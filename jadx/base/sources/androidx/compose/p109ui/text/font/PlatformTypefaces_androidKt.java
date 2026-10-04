package androidx.compose.p109ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.p109ui.text.ExperimentalTextApi;
import androidx.compose.p109ui.text.font.FontVariation;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0000\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0001\u001a \u0010\u0007\u001a\u0004\u0018\u00010\b*\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0001¨\u0006\r"}, m13886d2 = {"PlatformTypefaces", "Landroidx/compose/ui/text/font/PlatformTypefaces;", "getWeightSuffixForFallbackFamilyName", "", "name", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "setFontVariationSettings", "Landroid/graphics/Typeface;", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "context", "Landroid/content/Context;", "ui-text_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class PlatformTypefaces_androidKt {
    @NotNull
    public static final PlatformTypefaces PlatformTypefaces() {
        return Build.VERSION.SDK_INT >= 28 ? new PlatformTypefacesApi28() : new PlatformTypefacesApi();
    }

    @VisibleForTesting
    @NotNull
    public static final String getWeightSuffixForFallbackFamilyName(@NotNull String str, @NotNull FontWeight fontWeight) {
        int weight = fontWeight.getWeight() / 100;
        return (weight < 0 || weight >= 2) ? (2 > weight || weight >= 4) ? weight == 4 ? str : weight == 5 ? AbstractC0541b.m756B(str, "-medium") : ((6 > weight || weight >= 8) && 8 <= weight && weight < 11) ? AbstractC0541b.m756B(str, "-black") : str : AbstractC0541b.m756B(str, "-light") : AbstractC0541b.m756B(str, "-thin");
    }

    @ExperimentalTextApi
    @Nullable
    public static final Typeface setFontVariationSettings(@Nullable Typeface typeface, @NotNull FontVariation.Settings settings, @NotNull Context context) {
        return TypefaceCompatApi26.INSTANCE.setFontVariationSettings(typeface, settings, context);
    }
}
