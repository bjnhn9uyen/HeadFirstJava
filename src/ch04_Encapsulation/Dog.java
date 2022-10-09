package ch04_Encapsulation;

class Dog {

	private int size;

	// encapsulation
	public int getSize() {
		return size;
	}

	// encapsulation
	public void setSize(int s) {
		if (s > 9) {
			size = s;
		}
	}

	void bark() {
		if (size > 60) {
			System.out.println("Wooof! Wooof!");
		} else if (size > 14) {
			System.out.println("Ruff! Ruff!");
		} else {
			System.out.println("Yip! Yip!");
		}
	}

}
