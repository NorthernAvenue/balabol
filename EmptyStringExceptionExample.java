import java.util.Scanner;

public class EmptyStringExceptionExample {
    public static void main(String[] args) {
        try {
            String userInput = promptForInput();
            if (userInput.isEmpty()) {
                throw new EmptyStringException("Пустые строки вводить нельзя.");
            }
            System.out.println("Вы ввели: " + userInput);
        } catch (EmptyStringException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    private static String promptForInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        return scanner.nextLine();
    }
}

class EmptyStringException extends Exception {
    public EmptyStringException(String message) {
        super(message);
    }
}

