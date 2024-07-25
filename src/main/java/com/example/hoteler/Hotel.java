package com.example.hoteler;

import java.io.Serializable;
import java.util.*;

/**
 * Klasa reprezentująca hotel.
 */
public class Hotel extends ObjectPlus implements Serializable {
    private String name;
    private Map<Integer, HotelResource> resources = new HashMap<Integer, HotelResource>(); // Mapa zasobów hotelowych
    private List<Room> rooms; // Lista pokoi w hotelu

    private static Set<Room> allRooms = new HashSet<>(); // Zbiór wszystkich pokoi we wszystkich hotelach

    /**
     * Konstruktor inicjalizujący nazwę hotelu.
     * @param name nazwa hotelu
     */
    public Hotel(String name) {
        this.name = name;
        this.rooms = new ArrayList<>(); // Inicjalizacja listy pokoi
    }

    /**
     * Metoda zwracająca nazwę hotelu.
     * @return nazwa hotelu
     */
    public String getName() {
        return name;
    }


    /**
     * Metoda zwracająca mapę zasobów hotelowych.
     * @return mapa zasobów
     */
    public Map<Integer, HotelResource> getResources() {
        return resources;
    }

    /**
     * Metoda statyczna do tworzenia nowego obiektu hotelu.
     * @param name nazwa hotelu
     * @return nowy obiekt hotelu
     */
    public static Hotel createHotel(String name) {
        return new Hotel(name);
    }

    /*
    public void addResource(Resource newResource) {
        // Sprawdź, czy już mamy te zasoby
        if (!resources.containsKey(newResource.getId())) {
            resources.put(newResource.getId(), newResource);

            // Dodaj odwrotne połączenie
            newResource.addHotel(this);
        }
    }
 =
     */

    /**
     * Metoda wyszukująca zasób hotelowy po jego identyfikatorze.
     * @param resourceId identyfikator zasobu
     * @return zasób hotelowy
     * @throws Exception wyjątek rzucany, gdy zasób o podanym identyfikatorze nie istnieje
     */
    public HotelResource findResource(int resourceId) throws Exception {
        // Sprawdź, czy mamy te zasoby
        if (!resources.containsKey(resourceId)) {
            throw new Exception("Unable to find a resource with id: " + resourceId);
        }

        return resources.get(resourceId);
    }

    /**
     * Metoda dodająca pokój do hotelu.
     * @param room pokój do dodania
     * @throws Exception wyjątek rzucany, gdy pokój jest już powiązany z innym hotelem
     */
    public void addRoom(Room room) throws Exception {
        if(!rooms.contains(room)) {
            // Sprawdzenie, czy pokój nie jest już przypisany do innego hotelu
            if(allRooms.contains(room)) {
                throw new Exception("The part is already connected with a whole!");
            }
            rooms.add(room); // Dodanie pokoju do listy pokoi hotelowych
            allRooms.add(room); // Dodanie pokoju do globalnej listy wszystkich pokoi
        }
    }

    /**
     * Metoda dodająca zasób hotelowy do hotelu.
     * @param hotelResource zasób hotelowy do dodania
     */
    public void addHotelResource(HotelResource hotelResource) {
        resources.put(hotelResource.getId(), hotelResource); // Dodanie zasobu do mapy zasobów hotelowych
        hotelResource.addHotel(this); // Ustawienie referencji do hotelu w zasobie hotelowym
    }

    @Override
    public String toString() {
        return "Hotel: " + name + ", Rooms: " + rooms.size();
    }
}




