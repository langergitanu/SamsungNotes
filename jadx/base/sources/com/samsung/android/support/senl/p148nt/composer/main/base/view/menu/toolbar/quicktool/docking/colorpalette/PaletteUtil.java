package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.colorpalette;

import android.content.Context;
import com.samsung.android.sdk.pen.setting.color.SpenColorPaletteData;
import com.samsung.android.sdk.pen.setting.color.SpenColorPaletteUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bJ\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/colorpalette/PaletteUtil;", "", "<init>", "()V", "getDefinedPaletteData", "", "Lcom/samsung/android/sdk/pen/setting/color/SpenColorPaletteData;", "context", "Landroid/content/Context;", "swatchList", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PaletteUtil {

    @NotNull
    public static final PaletteUtil INSTANCE = new PaletteUtil();

    private PaletteUtil() {
    }

    @NotNull
    public final List<SpenColorPaletteData> getDefinedPaletteData(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList arrayList = new ArrayList();
        for (int i = 1; i < 24; i++) {
            arrayList.add(Integer.valueOf(i));
        }
        return getDefinedPaletteData(context, arrayList);
    }

    @NotNull
    public final List<SpenColorPaletteData> getDefinedPaletteData(@NotNull Context context, @NotNull List<Integer> swatchList) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(swatchList, "swatchList");
        SpenColorPaletteUtil spenColorPaletteUtil = new SpenColorPaletteUtil(context);
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = swatchList.iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            SpenColorPaletteData spenColorPaletteData = new SpenColorPaletteData();
            spenColorPaletteData.index = iIntValue;
            arrayList.add(spenColorPaletteData);
        }
        spenColorPaletteUtil.getColorTables(arrayList);
        spenColorPaletteUtil.close();
        return arrayList;
    }
}
