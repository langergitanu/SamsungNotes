package androidx.compose.foundation.text.input.internal;

import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.text.StringHelpers_androidKt;
import com.samsung.android.sdk.mobileservice.social.share.ShareApi;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0007H\u0000\u001a\u001c\u0010\b\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a\f\u0010\r\u001a\u00020\u0006*\u00020\u0007H\u0000\u001a\u001c\u0010\u000e\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0000\u001a\u001c\u0010\u0011\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0000\u001a\f\u0010\u0012\u001a\u00020\u0006*\u00020\u0007H\u0000\u001a\u0014\u0010\u0013\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\u0014\u001a\u00020\fH\u0000\u001a\u001c\u0010\u0015\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\fH\u0000\u001a\u001c\u0010\u0018\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000¨\u0006\u0019"}, m13886d2 = {"isSurrogatePair", "", "high", "", ShareApi.HQVGA_240_SIZE_IMAGE, "backspace", "", "Landroidx/compose/foundation/text/input/internal/EditingBuffer;", "commitText", "text", "", "newCursorPosition", "", "deleteAll", "deleteSurroundingText", "lengthBeforeCursor", "lengthAfterCursor", "deleteSurroundingTextInCodePoints", "finishComposingText", "moveCursor", "amount", "setComposingRegion", "start", "end", "setComposingText", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nEditCommand.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EditCommand.kt\nandroidx/compose/foundation/text/input/internal/EditCommandKt\n+ 2 MathUtils.kt\nandroidx/compose/foundation/text/input/internal/MathUtilsKt\n*L\n1#1,304:1\n27#2,3:305\n36#2,4:308\n*S KotlinDebug\n*F\n+ 1 EditCommand.kt\nandroidx/compose/foundation/text/input/internal/EditCommandKt\n*L\n156#1:305,3\n161#1:308,4\n*E\n"})
public final class EditCommandKt {
    public static final void backspace(@NotNull EditingBuffer editingBuffer) {
        if (editingBuffer.hasComposition()) {
            editingBuffer.delete(editingBuffer.getCompositionStart(), editingBuffer.getCompositionEnd());
            return;
        }
        if (editingBuffer.getCursor() != -1) {
            if (editingBuffer.getCursor() != 0) {
                editingBuffer.delete(StringHelpers_androidKt.findPrecedingBreak(editingBuffer.toString(), editingBuffer.getCursor()), editingBuffer.getCursor());
            }
        } else {
            int selectionStart = editingBuffer.getSelectionStart();
            int selectionEnd = editingBuffer.getSelectionEnd();
            editingBuffer.setCursor(editingBuffer.getSelectionStart());
            editingBuffer.delete(selectionStart, selectionEnd);
        }
    }

    public static final void commitText(@NotNull EditingBuffer editingBuffer, @NotNull String str, int i) {
        if (editingBuffer.hasComposition()) {
            editingBuffer.replace(editingBuffer.getCompositionStart(), editingBuffer.getCompositionEnd(), str);
        } else {
            editingBuffer.replace(editingBuffer.getSelectionStart(), editingBuffer.getSelectionEnd(), str);
        }
        editingBuffer.setCursor(RangesKt.coerceIn(i > 0 ? (r0 + i) - 1 : (editingBuffer.getCursor() + i) - str.length(), 0, editingBuffer.getLength()));
    }

    public static final void deleteAll(@NotNull EditingBuffer editingBuffer) {
        editingBuffer.replace(0, editingBuffer.getLength(), "");
    }

    public static final void deleteSurroundingText(@NotNull EditingBuffer editingBuffer, int i, int i2) {
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException(AbstractC0622a.m1164j(i, i2, "Expected lengthBeforeCursor and lengthAfterCursor to be non-negative, were ", " and ", " respectively.").toString());
        }
        int selectionEnd = editingBuffer.getSelectionEnd();
        int length = selectionEnd + i2;
        if (((i2 ^ length) & (selectionEnd ^ length)) < 0) {
            length = editingBuffer.getLength();
        }
        editingBuffer.delete(editingBuffer.getSelectionEnd(), Math.min(length, editingBuffer.getLength()));
        int selectionStart = editingBuffer.getSelectionStart();
        int i4 = selectionStart - i;
        if (((i ^ selectionStart) & (selectionStart ^ i4)) < 0) {
            i4 = 0;
        }
        editingBuffer.delete(Math.max(0, i4), editingBuffer.getSelectionStart());
    }

    public static final void deleteSurroundingTextInCodePoints(@NotNull EditingBuffer editingBuffer, int i, int i2) {
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException(AbstractC0622a.m1164j(i, i2, "Expected lengthBeforeCursor and lengthAfterCursor to be non-negative, were ", " and ", " respectively.").toString());
        }
        int i4 = 0;
        int i5 = 0;
        int selectionStart = 0;
        while (true) {
            if (i5 < i) {
                int i6 = selectionStart + 1;
                if (editingBuffer.getSelectionStart() <= i6) {
                    selectionStart = editingBuffer.getSelectionStart();
                    break;
                } else {
                    selectionStart = isSurrogatePair(editingBuffer.get((editingBuffer.getSelectionStart() - i6) + (-1)), editingBuffer.get(editingBuffer.getSelectionStart() - i6)) ? selectionStart + 2 : i6;
                    i5++;
                }
            } else {
                break;
            }
        }
        int length = 0;
        while (true) {
            if (i4 >= i2) {
                break;
            }
            int i7 = length + 1;
            if (editingBuffer.getSelectionEnd() + i7 >= editingBuffer.getLength()) {
                length = editingBuffer.getLength() - editingBuffer.getSelectionEnd();
                break;
            } else {
                length = isSurrogatePair(editingBuffer.get((editingBuffer.getSelectionEnd() + i7) + (-1)), editingBuffer.get(editingBuffer.getSelectionEnd() + i7)) ? length + 2 : i7;
                i4++;
            }
        }
        editingBuffer.delete(editingBuffer.getSelectionEnd(), editingBuffer.getSelectionEnd() + length);
        editingBuffer.delete(editingBuffer.getSelectionStart() - selectionStart, editingBuffer.getSelectionStart());
    }

    public static final void finishComposingText(@NotNull EditingBuffer editingBuffer) {
        editingBuffer.commitComposition();
    }

    private static final boolean isSurrogatePair(char c, char c2) {
        return Character.isHighSurrogate(c) && Character.isLowSurrogate(c2);
    }

    public static final void moveCursor(@NotNull EditingBuffer editingBuffer, int i) {
        if (editingBuffer.getCursor() == -1) {
            editingBuffer.setCursor(editingBuffer.getSelectionStart());
        }
        int selectionStart = editingBuffer.getSelectionStart();
        String string = editingBuffer.toString();
        int i2 = 0;
        if (i <= 0) {
            int i4 = -i;
            while (i2 < i4) {
                int iFindPrecedingBreak = StringHelpers_androidKt.findPrecedingBreak(string, selectionStart);
                if (iFindPrecedingBreak == -1) {
                    break;
                }
                i2++;
                selectionStart = iFindPrecedingBreak;
            }
        } else {
            while (i2 < i) {
                int iFindFollowingBreak = StringHelpers_androidKt.findFollowingBreak(string, selectionStart);
                if (iFindFollowingBreak == -1) {
                    break;
                }
                i2++;
                selectionStart = iFindFollowingBreak;
            }
        }
        editingBuffer.setCursor(selectionStart);
    }

    public static final void setComposingRegion(@NotNull EditingBuffer editingBuffer, int i, int i2) {
        if (editingBuffer.hasComposition()) {
            editingBuffer.commitComposition();
        }
        int iCoerceIn = RangesKt.coerceIn(i, 0, editingBuffer.getLength());
        int iCoerceIn2 = RangesKt.coerceIn(i2, 0, editingBuffer.getLength());
        if (iCoerceIn != iCoerceIn2) {
            if (iCoerceIn < iCoerceIn2) {
                editingBuffer.setComposition(iCoerceIn, iCoerceIn2);
            } else {
                editingBuffer.setComposition(iCoerceIn2, iCoerceIn);
            }
        }
    }

    public static final void setComposingText(@NotNull EditingBuffer editingBuffer, @NotNull String str, int i) {
        if (editingBuffer.hasComposition()) {
            int compositionStart = editingBuffer.getCompositionStart();
            editingBuffer.replace(compositionStart, editingBuffer.getCompositionEnd(), str);
            if (str.length() > 0) {
                editingBuffer.setComposition(compositionStart, str.length() + compositionStart);
            }
        } else {
            int selectionStart = editingBuffer.getSelectionStart();
            editingBuffer.replace(selectionStart, editingBuffer.getSelectionEnd(), str);
            if (str.length() > 0) {
                editingBuffer.setComposition(selectionStart, str.length() + selectionStart);
            }
        }
        editingBuffer.setCursor(RangesKt.coerceIn(i > 0 ? (r0 + i) - 1 : (editingBuffer.getCursor() + i) - str.length(), 0, editingBuffer.getLength()));
    }
}
