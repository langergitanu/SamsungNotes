package org.junit.internal.requests;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.junit.runner.Request;
import org.junit.runner.Runner;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
abstract class MemoizingRequest extends Request {
    private volatile Runner runner;
    private final Lock runnerLock = new ReentrantLock();

    public abstract Runner createRunner();

    @Override // org.junit.runner.Request
    public final Runner getRunner() {
        if (this.runner == null) {
            this.runnerLock.lock();
            try {
                if (this.runner == null) {
                    this.runner = createRunner();
                }
            } finally {
                this.runnerLock.unlock();
            }
        }
        return this.runner;
    }
}
