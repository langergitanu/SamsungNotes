package com.samsung.android.support.senl.p148nt.app.settings.detail.style.widget;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.view.View;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.base.winset.view.common.ImageRadioButton;
import com.samsung.android.support.senl.p148nt.base.winset.view.setting.page.common.AbsPageLayoutSettingsView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p095X2.SharedPreferencesOnSharedPreferenceChangeListenerC0340a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0014J\b\u0010\u0014\u001a\u00020\u0010H\u0014J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000bH\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/detail/style/widget/PageLayoutSettingsView;", "Lcom/samsung/android/support/senl/nt/base/winset/view/setting/page/common/AbsPageLayoutSettingsView;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mSharedPreferenceChangeListener", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "initLayout", "", "isA4LandscapeSupported", "", "onAttachedToWindow", "onDetachedFromWindow", "onClick", VPathDataCmd.RCurveTo, "Landroid/view/View;", "updateTemplateTypeForCustomTemplate", "newPageSize", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PageLayoutSettingsView extends AbsPageLayoutSettingsView implements View.OnClickListener {

    @NotNull
    private final SharedPreferences.OnSharedPreferenceChangeListener mSharedPreferenceChangeListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageLayoutSettingsView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mSharedPreferenceChangeListener = new SharedPreferencesOnSharedPreferenceChangeListenerC0340a(this, 7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mSharedPreferenceChangeListener$lambda$0(PageLayoutSettingsView pageLayoutSettingsView, SharedPreferences sharedPreferences, String str) {
        if (Intrinsics.areEqual(SettingsConstants.SETTINGS_PAGE_SIZE, str)) {
            pageLayoutSettingsView.updatePageSize();
        }
    }

    private final void updateTemplateTypeForCustomTemplate(View v, int newPageSize) {
        SharedPreferencesCompat.Companion companion = SharedPreferencesCompat.INSTANCE;
        if (companion.getInstance("Settings").getInt(SettingsConstants.SETTINGS_PAGE_SIZE, 0) == newPageSize) {
            return;
        }
        int i = companion.getInstance("Settings").getInt(SettingsConstants.SETTINGS_TEMPLATE_TYPE, 10);
        if (i == 3 || i == 5) {
            companion.getInstance("Settings").putInt(SettingsConstants.SETTINGS_TEMPLATE_TYPE, 10);
            companion.getInstance("Settings").putString(SettingsConstants.SETTINGS_PAGE_TEMPLATE, "0");
            if (newPageSize == 2) {
                ToastHandler.show(v.getContext(), C8875R.string.f6386x15377ee3, 0);
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.setting.page.common.AbsPageLayoutSettingsView
    public void initLayout() {
        super.initLayout();
        ImageRadioButton mNormalRadioButton = getMNormalRadioButton();
        if (mNormalRadioButton != null) {
            mNormalRadioButton.setOnClickListener(this);
        }
        ImageRadioButton mLongRadioButton = getMLongRadioButton();
        if (mLongRadioButton != null) {
            mLongRadioButton.setOnClickListener(this);
        }
        ImageRadioButton mLandscapeRadioButton = getMLandscapeRadioButton();
        if (mLandscapeRadioButton != null) {
            mLandscapeRadioButton.setOnClickListener(this);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.setting.page.common.AbsPageLayoutSettingsView
    public boolean isA4LandscapeSupported() {
        return true;
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
        if (id == C8875R.id.normal_radio_button) {
            updateTemplateTypeForCustomTemplate(v, 0);
            SharedPreferencesCompat.INSTANCE.getInstance("Settings").putInt(SettingsConstants.SETTINGS_PAGE_SIZE, 0);
        } else if (id == C8875R.id.long_radio_button) {
            updateTemplateTypeForCustomTemplate(v, 1);
            SharedPreferencesCompat.INSTANCE.getInstance("Settings").putInt(SettingsConstants.SETTINGS_PAGE_SIZE, 1);
        } else if (id == C8875R.id.landscape_radio_button) {
            updateTemplateTypeForCustomTemplate(v, 2);
            SharedPreferencesCompat.INSTANCE.getInstance("Settings").putInt(SettingsConstants.SETTINGS_PAGE_SIZE, 2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SharedPreferencesCompat.INSTANCE.getInstance("Settings").unregisterOnSharedPreferenceChangeListener(this.mSharedPreferenceChangeListener);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageLayoutSettingsView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mSharedPreferenceChangeListener = new SharedPreferencesOnSharedPreferenceChangeListenerC0340a(this, 7);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageLayoutSettingsView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mSharedPreferenceChangeListener = new SharedPreferencesOnSharedPreferenceChangeListenerC0340a(this, 7);
    }
}
