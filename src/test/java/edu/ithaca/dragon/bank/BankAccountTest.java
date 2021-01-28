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
<<<<<<< HEAD
        assertTrue(BankAccount.isEmailValid( "a@b.com")); //equivalence class: no special characters and .com domain
        assertFalse( BankAccount.isEmailValid("")); //this would be a border case as it is a string that contains nothing
=======
        // Simple test cases
        assertTrue(BankAccount.isEmailValid("a@b.com"));
        assertFalse(BankAccount.isEmailValid("b.com@a"));
        assertFalse(BankAccount.isEmailValid(" "));

        // Test cases w/o a prefix or suffix
        assertFalse(BankAccount.isEmailValid("a@"));
        assertFalse(BankAccount.isEmailValid("@b.com"));

        // Test cases w/ acceptable prefixes
        assertTrue(BankAccount.isEmailValid("a-b@c.com"));
        assertTrue(BankAccount.isEmailValid("a_b@c.com"));
        assertTrue(BankAccount.isEmailValid("a.b@c.com"));
        assertTrue(BankAccount.isEmailValid("a1b@c.com"));

        // Test cases w/ unacceptable prefixes
        assertFalse(BankAccount.isEmailValid("a#b@c.com"));
        assertFalse(BankAccount.isEmailValid("ab-@c.com"));
        assertFalse(BankAccount.isEmailValid("ab_@c.com"));
        assertFalse(BankAccount.isEmailValid("ab.@c.com"));
        assertFalse(BankAccount.isEmailValid(".ab@c.com"));
        assertFalse(BankAccount.isEmailValid("ab..c@d.com"));

        // Test cases w/ acceptable suffixes
        assertTrue(BankAccount.isEmailValid("a@b.cc"));
        assertTrue(BankAccount.isEmailValid("a@b.org"));
        assertTrue(BankAccount.isEmailValid("a@b1.com"));
        assertTrue(BankAccount.isEmailValid("a@b-1.com"));


        // Test cases w/ unacceptable suffixes
        assertFalse(BankAccount.isEmailValid("a@b#1.com"));
        assertFalse(BankAccount.isEmailValid("a@b1"));
        assertFalse(BankAccount.isEmailValid("a@b1.tde"));
        assertFalse(BankAccount.isEmailValid("a@b1..com"));

>>>>>>> 7dcb11537c2e800f7c31751b40e6260a794d0914
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