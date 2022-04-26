package spring;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

//spring이 직접 클래스를 검색해서 빈으로 등록하는 기능
@Component
public class ChangePasswordService {

	@Autowired
	private MemberDao memberDao;

	public void changePassword(String email, String oldPwd, String newPwd) {
		Member member = memberDao.selectByEmail(email);
		if (member == null)
			throw new MemberNotFoundException();

		member.changePassword(oldPwd, newPwd);

		memberDao.update(member);
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

}
