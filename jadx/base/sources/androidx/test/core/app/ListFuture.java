package androidx.test.core.app;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.test.internal.util.Checks;
import androidx.test.platform.concurrent.DirectExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
class ListFuture<V> implements ListenableFuture<List<V>> {
    private final boolean mAllMustSucceed;

    @Nullable
    List<? extends ListenableFuture<? extends V>> mFutures;

    @NonNull
    private final AtomicInteger mRemaining;

    @NonNull
    private final ListenableFuture<List<V>> mResult = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver<List<V>>() { // from class: androidx.test.core.app.ListFuture.1
        @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
        public Object attachCompleter(@NonNull CallbackToFutureAdapter.Completer<List<V>> completer) {
            Checks.checkState(ListFuture.this.mResultNotifier == null, "The result can only set once!");
            ListFuture.this.mResultNotifier = completer;
            return "ListFuture[" + this + "]";
        }
    });
    CallbackToFutureAdapter.Completer<List<V>> mResultNotifier;

    @Nullable
    List<V> mValues;

    public ListFuture(@NonNull List<? extends ListenableFuture<? extends V>> list, boolean z, @NonNull Executor executor) {
        this.mFutures = (List) Checks.checkNotNull(list);
        this.mValues = new ArrayList(list.size());
        this.mAllMustSucceed = z;
        this.mRemaining = new AtomicInteger(list.size());
        init(executor);
    }

    private void callAllGets() throws InterruptedException {
        List<? extends ListenableFuture<? extends V>> list = this.mFutures;
        if (list == null || isDone()) {
            return;
        }
        for (ListenableFuture<? extends V> listenableFuture : list) {
            while (!listenableFuture.isDone()) {
                try {
                    listenableFuture.get();
                } catch (Error e) {
                    throw e;
                } catch (InterruptedException e2) {
                    throw e2;
                } catch (Throwable unused) {
                    if (this.mAllMustSucceed) {
                        return;
                    }
                }
            }
        }
    }

    private static Executor directExecutor() {
        return DirectExecutor.INSTANCE;
    }

    @Nullable
    private static <V> V getUninterruptibly(@NonNull Future<V> future) {
        V v;
        boolean z = false;
        while (true) {
            try {
                v = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return v;
    }

    private void init(@NonNull Executor executor) {
        addListener(new Runnable() { // from class: androidx.test.core.app.ListFuture.2
            @Override // java.lang.Runnable
            public void run() {
                ListFuture listFuture = ListFuture.this;
                listFuture.mValues = null;
                listFuture.mFutures = null;
            }
        }, directExecutor());
        if (this.mFutures.isEmpty()) {
            this.mResultNotifier.set(new ArrayList(this.mValues));
            return;
        }
        for (int i = 0; i < this.mFutures.size(); i++) {
            this.mValues.add(null);
        }
        List<? extends ListenableFuture<? extends V>> list = this.mFutures;
        for (final int i2 = 0; i2 < list.size(); i2++) {
            final ListenableFuture<? extends V> listenableFuture = list.get(i2);
            listenableFuture.addListener(new Runnable() { // from class: androidx.test.core.app.ListFuture.3
                @Override // java.lang.Runnable
                public void run() {
                    ListFuture.this.setOneValue(i2, listenableFuture);
                }
            }, executor);
        }
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(@NonNull Runnable runnable, @NonNull Executor executor) {
        this.mResult.addListener(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        List<? extends ListenableFuture<? extends V>> list = this.mFutures;
        if (list != null) {
            Iterator<? extends ListenableFuture<? extends V>> it = list.iterator();
            while (it.hasNext()) {
                it.next().cancel(z);
            }
        }
        return this.mResult.cancel(z);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.mResult.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.mResult.isDone();
    }

    public void setOneValue(int i, @NonNull Future<? extends V> future) {
        CallbackToFutureAdapter.Completer<List<V>> completer;
        ArrayList arrayList;
        List<V> list = this.mValues;
        if (isDone() || list == null) {
            Checks.checkState(this.mAllMustSucceed, "Future was done before all dependencies completed");
            return;
        }
        try {
            try {
                try {
                    try {
                        try {
                            Checks.checkState(future.isDone(), "Tried to set value from future which is not done");
                            list.set(i, (V) getUninterruptibly(future));
                            int iDecrementAndGet = this.mRemaining.decrementAndGet();
                            Checks.checkState(iDecrementAndGet >= 0, "Less than 0 remaining futures");
                            if (iDecrementAndGet == 0) {
                                List<V> list2 = this.mValues;
                                if (list2 != null) {
                                    this.mResultNotifier.set(new ArrayList(list2));
                                } else {
                                    Checks.checkState(isDone());
                                }
                            }
                        } catch (ExecutionException e) {
                            if (this.mAllMustSucceed) {
                                this.mResultNotifier.setException(e.getCause());
                            }
                            int iDecrementAndGet2 = this.mRemaining.decrementAndGet();
                            Checks.checkState(iDecrementAndGet2 >= 0, "Less than 0 remaining futures");
                            if (iDecrementAndGet2 == 0) {
                                List<V> list3 = this.mValues;
                                if (list3 != null) {
                                    completer = this.mResultNotifier;
                                    arrayList = new ArrayList(list3);
                                    completer.set(arrayList);
                                    return;
                                }
                                Checks.checkState(isDone());
                            }
                        }
                    } catch (CancellationException unused) {
                        if (this.mAllMustSucceed) {
                            cancel(false);
                        }
                        int iDecrementAndGet3 = this.mRemaining.decrementAndGet();
                        Checks.checkState(iDecrementAndGet3 >= 0, "Less than 0 remaining futures");
                        if (iDecrementAndGet3 == 0) {
                            List<V> list4 = this.mValues;
                            if (list4 != null) {
                                completer = this.mResultNotifier;
                                arrayList = new ArrayList(list4);
                                completer.set(arrayList);
                                return;
                            }
                            Checks.checkState(isDone());
                        }
                    }
                } catch (Error e2) {
                    this.mResultNotifier.setException(e2);
                    int iDecrementAndGet4 = this.mRemaining.decrementAndGet();
                    Checks.checkState(iDecrementAndGet4 >= 0, "Less than 0 remaining futures");
                    if (iDecrementAndGet4 == 0) {
                        List<V> list5 = this.mValues;
                        if (list5 != null) {
                            completer = this.mResultNotifier;
                            arrayList = new ArrayList(list5);
                            completer.set(arrayList);
                            return;
                        }
                        Checks.checkState(isDone());
                    }
                }
            } catch (RuntimeException e3) {
                if (this.mAllMustSucceed) {
                    this.mResultNotifier.setException(e3);
                }
                int iDecrementAndGet5 = this.mRemaining.decrementAndGet();
                Checks.checkState(iDecrementAndGet5 >= 0, "Less than 0 remaining futures");
                if (iDecrementAndGet5 == 0) {
                    List<V> list6 = this.mValues;
                    if (list6 != null) {
                        completer = this.mResultNotifier;
                        arrayList = new ArrayList(list6);
                        completer.set(arrayList);
                        return;
                    }
                    Checks.checkState(isDone());
                }
            }
        } catch (Throwable th) {
            int iDecrementAndGet6 = this.mRemaining.decrementAndGet();
            Checks.checkState(iDecrementAndGet6 >= 0, "Less than 0 remaining futures");
            if (iDecrementAndGet6 == 0) {
                List<V> list7 = this.mValues;
                if (list7 != null) {
                    this.mResultNotifier.set(new ArrayList(list7));
                } else {
                    Checks.checkState(isDone());
                }
            }
            throw th;
        }
    }

    @Override // java.util.concurrent.Future
    @Nullable
    public List<V> get() throws InterruptedException {
        callAllGets();
        return this.mResult.get();
    }

    @Override // java.util.concurrent.Future
    public List<V> get(long j, @NonNull TimeUnit timeUnit) {
        return this.mResult.get(j, timeUnit);
    }
}
