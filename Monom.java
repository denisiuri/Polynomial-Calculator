public class Monom implements Comparable<Monom> {
	private float coefficient;
	private int exponent;

	public Monom(float c, int e) {
		this.coefficient = c;
		this.exponent = e;
	}

	public Monom(Monom m) {
		this.coefficient = m.coefficient;
		this.exponent = m.exponent;
	}

	public Monom() {

	}

	public float getCoefficient() {
		return this.coefficient;
	}

	public void setCoefficient(int c) {
		this.coefficient = c;
	}

	public int getExponent() {
		return this.exponent;
	}

	public void setExponent(int e) {
		this.exponent = e;
	}

	public void addMonoms(Monom m) {
		if (this.exponent == m.getExponent()) {
			this.coefficient = this.coefficient + m.getCoefficient();
		}
	}

	public int compareTo(Monom m) {
		return (int) (m.getExponent()) - this.exponent;
	}

	public void negative() {
		this.coefficient = (-1) * this.coefficient;
	}

	public void mulMonoms(Monom m) {
		this.exponent = this.exponent + m.exponent;
		this.coefficient = this.coefficient * m.coefficient;
	}

	public void integrateMonom() {
		this.exponent = this.exponent + 1;
		this.coefficient = this.coefficient / this.exponent;
	}

	public void derivateMonom() {
		if (this.exponent != 0) {
			this.coefficient = this.coefficient * this.exponent;
			this.exponent = this.exponent - 1;
		} else {
			this.coefficient = 0;
		}

	}

	/*
	 * Metoda toString() este utilizata la afisarea polinoamelor. Aceasta are mai
	 * multe ramuri if pentru diferite cazuri, afisarea unui monom fiind influentata
	 * de valoarea coeficientului sau exponentului acestuia.
	 */
	public String toString() {
		if (this.exponent != 0 && this.coefficient > 0) {
			return "+" + this.coefficient + "X" + "^" + this.exponent;

		} else if (this.exponent != 0 && this.coefficient < 0) {
			return this.coefficient + "X" + "^" + this.exponent;
		} else if (this.exponent == 0 && this.coefficient > 0) {
			return "+" + this.coefficient;
		} else if (this.exponent == 0 && this.coefficient < 0)

		{
			return " " + this.coefficient;
		} else {
			return " ";
		}

	}
}
