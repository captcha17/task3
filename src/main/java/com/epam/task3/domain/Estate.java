package com.epam.task3.domain;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.Month;
import java.util.Date;

@Entity
public class Estate {

    public Estate(String street, int floors, int rooms, BigInteger price, Agent agent) {
        this.street = street;
        this.floors = floors;
        this.rooms = rooms;
        this.price = price;
        this.agent = agent;
    }

    public Estate() {
    }

    @Id
    @GeneratedValue()
    private long id;

    @Column
    private String street;

    @Column
    private int floors;

    @Column
    private int rooms;

    @Column
    private BigInteger price;

    @Column
    private Date startDate;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Agent agent;

    @Column
    @Enumerated(EnumType.STRING)
    private Month soldMonth;

    @Column
    @Enumerated(EnumType.STRING)
    private SaleStateType saleType;

    @Column
    private int views;

    public enum SaleStateType {
        NEW,
        SALE,
        SOLD
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public Month getSoldMonth() {
        return soldMonth;
    }

    public void setSoldMonth(Month soldMonth) {
        this.soldMonth = soldMonth;
    }

    public SaleStateType getSaleType() {
        return saleType;
    }

    public void setSaleType(SaleStateType saleType) {
        this.saleType = saleType;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
}
