package de.tum.jk.mongo.pojo;

import java.util.LinkedList;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;
import org.mongodb.morphia.annotations.Reference;

@Entity
public class Student {

	@Id
	ObjectId id;
	@Property
	int matrnr;
	@Property
	String name;
	@Property
	int semester;
	@Reference
	LinkedList<Vorlesung> hoeren;
	@Reference
	LinkedList<Klausur> klausuren;

	public Student() {

	}

	public Student(int matrnr, String name, int semester, LinkedList<Vorlesung> hoeren, LinkedList<Klausur> klausuren) {
		super();
		this.id = new ObjectId();
		this.matrnr = matrnr;
		this.name = name;
		this.semester = semester;
		this.hoeren = hoeren;
		this.klausuren = klausuren;
	}

	public int getMatrnr() {
		return matrnr;
	}

	public void setMatrnr(int matrnr) {
		this.matrnr = matrnr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public LinkedList<Vorlesung> getHoeren() {
		return hoeren;
	}

	public void setHoeren(LinkedList<Vorlesung> hoeren) {
		this.hoeren = hoeren;
	}

	public LinkedList<Klausur> getKlausuren() {
		return klausuren;
	}

	public void setKlausuren(LinkedList<Klausur> klausuren) {
		this.klausuren = klausuren;
	}

	@Override
	public String toString() {
		return "Student [matrnr=" + matrnr + ", name=" + name + ", semester=" + semester + ", hoeren=" + hoeren
				+ ", klausuren=" + klausuren + "]";
	}

}
