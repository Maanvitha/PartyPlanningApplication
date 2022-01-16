package Project.a051.model;
import java.util.Date;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
public class Registration {
	
	@NotNull(message="First name can not be empty")
	   @Pattern(regexp = "[A-Za-z]*",message="Firstname must be valid(Only Alphabets)")
		@Size(min=8,max=20,message="Firstname should be atleast 8 characters and max 20 chars")
	    private String firstName;
		 @NotNull(message = "Roles can not be empty")
		private String roles;
	    
	    @NotNull(message="Last Name can not be empty")
	    @Pattern(regexp = "[A-Za-z]*",message="Lastname must be valid(Only Alphabets)")
	    @Size(min=8,max=20,message="Lastname should be atleast 8 characters and max 20 chars")
	    private String lastName;
	    
	   @NotNull(message="Date of Birth can not be empty")
	   @Past(message="It should be in past and in MM/dd/yyyy format")
	   @DateTimeFormat(pattern = "yyyy-MM-dd")
	    private Date dob;
	    
	    @NotNull(message="Gender can not be empty")
	    private String gender;
	    
	    @NotNull(message = "Contact Number can not be empty")
	    //@Digits(integer=10, fraction=0, message = "The contact number must be 10 digits")
	    @Size(min=10,max=10,message = "The contact number must be 10 digits")
	    private String contactNum;
	    
	    @NotNull(message="userID can not be empty")
	    @Pattern(regexp = "[A-Za-z0-9]*")
	    private String userID;
	    
	   @NotNull(message = "Password can not be empty")
	   @Size(min = 6, max = 8, message = "1. Minimum 6 and Maximum 8 Character.\r\n" + 
	           "2. Atleast 1 number\r\n" + 
	           "3. Atleast 1 alphabet in capitals.\r\n")
	    private String password;
	    
	    @NotNull(message = "Secret Question answer can not be empty")
	    private String sq1;
	    @NotNull(message = "Secret Question answer can not be empty") 
	    private String sq2;
	    @NotNull(message = "Secret Question answer can not be empty")
	    private String sq3;
	    public String getSq1() {
			return sq1;
		}
		public void setSq1(String sq1 ) {
			this.sq1 = sq1;
		}
		public String getSq2() {
			return sq2;
		}
		public void setSq2(String sq2) {
			this.sq2 = sq2;
		}
		public String getSq3() {
			return sq3;
		}
		public void setSq3(String sq3) {
			this.sq3 = sq3;
		}
		public String getFirstName() {
	           return firstName;
	    }
	    public void setFirstName(String firstName) {
	           this.firstName = firstName;
	    }
	    public String getLastName() {
	           return lastName;
	    }
	    public void setLastName(String lastName) {
	           this.lastName = lastName;
	    }
	    public Date getDob() {
	           return dob;
	    }
	    public void setDob(Date dob) {
	           this.dob = dob;
	    }
	    public String getGender() {
	           return gender;
	    }
	    public void setGender(String gender) {
	           this.gender = gender;
	    }
	    public String getContactNum() {
	           return contactNum;
	    }
	    public void setContactNum(String contactNum) {
	           this.contactNum = contactNum;
	    }
	    public String getUserID() {
	           return userID;
	    }
	    public void setUserID(String userID) {
	           this.userID = userID;
	    }
	    public String getPassword() {
	           return password;
	    }
	    public void setPassword(String password) {
	           this.password = password;
	    }
		public String getRoles() {
			return roles;
		}
		public void setRoles(String roles) {
			this.roles = roles;
			//System.out.println(this.roles);
		}
	    


}
