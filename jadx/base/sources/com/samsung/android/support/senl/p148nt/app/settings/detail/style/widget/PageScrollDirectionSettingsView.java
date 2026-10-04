package com.samsung.android.support.senl.p148nt.app.settings.detail.style.widget;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.view.View;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ModelFeature;
import com.samsung.android.support.senl.p148nt.base.winset.view.common.ImageRadioButton;
import com.samsung.android.support.senl.p148nt.base.winset.view.setting.page.common.AbsPageScrollDirectionSettingsView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p095X2.SharedPreferencesOnSharedPreferenceChangeListenerC0340a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\b\u0010\u0011\u001a\u00020\u000fH\u0014J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0018\u001a\u00020\u000fH\u0002J\b\u0010\u0019\u001a\u00020\u000fH\u0002J\b\u0010\u001a\u001a\u00020\u000fH\u0002J\b\u0010\u001b\u001a\u00020\u0016H\u0016R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/detail/style/widget/PageScrollDirectionSettingsView;", "Lcom/samsung/android/support/senl/nt/base/winset/view/setting/page/common/AbsPageScrollDirectionSettingsView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mSharedPreferenceChangeListener", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "updatePageScrollStyle", "", "onAttachedToWindow", "onDetachedFromWindow", "onClick", VPathDataCmd.RCurveTo, "Landroid/view/View;", "isVerticalScroll", "", "isSinglePage", "setScrollSinglePageVertical", "setScrollSinglePageHorizontal", "setScrollTwoPageHorizontal", "isTwoPageButtonVisible", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PageScrollDirectionSettingsView extends AbsPageScrollDirectionSettingsView {

    @NotNull
    private final SharedPreferences.OnSharedPreferenceChangeListener mSharedPreferenceChangeListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageScrollDirectionSettingsView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mSharedPreferenceChangeListener = new SharedPreferencesOnSharedPreferenceChangeListenerC0340a(this, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mSharedPreferenceChangeListener$lambda$0(PageScrollDirectionSettingsView pageScrollDirectionSettingsView, SharedPreferences sharedPreferences, String str) {
        if (Intrinsics.areEqual(SettingsConstants.SETTINGS_PAGE_SCROLL_DIRECTION, str) || Intrinsics.areEqual(SettingsConstants.SETTINGS_PAGE_LAYOUT_COLUMN, str) || Intrinsics.areEqual(SettingsConstants.SETTINGS_PAGE_SIZE, str)) {
            pageScrollDirectionSettingsView.updatePageScrollStyle();
        }
    }

    private final void setScrollSinglePageHorizontal() {
        SharedPreferencesCompat companion = SharedPreferencesCompat.INSTANCE.getInstance("Settings");
        companion.putBoolean(SettingsConstants.SETTINGS_PAGE_SCROLL_DIRECTION, false);
        companion.putInt(SettingsConstants.SETTINGS_PAGE_LAYOUT_COLUMN, 1);
    }

    private final void setScrollSinglePageVertical() {
        SharedPreferencesCompat companion = SharedPreferencesCompat.INSTANCE.getInstance("Settings");
        companion.putBoolean(SettingsConstants.SETTINGS_PAGE_SCROLL_DIRECTION, true);
        companion.putInt(SettingsConstants.SETTINGS_PAGE_LAYOUT_COLUMN, 1);
    }

    private final void setScrollTwoPageHorizontal() {
        SharedPreferencesCompat companion = SharedPreferencesCompat.INSTANCE.getInstance("Settings");
        companion.putBoolean(SettingsConstants.SETTINGS_PAGE_SCROLL_DIRECTION, false);
        companion.putInt(SettingsConstants.SETTINGS_PAGE_LAYOUT_COLUMN, 2);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.setting.page.common.AbsPageScrollDirectionSettingsView
    public boolean isSinglePage() {
        return SharedPreferencesCompat.INSTANCE.getInstance("Settings").getInt(SettingsConstants.SETTINGS_PAGE_LAYOUT_COLUMN, 1) == 1;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.setting.page.common.AbsPageScrollDirectionSettingsView
    public boolean isTwoPageButtonVisible() {
        return (ModelFeature.getFeature().isFoldableModel() || DeviceUtils.isTabletModel()) && 2 != SharedPreferencesCompat.INSTANCE.getInstance("Settings").getInt(SettingsConstants.SETTINGS_PAGE_SIZE, 0);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.setting.page.common.AbsPageScrollDirectionSettingsView
    public boolean isVerticalScroll() {
        return SharedPreferencesCompat.INSTANCE.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_PAGE_SCROLL_DIRECTION, true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        SharedPreferencesCompat.INSTANCE.getInstance("Settings").registerOnSharedPreferenceChangeListener(this.mSharedPreferenceChangeListener);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        int id = v.getId();
        if (id == C8875R.id.page_scroll_vertical_radio_button) {
            setScrollSinglePageVertical();
        } else if (id == C8875R.id.page_scroll_horizontal_radio_button) {
            setScrollSinglePageHorizontal();
        } else if (id == C8875R.id.page_scroll_two_page_radio_button) {
            setScrollTwoPageHorizontal();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SharedPreferencesCompat.INSTANCE.getInstance("Settings").unregisterOnSharedPreferenceChangeListener(this.mSharedPreferenceChangeListener);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.setting.page.common.AbsPageScrollDirectionSettingsView
    public void updatePageScrollStyle() {
        super.updatePageScrollStyle();
        if (getMVerticalRadioButton() == null || getMHorizontalRadioButton() == null || getMTwoPageButton() == null) {
            return;
        }
        if (isTwoPageButtonVisible()) {
            ImageRadioButton mTwoPageButton = getMTwoPageButton();
            Intrinsics.checkNotNull(mTwoPageButton);
            mTwoPageButton.setVisibility(0);
            return;
        }
        if (!isSinglePage()) {
            if (isVerticalScroll()) {
                setScrollSinglePageVertical();
            } else {
                setScrollSinglePageHorizontal();
            }
        }
        ImageRadioButton mTwoPageButton2 = getMTwoPageButton();
        Intrinsics.checkNotNull(mTwoPageButton2);
        mTwoPageButton2.setVisibility(8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageScrollDirectionSettingsView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mSharedPreferenceChangeListener = new SharedPreferencesOnSharedPreferenceChangeListenerC0340a(this, 8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageScrollDirectionSettingsView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mSharedPreferenceChangeListener = new SharedPreferencesOnSharedPreferenceChangeListenerC0340a(this, 8);
    }
}
