package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub;

import android.os.Handler;
import android.os.Looper;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub.ComposerSubContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class MenuAttachManager {
    private static final int DELAY_TIME_ATTACH_VIEW = 10;
    private static final String TAG = Logger.createTag("MenuAttachManager");
    private boolean mIsMenuAttached;
    protected final BaseSubManager mSubManager;
    protected ComposerSubContract.IView mView;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final List<Runnable> mMenuTasks = new ArrayList();

    public MenuAttachManager(BaseSubManager baseSubManager) {
        this.mSubManager = baseSubManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void attachHeavyView(boolean z) {
        AbstractC8014b.m7224z("attachHeavyView# ", TAG, z);
        this.mView.attachRichTextMenu(this.mSubManager.getMenuPresenterManager().getRtToolbarPresenter(), z);
        this.mView.attachHwToolbarMenu(this.mSubManager.getMenuPresenterManager().getHwToolbarPresenter(), z);
        this.mView.attachDirectWriteMenu(this.mSubManager.getMenuPresenterManager().getDwToolbarPresenter());
        this.mView.attachQuickTool(this.mSubManager.getMenuPresenterManager().getQuickToolPresenter());
        this.mView.attachToolbar(this.mSubManager.getMenuPresenterManager().getToolbarPresenter());
        this.mView.attachTableAndCellMenu(this.mSubManager.getMenuPresenterManager().getTableAndCellMenuPresenter());
        this.mView.attachCompList(this.mSubManager.getMenuPresenterManager().getListPresenter());
        if (this.mSubManager.getComposerModel().getComposerState().isNeedGuideView()) {
            this.mView.attachGuideTextView();
        }
        if (!this.mSubManager.getComposerModel().isPDFReader()) {
            this.mView.attachBottomMenu();
        }
        this.mIsMenuAttached = true;
        onAttachedHeavyView();
    }

    private void onAttachedHeavyView() {
        this.mSubManager.getMenuPresenterManager().updateToolbarByMode(false);
        runMenuTasks();
    }

    private void runMenuTasks() {
        Iterator<Runnable> it = this.mMenuTasks.iterator();
        while (it.hasNext()) {
            it.next().run();
        }
        this.mMenuTasks.clear();
    }

    public void addMenuTask(Runnable runnable) {
        this.mMenuTasks.add(runnable);
        if (this.mIsMenuAttached) {
            runMenuTasks();
        }
    }

    public void attachViews() {
        ComposerSubContract.IView iView = (ComposerSubContract.IView) this.mSubManager.getComposerLifeState().getFragment();
        this.mView = iView;
        this.mIsMenuAttached = false;
        iView.attachTitle(this.mSubManager.getMenuPresenterManager().getTitleEditorPresenter());
        this.mView.attachSearchModeView(this.mSubManager.getMenuPresenterManager().getSearchModePresenter());
        this.mView.attachVoiceMenu(this.mSubManager.getMenuPresenterManager().getVoiceRecordMenuPresenter());
        this.mView.attachHwToggleFab(this.mSubManager.getMenuPresenterManager().getHwToggleFabManager());
        this.mView.attachTranslationLanguageMenu(this.mSubManager.getMenuPresenterManager().getTlToolbarPresenter());
        if (!this.mSubManager.getComposerModel().getDocState().isContentEmpty() || EntryAction.isPdfViewAction(this.mSubManager.getComposerLifeState().getActivity().getIntent()) || !this.mSubManager.getComposerModel().getComposerSaveModel().isAutoSaveOptionEnabled() || this.mSubManager.getComposerModel().getCoeditAdapter().isCoeditNote()) {
            this.mSubManager.getComposerModel().getComposerState().disableIsNeedGuideView();
        }
        final boolean zIsChangingDoc = this.mSubManager.getComposerLifeState().isChangingDoc();
        this.mHandler.postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.MenuAttachManager.1
            @Override // java.lang.Runnable
            public void run() {
                MenuAttachManager.this.attachHeavyView(zIsChangingDoc);
            }
        }, 10L);
    }

    public void clear() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mMenuTasks.clear();
        this.mView = null;
        this.mIsMenuAttached = false;
    }
}
