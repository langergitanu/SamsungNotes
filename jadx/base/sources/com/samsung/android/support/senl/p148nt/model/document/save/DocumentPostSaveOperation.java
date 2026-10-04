package com.samsung.android.support.senl.p148nt.model.document.save;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p148nt.base.common.access.widgetaccess.WidgetAccessContract;
import com.samsung.android.support.senl.p148nt.base.common.access.widgetaccess.WidgetAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.collect.CollectTestLogger;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSyncManager;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.contract.DataToModelManager;
import com.samsung.android.support.senl.p148nt.data.contract.DataToSyncManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.model.document.save.SaveOperation;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class DocumentPostSaveOperation implements Runnable {
    private static final String TAG = DataLogger.createTag("DocumentPostSaveOperation");
    private final List<String> mChangedPageIdList;
    private final Context mContext;
    private final boolean mIsNewDocument;
    private final NotesDocumentEntity mParam;
    private final int mSearchSource;
    private int mStrategy;

    public DocumentPostSaveOperation(@NonNull Context context, boolean z, @NonNull NotesDocumentEntity notesDocumentEntity, List<String> list) {
        this(context, z, notesDocumentEntity, list, getSearchSourceFromParam(notesDocumentEntity));
    }

    @SearchConstants.Source
    private static int getSearchSourceFromParam(NotesDocumentEntity notesDocumentEntity) {
        if (notesDocumentEntity.isImported()) {
            return 1;
        }
        return notesDocumentEntity.getIsSynced() ? 2 : -1;
    }

    private void postCollectOperation(@NonNull NotesDocumentEntity notesDocumentEntity) {
        String str = TAG;
        DataLogger.m12307i(str, "postCollectOperation, isUpdateStrokeSearchData : " + notesDocumentEntity.isUpdateStrokeSearchData());
        PostLaunchManager.getInstance().executeBaseLogic(301);
        try {
            if (notesDocumentEntity.isUpdateStrokeSearchData()) {
                int sourceType = DataToModelManager.getSourceType(this.mSearchSource);
                boolean zIsNewDocument = isNewDocument();
                DataLogger.m12302d(str, "postCollectOperation, uuid/source/sourceType/isNewNote : " + notesDocumentEntity.getUuid() + "/" + this.mSearchSource + "/" + sourceType + "/" + zIsNewDocument);
                CollectTestLogger.log(str + " postCollectOperation, uuid/source/sourceType/isNewNote : " + notesDocumentEntity.getUuid() + "/" + this.mSearchSource + "/" + sourceType + "/" + zIsNewDocument);
                DataToModelManager.startCollect(notesDocumentEntity.getUuid(), notesDocumentEntity.getFilePath(), notesDocumentEntity.getLastModifiedAt(), this.mChangedPageIdList, sourceType, zIsNewDocument);
            }
        } catch (Exception e) {
            AbstractC11014a.m12333r(e, new StringBuilder("postCollectOperation, e : "), TAG);
        }
    }

    private void postGroupShareOperation(@NonNull NotesDocumentEntity notesDocumentEntity) {
        String str = TAG;
        DataLogger.m12307i(str, "postGroupShareOperation");
        try {
            String mdeSpaceId = notesDocumentEntity.getMdeSpaceId();
            if (notesDocumentEntity.getIsDirty() == 1) {
                if (!TextUtils.isEmpty(mdeSpaceId) && !"coedit:///".equals(notesDocumentEntity.getCategoryUuid())) {
                    RequestToSyncManager.INSTANCE.requestShareBackground(mdeSpaceId);
                }
                DataLogger.m12302d(str, "postGroupShareOperation, title : " + DataLogger.getEncode(notesDocumentEntity.getTitle()));
                if (TextUtils.isEmpty(mdeSpaceId) || !"coedit:///".equals(notesDocumentEntity.getCategoryUuid())) {
                    return;
                }
                RequestToSyncManager.INSTANCE.requestCoeditUpdateItemData(mdeSpaceId, notesDocumentEntity.getUuid(), notesDocumentEntity.getMdeItemId());
            }
        } catch (Exception e) {
            AbstractC11014a.m12333r(e, new StringBuilder("postGroupShareOperation, e : "), TAG);
        }
    }

    private void postSyncOperation(@NonNull NotesDocumentEntity notesDocumentEntity) {
        DataToSyncManager.getInstance().onPostDocumentSaved(notesDocumentEntity);
    }

    private void postTagOperation(@NonNull NotesDocumentEntity notesDocumentEntity) {
        DataLogger.m12307i(TAG, "postTagOperation");
        try {
            NotesDataRepositoryFactory.newInstance(getContext()).createDocumentTagRepository().notifyTagBoardByUuid(notesDocumentEntity.getUuid());
        } catch (Exception e) {
            AbstractC11014a.m12333r(e, new StringBuilder("postTagOperation, e : "), TAG);
        }
    }

    private void postWidgetBroadcastOperation(@NonNull NotesDocumentEntity notesDocumentEntity) {
        if ("coedit:///".equals(notesDocumentEntity.getCategoryUuid())) {
            DataLogger.m12302d(TAG, "postWidgetBroadcastOperation, skip for coedit note: " + notesDocumentEntity.getUuid());
            return;
        }
        WidgetAccessContract widgetAccessContract = WidgetAccessHandler.getWidgetAccessContract();
        if (widgetAccessContract == null) {
            DataLogger.m12302d(TAG, "postWidgetBroadcastOperation, contract is null");
            return;
        }
        DataLogger.m12307i(TAG, "postWidgetBroadcastOperation, isNew : " + isNewDocument() + ", getWidgetId : " + notesDocumentEntity.getWidgetId());
        try {
            if (isNewDocument() && notesDocumentEntity.getWidgetId() != -1) {
                widgetAccessContract.sendPickWidgetBroadcast(getContext(), notesDocumentEntity.getUuid(), notesDocumentEntity.getFilePath(), notesDocumentEntity.getWidgetId());
                return;
            }
            widgetAccessContract.sendUpdateUuidWidgetBroadcast(getContext(), notesDocumentEntity.getUuid());
            if (notesDocumentEntity.isUpdateContents()) {
                widgetAccessContract.sendUpdateUuidWidgetListSettingBroadcast(getContext(), notesDocumentEntity.getUuid(), BaseWidgetConstant.ACTION_WIDGET_LIST_SETTING_UPDATE);
            }
        } catch (Exception e) {
            AbstractC11014a.m12333r(e, new StringBuilder("postWidgetBroadcastOperation, e : "), TAG);
        }
    }

    public boolean checkStrategy(@SaveOperation.Strategy int i) {
        return (i & this.mStrategy) != 0;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean isNewDocument() {
        return this.mIsNewDocument;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (checkStrategy(2)) {
            postWidgetBroadcastOperation(this.mParam);
        }
        if (checkStrategy(8)) {
            postCollectOperation(this.mParam);
        }
        if (checkStrategy(16)) {
            postSyncOperation(this.mParam);
        }
        if (checkStrategy(4)) {
            postTagOperation(this.mParam);
        }
        if (checkStrategy(32)) {
            postGroupShareOperation(this.mParam);
        }
    }

    public DocumentPostSaveOperation setStrategy(int i) {
        this.mStrategy = i;
        return this;
    }

    public DocumentPostSaveOperation(@NonNull Context context, boolean z, @NonNull NotesDocumentEntity notesDocumentEntity, List<String> list, @SearchConstants.Source int i) {
        this.mStrategy = 62;
        this.mContext = context;
        this.mIsNewDocument = z;
        this.mParam = notesDocumentEntity;
        this.mChangedPageIdList = list;
        this.mSearchSource = i;
    }
}
