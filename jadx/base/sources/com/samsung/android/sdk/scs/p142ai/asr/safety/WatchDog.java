package com.samsung.android.sdk.scs.p142ai.asr.safety;

import android.os.Build;
import androidx.annotation.RestrictTo;
import com.samsung.scsp.framework.core.identity.IdentityApiContract;
import java.io.Closeable;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public interface WatchDog extends AutoCloseable {
    public static final boolean isDevelop = !IdentityApiContract.Token.USER.equals(Build.TYPE);
    public static final String DEFAULT_DETAIL_FORMAT = "YYMMdd_HHmm_ss.SSS";
    public static final SimpleDateFormat formatter = new SimpleDateFormat(DEFAULT_DETAIL_FORMAT);

    static WatchDog create() {
        return create(false);
    }

    static String createTimeStr(long j) {
        return formatter.format(new Date(j));
    }

    @Override // java.lang.AutoCloseable
    void close();

    void executeWatchDog();

    long getCreateTime();

    boolean isWatching();

    /* JADX INFO: renamed from: unWatchBlocking, reason: merged with bridge method [inline-methods] */
    void lambda$wrapBlocking$0(WatchDogCallback watchDogCallback);

    void watchBlocking(WatchDogCallback watchDogCallback, long j);

    default Closeable wrapBlocking(Runnable runnable, long j) {
        final WatchDogCallback watchDogCallbackCreate = create(runnable);
        watchBlocking(watchDogCallbackCreate, j);
        return new Closeable() { // from class: com.samsung.android.sdk.scs.ai.asr.safety.b
            @Override // java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                this.f5153a.lambda$wrapBlocking$0(watchDogCallbackCreate);
            }
        };
    }

    static WatchDog create(boolean z) {
        return WatchDogService.create(z);
    }

    static WatchDogCallback create(final Runnable runnable) {
        if (runnable == null) {
            return WatchDogCallback.doNothing;
        }
        return new WatchDogCallback() { // from class: com.samsung.android.sdk.scs.ai.asr.safety.a
            @Override // com.samsung.android.sdk.scs.p142ai.asr.safety.WatchDogCallback
            public final void onTimeoutDetected() {
                runnable.run();
            }
        };
    }
}
