public class HumanRobotOperator implements RobotOperator {

    @Override
    public void run(RobotWorker robot) {
        robot.work();
        robot.stopWorking();
        
    }
}
