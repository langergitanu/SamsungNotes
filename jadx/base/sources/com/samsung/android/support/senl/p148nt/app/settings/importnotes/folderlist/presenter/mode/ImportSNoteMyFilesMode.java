package com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.mode;

import android.content.Intent;
import com.samsung.android.app.notes.sync.constants.DocTypeConstants;
import com.samsung.android.app.notes.sync.importing.controllers.C6756e;
import com.samsung.android.app.notes.sync.importing.core.types.AbstractImportType;
import com.samsung.android.app.notes.sync.importing.core.types.SnoteLocalImportType;
import com.samsung.android.app.notes.sync.items.ImportItem;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.ImportFolderPresenterContract;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.mode.ImportFolderMode;
import com.samsung.android.support.senl.p148nt.base.common.util.ContentPickerUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p042J1.AbstractC0155m;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\"\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\u0018\u0010\u0018\u001a\u00020\u00192\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bH\u0016J\b\u0010\u001d\u001a\u00020\u0010H\u0016R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000e¨\u0006\u001f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/mode/ImportSNoteMyFilesMode;", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/mode/ImportSNoteMode;", "presenterContract", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/ImportFolderPresenterContract;", "modeContract", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/mode/ImportFolderMode$Contract;", "<init>", "(Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/ImportFolderPresenterContract;Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/mode/ImportFolderMode$Contract;)V", "importType", "Lcom/samsung/android/app/notes/sync/constants/DocTypeConstants;", "getImportType", "()Lcom/samsung/android/app/notes/sync/constants/DocTypeConstants;", "isLocalNotePickerNeeds", "", "()Z", "onCreate", "", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onActivityResultFromLocalNotePickerActivity", "getAbstractImportType", "Lcom/samsung/android/app/notes/sync/importing/core/types/AbstractImportType;", "importItems", "", "Lcom/samsung/android/app/notes/sync/items/ImportItem;", "requestImportList", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ImportSNoteMyFilesMode extends ImportSNoteMode {

    @NotNull
    private static final String TAG = "ImportSNoteMyFilesMode";

    public ImportSNoteMyFilesMode(@Nullable ImportFolderPresenterContract importFolderPresenterContract, @Nullable ImportFolderMode.Contract contract) {
        super(importFolderPresenterContract, contract);
        this.mSnoteImportListRequest = new C6756e(new SnoteLocalImportType(null));
    }

    private final void onActivityResultFromLocalNotePickerActivity(int resultCode, Intent data) throws Throwable {
        if (resultCode != -1 || data == null) {
            ImportFolderPresenterContract importFolderPresenterContract = this.mPresenterContract;
            if (importFolderPresenterContract != null) {
                importFolderPresenterContract.activityFinish();
                return;
            }
            return;
        }
        ArrayList arrayListM395j = AbstractC0155m.m395j(ContentPickerUtils.INSTANCE.getPathListFromResult(BaseUtils.getApplicationContext(), data));
        if (!arrayListM395j.isEmpty()) {
            Intrinsics.checkNotNull(arrayListM395j);
            startImportDirectly(arrayListM395j);
        } else {
            ImportFolderPresenterContract importFolderPresenterContract2 = this.mPresenterContract;
            if (importFolderPresenterContract2 != null) {
                importFolderPresenterContract2.activityFinish();
            }
            MainLogger.m7255e(TAG, "importItems is empty");
        }
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
    public boolean isLocalNotePickerNeeds() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.mode.ImportFolderMode
    public boolean onActivityResult(int requestCode, int resultCode, @Nullable Intent data) throws Throwable {
        if (requestCode != 3) {
            return super.onActivityResult(requestCode, resultCode, data);
        }
        onActivityResultFromLocalNotePickerActivity(resultCode, data);
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.mode.ImportFolderMode
    public void onCreate() {
        super.onCreate();
        ImportFolderPresenterContract importFolderPresenterContract = this.mPresenterContract;
        if (importFolderPresenterContract != null) {
            importFolderPresenterContract.startMyfilesPickerActivity();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.mode.ImportFolderMode
    public void requestImportList() {
        C6756e c6756e = this.mSnoteImportListRequest;
        Intrinsics.checkNotNull(c6756e);
        c6756e.m4895a(BaseUtils.getApplicationContext(), this.mImportSnoteListener);
    }
}
