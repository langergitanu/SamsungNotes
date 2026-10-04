package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.samsung.android.support.senl.p148nt.base.common.constants.TemplateViewType;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.constants.ChangeTemplateConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog.PageToApplySingleModeDialog;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog.PageToApplyTwoPageModeDialog;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.data.select.SelectedTemplateData;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.data.state.ViewStateData;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.common.BaseTemplateStyleFragment;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.common.CommonTemplateStyleLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.BaseTemplatePresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.PageTemplateStylePresenter;
import com.samsung.android.support.senl.p148nt.model.base.document.DocumentPageRatio;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 /2\u00020\u00012\u00020\u0002:\u0001/B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J$\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0006\u0010\u0014\u001a\u00020\u0015J\u0018\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001c\u001a\u00020\u0015H\u0002J\b\u0010\u001d\u001a\u00020\u0015H\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\rH\u0014J\b\u0010!\u001a\u00020\"H\u0014J\b\u0010#\u001a\u00020\u0015H\u0016J\u0018\u0010$\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020\u00152\u0006\u0010-\u001a\u00020.H\u0016¨\u00060"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/template/view/PageTemplateStyleFragment;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/template/view/common/BaseTemplateStyleFragment;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/template/view/presenter/PageTemplateStylePresenter$Contract;", "<init>", "()V", "setContract", "contract", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/template/view/common/BaseTemplateStyleFragment$Contract;", "createPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/template/view/presenter/BaseTemplatePresenter;", "savedInstanceState", "Landroid/os/Bundle;", "createView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "setupIntentTemplateInfo", "", "hasSelectedTemplate", "", "showSingleModePageToApplyDialog", "context", "Landroid/content/Context;", "pageToApplyCallback", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/template/view/common/BaseTemplateStyleFragment$PageToApplyCallback;", "showTwoPageModePageToApplyDialog", "isSingleModeDialogRequired", "isTwoPageModeDialogRequired", "getLayout", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/template/view/common/CommonTemplateStyleLayout;", "parentView", "getTAG", "", "isAdditionalDialogRequired", "showAdditionalDialog", "updateAdditionalDialogResultIntent", "resultIntent", "Landroid/content/Intent;", "pageToApply", "", "getPageRatioType", "Lcom/samsung/android/support/senl/nt/model/base/document/DocumentPageRatio$PageRatioType;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PageTemplateStyleFragment extends BaseTemplateStyleFragment implements PageTemplateStylePresenter.Contract {

    @NotNull
    public static final String TAG = "ChangeTemplateFragment";

    private final boolean isSingleModeDialogRequired() {
        BaseTemplatePresenter mPresenter = getMPresenter();
        ViewStateData viewStateData = mPresenter != null ? mPresenter.getViewStateData() : null;
        Intrinsics.checkNotNull(viewStateData);
        boolean zIsPickerMode = viewStateData.isPickerMode();
        BaseTemplatePresenter mPresenter2 = getMPresenter();
        ViewStateData viewStateData2 = mPresenter2 != null ? mPresenter2.getViewStateData() : null;
        Intrinsics.checkNotNull(viewStateData2);
        boolean isTwoPage = viewStateData2.getIsTwoPage();
        BaseTemplatePresenter mPresenter3 = getMPresenter();
        ViewStateData viewStateData3 = mPresenter3 != null ? mPresenter3.getViewStateData() : null;
        Intrinsics.checkNotNull(viewStateData3);
        return (isTwoPage || viewStateData3.getHasPDFPage() || zIsPickerMode) ? false : true;
    }

    private final boolean isTwoPageModeDialogRequired() {
        BaseTemplatePresenter mPresenter = getMPresenter();
        ViewStateData viewStateData = mPresenter != null ? mPresenter.getViewStateData() : null;
        Intrinsics.checkNotNull(viewStateData);
        boolean isTwoPage = viewStateData.getIsTwoPage();
        BaseTemplatePresenter mPresenter2 = getMPresenter();
        ViewStateData viewStateData2 = mPresenter2 != null ? mPresenter2.getViewStateData() : null;
        Intrinsics.checkNotNull(viewStateData2);
        boolean hasPDFPage = viewStateData2.getHasPDFPage();
        BaseTemplatePresenter mPresenter3 = getMPresenter();
        ViewStateData viewStateData3 = mPresenter3 != null ? mPresenter3.getViewStateData() : null;
        Intrinsics.checkNotNull(viewStateData3);
        return (!isTwoPage || hasPDFPage || viewStateData3.getHasPDFPageNext()) ? false : true;
    }

    private final void setupIntentTemplateInfo() {
        if (getActivity() != null) {
            FragmentActivity activity = getActivity();
            Intrinsics.checkNotNull(activity);
            if (activity.getIntent() == null) {
                return;
            }
            FragmentActivity activity2 = getActivity();
            Intrinsics.checkNotNull(activity2);
            int intExtra = activity2.getIntent().getIntExtra(ChangeTemplateConstants.ARG_PAGE_TEMPLATE_CALLER, 1);
            FragmentActivity activity3 = getActivity();
            Intrinsics.checkNotNull(activity3);
            boolean booleanExtra = activity3.getIntent().getBooleanExtra(ChangeTemplateConstants.ARG_TEMPLATE_SINGLE_MODE, false);
            FragmentActivity activity4 = getActivity();
            Intrinsics.checkNotNull(activity4);
            boolean booleanExtra2 = activity4.getIntent().getBooleanExtra(ChangeTemplateConstants.ARG_TEMPLATE_HAS_PDF_PAGE, false);
            FragmentActivity activity5 = getActivity();
            Intrinsics.checkNotNull(activity5);
            boolean booleanExtra3 = activity5.getIntent().getBooleanExtra(ChangeTemplateConstants.ARG_TEMPLATE_IS_TWO_PAGE, false);
            FragmentActivity activity6 = getActivity();
            Intrinsics.checkNotNull(activity6);
            boolean booleanExtra4 = activity6.getIntent().getBooleanExtra(ChangeTemplateConstants.ARG_TEMPLATE_HAS_PDF_PAGE_NEXT, false);
            FragmentActivity activity7 = getActivity();
            Intrinsics.checkNotNull(activity7);
            int intExtra2 = activity7.getIntent().getIntExtra(ChangeTemplateConstants.ARG_TEMPLATE_PAGE_INDEX, -1);
            FragmentActivity activity8 = getActivity();
            Intrinsics.checkNotNull(activity8);
            int intExtra3 = activity8.getIntent().getIntExtra(ChangeTemplateConstants.ARG_TEMPLATE_PAGE_WIDTH, 0);
            FragmentActivity activity9 = getActivity();
            Intrinsics.checkNotNull(activity9);
            int intExtra4 = activity9.getIntent().getIntExtra(ChangeTemplateConstants.ARG_TEMPLATE_PAGE_HEIGHT, 0);
            FragmentActivity activity10 = getActivity();
            Intrinsics.checkNotNull(activity10);
            int intExtra5 = activity10.getIntent().getIntExtra(ChangeTemplateConstants.ARG_TEMPLATE_NEXT_PAGE_WIDTH, 0);
            FragmentActivity activity11 = getActivity();
            Intrinsics.checkNotNull(activity11);
            int intExtra6 = activity11.getIntent().getIntExtra(ChangeTemplateConstants.ARG_TEMPLATE_NEXT_PAGE_HEIGHT, 0);
            FragmentActivity activity12 = getActivity();
            Intrinsics.checkNotNull(activity12);
            int intExtra7 = activity12.getIntent().getIntExtra("template_type", 10);
            FragmentActivity activity13 = getActivity();
            Intrinsics.checkNotNull(activity13);
            String stringExtra = activity13.getIntent().getStringExtra(ChangeTemplateConstants.ARG_TEMPLATE_NAME);
            Bundle arguments = getArguments();
            if (arguments != null) {
                arguments.putInt(ChangeTemplateConstants.ARG_PAGE_TEMPLATE_CALLER, intExtra);
            }
            Bundle arguments2 = getArguments();
            if (arguments2 != null) {
                arguments2.putBoolean(ChangeTemplateConstants.ARG_TEMPLATE_SINGLE_MODE, booleanExtra);
            }
            Bundle arguments3 = getArguments();
            if (arguments3 != null) {
                arguments3.putBoolean(ChangeTemplateConstants.ARG_TEMPLATE_HAS_PDF_PAGE, booleanExtra2);
            }
            Bundle arguments4 = getArguments();
            if (arguments4 != null) {
                arguments4.putBoolean(ChangeTemplateConstants.ARG_TEMPLATE_IS_TWO_PAGE, booleanExtra3);
            }
            Bundle arguments5 = getArguments();
            if (arguments5 != null) {
                arguments5.putBoolean(ChangeTemplateConstants.ARG_TEMPLATE_HAS_PDF_PAGE_NEXT, booleanExtra4);
            }
            Bundle arguments6 = getArguments();
            if (arguments6 != null) {
                arguments6.putInt(ChangeTemplateConstants.ARG_TEMPLATE_PAGE_INDEX, intExtra2);
            }
            Bundle arguments7 = getArguments();
            if (arguments7 != null) {
                arguments7.putInt(ChangeTemplateConstants.ARG_TEMPLATE_PAGE_WIDTH, intExtra3);
            }
            Bundle arguments8 = getArguments();
            if (arguments8 != null) {
                arguments8.putInt(ChangeTemplateConstants.ARG_TEMPLATE_PAGE_HEIGHT, intExtra4);
            }
            Bundle arguments9 = getArguments();
            if (arguments9 != null) {
                arguments9.putInt(ChangeTemplateConstants.ARG_TEMPLATE_NEXT_PAGE_WIDTH, intExtra5);
            }
            Bundle arguments10 = getArguments();
            if (arguments10 != null) {
                arguments10.putInt(ChangeTemplateConstants.ARG_TEMPLATE_NEXT_PAGE_HEIGHT, intExtra6);
            }
            Bundle arguments11 = getArguments();
            if (arguments11 != null) {
                arguments11.putInt("template_type", intExtra7);
            }
            Bundle arguments12 = getArguments();
            if (arguments12 != null) {
                arguments12.putString(ChangeTemplateConstants.ARG_TEMPLATE_NAME, stringExtra);
            }
        }
    }

    private final void showSingleModePageToApplyDialog(Context context, final BaseTemplateStyleFragment.PageToApplyCallback pageToApplyCallback) {
        PageToApplySingleModeDialog pageToApplySingleModeDialog = new PageToApplySingleModeDialog(context);
        pageToApplySingleModeDialog.setCallback(new BaseTemplateStyleFragment.PageToApplyCallback() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.PageTemplateStyleFragment.showSingleModePageToApplyDialog.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.common.BaseTemplateStyleFragment.PageToApplyCallback
            public void onResult(Intent data) {
                Intrinsics.checkNotNullParameter(data, "data");
                pageToApplyCallback.onResult(data);
            }
        });
        pageToApplySingleModeDialog.show();
    }

    private final void showTwoPageModePageToApplyDialog(Context context, final BaseTemplateStyleFragment.PageToApplyCallback pageToApplyCallback) {
        PageToApplyTwoPageModeDialog pageToApplyTwoPageModeDialog = new PageToApplyTwoPageModeDialog(context);
        pageToApplyTwoPageModeDialog.setCallback(new BaseTemplateStyleFragment.PageToApplyCallback() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.PageTemplateStyleFragment.showTwoPageModePageToApplyDialog.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.common.BaseTemplateStyleFragment.PageToApplyCallback
            public void onResult(Intent data) {
                Intrinsics.checkNotNullParameter(data, "data");
                pageToApplyCallback.onResult(data);
            }
        });
        pageToApplyTwoPageModeDialog.show();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.common.BaseTemplateStyleFragment
    @NotNull
    public BaseTemplatePresenter createPresenter(@Nullable Bundle savedInstanceState) {
        PageTemplateStylePresenter pageTemplateStylePresenter = new PageTemplateStylePresenter(getContext(), this);
        setupIntentTemplateInfo();
        if (savedInstanceState != null) {
            pageTemplateStylePresenter.initialize(savedInstanceState);
            return pageTemplateStylePresenter;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            arguments.putBoolean(ChangeTemplateConstants.ARG_TEMPLATE_HAS_SELECTED_TEMPLATE, false);
        }
        pageTemplateStylePresenter.initialize(getArguments());
        return pageTemplateStylePresenter;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.common.BaseTemplateStyleFragment
    @NotNull
    public View createView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNull(container);
        initCommonTemplateStyleLayout(container);
        CommonTemplateStyleLayout mCommonTemplateStyleLayout = getMCommonTemplateStyleLayout();
        Intrinsics.checkNotNull(mCommonTemplateStyleLayout);
        return mCommonTemplateStyleLayout;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.common.BaseTemplateStyleFragment
    @NotNull
    public CommonTemplateStyleLayout getLayout(@NotNull View parentView) {
        Intrinsics.checkNotNullParameter(parentView, "parentView");
        Context context = parentView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        return new CommonTemplateStyleLayout(context);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.presenter.BaseTemplatePresenter.Contract
    @NotNull
    public DocumentPageRatio.PageRatioType getPageRatioType() {
        DocumentPageRatio.PageRatioType pageRatioType;
        BaseTemplatePresenter mPresenter = getMPresenter();
        PageTemplateStylePresenter pageTemplateStylePresenter = mPresenter instanceof PageTemplateStylePresenter ? (PageTemplateStylePresenter) mPresenter : null;
        return (pageTemplateStylePresenter == null || (pageRatioType = pageTemplateStylePresenter.getPageRatioType()) == null) ? DocumentPageRatio.PageRatioType.A4_PORTRAIT : pageRatioType;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.common.BaseTemplateStyleFragment
    @NotNull
    public String getTAG() {
        return TAG;
    }

    public final boolean hasSelectedTemplate() {
        if (getMPresenter() == null) {
            return false;
        }
        BaseTemplatePresenter mPresenter = getMPresenter();
        Intrinsics.checkNotNull(mPresenter, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.presenter.PageTemplateStylePresenter");
        return ((PageTemplateStylePresenter) mPresenter).hasSelectedTemplate();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.common.BaseTemplateStyleFragment
    public boolean isAdditionalDialogRequired() {
        SelectedTemplateData selectedTemplateData;
        SelectedTemplateData selectedTemplateData2;
        if (!isSingleModeDialogRequired() && !isTwoPageModeDialogRequired()) {
            return false;
        }
        BaseTemplatePresenter mPresenter = getMPresenter();
        Integer numValueOf = (mPresenter == null || (selectedTemplateData2 = mPresenter.getSelectedTemplateData()) == null) ? null : Integer.valueOf(selectedTemplateData2.getSelectedTemplateType());
        Intrinsics.checkNotNull(numValueOf);
        if (TemplateViewType.isPdfType(numValueOf.intValue())) {
            return false;
        }
        BaseTemplatePresenter mPresenter2 = getMPresenter();
        Integer numValueOf2 = (mPresenter2 == null || (selectedTemplateData = mPresenter2.getSelectedTemplateData()) == null) ? null : Integer.valueOf(selectedTemplateData.getSelectedTemplateType());
        Intrinsics.checkNotNull(numValueOf2);
        if (numValueOf2.intValue() == -1) {
            return false;
        }
        BaseTemplatePresenter mPresenter3 = getMPresenter();
        ViewStateData viewStateData = mPresenter3 != null ? mPresenter3.getViewStateData() : null;
        Intrinsics.checkNotNull(viewStateData);
        return !viewStateData.getIsSingleMode();
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        Logger.m10999d(TAG, "onOptionsItemSelected# " + item.getItemId());
        if (item.getItemId() != C9086R.id.home) {
            return false;
        }
        BaseTemplatePresenter mPresenter = getMPresenter();
        Intrinsics.checkNotNull(mPresenter);
        mPresenter.onCancel();
        return false;
    }

    @NotNull
    public final PageTemplateStyleFragment setContract(@Nullable BaseTemplateStyleFragment.Contract contract) {
        setMContract(contract);
        return this;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.common.BaseTemplateStyleFragment
    public void showAdditionalDialog(@NotNull Context context, @NotNull BaseTemplateStyleFragment.PageToApplyCallback pageToApplyCallback) {
        SelectedTemplateData selectedTemplateData;
        SelectedTemplateData selectedTemplateData2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pageToApplyCallback, "pageToApplyCallback");
        BaseTemplatePresenter mPresenter = getMPresenter();
        Integer numValueOf = null;
        String selectedTemplate = (mPresenter == null || (selectedTemplateData2 = mPresenter.getSelectedTemplateData()) == null) ? null : selectedTemplateData2.getSelectedTemplate();
        BaseTemplatePresenter mPresenter2 = getMPresenter();
        if (mPresenter2 != null && (selectedTemplateData = mPresenter2.getSelectedTemplateData()) != null) {
            numValueOf = Integer.valueOf(selectedTemplateData.getItemType());
        }
        if (selectedTemplate == null || numValueOf == null) {
            Logger.m11000e(TAG, "showAdditionalDialog: selected item is null");
        } else if (isSingleModeDialogRequired()) {
            showSingleModePageToApplyDialog(context, pageToApplyCallback);
        } else {
            showTwoPageModePageToApplyDialog(context, pageToApplyCallback);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.common.BaseTemplateStyleFragment
    public void updateAdditionalDialogResultIntent(@NotNull Intent resultIntent, int pageToApply) {
        Intrinsics.checkNotNullParameter(resultIntent, "resultIntent");
        if (pageToApply == 1) {
            resultIntent.putExtra(ChangeTemplateConstants.ARG_TEMPLATE_APPLY_TO_ALL, false);
            resultIntent.putExtra(ChangeTemplateConstants.ARG_TEMPLATE_PAGE_TO_CHANGE, 1);
            return;
        }
        if (pageToApply == 2) {
            resultIntent.putExtra(ChangeTemplateConstants.ARG_TEMPLATE_APPLY_TO_ALL, false);
            resultIntent.putExtra(ChangeTemplateConstants.ARG_TEMPLATE_PAGE_TO_CHANGE, 2);
            return;
        }
        if (pageToApply == 3) {
            resultIntent.putExtra(ChangeTemplateConstants.ARG_TEMPLATE_APPLY_TO_ALL, false);
            resultIntent.putExtra(ChangeTemplateConstants.ARG_TEMPLATE_PAGE_TO_CHANGE, 3);
        } else if (pageToApply == 4) {
            resultIntent.putExtra(ChangeTemplateConstants.ARG_TEMPLATE_APPLY_TO_ALL, false);
            resultIntent.putExtra(ChangeTemplateConstants.ARG_TEMPLATE_PAGE_TO_CHANGE, 0);
        } else {
            if (pageToApply != 5) {
                return;
            }
            resultIntent.putExtra(ChangeTemplateConstants.ARG_TEMPLATE_APPLY_TO_ALL, true);
        }
    }
}
