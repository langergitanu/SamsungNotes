package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.common;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.base.common.constants.TemplateViewType;
import com.samsung.android.support.senl.p148nt.base.common.data.TemplateItem;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.C8886c;
import com.samsung.android.support.senl.p148nt.base.winset.app.dialog.ITemplateEditDialogResult;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.constants.ChangeTemplateConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog.TemplateNameDialog;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.common.Constant;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.adapter.TemplatePagerAdapter;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.data.select.SelectedTemplateData;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.data.state.ViewStateData;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.util.TemplateConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.PageTemplateStyleFragment;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.common.CommonTemplateStyleLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.BaseTemplatePresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.ImageTemplatePresenterUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.PageTemplateStylePresenter;
import com.samsung.android.support.senl.p148nt.model.base.document.DocumentPageRatio;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p047K3.ViewOnLayoutChangeListenerC0162a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u0004\u0083\u0001\u0084\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u00107\u001a\u0002082\u0006\u00109\u001a\u00020*J\u0012\u0010:\u001a\u0002082\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J&\u0010=\u001a\u0004\u0018\u00010>2\u0006\u0010?\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010B2\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\u001a\u0010C\u001a\u0002082\u0006\u0010D\u001a\u00020>2\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\u0012\u0010E\u001a\u0002082\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\u0010\u0010F\u001a\u0002082\u0006\u0010G\u001a\u00020<H\u0016J\b\u0010H\u001a\u000208H\u0016J\b\u0010I\u001a\u000208H\u0016J\u0010\u0010J\u001a\u0002082\u0006\u0010K\u001a\u00020LH\u0016J\"\u0010M\u001a\u0002082\u0006\u0010N\u001a\u00020\u00122\u0006\u0010O\u001a\u00020\u00122\b\u0010P\u001a\u0004\u0018\u00010QH\u0016J-\u0010R\u001a\u0002082\u0006\u0010N\u001a\u00020\u00122\u000e\u0010S\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010U0T2\u0006\u0010V\u001a\u00020WH\u0016¢\u0006\u0002\u0010XJ\b\u0010Y\u001a\u000208H\u0016J\b\u0010Z\u001a\u00020[H\u0016J\u0010\u0010\\\u001a\u0002082\u0006\u0010]\u001a\u00020\u0012H\u0016J\u0010\u0010^\u001a\u0002082\u0006\u0010_\u001a\u00020>H\u0004J\u0006\u0010`\u001a\u000208J\u000e\u0010a\u001a\u0002082\u0006\u0010b\u001a\u00020[J\u0006\u0010c\u001a\u00020[J\b\u0010d\u001a\u00020eH\u0016J\b\u0010f\u001a\u000208H\u0004J\u0010\u0010g\u001a\u0002082\u0006\u0010b\u001a\u00020[H\u0004J\u0010\u0010h\u001a\u00020[2\u0006\u0010i\u001a\u00020QH\u0016J\b\u0010j\u001a\u00020[H\u0016J\u0010\u0010k\u001a\u0002082\u0006\u0010i\u001a\u00020QH\u0004J\u0010\u0010l\u001a\u0002082\u0006\u0010i\u001a\u00020QH\u0004J\r\u0010m\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0014J\b\u0010n\u001a\u0004\u0018\u00010UJ\"\u0010o\u001a\u0002082\u0006\u0010p\u001a\u00020\u00122\b\u0010q\u001a\u0004\u0018\u00010U2\u0006\u0010r\u001a\u00020sH\u0016J\b\u0010t\u001a\u000208H\u0016J\b\u0010u\u001a\u000208H\u0016J\u0012\u0010v\u001a\u00020\u00062\b\u0010;\u001a\u0004\u0018\u00010<H$J$\u0010w\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010B2\b\u0010;\u001a\u0004\u0018\u00010<H$J\b\u0010x\u001a\u00020UH$J\u0010\u0010y\u001a\u00020\f2\u0006\u0010_\u001a\u00020>H$J\b\u0010z\u001a\u00020[H&J\u0018\u0010{\u001a\u0002082\u0006\u0010|\u001a\u00020}2\u0006\u0010~\u001a\u00020\u007fH&J\u001a\u0010\u0080\u0001\u001a\u0002082\u0006\u0010i\u001a\u00020Q2\u0007\u0010\u0081\u0001\u001a\u00020\u0012H&J\t\u0010\u0082\u0001\u001a\u00020\u0001H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0084\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u0012X\u0084\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\u001a\u0010\u001b\u001a\u00020\u0012X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\u0004\u0018\u00010\u0012X\u0084\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0014\u0010/\u001a\u000200X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0016\u00103\u001a\u0004\u0018\u0001048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b5\u00106¨\u0006\u0085\u0001"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/template/view/common/BaseTemplateStyleFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/template/view/presenter/BaseTemplatePresenter$Contract;", "<init>", "()V", "mPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/template/view/presenter/BaseTemplatePresenter;", "getMPresenter", "()Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/template/view/presenter/BaseTemplatePresenter;", "setMPresenter", "(Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/template/view/presenter/BaseTemplatePresenter;)V", "mCommonTemplateStyleLayout", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/template/view/common/CommonTemplateStyleLayout;", "getMCommonTemplateStyleLayout", "()Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/template/view/common/CommonTemplateStyleLayout;", "setMCommonTemplateStyleLayout", "(Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/template/view/common/CommonTemplateStyleLayout;)V", "mCurrentPage", "", "getMCurrentPage", "()Ljava/lang/Integer;", "setMCurrentPage", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "mOriginStyle", "getMOriginStyle", "setMOriginStyle", "mLayoutWidth", "getMLayoutWidth", "()I", "setMLayoutWidth", "(I)V", "mMultiWindowMode", "getMMultiWindowMode", "setMMultiWindowMode", "mOnBackPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "getMOnBackPressedCallback", "()Landroidx/activity/OnBackPressedCallback;", "setMOnBackPressedCallback", "(Landroidx/activity/OnBackPressedCallback;)V", "mContract", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/template/view/common/BaseTemplateStyleFragment$Contract;", "getMContract", "()Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/template/view/common/BaseTemplateStyleFragment$Contract;", "setMContract", "(Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/template/view/common/BaseTemplateStyleFragment$Contract;)V", "mITemplateEditDialogResult", "Lcom/samsung/android/support/senl/nt/base/winset/app/dialog/ITemplateEditDialogResult;", "getMITemplateEditDialogResult", "()Lcom/samsung/android/support/senl/nt/base/winset/app/dialog/ITemplateEditDialogResult;", "renameItem", "Lcom/samsung/android/support/senl/nt/base/common/data/TemplateItem;", "getRenameItem", "()Lcom/samsung/android/support/senl/nt/base/common/data/TemplateItem;", "setContract", "", "contract", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onViewStateRestored", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "outState", "onResume", "onDestroy", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "updatePagerHeight", "onItemLongPressed", "", "onItemClicked", "itemCount", "initCommonTemplateStyleLayout", "parentView", "setBackPressedCallback", "updateBackPressedCallBack", "isEnabled", "onBackPressed", "getCaller", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/common/Constant$Type;", "showRenameDialog", "enableConfirmBtn", "updateResultIntent", "resultIntent", "isTemplateChanged", "makeIntentForImageTemplate", "makeIntentForPdfTemplate", "getSelectedTemplateType", "getSelectedTemplate", "initTemplateThumbnail", "templateType", "templateInfo", "pageRatio", "", "onSelectedTemplateChanged", "calculateTabWidth", "createPresenter", "createView", "getTAG", "getLayout", "isAdditionalDialogRequired", "showAdditionalDialog", "context", "Landroid/content/Context;", "pageToApplyCallback", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/template/view/common/BaseTemplateStyleFragment$PageToApplyCallback;", "updateAdditionalDialogResultIntent", "pageToApply", "getFragment", "Contract", "PageToApplyCallback", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class BaseTemplateStyleFragment extends Fragment implements BaseTemplatePresenter.Contract {

    @Nullable
    private CommonTemplateStyleLayout mCommonTemplateStyleLayout;

    @Nullable
    private Contract mContract;

    @Nullable
    private Integer mCurrentPage;

    @NotNull
    private final ITemplateEditDialogResult mITemplateEditDialogResult = new ITemplateEditDialogResult() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.common.BaseTemplateStyleFragment$mITemplateEditDialogResult$1
        @Override // com.samsung.android.support.senl.p148nt.base.winset.app.dialog.ITemplateEditDialogResult
        public void onEditDialogDismiss(String deletePath) {
            CommonTemplateStyleLayout mCommonTemplateStyleLayout = this.this$0.getMCommonTemplateStyleLayout();
            if (mCommonTemplateStyleLayout != null) {
                mCommonTemplateStyleLayout.releaseEditMode();
            }
        }

        @Override // com.samsung.android.support.senl.p148nt.base.winset.app.dialog.ITemplateEditDialogResult
        public void onEditDialogResult(String newName) {
            BaseTemplatePresenter mPresenter = this.this$0.getMPresenter();
            if (mPresenter != null) {
                mPresenter.onEditDialogResult(newName);
            }
        }
    };
    private int mLayoutWidth;

    @Nullable
    private Integer mMultiWindowMode;

    @Nullable
    private OnBackPressedCallback mOnBackPressedCallback;

    @Nullable
    private Integer mOriginStyle;

    @Nullable
    private BaseTemplatePresenter mPresenter;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u000fH&¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/template/view/common/BaseTemplateStyleFragment$Contract;", "", "onSelectedTemplateChanged", "", "pageRatioType", "Lcom/samsung/android/support/senl/nt/model/base/document/DocumentPageRatio$PageRatioType;", "templatePath", "", "templateRes", "", "(Lcom/samsung/android/support/senl/nt/model/base/document/DocumentPageRatio$PageRatioType;Ljava/lang/String;Ljava/lang/Integer;)V", "enableConfirmBtn", "isEnabled", "", "getCaller", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/common/Constant$Type;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Contract {
        void enableConfirmBtn(boolean isEnabled);

        @NotNull
        Constant.Type getCaller();

        void onSelectedTemplateChanged(@NotNull DocumentPageRatio.PageRatioType pageRatioType, @Nullable String templatePath, @Nullable Integer templateRes);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/template/view/common/BaseTemplateStyleFragment$PageToApplyCallback;", "", "onResult", "", "data", "Landroid/content/Intent;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface PageToApplyCallback {
        void onResult(@NotNull Intent data);
    }

    private final TemplateItem getRenameItem() {
        BaseTemplatePresenter baseTemplatePresenter = this.mPresenter;
        if (baseTemplatePresenter != null) {
            return baseTemplatePresenter.getRenameItem();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initCommonTemplateStyleLayout$lambda$1(BaseTemplateStyleFragment baseTemplateStyleFragment, int i) {
        baseTemplateStyleFragment.mCurrentPage = Integer.valueOf(i);
        CommonTemplateStyleLayout commonTemplateStyleLayout = baseTemplateStyleFragment.mCommonTemplateStyleLayout;
        if (commonTemplateStyleLayout != null) {
            commonTemplateStyleLayout.updatePagerHeight();
        }
        CommonTemplateStyleLayout commonTemplateStyleLayout2 = baseTemplateStyleFragment.mCommonTemplateStyleLayout;
        if (commonTemplateStyleLayout2 != null) {
            commonTemplateStyleLayout2.releaseEditMode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onResume$lambda$0(BaseTemplateStyleFragment baseTemplateStyleFragment, View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
        if (view.getWidth() <= 0 || view.getHeight() <= 0 || baseTemplateStyleFragment.mLayoutWidth == view.getWidth()) {
            return;
        }
        baseTemplateStyleFragment.mLayoutWidth = view.getWidth();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.presenter.BaseTemplatePresenter.Contract
    public void calculateTabWidth() {
        CommonTemplateStyleLayout commonTemplateStyleLayout = this.mCommonTemplateStyleLayout;
        if (commonTemplateStyleLayout != null) {
            commonTemplateStyleLayout.calculateTabWidth();
        }
    }

    @NotNull
    public abstract BaseTemplatePresenter createPresenter(@Nullable Bundle savedInstanceState);

    @NotNull
    public abstract View createView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);

    public final void enableConfirmBtn(boolean isEnabled) {
        Contract contract = this.mContract;
        if (contract != null) {
            contract.enableConfirmBtn(isEnabled);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.presenter.BaseTemplatePresenter.Contract
    @NotNull
    public Constant.Type getCaller() {
        Contract contract = this.mContract;
        Constant.Type caller = contract != null ? contract.getCaller() : null;
        Intrinsics.checkNotNull(caller);
        return caller;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.presenter.BaseTemplatePresenter.Contract
    @NotNull
    public Fragment getFragment() {
        return this;
    }

    @NotNull
    public abstract CommonTemplateStyleLayout getLayout(@NotNull View parentView);

    @Nullable
    public final CommonTemplateStyleLayout getMCommonTemplateStyleLayout() {
        return this.mCommonTemplateStyleLayout;
    }

    @Nullable
    public final Contract getMContract() {
        return this.mContract;
    }

    @Nullable
    public final Integer getMCurrentPage() {
        return this.mCurrentPage;
    }

    @NotNull
    public final ITemplateEditDialogResult getMITemplateEditDialogResult() {
        return this.mITemplateEditDialogResult;
    }

    public final int getMLayoutWidth() {
        return this.mLayoutWidth;
    }

    @Nullable
    public final Integer getMMultiWindowMode() {
        return this.mMultiWindowMode;
    }

    @Nullable
    public final OnBackPressedCallback getMOnBackPressedCallback() {
        return this.mOnBackPressedCallback;
    }

    @Nullable
    public final Integer getMOriginStyle() {
        return this.mOriginStyle;
    }

    @Nullable
    public final BaseTemplatePresenter getMPresenter() {
        return this.mPresenter;
    }

    @Nullable
    public final String getSelectedTemplate() {
        SelectedTemplateData selectedTemplateData;
        BaseTemplatePresenter baseTemplatePresenter = this.mPresenter;
        if (baseTemplatePresenter == null || (selectedTemplateData = baseTemplatePresenter.getSelectedTemplateData()) == null) {
            return null;
        }
        return selectedTemplateData.getSelectedTemplate();
    }

    @Nullable
    public final Integer getSelectedTemplateType() {
        SelectedTemplateData selectedTemplateData;
        BaseTemplatePresenter baseTemplatePresenter = this.mPresenter;
        if (baseTemplatePresenter == null || (selectedTemplateData = baseTemplatePresenter.getSelectedTemplateData()) == null) {
            return null;
        }
        return Integer.valueOf(selectedTemplateData.getSelectedTemplateType());
    }

    @NotNull
    public abstract String getTAG();

    public final void initCommonTemplateStyleLayout(@NotNull View parentView) {
        Intrinsics.checkNotNullParameter(parentView, "parentView");
        TemplatePagerAdapter templatePagerAdapter = new TemplatePagerAdapter(getContext(), this.mPresenter);
        CommonTemplateStyleLayout layout = getLayout(parentView);
        this.mCommonTemplateStyleLayout = layout;
        if (layout != null) {
            layout.setAdapter(templatePagerAdapter);
        }
        CommonTemplateStyleLayout commonTemplateStyleLayout = this.mCommonTemplateStyleLayout;
        if (commonTemplateStyleLayout != null) {
            commonTemplateStyleLayout.setContract(new CommonTemplateStyleLayout.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.common.BaseTemplateStyleFragment.initCommonTemplateStyleLayout.1
                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.common.CommonTemplateStyleLayout.Contract
                public void enableConfirmBtn(boolean isEnabled) {
                    BaseTemplateStyleFragment.this.enableConfirmBtn(isEnabled);
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.common.CommonTemplateStyleLayout.Contract
                public Constant.Type getCaller() {
                    return BaseTemplateStyleFragment.this.getCaller();
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.common.CommonTemplateStyleLayout.Contract
                public int getDefaultCurrentPage() {
                    BaseTemplatePresenter mPresenter = BaseTemplateStyleFragment.this.getMPresenter();
                    if (mPresenter != null) {
                        return mPresenter.getSelectedTemplateCategory();
                    }
                    return 0;
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.common.CommonTemplateStyleLayout.Contract
                public int getItemCount() {
                    BaseTemplatePresenter mPresenter = BaseTemplateStyleFragment.this.getMPresenter();
                    if (mPresenter != null) {
                        return mPresenter.getItemCount();
                    }
                    return 0;
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.common.CommonTemplateStyleLayout.Contract
                public int getPagerHeight(int pageIndex) {
                    BaseTemplatePresenter mPresenter = BaseTemplateStyleFragment.this.getMPresenter();
                    if (mPresenter != null) {
                        return mPresenter.getTabViewLayoutHeight(pageIndex);
                    }
                    return 0;
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.common.CommonTemplateStyleLayout.Contract
                public int getSelectedItemCount() {
                    BaseTemplatePresenter mPresenter = BaseTemplateStyleFragment.this.getMPresenter();
                    if (mPresenter != null) {
                        return mPresenter.getSelectedItemCount();
                    }
                    return 0;
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.common.CommonTemplateStyleLayout.Contract
                public void onChangeMode() {
                    BaseTemplatePresenter mPresenter = BaseTemplateStyleFragment.this.getMPresenter();
                    if (mPresenter != null) {
                        mPresenter.onChangeMode();
                    }
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.common.CommonTemplateStyleLayout.Contract
                public void requestDeleteSelectedTemplate() {
                    BaseTemplatePresenter mPresenter = BaseTemplateStyleFragment.this.getMPresenter();
                    if (mPresenter != null) {
                        mPresenter.onClickDelete(true);
                    }
                    CommonTemplateStyleLayout mCommonTemplateStyleLayout = BaseTemplateStyleFragment.this.getMCommonTemplateStyleLayout();
                    Intrinsics.checkNotNull(mCommonTemplateStyleLayout);
                    mCommonTemplateStyleLayout.releaseEditMode();
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.common.CommonTemplateStyleLayout.Contract
                public int requestSelectAllItems(boolean isSelected) {
                    BaseTemplatePresenter mPresenter = BaseTemplateStyleFragment.this.getMPresenter();
                    if (mPresenter != null) {
                        return mPresenter.requestSelectAllItems(isSelected);
                    }
                    return 0;
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.common.CommonTemplateStyleLayout.Contract
                public void requestSetEnableCallBack(boolean isEnabled) {
                    BaseTemplateStyleFragment.this.updateBackPressedCallBack(isEnabled);
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.common.CommonTemplateStyleLayout.Contract
                public void requestShowRenameDialog() {
                    BaseTemplateStyleFragment.this.showRenameDialog();
                }
            });
        }
        CommonTemplateStyleLayout commonTemplateStyleLayout2 = this.mCommonTemplateStyleLayout;
        if (commonTemplateStyleLayout2 != null) {
            commonTemplateStyleLayout2.setCallback(new C8886c(this, 11));
        }
        CommonTemplateStyleLayout commonTemplateStyleLayout3 = this.mCommonTemplateStyleLayout;
        if (commonTemplateStyleLayout3 != null) {
            commonTemplateStyleLayout3.initPage();
        }
        this.mCurrentPage = 0;
        setBackPressedCallback();
        updateBackPressedCallBack(false);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.presenter.BaseTemplatePresenter.Contract
    public void initTemplateThumbnail(int templateType, @Nullable String templateInfo, float pageRatio) {
        if (templateInfo == null) {
            return;
        }
        DocumentPageRatio.PageRatioType pageRatioTypeFromRatio = DocumentPageRatio.getPageRatioTypeFromRatio(pageRatio);
        int resourceId = -1;
        if (TemplateViewType.isDefaultImageType(templateType)) {
            int i = Integer.parseInt(templateInfo);
            if (i > 12 && i <= 15) {
                i--;
            }
            resourceId = ImageTemplatePresenterUtil.getItemResourceArray(pageRatio).getResourceId(i, -1);
            templateInfo = "";
        } else if (!TemplateViewType.isCustomImageType(templateType)) {
            templateInfo = AbstractC0541b.m756B(StringsKt.m14154b0(templateInfo, Extension.DOT), ".jpg");
        }
        Contract contract = this.mContract;
        if (contract != null) {
            Intrinsics.checkNotNull(pageRatioTypeFromRatio);
            contract.onSelectedTemplateChanged(pageRatioTypeFromRatio, templateInfo, Integer.valueOf(resourceId));
        }
    }

    public abstract boolean isAdditionalDialogRequired();

    public boolean isTemplateChanged() {
        SelectedTemplateData selectedTemplateData;
        BaseTemplatePresenter baseTemplatePresenter = this.mPresenter;
        return !Intrinsics.areEqual(this.mOriginStyle, (baseTemplatePresenter == null || (selectedTemplateData = baseTemplatePresenter.getSelectedTemplateData()) == null) ? null : Integer.valueOf(selectedTemplateData.getSelectedTemplateType()));
    }

    public final void makeIntentForImageTemplate(@NotNull Intent resultIntent) {
        ViewStateData viewStateData;
        ViewStateData viewStateData2;
        SelectedTemplateData selectedTemplateData;
        String selectedTemplate;
        SelectedTemplateData selectedTemplateData2;
        Intrinsics.checkNotNullParameter(resultIntent, "resultIntent");
        BaseTemplatePresenter baseTemplatePresenter = this.mPresenter;
        Float fValueOf = null;
        resultIntent.putExtra("template_type", (baseTemplatePresenter == null || (selectedTemplateData2 = baseTemplatePresenter.getSelectedTemplateData()) == null) ? null : Integer.valueOf(selectedTemplateData2.getSelectedTemplateType()));
        BaseTemplatePresenter baseTemplatePresenter2 = this.mPresenter;
        resultIntent.putExtra(ChangeTemplateConstants.ARG_TEMPLATE_DEFAULT_IMAGE_RESULT, (baseTemplatePresenter2 == null || (selectedTemplateData = baseTemplatePresenter2.getSelectedTemplateData()) == null || (selectedTemplate = selectedTemplateData.getSelectedTemplate()) == null) ? null : Integer.valueOf(Integer.parseInt(selectedTemplate)));
        BaseTemplatePresenter baseTemplatePresenter3 = this.mPresenter;
        resultIntent.putExtra(ChangeTemplateConstants.ARG_TEMPLATE_PAGE_INDEX, (baseTemplatePresenter3 == null || (viewStateData2 = baseTemplatePresenter3.getViewStateData()) == null) ? null : Integer.valueOf(viewStateData2.getPageIndex()));
        BaseTemplatePresenter baseTemplatePresenter4 = this.mPresenter;
        if (baseTemplatePresenter4 != null && (viewStateData = baseTemplatePresenter4.getViewStateData()) != null) {
            fValueOf = Float.valueOf(viewStateData.getPageRatio());
        }
        resultIntent.putExtra(ChangeTemplateConstants.ARG_TEMPLATE_NOTE_PAGE_RATIO, fValueOf);
    }

    public final void makeIntentForPdfTemplate(@NotNull Intent resultIntent) {
        SelectedTemplateData selectedTemplateData;
        ViewStateData viewStateData;
        ViewStateData viewStateData2;
        SelectedTemplateData selectedTemplateData2;
        SelectedTemplateData selectedTemplateData3;
        Intrinsics.checkNotNullParameter(resultIntent, "resultIntent");
        BaseTemplatePresenter baseTemplatePresenter = this.mPresenter;
        Float fValueOf = null;
        Integer numValueOf = (baseTemplatePresenter == null || (selectedTemplateData3 = baseTemplatePresenter.getSelectedTemplateData()) == null) ? null : Integer.valueOf(selectedTemplateData3.getSelectedTemplateType());
        Intrinsics.checkNotNull(numValueOf);
        int iIntValue = numValueOf.intValue();
        resultIntent.putExtra("template_type", iIntValue);
        if (TemplateViewType.isCustomImageType(iIntValue)) {
            BaseTemplatePresenter baseTemplatePresenter2 = this.mPresenter;
            resultIntent.putExtra(ChangeTemplateConstants.ARG_TEMPLATE_IMAGE_RESULT, (baseTemplatePresenter2 == null || (selectedTemplateData2 = baseTemplatePresenter2.getSelectedTemplateData()) == null) ? null : selectedTemplateData2.getSelectedTemplate());
            BaseTemplatePresenter baseTemplatePresenter3 = this.mPresenter;
            Intrinsics.checkNotNull(resultIntent.putExtra(ChangeTemplateConstants.ARG_TEMPLATE_IMAGE_RATIO, (baseTemplatePresenter3 == null || (viewStateData2 = baseTemplatePresenter3.getViewStateData()) == null) ? null : Float.valueOf(viewStateData2.getPageRatio())));
        } else if (TemplateViewType.isPdfType(iIntValue)) {
            BaseTemplatePresenter baseTemplatePresenter4 = this.mPresenter;
            resultIntent.putExtra(ChangeTemplateConstants.ARG_TEMPLATE_PDF_RESULT, (baseTemplatePresenter4 == null || (selectedTemplateData = baseTemplatePresenter4.getSelectedTemplateData()) == null) ? null : selectedTemplateData.getSelectedTemplate());
            resultIntent.putExtra(ChangeTemplateConstants.ARG_TEMPLATE_APPLY_TO_ALL, false);
            Intrinsics.checkNotNull(resultIntent.putExtra(ChangeTemplateConstants.ARG_TEMPLATE_PAGE_TO_CHANGE, 0));
        } else {
            Logger.m11000e(PageTemplateStyleFragment.TAG, "unexpected case, templateType: " + iIntValue);
        }
        BaseTemplatePresenter baseTemplatePresenter5 = this.mPresenter;
        if (baseTemplatePresenter5 != null && (viewStateData = baseTemplatePresenter5.getViewStateData()) != null) {
            fValueOf = Float.valueOf(viewStateData.getPageRatio());
        }
        resultIntent.putExtra(ChangeTemplateConstants.ARG_TEMPLATE_NOTE_PAGE_RATIO, fValueOf);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getArguments() == null) {
            Logger.m11000e(getTAG(), "onActivityCreated - bundle is null");
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        if (savedInstanceState != null) {
            this.mCurrentPage = Integer.valueOf(savedInstanceState.getInt(TemplateConstants.KEY_CURRENT_PAGE, 0));
        }
        BaseTemplatePresenter baseTemplatePresenter = this.mPresenter;
        if (baseTemplatePresenter != null) {
            baseTemplatePresenter.onAttachView();
        }
        this.mMultiWindowMode = Integer.valueOf(WindowManagerCompat.INSTANCE.getInstance().getMultiWindowMode(getActivity()));
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        BaseTemplatePresenter baseTemplatePresenter = this.mPresenter;
        if (baseTemplatePresenter != null) {
            baseTemplatePresenter.handleActivityResult(requestCode, resultCode, data, true);
        }
    }

    public final boolean onBackPressed() {
        CommonTemplateStyleLayout commonTemplateStyleLayout = this.mCommonTemplateStyleLayout;
        if (commonTemplateStyleLayout == null || !commonTemplateStyleLayout.isEditMode()) {
            BaseTemplatePresenter baseTemplatePresenter = this.mPresenter;
            return baseTemplatePresenter != null && baseTemplatePresenter.onBackPressed();
        }
        CommonTemplateStyleLayout commonTemplateStyleLayout2 = this.mCommonTemplateStyleLayout;
        if (commonTemplateStyleLayout2 != null) {
            commonTemplateStyleLayout2.releaseEditMode();
        }
        return true;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        Logger.m10999d(getTAG(), "onConfigurationChanged#");
        super.onConfigurationChanged(newConfig);
        CommonTemplateStyleLayout commonTemplateStyleLayout = this.mCommonTemplateStyleLayout;
        if (commonTemplateStyleLayout != null) {
            commonTemplateStyleLayout.calculateTabWidth();
        }
        int multiWindowMode = WindowManagerCompat.INSTANCE.getInstance().getMultiWindowMode(getActivity());
        Integer num = this.mMultiWindowMode;
        if (num == null || num.intValue() != multiWindowMode) {
            Logger.m11003i(getTAG(), "onConfigurationChanged - getMultiWindowMode(" + multiWindowMode + ") preMultiWindowMode(" + this.mMultiWindowMode + ")");
            BaseTemplatePresenter baseTemplatePresenter = this.mPresenter;
            if (baseTemplatePresenter != null) {
                baseTemplatePresenter.scrollToPosition();
            }
            this.mMultiWindowMode = Integer.valueOf(multiWindowMode);
        }
        updatePagerHeight();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        SelectedTemplateData selectedTemplateData;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Integer numValueOf = null;
        if (container == null) {
            Logger.m11000e(getTAG(), "onCreateView - container is null");
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
            return null;
        }
        BaseTemplatePresenter baseTemplatePresenterCreatePresenter = createPresenter(savedInstanceState);
        this.mPresenter = baseTemplatePresenterCreatePresenter;
        if (baseTemplatePresenterCreatePresenter != null && (selectedTemplateData = baseTemplatePresenterCreatePresenter.getSelectedTemplateData()) != null) {
            numValueOf = Integer.valueOf(selectedTemplateData.getSelectedTemplateType());
        }
        this.mOriginStyle = numValueOf;
        return createView(inflater, container, savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        BaseTemplatePresenter baseTemplatePresenter = this.mPresenter;
        if (baseTemplatePresenter != null) {
            baseTemplatePresenter.release();
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

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int requestCode, @NotNull String[] permissions, @NotNull int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        BaseTemplatePresenter baseTemplatePresenter = this.mPresenter;
        if (baseTemplatePresenter != null) {
            baseTemplatePresenter.handlePermissionRequestResult(requestCode, permissions, grantResults, getPageRatioType());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        Window window;
        View decorView;
        Logger.m10999d(getTAG(), "onResume#");
        super.onResume();
        BaseTemplatePresenter baseTemplatePresenter = this.mPresenter;
        if (baseTemplatePresenter != null) {
            baseTemplatePresenter.onAttachView();
        }
        BaseTemplatePresenter baseTemplatePresenter2 = this.mPresenter;
        if (baseTemplatePresenter2 != null) {
            baseTemplatePresenter2.onResume(getArguments());
        }
        FragmentActivity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null && (decorView = window.getDecorView()) != null) {
            decorView.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC0162a(this, 6));
        }
        updatePagerHeight();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle outState) {
        SelectedTemplateData selectedTemplateData;
        SelectedTemplateData selectedTemplateData2;
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        Integer num = this.mCurrentPage;
        Intrinsics.checkNotNull(num);
        outState.putInt(TemplateConstants.KEY_CURRENT_PAGE, num.intValue());
        BaseTemplatePresenter baseTemplatePresenter = this.mPresenter;
        String selectedTemplate = null;
        Integer numValueOf = (baseTemplatePresenter == null || (selectedTemplateData2 = baseTemplatePresenter.getSelectedTemplateData()) == null) ? null : Integer.valueOf(selectedTemplateData2.getSelectedTemplateType());
        Intrinsics.checkNotNull(numValueOf);
        outState.putInt("template_type", numValueOf.intValue());
        BaseTemplatePresenter baseTemplatePresenter2 = this.mPresenter;
        if (baseTemplatePresenter2 != null && (selectedTemplateData = baseTemplatePresenter2.getSelectedTemplateData()) != null) {
            selectedTemplate = selectedTemplateData.getSelectedTemplate();
        }
        outState.putString(ChangeTemplateConstants.ARG_TEMPLATE_NAME, selectedTemplate);
        BaseTemplatePresenter baseTemplatePresenter3 = this.mPresenter;
        if (baseTemplatePresenter3 instanceof PageTemplateStylePresenter) {
            Intrinsics.checkNotNull(baseTemplatePresenter3, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.presenter.PageTemplateStylePresenter");
            ((PageTemplateStylePresenter) baseTemplatePresenter3).onSaveInstanceState(outState);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.presenter.BaseTemplatePresenter.Contract
    public void onSelectedTemplateChanged() {
        BaseTemplatePresenter baseTemplatePresenter = this.mPresenter;
        SelectedTemplateData selectedTemplateData = baseTemplatePresenter != null ? baseTemplatePresenter.getSelectedTemplateData() : null;
        if (selectedTemplateData == null || selectedTemplateData.getSelectedTemplateType() == -1) {
            Logger.m11000e(getTAG(), "onSelectedTemplateChanged# selectedTemplateData is null");
            return;
        }
        BaseTemplatePresenter baseTemplatePresenter2 = this.mPresenter;
        TemplateItem selectedTemplate = baseTemplatePresenter2 != null ? baseTemplatePresenter2.getSelectedTemplate(selectedTemplateData) : null;
        if (selectedTemplate == null) {
            Logger.m11000e(getTAG(), "onSelectedTemplateChanged# selectedTemplateItem is null");
            return;
        }
        String drawablePath = selectedTemplate.getDrawablePath();
        Integer numValueOf = Integer.valueOf(selectedTemplate.getDrawableResId());
        Contract contract = this.mContract;
        if (contract != null) {
            DocumentPageRatio.PageRatioType pageRatioType = getPageRatioType();
            Intrinsics.checkNotNullExpressionValue(pageRatioType, "getPageRatioType(...)");
            contract.onSelectedTemplateChanged(pageRatioType, drawablePath, numValueOf);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        updatePagerHeight();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        BaseTemplatePresenter baseTemplatePresenter = this.mPresenter;
        if (baseTemplatePresenter != null) {
            baseTemplatePresenter.onRestoreInstanceState(savedInstanceState);
        }
    }

    public final void setBackPressedCallback() {
        Logger.m10999d(getTAG(), "setBackPressedCallback");
        OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.common.BaseTemplateStyleFragment.setBackPressedCallback.1
            {
                super(true);
            }

            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                Logger.m10999d(BaseTemplateStyleFragment.this.getTAG(), "setBackPressedCallback# handleOnBackPressed");
                if (BaseTemplateStyleFragment.this.onBackPressed()) {
                    return;
                }
                setEnabled(false);
                BaseTemplateStyleFragment.this.requireActivity().onBackPressed();
            }
        };
        this.mOnBackPressedCallback = onBackPressedCallback;
        requireActivity().getOnBackPressedDispatcher().addCallback(this, onBackPressedCallback);
    }

    public final void setContract(@NotNull Contract contract) {
        Intrinsics.checkNotNullParameter(contract, "contract");
        this.mContract = contract;
    }

    public final void setMCommonTemplateStyleLayout(@Nullable CommonTemplateStyleLayout commonTemplateStyleLayout) {
        this.mCommonTemplateStyleLayout = commonTemplateStyleLayout;
    }

    public final void setMContract(@Nullable Contract contract) {
        this.mContract = contract;
    }

    public final void setMCurrentPage(@Nullable Integer num) {
        this.mCurrentPage = num;
    }

    public final void setMLayoutWidth(int i) {
        this.mLayoutWidth = i;
    }

    public final void setMMultiWindowMode(@Nullable Integer num) {
        this.mMultiWindowMode = num;
    }

    public final void setMOnBackPressedCallback(@Nullable OnBackPressedCallback onBackPressedCallback) {
        this.mOnBackPressedCallback = onBackPressedCallback;
    }

    public final void setMOriginStyle(@Nullable Integer num) {
        this.mOriginStyle = num;
    }

    public final void setMPresenter(@Nullable BaseTemplatePresenter baseTemplatePresenter) {
        this.mPresenter = baseTemplatePresenter;
    }

    public abstract void showAdditionalDialog(@NotNull Context context, @NotNull PageToApplyCallback pageToApplyCallback);

    public final void showRenameDialog() {
        TemplateItem renameItem = getRenameItem();
        if (renameItem == null) {
            return;
        }
        TemplateNameDialog templateNameDialog = new TemplateNameDialog(getContext(), renameItem.getName(), renameItem.getPath(), true);
        templateNameDialog.setEditDialogResultListener(this.mITemplateEditDialogResult);
        if (getContext() instanceof AppCompatActivity) {
            templateNameDialog.show();
        }
    }

    public abstract void updateAdditionalDialogResultIntent(@NotNull Intent resultIntent, int pageToApply);

    public final void updateBackPressedCallBack(boolean isEnabled) {
        OnBackPressedCallback onBackPressedCallback = this.mOnBackPressedCallback;
        if (onBackPressedCallback != null) {
            onBackPressedCallback.setEnabled(isEnabled);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.presenter.BaseTemplatePresenter.Contract
    public void updatePagerHeight() {
        CommonTemplateStyleLayout commonTemplateStyleLayout = this.mCommonTemplateStyleLayout;
        if (commonTemplateStyleLayout != null) {
            commonTemplateStyleLayout.updatePagerHeight();
        }
    }

    public boolean updateResultIntent(@NotNull Intent resultIntent) {
        SelectedTemplateData selectedTemplateData;
        int selectedTemplateType;
        Intrinsics.checkNotNullParameter(resultIntent, "resultIntent");
        BaseTemplatePresenter baseTemplatePresenter = this.mPresenter;
        if (baseTemplatePresenter == null || (selectedTemplateData = baseTemplatePresenter.getSelectedTemplateData()) == null || (selectedTemplateType = selectedTemplateData.getSelectedTemplateType()) == -1) {
            return false;
        }
        if (TemplateViewType.isDefaultImageType(selectedTemplateType)) {
            makeIntentForImageTemplate(resultIntent);
            return true;
        }
        makeIntentForPdfTemplate(resultIntent);
        return true;
    }
}
