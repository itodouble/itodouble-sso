package top.itodouble.sso.config;

import top.itodouble.sso.constant.SysConstant;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Order(1)
@Component
@WebFilter(filterName = "webSocketFilter", urlPatterns = {"/webSocket/*", "/ws/*"})
public class WebSocketFilter implements Filter {
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		request.setAttribute(SysConstant.TOKEN_NAME, request.getHeader("Sec-WebSocket-Protocol"));
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String token = ((HttpServletRequest) servletRequest).getHeader("Sec-WebSocket-Protocol");
		response.setHeader("Sec-WebSocket-Protocol", token);
		filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void destroy() {

	}
}
