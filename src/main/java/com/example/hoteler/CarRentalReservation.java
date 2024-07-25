package com.example.hoteler;

import java.time.LocalDate;

/**
 * Klasa reprezentująca rezerwację wypożyczenia samochodu, dziedzicząca po klasie Reservation.
 */
public class CarRentalReservation extends Reservation {
    private String carType; // Typ wypożyczanego samochodu
    private LocalDate pickupDate; // Data odbioru samochodu
    private LocalDate returnDate; // Data zwrotu samochodu

    /**
     * Konstruktor klasy CarRentalReservation.
     *
     * @param reservationId Numer identyfikacyjny rezerwacji
     * @param startDate     Data rozpoczęcia rezerwacji
     * @param endDate       Data zakończenia rezerwacji
     * @param roomNumber    Numer pokoju zarezerwowanego przez osobę
     * @param carType       Typ wypożyczanego samochodu
     * @param pickupDate    Data odbioru samochodu
     * @param returnDate    Data zwrotu samochodu
     * @param person        Osoba dokonująca rezerwacji
     */
    public CarRentalReservation(int reservationId, LocalDate startDate, LocalDate endDate, String roomNumber, String carType, LocalDate pickupDate, LocalDate returnDate, Person person) {
        super(reservationId, startDate, endDate, roomNumber, person);
        this.carType = carType;
        this.pickupDate = pickupDate;
        this.returnDate = returnDate;
    }

    /**
     * Ustawia typ wypożyczanego samochodu.
     *
     * @param carType Typ wypożyczanego samochodu
     */
    public void setCarType(String carType) {
        this.carType = carType;
    }

    /**
     * Zwraca typ wypożyczanego samochodu.
     *
     * @return Typ wypożyczanego samochodu
     */
    public String getCarType() {
        return carType;
    }

    /**
     * Ustawia datę odbioru samochodu.
     *
     * @param pickupDate Data odbioru samochodu
     */
    public void setPickupDate(LocalDate pickupDate) {
        this.pickupDate = pickupDate;
    }

    /**
     * Zwraca datę odbioru samochodu.
     *
     * @return Data odbioru samochodu
     */
    public LocalDate getPickupDate() {
        return pickupDate;
    }

    /**
     * Ustawia datę zwrotu samochodu.
     *
     * @param returnDate Data zwrotu samochodu
     */
    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    /**
     * Zwraca datę zwrotu samochodu.
     *
     * @return Data zwrotu samochodu
     */
    public LocalDate getReturnDate() {
        return returnDate;
    }

    /**
     * Zwraca reprezentację tekstową obiektu CarRentalReservation.
     *
     * @return Tekstowa reprezentacja obiektu CarRentalReservation
     */
    @Override
    public String toString() {
        return "CarRentalReservation: " + '\n' +
                getPerson()  +
                "Reservation ID: " + getReservationId() + '\n' +
                "Start date: " + getStartDate() + '\n' +
                "End date: " + getEndDate() + '\n' +
                "Room number: " + getRoomNumber() + '\n' +
                "Car type: " + carType + + '\n' +
                "Pickup date: " + pickupDate + '\n' +
                "Return date: " + returnDate;
    }
}
