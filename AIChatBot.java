
import java.util.*;

public class AIChatBot {

    // Predefined FAQs and responses (Rule-based logic)
    private static final Map<String, String> knowledgeBase = new HashMap<>();

    static {
        knowledgeBase.put("hi", "Hello! 👋 How can I help you?");
        knowledgeBase.put("hello", "Hi there! What can I do for you?");
        knowledgeBase.put("how are you", "I'm just a bunch of Java code, but I'm doing great! 😄");
        knowledgeBase.put("your name", "I'm JavaBot, your friendly chatbot assistant!");
        knowledgeBase.put("help", "Sure! Ask me anything about Java, tech, or general queries.");
        knowledgeBase.put("bye", "Goodbye! Have a great day! 👋");
        knowledgeBase.put("thank you", "You're welcome! 😊");
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("🤖 Welcome to JavaBot! Type 'exit' to quit.");

            while (true) {
                System.out.print("\nYou: ");
                String input = sc.nextLine().toLowerCase().trim();

                if (input.equals("exit")) {
                    System.out.println("JavaBot: 👋 Bye! Chat again soon.");
                    break;
                }

                boolean matched = false;

                for (String key : knowledgeBase.keySet()) {
                    if (input.contains(key)) {
                        System.out.println("JavaBot: " + knowledgeBase.get(key));
                        matched = true;
                        break;
                    }
                }

                if (!matched) {
                    System.out.println("JavaBot: 🤖 I'm not sure how to respond to that. Try asking something else.");
                }
            }
        }
    }
}
