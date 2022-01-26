/*
 * 스프링이 제공하는 클래스를 이용해서 AppContext를 읽어와 사용
 */

package chap02;

// Bean 객체 생성 및 관리를 위한 클래스 import
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		// AppContext 클래스를 생성자 매개변수로 전달하여 해당 클래스에 있는 Bean 객체의 설정 정보를 읽어온다.
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
		
		// 매개변수 1 : Bean 객체의 이름
		// 매개변수 2 : Bean 객체의 타입
		Greeter g = ctx.getBean("greeter", Greeter.class);
		String msg = g.greet("스프링");
		
		System.out.println(msg);
		
		ctx.close();
	}

}
