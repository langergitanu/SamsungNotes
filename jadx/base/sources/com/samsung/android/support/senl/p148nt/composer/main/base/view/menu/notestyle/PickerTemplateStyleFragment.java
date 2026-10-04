package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.constants.TemplateViewType;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.constants.ChangeTemplateConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.PickerTemplateStylePresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.view.LayoutSettingsMiniView;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.data.select.SelectedTemplateData;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.common.BaseTemplateStyleFragment;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.common.CommonTemplateStyleLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.BaseTemplatePresenter;
import com.samsung.android.support.senl.p148nt.model.assist.llm.p166sa.AssistSAConstants;
import com.samsung.android.support.senl.p148nt.model.base.document.DocumentPageRatio;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 02\u00020\u00012\u00020\u0002:\u00010B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\u001c\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J$\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000eH\u0014J\b\u0010\u0018\u001a\u00020\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\fH\u0016J\u0010\u0010'\u001a\u00020\f2\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020\nH\u0016J\u0018\u0010,\u001a\u00020\f2\u0006\u0010$\u001a\u00020%2\u0006\u0010-\u001a\u00020.H\u0016J\u0006\u0010/\u001a\u00020\fR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/PickerTemplateStyleFragment;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/template/view/common/BaseTemplateStyleFragment;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/PickerTemplateStylePresenter$Contract;", "<init>", "()V", "mLayoutMiniView", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/view/LayoutSettingsMiniView;", "createPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/template/view/presenter/BaseTemplatePresenter;", "savedInstanceState", "Landroid/os/Bundle;", "initLayoutMiniView", "", "view", "Landroid/view/View;", "initPickerTemplateStyleLayout", "createView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "getLayout", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/template/view/common/CommonTemplateStyleLayout;", "parentView", "getTAG", "", "getPageRatioType", "Lcom/samsung/android/support/senl/nt/model/base/document/DocumentPageRatio$PageRatioType;", "isAdditionalDialogRequired", "", "showAdditionalDialog", "context", "Landroid/content/Context;", "pageToApplyCallback", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/template/view/common/BaseTemplateStyleFragment$PageToApplyCallback;", "updateResultIntent", "resultIntent", "Landroid/content/Intent;", "onResume", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "outState", "updateAdditionalDialogResultIntent", "pageToApply", "", "loggingSATemplateChanged", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PickerTemplateStyleFragment extends BaseTemplateStyleFragment implements PickerTemplateStylePresenter.Contract {

    @NotNull
    public static final String TAG = "PickerTemplateStyleFragment";

    @Nullable
    private LayoutSettingsMiniView mLayoutMiniView;

    private final void initLayoutMiniView(View view, Bundle savedInstanceState) {
        this.mLayoutMiniView = view != null ? (LayoutSettingsMiniView) view.findViewById(C9086R.id.picker_layout_mini_view) : null;
        if (SharedPreferencesCompat.INSTANCE.getInstance("Settings").getInt(SettingsConstants.SETTINGS_PREFERRED_NOTE_STYLE, 1) == 0) {
            View viewFindViewById = view != null ? view.findViewById(C9086R.id.divider) : null;
            LayoutSettingsMiniView layoutSettingsMiniView = this.mLayoutMiniView;
            if (layoutSettingsMiniView != null) {
                layoutSettingsMiniView.setVisibility(8);
            }
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(8);
                return;
            }
            return;
        }
        LayoutSettingsMiniView layoutSettingsMiniView2 = this.mLayoutMiniView;
        if (layoutSettingsMiniView2 != null) {
            layoutSettingsMiniView2.setSettingChangeListener(new LayoutSettingsMiniView.SettingChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.PickerTemplateStyleFragment.initLayoutMiniView.1
                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.view.LayoutSettingsMiniView.SettingChangeListener
                public void onLayoutSettingChanged() {
                    BaseTemplatePresenter mPresenter = PickerTemplateStyleFragment.this.getMPresenter();
                    SelectedTemplateData selectedTemplateData = mPresenter != null ? mPresenter.getSelectedTemplateData() : null;
                    Intrinsics.checkNotNull(selectedTemplateData);
                    if (TemplateViewType.isCustomImageType(selectedTemplateData.getSelectedTemplateType())) {
                        selectedTemplateData.setDefaultTemplateData();
                    }
                    LayoutSettingsMiniView layoutSettingsMiniView3 = PickerTemplateStyleFragment.this.mLayoutMiniView;
                    if (layoutSettingsMiniView3 != null) {
                        layoutSettingsMiniView3.updateLayoutStyle();
                    }
                    if (PickerTemplateStyleFragment.this.getMPresenter() != null) {
                        BaseTemplatePresenter mPresenter2 = PickerTemplateStyleFragment.this.getMPresenter();
                        PickerTemplateStylePresenter pickerTemplateStylePresenter = mPresenter2 instanceof PickerTemplateStylePresenter ? (PickerTemplateStylePresenter) mPresenter2 : null;
                        if (pickerTemplateStylePresenter != null) {
                            LayoutSettingsMiniView layoutSettingsMiniView4 = PickerTemplateStyleFragment.this.mLayoutMiniView;
                            pickerTemplateStylePresenter.updateItemsPageRatio(layoutSettingsMiniView4 != null ? Integer.valueOf(layoutSettingsMiniView4.getPageSize()) : null);
                        }
                        PickerTemplateStyleFragment.this.updatePagerHeight();
                    }
                    PickerTemplateStyleFragment.this.onSelectedTemplateChanged();
                }
            });
        }
        LayoutSettingsMiniView layoutSettingsMiniView3 = this.mLayoutMiniView;
        if (layoutSettingsMiniView3 != null) {
            layoutSettingsMiniView3.initialize(savedInstanceState);
        }
    }

    private final void initPickerTemplateStyleLayout(View view) {
        initCommonTemplateStyleLayout(view);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.common.BaseTemplateStyleFragment
    @NotNull
    public BaseTemplatePresenter createPresenter(@Nullable Bundle savedInstanceState) {
        PickerTemplateStylePresenter pickerTemplateStylePresenter = new PickerTemplateStylePresenter(getContext(), this);
        if (savedInstanceState != null) {
            savedInstanceState.putInt(ChangeTemplateConstants.ARG_PAGE_TEMPLATE_CALLER, 3);
        }
        pickerTemplateStylePresenter.initialize(savedInstanceState);
        return pickerTemplateStylePresenter;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.common.BaseTemplateStyleFragment
    @NotNull
    public View createView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(C9086R.layout.picker_change_template_style_layout, container, false);
        initLayoutMiniView(viewInflate, savedInstanceState);
        Intrinsics.checkNotNull(viewInflate);
        initPickerTemplateStyleLayout(viewInflate);
        return viewInflate;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.common.BaseTemplateStyleFragment
    @NotNull
    public CommonTemplateStyleLayout getLayout(@NotNull View parentView) {
        Intrinsics.checkNotNullParameter(parentView, "parentView");
        View viewFindViewById = parentView.findViewById(C9086R.id.picker_template_style_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        return (CommonTemplateStyleLayout) viewFindViewById;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.presenter.BaseTemplatePresenter.Contract
    @NotNull
    public DocumentPageRatio.PageRatioType getPageRatioType() {
        LayoutSettingsMiniView layoutSettingsMiniView = this.mLayoutMiniView;
        Intrinsics.checkNotNull(layoutSettingsMiniView);
        DocumentPageRatio.PageRatioType pageRatioTypeFromPageSizeType = DocumentPageRatio.getPageRatioTypeFromPageSizeType(layoutSettingsMiniView.getPageSize());
        Intrinsics.checkNotNullExpressionValue(pageRatioTypeFromPageSizeType, "getPageRatioTypeFromPageSizeType(...)");
        return pageRatioTypeFromPageSizeType;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.common.BaseTemplateStyleFragment
    @NotNull
    public String getTAG() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.common.BaseTemplateStyleFragment
    public boolean isAdditionalDialogRequired() {
        return false;
    }

    public final void loggingSATemplateChanged() {
        LayoutSettingsMiniView layoutSettingsMiniView = this.mLayoutMiniView;
        String str = null;
        Integer numValueOf = layoutSettingsMiniView != null ? Integer.valueOf(layoutSettingsMiniView.getPageSize()) : null;
        if (numValueOf != null && numValueOf.intValue() == 0) {
            str = "a";
        } else if (numValueOf != null && numValueOf.intValue() == 2) {
            str = "c";
        } else if (numValueOf != null && numValueOf.intValue() == 1) {
            str = "b";
        }
        if (str != null) {
            CommonSamsungAnalytics.INSTANCE.insertLog("101", AssistSAConstants.EVENT_PAGE_LAYOUT, str);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.common.BaseTemplateStyleFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        updatePagerHeight();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.common.BaseTemplateStyleFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        BaseTemplatePresenter mPresenter = getMPresenter();
        PickerTemplateStylePresenter pickerTemplateStylePresenter = mPresenter instanceof PickerTemplateStylePresenter ? (PickerTemplateStylePresenter) mPresenter : null;
        if (pickerTemplateStylePresenter != null) {
            LayoutSettingsMiniView layoutSettingsMiniView = this.mLayoutMiniView;
            pickerTemplateStylePresenter.updateItemsPageRatio(layoutSettingsMiniView != null ? Integer.valueOf(layoutSettingsMiniView.getPageSize()) : null);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.common.BaseTemplateStyleFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        LayoutSettingsMiniView layoutSettingsMiniView = this.mLayoutMiniView;
        Integer numValueOf = layoutSettingsMiniView != null ? Integer.valueOf(layoutSettingsMiniView.getPageSize()) : null;
        Intrinsics.checkNotNull(numValueOf);
        outState.putInt(SettingsConstants.SETTINGS_PAGE_SIZE, numValueOf.intValue());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.common.BaseTemplateStyleFragment
    public void showAdditionalDialog(@NotNull Context context, @NotNull BaseTemplateStyleFragment.PageToApplyCallback pageToApplyCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pageToApplyCallback, "pageToApplyCallback");
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.common.BaseTemplateStyleFragment
    public void updateAdditionalDialogResultIntent(@NotNull Intent resultIntent, int pageToApply) {
        Intrinsics.checkNotNullParameter(resultIntent, "resultIntent");
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.common.BaseTemplateStyleFragment
    public boolean updateResultIntent(@NotNull Intent resultIntent) {
        Intrinsics.checkNotNullParameter(resultIntent, "resultIntent");
        super.updateResultIntent(resultIntent);
        LayoutSettingsMiniView layoutSettingsMiniView = this.mLayoutMiniView;
        resultIntent.putExtra(SettingsConstants.SETTINGS_PAGE_SIZE, layoutSettingsMiniView != null ? Integer.valueOf(layoutSettingsMiniView.getPageSize()) : null);
        return true;
    }
}
