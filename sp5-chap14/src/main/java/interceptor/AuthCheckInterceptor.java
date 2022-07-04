// httpsession 존재 여부에 따라 인터셉터 실행

package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class AuthCheckInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(
			HttpServletRequest request,
			HttpServletResponse response,
			Object Handler) throws Exception {
		HttpSession session = request.getSession(false);
		
		if (session != null) {
			Object authInfo = session.getAttribute("authInfo");
			
			if(authInfo != null) {
				return true;
			}
		}
		
		response.sendRedirect(request.getContextPath() + "/login");
		return false;
	}
			
}
