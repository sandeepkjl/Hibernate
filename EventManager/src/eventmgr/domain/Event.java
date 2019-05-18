package eventmgr.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Event {
	
	private Integer Id;
	private String name;
	private Date startDate;
	private Location location;
	private Set<Speaker> speakers;
	
	public Event() {
		super();
	}

	public Event(String name, Date startDate, Location location) {
		super();
		this.name = name;
		this.startDate = startDate;
		this.location = location;
	}

	
	
	public Event(String name, Date startDate, Location location, Set<Speaker> speakers) {
		super();
		this.name = name;
		this.startDate = startDate;
		this.location = location;
		this.speakers = speakers;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
	
	public Set<Speaker> getSpeakers() {
		return speakers;
	}

	public void setSpeakers(Set<Speaker> speakers) {
		this.speakers = speakers;
	}

	
	@Override
	public String toString() {
		return "Event [Id=" + Id + ", name=" + name + ", startDate=" + startDate + ", location=" + location + "]";
	}
	
	
	public void addSpeaker( Speaker speaker ) {
		if(speakers==null)
		{
			speakers = new HashSet<Speaker>();
		}
		if ( ! speakers.contains(speaker) ) speakers.add(speaker);
	}

	
	

}
