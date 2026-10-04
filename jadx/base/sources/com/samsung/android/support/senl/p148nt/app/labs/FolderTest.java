package com.samsung.android.support.senl.p148nt.app.labs;

import android.app.Activity;
import android.os.Looper;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.winset.util.DialogUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.common.exceptions.InvalidParentFolderException;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.executor.NotesDataTaskExecutor;
import com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.DataRepositoryScheduler;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import java.util.ArrayList;
import p001A.AbstractC0000a;
import p027F3.RunnableC0101a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class FolderTest {
    private static final String TAG = "FolderTest";

    private DialogUtils.ProgressDialog createProgress(Activity activity) {
        DialogUtils.ProgressDialog progressDialog = new DialogUtils.ProgressDialog(activity);
        progressDialog.setTitle("Create Folders...");
        progressDialog.show();
        return progressDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createData$0(int i, Activity activity, DialogUtils.ProgressDialog progressDialog) {
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(new NotesCategoryTreeEntity(UUIDUtils.newUUID(activity), PredefinedCategory.UNCATEGORIZED.getUuid(), AbstractC0000a.m11h(i2, "Test_"), null));
        }
        try {
            FolderManager.getInstance().insert(arrayList);
        } catch (InvalidParentFolderException e) {
            Logger.m8698e(TAG, "failed, e: " + e.getMessage());
        }
        progressDialog.dismiss();
    }

    public void createData(Activity activity, int i) {
        DataRepositoryScheduler.runnable(new RunnableC0101a(i, activity, createProgress(activity))).executeOn(NotesDataTaskExecutor.getIOThreadExecutor()).execute();
    }
}
