package com.example.hoteler;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa reprezentująca Helpdesk w systemie zarządzania zgłoszeniami.
 * Rozszerza klasę ObjectPlus i implementuje interfejs Serializable.
 */
public class Helpdesk extends ObjectPlus implements Serializable {
    private static List<Ticket> ticketList = new ArrayList<>(); // Lista wszystkich zgłoszeń
    private List<Ticket> tickets = new ArrayList<>(); // Lista zgłoszeń przypisanych do tego Helpdesku
    private static List<Employee> employees = new ArrayList<>(); // Lista wszystkich pracowników Helpdesku

    /**
     * Metoda zwracająca listę wszystkich zgłoszeń w systemie.
     *
     * @return lista zgłoszeń
     */
    public static List<Ticket> getAllTickets() {
        return ticketList;
    }

    /**
     * Metoda zwracająca listę zgłoszeń przypisanych do tego Helpdesku.
     *
     * @return lista zgłoszeń przypisanych do tego Helpdesku
     */
    public List<Ticket> getTickets() {
        return tickets;
    }

    /**
     * Metoda statyczna do tworzenia nowego zgłoszenia w systemie.
     * Przyjmuje tytuł, priorytet i opis zgłoszenia, generuje nowy numer identyfikacyjny.
     *
     * @param title       tytuł zgłoszenia
     * @param priority    priorytet zgłoszenia
     * @param description opis zgłoszenia
     */
    public static void createTicket(String title, String priority, String description) {
        int id = ticketList.size() + 1; // Założenie, że ID zgłoszeń są inkrementowane
        CustomDate lastModifiedDate = new CustomDate(LocalDate.now()); // Inicjalizacja daty ostatniej modyfikacji
        Ticket newTicket = new Ticket(id, title, priority, description, LocalDate.now(), lastModifiedDate);
        ticketList.add(newTicket);
    }

    /**
     * Metoda do przypisania pracownika do Helpdesku.
     * Sprawdza, czy pracownik nie jest już przypisany, a następnie dodaje go do listy pracowników Helpdesku.
     *
     * @param employee pracownik do przypisania
     */
    public void addEmployee(Employee employee) {
        if (!employees.contains(employee)) {
            employees.add(employee);
            employee.setHelpdesk(this); // Ustawianie referencji do Helpdesk w pracowniku
        }
    }

    /**
     * Metoda do usunięcia pracownika z Helpdesku.
     * Sprawdza, czy pracownik jest przypisany do Helpdesku, a następnie usuwa go z listy pracowników.
     *
     * @param employee pracownik do usunięcia
     */
    public void removeEmployee(Employee employee) {
        if (employees.contains(employee)) {
            employees.remove(employee);
            employee.setHelpdesk(null); // Usunięcie referencji do Helpdesk w pracowniku
        }
    }

    /**
     * Metoda zwracająca listę pracowników przypisanych do tego Helpdesku.
     *
     * @return lista pracowników Helpdesku
     */
    public List<Employee> getEmployees() {
        return employees;
    }

    /**
     * Metoda do dodawania zgłoszenia do Helpdesku.
     * Sprawdza, czy zgłoszenie nie jest już przypisane do tego Helpdesku, a następnie dodaje je do listy zgłoszeń.
     *
     * @param ticket zgłoszenie do dodania
     */
    public void addTicket(Ticket ticket) {
        if (!tickets.contains(ticket)) {
            tickets.add(ticket);
            ticket.setHelpdesk(this);
        }
    }

    /**
     * Metoda do usuwania zgłoszenia z Helpdesku.
     * Sprawdza, czy zgłoszenie jest przypisane do tego Helpdesku, a następnie usuwa je z listy zgłoszeń.
     *
     * @param ticket zgłoszenie do usunięcia
     */
    public void removeTicket(Ticket ticket) {
        if (tickets.contains(ticket)) {
            tickets.remove(ticket);
            ticket.setHelpdesk(null); // Usuwamy referencję do helpdesku w zgłoszeniu
        }
    }
}
