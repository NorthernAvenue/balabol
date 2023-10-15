import java.util.Scanner;

public class InputFloat {
    public static float getFloatInput() {
        float result = 0.0f;
        boolean validInput = false;
        Scanner scanner = new Scanner(System.in);

        while (!validInput) {
            try {
                System.out.print("Введите дробное число (типа float): ");
                String userInput = scanner.nextLine();
                result = Float.parseFloat(userInput);
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Введено некорректное число. Пожалуйста, повторите ввод.");
            }
            scanner.close();
        }

        return result;
    }

    public static void main(String[] args) {
        float userInput = getFloatInput();
        System.out.println("Вы ввели: " + userInput);
    }
}

