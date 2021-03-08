package top.itodouble.sso.utils;

import javax.servlet.http.HttpServletRequest;

public class WebUtils {
	/**
	 * 用户的访问地址。
	 *
	 * @param request 当前请求。
	 * @return 客户端IP地址。
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ips = request.getHeader("x-forwarded-for");
		if (ips == null || ips.length() == 0 || "unknown".equalsIgnoreCase(ips)) {
			ips = request.getHeader("Proxy-Client-IP");
		}
		if (ips == null || ips.length() == 0 || "unknown".equalsIgnoreCase(ips)) {
			ips = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ips == null || ips.length() == 0 || "unknown".equalsIgnoreCase(ips)) {
			ips = request.getRemoteAddr();
		}

		String[] ipArray = ips.split(",");
		String clientIP = null;
		for (String ip : ipArray) {
			if (!("unknown".equalsIgnoreCase(ip))) {
				clientIP = ip;
				break;
			}
		}
		return clientIP;
	}
}
