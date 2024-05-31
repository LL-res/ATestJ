package deepcopyT;


import deepcopy.Deepcopy;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pojo.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DeepcopyTest {
    private List<User> source;
    private List<User> target;
    @BeforeEach
    public void initializeSource(){
        this.source = new ArrayList<>();
        this.target = new ArrayList<>();
        this.source.add( new User("SourceName1",1));
        this.source.add( new User("SourceName2",2));
        this.source.add( new User("SourceName2",2));
    }
    @AfterEach
    public void checkIfEuqal(){
        this.target.get(0).setName("TargetName1");
        if(this.source.equals(target)){
            System.out.println("浅拷贝");
        }else {
            System.out.println("深拷贝");
        }
    }
    @Test
    public void t1(){
        this.target = this.source;
    }

    @Test
    public void t2(){
        this.target = new ArrayList<>(this.source);
    }
    @Test
    public void t3() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(this.source);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        this.target = (List<User>) objectInputStream.readObject();
    }
    @Test
    public void t4() throws IOException, ClassNotFoundException {
        this.target = Deepcopy.copy((ArrayList<User>) this.source);
    }
}
