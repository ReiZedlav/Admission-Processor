import javax.swing.*;
import java.awt.*;

public class test{
    public static int score = 0;
    public static String selectedCourse = ""; // Variable to hold the selected course

    public static void main(String[] args) {
        // Labels
        JLabel applicantLabel = new JLabel("Enter your name: ");
        JLabel genderLabel = new JLabel("Enter your gender: "); 
        JLabel birthdayLabel = new JLabel("Enter your birthday: ");
        JLabel addressLabel = new JLabel("Enter your address: ");
        JLabel emailLabel = new JLabel("Enter your email: ");
        JLabel phoneLabel = new JLabel("Enter your phone: ");
        JLabel finalGradeLabel = new JLabel("Enter your final grade: ");

        // Text Fields (Input Forms)
        JTextField applicantField = new JTextField();
        JTextField genderField = new JTextField(); 
        JTextField birthdayField = new JTextField();
        JTextField addressField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField phoneField = new JTextField();
        JTextField finalGradeField = new JTextField();

        // Submit Button
        JButton submitButton = new JButton("Submit");

        // RegisterPage Container
        JFrame registerPage = new JFrame();
        registerPage.setTitle("Initial Registration");
        registerPage.setSize(600, 600); // Ang size sa container. 
        registerPage.setLayout(null); // null lng ni sya always
        registerPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registerPage.setResizable(false); // False para chada tan awon

        // Modify positions here
        applicantLabel.setBounds(50, 50, 200, 30);
        applicantField.setBounds(250, 50, 300, 30); 
        genderLabel.setBounds(50, 100, 200, 30); 
        genderField.setBounds(250, 100, 300, 30); 
        birthdayLabel.setBounds(50, 150, 200, 30);
        birthdayField.setBounds(250, 150, 300, 30);
        addressLabel.setBounds(50, 200, 200, 30);
        addressField.setBounds(250, 200, 300, 30);
        emailLabel.setBounds(50, 250, 200, 30);
        emailField.setBounds(250, 250, 300, 30);
        phoneLabel.setBounds(50, 300, 200, 30);
        phoneField.setBounds(250, 300, 300, 30);
        finalGradeLabel.setBounds(50, 350, 200, 30);
        finalGradeField.setBounds(250, 350, 300, 30);

        // Button coordinates
        submitButton.setBounds(250, 400, 100, 30); 

        // RegisterPage components
        registerPage.add(applicantLabel);
        registerPage.add(applicantField);
        registerPage.add(genderLabel); 
        registerPage.add(genderField); 
        registerPage.add(birthdayLabel);
        registerPage.add(birthdayField);
        registerPage.add(addressLabel);
        registerPage.add(addressField);
        registerPage.add(emailLabel);
        registerPage.add(emailField);
        registerPage.add(phoneLabel);
        registerPage.add(phoneField);
        registerPage.add(finalGradeLabel);
        registerPage.add(finalGradeField);
        registerPage.add(submitButton);

        // Make the frame visible
        registerPage.setVisible(true);

        // USED TO TRANSFER DATA TO DATA STRUCTURES
        submitButton.addActionListener(e -> {
            String applicantName = applicantField.getText();
            String gender = genderField.getText(); 
            String birthday = birthdayField.getText();
            String address = addressField.getText();
            String email = emailField.getText();
            String phone = phoneField.getText();
            String finalGrade = finalGradeField.getText();
            String final_course = selectedCourse;

            // Check for null or empty values
            if (applicantName.isEmpty() || gender.isEmpty() || birthday.isEmpty() || address.isEmpty() || email.isEmpty() || phone.isEmpty() || finalGrade.isEmpty()) {
                JOptionPane.showMessageDialog(registerPage, "Please fill out all fields.", "Incomplete Information", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Validate final grade
            try {
                double grade = Double.parseDouble(finalGrade);
                if (grade < 75 || grade > 100) {
                    // Clear fields
                    applicantField.setText("");
                    genderField.setText(""); // Clear gender field
                    birthdayField.setText("");
                    addressField.setText("");
                    emailField.setText("");
                    phoneField.setText("");
                    finalGradeField.setText("");
                    JOptionPane.showMessageDialog(registerPage, "Final grade must be between 75 and 100.", "Invalid Final Grade", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException ex) {
                // Handle invalid number format
                JOptionPane.showMessageDialog(registerPage, "Final grade must be a number.", "Invalid Final Grade", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Display entrance exam message
            JOptionPane.showMessageDialog(registerPage, "Prepare for the entrance exam!", "Always aim for Magis", JOptionPane.INFORMATION_MESSAGE);

            // Take entrance exam

            int attempts = 0;

            while (selectedCourse.equals("")){
                if (attempts > 0){
                    JOptionPane.showMessageDialog(null,"You have " + attempts + " attempts!", "Try again!", JOptionPane.INFORMATION_MESSAGE);
                } 

                score = entranceExam();

                selectedCourse = displayCourseSelection(applicantName);

                attempts++;
            }

            //FINAL EVALUATED PERSONAL DATA - GRADE HAS BEEN REMOVED

            String evaluated_name = applicantName;
            String evaluated_gender = gender;
            String evaluated_birthday = birthday;
            String evaluated_address = address;
            String evaluated_email = email;
            String evaluated_phone = phone;
            String evaluated_course = selectedCourse;

            applicantField.setText("");
            genderField.setText(""); 
            birthdayField.setText("");
            addressField.setText("");
            emailField.setText("");
            phoneField.setText("");
            finalGradeField.setText("");
            selectedCourse = "";
        });
    }
    
    private static int entranceExam() {
        int pts = 0;

        // Question 1
        String answer1 = JOptionPane.showInputDialog(null, "IDE is the best subject ever - True or False?");
        if (answer1 != null && answer1.equalsIgnoreCase("True")) {
            pts++;
        }

        // Question 2
        String answer2 = JOptionPane.showInputDialog(null, "Xavier University is a Jesuit school - True or False?");
        if (answer2 != null && answer2.equalsIgnoreCase("True")) {
            pts++;
        }

        // Question 3
        String answer3 = JOptionPane.showInputDialog(null, "5 + 5 is 11 - True or False?");
        if (answer3 != null && answer3.equalsIgnoreCase("False")) {
            pts++;
        }

        // Question 4
        String answer4 = JOptionPane.showInputDialog(null, "15 + 11 = 26 - True or False?");
        if (answer4 != null && answer4.equalsIgnoreCase("True")) {
            pts++;
        }

        // Question 5
        String answer5 = JOptionPane.showInputDialog(null, "Pamate & Lage translates to 'listen carefully' - True or False?");
        if (answer5 != null && answer5.equalsIgnoreCase("True")) {
            pts++;
        }

        // Question 6
        String answer6 = JOptionPane.showInputDialog(null, "D comes before C then B must come before C - True or False?");
        if (answer6 != null && answer6.equalsIgnoreCase("True")) {
            pts++;
        }

        // Question 7
        String answer7 = JOptionPane.showInputDialog(null, "iOS is better than Android - True or False?");
        if (answer7 != null && answer7.equalsIgnoreCase("False")) {
            pts++;
        }

        // Question 8
        String answer8 = JOptionPane.showInputDialog(null, "Alcohol kills 100% of all germs - True or False?");
        if (answer8 != null && answer8.equalsIgnoreCase("False")) {
            pts++;
        }

        // Question 9
        String answer9 = JOptionPane.showInputDialog(null, "Electric Vehicles are superior to Combustion engines - True or False?");
        if (answer9 != null && answer9.equalsIgnoreCase("False")) {
            pts++;
        }

        // Question 10
        String answer10 = JOptionPane.showInputDialog(null, "Balik Balik Sturya means repeating words. - True or False?");
        if (answer10 != null && answer10.equalsIgnoreCase("True")) {
            pts++;
        }

        return pts;
    }

    private static String displayCourseSelection(String name) {
        StringBuilder message = new StringBuilder("Dear " + name + ", based on your entrance exam score, you are eligible for the following courses:\n\n");

        if (score > 5) {
            message.append("Engineering\n");
            message.append("Nursing\n");
            message.append("Computer Science\n");
            message.append("Agriculture\n");
            message.append("Psychology\n");
            message.append("Chemistry\n");
            message.append("Biology\n");
            
        } else if (score > 2) {
            message.append("Computer Science\n");
            message.append("Agriculture\n");
            message.append("Psychology\n");
            message.append("Chemistry\n");
            message.append("Biology\n");
        } else {
            JOptionPane.showMessageDialog(null, "You did not qualify!", "Admissions notice", JOptionPane.WARNING_MESSAGE);
            return "";
        }

        // Display message
        JOptionPane.showMessageDialog(null, message.toString(), "Course Selection", JOptionPane.INFORMATION_MESSAGE);

        // Prompt user to select a course
        String[] courses;

        if (score > 5){
            courses = new String[]{"Engineering", "Nursing", "Computer Science", "Agriculture","Psychology","Chemistry","Biology"};
        }

        else if (score > 2) {
            courses = new String[]{"Computer Science", "Agriculture", "Psychology", "Chemistry", "Biology"};
        } else {
            courses = new String[]{};
        }
        String selectedCourse = (String) JOptionPane.showInputDialog(null, "Please select a course:", "Course Selection", JOptionPane.QUESTION_MESSAGE, null, courses, null);

        return selectedCourse;
    }
}


