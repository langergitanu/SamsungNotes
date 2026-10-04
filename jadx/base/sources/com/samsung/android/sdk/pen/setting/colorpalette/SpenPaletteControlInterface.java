package com.samsung.android.sdk.pen.setting.colorpalette;

import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0013\bf\u0018\u0000 /2\u00020\u0001:\u0003/01J\b\u0010\u0002\u001a\u00020\u0003H&J!\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\"\u00020\bH&¢\u0006\u0002\u0010\tJ\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u000eH&J\b\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H&J(\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0005H&J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0010H&J\b\u0010\u001a\u001a\u00020\u0003H&J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0018\u0010\u001c\u001a\u00020\u00052\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eH&J\u0010\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eH&J\u0010\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u0010H&J\u0016\u0010#\u001a\u00020\u00052\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00100\u001eH&J\b\u0010%\u001a\u00020\u0010H&J\u0010\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0010H&J\u0010\u0010(\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0010H&J\u0010\u0010)\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u0010H&J\u0010\u0010+\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u0010H&J\u0010\u0010-\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\u0010H&¨\u00062"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteControlInterface;", "", "close", "", "setPaletteView", "", "paletteViewInterfaces", "", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteViewInterface;", "([Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteViewInterface;)Z", "setColorChangeListener", "actionListener", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteControlInterface$OnColorChangeListener;", "setPaletteActionListener", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteControlInterface$OnPaletteActionListener;", "getOpacity", "", "getColor", "color", "", "setColor", "uiInfo", "opacity", "needAnimation", "setPickerColor", "setEyedropperColor", "resetColor", "addRecentColor", "setRecentColor", "recentList", "", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenHSVColor;", "getRecentColor", "getColorUIInfo", "type", "setPaletteInfo", "paletteInfo", "getPalette", "setPalette", "paletteID", "containsPalette", "getPaletteIDFromViewIdx", "viewIndex", "setRecentIndicatorSize", "size", "setColorTheme", BaseWidgetConstant.WIDGET_THEME, "Companion", "OnColorChangeListener", "OnPaletteActionListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface SpenPaletteControlInterface {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int OPACITY_100 = 255;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteControlInterface$Companion;", "", "<init>", "()V", "OPACITY_100", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int OPACITY_100 = 255;

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H&¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteControlInterface$OnColorChangeListener;", "", "onColorChanged", "", "info", "", "hsvColor", "", "opacity", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnColorChangeListener {
        void onColorChanged(int info, @NotNull float[] hsvColor, int opacity);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0005H&J \u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteControlInterface$OnPaletteActionListener;", "", "onPaletteSwipe", "", "position", "", "direction", "onButtonClick", "which", "onColorSelected", "pageIndex", "colorIndex", "isSelected", "", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnPaletteActionListener {
        public static final int BUTTON_TYPE_EYEDROPPER = 2;
        public static final int BUTTON_TYPE_PICKER = 1;
        public static final int BUTTON_TYPE_SETTING = 3;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteControlInterface$OnPaletteActionListener$Companion;", "", "<init>", "()V", "BUTTON_TYPE_PICKER", "", "BUTTON_TYPE_EYEDROPPER", "BUTTON_TYPE_SETTING", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int BUTTON_TYPE_EYEDROPPER = 2;
            public static final int BUTTON_TYPE_PICKER = 1;
            public static final int BUTTON_TYPE_SETTING = 3;

            private Companion() {
            }
        }

        void onButtonClick(int which);

        void onColorSelected(int pageIndex, int colorIndex, boolean isSelected);

        void onPaletteSwipe(int position, int direction);
    }

    boolean addRecentColor(@NotNull float[] color);

    void close();

    boolean containsPalette(int paletteID);

    void getColor(@NotNull float[] color);

    int getColorUIInfo(int type);

    int getOpacity();

    int getPalette();

    int getPaletteIDFromViewIdx(int viewIndex);

    @Nullable
    List<SpenHSVColor> getRecentColor();

    void resetColor();

    void setColor(int uiInfo, @NotNull float[] color, int opacity, boolean needAnimation);

    void setColorChangeListener(@Nullable OnColorChangeListener actionListener);

    void setColorTheme(int theme);

    void setEyedropperColor(int color);

    boolean setPalette(int paletteID);

    void setPaletteActionListener(@Nullable OnPaletteActionListener actionListener);

    boolean setPaletteInfo(@NotNull List<Integer> paletteInfo);

    boolean setPaletteView(@NotNull SpenPaletteViewInterface... paletteViewInterfaces);

    void setPickerColor(@NotNull float[] color);

    boolean setRecentColor(@Nullable List<SpenHSVColor> recentList);

    void setRecentIndicatorSize(int size);
}
