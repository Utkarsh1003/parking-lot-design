package dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class Car extends Vehicle{
    private String name;

    public Car(String name, String licenceNumber, String color) {
        super(licenceNumber, color);
        this.name = name;
    }
}
