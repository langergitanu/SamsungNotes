package com.sec.android.diagmonagent.log.provider.exception;

import androidx.compose.runtime.AbstractC1974b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SimpleExceptionParser implements ExceptionParser {
    private static final String NEWLINE = "\u0007";

    @Override // com.sec.android.diagmonagent.log.provider.exception.ExceptionParser
    public String getDescription(String str, Throwable th) {
        StringBuilder sbM1324q = AbstractC1974b.m1324q("");
        if (th != null) {
            sbM1324q.append(th.getClass().getName());
            sbM1324q.append(":");
            sbM1324q.append(th.getLocalizedMessage());
            sbM1324q.append(NEWLINE);
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                sbM1324q.append(stackTraceElement.toString());
                sbM1324q.append(NEWLINE);
                if (sbM1324q.length() > 700) {
                    break;
                }
            }
        }
        return sbM1324q.toString();
    }
}
