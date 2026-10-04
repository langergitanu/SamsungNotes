package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.voice;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.app.AlertDialog;
import com.samsung.android.sdk.composer.voice.VoiceManager;
import com.samsung.android.support.senl.p148nt.base.common.util.ButtonBackgroundUtils;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p054M1.DialogInterfaceOnDismissListenerC0177d;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\n\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\u0006\u0010\f\u001a\u00020\u0007J \u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/voice/VoiceNotificationDialogActivity;", "Landroid/app/Activity;", "<init>", "()V", "mOverlay", "Landroid/view/ViewGroup;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "showConfirmSaveDialog", "createOverlay", "checkDrawOverlayPermission", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class VoiceNotificationDialogActivity extends Activity {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int REQUEST_CODE;

    @NotNull
    private static final String TAG;

    @Nullable
    private ViewGroup mOverlay;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0018\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u000fX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/voice/VoiceNotificationDialogActivity$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "setBackground", "", "context", "Landroid/content/Context;", "alertDialog", "Landroidx/appcompat/app/AlertDialog;", "setButtonTextSize", "dialog", "size", "", "REQUEST_CODE", "getREQUEST_CODE", "()I", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getREQUEST_CODE() {
            return VoiceNotificationDialogActivity.REQUEST_CODE;
        }

        public final void setBackground(@Nullable Context context, @Nullable AlertDialog alertDialog) {
            if (alertDialog != null) {
                Button button = alertDialog.getButton(-1);
                Button button2 = alertDialog.getButton(-2);
                Button button3 = alertDialog.getButton(-3);
                if (ButtonBackgroundUtils.isShowButtonShapeEnabled(context)) {
                    if (button != null) {
                        button.setBackgroundResource(C9086R.drawable.dialog_btn_border_material);
                    }
                    if (button2 != null) {
                        button2.setBackgroundResource(C9086R.drawable.dialog_btn_border_material);
                    }
                    if (button3 != null) {
                        button3.setBackgroundResource(C9086R.drawable.dialog_btn_border_material);
                        return;
                    }
                    return;
                }
                if (button != null) {
                    button.setBackgroundResource(C9086R.drawable.dialog_btn_borderless_material);
                }
                if (button2 != null) {
                    button2.setBackgroundResource(C9086R.drawable.dialog_btn_borderless_material);
                }
                if (button3 != null) {
                    button3.setBackgroundResource(C9086R.drawable.dialog_btn_borderless_material);
                }
            }
        }

        public final void setButtonTextSize(@Nullable AlertDialog dialog, int size) {
            if (dialog != null) {
                Logger.m10999d(VoiceNotificationDialogActivity.TAG, "setButtonTextSize: size = " + size);
                Button button = dialog.getButton(-1);
                Button button2 = dialog.getButton(-2);
                Button button3 = dialog.getButton(-3);
                if (button != null) {
                    button.setTextSize(0, size);
                }
                if (button2 != null) {
                    button2.setTextSize(0, size);
                }
                if (button3 != null) {
                    button3.setTextSize(0, size);
                }
            }
        }

        private Companion() {
        }
    }

    static {
        String strCreateTag = Logger.createTag("VoiceNotificationDialogActivity");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
        REQUEST_CODE = -1010101;
    }

    private final void createOverlay() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, -2, 2003, 40, -3);
        layoutParams.gravity = 17;
        Object systemService = getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        View viewInflate = ((LayoutInflater) systemService).inflate(C9086R.layout.voice_confirm_cancel_dialog, (ViewGroup) null);
        Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.widget.LinearLayout");
        this.mOverlay = (LinearLayout) viewInflate;
        Object systemService2 = getSystemService("window");
        Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.view.WindowManager");
        ((WindowManager) systemService2).addView(this.mOverlay, layoutParams);
    }

    private final void showConfirmSaveDialog() {
        AlertDialogBuilderForAppCompat alertDialogBuilderForAppCompat = new AlertDialogBuilderForAppCompat(this, 0, 2, null);
        alertDialogBuilderForAppCompat.setMessage(getString(C9086R.string.voice_alertdialog_message));
        final int i = 0;
        final int i2 = 1;
        final int i4 = 2;
        alertDialogBuilderForAppCompat.setPositiveButton(getResources().getString(C9086R.string.string_save), new DialogInterface.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.voice.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ VoiceNotificationDialogActivity f7103b;

            {
                this.f7103b = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                switch (i) {
                    case 0:
                        VoiceNotificationDialogActivity.showConfirmSaveDialog$lambda$0(this.f7103b, dialogInterface, i5);
                        break;
                    case 1:
                        VoiceNotificationDialogActivity.showConfirmSaveDialog$lambda$1(this.f7103b, dialogInterface, i5);
                        break;
                    default:
                        VoiceNotificationDialogActivity.showConfirmSaveDialog$lambda$2(this.f7103b, dialogInterface, i5);
                        break;
                }
            }
        }).setNegativeButton(getResources().getString(C9086R.string.string_discard), new DialogInterface.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.voice.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ VoiceNotificationDialogActivity f7103b;

            {
                this.f7103b = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                switch (i2) {
                    case 0:
                        VoiceNotificationDialogActivity.showConfirmSaveDialog$lambda$0(this.f7103b, dialogInterface, i5);
                        break;
                    case 1:
                        VoiceNotificationDialogActivity.showConfirmSaveDialog$lambda$1(this.f7103b, dialogInterface, i5);
                        break;
                    default:
                        VoiceNotificationDialogActivity.showConfirmSaveDialog$lambda$2(this.f7103b, dialogInterface, i5);
                        break;
                }
            }
        }).setNeutralButton(getResources().getString(C9086R.string.string_cancel), new DialogInterface.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.voice.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ VoiceNotificationDialogActivity f7103b;

            {
                this.f7103b = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                switch (i4) {
                    case 0:
                        VoiceNotificationDialogActivity.showConfirmSaveDialog$lambda$0(this.f7103b, dialogInterface, i5);
                        break;
                    case 1:
                        VoiceNotificationDialogActivity.showConfirmSaveDialog$lambda$1(this.f7103b, dialogInterface, i5);
                        break;
                    default:
                        VoiceNotificationDialogActivity.showConfirmSaveDialog$lambda$2(this.f7103b, dialogInterface, i5);
                        break;
                }
            }
        });
        alertDialogBuilderForAppCompat.setOnDismissListener(new DialogInterfaceOnDismissListenerC0177d(this, 8));
        AlertDialog alertDialogCreate = alertDialogBuilderForAppCompat.create();
        if (Settings.Global.getInt(getContentResolver(), "font_size", 0) > 4) {
            INSTANCE.setButtonTextSize(alertDialogCreate, (int) (18.06f * getResources().getDisplayMetrics().density));
        }
        alertDialogCreate.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showConfirmSaveDialog$lambda$0(VoiceNotificationDialogActivity voiceNotificationDialogActivity, DialogInterface dialogInterface, int i) {
        VoiceManager.stopRecording();
        dialogInterface.dismiss();
        voiceNotificationDialogActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showConfirmSaveDialog$lambda$1(VoiceNotificationDialogActivity voiceNotificationDialogActivity, DialogInterface dialogInterface, int i) {
        VoiceManager.cancelRecording();
        dialogInterface.dismiss();
        voiceNotificationDialogActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showConfirmSaveDialog$lambda$2(VoiceNotificationDialogActivity voiceNotificationDialogActivity, DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        voiceNotificationDialogActivity.finish();
    }

    public final void checkDrawOverlayPermission() {
        if (Settings.canDrawOverlays(getApplicationContext())) {
            return;
        }
        startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + getPackageName())), REQUEST_CODE);
    }

    @Override // android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, @NotNull Intent data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (requestCode == REQUEST_CODE && Settings.canDrawOverlays(this)) {
            createOverlay();
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(524288);
        if (Build.VERSION.SDK_INT < 31) {
            getApplicationContext().sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        } else {
            Logger.m11003i(TAG, "onCreate ACTION_CLOSE_SYSTEM_DIALOGS not supported");
        }
        setContentView(C9086R.layout.voice_notification_dialog_activity_main);
        showConfirmSaveDialog();
        Logger.m10999d(TAG, "onCreate");
    }
}
