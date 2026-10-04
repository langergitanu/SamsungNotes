package com.samsung.android.support.senl.addons.brush.view.injector;

import android.content.Context;
import com.samsung.android.sdk.pen.setting.color.SpenColorPaletteData;
import com.samsung.android.sdk.pen.setting.color.SpenColorPaletteUtil;
import com.samsung.android.support.senl.addons.C7944R;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.addons.base.utils.PreferenceUtils;
import com.samsung.android.support.senl.addons.brush.model.color.IColorModelInjector;
import com.samsung.android.support.senl.addons.brush.model.color.IColorPaletteModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0002J\u001a\u0010\u0010\u001a\u00020\u000e2\u0010\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u0012H\u0016J\u0010\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0012H\u0016J\"\u0010\u0014\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/view/injector/ColorModelInjector;", "Lcom/samsung/android/support/senl/addons/brush/model/color/IColorModelInjector;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mCustomColor", "", "mColorSettingUtil", "Lcom/samsung/android/sdk/pen/setting/color/SpenColorPaletteUtil;", "mDefaultColorPalletList", "", "Lcom/samsung/android/sdk/pen/setting/color/SpenColorPaletteData;", "loadDefault", "", "paletteList", "getColorTables", "tables", "", "getPaletteDatum", "getColorName", "color", "", "page", "index", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nColorModelInjector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ColorModelInjector.kt\ncom/samsung/android/support/senl/addons/brush/view/injector/ColorModelInjector\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,79:1\n37#2:80\n36#2,3:81\n*S KotlinDebug\n*F\n+ 1 ColorModelInjector.kt\ncom/samsung/android/support/senl/addons/brush/view/injector/ColorModelInjector\n*L\n64#1:80\n64#1:81,3\n*E\n"})
public class ColorModelInjector implements IColorModelInjector {

    @NotNull
    private static final String BRUSH_V6 = "_brush_v6";

    @NotNull
    private static final String COLOR_SETTINGS = "COLOR_SETTINGS";

    @NotNull
    private static final String TAG = Logger.createBrushTag("ColorModelInjector");

    @NotNull
    private final SpenColorPaletteUtil mColorSettingUtil;

    @NotNull
    private final String mCustomColor;

    @NotNull
    private final List<SpenColorPaletteData> mDefaultColorPalletList = new ArrayList();

    public ColorModelInjector(@Nullable Context context) {
        Intrinsics.checkNotNull(context);
        String string = context.getResources().getString(C7944R.string.brush_menu_custom_color);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.mCustomColor = string;
        this.mColorSettingUtil = new SpenColorPaletteUtil(context);
        String string2 = PreferenceUtils.getString(BRUSH_V6, COLOR_SETTINGS, "");
        Intrinsics.checkNotNull(string2);
        if (string2.length() > 0) {
            for (String str : (String[]) AbstractC12991c.m13999t(0, ":", string2).toArray(new String[0])) {
                if (!Intrinsics.areEqual(str, "")) {
                    SpenColorPaletteData spenColorPaletteData = new SpenColorPaletteData();
                    spenColorPaletteData.index = Integer.parseInt(str);
                    this.mDefaultColorPalletList.add(spenColorPaletteData);
                }
            }
        }
        this.mColorSettingUtil.getColorTables(this.mDefaultColorPalletList);
        if (this.mDefaultColorPalletList.isEmpty()) {
            loadDefault(this.mDefaultColorPalletList);
            this.mColorSettingUtil.getColorTables(this.mDefaultColorPalletList);
        }
        Logger.m7100d(TAG, "loadData");
    }

    private final void loadDefault(List<SpenColorPaletteData> paletteList) {
        for (int i : IColorPaletteModel.INSTANCE.getINFO_DEFAULT_LIST()) {
            SpenColorPaletteData spenColorPaletteData = new SpenColorPaletteData();
            spenColorPaletteData.index = i;
            paletteList.add(spenColorPaletteData);
        }
    }

    @Override // com.samsung.android.support.senl.addons.brush.model.color.IColorModelInjector
    @Nullable
    public String getColorName(int color, int page, int index) {
        ArrayList arrayList = new ArrayList();
        SpenColorPaletteData spenColorPaletteData = new SpenColorPaletteData();
        spenColorPaletteData.index = page;
        arrayList.add(spenColorPaletteData);
        this.mColorSettingUtil.getColorTables(arrayList);
        return (arrayList.isEmpty() || index >= ((SpenColorPaletteData) arrayList.get(0)).values.length || ((SpenColorPaletteData) arrayList.get(0)).values[index] != color) ? this.mCustomColor : ((SpenColorPaletteData) arrayList.get(0)).names[index];
    }

    @Override // com.samsung.android.support.senl.addons.brush.model.color.IColorModelInjector
    public void getColorTables(@Nullable List<SpenColorPaletteData> tables) {
        if (tables != null) {
            this.mColorSettingUtil.getColorTables(tables);
            if (tables.isEmpty()) {
                loadDefault(TypeIntrinsics.asMutableList(tables));
            }
        }
    }

    @Override // com.samsung.android.support.senl.addons.brush.model.color.IColorModelInjector
    @NotNull
    public List<SpenColorPaletteData> getPaletteDatum() {
        return this.mDefaultColorPalletList;
    }
}
