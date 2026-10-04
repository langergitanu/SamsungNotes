package org.apache.poi.java.awt;

import java.util.LinkedList;
import org.apache.poi.sun.awt.AWTAccessor;
import org.apache.poi.sun.awt.AppContext;
import org.apache.poi.sun.awt.SunToolkit;

/* JADX INFO: loaded from: classes10.dex */
class SequencedEvent extends AWTEvent implements ActiveEvent {

    /* JADX INFO: renamed from: ID */
    private static final int f10098ID = 1006;
    private static final LinkedList list = new LinkedList();
    private static final long serialVersionUID = 547742659238625067L;
    private AppContext appContext;
    private boolean disposed;
    private final AWTEvent nested;

    static {
        AWTAccessor.setSequencedEventAccessor(new AWTAccessor.SequencedEventAccessor() { // from class: org.apache.poi.java.awt.SequencedEvent.1
            @Override // org.apache.poi.sun.awt.AWTAccessor.SequencedEventAccessor
            public AWTEvent getNested(AWTEvent aWTEvent) {
                return ((SequencedEvent) aWTEvent).nested;
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.SequencedEventAccessor
            public boolean isSequencedEvent(AWTEvent aWTEvent) {
                return aWTEvent instanceof SequencedEvent;
            }
        });
    }

    public SequencedEvent(AWTEvent aWTEvent) {
        super(aWTEvent.getSource(), 1006);
        this.nested = aWTEvent;
        SunToolkit.setSystemGenerated(aWTEvent);
        synchronized (SequencedEvent.class) {
            list.add(this);
        }
    }

    private static final synchronized SequencedEvent getFirst() {
        return (SequencedEvent) list.getFirst();
    }

    private static final SequencedEvent getFirstWithContext() {
        while (true) {
            SequencedEvent first = getFirst();
            if (!isOwnerAppContextDisposed(first)) {
                return first;
            }
            first.dispose();
        }
    }

    private static final boolean isOwnerAppContextDisposed(SequencedEvent sequencedEvent) {
        if (sequencedEvent == null) {
            return false;
        }
        Object source = sequencedEvent.nested.getSource();
        if (source instanceof Component) {
            return ((Component) source).appContext.isDisposed();
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0041 A[Catch: all -> 0x0023, TRY_LEAVE, TryCatch #0 {all -> 0x0023, blocks: (B:2:0x0000, B:4:0x000c, B:6:0x0012, B:9:0x0025, B:12:0x002d, B:21:0x003c, B:22:0x003d, B:24:0x0041, B:13:0x002e, B:14:0x0035, B:18:0x0039), top: B:29:0x0000, inners: #1 }] */
    @Override // org.apache.poi.java.awt.ActiveEvent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void dispatch() {
        try {
            this.appContext = AppContext.getAppContext();
            if (getFirst() != this) {
                if (EventQueue.isDispatchThread()) {
                    ((EventDispatchThread) Thread.currentThread()).pumpEvents(1007, new Conditional() { // from class: org.apache.poi.java.awt.SequencedEvent.2
                        @Override // org.apache.poi.java.awt.Conditional
                        public boolean evaluate() {
                            return !SequencedEvent.this.isFirstOrDisposed();
                        }
                    });
                } else {
                    while (!isFirstOrDisposed()) {
                        synchronized (SequencedEvent.class) {
                            try {
                                SequencedEvent.class.wait(1000L);
                            } catch (InterruptedException unused) {
                                if (!this.disposed) {
                                }
                                dispose();
                            } finally {
                            }
                        }
                    }
                }
            }
            if (!this.disposed) {
                KeyboardFocusManager.getCurrentKeyboardFocusManager().setCurrentSequencedEvent(this);
                Toolkit.getEventQueue().dispatchEvent(this.nested);
            }
            dispose();
        } catch (Throwable th) {
            dispose();
            throw th;
        }
    }

    public final void dispose() {
        AppContext appContext;
        synchronized (SequencedEvent.class) {
            try {
                if (this.disposed) {
                    return;
                }
                SequencedEvent sequencedEvent = null;
                if (KeyboardFocusManager.getCurrentKeyboardFocusManager().getCurrentSequencedEvent() == this) {
                    KeyboardFocusManager.getCurrentKeyboardFocusManager().setCurrentSequencedEvent(null);
                }
                this.disposed = true;
                AppContext appContext2 = this.appContext;
                if (appContext2 != null) {
                    SunToolkit.postEvent(appContext2, new SentEvent());
                }
                synchronized (SequencedEvent.class) {
                    try {
                        SequencedEvent.class.notifyAll();
                        LinkedList linkedList = list;
                        if (linkedList.getFirst() == this) {
                            linkedList.removeFirst();
                            if (!linkedList.isEmpty()) {
                                sequencedEvent = (SequencedEvent) linkedList.getFirst();
                            }
                        } else {
                            linkedList.remove(this);
                        }
                    } finally {
                    }
                }
                if (sequencedEvent == null || (appContext = sequencedEvent.appContext) == null) {
                    return;
                }
                SunToolkit.postEvent(appContext, new SentEvent());
            } finally {
            }
        }
    }

    public final boolean isFirstOrDisposed() {
        return this.disposed || this == getFirstWithContext() || this.disposed;
    }
}
