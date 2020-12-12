import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.border.LineBorder;
import javax.swing.*;

public class GUI implements ActionListener{
	private JFrame frame = new JFrame();
	private JPanel panel= new JPanel();
	private Dimension screenSize = new Dimension(500,500);
	private JButton calculateButton = new JButton(" Calculate ");
	private JTextField input1 = new JTextField();
	private JLabel output = new JLabel();
	private JLabel title = new JLabel("Calculate Batting Average");
	private JLabel request= new JLabel("Enter Number of Hits:");
	private double hits;
	private double timesAtBat;
	private boolean hitsIn= false;
	private String textIn;
	private Double in;
	private Double average;
	private Calculator battingAverageCalculator = new Calculator();
	private String pattern = "###,###.###";
	private DecimalFormat decimalFormat = new DecimalFormat(pattern);
	
	public GUI() {
		
		frame.setSize(500,500);
		frame.setPreferredSize(screenSize);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Calculator");
		frame.setLayout(null);
		frame.getContentPane().setBackground(new Color(28, 43, 45));
		float newSize = 14;
		output.setFont(output.getFont().deriveFont(newSize));
		output.setBounds(140,210,300,50);
		output.setForeground(new Color(230, 213, 184));
		
		title.setFont(output.getFont().deriveFont(newSize));
		title.setBounds(130,0,250,50);
		title.setForeground(new Color(230, 213, 184));
		
		request.setFont(output.getFont().deriveFont(newSize));
		request.setBounds(150,30,250,50);
		request.setForeground(new Color(230, 213, 184));
		
		calculateButton.setBounds(170,130,100,40);
		calculateButton.setBackground(new Color(31, 111, 139));
		calculateButton.setForeground(new Color(230, 213, 184));
		calculateButton.setBorder(new LineBorder(new Color(230, 213, 184),2));
		
		input1.setBounds(170,80,100,30);
		input1.setBackground(new Color(31, 111, 139));
		input1.setBorder(new LineBorder(new Color(230, 213, 184),2));
		input1.setForeground(new Color(230, 213, 184));
		input1.setHorizontalAlignment(JTextField.CENTER);
		
		calculateButton.addActionListener(this);
		calculateButton.addMouseListener(new java.awt.event.MouseAdapter() {
		    
			public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	calculateButton.setBackground(new Color(230, 213, 184));
		    	calculateButton.setForeground(new Color(31, 111, 139));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	calculateButton.setBackground(new Color(31, 111, 139));
				calculateButton.setForeground(new Color(230, 213, 184));
				calculateButton.setBorder(new LineBorder(new Color(230, 213, 184),2));
		    }
		});
		
		input1.addKeyListener(new KeyAdapter() {
	         public void keyPressed(KeyEvent ke) {
	            if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9'
	            		|| ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
	            	input1.setEditable(true);
	               output.setText("");
	            } else {
	            	input1.setEditable(false);
	               output.setText("Enter Numbers Only(0-9)");
	            }
	         }
	      });
		
		frame.add(panel);
		frame.add(title);
		frame.add(input1);
		frame.add(request);
		frame.add(calculateButton);
		frame.add(output);
		
		frame.pack();
	}
	
	public void display() {
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		textIn = input1.getText();
		in = Double.parseDouble(textIn);
		
		if(hitsIn==false) {
			hits= in;
			input1.setText("");
			request.setText("Enter Times at Bat: ");
			hitsIn=true;
		}else{
			timesAtBat = in;
			hitsIn=false;
			input1.setText("");
			request.setText("Enter Number of Hits: ");
			average = battingAverageCalculator.getAverage(hits,timesAtBat);
			output.setText("The Batting Average is: "+decimalFormat.format(average));
		}
		
		
		
	}

}
