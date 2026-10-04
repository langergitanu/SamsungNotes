package com.samsung.android.support.senl.p145cm.base.framework.p146os;

import android.content.Context;
import com.samsung.android.support.senl.p145cm.base.framework.sem.p147os.AbsDVFSHelperCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.sem.p147os.DVFSHelperCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000bJ\u0018\u0010\u000f\u001a\u00020\u00102\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0011\u001a\u00020\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/os/DVFSHelperCompat;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mImpl", "Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsDVFSHelperCompatImplFactory$IDVFSHelperCompatImpl;", "acquire", "", "timeout", "", "release", "doBoost", "millisecond", "initScenarioType", "", "ScenarioType", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DVFSHelperCompat {
    public static final int HINT_TYPE_SPENSDK_FLING = 1500;

    @NotNull
    private static final String TAG = "DVFSHelperCompat";

    @NotNull
    private final AbsDVFSHelperCompatImplFactory.IDVFSHelperCompatImpl mImpl;

    public DVFSHelperCompat(@Nullable Context context) {
        this.mImpl = new DVFSHelperCompatImplFactory().create(DeviceInfo.getDeviceType(), context);
    }

    public final boolean acquire(int timeout) {
        return this.mImpl.acquire(timeout);
    }

    public final boolean doBoost(int millisecond) {
        return this.mImpl.doBoost(millisecond);
    }

    public final void initScenarioType(@Nullable Context context, int ScenarioType) {
        this.mImpl.initScenarioType(context, ScenarioType);
    }

    public final boolean release() {
        return this.mImpl.release();
    }

    public final boolean acquire() {
        return this.mImpl.acquire();
    }
}
