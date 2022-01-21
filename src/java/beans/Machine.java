package beans;

import java.util.Date;

public class Machine {

    private int id;
    private String reference;
    private Date dateAchat;
    private double prix;
    private String status;
    private Salle salle;
    
    public Machine(int id, String reference, Date dateAchat, double prix,Salle salle,String status) {
        this.id = id;
        this.reference = reference;
        this.dateAchat = dateAchat;
        this.prix = prix;
        this.salle = salle;
        this.status = status; 
        
    }

    public Machine(String reference, Date dateAchat, double prix,Salle salle,String status) {
        super();
        this.reference = reference;
        this.dateAchat = dateAchat;
        this.prix = prix;
        this.salle = salle;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    
    
    public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setId(int id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
    
    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle s) {
        this.salle = s;
    }

    @Override
    public String toString() {
        return this.id + " " + this.reference;
    }

}
