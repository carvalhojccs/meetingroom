package br.com.paraclean.meetingroom.repositories;

import br.com.paraclean.meetingroom.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
