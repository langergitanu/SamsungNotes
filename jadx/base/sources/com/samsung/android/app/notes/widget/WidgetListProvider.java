package com.samsung.android.app.notes.widget;

import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.widget.RemoteViews;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import androidx.glance.AbstractC2821a;
import androidx.glance.GlanceId;
import androidx.glance.appwidget.GlanceAppWidget;
import androidx.glance.appwidget.GlanceAppWidgetManager;
import androidx.glance.appwidget.state.GlanceAppWidgetStateKt;
import androidx.glance.oneui.template.GlanceTemplateAppWidgetReceiver;
import com.opencsv.bean.C6618c;
import com.samsung.android.app.notes.widget.broadcast.WidgetBroadcast;
import com.samsung.android.app.notes.widget.common.constants.WidgetConstant;
import com.samsung.android.app.notes.widget.common.log.WidgetLogger;
import com.samsung.android.app.notes.widget.cover.WidgetListExtraLargeCoverProvider;
import com.samsung.android.app.notes.widget.cover.WidgetListLargeCoverProvider;
import com.samsung.android.app.notes.widget.cover.WidgetListMediumCoverProvider;
import com.samsung.android.app.notes.widget.dialog.StorageErrorDialogActivity;
import com.samsung.android.app.notes.widget.glance.list.WidgetListGlance;
import com.samsung.android.app.notes.widget.lockbrief.list.WidgetListLockBriefProvider;
import com.samsung.android.app.notes.widget.preference.WidgetPreferenceManager;
import com.samsung.android.app.notes.widget.setting.WidgetListSettingActivity;
import com.samsung.android.app.notes.widget.theme.NoteListThemeManager;
import com.samsung.android.app.notes.widget.theme.ThemeInfo;
import com.samsung.android.app.notes.widget.util.ProviderUtils;
import com.samsung.android.app.notes.widget.util.WidgetBRHelper;
import com.samsung.android.app.notes.widget.util.WidgetUtils;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p145cm.base.framework.app.KeyguardManagerCompat;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.base.common.MultiTaskManager;
import com.samsung.android.support.senl.p148nt.base.common.access.document.DocumentAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.access.notelist.NoteListAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.NotesSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.HomeScreenUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.StorageUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.widget.preference.BaseWidgetPreferenceManager;
import com.samsung.android.support.senl.p148nt.base.widget.util.BaseWidgetUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesDocumentRepository;
import com.samsung.android.support.senl.p148nt.homewidget.C11391R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p122b2.C4191n;
import p123b3.C4201a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u0000 M2\u00020\u0001:\u0001MB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0016\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u001a\u0010\u001a\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\tH\u0002J,\u0010\u001c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u001a\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\u001ej\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\u001fH\u0002J\u0010\u0010 \u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J \u0010!\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010#H\u0002J \u0010$\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010#H\u0002J\u0018\u0010%\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010&\u001a\u00020\rH\u0002J\u0018\u0010'\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020)H\u0016J4\u0010*\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020)2\u001a\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\u001ej\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\u001fH\u0016J\u0018\u0010+\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J*\u0010,\u001a\b\u0012\u0004\u0012\u00020\t0#2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\t0.2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\t0.H\u0002J\u0010\u00100\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u00101\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J \u00102\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u00103\u001a\u00020)H\u0002J\u0018\u00104\u001a\u0002052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020)H\u0002J\u0018\u00106\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J&\u00107\u001a\u0002052\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0#2\u0006\u00103\u001a\u00020)H\u0002J \u00108\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020)2\u0006\u00109\u001a\u00020\tH\u0002J(\u0010:\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u00103\u001a\u00020)2\u0006\u0010;\u001a\u00020<H\u0016J(\u0010=\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u00103\u001a\u00020)2\u0006\u00109\u001a\u00020\tH\u0002J(\u0010>\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010?\u001a\u00020@2\u0006\u00103\u001a\u00020)2\u0006\u00109\u001a\u00020\tH\u0002J \u0010A\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010?\u001a\u00020@2\u0006\u00103\u001a\u00020)H\u0002J \u0010B\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010?\u001a\u00020@2\u0006\u00103\u001a\u00020)H\u0016J \u0010C\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010D\u001a\u00020E2\u0006\u00103\u001a\u00020)H\u0002J\u0018\u0010F\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u00103\u001a\u00020)H\u0002J \u0010F\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010D\u001a\u00020E2\u0006\u00103\u001a\u00020)H\u0002J \u0010G\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u00103\u001a\u00020)2\u0006\u00109\u001a\u00020\tH\u0002J(\u0010H\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u00103\u001a\u00020)2\u0006\u0010D\u001a\u00020E2\u0006\u00109\u001a\u00020\tH\u0002J\u0018\u0010I\u001a\u00020)2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020)H\u0002J\u0016\u0010J\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018J\u0014\u0010K\u001a\u0006\u0012\u0002\b\u00030L2\u0006\u0010\b\u001a\u00020\tH\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006N"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/WidgetListProvider;", "Landroidx/glance/oneui/template/GlanceTemplateAppWidgetReceiver;", "<init>", "()V", "glanceAppWidget", "Landroidx/glance/appwidget/GlanceAppWidget;", "getGlanceAppWidget", "()Landroidx/glance/appwidget/GlanceAppWidget;", "providerName", "", "getProviderName", "()Ljava/lang/String;", "onUpdate", "", "context", "Landroid/content/Context;", "appWidgetManager", "Landroid/appwidget/AppWidgetManager;", "appWidgetIds", "", "onEnabled", "onDisabled", "onReceive", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "startWidgetSetting", "updateUuidWidget", "uuid", "updateUuidListWidget", "uuidList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "updateAllMemo", "deleteUuidWidget", "deleteUuidList", "", "deleteUuidWidgetOneUi7x", "openSelectedNote", "prepareContract", "startNotePicker", "widgetId", "", "onNotePickerClickedActionAdd", "doneNotePicker", "updateDataListUuid", "uuidListBefore", "", "uuidListPickDone", "updateAllWidget", "updateAllWidgetOneUi7x", "saveWidgetBackground", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "isNotListWidget", "", "onDeleted", "isDeleteNote", "updateWidget", NotesConstants.KEY_CALLER, "onAppWidgetOptionsChanged", "newOptions", "Landroid/os/Bundle;", "updateAppWidgetView", "updateAppWidgetViewOneUi7x", "glanceManager", "Landroidx/glance/appwidget/GlanceAppWidgetManager;", "updateWidgetOneUi7x", "updateGlance", "updateRemoteServiceIntent", "remoteViews", "Landroid/widget/RemoteViews;", "updateEmptyWidgetView", "notifyAppWidgetViewDataChanged", "updateAppWidget", "getLayoutId", "onReceiveForBelowOneUi7x", "getClassProvider", "Ljava/lang/Class;", "Companion", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nWidgetListProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetListProvider.kt\ncom/samsung/android/app/notes/widget/WidgetListProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,965:1\n774#2:966\n865#2,2:967\n*S KotlinDebug\n*F\n+ 1 WidgetListProvider.kt\ncom/samsung/android/app/notes/widget/WidgetListProvider\n*L\n247#1:966\n247#1:967,2\n*E\n"})
public class WidgetListProvider extends GlanceTemplateAppWidgetReceiver {

    @NotNull
    private static final String TAG = "WidgetListProvider";
    private static final long mPreviousEventTime = 0;

    @NotNull
    private final GlanceAppWidget glanceAppWidget = new WidgetListGlance();

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
    private static final Preferences.Key<String> uuidListKey = PreferencesKeys.stringKey("uuidListKey");

    @NotNull
    private static final Preferences.Key<Long> requestTimeKey = PreferencesKeys.longKey("requestTimeKey");

    @NotNull
    private static final Preferences.Key<Integer> backgroundShapeKey = PreferencesKeys.intKey("backgroundShapeKey");

    @NotNull
    private static final Preferences.Key<Boolean> backgroundOnOffKey = PreferencesKeys.booleanKey("backgroundOnOffKey");

    @NotNull
    private static final Preferences.Key<String> providerNameKey = PreferencesKeys.stringKey("providerNameKey");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\fR\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\fR\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\fR\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\fR\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00120\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\fR\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\f¨\u0006\""}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/WidgetListProvider$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mPreviousEventTime", "", "transparencyKey", "Landroidx/datastore/preferences/core/Preferences$Key;", "", "getTransparencyKey", "()Landroidx/datastore/preferences/core/Preferences$Key;", "backgroundColorKey", "getBackgroundColorKey", "darkModeKey", "getDarkModeKey", "matchSettingKey", "", "getMatchSettingKey", "uuidListKey", "getUuidListKey", "requestTimeKey", "getRequestTimeKey", "backgroundShapeKey", "getBackgroundShapeKey", "backgroundOnOffKey", "getBackgroundOnOffKey", "providerNameKey", "getProviderNameKey", "openMemoList", "", "context", "Landroid/content/Context;", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void openMemoList(Context context) {
            if (NoteListAccessHandler.getNoteListClass() == null) {
                PostLaunchManager.INSTANCE.getInstance().executeBaseLogic(1);
            }
            Intent intent = new Intent(context, NoteListAccessHandler.getNoteListClass());
            WidgetBroadcast.sendUpdateAllWidgetBroadcast(context);
            intent.setFlags(335544320);
            MultiTaskManager.INSTANCE.getInstance().startActivity(context, intent);
        }

        @NotNull
        public final Preferences.Key<Integer> getBackgroundColorKey() {
            return WidgetListProvider.backgroundColorKey;
        }

        @NotNull
        public final Preferences.Key<Boolean> getBackgroundOnOffKey() {
            return WidgetListProvider.backgroundOnOffKey;
        }

        @NotNull
        public final Preferences.Key<Integer> getBackgroundShapeKey() {
            return WidgetListProvider.backgroundShapeKey;
        }

        @NotNull
        public final Preferences.Key<Integer> getDarkModeKey() {
            return WidgetListProvider.darkModeKey;
        }

        @NotNull
        public final Preferences.Key<Boolean> getMatchSettingKey() {
            return WidgetListProvider.matchSettingKey;
        }

        @NotNull
        public final Preferences.Key<String> getProviderNameKey() {
            return WidgetListProvider.providerNameKey;
        }

        @NotNull
        public final Preferences.Key<Long> getRequestTimeKey() {
            return WidgetListProvider.requestTimeKey;
        }

        @NotNull
        public final Preferences.Key<Integer> getTransparencyKey() {
            return WidgetListProvider.transparencyKey;
        }

        @NotNull
        public final Preferences.Key<String> getUuidListKey() {
            return WidgetListProvider.uuidListKey;
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.app.notes.widget.WidgetListProvider$updateGlance$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.samsung.android.app.notes.widget.WidgetListProvider$updateGlance$1", m14021f = "WidgetListProvider.kt", m14022i = {}, m14023l = {784, 795}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C69091 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $backgroundColor;
        final /* synthetic */ boolean $backgroundOnOff;
        final /* synthetic */ int $backgroundShape;
        final /* synthetic */ Context $context;
        final /* synthetic */ int $darkMode;
        final /* synthetic */ GlanceId $glanceId;
        final /* synthetic */ boolean $matchSetting;
        final /* synthetic */ long $requestTime;
        final /* synthetic */ int $transparency;
        final /* synthetic */ String $uuidList;
        int label;
        final /* synthetic */ WidgetListProvider this$0;

        /* JADX INFO: renamed from: com.samsung.android.app.notes.widget.WidgetListProvider$updateGlance$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, m13886d2 = {"<anonymous>", "", "state", "Landroidx/datastore/preferences/core/MutablePreferences;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
        @DebugMetadata(m14020c = "com.samsung.android.app.notes.widget.WidgetListProvider$updateGlance$1$1", m14021f = "WidgetListProvider.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
            final /* synthetic */ int $backgroundColor;
            final /* synthetic */ boolean $backgroundOnOff;
            final /* synthetic */ int $backgroundShape;
            final /* synthetic */ int $darkMode;
            final /* synthetic */ boolean $matchSetting;
            final /* synthetic */ long $requestTime;
            final /* synthetic */ int $transparency;
            final /* synthetic */ String $uuidList;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ WidgetListProvider this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(int i, int i2, int i4, boolean z, String str, long j, int i5, boolean z2, WidgetListProvider widgetListProvider, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$transparency = i;
                this.$backgroundColor = i2;
                this.$darkMode = i4;
                this.$matchSetting = z;
                this.$uuidList = str;
                this.$requestTime = j;
                this.$backgroundShape = i5;
                this.$backgroundOnOff = z2;
                this.this$0 = widgetListProvider;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$transparency, this.$backgroundColor, this.$darkMode, this.$matchSetting, this.$uuidList, this.$requestTime, this.$backgroundShape, this.$backgroundOnOff, this.this$0, continuation);
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
                Companion companion = WidgetListProvider.INSTANCE;
                mutablePreferences.set(companion.getTransparencyKey(), Boxing.boxInt(this.$transparency));
                mutablePreferences.set(companion.getBackgroundColorKey(), Boxing.boxInt(this.$backgroundColor));
                mutablePreferences.set(companion.getDarkModeKey(), Boxing.boxInt(this.$darkMode));
                mutablePreferences.set(companion.getMatchSettingKey(), Boxing.boxBoolean(this.$matchSetting));
                mutablePreferences.set(companion.getUuidListKey(), this.$uuidList);
                mutablePreferences.set(companion.getRequestTimeKey(), Boxing.boxLong(this.$requestTime));
                mutablePreferences.set(companion.getBackgroundShapeKey(), Boxing.boxInt(this.$backgroundShape));
                mutablePreferences.set(companion.getBackgroundOnOffKey(), Boxing.boxBoolean(this.$backgroundOnOff));
                mutablePreferences.set(companion.getProviderNameKey(), this.this$0.getProviderName());
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C69091(Context context, GlanceId glanceId, WidgetListProvider widgetListProvider, int i, int i2, int i4, boolean z, String str, long j, int i5, boolean z2, Continuation<? super C69091> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$glanceId = glanceId;
            this.this$0 = widgetListProvider;
            this.$transparency = i;
            this.$backgroundColor = i2;
            this.$darkMode = i4;
            this.$matchSetting = z;
            this.$uuidList = str;
            this.$requestTime = j;
            this.$backgroundShape = i5;
            this.$backgroundOnOff = z2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C69091(this.$context, this.$glanceId, this.this$0, this.$transparency, this.$backgroundColor, this.$darkMode, this.$matchSetting, this.$uuidList, this.$requestTime, this.$backgroundShape, this.$backgroundOnOff, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x005c, code lost:
        
            if (r2.update(r3, r4, r18) == r1) goto L15;
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
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$transparency, this.$backgroundColor, this.$darkMode, this.$matchSetting, this.$uuidList, this.$requestTime, this.$backgroundShape, this.$backgroundOnOff, this.this$0, null);
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
            return ((C69091) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    private final void deleteUuidWidget(Context context, List<String> deleteUuidList) {
        for (int i : AppWidgetManager.getInstance(context).getAppWidgetIds(new ComponentName(context, (Class<?>) WidgetListProvider.class))) {
            List<String> noteUuidList = WidgetPreferenceManager.INSTANCE.getNoteUuidList(i);
            Intrinsics.checkNotNull(noteUuidList, "null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.String>");
            List<String> listAsMutableList = TypeIntrinsics.asMutableList(noteUuidList);
            Intrinsics.checkNotNull(deleteUuidList);
            boolean z = false;
            for (String str : deleteUuidList) {
                if (listAsMutableList.remove(str) || (listAsMutableList.isEmpty() && Intrinsics.areEqual(str, BaseWidgetConstant.NONE))) {
                    z = true;
                }
            }
            if (z) {
                if (listAsMutableList.isEmpty()) {
                    WidgetPreferenceManager.INSTANCE.removeAllNoteUuidList(i);
                } else {
                    WidgetPreferenceManager.INSTANCE.saveNoteUuidList(i, listAsMutableList);
                }
                updateWidget(context, i, "deleteWidget");
            }
        }
    }

    private final void deleteUuidWidgetOneUi7x(Context context, List<String> deleteUuidList) {
        for (int i : AppWidgetManager.getInstance(context).getAppWidgetIds(new ComponentName(context, getClassProvider(getProviderName())))) {
            List<String> noteUuidList = WidgetPreferenceManager.INSTANCE.getNoteUuidList(i);
            Intrinsics.checkNotNull(noteUuidList, "null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.String>");
            List<String> listAsMutableList = TypeIntrinsics.asMutableList(noteUuidList);
            Intrinsics.checkNotNull(deleteUuidList);
            boolean z = false;
            for (String str : deleteUuidList) {
                if (listAsMutableList.remove(str) || (listAsMutableList.isEmpty() && Intrinsics.areEqual(str, BaseWidgetConstant.NONE))) {
                    z = true;
                }
            }
            if (z) {
                if (listAsMutableList.isEmpty()) {
                    WidgetPreferenceManager.INSTANCE.removeAllNoteUuidList(i);
                } else {
                    WidgetPreferenceManager.INSTANCE.saveNoteUuidList(i, listAsMutableList);
                }
                AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
                Intrinsics.checkNotNullExpressionValue(appWidgetManager, "getInstance(...)");
                onUpdate(context, appWidgetManager, new int[]{i});
            }
        }
    }

    private final void doneNotePicker(Context context, Intent intent) {
        int intExtra = intent.getIntExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, -1);
        int intExtra2 = intent.getIntExtra(WidgetConstant.EXTRA_KEY_WIDGET_LIST_FROM_ACTION, -1);
        WidgetPreferenceManager widgetPreferenceManager = WidgetPreferenceManager.INSTANCE;
        List<String> noteUuidListBeforeAdd = widgetPreferenceManager.getNoteUuidListBeforeAdd(intExtra);
        Intrinsics.checkNotNull(noteUuidListBeforeAdd, "null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.String>");
        List<String> listAsMutableList = TypeIntrinsics.asMutableList(noteUuidListBeforeAdd);
        List<String> stringArrayListExtra = intent.getStringArrayListExtra(WidgetConstant.EXTRA_KEY_NOTE_UUID_LIST);
        if (stringArrayListExtra == null || stringArrayListExtra.isEmpty()) {
            widgetPreferenceManager.removeAllNoteUuidList(intExtra);
            WidgetLogger.m5154d(TAG, "donePicker# empty");
        } else {
            if (intExtra2 != 2) {
                stringArrayListExtra = updateDataListUuid(listAsMutableList, stringArrayListExtra);
            }
            widgetPreferenceManager.saveNoteUuidList(intExtra, stringArrayListExtra);
            widgetPreferenceManager.saveNoteUuidListBeforeAdd(intExtra, stringArrayListExtra);
            WidgetLogger.m5154d(TAG, "donePicker# " + stringArrayListExtra.size());
        }
        HomeScreenUtils homeScreenUtils = HomeScreenUtils.INSTANCE;
        widgetPreferenceManager.saveWidgetDisplayDevicePref(intExtra, homeScreenUtils.getWidgetAddDisplayType(context));
        widgetPreferenceManager.saveWidgetHomeModePref(intExtra, homeScreenUtils.getHomeMode(context));
        saveWidgetBackground(context, intent, intExtra);
        if (!BaseWidgetUtils.INSTANCE.isSupportedNewWidget()) {
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            Intrinsics.checkNotNullExpressionValue(appWidgetManager, "getInstance(...)");
            updateAppWidgetView(context, appWidgetManager, intExtra, "donePicker");
        } else {
            boolean booleanExtra = intent.getBooleanExtra(BaseWidgetConstant.KEY_WIDGET_MATCH_SETTING, true);
            BaseWidgetPreferenceManager.Companion companion = BaseWidgetPreferenceManager.INSTANCE;
            companion.saveWidgetMatchSetting(intExtra, booleanExtra);
            companion.saveWidgetBackgroundShape(intExtra, intent.getIntExtra(BaseWidgetConstant.KEY_WIDGET_BACKGROUND_SHAPE, 0));
            companion.saveWidgetBackgroundOnOff(intExtra, intent.getBooleanExtra(BaseWidgetConstant.KEY_WIDGET_BACKGROUND_ON_OFF, true));
            updateAppWidgetViewOneUi7x(context, new GlanceAppWidgetManager(context), intExtra, "donePicker");
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final Class<?> getClassProvider(String providerName) {
        switch (providerName.hashCode()) {
            case -722604002:
                return !providerName.equals(BaseWidgetConstant.WIDGET_LIST_LOCK_BRIEF_PROVIDER_NAME) ? WidgetListProvider.class : WidgetListLockBriefProvider.class;
            case -593366001:
                return !providerName.equals(WidgetListLargeCoverProvider.TAG) ? WidgetListProvider.class : WidgetListLargeCoverProvider.class;
            case -504469509:
                return !providerName.equals(WidgetListExtraLargeCoverProvider.TAG) ? WidgetListProvider.class : WidgetListExtraLargeCoverProvider.class;
            case 1564427473:
                return !providerName.equals(WidgetListMediumCoverProvider.TAG) ? WidgetListProvider.class : WidgetListMediumCoverProvider.class;
            default:
                return WidgetListProvider.class;
        }
    }

    private final int getLayoutId(Context context, int widgetId) {
        return BaseWidgetUtils.INSTANCE.getWidgetLayoutId(context, widgetId, C11391R.layout.widget_list_init_phone_portrait_layout, C11391R.layout.widget_list_init_phone, C11391R.layout.widget_list_init);
    }

    private final boolean isDeleteNote(Context context, List<String> uuidList, int appWidgetId) {
        if (!uuidList.isEmpty() && !Intrinsics.areEqual(uuidList.get(0), "")) {
            return false;
        }
        WidgetLogger.m5156w(TAG, "isDeleteNote# removeAppWidget - " + appWidgetId);
        WidgetPreferenceManager.INSTANCE.removeAllNoteUuidList(appWidgetId);
        updateWidget(context, appWidgetId, "deleteWidget");
        return true;
    }

    private final boolean isNotListWidget(Context context, int widgetId) {
        int[] appWidgetIds = AppWidgetManager.getInstance(context).getAppWidgetIds(new ComponentName(context, getClassProvider(getProviderName())));
        int length = appWidgetIds.length;
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            if (appWidgetIds[i] == widgetId) {
                z = true;
                break;
            }
            i++;
        }
        return !z;
    }

    private final void notifyAppWidgetViewDataChanged(AppWidgetManager appWidgetManager, int appWidgetId, String caller) {
        WidgetLogger.m5155i(TAG, "notifyAppWidgetViewDataChanged# widgetId: " + appWidgetId + SQLKeyword.COMMA + caller);
        appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetId, C11391R.id.widget_list_view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onNotePickerClickedActionAdd$lambda$3(Context context, Intent intent, Display display) {
        Intrinsics.checkNotNullParameter(display, "display");
        context.startActivity(intent, ActivityOptions.makeBasic().setLaunchDisplayId(display.getDisplayId()).toBundle());
    }

    private final void prepareContract() {
        if (DocumentAccessHandler.getContract() == null) {
            PostLaunchManager.INSTANCE.getInstance().executeBaseLogic(1);
        }
    }

    private final void saveWidgetBackground(Context context, Intent intent, int appWidgetId) {
        int intExtra = intent.getIntExtra(BaseWidgetConstant.EXTRA_KEY_WIDGET_TRANSPARENCY, -1);
        if (intExtra == -1) {
            intExtra = BaseWidgetUtils.INSTANCE.isSupportedNewWidget() ? 75 : 100;
        }
        BaseWidgetPreferenceManager.Companion companion = BaseWidgetPreferenceManager.INSTANCE;
        companion.saveTransparency(appWidgetId, intExtra);
        int intExtra2 = intent.getIntExtra(BaseWidgetConstant.EXTRA_KEY_WIDGET_BACKGROUND_COLOR, -1);
        if (intExtra2 != -1) {
            companion.saveWidgetBackgroundColorPref(appWidgetId, intExtra2);
        }
        int intExtra3 = intent.getIntExtra(BaseWidgetConstant.EXTRA_KEY_WIDGET_DARK_MODE, -1);
        if (intExtra3 != -1) {
            companion.saveDarkModePref(appWidgetId, intExtra3);
        } else if (ContextUtils.isNightMode(context)) {
            companion.saveDarkModePref(appWidgetId, 1);
        } else {
            companion.saveDarkModePref(appWidgetId, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startNotePicker$lambda$1(Context context, Intent intent, Display display) {
        Intrinsics.checkNotNullParameter(display, "display");
        context.startActivity(intent, ActivityOptions.makeBasic().setLaunchDisplayId(display.getDisplayId()).toBundle());
        return Unit.INSTANCE;
    }

    private final void startWidgetSetting(Context context, Intent intent) {
        if (System.currentTimeMillis() <= 0) {
            return;
        }
        int intExtra = intent.getIntExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, -1);
        Intent intent2 = new Intent(context, (Class<?>) WidgetListSettingActivity.class);
        intent2.setAction(WidgetConstant.ACTION_MEMO_PICK);
        intent2.setFlags(ComposerConstants.ACTIVITY_FLAG_CALLEE);
        intent2.putExtra(WidgetConstant.EXTRA_KEY_WIDGET_PICK_MEMO, true);
        intent2.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, intExtra);
        BaseWidgetPreferenceManager.Companion companion = BaseWidgetPreferenceManager.INSTANCE;
        intent2.putExtra(WidgetConstant.EXTRA_KEY_UUID, companion.getUUID(intExtra));
        intent2.putExtra(WidgetConstant.Pick.TYPE, 1);
        intent2.putExtra(BaseWidgetConstant.EXTRA_KEY_WIDGET_TRANSPARENCY, companion.getTransparency(intExtra));
        intent2.putExtra(BaseWidgetConstant.EXTRA_KEY_WIDGET_BACKGROUND_COLOR, companion.getBackgroundColor(intExtra));
        intent2.putExtra(BaseWidgetConstant.EXTRA_KEY_WIDGET_DARK_MODE, companion.getDarkMode(intExtra));
        if (!Intrinsics.areEqual(getProviderName(), WidgetListLargeCoverProvider.TAG) && !Intrinsics.areEqual(getProviderName(), WidgetListMediumCoverProvider.TAG) && !Intrinsics.areEqual(getProviderName(), WidgetListExtraLargeCoverProvider.TAG)) {
            context.startActivity(intent2);
            return;
        }
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra(WidgetConstant.EXTRA_KEY_NOTE_UUID_LIST);
        WidgetPreferenceManager widgetPreferenceManager = WidgetPreferenceManager.INSTANCE;
        Intrinsics.checkNotNull(stringArrayListExtra, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String?>");
        widgetPreferenceManager.saveNoteUuidListBeforeAdd(intExtra, stringArrayListExtra);
        intent2.putExtra(BaseWidgetConstant.KEY_WIDGET_MATCH_SETTING, companion.getWidgetMatchSetting(intExtra));
        intent2.putExtra(BaseWidgetConstant.KEY_WIDGET_BACKGROUND_SHAPE, companion.getWidgetBackgroundShape(intExtra));
        intent2.putStringArrayListExtra(WidgetConstant.EXTRA_KEY_NOTE_UUID_LIST, stringArrayListExtra);
        PendingIntent activity = PendingIntent.getActivity(context, 0, intent2, 201326592);
        Intent intent3 = new Intent();
        intent3.putExtra("showCoverToast", true);
        intent3.putExtra("ignoreKeyguardState", true);
        KeyguardManagerCompat companion2 = KeyguardManagerCompat.INSTANCE.getInstance();
        Intrinsics.checkNotNull(activity);
        companion2.semSetPendingIntentAfterUnlock(context, activity, intent3);
    }

    private final void updateAllMemo(Context context) {
        WidgetLogger.m5154d(TAG, "updateAllMemo#");
        try {
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(context, getClassProvider(getProviderName())));
            Intrinsics.checkNotNull(appWidgetIds);
            if (appWidgetIds.length == 0) {
                return;
            }
            Intrinsics.checkNotNull(appWidgetManager);
            onUpdate(context, appWidgetManager, appWidgetIds);
        } catch (Exception e) {
            WidgetLogger.INSTANCE.m5158e(TAG, "updateAllMemo# ", e);
        }
    }

    private final void updateAllWidget(Context context) {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        for (int i : appWidgetManager.getAppWidgetIds(new ComponentName(context, getClassProvider(getProviderName())))) {
            Intrinsics.checkNotNull(appWidgetManager);
            updateAppWidgetView(context, appWidgetManager, i, "updateAllWidget");
        }
    }

    private final void updateAllWidgetOneUi7x(Context context) {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        GlanceAppWidgetManager glanceAppWidgetManager = new GlanceAppWidgetManager(context);
        for (int i : appWidgetManager.getAppWidgetIds(new ComponentName(context, getClassProvider(getProviderName())))) {
            updateAppWidgetViewOneUi7x(context, glanceAppWidgetManager, i, "updateAllWidget");
        }
    }

    private final void updateAppWidget(AppWidgetManager appWidgetManager, int appWidgetId, RemoteViews remoteViews, String caller) {
        WidgetLogger.m5155i(TAG, "updateAppWidget# widgetId: " + appWidgetId + SQLKeyword.COMMA + caller);
        appWidgetManager.updateAppWidget(appWidgetId, remoteViews);
    }

    private final void updateAppWidgetView(Context context, AppWidgetManager appWidgetManager, int appWidgetId, String caller) {
        if (isNotListWidget(context, appWidgetId)) {
            WidgetLogger.m5156w(TAG, "updateAppWidgetView# fail " + appWidgetId);
            return;
        }
        BaseWidgetPreferenceManager.Companion companion = BaseWidgetPreferenceManager.INSTANCE;
        companion.saveWidgetMatchSetting(appWidgetId, false);
        Bundle appWidgetOptions = AppWidgetManager.getInstance(context).getAppWidgetOptions(appWidgetId);
        if (appWidgetOptions.get("oneUiWidgetSource") != null) {
            companion.saveOneUiWidgetSource(appWidgetId, String.valueOf(appWidgetOptions.get("oneUiWidgetSource")));
        }
        List<String> noteUuidList = WidgetPreferenceManager.INSTANCE.getNoteUuidList(appWidgetId);
        StringBuilder sbM1629s = AbstractC2322a.m1629s("updateAppWidgetView# appWidgetIds: ", appWidgetId, ", caller : ", caller, SQLKeyword.COMMA);
        sbM1629s.append(noteUuidList);
        WidgetLogger.m5154d(TAG, sbM1629s.toString());
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), getLayoutId(context, appWidgetId));
        if (noteUuidList.isEmpty()) {
            if (Intrinsics.areEqual(WidgetConstant.RECEIVE_CALLER_ON_UPDATE, caller)) {
                companion.saveTrueReverseTransparency(appWidgetId);
            }
            updateEmptyWidgetView(context, remoteViews, appWidgetId);
            return;
        }
        updateRemoteServiceIntent(context, remoteViews, appWidgetId);
        new NoteListThemeManager().applyThemeToWidgetFrame(context, remoteViews, new ThemeInfo(context, appWidgetId));
        companion.saveWidgetOrientationPref(appWidgetId, context.getResources().getConfiguration().orientation);
        boolean zIsSupportSettingByQuickOption = WidgetUtils.INSTANCE.isSupportSettingByQuickOption();
        if (Build.VERSION.SDK_INT < 28) {
            Intent intent = new Intent(context, (Class<?>) WidgetListProvider.class);
            intent.setAction(WidgetConstant.SETTING_MEMO_FROM_WIDGET);
            intent.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, appWidgetId);
            PendingIntent broadcast = PendingIntent.getBroadcast(context, appWidgetId, intent, 134217728);
            remoteViews.setOnClickPendingIntent(C11391R.id.widget_settings, broadcast);
            remoteViews.setOnClickPendingIntent(C11391R.id.widget_overlap_setting, broadcast);
        }
        remoteViews.setViewVisibility(C11391R.id.widget_settings, zIsSupportSettingByQuickOption ? 8 : 0);
        updateAppWidget(appWidgetManager, appWidgetId, remoteViews, caller);
        notifyAppWidgetViewDataChanged(appWidgetManager, appWidgetId, caller);
    }

    private final void updateAppWidgetViewOneUi7x(Context context, GlanceAppWidgetManager glanceManager, int appWidgetId, String caller) {
        if (isNotListWidget(context, appWidgetId)) {
            WidgetLogger.m5156w(TAG, "updateAppWidgetView# fail " + appWidgetId);
            return;
        }
        Bundle appWidgetOptions = AppWidgetManager.getInstance(context).getAppWidgetOptions(appWidgetId);
        if (appWidgetOptions.get("oneUiWidgetSource") != null) {
            BaseWidgetPreferenceManager.INSTANCE.saveOneUiWidgetSource(appWidgetId, String.valueOf(appWidgetOptions.get("oneUiWidgetSource")));
        }
        List<String> noteUuidList = WidgetPreferenceManager.INSTANCE.getNoteUuidList(appWidgetId);
        StringBuilder sbM1629s = AbstractC2322a.m1629s("updateAppWidgetViewOneUi7x# appWidgetIds: ", appWidgetId, ", caller : ", caller, SQLKeyword.COMMA);
        sbM1629s.append(noteUuidList);
        WidgetLogger.m5154d(TAG, sbM1629s.toString());
        if (noteUuidList.isEmpty() && Intrinsics.areEqual(WidgetConstant.RECEIVE_CALLER_ON_UPDATE, caller)) {
            BaseWidgetPreferenceManager.INSTANCE.saveTrueReverseTransparency(appWidgetId);
        }
        BaseWidgetPreferenceManager.INSTANCE.saveWidgetOrientationPref(appWidgetId, context.getResources().getConfiguration().orientation);
        updateWidgetOneUi7x(context, glanceManager, appWidgetId);
    }

    private final List<String> updateDataListUuid(List<String> uuidListBefore, List<String> uuidListPickDone) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (String str : uuidListPickDone) {
            Intrinsics.checkNotNullExpressionValue(str, "next(...)");
            String str2 = str;
            if (uuidListBefore.contains(str2)) {
                arrayList.add(str2);
            } else {
                arrayList2.add(str2);
            }
        }
        arrayList.addAll(0, arrayList2);
        return CollectionsKt.toList(arrayList);
    }

    private final void updateEmptyWidgetView(Context context, int appWidgetId) {
        updateEmptyWidgetView(context, new RemoteViews(context.getPackageName(), getLayoutId(context, appWidgetId)), appWidgetId);
    }

    private final void updateRemoteServiceIntent(Context context, RemoteViews remoteViews, int appWidgetId) {
        Intent intent = new Intent(context, (Class<?>) WidgetListService.class);
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, appWidgetId);
        intent.setData(Uri.parse(intent.toUri(1)));
        remoteViews.setViewVisibility(C11391R.id.widget_list_empty_text, 8);
        remoteViews.setViewVisibility(C11391R.id.widget_list_view, 0);
        remoteViews.setRemoteAdapter(C11391R.id.widget_list_view, intent);
        Intent intent2 = new Intent(context, (Class<?>) WidgetListProvider.class);
        intent2.setAction(WidgetConstant.OPEN_MEMO_LIST_FROM_WIDGET);
        remoteViews.setPendingIntentTemplate(C11391R.id.widget_list_view, PendingIntent.getBroadcast(context, appWidgetId, intent2, 167772160));
    }

    private final void updateUuidListWidget(Context context, ArrayList<String> uuidList) {
        int[] appWidgetIds = AppWidgetManager.getInstance(context).getAppWidgetIds(new ComponentName(context, getClassProvider(getProviderName())));
        int i = 0;
        if (BaseWidgetUtils.INSTANCE.isSupportedNewWidget()) {
            GlanceAppWidgetManager glanceAppWidgetManager = new GlanceAppWidgetManager(context);
            int length = appWidgetIds.length;
            while (i < length) {
                int i2 = appWidgetIds[i];
                List<String> noteUuidList = WidgetPreferenceManager.INSTANCE.getNoteUuidList(i2);
                Intrinsics.checkNotNull(uuidList);
                Iterator<String> it = uuidList.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (true) {
                    if (it.hasNext()) {
                        String next = it.next();
                        Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                        if (noteUuidList.contains(next)) {
                            updateWidgetOneUi7x(context, glanceAppWidgetManager, i2);
                            break;
                        }
                    }
                }
                i++;
            }
            return;
        }
        int length2 = appWidgetIds.length;
        while (i < length2) {
            int i4 = appWidgetIds[i];
            List<String> noteUuidList2 = WidgetPreferenceManager.INSTANCE.getNoteUuidList(i4);
            Intrinsics.checkNotNull(uuidList);
            Iterator<String> it2 = uuidList.iterator();
            Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
            while (true) {
                if (it2.hasNext()) {
                    String next2 = it2.next();
                    Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                    if (noteUuidList2.contains(next2)) {
                        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
                        Intrinsics.checkNotNullExpressionValue(appWidgetManager, "getInstance(...)");
                        notifyAppWidgetViewDataChanged(appWidgetManager, i4, "updateUuidWidget");
                        break;
                    }
                }
            }
            i++;
        }
    }

    private final void updateUuidWidget(Context context, String uuid) {
        int[] appWidgetIds = AppWidgetManager.getInstance(context).getAppWidgetIds(new ComponentName(context, getClassProvider(getProviderName())));
        if (!BaseWidgetUtils.INSTANCE.isSupportedNewWidget()) {
            for (int i : appWidgetIds) {
                if (CollectionsKt.contains(WidgetPreferenceManager.INSTANCE.getNoteUuidList(i), uuid)) {
                    AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
                    Intrinsics.checkNotNullExpressionValue(appWidgetManager, "getInstance(...)");
                    notifyAppWidgetViewDataChanged(appWidgetManager, i, "updateUuidWidget");
                }
            }
            return;
        }
        GlanceAppWidgetManager glanceAppWidgetManager = new GlanceAppWidgetManager(context);
        for (int i2 : appWidgetIds) {
            List<String> noteUuidList = WidgetPreferenceManager.INSTANCE.getNoteUuidList(i2);
            if (CollectionsKt.contains(noteUuidList, uuid)) {
                NotesDocumentRepository notesDocumentRepositoryCreateDocumentDataRepository = NotesDataRepositoryFactory.newInstance(context).createDocumentDataRepository();
                Intrinsics.checkNotNullExpressionValue(notesDocumentRepositoryCreateDocumentDataRepository, "createDocumentDataRepository(...)");
                NotesDocumentEntity notesDocumentEntity = notesDocumentRepositoryCreateDocumentDataRepository.get(uuid == null ? "" : uuid);
                if (notesDocumentEntity != null && notesDocumentEntity.getIsLock() == 5) {
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : noteUuidList) {
                        if (!Intrinsics.areEqual((String) obj, uuid)) {
                            arrayList.add(obj);
                        }
                    }
                    WidgetPreferenceManager widgetPreferenceManager = WidgetPreferenceManager.INSTANCE;
                    widgetPreferenceManager.saveNoteUuidList(i2, arrayList);
                    widgetPreferenceManager.saveNoteUuidListBeforeAdd(i2, arrayList);
                }
                updateWidgetOneUi7x(context, glanceAppWidgetManager, i2);
            }
        }
    }

    private final void updateWidget(Context context, int widgetId, String caller) {
        WidgetLogger.m5155i(TAG, "updateWidget# " + widgetId + " : " + caller);
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        Intrinsics.checkNotNull(appWidgetManager);
        onUpdate(context, appWidgetManager, new int[]{widgetId});
    }

    private final void updateWidgetOneUi7x(Context context, GlanceAppWidgetManager glanceManager, int appWidgetId) {
        updateGlance(context, glanceManager, appWidgetId);
        Logger.m8702i(TAG, "onUpdate# " + appWidgetId + " updateAppWidget");
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

    @Override // androidx.glance.appwidget.GlanceAppWidgetReceiver, android.appwidget.AppWidgetProvider
    public void onAppWidgetOptionsChanged(@NotNull Context context, @NotNull AppWidgetManager appWidgetManager, int appWidgetId, @NotNull Bundle newOptions) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appWidgetManager, "appWidgetManager");
        Intrinsics.checkNotNullParameter(newOptions, "newOptions");
        AppWidgetUtils.INSTANCE.deleteOldWidgetBackupData(appWidgetManager, appWidgetId);
        BaseWidgetUtils.Companion companion = BaseWidgetUtils.INSTANCE;
        if (companion.isSupportedNewWidget()) {
            int i = newOptions.getInt("appWidgetMinWidth");
            int i2 = newOptions.getInt("appWidgetMinHeight");
            int i4 = newOptions.getInt("semAppWidgetRowSpan");
            int i5 = newOptions.getInt("semAppWidgetColumnSpan");
            BaseWidgetPreferenceManager.Companion companion2 = BaseWidgetPreferenceManager.INSTANCE;
            companion2.saveMinWidthHeight(appWidgetId, i, i2);
            companion2.saveRowSpan(appWidgetId, i4);
            companion2.saveColumnSpan(appWidgetId, i5);
            super.onAppWidgetOptionsChanged(context, appWidgetManager, appWidgetId, newOptions);
        }
        WidgetLogger.m5155i(TAG, "onAppWidgetOptionsChanged# appWidgetIds: " + appWidgetId);
        boolean zIsDarkModeChange = companion.isDarkModeChange(context, appWidgetId);
        boolean zIsFoldOrientationChange = companion.isFoldOrientationChange(context, appWidgetId);
        StringBuilder sbM2226q = AbstractC2821a.m2226q("onAppWidgetOptionsChanged# appWidgetIds: ", appWidgetId, ", darkModeChange: ", zIsDarkModeChange, ", foldOrientationChange: ");
        sbM2226q.append(zIsFoldOrientationChange);
        WidgetLogger.m5155i(TAG, sbM2226q.toString());
        if (companion.isSupportedNewWidget()) {
            if (!zIsDarkModeChange) {
                if (zIsFoldOrientationChange) {
                    updateAppWidgetViewOneUi7x(context, new GlanceAppWidgetManager(context), appWidgetId, "dark mode change");
                    return;
                }
                return;
            } else {
                if (ContextUtils.isNightMode(context)) {
                    BaseWidgetPreferenceManager.INSTANCE.saveDarkModePref(appWidgetId, 1);
                } else {
                    BaseWidgetPreferenceManager.INSTANCE.saveDarkModePref(appWidgetId, 0);
                }
                updateAppWidgetViewOneUi7x(context, new GlanceAppWidgetManager(context), appWidgetId, "dark mode change");
                return;
            }
        }
        String noteList = WidgetPreferenceManager.getNoteList(appWidgetId);
        if (noteList == null || noteList.length() == 0) {
            updateWidget(context, appWidgetId, "update widget data null");
        } else if (zIsDarkModeChange) {
            updateAppWidgetView(context, appWidgetManager, appWidgetId, "dark mode change");
        } else if (zIsFoldOrientationChange) {
            updateAppWidgetView(context, appWidgetManager, appWidgetId, "fold orientation change");
        }
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
        WidgetLogger.m5155i(TAG, "onDeleted# " + string);
        WidgetPreferenceManager.INSTANCE.deleteNoteListWidgetPref(Arrays.copyOf(appWidgetIds, appWidgetIds.length));
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onDisabled(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (BaseWidgetUtils.INSTANCE.isSupportedNewWidget()) {
            super.onDisabled(context);
        }
        WidgetLogger.m5154d(TAG, "onDisabled# ");
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onEnabled(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (BaseWidgetUtils.INSTANCE.isSupportedNewWidget()) {
            super.onEnabled(context);
        }
        WidgetLogger.m5154d(TAG, "onEnabled# ");
    }

    public void onNotePickerClickedActionAdd(@NotNull Context context, int widgetId, @Nullable ArrayList<String> uuidList) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (NoteListAccessHandler.getNotePickerClass() == null) {
            PostLaunchManager.INSTANCE.getInstance().executeBaseLogic(1);
        }
        WidgetPreferenceManager widgetPreferenceManager = WidgetPreferenceManager.INSTANCE;
        Intrinsics.checkNotNull(uuidList, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String?>");
        widgetPreferenceManager.saveNoteUuidListBeforeAdd(widgetId, uuidList);
        Intent intent = new Intent(context, NoteListAccessHandler.getNotePickerClass());
        intent.setFlags(403177472);
        intent.putExtra(WidgetConstant.EXTRA_KEY_WIDGET_PICK_MEMO, true);
        intent.putExtra(WidgetConstant.EXTRA_KEY_WIDGET_SETTING_PICK_MEMO, false);
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, widgetId);
        intent.putExtra(WidgetConstant.Pick.TYPE, 1);
        intent.putStringArrayListExtra(WidgetConstant.EXTRA_KEY_NOTE_UUID_LIST, uuidList);
        BaseWidgetPreferenceManager.Companion companion = BaseWidgetPreferenceManager.INSTANCE;
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_WIDGET_TRANSPARENCY, companion.getTransparency(widgetId));
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_WIDGET_BACKGROUND_COLOR, companion.getBackgroundColor(widgetId));
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_WIDGET_DARK_MODE, companion.getDarkMode(widgetId));
        intent.putExtra(BaseWidgetConstant.KEY_WIDGET_MATCH_SETTING, companion.getWidgetMatchSetting(widgetId));
        intent.putExtra(BaseWidgetConstant.KEY_WIDGET_BACKGROUND_SHAPE, companion.getWidgetBackgroundShape(widgetId));
        intent.putExtra(BaseWidgetConstant.KEY_WIDGET_BACKGROUND_ON_OFF, companion.getWidgetBackgroundOnOff(widgetId));
        intent.putExtra(WidgetConstant.EXTRA_KEY_ACTION_ADD_FROM_WIDGET_LIST_GLANCE, true);
        if (!Intrinsics.areEqual(getProviderName(), WidgetListLargeCoverProvider.TAG) && !Intrinsics.areEqual(getProviderName(), WidgetListMediumCoverProvider.TAG) && !Intrinsics.areEqual(getProviderName(), WidgetListExtraLargeCoverProvider.TAG)) {
            intent.setAction(WidgetConstant.ACTION_MEMO_PICK_FROM_NOTE_LIST);
            intent.addFlags(67174400);
            context.startActivity(intent);
        } else {
            intent.putExtra(WidgetConstant.WIDGET_PROVIDER_NAME, getProviderName());
            intent.setAction(WidgetConstant.ACTION_MEMO_PICK_FROM_NOTE_LIST_COVER);
            intent.addFlags(344031232);
            Optional.ofNullable(ProviderUtils.INSTANCE.getDisplayForSubAlert(context)).ifPresent(new C6618c(context, intent, 3));
        }
    }

    @Override // androidx.glance.oneui.template.GlanceTemplateAppWidgetReceiver, androidx.glance.appwidget.GlanceAppWidgetReceiver, android.appwidget.AppWidgetProvider, android.content.BroadcastReceiver
    public void onReceive(@NotNull Context context, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        String action = intent.getAction();
        ComponentName componentName = new ComponentName(context, getClassProvider(getProviderName()));
        WidgetLogger.m5155i(TAG, "onReceive# action : " + action + ", provider: " + getProviderName());
        if (Intrinsics.areEqual(BaseWidgetConstant.ACTION_APPWIDGET_UPDATE, action)) {
            NotesSamsungAnalytics.Companion companion = NotesSamsungAnalytics.INSTANCE;
            BaseWidgetUtils.Companion companion2 = BaseWidgetUtils.INSTANCE;
            companion.insertStatusLog("9979", companion2.getWidgetCount(context, WidgetListProvider.class));
            WidgetLogger.m5154d(TAG, "onReceive# " + getProviderName() + ": " + companion2.getWidgetCount(context, WidgetListProvider.class));
        } else if (Intrinsics.areEqual(WidgetConstant.ACTION_MEMO_UPDATE_UUID, action)) {
            updateUuidWidget(context, intent.getStringExtra(WidgetConstant.EXTRA_KEY_UUID));
        } else if (Intrinsics.areEqual(WidgetConstant.ACTION_MEMO_UPDATE_ALL, action)) {
            updateAllMemo(context);
        } else if (Intrinsics.areEqual(WidgetConstant.ACTION_MEMO_DELETE_UUID, action)) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra(WidgetConstant.EXTRA_KEY_UUID);
            if (BaseWidgetUtils.INSTANCE.isSupportedNewWidget()) {
                deleteUuidWidgetOneUi7x(context, stringArrayListExtra);
            } else {
                deleteUuidWidget(context, stringArrayListExtra);
            }
        } else if (Intrinsics.areEqual(WidgetConstant.PICK_MEMO_LIST_FROM_WIDGET, action)) {
            int intExtra = intent.getIntExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, -1);
            if (!ProviderUtils.INSTANCE.isCurrentProviderWidget(context, componentName, intExtra)) {
                return;
            } else {
                startNotePicker(context, intExtra);
            }
        } else if (Intrinsics.areEqual(WidgetConstant.PICK_MEMO_LIST_FROM_WIDGET_LIST_ACTION_ADD, action)) {
            int intExtra2 = intent.getIntExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, -1);
            if (!ProviderUtils.INSTANCE.isCurrentProviderWidget(context, componentName, intExtra2)) {
                return;
            } else {
                onNotePickerClickedActionAdd(context, intExtra2, intent.getStringArrayListExtra(WidgetConstant.EXTRA_KEY_NOTE_UUID_LIST));
            }
        } else if (Intrinsics.areEqual(WidgetConstant.ACTION_MEMO_PICK_DONE_FROM_NOTE_LIST, action)) {
            if (!ProviderUtils.INSTANCE.isCurrentProviderWidget(context, componentName, intent.getIntExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, -1))) {
                return;
            } else {
                doneNotePicker(context, intent);
            }
        } else if (Intrinsics.areEqual(WidgetConstant.OPEN_MEMO_LIST_FROM_WIDGET, action)) {
            openSelectedNote(context, intent);
        } else if (Intrinsics.areEqual(BaseWidgetConstant.ACTION_WALLPAPER_CHANGED, action)) {
            if (BaseWidgetUtils.INSTANCE.isSupportedNewWidget()) {
                updateAllWidgetOneUi7x(context);
            } else {
                updateAllWidget(context);
            }
        } else if (Intrinsics.areEqual(WidgetConstant.ACTION_MEMO_UPDATE_UUID_FROM_NOTE_LIST, action)) {
            updateUuidListWidget(context, intent.getStringArrayListExtra(WidgetConstant.EXTRA_KEY_NOTE_UUID_LIST));
        } else if (Intrinsics.areEqual(WidgetConstant.SETTING_MEMO_FROM_WIDGET, action)) {
            startWidgetSetting(context, intent);
        }
        if (BaseWidgetUtils.INSTANCE.isSupportedNewWidget()) {
            super.onReceive(context, intent);
        } else {
            onReceiveForBelowOneUi7x(context, intent);
        }
    }

    public final void onReceiveForBelowOneUi7x(@NotNull Context context, @NotNull Intent intent) {
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

    @Override // androidx.glance.appwidget.GlanceAppWidgetReceiver, android.appwidget.AppWidgetProvider
    public void onUpdate(@NotNull Context context, @NotNull AppWidgetManager appWidgetManager, @NotNull int[] appWidgetIds) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appWidgetManager, "appWidgetManager");
        Intrinsics.checkNotNullParameter(appWidgetIds, "appWidgetIds");
        String string = Arrays.toString(appWidgetIds);
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        String str = TAG;
        WidgetLogger.m5155i(TAG, "onUpdate# appWidgetIds: " + string);
        String str2 = ",newWidgetID: ";
        String str3 = "onUpdate# oldWidgetId: ";
        int i = 0;
        if (!BaseWidgetUtils.INSTANCE.isSupportedNewWidget()) {
            String str4 = TAG;
            String str5 = ",newWidgetID: ";
            String str6 = "onUpdate# oldWidgetId: ";
            int length = appWidgetIds.length;
            while (i < length) {
                int i2 = appWidgetIds[i];
                Bundle appWidgetOptions = appWidgetManager.getAppWidgetOptions(i2);
                int i4 = appWidgetOptions.getInt(BaseWidgetConstant.OLD_WIDGET_ID_OPTION);
                int i5 = appWidgetOptions.getInt(BaseWidgetConstant.NEW_WIDGET_ID_OPTION);
                String str7 = str6;
                StringBuilder sb = new StringBuilder(str7);
                sb.append(i4);
                String str8 = str5;
                sb.append(str8);
                sb.append(i5);
                String str9 = str4;
                WidgetLogger.m5154d(str9, sb.toString());
                if (WidgetBRHelper.restoreWidgetInfoWithoutUUID(i4, i5)) {
                    WidgetBRHelper.INSTANCE.restoreNoteListWidgetInfo(i2, i4);
                }
                updateAppWidgetView(context, appWidgetManager, i2, WidgetConstant.RECEIVE_CALLER_ON_UPDATE);
                i++;
                str6 = str7;
                str5 = str8;
                str4 = str9;
            }
            return;
        }
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        GlanceAppWidgetManager glanceAppWidgetManager = new GlanceAppWidgetManager(context);
        int length2 = appWidgetIds.length;
        while (i < length2) {
            int i6 = appWidgetIds[i];
            Bundle appWidgetOptions2 = appWidgetManager.getAppWidgetOptions(i6);
            int i7 = appWidgetOptions2.getInt(BaseWidgetConstant.OLD_WIDGET_ID_OPTION);
            int i8 = i;
            int i9 = appWidgetOptions2.getInt(BaseWidgetConstant.NEW_WIDGET_ID_OPTION);
            int i10 = length2;
            WidgetLogger.m5154d(str, str3 + i7 + str2 + i9);
            int i11 = appWidgetOptions2.getInt("appWidgetMinWidth");
            String str10 = str;
            int i12 = appWidgetOptions2.getInt("appWidgetMinHeight");
            String str11 = str2;
            int i13 = appWidgetOptions2.getInt("semAppWidgetRowSpan");
            String str12 = str3;
            int i14 = appWidgetOptions2.getInt("semAppWidgetColumnSpan");
            BaseWidgetPreferenceManager.Companion companion = BaseWidgetPreferenceManager.INSTANCE;
            companion.saveMinWidthHeight(i6, i11, i12);
            companion.saveRowSpan(i6, i13);
            companion.saveColumnSpan(i6, i14);
            if (WidgetBRHelper.restoreWidgetInfoWithoutUUID(i7, i9)) {
                WidgetBRHelper.INSTANCE.restoreNoteListWidgetInfo(i6, i7);
            }
            WidgetPreferenceManager.INSTANCE.saveWidgetProviderName(i6, getProviderName());
            updateAppWidgetViewOneUi7x(context, glanceAppWidgetManager, i6, WidgetConstant.RECEIVE_CALLER_ON_UPDATE);
            i = i8 + 1;
            length2 = i10;
            str = str10;
            str2 = str11;
            str3 = str12;
        }
    }

    public void openSelectedNote(@NotNull Context context, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        prepareContract();
        if (DocumentAccessHandler.getContract() == null) {
            WidgetLogger.INSTANCE.m5157e(TAG, "openSelectedNote# getContract is null");
            return;
        }
        if (!StorageUtils.isAvailableMemoryForNewMemo()) {
            Intent intent2 = new Intent(context, (Class<?>) StorageErrorDialogActivity.class);
            intent2.setFlags(402653184);
            context.startActivity(intent2);
            return;
        }
        String stringExtra = intent.getStringExtra("sdoc_uuid");
        String stringExtra2 = intent.getStringExtra(ComposerConstants.ARG_MDE_SPACE_ID);
        NotesDocumentRepository notesDocumentRepositoryCreateDocumentDataRepository = NotesDataRepositoryFactory.newInstance(context).createDocumentDataRepository();
        Intrinsics.checkNotNullExpressionValue(notesDocumentRepositoryCreateDocumentDataRepository, "createDocumentDataRepository(...)");
        if (notesDocumentRepositoryCreateDocumentDataRepository.getPath(String.valueOf(stringExtra)) == null) {
            INSTANCE.openMemoList(context);
            return;
        }
        WidgetLogger.m5155i(TAG, "openSelectedNote# uuid : " + stringExtra);
        DocumentAccessHandler.DocumentAccessContract contract = DocumentAccessHandler.getContract();
        Intent intent3 = new Intent(context, contract != null ? contract.getDocOpenTriggerClass() : null);
        if (!TextUtils.isEmpty(stringExtra2)) {
            intent3.putExtra(ComposerConstants.ARG_MDE_SPACE_ID, stringExtra2);
            intent3.putExtra(ComposerConstants.ARG_MDE_GROUP_ID, intent.getStringExtra(ComposerConstants.ARG_MDE_GROUP_ID));
            intent3.putExtra(ComposerConstants.ARG_MDE_OWNER_ID, intent.getStringExtra(ComposerConstants.ARG_MDE_OWNER_ID));
            intent3.putExtra(ComposerConstants.ARG_MDE_WRITER, intent.getStringExtra(ComposerConstants.ARG_MDE_WRITER));
            intent3.putExtra(ComposerConstants.ARG_MDE_ACCOUNT_TYPE, intent.getStringExtra(ComposerConstants.ARG_MDE_ACCOUNT_TYPE));
        }
        intent3.setAction(ComposerConstants.ACTION_OPEN_MEMO);
        intent3.putExtra("sdoc_uuid", stringExtra);
        intent3.setFlags(ComposerConstants.ACTIVITY_FLAG_CALLEE);
        if (!Intrinsics.areEqual(getProviderName(), WidgetListLargeCoverProvider.TAG) && !Intrinsics.areEqual(getProviderName(), WidgetListMediumCoverProvider.TAG) && !Intrinsics.areEqual(getProviderName(), WidgetListExtraLargeCoverProvider.TAG)) {
            context.startActivity(intent3);
            return;
        }
        PendingIntent activity = PendingIntent.getActivity(context, 0, intent3, 201326592);
        Object systemService = context.getSystemService("keyguard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.KeyguardManager");
        Intent intent4 = new Intent();
        intent4.putExtra("showCoverToast", true);
        intent4.putExtra("ignoreKeyguardState", true);
        KeyguardManagerCompat companion = KeyguardManagerCompat.INSTANCE.getInstance();
        Intrinsics.checkNotNull(activity);
        companion.semSetPendingIntentAfterUnlock(context, activity, intent4);
    }

    public void startNotePicker(@NotNull Context context, int widgetId) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (NoteListAccessHandler.getNotePickerClass() == null) {
            PostLaunchManager.INSTANCE.getInstance().executeBaseLogic(1);
        }
        Intent intent = new Intent(context, NoteListAccessHandler.getNotePickerClass());
        intent.setFlags(403177472);
        intent.putExtra(WidgetConstant.EXTRA_KEY_WIDGET_PICK_MEMO, true);
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, widgetId);
        intent.putExtra(WidgetConstant.Pick.TYPE, 1);
        BaseWidgetPreferenceManager.Companion companion = BaseWidgetPreferenceManager.INSTANCE;
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_WIDGET_TRANSPARENCY, companion.getTransparency(widgetId));
        if (BaseWidgetUtils.INSTANCE.isSupportedNewWidget()) {
            intent.putExtra(BaseWidgetConstant.EXTRA_KEY_WIDGET_BACKGROUND_COLOR, companion.getBackgroundColor(widgetId));
            intent.putExtra(BaseWidgetConstant.EXTRA_KEY_WIDGET_DARK_MODE, companion.getDarkMode(widgetId));
            intent.putExtra(BaseWidgetConstant.KEY_WIDGET_MATCH_SETTING, companion.getWidgetMatchSetting(widgetId));
            intent.putExtra(BaseWidgetConstant.KEY_WIDGET_BACKGROUND_SHAPE, companion.getWidgetBackgroundShape(widgetId));
            intent.putExtra(BaseWidgetConstant.KEY_WIDGET_BACKGROUND_ON_OFF, companion.getWidgetBackgroundOnOff(widgetId));
        }
        if (!Intrinsics.areEqual(getProviderName(), WidgetListLargeCoverProvider.TAG) && !Intrinsics.areEqual(getProviderName(), WidgetListMediumCoverProvider.TAG) && !Intrinsics.areEqual(getProviderName(), WidgetListExtraLargeCoverProvider.TAG)) {
            intent.setAction(WidgetConstant.ACTION_MEMO_PICK_FROM_NOTE_LIST);
            intent.addFlags(67174400);
            context.startActivity(intent);
            return;
        }
        intent.putExtra(WidgetConstant.WIDGET_PROVIDER_NAME, getProviderName());
        if (NotesDataRepositoryFactory.newInstance(context).createMainListDocumentDataRepository().getAllNoteCount(0, true) != 0) {
            intent.setAction(WidgetConstant.ACTION_MEMO_PICK_FROM_NOTE_LIST_COVER);
            intent.addFlags(344031232);
            Optional.ofNullable(ProviderUtils.INSTANCE.getDisplayForSubAlert(context)).ifPresent(new C4191n(new C4201a(context, intent, 1), 2));
            return;
        }
        intent.setAction(WidgetConstant.ACTION_MEMO_PICK_FROM_NOTE_LIST);
        PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 201326592);
        Object systemService = context.getSystemService("keyguard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.KeyguardManager");
        Intent intent2 = new Intent();
        intent2.putExtra("showCoverToast", true);
        intent2.putExtra("ignoreKeyguardState", true);
        KeyguardManagerCompat companion2 = KeyguardManagerCompat.INSTANCE.getInstance();
        Intrinsics.checkNotNull(activity);
        companion2.semSetPendingIntentAfterUnlock(context, activity, intent2);
    }

    public void updateGlance(@NotNull Context context, @NotNull GlanceAppWidgetManager glanceManager, int appWidgetId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(glanceManager, "glanceManager");
        long jCurrentTimeMillis = System.currentTimeMillis();
        BaseWidgetPreferenceManager.Companion companion = BaseWidgetPreferenceManager.INSTANCE;
        int transparency = companion.getTransparency(appWidgetId);
        int backgroundColor = companion.getBackgroundColor(appWidgetId);
        int darkMode = companion.getDarkMode(appWidgetId);
        boolean widgetMatchSetting = companion.getWidgetMatchSetting(appWidgetId);
        String noteList = WidgetPreferenceManager.getNoteList(appWidgetId);
        if (noteList == null) {
            noteList = "";
        }
        String str = noteList;
        int widgetBackgroundShape = companion.getWidgetBackgroundShape(appWidgetId);
        boolean widgetBackgroundOnOff = companion.getWidgetBackgroundOnOff(appWidgetId);
        StringBuilder sb = new StringBuilder("onUpdate: timeUpdate: ");
        sb.append(jCurrentTimeMillis);
        sb.append(", transparency: ");
        sb.append(transparency);
        AbstractC0622a.m1180z(sb, backgroundColor, darkMode, ", backgroundColor: ", ", darkMode: ");
        sb.append(", matchSetting: ");
        sb.append(widgetMatchSetting);
        sb.append(", backgroundShape: ");
        sb.append(widgetBackgroundShape);
        sb.append(", selectedItems: ");
        sb.append(str);
        sb.append(", backgroundOnOff: ");
        sb.append(widgetBackgroundOnOff);
        Logger.m8702i(TAG, sb.toString());
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C69091(context, glanceManager.getGlanceIdBy(appWidgetId), this, transparency, backgroundColor, darkMode, widgetMatchSetting, str, jCurrentTimeMillis, widgetBackgroundShape, widgetBackgroundOnOff, null), 3, null);
    }

    private final void updateEmptyWidgetView(Context context, RemoteViews remoteViews, int appWidgetId) {
        remoteViews.setViewVisibility(C11391R.id.widget_list_empty_text, 0);
        remoteViews.setViewVisibility(C11391R.id.widget_list_view, 8);
        Intent intent = new Intent(context, (Class<?>) WidgetListProvider.class);
        intent.setAction(WidgetConstant.PICK_MEMO_LIST_FROM_WIDGET);
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, appWidgetId);
        remoteViews.setOnClickPendingIntent(C11391R.id.widget_list_empty_text, PendingIntent.getBroadcast(context, appWidgetId, intent, 201326592));
        ThemeInfo themeInfo = new ThemeInfo(context, appWidgetId);
        int emptyTransparency = WidgetPreferenceManager.INSTANCE.getEmptyTransparency(appWidgetId);
        if (emptyTransparency >= 0) {
            BaseWidgetPreferenceManager.INSTANCE.saveTransparency(appWidgetId, emptyTransparency);
        } else {
            themeInfo.setMTransparency(WidgetUtils.INSTANCE.getEmptyWidgetAlpha());
        }
        boolean zIsSupportSettingByQuickOption = WidgetUtils.INSTANCE.isSupportSettingByQuickOption();
        if (Build.VERSION.SDK_INT < 28) {
            Intent intent2 = new Intent(context, (Class<?>) WidgetListProvider.class);
            intent2.setAction(WidgetConstant.SETTING_MEMO_FROM_WIDGET);
            intent2.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, appWidgetId);
            PendingIntent broadcast = PendingIntent.getBroadcast(context, appWidgetId, intent2, 134217728);
            remoteViews.setOnClickPendingIntent(C11391R.id.widget_settings, broadcast);
            remoteViews.setOnClickPendingIntent(C11391R.id.widget_overlap_setting, broadcast);
        }
        remoteViews.setViewVisibility(C11391R.id.widget_settings, zIsSupportSettingByQuickOption ? 8 : 0);
        new NoteListThemeManager().applyThemeToEmptyWidget(context, remoteViews, themeInfo);
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        Intrinsics.checkNotNullExpressionValue(appWidgetManager, "getInstance(...)");
        updateAppWidget(appWidgetManager, appWidgetId, remoteViews, "updateEmptyWidget");
    }
}
