package androidx.compose.p109ui.text.input;

import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, m13886d2 = {"Landroidx/compose/ui/text/input/DeleteSurroundingTextInCodePointsCommand;", "Landroidx/compose/ui/text/input/EditCommand;", "lengthBeforeCursor", "", "lengthAfterCursor", "(II)V", "getLengthAfterCursor", "()I", "getLengthBeforeCursor", "applyTo", "", "buffer", "Landroidx/compose/ui/text/input/EditingBuffer;", "equals", "", "other", "", "hashCode", "toString", "", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class DeleteSurroundingTextInCodePointsCommand implements EditCommand {
    public static final int $stable = 0;
    private final int lengthAfterCursor;
    private final int lengthBeforeCursor;

    public DeleteSurroundingTextInCodePointsCommand(int i, int i2) {
        this.lengthBeforeCursor = i;
        this.lengthAfterCursor = i2;
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException(AbstractC0622a.m1164j(i, i2, "Expected lengthBeforeCursor and lengthAfterCursor to be non-negative, were ", " and ", " respectively.").toString());
        }
    }

    @Override // androidx.compose.p109ui.text.input.EditCommand
    public void applyTo(@NotNull EditingBuffer buffer) {
        int i = this.lengthBeforeCursor;
        int i2 = 0;
        int i4 = 0;
        int selectionStart = 0;
        while (true) {
            if (i4 < i) {
                int i5 = selectionStart + 1;
                if (buffer.getSelectionStart() <= i5) {
                    selectionStart = buffer.getSelectionStart();
                    break;
                } else {
                    selectionStart = EditCommandKt.isSurrogatePair(buffer.get$ui_text_release((buffer.getSelectionStart() - i5) + (-1)), buffer.get$ui_text_release(buffer.getSelectionStart() - i5)) ? selectionStart + 2 : i5;
                    i4++;
                }
            } else {
                break;
            }
        }
        int i6 = this.lengthAfterCursor;
        int length$ui_text_release = 0;
        while (true) {
            if (i2 >= i6) {
                break;
            }
            int i7 = length$ui_text_release + 1;
            if (buffer.getSelectionEnd() + i7 >= buffer.getLength$ui_text_release()) {
                length$ui_text_release = buffer.getLength$ui_text_release() - buffer.getSelectionEnd();
                break;
            } else {
                length$ui_text_release = EditCommandKt.isSurrogatePair(buffer.get$ui_text_release((buffer.getSelectionEnd() + i7) + (-1)), buffer.get$ui_text_release(buffer.getSelectionEnd() + i7)) ? length$ui_text_release + 2 : i7;
                i2++;
            }
        }
        buffer.delete$ui_text_release(buffer.getSelectionEnd(), buffer.getSelectionEnd() + length$ui_text_release);
        buffer.delete$ui_text_release(buffer.getSelectionStart() - selectionStart, buffer.getSelectionStart());
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeleteSurroundingTextInCodePointsCommand)) {
            return false;
        }
        DeleteSurroundingTextInCodePointsCommand deleteSurroundingTextInCodePointsCommand = (DeleteSurroundingTextInCodePointsCommand) other;
        return this.lengthBeforeCursor == deleteSurroundingTextInCodePointsCommand.lengthBeforeCursor && this.lengthAfterCursor == deleteSurroundingTextInCodePointsCommand.lengthAfterCursor;
    }

    public final int getLengthAfterCursor() {
        return this.lengthAfterCursor;
    }

    public final int getLengthBeforeCursor() {
        return this.lengthBeforeCursor;
    }

    public int hashCode() {
        return (this.lengthBeforeCursor * 31) + this.lengthAfterCursor;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder("DeleteSurroundingTextInCodePointsCommand(lengthBeforeCursor=");
        sb.append(this.lengthBeforeCursor);
        sb.append(", lengthAfterCursor=");
        return AbstractC0000a.m13j(sb, this.lengthAfterCursor, PropertyUtils.MAPPED_DELIM2);
    }
}
