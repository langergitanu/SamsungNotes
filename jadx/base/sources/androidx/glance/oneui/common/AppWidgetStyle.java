package androidx.glance.oneui.common;

import com.samsung.android.visual.p167ai.sdkcommon.image.ImageConst;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000b\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0005J\u001b\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003H\u0080\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0013J\r\u0010\u0015\u001a\u00020\u0003¢\u0006\u0004\b\u0016\u0010\u0005J\u000f\u0010\u0017\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, m13886d2 = {"Landroidx/glance/oneui/common/AppWidgetStyle;", "", ImageConst.PARAM_MODE_WALLPAPER_MASK, "", "constructor-impl", "(I)I", "contains", "", "other", "contains-zt4u-bU", "(II)Z", "equals", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "plus", "size", "plus-5cHeHeM", "(II)I", "plus-PRK4-rM$glance_oneui_common_release", "toInt", "toInt-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@JvmInline
public final class AppWidgetStyle {
    private final int mask;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int Colorful = m21575constructorimpl(1);
    private static final int Monotone = m21575constructorimpl(2);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001b\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eR\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000f"}, m13886d2 = {"Landroidx/glance/oneui/common/AppWidgetStyle$Companion;", "", "()V", "Colorful", "Landroidx/glance/oneui/common/AppWidgetStyle;", "getColorful-WOdBnnM", "()I", "I", "Monotone", "getMonotone-WOdBnnM", "get", ImageConst.PARAM_MODE_WALLPAPER_MASK, "", "get-PRK4-rM", "(I)I", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: get-PRK4-rM, reason: not valid java name */
        public final int m21585getPRK4rM(int mask) {
            return mask != 2 ? m21586getColorfulWOdBnnM() : m21587getMonotoneWOdBnnM();
        }

        /* JADX INFO: renamed from: getColorful-WOdBnnM, reason: not valid java name */
        public final int m21586getColorfulWOdBnnM() {
            return AppWidgetStyle.Colorful;
        }

        /* JADX INFO: renamed from: getMonotone-WOdBnnM, reason: not valid java name */
        public final int m21587getMonotoneWOdBnnM() {
            return AppWidgetStyle.Monotone;
        }

        private Companion() {
        }
    }

    private /* synthetic */ AppWidgetStyle(int i) {
        this.mask = i;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ AppWidgetStyle m21574boximpl(int i) {
        return new AppWidgetStyle(i);
    }

    /* JADX INFO: renamed from: contains-zt4u-bU, reason: not valid java name */
    public static final boolean m21576containszt4ubU(int i, int i2) {
        return (i2 | i) == i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m21577equalsimpl(int i, Object obj) {
        return (obj instanceof AppWidgetStyle) && i == ((AppWidgetStyle) obj).getMask();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m21578equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m21579hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* JADX INFO: renamed from: plus-5cHeHeM, reason: not valid java name */
    public static final int m21580plus5cHeHeM(int i, int i2) {
        return m21575constructorimpl(i | i2);
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m21583toStringimpl(int i) {
        return i != 2 ? i != 3 ? "colorful" : "colorful|monotone" : "monotone";
    }

    public boolean equals(Object obj) {
        return m21577equalsimpl(this.mask, obj);
    }

    public int hashCode() {
        return m21579hashCodeimpl(this.mask);
    }

    @NotNull
    public String toString() {
        return m21583toStringimpl(this.mask);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getMask() {
        return this.mask;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m21575constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: toInt-impl, reason: not valid java name */
    public static final int m21582toIntimpl(int i) {
        return i;
    }
}
