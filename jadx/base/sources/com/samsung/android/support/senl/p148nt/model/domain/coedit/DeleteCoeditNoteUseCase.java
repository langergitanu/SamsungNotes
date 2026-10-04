package com.samsung.android.support.senl.p148nt.model.domain.coedit;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.samsung.android.sdk.composer.text.SpenNoteTextManager;
import com.samsung.android.sdk.pen.view.SpenDisplay;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.common.util.DataStrategy;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constructor.ToolConstructor;
import com.samsung.android.support.senl.p148nt.base.common.constants.CoeditBaseConstants;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.sdk.util.SpenSdkInitializer;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesDocumentRepository;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.document.save.DocumentPostSaveOperation;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentWriteResolver;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class DeleteCoeditNoteUseCase {
    private static final String TAG = ModelLogger.createTag("DeleteCoeditNoteUseCase");
    private Callback mCallback;
    private final NotesDocumentRepository mRepository;
    private ResultCallback mResultCallback;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Callback {
        void onError(int i);

        void onSuccess(int i);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ResultCallback {
        void onResult(int i);
    }

    public DeleteCoeditNoteUseCase(NotesDocumentRepository notesDocumentRepository, Callback callback) {
        this.mRepository = notesDocumentRepository;
        this.mCallback = callback;
    }

    private NotesDocumentEntity createNewEntity(@NonNull NotesDocumentEntity notesDocumentEntity, String str) {
        NotesDocumentEntity notesDocumentEntityMo22193clone = notesDocumentEntity.mo22193clone();
        notesDocumentEntityMo22193clone.setId(null);
        notesDocumentEntityMo22193clone.setUuid(str);
        notesDocumentEntityMo22193clone.setIsDirty(0);
        notesDocumentEntityMo22193clone.setCategoryUuid("uncategorized:///");
        notesDocumentEntityMo22193clone.setMdeSpaceId("");
        notesDocumentEntityMo22193clone.setMdeGroupId("");
        notesDocumentEntityMo22193clone.setMdeOwnerId("");
        notesDocumentEntityMo22193clone.setMdeItemId("");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Constants.KEY_SPACE_ID, notesDocumentEntity.getMdeSpaceId());
        } catch (JSONException e) {
            DataLogger.m12303e(TAG, "createNewEntity, e: " + e.getMessage());
        }
        notesDocumentEntityMo22193clone.setMdeExtra(jSONObject.toString());
        return notesDocumentEntityMo22193clone;
    }

    private void execute(@NonNull Context context, @NonNull String str) {
        String str2 = TAG;
        DataLogger.m12307i(str2, "execute, uuid : " + str);
        if (!SpenSdkInitializer.initialize(context)) {
            DataLogger.m12303e(str2, "execute, failed to initialize spen lib");
            onError(310);
            return;
        }
        NotesDocumentEntity notesDocumentEntity = this.mRepository.get(str);
        if (notesDocumentEntity == null || notesDocumentEntity.getIsDeleted() != 0) {
            DataLogger.m12303e(str2, "execute, failed to delete a note, entity: " + notesDocumentEntity);
            onError(310);
            return;
        }
        String strNewUUID = UUIDUtils.newUUID(context, true);
        try {
            NotesDocumentEntity notesDocumentEntityCreateNewEntity = createNewEntity(notesDocumentEntity, strNewUUID);
            if (!updateDocument(context, notesDocumentEntityCreateNewEntity) || !DocumentWriteResolver.delete(context, strNewUUID, 2, str2)) {
                onError(310);
                return;
            }
            DocumentWriteResolver.removeFromDB(context, notesDocumentEntity.getUuid());
            new DocumentPostSaveOperation(context, true, notesDocumentEntityCreateNewEntity, null).setStrategy(new DataStrategy(60).getMStrategy()).run();
            DataLogger.m12307i(str2, "execute, success");
            onSuccess(300);
        } catch (CloneNotSupportedException e) {
            DataLogger.m12303e(TAG, "fail to clone src entity, e : " + e.getMessage());
            onError(310);
        }
    }

    private void onError(@CoeditBaseConstants.DeleteCoeditNoteResult int i) {
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onError(i);
        }
        ResultCallback resultCallback = this.mResultCallback;
        if (resultCallback != null) {
            resultCallback.onResult(i);
        }
    }

    private void onPostExecute() {
        release();
    }

    private void onPreExecute() {
    }

    private void onSuccess(@CoeditBaseConstants.DeleteCoeditNoteResult int i) {
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onSuccess(i);
        }
        ResultCallback resultCallback = this.mResultCallback;
        if (resultCallback != null) {
            resultCallback.onResult(i);
        }
    }

    private void release() {
        this.mCallback = null;
    }

    private boolean saveToDB(Context context, SpenWNote spenWNote, NotesDocumentEntity notesDocumentEntity) {
        return DocumentWriteResolver.save(context, true, notesDocumentEntity.getFilePath(), notesDocumentEntity, spenWNote, notesDocumentEntity.getLockAccountGuid(), true, TAG);
    }

    private boolean saveToFile(SpenWNote spenWNote, String str) {
        try {
            DocumentFileManager.getInstance().saveAsDirectory(spenWNote, str);
            return true;
        } catch (Exception e) {
            AbstractC11014a.m12333r(e, new StringBuilder("saveToFile, e : "), TAG);
            return false;
        }
    }

    private boolean updateDocument(Context context, NotesDocumentEntity notesDocumentEntity) {
        try {
            SpenWNote spenWNoteOpen = DocumentFileManager.getInstance().open(context, notesDocumentEntity.getFilePath(), 2160, 8600, true, false);
            boolean zUpdateWNote = updateWNote(context, spenWNoteOpen, notesDocumentEntity);
            try {
                DocumentFileManager.getInstance().close(notesDocumentEntity.getFilePath(), spenWNoteOpen, true);
                return zUpdateWNote;
            } catch (Exception e) {
                AbstractC11014a.m12333r(e, new StringBuilder("fail to close a document, e : "), TAG);
                return zUpdateWNote;
            }
        } catch (Exception e2) {
            AbstractC11014a.m12333r(e2, new StringBuilder("updateDocument, e: "), TAG);
            return false;
        }
    }

    private boolean updateWNote(Context context, SpenWNote spenWNote, NotesDocumentEntity notesDocumentEntity) {
        SpenDisplay spenDisplayMakeSpenDisplay = ToolConstructor.makeSpenDisplay(context);
        int iCalculateTextSizeDelta = SpenNoteTextManager.calculateTextSizeDelta(spenDisplayMakeSpenDisplay, spenWNote.getBodyTextFontSizeDelta());
        spenDisplayMakeSpenDisplay.close();
        spenWNote.invertBackgroundColor(true);
        spenWNote.setBodyTextFontSizeDelta(iCalculateTextSizeDelta);
        spenWNote.setFixedTextDirection(SpenWNote.TextDirection.TEXT_DIRECTION_DEFAULT);
        spenWNote.setFixedBackgroundTheme(SpenWNote.BackgroundTheme.THEME_DEFAULT);
        spenWNote.setServerCheckPoint(-1L);
        spenWNote.initializeCoeditData();
        return saveToFile(spenWNote, notesDocumentEntity.getFilePath()) && saveToDB(context, spenWNote, notesDocumentEntity);
    }

    @WorkerThread
    public void invoke(@NonNull Context context, @NonNull String str) {
        onPreExecute();
        execute(context, str);
        onPostExecute();
    }

    public DeleteCoeditNoteUseCase setResultCallback(ResultCallback resultCallback) {
        this.mResultCallback = resultCallback;
        return this;
    }
}
