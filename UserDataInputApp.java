import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}

public class UserDataInputApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            String userInput = getUserInput(scanner);
            String[] userData = validateAndExtractData(userInput);

            String lastName = userData[0];
            String dataToWrite = formatData(userData);

            writeToFile(lastName, dataToWrite);
            System.out.println("Данные успешно записаны в файл.");

        } catch (InvalidInputException | ParseException | IOException e) {
            handleException(e);
        } finally {
            scanner.close();
        }
    }

    private static String getUserInput(Scanner scanner) {
        System.out.println("Введите данные (ФИО, дд.мм.гггг, номер телефона, пол) - через пробел): ");
        return scanner.nextLine();
    }

    private static String[] validateAndExtractData(String userInput) throws InvalidInputException, ParseException {
        String[] userData = userInput.split("\\s+");

        if (userData.length != 6) {
            throw new InvalidInputException("Неверное количество данных. Пожалуйста, введите все необходимые данные.");
        }

        String birthDateStr = userData[3];
        validateDateFormat(birthDateStr);

        String gender = userData[5];
        validateGender(gender);

        return userData;
    }

    private static void validateDateFormat(String dateStr) throws ParseException {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            dateFormat.parse(dateStr);
        } catch (ParseException e) {
            throw new ParseException("Неверный формат даты. Используйте дд.мм.гггг.", 0);
        }
    }

    private static void validateGender(String gender) throws InvalidInputException {
        if (!gender.equals("f") && !gender.equals("m")) {
            throw new InvalidInputException("Неверно указан пол. Используйте 'f' для женского и 'm' для мужского.");
        }
    }

    private static String formatData(String[] userData) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date birthDate = dateFormat.parse(userData[3]);

        return String.format("%s %s %s %s %s %s",
                userData[0], userData[1], userData[2],
                dateFormat.format(birthDate), userData[4], userData[5]);
    }

    private static void writeToFile(String lastName, String data) throws IOException {
        File file = new File("output.txt");

        if (!file.exists()) {
            file.createNewFile();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, StandardCharsets.UTF_8))) {
            writer.write(data);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleException(Exception e) {
        System.err.println("Ошибка: " + e.getMessage());
    }
}



