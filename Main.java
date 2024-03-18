package org.example;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Queue<Ticket> ticketQueue = new LinkedList<>();     //Ticket queue creation
        Random random = new Random();

        ticketQueue = generateTickets(7, ticketQueue);

        // Randomly generated processing time
        long waitPlease = random.nextInt(5000) + 1000;
        Thread.sleep(waitPlease);

        processTicket(ticketQueue);
    }

    private static Queue<Ticket> generateTickets(int ticketAmount, Queue<Ticket> ticketQueue) {
        long start = System.currentTimeMillis();    // Setting up ticket generation time
        Timestamp timestamp;                        // Initializing timestamp for our ticket

        for (int i = 1; i <= ticketAmount; i++) {
            long generateTicket = (long)(Math.random() * 5000);     // Randomly generated ticket creation time
            timestamp = new Timestamp(start + generateTicket);      // Assigning true ticket creation time
            ticketQueue.add(new Ticket(i, timestamp));              // Adding newly created ticket to queue
        }
        return ticketQueue;
    }

    private static void processTicket(Queue<Ticket> ticketQueue) {
        while (!ticketQueue.isEmpty()) {
            Ticket currentTicket = ticketQueue.poll();              // Current ticket "torn" from queue
            System.out.println("Ticket #" + currentTicket.getTicketNumber() + " ---> PROCESSED AT: " + currentTicket.getTimestamp());
        }
    }
}

