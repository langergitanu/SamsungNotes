package androidx.glance.oneui.template.preview;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.widget.RemoteViews;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.glance.oneui.common.AppWidgetHostType;
import androidx.glance.oneui.common.AppWidgetManagerKt;
import androidx.glance.oneui.common.AppWidgetProviderInfoKt;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.common.AppWidgetStyle;
import androidx.glance.oneui.common.DisplayDeviceType;
import androidx.glance.oneui.common.GlanceLog;
import androidx.glance.oneui.template.GlanceTemplateAppWidget;
import androidx.glance.oneui.template.GlanceTemplateAppWidgetReceiver;
import androidx.glance.state.GlanceState;
import androidx.glance.state.GlanceStateDefinition;
import androidx.glance.state.PreferencesGlanceStateDefinition;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000|\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\u001a*\u0010\u0002\u001a\u00020\u00012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0000ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a:\u0010\n\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r0\f\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u0004H\u0086@¢\u0006\u0002\u0010\u0012\u001aI\u0010\u0013\u001a\u0004\u0018\u0001H\u0014\"\u0004\b\u0000\u0010\u00142\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00162\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0080@ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a5\u0010\u0013\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u00042\u0006\u0010\u001a\u001a\u00020\u0007H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a \u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0000\u001a&\u0010%\u001a\u00020&2\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u0004H\u0086@¢\u0006\u0002\u0010\u0012\u001a&\u0010'\u001a\u00020&2\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u0004H\u0086@¢\u0006\u0002\u0010\u0012\u001aY\u0010(\u001a\u00020&2\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\"\u0010)\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020+\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0,\u0012\u0006\u0012\u0004\u0018\u00010-0*H\u0086@ø\u0001\u0000¢\u0006\u0004\b.\u0010/\u001ak\u00100\u001a\u00020&\"\u0004\b\u0000\u0010\u00142\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00162\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u00042\u0006\u00101\u001a\u00020\u00072\"\u0010)\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00140,\u0012\u0006\u0012\u0004\u0018\u00010-0*H\u0082@ø\u0001\u0000¢\u0006\u0004\b2\u00103\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00064"}, m13886d2 = {SearchConstants.TargetContents.TAG, "", "createUniquePreviewName", "widget", "Ljava/lang/Class;", "Landroidx/glance/oneui/template/GlanceTemplateAppWidget;", "size", "Landroidx/glance/oneui/common/AppWidgetSize;", "createUniquePreviewName-CZRyut0", "(Ljava/lang/Class;I)Ljava/lang/String;", "getAppWidgetPreview", "", "Lkotlin/Pair;", "Landroid/widget/RemoteViews;", "context", "Landroid/content/Context;", "receiver", "Landroidx/glance/oneui/template/GlanceTemplateAppWidgetReceiver;", "(Landroid/content/Context;Ljava/lang/Class;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPreviewState", "T", "definition", "Landroidx/glance/state/GlanceStateDefinition;", "getPreviewState-nb648eQ", "(Landroid/content/Context;Landroidx/glance/state/GlanceStateDefinition;Ljava/lang/Class;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/datastore/preferences/core/Preferences;", "templateSize", "getPreviewState-nZW8pK8", "(Landroid/content/Context;Ljava/lang/Class;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isCachedPreviewStateLost", "", "manager", "Landroid/appwidget/AppWidgetManager;", "providerInfo", "Landroid/appwidget/AppWidgetProviderInfo;", "state", "Landroidx/glance/oneui/template/preview/CachedPreviewAttributes;", "removeAppWidgetPreview", "", "updateAppWidgetPreview", "updateAppWidgetPreviewState", "updateState", "Lkotlin/Function2;", "Landroidx/datastore/preferences/core/MutablePreferences;", "Lkotlin/coroutines/Continuation;", "", "updateAppWidgetPreviewState-A7rLVw0", "(Landroid/content/Context;Ljava/lang/Class;ILkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAppWidgetPreviewStateInternal", "widgetSize", "updateAppWidgetPreviewStateInternal-rh_Hmrg", "(Landroid/content/Context;Landroidx/glance/state/GlanceStateDefinition;Ljava/lang/Class;ILkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nPreviewState.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PreviewState.kt\nandroidx/glance/oneui/template/preview/PreviewStateKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,217:1\n1855#2,2:218\n*S KotlinDebug\n*F\n+ 1 PreviewState.kt\nandroidx/glance/oneui/template/preview/PreviewStateKt\n*L\n94#1:218,2\n*E\n"})
public final class PreviewStateKt {

    @NotNull
    private static final String TAG = "GWT:PreviewState";

    /* JADX INFO: renamed from: androidx.glance.oneui.template.preview.PreviewStateKt$updateAppWidgetPreview$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.oneui.template.preview.PreviewStateKt", m14021f = "PreviewState.kt", m14022i = {0}, m14023l = {151}, m14024m = "updateAppWidgetPreview", m14025n = {"start"}, m14026s = {"J$0"})
    public static final class C34841 extends ContinuationImpl {
        long J$0;
        int label;
        /* synthetic */ Object result;

        public C34841(Continuation<? super C34841> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreviewStateKt.updateAppWidgetPreview(null, null, this);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: createUniquePreviewName-CZRyut0, reason: not valid java name */
    public static final String m21928createUniquePreviewNameCZRyut0(@NotNull Class<? extends GlanceTemplateAppWidget> widget, int i) {
        Intrinsics.checkNotNullParameter(widget, "widget");
        return AbstractC0541b.m774p("preview-", widget.getSimpleName(), CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR, AppWidgetSize.m21559toStringimpl(i));
    }

    @Nullable
    public static final Object getAppWidgetPreview(@NotNull Context context, @NotNull Class<? extends GlanceTemplateAppWidgetReceiver> cls, @NotNull Continuation<? super List<? extends Pair<AppWidgetSize, ? extends RemoteViews>>> continuation) {
        AppWidgetProviderInfo appWidgetProviderInfoFindProviderInfoFromAllReceiver = PreviewUtilsKt.findProviderInfoFromAllReceiver(context, cls);
        if (appWidgetProviderInfoFindProviderInfoFromAllReceiver == null) {
            return null;
        }
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        Intrinsics.checkNotNullExpressionValue(appWidgetManager, "getInstance(...)");
        List<Pair<AppWidgetSize, RemoteViews>> listM21540getTemplatePreviewhIv0bOU = AppWidgetManagerKt.m21540getTemplatePreviewhIv0bOU(appWidgetManager, appWidgetProviderInfoFindProviderInfoFromAllReceiver, AppWidgetSize.INSTANCE.m21565getAllrx25Pp4(), AppWidgetStyle.INSTANCE.m21586getColorfulWOdBnnM());
        if (listM21540getTemplatePreviewhIv0bOU == null) {
            return null;
        }
        return listM21540getTemplatePreviewhIv0bOU;
    }

    @Nullable
    /* JADX INFO: renamed from: getPreviewState-nZW8pK8, reason: not valid java name */
    public static final Object m21929getPreviewStatenZW8pK8(@NotNull Context context, @NotNull Class<? extends GlanceTemplateAppWidgetReceiver> cls, int i, @NotNull Continuation<? super Preferences> continuation) {
        return m21930getPreviewStatenb648eQ(context, PreferencesGlanceStateDefinition.INSTANCE, cls, i, continuation);
    }

    @Nullable
    /* JADX INFO: renamed from: getPreviewState-nb648eQ, reason: not valid java name */
    public static final <T> Object m21930getPreviewStatenb648eQ(@NotNull Context context, @NotNull GlanceStateDefinition<T> glanceStateDefinition, @NotNull Class<? extends GlanceTemplateAppWidgetReceiver> cls, int i, @NotNull Continuation<? super T> continuation) {
        GlanceTemplateAppWidget glanceTemplateAppWidgetFindAppWidgetFromReceiver = PreviewUtilsKt.findAppWidgetFromReceiver(cls);
        if (glanceTemplateAppWidgetFindAppWidgetFromReceiver != null) {
            return GlanceState.INSTANCE.getValue(context, glanceStateDefinition, m21928createUniquePreviewNameCZRyut0(glanceTemplateAppWidgetFindAppWidgetFromReceiver.getClass(), i), continuation);
        }
        return null;
    }

    public static final boolean isCachedPreviewStateLost(@NotNull AppWidgetManager manager, @NotNull AppWidgetProviderInfo providerInfo, @NotNull CachedPreviewAttributes state) {
        List<Pair<AppWidgetSize, RemoteViews>> listM21540getTemplatePreviewhIv0bOU;
        Intrinsics.checkNotNullParameter(manager, "manager");
        Intrinsics.checkNotNullParameter(providerInfo, "providerInfo");
        Intrinsics.checkNotNullParameter(state, "state");
        return Build.VERSION.SDK_INT >= 36 ? AppWidgetProviderInfoKt.generatedPreviewHostKeys(providerInfo) == 0 : AppWidgetProviderInfoKt.generatedColorfulPreviewStates(providerInfo) == 0 && AppWidgetProviderInfoKt.generatedMonotonePreviewStates(providerInfo) == 0 && (listM21540getTemplatePreviewhIv0bOU = AppWidgetManagerKt.m21540getTemplatePreviewhIv0bOU(manager, providerInfo, state.m21922getWidgetSizerx25Pp4(), state.m21923getWidgetStyleWOdBnnM())) != null && (listM21540getTemplatePreviewhIv0bOU.isEmpty() ^ true);
    }

    @Nullable
    public static final Object removeAppWidgetPreview(@NotNull Context context, @NotNull Class<? extends GlanceTemplateAppWidgetReceiver> cls, @NotNull Continuation<? super Unit> continuation) {
        AppWidgetProviderInfo appWidgetProviderInfoFindProviderInfoFromAllReceiver = PreviewUtilsKt.findProviderInfoFromAllReceiver(context, cls);
        if (appWidgetProviderInfoFindProviderInfoFromAllReceiver != null) {
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            Intrinsics.checkNotNull(appWidgetManager);
            if (!AppWidgetManagerKt.isSupportPreviewForHost(appWidgetManager) || Build.VERSION.SDK_INT < 36) {
                ComponentName provider = appWidgetProviderInfoFindProviderInfoFromAllReceiver.provider;
                Intrinsics.checkNotNullExpressionValue(provider, "provider");
                AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
                int iM21565getAllrx25Pp4 = companion.m21565getAllrx25Pp4();
                AppWidgetStyle.Companion companion2 = AppWidgetStyle.INSTANCE;
                AppWidgetManagerKt.m21542removeTemplatePreviewhIv0bOU(appWidgetManager, provider, iM21565getAllrx25Pp4, companion2.m21586getColorfulWOdBnnM());
                ComponentName provider2 = appWidgetProviderInfoFindProviderInfoFromAllReceiver.provider;
                Intrinsics.checkNotNullExpressionValue(provider2, "provider");
                AppWidgetManagerKt.m21542removeTemplatePreviewhIv0bOU(appWidgetManager, provider2, companion.m21565getAllrx25Pp4(), companion2.m21587getMonotoneWOdBnnM());
            } else {
                ComponentName provider3 = appWidgetProviderInfoFindProviderInfoFromAllReceiver.provider;
                Intrinsics.checkNotNullExpressionValue(provider3, "provider");
                AppWidgetManagerKt.removeWidgetPreviewForHost(appWidgetManager, provider3, 1048575);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object updateAppWidgetPreview(@NotNull Context context, @NotNull Class<? extends GlanceTemplateAppWidgetReceiver> cls, @NotNull Continuation<? super Unit> continuation) {
        C34841 c34841;
        long jCurrentTimeMillis;
        boolean zIsPreviewForHostUpdateAvailable;
        long j;
        if (continuation instanceof C34841) {
            c34841 = (C34841) continuation;
            int i = c34841.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c34841.label = i - Integer.MIN_VALUE;
            } else {
                c34841 = new C34841(continuation);
            }
        }
        Object obj = c34841.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c34841.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            GlanceTemplateAppWidget glanceTemplateAppWidgetFindAppWidgetFromReceiver = PreviewUtilsKt.findAppWidgetFromReceiver(cls);
            if (glanceTemplateAppWidgetFindAppWidgetFromReceiver == null) {
                return Unit.INSTANCE;
            }
            AppWidgetProviderInfo appWidgetProviderInfoFindProviderInfoFromAllReceiver = PreviewUtilsKt.findProviderInfoFromAllReceiver(context, cls);
            if (appWidgetProviderInfoFindProviderInfoFromAllReceiver != null) {
                jCurrentTimeMillis = System.currentTimeMillis();
                AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
                Intrinsics.checkNotNull(appWidgetManager);
                if (!AppWidgetManagerKt.isSupportPreviewForHost(appWidgetManager) || Build.VERSION.SDK_INT < 36) {
                    ComponentName provider = appWidgetProviderInfoFindProviderInfoFromAllReceiver.provider;
                    Intrinsics.checkNotNullExpressionValue(provider, "provider");
                    zIsPreviewForHostUpdateAvailable = PreviewUtilsKt.isPreviewUpdateAvailable(appWidgetManager, provider);
                } else {
                    ComponentName provider2 = appWidgetProviderInfoFindProviderInfoFromAllReceiver.provider;
                    Intrinsics.checkNotNullExpressionValue(provider2, "provider");
                    zIsPreviewForHostUpdateAvailable = AppWidgetManagerKt.isPreviewForHostUpdateAvailable(appWidgetManager, provider2);
                }
                GlanceLog.Companion companion = GlanceLog.INSTANCE;
                companion.m2301i(TAG, "isUpdateAvailable : " + zIsPreviewForHostUpdateAvailable);
                if (zIsPreviewForHostUpdateAvailable) {
                    int iExtractHostType = AppWidgetProviderInfoKt.extractHostType(appWidgetProviderInfoFindProviderInfoFromAllReceiver, context);
                    int iM21603getAllSDhLy5M = DisplayDeviceType.INSTANCE.m21603getAllSDhLy5M();
                    int iExtractPreviewSize = AppWidgetProviderInfoKt.extractPreviewSize(appWidgetProviderInfoFindProviderInfoFromAllReceiver, context);
                    int iExtractStyle = PreviewUtilsKt.extractStyle(appWidgetProviderInfoFindProviderInfoFromAllReceiver, context);
                    String strM21529toStringimpl = AppWidgetHostType.m21529toStringimpl(iExtractHostType);
                    String strM21559toStringimpl = AppWidgetSize.m21559toStringimpl(iExtractPreviewSize);
                    String strM21583toStringimpl = AppWidgetStyle.m21583toStringimpl(iExtractStyle);
                    StringBuilder sbM16m = AbstractC0000a.m16m("request update generated preview / ", strM21529toStringimpl, " ", strM21559toStringimpl, " ");
                    sbM16m.append(strM21583toStringimpl);
                    companion.m2301i(TAG, sbM16m.toString());
                    if (AppWidgetSize.m21550equalsimpl0(iExtractPreviewSize, AppWidgetSize.INSTANCE.m21572getUnknownrx25Pp4())) {
                        companion.m2297d(TAG, "Preview update is requested by unknown preview size");
                        return Unit.INSTANCE;
                    }
                    if (isCachedPreviewStateLost(appWidgetManager, appWidgetProviderInfoFindProviderInfoFromAllReceiver, new CachedPreviewAttributes(iExtractPreviewSize, iExtractStyle, iExtractHostType, iM21603getAllSDhLy5M, null))) {
                        companion.m2301i(TAG, "Preview cache data has been lost due to PACKAGE_CHANGED or LOCALE_CHANGED");
                        if (PreviewSessionManagerKt.getLatestSessionStates().containsKey(glanceTemplateAppWidgetFindAppWidgetFromReceiver.getClass().getName())) {
                            PreviewSessionManagerKt.getLatestSessionStates().remove(glanceTemplateAppWidgetFindAppWidgetFromReceiver.getClass().getName());
                        }
                    }
                    companion.m2301i(TAG, "updateAppWidgetPreview / " + glanceTemplateAppWidgetFindAppWidgetFromReceiver + SQLKeyword.COMMA + cls + SQLKeyword.COMMA + appWidgetProviderInfoFindProviderInfoFromAllReceiver);
                    CachedPreviewAttributes cachedPreviewAttributes = new CachedPreviewAttributes(iExtractPreviewSize, iExtractStyle, iExtractHostType, iM21603getAllSDhLy5M, null);
                    c34841.J$0 = jCurrentTimeMillis;
                    c34841.label = 1;
                    if (glanceTemplateAppWidgetFindAppWidgetFromReceiver.updatePreview$glance_oneui_template_release(context, cls, cachedPreviewAttributes, c34841) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    j = jCurrentTimeMillis;
                }
                GlanceLog.INSTANCE.m2301i(TAG, "updateAppWidgetPreview elapsed : " + (System.currentTimeMillis() - jCurrentTimeMillis));
            }
            return Unit.INSTANCE;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        j = c34841.J$0;
        ResultKt.throwOnFailure(obj);
        jCurrentTimeMillis = j;
        GlanceLog.INSTANCE.m2301i(TAG, "updateAppWidgetPreview elapsed : " + (System.currentTimeMillis() - jCurrentTimeMillis));
        return Unit.INSTANCE;
    }

    @Nullable
    /* JADX INFO: renamed from: updateAppWidgetPreviewState-A7rLVw0, reason: not valid java name */
    public static final Object m21931updateAppWidgetPreviewStateA7rLVw0(@NotNull Context context, @NotNull Class<? extends GlanceTemplateAppWidgetReceiver> cls, int i, @NotNull Function2<? super MutablePreferences, ? super Continuation<? super Unit>, ? extends Object> function2, @NotNull Continuation<? super Unit> continuation) {
        AppWidgetProviderInfo appWidgetProviderInfoFindProviderInfoFromAllReceiver = PreviewUtilsKt.findProviderInfoFromAllReceiver(context, cls);
        if (appWidgetProviderInfoFindProviderInfoFromAllReceiver == null) {
            GlanceLog.INSTANCE.m2301i(TAG, "Can't found providerInfo about " + cls);
            return Unit.INSTANCE;
        }
        int iExtractPreviewSize = AppWidgetProviderInfoKt.extractPreviewSize(appWidgetProviderInfoFindProviderInfoFromAllReceiver, context);
        GlanceLog.INSTANCE.m2297d(TAG, "Supported preview : " + AppWidgetSize.m21555toArrayListimpl(iExtractPreviewSize));
        Object objM21933updateAppWidgetPreviewStateInternalrh_Hmrg = m21933updateAppWidgetPreviewStateInternalrh_Hmrg(context, PreferencesGlanceStateDefinition.INSTANCE, cls, iExtractPreviewSize, new PreviewStateKt$updateAppWidgetPreviewState$2(function2, null), continuation);
        return objM21933updateAppWidgetPreviewStateInternalrh_Hmrg == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM21933updateAppWidgetPreviewStateInternalrh_Hmrg : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: updateAppWidgetPreviewState-A7rLVw0$default, reason: not valid java name */
    public static /* synthetic */ Object m21932updateAppWidgetPreviewStateA7rLVw0$default(Context context, Class cls, int i, Function2 function2, Continuation continuation, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = AppWidgetSize.INSTANCE.m21572getUnknownrx25Pp4();
        }
        return m21931updateAppWidgetPreviewStateA7rLVw0(context, cls, i, function2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX INFO: renamed from: updateAppWidgetPreviewStateInternal-rh_Hmrg, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object m21933updateAppWidgetPreviewStateInternalrh_Hmrg(Context context, GlanceStateDefinition<T> glanceStateDefinition, Class<? extends GlanceTemplateAppWidgetReceiver> cls, int i, Function2<? super T, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        PreviewStateKt$updateAppWidgetPreviewStateInternal$1 previewStateKt$updateAppWidgetPreviewStateInternal$1;
        Context context2;
        GlanceStateDefinition<T> glanceStateDefinition2;
        GlanceTemplateAppWidget glanceTemplateAppWidget;
        Iterator<T> it;
        Function2<? super T, ? super Continuation<? super T>, ? extends Object> function22;
        if (continuation instanceof PreviewStateKt$updateAppWidgetPreviewStateInternal$1) {
            previewStateKt$updateAppWidgetPreviewStateInternal$1 = (PreviewStateKt$updateAppWidgetPreviewStateInternal$1) continuation;
            int i2 = previewStateKt$updateAppWidgetPreviewStateInternal$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                previewStateKt$updateAppWidgetPreviewStateInternal$1.label = i2 - Integer.MIN_VALUE;
            } else {
                previewStateKt$updateAppWidgetPreviewStateInternal$1 = new PreviewStateKt$updateAppWidgetPreviewStateInternal$1(continuation);
            }
        }
        Object obj = previewStateKt$updateAppWidgetPreviewStateInternal$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = previewStateKt$updateAppWidgetPreviewStateInternal$1.label;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            GlanceLog.INSTANCE.m2297d(TAG, "updateAppWidgetPreviewState / " + cls + SQLKeyword.COMMA + AppWidgetSize.m21559toStringimpl(i));
            GlanceTemplateAppWidget glanceTemplateAppWidgetFindAppWidgetFromReceiver = PreviewUtilsKt.findAppWidgetFromReceiver(cls);
            if (glanceTemplateAppWidgetFindAppWidgetFromReceiver != null) {
                context2 = context;
                glanceStateDefinition2 = glanceStateDefinition;
                glanceTemplateAppWidget = glanceTemplateAppWidgetFindAppWidgetFromReceiver;
                it = AppWidgetSize.m21555toArrayListimpl(i).iterator();
                function22 = function2;
            }
            return Unit.INSTANCE;
        }
        if (i4 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        it = (Iterator) previewStateKt$updateAppWidgetPreviewStateInternal$1.L$4;
        glanceTemplateAppWidget = (GlanceTemplateAppWidget) previewStateKt$updateAppWidgetPreviewStateInternal$1.L$3;
        Function2<? super T, ? super Continuation<? super T>, ? extends Object> function23 = (Function2) previewStateKt$updateAppWidgetPreviewStateInternal$1.L$2;
        GlanceStateDefinition<T> glanceStateDefinition3 = (GlanceStateDefinition) previewStateKt$updateAppWidgetPreviewStateInternal$1.L$1;
        Context context3 = (Context) previewStateKt$updateAppWidgetPreviewStateInternal$1.L$0;
        ResultKt.throwOnFailure(obj);
        function22 = function23;
        glanceStateDefinition2 = glanceStateDefinition3;
        context2 = context3;
        PreviewStateKt$updateAppWidgetPreviewStateInternal$1 previewStateKt$updateAppWidgetPreviewStateInternal$12 = previewStateKt$updateAppWidgetPreviewStateInternal$1;
        while (it.hasNext()) {
            int mask = ((AppWidgetSize) it.next()).getMask();
            GlanceState glanceState = GlanceState.INSTANCE;
            String strM21928createUniquePreviewNameCZRyut0 = m21928createUniquePreviewNameCZRyut0(glanceTemplateAppWidget.getClass(), mask);
            previewStateKt$updateAppWidgetPreviewStateInternal$12.L$0 = context2;
            previewStateKt$updateAppWidgetPreviewStateInternal$12.L$1 = glanceStateDefinition2;
            previewStateKt$updateAppWidgetPreviewStateInternal$12.L$2 = function22;
            previewStateKt$updateAppWidgetPreviewStateInternal$12.L$3 = glanceTemplateAppWidget;
            previewStateKt$updateAppWidgetPreviewStateInternal$12.L$4 = it;
            previewStateKt$updateAppWidgetPreviewStateInternal$12.label = 1;
            if (glanceState.updateValue(context2, glanceStateDefinition2, strM21928createUniquePreviewNameCZRyut0, function22, previewStateKt$updateAppWidgetPreviewStateInternal$12) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
