package androidx.compose.p109ui.text.font;

import android.graphics.Typeface;
import android.os.Build;
import androidx.compose.p109ui.text.font.FontWeight;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a6\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\f"}, m13886d2 = {"synthesizeTypeface", "", "Landroidx/compose/ui/text/font/FontSynthesis;", "typeface", "font", "Landroidx/compose/ui/text/font/Font;", "requestedWeight", "Landroidx/compose/ui/text/font/FontWeight;", "requestedStyle", "Landroidx/compose/ui/text/font/FontStyle;", "synthesizeTypeface-FxwP2eA", "(ILjava/lang/Object;Landroidx/compose/ui/text/font/Font;Landroidx/compose/ui/text/font/FontWeight;I)Ljava/lang/Object;", "ui-text_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class FontSynthesis_androidKt {
    /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
    @NotNull
    /* JADX INFO: renamed from: synthesizeTypeface-FxwP2eA, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m20586synthesizeTypefaceFxwP2eA(int i, @NotNull Object obj, @NotNull Font font, @NotNull FontWeight fontWeight, int i2) {
        boolean z;
        if (!(obj instanceof Typeface)) {
            return obj;
        }
        boolean z2 = false;
        if (!FontSynthesis.m20579isWeightOnimpl$ui_text_release(i) || Intrinsics.areEqual(font.getWeight(), fontWeight)) {
            z = false;
        } else {
            FontWeight.Companion companion = FontWeight.INSTANCE;
            if (fontWeight.compareTo(AndroidFontUtils_androidKt.getAndroidBold(companion)) >= 0 && font.getWeight().compareTo(AndroidFontUtils_androidKt.getAndroidBold(companion)) < 0) {
                z = true;
            }
        }
        boolean z3 = FontSynthesis.m20578isStyleOnimpl$ui_text_release(i) && !FontStyle.m20565equalsimpl0(i2, font.getStyle());
        if (!z3 && !z) {
            return obj;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            return TypefaceHelperMethodsApi28.INSTANCE.create((Typeface) obj, z ? fontWeight.getWeight() : font.getWeight().getWeight(), z3 ? FontStyle.m20565equalsimpl0(i2, FontStyle.INSTANCE.m20571getItalic_LCdwA()) : FontStyle.m20565equalsimpl0(font.getStyle(), FontStyle.INSTANCE.m20571getItalic_LCdwA()));
        }
        if (z3 && FontStyle.m20565equalsimpl0(i2, FontStyle.INSTANCE.m20571getItalic_LCdwA())) {
            z2 = true;
        }
        return Typeface.create((Typeface) obj, AndroidFontUtils_androidKt.getAndroidTypefaceStyle(z, z2));
    }
}
