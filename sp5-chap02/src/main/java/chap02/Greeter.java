/*
 * 콘솔에 간단한 메시지를 출력하는 자바 클래스
 */

package chap02;

public class Greeter {
	private String format;
	
	public String greet(String guest) {
		return String.format(format,  guest);
	}
	
	public void setFormat(String format) {
		this.format = format;
	}
}
