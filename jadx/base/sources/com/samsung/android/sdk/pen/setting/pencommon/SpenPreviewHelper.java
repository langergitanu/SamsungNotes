package com.samsung.android.sdk.pen.setting.pencommon;

import android.content.Context;
import com.samsung.android.sdk.pen.pen.SpenPen;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/pencommon/SpenPreviewHelper;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mPenManager", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenPensManager;", "close", "", "getPreviewObject", "Lcom/samsung/android/sdk/pen/pen/SpenPen;", "penName", "", "getMaxSettingValue", "", "getMinSettingValue", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenPreviewHelper {

    @NotNull
    private SpenPensManager mPenManager;

    public SpenPreviewHelper(@Nullable Context context) {
        this.mPenManager = new SpenPensManager(context);
    }

    public final void close() {
        this.mPenManager.close();
    }

    public final float getMaxSettingValue(@NotNull String penName) {
        Intrinsics.checkNotNullParameter(penName, "penName");
        SpenPen previewObject = getPreviewObject(penName);
        if (previewObject != null) {
            return previewObject.getMaxSettingValue();
        }
        return 0.0f;
    }

    public final float getMinSettingValue(@NotNull String penName) {
        Intrinsics.checkNotNullParameter(penName, "penName");
        SpenPen previewObject = getPreviewObject(penName);
        if (previewObject != null) {
            return previewObject.getMinSettingValue();
        }
        return 0.0f;
    }

    @Nullable
    public final SpenPen getPreviewObject(@NotNull String penName) {
        Intrinsics.checkNotNullParameter(penName, "penName");
        int penIndexByPenName = this.mPenManager.getPenIndexByPenName(penName);
        if (penIndexByPenName <= -1) {
            return null;
        }
        this.mPenManager.loadPenObject(penName, true);
        return this.mPenManager.getPenInfoList().get(penIndexByPenName).getMSpenPreviewObject();
    }
}
