package org.apache.poi.java.awt;

import androidx.glance.AbstractC2821a;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.poi.sun.awt.PeerEvent;
import org.apache.poi.sun.util.logging.PlatformLogger;

/* JADX INFO: loaded from: classes10.dex */
class WaitDispatchSupport implements SecondaryLoop {
    private static final PlatformLogger log = PlatformLogger.getLogger("org.apache.poi.java.awt.event.WaitDispatchSupport");
    private static Timer timer;
    private volatile Conditional condition;
    private EventDispatchThread dispatchThread;
    private volatile Conditional extCondition;
    private EventFilter filter;
    private long interval;
    private AtomicBoolean keepBlockingCT;
    private AtomicBoolean keepBlockingEDT;
    private TimerTask timerTask;
    private final Runnable wakingRunnable;

    public WaitDispatchSupport(EventDispatchThread eventDispatchThread) {
        this(eventDispatchThread, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object getTreeLock() {
        return Component.LOCK;
    }

    private static synchronized void initializeTimer() {
        if (timer == null) {
            timer = new Timer("AWT-WaitDispatchSupport-Timer", true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wakeupEDT() {
        log.finest("wakeupEDT(): EDT == " + this.dispatchThread);
        this.dispatchThread.getEventQueue().postEvent(new PeerEvent(this, this.wakingRunnable, 1L));
    }

    @Override // org.apache.poi.java.awt.SecondaryLoop
    public boolean enter() {
        EventFilter eventFilter;
        PlatformLogger platformLogger = log;
        platformLogger.fine("enter(): blockingEDT=" + this.keepBlockingEDT.get() + ", blockingCT=" + this.keepBlockingCT.get());
        if (!this.keepBlockingEDT.compareAndSet(false, true)) {
            platformLogger.fine("The secondary loop is already running, aborting");
            return false;
        }
        final Runnable runnable = new Runnable() { // from class: org.apache.poi.java.awt.WaitDispatchSupport.2
            @Override // java.lang.Runnable
            public void run() {
                WaitDispatchSupport.log.fine("Starting a new event pump");
                if (WaitDispatchSupport.this.filter == null) {
                    WaitDispatchSupport.this.dispatchThread.pumpEvents(WaitDispatchSupport.this.condition);
                } else {
                    WaitDispatchSupport.this.dispatchThread.pumpEventsForFilter(WaitDispatchSupport.this.condition, WaitDispatchSupport.this.filter);
                }
            }
        };
        Thread threadCurrentThread = Thread.currentThread();
        if (threadCurrentThread == this.dispatchThread) {
            platformLogger.finest("On dispatch thread: " + this.dispatchThread);
            if (this.interval != 0) {
                platformLogger.finest(AbstractC2821a.m2224o(new StringBuilder("scheduling the timer for "), " ms", this.interval));
                Timer timer2 = timer;
                TimerTask timerTask = new TimerTask() { // from class: org.apache.poi.java.awt.WaitDispatchSupport.3
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        if (WaitDispatchSupport.this.keepBlockingEDT.compareAndSet(true, false)) {
                            WaitDispatchSupport.this.wakeupEDT();
                        }
                    }
                };
                this.timerTask = timerTask;
                timer2.schedule(timerTask, this.interval);
            }
            SequencedEvent currentSequencedEvent = KeyboardFocusManager.getCurrentKeyboardFocusManager().getCurrentSequencedEvent();
            if (currentSequencedEvent != null) {
                platformLogger.fine("Dispose current SequencedEvent: " + currentSequencedEvent);
                currentSequencedEvent.dispose();
            }
            AccessController.doPrivileged(new PrivilegedAction() { // from class: org.apache.poi.java.awt.WaitDispatchSupport.4
                @Override // java.security.PrivilegedAction
                public Object run() {
                    runnable.run();
                    return null;
                }
            });
        } else {
            platformLogger.finest("On non-dispatch thread: " + threadCurrentThread);
            synchronized (getTreeLock()) {
                EventFilter eventFilter2 = this.filter;
                if (eventFilter2 != null) {
                    this.dispatchThread.addEventFilter(eventFilter2);
                }
                try {
                    try {
                        this.dispatchThread.getEventQueue().postEvent(new PeerEvent(this, runnable, 1L));
                        this.keepBlockingCT.set(true);
                        if (this.interval > 0) {
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            while (this.keepBlockingCT.get() && (this.extCondition == null || this.extCondition.evaluate())) {
                                if (this.interval + jCurrentTimeMillis <= System.currentTimeMillis()) {
                                    break;
                                }
                                getTreeLock().wait(this.interval);
                            }
                        } else {
                            while (this.keepBlockingCT.get() && (this.extCondition == null || this.extCondition.evaluate())) {
                                getTreeLock().wait();
                            }
                        }
                        log.fine("waitDone " + this.keepBlockingEDT.get() + " " + this.keepBlockingCT.get());
                        eventFilter = this.filter;
                    } catch (InterruptedException e) {
                        log.fine("Exception caught while waiting: " + e);
                        eventFilter = this.filter;
                        if (eventFilter != null) {
                        }
                        this.keepBlockingEDT.set(false);
                        this.keepBlockingCT.set(false);
                    }
                    if (eventFilter != null) {
                        this.dispatchThread.removeEventFilter(eventFilter);
                    }
                    this.keepBlockingEDT.set(false);
                    this.keepBlockingCT.set(false);
                } catch (Throwable th) {
                    EventFilter eventFilter3 = this.filter;
                    if (eventFilter3 != null) {
                        this.dispatchThread.removeEventFilter(eventFilter3);
                    }
                    throw th;
                }
            }
        }
        return true;
    }

    @Override // org.apache.poi.java.awt.SecondaryLoop
    public boolean exit() {
        log.fine("exit(): blockingEDT=" + this.keepBlockingEDT.get() + ", blockingCT=" + this.keepBlockingCT.get());
        if (!this.keepBlockingEDT.compareAndSet(true, false)) {
            return false;
        }
        wakeupEDT();
        return true;
    }

    public WaitDispatchSupport(EventDispatchThread eventDispatchThread, Conditional conditional) {
        this.keepBlockingEDT = new AtomicBoolean(false);
        this.keepBlockingCT = new AtomicBoolean(false);
        this.wakingRunnable = new Runnable() { // from class: org.apache.poi.java.awt.WaitDispatchSupport.5
            @Override // java.lang.Runnable
            public void run() {
                WaitDispatchSupport.log.fine("Wake up EDT");
                synchronized (WaitDispatchSupport.getTreeLock()) {
                    WaitDispatchSupport.this.keepBlockingCT.set(false);
                    WaitDispatchSupport.getTreeLock().notifyAll();
                }
                WaitDispatchSupport.log.fine("Wake up EDT done");
            }
        };
        if (eventDispatchThread == null) {
            throw new IllegalArgumentException("The dispatchThread can not be null");
        }
        this.dispatchThread = eventDispatchThread;
        this.extCondition = conditional;
        this.condition = new Conditional() { // from class: org.apache.poi.java.awt.WaitDispatchSupport.1
            @Override // org.apache.poi.java.awt.Conditional
            public boolean evaluate() {
                if (WaitDispatchSupport.log.isLoggable(300)) {
                    WaitDispatchSupport.log.finest("evaluate(): blockingEDT=" + WaitDispatchSupport.this.keepBlockingEDT.get() + ", blockingCT=" + WaitDispatchSupport.this.keepBlockingCT.get());
                }
                boolean zEvaluate = WaitDispatchSupport.this.extCondition != null ? WaitDispatchSupport.this.extCondition.evaluate() : true;
                if (WaitDispatchSupport.this.keepBlockingEDT.get() && zEvaluate) {
                    return true;
                }
                if (WaitDispatchSupport.this.timerTask == null) {
                    return false;
                }
                WaitDispatchSupport.this.timerTask.cancel();
                WaitDispatchSupport.this.timerTask = null;
                return false;
            }
        };
    }

    public WaitDispatchSupport(EventDispatchThread eventDispatchThread, Conditional conditional, EventFilter eventFilter, long j) {
        this(eventDispatchThread, conditional);
        this.filter = eventFilter;
        if (j < 0) {
            throw new IllegalArgumentException("The interval value must be >= 0");
        }
        this.interval = j;
        if (j != 0) {
            initializeTimer();
        }
    }
}
