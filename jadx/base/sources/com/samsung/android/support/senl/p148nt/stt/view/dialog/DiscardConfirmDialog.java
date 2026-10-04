package com.samsung.android.support.senl.p148nt.stt.view.dialog;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.samsung.android.support.senl.p148nt.base.winset.util.ButtonShapeUtil;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.stt.C11493R;
import com.samsung.android.support.senl.p148nt.stt.common.Logger;
import com.samsung.android.support.senl.p148nt.stt.view.dialog.DialogContract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0014J\b\u0010\r\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\nH\u0002R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/view/dialog/DiscardConfirmDialog;", "Lcom/samsung/android/support/senl/nt/stt/view/dialog/AbsSTTDialog;", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "presenter", "Lcom/samsung/android/support/senl/nt/stt/view/dialog/DialogContract$IDiscardConfirmDialogPresenter;", "<init>", "(Landroid/app/Activity;Lcom/samsung/android/support/senl/nt/stt/view/dialog/DialogContract$IDiscardConfirmDialogPresenter;)V", "mPresenter", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setMessage", "setButtons", "Companion", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DiscardConfirmDialog extends AbsSTTDialog {

    @NotNull
    private static final String TAG = "DiscardConfirmDialog";

    @NotNull
    private final DialogContract.IDiscardConfirmDialogPresenter mPresenter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiscardConfirmDialog(@Nullable Activity activity, @NotNull DialogContract.IDiscardConfirmDialogPresenter presenter) {
        super(activity);
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        Intrinsics.checkNotNull(activity);
        Logger.m12710d(TAG, "DiscardConfirmDialog#");
        this.mPresenter = presenter;
    }

    private final void setButtons() {
        Logger.m12710d(TAG, "setButtons#");
        View viewFindViewById = findViewById(C11493R.id.neutralButton);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.Button");
        setMNeutralButton((Button) viewFindViewById);
        View viewFindViewById2 = findViewById(C11493R.id.negativeButton);
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.Button");
        setMNegativeButton((Button) viewFindViewById2);
        View viewFindViewById3 = findViewById(C11493R.id.positiveButton);
        Intrinsics.checkNotNull(viewFindViewById3, "null cannot be cast to non-null type android.widget.Button");
        setMPositiveButton((Button) viewFindViewById3);
        Button mNeutralButton = getMNeutralButton();
        Intrinsics.checkNotNull(mNeutralButton);
        mNeutralButton.setText(getMResources().getString(C11493R.string.base_string_cancel_type3));
        Button mNeutralButton2 = getMNeutralButton();
        Intrinsics.checkNotNull(mNeutralButton2);
        final int i = 0;
        mNeutralButton2.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.stt.view.dialog.b

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ DiscardConfirmDialog f7927b;

            {
                this.f7927b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i) {
                    case 0:
                        DiscardConfirmDialog.setButtons$lambda$0(this.f7927b, view);
                        break;
                    case 1:
                        DiscardConfirmDialog.setButtons$lambda$1(this.f7927b, view);
                        break;
                    default:
                        DiscardConfirmDialog.setButtons$lambda$2(this.f7927b, view);
                        break;
                }
            }
        });
        Button mNeutralButton3 = getMNeutralButton();
        int i2 = C11493R.drawable.stt_rectangle_button_ripple_effect_show_button_shape;
        ButtonShapeUtil.changeCustomButtonBackgroundUnchangedTextColor(mNeutralButton3, i2, i2);
        Button mNegativeButton = getMNegativeButton();
        Intrinsics.checkNotNull(mNegativeButton);
        mNegativeButton.setText(getMResources().getString(C11493R.string.string_discard));
        Button mNegativeButton2 = getMNegativeButton();
        Intrinsics.checkNotNull(mNegativeButton2);
        final int i4 = 1;
        mNegativeButton2.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.stt.view.dialog.b

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ DiscardConfirmDialog f7927b;

            {
                this.f7927b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i4) {
                    case 0:
                        DiscardConfirmDialog.setButtons$lambda$0(this.f7927b, view);
                        break;
                    case 1:
                        DiscardConfirmDialog.setButtons$lambda$1(this.f7927b, view);
                        break;
                    default:
                        DiscardConfirmDialog.setButtons$lambda$2(this.f7927b, view);
                        break;
                }
            }
        });
        Button mNegativeButton3 = getMNegativeButton();
        int i5 = C11493R.drawable.stt_rectangle_button_ripple_effect_show_button_shape;
        ButtonShapeUtil.changeCustomButtonBackgroundUnchangedTextColor(mNegativeButton3, i5, i5);
        Button mPositiveButton = getMPositiveButton();
        Intrinsics.checkNotNull(mPositiveButton);
        mPositiveButton.setText(getMResources().getString(C11493R.string.base_string_save_type1));
        Button mPositiveButton2 = getMPositiveButton();
        Intrinsics.checkNotNull(mPositiveButton2);
        final int i6 = 2;
        mPositiveButton2.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.stt.view.dialog.b

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ DiscardConfirmDialog f7927b;

            {
                this.f7927b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i6) {
                    case 0:
                        DiscardConfirmDialog.setButtons$lambda$0(this.f7927b, view);
                        break;
                    case 1:
                        DiscardConfirmDialog.setButtons$lambda$1(this.f7927b, view);
                        break;
                    default:
                        DiscardConfirmDialog.setButtons$lambda$2(this.f7927b, view);
                        break;
                }
            }
        });
        Button mPositiveButton3 = getMPositiveButton();
        int i7 = C11493R.drawable.stt_rectangle_button_ripple_effect_show_button_shape;
        ButtonShapeUtil.changeCustomButtonBackgroundUnchangedTextColor(mPositiveButton3, i7, i7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setButtons$lambda$0(DiscardConfirmDialog discardConfirmDialog, View view) {
        discardConfirmDialog.mPresenter.cancel();
        discardConfirmDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setButtons$lambda$1(DiscardConfirmDialog discardConfirmDialog, View view) {
        Logger.m12710d(TAG, "discard#");
        discardConfirmDialog.mPresenter.discard();
        discardConfirmDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setButtons$lambda$2(DiscardConfirmDialog discardConfirmDialog, View view) {
        Logger.m12710d(TAG, "save#");
        discardConfirmDialog.mPresenter.save();
        discardConfirmDialog.dismiss();
    }

    private final void setMessage() {
        Logger.m12710d(TAG, "setMessage#");
        View viewFindViewById = findViewById(C11493R.id.message);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.TextView");
        setMMessage((TextView) viewFindViewById);
        TextView mMessage = getMMessage();
        Intrinsics.checkNotNull(mMessage);
        mMessage.setText(getMResources().getString(C11493R.string.base_string_popup_ask_save));
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.view.dialog.AbsSTTDialog, android.app.Dialog
    public void onCreate(@NotNull Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(savedInstanceState, "savedInstanceState");
        Logger.m12710d(TAG, "onCreate#");
        setContentView(C11493R.layout.dialog_layout);
        super.onCreate(savedInstanceState);
        setMessage();
        setButtons();
    }
}
