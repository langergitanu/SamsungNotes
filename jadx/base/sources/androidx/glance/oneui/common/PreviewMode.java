package androidx.glance.oneui.common;

import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.visual.p167ai.sdkcommon.image.ImageConst;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012"}, m13886d2 = {"Landroidx/glance/oneui/common/PreviewMode;", "", ImageConst.PARAM_MODE_WALLPAPER_MASK, "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@JvmInline
public final class PreviewMode {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int Default = m21607constructorimpl(0);
    private static final int Dummy = m21607constructorimpl(1);
    private final int mask;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\n"}, m13886d2 = {"Landroidx/glance/oneui/common/PreviewMode$Companion;", "", "()V", AuthenticationConstants.Broker.ACCOUNT_DEFAULT_NAME, "Landroidx/glance/oneui/common/PreviewMode;", "getDefault-BmZA40c", "()I", "I", CoeditServiceConstants.Attribute.VALUE_DUMMY, "getDummy-BmZA40c", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: getDefault-BmZA40c, reason: not valid java name */
        public final int m21613getDefaultBmZA40c() {
            return PreviewMode.Default;
        }

        /* JADX INFO: renamed from: getDummy-BmZA40c, reason: not valid java name */
        public final int m21614getDummyBmZA40c() {
            return PreviewMode.Dummy;
        }

        private Companion() {
        }
    }

    private /* synthetic */ PreviewMode(int i) {
        this.mask = i;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ PreviewMode m21606boximpl(int i) {
        return new PreviewMode(i);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m21608equalsimpl(int i, Object obj) {
        return (obj instanceof PreviewMode) && i == ((PreviewMode) obj).getMask();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m21609equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m21610hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m21611toStringimpl(int i) {
        return i == Default ? AuthenticationConstants.Broker.ACCOUNT_DEFAULT_NAME : i == Dummy ? CoeditServiceConstants.Attribute.VALUE_DUMMY : "Unknown";
    }

    public boolean equals(Object obj) {
        return m21608equalsimpl(this.mask, obj);
    }

    public int hashCode() {
        return m21610hashCodeimpl(this.mask);
    }

    @NotNull
    public String toString() {
        return m21611toStringimpl(this.mask);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getMask() {
        return this.mask;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m21607constructorimpl(int i) {
        return i;
    }
}
