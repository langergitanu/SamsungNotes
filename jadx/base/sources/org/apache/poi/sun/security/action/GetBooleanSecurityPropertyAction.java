package org.apache.poi.sun.security.action;

import java.security.PrivilegedAction;
import java.security.Security;

/* JADX INFO: loaded from: classes10.dex */
public class GetBooleanSecurityPropertyAction implements PrivilegedAction<Boolean> {
    private String theProp;

    public GetBooleanSecurityPropertyAction(String str) {
        this.theProp = str;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.security.PrivilegedAction
    public Boolean run() {
        boolean z = false;
        try {
            String property = Security.getProperty(this.theProp);
            if (property != null) {
                if (property.equalsIgnoreCase("true")) {
                    z = true;
                }
            }
        } catch (NullPointerException unused) {
        }
        return Boolean.valueOf(z);
    }
}
