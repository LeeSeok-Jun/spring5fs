package controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import java.io.*;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// JSON 형식으로 전송된 요청 데이터를 커맨드 객체로 전달받음
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
// 응답결과를 모두 JSON으로 반환
import org.springframework.http.ResponseEntity;

import spring.Member;
import spring.MemberDao;
import spring.MemberNotFoundException;
import spring.MemberRegisterService;
import spring.DuplicateMemberException;
import spring.RegisterRequest;

@RestController
public class RestMemberController {
	private MemberDao memberDao;
	private MemberRegisterService registerService;
	
	@GetMapping("/api/members")
	public List<Member> members() {
		return memberDao.selectAll();
	}
	
	/*
	public Member member(@PathVariable Long id,
			HttpServletResponse response) throws IOException {
		
		Member member = memberDao.selectById(id);
		
		if(member == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		
		return member;
	}*/
	@GetMapping("/api/members/{id}")
	public ResponseEntity<Object> member(@PathVariable Long id,
			HttpServletResponse response) throws IOException {
		
		Member member = memberDao.selectById(id);
		
		if(member == null) {
			// 404 상태 응답 코드 반환
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("no member"));
		}
		// 200 상태 응답 코드 반환
		return ResponseEntity.status(HttpStatus.OK).body(member);
	}
	
	
	@PostMapping("/api/members")
	public void newMember(
			@RequestBody @Valid RegisterRequest regReq,
			HttpServletResponse response) throws IOException {
		
		try {
			Long newMemberId = registerService.regist(regReq);
			response.setHeader("Location", "/api/members/" + newMemberId);
			response.setStatus(HttpServletResponse.SC_CREATED);
		} catch(DuplicateMemberException dupEx) {
			response.sendError(HttpServletResponse.SC_CONFLICT);
		}
	}
	
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void setRegisterService(MemberRegisterService registerService) {
		this.registerService = registerService;
	}
}
