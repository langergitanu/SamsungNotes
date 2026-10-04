package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.menu.setting.color;

import android.content.Context;
import android.graphics.Color;
import com.samsung.android.sdk.pen.setting.color.SpenColorPaletteData;
import com.samsung.android.support.senl.p148nt.base.winset.app.picker.color.BaseColorPalette;
import com.samsung.android.support.senl.p148nt.composer.C9086R;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ColorPalette extends BaseColorPalette {
    public ColorPalette(Context context, BaseColorPalette.Contract contract) {
        super(context, contract);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.app.picker.color.BaseColorPalette
    public void setDefaultColorInPalette() {
        this.mColorPaletteData.clear();
        SpenColorPaletteData spenColorPaletteData = new SpenColorPaletteData();
        spenColorPaletteData.index = 0;
        spenColorPaletteData.nameId = C9086R.array.rich_text_bg_color_spen_setting_name;
        spenColorPaletteData.valueId = C9086R.array.rich_text_bg_color_spen_setting;
        spenColorPaletteData.values = this.mPaletteView.getResources().getIntArray(spenColorPaletteData.valueId);
        spenColorPaletteData.themeValues = this.mPaletteView.getResources().getIntArray(C9086R.array.rich_text_bg_color_spen_setting_Theme);
        spenColorPaletteData.names = this.mPaletteView.getResources().getStringArray(C9086R.array.rich_text_bg_color_spen_setting_default_name);
        int length = spenColorPaletteData.values.length;
        float[] fArr = new float[3];
        int i = 0;
        while (i < length) {
            if (i == 0) {
                Color.colorToHSV(this.mPageBgColor, fArr);
            } else {
                Color.colorToHSV(this.mDarkMode ? spenColorPaletteData.themeValues[i] : spenColorPaletteData.values[i], fArr);
            }
            this.mPaletteView.setColor(0, i < 8 ? i : i + 1, fArr, spenColorPaletteData.names[i]);
            i++;
        }
        this.mColorPaletteData.add(spenColorPaletteData);
    }
}
