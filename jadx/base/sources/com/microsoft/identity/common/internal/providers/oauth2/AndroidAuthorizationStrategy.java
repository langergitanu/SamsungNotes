package com.microsoft.identity.common.internal.providers.oauth2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationRequest;
import com.microsoft.identity.common.java.providers.oauth2.IAuthorizationStrategy;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy;
import edu.umd.cs.findbugs.annotations.Nullable;
import java.lang.ref.WeakReference;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AndroidAuthorizationStrategy<GenericOAuth2Strategy extends OAuth2Strategy, GenericAuthorizationRequest extends AuthorizationRequest> implements IAuthorizationStrategy<GenericOAuth2Strategy, GenericAuthorizationRequest> {
    private final WeakReference<Activity> mReferencedActivity;
    private final WeakReference<Context> mReferencedApplicationContext;
    private final WeakReference<Fragment> mReferencedFragment;

    public AndroidAuthorizationStrategy(@NonNull Context context, @NonNull Activity activity, @Nullable Fragment fragment) {
        if (context == null) {
            throw new NullPointerException("applicationContext is marked non-null but is null");
        }
        if (activity == null) {
            throw new NullPointerException("activity is marked non-null but is null");
        }
        this.mReferencedApplicationContext = new WeakReference<>(context);
        this.mReferencedActivity = new WeakReference<>(activity);
        this.mReferencedFragment = new WeakReference<>(fragment);
    }

    public Context getApplicationContext() {
        return this.mReferencedApplicationContext.get();
    }

    public void launchIntent(@NonNull Intent intent) throws ClientException {
        if (intent == null) {
            throw new NullPointerException("intent is marked non-null but is null");
        }
        Fragment fragment = this.mReferencedFragment.get();
        if (fragment == null) {
            Activity activity = this.mReferencedActivity.get();
            if (activity == null) {
                throw new ClientException("unknown_error", "Referenced activity is null");
            }
            activity.startActivity(intent);
            return;
        }
        Fragment authorizationFragmentFromStartIntent = AuthorizationActivityFactory.getAuthorizationFragmentFromStartIntent(intent);
        FragmentManager fragmentManager = fragment.getFragmentManager();
        if (fragmentManager == null) {
            throw new ClientException("unknown_error", "Fragment Manager is null");
        }
        fragmentManager.beginTransaction().setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE).add(fragment.getId(), authorizationFragmentFromStartIntent, Fragment.class.getName()).commit();
    }
}
