/*
 * 회원 중복 검사
 */

package spring;

public class DuplicateMemberException extends RuntimeException {
	public DuplicateMemberException(String message) {
		super(message);
	}
}
