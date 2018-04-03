
import java.sql.Date;
import java.time.LocalDate;


public class Przychody {


    private long id;
    private  String type;
    private String description;
    private long amount;  // kwota transakcji
    private LocalDate date=LocalDate.now();  // data transakcji

    public Przychody(String type, String description, long amount, LocalDate date) {
        this.type = type;
        this.description = description;
        this.amount = amount;
        this.date = date;
    }

    public Przychody() {
    }

    public long getId() {
        return id;
    }

    public long setId() {
        return id;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
