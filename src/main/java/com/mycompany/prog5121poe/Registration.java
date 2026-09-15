package com.mycompany.prog5121poe;

import java.util.regex.Pattern;

/**
 * Part 1 - Registration feature.
 * Handles creating a user account: username, password and South African
 * cell phone number, with the validation rules required by the brief.
 */
public class Registration {

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String cellPhoneNumber;

    // Regex used for checkCellPhoneNumber().
    // Requires an international country code (+27) followed by exactly
    // 9 digits, i.e. no more than 10 characters total after the '+'.
    // Reference: Oracle regex docs - https://docs.oracle.com/javase/tutorial/essential/regex/
    private static final Pattern CELL_PATTERN = Pattern.compile("^\\+27[0-9]{9}$");

    // Regex used for checkPasswordComplexity().
    // At least 8 characters, at least one capital letter, one digit and
    // one special (non-alphanumeric) character.
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^(?=.*[A-Z])(?=.*[0-9])(?=.*[^A-Za-z0-9]).{8,}$");

    public Registration(String firstName, String lastName, String username,
                         String password, String cellPhoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;
    }

    // ---------- Validation methods (can be tested directly with any value) ----------

    /**
     * Username must contain an underscore and be no more than five
     * characters long.
     * @param username
     * @return 
     */
    public boolean checkUserName(String username) {
        if (username == null) {
            return false;
        }
        return username.contains("_") && username.length() <= 5;
    }

    /**
     * Password must be at least eight characters long, contain a capital
     * letter, a number and a special character.
     * @param password
     * @return 
     */
    public boolean checkPasswordComplexity(String password) {
        if (password == null) {
            return false;
        }
        return PASSWORD_PATTERN.matcher(password).matches();
    }

    /**
     * Cell phone number must contain the South African international
     * country code (+27) followed by the number, no more than ten
     * characters long (i.e. exactly 9 digits after +27).
     * @param cellPhoneNumber
     * @return 
     */
    public boolean checkCellPhoneNumber(String cellPhoneNumber) {
        if (cellPhoneNumber == null) {
            return false;
        }
        return CELL_PATTERN.matcher(cellPhoneNumber).matches();
    }

    // ---------- Registration logic ----------

    /**
     * Validates this Registration's own fields and returns the
     * appropriate message, per the "Conditions / Messages" table.
     */
        // ---------- Registration logic ----------

    /**
     * Validates this Registration's own fields and returns the
     * appropriate message, per the "Conditions / Messages" table.
     * @return 
     */
    public String registerUser() {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        if (!checkCellPhoneNumber(cellPhoneNumber)) {
            return "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.";
        }
        
        // Match the assignment's exact expected return string format:
        return "Welcome " + firstName + " ," + lastName + " it is great to see you.";
    }


    // ---------- Getters / setters ----------

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getCellPhoneNumber() { return cellPhoneNumber; }
    public void setCellPhoneNumber(String cellPhoneNumber) { this.cellPhoneNumber = cellPhoneNumber; }
}