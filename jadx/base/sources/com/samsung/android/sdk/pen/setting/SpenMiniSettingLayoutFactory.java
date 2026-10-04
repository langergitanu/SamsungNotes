package com.samsung.android.sdk.pen.setting;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenMiniSettingLayoutFactory;", "", "<init>", "()V", "createPopupLayoutHelper", "Lcom/samsung/android/sdk/pen/setting/SpenMiniPopupLayoutInterface;", "orientation", "", "createSettingLayoutHelper", "Lcom/samsung/android/sdk/pen/setting/SpenMiniPenSettingLayoutInterface;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenMiniSettingLayoutFactory {

    @NotNull
    public static final SpenMiniSettingLayoutFactory INSTANCE = new SpenMiniSettingLayoutFactory();

    private SpenMiniSettingLayoutFactory() {
    }

    @JvmStatic
    @NotNull
    public static final SpenMiniPopupLayoutInterface createPopupLayoutHelper(int orientation) {
        return orientation == 0 ? new SpenMiniPopupHorizontalHelper(0, 1, null) : new SpenMiniPopupVerticalHelper(0, 1, null);
    }

    @JvmStatic
    @NotNull
    public static final SpenMiniPenSettingLayoutInterface createSettingLayoutHelper(int orientation) {
        return orientation == 0 ? new SpenMiniPenSettingHorizontalHelper() : new SpenMiniPenSettingVerticalHelper();
    }
}
