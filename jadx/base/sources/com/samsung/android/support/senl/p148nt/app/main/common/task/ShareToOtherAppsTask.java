package com.samsung.android.support.senl.p148nt.app.main.common.task;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.data.MainEntryParam;
import com.samsung.android.support.senl.p148nt.app.main.common.view.AbsAppCompatActivity;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.util.PageCacheUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.base.winset.util.DialogUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareData;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share.CreateIntentForPicker;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share.ShareCacheHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share.ShareUriHelper;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.model.document.save.ThumbnailCreator;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import java.io.IOException;
import java.lang.ref.WeakReference;
import p001A.AbstractC0000a;
import p258y.AbstractC14516b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class ShareToOtherAppsTask extends AsyncTask<Void, Void, Intent> {
    private static final String TAG = "ShareToOtherAppsTask";
    private final String callingPackage;
    private final MainEntryParam mainEntryParam;
    private final String mimeType;
    private DialogFragment progressDialog;
    private final WeakReference<AbsAppCompatActivity> weakReference;

    public ShareToOtherAppsTask(AbsAppCompatActivity absAppCompatActivity, MainEntryParam mainEntryParam, String str, String str2) {
        this.weakReference = new WeakReference<>(absAppCompatActivity);
        this.mainEntryParam = mainEntryParam;
        this.callingPackage = str;
        this.mimeType = str2;
    }

    private void saveThumbnailByFile(Context context, String str, @NonNull String str2) {
        SpenWNote spenWNote = NotesUtils.getSpenWNote(context, str2, UUIDUtils.isCoeditUuid(str));
        if (spenWNote == null) {
            MainLogger.m7255e(TAG, "saveThumbnailByFile# note is null");
            return;
        }
        new ThumbnailCreator().saveThumbnail(context, spenWNote, str);
        try {
            DocumentFileManager.getInstance().close(str2, spenWNote, true);
        } catch (IOException e) {
            MainLogger.m7255e(TAG, "saveThumbnailByFile# close note" + e.getMessage());
        }
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        super.onPreExecute();
        DialogFragment dialogFragmentCreateProgressDialogFragment = DialogUtils.createProgressDialogFragment();
        this.progressDialog = dialogFragmentCreateProgressDialogFragment;
        dialogFragmentCreateProgressDialogFragment.setCancelable(false);
        ((DialogUtils.ProgressDialogFragment) this.progressDialog).showAllowingStateLoss(this.weakReference.get().getSupportFragmentManager(), TAG);
    }

    public Intent setResultToOtherApps(Context context, MainEntryParam mainEntryParam, String str, String str2) {
        Intent intent = new Intent();
        String uuid = mainEntryParam.getUuid();
        String filePath = mainEntryParam.getFilePath();
        if (Constants.SDOC_UUID.equals(str2)) {
            String thumbnailImagePath = PageCacheUtils.getThumbnailImagePath(context, uuid);
            if (TextUtils.isEmpty(thumbnailImagePath)) {
                saveThumbnailByFile(context, uuid, filePath);
                thumbnailImagePath = PageCacheUtils.getThumbnailImagePath(context, uuid);
            }
            return new CreateIntentForPicker().createIntentUUIDPicker(context, uuid, thumbnailImagePath, str);
        }
        if (str2 == null || !str2.startsWith(Constants.MIME_SDOC)) {
            SpenWNote spenWNote = NotesUtils.getSpenWNote(context, filePath, UUIDUtils.isCoeditUuid(uuid));
            if (spenWNote == null) {
                return intent;
            }
            try {
                intent = new CreateIntentForPicker().createIntentNotePicker(context, spenWNote, new ShareData(filePath, mainEntryParam.getUuid(), mainEntryParam.getDocTitle(), mainEntryParam.getLastModifiedAt()), str);
                DocumentFileManager.getInstance().close(filePath, spenWNote, true);
                return intent;
            } catch (Exception e) {
                AbstractC14516b.m15115c(e, new StringBuilder("setResultToOtherApps# "), TAG);
            }
        } else {
            Uri documentUri = new ShareUriHelper(new ShareCacheHelper()).getDocumentUri(context, filePath, mainEntryParam.getDocTitle(), null, mainEntryParam.getLastModifiedAt());
            try {
                context.grantUriPermission(str, documentUri, 1);
                intent.putExtra("android.intent.extra.STREAM", documentUri);
                intent.addFlags(1);
            } catch (Exception e2) {
                AbstractC14516b.m15115c(e2, AbstractC0000a.m15l("setResultToOtherApps# ", str2, SQLKeyword.COMMA), TAG);
            }
        }
        return intent;
    }

    @Override // android.os.AsyncTask
    public Intent doInBackground(Void... voidArr) {
        if (this.weakReference.get() == null) {
            MainLogger.m7258i(TAG, "NotePickerActivity is null");
            return null;
        }
        if (this.mainEntryParam != null) {
            return setResultToOtherApps(this.weakReference.get().getApplicationContext(), this.mainEntryParam, this.callingPackage, this.mimeType);
        }
        return null;
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Intent intent) {
        super.onPostExecute(intent);
        DialogFragment dialogFragment = this.progressDialog;
        if (dialogFragment != null) {
            dialogFragment.dismissAllowingStateLoss();
        }
        if (this.weakReference.get() == null) {
            MainLogger.m7258i(TAG, "NotePickerActivity is null");
            return;
        }
        if (intent != null) {
            this.weakReference.get().setResult(-1, intent);
            this.weakReference.get().finish();
            MainLogger.m7258i(TAG, "Intent nonNull");
        } else {
            this.weakReference.get().setResult(0, new Intent());
            this.weakReference.get().finish();
            MainLogger.m7258i(TAG, "Intent is null");
        }
    }
}
