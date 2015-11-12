package unittest.practice.services;

/**
 * Account service.
 *
 * @author Marcelo Busico.
 */
public class AccountService {

    private float amount;

    public AccountService(float amount) {
        this.amount = amount;
    }
    
    public float getAvailableAmount() {
        return amount;
    }

    public void debitFromAccount(float amountToExtract) {
        amount -= amountToExtract;
    }
}
