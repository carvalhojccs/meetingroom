package br.com.paraclean.meetingroom.dto;

import br.com.paraclean.meetingroom.entities.Room;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class RoomInsertDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private LocalDate date;
    private LocalTime startHour;
    private LocalTime endHour;

    public RoomInsertDTO(){

    }

    public RoomInsertDTO(String name, LocalDate date, LocalTime startHour, LocalTime endHour) {
        this.name = name;
        this.date = date;
        this.startHour = startHour;
        this.endHour = endHour;
    }

    public RoomInsertDTO(Room entity) {
        this.name = entity.getName();
        this.date = entity.getDate();
        this.startHour = entity.getStartHour();
        this.endHour = entity.getEndHour();
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
