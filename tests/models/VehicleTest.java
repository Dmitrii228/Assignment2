package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {
    Vehicle car;

    @BeforeEach
    void setUp() {
        car = new Vehicle("Tesla", "Model3",2017,54000,39800);
    }

    @Test
    void setMake() {
        car.setMake("Audi");
        assertEquals("Audi", car.getMake());
    }
    @Test
    void setMakeInvalidEmpty() {
        assertThrows(IllegalArgumentException.class, ()->
                car.setMake(""));
    }
    @Test
    void setMakeInvalidNumbers() {
        assertThrows(IllegalArgumentException.class, ()->
                car.setMake("BMW34"));
    }
    @Test
    void setModel() {
        car.setModel("S5");
        assertEquals("S5", car.getModel());
    }
    @Test
    void setModelInvalidEmpty() {
        assertThrows(IllegalArgumentException.class, ()->
                car.setModel(""));
    }

    @Test
    void setYear() {
        car.setYear(2009);
        assertEquals(2009,car.getYear());
    }

    @Test
    void setMileage() {
        car.setMileage(89076);
        assertEquals(89076,car.getMileage());
    }
    @Test
    void setMileageInvalidLow() {
        assertThrows(IllegalArgumentException.class, ()->
                car.setMileage(-1));
    }

    @Test
    void setMileageInvalidHigh() {
        assertThrows(IllegalArgumentException.class, ()->
                car.setMileage(250001));
    }
    @Test
    void setPrice() {
        car.setPrice(54787);
        assertEquals(54787,car.getPrice());
    }

    @Test
    void setPriceInvalidLow() {
        assertThrows(IllegalArgumentException.class, ()->
                car.setPrice(-0.01));
    }
}