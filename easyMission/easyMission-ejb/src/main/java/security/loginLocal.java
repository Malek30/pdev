package security;

import java.util.Map;

import javax.ejb.Local;
import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;

@Local
public interface loginLocal {
	public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState,
			Map<String, ?> options);
	public boolean login() throws LoginException;
	public boolean commit() throws LoginException;
	public boolean abort() throws LoginException;
	public boolean logout() throws LoginException;

}
