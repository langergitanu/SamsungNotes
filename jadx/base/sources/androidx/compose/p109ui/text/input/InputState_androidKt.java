package androidx.compose.p109ui.text.input;

import android.view.inputmethod.ExtractedText;
import androidx.compose.p109ui.text.TextRange;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, m13886d2 = {"toExtractedText", "Landroid/view/inputmethod/ExtractedText;", "Landroidx/compose/ui/text/input/TextFieldValue;", "ui_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class InputState_androidKt {
    @NotNull
    public static final ExtractedText toExtractedText(@NotNull TextFieldValue textFieldValue) {
        ExtractedText extractedText = new ExtractedText();
        extractedText.text = textFieldValue.getText();
        extractedText.startOffset = 0;
        extractedText.partialEndOffset = textFieldValue.getText().length();
        extractedText.partialStartOffset = -1;
        extractedText.selectionStart = TextRange.m20454getMinimpl(textFieldValue.getSelection());
        extractedText.selectionEnd = TextRange.m20453getMaximpl(textFieldValue.getSelection());
        extractedText.flags = !StringsKt__StringsKt.contains$default((CharSequence) textFieldValue.getText(), '\n', false, 2, (Object) null) ? 1 : 0;
        return extractedText;
    }
}
