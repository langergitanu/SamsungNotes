package com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog;

import android.app.Activity;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p039I2.DialogInterfaceOnClickListenerC0140a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/dialog/RemoveRecordingConfirmDialog;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/dialog/Dialog;", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "presenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/dialog/DialogContract$IVoiceDialogPresenter;", "<init>", "(Landroid/app/Activity;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/dialog/DialogContract$IVoiceDialogPresenter;)V", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class RemoveRecordingConfirmDialog extends Dialog {

    @NotNull
    private static final String TAG;

    static {
        String strCreateTag = Logger.createTag("RemoveRecordingConfirmDialog");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
    }

    public RemoveRecordingConfirmDialog(@NotNull Activity activity, @NotNull final DialogContract.IVoiceDialogPresenter presenter) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        Logger.m10999d(TAG, "RemoveRecordingConfirmDialog#");
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, C9086R.style.NoteAlertDialogThemeForAppCompat);
        builder.setMessage(activity.getResources().getString(C9086R.string.voice_alertdialog_message));
        final int i = 0;
        builder.setNegativeButton(activity.getResources().getString(C9086R.string.dialog_discard), new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.m
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                switch (i) {
                    case 0:
                        RemoveRecordingConfirmDialog._init_$lambda$1(presenter, dialogInterface, i2);
                        break;
                    default:
                        RemoveRecordingConfirmDialog._init_$lambda$3(presenter, dialogInterface, i2);
                        break;
                }
            }
        });
        builder.setNeutralButton(activity.getResources().getString(C9086R.string.dialog_cancel), new DialogInterfaceOnClickListenerC0140a(20));
        final int i2 = 1;
        builder.setPositiveButton(activity.getResources().getString(C9086R.string.dialog_save), new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.m
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i22) {
                switch (i2) {
                    case 0:
                        RemoveRecordingConfirmDialog._init_$lambda$1(presenter, dialogInterface, i22);
                        break;
                    default:
                        RemoveRecordingConfirmDialog._init_$lambda$3(presenter, dialogInterface, i22);
                        break;
                }
            }
        });
        AlertDialog alertDialogCreate = builder.create();
        this.mDialog = alertDialogCreate;
        alertDialogCreate.setCanceledOnTouchOutside(true);
        this.mDialog.setOnDismissListener(getDefaultDismissListener(presenter));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(DialogContract.IVoiceDialogPresenter iVoiceDialogPresenter, DialogInterface dialogInterface, int i) {
        ComposerSA.insertLog(ComposerSAConstants.SCREEN_DIALOGS_DELETE_OBJECT, ComposerSAConstants.EVENT_DIALOGS_DELETE_OBJECT_DELETE);
        new SenlThreadFactory(TAG).newThread(new RunnableC10240j(iVoiceDialogPresenter, 1)).start();
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$2(DialogInterface dialogInterface, int i) {
        ComposerSA.insertLog(ComposerSAConstants.SCREEN_DIALOGS_DELETE_OBJECT, ComposerSAConstants.EVENT_DIALOGS_DELETE_OBJECT_CANCLE);
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$3(DialogContract.IVoiceDialogPresenter iVoiceDialogPresenter, DialogInterface dialogInterface, int i) {
        iVoiceDialogPresenter.stopRecording();
        dialogInterface.dismiss();
    }
}
