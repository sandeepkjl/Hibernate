package eventmgr.domain;




public class Location {
	
	private Integer id;
	private String name;
	private String address;
	
	public Location() {
		super();}

	public Location(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	
	
}
