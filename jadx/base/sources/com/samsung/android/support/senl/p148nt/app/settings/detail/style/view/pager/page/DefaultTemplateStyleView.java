package com.samsung.android.support.senl.p148nt.app.settings.detail.style.view.pager.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.sem.widget.NestedScrollViewCustom;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.settings.detail.style.view.pager.page.StyleOfNewNotesPage;
import com.samsung.android.support.senl.p148nt.app.settings.detail.style.widget.DefaultTemplateStylePresenter;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.data.TemplateItem;
import com.samsung.android.support.senl.p148nt.base.winset.app.dialog.ITemplateEditDialogResult;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog.TemplateNameDialog;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.common.Constant;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.adapter.TemplatePagerAdapter;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.util.p158sa.SAManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.common.CommonTemplateStyleLayout;
import com.samsung.android.support.senl.p148nt.model.base.document.DocumentPageRatio;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 B2\u00020\u00012\u00020\u0002:\u0001BB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u001c\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0010H\u0016J\b\u0010\u001b\u001a\u00020\u0010H\u0016J\b\u0010\u001c\u001a\u00020\u0010H\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\nH\u0016J\"\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u00192\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u0010H\u0016J\n\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010'\u001a\u00020\u0010H\u0016J\b\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\u0010H\u0016J\u0010\u0010+\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u0014H\u0016J\u0012\u0010-\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\"\u0010.\u001a\u00020\u00102\u0006\u0010/\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u00192\b\u00101\u001a\u0004\u0018\u000102H\u0016J\b\u00103\u001a\u00020\u0010H\u0016J+\u00104\u001a\u00020\u00102\u0006\u0010/\u001a\u00020\u00192\f\u00105\u001a\b\u0012\u0004\u0012\u00020!062\u0006\u00107\u001a\u000208H\u0016¢\u0006\u0002\u00109J\u0012\u0010:\u001a\u00020\u00162\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\b\u0010=\u001a\u00020\u0016H\u0016J\b\u0010>\u001a\u00020\u0010H\u0002J\n\u0010?\u001a\u0004\u0018\u00010@H\u0002J\b\u0010A\u001a\u00020!H\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006C"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/detail/style/view/pager/page/DefaultTemplateStyleView;", "Lcom/samsung/android/support/senl/nt/app/settings/detail/style/view/pager/page/StyleOfNewNotesPage;", "Lcom/samsung/android/support/senl/nt/app/settings/detail/style/widget/DefaultTemplateStylePresenter$Contract;", "context", "Landroid/content/Context;", "contract", "Lcom/samsung/android/support/senl/nt/app/settings/detail/style/view/pager/page/StyleOfNewNotesPage$Contract;", "<init>", "(Landroid/content/Context;Lcom/samsung/android/support/senl/nt/app/settings/detail/style/view/pager/page/StyleOfNewNotesPage$Contract;)V", "mFragment", "Landroidx/fragment/app/Fragment;", "mCommonTemplateStyleLayout", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/template/view/common/CommonTemplateStyleLayout;", "mDefaultTemplateStylePresenter", "Lcom/samsung/android/support/senl/nt/app/settings/detail/style/widget/DefaultTemplateStylePresenter;", "inflateLayout", "", "initialize", "fragment", "savedInstanceState", "Landroid/os/Bundle;", "onItemLongPressed", "", "onItemClicked", "itemCount", "", "onConfigurationChanged", "onResume", "updatePagerHeight", "getFragment", "initTemplateThumbnail", "templateType", "templateInfo", "", "pageRatio", "", "onSelectedTemplateChanged", "getPageRatioType", "Lcom/samsung/android/support/senl/nt/model/base/document/DocumentPageRatio$PageRatioType;", "calculateTabWidth", "getCaller", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/common/Constant$Type;", "onDestroy", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "outState", "onViewStateRestored", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "updateScrollStyle", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onBackKeyDown", "showRenameDialog", "getRenameItem", "Lcom/samsung/android/support/senl/nt/base/common/data/TemplateItem;", "getTAG", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SuppressLint({"ViewConstructor"})
@SourceDebugExtension({"SMAP\nDefaultTemplateStyleView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DefaultTemplateStyleView.kt\ncom/samsung/android/support/senl/nt/app/settings/detail/style/view/pager/page/DefaultTemplateStyleView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,245:1\n1#2:246\n*E\n"})
public final class DefaultTemplateStyleView extends StyleOfNewNotesPage implements DefaultTemplateStylePresenter.Contract {

    @NotNull
    public static final String TAG = "TemplateStyleLayout";

    @Nullable
    private CommonTemplateStyleLayout mCommonTemplateStyleLayout;

    @Nullable
    private DefaultTemplateStylePresenter mDefaultTemplateStylePresenter;

    @Nullable
    private Fragment mFragment;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultTemplateStyleView(@NotNull Context context, @NotNull StyleOfNewNotesPage.Contract contract) {
        super(context, contract);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(contract, "contract");
    }

    private final TemplateItem getRenameItem() {
        DefaultTemplateStylePresenter defaultTemplateStylePresenter = this.mDefaultTemplateStylePresenter;
        if (defaultTemplateStylePresenter != null) {
            return defaultTemplateStylePresenter.getRenameItem();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showRenameDialog() {
        TemplateItem renameItem = getRenameItem();
        if (renameItem != null) {
            TemplateNameDialog templateNameDialog = new TemplateNameDialog(getContext(), renameItem.getName(), renameItem.getPath(), true);
            templateNameDialog.setEditDialogResultListener(new ITemplateEditDialogResult() { // from class: com.samsung.android.support.senl.nt.app.settings.detail.style.view.pager.page.DefaultTemplateStyleView$showRenameDialog$1$1
                @Override // com.samsung.android.support.senl.p148nt.base.winset.app.dialog.ITemplateEditDialogResult
                public void onEditDialogDismiss(String deletePath) {
                    CommonTemplateStyleLayout commonTemplateStyleLayout = this.this$0.mCommonTemplateStyleLayout;
                    if (commonTemplateStyleLayout != null) {
                        commonTemplateStyleLayout.releaseEditMode();
                    }
                }

                @Override // com.samsung.android.support.senl.p148nt.base.winset.app.dialog.ITemplateEditDialogResult
                public void onEditDialogResult(String newName) {
                    DefaultTemplateStylePresenter defaultTemplateStylePresenter = this.this$0.mDefaultTemplateStylePresenter;
                    if (defaultTemplateStylePresenter != null) {
                        defaultTemplateStylePresenter.onEditDialogResult(newName);
                    }
                }
            });
            if (getContext() instanceof AppCompatActivity) {
                templateNameDialog.show();
            }
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.presenter.BaseTemplatePresenter.Contract
    public void calculateTabWidth() {
        CommonTemplateStyleLayout commonTemplateStyleLayout = this.mCommonTemplateStyleLayout;
        if (commonTemplateStyleLayout != null) {
            commonTemplateStyleLayout.calculateTabWidth();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.presenter.BaseTemplatePresenter.Contract
    @NotNull
    public Constant.Type getCaller() {
        return Constant.Type.SETTINGS;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.presenter.BaseTemplatePresenter.Contract
    @Nullable
    /* JADX INFO: renamed from: getFragment, reason: from getter */
    public Fragment getMFragment() {
        return this.mFragment;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.presenter.BaseTemplatePresenter.Contract
    @Nullable
    public DocumentPageRatio.PageRatioType getPageRatioType() {
        DefaultTemplateStylePresenter defaultTemplateStylePresenter = this.mDefaultTemplateStylePresenter;
        if (defaultTemplateStylePresenter != null) {
            return defaultTemplateStylePresenter.getPageRatioType();
        }
        return null;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.detail.style.view.pager.page.StyleOfNewNotesPage
    @NotNull
    public String getTAG() {
        return "TemplateStyleLayout";
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.detail.style.view.pager.page.StyleOfNewNotesPage
    public void inflateLayout(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        CommonTemplateStyleLayout commonTemplateStyleLayout = new CommonTemplateStyleLayout(context, true);
        this.mCommonTemplateStyleLayout = commonTemplateStyleLayout;
        addView(commonTemplateStyleLayout, -1, -1);
        CommonTemplateStyleLayout commonTemplateStyleLayout2 = this.mCommonTemplateStyleLayout;
        if (commonTemplateStyleLayout2 != null) {
            commonTemplateStyleLayout2.setContract(new CommonTemplateStyleLayout.Contract() { // from class: com.samsung.android.support.senl.nt.app.settings.detail.style.view.pager.page.DefaultTemplateStyleView.inflateLayout.1
                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.common.CommonTemplateStyleLayout.Contract
                public void enableConfirmBtn(boolean isEnabled) {
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.common.CommonTemplateStyleLayout.Contract
                public Constant.Type getCaller() {
                    return Constant.Type.SETTINGS;
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.common.CommonTemplateStyleLayout.Contract
                public int getDefaultCurrentPage() {
                    DefaultTemplateStylePresenter defaultTemplateStylePresenter = DefaultTemplateStyleView.this.mDefaultTemplateStylePresenter;
                    if (defaultTemplateStylePresenter != null) {
                        return defaultTemplateStylePresenter.getSelectedTemplateCategory();
                    }
                    return 0;
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.common.CommonTemplateStyleLayout.Contract
                public int getItemCount() {
                    DefaultTemplateStylePresenter defaultTemplateStylePresenter = DefaultTemplateStyleView.this.mDefaultTemplateStylePresenter;
                    if (defaultTemplateStylePresenter != null) {
                        return defaultTemplateStylePresenter.getItemCount();
                    }
                    return 0;
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.common.CommonTemplateStyleLayout.Contract
                public int getPagerHeight(int pageIndex) {
                    DefaultTemplateStylePresenter defaultTemplateStylePresenter = DefaultTemplateStyleView.this.mDefaultTemplateStylePresenter;
                    if (defaultTemplateStylePresenter != null) {
                        return defaultTemplateStylePresenter.getLayoutHeight(pageIndex);
                    }
                    return 0;
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.common.CommonTemplateStyleLayout.Contract
                public int getSelectedItemCount() {
                    DefaultTemplateStylePresenter defaultTemplateStylePresenter = DefaultTemplateStyleView.this.mDefaultTemplateStylePresenter;
                    if (defaultTemplateStylePresenter != null) {
                        return defaultTemplateStylePresenter.getSelectedItemCount();
                    }
                    return 0;
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.common.CommonTemplateStyleLayout.Contract
                public void onChangeMode() {
                    DefaultTemplateStylePresenter defaultTemplateStylePresenter = DefaultTemplateStyleView.this.mDefaultTemplateStylePresenter;
                    if (defaultTemplateStylePresenter != null) {
                        defaultTemplateStylePresenter.onChangeMode();
                    }
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.common.CommonTemplateStyleLayout.Contract
                public void requestDeleteSelectedTemplate() {
                    DefaultTemplateStylePresenter defaultTemplateStylePresenter = DefaultTemplateStyleView.this.mDefaultTemplateStylePresenter;
                    if (defaultTemplateStylePresenter != null) {
                        defaultTemplateStylePresenter.onClickDelete(false);
                    }
                    CommonTemplateStyleLayout commonTemplateStyleLayout3 = DefaultTemplateStyleView.this.mCommonTemplateStyleLayout;
                    if (commonTemplateStyleLayout3 != null) {
                        commonTemplateStyleLayout3.releaseEditMode();
                    }
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.common.CommonTemplateStyleLayout.Contract
                public int requestSelectAllItems(boolean isSelected) {
                    DefaultTemplateStylePresenter defaultTemplateStylePresenter = DefaultTemplateStyleView.this.mDefaultTemplateStylePresenter;
                    if (defaultTemplateStylePresenter != null) {
                        return defaultTemplateStylePresenter.requestSelectAllItems(isSelected);
                    }
                    return 0;
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.common.CommonTemplateStyleLayout.Contract
                public void requestSetEnableCallBack(boolean isEnabled) {
                    DefaultTemplateStyleView.this.getContract().updateBackPressedCallBack(isEnabled);
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.common.CommonTemplateStyleLayout.Contract
                public void requestShowRenameDialog() {
                    DefaultTemplateStyleView.this.showRenameDialog();
                }
            });
        }
        CommonTemplateStyleLayout commonTemplateStyleLayout3 = this.mCommonTemplateStyleLayout;
        if (commonTemplateStyleLayout3 != null) {
            commonTemplateStyleLayout3.setCallback(new CommonTemplateStyleLayout.Callback() { // from class: com.samsung.android.support.senl.nt.app.settings.detail.style.view.pager.page.DefaultTemplateStyleView.inflateLayout.2
                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.common.CommonTemplateStyleLayout.Callback
                public void onPageChanged(int position) {
                    SharedPreferencesCompat.INSTANCE.getInstance("Settings").putInt(SettingsConstants.SETTINGS_TEMPLATE_CATEGORY, position);
                    CommonTemplateStyleLayout commonTemplateStyleLayout4 = DefaultTemplateStyleView.this.mCommonTemplateStyleLayout;
                    if (commonTemplateStyleLayout4 != null) {
                        commonTemplateStyleLayout4.updatePagerHeight();
                    }
                    CommonTemplateStyleLayout commonTemplateStyleLayout5 = DefaultTemplateStyleView.this.mCommonTemplateStyleLayout;
                    if (commonTemplateStyleLayout5 != null) {
                        commonTemplateStyleLayout5.releaseEditMode();
                    }
                    SAManager.INSTANCE.onSelectTemplateCategory(position);
                }
            });
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.presenter.BaseTemplatePresenter.Contract
    public void initTemplateThumbnail(int templateType, @Nullable String templateInfo, float pageRatio) {
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.detail.style.view.pager.page.StyleOfNewNotesPage
    public void initialize(@Nullable Fragment fragment, @Nullable Bundle savedInstanceState) {
        super.initialize(fragment, savedInstanceState);
        this.mFragment = fragment;
        DefaultTemplateStylePresenter defaultTemplateStylePresenter = new DefaultTemplateStylePresenter(getContext());
        this.mDefaultTemplateStylePresenter = defaultTemplateStylePresenter;
        defaultTemplateStylePresenter.setContract(this);
        DefaultTemplateStylePresenter defaultTemplateStylePresenter2 = this.mDefaultTemplateStylePresenter;
        if (defaultTemplateStylePresenter2 != null) {
            defaultTemplateStylePresenter2.onAttachView();
        }
        CommonTemplateStyleLayout commonTemplateStyleLayout = this.mCommonTemplateStyleLayout;
        if (commonTemplateStyleLayout != null) {
            commonTemplateStyleLayout.setAdapter(new TemplatePagerAdapter(getContext(), this.mDefaultTemplateStylePresenter));
        }
        CommonTemplateStyleLayout commonTemplateStyleLayout2 = this.mCommonTemplateStyleLayout;
        if (commonTemplateStyleLayout2 != null) {
            commonTemplateStyleLayout2.initPage();
        }
        CommonTemplateStyleLayout commonTemplateStyleLayout3 = this.mCommonTemplateStyleLayout;
        if (commonTemplateStyleLayout3 != null) {
            commonTemplateStyleLayout3.calculateTabWidth();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.detail.style.view.pager.page.StyleOfNewNotesPage
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        int i = requestCode == 1113 ? 5 : 3;
        DefaultTemplateStylePresenter defaultTemplateStylePresenter = this.mDefaultTemplateStylePresenter;
        if (defaultTemplateStylePresenter != null) {
            boolean z = false;
            if (defaultTemplateStylePresenter != null && !defaultTemplateStylePresenter.isCanNotApplyPdfTemplate(i)) {
                z = true;
            }
            defaultTemplateStylePresenter.handleActivityResult(requestCode, resultCode, data, z);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.detail.style.view.pager.page.StyleOfNewNotesPage
    public boolean onBackKeyDown() {
        CommonTemplateStyleLayout commonTemplateStyleLayout = this.mCommonTemplateStyleLayout;
        if (commonTemplateStyleLayout == null || !commonTemplateStyleLayout.isEditMode()) {
            DefaultTemplateStylePresenter defaultTemplateStylePresenter = this.mDefaultTemplateStylePresenter;
            return (defaultTemplateStylePresenter == null || defaultTemplateStylePresenter == null || !defaultTemplateStylePresenter.onCancel()) ? false : true;
        }
        CommonTemplateStyleLayout commonTemplateStyleLayout2 = this.mCommonTemplateStyleLayout;
        if (commonTemplateStyleLayout2 != null) {
            commonTemplateStyleLayout2.releaseEditMode();
        }
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.detail.style.view.pager.page.StyleOfNewNotesPage
    public void onConfigurationChanged() {
        MainLogger.m7254d(getTAG(), "onConfigurationChanged#");
        DefaultTemplateStylePresenter defaultTemplateStylePresenter = this.mDefaultTemplateStylePresenter;
        if (defaultTemplateStylePresenter != null) {
            defaultTemplateStylePresenter.onConfigurationChanged();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.detail.style.view.pager.page.StyleOfNewNotesPage
    public void onDestroy() {
        SAManager.INSTANCE.logTemplateDetailSA();
        DefaultTemplateStylePresenter defaultTemplateStylePresenter = this.mDefaultTemplateStylePresenter;
        if (defaultTemplateStylePresenter != null) {
            defaultTemplateStylePresenter.release();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.presenter.BaseTemplatePresenter.Contract
    public void onItemClicked(int itemCount) {
        CommonTemplateStyleLayout commonTemplateStyleLayout = this.mCommonTemplateStyleLayout;
        if (commonTemplateStyleLayout != null) {
            commonTemplateStyleLayout.onItemClicked(itemCount);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.presenter.BaseTemplatePresenter.Contract
    public boolean onItemLongPressed() {
        CommonTemplateStyleLayout commonTemplateStyleLayout = this.mCommonTemplateStyleLayout;
        return commonTemplateStyleLayout != null && commonTemplateStyleLayout.setEditMode();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.detail.style.view.pager.page.StyleOfNewNotesPage
    public boolean onOptionsItemSelected(@Nullable MenuItem item) {
        DefaultTemplateStylePresenter defaultTemplateStylePresenter;
        Boolean boolValueOf = null;
        if (item != null && (defaultTemplateStylePresenter = this.mDefaultTemplateStylePresenter) != null) {
            boolValueOf = Boolean.valueOf(defaultTemplateStylePresenter.onOptionsItemSelected(item));
        }
        Intrinsics.checkNotNull(boolValueOf);
        return boolValueOf.booleanValue();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.detail.style.view.pager.page.StyleOfNewNotesPage
    public void onRequestPermissionsResult(int requestCode, @NotNull String[] permissions, @NotNull int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.detail.style.view.pager.page.StyleOfNewNotesPage
    public void onResume() {
        DefaultTemplateStylePresenter defaultTemplateStylePresenter = this.mDefaultTemplateStylePresenter;
        if (defaultTemplateStylePresenter != null) {
            defaultTemplateStylePresenter.onResume(new Bundle());
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.detail.style.view.pager.page.StyleOfNewNotesPage
    public void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        CommonTemplateStyleLayout commonTemplateStyleLayout = this.mCommonTemplateStyleLayout;
        if (commonTemplateStyleLayout != null) {
            commonTemplateStyleLayout.onSaveInstanceState(outState);
        }
        DefaultTemplateStylePresenter defaultTemplateStylePresenter = this.mDefaultTemplateStylePresenter;
        if (defaultTemplateStylePresenter != null) {
            defaultTemplateStylePresenter.onSaveInstanceState(outState);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.presenter.BaseTemplatePresenter.Contract
    public void onSelectedTemplateChanged() {
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.detail.style.view.pager.page.StyleOfNewNotesPage
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        DefaultTemplateStylePresenter defaultTemplateStylePresenter = this.mDefaultTemplateStylePresenter;
        if (defaultTemplateStylePresenter != null) {
            defaultTemplateStylePresenter.onRestoreInstanceState(savedInstanceState);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.presenter.BaseTemplatePresenter.Contract
    public void updatePagerHeight() {
        CommonTemplateStyleLayout commonTemplateStyleLayout = this.mCommonTemplateStyleLayout;
        if (commonTemplateStyleLayout != null) {
            commonTemplateStyleLayout.updatePagerHeight();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.detail.style.view.pager.page.StyleOfNewNotesPage
    public void updateScrollStyle() {
        updateScrollStyle((NestedScrollViewCustom) findViewById(C8003R.id.comp_template_view_pager_container_scroll_view));
        Object parent = findViewById(C8003R.id.comp_template_view_pager_container_scroll_view).getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        updateViewSpacing((View) parent);
    }
}
