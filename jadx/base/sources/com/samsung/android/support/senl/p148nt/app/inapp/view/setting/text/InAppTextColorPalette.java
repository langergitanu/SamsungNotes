package com.samsung.android.support.senl.p148nt.app.inapp.view.setting.text;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.widget.ImageView;
import com.samsung.android.sdk.pen.setting.color.SpenColorPaletteData;
import com.samsung.android.sdk.pen.setting.color.SpenColorPaletteUtil;
import com.samsung.android.support.senl.p148nt.app.inapp.view.setting.text.InAppPaletteCreator;
import com.samsung.android.support.senl.p148nt.base.common.inapp.common.InAppLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\u0012\u001a\u00020\u00132\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\u0014\u001a\u00020\u0015J\u001e\u0010\u0016\u001a\u00020\u00132\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u000eH\u0016J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u000eH\u0016R.\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/inapp/view/setting/text/InAppTextColorPalette;", "Lcom/samsung/android/support/senl/nt/app/inapp/view/setting/text/InAppPaletteCreator;", "context", "Landroid/content/Context;", "pickerSelector", "Landroid/view/View;", "titleColorBar", "Landroid/widget/ImageView;", "itemActionListener", "Lcom/samsung/android/support/senl/nt/app/inapp/view/setting/text/InAppPaletteCreator$OnItemActionListener;", "<init>", "(Landroid/content/Context;Landroid/view/View;Landroid/widget/ImageView;Lcom/samsung/android/support/senl/nt/app/inapp/view/setting/text/InAppPaletteCreator$OnItemActionListener;)V", "value", "", "", "paletteList", "getPaletteList", "()Ljava/util/List;", "create", "", "isDarkTheme", "", "initColorInPalette", "setSelectedColor", "paletteId", "colorIndex", "updateColor", "color", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class InAppTextColorPalette extends InAppPaletteCreator {

    @NotNull
    private static final String TAG = "InAppTextColorPalette";

    @Nullable
    private List<Integer> paletteList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InAppTextColorPalette(@NotNull Context context, @NotNull View pickerSelector, @NotNull ImageView titleColorBar, @NotNull InAppPaletteCreator.OnItemActionListener itemActionListener) {
        super(context, pickerSelector, titleColorBar, itemActionListener);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pickerSelector, "pickerSelector");
        Intrinsics.checkNotNullParameter(titleColorBar, "titleColorBar");
        Intrinsics.checkNotNullParameter(itemActionListener, "itemActionListener");
    }

    private final void initColorInPalette(List<Integer> paletteList, boolean isDarkTheme) {
        SpenColorPaletteUtil spenColorPaletteUtil = new SpenColorPaletteUtil(this.mContext);
        getColorPaletteData().clear();
        Iterator<Integer> it = paletteList.iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            SpenColorPaletteData spenColorPaletteData = new SpenColorPaletteData();
            spenColorPaletteData.index = iIntValue;
            getColorPaletteData().add(spenColorPaletteData);
        }
        spenColorPaletteUtil.getColorTables(getColorPaletteData());
        int size = getColorPaletteData().size();
        for (int i = 0; i < size; i++) {
            SpenColorPaletteData spenColorPaletteData2 = getColorPaletteData().get(i);
            int length = spenColorPaletteData2.values.length;
            for (int i2 = 0; i2 < length; i2++) {
                String str = spenColorPaletteData2.names[i2];
                if (str != null && str != null) {
                    this.mPaletteContainerViewList.get(i).setColor(i2, isDarkTheme ? spenColorPaletteData2.themeValues[i2] : spenColorPaletteData2.values[i2], str);
                }
            }
        }
    }

    public final void create(@Nullable List<Integer> paletteList, boolean isDarkTheme) {
        this.mCurrentPaletteId = 0;
        this.mCurrentColorIndex = 0;
        List<Integer> list = paletteList;
        if (list == null || list.isEmpty()) {
            InAppLogger.m8596e(TAG, "create# fail - paletteList is empty.");
            return;
        }
        initPaletteContainerViewList(paletteList.size());
        initColorInPalette(paletteList, isDarkTheme);
        this.paletteList = paletteList;
    }

    @Nullable
    public final List<Integer> getPaletteList() {
        return this.paletteList;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.inapp.view.setting.text.InAppPaletteCreator
    public void setSelectedColor(int paletteId, int colorIndex) {
        InAppLogger.m8598i(TAG, "setSelectedColor# paletteId= " + paletteId + ", colorIndex= " + colorIndex);
        int i = this.mCurrentColorIndex;
        if (i == -1) {
            updatePickerSelection(false);
        } else if (i >= 0 && (this.mCurrentPaletteId != paletteId || i != colorIndex)) {
            getPaletteContainerViewList().get(this.mCurrentPaletteId).updatePaletteItem(this.mCurrentColorIndex, false, true);
        }
        this.mCurrentPaletteId = paletteId;
        this.mCurrentColorIndex = colorIndex;
        if (colorIndex == -1) {
            updatePickerSelection(true);
        } else {
            setCurrentColor(Integer.valueOf(getColorPaletteData().get(paletteId).values[colorIndex]));
            getPaletteContainerViewList().get(paletteId).updatePaletteItem(colorIndex, true, true);
        }
        Integer currentColor = getCurrentColor();
        if (currentColor != null) {
            this.mTitleColorBar.setImageTintList(ColorStateList.valueOf(currentColor.intValue()));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.inapp.view.setting.text.InAppPaletteCreator
    public void updateColor(int color) {
        setCurrentColor(Integer.valueOf(color));
        int size = getColorPaletteData().size();
        boolean z = true;
        for (int i = 0; i < size; i++) {
            SpenColorPaletteData spenColorPaletteData = getColorPaletteData().get(i);
            int i2 = 0;
            while (true) {
                if (i2 >= 8) {
                    break;
                }
                if (spenColorPaletteData.values[i2] == color) {
                    setSelectedColor(i, i2);
                    z = false;
                    break;
                }
                i2++;
            }
        }
        if (z) {
            setSelectedColor(0, -1);
        }
    }
}
