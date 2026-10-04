package com.samsung.android.support.senl.p148nt.app.main.noteslist;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.main.common.data.MainEntryParam;
import com.samsung.android.support.senl.p148nt.app.nativecomposer.ComposerActivity;
import com.samsung.android.support.senl.p148nt.base.common.ComposerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.oldcomposer.OldComposerActivity;
import com.samsung.android.support.senl.p148nt.composer.main.recyclebin.RecycleBinActivity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.sync.SyncNoteDataRepository;
import com.samsung.android.support.senl.p148nt.model.service.DocumentServiceConstants;
import p079T.C0283a;
import p259y0.AbstractC14517a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class IntentFactory {
    public static final int ADDONS = 5;
    public static final int COMPOSER = 1;
    public static final int COMPOSER_GCS = 3;
    public static final int COMPOSER_RECYCLE_BIN = 2;
    public static final int COMPOSER_TAG = 4;
    public static final int DIGITALLEGACY_TYPE = 7;
    public static final int LOCKED_OTHER_DOC_TYPE = 6;
    public static final String TAG = "IntentFactory";

    private static void addComposerIntentFromGcs(Context context, Intent intent, MainEntryParam mainEntryParam) {
        SyncNoteDataRepository syncNoteDataRepositoryCreateSyncNoteDataRepository = NotesDataRepositoryFactory.newInstance(context).createSyncNoteDataRepository();
        String uuid = mainEntryParam.getUuid();
        String gcsOwnerId = syncNoteDataRepositoryCreateSyncNoteDataRepository.getGcsOwnerId(uuid);
        C0283a.m562d().getClass();
        boolean zM15116A = AbstractC14517a.m15116A(gcsOwnerId, C0283a.m561c());
        intent.putExtra(ComposerConstants.ARG_MDE_OWNER_ID, gcsOwnerId);
        intent.putExtra(ComposerConstants.ARG_MDE_WRITER, "test");
        intent.putExtra(ComposerConstants.ARG_MDE_ACCOUNT_TYPE, zM15116A ? 1 : 2);
        intent.putExtra("sdoc_uuid", uuid);
        intent.putExtra("doc_path", mainEntryParam.getFilePath());
        intent.putExtra(ComposerConstants.ARG_LOCK_ACCOUNT_GUID, DocumentServiceConstants.LockGuid.FROM_SHARED_NOTES_GUID);
        intent.setAction(ComposerConstants.ACTION_OPEN_MEMO);
    }

    private static void addComposerIntentFromTag(Intent intent, MainEntryParam mainEntryParam) {
        intent.setAction(ComposerConstants.ACTION_OPEN_MEMO);
        intent.putExtra("sdoc_uuid", mainEntryParam.getUuid());
        intent.putExtra(ComposerConstants.ARG_FROM_LIST_TYPE, 1);
        intent.putExtra(ComposerConstants.ARG_LOCK_ACCOUNT_GUID, mainEntryParam.getGuid());
        if (mainEntryParam.getHighLightText() != null) {
            intent.putExtra("highlighttext", mainEntryParam.getHighLightText());
        }
    }

    private static void addDefaultIntent(Intent intent, MainEntryParam mainEntryParam) {
        intent.putExtra("sdoc_uuid", mainEntryParam.getUuid());
        intent.putExtra("doc_path", mainEntryParam.getFilePath());
        intent.putExtra("tool_type", mainEntryParam.getToolType());
        intent.putExtra("category_id", mainEntryParam.getFolderUuid());
        intent.putExtra(ComposerConstants.ARG_LOCK_ACCOUNT_GUID, mainEntryParam.getGuid());
        intent.putExtra(ComposerConstants.ARG_LOCK_TYPE, mainEntryParam.getLockType());
        intent.putExtra("mode", mainEntryParam.getModeIndex());
        if (mainEntryParam.getHighLightText() != null) {
            intent.putExtra("highlighttext", mainEntryParam.getHighLightText());
        }
    }

    private static void disableComposerViewMode(Intent intent) {
        intent.putExtra(ComposerConstants.ARG_USE_VIEW_MODE, false);
    }

    private static void initIntent(Context context, Intent intent, Class<?> cls, MainEntryParam mainEntryParam) {
        if (!TextUtils.isEmpty(mainEntryParam.getOldUuid())) {
            intent.putExtra(ComposerConstants.ARG_SDOC_OLD_UUID, mainEntryParam.getOldUuid());
            cls = OldComposerActivity.class;
        }
        intent.setClass(context, cls);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static Intent makeIntent(int i, Activity activity, MainEntryParam mainEntryParam) {
        MainLogger.m7258i(TAG, "makeIntent# type : " + i);
        Intent intent = new Intent();
        if (activity != null) {
            Context applicationContext = activity.getApplicationContext();
            switch (i) {
                case 1:
                    initIntent(applicationContext, intent, ComposerActivity.class, mainEntryParam);
                    addDefaultIntent(intent, mainEntryParam);
                    if (ComposerManager.getInstance().hasComposerInSameTask(activity, mainEntryParam.getUuid())) {
                        intent.setFlags(131072);
                    }
                    disableComposerViewMode(intent);
                    return intent;
                case 2:
                    initIntent(applicationContext, intent, RecycleBinActivity.class, mainEntryParam);
                    addDefaultIntent(intent, mainEntryParam);
                    intent.putExtra(ComposerConstants.ARG_IS_DELETED, 2);
                    if (ComposerManager.getInstance().hasComposerInSameTask(activity, mainEntryParam.getUuid())) {
                        intent.setFlags(131072);
                    }
                    break;
                case 3:
                    initIntent(applicationContext, intent, ComposerActivity.class, mainEntryParam);
                    addComposerIntentFromGcs(applicationContext, intent, mainEntryParam);
                    if (ComposerManager.getInstance().hasComposerInSameTask(activity, mainEntryParam.getUuid())) {
                        intent.setFlags(131072);
                        return intent;
                    }
                    break;
                case 4:
                    initIntent(applicationContext, intent, ComposerActivity.class, mainEntryParam);
                    addComposerIntentFromTag(intent, mainEntryParam);
                    if (ComposerManager.getInstance().hasComposerInSameTask(activity, mainEntryParam.getUuid())) {
                        intent.setFlags(131072);
                        return intent;
                    }
                    break;
                case 5:
                    initIntent(applicationContext, intent, ComposerActivity.class, mainEntryParam);
                    addDefaultIntent(intent, mainEntryParam);
                    intent.putExtra(ComposerConstants.ARG_IS_CONVERTED, true);
                    intent.putExtra(ComposerConstants.ARG_FROM_LIST_TYPE, 2);
                    if (ComposerManager.getInstance().hasComposerInSameTask(activity, mainEntryParam.getUuid())) {
                        intent.setFlags(131072);
                        return intent;
                    }
                    break;
                case 6:
                    addDefaultIntent(intent, mainEntryParam);
                    return intent;
            }
        }
        return intent;
    }
}
