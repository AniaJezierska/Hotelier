package com.example.hoteler;

import java.io.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws Exception {
        // Tworzenie nowego gościa
        Person guest = new Guest("John", "Doe", LocalDate.of(1990, 5, 15), "john@example.com", "123456789", "123 Main St");

        // Tworzenie nowej rezerwacji
        Reservation reservation = new Reservation(1, LocalDate.now(), LocalDate.now().plusDays(3), "101", guest);
        reservation.setNumberOfGuests(2);
        reservation.setRoomPreferences("Non-smoking room");
        reservation.setSpecialRequests("Extra towels");

        // Wyświetlanie rezerwacji
        System.out.println(reservation);


        // Zapis do pliku
        final String extentFile = "src/main/hotelier-extent.ser";

        var emp1 = new Employee("John", "Doe", LocalDate.of(1985, 1, 1), "Manager", 5000, 500);
        var res1 = new Reservation(1, LocalDate.of(2023, 5, 10), LocalDate.of(2023, 5, 20), "101", emp1);


        // test trwałości ekstensji (przy użyciu serializacji)
        try {
            // Write the extent to the given stream
            var out = new ObjectOutputStream(new FileOutputStream(extentFile));
            ObjectPlus.writeExtents(out);
            out.close();

            // Read the extent from the given stream
            var in = new ObjectInputStream(new FileInputStream(extentFile));
            ObjectPlus.readExtents(in);
            in.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        Helpdesk helpdesk = new Helpdesk();

        Employee emp2 = new Employee("Jane", "Smith", LocalDate.of(1990, 4, 10), "Developer", 4500, 300);

        helpdesk.addEmployee(emp1);
        helpdesk.addEmployee(emp2);

        // Wyświetlanie wszystkich pracowników przypisanych do Helpdesk
        System.out.println("Employees in Helpdesk:");
        for (Employee emp : helpdesk.getEmployees()) {
            emp.showDetails();
        }

        // Sprawdzanie, do którego Helpdesk przypisany jest pracownik
        System.out.println("Helpdesk for employee John Doe: " + emp1.getHelpdesk());
        System.out.println("Helpdesk for employee Jane Smith: " + emp2.getHelpdesk());
    }
}


