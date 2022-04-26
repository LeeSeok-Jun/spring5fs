/*
 * 스프링을 이용한 객체 조립과 사용
 */

package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.beans.factory.annotation.Qualifier;

import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberRegisterService;
import spring.MemberPrinter;
import spring.MemberListPrinter;
import spring.MemberInfoPrinter;
import spring.VersionPrinter;
import spring.MemberSummaryPrinter;

@Configuration
public class AppCtx {
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		// memberDao()가 생성한 객체를 생성자를 통해 주입
		//return new MemberRegisterService(memberDao());
		
		// @Autowired 및 기본 생성자를 통한 자동 객체 주입
		return new MemberRegisterService();
	}
	
	@Bean
	public ChangePasswordService changePwdSvc() {
		ChangePasswordService pwdSvc = new ChangePasswordService();
		// @Autowired Annotation을 통해 자동으로 객체가 주입된다.
		//pwdSvc.setMemberDao(memberDao());
		return pwdSvc;
	}
	
	@Bean
	@Qualifier("printer")
	public MemberPrinter printer() {
		return new MemberPrinter();
	}
	
	@Bean
	@Qualifier("listPrinter")
	public MemberPrinter memberPrinter1() {
		return new MemberPrinter();
	}
	
	@Bean
	@Qualifier("summaryPrinter")
	public MemberSummaryPrinter memberPrinter2() {
		return new MemberSummaryPrinter();
	}
	
	@Bean
	public MemberListPrinter listPrinter() {
		// 여러개의 의존 주입 객체 생성
		return new MemberListPrinter(memberDao(), printer());
	}
	
	@Bean
	public MemberInfoPrinter infoPrinter() {
		// @Autowired를 통한 자동 객체 주입
		//MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		//infoPrinter.setMemberDao(memberDao());
		//infoPrinter.setPrinter(memberPrinter());
		
		//return infoPrinter;
		
		// @Autowired 및 기본 생성자를 통한 자동 객체 주입
		return new MemberInfoPrinter();
	}
	
	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(0);
		return versionPrinter;
	}
}
