import java.util.*;

public class QuestionService {
    int currQuesPtr;
    Question[] questions = new Question[5];

    public QuestionService() {
        this.currQuesPtr = -1;
    }

    public int getCurrNumOfQues() {
        return this.currQuesPtr + 1;
    }

    public void addQuestion() {
        if (currQuesPtr == questions.length - 1) {
            Question[] questions1 = new Question[questions.length * 2];
            int i = 0;
            for (Question question : questions) {
                questions1[i] = question;
                i++;
            }
            questions = questions1; // so questionsRefVar points to new QuesArr

        }
        Question question;
        String ques, opt1, opt2, opt3, opt4, ans;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the question statement:");

        ques = in.nextLine().trim();
        System.out.println("Enter the option1:");
        opt1 = in.nextLine().trim();
        System.out.println("Enter the option2:");
        opt2 = in.nextLine().trim();
        System.out.println("Enter the option3:");
        opt3 = in.nextLine().trim();
        System.out.println("Enter the option4:");
        opt4 = in.nextLine().trim();

        System.out.println("Enter the answer for ques:");
        ans = in.nextLine().trim();

        this.currQuesPtr++;
        question = new Question(currQuesPtr, ques, opt1, opt2, opt3, opt4, ans);
        questions[currQuesPtr] = question;
        System.out.println("Question of id " + currQuesPtr + " added successfully!");
        // in.close();
    }

    public void askQuestion(User user) {
        Question currQues = questions[(user.getCrtAns() + user.getWrongAns())];
        System.out.println(currQues.getQuestion());
        System.out.println("A. " + currQues.getOpt1() + "  B. " + currQues.getOpt2() + "  C." + currQues.getOpt3()
                + "  D." + currQues.getOpt4());
        System.out.println("Enter the correct option(write full option)");
        Scanner in = new Scanner(System.in);
        String ans = in.nextLine().trim();
        if (ans.equalsIgnoreCase(currQues.getAnswer())) {
            user.setCrtAns(user.getCrtAns() + 1);
            System.out.println("Ans correct:)");
        } else {
            user.setWrongAns(user.getWrongAns() + 1);
            System.out.println("Ans Wrong :(");
        }
        // in.close();

    }

}
