package com.example.hoteler;

/**
 * Interfejs reprezentujący gościa hotelowego.
 */
public interface IGuest {

    /**
     * Ustawia status gościa jako tajny.
     * Implementujące klasy powinny dostarczyć własną implementację tej metody.
     */
    void setAsUndercover(); // domyślnie abstrakcyjne

    /**
     * Wyświetla szczegóły dotyczące gościa.
     * Implementujące klasy powinny dostarczyć własną implementację tej metody.
     */
    void showGuestDetails();
}
