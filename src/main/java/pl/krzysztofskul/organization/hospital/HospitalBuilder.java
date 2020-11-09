package pl.krzysztofskul.organization.hospital;

import java.math.BigDecimal;

public class HospitalBuilder {

    private String name;

    private BigDecimal budget;

    private String country;

    private String city;

    private String postalCode;

    private String street;

    private int streetNo;

    private String www;

    private String email;

    private String phone;

    private float area;

    private String remarks;

    public HospitalBuilder() {
    }

    public HospitalBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public HospitalBuilder setBudget(BigDecimal budget) {
        this.budget = budget;
        return this;
    }

    public HospitalBuilder setCountry(String country) {
        this.country = country;
        return this;
    }

    public HospitalBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public HospitalBuilder setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public HospitalBuilder setStreet(String street) {
        this.street = street;
        return this;
    }

    public HospitalBuilder setStreetNo(int streetNo) {
        this.streetNo = streetNo;
        return this;
    }

    public HospitalBuilder setWww(String www) {
        this.www = www;
        return this;
    }

    public HospitalBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public HospitalBuilder setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public HospitalBuilder setArea(float area) {
        this.area = area;
        return this;
    }

    public HospitalBuilder setRemarks(String remarks) {
        this.remarks = remarks;
        return this;
    }

    public Hospital BuildHospital() {

        Hospital hospital = new Hospital();

        hospital.setName(this.name);

        hospital.setBudget(this.budget);

        hospital.setCountry(this.country);

        hospital.setCity(this.city);

        hospital.setPostalCode(this.postalCode);

        hospital.setStreet(this.street);

        hospital.setStreetNo(this.streetNo);

        hospital.setWww(this.www);

        hospital.setEmail(this.email);

        hospital.setPhone(this.phone);

        hospital.setArea(this.area);

        hospital.setRemarks(this.remarks);

        return hospital;

    }

}
