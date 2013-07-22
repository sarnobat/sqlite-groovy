import org.apache.commons.dbcp.BasicDataSource;

/*

sqlite3 students.db

create table students (
   NAME           TEXT    NOT NULL,
   CORRECT            INT     NOT NULL,
   RAISED            INT     NOT NULL
);

select count(*) from students;

insert into students(name,correct,raised) values ('Sridhar',0,0);
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
Object[] result = run.query("SELECT name,raised FROM Person WHERE name=?", new MapHandler(), "Sridhar");