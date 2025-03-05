import java.util.Scanner;
public class Main {
//Q.1) Write a program to print the numbers from 10 to 50 using for loop/while-loop. using this method
//    public static void main(String[] args) {
//
//        for (int i = 10; i <= 50; i++) {
//            System.out.println(i);
//        }
//    }
//    output 10
//11
//12
//13
//14
//15
//16
//17
//18
//19
//20
//21
//22
//23
//24
//25
//26
//27
//28
//29
//30
//31
//32
//33
//34
//35
//36
//37
//38
//39
//40
//41
//42
//43
//44
//45
//46
//47
//48
//49
//50
//
//Process finished with exit code 0



//
//        public static void main(String[] args) {
//
//            int i = 10;
//            while (i <= 50) {
//                System.out.println(i);
//                i++;
//            }
//        }
//    output:
//            10
//            11
//            12
//            13
//            14
//            15
//            16
//            17
//            18
//            19
//            20
//            21
//            22
//            23
//            24
//            25
//            26
//            27
//            28
//            29
//            30
//            31
//            32
//            33
//            34
//            35
//            36
//            37
//            38
//            39
//            40
//            41
//            42
//            43
//            44
//            45
//            46
//            47
//            48
//            49
//            50
//
//    Process finished with exit code 0





//Q.2) Write a program that find a given number is negative or positive .
//    Input=123
//    Output—Positive
//     Input=- 100
//    Output=Negative

//        public static void main(String[] args) {
//
//            Scanner scanner = new Scanner(System.in);
//
//            System.out.print("Enter a number: ");
//            int number = scanner.nextInt();
//
//            if (number > 0) {
//                System.out.println("Output: Positive");
//            } else if (number < 0) {
//                System.out.println("Output: Negative");
//            } else {
//                System.out.println("Output: Zero");
//            }
//
//
//            scanner.close();
//        }
//    Enter a number: 121
//    Output: Positive
//
//    Process finished with exit code 0
//
//    Enter a number: -100
//    Output: Negative
//
//    Process finished with exit code 0

// Q.3) Write down the program to reverse the given number using loops
//Input = 876
//Output =678

//        public static void main(String[] args) {
//            Scanner scanner = new Scanner(System.in);
//            System.out.print("Enter a number: ");
//            int number = scanner.nextInt();
//            int reversedNumber = 0;
//
//            while (number != 0) {
//                int digit = number % 10;
//                reversedNumber = reversedNumber * 10 + digit;
//                number = number / 10;
//            }
//
//            System.out.println("Output: " + reversedNumber);
//            scanner.close();
//        }
//    Enter a number: 963
//    Output: 369
//
//    Process finished with exit code 0
//

//Q.5) Write a Java program that takes the purchase amount as input and calculates the final payable
//    amount after applying the discount.

//        public static void main(String[] args) {
//            Scanner scanner = new Scanner(System.in);
//
//            System.out.print("Enter the purchase amount: ");
//            double purchaseAmount = scanner.nextDouble();
//
//            double discount = 0;
//
//            if (purchaseAmount > 1000) {
//                discount = 0.20; // 20% discount
//            } else if (purchaseAmount >= 500) {
//                discount = 0.10; // 10% discount
//            }
//
//            double finalAmount = purchaseAmount - (purchaseAmount * discount);
//
//            System.out.println("Final payable amount: " + finalAmount);
//
//            scanner.close();
//        }
//
//    Enter the purchase amount: 500
//    Final payable amount: 450.0
//
//
//    Enter the purchase amount: 1000
//    Final payable amount: 900.0
//
//  Process finished with exit code 0


//       Q.6) Write a java program to print bellowed pattern and j and k=>5
        public static void main(String[] args) {
            int j = 5;
            int k = 5;

            for (int i = 1; i <= j; i++) {
                for (int l = 1; l <= k; l++) {
                    if (l <= i) {
                        System.out.print(j - i + l);
                    } else {
                        System.out.print(j);
                    }
                }
                System.out.println();
            }
        }
//            55555
//            45555
//            34555
//            23455
//            12345
//
//    Process finished with exit code 0


}