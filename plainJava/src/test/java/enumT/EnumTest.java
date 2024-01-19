package enumT;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import enumP.Color;
import org.junit.jupiter.api.Test;

public class EnumTest {
    @Test
    public void t1() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(Color.RED);
        System.out.println(s);
        Color color = objectMapper.readValue(s, Color.class);
        System.out.println(color);
    }
}
