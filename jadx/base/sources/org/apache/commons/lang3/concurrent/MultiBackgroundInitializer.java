package org.apache.commons.lang3.concurrent;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.imagetranslation.inpainting.C7126a;
import com.samsung.android.ocr.C7212a;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import p074R1.C0233e;
import p122b2.C4191n;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class MultiBackgroundInitializer extends BackgroundInitializer<MultiBackgroundInitializerResults> {
    private final Map<String, BackgroundInitializer<?>> childInitializers;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class MultiBackgroundInitializerResults {
        private final Map<String, ConcurrentException> exceptions;
        private final Map<String, BackgroundInitializer<?>> initializers;
        private final Map<String, Object> resultObjects;

        private BackgroundInitializer<?> checkName(String str) {
            BackgroundInitializer<?> backgroundInitializer = this.initializers.get(str);
            if (backgroundInitializer != null) {
                return backgroundInitializer;
            }
            throw new NoSuchElementException(AbstractC0541b.m772n("No child initializer with name ", str));
        }

        public ConcurrentException getException(String str) {
            checkName(str);
            return this.exceptions.get(str);
        }

        public BackgroundInitializer<?> getInitializer(String str) {
            return checkName(str);
        }

        public Object getResultObject(String str) {
            checkName(str);
            return this.resultObjects.get(str);
        }

        public Set<String> initializerNames() {
            return Collections.unmodifiableSet(this.initializers.keySet());
        }

        public boolean isException(String str) {
            checkName(str);
            return this.exceptions.containsKey(str);
        }

        public boolean isSuccessful() {
            return this.exceptions.isEmpty();
        }

        private MultiBackgroundInitializerResults(Map<String, BackgroundInitializer<?>> map, Map<String, Object> map2, Map<String, ConcurrentException> map3) {
            this.initializers = map;
            this.resultObjects = map2;
            this.exceptions = map3;
        }
    }

    public MultiBackgroundInitializer() {
        this.childInitializers = new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$initialize$0(ExecutorService executorService, BackgroundInitializer backgroundInitializer) {
        if (backgroundInitializer.getExternalExecutor() == null) {
            backgroundInitializer.setExternalExecutor(executorService);
        }
        backgroundInitializer.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$initialize$1(Map map, Map map2, String str, BackgroundInitializer backgroundInitializer) {
        try {
            map.put(str, backgroundInitializer.get());
        } catch (ConcurrentException e) {
            map2.put(str, e);
        }
    }

    public void addInitializer(String str, BackgroundInitializer<?> backgroundInitializer) {
        Objects.requireNonNull(str, "name");
        Objects.requireNonNull(backgroundInitializer, "backgroundInitializer");
        synchronized (this) {
            try {
                if (isStarted()) {
                    throw new IllegalStateException("addInitializer() must not be called after start()!");
                }
                this.childInitializers.put(str, backgroundInitializer);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.apache.commons.lang3.concurrent.AbstractConcurrentInitializer
    public void close() throws ConcurrentException {
        Iterator<BackgroundInitializer<?>> it = this.childInitializers.values().iterator();
        ConcurrentException concurrentException = null;
        while (it.hasNext()) {
            try {
                it.next().close();
            } catch (Exception e) {
                if (concurrentException == null) {
                    concurrentException = new ConcurrentException();
                }
                if (e instanceof ConcurrentException) {
                    concurrentException.addSuppressed(e.getCause());
                } else {
                    concurrentException.addSuppressed(e);
                }
            }
        }
        if (concurrentException != null) {
            throw concurrentException;
        }
    }

    @Override // org.apache.commons.lang3.concurrent.BackgroundInitializer
    public int getTaskCount() {
        return this.childInitializers.values().stream().mapToInt(new C7212a(6)).sum() + 1;
    }

    @Override // org.apache.commons.lang3.concurrent.BackgroundInitializer, org.apache.commons.lang3.concurrent.AbstractConcurrentInitializer
    public boolean isInitialized() {
        if (this.childInitializers.isEmpty()) {
            return false;
        }
        return this.childInitializers.values().stream().allMatch(new C0233e(17));
    }

    @Override // org.apache.commons.lang3.concurrent.AbstractConcurrentInitializer
    public MultiBackgroundInitializerResults initialize() {
        HashMap map;
        synchronized (this) {
            map = new HashMap(this.childInitializers);
        }
        map.values().forEach(new C4191n(getActiveExecutor(), 29));
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        map.forEach(new C7126a(map2, map3, 5));
        return new MultiBackgroundInitializerResults(map, map2, map3);
    }

    public MultiBackgroundInitializer(ExecutorService executorService) {
        super(executorService);
        this.childInitializers = new HashMap();
    }
}
