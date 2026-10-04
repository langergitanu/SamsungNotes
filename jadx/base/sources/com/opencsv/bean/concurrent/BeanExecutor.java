package com.opencsv.bean.concurrent;

import com.opencsv.bean.MappingStrategy;
import com.opencsv.bean.exceptionhandler.CsvExceptionHandler;
import java.util.List;
import java.util.Locale;
import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class BeanExecutor<T> extends IntolerantThreadPoolExecutor<String[]> {
    public BeanExecutor(boolean z, Locale locale) {
        super(z, locale);
    }

    @Override // com.opencsv.bean.concurrent.IntolerantThreadPoolExecutor, java.util.Spliterator
    public /* bridge */ /* synthetic */ int characteristics() {
        return super.characteristics();
    }

    @Override // com.opencsv.bean.concurrent.IntolerantThreadPoolExecutor
    public /* bridge */ /* synthetic */ void complete() {
        super.complete();
    }

    @Override // com.opencsv.bean.concurrent.IntolerantThreadPoolExecutor, java.util.Spliterator
    public /* bridge */ /* synthetic */ long estimateSize() {
        return super.estimateSize();
    }

    @Override // com.opencsv.bean.concurrent.IntolerantThreadPoolExecutor
    public /* bridge */ /* synthetic */ List getCapturedExceptions() {
        return super.getCapturedExceptions();
    }

    @Override // com.opencsv.bean.concurrent.IntolerantThreadPoolExecutor
    public /* bridge */ /* synthetic */ Throwable getTerminalException() {
        return super.getTerminalException();
    }

    @Override // com.opencsv.bean.concurrent.IntolerantThreadPoolExecutor
    public /* bridge */ /* synthetic */ void prepare() {
        super.prepare();
    }

    @Override // com.opencsv.bean.concurrent.IntolerantThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public /* bridge */ /* synthetic */ List shutdownNow() {
        return super.shutdownNow();
    }

    public void submitBean(long j, MappingStrategy<T> mappingStrategy, T t, CsvExceptionHandler csvExceptionHandler) {
        if (this.accumulateThread != null) {
            this.expectedRecords.add(Long.valueOf(j));
        }
        try {
            execute(new ProcessCsvBean(j, mappingStrategy, t, this.resultQueue, this.thrownExceptionsQueue, this.expectedRecords, csvExceptionHandler));
        } catch (Exception e) {
            if (this.accumulateThread == null) {
                throw e;
            }
            this.expectedRecords.remove(Long.valueOf(j));
            this.accumulateThread.setMustStop(true);
            throw e;
        }
    }

    @Override // com.opencsv.bean.concurrent.IntolerantThreadPoolExecutor, java.util.Spliterator
    public /* bridge */ /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return super.tryAdvance(consumer);
    }

    @Override // com.opencsv.bean.concurrent.IntolerantThreadPoolExecutor, java.util.Spliterator
    public /* bridge */ /* synthetic */ Spliterator trySplit() {
        return super.trySplit();
    }
}
