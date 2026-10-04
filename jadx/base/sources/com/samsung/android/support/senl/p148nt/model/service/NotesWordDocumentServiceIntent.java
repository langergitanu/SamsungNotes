package com.samsung.android.support.senl.p148nt.model.service;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.base.common.ComposerManager;
import com.samsung.android.support.senl.p148nt.base.common.access.document.DocumentAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.sdk.util.SpenSdkInitializer;
import com.samsung.android.support.senl.p148nt.base.common.startmanager.ModelStartManager;
import com.samsung.android.support.senl.p148nt.base.common.task.TaskState;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.collector.manager.CollectTaskManager;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentSubscriptionId;
import com.samsung.android.support.senl.p148nt.model.service.DocumentServiceConstants;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentCacheUtils;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class NotesWordDocumentServiceIntent {
    private static final String TAG = ModelLogger.createTag("NotesWordDocumentServiceIntent");

    public static void removeCacheAndResave(Context context) {
        DataLogger.m12307i(TAG, "removeCacheAndResave#");
        Intent intent = new Intent(context, (Class<?>) NotesWordDocumentService.class);
        intent.setAction(DocumentServiceConstants.Action.ACTION_REMOVE_CACHE_AND_RESAVE);
        context.startService(intent);
    }

    private static void removeDummyCacheDirectories(Context context) {
        DocumentAccessHandler.DocumentAccessContract contract = DocumentAccessHandler.getContract();
        if (SpenSdkInitializer.initialize(context) && !CollectTaskManager.getInstance().isRunning() && !ComposerManager.getInstance().isRunningComposer() && !ModelStartManager.INSTANCE.getInstance().isRunning()) {
            TaskState.Companion companion = TaskState.INSTANCE;
            if (!companion.getInstance().isRunning("WIDGET_CAPTURE_TEXT_ONLY_NOTE") && !companion.getInstance().isRunning("WIDGET_CREATE_THUMBNAIL") && contract != null && !contract.isSmartSwitchRunning() && !contract.isSyncRunning() && !contract.isExternalCoeditRunning()) {
                DocumentCacheUtils.removeDummyCacheDirectories(context);
                return;
            }
        }
        DataLogger.m12302d(TAG, "cannot remove dummy cache directories");
    }

    public static void restoreCaches(@NonNull Context context) {
        if (DocumentCacheUtils.existAnyCacheFiles(context) || DocumentCacheUtils.existAnyPDFWriterCacheFiles(context)) {
            restoreCaches(context, null, null, null);
        } else {
            DataLogger.m12302d(TAG, "restoreCaches, cache dir is not exist.");
            removeDummyCacheDirectories(context);
        }
    }

    public static String saveMemo(@NonNull Context context, @NonNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable ArrayList<String> arrayList, @Nullable ArrayList<Uri> arrayList2, @Nullable String str5) {
        Intent intent = new Intent(context, (Class<?>) NotesWordDocumentService.class);
        intent.setAction(DocumentServiceConstants.Action.ACTION_SAVE_BY_TITLE_BODY);
        intent.putExtra("sdoc_uuid", str);
        intent.putExtra("folder_uuid", str2);
        intent.putExtra("title", str3);
        intent.putExtra("body", str4);
        intent.putStringArrayListExtra(DocumentServiceConstants.Extra.ARG_MIME_TYPES, arrayList);
        intent.putParcelableArrayListExtra(DocumentServiceConstants.Extra.ARG_URIS, arrayList2);
        intent.putExtra(DocumentServiceConstants.Extra.ARG_FOLDER_PATH, str5);
        context.startService(intent);
        return str;
    }

    public static void restoreCaches(@NonNull Context context, @Nullable String str, @Nullable String str2, @Nullable DocumentSubscriptionId documentSubscriptionId) {
        DataLogger.m12302d(TAG, "restoreCaches, cachedUuid : " + str + ", folderUuid : " + str2);
        Intent intent = new Intent(context, (Class<?>) NotesWordDocumentService.class);
        intent.setAction(DocumentServiceConstants.Action.ACTION_RESTORE_CACHE);
        intent.putExtra(DocumentServiceConstants.Extra.ARG_RESTORE_UUID, str);
        intent.putExtra("folder_uuid", str2);
        intent.putExtra(DocumentServiceConstants.Extra.ARG_SUBSCRIPTION_ID, documentSubscriptionId);
        context.startService(intent);
    }
}
