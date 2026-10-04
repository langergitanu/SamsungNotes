package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.cover;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.cover.AiCoverDataCreator;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.common.exceptions.NotesSQLiteConstraintException;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.SuggestedCoverEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.cover.NotesDocumentCoverRepository;
import com.samsung.android.support.senl.p148nt.data.repository.cover.SuggestedCoverRepository;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesDocumentRepository;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiCoverDataCreatorManager {
    private static final String TAG = Logger.createTag("AiCoverDataCreatorManager");
    private static AiCoverDataCreatorManager mInstance;
    private final Map<String, AiCoverDataCreator> mCreatorMap = new HashMap();
    private final NotesDocumentCoverRepository mDocumentCoverRepository;
    private final NotesDocumentRepository mNotesDocumentRepository;
    private final SuggestedCoverRepository mSuggestedCoverRepository;

    private AiCoverDataCreatorManager() {
        NotesDataRepositoryFactory notesDataRepositoryFactoryNewInstance = NotesDataRepositoryFactory.newInstance(BaseUtils.getContext());
        this.mDocumentCoverRepository = notesDataRepositoryFactoryNewInstance.createDocumentCoverRepository();
        this.mSuggestedCoverRepository = notesDataRepositoryFactoryNewInstance.createSuggestedCoverRepository();
        this.mNotesDocumentRepository = notesDataRepositoryFactoryNewInstance.createDocumentDataRepository();
    }

    public static AiCoverDataCreatorManager getInstance() {
        if (mInstance == null) {
            mInstance = new AiCoverDataCreatorManager();
        }
        return mInstance;
    }

    private NotesDocumentEntity getNotesDocumentEntity(String str) {
        return this.mNotesDocumentRepository.get(str);
    }

    public void cancelCreateCover(String str) {
        AbstractC8014b.m7196B("cancelCreateCover# uuid : ", str, TAG);
        AiCoverDataCreator aiCoverDataCreator = this.mCreatorMap.get(str);
        if (aiCoverDataCreator == null) {
            return;
        }
        aiCoverDataCreator.cancel();
    }

    public void deleteCoverEntity(String str) {
        this.mDocumentCoverRepository.deleteByUuids(Collections.singleton(str));
    }

    @Nullable
    public SuggestedCoverEntity getSuggestedCoverEntity(String str) {
        return this.mSuggestedCoverRepository.getEntity(str);
    }

    public void requestCreateCoverData(final String str, String str2, final AiCoverDataCreator.ProcessCallback processCallback) {
        AiCoverDataCreator aiCoverDataCreator = this.mCreatorMap.get(str);
        if (aiCoverDataCreator == null) {
            aiCoverDataCreator = new AiCoverDataCreator();
            this.mCreatorMap.put(str, aiCoverDataCreator);
        } else if (str2.equals(aiCoverDataCreator.getSrcContent())) {
            Logger.m10999d(TAG, "requestCreateCoverData# working job has same data");
            return;
        }
        if (processCallback != null) {
            processCallback.onStart();
        }
        aiCoverDataCreator.createCoverData(str2, new AiCoverDataCreator.Callback() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.cover.AiCoverDataCreatorManager.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.cover.AiCoverDataCreator.Callback
            public void onCompleted(@NonNull String str3, @NonNull String str4, String str5) {
                Logger.m10999d(AiCoverDataCreatorManager.TAG, "onCompleted#");
                AiCoverDataCreator.ProcessCallback processCallback2 = processCallback;
                if (processCallback2 != null) {
                    processCallback2.onCompleted(str3, str4, str5);
                }
                AiCoverDataCreatorManager.this.mCreatorMap.remove(str);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.cover.AiCoverDataCreator.Callback
            public void onFailed(String str3) {
                AbstractC8014b.m7196B("onFailed# errorCode : ", str3, AiCoverDataCreatorManager.TAG);
                AiCoverDataCreator.ProcessCallback processCallback2 = processCallback;
                if (processCallback2 != null) {
                    processCallback2.onFailed(str3);
                }
                AiCoverDataCreatorManager.this.mCreatorMap.remove(str);
            }
        });
    }

    public void updateSuggestedCoverEntity(String str, int i) {
        if (getNotesDocumentEntity(str) == null) {
            Logger.m11004w(TAG, "updateSuggestedCoverEntity# FOREIGN KEY constraint failed (code 787)");
            return;
        }
        SuggestedCoverEntity suggestedCoverEntity = getSuggestedCoverEntity(str);
        if (suggestedCoverEntity == null) {
            suggestedCoverEntity = new SuggestedCoverEntity();
            suggestedCoverEntity.setDocUuid(str);
        }
        if (i == -2 && suggestedCoverEntity.getState() == 0) {
            i = 0;
        }
        suggestedCoverEntity.setState(i, "composer - update entity");
        try {
            this.mSuggestedCoverRepository.update(suggestedCoverEntity);
        } catch (NotesSQLiteConstraintException e) {
            Logger.m11000e(TAG, "updateSuggestedCoverEntity# e: " + e.getMessage());
        }
    }
}
