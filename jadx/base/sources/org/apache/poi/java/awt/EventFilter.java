package org.apache.poi.java.awt;

/* JADX INFO: loaded from: classes10.dex */
interface EventFilter {

    public enum FilterAction {
        ACCEPT,
        REJECT,
        ACCEPT_IMMEDIATELY
    }

    FilterAction acceptEvent(AWTEvent aWTEvent);
}
