package androidx.glance.oneui.common;

import android.content.Context;
import com.google.firebase.messaging.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.CategoryConstants;
import com.samsung.android.visual.p167ai.sdkcommon.image.ImageConst;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000b\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0005J\u001b\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003H\u0080\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0013J\r\u0010\u0015\u001a\u00020\u0003¢\u0006\u0004\b\u0016\u0010\u0005J\u000f\u0010\u0017\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, m13886d2 = {"Landroidx/glance/oneui/common/DisplayDeviceType;", "", ImageConst.PARAM_MODE_WALLPAPER_MASK, "", "constructor-impl", "(I)I", "contains", "", "other", "contains-MTwIW7I", "(II)Z", "equals", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "plus", "displayType", "plus-mBXNS1g", "(II)I", "plus-PMarWA4$glance_oneui_common_release", "toInt", "toInt-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@JvmInline
public final class DisplayDeviceType {
    private final int mask;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int Main = m21591constructorimpl(1);
    private static final int Sub = m21591constructorimpl(2);
    private static final int All = m21591constructorimpl(3);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001b\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0016"}, m13886d2 = {"Landroidx/glance/oneui/common/DisplayDeviceType$Companion;", "", "()V", CategoryConstants.All.DISPLAY_NAME, "Landroidx/glance/oneui/common/DisplayDeviceType;", "getAll-SDhLy5M", "()I", "I", "Main", "getMain-SDhLy5M", "Sub", "getSub-SDhLy5M", Constants.MessagePayloadKeys.FROM, "context", "Landroid/content/Context;", "from-PMarWA4", "(Landroid/content/Context;)I", "get", ImageConst.PARAM_MODE_WALLPAPER_MASK, "", "get-PMarWA4", "(I)I", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: from-PMarWA4, reason: not valid java name */
        public final int m21601fromPMarWA4(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return context.getResources().getConfiguration().semDisplayDeviceType == 0 ? m21604getMainSDhLy5M() : m21605getSubSDhLy5M();
        }

        /* JADX INFO: renamed from: get-PMarWA4, reason: not valid java name */
        public final int m21602getPMarWA4(int mask) {
            return mask != 2 ? m21604getMainSDhLy5M() : m21605getSubSDhLy5M();
        }

        /* JADX INFO: renamed from: getAll-SDhLy5M, reason: not valid java name */
        public final int m21603getAllSDhLy5M() {
            return DisplayDeviceType.All;
        }

        /* JADX INFO: renamed from: getMain-SDhLy5M, reason: not valid java name */
        public final int m21604getMainSDhLy5M() {
            return DisplayDeviceType.Main;
        }

        /* JADX INFO: renamed from: getSub-SDhLy5M, reason: not valid java name */
        public final int m21605getSubSDhLy5M() {
            return DisplayDeviceType.Sub;
        }

        private Companion() {
        }
    }

    private /* synthetic */ DisplayDeviceType(int i) {
        this.mask = i;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ DisplayDeviceType m21590boximpl(int i) {
        return new DisplayDeviceType(i);
    }

    /* JADX INFO: renamed from: contains-MTwIW7I, reason: not valid java name */
    public static final boolean m21592containsMTwIW7I(int i, int i2) {
        return (i2 | i) == i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m21593equalsimpl(int i, Object obj) {
        return (obj instanceof DisplayDeviceType) && i == ((DisplayDeviceType) obj).getMask();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m21594equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m21595hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* JADX INFO: renamed from: plus-mBXNS1g, reason: not valid java name */
    public static final int m21597plusmBXNS1g(int i, int i2) {
        return m21591constructorimpl(i | i2);
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m21599toStringimpl(int i) {
        return i != 2 ? i != 3 ? "main" : "main|sub" : "sub";
    }

    public boolean equals(Object obj) {
        return m21593equalsimpl(this.mask, obj);
    }

    public int hashCode() {
        return m21595hashCodeimpl(this.mask);
    }

    @NotNull
    public String toString() {
        return m21599toStringimpl(this.mask);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getMask() {
        return this.mask;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m21591constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: toInt-impl, reason: not valid java name */
    public static final int m21598toIntimpl(int i) {
        return i;
    }
}
