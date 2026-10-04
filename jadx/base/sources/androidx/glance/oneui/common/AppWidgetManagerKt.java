package androidx.glance.oneui.common;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.annotation.RestrictTo;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.appwidget.util.RemoteViewsReflections;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.common.AppWidgetStyle;
import androidx.glance.oneui.common.GlanceLog;
import androidx.glance.oneui.common.appwidgetsize.HostKey;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u0088\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u001a3\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u001e\u0010\u0007\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\t0\bH\u0000¢\u0006\u0002\u0010\f\u001a$\u0010\r\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\t0\b*\u00020\u000eH\u0002\u001a&\u0010\u000f\u001a\u00020\n*\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0018\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\b*\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0011\u001a\u0010\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000e0\b*\u00020\u0016\u001a$\u0010\u0018\u001a\u00020\n*\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a$\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\b*\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u00112\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0006*\u00020\u00162\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0011\u001a@\u0010#\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060$\u0018\u00010\b*\u00020\u00162\u0006\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u000bø\u0001\u0000¢\u0006\u0004\b(\u0010)\u001a6\u0010*\u001a\u0004\u0018\u00010\u0006*\u00020\u00162\u0006\u0010+\u001a\u00020,2\u0006\u0010%\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u000bø\u0001\u0000¢\u0006\u0004\b0\u00101\u001a\u001e\u00102\u001a\b\u0012\u0004\u0012\u00020\u001c0\b*\u00020\u00162\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u0007\u001a\u0012\u00103\u001a\u000204*\u00020\u00162\u0006\u0010 \u001a\u00020!\u001a\n\u00105\u001a\u000204*\u00020\u0016\u001a\u0011\u00106\u001a\u0004\u0018\u000104*\u00020\u0016¢\u0006\u0002\u00107\u001a5\u00108\u001a\u0010\u0012\f\u0012\n ;*\u0004\u0018\u00010:0:09*\u00020\u00162\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010<\u001a.\u0010=\u001a\u0004\u0018\u00010:*\u00020\u00162\u0006\u0010 \u001a\u00020!2\u0006\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u000bø\u0001\u0000¢\u0006\u0004\b>\u0010?\u001a\u001c\u0010@\u001a\u0004\u0018\u00010:*\u00020\u00162\u0006\u0010 \u001a\u00020!2\u0006\u0010A\u001a\u00020\u0011\u001a(\u0010B\u001a\u00020C*\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u00012\u0006\u0010D\u001a\u00020\u00112\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u000e0\b\u001a5\u0010F\u001a\u0010\u0012\f\u0012\n ;*\u0004\u0018\u00010:0:09*\u00020\u00162\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010<\u001a>\u0010G\u001a\u0004\u0018\u00010:*\u00020\u00162\u0006\u0010 \u001a\u00020!2\u0006\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u000b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002ø\u0001\u0000¢\u0006\u0004\bH\u0010I\u001a2\u0010G\u001a\u00020C*\u00020\u00162\u0006\u0010 \u001a\u00020!2\u001e\u0010\u0007\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\t0\b\u001a\"\u0010J\u001a\u0004\u0018\u00010:*\u00020\u00162\u0006\u0010 \u001a\u00020!2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00060L\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006M"}, m13886d2 = {"APPWIDGET_PREVIEW_REMOTEVIEWS_KEY", "", "APPWIDGET_PREVIEW_STATES_KEY", SearchConstants.TargetContents.TAG, "sortPreview", "", "Landroid/widget/RemoteViews;", "preview", "", "Lkotlin/Triple;", "Landroidx/glance/oneui/common/AppWidgetSize;", "Landroidx/glance/oneui/common/AppWidgetStyle;", "(Ljava/util/List;)[Landroid/widget/RemoteViews;", "convertToPreviewData", "Landroid/os/Bundle;", "getAppWidgetSize", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "", "defaultSize", "getAppWidgetSize-nwm-oUQ", "(Landroid/os/Bundle;II)I", "getAppWidgetSizeInfo", "Landroid/appwidget/AppWidgetManager;", "getAppWidgetSizeInfos", "getBindAppWidgetSize", "getBindAppWidgetSize-nwm-oUQ", "(Landroid/appwidget/AppWidgetManager;II)I", "getInstalledProvidersForPackage", "Landroid/appwidget/AppWidgetProviderInfo;", "categoryFilter", "packageName", "getPreview", "provider", "Landroid/content/ComponentName;", "category", "getTemplatePreview", "Lkotlin/Pair;", "providerInfo", "templateSize", "templateStyle", "getTemplatePreview-hIv0bOU", "(Landroid/appwidget/AppWidgetManager;Landroid/appwidget/AppWidgetProviderInfo;II)Ljava/util/List;", "getWidgetPreviewForHost", "context", "Landroid/content/Context;", "hostType", "Landroidx/glance/oneui/common/AppWidgetHostType;", "style", "getWidgetPreviewForHost-5Xqs4k0", "(Landroid/appwidget/AppWidgetManager;Landroid/content/Context;Landroid/appwidget/AppWidgetProviderInfo;II)Landroid/widget/RemoteViews;", "installedAllProviders", "isPreviewForHostUpdateAvailable", "", "isSupportPreviewForHost", "isSupportTemplatePreview", "(Landroid/appwidget/AppWidgetManager;)Ljava/lang/Boolean;", "removePreview", "Lkotlin/Result;", "", "kotlin.jvm.PlatformType", "(Landroid/appwidget/AppWidgetManager;Landroid/content/ComponentName;ILandroid/widget/RemoteViews;)Ljava/lang/Object;", "removeTemplatePreview", "removeTemplatePreview-hIv0bOU", "(Landroid/appwidget/AppWidgetManager;Landroid/content/ComponentName;II)Ljava/lang/Object;", "removeWidgetPreviewForHost", "hostKeys", "setAppWidgetSizeInfo", "", "hostId", "appWidgetSizeInfos", "setPreview", "setTemplatePreview", "setTemplatePreview-ClELY0w", "(Landroid/appwidget/AppWidgetManager;Landroid/content/ComponentName;II[Landroid/widget/RemoteViews;)Ljava/lang/Object;", "setWidgetPreviewForHost", "previews", "Landroid/util/SparseArray;", "glance-oneui-common_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAppWidgetManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppWidgetManager.kt\nandroidx/glance/oneui/common/AppWidgetManagerKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,388:1\n1109#2,2:389\n1109#2,2:391\n1109#2,2:393\n12474#2,2:395\n13404#2,3:397\n1109#2,2:419\n1109#2,2:421\n13309#2,2:423\n1282#2,2:425\n1282#2,2:427\n1282#2,2:429\n1282#2,2:431\n1109#2,2:433\n1109#2,2:435\n1109#2,2:437\n12474#2,2:439\n1109#2,2:441\n1282#2,2:443\n1855#3:400\n766#3:401\n857#3,2:402\n1549#3:404\n1620#3,3:405\n1856#3:408\n1549#3:410\n1620#3,3:411\n1789#3,3:416\n1#4:409\n37#5,2:414\n*S KotlinDebug\n*F\n+ 1 AppWidgetManager.kt\nandroidx/glance/oneui/common/AppWidgetManagerKt\n*L\n51#1:389,2\n62#1:391,2\n72#1:393,2\n81#1:395,2\n103#1:397,3\n193#1:419,2\n209#1:421,2\n232#1:423,2\n252#1:425,2\n270#1:427,2\n287#1:429,2\n307#1:431,2\n331#1:433,2\n346#1:435,2\n358#1:437,2\n368#1:439,2\n378#1:441,2\n121#1:443,2\n139#1:400\n143#1:401\n143#1:402,2\n144#1:404\n144#1:405,3\n139#1:408\n162#1:410\n162#1:411,3\n178#1:416,3\n162#1:414,2\n*E\n"})
public final class AppWidgetManagerKt {

    @NotNull
    private static final String APPWIDGET_PREVIEW_REMOTEVIEWS_KEY = "previewRemoteViews";

    @NotNull
    private static final String APPWIDGET_PREVIEW_STATES_KEY = "previewStates";

    @NotNull
    private static final String TAG = "GWT:AppWidgetManager";

    private static final List<Triple<AppWidgetStyle, AppWidgetSize, RemoteViews>> convertToPreviewData(Bundle bundle) {
        RemoteViews[] remoteViewsArr;
        int[] intArray = bundle.getIntArray(APPWIDGET_PREVIEW_STATES_KEY);
        if (intArray == null) {
            return CollectionsKt.emptyList();
        }
        if (Build.VERSION.SDK_INT >= 33) {
            remoteViewsArr = (RemoteViews[]) bundle.getParcelableArray("previewRemoteViews", RemoteViews.class);
            if (remoteViewsArr == null) {
                return CollectionsKt.emptyList();
            }
        } else {
            remoteViewsArr = (RemoteViews[]) bundle.getParcelableArray(APPWIDGET_PREVIEW_REMOTEVIEWS_KEY);
            if (remoteViewsArr == null) {
                return CollectionsKt.emptyList();
            }
        }
        ArrayList arrayList = new ArrayList();
        int length = intArray.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i4 = intArray[i];
            int i5 = i2 + 1;
            if (i2 != remoteViewsArr.length) {
                int size = AppWidgetSize.m21555toArrayListimpl(AppWidgetSize.INSTANCE.m21565getAllrx25Pp4()).size();
                arrayList.add(new Triple(AppWidgetStyle.m21574boximpl(AppWidgetStyle.m21575constructorimpl(i4 >>> size)), AppWidgetSize.m21545boximpl(AppWidgetSize.m21547constructorimpl(i4 & ((1 << size) - 1))), remoteViewsArr[i2]));
            }
            i++;
            i2 = i5;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: getAppWidgetSize-nwm-oUQ, reason: not valid java name */
    private static final int m21538getAppWidgetSizenwmoUQ(Bundle bundle, int i, int i2) {
        int iExplicitWidgetSize = AppWidgetUtilsKt.explicitWidgetSize(bundle);
        GlanceLog.Companion companion = GlanceLog.INSTANCE;
        companion.m2297d(TAG, AbstractC11014a.m12321f("(id=", i, ") mode=", AppWidgetSize.m21559toStringimpl(iExplicitWidgetSize), " from options"));
        AppWidgetSize.Companion companion2 = AppWidgetSize.INSTANCE;
        if (!AppWidgetSize.m21550equalsimpl0(iExplicitWidgetSize, companion2.m21572getUnknownrx25Pp4())) {
            return iExplicitWidgetSize;
        }
        companion.m2297d(TAG, AbstractC2322a.m1616f(i, "(id=", ") default=", AppWidgetSize.m21559toStringimpl(i2)));
        return AppWidgetSize.m21550equalsimpl0(i2, companion2.m21572getUnknownrx25Pp4()) ? companion2.m21569getMediumrx25Pp4() : i2;
    }

    @NotNull
    public static final List<Bundle> getAppWidgetSizeInfo(@NotNull AppWidgetManager appWidgetManager, int i) {
        Method method;
        Intrinsics.checkNotNullParameter(appWidgetManager, "<this>");
        List<Bundle> listEmptyList = CollectionsKt.emptyList();
        try {
            Method[] declaredMethods = appWidgetManager.getClass().getDeclaredMethods();
            Intrinsics.checkNotNullExpressionValue(declaredMethods, "getDeclaredMethods(...)");
            int length = declaredMethods.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    method = null;
                    break;
                }
                method = declaredMethods[i2];
                method.setAccessible(true);
                if (Intrinsics.areEqual(method.getName(), AppWidgetManagerReflections.GET_APPWIDGET_SIZE_INFO)) {
                    break;
                }
                i2++;
            }
            if (method != null) {
                Object objInvoke = method.invoke(appWidgetManager, Integer.valueOf(i));
                Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.collections.List<android.os.Bundle>");
                return (List) objInvoke;
            }
        } catch (Exception e) {
            GlanceLog.INSTANCE.m2299e(TAG, "getAppWidgetSizeInfo " + e);
        }
        return listEmptyList;
    }

    @NotNull
    public static final List<Bundle> getAppWidgetSizeInfos(@NotNull AppWidgetManager appWidgetManager) {
        Method method;
        Intrinsics.checkNotNullParameter(appWidgetManager, "<this>");
        List<Bundle> listEmptyList = CollectionsKt.emptyList();
        try {
            Method[] declaredMethods = appWidgetManager.getClass().getDeclaredMethods();
            Intrinsics.checkNotNullExpressionValue(declaredMethods, "getDeclaredMethods(...)");
            int length = declaredMethods.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    method = null;
                    break;
                }
                method = declaredMethods[i];
                method.setAccessible(true);
                if (Intrinsics.areEqual(method.getName(), AppWidgetManagerReflections.GET_APPWIDGET_SIZE_INFOS)) {
                    break;
                }
                i++;
            }
            if (method != null) {
                Object objInvoke = method.invoke(appWidgetManager, null);
                Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.collections.List<android.os.Bundle>");
                return (List) objInvoke;
            }
        } catch (Exception e) {
            GlanceLog.INSTANCE.m2299e(TAG, "getAppWidgetSizeInfos " + e);
        }
        return listEmptyList;
    }

    /* JADX INFO: renamed from: getBindAppWidgetSize-nwm-oUQ, reason: not valid java name */
    public static final int m21539getBindAppWidgetSizenwmoUQ(@NotNull AppWidgetManager getBindAppWidgetSize, int i, int i2) {
        Intrinsics.checkNotNullParameter(getBindAppWidgetSize, "$this$getBindAppWidgetSize");
        Bundle appWidgetOptions = getBindAppWidgetSize.getAppWidgetOptions(i);
        Intrinsics.checkNotNullExpressionValue(appWidgetOptions, "getAppWidgetOptions(...)");
        return m21538getAppWidgetSizenwmoUQ(appWidgetOptions, i, i2);
    }

    private static final List<AppWidgetProviderInfo> getInstalledProvidersForPackage(AppWidgetManager appWidgetManager, int i, String str) {
        Method method;
        List<AppWidgetProviderInfo> listEmptyList = CollectionsKt.emptyList();
        try {
            Method[] declaredMethods = appWidgetManager.getClass().getDeclaredMethods();
            Intrinsics.checkNotNullExpressionValue(declaredMethods, "getDeclaredMethods(...)");
            int length = declaredMethods.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    method = null;
                    break;
                }
                method = declaredMethods[i2];
                method.setAccessible(true);
                if (Intrinsics.areEqual(method.getName(), AppWidgetManagerReflections.GET_INSTALLED_PROVIDERS_FOR_PACKAGE_METHOD)) {
                    break;
                }
                i2++;
            }
            if (method != null) {
                Object objInvoke = method.invoke(appWidgetManager, Integer.valueOf(i), str);
                Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.collections.List<android.appwidget.AppWidgetProviderInfo>");
                return (List) objInvoke;
            }
        } catch (Exception e) {
            GlanceLog.INSTANCE.m2299e(TAG, "getInstalledProvidersForPackage " + e);
        }
        return listEmptyList;
    }

    @Nullable
    public static final RemoteViews getPreview(@NotNull AppWidgetManager appWidgetManager, @NotNull ComponentName provider, int i) {
        Object objM22215constructorimpl;
        Method[] declaredMethods;
        int i2;
        Intrinsics.checkNotNullParameter(appWidgetManager, "<this>");
        Intrinsics.checkNotNullParameter(provider, "provider");
        try {
            Result.Companion companion = Result.INSTANCE;
            declaredMethods = appWidgetManager.getClass().getDeclaredMethods();
            Intrinsics.checkNotNullExpressionValue(declaredMethods, "getDeclaredMethods(...)");
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        for (Method method : declaredMethods) {
            method.setAccessible(true);
            if (Intrinsics.areEqual(method.getName(), AppWidgetManagerReflections.GET_WIDGET_PREVIEW_METHOD)) {
                objM22215constructorimpl = Result.m22215constructorimpl((RemoteViews) method.invoke(appWidgetManager, provider, Integer.valueOf(i)));
                if (Result.m22221isFailureimpl(objM22215constructorimpl)) {
                    objM22215constructorimpl = null;
                }
                return (RemoteViews) objM22215constructorimpl;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @Nullable
    /* JADX INFO: renamed from: getTemplatePreview-hIv0bOU, reason: not valid java name */
    public static final List<Pair<AppWidgetSize, RemoteViews>> m21540getTemplatePreviewhIv0bOU(@NotNull AppWidgetManager getTemplatePreview, @NotNull AppWidgetProviderInfo providerInfo, int i, int i2) {
        Object objM22215constructorimpl;
        Intrinsics.checkNotNullParameter(getTemplatePreview, "$this$getTemplatePreview");
        Intrinsics.checkNotNullParameter(providerInfo, "providerInfo");
        try {
            Result.Companion companion = Result.INSTANCE;
            List<Triple<AppWidgetStyle, AppWidgetSize, RemoteViews>> listConvertToPreviewData = convertToPreviewData(getTemplatePreview_hIv0bOU$lambda$13$getCachedBundle(getTemplatePreview, providerInfo, i, i2));
            ArrayList arrayList = new ArrayList();
            GlanceLog.INSTANCE.m2297d(TAG, "converted data : " + listConvertToPreviewData.size() + " / " + listConvertToPreviewData);
            AppWidgetStyle.Companion companion2 = AppWidgetStyle.INSTANCE;
            Iterator it = CollectionsKt.listOf((Object[]) new AppWidgetStyle[]{AppWidgetStyle.m21574boximpl(companion2.m21586getColorfulWOdBnnM()), AppWidgetStyle.m21574boximpl(companion2.m21587getMonotoneWOdBnnM())}).iterator();
            while (it.hasNext()) {
                int mask = ((AppWidgetStyle) it.next()).getMask();
                if (AppWidgetStyle.m21576containszt4ubU(i2, mask)) {
                    ArrayList<Triple> arrayList2 = new ArrayList();
                    for (Object obj : listConvertToPreviewData) {
                        if (AppWidgetStyle.m21578equalsimpl0(((AppWidgetStyle) ((Triple) obj).getFirst()).getMask(), mask)) {
                            arrayList2.add(obj);
                        }
                    }
                    ArrayList arrayList3 = new ArrayList(CollectionsKt.m13952k(arrayList2));
                    for (Triple triple : arrayList2) {
                        arrayList3.add(new Pair(triple.getSecond(), triple.getThird()));
                    }
                    arrayList.addAll(arrayList3);
                }
            }
            GlanceLog.INSTANCE.m2297d(TAG, "filtered preview : " + arrayList.size() + " / " + arrayList);
            objM22215constructorimpl = Result.m22215constructorimpl(arrayList);
        } catch (Throwable th) {
            Result.Companion companion3 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22215constructorimpl);
        if (thM22218exceptionOrNullimpl != null) {
            thM22218exceptionOrNullimpl.printStackTrace();
        }
        if (Result.m22221isFailureimpl(objM22215constructorimpl)) {
            objM22215constructorimpl = null;
        }
        return (List) objM22215constructorimpl;
    }

    private static final Bundle getTemplatePreview_hIv0bOU$lambda$13$getCachedBundle(AppWidgetManager appWidgetManager, AppWidgetProviderInfo appWidgetProviderInfo, int i, int i2) {
        Method method;
        Method[] declaredMethods = appWidgetManager.getClass().getDeclaredMethods();
        Intrinsics.checkNotNullExpressionValue(declaredMethods, "getDeclaredMethods(...)");
        int length = declaredMethods.length;
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                method = null;
                break;
            }
            method = declaredMethods[i4];
            method.setAccessible(true);
            if (Intrinsics.areEqual(method.getName(), AppWidgetManagerReflections.GET_TEMPLATE_WIDGET_PREVIEW_METHOD)) {
                break;
            }
            i4++;
        }
        Bundle bundle = (Bundle) (method != null ? method.invoke(appWidgetManager, appWidgetProviderInfo.provider, null, Integer.valueOf(AppWidgetSize.m21557toIntimpl(i)), Integer.valueOf(AppWidgetStyle.m21582toIntimpl(i2))) : null);
        if (bundle != null) {
            return bundle;
        }
        Bundle EMPTY = Bundle.EMPTY;
        Intrinsics.checkNotNullExpressionValue(EMPTY, "EMPTY");
        return EMPTY;
    }

    @Nullable
    /* JADX INFO: renamed from: getWidgetPreviewForHost-5Xqs4k0, reason: not valid java name */
    public static final RemoteViews m21541getWidgetPreviewForHost5Xqs4k0(@NotNull AppWidgetManager getWidgetPreviewForHost, @NotNull Context context, @NotNull AppWidgetProviderInfo providerInfo, int i, int i2) {
        Object objM22215constructorimpl;
        int iM21620makeHostKeyC7y7hqc;
        Method[] declaredMethods;
        int i4;
        Intrinsics.checkNotNullParameter(getWidgetPreviewForHost, "$this$getWidgetPreviewForHost");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(providerInfo, "providerInfo");
        try {
            Result.Companion companion = Result.INSTANCE;
            iM21620makeHostKeyC7y7hqc = HostKey.INSTANCE.m21620makeHostKeyC7y7hqc(i, DisplayDeviceType.INSTANCE.m21601fromPMarWA4(context), i2);
            declaredMethods = getWidgetPreviewForHost.getClass().getDeclaredMethods();
            Intrinsics.checkNotNullExpressionValue(declaredMethods, "getDeclaredMethods(...)");
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        for (Method method : declaredMethods) {
            method.setAccessible(true);
            if (Intrinsics.areEqual(method.getName(), AppWidgetManagerReflections.GET_WIDGET_PREVIEW_FOR_HOST_METHOD)) {
                objM22215constructorimpl = Result.m22215constructorimpl((RemoteViews) method.invoke(getWidgetPreviewForHost, providerInfo.provider, null, Integer.valueOf(iM21620makeHostKeyC7y7hqc)));
                RemoteViews remoteViews = (RemoteViews) (Result.m22221isFailureimpl(objM22215constructorimpl) ? null : objM22215constructorimpl);
                GlanceLog.Companion companion3 = GlanceLog.INSTANCE;
                String strM21529toStringimpl = AppWidgetHostType.m21529toStringimpl(i);
                String strM21583toStringimpl = AppWidgetStyle.m21583toStringimpl(i2);
                ComponentName componentName = providerInfo.provider;
                StringBuilder sbM16m = AbstractC0000a.m16m("Get ", strM21529toStringimpl, CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR, strM21583toStringimpl, CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
                sbM16m.append(componentName);
                sbM16m.append(" preview : ");
                sbM16m.append(remoteViews);
                companion3.m2297d(TAG, sbM16m.toString());
                return remoteViews;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public static final List<AppWidgetProviderInfo> installedAllProviders(@NotNull AppWidgetManager appWidgetManager, @Nullable String str) {
        Intrinsics.checkNotNullParameter(appWidgetManager, "<this>");
        CollectionsKt.emptyList();
        GlanceLog.Companion companion = GlanceLog.INSTANCE;
        companion.m2297d(TAG, "installedAllProviders " + str);
        List<AppWidgetProviderInfo> installedProvidersForPackage = getInstalledProvidersForPackage(appWidgetManager, 8705, str);
        if (installedProvidersForPackage.isEmpty()) {
            companion.m2297d(TAG, "no getInstalledProvidersForPackage method");
            try {
                Method[] declaredMethods = appWidgetManager.getClass().getDeclaredMethods();
                Intrinsics.checkNotNullExpressionValue(declaredMethods, "getDeclaredMethods(...)");
                for (Method method : declaredMethods) {
                    method.setAccessible(true);
                    if (Intrinsics.areEqual(method.getName(), RemoteViewsReflections.GET_INSTALLED_PROVIDERS) && method.getParameterCount() == 1) {
                        Object objInvoke = method.invoke(appWidgetManager, 8705);
                        Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.collections.List<android.appwidget.AppWidgetProviderInfo>");
                        installedProvidersForPackage = (List) objInvoke;
                    }
                }
                return installedProvidersForPackage;
            } catch (Exception e) {
                GlanceLog.INSTANCE.m2299e(TAG, "ex=" + e);
            }
        }
        return installedProvidersForPackage;
    }

    public static /* synthetic */ List installedAllProviders$default(AppWidgetManager appWidgetManager, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return installedAllProviders(appWidgetManager, str);
    }

    public static final boolean isPreviewForHostUpdateAvailable(@NotNull AppWidgetManager appWidgetManager, @NotNull ComponentName provider) {
        Object objM22215constructorimpl;
        Method[] declaredMethods;
        int i;
        Intrinsics.checkNotNullParameter(appWidgetManager, "<this>");
        Intrinsics.checkNotNullParameter(provider, "provider");
        try {
            Result.Companion companion = Result.INSTANCE;
            declaredMethods = appWidgetManager.getClass().getDeclaredMethods();
            Intrinsics.checkNotNullExpressionValue(declaredMethods, "getDeclaredMethods(...)");
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        for (Method method : declaredMethods) {
            method.setAccessible(true);
            if (Intrinsics.areEqual(method.getName(), AppWidgetManagerReflections.IS_WIDGET_PREVIEW_FOR_HOST_UPDATE_AVAILABLE)) {
                objM22215constructorimpl = Result.m22215constructorimpl((Boolean) method.invoke(appWidgetManager, provider));
                if (Result.m22221isFailureimpl(objM22215constructorimpl)) {
                    objM22215constructorimpl = null;
                }
                Boolean bool = (Boolean) objM22215constructorimpl;
                if (bool != null) {
                    return bool.booleanValue();
                }
                return true;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final boolean isSupportPreviewForHost(@NotNull AppWidgetManager appWidgetManager) {
        Object objM22215constructorimpl;
        Intrinsics.checkNotNullParameter(appWidgetManager, "<this>");
        try {
            Result.Companion companion = Result.INSTANCE;
            Method[] declaredMethods = appWidgetManager.getClass().getDeclaredMethods();
            Intrinsics.checkNotNullExpressionValue(declaredMethods, "getDeclaredMethods(...)");
            int length = declaredMethods.length;
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                Method method = declaredMethods[i];
                method.setAccessible(true);
                if (Intrinsics.areEqual(method.getName(), AppWidgetManagerReflections.GET_WIDGET_PREVIEW_FOR_HOST_METHOD)) {
                    z = true;
                    break;
                }
                i++;
            }
            objM22215constructorimpl = Result.m22215constructorimpl(Boolean.valueOf(z));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        Boolean bool = Boolean.FALSE;
        if (Result.m22221isFailureimpl(objM22215constructorimpl)) {
            objM22215constructorimpl = bool;
        }
        return ((Boolean) objM22215constructorimpl).booleanValue();
    }

    @Nullable
    public static final Boolean isSupportTemplatePreview(@NotNull AppWidgetManager appWidgetManager) {
        Object objM22215constructorimpl;
        Intrinsics.checkNotNullParameter(appWidgetManager, "<this>");
        try {
            Result.Companion companion = Result.INSTANCE;
            Method[] declaredMethods = appWidgetManager.getClass().getDeclaredMethods();
            Intrinsics.checkNotNullExpressionValue(declaredMethods, "getDeclaredMethods(...)");
            int length = declaredMethods.length;
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                Method method = declaredMethods[i];
                method.setAccessible(true);
                if (Intrinsics.areEqual(method.getName(), AppWidgetManagerReflections.GET_TEMPLATE_WIDGET_PREVIEW_METHOD)) {
                    z = true;
                    break;
                }
                i++;
            }
            objM22215constructorimpl = Result.m22215constructorimpl(Boolean.valueOf(z));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m22221isFailureimpl(objM22215constructorimpl)) {
            objM22215constructorimpl = null;
        }
        return (Boolean) objM22215constructorimpl;
    }

    @NotNull
    public static final Object removePreview(@NotNull AppWidgetManager appWidgetManager, @NotNull ComponentName provider, int i, @NotNull RemoteViews preview) {
        Intrinsics.checkNotNullParameter(appWidgetManager, "<this>");
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(preview, "preview");
        try {
            Result.Companion companion = Result.INSTANCE;
            Method[] declaredMethods = appWidgetManager.getClass().getDeclaredMethods();
            Intrinsics.checkNotNullExpressionValue(declaredMethods, "getDeclaredMethods(...)");
            for (Method method : declaredMethods) {
                method.setAccessible(true);
                if (Intrinsics.areEqual(method.getName(), AppWidgetManagerReflections.REMOVE_WIDGET_PREVIEW_METHOD)) {
                    return Result.m22215constructorimpl(method.invoke(appWidgetManager, provider, Integer.valueOf(i), preview));
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
    }

    @Nullable
    /* JADX INFO: renamed from: removeTemplatePreview-hIv0bOU, reason: not valid java name */
    public static final Object m21542removeTemplatePreviewhIv0bOU(@NotNull AppWidgetManager removeTemplatePreview, @NotNull ComponentName provider, int i, int i2) {
        Object objM22215constructorimpl;
        Method[] declaredMethods;
        int i4;
        Intrinsics.checkNotNullParameter(removeTemplatePreview, "$this$removeTemplatePreview");
        Intrinsics.checkNotNullParameter(provider, "provider");
        try {
            Result.Companion companion = Result.INSTANCE;
            declaredMethods = removeTemplatePreview.getClass().getDeclaredMethods();
            Intrinsics.checkNotNullExpressionValue(declaredMethods, "getDeclaredMethods(...)");
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        for (Method method : declaredMethods) {
            method.setAccessible(true);
            if (Intrinsics.areEqual(method.getName(), AppWidgetManagerReflections.REMOVE_TEMPLATE_WIDGET_PREVIEW_METHOD)) {
                objM22215constructorimpl = Result.m22215constructorimpl(method.invoke(removeTemplatePreview, provider, Integer.valueOf(AppWidgetSize.m21557toIntimpl(i)), Integer.valueOf(AppWidgetStyle.m21582toIntimpl(i2))));
                if (Result.m22221isFailureimpl(objM22215constructorimpl)) {
                    return null;
                }
                return objM22215constructorimpl;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @Nullable
    public static final Object removeWidgetPreviewForHost(@NotNull AppWidgetManager appWidgetManager, @NotNull ComponentName provider, int i) {
        Object objM22215constructorimpl;
        Method[] declaredMethods;
        int i2;
        Intrinsics.checkNotNullParameter(appWidgetManager, "<this>");
        Intrinsics.checkNotNullParameter(provider, "provider");
        try {
            Result.Companion companion = Result.INSTANCE;
            declaredMethods = appWidgetManager.getClass().getDeclaredMethods();
            Intrinsics.checkNotNullExpressionValue(declaredMethods, "getDeclaredMethods(...)");
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        for (Method method : declaredMethods) {
            method.setAccessible(true);
            if (Intrinsics.areEqual(method.getName(), AppWidgetManagerReflections.REMOVE_WIDGET_PREVIEW_FOR_HOST_METHOD)) {
                objM22215constructorimpl = Result.m22215constructorimpl(method.invoke(appWidgetManager, provider, Integer.valueOf(i)));
                if (Result.m22221isFailureimpl(objM22215constructorimpl)) {
                    return null;
                }
                return objM22215constructorimpl;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final void setAppWidgetSizeInfo(@NotNull AppWidgetManager appWidgetManager, @NotNull String packageName, int i, @NotNull List<Bundle> appWidgetSizeInfos) {
        Method method;
        Intrinsics.checkNotNullParameter(appWidgetManager, "<this>");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(appWidgetSizeInfos, "appWidgetSizeInfos");
        try {
            Method[] declaredMethods = appWidgetManager.getClass().getDeclaredMethods();
            Intrinsics.checkNotNullExpressionValue(declaredMethods, "getDeclaredMethods(...)");
            int length = declaredMethods.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    method = null;
                    break;
                }
                method = declaredMethods[i2];
                method.setAccessible(true);
                if (Intrinsics.areEqual(method.getName(), AppWidgetManagerReflections.SET_APPWIDGET_SIZE_INFO)) {
                    break;
                } else {
                    i2++;
                }
            }
            if (method != null) {
                method.invoke(appWidgetManager, packageName, Integer.valueOf(i), appWidgetSizeInfos);
                GlanceLog.INSTANCE.m2301i(TAG, "setAppWidgetSizeInfo - invoke");
            }
        } catch (Exception e) {
            GlanceLog.INSTANCE.m2299e(TAG, "setAppWidgetSizeInfo " + e);
        }
    }

    @NotNull
    public static final Object setPreview(@NotNull AppWidgetManager appWidgetManager, @NotNull ComponentName provider, int i, @NotNull RemoteViews preview) {
        Intrinsics.checkNotNullParameter(appWidgetManager, "<this>");
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(preview, "preview");
        try {
            Result.Companion companion = Result.INSTANCE;
            Method[] declaredMethods = appWidgetManager.getClass().getDeclaredMethods();
            Intrinsics.checkNotNullExpressionValue(declaredMethods, "getDeclaredMethods(...)");
            for (Method method : declaredMethods) {
                method.setAccessible(true);
                if (Intrinsics.areEqual(method.getName(), AppWidgetManagerReflections.SET_WIDGET_PREVIEW_METHOD)) {
                    return Result.m22215constructorimpl(method.invoke(appWidgetManager, provider, Integer.valueOf(i), preview));
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
    }

    public static final void setTemplatePreview(@NotNull AppWidgetManager appWidgetManager, @NotNull ComponentName provider, @NotNull List<? extends Triple<AppWidgetSize, AppWidgetStyle, ? extends RemoteViews>> preview) {
        Intrinsics.checkNotNullParameter(appWidgetManager, "<this>");
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(preview, "preview");
        RemoteViews[] remoteViewsArrSortPreview = sortPreview(preview);
        Pair pairM13893to = TuplesKt.m13893to(0, 0);
        Iterator<T> it = preview.iterator();
        while (it.hasNext()) {
            Triple triple = (Triple) it.next();
            int iIntValue = ((Number) pairM13893to.component1()).intValue();
            int iIntValue2 = ((Number) pairM13893to.component2()).intValue();
            pairM13893to = TuplesKt.m13893to(Integer.valueOf(iIntValue | AppWidgetSize.m21557toIntimpl(((AppWidgetSize) triple.component1()).getMask())), Integer.valueOf(iIntValue2 | AppWidgetStyle.m21582toIntimpl(((AppWidgetStyle) triple.component2()).getMask())));
        }
        int iIntValue3 = ((Number) pairM13893to.component1()).intValue();
        int iIntValue4 = ((Number) pairM13893to.component2()).intValue();
        GlanceLog.Companion companion = GlanceLog.INSTANCE;
        int length = remoteViewsArrSortPreview.length;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(iIntValue4, iIntValue3, "setTemplatePreview / ", SQLKeyword.COMMA, SQLKeyword.COMMA);
        sbM1173s.append(length);
        companion.m2297d(TAG, sbM1173s.toString());
        m21543setTemplatePreviewClELY0w(appWidgetManager, provider, AppWidgetSize.m21547constructorimpl(iIntValue3), AppWidgetStyle.m21575constructorimpl(iIntValue4), remoteViewsArrSortPreview);
    }

    /* JADX INFO: renamed from: setTemplatePreview-ClELY0w, reason: not valid java name */
    private static final Object m21543setTemplatePreviewClELY0w(AppWidgetManager appWidgetManager, ComponentName componentName, int i, int i2, RemoteViews[] remoteViewsArr) {
        Object objM22215constructorimpl;
        Method[] declaredMethods;
        int i4;
        try {
            Result.Companion companion = Result.INSTANCE;
            declaredMethods = appWidgetManager.getClass().getDeclaredMethods();
            Intrinsics.checkNotNullExpressionValue(declaredMethods, "getDeclaredMethods(...)");
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        for (Method method : declaredMethods) {
            method.setAccessible(true);
            if (Intrinsics.areEqual(method.getName(), AppWidgetManagerReflections.SET_TEMPLATE_WIDGET_PREVIEW_METHOD)) {
                objM22215constructorimpl = Result.m22215constructorimpl(method.invoke(appWidgetManager, componentName, Integer.valueOf(AppWidgetSize.m21557toIntimpl(i)), Integer.valueOf(AppWidgetStyle.m21582toIntimpl(i2)), remoteViewsArr));
                Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22215constructorimpl);
                if (thM22218exceptionOrNullimpl != null) {
                    thM22218exceptionOrNullimpl.printStackTrace();
                }
                if (Result.m22221isFailureimpl(objM22215constructorimpl)) {
                    return null;
                }
                return objM22215constructorimpl;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @Nullable
    public static final Object setWidgetPreviewForHost(@NotNull AppWidgetManager appWidgetManager, @NotNull ComponentName provider, @NotNull SparseArray<RemoteViews> previews) {
        Object objM22215constructorimpl;
        Method[] declaredMethods;
        int i;
        Intrinsics.checkNotNullParameter(appWidgetManager, "<this>");
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(previews, "previews");
        try {
            Result.Companion companion = Result.INSTANCE;
            declaredMethods = appWidgetManager.getClass().getDeclaredMethods();
            Intrinsics.checkNotNullExpressionValue(declaredMethods, "getDeclaredMethods(...)");
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        for (Method method : declaredMethods) {
            method.setAccessible(true);
            if (Intrinsics.areEqual(method.getName(), AppWidgetManagerReflections.SET_WIDGET_PREVIEW_FOR_HOST_METHOD)) {
                objM22215constructorimpl = Result.m22215constructorimpl(method.invoke(appWidgetManager, provider, previews));
                Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22215constructorimpl);
                if (thM22218exceptionOrNullimpl != null) {
                    thM22218exceptionOrNullimpl.printStackTrace();
                }
                if (Result.m22221isFailureimpl(objM22215constructorimpl)) {
                    return null;
                }
                return objM22215constructorimpl;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @NotNull
    public static final RemoteViews[] sortPreview(@NotNull List<? extends Triple<AppWidgetSize, AppWidgetStyle, ? extends RemoteViews>> preview) {
        Intrinsics.checkNotNullParameter(preview, "preview");
        List listSortedWith = CollectionsKt.sortedWith(preview, new Comparator() { // from class: androidx.glance.oneui.common.AppWidgetManagerKt$sortPreview$$inlined$compareBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(AppWidgetManagerKt.sortPreview$state((Triple) t)), Integer.valueOf(AppWidgetManagerKt.sortPreview$state((Triple) t2)));
            }
        });
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(listSortedWith));
        Iterator it = listSortedWith.iterator();
        while (it.hasNext()) {
            arrayList.add((RemoteViews) ((Triple) it.next()).getThird());
        }
        return (RemoteViews[]) arrayList.toArray(new RemoteViews[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int sortPreview$state(Triple<AppWidgetSize, AppWidgetStyle, ? extends RemoteViews> triple) {
        return AppWidgetSize.m21557toIntimpl(triple.getFirst().getMask()) | (AppWidgetStyle.m21582toIntimpl(triple.getSecond().getMask()) << AppWidgetSize.m21555toArrayListimpl(AppWidgetSize.INSTANCE.m21565getAllrx25Pp4()).size());
    }
}
