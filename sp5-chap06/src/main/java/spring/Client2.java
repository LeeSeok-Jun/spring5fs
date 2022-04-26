package spring;

// 객체 초기화, 소멸와 관련한 인터페이스를 상속받을 수 없는 경우
public class Client2 {
	private String host;
	
	public void setHost(String host) {
		this.host = host;
	}
	
	public void connect() {
		System.out.println("Client2.connect() 실행");
	}
	
	public void send() {
		System.out.println("Client2.sed() to " + host);
	}
	
	public void close() {
		System.out.println("Client2.close() 실행");
	}
}
