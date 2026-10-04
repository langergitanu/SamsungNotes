package androidx.glance.appwidget.translators;

import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.Layout;
import android.text.ParcelableSpan;
import android.text.SpannableString;
import android.text.style.AlignmentSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TextAppearanceSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.widget.RemoteViews;
import androidx.compose.p109ui.graphics.ColorKt;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.TextUnit;
import androidx.core.widget.RemoteViewsCompat;
import androidx.glance.appwidget.AppWidgetUtilsKt;
import androidx.glance.appwidget.ApplyModifiersKt;
import androidx.glance.appwidget.C2902R;
import androidx.glance.appwidget.InsertedViewInfo;
import androidx.glance.appwidget.LayoutSelectionKt;
import androidx.glance.appwidget.LayoutType;
import androidx.glance.appwidget.TranslationContext;
import androidx.glance.appwidget.UtilsKt;
import androidx.glance.appwidget.percent.PercentActionsKt;
import androidx.glance.appwidget.util.Constants;
import androidx.glance.appwidget.util.ReflectionsKt;
import androidx.glance.appwidget.util.RemoteViewsExtensionKt;
import androidx.glance.appwidget.util.RemoteViewsReflections;
import androidx.glance.color.DayNightColorProvider;
import androidx.glance.oneui.common.GlanceLog;
import androidx.glance.text.EmittableText;
import androidx.glance.text.FontFamily;
import androidx.glance.text.FontStyle;
import androidx.glance.text.FontWeight;
import androidx.glance.text.TextAlign;
import androidx.glance.text.TextCategory;
import androidx.glance.text.TextDecoration;
import androidx.glance.text.TextDirection;
import androidx.glance.text.TextPercentData;
import androidx.glance.text.TextShadowStyle;
import androidx.glance.text.TextStyle;
import androidx.glance.text.TextVerticalAlign;
import androidx.glance.unit.ColorProvider;
import androidx.glance.unit.FixedColorProvider;
import androidx.glance.unit.ResourceColorProvider;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import opennlp.tools.namefind.BilouCodec;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000f\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u001aV\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0003H\u0000\u001a\u001c\u0010\u0014\u001a\u00020\u0015*\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H\u0002\u001a(\u0010\u0019\u001a\u00020\u0015*\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0007H\u0002\u001a,\u0010\u001c\u001a\u00020\u0015*\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012H\u0002\u001a6\u0010 \u001a\u00020\u0015*\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0002\u001a\u001e\u0010#\u001a\u00020$*\u00020%2\u0006\u0010&\u001a\u00020'H\u0002ø\u0001\u0000¢\u0006\u0004\b(\u0010)\u001a\u0016\u0010*\u001a\u00020\u0003*\u00020%H\u0002ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a\u001c\u0010-\u001a\u00020\u0015*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010.\u001a\u00020/H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00060"}, m13886d2 = {SearchConstants.TargetContents.TAG, "", "getProperFontFamilyWhenSemiBold", "", "family", "Landroidx/glance/text/FontFamily;", "setText", "Landroid/os/Bundle;", "Landroid/widget/RemoteViews;", "translationContext", "Landroidx/glance/appwidget/TranslationContext;", "resId", "text", "style", "Landroidx/glance/text/TextStyle;", "maxLines", "verticalTextGravity", "maxFontScale", "", "textResId", "setTextViewShadow", "", "viewId", "textShadowStyle", "Landroidx/glance/text/TextShadowStyle;", "setTextViewTextResource", "strResId", "bundle", "setTextViewTextSize", "res", "Landroid/content/res/Resources;", "textSize", "setTextViewTextSizeResource", BilouCodec.UNIT, "textSizeResId", "toAlignment", "Landroid/text/Layout$Alignment;", "Landroidx/glance/text/TextAlign;", "isRtl", "", "toAlignment-Gxb6ijs", "(IZ)Landroid/text/Layout$Alignment;", "toGravity", "toGravity-b1p-sNo", "(I)I", "translateEmittableText", "element", "Landroidx/glance/text/EmittableText;", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTextTranslator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextTranslator.kt\nandroidx/glance/appwidget/translators/TextTranslatorKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,505:1\n174#2:506\n174#2:507\n1855#3,2:508\n*S KotlinDebug\n*F\n+ 1 TextTranslator.kt\nandroidx/glance/appwidget/translators/TextTranslatorKt\n*L\n192#1:506\n193#1:507\n301#1:508,2\n*E\n"})
public final class TextTranslatorKt {

    @NotNull
    private static final String TAG = "GWT:TextTranslator";

    public static final int getProperFontFamilyWhenSemiBold(@Nullable FontFamily fontFamily) {
        FontFamily.Companion companion = FontFamily.INSTANCE;
        return Intrinsics.areEqual(fontFamily, companion.getSecNumFixed()) ? C2902R.style.Glance_AppWidget_TextAppearance_SemiBoldNumFixed : Intrinsics.areEqual(fontFamily, companion.getSecNum()) ? C2902R.style.Glance_AppWidget_TextAppearance_SemiBoldNum : C2902R.style.Glance_AppWidget_TextAppearance_SemiBold;
    }

    @Nullable
    public static final Bundle setText(@NotNull RemoteViews remoteViews, @NotNull TranslationContext translationContext, int i, @NotNull String text, @Nullable TextStyle textStyle, int i2, int i4, float f, int i5) throws Throwable {
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        Intrinsics.checkNotNullParameter(translationContext, "translationContext");
        Intrinsics.checkNotNullParameter(text, "text");
        if (i2 != Integer.MAX_VALUE) {
            RemoteViewsCompat.setTextViewMaxLines(remoteViews, i, i2);
        }
        if (textStyle == null) {
            if (i5 == 0) {
                RemoteViewsCompat.setTextViewText(remoteViews, i, i5);
                return null;
            }
            remoteViews.setTextViewText(i, text);
            return null;
        }
        Bundle bundle = new Bundle();
        TextUnit fontSize = textStyle.getFontSize();
        if (fontSize != null) {
            long packedValue = fontSize.getPackedValue();
            if (!TextUnit.m21164isSpimpl(packedValue)) {
                throw new IllegalArgumentException("Only Sp is currently supported for font sizes");
            }
            if (textStyle.getTextSizeDimenResource() != 0) {
                Resources resources = translationContext.getContext().getResources();
                Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
                setTextViewTextSizeResource(remoteViews, resources, i, textStyle.getComplexUnit().getValue(), textStyle.getTextSizeDimenResource(), f);
            } else if (textStyle.getComplexUnit().getValue() == 2) {
                Resources resources2 = translationContext.getContext().getResources();
                Intrinsics.checkNotNullExpressionValue(resources2, "getResources(...)");
                setTextViewTextSize(remoteViews, resources2, i, TextUnit.m21161getValueimpl(packedValue), f);
            } else {
                remoteViews.setTextViewTextSize(i, 1, TextUnit.m21161getValueimpl(packedValue));
            }
        }
        TextPercentData percentData = textStyle.getPercentData();
        if (percentData != null) {
            PercentActionsKt.setViewTextPercent(remoteViews, i, percentData.getHeightPercent(), percentData.getWidthPercent(), text, percentData.getMinSize(), percentData.getMaxSize());
            TextCategory textCategory = percentData.getTextCategory();
            if (textCategory != null) {
                float currentDensity = translationContext.getDensity() == -1.0f ? AppWidgetUtilsKt.getCurrentDensity(translationContext.getAppWidgetId(), translationContext.getContext()) : translationContext.getDensity();
                PercentActionsKt.setAutoSizeTextTypeUniformWithConfiguration(remoteViews, i, UtilsKt.m21327toPixelsD5KLDUw(C2256Dp.m20968constructorimpl(textCategory.getMinSize()), currentDensity), UtilsKt.m21327toPixelsD5KLDUw(C2256Dp.m20968constructorimpl(textCategory.getMaxSize()), currentDensity), 1, 0);
            }
        }
        ArrayList arrayList = new ArrayList();
        TextDecoration textDecoration = textStyle.getTextDecoration();
        if (textDecoration != null) {
            int mask = textDecoration.getMask();
            TextDecoration.Companion companion = TextDecoration.INSTANCE;
            if (TextDecoration.m22014containshcOHJN8(mask, companion.m22022getLineThroughObZ5V_A())) {
                arrayList.add(new StrikethroughSpan());
                bundle.putBoolean("StrikethroughSpan", true);
            }
            if (TextDecoration.m22014containshcOHJN8(mask, companion.m22024getUnderlineObZ5V_A())) {
                arrayList.add(new UnderlineSpan());
                bundle.putBoolean("UnderlineSpan", true);
            }
        }
        FontStyle fontStyle = textStyle.getFontStyle();
        if (fontStyle != null) {
            int i6 = FontStyle.m21983equalsimpl0(fontStyle.getStyle(), FontStyle.INSTANCE.m21987getItaliczT8OX4g()) ? 2 : 0;
            arrayList.add(new StyleSpan(i6));
            bundle.putInt("StyleSpan", i6);
        }
        FontFamily fontFamily = textStyle.getFontFamily();
        if (fontFamily != null) {
            arrayList.add(new TypefaceSpan(fontFamily.getFamily()));
            bundle.putString("TypefaceSpan", fontFamily.getFamily());
        }
        FontWeight fontWeight = textStyle.getFontWeight();
        if (fontWeight != null) {
            int iM21995unboximpl = fontWeight.m21995unboximpl();
            FontWeight.Companion companion2 = FontWeight.INSTANCE;
            int properFontFamilyWhenSemiBold = FontWeight.m21992equalsimpl0(iM21995unboximpl, companion2.m21996getBoldWjrlUT0()) ? C2902R.style.Glance_AppWidget_TextAppearance_Bold : FontWeight.m21992equalsimpl0(iM21995unboximpl, companion2.m21999getSemiBoldWjrlUT0()) ? getProperFontFamilyWhenSemiBold(textStyle.getFontFamily()) : FontWeight.m21992equalsimpl0(iM21995unboximpl, companion2.m21997getMediumWjrlUT0()) ? C2902R.style.Glance_AppWidget_TextAppearance_Medium : C2902R.style.Glance_AppWidget_TextAppearance_Normal;
            arrayList.add(new TextAppearanceSpan(translationContext.getContext(), properFontFamilyWhenSemiBold));
            bundle.putInt("TextAppearanceSpan", properFontFamilyWhenSemiBold);
        }
        TextAlign textAlign = textStyle.getTextAlign();
        if (textAlign != null) {
            int value = textAlign.getValue();
            if (Build.VERSION.SDK_INT >= 31) {
                TextTranslatorApi31Impl.INSTANCE.setTextViewGravity(remoteViews, i, m21401toGravityb1psNo(value) | i4);
            } else {
                arrayList.add(new AlignmentSpan.Standard(m21400toAlignmentGxb6ijs(value, translationContext.isRtl())));
            }
        }
        TextVerticalAlign textVerticalAlign = textStyle.getTextVerticalAlign();
        if (textVerticalAlign != null) {
            int value2 = textVerticalAlign.getValue();
            if (Build.VERSION.SDK_INT >= 31) {
                TextVerticalAlign.Companion companion3 = TextVerticalAlign.INSTANCE;
                int iM21401toGravityb1psNo = 48;
                if (!TextVerticalAlign.m22048equalsimpl0(value2, companion3.m22054getTopJ86Ipig())) {
                    if (TextVerticalAlign.m22048equalsimpl0(value2, companion3.m22053getCenterJ86Ipig())) {
                        iM21401toGravityb1psNo = 16;
                    } else if (TextVerticalAlign.m22048equalsimpl0(value2, companion3.m22052getBottomJ86Ipig())) {
                        iM21401toGravityb1psNo = 80;
                    }
                }
                TextAlign textAlign2 = textStyle.getTextAlign();
                if (textAlign2 != null) {
                    iM21401toGravityb1psNo |= m21401toGravityb1psNo(textAlign2.getValue());
                }
                TextTranslatorApi31Impl.INSTANCE.setTextViewGravity(remoteViews, i, iM21401toGravityb1psNo);
            }
        }
        if (textStyle.getTextAppearanceResource() != 0) {
            if (i5 != 0) {
                setTextViewTextResource$default(remoteViews, i, i5, null, 4, null);
            } else {
                remoteViews.setTextViewText(i, text);
            }
            RemoteViewsExtensionKt.setTextAppearanceStyle(remoteViews, i, textStyle.getTextAppearanceResource());
        } else if (i5 == 0 || !ReflectionsKt.isValidMethod(remoteViews, RemoteViewsReflections.SET_TEXT_VIEW_TEXT_RESOURCE_METHOD)) {
            SpannableString spannableString = new SpannableString(text);
            int length = spannableString.length();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                spannableString.setSpan((ParcelableSpan) it.next(), 0, length, 17);
            }
            remoteViews.setTextViewText(i, spannableString);
        } else {
            setTextViewTextResource(remoteViews, i, i5, bundle);
        }
        ColorProvider color = textStyle.getColor();
        if (color instanceof FixedColorProvider) {
            remoteViews.setTextColor(i, ColorKt.m18579toArgb8_81llA(((FixedColorProvider) color).m22060getColor0d7_KjU()));
        } else if (color instanceof ResourceColorProvider) {
            if (Build.VERSION.SDK_INT >= 31) {
                RemoteViewsCompat.setTextViewTextColorResource(remoteViews, i, ((ResourceColorProvider) color).getResId());
            } else {
                remoteViews.setTextColor(i, ColorKt.m18579toArgb8_81llA(color.mo21422getColorvNxB06k(translationContext.getContext())));
            }
        } else if (!(color instanceof DayNightColorProvider)) {
            GlanceLog.INSTANCE.m2305w(TAG, "Unexpected text color: " + color);
        } else if (Build.VERSION.SDK_INT >= 31) {
            DayNightColorProvider dayNightColorProvider = (DayNightColorProvider) color;
            RemoteViewsCompat.setTextViewTextColor(remoteViews, i, ColorKt.m18579toArgb8_81llA(dayNightColorProvider.m21424getDay0d7_KjU()), ColorKt.m18579toArgb8_81llA(dayNightColorProvider.m21425getNight0d7_KjU()));
        } else {
            remoteViews.setTextColor(i, ColorKt.m18579toArgb8_81llA(color.mo21422getColorvNxB06k(translationContext.getContext())));
        }
        if (Constants.INSTANCE.getVERSION_ONE_UI_7() && textStyle.getHasShadow()) {
            setTextViewShadow(remoteViews, i, textStyle.getTextShadowStyle());
        }
        return bundle;
    }

    public static /* synthetic */ Bundle setText$default(RemoteViews remoteViews, TranslationContext translationContext, int i, String str, TextStyle textStyle, int i2, int i4, float f, int i5, int i6, Object obj) {
        return setText(remoteViews, translationContext, i, str, textStyle, i2, (i6 & 32) != 0 ? 48 : i4, (i6 & 64) != 0 ? 0.0f : f, (i6 & 128) != 0 ? 0 : i5);
    }

    private static final void setTextViewShadow(RemoteViews remoteViews, int i, TextShadowStyle textShadowStyle) throws IllegalAccessException, InvocationTargetException {
        Method method;
        try {
            Method[] declaredMethods = remoteViews.getClass().getDeclaredMethods();
            Intrinsics.checkNotNullExpressionValue(declaredMethods, "getDeclaredMethods(...)");
            int length = declaredMethods.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    method = null;
                    break;
                }
                method = declaredMethods[i2];
                if (Intrinsics.areEqual(method.getName(), RemoteViewsReflections.SET_TEXT_VIEW_SHADOW_METHOD)) {
                    method.setAccessible(true);
                    break;
                }
                i2++;
            }
            if (method != null) {
                method.invoke(remoteViews, Integer.valueOf(i), Float.valueOf(textShadowStyle.getRadius()), Float.valueOf(textShadowStyle.getDx()), Float.valueOf(textShadowStyle.getDy()), Integer.valueOf(ColorKt.m18579toArgb8_81llA(textShadowStyle.getColor())));
            }
        } catch (NoSuchElementException unused) {
            GlanceLog.INSTANCE.m2305w(TAG, "hidden_semSetTextViewShadow isn't supported.");
        }
    }

    private static final void setTextViewTextResource(RemoteViews remoteViews, int i, int i2, Bundle bundle) throws IllegalAccessException, InvocationTargetException {
        Method method;
        try {
            Method[] declaredMethods = remoteViews.getClass().getDeclaredMethods();
            Intrinsics.checkNotNullExpressionValue(declaredMethods, "getDeclaredMethods(...)");
            int length = declaredMethods.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length) {
                    method = null;
                    break;
                }
                method = declaredMethods[i4];
                if (Intrinsics.areEqual(method.getName(), RemoteViewsReflections.SET_TEXT_VIEW_TEXT_RESOURCE_METHOD)) {
                    method.setAccessible(true);
                    break;
                }
                i4++;
            }
            if (method != null) {
                method.invoke(remoteViews, Integer.valueOf(i), Integer.valueOf(i2), bundle);
            }
        } catch (NoSuchElementException unused) {
            GlanceLog.INSTANCE.m2305w(TAG, "hidden_semSetTextViewTextResource isn't supported.");
        }
    }

    public static /* synthetic */ void setTextViewTextResource$default(RemoteViews remoteViews, int i, int i2, Bundle bundle, int i4, Object obj) throws IllegalAccessException, InvocationTargetException {
        if ((i4 & 4) != 0) {
            bundle = null;
        }
        setTextViewTextResource(remoteViews, i, i2, bundle);
    }

    private static final void setTextViewTextSize(RemoteViews remoteViews, Resources resources, int i, float f, float f4) throws Throwable {
        Method method;
        Throwable th;
        Method method2 = null;
        try {
            if (f4 != 0.0f) {
                try {
                    Method[] declaredMethods = remoteViews.getClass().getDeclaredMethods();
                    Intrinsics.checkNotNullExpressionValue(declaredMethods, "getDeclaredMethods(...)");
                    int length = declaredMethods.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            method = null;
                            break;
                        }
                        method = declaredMethods[i2];
                        if (Intrinsics.areEqual(method.getName(), RemoteViewsReflections.SET_TEXT_VIEW_TEXT_SIZE_METHOD)) {
                            method.setAccessible(true);
                            break;
                        }
                        try {
                            i2++;
                        } catch (Throwable th2) {
                            th = th2;
                            if (method == null) {
                                if (f4 == 0.0f || resources.getConfiguration().fontScale <= f4) {
                                    remoteViews.setTextViewTextSize(i, 2, f);
                                } else {
                                    remoteViews.setTextViewTextSize(i, 1, f * f4);
                                }
                            }
                            throw th;
                        }
                    }
                    if (method != null) {
                        method.invoke(remoteViews, Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f4));
                    }
                    method2 = method;
                } catch (NoSuchElementException unused) {
                    GlanceLog.INSTANCE.m2305w(TAG, "hidden_semSetTextViewTextSize isn't supported.");
                    if (f4 != 0.0f && resources.getConfiguration().fontScale > f4) {
                        remoteViews.setTextViewTextSize(i, 1, f * f4);
                        return;
                    } else {
                        remoteViews.setTextViewTextSize(i, 2, f);
                        return;
                    }
                }
            }
            if (method2 == null) {
                if (f4 != 0.0f && resources.getConfiguration().fontScale > f4) {
                    remoteViews.setTextViewTextSize(i, 1, f * f4);
                } else {
                    remoteViews.setTextViewTextSize(i, 2, f);
                }
            }
        } catch (Throwable th3) {
            method = null;
            th = th3;
        }
    }

    private static final void setTextViewTextSizeResource(RemoteViews remoteViews, Resources resources, int i, int i2, int i4, float f) throws Throwable {
        Method method;
        Method method2 = null;
        try {
            try {
                Method[] declaredMethods = remoteViews.getClass().getDeclaredMethods();
                Intrinsics.checkNotNullExpressionValue(declaredMethods, "getDeclaredMethods(...)");
                int length = declaredMethods.length;
                int i5 = 0;
                while (true) {
                    if (i5 >= length) {
                        method = null;
                        break;
                    }
                    method = declaredMethods[i5];
                    if (Intrinsics.areEqual(method.getName(), RemoteViewsReflections.SET_TEXT_VIEW_TEXT_SIZE_RESOURCE_METHOD)) {
                        method.setAccessible(true);
                        break;
                    }
                    try {
                        i5++;
                    } catch (Throwable th) {
                        th = th;
                        method2 = method;
                        if (method2 == null) {
                            float f4 = Build.VERSION.SDK_INT >= 29 ? resources.getFloat(i4) : 14.0f;
                            if (i2 == 2) {
                                setTextViewTextSize(remoteViews, resources, i, f4, f);
                            } else {
                                remoteViews.setTextViewTextSize(i, 1, f4);
                            }
                        }
                        throw th;
                    }
                }
                if (method != null) {
                    method.invoke(remoteViews, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4), Float.valueOf(f));
                }
                if (method == null) {
                    float f5 = Build.VERSION.SDK_INT >= 29 ? resources.getFloat(i4) : 14.0f;
                    if (i2 == 2) {
                        setTextViewTextSize(remoteViews, resources, i, f5, f);
                    } else {
                        remoteViews.setTextViewTextSize(i, 1, f5);
                    }
                }
            } catch (NoSuchElementException unused) {
                GlanceLog.INSTANCE.m2305w(TAG, "hidden_semSetTextViewTextSizeResource isn't supported.");
                float f6 = Build.VERSION.SDK_INT >= 29 ? resources.getFloat(i4) : 14.0f;
                if (i2 == 2) {
                    setTextViewTextSize(remoteViews, resources, i, f6, f);
                } else {
                    remoteViews.setTextViewTextSize(i, 1, f6);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static /* synthetic */ void setTextViewTextSizeResource$default(RemoteViews remoteViews, Resources resources, int i, int i2, int i4, float f, int i5, Object obj) throws Throwable {
        if ((i5 & 16) != 0) {
            f = 0.0f;
        }
        setTextViewTextSizeResource(remoteViews, resources, i, i2, i4, f);
    }

    /* JADX INFO: renamed from: toAlignment-Gxb6ijs, reason: not valid java name */
    private static final Layout.Alignment m21400toAlignmentGxb6ijs(int i, boolean z) {
        TextAlign.Companion companion = TextAlign.INSTANCE;
        if (TextAlign.m22003equalsimpl0(i, companion.m22007getCenterROrN78o())) {
            return Layout.Alignment.ALIGN_CENTER;
        }
        if (TextAlign.m22003equalsimpl0(i, companion.m22009getLeftROrN78o())) {
            return z ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL;
        }
        if (TextAlign.m22003equalsimpl0(i, companion.m22010getRightROrN78o())) {
            return z ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_OPPOSITE;
        }
        if (TextAlign.m22003equalsimpl0(i, companion.m22011getStartROrN78o())) {
            return Layout.Alignment.ALIGN_NORMAL;
        }
        if (TextAlign.m22003equalsimpl0(i, companion.m22008getEndROrN78o())) {
            return Layout.Alignment.ALIGN_OPPOSITE;
        }
        GlanceLog.INSTANCE.m2305w(TAG, "Unknown TextAlign: " + TextAlign.m22005toStringimpl(i));
        return Layout.Alignment.ALIGN_NORMAL;
    }

    /* JADX INFO: renamed from: toGravity-b1p-sNo, reason: not valid java name */
    private static final int m21401toGravityb1psNo(int i) {
        TextAlign.Companion companion = TextAlign.INSTANCE;
        if (TextAlign.m22003equalsimpl0(i, companion.m22007getCenterROrN78o())) {
            return 1;
        }
        if (TextAlign.m22003equalsimpl0(i, companion.m22009getLeftROrN78o())) {
            return 3;
        }
        if (TextAlign.m22003equalsimpl0(i, companion.m22010getRightROrN78o())) {
            return 5;
        }
        if (TextAlign.m22003equalsimpl0(i, companion.m22011getStartROrN78o())) {
            return 8388611;
        }
        if (TextAlign.m22003equalsimpl0(i, companion.m22008getEndROrN78o())) {
            return 8388613;
        }
        GlanceLog.INSTANCE.m2305w(TAG, "Unknown TextAlign: " + TextAlign.m22005toStringimpl(i));
        return 8388611;
    }

    public static final void translateEmittableText(@NotNull RemoteViews remoteViews, @NotNull TranslationContext translationContext, @NotNull EmittableText element) {
        TextPercentData percentData;
        Intrinsics.checkNotNullParameter(remoteViews, "<this>");
        Intrinsics.checkNotNullParameter(translationContext, "translationContext");
        Intrinsics.checkNotNullParameter(element, "element");
        TextStyle style = element.getStyle();
        TextCategory textCategory = (style == null || (percentData = style.getPercentData()) == null) ? null : percentData.getTextCategory();
        TextCategory.Companion companion = TextCategory.INSTANCE;
        LayoutType layoutType = Intrinsics.areEqual(textCategory, companion.getDisplay()) ? LayoutType.TextDisplay : Intrinsics.areEqual(textCategory, companion.getTitle()) ? LayoutType.TextTitle : Intrinsics.areEqual(textCategory, companion.getBody()) ? LayoutType.TextBody : Intrinsics.areEqual(textCategory, companion.getDescription()) ? LayoutType.TextDescription : Intrinsics.areEqual(textCategory, companion.getLabel()) ? LayoutType.TextLabel : LayoutType.TextFirstStrong;
        TextStyle style2 = element.getStyle();
        if ((style2 != null ? style2.getPercentData() : null) == null) {
            TextStyle style3 = element.getStyle();
            TextDirection textDirectionM22025boximpl = style3 != null ? TextDirection.m22025boximpl(style3.getTextDirection()) : null;
            layoutType = textDirectionM22025boximpl == null ? false : TextDirection.m22028equalsimpl0(textDirectionM22025boximpl.getValue(), TextDirection.INSTANCE.m22034getLocaleyyWj0Bs()) ? LayoutType.Text : LayoutType.TextFirstStrong;
        }
        InsertedViewInfo insertedViewInfoInsertView = LayoutSelectionKt.insertView(remoteViews, translationContext, layoutType, element.getModifier());
        ApplyModifiersKt.applyModifiers(translationContext, remoteViews, element.getModifier(), insertedViewInfoInsertView, setText$default(remoteViews, translationContext, insertedViewInfoInsertView.getMainViewId(), element.getText(), element.getStyle(), element.getMaxLines(), 0, element.getMaxFontScale(), element.getTextResId(), 32, null));
    }
}
