package edu.ithaca.dragon.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void getBalanceTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals(200, bankAccount.getBalance());
    }

    @Test
    void withdrawTest() throws InsufficientFundsException{
        BankAccount bankAccount = new BankAccount("a@b.com", 200);
        bankAccount.withdraw(100);

        assertEquals(100, bankAccount.getBalance());
        assertThrows(InsufficientFundsException.class, () -> bankAccount.withdraw(300));
    }

    @Test
    void isEmailValidTest(){
        assertTrue(BankAccount.isEmailValid( "a@b.com")); 
        assertFalse( BankAccount.isEmailValid("")); 

        // Simple test cases
        assertTrue(BankAccount.isEmailValid("a@b.com")); //equivalence class: no special characters and .com domain
        assertFalse(BankAccount.isEmailValid("b.com@a"));
        assertFalse(BankAccount.isEmailValid(" ")); 

        // Test cases w/o a prefix or suffix
        assertFalse(BankAccount.isEmailValid("a@")); //equivalence class: no domain
        assertFalse(BankAccount.isEmailValid("@b.com")); //equivalence class: no prefix

        // Test cases w/ acceptable prefixes
        assertTrue(BankAccount.isEmailValid("a-b@c.com")); //equivalence class: prefix with '-'
        assertTrue(BankAccount.isEmailValid("a_b@c.com")); //equivalence class: prefix with '_'
        assertTrue(BankAccount.isEmailValid("a.b@c.com")); //equivalence class: prefix with '.'
        assertTrue(BankAccount.isEmailValid("a1b@c.com")); //equivalence class: prefix with 'numericals'

        // Test cases w/ unacceptable prefixes
        assertFalse(BankAccount.isEmailValid("a#b@c.com")); //equivalence class: prefix with unnacceptable special char
        assertFalse(BankAccount.isEmailValid("ab-@c.com")); //equivalence class: prefix with '-'
        assertFalse(BankAccount.isEmailValid("ab_@c.com")); //equivalence class: prefix with '_'
        assertFalse(BankAccount.isEmailValid("ab.@c.com")); //equivalence class: prefix with '.'
        assertFalse(BankAccount.isEmailValid(".ab@c.com")); //equivalence class: prefix with '.' 
        assertFalse(BankAccount.isEmailValid("ab..c@d.com")); //equivalence class: prefix with '.'

        // Test cases w/ acceptable suffixes
        assertTrue(BankAccount.isEmailValid("a@b.cc")); //border case: 2 character domain after '.'
        assertTrue(BankAccount.isEmailValid("a@b.org")); //equivalence class: domain with letter/three character after '.'
        assertTrue(BankAccount.isEmailValid("a@b1.com")); //equivalence class: domain with numerical
        assertTrue(BankAccount.isEmailValid("a@b-1.com")); //border case with special char close to the domain '.com'


        // Test cases w/ unacceptable suffixes
        assertFalse(BankAccount.isEmailValid("a@b#1.com")); //equivalence class: domain with unnaceptable character
        assertFalse(BankAccount.isEmailValid("a@b1")); //equivalence class: domain without '.'
        assertFalse(BankAccount.isEmailValid("a@b1.tde")); //I am not sure waht this is testing
        assertFalse(BankAccount.isEmailValid("a@b1..com")); //equivalence class: special characters next to eachother in domain

    }

    @Test
    void constructorTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals("a@b.com", bankAccount.getEmail());
        assertEquals(200, bankAccount.getBalance());
        //check for exception thrown correctly
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("", 100));
    }

}