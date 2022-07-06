// 로그인 요청 처리 컨트롤러

package controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CookieValue;	// 요청 매핑 애노테이션의 Cookie 타입의 타입 파라미터에 작용

import spring.AuthInfo;
import spring.AuthService;
import spring.WrongIdPasswordException;

import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/login")
public class LoginController {
	private AuthService authService;
	
	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}
	
	// 쿠키를 통해 로그인 시 이메일을 자동으로 불러옴(쿠키 활용 구현)
	@GetMapping
	public String form(LoginCommand loginCommand, @CookieValue(value="REMEMBER", required=false) Cookie rCookie) {
		if (rCookie != null) {
			loginCommand.setEmail(rCookie.getValue());
			loginCommand.setRememberEmail(true);
		}
		
		return "login/loginForm";
	}
	
	// HttpServletResponse 객체를 통한 쿠키 생성
	@PostMapping
	public String submit(LoginCommand loginCommand, Errors errors, HttpSession session, HttpServletResponse response) {
		new LoginCommandValidator().validate(loginCommand, errors);
		
		if(errors.hasErrors()) {
			return "login/loginForm";
		}
		
		try {
			AuthInfo authInfo = authService.authenticate(loginCommand.getEmail(), loginCommand.getPassword());
			
			// to-do : 세션에 authinfo 저장
			session.setAttribute("authInfo", authInfo);
			
			// 쿠키 생성
			Cookie rememberCookie = new Cookie("REMEMBER", loginCommand.getEmail());
			
			rememberCookie.setPath("/");
			// 이메일 기억하기 여부에 따라 쿠키 보존 시간 설정
			if (loginCommand.isRememberEmail()) {
				rememberCookie.setMaxAge(60*60*24*30);	// 최대 쿠키 보존 시간(단위 : 초)
			} else {
				rememberCookie.setMaxAge(0);
			}
			response.addCookie(rememberCookie);	// 쿠키 저장
			
			return "login/loginSuccess";
		} catch (WrongIdPasswordException e) {
			errors.reject("idPasswordNotMatching");
			return "login/loginForm";
		}
	}
}
