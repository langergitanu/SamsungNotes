package com.microsoft.identity.client;

import android.app.Activity;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.microsoft.identity.client.TokenParameters;
import com.microsoft.identity.common.java.p132ui.PreferredAuthMethod;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AcquireTokenParameters extends TokenParameters {
    private Activity mActivity;
    private AuthenticationCallback mCallback;
    private List<Map.Entry<String, String>> mExtraQueryStringParameters;
    private List<String> mExtraScopesToConsent;
    private Fragment mFragment;
    private String mLoginHint;
    private PreferredAuthMethod mPreferredAuthMethod;
    private Prompt mPrompt;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Builder extends TokenParameters.Builder<Builder> {
        private Activity mActivity;
        private AuthenticationCallback mCallback;
        private List<Map.Entry<String, String>> mExtraQueryStringParameters;
        private List<String> mExtraScopesToConsent;
        private Fragment mFragment;
        private String mLoginHint;
        private PreferredAuthMethod mPreferredAuthMethod;
        private Prompt mPrompt;

        @Override // com.microsoft.identity.client.TokenParameters.Builder
        public Builder self() {
            return this;
        }

        public Builder startAuthorizationFromActivity(Activity activity) {
            this.mActivity = activity;
            return self();
        }

        public Builder withAuthorizationQueryStringParameters(List<Map.Entry<String, String>> list) {
            this.mExtraQueryStringParameters = list;
            return self();
        }

        public Builder withCallback(AuthenticationCallback authenticationCallback) {
            this.mCallback = authenticationCallback;
            return self();
        }

        public Builder withFragment(Fragment fragment) {
            this.mFragment = fragment;
            return self();
        }

        public Builder withLoginHint(String str) {
            this.mLoginHint = str;
            return self();
        }

        public Builder withOtherScopesToAuthorize(List<String> list) {
            this.mExtraScopesToConsent = list;
            return self();
        }

        @Nullable
        public Builder withPreferredAuthMethod(PreferredAuthMethod preferredAuthMethod) {
            this.mPreferredAuthMethod = preferredAuthMethod;
            return self();
        }

        public Builder withPrompt(Prompt prompt) {
            this.mPrompt = prompt;
            return self();
        }

        @Override // com.microsoft.identity.client.TokenParameters.Builder
        public AcquireTokenParameters build() {
            return new AcquireTokenParameters(this);
        }
    }

    public AcquireTokenParameters(Builder builder) {
        super(builder);
        this.mActivity = builder.mActivity;
        this.mFragment = builder.mFragment;
        this.mLoginHint = builder.mLoginHint;
        this.mPreferredAuthMethod = builder.mPreferredAuthMethod;
        this.mPrompt = builder.mPrompt;
        this.mExtraScopesToConsent = builder.mExtraScopesToConsent;
        this.mExtraQueryStringParameters = builder.mExtraQueryStringParameters;
        this.mCallback = builder.mCallback;
    }

    public Activity getActivity() {
        return this.mActivity;
    }

    public AuthenticationCallback getCallback() {
        return this.mCallback;
    }

    public List<Map.Entry<String, String>> getExtraQueryStringParameters() {
        return this.mExtraQueryStringParameters;
    }

    public List<String> getExtraScopesToConsent() {
        return this.mExtraScopesToConsent;
    }

    public Fragment getFragment() {
        return this.mFragment;
    }

    public String getLoginHint() {
        return this.mLoginHint;
    }

    @Nullable
    public PreferredAuthMethod getPreferredAuthMethod() {
        return this.mPreferredAuthMethod;
    }

    public Prompt getPrompt() {
        return this.mPrompt;
    }

    public void setLoginHint(String str) {
        this.mLoginHint = str;
    }
}
