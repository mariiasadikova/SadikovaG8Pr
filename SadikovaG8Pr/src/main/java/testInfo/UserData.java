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
        // Ограничим длину максимум 50 символами
        int maxLength = Math.min(length, 50);

        // Символы, которые мы хотим использовать в нашей строке
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        // StringBuilder для построения нашей строки
        StringBuilder sb = new StringBuilder(maxLength);

        // Инициализация объекта Random
        Random random = new Random();

        // Генерация случайной строки
        for (int i = 0; i < maxLength; i++) {
            int index = random.nextInt(characters.length());
            char randomChar = characters.charAt(index);
            sb.append(randomChar);
        }

        return sb.toString();
    }


}
