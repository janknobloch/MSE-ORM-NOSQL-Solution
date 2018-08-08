package de.tum.jk.mongo.pojo;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

@Entity
public class Professor {

	@Id
	ObjectId id;
	@Property
	int persnr;
	@Property
	String name;
	@Property
	String rang;
	@Property
	int raum;
	
	public Professor()
	{
		
	}
	
	public Professor(int persnr, String name, String rang, int raum) {
		super();
		this.id = new ObjectId();
		this.persnr = persnr;
		this.name = name;
		this.rang = rang;
		this.raum = raum;
	}

	public int getPersnr() {
		return persnr;
	}

	public void setPersnr(int persnr) {
		this.persnr = persnr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRang() {
		return rang;
	}

	public void setRang(String rang) {
		this.rang = rang;
	}

	public int getRaum() {
		return raum;
	}

	public void setRaum(int raum) {
		this.raum = raum;
	}

	@Override
	public String toString() {
		return "Professor [persnr=" + persnr + ", name=" + name + ", rang=" + rang + ", raum=" + raum + "]";
	}

}
