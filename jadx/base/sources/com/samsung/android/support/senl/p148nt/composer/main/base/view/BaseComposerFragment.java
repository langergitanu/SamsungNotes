package com.samsung.android.support.senl.p148nt.composer.main.base.view;

import android.app.Activity;
import android.app.assist.AssistContent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.os.BuildCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.window.layout.FoldingFeature;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.ApplicationManager;
import com.samsung.android.support.senl.p148nt.base.common.ComposerManager;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.SCSOperator;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.base.winset.util.DialogUtils;
import com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.CustomToolbarFragment;
import com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.ICustomToolbar;
import com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.IMenuInflater;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.common.Callback;
import com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory;
import com.samsung.android.support.senl.p148nt.composer.main.base.handoff.CoHandoffSendManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.BaseComposerPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.CompContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.CompListPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.RunnableC9844c;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiOnDeviceMemoryManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.search.SearchModePresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.title.TitleEditorPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.ToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.directwrite.DwToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtogglefab.HwToggleFabContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.quicktool.QuickToolPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.table.TableAndCellPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.translation.TlToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.composer.ComposerView;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.layout.BaseComposerActivityLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.CompListView;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenu;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenuParam;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.search.SearchModeView;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.TitleEditor;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.ToolbarManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.VoiceRecordMenuContainer;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.system.SystemUiManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.system.WindowManagerWrapper;
import java.util.List;
import p031G2.C0109b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class BaseComposerFragment extends CustomToolbarFragment implements CompContract.IView, DialogContract.IFragmentPresenterContainer, ComposerManager.IComposer, ComposerManager.IComponentFinalizer {
    private static final String TAG = Logger.createTag("BaseComposerFragment");
    private HwToggleFabContract.IView hwToggleFab;
    private ComposerView mComposerView;
    private ViewGroup mContainer;
    private View mFragmentView;
    private CompListView mListView;
    private int mMultiWindowMode;
    private OnBackInvokedCallback mOnBackInvokedCallback;
    protected OptionMenu mOptionMenu;
    private int mOrientation;
    protected BaseComposerPresenter mPresenter;
    private SearchModeView mSearchModeView;
    private SystemUiManager mSystemUiManager;
    protected TitleEditor mTitle;
    private ToolbarManager mToolbarManager;
    private VoiceRecordMenuContainer mVoiceRecordMenuContainer;
    private WindowManagerWrapper mWindowManager;
    private Runnable mDelayedRunnable = null;
    protected final BaseComponentFactory mComponentFactory = createComponentFactory();

    private int getHashCode() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            return activity.hashCode();
        }
        return 0;
    }

    private void initActionBar(AppCompatActivity appCompatActivity) {
        if (this.mComponentFactory.getConfig().isActionBarEnabled()) {
            enableToolbar();
            enableAdjustableMenu();
            appCompatActivity.setSupportActionBar((Toolbar) getSupportedToolbar());
            ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setDisplayHomeAsUpEnabled(true);
            }
            ICustomToolbar supportedToolbar = getSupportedToolbar();
            if (supportedToolbar != null) {
                supportedToolbar.setDisplayHomeAsUpEnabled(true);
            }
        }
    }

    private boolean isAvailableToolbarManager() {
        if (this.mComposerView.isDisableComposerView()) {
            return false;
        }
        if (this.mToolbarManager != null) {
            return true;
        }
        this.mToolbarManager = new ToolbarManager(this.mComponentFactory);
        return true;
    }

    private boolean isChangedWindowModeAndUpdate(String str) {
        int multiWindowMode = WindowManagerCompat.getInstance().getMultiWindowMode(getActivity());
        if (this.mMultiWindowMode == multiWindowMode) {
            return false;
        }
        Logger.m11003i(TAG, str + "getMultiWindowMode(" + multiWindowMode + ") preMultiWindowMode(" + this.mMultiWindowMode + ")");
        this.mMultiWindowMode = multiWindowMode;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onConfigurationChanged$3(Configuration configuration) {
        if (this.mDelayedRunnable != null) {
            onConfigurationChanged(configuration);
            this.mDelayedRunnable = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(FoldingFeature foldingFeature) {
        ToolbarManager toolbarManager = this.mToolbarManager;
        if (toolbarManager != null) {
            toolbarManager.changeDeviceState(getActivity(), foldingFeature);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onCreate$1() {
        return this.mPresenter.getComposerResolver().isSearchMode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$registerOnBackInvokedCallback$2() {
        Logger.m10999d(TAG, "OnBackInvokedCallback# invoke onBackPressed");
        onBackPressed(true);
    }

    private boolean needUpdate(boolean z, boolean z2) {
        return z || z2;
    }

    private void onWindowModeChanged(int i) {
        ComposerView composerView = this.mComposerView;
        if (composerView != null) {
            composerView.updateByMultiWindowMode(i);
        }
        BaseComposerPresenter baseComposerPresenter = this.mPresenter;
        if (baseComposerPresenter != null) {
            baseComposerPresenter.onWindowModeChanged(i);
        }
    }

    private void registerOnBackInvokedCallback(int i) {
        if (BuildCompat.isAtLeastV()) {
            unregisterOnBackInvokedCallback();
            this.mOnBackInvokedCallback = new C0109b(this, 4);
            Logger.m10999d(TAG, "registerOnBackInvokedCallback# priority : " + i);
            getActivity().getOnBackInvokedDispatcher().registerOnBackInvokedCallback(i, this.mOnBackInvokedCallback);
        }
    }

    private void unregisterOnBackInvokedCallback() {
        if (!BuildCompat.isAtLeastV() || this.mOnBackInvokedCallback == null) {
            return;
        }
        Logger.m10999d(TAG, "unregisterOnBackInvokedCallback#");
        getActivity().getOnBackInvokedDispatcher().unregisterOnBackInvokedCallback(this.mOnBackInvokedCallback);
        this.mOnBackInvokedCallback = null;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.ComposerSubContract.IView
    public void attachBottomMenu() {
        OptionMenu optionMenu = this.mOptionMenu;
        if (optionMenu != null) {
            optionMenu.attachBottomMenu();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.ComposerSubContract.IView
    public void attachCompList(CompListPresenter compListPresenter) {
        CompListView compListView = this.mListView;
        if (compListView != null) {
            compListView.updateView();
            return;
        }
        CompListView compListView2 = new CompListView(getActivity());
        this.mListView = compListView2;
        compListView2.setPresenter(compListPresenter);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.ComposerSubContract.IView
    public void attachComposerView(ComposerViewPresenter composerViewPresenter, boolean z) {
        ComposerView composerView = this.mComposerView;
        if (composerView != null && z) {
            composerView.release(true, true);
            this.mComposerView = null;
        }
        if (this.mComposerView == null) {
            this.mComposerView = this.mComponentFactory.createComposerView(getActivity());
        }
        this.mComposerView.setPresenter(composerViewPresenter);
        this.mComposerView.attachView((ViewGroup) getView().findViewById(C9086R.id.main_layout_container));
        if (!z) {
            initActionBar((AppCompatActivity) getActivity());
        }
        this.mComposerView.updateByMultiWindowMode(this.mMultiWindowMode);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.ComposerSubContract.IView
    public void attachDirectWriteMenu(DwToolbarPresenter dwToolbarPresenter) {
        if (isAvailableToolbarManager()) {
            this.mToolbarManager.attachDirectWriteMenu(getActivity(), dwToolbarPresenter);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.ComposerSubContract.IView
    public void attachGuideTextView() {
        Logger.m10999d(TAG, "attachGuideTextView");
        this.mComposerView.initGuideTextView();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.ComposerSubContract.IView
    public void attachHwToggleFab(HwToggleFabContract.IView iView) {
        this.hwToggleFab = iView;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.ComposerSubContract.IView
    public void attachHwToolbarMenu(HwToolbarPresenter hwToolbarPresenter, boolean z) {
        if (isAvailableToolbarManager()) {
            this.mToolbarManager.attachHwToolbarMenu(getActivity(), hwToolbarPresenter, z);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.ComposerSubContract.IView
    public void attachQuickTool(QuickToolPresenter quickToolPresenter) {
        if (isAvailableToolbarManager()) {
            this.mToolbarManager.attachQuickTool(quickToolPresenter, this.mComposerView.getQTContainView(), this.mComposerView.getComposerView(), this.mComposerView.getQTCoverView());
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.ComposerSubContract.IView
    public void attachRichTextMenu(RtToolbarPresenter rtToolbarPresenter, boolean z) {
        if (isAvailableToolbarManager()) {
            this.mToolbarManager.attachRichTextMenu(getActivity(), rtToolbarPresenter, z);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.ComposerSubContract.IView
    public void attachSearchModeView(SearchModePresenter searchModePresenter) {
        if (this.mSearchModeView == null) {
            this.mSearchModeView = new SearchModeView(this, searchModePresenter);
        }
    }

    public void attachSubTitle() {
        BaseComposerPresenter baseComposerPresenter = this.mPresenter;
        if (baseComposerPresenter == null || !UUIDUtils.isGenUuid(baseComposerPresenter.getComposerResolver().getUuid())) {
            return;
        }
        View viewInflate = LayoutInflater.from(getActivity()).inflate(C9086R.layout.comp_title_pdf_reader, (ViewGroup) null);
        if (viewInflate instanceof TextView) {
            TextView textView = (TextView) viewInflate;
            textView.setText(getResources().getString(C9086R.string.ai_translated_content));
            ICustomToolbar supportedToolbar = getSupportedToolbar();
            if (supportedToolbar != null) {
                supportedToolbar.setTitleBottomView(textView);
            }
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.ComposerSubContract.IView
    public void attachTableAndCellMenu(TableAndCellPresenter tableAndCellPresenter) {
        if (isAvailableToolbarManager()) {
            this.mToolbarManager.attachTableAndCellMenu(getActivity(), tableAndCellPresenter);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.ComposerSubContract.IView
    public void attachTitle(TitleEditorPresenter titleEditorPresenter) {
        setHasOptionsMenu(true);
        TitleEditor titleEditor = this.mTitle;
        if (titleEditor == null) {
            this.mTitle = new TitleEditor(getActivity(), this, titleEditorPresenter);
        } else {
            titleEditor.attachTitle();
        }
        attachSubTitle();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.ComposerSubContract.IView
    public void attachToolbar(ToolbarPresenter toolbarPresenter) {
        if (isAvailableToolbarManager()) {
            this.mToolbarManager.attachToolbar(getActivity(), toolbarPresenter);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.ComposerSubContract.IView
    public void attachTranslationLanguageMenu(TlToolbarPresenter tlToolbarPresenter) {
        if (isAvailableToolbarManager()) {
            this.mToolbarManager.attachTranslationLanguageMenu(getActivity(), tlToolbarPresenter);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.ComposerSubContract.IView
    public void attachVoiceMenu(VoiceRecordMenuPresenter voiceRecordMenuPresenter) {
        if (this.mComponentFactory.getConfig().isVoiceRecordingEnabled()) {
            VoiceRecordMenuContainer voiceRecordMenuContainer = this.mVoiceRecordMenuContainer;
            if (voiceRecordMenuContainer == null) {
                this.mVoiceRecordMenuContainer = new VoiceRecordMenuContainer(getActivity(), voiceRecordMenuPresenter, getSupportedToolbar());
            } else {
                voiceRecordMenuContainer.updateView();
            }
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.CompContract.IView
    public void callOnBackPressed() {
        onBackPressed(false);
    }

    public boolean changeLayout() {
        BaseComposerPresenter baseComposerPresenter = this.mPresenter;
        if (baseComposerPresenter == null || !baseComposerPresenter.canChangeLayout() || !this.mPresenter.isChangedTabletLayout(ResourceUtils.isTabletLayout(getContext()))) {
            Logger.m11003i(TAG, "changeLayout# layout is not changed");
            return false;
        }
        this.mPresenter.blockToHideSip(true);
        Bundle bundle = new Bundle();
        this.mPresenter.onChangeLayoutBefore(bundle);
        bundle.putBoolean(ComposerConstants.KEY_PREV_COMPOSER_TABLET_LAYOUT, !ResourceUtils.isTabletLayout(getContext()));
        ToolbarManager toolbarManager = this.mToolbarManager;
        if (toolbarManager != null) {
            toolbarManager.noticeChangeLayout();
            this.mToolbarManager.release();
            this.mToolbarManager = null;
        }
        VoiceRecordMenuContainer voiceRecordMenuContainer = this.mVoiceRecordMenuContainer;
        if (voiceRecordMenuContainer != null) {
            voiceRecordMenuContainer.hideVoicePopupView();
            this.mVoiceRecordMenuContainer.release();
            this.mVoiceRecordMenuContainer = null;
        }
        OptionMenu optionMenu = this.mOptionMenu;
        if (optionMenu != null) {
            optionMenu.release();
            this.mOptionMenu = null;
        }
        TitleEditor titleEditor = this.mTitle;
        if (titleEditor != null) {
            titleEditor.release();
            this.mTitle = null;
        }
        this.mListView = null;
        this.mSearchModeView = null;
        ComposerView composerView = this.mComposerView;
        if (composerView != null) {
            composerView.removeFromParent();
        }
        View view = getView();
        if (view != null) {
            ViewGroup viewGroup = (ViewGroup) view;
            viewGroup.removeAllViews();
            viewGroup.addView(View.inflate(getContext(), getLayoutRes(), null));
        }
        initialize(this.mFragmentView);
        this.mPresenter.onLoadDocCompleted(bundle);
        this.mPresenter.blockToHideSip(false);
        return true;
    }

    public void changeNote(String str, String str2) {
        this.mPresenter.changeNote(str, str2, true);
    }

    public BaseComponentFactory createComponentFactory() {
        return new BaseComponentFactory();
    }

    @Override // com.samsung.android.support.senl.nt.base.common.ComposerManager.IComponentFinalizer
    public void finalizeAll() {
        SCSOperator.releaseTranslator();
        Context appContext = ApplicationManager.getInstance().getAppContext();
        if (appContext != null) {
            AiOnDeviceMemoryManager.getInstance().forceRelease(appContext);
        }
    }

    @Override // com.samsung.android.support.senl.nt.base.common.ComposerManager.IComposer
    @NonNull
    public ComposerManager.IComposerResolver getComposerResolver() {
        return this.mPresenter.getComposerResolver();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IFragmentPresenterContainer
    @Nullable
    public DialogContract.IFragmentPresenter getDialogFragmentPresenter(int i) {
        BaseComposerPresenter baseComposerPresenter = this.mPresenter;
        if (baseComposerPresenter == null) {
            return null;
        }
        return baseComposerPresenter.getDialogFragmentPresenter(i);
    }

    public int getLayoutRes() {
        return C9086R.layout.composer_fragment_main;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.CustomToolbarFragment
    public void initAppbarContents(View view) {
        getLayoutInflater().inflate(C9086R.layout.comp_title_layout, (ViewGroup) view.findViewById(C9086R.id.composer_title_scroll_container));
    }

    public boolean isLockVerified() {
        BaseComposerPresenter baseComposerPresenter = this.mPresenter;
        if (baseComposerPresenter != null) {
            return baseComposerPresenter.isLockVerified();
        }
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        String str = TAG;
        AbstractC8014b.m7216r(i, i2, "onActivityResult requestCode : ", "    resultCode : ", str);
        super.onActivityResult(i, i2, intent);
        if (i != 109 || i2 != 0) {
            this.mPresenter.onActivityResult(i, i2, intent);
            return;
        }
        Logger.m10999d(str, "Unlock canceled");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NonNull Context context) {
        Logger.m10999d(TAG, "onAttach");
        super.onAttach(context);
        if (getLifecycle().getState().isAtLeast(Lifecycle.State.CREATED)) {
            ComposerManager.getInstance().onAttach(this);
            registerOnBackInvokedCallback(0);
        }
    }

    public boolean onBLEShortcut(KeyEvent keyEvent) {
        return this.mPresenter.onBLEShortcut(keyEvent);
    }

    public boolean onBackPressed(boolean z) {
        TitleEditor titleEditor = this.mTitle;
        if (titleEditor != null && titleEditor.onBackPressed(z)) {
            return true;
        }
        ToolbarManager toolbarManager = this.mToolbarManager;
        if (toolbarManager != null && toolbarManager.onBackPressed(z)) {
            return true;
        }
        CompListView compListView = this.mListView;
        if (compListView == null || !compListView.onBackPressed()) {
            return this.mPresenter.onBackPressed(z);
        }
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.CustomToolbarFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        boolean z;
        BaseComposerPresenter baseComposerPresenter;
        ViewGroup viewGroup;
        Logger.m11003i(TAG, "onConfigurationChanged#" + configuration.toString());
        BaseComposerPresenter baseComposerPresenter2 = this.mPresenter;
        if (baseComposerPresenter2 != null && !baseComposerPresenter2.canWorkingDocument() && (viewGroup = this.mContainer) != null) {
            if (this.mDelayedRunnable != null) {
                viewGroup.getHandler().removeCallbacks(this.mDelayedRunnable);
            }
            RunnableC9844c runnableC9844c = new RunnableC9844c(this, configuration, 16);
            this.mDelayedRunnable = runnableC9844c;
            this.mContainer.postDelayed(runnableC9844c, 1000L);
            return;
        }
        boolean zIsChangedWindowModeAndUpdate = isChangedWindowModeAndUpdate("onConfigurationChanged#");
        if (changeLayout()) {
            BaseComposerPresenter baseComposerPresenter3 = this.mPresenter;
            if (baseComposerPresenter3 == null) {
                return;
            }
            if (zIsChangedWindowModeAndUpdate) {
                baseComposerPresenter3.onWindowModeChanged(this.mMultiWindowMode);
                return;
            } else {
                baseComposerPresenter3.onConfigurationChangedForQuickNote();
                return;
            }
        }
        int i = this.mOrientation;
        int i2 = configuration.orientation;
        if (i != i2) {
            this.mOrientation = i2;
            z = true;
        } else {
            z = false;
        }
        if (zIsChangedWindowModeAndUpdate) {
            onWindowModeChanged(this.mMultiWindowMode);
        }
        BaseComposerPresenter baseComposerPresenter4 = this.mPresenter;
        if (baseComposerPresenter4 != null) {
            baseComposerPresenter4.onConfigurationChanged(configuration, z);
            this.mPresenter.onConfigurationChangedForQuickNote();
        }
        ComposerView composerView = this.mComposerView;
        if (composerView != null) {
            composerView.onConfigurationChanged(configuration, z);
        }
        CompListView compListView = this.mListView;
        if (compListView != null) {
            compListView.onConfigurationChanged(configuration);
        }
        ToolbarManager toolbarManager = this.mToolbarManager;
        if (toolbarManager != null) {
            toolbarManager.onConfigurationChanged(getActivity(), configuration);
            if (z) {
                this.mToolbarManager.onOrientationChanged();
            }
        }
        OptionMenu optionMenu = this.mOptionMenu;
        if (optionMenu != null) {
            optionMenu.onConfigurationChanged(configuration);
        }
        if (z && (baseComposerPresenter = this.mPresenter) != null && !baseComposerPresenter.isFullScreenMode()) {
            this.mSystemUiManager.getStatusBar().updateStatusBar(getActivity());
        }
        if (needUpdate(z, zIsChangedWindowModeAndUpdate)) {
            TitleEditor titleEditor = this.mTitle;
            if (titleEditor != null) {
                titleEditor.updateVisibility();
            }
            HwToggleFabContract.IView iView = this.hwToggleFab;
            if (iView != null) {
                iView.updateVisibility();
            }
        }
        OptionMenu optionMenu2 = this.mOptionMenu;
        if (optionMenu2 != null) {
            optionMenu2.invalidateDelayOptionsMenu();
        }
        VoiceRecordMenuContainer voiceRecordMenuContainer = this.mVoiceRecordMenuContainer;
        if (voiceRecordMenuContainer != null) {
            voiceRecordMenuContainer.onConfigurationChanged();
        }
        SearchModeView searchModeView = this.mSearchModeView;
        if (searchModeView != null) {
            searchModeView.onConfigurationChanged(configuration, z);
        }
        super.onConfigurationChanged(configuration);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        Logger.startTime(String.valueOf(getHashCode()), Logger.START_TAG, "onCreate# ");
        super.onCreate(bundle);
        setRetainInstance(true);
        setPresenter(this.mComponentFactory.createPresenter());
        this.mPresenter.onCreated(getActivity());
        this.mWindowManager = new WindowManagerWrapper(getActivity(), new C10068a(this));
        this.mSystemUiManager = new SystemUiManager(this.mComponentFactory.getConfig().isStatusBarEnabled(), new C10068a(this));
        ComposerManager.getInstance().onCreate(this);
        registerOnBackInvokedCallback(0);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.CustomToolbarFragment
    public void onCreateFragmentOptionMenu(@NonNull Menu menu, @NonNull IMenuInflater iMenuInflater) {
        Logger.m10999d(TAG, "onCreateOptionsMenu# ");
        this.mOptionMenu = this.mComponentFactory.createOptionMenuCreator(this.mOptionMenu, getActivity(), this.mPresenter.getOptionMenuPresenter());
        OptionMenuParam optionMenuParam = new OptionMenuParam(menu);
        optionMenuParam.setMenuInflater(iMenuInflater);
        this.mOptionMenu.onCreateOptionsMenu(optionMenuParam);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Logger.midTime(String.valueOf(getHashCode()), Logger.START_TAG, "onCreateView# ");
        this.mContainer = viewGroup;
        View viewInflate = layoutInflater.inflate(getLayoutRes(), viewGroup, false);
        this.mFragmentView = viewInflate;
        initialize(viewInflate);
        return this.mFragmentView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        Logger.m10999d(TAG, "onDestroy# ");
        CoHandoffSendManager.getInstance().unregisterHandoffContentObserver(this);
        unregisterOnBackInvokedCallback();
        BaseComposerPresenter baseComposerPresenter = this.mPresenter;
        if (baseComposerPresenter != null) {
            baseComposerPresenter.onDestroy(getActivity());
            ViewGroup viewGroup = this.mContainer;
            if (viewGroup != null && this.mDelayedRunnable != null) {
                viewGroup.getHandler().removeCallbacks(this.mDelayedRunnable);
                this.mDelayedRunnable = null;
            }
        }
        WindowManagerWrapper windowManagerWrapper = this.mWindowManager;
        if (windowManagerWrapper != null) {
            windowManagerWrapper.release();
        }
        super.onDestroy();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.CustomToolbarFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Logger.m10999d(TAG, "onDestroyView");
        ViewGroup viewGroup = this.mContainer;
        if (viewGroup instanceof BaseComposerActivityLayout) {
            ((BaseComposerActivityLayout) viewGroup).setDispatchKeyEvent(null);
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        Logger.m10999d(TAG, "onDetach# ");
        super.onDetach();
        if (DialogUtils.getsOverSizeItemsDialog() != null && DialogUtils.getsOverSizeItemsDialog().isShowing()) {
            DialogUtils.getsOverSizeItemsDialog().dismiss();
            DialogUtils.clearOverSizeItemsDialog();
        }
        ComposerManager.getInstance().onDetach(this);
        unregisterOnBackInvokedCallback();
        ToolbarManager toolbarManager = this.mToolbarManager;
        if (toolbarManager != null) {
            toolbarManager.release();
            this.mToolbarManager = null;
        }
        BaseComposerPresenter baseComposerPresenter = this.mPresenter;
        if (baseComposerPresenter != null) {
            baseComposerPresenter.onDetachView(getActivity());
        }
        OptionMenu optionMenu = this.mOptionMenu;
        if (optionMenu != null) {
            optionMenu.release();
            this.mOptionMenu = null;
        }
        TitleEditor titleEditor = this.mTitle;
        if (titleEditor != null) {
            titleEditor.release();
            this.mTitle = null;
        }
        this.mListView = null;
        this.mSearchModeView = null;
        this.mComposerView = null;
        this.mVoiceRecordMenuContainer = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onMultiWindowModeChanged(boolean z) {
        super.onMultiWindowModeChanged(z);
        if (isChangedWindowModeAndUpdate("onMultiWindowModeChanged#")) {
            onWindowModeChanged(this.mMultiWindowMode);
        }
    }

    public void onNewIntent(Intent intent) {
        BaseComposerPresenter baseComposerPresenter = this.mPresenter;
        if (baseComposerPresenter != null) {
            baseComposerPresenter.onNewIntent(intent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(@NonNull MenuItem menuItem) {
        if (this.mOptionMenu != null) {
            if (this.mOptionMenu.onOptionsItemSelected(new OptionMenuParam(menuItem), menuItem.getItemId())) {
                return true;
            }
        } else {
            Logger.m11000e(TAG, "onOptionsItemSelected# mOptionMenu is null");
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        this.mPresenter.onPause();
        super.onPause();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.CustomToolbarFragment
    public void onPrepareFragmentOptionMenu(@NonNull Menu menu) {
        if (this.mOptionMenu != null) {
            this.mOptionMenu.onPrepareOptionsMenu(new OptionMenuParam(menu));
        }
        ComposerView composerView = this.mComposerView;
        if (composerView != null) {
            composerView.onOptionsMenuPrepared();
        }
        TitleEditor titleEditor = this.mTitle;
        if (titleEditor != null) {
            titleEditor.onPrepareFragmentOptionMenu();
        }
    }

    public void onProvideAssistContent(@NonNull Activity activity, AssistContent assistContent) {
        this.mPresenter.onProvideAssistContent(activity, assistContent);
    }

    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list) {
        KeyboardShortcutGroup keyboardShortcutGroup = this.mPresenter.getKeyboardShortcutGroup();
        if (keyboardShortcutGroup == null) {
            return;
        }
        list.add(keyboardShortcutGroup);
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        this.mPresenter.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        this.mPresenter.onResume();
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        BaseComposerPresenter baseComposerPresenter = this.mPresenter;
        if (baseComposerPresenter != null) {
            baseComposerPresenter.onSaveInstanceState(bundle, true, true);
            bundle.putBoolean(ComposerConstants.KEY_PREV_COMPOSER_TABLET_LAYOUT, ResourceUtils.isTabletLayout(getContext()));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        this.mPresenter.onStart();
        super.onStart();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        this.mPresenter.onStop();
        super.onStop();
    }

    public void onTrimMemory(int i) {
        BaseComposerPresenter baseComposerPresenter = this.mPresenter;
        if (baseComposerPresenter != null) {
            baseComposerPresenter.onTrimMemory(i);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        Logger.midTime(String.valueOf(getHashCode()), Logger.START_TAG, "onViewCreated# ");
        this.mSystemUiManager.getStatusBar().initStatusBar(getActivity());
        AppCompatActivity appCompatActivity = (AppCompatActivity) getActivity();
        if (appCompatActivity != null) {
            appCompatActivity.setTitle("");
        }
        this.mPresenter.onActivityCreated(getActivity(), bundle);
        this.mOrientation = getResources().getConfiguration().orientation;
        this.mMultiWindowMode = WindowManagerCompat.getInstance().getMultiWindowMode(getActivity());
        this.mPresenter.displayProgressForInitialization();
        ViewGroup viewGroup = this.mContainer;
        if (viewGroup instanceof BaseComposerActivityLayout) {
            BaseComposerActivityLayout baseComposerActivityLayout = (BaseComposerActivityLayout) viewGroup;
            baseComposerActivityLayout.setDispatchKeyEvent(new BaseComposerActivityLayout.OnDispatchKeyEvent() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.BaseComposerFragment.1
                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.layout.BaseComposerActivityLayout.OnDispatchKeyEvent
                public boolean dispatchKeyEvent(KeyEvent keyEvent) {
                    return BaseComposerFragment.this.mPresenter.dispatchKeyEvent(keyEvent);
                }
            });
            baseComposerActivityLayout.setOnDispatchKeyEventPreImeInterceptor(new BaseComposerActivityLayout.OnDispatchKeyEventPreImeInterceptor() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.BaseComposerFragment.2
                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.layout.BaseComposerActivityLayout.OnDispatchKeyEventPreImeInterceptor
                public boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
                    return BaseComposerFragment.this.mPresenter.dispatchKeyEventPreIme(keyEvent);
                }
            });
        }
    }

    public void onWindowFocusChanged(boolean z) {
        Logger.m11003i(TAG, "onWindowFocusChanged# " + hashCode() + " " + z);
        this.mPresenter.onWindowFocusChanged(z);
        if (z) {
            OptionMenu optionMenu = this.mOptionMenu;
            if (optionMenu != null) {
                optionMenu.onWindowFocusChanged();
            }
            ToolbarManager toolbarManager = this.mToolbarManager;
            if (toolbarManager != null) {
                toolbarManager.onWindowFocusChanged();
            }
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.ComposerSubContract.IView
    public void releaseComposerView(Callback callback) {
        ToolbarManager toolbarManager = this.mToolbarManager;
        if (toolbarManager != null) {
            toolbarManager.clearSelectedButtonsOfHandWritingToolbarItem();
        }
        ComposerView composerView = this.mComposerView;
        if (composerView != null) {
            composerView.releaseAfterCapture(callback);
            this.mComposerView = null;
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.ComposerSubContract.IView
    public void removeCaptureComposerView() {
        ComposerView composerView = this.mComposerView;
        if (composerView != null) {
            composerView.removeCaptureView();
        }
    }

    public void resetLockVerified() {
        BaseComposerPresenter baseComposerPresenter = this.mPresenter;
        if (baseComposerPresenter != null) {
            baseComposerPresenter.resetLockVerified();
        }
    }

    public void setPresenter(BaseComposerPresenter baseComposerPresenter) {
        String str = TAG;
        Logger.m10999d(str, "setPresenter");
        if (this.mPresenter != null) {
            Logger.m10999d(str, "setPresenter :  mPresenter set already");
        } else {
            this.mPresenter = baseComposerPresenter;
            baseComposerPresenter.setView(this);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.ComposerSubContract.IView
    public void showComposerCover() {
        ComposerView composerView = this.mComposerView;
        if (composerView != null) {
            composerView.showCover();
        }
    }

    public boolean verifyScreenLock() {
        BaseComposerPresenter baseComposerPresenter = this.mPresenter;
        if (baseComposerPresenter != null) {
            return baseComposerPresenter.verifyScreenLock();
        }
        return false;
    }
}
