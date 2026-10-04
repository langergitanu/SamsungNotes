package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.util.LockUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.RunnableC9844c;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share.HandleImage;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share.ShareCacheHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share.ShareToOtherAppHandler;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TaskStyleChanger extends SingleThreadTask<InputValues, ResultValues> {
    private static final String TAG = Logger.createTag("TaskStyleChanger");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InputValues implements Task.InputValues {
        Context mContext;
        SpenWNote mNote;
        SpenObjectBase mObjectImage;

        public InputValues(Context context, SpenWNote spenWNote, SpenObjectBase spenObjectBase) {
            this.mContext = context;
            this.mNote = spenWNote;
            this.mObjectImage = spenObjectBase;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ResultValues implements Task.ResultValues {
        Uri mUri;

        public ResultValues() {
        }

        public Uri getUri() {
            return this.mUri;
        }

        public ResultValues(Uri uri) {
            this.mUri = uri;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: makeShareUri, reason: merged with bridge method [inline-methods] */
    public void lambda$executeTask$0(InputValues inputValues) {
        boolean zIsLocked = LockUtils.isLocked(inputValues.mNote);
        ShareToOtherAppHandler shareToOtherAppHandler = new ShareToOtherAppHandler();
        ShareCacheHelper.ReturnValueForShareDir contextShareDir = shareToOtherAppHandler.getShareCacheHelper().getContextShareDir(inputValues.mContext, zIsLocked);
        if (contextShareDir == null) {
            Logger.m11000e(TAG, "file to make shareDir");
            notifyFailCallback();
            return;
        }
        String strSaveAsImage = new HandleImage().saveAsImage(inputValues.mObjectImage, contextShareDir.mDir, "", true);
        if (TextUtils.isEmpty(strSaveAsImage) || !AbstractC2322a.m1607A(strSaveAsImage)) {
            Logger.m10999d(TAG, "failed to saveAsImage");
            notifyFailCallback();
            return;
        }
        Logger.m10999d(TAG, "image# " + Logger.getEncode(strSaveAsImage));
        notifyCallback(true, new ResultValues(shareToOtherAppHandler.getShareUriHelper().getContextShareUri(inputValues.mContext, strSaveAsImage, contextShareDir.mUseFileProvider, Constants.MIME_IMAGE)));
    }

    private void notifyFailCallback() {
        notifyCallback(false, new ResultValues());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void executeTask(InputValues inputValues) {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG));
        this.mExecutorService = executorServiceNewSingleThreadExecutor;
        executorServiceNewSingleThreadExecutor.execute(new RunnableC9844c(this, inputValues, 14));
    }
}
