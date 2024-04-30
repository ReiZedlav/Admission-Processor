import javax.swing.*;

class test {
    public static void main(String[] args) {

        // Labels
        JLabel applicantLabel = new JLabel("Enter your name: ");
        JLabel birthdayLabel = new JLabel("Enter your birthday: ");
        JLabel addressLabel = new JLabel("Enter your address: ");
        JLabel emailLabel = new JLabel("Enter your email: ");
        JLabel phoneLabel = new JLabel("Enter your phone: ");
        JLabel finalGradeLabel = new JLabel("Enter your final grade: ");

        // Text Fields (Input Forms)
        JTextField applicantField = new JTextField();
        JTextField birthdayField = new JTextField();
        JTextField addressField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField phoneField = new JTextField();
        JTextField finalGradeField = new JTextField();

        // Submit Button
        JButton submitButton = new JButton("Submit");

        // Create a JFrame (window) to hold components
        JFrame registerPage = new JFrame();
        registerPage.setTitle("Initial Registration");
        registerPage.setSize(450, 450);
        registerPage.setLayout(null); // Disable layout manager for absolute positioning
        registerPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registerPage.setResizable(false); // Set resizable to false

        // Set positions and sizes of labels and text fields
        applicantLabel.setBounds(50, 50, 200, 30);
        applicantField.setBounds(250, 50, 120, 30);
        birthdayLabel.setBounds(50, 100, 200, 30);
        birthdayField.setBounds(250, 100, 120, 30);
        addressLabel.setBounds(50, 150, 200, 30);
        addressField.setBounds(250, 150, 120, 30);
        emailLabel.setBounds(50, 200, 200, 30);
        emailField.setBounds(250, 200, 120, 30);
        phoneLabel.setBounds(50, 250, 200, 30);
        phoneField.setBounds(250, 250, 120, 30);
        finalGradeLabel.setBounds(50, 300, 200, 30);
        finalGradeField.setBounds(250, 300, 120, 30);

        // Set position and size of submit button
        submitButton.setBounds(150, 350, 100, 30);

        // Add components to the frame
        registerPage.add(applicantLabel);
        registerPage.add(applicantField);
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

        // ActionListener for the submit button to capture input values
        submitButton.addActionListener(e -> {
            String applicantName = applicantField.getText();
            String birthday = birthdayField.getText();
            String address = addressField.getText();
            String email = emailField.getText();
            String phone = phoneField.getText();
            String finalGrade = finalGradeField.getText();
            
            // Check for null or empty values
            if (applicantName.isEmpty() || birthday.isEmpty() || address.isEmpty() || email.isEmpty() || phone.isEmpty() || finalGrade.isEmpty()) {
                JOptionPane.showMessageDialog(registerPage, "Please fill out all fields.", "Incomplete Information", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Validate final grade
            try {
                double grade = Double.parseDouble(finalGrade);
                if (grade < 75 || grade > 100) {
                    // Clear fields
                    applicantField.setText("");
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

            JOptionPane.showMessageDialog(registerPage, "Prepare for the entrance exam!", "Always aim for Magis", JOptionPane.INFORMATION_MESSAGE);

            int score = EntranceExam();

            // TEST VARIABLES TO SEE IF IT WORKS. YOU CAN OUTPUT IT TO ANY DATA STRUCTURE. DELETE THIS IF DONE
            System.out.println("Applicant Name: " + applicantName);
            System.out.println("Birthday: " + birthday);
            System.out.println("Address: " + address);
            System.out.println("Email: " + email);
            System.out.println("Phone: " + phone);
            System.out.println("Final Grade: " + finalGrade);

            System.out.println(score);
        });
    }

    private static int EntranceExam(){ //U CAN MODIFY THE EXAM HERE
        int score = 0;

       String answer1 = JOptionPane.showInputDialog(null, "IDE is the best subject ever - True or False?");
        if (answer1 != null && answer1.equalsIgnoreCase("True")) {
            score++;
        }

        // Question 2
        String answer2 = JOptionPane.showInputDialog(null, "Xavier University is a Jesuit school - True or False?");
        if (answer2 != null && answer2.equalsIgnoreCase("True")) {
            score++;
        }

        // Question 3
        String answer3 = JOptionPane.showInputDialog(null, "5 + 5 is 11 - True or False?");
        if (answer3 != null && answer3.equalsIgnoreCase("False")) {
            score++;
        }

        // Question 4
        String answer4 = JOptionPane.showInputDialog(null, "15 + 11 = 26 - True or False?");
        if (answer4 != null && answer4.equalsIgnoreCase("True")) {
            score++;
        }

        // Question 5
        String answer5 = JOptionPane.showInputDialog(null, "Pamate & Lage translates to 'listen carefully' - True or False?");
        if (answer5 != null && answer5.equalsIgnoreCase("True")) {
            score++;
        }

        // Question 6
        String answer6 = JOptionPane.showInputDialog(null, "D comes before C then B must come before C - True or False?");
        if (answer6 != null && answer6.equalsIgnoreCase("True")) {
            score++;
        }

        // Question 7
        String answer7 = JOptionPane.showInputDialog(null, "iOS is better than Android - True or False?");
        if (answer7 != null && answer7.equalsIgnoreCase("False")) {
            score++;
        }

        // Question 8
        String answer8 = JOptionPane.showInputDialog(null, "Alcohol kills 100% of all germs - True or False?");
        if (answer8 != null && answer8.equalsIgnoreCase("False")) {
            score++;
        }

        // Question 9
        String answer9 = JOptionPane.showInputDialog(null, "Electric Vehicles are superior to Combustion engines - True or False?");
        if (answer9 != null && answer9.equalsIgnoreCase("False")) {
            score++;
        }

        // Question 10
        String answer10 = JOptionPane.showInputDialog(null, "Balik Balik Sturya means repeating words. - True or False?");
        if (answer10 != null && answer10.equalsIgnoreCase("True")) {
            score++;
        }

        return score;
    }
}
