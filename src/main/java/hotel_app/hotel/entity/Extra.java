package hotel_app.hotel.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Scanner;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Extra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Type type;
    private  Category category;
    private Integer cost;
    private String description;

    @OneToOne
    private Room room;

    @OneToOne
    private ReservationDate date;

    @OneToOne
    private Food food;

    Integer getExtraBreakfastCost()
    {
        Integer addition = 46;
        Logger log = LoggerFactory.getLogger(Extra.class);
        if(category == Category.Food)
        {
            food.setId(1L);
            food.setName("BREAKFAST");
            log.info("YOU CHOOSE FOOD: " +food.getName());
        }
        if(room.getPersonNumber() == 2)
        {
            room.setPersonNumber(2);
            log.info("NUMBER PERSON: "+room.getPersonNumber());

        }
        if(date.totalDayReservation() > 0)
        {
            for(int i = 0; i <= date.totalDayReservation();i++)
            {
                date.setId(1L);
                date.setCheckInDate(LocalDate.now());
                date.setCheckOutDate(date.getCheckOutDate());

                log.info("TOTAL DAY RESERVATION: "+date.totalDayReservation());
            }
        }

        cost = date.totalDayReservation() * addition;
        log.info("TOTAL COST FOR BREAKFAST: " +cost);

        return cost;

    }

    Integer getExtraBeds() {

        Scanner sc = null;
        Integer add= null;
        if(room.getBeds() > 0 && room.getAvailable())
        {
            Logger log = LoggerFactory.getLogger(Extra.class);
            log.info("ADD EXTRA BEDS");
            sc = new Scanner(System.in);
            add= sc.nextInt();
            int allBeds = room.getBeds()+add;
            log.info("EXTRA BEDS: " +add);
            log.info("All BEDS: " +allBeds);

        }
        return add;
    }

    void totalExtraCost()
    {
        Logger log = LoggerFactory.getLogger(Extra.class);
        Integer allCost = getExtraBreakfastCost() + getExtraBeds();
        log.info("TOTAL EXTRA COST: " +allCost);

    }
}
