package com.opencsv.bean.concurrent;

import com.google.android.material.color.utilities.C4662f;
import com.opencsv.ICSVParser;
import com.opencsv.bean.util.OrderedObject;
import com.opencsv.exceptions.CsvException;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import org.apache.commons.collections4.ListValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ObjectUtils;
import p074R1.C0233e;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
class IntolerantThreadPoolExecutor<T> extends ThreadPoolExecutor implements Spliterator<T>, AutoCloseable {
    protected AccumulateCsvResults<T> accumulateThread;
    protected final Locale errorLocale;
    protected final SortedSet<Long> expectedRecords;
    private final boolean orderedResults;
    protected final BlockingQueue<OrderedObject<T>> resultQueue;
    private ConcurrentNavigableMap<Long, T> resultantBeansMap;
    private Throwable terminalException;
    private ListValuedMap<Long, CsvException> thrownExceptionsMap;
    protected final BlockingQueue<OrderedObject<CsvException>> thrownExceptionsQueue;

    public IntolerantThreadPoolExecutor(boolean z, Locale locale) {
        super(Runtime.getRuntime().availableProcessors(), Runtime.getRuntime().availableProcessors(), Long.MAX_VALUE, TimeUnit.NANOSECONDS, new LinkedBlockingQueue());
        this.resultQueue = new LinkedBlockingQueue();
        this.thrownExceptionsQueue = new LinkedBlockingQueue();
        this.resultantBeansMap = null;
        this.thrownExceptionsMap = null;
        this.accumulateThread = null;
        this.expectedRecords = new ConcurrentSkipListSet();
        this.orderedResults = z;
        this.errorLocale = (Locale) ObjectUtils.defaultIfNull(locale, Locale.getDefault());
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean areMoreResultsAvailable() {
        checkExceptions();
        boolean z = false;
        while (!z && !isConversionComplete()) {
            if (this.accumulateThread == null) {
                if (this.resultQueue.isEmpty()) {
                    Thread.yield();
                } else {
                    z = true;
                }
            } else if (this.resultantBeansMap.isEmpty()) {
                Thread.yield();
            }
            checkExceptions();
        }
        return this.accumulateThread == null ? !this.resultQueue.isEmpty() : !this.resultantBeansMap.isEmpty();
    }

    private boolean isConversionComplete() {
        if (!isTerminated()) {
            return false;
        }
        AccumulateCsvResults<T> accumulateCsvResults = this.accumulateThread;
        return accumulateCsvResults == null || !accumulateCsvResults.isAlive();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getCapturedExceptions$0(List list, Long l) {
        list.addAll(this.thrownExceptionsMap.get(l));
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        if (th != null) {
            if (th.getCause() != null) {
                this.terminalException = th.getCause();
            } else {
                this.terminalException = th;
            }
            shutdownNow();
        }
    }

    public int characteristics() {
        if (this.accumulateThread != null) {
            return 4368;
        }
        return ComposerConstants.RESULT_LOCK_CANCEL;
    }

    public void checkExceptions() {
        Throwable th = this.terminalException;
        if (th != null) {
            if (!(th instanceof CsvException)) {
                throw new RuntimeException(this.terminalException);
            }
            CsvException csvException = (CsvException) th;
            throw new RuntimeException(String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("parsing.error.linenumber"), Long.valueOf(csvException.getLineNumber()), String.join(",", ArrayUtils.nullToEmpty(csvException.getLine()))), csvException);
        }
    }

    @Override // java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        boolean zIsTerminated;
        if (this == ForkJoinPool.commonPool() || (zIsTerminated = isTerminated())) {
            return;
        }
        shutdown();
        boolean z = false;
        while (!zIsTerminated) {
            try {
                zIsTerminated = awaitTermination(1L, TimeUnit.DAYS);
            } catch (InterruptedException unused) {
                if (!z) {
                    shutdownNow();
                    z = true;
                }
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    public void complete() throws InterruptedException {
        shutdown();
        awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        AccumulateCsvResults<T> accumulateCsvResults = this.accumulateThread;
        if (accumulateCsvResults != null) {
            accumulateCsvResults.setMustStop(true);
            this.accumulateThread.join();
        }
        if (this.terminalException != null) {
            throw new RejectedExecutionException();
        }
    }

    public long estimateSize() {
        return this.accumulateThread == null ? this.resultQueue.size() : this.resultantBeansMap.size();
    }

    public List<CsvException> getCapturedExceptions() {
        if (this.thrownExceptionsMap == null) {
            return (List) this.thrownExceptionsQueue.stream().filter(new C0233e(4)).map(new C4662f(12)).collect(Collectors.toList());
        }
        final LinkedList linkedList = new LinkedList();
        synchronized (this.thrownExceptionsMap) {
            this.thrownExceptionsMap.keySet().stream().sorted().forEach(new Consumer() { // from class: com.opencsv.bean.concurrent.b
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f3679a.lambda$getCapturedExceptions$0(linkedList, (Long) obj);
                }
            });
        }
        return linkedList;
    }

    public Throwable getTerminalException() {
        return this.terminalException;
    }

    public void prepare() {
        prestartAllCoreThreads();
        if (this.orderedResults) {
            this.resultantBeansMap = new ConcurrentSkipListMap();
            this.thrownExceptionsMap = new ArrayListValuedHashMap();
            AccumulateCsvResults<T> accumulateCsvResults = new AccumulateCsvResults<>(this.resultQueue, this.thrownExceptionsQueue, this.expectedRecords, this.resultantBeansMap, this.thrownExceptionsMap);
            this.accumulateThread = accumulateCsvResults;
            accumulateCsvResults.start();
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        AccumulateCsvResults<T> accumulateCsvResults = this.accumulateThread;
        if (accumulateCsvResults != null) {
            accumulateCsvResults.setMustStop(true);
            try {
                this.accumulateThread.join();
            } catch (InterruptedException unused) {
            }
        }
        return super.shutdownNow();
    }

    public boolean tryAdvance(Consumer<? super T> consumer) {
        T value = null;
        if (areMoreResultsAvailable()) {
            if (this.accumulateThread == null) {
                OrderedObject<T> orderedObjectPoll = this.resultQueue.poll();
                if (orderedObjectPoll != null) {
                    value = orderedObjectPoll.getElement();
                }
            } else {
                Map.Entry<Long, T> entryPollFirstEntry = this.resultantBeansMap.pollFirstEntry();
                if (entryPollFirstEntry != null) {
                    value = entryPollFirstEntry.getValue();
                }
            }
            if (value != null) {
                consumer.accept(value);
            }
        }
        return value != null;
    }

    public Spliterator<T> trySplit() {
        ArrayList arrayList;
        if (!areMoreResultsAvailable()) {
            return null;
        }
        if (isConversionComplete()) {
            return this.accumulateThread == null ? this.resultQueue.stream().map(new C4662f(13)).spliterator() : this.resultantBeansMap.values().spliterator();
        }
        int i = 0;
        if (this.accumulateThread == null) {
            int size = this.resultQueue.size();
            arrayList = new ArrayList(size);
            while (i < size) {
                OrderedObject<T> orderedObjectPoll = this.resultQueue.poll();
                if (orderedObjectPoll != null) {
                    arrayList.add(orderedObjectPoll.getElement());
                }
                i++;
            }
        } else {
            int size2 = this.resultantBeansMap.size();
            arrayList = new ArrayList(size2);
            while (i < size2) {
                Map.Entry<Long, T> entryPollFirstEntry = this.resultantBeansMap.pollFirstEntry();
                if (entryPollFirstEntry != null) {
                    arrayList.add(entryPollFirstEntry.getValue());
                }
                i++;
            }
        }
        return arrayList.spliterator();
    }
}
