package testInfo;

import java.util.Random;
import java.util.UUID;

public class UserData {
    public static String USER_NAME = "Tommy",
            LAST_NAME = "Johnson",
            MOBILE_NUMBER = "4380665455",
            PHOTO_OF_USER_PATH = "src/main/resources/musician-664432_640.jpg",
            STATE = "Haryana",
            CITY = "Karnal",
            USER_LOGIN = "testqa1207",
            PASSWORD = "P@ssw0rdabc";


    public static String randomEmail() {
        String email = null;
        email = "automation" + UUID.randomUUID().toString().replace("-", "") + "@gmail.com";
        return email;
    }

    public static String generateRandomString(int length) {
        int maxLength = Math.min(length, 50);

        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder(maxLength);
        Random random = new Random();

        for (int i = 0; i < maxLength; i++) {
            int index = random.nextInt(characters.length());
            char randomChar = characters.charAt(index);
            sb.append(randomChar);
        }

        return sb.toString();
    }


}
