package br.com.paraclean.meetingroom.services;

import br.com.paraclean.meetingroom.dto.RoomDTO;
import br.com.paraclean.meetingroom.dto.RoomInsertDTO;
import br.com.paraclean.meetingroom.entities.Room;
import br.com.paraclean.meetingroom.exceptions.ResourceNotFoundException;
import br.com.paraclean.meetingroom.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Transactional(readOnly = true)
    public List<RoomDTO> findAll(){
        List<Room> list = roomRepository.findAll();
        return  list.stream().map(RoomDTO::new).collect(Collectors.toList());
    }

    public RoomDTO insert(RoomInsertDTO dto){
        Room newRoom = new Room();

        newRoom.setName(dto.getName());
        newRoom.setDate(dto.getDate());
        newRoom.setStartHour(dto.getStartHour());
        newRoom.setEndHour(dto.getEndHour());

        newRoom = roomRepository.save(newRoom);

        return new RoomDTO(newRoom);
    }

    /*
    @method get() => retorna a sala que está dentro do objeto Optional<Room>
     */
    public Room findById(Long id) throws ResourceNotFoundException {
        return roomRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Resource not found " + id));
    }

    public Room update(Long id, Room room) throws ResourceNotFoundException {
        Room newRoom = this.findById(id);

        newRoom.setName(room.getName());
        newRoom.setDate(room.getDate());
        newRoom.setStartHour(room.getStartHour());
        newRoom.setEndHour(room.getEndHour());

        return roomRepository.save(newRoom);
    }

    public void delete(Long id){
        roomRepository.deleteById(id);
    }
}
