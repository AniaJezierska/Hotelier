package com.example.hoteler;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Klasa reprezentująca niemodyfikowalną datę.
 * Implementuje interfejs Serializable, co pozwala na serializację obiektów tej klasy.
 */
public class CustomDate implements Serializable {
    private LocalDate date;

    /**
     * Konstruktor inicjalizujący obiekt klasy CustomDate podaną datą.
     *
     * @param date data do ustawienia
     */
    public CustomDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Metoda zwracająca przechowywaną datę.
     *
     * @return przechowywana data
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Metoda ustawiająca nową datę.
     *
     * @param date nowa data do ustawienia
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Przesłonięta metoda toString, zwracająca datę w formie tekstowej.
     *
     * @return data w formie tekstowej
     */
    @Override
    public String toString() {
        return date.toString();
    }
}
