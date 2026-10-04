package org.apache.poi.sun.security.action;

import java.security.PrivilegedAction;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LoadLibraryAction implements PrivilegedAction<Void> {
    private String theLib;

    public LoadLibraryAction(String str) {
        this.theLib = str;
    }

    @Override // java.security.PrivilegedAction
    public Void run() {
        return null;
    }
}
