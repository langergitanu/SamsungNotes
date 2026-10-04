package androidx.compose.material3;

import androidx.compose.p109ui.text.PlatformTextStyle;
import androidx.compose.p109ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, m13886d2 = {"copyAndSetFontPadding", "Landroidx/compose/ui/text/TextStyle;", "style", "includeFontPadding", "", "material3_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class IncludeFontPaddingHelper_androidKt {
    @NotNull
    public static final TextStyle copyAndSetFontPadding(@NotNull TextStyle style, boolean z) {
        Intrinsics.checkNotNullParameter(style, "style");
        return TextStyle.m20466copyNOaFTUo$default(style, 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, null, 0L, null, new PlatformTextStyle(z), null, 786431, null);
    }
}
