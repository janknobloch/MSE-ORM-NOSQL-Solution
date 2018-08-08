package de.tum.jk.mongo.pojo;

import java.util.LinkedList;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;
import org.mongodb.morphia.annotations.Reference;

public class Vorlesung {

	@Id
	ObjectId id;
	@Property
	int vorlnr;
	@Property
	String titel;
	@Property
	int sws;
	@Embedded 
	Professor gelesenvon;
	@Reference
	LinkedList<Vorlesung> vorgaenger;
	@Reference
	LinkedList<Vorlesung> nachfolger;

	public Vorlesung() {

	}

	public Vorlesung(int vorlnr, String titel, int sws, Professor gelesenvon) {
		super();
		this.id = new ObjectId();
		this.vorlnr = vorlnr;
		this.titel = titel;
		this.sws = sws;
		this.gelesenvon = gelesenvon;
		this.vorgaenger = new LinkedList<Vorlesung>();
		this.nachfolger = new LinkedList<Vorlesung>();

	}

	public int getVorlnr() {
		return vorlnr;
	}

	public void setVorlnr(int vorlnr) {
		this.vorlnr = vorlnr;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public int getSws() {
		return sws;
	}

	public void setSws(int sws) {
		this.sws = sws;
	}

	public Professor getGelesenvon() {
		return gelesenvon;
	}

	public void setGelesenvon(Professor gelesenvon) {
		this.gelesenvon = gelesenvon;
	}

	public LinkedList<Vorlesung> getVorgaenger() {
		return vorgaenger;
	}

	public void setVorgaenger(LinkedList<Vorlesung> vorgaenger) {
		this.vorgaenger = vorgaenger;
	}

	public LinkedList<Vorlesung> getNachfolger() {
		return nachfolger;
	}

	public void setNachfolger(LinkedList<Vorlesung> nachfolger) {
		this.nachfolger = nachfolger;
	}

	@Override
	public String toString() {
		return "Vorlesung [id=" + id + ", vorlnr=" + vorlnr + ", titel=" + titel + ", sws=" + sws + ", gelesenvon="
				+ gelesenvon + ", vorgaenger=" + vorgaenger + ", nachfolger=" + nachfolger + "]";
	}

	

}
