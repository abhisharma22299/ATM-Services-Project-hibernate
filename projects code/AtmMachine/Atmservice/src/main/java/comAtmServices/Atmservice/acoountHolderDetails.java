package comAtmServices.Atmservice;

//import javax.persistence.Column;
//import javax.persistence.Column.*;
//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class acoountHolderDetails {
    @Id
    private long accountHolderMobileNumber;
    private long accountHolderAccountNumber;
   	private String accountHolderName;
	private String accountHolderPassword;
    private String accountHolderEmailId;
    private long accountHolderAccountBalance=0;
    private int age;
    
	
	public long getAccountHolderMobileNumber() {
		return accountHolderMobileNumber;
	}


	public void setAccountHolderMobileNumber(long accountHolderMobileNumber) {
		this.accountHolderMobileNumber = accountHolderMobileNumber;
	}


	public long getAccountHolderAccountNumber() {
		return accountHolderAccountNumber;
	}


	public void setAccountHolderAccountNumber(long accountHolderAccountNumber) {
		this.accountHolderAccountNumber = accountHolderAccountNumber;
	}


	public String getAccountHolderName() {
		return accountHolderName;
	}


	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}


	public String getAccountHolderPassword() {
		return accountHolderPassword;
	}


	public void setAccountHolderPassword(String accountHolderPassword) {
		this.accountHolderPassword = accountHolderPassword;
	}


	public String getAccountHolderEmailId() {
		return accountHolderEmailId;
	}


	public void setAccountHolderEmailId(String accountHolderEmailId) {
		this.accountHolderEmailId = accountHolderEmailId;
	}


	public long getAccountHolderAccountBalance() {
		return accountHolderAccountBalance;
	}


	public void setAccountHolderAccountBalance(long accountHolderAccountBalance) {
		this.accountHolderAccountBalance = accountHolderAccountBalance;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	@Override
	public String toString() {
		
		return " \n Account Summary \n\n"+"Account Number  " +  accountHolderAccountNumber+ " \nAccount balance  "+
		accountHolderAccountBalance+
				"\nMobile Number    "+ accountHolderMobileNumber+" \n";
	}

}
