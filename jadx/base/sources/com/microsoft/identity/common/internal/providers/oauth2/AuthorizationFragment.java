package com.microsoft.identity.common.internal.providers.oauth2;

import android.os.Bundle;
import android.view.View;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.AbstractC0622a;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.microsoft.identity.common.internal.telemetry.events.UiEndEvent;
import com.microsoft.identity.common.java.AuthenticationConstants;
import com.microsoft.identity.common.java.logging.DiagnosticContext;
import com.microsoft.identity.common.java.logging.RequestContext;
import com.microsoft.identity.common.java.providers.RawAuthorizationResult;
import com.microsoft.identity.common.java.telemetry.Telemetry;
import com.microsoft.identity.common.java.util.ported.LocalBroadcaster;
import com.microsoft.identity.common.java.util.ported.PropertyBag;
import com.microsoft.identity.common.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AuthorizationFragment extends Fragment {
    private static final String TAG = "AuthorizationFragment";
    protected boolean mAuthResultSent = false;
    private final LocalBroadcaster.IReceiverCallback mCancelRequestReceiver = new LocalBroadcaster.IReceiverCallback() { // from class: com.microsoft.identity.common.internal.providers.oauth2.AuthorizationFragment.1
        @Override // com.microsoft.identity.common.java.util.ported.LocalBroadcaster.IReceiverCallback
        public void onReceive(@NonNull PropertyBag propertyBag) {
            AuthorizationFragment.this.cancelAuthorization(((Boolean) propertyBag.getOrDefault(AuthenticationConstants.LocalBroadcasterAliases.CANCEL_AUTHORIZATION_REQUEST, Boolean.FALSE)).booleanValue());
        }
    };
    private Bundle mInstanceState;

    private static void setDiagnosticContextForNewThread(String str) {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":setDiagnosticContextForAuthorizationActivity", new StringBuilder());
        RequestContext requestContext = new RequestContext();
        requestContext.put("correlation_id", str);
        DiagnosticContext.INSTANCE.setRequestContext(requestContext);
        Logger.verbose(strM1170p, "Initializing diagnostic context for AuthorizationActivity");
    }

    public void cancelAuthorization(boolean z) {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":cancelAuthorization", new StringBuilder());
        if (z) {
            Logger.info(strM1170p, "Received Authorization flow cancelled by the user");
            sendResult(RawAuthorizationResult.ResultCode.CANCELLED);
        } else {
            Logger.info(strM1170p, "Received Authorization flow cancel request from SDK");
            sendResult(RawAuthorizationResult.ResultCode.SDK_CANCELLED);
        }
        Telemetry.emit(new UiEndEvent().isUserCancelled());
        finish();
    }

    public void extractState(@NonNull Bundle bundle) {
        setDiagnosticContextForNewThread(bundle.getString("correlation_id"));
    }

    public void finish() {
        LocalBroadcaster.INSTANCE.unregisterCallback(AuthenticationConstants.LocalBroadcasterAliases.CANCEL_AUTHORIZATION_REQUEST);
        FragmentActivity activity = getActivity();
        if (activity instanceof AuthorizationActivity) {
            activity.finish();
            return;
        }
        try {
            FragmentManager fragmentManager = getFragmentManager();
            if (fragmentManager != null) {
                fragmentManager.beginTransaction().setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE).remove(this).commitNow();
            }
        } catch (Exception e) {
            Logger.error(TAG + "#finish", "Logged as error to capture 'cause'; Exception occurred when removing ourselves from provided FragmentManager", e);
        }
    }

    public void handleBackButtonPressed() {
        cancelAuthorization(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":onCreate", new StringBuilder());
        super.onCreate(bundle);
        LocalBroadcaster.INSTANCE.registerCallback(AuthenticationConstants.LocalBroadcasterAliases.CANCEL_AUTHORIZATION_REQUEST, this.mCancelRequestReceiver);
        if (bundle == null && this.mInstanceState == null) {
            Logger.warn(strM1170p, "No stored state. Unable to handle response");
            finish();
        } else if (bundle == null) {
            Logger.verbose(strM1170p, "Extract state from the intent bundle.");
            extractState(this.mInstanceState);
        } else {
            Logger.verbose(strM1170p, "Extract state from the saved bundle.");
            extractState(bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        String str = TAG + ":onDestroy";
        Logger.info(str, "");
        if (!this.mAuthResultSent) {
            Logger.info(str, "Hosting Activity is destroyed before Auth request is completed, sending request cancel");
            Telemetry.emit(new UiEndEvent().isUserCancelled());
            sendResult(RawAuthorizationResult.ResultCode.SDK_CANCELLED);
        }
        LocalBroadcaster.INSTANCE.unregisterCallback(AuthenticationConstants.LocalBroadcasterAliases.CANCEL_AUTHORIZATION_REQUEST);
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":onStop", new StringBuilder());
        FragmentActivity activity = getActivity();
        if (!this.mAuthResultSent && (activity == null || activity.isFinishing())) {
            Logger.info(strM1170p, "Hosting Activity is destroyed before Auth request is completed, sending request cancel");
            Telemetry.emit(new UiEndEvent().isUserCancelled());
            sendResult(RawAuthorizationResult.ResultCode.SDK_CANCELLED);
        }
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) { // from class: com.microsoft.identity.common.internal.providers.oauth2.AuthorizationFragment.2
            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                AuthorizationFragment.this.handleBackButtonPressed();
            }
        });
    }

    public void sendResult(RawAuthorizationResult.ResultCode resultCode) {
        sendResult(RawAuthorizationResult.fromResultCode(resultCode));
    }

    public void setInstanceState(@NonNull Bundle bundle) {
        this.mInstanceState = bundle;
    }

    public void sendResult(@NonNull RawAuthorizationResult rawAuthorizationResult) {
        Logger.info(AbstractC0622a.m1170p(TAG, ":sendResult", new StringBuilder()), "Sending result from Authorization Activity, resultCode: " + rawAuthorizationResult.getResultCode());
        PropertyBag propertyBag = RawAuthorizationResult.toPropertyBag(rawAuthorizationResult);
        propertyBag.put(AuthenticationConstants.LocalBroadcasterFields.REQUEST_CODE, 1001);
        LocalBroadcaster.INSTANCE.broadcast(AuthenticationConstants.LocalBroadcasterAliases.RETURN_AUTHORIZATION_REQUEST_RESULT, propertyBag);
        this.mAuthResultSent = true;
    }
}
