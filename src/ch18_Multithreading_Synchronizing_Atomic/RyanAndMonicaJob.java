package ch18_Multithreading_Synchronizing_Atomic;

public class RyanAndMonicaJob implements Runnable {

	private String name;
//	private BankAccountSynchronized account;
	private BankAccountAtomic account;
	private int amountToSpend;
	
//	public RyanAndMonicaJob(String name, BankAccountSynchronized account, int amountToSpend) {
//		this.name = name;
//		this.account = account;
//		this.amountToSpend = amountToSpend;
//	}

	public RyanAndMonicaJob(String name, BankAccountAtomic account, int amountToSpend) {
		this.name = name;
		this.account = account;
		this.amountToSpend = amountToSpend;
	}

	@Override
	public void run() {
		goShopping(amountToSpend);
	}

	private void goShopping(int amount) {
		System.out.println(name + " is about to spend");
		account.spend(name, amount);
		System.out.println(name + " finishs the spend");
	}

}