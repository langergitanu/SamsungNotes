package org.apache.poi.sun.awt;

import org.apache.poi.java.awt.AWTEvent;
import org.apache.poi.java.awt.EventQueue;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
class PostEventQueue {
    private final EventQueue eventQueue;
    private EventQueueItem queueHead = null;
    private EventQueueItem queueTail = null;
    private Thread flushThread = null;

    public PostEventQueue(EventQueue eventQueue) {
        this.eventQueue = eventQueue;
    }

    public void flush() {
        Thread threadCurrentThread = Thread.currentThread();
        try {
            synchronized (this) {
                try {
                    if (threadCurrentThread == this.flushThread) {
                        return;
                    }
                    while (this.flushThread != null) {
                        wait();
                    }
                    EventQueueItem eventQueueItem = this.queueHead;
                    if (eventQueueItem == null) {
                        return;
                    }
                    this.flushThread = threadCurrentThread;
                    this.queueTail = null;
                    this.queueHead = null;
                    while (eventQueueItem != null) {
                        try {
                            this.eventQueue.postEvent(eventQueueItem.event);
                            eventQueueItem = eventQueueItem.next;
                        } catch (Throwable th) {
                            synchronized (this) {
                                this.flushThread = null;
                                notifyAll();
                                throw th;
                            }
                        }
                    }
                    synchronized (this) {
                        this.flushThread = null;
                        notifyAll();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } catch (InterruptedException unused) {
            threadCurrentThread.interrupt();
        }
    }

    public void postEvent(AWTEvent aWTEvent) {
        EventQueueItem eventQueueItem = new EventQueueItem(aWTEvent);
        synchronized (this) {
            try {
                if (this.queueHead == null) {
                    this.queueTail = eventQueueItem;
                    this.queueHead = eventQueueItem;
                } else {
                    this.queueTail.next = eventQueueItem;
                    this.queueTail = eventQueueItem;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        SunToolkit.wakeupEventQueue(this.eventQueue, aWTEvent.getSource() == AWTAutoShutdown.getInstance());
    }
}
