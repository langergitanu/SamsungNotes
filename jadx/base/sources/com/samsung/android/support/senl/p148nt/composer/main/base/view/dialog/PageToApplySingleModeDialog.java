package com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog;

import android.animation.StateListAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertDialog;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.winset.view.common.ImageRadioButton;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.constants.ChangeTemplateConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.common.BaseTemplateStyleFragment;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PageToApplySingleModeDialog {
    protected AlertDialog mAlertDialog;
    private BaseTemplateStyleFragment.PageToApplyCallback mCallback;
    protected Context mContext;
    protected View mDialogView;
    protected int mSelectedItem = -1;
    protected ImageRadioButton mCurrentPageBtn = null;
    protected ImageRadioButton mAllPagesBtn = null;
    private Boolean mIsDismissWithClick = Boolean.FALSE;
    private final DialogInterface.OnClickListener mPositiveClickListener = new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.PageToApplySingleModeDialog.1
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            PageToApplySingleModeDialog.this.onPositiveButtonClick();
        }
    };

    public PageToApplySingleModeDialog(Context context) {
        this.mContext = context;
    }

    private void initButtons() {
        int i = this.mSelectedItem;
        if (i < 0) {
            setSelectedItem(4);
        } else {
            setSelectedItem(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$show$0(DialogInterface dialogInterface) {
        onShowDialog();
        if (this.mIsDismissWithClick.booleanValue()) {
            return;
        }
        setClickWithoutDismissListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPositiveButtonClick() {
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.Menu;
        if (UserInputSkipper.isValidEvent(tag)) {
            UserInputSkipper.setHoldingEventTime(300L, tag);
            sendResult();
        }
    }

    private void setRecoilStateListAnimator(View view) {
        StateListAnimator recoilStateListAnimator = ViewCompat.getInstance().getRecoilStateListAnimator(view.getContext(), 0);
        if (recoilStateListAnimator != null) {
            view.setStateListAnimator(recoilStateListAnimator);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSelectedItem(int i) {
        if (i != 4) {
            this.mCurrentPageBtn.setChecked(false);
            this.mAllPagesBtn.setChecked(true);
        } else {
            this.mCurrentPageBtn.setChecked(true);
            this.mAllPagesBtn.setChecked(false);
        }
        this.mSelectedItem = i;
    }

    public void onShowDialog() {
        initButtons();
    }

    public void sendResult() {
        Intent intent = new Intent();
        intent.putExtra(ChangeTemplateConstants.KEY_PAGE_TO_APPLY_SELECTED_OPTION, this.mSelectedItem);
        this.mCallback.onResult(intent);
        this.mAlertDialog.dismiss();
    }

    public void setCallback(BaseTemplateStyleFragment.PageToApplyCallback pageToApplyCallback) {
        this.mCallback = pageToApplyCallback;
    }

    public void setClickWithoutDismissListener() {
        this.mAlertDialog.getButton(-1).setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.PageToApplySingleModeDialog.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PageToApplySingleModeDialog.this.mAlertDialog.dismiss();
                PageToApplySingleModeDialog.this.onPositiveButtonClick();
            }
        });
    }

    public void show() {
        this.mDialogView = LayoutInflater.from(this.mContext).inflate(C9086R.layout.comp_change_template_apply_to_single_page, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this.mContext).setView(this.mDialogView).setCancelable(true).setTitle(C9086R.string.change_template_apply_template_to).setPositiveButton(C9086R.string.change_template_apply, this.mPositiveClickListener).create();
        this.mAlertDialog = alertDialogCreate;
        alertDialogCreate.setOnShowListener(new DialogInterfaceOnShowListenerC10242l(this, 0));
        ImageRadioButton imageRadioButton = (ImageRadioButton) this.mDialogView.findViewById(C9086R.id.apply_template_current_page);
        this.mCurrentPageBtn = imageRadioButton;
        imageRadioButton.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.PageToApplySingleModeDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PageToApplySingleModeDialog.this.setSelectedItem(4);
            }
        });
        ImageRadioButton imageRadioButton2 = (ImageRadioButton) this.mDialogView.findViewById(C9086R.id.apply_template_all_pages);
        this.mAllPagesBtn = imageRadioButton2;
        imageRadioButton2.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.PageToApplySingleModeDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PageToApplySingleModeDialog.this.setSelectedItem(5);
            }
        });
        setRecoilStateListAnimator(this.mCurrentPageBtn);
        setRecoilStateListAnimator(this.mAllPagesBtn);
        this.mAlertDialog.show();
    }
}
