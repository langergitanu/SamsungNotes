package org.apache.xmlbeans.impl.common;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class Mutex {
    private Thread owner = null;
    private int lock_count = 0;

    public synchronized void acquire() {
        while (!tryToAcquire()) {
            wait();
        }
    }

    public synchronized void release() {
        if (this.owner != Thread.currentThread()) {
            throw new IllegalStateException("Thread calling release() doesn't own mutex");
        }
        int i = this.lock_count - 1;
        this.lock_count = i;
        if (i <= 0) {
            this.owner = null;
            notify();
        }
    }

    public synchronized boolean tryToAcquire() {
        Thread thread = this.owner;
        if (thread == null) {
            this.owner = Thread.currentThread();
            this.lock_count = 1;
            return true;
        }
        if (thread != Thread.currentThread()) {
            return false;
        }
        this.lock_count++;
        return true;
    }
}
