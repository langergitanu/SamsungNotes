package androidx.glance.oneui.template.preview;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Xml;
import androidx.glance.appwidget.GlanceAppWidget;
import androidx.glance.appwidget.GlanceAppWidgetManager;
import androidx.glance.oneui.common.AppWidgetStyle;
import androidx.glance.oneui.common.StyleableAttributes;
import androidx.glance.oneui.template.GlanceTemplateAppWidget;
import androidx.glance.oneui.template.GlanceTemplateAppWidgetReceiver;
import androidx.glance.oneui.template.utils.AppWidgetManagerReflections;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u0004\u0018\u00010\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0000\u001a\"\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0003H\u0000\u001a\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0001H\u0000\u001a\u0019\u0010\f\u001a\u00020\r*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¢\u0006\u0002\u0010\u000e\u001a\u0012\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013¨\u0006\u0014"}, m13886d2 = {"findAppWidgetFromReceiver", "Landroidx/glance/oneui/template/GlanceTemplateAppWidget;", "receiver", "Ljava/lang/Class;", "findProviderInfoFromAllReceiver", "Landroid/appwidget/AppWidgetProviderInfo;", "context", "Landroid/content/Context;", "Landroidx/glance/oneui/template/GlanceTemplateAppWidgetReceiver;", "findReceiversFromAppWidget", "", "appWidget", "extractStyle", "Landroidx/glance/oneui/common/AppWidgetStyle;", "(Landroid/appwidget/AppWidgetProviderInfo;Landroid/content/Context;)I", "isPreviewUpdateAvailable", "", "Landroid/appwidget/AppWidgetManager;", "provider", "Landroid/content/ComponentName;", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nPreviewUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PreviewUtils.kt\nandroidx/glance/oneui/template/preview/PreviewUtilsKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,106:1\n1109#2,2:107\n288#3,2:109\n766#3:111\n857#3,2:112\n1549#3:114\n1620#3,3:115\n288#3,2:119\n1#4:118\n*S KotlinDebug\n*F\n+ 1 PreviewUtils.kt\nandroidx/glance/oneui/template/preview/PreviewUtilsKt\n*L\n20#1:107,2\n33#1:109,2\n44#1:111\n44#1:112,2\n55#1:114\n55#1:115,3\n89#1:119,2\n*E\n"})
public final class PreviewUtilsKt {
    public static final int extractStyle(@NotNull AppWidgetProviderInfo appWidgetProviderInfo, @NotNull Context context) {
        int next;
        Integer next2;
        Intrinsics.checkNotNullParameter(appWidgetProviderInfo, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            if (Build.VERSION.SDK_INT >= 31) {
                XmlResourceParser xmlResourceParserLoadXmlMetaData = appWidgetProviderInfo.getActivityInfo().loadXmlMetaData(context.getPackageManager(), "android.appwidget.provider");
                try {
                    Ref.IntRef intRef = new Ref.IntRef();
                    do {
                        next = xmlResourceParserLoadXmlMetaData.next();
                        intRef.element = next;
                        if (next == 1) {
                            break;
                        }
                    } while (next != 2);
                    AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xmlResourceParserLoadXmlMetaData);
                    Iterator<Integer> it = RangesKt.until(0, attributeSetAsAttributeSet.getAttributeCount()).iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it.next();
                        if (Intrinsics.areEqual(attributeSetAsAttributeSet.getAttributeName(next2.intValue()), StyleableAttributes.WidgetStyle.INSTANCE.getAttributeName())) {
                            break;
                        }
                    }
                    Integer num = next2;
                    if (num != null) {
                        int iM21575constructorimpl = AppWidgetStyle.m21575constructorimpl(attributeSetAsAttributeSet.getAttributeIntValue(num.intValue(), AppWidgetStyle.m21582toIntimpl(AppWidgetStyle.INSTANCE.m21586getColorfulWOdBnnM())));
                        AutoCloseableKt.closeFinally(xmlResourceParserLoadXmlMetaData, null);
                        return iM21575constructorimpl;
                    }
                    int iM21586getColorfulWOdBnnM = AppWidgetStyle.INSTANCE.m21586getColorfulWOdBnnM();
                    AutoCloseableKt.closeFinally(xmlResourceParserLoadXmlMetaData, null);
                    return iM21586getColorfulWOdBnnM;
                } finally {
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return AppWidgetStyle.INSTANCE.m21586getColorfulWOdBnnM();
    }

    @Nullable
    public static final GlanceTemplateAppWidget findAppWidgetFromReceiver(@NotNull Class<?> receiver) {
        Object objM22215constructorimpl;
        GlanceTemplateAppWidget glanceTemplateAppWidget;
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        try {
            Result.Companion companion = Result.INSTANCE;
            Object objNewInstance = Class.forName(receiver.getName()).newInstance();
            if ((objNewInstance instanceof GlanceTemplateAppWidgetReceiver) && (((GlanceTemplateAppWidgetReceiver) objNewInstance).getGlanceAppWidget() instanceof GlanceTemplateAppWidget)) {
                GlanceAppWidget glanceAppWidget = ((GlanceTemplateAppWidgetReceiver) objNewInstance).getGlanceAppWidget();
                Intrinsics.checkNotNull(glanceAppWidget, "null cannot be cast to non-null type androidx.glance.oneui.template.GlanceTemplateAppWidget");
                glanceTemplateAppWidget = (GlanceTemplateAppWidget) glanceAppWidget;
            } else {
                glanceTemplateAppWidget = null;
            }
            objM22215constructorimpl = Result.m22215constructorimpl(glanceTemplateAppWidget);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        Result.m22218exceptionOrNullimpl(objM22215constructorimpl);
        return (GlanceTemplateAppWidget) (Result.m22221isFailureimpl(objM22215constructorimpl) ? null : objM22215constructorimpl);
    }

    @Nullable
    public static final AppWidgetProviderInfo findProviderInfoFromAllReceiver(@NotNull Context context, @NotNull Class<? extends GlanceTemplateAppWidgetReceiver> receiver) {
        Object next;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        Iterator<T> it = new GlanceAppWidgetManager(context).getAppWidgetProviderInfoList(context.getPackageName()).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            AppWidgetProviderInfo appWidgetProviderInfo = (AppWidgetProviderInfo) next;
            if (Intrinsics.areEqual(appWidgetProviderInfo.provider.getPackageName(), context.getPackageName()) && Intrinsics.areEqual(appWidgetProviderInfo.provider.getClassName(), receiver.getName())) {
                break;
            }
        }
        return (AppWidgetProviderInfo) next;
    }

    @NotNull
    public static final List<GlanceTemplateAppWidgetReceiver> findReceiversFromAppWidget(@NotNull Context context, @NotNull GlanceTemplateAppWidget appWidget) throws IllegalAccessException, InstantiationException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appWidget, "appWidget");
        List<AppWidgetProviderInfo> installedProviders = AppWidgetManager.getInstance(context).getInstalledProviders();
        Intrinsics.checkNotNullExpressionValue(installedProviders, "getInstalledProviders(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : installedProviders) {
            AppWidgetProviderInfo appWidgetProviderInfo = (AppWidgetProviderInfo) obj;
            if (Intrinsics.areEqual(context.getPackageName(), appWidgetProviderInfo.provider.getPackageName())) {
                Object objNewInstance = Class.forName(appWidgetProviderInfo.provider.getClassName()).newInstance();
                if ((objNewInstance instanceof GlanceTemplateAppWidgetReceiver) && Intrinsics.areEqual(((GlanceTemplateAppWidgetReceiver) objNewInstance).getGlanceAppWidget().getClass(), appWidget.getClass())) {
                    arrayList.add(obj);
                }
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.m13952k(arrayList));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object objNewInstance2 = Class.forName(((AppWidgetProviderInfo) it.next()).provider.getClassName()).newInstance();
            Intrinsics.checkNotNull(objNewInstance2, "null cannot be cast to non-null type androidx.glance.oneui.template.GlanceTemplateAppWidgetReceiver");
            arrayList2.add((GlanceTemplateAppWidgetReceiver) objNewInstance2);
        }
        return arrayList2;
    }

    public static final boolean isPreviewUpdateAvailable(@NotNull AppWidgetManager appWidgetManager, @NotNull ComponentName provider) {
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
            if (Intrinsics.areEqual(method.getName(), AppWidgetManagerReflections.IS_PREVIEW_UPDATE_AVAILABLE)) {
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
}
