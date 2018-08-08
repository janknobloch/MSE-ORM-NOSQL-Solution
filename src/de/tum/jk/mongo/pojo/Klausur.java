package de.tum.jk.mongo.pojo;

import java.util.LinkedList;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;
import org.mongodb.morphia.annotations.Reference;

@Entity
public class Klausur {

	@Id
	ObjectId id;
	@Embedded
	Vorlesung vorlesung;
	@Embedded
	Professor professor;
	@Property
	int note;

	public Klausur()
	{
		
	}
	
	public Klausur(Vorlesung vorlesung, Professor professor, int note) {
		super();
		this.id = new ObjectId();
		this.vorlesung = vorlesung;
		this.professor = professor;
		this.note = note;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public Vorlesung getVorlesung() {
		return vorlesung;
	}

	public void setVorlesung(Vorlesung vorlesung) {
		this.vorlesung = vorlesung;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "Klausur [vorlesung=" + vorlesung + ", professor=" + professor + ", note=" + note + "]";
	}

}
