package com.sec.android.diagmonagent.log.provider.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class FullStackExceptionParser implements ExceptionParser {
    @Override // com.sec.android.diagmonagent.log.provider.exception.ExceptionParser
    public String getDescription(String str, Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        String string = stringWriter.toString();
        printWriter.close();
        return "thread(" + str + ") : " + string;
    }
}
