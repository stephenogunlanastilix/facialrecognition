package bankingsystem;
//Creating the public class get info
public class Getinfo {//Starts class getinfo
    
//DEclaring instance variables with the"private" access modifier
    private int id;//private keyword identifies the field id of type integer as a private member 
	private String firstname;//private keyword identifies the field firstname of type String as a private member
	private String lastname;//private keyword identifies the field  lastname of type String as a private member
    private String username;//private keyword identifies the field username of type String as a private member
    private String password;//private keyword identifies the field password of type String as a private member
    private String memberid;//private keyword identifies the field memberid of type String as a private member
    private String acctbalance;//private keyword identifies the field accountbalance of type String as a private member
   //	This is a 7 argument constructor 
    public Getinfo(int id ,String firstname, String lastname, String username, String password , String memberid , String  acctbalance) {
		super();
		this.firstname = firstname;//using the keyword this to refer firstname
		this.lastname = lastname;//using the keyword this to refer lastname
		this.username = username;//using the keyword this to refer username
		this.password = password;//using the keyword this to refer password
		this.memberid = memberid;//using the keyword this to refer  memberid
		this.acctbalance = acctbalance;//using the keyword this to refer acctbalance
	}
    //Accessors and Mutators
    public Getinfo() {//constructor
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the id
	 */
	public String getacctbalance() {//Getting and returning the acctbalance
		return acctbalance;
	}
	/**
	 * @param acctbalance 
	 * @param id the id to set
	 */
	public void setacctbalance(String acctbalance) {//Setter for acctbalance
		this.acctbalance = acctbalance;
	}
	/**
	 * @return the id
	 */
	public String getmemberid() {//Getting and returning memberid
		return memberid;
	}
	/**
	 * @param id the id to set
	 */
	public void setmemberid(String memberid) {
		this.memberid = memberid;//Setter for memberid
	}
	/**
	 * @return the id
	 */
	public int getid() {//Gets and returns id 
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setid(int id) {//Setter for id of user
		this.id = id;
	}
    /**
	 * @return the firstname
	 */
	public String getFirstname() {//Gets and returns the user firstname
		return firstname;
	}
	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {//Setter for the Firstname
		this.firstname = firstname;
	}
	/**
	 * @return the lastname
	 */
	public String getLastname() {//Gets and returns the lastname of the user
		return lastname;
	}
	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {//Setter for user lastname
		this.lastname = lastname;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {//Gets and returns the Username 
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {//Setter for user Username
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {//Gets and returns the Password of the user
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {//Setter for Password
		this.password = password;
	}

}//Ends class Getinfo
