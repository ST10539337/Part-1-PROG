/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.prog5121poe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RegistrationTest {

    @Test
    public void testUsernameCorrectlyFormatted() {
        // Test Data: "kyl_1" -> Has underscore, length <= 5
        Registration testReg = new Registration("Kyle", "Smith", "kyl_1", "Password123!", "+27838968976");
        assertTrue(testReg.checkUserName(testReg.getUsername()));
    }

    @Test
    public void testUsernameIncorrectlyFormatted() {
        // Test Data: "kyle!!!!!!!" -> No underscore, length > 5
        Registration testReg = new Registration("Kyle", "Smith", "kyle!!!!!!!", "Password123!", "+27838968976");
        assertFalse(testReg.checkUserName(testReg.getUsername()));
    }

    @Test
    public void testPasswordMeetsComplexity() {
        // Test Data: "Ch&&sec@ke99!" -> Meets all complexity criteria
        Registration testReg = new Registration("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertTrue(testReg.checkPasswordComplexity(testReg.getPassword()));
    }

    @Test
    public void testPasswordDoesNotMeetComplexity() {
        // Test Data: "password" -> No uppercase, no digits, no specials, weak length
        Registration testReg = new Registration("Kyle", "Smith", "kyl_1", "password", "+27838968976");
        assertFalse(testReg.checkPasswordComplexity(testReg.getPassword()));
    }

    @Test
    public void testCellPhoneCorrectlyFormatted() {
        // Test Data: "+27838968976" -> South African formatting matching CELL_PATTERN
        Registration testReg = new Registration("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertTrue(testReg.checkCellPhoneNumber(testReg.getCellPhoneNumber()));
    }

    @Test
    public void testCellPhoneIncorrectlyFormatted() {
        // Test Data: "08966553" -> Invalid formatting
        Registration testReg = new Registration("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "08966553");
        assertFalse(testReg.checkCellPhoneNumber(testReg.getCellPhoneNumber()));
    }
}
