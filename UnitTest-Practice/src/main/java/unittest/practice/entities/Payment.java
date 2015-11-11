package unittest.practice.entities;

/**
 * Payment entity.
 *
 * @author Marcelo Busico.
 */
public class Payment {

    private String description;
    private float amount;

    public Payment(String description, float amount) {
        this.description = description;
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
    
}
