package security;

import java.io.Serializable;
import java.security.Principal;

public class PrincipalU implements Principal , Serializable{
	String name;
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	public PrincipalU(String name) {
		super();
		this.name = name;
	}

}
