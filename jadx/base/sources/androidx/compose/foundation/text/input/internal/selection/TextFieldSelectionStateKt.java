package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.p109ui.text.TextRange;
import androidx.compose.p109ui.text.TextRangeKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0002\u001a\u0016\u0010\b\u001a\u00020\t*\u00020\tH\u0002ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\f"}, m13886d2 = {"DEBUG", "", "DEBUG_TAG", "", "logDebug", "", "text", "Lkotlin/Function0;", "reverse", "Landroidx/compose/ui/text/TextRange;", "reverse-5zc-tL8", "(J)J", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class TextFieldSelectionStateKt {
    private static final boolean DEBUG = false;

    @NotNull
    private static final String DEBUG_TAG = "TextFieldSelectionState";

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: reverse-5zc-tL8, reason: not valid java name */
    public static final long m16453reverse5zctL8(long j) {
        return TextRangeKt.TextRange(TextRange.m20451getEndimpl(j), TextRange.m20456getStartimpl(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void logDebug(Function0<String> function0) {
    }
}
