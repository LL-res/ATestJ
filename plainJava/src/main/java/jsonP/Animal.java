package jsonP;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;

//@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "animalType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Dog.class,name = "dog"),
        @JsonSubTypes.Type(value = Cat.class,name = "cat")
})
public interface Animal extends Serializable {
    //String getType();
}
