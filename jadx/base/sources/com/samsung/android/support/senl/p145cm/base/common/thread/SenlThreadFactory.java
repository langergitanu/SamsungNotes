package com.samsung.android.support.senl.p145cm.base.common.thread;

import android.text.TextUtils;
import androidx.glance.AbstractC2821a;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/common/thread/SenlThreadFactory;", "Ljava/util/concurrent/ThreadFactory;", "name", "", "<init>", "(Ljava/lang/String;)V", "mName", "mThreadNumber", "Ljava/util/concurrent/atomic/AtomicInteger;", "newThread", "Ljava/lang/Thread;", "runnable", "Ljava/lang/Runnable;", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SenlThreadFactory implements ThreadFactory {

    @NotNull
    private static final String TAG = "SenlThreadFactory";

    @NotNull
    private final String mName;

    @NotNull
    private final AtomicInteger mThreadNumber;

    public SenlThreadFactory(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (TextUtils.isEmpty(name)) {
            name = Thread.currentThread().getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        }
        this.mName = name;
        this.mThreadNumber = new AtomicInteger(1);
    }

    @Override // java.util.concurrent.ThreadFactory
    @NotNull
    public Thread newThread(@NotNull Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        String strM2218i = AbstractC2821a.m2218i(this.mThreadNumber.getAndIncrement(), this.mName, CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
        LoggerBase.INSTANCE.m7132d(TAG, "newThread# mName " + strM2218i);
        return new Thread(runnable, strM2218i);
    }
}
