package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.AbstractC0622a;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import com.samsung.android.sdk.pdf.SpenPdfRenderer;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.constants.TemplateViewType;
import com.samsung.android.support.senl.p148nt.base.common.data.TemplateItem;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CTLogger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.SortPageSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.common.Constant;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.adapter.BaseItemAdapter;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.data.select.SelectedTemplateData;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.data.state.ViewStateData;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.util.p158sa.SAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.util.p158sa.SAManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.PageTemplateStyleIntentHandler;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.ChangeTemplatesContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.ChangeTemplatesPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.tab.TemplateTabView;
import com.samsung.android.support.senl.p148nt.model.assist.llm.p166sa.AssistSAConstants;
import com.samsung.android.support.senl.p148nt.model.base.document.DocumentPageRatio;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseTemplatePresenter implements ChangeTemplatesContract.View {
    private static final String TAG = CTLogger.createTag("BaseTemplateView2");
    private BaseItemAdapter mAcademicItemAdapter;
    protected TemplateTabView mAcademicTemplateTabView;
    private BaseItemAdapter mBasicItemAdapter;
    protected TemplateTabView mBasicTemplateTabView;
    protected Context mContext;
    private BaseItemAdapter mCreativeItemAdapter;
    protected TemplateTabView mCreativeTemplateTabView;
    private BaseItemAdapter mCustomItemAdapter;
    protected TemplateTabView mCustomTemplateTabView;
    protected PageTemplateStyleIntentHandler mIntentHandler;
    private BaseItemAdapter mJournalItemAdapter;
    protected TemplateTabView mJournalTemplateTabView;
    private BaseItemAdapter mPlanItemAdapter;
    protected TemplateTabView mPlanTemplateTabView;
    protected ChangeTemplatesPresenter mPresenter;
    protected SelectedTemplateData mSelectedTemplateData;
    private final int DEFAULT_WIDTH = 1080;
    protected ViewStateData mViewStateData = new ViewStateData();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        void calculateTabWidth();

        Constant.Type getCaller();

        Fragment getFragment();

        DocumentPageRatio.PageRatioType getPageRatioType();

        void initTemplateThumbnail(int i, String str, float f);

        void onItemClicked(int i);

        boolean onItemLongPressed();

        void onSelectedTemplateChanged();

        void updatePagerHeight();
    }

    public BaseTemplatePresenter(Context context) {
        this.mContext = context;
        this.mBasicTemplateTabView = new TemplateTabView(context);
        this.mAcademicTemplateTabView = new TemplateTabView(context);
        this.mPlanTemplateTabView = new TemplateTabView(context);
        this.mJournalTemplateTabView = new TemplateTabView(context);
        this.mCreativeTemplateTabView = new TemplateTabView(context);
        this.mCustomTemplateTabView = new TemplateTabView(context);
        initTabNestedScrollView();
    }

    private void initItemAdapter() {
        this.mBasicItemAdapter = new BaseItemAdapter();
        this.mAcademicItemAdapter = new BaseItemAdapter();
        this.mPlanItemAdapter = new BaseItemAdapter();
        this.mJournalItemAdapter = new BaseItemAdapter();
        this.mCreativeItemAdapter = new BaseItemAdapter();
        this.mCustomItemAdapter = new BaseItemAdapter();
    }

    private void initLayout() {
        TemplateTabView.Contract contract = new TemplateTabView.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.presenter.BaseTemplatePresenter.2
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.tab.TemplateTabView.Contract
            public void updatePagerHeight() {
                BaseTemplatePresenter.this.updatePagerHeight();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.tab.TemplateTabView.Contract
            public void updateSpanCount(int i) {
                BaseTemplatePresenter.this.updateSpanCount(i);
            }
        };
        this.mBasicTemplateTabView.initLayout(this.mBasicItemAdapter, contract);
        this.mAcademicTemplateTabView.initLayout(this.mAcademicItemAdapter, contract);
        this.mPlanTemplateTabView.initLayout(this.mPlanItemAdapter, contract);
        this.mJournalTemplateTabView.initLayout(this.mJournalItemAdapter, contract);
        this.mCreativeTemplateTabView.initLayout(this.mCreativeItemAdapter, contract);
        this.mCustomTemplateTabView.initLayout(this.mCustomItemAdapter, contract);
    }

    private void initPresenter() {
        ChangeTemplatesPresenter changeTemplatesPresenter = new ChangeTemplatesPresenter(this.mContext, this.mViewStateData, new ChangeTemplatesPresenter.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.presenter.BaseTemplatePresenter.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.presenter.ChangeTemplatesPresenter.Contract
            public void onSelectedTemplateChanged() {
                BaseTemplatePresenter.this.onSelectedTemplateChanged();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.presenter.ChangeTemplatesPresenter.Contract
            public void resetPageThumbnail() {
                BaseTemplatePresenter.this.resetPageThumbnail();
            }
        });
        this.mPresenter = changeTemplatesPresenter;
        changeTemplatesPresenter.attachView(this);
        this.mPresenter.setBasicItemAdapter(this.mBasicItemAdapter);
        this.mPresenter.setAcademicItemAdapter(this.mAcademicItemAdapter);
        this.mPresenter.setPlanItemAdapter(this.mPlanItemAdapter);
        this.mPresenter.setRecordItemAdapter(this.mJournalItemAdapter);
        this.mPresenter.setCreativeItemAdapter(this.mCreativeItemAdapter);
        this.mPresenter.setCustomItemAdapter(this.mCustomItemAdapter);
        this.mPresenter.setSelectedTemplateData(this.mSelectedTemplateData);
        this.mPresenter.init(this.mContext);
        this.mIntentHandler = new PageTemplateStyleIntentHandler(this.mPresenter);
    }

    private boolean isNotSameRatio(int i, int i2, int i4, int i5) {
        if (i4 == 0) {
            Logger.m11004w(TAG, "isNotSameRatio# pageWidth is 0");
            return false;
        }
        boolean zEqualPageRatio = DocumentPageRatio.equalPageRatio(i, i2, i4, i5);
        boolean z = !zEqualPageRatio;
        if (!zEqualPageRatio) {
            String str = TAG;
            StringBuilder sbM1173s = AbstractC0622a.m1173s(i2, i, "isNotSameRatio# true ", "/", " != ");
            sbM1173s.append(i5);
            sbM1173s.append("/");
            sbM1173s.append(i4);
            Logger.m10999d(str, sbM1173s.toString());
        }
        return z;
    }

    private void logAddImageTemplateSA() {
        Constant.Type caller = getCaller();
        if (caller == Constant.Type.SETTINGS) {
            ComposerSA.insertLog("510", SAConstants.EVENT_SETTINGS_ADD_IMAGE_TEMPLATE);
            return;
        }
        if (caller == Constant.Type.CREATE_NOTE) {
            ComposerSA.insertLog("101", AssistSAConstants.EVENT_FAB_ADD_IMAGE_TEMPLATE);
        } else if (caller == Constant.Type.STYLE_CHANGE) {
            ComposerSA.insertLog("411", SAConstants.EVENT_PAGE_STYLE_ADD_IMAGE_TEMPLATE);
        } else if (caller == Constant.Type.TEMPLATE_PICKER) {
            ComposerSA.insertLog("504", SortPageSAConstants.SORTPAGE_EVENT_ADD_IMAGE_TEMPLATE);
        }
    }

    private void logAddPdfTemplateSA() {
        Constant.Type caller = getCaller();
        if (caller == Constant.Type.SETTINGS) {
            ComposerSA.insertLog("510", SAConstants.EVENT_SETTINGS_ADD_PDF_TEMPLATE);
            return;
        }
        if (caller == Constant.Type.CREATE_NOTE) {
            ComposerSA.insertLog("101", AssistSAConstants.EVENT_FAB_ADD_PDF_TEMPLATE);
        } else if (caller == Constant.Type.STYLE_CHANGE) {
            ComposerSA.insertLog("411", SAConstants.EVENT_PAGE_STYLE_ADD_PDF_TEMPLATE);
        } else if (caller == Constant.Type.TEMPLATE_PICKER) {
            ComposerSA.insertLog("504", "3560");
        }
    }

    private void setSpanCount(GridLayoutManager gridLayoutManager, int i) {
        if (this.mContext == null || gridLayoutManager == null) {
            return;
        }
        gridLayoutManager.setSpanCount(i);
    }

    public boolean canUsePdfTemplate(int i, String str) {
        if (TemplateViewType.isPdfType(i) && TemplateViewType.isCustomType(i) && DocumentPageRatio.getPageRatioTypeFromRatio(this.mViewStateData.getPageRatio()) == DocumentPageRatio.PageRatioType.A4_LANDSCAPE) {
            try {
                ParcelFileDescriptor parcelFileDescriptorOpen = ParcelFileDescriptor.open(new File(str), 268435456);
                try {
                    SpenPdfRenderer spenPdfRenderer = new SpenPdfRenderer(parcelFileDescriptorOpen);
                    int pageCount = spenPdfRenderer.getPageCount();
                    for (int i2 = 0; i2 < pageCount; i2++) {
                        if (spenPdfRenderer.getPageHeight(i2) > spenPdfRenderer.getPageWidth(i2)) {
                            release(parcelFileDescriptorOpen, spenPdfRenderer);
                            return false;
                        }
                    }
                    release(parcelFileDescriptorOpen, spenPdfRenderer);
                } catch (IOException e) {
                    Logger.m11000e(TAG, "canUsePdfTemplate# ParcelFileDescriptor e = " + e);
                    release(parcelFileDescriptorOpen, null);
                    throw new RuntimeException(e);
                }
            } catch (FileNotFoundException e2) {
                Logger.m11000e(TAG, "canUsePdfTemplate# ParcelFileDescriptor e = " + e2);
                release(null, null);
                return false;
            }
        }
        return true;
    }

    public boolean checkToNeedEditImageTemplate(int i, String str, int i2, int i4) {
        if (TemplateViewType.isCustomImageType(i) && i2 != 0) {
            if (this.mViewStateData.getPageWidth() == 0) {
                DocumentPageRatio.PageRatioType pageRatioTypeFromRatio = this.mViewStateData.isNoteStyleMode() ? DocumentPageRatio.getPageRatioTypeFromRatio(this.mViewStateData.getDefaultPageRatio()) : DocumentPageRatio.getPageRatioTypeFromSettings();
                if (!pageRatioTypeFromRatio.equal(i4 / i2)) {
                    this.mPresenter.onOpenTemplateEditor(str, 1080, pageRatioTypeFromRatio.getHeight(1080));
                    return true;
                }
            } else if (isNotSameRatio(i2, i4, this.mViewStateData.getPageWidth(), this.mViewStateData.getPageHeight())) {
                this.mPresenter.onOpenTemplateEditor(str, this.mViewStateData.getPageWidth(), this.mViewStateData.getPageRatioHeight());
                return true;
            }
        }
        return false;
    }

    public abstract Constant.Type getCaller();

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.presenter.ChangeTemplatesContract.View
    public Fragment getFragment() {
        return null;
    }

    public int getItemCount() {
        return this.mPresenter.getItemCount();
    }

    public TemplateItem getRenameItem() {
        return this.mPresenter.getRenameItem();
    }

    public int getSelectedItemCount() {
        return this.mPresenter.getSelectedItemCount();
    }

    public TemplateItem getSelectedTemplate(SelectedTemplateData selectedTemplateData) {
        return this.mPresenter.getSelectedItem(selectedTemplateData);
    }

    public abstract int getSelectedTemplateCategory();

    public SelectedTemplateData getSelectedTemplateData() {
        return this.mSelectedTemplateData;
    }

    @Nullable
    public View getTabView(int i) {
        if (i == 0) {
            return this.mBasicTemplateTabView.getMContainer();
        }
        if (i == 1) {
            return this.mAcademicTemplateTabView.getMContainer();
        }
        if (i == 2) {
            return this.mPlanTemplateTabView.getMContainer();
        }
        if (i == 3) {
            return this.mJournalTemplateTabView.getMContainer();
        }
        if (i == 4) {
            return this.mCreativeTemplateTabView.getMContainer();
        }
        if (i != 5) {
            return null;
        }
        return this.mCustomTemplateTabView.getMContainer();
    }

    public int getTabViewLayoutHeight(int i) {
        return i == 0 ? this.mBasicTemplateTabView.getLayoutHeight() : i == 1 ? this.mAcademicTemplateTabView.getLayoutHeight() : i == 2 ? this.mPlanTemplateTabView.getLayoutHeight() : i == 3 ? this.mJournalTemplateTabView.getLayoutHeight() : i == 4 ? this.mCreativeTemplateTabView.getLayoutHeight() : this.mCustomTemplateTabView.getLayoutHeight();
    }

    public ViewStateData getViewStateData() {
        return this.mViewStateData;
    }

    public void handleActivityResult(int i, int i2, @Nullable Intent intent, boolean z) {
        if (this.mContext == null) {
            return;
        }
        AbstractC8014b.m7222x(AbstractC0622a.m1173s(i, i2, "handleActivityResult# requestCode/resultCode ", "/", "/"), z, TAG);
        this.mIntentHandler.handleActivityResult(this.mContext, i, i2, intent, z);
    }

    public void handlePermissionRequestResult(int i, @NonNull String[] strArr, @NonNull int[] iArr, DocumentPageRatio.PageRatioType pageRatioType) {
        if (PermissionHelper.verifyRequestResult(getFragment().getActivity(), i, iArr, strArr)) {
            if (i == 114) {
                onOpenChooser(3, pageRatioType);
                return;
            }
            if (i == 122) {
                onOpenChooser(5, pageRatioType);
                return;
            }
            Logger.m11000e(TAG, "unexpected requestCode: " + i);
        }
    }

    public void initTabNestedScrollView() {
        this.mBasicTemplateTabView.setEnableNestedScroll(false);
        this.mAcademicTemplateTabView.setEnableNestedScroll(false);
        this.mPlanTemplateTabView.setEnableNestedScroll(false);
        this.mJournalTemplateTabView.setEnableNestedScroll(false);
        this.mCreativeTemplateTabView.setEnableNestedScroll(false);
        this.mCustomTemplateTabView.setEnableNestedScroll(false);
    }

    public abstract void initTemplateThumbnail(int i, String str, float f);

    public abstract void initialize(Bundle bundle);

    public boolean isCanNotApplyPdfTemplate(int i) {
        return TemplateViewType.isPdfType(i) && SharedPreferencesCompat.getInstance("Settings").getInt(SettingsConstants.SETTINGS_PREFERRED_NOTE_STYLE, 1) == 0;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.presenter.ChangeTemplatesContract.View
    public void onAllItemUpdated() {
        updatePagerHeight();
    }

    public void onAttachView() {
        Logger.m10999d(TAG, "onAttachView# ");
        initItemAdapter();
        initPresenter();
        initLayout();
    }

    public boolean onBackPressed() {
        if (this.mPresenter.onBackPressed()) {
            return false;
        }
        Logger.m11003i(TAG, "onBackPressed#");
        return true;
    }

    public abstract boolean onCancel();

    public void onChangeMode() {
        this.mPresenter.onChangeMode();
    }

    public void onClickDelete(boolean z) {
        this.mPresenter.onClickDelete(z);
    }

    public void onEditDialogResult(String str) {
        this.mPresenter.onEditDialogResult(str);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.presenter.ChangeTemplatesContract.View
    public void onOpenChooser(int i, DocumentPageRatio.PageRatioType pageRatioType) {
        Logger.m10999d(TAG, "onOpenChooser# state " + getFragment().getLifecycle().getState());
        if (3 == i) {
            logAddImageTemplateSA();
            this.mIntentHandler.startImageChooser(getFragment(), 1080, pageRatioType.getHeight(1080));
        } else {
            logAddPdfTemplateSA();
            this.mIntentHandler.startPdfChooser(getFragment());
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.presenter.ChangeTemplatesContract.View
    public void onOpenTemplateEditor(String str, String str2, int i, int i2, String str3) {
        Logger.m11003i(TAG, "openTemplateEditor, path : " + Logger.getEncode(str));
        this.mIntentHandler.startTemplateEditor(getFragment(), str, str2, i, i2, str3);
    }

    public void onRestoreInstanceState(Bundle bundle) {
        ChangeTemplatesPresenter changeTemplatesPresenter;
        Logger.m11003i(TAG, "onRestoreInstanceState#");
        if (bundle == null || (changeTemplatesPresenter = this.mPresenter) == null) {
            return;
        }
        changeTemplatesPresenter.restoreState(bundle);
    }

    public void onResume(Bundle bundle) {
    }

    public void onSaveInstanceState(Bundle bundle) {
        Logger.m11003i(TAG, "onSaveInstanceState#");
        this.mPresenter.onSaveInstanceState(bundle);
    }

    public void onSelectPdfItem(int i, String str, int i2, int i4) {
        if (isCanNotApplyPdfTemplate(i)) {
            Context context = this.mContext;
            if (context != null) {
                ToastHandler.show(context, context.getString(C9086R.string.f6727xd03a75df), 0, false);
                return;
            }
            return;
        }
        String string = SharedPreferencesCompat.getInstance("Settings").getString(SettingsConstants.SETTINGS_PAGE_TEMPLATE, null);
        Context context2 = this.mContext;
        if (context2 != null && ContextUtils.isNightMode(context2) && str != null && !str.equals(string)) {
            if (TemplateViewType.isPdfType(i)) {
                Context context3 = this.mContext;
                ToastHandler.show(context3, context3.getString(C9086R.string.dark_mode_not_applied_has_pdf_toast_msg), 0, false);
            } else {
                Context context4 = this.mContext;
                ToastHandler.show(context4, context4.getString(C9086R.string.dark_mode_not_applied_template_image_toast_msg), 0, false);
            }
        }
        if (checkToNeedEditImageTemplate(i, str, i2, i4)) {
            return;
        }
        if (!canUsePdfTemplate(i, str)) {
            ToastHandler.show(this.mContext, C9086R.string.composer_could_not_add_any_page_to_note_to_landscape, 0);
        } else {
            SAManager.INSTANCE.onSaveDefaultTemplate(i, 0);
            this.mPresenter.setSelectedTemplateData(i, str);
        }
    }

    public abstract void onSelectedTemplateChanged();

    public void release() {
        ChangeTemplatesPresenter changeTemplatesPresenter = this.mPresenter;
        if (changeTemplatesPresenter != null) {
            changeTemplatesPresenter.detachView();
        }
    }

    public int requestSelectAllItems(boolean z) {
        return this.mPresenter.requestSelectAllItems(z);
    }

    public abstract void resetPageThumbnail();

    public void scrollToPosition() {
        this.mPresenter.scrollToSelectedTemplateItem();
    }

    public abstract void updatePagerHeight();

    public void updateSpanCount(int i) {
        int iCalculateSpanCount = this.mPresenter.calculateSpanCount(this.mContext, i);
        setSpanCount(this.mBasicTemplateTabView.getViewLayoutManager(), iCalculateSpanCount);
        setSpanCount(this.mAcademicTemplateTabView.getViewLayoutManager(), iCalculateSpanCount);
        setSpanCount(this.mPlanTemplateTabView.getViewLayoutManager(), iCalculateSpanCount);
        setSpanCount(this.mJournalTemplateTabView.getViewLayoutManager(), iCalculateSpanCount);
        setSpanCount(this.mCreativeTemplateTabView.getViewLayoutManager(), iCalculateSpanCount);
        setSpanCount(this.mCustomTemplateTabView.getViewLayoutManager(), iCalculateSpanCount);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.presenter.ChangeTemplatesContract.View
    public void scrollToPosition(int i, int i2) {
        AbstractC8014b.m7216r(i, i2, "scrollToPosition# templateType:", ", position:", TAG);
        this.mBasicTemplateTabView.scrollToPosition(i, i2);
    }

    private static void release(ParcelFileDescriptor parcelFileDescriptor, SpenPdfRenderer spenPdfRenderer) {
        if (parcelFileDescriptor != null) {
            try {
                parcelFileDescriptor.close();
            } catch (IOException e) {
                Logger.m11000e(TAG, "release# IOException e = " + e);
            }
        }
        if (spenPdfRenderer != null) {
            spenPdfRenderer.close();
        }
    }
}
