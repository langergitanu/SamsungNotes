package androidx.compose.p109ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import androidx.compose.p109ui.text.font.FontVariation;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0016\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000bR\u001c\u0010\u0006\u001a\u00020\u0007X\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001d"}, m13886d2 = {"Landroidx/compose/ui/text/font/DeviceFontFamilyNameFont;", "Landroidx/compose/ui/text/font/AndroidFont;", "familyName", "Landroidx/compose/ui/text/font/DeviceFontFamilyName;", "weight", "Landroidx/compose/ui/text/font/FontWeight;", "style", "Landroidx/compose/ui/text/font/FontStyle;", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "(Ljava/lang/String;Landroidx/compose/ui/text/font/FontWeight;ILandroidx/compose/ui/text/font/FontVariation$Settings;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "Ljava/lang/String;", "getStyle-_-LCdwA", "()I", "I", "getWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "equals", "", "other", "", "hashCode", "", "loadCached", "Landroid/graphics/Typeface;", "context", "Landroid/content/Context;", "toString", "", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final class DeviceFontFamilyNameFont extends AndroidFont {

    @NotNull
    private final String familyName;
    private final int style;

    @NotNull
    private final FontWeight weight;

    public /* synthetic */ DeviceFontFamilyNameFont(String str, FontWeight fontWeight, int i, FontVariation.Settings settings, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, fontWeight, i, settings);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeviceFontFamilyNameFont)) {
            return false;
        }
        DeviceFontFamilyNameFont deviceFontFamilyNameFont = (DeviceFontFamilyNameFont) other;
        return DeviceFontFamilyName.m20533equalsimpl0(this.familyName, deviceFontFamilyNameFont.familyName) && Intrinsics.areEqual(getWeight(), deviceFontFamilyNameFont.getWeight()) && FontStyle.m20565equalsimpl0(getStyle(), deviceFontFamilyNameFont.getStyle()) && Intrinsics.areEqual(getVariationSettings(), deviceFontFamilyNameFont.getVariationSettings());
    }

    @Override // androidx.compose.p109ui.text.font.Font
    /* JADX INFO: renamed from: getStyle-_-LCdwA, reason: from getter */
    public int getStyle() {
        return this.style;
    }

    @Override // androidx.compose.p109ui.text.font.Font
    @NotNull
    public FontWeight getWeight() {
        return this.weight;
    }

    public int hashCode() {
        return getVariationSettings().hashCode() + ((FontStyle.m20566hashCodeimpl(getStyle()) + ((getWeight().hashCode() + (DeviceFontFamilyName.m20534hashCodeimpl(this.familyName) * 31)) * 31)) * 31);
    }

    @Nullable
    public final Typeface loadCached(@NotNull Context context) {
        return PlatformTypefaces_androidKt.PlatformTypefaces().mo20594optionalOnDeviceFontFamilyByName78DK7lM(this.familyName, getWeight(), getStyle(), getVariationSettings(), context);
    }

    @NotNull
    public String toString() {
        return "Font(familyName=\"" + ((Object) DeviceFontFamilyName.m20535toStringimpl(this.familyName)) + "\", weight=" + getWeight() + ", style=" + ((Object) FontStyle.m20567toStringimpl(getStyle())) + PropertyUtils.MAPPED_DELIM2;
    }

    private DeviceFontFamilyNameFont(String str, FontWeight fontWeight, int i, FontVariation.Settings settings) {
        super(FontLoadingStrategy.INSTANCE.m20558getOptionalLocalPKNRLFQ(), NamedFontLoader.INSTANCE, settings, null);
        this.familyName = str;
        this.weight = fontWeight;
        this.style = i;
    }
}
