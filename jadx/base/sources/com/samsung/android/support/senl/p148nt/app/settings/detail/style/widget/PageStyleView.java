package com.samsung.android.support.senl.p148nt.app.settings.detail.style.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.SettingsSAConstants;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.constants.TemplateViewType;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.base.winset.view.common.ImageViewRadioButton;
import com.samsung.android.support.senl.p148nt.base.winset.view.setting.page.common.AbsPageStyleView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p095X2.SharedPreferencesOnSharedPreferenceChangeListenerC0340a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010\u0012\u001a\u00020\u0013H\u0017J\b\u0010\u0014\u001a\u00020\u0013H\u0014J\b\u0010\u0015\u001a\u00020\u0013H\u0014J\b\u0010\u0016\u001a\u00020\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\nH\u0002R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006 "}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/detail/style/widget/PageStyleView;", "Lcom/samsung/android/support/senl/nt/base/winset/view/setting/page/common/AbsPageStyleView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mRadioButtonTouchListener", "Landroid/view/View$OnTouchListener;", "mRadioButtonClickListener", "Landroid/view/View$OnClickListener;", "mSharedPreferenceChangeListener", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "initRadioButton", "", "onAttachedToWindow", "onDetachedFromWindow", "updateRadioButton", "insertSALog", "saveType", "radioButtonClickListener", "getRadioButtonClickListener", "()Landroid/view/View$OnClickListener;", "radioButtonTouchListener", "getRadioButtonTouchListener", "()Landroid/view/View$OnTouchListener;", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PageStyleView extends AbsPageStyleView {

    @NotNull
    private static final String TAG = "PageStyleView";

    @Nullable
    private View.OnClickListener mRadioButtonClickListener;

    @Nullable
    private View.OnTouchListener mRadioButtonTouchListener;

    @NotNull
    private final SharedPreferences.OnSharedPreferenceChangeListener mSharedPreferenceChangeListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageStyleView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mSharedPreferenceChangeListener = new SharedPreferencesOnSharedPreferenceChangeListenerC0340a(this, 9);
    }

    private final View.OnClickListener getRadioButtonClickListener() {
        if (this.mRadioButtonClickListener == null) {
            this.mRadioButtonClickListener = new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.settings.detail.style.widget.PageStyleView$radioButtonClickListener$1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (v == null) {
                        return;
                    }
                    Object tag = v.getTag();
                    Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.Int");
                    int iIntValue = ((Integer) tag).intValue();
                    SharedPreferencesCompat.INSTANCE.getInstance("Settings").putInt(SettingsConstants.SETTINGS_PREFERRED_NOTE_STYLE, iIntValue);
                    this.this$0.updateRadioButton();
                    this.this$0.insertSALog(iIntValue);
                }
            };
        }
        View.OnClickListener onClickListener = this.mRadioButtonClickListener;
        Intrinsics.checkNotNull(onClickListener);
        return onClickListener;
    }

    private final View.OnTouchListener getRadioButtonTouchListener() {
        if (this.mRadioButtonTouchListener == null) {
            this.mRadioButtonTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.support.senl.nt.app.settings.detail.style.widget.PageStyleView$radioButtonTouchListener$1
                private final boolean isCanNotApplyInfiniteScrollingPageType(int touchedPageType) {
                    if (touchedPageType != 0) {
                        return false;
                    }
                    return TemplateViewType.isPdfType(SharedPreferencesCompat.INSTANCE.getInstance("Settings").getInt(SettingsConstants.SETTINGS_TEMPLATE_TYPE, 10));
                }

                @Override // android.view.View.OnTouchListener
                @SuppressLint({"ClickableViewAccessibility"})
                public boolean onTouch(View v, MotionEvent event) {
                    Intrinsics.checkNotNullParameter(v, "v");
                    Intrinsics.checkNotNullParameter(event, "event");
                    Object tag = v.getTag();
                    Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.Int");
                    if (!isCanNotApplyInfiniteScrollingPageType(((Integer) tag).intValue())) {
                        return false;
                    }
                    ToastHandler.show(this.this$0.getContext(), this.this$0.getContext().getString(C8003R.string.f6017xa5e6aa19), 0, false);
                    return true;
                }
            };
        }
        View.OnTouchListener onTouchListener = this.mRadioButtonTouchListener;
        Intrinsics.checkNotNull(onTouchListener);
        return onTouchListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void insertSALog(int saveType) {
        AbstractC8014b.m7201c(saveType, "insertSALog# saveType : ", TAG);
        if (saveType == 0) {
            CommonSamsungAnalytics.INSTANCE.insertLog("510", SettingsSAConstants.EVENT_SETTINGS_PAGE_STYLE_CHANGE, "b");
        } else if (saveType != 1) {
            AbstractC8014b.m7201c(saveType, "unexpected saveType: ", TAG);
        } else {
            CommonSamsungAnalytics.INSTANCE.insertLog("510", SettingsSAConstants.EVENT_SETTINGS_PAGE_STYLE_CHANGE, "a");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mSharedPreferenceChangeListener$lambda$0(PageStyleView pageStyleView, SharedPreferences sharedPreferences, String str) {
        if (Intrinsics.areEqual(SettingsConstants.SETTINGS_PREFERRED_NOTE_STYLE, str)) {
            pageStyleView.updateRadioButton();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.setting.page.common.AbsPageStyleView
    @SuppressLint({"ClickableViewAccessibility"})
    public void initRadioButton() {
        super.initRadioButton();
        ImageViewRadioButton mSplitPagesRadioButton = getMSplitPagesRadioButton();
        if (mSplitPagesRadioButton != null) {
            mSplitPagesRadioButton.setOnClickListener(getRadioButtonClickListener());
        }
        ImageViewRadioButton mInfiniteScrollRadioButton = getMInfiniteScrollRadioButton();
        if (mInfiniteScrollRadioButton != null) {
            mInfiniteScrollRadioButton.setOnClickListener(getRadioButtonClickListener());
        }
        ImageViewRadioButton mSplitPagesRadioButton2 = getMSplitPagesRadioButton();
        if (mSplitPagesRadioButton2 != null) {
            mSplitPagesRadioButton2.setOnTouchListener(getRadioButtonTouchListener());
        }
        ImageViewRadioButton mInfiniteScrollRadioButton2 = getMInfiniteScrollRadioButton();
        if (mInfiniteScrollRadioButton2 != null) {
            mInfiniteScrollRadioButton2.setOnTouchListener(getRadioButtonTouchListener());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        SharedPreferencesCompat.INSTANCE.getInstance("Settings").registerOnSharedPreferenceChangeListener(this.mSharedPreferenceChangeListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SharedPreferencesCompat.INSTANCE.getInstance("Settings").unregisterOnSharedPreferenceChangeListener(this.mSharedPreferenceChangeListener);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.setting.page.common.AbsPageStyleView
    public void updateRadioButton() {
        if (getMSplitPagesRadioButton() == null || getMInfiniteScrollRadioButton() == null) {
            return;
        }
        updateRadioButton(SharedPreferencesCompat.INSTANCE.getInstance("Settings").getInt(SettingsConstants.SETTINGS_PREFERRED_NOTE_STYLE, 1));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageStyleView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mSharedPreferenceChangeListener = new SharedPreferencesOnSharedPreferenceChangeListenerC0340a(this, 9);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageStyleView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mSharedPreferenceChangeListener = new SharedPreferencesOnSharedPreferenceChangeListenerC0340a(this, 9);
    }
}
