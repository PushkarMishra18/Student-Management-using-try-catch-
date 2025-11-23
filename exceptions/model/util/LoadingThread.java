package util;

public class LoadingThread extends Thread {
    public void run() {
        try {
            System.out.println("Processing...");
            Thread.sleep(800);
            System.out.println("Done.\n");
        } catch (Exception e) {}
    }
}
