package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.layout.AbstractC1038a;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, m13886d2 = {"DefaultWidthCharCount", "", "EmptyTextReplacement", "", "TwoLineTextReplacement", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class MinLinesConstrainerKt {
    private static final int DefaultWidthCharCount = 10;

    @NotNull
    private static final String EmptyTextReplacement;

    @NotNull
    private static final String TwoLineTextReplacement;

    static {
        String strRepeat = StringsKt__StringsJVMKt.repeat("H", 10);
        EmptyTextReplacement = strRepeat;
        TwoLineTextReplacement = AbstractC1038a.m1212m('\n', strRepeat, strRepeat);
    }
}
