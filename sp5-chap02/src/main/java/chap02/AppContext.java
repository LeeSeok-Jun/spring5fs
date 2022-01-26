/*
 * 스프링 설정 파일
 */

package chap02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @(Annotation)을 통해 해당 클래스를 스프링 설정 클래스로 지정
@Configuration
public class AppContext {
	
	@Bean
	public Greeter greeter() {
		Greeter g = new Greeter();
		
		g.setFormat("%s, 안녕하세요!");
		
		return g;
	}
}
