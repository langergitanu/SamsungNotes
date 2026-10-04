package com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.presenter;

import android.app.Activity;
import android.content.Context;
import android.widget.ListView;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.adapter.ImportCategorySpinnerAdapter;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/presenter/ImportDocumentPresenterContract;", "", "IView", "IListPopupWindow", "IDialog", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface ImportDocumentPresenterContract {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u0003H&R\u0012\u0010\r\u001a\u00020\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000f¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/presenter/ImportDocumentPresenterContract$IDialog;", "", "showCancelDownloadingDialog", "", "dismissCancelDownloadingDialog", "showProgressDialog", "dismissProgressDialog", "showNoteDataWarningDialog", "type", "", "size", "", "showErrorDialog", "isCancelDownloadingDialogAdded", "", "()Z", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IDialog {
        void dismissCancelDownloadingDialog();

        void dismissProgressDialog();

        boolean isCancelDownloadingDialogAdded();

        void showCancelDownloadingDialog();

        void showErrorDialog();

        void showNoteDataWarningDialog(int type, double size);

        void showProgressDialog();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/presenter/ImportDocumentPresenterContract$IListPopupWindow;", "", "setAdapter", "", "adapter", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/adapter/ImportCategorySpinnerAdapter;", "selectedCategoryPosition", "", "getSelectedCategoryPosition", "()I", "spinnerListView", "Landroid/widget/ListView;", "getSpinnerListView", "()Landroid/widget/ListView;", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IListPopupWindow {
        int getSelectedCategoryPosition();

        @Nullable
        ListView getSpinnerListView();

        void setAdapter(@Nullable ImportCategorySpinnerAdapter adapter);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u000bH&J\b\u0010\r\u001a\u00020\u000bH&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/documentlist/presenter/ImportDocumentPresenterContract$IView;", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "updateNoNotes", "", "updateSelectedItemCount", "onItemLongPressed", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IView {
        @Nullable
        Activity getActivity();

        @Nullable
        Context getContext();

        void onItemLongPressed();

        void updateNoNotes();

        void updateSelectedItemCount();
    }
}
