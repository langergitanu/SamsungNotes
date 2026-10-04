package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.samsung.android.sdk.pen.document.SpenUnsupportedTypeException;
import com.samsung.android.sdk.pen.document.SpenUnsupportedVersionException;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.PageCacheUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.appwidget.AppWidgetResolverConstructor;
import com.samsung.android.support.senl.p148nt.composer.main.base.appwidget.IAppWidgetResolver;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.RunnableC9844c;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentWriteResolver;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class RestoreNote {
    private static final String TAG = Logger.createTag("Restore");
    private final ComposerModel mComposerModel;
    private final ResultCallback mResultCallback;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ResultCallback {
        void fail(String str);

        void success(String str, String str2);
    }

    public RestoreNote(ComposerModel composerModel, ResultCallback resultCallback) {
        this.mComposerModel = composerModel;
        this.mResultCallback = resultCallback;
    }

    private void closeWNote(SpenWNote spenWNote, String str) {
        try {
            DocumentFileManager.getInstance().close(str, spenWNote, true);
        } catch (IOException e) {
            Logger.m11000e(TAG, "restoreNote# fail to close doc, error: " + e);
        }
    }

    private void copyPageCache(Context context, String str, String str2) {
        FileUtils.moveFile(PageCacheUtils.getCacheDirectory(context, str), PageCacheUtils.getCacheDirectory(context, str2));
    }

    private void deleteDBNewUuid(Context context, String str) {
        this.mComposerModel.getNotesDocEntityManager().setNotesDocumentEntity(str);
        this.mComposerModel.getNotesDocEntityManager().updateDeleteState(context, 2);
    }

    private SpenWNote getWNoteRestored(Context context, String str) {
        return DocumentFileManager.getInstance().open(context, str, 1080, 1000, true, true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$runRestoreNoteOnThread$0(WeakReference weakReference) {
        Activity activity = (Activity) weakReference.get();
        if (CommonUtil.isNotAvailableActivity(activity) || restore(activity, activity.getIntent())) {
            return;
        }
        Logger.m11000e(TAG, "restoreDoc fail  : ");
        this.mResultCallback.fail("failed to restore");
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean restore(Context context, Intent intent) throws Throwable {
        String str;
        RestoreNote restoreNote;
        String str2;
        String str3;
        String str4;
        Context context2;
        Object obj;
        Throwable th;
        boolean zSaveWithCopiedDB;
        String uuid = this.mComposerModel.getDocInfo().getUuid();
        this.mComposerModel.getEntityManager().initDataRepository(uuid);
        String docPath = this.mComposerModel.getDocInfo().getDocPath();
        String strGenerateUniqueFilePath = FileUtils.generateUniqueFilePath(docPath);
        String strNewUUIDFromSourceUUID = UUIDUtils.newUUIDFromSourceUUID(context, uuid);
        Logger.m11003i(TAG, "restoreNote# start : srcUuid " + uuid + " / newUuid = " + strNewUUIDFromSourceUUID);
        this.mComposerModel.setIsRecoveringNote(true);
        SpenWNote spenWNote = null;
        try {
            SpenWNote wNoteRestored = getWNoteRestored(context, docPath);
            try {
                DocumentFileManager.getInstance().saveAsDirectory(wNoteRestored, strGenerateUniqueFilePath, true);
                copyPageCache(context, uuid, strNewUUIDFromSourceUUID);
            } catch (SpenUnsupportedTypeException e) {
                e = e;
                restoreNote = this;
                str2 = strNewUUIDFromSourceUUID;
                str3 = strGenerateUniqueFilePath;
                str = docPath;
                str4 = uuid;
                context2 = context;
                obj = e;
                spenWNote = wNoteRestored;
                try {
                    Logger.m11002f(TAG, "restoreNote# error: " + obj);
                    closeWNote(spenWNote, str);
                    zSaveWithCopiedDB = false;
                    restoreNote.mComposerModel.setIsRecoveringNote(false);
                    if (zSaveWithCopiedDB) {
                    }
                    Logger.m11002f(TAG, "restoreNote, result: " + zSaveWithCopiedDB);
                    return zSaveWithCopiedDB;
                } catch (Throwable th2) {
                    th = th2;
                    th = th;
                    closeWNote(spenWNote, str);
                    throw th;
                }
            } catch (SpenUnsupportedVersionException e2) {
                e = e2;
                restoreNote = this;
                str2 = strNewUUIDFromSourceUUID;
                str3 = strGenerateUniqueFilePath;
                str = docPath;
                str4 = uuid;
                context2 = context;
                obj = e;
                spenWNote = wNoteRestored;
                Logger.m11002f(TAG, "restoreNote# error: " + obj);
                closeWNote(spenWNote, str);
                zSaveWithCopiedDB = false;
                restoreNote.mComposerModel.setIsRecoveringNote(false);
                if (zSaveWithCopiedDB) {
                }
                Logger.m11002f(TAG, "restoreNote, result: " + zSaveWithCopiedDB);
                return zSaveWithCopiedDB;
            } catch (IOException e3) {
                e = e3;
                restoreNote = this;
                str2 = strNewUUIDFromSourceUUID;
                str3 = strGenerateUniqueFilePath;
                str = docPath;
                str4 = uuid;
                context2 = context;
                obj = e;
                spenWNote = wNoteRestored;
                Logger.m11002f(TAG, "restoreNote# error: " + obj);
                closeWNote(spenWNote, str);
                zSaveWithCopiedDB = false;
                restoreNote.mComposerModel.setIsRecoveringNote(false);
                if (zSaveWithCopiedDB) {
                }
                Logger.m11002f(TAG, "restoreNote, result: " + zSaveWithCopiedDB);
                return zSaveWithCopiedDB;
            } catch (CloneNotSupportedException e5) {
                e = e5;
                restoreNote = this;
                str2 = strNewUUIDFromSourceUUID;
                str3 = strGenerateUniqueFilePath;
                str = docPath;
                str4 = uuid;
                context2 = context;
                obj = e;
                spenWNote = wNoteRestored;
                Logger.m11002f(TAG, "restoreNote# error: " + obj);
                closeWNote(spenWNote, str);
                zSaveWithCopiedDB = false;
                restoreNote.mComposerModel.setIsRecoveringNote(false);
                if (zSaveWithCopiedDB) {
                }
                Logger.m11002f(TAG, "restoreNote, result: " + zSaveWithCopiedDB);
                return zSaveWithCopiedDB;
            } catch (Throwable th3) {
                th = th3;
            }
            try {
                zSaveWithCopiedDB = saveWithCopiedDB(context, uuid, docPath, strGenerateUniqueFilePath, strNewUUIDFromSourceUUID, wNoteRestored);
                str2 = strNewUUIDFromSourceUUID;
                str3 = strGenerateUniqueFilePath;
                str4 = uuid;
                context2 = context;
                restoreNote = this;
                closeWNote(wNoteRestored, docPath);
            } catch (SpenUnsupportedTypeException e6) {
                e = e6;
                str2 = strNewUUIDFromSourceUUID;
                str3 = strGenerateUniqueFilePath;
                str = docPath;
                str4 = uuid;
                context2 = context;
                restoreNote = this;
                obj = e;
                spenWNote = wNoteRestored;
                Logger.m11002f(TAG, "restoreNote# error: " + obj);
                closeWNote(spenWNote, str);
                zSaveWithCopiedDB = false;
            } catch (SpenUnsupportedVersionException e7) {
                e = e7;
                str2 = strNewUUIDFromSourceUUID;
                str3 = strGenerateUniqueFilePath;
                str = docPath;
                str4 = uuid;
                context2 = context;
                restoreNote = this;
                obj = e;
                spenWNote = wNoteRestored;
                Logger.m11002f(TAG, "restoreNote# error: " + obj);
                closeWNote(spenWNote, str);
                zSaveWithCopiedDB = false;
            } catch (IOException e8) {
                e = e8;
                str2 = strNewUUIDFromSourceUUID;
                str3 = strGenerateUniqueFilePath;
                str = docPath;
                str4 = uuid;
                context2 = context;
                restoreNote = this;
                obj = e;
                spenWNote = wNoteRestored;
                Logger.m11002f(TAG, "restoreNote# error: " + obj);
                closeWNote(spenWNote, str);
                zSaveWithCopiedDB = false;
            } catch (CloneNotSupportedException e9) {
                e = e9;
                str2 = strNewUUIDFromSourceUUID;
                str3 = strGenerateUniqueFilePath;
                str = docPath;
                str4 = uuid;
                context2 = context;
                restoreNote = this;
                obj = e;
                spenWNote = wNoteRestored;
                Logger.m11002f(TAG, "restoreNote# error: " + obj);
                closeWNote(spenWNote, str);
                zSaveWithCopiedDB = false;
            } catch (Throwable th4) {
                th = th4;
                str = docPath;
                th = th;
                spenWNote = wNoteRestored;
                closeWNote(spenWNote, str);
                throw th;
            }
        } catch (SpenUnsupportedTypeException e10) {
            e = e10;
            restoreNote = this;
            str2 = strNewUUIDFromSourceUUID;
            str3 = strGenerateUniqueFilePath;
            str = docPath;
            str4 = uuid;
            context2 = context;
            obj = e;
            Logger.m11002f(TAG, "restoreNote# error: " + obj);
            closeWNote(spenWNote, str);
            zSaveWithCopiedDB = false;
            restoreNote.mComposerModel.setIsRecoveringNote(false);
            if (zSaveWithCopiedDB) {
            }
            Logger.m11002f(TAG, "restoreNote, result: " + zSaveWithCopiedDB);
            return zSaveWithCopiedDB;
        } catch (SpenUnsupportedVersionException e11) {
            e = e11;
            restoreNote = this;
            str2 = strNewUUIDFromSourceUUID;
            str3 = strGenerateUniqueFilePath;
            str = docPath;
            str4 = uuid;
            context2 = context;
            obj = e;
            Logger.m11002f(TAG, "restoreNote# error: " + obj);
            closeWNote(spenWNote, str);
            zSaveWithCopiedDB = false;
            restoreNote.mComposerModel.setIsRecoveringNote(false);
            if (zSaveWithCopiedDB) {
            }
            Logger.m11002f(TAG, "restoreNote, result: " + zSaveWithCopiedDB);
            return zSaveWithCopiedDB;
        } catch (IOException e12) {
            e = e12;
            restoreNote = this;
            str2 = strNewUUIDFromSourceUUID;
            str3 = strGenerateUniqueFilePath;
            str = docPath;
            str4 = uuid;
            context2 = context;
            obj = e;
            Logger.m11002f(TAG, "restoreNote# error: " + obj);
            closeWNote(spenWNote, str);
            zSaveWithCopiedDB = false;
            restoreNote.mComposerModel.setIsRecoveringNote(false);
            if (zSaveWithCopiedDB) {
            }
            Logger.m11002f(TAG, "restoreNote, result: " + zSaveWithCopiedDB);
            return zSaveWithCopiedDB;
        } catch (CloneNotSupportedException e13) {
            e = e13;
            restoreNote = this;
            str2 = strNewUUIDFromSourceUUID;
            str3 = strGenerateUniqueFilePath;
            str = docPath;
            str4 = uuid;
            context2 = context;
            obj = e;
            Logger.m11002f(TAG, "restoreNote# error: " + obj);
            closeWNote(spenWNote, str);
            zSaveWithCopiedDB = false;
            restoreNote.mComposerModel.setIsRecoveringNote(false);
            if (zSaveWithCopiedDB) {
            }
            Logger.m11002f(TAG, "restoreNote, result: " + zSaveWithCopiedDB);
            return zSaveWithCopiedDB;
        } catch (Throwable th5) {
            th = th5;
            str = docPath;
            th = th;
            closeWNote(spenWNote, str);
            throw th;
        }
        restoreNote.mComposerModel.setIsRecoveringNote(false);
        if (zSaveWithCopiedDB) {
            restoreNote.mComposerModel.getDocInfo().setDocPath(str3);
            if (intent != null && !TextUtils.isEmpty(intent.getStringExtra("doc_path"))) {
                intent.putExtra("doc_path", str3);
            }
            deleteDBNewUuid(context2, str2);
            restoreNote.mResultCallback.success(str4, str3);
            restoreNote.mComposerModel.setIsRecoveredOnCorrupted(true);
            restoreNote.mComposerModel.setCanShowRecoveredOnCorrupted(true);
        }
        Logger.m11002f(TAG, "restoreNote, result: " + zSaveWithCopiedDB);
        return zSaveWithCopiedDB;
    }

    private boolean saveWithCopiedDB(Context context, String str, String str2, String str3, String str4, SpenWNote spenWNote) {
        NotesDocumentEntity notesDocumentEntity = this.mComposerModel.getNotesDocEntityManager().getNotesDocumentEntity();
        NotesDocumentEntity notesDocumentEntityMo22193clone = notesDocumentEntity.mo22193clone();
        notesDocumentEntity.setFilePath(str3);
        if (!DocumentWriteResolver.save(context, false, str3, notesDocumentEntity, spenWNote, notesDocumentEntity.getLockAccountGuid(), false, getClass().getSimpleName())) {
            return false;
        }
        updateWidget(context, str, str3);
        notesDocumentEntityMo22193clone.setCorrupted(1);
        return this.mComposerModel.getNotesDocEntityManager().insertToDB(context, str4, str2, spenWNote, notesDocumentEntityMo22193clone);
    }

    private void updateWidget(Context context, String str, String str2) {
        try {
            IAppWidgetResolver appWidgetResolver = AppWidgetResolverConstructor.getAppWidgetResolver();
            if (appWidgetResolver != null) {
                appWidgetResolver.updateWidgetDocPath(context, str, str2);
            }
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            Logger.m11000e(TAG, "updateWidget error: " + e);
        }
    }

    public void runRestoreNoteOnThread(Activity activity) {
        Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG)).execute(new RunnableC9844c(this, new WeakReference(activity), 8));
    }
}
