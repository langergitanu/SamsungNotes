package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public class ViewModelProviders {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Deprecated
    public static class DefaultFactory extends ViewModelProvider.AndroidViewModelFactory {
        @Deprecated
        public DefaultFactory(@NonNull Application application) {
            super(application);
        }
    }

    @Deprecated
    public ViewModelProviders() {
    }

    private static Activity checkActivity(Fragment fragment) {
        FragmentActivity activity = fragment.getActivity();
        if (activity != null) {
            return activity;
        }
        throw new IllegalStateException("Can't create ViewModelProvider for detached fragment");
    }

    private static Application checkApplication(Activity activity) {
        Application application = activity.getApplication();
        if (application != null) {
            return application;
        }
        throw new IllegalStateException("Your activity/fragment is not yet attached to Application. You can't request ViewModel before onCreate call.");
    }

    @NonNull
    @MainThread
    /* JADX INFO: renamed from: of */
    public static ViewModelProvider m2338of(@NonNull Fragment fragment) {
        return m2339of(fragment, (ViewModelProvider.Factory) null);
    }

    @NonNull
    @MainThread
    /* JADX INFO: renamed from: of */
    public static ViewModelProvider m2340of(@NonNull FragmentActivity fragmentActivity) {
        return m2341of(fragmentActivity, (ViewModelProvider.Factory) null);
    }

    @NonNull
    @MainThread
    /* JADX INFO: renamed from: of */
    public static ViewModelProvider m2339of(@NonNull Fragment fragment, @Nullable ViewModelProvider.Factory factory) {
        Application applicationCheckApplication = checkApplication(checkActivity(fragment));
        if (factory == null) {
            factory = ViewModelProvider.AndroidViewModelFactory.getInstance(applicationCheckApplication);
        }
        return new ViewModelProvider(fragment.getViewModelStore(), factory);
    }

    @NonNull
    @MainThread
    /* JADX INFO: renamed from: of */
    public static ViewModelProvider m2341of(@NonNull FragmentActivity fragmentActivity, @Nullable ViewModelProvider.Factory factory) {
        Application applicationCheckApplication = checkApplication(fragmentActivity);
        if (factory == null) {
            factory = ViewModelProvider.AndroidViewModelFactory.getInstance(applicationCheckApplication);
        }
        return new ViewModelProvider(fragmentActivity.getViewModelStore(), factory);
    }
}
