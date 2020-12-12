package gui;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUI implements ActionListener{
	JFrame frame = new JFrame();
	JPanel panel= new JPanel();
	JLabel title = new JLabel("Add Two Numbers time");
	JLabel plus = new JLabel("+");
	JLabel output = new JLabel();
	JButton equalsButton = new JButton(" = ");
	JTextField input1 = new JTextField();
	JTextField input2 = new JTextField();
	Dimension screenSize = new Dimension(500,500);
	Calculator calc = new Calculator();
	
	public GUI() {
		frame.setSize(500,500);
		frame.setPreferredSize(screenSize);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Calculator");
		frame.setLayout(null);
		float newSize = 50;
		output.setFont(output.getFont().deriveFont(newSize));
		
		title.setBounds(200,0,150,50);
		input1.setBounds(10,40,100,30);
		plus.setBounds(50,70,30,30);
		input2.setBounds(10,100,100,30);
		equalsButton.setBounds(10,140,100,40);
		output.setBounds(10,210,100,50);

		equalsButton.addActionListener(this);	
		
		frame.add(panel);
		frame.add(title);
		frame.add(input1);
		frame.add(plus);
		frame.add(input2);
		frame.add(equalsButton);
		frame.add(output);
		
		frame.pack();

		// TODO Auto-generated constructor stub
	}
	public void display() {
		frame.setVisible(true);
	}
	
	@Override 
	public void actionPerformed(ActionEvent e) {
		int a = Integer.parseInt(input1.getText());
		int b = Integer.parseInt(input2.getText());
		
		int out = calc.addNums(a,b);
		output.setText(String.valueOf(out));
	}

}
