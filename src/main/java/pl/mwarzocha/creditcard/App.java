package pl.mwarzocha.creditcard;

import java.util.Collections;

public class App {
    public static void main(String[] args) {
        var name = "Michal";

        System.out.println(name);
        var message = String.format("Hello %s", name);
        var names = Collections.singletonList("Michal Warzocha");
        System.out.println(message);
    }
}
