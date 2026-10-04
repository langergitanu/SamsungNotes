package androidx.compose.p109ui.text.input;

import androidx.compose.p109ui.text.AnnotatedString;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0015\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0096\u0002J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, m13886d2 = {"Landroidx/compose/ui/text/input/SetComposingTextCommand;", "Landroidx/compose/ui/text/input/EditCommand;", "text", "", "newCursorPosition", "", "(Ljava/lang/String;I)V", "annotatedString", "Landroidx/compose/ui/text/AnnotatedString;", "(Landroidx/compose/ui/text/AnnotatedString;I)V", "getAnnotatedString", "()Landroidx/compose/ui/text/AnnotatedString;", "getNewCursorPosition", "()I", "getText", "()Ljava/lang/String;", "applyTo", "", "buffer", "Landroidx/compose/ui/text/input/EditingBuffer;", "equals", "", "other", "", "hashCode", "toString", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class SetComposingTextCommand implements EditCommand {
    public static final int $stable = 0;

    @NotNull
    private final AnnotatedString annotatedString;
    private final int newCursorPosition;

    public SetComposingTextCommand(@NotNull AnnotatedString annotatedString, int i) {
        this.annotatedString = annotatedString;
        this.newCursorPosition = i;
    }

    @Override // androidx.compose.p109ui.text.input.EditCommand
    public void applyTo(@NotNull EditingBuffer buffer) {
        if (buffer.hasComposition$ui_text_release()) {
            int compositionStart = buffer.getCompositionStart();
            buffer.replace$ui_text_release(buffer.getCompositionStart(), buffer.getCompositionEnd(), getText());
            if (getText().length() > 0) {
                buffer.setComposition$ui_text_release(compositionStart, getText().length() + compositionStart);
            }
        } else {
            int selectionStart = buffer.getSelectionStart();
            buffer.replace$ui_text_release(buffer.getSelectionStart(), buffer.getSelectionEnd(), getText());
            if (getText().length() > 0) {
                buffer.setComposition$ui_text_release(selectionStart, getText().length() + selectionStart);
            }
        }
        int cursor$ui_text_release = buffer.getCursor$ui_text_release();
        int i = this.newCursorPosition;
        buffer.setCursor$ui_text_release(RangesKt.coerceIn(i > 0 ? (cursor$ui_text_release + i) - 1 : (cursor$ui_text_release + i) - getText().length(), 0, buffer.getLength$ui_text_release()));
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SetComposingTextCommand)) {
            return false;
        }
        SetComposingTextCommand setComposingTextCommand = (SetComposingTextCommand) other;
        return Intrinsics.areEqual(getText(), setComposingTextCommand.getText()) && this.newCursorPosition == setComposingTextCommand.newCursorPosition;
    }

    @NotNull
    public final AnnotatedString getAnnotatedString() {
        return this.annotatedString;
    }

    public final int getNewCursorPosition() {
        return this.newCursorPosition;
    }

    @NotNull
    public final String getText() {
        return this.annotatedString.getText();
    }

    public int hashCode() {
        return (getText().hashCode() * 31) + this.newCursorPosition;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder("SetComposingTextCommand(text='");
        sb.append(getText());
        sb.append("', newCursorPosition=");
        return AbstractC0000a.m13j(sb, this.newCursorPosition, PropertyUtils.MAPPED_DELIM2);
    }

    public SetComposingTextCommand(@NotNull String str, int i) {
        this(new AnnotatedString(str, null, null, 6, null), i);
    }
}
