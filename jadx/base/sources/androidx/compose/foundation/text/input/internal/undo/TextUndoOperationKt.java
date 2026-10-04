package androidx.compose.foundation.text.input.internal.undo;

import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.internal.EditingBuffer;
import androidx.compose.p109ui.text.TextRange;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0006"}, m13886d2 = {"redo", "", "Landroidx/compose/foundation/text/input/TextFieldState;", "op", "Landroidx/compose/foundation/text/input/internal/undo/TextUndoOperation;", "undo", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTextUndoOperation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextUndoOperation.kt\nandroidx/compose/foundation/text/input/internal/undo/TextUndoOperationKt\n+ 2 TextFieldState.kt\nandroidx/compose/foundation/text/input/TextFieldState\n*L\n1#1,176:1\n288#2,15:177\n288#2,15:192\n*S KotlinDebug\n*F\n+ 1 TextUndoOperation.kt\nandroidx/compose/foundation/text/input/internal/undo/TextUndoOperationKt\n*L\n115#1:177,15\n125#1:192,15\n*E\n"})
public final class TextUndoOperationKt {
    public static final void redo(@NotNull TextFieldState textFieldState, @NotNull TextUndoOperation textUndoOperation) {
        textFieldState.getMainBuffer().getChangeTracker().clearChanges();
        EditingBuffer mainBuffer = textFieldState.getMainBuffer();
        mainBuffer.replace(textUndoOperation.getIndex(), textUndoOperation.getPreText().length() + textUndoOperation.getIndex(), textUndoOperation.getPostText());
        mainBuffer.setSelection(TextRange.m20456getStartimpl(textUndoOperation.getPostSelection()), TextRange.m20451getEndimpl(textUndoOperation.getPostSelection()));
        textFieldState.updateValueAndNotifyListeners(textFieldState.getValue$foundation_release(), new TextFieldCharSequence(textFieldState.getMainBuffer().toString(), textFieldState.getMainBuffer().m16312getSelectiond9O1mEE(), textFieldState.getMainBuffer().m16311getCompositionMzsxiRA(), null, 8, null), true);
    }

    public static final void undo(@NotNull TextFieldState textFieldState, @NotNull TextUndoOperation textUndoOperation) {
        textFieldState.getMainBuffer().getChangeTracker().clearChanges();
        EditingBuffer mainBuffer = textFieldState.getMainBuffer();
        mainBuffer.replace(textUndoOperation.getIndex(), textUndoOperation.getPostText().length() + textUndoOperation.getIndex(), textUndoOperation.getPreText());
        mainBuffer.setSelection(TextRange.m20456getStartimpl(textUndoOperation.getPreSelection()), TextRange.m20451getEndimpl(textUndoOperation.getPreSelection()));
        textFieldState.updateValueAndNotifyListeners(textFieldState.getValue$foundation_release(), new TextFieldCharSequence(textFieldState.getMainBuffer().toString(), textFieldState.getMainBuffer().m16312getSelectiond9O1mEE(), textFieldState.getMainBuffer().m16311getCompositionMzsxiRA(), null, 8, null), true);
    }
}
