
import java.util.Timer;
import java.util.TimerTask;

public class Customtimer {
    
    private Timer timer;

    private int timeInSec;

    public Customtimer() {
        this.timer = new Timer();
        this.timeInSec = 10;
    }

    public void start(TimerListener listener) {

        listener.onStart();

        timer.schedule(new TimerTask() {

            @Override
            public void run() {

                System.out.println(timeInSec + "s");
                listener.onRun();

                if (timeInSec == 0) {
                    System.out.println("Time's up!");
                    listener.onFinish();
                    cancel();
                }

                timeInSec--;
            }
        }, 1000, 1000);
    }

}
