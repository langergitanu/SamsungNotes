package com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.presenter.mode;

import com.samsung.android.app.notes.sync.constants.DocTypeConstants;
import com.samsung.android.app.notes.sync.items.ImportItem;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/presenter/mode/ImportDocumentModeContract;", "", "IPresenter", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface ImportDocumentModeContract {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u000b\u001a\u00020\fH&J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\fH&J\b\u0010\u0013\u001a\u00020\fH&J4\u0010\u0014\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u000e\u0010\u0019\u001a\n\u0018\u00010\u001aj\u0004\u0018\u0001`\u001bH&R&\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\n¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/presenter/mode/ImportDocumentModeContract$IPresenter;", "", "checkedItems", "Ljava/util/ArrayList;", "Lcom/samsung/android/app/notes/sync/items/ImportItem;", "Lkotlin/collections/ArrayList;", "getCheckedItems", "()Ljava/util/ArrayList;", "isCancelDownloadingEnded", "", "()Z", "registerImportListRequest", "", "showMemoDataWarningDialog", "type", "", "size", "", "dismissProgressDialog", "showCancelDownloadingDialog", "handleError", "Lcom/samsung/android/app/notes/sync/constants/DocTypeConstants;", "errorCode", "message", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IPresenter {
        void dismissProgressDialog();

        @Nullable
        ArrayList<ImportItem> getCheckedItems();

        void handleError(@Nullable DocTypeConstants type, int errorCode, @Nullable String message, @Nullable Exception e);

        boolean isCancelDownloadingEnded();

        void registerImportListRequest();

        void showCancelDownloadingDialog();

        void showMemoDataWarningDialog(int type, double size);
    }
}
