package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import androidx.fragment.app.FragmentManager;
import com.airbnb.lottie.LottieAnimationView;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import com.samsung.android.sdk.pen.widget.listener.SpenTextManagerActionListener;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.winset.app.language.AiLanguageHelper;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.coedit.utils.CoeditUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiViewUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AiMenuContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.Translation;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AbsAiActionResultView;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AiMenuResultViewTranslation;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerRequestCode;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog.SelectTranslateLanguageDialog;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiMenuResultViewTranslation extends AbsAiActionResultView implements AiMenuContract.ResultListener {
    public static final String TAG = Logger.createTag("AiMenuResultViewTranslation", AiConstants.PREFIX_TAG);
    BroadcastReceiver mBroadcastAddedReceiver;
    BroadcastReceiver mBroadcastRemovedReceiver;
    Contract mContract;
    TextView mErrorMsgView;
    boolean mIsEnableLongClick;
    LanguageSelectorView mLanguageSelectorView;
    int mOrientation;
    View mPanelView;
    SimpleEditView mSimpleEditView;
    Translation mTranslation;
    LottieAnimationView mTranslationAutoDetecting;
    View mView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract extends AiMenuContract.IAiActionResultContainer {
        void hide();

        boolean isSummaryTranslations();

        boolean updateEditedRecognizedHw();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class LanguageSelectorView {
        TextView mFromTextView;
        View mFromView;
        private int mFromWidth;
        View mLanguageContainer;
        View mSwitchButton;
        TextView mToTextView;
        View mToView;
        private int mToWidth;

        public LanguageSelectorView() {
        }

        private int getDefaultLangContainerWidth() {
            return this.mLanguageContainer.getResources().getDimensionPixelSize(C9086R.dimen.ai_menu_result_translation_language_min_width_portrait);
        }

        private Locale getValidToLanguage(Locale locale) {
            AiLanguageHelper.Language language = null;
            if (locale == null) {
                return null;
            }
            AiLanguageHelper.Language language2 = new AiLanguageHelper.Language(AiLanguageHelper.getLocale(locale.toLanguageTag()));
            Iterator<AiLanguageHelper.Language> it = AiLanguageHelper.getSourceLanguageList().iterator();
            while (true) {
                if (it.hasNext()) {
                    AiLanguageHelper.Language next = it.next();
                    if (next != null && next.getLocale() != null) {
                        if (next.equals(language2)) {
                            break;
                        }
                        if ("en".equals(next.getLocale().getLanguage()) || ((LangPackConfigConstants.LANGUAGE_CODE_ES.equals(next.getLocale().getLanguage()) && (language == null || language.getLocale() == null || !"en".equals(language.getLocale().getLanguage()))) || language == null)) {
                            language = next;
                        }
                    }
                } else if (language != null) {
                    return language.getLocale();
                }
            }
            return locale;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$initLanguageLayout$0(View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
            animateTranslationAutoDetecting(this.mLanguageContainer.getHeight());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$initLanguageLayout$1(View view) {
            Translation translation = AiMenuResultViewTranslation.this.mTranslation;
            if (translation == null) {
                Logger.m11000e(AiMenuResultViewTranslation.TAG, "onClick# from: null");
                return;
            }
            translation.setIsFistTime(false);
            Logger.m10999d(AiMenuResultViewTranslation.TAG, "onClick# from: " + ((Object) this.mFromTextView.getText()));
            AiMenuResultViewTranslation.this.showLanguageSelectorDialog(true);
            ComposerSA.insertLog("401", ComposerSAConstants.EVENT_AI_TRANSLATE_LANGUAGE_DIALOG_SOURCE, AiMenuResultViewTranslation.this.mTranslation.getFromLanguageTag());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$initLanguageLayout$2(View view) {
            if (AiMenuResultViewTranslation.this.mTranslation == null) {
                Logger.m11000e(AiMenuResultViewTranslation.TAG, "onClick# to: null");
                return;
            }
            Logger.m10999d(AiMenuResultViewTranslation.TAG, "onClick# to: " + ((Object) this.mToTextView.getText()));
            AiMenuResultViewTranslation.this.showLanguageSelectorDialog(false);
            ComposerSA.insertLog("401", ComposerSAConstants.EVENT_AI_TRANSLATE_LANGUAGE_DIALOG_TARGET, AiMenuResultViewTranslation.this.mTranslation.getToLanguageTag());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$initLanguageLayout$3(View view) {
            Translation translation = AiMenuResultViewTranslation.this.mTranslation;
            if (translation == null) {
                Logger.m11000e(AiMenuResultViewTranslation.TAG, "onClick# switch: null");
                return;
            }
            if (translation.isSame()) {
                Logger.m11000e(AiMenuResultViewTranslation.TAG, "onClick# switch: same language");
                return;
            }
            AiMenuResultViewTranslation.this.mTranslation.switchLanguageTag();
            updateLanguage();
            ComposerSA.insertLog("401", ComposerSAConstants.EVENT_AI_TRANSLATE_LANGUAGE_TRANSLATE, "d");
            AiMenuResultViewTranslation.this.requestTranslate(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$initLanguageLayout$4(View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
            int i10 = i4 - i;
            if (i8 - i6 != i10) {
                updateLayout(i10);
            }
        }

        private void requestUpdateLayout(int i, int i2, int i4) {
            AbstractC8014b.m7221w(AbstractC0622a.m1173s(i, i2, "requestUpdateLayout#", ": ", "/"), AiConstants.LAYOUT_DEBUG_TAG, i4);
            this.mLanguageContainer.getLayoutParams().width = i2;
            this.mLanguageContainer.requestLayout();
        }

        private void restoreEdgeCase() {
            if (this.mFromTextView.getVisibility() == 0) {
                return;
            }
            Logger.m10999d(AiConstants.LAYOUT_DEBUG_TAG, "restoreEdgeCase#");
            this.mToTextView.setVisibility(0);
            this.mFromTextView.setVisibility(0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateLanguage() {
            TextView textView;
            TextView textView2;
            Locale locale = AiLanguageHelper.getLocale(AiMenuResultViewTranslation.this.mTranslation.getFromLanguageTag());
            Locale validToLanguage = getValidToLanguage(AiLanguageHelper.getLocale(AiMenuResultViewTranslation.this.mTranslation.getToLanguageTag()));
            if (locale != null && (textView2 = this.mFromTextView) != null) {
                textView2.setMaxLines(AiLanguageHelper.isSeperateLanguagePack(locale.getLanguage()) ? 2 : 1);
                String displayName = AiLanguageHelper.getDisplayName(locale);
                this.mFromTextView.setText(displayName);
                this.mFromWidth = (int) this.mFromTextView.getPaint().measureText(displayName);
            }
            if (validToLanguage != null && (textView = this.mToTextView) != null) {
                textView.setMaxLines(AiLanguageHelper.isSeperateLanguagePack(validToLanguage.getLanguage()) ? 2 : 1);
                String displayName2 = AiLanguageHelper.getDisplayName(validToLanguage);
                this.mToTextView.setText(displayName2);
                this.mToWidth = (int) this.mToTextView.getPaint().measureText(displayName2);
            }
            updateLayout(AiMenuResultViewTranslation.this.mPanelView.getWidth());
        }

        public void animateTranslationAutoDetecting(int i) {
            if (!FeatureInfo.isSupportTranslationLanguageAutoDetectingEffect()) {
                Logger.m10999d(AiMenuResultViewTranslation.TAG, "animateTranslationAutoDetecting# Not supported");
                return;
            }
            Logger.m10999d(AiMenuResultViewTranslation.TAG, "animateTranslationAutoDetecting#");
            LottieAnimationView lottieAnimationView = AiMenuResultViewTranslation.this.mTranslationAutoDetecting;
            if (lottieAnimationView == null || lottieAnimationView.isAnimating()) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = AiMenuResultViewTranslation.this.mTranslationAutoDetecting.getLayoutParams();
            layoutParams.height = i;
            layoutParams.width = i * 4;
            AiMenuResultViewTranslation.this.mTranslationAutoDetecting.setLayoutParams(layoutParams);
            AiMenuResultViewTranslation.this.mTranslationAutoDetecting.setClipToOutline(true);
            AiMenuResultViewTranslation.this.mTranslationAutoDetecting.setRepeatCount(0);
            AiMenuResultViewTranslation.this.mTranslationAutoDetecting.setAnimation(ContextUtils.isNightMode(AiMenuResultViewTranslation.this.mTranslationAutoDetecting.getContext()) ? ComposerConstants.TRANSLATION_AUTO_DETECTING_DARK_LOTTIE_FILE : ComposerConstants.TRANSLATION_AUTO_DETECTING_LIGHT_LOTTIE_FILE);
            if (AiMenuResultViewTranslation.this.mTranslationAutoDetecting.getLayoutDirection() == 1) {
                AiMenuResultViewTranslation.this.mTranslationAutoDetecting.setScaleX(-1.0f);
            }
        }

        public void initLanguageLayout(View view) {
            View viewFindViewById = view.findViewById(C9086R.id.translation_language_selector);
            this.mLanguageContainer = viewFindViewById;
            final int i = 0;
            viewFindViewById.addOnLayoutChangeListener(new View.OnLayoutChangeListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.I

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ AiMenuResultViewTranslation.LanguageSelectorView f6925b;

                {
                    this.f6925b = this;
                }

                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view2, int i2, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
                    switch (i) {
                        case 0:
                            this.f6925b.lambda$initLanguageLayout$0(view2, i2, i4, i5, i6, i7, i8, i9, i10);
                            break;
                        default:
                            this.f6925b.lambda$initLanguageLayout$4(view2, i2, i4, i5, i6, i7, i8, i9, i10);
                            break;
                    }
                }
            });
            View viewFindViewById2 = view.findViewById(C9086R.id.translation_language_from);
            this.mFromView = viewFindViewById2;
            viewFindViewById2.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.J

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ AiMenuResultViewTranslation.LanguageSelectorView f6927b;

                {
                    this.f6927b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    switch (i) {
                        case 0:
                            this.f6927b.lambda$initLanguageLayout$1(view2);
                            break;
                        case 1:
                            this.f6927b.lambda$initLanguageLayout$2(view2);
                            break;
                        default:
                            this.f6927b.lambda$initLanguageLayout$3(view2);
                            break;
                    }
                }
            });
            this.mFromTextView = (TextView) this.mFromView.findViewById(C9086R.id.translation_language_from_text);
            this.mFromView.setAccessibilityDelegate(new View.AccessibilityDelegate() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewTranslation.LanguageSelectorView.1
                @Override // android.view.View.AccessibilityDelegate
                public void onInitializeAccessibilityNodeInfo(@NonNull View view2, @NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
                    super.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfo);
                    accessibilityNodeInfo.setContentDescription(((Object) LanguageSelectorView.this.mFromView.getContentDescription()) + SQLKeyword.COMMA + ((Object) LanguageSelectorView.this.mFromTextView.getText()));
                }
            });
            View viewFindViewById3 = view.findViewById(C9086R.id.translation_language_to);
            this.mToView = viewFindViewById3;
            final int i2 = 1;
            viewFindViewById3.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.J

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ AiMenuResultViewTranslation.LanguageSelectorView f6927b;

                {
                    this.f6927b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    switch (i2) {
                        case 0:
                            this.f6927b.lambda$initLanguageLayout$1(view2);
                            break;
                        case 1:
                            this.f6927b.lambda$initLanguageLayout$2(view2);
                            break;
                        default:
                            this.f6927b.lambda$initLanguageLayout$3(view2);
                            break;
                    }
                }
            });
            this.mToTextView = (TextView) this.mToView.findViewById(C9086R.id.translation_language_to_text);
            this.mToView.setAccessibilityDelegate(new View.AccessibilityDelegate() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewTranslation.LanguageSelectorView.2
                @Override // android.view.View.AccessibilityDelegate
                public void onInitializeAccessibilityNodeInfo(@NonNull View view2, @NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
                    super.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfo);
                    accessibilityNodeInfo.setContentDescription(((Object) LanguageSelectorView.this.mToView.getContentDescription()) + SQLKeyword.COMMA + ((Object) LanguageSelectorView.this.mToTextView.getText()));
                }
            });
            View viewFindViewById4 = view.findViewById(C9086R.id.translation_language_change_btn);
            this.mSwitchButton = viewFindViewById4;
            final int i4 = 2;
            viewFindViewById4.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.J

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ AiMenuResultViewTranslation.LanguageSelectorView f6927b;

                {
                    this.f6927b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    switch (i4) {
                        case 0:
                            this.f6927b.lambda$initLanguageLayout$1(view2);
                            break;
                        case 1:
                            this.f6927b.lambda$initLanguageLayout$2(view2);
                            break;
                        default:
                            this.f6927b.lambda$initLanguageLayout$3(view2);
                            break;
                    }
                }
            });
            final int i5 = 1;
            AiMenuResultViewTranslation.this.mPanelView.addOnLayoutChangeListener(new View.OnLayoutChangeListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.I

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ AiMenuResultViewTranslation.LanguageSelectorView f6925b;

                {
                    this.f6925b = this;
                }

                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view2, int i22, int i42, int i52, int i6, int i7, int i8, int i9, int i10) {
                    switch (i5) {
                        case 0:
                            this.f6925b.lambda$initLanguageLayout$0(view2, i22, i42, i52, i6, i7, i8, i9, i10);
                            break;
                        default:
                            this.f6925b.lambda$initLanguageLayout$4(view2, i22, i42, i52, i6, i7, i8, i9, i10);
                            break;
                    }
                }
            });
        }

        public void updateLayout(int i) {
            int i2;
            if (i != 0) {
                if (this.mFromWidth == 0 && this.mToWidth == 0) {
                    return;
                }
                Resources resources = this.mLanguageContainer.getResources();
                int dimensionPixelSize = i - resources.getDimensionPixelSize(C9086R.dimen.ai_result_translation_side_margin_portrait);
                int dimensionPixelSize2 = resources.getDimensionPixelSize(C9086R.dimen.ai_result_translation_language_switch_size);
                int dimensionPixelSize3 = resources.getDimensionPixelSize(C9086R.dimen.ai_result_translation_language_inner_horizontal_margin);
                int dimensionPixelSize4 = resources.getDimensionPixelSize(C9086R.dimen.ai_menu_result_translation_language_btn_end_padding) + resources.getDimensionPixelSize(C9086R.dimen.ai_menu_result_translation_language_btn_start_padding);
                int dimensionPixelSize5 = resources.getDimensionPixelSize(C9086R.dimen.ai_menu_result_translation_between_arrow_n_language) + resources.getDimensionPixelSize(C9086R.dimen.ai_menu_result_translation_arrow_size);
                int i4 = ((((dimensionPixelSize - dimensionPixelSize2) - dimensionPixelSize3) / 2) - dimensionPixelSize5) - dimensionPixelSize4;
                int defaultLangContainerWidth = getDefaultLangContainerWidth();
                int i5 = ((((defaultLangContainerWidth - dimensionPixelSize2) - dimensionPixelSize3) / 2) - dimensionPixelSize5) - dimensionPixelSize4;
                int iMax = Math.max(this.mFromWidth, this.mToWidth);
                if (i5 <= i4) {
                    restoreEdgeCase();
                    if (iMax <= i5) {
                        requestUpdateLayout(1, defaultLangContainerWidth, iMax);
                        return;
                    } else if (iMax < i4) {
                        requestUpdateLayout(2, AbstractC1974b.m1304A(iMax, i5, 2, defaultLangContainerWidth), iMax);
                        return;
                    } else {
                        requestUpdateLayout(3, dimensionPixelSize, i4);
                        return;
                    }
                }
                if (iMax <= i4) {
                    restoreEdgeCase();
                    requestUpdateLayout(4, dimensionPixelSize, iMax);
                    return;
                }
                if (i4 < 30) {
                    this.mToTextView.setVisibility(4);
                    this.mFromTextView.setVisibility(4);
                    i2 = 5;
                } else {
                    restoreEdgeCase();
                    i2 = 6;
                }
                if (i4 == 0) {
                    i4 = -1;
                }
                requestUpdateLayout(i2, dimensionPixelSize, i4);
            }
        }
    }

    public AiMenuResultViewTranslation(Translation translation, AiMenuResultCommonViews aiMenuResultCommonViews, Contract contract) {
        super(aiMenuResultCommonViews);
        this.mTranslation = translation;
        translation.setResultListener(this);
        this.mContract = contract;
        this.mOrientation = contract.getActivity().getResources().getConfiguration().orientation;
    }

    private void clearReceiver() {
        if (this.mBroadcastAddedReceiver != null) {
            AiLanguageHelper.unregisterLanguagePackReceiver(BaseUtils.getApplicationContext(), this.mBroadcastAddedReceiver);
            this.mBroadcastAddedReceiver = null;
        }
        if (this.mBroadcastRemovedReceiver != null) {
            AiLanguageHelper.unregisterLanguagePackReceiver(BaseUtils.getApplicationContext(), this.mBroadcastRemovedReceiver);
            this.mBroadcastRemovedReceiver = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean doInitialStep() {
        boolean z;
        this.mLanguageSelectorView.updateLanguage();
        Locale locale = AiLanguageHelper.getLocale(this.mTranslation.getFromLanguageTag());
        Locale locale2 = AiLanguageHelper.getLocale(this.mTranslation.getToLanguageTag());
        int fromLanguageState = this.mTranslation.getFromLanguageState();
        int toLanguageState = this.mTranslation.getToLanguageState();
        String str = TAG;
        AbstractC8014b.m7216r(fromLanguageState, toLanguageState, "doInitialStep# ", " - ", str);
        if (fromLanguageState != 2) {
            if (fromLanguageState == 1) {
                z = (locale == null || locale2 == null || !AiLanguageHelper.requestDownloadLanguagePack(this.mContract.getActivity(), locale, locale2, Integer.valueOf(ComposerRequestCode.DownloadLanguage.getId()))) ? false : true;
                updateNoLanguageHint();
            } else if (fromLanguageState != 0) {
                z = false;
            } else if (this.mTranslation.isSame()) {
                Logger.m10999d(str, "doInitialStep# same");
                showLanguageSelectorDialog(false);
                this.mTranslation.copyOriginNoteToResultNote();
            } else if (toLanguageState == 1) {
                z = (locale == null || locale2 == null || !AiLanguageHelper.requestDownloadLanguagePack(this.mContract.getActivity(), locale, locale2, Integer.valueOf(ComposerRequestCode.DownloadLanguage.getId()))) ? false : true;
                updateNoLanguageHint();
            } else {
                if (toLanguageState == 2) {
                    showLanguageSelectorDialog(false);
                }
                z = false;
            }
            if (z) {
                this.mCommonViews.hideProgress();
                this.mCommonViews.setBottomButtonsState(true);
                this.mContract.updateResultState(true, false);
            }
            return z;
        }
        showLanguageSelectorDialog(true);
        ToastHandler.show(BaseUtils.getApplicationContext(), C9086R.string.ai_not_supported_from_language, 1);
        z = true;
        if (z) {
        }
        return z;
    }

    private FragmentManager getSupportFragmentManager() {
        Contract contract = this.mContract;
        if (contract == null) {
            return null;
        }
        AppCompatActivity appCompatActivity = (AppCompatActivity) contract.getActivity();
        if (CoeditUtils.isActivityValid(appCompatActivity)) {
            return appCompatActivity.getSupportFragmentManager();
        }
        return null;
    }

    private void hideInnerErrorMsg() {
        this.mErrorMsgView.setVisibility(8);
        this.mPanelView.setVisibility(0);
        this.mPanelView.setImportantForAccessibility(0);
    }

    private void hideLanguageSelector() {
        SelectTranslateLanguageDialog selectTranslateLanguageDialog;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager == null || supportFragmentManager.isDestroyed() || (selectTranslateLanguageDialog = (SelectTranslateLanguageDialog) supportFragmentManager.findFragmentByTag(SelectTranslateLanguageDialog.TAG)) == null) {
            return;
        }
        selectTranslateLanguageDialog.dismiss();
    }

    private void initBroadcastReceiver() {
        AiLanguageHelper.updateLanguageList();
        if (this.mBroadcastAddedReceiver == null) {
            this.mBroadcastAddedReceiver = new BroadcastReceiver() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewTranslation.2
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    if (context == null || intent == null || AiMenuResultViewTranslation.this.mTranslation == null) {
                        Logger.m10999d(AiMenuResultViewTranslation.TAG, "addedReceiver# null");
                        return;
                    }
                    Logger.m11000e(AiMenuResultViewTranslation.TAG, "addedReceiver# " + intent.getStringExtra("locale"));
                    AiLanguageHelper.updateLanguageList();
                }
            };
        }
        AiLanguageHelper.registerLanguagePackAddedReceiver(BaseUtils.getApplicationContext(), this.mBroadcastAddedReceiver);
        if (this.mBroadcastRemovedReceiver == null) {
            this.mBroadcastRemovedReceiver = new BroadcastReceiver() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewTranslation.3
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    if (context == null || intent == null || AiMenuResultViewTranslation.this.mTranslation == null) {
                        Logger.m10999d(AiMenuResultViewTranslation.TAG, "removedReceiver# null");
                        return;
                    }
                    String stringExtra = intent.getStringExtra("locale");
                    Logger.m11000e(AiMenuResultViewTranslation.TAG, "removedReceiver# " + stringExtra);
                    AiLanguageHelper.updateLanguageList();
                }
            };
        }
        AiLanguageHelper.registerLanguagePackRemovedReceiver(BaseUtils.getApplicationContext(), this.mBroadcastRemovedReceiver);
    }

    private void initLanguage() {
        Logger.m10999d(TAG, "initLanguage#");
        if (this.mTranslation.getErrorType() != null) {
            showInnerErrorMsg();
            return;
        }
        if (this.mTranslation.isWaitingIdentifyLanguage()) {
            this.mTranslation.setLanguageIdentifierCallback(new C9687H(this));
        } else if (doInitialStep()) {
            return;
        }
        if (this.mTranslation.isWaitingFirstResult()) {
            return;
        }
        if (!TextUtils.isEmpty(this.mTranslation.getLastErrorMessage())) {
            onFailed(this.mTranslation.getLastErrorMessage());
            return;
        }
        this.mTranslation.updateResultNote();
        this.mTranslation.setFirstResult(true);
        onCompleted(this.mTranslation.isCompleted());
        this.mTranslation.setFirstResult(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initLanguage$4() {
        Logger.m10999d(TAG, "LanguageIdentifierCallback#onComplete#");
        if (doInitialStep() || this.mTranslation.isWaitingFirstResult()) {
            return;
        }
        this.mCommonViews.hideProgress();
        this.mContract.updateResultState(true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$initView$0(View view) {
        if (!this.mCommonViews.isShowingAnyProgress() && this.mTranslation.isCompleted() && this.mTranslation.canDoAction() && this.mIsEnableLongClick) {
            this.mCommonViews.mContract.getPresenter().startDragAndDrop(this.mSimpleEditView.getView(), this.mTranslation.getResultToCopy());
            this.mCommonViews.mContract.getPresenter().getComposerViewPresenter().getView().requestFocus();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$1(boolean z) {
        this.mCommonViews.mViewPager.setUserInputEnabled(!z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$2() {
        this.mIsEnableLongClick = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$initView$3(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        this.mIsEnableLongClick = true;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onLanguageDownload$5() {
        if (requestTranslate(false) && this.mTranslation.isHintShown()) {
            this.mTranslation.setHint("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean requestTranslate(boolean z) {
        int fromLanguageState = this.mTranslation.getFromLanguageState();
        int toLanguageState = this.mTranslation.getToLanguageState();
        if (this.mTranslation.isSame()) {
            if (!z) {
                this.mTranslation.copyOriginNoteToResultNote();
            }
            return false;
        }
        if (fromLanguageState != 0 || toLanguageState != 0) {
            return false;
        }
        Translation translation = this.mTranslation;
        translation.translate(translation.getOriginalText(), this.mTranslation.getFromLanguageTag(), this.mTranslation.getToLanguageTag());
        if (AiViewUtils.isSupportFloatingLayout()) {
            this.mSimpleEditView.clearSelection();
        }
        this.mCommonViews.setBottomButtonsState(false);
        this.mCommonViews.showProgress(1);
        return true;
    }

    private void showInnerErrorMsg() {
        this.mErrorMsgView.setText(this.mTranslation.getErrorType().getMsg(this.mErrorMsgView.getContext()));
        this.mErrorMsgView.setVisibility(0);
        this.mPanelView.setVisibility(8);
        this.mPanelView.setImportantForAccessibility(4);
    }

    private void updateNoLanguageHint() {
        Locale locale;
        Locale locale2;
        StringBuilder sb = new StringBuilder();
        int fromLanguageState = this.mTranslation.getFromLanguageState();
        int toLanguageState = this.mTranslation.getToLanguageState();
        if (fromLanguageState == 1 && (locale2 = AiLanguageHelper.getLocale(this.mTranslation.getFromLanguageTag())) != null) {
            sb.append(AiLanguageHelper.getDisplayName(locale2));
        }
        if (toLanguageState == 1 && (locale = AiLanguageHelper.getLocale(this.mTranslation.getToLanguageTag())) != null) {
            String displayName = AiLanguageHelper.getDisplayName(locale);
            if (sb.length() == 0) {
                sb.append(displayName);
            } else if (!sb.toString().equals(displayName)) {
                sb.append(SQLKeyword.COMMA);
                sb.append(displayName);
            }
        }
        this.mTranslation.setHint(this.mView.getResources().getString(C9086R.string.ai_translation_no_language_pack, sb.toString(), "").replace("()", ""));
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public void clear() {
        clearReceiver();
        SimpleEditView simpleEditView = this.mSimpleEditView;
        if (simpleEditView != null) {
            simpleEditView.release();
            this.mSimpleEditView = null;
        }
        Translation translation = this.mTranslation;
        if (translation != null) {
            translation.clear();
            this.mTranslation = null;
        }
        if (this.mView != null) {
            hideLanguageSelector();
            this.mView = null;
        }
        this.mContract = null;
        this.mTranslationAutoDetecting = null;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public AiMenuContract.IAiAction getAction() {
        return this.mTranslation;
    }

    public boolean hasTranslatedText() {
        return (this.mTranslation.getTranslatedText() == null || this.mTranslation.getTranslatedText().isEmpty()) ? false : true;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public View inflateView(ViewGroup viewGroup) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(C9086R.layout.ai_result_translation_layout, viewGroup, false);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    @SuppressLint({"ClickableViewAccessibility"})
    public void initView(View view, View view2) {
        if (this.mTranslation == null) {
            return;
        }
        this.mView = view2;
        this.mPanelView = view2.findViewById(C9086R.id.translation_panel);
        ViewGroup viewGroup = (ViewGroup) view2.findViewById(C9086R.id.translation_result_edit_view_container);
        SimpleEditView simpleEditView = new SimpleEditView(view.getContext(), this.mCommonViews.mContract.getPresenter());
        this.mSimpleEditView = simpleEditView;
        simpleEditView.attachView(viewGroup);
        this.mSimpleEditView.setSpenTextManagerActionListener(new SpenTextManagerActionListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewTranslation.1
            @Override // com.samsung.android.sdk.pen.widget.listener.SpenTextManagerActionListener
            public void onSelectionAreaLongPressed() {
                if (!AiMenuResultViewTranslation.this.mCommonViews.isShowingAnyProgress() && AiMenuResultViewTranslation.this.mTranslation.isCompleted() && AiMenuResultViewTranslation.this.mTranslation.canDoAction() && AiMenuResultViewTranslation.this.mIsEnableLongClick) {
                    ViewCompat.getInstance().performHapticFeedback(AiMenuResultViewTranslation.this.mSimpleEditView.getView(), 110);
                    AiMenuResultViewTranslation.this.mCommonViews.mContract.getPresenter().startDragAndDrop(AiMenuResultViewTranslation.this.mSimpleEditView.getView(), AiMenuResultViewTranslation.this.mSimpleEditView.getResultToCopy());
                    AiMenuResultViewTranslation.this.mSimpleEditView.getView().setOnDragListener(AiMenuResultViewTranslation.this.mSimpleEditView.onDragListener);
                }
            }
        });
        if (AiViewUtils.isSupportFloatingLayout()) {
            this.mSimpleEditView.setContextMenuListener();
        } else {
            this.mSimpleEditView.setOnLongClickListener(new ViewOnLongClickListenerC9715k(this, 2));
        }
        this.mSimpleEditView.setScrollBarListener(new C9687H(this));
        this.mSimpleEditView.setOnScrollListener(new C9687H(this));
        this.mSimpleEditView.setOnTouchListener(new ViewOnTouchListenerC9717m(this, 1));
        this.mSimpleEditView.setEnabledBlurEffect(true);
        this.mRestoreSpenEditViewScroll = new AbsAiActionResultView.RestoreSpenEditViewScroll(this.mSimpleEditView, this.mTranslation.getHandler());
        LanguageSelectorView languageSelectorView = new LanguageSelectorView();
        this.mLanguageSelectorView = languageSelectorView;
        languageSelectorView.initLanguageLayout(view2);
        this.mErrorMsgView = (TextView) view2.findViewById(C9086R.id.translation_error_msg_view);
        if (AiViewUtils.isSupportFloatingLayout()) {
            this.mErrorMsgView.setBackgroundColor(0);
            this.mTranslationAutoDetecting = (LottieAnimationView) view2.findViewById(C9086R.id.translation_auto_detecting_view);
        }
        initBroadcastReceiver();
        initLanguage();
    }

    public boolean isAvailableBottomMenu() {
        if (this.mTranslation.getErrorType() == null && hasTranslatedText()) {
            return this.mTranslation.isCompleted();
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public boolean isInitialized() {
        return this.mSimpleEditView != null;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.ResultListener
    public void onCompleted(boolean z) {
        if (isInitialized()) {
            this.mLanguageSelectorView.updateLanguage();
            this.mTranslation.updateResultNote();
            if (AiViewUtils.isSupportFloatingLayout()) {
                if (this.mTranslation.isFistTime() && FeatureInfo.isSupportTranslationLanguageAutoDetectingEffect()) {
                    this.mTranslationAutoDetecting.playAnimation();
                }
                this.mTranslation.setIsFistTime(false);
            }
            this.mSimpleEditView.initView(this.mTranslation.getResultNote(), this.mTranslation.getSrcContentInfo().mIsBGColorInverted, this.mView.getResources().getDimensionPixelSize(C9086R.dimen.ai_result_page_horizontal_padding), new boolean[0]);
            this.mContract.updateResultState(true, z);
            this.mCommonViews.hideProgress(z);
            this.mCommonViews.getBottomView().show(true);
            ComposerSA.insertLog("802", ComposerSAConstants.EVENT_AI_TRANSLATE_LANGUAGE, this.mTranslation.getFromLanguageTag() + "_" + this.mTranslation.getToLanguageTag());
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.ResultListener
    public void onFailed(String str) {
        if (this.mCommonViews.handleRestrictedPersonalDataError(str)) {
            return;
        }
        this.mCommonViews.hideProgress();
        this.mCommonViews.mErrMsgView.setText(str);
        this.mCommonViews.showErrorMessage();
        this.mContract.updateResultState(false, false);
        if (this.mCommonViews.isShowingErrorMessage()) {
            return;
        }
        ToastHandler.show(this.mCommonViews.mErrMsgView.getContext(), str, 0);
    }

    public void onLanguageDownload() {
        Logger.m10999d(TAG, "onLanguageDownload#");
        AiLanguageHelper.updateLanguageList(new RunnableC9711g(this, 12));
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.ResultListener
    public void onNextCompleted(boolean z) {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AbsAiActionResultView, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public void onOrientationChanged(int i) {
        if (isInitialized()) {
            this.mOrientation = i;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AbsAiActionResultView, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public void onPageSelected() {
        this.mCommonViews.setTopButtonsVisibility(null);
        this.mCommonViews.setBottomButtonsState(isAvailableBottomMenu());
        if (isInitialized() && this.mContract.updateEditedRecognizedHw()) {
            Translation.ErrorType errorTypeCanExecute = this.mTranslation.canExecute();
            if (errorTypeCanExecute == null) {
                this.mCommonViews.showProgress(1);
                this.mCommonViews.setTopButtonState(false);
                this.mTranslation.setErrorType(null);
                this.mTranslation.execute();
                initLanguage();
                this.mLanguageSelectorView.updateLayout(this.mPanelView.getWidth());
                hideInnerErrorMsg();
                return;
            }
            if (Translation.ErrorType.MINIMUM.equals(errorTypeCanExecute)) {
                Logger.m10999d(TAG, "onPageSelected# minimum limitation");
            } else if (Translation.ErrorType.UNSUPPORTED_LANGUAGE.equals(errorTypeCanExecute)) {
                Logger.m10999d(TAG, "onPageSelected# unsupported language");
            }
            this.mTranslation.setErrorType(errorTypeCanExecute);
            this.mTranslation.setTranslatedText(" ");
            showInnerErrorMsg();
            this.mCommonViews.setBottomButtonsState(isAvailableBottomMenu());
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.ResultListener
    public void onProgressing() {
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public void setTitle() {
        this.mCommonViews.getTopView().setTitle(C9086R.string.ai_translate_name, C9086R.drawable.ic_ai_menu_title, (Integer) null);
    }

    public void showLanguageSelectorDialog(final boolean z) {
        FragmentManager supportFragmentManager;
        if (!isInitialized() || (supportFragmentManager = getSupportFragmentManager()) == null || supportFragmentManager.isDestroyed()) {
            return;
        }
        String str = SelectTranslateLanguageDialog.TAG;
        if (((SelectTranslateLanguageDialog) supportFragmentManager.findFragmentByTag(str)) != null) {
            return;
        }
        Locale locale = AiLanguageHelper.getLocale(this.mTranslation.getFromLanguageTag());
        Locale locale2 = AiLanguageHelper.getLocale(this.mTranslation.getToLanguageTag());
        if (locale == null || locale2 == null) {
            Logger.m11000e(TAG, "showLanguageSelectorDialog# null " + locale + "/" + locale2);
            return;
        }
        if (!z) {
            z = this.mTranslation.getToLanguageState() == 1;
            locale = locale2;
        } else if (this.mTranslation.getFromLanguageState() == 1) {
            z = true;
        }
        SelectTranslateLanguageDialog selectTranslateLanguageDialog = new SelectTranslateLanguageDialog();
        selectTranslateLanguageDialog.setContract(z, locale, new SelectTranslateLanguageDialog.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewTranslation.4
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.dialog.SelectTranslateLanguageDialog.Contract
            public void onAddLanguagesClick() {
                ComposerSA.insertLog("401", z ? ComposerSAConstants.EVENT_AI_TRANSLATE_LANGUAGE_DIALOG_SOURCE_ADD : ComposerSAConstants.EVENT_AI_TRANSLATE_LANGUAGE_DIALOG_TARGET_ADD);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.dialog.SelectTranslateLanguageDialog.Contract
            public void onCancel(boolean z2) {
                if (z2) {
                    AiMenuResultViewTranslation.this.mContract.hide();
                }
                ComposerSA.insertLog("401", z ? ComposerSAConstants.EVENT_AI_TRANSLATE_LANGUAGE_DIALOG_SOURCE_CANCEL : ComposerSAConstants.EVENT_AI_TRANSLATE_LANGUAGE_DIALOG_TARGET_CANCEL);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.dialog.SelectTranslateLanguageDialog.Contract
            public void setSelectedLocale(Locale locale3) {
                String languageTag = locale3.toLanguageTag();
                String fromLanguageTag = AiMenuResultViewTranslation.this.mTranslation.getFromLanguageTag();
                String toLanguageTag = AiMenuResultViewTranslation.this.mTranslation.getToLanguageTag();
                String languageTag2 = Locale.getDefault().toLanguageTag();
                Logger.m11003i(AiMenuResultViewTranslation.TAG, "setSelectedLocale# " + z + " - " + languageTag);
                if (AiMenuResultViewTranslation.this.mTranslation.isHintShown()) {
                    AiMenuResultViewTranslation.this.mTranslation.setHint("");
                }
                if (z) {
                    if (AiMenuResultViewTranslation.this.mTranslation.getFromLanguageTag().equals(languageTag) && (!z || AiMenuResultViewTranslation.this.mTranslation.getFromLanguageState() != 0)) {
                        return;
                    } else {
                        AiMenuResultViewTranslation.this.mTranslation.setFromLanguageTag(languageTag);
                    }
                } else {
                    if (AiMenuResultViewTranslation.this.mTranslation.getToLanguageTag().equals(languageTag) && (!z || AiMenuResultViewTranslation.this.mTranslation.getToLanguageState() != 0)) {
                        AiMenuResultViewTranslation.this.mCommonViews.getBottomView().show(true);
                        return;
                    }
                    AiMenuResultViewTranslation.this.mTranslation.setToLanguageTag(languageTag);
                }
                AiMenuResultViewTranslation.this.mLanguageSelectorView.updateLanguage();
                AiMenuResultViewTranslation.this.requestTranslate(z);
                String str2 = z ? ComposerSAConstants.EVENT_AI_TRANSLATE_LANGUAGE_DIALOG_SOURCE_TRANSLATE : ComposerSAConstants.EVENT_AI_TRANSLATE_LANGUAGE_DIALOG_TARGET_TRANSLATE;
                ComposerSA.insertLog("401", str2, languageTag);
                ComposerSA.insertLog("401", str2, "b", languageTag.equals(languageTag2) ? 1L : 0L);
                if (!z) {
                    fromLanguageTag = toLanguageTag;
                }
                ComposerSA.insertLog("401", str2, "c", languageTag.equals(fromLanguageTag) ? 1L : 0L);
                ComposerSA.insertLog("401", ComposerSAConstants.EVENT_AI_TRANSLATE_LANGUAGE_TRANSLATE, z ? "b" : "c");
            }
        });
        selectTranslateLanguageDialog.showAllowingStateLoss(supportFragmentManager, str);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AbsAiActionResultView
    public void updateHorizontalPadding(int i) {
        if (isInitialized()) {
            this.mSimpleEditView.updateHorizontalPadding(this.mView.getResources().getDimensionPixelSize(C9086R.dimen.ai_menu_result_side_margin_size));
        }
    }
}
