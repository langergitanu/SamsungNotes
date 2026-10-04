package com.samsung.android.sdk.scs.p142ai.asr_6_0;

import android.os.Build;
import android.util.Log;
import androidx.annotation.RestrictTo;
import com.samsung.android.sdk.scs.p142ai.asr.C7690f;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.scsp.framework.core.identity.IdentityApiContract;
import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
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
    private final AtomicReference<V> data;
    private final Supplier<V> defaultSupplier;
    private long lastTimeUpdate;
    private final String name;
    private final Duration timeout;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Builder<V> {
        private Function<V, Boolean> checker;
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
            return expiringData;
        }

        public Builder setChecker(Function<V, Boolean> function) {
            this.checker = function;
            return this;
        }

        public Builder setTimeout(Duration duration) {
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
        long jCurrentTimeMillis = System.currentTimeMillis() - this.lastTimeUpdate;
        if ((obj != null && jCurrentTimeMillis <= this.timeout.toMillis()) || (objOrElse = Optional.ofNullable(supplier).map(new C7690f(28)).orElse(null)) == null || !this.checkValidate.apply((V) objOrElse).booleanValue()) {
            return obj;
        }
        this.lastTimeUpdate = System.currentTimeMillis();
        String str = this.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append(" has updated with ");
        sb.append(Duration.ofMillis(jCurrentTimeMillis));
        sb.append(SQLKeyword.COMMA);
        AbstractC11014a.m12338w(sb, obj == null ? "NEW" : "EXPIRED", str);
        return objOrElse;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$getOrCompute$2(Object obj) {
        Log.w(this.TAG, this.name + " return current value : " + Duration.ofMillis(System.currentTimeMillis() - this.lastTimeUpdate));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getOrCompute$3() {
        Log.w(this.TAG, this.name + " return default value : " + Duration.ofMillis(System.currentTimeMillis() - this.lastTimeUpdate));
        return this.defaultSupplier.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$new$0(Object obj) {
        return Boolean.TRUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ExpiringData setChecker(Function<V, Boolean> function) {
        if (function != null) {
            this.checkValidate = function;
        }
        return this;
    }

    public V getOrCompute(final Supplier<V> supplier) {
        return (V) Optional.ofNullable(this.data.updateAndGet(new UnaryOperator() { // from class: com.samsung.android.sdk.scs.ai.asr_6_0.d
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f5168a.lambda$getOrCompute$1(supplier, obj);
            }
        })).filter(new C7717e(this, 0)).orElseGet(new C7720h(this, 5));
    }

    private ExpiringData(String str, Supplier<V> supplier, Duration duration) {
        this.TAG = "ExpiringData@" + hashCode();
        this.data = new AtomicReference<>(null);
        this.checkValidate = new C7715c(0);
        this.lastTimeUpdate = System.currentTimeMillis();
        this.name = str;
        this.defaultSupplier = supplier;
        this.timeout = duration;
    }
}
