package androidx.compose.foundation.text.input;

import androidx.compose.p109ui.text.TextRange;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u0014\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0007"}, m13886d2 = {"getSelectedText", "", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "getTextAfterSelection", "maxChars", "", "getTextBeforeSelection", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class TextFieldCharSequenceKt {
    @NotNull
    public static final CharSequence getSelectedText(@NotNull TextFieldCharSequence textFieldCharSequence) {
        return textFieldCharSequence.subSequence(TextRange.m20454getMinimpl(textFieldCharSequence.getSelection()), TextRange.m20453getMaximpl(textFieldCharSequence.getSelection()));
    }

    @NotNull
    public static final CharSequence getTextAfterSelection(@NotNull TextFieldCharSequence textFieldCharSequence, int i) {
        return textFieldCharSequence.subSequence(TextRange.m20453getMaximpl(textFieldCharSequence.getSelection()), Math.min(TextRange.m20453getMaximpl(textFieldCharSequence.getSelection()) + i, textFieldCharSequence.length()));
    }

    @NotNull
    public static final CharSequence getTextBeforeSelection(@NotNull TextFieldCharSequence textFieldCharSequence, int i) {
        return textFieldCharSequence.subSequence(Math.max(0, TextRange.m20454getMinimpl(textFieldCharSequence.getSelection()) - i), TextRange.m20454getMinimpl(textFieldCharSequence.getSelection()));
    }
}
