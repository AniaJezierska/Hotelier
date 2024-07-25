package com.example.hoteler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa reprezentująca gościa, dziedzicząca po klasie Person i implementująca interfejs IGuest.
 */
public class Guest extends Person implements IGuest {
    private String email;
    private String phoneNumber;
    private String address;
    public PersonType personType;
    private List<Ticket> tickets = new ArrayList<>(); // Lista zgłoszeń przypisanych do gościa

    /**
     * Konstruktor klasy Guest.
     * @param firstName imię gościa
     * @param lastName nazwisko gościa
     * @param birthDate data urodzenia gościa
     * @param email adres email gościa
     * @param phoneNumber numer telefonu gościa
     * @param address adres zamieszkania gościa
     */
    public Guest(String firstName, String lastName, LocalDate birthDate, String email, String phoneNumber, String address) {
        super(firstName, lastName, birthDate, PersonType.Guest);
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    /**
     * Konstruktor kopiujący dla klasy Guest.
     * @param prevPerson obiekt klasy Person, którego dane zostaną skopiowane
     * @param email adres email gościa
     * @param phoneNumber numer telefonu gościa
     * @param address adres zamieszkania gościa
     */
    public Guest(Person prevPerson, String email, String phoneNumber, String address) {
        super(prevPerson.firstName, prevPerson.lastName, prevPerson.birthDate, PersonType.Guest);
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    /**
     * Zwraca adres email gościa.
     * @return adres email gościa
     */
    public String getEmail() {
        return email;
    }

    /**
     * Ustawia adres email gościa.
     * @param email nowy adres email gościa
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Zwraca numer telefonu gościa.
     * @return numer telefonu gościa
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Ustawia numer telefonu gościa.
     * @param phoneNumber nowy numer telefonu gościa
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Zwraca adres zamieszkania gościa.
     * @return adres zamieszkania gościa
     */
    public String getAddress() {
        return address;
    }

    /**
     * Ustawia adres zamieszkania gościa.
     * @param address nowy adres zamieszkania gościa
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Zwraca listę zgłoszeń przypisanych do gościa.
     * @return lista zgłoszeń
     */
    public List<Ticket> getTickets() {
        return tickets;
    }

    /**
     * Dodaje zgłoszenie do listy zgłoszeń gościa.
     * @param ticket zgłoszenie do dodania
     */
    public void addTicket(Ticket ticket) {
        if (!tickets.contains(ticket)) {
            tickets.add(ticket);
            ticket.setGuest(this); // Ustawiamy gościa dla zgłoszenia
        }
    }

    /**
     * Usuwa zgłoszenie z listy zgłoszeń gościa.
     * @param ticket zgłoszenie do usunięcia
     */
    public void removeTicket(Ticket ticket) {
        if (tickets.contains(ticket)) {
            tickets.remove(ticket);
            ticket.setGuest(null); // Usuwamy referencję do gościa dla zgłoszenia
        }
    }

    /**
     * Metoda do wyświetlania szczegółowych informacji o gościu.
     */
    @Override
    public void showDetails() {
        System.out.println("Guest: " + firstName + " " + lastName);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Address: " + address);
    }

    @Override
    public void setAsUndercover() {

    }

    @Override
    public void showGuestDetails() {

    }

/*
    @Override
    public void setAsUndercover() {
        // Implementacja dla interfejsu IGuest
        System.out.println("Setting guest as undercover...");
    }

    @Override
    public void showGuestDetails() {
        showDetails();
    }

 */
}


