package pl.mwarzocha.creditcard;

import java.math.BigDecimal;

public class CreditCard {
    private BigDecimal credit;
    private  BigDecimal balance;
    public CreditCard(String cardNumber) {

    }

    public void assignCreditLimit(BigDecimal credit) {
        if (this.credit != null){
            throw new CreditCardCantBeMOdifiedException();
        }
        this.credit = credit;
        this.balance = this.credit;

    }

    public BigDecimal getBalance() {
        return credit;
    }


    public void withdraw(BigDecimal money) {
        if (!canAfford(money)){
            throw new NoEnoughMooneyException();
        }
        this.balance = this.balance.subtract(money);

    }

    private boolean canAfford(BigDecimal money) {
        return  this.balance.subtract(money).compareTo(BigDecimal.ZERO) > 0;
    }
}
