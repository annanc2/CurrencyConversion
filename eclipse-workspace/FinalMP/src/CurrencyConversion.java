import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.Scanner;

public class CurrencyConversion extends JFrame {

	// go back and add more currencies!!!!
	// change fonts of everything
	// edit message for what this program does
	// private static String stringMessage = "This Program allows you to.... ";

	String[] options = CurrencyConverter.getCurrencyCodes(); // names
	// of
	// Currencies
	String[] options2 = CurrencyConverter.getAvailableDates(); // dates of Currencies
	private static final int width = 1100, height = 300;

	public JTextField inputBox = new JTextField("Enter amount in U.S. Dollars here", 20);
	private JTextField outputBox = new JTextField("Currency Output");

	JButton calculate = new JButton("Calculate");
	CalculateButton calculateButton = new CalculateButton();

	// private static JLabel programMessage = new JLabel(stringMessage);

	JLabel optionText = new JLabel("Select which currency you would like to convert to from U.S. Dollars:",
			SwingConstants.RIGHT);
	JLabel optionDateText = new JLabel("Select which date you would like your currency value to be estimated from:",
			SwingConstants.RIGHT);
	JLabel outputText = new JLabel("Currency converted from U.S. Dollars:", SwingConstants.RIGHT);

	JComboBox selectionDropdown = new JComboBox(options);
	JComboBox selectDateDropdown = new JComboBox(options2);

	// format of window
	public CurrencyConversion() {

		calculate.addActionListener(calculateButton);

		Container foo = getContentPane();
		foo.setLayout(new GridLayout(4, 2));
		foo.setBackground(new Color(0, 100, 120, 100));

		// programMessage.setFont(new Font("Monospaced", 3, 14));
		optionText.setFont(new Font("Monospaced", 3, 12));
		optionDateText.setFont(new Font("Monospaced", 3, 12));
		outputText.setFont(new Font("Monospaced", 3, 12));
		selectionDropdown.setFont(new Font("Monospaced", 3, 14));
		selectDateDropdown.setFont(new Font("Monospaced", 3, 14));

		// make textfields editable and not editable
		inputBox.setEditable(true);
		outputBox.setEditable(false);

		// pane.add(programMessage);
		foo.add(optionText);
		foo.add(selectionDropdown);
		foo.add(optionDateText);
		foo.add(selectDateDropdown);
		foo.add(inputBox);
		foo.add(calculate);
		foo.add(outputText);
		foo.add(outputBox);

		setSize(width, height);
		setTitle("Currency Converter");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	// implement ActionListener, listens to what the button does
	private class CalculateButton implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			// fix the setText
			boolean appropriateInput = false;
			try {
				double userInput = Double.parseDouble(inputBox.getText());
				appropriateInput = true;
			} catch (NumberFormatException a) {
				inputBox.setText("Enter amount in U.S. Dollars here");
				outputBox.setText("Currency Output");
			}

			if (appropriateInput) {
				// write code for reading data and calculating currency from U.S. dollars
				double inputForCalculation = Double.parseDouble(inputBox.getText());
				double answer = inputForCalculation
						* CurrencyConverter.getRate(selectDateDropdown.getSelectedItem().toString(),
								selectionDropdown.getSelectedItem().toString().substring(0,3)); 
				String outputAnswer = Double.toString(answer);
				outputBox.setText(outputAnswer);
			}

		}

	}

	public static void main(String[] args) throws FileNotFoundException {

		// write code to read currencies from currency1 file qnd put into the array
		CurrencyConversion session = new CurrencyConversion();
	}
}
