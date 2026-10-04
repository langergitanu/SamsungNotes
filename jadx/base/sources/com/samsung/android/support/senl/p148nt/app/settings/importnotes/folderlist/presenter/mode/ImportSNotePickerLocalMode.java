package com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.mode;

import android.os.Environment;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.app.notes.sync.constants.DocTypeConstants;
import com.samsung.android.app.notes.sync.importing.controllers.C6756e;
import com.samsung.android.app.notes.sync.importing.core.types.AbstractImportType;
import com.samsung.android.app.notes.sync.importing.core.types.SnoteLocalImportType;
import com.samsung.android.app.notes.sync.items.ImportItem;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.ImportFolderPresenterContract;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.mode.ImportFolderMode;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0016J\b\u0010\u0013\u001a\u00020\rH\u0016R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/mode/ImportSNotePickerLocalMode;", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/mode/ImportSNoteMode;", "presenterContract", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/ImportFolderPresenterContract;", "modeContract", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/mode/ImportFolderMode$Contract;", "<init>", "(Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/ImportFolderPresenterContract;Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/mode/ImportFolderMode$Contract;)V", "importType", "Lcom/samsung/android/app/notes/sync/constants/DocTypeConstants;", "getImportType", "()Lcom/samsung/android/app/notes/sync/constants/DocTypeConstants;", "setValidateFolderPath", "", "getAbstractImportType", "Lcom/samsung/android/app/notes/sync/importing/core/types/AbstractImportType;", "importItems", "", "Lcom/samsung/android/app/notes/sync/items/ImportItem;", "requestImportList", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ImportSNotePickerLocalMode extends ImportSNoteMode {

    @NotNull
    private static final String PICKER_FILE_NAME = "SamsungNotes";

    @NotNull
    private static final String TAG = "ImportSNotePickerLocalMode";

    public ImportSNotePickerLocalMode(@Nullable ImportFolderPresenterContract importFolderPresenterContract, @Nullable ImportFolderMode.Contract contract) {
        super(importFolderPresenterContract, contract);
        this.mSnoteImportListRequest = new C6756e(new SnoteLocalImportType(null));
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.mode.ImportSNoteMode
    @NotNull
    public AbstractImportType getAbstractImportType(@Nullable List<? extends ImportItem> importItems) {
        return new SnoteLocalImportType(importItems);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.mode.ImportFolderMode
    @NotNull
    public DocTypeConstants getImportType() {
        return DocTypeConstants.SNOTE_LOCAL;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.mode.ImportFolderMode
    public void requestImportList() {
        C6756e c6756e = this.mSnoteImportListRequest;
        Intrinsics.checkNotNull(c6756e);
        c6756e.m4895a(BaseUtils.getApplicationContext(), this.mImportSnoteListener);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.mode.ImportFolderMode
    public void setValidateFolderPath() {
        ImportFolderPresenterContract importFolderPresenterContract = this.mPresenterContract;
        if (importFolderPresenterContract == null || !importFolderPresenterContract.isRootFolder()) {
            return;
        }
        String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
        String str = File.separator;
        File file = new File(AbstractC0541b.m757C(path, str, PICKER_FILE_NAME));
        if (!file.exists() && !file.mkdirs()) {
            MainLogger.m7255e(TAG, "make file failed");
            this.mPresenterContract.activityFinish();
            return;
        }
        this.mPresenterContract.updateValidateFolderPath(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getName() + str + PICKER_FILE_NAME);
    }
}
