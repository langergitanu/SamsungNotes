package com.microsoft.identity.client;

import android.app.Activity;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class SignInParameters {

    @NonNull
    private Activity activity;

    @NonNull
    private AuthenticationCallback callback;

    @Nullable
    private String loginHint;

    @Nullable
    private Prompt prompt;

    @NonNull
    private List<String> scopes;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SignInParametersBuilder {
        private Activity activity;
        private AuthenticationCallback callback;
        private String loginHint;
        private Prompt prompt;
        private ArrayList<String> scopes;

        public SignInParameters build() {
            ArrayList<String> arrayList = this.scopes;
            int size = arrayList == null ? 0 : arrayList.size();
            return new SignInParameters(this.activity, this.loginHint, size != 0 ? size != 1 ? Collections.unmodifiableList(new ArrayList(this.scopes)) : Collections.singletonList(this.scopes.get(0)) : Collections.EMPTY_LIST, this.prompt, this.callback);
        }

        public SignInParametersBuilder clearScopes() {
            ArrayList<String> arrayList = this.scopes;
            if (arrayList != null) {
                arrayList.clear();
            }
            return this;
        }

        public String toString() {
            return "SignInParameters.SignInParametersBuilder(activity=" + this.activity + ", loginHint=" + this.loginHint + ", scopes=" + this.scopes + ", prompt=" + this.prompt + ", callback=" + this.callback + ")";
        }

        public SignInParametersBuilder withActivity(@NonNull Activity activity) {
            if (activity == null) {
                throw new NullPointerException("activity is marked non-null but is null");
            }
            this.activity = activity;
            return this;
        }

        public SignInParametersBuilder withCallback(@NonNull AuthenticationCallback authenticationCallback) {
            if (authenticationCallback == null) {
                throw new NullPointerException("callback is marked non-null but is null");
            }
            this.callback = authenticationCallback;
            return this;
        }

        public SignInParametersBuilder withLoginHint(@Nullable String str) {
            this.loginHint = str;
            return this;
        }

        public SignInParametersBuilder withPrompt(@Nullable Prompt prompt) {
            this.prompt = prompt;
            return this;
        }

        public SignInParametersBuilder withScope(String str) {
            if (this.scopes == null) {
                this.scopes = new ArrayList<>();
            }
            this.scopes.add(str);
            return this;
        }

        public SignInParametersBuilder withScopes(Collection<? extends String> collection) {
            if (collection == null) {
                throw new NullPointerException("scopes cannot be null");
            }
            if (this.scopes == null) {
                this.scopes = new ArrayList<>();
            }
            this.scopes.addAll(collection);
            return this;
        }
    }

    public SignInParameters(@NonNull Activity activity, @Nullable String str, @NonNull List<String> list, @Nullable Prompt prompt, @NonNull AuthenticationCallback authenticationCallback) {
        if (activity == null) {
            throw new NullPointerException("activity is marked non-null but is null");
        }
        if (list == null) {
            throw new NullPointerException("scopes is marked non-null but is null");
        }
        if (authenticationCallback == null) {
            throw new NullPointerException("callback is marked non-null but is null");
        }
        this.activity = activity;
        this.loginHint = str;
        this.scopes = list;
        this.prompt = prompt;
        this.callback = authenticationCallback;
    }

    public static SignInParametersBuilder builder() {
        return new SignInParametersBuilder();
    }

    public boolean canEqual(Object obj) {
        return obj instanceof SignInParameters;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SignInParameters)) {
            return false;
        }
        SignInParameters signInParameters = (SignInParameters) obj;
        if (!signInParameters.canEqual(this)) {
            return false;
        }
        Activity activity = getActivity();
        Activity activity2 = signInParameters.getActivity();
        if (activity != null ? !activity.equals(activity2) : activity2 != null) {
            return false;
        }
        String loginHint = getLoginHint();
        String loginHint2 = signInParameters.getLoginHint();
        if (loginHint != null ? !loginHint.equals(loginHint2) : loginHint2 != null) {
            return false;
        }
        List<String> scopes = getScopes();
        List<String> scopes2 = signInParameters.getScopes();
        if (scopes != null ? !scopes.equals(scopes2) : scopes2 != null) {
            return false;
        }
        Prompt prompt = getPrompt();
        Prompt prompt2 = signInParameters.getPrompt();
        if (prompt != null ? !prompt.equals(prompt2) : prompt2 != null) {
            return false;
        }
        AuthenticationCallback callback = getCallback();
        AuthenticationCallback callback2 = signInParameters.getCallback();
        return callback != null ? callback.equals(callback2) : callback2 == null;
    }

    @NonNull
    public Activity getActivity() {
        return this.activity;
    }

    @NonNull
    public AuthenticationCallback getCallback() {
        return this.callback;
    }

    @Nullable
    public String getLoginHint() {
        return this.loginHint;
    }

    @Nullable
    public Prompt getPrompt() {
        return this.prompt;
    }

    @NonNull
    public List<String> getScopes() {
        return this.scopes;
    }

    public int hashCode() {
        Activity activity = getActivity();
        int iHashCode = activity == null ? 43 : activity.hashCode();
        String loginHint = getLoginHint();
        int iHashCode2 = ((iHashCode + 59) * 59) + (loginHint == null ? 43 : loginHint.hashCode());
        List<String> scopes = getScopes();
        int iHashCode3 = (iHashCode2 * 59) + (scopes == null ? 43 : scopes.hashCode());
        Prompt prompt = getPrompt();
        int iHashCode4 = (iHashCode3 * 59) + (prompt == null ? 43 : prompt.hashCode());
        AuthenticationCallback callback = getCallback();
        return (iHashCode4 * 59) + (callback != null ? callback.hashCode() : 43);
    }

    public void setActivity(@NonNull Activity activity) {
        if (activity == null) {
            throw new NullPointerException("activity is marked non-null but is null");
        }
        this.activity = activity;
    }

    public void setCallback(@NonNull AuthenticationCallback authenticationCallback) {
        if (authenticationCallback == null) {
            throw new NullPointerException("callback is marked non-null but is null");
        }
        this.callback = authenticationCallback;
    }

    public void setLoginHint(@Nullable String str) {
        this.loginHint = str;
    }

    public void setPrompt(@Nullable Prompt prompt) {
        this.prompt = prompt;
    }

    public void setScopes(@NonNull List<String> list) {
        if (list == null) {
            throw new NullPointerException("scopes is marked non-null but is null");
        }
        this.scopes = list;
    }

    public String toString() {
        return "SignInParameters(activity=" + getActivity() + ", loginHint=" + getLoginHint() + ", scopes=" + getScopes() + ", prompt=" + getPrompt() + ", callback=" + getCallback() + ")";
    }
}
