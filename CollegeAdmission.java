import java.util.*;

public class CollegeAdmission {
    private static final Map<String, Double> courseQualificationGrades = new HashMap<>();
    private static final Map<String, List<String>> courseSubjects = new HashMap<>();
    private static final PriorityQueue<Student> waitingList = new PriorityQueue<>(Comparator.comparing(Student::getGrade).reversed());

    static {
        // Initialize qualification grades for courses
        courseQualificationGrades.put("Computer Science", 85.0);
        courseQualificationGrades.put("Engineering", 80.0);
        courseQualificationGrades.put("Business", 75.0);

        // Initialize first semester subjects for courses
        courseSubjects.put("Computer Science", Arrays.asList("Intro to Programming", "Calculus", "Physics", "English 101"));
        courseSubjects.put("Engineering", Arrays.asList("Engineering Fundamentals", "Calculus II", "Chemistry", "English 102"));
        courseSubjects.put("Business", Arrays.asList("Intro to Economics", "Statistics", "Accounting", "Business Law"));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your grade: ");
        double grade = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline

        System.out.println("Enter your desired course: ");
        String course = scanner.nextLine();

        if (courseQualificationGrades.containsKey(course)) {
            if (grade >= courseQualificationGrades.get(course)) {
                System.out.println("Congratulations, you're admitted to " + course + "!");
                System.out.println("Your subjects for the 1st semester:");
                courseSubjects.get(course).forEach(System.out::println);
            } else {
                waitingList.add(new Student(grade, course));
                System.out.println("You have been placed on the waiting list.");
            }
        } else {
            System.out.println("Course not found. Please try again.");
        }

        // Additional feature: Recommend a different course based on grades
        System.out.println("Would you like to get a course recommendation based on your grades? (yes/no)");
        String response = scanner.nextLine();
        if ("yes".equalsIgnoreCase(response)) {
            Optional<String> recommendedCourse = courseQualificationGrades.entrySet().stream()
                    .filter(entry -> grade >= entry.getValue())
                    .map(Map.Entry::getKey)
                    .findFirst();

            if (recommendedCourse.isPresent()) {
                System.out.println("Based on your grades, we recommend you consider the " + recommendedCourse.get() + " course.");
            } else {
                System.out.println("Unfortunately, based on your grades, we cannot recommend a course at this time.");
            }
        }
    }

    static class Student {
        private final double grade;
        private final String course;

        public Student(double grade, String course) {
            this.grade = grade;
            this.course = course;
        }

        public double getGrade() {
            return grade;
        }

        public String getCourse() {
            return course;
        }
    }
}