package androidx.compose.p109ui.text.input;

import androidx.compose.runtime.Stable;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012"}, m13886d2 = {"Landroidx/compose/ui/text/input/ImeAction;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@JvmInline
public final class ImeAction {
    private final int value;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int Unspecified = m20618constructorimpl(-1);
    private static final int Default = m20618constructorimpl(1);
    private static final int None = m20618constructorimpl(0);

    /* JADX INFO: renamed from: Go */
    private static final int f1199Go = m20618constructorimpl(2);
    private static final int Search = m20618constructorimpl(3);
    private static final int Send = m20618constructorimpl(4);
    private static final int Previous = m20618constructorimpl(5);
    private static final int Next = m20618constructorimpl(6);
    private static final int Done = m20618constructorimpl(7);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R$\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\u0007R$\u0010\f\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u0007R$\u0010\u000f\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0010\u0010\u0002\u001a\u0004\b\u0011\u0010\u0007R$\u0010\u0012\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0013\u0010\u0002\u001a\u0004\b\u0014\u0010\u0007R$\u0010\u0015\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0016\u0010\u0002\u001a\u0004\b\u0017\u0010\u0007R$\u0010\u0018\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0019\u0010\u0002\u001a\u0004\b\u001a\u0010\u0007R$\u0010\u001b\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u001c\u0010\u0002\u001a\u0004\b\u001d\u0010\u0007R$\u0010\u001e\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u001f\u0010\u0002\u001a\u0004\b \u0010\u0007\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006!"}, m13886d2 = {"Landroidx/compose/ui/text/input/ImeAction$Companion;", "", "()V", AuthenticationConstants.Broker.ACCOUNT_DEFAULT_NAME, "Landroidx/compose/ui/text/input/ImeAction;", "getDefault-eUduSuo$annotations", "getDefault-eUduSuo", "()I", "I", "Done", "getDone-eUduSuo$annotations", "getDone-eUduSuo", "Go", "getGo-eUduSuo$annotations", "getGo-eUduSuo", "Next", "getNext-eUduSuo$annotations", "getNext-eUduSuo", "None", "getNone-eUduSuo$annotations", "getNone-eUduSuo", "Previous", "getPrevious-eUduSuo$annotations", "getPrevious-eUduSuo", "Search", "getSearch-eUduSuo$annotations", "getSearch-eUduSuo", "Send", "getSend-eUduSuo$annotations", "getSend-eUduSuo", "Unspecified", "getUnspecified-eUduSuo$annotations", "getUnspecified-eUduSuo", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: getDefault-eUduSuo, reason: not valid java name */
        public final int m20633getDefaulteUduSuo() {
            return ImeAction.Default;
        }

        /* JADX INFO: renamed from: getDone-eUduSuo, reason: not valid java name */
        public final int m20634getDoneeUduSuo() {
            return ImeAction.Done;
        }

        /* JADX INFO: renamed from: getGo-eUduSuo, reason: not valid java name */
        public final int m20635getGoeUduSuo() {
            return ImeAction.f1199Go;
        }

        /* JADX INFO: renamed from: getNext-eUduSuo, reason: not valid java name */
        public final int m20636getNexteUduSuo() {
            return ImeAction.Next;
        }

        /* JADX INFO: renamed from: getNone-eUduSuo, reason: not valid java name */
        public final int m20637getNoneeUduSuo() {
            return ImeAction.None;
        }

        /* JADX INFO: renamed from: getPrevious-eUduSuo, reason: not valid java name */
        public final int m20638getPreviouseUduSuo() {
            return ImeAction.Previous;
        }

        /* JADX INFO: renamed from: getSearch-eUduSuo, reason: not valid java name */
        public final int m20639getSearcheUduSuo() {
            return ImeAction.Search;
        }

        /* JADX INFO: renamed from: getSend-eUduSuo, reason: not valid java name */
        public final int m20640getSendeUduSuo() {
            return ImeAction.Send;
        }

        /* JADX INFO: renamed from: getUnspecified-eUduSuo, reason: not valid java name */
        public final int m20641getUnspecifiedeUduSuo() {
            return ImeAction.Unspecified;
        }

        private Companion() {
        }

        @Stable
        /* JADX INFO: renamed from: getDefault-eUduSuo$annotations, reason: not valid java name */
        public static /* synthetic */ void m20624getDefaulteUduSuo$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getDone-eUduSuo$annotations, reason: not valid java name */
        public static /* synthetic */ void m20625getDoneeUduSuo$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getGo-eUduSuo$annotations, reason: not valid java name */
        public static /* synthetic */ void m20626getGoeUduSuo$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getNext-eUduSuo$annotations, reason: not valid java name */
        public static /* synthetic */ void m20627getNexteUduSuo$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getNone-eUduSuo$annotations, reason: not valid java name */
        public static /* synthetic */ void m20628getNoneeUduSuo$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getPrevious-eUduSuo$annotations, reason: not valid java name */
        public static /* synthetic */ void m20629getPreviouseUduSuo$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getSearch-eUduSuo$annotations, reason: not valid java name */
        public static /* synthetic */ void m20630getSearcheUduSuo$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getSend-eUduSuo$annotations, reason: not valid java name */
        public static /* synthetic */ void m20631getSendeUduSuo$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getUnspecified-eUduSuo$annotations, reason: not valid java name */
        public static /* synthetic */ void m20632getUnspecifiedeUduSuo$annotations() {
        }
    }

    private /* synthetic */ ImeAction(int i) {
        this.value = i;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ImeAction m20617boximpl(int i) {
        return new ImeAction(i);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m20619equalsimpl(int i, Object obj) {
        return (obj instanceof ImeAction) && i == ((ImeAction) obj).getValue();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m20620equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m20621hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m20622toStringimpl(int i) {
        return m20620equalsimpl0(i, Unspecified) ? "Unspecified" : m20620equalsimpl0(i, None) ? "None" : m20620equalsimpl0(i, Default) ? AuthenticationConstants.Broker.ACCOUNT_DEFAULT_NAME : m20620equalsimpl0(i, f1199Go) ? "Go" : m20620equalsimpl0(i, Search) ? "Search" : m20620equalsimpl0(i, Send) ? "Send" : m20620equalsimpl0(i, Previous) ? "Previous" : m20620equalsimpl0(i, Next) ? "Next" : m20620equalsimpl0(i, Done) ? "Done" : "Invalid";
    }

    public boolean equals(Object obj) {
        return m20619equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m20621hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m20622toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m20618constructorimpl(int i) {
        return i;
    }
}
