package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.sdk.scs.base.tasks.OnCompleteListener;
import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.SCSOperator;
import com.samsung.android.support.senl.p148nt.base.winset.app.language.AiLanguageHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class LanguageIdentifier {
    private static final String TAG = Logger.createTag("LanguageIdentifier", AiConstants.PREFIX_TAG);
    private ExecutorService mExecutorService;
    private Locale mIdentifiedLocale;
    private boolean mIsCanceled = false;
    private CountDownLatch mLastCountDownLatch;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface AsyncCallback {
        void onCompleted(Locale locale);
    }

    private Locale convertResultToLocale(String str) {
        return AiLanguageHelper.getLocale(str);
    }

    /* JADX INFO: renamed from: e */
    public static /* bridge */ /* synthetic */ Locale m9287e(String str, LanguageIdentifier languageIdentifier) {
        return languageIdentifier.convertResultToLocale(str);
    }

    private ExecutorService getExecutorService() {
        if (this.mExecutorService == null) {
            this.mExecutorService = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG));
        }
        return this.mExecutorService;
    }

    public void identifyLanguage(String str, @Nullable final AsyncCallback asyncCallback) {
        Logger.m10999d(TAG, "identifyLanguage# ");
        this.mIsCanceled = false;
        this.mIdentifiedLocale = null;
        SCSOperator sCSOperator = new SCSOperator();
        sCSOperator.updateLanguageList();
        sCSOperator.identifyLanguage(str).addOnCompleteListener(new OnCompleteListener<String>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.common.LanguageIdentifier.1
            @Override // com.samsung.android.sdk.scs.base.tasks.OnCompleteListener
            public void onComplete(@NonNull Task<String> task) {
                if (!task.isSuccessful() || task.getResult() == null) {
                    Logger.m10999d(LanguageIdentifier.TAG, "identifyLanguage#onComplete# fail");
                } else {
                    AbstractC8014b.m7213o(new StringBuilder("identifyLanguage#onComplete# "), task.getResult(), LanguageIdentifier.TAG);
                    LanguageIdentifier languageIdentifier = LanguageIdentifier.this;
                    languageIdentifier.mIdentifiedLocale = LanguageIdentifier.m9287e(task.getResult(), languageIdentifier);
                }
                if (LanguageIdentifier.this.mIsCanceled) {
                    Logger.m10999d(LanguageIdentifier.TAG, "identifyLanguage#onComplete#");
                    return;
                }
                AsyncCallback asyncCallback2 = asyncCallback;
                if (asyncCallback2 != null) {
                    asyncCallback2.onCompleted(LanguageIdentifier.this.mIdentifiedLocale);
                }
            }
        });
    }

    public void identifyLanguageAsync(String str, @Nullable final AsyncCallback asyncCallback) {
        Logger.m10999d(TAG, "identifyLanguageAsync# ");
        this.mIsCanceled = false;
        this.mIdentifiedLocale = null;
        new SCSOperator().identifyLanguage(str).addOnCompleteListener(getExecutorService(), new OnCompleteListener<String>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.common.LanguageIdentifier.3
            @Override // com.samsung.android.sdk.scs.base.tasks.OnCompleteListener
            public void onComplete(@NonNull Task<String> task) {
                if (!task.isSuccessful() || task.getResult() == null) {
                    Logger.m10999d(LanguageIdentifier.TAG, "identifyLanguageAsync#onComplete# fail");
                } else {
                    AbstractC8014b.m7213o(new StringBuilder("identifyLanguageAsync#onComplete# "), task.getResult(), LanguageIdentifier.TAG);
                    LanguageIdentifier languageIdentifier = LanguageIdentifier.this;
                    languageIdentifier.mIdentifiedLocale = LanguageIdentifier.m9287e(task.getResult(), languageIdentifier);
                }
                if (LanguageIdentifier.this.mIsCanceled) {
                    Logger.m10999d(LanguageIdentifier.TAG, "identifyLanguage#onComplete#");
                    return;
                }
                AsyncCallback asyncCallback2 = asyncCallback;
                if (asyncCallback2 != null) {
                    asyncCallback2.onCompleted(LanguageIdentifier.this.mIdentifiedLocale);
                }
            }
        });
    }

    public Locale identifyLanguageSync(String str) {
        String str2 = TAG;
        Logger.m10999d(str2, "identifyLanguageSync# ");
        this.mIsCanceled = false;
        SCSOperator sCSOperator = new SCSOperator();
        this.mLastCountDownLatch = new CountDownLatch(1);
        sCSOperator.identifyLanguage(str).addOnCompleteListener(getExecutorService(), new OnCompleteListener<String>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.common.LanguageIdentifier.2
            @Override // com.samsung.android.sdk.scs.base.tasks.OnCompleteListener
            public void onComplete(@NonNull Task<String> task) {
                if (LanguageIdentifier.this.mLastCountDownLatch.getCount() == 0) {
                    Logger.m10999d(LanguageIdentifier.TAG, "identifyLanguageSync#onComplete# CountDownLatch is 0");
                    return;
                }
                if (!task.isSuccessful() || task.getResult() == null) {
                    Logger.m10999d(LanguageIdentifier.TAG, "identifyLanguageSync#onComplete# fail");
                } else {
                    AbstractC8014b.m7213o(new StringBuilder("identifyLanguageSync#onComplete# "), task.getResult(), LanguageIdentifier.TAG);
                    LanguageIdentifier languageIdentifier = LanguageIdentifier.this;
                    languageIdentifier.mIdentifiedLocale = LanguageIdentifier.m9287e(task.getResult(), languageIdentifier);
                }
                LanguageIdentifier.this.mLastCountDownLatch.countDown();
            }
        });
        try {
            if (!this.mLastCountDownLatch.await(5L, TimeUnit.SECONDS)) {
                Logger.m10999d(str2, "identifyLanguageSync# timeout");
            }
        } catch (InterruptedException e) {
            Logger.m11000e(TAG, "identifyLanguageSync# " + e.getMessage());
        }
        this.mLastCountDownLatch.countDown();
        return this.mIdentifiedLocale;
    }

    public void release() {
        this.mIsCanceled = true;
        ExecutorService executorService = this.mExecutorService;
        if (executorService != null) {
            executorService.shutdownNow();
            this.mExecutorService = null;
        }
        CountDownLatch countDownLatch = this.mLastCountDownLatch;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }
}
