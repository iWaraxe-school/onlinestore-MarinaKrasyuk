package storepopulate;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ProcessingOfOrder  implements Runnable{
    Semaphore sem;
    Product product;
    String name;
    Trash trash;
    public ProcessingOfOrder(Semaphore sem,Trash trash,Product product, String name) {

        this.trash=trash;
        this.sem = sem;
        this.product=product;
        this.name=name;
    }

    @Override
    public void run() {
        Random random = new Random();
        int randomtime=random.nextInt(30)*1000;

        try {
            sem.acquire();
            Thread.sleep(randomtime);
            trash.addToTrash(product);
            System.out.println(name+ " :  product "+ product.getName()+" is added to the Trash");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " releases permission");
        sem.release();
    }
}
