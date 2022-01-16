package Project.a051.controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import Project.a051.model.ChooseVenue;
import Project.a051.model.Login;
import Project.a051.model.Registration;
import Project.a051.model.Validation;
@Controller
public class Projectcontroller {
	@Autowired
	DBClass dbclass = new DBClass();


	@RequestMapping(value = "/HomePage", method = RequestMethod.GET)
	public String homePage(@ModelAttribute("login") Login login) {
		return "homePage";
	}
	
	@RequestMapping(value = "/RegistrationPage", method = RequestMethod.GET)
	public String registrationPage(@ModelAttribute("registration") Registration registration) {
		return "registration";
	}
	
	
	@RequestMapping(value = "/ResultPage", method = RequestMethod.POST)
	public String resultPage(@Valid @ModelAttribute("registration") Registration registration,BindingResult error,ModelMap m, @RequestParam String userID) {
		
		if(error.hasErrors())
		{
			m.put("message","");
			return "registration";
		}
		else
		{
			if(dbclass.checkuserid(userID)==0)
			{
			dbclass.setValues(registration);
			m.put("message","");
			return "result";
		     }
			m.put("message","UserId already Exists");
			return "registration";
		}
   }

	@RequestMapping(value = "/adminresult", method = RequestMethod.POST)
    public String adminresultPage(@ModelAttribute("login") Login login,ModelMap m )  {
        
        int flag = dbclass.checkadmin(login);
        if(flag==1)
            return "AdminAfterLogin";
        else {
			
			m.put("message","Incorrect Login credentials");
        return "AdminSignin";}
   }



	
	@RequestMapping(value = "/userresult", method = RequestMethod.POST)
	public String userresultPage(@ModelAttribute("login") Login login,ModelMap m )  {
	    
		int flag = dbclass.check(login); 
		if(flag==1)
		{     
			 return "UserAfterLogin";
		}
		else {
			
			m.put("message","Incorrect Login credentials");
		return "UserSignin";
		}
   }
	@RequestMapping(value = "/UserAfterLogin", method = RequestMethod.GET)
	public String userafterloginpage() {
	return "UserAfterLogin";
   }
	
	@RequestMapping(value = "/AdminSigninPage", method = RequestMethod.GET)
	public String adminsigninPage() {
	return "AdminSignin";
   }
	
	
	@RequestMapping(value = "/UserSigninPage", method = RequestMethod.GET)
	public String usersigninPage() {
	return "UserSignin";
   }
	
	@ModelAttribute("gender")
	public List<String> Gender() {

		List<String> list = new ArrayList<String>();
		list.add("Male");
		list.add("Female");
		return list;
	}
	String place;
	
	@ModelAttribute("venue")
	public ArrayList<String> venueDetails() {
		ArrayList<String> venue=dbclass.retrieveVenueDetails(place);
		//System.out.println(venue.get(0));
		return venue;
	}
	
	
	
	
	
	@ModelAttribute("place")
	public ArrayList<String> placeDetails() {
		ArrayList<String> place=dbclass.retrievePlaceDetails();
		//System.out.println(place.get(1));
		return place;
	}
	
	/*
	@ModelAttribute("status")
	public ArrayList<String> status() {
		ArrayList<String> stat=dbclass.checkBookingStatus();
		System.out.println(stat.size());
		return stat;
	
	}
	*/
	
	@RequestMapping(value = "/ForgetPasswordresult", method = RequestMethod.POST)
    public String forgetpasswordresult(@ModelAttribute("validation") Validation validation) {
          
               int res=dbclass.checkDB(validation);
               if(res==1)
               {
                    return "ResetPassword";
               }
               else
               {
                    return "ForgetPassword";
               }

  }
	
	
	@RequestMapping(value = "/feedback1", method = RequestMethod.POST)
    public String feedback(ModelMap m,@RequestParam String feedback,@RequestParam int booking_id) {
          
                dbclass.storeFeedback(feedback,booking_id);
                dbclass.checkBookingStatus();
               
                return "feedback"; 

  }
	
	@RequestMapping(value = "/diplayDetails", method = RequestMethod.POST)
    public String forgetuserid(ModelMap m,@RequestParam String num,@RequestParam String sq1,@RequestParam String sq2,@RequestParam String sq3) {
          
               String res=dbclass.checkDBU(num,sq1,sq2,sq3);
               if(res.equals("0"))
               {
                    return "forgetUserId";
               }
               else
               {
            	    m.put("user_id",res);
                    return "displayDetails";
               }

  }
	
	
	@RequestMapping(value = "/ForgetPasswordPage", method = RequestMethod.GET)
    public String forgetpasswordpage() {
		return "ForgetPassword";
	
	}
	
	@RequestMapping(value = "/ForgetUserid", method = RequestMethod.GET)
    public String forgetuserId() {
		return "forgetUserId";
	
	}
	
	@RequestMapping(value = "/result1", method = RequestMethod.GET)
    public String result() {
		return "result1";
	
	}
	
	@RequestMapping(value = "/ResetSuccessful", method = RequestMethod.POST)
    public String resetpasswordpage(ModelMap m,@RequestParam String newPassword,@RequestParam String confirmPassword,@RequestParam String userID) {
		if(newPassword.equals(confirmPassword))
		{
			dbclass.storeNewPwd(newPassword,userID);
			return "resetdone";
		}
		else
		{
			return "ResetPassword";
		}
	
	}
		
	@RequestMapping(value = "/ChooseVenue" , method  = RequestMethod.POST)
	public String bookVenue(ModelMap f, @RequestParam String place)
	{
		this.place=place;
		System.out.println("place "+ this.place);
		return "ChooseVenue";
	} 
	
	
	@RequestMapping(value = "/ChoosePlace" , method  = RequestMethod.GET)
	public String chooseplace()
	{
		return "ChoosePlace";
	} 
	
	
	@RequestMapping(value = "/UpdateVenuedetails" , method  = RequestMethod.GET)
	public String UpdateVenu()
	{
		return "UpdateVenue";
	} 
	
	@RequestMapping(value = "/feedback" , method  = RequestMethod.GET)
	public String feedback()
	{
		return "feedback";
	} 
	@RequestMapping(value = "/selectTemplates" , method  = RequestMethod.GET)
	public String templates()
	{
		return "selectTemplates";
	}

	//from user end
	@RequestMapping(value = "/Choose", method = RequestMethod.POST)
    public String venuedetails(ModelMap f, @RequestParam String venue, @RequestParam String date) {
		String ss[]=venue.split(" ");
		//System.out.println( "venue id is "+ ss[0]+" "+date);
		int result=dbclass.checkVenueAvailability(Integer.parseInt(ss[0]), date);
		if(result==1)
		{
				f.put("message","Venue booked and waiting for admin approval");
				return "ChooseVenue";
				
		}
		return "ChooseVenue";
	
	}
	
	
    @RequestMapping(value = "/UpdateProfile", method = RequestMethod.GET)
    public String updateprofile(ModelMap model) {
          Registration register=dbclass.update();
          model.put("firstName", register.getFirstName());
          model.put("lastName", register.getLastName());
          //model.put("dob", register.getFirstName());
          model.put("gender", register.getGender());
          model.put("contactNum", register.getContactNum());
          model.put("userID", register.getUserID());
          model.put("password", register.getPassword());
          model.put("sq1", register.getSq1());
          model.put("sq2", register.getSq2());
          model.put("sq3", register.getSq3());
          model.put("role",register.getRoles());
          return "updateprofile";
    }
    
    @RequestMapping(value = "/edituser", method = RequestMethod.GET)
    public String edituser(@ModelAttribute("registration") Registration registration,ModelMap model) {
          Registration register=dbclass.update();
          model.put("firstName", register.getFirstName());
          model.put("lastName", register.getLastName());
          //model.put("dob", register.getFirstName());
          model.put("gender1", register.getGender());
          model.put("contactNum", register.getContactNum());
          model.put("userID", register.getUserID());
          model.put("password", register.getPassword());
          model.put("sq1", register.getSq1());
          model.put("sq2", register.getSq2());
          model.put("sq3", register.getSq3());
          model.put("role",register.getRoles());

          return "edituser";
    }
    
    @RequestMapping(value = "/UserAfterLogin", method = RequestMethod.POST)
    public String userhome(@Valid @ModelAttribute("registration") Registration registration,ModelMap m,BindingResult error) {
          //System.out.println("in userhome");
          if(error.hasErrors())
               return "edituser";
          else
          {
               dbclass.updaterow(registration);
               m.put("mess", "Your profile updated sucessfully");
               return "edituser";
          }
    }
    
    //from admin
    @RequestMapping(value = "/UpdateVenuedetails_1", method = RequestMethod.POST)
    public String updatevenuedetail(ModelMap f, @RequestParam String venue_id, @RequestParam String venue_name, @RequestParam String venue_location ,@RequestParam String venue_price ) {
		
		

    	dbclass.addVenues(Integer.parseInt(venue_id), venue_name, venue_location, Integer.parseInt(venue_price));
    	
	//	if(result==1)
	//	{
	//		return "result";
	//	}
		return "UpdateVenue";
	
	}
    
    
    @RequestMapping(value = "/addContact", method = RequestMethod.GET)
    public String contactlis() {

          return "addcontacts";
    }
    
    @RequestMapping(value = "/adminAfterLogin", method = RequestMethod.GET)
    public String aal() {

          return "AdminAfterLogin";
    }

  
    //to add contacts into data base
    @RequestMapping(value = "/addContacts", method = RequestMethod.POST)
        public String addContacts(ModelMap f, @RequestParam String email) {
          
    	if(email.equals(""))
    	{
    		return "addcontacts";
    	}
        dbclass.addContacts(email);
        return "addcontacts";
    }
    
    
    
    @RequestMapping(value = "/generate_report", method = RequestMethod.GET)
    public String generate_report() {

    	  dbclass.report();
    	 
    	  return "result1";
    }

    
    
    
    @RequestMapping(value = "/UploadTemplates", method = RequestMethod.GET)
    public String UploadTemplates() {

    	
          return "UploadTemplates";
    }
    
    @RequestMapping(value = "/CheckAcknowledgement", method = RequestMethod.GET)
    
    public String checkack() {

          return "checkAcknowledgement";
    }
    
    @ModelAttribute("ack")
	public ArrayList<String> ack() {
		ArrayList<String> ackw=dbclass.retrieveAck();
		//System.out.println(venue.get(0));
		return ackw;
	}
    
    @ModelAttribute("ackd")
   	public ArrayList<String> ackd() {
   		ArrayList<String> ackwd=dbclass.retrieveAckd();
   		//System.out.println(venue.get(0));
   		return ackwd;
   	}
    
    @RequestMapping(value = "/UploadTemplates1", method = RequestMethod.POST)
    public String uploadTemplates(ModelMap f , @RequestParam String image,@RequestParam String occasion) {
          System.out.println("inside upload template method");
          

          int flag = dbclass.addTemplates(image,occasion);
          System.out.println("inside upload template 2");
          if (flag == 0)
               return "UploadTemplates";

          return "result1";

    }
    
    @RequestMapping(value = "/help", method = RequestMethod.GET)
    public String help() {

          return "help";
    }

    @RequestMapping(value = "/ackApproval", method = RequestMethod.GET)
    public String ackapproval() {

          return "ackApproval";
    }

    @RequestMapping(value = "/ackDisapproval", method = RequestMethod.GET)
    public String ackdis() {

          return "ackDisapproval";
    }

    @RequestMapping(value = "/ackApproval", method = RequestMethod.POST)
    public String ackapp(ModelMap f, @RequestParam String approval) {
    	
	String ss[]=approval.split(" ");
	
      dbclass.addApproved(Integer.parseInt(ss[0]));
    return "ackApproval";
}

    @RequestMapping(value = "/ackDisapproval", method = RequestMethod.POST)
    public String ackdisapp(ModelMap f, @RequestParam String disapproval) {
    	
	String ss[]=disapproval.split(" ");
	
      dbclass.DisApproved(Integer.parseInt(ss[0]));
    return "ackApproval";
}

    @RequestMapping(value = "/UpdateContacts", method = RequestMethod.GET)
    public String updatecontacts(ModelMap model) {
         
          return "UpdateContacts";
    }
    
    
    @ModelAttribute("contacts")
	public ArrayList<String> contactDetails() {
		ArrayList<String> contact=dbclass.updateContacts();
		
		return contact;
	}
    
    String previous=null;
    @RequestMapping(value = "/editContacts", method = RequestMethod.POST)
    public String editcontacts(ModelMap m,@RequestParam String contact) {
         
        previous=contact;  
    	m.put("cont",contact);
          return "editContact";
    }
    
    @RequestMapping(value = "/editContact1", method = RequestMethod.POST)
    public String editcont(ModelMap m,@RequestParam String cont) {
         
          dbclass.editContact(cont,previous);
          return "result1";
    }
	
}
