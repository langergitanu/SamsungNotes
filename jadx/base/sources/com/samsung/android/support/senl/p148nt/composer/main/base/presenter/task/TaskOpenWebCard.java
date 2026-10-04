package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.samsung.android.sdk.pen.document.SpenObjectWeb;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.base.common.util.PageCacheUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.external.scrapbook.ScrapBookViewer;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.link.UriLinkHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TaskOpenWebCard extends SingleThreadTask<InputValues, ResultValues> {
    private static final String TAG = Logger.createTag("TaskOpenWebCard");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InputValues implements Task.InputValues {
        private Context context;
        private SpenObjectWeb objectWeb;
        private String uuid;

        public InputValues(Context context, SpenObjectWeb spenObjectWeb, String str) {
            this.context = context;
            this.objectWeb = spenObjectWeb;
            this.uuid = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ResultValues implements Task.ResultValues {
        private Intent intent;

        public ResultValues(Intent intent) {
            this.intent = intent;
        }

        public Intent getIntent() {
            return this.intent;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Intent getIntentForWeb(String str) {
        String strMakeUrl = UriLinkHelper.makeUrl(str);
        if (TextUtils.isEmpty(strMakeUrl)) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(strMakeUrl));
        intent.addFlags(268435456);
        return intent;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void executeTask(final InputValues inputValues) {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG));
        this.mExecutorService = executorServiceNewSingleThreadExecutor;
        executorServiceNewSingleThreadExecutor.execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskOpenWebCard.1
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                Intent intentForWeb;
                try {
                    String uri = inputValues.objectWeb.getUri();
                    String attachedHTMLFile = inputValues.objectWeb.getAttachedHTMLFile();
                    if (TextUtils.isEmpty(attachedHTMLFile)) {
                        intentForWeb = TaskOpenWebCard.this.getIntentForWeb(uri);
                    } else {
                        intentForWeb = ScrapBookViewer.getIntentForScrapbook(inputValues.context, attachedHTMLFile, uri, PageCacheUtils.getCacheDirectory(inputValues.context, inputValues.uuid));
                    }
                    if (intentForWeb != null) {
                        if (TaskOpenWebCard.this.getTaskCallback() != null) {
                            TaskOpenWebCard.this.getTaskCallback().onSuccess(new ResultValues(intentForWeb));
                        }
                    } else if (TaskOpenWebCard.this.getTaskCallback() != null) {
                        TaskOpenWebCard.this.getTaskCallback().onError(null);
                    }
                } catch (Exception e) {
                    Logger.m11001e(TaskOpenWebCard.TAG, e.getMessage(), e);
                    if (TaskOpenWebCard.this.getTaskCallback() != null) {
                        TaskOpenWebCard.this.getTaskCallback().onError(null);
                    }
                }
            }
        });
    }
}
