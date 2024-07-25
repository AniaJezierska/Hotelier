package com.example.hoteler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa reprezentująca zamówienie w systemie hotelarskim.
 */
public class Order extends ObjectPlus implements Serializable {
    private int id;
    private String name;
    private List<Resource> resources = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();

    /**
     * Konstruktor tworzący nowe zamówienie.
     *
     * @param id   identyfikator zamówienia
     * @param name nazwa zamówienia
     */
    public Order(int id, String name) {
        this.id = id;
        this.name = name;
        this.resources = new ArrayList<>();
    }

    /**
     * Metoda dodająca zasób do zamówienia.
     *
     * @param resource zasób do dodania
     */
    public void addResource(Resource resource) {
        if (!resources.contains(resource)) {
            resources.add(resource);
            resource.addOrder(this);
        }
    }

    /**
     * Metoda usuwająca zasób z zamówienia.
     *
     * @param resource zasób do usunięcia
     */
    public void removeResource(Resource resource) {
        if (resources.contains(resource)) {
            resources.remove(resource);
            resource.removeOrder(this);
        }
    }

    /**
     * Metoda dodająca pracownika do zamówienia.
     *
     * @param employee pracownik do dodania
     */
    public void addEmployee(Employee employee) {
        if (!employees.contains(employee)) {
            employees.add(employee);
            employee.addOrder(this); // Połączenie zwrotne
        }
    }

    /**
     * Metoda dodająca pracownika do zamówienia.
     *
     * @param employee pracownik do dodania
     */
    public void removeEmployee(Employee employee) {
        if (employees.contains(employee)) {
            employees.remove(employee);
            employee.removeOrder(this); // Usunięcie połączenia zwrotnego
        }
    }

    /**
     * Metoda zwracająca nazwę zamówienia.
     *
     * @return nazwa zamówienia
     */
    public String getName() {
        return name;
    }
}




