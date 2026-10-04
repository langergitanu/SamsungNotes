package com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.dialog;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.samsung.android.support.senl.p148nt.base.winset.util.ButtonShapeUtil;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.p164sa.SAManager;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.dialog.SaveNoteDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\b\u0010\r\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\nH\u0002R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/dialog/SaveNoteDialog;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/dialog/AbsDialog;", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "presenter", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/dialog/DialogContract$ISaveNoteDialogPresenter;", "<init>", "(Landroid/app/Activity;Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/dialog/DialogContract$ISaveNoteDialogPresenter;)V", "mPresenter", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setMessage", "setButtons", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SaveNoteDialog extends AbsDialog {

    @NotNull
    private static final String TAG = SOLogger.createTag("SaveNoteDialog");

    @NotNull
    private final DialogContract.ISaveNoteDialogPresenter mPresenter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SaveNoteDialog(@NotNull Activity activity, @NotNull DialogContract.ISaveNoteDialogPresenter presenter) {
        super(activity);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        SOLogger.INSTANCE.SOLoggerD(TAG, "SaveNoteDialog#");
        this.mPresenter = presenter;
    }

    private final void setButtons() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "setButtons#");
        setMNeutralButton((Button) findViewById(C9086R.id.neutralButton));
        setMNegativeButton((Button) findViewById(C9086R.id.negativeButton));
        setMPositiveButton((Button) findViewById(C9086R.id.positiveButton));
        Button mNeutralButton = getMNeutralButton();
        if (mNeutralButton != null) {
            mNeutralButton.setText(getMResources().getString(C9086R.string.dialog_cancel));
        }
        Button mNeutralButton2 = getMNeutralButton();
        if (mNeutralButton2 != null) {
            final int i = 0;
            mNeutralButton2.setOnClickListener(new View.OnClickListener(this) { // from class: S3.b

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ SaveNoteDialog f736b;

                {
                    this.f736b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i) {
                        case 0:
                            SaveNoteDialog.setButtons$lambda$0(this.f736b, view);
                            break;
                        case 1:
                            SaveNoteDialog.setButtons$lambda$1(this.f736b, view);
                            break;
                        default:
                            SaveNoteDialog.setButtons$lambda$2(this.f736b, view);
                            break;
                    }
                }
            });
        }
        Button mNeutralButton3 = getMNeutralButton();
        int i2 = C9086R.drawable.screenoff_rectangle_button_ripple_effect_show_button_shape;
        ButtonShapeUtil.changeCustomButtonBackgroundUnchangedTextColor(mNeutralButton3, i2, i2);
        Button mNegativeButton = getMNegativeButton();
        if (mNegativeButton != null) {
            mNegativeButton.setText(getMResources().getString(C9086R.string.dialog_discard));
        }
        Button mNegativeButton2 = getMNegativeButton();
        if (mNegativeButton2 != null) {
            final int i4 = 1;
            mNegativeButton2.setOnClickListener(new View.OnClickListener(this) { // from class: S3.b

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ SaveNoteDialog f736b;

                {
                    this.f736b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i4) {
                        case 0:
                            SaveNoteDialog.setButtons$lambda$0(this.f736b, view);
                            break;
                        case 1:
                            SaveNoteDialog.setButtons$lambda$1(this.f736b, view);
                            break;
                        default:
                            SaveNoteDialog.setButtons$lambda$2(this.f736b, view);
                            break;
                    }
                }
            });
        }
        Button mNegativeButton3 = getMNegativeButton();
        int i5 = C9086R.drawable.screenoff_rectangle_button_ripple_effect_show_button_shape;
        ButtonShapeUtil.changeCustomButtonBackgroundUnchangedTextColor(mNegativeButton3, i5, i5);
        Button mPositiveButton = getMPositiveButton();
        if (mPositiveButton != null) {
            mPositiveButton.setText(getMResources().getString(C9086R.string.dialog_save));
        }
        Button mPositiveButton2 = getMPositiveButton();
        if (mPositiveButton2 != null) {
            final int i6 = 2;
            mPositiveButton2.setOnClickListener(new View.OnClickListener(this) { // from class: S3.b

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ SaveNoteDialog f736b;

                {
                    this.f736b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i6) {
                        case 0:
                            SaveNoteDialog.setButtons$lambda$0(this.f736b, view);
                            break;
                        case 1:
                            SaveNoteDialog.setButtons$lambda$1(this.f736b, view);
                            break;
                        default:
                            SaveNoteDialog.setButtons$lambda$2(this.f736b, view);
                            break;
                    }
                }
            });
        }
        Button mPositiveButton3 = getMPositiveButton();
        int i7 = C9086R.drawable.screenoff_rectangle_button_ripple_effect_show_button_shape;
        ButtonShapeUtil.changeCustomButtonBackgroundUnchangedTextColor(mPositiveButton3, i7, i7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setButtons$lambda$0(SaveNoteDialog saveNoteDialog, View view) {
        SOLogger.INSTANCE.SOLoggerD(TAG, "cancel#");
        SAManager.INSTANCE.getINSTANCE().onSaveNoteDialogCancel();
        saveNoteDialog.mPresenter.cancel();
        saveNoteDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setButtons$lambda$1(SaveNoteDialog saveNoteDialog, View view) {
        SOLogger.INSTANCE.SOLoggerD(TAG, "discard#");
        SAManager.Companion companion = SAManager.INSTANCE;
        companion.getINSTANCE().onSaveNoteDialogDiscard();
        companion.getINSTANCE().setExitReason(3);
        saveNoteDialog.mPresenter.discard();
        saveNoteDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setButtons$lambda$2(SaveNoteDialog saveNoteDialog, View view) {
        SOLogger.INSTANCE.SOLoggerD(TAG, "save#");
        SAManager.Companion companion = SAManager.INSTANCE;
        companion.getINSTANCE().onSaveNoteDialogSave();
        companion.getINSTANCE().setExitReason(4);
        saveNoteDialog.mPresenter.save();
        saveNoteDialog.dismiss();
    }

    private final void setMessage() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "setMessage#");
        setMMessage((TextView) findViewById(C9086R.id.message));
        TextView mMessage = getMMessage();
        if (mMessage != null) {
            mMessage.setText(getMResources().getString(C9086R.string.base_string_popup_ask_save));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.dialog.AbsDialog, android.app.Dialog
    public void onCreate(@Nullable Bundle savedInstanceState) {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onCreate#");
        setContentView(C9086R.layout.screenoff_dialog_layout);
        super.onCreate(savedInstanceState);
        setMessage();
        setButtons();
    }
}
