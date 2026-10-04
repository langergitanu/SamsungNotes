package com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter;

import androidx.appcompat.widget.AbstractC0541b;
import com.google.api.client.googleapis.extensions.android.gms.auth.UserRecoverableAuthIOException;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.constants.DocTypeConstants;
import com.samsung.android.app.notes.sync.items.ImportItem;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.request.ImportHandler;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.request.ImportResult;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.model.ImportFolderInfo;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.mode.ImportFolderMode;
import com.samsung.android.support.senl.p148nt.app.sync.p150ui.dialog.NetworkConnectionFailedHelper;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\"\u0010\u000f\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0016J4\u0010\u0013\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\t2\u000e\u0010\u0017\u001a\n\u0018\u00010\u0018j\u0004\u0018\u0001`\u0019H\u0016J,\u0010\u001a\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\u0012H\u0016J$\u0010\u001e\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001f\u001a\u00020\u0015H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000¨\u0006 "}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/ImportSNoteResult;", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/common/request/ImportResult;", "mPresenterContract", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/ImportFolderPresenterContract;", "mModeContract", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/mode/ImportFolderMode$Contract;", "<init>", "(Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/ImportFolderPresenterContract;Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/mode/ImportFolderMode$Contract;)V", SearchConstants.TargetContents.TAG, "", "onSyncEnded", "", "type", "Lcom/samsung/android/app/notes/sync/constants/DocTypeConstants;", "onGetListEnded", "onImportEnded", "items", "", "Lcom/samsung/android/app/notes/sync/items/ImportItem;", "onError", "errorCode", "", "message", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onUpdated", "now", ImportHandler.KEY_TOTAL, "item", "onDownloaded", "state", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nImportSNoteResult.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImportSNoteResult.kt\ncom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/ImportSNoteResult\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,101:1\n1#2:102\n*E\n"})
public final class ImportSNoteResult implements ImportResult {

    @NotNull
    private final String TAG = "ST$ImportSNoteResult";

    @Nullable
    private final ImportFolderMode.Contract mModeContract;

    @Nullable
    private final ImportFolderPresenterContract mPresenterContract;

    public ImportSNoteResult(@Nullable ImportFolderPresenterContract importFolderPresenterContract, @Nullable ImportFolderMode.Contract contract) {
        this.mPresenterContract = importFolderPresenterContract;
        this.mModeContract = contract;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.request.ImportResult
    public void onDownloaded(@Nullable DocTypeConstants type, @Nullable ImportItem item, int state) {
        MainLogger.m7258i(this.TAG, "onDownloaded() on UI thread");
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.request.ImportResult
    public void onError(@Nullable DocTypeConstants type, int errorCode, @Nullable String message, @Nullable Exception e) {
        ImportFolderPresenterContract importFolderPresenterContract;
        MainLogger.m7255e(this.TAG, "onError() on UI thread");
        if (errorCode == 101) {
            NetworkConnectionFailedHelper.getInstance().show(BaseUtils.getApplicationContext(), 2);
        } else if (errorCode == 201 && (importFolderPresenterContract = this.mPresenterContract) != null) {
            importFolderPresenterContract.showErrorDialog();
        }
        if (type != DocTypeConstants.SNOTE_GOOGLEDRIVE) {
            ImportFolderPresenterContract importFolderPresenterContract2 = this.mPresenterContract;
            if (importFolderPresenterContract2 != null) {
                importFolderPresenterContract2.dismissFileDownloadingDialog();
            }
            ImportFolderPresenterContract importFolderPresenterContract3 = this.mPresenterContract;
            if (importFolderPresenterContract3 != null) {
                importFolderPresenterContract3.updateLayout();
                return;
            }
            return;
        }
        MainLogger.m7258i(this.TAG, "onError() : type is TYPE_SNOTE_GOOGLEDRIVE");
        if (errorCode != 901) {
            MainLogger.m7258i(this.TAG, "onError() : other errorCodes!");
            ImportFolderPresenterContract importFolderPresenterContract4 = this.mPresenterContract;
            if (importFolderPresenterContract4 != null) {
                importFolderPresenterContract4.dismissFileDownloadingDialog();
            }
            ImportFolderPresenterContract importFolderPresenterContract5 = this.mPresenterContract;
            if (importFolderPresenterContract5 != null) {
                importFolderPresenterContract5.updateLayout();
                return;
            }
            return;
        }
        MainLogger.m7258i(this.TAG, "onError() : cause is SyncService.ERROR_CODE_GOOGLEDRIVE_AUTHENTICATION");
        if (!(e instanceof UserRecoverableAuthIOException)) {
            AbstractC6670b.m4738C("not UserRecoverableAuthIOException - ", e == null ? "" : e.getMessage(), this.TAG);
            return;
        }
        try {
            ImportFolderPresenterContract importFolderPresenterContract6 = this.mPresenterContract;
            if (importFolderPresenterContract6 != null) {
                importFolderPresenterContract6.startRequestAuthorizationActivity(((UserRecoverableAuthIOException) e).getIntent());
                Unit unit = Unit.INSTANCE;
            }
        } catch (Exception e2) {
            AbstractC6670b.m4738C("Exception : ", e2.getMessage(), this.TAG);
            Unit unit2 = Unit.INSTANCE;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.request.ImportResult
    public void onGetListEnded(@Nullable DocTypeConstants type) {
        MainLogger.m7258i(this.TAG, "onGetListEnded() on UI thread");
        ImportFolderPresenterContract importFolderPresenterContract = this.mPresenterContract;
        if (importFolderPresenterContract != null) {
            importFolderPresenterContract.setValidateFolderPath();
        }
        ImportFolderPresenterContract importFolderPresenterContract2 = this.mPresenterContract;
        if (importFolderPresenterContract2 != null) {
            importFolderPresenterContract2.notifyDataSetChanged();
        }
        ImportFolderPresenterContract importFolderPresenterContract3 = this.mPresenterContract;
        if (importFolderPresenterContract3 != null) {
            importFolderPresenterContract3.updateSelectedItemCount();
        }
        ImportFolderPresenterContract importFolderPresenterContract4 = this.mPresenterContract;
        if (importFolderPresenterContract4 != null) {
            importFolderPresenterContract4.dismissFileDownloadingDialog();
        }
        ImportFolderPresenterContract importFolderPresenterContract5 = this.mPresenterContract;
        if (importFolderPresenterContract5 != null) {
            importFolderPresenterContract5.updateLayout();
        }
        ImportFolderPresenterContract importFolderPresenterContract6 = this.mPresenterContract;
        if (importFolderPresenterContract6 != null) {
            importFolderPresenterContract6.updateFolderLayout();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.request.ImportResult
    public void onImportEnded(@Nullable DocTypeConstants type, @Nullable List<? extends ImportItem> items) {
        MainLogger.m7258i(this.TAG, "onImportEnded() on UI thread");
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.request.ImportResult
    public void onSyncEnded(@Nullable DocTypeConstants type) {
        MainLogger.m7258i(this.TAG, "onSyncEnded() on UI thread");
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.request.ImportResult
    public void onUpdated(@Nullable DocTypeConstants type, int now, int total, @Nullable ImportItem item) {
        ImportFolderMode.Contract contract;
        String strM756B = AbstractC0541b.m756B((item == null || (contract = this.mModeContract) == null) ? null : contract.getBaseDisplayDirectory(type, item.getLocationType()), item != null ? item.getContainerName() : null);
        ImportFolderMode.Contract contract2 = this.mModeContract;
        if (contract2 != null) {
            contract2.addFileData(new ImportFolderInfo(2, item, strM756B, item != null ? item.getContent() : null));
        }
    }
}
