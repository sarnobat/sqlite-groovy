import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;


Class.forName("org.sqlite.JDBC");
BasicDataSource dataSource = new BasicDataSource();
dataSource.setDriverClassName("org.sqlite.JDBC");
dataSource.setUrl("jdbc:sqlite:students.db");
QueryRunner run = new QueryRunner(dataSource);
int inserts = run.update( "INSERT INTO students (name,raised,correct) VALUES ('name1',0,0)");
int updates = run.update( "UPDATE students SET raised=raised+1 WHERE name='name1'");