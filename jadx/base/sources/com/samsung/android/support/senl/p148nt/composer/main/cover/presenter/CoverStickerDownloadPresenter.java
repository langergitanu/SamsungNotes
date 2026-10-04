package com.samsung.android.support.senl.p148nt.composer.main.cover.presenter;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSyncManager;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.cover.presenter.TaskDownloadCoverSticker;
import com.samsung.android.support.senl.p148nt.composer.main.cover.util.CoverStickerDownloadUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CoverStickerDownloadPresenter {
    private static final boolean DEBUG = false;
    private static final String TAG = Logger.createCoverTag("CoverStickerDownloadPresenter");
    private final String mCachePath;
    private DownloadContract mDownloadContract;
    private final TaskDownloadCoverSticker mDownloadStickerTask;
    private final List<Uri> mStickerUris = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface DownloadContract {
        void hideProgress();

        void onDownloadedCoverSticker();

        void showProgress();
    }

    public CoverStickerDownloadPresenter(Context context, TaskDownloadCoverSticker taskDownloadCoverSticker) {
        this.mDownloadStickerTask = taskDownloadCoverSticker;
        this.mCachePath = CoverStickerDownloadUtils.getDownloadedStickerZipFolder(context).getPath() + File.separator;
        loadStickerUrl(context);
    }

    private Task.Callback<TaskDownloadCoverSticker.ResultValues> getDownloadUrlStickerCallback(final Context context) {
        return new Task.Callback<TaskDownloadCoverSticker.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.cover.presenter.CoverStickerDownloadPresenter.3
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onError(TaskDownloadCoverSticker.ResultValues resultValues) {
                Logger.m11000e(CoverStickerDownloadPresenter.TAG, "downloadUrlCoverSticker# onError# " + resultValues.getErrorCode());
                CoverStickerDownloadPresenter.this.showErrorToast(context, resultValues.getErrorCode());
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onSuccess(TaskDownloadCoverSticker.ResultValues resultValues) {
                Logger.m10999d(CoverStickerDownloadPresenter.TAG, "downloadUrlCoverSticker# onSuccess# ");
                CoverStickerDownloadPresenter.this.onDownloadedCoverSticker(context, resultValues.getPathList());
            }
        };
    }

    private void loadStickerUrl(Context context) {
        String[] stringArray = context.getResources().getStringArray(C9086R.array.cover_sticker_url);
        try {
            Logger.m10999d(TAG, "loadStickerUrl# mCachePath : " + this.mCachePath);
            this.mStickerUris.add(Uri.parse(stringArray[0]));
        } catch (Exception e) {
            Logger.m11001e(TAG, "loadStickerUrl# exception", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDownloadedCoverSticker(Context context, List<String> list) {
        if (list == null || list.isEmpty()) {
            Logger.m11000e(TAG, "onDownloadedCoverSticker# stickerPathList is null");
            showErrorToast(context, 6);
            return;
        }
        try {
            for (String str : list) {
                try {
                    CoverStickerDownloadUtils.unZipFile(str, CoverStickerDownloadUtils.getDownloadedStickerUnZipFolder(context));
                    Logger.m10999d(TAG, "onDownloadedCoverSticker# success unzip path : " + str);
                    this.mDownloadContract.onDownloadedCoverSticker();
                } catch (IOException unused) {
                    Logger.m11000e(TAG, "onDownloadedCoverSticker# fail to unzip");
                    showErrorToast(context, 7);
                }
            }
        } catch (Exception e) {
            Logger.m11001e(TAG, "onDownloadedCoverSticker# exception", e);
            showErrorToast(context, 7);
        }
    }

    private void showDownloadConfirmDialog(final Context context) {
        AlertDialogBuilderForAppCompat alertDialogBuilderForAppCompat = new AlertDialogBuilderForAppCompat(context);
        alertDialogBuilderForAppCompat.setMessage(C9086R.string.change_template_download_pdf_using_mobile_data);
        alertDialogBuilderForAppCompat.setPositiveButton(C9086R.string.dialog_ok, new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.cover.presenter.CoverStickerDownloadPresenter.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                CoverStickerDownloadPresenter.this.downloadCoverStickerUrl(context);
            }
        });
        alertDialogBuilderForAppCompat.setNegativeButton(C9086R.string.dialog_cancel, new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.cover.presenter.CoverStickerDownloadPresenter.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        alertDialogBuilderForAppCompat.show();
    }

    private void showNetworkErrorToast(Context context) {
        Logger.m10999d(TAG, "showNetworkErrorToast# network is not available");
        ToastHandler.show(context, C9086R.string.change_template_network_error_message, 0);
    }

    public void downloadCoverStickerUrl(Context context) {
        if (!RequestToSyncManager.INSTANCE.isDataNetworkAvailable(context)) {
            showNetworkErrorToast(context);
            return;
        }
        Logger.m10999d(TAG, "downloadUrlCoverSticker#");
        this.mDownloadContract.showProgress();
        this.mDownloadStickerTask.setInputValue(new TaskDownloadCoverSticker.InputValues(context, this.mStickerUris, this.mCachePath));
        this.mDownloadStickerTask.setTaskCallback(getDownloadUrlStickerCallback(context));
        this.mDownloadStickerTask.run();
    }

    public void onDownloadCoverSticker(Context context) {
        String str = TAG;
        Logger.m10999d(str, "onDownloadCoverSticker");
        RequestToSyncManager.Companion companion = RequestToSyncManager.INSTANCE;
        if (!companion.isDataNetworkAvailable(context)) {
            Logger.m10999d(str, "onDownloadCoverSticker# data network is not available");
            showNetworkErrorToast(context);
        } else if (companion.isWiFiAvailable(context)) {
            downloadCoverStickerUrl(context);
        } else {
            Logger.m10999d(str, "onDownloadCoverSticker# wifi is not available");
            showDownloadConfirmDialog(context);
        }
    }

    public void setDownloadContract(DownloadContract downloadContract) {
        this.mDownloadContract = downloadContract;
    }

    public void showErrorToast(Context context, int i) {
        CoverStickerDownloadUtils.showErrorToast(context, i, true);
        this.mDownloadContract.hideProgress();
    }
}
