package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.colorpalette;

import android.content.Context;
import com.samsung.android.sdk.pen.setting.color.SpenColorPaletteData;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\u000e2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0012\u001a\u00020\u0013J\"\u0010\u0014\u001a\u0004\u0018\u00010\f2\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/colorpalette/PaletteColorHelper;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mColorTables", "", "Lcom/samsung/android/sdk/pen/setting/color/SpenColorPaletteData;", "mCustomColorTables", "", "mDefaultString", "", "close", "", "setCustomPaletteData", "paletteData", "getColorString", "hsvColor", "", "findColorString", "colorTable", "color", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nPaletteColorHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PaletteColorHelper.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/colorpalette/PaletteColorHelper\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,60:1\n1#2:61\n*E\n"})
public final class PaletteColorHelper {

    @NotNull
    private List<SpenColorPaletteData> mColorTables;

    @Nullable
    private List<SpenColorPaletteData> mCustomColorTables;

    @NotNull
    private String mDefaultString;

    public PaletteColorHelper(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mColorTables = PaletteUtil.INSTANCE.getDefinedPaletteData(context);
        String string = context.getString(C9086R.string.pen_palette_color_custom);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.mDefaultString = string;
    }

    private final String findColorString(List<SpenColorPaletteData> colorTable, int color) {
        if (colorTable == null) {
            return null;
        }
        for (SpenColorPaletteData spenColorPaletteData : colorTable) {
            int length = spenColorPaletteData.values.length;
            for (int i = 0; i < length; i++) {
                if (spenColorPaletteData.values[i] == color) {
                    return spenColorPaletteData.names[i];
                }
            }
        }
        return null;
    }

    public final void close() {
        List<SpenColorPaletteData> list = this.mCustomColorTables;
        if (list != null) {
            list.clear();
        }
        this.mCustomColorTables = null;
    }

    @Nullable
    public final String getColorString(@NotNull float[] hsvColor) {
        String strFindColorString;
        Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
        int iHSVToColor = SpenSettingUtil.HSVToColor(hsvColor);
        List<SpenColorPaletteData> list = this.mCustomColorTables;
        if (list != null && (strFindColorString = findColorString(list, iHSVToColor)) != null) {
            return strFindColorString;
        }
        String strFindColorString2 = findColorString(this.mColorTables, iHSVToColor);
        return strFindColorString2 == null ? this.mDefaultString : strFindColorString2;
    }

    public final void setCustomPaletteData(@Nullable List<SpenColorPaletteData> paletteData) {
        if (paletteData == null) {
            return;
        }
        if (this.mCustomColorTables == null) {
            this.mCustomColorTables = new ArrayList();
        }
        List<SpenColorPaletteData> list = this.mCustomColorTables;
        if (list != null) {
            list.clear();
        }
        List<SpenColorPaletteData> list2 = this.mCustomColorTables;
        if (list2 != null) {
            list2.addAll(paletteData);
        }
    }
}
