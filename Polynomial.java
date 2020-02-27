import java.util.*;

public class Polynomial {
	private List<Monom> polynomial = new ArrayList<Monom>();

	public Polynomial() {
	}

	public Polynomial(List<Monom> polynomial) {

		this.polynomial = polynomial;
	}

	public List<Monom> getPolynomial() {
		return polynomial;
	}

	public void setPolynomial(List<Monom> polynomial) {
		this.polynomial = polynomial;
	}

	public void addElements(Monom x) {
		Monom m = new Monom(x.getCoefficient(), x.getExponent());
		this.polynomial.add(m);
	}

	public void addPolyElements(float coef, int exp) {
		Monom m = new Monom(coef, exp);
		this.polynomial.add(m);
	}

//Algoritmul folosit pentru adunare, este asemanator cu cel de interclasare.

	public void addPolynomials(Polynomial p1, Polynomial p2) {
		int i = 0, j = 0, k = 0;
		while (i < p1.getPolynomial().size() && j < p2.getPolynomial().size()) {
			if (p1.getPolynomial().get(i).getExponent() < p2.getPolynomial().get(j).getExponent()) {
				this.addElements(p2.getPolynomial().get(j));
				k++;
				j++;
			} else if (p1.getPolynomial().get(i).getExponent() > p2.getPolynomial().get(j).getExponent()) {
				this.addElements(p1.getPolynomial().get(i));
				k++;
				i++;
			} else if (p1.getPolynomial().get(i).getExponent() == p2.getPolynomial().get(j).getExponent()) {
				this.addElements(p1.getPolynomial().get(i));
				i++;
				this.polynomial.get(k).addMonoms(p2.getPolynomial().get(j));
				k++;
				j++;
			}
		}

		while (i < p1.getPolynomial().size()) {
			this.addElements(p1.getPolynomial().get(i));
			i++;
		}

		while (j < p2.getPolynomial().size()) {
			this.addElements(p2.getPolynomial().get(j));
			j++;
		}
		this.sortPolynomial();
	}

	/*
	 * Aceasta functie are rolul de a sorta polinomul in ordine descrescatoare dupa
	 * exponent si de a aduna elementele cu grad la fel.
	 */

	public void sortPolynomial() {
		Collections.sort(this.polynomial);
		for (int i = 0; i < this.polynomial.size(); i++) {
			for (int j = i + 1; j < this.polynomial.size(); j++) {
				if (this.polynomial.get(i).getExponent() == this.polynomial.get(j).getExponent()) {
					this.polynomial.get(i).addMonoms(this.polynomial.get(j));
					this.polynomial.remove(j);
				}
			}
		}
	}

	/*
	 * Metoda de scadere, inmulteste elementele celui de al doilea polinom cu (-1)
	 * si apoi apeleaza metoda de adunare.
	 */

	public void subPolynomials(Polynomial p1, Polynomial p2) {
		for (Monom index2 : p2.getPolynomial()) {
			index2.negative();
		}
		this.addPolynomials(p1, p2);
	}

	/*
	 * Se parcurg cele doua polinoame, în m3 am pus succesiv monoamele din primul
	 * polinom pentru a nu suferi modificari. Cu ajutorul metodei mulMonoms, am
	 * inmultit monoamele, iar apoi le-am adaugat la polinomul rezultat.
	 */

	public void mulPolynomials(Polynomial p1, Polynomial p2) {
		Monom m3 = new Monom();
		for (Monom index : p1.getPolynomial()) {
			m3 = new Monom(index);
			for (Monom index2 : p2.getPolynomial()) {
				m3.mulMonoms(index2);
				this.addElements(m3);
				m3 = new Monom(index);
			}
		}
		this.sortPolynomial();
	}

	/*
	 * Este parcurs polinomul, iar pentru fiecare monom se apeleaza metoda
	 * derivateMonom ce modifica exponentul si coeficientul.
	 */
	public void derivatePolynomial(Polynomial p1) {
		for (Monom index : p1.getPolynomial()) {
			Monom m = new Monom(index);
			m.derivateMonom();
			if (m.getCoefficient() != 0)
				this.polynomial.add(m);
		}

	}

	/*
	 * Este parcurs polinomul, iar pentru fiecare monom se apeleaza metoda
	 * integrateMonom ce modifica exponentul si coeficientul.
	 */

	public void integratePolynomial(Polynomial p1) {
		for (Monom index : p1.getPolynomial()) {
			Monom m = new Monom(index);
			m.integrateMonom();
			this.polynomial.add(m);
		}
	}

	public String printPolynomial() {
		String s = "";
		for (Monom index : polynomial) {
			s = s + index + " ";
		}

		return s;
	}

}
