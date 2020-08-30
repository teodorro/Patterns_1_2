import java.time.LocalDateTime;

public class Logger {
    protected int num = 1;

    private static Logger logger;

    public static Logger getInstance(){
        if (logger == null)
            logger = new Logger();
        return logger;
    }

    private Logger() {
    }

    public void log(String msg) {
        System.out.println("[" + LocalDateTime.now().toString() + " " + num++ + "] " + msg);
    }
}
