package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.pdf;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListPopupWindow;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.fragment.app.FragmentManager;
import com.airbnb.lottie.LottieAnimationView;
import com.samsung.android.sesl.visualeffect.ScanningEffectView;
import com.samsung.android.sesl.visualeffect.lighteffects.processinglight.ProcessingLightEffect;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.DisplayUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.base.winset.app.language.AiLanguageHelper;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.NoteManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.ViewUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiOnDeviceMemoryManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiViewUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog.SelectTranslateLanguageDialog;
import com.samsung.android.support.senl.p148nt.composer.main.base.widget.animation.ScanningAnimation;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import p039I2.DialogInterfaceOnClickListenerC0140a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TranslationLanguageSelector implements NoteManager.ObserverBackgroundColor {
    private static final int DEFAULT_MATCH_PARENT_LAYOUT = 0;
    private static final int DYNAMIC_WRAP_CONTENT_LAYOUT = 1;
    private static final float MAX_RATIO_OF_SCREEN_WIDTH = 0.7f;
    private static final String TAG = Logger.createTag("AI#TranslationLanguageSelector");
    private Activity mActivity;
    private View mComposerLayout;
    private View mContainer;
    private View mContainerDivider;
    private int mDefaultSelectorViewItemsWidth;
    private View mEffectView;
    private TextView mFromTextView;
    private boolean mIsPdfReader;
    private final TranslationLanguageModel mLanguageModel;
    private final View.OnLayoutChangeListener mLayoutChangeListener;
    private ProcessingLightEffect mLightEffect;
    private SelectorListener mListener;
    private int mMaxSelectorViewWidth;
    private int mMinSelectorViewWidth;
    private ModeManager mModeManager;
    private View mMoreBtn;
    private ListPopupWindow mMoreMenuPopupWindow;
    private View mSelectorView;
    private TextView mToTextView;
    private LottieAnimationView mTranslationAutoDetecting;
    private LottieAnimationView mTranslationProgress;
    private View mTranslationProgressContainer;
    private ImageView mTranslationToggle;
    private View mTranslationToggleBtn;
    private int mLayoutMode = 0;
    private AlertDialog mPdfOverlaySaveDialog = null;
    private final ScanningAnimation mScanningAnimation = new ScanningAnimation(TAG);
    private final AtomicBoolean mIsTranslating = new AtomicBoolean(false);
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface SelectorListener {
        void onChangedIsTranslating(boolean z);

        void onCloseClicked();

        void onFromLanguageClicked(float f, float f4);

        void onLocaleSelected();

        void onSaveAsNewNoteClicked();

        void onSelectLanguageDialogCancel();

        void onToLanguageClicked(float f, float f4);

        void onToggleClicked();
    }

    public TranslationLanguageSelector(TranslationLanguageModel translationLanguageModel) {
        this.mLanguageModel = translationLanguageModel;
        translationLanguageModel.setLanguageTagListener(new C9419f(this));
        this.mLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.g
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
                this.f6858a.lambda$new$0(view, i, i2, i4, i5, i6, i7, i8, i9);
            }
        };
    }

    private int calculateSelectorWidth() {
        int iMeasureContentWidth = ViewUtil.measureContentWidth(this.mFromTextView);
        int iMeasureContentWidth2 = ViewUtil.measureContentWidth(this.mToTextView);
        int i = iMeasureContentWidth + iMeasureContentWidth2 + this.mDefaultSelectorViewItemsWidth;
        String str = TAG;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, iMeasureContentWidth, "calculateSelectorWidth# ", ", (from: ", " / to : ");
        sbM1173s.append(iMeasureContentWidth2);
        sbM1173s.append(")");
        Logger.m10999d(str, sbM1173s.toString());
        if (i < this.mMinSelectorViewWidth) {
            AbstractC8014b.m7221w(new StringBuilder("calculateSelectorWidth# width to Min : "), str, this.mMinSelectorViewWidth);
            return this.mMinSelectorViewWidth;
        }
        if (i <= this.mMaxSelectorViewWidth) {
            return i;
        }
        AbstractC8014b.m7221w(new StringBuilder("calculateSelectorWidth# width to Max : "), str, this.mMaxSelectorViewWidth);
        return this.mMaxSelectorViewWidth;
    }

    private Animation getAlphaAnimation(float f, float f4, int i) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f, f4);
        alphaAnimation.setDuration(i);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        return alphaAnimation;
    }

    private void hideMoreButton() {
        View view = this.mMoreBtn;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private void initCloseButton() {
        this.mContainer.findViewById(C9086R.id.translation_close_btn).setOnClickListener(new ViewOnClickListenerC9416c(this, 1));
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void initContainer(ComposerViewPresenter composerViewPresenter) {
        View viewFindViewById;
        String str = TAG;
        Logger.m10999d(str, "initContainer# ");
        this.mLayoutMode = 0;
        Activity activity = composerViewPresenter.getActivity();
        this.mComposerLayout = activity.findViewById(C9086R.id.main_layout_container);
        if (isToolbarContainer()) {
            this.mLayoutMode = 1;
            this.mContainer = composerViewPresenter.getTlToolbarPresenter().getContainer();
            if (initToolbarContainer()) {
                composerViewPresenter.getTlToolbarPresenter().show();
            }
        } else {
            this.mContainer = activity.findViewById(C9086R.id.translate_overlay_language_selector_container);
        }
        if (this.mContainer == null) {
            Logger.m10999d(str, "initContainer# failed by invalid resource");
            return;
        }
        setColorTheme(composerViewPresenter.getBackgroundColor(), composerViewPresenter.isBackgroundColorInverted(), composerViewPresenter.hasBackgroundImage());
        this.mContainer.setVisibility(0);
        this.mComposerLayout.addOnLayoutChangeListener(this.mLayoutChangeListener);
        View viewFindViewById2 = activity.findViewById(C9086R.id.language_toolbar_divider);
        this.mContainerDivider = viewFindViewById2;
        viewFindViewById2.setVisibility(0);
        View viewFindViewById3 = this.mContainer.findViewById(C9086R.id.translation_language_selector);
        this.mSelectorView = viewFindViewById3;
        if (viewFindViewById3 != null && viewFindViewById3.getResources().getConfiguration().getLayoutDirection() == 1 && (viewFindViewById = this.mSelectorView.findViewById(C9086R.id.translation_language_direction)) != null) {
            viewFindViewById.setScaleX(-1.0f);
        }
        this.mEffectView = activity.findViewById(C9086R.id.main_layout_container);
        updateSelectorViewLayout(this.mLayoutMode, "initContainer");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initFromLanguageView() {
        View viewFindViewById = this.mContainer.findViewById(isToolbarContainer() ? C9086R.id.translation_language_from_container : C9086R.id.translation_language_from);
        if (isToolbarContainer() && (!DeviceUtils.isTabletModel() || this.mMinSelectorViewWidth == this.mMaxSelectorViewWidth)) {
            ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
            layoutParams.width = 0;
            viewFindViewById.setLayoutParams(layoutParams);
            viewFindViewById.invalidate();
        }
        this.mFromTextView = (TextView) viewFindViewById.findViewById(C9086R.id.translation_language_from_text);
        if (TextUtils.isEmpty(this.mLanguageModel.getFromLanguageTag())) {
            TextView textView = this.mFromTextView;
            textView.setText(textView.getResources().getString(C9086R.string.auto));
        } else {
            updateLanguageViewFromLanguageTag(this.mFromTextView, this.mLanguageModel.getFromLanguageTag());
            if (this.mLayoutMode == 1 && isEllipsize(this.mFromTextView)) {
                updateSelectorViewLayout(this.mLayoutMode, "initFromLanguageView");
            }
        }
        viewFindViewById.setOnClickListener(new ViewOnClickListenerC9416c(this, 0));
        StringBuilder sb = new StringBuilder();
        AbstractC8014b.m7202d(this.mContainer.getResources(), C9086R.string.source_language, sb, SQLKeyword.COMMA);
        sb.append((Object) this.mFromTextView.getText());
        viewFindViewById.setContentDescription(sb.toString());
    }

    private void initMoreButton() {
    }

    private void initProgressView() {
        this.mTranslationAutoDetecting = (LottieAnimationView) this.mContainer.findViewById(C9086R.id.translation_auto_detecting);
        this.mTranslationProgressContainer = this.mContainer.findViewById(C9086R.id.translation_progress_container);
        LottieAnimationView lottieAnimationView = this.mTranslationProgress;
        if (lottieAnimationView == null || !lottieAnimationView.isAnimating()) {
            LottieAnimationView lottieAnimationView2 = (LottieAnimationView) this.mContainer.findViewById(C9086R.id.translation_progress);
            this.mTranslationProgress = lottieAnimationView2;
            lottieAnimationView2.setAnimation(ComposerConstants.COVER_PROGRESS_LOTTIE_FILE);
            this.mTranslationProgress.setRepeatCount(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initToLanguageView() {
        View viewFindViewById = this.mContainer.findViewById(isToolbarContainer() ? C9086R.id.translation_language_to_container : C9086R.id.translation_language_to);
        if (isToolbarContainer() && (!DeviceUtils.isTabletModel() || this.mMinSelectorViewWidth == this.mMaxSelectorViewWidth)) {
            ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
            layoutParams.width = 0;
            viewFindViewById.setLayoutParams(layoutParams);
            viewFindViewById.invalidate();
        }
        this.mToTextView = (TextView) viewFindViewById.findViewById(C9086R.id.translation_language_to_text);
        if (!TextUtils.isEmpty(this.mLanguageModel.getToLanguageTag())) {
            updateLanguageViewFromLanguageTag(this.mToTextView, this.mLanguageModel.getToLanguageTag());
            if (this.mLayoutMode == 1 && isEllipsize(this.mToTextView)) {
                updateSelectorViewLayout(this.mLayoutMode, "initToLanguageView");
            }
        }
        viewFindViewById.setOnClickListener(new ViewOnClickListenerC9416c(this, 3));
        StringBuilder sb = new StringBuilder();
        AbstractC8014b.m7202d(this.mContainer.getResources(), C9086R.string.target_language, sb, SQLKeyword.COMMA);
        sb.append((Object) this.mToTextView.getText());
        viewFindViewById.setContentDescription(sb.toString());
    }

    private void initToggleButton(boolean z) {
        this.mTranslationToggle = (ImageView) this.mContainer.findViewById(C9086R.id.translation_toggle);
        View viewFindViewById = this.mContainer.findViewById(C9086R.id.translation_toggle_btn);
        this.mTranslationToggleBtn = viewFindViewById;
        viewFindViewById.setOnClickListener(new ViewOnClickListenerC9416c(this, 2));
        updateToggle(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean initToolbarContainer() {
        View view = this.mContainer;
        if (view == null) {
            return false;
        }
        this.mDefaultSelectorViewItemsWidth = (int) view.getResources().getDimension(C9086R.dimen.comp_tl_toolbar_default_items_width);
        if (DeviceUtils.isTabletModel()) {
            this.mMinSelectorViewWidth = Math.min((int) this.mContainer.getResources().getDimension(C9086R.dimen.comp_tl_toolbar_container_min_width), this.mComposerLayout.getWidth());
            int width = (int) (this.mComposerLayout.getWidth() * 0.7f);
            this.mMaxSelectorViewWidth = width;
            int i = this.mMinSelectorViewWidth;
            if (width < i) {
                this.mMaxSelectorViewWidth = i;
            }
        } else {
            int width2 = this.mComposerLayout.getWidth();
            this.mMaxSelectorViewWidth = width2;
            this.mMinSelectorViewWidth = width2;
        }
        String str = TAG;
        StringBuilder sb = new StringBuilder("initToolbarContainer# SelectorView Width MIN : ");
        sb.append(this.mMinSelectorViewWidth);
        sb.append(", MAX : ");
        AbstractC8014b.m7221w(sb, str, this.mMaxSelectorViewWidth);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isEllipsize(TextView textView) {
        return (textView == null || textView.getLayout() == null || textView.getLayout().getEllipsisCount(textView.getLineCount() - 1) <= 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$animateTranslationAutoDetecting$8() {
        View view = this.mContainer;
        if (view == null) {
            Logger.m10999d(TAG, "animateTranslationAutoDetecting# Ignored by invalid status");
            return;
        }
        if (this.mTranslationAutoDetecting == null) {
            this.mTranslationAutoDetecting = (LottieAnimationView) view.findViewById(C9086R.id.translation_auto_detecting);
        }
        LottieAnimationView lottieAnimationView = this.mTranslationAutoDetecting;
        if (lottieAnimationView == null || lottieAnimationView.isAnimating()) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.mTranslationAutoDetecting.getLayoutParams();
        layoutParams.height = this.mContainer.getHeight();
        this.mTranslationAutoDetecting.setLayoutParams(layoutParams);
        float fCalculateSelectorWidth = isToolbarContainer() ? calculateSelectorWidth() : DisplayUtils.getWidthPx(this.mComposerLayout.getContext());
        float dimensionPixelSize = this.mContainer.getResources().getDimensionPixelSize(C9086R.dimen.ai_pdf_translation_language_auto_detecting_effect_width);
        boolean z = this.mTranslationAutoDetecting.getLayoutDirection() == 1;
        if (z) {
            this.mTranslationAutoDetecting.setScaleX(-1.0f);
        }
        if (fCalculateSelectorWidth > dimensionPixelSize) {
            this.mTranslationAutoDetecting.setTranslationX((dimensionPixelSize - fCalculateSelectorWidth) / (z ? -2 : 2));
        }
        String str = TAG;
        StringBuilder sbM1176v = AbstractC0622a.m1176v("animateTranslationAutoDetecting# selectorWidth : ", fCalculateSelectorWidth, ", effectWidth : ", dimensionPixelSize, ", containerHeight : ");
        sbM1176v.append(layoutParams.height);
        sbM1176v.append(", isNightMode : ");
        sbM1176v.append(ContextUtils.isNightMode(this.mContainer.getContext()));
        Logger.m10999d(str, sbM1176v.toString());
        this.mTranslationAutoDetecting.setClipToOutline(true);
        this.mTranslationAutoDetecting.setRepeatCount(0);
        this.mTranslationAutoDetecting.setAnimation(ContextUtils.isNightMode(this.mContainer.getContext()) ? ComposerConstants.TRANSLATION_AUTO_DETECTING_DARK_LOTTIE_FILE : ComposerConstants.TRANSLATION_AUTO_DETECTING_LIGHT_LOTTIE_FILE);
        this.mTranslationAutoDetecting.playAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$hideTranslationProgress$7() {
        ProcessingLightEffect processingLightEffect;
        View view = this.mTranslationProgressContainer;
        if (view == null || view.getVisibility() == 8) {
            Logger.m10999d(TAG, "hideTranslationProgress# Ignored by invalid status");
            return;
        }
        Logger.m10999d(TAG, "hideTranslationProgress# execute");
        this.mTranslationProgressContainer.setVisibility(8);
        this.mTranslationToggleBtn.setVisibility(0);
        this.mTranslationProgress.cancelAnimation();
        SelectorListener selectorListener = this.mListener;
        if (selectorListener != null) {
            selectorListener.onChangedIsTranslating(false);
        }
        if (Build.VERSION.SDK_INT < 33 || (processingLightEffect = this.mLightEffect) == null) {
            return;
        }
        processingLightEffect.stop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initCloseButton$4(View view) {
        SelectorListener selectorListener = this.mListener;
        if (selectorListener != null) {
            selectorListener.onCloseClicked();
            ComposerSA.insertLog(getScreenID(), ComposerSAConstants.EVENT_PDF_VIEWER_END_TRANSLATE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initFromLanguageView$1(View view) {
        float fCenterX;
        float height;
        if (this.mListener != null) {
            if (isToolbarContainer()) {
                Rect rect = new Rect();
                view.getGlobalVisibleRect(rect);
                Logger.m10999d(TAG, "fromLanguageView#onClick " + rect);
                fCenterX = (float) (rect.centerX() - (this.mComposerLayout.getWidth() / 2));
                height = (float) (this.mActivity.getWindow().getDecorView().getHeight() - ((rect.centerY() + rect.bottom) / 2));
            } else {
                fCenterX = 0.0f;
                height = 0.0f;
            }
            this.mListener.onFromLanguageClicked(fCenterX, height);
            ComposerSA.insertLog(getScreenID(), ComposerSAConstants.EVENT_PDF_VIEWER_SOURCE_LANGUAGE_BUTTON);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initToLanguageView$2(View view) {
        float fCenterX;
        float height;
        if (this.mListener != null) {
            if (isToolbarContainer()) {
                Rect rect = new Rect();
                view.getGlobalVisibleRect(rect);
                Logger.m10999d(TAG, "toLanguageView#onClick " + rect);
                fCenterX = (float) (rect.centerX() - (this.mComposerLayout.getWidth() / 2));
                height = (float) (this.mActivity.getWindow().getDecorView().getHeight() - ((rect.centerY() + rect.bottom) / 2));
            } else {
                fCenterX = 0.0f;
                height = 0.0f;
            }
            this.mListener.onToLanguageClicked(fCenterX, height);
            ComposerSA.insertLog(getScreenID(), ComposerSAConstants.EVENT_PDF_VIEWER_TARGET_LANGUAGE_BUTTON);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initToggleButton$3(View view) {
        SelectorListener selectorListener = this.mListener;
        if (selectorListener != null) {
            selectorListener.onToggleClicked();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view, final int i, int i2, final int i4, int i5, int i6, int i7, int i8, int i9) {
        if (this.mLayoutMode != 0) {
            if (i == i6 && i4 == i8) {
                return;
            }
            new Handler().post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.TranslationLanguageSelector.1
                @Override // java.lang.Runnable
                public void run() {
                    if (TranslationLanguageSelector.this.isShowing()) {
                        Logger.m10999d(TranslationLanguageSelector.TAG, "onLayoutChange# left : " + i + ", right : " + i4 + " width : " + (i4 - i) + ", composerLayout width : " + TranslationLanguageSelector.this.mComposerLayout.getWidth());
                        if (TranslationLanguageSelector.this.isToolbarContainer() && TranslationLanguageSelector.this.initToolbarContainer()) {
                            TranslationLanguageSelector.this.initFromLanguageView();
                            TranslationLanguageSelector.this.initToLanguageView();
                        }
                        TranslationLanguageSelector translationLanguageSelector = TranslationLanguageSelector.this;
                        translationLanguageSelector.updateSelectorViewLayout(translationLanguageSelector.mLayoutMode, "onLayoutChange");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showSaveAsPdfOverlay$11(DialogInterface dialogInterface) {
        this.mPdfOverlaySaveDialog = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showSaveAsPdfOverlay$9(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        SelectorListener selectorListener = this.mListener;
        if (selectorListener != null) {
            selectorListener.onSaveAsNewNoteClicked();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showTranslationProgress$6() {
        View view = this.mTranslationProgressContainer;
        if (view == null || view.getVisibility() == 0) {
            Logger.m10999d(TAG, "showTranslationProgress# Ignored by invalid status");
            return;
        }
        Logger.m10999d(TAG, "showTranslationProgress# execute");
        this.mTranslationToggleBtn.setVisibility(4);
        this.mTranslationProgressContainer.setVisibility(0);
        this.mTranslationProgress.playAnimation();
        SelectorListener selectorListener = this.mListener;
        if (selectorListener != null) {
            selectorListener.onChangedIsTranslating(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateLanguage$5() {
        updateLanguageViewFromLanguageTag(this.mFromTextView, this.mLanguageModel.getFromLanguageTag());
        updateLanguageViewFromLanguageTag(this.mToTextView, this.mLanguageModel.getToLanguageTag());
        this.mHandler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.TranslationLanguageSelector.2
            @Override // java.lang.Runnable
            public void run() {
                if (TranslationLanguageSelector.this.mLayoutMode == 1) {
                    if (TranslationLanguageSelector.isEllipsize(TranslationLanguageSelector.this.mFromTextView) || TranslationLanguageSelector.isEllipsize(TranslationLanguageSelector.this.mToTextView)) {
                        TranslationLanguageSelector translationLanguageSelector = TranslationLanguageSelector.this;
                        translationLanguageSelector.updateSelectorViewLayout(translationLanguageSelector.mLayoutMode, "updateLanguage");
                    }
                }
            }
        });
        View view = this.mContainer;
        if (view != null) {
            View viewFindViewById = view.findViewById(C9086R.id.translation_language_from);
            View viewFindViewById2 = this.mContainer.findViewById(C9086R.id.translation_language_to);
            StringBuilder sb = new StringBuilder();
            AbstractC8014b.m7202d(this.mContainer.getResources(), C9086R.string.source_language, sb, SQLKeyword.COMMA);
            sb.append((Object) this.mFromTextView.getText());
            viewFindViewById.setContentDescription(sb.toString());
            StringBuilder sb2 = new StringBuilder();
            AbstractC8014b.m7202d(this.mContainer.getResources(), C9086R.string.target_language, sb2, SQLKeyword.COMMA);
            sb2.append((Object) this.mToTextView.getText());
            viewFindViewById2.setContentDescription(sb2.toString());
        }
    }

    private void runAnimationSetVI(@Nullable final Runnable runnable, View view, Animation... animationArr) {
        AnimationSet animationSet = new AnimationSet(true);
        for (Animation animation : animationArr) {
            animationSet.addAnimation(animation);
        }
        animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.TranslationLanguageSelector.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation2) {
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    runnable2.run();
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation2) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation2) {
            }
        });
        view.startAnimation(animationSet);
    }

    private void setColorTheme(int i, boolean z, boolean z2) {
        Logger.m11003i(TAG, "setColorTheme# not supported");
    }

    private void setThemeToView(ViewGroup viewGroup, int i) {
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof ViewGroup) {
                setThemeToView((ViewGroup) childAt, i);
            } else if (childAt instanceof TextView) {
                ((TextView) childAt).setTextColor(i);
            }
        }
    }

    private void showMoreButton() {
        View view = this.mMoreBtn;
        if (view == null || view.getVisibility() == 0) {
            return;
        }
        this.mMoreBtn.setVisibility(0);
    }

    private void showMoreOptionList(View view) {
        Logger.m10999d(TAG, "showMoreOptionList#");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(view.getContext(), C9086R.layout.comp_page_list_item_more_menu_item, new String[]{view.getResources().getString(C9086R.string.add_to_new_note)}) { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.TranslationLanguageSelector.6
            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            @NonNull
            public View getView(int i, @Nullable View view2, @NonNull ViewGroup viewGroup) {
                if (view2 == null) {
                    view2 = LayoutInflater.from(viewGroup.getContext()).inflate(C9086R.layout.comp_page_list_item_more_menu_item, (ViewGroup) null);
                }
                ((TextView) view2.findViewById(C9086R.id.comp_page_list_item_more_menu_title)).setText((CharSequence) getItem(i));
                return view2;
            }
        };
        int iMeasureContentWidth = ViewUtil.measureContentWidth(view.getContext(), arrayAdapter);
        ListPopupWindow listPopupWindow = new ListPopupWindow(view.getContext());
        this.mMoreMenuPopupWindow = listPopupWindow;
        listPopupWindow.setAdapter(arrayAdapter);
        this.mMoreMenuPopupWindow.setAnchorView(view);
        this.mMoreMenuPopupWindow.setDropDownGravity(8388693);
        this.mMoreMenuPopupWindow.setModal(true);
        this.mMoreMenuPopupWindow.setWidth(iMeasureContentWidth);
        this.mMoreMenuPopupWindow.setInputMethodMode(2);
        this.mMoreMenuPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.TranslationLanguageSelector.7
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                if (TranslationLanguageSelector.this.mMoreMenuPopupWindow != null) {
                    TranslationLanguageSelector.this.mMoreMenuPopupWindow.dismiss();
                }
                TranslationLanguageSelector.this.showSaveAsPdfOverlay(view2);
            }
        });
        this.mMoreMenuPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.TranslationLanguageSelector.8
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                Logger.m10999d(TranslationLanguageSelector.TAG, "showMoreOptionList# onDismiss");
                if (TranslationLanguageSelector.this.mMoreMenuPopupWindow != null) {
                    TranslationLanguageSelector.this.mMoreMenuPopupWindow.setAdapter(null);
                    TranslationLanguageSelector.this.mMoreMenuPopupWindow = null;
                }
            }
        });
        this.mMoreMenuPopupWindow.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSaveAsPdfOverlay(View view) {
        AlertDialogBuilderForAppCompat alertDialogBuilderForAppCompat = new AlertDialogBuilderForAppCompat(view.getContext());
        alertDialogBuilderForAppCompat.setPositiveButton(view.getContext().getResources().getString(C9086R.string.dialog_save), new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f6855a.lambda$showSaveAsPdfOverlay$9(dialogInterface, i);
            }
        }).setNegativeButton(view.getContext().getResources().getString(C9086R.string.dialog_cancel), new DialogInterfaceOnClickListenerC0140a(15)).setTitle(view.getContext().getResources().getString(C9086R.string.ai_pdfoverlay_dialog_title)).setMessage(view.getContext().getResources().getString(C9086R.string.ai_pdfoverlay_dialog_message));
        AlertDialog alertDialogCreate = alertDialogBuilderForAppCompat.create();
        this.mPdfOverlaySaveDialog = alertDialogCreate;
        alertDialogCreate.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.e
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f6856a.lambda$showSaveAsPdfOverlay$11(dialogInterface);
            }
        });
        Window window = this.mPdfOverlaySaveDialog.getWindow();
        if (window == null) {
            return;
        }
        window.setGravity(17);
        this.mPdfOverlaySaveDialog.show();
    }

    private void updateLanguageViewFromLanguageTag(TextView textView, String str) {
        String str2 = TAG;
        Logger.m10999d(str2, "updateLanguageViewFromLanguageTag# languageTag : " + str);
        if (TextUtils.isEmpty(str) || !AiLanguageHelper.isDownloadedLanguage(AiLanguageHelper.getLocale(str))) {
            Logger.m10999d(str2, "updateLanguageViewFromLanguageTag# Ignored by not supported.");
            return;
        }
        Locale locale = AiLanguageHelper.getLocale(str);
        if (textView == null || locale == null) {
            return;
        }
        textView.setMaxLines(ResourceUtils.isTabletLayout(textView.getContext()) ? 1 : 2);
        textView.setText(AiLanguageHelper.getDisplayName(locale));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSelectorViewLayout(int i, String str) {
        String str2 = TAG;
        StringBuilder sbM1629s = AbstractC2322a.m1629s("updateSelectorViewLayout# layoutMode : ", i, ", caller : ", str, ", from : ");
        TextView textView = this.mFromTextView;
        sbM1629s.append((Object) (textView != null ? textView.getText() : ""));
        sbM1629s.append(", to : ");
        TextView textView2 = this.mToTextView;
        sbM1629s.append((Object) (textView2 != null ? textView2.getText() : ""));
        Logger.m11003i(str2, sbM1629s.toString());
        View view = this.mSelectorView;
        if (view == null) {
            Logger.m11003i(str2, "updateSelectorViewLayout# Ignored by invalid status");
            return;
        }
        this.mLayoutMode = i;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (this.mLayoutMode == 1) {
            layoutParams.width = calculateSelectorWidth();
        } else {
            layoutParams.width = -1;
        }
        this.mSelectorView.setLayoutParams(layoutParams);
        this.mSelectorView.invalidate();
    }

    public void animateTranslationAutoDetecting() {
        if (!FeatureInfo.isSupportTranslationLanguageAutoDetectingEffect()) {
            Logger.m10999d(TAG, "animateTranslationAutoDetecting# Not supported");
        } else {
            Logger.m10999d(TAG, "animateTranslationAutoDetecting#");
            this.mHandler.post(new RunnableC9415b(this, 1));
        }
    }

    public void clearLanguage() {
        TextView textView;
        TextView textView2;
        if (TextUtils.isEmpty(this.mLanguageModel.getFromLanguageTag()) && (textView2 = this.mFromTextView) != null) {
            textView2.setMaxLines(ResourceUtils.isTabletLayout(textView2.getContext()) ? 1 : 2);
            this.mFromTextView.setText("");
        }
        if (!TextUtils.isEmpty(this.mLanguageModel.getToLanguageTag()) || (textView = this.mToTextView) == null) {
            return;
        }
        textView.setMaxLines(ResourceUtils.isTabletLayout(textView.getContext()) ? 1 : 2);
        this.mToTextView.setText("");
    }

    public String getScreenID() {
        boolean z = this.mIsPdfReader;
        ModeManager modeManager = this.mModeManager;
        boolean zIsEditMode = modeManager != null ? modeManager.isEditMode() : false;
        ModeManager modeManager2 = this.mModeManager;
        return ComposerSA.getScreenID(z, zIsEditMode, modeManager2 != null ? modeManager2.isMode(Mode.Writing) : false, ResourceUtils.isTabletLayout(this.mActivity));
    }

    public void hide() {
        AlertDialog alertDialog = this.mPdfOverlaySaveDialog;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.mPdfOverlaySaveDialog.dismiss();
        }
        ListPopupWindow listPopupWindow = this.mMoreMenuPopupWindow;
        if (listPopupWindow != null) {
            listPopupWindow.dismiss();
        }
        View view = this.mContainer;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.mContainerDivider;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    public void hideTranslationProgress() {
        String str = TAG;
        Logger.m10999d(str, "hideTranslationProgress#");
        if (this.mIsTranslating.get()) {
            this.mIsTranslating.set(false);
            Logger.m10999d(str, "hideTranslationProgress# AiOnDeviceMemoryManager.release");
            AiOnDeviceMemoryManager.getInstance().release(hashCode(), str);
        }
        this.mHandler.post(new RunnableC9415b(this, 3));
    }

    public void initLayout(ComposerViewPresenter composerViewPresenter, boolean z, SelectorListener selectorListener) {
        if (composerViewPresenter == null || composerViewPresenter.getActivity() == null) {
            return;
        }
        this.mActivity = composerViewPresenter.getActivity();
        this.mModeManager = composerViewPresenter.getComposerModel().getModeManager();
        this.mIsPdfReader = composerViewPresenter.getComposerModel().isPDFReader();
        this.mListener = selectorListener;
        initContainer(composerViewPresenter);
        if (this.mContainer == null) {
            return;
        }
        initFromLanguageView();
        initToLanguageView();
        initToggleButton(z);
        initMoreButton();
        initCloseButton();
        initProgressView();
    }

    public boolean isShowing() {
        View view = this.mContainer;
        return view != null && view.getVisibility() == 0;
    }

    public boolean isToolbarContainer() {
        return FeatureInfo.isSupportPdfTranslationOverlayFloatingToolbar();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.composer.NoteManager.ObserverBackgroundColor
    public void onChangedBackgroundColor(int i, boolean z, boolean z2) {
        setColorTheme(i, z, z2);
    }

    public void release() {
        this.mListener = null;
        this.mContainer = null;
        View view = this.mComposerLayout;
        if (view != null) {
            view.removeOnLayoutChangeListener(this.mLayoutChangeListener);
            this.mComposerLayout = null;
        }
        if (this.mIsTranslating.get()) {
            this.mIsTranslating.set(false);
            String str = TAG;
            Logger.m10999d(str, "release# AiOnDeviceMemoryManager.release");
            AiOnDeviceMemoryManager.getInstance().release(hashCode(), str);
        }
    }

    public void reload() {
        updateSelectorViewLayout(this.mLayoutMode, "reload");
    }

    public void showLanguageSelectorDialog(final boolean z, float f, float f4, FragmentManager fragmentManager) {
        final boolean z2;
        Locale locale;
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.Menu;
        if (UserInputSkipper.isValidEvent(tag)) {
            UserInputSkipper.setHoldingEventTime(300L, tag);
            String str = SelectTranslateLanguageDialog.TAG;
            SelectTranslateLanguageDialog selectTranslateLanguageDialog = (SelectTranslateLanguageDialog) fragmentManager.findFragmentByTag(str);
            boolean z3 = selectTranslateLanguageDialog != null;
            if (!z3) {
                selectTranslateLanguageDialog = new SelectTranslateLanguageDialog();
            }
            SelectTranslateLanguageDialog selectTranslateLanguageDialog2 = selectTranslateLanguageDialog;
            Locale locale2 = AiLanguageHelper.getLocale(this.mLanguageModel.getFromLanguageTag());
            Locale locale3 = AiLanguageHelper.getLocale(this.mLanguageModel.getToLanguageTag());
            if (z) {
                z2 = this.mLanguageModel.getFromLanguageState() == 1;
                locale = locale2;
            } else {
                z2 = this.mLanguageModel.getToLanguageState() == 1;
                locale = locale3;
            }
            selectTranslateLanguageDialog2.setContract(z, locale, f, f4, new SelectTranslateLanguageDialog.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.TranslationLanguageSelector.3
                private boolean isUnavailable(int i) {
                    return i != 0;
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.dialog.SelectTranslateLanguageDialog.Contract
                public void onCancel(boolean z4) {
                    if (TranslationLanguageSelector.this.mListener != null) {
                        TranslationLanguageSelector.this.mListener.onSelectLanguageDialogCancel();
                    }
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.dialog.SelectTranslateLanguageDialog.Contract
                public void setSelectedLocale(Locale locale4) {
                    String languageTag = locale4.toLanguageTag();
                    Logger.m11003i(TranslationLanguageSelector.TAG, "setSelectedLocale# " + z + " - " + languageTag);
                    if (z) {
                        if (TranslationLanguageSelector.this.mLanguageModel.getFromLanguageTag().equals(languageTag) && (!z2 || isUnavailable(TranslationLanguageSelector.this.mLanguageModel.getFromLanguageState()))) {
                            return;
                        } else {
                            TranslationLanguageSelector.this.mLanguageModel.setFromLanguageTag(languageTag);
                        }
                    } else if (TranslationLanguageSelector.this.mLanguageModel.getToLanguageTag().equals(languageTag) && (!z2 || isUnavailable(TranslationLanguageSelector.this.mLanguageModel.getToLanguageState()))) {
                        return;
                    } else {
                        TranslationLanguageSelector.this.mLanguageModel.setToLanguageTag(languageTag);
                    }
                    if (TranslationLanguageSelector.this.mListener != null) {
                        TranslationLanguageSelector.this.mListener.onLocaleSelected();
                    }
                }
            });
            try {
                if (z3) {
                    Logger.m11003i(TAG, "showLanguageSelectorDialog - already Added/Resumed");
                } else {
                    Logger.m11003i(TAG, "showLanguageSelectorDialog - Add");
                    selectTranslateLanguageDialog2.showAllowingStateLoss(fragmentManager, str);
                }
            } catch (IllegalStateException e) {
                Logger.m11003i(TAG, "showLanguageSelectorDialog - e: " + e.getMessage());
            }
        }
    }

    public void showProcessingEffectView() {
        int i = Build.VERSION.SDK_INT;
        if (i < 33) {
            Logger.m11004w(TAG, "showProcessingEffectView# not supported version : " + i);
            return;
        }
        Activity activity = this.mActivity;
        if (activity == null || activity.isDestroyed() || this.mActivity.isFinishing()) {
            Logger.m11004w(TAG, "showProcessingEffectView# activity is invalid " + this.mActivity);
            return;
        }
        if (AiViewUtils.isAtLeastOneUI7()) {
            if (this.mLightEffect == null) {
                this.mLightEffect = AiViewUtils.makeAiPdfOverlayProcessingLightEffect(this.mEffectView);
            }
            if (this.mLightEffect != null) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.TranslationLanguageSelector.4
                    @Override // java.lang.Runnable
                    public void run() {
                        TranslationLanguageSelector.this.mLightEffect.stop();
                    }
                }, 2000L);
                this.mLightEffect.start();
                return;
            }
            return;
        }
        if (this.mScanningAnimation.getScanningEffectView() == null) {
            this.mScanningAnimation.setScanningEffectView((ScanningEffectView) this.mActivity.findViewById(C9086R.id.scanning_effect_view));
        }
        if (this.mScanningAnimation.getScanningEffectView() == null || this.mScanningAnimation.isScanningAnimating()) {
            Logger.m10999d(TAG, "showScanningEffectView# Ignored by invalid status");
            return;
        }
        ScanningAnimation scanningAnimation = this.mScanningAnimation;
        Activity activity2 = this.mActivity;
        scanningAnimation.showScanningEffectView(activity2, activity2.findViewById(C9086R.id.appbar_layout));
    }

    public void showTranslationProgress() {
        String str = TAG;
        Logger.m10999d(str, "showTranslationProgress#");
        if (!this.mIsTranslating.get()) {
            this.mIsTranslating.set(true);
            Logger.m10999d(str, "showTranslationProgress# AiOnDeviceMemoryManager.ready");
            AiOnDeviceMemoryManager.getInstance().ready(hashCode(), str);
        }
        this.mHandler.post(new RunnableC9415b(this, 2));
    }

    public void updateLanguage() {
        RunnableC9415b runnableC9415b = new RunnableC9415b(this, 0);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnableC9415b.run();
        } else {
            this.mHandler.post(runnableC9415b);
        }
    }

    public void updateToggle(boolean z) {
        Drawable drawable;
        AbstractC8014b.m7220v("updateToggle# isTranslationOverlayActivated : ", TAG, z);
        if (z) {
            showMoreButton();
            if (this.mContainer != null && !isToolbarContainer()) {
                View view = this.mContainer;
                view.setBackgroundColor(view.getContext().getColor(C9086R.color.ai_pdf_translation_overlay_language_selector_active_bg));
            }
            drawable = AppCompatResources.getDrawable(this.mTranslationToggle.getContext(), C9086R.drawable.ic_ai_translate_solid);
            showProcessingEffectView();
            ComposerSA.insertLog(getScreenID(), ComposerSAConstants.EVENT_PDF_VIEWER_TRANSLATE_ON_OFF, "a");
        } else {
            hideMoreButton();
            if (this.mContainer != null && !isToolbarContainer()) {
                View view2 = this.mContainer;
                view2.setBackgroundColor(view2.getContext().getColor(C9086R.color.ai_pdf_translation_overlay_language_selector_bg));
            }
            drawable = AppCompatResources.getDrawable(this.mTranslationToggle.getContext(), C9086R.drawable.ic_ai_translate);
            ComposerSA.insertLog(getScreenID(), ComposerSAConstants.EVENT_PDF_VIEWER_TRANSLATE_ON_OFF, "b");
        }
        this.mTranslationToggle.setImageDrawable(drawable);
    }
}
