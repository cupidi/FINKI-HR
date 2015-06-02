package mk.ukim.finki.mp.crud;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import mk.ukim.finki.mp.crud.model.User;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sun.org.apache.xerces.internal.impl.validation.ValidationState;

 
public class UserValidator  implements Validator   {
   private static final String EMAIL_PATTERN ="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	@Override
	public boolean supports(Class clazz) {
		// TODO Auto-generated method stub
	 return User.class.equals(clazz);
	}
      public static boolean isValidDate(String  tekoven,String izberen)
      {
    	  
    	  String [] nizaTekoven=tekoven.split("/");
	         String []nizaIzberen=izberen.split("/");
	          int godinaTekoven=Integer.parseInt(nizaTekoven[2]);
	          int godinaIzberen=Integer.parseInt(nizaIzberen[2]);
	          int denTekoven=Integer.parseInt(nizaTekoven[1]);
	          int denIzberen=Integer.parseInt(nizaIzberen[1]);
	          int mesecTekoven=Integer.parseInt(nizaTekoven[0]);
	          int mesecIzberen=Integer.parseInt(nizaIzberen[0]);
	           
	       if(godinaIzberen <godinaTekoven  && (godinaTekoven-godinaIzberen >18)  &&  (godinaTekoven - godinaIzberen <66) )
	       {
	    	   return true;
	       }
	       return false;
    	   
      }
	@Override
	public void validate(Object object, Errors  errors) {
		  
		User user=(User)object;
		if(user.getName()==null|| user.getName().trim().length()==0)
		{
			 errors.rejectValue("name","name.required");
		}
		else
		{
			Pattern pattern=Pattern.compile("\\d");
			Pattern pattern1=Pattern.compile("\\W");
			Matcher matcher=pattern.matcher(user.getName());
			Matcher matcher1=pattern1.matcher(user.getName());
			if(matcher.find() ||  matcher1.find())
				errors.rejectValue("name","name.bad");
		}
		if(user.getSurname()==null || user.getSurname().trim().length()==0){
			errors.rejectValue("surname","surname.required");
		}
		  
		else
		{   
			 Pattern pattern=Pattern.compile("\\d");
			 Pattern pattern1=Pattern.compile("\\W");
			 Matcher matcher=pattern.matcher(user.getSurname());
			 Matcher matcher1=pattern1.matcher(user.getSurname());
			 if(matcher.find() || matcher1.find())
				 errors.rejectValue("surname","surname.bad");
		}
		 
	     
	    if(user.getPhone()==null || user.getPhone().trim().length()==0)
		{
			errors.rejectValue("phone","phone.required");
		}
	     
		else
		{
			Pattern pattern=Pattern.compile("\\D");
			Matcher matcher=pattern.matcher(user.getPhone());
			if(matcher.find())
				errors.rejectValue("phone","phone.bad");
		}
		if(user.getAddress()==null || user.getAddress().trim().length()==0)
		{
			errors.rejectValue("address","address.required");
		}
		if(user.getPassword()==null || user.getPassword().trim().length()==0)
		{
			errors.rejectValue("password","password.required");
		}
		if(user.getMail()==null || user.getMail().trim().length()==0)
		{
			errors.rejectValue("mail", "mail.required");
		}
		else
		{
			Pattern pattern=Pattern.compile(EMAIL_PATTERN);
			Matcher matcher=pattern.matcher(user.getMail());
			 if(!matcher.matches())
				 errors.rejectValue("mail","mail.bad");
		}
		 
		
		
	}
   

	  public static void main (String[]args)
	  {    
		   
	  }
  
}
