package karate.client;

import com.intuit.karate.junit5.Karate;

public class ClientRunner {

    @Karate.Test
    Karate testAddClient() {
        return Karate.run("add").relativeTo(getClass());
    }

    @Karate.Test
    Karate testUpClient() {
        return Karate.run("up").relativeTo(getClass());
    }

    @Karate.Test
    Karate testDeleteClient() {
        return Karate.run("delete").relativeTo(getClass());
    }
}