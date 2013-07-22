import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;


Class.forName("org.sqlite.JDBC");
BasicDataSource dataSource = new BasicDataSource();
dataSource.setDriverClassName("org.sqlite.JDBC");
dataSource.setUrl("jdbc:sqlite:students.db");
    
    