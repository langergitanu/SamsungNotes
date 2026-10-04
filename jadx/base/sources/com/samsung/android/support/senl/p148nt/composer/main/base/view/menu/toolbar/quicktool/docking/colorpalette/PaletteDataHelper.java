package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.colorpalette;

import android.content.Context;
import android.graphics.Color;
import com.samsung.android.sdk.pen.setting.color.SpenColorPaletteData;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\fJ$\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u00112\u0006\u0010\u0012\u001a\u00020\nJ\u001c\u0010\u0013\u001a\u00020\f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u00112\u0006\u0010\u0012\u001a\u00020\nJ\u000e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\nJ\u000e\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\nJ\u001e\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\nJ \u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0016\u0010 \u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\nJ\u0010\u0010$\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001b\u001a\u00020\nJ\u0010\u0010%\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010!\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006&"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/colorpalette/PaletteDataHelper;", "", "<init>", "()V", "mInitComplete", "", "mColorPaletteData", "", "Lcom/samsung/android/sdk/pen/setting/color/SpenColorPaletteData;", "mViewIndexList", "", "close", "", "setPaletteInfo", "context", "Landroid/content/Context;", "paletteInfo", "", "exceptPage", "setPaletteData", "paletteData", "isDefinedColor", "color", "", "getViewIndex", "paletteID", "getPaletteID", "viewIndex", "getChildIndex", "opacity", "getColor", "childIndex", "getOpacity", "paletteSize", "getPaletteSize", "()I", "getPaletteData", "getDataIndex", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nPaletteDataHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PaletteDataHelper.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/colorpalette/PaletteDataHelper\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,123:1\n1#2:124\n*E\n"})
public final class PaletteDataHelper {

    @Nullable
    private List<SpenColorPaletteData> mColorPaletteData;
    private boolean mInitComplete;

    @Nullable
    private List<Integer> mViewIndexList;

    private final int getDataIndex(int viewIndex) {
        List<Integer> list;
        if (this.mInitComplete && (list = this.mViewIndexList) != null) {
            return list.indexOf(Integer.valueOf(viewIndex));
        }
        return -1;
    }

    public final void close() {
        this.mViewIndexList = null;
        this.mColorPaletteData = null;
        this.mInitComplete = false;
    }

    public final int getChildIndex(int viewIndex, @NotNull float[] color, int opacity) {
        Intrinsics.checkNotNullParameter(color, "color");
        int iHSVToColor = SpenSettingUtil.HSVToColor(opacity, color);
        SpenColorPaletteData paletteData = getPaletteData(viewIndex);
        if (paletteData == null) {
            return -1;
        }
        int length = paletteData.values.length;
        for (int i = 0; i < length; i++) {
            if (paletteData.values[i] == iHSVToColor) {
                return i;
            }
        }
        return -1;
    }

    public final boolean getColor(int viewIndex, int childIndex, @Nullable float[] color) {
        SpenColorPaletteData paletteData = getPaletteData(viewIndex);
        if (paletteData == null) {
            return false;
        }
        Color.colorToHSV(paletteData.values[childIndex], color);
        return true;
    }

    public final int getOpacity(int viewIndex, int childIndex) {
        SpenColorPaletteData paletteData = getPaletteData(viewIndex);
        if (paletteData == null) {
            return 255;
        }
        return Color.alpha(paletteData.values[childIndex]);
    }

    @Nullable
    public final SpenColorPaletteData getPaletteData(int viewIndex) {
        List<SpenColorPaletteData> list;
        int dataIndex = getDataIndex(viewIndex);
        if (dataIndex <= -1 || (list = this.mColorPaletteData) == null) {
            return null;
        }
        return list.get(dataIndex);
    }

    public final int getPaletteID(int viewIndex) {
        SpenColorPaletteData paletteData = getPaletteData(viewIndex);
        if (paletteData != null) {
            return paletteData.index;
        }
        return -1;
    }

    public final int getPaletteSize() {
        List<Integer> list = this.mViewIndexList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public final int getViewIndex(int paletteID) {
        List<SpenColorPaletteData> list = this.mColorPaletteData;
        if (list == null || !this.mInitComplete) {
            return -1;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i).index == paletteID) {
                List<Integer> list2 = this.mViewIndexList;
                if (list2 != null) {
                    return list2.get(i).intValue();
                }
                return -1;
            }
        }
        return -1;
    }

    public final boolean isDefinedColor(@NotNull float[] color) {
        List<Integer> list;
        Intrinsics.checkNotNullParameter(color, "color");
        if (this.mInitComplete && (list = this.mViewIndexList) != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (getChildIndex(list.get(i).intValue(), color, 255) != -1) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void setPaletteData(@NotNull List<SpenColorPaletteData> paletteData, int exceptPage) {
        Intrinsics.checkNotNullParameter(paletteData, "paletteData");
        int size = paletteData.size();
        if (this.mViewIndexList == null) {
            this.mViewIndexList = new ArrayList();
            this.mColorPaletteData = new ArrayList();
        }
        List<Integer> list = this.mViewIndexList;
        if (list != null) {
            list.clear();
        }
        List<SpenColorPaletteData> list2 = this.mColorPaletteData;
        if (list2 != null) {
            list2.clear();
        }
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            if (i == exceptPage) {
                i++;
            }
            List<Integer> list3 = this.mViewIndexList;
            if (list3 != null) {
                list3.add(Integer.valueOf(i));
            }
            i++;
            List<SpenColorPaletteData> list4 = this.mColorPaletteData;
            if (list4 != null) {
                list4.add(paletteData.get(i2));
            }
        }
        this.mInitComplete = true;
    }

    public final void setPaletteInfo(@NotNull Context context, @NotNull List<Integer> paletteInfo, int exceptPage) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(paletteInfo, "paletteInfo");
        setPaletteData(PaletteUtil.INSTANCE.getDefinedPaletteData(context, paletteInfo), exceptPage);
    }
}
