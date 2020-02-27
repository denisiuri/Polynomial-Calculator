import java.awt.event.ActionListener;

import javax.swing.*;

public class View extends JFrame {
	JPanel panel = new JPanel();
	private JTextField coefficientTf = new JTextField(10);
	private JTextField exponentTf = new JTextField(15);
	private JTextField coefficientTf2 = new JTextField(10);
	private JTextField exponentTf2 = new JTextField(15);
	private JLabel labelCoefficient = new JLabel("Coefficient: ");
	private JLabel labelExponent = new JLabel("Exponent: ");
	private JLabel labelCoefficient2 = new JLabel("Coefficient: ");
	private JLabel labelExponent2 = new JLabel("Exponent: ");
	private JTextField polynomTf = new JTextField(40);
	private JTextField polynomTf2 = new JTextField(40);
	private JTextField resultTf = new JTextField(40);
	private JLabel labelPolynom = new JLabel("First polynom: ");
	private JLabel labelPolynom2 = new JLabel("Second polynom: ");
	private JLabel labelResult = new JLabel("Result: ");
	JButton enterButton = new JButton("Enter");
	JButton enterButton2 = new JButton("Enter");
	JButton sumButton = new JButton("Sum");
	JButton subButton = new JButton("Sub");
	JButton mulButton = new JButton("Mul");
	JButton divButton = new JButton("Div");
	JButton integrationButton = new JButton("Int");
	JButton derivareButton = new JButton("Der");
	JButton clearButton = new JButton("Clear");

	public JPanel getPanel() {
		return panel;
	}

	public JTextField getCoefficientTf() {
		return coefficientTf;
	}

	public JTextField getExponentTf() {
		return exponentTf;
	}

	public JTextField getCoefficientTf2() {
		return coefficientTf2;
	}

	public JTextField getExponentTf2() {
		return exponentTf2;
	}

	public JLabel getLabelCoefficient() {
		return labelCoefficient;
	}

	public JLabel getLabelExponent() {
		return labelExponent;
	}

	public JLabel getLabelCoefficient2() {
		return labelCoefficient2;
	}

	public JLabel getLabelExponent2() {
		return labelExponent2;
	}

	public JTextField getPolynomTf() {
		return polynomTf;
	}

	public JTextField getPolynomTf2() {
		return polynomTf2;
	}

	public JTextField getResultTf() {
		return resultTf;
	}

	public JLabel getLabelPolynom() {
		return labelPolynom;
	}

	public JLabel getLabelPolynom2() {
		return labelPolynom2;
	}

	public JLabel getLabelResult() {
		return labelResult;
	}

	public JButton getEnterButton() {
		return enterButton;
	}

	public JButton getEnterButton2() {
		return enterButton2;
	}

	public JButton getSumButton() {
		return sumButton;
	}

	public JButton getSubButton() {
		return subButton;
	}

	public JButton getMulButton() {
		return mulButton;
	}

	public JButton getDivButton() {
		return divButton;
	}

	public JButton getIntegrationButton() {
		return integrationButton;
	}

	public JButton getDerivareButton() {
		return derivareButton;
	}

//Constructorul pentru crearea interfetei.
	public View() {
		this.setBounds(100, 100, 650, 589);
		this.setVisible(true);
		this.setTitle("Polynomial calculator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel.setBounds(0, 0, 632, 542);
		this.add(panel);
		panel.setLayout(null);

		labelCoefficient.setBounds(63, 13, 71, 16);
		panel.add(labelCoefficient);

		coefficientTf.setBounds(37, 42, 116, 22);
		panel.add(coefficientTf);

		labelExponent.setBounds(63, 77, 71, 16);
		panel.add(labelExponent);

		exponentTf.setBounds(37, 106, 116, 22);
		panel.add(exponentTf);

		labelPolynom.setBounds(360, 37, 134, 16);
		panel.add(labelPolynom);

		polynomTf.setBounds(333, 62, 287, 38);
		panel.add(polynomTf);
		polynomTf.setEditable(false);

		enterButton.setBounds(203, 73, 97, 25);
		panel.add(enterButton);

		labelCoefficient2.setBounds(63, 189, 71, 16);
		panel.add(labelCoefficient2);

		coefficientTf2.setBounds(37, 221, 116, 22);
		panel.add(coefficientTf2);

		labelExponent2.setBounds(63, 256, 71, 16);
		panel.add(labelExponent2);

		exponentTf2.setBounds(37, 285, 116, 22);
		panel.add(exponentTf2);

		labelPolynom2.setBounds(360, 220, 134, 16);
		panel.add(labelPolynom2);

		polynomTf2.setBounds(333, 245, 287, 38);
		panel.add(polynomTf2);
		polynomTf2.setEditable(false);

		enterButton2.setBounds(203, 252, 97, 25);
		panel.add(enterButton2);

		sumButton.setBounds(37, 362, 97, 25);
		panel.add(sumButton);

		subButton.setBounds(37, 423, 97, 25);
		panel.add(subButton);

		mulButton.setBounds(250, 362, 97, 25);
		panel.add(mulButton);

		divButton.setBounds(250, 423, 97, 25);
		panel.add(divButton);

		integrationButton.setBounds(473, 423, 97, 25);
		panel.add(integrationButton);

		derivareButton.setBounds(473, 362, 97, 25);
		panel.add(derivareButton);

		labelResult.setBounds(22, 497, 56, 22);
		panel.add(labelResult);

		resultTf.setBounds(80, 487, 405, 42);
		panel.add(resultTf);
		resultTf.setEditable(false);

		clearButton.setBounds(518, 495, 97, 25);
		panel.add(clearButton);
	}

	void addEnterListener(ActionListener eal) {
		enterButton.addActionListener(eal);
	}

	void addEnterListener2(ActionListener eal) {
		enterButton2.addActionListener(eal);
	}

	void addSumListener(ActionListener sal) {
		sumButton.addActionListener(sal);
	}

	void addSubListener(ActionListener sal) {
		subButton.addActionListener(sal);
	}

	void addMulListener(ActionListener mal) {
		mulButton.addActionListener(mal);
	}

	void addDivListener(ActionListener dal) {
		divButton.addActionListener(dal);
	}

	void addIntListener(ActionListener ial) {
		integrationButton.addActionListener(ial);
	}

	void addClearListener(ActionListener cal) {
		clearButton.addActionListener(cal);
	}

	void addDerListener(ActionListener dal) {
		derivareButton.addActionListener(dal);
	}

	void setTotalPolynom(String newTotal) {
		polynomTf.setText(newTotal);
	}

	void setTotalPolynom2(String newTotal) {
		polynomTf2.setText(newTotal);
	}

	void setTotalResult(String newTotal) {
		resultTf.setText(newTotal);
	}

}
