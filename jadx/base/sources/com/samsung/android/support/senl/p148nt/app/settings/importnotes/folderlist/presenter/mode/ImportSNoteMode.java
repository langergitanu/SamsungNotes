package com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.mode;

import android.content.Intent;
import com.samsung.android.app.notes.sync.importing.controllers.C6756e;
import com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask;
import com.samsung.android.app.notes.sync.importing.core.types.AbstractImportType;
import com.samsung.android.app.notes.sync.importing.core.types.BasicImportHelperAdapter;
import com.samsung.android.app.notes.sync.items.ImportItem;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.request.ImportHandler;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.request.ImportRequestListener;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.model.ImportFolderInfo;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.ImportFolderPresenterContract;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.ImportSNoteResult;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.mode.ImportFolderMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p248v0.C14497a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b&\u0018\u0000 &2\u00020\u0001:\u0001&B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0010\u001a\u00020\n2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\r2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0016\u001a\u00020\n2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\rH\u0004¢\u0006\u0004\b\u0016\u0010\u0011J\u000f\u0010\u0017\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001a\u001a\u00020\u00192\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\rH&¢\u0006\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0004@\u0004X\u0085\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010%\u001a\u00020\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006'"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/mode/ImportSNoteMode;", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/mode/ImportFolderMode;", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/ImportFolderPresenterContract;", "presenterContract", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/mode/ImportFolderMode$Contract;", "modeContract", "<init>", "(Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/ImportFolderPresenterContract;Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/mode/ImportFolderMode$Contract;)V", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/common/request/ImportRequestListener;", "importRequestListener", "", "initImportRequestListener", "(Lcom/samsung/android/support/senl/nt/app/settings/importnotes/common/request/ImportRequestListener;)V", "", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/model/ImportFolderInfo;", "importFolderInfos", "startImport", "(Ljava/util/List;)V", "Lcom/samsung/android/app/notes/sync/items/ImportItem;", "getImportItems", "(Ljava/util/List;)Ljava/util/List;", "importItems", "startImportDirectly", "unregisterImportListRequest", "()V", "Lcom/samsung/android/app/notes/sync/importing/core/types/AbstractImportType;", "getAbstractImportType", "(Ljava/util/List;)Lcom/samsung/android/app/notes/sync/importing/core/types/AbstractImportType;", "Lcom/samsung/android/app/notes/sync/importing/controllers/e;", "mSnoteImportListRequest", "Lcom/samsung/android/app/notes/sync/importing/controllers/e;", "Lcom/samsung/android/app/notes/sync/importing/core/tasks/ImportBaseTask$Listener;", "mImportSnoteListener", "Lcom/samsung/android/app/notes/sync/importing/core/tasks/ImportBaseTask$Listener;", "", "getAppNameRes", "()I", "appNameRes", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nImportSNoteMode.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImportSNoteMode.kt\ncom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/mode/ImportSNoteMode\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,91:1\n1#2:92\n*E\n"})
public abstract class ImportSNoteMode extends ImportFolderMode {

    @NotNull
    private static final String TAG = "ImportSNoteMode";

    @JvmField
    @Nullable
    protected ImportBaseTask.Listener mImportSnoteListener;

    @JvmField
    @Nullable
    public C6756e mSnoteImportListRequest;

    public ImportSNoteMode(@Nullable ImportFolderPresenterContract importFolderPresenterContract, @Nullable ImportFolderMode.Contract contract) {
        super(importFolderPresenterContract, contract);
        initImportRequestListener(new ImportRequestListener(new ImportHandler(new ImportSNoteResult(importFolderPresenterContract, contract))));
    }

    @NotNull
    public abstract AbstractImportType getAbstractImportType(@Nullable List<? extends ImportItem> importItems);

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.mode.ImportFolderMode
    public int getAppNameRes() {
        return C8003R.string.settings_import_downloading_dialog_snote;
    }

    @NotNull
    public final List<ImportItem> getImportItems(@Nullable List<ImportFolderInfo> importFolderInfos) {
        ArrayList arrayList = new ArrayList();
        if (importFolderInfos != null) {
            Iterator<ImportFolderInfo> it = importFolderInfos.iterator();
            while (it.hasNext()) {
                ImportItem item = it.next().getItem();
                if (item != null) {
                    arrayList.add(item);
                }
            }
        }
        return arrayList;
    }

    public final void initImportRequestListener(@Nullable ImportRequestListener importRequestListener) {
        this.mImportSnoteListener = importRequestListener;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.mode.ImportFolderMode
    public void startImport(@Nullable List<ImportFolderInfo> importFolderInfos) {
        startImportDirectly(getImportItems(importFolderInfos));
    }

    public final void startImportDirectly(@NotNull List<? extends ImportItem> importItems) {
        Intrinsics.checkNotNullParameter(importItems, "importItems");
        MainLogger.m7258i(TAG, "startImport()");
        if (importItems.isEmpty()) {
            ImportFolderPresenterContract importFolderPresenterContract = this.mPresenterContract;
            if (importFolderPresenterContract != null) {
                importFolderPresenterContract.activityFinish();
                return;
            }
            return;
        }
        C14497a.m15078a().m15081d(getAbstractImportType(importItems));
        Intent intent = new Intent();
        intent.setAction(NotesConstants.ACTION_IMPORT_NOTES);
        ImportFolderPresenterContract importFolderPresenterContract2 = this.mPresenterContract;
        if (importFolderPresenterContract2 != null) {
            importFolderPresenterContract2.backToNoteList(intent);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.mode.ImportFolderMode
    public void unregisterImportListRequest() {
        if (this.mSnoteImportListRequest != null) {
            MainLogger.m7258i(TAG, "unregisterImportListRequest# ");
            C6756e c6756e = this.mSnoteImportListRequest;
            Intrinsics.checkNotNull(c6756e);
            BasicImportHelperAdapter basicImportHelperAdapter = c6756e.f4152c;
            if (basicImportHelperAdapter != null) {
                basicImportHelperAdapter.getImportHelper().setImportListener(null);
                c6756e.f4152c.getImportHelper().stop();
            }
            this.mSnoteImportListRequest = null;
        }
    }
}
