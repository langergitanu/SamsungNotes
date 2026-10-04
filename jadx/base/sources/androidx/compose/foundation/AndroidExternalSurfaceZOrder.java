package androidx.compose.foundation;

import androidx.collection.AbstractC0622a;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0014"}, m13886d2 = {"Landroidx/compose/foundation/AndroidExternalSurfaceZOrder;", "", "zOrder", "", "constructor-impl", "(I)I", "getZOrder", "()I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@JvmInline
public final class AndroidExternalSurfaceZOrder {
    private final int zOrder;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int Behind = m15397constructorimpl(0);
    private static final int MediaOverlay = m15397constructorimpl(1);
    private static final int OnTop = m15397constructorimpl(2);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\f"}, m13886d2 = {"Landroidx/compose/foundation/AndroidExternalSurfaceZOrder$Companion;", "", "()V", "Behind", "Landroidx/compose/foundation/AndroidExternalSurfaceZOrder;", "getBehind-B_4ceCc", "()I", "I", "MediaOverlay", "getMediaOverlay-B_4ceCc", "OnTop", "getOnTop-B_4ceCc", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: getBehind-B_4ceCc, reason: not valid java name */
        public final int m15403getBehindB_4ceCc() {
            return AndroidExternalSurfaceZOrder.Behind;
        }

        /* JADX INFO: renamed from: getMediaOverlay-B_4ceCc, reason: not valid java name */
        public final int m15404getMediaOverlayB_4ceCc() {
            return AndroidExternalSurfaceZOrder.MediaOverlay;
        }

        /* JADX INFO: renamed from: getOnTop-B_4ceCc, reason: not valid java name */
        public final int m15405getOnTopB_4ceCc() {
            return AndroidExternalSurfaceZOrder.OnTop;
        }

        private Companion() {
        }
    }

    private /* synthetic */ AndroidExternalSurfaceZOrder(int i) {
        this.zOrder = i;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ AndroidExternalSurfaceZOrder m15396boximpl(int i) {
        return new AndroidExternalSurfaceZOrder(i);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m15398equalsimpl(int i, Object obj) {
        return (obj instanceof AndroidExternalSurfaceZOrder) && i == ((AndroidExternalSurfaceZOrder) obj).m15402unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m15399equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m15400hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m15401toStringimpl(int i) {
        return AbstractC0622a.m1167m("AndroidExternalSurfaceZOrder(zOrder=", i, PropertyUtils.MAPPED_DELIM2);
    }

    public boolean equals(Object obj) {
        return m15398equalsimpl(this.zOrder, obj);
    }

    public final int getZOrder() {
        return this.zOrder;
    }

    public int hashCode() {
        return m15400hashCodeimpl(this.zOrder);
    }

    public String toString() {
        return m15401toStringimpl(this.zOrder);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m15402unboximpl() {
        return this.zOrder;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m15397constructorimpl(int i) {
        return i;
    }
}
