package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TriangleResponse {

    private String id;
    private double firstSide;
    private double secondSide;
    private double thirdSide;
}
