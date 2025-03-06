package hello.login.web.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

@Slf4j
public class LogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("log filter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("log filter doFilter");

        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        String requestURI = httpRequest.getRequestURI();

        String uuid = UUID.randomUUID().toString(); //요청 구분
        try {
            log.info("REQUEST [{}][{}]", uuid, requestURI);
            filterChain.doFilter(servletRequest, servletResponse); //다음 필터 호출, 없으면 서블릿 호출
        } catch (Exception e) {
            throw e;
        } finally {
            log.info("RESPONSE [{}][{}]", uuid, requestURI); //컨트롤러까지 끝내고 호출
        }
    }

    @Override
    public void destroy() {
        log.info("log filter destroy");
    }
}
