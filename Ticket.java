import java.sql.Timestamp;

public record Ticket(int ticketNumber, Timestamp timestamp) {

    public Ticket {
        if(ticketNumber < 0) {
            throw new IllegalArgumentException("Invalid ticket number. Please try again.");
        }
    }

    @Override
    public String toString() {
        return "The ticket number is "+ ticketNumber + " with timestamp of " + timestamp() + ".";
    }
}
