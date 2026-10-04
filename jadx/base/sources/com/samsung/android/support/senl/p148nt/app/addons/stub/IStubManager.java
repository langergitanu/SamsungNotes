package com.samsung.android.support.senl.p148nt.app.addons.stub;

import android.content.Intent;
import android.os.Bundle;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\"\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\b\u0010\n\u001a\u00020\u0003H&J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\rH&J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0011H&J\b\u0010\u0019\u001a\u00020\u0003H&R\u0012\u0010\u0010\u001a\u00020\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0012R\u0012\u0010\u0013\u001a\u00020\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0012R\u0012\u0010\u0014\u001a\u00020\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u0012\u0010\u0015\u001a\u00020\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0012R\u0012\u0010\u001a\u001a\u00020\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0012¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/addons/stub/IStubManager;", "", "onRestoreDialogListener", "", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "release", "onViewChangeSaveInstanceState", "outState", "Landroid/os/Bundle;", "onViewChangeRestoreInstanceState", "savedInstanceState", "isNeedAddonsUpdate", "", "()Z", "isSupportedAddonsUpdate", "isNeedSamsungNotesUpdate", "isInstallableAddons", "showAddonsInstallDialog", "isUpdate", "isProgressOn", "showSamsungNotesUpdateDialog", "isAddonExist", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IStubManager {
    boolean isAddonExist();

    boolean isInstallableAddons();

    boolean isNeedAddonsUpdate();

    boolean isNeedSamsungNotesUpdate();

    boolean isSupportedAddonsUpdate();

    void onActivityResult(int requestCode, int resultCode, @Nullable Intent data);

    void onRestoreDialogListener();

    void onViewChangeRestoreInstanceState(@Nullable Bundle savedInstanceState);

    void onViewChangeSaveInstanceState(@Nullable Bundle outState);

    void release();

    void showAddonsInstallDialog(boolean isUpdate, boolean isProgressOn);

    void showSamsungNotesUpdateDialog();
}
