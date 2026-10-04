package com.samsung.android.support.senl.p148nt.app.lock.view.verify;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import com.samsung.android.sdk.pen.setting.colorpalette.ViewOnClickListenerC7538b;
import com.samsung.android.sdk.pen.setting.handwriting.RunnableC7599e;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.lock.presenter.verify.IVerifyIrisContract;
import com.samsung.android.support.senl.p148nt.app.lock.presenter.verify.VerifyIrisPresenter;
import com.samsung.android.support.senl.p148nt.app.lock.utils.LockDialogUtils;
import com.samsung.android.support.senl.p148nt.app.lock.utils.LockLogger;
import com.samsung.android.support.senl.p148nt.app.lock.utils.LockToastUtils;
import com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsBaseBiometricView;
import com.samsung.android.support.senl.p148nt.base.common.constants.LockConstants;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.winset.view.SprImageView;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class VerifyIrisView extends AbsBaseBiometricView implements IVerifyIrisContract.IView {
    private static final String TAG = LockLogger.createTag("VerifyIrisView");
    private TextView mGuideTextView;
    private final IVerifyIrisContract.IPresenter mPresenter;

    public VerifyIrisView() {
        this.mPresenter = new VerifyIrisPresenter(this);
    }

    private View createDexView(LayoutInflater layoutInflater) {
        View viewInflate = layoutInflater.inflate(C8003R.layout.lock_dex_dialog_view, (ViewGroup) null);
        ((SprImageView) viewInflate.findViewById(C8003R.id.iris_icon)).setVisibility(0);
        TextView textView = (TextView) viewInflate.findViewById(C8003R.id.dex_guide_text);
        this.mGuideTextView = textView;
        textView.setText(C8003R.string.lock_dex_use_fingerprint);
        ((Button) viewInflate.findViewById(C8003R.id.use_password)).setOnClickListener(new ViewOnClickListenerC7538b(this, 25));
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createDexView$0(View view) {
        this.mPresenter.cancelAuthenticate();
        CommonSamsungAnalytics.insertLog(LockConstants.SA_LOG_VERIFY_IRIS_SCREEN, "3221");
        changeToPasswordVerification(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showRetryDialog$1(Context context) {
        this.mPresenter.authenticate(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showRetryDialog$2(Handler handler, Context context, DialogInterface dialogInterface, int i) {
        handler.post(new RunnableC8136a(context, 1, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showRetryDialog$3(Handler handler, DialogInterface dialogInterface, int i) {
        handler.post(new RunnableC7599e(this, 19));
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsBaseBiometricView
    public void authenticate() {
        this.mPresenter.authenticate(getContext());
    }

    @Override // com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsBaseBiometricView
    public void cancelAuthenticate() {
        this.mPresenter.cancelAuthenticate();
    }

    @Override // com.samsung.android.support.senl.nt.app.lock.presenter.verify.IVerifyIrisContract.IView
    public View getPreView() {
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (getActivity() != null) {
            getActivity().setRequestedOrientation(1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (DesktopModeCompat.INSTANCE.getInstance().isDexMode(getContext())) {
            LockLogger.m7356d(TAG, "createDexView");
            return createDexView(layoutInflater);
        }
        LockLogger.m7356d(TAG, "emptyView");
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (getActivity() != null) {
            getActivity().setRequestedOrientation(-1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mPresenter.cancelAuthenticate();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        LockLogger.m7356d(TAG, "onResume");
        super.onResume();
        if (!isBlockedByMultiwindow()) {
            this.mPresenter.onResume(getContext());
        } else {
            LockToastUtils.showMultiWindowImpossibleToast(getContext());
            exitMultiWindow();
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.lock.presenter.verify.IVerifyIrisContract.IView
    public void setGuideText(CharSequence charSequence) {
        TextView textView = this.mGuideTextView;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.lock.presenter.verify.IVerifyIrisContract.IView
    public void showRetryDialog(CharSequence charSequence) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        AlertDialog alertDialog = this.mRetryDialog;
        if (alertDialog == null || !alertDialog.isShowing()) {
            Handler handler = new Handler();
            this.mRetryDialog = LockDialogUtils.showRetryIrisDialogWithError(context, charSequence, new DialogInterfaceOnClickListenerC8137b(this, 0, handler, context), new DialogInterfaceOnClickListenerC8139d(this, handler, 2));
        }
    }

    public VerifyIrisView(AbsBaseBiometricView.PASSWORDTYPE passwordtype) {
        super(passwordtype);
        this.mPresenter = new VerifyIrisPresenter(this);
    }

    @Override // com.samsung.android.support.senl.nt.app.lock.presenter.verify.IVerifyIrisContract.IView
    public void showRetryDialog(int i) {
        if (getContext() == null) {
            return;
        }
        showRetryDialog(getContext().getResources().getString(i));
    }
}
