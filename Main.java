import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to My Quiz Appln: !!!");
        String userType;
        QuestionService quesServ = new QuestionService();
        while (true) {
            System.out.println("You are?(Trainer/Player):");
            userType = in.nextLine().trim();
            if (userType.equalsIgnoreCase("Trainer")) {
                String addQues = "No";
                System.out.println("Hey Trainer!!!");
                System.out.println("Wanna Add Question?");
                addQues = in.nextLine().trim().toLowerCase();
                while (addQues.equalsIgnoreCase("yes")) {

                    quesServ.addQuestion();
                    System.out.println("Wanna Add Question?(YES/NO)");
                    addQues = in.nextLine().trim();
                }
                System.out.println("Trainer Session Ended....");
            } else if (userType.equalsIgnoreCase("Player")) {
                User player = new User();
                if (quesServ.getCurrNumOfQues() == 0) {
                    System.out.println("Sorry Player...No Questions in QuizBank!");
                } else {
                    for (int i = 0; i < quesServ.getCurrNumOfQues(); i++) {
                        quesServ.askQuestion(player);
                    }
                    System.out.println("Number of Correct Answers: " + player.getCrtAns());
                    System.out.println("Number of Wrong Answers: " + player.getWrongAns());
                    System.out.println("Player Status : " + player.getStatus());
                }
            }

        }
        // in.close();

    }
}