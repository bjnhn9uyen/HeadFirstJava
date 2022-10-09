package ch13_ExceptionHandling_Polymorphism;

public class WashingMachine {

	void doLaundry() throws ClothingException { // polymorphism
		int randNum = (int) (Math.random() * 10);
		System.out.println(randNum);
		if (randNum < 2) {
			throw new DressShirtException();
		} else if (randNum >= 2 && randNum < 4) {
			throw new TeeShirtException();
		} else if (randNum >= 4 && randNum < 7) {
			throw new PantsException();
		} else {
			throw new ClothingException();
		}
	}

	public static void main(String[] args) {
		try {
			new WashingMachine().doLaundry();
		} catch (DressShirtException de) {
			// recovery from DressShirtException
			de.printStackTrace();
		} catch (TeeShirtException te) {
			// recovery from TeeShirtException
			te.printStackTrace();
		} catch (PantsException pe) {
			// recovery from PantsException
			pe.printStackTrace();
		} catch (ClothingException ce) {
			// recovery from ClothingException
			ce.printStackTrace();
		}
	}

}
