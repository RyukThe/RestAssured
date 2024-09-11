package Different_way_to_create_request_body;

public class OPJO_Post_Request
{
	String name;
	String location;
	String phone;
	String course[];
	
	// to automatically create getters and setters select all variable then click on 
	// source then click on set getters and setters 
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String[] getCourse() {
		return course;
	}
	public void setCourse(String[] course) {
		this.course = course;
	}
	

}
