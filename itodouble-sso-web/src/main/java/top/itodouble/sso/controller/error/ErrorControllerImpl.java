package top.itodouble.sso.controller.error;/*
package top.itodouble.sso.controller.error;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ErrorControllerImpl implements ErrorController {
	@RequestMapping("/error")
	public void handleError(HttpServletRequest request) throws Throwable {
		if (request.getAttribute("javax.servlet.error.exception") != null) {
			Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
			throw exception;
		}
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}
}
*/
