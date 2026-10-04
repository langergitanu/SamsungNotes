package com.samsung.android.support.senl.p148nt.composer.main.simple.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SeslProgressBar;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.CustomToolbarFragment;
import com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.IMenuInflater;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.simple.common.SimpleComposerConstant;
import com.samsung.android.support.senl.p148nt.composer.main.simple.model.NoteInfoArgument;
import com.samsung.android.support.senl.p148nt.composer.main.simple.presenter.SimpleComposerFragmentContract;
import com.samsung.android.support.senl.p148nt.composer.main.simple.presenter.SimpleComposerFragmentPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.simple.presenter.SimpleComposerViewPresenter;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SimpleComposerFragment extends CustomToolbarFragment implements SimpleComposerFragmentContract.IView {
    private static final String TAG = Logger.createTag("SimpleComposerFragment", SimpleComposerConstant.TAG_PREFIX);
    protected View mFragmentView;
    protected int mMultiWindowMode;
    protected SimpleComposerFragmentPresenter mPresenter;
    protected ProgressController mProgressController;
    protected SimpleComposerView mSimpleComposerView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ProgressController {
        private SeslProgressBar mProgressCircle;

        public void initProgress(Activity activity) {
            ViewStub viewStub = (ViewStub) activity.findViewById(C9086R.id.comp_progress_circle);
            if (viewStub != null) {
                this.mProgressCircle = (SeslProgressBar) viewStub.inflate();
            } else {
                this.mProgressCircle = (SeslProgressBar) activity.findViewById(C9086R.id.progress_bar);
            }
            this.mProgressCircle.setBackgroundColor(0);
        }

        public void setProgressVisibility(boolean z) {
            this.mProgressCircle.setVisibility(z ? 0 : 8);
        }
    }

    private boolean isChangedWindowModeAndUpdate(String str) {
        int multiWindowMode = WindowManagerCompat.getInstance().getMultiWindowMode(requireActivity());
        if (this.mMultiWindowMode == multiWindowMode) {
            return false;
        }
        Logger.m11003i(TAG, str + "getMultiWindowMode(" + multiWindowMode + ") preMultiWindowMode(" + this.mMultiWindowMode + ")");
        this.mMultiWindowMode = multiWindowMode;
        return true;
    }

    private NoteInfoArgument loadNoteInfoArgument() {
        NoteInfoArgument noteInfoArgument = (NoteInfoArgument) requireArguments().getParcelable(NoteInfoArgument.KEY_BUNDLE);
        if (noteInfoArgument != null) {
            return noteInfoArgument;
        }
        requireActivity().finish();
        Logger.m11000e(TAG, "onCreate# getArguments is null");
        ToastHandler.show(requireActivity(), "unexpected error", 0);
        return null;
    }

    private void onWindowModeChanged() {
        SimpleComposerView simpleComposerView = this.mSimpleComposerView;
        if (simpleComposerView != null) {
            simpleComposerView.updateByMultiWindowMode();
        }
    }

    public void attachComposerView(SimpleComposerViewPresenter simpleComposerViewPresenter) {
        if (this.mSimpleComposerView == null) {
            this.mSimpleComposerView = new SimpleComposerView(this);
        }
        this.mProgressController.setProgressVisibility(false);
        this.mSimpleComposerView.setPresenter(simpleComposerViewPresenter, getTag());
        this.mSimpleComposerView.attachView((ViewGroup) this.mFragmentView.findViewById(C9086R.id.simple_comp_container));
        this.mSimpleComposerView.updateByMultiWindowMode();
    }

    @LayoutRes
    public int getLayoutResource() {
        return C9086R.layout.simple_comp_view_fragment;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.CustomToolbarFragment
    public void initAppbarContents(View view) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Logger.m10999d(TAG, "onAttach# " + getTag());
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.CustomToolbarFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        if (isChangedWindowModeAndUpdate("onConfigurationChanged#")) {
            onWindowModeChanged();
        }
        super.onConfigurationChanged(configuration);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        Logger.m10999d(TAG, "onCreate# " + getTag());
        super.onCreate(bundle);
        NoteInfoArgument noteInfoArgumentLoadNoteInfoArgument = loadNoteInfoArgument();
        if (noteInfoArgumentLoadNoteInfoArgument == null) {
            return;
        }
        this.mPresenter = new SimpleComposerFragmentPresenter(this, noteInfoArgumentLoadNoteInfoArgument, bundle);
        this.mProgressController = new ProgressController();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.CustomToolbarFragment
    public void onCreateFragmentOptionMenu(@NonNull Menu menu, @NonNull IMenuInflater iMenuInflater) {
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Logger.m10999d(TAG, "onCreateView# " + getTag());
        View viewInflate = layoutInflater.inflate(getLayoutResource(), viewGroup, false);
        this.mFragmentView = viewInflate;
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        Logger.m10999d(TAG, "onDestroy# " + getTag());
        this.mPresenter.onDestroy();
        super.onDestroy();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.CustomToolbarFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Logger.m10999d(TAG, "onDestroyView# " + getTag());
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        Logger.m10999d(TAG, "onDetach# " + getTag());
        super.onDetach();
    }

    @Override // androidx.fragment.app.Fragment
    public void onMultiWindowModeChanged(boolean z) {
        super.onMultiWindowModeChanged(z);
        if (isChangedWindowModeAndUpdate("onMultiWindowModeChanged#")) {
            onWindowModeChanged();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.CustomToolbarFragment
    public void onPrepareFragmentOptionMenu(@NonNull Menu menu) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBundle(getTag(), new Bundle());
        SimpleComposerFragmentPresenter simpleComposerFragmentPresenter = this.mPresenter;
        if (simpleComposerFragmentPresenter != null) {
            simpleComposerFragmentPresenter.onSaveInstanceState(bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        AppCompatActivity appCompatActivity = (AppCompatActivity) requireActivity();
        this.mProgressController.initProgress(appCompatActivity);
        this.mProgressController.setProgressVisibility(true);
        this.mPresenter.requestLoadDocument();
        this.mMultiWindowMode = WindowManagerCompat.getInstance().getMultiWindowMode(appCompatActivity);
    }

    public void updateTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ((TextView) this.mFragmentView.findViewById(C9086R.id.title_text)).setText(str);
    }
}
