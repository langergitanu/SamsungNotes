package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.viewpager2.widget.ViewPager2;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.dialog.AiPersonalDataRestrictedDialog;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiViewUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AiMenuContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AiMenuResultViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.ResultNoteManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AiMenuResultBottomView;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AiMenuResultTopView;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.progress.AiResultContinuesProgress;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.progress.AiResultProgress;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.stt.presenter.STTPresenter;
import com.samsung.android.support.senl.p148nt.stt.presenter.STTSearchPresenter;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiMenuResultCommonViews {
    private static final String TAG = Logger.createTag("AiMenuResultCommonViews", AiConstants.PREFIX_TAG);
    Activity mActivity;
    private final AiMenuResultBottomView mBottomView;
    private final AiMenuResultBottomView.Contract mBottomViewContract;
    View mChinaWaterMark;
    View mContainer;
    AiResultContinuesProgress mContinuesProgress;
    Contract mContract;
    TextView mErrMsgView;
    View mErrorMenuView;
    private View.OnLayoutChangeListener mErrorMenuViewOnLayoutChangeListener;
    AiResultProgress mResultProgress;
    ViewGroup mSTTHelpView;
    private final AiMenuResultSTTSearchView mSTTSearchView;
    private String mSearchText = null;
    private final AiMenuResultTopView mTopView;
    private final AiMenuResultTopView.Contract mTopViewContract;
    ViewPager2 mViewPager;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        void close();

        void generateOneMore();

        List<AiMenuContract.IAiActionResultView> getPageList();

        AiMenuResultViewPresenter getPresenter();

        boolean isShowing();

        void retry();
    }

    public AiMenuResultCommonViews(Activity activity, View view, Contract contract, final AiResultContinuesProgress.StateListener stateListener) {
        this.mActivity = activity;
        this.mContainer = view;
        this.mContract = contract;
        AiMenuResultTopView.Contract contract2 = new AiMenuResultTopView.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultCommonViews.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultTopView.Contract
            public void close() {
                AiMenuResultCommonViews.this.mContract.close();
                if (AiMenuResultCommonViews.this.mContract.getPresenter().isCreateImageRunning()) {
                    ComposerSA.insertLog(ComposerSAConstants.SCREEN_AI_DRAWING_POPUP_RESULT, ComposerSAConstants.EVENT_AI_DRAWING_RESULT_CLOSE);
                }
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultTopView.Contract
            public AiMenuResultBottomView getBottomView() {
                return AiMenuResultCommonViews.this.mBottomView;
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultTopView.Contract
            public int getCurrentItem() {
                return AiMenuResultCommonViews.this.mViewPager.getCurrentItem();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultTopView.Contract
            public List<AiMenuContract.IAiActionResultView> getPageList() {
                return AiMenuResultCommonViews.this.mContract.getPageList();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultTopView.Contract
            public AiMenuResultViewPresenter getPresenter() {
                return AiMenuResultCommonViews.this.mContract.getPresenter();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultTopView.Contract
            public boolean isNotAvailable() {
                return AiMenuResultCommonViews.this.isNotAvailable();
            }
        };
        this.mTopViewContract = contract2;
        AiMenuResultBottomView.Contract contract3 = new AiMenuResultBottomView.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultCommonViews.2
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultBottomView.Contract
            public void close() {
                AiMenuResultCommonViews.this.mContract.close();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultBottomView.Contract
            public void generateOneMore() {
                AiMenuResultCommonViews.this.mContract.generateOneMore();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultBottomView.Contract
            public int getCurrentItem() {
                return AiMenuResultCommonViews.this.mViewPager.getCurrentItem();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultBottomView.Contract
            public List<AiMenuContract.IAiActionResultView> getPageList() {
                return AiMenuResultCommonViews.this.mContract.getPageList();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultBottomView.Contract
            public AiMenuResultViewPresenter getPresenter() {
                return AiMenuResultCommonViews.this.mContract.getPresenter();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultBottomView.Contract
            public boolean isShowing() {
                return AiMenuResultCommonViews.this.mContract.isShowing();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultBottomView.Contract
            public void retry() {
                AiMenuResultCommonViews.this.mContract.retry();
            }
        };
        this.mBottomViewContract = contract3;
        this.mTopView = new AiMenuResultTopView(contract2);
        this.mBottomView = new AiMenuResultBottomView(contract3);
        this.mContinuesProgress = new AiResultContinuesProgress(new AiResultContinuesProgress.StateListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultCommonViews.3
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.progress.AiResultContinuesProgress.StateListener
            public void onStopped() {
                stateListener.onStopped();
                AiMenuResultCommonViews.this.setBottomButtonsState(true);
            }
        });
        this.mResultProgress = new AiResultProgress(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultCommonViews.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                STTPresenter sTTPresenter = AiMenuResultCommonViews.this.mContract.getPresenter().getSTTTabletLayoutAction().getIAiSTTContract().getSTTPresenter();
                if (sTTPresenter != null) {
                    sTTPresenter.cancelTranscribe();
                }
            }
        }, new AiResultProgress.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultCommonViews.5
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.progress.AiResultProgress.Contract
            public Activity getActivity() {
                return AiMenuResultCommonViews.this.mActivity;
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.progress.AiResultProgress.Contract
            public List<View> getTopButtons() {
                return AiMenuResultCommonViews.this.mTopView.getButtonList(true);
            }
        });
        this.mSTTSearchView = new AiMenuResultSTTSearchView(contract2);
        init(view);
    }

    private void initWaterMark() {
        if (this.mChinaWaterMark == null && CscFeature.INSTANCE.getInstance().isChinaAiFeature()) {
            View viewFindViewById = this.mContainer.findViewById(C9086R.id.ai_watermark_chn_view_stub);
            if (viewFindViewById instanceof ViewStub) {
                this.mChinaWaterMark = ((ViewStub) viewFindViewById).inflate();
            } else {
                this.mChinaWaterMark = viewFindViewById;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$search$0(int i, boolean z) {
        if (i > -1) {
            this.mSTTSearchView.searchPosition(i);
        } else if (z) {
            this.mSTTSearchView.searchLatest();
        } else {
            this.mSTTSearchView.searchForward();
        }
    }

    public void addFormatWatermark(Context context, SpenWNote spenWNote) {
        if (CscFeature.INSTANCE.getInstance().isChinaAiFeature()) {
            Logger.m10999d(TAG, "addWatermark# ");
            SpenObjectTextBox spenObjectTextBoxCreateWatermark = ResultNoteManager.createWatermark(context);
            spenWNote.getBodyText().insertText(spenWNote.getBodyText().getText().trim().length(), spenObjectTextBoxCreateWatermark, 0, spenObjectTextBoxCreateWatermark.getText().length());
        }
    }

    public void addWatermark(Context context, SpenWNote spenWNote) {
        if (CscFeature.INSTANCE.getInstance().isChinaAiFeature()) {
            Logger.m10999d(TAG, "addWatermark# ");
            SpenObjectTextBox spenObjectTextBoxCreateWatermark = ResultNoteManager.createWatermark(context);
            spenWNote.getBodyText().insertText(spenWNote.getBodyText().getText().length(), spenObjectTextBoxCreateWatermark, 0, spenObjectTextBoxCreateWatermark.getText().length());
        }
    }

    public void clear() {
        this.mResultProgress.clear();
        this.mContinuesProgress.clear();
        this.mTopView.clear();
        this.mBottomView.clear();
        this.mSearchText = null;
        View.OnLayoutChangeListener onLayoutChangeListener = this.mErrorMenuViewOnLayoutChangeListener;
        if (onLayoutChangeListener != null) {
            this.mErrorMenuView.removeOnLayoutChangeListener(onLayoutChangeListener);
        }
    }

    public AiMenuResultBottomView getBottomView() {
        return this.mBottomView;
    }

    public AiResultContinuesProgress getContinuesProgress() {
        return this.mContinuesProgress;
    }

    public AiMenuResultSTTSearchView getSTTSearchView() {
        return this.mSTTSearchView;
    }

    public View getTopContainer() {
        return this.mTopView.mTopContainer;
    }

    public AiMenuResultTopView getTopView() {
        return this.mTopView;
    }

    public View getTranscribeProgressCancelBtn() {
        return this.mResultProgress.getTranscribeProgressCancelBtn();
    }

    public View getUnderTopContainer() {
        return this.mTopView.mUnderTopContainer;
    }

    public boolean handleRestrictedPersonalDataError(String str) {
        if (!"RESTRICTED_USER_ERROR".equals(str)) {
            return false;
        }
        AiPersonalDataRestrictedDialog.INSTANCE.show(this.mActivity, null);
        this.mContract.close();
        return true;
    }

    public void hideErrorMessage() {
        this.mErrorMenuView.setVisibility(8);
        getBottomView().setIsShowingErrorMenuView(false);
        setBottomButtonsState(true);
        setTopButtonState(true);
        ViewPager2 viewPager2 = this.mViewPager;
        if (viewPager2 != null) {
            viewPager2.setVisibility(0);
        }
    }

    public void hideProgress() {
        hideProgress(true);
    }

    public void hideWaterMark() {
        if (this.mChinaWaterMark == null) {
            initWaterMark();
        }
        if (this.mChinaWaterMark != null) {
            if (CscFeature.INSTANCE.getInstance().isChinaAiFeature()) {
                this.mChinaWaterMark.setVisibility(4);
            } else {
                this.mChinaWaterMark.setVisibility(8);
            }
        }
    }

    public void inLayoutFinished() {
        this.mResultProgress.inLayoutFinished();
    }

    public void init(View view) {
        initProgress(view);
        initErrorView(view);
        this.mTopView.init(view.findViewById(C9086R.id.ai_menu_result_top_container), view.findViewById(C9086R.id.ai_menu_result_under_top_container));
        this.mBottomView.init(view.findViewById(C9086R.id.ai_menu_result_bottom_container));
        this.mSTTSearchView.init(view);
        this.mContinuesProgress.init(view);
        initSTTHelpView(view);
    }

    public void initErrorView(View view) {
        this.mErrorMenuView = view.findViewById(C9086R.id.ai_menu_result_error_menu_container);
        if (AiViewUtils.isSupportFloatingLayout()) {
            this.mErrorMenuView.setBackgroundColor(0);
        }
        this.mErrorMenuView.setOnTouchListener(new View.OnTouchListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultCommonViews.6
            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                return true;
            }
        });
        this.mErrMsgView = (TextView) view.findViewById(C9086R.id.ai_menu_result_error_message_view);
        view.findViewById(C9086R.id.ai_menu_result_got_it_button).setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultCommonViews.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                AiMenuResultCommonViews.this.mContract.close();
            }
        });
        hideErrorMessage();
        final ScrollView scrollView = (ScrollView) ((ViewGroup) this.mErrorMenuView).getChildAt(0);
        final View childAt = scrollView.getChildAt(0);
        if (this.mErrorMenuViewOnLayoutChangeListener == null) {
            this.mErrorMenuViewOnLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultCommonViews.8
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view2, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
                    if (childAt.getTop() < 0) {
                        scrollView.getChildAt(0).setTranslationY(childAt.getTop() * (-1));
                    } else {
                        scrollView.getChildAt(0).setTranslationY(0.0f);
                    }
                }
            };
        }
        this.mErrorMenuView.addOnLayoutChangeListener(this.mErrorMenuViewOnLayoutChangeListener);
    }

    public void initProgress(View view) {
        this.mResultProgress.initProgress(view);
    }

    public void initSTTHelpView(View view) {
        this.mSTTHelpView = (ViewGroup) view.findViewById(C9086R.id.ai_menu_result_stt_help_container);
    }

    public boolean isNotAvailable() {
        return !this.mContract.isShowing() || this.mContract.getPageList().isEmpty();
    }

    public boolean isShowingAnyProgress() {
        return this.mContinuesProgress.isShowing() || isShowingProgress();
    }

    public boolean isShowingErrorMessage() {
        return this.mErrorMenuView.getVisibility() == 0;
    }

    public boolean isShowingProgress() {
        return this.mResultProgress.isShowingProgress();
    }

    public boolean isWorking() {
        return isShowingProgress() || !this.mTopView.mContextBtn.isEnabled();
    }

    public void resetSTTView() {
        ViewGroup viewGroup = this.mSTTHelpView;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        getTopView().mTabLayout.setVisibility(8);
        getTopView().mSTTDropdown.setVisibility(8);
        getTopView().mSTTSelectAllContainer.setVisibility(8);
        getSTTSearchView().hideSearchView();
        this.mResultProgress.getTranscribeProgressCancelBtn().setVisibility(8);
    }

    public void search(String str, boolean z, int i) {
        this.mSearchText = str;
        search(z, i);
    }

    public void setAlphaBottomButtons(float f) {
        this.mBottomView.setAlphaBottomButtons(f);
    }

    public void setBottomButtonsState(boolean z) {
        this.mBottomView.setBottomButtonsState(z);
    }

    public void setLanguageDetectedText(String str) {
        this.mResultProgress.getTextProgress().setProgressInfoText(str, this.mActivity);
    }

    public void setTopButtonState(boolean z) {
        this.mTopView.setTopButtonState(z);
    }

    public void setTopButtonsVisibility(@Nullable List<Integer> list) {
        this.mTopView.setButtonsVisibility(list);
    }

    public void setViewPager(ViewPager2 viewPager2) {
        this.mViewPager = viewPager2;
    }

    public void showErrorMessage() {
        this.mErrorMenuView.setVisibility(0);
        getBottomView().setIsShowingErrorMenuView(true);
        setBottomButtonsState(false);
        getBottomView().hide(false);
        setTopButtonState(false);
        ViewPager2 viewPager2 = this.mViewPager;
        if (viewPager2 != null) {
            viewPager2.setVisibility(4);
        }
    }

    public void showProgress(int i) {
        this.mResultProgress.showProgress(i);
        setTopButtonState(false);
    }

    public void showWaterMark() {
        if (this.mChinaWaterMark == null) {
            initWaterMark();
        }
        View view = this.mChinaWaterMark;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public void updatePercentProgress(int i) {
        AiResultProgress aiResultProgress = this.mResultProgress;
        if (aiResultProgress != null) {
            aiResultProgress.updatePercentProgress(i);
        }
    }

    public void hideProgress(boolean z) {
        this.mResultProgress.hideProgress();
        if (z) {
            setTopButtonState(true);
        }
    }

    public void search(final boolean z, final int i) {
        this.mSTTSearchView.search(this.mSearchText, new STTSearchPresenter.Callback() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.b
            @Override // com.samsung.android.support.senl.nt.stt.presenter.STTSearchPresenter.Callback
            public final void onSearchDone() {
                this.f6936a.lambda$search$0(i, z);
            }
        });
        this.mContract.getPresenter().getSTTTabletLayoutAction().getIAiSTTContract().getSTTPresenter().onUpdateMoveBtnState();
    }
}
