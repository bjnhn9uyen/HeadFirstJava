package ch18_Multithreading_Synchronizing_Atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RyanAndMonicaTest {

	public static void main(String[] args) {

		// bank account instance represents shared account of Ryan and Monica, two people — one bank account
		// two or more threads accessing the same object can lead to concurrency issues (lost update)
		for (int i = 0; i < 10; i++) {
//			BankAccountSynchronized account = new BankAccountSynchronized();
			BankAccountAtomic account = new BankAccountAtomic();
			RyanAndMonicaJob ryan = new RyanAndMonicaJob("Ryan", account, 50);
			RyanAndMonicaJob monica = new RyanAndMonicaJob("Monica", account, 100);
			ExecutorService executor = Executors.newFixedThreadPool(2);
			executor.execute(ryan);
			executor.execute(monica);
			executor.shutdown();
			try {
				// wait up to 1 minute for the ExecutorService to finish everything
				executor.awaitTermination(1, TimeUnit.MINUTES);
				System.out.println();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
