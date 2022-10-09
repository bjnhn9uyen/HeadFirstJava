package ch18_Multithreading_Synchronizing_Atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class BankAccountAtomic {

	// since synchronization can come with some costs (like performance and potential deadlocks),
	// we can fix our ‘lost update’ problem with an AtomicInteger, instead of synchronizing the ‘spend’ method
	private AtomicInteger balance = new AtomicInteger(100);

	public AtomicInteger getBalance() {
		return balance;
	}

	public void spend(String name, int amount) {
		int initialBalance = balance.get();
		if (initialBalance >= amount) {
			// if the current balance is the same as the expected value, update it to the new value
			// if this is false, the balance wasn’t changed and you decide what you need to do next
			boolean success = balance.compareAndSet(initialBalance, initialBalance - amount);
			if (!success) {
				System.out.println("Sorry " + name + ", you haven't spent the money");
			}
		} else {
			System.out.println("Sorry, not enough for " + name);
		}

	}

}
