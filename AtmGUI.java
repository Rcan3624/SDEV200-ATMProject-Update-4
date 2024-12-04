package com.example.atmprojectgui;// Java Program to create RadioButton, add it to a ToggleGroup and add a listener to it
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.*;
import javafx.collections.*;
import javafx.stage.Stage;
import javafx.scene.text.Text.*;
import javafx.scene.text.*;
import javafx.beans.value.*;
public class AtmGUI extends Application {

    // launch the application
    public void start(Stage s)
    {
        // set title for the stage
        s.setTitle("ATM Project");

        // create a tile pane
        TilePane r = new TilePane();

        // create a label
        Label l = new Label("This is a basic example of the ATM GUI ");
        Label l2 = new Label("nothing selected");

        // create a toggle group
        ToggleGroup tg = new ToggleGroup();

        // create radiobuttons
        RadioButton rbDeposit = new RadioButton("Deposit");
        RadioButton rbWithdraw = new RadioButton("Withdraw");
        RadioButton rbchkBalance = new RadioButton("Check Balance");
        RadioButton rbTransfer = new RadioButton("Transfer");

        // add radiobuttons to toggle group
        rbDeposit.setToggleGroup(tg);
        rbWithdraw.setToggleGroup(tg);
        rbchkBalance.setToggleGroup(tg);
        rbTransfer.setToggleGroup(tg);


        // add label
        r.getChildren().add(l);
        r.getChildren().add(rbDeposit);
        r.getChildren().add(rbWithdraw);
        r.getChildren().add(rbchkBalance);
        r.getChildren().add(rbTransfer);
        r.getChildren().add(l2);

        // create a scene
        Scene sc = new Scene(r, 200, 200);

        // add a change listener
        tg.selectedToggleProperty().addListener(new ChangeListener<Toggle>()
        {
            public void changed(ObservableValue<? extends Toggle> ob,
                                Toggle o, Toggle n)
            {

                RadioButton rb = (RadioButton)tg.getSelectedToggle();

                if (rb != null) {
                    String s = rb.getText();

                    // change the label
                    l2.setText(s + " selected");
                }
            }
        });

        // set the scene
        s.setScene(sc);

        s.show();
    }

    public static void main(String args[])
    {
        // launch the application
        launch(args);
    }
}
