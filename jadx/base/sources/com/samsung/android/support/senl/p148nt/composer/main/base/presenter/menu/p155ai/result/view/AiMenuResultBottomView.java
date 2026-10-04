package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.HorizontalScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ListPopupWindow;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.winset.accessibility.VoiceAssistAsButton;
import com.samsung.android.support.senl.p148nt.base.winset.util.ButtonShapeUtil;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.ViewUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiCommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiViewUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AiMenuContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AiMenuResultViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.ResultOperation;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.BackgroundColorUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.stt.ISTTWindow;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiMenuResultBottomView {
    private static final String TAG = Logger.createTag("AiMenuResultBottomView", AiConstants.PREFIX_TAG);
    private View mAddToBtn;
    private AddToListPopup mAddToListPopup;
    private ViewGroup mBottomContainer;
    private List<View> mButtonList;
    Contract mContract;
    private View mCopyBtn;
    private ValueAnimator mFadeInOutAnimator;
    private View mGenerateOneMoreBtn;
    private TextView mGenerateOneMoreTextView;
    private boolean mIsDisabled;
    private boolean mIsFixedFlag;
    private boolean mIsShowingState;
    private Runnable mPostShow;
    private View mReplaceBtn;
    private boolean mReplaceEnableFlag;
    private TextView mReplaceTextView;
    private View mRetryBtn;
    private Animation mSlideDownAnimation;
    private Animation mSlideUpAnimation;
    private View mTranslateBtn;
    private TextView mTranslateTextView;
    private boolean mIsShowingErrorMenuView = false;
    private boolean mIsSupportedTranslate = !FeatureInfo.isVSTModel();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class AddToListPopup {
        private ListPopupWindow mListPopupWindow;
        private float mTextSizeInPx = -1.0f;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public interface OnClickListener {
            void onItemClick(ResultOperation.AddTo addTo);
        }

        public void hide() {
            ListPopupWindow listPopupWindow = this.mListPopupWindow;
            if (listPopupWindow == null || !listPopupWindow.isShowing()) {
                return;
            }
            this.mListPopupWindow.dismiss();
        }

        public void init(View view, boolean z, final OnClickListener onClickListener) {
            if (isInitialized()) {
                return;
            }
            Context context = view.getContext();
            final ArrayList arrayList = new ArrayList();
            if (z) {
                arrayList.add(ResultOperation.AddTo.EndOfNote);
                arrayList.add(ResultOperation.AddTo.NewNote);
            } else {
                arrayList.add(ResultOperation.AddTo.NewPageBefore);
                arrayList.add(ResultOperation.AddTo.EndOfNote);
                arrayList.add(ResultOperation.AddTo.NewNote);
            }
            ArrayAdapter<ResultOperation.AddTo> arrayAdapter = new ArrayAdapter<ResultOperation.AddTo>(context, C9086R.layout.comp_page_list_item_more_menu_item, arrayList) { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultBottomView.AddToListPopup.1
                @Override // android.widget.ArrayAdapter, android.widget.Adapter
                @NonNull
                public View getView(int i, @Nullable View view2, @NonNull ViewGroup viewGroup) {
                    if (view2 == null) {
                        view2 = LayoutInflater.from(viewGroup.getContext()).inflate(C9086R.layout.comp_page_list_item_more_menu_item, (ViewGroup) null);
                    }
                    TextView textView = (TextView) view2.findViewById(C9086R.id.comp_page_list_item_more_menu_title);
                    textView.setText(((ResultOperation.AddTo) arrayList.get(i)).getDisplayName());
                    if (AddToListPopup.this.mTextSizeInPx != -1.0f) {
                        textView.setTextSize(0, AddToListPopup.this.mTextSizeInPx);
                    }
                    return view2;
                }
            };
            ListPopupWindow listPopupWindow = new ListPopupWindow(view.getContext());
            this.mListPopupWindow = listPopupWindow;
            listPopupWindow.setAdapter(arrayAdapter);
            this.mListPopupWindow.setAnchorView(view);
            this.mListPopupWindow.setWidth(ViewUtil.measureContentWidth(context, arrayAdapter, DeviceInfo.isVSTModel() ? context.getResources().getDimensionPixelSize(C9086R.dimen.popup_menu_side_margin) * 2 : 0));
            this.mListPopupWindow.setModal(true);
            this.mListPopupWindow.setInputMethodMode(2);
            this.mListPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultBottomView.AddToListPopup.2
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                    onClickListener.onItemClick((ResultOperation.AddTo) arrayList.get(i));
                    AddToListPopup.this.hide();
                }
            });
            BackgroundColorUtil.setBlurInfoPopup(context, this.mListPopupWindow.getListView());
        }

        public boolean isInitialized() {
            return this.mListPopupWindow != null;
        }

        public void setTextSizeInPx(float f) {
            this.mTextSizeInPx = f;
        }

        public void show() {
            ListPopupWindow listPopupWindow = this.mListPopupWindow;
            if (listPopupWindow == null || listPopupWindow.isShowing()) {
                return;
            }
            Context context = this.mListPopupWindow.getAnchorView().getContext();
            this.mListPopupWindow.setDropDownGravity(8388613);
            this.mListPopupWindow.setHorizontalOffset(context.getResources().getDimensionPixelOffset(C9086R.dimen.ai_result_bottom_menu_end_margin));
            this.mListPopupWindow.setVerticalOffset((int) ResourceUtils.convertDpToPixel(context, 6.0f));
            this.mListPopupWindow.show();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        void close();

        void generateOneMore();

        int getCurrentItem();

        List<AiMenuContract.IAiActionResultView> getPageList();

        AiMenuResultViewPresenter getPresenter();

        boolean isShowing();

        void retry();
    }

    public AiMenuResultBottomView(Contract contract) {
        this.mContract = contract;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getDetailSAAutoFormatStyle(AiMenuContract.IAiActionResultView iAiActionResultView) {
        if (!(iAiActionResultView instanceof AutoFormatResultView)) {
            return "";
        }
        int styleNumber = ((AutoFormatResultView) iAiActionResultView).getStyleNumber();
        return styleNumber == 0 ? "a" : styleNumber == 1 ? "b" : styleNumber == 2 ? "c" : styleNumber == 3 ? "d" : styleNumber == 4 ? "e" : "";
    }

    private void initAnimation() {
        if (this.mSlideUpAnimation != null) {
            return;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        this.mSlideUpAnimation = translateAnimation;
        translateAnimation.setDuration(500L);
        this.mSlideUpAnimation.setInterpolator(new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f));
        TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
        this.mSlideDownAnimation = translateAnimation2;
        translateAnimation2.setDuration(330L);
        this.mSlideDownAnimation.setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.4f, 1.0f));
        this.mSlideDownAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultBottomView.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AiMenuResultBottomView.this.mBottomContainer.setVisibility(8);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        ValueAnimator valueAnimator = new ValueAnimator();
        this.mFadeInOutAnimator = valueAnimator;
        valueAnimator.setInterpolator(new LinearInterpolator());
    }

    private void initButtons() {
        this.mButtonList = new ArrayList();
        this.mCopyBtn = this.mBottomContainer.findViewById(C9086R.id.ai_menu_result_copy_btn);
        this.mAddToBtn = this.mBottomContainer.findViewById(C9086R.id.ai_menu_result_add_to_btn);
        this.mReplaceBtn = this.mBottomContainer.findViewById(C9086R.id.ai_menu_result_overwrite_btn);
        this.mRetryBtn = this.mBottomContainer.findViewById(C9086R.id.ai_menu_result_retry_btn);
        this.mGenerateOneMoreBtn = this.mBottomContainer.findViewById(C9086R.id.ai_menu_result_generate_one_more_btn);
        this.mTranslateBtn = this.mBottomContainer.findViewById(C9086R.id.ai_menu_result_translate_btn);
        initButtonLayout();
        setBottomButtonsState(true);
        final AddToListPopup.OnClickListener onClickListener = new AddToListPopup.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultBottomView.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultBottomView.AddToListPopup.OnClickListener
            public void onItemClick(ResultOperation.AddTo addTo) {
                Logger.m10999d(AiMenuResultBottomView.TAG, "onClick# addTo");
                AiMenuResultBottomView.this.addTo(addTo);
            }
        };
        final boolean zIsSinglePageNote = this.mContract.getPresenter().isSinglePageNote();
        this.mAddToBtn.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultBottomView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AiMenuResultBottomView.this.isEditMode()) {
                    ISTTWindow.IAIContract iAiSTTContract = AiMenuResultBottomView.this.mContract.getPresenter().getSTTTabletLayoutAction().getIAiSTTContract();
                    iAiSTTContract.saveSTTData(true);
                    iAiSTTContract.toggleEditMode();
                    return;
                }
                if (AiMenuResultBottomView.this.isSTTSelectionMode()) {
                    AiMenuResultBottomView.this.mContract.getPresenter().getSTTTabletLayoutAction().deleteSelectedTextData();
                    return;
                }
                if (AiMenuResultBottomView.this.mContract.getPresenter().requiredAddToNoteOnly()) {
                    AiMenuResultBottomView.this.addTo(ResultOperation.AddTo.NearContent);
                    return;
                }
                if (!AiMenuResultBottomView.this.mContract.getPresenter().canEditBodyText()) {
                    AiMenuResultBottomView.this.addTo(ResultOperation.AddTo.NewNote);
                    return;
                }
                if (AiMenuResultBottomView.this.mAddToListPopup == null || !AiMenuResultBottomView.this.mAddToListPopup.isInitialized()) {
                    AiMenuResultBottomView.this.mAddToListPopup = new AddToListPopup();
                    AiMenuResultBottomView.this.mAddToListPopup.init(view, zIsSinglePageNote, new AddToListPopup.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultBottomView.2.1
                        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultBottomView.AddToListPopup.OnClickListener
                        public void onItemClick(ResultOperation.AddTo addTo) {
                            AiMenuResultBottomView.this.mAddToListPopup.hide();
                            onClickListener.onItemClick(addTo);
                        }
                    });
                }
                AiMenuResultBottomView.this.mAddToListPopup.show();
            }
        });
        this.mCopyBtn.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultBottomView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Logger.m10999d(AiMenuResultBottomView.TAG, "onClick# copy");
                if (AiMenuResultBottomView.this.isNotAvailable()) {
                    return;
                }
                if (AiMenuResultBottomView.this.isEditMode()) {
                    ISTTWindow.IAIContract iAiSTTContract = AiMenuResultBottomView.this.mContract.getPresenter().getSTTTabletLayoutAction().getIAiSTTContract();
                    iAiSTTContract.saveSTTData(false);
                    iAiSTTContract.toggleEditMode();
                    return;
                }
                if (AiMenuResultBottomView.this.isSTTSelectionMode()) {
                    AiMenuResultBottomView.this.mContract.getPresenter().getSTTTabletLayoutAction().copySelectedTextData();
                    return;
                }
                if (AiMenuResultBottomView.this.isSTTSelectionSummaryMode()) {
                    AiMenuResultBottomView.this.mContract.getPresenter().getSTTSummarization().copy();
                    return;
                }
                AiMenuContract.IAiActionResultView iAiActionResultView = AiMenuResultBottomView.this.mContract.getPageList().get(AiMenuResultBottomView.this.mContract.getCurrentItem());
                AiMenuResultBottomView.this.updateCurrentText(iAiActionResultView);
                AiMenuResultBottomView.this.saveLastUsedStyle(iAiActionResultView);
                AiMenuContract.IAiAction action = iAiActionResultView.getAction();
                AiMenuResultBottomView.this.mContract.getPresenter().copy(iAiActionResultView.getAction());
                AiMenuResultBottomView.this.hide(true);
                boolean zIsRecognizedHwAiResult = AiMenuResultBottomView.this.mContract.getPresenter().isRecognizedHwAiResult();
                String str = ComposerSAConstants.SCREEN_DIALOGS_CTT_RESULT;
                ComposerSA.insertLog(zIsRecognizedHwAiResult ? ComposerSAConstants.SCREEN_DIALOGS_CTT_RESULT : "802", ComposerSAConstants.EVENT_AI_ACTION_COPY, action != null ? action.getDetailSAAiType() : "");
                if (AiMenuResultBottomView.this.isAutoFormatResultView(iAiActionResultView)) {
                    if (!AiMenuResultBottomView.this.mContract.getPresenter().isRecognizedHwAiResult()) {
                        str = "802";
                    }
                    ComposerSA.insertLog(str, ComposerSAConstants.EVENT_AI_AUTO_FORMAT_COPY, AiMenuResultBottomView.this.getDetailSAAutoFormatStyle(iAiActionResultView));
                }
                ComposerSA.insertLog("802", ComposerSAConstants.EVENT_AI_LENGTH_FOR_PAGE_COPY, action != null ? action.getDetailSAAiType() : "");
            }
        });
        this.mReplaceBtn.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultBottomView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Logger.m10999d(AiMenuResultBottomView.TAG, "onClick# overwrite");
                if (AiMenuResultBottomView.this.isNotAvailable()) {
                    return;
                }
                if (AiMenuResultBottomView.this.isSTTSelectionMode()) {
                    AiMenuResultBottomView.this.mContract.getPresenter().getSTTTabletLayoutAction().shareSelectedTextData();
                    return;
                }
                if (AiMenuResultBottomView.this.isSTTSelectionSummaryMode()) {
                    AiMenuResultBottomView.this.mContract.getPresenter().getSTTSummarization().shareSelectedSummaryItem();
                    return;
                }
                AiMenuContract.IAiActionResultView iAiActionResultView = AiMenuResultBottomView.this.mContract.getPageList().get(AiMenuResultBottomView.this.mContract.getCurrentItem());
                AiMenuResultBottomView.this.updateCurrentText(iAiActionResultView);
                AiMenuResultBottomView.this.saveLastUsedStyle(iAiActionResultView);
                AiMenuContract.IAiAction action = iAiActionResultView.getAction();
                AiMenuResultBottomView.this.mContract.getPresenter().overwrite(action);
                if (!AiMenuResultBottomView.this.isCreateImageResultView(iAiActionResultView)) {
                    AiMenuResultBottomView.this.mContract.close();
                }
                boolean zIsRecognizedHwAiResult = AiMenuResultBottomView.this.mContract.getPresenter().isRecognizedHwAiResult();
                String str = ComposerSAConstants.SCREEN_DIALOGS_CTT_RESULT;
                ComposerSA.insertLog(zIsRecognizedHwAiResult ? ComposerSAConstants.SCREEN_DIALOGS_CTT_RESULT : "802", ComposerSAConstants.EVENT_AI_ACTION_REPLACE, action != null ? action.getDetailSAAiType() : "");
                if (AiMenuResultBottomView.this.isAutoFormatResultView(iAiActionResultView)) {
                    if (!AiMenuResultBottomView.this.mContract.getPresenter().isRecognizedHwAiResult()) {
                        str = "802";
                    }
                    ComposerSA.insertLog(str, ComposerSAConstants.EVENT_AI_AUTO_FORMAT_REPLACE, AiMenuResultBottomView.this.getDetailSAAutoFormatStyle(iAiActionResultView));
                }
                ComposerSA.insertLog("802", ComposerSAConstants.EVENT_AI_LENGTH_FOR_PAGE_REPLACE, action != null ? action.getDetailSAAiType() : "");
            }
        });
        if (this.mContract.getPresenter().canReplace() || isSTTSelectionMode() || isSTTSelectionSummaryMode()) {
            this.mReplaceBtn.setVisibility(0);
        } else {
            this.mReplaceBtn.setVisibility(8);
            this.mButtonList.remove(this.mReplaceBtn);
        }
        this.mTranslateBtn.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultBottomView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AiCommonUtil.executeActionByOndevice(AiMenuResultBottomView.this.mContract.getPresenter().getActivity(), new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultBottomView.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AiMenuContract.IAiActionResultView iAiActionResultView = AiMenuResultBottomView.this.mContract.getPageList().get(AiMenuResultBottomView.this.mContract.getCurrentItem());
                        if (iAiActionResultView instanceof AiMenuContract.SubTransition.IParentView) {
                            AiMenuContract.SubTransition.IParentView iParentView = (AiMenuContract.SubTransition.IParentView) iAiActionResultView;
                            ComposerSA.insertLog("802", iParentView.isShowingSubTranslation() ? ComposerSAConstants.EVENT_AI_RESULT_VIEW_BOTTOM_BTN_SHOW_ORIGINAL : ComposerSAConstants.EVENT_AI_RESULT_VIEW_BOTTOM_BTN_TRANSLATE);
                            iParentView.toggleTranslate();
                        }
                    }
                });
            }
        });
        initSketchButtons();
    }

    private void initSketchButtons() {
        this.mRetryBtn.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultBottomView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Logger.m10999d(AiMenuResultBottomView.TAG, "onClick# retry");
                if (AiMenuResultBottomView.this.isNotAvailable()) {
                    return;
                }
                AiMenuResultBottomView.this.mContract.retry();
            }
        });
        View view = this.mGenerateOneMoreBtn;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultBottomView.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Logger.m10999d(AiMenuResultBottomView.TAG, "onClick# GenerateOneMore");
                    if (AiMenuResultBottomView.this.isNotAvailable()) {
                        return;
                    }
                    AiMenuResultBottomView.this.mContract.generateOneMore();
                }
            });
        }
    }

    private void insertAutoFormatUsedStyleLog(AiMenuContract.IAiActionResultView iAiActionResultView, String str) {
        String detailSAAutoFormatStyle = getDetailSAAutoFormatStyle(iAiActionResultView);
        if (TextUtils.isEmpty(detailSAAutoFormatStyle)) {
            return;
        }
        ComposerSA.insertLog(this.mContract.getPresenter().isRecognizedHwAiResult() ? ComposerSAConstants.SCREEN_DIALOGS_CTT_RESULT : "802", str, detailSAAutoFormatStyle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isAutoFormatResultView(AiMenuContract.IAiActionResultView iAiActionResultView) {
        return iAiActionResultView instanceof AutoFormatResultView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isCreateImageResultView(AiMenuContract.IAiActionResultView iAiActionResultView) {
        return iAiActionResultView instanceof CreateImageResultView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isNotAvailable() {
        return !this.mContract.isShowing() || this.mContract.getPageList().isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveLastUsedStyle(AiMenuContract.IAiActionResultView iAiActionResultView) {
        if (iAiActionResultView instanceof AutoFormatResultView) {
            ((AutoFormatResultView) iAiActionResultView).saveLastUsedStyle();
        }
    }

    private void scrollToFirstButton() {
        final HorizontalScrollView horizontalScrollView = (HorizontalScrollView) this.mBottomContainer.findViewById(C9086R.id.ai_menu_result_bottom_scroll_view);
        horizontalScrollView.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultBottomView.10
            @Override // java.lang.Runnable
            public void run() {
                horizontalScrollView.smoothScrollTo(horizontalScrollView.getLayoutDirection() == 1 ? horizontalScrollView.getChildAt(0).getWidth() - horizontalScrollView.getWidth() : 0, 0);
            }
        });
    }

    private void setButtonStyle(View view) {
        if (view == null) {
            return;
        }
        view.setAccessibilityDelegate(new VoiceAssistAsButton());
        ButtonShapeUtil.setButtonShapeEnabled(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCurrentText(AiMenuContract.IAiActionResultView iAiActionResultView) {
        if (iAiActionResultView instanceof AiMenuResultViewRecognizedHw) {
            ((AiMenuResultViewRecognizedHw) iAiActionResultView).updateCurrentText();
        }
    }

    public void addTo(ResultOperation.AddTo addTo) {
        if (isNotAvailable()) {
            return;
        }
        Logger.m10999d(TAG, "addTo#");
        AiMenuContract.IAiActionResultView iAiActionResultView = this.mContract.getPageList().get(this.mContract.getCurrentItem());
        updateCurrentText(iAiActionResultView);
        saveLastUsedStyle(iAiActionResultView);
        AiMenuContract.IAiAction action = iAiActionResultView.getAction();
        this.mContract.getPresenter().addTo(action, addTo);
        ResultOperation.AddTo addTo2 = ResultOperation.AddTo.EndOfNote;
        ComposerSA.insertLog(this.mContract.getPresenter().isRecognizedHwAiResult() ? ComposerSAConstants.SCREEN_DIALOGS_CTT_RESULT : "802", addTo2.equals(addTo) ? ComposerSAConstants.EVENT_AI_ACTION_ADD_TO_END_OF_NOTE : ResultOperation.AddTo.NewNote.equals(addTo) ? ComposerSAConstants.EVENT_AI_ACTION_ADD_TO_NEW_NOTE : ComposerSAConstants.EVENT_AI_ACTION_ADD_TO_NEW_PAGE_BEFORE, action != null ? action.getDetailSAAiType() : "");
        if (iAiActionResultView instanceof AutoFormatResultView) {
            insertAutoFormatUsedStyleLog(iAiActionResultView, addTo2.equals(addTo) ? ComposerSAConstants.EVENT_AI_AUTO_FORMAT_ADD_TO_END_OF_NOTE : ResultOperation.AddTo.NewNote.equals(addTo) ? ComposerSAConstants.EVENT_AI_AUTO_FORMAT_ADD_TO_NEW_NOTE : ComposerSAConstants.EVENT_AI_AUTO_FORMAT_ADD_TO_NEW_PAGE_BEFORE);
        }
        ComposerSA.insertLog("802", ComposerSAConstants.EVENT_AI_LENGTH_FOR_PAGE_ADD_TO, action != null ? action.getDetailSAAiType() : "");
        if (isCreateImageResultView(iAiActionResultView)) {
            return;
        }
        this.mContract.close();
    }

    public void clear() {
        AddToListPopup addToListPopup = this.mAddToListPopup;
        if (addToListPopup != null) {
            addToListPopup.hide();
        }
        this.mButtonList.clear();
    }

    public View getAddToBtn() {
        return this.mAddToBtn;
    }

    public View getCopyBtn() {
        return this.mCopyBtn;
    }

    public View getGenerateOneMoreBtn() {
        return this.mGenerateOneMoreBtn;
    }

    public TextView getGenerateOneMoreTextView() {
        return this.mGenerateOneMoreTextView;
    }

    public View getReplaceBtn() {
        return this.mReplaceBtn;
    }

    public TextView getReplaceTextView() {
        return this.mReplaceTextView;
    }

    public View getRetryBtn() {
        return this.mRetryBtn;
    }

    public View getView() {
        return this.mBottomContainer;
    }

    public void hide(boolean z) {
        hide(z, true);
    }

    public void hideAddToListPopup() {
        AddToListPopup addToListPopup = this.mAddToListPopup;
        if (addToListPopup != null) {
            addToListPopup.hide();
        }
    }

    public void init(View view) {
        View viewFindViewById;
        this.mReplaceEnableFlag = true;
        this.mIsDisabled = false;
        this.mIsShowingState = false;
        this.mIsFixedFlag = false;
        ViewGroup viewGroup = (ViewGroup) view;
        this.mBottomContainer = viewGroup;
        viewGroup.setVisibility(0);
        if (AiViewUtils.isSupportFloatingLayout() && (viewFindViewById = this.mBottomContainer.findViewById(C9086R.id.ai_menu_result_bottom_menu_container)) != null) {
            viewFindViewById.setBackgroundColor(0);
        }
        initButtons();
    }

    public void initButtonLayout() {
        this.mButtonList.clear();
        View view = this.mCopyBtn;
        if (view != null) {
            this.mButtonList.add(view);
            setButtonStyle((TextView) this.mCopyBtn.findViewById(C9086R.id.ai_menu_result_copy_text));
        }
        View view2 = this.mReplaceBtn;
        if (view2 != null) {
            if (view2.getVisibility() == 0) {
                this.mButtonList.add(this.mReplaceBtn);
            }
            TextView textView = (TextView) this.mReplaceBtn.findViewById(C9086R.id.ai_menu_result_overwrite_text);
            this.mReplaceTextView = textView;
            setButtonStyle(textView);
        }
        View view3 = this.mAddToBtn;
        if (view3 != null) {
            this.mButtonList.add(view3);
            TextView textView2 = (TextView) this.mAddToBtn.findViewById(C9086R.id.ai_menu_result_add_to_text);
            if (this.mContract.getPresenter().requiredAddToNoteOnly()) {
                textView2.setText(C9086R.string.ai_action_add_to_note);
            } else if (this.mContract.getPresenter().canEditBodyText()) {
                textView2.setText(C9086R.string.ai_action_add_to);
            } else {
                textView2.setText(C9086R.string.action_add_to_new_note);
            }
            textView2.requestLayout();
            setButtonStyle(textView2);
        }
        View view4 = this.mTranslateBtn;
        if (view4 != null) {
            this.mButtonList.add(view4);
            this.mTranslateBtn.setVisibility(8);
            TextView textView3 = (TextView) this.mTranslateBtn.findViewById(C9086R.id.ai_menu_result_translate_text);
            this.mTranslateTextView = textView3;
            textView3.setText(C9086R.string.translate);
            setButtonStyle(this.mTranslateTextView);
        }
        View view5 = this.mRetryBtn;
        if (view5 != null) {
            this.mButtonList.add(view5);
            this.mRetryBtn.setVisibility(8);
            setButtonStyle(this.mRetryBtn.findViewById(C9086R.id.ai_menu_result_retry_text));
        }
        View view6 = this.mGenerateOneMoreBtn;
        if (view6 != null) {
            this.mButtonList.add(view6);
            this.mGenerateOneMoreBtn.setVisibility(8);
            TextView textView4 = (TextView) this.mGenerateOneMoreBtn.findViewById(C9086R.id.ai_menu_result_generate_one_more_text);
            this.mGenerateOneMoreTextView = textView4;
            setButtonStyle(textView4);
        }
    }

    public boolean isDisabled() {
        return this.mIsDisabled;
    }

    public boolean isEditMode() {
        if (this.mContract.getPresenter().getSTTTabletLayoutAction() == null) {
            return false;
        }
        return this.mContract.getPresenter().getSTTTabletLayoutAction().getIAiSTTContract().isEditMode();
    }

    public boolean isPositionInRect(int i, int i2) {
        Rect rect = new Rect();
        this.mBottomContainer.getGlobalVisibleRect(rect);
        return rect.contains(i, i2);
    }

    public boolean isSTTSelectionMode() {
        if (this.mContract.getPresenter().getSTTTabletLayoutAction() == null) {
            return false;
        }
        return this.mContract.getPresenter().isSTTSelectionMode();
    }

    public boolean isSTTSelectionSummaryMode() {
        if (this.mContract.getPresenter().getSTTSummarization() == null) {
            return false;
        }
        return this.mContract.getPresenter().isSTTSelectionSummaryMode();
    }

    public boolean isShowing() {
        ViewGroup viewGroup = this.mBottomContainer;
        return viewGroup != null && viewGroup.getVisibility() == 0;
    }

    public void removePostShow() {
        if (this.mPostShow != null) {
            this.mContract.getPresenter().getHandler().removeCallbacks(this.mPostShow);
        }
    }

    public void setAlphaBottomButtons(float f) {
        this.mCopyBtn.setAlpha(f);
        if (this.mReplaceEnableFlag) {
            this.mReplaceBtn.setAlpha(f);
        }
        this.mAddToBtn.setAlpha(f);
        if (this.mIsSupportedTranslate) {
            this.mTranslateBtn.setAlpha(f);
        }
    }

    public void setBottomButtonsState(boolean z) {
        if (this.mCopyBtn == null) {
            return;
        }
        setAlphaBottomButtons(z ? 1.0f : 0.4f);
        this.mCopyBtn.setEnabled(z);
        if (this.mReplaceEnableFlag) {
            this.mReplaceBtn.setEnabled(z);
        }
        this.mAddToBtn.setEnabled(z);
        if (this.mIsSupportedTranslate) {
            this.mTranslateBtn.setEnabled(z);
        }
    }

    public void setButtonVisibility(List<View> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        for (View view : this.mButtonList) {
            if (list.contains(view)) {
                view.setVisibility(0);
            } else {
                view.setVisibility(8);
            }
        }
    }

    public void setDisabled(boolean z) {
        ViewGroup viewGroup;
        this.mIsDisabled = z;
        if (!z || (viewGroup = this.mBottomContainer) == null) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    public void setEnableReplace(boolean z) {
        if (this.mReplaceEnableFlag == z) {
            return;
        }
        AbstractC8014b.m7220v("setEnableReplace# ", TAG, z);
        this.mReplaceEnableFlag = z;
        this.mReplaceBtn.setEnabled(z);
        if (z) {
            this.mReplaceBtn.setAlpha(1.0f);
        } else {
            this.mReplaceBtn.setAlpha(0.4f);
        }
    }

    public void setFixed(boolean z) {
        if (this.mIsFixedFlag == z) {
            return;
        }
        this.mIsFixedFlag = z;
    }

    public void setIsShowingErrorMenuView(boolean z) {
        this.mIsShowingErrorMenuView = z;
    }

    public void setTextMenuVisible(boolean z) {
        View view;
        TextView textView;
        TextView textView2;
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.mCopyBtn);
        if (this.mContract.getPresenter().canReplace()) {
            arrayList.add(this.mReplaceBtn);
        }
        arrayList.add(this.mAddToBtn);
        if (z && this.mIsSupportedTranslate) {
            arrayList.add(this.mTranslateBtn);
        }
        setButtonVisibility(arrayList);
        View view2 = this.mReplaceBtn;
        if (view2 != null && view2.getVisibility() == 0 && (textView2 = this.mReplaceTextView) != null && textView2.getMeasuredWidth() == 0) {
            this.mReplaceTextView.requestLayout();
        }
        if (this.mIsSupportedTranslate && (view = this.mTranslateBtn) != null && view.getVisibility() == 0 && (textView = this.mTranslateTextView) != null && textView.getMeasuredWidth() == 0) {
            this.mTranslateTextView.requestLayout();
        }
    }

    public void show(boolean z) {
        show(z, false);
    }

    public void showDelay() {
        if (isShowing()) {
            return;
        }
        if (this.mPostShow == null) {
            this.mPostShow = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultBottomView.9
                @Override // java.lang.Runnable
                public void run() {
                    AiMenuResultBottomView.this.show(true);
                }
            };
        }
        this.mContract.getPresenter().getHandler().post(this.mPostShow);
    }

    public void updateTranslateButtonText(boolean z) {
        if (z) {
            this.mTranslateTextView.setText(C9086R.string.translate);
        } else {
            this.mTranslateTextView.setText(C9086R.string.ai_show_original);
        }
    }

    public void hide(boolean z, boolean z2) {
        if (this.mIsDisabled || this.mIsFixedFlag) {
            return;
        }
        removePostShow();
        if (isShowing()) {
            if (z2) {
                this.mIsShowingState = false;
            }
            initAnimation();
            if (this.mFadeInOutAnimator.isRunning()) {
                this.mFadeInOutAnimator.cancel();
            }
            if (z) {
                this.mFadeInOutAnimator.setFloatValues(1.0f, 0.0f);
                this.mFadeInOutAnimator.setDuration(100L);
                this.mFadeInOutAnimator.start();
            }
            this.mSlideUpAnimation.cancel();
            this.mSlideDownAnimation.cancel();
            if (z) {
                this.mBottomContainer.startAnimation(this.mSlideDownAnimation);
            } else {
                this.mBottomContainer.setVisibility(8);
            }
        }
    }

    public void show(boolean z, boolean z2) {
        if (this.mIsShowingErrorMenuView) {
            return;
        }
        if (this.mIsDisabled || isShowing() || (z2 && !this.mIsShowingState)) {
            if (isShowing()) {
                scrollToFirstButton();
                return;
            }
            return;
        }
        this.mIsShowingState = true;
        removePostShow();
        initAnimation();
        this.mSlideUpAnimation.cancel();
        this.mSlideDownAnimation.cancel();
        this.mBottomContainer.setVisibility(0);
        if (z) {
            this.mBottomContainer.startAnimation(this.mSlideUpAnimation);
            if (this.mFadeInOutAnimator.isRunning()) {
                this.mFadeInOutAnimator.cancel();
            }
            this.mFadeInOutAnimator.setFloatValues(0.0f, 1.0f);
            this.mFadeInOutAnimator.setDuration(200L);
            this.mFadeInOutAnimator.start();
        }
        scrollToFirstButton();
    }
}
