/**
	 * Class Name:	Information	
	 * Purpose:		Customized GUI to show the information of each student
	 * 				
	 * Coder:		Mahan Mehdipour	
	 * Date:		April 9, 2020	
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Information extends JFrame {
	private int index = 0;
	JLabel interestNum, months;
	JButton addUpper, remUpper, addUpper2, remUpper2, getResult;
	JTextArea cslAndOsl;

	public Information() {

		super("Repayment Calculation Window");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 850);
		this.setLayout(new GridLayout(7, 1));
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		JButton previous = new JButton("Previous");
		JButton next = new JButton("    Next    ");
		JButton remove = new JButton("  Remove  ");

		JButton goBack = new JButton("Go Back");

		JPanel sec1 = new JPanel(new FlowLayout());
		JPanel sec1_2 = new JPanel(new FlowLayout());
		JPanel sec1_3 = new JPanel(new FlowLayout());
		JPanel sec2 = new JPanel(new FlowLayout());
		JPanel sec2_2 = new JPanel(new FlowLayout());
		JPanel sec3 = new JPanel(new FlowLayout());
		JPanel sec4 = new JPanel(new FlowLayout());

		JTextArea info = new JTextArea();

		if (StudentLoanApp.info.size() == 0)
			info.setText("No data Available");
		else
			info.setText(StudentLoanApp.info.get(index).toString() + "\nAddress: "
					+ StudentLoanApp.info.get(index).getStreetNumber() + " "
					+ StudentLoanApp.info.get(index).getStreetName() + "\n" + StudentLoanApp.info.get(index).getCity()
					+ ", " + StudentLoanApp.info.get(index).getProvince());

		sec1_2.add(new JLabel("Interest Rate:"));
		interestNum = new JLabel("0.00");
		sec1_2.add(interestNum);
		sec1_2.add(new JLabel("%"));

		JPanel btnForInter = new JPanel();
		btnForInter.setLayout(new GridLayout(2, 1));
		addUpper = new JButton("Go Higher");
		remUpper = new JButton("Go Lower");

		sec1_2.add(btnForInter);
		btnForInter.add(addUpper);
		btnForInter.add(remUpper);

		addUpper.addActionListener((e) -> {
			double numberX = Double.parseDouble(interestNum.getText());

			if (numberX != 9.75) {
				numberX += 0.25;
				interestNum.setText("" + numberX);
			}

		});

		remUpper.addActionListener((e) -> {
			double numberX = Double.parseDouble(interestNum.getText());

			if (numberX != 0.00) {
				numberX -= 0.25;
				interestNum.setText("" + numberX);
			}

		});

		sec1_3.add(new JLabel("Number of Months:"));
		months = new JLabel("0");

		addUpper2 = new JButton("Add 1");
		remUpper2 = new JButton("Remove 1");
		JPanel btnForMonth = new JPanel();
		btnForMonth.setLayout(new GridLayout(2, 1));
		btnForMonth.add(addUpper2);
		btnForMonth.add(remUpper2);
		sec1_3.add(months);
		sec1_3.add(btnForMonth);

		addUpper2.addActionListener((e) -> {
			int numberX = Integer.parseInt(months.getText());

			numberX++;
			months.setText("" + numberX);

		});

		remUpper2.addActionListener((e) -> {
			int numberX = Integer.parseInt(months.getText());

			if (numberX != 0) {
				numberX--;
				months.setText("" + numberX);
			}

		});

		getResult = new JButton("Get the Amount");
		sec2_2.add(getResult);
		GetLastResult cls = new GetLastResult();

		getResult.addActionListener(cls);

		cslAndOsl = new JTextArea("");
		cslAndOsl.setEditable(false);
		sec2_2.add(cslAndOsl);

		info.setEditable(false);
		this.add(sec1);
		this.add(sec1_2);
		this.add(sec1_3);
		this.add(sec2);
		this.add(sec2_2);
		this.add(sec3);
		this.add(sec4);

		sec1.add(new JLabel("This is the repayment calculation form"));
		sec2.add(new JLabel("Student Information"));
		sec2.add(info);
		sec3.add(previous);
		sec3.add(remove);
		sec3.add(next);
		sec4.add(goBack);

		remove.addActionListener((e) -> {
			if (StudentLoanApp.info.size() - 1 == 0) {
				info.setText("No data Available");
				StudentLoanApp.info.remove(index);
			}

			else if (StudentLoanApp.info.size() - 1 > 0) {
				StudentLoanApp.info.remove(index);
				info.setText(StudentLoanApp.info.get(index).toString());

			} else {
				info.setText("No data Available");
				System.out.println("There is no data to remove!");
			}

		});

		previous.addActionListener((e) -> {
			if (index == 0) {
				System.out.println("This is the first Element of the ArrayList!");
			}

			else if (index > 0) {
				--index;
				info.setText(StudentLoanApp.info.get(index).toString());
				info.setEditable(false);
			} else {
				info.setText("No data Available");
			}

		});

		next.addActionListener((e) -> {
			if (index == StudentLoanApp.info.size() - 1) {
				System.out.println("This is the last element of the ArrayList!");
			} else if (index < StudentLoanApp.info.size() - 1) {
				++index;
				info.setText(StudentLoanApp.info.get(index).toString());
				info.setEditable(false);
			} else {
				info.setText("No data Available");
			}

		});

		goBack.addActionListener((e) -> {
			new StudentLoanApp();
			this.setVisible(false);
		});

	}

	/**
	 * Class Name: GetLastResult Purpose: Getting and printing the information based
	 * on the array list using action Listeners Coder: Mahan Mehdipour Date: April
	 * 9, 2020
	 */
	private class GetLastResult implements ActionListener, MM_LoanPayable {

		
		/*Method Name:	actionPerformed
		*Purpose:	operate some operation when button clicked
		*Accepts:	ActionEven
		*Returns:	void
		*/
		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getActionCommand().equals("Get the Amount")) {
				if (StudentLoanApp.info.size() > 0) {

					double osl = StudentLoanApp.info.get(index).getOslLoanAmount();
					double csl = StudentLoanApp.info.get(index).getCslLoanAmount();
					double intrst = Double.parseDouble(interestNum.getText());
					int mnths = Integer.parseInt(months.getText());

					double finalOsl = calculateLoanPayment(osl / 100, intrst + 1, mnths);
					double finalCsl = calculateLoanPayment(csl / 100, intrst + 2.5, mnths);

					finalOsl = (Math.round(finalOsl * 100)) / 100.0;
					finalCsl = (Math.round(finalCsl * 100)) / 100.0;

					cslAndOsl.setText("The OSL Payment is: " + finalOsl + "\n" + "The CSL Payment is: " + finalCsl
							+ "\n" + "Sum of these is: " + (finalCsl + finalOsl));

				} else {
					cslAndOsl.setText("No Data Available");
				}

			}

		}

		/*
		 * Method Name: calculateLoanPayment Purpose: calculating the OSL and CSL based
		 * on different factors Accepts: double for OSL or CSL, double interest rate,
		 * int number of months Returns: double as amount of interest
		 */

		@Override
		public double calculateLoanPayment(double oslOrCsl, double anualPrimeInterest, int amorization) {
			double monthlyRate = ANNUAL_RATE_TO_MONTHLY_RATE * anualPrimeInterest;

			double payment = oslOrCsl * monthlyRate
					* (Math.pow(1 + monthlyRate, 60) / (Math.pow(1 + monthlyRate, 60) - 1));

			return payment * 100;

		}

	}

}
