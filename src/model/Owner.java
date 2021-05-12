package model;

public class Owner extends Person{
	
	private String phone;
	private String adress;

	public Owner (String idNumber, String name, String lastName,String phone,String adress){
		super(idNumber,name,lastName);
		this.phone=phone;
		this.adress=adress;
	}

	public String getPhone(){
	return phone;
	}

	public String getAdress(){
	return adress;
	}

	public void setPhone(String phone){
		this.phone=phone;
	}

	public void setAdress(String adress){
		this.adress=adress;
	}
		
		
}
