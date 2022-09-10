import java.util.Scanner;

public class BinaryAsciiConverter {
    static int num;

    private static Scanner sc = new Scanner(System.in);

    public static void run() {
        System.out.println(
                """
                        1. Text to binary
                        2. Binary to text
                        3.Quit
                        Enter choice: \s
                        """
        );
        int choice = sc.nextInt();
        sc.nextLine(); //buffer line
        if (choice == 1) {
            textToBinary();
        } else if (choice == 2) {
            binaryToText();
        }
    }

    private static void binaryToText() {
        System.out.println("Enter binary: ");
        String text1 = sc.nextLine();
        int binary = 128;
        int total = 0;
        String end = "";
        for(int i = 0; i < text1.length(); i++) {
            char ascii = text1.charAt(i);

            if(ascii == '1')
            {
                total += binary;
            }
            else if(binary == 0){
                char letter = (char) total;
                total = 0;
                binary = 128;
                end += letter;
            }
            else if(total == 0)
            {
                end += " ";
            }
            binary = binary / 2;
        }
        System.out.println(end);

    }


    private static void textToBinary() {
        System.out.println("Enter text: ");
        String text = sc.nextLine();
        String binary = "";

        for (int i = 0; i < text.length(); i++) {
            int ascii = text.charAt(i);
            int num = 128;
            for (int x = 0; x < 8; x++) {

                if (ascii >= num) {
                    binary += "1";
                    ascii -= num;
                    num /= 2;
                }
                else {
                    binary += "0";
                    num /= 2;
                }

            }

        }
        System.out.println(binary);
    }
}
//input text - done
//loop through text
//Access each character - store as int
//Convert in to binary string
//output answer
