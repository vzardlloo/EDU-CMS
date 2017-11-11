/*
 * This file is generated by jOOQ.
*/
package com.vzard.educms.database.tables.pojos;


import com.vzard.educms.database.tables.interfaces.ITeacher;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Teacher implements ITeacher {

    private static final long serialVersionUID = 558317690;

    private String number;
    private String name;
    private String office;
    private String title;
    private String phoneNumber;
    private String gender;

    public Teacher() {}

    public Teacher(Teacher value) {
        this.number = value.number;
        this.name = value.name;
        this.office = value.office;
        this.title = value.title;
        this.phoneNumber = value.phoneNumber;
        this.gender = value.gender;
    }

    public Teacher(
        String number,
        String name,
        String office,
        String title,
        String phoneNumber,
        String gender
    ) {
        this.number = number;
        this.name = name;
        this.office = office;
        this.title = title;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    @Override
    public String getNumber() {
        return this.number;
    }

    @Override
    public Teacher setNumber(String number) {
        this.number = number;
        return this;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Teacher setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String getOffice() {
        return this.office;
    }

    @Override
    public Teacher setOffice(String office) {
        this.office = office;
        return this;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public Teacher setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    @Override
    public Teacher setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    @Override
    public String getGender() {
        return this.gender;
    }

    @Override
    public Teacher setGender(String gender) {
        this.gender = gender;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Teacher (");

        sb.append(number);
        sb.append(", ").append(name);
        sb.append(", ").append(office);
        sb.append(", ").append(title);
        sb.append(", ").append(phoneNumber);
        sb.append(", ").append(gender);

        sb.append(")");
        return sb.toString();
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public void from(ITeacher from) {
        setNumber(from.getNumber());
        setName(from.getName());
        setOffice(from.getOffice());
        setTitle(from.getTitle());
        setPhoneNumber(from.getPhoneNumber());
        setGender(from.getGender());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends ITeacher> E into(E into) {
        into.from(this);
        return into;
    }
}
