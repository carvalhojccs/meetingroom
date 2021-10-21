package br.com.paraclean.meetingroom.dto;

import br.com.paraclean.meetingroom.entities.Room;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;


public class RoomDTO implements Serializable {

    private final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private LocalDate date;
    private LocalTime startHour;
    private LocalTime endHour;

    public RoomDTO(){

    }

    public RoomDTO(Long id, String name, LocalDate date, LocalTime startHour, LocalTime endHour){
        this.id = id;
        this.name = name;
        this.date = date;
        this.startHour = startHour;
        this.endHour = endHour;
    }

    public RoomDTO(Room entity){
        super();
        this.id = entity.getId();
        this.name = entity.getName();
        this.date = entity.getDate();
        this.startHour = entity.getStartHour();
        this.endHour = entity.getEndHour();
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

    public Room toEntity(){
        Room entity = new Room();

        entity.setName(this.name);
        entity.setDate(this.date);
        entity.setStartHour(this.startHour);
        entity.setEndHour(this.endHour);

        return entity;
    }
}
