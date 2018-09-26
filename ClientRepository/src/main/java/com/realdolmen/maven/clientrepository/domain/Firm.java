package com.realdolmen.maven.clientrepository.domain;


public class Firm extends Klant{
    
    private String taxNumber;
    private String name;
    private String field;

    public Firm() {
    }

    @Override
    public void hello() {
        super.hello();
        System.out.print(" firma "+this.name);
    }
   
    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return "Firm{number= "+number + "taxNumber=" + taxNumber + ", name=" + name + '}';
    }
   
}
