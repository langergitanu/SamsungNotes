package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.search;

import android.content.Intent;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.sdk.composer.document.search.SearchData;
import com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.common.SpenDocumentInitializer;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.widget.search.VoiceButtonHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.NoteManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.controller.search.SearchModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SearchController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SoftInputManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.MenuPresenterContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.search.SearchModeContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.voice.STTPresenterImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerRequestCode;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.constants.SharedPreferencesConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.widget.view.SpenComposerWrapper;
import java.util.ArrayList;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SearchModePresenter implements SearchController.SearchCallback, NoteManager.ObserverBackgroundColor {
    private static final String TAG = Logger.createTag("SearchModePresenter");
    private ComposerModel mComposerModel;
    private ComposerViewPresenter mComposerViewPresenter;
    private MenuPresenterContract.IMenuManager mMenuManager;
    private View.OnTouchListener mOnTouchListener;
    private STTPresenterImpl mSTTPresenter;
    private ScrollGestureListener mScrollGestureListener;
    private SearchController mSearchController;
    private String mSearchText;
    private SoftInputManager mSoftInputManager;
    private SearchModeContract.IView mView;
    private VoiceRecordMenuPresenter mVoiceRecordMenuPresenter;
    private MoveToFirstSearchResult rMoveToFirstSearchResult = null;
    private boolean isSearchSTT = false;
    private int mCurrentVoiceSearchIndex = -1;
    private ArrayList<Integer> mVoiceSearchIndexList = new ArrayList<>();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class MoveToFirstSearchResult implements Runnable {
        public /* synthetic */ MoveToFirstSearchResult(SearchModePresenter searchModePresenter, int i) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            Logger.m10999d(SearchModePresenter.TAG, "rMoveToFirstSearchResult# ");
            if (SearchModePresenter.this.mView == null) {
                return;
            }
            SearchModePresenter.this.forwardComposer();
            SearchModePresenter.this.rMoveToFirstSearchResult = null;
        }

        private MoveToFirstSearchResult() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ScrollGestureListener extends GestureDetector.SimpleOnGestureListener {
        int direction;

        public /* synthetic */ ScrollGestureListener(SearchModePresenter searchModePresenter, int i) {
            this();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f4) {
            if ((this.direction == 0 ? Math.abs(f4) : Math.abs(f)) <= 20.0f || !SearchModePresenter.this.mSoftInputManager.isInputMethodShown()) {
                return false;
            }
            SearchModePresenter.this.mSoftInputManager.minimizeSoftInput(SearchModePresenter.this.mView.getView());
            return false;
        }

        public void setDirection(int i) {
            this.direction = i;
        }

        private ScrollGestureListener() {
        }
    }

    private void clearSearchFocusComposer(SearchModel searchModel) {
        searchModel.setCurrent(-1);
        this.mComposerViewPresenter.getSearchController().setSearchFocus(-1);
    }

    private float getTopMargin(int i) {
        if (i == 0) {
            return 0.0f;
        }
        this.mComposerViewPresenter.getView().getLocationInWindow(new int[2]);
        return SpenDocumentInitializer.INSTANCE.convertDpToNoteValue(this.mComposerViewPresenter.getDoc(), ResourceUtils.convertPxToDp(this.mComposerViewPresenter.getActivity(), i));
    }

    private void initVoiceList(String str) {
        if (!str.isEmpty()) {
            this.mVoiceSearchIndexList = this.mSTTPresenter.getVoiceListBySearch(str);
        }
        if (this.mVoiceSearchIndexList.isEmpty()) {
            this.isSearchSTT = false;
            this.mCurrentVoiceSearchIndex = -1;
        } else {
            this.isSearchSTT = true;
            this.mCurrentVoiceSearchIndex = 0;
        }
        AbstractC8014b.m7221w(new StringBuilder("initVoiceList# current index: "), TAG, this.mCurrentVoiceSearchIndex);
    }

    private void initVoiceListChangeMode(String str) {
        if (this.mSTTPresenter.getVoiceDataList().isEmpty()) {
            return;
        }
        this.isSearchSTT = true;
        ArrayList<Integer> voiceListBySearch = this.mSTTPresenter.getVoiceListBySearch(str);
        this.mVoiceSearchIndexList = voiceListBySearch;
        if (voiceListBySearch.isEmpty()) {
            this.mCurrentVoiceSearchIndex = -1;
        } else {
            this.mCurrentVoiceSearchIndex = 0;
        }
        AbstractC8014b.m7221w(new StringBuilder("initVoiceListChangeMode# mCurrentVoiceSearchIndex = "), TAG, this.mCurrentVoiceSearchIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveToFirstSearchResult() {
        MoveToFirstSearchResult moveToFirstSearchResult = this.rMoveToFirstSearchResult;
        if (moveToFirstSearchResult != null) {
            moveToFirstSearchResult.run();
        }
    }

    private void releaseView() {
        SearchModeContract.IView iView = this.mView;
        if (iView != null) {
            iView.release();
        }
    }

    public void backward() {
        if (FeatureInfo.isSearchSTTInComposerEnabled()) {
            backwardBoth();
        } else {
            backwardComposer();
        }
    }

    public void backwardBoth() {
        if (backwardComposer() || !this.isSearchSTT) {
            return;
        }
        backwardSTT();
    }

    public boolean backwardComposer() {
        SearchModel searchData = this.mComposerModel.getSearchData();
        if (searchData == null || !searchData.canBackward()) {
            if (!FeatureInfo.isSearchSTTInComposerEnabled()) {
                return false;
            }
            clearSearchFocusComposer(searchData);
            return false;
        }
        searchData.setCurrent(this.mComposerViewPresenter.getSearchController().searchBackward());
        Logger.m10999d(TAG, "backward# " + searchData.getCurrent());
        if (FeatureInfo.isSearchSTTInComposerEnabled()) {
            updateBtn(searchData);
            return true;
        }
        this.mView.updateMoveButton(searchData.canForward(), searchData.canBackward());
        return true;
    }

    public boolean backwardSTT() {
        int currentIndex;
        SearchModel searchData = this.mComposerModel.getSearchData();
        if (this.mVoiceRecordMenuPresenter.isShowingAiResultView().booleanValue()) {
            currentIndex = -1;
        } else {
            currentIndex = this.mSTTPresenter.getCurrentIndex(true);
            AbstractC0000a.m3D(currentIndex, "backwardSTT# indexCurrentSearchSTT = ", TAG);
            if (currentIndex > -1) {
                showSTTSearch(this.mSearchText, true, currentIndex);
                this.mView.updateMoveButton(true, this.mSTTPresenter.canBackward());
            }
        }
        if (currentIndex != -1 || this.mSTTPresenter.searchBackward()) {
            updateBtn(searchData);
            clearSearchFocusComposer(searchData);
            return true;
        }
        this.mCurrentVoiceSearchIndex--;
        AbstractC8014b.m7195A(new StringBuilder("backwardSTT# mCurrentVoiceSearchIndex = "), TAG, this.mCurrentVoiceSearchIndex);
        int i = this.mCurrentVoiceSearchIndex;
        if (i < 0 || i >= this.mVoiceSearchIndexList.size()) {
            updateBtn(searchData);
            return false;
        }
        showSTTSearch(this.mSearchText, true, -1);
        clearSearchFocusComposer(searchData);
        this.mView.updateMoveButton(true, true);
        return true;
    }

    public void clearSearchInfo() {
        this.mComposerModel.setSearchData(null);
        ComposerViewPresenter composerViewPresenter = this.mComposerViewPresenter;
        if (composerViewPresenter != null) {
            composerViewPresenter.getSearchController().search("", false);
        }
    }

    public void clearSearchSTT() {
        if (FeatureInfo.isSupportSTTFunction() && this.isSearchSTT) {
            if (!this.mVoiceSearchIndexList.isEmpty()) {
                this.mVoiceSearchIndexList.clear();
                this.mSTTPresenter.clearSTTSearchComposerMode();
                this.mVoiceRecordMenuPresenter.clearSearchComposer();
            }
            this.isSearchSTT = false;
            this.mCurrentVoiceSearchIndex = -1;
            AbstractC8014b.m7221w(new StringBuilder("clearSearchSTT# mCurrentVoiceSearchIndex = "), TAG, this.mCurrentVoiceSearchIndex);
        }
    }

    public void disableComposerFocusableInTouchMode() {
        this.mComposerViewPresenter.getView().setFocusableInTouchMode(false);
    }

    public void enableComposerFocusableInTouchMode() {
        this.mComposerViewPresenter.getView().setFocusableInTouchMode(true);
        this.mComposerViewPresenter.getView().requestFocus();
    }

    public void forward() {
        if (FeatureInfo.isSearchSTTInComposerEnabled()) {
            forwardBoth();
        } else {
            forwardComposer();
        }
    }

    public void forwardBoth() {
        if (this.isSearchSTT && forwardSTT()) {
            return;
        }
        forwardComposer();
    }

    public void forwardComposer() {
        SearchModel searchData = this.mComposerModel.getSearchData();
        if (searchData == null || !searchData.canForward()) {
            return;
        }
        searchData.setCurrent(this.mComposerViewPresenter.getSearchController().searchForward());
        Logger.m10999d(TAG, "forward# " + searchData.getCurrent());
        if (FeatureInfo.isSearchSTTInComposerEnabled()) {
            updateBtn(searchData);
        } else {
            this.mView.updateMoveButton(searchData.canForward(), searchData.canBackward());
        }
    }

    public boolean forwardSTT() {
        int currentIndex;
        SearchModel searchData = this.mComposerModel.getSearchData();
        if (this.mVoiceRecordMenuPresenter.isShowingAiResultView().booleanValue()) {
            currentIndex = -1;
        } else {
            currentIndex = this.mSTTPresenter.getCurrentIndex(false);
            AbstractC8014b.m7217s(currentIndex, "forwardSTT# indexCurrentSearchSTT = ", TAG);
            if (currentIndex > -1) {
                showSTTSearch(this.mSearchText, false, currentIndex);
                this.mView.updateMoveButton(this.mSTTPresenter.canForward(), true);
            }
        }
        if (currentIndex != -1 || this.mSTTPresenter.searchForward()) {
            updateBtn(searchData);
            clearSearchFocusComposer(searchData);
            return true;
        }
        if (this.mCurrentVoiceSearchIndex < this.mVoiceSearchIndexList.size()) {
            this.mCurrentVoiceSearchIndex++;
        }
        AbstractC8014b.m7221w(new StringBuilder("forwardSTT# mCurrentVoiceSearchIndex = "), TAG, this.mCurrentVoiceSearchIndex);
        if (this.mCurrentVoiceSearchIndex < this.mVoiceSearchIndexList.size()) {
            showSTTSearch(this.mSearchText, false, -1);
            clearSearchFocusComposer(searchData);
            return true;
        }
        this.mSTTPresenter.getMSTTSearchPresenter().clearSearchFocus();
        updateBtn(searchData);
        return false;
    }

    public int getBackgroundColor() {
        return this.mComposerViewPresenter.getBackgroundColor();
    }

    public boolean hasBackgroundImage() {
        return this.mComposerViewPresenter.hasBackgroundImage();
    }

    public void hide() {
        this.mView.hide();
        this.mSoftInputManager.setLockViewEnabled(false, this.mView.getView());
    }

    public void hideSoftInput(View view) {
        Logger.m11003i(TAG, "hideSoftInput#");
        if (this.mComposerModel.getModeManager().isMode(Mode.Text)) {
            return;
        }
        this.mSoftInputManager.hide(view);
    }

    public void init(MenuPresenterContract.IMenuManager iMenuManager, ComposerViewPresenter composerViewPresenter, ControllerManager controllerManager, ComposerModel composerModel, VoiceRecordMenuPresenter voiceRecordMenuPresenter) {
        this.mMenuManager = iMenuManager;
        this.mComposerViewPresenter = composerViewPresenter;
        this.mSearchController = controllerManager.getSearchController();
        this.mSoftInputManager = controllerManager.getSoftInputManager();
        this.mComposerModel = composerModel;
        this.mVoiceRecordMenuPresenter = voiceRecordMenuPresenter;
        if (FeatureInfo.isSearchSTTInComposerEnabled()) {
            this.mSTTPresenter = this.mVoiceRecordMenuPresenter.getSTTPresenter();
        }
        this.mScrollGestureListener = new ScrollGestureListener(this, 0);
        final GestureDetector gestureDetector = new GestureDetector(composerViewPresenter.getActivity(), this.mScrollGestureListener);
        this.mOnTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.search.SearchModePresenter.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                gestureDetector.onTouchEvent(motionEvent);
                return false;
            }
        };
        this.mComposerViewPresenter.getNoteManager().addBackgroundColorObserver(this);
    }

    public boolean isBackgroundColorInverted() {
        return this.mComposerViewPresenter.isBackgroundColorInverted();
    }

    public boolean isFullScreenMode() {
        return this.mComposerModel.getComposerState().isFullScreenMode();
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        String queryFromResult = VoiceButtonHelper.getQueryFromResult(i2, intent, ComposerRequestCode.SearchVoiceSvi == ComposerRequestCode.get(i));
        if (queryFromResult != null) {
            this.mView.setSearchText(queryFromResult);
        }
        return true;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.SearchController.SearchCallback
    @WorkerThread
    public void onAfterSearchOnThread() {
    }

    public boolean onBackPressed() {
        SearchModeContract.IView iView = this.mView;
        if (iView == null || !iView.isShowing()) {
            return false;
        }
        if (this.mComposerModel.getModeManager().isMode(Mode.Search)) {
            this.mSearchController.cancel();
            if (this.mComposerModel.isSupportedViewMode()) {
                this.mComposerModel.getModeManager().setMode(Mode.View, "search hide", true);
            } else {
                SoftInputManager softInputManager = this.mSoftInputManager;
                String str = TAG;
                softInputManager.blockToShow(true, str);
                Mode prevMode = this.mComposerModel.getModeManager().getPrevMode();
                Mode mode = Mode.Text;
                if (prevMode == mode && this.mView.isStatusBarHidden() && this.mSoftInputManager.isSipShowing()) {
                    this.mSoftInputManager.hide((View) null);
                }
                if (prevMode != mode && prevMode != Mode.Writing && prevMode != Mode.ReadOnly) {
                    prevMode = this.mComposerModel.getModeManager().getLastEditMode();
                }
                this.mComposerModel.getModeManager().setMode(prevMode, "search hide", true);
                this.mSoftInputManager.blockToShow(false, str);
            }
        }
        return true;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.SearchController.SearchCallback
    @WorkerThread
    public void onBeforeSearchOnThread(SearchModel searchModel) {
        if (this.mView == null || searchModel == null) {
            return;
        }
        this.mComposerModel.setSearchData(searchModel);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.composer.NoteManager.ObserverBackgroundColor
    public void onChangedBackgroundColor(int i, boolean z, boolean z2) {
        SearchModeContract.IView iView = this.mView;
        if (iView == null || !iView.isShowing()) {
            return;
        }
        this.mView.setColorTheme(i, z, z2);
    }

    public void onDestroy() {
        SearchController searchController = this.mSearchController;
        if (searchController != null) {
            searchController.cancel();
        }
        releaseView();
    }

    public void onDetachView() {
        SearchModeContract.IView iView;
        this.mSearchController.cancel();
        if (this.rMoveToFirstSearchResult != null && (iView = this.mView) != null && iView.getView() != null) {
            this.mView.getView().removeCallbacks(this.rMoveToFirstSearchResult);
        }
        releaseView();
        this.mView = null;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.SearchController.SearchCallback
    public void onPreSearchCancel() {
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        this.mComposerModel.getSearchData();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.SearchController.SearchCallback
    @MainThread
    public void onSearchDone(SearchModel searchModel) {
        Logger.m10999d(TAG, "onSearchDone#");
        if (this.mView == null) {
            return;
        }
        this.mComposerModel.setSearchData(searchModel);
        if (this.mComposerModel.getModeManager().isMode(Mode.Search)) {
            if (FeatureInfo.isSearchSTTInComposerEnabled()) {
                updateBtn(searchModel);
            } else {
                this.mView.updateMoveButton(searchModel.canForward(), searchModel.canBackward());
            }
            moveToFirstSearchResult();
            this.mMenuManager.onSearchDone(searchModel.getKeyword());
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.SearchController.SearchCallback
    @MainThread
    public void onSearchReady() {
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.SearchController.SearchCallback
    public void onUpdateMoveBtn() {
        Logger.m10999d(TAG, "onUpdateMoveBtn#");
        SearchModel searchData = this.mComposerModel.getSearchData();
        if (searchData != null) {
            if (FeatureInfo.isSearchSTTInComposerEnabled()) {
                updateBtn(searchData);
            } else {
                this.mView.updateMoveButton(searchData.canForward(), searchData.canBackward());
            }
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.SearchController.SearchCallback
    @WorkerThread
    public void onUpdateSearchingResult(int i, SearchData searchData) {
        ComposerModel composerModel;
        final SearchModel searchData2;
        if (this.mView == null || (composerModel = this.mComposerModel) == null || !composerModel.getModeManager().isMode(Mode.Search) || (searchData2 = this.mComposerModel.getSearchData()) == null) {
            return;
        }
        int count = searchData2.getCount();
        searchData2.setCount(i);
        if (count == 0) {
            this.mView.getView().post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.search.SearchModePresenter.2
                @Override // java.lang.Runnable
                public void run() {
                    if (SearchModePresenter.this.mView == null) {
                        return;
                    }
                    SearchModePresenter.this.mView.updateMoveButton(searchData2.canForward(), searchData2.canBackward());
                    SearchModePresenter.this.moveToFirstSearchResult();
                }
            });
        }
    }

    public boolean onWindowFocusChanged(boolean z) {
        SearchModeContract.IView iView = this.mView;
        if (iView == null || !iView.isShowing() || !z) {
            return false;
        }
        if (this.mView.hasFocusSearchText()) {
            return true;
        }
        hideSoftInput(this.mView.getView());
        return true;
    }

    public void releaseListener() {
        this.mComposerViewPresenter.getView().setOnTouchListener(null);
    }

    public void restoreState(Bundle bundle) {
    }

    public void search(String str) {
        this.mSearchController.search(str, this, false);
    }

    public void searchSTT(String str, boolean z) {
        initVoiceList(str);
        this.mSearchText = str;
        if (this.isSearchSTT) {
            this.mVoiceRecordMenuPresenter.search(str, z);
        }
    }

    public void setFadingEdgeEffectEnabled(boolean z) {
        View view = this.mComposerViewPresenter.getView();
        if (view instanceof SpenComposerWrapper) {
            ((SpenComposerWrapper) view).setFadingEdgeEnabled(z && this.mComposerViewPresenter.getComposerControllerManager().getCvPageSettingController().getPageLayoutState().isVertical());
        }
    }

    public void setListener() {
        this.mComposerViewPresenter.getView().setOnTouchListener(this.mOnTouchListener);
    }

    public void setMargin(boolean z, int i) {
        PointF pointFConvertViewPointIntoContentPoint;
        PointF pointFConvertViewPointIntoContentPoint2;
        PointF pan = this.mComposerViewPresenter.getComposerControllerManager().getScrollController().getPan();
        String str = TAG;
        StringBuilder sbM3200j = AbstractC4539a.m3200j("setMargin# ", " cur: ", z);
        sbM3200j.append(pan.y);
        Logger.m10999d(str, sbM3200j.toString());
        ISpenNoteZoomScroller noteZoomScroller = this.mComposerViewPresenter.getObjectManager().getNoteZoomScroller();
        if (!z) {
            if (noteZoomScroller.getContentMargin() != null && (pointFConvertViewPointIntoContentPoint = noteZoomScroller.convertViewPointIntoContentPoint(new PointF(0.0f, i))) != null) {
                noteZoomScroller.setPan(new PointF(pan.x, pointFConvertViewPointIntoContentPoint.y));
            }
            noteZoomScroller.setContentMargin(new RectF());
            return;
        }
        float topMargin = getTopMargin(i);
        float fConvertDpToNoteValue = SpenDocumentInitializer.INSTANCE.convertDpToNoteValue(this.mComposerViewPresenter.getDoc(), 80.0f);
        Logger.m10999d(str, "setMargin# " + topMargin);
        noteZoomScroller.setContentMargin(new RectF(0.0f, topMargin, 0.0f, fConvertDpToNoteValue));
        if (topMargin == 0.0f || (pointFConvertViewPointIntoContentPoint2 = noteZoomScroller.convertViewPointIntoContentPoint(new PointF(0.0f, -i))) == null) {
            return;
        }
        noteZoomScroller.setPan(new PointF(pan.x, pointFConvertViewPointIntoContentPoint2.y));
    }

    public void setSipAdjustResize() {
        this.mSoftInputManager.setTemporarySoftInputMode(16);
    }

    public void setView(SearchModeContract.IView iView) {
        this.mView = iView;
    }

    public void show(String str) {
        this.mSearchText = str;
        int i = 0;
        this.mScrollGestureListener.setDirection(SharedPreferencesCompat.getInstance("Composer").getInt(SharedPreferencesConstants.COMPOSER_SP_KEY_SCROLLING_DIRECTION, 0));
        if (!TextUtils.isEmpty(str)) {
            Logger.m11003i(TAG, "show# ");
            this.rMoveToFirstSearchResult = new MoveToFirstSearchResult(this, i);
        }
        if (FeatureInfo.isSearchSTTInComposerEnabled()) {
            showSTTSearch(str, false, -1);
        }
        setSipAdjustResize();
        this.mView.show(str);
        this.mSoftInputManager.setLockViewEnabled(true, this.mView.getView());
    }

    public void showSTTSearch(String str, boolean z, int i) {
        int i2;
        if (!this.isSearchSTT || (i2 = this.mCurrentVoiceSearchIndex) < 0 || i2 >= this.mVoiceSearchIndexList.size()) {
            return;
        }
        this.mVoiceRecordMenuPresenter.onSTTItemShowSearchFromComposer(this.mVoiceSearchIndexList.get(this.mCurrentVoiceSearchIndex).intValue(), str, z, i);
    }

    public void showSoftInput(View view) {
        Logger.m11003i(TAG, "showSoftInput#");
        this.mSoftInputManager.blockToHide(true);
        this.mSoftInputManager.show(view);
        view.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.search.SearchModePresenter.3
            @Override // java.lang.Runnable
            public void run() {
                SearchModePresenter.this.mSoftInputManager.blockToHide(false);
            }
        });
    }

    public void showWithChangeMode(String str) {
        initVoiceListChangeMode(str);
        show(str);
    }

    public void stopActionMode() {
        this.mComposerViewPresenter.setContextMenu(false);
    }

    public void submitSearchSTT(String str, boolean z) {
        initVoiceList(str);
        this.mSearchText = str;
        if (this.isSearchSTT) {
            showSTTSearch(str, z, -1);
        }
    }

    public void updateBtn(SearchModel searchModel) {
        boolean z;
        boolean zCanBackward = false;
        if (this.mSearchText.isEmpty()) {
            z = false;
        } else {
            boolean zCanForward = this.isSearchSTT ? this.mCurrentVoiceSearchIndex < this.mVoiceSearchIndexList.size() - 1 || this.mSTTPresenter.canForward() || searchModel.canForward() : searchModel.canForward();
            if (!this.isSearchSTT) {
                zCanBackward = searchModel.canBackward();
            } else if (this.mCurrentVoiceSearchIndex > 0 || this.mSTTPresenter.canBackward() || searchModel.canBackward()) {
                zCanBackward = true;
            }
            z = zCanBackward;
            zCanBackward = zCanForward;
        }
        this.mView.updateMoveButton(zCanBackward, z);
    }
}
