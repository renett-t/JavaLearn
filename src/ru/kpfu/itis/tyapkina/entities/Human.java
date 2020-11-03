package ru.kpfu.itis.tyapkina.entities;

import java.util.Calendar;

public class Human {
    protected String name;
    protected Calendar birthDate = Calendar.getInstance();
    protected boolean gender;

    public Human(String name, Calendar birthDate, boolean gender) {
        this.setName(name);
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public void setName(String name) {
        if (name.length() > 2) {
            this.name = name;
        }
    }

    public String getName() {
        return this.name;
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }

    public Calendar getBirthDate() {
       return this.birthDate;
    }

    public void showBirthDate() {
        System.out.println(this.birthDate.get(Calendar.YEAR) + " " + (this.birthDate.get(Calendar.MONTH) + 1) + " " +this.birthDate.get(Calendar.DATE));
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public boolean getGender() {
        return this.gender;
    }
}
