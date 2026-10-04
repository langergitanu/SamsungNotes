package com.samsung.android.support.senl.p148nt.base.common.util;

import android.content.Context;
import android.os.Build;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.BulletSpan;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.widget.TextView;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.textspan.SpenBackgroundColorSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenBoldSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenBulletParagraph;
import com.samsung.android.sdk.pen.document.textspan.SpenFontSizeSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenForegroundColorSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenItalicSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenStrikethroughSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenTextParagraphBase;
import com.samsung.android.sdk.pen.document.textspan.SpenTextSpanBase;
import com.samsung.android.sdk.pen.document.textspan.SpenUnderlineSpan;
import com.samsung.android.support.senl.p145cm.base.framework.content.PackageManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.provider.SettingsCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011H\u0007J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0007J\u0012\u0010\u001b\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\u0012\u0010\u001e\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\u0012\u0010\u001f\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\u001d\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010!2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002¢\u0006\u0002\u0010\"J\u0018\u0010#\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\tH\u0002J\u0018\u0010%\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u000eH\u0002J\u001d\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010!2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002¢\u0006\u0002\u0010\"J$\u0010(\u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020\u000eH\u0007J$\u0010,\u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020\u000eH\u0007J$\u0010-\u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020\u000eH\u0007J,\u0010.\u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\tH\u0002J)\u00100\u001a\u00020\u00052\b\u00101\u001a\u0004\u0018\u00010\u00052\u0010\u00102\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010!H\u0007¢\u0006\u0002\u00103J\u0018\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000207H\u0007J\u0010\u00109\u001a\u0002052\b\u0010:\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\t0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/CharUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "SETTINGS_PACKAGE", "SDOCX_CRLF_REGEX", "mSmallFontIndex", "", "mMediumFontIndex", "mLargeFontIndex", "mFontScales", "", "", "mFontIndex", "fromHtml", "Landroid/text/Spanned;", "string", "toHtml", "spanned", "convertSpannablerToSpen", "", "spannableSB", "Landroid/text/SpannableStringBuilder;", "dest", "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox;", "getSmallFontIndex", "context", "Landroid/content/Context;", "getMediumFontIndex", "getLargeFontIndex", "getSystemFontIndex", "", "(Landroid/content/Context;)[Ljava/lang/String;", "getFontScale", "index", "getFontIndex", "fontScale", "getSystemFontScale", "applyTextSizeUntilSmallSize", "textView", "Landroid/widget/TextView;", "fontSize", "applyTextSizeUntilMediumSize", "applyTextSizeUntilLargeSize", "applyTextSizeUntilSpecificSize", "specificSize", "arrayJoin", "glue", "array", "(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;", "isValidByteSymbol", "", "result", "", "source", "isDouble", "text", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nCharUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CharUtils.kt\ncom/samsung/android/support/senl/nt/base/common/util/CharUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,317:1\n1#2:318\n*E\n"})
public final class CharUtils {

    @NotNull
    public static final String SDOCX_CRLF_REGEX = "\\r|\\n";

    @NotNull
    private static final String SETTINGS_PACKAGE = "com.android.settings";

    @NotNull
    private static final String TAG = "CharUtils";

    @NotNull
    public static final CharUtils INSTANCE = new CharUtils();
    private static int mSmallFontIndex = -1;
    private static int mMediumFontIndex = -1;
    private static int mLargeFontIndex = -1;

    @NotNull
    private static final Map<Integer, Float> mFontScales = new HashMap();

    @NotNull
    private static final Map<Float, Integer> mFontIndex = new HashMap();

    private CharUtils() {
    }

    @JvmStatic
    public static final void applyTextSizeUntilLargeSize(@Nullable Context context, @Nullable TextView textView, float fontSize) {
        CharUtils charUtils = INSTANCE;
        charUtils.applyTextSizeUntilSpecificSize(context, textView, fontSize, charUtils.getLargeFontIndex(context));
    }

    @JvmStatic
    public static final void applyTextSizeUntilMediumSize(@Nullable Context context, @Nullable TextView textView, float fontSize) {
        CharUtils charUtils = INSTANCE;
        charUtils.applyTextSizeUntilSpecificSize(context, textView, fontSize, charUtils.getMediumFontIndex(context));
    }

    @JvmStatic
    public static final void applyTextSizeUntilSmallSize(@Nullable Context context, @Nullable TextView textView, float fontSize) {
        CharUtils charUtils = INSTANCE;
        charUtils.applyTextSizeUntilSpecificSize(context, textView, fontSize, charUtils.getSmallFontIndex(context));
    }

    private final void applyTextSizeUntilSpecificSize(Context context, TextView textView, float fontSize, int specificSize) {
        if (context == null || textView == null) {
            return;
        }
        if (DeviceInfo.isOtherCorpDevice()) {
            textView.setTextSize(2, fontSize);
            return;
        }
        DesktopModeCompat.Companion companion = DesktopModeCompat.INSTANCE;
        if ((companion.getInstance().isDexMode(context) ? getFontIndex(context, companion.getInstance().getDexFontScale(context, 0.0f)) : SettingsCompat.INSTANCE.getInstance().getGlobalFontSize(context)) <= specificSize) {
            textView.setTextSize(2, fontSize);
        } else {
            textView.setTextSize(0, fontSize * getFontScale(context, specificSize) * context.getResources().getDisplayMetrics().density);
        }
    }

    @JvmStatic
    @NotNull
    public static final String arrayJoin(@Nullable String glue, @Nullable String[] array) {
        if (array == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = array.length;
        for (int i = 0; i < length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(glue);
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @JvmStatic
    public static final void convertSpannablerToSpen(@NotNull SpannableStringBuilder spannableSB, @NotNull SpenObjectTextBox dest) {
        Intrinsics.checkNotNullParameter(spannableSB, "spannableSB");
        Intrinsics.checkNotNullParameter(dest, "dest");
        ArrayList<SpenTextSpanBase> textSpan = dest.getTextSpan() != null ? dest.getTextSpan() : new ArrayList<>();
        int iMin = (int) Math.min(spannableSB.length(), dest.getTextLimit());
        int i = 0;
        while (i < iMin) {
            int iNextSpanTransition = spannableSB.nextSpanTransition(i, spannableSB.length(), CharacterStyle.class);
            if (iMin < iNextSpanTransition) {
                iNextSpanTransition = iMin;
            }
            Iterator it = ArrayIteratorKt.iterator((CharacterStyle[]) spannableSB.getSpans(i, iNextSpanTransition, CharacterStyle.class));
            while (it.hasNext()) {
                CharacterStyle characterStyle = (CharacterStyle) it.next();
                if (characterStyle instanceof StrikethroughSpan) {
                    SpenStrikethroughSpan spenStrikethroughSpan = new SpenStrikethroughSpan(i, iNextSpanTransition, 2, true);
                    if (textSpan != null) {
                        textSpan.add(spenStrikethroughSpan);
                    }
                } else if (characterStyle instanceof UnderlineSpan) {
                    SpenUnderlineSpan spenUnderlineSpan = new SpenUnderlineSpan(i, iNextSpanTransition, 2, true);
                    if (textSpan != null) {
                        textSpan.add(spenUnderlineSpan);
                    }
                } else if (characterStyle instanceof ForegroundColorSpan) {
                    SpenForegroundColorSpan spenForegroundColorSpan = new SpenForegroundColorSpan(i, iNextSpanTransition, 2, ((ForegroundColorSpan) characterStyle).getForegroundColor());
                    if (textSpan != null) {
                        textSpan.add(spenForegroundColorSpan);
                    }
                } else if (characterStyle instanceof BackgroundColorSpan) {
                    SpenBackgroundColorSpan spenBackgroundColorSpan = new SpenBackgroundColorSpan(i, iNextSpanTransition, 2, ((BackgroundColorSpan) characterStyle).getBackgroundColor());
                    if (textSpan != null) {
                        textSpan.add(spenBackgroundColorSpan);
                    }
                } else if (characterStyle instanceof AbsoluteSizeSpan) {
                    SpenFontSizeSpan spenFontSizeSpan = new SpenFontSizeSpan(i, iNextSpanTransition, 2, ((AbsoluteSizeSpan) characterStyle).getSize());
                    if (textSpan != null) {
                        textSpan.add(spenFontSizeSpan);
                    }
                } else if (characterStyle instanceof RelativeSizeSpan) {
                    SpenFontSizeSpan spenFontSizeSpan2 = new SpenFontSizeSpan(i, iNextSpanTransition, 2, dest.getFontSize() * ((RelativeSizeSpan) characterStyle).getSizeChange());
                    if (textSpan != null) {
                        textSpan.add(spenFontSizeSpan2);
                    }
                } else if (characterStyle instanceof StyleSpan) {
                    int style = ((StyleSpan) characterStyle).getStyle();
                    if ((style & 1) != 0) {
                        SpenBoldSpan spenBoldSpan = new SpenBoldSpan(i, iNextSpanTransition, 2, true);
                        if (textSpan != null) {
                            textSpan.add(spenBoldSpan);
                        }
                    }
                    if ((style & 2) != 0) {
                        SpenItalicSpan spenItalicSpan = new SpenItalicSpan(i, iNextSpanTransition, 2, true);
                        if (textSpan != null) {
                            textSpan.add(spenItalicSpan);
                        }
                    }
                } else {
                    Logger.m8702i(TAG, "convertSpannablerToSpen#CharacterStyle It is not supported. " + characterStyle);
                }
            }
            i = iNextSpanTransition;
        }
        dest.setTextSpan(textSpan);
        ArrayList<SpenTextParagraphBase> textParagraph = dest.getTextParagraph() != null ? dest.getTextParagraph() : new ArrayList<>();
        Iterator it2 = ArrayIteratorKt.iterator((BulletSpan[]) spannableSB.getSpans(0, spannableSB.length(), BulletSpan.class));
        while (it2.hasNext()) {
            BulletSpan bulletSpan = (BulletSpan) it2.next();
            String string = spannableSB.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            String strSubstring = string.substring(0, spannableSB.getSpanStart(bulletSpan));
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            int length = strSubstring.length() - StringsKt.m14139M(strSubstring, "\n", "").length();
            SpenBulletParagraph spenBulletParagraph = new SpenBulletParagraph(length, length + 1, 8);
            if (textParagraph != null) {
                textParagraph.add(spenBulletParagraph);
            }
        }
        dest.setTextParagraph(textParagraph);
    }

    @JvmStatic
    @NotNull
    public static final Spanned fromHtml(@Nullable String string) {
        Spanned spannedFromHtml = Html.fromHtml(string, 63);
        Intrinsics.checkNotNullExpressionValue(spannedFromHtml, "fromHtml(...)");
        return spannedFromHtml;
    }

    private final int getFontIndex(Context context, float fontScale) {
        Float fValueOf = Float.valueOf(1.0f);
        if (mFontIndex.isEmpty()) {
            String[] systemFontScale = getSystemFontScale(context);
            IntRange indices = systemFontScale != null ? ArraysKt.getIndices(systemFontScale) : null;
            Intrinsics.checkNotNull(indices);
            int first = indices.getFirst();
            int last = indices.getLast();
            if (first <= last) {
                while (true) {
                    mFontIndex.put(Float.valueOf(Float.parseFloat(systemFontScale[first])), Integer.valueOf(first));
                    if (first == last) {
                        break;
                    }
                    first++;
                }
            }
        }
        Map<Float, Integer> map = mFontIndex;
        if (map.containsKey(Float.valueOf(fontScale))) {
            Integer num = map.get(Float.valueOf(fontScale));
            Intrinsics.checkNotNull(num);
            return num.intValue();
        }
        if (!map.containsKey(fValueOf)) {
            return 0;
        }
        Integer num2 = map.get(fValueOf);
        Intrinsics.checkNotNull(num2);
        return num2.intValue();
    }

    private final float getFontScale(Context context, int index) {
        Map<Integer, Float> map = mFontScales;
        if (!map.containsKey(Integer.valueOf(index))) {
            String[] systemFontScale = getSystemFontScale(context);
            if (systemFontScale != null) {
                if (index >= systemFontScale.length) {
                    index = systemFontScale.length - 1;
                }
                map.put(Integer.valueOf(index), Float.valueOf(Float.parseFloat(systemFontScale[index])));
            } else {
                map.put(Integer.valueOf(index), Float.valueOf(1.0f));
            }
        }
        Float f = map.get(Integer.valueOf(index));
        if (f != null) {
            return f.floatValue();
        }
        map.remove(Integer.valueOf(index));
        return 1.0f;
    }

    private final int getLargeFontIndex(Context context) {
        int i = mLargeFontIndex;
        if (i > -1) {
            return i;
        }
        String[] systemFontIndex = context != null ? INSTANCE.getSystemFontIndex(context) : null;
        String str = Build.VERSION.SDK_INT < 28 ? "Large" : "1.3";
        if (systemFontIndex != null) {
            int length = systemFontIndex.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (Intrinsics.areEqual(str, systemFontIndex[i2])) {
                    mLargeFontIndex = i2;
                    return i2;
                }
            }
        }
        mLargeFontIndex = 4;
        return 4;
    }

    private final int getMediumFontIndex(Context context) {
        int i = mMediumFontIndex;
        if (i > -1) {
            return i;
        }
        String[] systemFontIndex = context != null ? INSTANCE.getSystemFontIndex(context) : null;
        String str = Build.VERSION.SDK_INT < 28 ? "Medium" : "1.1";
        if (systemFontIndex != null) {
            int length = systemFontIndex.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (Intrinsics.areEqual(str, systemFontIndex[i2])) {
                    mMediumFontIndex = i2;
                    return i2;
                }
            }
        }
        mMediumFontIndex = 3;
        return 3;
    }

    private final int getSmallFontIndex(Context context) {
        int i = mSmallFontIndex;
        if (i > -1) {
            return i;
        }
        String[] systemFontIndex = context != null ? INSTANCE.getSystemFontIndex(context) : null;
        String str = Build.VERSION.SDK_INT < 28 ? "Small" : "1.0";
        if (systemFontIndex != null) {
            int length = systemFontIndex.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (Intrinsics.areEqual(str, systemFontIndex[i2])) {
                    mSmallFontIndex = i2;
                    return i2;
                }
            }
        }
        mSmallFontIndex = 2;
        return 2;
    }

    private final String[] getSystemFontIndex(Context context) {
        return DeviceInfo.isVSTModel() ? PackageManagerCompat.INSTANCE.getInstance().getStringArrayFromPackage(context, SETTINGS_PACKAGE, "sec_entryvalues_font_size_for_vst") : Build.VERSION.SDK_INT < 28 ? PackageManagerCompat.INSTANCE.getInstance().getStringArrayFromPackage(context, SETTINGS_PACKAGE, "entry_7_step_font_size") : PackageManagerCompat.INSTANCE.getInstance().getStringArrayFromPackage(context, SETTINGS_PACKAGE, "sec_entryvalues_8_step_font_size");
    }

    private final String[] getSystemFontScale(Context context) {
        return DeviceInfo.isVSTModel() ? PackageManagerCompat.INSTANCE.getInstance().getStringArrayFromPackage(context, SETTINGS_PACKAGE, "sec_entryvalues_font_size_for_vst") : Build.VERSION.SDK_INT < 28 ? PackageManagerCompat.INSTANCE.getInstance().getStringArrayFromPackage(context, SETTINGS_PACKAGE, "entryvalues_7_step_font_size") : PackageManagerCompat.INSTANCE.getInstance().getStringArrayFromPackage(context, SETTINGS_PACKAGE, "sec_entryvalues_8_step_font_size");
    }

    @JvmStatic
    public static final boolean isValidByteSymbol(@NotNull CharSequence result, @NotNull CharSequence source) {
        char cCharAt;
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(source, "source");
        return result.length() <= 0 || !((cCharAt = source.charAt(result.length() - 1)) == 9770 || cCharAt == 10013);
    }

    @JvmStatic
    @NotNull
    public static final String toHtml(@Nullable Spanned spanned) {
        String html = Html.toHtml(spanned, 0);
        Intrinsics.checkNotNullExpressionValue(html, "toHtml(...)");
        return html;
    }

    public final boolean isDouble(@Nullable String text) {
        return (text != null ? StringsKt.toDoubleOrNull(text) : null) != null;
    }
}
