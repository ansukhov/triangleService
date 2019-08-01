package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.Objects;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TriangleRequest {

    private String separator;
    private String input;

    public TriangleRequest(String separator, String input) {
        setSeparator(separator);
        setInput(input);
    }

    public TriangleRequest(String input) {
        setInput(input);
    }

    @Override
    public String toString() {
        return String.format("Triangle: input - %s; separator - %s", getInput(), Objects.isNull(getSeparator()) ? ";" : getSeparator());
    }
}
