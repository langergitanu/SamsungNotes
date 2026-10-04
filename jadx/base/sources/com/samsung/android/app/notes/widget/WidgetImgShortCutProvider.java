package com.samsung.android.app.notes.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.app.notes.widget.capture.CacheFileManager;
import com.samsung.android.app.notes.widget.common.ConvertConfirmDialogActivity;
import com.samsung.android.app.notes.widget.common.constants.WidgetConstant;
import com.samsung.android.app.notes.widget.common.log.WidgetLogger;
import com.samsung.android.app.notes.widget.dialog.StorageErrorDialogActivity;
import com.samsung.android.app.notes.widget.preference.WidgetPreferenceManager;
import com.samsung.android.app.notes.widget.theme.ShortcutThemeManager;
import com.samsung.android.app.notes.widget.theme.ThemeInfo;
import com.samsung.android.app.notes.widget.util.ProviderUtils;
import com.samsung.android.app.notes.widget.util.WidgetBRHelper;
import com.samsung.android.app.notes.widget.util.WidgetUtils;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.base.common.access.composer.ComposerAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.access.notelist.NoteListAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.access.widgetaccess.WidgetAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.NotesSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.sdk.util.SpenComposerSdkInitializer;
import com.samsung.android.support.senl.p148nt.base.common.sdk.util.SpenSdkInitializer;
import com.samsung.android.support.senl.p148nt.base.common.util.HomeScreenUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.StorageUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.widget.preference.BaseWidgetPreferenceManager;
import com.samsung.android.support.senl.p148nt.base.widget.util.BaseWidgetUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mde.MdeInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesDocumentRepository;
import com.samsung.android.support.senl.p148nt.homewidget.C11391R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p044K.C0158a;
import p259y0.AbstractC14517a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u0000 H2\u00020\u0001:\u0001HB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J*\u0010\u0010\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J0\u0010\u0010\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J2\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J(\u0010\u0019\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J \u0010\u001a\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010\u001b\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010\u001c\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J2\u0010\u001f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010 \u001a\u0004\u0018\u00010!2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010#2\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J \u0010$\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J(\u0010$\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J*\u0010%\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J2\u0010%\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010&\u001a\u00020'2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J<\u0010%\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010(\u001a\u0004\u0018\u00010\u00172\u0006\u0010&\u001a\u00020'2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J:\u0010)\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010*\u001a\u00020\u0017H\u0002J \u0010+\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J \u0010,\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u0017H\u0002J(\u0010-\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010.\u001a\u00020/H\u0016J\u0018\u00100\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u0012H\u0002J \u00102\u001a\u00020'2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J \u00103\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\u000fH\u0016J \u00106\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\"\u00107\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\"\u00108\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J6\u00109\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010 \u001a\u0004\u0018\u00010!2\u001a\u0010:\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170;j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0017`<H\u0002J\u001a\u0010=\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0002J \u0010>\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010?\u001a\u00020@H\u0002J,\u0010A\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010B\u001a\u0004\u0018\u00010\u0017H\u0002J(\u0010C\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010?\u001a\u00020@2\u0006\u0010D\u001a\u00020'H\u0002J \u0010E\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010?\u001a\u00020@H\u0002J\u0010\u0010F\u001a\u00020\t2\u0006\u0010G\u001a\u00020@H\u0002R\u0015\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006I"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/WidgetImgShortCutProvider;", "Landroid/appwidget/AppWidgetProvider;", "<init>", "()V", "this", "Ljava/lang/Class;", "getThis", "()Ljava/lang/Class;", "onUpdate", "", "context", "Landroid/content/Context;", "appWidgetManager", "Landroid/appwidget/AppWidgetManager;", "appWidgetIds", "", "updateAppWidgetAndNotify", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "", "remoteViews", "Landroid/widget/RemoteViews;", "listId", NotesConstants.KEY_CALLER, "", "uuid", "updateNoFilePathWidget", "makeEmptyWidgetView", "makeConvertWidgetView", "onReceive", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "updateWidgetByCache", "provider", "Landroid/content/ComponentName;", "widgetIds", "", "makeEmptyContent", "makeContent", "isSaveSkip", "", "noteFilePath", "setListAdapter", "title", "setClickPendingIntent", "setWidgetTitle", "onAppWidgetOptionsChanged", "newOptions", "Landroid/os/Bundle;", "getLayoutId", "widgetId", "isDeleteNote", "onRestored", "oldWidgetIds", "newWidgetIds", "updateWidget", "updateWidgetByUUID", "deleteWidget", "deleteWidgetByUUIDList", "uuidList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "updateAllWidget", "openMemoListFromWidget", "previousEventTime", "", "updateWidgetByConvertUUID", "newUuid", "pickMemoListFromWidget", "checkWidgetCount", "convertFromWidget", "setPreviousEventTime", "time", "Companion", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WidgetImgShortCutProvider extends AppWidgetProvider {
    public static final long SKIP_TIME = 1000;

    @NotNull
    private static final String TAG = "WidgetImgShortCutProvider";
    private static long mPreviousEventTime;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/WidgetImgShortCutProvider$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "SKIP_TIME", "", "mPreviousEventTime", "setEventTime", "", "time", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void setEventTime(long time) {
            WidgetImgShortCutProvider.mPreviousEventTime = time;
        }

        private Companion() {
        }
    }

    private final void convertFromWidget(Context context, Intent intent, long previousEventTime) {
        WidgetLogger.m5154d(TAG, "convertFromWidget#");
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
                WidgetLogger.m5154d(TAG, sbM1629s.toString());
                Intent intent2 = new Intent(context, (Class<?>) ConvertConfirmDialogActivity.class);
                intent2.setAction(WidgetConstant.ACTION_MEMO_CONVERT);
                intent2.putExtra("sdoc_uuid", uuid);
                intent2.putExtra("doc_path", path);
                intent2.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, intExtra);
                intent2.setFlags(402653184);
                context.startActivity(intent2);
            } else {
                WidgetLogger.m5154d(TAG, "convertFromWidget# widgetId : " + intExtra + "uuid : " + encode);
                providerUtils.openMemoList(context);
            }
            setPreviousEventTime(jCurrentTimeMillis + 1000);
        }
    }

    private final void deleteWidget(Context context, ComponentName provider, String uuid) {
        WidgetLogger.m5154d(TAG, "deleteWidget#");
        for (int i : AppWidgetManager.getInstance(context).getAppWidgetIds(provider)) {
            if (Intrinsics.areEqual(uuid, BaseWidgetPreferenceManager.INSTANCE.getUUID(i))) {
                WidgetPreferenceManager.deleteWidgetPref(i, false);
                updateWidget(context, i, "deleteWidget");
            }
        }
    }

    private final void deleteWidgetByUUIDList(Context context, ComponentName provider, ArrayList<String> uuidList) {
        WidgetLogger.m5154d(TAG, "deleteWidgetByUUIDList#");
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        for (int i : appWidgetManager.getAppWidgetIds(provider)) {
            if (uuidList.contains(BaseWidgetPreferenceManager.INSTANCE.getUUID(i))) {
                WidgetPreferenceManager.deleteWidgetPref(i, false);
                Intrinsics.checkNotNull(appWidgetManager);
                onUpdate(context, appWidgetManager, new int[]{i});
            }
        }
    }

    private final int getLayoutId(Context context, int widgetId) {
        return BaseWidgetUtils.INSTANCE.getWidgetLayoutId(context, widgetId, C11391R.layout.widget_shortcut_portrait_phone_layout, C11391R.layout.widget_shortcut_phone_layout, C11391R.layout.widget_img_shortcut_layout);
    }

    private final boolean isDeleteNote(Context context, String uuid, int appWidgetId) {
        NotesDocumentRepository notesDocumentRepositoryCreateDocumentDataRepository = NotesDataRepositoryFactory.newInstance(context).createDocumentDataRepository();
        Intrinsics.checkNotNullExpressionValue(notesDocumentRepositoryCreateDocumentDataRepository, "createDocumentDataRepository(...)");
        if (notesDocumentRepositoryCreateDocumentDataRepository.get(uuid) != null && notesDocumentRepositoryCreateDocumentDataRepository.get(uuid).getIsDeleted() == 0) {
            return false;
        }
        WidgetLogger.m5156w(TAG, "isDeleteNote# removeAppWidget - " + appWidgetId);
        CacheFileManager.INSTANCE.getInstance().removeCacheInfo(context, uuid);
        deleteWidget(context, new ComponentName(context, getThis()), uuid);
        return true;
    }

    private final RemoteViews makeContent(Context context, int appWidgetId, String uuid, String caller) {
        return makeContent(context, appWidgetId, uuid, false, caller);
    }

    private final RemoteViews makeConvertWidgetView(Context context, int appWidgetId) {
        WidgetLogger.m5155i(TAG, "makeConvertWidgetView#");
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), getLayoutId(context, appWidgetId));
        remoteViews.setViewVisibility(C11391R.id.widget_img_shortcut_list_view, 8);
        remoteViews.setViewVisibility(C11391R.id.widget_img_shortcut_title, 8);
        remoteViews.setViewVisibility(C11391R.id.widget_img_shortcut_empty_container, 8);
        remoteViews.setViewVisibility(C11391R.id.widget_loading_layout, 8);
        remoteViews.setViewVisibility(C11391R.id.widget_img_shortcut_convert_text, 0);
        remoteViews.setInt(C11391R.id.background, BaseWidgetConstant.SET_IMAGE_RESOURCE, C11391R.drawable.widget_short_background_white);
        remoteViews.setInt(C11391R.id.background, BaseWidgetConstant.SET_IMAGE_ALPHA, BaseWidgetUtils.INSTANCE.convertAlpha(WidgetUtils.INSTANCE.getEmptyWidgetAlpha()));
        Intent intent = new Intent(context, getThis());
        intent.setAction(WidgetConstant.ACTION_MEMO_CONVERT);
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, appWidgetId);
        remoteViews.setOnClickPendingIntent(C11391R.id.widget_img_shortcut_container, PendingIntent.getBroadcast(context, appWidgetId, intent, 201326592));
        remoteViews.setContentDescription(C11391R.id.widget_img_shortcut_container, context.getResources().getString(C11391R.string.widget_convert_document) + "," + context.getResources().getString(C11391R.string.memolist_category_content_description_button));
        return remoteViews;
    }

    private final RemoteViews makeEmptyContent(Context context, int appWidgetId, String caller) {
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), getLayoutId(context, appWidgetId));
        makeEmptyContent(context, appWidgetId, remoteViews, caller);
        return remoteViews;
    }

    private final RemoteViews makeEmptyWidgetView(Context context, int appWidgetId, String caller) {
        return makeContent(context, appWidgetId, null, caller);
    }

    private final void openMemoListFromWidget(Context context, Intent intent, long previousEventTime) {
        WidgetLogger.m5154d(TAG, "openMemoListFromWidget#");
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
                    WidgetLogger.m5156w(TAG, "openMemoListFromWidget# need to convert");
                    updateWidget(context, intExtra, "openMemoListAndConvert");
                    return;
                }
                NotesDocumentRepository notesDocumentRepositoryCreateDocumentDataRepository = NotesDataRepositoryFactory.newInstance(context).createDocumentDataRepository();
                Intrinsics.checkNotNullExpressionValue(notesDocumentRepositoryCreateDocumentDataRepository, "createDocumentDataRepository(...)");
                String path = notesDocumentRepositoryCreateDocumentDataRepository.getPath(uuid);
                WidgetLogger widgetLogger = WidgetLogger.INSTANCE;
                String encode = widgetLogger.getEncode(uuid);
                if (path != null) {
                    WidgetLogger.m5154d(TAG, "openMemoListFromWidget# widgetId : " + intExtra + " uuid : " + encode + " path :" + widgetLogger.getEncode(path));
                    if (ComposerAccessHandler.getComposerActivityClass() == null) {
                        PostLaunchManager.INSTANCE.getInstance().executeBaseLogic(1);
                    }
                    Intent intent3 = new Intent(context, ComposerAccessHandler.getComposerActivityClass());
                    if (C0158a.m407a().m415h()) {
                        MdeInfo mdeInfo = new MdeInfo(notesDocumentRepositoryCreateDocumentDataRepository.get(uuid).getMdeSpaceId(), notesDocumentRepositoryCreateDocumentDataRepository.get(uuid).getMdeGroupId(), notesDocumentRepositoryCreateDocumentDataRepository.get(uuid).getMdeOwnerId(), "test", AbstractC14517a.m15166z(context, uuid) ? 1 : 2);
                        if (!TextUtils.isEmpty(mdeInfo.getSpaceId())) {
                            WidgetLogger.m5154d(TAG, "openMemoListFromWidget# this is mde file");
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
                    context.startActivity(intent3);
                } else {
                    WidgetLogger.m5154d(TAG, "openMemoListFromWidget# widgetId : " + intExtra + "uuid : " + encode);
                    providerUtils.openMemoList(context);
                }
                setPreviousEventTime(jCurrentTimeMillis + 1000);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void pickMemoListFromWidget(Context context, Intent intent, long previousEventTime, boolean checkWidgetCount) {
        WidgetLogger.m5154d(TAG, "pickMemoListFromWidget#");
        long jCurrentTimeMillis = System.currentTimeMillis();
        ProviderUtils providerUtils = ProviderUtils.INSTANCE;
        if (providerUtils.checkEventTime(jCurrentTimeMillis, previousEventTime, 1000L)) {
            if (WidgetAccessHandler.INSTANCE.getWidgetResolverClass() == null || NoteListAccessHandler.getNotePickerClass() == null) {
                PostLaunchManager.INSTANCE.getInstance().executeBaseLogic(1);
            }
            int allNoteCount = NotesDataRepositoryFactory.newInstance(context).createMainListDocumentDataRepository().getAllNoteCount(0, true);
            int intExtra = intent.getIntExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, -1);
            if (checkWidgetCount && !providerUtils.isAvailableToReferWidget(context, getThis(), intExtra)) {
                WidgetUtils.Companion.showWidgetMaximumToast$default(WidgetUtils.INSTANCE, context, 0, 2, null);
            } else if (allNoteCount == 0) {
                Intent intent2 = new Intent(context, ComposerAccessHandler.getComposerActivityClass());
                intent2.setAction(ComposerConstants.ACTION_NEW_MEMO);
                intent2.setFlags(ComposerConstants.ACTIVITY_FLAG_CALLEE);
                intent2.putExtra(ComposerConstants.NEW_MEMO_FROM_PICKER, intExtra);
                intent2.putExtra("tool_type", 1);
                context.startActivity(intent2);
            } else {
                Intent intent3 = new Intent(context, NoteListAccessHandler.getNotePickerClass());
                intent3.setAction(WidgetConstant.ACTION_MEMO_PICK);
                intent3.setFlags(403177472);
                intent3.putExtra(WidgetConstant.EXTRA_KEY_WIDGET_PICK_MEMO, true);
                intent3.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, intExtra);
                intent3.putExtra(WidgetConstant.Pick.TYPE, 1);
                context.startActivity(intent3);
            }
            setPreviousEventTime(jCurrentTimeMillis + 1000);
        }
    }

    private final void setClickPendingIntent(Context context, RemoteViews remoteViews, int appWidgetId) {
        Intent intent = new Intent(context, getThis());
        intent.setAction(WidgetConstant.OPEN_MEMO_LIST_FROM_WIDGET);
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, appWidgetId);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, appWidgetId, intent, 201326592);
        remoteViews.setPendingIntentTemplate(C11391R.id.widget_img_shortcut_list_view, broadcast);
        remoteViews.setOnClickPendingIntent(C11391R.id.widget_img_shortcut_container, broadcast);
    }

    private final void setListAdapter(Context context, RemoteViews remoteViews, int appWidgetId, String noteFilePath, String uuid, String title) {
        Intent intent = new Intent(context, (Class<?>) WidgetImgShortcutService.class);
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, appWidgetId);
        intent.putExtra(WidgetConstant.EXTRA_KEY_FILE_PATH, noteFilePath);
        intent.putExtra(WidgetConstant.EXTRA_KEY_UUID, uuid);
        intent.putExtra(WidgetConstant.EXTRA_KEY_TITLE, title);
        intent.setData(Uri.parse(intent.toUri(1)));
        remoteViews.setRemoteAdapter(C11391R.id.widget_img_shortcut_list_view, intent);
    }

    private final void setPreviousEventTime(long time) {
        INSTANCE.setEventTime(time);
    }

    private final void setWidgetTitle(Context context, RemoteViews remoteViews, String title) {
        ProviderUtils.INSTANCE.setWidgetTitle(context, remoteViews, title, !TextUtils.isEmpty(title), C11391R.id.widget_img_shortcut_title_layout, C11391R.id.widget_img_shortcut_title, C11391R.id.widget_img_shortcut_shadow_title);
    }

    private final void updateAllWidget(Context context, ComponentName provider) {
        WidgetLogger.m5154d(TAG, "updateAllWidget#");
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
            WidgetLogger.INSTANCE.m5158e(TAG, "updateAllWidget# ", e);
        }
    }

    private final void updateAppWidgetAndNotify(AppWidgetManager appWidgetManager, int appWidgetId, RemoteViews remoteViews, int listId) {
        if (remoteViews != null) {
            updateAppWidgetAndNotify(appWidgetManager, appWidgetId, listId, remoteViews, "onUpdate");
            return;
        }
        WidgetLogger.INSTANCE.m5157e(TAG, "updateAppWidgetAndNotify# remoteViews is null from id = " + appWidgetId + "/ caller = onUpdate");
    }

    private final RemoteViews updateNoFilePathWidget(Context context, String uuid, int appWidgetId, String caller) {
        WidgetLogger.m5154d(TAG, "updateNoFilePathWidget#");
        if (!Intrinsics.areEqual(uuid, BaseWidgetConstant.NONE)) {
            if (ProviderUtils.INSTANCE.isMakeWidgetContent(context, uuid)) {
                return makeContent(context, appWidgetId, uuid, null, false, caller);
            }
            WidgetLogger.m5154d(TAG, "updateNoFilePathWidget# onUpdate : deleted - " + WidgetLogger.INSTANCE.getEncode(uuid));
            return makeEmptyWidgetView(context, appWidgetId, caller);
        }
        String pinUUID = WidgetPreferenceManager.getPinUUID();
        WidgetLogger.m5154d(TAG, "updateNoFilePathWidget# onUpdate : pinUUID - " + pinUUID);
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
        return makeContent(context, appWidgetId, pinUUID, pinFilePath, false, caller);
    }

    private final void updateWidget(Context context, int widgetId, String caller) {
        WidgetLogger.m5155i(TAG, "updateWidget# " + widgetId + " : " + caller);
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        Intrinsics.checkNotNull(appWidgetManager);
        onUpdate(context, appWidgetManager, new int[]{widgetId});
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

    private final void updateWidgetByConvertUUID(Context context, ComponentName provider, String uuid, String newUuid) {
        String str;
        int[] appWidgetIds = AppWidgetManager.getInstance(context).getAppWidgetIds(provider);
        if (TextUtils.isEmpty(uuid)) {
            WidgetLogger.INSTANCE.m5157e(TAG, "updateWidgetByConvertUUID# uuid is null or empty");
            return;
        }
        if (TextUtils.isEmpty(newUuid)) {
            WidgetLogger.INSTANCE.m5157e(TAG, "updateWidgetByConvertUUID# new uuid is null or empty");
            return;
        }
        int length = appWidgetIds.length;
        int i = 0;
        while (i < length) {
            int i2 = appWidgetIds[i];
            if (Intrinsics.areEqual(uuid, BaseWidgetPreferenceManager.INSTANCE.getUUID(i2))) {
                str = newUuid;
                WidgetPreferenceManager.saveWidgetPref$default(WidgetPreferenceManager.INSTANCE, i2, str, null, 4, null);
                updateWidget(context, i2, "updateWidgetByConvertUUID");
            } else {
                str = newUuid;
            }
            i++;
            newUuid = str;
        }
    }

    private final void updateWidgetByUUID(Context context, ComponentName provider, String uuid) {
        int[] appWidgetIds = AppWidgetManager.getInstance(context).getAppWidgetIds(provider);
        if (TextUtils.isEmpty(uuid)) {
            WidgetLogger.INSTANCE.m5157e(TAG, "updateWidgetByUUID# uuid is null or empty");
            return;
        }
        for (int i : appWidgetIds) {
            String uuid2 = BaseWidgetPreferenceManager.INSTANCE.getUUID(i);
            if (Intrinsics.areEqual(uuid, uuid2)) {
                ProviderUtils.INSTANCE.removePreviousCache(context, uuid2);
                updateWidget(context, i, "updateWidgetByUUID");
            }
        }
    }

    @NotNull
    public final Class<?> getThis() {
        return WidgetImgShortCutProvider.class;
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onAppWidgetOptionsChanged(@NotNull Context context, @NotNull AppWidgetManager appWidgetManager, int appWidgetId, @NotNull Bundle newOptions) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appWidgetManager, "appWidgetManager");
        Intrinsics.checkNotNullParameter(newOptions, "newOptions");
        WidgetLogger.m5155i(TAG, "onAppWidgetOptionsChanged# " + appWidgetId + SQLKeyword.COMMA + WidgetUtils.INSTANCE.printWidgetOptions(context, newOptions, appWidgetId));
        super.onAppWidgetOptionsChanged(context, appWidgetManager, appWidgetId, newOptions);
        AppWidgetUtils.INSTANCE.deleteOldWidgetBackupData(appWidgetManager, appWidgetId);
        int i = newOptions.getInt("appWidgetMinWidth");
        int i2 = newOptions.getInt("appWidgetMaxWidth");
        SharedPreferences sharedPreferences = context.getSharedPreferences(BaseWidgetConstant.WIDGET_PREFERENCES, 0);
        int i4 = sharedPreferences.getInt(WidgetConstant.WIDGET_MAX_WIDTH + appWidgetId, -1);
        int i5 = sharedPreferences.getInt(WidgetConstant.WIDGET_MIN_WIDTH + appWidgetId, -1);
        int i6 = C11391R.id.widget_img_shortcut_list_view;
        if (i != i5 || i2 != i4) {
            StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "onAppWidgetOptionsChanged# ", " - ", " | ");
            sbM1173s.append(i5);
            sbM1173s.append(" - ");
            sbM1173s.append(i4);
            WidgetLogger.m5154d(TAG, sbM1173s.toString());
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putInt(WidgetConstant.WIDGET_MAX_WIDTH + appWidgetId, i2);
            editorEdit.putInt(WidgetConstant.WIDGET_MIN_WIDTH + appWidgetId, i);
            editorEdit.apply();
        }
        String uuid = BaseWidgetPreferenceManager.INSTANCE.getUUID(appWidgetId);
        if (isDeleteNote(context, uuid, appWidgetId)) {
            return;
        }
        if (BaseWidgetUtils.INSTANCE.isDarkModeChange(context, appWidgetId)) {
            if (Intrinsics.areEqual(BaseWidgetConstant.NONE, uuid)) {
                ProviderUtils.INSTANCE.updateAppWidget(appWidgetManager, appWidgetId, makeEmptyContent(context, appWidgetId, "onAppWidgetOptionsChanged. updateEmptyAppWidget dark"), "onAppWidgetOptionsChanged. updateEmptyAppWidget dark");
                return;
            } else {
                updateAppWidgetAndNotify(context, appWidgetId, uuid, i6, "onAppWidgetOptionsChanged. updateAppWidget dark");
                return;
            }
        }
        if (ProviderUtils.INSTANCE.isTextOnlyNote(context, uuid)) {
            if (i == i5 && i2 == i4) {
                return;
            }
            updateAppWidgetAndNotify(context, appWidgetId, uuid, i6, "onAppWidgetOptionsChanged. updateAppWidget ");
        }
    }

    @Override // android.appwidget.AppWidgetProvider, android.content.BroadcastReceiver
    public void onReceive(@NotNull Context context, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onReceive(context, intent);
        String action = intent.getAction();
        ComponentName componentName = new ComponentName(context, getThis());
        WidgetLogger.m5155i(TAG, "onReceive# action : " + action + ", RequestTime : " + System.currentTimeMillis() + " PreviousEventTime : " + mPreviousEventTime);
        if (Intrinsics.areEqual(BaseWidgetConstant.ACTION_APPWIDGET_UPDATE, action)) {
            NotesSamsungAnalytics.INSTANCE.insertStatusLog("9978", BaseWidgetUtils.INSTANCE.getWidgetCount(context, getThis()));
        }
        if (Intrinsics.areEqual(WidgetConstant.ACTION_MEMO_PICK_DONE, action)) {
            int intExtra = intent.getIntExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, -1);
            ProviderUtils providerUtils = ProviderUtils.INSTANCE;
            if (providerUtils.isCurrentProviderWidget(context, new ComponentName(context, getThis()), intExtra)) {
                String stringExtra = intent.getStringExtra(WidgetConstant.EXTRA_KEY_UUID);
                String stringExtra2 = intent.getStringExtra(WidgetConstant.EXTRA_KEY_FILE_PATH);
                int intExtra2 = intent.getIntExtra(BaseWidgetConstant.EXTRA_KEY_WIDGET_TRANSPARENCY, -1);
                int intExtra3 = intent.getIntExtra(BaseWidgetConstant.EXTRA_KEY_WIDGET_BACKGROUND_COLOR, -1);
                int intExtra4 = intent.getIntExtra(BaseWidgetConstant.EXTRA_KEY_WIDGET_DARK_MODE, -1);
                if (intExtra2 == -1) {
                    int i = BaseWidgetUtils.INSTANCE.isSupportedNewWidget() ? 75 : 100;
                    WidgetPreferenceManager.INSTANCE.saveWidgetPref(intExtra, stringExtra, stringExtra2);
                    BaseWidgetPreferenceManager.INSTANCE.saveTransparency(intExtra, i);
                } else {
                    WidgetPreferenceManager.INSTANCE.saveWidgetPref(intExtra, stringExtra, stringExtra2, intExtra2);
                }
                if (intExtra3 != -1) {
                    BaseWidgetPreferenceManager.INSTANCE.saveWidgetBackgroundColorPref(intExtra, intExtra3);
                }
                if (intExtra4 != -1) {
                    BaseWidgetPreferenceManager.INSTANCE.saveDarkModePref(intExtra, intExtra4);
                }
                WidgetPreferenceManager widgetPreferenceManager = WidgetPreferenceManager.INSTANCE;
                HomeScreenUtils homeScreenUtils = HomeScreenUtils.INSTANCE;
                widgetPreferenceManager.saveWidgetDisplayDevicePref(intExtra, homeScreenUtils.getWidgetAddDisplayType(context));
                widgetPreferenceManager.saveWidgetHomeModePref(intExtra, homeScreenUtils.getHomeMode(context));
                providerUtils.removePreviousCache(context, stringExtra);
                updateWidget(context, intExtra, "onReceive");
            }
        } else if (Intrinsics.areEqual(WidgetConstant.ACTION_MEMO_PICK_DONE_NEW_NOTE, action)) {
            int intExtra5 = intent.getIntExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, -1);
            WidgetLogger.m5154d(TAG, "onReceive# widget id : " + intExtra5);
            ProviderUtils providerUtils2 = ProviderUtils.INSTANCE;
            if (providerUtils2.isCurrentProviderWidget(context, componentName, intExtra5)) {
                String stringExtra3 = intent.getStringExtra(WidgetConstant.EXTRA_KEY_UUID);
                String stringExtra4 = intent.getStringExtra(WidgetConstant.EXTRA_KEY_FILE_PATH);
                WidgetPreferenceManager widgetPreferenceManager2 = WidgetPreferenceManager.INSTANCE;
                widgetPreferenceManager2.saveWidgetPref(intExtra5, stringExtra3, stringExtra4);
                BaseWidgetPreferenceManager.INSTANCE.saveWidgetOrientationPref(intExtra5, context.getResources().getConfiguration().orientation);
                HomeScreenUtils homeScreenUtils2 = HomeScreenUtils.INSTANCE;
                widgetPreferenceManager2.saveWidgetDisplayDevicePref(intExtra5, homeScreenUtils2.getWidgetAddDisplayType(context));
                widgetPreferenceManager2.saveWidgetHomeModePref(intExtra5, homeScreenUtils2.getHomeMode(context));
                providerUtils2.removePreviousCache(context, stringExtra3);
                AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
                Intrinsics.checkNotNull(appWidgetManager);
                onUpdate(context, appWidgetManager, new int[]{intExtra5});
            }
        } else {
            if (Intrinsics.areEqual(WidgetConstant.ACTION_MEMO_WAIT_CACHE, action)) {
                updateWidgetByCache(context, componentName, intent.getIntegerArrayListExtra(WidgetConstant.EXTRA_KEY_FROM_WIDGET_ID_LIST), C11391R.id.widget_img_shortcut_list_view);
                return;
            }
            if (Intrinsics.areEqual(WidgetConstant.ACTION_MEMO_UPDATE_UUID, action)) {
                updateWidgetByUUID(context, componentName, String.valueOf(intent.getStringExtra(WidgetConstant.EXTRA_KEY_UUID)));
                return;
            }
            if (!Intrinsics.areEqual(WidgetConstant.ACTION_MEMO_DELETE_UUID, action)) {
                if (Intrinsics.areEqual(WidgetConstant.ACTION_MEMO_UPDATE_ALL, action) || Intrinsics.areEqual(BaseWidgetConstant.TIME_SET_CHANGED, action)) {
                    updateAllWidget(context, componentName);
                    return;
                }
                if (Intrinsics.areEqual(WidgetConstant.OPEN_MEMO_LIST_FROM_WIDGET, action)) {
                    NotesSamsungAnalytics.INSTANCE.insertLog("614", "6131");
                    openMemoListFromWidget(context, intent, mPreviousEventTime);
                    return;
                }
                if (Intrinsics.areEqual(WidgetConstant.PICK_MEMO_LIST_FROM_WIDGET, action)) {
                    NotesSamsungAnalytics.INSTANCE.insertLog("614", "6132");
                    pickMemoListFromWidget(context, intent, mPreviousEventTime, false);
                    return;
                } else if (Intrinsics.areEqual(WidgetConstant.ACTION_MEMO_CONVERT, action)) {
                    convertFromWidget(context, intent, mPreviousEventTime);
                    return;
                } else {
                    if (Intrinsics.areEqual(WidgetConstant.ACTION_MEMO_CONVERT_UUID, action)) {
                        updateWidgetByConvertUUID(context, componentName, String.valueOf(intent.getStringExtra(WidgetConstant.EXTRA_KEY_UUID)), intent.getStringExtra(WidgetConstant.EXTRA_KEY_CONVERT_UUID));
                        return;
                    }
                    return;
                }
            }
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra(WidgetConstant.EXTRA_KEY_UUID);
            if (stringArrayListExtra != null) {
                CacheFileManager.INSTANCE.getInstance().removeCacheInfo(context, stringArrayListExtra);
                deleteWidgetByUUIDList(context, componentName, stringArrayListExtra);
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
        Logger.m8697d(TAG, "onRestored oldWidgetIds" + string);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0083  */
    @Override // android.appwidget.AppWidgetProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onUpdate(@NotNull Context context, @NotNull AppWidgetManager appWidgetManager, @NotNull int[] appWidgetIds) {
        int i;
        int i2;
        Context context2;
        RemoteViews remoteViewsMakeEmptyWidgetView;
        RemoteViews remoteViewsUpdateNoFilePathWidget;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appWidgetManager, "appWidgetManager");
        Intrinsics.checkNotNullParameter(appWidgetIds, "appWidgetIds");
        String string = Arrays.toString(appWidgetIds);
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        WidgetLogger.m5155i(TAG, "onUpdate# appWidgetIds: " + string);
        ComponentName componentName = new ComponentName(context, getThis());
        int length = appWidgetIds.length;
        int i4 = 0;
        while (i4 < length) {
            int i5 = appWidgetIds[i4];
            Bundle appWidgetOptions = appWidgetManager.getAppWidgetOptions(i5);
            if (appWidgetOptions != null) {
                i2 = appWidgetOptions.getInt(BaseWidgetConstant.OLD_WIDGET_ID_OPTION);
                i = appWidgetOptions.getInt(BaseWidgetConstant.NEW_WIDGET_ID_OPTION);
            } else {
                i = 0;
                i2 = 0;
            }
            WidgetBRHelper widgetBRHelper = WidgetBRHelper.INSTANCE;
            String strRestoreWidgetInfo = widgetBRHelper.restoreWidgetInfo(context, i2, i, false);
            if (widgetBRHelper.isCalledBySmartSwitch(strRestoreWidgetInfo)) {
                if (i2 == i) {
                    String uuid = BaseWidgetPreferenceManager.INSTANCE.getUUID(i2);
                    remoteViewsUpdateNoFilePathWidget = (TextUtils.isEmpty(uuid) || Intrinsics.areEqual(uuid, BaseWidgetConstant.NONE) || Intrinsics.areEqual(uuid, strRestoreWidgetInfo)) ? null : makeContent(context, i5, uuid, WidgetConstant.RECEIVE_CALLER_ON_UPDATE);
                    if (remoteViewsUpdateNoFilePathWidget == null) {
                        WidgetBRHelper.restoreWidgetInfoToSharedPref(strRestoreWidgetInfo, i5, i2);
                        remoteViewsUpdateNoFilePathWidget = WidgetUtils.INSTANCE.isSDoc(context, strRestoreWidgetInfo) ? makeConvertWidgetView(context, i5) : makeContent(context, i5, strRestoreWidgetInfo, WidgetConstant.RECEIVE_CALLER_ON_UPDATE);
                    }
                }
                updateAppWidgetAndNotify(appWidgetManager, i5, remoteViewsMakeEmptyWidgetView, C11391R.id.widget_img_shortcut_list_view);
                i4++;
                context = context2;
            } else {
                String filePath = WidgetPreferenceManager.INSTANCE.getFilePath(i5);
                String uuid2 = BaseWidgetPreferenceManager.INSTANCE.getUUID(i5);
                if (!TextUtils.isEmpty(uuid2) && WidgetUtils.INSTANCE.isSDoc(context, uuid2)) {
                    remoteViewsUpdateNoFilePathWidget = makeConvertWidgetView(context, i5);
                } else if (Intrinsics.areEqual(filePath, BaseWidgetConstant.NONE)) {
                    remoteViewsUpdateNoFilePathWidget = updateNoFilePathWidget(context, uuid2, i5, WidgetConstant.RECEIVE_CALLER_ON_UPDATE);
                } else {
                    if (ProviderUtils.INSTANCE.isMakeWidgetContent(context, uuid2)) {
                        context2 = context;
                        remoteViewsMakeEmptyWidgetView = makeContent(context2, i5, uuid2, filePath, false, WidgetConstant.RECEIVE_CALLER_ON_UPDATE);
                    } else {
                        context2 = context;
                        deleteWidget(context2, componentName, uuid2);
                        remoteViewsMakeEmptyWidgetView = makeEmptyWidgetView(context2, i5, WidgetConstant.RECEIVE_CALLER_ON_UPDATE);
                    }
                    updateAppWidgetAndNotify(appWidgetManager, i5, remoteViewsMakeEmptyWidgetView, C11391R.id.widget_img_shortcut_list_view);
                    i4++;
                    context = context2;
                }
            }
            context2 = context;
            remoteViewsMakeEmptyWidgetView = remoteViewsUpdateNoFilePathWidget;
            updateAppWidgetAndNotify(appWidgetManager, i5, remoteViewsMakeEmptyWidgetView, C11391R.id.widget_img_shortcut_list_view);
            i4++;
            context = context2;
        }
    }

    private final RemoteViews makeContent(Context context, int appWidgetId, String uuid, boolean isSaveSkip, String caller) {
        return makeContent(context, appWidgetId, uuid, null, isSaveSkip, caller);
    }

    private final RemoteViews makeContent(Context context, int appWidgetId, String uuid, String noteFilePath, boolean isSaveSkip, String caller) {
        String filePath;
        WidgetImgShortCutProvider widgetImgShortCutProvider;
        int i;
        Context context2 = context;
        WidgetLogger.m5155i(TAG, "makeContent# start, widgetId: " + appWidgetId + SQLKeyword.COMMA + WidgetUtils.INSTANCE.printWidgetOptions(context2, null, appWidgetId));
        RemoteViews remoteViews = new RemoteViews(context2.getPackageName(), getLayoutId(context, appWidgetId));
        NotesDocumentRepository notesDocumentRepositoryCreateDocumentDataRepository = NotesDataRepositoryFactory.newInstance(context2).createDocumentDataRepository();
        Intrinsics.checkNotNullExpressionValue(notesDocumentRepositoryCreateDocumentDataRepository, "createDocumentDataRepository(...)");
        if (noteFilePath != null || uuid == null) {
            filePath = noteFilePath;
        } else {
            filePath = notesDocumentRepositoryCreateDocumentDataRepository.getPath(uuid);
            if (!TextUtils.isEmpty(filePath)) {
                WidgetPreferenceManager.INSTANCE.saveWidgetPrefFilePath(appWidgetId, filePath);
            }
        }
        if (filePath == null) {
            filePath = WidgetPreferenceManager.INSTANCE.getFilePath(appWidgetId);
        }
        if (filePath == null) {
            makeEmptyContent(context2, appWidgetId, remoteViews, caller);
            return remoteViews;
        }
        WidgetLogger widgetLogger = WidgetLogger.INSTANCE;
        String encode = widgetLogger.getEncode(String.valueOf(uuid));
        try {
            WidgetLogger.m5154d(TAG, "makeContent# uuid : " + encode + " path: " + widgetLogger.getEncode(filePath));
            SpenSdkInitializer.initialize(context2);
            SpenComposerSdkInitializer.initialize(context2);
            if (!AbstractC2322a.m1607A(filePath)) {
                widgetLogger.m5157e(TAG, "makeContent# path is not exist. path: " + widgetLogger.getEncode(filePath));
                makeEmptyContent(context2, appWidgetId, remoteViews, caller);
                return remoteViews;
            }
            boolean zIsSaving = notesDocumentRepositoryCreateDocumentDataRepository.isSaving(String.valueOf(uuid), Process.myPid());
            WidgetLogger.m5155i(TAG, "makeContent# uuid : " + encode + ", isSaving: " + zIsSaving);
            int i2 = 0;
            if (!isSaveSkip && zIsSaving) {
                remoteViews.setViewVisibility(C11391R.id.widget_loading_layout, 0);
                return remoteViews;
            }
            CacheFileManager.Companion companion = CacheFileManager.INSTANCE;
            if (!companion.getInstance().isInitialized()) {
                companion.getInstance().init(context2);
            }
            if (companion.getInstance().isValidFiles(String.valueOf(uuid)) && !companion.getInstance().isCacheFilesCleared(context2, String.valueOf(uuid)) && companion.getInstance().isCreateWidgetState(context2, String.valueOf(uuid), appWidgetId)) {
                remoteViews.setViewVisibility(C11391R.id.widget_loading_layout, 8);
                try {
                    remoteViews.setViewVisibility(C11391R.id.widget_img_shortcut_empty_container, 8);
                    remoteViews.setViewVisibility(C11391R.id.widget_img_shortcut_list_view, 0);
                    remoteViews.setViewVisibility(C11391R.id.widget_img_shortcut_convert_text, 8);
                    String title = notesDocumentRepositoryCreateDocumentDataRepository.get(String.valueOf(uuid)).getTitle();
                    Intrinsics.checkNotNullExpressionValue(title, "getTitle(...)");
                    setWidgetTitle(context2, remoteViews, title);
                    ProviderUtils.INSTANCE.convertOpacity(appWidgetId);
                    setListAdapter(context2, remoteViews, appWidgetId, filePath, uuid, title);
                    widgetImgShortCutProvider = this;
                    i = appWidgetId;
                    try {
                        widgetImgShortCutProvider.setClickPendingIntent(context2, remoteViews, i);
                        boolean zExistVoiceRecording = companion.getInstance().existVoiceRecording(String.valueOf(uuid));
                        if (zExistVoiceRecording) {
                            remoteViews.setViewVisibility(C11391R.id.widget_img_shortcut_title_layout, 0);
                        }
                        int i4 = C11391R.id.widget_voice;
                        if (!zExistVoiceRecording) {
                            i2 = 8;
                        }
                        remoteViews.setViewVisibility(i4, i2);
                        try {
                        } catch (Exception e) {
                            e = e;
                            remoteViews = remoteViews;
                        }
                        try {
                            new ShortcutThemeManager().applyThemeToWidgetFrame(context2, remoteViews, new ThemeInfo(context2, i), companion.getInstance().getPageColor(String.valueOf(uuid)), companion.getInstance().hasBackgroundImage(String.valueOf(uuid)));
                            remoteViews = remoteViews;
                        } catch (Exception e2) {
                            e = e2;
                            remoteViews = remoteViews;
                            context2 = context2;
                            WidgetLogger.INSTANCE.m5158e(TAG, "makeContent# " + e, e);
                            widgetImgShortCutProvider.makeEmptyContent(context2, i, remoteViews, caller);
                        }
                    } catch (Exception e3) {
                        e = e3;
                    }
                } catch (Exception e5) {
                    e = e5;
                    widgetImgShortCutProvider = this;
                    i = appWidgetId;
                }
                WidgetLogger.m5155i(TAG, "makeContent# end, widgetId - " + i);
                return remoteViews;
            }
            companion.getInstance().createCacheInfo(context2, String.valueOf(uuid), filePath, appWidgetId);
            widgetLogger.m5157e(TAG, "makeContent# wait cache loading, mAppWidgetId: " + appWidgetId);
            return remoteViews;
        } catch (Exception e6) {
            WidgetLogger.INSTANCE.m5158e(TAG, "makeContent# fail to init Spen", e6);
            makeEmptyContent(context2, appWidgetId, remoteViews, caller);
            return remoteViews;
        }
    }

    private final void makeEmptyContent(Context context, int appWidgetId, RemoteViews remoteViews, String caller) {
        WidgetLogger.m5155i(TAG, "makeEmptyContent# caller : " + caller);
        if (Intrinsics.areEqual(WidgetConstant.RECEIVE_CALLER_ON_UPDATE, caller)) {
            BaseWidgetPreferenceManager.INSTANCE.saveTrueReverseTransparency(appWidgetId);
        }
        WidgetPreferenceManager widgetPreferenceManager = WidgetPreferenceManager.INSTANCE;
        WidgetPreferenceManager.saveWidgetPref$default(widgetPreferenceManager, appWidgetId, BaseWidgetConstant.NONE, null, 4, null);
        remoteViews.setViewVisibility(C11391R.id.widget_img_shortcut_list_view, 8);
        remoteViews.setViewVisibility(C11391R.id.widget_img_shortcut_title_layout, 8);
        remoteViews.setViewVisibility(C11391R.id.widget_img_shortcut_empty_container, 0);
        ThemeInfo themeInfo = new ThemeInfo(context, appWidgetId);
        int emptyTransparency = widgetPreferenceManager.getEmptyTransparency(appWidgetId);
        if (emptyTransparency >= 0) {
            BaseWidgetPreferenceManager.INSTANCE.saveTransparency(appWidgetId, emptyTransparency);
        } else {
            themeInfo.setMTransparency(WidgetUtils.INSTANCE.getEmptyWidgetAlpha());
        }
        new ShortcutThemeManager().applyThemeToEmptyWidget(context, remoteViews, themeInfo);
        Intent intent = new Intent(context, getThis());
        intent.setAction(WidgetConstant.PICK_MEMO_LIST_FROM_WIDGET);
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, appWidgetId);
        remoteViews.setOnClickPendingIntent(C11391R.id.widget_img_shortcut_container, PendingIntent.getBroadcast(context, appWidgetId, intent, 201326592));
        remoteViews.setContentDescription(C11391R.id.widget_img_shortcut_container, context.getResources().getString(C11391R.string.widget_shortcut_add_to_note) + "," + context.getResources().getString(C11391R.string.memolist_category_content_description_button));
    }

    private final void updateAppWidgetAndNotify(AppWidgetManager appWidgetManager, int appWidgetId, int listId, RemoteViews remoteViews, String caller) {
        WidgetLogger.m5155i(TAG, "updateAppWidget# widgetId = " + appWidgetId + "/ caller = " + caller);
        appWidgetManager.updateAppWidget(appWidgetId, remoteViews);
        WidgetLogger.m5155i(TAG, "notifyAppWidgetViewDataChanged# widgetId = " + appWidgetId + "/ caller = " + caller);
        appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetId, listId);
    }

    private final void updateAppWidgetAndNotify(Context context, int appWidgetId, String uuid, int listId, String caller) {
        RemoteViews remoteViewsMakeContent = makeContent(context, appWidgetId, uuid, null, true, caller);
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        Intrinsics.checkNotNullExpressionValue(appWidgetManager, "getInstance(...)");
        updateAppWidgetAndNotify(appWidgetManager, appWidgetId, listId, remoteViewsMakeContent, caller);
    }
}
