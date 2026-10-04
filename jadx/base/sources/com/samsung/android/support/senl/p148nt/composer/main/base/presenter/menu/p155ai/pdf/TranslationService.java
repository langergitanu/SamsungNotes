package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.pdf;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.pdf.TranslatedPDFSaveTask;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.PageMode;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TranslationService extends Service {
    private static final String TAG = Logger.createTag("TranslationService");
    private TranslationNotificationHelper mNotificationHelper;
    private TranslatedPDFSaveTask mTranslatedPDFSaveTask = null;
    private final ExecutorService mExecutorService = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG));

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CallbackWrapper implements TranslatedPDFSaveTask.Callback {
        private final TranslatedPDFSaveTask.Callback mCallback;
        private final TranslationNotificationHelper mNotificationHelper;

        public CallbackWrapper(TranslationNotificationHelper translationNotificationHelper, @NonNull TranslatedPDFSaveTask.Callback callback) {
            this.mNotificationHelper = translationNotificationHelper;
            this.mCallback = callback;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.TranslatedPDFSaveTask.Callback
        public void onFailed(int i, String str) {
            this.mCallback.onFailed(i, str);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.TranslatedPDFSaveTask.Callback
        public void onProgress(int i, int i2) {
            this.mCallback.onProgress(i, i2);
            TranslationNotificationHelper translationNotificationHelper = this.mNotificationHelper;
            if (translationNotificationHelper != null) {
                translationNotificationHelper.notifyTranslation();
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.TranslatedPDFSaveTask.Callback
        public void onSuccess(String str) {
            this.mCallback.onSuccess(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class LocalBinder extends Binder {
        public LocalBinder() {
        }

        public TranslationService getService() {
            return TranslationService.this;
        }
    }

    public void cancel() {
        TranslatedPDFSaveTask translatedPDFSaveTask = this.mTranslatedPDFSaveTask;
        if (translatedPDFSaveTask != null) {
            translatedPDFSaveTask.cancel();
        }
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return new LocalBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        TranslationNotificationHelper translationNotificationHelper = new TranslationNotificationHelper(getApplicationContext(), new C9419f(this));
        this.mNotificationHelper = translationNotificationHelper;
        if (Build.VERSION.SDK_INT >= 33) {
            startForeground(TranslationNotificationHelper.NOTIFICATION_ID, translationNotificationHelper.getNotification(), 1);
        } else {
            startForeground(TranslationNotificationHelper.NOTIFICATION_ID, translationNotificationHelper.getNotification());
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        Logger.m11003i(TAG, "onDestroy");
        TranslationNotificationHelper translationNotificationHelper = this.mNotificationHelper;
        if (translationNotificationHelper != null) {
            translationNotificationHelper.removeTranslationNotification();
            this.mNotificationHelper = null;
        }
        super.onDestroy();
    }

    public void translate(String str, String str2, @PageMode int i, ComposerViewPresenter composerViewPresenter, TranslatedPDFSaveTask.Callback callback) {
        TranslatedPDFSaveTask translatedPDFSaveTask = new TranslatedPDFSaveTask(getApplicationContext(), str, str2, i, composerViewPresenter, new CallbackWrapper(this.mNotificationHelper, callback));
        this.mTranslatedPDFSaveTask = translatedPDFSaveTask;
        this.mExecutorService.execute(translatedPDFSaveTask);
    }
}
