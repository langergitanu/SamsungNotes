package com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.ImportFolderPresenterContract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\b\u001a\u00020\tJ\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/receiver/ExternalStorageMountReceiver;", "Landroid/content/BroadcastReceiver;", "mPresenterContract", "Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/ImportFolderPresenterContract;", "<init>", "(Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/presenter/ImportFolderPresenterContract;)V", "mPendingRefresh", "", "handlePendingRefresh", "", "onReceive", "context", "Landroid/content/Context;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ExternalStorageMountReceiver extends BroadcastReceiver {

    @NotNull
    private static final String TAG = "ST$ExternalStorageMountReceiver";
    private boolean mPendingRefresh;

    @Nullable
    private final ImportFolderPresenterContract mPresenterContract;

    public ExternalStorageMountReceiver(@Nullable ImportFolderPresenterContract importFolderPresenterContract) {
        this.mPresenterContract = importFolderPresenterContract;
    }

    public final void handlePendingRefresh() {
        if (this.mPendingRefresh) {
            this.mPendingRefresh = false;
            ImportFolderPresenterContract importFolderPresenterContract = this.mPresenterContract;
            if (importFolderPresenterContract != null) {
                importFolderPresenterContract.startContentLoadingDialog();
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@NotNull Context context, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (Intrinsics.areEqual("android.intent.action.MEDIA_MOUNTED", intent.getAction()) || Intrinsics.areEqual("android.intent.action.MEDIA_UNMOUNTED", intent.getAction())) {
            AbstractC8014b.m7209k("ExternalStorageMountReceiver : ", intent.getAction(), TAG);
            ImportFolderPresenterContract importFolderPresenterContract = this.mPresenterContract;
            if (importFolderPresenterContract == null || !importFolderPresenterContract.isFragmentResumed()) {
                this.mPendingRefresh = true;
            } else {
                this.mPresenterContract.startContentLoadingDialog();
            }
        }
    }
}
