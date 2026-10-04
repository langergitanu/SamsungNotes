package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting;

import android.animation.Animator;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.tabs.TabLayout;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.provider.SettingsCompat;
import com.samsung.android.support.senl.p148nt.base.common.util.DisplayLanguageUtils;
import com.samsung.android.support.senl.p148nt.base.composer.common.BaseComposerSAConstants;
import com.samsung.android.support.senl.p148nt.base.winset.accessibility.VoiceAssistantTTS;
import com.samsung.android.support.senl.p148nt.base.winset.view.SwipeViewFlipper;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingAssistanceData;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HwSettingAssistanceLayout extends AbsHwSettingAnchorExpansionLayout {
    private static final String ASSISTANCE_FTU_COUNT_ID = "assistance_ftu_count_id";
    private static final int ASSISTANCE_FTU_COUNT_MAX = 3;
    private static final String AUTO_CLEAN_UP_COMMON_ASSET_NAME = "auto_clean_up_en.json";
    private static final String AUTO_CLEAN_UP_KR_ASSET_NAME = "auto_clean_up_kr.json";
    private static final int DIRECT_ASSISTANCE_CONDITION_CNT = 1;
    private static final String PREF_ASSISTANCE_USE_CNT = "hw_assistance_use_cnt";
    private static final long SHORT_DURATION_TIMEOUT = 2000;
    private static final String SMART_GUIDELINE_COMMON_ASSET_NAME = "smart_guideline_en.json";
    private static final String SMART_GUIDELINE_KR_ASSET_NAME = "smart_guideline_kr.json";
    private CompoundButton.OnCheckedChangeListener mAlignLettersChangeListener;
    private SwitchCompat mAlignLettersSwitch;
    private View mCollapseView;
    private Runnable mDismissRunnable;
    private View mExpandView;
    private View mFTUContainer;
    private SwipeViewFlipper mFTUFlipper;
    private TabLayout mFTUIndicator;
    private CompoundButton.OnCheckedChangeListener mFixShapeLettersChangeListener;
    private SwitchCompat mFixShapeLettersSwitch;
    private CompoundButton.OnCheckedChangeListener mGuideLineChangeListener;
    private SwitchCompat mGuideLineSwitch;
    private Handler mHandler;
    protected ViewGroup mHwAssistanceLayout;
    private boolean mIsSupportedLanguageAtFirst;
    protected View mLanguageSettingBtn;
    private TextView mLanguageTextView;

    /* JADX INFO: Access modifiers changed from: private */
    public void autoPlay() {
        SwipeViewFlipper swipeViewFlipper = this.mFTUFlipper;
        if (swipeViewFlipper == null || this.mFTUIndicator == null) {
            return;
        }
        swipeViewFlipper.setDisplayedChild((swipeViewFlipper.getDisplayedChild() + 1) % this.mFTUFlipper.getChildCount());
        ((LottieAnimationView) this.mFTUFlipper.getCurrentView()).playAnimation();
        TabLayout tabLayout = this.mFTUIndicator;
        tabLayout.selectTab(tabLayout.getTabAt(this.mFTUFlipper.getDisplayedChild()));
    }

    private LottieAnimationView createLottieView(String str) {
        final LottieAnimationView lottieAnimationView = new LottieAnimationView(this.mHwAssistanceLayout.getContext());
        lottieAnimationView.setAnimation(str);
        lottieAnimationView.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingAssistanceLayout.11
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@NonNull Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NonNull Animator animator) {
                lottieAnimationView.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingAssistanceLayout.11.1
                    @Override // java.lang.Runnable
                    public void run() {
                        HwSettingAssistanceLayout.this.autoPlay();
                    }
                });
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@NonNull Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@NonNull Animator animator) {
            }
        });
        return lottieAnimationView;
    }

    private void deInitFTU() {
        View view = this.mFTUContainer;
        if (view != null) {
            view.setVisibility(8);
            this.mFTUContainer = null;
        }
        SwipeViewFlipper swipeViewFlipper = this.mFTUFlipper;
        if (swipeViewFlipper != null) {
            swipeViewFlipper.removeAllViews();
            this.mFTUFlipper = null;
        }
        TabLayout tabLayout = this.mFTUIndicator;
        if (tabLayout != null) {
            tabLayout.removeAllTabs();
            this.mFTUIndicator = null;
        }
    }

    private void dismissTimeOut() {
        if (isExpand() || VoiceAssistantTTS.isVoiceAssistantEnabled(this.mHwAssistanceLayout.getContext())) {
            return;
        }
        resetDismissTimeOut();
        this.mHandler.postDelayed(this.mDismissRunnable, 2000L);
    }

    private static int getFTURunCount() {
        return SharedPreferencesCompat.getInstance("Composer").getInt(ASSISTANCE_FTU_COUNT_ID, 0);
    }

    private void initFTU() {
        if (!isEnabledFTU() || isRemoveAnimation(this.mHwAssistanceLayout.getContext())) {
            return;
        }
        playFTU();
        updateFTURunCount();
    }

    private void initFTUIndicator(TabLayout tabLayout, int i) {
        int dimensionPixelSize = this.mHwAssistanceLayout.getContext().getResources().getDimensionPixelSize(C9086R.dimen.setting_color_palette_page_indicator_size);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(dimensionPixelSize, dimensionPixelSize);
        int i2 = dimensionPixelSize / 2;
        marginLayoutParams.setMargins(i2, 0, i2, 0);
        while (true) {
            int i4 = i - 1;
            if (i == 0) {
                return;
            }
            View view = new View(this.mHwAssistanceLayout.getContext());
            view.setLayoutParams(marginLayoutParams);
            view.setBackgroundResource(C9086R.drawable.color_palette_v70_default_indicator);
            tabLayout.addTab(tabLayout.newTab().setCustomView(view));
            i = i4;
        }
    }

    private void initListeners() {
        this.mCollapseView.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingAssistanceLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HwSettingAssistanceLayout.this.expandView();
                HwSettingAssistanceLayout.this.mHwAssistanceLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingAssistanceLayout.2.1
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        HwSettingAssistanceLayout.this.mHwAssistanceLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        HwSettingAssistanceLayout.this.mHwAssistanceLayout.findViewById(C9086R.id.close_button).requestFocus();
                    }
                });
            }
        });
        this.mHwAssistanceLayout.findViewById(C9086R.id.close_button).setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingAssistanceLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HwSettingAssistanceLayout.this.hide(true);
            }
        });
        this.mLanguageSettingBtn.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingAssistanceLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HwSettingAssistanceLayout.this.getSettingInstance().showLanguageSettingDialog();
            }
        });
        this.mGuideLineChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingAssistanceLayout.5
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ComposerSA.insertLog(BaseComposerSAConstants.SCREEN_NONE, ComposerSAConstants.EVENT_HANDWRITING_HELP_SMART_GUIDELINE, z ? "a" : "b");
                SettingAssistanceData settingAssistanceData = HwSettingAssistanceLayout.this.getSettingInstance().getSettingInfoManager().getSettingAssistanceData();
                HwSettingAssistanceLayout.this.getSettingInstance().setAssistanceOptions(z, settingAssistanceData.getAlignLettersEnabled(), settingAssistanceData.getFixShapeLettersEnabled());
            }
        };
        this.mAlignLettersChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingAssistanceLayout.6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ComposerSA.insertLog(BaseComposerSAConstants.SCREEN_NONE, ComposerSAConstants.EVENT_HANDWRITING_HELP_ALIGN_LETTERS, z ? "a" : "b");
                SettingAssistanceData settingAssistanceData = HwSettingAssistanceLayout.this.getSettingInstance().getSettingInfoManager().getSettingAssistanceData();
                HwSettingAssistanceLayout.this.getSettingInstance().setAssistanceOptions(settingAssistanceData.getGuidelineEnable(), z, settingAssistanceData.getFixShapeLettersEnabled());
            }
        };
        this.mFixShapeLettersChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingAssistanceLayout.7
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ComposerSA.insertLog(BaseComposerSAConstants.SCREEN_NONE, ComposerSAConstants.EVENT_HANDWRITING_HELP_FIX_SHAPE, z ? "a" : "b");
                SettingAssistanceData settingAssistanceData = HwSettingAssistanceLayout.this.getSettingInstance().getSettingInfoManager().getSettingAssistanceData();
                HwSettingAssistanceLayout.this.getSettingInstance().setAssistanceOptions(settingAssistanceData.getGuidelineEnable(), settingAssistanceData.getAlignLettersEnabled(), z);
            }
        };
    }

    private static boolean isEnabledFTU() {
        return getFTURunCount() < 3;
    }

    private boolean isRemoveAnimation(Context context) {
        return SettingsCompat.getInstance().isRemoveAnimation(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void manualPlay() {
        SwipeViewFlipper swipeViewFlipper = this.mFTUFlipper;
        if (swipeViewFlipper == null) {
            return;
        }
        LottieAnimationView lottieAnimationView = (LottieAnimationView) swipeViewFlipper.getCurrentView();
        lottieAnimationView.removeAllAnimatorListeners();
        lottieAnimationView.setRepeatCount(-1);
        lottieAnimationView.playAnimation();
    }

    private void playFTU() {
        deInitFTU();
        this.mFTUContainer = this.mHwAssistanceLayout.findViewById(C9086R.id.assistance_ftu);
        this.mFTUIndicator = (TabLayout) this.mHwAssistanceLayout.findViewById(C9086R.id.ftu_indicator);
        SwipeViewFlipper swipeViewFlipper = (SwipeViewFlipper) this.mHwAssistanceLayout.findViewById(C9086R.id.ftu_flipper);
        this.mFTUFlipper = swipeViewFlipper;
        swipeViewFlipper.setActionListener(new SwipeViewFlipper.ViewFlipperActionListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingAssistanceLayout.9
            @Override // com.samsung.android.support.senl.nt.base.winset.view.SwipeViewFlipper.ViewFlipperActionListener
            public void onFlipped(boolean z) {
                if (HwSettingAssistanceLayout.this.mFTUFlipper == null || HwSettingAssistanceLayout.this.mFTUIndicator == null) {
                    return;
                }
                HwSettingAssistanceLayout.this.mFTUIndicator.selectTab(HwSettingAssistanceLayout.this.mFTUIndicator.getTabAt(HwSettingAssistanceLayout.this.mFTUFlipper.getDisplayedChild()));
                HwSettingAssistanceLayout.this.manualPlay();
            }
        });
        if (LocaleUtils.isKoreaLanguage()) {
            this.mFTUFlipper.addView(createLottieView(SMART_GUIDELINE_KR_ASSET_NAME));
            this.mFTUFlipper.addView(createLottieView(AUTO_CLEAN_UP_KR_ASSET_NAME));
        } else {
            this.mFTUFlipper.addView(createLottieView(SMART_GUIDELINE_COMMON_ASSET_NAME));
            this.mFTUFlipper.addView(createLottieView(AUTO_CLEAN_UP_COMMON_ASSET_NAME));
        }
        initFTUIndicator(this.mFTUIndicator, this.mFTUFlipper.getChildCount());
        this.mFTUIndicator.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingAssistanceLayout.10
            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabReselected(TabLayout.Tab tab) {
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                if (HwSettingAssistanceLayout.this.mFTUFlipper == null || HwSettingAssistanceLayout.this.mFTUFlipper.getDisplayedChild() == tab.getPosition()) {
                    return;
                }
                HwSettingAssistanceLayout.this.mFTUFlipper.setDisplayedChild(tab.getPosition());
                HwSettingAssistanceLayout.this.manualPlay();
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
            }
        });
        this.mFTUContainer.setVisibility(0);
        ((LottieAnimationView) this.mFTUFlipper.getCurrentView()).playAnimation();
    }

    private void resetDismissTimeOut() {
        this.mHandler.removeCallbacks(this.mDismissRunnable);
    }

    private void setCheckedChangeListener(boolean z) {
        if (!z) {
            this.mGuideLineSwitch.setOnCheckedChangeListener(null);
            this.mAlignLettersSwitch.setOnCheckedChangeListener(null);
            this.mFixShapeLettersSwitch.setOnCheckedChangeListener(null);
        } else {
            this.mGuideLineSwitch.setOnCheckedChangeListener(this.mGuideLineChangeListener);
            setEnableSwipeSwitchCompat(this.mGuideLineSwitch);
            this.mAlignLettersSwitch.setOnCheckedChangeListener(this.mAlignLettersChangeListener);
            setEnableSwipeSwitchCompat(this.mAlignLettersSwitch);
            this.mFixShapeLettersSwitch.setOnCheckedChangeListener(this.mFixShapeLettersChangeListener);
            setEnableSwipeSwitchCompat(this.mFixShapeLettersSwitch);
        }
    }

    private static void updateFTURunCount() {
        SharedPreferencesCompat.getInstance("Composer").putInt(ASSISTANCE_FTU_COUNT_ID, getFTURunCount() + 1);
    }

    private void updateSettingData(boolean z) {
        SettingAssistanceData settingAssistanceData = this.mSettingViewManager.getSettingInfoManager().getSettingAssistanceData();
        setAssistanceOptions(settingAssistanceData.getGuidelineEnable(), settingAssistanceData.getAlignLettersEnabled(), settingAssistanceData.getFixShapeLettersEnabled());
        this.mAlignLettersSwitch.setEnabled(z);
        this.mFixShapeLettersSwitch.setEnabled(z);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void close() {
        this.mSettingViewManager.updateShowState(getCallerType(), getViewId(), false);
        if (this.mHwAssistanceLayout != null) {
            this.mHwAssistanceLayout = null;
        }
        deInitFTU();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.AbsHwSettingAnchorExpansionLayout
    public void expandView() {
        resetDismissTimeOut();
        super.expandView();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.AbsHwSettingAnchorExpansionLayout
    @NonNull
    public View getCollapseView() {
        return this.mCollapseView;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.AbsHwSettingAnchorExpansionLayout
    @NonNull
    public View getExpandView() {
        return this.mExpandView;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.AbsHwSettingAnchorLayout
    public View getView() {
        return this.mHwAssistanceLayout;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.AbsHwSettingAnchorExpansionLayout, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.AbsHwSettingAnchorLayout, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void hide(boolean z) {
        if (isVisible()) {
            super.hide(z);
            inOutVI(this.mHwAssistanceLayout, z);
            this.mHwAssistanceLayout.setVisibility(8);
            this.mSettingViewManager.updateShowState(getCallerType(), getViewId(), false);
            deInitFTU();
            getSettingInstance().updateAssistanceSelection();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void init() {
        if (this.mHwAssistanceLayout != null) {
            return;
        }
        this.mHandler = new Handler();
        this.mDismissRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingAssistanceLayout.1
            @Override // java.lang.Runnable
            public void run() {
                HwSettingAssistanceLayout.this.hide(true);
            }
        };
        ViewGroup viewGroupAddWrappingScrollView = addWrappingScrollView(C9086R.layout.comp_hw_assistance);
        this.mHwAssistanceLayout = viewGroupAddWrappingScrollView;
        this.mExpandView = viewGroupAddWrappingScrollView.findViewById(C9086R.id.hw_expand_container);
        this.mCollapseView = this.mHwAssistanceLayout.findViewById(C9086R.id.hw_collapse_container);
        this.mGuideLineSwitch = (SwitchCompat) this.mHwAssistanceLayout.findViewById(C9086R.id.hw_guideline_switch);
        this.mAlignLettersSwitch = (SwitchCompat) this.mHwAssistanceLayout.findViewById(C9086R.id.align_letters_switch);
        this.mFixShapeLettersSwitch = (SwitchCompat) this.mHwAssistanceLayout.findViewById(C9086R.id.fix_shape_letters_switch);
        this.mLanguageTextView = (TextView) this.mHwAssistanceLayout.findViewById(C9086R.id.hw_language_text);
        this.mLanguageSettingBtn = this.mHwAssistanceLayout.findViewById(C9086R.id.hw_language_icon);
        initListeners();
        setCheckedChangeListener(true);
        if (getSettingInstance() != null) {
            updateLanguage(getSettingInstance().getBeautifierLanguage(), getSettingInstance().isBeautifierSupportedLanguage());
        }
        this.mHwAssistanceLayout.setVisibility(8);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public boolean isVisible() {
        ViewGroup viewGroup = this.mHwAssistanceLayout;
        return viewGroup != null && viewGroup.getVisibility() == 0;
    }

    public boolean needExpandView() {
        SharedPreferencesCompat sharedPreferencesCompat = SharedPreferencesCompat.getInstance("Composer");
        int i = sharedPreferencesCompat.getInt(PREF_ASSISTANCE_USE_CNT, 0);
        if (i >= 1) {
            return !getSettingInstance().canUseAssistanceOptions();
        }
        sharedPreferencesCompat.putInt(PREF_ASSISTANCE_USE_CNT, i + 1);
        return true;
    }

    public void setAssistanceOptions(boolean z, boolean z2, boolean z3) {
        if (isVisible()) {
            boolean z4 = false;
            setCheckedChangeListener(false);
            this.mGuideLineSwitch.setChecked(z);
            boolean zIsBeautifierSupportedLanguage = getSettingInstance().isBeautifierSupportedLanguage();
            this.mAlignLettersSwitch.setChecked(z2 && zIsBeautifierSupportedLanguage);
            SwitchCompat switchCompat = this.mFixShapeLettersSwitch;
            if (z3 && zIsBeautifierSupportedLanguage) {
                z4 = true;
            }
            switchCompat.setChecked(z4);
            setCheckedChangeListener(true);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.AbsHwSettingAnchorExpansionLayout, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.AbsHwSettingAnchorLayout, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void show(int i, View view, boolean z) {
        setCallerType(i);
        init();
        if (this.mHwAssistanceLayout.getVisibility() == 0) {
            return;
        }
        super.show(i, view, z);
        setExpandView(needExpandView());
        dismissTimeOut();
        inOutVI(this.mHwAssistanceLayout, z);
        this.mHwAssistanceLayout.setVisibility(0);
        this.mSettingViewManager.updateShowState(getCallerType(), getViewId(), true);
        updatePosition(i, view, false);
        if (getSettingInstance() != null) {
            this.mIsSupportedLanguageAtFirst = getSettingInstance().isBeautifierSupportedLanguage();
            updateLanguage(getSettingInstance().getBeautifierLanguage(), this.mIsSupportedLanguageAtFirst);
        }
        initFTU();
        this.mHwAssistanceLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingAssistanceLayout.8
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                HwSettingAssistanceLayout.this.mHwAssistanceLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if (HwSettingAssistanceLayout.this.isExpand()) {
                    HwSettingAssistanceLayout.this.mHwAssistanceLayout.findViewById(C9086R.id.close_button).requestFocus();
                } else {
                    HwSettingAssistanceLayout.this.mCollapseView.requestFocus();
                }
            }
        });
    }

    public void updateLanguage(String str, boolean z) {
        if (isVisible()) {
            this.mLanguageTextView.setText(DisplayLanguageUtils.getDisplayName(str));
            updateSettingData(z);
            if (isEnabledFTU() || !z || this.mIsSupportedLanguageAtFirst || isRemoveAnimation(this.mLanguageTextView.getContext())) {
                return;
            }
            updatePosition(getCallerType(), null, false);
            playFTU();
        }
    }
}
