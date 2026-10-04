package com.samsung.android.support.senl.p148nt.composer.main.nativecomposer;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p145cm.base.framework.app.KeyguardManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.PowerManagerCompat;
import com.samsung.android.support.senl.p148nt.base.common.access.composer.ComposerAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.util.NotificationUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.StorageUtils;
import com.samsung.android.support.senl.p148nt.base.winset.util.DialogUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.nativecomposer.NativeComposerTriggerActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/nativecomposer/NativeComposerTriggerActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "isForVoiceRecord", "", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "canUseVoiceRecord", "notifyNotification", "context", "Landroid/content/Context;", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nNativeComposerTriggerActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NativeComposerTriggerActivity.kt\ncom/samsung/android/support/senl/nt/composer/main/nativecomposer/NativeComposerTriggerActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,104:1\n1#2:105\n*E\n"})
public final class NativeComposerTriggerActivity extends AppCompatActivity {

    @NotNull
    private static final String ARG_NEED_TO_CHECK_KEYGUARD = "app_need_to_check_keyguard";

    @NotNull
    private static final String CHANNEL_ID_NOTIFICATION_NOTES_COMPOSER = "CHANNEL_ID_NOTIFICATION_NOTES_COMPOSER";
    private static final int NOTIFICATION_ID_NOTES_COMPOSER = 1001;

    @NotNull
    private static final String TAG = "NativeComposerTriggerActivity";

    private final boolean canUseVoiceRecord() {
        PowerManagerCompat.Companion companion = PowerManagerCompat.INSTANCE;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        return companion.getInstance(applicationContext).isInteractive() && !KeyguardManagerCompat.INSTANCE.getInstance().isKeyguardLocked(getApplicationContext());
    }

    private final boolean isForVoiceRecord(Intent intent) {
        return Intrinsics.areEqual(ComposerConstants.NEW_MEMO_VOICE_OPEN, intent.getStringExtra(ComposerConstants.MEMO_WIDGET_ACTION));
    }

    private final void notifyNotification(Context context) {
        String string = context.getResources().getString(C9086R.string.voice_notification_can_not_start_recording);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        Notification.Builder autoCancel = NotificationUtils.createNotification$default(context, CHANNEL_ID_NOTIFICATION_NOTES_COMPOSER, TAG, 0, false, 24, null).setSmallIcon(C9086R.drawable.stat_notify_notes).setContentText(string).setStyle(new Notification.BigTextStyle().bigText(string)).setAutoCancel(true);
        Intrinsics.checkNotNullExpressionValue(autoCancel, "setAutoCancel(...)");
        Notification notificationBuild = autoCancel.build();
        Intrinsics.checkNotNullExpressionValue(notificationBuild, "build(...)");
        Object systemService = context.getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        try {
            ((NotificationManager) systemService).notify(1001, notificationBuild);
        } catch (IllegalArgumentException e) {
            Logger.m11000e(TAG, e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(NativeComposerTriggerActivity nativeComposerTriggerActivity) {
        nativeComposerTriggerActivity.getIntent().putExtra(ARG_NEED_TO_CHECK_KEYGUARD, false);
        nativeComposerTriggerActivity.startActivity(nativeComposerTriggerActivity.getIntent());
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.m10999d(TAG, "onCreate, action: " + getIntent().getAction());
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
        if (isForVoiceRecord(intent) && !canUseVoiceRecord()) {
            Logger.m11003i(TAG, "cannot UseVoiceRecord");
            if (getIntent().getBooleanExtra(ARG_NEED_TO_CHECK_KEYGUARD, true)) {
                final int i = 0;
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this) { // from class: I3.a

                    /* JADX INFO: renamed from: b */
                    public final /* synthetic */ NativeComposerTriggerActivity f395b;

                    {
                        this.f395b = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i) {
                            case 0:
                                NativeComposerTriggerActivity.onCreate$lambda$0(this.f395b);
                                break;
                            default:
                                this.f395b.finish();
                                break;
                        }
                    }
                }, 500L);
                finish();
                return;
            } else {
                Context applicationContext = getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                notifyNotification(applicationContext);
                finish();
                return;
            }
        }
        if (!StorageUtils.isAvailableMemoryForNewMemo()) {
            final int i2 = 1;
            DialogUtils.showNotEnoughStorageDialog(this, new Runnable(this) { // from class: I3.a

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ NativeComposerTriggerActivity f395b;

                {
                    this.f395b = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    switch (i2) {
                        case 0:
                            NativeComposerTriggerActivity.onCreate$lambda$0(this.f395b);
                            break;
                        default:
                            this.f395b.finish();
                            break;
                    }
                }
            });
            return;
        }
        if (ComposerAccessHandler.getComposerActivityClass() == null) {
            PostLaunchManager.INSTANCE.getInstance().executeBaseLogic(1);
        }
        Class<?> composerActivityClass = ComposerAccessHandler.getComposerActivityClass();
        if (composerActivityClass != null) {
            getIntent().setClass(getApplicationContext(), composerActivityClass);
        }
        getIntent().setFlags(134742016);
        startActivity(getIntent());
        String stringExtra = getIntent().getStringExtra(ComposerConstants.MEMO_WIDGET_ACTION);
        if (stringExtra != null && stringExtra.length() != 0) {
            if (Intrinsics.areEqual(stringExtra, ComposerConstants.NEW_MEMO_WRITING_OPEN)) {
                ComposerSA.insertStatusLog("9985", "Task Edge_Pen");
            } else if (Intrinsics.areEqual(stringExtra, ComposerConstants.NEW_MEMO_DRAWING_OPEN)) {
                ComposerSA.insertStatusLog("9985", "Task Edge_Brush");
            }
        }
        finish();
    }
}
