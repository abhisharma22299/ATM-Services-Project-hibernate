package comAtmServices.Atmservice;
import java.util.Scanner;


import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;

import java.util.*;
import org.hibernate.*;

public class AtmServices 
{
	
	public static void  loginPageServer() {
		Configuration configuration=new Configuration().configure().addAnnotatedClass(acoountHolderDetails.class);
	    SessionFactory sessionFactory=configuration.buildSessionFactory();
	    Session session=sessionFactory.openSession();
        Transaction transaction= session.beginTransaction();  
	    String password;
		acoountHolderDetails accountholder=new acoountHolderDetails();
 		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome to Login page");
		long balance;
		
		long depostecash;
		System.out.println("Enter your mobile number");
		long mobileNumber=sc.nextLong();
		accountholder=session.load(acoountHolderDetails.class, mobileNumber);
		long checkMobileNumber  =accountholder.getAccountHolderMobileNumber();
		String checkpassword=accountholder.getAccountHolderPassword();
		int input;
		long cashwidrwal;
		long accountbalance=accountholder.getAccountHolderAccountBalance();
		if(checkMobileNumber == mobileNumber) {
			
			System.out.println("Enter your password");
			password=sc.next();	
			if(checkpassword.equals(password)) {
				
				System.out.println("Welcome to the Atm services!");
				System.out.println();
				System.out.println("Enter the Number to Select the option");
				System.out.println("1 for Account Balance ");
				System.out.println("2 for Cash Widrwal");
				System.out.println("3 for Deposite");
				input = sc.nextInt();
				if(input==1)
				{
					System.out.println(accountholder);
				}
				
				else if(input==2) {
					System.out.println("Account Balance : "+ accountbalance);
					System.out.println("Enter the amount you want to Widrwal");
					cashwidrwal=sc.nextLong(); 
            if(cashwidrwal<=accountbalance) {
	
            System.out.println("Cash Widrwal process SuccessFull");
            
             balance=accountbalance-cashwidrwal;
            
            System.out.println("Account Balance : "+balance);
            
            accountholder.setAccountHolderAccountBalance(balance);
            
            }
            else {
            	
            	System.out.println("You Enter grater amount then in your Account Balance");
            	return;
            }
					
					
				}
				
				else if(input==3){
					
					//acoountHolderDetails p=new acoountHolderDetails();
					acoountHolderDetails p=session.find(acoountHolderDetails.class,checkMobileNumber);	
					System.out.println(p);
					System.out.println("Enter amount you want to deposite ");
					 depostecash=sc.nextLong() ;
					
					accountbalance = accountbalance + depostecash;
					
					p.setAccountHolderAccountBalance(accountbalance);
					 session.persist(p);	
					 transaction.commit();
					 System.out.println();
						System.out.println("You deposited "+depostecash + " Sucessfully" );
						System.out.println();
					 System.out.println("Account Balance : " + p.getAccountHolderAccountBalance());
					 System.out.println();
					 return;			
						
					
				}
				
				else {
					System.out.println("You enter the invalid input!");
				}
				
				
				
				
			}
			else {
				System.out.println("You Enter the wrong password");
				return;
			}
		}
		else {
			System.out.println("You Enter a Invalid number or Number not link with bank account!");
		return;
		}
		
		
	
		
		
		
		
		 
		
		  
    
      //session.save(accountholder);
        transaction.commit();
				
		
	}
	
	public static void newUserPageServer() {
	acoountHolderDetails accountholder= new acoountHolderDetails();	
	     
		String password,confirmpassword;
		Scanner sc=new Scanner(System.in);
		System.out.println("New User Details");
		System.out.println("Enter your Name ");
		String name =sc.nextLine();
		System.out.println("Enter your age");
		int age =sc.nextInt();
        System.out.println("Enter you mobile number ");
        long mobileNumber= sc.nextLong();
        Random random = new Random();
       long accountNumber=1000+random.nextLong(10000);
        System.out.println("Enter your Email ID");
        String emailId=sc.next();
System.out.println("Enter your password");
password=sc.next();
System.out.println("Enter your ReConfirmPassword");
confirmpassword=sc.next();
if(confirmpassword.equals(password)==true) {
	accountholder.setAccountHolderPassword(password);
 
	System.out.println("Your account created Sucessfully");
	System.out.println();
	
}
else {
	System.out.println("Miss Match of password and confirm password!");
	return;
}
accountholder.setAccountHolderName(name);
        accountholder.setAge(age);
        accountholder.setAccountHolderMobileNumber(mobileNumber);
        accountholder.setAccountHolderAccountNumber(accountNumber);
        accountholder.setAccountHolderEmailId(emailId);
        
        
        Configuration configuration=new Configuration().configure().addAnnotatedClass(acoountHolderDetails.class);
	    SessionFactory sessionFactory=configuration.buildSessionFactory();
	    Session session=sessionFactory.openSession();
	    Transaction transaction= session.beginTransaction();  
   
      session.save(accountholder);
        transaction.commit();
        
       
    	System.out.println(accountholder);
    	System.out.println();
       // accountholder= session.get(acoountHolderDetails.class,63860l);
   // System.out.println(accountholder);   
//	String checkpass=accountholder.getAccountHolderPassword();
//	System.out.println(checkpass);
	}
	
    public static void main( String[] args )
    {
    	Scanner scanner  =new Scanner(System.in);
    	System.out.println("Welcome to the Atm Services");
    	System.out.println();
      System.out.println("Enter 1 for login and 2 for New users!");
     int loginNumberEnter=scanner.nextInt();
      if(loginNumberEnter==1) {
    	loginPageServer();  
      }
      else if(loginNumberEnter==2) {
    	  newUserPageServer();
      }
      else {
    	  System.out.println("You Enter invalid  number!");
      }
      System.out.println("Thank You");
    }
}
