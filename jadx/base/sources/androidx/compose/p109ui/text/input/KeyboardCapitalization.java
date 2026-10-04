package androidx.compose.p109ui.text.input;

import androidx.compose.runtime.Stable;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012"}, m13886d2 = {"Landroidx/compose/ui/text/input/KeyboardCapitalization;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@JvmInline
public final class KeyboardCapitalization {
    private final int value;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int Unspecified = m20654constructorimpl(-1);
    private static final int None = m20654constructorimpl(0);
    private static final int Characters = m20654constructorimpl(1);
    private static final int Words = m20654constructorimpl(2);
    private static final int Sentences = m20654constructorimpl(3);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R$\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\u0007R$\u0010\f\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u0007R$\u0010\u000f\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0010\u0010\u0002\u001a\u0004\b\u0011\u0010\u0007R$\u0010\u0012\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0013\u0010\u0002\u001a\u0004\b\u0014\u0010\u0007\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0015"}, m13886d2 = {"Landroidx/compose/ui/text/input/KeyboardCapitalization$Companion;", "", "()V", "Characters", "Landroidx/compose/ui/text/input/KeyboardCapitalization;", "getCharacters-IUNYP9k$annotations", "getCharacters-IUNYP9k", "()I", "I", "None", "getNone-IUNYP9k$annotations", "getNone-IUNYP9k", "Sentences", "getSentences-IUNYP9k$annotations", "getSentences-IUNYP9k", "Unspecified", "getUnspecified-IUNYP9k$annotations", "getUnspecified-IUNYP9k", "Words", "getWords-IUNYP9k$annotations", "getWords-IUNYP9k", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: getCharacters-IUNYP9k, reason: not valid java name */
        public final int m20665getCharactersIUNYP9k() {
            return KeyboardCapitalization.Characters;
        }

        /* JADX INFO: renamed from: getNone-IUNYP9k, reason: not valid java name */
        public final int m20666getNoneIUNYP9k() {
            return KeyboardCapitalization.None;
        }

        /* JADX INFO: renamed from: getSentences-IUNYP9k, reason: not valid java name */
        public final int m20667getSentencesIUNYP9k() {
            return KeyboardCapitalization.Sentences;
        }

        /* JADX INFO: renamed from: getUnspecified-IUNYP9k, reason: not valid java name */
        public final int m20668getUnspecifiedIUNYP9k() {
            return KeyboardCapitalization.Unspecified;
        }

        /* JADX INFO: renamed from: getWords-IUNYP9k, reason: not valid java name */
        public final int m20669getWordsIUNYP9k() {
            return KeyboardCapitalization.Words;
        }

        private Companion() {
        }

        @Stable
        /* JADX INFO: renamed from: getCharacters-IUNYP9k$annotations, reason: not valid java name */
        public static /* synthetic */ void m20660getCharactersIUNYP9k$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getNone-IUNYP9k$annotations, reason: not valid java name */
        public static /* synthetic */ void m20661getNoneIUNYP9k$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getSentences-IUNYP9k$annotations, reason: not valid java name */
        public static /* synthetic */ void m20662getSentencesIUNYP9k$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getUnspecified-IUNYP9k$annotations, reason: not valid java name */
        public static /* synthetic */ void m20663getUnspecifiedIUNYP9k$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getWords-IUNYP9k$annotations, reason: not valid java name */
        public static /* synthetic */ void m20664getWordsIUNYP9k$annotations() {
        }
    }

    private /* synthetic */ KeyboardCapitalization(int i) {
        this.value = i;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ KeyboardCapitalization m20653boximpl(int i) {
        return new KeyboardCapitalization(i);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m20655equalsimpl(int i, Object obj) {
        return (obj instanceof KeyboardCapitalization) && i == ((KeyboardCapitalization) obj).getValue();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m20656equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m20657hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m20658toStringimpl(int i) {
        return m20656equalsimpl0(i, Unspecified) ? "Unspecified" : m20656equalsimpl0(i, None) ? "None" : m20656equalsimpl0(i, Characters) ? "Characters" : m20656equalsimpl0(i, Words) ? "Words" : m20656equalsimpl0(i, Sentences) ? "Sentences" : "Invalid";
    }

    public boolean equals(Object obj) {
        return m20655equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m20657hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m20658toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m20654constructorimpl(int i) {
        return i;
    }
}
