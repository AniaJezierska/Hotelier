package com.example.hoteler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Klasa reprezentująca pracownika w systemie hotelowym.
 * Rozszerza klasę Person o dodatkowe informacje specyficzne dla pracowników.
 */
public class Employee extends Person {
    private String position; // Stanowisko pracownika
    private List<String> skills; // Lista umiejętności pracownika
    private double salary; // Wynagrodzenie pracownika
    private static double minSalary = 4000.0; // Minimalne wynagrodzenie
    private double bonus; // Premia pracownika
    public PersonType personType; // Typ osoby

    private List<Reservation> reservations = new ArrayList<>(); // Lista rezerwacji pracownika
    private List<Order> orders = new ArrayList<>(); // Lista zamówień pracownika
    private static Set<Reservation> allReservations = new HashSet<>(); // Wszystkie rezerwacje w systemie
    private Helpdesk helpdesk; // Referencja do Helpdesku, do którego jest przypisany pracownik

    /**
     * Konstruktor klasy Employee.
     * @param firstName Imię pracownika
     * @param lastName Nazwisko pracownika
     * @param birthDate Data urodzenia pracownika
     * @param position Stanowisko pracownika
     * @param salary Wynagrodzenie pracownika
     * @param bonus Premia pracownika
     */
    public Employee(String firstName, String lastName, LocalDate birthDate, String position, double salary, double bonus) {
        super(firstName, lastName, birthDate, PersonType.Employee);
        this.position = position;
        this.skills = skills;
        this.salary = salary;
        this.bonus = bonus;
        if (this.salary < minSalary) {
            this.salary = minSalary;
        }
    }

    /**
     * Konstruktor kopiujący klasy Employee.
     * @param prevPerson Obiekt klasy Person, z którego kopiowane są podstawowe informacje o pracowniku
     * @param position Stanowisko pracownika
     * @param skills Lista umiejętności pracownika
     * @param salary Wynagrodzenie pracownika
     * @param bonus Premia pracownika
     */
    public Employee(Person prevPerson, String position, List<String> skills, double salary, double bonus) {
        super(prevPerson.firstName, prevPerson.lastName, prevPerson.birthDate, PersonType.Employee);
        this.position = position;
        this.skills = skills;
        this.salary = salary;
        this.bonus = bonus;
        if (this.salary < minSalary) {
            this.salary = minSalary;
        }
    }

    /**
     * Metoda dodająca rezerwację pracownika.
     * @param reservation Rezerwacja do dodania
     * @throws Exception Wyjątek w przypadku próby dodania już istniejącej rezerwacji
     */
    public void addReservation(Reservation reservation) throws Exception {
        if (!reservations.contains(reservation)) {
            if(allReservations.contains(reservation)) {
                throw new Exception("The reservation is already connected with a person!");
            }
            reservations.add(reservation);
            allReservations.add(reservation);
        }
    }

    /**
     * Metoda usuwająca rezerwację pracownika.
     * @param reservation Rezerwacja do usunięcia
     * @throws Exception Wyjątek w przypadku próby usunięcia nieistniejącej rezerwacji
     */
    public void cancelReservation(Reservation reservation) throws Exception {
        if(!reservations.contains(reservation)) {
            if(allReservations.contains(reservation)) {
                throw new Exception("The reservation is already connected with a person!");
            }
            reservations.remove(reservation);
            allReservations.remove(reservation);
        }
    }

    /**
     * Metoda zwracająca listę rezerwacji pracownika.
     * @return Lista rezerwacji
     */
    public List<Reservation> getReservations() {
        return reservations;
    }

    /**
     * Metoda ustawiająca wynagrodzenie pracownika.
     * @param salary Nowe wynagrodzenie
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Metoda ustawiająca premię pracownika.
     * @param bonus Nowa premia
     */
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    /**
     * Metoda zwracająca wynagrodzenie pracownika.
     * @return Wynagrodzenie
     */
    public double getSalary(){
        return salary;
    };

    /**
     * Metoda zwracająca premię pracownika.
     * @return Premia
     */
    public double getBonus() {
        return bonus;
    }

    /**
     * Metoda zwracająca listę umiejętności pracownika.
     * @return Lista umiejętności
     */
    public List<String> getSkills() {
        return skills;
    }

    /**
     * Metoda dodająca nową umiejętność pracownika.
     * @param newSkill Nowa umiejętność do dodania
     */
    public void addSkill(String newSkill) {
        if (skills == null) {
            skills = new ArrayList<>();
        }
        skills.add(newSkill);
    }

    /**
     * Przeciążona metoda dodająca listę umiejętności pracownika.
     * @param newSkills Lista nowych umiejętności do dodania
     */
    public void addSkill(List<String> newSkills) {
        if (skills == null) {
            skills = new ArrayList<>();
        }
        skills.addAll(newSkills);
    }

    /**
     * Metoda usuwająca umiejętność pracownika.
     * @param skillToRemove Umiejętność do usunięcia
     */
    public void removeSkill(String skillToRemove) {
        if (skills != null) {
            skills.remove(skillToRemove);
        }
    }

    /**
     * Metoda znajdująca pracowników z wynagrodzeniem powyżej określonego progu.
     * @param employees Lista pracowników do przeszukania
     * @param minSalary Minimalne wynagrodzenie
     * @return Lista pracowników spełniających warunek
     */
    public static List<Employee> findEmployeesWithSalaryAbove(List<Employee> employees, double minSalary) {
        return employees.stream()
                .filter(employee -> employee.getSalary() > minSalary)
                .collect(Collectors.toList());
    }

    /**
     * Metoda ustawiająca nowe wynagrodzenie dla wszystkich pracowników.
     * @param employees Lista pracowników do aktualizacji
     * @param newSalary Nowe wynagrodzenie
     */
    public static void setAllSalaries(List<Employee> employees, double newSalary) {
        employees.forEach(employee -> employee.setSalary(newSalary));
    }

    /**
     * Metoda ustawiająca referencję do Helpdesku dla pracownika.
     * @param helpdesk Referencja do Helpdesku
     */
    public void setHelpdesk(Helpdesk helpdesk) {
        this.helpdesk = helpdesk;
    }

    /**
     * Metoda zwracająca referencję do Helpdesku przypisanego do pracownika.
     * @return Referencja do Helpdesku
     */
    public Helpdesk getHelpdesk() {
        return helpdesk;
    }

    /**
     * Metoda dodająca zamówienie do pracownika.
     * @param order Zamówienie do dodania
     */
    public void addOrder(Order order) {
        if (!orders.contains(order)) {
            orders.add(order);
            order.addEmployee(this); // Połączenie zwrotne
        }
    }

    /**
     * Metoda usuwająca zamówienie z pracownika.
     * @param order Zamówienie do usunięcia
     */
    public void removeOrder(Order order) {
        if (orders.contains(order)) {
            orders.remove(order);
            order.removeEmployee(this); // Usunięcie połączenia zwrotnego
        }
    }

    /**
     * Przesłonięta metoda wyświetlająca szczegóły pracownika.
     */
    @Override
    public void showDetails() {
        System.out.println("Employee: " + firstName + " " + lastName);
        System.out.println("Position: " + position);
        System.out.println("Salary: " + salary);
        System.out.println("Bonus: " + bonus);
    }
}

