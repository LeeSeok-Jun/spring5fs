package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import spring.RegisterRequest;

public class RegisterRequestValidator implements Validator {
	private static final String emailRegExp =
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
	
	private Pattern pattern;
	
	public RegisterRequestValidator() {
		pattern = Pattern.compile(emailRegExp);
	}
	
	@Override
	// clazz로 전달받은 객체가 RegisterRequest 클래스로 타입 변환이 가능한지 확인
	public boolean supports(Class<?> clazz) {
		return RegisterRequest.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		// 실제 검사할 객체 타입으로 변환
		RegisterRequest regReq = (RegisterRequest) target;
		
		// 이메일 유효성 검사
		// 이메일이 공란인 경우
		if (regReq.getEmail() == null || regReq.getEmail().trim().isEmpty()) {
			errors.rejectValue("email", "required");
		} else {
			// 이메일 정규 표현식 검사
			Matcher matcher = pattern.matcher(regReq.getEmail());
			if (!matcher.matches()) {
				errors.rejectValue("email", "bad");
			}
		}
		
		// 다른 요소(이름, 비밀번호, 비밀번호 확인)에 대한 유효성 검사
		// errors 객체의 getFieldValue("name") 메서드를 실행 후 커맨드 객체의 name 프로퍼티 값을 구함
		// 따라서 커맨드 객체(RegisterRequest)를 직접 전달하지 않아도 값 검증을 할 수 있음
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
		ValidationUtils.rejectIfEmpty(errors, "password", "required");
		ValidationUtils.rejectIfEmpty(errors, "confirmPassword", "required");
		
		if (!regReq.getPassword().isEmpty()) {
			if (!regReq.isPasswordEqualToConfirmPassword()) {
				errors.rejectValue("confirmPassword", "nomatch");
			}
		}
	}
}
