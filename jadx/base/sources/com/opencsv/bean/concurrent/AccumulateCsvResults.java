package com.opencsv.bean.concurrent;

import com.opencsv.bean.util.OrderedObject;
import com.opencsv.exceptions.CsvException;
import java.util.SortedSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Predicate;
import org.apache.commons.collections4.ListValuedMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
class AccumulateCsvResults<T> extends Thread {
    private final SortedSet<Long> expectedRecords;
    private boolean mustStop = false;
    private final ConcurrentMap<Long, T> resultantBeanMap;
    private final BlockingQueue<OrderedObject<T>> resultantBeansQueue;
    private final ListValuedMap<Long, CsvException> thrownExceptionsMap;
    private final BlockingQueue<OrderedObject<CsvException>> thrownExceptionsQueue;

    public AccumulateCsvResults(BlockingQueue<OrderedObject<T>> blockingQueue, BlockingQueue<OrderedObject<CsvException>> blockingQueue2, SortedSet<Long> sortedSet, ConcurrentMap<Long, T> concurrentMap, ListValuedMap<Long, CsvException> listValuedMap) {
        this.resultantBeansQueue = blockingQueue;
        this.thrownExceptionsQueue = blockingQueue2;
        this.expectedRecords = sortedSet;
        this.resultantBeanMap = concurrentMap;
        this.thrownExceptionsMap = listValuedMap;
    }

    private synchronized boolean isMustStop() {
        return this.mustStop;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$run$0(OrderedObject orderedObject) {
        return this.expectedRecords.first().equals(Long.valueOf(orderedObject.getOrdinal()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$run$1(OrderedObject orderedObject) {
        return this.expectedRecords.first().equals(Long.valueOf(orderedObject.getOrdinal()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x003d, code lost:
    
        r0 = null;
     */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        OrderedObject<T> orderedObjectOrElse;
        while (true) {
            if (isMustStop() && this.resultantBeansQueue.isEmpty() && this.thrownExceptionsQueue.isEmpty()) {
                return;
            }
            if (!this.expectedRecords.isEmpty()) {
                final int i = 0;
                orderedObjectOrElse = this.resultantBeansQueue.stream().filter(new Predicate(this) { // from class: com.opencsv.bean.concurrent.a

                    /* JADX INFO: renamed from: b */
                    public final /* synthetic */ AccumulateCsvResults f3678b;

                    {
                        this.f3678b = this;
                    }

                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        switch (i) {
                            case 0:
                                return this.f3678b.lambda$run$0((OrderedObject) obj);
                            default:
                                return this.f3678b.lambda$run$1((OrderedObject) obj);
                        }
                    }
                }).findAny().orElse(null);
                while (orderedObjectOrElse != null) {
                    this.resultantBeansQueue.remove(orderedObjectOrElse);
                    SortedSet<Long> sortedSet = this.expectedRecords;
                    sortedSet.remove(sortedSet.first());
                    this.resultantBeanMap.put(Long.valueOf(orderedObjectOrElse.getOrdinal()), orderedObjectOrElse.getElement());
                    if (!this.expectedRecords.isEmpty()) {
                        final int i2 = 1;
                        orderedObjectOrElse = this.resultantBeansQueue.stream().filter(new Predicate(this) { // from class: com.opencsv.bean.concurrent.a

                            /* JADX INFO: renamed from: b */
                            public final /* synthetic */ AccumulateCsvResults f3678b;

                            {
                                this.f3678b = this;
                            }

                            @Override // java.util.function.Predicate
                            public final boolean test(Object obj) {
                                switch (i2) {
                                    case 0:
                                        return this.f3678b.lambda$run$0((OrderedObject) obj);
                                    default:
                                        return this.f3678b.lambda$run$1((OrderedObject) obj);
                                }
                            }
                        }).findAny().orElse(null);
                    }
                }
                while (!this.thrownExceptionsQueue.isEmpty()) {
                    OrderedObject<CsvException> orderedObjectPoll = this.thrownExceptionsQueue.poll();
                    if (orderedObjectPoll != null) {
                        synchronized (this.thrownExceptionsMap) {
                            this.thrownExceptionsMap.put(Long.valueOf(orderedObjectPoll.getOrdinal()), orderedObjectPoll.getElement());
                        }
                    }
                }
                Thread.yield();
            }
            orderedObjectOrElse = null;
        }
    }

    public synchronized void setMustStop(boolean z) {
        this.mustStop = z;
    }
}
