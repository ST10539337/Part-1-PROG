package com.mycompany.prog5121poe;

/**
 * Part 1 - Login feature.
 * Verifies that entered login details match the details captured at
 * registration, and returns the correct login status message.
 */
public class Login {

    private Registration registeredUser;

    public Login(Registration registeredUser) {
        this.registeredUser = registeredUser;
    }

    /**
     * Returns true only if both the username and password entered match
     * the username and password stored when the user registered.
     */
    public boolean loginUser(String enteredUsername, String enteredPassword) {
        if (registeredUser == null || enteredUsername == null || enteredPassword == null) {
            return false;
        }
        return registeredUser.getUsername().equals(enteredUsername)
                && registeredUser.getPassword().equals(enteredPassword);
    }

    /**
     * Returns the correct message for a successful or failed login.
     * @param loginSuccessful
     * @return 
     */
     public String returnLoginStatus(boolean loginSuccessful) {
        if (loginSuccessful) {
            return "A successful login";
        }
        return "A failed login";
    }
    
    }
