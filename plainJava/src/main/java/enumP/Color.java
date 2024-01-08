package enumP;

import lombok.Data;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Color {
    BLUE(0,"blue"),
    GREEN(1,"green"),
    RED(2,"red");

    Color(Integer a, String b){
        this.code = a;
        this.name = b;
    }
    private Integer code;
    private String name;

    public Color getFromCode(Integer code){
        return Arrays.stream(Color.values()).filter(c -> c.getCode().equals(code)).findFirst().orElse(null);
    }

}
