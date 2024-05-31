package optionT;

import lombok.Data;

import java.util.Optional;

@Data
public class POJOWithOptionalField {
    private Optional<String> op1;
}
