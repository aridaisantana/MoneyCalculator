/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moneycalculator.main;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import moneycalculator.controller.Command;
import moneycalculator.model.Currency;
import moneycalculator.view.MoneyDialog;
import moneycalculator.view.MoneyDisplay;
import moneycalculator.view.swing.SwingMoneyDialog;
import moneycalculator.view.swing.SwingMoneyDisplay;

/**
 *
 * @author aridai
 */
public class MainFrame  extends JFrame{
    
    private final Map<String,Command> commands = new HashMap<>();
    private final Currency[] currencies;
    private MoneyDialog moneyDialog;
    private MoneyDisplay moneyDisplay;
    
    public MainFrame(Currency [] currencies){
        this.currencies = currencies;
        this.setTitle("Money Calculator");
        this.setSize(400,400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(moneyDialog(), BorderLayout.NORTH);
        this.add(moneyDisplay(), BorderLayout.CENTER);
        this.add(toolbar(), BorderLayout.SOUTH);
        this.setVisible(true);
    }
    
    public void add( Command command){
            commands.put(command.name(), command);
    }
    
    public MoneyDialog getMoneyDialog(){
        return moneyDialog;
    }
    
    public MoneyDisplay getMoneyDisplay(){
        return moneyDisplay;
    }

    private Component moneyDialog() {
         SwingMoneyDialog dialog = new SwingMoneyDialog(currencies);
         moneyDialog = dialog;
         return dialog;
         
    }

    private Component moneyDisplay() {
         SwingMoneyDisplay display = new SwingMoneyDisplay();
         moneyDisplay = display;
         return display;
    }

    private Component toolbar() {
       JPanel panel = new JPanel();
       panel.add(calculateButton());
       return panel;
    }

    private JButton calculateButton() {
          JButton button = new JButton("Calculate");
          button.addActionListener(calculate());
          return button;
    }

    private ActionListener calculate() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get("calculate").execute();
            }
        };
    }
}
