package br.com.paraclean.meetingroom.contollers;

import br.com.paraclean.meetingroom.dto.RoomDTO;
import br.com.paraclean.meetingroom.dto.RoomInsertDTO;
import br.com.paraclean.meetingroom.entities.Room;
import br.com.paraclean.meetingroom.exceptions.ResourceNotFoundException;
import br.com.paraclean.meetingroom.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping(value = "/rooms")
    public ResponseEntity<List<RoomDTO>> findAll(){
        List<RoomDTO> list = roomService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping(value = "/rooms")
    public ResponseEntity<RoomDTO> insert(@RequestBody RoomInsertDTO roomInsertDTO){
            try{
                RoomDTO roomDTO = roomService.insert(roomInsertDTO);
                URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(roomDTO.getId()).toUri();
                return ResponseEntity.created(uri).body(roomDTO);
            } catch (Exception e) {
                return ResponseEntity.unprocessableEntity().build();
            }
    }

    @PutMapping(value = "/rooms/{id}")
    public ResponseEntity<Room> update(@PathVariable(value = "id") Long id, @RequestBody RoomDTO roomDTO) throws ResourceNotFoundException {
        Room updateRoom = roomService.update(id, roomDTO.toEntity());
        return ResponseEntity.ok().body(updateRoom);
    }

    @DeleteMapping(value = "/rooms/{id}")
    public void delete(@PathVariable Long id){
        roomService.delete(id);
    }

    @GetMapping(value = "/rooms/{id}")
    public ResponseEntity<Room> findById(@PathVariable Long id) throws ResourceNotFoundException {
            Room room = roomService.findById(id);
            return ResponseEntity.ok().body(room);
    }
}
