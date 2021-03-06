import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
/*
sqlite3 students.db

drop table students;

create table students (
NAME           TEXT    PRIMARY KEY NOT NULL,
CORRECT            INT     NOT NULL,
RAISED            INT     NOT NULL
);

select count(*) from students;

insert into students(name,correct,raised) values ('Sridhar',0,0);
insert into students(name,correct,raised) values ('Monali',0,0);
*/

Class.forName("org.sqlite.JDBC");
BasicDataSource dataSource = new BasicDataSource();
dataSource.setDriverClassName("org.sqlite.JDBC");
dataSource.setUrl("jdbc:sqlite:students.db");
      

QueryRunner run = new QueryRunner(dataSource);

String newName = "name2";
try {
int inserts = run.update( "INSERT INTO students (name,raised,correct) VALUES ('" + newName + "',0,0)");
} catch (Exception e) {
	int updates = run.update( "UPDATE students SET raised=raised+1 WHERE name='" + newName + "'");
}

Map[] result = run.query("SELECT name,raised,correct FROM students", new MapListHandler());
//Map.Entry[] result = run.query("SELECT name,raised FROM students WHERE name=?", new MapHandler(), "Sridhar");
//println(result);
//println(result[0].getClass().getName());
//println(result[0].getKey());

for (Map row : result) {
	System.out.println(row.get("NAME"));
	System.out.println(row.get("RAISED"));
	System.out.println(row.get("CORRECT"));
}