package ch18_Multithreading_Synchronizing_Atomic;

public class BankAccountSynchronized {

	private int balance = 100;

	public int getBalance() {
		return balance;
	}

	// every Java object has a lock with only one key. We don’t put a lock on the bank account itself,
	// we lock the method that does the banking transaction by marking it ‘synchronized’
	public synchronized void spend(String name, int amount) {
		if (balance >= amount) {
			balance = balance - amount;
			if (balance < 0) {
				System.out.println("Overdrawn!");
				// remove the ‘synchronized’ keyword and run the test several times,
				// if you see the account overdrawn, that’s concurrency issues (lost update)
			}
		} else {
			System.out.println("Sorry, not enough for " + name);
		}
	}

}
