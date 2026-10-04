package androidx.glance.oneui.common;

import com.samsung.android.support.senl.p148nt.data.common.constants.CategoryConstants;
import com.samsung.android.visual.p167ai.sdkcommon.image.ImageConst;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000b\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0005J\u001b\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003H\u0080\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0013J\r\u0010\u0015\u001a\u00020\u0003¢\u0006\u0004\b\u0016\u0010\u0005J\u000f\u0010\u0017\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, m13886d2 = {"Landroidx/glance/oneui/common/AppWidgetHostType;", "", ImageConst.PARAM_MODE_WALLPAPER_MASK, "", "constructor-impl", "(I)I", "contains", "", "other", "contains-RLJl_S0", "(II)Z", "equals", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "plus", "type", "plus-hRCFbmQ", "(II)I", "plus-bBfPHyc$glance_oneui_common_release", "toInt", "toInt-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@JvmInline
@SourceDebugExtension({"SMAP\nAppWidgetFeatures.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppWidgetFeatures.kt\nandroidx/glance/oneui/common/AppWidgetHostType\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,386:1\n1789#2,3:387\n1#3:390\n*S KotlinDebug\n*F\n+ 1 AppWidgetFeatures.kt\nandroidx/glance/oneui/common/AppWidgetHostType\n*L\n275#1:387,3\n*E\n"})
public final class AppWidgetHostType {
    private static final int All;
    private static final int Cover;
    private static final int DexHome;
    private static final int Home;
    private static final int LockAndAOD;
    private final int mask;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int Unknown = m21521constructorimpl(0);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001b\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u0019\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u0019\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000f\u0010\u0006R\u0019\u0010\u0010\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0011\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0017"}, m13886d2 = {"Landroidx/glance/oneui/common/AppWidgetHostType$Companion;", "", "()V", CategoryConstants.All.DISPLAY_NAME, "Landroidx/glance/oneui/common/AppWidgetHostType;", "getAll-mn_SBp8", "()I", "I", "Cover", "getCover-mn_SBp8", "DexHome", "getDexHome-mn_SBp8", "Home", "getHome-mn_SBp8", "LockAndAOD", "getLockAndAOD-mn_SBp8", "Unknown", "getUnknown-mn_SBp8", "get", ImageConst.PARAM_MODE_WALLPAPER_MASK, "", "get-bBfPHyc", "(I)I", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: get-bBfPHyc, reason: not valid java name */
        public final int m21531getbBfPHyc(int mask) {
            return mask == m21535getHomemn_SBp8() ? m21535getHomemn_SBp8() : mask == m21536getLockAndAODmn_SBp8() ? m21536getLockAndAODmn_SBp8() : mask == m21533getCovermn_SBp8() ? m21533getCovermn_SBp8() : mask == m21534getDexHomemn_SBp8() ? m21534getDexHomemn_SBp8() : m21537getUnknownmn_SBp8();
        }

        /* JADX INFO: renamed from: getAll-mn_SBp8, reason: not valid java name */
        public final int m21532getAllmn_SBp8() {
            return AppWidgetHostType.All;
        }

        /* JADX INFO: renamed from: getCover-mn_SBp8, reason: not valid java name */
        public final int m21533getCovermn_SBp8() {
            return AppWidgetHostType.Cover;
        }

        /* JADX INFO: renamed from: getDexHome-mn_SBp8, reason: not valid java name */
        public final int m21534getDexHomemn_SBp8() {
            return AppWidgetHostType.DexHome;
        }

        /* JADX INFO: renamed from: getHome-mn_SBp8, reason: not valid java name */
        public final int m21535getHomemn_SBp8() {
            return AppWidgetHostType.Home;
        }

        /* JADX INFO: renamed from: getLockAndAOD-mn_SBp8, reason: not valid java name */
        public final int m21536getLockAndAODmn_SBp8() {
            return AppWidgetHostType.LockAndAOD;
        }

        /* JADX INFO: renamed from: getUnknown-mn_SBp8, reason: not valid java name */
        public final int m21537getUnknownmn_SBp8() {
            return AppWidgetHostType.Unknown;
        }

        private Companion() {
        }
    }

    static {
        int mask = 0;
        int iM21521constructorimpl = m21521constructorimpl(1);
        Home = iM21521constructorimpl;
        int iM21521constructorimpl2 = m21521constructorimpl(2);
        LockAndAOD = iM21521constructorimpl2;
        int iM21521constructorimpl3 = m21521constructorimpl(4);
        Cover = iM21521constructorimpl3;
        int iM21521constructorimpl4 = m21521constructorimpl(16);
        DexHome = iM21521constructorimpl4;
        Iterator it = CollectionsKt.listOf((Object[]) new AppWidgetHostType[]{m21520boximpl(iM21521constructorimpl), m21520boximpl(iM21521constructorimpl2), m21520boximpl(iM21521constructorimpl3), m21520boximpl(iM21521constructorimpl4)}).iterator();
        while (it.hasNext()) {
            mask |= ((AppWidgetHostType) it.next()).getMask();
        }
        All = m21521constructorimpl(mask);
    }

    private /* synthetic */ AppWidgetHostType(int i) {
        this.mask = i;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ AppWidgetHostType m21520boximpl(int i) {
        return new AppWidgetHostType(i);
    }

    /* JADX INFO: renamed from: contains-RLJl_S0, reason: not valid java name */
    public static final boolean m21522containsRLJl_S0(int i, int i2) {
        return (i2 | i) == i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m21523equalsimpl(int i, Object obj) {
        return (obj instanceof AppWidgetHostType) && i == ((AppWidgetHostType) obj).getMask();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m21524equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m21525hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* JADX INFO: renamed from: plus-hRCFbmQ, reason: not valid java name */
    public static final int m21527plushRCFbmQ(int i, int i2) {
        return m21521constructorimpl(i | i2);
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m21529toStringimpl(int i) {
        return i == Home ? "Home" : i == LockAndAOD ? "LockAndAOD" : i == Cover ? "Cover" : i == DexHome ? "DexHome" : "Unknown";
    }

    public boolean equals(Object obj) {
        return m21523equalsimpl(this.mask, obj);
    }

    public int hashCode() {
        return m21525hashCodeimpl(this.mask);
    }

    @NotNull
    public String toString() {
        return m21529toStringimpl(this.mask);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getMask() {
        return this.mask;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m21521constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: toInt-impl, reason: not valid java name */
    public static final int m21528toIntimpl(int i) {
        return i;
    }
}
