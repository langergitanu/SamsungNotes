package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.common.Constant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0001J\u0011\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0096\u0002J2\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u0005J\u0018\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m13886d2 = {"Landroidx/compose/foundation/text/input/internal/PartialGapBuffer;", "", "text", "(Ljava/lang/CharSequence;)V", "bufEnd", "", "bufStart", "buffer", "Landroidx/compose/foundation/text/input/internal/GapBuffer;", "length", "getLength", "()I", "contentEquals", "", "other", "get", "", "index", Constant.DRAWING_TOOLKIT_KEY_RETURN_TYPE_REPLACE, "", "start", "end", "textStart", "textEnd", "subSequence", TextConst.KEY_START_INDEX, TextConst.KEY_END_INDEX, "toString", "", "Companion", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nGapBuffer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GapBuffer.kt\nandroidx/compose/foundation/text/input/internal/PartialGapBuffer\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,334:1\n1#2:335\n*E\n"})
public final class PartialGapBuffer implements CharSequence {
    public static final int BUF_SIZE = 255;
    public static final int NOWHERE = -1;
    public static final int SURROUNDING_SIZE = 64;

    @Nullable
    private GapBuffer buffer;

    @NotNull
    private CharSequence text;
    public static final int $stable = 8;
    private int bufStart = -1;
    private int bufEnd = -1;

    public PartialGapBuffer(@NotNull CharSequence charSequence) {
        this.text = charSequence;
    }

    public static /* synthetic */ void replace$default(PartialGapBuffer partialGapBuffer, int i, int i2, CharSequence charSequence, int i4, int i5, int i6, Object obj) {
        if ((i6 & 8) != 0) {
            i4 = 0;
        }
        int i7 = i4;
        if ((i6 & 16) != 0) {
            i5 = charSequence.length();
        }
        partialGapBuffer.replace(i, i2, charSequence, i7, i5);
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ char charAt(int i) {
        return get(i);
    }

    public final boolean contentEquals(@NotNull CharSequence other) {
        return Intrinsics.areEqual(toString(), other.toString());
    }

    public char get(int index) {
        GapBuffer gapBuffer = this.buffer;
        if (gapBuffer == null) {
            return this.text.charAt(index);
        }
        if (index < this.bufStart) {
            return this.text.charAt(index);
        }
        int length = gapBuffer.length();
        int i = this.bufStart;
        return index < length + i ? gapBuffer.get(index - i) : this.text.charAt(index - ((length - this.bufEnd) + i));
    }

    public int getLength() {
        GapBuffer gapBuffer = this.buffer;
        return gapBuffer == null ? this.text.length() : (this.text.length() - (this.bufEnd - this.bufStart)) + gapBuffer.length();
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ int length() {
        return getLength();
    }

    public final void replace(int start, int end, @NotNull CharSequence text, int textStart, int textEnd) {
        if (start > end) {
            throw new IllegalArgumentException(AbstractC1038a.m1214o(start, end, "start=", " > end=").toString());
        }
        if (textStart > textEnd) {
            throw new IllegalArgumentException(AbstractC1038a.m1214o(textStart, textEnd, "textStart=", " > textEnd=").toString());
        }
        if (start < 0) {
            throw new IllegalArgumentException(AbstractC0000a.m11h(start, "start must be non-negative, but was ").toString());
        }
        if (textStart < 0) {
            throw new IllegalArgumentException(AbstractC0000a.m11h(textStart, "textStart must be non-negative, but was ").toString());
        }
        GapBuffer gapBuffer = this.buffer;
        int i = textEnd - textStart;
        if (gapBuffer != null) {
            int i2 = this.bufStart;
            int i4 = start - i2;
            int i5 = end - i2;
            if (i4 >= 0 && i5 <= gapBuffer.length()) {
                gapBuffer.replace(i4, i5, text, textStart, textEnd);
                return;
            }
            this.text = toString();
            this.buffer = null;
            this.bufStart = -1;
            this.bufEnd = -1;
            replace(start, end, text, textStart, textEnd);
            return;
        }
        int iMax = Math.max(255, i + 128);
        char[] cArr = new char[iMax];
        int iMin = Math.min(start, 64);
        int iMin2 = Math.min(this.text.length() - end, 64);
        int i6 = start - iMin;
        ToCharArray_androidKt.toCharArray(this.text, cArr, 0, i6, start);
        int i7 = iMax - iMin2;
        int i8 = iMin2 + end;
        ToCharArray_androidKt.toCharArray(this.text, cArr, i7, end, i8);
        ToCharArray_androidKt.toCharArray(text, cArr, iMin, textStart, textEnd);
        this.buffer = new GapBuffer(cArr, iMin + i, i7);
        this.bufStart = i6;
        this.bufEnd = i8;
    }

    @Override // java.lang.CharSequence
    @NotNull
    public CharSequence subSequence(int startIndex, int endIndex) {
        return toString().subSequence(startIndex, endIndex);
    }

    @Override // java.lang.CharSequence
    @NotNull
    public String toString() {
        GapBuffer gapBuffer = this.buffer;
        if (gapBuffer == null) {
            return this.text.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.text, 0, this.bufStart);
        gapBuffer.append(sb);
        CharSequence charSequence = this.text;
        sb.append(charSequence, this.bufEnd, charSequence.length());
        return sb.toString();
    }
}
