package top.itodouble.sso.config;

import top.itodouble.common.utils.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CorsFilter implements Filter {


	public void init(FilterConfig filterConfig) {
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, HEAD");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "access-control-allow-origin, authority, content-type, version-info, X-Requested-With, token, Sec-WebSocket-Protocol");
		if (!StringUtils.isNotNull(response.getHeader("Content-Type"))) {
			response.setHeader("Content-Type", "application/json;charset=UTF-8");
		}
		filterChain.doFilter(servletRequest, servletResponse);
	}

	public void destroy() {
	}
}
