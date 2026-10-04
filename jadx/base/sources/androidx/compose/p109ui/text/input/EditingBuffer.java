package androidx.compose.p109ui.text.input;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.p109ui.text.AnnotatedString;
import androidx.compose.p109ui.text.TextRange;
import androidx.compose.p109ui.text.TextRangeKt;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.sdk.mobileservice.social.social.OpenSessionApi;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.common.Constant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0007\u0018\u0000 =2\u00020\u0001:\u0001=B\u0017\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\r\u0010$\u001a\u00020%H\u0000¢\u0006\u0002\b&J\r\u0010'\u001a\u00020%H\u0000¢\u0006\u0002\b(J\u001d\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\rH\u0000¢\u0006\u0002\b,J\u0016\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\rH\u0080\u0002¢\u0006\u0002\b0J\r\u00101\u001a\u000202H\u0000¢\u0006\u0002\b3J%\u00104\u001a\u00020%2\u0006\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u0007H\u0000¢\u0006\u0002\b5J%\u00104\u001a\u00020%2\u0006\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\b5J\u001d\u00106\u001a\u00020%2\u0006\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\rH\u0000¢\u0006\u0002\b7J\u001d\u00108\u001a\u00020%2\u0006\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\rH\u0000¢\u0006\u0002\b9J\r\u0010:\u001a\u00020\u0007H\u0000¢\u0006\u0002\b;J\b\u0010<\u001a\u00020\u0003H\u0016R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00058@X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R$\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r8@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u00020\r8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u00058@X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR$\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\r@BX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0010\"\u0004\b \u0010\u0016R$\u0010!\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\r@BX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0010\"\u0004\b#\u0010\u0016\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006>"}, m13886d2 = {"Landroidx/compose/ui/text/input/EditingBuffer;", "", "text", "", "selection", "Landroidx/compose/ui/text/TextRange;", "(Ljava/lang/String;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "Landroidx/compose/ui/text/AnnotatedString;", "(Landroidx/compose/ui/text/AnnotatedString;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "composition", "getComposition-MzsxiRA$ui_text_release", "()Landroidx/compose/ui/text/TextRange;", "<set-?>", "", "compositionEnd", "getCompositionEnd$ui_text_release", "()I", "compositionStart", "getCompositionStart$ui_text_release", "cursor", "getCursor$ui_text_release", "setCursor$ui_text_release", "(I)V", "gapBuffer", "Landroidx/compose/ui/text/input/PartialGapBuffer;", "length", "getLength$ui_text_release", "getSelection-d9O1mEE$ui_text_release", "()J", "value", "selectionEnd", "getSelectionEnd$ui_text_release", "setSelectionEnd", "selectionStart", "getSelectionStart$ui_text_release", "setSelectionStart", "cancelComposition", "", "cancelComposition$ui_text_release", "commitComposition", "commitComposition$ui_text_release", OpenSessionApi.ITEM_LIMIT_DELETE, "start", "end", "delete$ui_text_release", "get", "", "index", "get$ui_text_release", "hasComposition", "", "hasComposition$ui_text_release", Constant.DRAWING_TOOLKIT_KEY_RETURN_TYPE_REPLACE, "replace$ui_text_release", "setComposition", "setComposition$ui_text_release", "setSelection", "setSelection$ui_text_release", "toAnnotatedString", "toAnnotatedString$ui_text_release", "toString", "Companion", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nEditingBuffer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EditingBuffer.kt\nandroidx/compose/ui/text/input/EditingBuffer\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,402:1\n1#2:403\n*E\n"})
public final class EditingBuffer {
    public static final int NOWHERE = -1;
    private int compositionEnd;
    private int compositionStart;

    @NotNull
    private final PartialGapBuffer gapBuffer;
    private int selectionEnd;
    private int selectionStart;
    public static final int $stable = 8;

    public /* synthetic */ EditingBuffer(AnnotatedString annotatedString, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, j);
    }

    private final void setSelectionEnd(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(AbstractC0000a.m11h(i, "Cannot set selectionEnd to a negative value: ").toString());
        }
        this.selectionEnd = i;
    }

    private final void setSelectionStart(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(AbstractC0000a.m11h(i, "Cannot set selectionStart to a negative value: ").toString());
        }
        this.selectionStart = i;
    }

    public final void cancelComposition$ui_text_release() {
        replace$ui_text_release(this.compositionStart, this.compositionEnd, "");
        this.compositionStart = -1;
        this.compositionEnd = -1;
    }

    public final void commitComposition$ui_text_release() {
        this.compositionStart = -1;
        this.compositionEnd = -1;
    }

    public final void delete$ui_text_release(int start, int end) {
        long jTextRange = TextRangeKt.TextRange(start, end);
        this.gapBuffer.replace(start, end, "");
        long jM20616updateRangeAfterDeletepWDy79M = EditingBufferKt.m20616updateRangeAfterDeletepWDy79M(TextRangeKt.TextRange(this.selectionStart, this.selectionEnd), jTextRange);
        setSelectionStart(TextRange.m20454getMinimpl(jM20616updateRangeAfterDeletepWDy79M));
        setSelectionEnd(TextRange.m20453getMaximpl(jM20616updateRangeAfterDeletepWDy79M));
        if (hasComposition$ui_text_release()) {
            long jM20616updateRangeAfterDeletepWDy79M2 = EditingBufferKt.m20616updateRangeAfterDeletepWDy79M(TextRangeKt.TextRange(this.compositionStart, this.compositionEnd), jTextRange);
            if (TextRange.m20450getCollapsedimpl(jM20616updateRangeAfterDeletepWDy79M2)) {
                commitComposition$ui_text_release();
            } else {
                this.compositionStart = TextRange.m20454getMinimpl(jM20616updateRangeAfterDeletepWDy79M2);
                this.compositionEnd = TextRange.m20453getMaximpl(jM20616updateRangeAfterDeletepWDy79M2);
            }
        }
    }

    public final char get$ui_text_release(int index) {
        return this.gapBuffer.get(index);
    }

    @Nullable
    /* JADX INFO: renamed from: getComposition-MzsxiRA$ui_text_release, reason: not valid java name */
    public final TextRange m20614getCompositionMzsxiRA$ui_text_release() {
        if (hasComposition$ui_text_release()) {
            return TextRange.m20444boximpl(TextRangeKt.TextRange(this.compositionStart, this.compositionEnd));
        }
        return null;
    }

    /* JADX INFO: renamed from: getCompositionEnd$ui_text_release, reason: from getter */
    public final int getCompositionEnd() {
        return this.compositionEnd;
    }

    /* JADX INFO: renamed from: getCompositionStart$ui_text_release, reason: from getter */
    public final int getCompositionStart() {
        return this.compositionStart;
    }

    public final int getCursor$ui_text_release() {
        int i = this.selectionStart;
        int i2 = this.selectionEnd;
        if (i == i2) {
            return i2;
        }
        return -1;
    }

    public final int getLength$ui_text_release() {
        return this.gapBuffer.getLength();
    }

    /* JADX INFO: renamed from: getSelection-d9O1mEE$ui_text_release, reason: not valid java name */
    public final long m20615getSelectiond9O1mEE$ui_text_release() {
        return TextRangeKt.TextRange(this.selectionStart, this.selectionEnd);
    }

    /* JADX INFO: renamed from: getSelectionEnd$ui_text_release, reason: from getter */
    public final int getSelectionEnd() {
        return this.selectionEnd;
    }

    /* JADX INFO: renamed from: getSelectionStart$ui_text_release, reason: from getter */
    public final int getSelectionStart() {
        return this.selectionStart;
    }

    public final boolean hasComposition$ui_text_release() {
        return this.compositionStart != -1;
    }

    public final void replace$ui_text_release(int start, int end, @NotNull AnnotatedString text) {
        replace$ui_text_release(start, end, text.getText());
    }

    public final void setComposition$ui_text_release(int start, int end) {
        if (start < 0 || start > this.gapBuffer.getLength()) {
            StringBuilder sbM778t = AbstractC0541b.m778t(start, "start (", ") offset is outside of text region ");
            sbM778t.append(this.gapBuffer.getLength());
            throw new IndexOutOfBoundsException(sbM778t.toString());
        }
        if (end < 0 || end > this.gapBuffer.getLength()) {
            StringBuilder sbM778t2 = AbstractC0541b.m778t(end, "end (", ") offset is outside of text region ");
            sbM778t2.append(this.gapBuffer.getLength());
            throw new IndexOutOfBoundsException(sbM778t2.toString());
        }
        if (start >= end) {
            throw new IllegalArgumentException(AbstractC1038a.m1214o(start, end, "Do not set reversed or empty range: ", " > "));
        }
        this.compositionStart = start;
        this.compositionEnd = end;
    }

    public final void setCursor$ui_text_release(int i) {
        setSelection$ui_text_release(i, i);
    }

    public final void setSelection$ui_text_release(int start, int end) {
        if (start < 0 || start > this.gapBuffer.getLength()) {
            StringBuilder sbM778t = AbstractC0541b.m778t(start, "start (", ") offset is outside of text region ");
            sbM778t.append(this.gapBuffer.getLength());
            throw new IndexOutOfBoundsException(sbM778t.toString());
        }
        if (end < 0 || end > this.gapBuffer.getLength()) {
            StringBuilder sbM778t2 = AbstractC0541b.m778t(end, "end (", ") offset is outside of text region ");
            sbM778t2.append(this.gapBuffer.getLength());
            throw new IndexOutOfBoundsException(sbM778t2.toString());
        }
        if (start > end) {
            throw new IllegalArgumentException(AbstractC1038a.m1214o(start, end, "Do not set reversed range: ", " > "));
        }
        setSelectionStart(start);
        setSelectionEnd(end);
    }

    @NotNull
    public final AnnotatedString toAnnotatedString$ui_text_release() {
        return new AnnotatedString(toString(), null, null, 6, null);
    }

    @NotNull
    public String toString() {
        return this.gapBuffer.toString();
    }

    public /* synthetic */ EditingBuffer(String str, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j);
    }

    public final void replace$ui_text_release(int start, int end, @NotNull String text) {
        if (start < 0 || start > this.gapBuffer.getLength()) {
            StringBuilder sbM778t = AbstractC0541b.m778t(start, "start (", ") offset is outside of text region ");
            sbM778t.append(this.gapBuffer.getLength());
            throw new IndexOutOfBoundsException(sbM778t.toString());
        }
        if (end < 0 || end > this.gapBuffer.getLength()) {
            StringBuilder sbM778t2 = AbstractC0541b.m778t(end, "end (", ") offset is outside of text region ");
            sbM778t2.append(this.gapBuffer.getLength());
            throw new IndexOutOfBoundsException(sbM778t2.toString());
        }
        if (start > end) {
            throw new IllegalArgumentException(AbstractC1038a.m1214o(start, end, "Do not set reversed range: ", " > "));
        }
        this.gapBuffer.replace(start, end, text);
        setSelectionStart(text.length() + start);
        setSelectionEnd(text.length() + start);
        this.compositionStart = -1;
        this.compositionEnd = -1;
    }

    private EditingBuffer(AnnotatedString annotatedString, long j) {
        this.gapBuffer = new PartialGapBuffer(annotatedString.getText());
        this.selectionStart = TextRange.m20454getMinimpl(j);
        this.selectionEnd = TextRange.m20453getMaximpl(j);
        this.compositionStart = -1;
        this.compositionEnd = -1;
        int iM20454getMinimpl = TextRange.m20454getMinimpl(j);
        int iM20453getMaximpl = TextRange.m20453getMaximpl(j);
        if (iM20454getMinimpl >= 0 && iM20454getMinimpl <= annotatedString.length()) {
            if (iM20453getMaximpl < 0 || iM20453getMaximpl > annotatedString.length()) {
                StringBuilder sbM778t = AbstractC0541b.m778t(iM20453getMaximpl, "end (", ") offset is outside of text region ");
                sbM778t.append(annotatedString.length());
                throw new IndexOutOfBoundsException(sbM778t.toString());
            }
            if (iM20454getMinimpl > iM20453getMaximpl) {
                throw new IllegalArgumentException(AbstractC1038a.m1214o(iM20454getMinimpl, iM20453getMaximpl, "Do not set reversed range: ", " > "));
            }
            return;
        }
        StringBuilder sbM778t2 = AbstractC0541b.m778t(iM20454getMinimpl, "start (", ") offset is outside of text region ");
        sbM778t2.append(annotatedString.length());
        throw new IndexOutOfBoundsException(sbM778t2.toString());
    }

    private EditingBuffer(String str, long j) {
        this(new AnnotatedString(str, null, null, 6, null), j, (DefaultConstructorMarker) null);
    }
}
