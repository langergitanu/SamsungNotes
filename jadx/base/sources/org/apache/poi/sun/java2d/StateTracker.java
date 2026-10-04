package org.apache.poi.sun.java2d;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface StateTracker {
    public static final StateTracker ALWAYS_CURRENT = new StateTracker() { // from class: org.apache.poi.sun.java2d.StateTracker.1
        @Override // org.apache.poi.sun.java2d.StateTracker
        public boolean isCurrent() {
            return true;
        }
    };
    public static final StateTracker NEVER_CURRENT = new StateTracker() { // from class: org.apache.poi.sun.java2d.StateTracker.2
        @Override // org.apache.poi.sun.java2d.StateTracker
        public boolean isCurrent() {
            return false;
        }
    };

    boolean isCurrent();
}
