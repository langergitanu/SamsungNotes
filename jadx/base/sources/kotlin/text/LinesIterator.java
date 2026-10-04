package kotlin.text;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\f\u001a\u00020\rH\u0096\u0002J\t\u0010\u000e\u001a\u00020\u0002H\u0096\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m13886d2 = {"Lkotlin/text/LinesIterator;", "", "", "string", "", "<init>", "(Ljava/lang/CharSequence;)V", "state", "", "tokenStartIndex", "delimiterStartIndex", "delimiterLength", "hasNext", "", "next", "State", "kotlin-stdlib"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
final class LinesIterator implements Iterator<String>, KMappedMarker {

    @Deprecated
    public static final int EXHAUSTED = 2;

    @Deprecated
    public static final int HAS_NEXT = 1;

    @NotNull
    private static final State State = new State(null);

    @Deprecated
    public static final int UNKNOWN = 0;
    private int delimiterLength;
    private int delimiterStartIndex;
    private int state;

    @NotNull
    private final CharSequence string;
    private int tokenStartIndex;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, m13886d2 = {"Lkotlin/text/LinesIterator$State;", "", "<init>", "()V", "UNKNOWN", "", "HAS_NEXT", "EXHAUSTED", "kotlin-stdlib"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class State {
        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private State() {
        }
    }

    public LinesIterator(@NotNull CharSequence string) {
        Intrinsics.checkNotNullParameter(string, "string");
        this.string = string;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        int i;
        int i2;
        int i4 = this.state;
        if (i4 != 0) {
            return i4 == 1;
        }
        if (this.delimiterLength < 0) {
            this.state = 2;
            return false;
        }
        int length = this.string.length();
        int length2 = this.string.length();
        for (int i5 = this.tokenStartIndex; i5 < length2; i5++) {
            char cCharAt = this.string.charAt(i5);
            if (cCharAt == '\n' || cCharAt == '\r') {
                i = (cCharAt == '\r' && (i2 = i5 + 1) < this.string.length() && this.string.charAt(i2) == '\n') ? 2 : 1;
                length = i5;
                this.state = 1;
                this.delimiterLength = i;
                this.delimiterStartIndex = length;
                return true;
            }
        }
        i = -1;
        this.state = 1;
        this.delimiterLength = i;
        this.delimiterStartIndex = length;
        return true;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    @NotNull
    public String next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.state = 0;
        int i = this.delimiterStartIndex;
        int i2 = this.tokenStartIndex;
        this.tokenStartIndex = this.delimiterLength + i;
        return this.string.subSequence(i2, i).toString();
    }
}
