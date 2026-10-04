package com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.mode;

import android.content.Intent;
import com.samsung.android.app.notes.sync.constants.DocTypeConstants;
import com.samsung.android.app.notes.sync.importing.core.types.ServerNoteLocalImportType;
import com.samsung.android.app.notes.sync.items.ImportItem;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.model.ImportFolderInfo;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.ImportFolderPresenterContract;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.mode.ImportFolderMode;
import com.samsung.android.support.senl.p148nt.base.common.util.ContentPickerUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p042J1.AbstractC0155m;
import p248v0.C14497a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 *2\u00020\u0001:\u0001*B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0012\u001a\u00020\u00132\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015H\u0016J \u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u00152\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015H\u0004J\b\u0010\u001d\u001a\u00020\u0013H\u0016J\"\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u000f2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u001a\u0010$\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u000f2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002J\u0018\u0010%\u001a\u00020\u00132\u000e\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0015H\u0004J\b\u0010'\u001a\u00020\u0013H\u0016J\b\u0010(\u001a\u00020\u0013H\u0016J\b\u0010)\u001a\u00020\u0013H\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006+"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/mode/ImportSDocxServerMode;", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/mode/ImportFolderMode;", "presenterContract", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/ImportFolderPresenterContract;", "modeContract", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/mode/ImportFolderMode$Contract;", "<init>", "(Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/ImportFolderPresenterContract;Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/mode/ImportFolderMode$Contract;)V", "mThread", "Ljava/lang/Thread;", "getMThread", "()Ljava/lang/Thread;", "setMThread", "(Ljava/lang/Thread;)V", "appNameRes", "", "getAppNameRes", "()I", "startImport", "", "importFolderInfos", "", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/model/ImportFolderInfo;", "getImportItems", "Lcom/samsung/android/app/notes/sync/items/ImportItem;", "importType", "Lcom/samsung/android/app/notes/sync/constants/DocTypeConstants;", "getImportType", "()Lcom/samsung/android/app/notes/sync/constants/DocTypeConstants;", "onCreate", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onActivityResultFromSNBAKPickerActivity", "startImportDirectly", "importItems", "requestImportList", "unregisterImportListRequest", "setValidateFolderPath", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ImportSDocxServerMode extends ImportFolderMode {

    @NotNull
    private static final String TAG = "ImportSDocxServerMode";

    @Nullable
    private Thread mThread;

    public ImportSDocxServerMode(@Nullable ImportFolderPresenterContract importFolderPresenterContract, @Nullable ImportFolderMode.Contract contract) {
        super(importFolderPresenterContract, contract);
    }

    private final void onActivityResultFromSNBAKPickerActivity(int resultCode, Intent data) throws Throwable {
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

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.mode.ImportFolderMode
    public int getAppNameRes() {
        return CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy() ? C8003R.string.notes_jp : C8003R.string.notes;
    }

    @NotNull
    public final List<ImportItem> getImportItems(@Nullable List<ImportFolderInfo> importFolderInfos) {
        ArrayList arrayList = new ArrayList();
        if (importFolderInfos != null) {
            Iterator<ImportFolderInfo> it = importFolderInfos.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getItem());
            }
        }
        return arrayList;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.mode.ImportFolderMode
    @NotNull
    public DocTypeConstants getImportType() {
        return DocTypeConstants.SDOCX_SCLOUD;
    }

    @Nullable
    public final Thread getMThread() {
        return this.mThread;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.mode.ImportFolderMode
    public boolean onActivityResult(int requestCode, int resultCode, @Nullable Intent data) throws Throwable {
        if (requestCode != 4) {
            return super.onActivityResult(requestCode, resultCode, data);
        }
        onActivityResultFromSNBAKPickerActivity(resultCode, data);
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.mode.ImportFolderMode
    public void onCreate() {
        super.onCreate();
        ImportFolderPresenterContract importFolderPresenterContract = this.mPresenterContract;
        if (importFolderPresenterContract != null) {
            importFolderPresenterContract.startSNBAKPickerActivity();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.mode.ImportFolderMode
    public void requestImportList() {
    }

    public final void setMThread(@Nullable Thread thread) {
        this.mThread = thread;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.mode.ImportFolderMode
    public void setValidateFolderPath() {
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.mode.ImportFolderMode
    public void startImport(@Nullable List<ImportFolderInfo> importFolderInfos) {
        startImportDirectly(getImportItems(importFolderInfos));
    }

    public final void startImportDirectly(@NotNull List<? extends ImportItem> importItems) {
        Intrinsics.checkNotNullParameter(importItems, "importItems");
        MainLogger.m7258i(TAG, "startImportDirectly()");
        C14497a.m15078a().m15081d(new ServerNoteLocalImportType(importItems));
        Intent intent = new Intent();
        intent.setAction(NotesConstants.ACTION_IMPORT_NOTES);
        ImportFolderPresenterContract importFolderPresenterContract = this.mPresenterContract;
        if (importFolderPresenterContract != null) {
            importFolderPresenterContract.backToNoteList(intent);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.mode.ImportFolderMode
    public void unregisterImportListRequest() {
    }
}
