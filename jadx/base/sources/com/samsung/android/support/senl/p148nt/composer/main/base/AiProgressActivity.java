package com.samsung.android.support.senl.p148nt.composer.main.base;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;
import com.samsung.android.sdk.mobileservice.common.ErrorCodeConvertor;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.RunnableC8669a;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AIFeatureInfoManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\b\u0010\f\u001a\u00020\tH\u0002J\u0006\u0010\r\u001a\u00020\tJ\u0006\u0010\u000e\u001a\u00020\tJ\b\u0010\u000f\u001a\u00020\tH\u0014J\b\u0010\u0010\u001a\u00020\tH\u0002J\b\u0010\u0011\u001a\u00020\tH\u0002J\b\u0010\u0012\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/AiProgressActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "mIsServerCheckedCount", "", "mTimer", "Ljava/util/Timer;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "startProgress", "checkedProgress", "stopProgress", "onDestroy", "releaseTimer", "finishWithFailed", "finishWithSuccess", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AiProgressActivity extends AppCompatActivity {
    private static final long LOADING_MESSAGE_PERIOD_MS = 7000;
    private int mIsServerCheckedCount;

    @Nullable
    private Timer mTimer;
    private static final String TAG = Logger.createTag("AiProgressActivity");

    private final void finishWithFailed() {
        Logger.m11003i(TAG, "finishWithFailed#");
        setResult(0, getIntent());
        finish();
    }

    private final void finishWithSuccess() {
        Logger.m11003i(TAG, "finishWithSuccess#");
        AIFeatureInfoManager.setAIFeatureInfo();
        setResult(-1);
        finish();
    }

    private final void releaseTimer() {
        Logger.m11003i(TAG, "releaseTimer#");
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
        }
        this.mTimer = null;
    }

    private final void startProgress() {
        Timer timer = new Timer();
        this.mTimer = timer;
        timer.schedule(new TimerTask() { // from class: com.samsung.android.support.senl.nt.composer.main.base.AiProgressActivity.startProgress.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Logger.m11003i(AiProgressActivity.TAG, "Timer# schedule");
                if (AiProgressActivity.this.isDestroyed()) {
                    return;
                }
                AiProgressActivity.this.stopProgress();
            }
        }, AIFeatureInfoManager.requestAIFeatureInfo(new AIFeatureInfoManager.Listener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.AiProgressActivity$startProgress$tokenInvalidate$1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.common.AIFeatureInfoManager.Listener
            public void checkedProgress() {
                this.this$0.checkedProgress();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.common.AIFeatureInfoManager.Listener
            public void stopProgress(String errCode) {
                if (Intrinsics.areEqual(ErrorCodeConvertor.NOT_REGISTER_COMPLETED, errCode)) {
                    this.this$0.getIntent().setAction(ErrorCodeConvertor.NOT_REGISTER_COMPLETED);
                }
                this.this$0.stopProgress();
            }
        }) ? 14000L : LOADING_MESSAGE_PERIOD_MS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void stopProgress$lambda$0(AiProgressActivity aiProgressActivity) {
        Logger.m11003i(TAG, "stopProgress#");
        aiProgressActivity.releaseTimer();
        if (aiProgressActivity.mIsServerCheckedCount == 3) {
            aiProgressActivity.finishWithSuccess();
        } else {
            aiProgressActivity.finishWithFailed();
        }
    }

    public final synchronized void checkedProgress() {
        int i = this.mIsServerCheckedCount + 1;
        this.mIsServerCheckedCount = i;
        if (i == 3) {
            stopProgress();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(524288);
        setContentView(C9086R.layout.ai_progress_activity);
        startProgress();
        Logger.m10999d(TAG, "onCreate");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Logger.m10999d(TAG, "onDestroy");
        super.onDestroy();
        stopProgress();
    }

    public final void stopProgress() {
        new Handler(Looper.getMainLooper()).post(new RunnableC8669a(this, 24));
    }
}
