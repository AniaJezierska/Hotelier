package com.example.hoteler;

import java.time.LocalDate;

/**
 * Klasa reprezentująca pracownika 'pod przykryciem', który jest jednocześnie gościem hotelowym.
 * Rozszerza klasę Employee i implementuje interfejs IGuest.
 */
public class UndercoverEmployee extends Employee implements IGuest {
    private Guest guest;
    private boolean isUndercover;

    /**
     * Konstruktor klasy UndercoverEmployee.
     *
     * @param firstName  Imię pracownika
     * @param lastName   Nazwisko pracownika
     * @param birthDate  Data urodzenia pracownika
     * @param position   Stanowisko pracownika
     * @param salary     Pensja pracownika
     * @param bonus      Premia pracownika
     * @param guest      Gość, który jest jednocześnie pracownikiem 'pod przykryciem'
     */
    public UndercoverEmployee(String firstName, String lastName, LocalDate birthDate,
                              String position, double salary, double bonus, Guest guest) {
        super(firstName, lastName, birthDate, position, salary, bonus);
        this.guest = guest;
        this.isUndercover = false;
        setPersonKind(PersonType.Employee, PersonType.Guest);
    }

    /**
     * Metoda wyświetlająca szczegóły pracownika 'pod przykryciem'.
     */
    @Override
    public void showDetails() {
        super.showDetails();
        System.out.println();
        System.out.println(">> Undercover Employee:");
        System.out.println("Name: " + guest.firstName + " " + guest.lastName);
        System.out.println("Birth Date: " + guest.birthDate);
        System.out.println("Email: " + guest.getEmail());
        System.out.println("Phone Number: " + guest.getPhoneNumber());
        System.out.println("Address: " + guest.getAddress());
    }

    /**
     * Metoda ustawiająca pracownika jako 'pod przykryciem'.
     * Implementacja w tej klasie nie jest jeszcze dostarczona.
     */
    @Override
    public void setAsUndercover() {
    }

    /**
     * Metoda wyświetlająca szczegóły gościa.
     * Implementacja w tej klasie nie jest jeszcze dostarczona.
     */
    @Override
    public void showGuestDetails() {
    }
}


