package com.samsung.android.support.senl.p148nt.app.trigger.task;

import android.content.ClipData;
import android.content.Context;
import android.util.Pair;
import com.samsung.android.support.senl.p148nt.app.converter.ConverterDialogManager;
import com.samsung.android.support.senl.p148nt.base.common.access.sync.importer.data.ImportDocument;
import com.samsung.android.support.senl.p148nt.base.common.util.UriFileUtils;
import com.samsung.android.support.senl.p148nt.model.converter.task.common.ConvertInfo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class TriggerListCreationTask extends AbsTriggerTask<ClipData, Void, Pair<List<ImportDocument>, List<ConvertInfo>>> {
    private static final String TAG = "TriggerListCreationTask";
    private final ICallback mCallback;
    private final int mCallerId;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ICallback {
        void onPostExecute(List<ImportDocument> list, List<ConvertInfo> list2);
    }

    public TriggerListCreationTask(Context context, ConverterDialogManager converterDialogManager, int i, ICallback iCallback) {
        super(context, converterDialogManager);
        this.mCallerId = i;
        this.mCallback = iCallback;
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        super.onPreExecute();
        this.mDialogManager.showImportProgressDialog();
    }

    @Override // android.os.AsyncTask
    public Pair<List<ImportDocument>, List<ConvertInfo>> doInBackground(ClipData... clipDataArr) throws Throwable {
        Thread.currentThread().setName("TriggerListCreationTask-thread");
        int itemCount = clipDataArr[0].getItemCount();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < itemCount && !isCancelled(); i++) {
            String pathFromUri = UriFileUtils.getPathFromUri(this.mContextRef.get(), clipDataArr[0].getItemAt(i).getUri());
            if (pathFromUri.endsWith(".sdoc") || pathFromUri.endsWith(".sdocx")) {
                arrayList.add(new ImportDocument(pathFromUri, null));
            } else {
                arrayList2.add(new ConvertInfo(pathFromUri, this.mCallerId));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Pair<List<ImportDocument>, List<ConvertInfo>> pair) {
        super.onPostExecute(pair);
        dismissDialog();
        this.mCallback.onPostExecute((List) pair.first, (List) pair.second);
        release();
    }
}
