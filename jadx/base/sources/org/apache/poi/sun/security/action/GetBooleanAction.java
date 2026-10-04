package org.apache.poi.sun.security.action;

import java.security.PrivilegedAction;

/* JADX INFO: loaded from: classes10.dex */
public class GetBooleanAction implements PrivilegedAction<Boolean> {
    private String theProp;

    public GetBooleanAction(String str) {
        this.theProp = str;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.security.PrivilegedAction
    public Boolean run() {
        return Boolean.valueOf(Boolean.getBoolean(this.theProp));
    }
}
