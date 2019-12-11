/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MoneyCalculator;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author aridai
 */
public class SwingDisplay extends JFrame implements Display  {
    
    private final Currency [] currencies;
    private JLabel amountLabel;
    private JComboBox firstComboCurrency;
    private JComboBox secondComboCurrency;
    private JButton done;
    private JTextField amountText;
    private JTextField result;
    
    public SwingDisplay( final Currency [] currencies){
        this.currencies = currencies;
        setTitle("Money Calculator");
        
        iniciarComponentes();
        createPanel();
        
        
        
        done.addActionListener(new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent e) {
                String fromS,toS;
                Currency from = null;
                Currency to = null;
                
                double amount = Double.parseDouble(amountText.getText());
                Money money = new Money( amount, currencies[1]);
                
                fromS = firstComboCurrency.getSelectedItem().toString();
                toS = secondComboCurrency.getSelectedItem().toString();
                
                for (int i = 0; i < currencies.length; i++) {
                    if(currencies[i].getName().equals(fromS)){
                        from = currencies[i];
                    }
                }
                
                for (int i = 0; i < currencies.length; i++) {
                    if(currencies[i].getName().equals(toS)){
                        to = currencies[i];
                    }
                }
        
                ExchangeRate exchangerate = new ExchangeRate();
                double exchangeRate = 0;
                
                try {
                    exchangeRate = exchangerate.getExchangeRate(from, to);
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
                double exchange = money.getAmount() * exchangeRate;
                result.setText(String.format("%.2f", exchange));
         
            }
        });

        
        
        
    
        
        
    }
    
    public void display( ){
        this.setVisible(true);
    }

    public void iniciarComponentes(){
        amountLabel = new JLabel("Amount:");
        done = new JButton("Exchange");
        amountText = new JTextField(10);
        result = new JTextField(10);
        firstComboCurrency = new JComboBox();
        for (int i = 0; i < currencies.length; i++) {
            firstComboCurrency.addItem(currencies[i].getName());
            
        }
        
        secondComboCurrency = new JComboBox();
        for (int i = currencies.length - 1; i >= 0; i--) {
            secondComboCurrency.addItem(currencies[i].getName());
            
        }
    }
    
    public void createPanel(){
        
        JFrame frame = new JFrame();
        Container panel = getContentPane();
	panel.setLayout(new FlowLayout());
        panel.add(amountLabel);
        panel.add(amountText);
        panel.add(firstComboCurrency);
        panel.add(secondComboCurrency);
        panel.add(done);
        panel.add(result);
        this.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        pack();
    }
    
    
    
}
