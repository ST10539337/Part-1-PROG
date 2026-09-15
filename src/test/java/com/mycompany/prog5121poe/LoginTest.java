/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.prog5121poe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    @Test
    public void testLoginSuccess() {
        // 1. Setup a valid registered user configuration
        Registration registeredUser = new Registration("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        Login testLogin = new Login(registeredUser);
        
        // 2. Attempt login with the EXACT matching credentials
        boolean loginResult = testLogin.loginUser("kyl_1", "Ch&&sec@ke99!");
        assertTrue(loginResult, "Login should return true for matching credentials.");
        
        // 3. Verify that the correct string notification is produced
        String expectedMessage = "A successful login";
        String actualMessage = testLogin.returnLoginStatus(loginResult);
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testLoginFailed() {
        // 1. Setup a valid registered user configuration
        Registration registeredUser = new Registration("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        Login testLogin = new Login(registeredUser);
        
        // 2. Attempt login with an incorrect password
        boolean loginResult = testLogin.loginUser("kyl_1", "wrongPassword123!");
        assertFalse(loginResult, "Login should return false for incorrect credentials.");
        
        // 3. Verify that the correct failure notification string is produced
        String expectedMessage = "A failed login";
        String actualMessage = testLogin.returnLoginStatus(loginResult);
        assertEquals(expectedMessage, actualMessage);
    }
}
