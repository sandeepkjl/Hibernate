package eventmgr.domain;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class EventTest {
	
	private static SessionFactory factory = HibernateUtil.getSessionFactory();
	
	/** save some events to database */
	public static void saveEvents( ) {
		Event event = new Event( );
		event.setName("Java Days");
		event.setStartDate( new Date(108,Calendar.JULY,1) );
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery(
				"from Location where name=:name");
		query.setParameter("name", "Kasetsart University");
		List list = query.list();
		event.setLocation( (Location)list.get(0) );
		System.out.printf("Saving event: %s\nLocation: %s\n",
					event, event.getLocation() );
		
		Speaker speaker1 = new Speaker("john","9898663325");
		Speaker speaker2 = new Speaker("David", "8989363655");
		
		event.addSpeaker(speaker1);
		event.addSpeaker(speaker2);
		session.save( event );
		tx.commit();
		// getCurrentSession creates a session that is bound to a
		// single
		System.out.println("Event saved");
	}
	
	public static void testRetrieve( ) {
		
		System.out.println("Retrieving events...");
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		// get all the events
		Query query = session.createQuery( "from Event" );
		List<Event> list = (List<Event>)query.list( );
		tx.commit();
	//(1)
		for(Event e : list ) {
			System.out.printf("%s on %tD\n", e.toString(), e.getStartDate() );
			System.out.printf("  Location: %s\n", e.getLocation() );
			System.out.print( "  Speakers:");
			for(Speaker s : e.getSpeakers() ) 
				System.out.print(" "+s.getName() );
			System.out.println();
		}
	//(2) close the session
		session.close( );
	}

	
	
	public static void main(String[] args) {
		// recreate the locations because we told Hibernate
		// to recreate the schema each run.
		LocationTest.saveLocations( );
		saveEvents();
		testRetrieve();
	}


	

}
