package com.example.hoteler;

import java.io.Serializable;
import java.util.*;

/**
 * Klasa reprezentująca zasób hotelowy, zawierająca informacje o asocjacjach z atrybutem.
 */
public class HotelResource extends ObjectPlus implements Serializable {
    private int id;
    private String name;
    private List<HotelResourceAssociation> associations; // Lista asocjacji z atrybutem
    private Set<Hotel> hotels = new HashSet<>();

    /**
     * Konstruktor z dwoma parametrami.
     * @param id identyfikator zasobu
     * @param name nazwa zasobu
     */
    public HotelResource(int id, String name) {
        this.id = id;
        this.name = name;
        this.associations = new ArrayList<>();
    }

    /**
     * Konstruktor z jednym parametrem.
     * @param name nazwa zasobu
     */
    public HotelResource(String name) {
        this.name = name;
        this.associations = new ArrayList<>();
    }

    /**
     * Zwraca identyfikator zasobu.
     * @return identyfikator zasobu
     */
    public int getId() {
        return id;
    }

    /**
     * Zwraca nazwę zasobu.
     * @return nazwa zasobu
     */
    public String getName() {
        return name;
    }

    /**
     * Zwraca listę asocjacji z zasobami.
     * @return lista asocjacji
     */
    public List<HotelResourceAssociation> getResources() {
        return associations;
    }

    /**
     * Zwraca zbiór hoteli powiązanych z tym zasobem.
     * @return zbiór hoteli
     */
    public Set<Hotel> getHotels() {
        return hotels;
    }

    /**
     * Dodaje zasób do listy asocjacji z zasobami dla tego hotelu.
     * Dodaje również odwrotne połączenie, aby zasób mógł wiedzieć, z którym hotelem jest powiązany.
     * @param resource dodawany zasób
     * @param quantity ilość zasobu
     */
    public void addResource(Resource resource, int quantity) {
        HotelResourceAssociation association = new HotelResourceAssociation(resource, quantity, this);
        if (!associations.contains(association)) {
            associations.add(association);
            resource.addHotelResourceAssociation(association);
        }
    }

    /**
     * Dodaje hotel do zbioru hoteli powiązanych z tym zasobem.
     * Dodaje również odwrotne połączenie, aby hotel mógł wiedzieć, z jakimi zasobami jest powiązany.
     * @param hotel dodawany hotel
     */
    public void addHotel(Hotel hotel) {
        if (!hotels.contains(hotel)) {
            hotels.add(hotel);
            hotel.addHotelResource(this);
        }
    }
}

