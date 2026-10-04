package androidx.compose.p109ui.text.font;

import androidx.compose.runtime.Stable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a!\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006H\u0007¢\u0006\u0002\u0010\u0007\u001a\u0016\u0010\u0000\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0007¨\u0006\t"}, m13886d2 = {"FontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "typeface", "Landroidx/compose/ui/text/font/Typeface;", "fonts", "", "Landroidx/compose/ui/text/font/Font;", "([Landroidx/compose/ui/text/font/Font;)Landroidx/compose/ui/text/font/FontFamily;", "", "ui-text_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class FontFamilyKt {
    @Stable
    @NotNull
    public static final FontFamily FontFamily(@NotNull List<? extends Font> list) {
        return new FontListFontFamily(list);
    }

    @Stable
    @NotNull
    public static final FontFamily FontFamily(@NotNull Font... fontArr) {
        return new FontListFontFamily(ArraysKt.asList(fontArr));
    }

    @Stable
    @NotNull
    public static final FontFamily FontFamily(@NotNull Typeface typeface) {
        return new LoadedFontFamily(typeface);
    }
}
