package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.widget.search.VoiceButtonHelper;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiBixbyParam;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiCommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiViewUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.common.AiDrawingUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AiMenuContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AiMenuResultViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AutoFormat;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.RecognizedHw;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.ResultOperation;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.STTSummarization;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.STTSummarizationStreaming;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.STTTabletLayoutAction;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.SrcContentInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.Summarization;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.Translation;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AiMenuResultCommonViews;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AiMenuResultLayoutManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AiMenuResultViewRecognizedHw;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AiMenuResultViewSummarization;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AiMenuResultViewTranslation;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AutoFormatResultViewManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.CreateImageResultViewManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.PageIndicator;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.SimpleEditView;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.progress.AiResultContinuesProgress;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerRequestCode;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.NavigationBarUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.p157ai.drawing.common.AiDrawingRequestPopup;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.p157ai.drawing.generate.AiDrawingRequestLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.stt.ISTTWindow;
import com.samsung.android.support.senl.p148nt.stt.base.model.mode.STTMode;
import com.samsung.android.support.senl.p148nt.stt.presenter.AiMenuSTTProcessListener;
import com.samsung.android.support.senl.p148nt.stt.presenter.STTPresenter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import p001A.AbstractC0000a;
import p012C1.RunnableC0050f;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiMenuResultView implements AiMenuContract.IView {
    private static final String TAG = Logger.createTag("AiMenuResultView", AiConstants.PREFIX_TAG);
    private static final int TOUCHSLOP_AUTOFORMAT = 100;
    AiMenuResultViewAnimation mAnimation;
    AutoFormatResultViewManager mAutoFormatResultViewManager;
    AiMenuResultCommonViews mCommonViews;
    CreateImageResultViewManager mCreateImageViewManager;
    boolean mIsShowing;
    AiMenuResultLayoutManager mLayoutManager;
    ViewPager2.OnPageChangeCallback mOnPageChangeCallback;
    List<AiMenuContract.IAiActionResultView> mPageTypeList;
    AiMenuResultViewPresenter mPresenter;
    int mPreviousPageIndex;
    ResultViewAdapter mResultViewAdapter;
    View mView;
    ViewPager2 mViewPager;
    private boolean isRestore = false;
    PageIndicator mPageIndicator = new PageIndicator();
    boolean mOnSavedInstanceState = false;
    int mIsMoveBlockingCnt = 0;
    int mCurrentPageIndex = 1;
    int mScrollState = 0;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultView$14 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C957714 implements AiMenuContract.IAiActionSTTResultContainer {
        public C957714() {
        }

        private void checkSTTSummarizeCondition(boolean z, int i) {
            STTPresenter sTTPresenter = AiMenuResultView.this.mPresenter.getSTTTabletLayoutAction().getIAiSTTContract().getSTTPresenter();
            AiMenuResultViewSTTSummarization aiMenuResultViewSTTSummarization = (AiMenuResultViewSTTSummarization) AiMenuResultView.this.mPageTypeList.get(i);
            int mItemIndexToShow = sTTPresenter.getMItemIndexToShow();
            if (AiMenuResultView.this.isRestore) {
                return;
            }
            if ((sTTPresenter.getVoiceDataController().isHaveSTTData(mItemIndexToShow) || !sTTPresenter.getVoiceDataList().isEmpty()) && !aiMenuResultViewSTTSummarization.updateInfoView()) {
                AiMenuResultView.this.mCommonViews.showProgress(2);
                AiMenuResultViewPresenter aiMenuResultViewPresenter = AiMenuResultView.this.mPresenter;
                aiMenuResultViewPresenter.executeSTTSummarize(aiMenuResultViewPresenter.getSTTTabletLayoutAction().getIAiSTTContract(), z);
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionSTTResultContainer
        public void executeSummarize(boolean z) {
            AiMenuResultView.this.sttKeepOnlyView(new Class[]{AiMenuResultViewSTT.class, AiMenuResultViewSTTSummarization.class}, new Class[]{STTTabletLayoutAction.class, STTSummarization.class, STTSummarizationStreaming.class});
            int size = 0;
            while (true) {
                if (size >= AiMenuResultView.this.mPageTypeList.size()) {
                    size = -1;
                    break;
                } else {
                    if (AiMenuResultView.this.mPageTypeList.get(size) instanceof AiMenuResultViewSTTSummarization) {
                        Logger.m10999d(AiMenuResultView.TAG, "createSTTSummarizationView already exist");
                        break;
                    }
                    size++;
                }
            }
            STTPresenter sTTPresenter = AiMenuResultView.this.mPresenter.getSTTTabletLayoutAction().getIAiSTTContract().getSTTPresenter();
            if (size == -1) {
                AiMenuResultView.this.updateExecuteState(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultView.14.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AiMenuResultViewPresenter aiMenuResultViewPresenter = AiMenuResultView.this.mPresenter;
                        aiMenuResultViewPresenter.initSTTSummarize(aiMenuResultViewPresenter.getSTTTabletLayoutAction().getIAiSTTContract());
                        AiMenuResultView.this.createSTTSummarizationView();
                    }
                });
                size = AiMenuResultView.this.mPageTypeList.size() - 1;
            } else if (AiMenuResultView.this.mViewPager.getCurrentItem() != size && sTTPresenter.getIsNeedSummaryAgain()) {
                sTTPresenter.setNeedSummaryAgain(false);
            }
            AiMenuResultView.this.setCurrentItemViewPager(size, true);
            checkSTTSummarizeCondition(z, size);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionSTTResultContainer
        public void executeTranscribeAgain() {
            AiMenuResultView.this.sttKeepOnlyView(new Class[]{AiMenuResultViewSTT.class}, new Class[]{STTTabletLayoutAction.class});
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultContainer
        public Activity getActivity() {
            return AiMenuResultView.this.mPresenter.getActivity();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionSTTResultContainer
        public boolean isMinimizeView() {
            return AiMenuResultView.this.mLayoutManager.isMinimizeView();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionSTTResultContainer
        public void onTabSelected(int i) {
            if (AiMenuResultView.this.mPresenter.getSTTTabletLayoutAction() == null) {
                return;
            }
            final STTPresenter sTTPresenter = AiMenuResultView.this.mPresenter.getSTTTabletLayoutAction().getIAiSTTContract().getSTTPresenter();
            AiMenuResultView.this.mLayoutManager.setEnabledFlickAnimation(false);
            if ((AiMenuResultView.this.mPageTypeList.size() != 1 || i <= 0) && !sTTPresenter.getIsNeedSummaryAgain()) {
                if (AiMenuResultView.this.mPageTypeList.size() == 2) {
                    AiMenuResultView.this.setCurrentItemViewPager(i, true);
                    return;
                }
                return;
            }
            final boolean[] zArr = {false};
            AiCommonUtil.executeActionByServer(getActivity(), new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultView.14.2
                @Override // java.lang.Runnable
                public void run() {
                    zArr[0] = true;
                    C957714.this.executeSummarize(sTTPresenter.getIsNeedSummaryAgain());
                }
            });
            if (zArr[0]) {
                sTTPresenter.setNeedSummaryAgain(false);
                return;
            }
            TabLayout.Tab tabAt = AiMenuResultView.this.mCommonViews.getTopView().mTabLayout.getTabAt(0);
            if (tabAt != null) {
                tabAt.select();
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionSTTResultContainer
        public void onVoiceInfoChanged() {
            for (AiMenuContract.IAiActionResultView iAiActionResultView : AiMenuResultView.this.mPageTypeList) {
                if (!(iAiActionResultView instanceof AiMenuResultViewSTT) && (iAiActionResultView instanceof AiMenuSTTProcessListener)) {
                    ((AiMenuSTTProcessListener) iAiActionResultView).onVoiceInfoChanged();
                }
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultContainer
        public void updateResultState(boolean z, boolean z2) {
            Logger.m10999d(AiMenuResultView.TAG, "createSTTView# updateResultState success " + z + " completed " + z2);
            if (z && z2) {
                AiMenuResultView.this.postExecuteDirectResultAction();
            }
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultView$17 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C958017 implements AutoFormatResultViewManager.Contract {
        public C958017() {
        }

        private int getStreamingResultViewIndex() {
            int i = 0;
            while (i < AiMenuResultView.this.mPageTypeList.size() && !(AiMenuResultView.this.mPageTypeList.get(i) instanceof AutoFormatStreamingResultView)) {
                i++;
            }
            if (i >= AiMenuResultView.this.mPageTypeList.size()) {
                return -1;
            }
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$updateResultState$0(AutoFormatResultView autoFormatResultView) {
            autoFormatResultView.scrollToPosition(SimpleEditView.SCROLL_POSITION.TOP);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$updateResultState$1() {
            AiMenuResultView.this.executeDirectResultAction();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultContainer
        public Activity getActivity() {
            return AiMenuResultView.this.mPresenter.getActivity();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AutoFormatResultViewManager.Contract
        public boolean updateEditedRecognizedHw() {
            return AiMenuResultView.this.updateEditedRecognizedHw();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AutoFormatResultViewManager.Contract
        @SuppressLint({"NotifyDataSetChanged"})
        public void updatePages() {
            boolean z = false;
            if (AiMenuResultView.this.mPresenter.getAutoFormat().getErrorType() == null) {
                for (AutoFormatResultView autoFormatResultView : AiMenuResultView.this.mAutoFormatResultViewManager.getAutoFormatResultViewList()) {
                    if (!AiMenuResultView.this.mPageTypeList.contains(autoFormatResultView)) {
                        AiMenuResultView.this.mPageTypeList.add(autoFormatResultView);
                        z = true;
                    }
                }
            } else {
                Iterator<AiMenuContract.IAiActionResultView> it = AiMenuResultView.this.mPageTypeList.iterator();
                int i = 0;
                while (it.hasNext()) {
                    if (it.next() instanceof AutoFormatResultView) {
                        if (i > 0) {
                            it.remove();
                            z = true;
                        }
                        i++;
                    }
                }
            }
            if (!z || AiMenuResultView.this.mViewPager.getAdapter() == null) {
                return;
            }
            AiMenuResultView.this.mPageIndicator.updateIndicator();
            AiMenuResultView.this.mViewPager.getAdapter().notifyDataSetChanged();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultContainer
        public void updateResultState(boolean z, boolean z2) {
            if (AiMenuResultView.this.mPageTypeList.isEmpty()) {
                AiMenuResultView.this.mCommonViews.hideProgress();
                return;
            }
            int streamingResultViewIndex = getStreamingResultViewIndex();
            if (streamingResultViewIndex >= 0) {
                AiMenuResultView.this.mPageTypeList.remove(streamingResultViewIndex);
                AiMenuResultView.this.mResultViewAdapter.notifyItemRemoved(streamingResultViewIndex);
                List<AutoFormatResultView> autoFormatResultViewList = AiMenuResultView.this.mAutoFormatResultViewManager.getAutoFormatResultViewList();
                AiMenuResultView.this.mPageTypeList.addAll(autoFormatResultViewList);
                AiMenuResultView.this.mResultViewAdapter.notifyItemRangeInserted(streamingResultViewIndex, autoFormatResultViewList.size());
            } else {
                Logger.m11004w(AiMenuResultView.TAG, "get AutoFormatStreamingResultView index failed");
            }
            int i = 0;
            while (true) {
                if (i >= AiMenuResultView.this.mPageTypeList.size()) {
                    break;
                }
                AiMenuContract.IAiActionResultView iAiActionResultView = AiMenuResultView.this.mPageTypeList.get(i);
                if (iAiActionResultView instanceof AutoFormatResultView) {
                    AiMenuResultView.this.mPresenter.getHandler().post(new RunnableC9711g((AutoFormatResultView) iAiActionResultView, 0));
                    break;
                }
                i++;
            }
            if (z) {
                AiMenuResultView aiMenuResultView = AiMenuResultView.this;
                aiMenuResultView.mAnimation.runMoveToResultPageAnimation(aiMenuResultView.mViewPager, i - 1, new RunnableC9711g(this, 1));
                AiMenuResultView.this.mPageIndicator.updateIndicator(i);
            } else {
                AiMenuResultView.this.setCurrentItemViewPager(i, true);
            }
            AiMenuResultView.this.mPageTypeList.get(i).setTitle();
            AiMenuResultView.this.mCommonViews.getTopView().mSettingBtn.setVisibility(8);
            AiMenuResultView.this.mCommonViews.getTopView().mContextBtn.setVisibility(8);
            View view = AiMenuResultView.this.mCommonViews.getTopView().mDisclaimerBtn;
            view.setVisibility(0);
            if (view.isEnabled()) {
                view.setAlpha(1.0f);
            }
            AiMenuResultView.this.mCommonViews.hideProgress();
            AiMenuResultView.this.mCommonViews.setBottomButtonsState(true);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultContainer
        public void updateStreamingState() {
            int streamingResultViewIndex = getStreamingResultViewIndex();
            if (streamingResultViewIndex < 0) {
                int i = 0;
                while (i < AiMenuResultView.this.mPageTypeList.size()) {
                    if (AiMenuResultView.this.mPageTypeList.get(i) instanceof AutoFormatResultView) {
                        AiMenuResultView.this.mPageTypeList.remove(i);
                        AiMenuResultView.this.mResultViewAdapter.notifyItemRemoved(i);
                    } else {
                        i++;
                    }
                }
                AiMenuResultView aiMenuResultView = AiMenuResultView.this;
                aiMenuResultView.mPageTypeList.add(((AutoFormatStreamingResultViewManager) aiMenuResultView.mAutoFormatResultViewManager).geAutoFormatStreamingResultView());
                AiMenuResultView.this.mResultViewAdapter.notifyItemInserted(r0.mPageTypeList.size() - 1);
                streamingResultViewIndex = getStreamingResultViewIndex();
            }
            AiMenuResultView aiMenuResultView2 = AiMenuResultView.this;
            aiMenuResultView2.mAnimation.runMoveToResultPageAnimation(aiMenuResultView2.mViewPager, streamingResultViewIndex - 1, null);
            AiMenuResultView.this.mPageTypeList.get(streamingResultViewIndex).setTitle();
            AiMenuResultView.this.mCommonViews.getTopView().mSettingBtn.setVisibility(8);
            AiMenuResultView.this.mCommonViews.getTopView().mContextBtn.setVisibility(8);
            AiMenuResultView.this.mCommonViews.hideProgress();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class OnPageChangeCallbackImpl extends ViewPager2.OnPageChangeCallback {
        public OnPageChangeCallbackImpl() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i) {
            AiMenuResultView.this.mLayoutManager.setScrollState(i);
            if (i == 1 || i == 0) {
                AiMenuResultView.this.mAnimation.getPageTransformer().setEventStartIndex(AiMenuResultView.this.mViewPager.getCurrentItem());
            }
            AiMenuResultView.this.mScrollState = i;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i, float f, int i2) {
            AiMenuResultView aiMenuResultView = AiMenuResultView.this;
            int i4 = aiMenuResultView.mCurrentPageIndex;
            if (i4 == 1 && i < i4 && aiMenuResultView.mScrollState == 1 && f > 0.0f) {
                aiMenuResultView.mCommonViews.getBottomView().hide(false);
            }
            if (!AiMenuResultView.this.mPageTypeList.get(i).isBottomMenuSupported() || AiMenuResultView.this.mCommonViews.getBottomView().isShowing()) {
                return;
            }
            AiMenuResultView.this.mCommonViews.getBottomView().show(false);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i) {
            TabLayout.Tab tabAt;
            AbstractC0000a.m3D(i, "onPageSelected# ", AiMenuResultView.TAG);
            if (AiMenuResultView.this.mPageTypeList.size() <= i || i < 0) {
                Logger.m11000e(AiMenuResultView.TAG, "out of bound");
                return;
            }
            AiMenuResultView aiMenuResultView = AiMenuResultView.this;
            aiMenuResultView.mCurrentPageIndex = i;
            if (aiMenuResultView.mPresenter.getSoftInputManager().isInputMethodShown()) {
                AiMenuResultView.this.mPresenter.getSoftInputManager().hide(AiMenuResultView.this.mViewPager);
            }
            AiMenuContract.IAiActionResultView iAiActionResultView = AiMenuResultView.this.mPageTypeList.get(i);
            AiMenuResultView.this.mCommonViews.setBottomButtonsState(iAiActionResultView.isBottomMenuSupported());
            if (iAiActionResultView.isBottomMenuSupported()) {
                AiMenuResultView.this.mCommonViews.getBottomView().show(true, true);
            } else {
                AiMenuResultView.this.mCommonViews.getBottomView().hide(false, false);
            }
            iAiActionResultView.onPageSelected();
            iAiActionResultView.setTitle();
            AiMenuResultView.this.mPageIndicator.updateIndicator(i);
            if ((iAiActionResultView instanceof AiMenuResultViewSTT) || (iAiActionResultView instanceof AiMenuResultViewSTTSummarization)) {
                ISTTWindow.IAIContract iAiSTTContract = AiMenuResultView.this.mPresenter.getSTTTabletLayoutAction().getIAiSTTContract();
                if (iAiSTTContract == null || ((iAiSTTContract.isCurrentVoiceHaveSTTData() && !iAiSTTContract.isEditMode()) || AiMenuResultView.this.mPresenter.getSTTTabletLayoutAction().isWorking())) {
                    AiMenuResultCommonViews aiMenuResultCommonViews = AiMenuResultView.this.mCommonViews;
                    ArrayList arrayList = new ArrayList(1);
                    Object obj = new Object[]{100}[0];
                    Objects.requireNonNull(obj);
                    arrayList.add(obj);
                    aiMenuResultCommonViews.setTopButtonsVisibility(Collections.unmodifiableList(arrayList));
                } else {
                    AiMenuResultView.this.mCommonViews.setTopButtonsVisibility(null);
                }
                if (i > 0 && (tabAt = AiMenuResultView.this.mCommonViews.getTopView().mTabLayout.getTabAt(i)) != null) {
                    tabAt.select();
                }
            }
            AiMenuResultView aiMenuResultView2 = AiMenuResultView.this;
            if (aiMenuResultView2.mPreviousPageIndex != 0 && i == 0) {
                ComposerSA.insertLog(aiMenuResultView2.mPresenter.isRecognizedHwAiResult() ? ComposerSAConstants.SCREEN_DIALOGS_CTT_RESULT : "802", ComposerSAConstants.EVENT_AI_ACCESS_TO_ORIGINAL);
            }
            AiMenuResultView aiMenuResultView3 = AiMenuResultView.this;
            aiMenuResultView3.mPreviousPageIndex = i;
            aiMenuResultView3.mPresenter.getHandler().post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultView.OnPageChangeCallbackImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    AiMenuResultView.this.mViewPager.requestTransform();
                }
            });
            AiMenuResultView.this.mCommonViews.getBottomView().hideAddToListPopup();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ResultViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        List<AiMenuContract.IAiActionResultView> mItemList;

        public ResultViewAdapter(List<AiMenuContract.IAiActionResultView> list) {
            this.mItemList = list;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.mItemList.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            if (AiMenuResultView.this.isCreateImageRunning()) {
                AiMenuContract.IAiActionResultView iAiActionResultView = this.mItemList.get(i);
                if (iAiActionResultView instanceof CreateImageResultView) {
                    ((CreateImageResultView) iAiActionResultView).updateLayout("onBindViewHolder");
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            AbstractC0000a.m3D(i, "onCreateViewHolder# ", AiMenuResultView.TAG);
            AiMenuContract.IAiActionResultView iAiActionResultView = this.mItemList.get(i);
            return AiMenuResultView.this.new ResultViewHolder(iAiActionResultView.inflateView(viewGroup), iAiActionResultView);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ResultViewHolder extends RecyclerView.ViewHolder {
        public ResultViewHolder(@NonNull View view, AiMenuContract.IAiActionResultView iAiActionResultView) {
            super(view);
            iAiActionResultView.initView(AiMenuResultView.this.mView, view);
        }
    }

    private void clearPages() {
        List<AiMenuContract.IAiActionResultView> list = this.mPageTypeList;
        if (list != null) {
            Iterator<AiMenuContract.IAiActionResultView> it = list.iterator();
            while (it.hasNext()) {
                it.next().clear();
            }
            this.mPageTypeList.clear();
        }
        AutoFormatResultViewManager autoFormatResultViewManager = this.mAutoFormatResultViewManager;
        if (autoFormatResultViewManager != null) {
            autoFormatResultViewManager.clear();
        }
        CreateImageResultViewManager createImageResultViewManager = this.mCreateImageViewManager;
        if (createImageResultViewManager != null) {
            createImageResultViewManager.clear("clearPages");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void close() {
        hide(new boolean[0]);
        hideSTTMode();
        releaseSelection();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createAutoFormatInternal(boolean z, boolean z2) {
        createAutoFormatInternal(z, true, z2);
    }

    private void createSTTView() {
        this.mCommonViews.getBottomView().setDisabled(true);
        this.mPageTypeList.add(new AiMenuResultViewSTT(this.mPresenter, this.mCommonViews, new C957714()));
    }

    private AiMenuResultViewTranslation.Contract createTranslationContract() {
        return new AiMenuResultViewTranslation.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultView.13
            private void updateBottomMenu() {
                AiMenuContract.IAiActionResultView currentResultView = AiMenuResultView.this.getCurrentResultView();
                if (currentResultView instanceof AiMenuResultViewTranslation) {
                    AiMenuResultView.this.mCommonViews.setBottomButtonsState(((AiMenuResultViewTranslation) currentResultView).isAvailableBottomMenu());
                    AiMenuResultView.this.mCommonViews.getBottomView().show(true);
                }
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultContainer
            public Activity getActivity() {
                return AiMenuResultView.this.mPresenter.getActivity();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewTranslation.Contract
            public void hide() {
                AiMenuResultView.this.hide(new boolean[0]);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewTranslation.Contract
            public boolean isSummaryTranslations() {
                return false;
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewTranslation.Contract
            public boolean updateEditedRecognizedHw() {
                return AiMenuResultView.this.updateEditedRecognizedHw();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultContainer
            public void updateResultState(boolean z, boolean z2) {
                if (!z) {
                    AiMenuResultView.this.removeErrorPage();
                    return;
                }
                if (AiMenuResultView.this.isBlockingMovePage()) {
                    return;
                }
                if (AiMenuResultView.this.mPresenter.getTranslation().isFirstResult()) {
                    int i = 0;
                    while (i < AiMenuResultView.this.mPageTypeList.size() && !(AiMenuResultView.this.mPageTypeList.get(i) instanceof AiMenuResultViewTranslation)) {
                        i++;
                    }
                    if (AiMenuResultView.this.mViewPager.getCurrentItem() != i) {
                        AiMenuResultView.this.movePage(i);
                        AiMenuResultView.this.mPageTypeList.get(i).setTitle();
                        AiMenuResultView.this.mCommonViews.getTopView().mSettingBtn.setVisibility(8);
                    }
                }
                if (z2) {
                    updateBottomMenu();
                    AiMenuResultView.this.postExecuteDirectResultAction();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeDirectResultAction() {
        int resultAction = this.mPresenter.getSrcContentInfo().getAiBixbyParam().getResultAction();
        AbstractC0000a.m3D(resultAction, "executeDirectResultAction# ", TAG);
        if (resultAction == 1) {
            this.mCommonViews.getBottomView().getCopyBtn().callOnClick();
        } else if (resultAction != 2) {
            if (resultAction == 3) {
                this.mCommonViews.getBottomView().addTo(this.mPresenter.isSinglePageNote() ? ResultOperation.AddTo.EndOfNote : ResultOperation.AddTo.NewPageBefore);
            } else if (resultAction == 4) {
                this.mCommonViews.getBottomView().addTo(ResultOperation.AddTo.NewNote);
            }
        } else if (this.mPresenter.canReplace()) {
            this.mCommonViews.getBottomView().getReplaceBtn().callOnClick();
        } else {
            ToastHandler.show(this.mView.getContext(), this.mView.getContext().getString(C9086R.string.could_not_run_something, this.mView.getContext().getString(C9086R.string.action_replace)), 0);
            this.mPresenter.getSrcContentInfo().setAiBixbyParam(new AiBixbyParam());
        }
        SrcContentInfo srcContentInfo = this.mPresenter.getSrcContentInfo();
        if (srcContentInfo != null) {
            srcContentInfo.getAiBixbyParam().clearResultAction();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AiMenuContract.IAiActionResultView getCurrentResultView() {
        List<AiMenuContract.IAiActionResultView> list;
        if (this.mViewPager == null || (list = this.mPageTypeList) == null || list.isEmpty()) {
            return null;
        }
        return this.mPageTypeList.get(this.mViewPager.getCurrentItem());
    }

    private void hideSTTMode() {
        ISTTWindow.IAIContract iAiSTTContract;
        if (this.mPresenter.getSTTTabletLayoutAction() == null || (iAiSTTContract = this.mPresenter.getSTTTabletLayoutAction().getIAiSTTContract()) == null) {
            return;
        }
        STTMode currentMode = iAiSTTContract.getSTTPresenter().getCurrentMode();
        if (currentMode == STTMode.EDIT) {
            iAiSTTContract.toggleEditMode();
        } else if (currentMode == STTMode.SELECTION) {
            iAiSTTContract.getSTTPresenter().toggleSTTSelectionMode(true);
        } else if (currentMode == STTMode.SELECTION_SUMMARY) {
            iAiSTTContract.getSTTPresenter().toggleSTTSelectionMode(false);
        }
    }

    private void initAnimation() {
        AiMenuResultViewAnimation aiMenuResultViewAnimation = new AiMenuResultViewAnimation(this.mCommonViews);
        this.mAnimation = aiMenuResultViewAnimation;
        aiMenuResultViewAnimation.initAnimation();
    }

    private void initIndicator(View view) {
        this.mPageIndicator.initIndicator(view, this.mViewPager, this.mPresenter.getSTTTabletLayoutAction() != null || (!this.mPresenter.isCreateImageRunning() && this.mPageTypeList.size() < 2));
        this.mPageIndicator.setOnIconClickListener(new PageIndicator.OnIconClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultView.6
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.PageIndicator.OnIconClickListener
            public void onClickListener(int i) {
                AiMenuResultView.this.setCurrentItemViewPager(i, true);
            }
        });
    }

    private void initPages() {
        RecognizedHw recognizedHw = this.mPresenter.getRecognizedHw();
        if (recognizedHw != null) {
            this.mPageTypeList.add(new AiMenuResultViewOriginalHw(this.mPresenter.getRecognizedHw(), this.mCommonViews));
            this.mPageTypeList.add(createRecognizedHwView());
            if (this.mPresenter.getAutoFormat() != null) {
                createAutoFormatInternal(false, AutoFormat.isLimitedMinLength(this.mView.getContext(), recognizedHw.getText(), false));
            } else if (this.mPresenter.getSummarization() != null) {
                createSummarizationView();
                if (!this.isRestore && !this.mPresenter.getSummarization().hasResult() && this.mPresenter.getSummarization().getErrorType() == null) {
                    this.mCommonViews.showProgress(2);
                }
            } else if (this.mPresenter.getTranslation() != null) {
                createTranslationView();
                if (!this.isRestore && TextUtils.isEmpty(this.mPresenter.getTranslation().getTranslatedText()) && this.mPresenter.getTranslation().getErrorType() == null) {
                    this.mCommonViews.showProgress(1);
                }
            }
        } else if (this.mPresenter.getAutoFormat() != null) {
            createAutoFormatInternal(true, false);
        } else if (this.mPresenter.getSummarization() != null) {
            this.mPageTypeList.add(new AiMenuResultViewSummaryOrigin(this.mPresenter.getSummarization(), this.mCommonViews));
            createSummarizationView();
            if (!this.isRestore) {
                this.mCommonViews.showProgress(2);
            }
        } else if (this.mPresenter.getSpellingCorrection() != null) {
            this.mPageTypeList.add(new AiMenuResultViewCorrectionOrigin(this.mPresenter.getSpellingCorrection(), this.mCommonViews));
            createSpellingCorrectionView();
            if (!this.isRestore) {
                this.mCommonViews.showProgress(5);
            }
        } else if (this.mPresenter.getSTTTabletLayoutAction() != null) {
            for (AiMenuContract.IAiAction iAiAction : this.mPresenter.getAiActions()) {
                if (iAiAction instanceof STTTabletLayoutAction) {
                    createSTTView();
                } else if (iAiAction instanceof STTSummarization) {
                    createSTTSummarizationView();
                }
            }
        } else if (this.mPresenter.getTranslation() != null) {
            this.mPageTypeList.add(new AiMenuResultViewTranslationOrigin(this.mPresenter.getTranslation(), this.mCommonViews));
            createTranslationView();
            if (!this.isRestore) {
                this.mCommonViews.showProgress(1);
            }
        } else {
            if (!this.mPresenter.isCreateImageRunning()) {
                Logger.m11000e(TAG, "initViewPager# unexpected case");
                this.isRestore = false;
            }
            CreateImageResultViewManager createImageResultViewManager = new CreateImageResultViewManager(this.mPresenter.getCreateImage(), this.mCommonViews, new CreateImageResultViewManager.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultView.7
                @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.CreateImageResultViewManager.Contract
                public void requestRelease(String str) {
                    AbstractC8014b.m7198D("requestRelease# caller: ", str, AiMenuResultView.TAG);
                    AiMenuResultView.this.close();
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.CreateImageResultViewManager.Contract
                @SuppressLint({"NotifyDataSetChanged"})
                public void updatePages(List<CreateImageResultView> list, int i, String str) {
                    int size = AiMenuResultView.this.mPageTypeList.size();
                    if (size > 1) {
                        AiMenuResultView.this.mPageTypeList.subList(1, size).clear();
                    }
                    AiMenuResultView.this.mPageTypeList.addAll(list);
                    String str2 = AiMenuResultView.TAG;
                    StringBuilder sbM780v = AbstractC0541b.m780v("updatePages, caller: ", i, str, ", targetPageIndex: ", ", before: ");
                    sbM780v.append(size);
                    sbM780v.append(", after: ");
                    sbM780v.append(AiMenuResultView.this.mPageTypeList.size());
                    Logger.m10999d(str2, sbM780v.toString());
                    AiMenuResultView.this.mResultViewAdapter.notifyDataSetChanged();
                    AiMenuResultView.this.mPageIndicator.updateIndicator();
                    AiMenuResultView.this.mPageIndicator.requestLayout();
                    AiMenuResultView.this.setCurrentItemViewPager(i, false);
                }
            });
            this.mCreateImageViewManager = createImageResultViewManager;
            createImageResultViewManager.initView();
            this.mPageTypeList.add(this.mCreateImageViewManager.getOriginalView());
            if (this.mPresenter.getCreateImage().isFinishedState()) {
                this.mCreateImageViewManager.addResultPages();
            } else if (this.mPresenter.getCreateImage().isRunningState()) {
                this.mCreateImageViewManager.onStart();
            }
        }
        setInitialTitle();
        this.isRestore = false;
    }

    private void initSALog() {
        if (this.mOnSavedInstanceState) {
            this.mOnSavedInstanceState = false;
        } else {
            this.mPresenter.setCurrentPageStartShowingTime(System.currentTimeMillis());
        }
    }

    private void insertSALogAiViewDuration(int i, long j) {
        String str;
        if (j < 0) {
            return;
        }
        String str2 = "802";
        if (i == 90011) {
            str = ComposerSAConstants.EVENT_AI_MAINTAIN_RESULT_WINDOW_AUTO_FORMAT_HEADERS_TIME;
        } else if (i == 90012) {
            str = ComposerSAConstants.EVENT_AI_MAINTAIN_RESULT_WINDOW_AUTO_FORMAT_MEETING_TIME;
        } else if (i == 9002) {
            str = ComposerSAConstants.EVENT_AI_MAINTAIN_RESULT_WINDOW_SUMMARIZE_TIME;
        } else if (i == 9003) {
            str = ComposerSAConstants.EVENT_AI_MAINTAIN_RESULT_WINDOW_CORRECT_SPELLING_TIME;
        } else if (i == 9004) {
            str = ComposerSAConstants.EVENT_AI_MAINTAIN_RESULT_WINDOW_TRANSLATE_TIME;
        } else if (i == 9006) {
            str = ComposerSAConstants.EVENT_AI_MAINTAIN_RESULT_WINDOW_SKETCH_TO_IMAGE_TIME;
        } else if (i != 9005) {
            Logger.m11000e(TAG, "insertSALogPreviousAiViewDuration# current Ai View is invalid");
            return;
        } else {
            str = ComposerSAConstants.EVENT_AI_MAINTAIN_RESULT_WINDOW_TRANSCRIBE_TIME;
            str2 = "816";
        }
        ComposerSA.insertLog(str2, str, j <= 10000 ? "a" : j <= 30000 ? "b" : j <= 60000 ? "c" : "d");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isBlockingMovePage() {
        int i = this.mIsMoveBlockingCnt;
        if (i <= 0) {
            return false;
        }
        this.mIsMoveBlockingCnt = i - 1;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isCreateImageRunning() {
        return this.mPresenter.isCreateImageRunning();
    }

    private boolean isSTTSelectionMode() {
        ISTTWindow.IAIContract iAiSTTContract;
        return (this.mPresenter.getSTTTabletLayoutAction() == null || (iAiSTTContract = this.mPresenter.getSTTTabletLayoutAction().getIAiSTTContract()) == null || (!iAiSTTContract.getSTTPresenter().isSelectionMode() && !iAiSTTContract.getSTTPresenter().isSelectionSummaryMode())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$movePage$0(int i) {
        setCurrentItemViewPager(i, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void movePage(Class<?> cls) {
        for (int i = 0; i < this.mPageTypeList.size(); i++) {
            if (cls.isInstance(this.mPageTypeList.get(i))) {
                setCurrentItemViewPager(i, true);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postExecuteDirectResultAction() {
        postExecuteDirectResultAction(300L);
    }

    private void reduceDragSensitivity(ViewPager2 viewPager2, int i) {
        try {
            Field declaredField = ViewPager2.class.getDeclaredField("mRecyclerView");
            declaredField.setAccessible(true);
            RecyclerView recyclerView = (RecyclerView) declaredField.get(viewPager2);
            Field declaredField2 = RecyclerView.class.getDeclaredField("mTouchSlop");
            declaredField2.setAccessible(true);
            Integer num = (Integer) declaredField2.get(recyclerView);
            if (num == null || num.intValue() == i) {
                return;
            }
            declaredField2.set(recyclerView, Integer.valueOf(i));
            Logger.m11003i(TAG, "reduceDragSensitivity# from = " + num + " / to = " + i);
        } catch (Exception e) {
            AbstractC8014b.m7207i("reduceDragSensitivity# e = ", e, TAG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean removeErrorPage() {
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= this.mPageTypeList.size()) {
                break;
            }
            if (this.mPageTypeList.get(i) instanceof AiMenuResultViewRecognizedHw) {
                i++;
                z = true;
                break;
            }
            i++;
        }
        if (z) {
            while (i < this.mPageTypeList.size()) {
                this.mPageTypeList.get(i).clear();
                this.mPageTypeList.remove(i);
            }
            this.mCommonViews.hideErrorMessage();
        }
        this.mPageIndicator.updateIndicator();
        return z;
    }

    private void resetSTTView() {
        this.mCommonViews.getBottomView().setDisabled(false);
        this.mCommonViews.getBottomView().initButtonLayout();
        this.mCommonViews.resetSTTView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentItemViewPager(int i, boolean z) {
        if (this.mViewPager.getScrollState() != 0) {
            this.mViewPager.endFakeDrag();
        }
        this.mViewPager.setCurrentItem(i, z);
    }

    private void setInitialTitle() {
        if (this.mPageTypeList.size() > 1) {
            this.mPageTypeList.get(1).setTitle();
        } else if (this.mPageTypeList.size() == 1 && (this.mPageTypeList.get(0) instanceof AiMenuResultViewSTT)) {
            this.mPageTypeList.get(0).setTitle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sttKeepOnlyView(Class<?>[] clsArr, Class<?>[] clsArr2) {
        Iterator<AiMenuContract.IAiActionResultView> it = this.mPageTypeList.iterator();
        while (true) {
            int i = 0;
            if (!it.hasNext()) {
                break;
            }
            AiMenuContract.IAiActionResultView next = it.next();
            if (next != null) {
                int length = clsArr.length;
                while (true) {
                    if (i >= length) {
                        it.remove();
                        break;
                    }
                    if (next.getClass().isAssignableFrom(clsArr[i])) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
        }
        Iterator<AiMenuContract.IAiAction> it2 = this.mPresenter.getAiActions().iterator();
        while (it2.hasNext()) {
            AiMenuContract.IAiAction next2 = it2.next();
            if (next2 != null) {
                int length2 = clsArr2.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length2) {
                        it2.remove();
                        break;
                    }
                    if (next2.getClass().isAssignableFrom(clsArr2[i2])) {
                        break;
                    } else {
                        i2++;
                    }
                }
            }
        }
        this.mViewPager.seslGetListView().getRecycledViewPool().clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean updateEditedRecognizedHw() {
        if (this.mPresenter.getRecognizedHw() == null) {
            return false;
        }
        for (AiMenuContract.IAiActionResultView iAiActionResultView : this.mPageTypeList) {
            if (iAiActionResultView instanceof AiMenuResultViewRecognizedHw) {
                ((AiMenuResultViewRecognizedHw) iAiActionResultView).updateCurrentText();
            }
        }
        return this.mPresenter.getSrcContentInfo().hasDirty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateExecuteState(final Runnable runnable) {
        if (this.mViewPager.isInLayout()) {
            Logger.m10999d(TAG, "updateExecuteState# isInLayout");
            this.mPresenter.getHandler().post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultView.10
                @Override // java.lang.Runnable
                public void run() {
                    Logger.m10999d(AiMenuResultView.TAG, "updateExecuteState# pending call");
                    AiMenuResultView.this.updateExecuteState(runnable);
                }
            });
            return;
        }
        isBlockingMovePage();
        int size = this.mPageTypeList.size();
        runnable.run();
        if (this.mViewPager.getAdapter() != null) {
            this.mViewPager.getAdapter().notifyItemRangeInserted(size, this.mPageTypeList.size() - size);
        }
        this.mPageIndicator.updateIndicator();
        this.mPageIndicator.requestLayout();
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void clear() {
        clearPages();
        AiMenuResultCommonViews aiMenuResultCommonViews = this.mCommonViews;
        if (aiMenuResultCommonViews != null) {
            aiMenuResultCommonViews.clear();
        }
        ViewPager2 viewPager2 = this.mViewPager;
        if (viewPager2 != null) {
            try {
                viewPager2.beginFakeDrag();
                this.mViewPager.endFakeDrag();
            } catch (Exception e) {
                AbstractC8014b.m7205g(e, new StringBuilder("clear#fakeDrag "), TAG);
            }
            this.mViewPager.unregisterOnPageChangeCallback(this.mOnPageChangeCallback);
            this.mViewPager.setPageTransformer(null);
            if (this.mViewPager.getAdapter() != null) {
                this.mViewPager.getAdapter().notifyDataSetChanged();
            }
            if (this.mViewPager.seslGetListView().getLayoutManager() != null) {
                this.mViewPager.seslGetListView().getLayoutManager().removeAllViews();
            }
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IView
    public void clearCurrentAiAction() {
        this.mCommonViews.getContinuesProgress().callStop();
        clearPages();
    }

    public void clearSearchComposer() {
        AiMenuResultCommonViews aiMenuResultCommonViews = this.mCommonViews;
        if (aiMenuResultCommonViews != null) {
            aiMenuResultCommonViews.clear();
        }
    }

    public boolean closeEditMode() {
        List<AiMenuContract.IAiActionResultView> list = this.mPageTypeList;
        if (list != null && !list.isEmpty()) {
            AiMenuContract.IAiActionResultView currentResultView = getCurrentResultView();
            if (currentResultView instanceof AiMenuResultViewRecognizedHw) {
                AiMenuResultViewRecognizedHw aiMenuResultViewRecognizedHw = (AiMenuResultViewRecognizedHw) currentResultView;
                if (aiMenuResultViewRecognizedHw.canShowingSip()) {
                    aiMenuResultViewRecognizedHw.setNormalModeState();
                    return true;
                }
            }
        }
        return false;
    }

    public void createAutoFormatStreamingView(boolean z) {
        AutoFormatStreamingResultViewManager autoFormatStreamingResultViewManager = new AutoFormatStreamingResultViewManager(this.mPresenter.getAutoFormat(), this.mCommonViews, new C958017());
        this.mAutoFormatResultViewManager = autoFormatStreamingResultViewManager;
        autoFormatStreamingResultViewManager.initView(this.mView);
        if (z) {
            autoFormatStreamingResultViewManager.createOriginView();
            this.mAnimation.getPageTransformer().setEventBaseIndex(this.mPageTypeList.size());
            this.mPageTypeList.add(autoFormatStreamingResultViewManager.getOriginalView());
        }
        if (this.mPresenter.getAutoFormat().hasResult()) {
            autoFormatStreamingResultViewManager.createAutoFormatView(this.mPresenter.getRecognizedHw() != null);
            this.mPageTypeList.addAll(autoFormatStreamingResultViewManager.getAutoFormatResultViewList());
        } else {
            autoFormatStreamingResultViewManager.createAutoFormatStreamingResultView();
            this.mPageTypeList.add(autoFormatStreamingResultViewManager.geAutoFormatStreamingResultView());
            autoFormatStreamingResultViewManager.createAutoFormatView(this.mPresenter.getRecognizedHw() != null);
        }
    }

    public void createAutoFormatView(boolean z) {
        AutoFormatResultViewManager autoFormatResultViewManager = new AutoFormatResultViewManager(this.mPresenter.getAutoFormat(), this.mCommonViews, new AutoFormatResultViewManager.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultView.8
            private void hideMenuBtn() {
                AiMenuResultView.this.mCommonViews.getTopView().getButton(2).setVisibility(8);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultContainer
            public Activity getActivity() {
                return AiMenuResultView.this.mPresenter.getActivity();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultContainer
            public void updateContinuesResultState(boolean z2) {
                if (z2) {
                    AiMenuResultView aiMenuResultView = AiMenuResultView.this;
                    AiMenuContract.IAiActionResultView iAiActionResultView = aiMenuResultView.mPageTypeList.get(aiMenuResultView.mViewPager.getCurrentItem());
                    if (iAiActionResultView instanceof AutoFormatResultView) {
                        AiMenuResultView.this.mCommonViews.setBottomButtonsState(true);
                    } else if (iAiActionResultView instanceof AutoFormatOriginTextView) {
                        AiMenuResultCommonViews aiMenuResultCommonViews = AiMenuResultView.this.mCommonViews;
                        ArrayList arrayList = new ArrayList(1);
                        Object obj = new Object[]{1}[0];
                        Objects.requireNonNull(obj);
                        arrayList.add(obj);
                        aiMenuResultCommonViews.setTopButtonsVisibility(Collections.unmodifiableList(arrayList));
                    }
                    AiMenuResultView.this.mCommonViews.getContinuesProgress().setEnable(false);
                }
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AutoFormatResultViewManager.Contract
            public boolean updateEditedRecognizedHw() {
                return AiMenuResultView.this.updateEditedRecognizedHw();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AutoFormatResultViewManager.Contract
            @SuppressLint({"NotifyDataSetChanged"})
            public void updatePages() {
                boolean z2 = false;
                if (AiMenuResultView.this.mPresenter.getAutoFormat().getErrorType() == null) {
                    for (AutoFormatResultView autoFormatResultView : AiMenuResultView.this.mAutoFormatResultViewManager.getAutoFormatResultViewList()) {
                        if (!AiMenuResultView.this.mPageTypeList.contains(autoFormatResultView)) {
                            AiMenuResultView.this.mPageTypeList.add(autoFormatResultView);
                            z2 = true;
                        }
                    }
                } else {
                    Iterator<AiMenuContract.IAiActionResultView> it = AiMenuResultView.this.mPageTypeList.iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        if (it.next() instanceof AutoFormatResultView) {
                            if (i > 0) {
                                it.remove();
                                z2 = true;
                            }
                            i++;
                        }
                    }
                }
                if (!z2 || AiMenuResultView.this.mViewPager.getAdapter() == null) {
                    return;
                }
                AiMenuResultView.this.mPageIndicator.updateIndicator();
                AiMenuResultView.this.mViewPager.getAdapter().notifyDataSetChanged();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultContainer
            public void updateResultState(boolean z2, boolean z3) {
                if (AiMenuResultView.this.mPageTypeList.isEmpty()) {
                    AiMenuResultView.this.mCommonViews.hideProgress();
                    return;
                }
                int i = 0;
                while (i < AiMenuResultView.this.mPageTypeList.size() && !(AiMenuResultView.this.mPageTypeList.get(i) instanceof AutoFormatResultView)) {
                    i++;
                }
                if (z2) {
                    if (AiMenuResultView.this.isBlockingMovePage()) {
                        AiMenuResultView.this.mCommonViews.hideProgress();
                        return;
                    }
                    if (i != AiMenuResultView.this.mViewPager.getCurrentItem()) {
                        hideMenuBtn();
                        AiMenuResultView.this.setCurrentItemViewPager(i, true);
                        if (z3) {
                            AiMenuResultView.this.executeDirectResultAction();
                        }
                    }
                    if (AiMenuResultView.this.mCommonViews.getContinuesProgress().isShowing()) {
                        AiMenuResultView.this.mCommonViews.getBottomView().hide(false);
                    } else if (z3) {
                        AiMenuResultView.this.mCommonViews.getBottomView().show(true);
                    }
                } else if (AiMenuResultView.this.removeErrorPage()) {
                    i = 1;
                } else {
                    hideMenuBtn();
                    int i2 = i < AiMenuResultView.this.mPageTypeList.size() ? i : 0;
                    AiMenuResultView.this.setCurrentItemViewPager(i2, true);
                    i = i2;
                }
                AiMenuResultView.this.mCommonViews.hideProgress();
                if (AiMenuResultView.this.mPageTypeList.isEmpty()) {
                    return;
                }
                AiMenuResultView.this.mPageTypeList.get(i).setTitle();
            }
        });
        this.mAutoFormatResultViewManager = autoFormatResultViewManager;
        autoFormatResultViewManager.initView(this.mView);
        if (z) {
            this.mAutoFormatResultViewManager.createOriginView();
            this.mAnimation.getPageTransformer().setEventBaseIndex(this.mPageTypeList.size());
            this.mPageTypeList.add(this.mAutoFormatResultViewManager.getOriginalView());
        }
        this.mAutoFormatResultViewManager.createAutoFormatView(this.mPresenter.getRecognizedHw() != null);
        this.mPageTypeList.addAll(this.mAutoFormatResultViewManager.getAutoFormatResultViewList());
    }

    public AiMenuResultViewRecognizedHw createRecognizedHwView() {
        return new AiMenuResultViewRecognizedHw(this.mPresenter.getRecognizedHw(), this.mCommonViews, new AiMenuResultViewRecognizedHw.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultView.9
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewRecognizedHw.Contract
            public void addAutoFormatPage(final AutoFormat.FormatType formatType, final AutoFormat.ErrorType errorType) {
                AiMenuResultView.this.updateExecuteState(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultView.9.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AiMenuResultView.this.mPresenter.addAutoFormat(formatType, errorType);
                        AiMenuResultView.this.createAutoFormatInternal(false, false, true);
                        AiMenuResultView.this.movePage((Class<?>) AutoFormatResultView.class);
                    }
                });
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewRecognizedHw.Contract
            public void addSummaryPage(final Summarization.ErrorType errorType) {
                AiMenuResultView.this.updateExecuteState(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultView.9.4
                    @Override // java.lang.Runnable
                    public void run() {
                        AiMenuResultView.this.mPresenter.addSummarize(errorType);
                        AiMenuResultView.this.createSummarizationView();
                        AiMenuResultView.this.movePage((Class<?>) AiMenuResultViewSummarization.class);
                    }
                });
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewRecognizedHw.Contract
            public void addTranslationPage(final Translation.ErrorType errorType) {
                AiMenuResultView.this.updateExecuteState(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultView.9.6
                    @Override // java.lang.Runnable
                    public void run() {
                        AiMenuResultView.this.mPresenter.addTranslation(errorType);
                        AiMenuResultView.this.createTranslationView();
                        AiMenuResultView.this.movePage((Class<?>) AiMenuResultViewTranslation.class);
                    }
                });
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewRecognizedHw.Contract
            public void executeAutoFormat(AutoFormat.FormatType formatType) {
                AiMenuResultView.this.mCommonViews.showProgress(4);
                AiMenuResultView.this.mPresenter.executeAutoFormat(formatType);
                String sAForAIScenarioScreenID = AiMenuResultView.this.mPresenter.getSrcContentInfo().getSAForAIScenarioScreenID();
                AutoFormat.FormatType formatType2 = AutoFormat.FormatType.Meeting;
                ComposerSA.insertLog(sAForAIScenarioScreenID, formatType.equals(formatType2) ? ComposerSAConstants.EVENT_AI_MEETING_NOTES : ComposerSAConstants.EVENT_AI_HEADERS_AND_BULLETS, AiMenuResultView.this.mPresenter.getSrcContentInfo().getSAForAIScenario());
                ComposerSA.insertLog(AiMenuResultView.this.mPresenter.getSrcContentInfo().getSAForAIScenarioScreenID(), formatType.equals(formatType2) ? ComposerSAConstants.EVENT_AI_LENGTH_FOR_AF_MEETING_NOTES : ComposerSAConstants.EVENT_AI_LENGTH_FOR_AF_HEADERS_AND_BULLETS, ComposerSA.getDetailAiSelectedTextLength(AiMenuResultView.this.mPresenter.getSrcContentInfo().getSelectedText().length(), 10000));
                AiMenuResultView.this.updateExecuteState(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultView.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AiMenuResultView.this.createAutoFormatInternal(false, false);
                    }
                });
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewRecognizedHw.Contract
            public void executeSummarize() {
                AiMenuResultView.this.mCommonViews.showProgress(2);
                AiMenuResultView.this.mPresenter.executeSummarize();
                ComposerSA.insertLog(AiMenuResultView.this.mPresenter.getSrcContentInfo().getSAForAIScenarioScreenID(), ComposerSAConstants.EVENT_AI_SUMMARIZE, AiMenuResultView.this.mPresenter.getSrcContentInfo().getSAForAIScenario());
                ComposerSA.insertLog(AiMenuResultView.this.mPresenter.getSrcContentInfo().getSAForAIScenarioScreenID(), ComposerSAConstants.EVENT_AI_LENGTH_FOR_AF_SUMMARIZE, ComposerSA.getDetailAiSelectedTextLength(AiMenuResultView.this.mPresenter.getSrcContentInfo().getSelectedText().length(), 10000));
                AiMenuResultView.this.updateExecuteState(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultView.9.3
                    @Override // java.lang.Runnable
                    public void run() {
                        AiMenuResultView.this.createSummarizationView();
                    }
                });
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewRecognizedHw.Contract
            public void executeTranslate() {
                AiMenuResultView.this.mCommonViews.showProgress(1);
                AiMenuResultView.this.mPresenter.executeTranslate();
                ComposerSA.insertLog(AiMenuResultView.this.mPresenter.getSrcContentInfo().getSAForAIScenarioScreenID(), ComposerSAConstants.EVENT_AI_TRANSLATE, AiMenuResultView.this.mPresenter.getSrcContentInfo().getSAForAIScenario());
                ComposerSA.insertLog(AiMenuResultView.this.mPresenter.getSrcContentInfo().getSAForAIScenarioScreenID(), ComposerSAConstants.EVENT_AI_LENGTH_FOR_TRANSLATE, ComposerSA.getDetailAiSelectedTextLength(AiMenuResultView.this.mPresenter.getSrcContentInfo().getSelectedText().length(), 10000));
                AiMenuResultView.this.updateExecuteState(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultView.9.5
                    @Override // java.lang.Runnable
                    public void run() {
                        AiMenuResultView.this.createTranslationView();
                    }
                });
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewRecognizedHw.Contract
            public Activity getActivity() {
                return AiMenuResultView.this.mPresenter.getActivity();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewRecognizedHw.Contract
            public void hide() {
                AiMenuResultView.this.hide(new boolean[0]);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewRecognizedHw.Contract
            public void updateResultState() {
                if (AiMenuResultView.this.isBlockingMovePage()) {
                    return;
                }
                AiMenuResultView aiMenuResultView = AiMenuResultView.this;
                if (aiMenuResultView.mView == null) {
                    return;
                }
                aiMenuResultView.movePage((Class<?>) AiMenuResultViewRecognizedHw.class);
            }
        });
    }

    public void createSTTSummarizationView() {
        this.mPageTypeList.add(new AiMenuResultViewSTTSummarization(this.mPresenter, this.mCommonViews, new AiMenuContract.IAiActionSTTResultContainer() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultView.15
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionSTTResultContainer
            public void executeSummarize(boolean z) {
                AiMenuResultView.this.sttKeepOnlyView(new Class[]{AiMenuResultViewSTT.class, AiMenuResultViewSTTSummarization.class}, new Class[]{STTTabletLayoutAction.class, STTSummarization.class, STTSummarizationStreaming.class});
                if (!AiMenuResultView.this.isRestore) {
                    AiMenuResultView.this.mCommonViews.showProgress(2);
                }
                AiMenuResultViewPresenter aiMenuResultViewPresenter = AiMenuResultView.this.mPresenter;
                aiMenuResultViewPresenter.executeSTTSummarize(aiMenuResultViewPresenter.getSTTTabletLayoutAction().getIAiSTTContract(), z);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultContainer
            public Activity getActivity() {
                return AiMenuResultView.this.mPresenter.getActivity();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionSTTResultContainer
            public boolean isMinimizeView() {
                return AiMenuResultView.this.mLayoutManager.isMinimizeView();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultContainer
            public void updateResultState(boolean z, boolean z2) {
                int i = 0;
                while (i < AiMenuResultView.this.mPageTypeList.size() && !(AiMenuResultView.this.mPageTypeList.get(i) instanceof AiMenuResultViewSTTSummarization)) {
                    i++;
                }
                if (AiMenuResultView.this.mViewPager.getCurrentItem() != i) {
                    if (AiMenuResultView.this.isBlockingMovePage()) {
                        return;
                    }
                    AiMenuResultView.this.setCurrentItemViewPager(i, true);
                    if (i < AiMenuResultView.this.mPageTypeList.size()) {
                        AiMenuResultView.this.mPageTypeList.get(i).setTitle();
                    }
                    AiMenuResultView.this.mCommonViews.getTopView().mSTTContextBtn.setVisibility(0);
                }
                if (z2) {
                    AiMenuResultView.this.postExecuteDirectResultAction();
                }
            }
        }, this.mPresenter.getSTTTabletLayoutAction().getIAiSTTContract()));
    }

    public void createSpellingCorrectionView() {
        this.mPageTypeList.add(new AiMenuResultViewCorrection(this.mPresenter.getSpellingCorrection(), this.mCommonViews, new AiMenuContract.IAiActionResultContainer() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultView.12
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultContainer
            public Activity getActivity() {
                return AiMenuResultView.this.mPresenter.getActivity();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultContainer
            public void updateContinuesResultState(boolean z) {
                if (z) {
                    AiMenuResultView.this.mCommonViews.getContinuesProgress().setEnable(false);
                    AiMenuResultView aiMenuResultView = AiMenuResultView.this;
                    aiMenuResultView.mCommonViews.setBottomButtonsState(aiMenuResultView.mPageTypeList.get(aiMenuResultView.mViewPager.getCurrentItem()) instanceof AiMenuResultViewCorrection);
                }
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultContainer
            public void updateResultState(boolean z, boolean z2) {
                if (!z) {
                    AiMenuResultView.this.removeErrorPage();
                    return;
                }
                if (AiMenuResultView.this.isBlockingMovePage()) {
                    return;
                }
                int i = 0;
                while (i < AiMenuResultView.this.mPageTypeList.size() && !(AiMenuResultView.this.mPageTypeList.get(i) instanceof AiMenuResultViewCorrection)) {
                    i++;
                }
                if (AiMenuResultView.this.mViewPager.getCurrentItem() != i) {
                    AiMenuResultView.this.movePage(i);
                    AiMenuResultView.this.mPageTypeList.get(i).setTitle();
                    AiMenuResultView.this.mCommonViews.getTopView().mSettingBtn.setVisibility(8);
                }
                if (z2) {
                    AiMenuResultView.this.postExecuteDirectResultAction(500L);
                }
            }
        }));
    }

    public void createSummarizationView() {
        this.mPageTypeList.add(new AiMenuResultViewSummarization(this.mPresenter.getSummarization(), this.mPresenter.getSummarization().getSelectionMaxLength(), this.mCommonViews, new AiMenuResultViewSummarization.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultView.11
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultContainer
            public Activity getActivity() {
                return AiMenuResultView.this.mPresenter.getActivity();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultContainer
            public void updateContinuesResultState(boolean z) {
                if (z) {
                    AiMenuResultView aiMenuResultView = AiMenuResultView.this;
                    if (aiMenuResultView.mPageTypeList.get(aiMenuResultView.mViewPager.getCurrentItem()) instanceof AiMenuResultViewSummarization) {
                        AiMenuResultCommonViews aiMenuResultCommonViews = AiMenuResultView.this.mCommonViews;
                        Object[] objArr = {3, 4};
                        ArrayList arrayList = new ArrayList(2);
                        for (int i = 0; i < 2; i++) {
                            Object obj = objArr[i];
                            Objects.requireNonNull(obj);
                            arrayList.add(obj);
                        }
                        aiMenuResultCommonViews.setTopButtonsVisibility(Collections.unmodifiableList(arrayList));
                        AiMenuResultView.this.mCommonViews.setBottomButtonsState(true);
                    }
                    AiMenuResultView.this.mCommonViews.getContinuesProgress().setEnable(false);
                }
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSummarization.Contract
            public boolean updateEditedRecognizedHw() {
                return AiMenuResultView.this.updateEditedRecognizedHw();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultContainer
            public void updateResultState(boolean z, boolean z2) {
                if (!z) {
                    AiMenuResultView.this.removeErrorPage();
                    return;
                }
                int i = 0;
                while (i < AiMenuResultView.this.mPageTypeList.size() && !(AiMenuResultView.this.mPageTypeList.get(i) instanceof AiMenuResultViewSummarization)) {
                    i++;
                }
                if (AiMenuResultView.this.mViewPager.getCurrentItem() != i) {
                    if (AiMenuResultView.this.isBlockingMovePage()) {
                        return;
                    }
                    AiMenuResultView.this.setCurrentItemViewPager(i, false);
                    AiMenuResultView.this.mPageTypeList.get(i).setTitle();
                    AiMenuResultView.this.mCommonViews.getTopView().mSettingBtn.setVisibility(8);
                }
                if (z2) {
                    AiMenuResultView.this.postExecuteDirectResultAction();
                }
            }
        }));
    }

    public void createTranslationView() {
        this.mPageTypeList.add(new AiMenuResultViewTranslation(this.mPresenter.getTranslation(), this.mCommonViews, createTranslationContract()));
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IView
    public void expandView() {
        this.mLayoutManager.expandView();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IView
    public int getCurrentPageIndex() {
        return this.mViewPager.getCurrentItem();
    }

    public int getCurrentScreen() {
        if (!isShowing() || this.mCommonViews.isShowingProgress() || this.mCommonViews.isShowingErrorMessage()) {
            return 9000;
        }
        AiMenuContract.IAiActionResultView iAiActionResultView = this.mPageTypeList.get(this.mViewPager.getCurrentItem());
        if ((iAiActionResultView instanceof AutoFormatResultView) || (iAiActionResultView instanceof AutoFormatStreamingResultView)) {
            return ((AutoFormat) iAiActionResultView.getAction()).getCurrentFormatType() == AutoFormat.FormatType.Meeting ? 90012 : 90011;
        }
        if (iAiActionResultView instanceof AiMenuResultViewCorrection) {
            return 9003;
        }
        if (iAiActionResultView instanceof AiMenuResultViewSummarization) {
            return 9002;
        }
        if (iAiActionResultView instanceof AiMenuResultViewTranslation) {
            return 9004;
        }
        if ((iAiActionResultView instanceof AiMenuResultViewSTT) || (iAiActionResultView instanceof AiMenuResultViewSTTSummarization)) {
            return 9005;
        }
        if (iAiActionResultView instanceof CreateImageResultView) {
            return 9006;
        }
        return iAiActionResultView instanceof AiMenuResultViewRecognizedHw ? 9007 : 9000;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IView
    public boolean getSavedInstanceState() {
        return this.mOnSavedInstanceState;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IView
    public void hide(boolean... zArr) {
        if (this.mView == null) {
            return;
        }
        Logger.m10999d(TAG, "hide#");
        if (!this.mOnSavedInstanceState) {
            int currentScreenIdByAiActions = this.mPresenter.getCurrentScreenIdByAiActions();
            if (currentScreenIdByAiActions == 9005) {
                ComposerSA.insertLog("816", ComposerSAConstants.EVENT_AI_RESULT_VIEW_TYPE_BEFORE_CLOSING, ComposerSA.getAiResultViewMode(this.mLayoutManager.getCurrentMode()));
            } else if (currentScreenIdByAiActions != 9000) {
                ComposerSA.insertLog("802", ComposerSAConstants.EVENT_AI_RESULT_VIEW_TYPE_BEFORE_CLOSING, ComposerSA.getAiResultViewMode(this.mLayoutManager.getCurrentMode()));
            }
            insertSALogAiViewDuration(currentScreenIdByAiActions, System.currentTimeMillis() - this.mPresenter.getCurrentPageStartShowingTime());
            this.mPresenter.setCurrentPageStartShowingTime(-1L);
        }
        this.mLayoutManager.hide();
        if (AiViewUtils.isSupportFloatingLayout()) {
            this.isRestore = zArr.length != 0;
        }
        clear();
        this.mPresenter.onHide();
        this.mIsShowing = false;
        this.mView = null;
        this.mIsMoveBlockingCnt = 0;
        if (this.mPresenter.needToBlockHideNavigationBar()) {
            NavigationBarUtil.hideNavigationBar(this.mPresenter.getActivity());
        }
        this.mCommonViews.getContinuesProgress().setEnable(false);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IView
    public void hideNormalProgress() {
        this.mCommonViews.hideProgress();
    }

    public void hideSearchControl() {
        this.mCommonViews.getSTTSearchView().hideSearchView();
    }

    public void init(Activity activity) {
        AiMenuResultLayoutManager aiMenuResultLayoutManager = new AiMenuResultLayoutManager(activity, new AiMenuResultLayoutManager.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultView.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultLayoutManager.Contract
            public List<AiMenuContract.IAiActionResultView> getPageTypeList() {
                return AiMenuResultView.this.mPageTypeList;
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultLayoutManager.Contract
            public AiMenuResultViewPresenter getPresenter() {
                return AiMenuResultView.this.mPresenter;
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultLayoutManager.Contract
            public void hide() {
                AiMenuResultView.this.hide(new boolean[0]);
                AiMenuResultView.this.releaseSelection();
            }
        });
        this.mLayoutManager = aiMenuResultLayoutManager;
        this.mView = aiMenuResultLayoutManager.getLayoutContainer();
        AiMenuResultCommonViews aiMenuResultCommonViews = new AiMenuResultCommonViews(activity, this.mView, new AiMenuResultCommonViews.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultView.2
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultCommonViews.Contract
            public void close() {
                AiMenuResultView.this.close();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultCommonViews.Contract
            public void generateOneMore() {
                if (AiMenuResultView.this.mPresenter.isCreateImageRunning()) {
                    AiMenuResultView.this.mPresenter.getCreateImage().generateOneMore();
                } else {
                    Logger.m11004w(AiMenuResultView.TAG, "generateOneMore, invalid, used for create image");
                }
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultCommonViews.Contract
            public List<AiMenuContract.IAiActionResultView> getPageList() {
                return AiMenuResultView.this.mPageTypeList;
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultCommonViews.Contract
            public AiMenuResultViewPresenter getPresenter() {
                return AiMenuResultView.this.mPresenter;
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultCommonViews.Contract
            public boolean isShowing() {
                return AiMenuResultView.this.isShowing();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultCommonViews.Contract
            public void retry() {
                if (!AiMenuResultView.this.mPresenter.isCreateImageRunning()) {
                    Logger.m11004w(AiMenuResultView.TAG, "retry, invalid, used for create image");
                    return;
                }
                ComposerSA.insertLog(ComposerSAConstants.SCREEN_AI_DRAWING_POPUP_RESULT, ComposerSAConstants.EVENT_AI_DRAWING_RESULT_CHANGE_STYLE);
                View retryBtn = AiMenuResultView.this.mCommonViews.getBottomView().getRetryBtn();
                AiDrawingRequestPopup aiDrawingRequestPopup = new AiDrawingRequestPopup(retryBtn.getContext());
                aiDrawingRequestPopup.setContract(new AiDrawingRequestLayout.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultView.2.1
                    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.generate.AiDrawingRequestLayout.Contract
                    public int getGenerateStyleIndex() {
                        return AiDrawingUtil.getGenerateStyleIndex(AiMenuResultView.this.mPresenter.getSrcContentInfo().getGenerateStyle());
                    }

                    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.generate.AiDrawingRequestLayout.Contract
                    public void requestExecuteCreateImage() {
                        SrcContentInfo srcContentInfo = AiMenuResultView.this.mPresenter.getSrcContentInfo();
                        ComposerSA.insertLog(ComposerSAConstants.SCREEN_AI_DRAWING_POPUP_RESULT, ComposerSAConstants.EVENT_AI_DRAWING_RETRY_STYLE, srcContentInfo.getGenerateStyle());
                        AiMenuResultView.this.mPresenter.getCreateImage().setLastRequestedImageStyle(srcContentInfo.getGenerateStyle());
                        AiMenuResultView.this.mPresenter.getCreateImage().generateOneMore();
                    }

                    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.generate.AiDrawingRequestLayout.Contract
                    public void requestUpdateGenerateStyleIndex(int i) {
                        AiMenuResultView.this.mPresenter.getSrcContentInfo().setGenerateTheme(AiDrawingUtil.getGenerateStyle(i));
                    }
                });
                aiDrawingRequestPopup.show(retryBtn);
            }
        }, new AiResultContinuesProgress.StateListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultView.3
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.progress.AiResultContinuesProgress.StateListener
            public void onStopped() {
                AiMenuResultView.this.mPresenter.stopContinues();
                List<AiMenuContract.IAiActionResultView> list = AiMenuResultView.this.mPageTypeList;
                if (list == null || list.isEmpty()) {
                    return;
                }
                AiMenuResultView aiMenuResultView = AiMenuResultView.this;
                AiMenuContract.IAiActionResultView iAiActionResultView = aiMenuResultView.mPageTypeList.get(aiMenuResultView.mViewPager.getCurrentItem());
                if (!(iAiActionResultView instanceof AiMenuResultViewSummarization)) {
                    if (iAiActionResultView instanceof AutoFormatOriginTextView) {
                        AiMenuResultCommonViews aiMenuResultCommonViews2 = AiMenuResultView.this.mCommonViews;
                        ArrayList arrayList = new ArrayList(1);
                        Object obj = new Object[]{1}[0];
                        Objects.requireNonNull(obj);
                        arrayList.add(obj);
                        aiMenuResultCommonViews2.setTopButtonsVisibility(Collections.unmodifiableList(arrayList));
                        return;
                    }
                    return;
                }
                AiMenuResultCommonViews aiMenuResultCommonViews3 = AiMenuResultView.this.mCommonViews;
                Object[] objArr = {4, 3};
                ArrayList arrayList2 = new ArrayList(2);
                for (int i = 0; i < 2; i++) {
                    Object obj2 = objArr[i];
                    Objects.requireNonNull(obj2);
                    arrayList2.add(obj2);
                }
                aiMenuResultCommonViews3.setTopButtonsVisibility(Collections.unmodifiableList(arrayList2));
            }
        });
        this.mCommonViews = aiMenuResultCommonViews;
        this.mLayoutManager.init(aiMenuResultCommonViews);
        initAnimation();
        initViewPager(this.mView);
        initSALog();
    }

    public void initViewPager(View view) {
        ViewPager2 viewPager2 = (ViewPager2) view.findViewById(C9086R.id.ai_menu_result_viewpager);
        this.mViewPager = viewPager2;
        viewPager2.seslGetListView().seslSetPenSelectionEnabled(false);
        this.mViewPager.setVisibility(0);
        this.mViewPager.setAlpha(1.0f);
        this.mCommonViews.setViewPager(this.mViewPager);
        this.mCommonViews.hideProgress();
        this.mPageTypeList = new ArrayList();
        this.mViewPager.setOffscreenPageLimit(6);
        initPages();
        ResultViewAdapter resultViewAdapter = new ResultViewAdapter(this.mPageTypeList);
        this.mResultViewAdapter = resultViewAdapter;
        this.mViewPager.setAdapter(resultViewAdapter);
        if (this.mOnPageChangeCallback == null) {
            this.mOnPageChangeCallback = new OnPageChangeCallbackImpl();
        }
        this.mViewPager.registerOnPageChangeCallback(this.mOnPageChangeCallback);
        initIndicator(view);
        this.mViewPager.setPageTransformer(this.mAnimation.getPageTransformer());
        reduceDragSensitivity(this.mViewPager, this.mPresenter.getTranslation() == null ? 100 : 42);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IView
    public boolean isSTTSearchViewFocusing() {
        if (this.mCommonViews == null || !(getCurrentResultView() instanceof AiMenuResultViewSTT)) {
            return false;
        }
        return this.mCommonViews.getSTTSearchView().getView().hasFocus();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IView
    public boolean isShowing() {
        return this.mIsShowing;
    }

    public boolean isShowingResultWorking() {
        AiMenuResultCommonViews aiMenuResultCommonViews = this.mCommonViews;
        if (aiMenuResultCommonViews == null) {
            return false;
        }
        return aiMenuResultCommonViews.isShowingProgress();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IView
    public void minimizeView() {
        if (isShowing()) {
            this.mLayoutManager.minimize();
        }
    }

    public void notifyLanguageDownload() {
        if (isShowing()) {
            AiMenuContract.IAiActionResultView iAiActionResultView = this.mPageTypeList.get(this.mViewPager.getCurrentItem());
            if (iAiActionResultView instanceof AiMenuResultViewTranslation) {
                ((AiMenuResultViewTranslation) iAiActionResultView).onLanguageDownload();
                return;
            }
            for (AiMenuContract.IAiActionResultView iAiActionResultView2 : this.mPageTypeList) {
                if (iAiActionResultView2 instanceof AiMenuResultViewTranslation) {
                    ((AiMenuResultViewTranslation) iAiActionResultView2).onLanguageDownload();
                } else if (iAiActionResultView2 instanceof AiMenuResultViewSummarization) {
                    AiMenuResultViewSummarization aiMenuResultViewSummarization = (AiMenuResultViewSummarization) iAiActionResultView2;
                    if (aiMenuResultViewSummarization.isShowingSubTranslation()) {
                        aiMenuResultViewSummarization.onLanguageDownload();
                    }
                }
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration, boolean z) {
        AiMenuResultLayoutManager aiMenuResultLayoutManager;
        if (isShowing() && (aiMenuResultLayoutManager = this.mLayoutManager) != null) {
            aiMenuResultLayoutManager.onConfigurationChanged(configuration, z, this.mPreviousPageIndex);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IView
    public void onResume() {
        if (isShowing()) {
            Iterator<AiMenuContract.IAiActionResultView> it = this.mPageTypeList.iterator();
            while (it.hasNext()) {
                it.next().onResume();
            }
        }
    }

    public void onSTTSearchVoiceResult(int i, int i2, Intent intent) {
        String queryFromResult = VoiceButtonHelper.getQueryFromResult(i2, intent, ComposerRequestCode.SearchVoiceSTTSvi == ComposerRequestCode.get(i));
        if (queryFromResult != null) {
            this.mCommonViews.getSTTSearchView().setVoiceSearchText(queryFromResult);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IView
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        if (isShowing()) {
            Iterator<AiMenuContract.IAiActionResultView> it = this.mPageTypeList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AiMenuContract.IAiActionResultView next = it.next();
                if (next instanceof AiMenuResultViewRecognizedHw) {
                    ((AiMenuResultViewRecognizedHw) next).onSaveInstanceState();
                    break;
                } else if (next instanceof AiMenuResultViewSTT) {
                    ((AiMenuResultViewSTT) next).onSaveInstanceState();
                    break;
                }
            }
            this.mOnSavedInstanceState = true;
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IView
    public void onShowSip() {
        this.mLayoutManager.onShowSip();
    }

    public void releaseSelection() {
        AiMenuResultViewPresenter aiMenuResultViewPresenter = this.mPresenter;
        if (aiMenuResultViewPresenter != null) {
            aiMenuResultViewPresenter.releaseSelection();
        }
    }

    public void requestResultAction(int i) {
        String str = TAG;
        AbstractC0000a.m3D(i, "requestResultAction# ", str);
        if (this.mCommonViews.isShowingErrorMessage()) {
            Logger.m11004w(str, "requestResultAction#error message is showing");
            return;
        }
        this.mPresenter.getSrcContentInfo().setAiBixbyParam(new AiBixbyParam(0, i));
        if (this.mCommonViews.isWorking()) {
            Logger.m11004w(str, "requestResultAction#error message is isWorking");
        } else {
            executeDirectResultAction();
        }
    }

    public void search(String str, boolean z, int i) {
        this.mCommonViews.search(str, z, i);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IView
    public void setDisableSettingBtn() {
        this.mCommonViews.getTopView().setDisableSettingBtn();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IView
    public void setEnableReplace(boolean z) {
        if (isSTTSelectionMode() || isCreateImageRunning()) {
            this.mCommonViews.getBottomView().setEnableReplace(true);
            return;
        }
        if (z && !this.mPresenter.getComposerViewPresenter().getObjectManager().isSelectedBodyText()) {
            z = false;
        }
        this.mCommonViews.getBottomView().setEnableReplace(z);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IView
    public void setFocusEditResult(boolean z) {
        this.mLayoutManager.setFocusEditResult(z);
    }

    public void setPresenter(AiMenuResultViewPresenter aiMenuResultViewPresenter) {
        this.mPresenter = aiMenuResultViewPresenter;
        aiMenuResultViewPresenter.setView(this);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IView
    public void show(Activity activity, final String str, final boolean z, final int i) {
        show(activity, true, (Integer) null, false);
        this.mView.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultView.4
            @Override // java.lang.Runnable
            public void run() {
                AiMenuResultView.this.search(str, z, i);
                AiMenuResultView.this.hideSearchControl();
            }
        });
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IView
    public void showNormalProgress() {
        this.mCommonViews.showProgress(0);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IView
    @SuppressLint({"NotifyDataSetChanged"})
    public void updateNewAiAction() {
        if (this.mView == null) {
            Logger.m10999d(TAG, "updateNewAiAction# ");
            return;
        }
        this.mCommonViews.getTopView().init(this.mCommonViews.getTopContainer(), this.mCommonViews.getUnderTopContainer());
        this.mCommonViews.getBottomView().init(this.mCommonViews.getBottomView().getView());
        this.mCommonViews.getSTTSearchView().init(this.mCommonViews.mContainer);
        this.mCommonViews.hideProgress();
        this.mCommonViews.hideErrorMessage();
        initPages();
        initIndicator(this.mView);
        if (this.mPresenter.getSTTTabletLayoutAction() != null) {
            this.mCommonViews.getBottomView().setDisabled(true);
            this.mCommonViews.getTopView().mTabLayout.setVisibility(0);
            if (this.mPresenter.getSTTTabletLayoutAction().getIAiSTTContract().getSTTPresenter().isAutoTranscribeItemRunning()) {
                this.mCommonViews.getTopView().mTabLayout.setVisibility(8);
            }
        } else {
            resetSTTView();
        }
        setCurrentItemViewPager(0, true);
        this.mViewPager.setAdapter(this.mResultViewAdapter);
        this.mView.requestLayout();
        if (this.mPresenter.getPreviousScreenId() != getCurrentScreen()) {
            insertSALogAiViewDuration(this.mPresenter.getPreviousScreenId(), System.currentTimeMillis() - this.mPresenter.getCurrentPageStartShowingTime());
            this.mPresenter.setCurrentPageStartShowingTime(System.currentTimeMillis());
        }
    }

    public void updatePageContainer() {
        this.mLayoutManager.updateViewPagerContainerParams();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createAutoFormatInternal(boolean z, boolean z2, boolean z3) {
        if (!CscFeature.INSTANCE.getInstance().isChinaAiFeature() || z3) {
            createAutoFormatView(z);
        } else {
            createAutoFormatStreamingView(z);
        }
        if (this.isRestore || !z2 || this.mPresenter.getAutoFormat().hasResult() || this.mPresenter.getAutoFormat().isRestore()) {
            return;
        }
        this.mCommonViews.showProgress(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postExecuteDirectResultAction(long j) {
        this.mPresenter.getHandler().postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultView.16
            @Override // java.lang.Runnable
            public void run() {
                AiMenuResultView.this.executeDirectResultAction();
            }
        }, j);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IView
    public void show(Activity activity) {
        show(activity, true, (Integer) null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void movePage(int i) {
        this.mViewPager.post(new RunnableC0050f(this, i, 18));
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IView
    public void show(Activity activity, boolean z, final Integer num, boolean z2) {
        Logger.m10999d(TAG, "show#");
        if (this.mView == null) {
            init(activity);
        }
        resetSTTView();
        this.mPresenter.onShow();
        this.mLayoutManager.show(z2);
        this.mIsShowing = true;
        if (this.mPresenter.needToBlockHideNavigationBar()) {
            NavigationBarUtil.clearHideNavigationBarFlag(activity);
        }
        if (num != null) {
            if (num.intValue() != 0) {
                this.mIsMoveBlockingCnt = 1;
                this.mLayoutManager.setPageIndexToUpdate(num.intValue());
            }
            this.mViewPager.setPageTransformer(null);
            this.mViewPager.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultView.5
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
                    if (i4 - i > 0) {
                        AiMenuResultView.this.setCurrentItemViewPager(num.intValue(), false);
                        if (AiMenuResultView.this.mPageTypeList.size() > num.intValue() && AiMenuResultView.this.mPageTypeList.get(num.intValue()).isBottomMenuSupported()) {
                            AiMenuResultView.this.mCommonViews.getBottomView().show(false);
                        }
                        view.removeOnLayoutChangeListener(this);
                    }
                }
            });
        }
    }
}
