package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.pages;

import android.app.Activity;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.compose.runtime.AbstractC1974b;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.oneui.floatingactioncontainer.FloatingBottomLayout;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.framework.emergencymode.EmergencyManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.C8886c;
import com.samsung.android.support.senl.p148nt.base.common.util.CharUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.PageListEditModeMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.SortPageSAConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PageListEditModeLayout implements PageListEditModeMenuPresenter.IView, View.OnCreateContextMenuListener {
    private static final String TAG = Logger.createTag("PageListEditModeLayout");
    private final Activity mActivity;
    private final FloatingBottomLayout mBottomFloatingViewContainer;
    private final int mBottomMargin;
    private BottomNavigationView mBottomNavigationView;
    private TextView mCheckInfoText;
    private MenuItem mCopyItem;
    private MenuItem mCutItem;
    private MenuItem mDeleteItem;
    private final ViewStub mEditModeBottomLayout;
    private final ViewStub mEditModeToolbarLayout;
    private PageListEditModeMenuPresenter mMenuPresenter;
    private final RecyclerView mRecyclerView;
    private MenuItem mSaveAsFileItem;
    private CheckBox mSelectAll;
    private ViewGroup mSelectAllLayout;
    private MenuItem mShareItem;
    private ConstraintLayout mTopEditModeToolbar;

    public PageListEditModeLayout(Activity activity, View view, RecyclerView recyclerView) {
        View viewFindViewById;
        this.mActivity = activity;
        this.mEditModeToolbarLayout = (ViewStub) view.findViewById(C9086R.id.comp_page_list_edit_mode_toolbar);
        this.mEditModeBottomLayout = (ViewStub) view.findViewById(C9086R.id.bottom_navigation);
        FloatingBottomLayout floatingBottomLayout = (FloatingBottomLayout) view.findViewById(C9086R.id.floating_bottom_layout);
        this.mBottomFloatingViewContainer = floatingBottomLayout;
        if (floatingBottomLayout != null && (viewFindViewById = floatingBottomLayout.findViewById(C9086R.id.floating_toolbar_item_background_start_first)) != null) {
            viewFindViewById.setVisibility(8);
        }
        this.mRecyclerView = recyclerView;
        this.mBottomMargin = view.getResources().getDimensionPixelSize(C9086R.dimen.bottom_navigation_with_icon_view_height);
    }

    private void addContextMenuItem(ContextMenu contextMenu, MenuItem menuItem) {
        if (menuItem.isEnabled() && menuItem.isVisible()) {
            contextMenu.add(0, menuItem.getItemId(), menuItem.getOrder(), menuItem.getTitle());
        }
    }

    private String getSelectAllContentDescription(int i) {
        Resources resources = this.mTopEditModeToolbar.getResources();
        if (this.mSelectAll.isChecked()) {
            StringBuilder sb = new StringBuilder();
            sb.append(LocaleUtils.convertToArabicNumber(i));
            sb.append(" ");
            AbstractC8014b.m7202d(resources, C9086R.string.selectall_voice_ass_selected, sb, SQLKeyword.COMMA);
            AbstractC8014b.m7202d(resources, C9086R.string.selectall_voice_ass_double_tap_to_deselect_all, sb, SQLKeyword.COMMA);
            return AbstractC0000a.m12i(resources, C9086R.string.selectall_voice_ass_tick_box, sb);
        }
        if (i == 0) {
            StringBuilder sb2 = new StringBuilder();
            AbstractC8014b.m7202d(resources, C9086R.string.selectall_voice_ass_nothing_selected, sb2, SQLKeyword.COMMA);
            AbstractC8014b.m7202d(resources, C9086R.string.selectall_voice_ass_double_tap_to_select_all, sb2, SQLKeyword.COMMA);
            return AbstractC0000a.m12i(resources, C9086R.string.selectall_voice_ass_tick_box, sb2);
        }
        StringBuilder sbM1322o = AbstractC1974b.m1322o(i, " ");
        AbstractC8014b.m7202d(resources, C9086R.string.selectall_voice_ass_selected, sbM1322o, SQLKeyword.COMMA);
        AbstractC8014b.m7202d(resources, C9086R.string.selectall_voice_ass_double_tap_to_select_all, sbM1322o, SQLKeyword.COMMA);
        return AbstractC0000a.m12i(resources, C9086R.string.selectall_voice_ass_tick_box, sbM1322o);
    }

    private void hideBottomNavigation() {
        this.mBottomNavigationView.setVisibility(8);
        this.mBottomFloatingViewContainer.setVisibility(8);
        this.mBottomFloatingViewContainer.setLayoutVisibility(false, false, true);
        setRecyclerViewBottomMargin(0);
    }

    private void initBottomNavigation(int i) {
        if (this.mBottomNavigationView == null) {
            BottomNavigationView bottomNavigationView = (BottomNavigationView) this.mEditModeBottomLayout.inflate();
            this.mBottomNavigationView = bottomNavigationView;
            bottomNavigationView.inflateMenu(C9086R.menu.composer_page_list_edit_bottom_menu);
            this.mBottomNavigationView.setOnItemSelectedListener(new C8886c(this, 10));
            this.mCopyItem = this.mBottomNavigationView.getMenu().findItem(C9086R.id.action_copy);
            this.mShareItem = this.mBottomNavigationView.getMenu().findItem(C9086R.id.action_share);
            this.mDeleteItem = this.mBottomNavigationView.getMenu().findItem(C9086R.id.action_delete);
            this.mCutItem = this.mBottomNavigationView.getMenu().findItem(C9086R.id.action_cut);
            this.mSaveAsFileItem = this.mBottomNavigationView.getMenu().findItem(C9086R.id.action_save_as_file);
        }
        boolean zIsCopyEnabled = this.mMenuPresenter.isCopyEnabled();
        boolean z = i != 2;
        this.mCopyItem.setVisible(zIsCopyEnabled);
        this.mDeleteItem.setEnabled(z);
        this.mCutItem.setVisible(zIsCopyEnabled);
        this.mCutItem.setEnabled(z);
        this.mShareItem.setVisible(isAvailableShare());
        this.mSaveAsFileItem.setEnabled(!EmergencyManagerCompat.INSTANCE.getInstance().isEmergencyMode(this.mActivity));
        this.mSaveAsFileItem.setVisible(isAvailableShare());
    }

    private boolean isAvailableShare() {
        return !this.mMenuPresenter.isLockNote() || DeviceUtils.isSupportedFileProvider();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ boolean lambda$initBottomNavigation$2(MenuItem menuItem) {
        boolean zOnCutClicked;
        this.mMenuPresenter.clearSelection();
        setBottomNavigationButtonEnabled(false);
        int itemId = menuItem.getItemId();
        if (itemId != C9086R.id.action_delete) {
            if (itemId == C9086R.id.action_share) {
                zOnCutClicked = this.mMenuPresenter.onShareClicked(this.mActivity);
            } else if (itemId == C9086R.id.action_copy) {
                zOnCutClicked = this.mMenuPresenter.onCopyClicked(this.mActivity);
            } else if (itemId == C9086R.id.action_save_as_file) {
                zOnCutClicked = this.mMenuPresenter.onExportClicked(this.mActivity);
            } else if (itemId == C9086R.id.action_cut) {
                zOnCutClicked = this.mMenuPresenter.onCutClicked(this.mActivity);
            }
            if (!zOnCutClicked) {
                setBottomNavigationButtonEnabled(true);
            }
            return true;
        }
        this.mMenuPresenter.onDeleteClicked();
        zOnCutClicked = true;
        if (!zOnCutClicked) {
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showToolbar$0(View view) {
        this.mMenuPresenter.onSelectAllClicked(!this.mSelectAll.isChecked(), true);
        ComposerSA.insertLog(SortPageSAConstants.SORTPAGE_SCREEN_ID_PAGE_LIST_EDIT, SortPageSAConstants.SORTPAGE_EVENT_EDIT_MODE_SELECTION_ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showToolbar$1(View view) {
        this.mMenuPresenter.onDoneClicked();
    }

    private void setRecyclerViewBottomMargin(int i) {
        RecyclerView recyclerView = this.mRecyclerView;
        recyclerView.setPaddingRelative(recyclerView.getPaddingLeft(), this.mRecyclerView.getPaddingTop(), this.mRecyclerView.getPaddingRight(), i);
    }

    private void showToolbar() {
        if (this.mTopEditModeToolbar == null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) this.mEditModeToolbarLayout.inflate();
            this.mTopEditModeToolbar = constraintLayout;
            ViewGroup viewGroup = (ViewGroup) constraintLayout.findViewById(C9086R.id.checkbox_withtext);
            this.mSelectAllLayout = viewGroup;
            final int i = 0;
            viewGroup.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.a

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ PageListEditModeLayout f7163b;

                {
                    this.f7163b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i) {
                        case 0:
                            this.f7163b.lambda$showToolbar$0(view);
                            break;
                        default:
                            this.f7163b.lambda$showToolbar$1(view);
                            break;
                    }
                }
            });
            this.mSelectAll = (CheckBox) this.mSelectAllLayout.findViewById(C9086R.id.checkbox_all);
            this.mCheckInfoText = (TextView) this.mTopEditModeToolbar.findViewById(C9086R.id.check_info);
            CharUtils.applyTextSizeUntilLargeSize(this.mTopEditModeToolbar.getContext(), this.mCheckInfoText, 19.0f);
        }
        this.mTopEditModeToolbar.setVisibility(0);
        if (DeviceInfo.isVSTModel()) {
            TextView textView = (TextView) this.mTopEditModeToolbar.findViewById(C9086R.id.comp_page_list_edit_done_btn);
            textView.setVisibility(0);
            final int i2 = 1;
            textView.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.a

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ PageListEditModeLayout f7163b;

                {
                    this.f7163b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i2) {
                        case 0:
                            this.f7163b.lambda$showToolbar$0(view);
                            break;
                        default:
                            this.f7163b.lambda$showToolbar$1(view);
                            break;
                    }
                }
            });
        }
    }

    private void updateBottomNavigation() {
        boolean zIsDynamicTemplatePageSelected = this.mMenuPresenter.isDynamicTemplatePageSelected();
        this.mCopyItem.setVisible(!zIsDynamicTemplatePageSelected);
        this.mCutItem.setVisible(!zIsDynamicTemplatePageSelected);
    }

    private void updateDeleteButtonTitle(boolean z) {
        int i = z ? C9086R.string.action_delete_all : C9086R.string.action_delete;
        this.mDeleteItem.setTitle(i);
        this.mDeleteItem.setContentDescription(this.mActivity.getString(i));
    }

    public void forceHide() {
        this.mTopEditModeToolbar.setVisibility(8);
        hideBottomNavigation();
        this.mSelectAll.setChecked(false);
        this.mSelectAll.jumpDrawablesToCurrentState();
    }

    public boolean getVisibilityBottomNavigation() {
        BottomNavigationView bottomNavigationView = this.mBottomNavigationView;
        return bottomNavigationView != null && bottomNavigationView.getVisibility() == 0;
    }

    public void hide() {
        ConstraintLayout constraintLayout = this.mTopEditModeToolbar;
        if (constraintLayout != null && constraintLayout.isShown()) {
            forceHide();
        }
        this.mRecyclerView.setOnCreateContextMenuListener(null);
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        if (this.mBottomNavigationView.getVisibility() != 0) {
            return;
        }
        int size = this.mBottomNavigationView.getMenu().size();
        for (int i = 0; i < size; i++) {
            addContextMenuItem(contextMenu, this.mBottomNavigationView.getMenu().getItem(i));
        }
    }

    public void setBottomNavigationButtonEnabled(boolean z) {
        String str = TAG;
        AbstractC8014b.m7220v("setBottomNavigationViewEnabled# enabled ", str, z);
        if (this.mBottomNavigationView == null) {
            Logger.m11004w(str, "setBottomNavigationViewEnabled# not ready");
            return;
        }
        this.mCopyItem.setEnabled(z);
        this.mDeleteItem.setEnabled(z);
        this.mCutItem.setEnabled(z);
        if (!this.mMenuPresenter.isLockNote() || DeviceUtils.isSupportedFileProvider()) {
            this.mShareItem.setEnabled(z);
        } else {
            this.mBottomNavigationView.getMenu().removeItem(this.mShareItem.getItemId());
        }
    }

    public void show(int i, PageListEditModeMenuPresenter pageListEditModeMenuPresenter) {
        this.mMenuPresenter = pageListEditModeMenuPresenter;
        showToolbar();
        initBottomNavigation(i);
        setBottomNavigationButtonEnabled(true);
        updateSelectedPageCount(false, 0, 0, false, i);
        this.mRecyclerView.setOnCreateContextMenuListener(this);
    }

    public void showBottomNavigation() {
        boolean zIsDynamicTemplatePageSelected = this.mMenuPresenter.isDynamicTemplatePageSelected();
        this.mCopyItem.setVisible(!zIsDynamicTemplatePageSelected);
        this.mCutItem.setVisible(!zIsDynamicTemplatePageSelected);
        setRecyclerViewBottomMargin(this.mBottomMargin);
        this.mBottomNavigationView.setVisibility(0);
        this.mBottomFloatingViewContainer.setVisibility(0);
        this.mBottomFloatingViewContainer.setLayoutVisibility(true, true, true);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageListEditModeMenuPresenter.IView
    public void updateSelectedPageCount(boolean z, int i, int i2, boolean z2, int i4) {
        String str = TAG;
        StringBuilder sb = new StringBuilder("updateSelectedPageCount, all/prev/current : ");
        sb.append(z);
        sb.append("/");
        sb.append(i);
        sb.append("/");
        AbstractC8014b.m7221w(sb, str, i2);
        this.mCheckInfoText.setText(this.mTopEditModeToolbar.getResources().getString(C9086R.string.selected_check_info, Integer.valueOf(i2)));
        if (this.mSelectAll.isChecked() != z) {
            updateDeleteButtonTitle(z);
        }
        this.mSelectAll.setChecked(z);
        this.mSelectAllLayout.setContentDescription(getSelectAllContentDescription(i2));
        if (i == 0 && i2 > 0 && !z2) {
            showBottomNavigation();
        } else if (i2 == 0 && this.mBottomNavigationView.getVisibility() == 0) {
            hideBottomNavigation();
        } else {
            updateBottomNavigation();
        }
        if (this.mMenuPresenter.isCoeditNote()) {
            this.mDeleteItem.setEnabled(i2 == 1);
        }
    }
}
