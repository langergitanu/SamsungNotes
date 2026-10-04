package com.samsung.android.support.senl.p148nt.app.updater.migration;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.samsung.android.app.notes.sync.p135db.C6749r;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.cover.presenter.CoverEditorUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.DocumentTempDataConstants;
import com.samsung.android.support.senl.p148nt.data.common.exceptions.NotesSQLiteConstraintException;
import com.samsung.android.support.senl.p148nt.data.common.utils.DocumentTempDataJsonUtils;
import com.samsung.android.support.senl.p148nt.data.common.utils.NotesDocumentCoverUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.DocumentTempDataEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.tuple.DocumentCoverStateTuple;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.cover.NotesDocumentCoverRepository;
import com.samsung.android.support.senl.p148nt.data.repository.document.DocumentTempDataRepository;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import p001A.AbstractC0000a;
import p175e0.AbstractC11974a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class CoverDataMigrationManager {
    private static final String TAG = "CoverDataMigrationManager";
    private final NotesDocumentCoverRepository mNotesDocumentCoverRepository;
    private final DocumentTempDataRepository mTempDataRepository;
    private final C6749r mWdocWriteResolver;

    private CoverDataMigrationManager(NotesDataRepositoryFactory notesDataRepositoryFactory, C6749r c6749r) {
        this.mTempDataRepository = notesDataRepositoryFactory.createDocumentTempDataRepository();
        this.mNotesDocumentCoverRepository = notesDataRepositoryFactory.createDocumentCoverRepository();
        this.mWdocWriteResolver = c6749r;
    }

    @WorkerThread
    public static synchronized void execute(@NonNull Context context) {
        SharedPreferencesCompat sharedPreferencesCompat = SharedPreferencesCompat.getInstance("APP_UPDATE_PREFERENCE");
        if (sharedPreferencesCompat.getInt("KEY_COVER_DATA_MIGRATION", 0) > 0) {
            new CoverDataMigrationManager(NotesDataRepositoryFactory.newInstance(context), new C6749r(context)).migrate();
            sharedPreferencesCompat.putInt("KEY_COVER_DATA_MIGRATION", 0);
        }
    }

    @WorkerThread
    private void migrate() {
        DocumentCoverStateTuple documentCoverStateTupleM13540b;
        List<DocumentTempDataEntity> entities = this.mTempDataRepository.getEntities(DocumentTempDataConstants.KEY_AI_COVER);
        for (DocumentTempDataEntity documentTempDataEntity : entities) {
            HashMap map = new HashMap();
            String uuid = documentTempDataEntity.getUuid();
            try {
                JSONObject jSONObject = new JSONObject(new JSONObject(documentTempDataEntity.getTempData()).optString(DocumentTempDataConstants.KEY_AI_COVER));
                Debugger.m8609e("WDocAiCover", "[AiCover] getModifiableCoverStateTuple() : " + jSONObject);
                documentCoverStateTupleM13540b = AbstractC11974a.m13540b(NotesDocumentCoverUtils.getVersion(jSONObject.getString(DocumentTempDataConstants.KEY_COVER_VERSION)), uuid, jSONObject, map);
            } catch (JSONException e) {
                Debugger.m8609e("WDocAiCover", "[AiCover] getModifiableCoverStateTuple() : " + e);
                documentCoverStateTupleM13540b = null;
            }
            if (documentCoverStateTupleM13540b == null) {
                Logger.m8697d(TAG, "migrate, tuple is null: " + documentTempDataEntity.getUuid());
            } else {
                Iterator it = map.values().iterator();
                int i = 0;
                while (it.hasNext()) {
                    if (((Boolean) it.next()).booleanValue()) {
                        i++;
                    }
                }
                if (i > 0) {
                    CoverEditorUtils.savePreviewJpg(null, documentCoverStateTupleM13540b.getSummary(), documentCoverStateTupleM13540b.getCategoryUuid(), documentCoverStateTupleM13540b.getTemplateUuid(), documentCoverStateTupleM13540b.getBackgroundColor(), documentCoverStateTupleM13540b.getDocUuid(), documentCoverStateTupleM13540b.getState());
                    try {
                        this.mNotesDocumentCoverRepository.insert(documentCoverStateTupleM13540b, documentCoverStateTupleM13540b.state, TAG);
                    } catch (NotesSQLiteConstraintException e2) {
                        Logger.m8698e(TAG, "migrate, uuid: " + documentTempDataEntity.getUuid() + ", e: " + e2.getMessage());
                    }
                }
                int size = map.values().size();
                if (i == size) {
                    C6749r c6749r = this.mWdocWriteResolver;
                    String tempData = documentTempDataEntity.getTempData();
                    String uuid2 = documentTempDataEntity.getUuid();
                    if (TextUtils.isEmpty(tempData)) {
                        c6749r.f4135c.deleteByUuid(uuid2);
                    } else {
                        try {
                            JSONObject jSONObjectRemoveTempData = DocumentTempDataJsonUtils.removeTempData(DocumentTempDataConstants.KEY_AI_COVER, tempData);
                            if (jSONObjectRemoveTempData.length() == 0) {
                                c6749r.f4135c.deleteByUuid(uuid2);
                            } else {
                                String string = jSONObjectRemoveTempData.toString();
                                c6749r.getClass();
                                DocumentTempDataEntity documentTempDataEntity2 = new DocumentTempDataEntity();
                                documentTempDataEntity2.setUuid(uuid2);
                                documentTempDataEntity2.setTempData(string);
                                c6749r.f4135c.insert(documentTempDataEntity2);
                            }
                        } catch (Exception e3) {
                            AbstractC0000a.m21r(e3, new StringBuilder("removeTempData() : fail to remove AiCover, "), "DocumentTempDataUtil");
                        }
                    }
                }
                Logger.m8697d(TAG, "migrate, uuid: " + documentTempDataEntity.getUuid() + ", modified: " + i + " of " + size);
            }
        }
        Logger.m8697d(TAG, "migrate, size: " + entities.size());
    }
}
