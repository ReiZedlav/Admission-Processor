import java.util.*;

public class CollegeAdmission {
    private static final Map<String, CourseInfo> courses = new HashMap<>();
    private static final PriorityQueue<Student> waitingList = new PriorityQueue<>(Comparator.comparing(Student::getQpi).reversed());

    static {
        // Initialize courses with their qualification QPI and subjects
        courses.put("Computer Science", new CourseInfo(3.5, Arrays.asList("Intro to Programming", "Calculus", "Physics", "English 101", "Discrete Mathematics")));
        courses.put("Engineering", new CourseInfo(3.0, Arrays.asList("Engineering Fundamentals", "Calculus II", "Chemistry", "English 102", "Circuit Analysis")));
        courses.put("Business", new CourseInfo(2.5, Arrays.asList("Intro to Economics", "Statistics", "Accounting", "Business Law", "Marketing")));
        courses.put("Psychology", new CourseInfo(2.7, Arrays.asList("General Psychology", "Statistics", "Biology", "English 103", "Developmental Psychology")));
        courses.put("Education", new CourseInfo(2.6, Arrays.asList("Foundations of Education", "Child Psychology", "Literature", "History of Education", "Educational Technology")));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Enter your age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        if (age < 16) {
            System.out.println("Sorry, you must be at least 16 years old to apply.");
            return;
        }

        System.out.println("Enter your gender (M/F/Other): ");
        String gender = scanner.nextLine();
        String pronoun = determinePronoun(gender);

        System.out.println("Enter your Math grade: ");
        double mathGrade = scanner.nextDouble();
        System.out.println("Enter your Science grade: ");
        double scienceGrade = scanner.nextDouble();
        System.out.println("Enter your English grade: ");
        double englishGrade = scanner.nextDouble();

        double qpi = calculateQPI(mathGrade, scienceGrade, englishGrade);

        System.out.println(name + ", your QPI is: " + qpi);
        System.out.println("Available courses: " + String.join(", ", courses.keySet()));
        System.out.println("Enter your desired course: ");
        scanner.nextLine(); // Consume the newline
        String course = scanner.nextLine();

        if (courses.containsKey(course)) {
            CourseInfo courseInfo = courses.get(course);
            if (qpi >= courseInfo.getQualificationQPI()) {
                System.out.println("Congratulations, " + pronoun + " " + name + ", you're admitted to " + course + "!");
                System.out.println("Your subjects for the 1st semester:");
                courseInfo.getSubjects().forEach(System.out::println);
            } else {
                waitingList.add(new Student(name, qpi, course));
                System.out.println("You have been placed on the waiting list.");
            }
        } else {
            System.out.println("Course not found. Please try again.");
        }
    }

    private static String determinePronoun(String gender) {
        switch (gender.toLowerCase()) {
            case "m":
                return "Mr.";
            case "f":
                return "Ms.";
            default:
                return "Mx.";
        }
    }

    private static double calculateQPI(double mathGrade, double scienceGrade, double englishGrade) {
        // Assuming each subject has the same weight
        return (mathGrade + scienceGrade + englishGrade) / 3;
    }

    static class Student {
        private final String name;
        private final double qpi;
        private final String course;

        public Student(String name, double qpi, String course) {
            this.name = name;
            this.qpi = qpi;
            this.course = course;
        }

        public String getName() {
            return name;
        }

        public double getQpi() {
            return qpi;
        }

        public String getCourse() {
            return course;
        }
    }

    static class CourseInfo {
        private final double qualificationQPI;
        private final List<String> subjects;

        public CourseInfo(double qualificationQPI, List<String> subjects) {
            this.qualificationQPI = qualificationQPI;
            this.subjects = subjects;
        }

        public double getQualificationQPI() {
            return qualificationQPI;
        }

        public List<String> getSubjects() {
            return subjects;
        }
    }
}
