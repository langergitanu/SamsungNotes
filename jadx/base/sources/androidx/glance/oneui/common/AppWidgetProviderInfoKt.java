package androidx.glance.oneui.common;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Xml;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.common.StyleableAttributes;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u00002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0019\u0010\b\u001a\u00020\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\r\u001a\u0019\u0010\u000e\u001a\u00020\u0003*\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\r\u001a\u0019\u0010\u000f\u001a\u00020\u0003*\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\r\u001a\n\u0010\u0010\u001a\u00020\u0011*\u00020\n\u001a\n\u0010\u0012\u001a\u00020\u0011*\u00020\n\u001a\n\u0010\u0013\u001a\u00020\u0011*\u00020\n\u001a\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u0011*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u0017\u001a\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u0015*\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0003\u001a\f\u0010\u0019\u001a\u00020\u0015*\u00020\u0015H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001a"}, m13886d2 = {SearchConstants.TargetContents.TAG, "", "filterPreviewSize", "Landroidx/glance/oneui/common/AppWidgetSize;", "widgetSize", "previewSize", "filterPreviewSize-2Z8j5yc", "(II)I", "extractHostType", "Landroidx/glance/oneui/common/AppWidgetHostType;", "Landroid/appwidget/AppWidgetProviderInfo;", "context", "Landroid/content/Context;", "(Landroid/appwidget/AppWidgetProviderInfo;Landroid/content/Context;)I", "extractPreviewSize", "extractSize", "generatedColorfulPreviewStates", "", "generatedMonotonePreviewStates", "generatedPreviewHostKeys", "getAttributeValue", "Landroid/content/res/XmlResourceParser;", "attributeName", "(Landroid/content/res/XmlResourceParser;Ljava/lang/String;)Ljava/lang/Integer;", "getMetadata", "moveToAttributeSet", "glance-oneui-common_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAppWidgetProviderInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppWidgetProviderInfo.kt\nandroidx/glance/oneui/common/AppWidgetProviderInfoKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,158:1\n288#2,2:159\n288#2,2:162\n766#2:164\n857#2,2:165\n1855#2,2:167\n1789#2,3:169\n1#3:161\n*S KotlinDebug\n*F\n+ 1 AppWidgetProviderInfo.kt\nandroidx/glance/oneui/common/AppWidgetProviderInfoKt\n*L\n28#1:159,2\n50#1:162,2\n114#1:164\n114#1:165,2\n116#1:167,2\n124#1:169,3\n*E\n"})
public final class AppWidgetProviderInfoKt {

    @NotNull
    private static final String TAG = "GWT:ProviderInfo";

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final int extractHostType(@NotNull AppWidgetProviderInfo appWidgetProviderInfo, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(appWidgetProviderInfo, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT < 31) {
            return AppWidgetHostType.INSTANCE.m21537getUnknownmn_SBp8();
        }
        XmlResourceParser metadata = getMetadata(appWidgetProviderInfo, context);
        if (metadata == null) {
            return AppWidgetHostType.INSTANCE.m21532getAllmn_SBp8();
        }
        try {
            moveToAttributeSet(metadata);
            Integer attributeValue = getAttributeValue(metadata, StyleableAttributes.TargetHost.INSTANCE.getAttributeName());
            if (attributeValue != null) {
                int iM21521constructorimpl = AppWidgetHostType.m21521constructorimpl(attributeValue.intValue());
                AutoCloseableKt.closeFinally(metadata, null);
                return iM21521constructorimpl;
            }
            int iM21532getAllmn_SBp8 = AppWidgetHostType.INSTANCE.m21532getAllmn_SBp8();
            AutoCloseableKt.closeFinally(metadata, null);
            return iM21532getAllmn_SBp8;
        } finally {
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final int extractPreviewSize(@NotNull AppWidgetProviderInfo appWidgetProviderInfo, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(appWidgetProviderInfo, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return m21544filterPreviewSize2Z8j5yc(extractSize(appWidgetProviderInfo, context), extractPreviewSize$extractPreviewSizeInner(appWidgetProviderInfo, context));
    }

    private static final int extractPreviewSize$extractPreviewSizeInner(AppWidgetProviderInfo appWidgetProviderInfo, Context context) {
        if (Build.VERSION.SDK_INT < 31) {
            return AppWidgetSize.INSTANCE.m21572getUnknownrx25Pp4();
        }
        XmlResourceParser metadata = getMetadata(appWidgetProviderInfo, context);
        if (metadata == null) {
            return AppWidgetSize.INSTANCE.m21572getUnknownrx25Pp4();
        }
        try {
            moveToAttributeSet(metadata);
            Integer attributeValue = getAttributeValue(metadata, StyleableAttributes.PreviewSize.INSTANCE.getAttributeName());
            if (attributeValue != null) {
                int iM21547constructorimpl = AppWidgetSize.m21547constructorimpl(attributeValue.intValue());
                AutoCloseableKt.closeFinally(metadata, null);
                return iM21547constructorimpl;
            }
            int iM21572getUnknownrx25Pp4 = AppWidgetSize.INSTANCE.m21572getUnknownrx25Pp4();
            AutoCloseableKt.closeFinally(metadata, null);
            return iM21572getUnknownrx25Pp4;
        } finally {
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final int extractSize(@NotNull AppWidgetProviderInfo appWidgetProviderInfo, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(appWidgetProviderInfo, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT < 31) {
            return AppWidgetSize.INSTANCE.m21572getUnknownrx25Pp4();
        }
        XmlResourceParser metadata = getMetadata(appWidgetProviderInfo, context);
        if (metadata == null) {
            return AppWidgetSize.INSTANCE.m21572getUnknownrx25Pp4();
        }
        try {
            moveToAttributeSet(metadata);
            Integer attributeValue = getAttributeValue(metadata, StyleableAttributes.WidgetSize.INSTANCE.getAttributeName());
            if (attributeValue != null) {
                int iM21547constructorimpl = AppWidgetSize.m21547constructorimpl(attributeValue.intValue());
                AutoCloseableKt.closeFinally(metadata, null);
                return iM21547constructorimpl;
            }
            int iM21565getAllrx25Pp4 = AppWidgetSize.INSTANCE.m21565getAllrx25Pp4();
            AutoCloseableKt.closeFinally(metadata, null);
            return iM21565getAllrx25Pp4;
        } finally {
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* JADX INFO: renamed from: filterPreviewSize-2Z8j5yc, reason: not valid java name */
    public static final int m21544filterPreviewSize2Z8j5yc(int i, int i2) {
        ArrayList arrayList = new ArrayList();
        ArrayList<AppWidgetSize> arrayListM21555toArrayListimpl = AppWidgetSize.m21555toArrayListimpl(i);
        ArrayList<AppWidgetSize> arrayListM21555toArrayListimpl2 = AppWidgetSize.m21555toArrayListimpl(i2);
        GlanceLog.INSTANCE.m2297d(TAG, "filtering widgetSize : " + arrayListM21555toArrayListimpl + " / previewSize : " + arrayListM21555toArrayListimpl2);
        if (arrayListM21555toArrayListimpl2.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayListM21555toArrayListimpl) {
                if (AppWidgetSize.m21546compareToL2j3NV4(((AppWidgetSize) obj).getMask(), AppWidgetSize.INSTANCE.m21566getExtraLargerx25Pp4()) < 0) {
                    arrayList2.add(obj);
                }
            }
            arrayList.addAll(arrayList2);
        } else {
            Iterator<T> it = arrayListM21555toArrayListimpl2.iterator();
            while (it.hasNext()) {
                int mask = ((AppWidgetSize) it.next()).getMask();
                AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
                if (!AppWidgetSize.m21550equalsimpl0(mask, companion.m21566getExtraLargerx25Pp4())) {
                    if (AppWidgetSize.m21548containsL2j3NV4(i, AppWidgetSize.m21550equalsimpl0(mask, companion.m21567getExtraLargeLongrx25Pp4()) ? companion.m21566getExtraLargerx25Pp4() : mask)) {
                        arrayList.add(AppWidgetSize.m21545boximpl(mask));
                    }
                }
            }
        }
        int iM21572getUnknownrx25Pp4 = AppWidgetSize.INSTANCE.m21572getUnknownrx25Pp4();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            iM21572getUnknownrx25Pp4 = AppWidgetSize.m21553plus8PP4PnY(iM21572getUnknownrx25Pp4, ((AppWidgetSize) it2.next()).getMask());
        }
        return iM21572getUnknownrx25Pp4;
    }

    public static final int generatedColorfulPreviewStates(@NotNull AppWidgetProviderInfo appWidgetProviderInfo) {
        Object objM22215constructorimpl;
        Intrinsics.checkNotNullParameter(appWidgetProviderInfo, "<this>");
        try {
            Result.Companion companion = Result.INSTANCE;
            Field declaredField = appWidgetProviderInfo.getClass().getDeclaredField(AppWidgetProviderInfoReflections.GENERATED_COLORFUL_PREVIEW_STATES);
            declaredField.setAccessible(true);
            objM22215constructorimpl = Result.m22215constructorimpl((Integer) declaredField.get(appWidgetProviderInfo));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m22221isFailureimpl(objM22215constructorimpl)) {
            objM22215constructorimpl = null;
        }
        Integer num = (Integer) objM22215constructorimpl;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int generatedMonotonePreviewStates(@NotNull AppWidgetProviderInfo appWidgetProviderInfo) {
        Object objM22215constructorimpl;
        Intrinsics.checkNotNullParameter(appWidgetProviderInfo, "<this>");
        try {
            Result.Companion companion = Result.INSTANCE;
            Field declaredField = appWidgetProviderInfo.getClass().getDeclaredField(AppWidgetProviderInfoReflections.GENERATED_MONOTONE_PREVIEW_STATES);
            declaredField.setAccessible(true);
            objM22215constructorimpl = Result.m22215constructorimpl((Integer) declaredField.get(appWidgetProviderInfo));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m22221isFailureimpl(objM22215constructorimpl)) {
            objM22215constructorimpl = null;
        }
        Integer num = (Integer) objM22215constructorimpl;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int generatedPreviewHostKeys(@NotNull AppWidgetProviderInfo appWidgetProviderInfo) {
        Object objM22215constructorimpl;
        Intrinsics.checkNotNullParameter(appWidgetProviderInfo, "<this>");
        try {
            Result.Companion companion = Result.INSTANCE;
            Field declaredField = appWidgetProviderInfo.getClass().getDeclaredField(AppWidgetProviderInfoReflections.GENERATED_PREVIEW_PREVIEW_HOST_KEYS);
            declaredField.setAccessible(true);
            objM22215constructorimpl = Result.m22215constructorimpl((Integer) declaredField.get(appWidgetProviderInfo));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m22221isFailureimpl(objM22215constructorimpl)) {
            objM22215constructorimpl = null;
        }
        Integer num = (Integer) objM22215constructorimpl;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    private static final Integer getAttributeValue(XmlResourceParser xmlResourceParser, String str) {
        Integer next;
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xmlResourceParser);
        if (attributeSetAsAttributeSet == null) {
            return null;
        }
        Iterator<Integer> it = RangesKt.until(0, attributeSetAsAttributeSet.getAttributeCount()).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics.areEqual(attributeSetAsAttributeSet.getAttributeName(next.intValue()), str)) {
                break;
            }
        }
        Integer num = next;
        if (num != null) {
            return Integer.valueOf(attributeSetAsAttributeSet.getAttributeIntValue(num.intValue(), AppWidgetSize.m21557toIntimpl(AppWidgetSize.INSTANCE.m21565getAllrx25Pp4())));
        }
        return null;
    }

    @RequiresApi(31)
    private static final XmlResourceParser getMetadata(AppWidgetProviderInfo appWidgetProviderInfo, Context context) {
        Object next;
        ActivityInfo activityInfo;
        PackageManager packageManager = context.getPackageManager();
        try {
            ActivityInfo activityInfo2 = appWidgetProviderInfo.getActivityInfo();
            if (activityInfo2 != null) {
                XmlResourceParser xmlResourceParserLoadXmlMetaData = activityInfo2.loadXmlMetaData(packageManager, "android.appwidget.provider");
                if (xmlResourceParserLoadXmlMetaData != null) {
                    return xmlResourceParserLoadXmlMetaData;
                }
            }
            return null;
        } catch (Exception e) {
            GlanceLog.INSTANCE.m2297d(TAG, "Exception " + e + " occurred during parsing " + appWidgetProviderInfo.provider + " meta data");
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            Intrinsics.checkNotNullExpressionValue(appWidgetManager, "getInstance(...)");
            Iterator<T> it = AppWidgetManagerKt.installedAllProviders(appWidgetManager, appWidgetProviderInfo.provider.getPackageName()).iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                AppWidgetProviderInfo appWidgetProviderInfo2 = (AppWidgetProviderInfo) next;
                if (Intrinsics.areEqual(appWidgetProviderInfo2.provider.getClassName(), appWidgetProviderInfo.provider.getClassName()) && Intrinsics.areEqual(appWidgetProviderInfo2.provider.getPackageName(), appWidgetProviderInfo.provider.getPackageName())) {
                    break;
                }
            }
            AppWidgetProviderInfo appWidgetProviderInfo3 = (AppWidgetProviderInfo) next;
            if (appWidgetProviderInfo3 == null || (activityInfo = appWidgetProviderInfo3.getActivityInfo()) == null) {
                return null;
            }
            return activityInfo.loadXmlMetaData(packageManager, "android.appwidget.provider");
        }
    }

    private static final XmlResourceParser moveToAttributeSet(XmlResourceParser xmlResourceParser) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlResourceParser.next();
            if (next == 1) {
                break;
            }
        } while (next != 2);
        return xmlResourceParser;
    }
}
