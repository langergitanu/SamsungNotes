package com.microsoft.identity.common.logging;

import com.microsoft.identity.common.java.logging.IRequestContext;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class DiagnosticContext {
    public static void clear() {
        com.microsoft.identity.common.java.logging.DiagnosticContext.INSTANCE.clear();
    }

    public static IRequestContext getRequestContext() {
        return com.microsoft.identity.common.java.logging.DiagnosticContext.INSTANCE.getRequestContext();
    }

    public static void setRequestContext(IRequestContext iRequestContext) {
        com.microsoft.identity.common.java.logging.DiagnosticContext.INSTANCE.setRequestContext(iRequestContext);
    }
}
