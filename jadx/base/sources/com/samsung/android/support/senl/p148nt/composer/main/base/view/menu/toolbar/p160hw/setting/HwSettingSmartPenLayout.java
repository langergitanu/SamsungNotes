package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting;

import android.animation.Animator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
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
import com.samsung.android.support.senl.p148nt.base.winset.view.SwipeViewFlipper;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingAssistanceData;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingSmartPenData;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingToolbarItemData;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HwSettingSmartPenLayout extends AbsHwSettingAnchorLayout implements SettingSmartPenData.ChangeListener {
    private static final String TAG = Logger.createTag("HwSettingSmartPenLayout");
    private AssistanceOption mAssistanceOption;
    private ButtonGroup mButtonGroup;
    private View mCallerContainer;
    private ViewGroup mOptionContainer;
    private ViewGroup mOptionDetailContainer;
    protected ViewGroup mSmartPenLayout;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class AssistanceOption {
        private static final String ASSISTANCE_FTU_COUNT_ID = "assistance_ftu_count_id";
        private static final int ASSISTANCE_FTU_COUNT_MAX = 3;
        private static final String AUTO_CLEAN_UP_COMMON_ASSET_NAME = "auto_clean_up_en.json";
        private static final String AUTO_CLEAN_UP_KR_ASSET_NAME = "auto_clean_up_kr.json";
        private static final int DIRECT_ASSISTANCE_CONDITION_CNT = 1;
        private static final String PREF_ASSISTANCE_USE_CNT = "hw_assistance_use_cnt";
        private static final String SMART_GUIDELINE_COMMON_ASSET_NAME = "smart_guideline_en.json";
        private static final String SMART_GUIDELINE_KR_ASSET_NAME = "smart_guideline_kr.json";
        private CompoundButton.OnCheckedChangeListener mAlignLettersChangeListener;
        private SwitchCompat mAlignLettersSwitch;
        private View mAssistanceContainer;
        private View mFTUContainer;
        private SwipeViewFlipper mFTUFlipper;
        private TabLayout mFTUIndicator;
        private CompoundButton.OnCheckedChangeListener mFixShapeLettersChangeListener;
        private SwitchCompat mFixShapeLettersSwitch;
        private CompoundButton.OnCheckedChangeListener mGuideLineChangeListener;
        private SwitchCompat mGuideLineSwitch;
        private boolean mIsSupportedLanguageAtFirst;
        protected View mLanguageSettingBtn;
        private TextView mLanguageTextView;

        public AssistanceOption() {
        }

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
            LottieAnimationView lottieAnimationView = new LottieAnimationView(HwSettingSmartPenLayout.this.mSmartPenLayout.getContext());
            lottieAnimationView.setAnimation(str);
            lottieAnimationView.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingSmartPenLayout.AssistanceOption.7
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(@NonNull Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(@NonNull Animator animator) {
                    AssistanceOption.this.autoPlay();
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

        private static int getFTURunCount() {
            return SharedPreferencesCompat.getInstance("Composer").getInt(ASSISTANCE_FTU_COUNT_ID, 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void initAssistance(ViewGroup viewGroup) {
            this.mAssistanceContainer = viewGroup.findViewById(C9086R.id.assistance_option_container);
            this.mGuideLineSwitch = (SwitchCompat) viewGroup.findViewById(C9086R.id.hw_guideline_switch);
            this.mAlignLettersSwitch = (SwitchCompat) viewGroup.findViewById(C9086R.id.align_letters_switch);
            this.mFixShapeLettersSwitch = (SwitchCompat) viewGroup.findViewById(C9086R.id.fix_shape_letters_switch);
            this.mLanguageTextView = (TextView) viewGroup.findViewById(C9086R.id.hw_language_text);
            this.mLanguageSettingBtn = viewGroup.findViewById(C9086R.id.hw_language_icon);
            initAssistanceListeners();
            setAssistanceCheckedChangeListener(true);
            if (HwSettingSmartPenLayout.this.getSettingInstance() != null) {
                updateLanguage(HwSettingSmartPenLayout.this.getSettingInstance().getBeautifierLanguage(), HwSettingSmartPenLayout.this.getSettingInstance().isBeautifierSupportedLanguage());
            }
        }

        private void initAssistanceListeners() {
            this.mLanguageSettingBtn.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingSmartPenLayout.AssistanceOption.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    HwSettingSmartPenLayout.this.getSettingInstance().showLanguageSettingDialog();
                }
            });
            this.mGuideLineChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingSmartPenLayout.AssistanceOption.2
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    ComposerSA.insertLog(BaseComposerSAConstants.SCREEN_NONE, ComposerSAConstants.EVENT_HANDWRITING_HELP_SMART_GUIDELINE, z ? "a" : "b");
                    SettingAssistanceData settingAssistanceData = HwSettingSmartPenLayout.this.getSettingInstance().getSettingInfoManager().getSettingAssistanceData();
                    HwSettingSmartPenLayout.this.getSettingInstance().setAssistanceOptions(z, settingAssistanceData.getAlignLettersEnabled(), settingAssistanceData.getFixShapeLettersEnabled());
                }
            };
            this.mAlignLettersChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingSmartPenLayout.AssistanceOption.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    ComposerSA.insertLog(BaseComposerSAConstants.SCREEN_NONE, ComposerSAConstants.EVENT_HANDWRITING_HELP_ALIGN_LETTERS, z ? "a" : "b");
                    SettingAssistanceData settingAssistanceData = HwSettingSmartPenLayout.this.getSettingInstance().getSettingInfoManager().getSettingAssistanceData();
                    HwSettingSmartPenLayout.this.getSettingInstance().setAssistanceOptions(settingAssistanceData.getGuidelineEnable(), z, settingAssistanceData.getFixShapeLettersEnabled());
                }
            };
            this.mFixShapeLettersChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingSmartPenLayout.AssistanceOption.4
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    ComposerSA.insertLog(BaseComposerSAConstants.SCREEN_NONE, ComposerSAConstants.EVENT_HANDWRITING_HELP_FIX_SHAPE, z ? "a" : "b");
                    SettingAssistanceData settingAssistanceData = HwSettingSmartPenLayout.this.getSettingInstance().getSettingInfoManager().getSettingAssistanceData();
                    HwSettingSmartPenLayout.this.getSettingInstance().setAssistanceOptions(settingAssistanceData.getGuidelineEnable(), settingAssistanceData.getAlignLettersEnabled(), z);
                }
            };
        }

        private void initFTU() {
            if (!isEnabledFTU() || isRemoveAnimation(HwSettingSmartPenLayout.this.mOptionContainer.getContext())) {
                return;
            }
            playFTU();
            updateFTURunCount();
        }

        private void initFTUIndicator(TabLayout tabLayout, int i) {
            int dimensionPixelSize = tabLayout.getContext().getResources().getDimensionPixelSize(C9086R.dimen.setting_color_palette_page_indicator_size);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(dimensionPixelSize, dimensionPixelSize);
            int i2 = dimensionPixelSize / 2;
            marginLayoutParams.setMargins(i2, 0, i2, 0);
            while (true) {
                int i4 = i - 1;
                if (i == 0) {
                    return;
                }
                View view = new View(tabLayout.getContext());
                view.setLayoutParams(marginLayoutParams);
                view.setBackgroundResource(C9086R.drawable.color_palette_v70_default_indicator);
                tabLayout.addTab(tabLayout.newTab().setCustomView(view));
                i = i4;
            }
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
            this.mFTUContainer = HwSettingSmartPenLayout.this.mOptionContainer.findViewById(C9086R.id.assistance_ftu);
            this.mFTUIndicator = (TabLayout) HwSettingSmartPenLayout.this.mOptionContainer.findViewById(C9086R.id.ftu_indicator);
            SwipeViewFlipper swipeViewFlipper = (SwipeViewFlipper) HwSettingSmartPenLayout.this.mOptionContainer.findViewById(C9086R.id.ftu_flipper);
            this.mFTUFlipper = swipeViewFlipper;
            swipeViewFlipper.setActionListener(new SwipeViewFlipper.ViewFlipperActionListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingSmartPenLayout.AssistanceOption.5
                @Override // com.samsung.android.support.senl.nt.base.winset.view.SwipeViewFlipper.ViewFlipperActionListener
                public void onFlipped(boolean z) {
                    if (AssistanceOption.this.mFTUFlipper == null || AssistanceOption.this.mFTUIndicator == null) {
                        return;
                    }
                    AssistanceOption.this.mFTUIndicator.selectTab(AssistanceOption.this.mFTUIndicator.getTabAt(AssistanceOption.this.mFTUFlipper.getDisplayedChild()));
                    AssistanceOption.this.manualPlay();
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
            this.mFTUIndicator.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingSmartPenLayout.AssistanceOption.6
                @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
                public void onTabReselected(TabLayout.Tab tab) {
                }

                @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
                public void onTabSelected(TabLayout.Tab tab) {
                    if (AssistanceOption.this.mFTUFlipper == null || AssistanceOption.this.mFTUFlipper.getDisplayedChild() == tab.getPosition()) {
                        return;
                    }
                    AssistanceOption.this.mFTUFlipper.setDisplayedChild(tab.getPosition());
                    AssistanceOption.this.manualPlay();
                }

                @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
                public void onTabUnselected(TabLayout.Tab tab) {
                }
            });
            this.mFTUContainer.setVisibility(0);
            ((LottieAnimationView) this.mFTUFlipper.getCurrentView()).playAnimation();
        }

        private void setAssistanceCheckedChangeListener(boolean z) {
            if (z) {
                this.mGuideLineSwitch.setOnCheckedChangeListener(this.mGuideLineChangeListener);
                this.mAlignLettersSwitch.setOnCheckedChangeListener(this.mAlignLettersChangeListener);
                this.mFixShapeLettersSwitch.setOnCheckedChangeListener(this.mFixShapeLettersChangeListener);
            } else {
                this.mGuideLineSwitch.setOnCheckedChangeListener(null);
                this.mAlignLettersSwitch.setOnCheckedChangeListener(null);
                this.mFixShapeLettersSwitch.setOnCheckedChangeListener(null);
            }
        }

        private void setCheckedChangeListener(boolean z) {
            if (z) {
                this.mGuideLineSwitch.setOnCheckedChangeListener(this.mGuideLineChangeListener);
                this.mAlignLettersSwitch.setOnCheckedChangeListener(this.mAlignLettersChangeListener);
                this.mFixShapeLettersSwitch.setOnCheckedChangeListener(this.mFixShapeLettersChangeListener);
            } else {
                this.mGuideLineSwitch.setOnCheckedChangeListener(null);
                this.mAlignLettersSwitch.setOnCheckedChangeListener(null);
                this.mFixShapeLettersSwitch.setOnCheckedChangeListener(null);
            }
        }

        private static void updateFTURunCount() {
            SharedPreferencesCompat.getInstance("Composer").putInt(ASSISTANCE_FTU_COUNT_ID, getFTURunCount() + 1);
        }

        private void updateSettingData(boolean z) {
            SettingAssistanceData settingAssistanceData = HwSettingSmartPenLayout.this.mSettingViewManager.getSettingInfoManager().getSettingAssistanceData();
            setAssistanceOptions(settingAssistanceData.getGuidelineEnable(), settingAssistanceData.getAlignLettersEnabled(), settingAssistanceData.getFixShapeLettersEnabled());
            this.mAlignLettersSwitch.setEnabled(z);
            this.mFixShapeLettersSwitch.setEnabled(z);
        }

        public void hide() {
            deInitFTU();
            HwSettingSmartPenLayout.this.getSettingInstance().updateAssistanceSelection();
        }

        public void setAssistanceOptions(boolean z, boolean z2, boolean z3) {
            if (HwSettingSmartPenLayout.this.isVisible()) {
                boolean z4 = false;
                setCheckedChangeListener(false);
                this.mGuideLineSwitch.setChecked(z);
                boolean zIsBeautifierSupportedLanguage = HwSettingSmartPenLayout.this.getSettingInstance().isBeautifierSupportedLanguage();
                this.mAlignLettersSwitch.setChecked(z2 && zIsBeautifierSupportedLanguage);
                SwitchCompat switchCompat = this.mFixShapeLettersSwitch;
                if (z3 && zIsBeautifierSupportedLanguage) {
                    z4 = true;
                }
                switchCompat.setChecked(z4);
                setCheckedChangeListener(true);
            }
        }

        public void show() {
            if (this.mAssistanceContainer.getVisibility() == 0) {
                return;
            }
            this.mAssistanceContainer.setVisibility(0);
            if (HwSettingSmartPenLayout.this.getSettingInstance() != null) {
                this.mIsSupportedLanguageAtFirst = HwSettingSmartPenLayout.this.getSettingInstance().isBeautifierSupportedLanguage();
                updateLanguage(HwSettingSmartPenLayout.this.getSettingInstance().getBeautifierLanguage(), this.mIsSupportedLanguageAtFirst);
            }
            initFTU();
        }

        public void updateLanguage(String str, boolean z) {
            if (HwSettingSmartPenLayout.this.isVisible()) {
                this.mLanguageTextView.setText(DisplayLanguageUtils.getDisplayName(str));
                updateSettingData(z);
                if (isEnabledFTU() || !z || this.mIsSupportedLanguageAtFirst || isRemoveAnimation(this.mLanguageTextView.getContext())) {
                    return;
                }
                HwSettingSmartPenLayout hwSettingSmartPenLayout = HwSettingSmartPenLayout.this;
                hwSettingSmartPenLayout.updatePosition(hwSettingSmartPenLayout.getCallerType(), null, false);
                playFTU();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ButtonGroup {
        private final Map<Integer, View> mBtnMap = new HashMap();

        public ButtonGroup() {
        }

        private void setOptionVisibility(int i) {
            if (i == 131072) {
                HwSettingSmartPenLayout.this.mOptionContainer.setVisibility(0);
            } else {
                HwSettingSmartPenLayout.this.mOptionContainer.setVisibility(8);
            }
        }

        public void initState() {
            View view;
            View view2;
            Iterator<View> it = this.mBtnMap.values().iterator();
            while (it.hasNext()) {
                it.next().setSelected(false);
            }
            int selectedMenuId = HwSettingSmartPenLayout.this.getSettingInstance().getSettingInfoManager().getSmartPenData().getSelectedMenuId();
            View view3 = this.mBtnMap.get(Integer.valueOf(selectedMenuId));
            if (view3 != null) {
                view3.setSelected(true);
                setOptionVisibility(selectedMenuId);
            }
            SettingToolbarItemData toolbarItemData = HwSettingSmartPenLayout.this.getSettingInstance().getSettingInfoManager().getToolbarItemData();
            if (!toolbarItemData.isEnabledCleanUpAndConvertText() && (view2 = this.mBtnMap.get(524288)) != null) {
                view2.setVisibility(8);
            }
            if (!toolbarItemData.isEnabledAssistance() && (view = this.mBtnMap.get(131072)) != null) {
                view.setVisibility(8);
            }
            SettingSmartPenData smartPenData = HwSettingSmartPenLayout.this.getSettingInstance().getSettingInfoManager().getSmartPenData();
            Iterator<Integer> it2 = smartPenData.getGoneMenuIds().iterator();
            while (it2.hasNext()) {
                View view4 = this.mBtnMap.get(it2.next());
                if (view4 != null) {
                    view4.setVisibility(8);
                }
            }
            Iterator<Integer> it3 = smartPenData.getDisabledMenuIdSet().iterator();
            while (it3.hasNext()) {
                HwSettingSmartPenLayout.this.setEnabledView(this.mBtnMap.get(it3.next()), false);
            }
        }

        public void updateSelectedState(View view, int i) {
            if (view.isSelected()) {
                view.setSelected(false);
                HwSettingSmartPenLayout.this.getSettingInstance().setSmartPen(0);
                HwSettingSmartPenLayout.this.mOptionContainer.setVisibility(8);
                return;
            }
            for (View view2 : this.mBtnMap.values()) {
                if (view == view2) {
                    view.setSelected(true);
                } else {
                    view2.setSelected(false);
                }
            }
            HwSettingSmartPenLayout.this.getSettingInstance().setSmartPen(i);
            if (i == 524288) {
                HwSettingSmartPenLayout.this.getSettingInstance().getSettingInfoManager().getSmartPenData().setSelectedMenuId(0);
            }
            setOptionVisibility(i);
        }
    }

    private void initMenus() {
        this.mSmartPenLayout.findViewById(C9086R.id.close_button).setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingSmartPenLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HwSettingSmartPenLayout.this.hide(true);
            }
        });
        View viewFindViewById = this.mSmartPenLayout.findViewById(C9086R.id.clean_up_and_ctt_item);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingSmartPenLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Logger.m10999d(HwSettingSmartPenLayout.TAG, "onClick# clean up and convert text");
                HwSettingSmartPenLayout.this.mButtonGroup.updateSelectedState(view, 524288);
            }
        });
        View viewFindViewById2 = this.mSmartPenLayout.findViewById(C9086R.id.assistance_item);
        viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingSmartPenLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Logger.m10999d(HwSettingSmartPenLayout.TAG, "onClick# assistance");
                HwSettingSmartPenLayout.this.mButtonGroup.updateSelectedState(view, 131072);
            }
        });
        View viewFindViewById3 = this.mSmartPenLayout.findViewById(C9086R.id.direct_write_item);
        viewFindViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingSmartPenLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Logger.m10999d(HwSettingSmartPenLayout.TAG, "onClick# direct write");
                HwSettingSmartPenLayout.this.mButtonGroup.updateSelectedState(view, 8192);
            }
        });
        ButtonGroup buttonGroup = new ButtonGroup();
        this.mButtonGroup = buttonGroup;
        buttonGroup.mBtnMap.put(524288, viewFindViewById);
        this.mButtonGroup.mBtnMap.put(131072, viewFindViewById2);
        this.mButtonGroup.mBtnMap.put(8192, viewFindViewById3);
        getSettingInstance().getSettingInfoManager().getSmartPenData().setChangeListener(this);
    }

    private void initOptions() {
        this.mOptionContainer = (ViewGroup) this.mSmartPenLayout.findViewById(C9086R.id.option_container);
        this.mOptionDetailContainer = (ViewGroup) this.mSmartPenLayout.findViewById(C9086R.id.option_detail_container);
        this.mOptionContainer.findViewById(C9086R.id.option_expand_button).setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingSmartPenLayout.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HwSettingSmartPenLayout.this.mOptionDetailContainer.getVisibility() == 0) {
                    view.setContentDescription(view.getResources().getString(C9086R.string.change_template_expand));
                    view.setRotation(0.0f);
                    view.animate().rotation(180.0f).setDuration(300L).start();
                    HwSettingSmartPenLayout.this.mAssistanceOption.hide();
                    HwSettingSmartPenLayout.this.mOptionDetailContainer.setVisibility(8);
                    HwSettingSmartPenLayout hwSettingSmartPenLayout = HwSettingSmartPenLayout.this;
                    hwSettingSmartPenLayout.updatePosition(hwSettingSmartPenLayout.getCallerType(), HwSettingSmartPenLayout.this.mCallerContainer, false);
                    return;
                }
                view.setContentDescription(view.getResources().getString(C9086R.string.change_template_collapse));
                view.setRotation(180.0f);
                view.animate().rotation(0.0f).setDuration(300L).start();
                HwSettingSmartPenLayout.this.mOptionDetailContainer.setVisibility(0);
                HwSettingSmartPenLayout.this.mAssistanceOption.show();
                HwSettingSmartPenLayout hwSettingSmartPenLayout2 = HwSettingSmartPenLayout.this;
                hwSettingSmartPenLayout2.updatePosition(hwSettingSmartPenLayout2.getCallerType(), HwSettingSmartPenLayout.this.mCallerContainer, false);
            }
        });
        AssistanceOption assistanceOption = new AssistanceOption();
        this.mAssistanceOption = assistanceOption;
        assistanceOption.initAssistance(this.mOptionDetailContainer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEnabledView(View view, boolean z) {
        if (view != null) {
            view.setEnabled(z);
            view.setAlpha(z ? 1.0f : 0.4f);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void close() {
        if (this.mSmartPenLayout != null) {
            this.mSmartPenLayout = null;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.AbsHwSettingAnchorLayout
    public View getView() {
        return this.mSmartPenLayout;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.AbsHwSettingAnchorLayout, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void hide(boolean z) {
        if (isVisible()) {
            super.hide(z);
            inOutVI(this.mSmartPenLayout, z);
            this.mSmartPenLayout.setVisibility(8);
            this.mSettingViewManager.updateShowState(getCallerType(), getViewId(), false);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void init() {
        if (this.mSmartPenLayout != null) {
            return;
        }
        this.mSmartPenLayout = addWrappingScrollView(C9086R.layout.comp_hw_smart_pen_layout);
        initMenus();
        initOptions();
        this.mSmartPenLayout.setVisibility(8);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public boolean isVisible() {
        ViewGroup viewGroup = this.mSmartPenLayout;
        return viewGroup != null && viewGroup.getVisibility() == 0;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.menu.toolbar.hw.setting.data.SettingSmartPenData.ChangeListener
    public void onEnabledMenu(int i, boolean z) {
        setEnabledView((View) this.mButtonGroup.mBtnMap.get(Integer.valueOf(i)), z);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.AbsHwSettingAnchorLayout, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void show(int i, View view, boolean z) {
        setCallerType(i);
        init();
        if (this.mSmartPenLayout.getVisibility() == 0) {
            return;
        }
        super.show(i, view, z);
        this.mButtonGroup.initState();
        inOutVI(this.mSmartPenLayout, z);
        this.mSmartPenLayout.setVisibility(0);
        this.mSmartPenLayout.requestFocus();
        this.mSettingViewManager.updateShowState(getCallerType(), getViewId(), true);
        updatePosition(i, view, false);
        this.mCallerContainer = view;
    }
}
