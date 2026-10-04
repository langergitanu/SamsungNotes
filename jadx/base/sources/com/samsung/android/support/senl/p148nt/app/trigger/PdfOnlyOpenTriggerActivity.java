package com.samsung.android.support.senl.p148nt.app.trigger;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.util.SeslKoreanGeneralizer;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.PermissionCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.base.common.PermissionUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.lifecycle.PdfWriterManager;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.model.PdfFileInfo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class PdfOnlyOpenTriggerActivity extends DocOpenTriggerActivity {
    private static final String TAG = "PdfOnlyOpenTriggerActivity";

    private void handlePermissionResult(String[] strArr) {
        if (PermissionHelper.isPermissionGrantedWithoutNotice(this, strArr)) {
            openDocument();
            return;
        }
        ToastHandler.show(getApplicationContext(), getResources().getString(C8003R.string.need_to_allow_permission, getResources().getString(C8003R.string.storage_permission_title)), 1);
        Logger.m8698e(TAG, "fail to get the permission of accessing all files.");
        finish("onActivityResult");
    }

    @RequiresApi(api = 30)
    private boolean resultAllFilesAccessPermission(int i) {
        if (i != 53) {
            return false;
        }
        handlePermissionResult(PermissionCompat.getStoragePermissions(5));
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.trigger.DocOpenTriggerActivity
    public boolean checkPermission() {
        final String[] storagePermissions = PermissionCompat.getStoragePermissions(5);
        return PermissionHelper.isPermissionGranted(this, new Runnable() { // from class: com.samsung.android.support.senl.nt.app.trigger.PdfOnlyOpenTriggerActivity.1
            @Override // java.lang.Runnable
            public void run() {
                if (Build.VERSION.SDK_INT >= 30) {
                    PermissionUtils.showAllFilesAccessPermission(PdfOnlyOpenTriggerActivity.this, 53);
                } else {
                    PermissionHelper.requestPermissions((Activity) PdfOnlyOpenTriggerActivity.this, 102, true, storagePermissions);
                }
            }
        }, storagePermissions);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.trigger.DocOpenTriggerActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Logger.m8697d(TAG, "onActivityResult requestCode:" + i + ", resultCode:" + i2);
        if (Build.VERSION.SDK_INT < 30 || !resultAllFilesAccessPermission(i)) {
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.trigger.DocOpenTriggerActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        AbstractC4539a.m3203m(i, "onRequestPermissionsResult, requestCode: ", TAG);
        if (i == 102) {
            handlePermissionResult(strArr);
        } else {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.trigger.DocOpenTriggerActivity
    public void openPDF(Uri uri) {
        changeActivityFlags();
        Intent openPDFReaderIntent = this.mIntentHandler.getOpenPDFReaderIntent(this, uri, getIntent());
        PdfFileInfo pdfFileInfo = (PdfFileInfo) openPDFReaderIntent.getParcelableExtra(ComposerConstants.ARG_PDF_READER_FILE_INFO);
        if (pdfFileInfo == null) {
            finishWithErrorToast("openPDF, PdfFileInfo is null");
            return;
        }
        if (PdfWriterManager.getInstance().moveExistPwToFront(this, pdfFileInfo)) {
            Resources resources = getResources();
            ToastHandler.show(this, new SeslKoreanGeneralizer().naturalizeText(resources.getString(C9086R.string.pdf_reader_is_already_in_use, resources.getString(C9086R.string.composer_add_pdf))), 0);
        } else {
            try {
                startActivity(openPDFReaderIntent);
            } catch (SecurityException e) {
                finishWithErrorToast("openPDF, e : " + e.getMessage());
                return;
            }
        }
        finish("openPDF");
    }
}
