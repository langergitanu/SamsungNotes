package androidx.glance.oneui.common;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.util.Size;
import android.util.SizeF;
import androidx.annotation.RestrictTo;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.oneui.common.AppWidgetHostType;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.common.AppWidgetStyle;
import androidx.glance.oneui.common.GlanceLog;
import androidx.glance.oneui.common.sizepolicy.flip.FlipSizePolicyManager;
import androidx.glance.oneui.common.sizepolicy.foldable.FoldableSizePolicyManager;
import androidx.glance.oneui.common.sizepolicy.multifold.MultiFoldableSizePolicyManager;
import androidx.glance.oneui.common.sizepolicy.phone.PhoneSizePolicyManager;
import androidx.glance.oneui.common.sizepolicy.tablet.TabletSizePolicyManager;
import androidx.glance.oneui.common.sizepolicy.third.SizePolicyAt3rd;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\\\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001aK\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010\u001aT\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0019\u0010\u0017\u001a\u00020\u0003*\u00020\u00182\u0006\u0010\u0004\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010\u0019\u001a\u000f\u0010\u001a\u001a\u00020\u0003*\u00020\u0018¢\u0006\u0002\u0010\u001b\u001a\f\u0010\u001c\u001a\u00020\u0007*\u00020\u0018H\u0007\u001a\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u0013*\u00020\u00182\u0006\u0010\u001e\u001a\u00020\n\u001a\u0011\u0010\u001f\u001a\u00020 *\u00020\u0018H\u0007¢\u0006\u0002\u0010\u001b\u001a\u000f\u0010!\u001a\u00020\"*\u00020\u0018¢\u0006\u0002\u0010\u001b\u001a/\u0010#\u001a\u00020\u0003*\u00020\u00182\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010&\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006'"}, m13886d2 = {SearchConstants.TargetContents.TAG, "", "convertDpToSize", "Landroidx/glance/oneui/common/AppWidgetSize;", "context", "Landroid/content/Context;", "width", "", "height", "isEasyMode", "", "isFoldSync", "gridSpanInfo", "Landroidx/glance/oneui/common/GridSpanInfo;", "screenSize", "Landroid/util/Size;", "(Landroid/content/Context;FFZZLandroidx/glance/oneui/common/GridSpanInfo;Landroid/util/Size;)I", "convertSizeToDp", "Lkotlin/Pair;", "Landroid/util/SizeF;", "size", "convertSizeToDp-pt7MXqQ", "(Landroid/content/Context;IZZLandroidx/glance/oneui/common/GridSpanInfo;Landroid/util/Size;)Lkotlin/Pair;", "calculateWidgetSizeAt3rdLauncher", "Landroid/os/Bundle;", "(Landroid/os/Bundle;Landroid/content/Context;)I", "explicitWidgetSize", "(Landroid/os/Bundle;)I", "extractDisplayDensity", "extractDpSizeFromOptions", "isPortrait", "extractWidgetHost", "Landroidx/glance/oneui/common/AppWidgetHostType;", "extractWidgetStyle", "Landroidx/glance/oneui/common/AppWidgetStyle;", "getLayoutMode", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "", "(Landroid/os/Bundle;Landroid/content/Context;IFF)I", "glance-oneui-common_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAppWidgetUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppWidgetUtils.kt\nandroidx/glance/oneui/common/AppWidgetUtilsKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,261:1\n1549#2:262\n1620#2,3:263\n1549#2:266\n1620#2,3:267\n*S KotlinDebug\n*F\n+ 1 AppWidgetUtils.kt\nandroidx/glance/oneui/common/AppWidgetUtilsKt\n*L\n94#1:262\n94#1:263,3\n95#1:266\n95#1:267,3\n*E\n"})
public final class AppWidgetUtilsKt {

    @NotNull
    private static final String TAG = "GWT:AppWidgetUtils";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DeviceType.values().length];
            try {
                iArr[DeviceType.MultiFoldMain.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DeviceType.MultiFoldSub.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DeviceType.FoldMain.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DeviceType.FoldSub.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[DeviceType.Tablet.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[DeviceType.Flip.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final int calculateWidgetSizeAt3rdLauncher(Bundle bundle, Context context) {
        GlanceLog.Companion companion = GlanceLog.INSTANCE;
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        companion.init(packageName);
        Configuration configuration = context.getResources().getConfiguration();
        Intrinsics.checkNotNull(configuration);
        SizeF sizeFExtractDpSizeFromOptions = extractDpSizeFromOptions(bundle, DeviceConfigUtilsKt.isPortrait(configuration));
        return sizeFExtractDpSizeFromOptions == null ? AppWidgetSize.INSTANCE.m21572getUnknownrx25Pp4() : DeviceConfigUtilsKt.isPortrait(configuration) ? SizePolicyAt3rd.PortraitPolicy.INSTANCE.m21621convertDpToSizeMIcY41U$glance_oneui_common_release(sizeFExtractDpSizeFromOptions.getWidth(), sizeFExtractDpSizeFromOptions.getHeight()) : SizePolicyAt3rd.LandscapePolicy.INSTANCE.m21621convertDpToSizeMIcY41U$glance_oneui_common_release(sizeFExtractDpSizeFromOptions.getWidth(), sizeFExtractDpSizeFromOptions.getHeight());
    }

    public static final int convertDpToSize(@NotNull Context context, float f, float f4, boolean z, boolean z2, @NotNull GridSpanInfo gridSpanInfo, @NotNull Size screenSize) {
        int iM21647convertDpToSizeTO2Bc4c;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gridSpanInfo, "gridSpanInfo");
        Intrinsics.checkNotNullParameter(screenSize, "screenSize");
        GlanceLog.Companion companion = GlanceLog.INSTANCE;
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        companion.init(packageName);
        Configuration configuration = context.getResources().getConfiguration();
        Intrinsics.checkNotNullExpressionValue(configuration, "getConfiguration(...)");
        boolean zIsPortrait = DeviceConfigUtilsKt.isPortrait(configuration);
        DeviceType deviceType = DeviceTypeUtil.INSTANCE.get(context);
        boolean zIsOverSW360Dp = DeviceConfigUtilsKt.isOverSW360Dp(context);
        switch (WhenMappings.$EnumSwitchMapping$0[deviceType.ordinal()]) {
            case 1:
            case 2:
                iM21647convertDpToSizeTO2Bc4c = MultiFoldableSizePolicyManager.INSTANCE.m21647convertDpToSizeTO2Bc4c(context, f, f4, z2, z, gridSpanInfo, screenSize);
                break;
            case 3:
            case 4:
                iM21647convertDpToSizeTO2Bc4c = FoldableSizePolicyManager.INSTANCE.m21638convertDpToSize9ovGfe8(context, f, f4, z, z2, screenSize);
                break;
            case 5:
                iM21647convertDpToSizeTO2Bc4c = TabletSizePolicyManager.INSTANCE.m21655convertDpToSizeh6tS73U(context, f, f4, gridSpanInfo, screenSize);
                break;
            case 6:
                iM21647convertDpToSizeTO2Bc4c = FlipSizePolicyManager.INSTANCE.m21627convertDpToSizeh6tS73U(context, f, f4, z, screenSize);
                break;
            default:
                iM21647convertDpToSizeTO2Bc4c = PhoneSizePolicyManager.INSTANCE.m21651convertDpToSizeh6tS73U(context, f, f4, z, screenSize);
                break;
        }
        String strM21559toStringimpl = AppWidgetSize.m21559toStringimpl(iM21647convertDpToSizeTO2Bc4c);
        StringBuilder sbM1176v = AbstractC0622a.m1176v("convert: dp(", f, SQLKeyword.COMMA, f4, ") to size(");
        sbM1176v.append(strM21559toStringimpl);
        sbM1176v.append(") port=");
        sbM1176v.append(zIsPortrait);
        sbM1176v.append(" isSw360dp=");
        sbM1176v.append(zIsOverSW360Dp);
        sbM1176v.append(", device=");
        sbM1176v.append(deviceType);
        companion.m2301i(TAG, sbM1176v.toString());
        return iM21647convertDpToSizeTO2Bc4c;
    }

    public static /* synthetic */ int convertDpToSize$default(Context context, float f, float f4, boolean z, boolean z2, GridSpanInfo gridSpanInfo, Size size, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        if ((i & 16) != 0) {
            z2 = false;
        }
        if ((i & 32) != 0) {
            gridSpanInfo = GridSpanInfo.INSTANCE.getUnspecified();
        }
        if ((i & 64) != 0) {
            size = DeviceConfigUtilsKt.getScreenSize(context);
        }
        return convertDpToSize(context, f, f4, z, z2, gridSpanInfo, size);
    }

    @NotNull
    /* JADX INFO: renamed from: convertSizeToDp-pt7MXqQ, reason: not valid java name */
    public static final Pair<SizeF, SizeF> m21588convertSizeToDppt7MXqQ(@NotNull Context context, int i, boolean z, boolean z2, @NotNull GridSpanInfo gridSpanInfo, @NotNull Size screenSize) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gridSpanInfo, "gridSpanInfo");
        Intrinsics.checkNotNullParameter(screenSize, "screenSize");
        GlanceLog.Companion companion = GlanceLog.INSTANCE;
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        companion.init(packageName);
        switch (WhenMappings.$EnumSwitchMapping$0[DeviceTypeUtil.INSTANCE.get(context).ordinal()]) {
            case 1:
            case 2:
                return MultiFoldableSizePolicyManager.INSTANCE.m21648convertSizeToDppt7MXqQ(context, i, z, z2, gridSpanInfo, screenSize);
            case 3:
            case 4:
                return FoldableSizePolicyManager.INSTANCE.m21639convertSizeToDphGL1VUE(context, i, z, z2, screenSize);
            case 5:
                return TabletSizePolicyManager.INSTANCE.m21656convertSizeToDpqK15sPk(context, i, gridSpanInfo, screenSize);
            case 6:
                return FlipSizePolicyManager.INSTANCE.m21628convertSizeToDpqK15sPk(context, i, z, screenSize);
            default:
                return PhoneSizePolicyManager.INSTANCE.m21652convertSizeToDpqK15sPk(context, i, z, screenSize);
        }
    }

    /* JADX INFO: renamed from: convertSizeToDp-pt7MXqQ$default, reason: not valid java name */
    public static /* synthetic */ Pair m21589convertSizeToDppt7MXqQ$default(Context context, int i, boolean z, boolean z2, GridSpanInfo gridSpanInfo, Size size, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        if ((i2 & 8) != 0) {
            z2 = false;
        }
        if ((i2 & 16) != 0) {
            gridSpanInfo = GridSpanInfo.INSTANCE.getUnspecified();
        }
        if ((i2 & 32) != 0) {
            size = DeviceConfigUtilsKt.getScreenSize(context);
        }
        return m21588convertSizeToDppt7MXqQ(context, i, z, z2, gridSpanInfo, size);
    }

    public static final int explicitWidgetSize(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
        return companion.m21562getIQT_O7U(bundle.getInt(AppWidgetConstants.OPTION_APPWIDGET_SIZE, AppWidgetSize.m21557toIntimpl(companion.m21572getUnknownrx25Pp4())));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final float extractDisplayDensity(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        return bundle.getFloat(AppWidgetConstants.OPTION_APPWIDGET_DISPLAY_DENSITY, 0.0f);
    }

    @Nullable
    public static final SizeF extractDpSizeFromOptions(@NotNull Bundle bundle, boolean z) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        SizeF sizeFExtractDpSizeFromOptions$extractFromArraySizes = extractDpSizeFromOptions$extractFromArraySizes(bundle, z);
        return sizeFExtractDpSizeFromOptions$extractFromArraySizes == null ? extractDpSizeFromOptions$extractFromMinMaxSizes(bundle, z) : sizeFExtractDpSizeFromOptions$extractFromArraySizes;
    }

    private static final SizeF extractDpSizeFromOptions$extractFromArraySizes(Bundle bundle, boolean z) {
        ArrayList parcelableArrayList = Build.VERSION.SDK_INT >= 33 ? bundle.getParcelableArrayList("appWidgetSizes", SizeF.class) : bundle.getParcelableArrayList("appWidgetSizes");
        if (parcelableArrayList == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(parcelableArrayList));
        Iterator it = parcelableArrayList.iterator();
        while (it.hasNext()) {
            arrayList.add(Float.valueOf(((SizeF) it.next()).getWidth()));
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.m13952k(parcelableArrayList));
        Iterator it2 = parcelableArrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(Float.valueOf(((SizeF) it2.next()).getHeight()));
        }
        return z ? new SizeF(CollectionsKt___CollectionsKt.m22660minOrThrow((Iterable<Float>) arrayList), CollectionsKt___CollectionsKt.m22652maxOrThrow((Iterable<Float>) arrayList2)) : new SizeF(CollectionsKt___CollectionsKt.m22652maxOrThrow((Iterable<Float>) arrayList), CollectionsKt___CollectionsKt.m22660minOrThrow((Iterable<Float>) arrayList2));
    }

    private static final SizeF extractDpSizeFromOptions$extractFromMinMaxSizes(Bundle bundle, boolean z) {
        int i = bundle.getInt("appWidgetMinHeight", 0);
        int i2 = bundle.getInt("appWidgetMaxHeight", 0);
        int i4 = bundle.getInt("appWidgetMinWidth", 0);
        int i5 = bundle.getInt("appWidgetMaxWidth", 0);
        if (i == 0 || i2 == 0 || i4 == 0 || i5 == 0) {
            return null;
        }
        return z ? new SizeF(i4, i2) : new SizeF(i5, i);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final int extractWidgetHost(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        AppWidgetHostType.Companion companion = AppWidgetHostType.INSTANCE;
        return companion.m21531getbBfPHyc(bundle.getInt(AppWidgetConstants.OPTION_APPWIDGET_HOST_TYPE, AppWidgetHostType.m21528toIntimpl(companion.m21537getUnknownmn_SBp8())));
    }

    public static final int extractWidgetStyle(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        AppWidgetStyle.Companion companion = AppWidgetStyle.INSTANCE;
        return companion.m21585getPRK4rM(bundle.getInt(AppWidgetConstants.OPTION_APPWIDGET_STYLE, AppWidgetStyle.m21582toIntimpl(companion.m21586getColorfulWOdBnnM())));
    }

    public static final int getLayoutMode(@NotNull Bundle bundle, @NotNull Context context, int i, float f, float f4) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        GlanceLog.Companion companion = GlanceLog.INSTANCE;
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        companion.init(packageName);
        float f5 = context.getResources().getDisplayMetrics().density;
        StringBuilder sbM1628r = AbstractC2322a.m1628r("[common-2.0.14] ", i, "-widget size dp: w=", f, " h=");
        AbstractC11014a.m12337v(sbM1628r, f4, ", px: w=", f * f5, ".px h=");
        sbM1628r.append(f5 * f4);
        sbM1628r.append(".px");
        companion.m2301i(TAG, sbM1628r.toString());
        int iExplicitWidgetSize = explicitWidgetSize(bundle);
        companion.m2301i(TAG, "mode=" + AppWidgetSize.m21559toStringimpl(iExplicitWidgetSize) + " from options");
        AppWidgetSize.Companion companion2 = AppWidgetSize.INSTANCE;
        if (!AppWidgetSize.m21550equalsimpl0(iExplicitWidgetSize, companion2.m21572getUnknownrx25Pp4())) {
            return iExplicitWidgetSize;
        }
        if (AppWidgetStyle.m21578equalsimpl0(extractWidgetStyle(bundle), AppWidgetStyle.INSTANCE.m21587getMonotoneWOdBnnM()) || Build.VERSION.SDK_INT <= 34) {
            return ((double) (f / f4)) < 1.5d ? companion2.m21571getTinyrx25Pp4() : companion2.m21570getSmallrx25Pp4();
        }
        int iCalculateWidgetSizeAt3rdLauncher = calculateWidgetSizeAt3rdLauncher(bundle, context);
        companion.m2301i(TAG, AppWidgetSize.m21559toStringimpl(iCalculateWidgetSizeAt3rdLauncher) + " size is calculated at 3rd launcher");
        return iCalculateWidgetSizeAt3rdLauncher;
    }
}
