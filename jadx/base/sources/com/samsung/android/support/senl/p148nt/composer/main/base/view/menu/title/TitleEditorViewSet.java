package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.fragment.app.Fragment;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view.ViewOnClickListenerC8556a;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.C8886c;
import com.samsung.android.support.senl.p148nt.base.common.util.ButtonBackgroundUtils;
import com.samsung.android.support.senl.p148nt.base.winset.accessibility.VoiceAssistantTTS;
import com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.CustomToolbarFragment;
import com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.ICustomToolbar;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.title.TitleEditorPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.BackgroundColorUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.DetailsViewManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.FolderViewManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.NoteInfoViewManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.coedit.TitleCoeditAddMember;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.coedit.TitleCoeditMemberListView;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.coedit.TitleCoeditToolbarViewManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.tag.TagListView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TitleEditorViewSet {
    private static final String TAG = Logger.createTag("TitleEditorViewSet");
    private View.AccessibilityDelegate mAccessibilityDelegate;
    private final View mAiMenuCoverBtn;
    private final View mAiNoteContainer;
    private final TitleAiNoteCoverView mAiNoteCoverView;
    private final View mBottomDockerView;
    private TitleCoeditAddMember mCoeditAddMember;
    private final TitleCoeditMemberListView mCoeditMemberListView;
    private final Contract mContract;
    private final View mDetailsBtn;
    private final DetailsViewManager mDetailsViewManager;
    private Favorite mFavorite;
    private final View mFolderContainer;
    private final FolderViewManager mFolderViewManager;
    private final View mInfoContainer;
    private final View mMainLayoutContainerParent;
    private View mNaviUpView;
    private final NoteInfoViewManager mNoteInfoViewManager;
    private final View mOtherContainer;
    private final View mOtherContainerFirstLine;
    private final View mOtherContainerFirstLineDivider;
    private final View mOthersFirstDivider;
    private final View mParentLockView;
    private final View mParentView;
    private TagListView mTagListView;
    private final TitleCoeditToolbarViewManager mTitleCoeditToolbarViewManager;
    private final View mTitleContainer;
    private final View mTitleContainerCover;
    private TitleViewManager mTitleView;
    private ICustomToolbar mToolbar;
    private View mToolbarActionBtns;
    private final View mToolbarCoverView;
    private AppCompatImageButton mToolbarNaviUp;
    private AppCompatTextView mToolbarTitle;
    private final View mToolbarView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        AppCompatActivity getActivity();

        TitleEditorPresenter getPresenter();

        void hide();
    }

    public TitleEditorViewSet(Fragment fragment, final Contract contract) {
        this.mContract = contract;
        if (fragment instanceof CustomToolbarFragment) {
            this.mToolbar = ((CustomToolbarFragment) fragment).getSupportedToolbar();
        }
        this.mParentView = contract.getActivity().findViewById(C9086R.id.composer_title_scroll_view);
        this.mParentLockView = contract.getActivity().findViewById(C9086R.id.composer_fragment_container_lock);
        View viewFindViewById = contract.getActivity().findViewById(C9086R.id.comp_title_container);
        this.mTitleContainer = viewFindViewById;
        this.mMainLayoutContainerParent = contract.getActivity().findViewById(C9086R.id.main_layout_container_parent);
        this.mBottomDockerView = contract.getActivity().findViewById(C9086R.id.bottom_fixed_docker);
        this.mToolbarCoverView = viewFindViewById.findViewById(C9086R.id.comp_title_toolbar_cover);
        this.mTitleContainerCover = viewFindViewById.findViewById(C9086R.id.comp_title_container_cover);
        View viewFindViewById2 = viewFindViewById.findViewById(C9086R.id.comp_other_container);
        this.mOtherContainer = viewFindViewById2;
        View viewFindViewById3 = viewFindViewById.findViewById(C9086R.id.comp_title_ai_note_cover);
        this.mAiNoteContainer = viewFindViewById3;
        viewFindViewById3.setAlpha(0.0f);
        this.mAiMenuCoverBtn = viewFindViewById.findViewById(C9086R.id.ai_menu_cover_image_btn);
        View viewFindViewById4 = viewFindViewById.findViewById(C9086R.id.comp_other_first_line);
        this.mOtherContainerFirstLine = viewFindViewById4;
        viewFindViewById4.setAlpha(0.0f);
        View viewFindViewById5 = viewFindViewById.findViewById(C9086R.id.item_divider_first_line);
        this.mOtherContainerFirstLineDivider = viewFindViewById5;
        viewFindViewById5.setAlpha(0.0f);
        View viewFindViewById6 = viewFindViewById2.findViewById(C9086R.id.comp_title_info_container);
        this.mInfoContainer = viewFindViewById6;
        viewFindViewById6.setAlpha(0.0f);
        viewFindViewById6.setFocusable(false);
        this.mOthersFirstDivider = viewFindViewById2.findViewById(C9086R.id.item_divider_first_line);
        this.mNoteInfoViewManager = new NoteInfoViewManager(viewFindViewById6, new NoteInfoViewManager.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.TitleEditorViewSet.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.NoteInfoViewManager.Contract
            public AppCompatActivity getActivity() {
                return TitleEditorViewSet.this.mContract.getActivity();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.NoteInfoViewManager.Contract
            public TitleEditorPresenter getPresenter() {
                return TitleEditorViewSet.this.mContract.getPresenter();
            }
        });
        View viewFindViewById7 = viewFindViewById2.findViewById(C9086R.id.comp_title_folder_container);
        this.mFolderContainer = viewFindViewById7;
        this.mFolderViewManager = new FolderViewManager(viewFindViewById7, contract.getPresenter().getKeyguardPresenter(), new FolderViewManager.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.TitleEditorViewSet.2
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.FolderViewManager.Contract
            public AppCompatActivity getActivity() {
                return contract.getActivity();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.FolderViewManager.Contract
            public TitleEditorPresenter getPresenter() {
                return contract.getPresenter();
            }
        });
        this.mDetailsBtn = viewFindViewById6.findViewById(C9086R.id.comp_title_details_btn);
        this.mDetailsViewManager = new DetailsViewManager(contract.getPresenter().getKeyguardPresenter(), new DetailsViewManager.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.TitleEditorViewSet.3
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.DetailsViewManager.Contract
            public AppCompatActivity getActivity() {
                return contract.getActivity();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.DetailsViewManager.Contract
            public TitleEditorPresenter getPresenter() {
                return contract.getPresenter();
            }
        });
        View viewFindViewById8 = fragment.getView().findViewById(C9086R.id.toolbar);
        this.mToolbarView = viewFindViewById8;
        this.mTitleCoeditToolbarViewManager = new TitleCoeditToolbarViewManager(viewFindViewById8, new TitleCoeditToolbarViewManager.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.TitleEditorViewSet.4
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.coedit.TitleCoeditToolbarViewManager.Contract
            public AppCompatActivity getActivity() {
                return contract.getActivity();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.coedit.TitleCoeditToolbarViewManager.Contract
            public TitleEditorPresenter getPresenter() {
                return contract.getPresenter();
            }
        });
        this.mCoeditMemberListView = new TitleCoeditMemberListView();
        this.mAiNoteCoverView = new TitleAiNoteCoverView(viewFindViewById, contract.getPresenter().getAiCoverMenuViewPresenter());
    }

    private float calculateTranslationX() {
        int dimensionPixelSize = this.mToolbarNaviUp.getResources().getDimensionPixelSize(C9086R.dimen.comp_title_text_side_margin);
        int dimensionPixelSize2 = this.mToolbarNaviUp.getResources().getDimensionPixelSize(C9086R.dimen.comp_title_text_side_padding);
        if (this.mToolbarNaviUp.getMeasuredWidth() <= 0) {
            this.mToolbarNaviUp.measure(0, 0);
        }
        return this.mToolbarNaviUp.getMeasuredWidth() - (dimensionPixelSize + dimensionPixelSize2);
    }

    private boolean handleSpecialCase(MenuItemImpl menuItemImpl, Drawable drawable, int i) {
        if (menuItemImpl.getItemId() != C9086R.id.action_laser_pen || !(drawable instanceof LayerDrawable)) {
            return false;
        }
        LayerDrawable layerDrawable = (LayerDrawable) drawable;
        try {
            layerDrawable.getDrawable(0).setTint(i);
            layerDrawable.getDrawable(2).setTint(i);
            return true;
        } catch (Exception unused) {
            Logger.m11000e(TAG, "handleSpecialCase#");
            return true;
        }
    }

    private void initCoeditAddMember() {
        TitleCoeditAddMember titleCoeditAddMember = new TitleCoeditAddMember(this.mTitleContainer, this.mContract.getPresenter());
        this.mCoeditAddMember = titleCoeditAddMember;
        titleCoeditAddMember.init(0.0f);
    }

    private void initFavorite() {
        Favorite favorite = new Favorite(this.mTitleContainer, this.mContract.getPresenter());
        this.mFavorite = favorite;
        favorite.init(0.0f);
    }

    private void initTags() {
        TagListView tagListView = new TagListView();
        this.mTagListView = tagListView;
        tagListView.init((ViewGroup) this.mTitleContainer, this.mContract.getPresenter().getHashTagPresenter(), 0.0f);
    }

    private void initTitleTextView() {
        TitleViewManager titleViewManager = new TitleViewManager(this.mContract.getActivity(), this.mToolbar, this.mTitleContainer, this.mContract.getPresenter(), new C8886c(this, 13));
        this.mTitleView = titleViewManager;
        titleViewManager.init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$attachNaviUpButton$1(View view) {
        this.mContract.hide();
        ComposerSA.insertLog(this.mContract.getPresenter().isEditMode() ? "401" : "301", ComposerSAConstants.EVENT_EDIT_TITLE_COLLAPSE_EXPAND, "0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initTitleTextView$0() {
        this.mTitleCoeditToolbarViewManager.getTitleCoeditGuideTip().updateGuideTipPopup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initToolbar$3(int i) {
        this.mToolbarNaviUp.setVisibility(i);
        this.mToolbarTitle.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setThemeActionMenuView$2(int i) {
        int childCount = ((ViewGroup) this.mToolbarView).getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = ((ViewGroup) this.mToolbarView).getChildAt(i2);
            if (childAt instanceof ActionMenuView) {
                Drawable overflowIcon = ((ActionMenuView) childAt).getOverflowIcon();
                if (overflowIcon == null) {
                    return;
                }
                overflowIcon.setTint(i);
                overflowIcon.invalidateSelf();
                return;
            }
        }
    }

    private void setThemeActionMenuView(int i) {
        View view = this.mToolbarActionBtns;
        if (view == null || !(view instanceof ActionMenuView)) {
            Logger.m11000e(TAG, "setThemeActionMenuView# mToolbarActionBtns is null");
            return;
        }
        Drawable overflowIcon = ((ActionMenuView) view).getOverflowIcon();
        if (overflowIcon != null) {
            overflowIcon.setTint(i);
            overflowIcon.invalidateSelf();
        }
        this.mToolbarActionBtns.post(new RunnableC10498c(this, i, 0));
        Menu menu = ((ActionMenuView) this.mToolbarActionBtns).getMenu();
        if (!(menu instanceof MenuBuilder)) {
            Logger.m11000e(TAG, "setThemeActionMenuView# menu is null");
            return;
        }
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(i);
        for (MenuItemImpl menuItemImpl : ((MenuBuilder) menu).getActionItems()) {
            Drawable icon = menuItemImpl.getIcon();
            if (icon != null) {
                if (!handleSpecialCase(menuItemImpl, icon, i)) {
                    icon.setTint(i);
                }
                icon.invalidateSelf();
            } else if (!ButtonBackgroundUtils.isShowButtonShapeEnabled(this.mContract.getActivity())) {
                SpannableString spannableString = new SpannableString(menuItemImpl.getTitle());
                if (!menuItemImpl.isEnabled()) {
                    foregroundColorSpan = new ForegroundColorSpan(ColorUtils.setAlphaComponent(i, 102));
                }
                spannableString.setSpan(foregroundColorSpan, 0, spannableString.length(), 33);
                menuItemImpl.setTitle(spannableString);
            }
        }
    }

    private void setThemeToToolbarView(int[] iArr) {
        setThemeActionMenuView(iArr[1]);
        setThemeToView((ViewGroup) this.mToolbarView, iArr[1]);
        this.mToolbarView.setBackgroundColor(iArr[0]);
        this.mToolbarView.setAlpha(1.0f);
    }

    private void setThemeToView(ViewGroup viewGroup, int i) {
        String string = viewGroup.getContext().getString(C9086R.string.coedit_theme_skip_tag);
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof ViewGroup) {
                if (childAt.getTag() != null && (childAt.getTag() instanceof Integer) && ((Integer) childAt.getTag()).intValue() == this.mTagListView.getTag()) {
                    return;
                } else {
                    setThemeToView((ViewGroup) childAt, i);
                }
            } else if (childAt instanceof ImageView) {
                if (childAt.getTag() != null && (((childAt.getTag() instanceof Integer) && ((Integer) childAt.getTag()).intValue() == C9086R.drawable.comp_title_ic_favorite_on) || childAt.getTag().equals(string))) {
                    return;
                }
                ((ImageView) childAt).setColorFilter(i);
                childAt.invalidate();
            } else if (!(childAt instanceof TextView)) {
                continue;
            } else if (childAt.getTag() != null && childAt.getTag().equals(string)) {
                return;
            } else {
                ((TextView) childAt).setTextColor(i);
            }
        }
    }

    public void attachNaviUpButton() {
        if (this.mToolbarNaviUp == null) {
            return;
        }
        if (this.mNaviUpView == null) {
            AppCompatImageButton appCompatImageButton = new AppCompatImageButton(this.mContract.getActivity());
            this.mNaviUpView = appCompatImageButton;
            appCompatImageButton.setId(C9086R.id.composer_title_navigate);
            View view = this.mNaviUpView;
            view.setBackground(ContextCompat.getDrawable(view.getContext(), C9086R.drawable.base_ripple_circle_pressed));
            ((AppCompatImageButton) this.mNaviUpView).setImageDrawable(this.mToolbarNaviUp.getDrawable());
            this.mNaviUpView.setRotation(90.0f);
            ((ViewGroup) this.mTitleContainer).addView(this.mNaviUpView);
            this.mNaviUpView.setContentDescription(this.mContract.getActivity().getString(C9086R.string.composer_navigate_up));
            this.mNaviUpView.setOnClickListener(new ViewOnClickListenerC8556a(this, 19));
        }
        int iMin = Math.min(this.mToolbarNaviUp.getWidth(), this.mToolbarNaviUp.getHeight());
        this.mNaviUpView.setLayoutParams(new RelativeLayout.LayoutParams(iMin, iMin));
    }

    public int calculateTitleMaxWidth() {
        View view = this.mToolbarActionBtns;
        int width = (view == null ? this.mToolbarView.getWidth() : view.getLeft()) - this.mToolbar.getCustomViewWidth();
        AppCompatImageButton appCompatImageButton = this.mToolbarNaviUp;
        return width - (appCompatImageButton == null ? 0 : appCompatImageButton.getRight());
    }

    public void findViewOnToolbar() {
        Logger.m10999d(TAG, "findViewOnToolbar#");
        int childCount = ((ViewGroup) this.mToolbarView).getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = ((ViewGroup) this.mToolbarView).getChildAt(i);
            if (childAt instanceof AppCompatTextView) {
                AppCompatTextView appCompatTextView = (AppCompatTextView) childAt;
                this.mToolbarTitle = appCompatTextView;
                appCompatTextView.setId(C9086R.id.composer_toolbar_title);
            } else if (childAt instanceof ActionMenuView) {
                this.mToolbarActionBtns = childAt;
            } else if (childAt instanceof AppCompatImageButton) {
                AppCompatImageButton appCompatImageButton = (AppCompatImageButton) childAt;
                this.mToolbarNaviUp = appCompatImageButton;
                appCompatImageButton.setId(C9086R.id.composer_toolbar_navigate);
                this.mToolbarNaviUp.setNextFocusUpId(C9086R.id.toolbar);
                this.mToolbarNaviUp.setNextFocusLeftId(C9086R.id.toolbar);
            }
        }
        if (this.mToolbarNaviUp != null) {
            this.mToolbarView.setNextFocusRightId(C9086R.id.composer_toolbar_navigate);
            this.mToolbarView.setNextFocusForwardId(C9086R.id.composer_toolbar_navigate);
        }
    }

    public View getAiNoteContainer() {
        return this.mAiNoteContainer;
    }

    public TitleAiNoteCoverView getAiNoteCoverView() {
        return this.mAiNoteCoverView;
    }

    public TitleCoeditAddMember getCoeditAddMember() {
        return this.mCoeditAddMember;
    }

    public DetailsViewManager getDetailsViewManager() {
        return this.mDetailsViewManager;
    }

    public int getExtendedTitleHeight(Resources resources, boolean z) {
        float dimensionPixelSize = resources.getDimensionPixelSize(C9086R.dimen.comp_title_height);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(C9086R.dimen.comp_title_time_text_height);
        if (!TextUtils.isEmpty(this.mContract.getPresenter().getCreatedTime())) {
            dimensionPixelSize += dimensionPixelSize2;
        }
        if (!TextUtils.isEmpty(this.mContract.getPresenter().getModifiedTime())) {
            dimensionPixelSize += dimensionPixelSize2;
        }
        if (!TextUtils.isEmpty(this.mContract.getPresenter().getCreatorText())) {
            dimensionPixelSize += dimensionPixelSize2;
        }
        this.mNoteInfoViewManager.initInfoTextViews();
        List<String> tagList = this.mContract.getPresenter().getHashTagPresenter().getTagList();
        if (tagList != null && !tagList.isEmpty()) {
            dimensionPixelSize += resources.getDimensionPixelSize(C9086R.dimen.comp_title_tag_item_margin) + resources.getDimensionPixelSize(C9086R.dimen.comp_title_tag_item_height);
        }
        return (int) (dimensionPixelSize + this.mCoeditMemberListView.getHeight());
    }

    public Favorite getFavorite() {
        return this.mFavorite;
    }

    public FolderViewManager getFolderViewManager() {
        return this.mFolderViewManager;
    }

    public View getInfoContainer() {
        return this.mInfoContainer;
    }

    public View getMainLayoutContainerParent() {
        return this.mMainLayoutContainerParent;
    }

    public View getNaviUpView() {
        return this.mNaviUpView;
    }

    public NoteInfoViewManager getNoteInfoViewManager() {
        return this.mNoteInfoViewManager;
    }

    public View getOtherContainer() {
        return this.mOtherContainer;
    }

    public View getOtherContainerFirstLine() {
        return this.mOtherContainerFirstLine;
    }

    public View getOtherContainerFirstLineDivider() {
        return this.mOtherContainerFirstLineDivider;
    }

    public View getParentLockView() {
        return this.mParentLockView;
    }

    public View getParentView() {
        return this.mParentView;
    }

    public Resources getResources() {
        return this.mTitleContainer.getResources();
    }

    public TagListView getTagListView() {
        return this.mTagListView;
    }

    public TitleCoeditMemberListView getTitleCoeditMemberListView() {
        return this.mCoeditMemberListView;
    }

    public View getTitleContainer() {
        return this.mTitleContainer;
    }

    public int getTitleStartMargin() {
        return getResources().getDimensionPixelSize(C9086R.dimen.comp_title_text_side_padding) + getResources().getDimensionPixelSize(C9086R.dimen.comp_title_text_side_margin);
    }

    public TitleViewManager getTitleView() {
        return this.mTitleView;
    }

    public ICustomToolbar getToolbar() {
        return this.mToolbar;
    }

    public View getToolbarActionBtns() {
        return this.mToolbarActionBtns;
    }

    public View getToolbarCoverView() {
        return this.mToolbarCoverView;
    }

    public AppCompatImageButton getToolbarNaviUp() {
        return this.mToolbarNaviUp;
    }

    public AppCompatTextView getToolbarTitle() {
        return this.mToolbarTitle;
    }

    public View getToolbarView() {
        return this.mToolbarView;
    }

    public void init() {
        this.mNoteInfoViewManager.initInfoTextViews();
        initTitleTextView();
        initFavorite();
        initCoeditAddMember();
        initTags();
        this.mFolderViewManager.init(this.mFolderContainer);
        this.mDetailsViewManager.init(this.mDetailsBtn);
        this.mCoeditMemberListView.init((ViewGroup) this.mOtherContainer, this.mContract.getPresenter());
        this.mTitleCoeditToolbarViewManager.updateCoeditGroupCount();
        updateFirstLineLayout();
    }

    public void initShowState() {
        if (TextUtils.isEmpty(this.mContract.getPresenter().getCreatedTime())) {
            this.mOthersFirstDivider.setVisibility(8);
        } else {
            this.mOthersFirstDivider.setVisibility(0);
        }
    }

    public void initToolbar() {
        findViewOnToolbar();
        if (this.mToolbarTitle == null || this.mToolbarNaviUp == null) {
            return;
        }
        int i = 0;
        if (this.mContract.getPresenter().isNaviUpEnabled()) {
            this.mToolbarNaviUp.setEnabled(true);
            this.mToolbarTitle.setTranslationX(0.0f);
        } else {
            this.mToolbarNaviUp.setEnabled(false);
            float fCalculateTranslationX = calculateTranslationX();
            Logger.m10999d(TAG, "initToolbar, transX: " + fCalculateTranslationX);
            if (fCalculateTranslationX > 0.0f) {
                if (LocaleUtils.isRTLMode()) {
                    this.mToolbarTitle.setTranslationX(fCalculateTranslationX);
                } else {
                    this.mToolbarTitle.setTranslationX(-fCalculateTranslationX);
                }
            }
            i = 8;
        }
        this.mToolbarTitle.post(new RunnableC10498c(this, i, 1));
    }

    public void onNaviUpEnabled() {
        this.mToolbar.setNaviUpEnabled(true);
        AppCompatTextView appCompatTextView = this.mToolbarTitle;
        if (appCompatTextView != null) {
            appCompatTextView.setTranslationX(0.0f);
        }
        AppCompatImageButton appCompatImageButton = this.mToolbarNaviUp;
        if (appCompatImageButton != null) {
            appCompatImageButton.setEnabled(true);
            this.mToolbarNaviUp.setVisibility(0);
        }
        View view = this.mNaviUpView;
        if (view != null) {
            view.setAlpha(1.0f);
        }
    }

    public void setBackgroundColor(int i, boolean z, boolean z2) {
        int alphaComponent;
        int color;
        int color2;
        AppCompatActivity activity = this.mContract.getActivity();
        if (activity == null) {
            return;
        }
        int[] backgroundThemeColorTable = BackgroundColorUtil.getBackgroundThemeColorTable(activity, i, z, z2);
        boolean z3 = backgroundThemeColorTable[2] == 1;
        if (z3) {
            alphaComponent = ContextCompat.getColor(activity, C9086R.color.composer_actionbar_other_container_dark);
            color = ContextCompat.getColor(activity, C9086R.color.composer_actionbar_divider_dark);
            color2 = ContextCompat.getColor(activity, C9086R.color.composer_title_folder_text_icon_color_dark);
        } else {
            alphaComponent = ColorUtils.setAlphaComponent(backgroundThemeColorTable[1], 76);
            color = ContextCompat.getColor(activity, C9086R.color.composer_actionbar_divider_light);
            color2 = ContextCompat.getColor(activity, C9086R.color.composer_title_folder_text_icon_color);
        }
        setThemeToToolbarView(backgroundThemeColorTable);
        this.mTitleCoeditToolbarViewManager.setTheme(backgroundThemeColorTable, z3);
        setThemeToView((ViewGroup) this.mTitleContainer, backgroundThemeColorTable[1]);
        setThemeToView((ViewGroup) this.mOtherContainer, alphaComponent);
        setThemeToView((ViewGroup) this.mFolderContainer, color2);
        this.mTagListView.setDarkTheme(z3);
        this.mTitleView.updateTitleHint();
        this.mTitleView.setCoverAIIconColor(z3);
        this.mAiNoteCoverView.setBackgroundColor(z3);
        this.mFavorite.setThemeColor(backgroundThemeColorTable[1]);
        View viewFindViewById = activity.findViewById(C9086R.id.toolbar_divider);
        if (viewFindViewById != null) {
            viewFindViewById.setBackgroundColor(color);
        }
        this.mToolbarCoverView.setBackgroundColor(backgroundThemeColorTable[0]);
        this.mTitleContainerCover.setBackgroundColor(backgroundThemeColorTable[0]);
        this.mCoeditMemberListView.setBackgroundColor(backgroundThemeColorTable[0]);
    }

    public void updateAccessibilityTraversal() {
        if (this.mNaviUpView == null || !VoiceAssistantTTS.isVoiceAssistantEnabled(this.mContract.getActivity())) {
            return;
        }
        ArrayList<View> arrayList = new ArrayList();
        arrayList.add(this.mNaviUpView);
        arrayList.add(this.mTitleView.getView());
        if (this.mAiNoteCoverView.getView().getVisibility() == 0) {
            if (!this.mAiNoteCoverView.getView().isFocusable()) {
                this.mAiNoteCoverView.getView().setFocusable(true);
            }
            arrayList.add(this.mAiNoteCoverView.getView());
        }
        if (this.mCoeditAddMember.getView().getVisibility() == 0) {
            arrayList.add(this.mCoeditAddMember.getView());
        }
        if (this.mFavorite.getView().getVisibility() == 0) {
            arrayList.add(this.mFavorite.getView());
        }
        if (this.mFolderContainer.getVisibility() == 0) {
            if (!this.mFolderContainer.isFocusable()) {
                this.mFolderContainer.setFocusable(true);
            }
            arrayList.add(this.mFolderContainer);
        }
        if (this.mAiMenuCoverBtn.getVisibility() == 0) {
            arrayList.add(this.mAiMenuCoverBtn);
        }
        if (this.mInfoContainer.getVisibility() == 0) {
            arrayList.add(this.mInfoContainer);
            arrayList.add(this.mDetailsBtn);
        }
        if (this.mTagListView.getView().getVisibility() == 0) {
            arrayList.add(this.mTagListView.getView());
        }
        if (this.mCoeditMemberListView.getView().getVisibility() == 0) {
            arrayList.add(this.mCoeditMemberListView.getView());
        }
        int id = this.mTitleContainer.getId();
        for (View view : arrayList) {
            view.setAccessibilityTraversalAfter(id);
            id = view.getId();
        }
    }

    public void updateBottomDockerLockedState(boolean z) {
        View view = this.mBottomDockerView;
        if (view == null) {
            return;
        }
        view.setImportantForAccessibility(z ? 4 : 2);
    }

    public void updateCoeditMemberInfo() {
        this.mTitleCoeditToolbarViewManager.updateCoeditGroupCount();
        this.mCoeditMemberListView.updateCoeditMemberListView();
    }

    public void updateFirstLineLayout() {
        boolean z = this.mFavorite.getView().getVisibility() == 8;
        boolean z2 = this.mCoeditAddMember.getView().getVisibility() == 8;
        if (z && z2) {
            this.mTitleContainer.findViewById(C9086R.id.comp_other_first_line_first_icon).setVisibility(8);
        }
        if (z) {
            this.mTitleContainer.findViewById(C9086R.id.item_divider).setVisibility(8);
        }
    }

    public void updateFocusNavigationTraversal() {
        this.mNaviUpView.setNextFocusRightId(C9086R.id.comp_title_text);
        this.mNaviUpView.setNextFocusForwardId(C9086R.id.comp_title_text);
        this.mNaviUpView.setNextFocusDownId(C9086R.id.comp_title_text);
        this.mTitleView.getView().setNextFocusUpId(this.mNaviUpView.getId());
        this.mTitleView.getView().setNextFocusForwardId(this.mAiNoteCoverView.getView().getId());
        this.mAiNoteCoverView.getView().setNextFocusUpId(this.mNaviUpView.getId());
        this.mAiNoteCoverView.getView().setNextFocusLeftId(this.mTitleView.getView().getId());
        this.mAiNoteCoverView.getView().setNextFocusDownId(this.mFolderContainer.getId());
        if (this.mCoeditAddMember.getView().isShown()) {
            this.mCoeditAddMember.getView().setNextFocusRightId(this.mFolderContainer.getId());
            this.mTitleView.getView().setNextFocusDownId(this.mCoeditAddMember.getView().getId());
            this.mFolderContainer.setNextFocusLeftId(this.mCoeditAddMember.getView().getId());
            this.mAiNoteCoverView.getView().setNextFocusForwardId(this.mCoeditAddMember.getView().getId());
            this.mAiNoteCoverView.getView().setNextFocusRightId(this.mCoeditAddMember.getView().getId());
        } else if (this.mFavorite.getView().isShown()) {
            this.mFavorite.getView().setNextFocusRightId(this.mFolderContainer.getId());
            this.mTitleView.getView().setNextFocusDownId(this.mFavorite.getView().getId());
            this.mFolderContainer.setNextFocusLeftId(this.mFavorite.getView().getId());
            this.mAiNoteCoverView.getView().setNextFocusForwardId(this.mFavorite.getView().getId());
            this.mAiNoteCoverView.getView().setNextFocusRightId(this.mFavorite.getView().getId());
        } else {
            this.mTitleView.getView().setNextFocusDownId(this.mFolderContainer.getId());
            this.mAiNoteCoverView.getView().setNextFocusForwardId(this.mFolderContainer.getId());
            this.mAiNoteCoverView.getView().setNextFocusRightId(this.mFolderContainer.getId());
        }
        if (this.mAiMenuCoverBtn.isShown()) {
            this.mAiMenuCoverBtn.setNextFocusLeftId(this.mFolderContainer.getId());
            this.mFolderContainer.setNextFocusRightId(this.mAiMenuCoverBtn.getId());
            this.mFolderContainer.setNextFocusForwardId(this.mAiMenuCoverBtn.getId());
            this.mAiMenuCoverBtn.setNextFocusRightId(this.mNaviUpView.getId());
            this.mAiMenuCoverBtn.setNextFocusForwardId(this.mNaviUpView.getId());
            this.mAiMenuCoverBtn.setNextFocusDownId(this.mNaviUpView.getId());
        } else {
            this.mFolderContainer.setNextFocusRightId(this.mNaviUpView.getId());
            this.mFolderContainer.setNextFocusForwardId(this.mNaviUpView.getId());
        }
        if (this.mTagListView.getView().getVisibility() != 0) {
            this.mFavorite.getView().setNextFocusDownId(this.mNaviUpView.getId());
            this.mFolderContainer.setNextFocusDownId(this.mNaviUpView.getId());
        } else {
            this.mFavorite.getView().setNextFocusDownId(this.mTagListView.getView().getId());
            this.mFolderContainer.setNextFocusDownId(this.mTagListView.getView().getId());
            this.mTagListView.getView().setNextFocusUpId(this.mFolderContainer.getId());
            this.mTagListView.getView().setNextFocusDownId(this.mNaviUpView.getId());
        }
    }

    public void updateScreenLockView(float f, boolean z) {
        if (z) {
            f = 1.0f - f;
        }
        if (this.mContract.getPresenter().isBackgroundDarkTheme()) {
            getParentLockView().setBackgroundColor(-1);
            getParentLockView().setAlpha(f * 0.1f);
        } else {
            getParentLockView().setBackgroundColor(-16777216);
            getParentLockView().setAlpha(f * 0.3f);
        }
    }

    public void updateTitleToolbarAccessibilityDelegate(boolean z) {
        if (VoiceAssistantTTS.isVoiceAssistantEnabled(this.mContract.getActivity())) {
            if (!z) {
                this.mToolbarView.setAccessibilityDelegate(null);
                return;
            }
            if (this.mAccessibilityDelegate == null) {
                this.mAccessibilityDelegate = new View.AccessibilityDelegate() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.TitleEditorViewSet.5
                    @Override // android.view.View.AccessibilityDelegate
                    public void onInitializeAccessibilityNodeInfo(@NonNull View view, @NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
                        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                        accessibilityNodeInfo.addAction(new AccessibilityNodeInfo.AccessibilityAction(16, TitleEditorViewSet.this.mContract.getActivity().getString(C9086R.string.toolbar_edit_text)));
                    }
                };
            }
            this.mToolbarView.setAccessibilityDelegate(this.mAccessibilityDelegate);
        }
    }
}
