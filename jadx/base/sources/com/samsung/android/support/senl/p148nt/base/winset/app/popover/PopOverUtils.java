package com.samsung.android.support.senl.p148nt.base.winset.app.popover;

import android.content.Context;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007J\b\u0010\b\u001a\u00020\u0005H\u0007J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/popover/PopOverUtils;", "", "<init>", "()V", "isAbleToSetAnchor", "", "context", "Landroid/content/Context;", "canSupportSemSetAnchor", "isPopOverSupportLayout", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PopOverUtils {

    @NotNull
    public static final PopOverUtils INSTANCE = new PopOverUtils();

    private PopOverUtils() {
    }

    @JvmStatic
    public static final boolean canSupportSemSetAnchor() {
        return DeviceInfo.isSemDevice() && DeviceInfo.getSemPlatformVersionInt(0) >= 110500;
    }

    @JvmStatic
    public static final boolean isAbleToSetAnchor(@Nullable Context context) {
        return canSupportSemSetAnchor() && isPopOverSupportLayout(context);
    }

    @JvmStatic
    public static final boolean isPopOverSupportLayout(@Nullable Context context) {
        return context != null && context.getResources().getInteger(C8875R.integer.isPopOverSupportLayout) == 1;
    }
}
