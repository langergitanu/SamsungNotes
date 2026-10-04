package cz.msebera.android.httpclient.impl.conn.tsccm;

import cz.msebera.android.httpclient.util.Args;
import java.util.Date;
import java.util.concurrent.locks.Condition;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Deprecated
public class WaitingThread {
    private boolean aborted;
    private final Condition cond;
    private final RouteSpecificPool pool;
    private Thread waiter;

    public WaitingThread(Condition condition, RouteSpecificPool routeSpecificPool) {
        Args.notNull(condition, "Condition");
        this.cond = condition;
        this.pool = routeSpecificPool;
    }

    public boolean await(Date date) throws InterruptedException {
        boolean zAwaitUntil;
        if (this.waiter != null) {
            throw new IllegalStateException("A thread is already waiting on this object.\ncaller: " + Thread.currentThread() + "\nwaiter: " + this.waiter);
        }
        if (this.aborted) {
            throw new InterruptedException("Operation interrupted");
        }
        this.waiter = Thread.currentThread();
        try {
            if (date != null) {
                zAwaitUntil = this.cond.awaitUntil(date);
            } else {
                this.cond.await();
                zAwaitUntil = true;
            }
            if (this.aborted) {
                throw new InterruptedException("Operation interrupted");
            }
            this.waiter = null;
            return zAwaitUntil;
        } catch (Throwable th) {
            this.waiter = null;
            throw th;
        }
    }

    public final Condition getCondition() {
        return this.cond;
    }

    public final RouteSpecificPool getPool() {
        return this.pool;
    }

    public final Thread getThread() {
        return this.waiter;
    }

    public void interrupt() {
        this.aborted = true;
        this.cond.signalAll();
    }

    public void wakeup() {
        if (this.waiter == null) {
            throw new IllegalStateException("Nobody waiting on this object.");
        }
        this.cond.signalAll();
    }
}
