package com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.presenter;

import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.constants.DocTypeConstants;
import com.samsung.android.app.notes.sync.items.ImportItem;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.request.ImportHandler;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.request.ImportResult;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.model.ImportDocumentModel;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.presenter.ImportDocumentPresenterContract;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.presenter.ImportDocumentResultContract;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.presenter.converter.ImportItemConverter;
import com.samsung.android.support.senl.p148nt.app.sync.p150ui.dialog.NetworkConnectionFailedHelper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 $2\u00020\u0001:\u0001$B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\"\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0015H\u0016J4\u0010\u0016\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u000e\u0010\u001b\u001a\n\u0018\u00010\u001cj\u0004\u0018\u0001`\u001dH\u0016J,\u0010\u001e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u00182\b\u0010!\u001a\u0004\u0018\u00010\fH\u0016J$\u0010\"\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010!\u001a\u0004\u0018\u00010\f2\u0006\u0010#\u001a\u00020\u0018H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bj\n\u0012\u0006\u0012\u0004\u0018\u00010\f`\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/presenter/ImportDocumentResult;", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/common/request/ImportResult;", "mView", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/presenter/ImportDocumentPresenterContract$IView;", "mDialog", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/presenter/ImportDocumentPresenterContract$IDialog;", "mPresenter", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/presenter/ImportDocumentResultContract$IPresenter;", "<init>", "(Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/presenter/ImportDocumentPresenterContract$IView;Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/presenter/ImportDocumentPresenterContract$IDialog;Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/presenter/ImportDocumentResultContract$IPresenter;)V", "mImportItems", "Ljava/util/ArrayList;", "Lcom/samsung/android/app/notes/sync/items/ImportItem;", "Lkotlin/collections/ArrayList;", "onSyncEnded", "", "type", "Lcom/samsung/android/app/notes/sync/constants/DocTypeConstants;", "onGetListEnded", "onImportEnded", "items", "", "onError", "errorCode", "", "message", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onUpdated", "now", ImportHandler.KEY_TOTAL, "item", "onDownloaded", "state", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ImportDocumentResult implements ImportResult {

    @NotNull
    private static final String TAG = "ST$ImportDocumentResult";

    @NotNull
    private final ImportDocumentPresenterContract.IDialog mDialog;

    @NotNull
    private final ArrayList<ImportItem> mImportItems;

    @NotNull
    private final ImportDocumentResultContract.IPresenter mPresenter;

    @NotNull
    private final ImportDocumentPresenterContract.IView mView;

    public ImportDocumentResult(@NotNull ImportDocumentPresenterContract.IView mView, @NotNull ImportDocumentPresenterContract.IDialog mDialog, @NotNull ImportDocumentResultContract.IPresenter mPresenter) {
        Intrinsics.checkNotNullParameter(mView, "mView");
        Intrinsics.checkNotNullParameter(mDialog, "mDialog");
        Intrinsics.checkNotNullParameter(mPresenter, "mPresenter");
        this.mView = mView;
        this.mDialog = mDialog;
        this.mPresenter = mPresenter;
        this.mImportItems = new ArrayList<>();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.request.ImportResult
    public void onDownloaded(@Nullable DocTypeConstants type, @Nullable ImportItem item, int state) {
        MainLogger.m7258i(TAG, "onDownloaded() on UI thread");
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.request.ImportResult
    public void onError(@Nullable DocTypeConstants type, int errorCode, @Nullable String message, @Nullable Exception e) {
        MainLogger.m7255e(TAG, "onError() on UI thread");
        if (this.mView.getContext() == null) {
            MainLogger.m7258i(TAG, "onError() context is null");
            return;
        }
        if (errorCode == 101) {
            NetworkConnectionFailedHelper.getInstance().show(this.mView.getContext(), 2);
        } else if (errorCode == 201) {
            this.mDialog.showErrorDialog();
        }
        this.mDialog.dismissCancelDownloadingDialog();
        this.mView.updateNoNotes();
        this.mPresenter.unregisterImportListRequest();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.request.ImportResult
    public void onGetListEnded(@Nullable DocTypeConstants type) {
        MainLogger.m7258i(TAG, "onGetListEnded() on UI thread");
        this.mDialog.dismissCancelDownloadingDialog();
        this.mView.updateNoNotes();
        this.mView.updateSelectedItemCount();
        this.mPresenter.unregisterImportListRequest();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.request.ImportResult
    public void onImportEnded(@Nullable DocTypeConstants type, @Nullable List<? extends ImportItem> items) {
        MainLogger.m7258i(TAG, "onImportEnded() on UI thread");
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.request.ImportResult
    public void onSyncEnded(@Nullable DocTypeConstants type) {
        MainLogger.m7258i(TAG, "onSyncEnded() on UI thread");
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.request.ImportResult
    public void onUpdated(@Nullable DocTypeConstants type, int now, int total, @Nullable ImportItem item) {
        MainLogger.m7258i(TAG, "onUpdated on UI thread : now = " + now + "/" + total);
        ImportDocumentModel importDocumentModel = new ImportDocumentModel();
        if (item == null || !item.getDownloadCompleted()) {
            importDocumentModel.setImportItem(item);
            importDocumentModel.setCategory(item != null ? item.getContainerName() : null);
            this.mPresenter.addRecyclerViewItem(importDocumentModel);
            if (this.mPresenter.getItemCount() >= total) {
                this.mDialog.dismissCancelDownloadingDialog();
                if (this.mDialog.isCancelDownloadingDialogAdded()) {
                    this.mView.updateNoNotes();
                    this.mView.updateSelectedItemCount();
                }
            }
        } else {
            try {
                importDocumentModel.setMemoMetaDataItem(ImportItemConverter.fromImportItem(item, this.mView.getContext()));
                importDocumentModel.setImportItem(item);
                importDocumentModel.setCategory(item.getContainerName());
                importDocumentModel.setDataType(2);
                this.mPresenter.addRecyclerViewItem(importDocumentModel);
            } catch (IOException e) {
                AbstractC6670b.m4738C("IOException :", e.getMessage(), TAG);
            } catch (JSONException e2) {
                AbstractC6670b.m4738C("IOException :", e2.getMessage(), TAG);
            }
        }
        if (this.mImportItems.contains(item)) {
            return;
        }
        this.mPresenter.addCategorySpinnerItem(item != null ? item.getContainerName() : null);
        this.mImportItems.add(item);
    }
}
