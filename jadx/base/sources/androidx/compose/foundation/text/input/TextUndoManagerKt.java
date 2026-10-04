package androidx.compose.foundation.text.input;

import androidx.compose.foundation.text.UndoManagerKt;
import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.foundation.text.input.internal.undo.TextDeleteType;
import androidx.compose.foundation.text.input.internal.undo.TextEditType;
import androidx.compose.foundation.text.input.internal.undo.TextUndoOperation;
import androidx.compose.p109ui.text.TextRange;
import androidx.compose.p109ui.text.TextRangeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0004*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0000\u001a.\u0010\b\u001a\u00020\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0003H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0002\u001a\u00020\u0003*\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u0011"}, m13886d2 = {"TEXT_UNDO_CAPACITY", "", "isNewLineInsert", "", "Landroidx/compose/foundation/text/input/internal/undo/TextUndoOperation;", "(Landroidx/compose/foundation/text/input/internal/undo/TextUndoOperation;)Z", "merge", "next", "recordChanges", "", "Landroidx/compose/foundation/text/input/TextUndoManager;", "pre", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "post", "changes", "Landroidx/compose/foundation/text/input/TextFieldBuffer$ChangeList;", "allowMerge", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class TextUndoManagerKt {
    private static final int TEXT_UNDO_CAPACITY = 100;

    private static final boolean isNewLineInsert(TextUndoOperation textUndoOperation) {
        return Intrinsics.areEqual(textUndoOperation.getPostText(), "\n") || Intrinsics.areEqual(textUndoOperation.getPostText(), "\r\n");
    }

    @Nullable
    public static final TextUndoOperation merge(@NotNull TextUndoOperation textUndoOperation, @NotNull TextUndoOperation textUndoOperation2) {
        if (!textUndoOperation.getCanMerge() || !textUndoOperation2.getCanMerge() || textUndoOperation2.getTimeInMillis() < textUndoOperation.getTimeInMillis() || textUndoOperation2.getTimeInMillis() - textUndoOperation.getTimeInMillis() >= UndoManagerKt.getSNAPSHOTS_INTERVAL_MILLIS() || isNewLineInsert(textUndoOperation) || isNewLineInsert(textUndoOperation2) || textUndoOperation.getTextEditType() != textUndoOperation2.getTextEditType()) {
            return null;
        }
        if (textUndoOperation.getTextEditType() == TextEditType.Insert) {
            if (textUndoOperation.getPostText().length() + textUndoOperation.getIndex() == textUndoOperation2.getIndex()) {
                return new TextUndoOperation(textUndoOperation.getIndex(), "", textUndoOperation.getPostText() + textUndoOperation2.getPostText(), textUndoOperation.getPreSelection(), textUndoOperation2.getPostSelection(), textUndoOperation.getTimeInMillis(), false, 64, null);
            }
        }
        if (textUndoOperation.getTextEditType() == TextEditType.Delete && textUndoOperation.getDeletionType() == textUndoOperation2.getDeletionType() && (textUndoOperation.getDeletionType() == TextDeleteType.Start || textUndoOperation.getDeletionType() == TextDeleteType.End)) {
            if (textUndoOperation.getIndex() == textUndoOperation2.getPreText().length() + textUndoOperation2.getIndex()) {
                return new TextUndoOperation(textUndoOperation2.getIndex(), textUndoOperation2.getPreText() + textUndoOperation.getPreText(), "", textUndoOperation.getPreSelection(), textUndoOperation2.getPostSelection(), textUndoOperation.getTimeInMillis(), false, 64, null);
            }
            if (textUndoOperation.getIndex() == textUndoOperation2.getIndex()) {
                return new TextUndoOperation(textUndoOperation.getIndex(), textUndoOperation.getPreText() + textUndoOperation2.getPreText(), "", textUndoOperation.getPreSelection(), textUndoOperation2.getPostSelection(), textUndoOperation.getTimeInMillis(), false, 64, null);
            }
        }
        return null;
    }

    public static final void recordChanges(@NotNull TextUndoManager textUndoManager, @NotNull TextFieldCharSequence textFieldCharSequence, @NotNull TextFieldCharSequence textFieldCharSequence2, @NotNull TextFieldBuffer.ChangeList changeList, boolean z) {
        if (changeList.getChangeCount() > 1) {
            textUndoManager.record(new TextUndoOperation(0, textFieldCharSequence.toString(), textFieldCharSequence2.toString(), textFieldCharSequence.getSelection(), textFieldCharSequence2.getSelection(), 0L, false, 32, null));
            return;
        }
        if (changeList.getChangeCount() == 1) {
            long jMo16278getOriginalRangejx7JFs = changeList.mo16278getOriginalRangejx7JFs(0);
            long jMo16279getRangejx7JFs = changeList.mo16279getRangejx7JFs(0);
            if (TextRange.m20450getCollapsedimpl(jMo16278getOriginalRangejx7JFs) && TextRange.m20450getCollapsedimpl(jMo16279getRangejx7JFs)) {
                return;
            }
            textUndoManager.record(new TextUndoOperation(TextRange.m20454getMinimpl(jMo16278getOriginalRangejx7JFs), TextRangeKt.m20463substringFDrldGo(textFieldCharSequence, jMo16278getOriginalRangejx7JFs), TextRangeKt.m20463substringFDrldGo(textFieldCharSequence2, jMo16279getRangejx7JFs), textFieldCharSequence.getSelection(), textFieldCharSequence2.getSelection(), 0L, z, 32, null));
        }
    }

    public static /* synthetic */ void recordChanges$default(TextUndoManager textUndoManager, TextFieldCharSequence textFieldCharSequence, TextFieldCharSequence textFieldCharSequence2, TextFieldBuffer.ChangeList changeList, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = true;
        }
        recordChanges(textUndoManager, textFieldCharSequence, textFieldCharSequence2, changeList, z);
    }
}
