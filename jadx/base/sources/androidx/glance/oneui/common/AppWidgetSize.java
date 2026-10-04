package androidx.glance.oneui.common;

import android.content.Context;
import android.graphics.Point;
import android.util.Size;
import com.google.firebase.messaging.Constants;
import com.samsung.android.app.notes.widget.common.constants.WidgetConstant;
import com.samsung.android.support.senl.p148nt.data.common.constants.CategoryConstants;
import com.samsung.android.visual.p167ai.sdkcommon.image.ImageConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 /2\u00020\u0001:\u0001/B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u000f\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0005J\u001b\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\tJ\u001b\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\tJ\u001e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003H\u0080\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\tJ\u001d\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00000\u001bj\b\u0012\u0004\u0012\u00020\u0000`\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0007¢\u0006\u0004\b#\u0010$J\r\u0010%\u001a\u00020\u0003¢\u0006\u0004\b&\u0010\u0005J\u0015\u0010'\u001a\u00020(2\u0006\u0010!\u001a\u00020\"¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020,H\u0016¢\u0006\u0004\b-\u0010.R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00060"}, m13886d2 = {"Landroidx/glance/oneui/common/AppWidgetSize;", "", ImageConst.PARAM_MODE_WALLPAPER_MASK, "", "constructor-impl", "(I)I", "compareTo", "a", "compareTo-L2j3NV4", "(II)I", "contains", "", "other", "contains-L2j3NV4", "(II)Z", "equals", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "minus", "size", "minus-8PP4PnY", "plus", "plus-8PP4PnY", "plus-IQT_O7U$glance_oneui_common_release", "toArrayList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "toArrayList-impl", "(I)Ljava/util/ArrayList;", "toCell", "Landroid/util/Size;", "context", "Landroid/content/Context;", "toCell-impl", "(ILandroid/content/Context;)Landroid/util/Size;", "toInt", "toInt-impl", "toSpan", "Landroid/graphics/Point;", "toSpan-impl", "(ILandroid/content/Context;)Landroid/graphics/Point;", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@JvmInline
public final class AppWidgetSize {
    private static final int All;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final int ExtraLarge;
    private static final int ExtraLargeLong;
    private static final int Large;
    private static final int Medium;
    private static final int Small;
    private static final int Tiny;
    private static final int Unknown;
    private static final int WideSmall;
    private final int mask;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u0018\u001a\u00020\u00042\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u001aø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ+\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$J\u001b\u0010\u001d\u001a\u00020\u00042\u0006\u0010%\u001a\u00020!ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b&\u0010'J\u001b\u0010\u001d\u001a\u00020\u00042\u0006\u0010(\u001a\u00020)ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b&\u0010*R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u0019\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u0019\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000f\u0010\u0006R\u0019\u0010\u0010\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0011\u0010\u0006R\u0019\u0010\u0012\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0013\u0010\u0006R\u0019\u0010\u0014\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0015\u0010\u0006R\u0019\u0010\u0016\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0017\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006+"}, m13886d2 = {"Landroidx/glance/oneui/common/AppWidgetSize$Companion;", "", "()V", CategoryConstants.All.DISPLAY_NAME, "Landroidx/glance/oneui/common/AppWidgetSize;", "getAll-rx25Pp4", "()I", "I", "ExtraLarge", "getExtraLarge-rx25Pp4", "ExtraLargeLong", "getExtraLargeLong-rx25Pp4", "Large", "getLarge-rx25Pp4", "Medium", "getMedium-rx25Pp4", "Small", "getSmall-rx25Pp4", "Tiny", "getTiny-rx25Pp4", "Unknown", "getUnknown-rx25Pp4", "WideSmall", "getWideSmall-rx25Pp4", "combine", "sizes", "", "combine-IQT_O7U", "(Ljava/util/List;)I", "get", "context", "Landroid/content/Context;", WidgetConstant.WIDGET_SAMSUNG_SPAN_X, "", WidgetConstant.WIDGET_SAMSUNG_SPAN_Y, "get-Kiq_Kzg", "(Landroid/content/Context;II)I", ImageConst.PARAM_MODE_WALLPAPER_MASK, "get-IQT_O7U", "(I)I", "str", "", "(Ljava/lang/String;)I", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nAppWidgetFeatures.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppWidgetFeatures.kt\nandroidx/glance/oneui/common/AppWidgetSize$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,386:1\n1789#2,3:387\n*S KotlinDebug\n*F\n+ 1 AppWidgetFeatures.kt\nandroidx/glance/oneui/common/AppWidgetSize$Companion\n*L\n33#1:387,3\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: combine-IQT_O7U, reason: not valid java name */
        public final int m21561combineIQT_O7U(@NotNull List<AppWidgetSize> sizes) {
            Intrinsics.checkNotNullParameter(sizes, "sizes");
            Iterator<T> it = sizes.iterator();
            int mask = 0;
            while (it.hasNext()) {
                mask |= ((AppWidgetSize) it.next()).getMask();
            }
            return AppWidgetSize.m21547constructorimpl(mask);
        }

        /* JADX INFO: renamed from: get-IQT_O7U, reason: not valid java name */
        public final int m21562getIQT_O7U(int mask) {
            return mask == m21571getTinyrx25Pp4() ? m21571getTinyrx25Pp4() : mask == m21570getSmallrx25Pp4() ? m21570getSmallrx25Pp4() : mask == m21573getWideSmallrx25Pp4() ? m21573getWideSmallrx25Pp4() : mask == m21569getMediumrx25Pp4() ? m21569getMediumrx25Pp4() : mask == m21568getLargerx25Pp4() ? m21568getLargerx25Pp4() : mask == m21566getExtraLargerx25Pp4() ? m21566getExtraLargerx25Pp4() : mask == m21567getExtraLargeLongrx25Pp4() ? m21567getExtraLargeLongrx25Pp4() : m21572getUnknownrx25Pp4();
        }

        /* JADX INFO: renamed from: get-Kiq_Kzg, reason: not valid java name */
        public final int m21564getKiq_Kzg(@NotNull Context context, int spanX, int spanY) {
            Intrinsics.checkNotNullParameter(context, "context");
            return spanY != 1 ? spanY != 2 ? spanY != 4 ? spanY != 6 ? m21572getUnknownrx25Pp4() : (spanX == 4 && context.getResources().getConfiguration().orientation == 1) ? m21567getExtraLargeLongrx25Pp4() : m21572getUnknownrx25Pp4() : spanX == 4 ? m21566getExtraLargerx25Pp4() : (spanX == 6 && context.getResources().getConfiguration().orientation == 2) ? m21567getExtraLargeLongrx25Pp4() : m21572getUnknownrx25Pp4() : spanX != 2 ? spanX != 4 ? m21572getUnknownrx25Pp4() : m21568getLargerx25Pp4() : m21569getMediumrx25Pp4() : spanX != 1 ? spanX != 2 ? spanX != 4 ? m21572getUnknownrx25Pp4() : m21573getWideSmallrx25Pp4() : m21570getSmallrx25Pp4() : m21571getTinyrx25Pp4();
        }

        /* JADX INFO: renamed from: getAll-rx25Pp4, reason: not valid java name */
        public final int m21565getAllrx25Pp4() {
            return AppWidgetSize.All;
        }

        /* JADX INFO: renamed from: getExtraLarge-rx25Pp4, reason: not valid java name */
        public final int m21566getExtraLargerx25Pp4() {
            return AppWidgetSize.ExtraLarge;
        }

        /* JADX INFO: renamed from: getExtraLargeLong-rx25Pp4, reason: not valid java name */
        public final int m21567getExtraLargeLongrx25Pp4() {
            return AppWidgetSize.ExtraLargeLong;
        }

        /* JADX INFO: renamed from: getLarge-rx25Pp4, reason: not valid java name */
        public final int m21568getLargerx25Pp4() {
            return AppWidgetSize.Large;
        }

        /* JADX INFO: renamed from: getMedium-rx25Pp4, reason: not valid java name */
        public final int m21569getMediumrx25Pp4() {
            return AppWidgetSize.Medium;
        }

        /* JADX INFO: renamed from: getSmall-rx25Pp4, reason: not valid java name */
        public final int m21570getSmallrx25Pp4() {
            return AppWidgetSize.Small;
        }

        /* JADX INFO: renamed from: getTiny-rx25Pp4, reason: not valid java name */
        public final int m21571getTinyrx25Pp4() {
            return AppWidgetSize.Tiny;
        }

        /* JADX INFO: renamed from: getUnknown-rx25Pp4, reason: not valid java name */
        public final int m21572getUnknownrx25Pp4() {
            return AppWidgetSize.Unknown;
        }

        /* JADX INFO: renamed from: getWideSmall-rx25Pp4, reason: not valid java name */
        public final int m21573getWideSmallrx25Pp4() {
            return AppWidgetSize.WideSmall;
        }

        private Companion() {
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX INFO: renamed from: get-IQT_O7U, reason: not valid java name */
        public final int m21563getIQT_O7U(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "str");
            switch (str.hashCode()) {
                case -1078030475:
                    if (str.equals(Constants.ScionAnalytics.PARAM_MEDIUM)) {
                        return m21569getMediumrx25Pp4();
                    }
                    break;
                case -470076908:
                    if (str.equals("widesmall")) {
                        return m21573getWideSmallrx25Pp4();
                    }
                    break;
                case 3560192:
                    if (str.equals("tiny")) {
                        return m21571getTinyrx25Pp4();
                    }
                    break;
                case 102742843:
                    if (str.equals("large")) {
                        return m21568getLargerx25Pp4();
                    }
                    break;
                case 109548807:
                    if (str.equals("small")) {
                        return m21570getSmallrx25Pp4();
                    }
                    break;
                case 759312683:
                    if (str.equals("extralarge")) {
                        return m21566getExtraLargerx25Pp4();
                    }
                    break;
                case 1901226535:
                    if (str.equals("extralargelong")) {
                        return m21567getExtraLargeLongrx25Pp4();
                    }
                    break;
            }
            return m21572getUnknownrx25Pp4();
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        Unknown = m21547constructorimpl(0);
        int iM21547constructorimpl = m21547constructorimpl(1);
        Tiny = iM21547constructorimpl;
        int iM21547constructorimpl2 = m21547constructorimpl(2);
        Small = iM21547constructorimpl2;
        int iM21547constructorimpl3 = m21547constructorimpl(4);
        WideSmall = iM21547constructorimpl3;
        int iM21547constructorimpl4 = m21547constructorimpl(8);
        Medium = iM21547constructorimpl4;
        int iM21547constructorimpl5 = m21547constructorimpl(16);
        Large = iM21547constructorimpl5;
        int iM21547constructorimpl6 = m21547constructorimpl(32);
        ExtraLarge = iM21547constructorimpl6;
        int iM21547constructorimpl7 = m21547constructorimpl(64);
        ExtraLargeLong = iM21547constructorimpl7;
        All = companion.m21561combineIQT_O7U(CollectionsKt.listOf((Object[]) new AppWidgetSize[]{m21545boximpl(iM21547constructorimpl), m21545boximpl(iM21547constructorimpl2), m21545boximpl(iM21547constructorimpl3), m21545boximpl(iM21547constructorimpl4), m21545boximpl(iM21547constructorimpl5), m21545boximpl(iM21547constructorimpl6), m21545boximpl(iM21547constructorimpl7)}));
    }

    private /* synthetic */ AppWidgetSize(int i) {
        this.mask = i;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ AppWidgetSize m21545boximpl(int i) {
        return new AppWidgetSize(i);
    }

    /* JADX INFO: renamed from: compareTo-L2j3NV4, reason: not valid java name */
    public static final int m21546compareToL2j3NV4(int i, int i2) {
        if (i > i2) {
            return 1;
        }
        return i < i2 ? -1 : 0;
    }

    /* JADX INFO: renamed from: contains-L2j3NV4, reason: not valid java name */
    public static final boolean m21548containsL2j3NV4(int i, int i2) {
        return (i2 | i) == i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m21549equalsimpl(int i, Object obj) {
        return (obj instanceof AppWidgetSize) && i == ((AppWidgetSize) obj).getMask();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m21550equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m21551hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* JADX INFO: renamed from: minus-8PP4PnY, reason: not valid java name */
    public static final int m21552minus8PP4PnY(int i, int i2) {
        return m21547constructorimpl(i & (~i2));
    }

    /* JADX INFO: renamed from: plus-8PP4PnY, reason: not valid java name */
    public static final int m21553plus8PP4PnY(int i, int i2) {
        return m21547constructorimpl(i | i2);
    }

    @NotNull
    /* JADX INFO: renamed from: toArrayList-impl, reason: not valid java name */
    public static final ArrayList<AppWidgetSize> m21555toArrayListimpl(int i) {
        ArrayList<AppWidgetSize> arrayList = new ArrayList<>();
        int i2 = Tiny;
        if (AppWidgetFeaturesKt.m21519containsCZRyut0(i, i2)) {
            arrayList.add(m21545boximpl(i2));
        }
        int i4 = Small;
        if (AppWidgetFeaturesKt.m21519containsCZRyut0(i, i4)) {
            arrayList.add(m21545boximpl(i4));
        }
        int i5 = WideSmall;
        if (AppWidgetFeaturesKt.m21519containsCZRyut0(i, i5)) {
            arrayList.add(m21545boximpl(i5));
        }
        int i6 = Medium;
        if (AppWidgetFeaturesKt.m21519containsCZRyut0(i, i6)) {
            arrayList.add(m21545boximpl(i6));
        }
        int i7 = Large;
        if (AppWidgetFeaturesKt.m21519containsCZRyut0(i, i7)) {
            arrayList.add(m21545boximpl(i7));
        }
        int i8 = ExtraLarge;
        if (AppWidgetFeaturesKt.m21519containsCZRyut0(i, i8)) {
            arrayList.add(m21545boximpl(i8));
        }
        int i9 = ExtraLargeLong;
        if (AppWidgetFeaturesKt.m21519containsCZRyut0(i, i9)) {
            arrayList.add(m21545boximpl(i9));
        }
        return arrayList;
    }

    @Deprecated(message = "", replaceWith = @ReplaceWith(expression = "toSpan(context)", imports = {}))
    @NotNull
    /* JADX INFO: renamed from: toCell-impl, reason: not valid java name */
    public static final Size m21556toCellimpl(int i, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return i == Tiny ? new Size(1, 1) : i == Small ? new Size(2, 1) : i == WideSmall ? new Size(4, 1) : i == Medium ? new Size(2, 2) : i == Large ? new Size(4, 2) : i == ExtraLarge ? new Size(4, 4) : i == ExtraLargeLong ? context.getResources().getConfiguration().orientation == 1 ? new Size(4, 6) : new Size(6, 4) : new Size(0, 0);
    }

    @NotNull
    /* JADX INFO: renamed from: toSpan-impl, reason: not valid java name */
    public static final Point m21558toSpanimpl(int i, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return i == Tiny ? new Point(1, 1) : i == Small ? new Point(2, 1) : i == WideSmall ? new Point(4, 1) : i == Medium ? new Point(2, 2) : i == Large ? new Point(4, 2) : i == ExtraLarge ? new Point(4, 4) : i == ExtraLargeLong ? context.getResources().getConfiguration().orientation == 1 ? new Point(4, 6) : new Point(6, 4) : new Point(0, 0);
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m21559toStringimpl(int i) {
        return i == Unknown ? "unknown" : i == Tiny ? "tiny" : i == Small ? "small" : i == WideSmall ? "widesmall" : i == Medium ? Constants.ScionAnalytics.PARAM_MEDIUM : i == Large ? "large" : i == ExtraLarge ? "extralarge" : i == ExtraLargeLong ? "extralargelong" : i == All ? "all" : "mixed";
    }

    public boolean equals(Object obj) {
        return m21549equalsimpl(this.mask, obj);
    }

    public int hashCode() {
        return m21551hashCodeimpl(this.mask);
    }

    @NotNull
    public String toString() {
        return m21559toStringimpl(this.mask);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getMask() {
        return this.mask;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m21547constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: toInt-impl, reason: not valid java name */
    public static final int m21557toIntimpl(int i) {
        return i;
    }
}
