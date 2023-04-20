/**
	 * Class Name:	StudentLoanApp	
	 * Purpose:		Customized GUI to store information about the students and validate some data
	 * 				
	 * Coder:		Mahan Mehdipour	
	 * Date:		April 9, 2020	
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class StudentLoanApp extends JFrame {

	private String studentId;
	private String surname;
	private String middleName;
	private String firstName;
	private String aptNumber;
	private String streetNumber;
	private String streetName;
	private String city;
	private String provinces;
	private String postalCode;
	private double cslLoanAmount;
	private double oslLoanAmount;

	JLabel csl, osl, sId, aptNum, strtNum, interestNum, months;
	JTextField strtName, cit, pCode, lName, mName, fName;

	public static ArrayList<Student> info = new ArrayList<Student>();

	JComboBox<String> combo, province;

	JButton submit, n1, n2, n3, n4, n5, n6, n7, n8, n9, nRem, n0, nAdd, otherWin, addUpper, remUpper, addUpper2,
			remUpper2;
	String[]  sections= { "Student ID", "Apartment Number", "Street Number", "CSL Loan Amount", "OSL Loan Amount" };
	String[] prov = { "AB", "BC", "MB", "NB", "NL", "NS", "NT", "NU", "ON", "PE", "QC", "SK", "YT" };
	String[] firstNumbers = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
	String[] secondNumbers = { "0", "0.25", "0.5", "0.75" };

	public void validatesZero(String s) throws NoZero {
		if (s.charAt(0) == '0') {
			throw new NoZero();
		}

	}

	public void validates(String s) throws MM_NegativeValueException {
		if (s.length() != 7) {
			throw new MM_NegativeValueException();
		}

	}

	StudentLoanApp() {
		super("Mahan Mehdipour, 0937434");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setLayout(new GridLayout(3, 1));


		JPanel top = new JPanel();
		top.setLayout(new FlowLayout());
		JLabel header = new JLabel("This is Mahan Mehdipour's Student Loan Calculator");
		top.add(header);

		top.setSize(600, 40);
		this.add(top);

		JPanel all = new JPanel();
		all.setLayout(new GridLayout(1, 2));
		this.add(all);

		submit = new JButton("Add all information");
		otherWin = new JButton("Go to Veiw Information");

		JPanel last = new JPanel();
		last.setLayout(new GridLayout(2, 2));
		JPanel lastUp = new JPanel();
		JPanel lastDown = new JPanel();

		last.add(lastUp);
		last.add(submit);
		last.add(lastDown);
		last.add(otherWin);
		this.add(last);

		Submition cls = new Submition();
		submit.addActionListener(cls);

		lastUp.setLayout(new GridLayout(3, 2));
		lastDown.setLayout(new GridLayout(3, 2));

		lastUp.add(new JLabel("*Street Name:"));
		strtName = new JTextField();
		lastUp.add(strtName);

		JPanel right = new JPanel();
		JPanel left = new JPanel();

		all.add(left);
		left.setLayout(new GridLayout(6, 2));

		left.add(new JLabel("*Student ID:"));
		sId = new JLabel();
		left.add(sId);

		left.add(new JLabel("*Surname:"));
		lName = new JTextField();
		left.add(lName);

		left.add(new JLabel("Middle Name:"));
		mName = new JTextField();
		left.add(mName);

		left.add(new JLabel("*First Name:"));
		fName = new JTextField();
		left.add(fName);

		left.add(new JLabel("Apartment Number:"));
		aptNum = new JLabel();
		left.add(aptNum);

		left.add(new JLabel("*Street Number:"));
		strtNum = new JLabel();
		left.add(strtNum);

		lastUp.add(new JLabel("*City:"));
		cit = new JTextField();
		lastUp.add(cit);

		lastUp.add(new JLabel("*Province:"));
		province = new JComboBox<String>(prov);
		lastUp.add(province);

		lastDown.add(new JLabel("*Postal Code:"));
		pCode = new JTextField();
		lastDown.add(pCode);

		lastDown.add(new JLabel("*CSL Loan Amount:$"));
		csl = new JLabel("1");
		lastDown.add(csl);

		lastDown.add(new JLabel("*OSL Loan Amount:$"));
		osl = new JLabel("1");
		lastDown.add(osl);

		all.add(right);
		right.setLayout(new GridLayout(2, 1));
		combo = new JComboBox<String>(sections);

		JPanel bottom = new JPanel();
		JPanel up = new JPanel();

		up.setLayout(new GridLayout(2, 1));

		JPanel upUp = new JPanel();
		JPanel upDown = new JPanel();
		up.add(upUp);
		up.add(upDown);

		upUp.add(combo);
		upDown.setLayout(new GridLayout(1, 3));

		JLabel dLeft = new JLabel("Number: ");
		JLabel dRight = new JLabel("");
		JButton clear = new JButton("Clear");

		upDown.add(dLeft);
		upDown.add(dRight);
		upDown.add(clear);

		clear.addActionListener((e) -> {
			dRight.setText("");
		});

		right.add(up);
		right.add(bottom);

		n1 = new JButton("1");
		n2 = new JButton("2");
		n3 = new JButton("3");
		n4 = new JButton("4");
		n5 = new JButton("5");
		n6 = new JButton("6");
		n7 = new JButton("7");
		n8 = new JButton("8");
		n9 = new JButton("9");
		nRem = new JButton("Remove");
		n0 = new JButton("0");
		nAdd = new JButton("Add");

		n1.addActionListener((e) -> {
			dRight.setText(dRight.getText() + "1");
		});
		n2.addActionListener((e) -> {
			dRight.setText(dRight.getText() + "2");
		});
		n3.addActionListener((e) -> {
			dRight.setText(dRight.getText() + "3");
		});
		n4.addActionListener((e) -> {
			dRight.setText(dRight.getText() + "4");
		});
		n5.addActionListener((e) -> {
			dRight.setText(dRight.getText() + "5");
		});
		n6.addActionListener((e) -> {
			dRight.setText(dRight.getText() + "6");
		});
		n7.addActionListener((e) -> {
			dRight.setText(dRight.getText() + "7");
		});
		n8.addActionListener((e) -> {
			dRight.setText(dRight.getText() + "8");
		});
		n9.addActionListener((e) -> {
			dRight.setText(dRight.getText() + "9");
		});
		n0.addActionListener((e) -> {
			dRight.setText(dRight.getText() + "0");
		});

		
		nAdd.addActionListener((e) -> {
			String comboSelected = (String) combo.getSelectedItem();

			// Exception Handling validating the data for student ID
			// //--------------------------------------------------------
			//
			if (comboSelected.equals("Student ID")) { //
				try { //
					validates(dRight.getText()); //
					sId.setText(dRight.getText()); //
				} //
				catch (MM_NegativeValueException ex) { //
					System.out.println(ex.getMessage()); //
				} //
			} //
				//
				// -------------------------------------------------------

			if (comboSelected.equals("Apartment Number"))
				aptNum.setText(dRight.getText());

			if (comboSelected.equals("Street Number"))
				strtNum.setText(dRight.getText());

			// Exception Handling for leading 0 for the validation
			// ----------------------------------------------
			if (comboSelected.equals("CSL Loan Amount")) {
				try {
					String s = dRight.getText();
					validatesZero(s);
					csl.setText(dRight.getText());
				} catch (NoZero exe) {
					System.out.println(exe.getMessage());
				}
			}
			if (comboSelected.equals("OSL Loan Amount")) {

				try {
					validatesZero(dRight.getText());
					osl.setText(dRight.getText());
				} catch (NoZero ex) {
					System.out.println(ex.getMessage());
				}
			}
			// -------------------------------------------------
			dRight.setText("");

		});

		nRem.addActionListener((e) -> {
			String comboSelected = (String) combo.getSelectedItem();
			if (comboSelected.equals("Student ID"))
				sId.setText("");

			if (comboSelected.equals("Apartment Number"))
				aptNum.setText("");

			if (comboSelected.equals("Street Number"))
				strtNum.setText("");

			if (comboSelected.equals("CSL Loan Amount"))
				csl.setText("1");

			if (comboSelected.equals("OSL Loan Amount"))
				;
			osl.setText("1");

			dRight.setText("");

		});

		otherWin.addActionListener((e) -> {
			new Information();
			this.setVisible(false);

		});

		bottom.setPreferredSize(new Dimension(600, 90));
		bottom.setLayout(new GridLayout(4, 3));
		bottom.add(n1);
		bottom.add(n2);
		bottom.add(n3);
		bottom.add(n4);
		bottom.add(n5);
		bottom.add(n6);
		bottom.add(n7);
		bottom.add(n8);
		bottom.add(n9);
		bottom.add(nRem);
		bottom.add(n0);
		bottom.add(nAdd);


		this.setVisible(true);
	}

	
	
	/**
	 * Class Name:	Submition 	
	 * Purpose:		action listener inner class to add information to array list using constructor in order to store the information
	 * 				
	 * 				
	 * Coder:		Mahan Mehdipour	
	 * Date:		April 9, 2020	
*/
	private class Submition implements ActionListener {
		
		
		
		
		
		/*Method Name:	actionPerformed
		*Purpose:	operate some operation when button clicked
		*Accepts:	ActionEven
		*Returns:	void
		*/

		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("Add all information")) {
				studentId = sId.getText();
				surname = lName.getText();
				middleName = mName.getText();
				firstName = fName.getText();
				aptNumber = aptNum.getText();
				streetNumber = strtNum.getText();
				streetName = strtName.getText();
				city = cit.getText();
				provinces = (String) province.getSelectedItem();
				postalCode = pCode.getText();
				// -----------------------------------------------
				cslLoanAmount = Integer.parseInt(csl.getText());
				oslLoanAmount = Integer.parseInt(osl.getText());

				Student obj = new Student(studentId, surname, middleName, firstName, aptNumber, streetNumber,
						streetName, city, provinces, postalCode, cslLoanAmount, oslLoanAmount);
				info.add(obj);

				sId.setText("");
				lName.setText("");
				mName.setText("");
				fName.setText("");
				aptNum.setText("");
				strtNum.setText("");
				strtName.setText("");
				cit.setText("");
				province.setSelectedItem("AB");
				pCode.setText("");
				csl.setText("1");
				osl.setText("1");

			}

		}

	}

	public static void main(String[] args) {
		new StudentLoanApp();
	}
}
