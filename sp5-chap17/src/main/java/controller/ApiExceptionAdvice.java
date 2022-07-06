/*************************************************************************
 * 에러 처리 코드를 별도의 클래스로 분리
 *************************************************************************/

package controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import spring.MemberNotFoundException;

@RestControllerAdvice("controller")
public class ApiExceptionAdvice {
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleNoData() {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("no member"));
	}
}
