package com.samsung.android.support.senl.p148nt.app.inapp.view.setting.text;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.widget.ImageView;
import com.samsung.android.sdk.pen.setting.color.SpenColorPaletteData;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.util.ResourcesUtils;
import com.samsung.android.support.senl.p148nt.app.inapp.view.setting.text.InAppPaletteCreator;
import com.samsung.android.support.senl.p148nt.base.common.inapp.common.InAppLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012J\u0018\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0016\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\rH\u0016J\u0010\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\rH\u0016R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/inapp/view/setting/text/InAppTextBgColorPalette;", "Lcom/samsung/android/support/senl/nt/app/inapp/view/setting/text/InAppPaletteCreator;", "context", "Landroid/content/Context;", "pickerSelector", "Landroid/view/View;", "titleColorBar", "Landroid/widget/ImageView;", "itemActionListener", "Lcom/samsung/android/support/senl/nt/app/inapp/view/setting/text/InAppPaletteCreator$OnItemActionListener;", "<init>", "(Landroid/content/Context;Landroid/view/View;Landroid/widget/ImageView;Lcom/samsung/android/support/senl/nt/app/inapp/view/setting/text/InAppPaletteCreator$OnItemActionListener;)V", "mPageBgColor", "", "create", "", "backgroundColor", "isDarkTheme", "", "setDefaultColorInPalette", "updatePageBgColor", "pageBgColor", "setSelectedColor", "paletteId", "colorIndex", "updateColor", "color", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class InAppTextBgColorPalette extends InAppPaletteCreator {

    @NotNull
    private static final String TAG = "InAppTextBgColorPalette";
    private int mPageBgColor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InAppTextBgColorPalette(@NotNull Context context, @NotNull View pickerSelector, @NotNull ImageView titleColorBar, @NotNull InAppPaletteCreator.OnItemActionListener itemActionListener) {
        super(context, pickerSelector, titleColorBar, itemActionListener);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pickerSelector, "pickerSelector");
        Intrinsics.checkNotNullParameter(titleColorBar, "titleColorBar");
        Intrinsics.checkNotNullParameter(itemActionListener, "itemActionListener");
    }

    private final void setDefaultColorInPalette(int backgroundColor, boolean isDarkTheme) {
        getColorPaletteData().clear();
        SpenColorPaletteData spenColorPaletteData = new SpenColorPaletteData();
        spenColorPaletteData.index = 0;
        spenColorPaletteData.nameId = C8003R.array.rich_text_bg_color_spen_setting_name;
        spenColorPaletteData.valueId = C8003R.array.rich_text_bg_color_spen_setting;
        int[] intArray = this.mContext.getResources().getIntArray(spenColorPaletteData.valueId);
        Intrinsics.checkNotNullExpressionValue(intArray, "getIntArray(...)");
        spenColorPaletteData.values = intArray;
        int[] intArray2 = this.mContext.getResources().getIntArray(C8003R.array.rich_text_bg_color_spen_setting_Theme);
        Intrinsics.checkNotNullExpressionValue(intArray2, "getIntArray(...)");
        spenColorPaletteData.themeValues = intArray2;
        String[] stringArray = this.mContext.getResources().getStringArray(C8003R.array.rich_text_bg_color_spen_setting_default_name);
        Intrinsics.checkNotNullExpressionValue(stringArray, "getStringArray(...)");
        spenColorPaletteData.names = stringArray;
        getColorPaletteData().add(spenColorPaletteData);
        updatePageBgColor(backgroundColor, isDarkTheme);
        int length = spenColorPaletteData.values.length;
        for (int i = 1; i < length; i++) {
            String str = spenColorPaletteData.names[i];
            if (str != null) {
                this.mPaletteContainerViewList.get(0).setColor(i, isDarkTheme ? spenColorPaletteData.themeValues[i] : spenColorPaletteData.values[i], str);
            }
        }
        if (isDarkTheme) {
            int i2 = length - 1;
            this.mPaletteContainerViewList.get(0).setResource(i2, C8003R.drawable.in_app_text_palette_bg_with_stroke, "");
            this.mPaletteContainerViewList.get(0).updateSelector(i2, false);
        }
    }

    public final void create(int backgroundColor, boolean isDarkTheme) {
        initPaletteContainerViewList(1);
        setDefaultColorInPalette(backgroundColor, isDarkTheme);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.inapp.view.setting.text.InAppPaletteCreator
    public void setSelectedColor(int paletteId, int colorIndex) {
        InAppLogger.m8598i(TAG, "setSelectedColor# colorIndex=" + colorIndex);
        int i = this.mCurrentColorIndex;
        if (i == -1) {
            updatePickerSelection(false);
        } else if (i >= 0 && i != colorIndex) {
            getPaletteContainerViewList().get(0).updatePaletteItem(this.mCurrentColorIndex, false, true);
        }
        this.mCurrentColorIndex = colorIndex;
        if (colorIndex == -1) {
            updatePickerSelection(true);
        } else {
            setCurrentColor(Integer.valueOf(getColorPaletteData().get(0).values[colorIndex]));
            getPaletteContainerViewList().get(0).updatePaletteItem(colorIndex, true, true);
        }
        if (colorIndex == 0) {
            this.mTitleColorBar.setImageTintList(ColorStateList.valueOf(this.mPageBgColor));
        } else if (getCurrentColor() != null) {
            ImageView imageView = this.mTitleColorBar;
            Integer currentColor = getCurrentColor();
            Intrinsics.checkNotNull(currentColor);
            imageView.setImageTintList(ColorStateList.valueOf(currentColor.intValue()));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.inapp.view.setting.text.InAppPaletteCreator
    public void updateColor(int color) {
        setCurrentColor(Integer.valueOf(color));
        SpenColorPaletteData spenColorPaletteData = getColorPaletteData().get(0);
        for (int i = 0; i < 8; i++) {
            if (spenColorPaletteData.values[i] == color) {
                setSelectedColor(0, i);
                return;
            }
        }
        setSelectedColor(0, -1);
    }

    public final void updatePageBgColor(int pageBgColor, boolean isDarkTheme) {
        boolean z = this.mCurrentColorIndex == 0;
        if (pageBgColor == ResourcesUtils.getDefaultBackgroundColor(this.mContext.getResources())) {
            if (isDarkTheme) {
                pageBgColor = this.mContext.getColor(C8003R.color.background_color_black);
                this.mPaletteContainerViewList.get(0).setColor(0, pageBgColor, z);
            } else {
                this.mPaletteContainerViewList.get(0).setResource(0, C8003R.drawable.in_app_text_palette_bg_with_stroke, "", z);
            }
            this.mPaletteContainerViewList.get(0).updateSelector(0, isDarkTheme);
        } else {
            this.mPaletteContainerViewList.get(0).setColor(0, pageBgColor, z);
            this.mPaletteContainerViewList.get(0).updateSelector(0, true);
        }
        this.mPageBgColor = pageBgColor;
        if (z) {
            this.mTitleColorBar.setImageTintList(ColorStateList.valueOf(pageBgColor));
        }
    }
}
