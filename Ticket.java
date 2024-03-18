package org.example;

import java.sql.Timestamp;

public record Ticket(int ticketNumber, Timestamp timestamp) {
    public Ticket{
        if(ticketNumber < 0) {
            throw new IllegalArgumentException("Ticket number cannot be less than zero.");
        }
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Ticket #" + ticketNumber + "/ Timestamp: " + timestamp;
    }
}
