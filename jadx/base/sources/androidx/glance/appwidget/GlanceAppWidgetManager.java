package androidx.glance.appwidget;

import android.app.Application;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.RemoteViews;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.p109ui.unit.DpSize;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.datastore.preferences.PreferenceDataStoreDelegateKt;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesFactory;
import androidx.datastore.preferences.core.PreferencesKeys;
import androidx.datastore.preferences.core.PreferencesKt;
import androidx.glance.GlanceId;
import androidx.glance.oneui.common.AppWidgetManagerKt;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.common.GlanceLog;
import androidx.glance.oneui.common.appwidgetsize.AppWidgetSizeInfo;
import androidx.glance.oneui.common.appwidgetsize.HostId;
import androidx.glance.oneui.common.appwidgetsize.HostKey;
import androidx.glance.oneui.common.appwidgetsize.HostSizeInfo;
import androidx.glance.oneui.common.appwidgetsize.SizeInfoKt;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 X2\u00020\u0001:\u0003WXYB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000f\u001a\u00020\nH\u0082@¢\u0006\u0002\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0012H\u0000¢\u0006\u0002\b\u0013J\u0010\u0010\u0014\u001a\u00020\u0012H\u0080@¢\u0006\u0004\b\u0015\u0010\u0010J\u0010\u0010\u0016\u001a\u00020\u0012H\u0081@¢\u0006\u0004\b\u0017\u0010\u0010J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\nH\u0002J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#H\u0007J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001cH\u0007J\u0014\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020%0(H\u0007J\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020*0 2\u0006\u0010\u001d\u001a\u00020\u001eH\u0086@¢\u0006\u0002\u0010+J\u0010\u0010,\u001a\u0004\u0018\u00010\u001e2\u0006\u0010-\u001a\u00020.J\u000e\u0010,\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\u001cJ\u0010\u0010/\u001a\u0004\u0018\u00010\u001e2\u0006\u0010&\u001a\u00020\u001cJ&\u00100\u001a\b\u0012\u0004\u0012\u00020\u001e0 \"\b\b\u0000\u00101*\u0002022\f\u00103\u001a\b\u0012\u0004\u0012\u0002H104H\u0002J,\u00105\u001a\b\u0012\u0004\u0012\u00020\u001e0 \"\b\b\u0000\u00101*\u0002022\f\u00103\u001a\b\u0012\u0004\u0012\u0002H104H\u0086@¢\u0006\u0002\u00106J\u000e\u00107\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u000e\u00108\u001a\u00020\u0019H\u0082@¢\u0006\u0002\u0010\u0010J\u0018\u00109\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010:H\u0081@¢\u0006\u0004\b;\u0010\u0010JJ\u0010<\u001a\u00020=\"\b\b\u0000\u00101*\u00020>2\f\u0010?\u001a\b\u0012\u0004\u0012\u0002H1042\n\b\u0002\u0010@\u001a\u0004\u0018\u0001022\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010CH\u0086@¢\u0006\u0002\u0010DJ@\u0010E\u001a\u00020\u00122\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020M2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020O0 H\u0007ø\u0001\u0000¢\u0006\u0004\bP\u0010QJ4\u0010R\u001a\u00020\u0012\"\b\b\u0000\u0010S*\u00020>\"\b\b\u0001\u0010T*\u0002022\u0006\u0010?\u001a\u0002HS2\u0006\u00103\u001a\u0002HTH\u0080@¢\u0006\u0004\bU\u0010VR\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006Z"}, m13886d2 = {"Landroidx/glance/appwidget/GlanceAppWidgetManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "appWidgetManager", "Landroid/appwidget/AppWidgetManager;", "kotlin.jvm.PlatformType", "dataStore", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "getDataStore", "()Landroidx/datastore/core/DataStore;", "dataStore$delegate", "Lkotlin/Lazy;", "addAllReceiversAndProvidersToPreferences", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cleanCacheData", "", "cleanCacheData$glance_appwidget_release", "cleanReceivers", "cleanReceivers$glance_appwidget_release", "clearDataStore", "clearDataStore$glance_appwidget_release", "createState", "Landroidx/glance/appwidget/GlanceAppWidgetManager$State;", "prefs", "getAppWidgetId", "", "glanceId", "Landroidx/glance/GlanceId;", "getAppWidgetProviderInfoList", "", "Landroid/appwidget/AppWidgetProviderInfo;", "packageName", "", "getAppWidgetSizeInfo", "Landroidx/glance/oneui/common/appwidgetsize/HostSizeInfo;", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "getAppWidgetSizeInfos", "", "getAppWidgetSizes", "Landroidx/compose/ui/unit/DpSize;", "(Landroidx/glance/GlanceId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGlanceIdBy", "configurationIntent", "Landroid/content/Intent;", "getGlanceIdByOrNull", "getGlanceIdByProvider", "T", "Landroidx/glance/appwidget/GlanceAppWidget;", "provider", "Ljava/lang/Class;", "getGlanceIds", "(Ljava/lang/Class;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOrCreateDataStore", "getState", "listKnownReceivers", "", "listKnownReceivers$glance_appwidget_release", "requestPinGlanceAppWidget", "", "Landroidx/glance/appwidget/GlanceAppWidgetReceiver;", "receiver", "preview", "previewState", "successCallback", "Landroid/app/PendingIntent;", "(Ljava/lang/Class;Landroidx/glance/appwidget/GlanceAppWidget;Ljava/lang/Object;Landroid/app/PendingIntent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setAppWidgetSizeInfo", "hostId", "Landroidx/glance/oneui/common/appwidgetsize/HostId;", "hostType", "Landroidx/glance/oneui/common/AppWidgetHostType;", "displayDeviceType", "Landroidx/glance/oneui/common/DisplayDeviceType;", "appWidgetStyle", "Landroidx/glance/oneui/common/AppWidgetStyle;", "appWidgetSizeInfos", "Landroidx/glance/oneui/common/appwidgetsize/AppWidgetSizeInfo;", "setAppWidgetSizeInfo-dw4hRxs", "(Landroidx/glance/oneui/common/appwidgetsize/HostId;IIILjava/util/List;)V", "updateReceiver", "R", "P", "updateReceiver$glance_appwidget_release", "(Landroidx/glance/appwidget/GlanceAppWidgetReceiver;Landroidx/glance/appwidget/GlanceAppWidget;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "AppWidgetManagerApi26Impl", "Companion", "State", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nGlanceAppWidgetManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlanceAppWidgetManager.kt\nandroidx/glance/appwidget/GlanceAppWidgetManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 5 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 6 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt\n*L\n1#1,569:1\n1603#2,9:570\n1855#2:579\n1856#2:581\n1612#2:582\n1360#2:584\n1446#2,2:585\n1448#2,3:591\n766#2:594\n857#2,2:595\n766#2:597\n857#2,2:598\n1360#2:600\n1446#2,2:601\n1448#2,3:607\n223#2,2:610\n766#2:612\n857#2,2:613\n1549#2:615\n1620#2,3:616\n766#2:619\n857#2,2:620\n1603#2,9:622\n1855#2:631\n1856#2:633\n1612#2:634\n1855#2:636\n1856#2:644\n1855#2,2:645\n1855#2,2:647\n1#3:580\n1#3:583\n1#3:632\n1#3:635\n11095#4:587\n11430#4,3:588\n11095#4:603\n11430#4,3:604\n372#5,7:637\n48#6,4:649\n*S KotlinDebug\n*F\n+ 1 GlanceAppWidgetManager.kt\nandroidx/glance/appwidget/GlanceAppWidgetManager\n*L\n133#1:570,9\n133#1:579\n133#1:581\n133#1:582\n177#1:584\n177#1:585,2\n177#1:591,3\n184#1:594\n184#1:595,2\n188#1:597\n188#1:598,2\n199#1:600\n199#1:601,2\n199#1:607,3\n310#1:610,2\n337#1:612\n337#1:613,2\n338#1:615\n338#1:616,3\n383#1:619\n383#1:620,2\n384#1:622,9\n384#1:631\n384#1:633\n384#1:634\n504#1:636\n504#1:644\n531#1:645,2\n558#1:647,2\n133#1:580\n384#1:632\n178#1:587\n178#1:588,3\n200#1:603\n200#1:604,3\n513#1:637,7\n451#1:649,4\n*E\n"})
public final class GlanceAppWidgetManager {

    @NotNull
    private static final ReadOnlyProperty<Context, DataStore<Preferences>> appManagerDataStore$delegate;

    @Nullable
    private static List<? extends AppWidgetProviderInfo> cachedAppWidgetProviderInfo;

    @Nullable
    private static DataStore<Preferences> dataStoreSingleton;

    @NotNull
    private static final Preferences.Key<Set<String>> providersKey;
    private final AppWidgetManager appWidgetManager;

    @NotNull
    private final Context context;

    /* JADX INFO: renamed from: dataStore$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy dataStore;

    @NotNull
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RequiresApi(26)
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J,\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007¨\u0006\u000e"}, m13886d2 = {"Landroidx/glance/appwidget/GlanceAppWidgetManager$AppWidgetManagerApi26Impl;", "", "()V", "isRequestPinAppWidgetSupported", "", "manager", "Landroid/appwidget/AppWidgetManager;", "requestPinAppWidget", "target", "Landroid/content/ComponentName;", "extras", "Landroid/os/Bundle;", "successCallback", "Landroid/app/PendingIntent;", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class AppWidgetManagerApi26Impl {

        @NotNull
        public static final AppWidgetManagerApi26Impl INSTANCE = new AppWidgetManagerApi26Impl();

        private AppWidgetManagerApi26Impl() {
        }

        @DoNotInline
        public final boolean isRequestPinAppWidgetSupported(@NotNull AppWidgetManager manager) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            return manager.isRequestPinAppWidgetSupported();
        }

        @DoNotInline
        public final boolean requestPinAppWidget(@NotNull AppWidgetManager manager, @NotNull ComponentName target, @Nullable Bundle extras, @Nullable PendingIntent successCallback) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            Intrinsics.checkNotNullParameter(target, "target");
            return manager.requestPinAppWidget(target, extras, successCallback);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\u0014\u001a\u00020\fH\u0002J\f\u0010\u0015\u001a\u00020\f*\u00020\u0016H\u0002J\f\u0010\u0015\u001a\u00020\f*\u00020\u0017H\u0002J\u000e\u0010\u0018\u001a\u0004\u0018\u00010\u0017*\u00020\u0005H\u0002R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R%\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0007*\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, m13886d2 = {"Landroidx/glance/appwidget/GlanceAppWidgetManager$Companion;", "", "()V", "cachedAppWidgetProviderInfo", "", "Landroid/appwidget/AppWidgetProviderInfo;", "dataStoreSingleton", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "providersKey", "Landroidx/datastore/preferences/core/Preferences$Key;", "", "", "appManagerDataStore", "Landroid/content/Context;", "getAppManagerDataStore", "(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", "appManagerDataStore$delegate", "Lkotlin/properties/ReadOnlyProperty;", "providerKey", "provider", "canonicalName", "Landroidx/glance/appwidget/GlanceAppWidget;", "Landroidx/glance/appwidget/GlanceAppWidgetReceiver;", "maybeGlanceAppWidgetReceiver", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nGlanceAppWidgetManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlanceAppWidgetManager.kt\nandroidx/glance/appwidget/GlanceAppWidgetManager$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,569:1\n1#2:570\n*E\n"})
    public static final class Companion {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property2(new PropertyReference2Impl(Companion.class, "appManagerDataStore", "getAppManagerDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 0))};

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String canonicalName(GlanceAppWidgetReceiver glanceAppWidgetReceiver) {
            String canonicalName = glanceAppWidgetReceiver.getClass().getCanonicalName();
            if (canonicalName != null) {
                return canonicalName;
            }
            throw new IllegalArgumentException("no receiver name");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final DataStore<Preferences> getAppManagerDataStore(Context context) {
            return (DataStore) GlanceAppWidgetManager.appManagerDataStore$delegate.getValue(context, $$delegatedProperties[0]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final GlanceAppWidgetReceiver maybeGlanceAppWidgetReceiver(AppWidgetProviderInfo appWidgetProviderInfo) throws IllegalAccessException, InstantiationException, InvocationTargetException {
            Object objNewInstance = Class.forName(appWidgetProviderInfo.provider.getClassName()).getDeclaredConstructor(null).newInstance(null);
            if (objNewInstance instanceof GlanceAppWidgetReceiver) {
                return (GlanceAppWidgetReceiver) objNewInstance;
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Preferences.Key<String> providerKey(String provider) {
            return PreferencesKeys.stringKey("provider:" + provider);
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String canonicalName(GlanceAppWidget glanceAppWidget) {
            String canonicalName = glanceAppWidget.getClass().getCanonicalName();
            if (canonicalName != null) {
                return canonicalName;
            }
            throw new IllegalArgumentException("no provider name");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001b\b\u0016\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006B7\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u001a\b\u0002\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\b0\u0003¢\u0006\u0002\u0010\tJ\u0015\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u001b\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\b0\u0003HÆ\u0003J;\u0010\u000f\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u001a\b\u0002\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\b0\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R#\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0016"}, m13886d2 = {"Landroidx/glance/appwidget/GlanceAppWidgetManager$State;", "", "receiverToProviderName", "", "Landroid/content/ComponentName;", "", "(Ljava/util/Map;)V", "providerNameToReceivers", "", "(Ljava/util/Map;Ljava/util/Map;)V", "getProviderNameToReceivers", "()Ljava/util/Map;", "getReceiverToProviderName", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final /* data */ class State {

        @NotNull
        private final Map<String, List<ComponentName>> providerNameToReceivers;

        @NotNull
        private final Map<ComponentName, String> receiverToProviderName;

        /* JADX WARN: Multi-variable type inference failed */
        public State() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, Map map, Map map2, int i, Object obj) {
            if ((i & 1) != 0) {
                map = state.receiverToProviderName;
            }
            if ((i & 2) != 0) {
                map2 = state.providerNameToReceivers;
            }
            return state.copy(map, map2);
        }

        @NotNull
        public final Map<ComponentName, String> component1() {
            return this.receiverToProviderName;
        }

        @NotNull
        public final Map<String, List<ComponentName>> component2() {
            return this.providerNameToReceivers;
        }

        @NotNull
        public final State copy(@NotNull Map<ComponentName, String> receiverToProviderName, @NotNull Map<String, ? extends List<ComponentName>> providerNameToReceivers) {
            Intrinsics.checkNotNullParameter(receiverToProviderName, "receiverToProviderName");
            Intrinsics.checkNotNullParameter(providerNameToReceivers, "providerNameToReceivers");
            return new State(receiverToProviderName, providerNameToReceivers);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.receiverToProviderName, state.receiverToProviderName) && Intrinsics.areEqual(this.providerNameToReceivers, state.providerNameToReceivers);
        }

        @NotNull
        public final Map<String, List<ComponentName>> getProviderNameToReceivers() {
            return this.providerNameToReceivers;
        }

        @NotNull
        public final Map<ComponentName, String> getReceiverToProviderName() {
            return this.receiverToProviderName;
        }

        public int hashCode() {
            return this.providerNameToReceivers.hashCode() + (this.receiverToProviderName.hashCode() * 31);
        }

        @NotNull
        public String toString() {
            return "State(receiverToProviderName=" + this.receiverToProviderName + ", providerNameToReceivers=" + this.providerNameToReceivers + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public State(@NotNull Map<ComponentName, String> receiverToProviderName, @NotNull Map<String, ? extends List<ComponentName>> providerNameToReceivers) {
            Intrinsics.checkNotNullParameter(receiverToProviderName, "receiverToProviderName");
            Intrinsics.checkNotNullParameter(providerNameToReceivers, "providerNameToReceivers");
            this.receiverToProviderName = receiverToProviderName;
            this.providerNameToReceivers = providerNameToReceivers;
        }

        public /* synthetic */ State(Map map, Map map2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? MapsKt.emptyMap() : map, (i & 2) != 0 ? MapsKt.emptyMap() : map2);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public State(@NotNull Map<ComponentName, String> receiverToProviderName) {
            this(receiverToProviderName, GlanceAppWidgetManagerKt.reverseMapping(receiverToProviderName));
            Intrinsics.checkNotNullParameter(receiverToProviderName, "receiverToProviderName");
        }
    }

    /* JADX INFO: renamed from: androidx.glance.appwidget.GlanceAppWidgetManager$addAllReceiversAndProvidersToPreferences$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.appwidget.GlanceAppWidgetManager", m14021f = "GlanceAppWidgetManager.kt", m14022i = {}, m14023l = {389}, m14024m = "addAllReceiversAndProvidersToPreferences", m14025n = {}, m14026s = {})
    public static final class C28521 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C28521(Continuation<? super C28521> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GlanceAppWidgetManager.this.addAllReceiversAndProvidersToPreferences(this);
        }
    }

    /* JADX INFO: renamed from: androidx.glance.appwidget.GlanceAppWidgetManager$addAllReceiversAndProvidersToPreferences$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@"}, m13886d2 = {"<anonymous>", "Landroidx/datastore/preferences/core/Preferences;", "prefs"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.appwidget.GlanceAppWidgetManager$addAllReceiversAndProvidersToPreferences$2", m14021f = "GlanceAppWidgetManager.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    @SourceDebugExtension({"SMAP\nGlanceAppWidgetManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlanceAppWidgetManager.kt\nandroidx/glance/appwidget/GlanceAppWidgetManager$addAllReceiversAndProvidersToPreferences$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,569:1\n1549#2:570\n1620#2,3:571\n1855#2,2:574\n*S KotlinDebug\n*F\n+ 1 GlanceAppWidgetManager.kt\nandroidx/glance/appwidget/GlanceAppWidgetManager$addAllReceiversAndProvidersToPreferences$2\n*L\n392#1:570\n392#1:571,3\n393#1:574,2\n*E\n"})
    public static final class C28532 extends SuspendLambda implements Function2<Preferences, Continuation<? super Preferences>, Object> {
        final /* synthetic */ List<GlanceAppWidgetReceiver> $installedGlanceAppWidgetReceivers;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C28532(List<? extends GlanceAppWidgetReceiver> list, Continuation<? super C28532> continuation) {
            super(2, continuation);
            this.$installedGlanceAppWidgetReceivers = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C28532 c28532 = new C28532(this.$installedGlanceAppWidgetReceivers, continuation);
            c28532.L$0 = obj;
            return c28532;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull Preferences preferences, @Nullable Continuation<? super Preferences> continuation) {
            return ((C28532) create(preferences, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            MutablePreferences mutablePreferences = ((Preferences) this.L$0).toMutablePreferences();
            List<GlanceAppWidgetReceiver> list = this.$installedGlanceAppWidgetReceivers;
            Preferences.Key key = GlanceAppWidgetManager.providersKey;
            List<GlanceAppWidgetReceiver> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(list2));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(((GlanceAppWidgetReceiver) it.next()).getClass().getName());
            }
            mutablePreferences.set(key, CollectionsKt.toSet(arrayList));
            for (GlanceAppWidgetReceiver glanceAppWidgetReceiver : list2) {
                mutablePreferences.set(GlanceAppWidgetManager.Companion.providerKey(GlanceAppWidgetManager.Companion.canonicalName(glanceAppWidgetReceiver)), GlanceAppWidgetManager.Companion.canonicalName(glanceAppWidgetReceiver.getGlanceAppWidget()));
            }
            return mutablePreferences.toPreferences();
        }
    }

    /* JADX INFO: renamed from: androidx.glance.appwidget.GlanceAppWidgetManager$getGlanceIds$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.appwidget.GlanceAppWidgetManager", m14021f = "GlanceAppWidgetManager.kt", m14022i = {0, 0}, m14023l = {167}, m14024m = "getGlanceIds", m14025n = {"this", "provider"}, m14026s = {"L$0", "L$1"})
    public static final class C28551<T extends GlanceAppWidget> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C28551(Continuation<? super C28551> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GlanceAppWidgetManager.this.getGlanceIds(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.glance.appwidget.GlanceAppWidgetManager$getState$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.appwidget.GlanceAppWidgetManager", m14021f = "GlanceAppWidgetManager.kt", m14022i = {0}, m14023l = {153, 154}, m14024m = "getState", m14025n = {"this"}, m14026s = {"L$0"})
    public static final class C28561 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C28561(Continuation<? super C28561> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GlanceAppWidgetManager.this.getState(this);
        }
    }

    /* JADX INFO: renamed from: androidx.glance.appwidget.GlanceAppWidgetManager$requestPinGlanceAppWidget$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.appwidget.GlanceAppWidgetManager", m14021f = "GlanceAppWidgetManager.kt", m14022i = {0, 0, 0, 0}, m14023l = {313}, m14024m = "requestPinGlanceAppWidget", m14025n = {"this", "successCallback", "target", "$this$requestPinGlanceAppWidget_u24lambda_u2415"}, m14026s = {"L$0", "L$1", "L$2", "L$4"})
    public static final class C28571<T extends GlanceAppWidgetReceiver> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C28571(Continuation<? super C28571> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GlanceAppWidgetManager.this.requestPinGlanceAppWidget(null, null, null, null, this);
        }
    }

    static {
        appManagerDataStore$delegate = PreferenceDataStoreDelegateKt.preferencesDataStore$default(Build.VERSION.SDK_INT >= 28 ? AbstractC0541b.m772n("GlanceAppWidgetManager_", Application.getProcessName()) : "GlanceAppWidgetManager", new ReplaceFileCorruptionHandler(new Function1<CorruptionException, Preferences>() { // from class: androidx.glance.appwidget.GlanceAppWidgetManager$Companion$appManagerDataStore$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Preferences invoke(@NotNull CorruptionException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.printStackTrace();
                return PreferencesFactory.createEmpty();
            }
        }), null, CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)).plus(new C2858x32d97056(CoroutineExceptionHandler.INSTANCE))), 4, null);
        providersKey = PreferencesKeys.stringSetKey("list::Providers");
    }

    public GlanceAppWidgetManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        GlanceLog.Companion companion = GlanceLog.INSTANCE;
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        companion.init(packageName);
        this.appWidgetManager = AppWidgetManager.getInstance(context);
        this.dataStore = LazyKt.lazy(new Function0<DataStore<Preferences>>() { // from class: androidx.glance.appwidget.GlanceAppWidgetManager$dataStore$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final DataStore<Preferences> invoke() {
                return this.this$0.getOrCreateDataStore();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object addAllReceiversAndProvidersToPreferences(Continuation<? super Preferences> continuation) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        C28521 c28521;
        if (continuation instanceof C28521) {
            c28521 = (C28521) continuation;
            int i = c28521.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c28521.label = i - Integer.MIN_VALUE;
            } else {
                c28521 = new C28521(continuation);
            }
        }
        Object objUpdateData = c28521.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c28521.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objUpdateData);
                List<AppWidgetProviderInfo> appWidgetProviderInfoList = getAppWidgetProviderInfoList(this.context.getPackageName());
                ArrayList arrayList = new ArrayList();
                for (Object obj : appWidgetProviderInfoList) {
                    if (Intrinsics.areEqual(((AppWidgetProviderInfo) obj).provider.getPackageName(), this.context.getPackageName())) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    GlanceAppWidgetReceiver glanceAppWidgetReceiverMaybeGlanceAppWidgetReceiver = Companion.maybeGlanceAppWidgetReceiver((AppWidgetProviderInfo) it.next());
                    if (glanceAppWidgetReceiverMaybeGlanceAppWidgetReceiver != null) {
                        arrayList2.add(glanceAppWidgetReceiverMaybeGlanceAppWidgetReceiver);
                    }
                }
                GlanceLog.INSTANCE.m2297d("GWT:GAppWidgetManager", "Installed receivers : " + arrayList2.size());
                DataStore<Preferences> dataStore = getDataStore();
                C28532 c28532 = new C28532(arrayList2, null);
                c28521.label = 1;
                objUpdateData = dataStore.updateData(c28532, c28521);
                if (objUpdateData == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objUpdateData);
            }
            return (Preferences) objUpdateData;
        } catch (Exception e) {
            GlanceLog.INSTANCE.m2297d("GWT:GAppWidgetManager", "Error " + e + " occurred at addAllReceiversAndProvidersToPreferences");
            return PreferencesFactory.createEmpty();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final State createState(Preferences prefs) {
        String packageName = this.context.getPackageName();
        Set<String> set = (Set) prefs.get(providersKey);
        Map map = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        if (set == null) {
            return new State(map, objArr2 == true ? 1 : 0, 3, objArr == true ? 1 : 0);
        }
        ArrayList arrayList = new ArrayList();
        for (String str : set) {
            ComponentName componentName = new ComponentName(packageName, str);
            String str2 = (String) prefs.get(Companion.providerKey(str));
            Pair pairM13893to = str2 == null ? null : TuplesKt.m13893to(componentName, str2);
            if (pairM13893to != null) {
                arrayList.add(pairM13893to);
            }
        }
        return new State(MapsKt.toMap(arrayList));
    }

    public static /* synthetic */ List getAppWidgetProviderInfoList$default(GlanceAppWidgetManager glanceAppWidgetManager, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return glanceAppWidgetManager.getAppWidgetProviderInfoList(str);
    }

    private final DataStore<Preferences> getDataStore() {
        return (DataStore) this.dataStore.getValue();
    }

    private final <T extends GlanceAppWidget> List<GlanceId> getGlanceIdByProvider(Class<T> provider) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        List<AppWidgetProviderInfo> appWidgetProviderInfoList = getAppWidgetProviderInfoList(this.context.getPackageName());
        ArrayList arrayList = new ArrayList();
        for (Object obj : appWidgetProviderInfoList) {
            if (Intrinsics.areEqual(((AppWidgetProviderInfo) obj).provider.getPackageName(), this.context.getPackageName())) {
                arrayList.add(obj);
            }
        }
        GlanceLog.INSTANCE.m2301i("GWT:GAppWidgetManager", "getGlanceIdByProvider / " + provider);
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            Object objNewInstance = Class.forName(((AppWidgetProviderInfo) next).provider.getClassName()).getDeclaredConstructor(null).newInstance(null);
            if (objNewInstance instanceof GlanceAppWidgetReceiver ? Intrinsics.areEqual(((GlanceAppWidgetReceiver) objNewInstance).getGlanceAppWidget().getClass(), provider) : false) {
                arrayList2.add(next);
            }
        }
        GlanceLog.INSTANCE.m2301i("GWT:GAppWidgetManager", "get receiver list / " + arrayList2.size());
        if (arrayList2.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            int[] appWidgetIds = this.appWidgetManager.getAppWidgetIds(((AppWidgetProviderInfo) it2.next()).provider);
            Intrinsics.checkNotNullExpressionValue(appWidgetIds, "getAppWidgetIds(...)");
            ArrayList arrayList4 = new ArrayList(appWidgetIds.length);
            for (int i : appWidgetIds) {
                GlanceLog.INSTANCE.m2301i("GWT:GAppWidgetManager", "Widget id : " + i);
                arrayList4.add(new AppWidgetId(i));
            }
            CollectionsKt__MutableCollectionsKt.addAll(arrayList3, arrayList4);
        }
        GlanceLog.INSTANCE.m2301i("GWT:GAppWidgetManager", "widget ids / " + arrayList3.size());
        return arrayList3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DataStore<Preferences> getOrCreateDataStore() {
        DataStore<Preferences> appManagerDataStore;
        Companion companion = Companion;
        synchronized (companion) {
            appManagerDataStore = dataStoreSingleton;
            if (appManagerDataStore == null) {
                appManagerDataStore = companion.getAppManagerDataStore(this.context);
                dataStoreSingleton = appManagerDataStore;
            }
        }
        return appManagerDataStore;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getState(Continuation<? super State> continuation) {
        C28561 c28561;
        GlanceAppWidgetManager glanceAppWidgetManager;
        GlanceAppWidgetManager glanceAppWidgetManager2;
        Preferences preferences;
        GlanceAppWidgetManager glanceAppWidgetManager3;
        if (continuation instanceof C28561) {
            c28561 = (C28561) continuation;
            int i = c28561.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c28561.label = i - Integer.MIN_VALUE;
            } else {
                c28561 = new C28561(continuation);
            }
        }
        Object objFirst = c28561.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c28561.label;
        Map map = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objFirst);
                Flow<Preferences> data = getDataStore().getData();
                c28561.L$0 = this;
                c28561.L$1 = this;
                c28561.label = 1;
                objFirst = FlowKt.first(data, c28561);
                if (objFirst == coroutine_suspended) {
                    return coroutine_suspended;
                }
                glanceAppWidgetManager = this;
                glanceAppWidgetManager2 = glanceAppWidgetManager;
            } else {
                if (i2 != 1) {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    glanceAppWidgetManager3 = (GlanceAppWidgetManager) c28561.L$0;
                    ResultKt.throwOnFailure(objFirst);
                    preferences = (Preferences) objFirst;
                    glanceAppWidgetManager = glanceAppWidgetManager3;
                    return glanceAppWidgetManager.createState(preferences);
                }
                glanceAppWidgetManager = (GlanceAppWidgetManager) c28561.L$1;
                glanceAppWidgetManager2 = (GlanceAppWidgetManager) c28561.L$0;
                ResultKt.throwOnFailure(objFirst);
            }
            if (((Preferences) objFirst).get(providersKey) == null) {
                objFirst = null;
            }
            preferences = (Preferences) objFirst;
            if (preferences == null) {
                c28561.L$0 = glanceAppWidgetManager;
                c28561.L$1 = null;
                c28561.label = 2;
                objFirst = glanceAppWidgetManager2.addAllReceiversAndProvidersToPreferences(c28561);
                if (objFirst != coroutine_suspended) {
                    glanceAppWidgetManager3 = glanceAppWidgetManager;
                    preferences = (Preferences) objFirst;
                    glanceAppWidgetManager = glanceAppWidgetManager3;
                }
                return coroutine_suspended;
            }
            return glanceAppWidgetManager.createState(preferences);
        } catch (Exception e) {
            GlanceLog.INSTANCE.m2305w("GWT:GAppWidgetManager", "Exception : " + e);
            return new State(map, objArr2 == true ? 1 : 0, 3, objArr == true ? 1 : 0);
        }
    }

    public static /* synthetic */ Object requestPinGlanceAppWidget$default(GlanceAppWidgetManager glanceAppWidgetManager, Class cls, GlanceAppWidget glanceAppWidget, Object obj, PendingIntent pendingIntent, Continuation continuation, int i, Object obj2) {
        if ((i & 2) != 0) {
            glanceAppWidget = null;
        }
        if ((i & 4) != 0) {
            obj = null;
        }
        if ((i & 8) != 0) {
            pendingIntent = null;
        }
        return glanceAppWidgetManager.requestPinGlanceAppWidget(cls, glanceAppWidget, obj, pendingIntent, continuation);
    }

    public final void cleanCacheData$glance_appwidget_release() {
        synchronized (Companion) {
            cachedAppWidgetProviderInfo = null;
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object cleanReceivers$glance_appwidget_release(@NotNull Continuation<? super Unit> continuation) {
        GlanceAppWidgetManager$cleanReceivers$1 glanceAppWidgetManager$cleanReceivers$1;
        if (continuation instanceof GlanceAppWidgetManager$cleanReceivers$1) {
            glanceAppWidgetManager$cleanReceivers$1 = (GlanceAppWidgetManager$cleanReceivers$1) continuation;
            int i = glanceAppWidgetManager$cleanReceivers$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                glanceAppWidgetManager$cleanReceivers$1.label = i - Integer.MIN_VALUE;
            } else {
                glanceAppWidgetManager$cleanReceivers$1 = new GlanceAppWidgetManager$cleanReceivers$1(this, continuation);
            }
        }
        Object obj = glanceAppWidgetManager$cleanReceivers$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = glanceAppWidgetManager$cleanReceivers$1.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                String packageName = this.context.getPackageName();
                List<AppWidgetProviderInfo> installedProviders = this.appWidgetManager.getInstalledProviders();
                Intrinsics.checkNotNullExpressionValue(installedProviders, "getInstalledProviders(...)");
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : installedProviders) {
                    if (Intrinsics.areEqual(((AppWidgetProviderInfo) obj2).provider.getPackageName(), packageName)) {
                        arrayList.add(obj2);
                    }
                }
                ArrayList arrayList2 = new ArrayList(CollectionsKt.m13952k(arrayList));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((AppWidgetProviderInfo) it.next()).provider.getClassName());
                }
                Set set = CollectionsKt.toSet(arrayList2);
                DataStore<Preferences> dataStore = getDataStore();
                GlanceAppWidgetManager$cleanReceivers$2 glanceAppWidgetManager$cleanReceivers$2 = new GlanceAppWidgetManager$cleanReceivers$2(set, null);
                glanceAppWidgetManager$cleanReceivers$1.label = 1;
                if (dataStore.updateData(glanceAppWidgetManager$cleanReceivers$2, glanceAppWidgetManager$cleanReceivers$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
        } catch (Exception e) {
            GlanceLog.INSTANCE.m2297d("GWT:GAppWidgetManager", "Error " + e + " occurred at cleanReceivers");
        }
        return Unit.INSTANCE;
    }

    @VisibleForTesting
    @Nullable
    public final Object clearDataStore$glance_appwidget_release(@NotNull Continuation<? super Unit> continuation) {
        Object objEdit = PreferencesKt.edit(getDataStore(), new GlanceAppWidgetManager$clearDataStore$2(null), continuation);
        return objEdit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEdit : Unit.INSTANCE;
    }

    public final int getAppWidgetId(@NotNull GlanceId glanceId) {
        Intrinsics.checkNotNullParameter(glanceId, "glanceId");
        if (glanceId instanceof AppWidgetId) {
            return ((AppWidgetId) glanceId).getAppWidgetId();
        }
        throw new IllegalArgumentException("This method only accepts App Widget Glance Id");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @NotNull
    public final List<AppWidgetProviderInfo> getAppWidgetProviderInfoList(@Nullable String packageName) {
        List listEmptyList;
        synchronized (Companion) {
            try {
                List<? extends AppWidgetProviderInfo> list = cachedAppWidgetProviderInfo;
                if (list == null || (list != null && list.isEmpty())) {
                    AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this.context);
                    Intrinsics.checkNotNull(appWidgetManager);
                    List<AppWidgetProviderInfo> listInstalledAllProviders = AppWidgetManagerKt.installedAllProviders(appWidgetManager, packageName);
                    cachedAppWidgetProviderInfo = listInstalledAllProviders;
                    listEmptyList = listInstalledAllProviders;
                } else {
                    List<? extends AppWidgetProviderInfo> list2 = cachedAppWidgetProviderInfo;
                    listEmptyList = list2;
                    if (list2 == null) {
                        listEmptyList = CollectionsKt.emptyList();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return listEmptyList;
    }

    @RequiresApi(36)
    @NotNull
    public final HostSizeInfo getAppWidgetSizeInfo(int appWidgetId) {
        HostSizeInfo hostSizeInfo;
        synchronized (Companion) {
            try {
                AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this.context);
                Intrinsics.checkNotNull(appWidgetManager);
                List<Bundle> appWidgetSizeInfo = AppWidgetManagerKt.getAppWidgetSizeInfo(appWidgetManager, appWidgetId);
                hostSizeInfo = new HostSizeInfo(new LinkedHashMap(), 0.0f, 0);
                if (!appWidgetSizeInfo.isEmpty()) {
                    hostSizeInfo.setDensity(SizeInfoKt.getDensity(appWidgetSizeInfo.get(0)));
                    hostSizeInfo.setHostKey(SizeInfoKt.getHostKey(appWidgetSizeInfo.get(0)));
                }
                Iterator<T> it = appWidgetSizeInfo.iterator();
                while (it.hasNext()) {
                    AppWidgetSizeInfo appWidgetSizeInfo2 = SizeInfoKt.toAppWidgetSizeInfo((Bundle) it.next());
                    if (appWidgetSizeInfo2 != null) {
                        hostSizeInfo.getSizeTable().put(appWidgetSizeInfo2.getSpanSize(), appWidgetSizeInfo2);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return hostSizeInfo;
    }

    @RequiresApi(36)
    @NotNull
    public final Map<Integer, HostSizeInfo> getAppWidgetSizeInfos() {
        LinkedHashMap linkedHashMap;
        synchronized (Companion) {
            try {
                AppWidgetManager appWidgetManager = this.appWidgetManager;
                Intrinsics.checkNotNullExpressionValue(appWidgetManager, "appWidgetManager");
                List<Bundle> appWidgetSizeInfos = AppWidgetManagerKt.getAppWidgetSizeInfos(appWidgetManager);
                linkedHashMap = new LinkedHashMap();
                GlanceLog.INSTANCE.m2297d("GWT:GAppWidgetManager", "Get appwidgetsizeinfos");
                for (Bundle bundle : appWidgetSizeInfos) {
                    int hostKey = SizeInfoKt.getHostKey(bundle);
                    float density = SizeInfoKt.getDensity(bundle);
                    AppWidgetSizeInfo appWidgetSizeInfo = SizeInfoKt.toAppWidgetSizeInfo(bundle);
                    GlanceLog.INSTANCE.m2297d("GWT:GAppWidgetManager", "AppWidgetSizeInfo : " + hostKey + " " + density + " " + appWidgetSizeInfo);
                    if (hostKey > 0 && appWidgetSizeInfo != null && !AppWidgetSize.m21550equalsimpl0(appWidgetSizeInfo.m21618getAppWidgetSizerx25Pp4(), AppWidgetSize.INSTANCE.m21572getUnknownrx25Pp4())) {
                        Integer numValueOf = Integer.valueOf(hostKey);
                        Object hostSizeInfo = linkedHashMap.get(numValueOf);
                        if (hostSizeInfo == null) {
                            hostSizeInfo = new HostSizeInfo(new LinkedHashMap(), density, hostKey);
                            linkedHashMap.put(numValueOf, hostSizeInfo);
                        }
                        ((HostSizeInfo) hostSizeInfo).getSizeTable().put(appWidgetSizeInfo.getSpanSize(), appWidgetSizeInfo);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return linkedHashMap;
    }

    @Nullable
    public final Object getAppWidgetSizes(@NotNull GlanceId glanceId, @NotNull Continuation<? super List<DpSize>> continuation) {
        if (!(glanceId instanceof AppWidgetId)) {
            throw new IllegalArgumentException("This method only accepts App Widget Glance Id");
        }
        Bundle appWidgetOptions = this.appWidgetManager.getAppWidgetOptions(((AppWidgetId) glanceId).getAppWidgetId());
        Intrinsics.checkNotNull(appWidgetOptions);
        return AppWidgetUtilsKt.extractAllSizes(appWidgetOptions, new Function0<DpSize>() { // from class: androidx.glance.appwidget.GlanceAppWidgetManager.getAppWidgetSizes.3
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ DpSize invoke() {
                return DpSize.m21054boximpl(m21294invokeMYxV2XQ());
            }

            /* JADX INFO: renamed from: invoke-MYxV2XQ, reason: not valid java name */
            public final long m21294invokeMYxV2XQ() {
                return DpSize.INSTANCE.m21076getZeroMYxV2XQ();
            }
        });
    }

    @NotNull
    public final GlanceId getGlanceIdBy(int appWidgetId) {
        if (this.appWidgetManager.getAppWidgetInfo(appWidgetId) != null) {
            return new AppWidgetId(appWidgetId);
        }
        throw new IllegalArgumentException("Invalid AppWidget ID.");
    }

    @Nullable
    public final GlanceId getGlanceIdByOrNull(int appWidgetId) {
        if (this.appWidgetManager.getAppWidgetInfo(appWidgetId) != null) {
            return new AppWidgetId(appWidgetId);
        }
        GlanceLog.INSTANCE.m2301i("GWT:GAppWidgetManager", "It is invalid appwidget id(" + appWidgetId + ")");
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <T extends GlanceAppWidget> Object getGlanceIds(@NotNull Class<T> cls, @NotNull Continuation<? super List<? extends GlanceId>> continuation) {
        C28551 c28551;
        GlanceAppWidgetManager glanceAppWidgetManager;
        if (continuation instanceof C28551) {
            c28551 = (C28551) continuation;
            int i = c28551.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c28551.label = i - Integer.MIN_VALUE;
            } else {
                c28551 = new C28551(continuation);
            }
        }
        Object state = c28551.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c28551.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(state);
            c28551.L$0 = this;
            c28551.L$1 = cls;
            c28551.label = 1;
            state = getState(c28551);
            if (state == coroutine_suspended) {
                return coroutine_suspended;
            }
            glanceAppWidgetManager = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            cls = (Class) c28551.L$1;
            glanceAppWidgetManager = (GlanceAppWidgetManager) c28551.L$0;
            ResultKt.throwOnFailure(state);
        }
        State state2 = (State) state;
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("no canonical provider name");
        }
        List<ComponentName> listEmptyList = state2.getProviderNameToReceivers().get(canonicalName);
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        if (listEmptyList.isEmpty()) {
            return glanceAppWidgetManager.getGlanceIdByProvider(cls);
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = listEmptyList.iterator();
        while (it.hasNext()) {
            int[] appWidgetIds = glanceAppWidgetManager.appWidgetManager.getAppWidgetIds((ComponentName) it.next());
            Intrinsics.checkNotNullExpressionValue(appWidgetIds, "getAppWidgetIds(...)");
            ArrayList arrayList2 = new ArrayList(appWidgetIds.length);
            for (int i4 : appWidgetIds) {
                arrayList2.add(new AppWidgetId(i4));
            }
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, arrayList2);
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @VisibleForTesting
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object listKnownReceivers$glance_appwidget_release(@NotNull Continuation<? super Collection<String>> continuation) {
        GlanceAppWidgetManager$listKnownReceivers$1 glanceAppWidgetManager$listKnownReceivers$1;
        if (continuation instanceof GlanceAppWidgetManager$listKnownReceivers$1) {
            glanceAppWidgetManager$listKnownReceivers$1 = (GlanceAppWidgetManager$listKnownReceivers$1) continuation;
            int i = glanceAppWidgetManager$listKnownReceivers$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                glanceAppWidgetManager$listKnownReceivers$1.label = i - Integer.MIN_VALUE;
            } else {
                glanceAppWidgetManager$listKnownReceivers$1 = new GlanceAppWidgetManager$listKnownReceivers$1(this, continuation);
            }
        }
        Object objFirstOrNull = glanceAppWidgetManager$listKnownReceivers$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = glanceAppWidgetManager$listKnownReceivers$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objFirstOrNull);
            Flow<Preferences> data = getDataStore().getData();
            glanceAppWidgetManager$listKnownReceivers$1.label = 1;
            objFirstOrNull = FlowKt.firstOrNull(data, glanceAppWidgetManager$listKnownReceivers$1);
            if (objFirstOrNull == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objFirstOrNull);
        }
        Preferences preferences = (Preferences) objFirstOrNull;
        if (preferences != null) {
            return (Set) preferences.get(providersKey);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <T extends GlanceAppWidgetReceiver> Object requestPinGlanceAppWidget(@NotNull Class<T> cls, @Nullable GlanceAppWidget glanceAppWidget, @Nullable Object obj, @Nullable PendingIntent pendingIntent, @NotNull Continuation<? super Boolean> continuation) {
        C28571 c28571;
        ComponentName componentName;
        Bundle bundle;
        PendingIntent pendingIntent2;
        GlanceAppWidgetManager glanceAppWidgetManager;
        ComponentName componentName2;
        Bundle bundle2;
        if (continuation instanceof C28571) {
            c28571 = (C28571) continuation;
            int i = c28571.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c28571.label = i - Integer.MIN_VALUE;
            } else {
                c28571 = new C28571(continuation);
            }
        }
        C28571 c285712 = c28571;
        Object obj2 = c285712.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c285712.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj2);
            AppWidgetManagerApi26Impl appWidgetManagerApi26Impl = AppWidgetManagerApi26Impl.INSTANCE;
            AppWidgetManager appWidgetManager = this.appWidgetManager;
            Intrinsics.checkNotNullExpressionValue(appWidgetManager, "appWidgetManager");
            if (!appWidgetManagerApi26Impl.isRequestPinAppWidgetSupported(appWidgetManager)) {
                return Boxing.boxBoolean(false);
            }
            componentName = new ComponentName(this.context.getPackageName(), cls.getName());
            bundle = new Bundle();
            if (glanceAppWidget == null) {
                pendingIntent2 = pendingIntent;
                glanceAppWidgetManager = this;
                AppWidgetManagerApi26Impl appWidgetManagerApi26Impl2 = AppWidgetManagerApi26Impl.INSTANCE;
                AppWidgetManager appWidgetManager2 = glanceAppWidgetManager.appWidgetManager;
                Intrinsics.checkNotNullExpressionValue(appWidgetManager2, "appWidgetManager");
                return Boxing.boxBoolean(appWidgetManagerApi26Impl2.requestPinAppWidget(appWidgetManager2, componentName, bundle, pendingIntent2));
            }
            List<AppWidgetProviderInfo> installedProviders = this.appWidgetManager.getInstalledProviders();
            Intrinsics.checkNotNullExpressionValue(installedProviders, "getInstalledProviders(...)");
            for (AppWidgetProviderInfo appWidgetProviderInfo : installedProviders) {
                if (Intrinsics.areEqual(appWidgetProviderInfo.provider, componentName)) {
                    Context context = this.context;
                    AppWidgetId appWidgetId = new AppWidgetId(0);
                    Bundle bundle3 = Bundle.EMPTY;
                    Intrinsics.checkNotNull(appWidgetProviderInfo);
                    DisplayMetrics displayMetrics = this.context.getResources().getDisplayMetrics();
                    Intrinsics.checkNotNullExpressionValue(displayMetrics, "getDisplayMetrics(...)");
                    DpSize dpSizeM21054boximpl = DpSize.m21054boximpl(AppWidgetUtilsKt.getMinSize(appWidgetProviderInfo, displayMetrics));
                    c285712.L$0 = this;
                    pendingIntent2 = pendingIntent;
                    c285712.L$1 = pendingIntent2;
                    c285712.L$2 = componentName;
                    c285712.L$3 = bundle;
                    c285712.L$4 = bundle;
                    c285712.label = 1;
                    Object objM21261composeDR8WLM = AppWidgetComposerKt.m21261composeDR8WLM(glanceAppWidget, context, appWidgetId, bundle3, dpSizeM21054boximpl, obj, c285712);
                    if (objM21261composeDR8WLM == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    glanceAppWidgetManager = this;
                    componentName2 = componentName;
                    obj2 = objM21261composeDR8WLM;
                    bundle2 = bundle;
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        bundle = (Bundle) c285712.L$4;
        bundle2 = (Bundle) c285712.L$3;
        componentName2 = (ComponentName) c285712.L$2;
        PendingIntent pendingIntent3 = (PendingIntent) c285712.L$1;
        glanceAppWidgetManager = (GlanceAppWidgetManager) c285712.L$0;
        ResultKt.throwOnFailure(obj2);
        pendingIntent2 = pendingIntent3;
        bundle.putParcelable("appWidgetPreview", (RemoteViews) obj2);
        bundle = bundle2;
        componentName = componentName2;
        AppWidgetManagerApi26Impl appWidgetManagerApi26Impl22 = AppWidgetManagerApi26Impl.INSTANCE;
        AppWidgetManager appWidgetManager22 = glanceAppWidgetManager.appWidgetManager;
        Intrinsics.checkNotNullExpressionValue(appWidgetManager22, "appWidgetManager");
        return Boxing.boxBoolean(appWidgetManagerApi26Impl22.requestPinAppWidget(appWidgetManager22, componentName, bundle, pendingIntent2));
    }

    @RequiresApi(36)
    /* JADX INFO: renamed from: setAppWidgetSizeInfo-dw4hRxs, reason: not valid java name */
    public final void m21293setAppWidgetSizeInfodw4hRxs(@NotNull HostId hostId, int hostType, int displayDeviceType, int appWidgetStyle, @NotNull List<AppWidgetSizeInfo> appWidgetSizeInfos) {
        Intrinsics.checkNotNullParameter(hostId, "hostId");
        Intrinsics.checkNotNullParameter(appWidgetSizeInfos, "appWidgetSizeInfos");
        synchronized (Companion) {
            try {
                AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this.context);
                ArrayList arrayList = new ArrayList();
                float f = this.context.getResources().getDisplayMetrics().density;
                int iM21620makeHostKeyC7y7hqc = HostKey.INSTANCE.m21620makeHostKeyC7y7hqc(hostType, displayDeviceType, appWidgetStyle);
                Iterator<T> it = appWidgetSizeInfos.iterator();
                while (it.hasNext()) {
                    arrayList.add(SizeInfoKt.toBundle((AppWidgetSizeInfo) it.next(), iM21620makeHostKeyC7y7hqc, f));
                }
                Intrinsics.checkNotNull(appWidgetManager);
                AppWidgetManagerKt.setAppWidgetSizeInfo(appWidgetManager, hostId.getPackageName(), hostId.getId(), arrayList);
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <R extends GlanceAppWidgetReceiver, P extends GlanceAppWidget> Object updateReceiver$glance_appwidget_release(@NotNull R r, @NotNull P p, @NotNull Continuation<? super Unit> continuation) {
        GlanceAppWidgetManager$updateReceiver$1 glanceAppWidgetManager$updateReceiver$1;
        if (continuation instanceof GlanceAppWidgetManager$updateReceiver$1) {
            glanceAppWidgetManager$updateReceiver$1 = (GlanceAppWidgetManager$updateReceiver$1) continuation;
            int i = glanceAppWidgetManager$updateReceiver$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                glanceAppWidgetManager$updateReceiver$1.label = i - Integer.MIN_VALUE;
            } else {
                glanceAppWidgetManager$updateReceiver$1 = new GlanceAppWidgetManager$updateReceiver$1(this, continuation);
            }
        }
        Object obj = glanceAppWidgetManager$updateReceiver$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = glanceAppWidgetManager$updateReceiver$1.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                Companion companion = Companion;
                String strCanonicalName = companion.canonicalName(r);
                String strCanonicalName2 = companion.canonicalName(p);
                DataStore<Preferences> dataStore = getDataStore();
                GlanceAppWidgetManager$updateReceiver$2 glanceAppWidgetManager$updateReceiver$2 = new GlanceAppWidgetManager$updateReceiver$2(strCanonicalName, strCanonicalName2, null);
                glanceAppWidgetManager$updateReceiver$1.label = 1;
                if (dataStore.updateData(glanceAppWidgetManager$updateReceiver$2, glanceAppWidgetManager$updateReceiver$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
        } catch (FileNotFoundException e) {
            GlanceLog.INSTANCE.m2297d("GWT:GAppWidgetManager", "Error " + e + " occurred at updateReceiver");
        } catch (Exception e2) {
            GlanceLog.INSTANCE.m2297d("GWT:GAppWidgetManager", "Error " + e2 + " occurred at updateReceiver");
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final GlanceId getGlanceIdBy(@NotNull Intent configurationIntent) {
        Intrinsics.checkNotNullParameter(configurationIntent, "configurationIntent");
        Bundle extras = configurationIntent.getExtras();
        int i = extras != null ? extras.getInt(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, 0) : 0;
        if (i == 0) {
            return null;
        }
        return new AppWidgetId(i);
    }
}
