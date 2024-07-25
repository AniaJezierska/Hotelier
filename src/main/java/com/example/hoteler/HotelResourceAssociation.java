package com.example.hoteler;

import java.io.Serializable;

/**
 * Klasa reprezentująca powiązanie zasobu (Resource) hotelowego zasobu (HotelResource).
 * Asocjacja ta określa ilość danego zasobu przypisanego do danego hotelowego zasobu.
 */
public class HotelResourceAssociation extends ObjectPlus implements Serializable {

    private Resource resource; // Zasób, który jest powiązany z hotelem
    private HotelResource hotelResource; // Hotelowy zasób, do którego przypisany jest zasób
    private int quantity; // Ilość danego zasobu przypisanego do hotelowego zasobu

    /**
     * Konstruktor inicjujący nowe powiązanie zasobu hotelowego z danym zasobem.
     *
     * @param resource      Zasób, który jest przypisywany do hotelowego zasobu
     * @param quantity      Ilość danego zasobu
     * @param hotelResource Hotelowy zasób, do którego przypisany jest zasób
     */
    public HotelResourceAssociation(Resource resource, int quantity, HotelResource hotelResource) {
        this.hotelResource = hotelResource;
        this.resource = resource;
        this.quantity = quantity;
    }

    /**
     * Metoda zwracająca hotelowy zasób, do którego przypisany jest dany zasób.
     *
     * @return Hotelowy zasób
     */
    public HotelResource getHotelResource() {
        return hotelResource;
    }

    /**
     * Metoda do ustawiania zasobu (nieużywana w tej implementacji).
     *
     * @param resource Zasób do ustawienia
     */
    public void setResource(Resource resource) {
    }

    /**
     * Metoda zwracająca zasób przypisany do hotelowego zasobu.
     *
     * @return Zasób przypisany do hotelowego zasobu
     */
    public Resource getResource() {
        return resource;
    }

    /**
     * Metoda zwracająca ilość danego zasobu przypisanego do hotelowego zasobu.
     *
     * @return Ilość zasobu
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Metoda do ustawiania ilości danego zasobu przypisanego do hotelowego zasobu.
     *
     * @param quantity Ilość zasobu do ustawienia
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}


