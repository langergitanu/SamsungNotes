package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.controller.ViewState;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ComposerLifeState {
    public static final String KEY_NOT_INIT_STATE = "not_initialized";
    private Activity mActivity;
    private Fragment mFragment;
    private Bundle mSavedInstanceState;
    private final ViewState mViewState = new ViewState();
    private boolean mIsInitialized = false;
    private boolean mIsInitLayoutFinished = false;
    private boolean mIsChangingDoc = false;

    @Nullable
    public Activity getActivity() {
        return this.mActivity;
    }

    public Fragment getFragment() {
        return this.mFragment;
    }

    public Bundle getSavedInstanceState() {
        return this.mSavedInstanceState;
    }

    public ViewState getViewState() {
        return this.mViewState;
    }

    public boolean isChangingDoc() {
        return this.mIsChangingDoc;
    }

    public boolean isInitLayoutFinished() {
        return this.mIsInitLayoutFinished;
    }

    public boolean isInitialized() {
        return this.mIsInitialized;
    }

    public boolean isNotRecreated() {
        return this.mSavedInstanceState == null;
    }

    public boolean isRecreatedBeforeInit() {
        Bundle bundle = this.mSavedInstanceState;
        return bundle != null && bundle.getBoolean("not_initialized");
    }

    public void onPause() {
        this.mViewState.onPause();
    }

    public void onResume() {
        this.mViewState.onResume();
    }

    public void onStop() {
        this.mViewState.onStop();
    }

    public void setActivity(Activity activity) {
        this.mActivity = activity;
    }

    public void setChangingDocState(boolean z) {
        this.mIsChangingDoc = z;
    }

    public void setFragment(Fragment fragment) {
        this.mFragment = fragment;
    }

    public void setInitLayoutFinished(boolean z) {
        this.mIsInitLayoutFinished = z;
    }

    public void setInitialized(boolean z) {
        this.mIsInitialized = z;
        this.mSavedInstanceState = null;
        this.mIsChangingDoc = false;
    }

    public void setSavedInstanceState(Bundle bundle) {
        this.mSavedInstanceState = bundle;
    }
}
