import java.util.Scanner;

public class Hangman {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char[] word = {'A', 'B', 'E', 'R', 'R', 'A', 'T', 'I', 'O', 'N'};
        char[] guessed = {'_', '_', '_', '_', '_', '_', '_', '_', '_', '_'};

        int mistakes = 0;
        int hints = 3;
        int correctLetters = 0;

        System.out.println("=============================\n"
                + "       WELCOME TO HANGMAN!\n"
                + "=============================\n\n"
                + "Guess the hidden 10-letter word.\n"
                + "You can make 6 mistakes.\n"
                + "You also have 3 hints.\n\n"
                + "Good luck!\n");

        while (mistakes < 6 && correctLetters < word.length) {

            System.out.print("Word: ");

            for (int i = 0; i < guessed.length; i++) {
                System.out.print(guessed[i] + " ");
            }

            System.out.println();
            System.out.println("Hints left: " + hints);
            System.out.print("Enter a letter or H for a hint: ");

            String answer = scanner.nextLine().toUpperCase();

            if (answer.equals("H")) {

                if (hints > 0) {
                    hints--;

                    if (hints == 2) {
                        System.out.println("Hint: It means something unusual.");
                    } else if (hints == 1) {
                        System.out.println("Hint: It is a deviation from what is normal.");
                    } else {
                        System.out.println("Hint: It can describe an unusual event or situation.");
                    }

                } else {
                    System.out.println("No hints left!");
                }

            } else {

                char letter = answer.charAt(0);
                boolean found = false;

                for (int i = 0; i < word.length; i++) {

                    if (word[i] == letter && guessed[i] == '_') {
                        guessed[i] = letter;
                        correctLetters++;
                        found = true;
                    }
                }

                if (found) {
                    System.out.println("Correct!");

                } else {
                    mistakes++;
                    System.out.println("Wrong guess!");

                    if (mistakes == 1) {
                        System.out.println(
                                " +--+\n"
                              + " |  |\n"
                              + " O  |\n"
                              + "    |\n"
                              + "====="
                        );

                    } else if (mistakes == 2) {
                        System.out.println(
                                " +--+\n"
                              + " |  |\n"
                              + " O  |\n"
                              + " |  |\n"
                              + "====="
                        );

                    } else if (mistakes == 3) {
                        System.out.println(
                                " +--+\n"
                              + " |  |\n"
                              + " O  |\n"
                              + "/|  |\n"
                              + "====="
                        );

                    } else if (mistakes == 4) {
                        System.out.println(
                                " +--+\n"
                              + " |  |\n"
                              + " O  |\n"
                              + "/|\\ |\n"
                              + "====="
                        );

                    } else if (mistakes == 5) {
                        System.out.println(
                                " +--+\n"
                              + " |  |\n"
                              + " O  |\n"
                              + "/|\\ |\n"
                              + "/   |\n"
                              + "====="
                        );

                    } else if (mistakes == 6) {
                        System.out.println(
                                " +--+\n"
                              + " |  |\n"
                              + " O  |\n"
                              + "/|\\ |\n"
                              + "/ \\ |\n"
                              + "====="
                        );
                    }
                }
            }
        }

        if (correctLetters == word.length) {

            System.out.println(
                    "\n=============================\n"
                  + "          YOU WIN!\n"
                  + "=============================\n\n"
                  + "              ___________\n"
                  + "             '._==_==_.'\n"
                  + "             .-\\:     /-.\n"
                  + "            | (|:     |) |\n"
                  + "             '-|:     |-'\n"
                  + "               \\:     /\n"
                  + "                '._.'\n"
                  + "                 | |\n"
                  + "              ___| |___\n"
                  + "             |_________|\n\n"
                  + "       ***CONGRATULATIONS!***"
            );

        } else {

            System.out.println(
                    "\n=============================\n"
                  + "         GAME OVER!\n"
                  + "=============================\n\n"
                  + "             +++\n"
                  + "             +++\n"
                  + "             +++\n"
                  + "      +++++++++++++++\n"
                  + "      +++++++++++++++\n"
                  + "             +++\n"
                  + "             +++\n"
                  + "             +++\n"
                  + "             +++\n"
                  + "             +++\n\n"
                  + "       Better luck next time!"
            );
        }

        scanner.close();
    }
}

