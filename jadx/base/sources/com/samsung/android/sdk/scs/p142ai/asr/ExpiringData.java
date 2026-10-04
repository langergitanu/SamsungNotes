package com.samsung.android.sdk.scs.p142ai.asr;

import android.os.Build;
import androidx.annotation.RestrictTo;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.scsp.framework.core.identity.IdentityApiContract;
import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
class ExpiringData<V> {
    protected static final Duration DEFAULT_DURATION;
    protected static final boolean isDevelop;
    private final String TAG;
    private Function<V, Boolean> checkValidate;
    private Consumer<V> cleanupCallback;
    private final AtomicReference<V> data;
    private final Supplier<V> defaultSupplier;
    private volatile long lastTimeUpdate;
    private final String name;
    private final Duration timeout;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Builder<V> {
        private Function<V, Boolean> checker;
        private Consumer<V> cleanupCallback;
        private final Supplier<V> defaultHandler;
        private final String name;
        private Duration timeout = ExpiringData.DEFAULT_DURATION;

        public Builder(String str, Supplier<V> supplier) {
            this.name = str;
            this.defaultHandler = supplier;
        }

        public ExpiringData<V> build() {
            ExpiringData<V> expiringData = new ExpiringData<>(this.name, this.defaultHandler, this.timeout, 0);
            expiringData.setChecker(this.checker);
            expiringData.setCleanupCallback(this.cleanupCallback);
            return expiringData;
        }

        public Builder<V> setChecker(Function<V, Boolean> function) {
            this.checker = function;
            return this;
        }

        public Builder<V> setCleanupCallback(Consumer<V> consumer) {
            this.cleanupCallback = consumer;
            return this;
        }

        public Builder<V> setTimeout(Duration duration) {
            this.timeout = duration;
            return this;
        }
    }

    static {
        boolean zEquals = IdentityApiContract.Token.USER.equals(Build.TYPE);
        isDevelop = !zEquals;
        DEFAULT_DURATION = !zEquals ? Duration.ofSeconds(30L) : Duration.ofMinutes(15L);
    }

    public /* synthetic */ ExpiringData(String str, Supplier supplier, Duration duration, int i) {
        this(str, supplier, duration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getOrCompute$1(Supplier supplier, Object obj) {
        Object objOrElse;
        Consumer<V> consumer;
        long jCurrentTimeMillis = System.currentTimeMillis() - this.lastTimeUpdate;
        if ((obj != null && jCurrentTimeMillis <= this.timeout.toMillis()) || (objOrElse = Optional.ofNullable(supplier).map(new C7690f(28)).orElse(null)) == null || !this.checkValidate.apply((V) objOrElse).booleanValue()) {
            return obj;
        }
        if (obj != null && (consumer = this.cleanupCallback) != null) {
            try {
                consumer.accept(obj);
            } catch (Exception e) {
                Log.m6491w(this.TAG, this.name + " cleanup callback error", e);
            }
        }
        this.lastTimeUpdate = System.currentTimeMillis();
        String str = this.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append(" has updated with ");
        sb.append(Duration.ofMillis(jCurrentTimeMillis));
        sb.append(SQLKeyword.COMMA);
        sb.append(obj == null ? "NEW" : "EXPIRED");
        Log.m6489i(str, sb.toString());
        return objOrElse;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$getOrCompute$2(Object obj) {
        Log.m6490w(this.TAG, this.name + " return current value : " + Duration.ofMillis(System.currentTimeMillis() - this.lastTimeUpdate));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getOrCompute$3() {
        Log.m6490w(this.TAG, this.name + " return default value : " + Duration.ofMillis(System.currentTimeMillis() - this.lastTimeUpdate));
        return this.defaultSupplier.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$new$0(Object obj) {
        return Boolean.TRUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ExpiringData<V> setChecker(Function<V, Boolean> function) {
        if (function != null) {
            this.checkValidate = function;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ExpiringData<V> setCleanupCallback(Consumer<V> consumer) {
        if (consumer != null) {
            this.cleanupCallback = consumer;
        }
        return this;
    }

    public V getOrCompute(final Supplier<V> supplier) {
        return (V) Optional.ofNullable(this.data.updateAndGet(new UnaryOperator() { // from class: com.samsung.android.sdk.scs.ai.asr.d
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f5134a.lambda$getOrCompute$1(supplier, obj);
            }
        })).filter(new C7689e(this, 0)).orElseGet(new C7697m(this, 5));
    }

    private ExpiringData(String str, Supplier<V> supplier, Duration duration) {
        this.TAG = "ExpiringData@" + hashCode();
        this.data = new AtomicReference<>(null);
        this.checkValidate = new C7690f(0);
        this.cleanupCallback = null;
        this.lastTimeUpdate = System.currentTimeMillis();
        this.name = str;
        this.defaultSupplier = supplier;
        this.timeout = duration;
    }
}
