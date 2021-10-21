package br.com.paraclean.meetingroom.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DATE")
    private LocalDate date;

    @Column(name = "START_HOUR")
    private LocalTime startHour;

    @Column(name = "END_HOUR")
    private LocalTime endHour;

    public Room(){

    }

    public Room (Long id, String name, LocalDate date, LocalTime startHour, LocalTime endHour){
        super();
        this.id = id;
        this.name = name;
        this.date = date;
        this.startHour = startHour;
        this.endHour = endHour;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartHour() {
        return startHour;
    }

    public void setStartHour(LocalTime startHour) {
        this.startHour = startHour;
    }

    public LocalTime getEndHour() {
        return endHour;
    }

    public void setEndHour(LocalTime endHour) {
        this.endHour = endHour;
    }
}
