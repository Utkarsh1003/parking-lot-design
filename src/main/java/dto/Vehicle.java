package dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vehicle {
    private String licenceNumber;
    private String color;

    public Vehicle(String licenceNumber, String color) {
        this.licenceNumber = licenceNumber;
        this.color = color;
    }
}
