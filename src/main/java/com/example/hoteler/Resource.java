package com.example.hoteler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa reprezentująca zasób w systemie hotelowym.
 * Dziedziczy po klasie ObjectPlus i implementuje interfejs Serializable.
 */
public class Resource extends ObjectPlus implements Serializable {
    private int id;
    private String name;
    private List<Order> orders = new ArrayList<>(); // Lista zamówień dla tego zasobu
    private List<HotelResourceAssociation> associations; // Lista powiązań zasobu z hotelami

    /**
     * Konstruktor tworzący nowy zasób o podanym identyfikatorze i nazwie.
     * @param id identyfikator zasobu
     * @param name nazwa zasobu
     */
    public Resource(int id, String name) {
        this.id = id;
        this.name = name;
        this.orders = new ArrayList<>();
        this.associations = new ArrayList<>();
    }

    /**
     * Metoda zwracająca listę powiązań zasobu z hotelami.
     * @return lista powiązań zasobu z hotelami
     */
    public List<HotelResourceAssociation> getHotels() {
        return associations;
    } // Lista asocjacji z atrybutem

    /**
     * Metoda dodająca nowe powiązanie zasobu z hotelem.
     * @param association nowe powiązanie do dodania
     */
    public void addHotelResourceAssociation(HotelResourceAssociation association) {
        if (!associations.contains(association)) {
            associations.add(association);
            association.setResource(this);
        }
    }

    /**
     * Metoda dodająca zamówienie dla tego zasobu.
     * @param order zamówienie do dodania
     */
    public void addOrder(Order order) {
        if (!orders.contains(order)) {
            orders.add(order);
            order.addResource(this);
        }
    }

    /**
     * Metoda dodająca zamówienie dla tego zasobu.
     * @param order zamówienie do dodania
     */
    public void removeOrder(Order order) {
        if (orders.contains(order)) {
            orders.remove(order);
            order.removeResource(this);
        }
    }

    /**
     * Metoda zwracająca identyfikator zasobu.
     * @return identyfikator zasobu
     */
    public int getId() {
        return id;
    }

    /**
     * Metoda zwracająca nazwę zasobu.
     * @return nazwa zasobu
     */
    public String getName() {
        return name;
    }

    public void addHotel(Hotel hotel) {
    }
}
