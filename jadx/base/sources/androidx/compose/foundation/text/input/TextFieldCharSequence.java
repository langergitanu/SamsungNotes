package androidx.compose.foundation.text.input;

import androidx.compose.foundation.text.input.internal.ToCharArray_androidKt;
import androidx.compose.p109ui.text.TextRange;
import androidx.compose.p109ui.text.TextRangeKt;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import io.netty.handler.codec.rtsp.RtspHeaders;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\f\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0001J\u0013\u0010\u001a\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001bH\u0096\u0002J\u0011\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000fH\u0096\u0002J\b\u0010\u001f\u001a\u00020\u000fH\u0016J\u0006\u0010 \u001a\u00020\u0018J\u0018\u0010!\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u000fH\u0016J&\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\u000fJ\b\u0010+\u001a\u00020,H\u0016R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006-"}, m13886d2 = {"Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "", "text", "selection", "Landroidx/compose/ui/text/TextRange;", "composition", "highlight", "Lkotlin/Pair;", "Landroidx/compose/foundation/text/input/TextHighlightType;", "(Ljava/lang/CharSequence;JLandroidx/compose/ui/text/TextRange;Lkotlin/Pair;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getComposition-MzsxiRA", "()Landroidx/compose/ui/text/TextRange;", "getHighlight", "()Lkotlin/Pair;", "length", "", "getLength", "()I", "getSelection-d9O1mEE", "()J", "J", "getText", "()Ljava/lang/CharSequence;", "contentEquals", "", "other", "equals", "", "get", "", "index", "hashCode", "shouldShowSelection", "subSequence", TextConst.KEY_START_INDEX, TextConst.KEY_END_INDEX, "toCharArray", "", RtspHeaders.Values.DESTINATION, "", "destinationOffset", "sourceStartIndex", "sourceEndIndex", "toString", "", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class TextFieldCharSequence implements CharSequence {
    public static final int $stable = 8;

    @Nullable
    private final TextRange composition;

    @Nullable
    private final Pair<TextHighlightType, TextRange> highlight;
    private final long selection;

    @NotNull
    private final CharSequence text;

    public /* synthetic */ TextFieldCharSequence(CharSequence charSequence, long j, TextRange textRange, Pair pair, DefaultConstructorMarker defaultConstructorMarker) {
        this(charSequence, j, textRange, pair);
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ char charAt(int i) {
        return get(i);
    }

    public final boolean contentEquals(@NotNull CharSequence other) {
        return StringsKt.contentEquals(this.text, other);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || TextFieldCharSequence.class != other.getClass()) {
            return false;
        }
        TextFieldCharSequence textFieldCharSequence = (TextFieldCharSequence) other;
        return TextRange.m20449equalsimpl0(this.selection, textFieldCharSequence.selection) && Intrinsics.areEqual(this.composition, textFieldCharSequence.composition) && Intrinsics.areEqual(this.highlight, textFieldCharSequence.highlight) && contentEquals(textFieldCharSequence.text);
    }

    public char get(int index) {
        return this.text.charAt(index);
    }

    @Nullable
    /* JADX INFO: renamed from: getComposition-MzsxiRA, reason: not valid java name and from getter */
    public final TextRange getComposition() {
        return this.composition;
    }

    @Nullable
    public final Pair<TextHighlightType, TextRange> getHighlight() {
        return this.highlight;
    }

    public int getLength() {
        return this.text.length();
    }

    /* JADX INFO: renamed from: getSelection-d9O1mEE, reason: not valid java name and from getter */
    public final long getSelection() {
        return this.selection;
    }

    @NotNull
    public final CharSequence getText() {
        return this.text;
    }

    public int hashCode() {
        int iM20457hashCodeimpl = (TextRange.m20457hashCodeimpl(this.selection) + (this.text.hashCode() * 31)) * 31;
        TextRange textRange = this.composition;
        int iM20457hashCodeimpl2 = (iM20457hashCodeimpl + (textRange != null ? TextRange.m20457hashCodeimpl(textRange.getPackedValue()) : 0)) * 31;
        Pair<TextHighlightType, TextRange> pair = this.highlight;
        return iM20457hashCodeimpl2 + (pair != null ? pair.hashCode() : 0);
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ int length() {
        return getLength();
    }

    public final boolean shouldShowSelection() {
        return this.highlight == null;
    }

    @Override // java.lang.CharSequence
    @NotNull
    public CharSequence subSequence(int startIndex, int endIndex) {
        return this.text.subSequence(startIndex, endIndex);
    }

    public final void toCharArray(@NotNull char[] destination, int destinationOffset, int sourceStartIndex, int sourceEndIndex) {
        ToCharArray_androidKt.toCharArray(this.text, destination, destinationOffset, sourceStartIndex, sourceEndIndex);
    }

    @Override // java.lang.CharSequence
    @NotNull
    public String toString() {
        return this.text.toString();
    }

    private TextFieldCharSequence(CharSequence charSequence, long j, TextRange textRange, Pair<TextHighlightType, TextRange> pair) {
        this.text = charSequence instanceof TextFieldCharSequence ? ((TextFieldCharSequence) charSequence).text : charSequence;
        this.selection = TextRangeKt.m20462coerceIn8ffj60Q(j, 0, charSequence.length());
        this.composition = textRange != null ? TextRange.m20444boximpl(TextRangeKt.m20462coerceIn8ffj60Q(textRange.getPackedValue(), 0, charSequence.length())) : null;
        this.highlight = pair != null ? Pair.copy$default(pair, null, TextRange.m20444boximpl(TextRangeKt.m20462coerceIn8ffj60Q(pair.getSecond().getPackedValue(), 0, charSequence.length())), 1, null) : null;
    }

    public /* synthetic */ TextFieldCharSequence(String str, long j, TextRange textRange, Pair pair, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? TextRange.INSTANCE.m20461getZerod9O1mEE() : j, (i & 4) != 0 ? null : textRange, (i & 8) != 0 ? null : pair, null);
    }
}
