package androidx.compose.p109ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.compose.p109ui.text.font.FontFamily;
import androidx.compose.p109ui.text.font.FontStyle;
import androidx.compose.p109ui.text.font.FontVariation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(28)
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\"\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ*\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J,\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\nH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\fJ<\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006!"}, m13886d2 = {"Landroidx/compose/ui/text/font/PlatformTypefacesApi28;", "Landroidx/compose/ui/text/font/PlatformTypefaces;", "()V", "createAndroidTypefaceApi28", "Landroid/graphics/Typeface;", "genericFontFamily", "", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "createAndroidTypefaceApi28-RetOiIg", "(Ljava/lang/String;Landroidx/compose/ui/text/font/FontWeight;I)Landroid/graphics/Typeface;", "createDefault", "createDefault-FO1MlWM", "(Landroidx/compose/ui/text/font/FontWeight;I)Landroid/graphics/Typeface;", "createNamed", "name", "Landroidx/compose/ui/text/font/GenericFontFamily;", "createNamed-RetOiIg", "(Landroidx/compose/ui/text/font/GenericFontFamily;Landroidx/compose/ui/text/font/FontWeight;I)Landroid/graphics/Typeface;", "loadNamedFromTypefaceCacheOrNull", "familyName", "weight", "style", "loadNamedFromTypefaceCacheOrNull-RetOiIg", "optionalOnDeviceFontFamilyByName", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "context", "Landroid/content/Context;", "optionalOnDeviceFontFamilyByName-78DK7lM", "(Ljava/lang/String;Landroidx/compose/ui/text/font/FontWeight;ILandroidx/compose/ui/text/font/FontVariation$Settings;Landroid/content/Context;)Landroid/graphics/Typeface;", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@VisibleForTesting
final class PlatformTypefacesApi28 implements PlatformTypefaces {
    /* JADX INFO: renamed from: createAndroidTypefaceApi28-RetOiIg, reason: not valid java name */
    private final Typeface m20598createAndroidTypefaceApi28RetOiIg(String genericFontFamily, FontWeight fontWeight, int fontStyle) {
        FontStyle.Companion companion = FontStyle.INSTANCE;
        if (FontStyle.m20565equalsimpl0(fontStyle, companion.m20572getNormal_LCdwA()) && Intrinsics.areEqual(fontWeight, FontWeight.INSTANCE.getNormal()) && (genericFontFamily == null || genericFontFamily.length() == 0)) {
            return Typeface.DEFAULT;
        }
        return Typeface.create(genericFontFamily == null ? Typeface.DEFAULT : Typeface.create(genericFontFamily, 0), fontWeight.getWeight(), FontStyle.m20565equalsimpl0(fontStyle, companion.m20571getItalic_LCdwA()));
    }

    /* JADX INFO: renamed from: createAndroidTypefaceApi28-RetOiIg$default, reason: not valid java name */
    public static /* synthetic */ Typeface m20599createAndroidTypefaceApi28RetOiIg$default(PlatformTypefacesApi28 platformTypefacesApi28, String str, FontWeight fontWeight, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        return platformTypefacesApi28.m20598createAndroidTypefaceApi28RetOiIg(str, fontWeight, i);
    }

    /* JADX INFO: renamed from: loadNamedFromTypefaceCacheOrNull-RetOiIg, reason: not valid java name */
    private final Typeface m20600loadNamedFromTypefaceCacheOrNullRetOiIg(String familyName, FontWeight weight, int style) {
        if (familyName.length() == 0) {
            return null;
        }
        Typeface typefaceM20598createAndroidTypefaceApi28RetOiIg = m20598createAndroidTypefaceApi28RetOiIg(familyName, weight, style);
        if (Intrinsics.areEqual(typefaceM20598createAndroidTypefaceApi28RetOiIg, TypefaceHelperMethodsApi28.INSTANCE.create(Typeface.DEFAULT, weight.getWeight(), FontStyle.m20565equalsimpl0(style, FontStyle.INSTANCE.m20571getItalic_LCdwA()))) || Intrinsics.areEqual(typefaceM20598createAndroidTypefaceApi28RetOiIg, m20598createAndroidTypefaceApi28RetOiIg(null, weight, style))) {
            return null;
        }
        return typefaceM20598createAndroidTypefaceApi28RetOiIg;
    }

    @Override // androidx.compose.p109ui.text.font.PlatformTypefaces
    @NotNull
    /* JADX INFO: renamed from: createDefault-FO1MlWM */
    public Typeface mo20592createDefaultFO1MlWM(@NotNull FontWeight fontWeight, int fontStyle) {
        return m20598createAndroidTypefaceApi28RetOiIg(null, fontWeight, fontStyle);
    }

    @Override // androidx.compose.p109ui.text.font.PlatformTypefaces
    @NotNull
    /* JADX INFO: renamed from: createNamed-RetOiIg */
    public Typeface mo20593createNamedRetOiIg(@NotNull GenericFontFamily name, @NotNull FontWeight fontWeight, int fontStyle) {
        return m20598createAndroidTypefaceApi28RetOiIg(name.getName(), fontWeight, fontStyle);
    }

    @Override // androidx.compose.p109ui.text.font.PlatformTypefaces
    @Nullable
    /* JADX INFO: renamed from: optionalOnDeviceFontFamilyByName-78DK7lM */
    public Typeface mo20594optionalOnDeviceFontFamilyByName78DK7lM(@NotNull String familyName, @NotNull FontWeight weight, int style, @NotNull FontVariation.Settings variationSettings, @NotNull Context context) {
        FontFamily.Companion companion = FontFamily.INSTANCE;
        return PlatformTypefaces_androidKt.setFontVariationSettings(Intrinsics.areEqual(familyName, companion.getSansSerif().getName()) ? mo20593createNamedRetOiIg(companion.getSansSerif(), weight, style) : Intrinsics.areEqual(familyName, companion.getSerif().getName()) ? mo20593createNamedRetOiIg(companion.getSerif(), weight, style) : Intrinsics.areEqual(familyName, companion.getMonospace().getName()) ? mo20593createNamedRetOiIg(companion.getMonospace(), weight, style) : Intrinsics.areEqual(familyName, companion.getCursive().getName()) ? mo20593createNamedRetOiIg(companion.getCursive(), weight, style) : m20600loadNamedFromTypefaceCacheOrNullRetOiIg(familyName, weight, style), variationSettings, context);
    }
}
