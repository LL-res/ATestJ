package timeT;

import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.TemporalAccessor;
import java.util.concurrent.TimeUnit;

public class TimeTest {
    @Test
    public void t1() throws InterruptedException {
        Instant now = Instant.now();
        TimeUnit.SECONDS.sleep(1);
        Instant now1 = Instant.now();
        Duration between = Duration.between(now, now1);
        System.out.println(between.toSeconds());
    }
    @Test
    public void t2() throws InterruptedException {
        long l = System.currentTimeMillis();
        TimeUnit.SECONDS.sleep(1);
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l);
    }
    @Test
    public void t3() throws InterruptedException {
        Instant now = Instant.now();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(now, ZoneId.systemDefault());
        System.out.println(localDateTime);
        System.out.println(DateTimeFormatter.ofPattern("dd-MM-yy HH:mm:ss").format(localDateTime));
    }
    @Test
    public void t4() throws InterruptedException {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yy HH:mm:ss").withZone(ZoneId.of("America/Chicago"));
        ZonedDateTime parse = ZonedDateTime.parse("23-05-24 23:30:20", dateTimeFormatter);
        Instant instant = parse.toInstant();
        System.out.println(instant);

    }
}
