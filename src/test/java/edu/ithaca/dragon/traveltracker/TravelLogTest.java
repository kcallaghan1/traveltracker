package edu.ithaca.dragon.traveltracker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.ArrayList;
public class TravelLogTest {

    @Test
    void constructorTest(){
        TravelLog travelLog = new TravelLog("Ithaca", "All the best locations in downtown Ithaca!");

        assertEquals("Ithaca", travelLog.getTitle());
        assertEquals("All the best locations in downtown Ithaca!", travelLog.getDescription());
        //check for exception thrown correctly
        assertThrows(IllegalArgumentException.class, () -> new TravelLog("", "description here"));
        assertThrows(IllegalArgumentException.class, () -> new TravelLog("Ithaca", ""));
        assertThrows(IllegalArgumentException.class, () -> new TravelLog("", ""));
    }

    @Test
    void addDestinationTest(){
        TravelLog travelLog = new TravelLog("Ithaca", "All the best locations in downtown Ithaca!");
        Location location1 = new Location("Waffle Frolic", "146 E State St, Ithaca, NY 14850");
        Location location2 = new Location("Starbucks", "130 E Seneca St, Ithaca, NY 14850");
        Location location3 = new Location("New Delhi Diamond's", "106 W Green St, Ithaca, NY 14850");

        List<Location> compare = new ArrayList<>();
        compare.add(location1);

        //When places list is still empty
        assertNotEquals(compare, travelLog.getPlaces());
        travelLog.addDestination(location1);
        //Base case
        assertEquals(compare, travelLog.getPlaces());
        //Adding multiple locations
        compare.add(location2);
        compare.add(location3);
        assertNotEquals(compare, travelLog.getPlaces());
        travelLog.addDestination(location2);
        travelLog.addDestination(location3);
        assertEquals(compare, travelLog.getPlaces());
        //adding the same location
        assertThrows(IllegalArgumentException.class, () -> travelLog.addDestination(location1));
    }

    @Test
    void addDestinationV2Test(){
        TravelLog travelLog = new TravelLog("Ithaca", "All the best locations in downtown Ithaca!");
        Location location1 = new Location("Waffle Frolic", "146 E State St, Ithaca, NY 14850");
        Location location2 = new Location("Starbucks", "130 E Seneca St, Ithaca, NY 14850");
        Location location3 = new Location("New Delhi Diamond's", "106 W Green St, Ithaca, NY 14850");
        Date date1 = new Date("May", 3, 2021);
        Date date2 = new Date("April", 15, 2021);
        Date date3 = new Date("March", 21, 2021);

        List<Date> compare = new ArrayList<>();
        compare.add(date1);

        //When places list is still empty
        assertNotEquals(compare, travelLog.getDates());
        travelLog.addDestinationV2(location1, date1);
        //Base case
        assertEquals(compare, travelLog.getDates());
        //Adding multiple locations
        compare.add(date2);
        compare.add(date3);
        assertNotEquals(compare, travelLog.getDates());
        travelLog.addDestinationV2(location2, date2);
        travelLog.addDestinationV2(location3, date3);
        assertEquals(compare, travelLog.getDates());
        //adding the same location
        assertThrows(IllegalArgumentException.class, () -> travelLog.addDestinationV2(location1, date1));
    }
}
