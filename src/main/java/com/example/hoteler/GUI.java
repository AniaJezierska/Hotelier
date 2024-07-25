package com.example.hoteler;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;

/**
 * Główna aplikacja obsługująca interfejs hoteliera.
 */
public class HelloApplication extends Application {

    private Stage primaryStage;
    // Pamięć podręczna dla wszystkich rezerwacji
    private Set<Reservation> allReservations = new HashSet<>();

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        showMainScreen();
    }

    /**
     * Metoda wyświetlająca główny ekran aplikacji.
     */
    private void showMainScreen() {
        primaryStage.setTitle("Main Screen");

        VBox mainLayout = createLayout();
        mainLayout.setAlignment(Pos.CENTER);
        mainLayout.setSpacing(20);

        Label titleLabel = new Label("Welcome to Hotelier");
        titleLabel.setFont(Font.font("Arial", 36));
        titleLabel.setTextFill(Color.WHITE);

        Button newReservationButton = createMenuButton("Book a Room", 24);
        Button helpdeskButton = createMenuButton("Support", 24);
        Button orderResourcesButton = createMenuButton("Order", 24);

        newReservationButton.setOnAction(e -> showNewReservationScreen());
        helpdeskButton.setOnAction(e -> showHelpdeskScreen());

        VBox.setMargin(orderResourcesButton, new Insets(0, 0, 30, 0));

        mainLayout.getChildren().addAll(titleLabel, newReservationButton, helpdeskButton, orderResourcesButton);

        Scene mainScene = new Scene(mainLayout, 1024, 768);
        // Kolor tła
        mainScene.setFill(Color.rgb(32, 178, 170));
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    /**
     * Tworzy układ VBox z określonym odstępem i centrowaniem.
     *
     * @return utworzony układ VBox
     */
    private VBox createLayout() {
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.setBackground(new Background(new BackgroundFill(
                LinearGradient.valueOf("linear-gradient(to bottom right, #20b2aa, #008080)"),
                CornerRadii.EMPTY, Insets.EMPTY)));
        return layout;
    }

    /**
     * Tworzy przycisk menu z określonym tekstem i rozmiarem czcionki.
     *
     * @param text     tekst przycisku
     * @param fontSize rozmiar czcionki
     * @return utworzony przycisk
     */
    private Button createMenuButton(String text, double fontSize) {
        Button button = new Button(text);
        button.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: #154c79; -fx-font-weight: bold; -fx-font-size: " + fontSize + "pt;");
        button.setPrefWidth(250);
        return button;
    }

    /**
     * Metoda wyświetlająca ekran rezerwacji nowego pokoju.
     */
    private void showNewReservationScreen() {
        primaryStage.setTitle("Book a Room");

        VBox reservationLayout = createLayout();
        reservationLayout.setPadding(new Insets(20));
        reservationLayout.setSpacing(20);

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(20));

        // Etykiety i pola
        String[] labels = {"First Name:", "Last Name:", "Email:", "Phone Number:",
                "Address:", "Check-in Date:", "Check-out Date:", "Number of Guests:",
                "Room Preferences:", "Special Requests:"};

        // Tworzenie dynamicznego interfejsu użytkownika
        for (int i = 0; i < labels.length; i++) {
            Label label = createLabel(labels[i]);
            gridPane.add(label, 0, i);

            if (i == 5) { // Wybór daty zameldowania
                DatePicker checkInDatePicker = new DatePicker();
                checkInDatePicker.setPrefWidth(200);
                gridPane.add(checkInDatePicker, 1, i);
            } else if (i == 6) { // Wybór daty wymeldowania
                DatePicker checkOutDatePicker = new DatePicker();
                checkOutDatePicker.setPrefWidth(200);
                gridPane.add(checkOutDatePicker, 1, i);
            } else { // Pola tekstowe dla innych pól
                TextField textField = new TextField();
                textField.setPrefWidth(300);
                gridPane.add(textField, 1, i);
            }
        }

        // Przyciski
        Button submitButton = createStyledButton("Submit", 18);
        submitButton.setOnAction(e -> {
            saveDataToFile();
            showRoomSelectionScreen();
        });

        Button backButton = createStyledButton("Back", 18);
        backButton.setOnAction(e -> showMainScreen());

        VBox buttonBox = new VBox(20, submitButton, backButton);
        buttonBox.setAlignment(Pos.CENTER);

        reservationLayout.getChildren().addAll(gridPane, buttonBox);

        Scene reservationScene = new Scene(reservationLayout, 1024, 768);
        reservationScene.setFill(Color.rgb(32, 178, 170));
        primaryStage.setScene(reservationScene);
    }

    /**
     * Tworzy etykietę z określonym tekstem i stylizacją.
     *
     * @param text tekst etykiety
     * @return utworzona etykieta
     */
    private Label createLabel(String text) {
        Label label = new Label(text);
        label.setStyle("-fx-font-weight: bold; -fx-font-size: 14pt; -fx-text-fill: #FFFFFF;");
        return label;
    }

    /**
     * Tworzy przycisk stylizowany z określonym tekstem i rozmiarem czcionki.
     *
     * @param text     tekst przycisku
     * @param fontSize rozmiar czcionki
     * @return utworzony przycisk
     */
    private Button createStyledButton(String text, double fontSize) {
        Button button = new Button(text);
        button.setStyle("-fx-background-color: #20b2aa; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: " + fontSize + "pt;");
        button.setPrefWidth(200);
        return button;
    }

    /**
     * Zapisuje dane rezerwacji do pliku.
     */
    private void saveDataToFile() {
        try (FileOutputStream fileOut = new FileOutputStream("hotelier-extent.ser");
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {

            objectOut.writeObject(allReservations);
            System.out.println("Data has been saved to hotelier-extent.ser");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Wyświetla ekran wyboru pokoju.
     */
    private void showRoomSelectionScreen() {
        primaryStage.setTitle("Room Selection");

        VBox roomSelectionLayout = createLayout();
        roomSelectionLayout.setPadding(new Insets(20));
        roomSelectionLayout.setSpacing(20);

        Button carRentalButton = createStyledButton("Rent a Car", 18);
        Button roomServiceButton = createStyledButton("Room Service", 18);

        ListView<String> roomListView = new ListView<>();
        ObservableList<String> rooms = FXCollections.observableArrayList("Room 101", "Room 102", "Room 103");
        roomListView.setItems(rooms);

        Button submitButton = createStyledButton("Submit", 18);
        submitButton.setOnAction(e -> showConfirmationScreen());

        Button backButton = createStyledButton("Previous Screen", 18);
        backButton.setOnAction(e -> showNewReservationScreen());

        VBox buttonBox = new VBox(20, carRentalButton, roomServiceButton, submitButton, backButton);
        buttonBox.setAlignment(Pos.CENTER);

        roomSelectionLayout.getChildren().addAll(buttonBox, roomListView);

        Scene roomSelectionScene = new Scene(roomSelectionLayout, 1024, 768);
        roomSelectionScene.setFill(Color.rgb(32, 178, 170));
        primaryStage.setScene(roomSelectionScene);
    }

    /**
     * Wyświetla ekran potwierdzenia rezerwacji.
     */
    private void showConfirmationScreen() {
        primaryStage.setTitle("Confirmation");

        VBox confirmationLayout = createLayout();
        confirmationLayout.setPadding(new Insets(20));
        confirmationLayout.setSpacing(20);

        Label confirmationLabel = createLabel("Reservation confirmed!");
        confirmationLabel.setFont(Font.font("Arial", 24));
        confirmationLabel.setTextFill(Color.WHITE);

        Button backButton = createStyledButton("Back", 18);
        backButton.setOnAction(e -> showMainScreen());

        confirmationLayout.getChildren().addAll(confirmationLabel, backButton);

        Scene confirmationScene = new Scene(confirmationLayout, 1024, 768);
        confirmationScene.setFill(Color.rgb(32, 178, 170));
        primaryStage.setScene(confirmationScene);
    }

    /**
     * Wyświetla ekran obsługi klienta.
     */
    private void showHelpdeskScreen() {
        primaryStage.setTitle("Customer Support");

        VBox helpdeskLayout = createLayout();
        helpdeskLayout.setPadding(new Insets(20));
        helpdeskLayout.setSpacing(20);

        ListView<String> ticketListView = new ListView<>();
        ObservableList<String> ticketObservableList = FXCollections.observableArrayList("Ticket 1", "Ticket 2", "Ticket 3");
        ticketListView.setItems(ticketObservableList);

        Button backButton = createStyledButton("Back", 18);
        backButton.setOnAction(e -> showMainScreen());

        helpdeskLayout.getChildren().addAll(ticketListView, backButton);

        Scene helpdeskScene = new Scene(helpdeskLayout, 1024, 768);
        helpdeskScene.setFill(Color.rgb(32, 178, 170));
        primaryStage.setScene(helpdeskScene);
    }

    /**
     * Metoda główna uruchamiająca aplikację.
     *
     * @param args argumenty wiersza poleceń
     */
    public static void main(String[] args) {
        launch(args);
    }
}




