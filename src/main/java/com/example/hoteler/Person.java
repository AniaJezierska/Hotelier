package com.example.hoteler;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

enum PersonType {Person, Employee, Guest};

/**
 * Abstrakcyjna klasa reprezentująca osobę.
 */
public abstract class Person extends ObjectPlus implements Serializable {
    public String firstName;
    public String lastName;
    public LocalDate birthDate;
    private EnumSet<PersonType> personKind =  EnumSet.of(PersonType.Person);
    private List<Reservation> reservations = new ArrayList<>();
    private static Set<Reservation> allReservations = new HashSet<>();

    /**
     * Konstruktor klasy Person.
     * @param firstName imię osoby
     * @param lastName nazwisko osoby
     * @param birthDate data urodzenia osoby
     * @param types rodzaj osoby (np. Employee, Guest)
     */
    public Person(String firstName, String lastName, LocalDate birthDate, PersonType... types) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        setPersonKind(types);
    }

    /**
     * Metoda abstrakcyjna do wyświetlania szczegółów osoby.
     */
    public abstract void showDetails();

    /**
     * Ustawia rodzaj osoby na podstawie przekazanych typów.
     * @param types rodzaje osoby
     */
    public void setPersonKind(PersonType... types) {
        personKind.clear();
        personKind.addAll(EnumSet.of(types[0], types));
    }

    /**
     * Zwraca zbiór rodzajów tej osoby.
     * @return zbiór rodzajów osoby
     */
    public EnumSet<PersonType> getPersonKind() {
        return personKind;
    }


    /**
     * Dodaje rezerwację do listy rezerwacji osoby, jeśli jeszcze jej tam nie ma.
     * @param reservation rezerwacja do dodania
     * @throws Exception gdy rezerwacja jest już powiązana z inną osobą
     */
    public void addReservation(Reservation reservation) throws Exception {
        if (!reservations.contains(reservation)) {
            if(allReservations.contains(reservation)) {
                throw new Exception("The reservation is already connected with a person!");
            }
            reservations.add(reservation);
            allReservations.add(reservation);
        }
    }

    /**
     * Usuwa rezerwację z listy rezerwacji osoby.
     * @param reservation rezerwacja do usunięcia
     * @throws Exception gdy rezerwacja nie jest powiązana z tą osobą
     */
    public void cancelReservation(Reservation reservation) throws Exception {
        if(!reservations.contains(reservation)) {
            if(allReservations.contains(reservation)) {
                throw new Exception("The reservation is already connected with a person!");
            }
            reservations.remove(reservation);
            allReservations.remove(reservation);
        }
    }

    /**
     * Zwraca listę rezerwacji tej osoby.
     * @return lista rezerwacji
     */
    public List<Reservation> getReservations() {
        return reservations;
    }

    /**
     * Przesłonięta metoda toString zwracająca tekstową reprezentację obiektu.
     * @return tekstowa reprezentacja osoby
     */
    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append("Person: ").append(firstName).append(" ").append(lastName).append("\n");
        for (Reservation reservation : reservations) {
            info.append("Reservation: ").append(reservation.toString()).append("\n");
        }
        return info.toString();
    }
}

