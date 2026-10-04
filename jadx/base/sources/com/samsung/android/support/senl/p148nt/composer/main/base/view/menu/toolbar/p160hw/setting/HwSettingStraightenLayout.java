package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.util.DisplayLanguageUtils;
import com.samsung.android.support.senl.p148nt.base.winset.util.ButtonShapeUtil;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingStraightenData;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.HWToolbarSAConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HwSettingStraightenLayout extends AbsHwSettingAnchorExpansionLayout {
    private static final int MENU_SKIP_TIME = 500;
    private static final String STRAIGHTEN_EXPAND_STATE_ID = "straighten_expand_state_id";
    private static final String TAG = Logger.createTag("HwSettingStraightenLayout");
    private View mAlignLettersIcon;
    private SwitchCompat mAlignLettersSwitch;
    private View mAlignLettersTitle;
    boolean mBlockInput;
    private View mCollapseView;
    private View mEvenlySpaceWordsIcon;
    private SwitchCompat mEvenlySpaceWordsSwitch;
    private View mEvenlySpaceWordsTitle;
    private View mExpandView;
    private View mFixShapeLettersIcon;
    private SwitchCompat mFixShapeLettersSwitch;
    private View mFixShapeLettersTitle;
    private TextView mLanguageTextView;
    private SettingStraightenData mPreviousStraightenData;
    protected ViewGroup mStraightenLayout;
    private SwitchCompat mStraightenLinesSwitch;

    public HwSettingStraightenLayout() {
        super(STRAIGHTEN_EXPAND_STATE_ID);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyAlignLetters(boolean z) {
        SettingStraightenData straightenData = getSettingInstance().getSettingInfoManager().getStraightenData();
        getSettingInstance().setAlignmentOptions(straightenData.getStraightenEnabled(), z, straightenData.getEvenlySpaceWordsEnabled(), straightenData.getFixShapeLettersEnabled());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyEvenlySpaceWords(boolean z) {
        SettingStraightenData straightenData = getSettingInstance().getSettingInfoManager().getStraightenData();
        getSettingInstance().setAlignmentOptions(straightenData.getStraightenEnabled(), straightenData.getAlignLettersEnabled(), z, straightenData.getFixShapeLettersEnabled());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyFixShapeLetters(boolean z) {
        SettingStraightenData straightenData = getSettingInstance().getSettingInfoManager().getStraightenData();
        getSettingInstance().setAlignmentOptions(straightenData.getStraightenEnabled(), straightenData.getAlignLettersEnabled(), straightenData.getEvenlySpaceWordsEnabled(), z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyStraighten(boolean z) {
        SettingStraightenData straightenData = getSettingInstance().getSettingInfoManager().getStraightenData();
        getSettingInstance().setAlignmentOptions(z, straightenData.getAlignLettersEnabled(), straightenData.getEvenlySpaceWordsEnabled(), straightenData.getFixShapeLettersEnabled());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void done() {
        View view;
        if (this.mStraightenLayout != null && (view = this.mCollapseView) != null) {
            ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_HW_DONE_TYPE_ALIGN_HANDWRITING, view.getVisibility() == 0 ? "2" : "1");
        }
        internalHide(true);
        getSettingInstance().confirmAlignment();
    }

    private boolean internalHide(boolean z) {
        ViewGroup viewGroup = this.mStraightenLayout;
        if (viewGroup == null) {
            return false;
        }
        inOutVI(viewGroup, z);
        this.mStraightenLayout.setVisibility(8);
        this.mSettingViewManager.updateShowState(getCallerType(), getViewId(), false);
        this.mPreviousStraightenData = null;
        return true;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void setCheckedChangeListener(boolean z) {
        if (!z) {
            this.mStraightenLinesSwitch.setOnCheckedChangeListener(null);
            this.mAlignLettersSwitch.setOnCheckedChangeListener(null);
            this.mEvenlySpaceWordsSwitch.setOnCheckedChangeListener(null);
            this.mFixShapeLettersSwitch.setOnCheckedChangeListener(null);
            return;
        }
        View.OnTouchListener onTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingStraightenLayout.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return HwSettingStraightenLayout.this.mBlockInput;
            }
        };
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingStraightenLayout.9
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                if (HwSettingStraightenLayout.this.mBlockInput) {
                    compoundButton.setChecked(!z2);
                    return;
                }
                if (compoundButton.getId() == C9086R.id.straighten_switch) {
                    HwSettingStraightenLayout.this.applyStraighten(z2);
                    return;
                }
                if (compoundButton.getId() == C9086R.id.align_letters_switch) {
                    HwSettingStraightenLayout.this.applyAlignLetters(z2);
                } else if (compoundButton.getId() == C9086R.id.evenly_space_words_switch) {
                    HwSettingStraightenLayout.this.applyEvenlySpaceWords(z2);
                } else if (compoundButton.getId() == C9086R.id.fix_shape_letters_switch) {
                    HwSettingStraightenLayout.this.applyFixShapeLetters(z2);
                }
            }
        };
        this.mStraightenLinesSwitch.setOnCheckedChangeListener(onCheckedChangeListener);
        this.mStraightenLinesSwitch.setOnTouchListener(onTouchListener);
        setEnableSwipeSwitchCompat(this.mStraightenLinesSwitch);
        this.mAlignLettersSwitch.setOnCheckedChangeListener(onCheckedChangeListener);
        this.mAlignLettersSwitch.setOnTouchListener(onTouchListener);
        setEnableSwipeSwitchCompat(this.mAlignLettersSwitch);
        this.mEvenlySpaceWordsSwitch.setOnCheckedChangeListener(onCheckedChangeListener);
        this.mEvenlySpaceWordsSwitch.setOnTouchListener(onTouchListener);
        setEnableSwipeSwitchCompat(this.mEvenlySpaceWordsSwitch);
        this.mFixShapeLettersSwitch.setOnCheckedChangeListener(onCheckedChangeListener);
        this.mFixShapeLettersSwitch.setOnTouchListener(onTouchListener);
        setEnableSwipeSwitchCompat(this.mFixShapeLettersSwitch);
    }

    private void setClickListeners() {
        ViewGroup viewGroup = this.mStraightenLayout;
        if (viewGroup == null) {
            return;
        }
        viewGroup.findViewById(C9086R.id.collapse_button).setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingStraightenLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HwSettingStraightenLayout.this.collapseView();
            }
        });
        this.mStraightenLayout.findViewById(C9086R.id.hw_language_icon).setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingStraightenLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HwSettingStraightenLayout.this.mBlockInput) {
                    return;
                }
                UserInputSkipper.Tag tag = UserInputSkipper.Tag.Default;
                if (UserInputSkipper.isValidEvent(tag)) {
                    UserInputSkipper.setHoldingEventTime(500L, tag);
                    HwSettingStraightenLayout.this.mSettingViewManager.getSettingInstance().showLanguageSettingDialog();
                }
            }
        });
        View viewFindViewById = this.mStraightenLayout.findViewById(C9086R.id.hw_decision_done);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingStraightenLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HwSettingStraightenLayout.this.done();
            }
        });
        ButtonShapeUtil.setButtonShapeEnabled(viewFindViewById);
        this.mStraightenLayout.findViewById(C9086R.id.hw_collapse_done).setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingStraightenLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HwSettingStraightenLayout.this.done();
            }
        });
        View viewFindViewById2 = this.mStraightenLayout.findViewById(C9086R.id.hw_decision_cancel);
        viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingStraightenLayout.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HwSettingStraightenLayout.this.cancel();
            }
        });
        ButtonShapeUtil.setButtonShapeEnabled(viewFindViewById2);
        this.mStraightenLayout.findViewById(C9086R.id.hw_collapse_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingStraightenLayout.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HwSettingStraightenLayout.this.cancel();
            }
        });
        this.mStraightenLayout.findViewById(C9086R.id.hw_collapse_setting_container).setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingStraightenLayout.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HwSettingStraightenLayout.this.expandView();
            }
        });
    }

    private void setDim(boolean z, View... viewArr) {
        for (View view : viewArr) {
            view.setAlpha(z ? 0.5f : 1.0f);
        }
    }

    private void updateSettingData(boolean z) {
        SettingStraightenData straightenData = getSettingInstance().getSettingInfoManager().getStraightenData();
        setAlignmentOptions(straightenData.getStraightenEnabled(), straightenData.getAlignLettersEnabled(), straightenData.getEvenlySpaceWordsEnabled(), straightenData.getFixShapeLettersEnabled());
        this.mAlignLettersSwitch.setEnabled(z);
        this.mEvenlySpaceWordsSwitch.setEnabled(z);
        this.mFixShapeLettersSwitch.setEnabled(z);
        setDim(!z, this.mAlignLettersIcon, this.mAlignLettersTitle, this.mEvenlySpaceWordsIcon, this.mEvenlySpaceWordsTitle, this.mFixShapeLettersIcon, this.mFixShapeLettersTitle);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public boolean cancel() {
        if (!isVisible() || this.mPreviousStraightenData == null) {
            return false;
        }
        getSettingInstance().getSettingInfoManager().getStraightenData().set(this.mPreviousStraightenData);
        getSettingInstance().setAlignment(false);
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void close() {
        if (this.mStraightenLayout != null) {
            this.mStraightenLayout = null;
        }
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
        return this.mStraightenLayout;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.AbsHwSettingAnchorExpansionLayout, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.AbsHwSettingAnchorLayout, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void hide(boolean z) {
        if (getSettingInstance().isAlignmentRunning()) {
            Logger.m11003i(TAG, "skip hiding cause alignment is running");
        } else {
            super.hide(z);
            internalHide(z);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void init() {
        if (this.mStraightenLayout != null) {
            return;
        }
        ViewGroup viewGroupAddWrappingScrollView = addWrappingScrollView(C9086R.layout.comp_hw_straighten);
        this.mStraightenLayout = viewGroupAddWrappingScrollView;
        this.mStraightenLinesSwitch = (SwitchCompat) viewGroupAddWrappingScrollView.findViewById(C9086R.id.straighten_switch);
        this.mAlignLettersIcon = this.mStraightenLayout.findViewById(C9086R.id.align_letters_icon);
        this.mAlignLettersTitle = this.mStraightenLayout.findViewById(C9086R.id.align_letters_title);
        this.mAlignLettersSwitch = (SwitchCompat) this.mStraightenLayout.findViewById(C9086R.id.align_letters_switch);
        this.mEvenlySpaceWordsIcon = this.mStraightenLayout.findViewById(C9086R.id.evenly_space_words_icon);
        this.mEvenlySpaceWordsTitle = this.mStraightenLayout.findViewById(C9086R.id.evenly_space_words_title);
        this.mEvenlySpaceWordsSwitch = (SwitchCompat) this.mStraightenLayout.findViewById(C9086R.id.evenly_space_words_switch);
        this.mFixShapeLettersIcon = this.mStraightenLayout.findViewById(C9086R.id.fix_shape_letters_icon);
        this.mFixShapeLettersTitle = this.mStraightenLayout.findViewById(C9086R.id.fix_shape_letters_title);
        this.mFixShapeLettersSwitch = (SwitchCompat) this.mStraightenLayout.findViewById(C9086R.id.fix_shape_letters_switch);
        this.mLanguageTextView = (TextView) this.mStraightenLayout.findViewById(C9086R.id.hw_language_text);
        this.mExpandView = this.mStraightenLayout.findViewById(C9086R.id.hw_expand_container);
        this.mCollapseView = this.mStraightenLayout.findViewById(C9086R.id.hw_collapse_container);
        setClickListeners();
        setCheckedChangeListener(true);
        if (getSettingInstance() != null) {
            updateLanguage(getSettingInstance().getBeautifierLanguage(), getSettingInstance().isBeautifierSupportedLanguage());
        }
        this.mStraightenLayout.setVisibility(8);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public boolean isVisible() {
        ViewGroup viewGroup = this.mStraightenLayout;
        return viewGroup != null && viewGroup.getVisibility() == 0;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public boolean onTouchOutside() {
        return false;
    }

    public void setAlignmentOptions(boolean z, boolean z2, boolean z3, boolean z4) {
        if (isVisible()) {
            boolean z5 = false;
            setCheckedChangeListener(false);
            this.mStraightenLinesSwitch.setChecked(z);
            boolean zIsBeautifierSupportedLanguage = getSettingInstance().isBeautifierSupportedLanguage();
            this.mAlignLettersSwitch.setChecked(z2 && zIsBeautifierSupportedLanguage);
            this.mEvenlySpaceWordsSwitch.setChecked(z3 && zIsBeautifierSupportedLanguage);
            SwitchCompat switchCompat = this.mFixShapeLettersSwitch;
            if (z4 && zIsBeautifierSupportedLanguage) {
                z5 = true;
            }
            switchCompat.setChecked(z5);
            setCheckedChangeListener(true);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void setEnabledSettingView(boolean z) {
        this.mBlockInput = !z;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.AbsHwSettingAnchorExpansionLayout, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.AbsHwSettingAnchorLayout, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void show(int i, View view, boolean z) {
        init();
        setCallerType(i);
        if (this.mStraightenLayout.getVisibility() == 0) {
            return;
        }
        if (!this.mSettingViewManager.getSettingInstance().isAlignmentRunning()) {
            hide(false);
            return;
        }
        super.show(i, view, z);
        inOutVI(this.mStraightenLayout, z);
        this.mStraightenLayout.setVisibility(0);
        this.mStraightenLayout.requestFocus();
        this.mSettingViewManager.updateShowState(getCallerType(), getViewId(), true, false, true);
        updatePosition(i, view, false);
        if (getSettingInstance() != null) {
            updateLanguage(getSettingInstance().getBeautifierLanguage(), getSettingInstance().isBeautifierSupportedLanguage());
        }
        this.mPreviousStraightenData = getSettingInstance().getSettingInfoManager().getStraightenData().m22190clone();
        this.mBlockInput = false;
    }

    public void updateLanguage(String str, boolean z) {
        if (isVisible()) {
            this.mLanguageTextView.setText(DisplayLanguageUtils.getDisplayName(str));
            updateSettingData(z);
        }
    }
}
