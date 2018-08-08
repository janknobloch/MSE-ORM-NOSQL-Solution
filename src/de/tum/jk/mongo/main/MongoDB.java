package de.tum.jk.mongo.main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

import de.tum.jk.mongo.pojo.Assistent;
import de.tum.jk.mongo.pojo.Klausur;
import de.tum.jk.mongo.pojo.Professor;
import de.tum.jk.mongo.pojo.Student;
import de.tum.jk.mongo.pojo.Vorlesung;

public class MongoDB {

	public static final String DB_HOST = "interactive-bruegge.in.tum.de";
	public static final int DB_PORT = 27017;
	public static final String DB_NAME = "unischema";
	private static final String DB_USER = "unischema";
	private static final String DB_DATABASE = "see slides";
	private static final String DB_PASSWORD = "see slides";
	public static MongoDB INSTANCE;
	private final Datastore datastore;

	
	public MongoDB() {

		MongoClient mongoClient;
		List<MongoCredential> credentialsList = new ArrayList<MongoCredential>();
		MongoCredential credential = MongoCredential.createCredential(DB_USER, DB_DATABASE, DB_PASSWORD.toCharArray());
		credentialsList.add(credential);

		mongoClient = new MongoClient(new ServerAddress(DB_HOST, DB_PORT), credentialsList);
		datastore = new Morphia().mapPackage(Professor.class.getPackage().getName()).createDatastore(mongoClient,
				DB_NAME);

	}

	public static MongoDB getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new MongoDB();

		}
		return INSTANCE;
	}

	public static void main(String[] args) {
		
		/**
		 * Only works inside the university network due to blocked ports of mongo to outside clients.
		 */
		
		MongoDB m = MongoDB.getInstance();
		//createDatabase(m);
		/**
		 * Original Tasks from the SQL Lecture on querying Show all students which are
		 * studying shorter than 4 semesters Tables involved: students
		 * 
		 * Show which assistant belongs to each professors Tables involved: assistenten,
		 * professoren
		 * 
		 * Show a list of students with their corresponding classes Tables involved:
		 * vorlesung, hoeren, studenten
		 * 
		 * Show which professor is examining which student Tables involved: studenten,
		 * professoren, pruefen, vorlesung
		 * 
		 */

		/**
		 * Show all students which are studying shorter than 4 semesters
		 */
		Query<Student> q1 = m.datastore.createQuery(Student.class);
		q1.field("semester").lessThanOrEq(4);
		System.out.println(q1.toString());
		List<Student> res = q1.asList();
		for (Student s : res) {
			System.out.println(s.getName() + " " + s.getSemester());
		}

		/**
		 * * Show which assistant belongs to each professors
		 */
		Query<Assistent> q2 = m.datastore.createQuery(Assistent.class);
		System.out.println(q2.toString());
		List<Assistent> res2 = q2.asList();
		for (Assistent s : res2) {
			System.out.println(s.getName() + " " + s.getBoss().getName());
		}

		/**
		 * Show a list of students with their corresponding classes
		 */
		Query<Student> q3 = m.datastore.createQuery(Student.class);
		System.out.println(q3.toString());
		List<Student> res3 = q3.asList();
		for (Student s : res3) {
			System.out.println(s.getName() + " " + s.getHoeren());
		}

		/**
		 * Show which professor is examining which student
		 */

		Query<Student> q4 = m.datastore.createQuery(Student.class);
		List<Student> res4 = q4.asList();
		for (Student s : res4) {
			System.out.println(s.getName() + " " + s.getKlausuren());
		}

//		createDatabase(m);

	}

	private static void createDatabase(MongoDB m) {
		Professor p1 = new Professor(2125, "Sokrates", "C4", 226);
		Professor p2 = new Professor(2126, "Russel", "C4", 232);
		Professor p3 = new Professor(2127, "Kopernikus", "C3", 310);
		Professor p4 = new Professor(2133, "Popper", "C3", 52);
		Professor p5 = new Professor(2134, "Augustinus", "C3", 309);
		Professor p6 = new Professor(2136, "Curie", "C4", 36);
		Professor p7 = new Professor(2137, "Kant", "C4", 7);

		Assistent a1 = new Assistent(3002, "Platon", "Ideenlehre", p1);
		Assistent a2 = new Assistent(3003, "Aristotheles", "Syllogistik", p1);
		Assistent a3 = new Assistent(3004, "Wittgenstein", "Sprachtheorie", p2);
		Assistent a4 = new Assistent(3005, "Rhetikus", "Planetenbewegung", p3);
		Assistent a5 = new Assistent(3006, "Newton", "Keplersche Gesetze", p3);
		Assistent a6 = new Assistent(3007, "Spinoza", "Gott und Natur", p5);

		Vorlesung v1 = new Vorlesung(5001, "Grundzuege", 4, p7);
		Vorlesung v2 = new Vorlesung(5041, "Ethik", 4, p1);
		Vorlesung v3 = new Vorlesung(5043, "Erkenntnistheorie", 3, p2);
		Vorlesung v4 = new Vorlesung(5049, "Maeutik", 2, p1);
		Vorlesung v5 = new Vorlesung(4052, "Logik", 4, p1);
		Vorlesung v6 = new Vorlesung(5052, "Wissenschaftstheorie", 3, p2);
		Vorlesung v7 = new Vorlesung(5216, "Bioethik", 2, p2);
		Vorlesung v8 = new Vorlesung(5259, "Der Wiener Kreis", 2, p4);
		Vorlesung v9 = new Vorlesung(5022, "Glaube und Wissen", 2, p5);
		Vorlesung v10 = new Vorlesung(4630, "Die 3 Kritiken", 4, p7);

		// bidirectional mapping of vorgaenger und nachfolger
//		 v1.getNachfolger().add(v2);
//		 v2.getVorgaenger().add(v1);
//		
//		 v1.getNachfolger().add(v3);
//		 v3.getVorgaenger().add(v1);
//		
//		 v1.getNachfolger().add(v4);
//		 v4.getVorgaenger().add(v1);
//		
//		 v2.getNachfolger().add(v7);
//		 v7.getVorgaenger().add(v2);
//		
//		 v2.getNachfolger().add(v6);
//		 v6.getVorgaenger().add(v2);
//		
//		 v2.getNachfolger().add(v6);
//		 v6.getVorgaenger().add(v2);
//		
//		 v6.getNachfolger().add(v8);
//		 v7.getVorgaenger().add(v6);

		// Students including their Vorlesungsmapping
		Student s1 = new Student(24002, "Xenokrates", 18, null, null);

		LinkedList<Vorlesung> l2 = new LinkedList<Vorlesung>();
		// klausuren
		LinkedList<Klausur> k2 = new LinkedList<Klausur>();
		Klausur klausur1 = new Klausur(v2, p1, 2);
		k2.add(klausur1);
		l2.add(v9);
		Student s2 = new Student(25403, "Jonas", 12, l2, k2);

		LinkedList<Vorlesung> l3 = new LinkedList<Vorlesung>();
		l3.add(v1);
		Student s3 = new Student(26120, "Fichte", 10, l3, null);

		Student s4 = new Student(26830, "Aristoxenos", 8, null, null);

		LinkedList<Vorlesung> l5 = new LinkedList<Vorlesung>();
		// klausuren
		LinkedList<Klausur> k5 = new LinkedList<Klausur>();
		Klausur klausur2 = new Klausur(v10, p7, 2);
		k5.add(klausur2);
		l5.add(v1);
		l5.add(v5);
		Student s5 = new Student(27550, "Schopenhauer", 6, l5, k5);

		LinkedList<Vorlesung> l6 = new LinkedList<Vorlesung>();
		// klausuren
		LinkedList<Klausur> k6 = new LinkedList<Klausur>();
		Klausur klausur3 = new Klausur(v1, p2, 1);
		k6.add(klausur3);

		l6.add(v2);
		l6.add(v6);
		l6.add(v7);
		l6.add(v8);
		Student s6 = new Student(28106, "Carnap", 3, l6, k6);

		LinkedList<Vorlesung> l7 = new LinkedList<Vorlesung>();
		l7.add(v1);
		l7.add(v2);
		l7.add(v4);
		Student s7 = new Student(29120, "Theophrastos", 2, l7, null);

		LinkedList<Vorlesung> l8 = new LinkedList<Vorlesung>();
		l8.add(v1);
		l8.add(v9);
		Student s8 = new Student(29555, "Feuerbach", 2, l8, null);

		m.datastore.save(p1);
		m.datastore.save(p2);
		m.datastore.save(p3);
		m.datastore.save(p4);
		m.datastore.save(p5);
		m.datastore.save(p6);
		m.datastore.save(p7);

		m.datastore.save(a1);
		m.datastore.save(a2);
		m.datastore.save(a3);
		m.datastore.save(a4);
		m.datastore.save(a5);
		m.datastore.save(a6);

		m.datastore.save(v1);
		m.datastore.save(v2);
		m.datastore.save(v3);
		m.datastore.save(v4);
		m.datastore.save(v5);
		m.datastore.save(v6);
		m.datastore.save(v7);
		m.datastore.save(v8);
		m.datastore.save(v9);
		m.datastore.save(v10);

		m.datastore.save(klausur1);
		m.datastore.save(klausur2);
		m.datastore.save(klausur3);

		m.datastore.save(s1);
		m.datastore.save(s2);
		m.datastore.save(s3);
		m.datastore.save(s4);
		m.datastore.save(s5);
		m.datastore.save(s6);
		m.datastore.save(s7);
		m.datastore.save(s8);
	}
}
