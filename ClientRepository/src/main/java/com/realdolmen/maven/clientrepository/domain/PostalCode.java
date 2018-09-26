package com.realdolmen.maven.clientrepository.domain;
public class PostalCode {
    
    private int number;
    private String city;

    public PostalCode() {
    }
    
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        if(city.isEmpty()){
            this.city = "default";
        }else{
            this.city = city;
        }
    }

    @Override
    public String toString() {
        return "PostalCode{" + "number=" + number + ", city=" + city + '}';
    }
}
