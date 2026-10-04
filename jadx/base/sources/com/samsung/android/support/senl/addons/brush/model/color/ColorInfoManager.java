package com.samsung.android.support.senl.addons.brush.model.color;

import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.addons.base.utils.PreferenceUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.ColorCompat;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000  2\u00020\u0001:\u0001 B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005JI\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000f¢\u0006\u0002\u0010\u0013J\u0014\u0010\u0014\u001a\u00020\u00072\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016J\u0006\u0010\u0018\u001a\u00020\u0005J\u000e\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0005J\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00100\u0016J\u0014\u0010\u001c\u001a\u00020\u00072\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00100\u0016J\u0014\u0010\u001e\u001a\u00020\u00072\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/model/color/ColorInfoManager;", "", "<init>", "()V", "loadRecentColorSize", "", "loadRecentColor", "", "injector", "Lcom/samsung/android/support/senl/addons/brush/model/color/IColorModelInjector;", "size", "recentColor", "", "recentPosition", "recentHsvColor", "", "", "recentName", "", "(Lcom/samsung/android/support/senl/addons/brush/model/color/IColorModelInjector;I[I[I[[F[Ljava/lang/String;)V", "saveRecentColor", "colorTableSet", "", "Lcom/samsung/android/support/senl/addons/brush/model/color/MenuColorModel;", "loadViewMode", "saveViewMode", "viewMode", "loadColorPickerRecentColor", "saveColorPickerRecentColor", "hsvColors", "saveColorPalettes", XmlErrorCodes.LIST, "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ColorInfoManager {

    @NotNull
    private static final String BRUSH_V6 = "_brush_v6";

    @NotNull
    private static final String COLOR_PICKER_RECENT_COLOR = "COLOR_PICKER_RECENT_COLOR_";

    @NotNull
    private static final String COLOR_PICKER_RECENT_COLOR_NUM = "COLOR_PICKER_RECENT_COLOR_NUM";

    @NotNull
    private static final String COLOR_PICKER_VIEW_MODE = "COLOR_PICKER_VIEW_MODE";

    @NotNull
    private static final String COLOR_SETTINGS = "COLOR_SETTINGS";

    @NotNull
    private static final String RECENT_COLOR = "RECENT_COLOR_";

    @NotNull
    private static final String RECENT_COLOR_NUM = "RECENT_COLOR_NUM";

    @NotNull
    private static final String RECENT_POSITION = "RECENT_COLOR_POSITION_";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = Logger.createBrushTag("ColorInfoManager");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0010B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/model/color/ColorInfoManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "BRUSH_V6", ColorInfoManager.RECENT_COLOR_NUM, "RECENT_COLOR", "RECENT_POSITION", ColorInfoManager.COLOR_PICKER_VIEW_MODE, ColorInfoManager.COLOR_PICKER_RECENT_COLOR_NUM, "COLOR_PICKER_RECENT_COLOR", ColorInfoManager.COLOR_SETTINGS, "getInstance", "Lcom/samsung/android/support/senl/addons/brush/model/color/ColorInfoManager;", "ColorInfoManagerHolder", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\b\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/model/color/ColorInfoManager$Companion$ColorInfoManagerHolder;", "", "<init>", "()V", "INSTANCE", "Lcom/samsung/android/support/senl/addons/brush/model/color/ColorInfoManager;", "getINSTANCE", "()Lcom/samsung/android/support/senl/addons/brush/model/color/ColorInfoManager;", "INSTANCE$1", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class ColorInfoManagerHolder {

            @NotNull
            public static final ColorInfoManagerHolder INSTANCE = new ColorInfoManagerHolder();

            /* JADX INFO: renamed from: INSTANCE$1, reason: from kotlin metadata */
            @NotNull
            private static final ColorInfoManager INSTANCE = new ColorInfoManager(null);

            private ColorInfoManagerHolder() {
            }

            @NotNull
            public final ColorInfoManager getINSTANCE() {
                return INSTANCE;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ColorInfoManager getInstance() {
            return ColorInfoManagerHolder.INSTANCE.getINSTANCE();
        }

        private Companion() {
        }
    }

    public /* synthetic */ ColorInfoManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public final List<float[]> loadColorPickerRecentColor() {
        int i = PreferenceUtils.getInt(BRUSH_V6, COLOR_PICKER_RECENT_COLOR_NUM, 0);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(new float[]{PreferenceUtils.getFloat(BRUSH_V6, "COLOR_PICKER_RECENT_COLOR_H_" + i2, -1.0f), PreferenceUtils.getFloat(BRUSH_V6, "COLOR_PICKER_RECENT_COLOR_S_" + i2, -1.0f), PreferenceUtils.getFloat(BRUSH_V6, "COLOR_PICKER_RECENT_COLOR_V_" + i2, -1.0f)});
        }
        return arrayList;
    }

    public final void loadRecentColor(@NotNull IColorModelInjector injector, int size, @NotNull int[] recentColor, @NotNull int[] recentPosition, @NotNull float[][] recentHsvColor, @NotNull String[] recentName) {
        Intrinsics.checkNotNullParameter(injector, "injector");
        Intrinsics.checkNotNullParameter(recentColor, "recentColor");
        Intrinsics.checkNotNullParameter(recentPosition, "recentPosition");
        Intrinsics.checkNotNullParameter(recentHsvColor, "recentHsvColor");
        Intrinsics.checkNotNullParameter(recentName, "recentName");
        for (int i = 0; i < size; i++) {
            recentColor[i] = PreferenceUtils.getInt(BRUSH_V6, RECENT_COLOR + i, MarketingConstants.PopupConst.DEFAULT_COLOR_LINE);
            recentHsvColor[i][0] = PreferenceUtils.getFloat(BRUSH_V6, "RECENT_COLOR_H_" + i, -1.0f);
            recentHsvColor[i][1] = PreferenceUtils.getFloat(BRUSH_V6, "RECENT_COLOR_S_" + i, -1.0f);
            recentHsvColor[i][2] = PreferenceUtils.getFloat(BRUSH_V6, "RECENT_COLOR_V_" + i, -1.0f);
            float[] fArr = recentHsvColor[i];
            if (fArr[0] < 0.0f || fArr[1] < 0.0f || fArr[2] < 0.0f) {
                ColorCompat.colorToHSV(recentColor[i], fArr);
            }
            int i2 = PreferenceUtils.getInt(BRUSH_V6, RECENT_POSITION + i, 2097151);
            recentPosition[i] = i2;
            recentName[i] = injector.getColorName(recentColor[i], ((1048320 & i2) >> 8) & 4095, i2 & 255);
        }
    }

    public final int loadRecentColorSize() {
        int i = PreferenceUtils.getInt(BRUSH_V6, RECENT_COLOR_NUM, 0);
        AbstractC6670b.m4761v(i, "load Recent color: ", TAG);
        return i;
    }

    public final int loadViewMode() {
        int i = PreferenceUtils.getInt(BRUSH_V6, COLOR_PICKER_VIEW_MODE, 1);
        AbstractC6670b.m4761v(i, "load view mode: ", TAG);
        return i;
    }

    public final void saveColorPalettes(@NotNull List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append(String.valueOf(list.get(i).intValue()));
            sb.append(':');
        }
        PreferenceUtils.putString(BRUSH_V6, COLOR_SETTINGS, sb.toString());
    }

    public final void saveColorPickerRecentColor(@NotNull List<float[]> hsvColors) {
        Intrinsics.checkNotNullParameter(hsvColors, "hsvColors");
        int size = hsvColors.size();
        for (int i = 0; i < size; i++) {
            PreferenceUtils.putFloat(BRUSH_V6, AbstractC0000a.m11h(i, "COLOR_PICKER_RECENT_COLOR_H_"), hsvColors.get(i)[0]);
            PreferenceUtils.putFloat(BRUSH_V6, "COLOR_PICKER_RECENT_COLOR_S_" + i, hsvColors.get(i)[1]);
            PreferenceUtils.putFloat(BRUSH_V6, "COLOR_PICKER_RECENT_COLOR_V_" + i, hsvColors.get(i)[2]);
        }
        PreferenceUtils.putInt(BRUSH_V6, COLOR_PICKER_RECENT_COLOR_NUM, hsvColors.size());
    }

    public final void saveRecentColor(@NotNull List<MenuColorModel> colorTableSet) {
        Intrinsics.checkNotNullParameter(colorTableSet, "colorTableSet");
        int size = colorTableSet.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            if (colorTableSet.get(i2).getMIsEnabled()) {
                i++;
                PreferenceUtils.putInt(BRUSH_V6, AbstractC0000a.m11h(i2, RECENT_COLOR), colorTableSet.get(i2).getMColor());
                PreferenceUtils.putFloat(BRUSH_V6, "RECENT_COLOR_H_" + i2, colorTableSet.get(i2).getMHSV()[0]);
                PreferenceUtils.putFloat(BRUSH_V6, "RECENT_COLOR_S_" + i2, colorTableSet.get(i2).getMHSV()[1]);
                PreferenceUtils.putFloat(BRUSH_V6, "RECENT_COLOR_V_" + i2, colorTableSet.get(i2).getMHSV()[2]);
                PreferenceUtils.putInt(BRUSH_V6, RECENT_POSITION + i2, colorTableSet.get(i2).getMPosition());
            }
        }
        PreferenceUtils.putInt(BRUSH_V6, RECENT_COLOR_NUM, i);
        AbstractC6670b.m4761v(i, "save Recent Color: ", TAG);
    }

    public final void saveViewMode(int viewMode) {
        PreferenceUtils.putInt(BRUSH_V6, COLOR_PICKER_VIEW_MODE, viewMode);
        AbstractC6670b.m4761v(viewMode, "save view mode: ", TAG);
    }

    private ColorInfoManager() {
    }
}
