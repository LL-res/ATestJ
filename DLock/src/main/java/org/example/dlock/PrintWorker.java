package org.example.dlock;

import com.google.common.io.Files;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.StandardCharsets;

@Component
public class PrintWorker {
    @Value("${worker.path}")
    private String path;
    @Value("${worker.content}")
    private String content;
    public void PrintToFile() throws IOException {

    }
    public void work(){
    }
}
