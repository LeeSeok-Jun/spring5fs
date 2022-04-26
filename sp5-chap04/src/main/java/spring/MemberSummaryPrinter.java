package spring;

import org.springframework.beans.factory.annotation.Qualifier;

public class MemberSummaryPrinter extends MemberPrinter {
	private MemberDao memberDao;
	private MemberPrinter printer;
	
	
	@Override
	@Qualifier("summaryPrinter")
	public void print(Member member) {
		System.out.printf("회원 정보 = %s / 이름 = %s", member.getEmail(), member.getName());
	}
}
