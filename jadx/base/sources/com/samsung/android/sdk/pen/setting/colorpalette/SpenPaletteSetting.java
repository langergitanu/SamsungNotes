package com.samsung.android.sdk.pen.setting.colorpalette;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\tH&J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u000bH&J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018H&J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0011H&J\b\u0010\u001d\u001a\u00020\u0003H&J\u0018\u0010\u001e\u001a\u00020\u001b2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018H&J\u0016\u0010 \u001a\u00020\u001b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\r0\u0018H&J\u0010\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\rH&R\u0012\u0010\u0012\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\"\u001a\u00020\rX¦\u000e¢\u0006\f\u001a\u0004\b#\u0010\u0014\"\u0004\b$\u0010%¨\u0006("}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteSetting;", "", "setOnActionButtonListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/pen/setting/colorpalette/OnActionButtonListener;", "setOnColorChangeListener", "Lcom/samsung/android/sdk/pen/setting/colorpalette/OnColorChangeListener;", "setOnPaletteSwipeListener", "Lcom/samsung/android/sdk/pen/setting/colorpalette/OnPaletteSwipeListener;", "setOnColorButtonListener", "Lcom/samsung/android/sdk/pen/setting/colorpalette/OnColorButtonListener;", "getUiInfo", "", "type", "getColor", "color", "", "opacity", "getOpacity", "()I", "setColor", "uiInfo", "getRecentColor", "", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenHSVColor;", "addRecentColor", "", "hsvColor", "resetColor", "setRecentColor", "recentColors", "setPaletteList", "palettes", "palette", "getPalette", "setPalette", "(I)V", "setColorTheme", BaseWidgetConstant.WIDGET_THEME, "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface SpenPaletteSetting {
    boolean addRecentColor(@NotNull float[] hsvColor);

    void getColor(@NotNull float[] color);

    int getOpacity();

    int getPalette();

    @Nullable
    List<SpenHSVColor> getRecentColor();

    int getUiInfo(int type);

    void resetColor();

    void setColor(int uiInfo, @NotNull float[] color);

    void setColorTheme(int theme);

    void setOnActionButtonListener(@Nullable OnActionButtonListener listener);

    void setOnColorButtonListener(@Nullable OnColorButtonListener listener);

    void setOnColorChangeListener(@Nullable OnColorChangeListener listener);

    void setOnPaletteSwipeListener(@Nullable OnPaletteSwipeListener listener);

    void setPalette(int i);

    boolean setPaletteList(@NotNull List<Integer> palettes);

    boolean setRecentColor(@Nullable List<SpenHSVColor> recentColors);
}
