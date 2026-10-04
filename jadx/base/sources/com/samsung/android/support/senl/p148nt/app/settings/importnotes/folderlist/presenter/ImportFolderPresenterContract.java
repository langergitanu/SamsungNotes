package com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter;

import android.content.Intent;
import com.samsung.android.app.notes.sync.constants.DocTypeConstants;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0006H&J\b\u0010\n\u001a\u00020\u0006H&J\b\u0010\u000b\u001a\u00020\u0006H&J\b\u0010\f\u001a\u00020\u0006H&J\b\u0010\r\u001a\u00020\u0006H&J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0012\u0010\u0011\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\b\u0010\u0012\u001a\u00020\u0006H&J\b\u0010\u0013\u001a\u00020\u0006H&J\u0012\u0010\u0014\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\b\u0010\u0015\u001a\u00020\u0006H&J\u001c\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H&J\b\u0010\u001a\u001a\u00020\u0006H&J\b\u0010\u001b\u001a\u00020\u0006H&J\b\u0010\u001c\u001a\u00020\u0006H&J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001fH&J\b\u0010 \u001a\u00020\u0003H&J\b\u0010!\u001a\u00020\u0006H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\""}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/ImportFolderPresenterContract;", "", "isFragmentResumed", "", "()Z", "backToNoteList", "", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "updateSelectedItemCount", "onItemLongPressed", "updateFolderLayout", "updateLayout", "activityFinish", "updateValidateFolderPath", "folderName", "", "startGoogleDriveActivity", "startMyfilesPickerActivity", "startSNBAKPickerActivity", "startRequestAuthorizationActivity", "startContentLoadingDialog", "showFileDownloadingDialog", "appName", "importType", "Lcom/samsung/android/app/notes/sync/constants/DocTypeConstants;", "dismissFileDownloadingDialog", "showErrorDialog", "notifyDataSetChanged", "notifyItemChanged", "position", "", "isRootFolder", "setValidateFolderPath", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface ImportFolderPresenterContract {
    void activityFinish();

    void backToNoteList(@NotNull Intent intent);

    void dismissFileDownloadingDialog();

    boolean isFragmentResumed();

    boolean isRootFolder();

    void notifyDataSetChanged();

    void notifyItemChanged(int position);

    void onItemLongPressed();

    void setValidateFolderPath();

    void showErrorDialog();

    void showFileDownloadingDialog(@Nullable String appName, @Nullable DocTypeConstants importType);

    void startContentLoadingDialog();

    void startGoogleDriveActivity(@Nullable Intent intent);

    void startMyfilesPickerActivity();

    void startRequestAuthorizationActivity(@Nullable Intent intent);

    void startSNBAKPickerActivity();

    void updateFolderLayout();

    void updateLayout();

    void updateSelectedItemCount();

    void updateValidateFolderPath(@NotNull String folderName);
}
