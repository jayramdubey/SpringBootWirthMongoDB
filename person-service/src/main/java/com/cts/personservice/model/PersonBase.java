package com.cts.personservice.model;

public class PersonBase {

    private Name name;
    //private LocalDate dob;
    private Boolean verified;

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

/*    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }*/

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }
}
