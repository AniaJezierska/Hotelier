package com.example.hoteler;

import java.time.LocalDate;

/**
 * Represents a room service reservation, extending the basic Reservation class.
 */
public class RoomServiceReservation extends Reservation {
    private String mealType; // Typ posiłku dla rezerwacji pokoju

    /**
     * Constructs a new RoomServiceReservation object.
     *
     * @param reservationId Unique identifier for the reservation.
     * @param startDate     Start date of the reservation.
     * @param endDate       End date of the reservation.
     * @param roomNumber    Number of the room reserved.
     * @param mealType      Type of meal included in the reservation.
     * @param person        Person who made the reservation.
     */
    public RoomServiceReservation(int reservationId, LocalDate startDate, LocalDate endDate, String roomNumber, String mealType, Person person) {
        super(reservationId, startDate, endDate, roomNumber, person);
        this.mealType = mealType;
    }

    /**
     * Retrieves the meal type associated with this room service reservation.
     *
     * @return The meal type.
     */
    public String getMealType() {
        return mealType;
    }

    /**
     * Returns a string representation of the RoomServiceReservation object.
     *
     * @return A string representation including reservation details.
     */
    @Override
    public String toString() {
        return "RoomServiceReservation: " + '\n' +
                getPerson() +
                "Reservation ID: " + getReservationId() + '\n' +
                "Start date: " + getStartDate() + '\n' +
                "End date: " + getEndDate() + '\n' +
                "Room number: " + getRoomNumber() + '\n' +
                "Meal type: " + mealType;
    }
}
