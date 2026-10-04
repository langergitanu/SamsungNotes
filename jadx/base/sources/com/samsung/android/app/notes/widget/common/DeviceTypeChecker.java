package com.samsung.android.app.notes.widget.common;

import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.app.notes.widget.common.log.WidgetLogger;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\b¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/common/DeviceTypeChecker;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "isFoldDeviceType", "", "()Z", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DeviceTypeChecker {
    public static final int $stable = 0;

    @NotNull
    public static final DeviceTypeChecker INSTANCE = new DeviceTypeChecker();

    @NotNull
    private static final String TAG = "DeviceTypeChecker";

    private DeviceTypeChecker() {
    }

    public final boolean isFoldDeviceType() {
        boolean zIsFoldableModel = DeviceUtils.isFoldableModel();
        WidgetLogger.m5155i(TAG, "isFoldDeviceType# " + zIsFoldableModel);
        return zIsFoldableModel;
    }
}
