package com.samsung.android.support.senl.p148nt.base.common.access.lock;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007H\u0007J\u0016\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007H\u0007J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0012\u0010\u0012\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\tH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/access/lock/LockAccessHandler;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "LOCKACTIVITY_CLASS", "Ljava/lang/Class;", "sLockManagerFactory", "Lcom/samsung/android/support/senl/nt/base/common/access/lock/ILockManagerFactory;", "getLockActivityClass", "setLockActivityClass", "", "executor", "createLockManager", "Lcom/samsung/android/support/senl/nt/base/common/access/lock/ILockManager;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/support/senl/nt/base/common/access/lock/ILockManagerListener;", "setLockManagerFactory", "lockManagerFactory", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class LockAccessHandler {

    @NotNull
    public static final LockAccessHandler INSTANCE = new LockAccessHandler();

    @Nullable
    private static Class<?> LOCKACTIVITY_CLASS = null;

    @NotNull
    private static final String TAG = "CategoryAccessHandler";

    @Nullable
    private static ILockManagerFactory sLockManagerFactory;

    private LockAccessHandler() {
    }

    @JvmStatic
    @Nullable
    public static final ILockManager createLockManager(@NotNull ILockManagerListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ILockManagerFactory iLockManagerFactory = sLockManagerFactory;
        if (iLockManagerFactory == null || iLockManagerFactory == null) {
            return null;
        }
        return iLockManagerFactory.createLockManager(listener);
    }

    @JvmStatic
    @Nullable
    public static final Class<?> getLockActivityClass() {
        return LOCKACTIVITY_CLASS;
    }

    @JvmStatic
    public static final void setLockActivityClass(@Nullable Class<?> executor) {
        if (LOCKACTIVITY_CLASS == null) {
            LOCKACTIVITY_CLASS = executor;
        } else {
            Logger.m8698e(TAG, "setCategorypickerClass, twice access! only first trial is accepted");
        }
    }

    @JvmStatic
    public static final void setLockManagerFactory(@Nullable ILockManagerFactory lockManagerFactory) {
        sLockManagerFactory = lockManagerFactory;
    }
}
