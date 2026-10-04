package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.cover;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.NotesHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.DocumentMap;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.NotesModel;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.StateInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.params.ViewParams;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.NoteStyleActivity;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.common.Constant;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.cover.util.CoverStyleUtils;
import com.samsung.android.support.senl.p148nt.composer.main.cover.model.CoverData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentCoverEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.model.assist.llm.p166sa.AssistSAConstants;
import com.samsung.android.support.senl.p148nt.model.document.save.CoverThumbnailCreator;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentSubscriptionId;
import com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument;
import com.samsung.android.support.senl.p148nt.model.domain.cover.UpdateDocumentCoverUseCase;
import com.samsung.android.support.senl.p148nt.model.helper.BaseDocumentHelper;
import com.samsung.android.support.senl.p148nt.model.helper.UpdateDocumentHelper;
import com.samsung.android.support.senl.p148nt.model.repository.data.NotesDocument;
import p001A.AbstractC0000a;
import p258y.AbstractC14516b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class CoverHelper {
    private static final String TAG = "CoverHelper";
    private final int NON_POS = -1;
    private final DocumentMap mDocumentMap;
    private final IPresenter mIPresenter;
    private final NotesModel mNotesModel;
    private final StateInfo mStateInfo;
    private final ViewParams mViewParams;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IPresenter {
        CommonHolder findCommonHolder(String str);

        void notifyItemChanged(int i, @Nullable Object obj, String str);
    }

    public CoverHelper(ViewParams viewParams, DocumentMap documentMap, StateInfo stateInfo, NotesModel notesModel, IPresenter iPresenter) {
        this.mViewParams = viewParams;
        this.mDocumentMap = documentMap;
        this.mStateInfo = stateInfo;
        this.mNotesModel = notesModel;
        this.mIPresenter = iPresenter;
    }

    private CoverData createCoverData(String str, MainListDocumentData mainListDocumentData) {
        CoverData coverData = new CoverData(str);
        coverData.setDocPath(mainListDocumentData.getFilePath());
        coverData.setState(mainListDocumentData.getCoverState());
        coverData.setEnabled(mainListDocumentData.isCoverEnabled());
        coverData.setCategoryUuid(mainListDocumentData.getCoverStickerUuid());
        coverData.setTemplateUuid(mainListDocumentData.getCoverTemplateUuid());
        coverData.setTitle(mainListDocumentData.getTitle());
        coverData.setSummary(mainListDocumentData.getCoverSummary());
        coverData.setColorId(mainListDocumentData.getCoverBackgroundColor());
        coverData.setCreatedAt(mainListDocumentData.getCreatedAt());
        coverData.setLastModifiedAt(mainListDocumentData.getLastModifiedAt());
        coverData.setBackgroundColor(mainListDocumentData.getBackgroundColor());
        coverData.setBackgroundColorInverted(mainListDocumentData.getBackgroundColorInverted());
        return coverData;
    }

    private int findHolderPosition(String str) {
        CommonHolder commonHolderFindCommonHolder = this.mIPresenter.findCommonHolder(str);
        if (commonHolderFindCommonHolder == null || commonHolderFindCommonHolder.getMHolderType() != 2048) {
            return -1;
        }
        int position = ((NotesHolder) commonHolderFindCommonHolder).getNotesHolderInfo().getPosition();
        MainLogger.m7254d(TAG, "findHolderPosition# noteUuid : " + str + ", position : " + position);
        return position;
    }

    private boolean hasCover(MainListDocumentData mainListDocumentData) {
        int coverState = mainListDocumentData.getCoverState();
        AbstractC6670b.m4736A(coverState, "hasCover# state : ", TAG);
        return coverState == 1 || coverState == 2 || coverState == 4;
    }

    public boolean isActiveCover(MainListDocumentData mainListDocumentData) {
        return mainListDocumentData != null && mainListDocumentData.isCoverEnabled() && hasCover(mainListDocumentData);
    }

    public void showCoverEditDialog(String str) {
        SpenWNote spenWNote;
        MainListDocumentData noteData = this.mDocumentMap.getNoteData(str);
        Context context = this.mViewParams.getContext();
        if (noteData == null || context == null) {
            return;
        }
        AbstractC0000a.m25v("showCoverEditDialog# uuid : ", str, TAG);
        CommonSamsungAnalytics.insertLog(AssistSAConstants.SCREEN_LIST, AssistSAConstants.EVENT_EDIT_COVER, "c");
        try {
            spenWNote = NotesUtils.getSpenWNote(context, noteData.getFilePath(), false);
        } catch (Exception e) {
            AbstractC14516b.m15115c(e, new StringBuilder("showCoverEditDialog#, e: "), TAG);
            spenWNote = null;
        }
        CoverStyleUtils.INSTANCE.extractTextWithReceiver(this.mViewParams.getContext(), spenWNote, noteData.getFilePath(), noteData.getUuid(), true);
        Intent intent = new Intent(this.mViewParams.getAbsFragment().getContext(), (Class<?>) NoteStyleActivity.class);
        intent.putExtra("key_type", Constant.Type.COVER_EDIT.ordinal());
        intent.putExtra(Constant.KEY_GRAVITY, 81);
        intent.putExtra("sdoc_uuid", str);
        intent.putExtra(CoverData.KEY_COVER_DATA, createCoverData(str, noteData));
        this.mViewParams.getAbsFragment().getActivity().startActivityForResult(intent, 8);
        this.mViewParams.getNotesView().getMode().releaseEditMode();
    }

    public void updateCoverEntity(Context context, CoverData coverData) {
        if (context == null || coverData == null) {
            return;
        }
        NotesDocumentCoverEntity notesDocumentCoverEntity = new NotesDocumentCoverEntity();
        notesDocumentCoverEntity.setDocUuid(coverData.getNoteUuid());
        notesDocumentCoverEntity.setCategoryUuid(coverData.getCategoryUuid());
        notesDocumentCoverEntity.setTemplateUuid(coverData.getTemplateUuid());
        notesDocumentCoverEntity.setBackgroundColor(coverData.getColorId());
        notesDocumentCoverEntity.setTitle(coverData.getTitle());
        notesDocumentCoverEntity.setSummary(coverData.getSummary());
        notesDocumentCoverEntity.setCreatedAt(coverData.getCreatedAt());
        notesDocumentCoverEntity.setLastModifiedAt(coverData.getLastModifiedAt());
        notesDocumentCoverEntity.setEnabled(coverData.isEnabled());
        new UpdateDocumentCoverUseCase(NotesDataRepositoryFactory.newInstance(context).createDocumentCoverRepository()).invoke(notesDocumentCoverEntity, 2, "CoverHelper - updateCoverEntity");
        if (notesDocumentCoverEntity.isEnabled()) {
            CoverThumbnailCreator.convertCoverPath(context, coverData.getNoteUuid());
        } else {
            CoverThumbnailCreator.deleteCoverFileByUuid(context, coverData.getNoteUuid());
        }
    }

    public void updateCoverEntityWithTitle(final Context context, final CoverData coverData) {
        if (context == null) {
            return;
        }
        MainLogger.m7254d(TAG, "updateCoverEntityWithTitle# noteUuid : " + coverData.getNoteUuid());
        new UpdateDocumentHelper(context, DocumentSubscriptionId.UI_LIST_SERVICE_ID).setUuid(coverData.getNoteUuid()).setListener(new BaseDocumentHelper.Listener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.cover.CoverHelper.2
            @Override // com.samsung.android.support.senl.nt.model.helper.BaseDocumentHelper.Listener
            public void onFailed(@NonNull String str) {
            }

            @Override // com.samsung.android.support.senl.nt.model.helper.BaseDocumentHelper.Listener
            public void onOpen(@NonNull NotesDocument<ISpenDocument> notesDocument, @NonNull String str) {
                notesDocument.setDirty(true);
                notesDocument.getDoc().insertTitle(coverData.getTitle());
                notesDocument.getDocumentRepository().getDocumentEntity().getEntity().setTitle(coverData.getTitle());
            }

            @Override // com.samsung.android.support.senl.nt.model.helper.BaseDocumentHelper.Listener
            public void onSave(@NonNull NotesDocument<ISpenDocument> notesDocument, @NonNull String str) {
                CoverHelper.this.updateCoverEntity(context, coverData);
            }
        }).execute();
    }
}
