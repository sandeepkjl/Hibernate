package eventmgr.domain;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class LocationTest {
	
	private static SessionFactory factory = HibernateUtil.getSessionFactory();
	
	/** save some locations */
	public static void saveLocations() {
		
		Session session = factory.openSession( );
		Location loc1 = new Location();
		loc1.setName("Kasetsart University");
		loc1.setAddress("Pahonyotin Rd, Bangkok");
		Location loc2 = new Location();
		loc2.setName("Mahidol University");
		loc2.setAddress("Salaya, Nakorn Pathom");
		System.out.println("Saving locations...");
		System.out.println( loc1 );
		System.out.println( loc2 );
		
		Transaction tx = session.beginTransaction();
		session.save( loc1 );
		session.save( loc2 );
		tx.commit();
		session.close();	
		System.out.println("Locations saved");

	}
	
	/** retrieve some events from the database */
	public static void testRetrieve() {
		
		System.out.println("Retrieving locations...");
		Session session = factory.openSession();
		Query query = session.createQuery("from Location");
		Transaction tx = session.beginTransaction();
		List<Location> list = query.list( );
		// print the locations
		for( Object loc : list ) 
			System.out.println( loc );
		tx.commit();
		session.close();
		System.out.println("Done retrieving");
	}
	
	/** change address of a location */
	public static void testUpdate( String name, String newAddress ) {
		
		System.out.println("Updating "+name +"...");
		Session session = factory.openSession( );
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery(
				"from Location where name=:name");
		query.setParameter("name", name );
		
		List list = query.list( );
		if ( list.size() == 0 )
			System.out.print("No location named "+name);
		else {
			// change first location that matches
			Location loc = (Location) list.get(0);
			loc.setAddress( newAddress );
			System.out.println( loc );
		}
		tx.commit();
		session.close( );
	}

	
	public static void main(String[] args) {
		//testSave();
		saveLocations();
		testRetrieve();
		testUpdate("Chulalongkorn University","Rama IV Rd, Bangkok");
		testRetrieve();
	}






}
