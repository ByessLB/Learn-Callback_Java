
public class Main2 {

    public static void main(String[] args) {

        Customtimer timer = new Customtimer();
        timer.start(new TimerListener() {

            @Override
            public void onStart() {
                System.out.println("Timer started");
            }

            @Override
            public void onRun() {
                System.out.println("Timer running...");
            }

            @Override
            public void onFinish() {
                System.out.println("Timer finished");
            }

        });
    }
}
