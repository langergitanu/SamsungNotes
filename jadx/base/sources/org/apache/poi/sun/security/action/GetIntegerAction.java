package org.apache.poi.sun.security.action;

import java.security.PrivilegedAction;

/* JADX INFO: loaded from: classes10.dex */
public class GetIntegerAction implements PrivilegedAction<Integer> {
    private boolean defaultSet = false;
    private int defaultVal;
    private String theProp;

    public GetIntegerAction(String str) {
        this.theProp = str;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.security.PrivilegedAction
    public Integer run() {
        Integer integer = Integer.getInteger(this.theProp);
        return (integer == null && this.defaultSet) ? new Integer(this.defaultVal) : integer;
    }

    public GetIntegerAction(String str, int i) {
        this.theProp = str;
        this.defaultVal = i;
    }
}
