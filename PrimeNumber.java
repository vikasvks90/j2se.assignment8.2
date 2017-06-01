/**
* <h1>PrimeNumber</h1>
* This program implement a class that checks whether a given number is a 
* prime using both the Thread class and Runnable interface
* @author  Vikas
* @version 1.0
* @since   2017-05-30 
*/
package assignment8.session2;

//here we are passing the object of PrimeNumber class while creating the Thread
//we have implemented the same concept in both using Thread class and Runnable interface
public class PrimeNumber { 
	int givenNumber;//this number will be passed while creating the object
	
	public PrimeNumber(int givenNumber) {
		super();
		this.givenNumber = givenNumber;
	}

	public static void main(String args[]) {
		PrimeNumber prime1 = new PrimeNumber(8);
		PrimeNumber prime2 = new PrimeNumber(3);
		PrimeThread thread1 = new PrimeThread(prime1);//passing the PrimeNumber object in the PrimeThread class 
		Thread thread2 = new Thread(new PrimeRunnable(prime2));//passing the PrimeNumber object in the PrimeRunnable class
		thread1.start();//start thread1
		thread2.start();//start thread2
	}
	
}

//this class shows the concept how we can create thread by extending Thread class
class PrimeThread extends Thread {
	PrimeNumber prime;
	
	public PrimeThread(PrimeNumber prime) {
		super();
		this.prime = prime;
	}

	public void run() {
		System.out.println("Checking prime number extending Thread class");
		int number = prime.givenNumber;
			if(isPrimeNumber(number)){
				System.out.println (number+" is a prime number");
			}
			else{
				System.out.println (number+" is not a prime number");
			}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//this method checks whether a given number is prime or not
	public static boolean isPrimeNumber(int number){
		if(number == 0 || number == 1){
			return false;
		}
        
		else {
        for(int i=2; i<=number/2; i++){
            if(number % i == 0 ){
                return false;
            }
        }
        return true;
		}
    }
}

//this class shows the concept how we can create thread by implementing Runnable interface
class PrimeRunnable implements Runnable {
	PrimeNumber prime;
	
	public PrimeRunnable(PrimeNumber prime) {
		super();
		this.prime = prime;
	}

	public void run() {
		System.out.println("Checking prime number implementing Runnable interface");
		int number = prime.givenNumber;
			if(isPrimeNumber(number)){
				System.out.println (number+" is a prime number");
			}
			else{
				System.out.println (number+" is not a prime number");
			}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//this method checks whether a given number is prime or not
	public static boolean isPrimeNumber(int number){
		if(number == 0 || number == 1){
			return false;
		}
        
		else {
        for(int i=2; i<=number/2; i++){
            if(number % i == 0 ){
                return false;
            }
        }
        return true;
		}
    }
}