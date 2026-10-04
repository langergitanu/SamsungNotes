package com.samsung.android.support.senl.p148nt.app.settings.detail.style.widget;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.collection.AbstractC0622a;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.data.TemplateItem;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.constants.ChangeTemplateConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.common.Constant;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.data.select.SelectedTemplateData;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.util.TemplateIndexConverter;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.BaseTemplatePresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.ChangeTemplatesPresenter;
import com.samsung.android.support.senl.p148nt.model.base.document.DocumentPageRatio;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p047K3.ViewOnLayoutChangeListenerC0162a;
import p095X2.SharedPreferencesOnSharedPreferenceChangeListenerC0340a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 :2\u00020\u0001:\u00029:B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\nJ\b\u0010\u0014\u001a\u00020\u000eH\u0016J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0016\u001a\u00020\u000eH\u0016J\b\u0010\u0017\u001a\u00020\u000eH\u0016J\"\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u000e\u0010!\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\"\u001a\u00020#H\u0016J\u0018\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020'H\u0002J\u0010\u0010)\u001a\u00020#2\u0006\u0010\u0019\u001a\u00020\u0007H\u0016J\u0010\u0010*\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\u0007H\u0016J\b\u0010,\u001a\u00020-H\u0016J\n\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00100\u001a\u00020\u0007H\u0016J\u000e\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u0007J\u0006\u00103\u001a\u00020\u000eJ\b\u00104\u001a\u00020\u000eH\u0016J\n\u00105\u001a\u0004\u0018\u000106H\u0016J\u000e\u00107\u001a\u00020#2\u0006\u0010&\u001a\u000208R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006;"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/detail/style/widget/DefaultTemplateStylePresenter;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/template/view/presenter/BaseTemplatePresenter;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mLayoutWidth", "", "mMultiWindowMode", "mContract", "Lcom/samsung/android/support/senl/nt/app/settings/detail/style/widget/DefaultTemplateStylePresenter$Contract;", "mSharedPreferenceChangeListener", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "resetPageLayoutStyle", "", "initialize", "bundle", "Landroid/os/Bundle;", "setContract", "contract", "release", "onResume", "onSelectedTemplateChanged", "resetPageThumbnail", "initTemplateThumbnail", "templateType", "templateInfo", "", "pageRatio", "", "defaultArguments", "getDefaultArguments", "()Landroid/os/Bundle;", "updateItemsPageRatio", "onCancel", "", "onSelectItem", "itemType", "item", "Lcom/samsung/android/support/senl/nt/base/common/data/TemplateItem;", "onSelectImageItem", "onItemLongPressed", "onItemClicked", "itemCount", "getPageRatioType", "Lcom/samsung/android/support/senl/nt/model/base/document/DocumentPageRatio$PageRatioType;", "getFragment", "Landroidx/fragment/app/Fragment;", "getSelectedTemplateCategory", "getLayoutHeight", "templateMode", "onConfigurationChanged", "updatePagerHeight", "getCaller", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/common/Constant$Type;", "onOptionsItemSelected", "Landroid/view/MenuItem;", "Contract", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DefaultTemplateStylePresenter extends BaseTemplatePresenter {

    @NotNull
    private static final String TAG = "DefaultTemplateStylePresenter";

    @Nullable
    private Contract mContract;
    private int mLayoutWidth;
    private int mMultiWindowMode;

    @NotNull
    private final SharedPreferences.OnSharedPreferenceChangeListener mSharedPreferenceChangeListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/detail/style/widget/DefaultTemplateStylePresenter$Contract;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/template/view/presenter/BaseTemplatePresenter$Contract;", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Contract extends BaseTemplatePresenter.Contract {
    }

    public DefaultTemplateStylePresenter(@Nullable Context context) {
        super(context);
        this.mSharedPreferenceChangeListener = new SharedPreferencesOnSharedPreferenceChangeListenerC0340a(this, 5);
        initialize(getDefaultArguments());
    }

    private final Bundle getDefaultArguments() {
        Bundle bundle = new Bundle();
        bundle.putInt(ChangeTemplateConstants.ARG_PAGE_TEMPLATE_CALLER, 0);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mSharedPreferenceChangeListener$lambda$0(DefaultTemplateStylePresenter defaultTemplateStylePresenter, SharedPreferences sharedPreferences, String str) {
        if (Intrinsics.areEqual(SettingsConstants.SETTINGS_PAGE_SIZE, str)) {
            defaultTemplateStylePresenter.updateItemsPageRatio(DocumentPageRatio.getPageRatioTypeFromSettings().getPageRatio());
            return;
        }
        if (Intrinsics.areEqual(SettingsConstants.SETTINGS_PREFERRED_NOTE_STYLE, str)) {
            defaultTemplateStylePresenter.resetPageLayoutStyle();
        } else if (Intrinsics.areEqual(SettingsConstants.SETTINGS_PAGE_TEMPLATE, str)) {
            SelectedTemplateData selectedTemplateData = new SelectedTemplateData(true);
            defaultTemplateStylePresenter.mSelectedTemplateData = selectedTemplateData;
            defaultTemplateStylePresenter.mPresenter.setSelectedTemplateData(selectedTemplateData);
            defaultTemplateStylePresenter.mPresenter.loadItemData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onResume$lambda$1(DefaultTemplateStylePresenter defaultTemplateStylePresenter, View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
        if (view.getWidth() <= 0 || view.getHeight() <= 0) {
            return;
        }
        defaultTemplateStylePresenter.updatePagerHeight();
    }

    private final void onSelectImageItem(TemplateItem item) {
        this.mPresenter.setSelectedTemplateData(item.getType(), String.valueOf(TemplateIndexConverter.convertTemplateNameToWPageIndex(item.getName())));
        this.mPresenter.loadItemData();
    }

    private final void resetPageLayoutStyle() {
        SharedPreferencesCompat.Companion companion = SharedPreferencesCompat.INSTANCE;
        int i = companion.getInstance("Settings").getInt(SettingsConstants.SETTINGS_PAGE_SIZE, 0);
        int i2 = companion.getInstance("Settings").getInt(SettingsConstants.SETTINGS_PREFERRED_NOTE_STYLE, 1);
        if (i == 0 || i2 != 0) {
            return;
        }
        companion.getInstance("Settings").putInt(SettingsConstants.SETTINGS_PAGE_SIZE, 0);
        companion.getInstance("Settings").putInt(SettingsConstants.SETTINGS_TEMPLATE_TYPE, 10);
        companion.getInstance("Settings").putString(SettingsConstants.SETTINGS_PAGE_TEMPLATE, "0");
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.BaseTemplatePresenter
    @Nullable
    public Constant.Type getCaller() {
        Contract contract = this.mContract;
        Intrinsics.checkNotNull(contract);
        return contract.getCaller();
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

    public final int getLayoutHeight(int templateMode) {
        return getTabViewLayoutHeight(templateMode);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.presenter.ChangeTemplatesContract.View
    @NotNull
    public DocumentPageRatio.PageRatioType getPageRatioType() {
        DocumentPageRatio.PageRatioType pageRatioTypeFromSettings = DocumentPageRatio.getPageRatioTypeFromSettings();
        Intrinsics.checkNotNullExpressionValue(pageRatioTypeFromSettings, "getPageRatioTypeFromSettings(...)");
        return pageRatioTypeFromSettings;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.BaseTemplatePresenter
    public int getSelectedTemplateCategory() {
        return SharedPreferencesCompat.INSTANCE.getInstance("Settings").getInt(SettingsConstants.SETTINGS_TEMPLATE_CATEGORY, 0);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.BaseTemplatePresenter
    public void initTemplateThumbnail(int templateType, @Nullable String templateInfo, float pageRatio) {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.BaseTemplatePresenter
    public void initialize(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        MainLogger.m7254d(TAG, "initialize# ");
        TemplateIndexConverter.clearWPageIndexMap();
        this.mViewStateData.initialize(bundle);
        this.mSelectedTemplateData = new SelectedTemplateData(true);
        WindowManagerCompat companion = WindowManagerCompat.INSTANCE.getInstance();
        Fragment fragment = getFragment();
        this.mMultiWindowMode = companion.getMultiWindowMode(fragment != null ? fragment.getActivity() : null);
        SharedPreferencesCompat.INSTANCE.getInstance("Settings").registerOnSharedPreferenceChangeListener(this.mSharedPreferenceChangeListener);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.BaseTemplatePresenter
    public boolean onCancel() {
        ChangeTemplatesPresenter changeTemplatesPresenter = this.mPresenter;
        if (changeTemplatesPresenter == null) {
            return false;
        }
        return changeTemplatesPresenter.onBackPressed();
    }

    public final void onConfigurationChanged() {
        Fragment fragment = getFragment();
        if (fragment != null) {
            int multiWindowMode = WindowManagerCompat.INSTANCE.getInstance().getMultiWindowMode(fragment.getActivity());
            int i = this.mMultiWindowMode;
            if (i != multiWindowMode) {
                MainLogger.m7258i(TAG, AbstractC0622a.m1164j(multiWindowMode, i, "onConfigurationChanged - getMultiWindowMode(", ") preMultiWindowMode(", ")"));
                scrollToPosition();
                this.mMultiWindowMode = multiWindowMode;
            }
            updatePagerHeight();
        }
        Contract contract = this.mContract;
        if (contract != null) {
            contract.calculateTabWidth();
        }
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

    public final boolean onOptionsItemSelected(@NotNull MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        Logger.m10999d(TAG, "onOptionsItemSelected# " + item.getItemId());
        if (item.getItemId() != 16908332) {
            return false;
        }
        onCancel();
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.BaseTemplatePresenter
    public void onResume(@NotNull Bundle bundle) {
        FragmentActivity fragmentActivityRequireActivity;
        Window window;
        View decorView;
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        super.onResume(getDefaultArguments());
        updatePagerHeight();
        Fragment fragment = getFragment();
        if (fragment != null && (fragmentActivityRequireActivity = fragment.requireActivity()) != null && (window = fragmentActivityRequireActivity.getWindow()) != null && (decorView = window.getDecorView()) != null) {
            decorView.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC0162a(this, 4));
        }
        Contract contract = this.mContract;
        if (contract != null) {
            contract.calculateTabWidth();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.presenter.ChangeTemplatesContract.View
    public void onSelectItem(int itemType, @NotNull TemplateItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (itemType == 0) {
            onSelectImageItem(item);
        } else if (itemType == 1 || item.getType() == 3) {
            onSelectPdfItem(item.getType(), item.getPath(), item.getWidth(), item.getHeight());
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.BaseTemplatePresenter
    public void onSelectedTemplateChanged() {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.BaseTemplatePresenter
    public void release() {
        SharedPreferencesCompat.INSTANCE.getInstance("Settings").unregisterOnSharedPreferenceChangeListener(this.mSharedPreferenceChangeListener);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.BaseTemplatePresenter
    public void resetPageThumbnail() {
    }

    public final void setContract(@Nullable Contract contract) {
        this.mContract = contract;
    }

    public final void updateItemsPageRatio(float pageRatio) {
        this.mPresenter.updateItemsPageRatio(this.mContext, pageRatio);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.BaseTemplatePresenter
    public void updatePagerHeight() {
        Contract contract = this.mContract;
        if (contract != null) {
            Intrinsics.checkNotNull(contract);
            contract.updatePagerHeight();
        }
    }
}
