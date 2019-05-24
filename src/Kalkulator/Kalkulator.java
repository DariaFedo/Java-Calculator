package Kalkulator;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class Kalkulator implements ActionListener {
	
	double number, answer;
	int calculation;
	
	/// DECLARING (creating) ALL OBJECTS FOR GUI ///
	
	JFrame frame;
	JTextField textField = new JTextField();
	JLabel label = new JLabel();
	
	JButton btn_0 = new JButton("0");
	JButton btn_1 = new JButton("1");
	JButton btn_2 = new JButton("2");
	JButton btn_3 = new JButton("3");
	JButton btn_4 = new JButton("4");
	JButton btn_5 = new JButton("5");
	JButton btn_6 = new JButton("6");
	JButton btn_7 = new JButton("7");
	JButton btn_8 = new JButton("8");
	JButton btn_9 = new JButton("9");
    JButton btn_dot = new JButton(".");
    JButton btn_Clear = new JButton("C");
    JButton btn_Del = new JButton("Del");
    JButton btn_Equal = new JButton("=");
    JButton btn_Mul = new JButton("x");
    JButton btn_Div = new JButton("/");
    JButton btn_Plus = new JButton("+");
    JButton btn_Minus = new JButton("-");
    
    /// CONSTRUCTOR WITH METHODS ///
    Kalkulator() {
        prepareGUI();
        addComponents();
        addActionsToButtons();
    }
    
    /// SET PROPERTIES OF JFRAME WINDOW /// 
    public void prepareGUI() {
    	
    	frame = new JFrame();
    	frame.setTitle("KALKULATOR");
    	frame.setVisible(true);
		frame.setSize(300, 420);
		frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.white);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		
    }
    
    public void addComponents() {
    	
    	/// DISPLAY ///
    	label.setBounds(250, 0, 50, 50);
        label.setForeground(Color.white);
        frame.add(label);
    	
        textField.setBounds(10, 10, 270, 60);
        textField.setFont(new Font("Arial", Font.BOLD, 20));
        textField.setEditable(false);
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        textField.setEnabled(true);
        frame.add(textField);
        
        /// 7
        btn_7.setBounds(10, 150, 60, 40);
        btn_7.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(btn_7);
     
        /// 8
        btn_8.setBounds(80, 150, 60, 40);
        btn_8.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(btn_8);

        /// 9
        btn_9.setBounds(150, 150, 60, 40);
        btn_9.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(btn_9);

        /// 4
        btn_4.setBounds(10, 210, 60, 40);
        btn_4.setFont(new Font("Arial", Font.BOLD, 20));
     	frame.add(btn_4);

     	/// 5
     	btn_5.setBounds(80, 210, 60, 40);
     	btn_5.setFont(new Font("Arial", Font.BOLD, 20));
     	frame.add(btn_5);

     	/// 6
     	btn_6.setBounds(150, 210, 60, 40);
     	btn_6.setFont(new Font("Arial", Font.BOLD, 20));
     	frame.add(btn_6);

     	/// 1
     	btn_1.setBounds(10, 270, 60, 40);
     	btn_1.setFont(new Font("Arial", Font.BOLD, 20));
     	frame.add(btn_1);

     	/// 2
     	btn_2.setBounds(80, 270, 60, 40);
     	btn_2.setFont(new Font("Arial", Font.BOLD, 20));
     	frame.add(btn_2);
     
     	/// 3
     	btn_3.setBounds(150, 270, 60, 40);
     	btn_3.setFont(new Font("Arial", Font.BOLD, 20));
     	frame.add(btn_3);

     	/// .
     	btn_dot.setBounds(150, 330, 60, 40);
     	btn_dot.setFont(new Font("Arial", Font.BOLD, 20));
     	frame.add(btn_dot);

     	/// 0
     	btn_0.setBounds(10, 330, 130, 40);
     	btn_0.setFont(new Font("Arial", Font.BOLD, 20));
     	frame.add(btn_0);

     	/// =
     	btn_Equal.setBounds(220, 330, 60, 40);
     	btn_Equal.setFont(new Font("Arial", Font.BOLD, 20));
     	btn_Equal.setBackground(Color.orange);
     	frame.add(btn_Equal);

     	/// /
     	btn_Div.setBounds(220, 90, 60, 40);
     	btn_Div.setFont(new Font("Arial", Font.BOLD, 20));
     	btn_Div.setBackground(Color.orange);
     	frame.add(btn_Div);

     	//Setting property of button X
     	btn_Mul.setBounds(220, 210, 60, 40);
     	btn_Mul.setFont(new Font("Arial", Font.BOLD, 20));
     	btn_Mul.setBackground(Color.orange);
     	frame.add(btn_Mul);

     	//Setting property of button -
     	btn_Minus.setBounds(220, 150, 60, 40);
     	btn_Minus.setFont(new Font("Arial", Font.BOLD, 20));
     	btn_Minus.setBackground(Color.orange);
     	frame.add(btn_Minus);

     	//Setting property of button +
     	btn_Plus.setBounds(220, 270, 60, 40);
     	btn_Plus.setFont(new Font("Arial", Font.BOLD, 20));
     	btn_Plus.setBackground(Color.orange);
     	frame.add(btn_Plus);

    
     	//Setting property of delete button
     	btn_Del.setBounds(80, 90, 130, 40);
     	btn_Del.setFont(new Font("Arial", Font.BOLD, 12));
     	btn_Del.setBackground(Color.red);
     	btn_Del.setForeground(Color.white);
     	frame.add(btn_Del);
     
     	//Setting property of clear button
     	btn_Clear.setBounds(10, 90, 60, 40);
     	btn_Clear.setFont(new Font("Arial", Font.BOLD, 12));
     	btn_Clear.setBackground(Color.red);
     	btn_Clear.setForeground(Color.white);
     	frame.add(btn_Clear);
        
            
         
    }

    public void addActionsToButtons() {
    
    	btn_0.addActionListener((ActionListener) this);
		btn_1.addActionListener((ActionListener) this);
		btn_2.addActionListener((ActionListener) this);
		btn_3.addActionListener((ActionListener) this);
		btn_4.addActionListener((ActionListener) this);
		btn_5.addActionListener((ActionListener) this);
		btn_6.addActionListener((ActionListener) this);
		btn_7.addActionListener((ActionListener) this);
		btn_8.addActionListener((ActionListener) this);
		btn_9.addActionListener((ActionListener) this);
		btn_Plus.addActionListener((ActionListener) this);
		btn_Minus.addActionListener((ActionListener) this);
		btn_Mul.addActionListener((ActionListener) this);
		btn_Div.addActionListener((ActionListener) this);
		btn_Equal.addActionListener((ActionListener) this);	
		btn_Clear.addActionListener((ActionListener) this);
		btn_Del.addActionListener((ActionListener) this);
		btn_dot.addActionListener((ActionListener) this);
		
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if(source == btn_Clear) {
        	label.setText("");
        	textField.setText("");
        }        	
        else if (source == btn_Del) {
        	int length = textField.getText().length();
            int number = length - 1;  /// index to remove (the last one) 
            
            if (length > 0) {
                StringBuilder back = new StringBuilder(textField.getText());
                back.deleteCharAt(number);  
                textField.setText(back.toString());
             }
            if (textField.getText().endsWith("")) {
                label.setText("");
                }
        } else if (source == btn_0)
    		if (textField.getText().equals("0")) 
    			return;
    		else
    			textField.setText(textField.getText() + "0");
        else if (source == btn_1)
        	textField.setText(textField.getText() + "1");
        else if (source == btn_2)
        	textField.setText(textField.getText() + "2");
        else if (source == btn_3)
        	textField.setText(textField.getText() + "3");
        else if (source == btn_4)
        	textField.setText(textField.getText() + "4");
        else if (source == btn_5)
        	textField.setText(textField.getText() + "5");
        else if (source == btn_6)
        	textField.setText(textField.getText() + "6");
        else if (source == btn_7)
        	textField.setText(textField.getText() + "7");
        else if (source == btn_8)
        	textField.setText(textField.getText() + "8");
        else if (source == btn_9)
        	textField.setText(textField.getText() + "9");
        else if (source == btn_dot) {
        	if (textField.getText().contains("."))
        		return;
        	else
        		textField.setText(textField.getText() + ".");
        } 
        
        
        else if (source == btn_Plus) {
                String str = textField.getText();
                number = Double.parseDouble(textField.getText());
                textField.setText("");
                label.setText(str + "+");
                calculation = 1;
            } else if (source == btn_Minus) {
                String str = textField.getText();
                number = Double.parseDouble(textField.getText());
                textField.setText("");
                label.setText(str + "-");
                calculation = 2;
            } else if (source == btn_Mul) {
                String str = textField.getText();
                number = Double.parseDouble(textField.getText());
                textField.setText("");
                label.setText(str + "X");
                calculation = 3;
            } else if (source == btn_Div) {
                String str = textField.getText();
                number = Double.parseDouble(textField.getText());
                textField.setText("");
                label.setText(str + "/");
                calculation = 4;
            } else if (source == btn_Equal) {


                switch (calculation) {
                    case 1:
                        answer = number + Double.parseDouble(textField.getText());
                        if (Double.toString(answer).endsWith(".0")) {
                            textField.setText(Double.toString(answer).replace(".0", ""));
                        } else {
                            textField.setText(Double.toString(answer));
                        }
                        break;
                    case 2:
                        answer = number - Double.parseDouble(textField.getText());
                        if (Double.toString(answer).endsWith(".0")) {
                            textField.setText(Double.toString(answer).replace(".0", ""));
                        } else {
                            textField.setText(Double.toString(answer));
                        }
                        break;
                    case 3:
                        answer = number * Double.parseDouble(textField.getText());
                        if (Double.toString(answer).endsWith(".0")) {
                            textField.setText(Double.toString(answer).replace(".0", ""));
                        } else {
                            textField.setText(Double.toString(answer));
                        }
                        break;
                    case 4:
                    	
                    	double num2 = Double.parseDouble(textField.getText());
                    	if (num2 != 0) {
                        answer = number / num2;
                        if (Double.toString(answer).endsWith(".0")) {
                            textField.setText(Double.toString(answer).replace(".0", ""));
                        } else {
                            textField.setText(Double.toString(answer));
                        }
                    	}
                        
                        break;
     
                }
                
            
            }
               
    
    }


}
    	    	
    	
