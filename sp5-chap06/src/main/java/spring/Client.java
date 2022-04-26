package spring;

import org.springframework.beans.factory.DisposableBean;	// 객체 초기화 인터페이스
import org.springframework.beans.factory.InitializingBean;	// 객체 생성 인터페이스

public class Client implements DisposableBean, InitializingBean{
	private String host;
	
	public void setHost(String host) {
		this.host = host;
	}
	
	// 객체 초기화 인터페이스 메소드 재정의
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Client.afterProperties() 실행");
	}
	
	
	public void send() {
		System.out.println("Client.send() to " + host);
	}
	
	// 객체 소멸 인터페이스 메소드 재정의
	@Override
	public void destroy() throws Exception {
		System.out.println("Client.destory() 실행");
	}
}
