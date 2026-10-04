package com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.mode;

import android.content.Intent;
import android.text.TextUtils;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.drive.Drive;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.constants.DocTypeConstants;
import com.samsung.android.app.notes.sync.importing.controllers.C6756e;
import com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask;
import com.samsung.android.app.notes.sync.importing.core.types.AbstractImportType;
import com.samsung.android.app.notes.sync.importing.core.types.SnoteGoogleDriveImportType;
import com.samsung.android.app.notes.sync.items.ImportItem;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.ImportFolderPresenterContract;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.mode.ImportFolderMode;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p042J1.C0145c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 52\u00020\u0001:\u00015B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000f\u001a\u00020\u00102\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0018\u0010\u001b\u001a\u00020\u001c2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eH\u0016J\"\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u00122\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u001a\u0010&\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u00122\b\u0010$\u001a\u0004\u0018\u00010%H\u0002J\u0010\u0010'\u001a\u00020\u00102\u0006\u0010(\u001a\u00020!H\u0002J\u0012\u0010)\u001a\u00020!2\b\u0010*\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010)\u001a\u00020!H\u0002J\b\u0010+\u001a\u00020\u0010H\u0016J\b\u0010,\u001a\u00020\u0010H\u0016J\b\u0010-\u001a\u00020\u0010H\u0002J\b\u0010.\u001a\u00020\u0010H\u0002J\b\u0010/\u001a\u00020\u0010H\u0002J\b\u00100\u001a\u00020\u0010H\u0002J\u0010\u00101\u001a\u00020\u00102\b\u00102\u001a\u0004\u0018\u00010\u000bJ\u0012\u00103\u001a\u00020\r2\b\u00104\u001a\u0004\u0018\u00010\u000bH\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u00066"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/mode/ImportSNoteGoogleDriveMode;", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/mode/ImportSNoteMode;", "presenterContract", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/ImportFolderPresenterContract;", "modeContract", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/mode/ImportFolderMode$Contract;", "googleAccountName", "", "<init>", "(Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/ImportFolderPresenterContract;Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/mode/ImportFolderMode$Contract;Ljava/lang/String;)V", "mCredential", "Lcom/google/api/client/googleapis/extensions/android/gms/auth/GoogleAccountCredential;", "mDrive", "Lcom/google/api/services/drive/Drive;", "mGoogleAccountName", "setGoogleAccountName", "", "rootFolderRes", "", "getRootFolderRes", "()I", "noNoteTextRes", "getNoNoteTextRes", "importType", "Lcom/samsung/android/app/notes/sync/constants/DocTypeConstants;", "getImportType", "()Lcom/samsung/android/app/notes/sync/constants/DocTypeConstants;", "getAbstractImportType", "Lcom/samsung/android/app/notes/sync/importing/core/types/AbstractImportType;", "importItems", "", "Lcom/samsung/android/app/notes/sync/items/ImportItem;", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onActivityResultFromGoogleDrivePicker", "onActivityResultFromGoogleDriveAuthentication", "requestAgain", "registerGoogleDriveImportListRequest", "accountName", "requestImportList", "setValidateFolderPath", "initImportListRequest", "requestSNoteImportList", "connectGoogleDrive", "initGoogleDrive", "setGoogleAccountCredential", "googleAccountCredential", "getDriveService", "credential", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ImportSNoteGoogleDriveMode extends ImportSNoteMode {

    @NotNull
    private static final String TAG = "ImportSNoteGoogleDriveMode";

    @Nullable
    private GoogleAccountCredential mCredential;

    @Nullable
    private Drive mDrive;

    @Nullable
    private String mGoogleAccountName;

    public ImportSNoteGoogleDriveMode(@Nullable ImportFolderPresenterContract importFolderPresenterContract, @Nullable ImportFolderMode.Contract contract, @Nullable String str) {
        super(importFolderPresenterContract, contract);
        setGoogleAccountName(str);
        initImportListRequest();
    }

    private final void connectGoogleDrive() {
        MainLogger.m7258i(TAG, "connectGoogleDrive# ");
        GoogleAccountCredential googleAccountCredential = this.mCredential;
        Intrinsics.checkNotNull(googleAccountCredential);
        Intent intentNewChooseAccountIntent = googleAccountCredential.newChooseAccountIntent();
        ImportFolderPresenterContract importFolderPresenterContract = this.mPresenterContract;
        if (importFolderPresenterContract != null) {
            importFolderPresenterContract.startGoogleDriveActivity(intentNewChooseAccountIntent);
        }
    }

    private final Drive getDriveService(GoogleAccountCredential credential) {
        Drive driveBuild = new Drive.Builder(AndroidHttp.newCompatibleTransport(), new GsonFactory(), credential).build();
        Intrinsics.checkNotNullExpressionValue(driveBuild, "build(...)");
        return driveBuild;
    }

    private final void initGoogleDrive() {
        if (this.mCredential == null) {
            setGoogleAccountCredential(GoogleAccountCredential.usingOAuth2(BaseUtils.getApplicationContext(), CollectionsKt.listOf("https://www.googleapis.com/auth/drive")));
        }
        if (TextUtils.isEmpty(this.mGoogleAccountName)) {
            MainLogger.m7258i(TAG, "initGoogleDrive#. Selected account name is not valid!");
            return;
        }
        try {
            GoogleAccountCredential googleAccountCredential = this.mCredential;
            if (googleAccountCredential != null) {
                googleAccountCredential.setSelectedAccountName(this.mGoogleAccountName);
            }
            this.mDrive = getDriveService(this.mCredential);
        } catch (NullPointerException e) {
            AbstractC8014b.m7209k("initGoogleDrive#. NullPointerException ", e.getMessage(), TAG);
        }
    }

    private final void initImportListRequest() {
        this.mSnoteImportListRequest = new C6756e(new SnoteGoogleDriveImportType(null, this.mGoogleAccountName, this.mDrive));
    }

    private final void onActivityResultFromGoogleDriveAuthentication(boolean requestAgain) {
        if (requestAgain) {
            MainLogger.m7258i(TAG, "onActivityResultFromGoogleDriveAuthentication# call requestGetLists() again");
            if (registerGoogleDriveImportListRequest()) {
                return;
            }
        }
        ImportFolderPresenterContract importFolderPresenterContract = this.mPresenterContract;
        if (importFolderPresenterContract != null) {
            importFolderPresenterContract.dismissFileDownloadingDialog();
        }
        ImportFolderPresenterContract importFolderPresenterContract2 = this.mPresenterContract;
        if (importFolderPresenterContract2 != null) {
            importFolderPresenterContract2.updateLayout();
        }
    }

    private final void onActivityResultFromGoogleDrivePicker(int resultCode, Intent data) {
        if (resultCode == -1 && data != null && registerGoogleDriveImportListRequest(data.getStringExtra("authAccount"))) {
            return;
        }
        MainLogger.m7258i(TAG, "onActivityResultFromGoogleDrivePicker# Fail to get Drive!");
        ImportFolderPresenterContract importFolderPresenterContract = this.mPresenterContract;
        if (importFolderPresenterContract != null) {
            importFolderPresenterContract.dismissFileDownloadingDialog();
        }
        ImportFolderPresenterContract importFolderPresenterContract2 = this.mPresenterContract;
        if (importFolderPresenterContract2 != null) {
            importFolderPresenterContract2.updateLayout();
        }
        if (TextUtils.isEmpty(this.mGoogleAccountName)) {
            MainLogger.m7258i(TAG, "onActivityResultFromGoogleDrivePicker# finish Fragment!");
            ImportFolderPresenterContract importFolderPresenterContract3 = this.mPresenterContract;
            if (importFolderPresenterContract3 != null) {
                importFolderPresenterContract3.activityFinish();
            }
        }
    }

    private final boolean registerGoogleDriveImportListRequest(String accountName) {
        if (TextUtils.isEmpty(accountName)) {
            return false;
        }
        setGoogleAccountName(accountName);
        initGoogleDrive();
        MainLogger.m7258i(TAG, "registerGoogleDriveImportListRequest# Drive is ready!");
        requestSNoteImportList();
        return true;
    }

    private final void requestSNoteImportList() {
        initImportListRequest();
        try {
            C6756e c6756e = this.mSnoteImportListRequest;
            if (c6756e != null) {
                c6756e.m4895a(BaseUtils.getApplicationContext(), this.mImportSnoteListener);
            }
        } catch (UnsupportedOperationException e) {
            AbstractC6670b.m4738C("requestSNoteImportList# UnsupportedOperationException: ", e.getMessage(), TAG);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.mode.ImportSNoteMode
    @NotNull
    public AbstractImportType getAbstractImportType(@Nullable List<? extends ImportItem> importItems) {
        return new SnoteGoogleDriveImportType(importItems, this.mGoogleAccountName, this.mDrive);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.mode.ImportFolderMode
    @NotNull
    public DocTypeConstants getImportType() {
        return DocTypeConstants.SNOTE_GOOGLEDRIVE;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.mode.ImportFolderMode
    public int getNoNoteTextRes() {
        return C8003R.string.settings_import_no_data_on_googledrive;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.mode.ImportFolderMode
    public int getRootFolderRes() {
        return C8003R.string.import_rootname_google_drive;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.mode.ImportFolderMode
    public boolean onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1) {
            onActivityResultFromGoogleDrivePicker(resultCode, data);
            return true;
        }
        if (requestCode != 2) {
            return super.onActivityResult(requestCode, resultCode, data);
        }
        onActivityResultFromGoogleDriveAuthentication(resultCode == -1);
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.mode.ImportFolderMode
    public void requestImportList() {
        if (!C0145c.m334s(BaseUtils.getApplicationContext())) {
            MainLogger.m7258i(TAG, "requestImportList#. Network is not Connected.");
            ImportBaseTask.Listener listener = this.mImportSnoteListener;
            if (listener != null) {
                listener.onImportError(DocTypeConstants.SNOTE_GOOGLEDRIVE, 101, "", null);
                return;
            }
            return;
        }
        initGoogleDrive();
        if (TextUtils.isEmpty(this.mGoogleAccountName)) {
            connectGoogleDrive();
        } else {
            MainLogger.m7258i(TAG, "requestImportList# Drive is ready again! call requestGetLists()");
            requestSNoteImportList();
        }
    }

    public final void setGoogleAccountCredential(@Nullable GoogleAccountCredential googleAccountCredential) {
        this.mCredential = googleAccountCredential;
    }

    public final void setGoogleAccountName(@Nullable String googleAccountName) {
        this.mGoogleAccountName = googleAccountName;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.mode.ImportFolderMode
    public void setValidateFolderPath() {
    }

    private final boolean registerGoogleDriveImportListRequest() {
        GoogleAccountCredential googleAccountCredential = this.mCredential;
        if (googleAccountCredential == null) {
            MainLogger.m7258i(TAG, "registerGoogleDriveImportListRequest# GoogleAccountCredential is null");
            return false;
        }
        if (this.mSnoteImportListRequest == null) {
            return false;
        }
        setGoogleAccountName(googleAccountCredential != null ? googleAccountCredential.getSelectedAccountName() : null);
        if (TextUtils.isEmpty(this.mGoogleAccountName)) {
            MainLogger.m7258i(TAG, "registerGoogleDriveImportListRequest# Selected account name is not valid!");
            return false;
        }
        requestSNoteImportList();
        return true;
    }
}
