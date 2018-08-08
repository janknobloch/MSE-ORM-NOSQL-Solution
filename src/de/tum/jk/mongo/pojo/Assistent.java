package de.tum.jk.mongo.pojo;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;
import org.mongodb.morphia.annotations.Reference;

public class Assistent {

	@Id
	ObjectId id;
	@Property
	int persnr;
	@Property
	String name;
	@Property
	String fachgebiet;
	@Embedded
	Professor boss;

	public Assistent() {

	}

	public Assistent(int persnr, String name, String fachgebiet, Professor boss) {
		super();
		this.id = new ObjectId();
		this.persnr = persnr;
		this.name = name;
		this.fachgebiet = fachgebiet;
		this.boss = boss;
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

	public String getFachgebiet() {
		return fachgebiet;
	}

	public void setFachgebiet(String fachgebiet) {
		this.fachgebiet = fachgebiet;
	}

	public Professor getBoss() {
		return boss;
	}

	public void setBoss(Professor boss) {
		this.boss = boss;
	}

	@Override
	public String toString() {
		return "Assistent [persnr=" + persnr + ", name=" + name + ", fachgebiet=" + fachgebiet + ", boss=" + boss + "]";
	}

}
