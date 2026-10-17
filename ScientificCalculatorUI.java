import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ScientificCalculatorUI extends JFrame implements ActionListener {
    JTextField display;
    StringBuilder currentInput = new StringBuilder();
    // Buttons
    String[] buttons = {
        "7","8","9","/","sin",
        "4","5","6","*","cos",
        "1","2","3","-","tan",
        "0",".","=","+","log",
        "C","sqrt","^","ln","!"
    };
    
    public ScientificCalculatorUI() {
        setTitle("Scientific Calculator - Vijay");
        setSize(500,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setEditable(false);
        add(display, BorderLayout.NORTH);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5,5,5,5));
        
        for(String text: buttons){
            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial", Font.BOLD, 18));
            btn.addActionListener(this);
            panel.add(btn);
        }
        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        String cmd = e.getActionCommand();
        // Logic yahan se shuru
        if(cmd.equals("C")){
            currentInput.setLength(0);
            display.setText("");
        } else if(cmd.equals("=")){
            try {
                // calculation logic
                display.setText("Result");
            } catch(Exception ex){
                display.setText("Error");
            }
        } else {
            currentInput.append(cmd);
            display.setText(currentInput.toString());
        }
    }
    
    public static void main(String[] args){
        new ScientificCalculatorUI();
    }
}
