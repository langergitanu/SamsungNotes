package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.samsung.android.support.senl.p148nt.base.common.constants.TemplateViewType;
import com.samsung.android.support.senl.p148nt.base.common.data.TemplateItem;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CTLogger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.constants.ChangeTemplateConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.common.Constant;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.data.select.SelectedTemplateData;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.util.TemplateIndexConverter;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.BaseTemplatePresenter;
import com.samsung.android.support.senl.p148nt.model.base.document.DocumentPageRatio;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PageTemplateStylePresenter extends BaseTemplatePresenter {
    private static final String TAG = CTLogger.createTag("ChangeTemplateView");
    private static boolean mHasSelectedTemplate = false;
    private final Contract mContract;
    private SelectedTemplateData mCurrentPageTemplateData;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract extends BaseTemplatePresenter.Contract {
    }

    public PageTemplateStylePresenter(Context context, Contract contract) {
        super(context);
        this.mContract = contract;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.BaseTemplatePresenter
    public Constant.Type getCaller() {
        return this.mContract.getCaller();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.BaseTemplatePresenter, com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.presenter.ChangeTemplatesContract.View
    public Fragment getFragment() {
        return this.mContract.getMFragment();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.presenter.ChangeTemplatesContract.View
    public DocumentPageRatio.PageRatioType getPageRatioType() {
        return DocumentPageRatio.getPageRatioTypeFromRatio(this.mViewStateData.getPageRatio());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.BaseTemplatePresenter
    public int getSelectedTemplateCategory() {
        int selectedTemplateType = this.mSelectedTemplateData.getSelectedTemplateType();
        if (selectedTemplateType == 3 || selectedTemplateType == 5) {
            return 5;
        }
        if (selectedTemplateType == 10 || selectedTemplateType == 11) {
            return 0;
        }
        if (selectedTemplateType == 13 || selectedTemplateType == 14) {
            return 1;
        }
        if (selectedTemplateType == 16 || selectedTemplateType == 17) {
            return 2;
        }
        if (selectedTemplateType == 19 || selectedTemplateType == 20) {
            return 3;
        }
        return (selectedTemplateType == 22 || selectedTemplateType == 23) ? 4 : 0;
    }

    public boolean hasSelectedTemplate() {
        SelectedTemplateData selectedTemplateData = this.mSelectedTemplateData;
        if (selectedTemplateData == null || this.mCurrentPageTemplateData == null) {
            return false;
        }
        return (selectedTemplateData.getSelectedTemplateType() == this.mCurrentPageTemplateData.getSelectedTemplateType() && this.mSelectedTemplateData.getSelectedTemplate().equals(this.mCurrentPageTemplateData.getSelectedTemplate())) ? false : true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.BaseTemplatePresenter
    public void initTemplateThumbnail(int i, String str, float f) {
        this.mContract.initTemplateThumbnail(i, str, f);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.BaseTemplatePresenter
    public void initialize(Bundle bundle) {
        String str = TAG;
        Logger.m10999d(str, "initialize# bundle");
        this.mViewStateData.initialize(bundle);
        this.mCurrentPageTemplateData = new SelectedTemplateData(bundle);
        this.mSelectedTemplateData = new SelectedTemplateData(bundle);
        mHasSelectedTemplate = bundle.getBoolean(ChangeTemplateConstants.ARG_TEMPLATE_HAS_SELECTED_TEMPLATE);
        int i = bundle.getInt(ChangeTemplateConstants.ARG_PAGE_TEMPLATE_CALLER);
        if (mHasSelectedTemplate) {
            SelectedTemplateData selectedTemplateData = this.mSelectedTemplateData;
            selectedTemplateData.setSelectedTemplateData(selectedTemplateData.getSelectedTemplateType(), this.mSelectedTemplateData.getSelectedTemplate());
        } else if (i == 2) {
            this.mSelectedTemplateData.setDefaultTemplateData();
        } else {
            this.mSelectedTemplateData.setNoTemplateData();
            this.mContract.initTemplateThumbnail(this.mCurrentPageTemplateData.getSelectedTemplateType(), this.mCurrentPageTemplateData.getSelectedTemplate(), this.mViewStateData.getPageRatio());
        }
        if (TemplateViewType.isCustomPdfType(this.mCurrentPageTemplateData.getSelectedTemplateType()) && this.mCurrentPageTemplateData.getSelectedTemplate() == null) {
            Logger.m10999d(str, "initialize# Custom pdf deleted");
            this.mCurrentPageTemplateData.setDefaultTemplateData();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.BaseTemplatePresenter
    public boolean onCancel() {
        return true;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.presenter.ChangeTemplatesContract.View
    public void onItemClicked(int i) {
        this.mContract.onItemClicked(i);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.presenter.ChangeTemplatesContract.View
    public boolean onItemLongPressed(int i) {
        if (i != 3 && i != 5) {
            return false;
        }
        this.mContract.onItemLongPressed();
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.BaseTemplatePresenter
    public void onResume(Bundle bundle) {
        super.onResume(bundle);
        updatePagerHeight();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.BaseTemplatePresenter
    public void onSaveInstanceState(Bundle bundle) {
        if (!mHasSelectedTemplate) {
            bundle.putInt("template_type", this.mCurrentPageTemplateData.getSelectedTemplateType());
            bundle.putString(ChangeTemplateConstants.ARG_TEMPLATE_NAME, this.mCurrentPageTemplateData.getSelectedTemplate());
        } else {
            bundle.putInt("template_type", this.mSelectedTemplateData.getSelectedTemplateType());
            bundle.putString(ChangeTemplateConstants.ARG_TEMPLATE_NAME, this.mSelectedTemplateData.getSelectedTemplate());
            bundle.putBoolean(ChangeTemplateConstants.ARG_TEMPLATE_HAS_SELECTED_TEMPLATE, mHasSelectedTemplate);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.presenter.ChangeTemplatesContract.View
    public void onSelectItem(int i, TemplateItem templateItem) {
        if (!mHasSelectedTemplate) {
            mHasSelectedTemplate = true;
        }
        if (i == 0) {
            this.mPresenter.setSelectedTemplateData(templateItem.getType(), String.valueOf(TemplateIndexConverter.convertTemplateNameToWPageIndex(templateItem.getName())));
        } else if (i == 1 || templateItem.getType() == 3) {
            onSelectPdfItem(templateItem.getType(), templateItem.getPath(), templateItem.getWidth(), templateItem.getHeight());
        }
        this.mPresenter.loadItemData();
        onSelectedTemplateChanged();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.BaseTemplatePresenter
    public void onSelectedTemplateChanged() {
        this.mContract.onSelectedTemplateChanged();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.BaseTemplatePresenter
    public void resetPageThumbnail() {
        initTemplateThumbnail(this.mCurrentPageTemplateData.getSelectedTemplateType(), this.mCurrentPageTemplateData.getSelectedTemplate(), this.mViewStateData.getPageRatio());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.BaseTemplatePresenter
    public void updatePagerHeight() {
        Contract contract = this.mContract;
        if (contract != null) {
            contract.updatePagerHeight();
        }
    }
}
