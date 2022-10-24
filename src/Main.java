import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
//        task1();
//        task2();
//        task3();
//        task4();
//        task5();
//        task6();
//        task7();
//        task8();
//        task9();
//        task10();
//        task11();
        task14();


//        task15();
    }


    public static void task1() {

        int[] ints = {24, 39, -90};
        File file = new File("src/myFiles/data.txt");
        try (FileWriter fileWriter = new FileWriter(file)) {
            for (int anInt : ints) {
                fileWriter.write(anInt + " ");
                fileWriter.flush();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void task2() {
        File file = new File("src/myFiles/data1.txt");
        try (FileWriter fileWriter = new FileWriter(file)) {
            for (int i = 0; i < 100; i++) {
                fileWriter.write(i + " ");
                fileWriter.flush();
            }
            fileWriter.flush();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void task3() {

        for (int i = 2; i < 33; i++) {
            File file = new File("src/myFiles/data0" + i + ".txt");
            try (FileWriter fileWriter = new FileWriter(file)) {
                fileWriter.write("programmer");
                fileWriter.flush();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }

        }

    }

    public static void task4() {
        for (int i = 1; i < 31; i++) {
            File file = new File("src/myFiles2/data" + i + ".txt");
            try (FileWriter fileWriter = new FileWriter(file)) {
                fileWriter.write("programmer" + i);
                fileWriter.flush();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }


    public static void task5() {
        var a = scanner.nextInt();
        var b = scanner.nextInt();
        File file = new File("src/myFiles/data2.txt");
        try (FileWriter fileWriter = new FileWriter(file)) {
            for (int i = 0; i < 100; i++) {
                fileWriter.write(ThreadLocalRandom.current().nextInt(Math.min(a, b), Math.max(a, b) + 1) + " ");
            }
            fileWriter.flush();

        } catch (IOException e) {
            System.err.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            task5();
        }

    }

    public static void task6() {
        var a = scanner.nextDouble();
        var b = scanner.nextDouble();
        var temp = a;
        if (a > b) {
            temp = b;
            b = a;
            a = temp;
        }
        File file = new File("src/myFiles/data3.txt");
        try (FileWriter fileWriter = new FileWriter(file, true);) {
            fileWriter.write("new numbers" + "\n");
            fileWriter.flush();
            for (int i = 0; i < 100; i++) {
                fileWriter.write(ThreadLocalRandom.current().nextDouble(a, b + 1) + " ");
            }
            fileWriter.flush();

        } catch (IOException e) {
            System.err.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            task5();
        }

    }

    public static void task7() {
        File file = new File("src/myFiles/function.txt");
        try (FileWriter fileWriter = new FileWriter(file)) {
            for (int i = 0; i < 3; i++) {
                double y = (i * i) / 2.24 + 5;
                fileWriter.write(String.format("%,.2f", y) + "\n");
            }
            fileWriter.flush();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void task8() {
        File file = new File("src/function.txt");
        try (FileWriter fileWriter = new FileWriter(file)) {
            for (int i = 0; i < 3; i++) {
                double y = (i * i) / 2.27 + 5;
                fileWriter.write(String.format("%,.2f", y) + "\n");
            }
            fileWriter.flush();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void task9() {
        for (int i = 1; i < 10001; i++) {
            File file = new File("src/myFiles/" + i + ".txt");
            try (FileWriter fileWriter = new FileWriter(file)) {
                fileWriter.write(i + " ");
                fileWriter.flush();

            } catch (IOException e) {
                System.err.println(e.getMessage());

            }
        }

    }

    public static void task10() throws RuntimeException {
        System.out.println("enter binary");
        var binary = 0;
        try {
            binary = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("input should be int ");
            return;
        }
        if (String.valueOf(binary).matches("[0-1]+")) {
            int res = 0;
            int loc = 0;
            while (true) {
                if (binary == 0) {
                    break;
                } else {
                    res += binary % 10 * Math.pow(2, loc);
                    binary = binary / 10;
                    loc++;
                }
            }
            System.out.println(res);
            return;
        }

        throw new RuntimeException("binary only contains 0 and 1 ");


    }

    public static void task11() {
        int decimal = 0;
        System.out.println("enter decimal");
        try {

            decimal = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("decimal should only contain numbers 0-9");
        }

            int[] binary = new int[40];
            int index = 0;
            while (decimal > 0) {
                binary[index++] = decimal % 2;
                decimal = decimal / 2;
            }
            for (int i = index - 1; i >= 0; i--) {
                System.out.print(binary[i]);
            }
    }

    public static void task14() {
        var sumEven = 0;
        var sumOdd = 0;
        System.out.println("enter origin");
        var a = scanner.nextInt();
        System.out.println("enter bound");
        var b = scanner.nextInt();
        File file = new File("number.txt");
        try (FileWriter fileWriter = new FileWriter(file)) {
            for (int i = 0; i < 40; i++) {
                fileWriter.write(ThreadLocalRandom.current().nextInt(a, b) + " ");
                fileWriter.flush();
            }
            String[] strings = Files.readString(Path.of(file.getPath())).split(" ");
            for (String string : strings) {
                System.out.println(string);
                if (Integer.parseInt(string) % 2 == 0) {
                    sumEven += Integer.parseInt(string);
                } else sumOdd += Integer.parseInt(string);
            }
            System.out.println(sumEven);
            System.out.println(sumOdd);
            file = new File("number2.txt");
            try (FileWriter fileWriter1 = new FileWriter(file)) {
                for (int i = 0; i < 5; i++) {
                    fileWriter1.write(ThreadLocalRandom.current().nextInt(Math.min(sumEven, sumOdd), Math.max(sumEven, sumOdd))+" ");
                    fileWriter1.flush();
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }


    public static void task15() {
        File file = new File("info.txt");
        try (FileWriter fileWriter = new FileWriter(file)) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                StringBuilder line = new StringBuilder();
                for (int j = 0; j < m; j++) {
                    line.append(ThreadLocalRandom.current().nextInt(0, 2)).append(" ");
                }
                fileWriter.write(line + "\n");
                fileWriter.flush();
            }
            var count1 = 0;
            var count0 = 0;
            String res = Files.readString(Path.of(file.getPath()));
            for (int i = 0; i < res.length(); i++) {
                if (res.charAt(i) == '1') {
                    count1 += 1;
                }
                if (res.charAt(i) == '0') {
                    count0 += 1;
                }
                System.out.println(count0);
                System.out.println(count1);
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

}
