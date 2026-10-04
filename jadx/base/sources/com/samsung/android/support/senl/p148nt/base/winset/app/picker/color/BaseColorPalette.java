package com.samsung.android.support.senl.p148nt.base.winset.app.picker.color;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Pair;
import android.widget.RelativeLayout;
import com.samsung.android.sdk.pen.setting.color.SpenColorPaletteData;
import com.samsung.android.sdk.pen.setting.color.SpenColorPaletteUtil;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewActionListener;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewV4;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseColorPalette {
    public static final int BUTTON_PAGE_BG_POS = 0;
    public static final int BUTTON_PICKER_POS = 8;
    public static final int BUTTON_SETTING_POS = 9;
    private static final String TAG = Logger.createTag("BaseColorPalette");
    protected final Context mContext;
    protected final Contract mContract;
    protected int mCurrentColor;
    protected SpenPaletteViewV4 mPaletteView;
    protected RelativeLayout mPresetLayout;
    protected final List<SpenColorPaletteData> mColorPaletteData = new ArrayList();
    protected int mCurrentPaletteId = -1;
    protected int mCurrentColorIndex = 0;
    protected boolean mHasColorSetting = true;
    protected boolean mIsSelectedColorPicker = false;
    protected int mPageBgColor = 0;
    protected boolean mDarkMode = false;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        int getBackgroundColor();

        boolean isDarkTheme();

        void notifyChangedColor(int i);

        void notifyChangedPaletteId(int i);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnPaletteActionListener extends SpenPaletteViewActionListener {
    }

    public BaseColorPalette(Context context, Contract contract) {
        this.mContext = context;
        this.mContract = contract;
    }

    private void clearSelectionOnPalette() {
        if (this.mIsSelectedColorPicker) {
            setSelectedColorPicker(false);
        } else {
            this.mPaletteView.setSelected(this.mCurrentPaletteId, this.mCurrentColorIndex, false, false);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002d, code lost:
    
        r1 = r1 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Pair<Integer, Integer> findPaletteIndexBy(int i) {
        int i2 = 0;
        while (i2 < this.mColorPaletteData.size()) {
            SpenColorPaletteData spenColorPaletteData = this.mColorPaletteData.get(i2);
            int i4 = 0;
            while (true) {
                int[] iArr = spenColorPaletteData.values;
                if (i4 < iArr.length) {
                    if (i == iArr[i4]) {
                        return new Pair<>(Integer.valueOf(i2), Integer.valueOf(i4));
                    }
                    i4++;
                }
            }
        }
        throw new NoSuchElementException("not found " + Integer.toHexString(i) + " in palette");
    }

    private void setButtonInPalette() {
        int size = this.mColorPaletteData.size();
        for (int i = 0; i < size; i++) {
            this.mPaletteView.setResource(i, 8, C8875R.drawable.note_handwriting_setting_color_01, C8875R.string.pen_string_color_picker, C8875R.drawable.color_picker_icon_selector);
            if (this.mHasColorSetting) {
                this.mPaletteView.setResource(i, 9, C8875R.drawable.note_handwriting_setting_color_02, C8875R.string.pen_string_select_color_set_to_show);
            }
        }
    }

    private void setColorInPalette(List<Integer> list) {
        SpenColorPaletteUtil spenColorPaletteUtil = new SpenColorPaletteUtil(this.mContext);
        this.mColorPaletteData.clear();
        for (Integer num : list) {
            SpenColorPaletteData spenColorPaletteData = new SpenColorPaletteData();
            spenColorPaletteData.index = num.intValue();
            this.mColorPaletteData.add(spenColorPaletteData);
        }
        if (!spenColorPaletteUtil.getIsInitComplete()) {
            Logger.m8697d(TAG, "setColorInPalette# SpenColorSettingUtil has problem.");
            return;
        }
        spenColorPaletteUtil.getColorTables(this.mColorPaletteData);
        float[] fArr = new float[3];
        int size = this.mColorPaletteData.size();
        for (int i = 0; i < size; i++) {
            SpenColorPaletteData spenColorPaletteData2 = this.mColorPaletteData.get(i);
            int length = spenColorPaletteData2.values.length;
            int i2 = 0;
            while (i2 < length) {
                Color.colorToHSV(this.mDarkMode ? spenColorPaletteData2.themeValues[i2] : spenColorPaletteData2.values[i2], fArr);
                this.mPaletteView.setColor(i, i2 < 8 ? i2 : i2 + 1, fArr, spenColorPaletteData2.names[i2]);
                i2++;
            }
        }
    }

    private void setCurrentPaletteId(int i) {
        this.mCurrentPaletteId = i;
        this.mContract.notifyChangedPaletteId(i);
    }

    private void setSelectedColorByColor() {
        int size = this.mColorPaletteData.size();
        for (int i = 0; i < size; i++) {
            SpenColorPaletteData spenColorPaletteData = this.mColorPaletteData.get(i);
            int length = spenColorPaletteData.values.length;
            int i2 = 0;
            while (i2 < length) {
                int i4 = i2 < 8 ? i2 : i2 + 1;
                int i5 = spenColorPaletteData.values[i2];
                boolean z = this.mHasColorSetting;
                if (!z && i4 == 9) {
                    i5 = 0;
                }
                if (!z && i4 == 0) {
                    i5 = 0;
                }
                if (i5 == this.mCurrentColor) {
                    this.mPaletteView.setSelected(i, i4, true, false);
                    this.mPaletteView.setPage(i, false);
                    setCurrentPaletteId(i);
                    this.mCurrentColorIndex = i4;
                    return;
                }
                i2++;
            }
        }
        this.mPaletteView.setPage(0, false);
        setSelectedColorPicker(true);
        setCurrentPaletteId(-1);
    }

    private void setSelectedColorPicker(boolean z) {
        this.mIsSelectedColorPicker = z;
        int size = this.mColorPaletteData.size();
        for (int i = 0; i < size; i++) {
            this.mPaletteView.setSelected(i, 8, z, false);
            updateColorPickerColor(i, z);
        }
    }

    private void updateColorPickerColor(int i, boolean z) {
        Drawable selectorDrawable = this.mPaletteView.getSelectorDrawable(i, 8);
        if (selectorDrawable instanceof LayerDrawable) {
            ((GradientDrawable) ((LayerDrawable) selectorDrawable).findDrawableByLayerId(C8875R.id.selector_color)).setColor(z ? this.mCurrentColor : 0);
        }
    }

    public void changeTable(List<Integer> list) {
        this.mPaletteView.setPaletteInfo(list.size());
        setColorInPalette(list);
        setButtonInPalette();
        setSelectedColorByColor();
    }

    public boolean checkColorPaletteData() {
        return !this.mColorPaletteData.isEmpty();
    }

    public void initPalette(List<Integer> list, int i, int i2, boolean z) {
        this.mCurrentColor = i;
        this.mHasColorSetting = z;
        this.mDarkMode = this.mContract.isDarkTheme();
        this.mPageBgColor = this.mContract.getBackgroundColor();
        this.mPaletteView = new SpenPaletteViewV4(this.mContext);
        if (list == null || list.isEmpty()) {
            this.mPaletteView.setPaletteInfo(1);
            setDefaultColorInPalette();
        } else {
            this.mPaletteView.setPaletteInfo(list.size());
            setColorInPalette(list);
        }
        setButtonInPalette();
        setSelectedColorByColor();
        if (i2 == -1) {
            this.mContract.notifyChangedPaletteId(this.mCurrentPaletteId);
        } else {
            this.mCurrentPaletteId = i2;
            this.mPaletteView.setPage(i2, false);
        }
    }

    public void initPresetLayout(RelativeLayout relativeLayout) {
        this.mPresetLayout = relativeLayout;
        relativeLayout.addView(this.mPaletteView);
    }

    public void onColorChangedByPicker(int i) {
        this.mCurrentColor = i;
        setSelectedColorPicker(true);
        int i2 = this.mCurrentPaletteId;
        if (i2 != -1) {
            this.mPaletteView.setSelected(i2, this.mCurrentColorIndex, false, false);
            setCurrentPaletteId(-1);
        }
    }

    public boolean setCurrentColor(int i) {
        if (this.mCurrentColor == i) {
            Logger.m8702i(TAG, "setCurrentColor fail, same color : " + this.mCurrentColor);
            return false;
        }
        this.mCurrentColor = i;
        clearSelectionOnPalette();
        try {
            Pair<Integer, Integer> pairFindPaletteIndexBy = findPaletteIndexBy(i);
            this.mPaletteView.setSelected(((Integer) pairFindPaletteIndexBy.first).intValue(), ((Integer) pairFindPaletteIndexBy.second).intValue(), true, true);
            this.mPaletteView.setPage(((Integer) pairFindPaletteIndexBy.first).intValue(), this.mCurrentPaletteId != ((Integer) pairFindPaletteIndexBy.first).intValue());
            setCurrentPaletteId(((Integer) pairFindPaletteIndexBy.first).intValue());
            this.mCurrentColorIndex = ((Integer) pairFindPaletteIndexBy.second).intValue();
        } catch (NoSuchElementException unused) {
            setSelectedColorPicker(true);
        }
        return true;
    }

    public abstract void setDefaultColorInPalette();

    public void setPaletteActionListener(OnPaletteActionListener onPaletteActionListener) {
        this.mPaletteView.setPaletteActionListener(onPaletteActionListener);
    }

    public void setSelectedColor(int i, int i2, boolean z) {
        if (this.mIsSelectedColorPicker) {
            setSelectedColorPicker(false);
        }
        this.mPaletteView.setSelected(i, i2, true, true);
        int i4 = this.mCurrentPaletteId;
        if (i4 != -1 && (i4 != i || this.mCurrentColorIndex != i2)) {
            this.mPaletteView.setSelected(i4, this.mCurrentColorIndex, false, false);
        }
        setCurrentPaletteId(i);
        this.mCurrentColorIndex = i2;
        boolean z2 = this.mHasColorSetting;
        if (!z2 && i2 == 9) {
            this.mCurrentColor = 0;
        } else if (!z2 && i2 == 0) {
            this.mCurrentColor = 0;
        } else if (this.mColorPaletteData.size() > i) {
            SpenColorPaletteData spenColorPaletteData = this.mColorPaletteData.get(i);
            if (i2 > 8) {
                i2--;
            }
            int[] iArr = spenColorPaletteData.values;
            if (iArr.length > i2) {
                this.mCurrentColor = iArr[i2];
                this.mPaletteView.announceForAccessibility(spenColorPaletteData.names[i2] + SQLKeyword.COMMA + this.mContext.getResources().getString(C8875R.string.selected_str));
            }
        }
        this.mContract.notifyChangedColor(this.mCurrentColor);
    }
}
