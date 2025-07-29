
import java.util.*;

public class StudentGradeTracker {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            ArrayList<Student> students = new ArrayList<>();
            System.out.println("🎓 Student Grade Tracker");
            // Input loop
            while (true) {
                System.out.print("Enter student name (or type 'done' to finish): ");
                String name = sc.nextLine();

                if (name.equalsIgnoreCase("done")) {
                    break;
                }

                System.out.print("Enter score for " + name + ": ");
                int score = Integer.parseInt(sc.nextLine());

                students.add(new Student(name, score));
            }   // Validation
            if (students.isEmpty()) {
                System.out.println("❌ No student data entered.");
                return;
            }
            int total = 0, highest = Integer.MIN_VALUE, lowest = Integer.MAX_VALUE;
            String topStudent = "", lowStudent = "";
            for (Student s : students) {
                int score = s.getScore();
                total += score;

                if (score > highest) {
                    highest = score;
                    topStudent = s.getName();
                }
                if (score < lowest) {
                    lowest = score;
                    lowStudent = s.getName();
                }
            }
            double average = (double) total / students.size();
            System.out.println("\n📊 Summary Report:");
            System.out.printf("Average Score: %.2f%n", average);
            System.out.println("Highest Score: " + highest + " (" + topStudent + ")");
            System.out.println("Lowest Score: " + lowest + " (" + lowStudent + ")");
            System.out.println("\n📋 Student List:");
            for (Student s : students) {
                System.out.println(s.getName() + " - " + s.getScore());
            }
        }
    }
}
