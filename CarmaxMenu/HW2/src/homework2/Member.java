package homework2;
import java.util.*;

public class Member {
	String id;
    String pw;
    String fn;
    String ln;
    String email;
    
    public Member() 
    {
    		id = null;
    		pw = null;
    		fn = null;
    		ln = null;
    		email = null;
    }
    public void setId(String v)
    {
    		id = v;
    }
    public void setPass(String _pw)
    { 
    		pw = _pw;
    }
    public void setFirstName(String _fn)
    {
    		fn = _fn;
    }
    public void setLastName(String _ln)
    {
    		ln = _ln;
    }
    public void setEmail(String em)
    {
    	 	email = em;
    }

    public String getId()
    {
    		return id;
    }
    public String getPass()
    {
    		return pw;
    }
    public String getFirstName()
    {
    		return fn;
    }
    public String getLastName()
    {
    		return ln;
    }
    public String getEmail()
    {
    	 	return email;
    }
    
}