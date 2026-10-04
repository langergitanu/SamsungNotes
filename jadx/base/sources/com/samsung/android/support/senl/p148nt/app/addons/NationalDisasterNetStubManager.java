package com.samsung.android.support.senl.p148nt.app.addons;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p148nt.app.addons.stub.IStubManager;
import com.samsung.android.support.senl.p148nt.app.addons.stub.StubUtil;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 !2\u00020\u0001:\u0001!B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\"\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\tH\u0016J\u0012\u0010\u0011\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0013H\u0016J\u0018\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u0017H\u0016J\b\u0010\u001f\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0018R\u0014\u0010 \u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u0018¨\u0006\""}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/addons/NationalDisasterNetStubManager;", "Lcom/samsung/android/support/senl/nt/app/addons/stub/IStubManager;", "mActivity", "Landroidx/fragment/app/FragmentActivity;", "<init>", "(Landroidx/fragment/app/FragmentActivity;)V", "getMActivity", "()Landroidx/fragment/app/FragmentActivity;", "onRestoreDialogListener", "", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "release", "onViewChangeSaveInstanceState", "outState", "Landroid/os/Bundle;", "onViewChangeRestoreInstanceState", "savedInstanceState", "isNeedAddonsUpdate", "", "()Z", "isSupportedAddonsUpdate", "isNeedSamsungNotesUpdate", "isInstallableAddons", "showAddonsInstallDialog", "isUpdate", "isProgressOn", "showSamsungNotesUpdateDialog", "isAddonExist", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class NationalDisasterNetStubManager implements IStubManager {

    @NotNull
    private static final String TAG = "NationalDisasterNetStubManager";

    @NotNull
    private final FragmentActivity mActivity;

    public NationalDisasterNetStubManager(@NotNull FragmentActivity mActivity) {
        Intrinsics.checkNotNullParameter(mActivity, "mActivity");
        this.mActivity = mActivity;
    }

    @NotNull
    public final FragmentActivity getMActivity() {
        return this.mActivity;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.addons.stub.IStubManager
    public boolean isAddonExist() {
        return StubUtil.isAddonExist(this.mActivity);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.addons.stub.IStubManager
    public boolean isInstallableAddons() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.addons.stub.IStubManager
    public boolean isNeedAddonsUpdate() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.addons.stub.IStubManager
    public boolean isNeedSamsungNotesUpdate() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.addons.stub.IStubManager
    public boolean isSupportedAddonsUpdate() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.addons.stub.IStubManager
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        AbstractC8014b.m7200b(requestCode, resultCode, "onActivityResult requestCode# ", " resultCode# ", TAG);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.addons.stub.IStubManager
    public void onRestoreDialogListener() {
    }

    @Override // com.samsung.android.support.senl.p148nt.app.addons.stub.IStubManager
    public void onViewChangeRestoreInstanceState(@Nullable Bundle savedInstanceState) {
    }

    @Override // com.samsung.android.support.senl.p148nt.app.addons.stub.IStubManager
    public void onViewChangeSaveInstanceState(@Nullable Bundle outState) {
    }

    @Override // com.samsung.android.support.senl.p148nt.app.addons.stub.IStubManager
    public void release() {
    }

    @Override // com.samsung.android.support.senl.p148nt.app.addons.stub.IStubManager
    public void showAddonsInstallDialog(boolean isUpdate, boolean isProgressOn) {
        AbstractC6670b.m4739D("showAddonsInstallDialog isUpdate# ", TAG, isUpdate);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.addons.stub.IStubManager
    public void showSamsungNotesUpdateDialog() {
        MainLogger.m7258i(TAG, "showSamsungNotesUpdateDialog");
    }
}
