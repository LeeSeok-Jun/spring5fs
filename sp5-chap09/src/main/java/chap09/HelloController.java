package chap09;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// spring에서 컨트롤러로 사용할 클래스로 지정
@Controller
public class HelloController {
	// 메서드가 처리할 요청 경로 지정
	// GET 메서드에 대한 매핑 설정
	@GetMapping("/hello")
	public String hello(Model model,	// 컨트롤러의 처리 결과를 뷰에 전달할 때 사용
			@RequestParam(value = "name", required = false) String name) {	// HTTP 요청 파라미터의 값을 메서드의 파라미터로 전달
		model.addAttribute("greeting", "안녕하세요," + name);
		return "hello";	// 컨트롤러의 처리 결과를 보여줌
	}
}
