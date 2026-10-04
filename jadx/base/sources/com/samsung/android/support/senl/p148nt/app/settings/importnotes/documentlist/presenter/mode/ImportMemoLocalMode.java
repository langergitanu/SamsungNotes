package com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.presenter.mode;

import android.content.Context;
import android.text.TextUtils;
import com.samsung.android.app.notes.sync.constants.DocTypeConstants;
import com.samsung.android.app.notes.sync.importing.core.types.AbstractImportType;
import com.samsung.android.app.notes.sync.importing.core.types.MemoLocalImportType;
import com.samsung.android.app.notes.sync.items.ImportItem;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.presenter.mode.ImportDocumentModeContract;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u001a\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u0013H\u0016R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/presenter/mode/ImportMemoLocalMode;", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/presenter/mode/ImportMemoMode;", "presenter", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/presenter/mode/ImportDocumentModeContract$IPresenter;", "<init>", "(Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/presenter/mode/ImportDocumentModeContract$IPresenter;)V", "noNoteBodyText", "", "getNoNoteBodyText", "()Ljava/lang/String;", "importType", "Lcom/samsung/android/app/notes/sync/constants/DocTypeConstants;", "getImportType", "()Lcom/samsung/android/app/notes/sync/constants/DocTypeConstants;", "getAbstractImportType", "Lcom/samsung/android/app/notes/sync/importing/core/types/AbstractImportType;", "importItems", "Ljava/util/ArrayList;", "Lcom/samsung/android/app/notes/sync/items/ImportItem;", "Lkotlin/collections/ArrayList;", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ImportMemoLocalMode extends ImportMemoMode {
    public ImportMemoLocalMode(@Nullable ImportDocumentModeContract.IPresenter iPresenter) {
        super(iPresenter);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.presenter.mode.ImportDocumentMode
    @Nullable
    public AbstractImportType getAbstractImportType(@Nullable ArrayList<ImportItem> importItems) {
        return new MemoLocalImportType(importItems);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.presenter.mode.ImportDocumentMode
    @NotNull
    public DocTypeConstants getImportType() {
        return DocTypeConstants.MEMO_LOCAL;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.presenter.mode.ImportDocumentMode
    @NotNull
    public String getNoNoteBodyText() {
        if (TextUtils.isEmpty(this.mNoNoteText)) {
            Context applicationContext = BaseUtils.getApplicationContext();
            this.mNoNoteText = applicationContext != null ? applicationContext.getString(C8003R.string.settings_import_no_data_on_device, getAppName()) : null;
        }
        String str = this.mNoNoteText;
        Intrinsics.checkNotNull(str);
        return str;
    }
}
