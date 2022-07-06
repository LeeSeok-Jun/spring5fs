package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();	// 로그 아웃 시 세션 종료
		return "redirect:/main";
	}
}
