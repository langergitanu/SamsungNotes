package com.samsung.android.support.senl.p148nt.app.lock.view.verify;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.lock.utils.LockBackupUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class VerifyBackupPasswordView extends VerifyPasswordView {
    @Override // com.samsung.android.support.senl.p148nt.app.lock.view.verify.VerifyPasswordView, com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsPasswordView
    public void initGuideText() {
        if (this.mGuideTextView == null) {
            return;
        }
        if (this.mGuideInitValue.length() <= 0) {
            this.mGuideTextView.setText(C8003R.string.enter_old_passwd);
        } else {
            this.mGuideTextView.setText(this.mGuideInitValue);
            this.mGuideInitValue = "";
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.view.verify.VerifyPasswordView, com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsPasswordView, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View viewOnCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        if (viewOnCreateView == null) {
            return getView();
        }
        this.mUseBiometricsCheckBox.setVisibility(8);
        ((TextView) viewOnCreateView.findViewById(C8003R.id.reset_password)).setVisibility(8);
        this.mPresenter.setPasswordToBeCompared(LockBackupUtil.getPrefPasswordEncryptedHashBackup(getContext()), LockBackupUtil.getPrefPasswordEncryptedSaltBackup(getContext()));
        this.mPresenter.setOldPasswordVerificationMode(true);
        return viewOnCreateView;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.view.verify.VerifyPasswordView, com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsPasswordView
    public void updateDefaultGuideText() {
        TextView textView = this.mGuideTextView;
        if (textView == null) {
            return;
        }
        textView.setText(getResources().getString(C8003R.string.enter_old_passwd));
    }
}
