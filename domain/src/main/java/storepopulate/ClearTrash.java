package storepopulate;

import java.util.concurrent.Semaphore;

import static java.lang.Thread.*;

public class ClearTrash implements Runnable{
    Semaphore sem;
    Trash trash;
    String name;

    public ClearTrash(Semaphore sem, Trash trash, String name) {
        this.sem = sem;
        this.trash = trash;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            sem.acquire();
            Thread.sleep(3000);
            trash.clearTrash();
            System.out.println(name+ " :  trash is cleared");

        } catch (InterruptedException e) {
            e.printStackTrace(); }
        System.out.println(name + " releases permission");
        sem.release();

    }

}
