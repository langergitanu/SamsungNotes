package androidx.compose.p109ui.text.input;

import androidx.compose.p109ui.text.JvmCharHelpers_androidKt;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, m13886d2 = {"Landroidx/compose/ui/text/input/MoveCursorCommand;", "Landroidx/compose/ui/text/input/EditCommand;", "amount", "", "(I)V", "getAmount", "()I", "applyTo", "", "buffer", "Landroidx/compose/ui/text/input/EditingBuffer;", "equals", "", "other", "", "hashCode", "toString", "", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class MoveCursorCommand implements EditCommand {
    public static final int $stable = 0;
    private final int amount;

    public MoveCursorCommand(int i) {
        this.amount = i;
    }

    @Override // androidx.compose.p109ui.text.input.EditCommand
    public void applyTo(@NotNull EditingBuffer buffer) {
        if (buffer.getCursor$ui_text_release() == -1) {
            buffer.setCursor$ui_text_release(buffer.getSelectionStart());
        }
        int selectionStart = buffer.getSelectionStart();
        String string = buffer.toString();
        int i = this.amount;
        int i2 = 0;
        if (i <= 0) {
            int i4 = -i;
            while (i2 < i4) {
                int iFindPrecedingBreak = JvmCharHelpers_androidKt.findPrecedingBreak(string, selectionStart);
                if (iFindPrecedingBreak == -1) {
                    break;
                }
                i2++;
                selectionStart = iFindPrecedingBreak;
            }
        } else {
            while (i2 < i) {
                int iFindFollowingBreak = JvmCharHelpers_androidKt.findFollowingBreak(string, selectionStart);
                if (iFindFollowingBreak == -1) {
                    break;
                }
                i2++;
                selectionStart = iFindFollowingBreak;
            }
        }
        buffer.setCursor$ui_text_release(selectionStart);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MoveCursorCommand) && this.amount == ((MoveCursorCommand) other).amount;
    }

    public final int getAmount() {
        return this.amount;
    }

    public int hashCode() {
        return this.amount;
    }

    @NotNull
    public String toString() {
        return AbstractC0000a.m13j(new StringBuilder("MoveCursorCommand(amount="), this.amount, PropertyUtils.MAPPED_DELIM2);
    }
}
