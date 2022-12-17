package controller;

import org.junit.jupiter.api.Assertions;

public class MainTest {

    void getMain_shouldBe_MyNameIsGivenName() {
        String name = "Karmo";
        String given = Main.Companion.main(name);
        Assertions.assertEquals("My name is: $name", given);

    }
}
