package androidx.compose.p109ui.text.font;

import androidx.compose.p109ui.text.ExperimentalTextApi;
import androidx.compose.p109ui.text.font.FontVariation;
import androidx.compose.runtime.Stable;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a8\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001aB\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\f\u0010\u0012\u001a\u00020\u0013*\u00020\u0001H\u0007\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0014"}, m13886d2 = {"Font", "Landroidx/compose/ui/text/font/Font;", "resId", "", "weight", "Landroidx/compose/ui/text/font/FontWeight;", "style", "Landroidx/compose/ui/text/font/FontStyle;", "Font-RetOiIg", "(ILandroidx/compose/ui/text/font/FontWeight;I)Landroidx/compose/ui/text/font/Font;", "loadingStrategy", "Landroidx/compose/ui/text/font/FontLoadingStrategy;", "Font-YpTlLL0", "(ILandroidx/compose/ui/text/font/FontWeight;II)Landroidx/compose/ui/text/font/Font;", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "Font-F3nL8kk", "(ILandroidx/compose/ui/text/font/FontWeight;IILandroidx/compose/ui/text/font/FontVariation$Settings;)Landroidx/compose/ui/text/font/Font;", "toFontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "ui-text_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class FontKt {
    @ExperimentalTextApi
    @NotNull
    /* JADX INFO: renamed from: Font-F3nL8kk, reason: not valid java name */
    public static final Font m20543FontF3nL8kk(int i, @NotNull FontWeight fontWeight, int i2, int i4, @NotNull FontVariation.Settings settings) {
        return new ResourceFont(i, fontWeight, i2, settings, i4, null);
    }

    /* JADX INFO: renamed from: Font-F3nL8kk$default, reason: not valid java name */
    public static /* synthetic */ Font m20544FontF3nL8kk$default(int i, FontWeight fontWeight, int i2, int i4, FontVariation.Settings settings, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            fontWeight = FontWeight.INSTANCE.getNormal();
        }
        if ((i5 & 4) != 0) {
            i2 = FontStyle.INSTANCE.m20572getNormal_LCdwA();
        }
        if ((i5 & 8) != 0) {
            i4 = FontLoadingStrategy.INSTANCE.m20557getBlockingPKNRLFQ();
        }
        if ((i5 & 16) != 0) {
            settings = FontVariation.INSTANCE.m20587Settings6EWAqTQ(fontWeight, i2, new FontVariation.Setting[0]);
        }
        return m20543FontF3nL8kk(i, fontWeight, i2, i4, settings);
    }

    @Stable
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility until Compose 1.3.", replaceWith = @ReplaceWith(expression = "Font(resId, weight, style)", imports = {}))
    /* JADX INFO: renamed from: Font-RetOiIg, reason: not valid java name */
    public static final /* synthetic */ Font m20545FontRetOiIg(int i, FontWeight fontWeight, int i2) {
        return new ResourceFont(i, fontWeight, i2, null, FontLoadingStrategy.INSTANCE.m20557getBlockingPKNRLFQ(), 8, null);
    }

    /* JADX INFO: renamed from: Font-RetOiIg$default, reason: not valid java name */
    public static /* synthetic */ Font m20546FontRetOiIg$default(int i, FontWeight fontWeight, int i2, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            fontWeight = FontWeight.INSTANCE.getNormal();
        }
        if ((i4 & 4) != 0) {
            i2 = FontStyle.INSTANCE.m20572getNormal_LCdwA();
        }
        return m20545FontRetOiIg(i, fontWeight, i2);
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: Font-YpTlLL0, reason: not valid java name */
    public static final Font m20547FontYpTlLL0(int i, @NotNull FontWeight fontWeight, int i2, int i4) {
        return new ResourceFont(i, fontWeight, i2, new FontVariation.Settings(new FontVariation.Setting[0]), i4, null);
    }

    /* JADX INFO: renamed from: Font-YpTlLL0$default, reason: not valid java name */
    public static /* synthetic */ Font m20548FontYpTlLL0$default(int i, FontWeight fontWeight, int i2, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            fontWeight = FontWeight.INSTANCE.getNormal();
        }
        if ((i5 & 4) != 0) {
            i2 = FontStyle.INSTANCE.m20572getNormal_LCdwA();
        }
        if ((i5 & 8) != 0) {
            i4 = FontLoadingStrategy.INSTANCE.m20557getBlockingPKNRLFQ();
        }
        return m20547FontYpTlLL0(i, fontWeight, i2, i4);
    }

    @Stable
    @NotNull
    public static final FontFamily toFontFamily(@NotNull Font font) {
        return FontFamilyKt.FontFamily(font);
    }
}
