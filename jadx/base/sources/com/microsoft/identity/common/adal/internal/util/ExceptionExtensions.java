package com.microsoft.identity.common.adal.internal.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final class ExceptionExtensions {
    private ExceptionExtensions() {
    }

    public static String getExceptionMessage(Exception exc) {
        if (exc == null) {
            return null;
        }
        String message = exc.getMessage();
        if (message != null) {
            return message;
        }
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
