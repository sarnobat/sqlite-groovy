import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
/*

sqlite3 students.db

create table students (
   NAME           TEXT    NOT NULL,
   CORRECT            INT     NOT NULL,
   RAISED            INT     NOT NULL
);

select count(*) from students;

insert into students(name,correct,raised) values ('Sridhar',0,0);
insert into students(name,correct,raised) values ('Monali',0,0);
*/

Class.forName("org.sqlite.JDBC");

//Connection connection = null;
//connection = DriverManager.getConnection("jdbc:sqlite:students.db");


BasicDataSource dataSource = new BasicDataSource();
dataSource.setDriverClassName("org.sqlite.JDBC");
dataSource.setUrl("jdbc:sqlite:students.db");
      

// Create a QueryRunner that will use connections from
// the given DataSource
QueryRunner run = new QueryRunner(dataSource);

// Execute the query and get the results back from the handler
Map[] result = run.query("SELECT name,raised,correct FROM students", new MapListHandler());
//Map.Entry[] result = run.query("SELECT name,raised FROM students WHERE name=?", new MapHandler(), "Sridhar");
println(result);
println(result[0].getClass().getName());
//println(result[0].getKey());

for (Map row : result) {
	System.out.println(row.get("NAME"));
	System.out.println(row.get("RAISED"));
	System.out.println(row.get("CORRECT"));
}