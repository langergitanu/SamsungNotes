package com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.mode;

import android.content.Context;
import android.content.IntentFilter;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.constants.DocTypeConstants;
import com.samsung.android.app.notes.sync.importing.controllers.C6756e;
import com.samsung.android.app.notes.sync.importing.core.types.AbstractImportType;
import com.samsung.android.app.notes.sync.importing.core.types.SnoteLocalImportType;
import com.samsung.android.app.notes.sync.items.ImportItem;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.ImportFolderPresenterContract;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.mode.ImportFolderMode;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.receiver.ExternalStorageMountReceiver;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0002J\b\u0010\u0012\u001a\u00020\u000bH\u0002J\b\u0010\u0013\u001a\u00020\u000bH\u0002J\u0018\u0010\u0014\u001a\u00020\u00152\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u000bH\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/mode/ImportSNoteLocalMode;", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/mode/ImportSNoteMode;", "presenterContract", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/ImportFolderPresenterContract;", "modeContract", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/mode/ImportFolderMode$Contract;", "<init>", "(Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/ImportFolderPresenterContract;Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/mode/ImportFolderMode$Contract;)V", "mMediaMountReceiver", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/receiver/ExternalStorageMountReceiver;", "onResume", "", "onDestroy", "importType", "Lcom/samsung/android/app/notes/sync/constants/DocTypeConstants;", "getImportType", "()Lcom/samsung/android/app/notes/sync/constants/DocTypeConstants;", "registerMediaMountReceiver", "receiverHandlePendingRefresh", "unregisterMediaMountReceiver", "getAbstractImportType", "Lcom/samsung/android/app/notes/sync/importing/core/types/AbstractImportType;", "importItems", "", "Lcom/samsung/android/app/notes/sync/items/ImportItem;", "requestImportList", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ImportSNoteLocalMode extends ImportSNoteMode {

    @NotNull
    private static final String ACTION_MEDIA_SCAN_FINISHED = "android.intent.action.MEDIA_SCANNER_FINISHED";

    @NotNull
    private static final String MEDIA_SCAN_DATA_SCHEME = "file";

    @NotNull
    private static final String TAG = "ImportSNoteLocalMode";

    @Nullable
    private ExternalStorageMountReceiver mMediaMountReceiver;

    public ImportSNoteLocalMode(@Nullable ImportFolderPresenterContract importFolderPresenterContract, @Nullable ImportFolderMode.Contract contract) {
        super(importFolderPresenterContract, contract);
        registerMediaMountReceiver();
        this.mSnoteImportListRequest = new C6756e(new SnoteLocalImportType(null));
    }

    private final void receiverHandlePendingRefresh() {
        if (isLocalNotePickerNeeds()) {
            ExternalStorageMountReceiver externalStorageMountReceiver = this.mMediaMountReceiver;
            Intrinsics.checkNotNull(externalStorageMountReceiver);
            externalStorageMountReceiver.handlePendingRefresh();
        }
    }

    private final void registerMediaMountReceiver() {
        if (isLocalNotePickerNeeds()) {
            this.mMediaMountReceiver = new ExternalStorageMountReceiver(this.mPresenterContract);
            IntentFilter intentFilter = new IntentFilter("android.intent.action.MEDIA_MOUNTED");
            intentFilter.addAction(ACTION_MEDIA_SCAN_FINISHED);
            intentFilter.addDataScheme("file");
            IntentFilter intentFilter2 = new IntentFilter("android.intent.action.MEDIA_UNMOUNTED");
            intentFilter2.addAction(ACTION_MEDIA_SCAN_FINISHED);
            intentFilter2.addDataScheme("file");
            try {
                Context applicationContext = BaseUtils.getApplicationContext();
                if (applicationContext != null) {
                    applicationContext.registerReceiver(this.mMediaMountReceiver, intentFilter);
                }
                Context applicationContext2 = BaseUtils.getApplicationContext();
                if (applicationContext2 != null) {
                    applicationContext2.registerReceiver(this.mMediaMountReceiver, intentFilter2);
                }
            } catch (IllegalArgumentException e) {
                AbstractC6670b.m4738C("unregisterMediaMountReceiver# IllegalArgumentException: ", e.getMessage(), TAG);
            } catch (SecurityException e2) {
                AbstractC6670b.m4738C("unregisterMediaMountReceiver# SecurityException: ", e2.getMessage(), TAG);
            }
        }
    }

    private final void unregisterMediaMountReceiver() {
        if (isLocalNotePickerNeeds()) {
            try {
                Context applicationContext = BaseUtils.getApplicationContext();
                if (applicationContext != null) {
                    applicationContext.unregisterReceiver(this.mMediaMountReceiver);
                }
            } catch (IllegalArgumentException e) {
                AbstractC6670b.m4738C("unregisterMediaMountReceiver# IllegalArgumentException: ", e.getMessage(), TAG);
            } catch (SecurityException e2) {
                AbstractC6670b.m4738C("unregisterMediaMountReceiver# SecurityException: ", e2.getMessage(), TAG);
            }
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
    public void onDestroy() {
        super.onDestroy();
        receiverHandlePendingRefresh();
        unregisterMediaMountReceiver();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.mode.ImportFolderMode
    public void onResume() {
        super.onResume();
        receiverHandlePendingRefresh();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.mode.ImportFolderMode
    public void requestImportList() {
        C6756e c6756e = this.mSnoteImportListRequest;
        if (c6756e != null) {
            c6756e.m4895a(BaseUtils.getApplicationContext(), this.mImportSnoteListener);
        }
    }
}
