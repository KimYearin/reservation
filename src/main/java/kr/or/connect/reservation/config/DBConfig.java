package kr.or.connect.reservation.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.config.TransactionManagementConfigUtils;

@Configuration
@EnableTransactionManagement
public class DBConfig extends TransactionManagementConfigUtils {
	private String driverClassName = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/book?serverTimezone=Asia/Seoul&useSSL=false";
	
	private String username = "bookuser";
	private String password = "book123!@#";
	@Bean
	public DataSource datasource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}
	
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return annotationDrivenTransactionManager();
	}
	
	@Bean
	public PlatformTransactionManager transactionManger() {
		return new DataSourceTransactionManager(datasource());
	}
	
}
