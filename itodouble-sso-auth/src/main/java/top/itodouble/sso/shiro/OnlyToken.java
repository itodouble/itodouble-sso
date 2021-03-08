package top.itodouble.sso.shiro;
import org.apache.shiro.authc.AuthenticationToken;

public class OnlyToken implements AuthenticationToken{
	private String token;

	public OnlyToken(String token) {
		this.token = token;
	}

	@Override
	public Object getPrincipal() {
		return token;
	}

	@Override
	public Object getCredentials() {
		return token;
	}
}
