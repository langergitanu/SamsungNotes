package com.samsung.android.support.senl.p148nt.composer.main.base.view.composer;

import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.samsung.android.sdk.composer.SpenComposer;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.composer.ComposerViewState;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.composer.PageTunerButton;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ComposerViewMenuManager implements ComposerViewState.StateChangeListener {
    private AddNewPageView mAddNewPageView;
    private final ComposerViewState mComposerViewState;
    private SpenWNote mNote;
    private PageTunerButton mPageTurnerButton;
    private ViewGroup mParent;
    private ComposerViewContract.IPresenter mPresenter;
    private SpenComposer mSpenComposer;
    private VstPageControllerView mVstPageControllerView;

    public ComposerViewMenuManager(ComposerViewState composerViewState) {
        this.mComposerViewState = composerViewState;
    }

    private void initAddNewPageView() {
        if (isHideAddNewPageButton()) {
            return;
        }
        AddNewPageView addNewPageView = new AddNewPageView(this.mParent);
        this.mAddNewPageView = addNewPageView;
        addNewPageView.init(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.ComposerViewMenuManager.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ComposerViewMenuManager.this.mPresenter.insertPage(ComposerViewMenuManager.this.mNote.getPageCount() - 1);
                if (DeviceInfo.isVSTModel()) {
                    ComposerSA.insertLog(ComposerSA.getScreenID(ComposerViewMenuManager.this.mPresenter.getComposerModel().getModeManager().isEditMode(), ComposerViewMenuManager.this.mPresenter.getComposerModel().getModeManager().isMode(Mode.Writing), ComposerViewMenuManager.this.mPresenter.getComposerModel().isTabletLayout()), ComposerSAConstants.EVENT_VST_PAGE_CONTROLLER_ADD_PAGE);
                }
            }
        });
    }

    private void initPageTunerView() {
        if (!DeviceInfo.isVSTModel() || this.mNote.getPageMode() == SpenWNote.PageMode.SINGLE) {
            return;
        }
        PageTunerButton pageTunerButton = new PageTunerButton();
        this.mPageTurnerButton = pageTunerButton;
        pageTunerButton.init(this.mParent, this.mComposerViewState, new PageTunerButton.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.ComposerViewMenuManager.2
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.PageTunerButton.Contract
            public ComposerModel getComposerModel() {
                return ComposerViewMenuManager.this.mPresenter.getComposerModel();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.PageTunerButton.Contract
            public void goToPage(int i) {
                ComposerViewMenuManager.this.mPresenter.goToPage(i);
            }
        });
    }

    private void initVstPageControlView() {
        if (DeviceInfo.isVSTModel()) {
            VstPageControllerView vstPageControllerView = new VstPageControllerView(this.mParent, this.mPresenter);
            this.mVstPageControllerView = vstPageControllerView;
            vstPageControllerView.init();
        }
    }

    private boolean isAddNewPageViewVisible(int i) {
        int pageCount = this.mNote.getPageCount();
        if (pageCount < 0) {
            return false;
        }
        return (this.mComposerViewState.isTwoPageView() && pageCount % 2 == 1 && i == pageCount + (-3)) || i == pageCount + (-2);
    }

    private boolean isHideAddNewPageButton() {
        return !(DesktopModeCompat.INSTANCE.getInstance().isDexMode(this.mParent.getContext()) || FeatureInfo.isVSTModel()) || this.mNote.getPageMode() == SpenWNote.PageMode.SINGLE;
    }

    private void releaseVstControlView() {
        VstPageControllerView vstPageControllerView = this.mVstPageControllerView;
        if (vstPageControllerView != null) {
            vstPageControllerView.release();
        }
    }

    private boolean updateAddPageButtonVisibility() {
        if (this.mAddNewPageView == null || Looper.myLooper() != Looper.getMainLooper() || this.mSpenComposer.getNoteZoomScroller().getContentRectInView() == null) {
            return false;
        }
        this.mAddNewPageView.updateButtonVisibility(this.mComposerViewState.getComposerMode(), isAddNewPageViewVisible(this.mComposerViewState.getLastPageIndex()));
        return true;
    }

    public void init(SpenComposer spenComposer, SpenWNote spenWNote, ComposerViewContract.IPresenter iPresenter) {
        this.mNote = spenWNote;
        this.mSpenComposer = spenComposer;
        this.mPresenter = iPresenter;
        initVstPageControlView();
        initAddNewPageView();
        initPageTunerView();
        this.mComposerViewState.addStateChangeListener(this);
    }

    public void onAttached(ViewGroup viewGroup) {
        this.mParent = viewGroup;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.ComposerViewState.StateChangeListener
    public void onComposerModeChanged(int i, int i2) {
        if (i2 != 1) {
            updateAddPageButtonVisibility();
        } else if (updateAddPageButtonVisibility()) {
            this.mPresenter.getListenerManager().addPreTouchListener(this.mAddNewPageView.getPreTouchListener());
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.ComposerViewState.StateChangeListener
    public void onPageCountChanged(int i) {
        updateAddPageButtonVisibility();
        PageTunerButton pageTunerButton = this.mPageTurnerButton;
        if (pageTunerButton != null) {
            pageTunerButton.updatePageCount(i);
        }
        this.mPresenter.onPageCountChanged(i);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.composer.ComposerViewState.StateChangeListener
    public void onPageIndexChanged(int i, int i2) {
        AddNewPageView addNewPageView = this.mAddNewPageView;
        if (addNewPageView != null) {
            addNewPageView.updateButtonVisibility(this.mComposerViewState.getComposerMode(), isAddNewPageViewVisible(i2));
        }
        PageTunerButton pageTunerButton = this.mPageTurnerButton;
        if (pageTunerButton != null) {
            pageTunerButton.updateCurrentPageIndex(i2);
        }
        this.mPresenter.onPageIndexChanged(i2);
    }

    public void onPageLayoutChanged() {
        ComposerViewContract.IPresenter iPresenter = this.mPresenter;
        if (iPresenter != null) {
            iPresenter.onPageLayoutChanged();
        }
        if (DeviceInfo.isVSTModel()) {
            updatePageTurnerButton();
        }
    }

    public void release() {
        if (this.mAddNewPageView != null) {
            this.mPresenter.getListenerManager().removePreTouchListener(this.mAddNewPageView.getPreTouchListener());
        }
        releaseVstControlView();
    }

    public void updatePageTurnerButton() {
        PageTunerButton pageTunerButton = this.mPageTurnerButton;
        if (pageTunerButton != null) {
            pageTunerButton.updateButtonImg();
        }
    }
}
