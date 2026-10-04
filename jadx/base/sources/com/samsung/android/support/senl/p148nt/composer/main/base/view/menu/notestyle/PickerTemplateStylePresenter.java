package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.samsung.android.support.senl.p148nt.base.common.data.TemplateItem;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.constants.ChangeTemplateConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.common.Constant;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.data.select.SelectedTemplateData;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.util.TemplateIndexConverter;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.BaseTemplatePresenter;
import com.samsung.android.support.senl.p148nt.model.base.document.DocumentPageRatio;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 .2\u00020\u0001:\u0002-.B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0015\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\u001a\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0010H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0010H\u0016J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u0010H\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u000bH\u0016J\n\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010!\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\"\u001a\u00020\u000bH\u0016J\b\u0010#\u001a\u00020\u000bH\u0016J\"\u0010$\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00102\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(H\u0016J\n\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010+\u001a\u00020\u0018H\u0016J\b\u0010,\u001a\u00020\u000bH\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/PickerTemplateStylePresenter;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/template/view/presenter/BaseTemplatePresenter;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "contract", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/PickerTemplateStylePresenter$Contract;", "(Landroid/content/Context;Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/PickerTemplateStylePresenter$Contract;)V", "mContract", "initialize", "", "bundle", "Landroid/os/Bundle;", "updateItemsPageRatio", "pageSizeType", "", "(Ljava/lang/Integer;)V", "onSelectItem", "itemType", "item", "Lcom/samsung/android/support/senl/nt/base/common/data/TemplateItem;", "getSelectedTemplateCategory", "onItemLongPressed", "", "templateType", "onItemClicked", "itemCount", "getPageRatioType", "Lcom/samsung/android/support/senl/nt/model/base/document/DocumentPageRatio$PageRatioType;", "updatePagerHeight", "getCaller", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/common/Constant$Type;", "onResume", "onSelectedTemplateChanged", "resetPageThumbnail", "initTemplateThumbnail", "templateInfo", "", "pageRatio", "", "getFragment", "Landroidx/fragment/app/Fragment;", "onCancel", "onAllItemUpdated", "Contract", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PickerTemplateStylePresenter extends BaseTemplatePresenter {

    @NotNull
    public static final String TAG = "PickerTemplateStylePresenter";

    @Nullable
    private Contract mContract;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/PickerTemplateStylePresenter$Contract;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/template/view/presenter/BaseTemplatePresenter$Contract;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Contract extends BaseTemplatePresenter.Contract {
    }

    public PickerTemplateStylePresenter(@Nullable Context context) {
        super(context);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.BaseTemplatePresenter
    @Nullable
    public Constant.Type getCaller() {
        Contract contract = this.mContract;
        if (contract != null) {
            return contract.getCaller();
        }
        return null;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.BaseTemplatePresenter, com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.presenter.ChangeTemplatesContract.View
    @Nullable
    public Fragment getFragment() {
        Contract contract = this.mContract;
        if (contract != null) {
            return contract.getMFragment();
        }
        return null;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.presenter.ChangeTemplatesContract.View
    @NotNull
    public DocumentPageRatio.PageRatioType getPageRatioType() {
        Contract contract = this.mContract;
        Intrinsics.checkNotNull(contract);
        DocumentPageRatio.PageRatioType pageRatioType = contract.getPageRatioType();
        Intrinsics.checkNotNullExpressionValue(pageRatioType, "getPageRatioType(...)");
        return pageRatioType;
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

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.BaseTemplatePresenter
    public void initTemplateThumbnail(int templateType, @Nullable String templateInfo, float pageRatio) {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.BaseTemplatePresenter
    public void initialize(@Nullable Bundle bundle) {
        Logger.m10999d(TAG, "initialize# bundle");
        if (bundle != null) {
            this.mViewStateData.initialize(bundle);
            this.mSelectedTemplateData = new SelectedTemplateData(bundle);
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putInt(ChangeTemplateConstants.ARG_PAGE_TEMPLATE_CALLER, 3);
            this.mViewStateData.initialize(bundle2);
            this.mSelectedTemplateData = new SelectedTemplateData(false);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.BaseTemplatePresenter, com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.presenter.ChangeTemplatesContract.View
    public void onAllItemUpdated() {
        super.onAllItemUpdated();
        onSelectedTemplateChanged();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.BaseTemplatePresenter
    public boolean onCancel() {
        return true;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.presenter.ChangeTemplatesContract.View
    public void onItemClicked(int itemCount) {
        Contract contract = this.mContract;
        if (contract != null) {
            contract.onItemClicked(itemCount);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.presenter.ChangeTemplatesContract.View
    public boolean onItemLongPressed(int templateType) {
        Contract contract;
        if ((templateType != 3 && templateType != 5) || (contract = this.mContract) == null) {
            return false;
        }
        contract.onItemLongPressed();
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.BaseTemplatePresenter
    public void onResume(@Nullable Bundle bundle) {
        super.onResume(bundle);
        updatePagerHeight();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.presenter.ChangeTemplatesContract.View
    public void onSelectItem(int itemType, @Nullable TemplateItem item) {
        if (item == null) {
            Logger.m11000e(TAG, "onSelectItem: selected item is null");
            return;
        }
        if (itemType == 0) {
            this.mPresenter.setSelectedTemplateData(item.getType(), String.valueOf(TemplateIndexConverter.convertTemplateNameToWPageIndex(item.getName())));
        } else if (itemType == 1 || item.getType() == 3) {
            onSelectPdfItem(item.getType(), item.getPath(), item.getWidth(), item.getHeight());
        }
        this.mPresenter.loadItemData();
        onSelectedTemplateChanged();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.BaseTemplatePresenter
    public void onSelectedTemplateChanged() {
        Contract contract = this.mContract;
        if (contract != null) {
            contract.onSelectedTemplateChanged();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.BaseTemplatePresenter
    public void resetPageThumbnail() {
    }

    public final void updateItemsPageRatio(@Nullable Integer pageSizeType) {
        Intrinsics.checkNotNull(pageSizeType);
        float pageRatio = DocumentPageRatio.getPageRatioTypeFromPageSizeType(pageSizeType.intValue()).getPageRatio();
        this.mViewStateData.setDefaultPageRatio(pageRatio);
        this.mPresenter.updateItemsPageRatio(this.mContext, pageRatio);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.BaseTemplatePresenter
    public void updatePagerHeight() {
        Contract contract = this.mContract;
        if (contract == null || contract == null) {
            return;
        }
        contract.updatePagerHeight();
    }

    public PickerTemplateStylePresenter(@Nullable Context context, @Nullable Contract contract) {
        this(context);
        this.mContract = contract;
    }
}
