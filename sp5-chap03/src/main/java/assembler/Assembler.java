/*
 * 의존 주입을 위한 클래스
 * 객체를 생성하고 주입해주는 역할 수행
 */

package assembler;

import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberRegisterService;

public class Assembler {
	private MemberDao memberDao;
	private MemberRegisterService regSvc;
	private ChangePasswordService pwdSvc;
	
	public Assembler() {
		// 의존 객체 생성
		memberDao = new MemberDao();
		
		// 의존 주입 : 생성자를 이용한 방법
		regSvc = new MemberRegisterService(memberDao);
		
		// 의존 주입 : setter를 이용한 방법
		pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberDao(memberDao);
		
	}
	
	public MemberDao getMemberDao() {
		return memberDao;
	}
	
	public MemberRegisterService getMemberRegisterService() {
		return regSvc;
	}
	
	public ChangePasswordService getChangePasswordService() {
		return pwdSvc;
	}
}
