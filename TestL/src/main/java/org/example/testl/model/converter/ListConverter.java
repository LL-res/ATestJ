package org.example.testl.model.converter;

import jakarta.persistence.AttributeConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListConverter implements AttributeConverter<List<String>, String> {
    private static final String delimeter = ",";

    @Override
    public String convertToDatabaseColumn(List<String> strings) {
        if(strings == null || strings.isEmpty()){
            return "";
        }
        return String.join(delimeter, strings);
    }

    @Override
    public List<String> convertToEntityAttribute(String string) {
        if(string.isEmpty()){
            return new ArrayList<>();
        }
        return Arrays.asList(string.split(delimeter));
    }
}
