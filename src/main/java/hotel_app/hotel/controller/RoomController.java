package hotel_app.hotel.controller;

import hotel_app.hotel.entity.Room;
import hotel_app.hotel.repository.RoomRepository;
import hotel_app.hotel.service.CreateRoomService;
import hotel_app.hotel.service.DeleteRoomService;
import hotel_app.hotel.service.ReadRoomService;
import hotel_app.hotel.service.UpdateRoomService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    private static final Logger log = LoggerFactory.getLogger(PaymentController.class);
    private final RoomRepository roomRepository;
    private final ReadRoomService readRoomService;
    private final CreateRoomService createRoomService;
    private final UpdateRoomService updateRoomService;
    private final DeleteRoomService deleteRoomService;


    @GetMapping
    ResponseEntity<List<Room>> read()
    {
        return ResponseEntity.ok(roomRepository.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<Room> read(@PathVariable("id") Long id)
    {

        return ResponseEntity.ok(readRoomService.findById(id));
    }


    @GetMapping("/{personNumber}")
    ResponseEntity<List<Room>> readByPersonNumber(@PathVariable("personNumber") Integer personNumber)
    {
        log.info("FIND ROOM BY PERSON NUMBER");

        return ResponseEntity.ok(readRoomService.findByPersonNumber(personNumber));
    }

    @GetMapping("/{priceForNight}")
    ResponseEntity<List<Room>> readByPriceForNight(@PathVariable("priceForNight") Double priceForNight)
    {
        log.info("FIND ROOM BY PRICE FOR NIGHT");

        return ResponseEntity.ok(readRoomService.findByPriceForNight(priceForNight));
    }

    @GetMapping("/{price}")
    ResponseEntity<List<Room>> readByPrice(@PathVariable("price") Double price)
    {
        log.info("FIND ROOM BY PRICE");

        return ResponseEntity.ok(readRoomService.findByPrice(price));
    }

    @GetMapping("/{available}")
    ResponseEntity<List<Room>> readByAvailable(@PathVariable("available") Boolean available)
    {
        log.info("FIND ROOM BY AVAILABLE");

        return ResponseEntity.ok(readRoomService.findByAvailable(available));
    }

    @GetMapping("/{totalCostRoom}")
    public double readByTotalCostRoom(@PathVariable("totalCostRoom") Double totalCostRoom)
    {
        log.info("TOTAL COST ROOM");

        return readRoomService.findByTotalCostRoom();
    }


    @PostMapping
    void create(@RequestBody Room room)
    {
        log.info("CREATE ROOM");
        createRoomService.create(room);
    }

    @PutMapping("/{id}")
    Room update(@PathVariable("id") Long id)
    {
        log.info("UPDATE ROOM BY ID");
        return updateRoomService.updateById(id);
    }

    @PutMapping("/{beds}")
    ResponseEntity<Integer> updateByBeds(@PathVariable("beds") Integer beds)
    {
        log.info("UPDATE ROOM BY BEDS");

        return ResponseEntity.ok(updateRoomService.updateByBeds(beds));
    }

    @PutMapping("/{personNumber}")
    ResponseEntity<Integer> updateByPersonNumber(@PathVariable("personNumber") Integer personNumber)
    {
        log.info("UPDATE ROOM BY PERSON NUMBER");

        return ResponseEntity.ok(updateRoomService.updateByPersonNumber(personNumber));
    }

    @PutMapping("/{priceForNight}")
    ResponseEntity<Double> updateByPriceForNight(@PathVariable("priceForNight") Double priceForNight)
    {
        log.info("UPDATE ROOM BY PRICE FOR 1 NIGHT");

        return ResponseEntity.ok(updateRoomService.updateByPriceForNight(priceForNight));
    }

    @PutMapping("/{price}")
    ResponseEntity<Double> updateByPrice(@PathVariable("price") Double price)
    {
        log.info("UPDATE ROOM BY ALL PRICE");

        return ResponseEntity.ok(updateRoomService.updateByPrice(price));
    }

    @PutMapping("/{available}")
    ResponseEntity<Boolean> updateByAvailable(@PathVariable("available") boolean available)
    {
        log.info("UPDATE ROOM BY AVAILABLE");

        return ResponseEntity.ok(updateRoomService.updateByAvailable(available));
    }

    @DeleteMapping
    void delete(@RequestBody Room room)
    {
        deleteRoomService.delete(room);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable("id") Long id)
    {
        deleteRoomService.deleteById(id);
    }

    @DeleteMapping("/{beds}")
    void deleteByBeds(@PathVariable("beds") Integer beds)
    {
        log.info("DELETE ROOM BY BEDS");

        deleteRoomService.deleteByBeds(beds);
    }

    @DeleteMapping("/{personNumber}")
    void deleteByPersonNumber(@PathVariable("personNumber") Integer personNumber)
    {
        log.info("DELETE ROOM BY PERSON NUMBER");

        deleteRoomService.deleteByPersonNumber(personNumber);
    }

    @DeleteMapping("/{priceForNight}")
    void deleteByPriceForNight(@PathVariable("priceForNight") Double priceForNight)
    {
        log.info("DELETE ROOM BY PRICE FOR 1 NIGHT");

        deleteRoomService.deleteByPriceForNight(priceForNight);
    }

    @DeleteMapping("/{price}")
    void deleteByPrice(@PathVariable("price") Double price)
    {
        log.info("DELETE ROOM BY ALL PRICE");

        deleteRoomService.deleteByPrice(price);
    }

    @DeleteMapping("/{available}")
    void deleteByAvailable(@PathVariable("available") boolean available)
    {
        log.info("DELETE ROOM BY AVAILABLE");

        deleteRoomService.deleteByAvailable(available);
    }
}

