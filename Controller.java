import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class Controller {

	private View view;
	private Polynomial polynom = new Polynomial();
	private Polynomial polynom2 = new Polynomial();
	private Polynomial polynom3 = new Polynomial();
	private Monom monom = new Monom();
	private Monom monom2 = new Monom();

	public Controller(View v) {
		this.view = v;

		v.addEnterListener(new EnterListener());
		v.addEnterListener2(new EnterListener2());
		v.addSumListener(new SumListener());
		v.addSubListener(new SubListener());
		v.addDerListener(new DerListener());
		v.addMulListener(new MulListener());
		v.addIntListener(new IntListener());
		v.addClearListener(new ClearListener());
	}
//Am creat o clasa interna pentru fiecare ascultator.

	class EnterListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int coefficient = 0;
			int exponent = 0;
			try {
				coefficient = Integer.parseInt(view.getCoefficientTf().getText());
				exponent = Integer.parseInt(view.getExponentTf().getText());
				monom = new Monom(coefficient, exponent);
				polynom.addElements(monom);
				polynom.sortPolynomial();
				view.getPolynomTf().setText(polynom.printPolynomial());
				view.getCoefficientTf().setText("");
				view.getExponentTf().setText("");
			} catch (NumberFormatException nfex) {
				JOptionPane.showMessageDialog(view.getPanel(), "Bad input !");
			}

		}
	}

	class EnterListener2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int coefficient = 0;
			int exponent = 0;
			try {
				coefficient = Integer.parseInt(view.getCoefficientTf2().getText());
				exponent = Integer.parseInt(view.getExponentTf2().getText());
				monom2 = new Monom(coefficient, exponent);
				polynom2.addElements(monom2);
				polynom2.sortPolynomial();
				view.getPolynomTf2().setText(polynom2.printPolynomial());
				view.getCoefficientTf2().setText("");
				view.getExponentTf2().setText("");
			} catch (NumberFormatException nfex) {
				JOptionPane.showMessageDialog(view.getPanel(), "Bad input !");
			}

		}
	}

	class SumListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			view.getResultTf().setText("");
			polynom3 = new Polynomial();
			polynom3.addPolynomials(polynom, polynom2);
			polynom3.sortPolynomial();
			view.getResultTf().setText(polynom3.printPolynomial());

		}
	}

	class SubListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			view.getResultTf().setText("");
			polynom3 = new Polynomial();
			polynom3.subPolynomials(polynom, polynom2);
			polynom3.sortPolynomial();
			view.getResultTf().setText(polynom3.printPolynomial());
		}
	}

	class DerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			polynom3 = new Polynomial();
			polynom3.derivatePolynomial(polynom);
			view.getResultTf().setText(polynom3.printPolynomial());
		}
	}

	class MulListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			view.getResultTf().setText("");
			polynom3 = new Polynomial();
			polynom3.mulPolynomials(polynom, polynom2);
			polynom3.sortPolynomial();
			view.getResultTf().setText(polynom3.printPolynomial());
		}
	}

	class IntListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			polynom3 = new Polynomial();
			polynom3.integratePolynomial(polynom);
			view.getResultTf().setText(polynom3.printPolynomial());
		}
	}

	class ClearListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			view.getResultTf().setText("");
			view.getPolynomTf().setText("");
			view.getPolynomTf2().setText("");
			polynom = new Polynomial();
			polynom2 = new Polynomial();
			polynom3 = new Polynomial();

		}
	}
}
