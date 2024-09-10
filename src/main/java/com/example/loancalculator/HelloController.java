package com.example.loancalculator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    public TextField interestRate;
    public TextField years;
    public TextField amount;
    public TextField monthly;
    public TextField total;

    @FXML
    public void calculateLoan(){
        try { //make sure we only accept numbers
            //covert the string to a double
            double years1 = Double.parseDouble(years.getText());
            double amount1 = Double.parseDouble(amount.getText());
            double interestRate1 = Double.parseDouble(interestRate.getText()) / 100 / 12;
//loan equation
            double totalMonthly = amount1 * interestRate1 * (Math.pow(1 + interestRate1, (years1 * 12))) / (Math.pow(1 + interestRate1, (years1 * 12)) - 1);
            monthly.setText(String.valueOf(totalMonthly));
//set the text
            double totalAmount = totalMonthly * years1 * 12;
            total.setText(String.valueOf(totalAmount));
        }
        catch (NumberFormatException e){
            monthly.setText("Invalid input");
            total.setText("Invalid input");
        }


    }
}