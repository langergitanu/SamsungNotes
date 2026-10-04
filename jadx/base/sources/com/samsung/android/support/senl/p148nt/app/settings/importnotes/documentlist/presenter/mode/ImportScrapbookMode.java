package com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.presenter.mode;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.samsung.android.app.notes.sync.constants.DocTypeConstants;
import com.samsung.android.app.notes.sync.importing.core.types.AbstractImportType;
import com.samsung.android.app.notes.sync.importing.core.types.ScrapbookCloudImportType;
import com.samsung.android.app.notes.sync.items.ImportItem;
import com.samsung.android.app.notes.sync.quota.C6871d;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.RunnableC8669a;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.presenter.mode.ImportDocumentModeContract;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J&\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u001a\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bj\n\u0012\u0004\u0012\u00020\u001c\u0018\u0001`\u001dH\u0016R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/presenter/mode/ImportScrapbookMode;", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/presenter/mode/ImportDocumentMode;", "presenter", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/presenter/mode/ImportDocumentModeContract$IPresenter;", "<init>", "(Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/presenter/mode/ImportDocumentModeContract$IPresenter;)V", "onCreate", "", "taskType", "", "getTaskType", "()I", "defaultCategoryText", "getDefaultCategoryText", "appName", "", "getAppName", "()Ljava/lang/String;", "noNoteBodyText", "getNoNoteBodyText", "importType", "Lcom/samsung/android/app/notes/sync/constants/DocTypeConstants;", "getImportType", "()Lcom/samsung/android/app/notes/sync/constants/DocTypeConstants;", "getAbstractImportType", "Lcom/samsung/android/app/notes/sync/importing/core/types/AbstractImportType;", "importItems", "Ljava/util/ArrayList;", "Lcom/samsung/android/app/notes/sync/items/ImportItem;", "Lkotlin/collections/ArrayList;", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ImportScrapbookMode extends ImportDocumentMode {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImportScrapbookMode(@Nullable ImportDocumentModeContract.IPresenter iPresenter) {
        super(iPresenter);
        Intrinsics.checkNotNull(iPresenter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(ImportScrapbookMode importScrapbookMode) {
        if (importScrapbookMode.mPresenter.isCancelDownloadingEnded()) {
            return;
        }
        C6871d.m5056b().m5057a(importScrapbookMode.mSyncQuotaListener);
        C6871d.m5056b().m5058c(2);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.presenter.mode.ImportDocumentMode
    @Nullable
    public AbstractImportType getAbstractImportType(@Nullable ArrayList<ImportItem> importItems) {
        return new ScrapbookCloudImportType(importItems);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.presenter.mode.ImportDocumentMode
    @NotNull
    public String getAppName() {
        if (TextUtils.isEmpty(this.mAppName)) {
            Context applicationContext = BaseUtils.getApplicationContext();
            this.mAppName = applicationContext != null ? applicationContext.getString(C8003R.string.settings_import_downloading_dialog_scrapbook) : null;
        }
        String str = this.mAppName;
        Intrinsics.checkNotNull(str);
        return str;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.presenter.mode.ImportDocumentMode
    public int getDefaultCategoryText() {
        return C8003R.string.settings_import_memo_all_scrapbooks;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.presenter.mode.ImportDocumentMode
    @NotNull
    public DocTypeConstants getImportType() {
        return DocTypeConstants.SCRAPBOOK_SCLOUD;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.presenter.mode.ImportDocumentMode
    @NotNull
    public String getNoNoteBodyText() {
        String string;
        if (TextUtils.isEmpty(this.mNoNoteText)) {
            Context applicationContext = BaseUtils.getApplicationContext();
            if (applicationContext != null) {
                string = applicationContext.getString(CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy() ? C8003R.string.settings_import_no_data_on_samsungaccount_jp : C8003R.string.settings_import_no_data_on_samsungaccount, getAppName());
            } else {
                string = null;
            }
            this.mNoNoteText = string;
        }
        String str = this.mNoNoteText;
        Intrinsics.checkNotNull(str);
        return str;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.presenter.mode.ImportDocumentMode
    public int getTaskType() {
        return 201;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.presenter.mode.ImportDocumentMode
    public void onCreate() {
        if (this.mPresenter.isCancelDownloadingEnded()) {
            return;
        }
        Looper looperMyLooper = Looper.myLooper();
        Intrinsics.checkNotNull(looperMyLooper);
        new Handler(looperMyLooper).postDelayed(new RunnableC8669a(this, 10), 500L);
    }
}
