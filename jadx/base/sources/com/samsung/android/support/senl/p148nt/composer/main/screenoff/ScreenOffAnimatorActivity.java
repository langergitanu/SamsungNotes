package com.samsung.android.support.senl.p148nt.composer.main.screenoff;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.appcompat.app.AppCompatActivity;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowInsetsCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.base.common.ActivityLifecycleTracker;
import com.samsung.android.support.senl.p148nt.base.common.ApplicationManager;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.feature.ExposedActivityFinishFeature;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.feature.ForceHideSoftInputFeature;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0003\u0012\u0013\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\n\u001a\u00020\u0007H\u0014J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00060\u0011R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/ScreenOffAnimatorActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "mActivityLifeCycleCallback", "Lcom/samsung/android/support/senl/nt/base/common/ActivityLifecycleTracker$ActivityLifeCycleCallback;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "initWindowAttributes", "setSystemUIVisibility", "onFinish", "reason", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/ScreenOffAnimatorActivity$FinishReason;", "mHandler", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/ScreenOffAnimatorActivity$MessageHandler;", "FinishReason", "MessageHandler", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nScreenOffAnimatorActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScreenOffAnimatorActivity.kt\ncom/samsung/android/support/senl/nt/composer/main/screenoff/ScreenOffAnimatorActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,119:1\n1#2:120\n*E\n"})
public final class ScreenOffAnimatorActivity extends AppCompatActivity {
    private static final int MESSAGE_NOTIFY_FINISHED = 1;
    private static final int WAIT_TO_NOTIFY_FINISHED_DELAY = 1000;

    @Nullable
    private ActivityLifecycleTracker.ActivityLifeCycleCallback mActivityLifeCycleCallback;

    @NotNull
    private final MessageHandler mHandler;

    @NotNull
    private static final String TAG = SOLogger.createTag("ScreenOffAnimatorActivity");
    private static final String SCREEN_OFF_ACTIVITY = "ScreenOffActivity";

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/ScreenOffAnimatorActivity$FinishReason;", "", "<init>", "(Ljava/lang/String;I)V", "ACTIVITY_RESUMED", "ACTIVITY_POST_RESUMED", "NOTIFY_FINISHED", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class FinishReason {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ FinishReason[] $VALUES;
        public static final FinishReason ACTIVITY_RESUMED = new FinishReason("ACTIVITY_RESUMED", 0);
        public static final FinishReason ACTIVITY_POST_RESUMED = new FinishReason("ACTIVITY_POST_RESUMED", 1);
        public static final FinishReason NOTIFY_FINISHED = new FinishReason("NOTIFY_FINISHED", 2);

        private static final /* synthetic */ FinishReason[] $values() {
            return new FinishReason[]{ACTIVITY_RESUMED, ACTIVITY_POST_RESUMED, NOTIFY_FINISHED};
        }

        static {
            FinishReason[] finishReasonArr$values = $values();
            $VALUES = finishReasonArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(finishReasonArr$values);
        }

        private FinishReason(String str, int i) {
        }

        @NotNull
        public static EnumEntries<FinishReason> getEntries() {
            return $ENTRIES;
        }

        public static FinishReason valueOf(String str) {
            return (FinishReason) Enum.valueOf(FinishReason.class, str);
        }

        public static FinishReason[] values() {
            return (FinishReason[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/ScreenOffAnimatorActivity$MessageHandler;", "Landroid/os/Handler;", "looper", "Landroid/os/Looper;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/screenoff/ScreenOffAnimatorActivity;Landroid/os/Looper;)V", "handleMessage", "", "msg", "Landroid/os/Message;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class MessageHandler extends Handler {
        final /* synthetic */ ScreenOffAnimatorActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MessageHandler(@NotNull ScreenOffAnimatorActivity screenOffAnimatorActivity, Looper looper) {
            super(looper);
            Intrinsics.checkNotNullParameter(looper, "looper");
            this.this$0 = screenOffAnimatorActivity;
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message msg) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            if (msg.what == 1) {
                this.this$0.onFinish(FinishReason.NOTIFY_FINISHED);
            }
        }
    }

    public ScreenOffAnimatorActivity() {
        Looper mainLooper = Looper.getMainLooper();
        Intrinsics.checkNotNullExpressionValue(mainLooper, "getMainLooper(...)");
        this.mHandler = new MessageHandler(this, mainLooper);
    }

    private final void initWindowAttributes() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "initWindowAttributes#");
        getWindow().addFlags(131075);
        WindowManagerCompat.Companion companion = WindowManagerCompat.INSTANCE;
        companion.getInstance().setTurnScreenOn(this, true, false);
        companion.getInstance().setShowWhenLocked(this, true, false);
        WindowInsetsCompat.INSTANCE.getInstance().setFitInsetsTypesNavigationBar(getWindow());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onFinish(FinishReason reason) {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onFinish# reason " + reason);
        if (isFinishing() || isDestroyed()) {
            return;
        }
        finish();
    }

    private final void setSystemUIVisibility() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "setSystemUIVisibility#");
        ViewCompat.INSTANCE.getInstance().setSystemUiVisibility(getWindow().getDecorView(), 5382, true, true, true);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SOLogger.INSTANCE.SOLoggerD(TAG, "onCreate#");
        overridePendingTransition(0, 0);
        ForceHideSoftInputFeature forceHideSoftInputFeature = ForceHideSoftInputFeature.INSTANCE;
        if (forceHideSoftInputFeature.needToForceHideSoftInput(this)) {
            forceHideSoftInputFeature.hideSoftInput(this);
        }
        initWindowAttributes();
        setSystemUIVisibility();
        ActivityLifecycleTracker activityTracker = ApplicationManager.INSTANCE.getInstance().getActivityTracker();
        ActivityLifecycleTracker.ActivityLifeCycleCallback activityLifeCycleCallback = new ActivityLifecycleTracker.ActivityLifeCycleCallback() { // from class: com.samsung.android.support.senl.nt.composer.main.screenoff.ScreenOffAnimatorActivity.onCreate.1
            @Override // com.samsung.android.support.senl.nt.base.common.ActivityLifecycleTracker.ActivityLifeCycleCallback
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // com.samsung.android.support.senl.nt.base.common.ActivityLifecycleTracker.ActivityLifeCycleCallback
            public void onActivityPaused(Activity activity) {
            }

            @Override // com.samsung.android.support.senl.nt.base.common.ActivityLifecycleTracker.ActivityLifeCycleCallback
            public void onActivityPostResumed(Activity activity) {
                if (activity == null || !Intrinsics.areEqual(ScreenOffAnimatorActivity.SCREEN_OFF_ACTIVITY, activity.getClass().getSimpleName())) {
                    return;
                }
                ScreenOffAnimatorActivity.this.onFinish(FinishReason.ACTIVITY_POST_RESUMED);
            }

            @Override // com.samsung.android.support.senl.nt.base.common.ActivityLifecycleTracker.ActivityLifeCycleCallback
            public void onActivityResumed(Activity activity) {
                if (ExposedActivityFinishFeature.INSTANCE.isActivityPostResumedSupported() || activity == null || !Intrinsics.areEqual(ScreenOffAnimatorActivity.SCREEN_OFF_ACTIVITY, activity.getClass().getSimpleName())) {
                    return;
                }
                ScreenOffAnimatorActivity.this.onFinish(FinishReason.ACTIVITY_RESUMED);
            }
        };
        this.mActivityLifeCycleCallback = activityLifeCycleCallback;
        activityTracker.addOnActivityLifeCycleCallback(activityLifeCycleCallback);
        this.mHandler.removeMessages(1);
        this.mHandler.sendEmptyMessageDelayed(1, 1000L);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        SOLogger.INSTANCE.SOLoggerD(TAG, "onDestroy#");
        ApplicationManager.INSTANCE.getInstance().getActivityTracker().removeOnActivityLifeCycleCallback(this.mActivityLifeCycleCallback);
        this.mActivityLifeCycleCallback = null;
        this.mHandler.removeMessages(1);
    }
}
