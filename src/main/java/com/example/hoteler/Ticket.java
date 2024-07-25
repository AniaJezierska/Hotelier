package com.example.hoteler;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Klasa reprezentująca zgłoszenie (Ticket) w systemie helpdeskowym.
 * Rozszerza klasę ObjectPlus i implementuje interfejs Serializable.
 */
public class Ticket extends ObjectPlus implements Serializable {
    private int id;
    private String title;
    private String priority;
    private String status;
    private String description;
    private LocalDate creationDate;
    private CustomDate lastModifiedDate;
    private Guest guest;
    private Helpdesk helpdesk;


    /**
     * Konstruktor klasy Ticket.
     *
     * @param id             identyfikator zgłoszenia
     * @param title          tytuł zgłoszenia
     * @param priority       priorytet zgłoszenia
     * @param description    opis zgłoszenia
     * @param creationDate   data utworzenia zgłoszenia
     * @param lastModifiedDate data ostatniej modyfikacji zgłoszenia
     */
    public Ticket(int id, String title, String priority, String description, LocalDate creationDate, CustomDate lastModifiedDate) {
        this.id = id;
        this.title = title;
        this.priority = priority;
        this.description = description;
        this.creationDate = creationDate;
        this.lastModifiedDate = lastModifiedDate;
    }


    /**
     * Zwraca identyfikator zgłoszenia.
     *
     * @return identyfikator zgłoszenia
     */
    public int getId() {
        return id;
    }

    /**
     * Ustawia identyfikator zgłoszenia.
     *
     * @param id identyfikator zgłoszenia
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Zwraca tytuł zgłoszenia.
     *
     * @return tytuł zgłoszenia
     */
    public String getTitle() {
        return title;
    }

    /**
     * Zwraca tytuł zgłoszenia.
     *
     * @return tytuł zgłoszenia
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Zwraca priorytet zgłoszenia.
     *
     * @return priorytet zgłoszenia
     */
    public String getPriority() {
        return priority;
    }

    /**
     * Ustawia priorytet zgłoszenia.
     *
     * @param priority priorytet zgłoszenia
     */
    public void setPriority(String priority) {
        this.priority = priority;
    }

    /**
     * Zwraca opis zgłoszenia.
     *
     * @return opis zgłoszenia
     */
    public String getDescription() {
        return description;
    }

    /**
     * Ustawia opis zgłoszenia.
     *
     * @param description opis zgłoszenia
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Zwraca datę utworzenia zgłoszenia.
     *
     * @return data utworzenia zgłoszenia
     */
    public LocalDate getCreationDate() {
        return creationDate;
    }

    /**
     * Ustawia datę utworzenia zgłoszenia.
     *
     * @param creationDate data utworzenia zgłoszenia
     */
    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Zwraca datę ostatniej modyfikacji zgłoszenia.
     *
     * @return data ostatniej modyfikacji zgłoszenia
     */
    public LocalDate getLastModifiedDate() {
        return lastModifiedDate.getDate();
    }

    /**
     * Ustawia datę ostatniej modyfikacji zgłoszenia.
     *
     * @param lastModifiedDate data ostatniej modyfikacji zgłoszenia
     */
    public void setLastModifiedDate(CustomDate lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    /**
     * Zwraca status zgłoszenia.
     *
     * @return status zgłoszenia
     */
    public String getStatus() {
        return status;
    }

    /**
     * Ustawia status zgłoszenia.
     *
     * @param status status zgłoszenia
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Oblicza liczbę dni od utworzenia zgłoszenia do ostatniej modyfikacji.
     *
     * @return liczba dni od utworzenia zgłoszenia do ostatniej modyfikacji
     */
    public int getDaysSinceCreation() {
        long daysBetween = ChronoUnit.DAYS.between(creationDate, lastModifiedDate.getDate());
        return (int) daysBetween;
    }

    /**
     * Zwraca gościa przypisanego do zgłoszenia.
     *
     * @return gość przypisany do zgłoszenia
     */
    public Guest getGuest() {
        return guest;
    }

    /**
     * Ustawia gościa przypisanego do zgłoszenia.
     *
     * @param guest gość przypisany do zgłoszenia
     */
    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    /**
     * Ustawia Helpdesk, do którego przypisane jest zgłoszenie.
     *
     * @param helpdesk Helpdesk, do którego przypisane jest zgłoszenie
     */
    public void setHelpdesk(Helpdesk helpdesk) {
        this.helpdesk = helpdesk;
    }

    /**
     * Modyfikuje zgłoszenie ustawiając nowy opis, priorytet, status i datę ostatniej modyfikacji.
     *
     * @param newDescription      nowy opis zgłoszenia
     * @param newPriority         nowy priorytet zgłoszenia
     * @param newStatus           nowy status zgłoszenia
     * @param newLastModifiedDate nowa data ostatniej modyfikacji zgłoszenia
     */
    public void modifyTicket(String newDescription, String newPriority, String newStatus, CustomDate newLastModifiedDate) {
        this.description = newDescription;
        this.priority = newPriority;
        this.status = newStatus;
        this.lastModifiedDate = newLastModifiedDate;
    }

    /**
     * Modyfikuje zgłoszenie ustawiając nowy opis, priorytet, status i aktualną datę jako datę ostatniej modyfikacji.
     *
     * @param newDescription nowy opis zgłoszenia
     * @param newPriority    nowy priorytet zgłoszenia
     * @param newStatus      nowy status zgłoszenia
     */
    public void modifyTicket(String newDescription, String newPriority, String newStatus) {
        CustomDate now = new CustomDate(LocalDate.now());
        modifyTicket(newDescription, newPriority, newStatus, now);
    }

    /**
     * Zwraca tekstową reprezentację zgłoszenia.
     *
     * @return tekstowa reprezentacja zgłoszenia
     */
    @Override
    public String toString() {
        return "Ticket ID: " + id +
                "\nTitle: " + title +
                "\nPriority: " + priority +
                "\nDescription: " + description +
                "\nCreation Date: " + creationDate +
                "\nLast Modified Date: " + lastModifiedDate.getDate() +
                "\nStatus: " + status;
    }
}
