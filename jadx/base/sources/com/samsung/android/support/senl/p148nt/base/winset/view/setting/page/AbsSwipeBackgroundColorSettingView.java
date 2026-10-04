package com.samsung.android.support.senl.p148nt.base.winset.view.setting.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.material.tabs.TabLayout;
import com.samsung.android.sdk.pen.setting.color.SpenColorPaletteData;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.winset.accessibility.VoiceAssistantTTS;
import com.samsung.android.support.senl.p148nt.base.winset.view.SwipeViewFlipper;
import com.samsung.android.support.senl.p148nt.base.winset.view.palette.PaletteContainerView;
import com.samsung.android.support.senl.p148nt.base.winset.view.palette.PaletteCreator;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbsSwipeBackgroundColorSettingView extends FrameLayout {
    private static final float DISABLED_ALPHA = 0.1f;
    private static final float ENABLED_ALPHA = 1.0f;
    private static final String TAG = Logger.createTag("AbsSwipeBackgroundColorSettingView");
    protected int mCurrentColor;
    protected int mCurrentColorIndex;
    protected boolean mCurrentInvert;
    protected int mCurrentPaletteId;
    private View mInvertLayout;
    private SwitchCompat mInvertSwitch;
    protected PaletteCreator mPalette;
    private SwipeViewFlipper mPaletteContainer;
    private TabLayout mPaletteIndicator;

    public AbsSwipeBackgroundColorSettingView(@NonNull Context context) {
        super(context);
        this.mCurrentPaletteId = 0;
        this.mCurrentColorIndex = 0;
        init();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void initInvertLayout() {
        this.mInvertLayout = findViewById(C8875R.id.invert_layout);
        SwitchCompat switchCompat = (SwitchCompat) findViewById(C8875R.id.invert_switch);
        this.mInvertSwitch = switchCompat;
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.samsung.android.support.senl.nt.base.winset.view.setting.page.AbsSwipeBackgroundColorSettingView.4
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AbsSwipeBackgroundColorSettingView.this.onInvertChanged(z);
            }
        });
        this.mInvertSwitch.setOnTouchListener(new View.OnTouchListener() { // from class: com.samsung.android.support.senl.nt.base.winset.view.setting.page.AbsSwipeBackgroundColorSettingView.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                }
                if (motionEvent.getAction() == 1) {
                    view.getParent().requestDisallowInterceptTouchEvent(false);
                }
                return false;
            }
        });
        ((TextView) findViewById(C8875R.id.invert_text)).setOnTouchListener(new View.OnTouchListener() { // from class: com.samsung.android.support.senl.nt.base.winset.view.setting.page.AbsSwipeBackgroundColorSettingView.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    AbsSwipeBackgroundColorSettingView.this.onInvertChanged(!r2.mCurrentInvert);
                }
                return true;
            }
        });
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void initPalette() {
        PaletteCreator paletteCreator = new PaletteCreator(getContext(), getPaletteItemActionListener());
        this.mPalette = paletteCreator;
        paletteCreator.create(getContext().getResources().getDimensionPixelOffset(C8875R.dimen.background_color_rect_chip_width), getContext().getResources().getDimensionPixelOffset(C8875R.dimen.background_color_rect_chip_height), 1.2f, getDefaultBackgroundInvert());
        this.mPaletteIndicator = (TabLayout) findViewById(C8875R.id.palette_indicator);
        SwipeViewFlipper swipeViewFlipper = (SwipeViewFlipper) findViewById(C8875R.id.palette_view);
        this.mPaletteContainer = swipeViewFlipper;
        swipeViewFlipper.setActionListener(new SwipeViewFlipper.ViewFlipperActionListener() { // from class: com.samsung.android.support.senl.nt.base.winset.view.setting.page.AbsSwipeBackgroundColorSettingView.1
            @Override // com.samsung.android.support.senl.nt.base.winset.view.SwipeViewFlipper.ViewFlipperActionListener
            public void onFlipped(boolean z) {
                Logger.m8697d(AbsSwipeBackgroundColorSettingView.TAG, "onFlipped(). showRightPage : " + z);
                AbsSwipeBackgroundColorSettingView.this.mPaletteIndicator.selectTab(AbsSwipeBackgroundColorSettingView.this.mPaletteIndicator.getTabAt(AbsSwipeBackgroundColorSettingView.this.mPaletteContainer.getDisplayedChild()));
            }
        });
        for (PaletteContainerView paletteContainerView : this.mPalette.getPaletteContainerViewList()) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) paletteContainerView.getLayoutParams();
            marginLayoutParams.width = -1;
            marginLayoutParams.height = getContext().getResources().getDimensionPixelSize(C8875R.dimen.background_color_palette_height);
            marginLayoutParams.topMargin = getContext().getResources().getDimensionPixelSize(C8875R.dimen.background_color_palette_margin_top_bottom);
            marginLayoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(C8875R.dimen.background_color_palette_margin_top_bottom);
            paletteContainerView.setLayoutParams(marginLayoutParams);
            paletteContainerView.setGravity(17);
            this.mPaletteContainer.addView(paletteContainerView);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(C8875R.dimen.setting_color_palette_page_indicator_size);
            TabLayout.Tab tabNewTab = this.mPaletteIndicator.newTab();
            View view = new View(getContext());
            ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(dimensionPixelSize, dimensionPixelSize);
            int i = dimensionPixelSize / 2;
            marginLayoutParams2.setMargins(i, 0, i, 0);
            view.setLayoutParams(marginLayoutParams2);
            view.setBackgroundResource(C8875R.drawable.color_palette_v70_default_indicator);
            tabNewTab.setCustomView(view);
            this.mPaletteIndicator.addTab(tabNewTab);
        }
    }

    private void initSelectedColor() {
        int size = this.mPalette.getColorPaletteData().size();
        for (int i = 0; i < size; i++) {
            SpenColorPaletteData spenColorPaletteData = this.mPalette.getColorPaletteData().get(i);
            int length = spenColorPaletteData.values.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (spenColorPaletteData.values[i2] == this.mCurrentColor) {
                    this.mPalette.getPaletteContainerViewList().get(i).updatePaletteItem(i2, true, false);
                    selectTab(i);
                    this.mCurrentPaletteId = i;
                    this.mCurrentColorIndex = i2;
                    return;
                }
            }
        }
        Logger.m8697d(TAG, "initSelectedColor# if it don't find the color position. color : " + this.mCurrentColor);
        this.mCurrentPaletteId = 0;
        this.mCurrentColorIndex = 0;
        selectTab(0);
    }

    private void initView() {
        initPalette();
        initInvertLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onInvertChanged(boolean z) {
        SwitchCompat switchCompat = this.mInvertSwitch;
        if (switchCompat == null) {
            return;
        }
        this.mCurrentInvert = z;
        switchCompat.setChecked(z);
        this.mPalette.updateDefaultColorLayout(this.mCurrentInvert);
        invertBackgroundColor(z);
        notifyChanged();
        loggingOnInvertChanged(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void selectTab(int i) {
        AbstractC4539a.m3203m(i, "selectTab ", TAG);
        this.mPaletteContainer.setDisplayedChild(i);
        TabLayout tabLayout = this.mPaletteIndicator;
        tabLayout.selectTab(tabLayout.getTabAt(i));
        sendTalkBackMessage(i);
    }

    private void sendTalkBackMessage(int i) {
        Resources resources = getContext().getResources();
        StringBuilder sb = new StringBuilder();
        AbstractC8014b.m7202d(resources, C8875R.string.background_color_Tab, sb, " ");
        sb.append(resources.getString(C8875R.string.background_color_select_of, Integer.valueOf(i + 1), Integer.valueOf(this.mPaletteIndicator.getTabCount())));
        sb.append(SQLKeyword.COMMA);
        VoiceAssistantTTS.getInstance().sendTalkBackMessage(AbstractC0000a.m12i(resources, C8875R.string.selectall_voice_ass_selected, sb));
    }

    private void setUntouchableTab() {
        this.mPaletteIndicator.clearOnTabSelectedListeners();
        int i = 0;
        for (View view : this.mPaletteIndicator.getTouchables()) {
            view.setClickable(false);
            view.setTag(Integer.valueOf(i));
            view.setOnKeyListener(new View.OnKeyListener() { // from class: com.samsung.android.support.senl.nt.base.winset.view.setting.page.AbsSwipeBackgroundColorSettingView.2
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view2, int i2, KeyEvent keyEvent) {
                    if ((i2 != 66 && i2 != 160 && i2 != 62) || keyEvent.getAction() != 1) {
                        return false;
                    }
                    AbsSwipeBackgroundColorSettingView.this.selectTab(((Integer) view2.getTag()).intValue());
                    return true;
                }
            });
            view.setOnTouchListener(new View.OnTouchListener() { // from class: com.samsung.android.support.senl.nt.base.winset.view.setting.page.AbsSwipeBackgroundColorSettingView.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 1 || motionEvent.getAction() == 212) {
                        AbsSwipeBackgroundColorSettingView.this.selectTab(((Integer) view2.getTag()).intValue());
                    }
                    return true;
                }
            });
            i++;
        }
    }

    private void updateInvertLayout() {
        if (this.mInvertLayout == null) {
            return;
        }
        if (!ContextUtils.isNightMode(getContext())) {
            this.mInvertLayout.setVisibility(8);
            return;
        }
        if (isCoeditDarkThemeOfF() && isCoeditNote() && !this.mCurrentInvert) {
            Logger.m8702i(TAG, "updateInvertLayout # the invert button does not support in coedit note.");
            this.mInvertLayout.setVisibility(8);
            return;
        }
        this.mInvertLayout.setVisibility(0);
        boolean zCanEnableInvertLayout = canEnableInvertLayout();
        SwitchCompat switchCompat = (SwitchCompat) this.mInvertLayout.findViewById(C8875R.id.invert_switch);
        switchCompat.setChecked(this.mCurrentInvert);
        switchCompat.setEnabled(zCanEnableInvertLayout);
        switchCompat.setAlpha(zCanEnableInvertLayout ? 1.0f : 0.1f);
        TextView textView = (TextView) this.mInvertLayout.findViewById(C8875R.id.invert_text);
        textView.setEnabled(zCanEnableInvertLayout);
        textView.setAlpha(zCanEnableInvertLayout ? 1.0f : 0.1f);
    }

    public abstract boolean canEnableInvertLayout();

    public abstract boolean getDefaultBackgroundInvert();

    public abstract PaletteCreator.OnItemActionListener getPaletteItemActionListener();

    public void init() {
        LayoutInflater.from(getContext()).inflate(C8875R.layout.page_swiped_background_color_settings_view, (ViewGroup) this, true);
        initView();
    }

    public void initStatus() {
        initSelectedColor();
        setUntouchableTab();
        updateInvertLayout();
    }

    public abstract void invertBackgroundColor(boolean z);

    public abstract boolean isCoeditDarkThemeOfF();

    public abstract boolean isCoeditNote();

    public abstract void loggingOnInvertChanged(boolean z);

    public abstract void notifyChanged();

    @Override // android.view.View
    public abstract void setBackgroundColor(int i);

    public AbsSwipeBackgroundColorSettingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentPaletteId = 0;
        this.mCurrentColorIndex = 0;
        init();
    }

    public AbsSwipeBackgroundColorSettingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentPaletteId = 0;
        this.mCurrentColorIndex = 0;
        init();
    }
}
