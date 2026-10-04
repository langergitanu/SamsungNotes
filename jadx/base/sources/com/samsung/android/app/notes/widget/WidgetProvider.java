package com.samsung.android.app.notes.widget;

import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import android.view.Display;
import android.widget.RemoteViews;
import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
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
import com.samsung.android.app.notes.widget.capture.CacheFileManager;
import com.samsung.android.app.notes.widget.common.ConvertConfirmDialogActivity;
import com.samsung.android.app.notes.widget.common.constants.WidgetConstant;
import com.samsung.android.app.notes.widget.common.log.WidgetLogger;
import com.samsung.android.app.notes.widget.cover.WidgetSingleExtraLargeCoverProvider;
import com.samsung.android.app.notes.widget.cover.WidgetSingleLargeCoverProvider;
import com.samsung.android.app.notes.widget.cover.WidgetSingleMediumCoverProvider;
import com.samsung.android.app.notes.widget.dialog.StorageErrorDialogActivity;
import com.samsung.android.app.notes.widget.glance.single.WidgetSingleGlance;
import com.samsung.android.app.notes.widget.lockbrief.single.WidgetSingleLockBriefProvider;
import com.samsung.android.app.notes.widget.preference.WidgetPreferenceManager;
import com.samsung.android.app.notes.widget.setting.WidgetPinSettingsActivity;
import com.samsung.android.app.notes.widget.theme.ShowNoteThemeManager;
import com.samsung.android.app.notes.widget.theme.ThemeInfo;
import com.samsung.android.app.notes.widget.util.ProviderUtils;
import com.samsung.android.app.notes.widget.util.WidgetBRHelper;
import com.samsung.android.app.notes.widget.util.WidgetUtils;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p145cm.base.framework.app.KeyguardManagerCompat;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.base.common.access.composer.ComposerAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.access.notelist.NoteListAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.access.widgetaccess.WidgetAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.NotesSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.sdk.util.SpenComposerSdkInitializer;
import com.samsung.android.support.senl.p148nt.base.common.sdk.util.SpenSdkInitializer;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.HomeScreenUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.StorageUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.widget.preference.BaseWidgetPreferenceManager;
import com.samsung.android.support.senl.p148nt.base.widget.util.BaseWidgetUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mde.MdeInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesDocumentRepository;
import com.samsung.android.support.senl.p148nt.homewidget.C11391R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
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
import p044K.C0158a;
import p259y0.AbstractC14517a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0017\u0018\u0000 q2\u00020\u0001:\u0001qB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ \u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J \u0010\u001b\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J*\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u0011H\u0016J \u0010\"\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J(\u0010#\u001a\u00020$2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010&\u001a\u00020\u0011H\u0002J\"\u0010'\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010%\u001a\u00020\u0011H\u0002J*\u0010*\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 2\b\u0010+\u001a\u0004\u0018\u00010$2\u0006\u0010,\u001a\u00020 H\u0002J2\u0010*\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 2\b\u0010%\u001a\u0004\u0018\u00010\u00112\u0006\u0010,\u001a\u00020 2\u0006\u0010&\u001a\u00020\u0011H\u0002J0\u0010*\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010,\u001a\u00020 2\u0006\u0010+\u001a\u00020$2\u0006\u0010&\u001a\u00020\u0011H\u0002J\u0018\u0010-\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010.\u001a\u00020/H\u0016J\u0018\u00100\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010.\u001a\u00020/H\u0002J\"\u00101\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010%\u001a\u00020\u0011H\u0002J2\u00102\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010(\u001a\u0004\u0018\u00010)2\u000e\u00103\u001a\n\u0012\u0004\u0012\u00020 \u0018\u0001042\u0006\u0010,\u001a\u00020 H\u0002J*\u00105\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010(\u001a\u0004\u0018\u00010)2\u000e\u00103\u001a\n\u0012\u0004\u0012\u00020 \u0018\u000104H\u0002J,\u00106\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u00107\u001a\u00020 2\b\u0010%\u001a\u0004\u0018\u00010\u0011H\u0002J,\u00108\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010%\u001a\u0004\u0018\u00010\u00112\u0006\u00109\u001a\u00020 H\u0002J6\u0010:\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010(\u001a\u0004\u0018\u00010)2\u001a\u0010;\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00110<j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0011`=H\u0002J\u001a\u0010>\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\u001a\u0010?\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J(\u0010@\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010A\u001a\u00020\u00182\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020 H\u0002J \u0010E\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010.\u001a\u00020/2\u0006\u0010F\u001a\u00020\u000bH\u0016J*\u0010G\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 2\b\u0010+\u001a\u0004\u0018\u00010$2\u0006\u0010&\u001a\u00020\u0011H\u0002J(\u0010H\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010.\u001a\u00020/2\u0006\u0010F\u001a\u00020\u000b2\u0006\u0010I\u001a\u00020JH\u0016J\u0018\u0010K\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010.\u001a\u00020/H\u0002J \u0010L\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010.\u001a\u00020/2\u0006\u0010F\u001a\u00020\u000bH\u0002J,\u0010M\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010%\u001a\u00020\u00112\b\u0010N\u001a\u0004\u0018\u00010\u0011H\u0002J\u0018\u0010O\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J \u0010P\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010Q\u001a\u00020\u001a2\u0006\u0010R\u001a\u00020\u001aH\u0016J\u0012\u0010S\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J(\u0010T\u001a\u00020$2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u0011H\u0002J0\u0010T\u001a\u00020$2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010%\u001a\u00020\u00112\u0006\u0010U\u001a\u00020J2\u0006\u0010&\u001a\u00020\u0011H\u0002J<\u0010T\u001a\u00020$2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 2\b\u0010%\u001a\u0004\u0018\u00010\u00112\b\u0010V\u001a\u0004\u0018\u00010\u00112\u0006\u0010U\u001a\u00020J2\u0006\u0010&\u001a\u00020\u0011H\u0002J:\u0010W\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 2\b\u0010%\u001a\u0004\u0018\u00010\u00112\u0006\u0010V\u001a\u00020\u00112\u0006\u0010+\u001a\u00020$2\u0006\u0010X\u001a\u00020\u0011H\u0002J \u0010Y\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010+\u001a\u00020$H\u0002J \u0010Z\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010+\u001a\u00020$2\u0006\u0010X\u001a\u00020\u0011H\u0002J(\u0010[\u001a\u00020\t2\u0006\u0010+\u001a\u00020$2\u0006\u0010X\u001a\u00020\u00112\u0006\u0010\\\u001a\u00020J2\u0006\u0010]\u001a\u00020JH\u0002J \u0010^\u001a\u00020$2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010&\u001a\u00020\u0011H\u0002J\u0018\u0010_\u001a\u00020$2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 H\u0002J*\u0010`\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010U\u001a\u00020JH\u0002J(\u0010a\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010b\u001a\u00020cH\u0016J \u0010d\u001a\u00020J2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020 H\u0002J$\u0010e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 2\b\u0010%\u001a\u0004\u0018\u00010\u00112\b\u0010f\u001a\u0004\u0018\u00010gH\u0002JJ\u0010h\u001a\u00020J2\b\u0010%\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010i\u001a\u00020 2\u0006\u0010j\u001a\u00020 2\u0006\u0010k\u001a\u00020 2\u0006\u0010l\u001a\u00020J2\u0006\u0010m\u001a\u00020 2\u0006\u0010n\u001a\u00020JH\u0002J\u0018\u0010o\u001a\u00020 2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u00107\u001a\u00020 H\u0002J\u0014\u0010p\u001a\u0006\u0012\u0002\b\u00030\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\f\u001a\u0006\u0012\u0002\b\u00030\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0011X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006r"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/WidgetProvider;", "Landroidx/glance/oneui/template/GlanceTemplateAppWidgetReceiver;", "<init>", "()V", "glanceAppWidget", "Landroidx/glance/appwidget/GlanceAppWidget;", "getGlanceAppWidget", "()Landroidx/glance/appwidget/GlanceAppWidget;", "setPreviousEventTime", "", "time", "", "this", "Ljava/lang/Class;", "getThis", "()Ljava/lang/Class;", "providerName", "", "getProviderName", "()Ljava/lang/String;", "onUpdate", "context", "Landroid/content/Context;", "appWidgetManager", "Landroid/appwidget/AppWidgetManager;", "appWidgetIds", "", "onUpdateForOneUi7x", "updateGlance", "glanceManager", "Landroidx/glance/appwidget/GlanceAppWidgetManager;", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "", "typeWidgetView", "onUpdateForBelowOneUi7x", "updateNoFilePathWidget", "Landroid/widget/RemoteViews;", "uuid", NotesConstants.KEY_CALLER, "deleteWidget", "provider", "Landroid/content/ComponentName;", "updateAppWidgetAndNotify", "remoteViews", "listId", "onReceive", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "onReceiveForBelowOneUi7x", "updateWidgetByUUID", "updateWidgetByCache", "widgetIds", "", "updateWidgetByCacheOneUi7x", "updateWidgetCacheDoneOneUi7", "widgetId", "updateWidgetCacheDone", "view", "deleteWidgetByUUIDList", "uuidList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "updateAllWidget", "updateAllWidgetForWallpaperChanged", "updateWidgetForWallpaperChanged", "manager", BaseWidgetConstant.WIDGET_PREFERENCES, "Landroid/content/SharedPreferences;", "wId", "openMemoListFromWidget", "previousEventTime", "updateAppWidgetRemoteView", "pickMemoListFromWidget", "checkWidgetCount", "", "startWidgetSetting", "convertFromWidget", "updateWidgetByConvertUUID", "newUuid", "onDeleted", "onRestored", "oldWidgetIds", "newWidgetIds", "onDisabled", "makeWidgetListView", "isSaveSkip", "noteFilePath", "setListAdapter", "title", "setClickPendingIntent", "setWidgetTitle", "setOptionIcon", "isRecording", "notSupportQuickSetting", "makeEmptyWidgetView", "makeConvertWidgetView", "updateNormalWidgetViewOneUi7x", "onAppWidgetOptionsChanged", "newOptions", "Landroid/os/Bundle;", "isDeleteNote", "updateBackgroundOnOff", "entity", "Lcom/samsung/android/support/senl/nt/data/database/core/document/entity/NotesDocumentEntity;", "isUpdatePickNote", "transparency", "backgroundColor", "darkMode", "matchSetting", "backgroundShape", "backgroundOnOff", "getLayoutId", "getClassProvider", "Companion", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class WidgetProvider extends GlanceTemplateAppWidgetReceiver {

    @NotNull
    public static final String CLICKED_TYPE = "type";
    public static final int CONTENT = 1;
    public static final long SKIP_TIME = 1000;

    @NotNull
    private static final String TAG = "WidgetProvider";
    public static final int TITLE = 0;
    private static long mPreviousEventTime;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @NotNull
    private static final Preferences.Key<Long> requestTimeKey = PreferencesKeys.longKey("requestTimeKey");

    @NotNull
    private static final Preferences.Key<String> typeWidgetViewKey = PreferencesKeys.stringKey("typeWidgetView");

    @NotNull
    private static final Preferences.Key<String> providerNameKey = PreferencesKeys.stringKey("providerNameKey");

    @NotNull
    private static final Preferences.Key<Integer> transparencyKey = PreferencesKeys.intKey("transparencyKey");

    @NotNull
    private static final Preferences.Key<Integer> backgroundColorKey = PreferencesKeys.intKey("backgroundColorKey");

    @NotNull
    private static final Preferences.Key<Integer> darkModeKey = PreferencesKeys.intKey("darkModeKey");

    @NotNull
    private static final Preferences.Key<Boolean> matchSettingKey = PreferencesKeys.booleanKey("matchSettingKey");

    @NotNull
    private static final Preferences.Key<String> uuidKey = PreferencesKeys.stringKey("uuidKey");

    @NotNull
    private static final Preferences.Key<String> filePathKey = PreferencesKeys.stringKey("filePathKey");

    @NotNull
    private static final Preferences.Key<Integer> backgroundShapeKey = PreferencesKeys.intKey("backgroundShapeKey");

    @NotNull
    private static final Preferences.Key<Boolean> backgroundOnOffKey = PreferencesKeys.booleanKey("backgroundOnOffKey");

    @NotNull
    private final GlanceAppWidget glanceAppWidget = new WidgetSingleGlance();

    @NotNull
    private final Class<?> this = WidgetProvider.class;

    @NotNull
    private final String providerName = "WidgetProvider";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0011¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0013R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0013R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0013R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0011¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0013R\u0017\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0011¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0013¨\u0006)"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/WidgetProvider$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mPreviousEventTime", "", "SKIP_TIME", "CLICKED_TYPE", SearchConstants.TargetContents.TITLE, "", "CONTENT", "setEventTime", "", "time", "requestTimeKey", "Landroidx/datastore/preferences/core/Preferences$Key;", "getRequestTimeKey", "()Landroidx/datastore/preferences/core/Preferences$Key;", "typeWidgetViewKey", "getTypeWidgetViewKey", "providerNameKey", "getProviderNameKey", "transparencyKey", "getTransparencyKey", "backgroundColorKey", "getBackgroundColorKey", "darkModeKey", "getDarkModeKey", "matchSettingKey", "", "getMatchSettingKey", "uuidKey", "getUuidKey", "filePathKey", "getFilePathKey", "backgroundShapeKey", "getBackgroundShapeKey", "backgroundOnOffKey", "getBackgroundOnOffKey", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void setEventTime(long time) {
            WidgetProvider.mPreviousEventTime = time;
        }

        @NotNull
        public final Preferences.Key<Integer> getBackgroundColorKey() {
            return WidgetProvider.backgroundColorKey;
        }

        @NotNull
        public final Preferences.Key<Boolean> getBackgroundOnOffKey() {
            return WidgetProvider.backgroundOnOffKey;
        }

        @NotNull
        public final Preferences.Key<Integer> getBackgroundShapeKey() {
            return WidgetProvider.backgroundShapeKey;
        }

        @NotNull
        public final Preferences.Key<Integer> getDarkModeKey() {
            return WidgetProvider.darkModeKey;
        }

        @NotNull
        public final Preferences.Key<String> getFilePathKey() {
            return WidgetProvider.filePathKey;
        }

        @NotNull
        public final Preferences.Key<Boolean> getMatchSettingKey() {
            return WidgetProvider.matchSettingKey;
        }

        @NotNull
        public final Preferences.Key<String> getProviderNameKey() {
            return WidgetProvider.providerNameKey;
        }

        @NotNull
        public final Preferences.Key<Long> getRequestTimeKey() {
            return WidgetProvider.requestTimeKey;
        }

        @NotNull
        public final Preferences.Key<Integer> getTransparencyKey() {
            return WidgetProvider.transparencyKey;
        }

        @NotNull
        public final Preferences.Key<String> getTypeWidgetViewKey() {
            return WidgetProvider.typeWidgetViewKey;
        }

        @NotNull
        public final Preferences.Key<String> getUuidKey() {
            return WidgetProvider.uuidKey;
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.app.notes.widget.WidgetProvider$updateGlance$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.samsung.android.app.notes.widget.WidgetProvider$updateGlance$1", m14021f = "WidgetProvider.kt", m14022i = {}, m14023l = {148, 161}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C69101 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $backgroundColor;
        final /* synthetic */ boolean $backgroundOnOff;
        final /* synthetic */ int $backgroundShape;
        final /* synthetic */ Context $context;
        final /* synthetic */ int $darkMode;
        final /* synthetic */ String $filePath;
        final /* synthetic */ GlanceId $glanceId;
        final /* synthetic */ boolean $matchSetting;
        final /* synthetic */ long $requestTime;
        final /* synthetic */ int $transparency;
        final /* synthetic */ String $typeWidgetView;
        final /* synthetic */ String $uuid;
        int label;
        final /* synthetic */ WidgetProvider this$0;

        /* JADX INFO: renamed from: com.samsung.android.app.notes.widget.WidgetProvider$updateGlance$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, m13886d2 = {"<anonymous>", "", "state", "Landroidx/datastore/preferences/core/MutablePreferences;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
        @DebugMetadata(m14020c = "com.samsung.android.app.notes.widget.WidgetProvider$updateGlance$1$1", m14021f = "WidgetProvider.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
            final /* synthetic */ int $backgroundColor;
            final /* synthetic */ boolean $backgroundOnOff;
            final /* synthetic */ int $backgroundShape;
            final /* synthetic */ int $darkMode;
            final /* synthetic */ String $filePath;
            final /* synthetic */ boolean $matchSetting;
            final /* synthetic */ long $requestTime;
            final /* synthetic */ int $transparency;
            final /* synthetic */ String $typeWidgetView;
            final /* synthetic */ String $uuid;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ WidgetProvider this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(long j, String str, WidgetProvider widgetProvider, int i, int i2, int i4, boolean z, boolean z2, int i5, String str2, String str3, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$requestTime = j;
                this.$typeWidgetView = str;
                this.this$0 = widgetProvider;
                this.$transparency = i;
                this.$backgroundColor = i2;
                this.$darkMode = i4;
                this.$matchSetting = z;
                this.$backgroundOnOff = z2;
                this.$backgroundShape = i5;
                this.$filePath = str2;
                this.$uuid = str3;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$requestTime, this.$typeWidgetView, this.this$0, this.$transparency, this.$backgroundColor, this.$darkMode, this.$matchSetting, this.$backgroundOnOff, this.$backgroundShape, this.$filePath, this.$uuid, continuation);
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
                Companion companion = WidgetProvider.INSTANCE;
                mutablePreferences.set(companion.getRequestTimeKey(), Boxing.boxLong(this.$requestTime));
                mutablePreferences.set(companion.getTypeWidgetViewKey(), this.$typeWidgetView);
                mutablePreferences.set(companion.getProviderNameKey(), this.this$0.getProviderName());
                mutablePreferences.set(companion.getTransparencyKey(), Boxing.boxInt(this.$transparency));
                mutablePreferences.set(companion.getBackgroundColorKey(), Boxing.boxInt(this.$backgroundColor));
                mutablePreferences.set(companion.getDarkModeKey(), Boxing.boxInt(this.$darkMode));
                mutablePreferences.set(companion.getMatchSettingKey(), Boxing.boxBoolean(this.$matchSetting));
                mutablePreferences.set(companion.getBackgroundOnOffKey(), Boxing.boxBoolean(this.$backgroundOnOff));
                mutablePreferences.set(companion.getBackgroundShapeKey(), Boxing.boxInt(this.$backgroundShape));
                mutablePreferences.set(companion.getFilePathKey(), this.$filePath);
                mutablePreferences.set(companion.getUuidKey(), this.$uuid);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C69101(Context context, GlanceId glanceId, WidgetProvider widgetProvider, long j, String str, int i, int i2, int i4, boolean z, boolean z2, int i5, String str2, String str3, Continuation<? super C69101> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$glanceId = glanceId;
            this.this$0 = widgetProvider;
            this.$requestTime = j;
            this.$typeWidgetView = str;
            this.$transparency = i;
            this.$backgroundColor = i2;
            this.$darkMode = i4;
            this.$matchSetting = z;
            this.$backgroundOnOff = z2;
            this.$backgroundShape = i5;
            this.$filePath = str2;
            this.$uuid = str3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C69101(this.$context, this.$glanceId, this.this$0, this.$requestTime, this.$typeWidgetView, this.$transparency, this.$backgroundColor, this.$darkMode, this.$matchSetting, this.$backgroundOnOff, this.$backgroundShape, this.$filePath, this.$uuid, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0065, code lost:
        
            if (r2.update(r3, r4, r20) == r1) goto L15;
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
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$requestTime, this.$typeWidgetView, this.this$0, this.$transparency, this.$backgroundColor, this.$darkMode, this.$matchSetting, this.$backgroundOnOff, this.$backgroundShape, this.$filePath, this.$uuid, null);
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
            return ((C69101) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    private final void convertFromWidget(Context context, Intent intent, long previousEventTime) {
        WidgetLogger.m5154d("WidgetProvider", "convertFromWidget#");
        long jCurrentTimeMillis = System.currentTimeMillis();
        ProviderUtils providerUtils = ProviderUtils.INSTANCE;
        if (providerUtils.checkEventTime(jCurrentTimeMillis, previousEventTime, 1000L)) {
            int intExtra = intent.getIntExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, -1);
            String uuid = BaseWidgetPreferenceManager.INSTANCE.getUUID(intExtra);
            NotesDocumentRepository notesDocumentRepositoryCreateDocumentDataRepository = NotesDataRepositoryFactory.newInstance(context).createDocumentDataRepository();
            Intrinsics.checkNotNullExpressionValue(notesDocumentRepositoryCreateDocumentDataRepository, "createDocumentDataRepository(...)");
            String path = notesDocumentRepositoryCreateDocumentDataRepository.getPath(uuid);
            WidgetLogger widgetLogger = WidgetLogger.INSTANCE;
            String encode = widgetLogger.getEncode(uuid);
            if (path != null) {
                String encode2 = widgetLogger.getEncode(path);
                StringBuilder sbM1629s = AbstractC2322a.m1629s("convertFromWidget# widgetId : ", intExtra, " uuid : ", encode, " path :");
                sbM1629s.append(encode2);
                WidgetLogger.m5154d("WidgetProvider", sbM1629s.toString());
                Intent intent2 = new Intent(context, (Class<?>) ConvertConfirmDialogActivity.class);
                intent2.setAction(WidgetConstant.ACTION_MEMO_CONVERT);
                intent2.putExtra("sdoc_uuid", uuid);
                intent2.putExtra("doc_path", path);
                intent2.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, intExtra);
                intent2.setFlags(402653184);
                context.startActivity(intent2);
            } else {
                WidgetLogger.m5154d("WidgetProvider", "convertFromWidget# widgetId : " + intExtra + "uuid : " + encode);
                providerUtils.openMemoList(context);
            }
            setPreviousEventTime(jCurrentTimeMillis + 1000);
        }
    }

    private final void deleteWidget(Context context, ComponentName provider, String uuid) {
        WidgetLogger.m5154d("WidgetProvider", "deleteWidget#");
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        for (int i : appWidgetManager.getAppWidgetIds(provider)) {
            if (Intrinsics.areEqual(uuid, BaseWidgetPreferenceManager.INSTANCE.getUUID(i))) {
                WidgetPreferenceManager.deleteWidgetPref(i, false);
                Intrinsics.checkNotNull(appWidgetManager);
                onUpdate(context, appWidgetManager, new int[]{i});
                return;
            }
        }
    }

    private final void deleteWidgetByUUIDList(Context context, ComponentName provider, ArrayList<String> uuidList) {
        WidgetLogger.m5154d("WidgetProvider", "deleteWidgetByUUIDList#");
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        for (int i : appWidgetManager.getAppWidgetIds(provider)) {
            if (uuidList.contains(BaseWidgetPreferenceManager.INSTANCE.getUUID(i))) {
                WidgetPreferenceManager.deleteWidgetPref(i, false);
                Intrinsics.checkNotNull(appWidgetManager);
                onUpdate(context, appWidgetManager, new int[]{i});
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final Class<?> getClassProvider(String providerName) {
        switch (providerName.hashCode()) {
            case -1810065740:
                return !providerName.equals(BaseWidgetConstant.WIDGET_SINGLE_LOCK_BRIEF_PROVIDER_NAME) ? WidgetProvider.class : WidgetSingleLockBriefProvider.class;
            case 55058489:
                return !providerName.equals("WidgetSingleLargeCoverProvider") ? WidgetProvider.class : WidgetSingleLargeCoverProvider.class;
            case 190750183:
                return !providerName.equals(BaseWidgetConstant.WIDGET_SINGLE_MEDIUM_COVER_PROVIDER_NAME) ? WidgetProvider.class : WidgetSingleMediumCoverProvider.class;
            case 1341081105:
                return !providerName.equals("WidgetSingleExtraLargeCoverProvider") ? WidgetProvider.class : WidgetSingleExtraLargeCoverProvider.class;
            default:
                return WidgetProvider.class;
        }
    }

    private final int getLayoutId(Context context, int widgetId) {
        return BaseWidgetUtils.INSTANCE.getWidgetLayoutId(context, widgetId, C11391R.layout.widget_init_phone_portrait_layout, C11391R.layout.widget_init_phone_layout, C11391R.layout.widget_init);
    }

    private final boolean isDeleteNote(Context context, String uuid, int appWidgetId) {
        MainListDocumentData mainListDocumentData = NotesDataRepositoryFactory.newInstance(context).createMainListDocumentDataRepository().get(uuid);
        WidgetLogger.m5156w("WidgetProvider", "isDeleteNote# removeAppWidget - " + appWidgetId + ", entity: " + mainListDocumentData + ", uuid: " + uuid);
        if (mainListDocumentData == null || mainListDocumentData.getIsDeleted() == 0) {
            return false;
        }
        WidgetLogger.m5156w("WidgetProvider", "isDeleteNote# removeAppWidget - " + appWidgetId);
        CacheFileManager.INSTANCE.getInstance().removeCacheInfo(context, uuid);
        deleteWidget(context, new ComponentName(context, getClassProvider(getProviderName())), uuid);
        return true;
    }

    private final boolean isUpdatePickNote(String uuid, int appWidgetId, int transparency, int backgroundColor, int darkMode, boolean matchSetting, int backgroundShape, boolean backgroundOnOff) {
        BaseWidgetPreferenceManager.Companion companion = BaseWidgetPreferenceManager.INSTANCE;
        return (Intrinsics.areEqual(uuid, companion.getUUID(appWidgetId)) && transparency == companion.getTransparency(appWidgetId) && backgroundColor == companion.getBackgroundColor(appWidgetId) && darkMode == companion.getDarkMode(appWidgetId) && matchSetting == companion.getWidgetMatchSetting(appWidgetId) && backgroundShape == companion.getWidgetBackgroundShape(appWidgetId) && backgroundOnOff == companion.getWidgetBackgroundOnOff(appWidgetId)) ? false : true;
    }

    private final RemoteViews makeConvertWidgetView(Context context, int appWidgetId) {
        WidgetLogger.m5155i("WidgetProvider", "makeConvertWidgetView#");
        Intent intent = new Intent(context, getThis());
        intent.setAction(WidgetConstant.ACTION_MEMO_CONVERT);
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, appWidgetId);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, appWidgetId, intent, 201326592);
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), C11391R.layout.widget_empty_view);
        remoteViews.setInt(C11391R.id.background, BaseWidgetConstant.SET_IMAGE_RESOURCE, C11391R.drawable.widget_background_white);
        remoteViews.setInt(C11391R.id.background, BaseWidgetConstant.SET_IMAGE_ALPHA, BaseWidgetUtils.INSTANCE.convertAlpha(WidgetUtils.INSTANCE.getEmptyWidgetAlpha()));
        remoteViews.setTextViewText(C11391R.id.widget_no_memo_text, context.getResources().getString(C11391R.string.widget_convert_document));
        remoteViews.setContentDescription(C11391R.id.widget_no_memo_text, context.getResources().getString(C11391R.string.widget_convert_document) + "," + context.getResources().getString(C11391R.string.memolist_category_content_description_button));
        remoteViews.setOnClickPendingIntent(C11391R.id.widget_init_layout, broadcast);
        return remoteViews;
    }

    private final RemoteViews makeEmptyWidgetView(Context context, int appWidgetId, String caller) {
        WidgetLogger.m5155i("WidgetProvider", "makeEmptyWidgetView# " + appWidgetId + ", caller : " + caller);
        if (Intrinsics.areEqual(WidgetConstant.RECEIVE_CALLER_ON_UPDATE, caller)) {
            BaseWidgetPreferenceManager.INSTANCE.saveTrueReverseTransparency(appWidgetId);
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(BaseWidgetConstant.WIDGET_PREFERENCES, 0);
        String string = sharedPreferences.getString(BaseWidgetConstant.WIDGET_ID + appWidgetId, "");
        if (string != null && string.length() == 0) {
            if (!ProviderUtils.INSTANCE.isAvailableToReferWidget(context, getThis(), appWidgetId)) {
                WidgetUtils.Companion.showWidgetMaximumToast$default(WidgetUtils.INSTANCE, context, 0, 2, null);
            }
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString(BaseWidgetConstant.WIDGET_ID + appWidgetId, BaseWidgetConstant.NONE);
            editorEdit.apply();
        }
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), C11391R.layout.widget_empty_view);
        ThemeInfo themeInfo = new ThemeInfo(context, appWidgetId);
        int emptyTransparency = WidgetPreferenceManager.INSTANCE.getEmptyTransparency(appWidgetId);
        if (emptyTransparency >= 0) {
            BaseWidgetPreferenceManager.INSTANCE.saveTransparency(appWidgetId, emptyTransparency);
        } else {
            themeInfo.setMTransparency(WidgetUtils.INSTANCE.getEmptyWidgetAlpha());
        }
        new ShowNoteThemeManager().applyThemeToEmptyWidget(context, remoteViews, themeInfo);
        Intent intent = new Intent(context, getThis());
        intent.setAction(WidgetConstant.PICK_MEMO_LIST_FROM_WIDGET);
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, appWidgetId);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, appWidgetId, intent, 201326592);
        remoteViews.setContentDescription(C11391R.id.widget_no_memo_text, context.getResources().getString(C11391R.string.tap_here_to_add_a_note) + "," + context.getResources().getString(C11391R.string.memolist_category_content_description_button));
        remoteViews.setOnClickPendingIntent(C11391R.id.widget_init_layout, broadcast);
        return remoteViews;
    }

    private final RemoteViews makeWidgetListView(Context context, int appWidgetId, String uuid, String caller) {
        return makeWidgetListView(context, appWidgetId, uuid, false, caller);
    }

    private final void onReceiveForBelowOneUi7x(Context context, Intent intent) {
        Bundle extras;
        int[] intArray;
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
        if (intArray2 != null) {
            if (intArray2.length == 0) {
                return;
            }
            Intrinsics.checkNotNull(intArray3);
            onRestored(context, intArray2, intArray3);
            AppWidgetManager appWidgetManager3 = AppWidgetManager.getInstance(context);
            Intrinsics.checkNotNullExpressionValue(appWidgetManager3, "getInstance(...)");
            onUpdate(context, appWidgetManager3, intArray3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void onUpdateForBelowOneUi7x(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        int i;
        int i2;
        Context context2;
        RemoteViews remoteViewsMakeEmptyWidgetView;
        RemoteViews remoteViewsUpdateNoFilePathWidget;
        Class<?> cls = getThis();
        Intrinsics.checkNotNull(cls);
        ComponentName componentName = new ComponentName(context, cls);
        int length = appWidgetIds.length;
        int i4 = 0;
        while (i4 < length) {
            int i5 = appWidgetIds[i4];
            Bundle appWidgetOptions = AppWidgetManager.getInstance(context).getAppWidgetOptions(i5);
            if (appWidgetOptions.get("oneUiWidgetSource") != null) {
                BaseWidgetPreferenceManager.INSTANCE.saveOneUiWidgetSource(i5, String.valueOf(appWidgetOptions.get("oneUiWidgetSource")));
            }
            BaseWidgetPreferenceManager.Companion companion = BaseWidgetPreferenceManager.INSTANCE;
            companion.saveWidgetMatchSetting(i5, false);
            Bundle appWidgetOptions2 = appWidgetManager.getAppWidgetOptions(i5);
            if (appWidgetOptions2 != null) {
                i2 = appWidgetOptions2.getInt(BaseWidgetConstant.OLD_WIDGET_ID_OPTION);
                i = appWidgetOptions2.getInt(BaseWidgetConstant.NEW_WIDGET_ID_OPTION);
            } else {
                i = 0;
                i2 = 0;
            }
            WidgetBRHelper widgetBRHelper = WidgetBRHelper.INSTANCE;
            String strRestoreWidgetInfo = widgetBRHelper.restoreWidgetInfo(context, i2, i, true);
            if (widgetBRHelper.isCalledBySmartSwitch(strRestoreWidgetInfo)) {
                if (i2 == i) {
                    String uuid = companion.getUUID(i2);
                    remoteViewsUpdateNoFilePathWidget = (TextUtils.isEmpty(uuid) || Intrinsics.areEqual(uuid, BaseWidgetConstant.NONE) || Intrinsics.areEqual(uuid, strRestoreWidgetInfo)) ? null : makeWidgetListView(context, i5, uuid.toString(), WidgetConstant.RECEIVE_CALLER_ON_UPDATE);
                    if (remoteViewsUpdateNoFilePathWidget == null) {
                        WidgetBRHelper.restoreWidgetInfoToSharedPref(strRestoreWidgetInfo, i5, i2);
                        remoteViewsUpdateNoFilePathWidget = WidgetUtils.INSTANCE.isSDoc(context, strRestoreWidgetInfo) ? makeConvertWidgetView(context, i5) : makeWidgetListView(context, i5, String.valueOf(strRestoreWidgetInfo), WidgetConstant.RECEIVE_CALLER_ON_UPDATE);
                    }
                }
                updateAppWidgetAndNotify(appWidgetManager, i5, remoteViewsMakeEmptyWidgetView, C11391R.id.widget_list_view);
                i4++;
                context = context2;
            } else {
                String filePath = WidgetPreferenceManager.INSTANCE.getFilePath(i5);
                String uuid2 = companion.getUUID(i5);
                if (!TextUtils.isEmpty(uuid2) && WidgetUtils.INSTANCE.isSDoc(context, uuid2)) {
                    remoteViewsUpdateNoFilePathWidget = makeConvertWidgetView(context, i5);
                } else if (Intrinsics.areEqual(filePath, BaseWidgetConstant.NONE)) {
                    remoteViewsUpdateNoFilePathWidget = updateNoFilePathWidget(context, uuid2, i5, WidgetConstant.RECEIVE_CALLER_ON_UPDATE);
                } else {
                    if (ProviderUtils.INSTANCE.isMakeWidgetContent(context, uuid2)) {
                        context2 = context;
                        remoteViewsMakeEmptyWidgetView = makeWidgetListView(context2, i5, uuid2, filePath, false, WidgetConstant.RECEIVE_CALLER_ON_UPDATE);
                    } else {
                        context2 = context;
                        deleteWidget(context2, componentName, uuid2);
                        remoteViewsMakeEmptyWidgetView = makeEmptyWidgetView(context2, i5, WidgetConstant.RECEIVE_CALLER_ON_UPDATE);
                    }
                    updateAppWidgetAndNotify(appWidgetManager, i5, remoteViewsMakeEmptyWidgetView, C11391R.id.widget_list_view);
                    i4++;
                    context = context2;
                }
            }
            context2 = context;
            remoteViewsMakeEmptyWidgetView = remoteViewsUpdateNoFilePathWidget;
            updateAppWidgetAndNotify(appWidgetManager, i5, remoteViewsMakeEmptyWidgetView, C11391R.id.widget_list_view);
            i4++;
            context = context2;
        }
    }

    private final void onUpdateForOneUi7x(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        Context context2;
        GlanceAppWidgetManager glanceAppWidgetManager = new GlanceAppWidgetManager(context);
        int length = appWidgetIds.length;
        int i = 0;
        while (i < length) {
            int i2 = appWidgetIds[i];
            WidgetLogger.m5154d("WidgetProvider", "check thread: onUpdateForOneUi7x " + Thread.currentThread().getName());
            AppWidgetManager appWidgetManager2 = AppWidgetManager.getInstance(context);
            if (appWidgetManager2.getAppWidgetInfo(i2) == null) {
                context2 = context;
            } else {
                Bundle appWidgetOptions = appWidgetManager2.getAppWidgetOptions(i2);
                int i4 = appWidgetOptions.getInt("appWidgetMinWidth");
                int i5 = appWidgetOptions.getInt("appWidgetMinHeight");
                int i6 = appWidgetOptions.getInt("semAppWidgetRowSpan");
                int i7 = appWidgetOptions.getInt("semAppWidgetColumnSpan");
                BaseWidgetPreferenceManager.Companion companion = BaseWidgetPreferenceManager.INSTANCE;
                companion.saveMinWidthHeight(i2, i4, i5);
                companion.saveRowSpan(i2, i6);
                companion.saveColumnSpan(i2, i7);
                Bundle appWidgetOptions2 = AppWidgetManager.getInstance(context).getAppWidgetOptions(i2);
                if (appWidgetOptions2.get("oneUiWidgetSource") != null) {
                    companion.saveOneUiWidgetSource(i2, String.valueOf(appWidgetOptions2.get("oneUiWidgetSource")));
                }
                int i8 = appWidgetOptions.getInt(BaseWidgetConstant.OLD_WIDGET_ID_OPTION);
                int i9 = appWidgetOptions.getInt(BaseWidgetConstant.NEW_WIDGET_ID_OPTION);
                boolean zRestoreWidgetInfoWithoutUUID = WidgetBRHelper.restoreWidgetInfoWithoutUUID(i8, i9);
                WidgetLogger.m5154d("WidgetProvider", "onUpdate# oldWidgetId: " + i8 + ",newWidgetID: " + i9);
                if (zRestoreWidgetInfoWithoutUUID) {
                    WidgetBRHelper.INSTANCE.restoreSingleInfo(i2, i8);
                }
                WidgetPreferenceManager.INSTANCE.saveWidgetProviderName(i2, getProviderName());
                context2 = context;
                updateNormalWidgetViewOneUi7x$default(this, context2, glanceAppWidgetManager, i2, false, 8, null);
            }
            i++;
            context = context2;
        }
    }

    private final void setClickPendingIntent(Context context, int appWidgetId, RemoteViews remoteViews) {
        Intent intent = new Intent(context, getThis());
        intent.setAction(WidgetConstant.OPEN_MEMO_LIST_FROM_WIDGET);
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, appWidgetId);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, appWidgetId, intent, 201326592);
        remoteViews.setOnClickPendingIntent(C11391R.id.widget_title, broadcast);
        remoteViews.setPendingIntentTemplate(C11391R.id.widget_list_view, broadcast);
        remoteViews.setOnClickPendingIntent(C11391R.id.widget_listview_cover, broadcast);
        remoteViews.setOnClickPendingIntent(C11391R.id.widget_title_layout, broadcast);
        if (Build.VERSION.SDK_INT < 28) {
            Intent intent2 = new Intent(context, getThis());
            intent2.setAction(WidgetConstant.SETTING_MEMO_FROM_WIDGET);
            intent2.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, appWidgetId);
            PendingIntent broadcast2 = PendingIntent.getBroadcast(context, appWidgetId, intent2, 134217728);
            remoteViews.setOnClickPendingIntent(C11391R.id.widget_settings, broadcast2);
            remoteViews.setOnClickPendingIntent(C11391R.id.widget_overlap_setting, broadcast2);
        }
    }

    private final void setListAdapter(Context context, int appWidgetId, String uuid, String noteFilePath, RemoteViews remoteViews, String title) {
        Intent intent = new Intent(context, (Class<?>) WidgetService.class);
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, appWidgetId);
        intent.putExtra(WidgetConstant.EXTRA_KEY_FILE_PATH, noteFilePath);
        intent.putExtra(WidgetConstant.EXTRA_KEY_UUID, uuid);
        intent.putExtra(WidgetConstant.EXTRA_KEY_TITLE, title);
        intent.setData(Uri.parse(intent.toUri(1)));
        remoteViews.setViewVisibility(C11391R.id.widget_content_layout, 0);
        remoteViews.setViewVisibility(C11391R.id.widget_loading_layout, 8);
        remoteViews.setRemoteAdapter(C11391R.id.widget_list_view, intent);
    }

    private final void setOptionIcon(RemoteViews remoteViews, String title, boolean isRecording, boolean notSupportQuickSetting) {
        if (TextUtils.isEmpty(title)) {
            remoteViews.setViewVisibility(C11391R.id.widget_overlap_voice, isRecording ? 0 : 8);
            remoteViews.setViewVisibility(C11391R.id.widget_overlap_setting, notSupportQuickSetting ? 0 : 8);
            remoteViews.setViewVisibility(C11391R.id.widget_voice, 8);
            remoteViews.setViewVisibility(C11391R.id.widget_settings, 8);
            return;
        }
        remoteViews.setViewVisibility(C11391R.id.widget_voice, isRecording ? 0 : 8);
        remoteViews.setViewVisibility(C11391R.id.widget_settings, notSupportQuickSetting ? 0 : 8);
        remoteViews.setViewVisibility(C11391R.id.widget_overlap_voice, 8);
        remoteViews.setViewVisibility(C11391R.id.widget_overlap_setting, 8);
    }

    private final void setWidgetTitle(Context context, RemoteViews remoteViews, String title) {
        boolean zIsEmpty = TextUtils.isEmpty(title);
        ProviderUtils.INSTANCE.setWidgetTitle(context, remoteViews, title, !zIsEmpty, C11391R.id.widget_title_layout, C11391R.id.widget_title, C11391R.id.widget_title_shadow);
        if (zIsEmpty) {
            return;
        }
        remoteViews.setViewVisibility(C11391R.id.widget_overlap_voice, 8);
        remoteViews.setViewVisibility(C11391R.id.widget_overlap_setting, 8);
    }

    private final void startWidgetSetting(Context context, Intent intent) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis <= mPreviousEventTime) {
            return;
        }
        int intExtra = intent.getIntExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, -1);
        Intent intent2 = new Intent(context, (Class<?>) WidgetPinSettingsActivity.class);
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
        context.startActivity(intent2);
        setPreviousEventTime(jCurrentTimeMillis + 1000);
    }

    private final void updateAllWidget(Context context, ComponentName provider) {
        WidgetLogger.m5154d("WidgetProvider", "updateAllWidget#");
        try {
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            int[] appWidgetIds = appWidgetManager.getAppWidgetIds(provider);
            Intrinsics.checkNotNull(appWidgetIds);
            if (appWidgetIds.length == 0) {
                return;
            }
            Intrinsics.checkNotNull(appWidgetManager);
            onUpdate(context, appWidgetManager, appWidgetIds);
        } catch (Exception e) {
            WidgetLogger.INSTANCE.m5158e("WidgetProvider", "updateAllWidget# ", e);
        }
    }

    private final void updateAllWidgetForWallpaperChanged(Context context, ComponentName provider) {
        WidgetLogger.m5154d("WidgetProvider", "updateAllWidgetForWallpaperChanged#");
        try {
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            int[] appWidgetIds = appWidgetManager.getAppWidgetIds(provider);
            SharedPreferences sharedPreferences = context.getSharedPreferences(BaseWidgetConstant.WIDGET_PREFERENCES, 0);
            for (int i : appWidgetIds) {
                Intrinsics.checkNotNull(appWidgetManager);
                Intrinsics.checkNotNull(sharedPreferences);
                updateWidgetForWallpaperChanged(context, appWidgetManager, sharedPreferences, i);
            }
        } catch (Exception e) {
            WidgetLogger.INSTANCE.m5158e("WidgetProvider", "updateAllWidgetForWallpaperChanged# ", e);
        }
    }

    private final void updateAppWidgetAndNotify(AppWidgetManager appWidgetManager, int appWidgetId, RemoteViews remoteViews, int listId) {
        if (remoteViews != null) {
            updateAppWidgetAndNotify(appWidgetManager, appWidgetId, listId, remoteViews, "onUpdate");
            return;
        }
        WidgetLogger.INSTANCE.m5157e("WidgetProvider", "updateAppWidgetAndNotify# remoteViews is null from id = " + appWidgetId + "/ caller = onUpdate");
    }

    private final void updateAppWidgetRemoteView(AppWidgetManager appWidgetManager, int appWidgetId, RemoteViews remoteViews, String caller) {
        if (remoteViews == null) {
            WidgetLogger.INSTANCE.m5157e("WidgetProvider", AbstractC2322a.m1616f(appWidgetId, "updateAppWidget# remoteViews is null from id = ", "/ caller = ", caller));
            return;
        }
        WidgetLogger.m5155i("WidgetProvider", "updateAppWidget# widgetId = " + appWidgetId + "/ caller = " + caller);
        appWidgetManager.updateAppWidget(appWidgetId, remoteViews);
    }

    private final void updateBackgroundOnOff(int appWidgetId, String uuid, NotesDocumentEntity entity) {
        BaseWidgetPreferenceManager.Companion companion = BaseWidgetPreferenceManager.INSTANCE;
        boolean widgetBackgroundOnOff = companion.getWidgetBackgroundOnOff(appWidgetId);
        if (uuid == null || entity == null || widgetBackgroundOnOff || !CacheFileManager.INSTANCE.getInstance().isTextOnlyNote(uuid)) {
            return;
        }
        String content = entity.getContent();
        Intrinsics.checkNotNullExpressionValue(content, "getContent(...)");
        if (content.length() == 0) {
            String title = entity.getTitle();
            Intrinsics.checkNotNullExpressionValue(title, "getTitle(...)");
            if (title.length() == 0) {
                companion.saveWidgetBackgroundOnOff(appWidgetId, true);
            }
        }
    }

    public static /* synthetic */ void updateGlance$default(WidgetProvider widgetProvider, Context context, GlanceAppWidgetManager glanceAppWidgetManager, int i, String str, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateGlance");
        }
        if ((i2 & 8) != 0) {
            str = WidgetConstant.NORMAL_VIEW;
        }
        widgetProvider.updateGlance(context, glanceAppWidgetManager, i, str);
    }

    private final RemoteViews updateNoFilePathWidget(Context context, String uuid, int appWidgetId, String caller) {
        WidgetLogger.m5154d("WidgetProvider", "updateNoFilePathWidget#");
        if (!Intrinsics.areEqual(uuid, BaseWidgetConstant.NONE)) {
            if (ProviderUtils.INSTANCE.isMakeWidgetContent(context, uuid)) {
                return makeWidgetListView(context, appWidgetId, uuid, null, false, caller);
            }
            WidgetLogger.m5154d("WidgetProvider", "updateNoFilePathWidget# onUpdate : deleted - " + WidgetLogger.INSTANCE.getEncode(uuid));
            return makeEmptyWidgetView(context, appWidgetId, caller);
        }
        String pinUUID = WidgetPreferenceManager.getPinUUID();
        WidgetLogger.m5154d("WidgetProvider", "updateNoFilePathWidget# onUpdate : pinUUID - " + pinUUID);
        if (Intrinsics.areEqual(pinUUID, BaseWidgetConstant.NONE)) {
            return makeEmptyWidgetView(context, appWidgetId, caller);
        }
        WidgetPreferenceManager widgetPreferenceManager = WidgetPreferenceManager.INSTANCE;
        String pinFilePath = widgetPreferenceManager.getPinFilePath();
        SharedPreferences.Editor editorEdit = BaseWidgetPreferenceManager.INSTANCE.getWidgetPref().edit();
        editorEdit.putString(BaseWidgetConstant.WIDGET_ID + appWidgetId, pinUUID);
        editorEdit.apply();
        widgetPreferenceManager.clearDocInfoForPinToHome();
        HomeScreenUtils homeScreenUtils = HomeScreenUtils.INSTANCE;
        widgetPreferenceManager.saveWidgetDisplayDevicePref(appWidgetId, homeScreenUtils.getWidgetAddDisplayType(context));
        widgetPreferenceManager.saveWidgetHomeModePref(appWidgetId, homeScreenUtils.getHomeMode(context));
        return makeWidgetListView(context, appWidgetId, pinUUID, pinFilePath, false, caller);
    }

    private final void updateNormalWidgetViewOneUi7x(Context context, GlanceAppWidgetManager glanceManager, int appWidgetId, boolean isSaveSkip) {
        WidgetLogger.m5155i("WidgetProvider", "updateNormalWidgetViewOneUi7x#");
        WidgetPreferenceManager widgetPreferenceManager = WidgetPreferenceManager.INSTANCE;
        String filePath = widgetPreferenceManager.getFilePath(appWidgetId);
        BaseWidgetPreferenceManager.Companion companion = BaseWidgetPreferenceManager.INSTANCE;
        String uuid = companion.getUUID(appWidgetId);
        if (Intrinsics.areEqual(uuid, BaseWidgetConstant.NONE)) {
            String pinUUID = WidgetPreferenceManager.getPinUUID();
            WidgetLogger.m5154d("WidgetProvider", "updateNoFilePathWidgetOneUi7x# onUpdate : pinUUID - " + pinUUID);
            if (!Intrinsics.areEqual(pinUUID, BaseWidgetConstant.NONE)) {
                uuid = pinUUID == null ? BaseWidgetConstant.NONE : pinUUID;
                filePath = widgetPreferenceManager.getPinFilePath();
                SharedPreferences.Editor editorEdit = companion.getWidgetPref().edit();
                editorEdit.putString(BaseWidgetConstant.WIDGET_ID + appWidgetId, pinUUID);
                editorEdit.apply();
                widgetPreferenceManager.clearDocInfoForPinToHome();
                HomeScreenUtils homeScreenUtils = HomeScreenUtils.INSTANCE;
                widgetPreferenceManager.saveWidgetDisplayDevicePref(appWidgetId, homeScreenUtils.getWidgetAddDisplayType(context));
                widgetPreferenceManager.saveWidgetHomeModePref(appWidgetId, homeScreenUtils.getHomeMode(context));
            }
        }
        NotesDocumentRepository notesDocumentRepositoryCreateDocumentDataRepository = NotesDataRepositoryFactory.newInstance(context).createDocumentDataRepository();
        Intrinsics.checkNotNullExpressionValue(notesDocumentRepositoryCreateDocumentDataRepository, "createDocumentDataRepository(...)");
        if ((filePath == null || Intrinsics.areEqual(filePath, BaseWidgetConstant.NONE) || filePath.length() == 0) && (filePath = notesDocumentRepositoryCreateDocumentDataRepository.getPath(uuid)) != null) {
            widgetPreferenceManager.saveWidgetPrefFilePath(appWidgetId, filePath);
        }
        WidgetLogger.m5155i("WidgetProvider", "updateNormalWidgetViewOneUi7x# uuid: " + uuid + ", filePath: " + filePath);
        if (Intrinsics.areEqual(uuid, BaseWidgetConstant.NONE) && (filePath == null || Intrinsics.areEqual(filePath, BaseWidgetConstant.NONE))) {
            WidgetLogger.m5154d("WidgetProvider", "updateEmptyView# uuid: " + uuid);
            updateGlance(context, glanceManager, appWidgetId, WidgetConstant.EMPTY_VIEW);
            return;
        }
        if (!TextUtils.isEmpty(uuid) && WidgetUtils.INSTANCE.isSDoc(context, uuid)) {
            WidgetLogger.m5154d("WidgetProvider", "updateCoverView# uuid: " + uuid);
            updateGlance(context, glanceManager, appWidgetId, WidgetConstant.CONVERT_VIEW);
            return;
        }
        if (filePath == null || Intrinsics.areEqual(filePath, BaseWidgetConstant.NONE)) {
            WidgetLogger.m5154d("WidgetProvider", "updateNormalWidgetViewOneUi7x# noteFilePath is null.");
            WidgetPreferenceManager.saveWidgetPref$default(widgetPreferenceManager, appWidgetId, uuid, null, 4, null);
            updateGlance(context, glanceManager, appWidgetId, WidgetConstant.LOADING_VIEW);
            return;
        }
        WidgetLogger widgetLogger = WidgetLogger.INSTANCE;
        String encode = widgetLogger.getEncode(uuid);
        boolean zIsSaving = notesDocumentRepositoryCreateDocumentDataRepository.isSaving(uuid, Process.myPid());
        NotesDocumentEntity notesDocumentEntity = notesDocumentRepositoryCreateDocumentDataRepository.get(uuid);
        boolean z = notesDocumentEntity != null && notesDocumentEntity.getIsLock() == 5;
        if (notesDocumentEntity == null) {
            WidgetLogger.m5154d("WidgetProvider", "updateNormalWidgetViewOneUi7x# mainListEntry is null.");
            updateGlance(context, glanceManager, appWidgetId, WidgetConstant.LOADING_VIEW);
            return;
        }
        if (z) {
            WidgetLogger.m5154d("WidgetProvider", "updateNormalWidgetViewOneUi7x# note lock");
            onDeleted(context, new int[]{appWidgetId});
            updateGlance(context, glanceManager, appWidgetId, WidgetConstant.EMPTY_VIEW);
            return;
        }
        if (!isSaveSkip && zIsSaving) {
            WidgetLogger.m5154d("WidgetProvider", "updateNormalWidgetViewOneUi7x# uuid : " + encode + ", in saving.");
            updateGlance(context, glanceManager, appWidgetId, WidgetConstant.LOADING_VIEW);
            return;
        }
        if (!AbstractC2322a.m1607A(filePath)) {
            widgetLogger.m5157e("WidgetProvider", "updateNormalWidgetViewOneUi7x# path is not exist. path : " + widgetLogger.getEncode(filePath));
            updateGlance(context, glanceManager, appWidgetId, WidgetConstant.EMPTY_VIEW);
            return;
        }
        CacheFileManager.Companion companion2 = CacheFileManager.INSTANCE;
        if (!companion2.getInstance().isInitialized()) {
            companion2.getInstance().init(context);
        }
        if (companion2.getInstance().isValidFiles(uuid) && !companion2.getInstance().isCacheFilesCleared(context, uuid) && companion2.getInstance().isCreateWidgetState(context, uuid, appWidgetId)) {
            updateBackgroundOnOff(appWidgetId, uuid, notesDocumentEntity);
            updateGlance(context, glanceManager, appWidgetId, WidgetConstant.NORMAL_VIEW);
            return;
        }
        widgetPreferenceManager.saveUpdateWidgetContentDone(appWidgetId, false);
        companion2.getInstance().createCacheInfo(context, uuid, filePath, appWidgetId);
        widgetLogger.m5157e("WidgetProvider", "updateNormalWidgetViewOneUi7x# wait cache loading, mAppWidgetId: " + appWidgetId);
        updateGlance(context, glanceManager, appWidgetId, WidgetConstant.LOADING_VIEW);
    }

    public static /* synthetic */ void updateNormalWidgetViewOneUi7x$default(WidgetProvider widgetProvider, Context context, GlanceAppWidgetManager glanceAppWidgetManager, int i, boolean z, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateNormalWidgetViewOneUi7x");
        }
        if ((i2 & 8) != 0) {
            z = false;
        }
        widgetProvider.updateNormalWidgetViewOneUi7x(context, glanceAppWidgetManager, i, z);
    }

    private final void updateWidgetByCache(Context context, ComponentName provider, List<Integer> widgetIds, int listId) {
        List<Integer> list = widgetIds;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i : AppWidgetManager.getInstance(context).getAppWidgetIds(provider)) {
            Iterator<Integer> it = widgetIds.iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                if (i == iIntValue) {
                    updateAppWidgetAndNotify(context, iIntValue, BaseWidgetPreferenceManager.INSTANCE.getUUID(iIntValue), listId, "updateWidgetByCache");
                }
            }
        }
    }

    private final void updateWidgetByCacheOneUi7x(Context context, ComponentName provider, List<Integer> widgetIds) {
        List<Integer> list = widgetIds;
        if (list == null || list.isEmpty()) {
            return;
        }
        WidgetLogger.m5154d("WidgetProvider", "updateWidgetByCacheOneUi7x#");
        int[] appWidgetIds = AppWidgetManager.getInstance(context).getAppWidgetIds(provider);
        GlanceAppWidgetManager glanceAppWidgetManager = new GlanceAppWidgetManager(context);
        Iterator<Integer> it = widgetIds.iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            Intrinsics.checkNotNull(appWidgetIds);
            if (ArraysKt.contains(appWidgetIds, iIntValue)) {
                WidgetLogger.m5154d("WidgetProvider", "update wait cache widget id : " + iIntValue);
                updateNormalWidgetViewOneUi7x(context, glanceAppWidgetManager, iIntValue, true);
            }
        }
    }

    private final void updateWidgetByConvertUUID(Context context, ComponentName provider, String uuid, String newUuid) {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(provider);
        if (TextUtils.isEmpty(uuid)) {
            WidgetLogger.INSTANCE.m5157e("WidgetProvider", "updateWidgetByConvertUUID# uuid is null or empty");
            return;
        }
        if (TextUtils.isEmpty(newUuid)) {
            WidgetLogger.INSTANCE.m5157e("WidgetProvider", "updateWidgetByConvertUUID# new uuid is null or empty");
            return;
        }
        for (int i : appWidgetIds) {
            if (Intrinsics.areEqual(uuid, BaseWidgetPreferenceManager.INSTANCE.getUUID(i))) {
                WidgetPreferenceManager.saveWidgetPref$default(WidgetPreferenceManager.INSTANCE, i, newUuid, null, 4, null);
                Intrinsics.checkNotNull(appWidgetManager);
                onUpdate(context, appWidgetManager, new int[]{i});
                return;
            }
        }
    }

    private final void updateWidgetByUUID(Context context, ComponentName provider, String uuid) {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(provider);
        if (TextUtils.isEmpty(uuid)) {
            WidgetLogger.INSTANCE.m5157e("WidgetProvider", "updateWidgetByUUID# uuid is null or empty");
            return;
        }
        for (int i : appWidgetIds) {
            String uuid2 = BaseWidgetPreferenceManager.INSTANCE.getUUID(i);
            if (Intrinsics.areEqual(uuid, uuid2)) {
                ProviderUtils.INSTANCE.removePreviousCache(context, uuid2);
                Intrinsics.checkNotNull(appWidgetManager);
                onUpdate(context, appWidgetManager, new int[]{i});
                return;
            }
        }
    }

    private final void updateWidgetCacheDone(Context context, ComponentName provider, String uuid, int view) {
        if (TextUtils.isEmpty(uuid)) {
            WidgetLogger.INSTANCE.m5157e("WidgetProvider", "updateWidgetByUUID# uuid is null or empty");
            return;
        }
        for (int i : AppWidgetManager.getInstance(context).getAppWidgetIds(provider)) {
            if (Intrinsics.areEqual(uuid, BaseWidgetPreferenceManager.INSTANCE.getUUID(i))) {
                boolean updateWidgetContentDone = WidgetPreferenceManager.INSTANCE.getUpdateWidgetContentDone(i);
                WidgetLogger.INSTANCE.m5157e("WidgetProvider", "updateWidgetCacheDone# " + updateWidgetContentDone);
                if (updateWidgetContentDone) {
                    return;
                }
                updateAppWidgetAndNotify(context, i, uuid, view, "updateWidgetByCache");
                return;
            }
        }
    }

    private final void updateWidgetCacheDoneOneUi7(Context context, ComponentName provider, int widgetId, String uuid) {
        if (TextUtils.isEmpty(uuid)) {
            WidgetLogger.INSTANCE.m5157e("WidgetProvider", "updateWidgetByUUID# uuid is null or empty");
            return;
        }
        WidgetLogger widgetLogger = WidgetLogger.INSTANCE;
        widgetLogger.m5157e("WidgetProvider", AbstractC2322a.m1616f(widgetId, "updateWidgetCacheDone# widgetId: ", ", uuid: ", uuid));
        if (widgetId > -1) {
            GlanceAppWidgetManager glanceAppWidgetManager = new GlanceAppWidgetManager(context);
            boolean updateWidgetContentDone = WidgetPreferenceManager.INSTANCE.getUpdateWidgetContentDone(widgetId);
            widgetLogger.m5157e("WidgetProvider", "updateWidgetCacheDone# " + updateWidgetContentDone);
            if (updateWidgetContentDone) {
                return;
            }
            updateNormalWidgetViewOneUi7x(context, glanceAppWidgetManager, widgetId, true);
            return;
        }
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        GlanceAppWidgetManager glanceAppWidgetManager2 = new GlanceAppWidgetManager(context);
        for (int i : appWidgetManager.getAppWidgetIds(provider)) {
            if (Intrinsics.areEqual(uuid, BaseWidgetPreferenceManager.INSTANCE.getUUID(i))) {
                boolean updateWidgetContentDone2 = WidgetPreferenceManager.INSTANCE.getUpdateWidgetContentDone(i);
                WidgetLogger.INSTANCE.m5157e("WidgetProvider", "updateWidgetCacheDone# " + updateWidgetContentDone2);
                if (updateWidgetContentDone2) {
                    return;
                }
                updateNormalWidgetViewOneUi7x(context, glanceAppWidgetManager2, i, true);
                return;
            }
        }
    }

    private final void updateWidgetForWallpaperChanged(Context context, AppWidgetManager manager, SharedPreferences widgetPref, int wId) {
        int i = widgetPref.getInt(BaseWidgetConstant.WIDGET_ID + wId + BaseWidgetConstant.WIDGET_THEME, -1);
        int widgetPreferenceManagerReverseTransparency = WidgetPreferenceManager.INSTANCE.getWidgetPreferenceManagerReverseTransparency(wId);
        BaseWidgetPreferenceManager.Companion companion = BaseWidgetPreferenceManager.INSTANCE;
        int backgroundColor = companion.getBackgroundColor(wId);
        int darkMode = companion.getDarkMode(wId);
        BaseWidgetUtils.Companion companion2 = BaseWidgetUtils.INSTANCE;
        int iCheckTheme = companion2.checkTheme(context, widgetPreferenceManagerReverseTransparency, backgroundColor);
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, iCheckTheme, "updateAllWidgetForWallpaperChanged# previousTheme = ", " , newTheme = ", " , darkMode = ");
        sbM1173s.append(darkMode);
        WidgetLogger.m5154d("WidgetProvider", sbM1173s.toString());
        if (i == -1 || i == iCheckTheme || companion2.isMatchWithDarkModeAndNightMode(context, darkMode)) {
            return;
        }
        onUpdate(context, manager, new int[]{wId});
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

    @NotNull
    public Class<?> getThis() {
        return this.this;
    }

    @Override // androidx.glance.appwidget.GlanceAppWidgetReceiver, android.appwidget.AppWidgetProvider
    public void onAppWidgetOptionsChanged(@NotNull final Context context, @NotNull AppWidgetManager appWidgetManager, final int appWidgetId, @NotNull Bundle newOptions) {
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
        WidgetLogger.m5155i("WidgetProvider", "onAppWidgetOptionsChanged# " + appWidgetId);
        BaseWidgetPreferenceManager.Companion companion3 = BaseWidgetPreferenceManager.INSTANCE;
        final String uuid = companion3.getUUID(appWidgetId);
        int i6 = newOptions.getInt("appWidgetMinWidth");
        int i7 = newOptions.getInt("appWidgetMaxWidth");
        SharedPreferences sharedPreferences = context.getSharedPreferences(BaseWidgetConstant.WIDGET_PREFERENCES, 0);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        int i8 = sharedPreferences.getInt(WidgetConstant.WIDGET_MAX_WIDTH + appWidgetId, -1);
        editorEdit.putInt(WidgetConstant.WIDGET_MAX_WIDTH + appWidgetId, i7);
        editorEdit.putInt(WidgetConstant.WIDGET_MIN_WIDTH + appWidgetId, i6);
        editorEdit.apply();
        boolean z = i8 / 10 != i7 / 10;
        boolean zIsDarkModeChange = companion.isDarkModeChange(context, appWidgetId);
        boolean zIsTextOnlyNote = ProviderUtils.INSTANCE.isTextOnlyNote(context, uuid);
        boolean updateWidgetContentDone = WidgetPreferenceManager.INSTANCE.getUpdateWidgetContentDone(appWidgetId);
        if (companion.isSupportedNewWidget()) {
            StringBuilder sbM2226q = AbstractC2821a.m2226q("onAppWidgetOptionsChanged# glance widget ", appWidgetId, ", isDarkModeChange: ", zIsDarkModeChange, ", isTextOnly: ");
            AbstractC2821a.m2208C(sbM2226q, zIsTextOnlyNote, ", isWidthChange: ", z, ", isUpdateDone: ");
            sbM2226q.append(updateWidgetContentDone);
            WidgetLogger.m5155i("WidgetProvider", sbM2226q.toString());
            GlanceAppWidgetManager glanceAppWidgetManager = new GlanceAppWidgetManager(context);
            if (zIsDarkModeChange) {
                if (ContextUtils.isNightMode(context)) {
                    companion3.saveDarkModePref(appWidgetId, 1);
                } else {
                    companion3.saveDarkModePref(appWidgetId, 0);
                }
                updateNormalWidgetViewOneUi7x$default(this, context, glanceAppWidgetManager, appWidgetId, false, 8, null);
                return;
            }
            if (zIsTextOnlyNote || z || !updateWidgetContentDone) {
                updateNormalWidgetViewOneUi7x$default(this, context, glanceAppWidgetManager, appWidgetId, false, 8, null);
                return;
            }
            return;
        }
        StringBuilder sbM2226q2 = AbstractC2821a.m2226q("onAppWidgetOptionsChanged# old widget ", appWidgetId, ", isDarkModeChange: ", zIsDarkModeChange, ", isTextOnly: ");
        AbstractC2821a.m2208C(sbM2226q2, zIsTextOnlyNote, ", isWidthChange: ", z, ", isUpdateDone: ");
        sbM2226q2.append(updateWidgetContentDone);
        WidgetLogger.m5155i("WidgetProvider", sbM2226q2.toString());
        final int i9 = C11391R.id.widget_list_view;
        if (uuid.length() == 0 || Intrinsics.areEqual(uuid, BaseWidgetConstant.NONE)) {
            onUpdate(context, appWidgetManager, new int[]{appWidgetId});
            return;
        }
        if (zIsDarkModeChange) {
            updateAppWidgetAndNotify(context, appWidgetId, uuid, i9, "onAppWidgetOptionsChanged. updateAppWidget dark");
            return;
        }
        if (zIsTextOnlyNote) {
            int i10 = context.getResources().getConfiguration().orientation;
            if (i10 == sharedPreferences.getInt(BaseWidgetConstant.WIDGET_ID + appWidgetId + "orientation", -1)) {
                if (z) {
                    updateAppWidgetAndNotify(context, appWidgetId, uuid, i9, "onAppWidgetOptionsChanged. updateWidget width");
                    return;
                }
                return;
            }
            editorEdit.putInt(BaseWidgetConstant.WIDGET_ID + appWidgetId + "orientation", i10);
            editorEdit.apply();
            if (Build.VERSION.SDK_INT > 29) {
                new Handler().postDelayed(new Runnable() { // from class: com.samsung.android.app.notes.widget.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f4486a.updateAppWidgetAndNotify(context, appWidgetId, uuid, i9, "onAppWidgetOptionsChanged. updateAppWidget post");
                    }
                }, 100L);
            } else {
                updateAppWidgetAndNotify(context, appWidgetId, uuid, i9, "onAppWidgetOptionsChanged. updateAppWidget");
            }
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
        WidgetLogger.m5155i("WidgetProvider", "onDeleted# " + string);
        for (int i : appWidgetIds) {
            CacheFileManager.INSTANCE.getInstance().removeCacheInfo(context, BaseWidgetPreferenceManager.INSTANCE.getUUID(i), i);
            WidgetPreferenceManager.deleteWidgetPref(i, true);
        }
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onDisabled(@Nullable Context context) {
        Logger.m8697d("WidgetProvider", "onDisabled");
        if (BaseWidgetUtils.INSTANCE.isSupportedNewWidget()) {
            super.onDisabled(context);
        }
    }

    @Override // androidx.glance.oneui.template.GlanceTemplateAppWidgetReceiver, androidx.glance.appwidget.GlanceAppWidgetReceiver, android.appwidget.AppWidgetProvider, android.content.BroadcastReceiver
    public void onReceive(@NotNull Context context, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        BaseWidgetUtils.Companion companion = BaseWidgetUtils.INSTANCE;
        if (companion.isSupportedNewWidget()) {
            super.onReceive(context, intent);
        } else {
            onReceiveForBelowOneUi7x(context, intent);
        }
        String action = intent.getAction();
        Class<?> classProvider = getClassProvider(getProviderName());
        ComponentName componentName = new ComponentName(context, classProvider);
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = mPreviousEventTime;
        String providerName = getProviderName();
        StringBuilder sb = new StringBuilder("onReceive# action: ");
        sb.append(action);
        sb.append(" , RequestTime: ");
        sb.append(jCurrentTimeMillis);
        AbstractC1038a.m1223x(sb, " PreviousEventTime: ", j, "providerName: ");
        sb.append(providerName);
        WidgetLogger.m5155i("WidgetProvider", sb.toString());
        if (Intrinsics.areEqual(BaseWidgetConstant.ACTION_APPWIDGET_UPDATE, action)) {
            NotesSamsungAnalytics.INSTANCE.insertStatusLog("9979", companion.getWidgetCount(context, classProvider));
            WidgetLogger.m5154d("WidgetProvider", "onReceive# " + getProviderName() + ": " + companion.getWidgetCount(context, classProvider));
        }
        if (Intrinsics.areEqual(WidgetConstant.ACTION_MEMO_PICK_DONE, action)) {
            int intExtra = intent.getIntExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, -1);
            WidgetLogger.m5154d("WidgetProvider", "onReceive# widget id : " + intExtra);
            ProviderUtils providerUtils = ProviderUtils.INSTANCE;
            if (providerUtils.isCurrentProviderWidget(context, componentName, intExtra)) {
                String stringExtra = intent.getStringExtra(WidgetConstant.EXTRA_KEY_UUID);
                String stringExtra2 = intent.getStringExtra(WidgetConstant.EXTRA_KEY_FILE_PATH);
                int intExtra2 = intent.getIntExtra(BaseWidgetConstant.EXTRA_KEY_WIDGET_TRANSPARENCY, -1);
                int intExtra3 = intent.getIntExtra(BaseWidgetConstant.EXTRA_KEY_WIDGET_BACKGROUND_COLOR, -1);
                int intExtra4 = intent.getIntExtra(BaseWidgetConstant.EXTRA_KEY_WIDGET_DARK_MODE, -1);
                boolean booleanExtra = intent.getBooleanExtra(BaseWidgetConstant.KEY_WIDGET_MATCH_SETTING, true);
                int intExtra5 = intent.getIntExtra(BaseWidgetConstant.KEY_WIDGET_BACKGROUND_SHAPE, 0);
                boolean booleanExtra2 = intent.getBooleanExtra(BaseWidgetConstant.KEY_WIDGET_BACKGROUND_ON_OFF, true);
                if (isUpdatePickNote(stringExtra, intExtra, intExtra2, intExtra3, intExtra4, booleanExtra, intExtra5, booleanExtra2)) {
                    if (intExtra2 == -1) {
                        WidgetPreferenceManager.INSTANCE.saveWidgetPref(intExtra, stringExtra, stringExtra2);
                        BaseWidgetPreferenceManager.INSTANCE.saveTransparency(intExtra, companion.isSupportedNewWidget() ? 75 : 100);
                    } else {
                        WidgetPreferenceManager.INSTANCE.saveWidgetPref(intExtra, stringExtra, stringExtra2, intExtra2);
                    }
                    if (intExtra3 != -1) {
                        BaseWidgetPreferenceManager.INSTANCE.saveWidgetBackgroundColorPref(intExtra, intExtra3);
                    }
                    if (intExtra4 != -1) {
                        BaseWidgetPreferenceManager.INSTANCE.saveDarkModePref(intExtra, intExtra4);
                    } else if (ContextUtils.isNightMode(context)) {
                        BaseWidgetPreferenceManager.INSTANCE.saveDarkModePref(intExtra, 1);
                    } else {
                        BaseWidgetPreferenceManager.INSTANCE.saveDarkModePref(intExtra, 0);
                    }
                    BaseWidgetPreferenceManager.Companion companion2 = BaseWidgetPreferenceManager.INSTANCE;
                    companion2.saveWidgetOrientationPref(intExtra, context.getResources().getConfiguration().orientation);
                    WidgetPreferenceManager widgetPreferenceManager = WidgetPreferenceManager.INSTANCE;
                    HomeScreenUtils homeScreenUtils = HomeScreenUtils.INSTANCE;
                    widgetPreferenceManager.saveWidgetDisplayDevicePref(intExtra, homeScreenUtils.getWidgetAddDisplayType(context));
                    widgetPreferenceManager.saveWidgetHomeModePref(intExtra, homeScreenUtils.getHomeMode(context));
                    if (companion.isSupportedNewWidget()) {
                        companion2.saveWidgetMatchSetting(intExtra, booleanExtra);
                        companion2.saveWidgetBackgroundShape(intExtra, intExtra5);
                        companion2.saveWidgetBackgroundOnOff(intExtra, booleanExtra2);
                        widgetPreferenceManager.saveWidgetProviderName(intExtra, getProviderName());
                    }
                    providerUtils.removePreviousCache(context, stringExtra);
                    AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
                    Intrinsics.checkNotNull(appWidgetManager);
                    onUpdate(context, appWidgetManager, new int[]{intExtra});
                    return;
                }
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(WidgetConstant.ACTION_MEMO_PICK_DONE_NEW_NOTE, action)) {
            int intExtra6 = intent.getIntExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, -1);
            WidgetLogger.m5154d("WidgetProvider", "onReceive# widget id : " + intExtra6);
            ProviderUtils providerUtils2 = ProviderUtils.INSTANCE;
            if (providerUtils2.isCurrentProviderWidget(context, componentName, intExtra6)) {
                String stringExtra3 = intent.getStringExtra(WidgetConstant.EXTRA_KEY_UUID);
                String stringExtra4 = intent.getStringExtra(WidgetConstant.EXTRA_KEY_FILE_PATH);
                WidgetPreferenceManager widgetPreferenceManager2 = WidgetPreferenceManager.INSTANCE;
                widgetPreferenceManager2.saveWidgetPref(intExtra6, stringExtra3, stringExtra4);
                BaseWidgetPreferenceManager.INSTANCE.saveWidgetOrientationPref(intExtra6, context.getResources().getConfiguration().orientation);
                HomeScreenUtils homeScreenUtils2 = HomeScreenUtils.INSTANCE;
                widgetPreferenceManager2.saveWidgetDisplayDevicePref(intExtra6, homeScreenUtils2.getWidgetAddDisplayType(context));
                widgetPreferenceManager2.saveWidgetHomeModePref(intExtra6, homeScreenUtils2.getHomeMode(context));
                widgetPreferenceManager2.saveWidgetProviderName(intExtra6, getProviderName());
                providerUtils2.removePreviousCache(context, stringExtra3);
                AppWidgetManager appWidgetManager2 = AppWidgetManager.getInstance(context);
                Intrinsics.checkNotNull(appWidgetManager2);
                onUpdate(context, appWidgetManager2, new int[]{intExtra6});
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(WidgetConstant.ACTION_MEMO_UPDATE_UUID, action)) {
            String stringExtra5 = intent.getStringExtra(WidgetConstant.EXTRA_KEY_UUID);
            Intrinsics.checkNotNull(stringExtra5);
            updateWidgetByUUID(context, componentName, stringExtra5);
            return;
        }
        if (Intrinsics.areEqual(WidgetConstant.ACTION_MEMO_WAIT_CACHE, action)) {
            ArrayList<Integer> integerArrayListExtra = intent.getIntegerArrayListExtra(WidgetConstant.EXTRA_KEY_FROM_WIDGET_ID_LIST);
            if (companion.isSupportedNewWidget()) {
                updateWidgetByCacheOneUi7x(context, componentName, integerArrayListExtra);
                return;
            } else {
                updateWidgetByCache(context, componentName, integerArrayListExtra, C11391R.id.widget_list_view);
                return;
            }
        }
        if (Intrinsics.areEqual(action, WidgetConstant.ACTION_MEMO_CACHE_DONE)) {
            int intExtra7 = intent.getIntExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, -1);
            String stringExtra6 = intent.getStringExtra(WidgetConstant.EXTRA_KEY_UUID);
            WidgetLogger.m5154d("WidgetProvider", "onReceive# widget id : " + intExtra7);
            if (intExtra7 <= -1 || ProviderUtils.INSTANCE.isCurrentProviderWidget(context, componentName, intExtra7)) {
                if (companion.isSupportedNewWidget()) {
                    updateWidgetCacheDoneOneUi7(context, componentName, intExtra7, stringExtra6);
                    return;
                } else {
                    if (Intrinsics.areEqual(getProviderName(), "WidgetProvider")) {
                        updateWidgetCacheDone(context, componentName, stringExtra6, C11391R.id.widget_list_view);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (Intrinsics.areEqual(WidgetConstant.ACTION_MEMO_DELETE_UUID, action)) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra(WidgetConstant.EXTRA_KEY_UUID);
            if (stringArrayListExtra != null) {
                CacheFileManager.INSTANCE.getInstance().removeCacheInfo(context, stringArrayListExtra);
                deleteWidgetByUUIDList(context, componentName, stringArrayListExtra);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(WidgetConstant.ACTION_MEMO_UPDATE_ALL, action) || Intrinsics.areEqual(BaseWidgetConstant.TIME_SET_CHANGED, action) || Intrinsics.areEqual("android.intent.action.TIMEZONE_CHANGED", action)) {
            updateAllWidget(context, componentName);
            return;
        }
        if (Intrinsics.areEqual(BaseWidgetConstant.ACTION_WALLPAPER_CHANGED, action)) {
            if (!companion.isSupportedNewWidget()) {
                updateAllWidgetForWallpaperChanged(context, componentName);
                return;
            }
            AppWidgetManager appWidgetManager3 = AppWidgetManager.getInstance(context);
            Intrinsics.checkNotNullExpressionValue(appWidgetManager3, "getInstance(...)");
            int[] appWidgetIds = AppWidgetManager.getInstance(context).getAppWidgetIds(componentName);
            Intrinsics.checkNotNullExpressionValue(appWidgetIds, "getAppWidgetIds(...)");
            onUpdate(context, appWidgetManager3, appWidgetIds);
            return;
        }
        if (Intrinsics.areEqual(WidgetConstant.OPEN_MEMO_LIST_FROM_WIDGET, action)) {
            openMemoListFromWidget(context, intent, mPreviousEventTime);
            return;
        }
        if (Intrinsics.areEqual(WidgetConstant.PICK_MEMO_LIST_FROM_WIDGET, action)) {
            pickMemoListFromWidget(context, intent, mPreviousEventTime, true);
            return;
        }
        if (Intrinsics.areEqual(WidgetConstant.SETTING_MEMO_FROM_WIDGET, action)) {
            startWidgetSetting(context, intent);
            return;
        }
        if (Intrinsics.areEqual(WidgetConstant.ACTION_MEMO_CONVERT, action)) {
            convertFromWidget(context, intent, mPreviousEventTime);
            return;
        }
        if (Intrinsics.areEqual(WidgetConstant.ACTION_MEMO_CONVERT_UUID, action)) {
            String stringExtra7 = intent.getStringExtra(WidgetConstant.EXTRA_KEY_UUID);
            String stringExtra8 = intent.getStringExtra(WidgetConstant.EXTRA_KEY_CONVERT_UUID);
            Intrinsics.checkNotNull(stringExtra7);
            updateWidgetByConvertUUID(context, componentName, stringExtra7, stringExtra8);
            return;
        }
        if (Intrinsics.areEqual(WidgetConstant.ACTION_MEMO_EMPTY, action)) {
            int intExtra8 = intent.getIntExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, -1);
            if (ProviderUtils.INSTANCE.isCurrentProviderWidget(context, componentName, intExtra8)) {
                BaseWidgetPreferenceManager.INSTANCE.saveWidgetOrientationPref(intExtra8, context.getResources().getConfiguration().orientation);
                WidgetPreferenceManager widgetPreferenceManager3 = WidgetPreferenceManager.INSTANCE;
                HomeScreenUtils homeScreenUtils3 = HomeScreenUtils.INSTANCE;
                widgetPreferenceManager3.saveWidgetDisplayDevicePref(intExtra8, homeScreenUtils3.getWidgetAddDisplayType(context));
                widgetPreferenceManager3.saveWidgetHomeModePref(intExtra8, homeScreenUtils3.getHomeMode(context));
                widgetPreferenceManager3.saveWidgetProviderName(intExtra8, getProviderName());
            }
        }
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onRestored(@NotNull Context context, @NotNull int[] oldWidgetIds, @NotNull int[] newWidgetIds) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(oldWidgetIds, "oldWidgetIds");
        Intrinsics.checkNotNullParameter(newWidgetIds, "newWidgetIds");
        String string = Arrays.toString(oldWidgetIds);
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        Logger.m8697d("WidgetProvider", "onRestored oldWidgetIds" + string);
        String string2 = Arrays.toString(newWidgetIds);
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        Logger.m8697d("WidgetProvider", "onRestored oldWidgetIds " + string2);
        if (BaseWidgetUtils.INSTANCE.isSupportedNewWidget()) {
            super.onRestored(context, oldWidgetIds, newWidgetIds);
        }
    }

    @Override // androidx.glance.appwidget.GlanceAppWidgetReceiver, android.appwidget.AppWidgetProvider
    public void onUpdate(@NotNull Context context, @NotNull AppWidgetManager appWidgetManager, @NotNull int[] appWidgetIds) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appWidgetManager, "appWidgetManager");
        Intrinsics.checkNotNullParameter(appWidgetIds, "appWidgetIds");
        String string = Arrays.toString(appWidgetIds);
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        WidgetLogger.m5155i("WidgetProvider", "onUpdate# " + string);
        if (!BaseWidgetUtils.INSTANCE.isSupportedNewWidget()) {
            onUpdateForBelowOneUi7x(context, appWidgetManager, appWidgetIds);
        } else {
            super.onUpdate(context, appWidgetManager, appWidgetIds);
            onUpdateForOneUi7x(context, appWidgetManager, appWidgetIds);
        }
    }

    public void openMemoListFromWidget(@NotNull Context context, @NotNull Intent intent, long previousEventTime) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        WidgetLogger.m5154d("WidgetProvider", "openMemoListFromWidget#");
        synchronized (this) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (!StorageUtils.isAvailableMemoryForNewMemo()) {
                Intent intent2 = new Intent(context, (Class<?>) StorageErrorDialogActivity.class);
                intent2.setFlags(402653184);
                context.startActivity(intent2);
                return;
            }
            ProviderUtils providerUtils = ProviderUtils.INSTANCE;
            if (providerUtils.checkEventTime(jCurrentTimeMillis, previousEventTime, 1000L)) {
                int intExtra = intent.getIntExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, -1);
                String uuid = BaseWidgetPreferenceManager.INSTANCE.getUUID(intExtra);
                if (WidgetUtils.INSTANCE.isSDoc(context, uuid)) {
                    WidgetLogger.m5156w("WidgetProvider", "openMemoListFromWidget# need to convert");
                    if (BaseWidgetUtils.INSTANCE.isSupportedNewWidget()) {
                        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
                        Intrinsics.checkNotNullExpressionValue(appWidgetManager, "getInstance(...)");
                        onUpdate(context, appWidgetManager, new int[]{intExtra});
                    } else {
                        AppWidgetManager appWidgetManager2 = AppWidgetManager.getInstance(context);
                        Intrinsics.checkNotNullExpressionValue(appWidgetManager2, "getInstance(...)");
                        updateAppWidgetRemoteView(appWidgetManager2, intExtra, makeConvertWidgetView(context, intExtra), "openMemoListAndConvert");
                    }
                    return;
                }
                NotesDocumentRepository notesDocumentRepositoryCreateDocumentDataRepository = NotesDataRepositoryFactory.newInstance(context).createDocumentDataRepository();
                Intrinsics.checkNotNullExpressionValue(notesDocumentRepositoryCreateDocumentDataRepository, "createDocumentDataRepository(...)");
                String path = notesDocumentRepositoryCreateDocumentDataRepository.getPath(uuid);
                WidgetLogger widgetLogger = WidgetLogger.INSTANCE;
                String encode = widgetLogger.getEncode(uuid);
                if (path != null) {
                    WidgetLogger.m5154d("WidgetProvider", "openMemoListFromWidget# widgetId : " + intExtra + " uuid : " + encode + " path :" + widgetLogger.getEncode(path));
                    if (ComposerAccessHandler.getComposerActivityClass() == null) {
                        PostLaunchManager.INSTANCE.getInstance().executeBaseLogic(1);
                    }
                    Intent intent3 = new Intent(context, ComposerAccessHandler.getComposerActivityClass());
                    if (C0158a.m407a().m415h()) {
                        MdeInfo mdeInfo = new MdeInfo(notesDocumentRepositoryCreateDocumentDataRepository.get(uuid).getMdeSpaceId(), notesDocumentRepositoryCreateDocumentDataRepository.get(uuid).getMdeGroupId(), notesDocumentRepositoryCreateDocumentDataRepository.get(uuid).getMdeOwnerId(), "test", AbstractC14517a.m15166z(context, uuid) ? 1 : 2);
                        if (!TextUtils.isEmpty(mdeInfo.getSpaceId())) {
                            WidgetLogger.m5154d("WidgetProvider", "openMemoListFromWidget# this is mde file");
                            PostLaunchManager.INSTANCE.getInstance().executeBaseLogics();
                            intent3.putExtra(ComposerConstants.ARG_MDE_SPACE_ID, mdeInfo.getSpaceId());
                            intent3.putExtra(ComposerConstants.ARG_MDE_GROUP_ID, mdeInfo.getGroupId());
                            intent3.putExtra(ComposerConstants.ARG_MDE_OWNER_ID, mdeInfo.getOwnerId());
                            intent3.putExtra(ComposerConstants.ARG_MDE_WRITER, mdeInfo.getCreatorName());
                            intent3.putExtra(ComposerConstants.ARG_MDE_ACCOUNT_TYPE, mdeInfo.getAccountType());
                        }
                    }
                    intent3.setAction(ComposerConstants.ACTION_OPEN_MEMO);
                    intent3.putExtra("sdoc_uuid", uuid);
                    intent3.setFlags(ComposerConstants.ACTIVITY_FLAG_CALLEE);
                    if (Intrinsics.areEqual(getProviderName(), BaseWidgetConstant.WIDGET_SINGLE_MEDIUM_COVER_PROVIDER_NAME) || Intrinsics.areEqual(getProviderName(), "WidgetSingleLargeCoverProvider") || Intrinsics.areEqual(getProviderName(), "WidgetSingleExtraLargeCoverProvider")) {
                        PendingIntent activity = PendingIntent.getActivity(context, 0, intent3, 201326592);
                        Object systemService = context.getSystemService("keyguard");
                        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.KeyguardManager");
                        Intent intent4 = new Intent();
                        intent4.putExtra("showCoverToast", true);
                        intent4.putExtra("ignoreKeyguardState", true);
                        KeyguardManagerCompat companion = KeyguardManagerCompat.INSTANCE.getInstance();
                        Intrinsics.checkNotNull(activity);
                        companion.semSetPendingIntentAfterUnlock(context, activity, intent4);
                    } else {
                        context.startActivity(intent3);
                    }
                } else {
                    WidgetLogger.m5154d("WidgetProvider", "openMemoListFromWidget# widgetId : " + intExtra + "uuid : " + encode);
                    providerUtils.openMemoList(context);
                }
                setPreviousEventTime(jCurrentTimeMillis + 1000);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public void pickMemoListFromWidget(@NotNull Context context, @NotNull Intent intent, long previousEventTime, boolean checkWidgetCount) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        WidgetLogger.m5154d("WidgetProvider", "pickMemoListFromWidget#");
        long jCurrentTimeMillis = System.currentTimeMillis();
        Class<?> classProvider = getClassProvider(getProviderName());
        ProviderUtils providerUtils = ProviderUtils.INSTANCE;
        if (providerUtils.checkEventTime(jCurrentTimeMillis, previousEventTime, 1000L)) {
            if (WidgetAccessHandler.INSTANCE.getWidgetResolverClass() == null || NoteListAccessHandler.getNotePickerClass() == null) {
                PostLaunchManager.INSTANCE.getInstance().executeBaseLogic(1);
            }
            int allNoteCount = NotesDataRepositoryFactory.newInstance(context).createMainListDocumentDataRepository().getAllNoteCount(0, true);
            int intExtra = intent.getIntExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, -1);
            if (checkWidgetCount && !providerUtils.isAvailableToReferWidget(context, classProvider, intExtra)) {
                WidgetUtils.Companion.showWidgetMaximumToast$default(WidgetUtils.INSTANCE, context, 0, 2, null);
            } else if (allNoteCount == 0) {
                Intent intent2 = new Intent(context, ComposerAccessHandler.getComposerActivityClass());
                intent2.setAction(ComposerConstants.ACTION_NEW_MEMO);
                intent2.setFlags(ComposerConstants.ACTIVITY_FLAG_CALLEE);
                intent2.putExtra(ComposerConstants.NEW_MEMO_FROM_PICKER, intExtra);
                intent2.putExtra("tool_type", 1);
                if (Intrinsics.areEqual(getProviderName(), BaseWidgetConstant.WIDGET_SINGLE_MEDIUM_COVER_PROVIDER_NAME) || Intrinsics.areEqual(getProviderName(), "WidgetSingleLargeCoverProvider") || Intrinsics.areEqual(getProviderName(), "WidgetSingleExtraLargeCoverProvider")) {
                    PendingIntent activity = PendingIntent.getActivity(context, 0, intent2, 201326592);
                    Object systemService = context.getSystemService("keyguard");
                    Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.KeyguardManager");
                    Intent intent3 = new Intent();
                    intent3.putExtra("showCoverToast", true);
                    intent3.putExtra("ignoreKeyguardState", true);
                    KeyguardManagerCompat companion = KeyguardManagerCompat.INSTANCE.getInstance();
                    Intrinsics.checkNotNull(activity);
                    companion.semSetPendingIntentAfterUnlock(context, activity, intent3);
                } else {
                    context.startActivity(intent2);
                }
            } else {
                Intent intent4 = new Intent(context, NoteListAccessHandler.getNotePickerClass());
                intent4.setFlags(403177472);
                intent4.putExtra(WidgetConstant.EXTRA_KEY_WIDGET_PICK_MEMO, true);
                intent4.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, intExtra);
                intent4.putExtra(WidgetConstant.Pick.TYPE, 1);
                BaseWidgetPreferenceManager.Companion companion2 = BaseWidgetPreferenceManager.INSTANCE;
                intent4.putExtra(BaseWidgetConstant.EXTRA_KEY_WIDGET_TRANSPARENCY, companion2.getTransparency(intExtra));
                if (BaseWidgetUtils.INSTANCE.isSupportedNewWidget()) {
                    intent4.putExtra(BaseWidgetConstant.EXTRA_KEY_WIDGET_BACKGROUND_COLOR, companion2.getBackgroundColor(intExtra));
                    intent4.putExtra(BaseWidgetConstant.EXTRA_KEY_WIDGET_DARK_MODE, companion2.getDarkMode(intExtra));
                    intent4.putExtra(BaseWidgetConstant.KEY_WIDGET_MATCH_SETTING, companion2.getWidgetMatchSetting(intExtra));
                    intent4.putExtra(BaseWidgetConstant.KEY_WIDGET_BACKGROUND_SHAPE, companion2.getWidgetBackgroundShape(intExtra));
                    intent4.putExtra(BaseWidgetConstant.KEY_WIDGET_BACKGROUND_ON_OFF, companion2.getWidgetBackgroundOnOff(intExtra));
                    intent4.putExtra(WidgetConstant.WIDGET_PROVIDER_NAME, getProviderName());
                }
                if (Intrinsics.areEqual(getProviderName(), BaseWidgetConstant.WIDGET_SINGLE_MEDIUM_COVER_PROVIDER_NAME) || Intrinsics.areEqual(getProviderName(), "WidgetSingleLargeCoverProvider") || Intrinsics.areEqual(getProviderName(), "WidgetSingleExtraLargeCoverProvider")) {
                    intent4.setAction(WidgetConstant.ACTION_MEMO_PICK_COVER);
                    Display displayForSubAlert = providerUtils.getDisplayForSubAlert(context);
                    if (displayForSubAlert != null) {
                        intent4.addFlags(75497472);
                        ActivityOptions activityOptionsMakeBasic = ActivityOptions.makeBasic();
                        activityOptionsMakeBasic.setLaunchDisplayId(displayForSubAlert.getDisplayId());
                        context.startActivity(intent4, activityOptionsMakeBasic.toBundle());
                    }
                } else {
                    intent4.setAction(WidgetConstant.ACTION_MEMO_PICK);
                    context.startActivity(intent4);
                }
            }
            setPreviousEventTime(jCurrentTimeMillis + 1000);
        }
    }

    public final void setPreviousEventTime(long time) {
        INSTANCE.setEventTime(time);
    }

    public void updateGlance(@NotNull Context context, @NotNull GlanceAppWidgetManager glanceManager, int appWidgetId, @NotNull String typeWidgetView) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(glanceManager, "glanceManager");
        Intrinsics.checkNotNullParameter(typeWidgetView, "typeWidgetView");
        long jCurrentTimeMillis = System.currentTimeMillis();
        BaseWidgetPreferenceManager.Companion companion = BaseWidgetPreferenceManager.INSTANCE;
        int transparency = companion.getTransparency(appWidgetId);
        int backgroundColor = companion.getBackgroundColor(appWidgetId);
        int darkMode = companion.getDarkMode(appWidgetId);
        boolean widgetMatchSetting = companion.getWidgetMatchSetting(appWidgetId);
        boolean widgetBackgroundOnOff = companion.getWidgetBackgroundOnOff(appWidgetId);
        int widgetBackgroundShape = companion.getWidgetBackgroundShape(appWidgetId);
        String filePath = WidgetPreferenceManager.INSTANCE.getFilePath(appWidgetId);
        if (filePath == null) {
            filePath = BaseWidgetConstant.NONE;
        }
        String uuid = companion.getUUID(appWidgetId);
        StringBuilder sb = new StringBuilder("onUpdate: timeUpdate: ");
        sb.append(jCurrentTimeMillis);
        sb.append(", appWidgetId: ");
        sb.append(appWidgetId);
        AbstractC2821a.m2207B(sb, ", typeWidgetView: ", typeWidgetView, ", uuid: ", uuid);
        sb.append(", filePath: ");
        sb.append(filePath);
        sb.append(", transparency: ");
        sb.append(transparency);
        AbstractC0622a.m1180z(sb, backgroundColor, darkMode, ", backgroundColor: ", ", darkMode: ");
        sb.append(", matchSetting: ");
        sb.append(widgetMatchSetting);
        sb.append(", backgroundOnOff: ");
        sb.append(widgetBackgroundOnOff);
        sb.append(", backgroundShape: ");
        sb.append(widgetBackgroundShape);
        Logger.m8702i("WidgetProvider", sb.toString());
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C69101(context, glanceManager.getGlanceIdBy(appWidgetId), this, jCurrentTimeMillis, typeWidgetView, transparency, backgroundColor, darkMode, widgetMatchSetting, widgetBackgroundOnOff, widgetBackgroundShape, filePath, uuid, null), 3, null);
    }

    private final RemoteViews makeWidgetListView(Context context, int appWidgetId, String uuid, boolean isSaveSkip, String caller) {
        return makeWidgetListView(context, appWidgetId, uuid, null, isSaveSkip, caller);
    }

    private final RemoteViews makeWidgetListView(Context context, int appWidgetId, String uuid, String noteFilePath, boolean isSaveSkip, String caller) {
        String path;
        WidgetUtils.Companion companion = WidgetUtils.INSTANCE;
        WidgetLogger.m5155i("WidgetProvider", "makeWidgetListView# start widgetId: " + appWidgetId + SQLKeyword.COMMA + companion.printWidgetOptions(context, null, appWidgetId));
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), getLayoutId(context, appWidgetId));
        NotesDocumentRepository notesDocumentRepositoryCreateDocumentDataRepository = NotesDataRepositoryFactory.newInstance(context).createDocumentDataRepository();
        Intrinsics.checkNotNullExpressionValue(notesDocumentRepositoryCreateDocumentDataRepository, "createDocumentDataRepository(...)");
        if (noteFilePath == null) {
            path = notesDocumentRepositoryCreateDocumentDataRepository.getPath(String.valueOf(uuid));
            if (path != null) {
                WidgetPreferenceManager.INSTANCE.saveWidgetPrefFilePath(appWidgetId, path);
            }
        } else {
            path = noteFilePath;
        }
        if (path == null) {
            WidgetLogger.m5154d("WidgetProvider", "makeWidgetListView# noteFilePath is null.");
            ToastHandler.show(context, C11391R.string.unable_to_open_note, 0);
            WidgetPreferenceManager.saveWidgetPref$default(WidgetPreferenceManager.INSTANCE, appWidgetId, BaseWidgetConstant.NONE, null, 4, null);
            return makeEmptyWidgetView(context, appWidgetId, caller);
        }
        WidgetLogger widgetLogger = WidgetLogger.INSTANCE;
        String encode = widgetLogger.getEncode(String.valueOf(uuid));
        boolean zIsSaving = notesDocumentRepositoryCreateDocumentDataRepository.isSaving(String.valueOf(uuid), Process.myPid());
        NotesDocumentEntity notesDocumentEntity = notesDocumentRepositoryCreateDocumentDataRepository.get(String.valueOf(uuid));
        if (notesDocumentEntity == null) {
            WidgetLogger.m5154d("WidgetProvider", "makeWidgetListView# mainListEntry is null.");
            return makeEmptyWidgetView(context, appWidgetId, caller);
        }
        WidgetLogger.m5155i("WidgetProvider", "makeWidgetListView# uuid : " + encode + ", isSaving: " + zIsSaving);
        if (!isSaveSkip && zIsSaving) {
            WidgetLogger.m5154d("WidgetProvider", "makeWidgetListView# uuid : " + encode + ", in saving.");
            remoteViews.setViewVisibility(C11391R.id.widget_content_layout, 8);
            remoteViews.setViewVisibility(C11391R.id.widget_loading_layout, 0);
            return remoteViews;
        }
        WidgetLogger.m5155i("WidgetProvider", "makeWidgetListView# uuid : " + encode + " path : " + widgetLogger.getEncode(path));
        if (!AbstractC2322a.m1607A(path)) {
            widgetLogger.m5157e("WidgetProvider", "makeWidgetListView# path is not exist. path : " + widgetLogger.getEncode(path));
            return makeEmptyWidgetView(context, appWidgetId, caller);
        }
        try {
            SpenSdkInitializer.initialize(context);
            SpenComposerSdkInitializer.initialize(context);
            String title = notesDocumentEntity.getTitle();
            Intrinsics.checkNotNullExpressionValue(title, "getTitle(...)");
            boolean z = !companion.isSupportSettingByQuickOption();
            setWidgetTitle(context, remoteViews, title);
            CacheFileManager.Companion companion2 = CacheFileManager.INSTANCE;
            if (!companion2.getInstance().isInitialized()) {
                companion2.getInstance().init(context);
            }
            if (companion2.getInstance().isValidFiles(String.valueOf(uuid)) && !companion2.getInstance().isCacheFilesCleared(context, String.valueOf(uuid)) && companion2.getInstance().isCreateWidgetState(context, String.valueOf(uuid), appWidgetId)) {
                WidgetLogger.m5154d("WidgetProvider", "makeWidgetListView# " + appWidgetId + ", display - " + context.getResources().getDisplayMetrics());
                setClickPendingIntent(context, appWidgetId, remoteViews);
                setListAdapter(context, appWidgetId, uuid, path, remoteViews, title);
                setOptionIcon(remoteViews, title, companion2.getInstance().existVoiceRecording(String.valueOf(uuid)), z);
                ProviderUtils.INSTANCE.convertOpacity(appWidgetId);
                new ShowNoteThemeManager().applyThemeToWidgetFrame(context, remoteViews, new ThemeInfo(context, appWidgetId), companion2.getInstance().getPageColor(String.valueOf(uuid)), companion2.getInstance().hasBackgroundImage(String.valueOf(uuid)));
                WidgetLogger.m5155i("WidgetProvider", "makeWidgetListView# done " + appWidgetId);
                return remoteViews;
            }
            companion2.getInstance().createCacheInfo(context, String.valueOf(uuid), path, appWidgetId);
            WidgetPreferenceManager.INSTANCE.saveUpdateWidgetContentDone(appWidgetId, false);
            widgetLogger.m5157e("WidgetProvider", "makeWidgetListView# wait cache loading, mAppWidgetId: " + appWidgetId);
            return remoteViews;
        } catch (Exception e) {
            WidgetLogger.INSTANCE.m5158e("WidgetProvider", "makeWidgetListView# fail to open SpenSDoc", e);
            ToastHandler.show(context, C11391R.string.unable_to_open_note, 0);
            WidgetPreferenceManager.saveWidgetPref$default(WidgetPreferenceManager.INSTANCE, appWidgetId, BaseWidgetConstant.NONE, null, 4, null);
            return makeEmptyWidgetView(context, appWidgetId, caller);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateAppWidgetAndNotify(Context context, int appWidgetId, String uuid, int listId, String caller) {
        RemoteViews remoteViewsMakeWidgetListView = makeWidgetListView(context, appWidgetId, uuid, null, true, caller);
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        Intrinsics.checkNotNullExpressionValue(appWidgetManager, "getInstance(...)");
        updateAppWidgetAndNotify(appWidgetManager, appWidgetId, listId, remoteViewsMakeWidgetListView, caller);
    }

    private final void updateAppWidgetAndNotify(AppWidgetManager appWidgetManager, int appWidgetId, int listId, RemoteViews remoteViews, String caller) {
        WidgetLogger.m5155i("WidgetProvider", "updateAppWidget# widgetId = " + appWidgetId + "/ caller = " + caller);
        appWidgetManager.updateAppWidget(appWidgetId, remoteViews);
        WidgetLogger.m5155i("WidgetProvider", "notifyAppWidgetViewDataChanged# widgetId = " + appWidgetId + "/ caller = " + caller);
        appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetId, listId);
    }
}
