package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbConfig {
	
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost/spring5fs?characterEncoding=utf8");
		ds.setUsername("spring5");
		ds.setPassword("spring5s");
		ds.setInitialSize(2);	// 초기 커넥션 개수
		ds.setMaxActive(10);	// 최대 커넥션 개수
		
		ds.setTestWhileIdle(true); // 유휴 커넥션 검사
		ds.setMinEvictableIdleTimeMillis(1000*60*3);	// 최소 유효 시간 3분 설정
		ds.setTimeBetweenEvictionRunsMillis(1000*10); 	// 10초 주기로 검사
		
		return ds;
	}
}
