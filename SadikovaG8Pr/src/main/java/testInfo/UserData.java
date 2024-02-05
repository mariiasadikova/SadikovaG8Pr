package testInfo;

import java.util.UUID;

public class UserData {
    public static String USER_NAME = "Tommy",
    LAST_NAME = "Johnson";



    public static String randomEmail() {
        String email = null;
        email = "automation" + UUID.randomUUID().toString().replace("-", "") + "@gmail.com";
        return email;
    }
}
