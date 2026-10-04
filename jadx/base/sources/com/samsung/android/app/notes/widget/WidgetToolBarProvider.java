package com.samsung.android.app.notes.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import androidx.glance.GlanceId;
import androidx.glance.appwidget.GlanceAppWidget;
import androidx.glance.appwidget.GlanceAppWidgetManager;
import androidx.glance.appwidget.state.GlanceAppWidgetStateKt;
import androidx.glance.oneui.template.GlanceTemplateAppWidgetReceiver;
import com.google.android.gms.drive.DriveFile;
import com.samsung.android.app.notes.C6635R;
import com.samsung.android.app.notes.widget.capture.CacheFileManager;
import com.samsung.android.app.notes.widget.common.log.WidgetLogger;
import com.samsung.android.app.notes.widget.dialog.StorageErrorDialogActivity;
import com.samsung.android.app.notes.widget.glance.WidgetCreator;
import com.samsung.android.app.notes.widget.glance.common.WidgetCreatorPreference;
import com.samsung.android.app.notes.widget.preference.WidgetPreferenceManager;
import com.samsung.android.app.notes.widget.theme.ThemeInfo;
import com.samsung.android.app.notes.widget.theme.ToolbarThemeInfo;
import com.samsung.android.app.notes.widget.theme.ToolbarThemeManager;
import com.samsung.android.app.notes.widget.util.WidgetBRHelper;
import com.samsung.android.app.notes.widget.util.WidgetToolbarUtils;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.base.common.MultiTaskManager;
import com.samsung.android.support.senl.p148nt.base.common.access.composer.ComposerAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.access.notelist.NoteListAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.NotesSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.StorageUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.widget.preference.BaseWidgetPreferenceManager;
import com.samsung.android.support.senl.p148nt.base.widget.util.BaseWidgetUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.document.MainListDocumentDataRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0017\u0018\u0000 @2\u00020\u0001:\u0001@B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0016\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J \u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J \u0010\u0018\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0018\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u001e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001aJ \u0010!\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010 \u001a\u00020\tJ\u001e\u0010$\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\tJ(\u0010'\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020)H\u0016J\u0018\u0010*\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010+\u001a\u00020,2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u001aH\u0002J\u0018\u0010-\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010.\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010/\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J \u00100\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u00172\u0006\u00102\u001a\u00020\u0017H\u0016J \u00103\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u001a2\u0006\u00104\u001a\u00020,H\u0002J \u00105\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u00104\u001a\u00020,H\u0002J\u0010\u00106\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J \u00107\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u00104\u001a\u00020,H\u0002J\u001a\u00108\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u00109\u001a\u0004\u0018\u00010\tH\u0016J \u0010:\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u00104\u001a\u00020,H\u0002J \u0010;\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u00104\u001a\u00020,H\u0002J \u0010<\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u00104\u001a\u00020,H\u0002J \u0010=\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u00104\u001a\u00020,H\u0002J\u0012\u0010>\u001a\u00020\r2\b\u00109\u001a\u0004\u0018\u00010\tH\u0002J\u0018\u0010?\u001a\u00020\u001a2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u001aH\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006A"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/WidgetToolBarProvider;", "Landroidx/glance/oneui/template/GlanceTemplateAppWidgetReceiver;", "<init>", "()V", "glanceAppWidget", "Landroidx/glance/appwidget/GlanceAppWidget;", "getGlanceAppWidget", "()Landroidx/glance/appwidget/GlanceAppWidget;", "providerName", "", "getProviderName", "()Ljava/lang/String;", "onReceive", "", "context", "Landroid/content/Context;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "onReceiveForBelowOneUi7x", "onUpdate", "appWidgetManager", "Landroid/appwidget/AppWidgetManager;", "appWidgetIds", "", "updateGlance", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "", "glanceManager", "Landroidx/glance/appwidget/GlanceAppWidgetManager;", "restoreBySmartSwitch", "isDeleteNote", "", "uuid", "deleteWidget", "provider", "Landroid/content/ComponentName;", "updateWidget", "widgetId", NotesConstants.KEY_CALLER, "onAppWidgetOptionsChanged", "newOptions", "Landroid/os/Bundle;", "deleteOldWidgetBackupData", "makeWidgetToolbarView", "Landroid/widget/RemoteViews;", "onDeleted", "onEnabled", "onDisabled", "onRestored", "oldWidgetIds", "newWidgetIds", "setBackground", "remoteViews", "addPendingIntentToLaunchNotes", "actionPendingIntentToLaunchNotes", "addPendingIntentToComposerText", "actionPendingIntentToComposerOther", "widgetAction", "addPendingIntentToComposerPen", "addPendingIntentToComposerDrawing", "addPendingIntentToComposerImage", "addPendingIntentToComposerVoice", "insertLog", "getLayoutId", "Companion", "notes-4.4.37.35_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class WidgetToolBarProvider extends GlanceTemplateAppWidgetReceiver {
    private static final long INPUT_SKIP_TIME = 1000;

    @NotNull
    private static final String TAG = "WidgetToolBarProvider";
    private static long mPreviousEventTime;

    @NotNull
    private final GlanceAppWidget glanceAppWidget = new WidgetCreator();

    @NotNull
    private final String providerName = TAG;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = GlanceTemplateAppWidgetReceiver.$stable | GlanceAppWidget.$stable;

    @NotNull
    private static final Preferences.Key<Integer> transparencyKey = PreferencesKeys.intKey("transparencyKey");

    @NotNull
    private static final Preferences.Key<Integer> backgroundColorKey = PreferencesKeys.intKey("backgroundColorKey");

    @NotNull
    private static final Preferences.Key<Integer> darkModeKey = PreferencesKeys.intKey("darkModeKey");

    @NotNull
    private static final Preferences.Key<Boolean> matchSettingKey = PreferencesKeys.booleanKey("matchSettingKey");

    @NotNull
    private static final Preferences.Key<Set<String>> selectedItemsKey = PreferencesKeys.stringSetKey("selectedItemsKey");

    @NotNull
    private static final Preferences.Key<Long> requestTimeKey = PreferencesKeys.longKey("requestTimeKey");

    @NotNull
    private static final Preferences.Key<Integer> shapeBGKey = PreferencesKeys.intKey("shapeBGKey");

    @NotNull
    private static final Preferences.Key<Boolean> backgroundOnOffKey = PreferencesKeys.booleanKey("backgroundOnOffKey");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\rR\u001d\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00160\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\rR\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\rR\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\rR\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00130\n¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\r¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/WidgetToolBarProvider$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mPreviousEventTime", "", "INPUT_SKIP_TIME", "transparencyKey", "Landroidx/datastore/preferences/core/Preferences$Key;", "", "getTransparencyKey", "()Landroidx/datastore/preferences/core/Preferences$Key;", "backgroundColorKey", "getBackgroundColorKey", "darkModeKey", "getDarkModeKey", "matchSettingKey", "", "getMatchSettingKey", "selectedItemsKey", "", "getSelectedItemsKey", "requestTimeKey", "getRequestTimeKey", "shapeBGKey", "getShapeBGKey", "backgroundOnOffKey", "getBackgroundOnOffKey", "notes-4.4.37.35_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Preferences.Key<Integer> getBackgroundColorKey() {
            return WidgetToolBarProvider.backgroundColorKey;
        }

        @NotNull
        public final Preferences.Key<Boolean> getBackgroundOnOffKey() {
            return WidgetToolBarProvider.backgroundOnOffKey;
        }

        @NotNull
        public final Preferences.Key<Integer> getDarkModeKey() {
            return WidgetToolBarProvider.darkModeKey;
        }

        @NotNull
        public final Preferences.Key<Boolean> getMatchSettingKey() {
            return WidgetToolBarProvider.matchSettingKey;
        }

        @NotNull
        public final Preferences.Key<Long> getRequestTimeKey() {
            return WidgetToolBarProvider.requestTimeKey;
        }

        @NotNull
        public final Preferences.Key<Set<String>> getSelectedItemsKey() {
            return WidgetToolBarProvider.selectedItemsKey;
        }

        @NotNull
        public final Preferences.Key<Integer> getShapeBGKey() {
            return WidgetToolBarProvider.shapeBGKey;
        }

        @NotNull
        public final Preferences.Key<Integer> getTransparencyKey() {
            return WidgetToolBarProvider.transparencyKey;
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.app.notes.widget.WidgetToolBarProvider$updateGlance$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.samsung.android.app.notes.widget.WidgetToolBarProvider$updateGlance$1", m14021f = "WidgetToolBarProvider.kt", m14022i = {}, m14023l = {270, 280}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C69111 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $backgroundColor;
        final /* synthetic */ boolean $backgroundOnOff;
        final /* synthetic */ Context $context;
        final /* synthetic */ int $darkMode;
        final /* synthetic */ GlanceId $glanceId;
        final /* synthetic */ boolean $matchSetting;
        final /* synthetic */ long $requestTime;
        final /* synthetic */ Set<String> $selectedItems;
        final /* synthetic */ int $shapeBG;
        final /* synthetic */ int $transparency;
        int label;
        final /* synthetic */ WidgetToolBarProvider this$0;

        /* JADX INFO: renamed from: com.samsung.android.app.notes.widget.WidgetToolBarProvider$updateGlance$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, m13886d2 = {"<anonymous>", "", "state", "Landroidx/datastore/preferences/core/MutablePreferences;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
        @DebugMetadata(m14020c = "com.samsung.android.app.notes.widget.WidgetToolBarProvider$updateGlance$1$1", m14021f = "WidgetToolBarProvider.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
            final /* synthetic */ int $backgroundColor;
            final /* synthetic */ boolean $backgroundOnOff;
            final /* synthetic */ int $darkMode;
            final /* synthetic */ boolean $matchSetting;
            final /* synthetic */ long $requestTime;
            final /* synthetic */ Set<String> $selectedItems;
            final /* synthetic */ int $shapeBG;
            final /* synthetic */ int $transparency;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(int i, int i2, int i4, boolean z, Set<String> set, long j, int i5, boolean z2, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$transparency = i;
                this.$backgroundColor = i2;
                this.$darkMode = i4;
                this.$matchSetting = z;
                this.$selectedItems = set;
                this.$requestTime = j;
                this.$shapeBG = i5;
                this.$backgroundOnOff = z2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$transparency, this.$backgroundColor, this.$darkMode, this.$matchSetting, this.$selectedItems, this.$requestTime, this.$shapeBG, this.$backgroundOnOff, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(MutablePreferences mutablePreferences, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(mutablePreferences, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                MutablePreferences mutablePreferences = (MutablePreferences) this.L$0;
                Companion companion = WidgetToolBarProvider.INSTANCE;
                mutablePreferences.set(companion.getTransparencyKey(), Boxing.boxInt(this.$transparency));
                mutablePreferences.set(companion.getBackgroundColorKey(), Boxing.boxInt(this.$backgroundColor));
                mutablePreferences.set(companion.getDarkModeKey(), Boxing.boxInt(this.$darkMode));
                mutablePreferences.set(companion.getMatchSettingKey(), Boxing.boxBoolean(this.$matchSetting));
                mutablePreferences.set(companion.getSelectedItemsKey(), this.$selectedItems);
                mutablePreferences.set(companion.getRequestTimeKey(), Boxing.boxLong(this.$requestTime));
                mutablePreferences.set(companion.getShapeBGKey(), Boxing.boxInt(this.$shapeBG));
                mutablePreferences.set(companion.getBackgroundOnOffKey(), Boxing.boxBoolean(this.$backgroundOnOff));
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C69111(Context context, GlanceId glanceId, WidgetToolBarProvider widgetToolBarProvider, int i, int i2, int i4, boolean z, Set<String> set, long j, int i5, boolean z2, Continuation<? super C69111> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$glanceId = glanceId;
            this.this$0 = widgetToolBarProvider;
            this.$transparency = i;
            this.$backgroundColor = i2;
            this.$darkMode = i4;
            this.$matchSetting = z;
            this.$selectedItems = set;
            this.$requestTime = j;
            this.$shapeBG = i5;
            this.$backgroundOnOff = z2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C69111(this.$context, this.$glanceId, this.this$0, this.$transparency, this.$backgroundColor, this.$darkMode, this.$matchSetting, this.$selectedItems, this.$requestTime, this.$shapeBG, this.$backgroundOnOff, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0057, code lost:
        
            if (r2.update(r4, r5, r17) == r1) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Context context = this.$context;
                GlanceId glanceId = this.$glanceId;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$transparency, this.$backgroundColor, this.$darkMode, this.$matchSetting, this.$selectedItems, this.$requestTime, this.$shapeBG, this.$backgroundOnOff, null);
                this.label = 1;
                if (GlanceAppWidgetStateKt.updateAppWidgetState(context, glanceId, anonymousClass1, this) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            GlanceAppWidget glanceAppWidget = this.this$0.getGlanceAppWidget();
            Context context2 = this.$context;
            GlanceId glanceId2 = this.$glanceId;
            this.label = 2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C69111) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    private final void addPendingIntentToComposerDrawing(Context context, int appWidgetId, RemoteViews remoteViews) {
        Intent intent = new Intent(context, (Class<?>) WidgetToolBarProvider.class);
        intent.setAction(BaseWidgetConstant.ADD_MEMO_FROM_TOOLBAR);
        intent.putExtra(ComposerConstants.MEMO_WIDGET_ACTION, ComposerConstants.NEW_MEMO_DRAWING_OPEN);
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, appWidgetId);
        remoteViews.setOnClickPendingIntent(C6635R.id.widget_drawing_icon, PendingIntent.getBroadcast(context, 5, intent, 201326592));
        remoteViews.setImageViewResource(C6635R.id.widget_drawing_icon, C6635R.drawable.ic_widget_brush);
    }

    private final void addPendingIntentToComposerImage(Context context, int appWidgetId, RemoteViews remoteViews) {
        Intent intent = new Intent(context, (Class<?>) WidgetToolBarProvider.class);
        intent.setAction(BaseWidgetConstant.ADD_MEMO_FROM_TOOLBAR);
        intent.putExtra(ComposerConstants.MEMO_WIDGET_ACTION, ComposerConstants.NEW_MEMO_INSERT_OPEN);
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, appWidgetId);
        remoteViews.setOnClickPendingIntent(C6635R.id.widget_image_icon, PendingIntent.getBroadcast(context, 3, intent, 201326592));
        remoteViews.setImageViewResource(C6635R.id.widget_image_icon, C6635R.drawable.ic_widget_image);
    }

    private final void addPendingIntentToComposerPen(Context context, int appWidgetId, RemoteViews remoteViews) {
        Intent intent = new Intent(context, (Class<?>) WidgetToolBarProvider.class);
        intent.setAction(BaseWidgetConstant.ADD_MEMO_FROM_TOOLBAR);
        intent.putExtra(ComposerConstants.MEMO_WIDGET_ACTION, ComposerConstants.NEW_MEMO_WRITING_OPEN);
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, appWidgetId);
        remoteViews.setOnClickPendingIntent(C6635R.id.widget_writing_icon, PendingIntent.getBroadcast(context, 4, intent, 201326592));
        remoteViews.setImageViewResource(C6635R.id.widget_writing_icon, C6635R.drawable.ic_widget_handwriting);
    }

    private final void addPendingIntentToComposerText(Context context, int appWidgetId, RemoteViews remoteViews) {
        Intent intent = new Intent(context, (Class<?>) WidgetToolBarProvider.class);
        intent.setAction(BaseWidgetConstant.ADD_MEMO_FROM_TOOLBAR);
        intent.putExtra(ComposerConstants.MEMO_WIDGET_ACTION, ComposerConstants.NEW_MEMO_OPEN);
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, appWidgetId);
        remoteViews.setOnClickPendingIntent(C6635R.id.widget_add_icon, PendingIntent.getBroadcast(context, 2, intent, 201326592));
        remoteViews.setImageViewResource(C6635R.id.widget_add_icon, C6635R.drawable.ic_widget_text);
    }

    private final void addPendingIntentToComposerVoice(Context context, int appWidgetId, RemoteViews remoteViews) {
        Intent intent = new Intent(context, (Class<?>) WidgetToolBarProvider.class);
        intent.setAction(BaseWidgetConstant.ADD_MEMO_FROM_TOOLBAR);
        intent.putExtra(ComposerConstants.MEMO_WIDGET_ACTION, ComposerConstants.NEW_MEMO_VOICE_OPEN);
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, appWidgetId);
        remoteViews.setOnClickPendingIntent(C6635R.id.widget_voice_icon, PendingIntent.getBroadcast(context, 6, intent, 201326592));
        remoteViews.setImageViewResource(C6635R.id.widget_voice_icon, C6635R.drawable.ic_widget_voice);
    }

    private final void addPendingIntentToLaunchNotes(Context context, int appWidgetId, RemoteViews remoteViews) {
        Intent intent = new Intent(context, (Class<?>) WidgetToolBarProvider.class);
        intent.setAction(BaseWidgetConstant.LAUNCH_NOTES_FROM_TOOLBAR);
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, appWidgetId);
        remoteViews.setOnClickPendingIntent(C6635R.id.widget_launch_note_icon, PendingIntent.getBroadcast(context, 1, intent, 201326592));
        remoteViews.setImageViewResource(C6635R.id.widget_launch_note_icon, C6635R.drawable.ic_widget_notes_line);
    }

    private final void deleteOldWidgetBackupData(AppWidgetManager appWidgetManager, int appWidgetId) {
        int i;
        int i2;
        if (appWidgetManager.getAppWidgetOptions(appWidgetId) != null) {
            i = appWidgetManager.getAppWidgetOptions(appWidgetId).getInt(BaseWidgetConstant.OLD_WIDGET_ID_OPTION);
            i2 = appWidgetManager.getAppWidgetOptions(appWidgetId).getInt(BaseWidgetConstant.NEW_WIDGET_ID_OPTION);
        } else {
            i = 0;
            i2 = 0;
        }
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "deleteOldWidgetBackupData# oldWidgetID = ", "/ newWidgetID = ", " appWidgetId ");
        sbM1173s.append(appWidgetId);
        Logger.m8702i(TAG, sbM1173s.toString());
        if (i == 0 || i2 == 0) {
            return;
        }
        WidgetBRHelper.deleteWidgetInfoWithoutUuid(i);
    }

    private final int getLayoutId(Context context, int widgetId) {
        return WidgetToolbarUtils.INSTANCE.getWidgetLayoutId(context, widgetId, C6635R.layout.widget_toolbar_init_phone_portrait_layout, C6635R.layout.widget_toolbar_init_phone_landscape_layout, C6635R.layout.widget_toolbar_init_phone_layout, C6635R.layout.widget_toolbar_init);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final void insertLog(String widgetAction) {
        if (widgetAction != null) {
            switch (widgetAction.hashCode()) {
                case -1327778454:
                    if (widgetAction.equals(ComposerConstants.NEW_MEMO_INSERT_OPEN)) {
                        NotesSamsungAnalytics.INSTANCE.insertLog("611", "6105");
                        break;
                    }
                    break;
                case -889698351:
                    if (widgetAction.equals(ComposerConstants.NEW_MEMO_DRAWING_OPEN)) {
                        NotesSamsungAnalytics.INSTANCE.insertLog("611", "6104");
                        break;
                    }
                    break;
                case -833164099:
                    if (widgetAction.equals(ComposerConstants.NEW_MEMO_VOICE_OPEN)) {
                        NotesSamsungAnalytics.INSTANCE.insertLog("611", "6106");
                        break;
                    }
                    break;
                case 226248240:
                    if (widgetAction.equals(ComposerConstants.NEW_MEMO_OPEN)) {
                        NotesSamsungAnalytics.Companion companion = NotesSamsungAnalytics.INSTANCE;
                        companion.insertLog("611", "6102");
                        companion.insertStatusLog("9985", "Widget_Keypad");
                        break;
                    }
                    break;
                case 1022795391:
                    if (widgetAction.equals(BaseWidgetConstant.LAUNCH_NOTES_FROM_TOOLBAR)) {
                        NotesSamsungAnalytics.INSTANCE.insertLog("611", "6101");
                        break;
                    }
                    break;
                case 1118161363:
                    if (widgetAction.equals(ComposerConstants.NEW_MEMO_WRITING_OPEN)) {
                        NotesSamsungAnalytics.Companion companion2 = NotesSamsungAnalytics.INSTANCE;
                        companion2.insertLog("611", "6103");
                        companion2.insertStatusLog("9985", "Widget_Brush");
                        break;
                    }
                    break;
            }
        }
    }

    private final RemoteViews makeWidgetToolbarView(Context context, int appWidgetIds) {
        String string;
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), getLayoutId(context, appWidgetIds));
        if (Build.VERSION.SDK_INT >= 34) {
            string = context.getString(C6635R.string.app_name_simple);
        } else {
            string = context.getString(CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy() ? C6635R.string.notes_jp : C6635R.string.app_name);
        }
        Intrinsics.checkNotNull(string);
        BaseWidgetPreferenceManager.Companion companion = BaseWidgetPreferenceManager.INSTANCE;
        companion.saveWidgetMatchSetting(appWidgetIds, false);
        Bundle appWidgetOptions = AppWidgetManager.getInstance(context).getAppWidgetOptions(appWidgetIds);
        if (appWidgetOptions.get("oneUiWidgetSource") != null) {
            companion.saveOneUiWidgetSource(appWidgetIds, String.valueOf(appWidgetOptions.get("oneUiWidgetSource")));
        }
        remoteViews.setTextViewText(C6635R.id.widget_app_name, string);
        remoteViews.setTextViewText(C6635R.id.widget_app_name_and_shadow, string);
        addPendingIntentToLaunchNotes(context, appWidgetIds, remoteViews);
        addPendingIntentToComposerText(context, appWidgetIds, remoteViews);
        addPendingIntentToComposerPen(context, appWidgetIds, remoteViews);
        addPendingIntentToComposerDrawing(context, appWidgetIds, remoteViews);
        addPendingIntentToComposerImage(context, appWidgetIds, remoteViews);
        addPendingIntentToComposerVoice(context, appWidgetIds, remoteViews);
        setBackground(context, appWidgetIds, remoteViews);
        ToolbarThemeManager toolbarThemeManager = new ToolbarThemeManager();
        ToolbarThemeInfo toolbarThemeInfo = new ToolbarThemeInfo(context, appWidgetIds);
        toolbarThemeManager.applyThemeToWidgetFrame(context, remoteViews, toolbarThemeInfo);
        companion.saveTransparency(appWidgetIds, 100 - toolbarThemeInfo.getMTransparency());
        companion.saveWidgetOrientationPref(appWidgetIds, context.getResources().getConfiguration().orientation);
        companion.saveWidgetData(appWidgetIds, true);
        return remoteViews;
    }

    private final void restoreBySmartSwitch(AppWidgetManager appWidgetManager, int appWidgetId) throws Throwable {
        int i;
        int i2;
        if (appWidgetManager.getAppWidgetOptions(appWidgetId) != null) {
            i = appWidgetManager.getAppWidgetOptions(appWidgetId).getInt(BaseWidgetConstant.OLD_WIDGET_ID_OPTION);
            i2 = appWidgetManager.getAppWidgetOptions(appWidgetId).getInt(BaseWidgetConstant.NEW_WIDGET_ID_OPTION);
        } else {
            i = 0;
            i2 = 0;
        }
        if (WidgetBRHelper.restoreWidgetInfoWithoutUUID(i, i2)) {
            if (BaseWidgetUtils.INSTANCE.isSupportedNewWidget()) {
                WidgetBRHelper.INSTANCE.restoreCreatorWidgetInfo(appWidgetId, i);
            } else {
                WidgetBRHelper.restoreWidgetInfoToSharedPref(null, appWidgetId, i);
            }
        }
    }

    private final void setBackground(Context context, int widgetId, RemoteViews remoteViews) {
        int i = new ThemeInfo(context, widgetId).isDarkMode() ? C6635R.drawable.widget_toolbar_item_dark_bg_ripple : C6635R.drawable.widget_toolbar_item_light_bg_ripple;
        int[] iArr = {C6635R.id.widget_add_icon, C6635R.id.widget_launch_note_icon, C6635R.id.widget_writing_icon, C6635R.id.widget_drawing_icon, C6635R.id.widget_image_icon, C6635R.id.widget_voice_icon};
        for (int i2 = 0; i2 < 6; i2++) {
            remoteViews.setInt(iArr[i2], BaseWidgetConstant.SET_BACKGROUND_RESOURCE, i);
        }
    }

    private final void updateGlance(Context context, int appWidgetId, GlanceAppWidgetManager glanceManager) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        BaseWidgetPreferenceManager.Companion companion = BaseWidgetPreferenceManager.INSTANCE;
        int transparency = companion.getTransparency(appWidgetId);
        int backgroundColor = companion.getBackgroundColor(appWidgetId);
        int darkMode = companion.getDarkMode(appWidgetId);
        boolean widgetMatchSetting = companion.getWidgetMatchSetting(appWidgetId);
        Set<String> selectedItemsSet = WidgetCreatorPreference.INSTANCE.getSelectedItemsSet(appWidgetId);
        GlanceId glanceIdBy = glanceManager.getGlanceIdBy(appWidgetId);
        int widgetBackgroundShape = companion.getWidgetBackgroundShape(appWidgetId);
        boolean widgetBackgroundOnOff = companion.getWidgetBackgroundOnOff(appWidgetId);
        StringBuilder sb = new StringBuilder("onUpdate: timeUpdate: ");
        sb.append(jCurrentTimeMillis);
        sb.append(", transparency: ");
        sb.append(transparency);
        AbstractC0622a.m1180z(sb, backgroundColor, darkMode, ", backgroundColor: ", ", darkMode: ");
        sb.append(", isMatchSetting: ");
        sb.append(widgetMatchSetting);
        sb.append(", selectedItems: ");
        sb.append(selectedItemsSet);
        sb.append(", shapeBG: ");
        sb.append(widgetBackgroundShape);
        sb.append(", backgroundOnOff: ");
        sb.append(widgetBackgroundOnOff);
        WidgetLogger.m5154d(TAG, sb.toString());
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C69111(context, glanceIdBy, this, transparency, backgroundColor, darkMode, widgetMatchSetting, selectedItemsSet, jCurrentTimeMillis, widgetBackgroundShape, widgetBackgroundOnOff, null), 3, null);
    }

    public void actionPendingIntentToComposerOther(@NotNull Context context, @Nullable String widgetAction) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (ComposerAccessHandler.getComposerActivityClass() == null) {
            PostLaunchManager.INSTANCE.getInstance().executeBaseLogic(1);
        }
        Intent intent = new Intent(context, ComposerAccessHandler.getComposerActivityClass());
        intent.setFlags(403177472);
        intent.putExtra(ComposerConstants.MEMO_WIDGET_ACTION, widgetAction);
        intent.setAction(ComposerConstants.ACTION_WIDGET);
        context.startActivity(intent);
    }

    public void actionPendingIntentToLaunchNotes(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getApplicationContext().getPackageName());
        if (launchIntentForPackage != null) {
            launchIntentForPackage.setAction("android.intent.action.MAIN");
            launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
            launchIntentForPackage.addFlags(268435456);
            launchIntentForPackage.addFlags(2097152);
            launchIntentForPackage.setPackage(null);
            context.startActivity(launchIntentForPackage);
        }
    }

    public final void deleteWidget(@NotNull Context context, @Nullable ComponentName provider, @NotNull String uuid) throws Throwable {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        WidgetLogger.m5154d(TAG, "deleteWidget#");
        for (int i : AppWidgetManager.getInstance(context).getAppWidgetIds(provider)) {
            if (Intrinsics.areEqual(uuid, BaseWidgetPreferenceManager.INSTANCE.getUUID(i))) {
                WidgetPreferenceManager.deleteWidgetPref(i, false);
                updateWidget(context, i, "deleteWidget");
            }
        }
    }

    @Override // androidx.glance.appwidget.GlanceAppWidgetReceiver
    @NotNull
    public GlanceAppWidget getGlanceAppWidget() {
        return this.glanceAppWidget;
    }

    @NotNull
    public String getProviderName() {
        return this.providerName;
    }

    public final boolean isDeleteNote(@NotNull Context context, @NotNull String uuid, int appWidgetId) throws Throwable {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        MainListDocumentDataRepository mainListDocumentDataRepositoryCreateMainListDocumentDataRepository = NotesDataRepositoryFactory.newInstance(context).createMainListDocumentDataRepository();
        if (mainListDocumentDataRepositoryCreateMainListDocumentDataRepository.get(uuid) != null && mainListDocumentDataRepositoryCreateMainListDocumentDataRepository.get(uuid).getIsDeleted() == 0) {
            return false;
        }
        WidgetLogger.m5156w(TAG, "isDeleteNote# removeAppWidget - " + appWidgetId);
        CacheFileManager companion = CacheFileManager.INSTANCE.getInstance();
        if (companion != null) {
            companion.removeCacheInfo(context, uuid);
        }
        deleteWidget(context, new ComponentName(context, getClass()), uuid);
        return true;
    }

    @Override // androidx.glance.appwidget.GlanceAppWidgetReceiver, android.appwidget.AppWidgetProvider
    public void onAppWidgetOptionsChanged(@NotNull Context context, @NotNull AppWidgetManager appWidgetManager, int appWidgetId, @NotNull Bundle newOptions) {
        String strM767i;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appWidgetManager, "appWidgetManager");
        Intrinsics.checkNotNullParameter(newOptions, "newOptions");
        deleteOldWidgetBackupData(appWidgetManager, appWidgetId);
        BaseWidgetUtils.Companion companion = BaseWidgetUtils.INSTANCE;
        if (companion.isSupportedNewWidget()) {
            super.onAppWidgetOptionsChanged(context, appWidgetManager, appWidgetId, newOptions);
            int i = newOptions.getInt("appWidgetMinWidth");
            int i2 = newOptions.getInt("appWidgetMinHeight");
            int i4 = newOptions.getInt("semAppWidgetColumnSpan");
            BaseWidgetPreferenceManager.Companion companion2 = BaseWidgetPreferenceManager.INSTANCE;
            companion2.saveColumnSpan(appWidgetId, i4);
            companion2.saveMinWidthHeight(appWidgetId, i, i2);
        }
        Logger.m8702i(TAG, "onAppWidgetOptionsChanged# " + appWidgetId);
        int i5 = newOptions.getInt("appWidgetMinWidth");
        int i6 = newOptions.getInt("appWidgetMaxWidth");
        int i7 = context.getResources().getDisplayMetrics().densityDpi;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i5, i6, "onAppWidgetOptionsChanged# - minW (", ")  maxW(", "), ");
        sbM1173s.append(i7);
        sbM1173s.append(" / 160 = ");
        sbM1173s.append(i7 / 160);
        Logger.m8697d(TAG, sbM1173s.toString());
        if (companion.isDarkModeChange(context, appWidgetId)) {
            if (ContextUtils.isNightMode(context)) {
                BaseWidgetPreferenceManager.INSTANCE.saveDarkModePref(appWidgetId, 1);
            } else {
                BaseWidgetPreferenceManager.INSTANCE.saveDarkModePref(appWidgetId, 0);
            }
            strM767i = AbstractC0541b.m767i(appWidgetId, "onAppWidgetOptionsChanged# ", ", updateAppWidget dark mode change");
        } else {
            strM767i = companion.isFoldOrientationChange(context, appWidgetId) ? AbstractC0541b.m767i(appWidgetId, "onAppWidgetOptionsChanged# ", ", updateAppWidget fold orientation change") : WidgetToolbarUtils.INSTANCE.isHeightChanged(context, appWidgetId) ? AbstractC0541b.m767i(appWidgetId, "onAppWidgetOptionsChanged# ", ", updateAppWidget height change") : null;
        }
        boolean widgetData = BaseWidgetPreferenceManager.INSTANCE.getWidgetData(appWidgetId);
        if (TextUtils.isEmpty(strM767i) && widgetData) {
            return;
        }
        if (companion.isSupportedNewWidget()) {
            updateGlance(context, appWidgetId, new GlanceAppWidgetManager(context));
        } else {
            appWidgetManager.updateAppWidget(appWidgetId, makeWidgetToolbarView(context, appWidgetId));
        }
        Logger.m8702i(TAG, strM767i + " widget data: " + widgetData);
    }

    @Override // androidx.glance.appwidget.GlanceAppWidgetReceiver, android.appwidget.AppWidgetProvider
    public void onDeleted(@NotNull Context context, @NotNull int[] appWidgetIds) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appWidgetIds, "appWidgetIds");
        if (BaseWidgetUtils.INSTANCE.isSupportedNewWidget()) {
            super.onDeleted(context, appWidgetIds);
        }
        String string = Arrays.toString(appWidgetIds);
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        Logger.m8702i(TAG, "onDeleted# " + string);
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onDisabled(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (BaseWidgetUtils.INSTANCE.isSupportedNewWidget()) {
            super.onDisabled(context);
        }
        Logger.m8697d(TAG, "onDisabled");
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onEnabled(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (BaseWidgetUtils.INSTANCE.isSupportedNewWidget()) {
            super.onEnabled(context);
        }
        Logger.m8697d(TAG, "onEnabled");
    }

    @Override // androidx.glance.oneui.template.GlanceTemplateAppWidgetReceiver, androidx.glance.appwidget.GlanceAppWidgetReceiver, android.appwidget.AppWidgetProvider, android.content.BroadcastReceiver
    public void onReceive(@NotNull Context context, @NotNull Intent intent) throws Throwable {
        List<Integer> listEmptyList;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        BaseWidgetUtils.Companion companion = BaseWidgetUtils.INSTANCE;
        if (companion.isSupportedNewWidget()) {
            super.onReceive(context, intent);
        } else {
            onReceiveForBelowOneUi7x(context, intent);
        }
        String action = intent.getAction();
        if (action == null) {
            Logger.m8698e(TAG, "onReceive# action is null");
            return;
        }
        WidgetToolbarUtils widgetToolbarUtils = WidgetToolbarUtils.INSTANCE;
        ComponentName componentName = new ComponentName(context, widgetToolbarUtils.getClassProvider(getProviderName()));
        Logger.m8702i(TAG, "onReceive# ".concat(action));
        if (Intrinsics.areEqual(BaseWidgetConstant.ACTION_APPWIDGET_UPDATE, action)) {
            NotesSamsungAnalytics.INSTANCE.insertStatusLog("9977", companion.getWidgetCount(context, WidgetToolBarProvider.class));
            WidgetLogger.m5154d(TAG, "onReceive# WidgetToolBarProvider: " + companion.getWidgetCount(context, WidgetToolBarProvider.class));
            return;
        }
        if (Intrinsics.areEqual(action, BaseWidgetConstant.ACTION_UPDATE_TOOLBAR)) {
            int intExtra = intent.getIntExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, -1);
            if (widgetToolbarUtils.isCurrentProviderWidget(context, componentName, intExtra)) {
                int intExtra2 = intent.getIntExtra(BaseWidgetConstant.EXTRA_KEY_WIDGET_BACKGROUND_COLOR, -1);
                int intExtra3 = intent.getIntExtra(BaseWidgetConstant.EXTRA_KEY_WIDGET_DARK_MODE, -1);
                if (companion.isSupportedNewWidget()) {
                    boolean booleanExtra = intent.getBooleanExtra(BaseWidgetConstant.KEY_WIDGET_MATCH_SETTING, true);
                    BaseWidgetPreferenceManager.Companion companion2 = BaseWidgetPreferenceManager.INSTANCE;
                    companion2.saveWidgetMatchSetting(intExtra, booleanExtra);
                    companion2.saveWidgetBackgroundShape(intExtra, intent.getIntExtra(BaseWidgetConstant.KEY_WIDGET_BACKGROUND_SHAPE, 0));
                    companion2.saveWidgetBackgroundOnOff(intExtra, intent.getBooleanExtra(BaseWidgetConstant.KEY_WIDGET_BACKGROUND_ON_OFF, true));
                    ArrayList<Integer> integerArrayListExtra = intent.getIntegerArrayListExtra(BaseWidgetConstant.KEY_SELECTED_ITEMS);
                    if (integerArrayListExtra == null || (listEmptyList = CollectionsKt.toList(integerArrayListExtra)) == null) {
                        listEmptyList = CollectionsKt.emptyList();
                    }
                    if (!listEmptyList.isEmpty()) {
                        WidgetCreatorPreference.INSTANCE.saveSelectedItems(intExtra, listEmptyList);
                    }
                }
                int intExtra4 = intent.getIntExtra(BaseWidgetConstant.EXTRA_KEY_WIDGET_TRANSPARENCY, -1);
                if (intExtra4 == -1) {
                    intExtra4 = companion.isSupportedNewWidget() ? 75 : 100;
                }
                BaseWidgetPreferenceManager.Companion companion3 = BaseWidgetPreferenceManager.INSTANCE;
                companion3.saveTransparency(intExtra, intExtra4);
                if (intExtra2 != -1) {
                    companion3.saveWidgetBackgroundColorPref(intExtra, intExtra2);
                }
                if (intExtra3 != -1) {
                    companion3.saveDarkModePref(intExtra, intExtra3);
                } else if (ContextUtils.isNightMode(context)) {
                    companion3.saveDarkModePref(intExtra, 1);
                } else {
                    companion3.saveDarkModePref(intExtra, 0);
                }
                AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
                Intrinsics.checkNotNull(appWidgetManager);
                onUpdate(context, appWidgetManager, new int[]{intExtra});
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(BaseWidgetConstant.TIME_SET_CHANGED, action) || Intrinsics.areEqual(BaseWidgetConstant.ACTION_WALLPAPER_CHANGED, action)) {
            AppWidgetManager appWidgetManager2 = AppWidgetManager.getInstance(context);
            int[] appWidgetIds = appWidgetManager2.getAppWidgetIds(new ComponentName(context, (Class<?>) WidgetToolBarProvider.class));
            Intrinsics.checkNotNull(appWidgetManager2);
            Intrinsics.checkNotNull(appWidgetIds);
            onUpdate(context, appWidgetManager2, appWidgetIds);
            return;
        }
        if (Intrinsics.areEqual(action, BaseWidgetConstant.LAUNCH_NOTES_FROM_TOOLBAR)) {
            if (widgetToolbarUtils.isCurrentProviderWidget(context, componentName, intent.getIntExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, -1))) {
                actionPendingIntentToLaunchNotes(context);
                insertLog(action);
                return;
            }
            return;
        }
        if (!Intrinsics.areEqual(action, BaseWidgetConstant.ADD_MEMO_FROM_TOOLBAR)) {
            if (Intrinsics.areEqual(action, BaseWidgetConstant.OPEN_MEMO_FROM_TOOLBAR)) {
                if (NoteListAccessHandler.getNoteListClass() == null) {
                    PostLaunchManager.INSTANCE.getInstance().executeBaseLogic(1);
                }
                Intent intent2 = new Intent(context, NoteListAccessHandler.getNoteListClass());
                intent2.setFlags(DriveFile.MODE_READ_WRITE);
                MultiTaskManager.INSTANCE.getInstance().startActivity(context, intent2);
                NotesSamsungAnalytics.INSTANCE.insertLog("612", "6111");
                return;
            }
            return;
        }
        synchronized (this) {
            if (widgetToolbarUtils.isCurrentProviderWidget(context, componentName, intent.getIntExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, -1))) {
                String stringExtra = intent.getStringExtra(ComposerConstants.MEMO_WIDGET_ACTION);
                Logger.m8697d(TAG, "onReceive, widgetAction: " + stringExtra);
                insertLog(stringExtra);
                long jUptimeMillis = SystemClock.uptimeMillis();
                Logger.m8697d(TAG, "onReceive : RT - " + jUptimeMillis + " PT - " + mPreviousEventTime);
                if (jUptimeMillis > mPreviousEventTime) {
                    if (!StorageUtils.isAvailableMemoryForNewMemo()) {
                        Intent intent3 = new Intent(context, (Class<?>) StorageErrorDialogActivity.class);
                        intent3.setFlags(402653184);
                        context.startActivity(intent3);
                        return;
                    }
                    actionPendingIntentToComposerOther(context, stringExtra);
                    mPreviousEventTime = SystemClock.uptimeMillis() + 1000;
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void onReceiveForBelowOneUi7x(@NotNull Context context, @NotNull Intent intent) throws Throwable {
        Bundle extras;
        int[] intArray;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        String action = intent.getAction();
        if (Intrinsics.areEqual(BaseWidgetConstant.ACTION_APPWIDGET_UPDATE, action)) {
            Bundle extras2 = intent.getExtras();
            if (extras2 == null || (intArray = extras2.getIntArray("appWidgetIds")) == null || intArray.length <= 0) {
                return;
            }
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            Intrinsics.checkNotNullExpressionValue(appWidgetManager, "getInstance(...)");
            onUpdate(context, appWidgetManager, intArray);
            return;
        }
        if (Intrinsics.areEqual("android.appwidget.action.APPWIDGET_DELETED", action)) {
            Bundle extras3 = intent.getExtras();
            if (extras3 == null || !extras3.containsKey(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID)) {
                return;
            }
            onDeleted(context, new int[]{extras3.getInt(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID)});
            return;
        }
        if (Intrinsics.areEqual("android.appwidget.action.APPWIDGET_UPDATE_OPTIONS", action)) {
            Bundle extras4 = intent.getExtras();
            if (extras4 != null && extras4.containsKey(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID) && extras4.containsKey("appWidgetOptions")) {
                int i = extras4.getInt(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID);
                Bundle bundle = extras4.getBundle("appWidgetOptions");
                if (bundle != null) {
                    AppWidgetManager appWidgetManager2 = AppWidgetManager.getInstance(context);
                    Intrinsics.checkNotNullExpressionValue(appWidgetManager2, "getInstance(...)");
                    onAppWidgetOptionsChanged(context, appWidgetManager2, i, bundle);
                    return;
                }
                return;
            }
            return;
        }
        if (Intrinsics.areEqual("android.appwidget.action.APPWIDGET_ENABLED", action)) {
            onEnabled(context);
            return;
        }
        if (Intrinsics.areEqual("android.appwidget.action.APPWIDGET_DISABLED", action)) {
            onDisabled(context);
            return;
        }
        if (!Intrinsics.areEqual("android.appwidget.action.APPWIDGET_RESTORED", action) || (extras = intent.getExtras()) == null) {
            return;
        }
        int[] intArray2 = extras.getIntArray("appWidgetOldIds");
        int[] intArray3 = extras.getIntArray("appWidgetIds");
        if (intArray2 == null || intArray2.length <= 0) {
            return;
        }
        Intrinsics.checkNotNull(intArray3);
        onRestored(context, intArray2, intArray3);
        AppWidgetManager appWidgetManager3 = AppWidgetManager.getInstance(context);
        Intrinsics.checkNotNullExpressionValue(appWidgetManager3, "getInstance(...)");
        onUpdate(context, appWidgetManager3, intArray3);
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onRestored(@NotNull Context context, @NotNull int[] oldWidgetIds, @NotNull int[] newWidgetIds) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(oldWidgetIds, "oldWidgetIds");
        Intrinsics.checkNotNullParameter(newWidgetIds, "newWidgetIds");
        if (BaseWidgetUtils.INSTANCE.isSupportedNewWidget()) {
            super.onRestored(context, oldWidgetIds, newWidgetIds);
        }
        String string = Arrays.toString(oldWidgetIds);
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        Logger.m8697d(TAG, "onRestored oldWidgetIds " + string);
        String string2 = Arrays.toString(newWidgetIds);
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        Logger.m8697d(TAG, "onRestored oldWidgetIds " + string2);
    }

    @Override // androidx.glance.appwidget.GlanceAppWidgetReceiver, android.appwidget.AppWidgetProvider
    public void onUpdate(@NotNull Context context, @NotNull AppWidgetManager appWidgetManager, @NotNull int[] appWidgetIds) throws Throwable {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appWidgetManager, "appWidgetManager");
        Intrinsics.checkNotNullParameter(appWidgetIds, "appWidgetIds");
        String string = Arrays.toString(appWidgetIds);
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        Logger.m8702i(TAG, "onUpdate# appWidgetIds: " + string);
        int i = 0;
        if (!BaseWidgetUtils.INSTANCE.isSupportedNewWidget()) {
            int length = appWidgetIds.length;
            while (i < length) {
                int i2 = appWidgetIds[i];
                restoreBySmartSwitch(appWidgetManager, i2);
                appWidgetManager.updateAppWidget(i2, makeWidgetToolbarView(context, i2));
                Logger.m8702i(TAG, "onUpdate# " + i2 + " updateAppWidget");
                i++;
            }
            return;
        }
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        GlanceAppWidgetManager glanceAppWidgetManager = new GlanceAppWidgetManager(context);
        int length2 = appWidgetIds.length;
        while (i < length2) {
            int i4 = appWidgetIds[i];
            Bundle appWidgetOptions = appWidgetManager.getAppWidgetOptions(i4);
            int i5 = appWidgetOptions.getInt("appWidgetMinWidth");
            int i6 = appWidgetOptions.getInt("appWidgetMinHeight");
            int i7 = appWidgetOptions.getInt("semAppWidgetColumnSpan");
            BaseWidgetPreferenceManager.Companion companion = BaseWidgetPreferenceManager.INSTANCE;
            companion.saveColumnSpan(i4, i7);
            companion.saveMinWidthHeight(i4, i5, i6);
            Bundle appWidgetOptions2 = AppWidgetManager.getInstance(context).getAppWidgetOptions(i4);
            if (appWidgetOptions2.get("oneUiWidgetSource") != null) {
                companion.saveOneUiWidgetSource(i4, String.valueOf(appWidgetOptions2.get("oneUiWidgetSource")));
            }
            restoreBySmartSwitch(appWidgetManager, i4);
            updateGlance(context, i4, glanceAppWidgetManager);
            Logger.m8702i(TAG, "onUpdate# " + i4 + " updateAppWidget");
            i++;
        }
    }

    public final void updateWidget(@NotNull Context context, int widgetId, @NotNull String caller) throws Throwable {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(caller, "caller");
        WidgetLogger.m5155i(TAG, "updateWidget# " + widgetId + " : " + caller);
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        Intrinsics.checkNotNull(appWidgetManager);
        onUpdate(context, appWidgetManager, new int[]{widgetId});
    }
}
