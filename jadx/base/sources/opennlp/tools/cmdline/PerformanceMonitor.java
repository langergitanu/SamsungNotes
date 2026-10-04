package opennlp.tools.cmdline;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import java.io.PrintStream;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import opennlp.tools.commons.Internal;
import opennlp.tools.log.LogPrintStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
public class PerformanceMonitor {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) PerformanceMonitor.class);
    private ScheduledFuture<?> beeperHandle;
    private volatile int counter;
    private final PrintStream out;
    private final ScheduledExecutorService scheduler;
    private volatile long startTime;
    private final String unit;

    public PerformanceMonitor(PrintStream printStream, String str) {
        this.scheduler = Executors.newScheduledThreadPool(1, new ThreadFactoryC13623a(0));
        this.startTime = -1L;
        this.out = printStream;
        this.unit = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Thread lambda$new$0(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName("opennlp.tools.cmdline.PerformanceMonitor");
        thread.setDaemon(true);
        return thread;
    }

    public void incrementCounter(int i) {
        if (!isStarted()) {
            throw new IllegalStateException("Must be started first!");
        }
        if (i < 0) {
            throw new IllegalArgumentException(AbstractC0541b.m767i(i, "increment must be zero or positive but was ", "!"));
        }
        this.counter += i;
    }

    public boolean isStarted() {
        return this.startTime != -1;
    }

    public void start() {
        if (isStarted()) {
            throw new IllegalStateException("Already started!");
        }
        this.startTime = System.currentTimeMillis();
    }

    public void startAndPrintThroughput() {
        start();
        this.beeperHandle = this.scheduler.scheduleAtFixedRate(new Runnable() { // from class: opennlp.tools.cmdline.PerformanceMonitor.1
            private int lastCount;
            private long lastTimeStamp;

            {
                this.lastTimeStamp = PerformanceMonitor.this.startTime;
                this.lastCount = PerformanceMonitor.this.counter;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i = PerformanceMonitor.this.counter - this.lastCount;
                long jCurrentTimeMillis = System.currentTimeMillis() - this.lastTimeStamp;
                double d = jCurrentTimeMillis > 0 ? ((double) i) / (jCurrentTimeMillis / 1000.0d) : 0.0d;
                long jCurrentTimeMillis2 = System.currentTimeMillis() - PerformanceMonitor.this.startTime;
                PerformanceMonitor.this.out.printf(AbstractC0622a.m1170p(PerformanceMonitor.this.unit, "%n", AbstractC0000a.m16m("current: %.1f ", PerformanceMonitor.this.unit, "/s avg: %.1f ", PerformanceMonitor.this.unit, "/s total: %d ")), Double.valueOf(d), Double.valueOf(jCurrentTimeMillis2 > 0 ? ((double) PerformanceMonitor.this.counter) / (jCurrentTimeMillis2 / 1000.0d) : 0.0d), Integer.valueOf(PerformanceMonitor.this.counter));
                this.lastTimeStamp = System.currentTimeMillis();
                this.lastCount = PerformanceMonitor.this.counter;
            }
        }, 1L, 1L, TimeUnit.SECONDS);
    }

    public void stopAndPrintFinalResult() {
        if (!isStarted()) {
            throw new IllegalStateException("Must be started first!");
        }
        ScheduledFuture<?> scheduledFuture = this.beeperHandle;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.scheduler.shutdown();
        long jCurrentTimeMillis = System.currentTimeMillis() - this.startTime;
        this.out.printf(AbstractC0541b.m773o("Average: %.1f ", this.unit, "/s %n"), Double.valueOf(jCurrentTimeMillis > 0 ? ((double) this.counter) / (jCurrentTimeMillis / 1000.0d) : 0.0d));
        this.out.println("Total: " + this.counter + " " + this.unit);
        this.out.println("Runtime: " + (((double) jCurrentTimeMillis) / 1000.0d) + "s");
    }

    public PerformanceMonitor(String str) {
        this(new LogPrintStream(logger), str);
    }

    public void incrementCounter() {
        incrementCounter(1);
    }
}
