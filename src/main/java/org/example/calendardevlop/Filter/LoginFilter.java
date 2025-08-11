package org.example.calendardevlop.Filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.util.PatternMatchUtils;

import java.io.IOException;

public class LoginFilter implements Filter {

    private static final String[] WHITE_LIST = {"/", "/users/login","/users/signup"};
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest  = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        String requestURI = httpRequest.getRequestURI();

        //화이트리스트가 아니다 -> 검증이 필요하다!!
        if(isNotWhiteList(requestURI)){
            HttpSession httpSession = httpRequest.getSession(false);
            // 로그인된 상태가 아니거나 USER_ID가 없거나
            if(httpSession ==null || httpSession.getAttribute("USER_ID") == null){
                httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "로그인 해주세요.");
                return;
            }
        }
        filterChain.doFilter(httpRequest,httpResponse);
    }

    private boolean isNotWhiteList(String requestURI){
        return !PatternMatchUtils.simpleMatch(WHITE_LIST, requestURI);
    }
}
