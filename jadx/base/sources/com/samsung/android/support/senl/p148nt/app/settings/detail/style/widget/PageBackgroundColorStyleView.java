package com.samsung.android.support.senl.p148nt.app.settings.detail.style.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.SwitchCompat;
import com.google.android.material.oneui.floatingdock.ViewOnTouchListenerC4799j;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.SettingsSAConstants;
import com.samsung.android.support.senl.p148nt.app.lock.view.create.C8127a;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.constants.TemplateViewType;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.base.winset.view.palette.PaletteContainerView;
import com.samsung.android.support.senl.p148nt.base.winset.view.palette.PaletteCreator;
import com.samsung.android.support.senl.p148nt.base.winset.view.setting.page.common.AbsBackgroundColorStyleView;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.BackgroundColorUtil;
import com.samsung.android.support.senl.p148nt.model.base.document.DocumentStyleRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p095X2.SharedPreferencesOnSharedPreferenceChangeListenerC0340a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u0000 )2\u00020\u0001:\u0001)B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0012\u001a\u00020\nH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016J\b\u0010\u0016\u001a\u00020\nH\u0016J\b\u0010\u0017\u001a\u00020\nH\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\nH\u0016J\b\u0010\u001f\u001a\u00020\u0011H\u0017J\u0010\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u001bH\u0002J\u0018\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u001bH\u0002J\u0010\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\u001bH\u0002J\b\u0010%\u001a\u00020\u0011H\u0002J\b\u0010&\u001a\u00020\u0011H\u0014J\b\u0010'\u001a\u00020\u0011H\u0014J\b\u0010(\u001a\u00020\rH\u0002R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/detail/style/widget/PageBackgroundColorStyleView;", "Lcom/samsung/android/support/senl/nt/base/winset/view/setting/page/common/AbsBackgroundColorStyleView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mDocumentStyleRepository", "Lcom/samsung/android/support/senl/nt/model/base/document/DocumentStyleRepository;", "mPreferenceChangeListener", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "initialize", "", "getLayoutResource", "getPaletteItemActionListener", "Lcom/samsung/android/support/senl/nt/base/winset/view/palette/PaletteCreator$OnItemActionListener;", "getCurrentColor", "getPaletteItemWidth", "getPaletteItemHeight", "getPaletteItemScale", "", "isDefaultBackgroundColorInverted", "", "setSelectedColor", "paletteId", "colorIndex", "initInvertSwitch", "setInvertSwitchChecked", "checked", "withPreferenceUpdate", "setInvertSwitchEnabled", "enabled", "updateInvertSwitchAlpha", "onAttachedToWindow", "onDetachedFromWindow", "getDocumentStyleRepository", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PageBackgroundColorStyleView extends AbsBackgroundColorStyleView {

    @NotNull
    private static final String TAG = "PageBackgroundColorStyleView";

    @Nullable
    private DocumentStyleRepository mDocumentStyleRepository;

    @NotNull
    private final SharedPreferences.OnSharedPreferenceChangeListener mPreferenceChangeListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageBackgroundColorStyleView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mPreferenceChangeListener = new SharedPreferencesOnSharedPreferenceChangeListenerC0340a(this, 6);
    }

    private final DocumentStyleRepository getDocumentStyleRepository() {
        if (this.mDocumentStyleRepository == null) {
            this.mDocumentStyleRepository = new DocumentStyleRepository();
        }
        DocumentStyleRepository documentStyleRepository = this.mDocumentStyleRepository;
        Intrinsics.checkNotNull(documentStyleRepository);
        return documentStyleRepository;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initInvertSwitch$lambda$3$lambda$1(PageBackgroundColorStyleView pageBackgroundColorStyleView, View view, MotionEvent motionEvent) {
        if (!view.isEnabled() && motionEvent.getAction() == 0) {
            ToastHandler.show(pageBackgroundColorStyleView.getContext(), C8003R.string.dark_mode_not_applied_template_image_toast_msg, 0);
        }
        return !view.isEnabled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initInvertSwitch$lambda$3$lambda$2(CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        SharedPreferencesCompat.INSTANCE.getInstance("Settings").putBoolean(SettingsConstants.SETTINGS_PAGE_COLOR_ADJUST_IN_DARK_MODE, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mPreferenceChangeListener$lambda$0(PageBackgroundColorStyleView pageBackgroundColorStyleView, SharedPreferences sharedPreferences, String str) {
        if (Intrinsics.areEqual(SettingsConstants.SETTINGS_PAGE_COLOR_ADJUST_IN_DARK_MODE, str)) {
            pageBackgroundColorStyleView.updateDefaultColorLayout();
            pageBackgroundColorStyleView.setInvertSwitchChecked(SharedPreferencesCompat.INSTANCE.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_PAGE_COLOR_ADJUST_IN_DARK_MODE, true), false);
            CommonSamsungAnalytics.INSTANCE.insertLog("510", SettingsSAConstants.EVENT_SETTINGS_PAGE_ADJUST_COLOR_IN_DARK_MODE, BackgroundColorUtil.getDefaultBackgroundInvert() ? "1" : "0");
        } else {
            if (!Intrinsics.areEqual(SettingsConstants.SETTINGS_TEMPLATE_TYPE, str)) {
                if (Intrinsics.areEqual(SettingsConstants.SETTINGS_PAGE_COLOR, str)) {
                    pageBackgroundColorStyleView.updateSelectedColor(pageBackgroundColorStyleView.getCurrentColor());
                    return;
                }
                return;
            }
            boolean zIsBackgroundInvertibleTemplateType = pageBackgroundColorStyleView.getDocumentStyleRepository().isBackgroundInvertibleTemplateType();
            boolean zIsDefaultImageType = TemplateViewType.isDefaultImageType(pageBackgroundColorStyleView.getDocumentStyleRepository().getTemplateType());
            pageBackgroundColorStyleView.setInvertSwitchEnabled(ContextUtils.isNightMode(pageBackgroundColorStyleView.getContext()) && zIsBackgroundInvertibleTemplateType && zIsDefaultImageType);
            if (!ContextUtils.isNightMode(pageBackgroundColorStyleView.getContext()) || zIsBackgroundInvertibleTemplateType || zIsDefaultImageType) {
                return;
            }
            pageBackgroundColorStyleView.setInvertSwitchChecked(false);
        }
    }

    private final void setInvertSwitchChecked(boolean checked) {
        setInvertSwitchChecked(checked, true);
    }

    private final void setInvertSwitchEnabled(boolean enabled) {
        SwitchCompat mInvertSwitch = getMInvertSwitch();
        if (mInvertSwitch != null) {
            mInvertSwitch.setEnabled(enabled);
        }
        updateInvertSwitchAlpha();
    }

    private final void updateInvertSwitchAlpha() {
        SwitchCompat mInvertSwitch = getMInvertSwitch();
        if (mInvertSwitch != null) {
            if (mInvertSwitch.isEnabled()) {
                mInvertSwitch.setAlpha(1.0f);
            } else {
                mInvertSwitch.setAlpha(0.5f);
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.setting.page.common.AbsBackgroundColorStyleView
    public int getCurrentColor() {
        SharedPreferencesCompat companion = SharedPreferencesCompat.INSTANCE.getInstance("Settings");
        PaletteCreator mPalette = getMPalette();
        Intrinsics.checkNotNull(mPalette);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        return companion.getInt(SettingsConstants.SETTINGS_PAGE_COLOR, mPalette.getDefaultColor(context));
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.setting.page.common.AbsBackgroundColorStyleView
    public int getLayoutResource() {
        return C8003R.layout.settings_color_style_view;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.setting.page.common.AbsBackgroundColorStyleView
    @NotNull
    public PaletteCreator.OnItemActionListener getPaletteItemActionListener() {
        return new PaletteCreator.OnItemActionListener() { // from class: com.samsung.android.support.senl.nt.app.settings.detail.style.widget.PageBackgroundColorStyleView.getPaletteItemActionListener.1
            @Override // com.samsung.android.support.senl.nt.base.winset.view.palette.PaletteCreator.OnItemActionListener
            public void onPaletteClicked(int paletteId, int colorIndex) {
                PageBackgroundColorStyleView.this.setSelectedColor(paletteId, colorIndex);
            }
        };
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.setting.page.common.AbsBackgroundColorStyleView
    public int getPaletteItemHeight() {
        return getResources().getDimensionPixelSize(C8003R.dimen.page_color_item_height);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.setting.page.common.AbsBackgroundColorStyleView
    public float getPaletteItemScale() {
        return 1.14f;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.setting.page.common.AbsBackgroundColorStyleView
    public int getPaletteItemWidth() {
        return getResources().getDimensionPixelSize(C8003R.dimen.page_color_item_width);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.setting.page.common.AbsBackgroundColorStyleView
    @SuppressLint({"ClickableViewAccessibility"})
    public void initInvertSwitch() {
        boolean zIsNightMode = ContextUtils.isNightMode(getContext());
        boolean zIsBackgroundInvertibleTemplateType = getDocumentStyleRepository().isBackgroundInvertibleTemplateType();
        MainLogger.m7258i(TAG, "initInvertSwitch# isNightMode=" + zIsNightMode + " isInvertibleTemplateUsed=" + zIsBackgroundInvertibleTemplateType);
        setMInvertSwitch((SwitchCompat) findViewById(C8003R.id.settings_color_style_adjust_in_dark_mode));
        SwitchCompat mInvertSwitch = getMInvertSwitch();
        if (mInvertSwitch != null) {
            mInvertSwitch.setOnTouchListener(new ViewOnTouchListenerC4799j(this, 16));
            mInvertSwitch.setOnCheckedChangeListener(new C8127a(1));
            if (!zIsNightMode || zIsBackgroundInvertibleTemplateType) {
                setInvertSwitchChecked(SharedPreferencesCompat.INSTANCE.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_PAGE_COLOR_ADJUST_IN_DARK_MODE, true), false);
            } else {
                setInvertSwitchChecked(false);
            }
            if (zIsNightMode) {
                mInvertSwitch.setVisibility(0);
            } else {
                mInvertSwitch.setVisibility(8);
            }
        }
        setInvertSwitchEnabled(zIsNightMode && zIsBackgroundInvertibleTemplateType);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.setting.page.common.AbsBackgroundColorStyleView
    public void initialize(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.initialize(context);
        LinearLayout linearLayout = (LinearLayout) findViewById(C8003R.id.palette_layout);
        int dimensionPixelSize = getResources().getDimensionPixelSize(C8003R.dimen.page_color_container_margin_top_bottom);
        PaletteCreator mPalette = getMPalette();
        Intrinsics.checkNotNull(mPalette);
        for (PaletteContainerView paletteContainerView : mPalette.getPaletteContainerViewList()) {
            ViewGroup.LayoutParams layoutParams = paletteContainerView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.setMargins(0, dimensionPixelSize, 0, dimensionPixelSize);
            paletteContainerView.setLayoutParams(layoutParams2);
            linearLayout.addView(paletteContainerView);
        }
        initSelectedColor();
        initInvertSwitch();
        updateInvertSwitchAlpha();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.setting.page.common.AbsBackgroundColorStyleView
    public boolean isDefaultBackgroundColorInverted() {
        return BackgroundColorUtil.getDefaultBackgroundInvert();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        SharedPreferencesCompat.INSTANCE.getInstance("Settings").registerOnSharedPreferenceChangeListener(this.mPreferenceChangeListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SharedPreferencesCompat.INSTANCE.getInstance("Settings").unregisterOnSharedPreferenceChangeListener(this.mPreferenceChangeListener);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.setting.page.common.AbsBackgroundColorStyleView
    public void setSelectedColor(int paletteId, int colorIndex) {
        super.setSelectedColor(paletteId, colorIndex);
        AbstractC8014b.m7200b(paletteId, colorIndex, "setSelectedColor# paletteIndex=", " index=", TAG);
        SharedPreferencesCompat companion = SharedPreferencesCompat.INSTANCE.getInstance("Settings");
        PaletteCreator mPalette = getMPalette();
        Intrinsics.checkNotNull(mPalette);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        companion.putInt(SettingsConstants.SETTINGS_PAGE_COLOR, mPalette.getColor(context, paletteId, colorIndex));
        CommonSamsungAnalytics.INSTANCE.insertLog("510", SettingsSAConstants.EVENT_SETTINGS_PAGE_COLOR_CHANGE, (paletteId == 0 && colorIndex == 0) ? "a" : "b");
    }

    private final void setInvertSwitchChecked(boolean checked, boolean withPreferenceUpdate) {
        SwitchCompat mInvertSwitch = getMInvertSwitch();
        if (mInvertSwitch != null) {
            mInvertSwitch.setChecked(checked);
        }
        if (withPreferenceUpdate) {
            SharedPreferencesCompat.INSTANCE.getInstance("Settings").putBoolean(SettingsConstants.SETTINGS_PAGE_COLOR_ADJUST_IN_DARK_MODE, checked);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageBackgroundColorStyleView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mPreferenceChangeListener = new SharedPreferencesOnSharedPreferenceChangeListenerC0340a(this, 6);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageBackgroundColorStyleView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mPreferenceChangeListener = new SharedPreferencesOnSharedPreferenceChangeListenerC0340a(this, 6);
    }
}
