package com.samsung.android.sdk.pen.setting;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u000bH&J\b\u0010\r\u001a\u00020\u000bH&J\b\u0010\u000e\u001a\u00020\u000bH&J\b\u0010\u000f\u001a\u00020\u000bH&J\b\u0010\u0010\u001a\u00020\u000bH&J\b\u0010\u0011\u001a\u00020\u000bH&J\b\u0010\u0012\u001a\u00020\u000bH&J\b\u0010\u0013\u001a\u00020\u000bH&¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenMiniPenSettingLayoutInterface;", "", "createContentParam", "Landroid/widget/FrameLayout$LayoutParams;", "createPenParam", "Landroid/view/ViewGroup$LayoutParams;", "context", "Landroid/content/Context;", "createColorParam", "createSizeParam", "getPenId", "", "getPenPopupId", "getColorId", "getColorGroupId", "getColorPopupId", "getSizeId", "getSizePopupId", "getPatternId", "getPatternPopupId", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface SpenMiniPenSettingLayoutInterface {
    @NotNull
    ViewGroup.LayoutParams createColorParam(@NotNull Context context);

    @NotNull
    FrameLayout.LayoutParams createContentParam();

    @NotNull
    ViewGroup.LayoutParams createPenParam(@NotNull Context context);

    @NotNull
    ViewGroup.LayoutParams createSizeParam(@NotNull Context context);

    int getColorGroupId();

    int getColorId();

    int getColorPopupId();

    int getPatternId();

    int getPatternPopupId();

    int getPenId();

    int getPenPopupId();

    int getSizeId();

    int getSizePopupId();
}
