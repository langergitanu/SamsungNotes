package com.samsung.android.sdk.pen.setting;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.setting.colorpalette.OnActionButtonListener;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenHSVColor;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0006H&J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\rH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0018\u0010\u0011\u001a\u00020\u00032\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0005H&J\u0012\u0010\u0014\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0015H&¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenPenSettingUI;", "", "setPalette", "", "paletteList", "", "", "setCurrentPalette", "paletteID", "setPaletteActionButtonListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/pen/setting/colorpalette/OnActionButtonListener;", "setPaletteActionListener", "Lcom/samsung/android/sdk/pen/setting/SpenPaletteActionListener;", "addRecentColor", "hsvColor", "", "setRecentColor", "recentList", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenHSVColor;", "setRecentColorChangedListener", "Lcom/samsung/android/sdk/pen/setting/SpenRecentColorChangedListener;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface SpenPenSettingUI {
    void addRecentColor(@NotNull float[] hsvColor);

    void setCurrentPalette(int paletteID);

    void setPalette(@Nullable List<Integer> paletteList);

    void setPaletteActionButtonListener(@Nullable OnActionButtonListener listener);

    void setPaletteActionListener(@Nullable SpenPaletteActionListener listener);

    void setRecentColor(@Nullable List<SpenHSVColor> recentList);

    void setRecentColorChangedListener(@Nullable SpenRecentColorChangedListener listener);
}
