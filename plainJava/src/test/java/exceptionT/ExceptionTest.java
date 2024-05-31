package exceptionT;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ExceptionTest {
    static Exception exception1 = new Exception("exception1");
    static Exception exception2 = new Exception("exception2");

    //错误的例子，千万不要写静态异常，否则日志的位置都会被定位到这个static上
    @Test
    public void t1() {
        try {
            throw exception1;
        } catch (Exception e) {
            log.error("1 here", e);
        }
        try {
            throw exception2;
        } catch (Exception e) {
            log.error("2 here", e);
        }
    }

    public static Exception exception3() {
        return new Exception("exception3");
    }

    public static Exception exception4() {
        return new Exception("exception4");
    }

    //统一管理异常的时候一定要使用静态方法来创建非静态的异常
    @Test
    public void t2() {
        try {
            throw ExceptionTest.exception3();
        } catch (Exception e) {
            log.error("3 here", e);
        }
        try {
            throw ExceptionTest.exception4();
        } catch (Exception e) {
            log.error("4 here", e);
        }
    }

    @Test
    public void t3() throws Exception {
        try {
            throw ExceptionTest.exception3();
        } finally {
            //这个finally的异常抛出会屏蔽上层的异常
            throw ExceptionTest.exception4();
        }
    }
    //要在finally中做异常的捕获，并且尽量使用try with resource的模式
    @Test
    public void t4() throws Exception {
        try {
            throw ExceptionTest.exception3();
        } finally {
            try {
                throw ExceptionTest.exception4();
            }catch (Exception e){
                log.error("finally error",e);
            }
        }
    }
}
