package jsonP;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Zoo {
    private final List<Animal> animals = new ArrayList<>();
    public void add(Animal animal){
        animals.add(animal);
    }

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Zoo zoo = new Zoo();
        zoo.add(new Dog());
        zoo.add(new Cat());
        String s = objectMapper.writeValueAsString(zoo);
        System.out.println(s);
    }
}
