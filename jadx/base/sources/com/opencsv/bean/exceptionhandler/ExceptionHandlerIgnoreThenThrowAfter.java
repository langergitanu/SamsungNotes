package com.opencsv.bean.exceptionhandler;

import com.opencsv.exceptions.CsvException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final class ExceptionHandlerIgnoreThenThrowAfter implements CsvExceptionHandler {
    private final AtomicInteger count = new AtomicInteger();
    private final int maxExceptions;

    public ExceptionHandlerIgnoreThenThrowAfter(int i) {
        this.maxExceptions = i;
    }

    @Override // com.opencsv.bean.exceptionhandler.CsvExceptionHandler
    public CsvException handleException(CsvException csvException) throws CsvException {
        if (this.count.incrementAndGet() <= this.maxExceptions) {
            return null;
        }
        throw csvException;
    }
}
