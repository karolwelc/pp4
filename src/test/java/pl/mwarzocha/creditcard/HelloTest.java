package pl.mwarzocha.creditcard;

import org.junit.jupiter.api.Test;

public class HelloTest {

    @Test
    void myFirstTest(){
        var a = 2;
        var b = 4;
        var result = a+b;

        assert 6 == result;
    }
}
