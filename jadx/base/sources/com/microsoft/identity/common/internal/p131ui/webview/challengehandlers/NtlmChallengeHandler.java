package com.microsoft.identity.common.internal.p131ui.webview.challengehandlers;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.C6228R;
import com.microsoft.identity.common.java.p132ui.webview.authorization.IAuthorizationCompletionCallback;
import com.microsoft.identity.common.java.providers.RawAuthorizationResult;
import com.microsoft.identity.common.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final class NtlmChallengeHandler implements IChallengeHandler<NtlmChallenge, Void> {
    private static final String TAG = "NtlmChallengeHandler";
    private final Activity mActivity;
    private final IAuthorizationCompletionCallback mChallengeCallback;

    public NtlmChallengeHandler(Activity activity, IAuthorizationCompletionCallback iAuthorizationCompletionCallback) {
        this.mActivity = activity;
        this.mChallengeCallback = iAuthorizationCompletionCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelRequest() {
        Logger.info(TAG + ":cancelRequest", "Sending intent to cancel authentication activity");
        this.mChallengeCallback.onChallengeResponseReceived(RawAuthorizationResult.fromResultCode(RawAuthorizationResult.ResultCode.CANCELLED));
    }

    private void showHttpAuthDialog(final NtlmChallenge ntlmChallenge) {
        final String strM1170p = AbstractC0622a.m1170p(TAG, ":showHttpAuthDialog", new StringBuilder());
        View viewInflate = LayoutInflater.from(this.mActivity).inflate(this.mActivity.getResources().getLayout(C6228R.layout.http_auth_dialog), (ViewGroup) null);
        final EditText editText = (EditText) viewInflate.findViewById(C6228R.id.editUserName);
        final EditText editText2 = (EditText) viewInflate.findViewById(C6228R.id.editPassword);
        new AlertDialog.Builder(this.mActivity).setTitle(this.mActivity.getText(C6228R.string.http_auth_dialog_title).toString()).setView(viewInflate).setPositiveButton(C6228R.string.http_auth_dialog_login, new DialogInterface.OnClickListener() { // from class: com.microsoft.identity.common.internal.ui.webview.challengehandlers.NtlmChallengeHandler.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Logger.info(strM1170p, "Proceeding with user supplied username and password.");
                ntlmChallenge.getHandler().proceed(editText.getText().toString(), editText2.getText().toString());
            }
        }).setNegativeButton(C6228R.string.http_auth_dialog_cancel, new DialogInterface.OnClickListener() { // from class: com.microsoft.identity.common.internal.ui.webview.challengehandlers.NtlmChallengeHandler.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                ntlmChallenge.getHandler().cancel();
                NtlmChallengeHandler.this.cancelRequest();
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.microsoft.identity.common.internal.ui.webview.challengehandlers.NtlmChallengeHandler.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                ntlmChallenge.getHandler().cancel();
                NtlmChallengeHandler.this.cancelRequest();
            }
        }).create().show();
    }

    @Override // com.microsoft.identity.common.internal.p131ui.webview.challengehandlers.IChallengeHandler
    public Void processChallenge(NtlmChallenge ntlmChallenge) {
        showHttpAuthDialog(ntlmChallenge);
        return null;
    }
}
