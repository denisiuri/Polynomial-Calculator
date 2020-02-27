import static org.junit.Assert.*;
import org.junit.Test;

public class TestPolynomial {
	Polynomial p1;
	Polynomial p2;
	Polynomial p3;
	Polynomial result;

	/*
	 * Testul pentru operatia de adunare. In p1 si in p2 am adaugat polinoamele
	 * ce urmeaza a fi adunate, iar in p3 am stocat rezultatul adunarii. In
	 * result am pus rezultatul adunarii pe care il asteptam. Pentru toate
	 * operatiile testul se efectueaza similar, diferentele posibile fiind metoda
	 * apelata sau numarul de polinoame folosite.
	 */
	@Test
	public void testSum() {
		p1 = new Polynomial();
		p2 = new Polynomial();
		p3 = new Polynomial();
		result = new Polynomial();

		// (2x^3 - 3X^2 + X + 4)
		p1.addPolyElements(2, 3);
		p1.addPolyElements(1, 1);
		p1.addPolyElements(-3, 2);
		p1.addPolyElements(4, 0);

		// (5x^5 + X^4 + 4X^3 + 2X + 3)
		p2.addPolyElements(5, 5);
		p2.addPolyElements(1, 4);
		p2.addPolyElements(2, 1);
		p2.addPolyElements(3, 0);
		p2.addPolyElements(4, 3);

		// (5X^5 + X^4 + 6X^3 - 3X^2 + 3X + 7)
		result.addPolyElements(5, 5);
		result.addPolyElements(1, 4);
		result.addPolyElements(6, 3);
		result.addPolyElements(-3, 2);
		result.addPolyElements(3, 1);
		result.addPolyElements(7, 0);
		result.sortPolynomial();

		p3.addPolynomials(p1, p2);

		assertEquals(p3.printPolynomial(), result.printPolynomial());

	}

	@Test
	public void testSub() {
		p1 = new Polynomial();
		p2 = new Polynomial();
		p3 = new Polynomial();
		result = new Polynomial();

		// (3X4 -2X3 + 7X +1)
		p1.addPolyElements(3, 4);
		p1.addPolyElements(-2, 3);
		p1.addPolyElements(7, 1);
		p1.addPolyElements(1, 0);

		// (-7X5 - 2X4 + 3X2 +X +5)
		p2.addPolyElements(-7, 5);
		p2.addPolyElements(-2, 4);
		p2.addPolyElements(3, 2);
		p2.addPolyElements(1, 1);
		p2.addPolyElements(5, 0);

		// (7X5 + 5X4 -2X3 - 3X2 + 6x -4)
		result.addPolyElements(7, 5);
		result.addPolyElements(5, 4);
		result.addPolyElements(-2, 3);
		result.addPolyElements(-3, 2);
		result.addPolyElements(6, 1);
		result.addPolyElements(-4, 0);

		p3.subPolynomials(p1, p2);

		assertEquals(p3.printPolynomial(), result.printPolynomial());
	}

	@Test
	public void testMul() {
		p1 = new Polynomial();
		p2 = new Polynomial();
		p3 = new Polynomial();
		result = new Polynomial();

		// (2X^2 + X + 2)
		p1.addPolyElements(2, 2);
		p1.addPolyElements(1, 1);
		p1.addPolyElements(2, 0);

		// (X - 1)
		p2.addPolyElements(1, 1);
		p2.addPolyElements(-1, 0);

		// (2X^3 - X^2 + X - 2)
		result.addPolyElements(2, 3);
		result.addPolyElements(-1, 2);
		result.addPolyElements(1, 1);
		result.addPolyElements(-2, 0);
		result.sortPolynomial();

		p3.mulPolynomials(p1, p2);

		assertEquals(p3.printPolynomial(), result.printPolynomial());

	}

	@Test
	public void testDer() {
		p1 = new Polynomial();
		p3 = new Polynomial();
		result = new Polynomial();

		// (5X^3 - 6X^2 + 2X + 1)
		p1.addPolyElements(5, 3);
		p1.addPolyElements(-6, 2);
		p1.addPolyElements(2, 1);
		p1.addPolyElements(1, 0);

		result.addPolyElements(15, 2);
		result.addPolyElements(-12, 1);
		result.addPolyElements(2, 0);

		p3.derivatePolynomial(p1);

		assertEquals(p3.printPolynomial(), result.printPolynomial());

	}

	@Test
	public void testInt() {
		p1 = new Polynomial();
		p3 = new Polynomial();
		result = new Polynomial();

		// (4X^3 + 2X + 1)
		p1.addPolyElements(4, 3);
		p1.addPolyElements(2, 1);
		p1.addPolyElements(1, 0);

		result.addPolyElements(1, 4);
		result.addPolyElements(1, 2);
		result.addPolyElements(1, 1);

		p3.integratePolynomial(p1);

		assertEquals(p3.printPolynomial(), result.printPolynomial());
	}

}
