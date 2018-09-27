
package com.realdolmen.maven.clientrepository.domain;

public class Address {
    
    private int key;
    private String typeAddress;
    private String street;
    private int number;
    private int box;
    private PostalCode postalCode;
    private Klant klant;

    public Address(int key, String street, int number, Klant klant) {
        this.key = key;
        this.street = street;
        this.number = number;
        this.klant = klant;
    }
    
    

    
    public Address(){
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getTypeAddress() {
        return typeAddress;
    }

    public void setTypeAddress(String typeAddress) {
        this.typeAddress = typeAddress;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getBox() {
        return box;
    }

    public void setBox(int box) {
        this.box = box;
    }

    public PostalCode getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(PostalCode postalCode) {
        this.postalCode = postalCode;
    }

    public Klant getKlant() {
        return klant;
    }

    public void setKlant(Klant klant) {
        this.klant = klant;
    }
    

    @Override
    public String toString() {
        String card = "******************************\n"
                + this.street +" "+this.number+"\n"
                + this.postalCode.getNumber()+" "+this.postalCode.getCity()+
                "*******************************\n";
        return card;
    }
    
}
