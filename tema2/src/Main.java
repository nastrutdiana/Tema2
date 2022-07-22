import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        String direction1 = "Nord-South";
//        String direction2 = "West-East";

//        Semaphore semaphore = new Semaphore(2);
//        SemaphoreClass car1 = new SemaphoreClass(semaphore, direction1);
//        SemaphoreClass car2 = new SemaphoreClass(semaphore, direction1);
//        SemaphoreClass car3 = new SemaphoreClass(semaphore, direction2);
//        car1.start();
//        car2.start();
//        car3.start();
//        car1.join();
//        car2.join();
//        car3.join();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Number of cars: ");
        int nrOfCars = Integer.parseInt(scanner.nextLine());
        String[] directions = new String[nrOfCars];
        SemaphoreClass[] semaphores = new SemaphoreClass[nrOfCars];
        System.out.println("Directions (Nord-South or West-East)");
        for (int i = 0; i< nrOfCars;i++){
            directions[i] = scanner.nextLine();
        }

        int j =0;
        int nr = 1;
        int k =0;
        while (j<nrOfCars){
            while ((j < (nrOfCars-1)) && directions[j].equals(directions[j+1])){
                nr++;
                j++;
            }
            Semaphore s = new Semaphore(nr);
            for(int l=k; l<=j; l++){
                SemaphoreClass semaphore = new SemaphoreClass(s,directions[j]);
                semaphores[l] = semaphore;
                semaphore.start();
            }
            for(int l=k; l<=j; l++){
                semaphores[l].join();
            }
            nr = 1;
            j++;
            k = j;
        }
    }
}
