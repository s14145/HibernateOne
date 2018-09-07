package FileJava;

class BankAccount{
	
	private static int balance;
	
	public BankAccount(int b) {
		balance=b;
	}
	
	public BankAccount() {
		balance=0;
	}

	public static int getBalance() {
		return balance;
	}
	
	public synchronized int withdraw(int w) {
		int b=getBalance();
		if(w<=b) {
			balance=balance-w;
			return w;
			}else
				return 0;
	}
	
}

class WithdrawAccount implements Runnable{
	private BankAccount acc;
	private int amount;
	
	public WithdrawAccount() {
		acc=null;
		amount=0;
	}
	
	public WithdrawAccount(BankAccount acc,int amount) {
		this.acc=acc;
		this.amount=amount;
	}

	@Override
	public void run() {
		int w;
		
		for(int i=0;i<20;i++) {
			try {
				Thread.sleep(200);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			
		// when thread is having class level lock then next thread can acquire object level lock
			System.out.println("Count is: "+i+" =Balance before "+Thread.currentThread().getName()+" withdrawal: "+acc.getBalance());
			w=acc.withdraw(amount);
			System.out.println("Count is: "+i+" =Balance after "+Thread.currentThread().getName()+" withdrawal: "+acc.getBalance());
		// if(l.trylock()){
		// safe operation}
		// else { alternate operation
		//	}
		
	}
	}
	
}

public class TestBankAccount {

	public static void main(String[] args) {
		BankAccount BA=new BankAccount(1000);
		WithdrawAccount w1=new WithdrawAccount(BA,10);
		Thread t1=new Thread(w1);
		t1.setName("First Thread");
		
		Thread t2=new Thread(w1);
		t2.setName("Second Thread");
		
		t1.start();
		t2.start();
		

	}

}
