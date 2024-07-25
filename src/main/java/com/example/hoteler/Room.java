package com.example.hoteler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa reprezentująca pokój w hotelu.
 */
class Room extends ObjectPlus implements Serializable {
    private String roomNumber; // Numer pokoju
    private String type; // Typ pokoju
    private Hotel hotel; // Referencja do hotelu, do którego należy pokój
    private boolean available; // Określa dostępność pokoju
    private List<Reservation> reservations; // Lista rezerwacji dla tego pokoju

    /**
     * Konstruktor tworzący nowy pokój.
     *
     * @param hotel      Hotel, do którego należy pokój
     * @param roomNumber Numer pokoju
     * @param type       Typ pokoju
     */
    private Room(Hotel hotel, String roomNumber, String type) {
        this.hotel = hotel;
        this.type = type;
        this.roomNumber = roomNumber;
        this.available = true; // Na początku ustawiamy pokój jako dostępny
        this.reservations = new ArrayList<>();
    }

    /**
     * Metoda fabryczna do tworzenia nowego pokoju.
     *
     * @param hotel      Hotel, do którego należy pokój
     * @param roomNumber Numer pokoju
     * @param type       Typ pokoju
     * @return Nowo utworzony pokój
     * @throws Exception Jeżeli hotel nie istnieje
     */
    public static Room createRoom(Hotel hotel, String roomNumber, String type) throws Exception {
        if (hotel == null) {
            throw new Exception("The given hotel does not exist!");
        }
        Room room = new Room(hotel, roomNumber, type);
        hotel.addRoom(room);
        return room;
    }

    /**
     * Metoda dodająca rezerwację do pokoju.
     *
     * @param reservation Rezerwacja do dodania
     */
    public void addReservation(Reservation reservation) {
        if (!reservations.contains(reservation)) {
            reservations.add(reservation);
            reservation.setRoomNumber(this.roomNumber); // Ustawia numer pokoju w rezerwacji
        }
    }

    /**
     * Metoda usuwająca rezerwację z pokoju.
     *
     * @param reservation Rezerwacja do usunięcia
     */
    public void removeReservation(Reservation reservation) {
        reservations.remove(reservation);
        reservation.setRoomNumber(null); // Usuwa referencję do pokoju w rezerwacji
    }

    /**
     * Metoda zwracająca listę wszystkich rezerwacji przypisanych do pokoju.
     *
     * @return Lista rezerwacji
     */
    public List<Reservation> getReservations() {
        return reservations;
    }


    /**
     * Sprawdza dostępność pokoju.
     * @return true, jeśli pokój jest dostępny; false w przeciwnym razie
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * Ustawia dostępność pokoju.
     * @param available true, jeśli pokój ma być ustawiony jako dostępny; false w przeciwnym razie
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }

    /**
     * Zwraca listę dostępnych pokoi dla danego typu.
     * @param allRooms lista wszystkich pokoi
     * @param type typ pokoju do wyszukania
     * @return lista dostępnych pokoi dla danego typu
     */
    public static List<Room> getAvailableRooms(List<Room> allRooms, String type) {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : allRooms) {
            if (room.type.equals(type) && room.isAvailable()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    /**
     * Zwraca tekstową reprezentację pokoju, używaną do wyświetlania.
     * @return tekstowa reprezentacja pokoju
     */
    @Override
    public String toString() {
        return "Room: " + roomNumber;
    }
}

