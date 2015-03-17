public class RobotWorker implements Worker {

    @Override
    public void work() {
        System.out.println("RobotWorker.work");
    }

    @Override
    public void stopWorking() {
        System.out.println("RobotWorker.stopWorking");
    }

  
}
