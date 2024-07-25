package com.example.hoteler;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Klasa reprezentująca rezerwację w systemie hotelowym.
 */
public class Reservation extends ObjectPlus implements Serializable {
    private int reservationId;           // Identyfikator rezerwacji
    private LocalDate startDate;         // Data rozpoczęcia rezerwacji
    private LocalDate endDate;           // Data zakończenia rezerwacji
    private String roomNumber;           // Numer pokoju
    private Person person;               // Osoba dokonująca rezerwacji
    private int numberOfGuests;          // Liczba gości
    private String roomPreferences;      // Preferencje dotyczące pokoju
    private String specialRequests;      // Specjalne życzenia

    /**
     * Konstruktor tworzący nową rezerwację.
     *
     * @param reservationId   Identyfikator rezerwacji
     * @param startDate       Data rozpoczęcia rezerwacji
     * @param endDate         Data zakończenia rezerwacji
     * @param roomNumber      Numer pokoju
     * @param person          Osoba dokonująca rezerwacji
     */
    public Reservation(int reservationId, LocalDate startDate, LocalDate endDate, String roomNumber, Person person) {
        this.reservationId = reservationId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.roomNumber = roomNumber;
        this.person = person;
    }

    /**
     * Zwraca identyfikator rezerwacji.
     *
     * @return Identyfikator rezerwacji
     */
    public int getReservationId() {
        return reservationId;
    }

    /**
     * Ustawia identyfikator rezerwacji.
     *
     * @param reservationId Identyfikator rezerwacji
     */
    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    /**
     * Zwraca datę rozpoczęcia rezerwacji.
     *
     * @return Data rozpoczęcia rezerwacji
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * Ustawia datę rozpoczęcia rezerwacji.
     *
     * @param startDate Data rozpoczęcia rezerwacji
     */
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    /**
     * Zwraca datę zakończenia rezerwacji.
     *
     * @return Data zakończenia rezerwacji
     */
    public LocalDate getEndDate() {
        return endDate;
    }

    /**
     * Ustawia datę zakończenia rezerwacji.
     *
     * @param endDate Data zakończenia rezerwacji
     */
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    /**
     * Zwraca numer pokoju.
     *
     * @return Numer pokoju
     */
    public String getRoomNumber() {
        return roomNumber;
    }

    /**
     * Zwraca numer pokoju.
     *
     * @return Numer pokoju
     */
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    /**
     * Zwraca osobę dokonującą rezerwacji.
     *
     * @return Osoba dokonująca rezerwacji
     */
    public Person getPerson() {
        return person;
    }

    /**
     * Ustawia osobę dokonującą rezerwacji.
     *
     * @param person Osoba dokonująca rezerwacji
     */
    public void setPerson(Person person) {
        this.person = person;
    }

    /**
     * Zwraca liczbę gości.
     *
     * @return Liczba gości
     */
    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    /**
     * Ustawia liczbę gości.
     *
     * @param numberOfGuests Liczba gości
     */
    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    /**
     * Zwraca preferencje dotyczące pokoju.
     *
     * @return Preferencje dotyczące pokoju
     */
    public String getRoomPreferences() {
        return roomPreferences;
    }

    /**
     * Ustawia preferencje dotyczące pokoju.
     *
     * @param roomPreferences Preferencje dotyczące pokoju
     */
    public void setRoomPreferences(String roomPreferences) {
        this.roomPreferences = roomPreferences;
    }

    /**
     * Zwraca specjalne życzenia dotyczące rezerwacji.
     *
     * @return Specjalne życzenia
     */
    public String getSpecialRequests() {
        return specialRequests;
    }

    /**
     * Ustawia specjalne życzenia dotyczące rezerwacji.
     *
     * @param specialRequests Specjalne życzenia
     */
    public void setSpecialRequests(String specialRequests) {
        this.specialRequests = specialRequests;
    }

    /**
     * Metoda do walidacji daty rezerwacji.
     *
     * @return true, jeśli data rozpoczęcia jest wcześniejsza niż data zakończenia; false w przeciwnym razie
     */
    public boolean isValid() {
        return startDate != null && endDate != null && startDate.isBefore(endDate);
    }

    /**
     * Metoda do zapisywania rezerwacji w bazie danych.
     * Implementacja tej metody jest zależna od konkretnego systemu.
     */
    public void saveReservationToDatabase() {
        // Implementacja zapisu w bazie danych
    }

    /**
     * Metoda do pobierania rezerwacji z bazy danych na podstawie identyfikatora.
     * Implementacja tej metody jest zależna od konkretnego systemu.
     *
     * @param reservationId Identyfikator rezerwacji do pobrania
     * @return Obiekt rezerwacji z bazy danych lub null, jeśli nie znaleziono
     */
    public static Reservation loadReservationFromDatabase(int reservationId) {
        // Implementacja pobierania z bazy danych
        return null;
    }

    /**
     * Metoda do aktualizacji interfejsu użytkownika na podstawie zmian w rezerwacji.
     * Implementacja tej metody zależy od konkretnego interfejsu użytkownika.
     */
    public void updateUI() {
        // Implementacja aktualizacji interfejsu użytkownika
    }

    /**
     * Przesłonięta metoda zwracająca tekstową reprezentację obiektu rezerwacji.
     *
     * @return Tekstowa reprezentacja rezerwacji
     */
    @Override
    public String toString() {
        return "Reservation: " +
                "\nReservation ID: " + reservationId +
                "\nStart Date: " + startDate +
                "\nEnd Date: " + endDate +
                "\nRoom Number: " + roomNumber +
                "\nPerson: " + person +
                "\nNumber of Guests: " + numberOfGuests +
                "\nRoom Preferences: " + roomPreferences +
                "\nSpecial Requests: " + specialRequests;
    }
}

