import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException{

        Queue<Ticket> tickets = new LinkedList<>();

        //Add ticket to simulate the arrival of customer
        tickets = generateTicket(5, tickets);

        Thread.sleep(2000); //time interval between ticket issuance and processing

        processTicket(tickets);
    }

    public static Queue<Ticket> generateTicket(int numberOfTicket, Queue<Ticket> ticketQueue) {

        long start = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(start);

        for (int i = 1; i<= numberOfTicket; i++) {
            ticketQueue.add(new Ticket(i, timestamp));
            long interval = (long)(Math.random()*5000); //tickets are generated in random intervals
            timestamp = new Timestamp(start + 2000*i + interval);

        }

        return  ticketQueue;
    }

    public static void processTicket(Queue<Ticket> ticketQueue) {
        while (ticketQueue.peek() != null) {
            System.out.println(ticketQueue.poll());
        }
    }

}