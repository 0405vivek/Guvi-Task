// // Write a Java program that prints even and odd numbers alternately using two threads. 
// // One thread should print even numbers, and the other should print odd numbers. 
// // The output should be in a sequence, e.g., 1, 2, 3, 4, 5, 6,....

// class evenOddPrint{

//     private int number=1;
//     private final int MAX=100;

//     // method fr even numbers 

//     public synchronised void printEven() throws InterruptedException{

//         while(number<=MAX){
//             // wait if no is odd 
//             while(number % 2 !=0 ){
//                 wait();
//             }
//             System.out.println(number);
//             number++;
//             notify();
//         }

//     }
//     public synchronised void printOdd() throws InterruptedException}{

//         while(number<=MAX){
//             // wait if no is odd 
//             while(number % 2 ==0 ){
//                 wait();
//             }
//             System.out.println(number);
//             number++;
//             notify();
//         }
//     }

//     public static void main(){

//         evenOddPrint p=new evenOddPrint();
//         Thread e=new Thread(()->{
//             try{
//                 print.printEven();

//             }
//             catch(e){

//             }
//         });

//         Thread o=new Thread(()->{
//             try{
//                 print.printOdd();

//             }
//             catch(e){

//             }
//         });
//     }
//     }


//     }


//     // You have a shared resource (e.g., a list of records) 
//     // that can be read by multiple threads but can only be written by one thread at a time. 
//     // Implement a system with multiple reader threads and a single writer thread

//     class SharedResource{
//         private String data="Initial data";

//         private final ReadWriteLock lock=new ReentrantLock();

//         public String read(){
//             lock.readLock().lock();
//             try{
//                 Sysyem.out.print(Thread.currentTHread().getname());
//                 return data;
//             }
//             finally{

//             }
//         }



//     }



//     // In a banking system, multiple threads might access the same account 
//     // balance (e.g., deposits or withdrawals). A transaction should ensure that 
//     // the account balance is updated
//     //  correctly and consistently even with concurrent deposits or withdrawals.

//     // Suppose several threads need to read from or write to a shared file. 
//     // Reading operations can be performed simultaneously, 
//     // but writing requires exclusive access to
//     //  ensure the file content is not corrupted.



//     // A cache is used to store frequently accessed data. Multiple threads
//     //  may access the cache at the same time, and occasionally, the cache might need to be updated or
//     //  invalidated (e.g., when the data expires or is updated).



//     // In this problem, multiple philosophers sit at a table with a fork between each pair
//     //  of philosophers. A philosopher can either think or eat. To eat, a philosopher needs both forks. 
//     // The challenge is to avoid deadlocks and ensure that all philosophers get a chance to eat.




import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class EvenOddPrint {

    private int number = 1;
    private final int MAX = 100;

    // Method for even numbers
    public synchronized void printEven() throws InterruptedException {
        while (number <= MAX) {
            while (number % 2 != 0) {
                wait();
            }
            System.out.println(number);
            number++;
            notify();
        }
    }

    // Method for odd numbers
    public synchronized void printOdd() throws InterruptedException {
        while (number <= MAX) {
            while (number % 2 == 0) {
                wait();
            }
            System.out.println(number);
            number++;
            notify();
        }
    }

    public static void main(String[] args) {
        EvenOddPrint print = new EvenOddPrint();

        Thread evenThread = new Thread(() -> {
            try {
                print.printEven();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread oddThread = new Thread(() -> {
            try {
                print.printOdd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        evenThread.start();
        oddThread.start();
    }
}

class SharedResource {
    private String data = "Initial data";
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public String read() {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " reading: " + data);
            return data;
        } finally {
            lock.readLock().unlock();
        }
    }

    public void write(String newData) {
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " writing: " + newData);
            this.data = newData;
        } finally {
            lock.writeLock().unlock();
        }
    }
}

class BankAccount {
    private int balance;

    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposited " + amount + ", new balance: " + balance);
    }

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew " + amount + ", new balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " attempted to withdraw " + amount + " but insufficient funds.");
        }
    }
}

// Example usage with multiple threads
total.public class BankingSystem {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        Thread t1 = new Thread(() -> account.deposit(500));
        Thread t2 = new Thread(() -> account.withdraw(200));
        Thread t3 = new Thread(() -> account.withdraw(1000));

        t1.start();
        t2.start();
        t3.start();
    }
}
