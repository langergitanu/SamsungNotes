package org.apache.poi.sun.security.action;

import java.security.PrivilegedAction;

/* JADX INFO: loaded from: classes10.dex */
public class GetLongAction implements PrivilegedAction<Long> {
    private boolean defaultSet = false;
    private long defaultVal;
    private String theProp;

    public GetLongAction(String str) {
        this.theProp = str;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.security.PrivilegedAction
    public Long run() {
        Long l = Long.getLong(this.theProp);
        return (l == null && this.defaultSet) ? new Long(this.defaultVal) : l;
    }

    public GetLongAction(String str, long j) {
        this.theProp = str;
        this.defaultVal = j;
    }
}
