package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.GetMapping;

import spring.DuplicateMemberException;
import spring.MemberRegisterService;
import spring.RegisterRequest; // command objects

import org.springframework.ui.Model;

@Controller
public class RegisterController {

		private MemberRegisterService memberRegisterService;
		
		public void setMemberRegisterService(
				MemberRegisterService memberRegisterService) {
			this.memberRegisterService = memberRegisterService;
		}
	
		@RequestMapping("/register/step1")
		public String handleStep1() {
			return "register/step1";	// 동일한 이름의 뷰 리턴
		}
		
		@PostMapping("/register/step2")
		public String handleStep2(
				@RequestParam(value = "agree", defaultValue = "false") Boolean agree, Model model) {
			if (!agree) {
				return "register/step1";
			}
			
			model.addAttribute("registerRequest", new RegisterRequest());
			return "register/step2";
		}
		
		// get 방식으로 step2에 요청이 들어간 경우 step1으로 리다이렉트
		@GetMapping("/register/step2")
		public String handleStep2Get() {
			return "redirect:/register/step1";
		}
		
		
		@PostMapping("/register/step3")
		public String handleStep3(RegisterRequest reqReq) {
			try {
				memberRegisterService.regist(reqReq);
				return "register/step3";
			} catch (DuplicateMemberException ex) {
				return "register/step2";
			}
		}
}
