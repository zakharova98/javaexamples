package org.example;

import java.util.Random;

public class Operators {

    public Operators() {
    }

    public void ifOperatorExample() {
        int randomValue = new Random().nextInt(1000);
        int mod = randomValue % 2;

        System.out.println("Random value = " + randomValue);
        if (mod == 0) {
            System.out.println("it is odd value");
            if (randomValue % 10 == 2) { // число делится на 2, если его последняя цифра делится на 2
                System.out.println("the number is divisible by 2");
            }
        } else if (randomValue % 10 == 5) { // здесь нечетное число делится на 5, если последняя цифра делится на 5
            System.out.println("it is even value and divisible by 5");
        } else {
            System.out.println("it is even value");
        }
    }

    public void switchOperatorExample(int inputValue) {
        switch (inputValue) {
            case 1:
                System.out.println("Новая игра");
                break;
            case 2:
                System.out.println("Настройки");
                break; // если передать параметр 2 и не написать break
                       // пойдем на следующий case 3 и в консоли отобразится Выход
            case 3:
                System.out.println("Выход");
                break;
            default:
                System.out.println("Ошибка ввода. Пожалуйста, введите цифру 1, 2 или 3");
        }
    }

    public void switchOperatorExampleMonth(int month) {
        switch (month) {
            case 12:
            case 1:
            case 2:
                System.out.println("Winter");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("Spring");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("Summer");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("Autumn");
                break;
            default:
                System.out.println("Invalid value. Not a Month");
        }
    }

    public void whileOperatorExample() {
        System.out.println("while example");
        int i = 10;
        while (i > 0) {
            System.out.println("i = " + i);
            i--;
        }
    }

    public void doWhileOperatorExample() {
        System.out.println("do-while example");
        int i = 10;
        do {
            System.out.println("i = " + i);
            i--;
        } while (i > 0);
    }

    public void forOperatorExample() {
        System.out.println("for example");
        int i;
        for (i = 0; i < 5; i++) {
            System.out.println("i = " + i);
        }

        // объявление переменной k внутри цикла for
        for (int k = 0; k < 5; k++) {
            System.out.println("k = " + k);
        }
    }

    public void forOperatorExample2() {
        int randomValue;
        int mod = -1;

        // условием может быть любое булевское выражение
        for (int i = 0; !(mod == 0); i++) {
            randomValue = new Random().nextInt(1000);
            mod = randomValue % 2;
            System.out.println("Random value = " + randomValue + " i = " + i);
        }
    }

    public void forOperatorExampleForArray() {
        int[][] nums = new int[3][5];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                nums[i][j] = (i + 1) * (j + 1);
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void forEachOperatorExample() {
        int [] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        for (int num:nums) {
            System.out.print(num + " ");
        }
    }

    public void breakOperatorExample() {
        System.out.println("break example");
        for (int i = 0; i < 100; i++) {
            if (i == 5) {
                break;
            }
            System.out.println("i = " + i);
        }
        System.out.println("End");
    }

    public void breakOperatorGoToExample() {
        System.out.println("break operator with goto example\n");
        boolean flag = true;

        first: {
            second: {
                third: {
                    System.out.println("Перед оператором break");
                    if (flag) {
                        break second; // выйти из блока second
                    }
                    System.out.println("Этот оператор не выполнится");
                }
                System.out.println("Этот оператор не выполнится");
            }
            System.out.println("После блока second");
        }
    }

    public void continueOperatorForExample() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) continue;
            System.out.println("i = " + i);
        }
    }

    public void continueOperatorWhileExample() {
        int i = -1;
        while (i < 10) {
            i++;
            if (i % 2 == 0) continue;
            System.out.println("i = " + i);
        }
    }

    public void continueOperatorGoToExample() {
        System.out.println("continue operator with goto example\n");

        first: for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println("i = " + i + " j = " + j);
                if (i != j) continue first;
            }
        }
        System.out.println("После блока first");
    }

    public void returnOperatorExample() {
        boolean flag = true;

        System.out.println("Перед return");
        if (flag) {
            return;
        }
        System.out.println("После return"); // не выполнится в данном случае
    }


}
