package com.samsung.android.support.senl.addons.base;

import android.content.Context;
import com.samsung.android.support.senl.addons.base.utils.ApplicationUtils;
import com.samsung.android.support.senl.addons.base.utils.PlatformUtil;
import com.samsung.android.support.senl.addons.base.utils.PreferenceUtils;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0005¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/UtilManager;", "", "<init>", "()V", "onCreate", "", "context", "Landroid/content/Context;", "onDestroy", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class UtilManager {

    @NotNull
    public static final UtilManager INSTANCE = new UtilManager();

    private UtilManager() {
    }

    public final void onCreate(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        PostLaunchManager.INSTANCE.getInstance().executeBaseLogics();
        ApplicationUtils.initialize(context);
        PlatformUtil.initializePenLibrary();
        PreferenceUtils.initialize(context);
    }

    public final void onDestroy() {
        PreferenceUtils.close();
        ApplicationUtils.close();
    }
}
