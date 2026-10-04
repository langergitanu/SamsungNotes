package org.apache.poi.java.awt;

import org.apache.poi.sun.awt.AppContext;
import org.apache.poi.sun.awt.SunToolkit;

/* JADX INFO: loaded from: classes10.dex */
class SentEvent extends AWTEvent implements ActiveEvent {

    /* JADX INFO: renamed from: ID */
    static final int f10097ID = 1007;
    private static final long serialVersionUID = -383615247028828931L;
    boolean dispatched;
    private AWTEvent nested;
    private AppContext toNotify;

    public SentEvent() {
        this(null);
    }

    public void dispatch() {
        try {
            if (this.nested != null) {
                Toolkit.getEventQueue().dispatchEvent(this.nested);
            }
            this.dispatched = true;
            AppContext appContext = this.toNotify;
            if (appContext != null) {
                SunToolkit.postEvent(appContext, new SentEvent());
            }
            synchronized (this) {
                notifyAll();
            }
        } catch (Throwable th) {
            this.dispatched = true;
            AppContext appContext2 = this.toNotify;
            if (appContext2 != null) {
                SunToolkit.postEvent(appContext2, new SentEvent());
            }
            synchronized (this) {
                notifyAll();
                throw th;
            }
        }
    }

    public final void dispose() {
        this.dispatched = true;
        AppContext appContext = this.toNotify;
        if (appContext != null) {
            SunToolkit.postEvent(appContext, new SentEvent());
        }
        synchronized (this) {
            notifyAll();
        }
    }

    public SentEvent(AWTEvent aWTEvent) {
        this(aWTEvent, null);
    }

    public SentEvent(AWTEvent aWTEvent, AppContext appContext) {
        super(aWTEvent != null ? aWTEvent.getSource() : Toolkit.getDefaultToolkit(), 1007);
        this.nested = aWTEvent;
        this.toNotify = appContext;
    }
}
