package com.samsung.android.app.notes.widget.broadcast;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.samsung.android.app.notes.widget.common.constants.WidgetConstant;
import com.samsung.android.app.notes.widget.common.log.WidgetLogger;
import com.samsung.android.app.notes.widget.preference.WidgetPreferenceManager;
import com.samsung.android.app.notes.widget.util.ProviderUtils;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p148nt.base.common.access.widgetaccess.WidgetAccessHandler;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.widget.preference.BaseWidgetPreferenceManager;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.document.MainListDocumentDataRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0007J\u001e\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fH\u0007J\u001e\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fH\u0007J\"\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\u0007H\u0007J*\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\u0007J \u0010\u0015\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fH\u0007J&\u0010\u0016\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u00182\u0006\u0010\u0019\u001a\u00020\u0005H\u0007J\\\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001eH\u0007J\u0012\u0010!\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007J$\u0010\"\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010\u00052\b\u0010$\u001a\u0004\u0018\u00010\u0005H\u0007J2\u0010%\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0010\u0010&\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u000fH\u0007Jb\u0010%\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00072\u0010\u0010&\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u000f2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u0007H\u0007J$\u0010%\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00072\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fJ\u0010\u0010(\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0018\u0010)\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020+2\u0006\u0010\f\u001a\u00020\u0005H\u0002J&\u0010,\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005H\u0007J&\u0010-\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005H\u0007J2\u0010.\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0016\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\u000500j\b\u0012\u0004\u0012\u00020\u0005`12\u0006\u0010\u0019\u001a\u00020\u0005H\u0002J\u0016\u00102\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0007J\u001e\u00103\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u00064"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/broadcast/WidgetBroadcast;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "WIDGET_DELETE_BROADCAST_SIZE", "", "sendUpdateUUIDWidgetBroadcast", "", "context", "Landroid/content/Context;", "uuid", "sendUpdateUUIDListWidgetBroadcast", "uuidList", "", "sendWaitCreateCacheFileUuid", "widgetIds", "sendPickWidgetBroadcast", "widgetId", "filePath", "sendDeleteUUIDWidgetBroadcast", "sendDocumentDeletedBroadcast", "docUuids", "", "action", "transparency", "backgroundColor", "darkMode", "matchSetting", "", "backgroundShape", "backgroundOnOff", "sendUpdateAllWidgetBroadcast", "sendConvertWidgetBroadcast", "oldUuid", "newUuid", "sendPickNoteListBroadcast", "noteList", "fromAction", "sendDeleteDummyWidgetBroadcast", "isDeleteNote", "docRepository", "Lcom/samsung/android/support/senl/nt/data/repository/document/MainListDocumentDataRepository;", "sendUpdateWidgetSettingBroadcast", "sendUpdateUUIDWidgetListSettingBroadcast", "sendDeleteUUIDListWidgetSettingBroadcast", "docUuidList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "sendPickNewEmptyWidget", "sendUpdateWidgetCacheDoneBroadcast", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nWidgetBroadcast.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetBroadcast.kt\ncom/samsung/android/app/notes/widget/broadcast/WidgetBroadcast\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,288:1\n1#2:289\n*E\n"})
public final class WidgetBroadcast {
    public static final int $stable = 0;

    @NotNull
    public static final WidgetBroadcast INSTANCE = new WidgetBroadcast();

    @NotNull
    private static final String TAG = "WidgetBroadcast";
    private static final int WIDGET_DELETE_BROADCAST_SIZE = 100;

    private WidgetBroadcast() {
    }

    private final boolean isDeleteNote(MainListDocumentDataRepository docRepository, String uuid) {
        MainListDocumentData mainListDocumentData = docRepository.get(uuid);
        return mainListDocumentData == null || mainListDocumentData.getIsDeleted() != 0;
    }

    @JvmStatic
    public static final void sendConvertWidgetBroadcast(@NotNull Context context, @Nullable String oldUuid, @Nullable String newUuid) {
        Intrinsics.checkNotNullParameter(context, "context");
        String packageName = context.getPackageName();
        WidgetLogger widgetLogger = WidgetLogger.INSTANCE;
        WidgetLogger.m5154d(TAG, AbstractC2322a.m1622l(packageName, " : sendConvertWidgetBroadcast - ", widgetLogger.getEncode(String.valueOf(oldUuid)), " ", widgetLogger.getEncode(String.valueOf(newUuid))));
        Intent intent = new Intent(WidgetConstant.ACTION_MEMO_CONVERT_UUID);
        intent.setPackage(context.getPackageName());
        intent.putExtra(WidgetConstant.EXTRA_KEY_UUID, oldUuid);
        intent.putExtra(WidgetConstant.EXTRA_KEY_CONVERT_UUID, newUuid);
        context.sendBroadcast(intent);
    }

    @JvmStatic
    public static final void sendDeleteDummyWidgetBroadcast(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int[] widgetIdList = ProviderUtils.INSTANCE.getWidgetIdList(context);
        MainListDocumentDataRepository mainListDocumentDataRepositoryCreateMainListDocumentDataRepository = NotesDataRepositoryFactory.newInstance(context).createMainListDocumentDataRepository();
        HashSet hashSet = new HashSet();
        for (int i : widgetIdList) {
            String uuid = BaseWidgetPreferenceManager.INSTANCE.getUUID(i);
            if (mainListDocumentDataRepositoryCreateMainListDocumentDataRepository != null && INSTANCE.isDeleteNote(mainListDocumentDataRepositoryCreateMainListDocumentDataRepository, uuid)) {
                hashSet.add(uuid);
            }
        }
        if (WidgetAccessHandler.getNoteListWidgetProviderClass() == null) {
            PostLaunchManager.INSTANCE.getInstance().executeBaseLogic(1);
        }
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        Class<?> noteListWidgetProviderClass = WidgetAccessHandler.getNoteListWidgetProviderClass();
        for (int i2 : appWidgetManager.getAppWidgetIds(noteListWidgetProviderClass != null ? new ComponentName(context, noteListWidgetProviderClass) : null)) {
            for (String str : WidgetPreferenceManager.INSTANCE.getNoteUuidList(i2)) {
                if (mainListDocumentDataRepositoryCreateMainListDocumentDataRepository != null && INSTANCE.isDeleteNote(mainListDocumentDataRepositoryCreateMainListDocumentDataRepository, str)) {
                    hashSet.add(str);
                }
            }
        }
        if (hashSet.isEmpty()) {
            return;
        }
        sendDeleteUUIDWidgetBroadcast(context, new ArrayList(hashSet));
    }

    private final void sendDeleteUUIDListWidgetSettingBroadcast(Context context, ArrayList<String> docUuidList, String action) {
        Intent intent = new Intent(action);
        intent.putStringArrayListExtra(WidgetConstant.EXTRA_KEY_NOTE_UUID_LIST, docUuidList);
        Intrinsics.checkNotNull(context);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    @JvmStatic
    public static final void sendDeleteUUIDWidgetBroadcast(@Nullable Context context, @NotNull List<String> uuidList) {
        Intrinsics.checkNotNullParameter(uuidList, "uuidList");
        if (context == null) {
            WidgetLogger.m5154d(TAG, "sendDeleteUUIDWidgetBroadcast# context is null");
            return;
        }
        WidgetLogger.m5154d(TAG, context.getPackageName() + " : sendDeleteUUIDWidgetBroadcast size: " + uuidList.size());
        int size = uuidList.size();
        Intent intent = new Intent(WidgetConstant.ACTION_MEMO_DELETE_UUID);
        intent.setPackage(context.getPackageName());
        int i = 0;
        while (i < size) {
            int i2 = i + 100;
            intent.putExtra(WidgetConstant.EXTRA_KEY_UUID, new ArrayList(uuidList.subList(i, (int) Math.min(size, i2))));
            context.sendBroadcast(intent);
            i = i2;
        }
    }

    @JvmStatic
    public static final void sendDocumentDeletedBroadcast(@NotNull Context context, @NotNull Collection<String> docUuids, @NotNull String action) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(docUuids, "docUuids");
        Intrinsics.checkNotNullParameter(action, "action");
        ArrayList<String> arrayList = new ArrayList<>(docUuids);
        sendDeleteUUIDWidgetBroadcast(context, arrayList);
        INSTANCE.sendDeleteUUIDListWidgetSettingBroadcast(context, arrayList, action);
    }

    @JvmStatic
    public static final void sendPickNoteListBroadcast(@NotNull Context context, int widgetId, int transparency, @Nullable List<String> noteList) {
        Intrinsics.checkNotNullParameter(context, "context");
        sendPickNoteListBroadcast(context, widgetId, transparency, -1, -1, noteList, false, -1, false, -1);
    }

    @JvmStatic
    public static final void sendPickWidgetBroadcast(@NotNull Context context, @Nullable String uuid, int widgetId) {
        Intrinsics.checkNotNullParameter(context, "context");
        INSTANCE.sendPickWidgetBroadcast(context, uuid, null, widgetId);
    }

    public static /* synthetic */ void sendPickWidgetBroadcast$default(Context context, String str, int i, int i2, String str2, int i4, int i5, boolean z, int i6, boolean z2, int i7, Object obj) {
        if ((i7 & 16) != 0) {
            str2 = null;
        }
        sendPickWidgetBroadcast(context, str, i, i2, str2, i4, i5, z, i6, z2);
    }

    @JvmStatic
    public static final void sendUpdateAllWidgetBroadcast(@Nullable Context context) {
        if (context != null) {
            WidgetLogger.m5154d(TAG, context.getPackageName() + " : sendUpdateAllWidgetBroadcast");
            Intent intent = new Intent(WidgetConstant.ACTION_MEMO_UPDATE_ALL);
            intent.setPackage(context.getPackageName());
            context.sendBroadcast(intent);
        }
    }

    @JvmStatic
    public static final void sendUpdateUUIDListWidgetBroadcast(@NotNull Context context, @NotNull List<String> uuidList) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uuidList, "uuidList");
        WidgetLogger.m5154d(TAG, context.getPackageName() + " : sendUpdateUUIDListWidgetBroadcast - uuidList size | " + uuidList.size());
        Intent intent = new Intent(WidgetConstant.ACTION_MEMO_UPDATE_UUID_FROM_NOTE_LIST);
        intent.setPackage(context.getPackageName());
        intent.putStringArrayListExtra(WidgetConstant.EXTRA_KEY_NOTE_UUID_LIST, new ArrayList<>(uuidList));
        context.sendBroadcast(intent);
    }

    @JvmStatic
    public static final void sendUpdateUUIDWidgetBroadcast(@NotNull Context context, @Nullable String uuid) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (uuid == null) {
            WidgetLogger.m5154d(TAG, context.getPackageName() + " : sendUpdateUUIDWidgetBroadcast - uuid is null");
            return;
        }
        WidgetLogger.m5154d(TAG, context.getPackageName() + " : sendUpdateUUIDWidgetBroadcast - uuid | " + uuid);
        Intent intent = new Intent(WidgetConstant.ACTION_MEMO_UPDATE_UUID);
        intent.setPackage(context.getPackageName());
        intent.putExtra(WidgetConstant.EXTRA_KEY_UUID, uuid);
        context.sendBroadcast(intent);
    }

    @JvmStatic
    public static final void sendUpdateUUIDWidgetListSettingBroadcast(@Nullable Context context, @Nullable String uuid, @Nullable String action) {
        Intent intent = new Intent(action);
        intent.putExtra(WidgetConstant.EXTRA_KEY_UUID, uuid);
        Intrinsics.checkNotNull(context);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    @JvmStatic
    public static final void sendUpdateWidgetSettingBroadcast(@Nullable Context context, @Nullable String uuid, @Nullable String action) {
        Intent intent = new Intent(action);
        intent.putExtra(WidgetConstant.EXTRA_KEY_UUID, uuid);
        Intrinsics.checkNotNull(context);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    @JvmStatic
    public static final void sendWaitCreateCacheFileUuid(@NotNull Context context, @NotNull List<Integer> widgetIds) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(widgetIds, "widgetIds");
        WidgetLogger.m5154d(TAG, context.getPackageName() + " : sendWaitCreateCacheFileUuid - " + widgetIds);
        if (widgetIds.isEmpty()) {
            return;
        }
        Intent intent = new Intent(WidgetConstant.ACTION_MEMO_WAIT_CACHE);
        intent.setPackage(context.getPackageName());
        intent.putIntegerArrayListExtra(WidgetConstant.EXTRA_KEY_FROM_WIDGET_ID_LIST, new ArrayList<>(widgetIds));
        context.sendBroadcast(intent);
    }

    public final void sendPickNewEmptyWidget(@NotNull Context context, int widgetId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent(WidgetConstant.ACTION_MEMO_EMPTY);
        intent.setPackage(context.getPackageName());
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, widgetId);
        context.sendBroadcast(intent);
    }

    public final void sendUpdateWidgetCacheDoneBroadcast(@NotNull Context context, int widgetId, @NotNull String uuid) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        WidgetLogger.m5154d(TAG, context.getPackageName() + " : sendUpdateWidgetCacheDoneBroadcast - uuid | " + uuid);
        Intent intent = new Intent(WidgetConstant.ACTION_MEMO_CACHE_DONE);
        intent.setPackage(context.getPackageName());
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, widgetId);
        intent.putExtra(WidgetConstant.EXTRA_KEY_UUID, uuid);
        context.sendBroadcast(intent);
    }

    @JvmStatic
    public static final void sendPickNoteListBroadcast(@NotNull Context context, int widgetId, int transparency, int backgroundColor, int darkMode, @Nullable List<String> noteList, boolean matchSetting, int backgroundShape, boolean backgroundOnOff, int fromAction) {
        Intrinsics.checkNotNullParameter(context, "context");
        WidgetLogger.m5154d(TAG, context.getPackageName() + " : sendPickNoteListBroadcast - widgetId : " + widgetId + " backgroundColor : " + backgroundColor + " darkMode : " + darkMode);
        Intent intent = new Intent(WidgetConstant.ACTION_MEMO_PICK_DONE_FROM_NOTE_LIST);
        intent.setPackage(context.getPackageName());
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, widgetId);
        if (transparency != -1) {
            intent.putExtra(BaseWidgetConstant.EXTRA_KEY_WIDGET_TRANSPARENCY, transparency);
        }
        if (backgroundColor != -1) {
            intent.putExtra(BaseWidgetConstant.EXTRA_KEY_WIDGET_BACKGROUND_COLOR, backgroundColor);
        }
        if (darkMode != -1) {
            intent.putExtra(BaseWidgetConstant.EXTRA_KEY_WIDGET_DARK_MODE, darkMode);
        }
        intent.putStringArrayListExtra(WidgetConstant.EXTRA_KEY_NOTE_UUID_LIST, new ArrayList<>(noteList));
        intent.putExtra(BaseWidgetConstant.KEY_WIDGET_MATCH_SETTING, matchSetting);
        intent.putExtra(BaseWidgetConstant.KEY_WIDGET_BACKGROUND_SHAPE, backgroundShape);
        intent.putExtra(BaseWidgetConstant.KEY_WIDGET_BACKGROUND_ON_OFF, backgroundOnOff);
        intent.putExtra(WidgetConstant.EXTRA_KEY_WIDGET_LIST_FROM_ACTION, fromAction);
        context.sendBroadcast(intent);
    }

    public final void sendPickWidgetBroadcast(@NotNull Context context, @Nullable String uuid, @Nullable String filePath, int widgetId) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (uuid == null) {
            WidgetLogger.m5154d(TAG, context.getPackageName() + " : sendPickWidgetBroadcast - uuid is null ");
        } else {
            WidgetLogger.m5154d(TAG, context.getPackageName() + " : sendPickWidgetBroadcast - uuid | " + uuid);
        }
        if (filePath == null) {
            WidgetLogger.m5154d(TAG, context.getPackageName() + " : sendPickWidgetBroadcast - filePath is null ");
        } else {
            WidgetLogger.m5154d(TAG, context.getPackageName() + " : sendPickWidgetBroadcast - filePath | " + filePath);
        }
        WidgetLogger.m5154d(TAG, context.getPackageName() + " : sendPickWidgetBroadcast - widgetId | " + widgetId);
        Intent intent = new Intent(WidgetConstant.ACTION_MEMO_PICK_DONE_NEW_NOTE);
        intent.setPackage(context.getPackageName());
        intent.putExtra(WidgetConstant.EXTRA_KEY_UUID, uuid);
        intent.putExtra(WidgetConstant.EXTRA_KEY_FILE_PATH, filePath);
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, widgetId);
        context.sendBroadcast(intent);
    }

    @JvmStatic
    public static final void sendPickWidgetBroadcast(@NotNull Context context, @NotNull String uuid, int widgetId, int transparency, @Nullable String filePath, int backgroundColor, int darkMode, boolean matchSetting, int backgroundShape, boolean backgroundOnOff) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        WidgetLogger.m5154d(TAG, context.getPackageName() + " : sendPickWidgetBroadcast - uuid | " + uuid + " widgetId | " + widgetId + " path : " + filePath + " backgroundColor : " + backgroundColor + " darkMode : " + darkMode);
        Intent intent = new Intent(WidgetConstant.ACTION_MEMO_PICK_DONE);
        intent.setPackage(context.getPackageName());
        intent.putExtra(WidgetConstant.EXTRA_KEY_UUID, uuid);
        if (transparency != -1) {
            intent.putExtra(BaseWidgetConstant.EXTRA_KEY_WIDGET_TRANSPARENCY, transparency);
        }
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, widgetId);
        intent.putExtra(WidgetConstant.EXTRA_KEY_FILE_PATH, filePath);
        if (backgroundColor != -1) {
            intent.putExtra(BaseWidgetConstant.EXTRA_KEY_WIDGET_BACKGROUND_COLOR, backgroundColor);
        }
        if (darkMode != -1) {
            intent.putExtra(BaseWidgetConstant.EXTRA_KEY_WIDGET_DARK_MODE, darkMode);
        }
        intent.putExtra(BaseWidgetConstant.KEY_WIDGET_MATCH_SETTING, matchSetting);
        intent.putExtra(BaseWidgetConstant.KEY_WIDGET_BACKGROUND_SHAPE, backgroundShape);
        intent.putExtra(BaseWidgetConstant.KEY_WIDGET_BACKGROUND_ON_OFF, backgroundOnOff);
        context.sendBroadcast(intent);
    }

    public final void sendPickNoteListBroadcast(@NotNull Context context, int widgetId, @NotNull List<String> noteList) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(noteList, "noteList");
        WidgetLogger.m5154d(TAG, "sendPickNoteListBroadcast widgetId : " + widgetId + ", uuidList: " + noteList);
        Intent intent = new Intent(WidgetConstant.ACTION_MEMO_PICK_DONE_FROM_NOTE_LIST);
        intent.setPackage(context.getPackageName());
        intent.putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, widgetId);
        intent.putStringArrayListExtra(WidgetConstant.EXTRA_KEY_NOTE_UUID_LIST, new ArrayList<>(noteList));
        context.sendBroadcast(intent);
    }
}
