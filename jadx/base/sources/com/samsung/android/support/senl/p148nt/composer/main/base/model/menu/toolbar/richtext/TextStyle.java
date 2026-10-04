package com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.richtext;

import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.ColorCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TextStyle {
    public static final String DIVIDE = ";";
    private static final int INDEX_INVALID = -1;
    public static final String KEY_TEXT_STYLE_INFO = "KEY_TEXT_STYLE_INFO";
    public static final String KEY_TEXT_STYLE_LIST = "KEY_TEXT_STYLE_LIST";
    private static final String TAG = Logger.createTag("TextStyle");
    private int mFontBgColor;
    private float[] mFontBgColorHsvColor;
    private int mFontBgColorUIInfo;
    private int mFontColor;
    private float[] mFontColorHsvColor;
    private int mFontColorUIInfo;
    private int mFontSize;
    private int mIndex;
    private boolean mIsBold;
    private boolean mIsItalic;
    private boolean mIsStrikethrough;
    private boolean mIsUnderline;
    private String mLastInfo;

    public TextStyle() {
        this.mIndex = -1;
        this.mFontColorHsvColor = new float[3];
        this.mFontBgColorHsvColor = new float[3];
    }

    public String convertToString(TextStyle textStyle) {
        return textStyle.isBold() + ";" + textStyle.isItalic() + ";" + textStyle.isUnderline() + ";" + textStyle.isStrikethrough() + ";" + textStyle.getFontSize() + ";" + textStyle.getFontColor() + ";" + textStyle.getFontColorUIInfo() + ";" + textStyle.mFontColorHsvColor[0] + ";" + textStyle.mFontColorHsvColor[1] + ";" + textStyle.mFontColorHsvColor[2] + ";" + textStyle.getFontBgColor() + ";" + textStyle.getFontBgColorUIInfo() + ";" + textStyle.mFontBgColorHsvColor[0] + ";" + textStyle.mFontBgColorHsvColor[1] + ";" + textStyle.mFontBgColorHsvColor[2];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            TextStyle textStyle = (TextStyle) obj;
            if (this.mIsBold == textStyle.mIsBold && this.mIsItalic == textStyle.mIsItalic && this.mIsUnderline == textStyle.mIsUnderline && this.mIsStrikethrough == textStyle.mIsStrikethrough && this.mFontSize == textStyle.mFontSize && this.mFontColor == textStyle.mFontColor && this.mFontBgColor == textStyle.mFontBgColor) {
                return true;
            }
        }
        return false;
    }

    public int getFontBgColor() {
        return this.mFontBgColor;
    }

    public float[] getFontBgColorHsvColor() {
        return this.mFontBgColorHsvColor;
    }

    public int getFontBgColorUIInfo() {
        return this.mFontBgColorUIInfo;
    }

    public int getFontColor() {
        return this.mFontColor;
    }

    public float[] getFontColorHsvColor() {
        return this.mFontColorHsvColor;
    }

    public int getFontColorUIInfo() {
        return this.mFontColorUIInfo;
    }

    public int getFontSize() {
        return this.mFontSize;
    }

    public int getIndex() {
        return this.mIndex;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.mIndex), Boolean.valueOf(this.mIsBold), Boolean.valueOf(this.mIsItalic), Boolean.valueOf(this.mIsUnderline), Boolean.valueOf(this.mIsStrikethrough), Integer.valueOf(this.mFontSize), Integer.valueOf(this.mFontColor), Integer.valueOf(this.mFontBgColor));
    }

    public boolean isBold() {
        return this.mIsBold;
    }

    public boolean isItalic() {
        return this.mIsItalic;
    }

    public boolean isStrikethrough() {
        return this.mIsStrikethrough;
    }

    public boolean isUnderline() {
        return this.mIsUnderline;
    }

    public boolean load() {
        if (this.mIndex == -1) {
            return false;
        }
        String string = SharedPreferencesCompat.getInstance(KEY_TEXT_STYLE_INFO).getString(String.valueOf(this.mIndex), "");
        this.mLastInfo = string;
        if (string == null || string.isEmpty()) {
            int i = this.mIndex;
            if (i == 0) {
                this.mLastInfo = "true;true;true;true;30;-16776961;0;240.0;1.0;1.0;-7829368;0;0.0;0.0;0.53333336";
            } else if (i == 1) {
                this.mLastInfo = "false;true;false;true;60;-65536;0;0.0;1.0;1.0;-1;0;0.0;0.0;1.0";
            } else {
                if (i != 2) {
                    return false;
                }
                this.mLastInfo = "true;true;false;true;60;-65536;0;0.0;1.0;1.0;-7829368;0;0.0;0.0;0.53333336";
            }
        }
        try {
            load(this.mLastInfo);
        } catch (Exception e) {
            AbstractC8014b.m7207i("load# e = ", e, TAG);
        }
        return true;
    }

    public boolean save() {
        if (this.mIndex == -1) {
            return false;
        }
        String strConvertToString = convertToString(this);
        if (this.mLastInfo.equals(strConvertToString)) {
            return true;
        }
        SharedPreferencesCompat.getInstance(KEY_TEXT_STYLE_INFO).putString(String.valueOf(this.mIndex), strConvertToString);
        return true;
    }

    public void setBold(boolean z) {
        this.mIsBold = z;
    }

    public void setFontBgColor(int i) {
        this.mFontBgColor = i;
    }

    public void setFontBgColorHsvColor(float[] fArr) {
        this.mFontBgColorHsvColor = fArr;
    }

    public void setFontBgColorUIInfo(int i) {
        this.mFontBgColorUIInfo = i;
    }

    public void setFontBgColorWithHSV(int i) {
        this.mFontBgColor = i;
        this.mFontBgColorUIInfo = 0;
        float[] fArr = new float[3];
        ColorCompat.colorToHSV(i, fArr);
        this.mFontBgColorHsvColor = fArr;
    }

    public void setFontColor(int i) {
        this.mFontColor = i;
    }

    public void setFontColorHsvColor(float[] fArr) {
        this.mFontColorHsvColor = fArr;
    }

    public void setFontColorUIInfo(int i) {
        this.mFontColorUIInfo = i;
    }

    public void setFontColorWithHSV(int i) {
        this.mFontColor = i;
        this.mFontColorUIInfo = 0;
        float[] fArr = new float[3];
        ColorCompat.colorToHSV(i, fArr);
        this.mFontColorHsvColor = fArr;
    }

    public void setFontSize(int i) {
        this.mFontSize = i;
    }

    public TextStyle setIndex(int i) {
        this.mIndex = i;
        return this;
    }

    public void setItalic(boolean z) {
        this.mIsItalic = z;
    }

    public void setStrikethrough(boolean z) {
        this.mIsStrikethrough = z;
    }

    public void setUnderline(boolean z) {
        this.mIsUnderline = z;
    }

    public TextStyle(TextStyle textStyle) {
        this.mIndex = -1;
        this.mFontColorHsvColor = new float[3];
        this.mFontBgColorHsvColor = new float[3];
        this.mIndex = textStyle.mIndex;
        this.mIsBold = textStyle.mIsBold;
        this.mIsItalic = textStyle.mIsItalic;
        this.mIsUnderline = textStyle.mIsUnderline;
        this.mIsStrikethrough = textStyle.mIsStrikethrough;
        this.mFontSize = textStyle.mFontSize;
        this.mFontColor = textStyle.mFontColor;
        this.mFontColorUIInfo = textStyle.mFontColorUIInfo;
        this.mFontColorHsvColor = (float[]) textStyle.mFontColorHsvColor.clone();
        this.mFontBgColor = textStyle.mFontBgColor;
        this.mFontBgColorUIInfo = textStyle.mFontBgColorUIInfo;
        this.mFontBgColorHsvColor = (float[]) textStyle.mFontBgColorHsvColor.clone();
        this.mLastInfo = textStyle.mLastInfo;
    }

    private void load(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        String[] strArrSplit = str.split(";");
        if (strArrSplit.length == 0) {
            return;
        }
        this.mIsBold = Boolean.parseBoolean(strArrSplit[0]);
        this.mIsItalic = Boolean.parseBoolean(strArrSplit[1]);
        this.mIsUnderline = Boolean.parseBoolean(strArrSplit[2]);
        this.mIsStrikethrough = Boolean.parseBoolean(strArrSplit[3]);
        this.mFontSize = Integer.parseInt(strArrSplit[4]);
        this.mFontColor = Integer.parseInt(strArrSplit[5]);
        this.mFontColorUIInfo = Integer.parseInt(strArrSplit[6]);
        this.mFontColorHsvColor[0] = Float.parseFloat(strArrSplit[7]);
        this.mFontColorHsvColor[1] = Float.parseFloat(strArrSplit[8]);
        this.mFontColorHsvColor[2] = Float.parseFloat(strArrSplit[9]);
        this.mFontBgColor = Integer.parseInt(strArrSplit[10]);
        this.mFontBgColorUIInfo = Integer.parseInt(strArrSplit[11]);
        this.mFontBgColorHsvColor[0] = Float.parseFloat(strArrSplit[12]);
        this.mFontBgColorHsvColor[1] = Float.parseFloat(strArrSplit[13]);
        this.mFontBgColorHsvColor[2] = Float.parseFloat(strArrSplit[14]);
    }
}
