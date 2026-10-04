package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.voice;

import android.R;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Handler;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import com.samsung.android.mcf.continuity.interfaces.ContinuityCommand;
import com.samsung.android.sdk.composer.voice.VoiceManager;
import com.samsung.android.sdk.pen.setting.patternpalette.ViewOnClickListenerC7602a;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.BroadcastCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.SViewManager;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.util.ButtonBackgroundUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.voice.VoiceModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.voice.VoiceState;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.view.SemWindowManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;
import p039I2.DialogInterfaceOnClickListenerC0140a;
import p046K2.DialogInterfaceOnClickListenerC0161a;
import p054M1.DialogInterfaceOnDismissListenerC0177d;
import p054M1.DialogInterfaceOnShowListenerC0176c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u0083\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001 \u0018\u0000 K2\u00020\u0001:\u0001KB7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\"\u001a\u00020#H\u0002J\u0006\u0010$\u001a\u00020#J\b\u0010%\u001a\u00020#H\u0002J\u0010\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\nH\u0002J\u0016\u0010(\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020)2\u0006\u0010'\u001a\u00020\nJ\u0012\u0010*\u001a\u00020#2\b\u0010+\u001a\u0004\u0018\u00010,H\u0002J\u000e\u0010/\u001a\u00020#2\u0006\u00100\u001a\u00020\nJ\u0018\u00101\u001a\u00020#2\u0006\u00100\u001a\u00020\n2\b\u00102\u001a\u0004\u0018\u00010\u001dJ\u0018\u00103\u001a\u00020#2\u0006\u00100\u001a\u00020\n2\b\u00102\u001a\u0004\u0018\u00010\u001dJ\u000e\u00104\u001a\u00020#2\u0006\u00105\u001a\u00020\nJ\u0018\u00106\u001a\u00020#2\u0006\u00100\u001a\u00020\n2\b\u00102\u001a\u0004\u0018\u00010\u001dJ\b\u00107\u001a\u00020#H\u0002J\b\u00108\u001a\u00020#H\u0002J\u001a\u00109\u001a\u00020#2\b\u0010:\u001a\u0004\u0018\u00010\u00032\u0006\u0010;\u001a\u00020<H\u0004J\u001a\u0010=\u001a\u00020#2\b\u0010:\u001a\u0004\u0018\u00010\u00032\u0006\u0010;\u001a\u00020<H\u0002J\b\u0010>\u001a\u00020#H\u0002J\u0012\u0010?\u001a\u00020#2\b\u0010:\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u0010@\u001a\u00020#2\b\u0010:\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010A\u001a\u00020#H\u0002J\b\u0010B\u001a\u00020#H\u0002J\b\u0010C\u001a\u00020#H\u0002J\b\u0010D\u001a\u00020#H\u0002J\u0010\u0010E\u001a\u00020\u00052\u0006\u0010F\u001a\u00020\nH\u0002J\u000e\u0010G\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u0003J\u0010\u0010H\u001a\u0004\u0018\u00010I2\u0006\u0010:\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010!R\u0014\u0010-\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0014\u0010J\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010.¨\u0006L"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/voice/VoiceNotificationHelper;", "", "mContext", "Landroid/content/Context;", "service", "", "needToRegister", "mObjectManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/composer/ObjectManager;", "progress", "", "mVoiceModel", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/voice/VoiceModel;", "<init>", "(Landroid/content/Context;ZZLcom/samsung/android/support/senl/nt/composer/main/base/model/composer/ObjectManager;ILcom/samsung/android/support/senl/nt/composer/main/base/model/voice/VoiceModel;)V", "mNotification", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/voice/VoiceNotification;", "mNotificationManager", "Landroid/app/NotificationManager;", "mNotificationReceiver", "Landroid/content/BroadcastReceiver;", "mCancelDialog", "Landroidx/appcompat/app/AlertDialog;", "mCancelDialogOnCover", "Landroid/app/Dialog;", "mPlayTime", "mRecordTime", "mIsStop", "mVoiceState", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/voice/VoiceState;", "SUB_SCREEN_DISPLAY", "mFoldStateListener", "com/samsung/android/support/senl/nt/composer/main/base/presenter/voice/VoiceNotificationHelper$mFoldStateListener$1", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/voice/VoiceNotificationHelper$mFoldStateListener$1;", "initNotification", "", "removeVoiceNotification", "hideVoiceNotification", "checkSelfPermission", "foregroundServiceType", "connectService", "Landroid/app/Service;", "notify", "notification", "Landroid/app/Notification;", "isUserSkip", "()Z", "updateRecordTime", "time", "updateRecordStatus", "voiceState", "updateNewRecordStatus", "updatePlayTime", "timeMillis", "updatePlayStatus", "registerNotificationReceiver", "updateNotificationView", "executeWithAction", "context", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "executeToCancelRecording", "removeNotificationReceiver", "showCancelDialog", "showCancelDialogActivity", "showRecordCancelDialogOnCover", "hideRecordCancelDialog", "initializeWindow", "initializeButtons", "needsUpdateTime", "timeInMilliseconds", "getDisplayingContext", "getSystemDisplayManager", "Landroid/hardware/display/DisplayManager;", "isRecordingVoiceState", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class VoiceNotificationHelper {
    public static final int NOTIFICATION_ACTION_CANCEL = 7;
    public static final int NOTIFICATION_ACTION_CANCEL_RECORDING = 3;
    public static final int NOTIFICATION_ACTION_CLEAR_BY_USER = 10;
    public static final int NOTIFICATION_ACTION_NEW_RECORD = 9;
    public static final int NOTIFICATION_ACTION_OPEN_APP = 8;
    public static final int NOTIFICATION_ACTION_PAUSE = 5;
    public static final int NOTIFICATION_ACTION_PAUSE_RECORDING = 1;
    public static final int NOTIFICATION_ACTION_PLAY = 4;
    public static final int NOTIFICATION_ACTION_START_RECORDING = 0;
    private static final int NOTIFICATION_ACTION_STOP = 6;
    public static final int NOTIFICATION_ACTION_STOP_RECORDING = 2;
    private static final int NOTIFICATION_ID = 32305934;

    @NotNull
    public static final String NOTIFICATION_INTENT_CLEARED_BY_USER = "notification_cleared_by_user";

    @NotNull
    public static final String NOTIFICATION_INTENT_FILTER = "samsungnotes_voice_noti";

    @NotNull
    public static final String NOTIFICATION_INTENT_KEY = "voice_noti_key";

    @NotNull
    public static final String NOTIFICATION_INTENT_NEW_RECORD = "voice_new_record";

    @NotNull
    public static final String NOTIFICATION_INTENT_STOP_RECORD_NOTI = "voice_stop_record_noti";

    @NotNull
    private static final String TAG;
    private final int SUB_SCREEN_DISPLAY;

    @Nullable
    private AlertDialog mCancelDialog;

    @Nullable
    private Dialog mCancelDialogOnCover;

    @NotNull
    private final Context mContext;

    @NotNull
    private final VoiceNotificationHelper$mFoldStateListener$1 mFoldStateListener;
    private boolean mIsStop;

    @Nullable
    private VoiceNotification mNotification;

    @Nullable
    private NotificationManager mNotificationManager;

    @Nullable
    private BroadcastReceiver mNotificationReceiver;

    @NotNull
    private final ObjectManager mObjectManager;
    private int mPlayTime;
    private int mRecordTime;

    @NotNull
    private final VoiceModel mVoiceModel;

    @Nullable
    private VoiceState mVoiceState;

    static {
        String strCreateTag = Logger.createTag("VoiceNotificationHelper");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
    }

    /* JADX WARN: Type inference failed for: r5v2, types: [com.samsung.android.support.senl.nt.composer.main.base.presenter.voice.VoiceNotificationHelper$mFoldStateListener$1] */
    public VoiceNotificationHelper(@NotNull Context mContext, boolean z, boolean z2, @NotNull ObjectManager mObjectManager, int i, @NotNull VoiceModel mVoiceModel) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(mObjectManager, "mObjectManager");
        Intrinsics.checkNotNullParameter(mVoiceModel, "mVoiceModel");
        this.mContext = mContext;
        this.mObjectManager = mObjectManager;
        this.mVoiceModel = mVoiceModel;
        this.SUB_SCREEN_DISPLAY = 1;
        this.mFoldStateListener = new SemWindowManager.FoldStateListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.voice.VoiceNotificationHelper$mFoldStateListener$1
            public void onFoldStateChanged(boolean isFolded) {
                AbstractC8014b.m7220v("onFoldStateChanged isFolded = ", VoiceNotificationHelper.TAG, isFolded);
                this.this$0.hideRecordCancelDialog();
            }

            public void onTableModeChanged(boolean isTableMode) {
                AbstractC8014b.m7220v("onTableModeChanged isTableMode = ", VoiceNotificationHelper.TAG, isTableMode);
            }
        };
        this.mNotification = new VoiceNotification(mContext, VoiceManager.isRecordingActivated(), i);
        Object systemService = mContext.getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        this.mNotificationManager = (NotificationManager) systemService;
        if (!z) {
            initNotification();
        }
        if (z2) {
            SViewManager.INSTANCE.getInstance().register(mContext, SViewManager.RegisterID.NOTIFICATION);
            registerNotificationReceiver();
        }
    }

    private final boolean checkSelfPermission(int foregroundServiceType) {
        return ContextCompat.checkSelfPermission(this.mContext, foregroundServiceType == 128 ? "android.permission.FOREGROUND_SERVICE_MICROPHONE" : "android.permission.FOREGROUND_SERVICE_MEDIA_PLAYBACK") == 0;
    }

    private final void executeToCancelRecording(Context context, Intent intent) {
        if (SViewManager.INSTANCE.getInstance().isCoverClosed(context, false)) {
            try {
                showRecordCancelDialogOnCover();
                return;
            } catch (Exception e) {
                AbstractC8014b.m7196B("error: ", e.getMessage(), TAG);
                hideRecordCancelDialog();
                return;
            }
        }
        try {
            boolean booleanExtra = intent.getBooleanExtra(NOTIFICATION_INTENT_NEW_RECORD, false);
            Logger.m10999d(TAG, "NotificationReceiver RecordCancel. " + booleanExtra);
            if (!booleanExtra) {
                showCancelDialog(context);
            } else {
                removeVoiceNotification();
                VoiceService.INSTANCE.stopService();
            }
        } catch (Exception e2) {
            AbstractC8014b.m7196B("error: ", e2.getMessage(), TAG);
            hideRecordCancelDialog();
            showCancelDialogActivity(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideRecordCancelDialog() {
        AlertDialog alertDialog = this.mCancelDialog;
        if (alertDialog != null) {
            Intrinsics.checkNotNull(alertDialog);
            alertDialog.dismiss();
            this.mCancelDialog = null;
        }
        Dialog dialog = this.mCancelDialogOnCover;
        if (dialog != null) {
            Intrinsics.checkNotNull(dialog);
            dialog.dismiss();
            this.mCancelDialogOnCover = null;
        }
    }

    private final void hideVoiceNotification() {
        Logger.m10999d(TAG, "hideVoiceNotification");
        NotificationManager notificationManager = this.mNotificationManager;
        if (notificationManager != null) {
            notificationManager.cancel(NOTIFICATION_ID);
        }
    }

    private final void initNotification() {
        VoiceNotification voiceNotification = this.mNotification;
        notify(voiceNotification != null ? voiceNotification.getNotification() : null);
    }

    private final void initializeButtons() {
        Dialog dialog = this.mCancelDialogOnCover;
        Intrinsics.checkNotNull(dialog);
        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }
        boolean zIsShowButtonShapeEnabled = ButtonBackgroundUtils.isShowButtonShapeEnabled(this.mContext);
        Button button = (Button) window.getDecorView().findViewById(C9086R.id.cover_canceldialog_cancel);
        if (button != null) {
            button.setBackgroundResource(C9086R.drawable.dialog_btn_borderless_material);
            final int i = 0;
            button.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.voice.b

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ VoiceNotificationHelper f7105b;

                {
                    this.f7105b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i) {
                        case 0:
                            this.f7105b.hideRecordCancelDialog();
                            break;
                        default:
                            VoiceNotificationHelper.initializeButtons$lambda$7(this.f7105b, view);
                            break;
                    }
                }
            });
            button.setTextColor(this.mContext.getResources().getColor(C9086R.color.notes_primary_color));
            if (zIsShowButtonShapeEnabled) {
                button.setBackgroundResource(C9086R.drawable.dialog_btn_border_material);
            }
        }
        Button button2 = (Button) window.getDecorView().findViewById(C9086R.id.cover_canceldialog_discard);
        if (button2 != null) {
            button2.setBackgroundResource(C9086R.drawable.dialog_btn_borderless_material);
            button2.setTextColor(this.mContext.getResources().getColor(C9086R.color.notes_primary_color));
            button2.setOnClickListener(new ViewOnClickListenerC7602a(4));
            if (zIsShowButtonShapeEnabled) {
                button2.setBackgroundResource(C9086R.drawable.dialog_btn_border_material);
            }
        }
        Button button3 = (Button) window.getDecorView().findViewById(C9086R.id.cover_canceldialog_save);
        if (button3 != null) {
            button3.setBackgroundResource(C9086R.drawable.dialog_btn_borderless_material);
            button3.setTextColor(this.mContext.getResources().getColor(C9086R.color.notes_primary_color));
            final int i2 = 1;
            button3.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.voice.b

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ VoiceNotificationHelper f7105b;

                {
                    this.f7105b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i2) {
                        case 0:
                            this.f7105b.hideRecordCancelDialog();
                            break;
                        default:
                            VoiceNotificationHelper.initializeButtons$lambda$7(this.f7105b, view);
                            break;
                    }
                }
            });
            if (zIsShowButtonShapeEnabled) {
                button3.setBackgroundResource(C9086R.drawable.dialog_btn_border_material);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initializeButtons$lambda$6(View view) {
        Logger.m10999d(TAG, "cancel recording in quickpanel while recording or pause by stop recording dialog");
        VoiceManager.cancelRecording();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initializeButtons$lambda$7(VoiceNotificationHelper voiceNotificationHelper, View view) {
        Logger.m10999d(TAG, "cancel recording in quickpanel while recording or pause by stop recording dialog");
        VoiceManager.stopRecording();
        voiceNotificationHelper.removeVoiceNotification();
        VoiceService.INSTANCE.stopService();
    }

    private final void initializeWindow() {
        Dialog dialog = this.mCancelDialogOnCover;
        Intrinsics.checkNotNull(dialog);
        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }
        window.setBackgroundDrawableResource(C9086R.color.dialog_bg);
        window.setType(2099);
        SViewManager.Companion companion = SViewManager.INSTANCE;
        window.setLayout(companion.getInstance().getCoverWindowWidth(), companion.getInstance().getCoverWindowHeight());
        window.getDecorView().setPadding(this.mContext.getResources().getDimensionPixelSize(C9086R.dimen.cover_dialog_start_padding), 0, this.mContext.getResources().getDimensionPixelSize(C9086R.dimen.cover_dialog_start_padding), 0);
        window.clearFlags(2);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.windowAnimations = 0;
        window.setAttributes(attributes);
        window.addFlags(524288);
    }

    private final boolean isRecordingVoiceState() {
        VoiceState voiceState = this.mVoiceState;
        return voiceState == VoiceState.RECORD_STARTED || voiceState == VoiceState.RECORD_PROGRESS || voiceState == VoiceState.RECORD_PAUSE || voiceState == VoiceState.RECORD_RESUMED;
    }

    private final boolean isUserSkip() {
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.VoiceRecorder;
        if (!UserInputSkipper.isValidSingleActionEvent(false, tag)) {
            return false;
        }
        UserInputSkipper.setHoldingSingleActionEventTime(700L, tag);
        return true;
    }

    private final boolean needsUpdateTime(int timeInMilliseconds) {
        int i = timeInMilliseconds / 1000;
        if (this.mPlayTime == i) {
            return false;
        }
        this.mPlayTime = i;
        return true;
    }

    private final void notify(Notification notification) {
        String str = TAG;
        Logger.m10999d(str, "notify");
        if (this.mVoiceModel.getMIsNotificationClearedByUser()) {
            Logger.m10999d(str, "notify# notification is cleared by user");
            return;
        }
        NotificationManager notificationManager = this.mNotificationManager;
        if (notificationManager != null) {
            notificationManager.notify(NOTIFICATION_ID, notification);
        }
    }

    private final void registerNotificationReceiver() {
        if (this.mNotificationReceiver != null) {
            return;
        }
        this.mNotificationReceiver = new BroadcastReceiver() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.voice.VoiceNotificationHelper.registerNotificationReceiver.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                if (Intrinsics.areEqual("android.intent.action.LOCALE_CHANGED", intent.getAction())) {
                    Logger.m10999d(VoiceNotificationHelper.TAG, "NotificationReceiver onReceive : ACTION_LOCALE_CHANGED");
                    VoiceNotificationHelper.this.updateNotificationView();
                } else {
                    VoiceNotificationHelper.this.mIsStop = intent.getBooleanExtra(VoiceNotificationHelper.NOTIFICATION_INTENT_STOP_RECORD_NOTI, false);
                    VoiceNotificationHelper.this.executeWithAction(context, intent);
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.LOCALE_CHANGED");
        intentFilter.addAction(NOTIFICATION_INTENT_FILTER);
        intentFilter.addAction(NOTIFICATION_INTENT_CLEARED_BY_USER);
        BroadcastCompat.Companion companion = BroadcastCompat.INSTANCE;
        Context applicationContext = this.mContext.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        companion.registerReceiver(applicationContext, this.mNotificationReceiver, intentFilter, 4);
        if (DeviceUtils.isLargeCoverScreen()) {
            SemWindowManager.getInstance().registerFoldStateListener(this.mFoldStateListener, (Handler) null);
        }
    }

    private final void removeNotificationReceiver() {
        if (this.mNotificationReceiver != null) {
            try {
                this.mContext.getApplicationContext().unregisterReceiver(this.mNotificationReceiver);
                if (DeviceUtils.isLargeCoverScreen()) {
                    SemWindowManager.getInstance().unregisterFoldStateListener(this.mFoldStateListener);
                }
            } catch (IllegalArgumentException e) {
                Logger.m11000e(TAG, e.toString());
            } finally {
                this.mNotificationReceiver = null;
            }
        }
    }

    private final void showCancelDialog(Context context) {
        if (context == null || this.mCancelDialog != null) {
            return;
        }
        AlertDialogBuilderForAppCompat alertDialogBuilderForAppCompat = new AlertDialogBuilderForAppCompat(getDisplayingContext(context), 0, 2, null);
        if (DeviceUtils.isLargeCoverScreen() && DeviceUtils.isDeviceFolded()) {
            alertDialogBuilderForAppCompat.setView(C9086R.layout.cover_screen_confirm_cancel_dialog_layout);
        } else {
            alertDialogBuilderForAppCompat.setMessage(context.getString(C9086R.string.voice_alertdialog_message));
        }
        alertDialogBuilderForAppCompat.setPositiveButton(context.getResources().getString(C9086R.string.string_save), new DialogInterfaceOnClickListenerC0161a(this, 12)).setNegativeButton(context.getResources().getString(C9086R.string.string_discard), new DialogInterfaceOnClickListenerC0140a(16)).setNeutralButton(context.getResources().getString(C9086R.string.string_cancel), new DialogInterfaceOnClickListenerC0140a(17));
        alertDialogBuilderForAppCompat.setOnDismissListener(new DialogInterfaceOnDismissListenerC0177d(this, 9));
        alertDialogBuilderForAppCompat.setCancelable(true);
        AlertDialog alertDialogCreate = alertDialogBuilderForAppCompat.create();
        this.mCancelDialog = alertDialogCreate;
        Intrinsics.checkNotNull(alertDialogCreate);
        if (alertDialogCreate.getWindow() != null) {
            AlertDialog alertDialog = this.mCancelDialog;
            Intrinsics.checkNotNull(alertDialog);
            Window window = alertDialog.getWindow();
            Intrinsics.checkNotNull(window);
            window.setType(ContinuityCommand.CMD_ASYNC_UNREGISTER_SIMPLE_MESSAGE_LISTENER);
        }
        AlertDialog alertDialog2 = this.mCancelDialog;
        Intrinsics.checkNotNull(alertDialog2);
        alertDialog2.setCanceledOnTouchOutside(true);
        AlertDialog alertDialog3 = this.mCancelDialog;
        Intrinsics.checkNotNull(alertDialog3);
        alertDialog3.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showCancelDialog$lambda$0(VoiceNotificationHelper voiceNotificationHelper, DialogInterface dialogInterface, int i) {
        VoiceManager.stopRecording();
        dialogInterface.dismiss();
        voiceNotificationHelper.removeVoiceNotification();
        VoiceService.INSTANCE.stopService();
        ComposerSA.insertLog(ComposerSAConstants.SCREEN_DIALOGS_DISCARD_VOICE_REC, ComposerSAConstants.EVENT_DIALOGS_DISCARD_VOICE_REC_SAVE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showCancelDialog$lambda$1(DialogInterface dialogInterface, int i) {
        VoiceManager.cancelRecording();
        dialogInterface.dismiss();
        ComposerSA.insertLog(ComposerSAConstants.SCREEN_DIALOGS_DISCARD_VOICE_REC, ComposerSAConstants.EVENT_DIALOGS_DISCARD_VOICE_REC_DISCARD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showCancelDialog$lambda$2(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        ComposerSA.insertLog(ComposerSAConstants.SCREEN_DIALOGS_DISCARD_VOICE_REC, ComposerSAConstants.EVENT_DIALOGS_DISCARD_VOICE_REC_CANCEL);
    }

    private final void showCancelDialogActivity(Context context) {
        if (context != null) {
            Intent intent = new Intent(context, (Class<?>) VoiceNotificationDialogActivity.class);
            intent.setFlags(268435456);
            context.startActivity(intent);
        }
    }

    private final void showRecordCancelDialogOnCover() {
        hideRecordCancelDialog();
        Dialog dialog = new Dialog(new ContextThemeWrapper(this.mContext, R.style.Theme.DeviceDefault.Light));
        this.mCancelDialogOnCover = dialog;
        Intrinsics.checkNotNull(dialog);
        dialog.requestWindowFeature(1);
        Dialog dialog2 = this.mCancelDialogOnCover;
        Intrinsics.checkNotNull(dialog2);
        dialog2.setCancelable(true);
        Dialog dialog3 = this.mCancelDialogOnCover;
        Intrinsics.checkNotNull(dialog3);
        dialog3.setContentView(C9086R.layout.voice_dialog_recording_cancel_on_cover);
        initializeWindow();
        initializeButtons();
        Dialog dialog4 = this.mCancelDialogOnCover;
        Intrinsics.checkNotNull(dialog4);
        dialog4.setOnShowListener(new DialogInterfaceOnShowListenerC0176c(this, 6));
        Dialog dialog5 = this.mCancelDialogOnCover;
        Intrinsics.checkNotNull(dialog5);
        dialog5.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showRecordCancelDialogOnCover$lambda$4(VoiceNotificationHelper voiceNotificationHelper, DialogInterface dialogInterface) {
        Dialog dialog = voiceNotificationHelper.mCancelDialogOnCover;
        Intrinsics.checkNotNull(dialog);
        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) window.getDecorView().findViewById(C9086R.id.cover_canceldialog_button_bar);
        Button button = (Button) window.getDecorView().findViewById(C9086R.id.cover_canceldialog_cancel);
        Button button2 = (Button) window.getDecorView().findViewById(C9086R.id.cover_canceldialog_discard);
        Button button3 = (Button) window.getDecorView().findViewById(C9086R.id.cover_canceldialog_save);
        if (linearLayout == null || button3 == null || button == null || button2 == null) {
            return;
        }
        button3.measure(0, 0);
        button.measure(0, 0);
        button2.measure(0, 0);
        if (((int) ((TypedValue.applyDimension(1, 8.0f, voiceNotificationHelper.mContext.getResources().getDisplayMetrics()) * 4) + button2.getMeasuredWidth() + button.getMeasuredWidth() + button3.getMeasuredWidth())) > linearLayout.getWidth()) {
            linearLayout.setOrientation(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateNotificationView() {
        VoiceState voiceState = this.mVoiceState;
        if (voiceState == VoiceState.RECORD_IDLE) {
            updateNewRecordStatus(this.mRecordTime, voiceState);
        } else if (isRecordingVoiceState()) {
            updateRecordTime(this.mRecordTime);
        } else {
            updatePlayStatus(this.mPlayTime, this.mVoiceState);
        }
    }

    public final boolean connectService(@NotNull Service service, int foregroundServiceType) {
        Intrinsics.checkNotNullParameter(service, "service");
        VoiceNotification voiceNotification = this.mNotification;
        if (voiceNotification == null) {
            return false;
        }
        Intrinsics.checkNotNull(voiceNotification);
        Notification notification = voiceNotification.getNotification();
        if (notification == null) {
            return false;
        }
        try {
            if (Build.VERSION.SDK_INT >= 33) {
                service.startForeground(32305934, notification, foregroundServiceType);
                return true;
            }
            service.startForeground(NOTIFICATION_ID, notification);
            return true;
        } catch (Exception e) {
            AbstractC8014b.m7198D("connectService# ", e.getMessage(), TAG);
            return false;
        }
    }

    public final void executeWithAction(@Nullable Context context, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (!isUserSkip()) {
            Logger.m10999d(TAG, "NotificationReceiver onReceive, isUserSkip");
        }
        int intExtra = intent.getIntExtra(NOTIFICATION_INTENT_KEY, -1);
        AbstractC0000a.m3D(intExtra, "NotificationReceiver onReceive, type : ", TAG);
        switch (intExtra) {
            case 0:
                ComposerSA.insertLog("406", ComposerSAConstants.EVENT_VOICE_RECORDING_QUICK_PANEL_RECORD);
                if (!VoiceUtil.INSTANCE.isCalling(context)) {
                    VoiceManager.resumeRecording();
                } else {
                    ToastHandler.show(context, C9086R.string.voice_warning_call_isactive, 0);
                }
                break;
            case 1:
                ComposerSA.insertLog("406", ComposerSAConstants.EVENT_VOICE_RECORDING_QUICK_PANEL_PAUSE);
                VoiceManager.pauseRecording();
                break;
            case 2:
                ComposerSA.insertLog("406", ComposerSAConstants.EVENT_VOICE_RECORDING_QUICK_PANEL_STOP);
                VoiceManager.stopRecording();
                break;
            case 3:
                ComposerSA.insertLog("406", ComposerSAConstants.EVENT_VOICE_RECORDING_QUICK_PANEL_DELETE);
                executeToCancelRecording(context, intent);
                break;
            case 4:
                ComposerSA.insertLog("406", ComposerSAConstants.EVENT_VOICE_RECORDING_QUICK_PANEL_PLAY);
                if (!VoiceUtil.INSTANCE.isCalling(context)) {
                    VoiceManager.resumePlaying();
                } else {
                    ToastHandler.show(context, C9086R.string.voice_unable_to_play_during_call, 0);
                }
                break;
            case 5:
                ComposerSA.insertLog("406", ComposerSAConstants.EVENT_VOICE_RECORDING_QUICK_PANEL_PAUSE);
                VoiceManager.pausePlaying();
                break;
            case 6:
                ComposerSA.insertLog("406", ComposerSAConstants.EVENT_VOICE_RECORDING_QUICK_PANEL_STOP);
                VoiceManager.stopPlaying();
                removeVoiceNotification();
                break;
            case 7:
                ComposerSA.insertLog("406", ComposerSAConstants.EVENT_VOICE_RECORDING_QUICK_PANEL_DELETE);
                VoiceManager.stopPlaying();
                removeVoiceNotification();
                break;
            case 8:
                ComposerSA.insertLog("406", ComposerSAConstants.EVENT_VOICE_RECORDING_QUICK_PANEL_VIEW_NOTE);
                break;
            case 9:
                this.mObjectManager.insertVoiceData();
                break;
            case 10:
                this.mVoiceModel.setNotificationClearByUser(true);
                hideVoiceNotification();
                break;
        }
    }

    @NotNull
    public final Context getDisplayingContext(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DisplayManager systemDisplayManager = getSystemDisplayManager(context);
        if (systemDisplayManager != null) {
            Context contextCreateDisplayContext = null;
            Display display = (DeviceUtils.isLargeCoverScreen() && DeviceUtils.isDeviceFolded()) ? systemDisplayManager.getDisplay(this.SUB_SCREEN_DISPLAY) : null;
            if (display == null) {
                Logger.m11000e(TAG, "get display failed");
            } else {
                contextCreateDisplayContext = context.createDisplayContext(display);
            }
            if (contextCreateDisplayContext != null) {
                String str = TAG;
                Intrinsics.checkNotNull(display);
                AbstractC8014b.m7217s(display.getDisplayId(), "getDisplayContext - get display: ", str);
                return contextCreateDisplayContext;
            }
        }
        return context;
    }

    @Nullable
    public final DisplayManager getSystemDisplayManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!(context.getSystemService("display") instanceof DisplayManager)) {
            Logger.m11000e(TAG, "Cannot get DisplayManager");
            return null;
        }
        Object systemService = context.getSystemService("display");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.display.DisplayManager");
        return (DisplayManager) systemService;
    }

    public final void removeVoiceNotification() {
        Logger.m10999d(TAG, "removeVoiceNotification");
        NotificationManager notificationManager = this.mNotificationManager;
        if (notificationManager != null) {
            Intrinsics.checkNotNull(notificationManager);
            notificationManager.cancel(NOTIFICATION_ID);
            this.mNotificationManager = null;
        }
        this.mNotification = null;
        removeNotificationReceiver();
        hideRecordCancelDialog();
        SViewManager.INSTANCE.getInstance().unregister(SViewManager.RegisterID.NOTIFICATION);
    }

    public final void updateNewRecordStatus(int time, @Nullable VoiceState voiceState) {
        AbstractC8014b.m7220v("updateNewRecordStatus. ", TAG, this.mIsStop);
        this.mRecordTime = time;
        this.mVoiceState = voiceState;
        if (!this.mIsStop) {
            removeVoiceNotification();
            VoiceService.INSTANCE.stopService();
            return;
        }
        VoiceNotification voiceNotification = this.mNotification;
        if (voiceNotification != null) {
            Intrinsics.checkNotNull(voiceNotification);
            notify(voiceNotification.updateNewRecordingStatus(time, voiceState));
        }
    }

    public final void updatePlayStatus(int time, @Nullable VoiceState voiceState) {
        this.mPlayTime = time;
        this.mVoiceState = voiceState;
        VoiceNotification voiceNotification = this.mNotification;
        if (voiceNotification != null) {
            Intrinsics.checkNotNull(voiceNotification);
            notify(voiceNotification.updatePlayStatus(time, voiceState));
        }
    }

    public final void updatePlayTime(int timeMillis) {
        VoiceNotification voiceNotification = this.mNotification;
        if (voiceNotification != null) {
            Intrinsics.checkNotNull(voiceNotification);
            if (voiceNotification.isValid() && needsUpdateTime(timeMillis)) {
                VoiceNotification voiceNotification2 = this.mNotification;
                Intrinsics.checkNotNull(voiceNotification2);
                Notification notificationUpdatePlayTime = voiceNotification2.updatePlayTime(this.mPlayTime);
                if (notificationUpdatePlayTime != null) {
                    notify(notificationUpdatePlayTime);
                } else {
                    Logger.m10999d(TAG, "updatePlayTime: empty notification. skip.");
                }
            }
        }
    }

    public final void updateRecordStatus(int time, @Nullable VoiceState voiceState) {
        this.mRecordTime = time;
        this.mVoiceState = voiceState;
        String strCreateTimeString$default = VoiceUtil.createTimeString$default(VoiceUtil.INSTANCE, time, false, 2, null);
        VoiceNotification voiceNotification = this.mNotification;
        if (voiceNotification == null || strCreateTimeString$default == null) {
            return;
        }
        Intrinsics.checkNotNull(voiceNotification);
        notify(voiceNotification.updateRecordStatus(time, voiceState));
    }

    public final void updateRecordTime(int time) {
        VoiceNotification voiceNotification = this.mNotification;
        if (voiceNotification != null) {
            Intrinsics.checkNotNull(voiceNotification);
            if (voiceNotification.isValid()) {
                this.mRecordTime = time;
                VoiceNotification voiceNotification2 = this.mNotification;
                Intrinsics.checkNotNull(voiceNotification2);
                Notification notificationUpdateRecordTime = voiceNotification2.updateRecordTime(time);
                if (notificationUpdateRecordTime != null) {
                    notify(notificationUpdateRecordTime);
                } else {
                    Logger.m10999d(TAG, "updateRecordTime: empty notification. skip.");
                }
            }
        }
    }
}
