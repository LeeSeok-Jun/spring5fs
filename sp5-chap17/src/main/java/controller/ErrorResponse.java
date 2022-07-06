/************************************************************
 * 응답 결과가 정상/비정상인 경우 모두 JSON 응답을 전송하는 방법을 담은 클래스
 ************************************************************/

package controller;

public class ErrorResponse {
	private String message;
	
	public ErrorResponse(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
