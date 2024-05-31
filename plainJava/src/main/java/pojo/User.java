package pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
public class User implements Serializable {
    private String name;
    private Integer age;
    public User(){
        this.age = 999;
        this.name = "xxx";
        //System.out.println("我会产生副作用");
    }
}
