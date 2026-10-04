package com.samsung.android.sdk.pen.setting.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.provider.Settings;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.glance.AbstractC2821a;
import com.samsung.android.spen.C7932R;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001:\u00012B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0011\"\u00020\u0012H\u0007¢\u0006\u0002\u0010\u0013J9\u0010\u0014\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0016\u0010\u0010\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00120\u0011\"\u0004\u0018\u00010\u0012H\u0007¢\u0006\u0002\u0010\u0017J)\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00072\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0011\"\u00020\u0012H\u0007¢\u0006\u0002\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u0012H\u0007J7\u0010\u001d\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001e\u001a\u00020\u00052\u0016\u0010\u0010\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00120\u0011\"\u0004\u0018\u00010\u0012H\u0007¢\u0006\u0002\u0010\u001fJ\u001a\u0010 \u001a\u00020\r2\b\u0010!\u001a\u0004\u0018\u00010\u00122\u0006\u0010\"\u001a\u00020\u0007H\u0007J9\u0010#\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010$\u001a\u0004\u0018\u00010\u00162\u0016\u0010\u0010\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00120\u0011\"\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0002\u0010\u0017J\u0010\u0010%\u001a\u00020&2\u0006\u0010\u001c\u001a\u00020\u0012H\u0002J-\u0010'\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\tH\u0002¢\u0006\u0002\u0010*J\u0018\u0010+\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\u0007H\u0002J\u001d\u0010-\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¢\u0006\u0002\u0010.J\u0010\u0010/\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u00100\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u001d\u00101\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¢\u0006\u0002\u0010.R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u00063"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/util/SpenSettingUtilText;", "", "<init>", "()V", "mFontScale", "", "mDeviceCorpCheck", "", "SETTINGS_PACKAGE", "", "mLargeFontIndex", "FONT_SIZE", "setDefaultButtonTextStyle", "", "context", "Landroid/content/Context;", "textViews", "", "Landroid/widget/TextView;", "(Landroid/content/Context;[Landroid/widget/TextView;)V", "setTypeFace", "name", "Lcom/samsung/android/sdk/pen/setting/util/SpenSettingUtilText$FontName;", "(Landroid/content/Context;Lcom/samsung/android/sdk/pen/setting/util/SpenSettingUtilText$FontName;[Landroid/widget/TextView;)V", "findMinValue", "maxWidth", "(I[Landroid/widget/TextView;)V", "resizeTextSize", "tv", "applyUpToLargeLevel", "fontSize", "(Landroid/content/Context;F[Landroid/widget/TextView;)V", "adjustCharLineSeparation", "textView", "maxLine", "setTextAppearance", "fontName", "isEllipsis", "", "getStringArrayFromPackage", "packageName", "identifierName", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;", "getFontScale", "index", "getSystemFontScale", "(Landroid/content/Context;)[Ljava/lang/String;", "getFontSizeIndex", "getLargeFontIndex", "getSystemFontIndex", "FontName", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenSettingUtilText {

    @NotNull
    private static final String FONT_SIZE = "font_size";

    @NotNull
    private static final String SETTINGS_PACKAGE = "com.android.settings";

    @NotNull
    public static final SpenSettingUtilText INSTANCE = new SpenSettingUtilText();
    private static float mFontScale = -1.0f;
    private static int mDeviceCorpCheck = -1;
    private static int mLargeFontIndex = -1;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/util/SpenSettingUtilText$FontName;", "", "<init>", "(Ljava/lang/String;I)V", "REGULAR", "MEDIUM", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class FontName {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ FontName[] $VALUES;
        public static final FontName REGULAR = new FontName("REGULAR", 0);
        public static final FontName MEDIUM = new FontName("MEDIUM", 1);

        private static final /* synthetic */ FontName[] $values() {
            return new FontName[]{REGULAR, MEDIUM};
        }

        static {
            FontName[] fontNameArr$values = $values();
            $VALUES = fontNameArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(fontNameArr$values);
        }

        private FontName(String str, int i) {
        }

        @NotNull
        public static EnumEntries<FontName> getEntries() {
            return $ENTRIES;
        }

        public static FontName valueOf(String str) {
            return (FontName) Enum.valueOf(FontName.class, str);
        }

        public static FontName[] values() {
            return (FontName[]) $VALUES.clone();
        }
    }

    private SpenSettingUtilText() {
    }

    @JvmStatic
    public static final void adjustCharLineSeparation(@Nullable TextView textView, int maxLine) {
        if (textView == null || textView.getWidth() == 0 || textView.getText() == null) {
            return;
        }
        TextPaint paint = textView.getPaint();
        Intrinsics.checkNotNullExpressionValue(paint, "getPaint(...)");
        String string = textView.getText().toString();
        float width = textView.getWidth();
        int iBreakText = paint.breakText(string, true, width, null);
        String strSubstring = string.substring(0, iBreakText);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        int i = 1;
        while (true) {
            string = string.substring(iBreakText);
            Intrinsics.checkNotNullExpressionValue(string, "this as java.lang.String).substring(startIndex)");
            if (string.length() == 0) {
                break;
            }
            i++;
            if (i > maxLine) {
                String strSubstring2 = strSubstring.substring(0, strSubstring.length() - 2);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                strSubstring = AbstractC0541b.m756B(strSubstring2, "...");
                break;
            } else {
                iBreakText = paint.breakText(string, true, width, null);
                String strSubstring3 = string.substring(0, iBreakText);
                Intrinsics.checkNotNullExpressionValue(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
                strSubstring = AbstractC0541b.m756B(strSubstring, StringsKt.trimIndent("\n                \n                " + strSubstring3 + "\n                "));
            }
        }
        textView.setText(strSubstring);
    }

    @JvmStatic
    public static final void applyUpToLargeLevel(@Nullable Context context, float fontSize, @NotNull TextView... textViews) {
        Intrinsics.checkNotNullParameter(textViews, "textViews");
        if (context == null) {
            return;
        }
        int i = 0;
        if (mDeviceCorpCheck == 0) {
            int length = textViews.length;
            while (i < length) {
                TextView textView = textViews[i];
                if (textView != null) {
                    textView.setTextSize(2, fontSize);
                }
                i++;
            }
            return;
        }
        SpenSettingUtilText spenSettingUtilText = INSTANCE;
        int fontSizeIndex = spenSettingUtilText.getFontSizeIndex(context);
        int largeFontIndex = spenSettingUtilText.getLargeFontIndex(context);
        StringBuilder sb = new StringBuilder("applyUpToLargeLevel fontSize=");
        sb.append(fontSize);
        sb.append(", fontSizeIndex=");
        sb.append(fontSizeIndex);
        sb.append(", largeIndex=");
        AbstractC0000a.m26w(sb, "SpenSettingUtilText", largeFontIndex);
        if (fontSizeIndex <= largeFontIndex) {
            int length2 = textViews.length;
            while (i < length2) {
                TextView textView2 = textViews[i];
                if (textView2 != null) {
                    textView2.setTextSize(2, fontSize);
                }
                i++;
            }
            return;
        }
        float fontScale = spenSettingUtilText.getFontScale(context, largeFontIndex);
        float f = context.getResources().getDisplayMetrics().density;
        Log.i("SpenSettingUtilText", "applyUpToLargeLevel scale=" + fontScale + ", density=" + f);
        int length3 = textViews.length;
        for (int i2 = 0; i2 < length3; i2++) {
            TextView textView3 = textViews[i2];
            if (textView3 != null) {
                textView3.setTextSize(0, fontSize * fontScale * f);
            }
        }
    }

    @JvmStatic
    public static final void findMinValue(int maxWidth, @NotNull TextView... textViews) {
        Intrinsics.checkNotNullParameter(textViews, "textViews");
        float[] fArr = new float[textViews.length];
        int length = textViews.length;
        for (int i = 0; i < length; i++) {
            fArr[i] = textViews[i].getTextSize();
        }
        float f = 0.0f;
        while (true) {
            int length2 = textViews.length;
            int measuredWidth = 0;
            for (int i2 = 0; i2 < length2; i2++) {
                textViews[i2].measure(0, 0);
                measuredWidth += textViews[i2].getMeasuredWidth();
            }
            if (measuredWidth <= maxWidth) {
                return;
            }
            f += 1.0f;
            int length3 = textViews.length;
            for (int i4 = 0; i4 < length3; i4++) {
                textViews[i4].setTextSize(0, fArr[i4] - f);
            }
        }
    }

    private final float getFontScale(Context context, int index) {
        float f = mFontScale;
        if (f > -1.0f) {
            return f;
        }
        String[] systemFontScale = getSystemFontScale(context);
        if (systemFontScale == null) {
            mDeviceCorpCheck = 0;
            mFontScale = 1.0f;
            return 1.0f;
        }
        mDeviceCorpCheck = 1;
        if (index >= systemFontScale.length) {
            index = systemFontScale.length - 1;
        }
        try {
            mFontScale = Float.parseFloat(systemFontScale[index]);
        } catch (NumberFormatException unused) {
            Log.e("SpenSettingUtilText", "getFontScale cannot parse font scale");
            mFontScale = 1.0f;
        }
        return mFontScale;
    }

    private final int getFontSizeIndex(Context context) {
        if (!SpenSettingUtilDesktopMode.isDesktopMode(context)) {
            return Settings.Global.getInt(context.getContentResolver(), FONT_SIZE, 0);
        }
        float fontScale = SpenSettingUtilDesktopMode.getFontScale(context);
        String[] systemFontScale = getSystemFontScale(context);
        if (systemFontScale == null) {
            return -1;
        }
        int length = systemFontScale.length - 1;
        int length2 = systemFontScale.length;
        for (int i = 0; i < length2; i++) {
            if (Float.parseFloat(systemFontScale[i]) >= fontScale) {
                return i;
            }
        }
        return length;
    }

    private final int getLargeFontIndex(Context context) {
        int i = mLargeFontIndex;
        if (i > -1) {
            return i;
        }
        String[] systemFontIndex = getSystemFontIndex(context);
        String str = Build.VERSION.SDK_INT < 28 ? "Large" : "1.3";
        int i2 = 0;
        if (systemFontIndex != null) {
            mDeviceCorpCheck = 1;
            int length = systemFontIndex.length;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (Intrinsics.areEqual(str, systemFontIndex[i2])) {
                    mLargeFontIndex = i2;
                    break;
                }
                i2++;
            }
            if (mLargeFontIndex == -1) {
                mLargeFontIndex = 4;
            }
        } else {
            mDeviceCorpCheck = 0;
        }
        return mLargeFontIndex;
    }

    private final String[] getStringArrayFromPackage(Context context, String packageName, String identifierName) {
        if (!TextUtils.isEmpty(packageName) && !TextUtils.isEmpty(identifierName)) {
            try {
                Resources resourcesForApplication = context.getPackageManager().getResourcesForApplication(packageName);
                Intrinsics.checkNotNullExpressionValue(resourcesForApplication, "getResourcesForApplication(...)");
                int identifier = resourcesForApplication.getIdentifier(identifierName, "array", packageName);
                if (identifier > 0) {
                    return resourcesForApplication.getStringArray(identifier);
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return null;
    }

    private final String[] getSystemFontIndex(Context context) {
        return Build.VERSION.SDK_INT < 28 ? getStringArrayFromPackage(context, SETTINGS_PACKAGE, "entry_7_step_font_size") : getStringArrayFromPackage(context, SETTINGS_PACKAGE, "sec_entryvalues_8_step_font_size");
    }

    private final String[] getSystemFontScale(Context context) {
        return Build.VERSION.SDK_INT < 28 ? getStringArrayFromPackage(context, SETTINGS_PACKAGE, "entryvalues_7_step_font_size") : getStringArrayFromPackage(context, SETTINGS_PACKAGE, "sec_entryvalues_8_step_font_size");
    }

    private final boolean isEllipsis(TextView tv) {
        return tv.getLayout() != null && tv.getLayout().getEllipsisCount(tv.getLineCount() - 1) > 0;
    }

    @JvmStatic
    public static final void resizeTextSize(@NotNull TextView tv) {
        Intrinsics.checkNotNullParameter(tv, "tv");
        if (INSTANCE.isEllipsis(tv)) {
            int ellipsizedWidth = tv.getLayout().getEllipsizedWidth() - 10;
            float textSize = tv.getTextSize();
            Log.i("SpenSettingUtilText", "isEllipsis is TRUE. [BEFORE] getWidth=" + ellipsizedWidth + " textSize=" + textSize);
            Paint paint = new Paint();
            Rect rect = new Rect();
            String string = tv.getText().toString();
            paint.setTypeface(tv.getTypeface());
            do {
                textSize -= 1.0f;
                paint.setTextSize(textSize);
                paint.getTextBounds(string, 0, string.length(), rect);
            } while (rect.width() >= ellipsizedWidth);
            tv.setEllipsize(null);
            tv.setTextSize(0, textSize);
            AbstractC2821a.m2206A(new StringBuilder("[AFTER] textSize="), "SpenSettingUtilText", textSize);
        }
    }

    @JvmStatic
    public static final void setDefaultButtonTextStyle(@NotNull Context context, @NotNull TextView... textViews) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(textViews, "textViews");
        INSTANCE.setTextAppearance(context, FontName.MEDIUM, (TextView[]) Arrays.copyOf(textViews, textViews.length));
        int color = SpenSettingUtil.getColor(context, C7932R.color.component_common);
        for (TextView textView : textViews) {
            textView.setTextColor(color);
        }
    }

    private final void setTextAppearance(Context context, FontName fontName, TextView... textViews) {
        int i = fontName == FontName.MEDIUM ? C7932R.style.RobotoMedium : C7932R.style.RobotoRegular;
        for (TextView textView : textViews) {
            if (textView != null) {
                textView.setTextAppearance(context, i);
            }
        }
    }

    @JvmStatic
    public static final void setTypeFace(@Nullable Context context, @Nullable FontName name, @NotNull TextView... textViews) {
        Intrinsics.checkNotNullParameter(textViews, "textViews");
        INSTANCE.setTextAppearance(context, name, (TextView[]) Arrays.copyOf(textViews, textViews.length));
    }
}
