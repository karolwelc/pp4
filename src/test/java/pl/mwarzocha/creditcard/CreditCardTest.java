package pl.mwarzocha.creditcard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

public class CreditCardTest {

    @Test
    void itAllowsToAssignCreditLimit(){
        //Arange
        CreditCard card = new CreditCard("1234-56789");
        //Act
        card.assignCreditLimit(BigDecimal.valueOf(1000));
        //Assert
        assert BigDecimal.valueOf(1000).equals(card.getBalance());
    }
//    @Test
//    void itAllowsToAssignCreditLimit2(){
//        //Arange
//        CreditCard card = new CreditCard("1234-56789");
//        //Act
//        card.assignCreditLimit(BigDecimal.valueOf(1000));
//        //Assert
//        assertEquals(BigDecimal.valueOf(2000).
//                card.getBalance()
//                );
//        ;
////        assert BigDecimal.valueOf(20000).equals(card.getBalance());
//    }
    @Test
    void itDenyToChangeAlreadyAsignedCredit(){
        CreditCard card = new CreditCard("1234-56789");
        //Act
        card.assignCreditLimit(BigDecimal.valueOf(1000));
        try{
            card.assignCreditLimit(BigDecimal.valueOf(2000));
            fail("Exception should be thrown");
        }catch (CreditCardCantBeMOdifiedException e){
            assertTrue(true);
        }
        
    }
    @Test
    void itDenyToChangeAlreadyAsignedCreditV2(){
        CreditCard card = new CreditCard("1234-56789");
        //Act
        card.assignCreditLimit(BigDecimal.valueOf(1000));
        assertThrows(CreditCardCantBeMOdifiedException.class,
        () -> card.assignCreditLimit(BigDecimal.valueOf(2000)));
    }

    @Test
    void denyWithdowBellowCurrentBalance(){
        CreditCard card = new CreditCard("123-123");
        card.assignCreditLimit(BigDecimal.valueOf(1000));
        card.withdraw(BigDecimal.valueOf(700));
        assertThrows(NoEnoughMooneyException.class,
                () -> card.withdraw(BigDecimal.valueOf(700))
        );

    }
}
