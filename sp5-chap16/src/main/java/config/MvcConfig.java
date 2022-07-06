package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;	// HandlerInterceptor 적용
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry; // 컨트롤러 구현 없이 요쳥 경로와 뷰 이름 연결

import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;

import org.springframework.validation.Validator;

// 모든 날짜 타입을 ISO-8601 형식으로 변환
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import controller.RegisterRequestValidator;

import interceptor.AuthCheckInterceptor;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer{
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/view/",".jsp");
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/main").setViewName("main");
	}
	
	// 글로벌 범위 validator 설정을 위해 인터페이스에 정의된 getValidator() 메소드 구현
	@Override
	public Validator getValidator() {
		return new RegisterRequestValidator();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authCheckInterceptor()).addPathPatterns("/edit/**");
	}
	
	@Override
	public void extendMessageConverters(
			List<HttpMessageConverter<?>> converters) {
		ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json().featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS).build();
		// 가장 먼저 이용해야 하기 때문에 0번 인덱스에 추가
		converters.add(0, new MappingJackson2HttpMessageConverter(objectMapper));
	}
	
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
		ms.setBasenames("message.label");	// message 패키지의 label로 부터 값을 가져옴
		ms.setDefaultEncoding("UTF-8");
		return ms;
	}
	
	@Bean
	public AuthCheckInterceptor authCheckInterceptor() {
		return new AuthCheckInterceptor();
	}
}
