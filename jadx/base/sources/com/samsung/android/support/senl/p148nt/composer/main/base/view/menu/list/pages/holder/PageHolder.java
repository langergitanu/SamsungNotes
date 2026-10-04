package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.pages.holder;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.base.composer.common.ComposerSpenUtils;
import com.samsung.android.support.senl.p148nt.base.winset.accessibility.VoiceAssistantTTS;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.list.pages.PageListResourceUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.PageListContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.PageListHolderPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.common.InputEventChecker;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.pages.holder.PageThumbnailHoverListener;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PageHolder extends RecyclerView.ViewHolder implements PageListContract.IPageHolder {
    private static final String TAG = Logger.createTag("PageHolder");
    public static final int TYPE_BASE = 0;
    public static final int TYPE_LAST_EMPTY_PAGE = 1;
    private int mBackgroundColor;
    protected View mBookmarkBtnContainer;
    protected LottieAnimationView mBookmarkBtnImage;
    private final CheckBoxShowHideAnimator mCheckBoxShowHideAnimator;
    private CheckBox mCheckbox;
    protected int mIndex;
    protected InputEventChecker mInputEventChecker;
    private boolean mIsBlockingCheckedListener;
    private boolean mIsBookmarked;
    private int mLastPageIndex;
    private long mLastThumbnailCreatedTime;
    protected View mMoreBtn;
    private String mPageFilePath;
    protected PageHolderLayout mPageHolderLayout;
    protected final PageHolderVariable mPageHolderVariable;
    protected String mPageId;
    protected int mPageIndex;
    protected TextView mPageIndexView;
    public PageThumbnailHoverListener mPageThumbnailHoverListener;
    private final PageListHolderPresenter mPresenter;
    protected CheckableRelativeLayout mThumbnailContainer;
    protected ImageView mThumbnailView;

    public PageHolder(@NonNull final View view, @NonNull PageListHolderPresenter pageListHolderPresenter, PageHolderVariable pageHolderVariable) {
        super(view);
        this.mIndex = -1;
        this.mPageIndex = -1;
        this.mIsBookmarked = false;
        this.mLastThumbnailCreatedTime = 0L;
        this.mLastPageIndex = Integer.MIN_VALUE;
        this.mInputEventChecker = new InputEventChecker();
        CheckableRelativeLayout checkableRelativeLayout = (CheckableRelativeLayout) view.findViewById(C9086R.id.pages_item_thumbnail_container);
        this.mThumbnailContainer = checkableRelativeLayout;
        this.mThumbnailView = (ImageView) checkableRelativeLayout.findViewById(C9086R.id.pages_item_thumbnail);
        this.mPageHolderVariable = pageHolderVariable;
        this.mPresenter = pageListHolderPresenter;
        this.mPageIndexView = (TextView) view.findViewById(C9086R.id.pages_item_number);
        this.mCheckBoxShowHideAnimator = new CheckBoxShowHideAnimator();
        this.mPageThumbnailHoverListener = new PageThumbnailHoverListener(new PageThumbnailHoverListener.HoverRecyclerViewHolderListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.holder.PageHolder.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.holder.PageThumbnailHoverListener.HoverRecyclerViewHolderListener
            public int backgroundColor() {
                return PageHolder.this.mBackgroundColor;
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.holder.PageThumbnailHoverListener.HoverRecyclerViewHolderListener
            public Drawable getImageDrawableImpl() {
                if (TextUtils.isEmpty(PageHolder.this.mPageFilePath)) {
                    return null;
                }
                return Drawable.createFromPath(PageHolder.this.mPageFilePath);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.holder.PageThumbnailHoverListener.HoverRecyclerViewHolderListener
            public View getItemView() {
                return view;
            }
        });
        init();
        this.mPageHolderLayout = new PageHolderLayout(view, this.mThumbnailView, this.mThumbnailContainer, this.mBookmarkBtnImage, pageHolderVariable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelBookmarkAnimation() {
        if (this.mBookmarkBtnImage.isAnimating()) {
            this.mBookmarkBtnImage.cancelAnimation();
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void init() {
        initMoreBtn();
        initBookmark();
        initCheckBox();
        this.mThumbnailContainer.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.holder.PageHolder.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PageHolder.this.mPageThumbnailHoverListener.dismissHoverPopup();
                PageHolder pageHolder = PageHolder.this;
                if (pageHolder.mPageHolderVariable.mMode != 1) {
                    PageListHolderPresenter pageListHolderPresenter = pageHolder.mPresenter;
                    PageHolder pageHolder2 = PageHolder.this;
                    pageListHolderPresenter.onItemClicked(pageHolder2.mPageId, pageHolder2.mInputEventChecker.getToolType());
                } else {
                    if (!pageHolder.mPresenter.canMouseShiftSelectionAction()) {
                        PageHolder.this.updateCheckboxStatus();
                        return;
                    }
                    PageListHolderPresenter pageListHolderPresenter2 = PageHolder.this.mPresenter;
                    PageHolder pageHolder3 = PageHolder.this;
                    pageListHolderPresenter2.onItemClicked(pageHolder3.mPageId, pageHolder3.mInputEventChecker.getToolType());
                }
            }
        });
        this.mThumbnailContainer.setOnTouchListener(this.mInputEventChecker);
        if (ComposerSpenUtils.isSpenHoverListener(this.mThumbnailView.getContext())) {
            this.mThumbnailView.setOnHoverListener(this.mPageThumbnailHoverListener);
        }
    }

    private void initBookmark() {
        LottieAnimationView lottieAnimationView = (LottieAnimationView) this.itemView.findViewById(C9086R.id.pages_item_bookmark_btn_image);
        this.mBookmarkBtnImage = lottieAnimationView;
        lottieAnimationView.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.holder.PageHolder.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PageHolder.this.cancelBookmarkAnimation();
                if (PageHolder.this.mIsBookmarked) {
                    PageHolder.this.mBookmarkBtnImage.setAnimation("sortpage_bookmark_off.json");
                } else {
                    PageHolder.this.mBookmarkBtnImage.setAnimation("sortpage_bookmark_on.json");
                }
                PageHolder.this.mIsBookmarked = !r2.mIsBookmarked;
                PageHolder.this.mBookmarkBtnImage.playAnimation();
                VoiceAssistantTTS.getInstance().sendTalkBackMessage(PageListResourceUtils.getBookmarkOnOffDescription(PageHolder.this.mIsBookmarked));
                PageHolder.this.mPresenter.onBookmarkClicked(PageHolder.this.mPageId);
            }
        });
        this.mBookmarkBtnImage.addAnimatorListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.holder.PageHolder.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                PageHolder pageHolder = PageHolder.this;
                pageHolder.updateBookmark(pageHolder.mIsBookmarked, true);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PageHolder pageHolder = PageHolder.this;
                pageHolder.updateBookmark(pageHolder.mIsBookmarked, true);
            }
        });
        setBookmarkTouchDelegate();
        this.mBookmarkBtnImage.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.holder.PageHolder.7
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return PageHolder.this.mCheckbox.isChecked();
            }
        });
    }

    private void initCheckBox() {
        CheckBox checkBox = (CheckBox) this.itemView.findViewById(C9086R.id.checkbox);
        this.mCheckbox = checkBox;
        checkBox.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.holder.PageHolder.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PageHolder pageHolder = PageHolder.this;
                if (pageHolder.mPageHolderVariable.mMode == 1) {
                    PageListHolderPresenter pageListHolderPresenter = pageHolder.mPresenter;
                    PageHolder pageHolder2 = PageHolder.this;
                    pageListHolderPresenter.onCheckBoxClicked(pageHolder2.mPageId, pageHolder2.mCheckbox.isChecked());
                }
            }
        });
        this.mCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.holder.PageHolder.9
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (PageHolder.this.mIsBlockingCheckedListener) {
                    return;
                }
                if (compoundButton.getVisibility() != 0) {
                    PageHolder.this.mThumbnailContainer.setChecked(z);
                    return;
                }
                CheckBoxShowHideAnimator checkBoxShowHideAnimator = PageHolder.this.mCheckBoxShowHideAnimator;
                PageHolder pageHolder = PageHolder.this;
                checkBoxShowHideAnimator.updateCheckBoxDim(z, pageHolder.mThumbnailContainer, pageHolder.mCheckbox);
            }
        });
        this.mThumbnailContainer.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.holder.PageHolder.10
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
                if (PageHolder.this.mPageHolderLayout.isFittingOnlyWidth()) {
                    PageHolder.this.mCheckbox.setTranslationX(0.0f);
                    PageHolder.this.mCheckbox.setTranslationY(i2);
                } else if (!PageHolder.this.mPageHolderLayout.isFittingOnlyHeight()) {
                    PageHolder.this.mCheckbox.setTranslationX(0.0f);
                    PageHolder.this.mCheckbox.setTranslationY(0.0f);
                } else {
                    if (PageHolder.this.mPageHolderVariable.isRTL()) {
                        PageHolder.this.mCheckbox.setTranslationX(-i);
                    } else {
                        PageHolder.this.mCheckbox.setTranslationX(i);
                    }
                    PageHolder.this.mCheckbox.setTranslationY(0.0f);
                }
            }
        });
    }

    private void initMoreBtn() {
        View viewFindViewById = this.itemView.findViewById(C9086R.id.pages_item_more_btn);
        this.mMoreBtn = viewFindViewById;
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.holder.PageHolder.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PageListHolderPresenter pageListHolderPresenter = PageHolder.this.mPresenter;
                PageHolder pageHolder = PageHolder.this;
                pageListHolderPresenter.onMoreBtnClicked(view, pageHolder.mPageId, pageHolder.mIndex, pageHolder.mInputEventChecker.getToolType());
            }
        });
        this.mMoreBtn.setOnTouchListener(this.mInputEventChecker);
        this.mThumbnailView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.holder.PageHolder.4
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
                PageHolder.this.mMoreBtn.setTranslationY(view.getY());
            }
        });
    }

    private void setBookmarkTouchDelegate() {
        View view = (View) this.mBookmarkBtnImage.getParent();
        this.mBookmarkBtnContainer = view;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        this.mBookmarkBtnContainer.setTouchDelegate(new TouchDelegate(new Rect(0, 0, layoutParams.width, layoutParams.height), this.mBookmarkBtnImage));
    }

    private void setCheckBox(boolean z, boolean z2) {
        this.mThumbnailContainer.setCheckable(z);
        if (z) {
            this.mIsBlockingCheckedListener = true;
            this.mCheckbox.setVisibility(0);
            this.mCheckbox.setChecked(z2);
            this.mThumbnailContainer.setChecked(z2);
            if (z2) {
                this.mThumbnailContainer.getForeground().setAlpha(100);
            } else {
                this.mThumbnailContainer.getForeground().setAlpha(0);
            }
            this.mIsBlockingCheckedListener = false;
        } else {
            this.mCheckbox.setVisibility(8);
            this.mThumbnailContainer.getForeground().setAlpha(255);
            this.mThumbnailContainer.setChecked(false);
        }
        this.mCheckbox.jumpDrawablesToCurrentState();
        this.mCheckbox.setImportantForAccessibility(2);
    }

    private void setNotEditableState() {
        if (!this.mPageHolderVariable.mIsEditable) {
            this.itemView.setVisibility(0);
            this.mBookmarkBtnImage.setVisibility(8);
            this.mThumbnailContainer.setOnLongClickListener(null);
        }
        if (this.mPageHolderVariable.mIsMoreEnable) {
            return;
        }
        this.mMoreBtn.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBookmark(boolean z, boolean z2) {
        if (!this.mPageHolderVariable.mIsEnabledBookmark) {
            this.mBookmarkBtnImage.setVisibility(8);
            this.mIsBookmarked = false;
            return;
        }
        if (this.mIsBookmarked != z || z2) {
            if (z) {
                this.mBookmarkBtnImage.setImageResource(C9086R.drawable.comp_page_bookmark_on_ic);
            } else {
                this.mBookmarkBtnImage.setImageResource(C9086R.drawable.comp_page_bookmark_off_ic);
            }
            this.mIsBookmarked = z;
        }
        if (this.mPageHolderVariable.mIsVoiceAssistantEnabled) {
            this.mBookmarkBtnImage.setContentDescription(PageListResourceUtils.getBookmarkOnOffDescription(z));
        }
        this.mBookmarkBtnImage.setVisibility(0);
        ViewCompat.getInstance().setTooltipText(this.mBookmarkBtnImage);
    }

    private void updateBtns(boolean z) {
        this.mBookmarkBtnImage.setEnabled(z);
        this.mMoreBtn.setEnabled(z);
    }

    private void updateDescription() {
        if (this.mPageHolderVariable.mMode == 1) {
            this.mThumbnailContainer.setContentDescription("");
        } else if (this.mIsBookmarked) {
            this.mThumbnailContainer.setContentDescription(PageListResourceUtils.getPageDescriptionWithBookmark());
        } else {
            this.mThumbnailContainer.setContentDescription(PageListResourceUtils.getPageDescription());
        }
    }

    private void updateModeState(boolean z, boolean z2) {
        int i = this.mPageHolderVariable.mMode;
        if (i == 0) {
            this.mThumbnailContainer.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.holder.PageHolder.11
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    Logger.m10999d(PageHolder.TAG, "onLongClick# " + PageHolder.this.hashCode());
                    if (!PageHolder.this.mPresenter.canDrag(PageHolder.this.getPageId())) {
                        return true;
                    }
                    PageHolder.this.mPresenter.readyDrag(PageHolder.this.mInputEventChecker.getToolType());
                    PageReorderController pageReorderController = PageHolder.this.mPageHolderVariable.getPageReorderController();
                    PageHolder pageHolder = PageHolder.this;
                    pageReorderController.startDrag(pageHolder, pageHolder.mPresenter.getPageIndex(PageHolder.this.getPageId()));
                    return true;
                }
            });
            this.mMoreBtn.setVisibility(0);
            updateBtns(true);
        } else if (i == 1) {
            this.mThumbnailContainer.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.holder.PageHolder.12
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    PageHolder.this.mPresenter.onStartLongPressMultiSelection(PageHolder.this.mIndex);
                    return true;
                }
            });
            this.mBookmarkBtnImage.setEnabled(true);
            this.mMoreBtn.setEnabled(false);
        } else if (i == 2 || i == 3) {
            this.mThumbnailContainer.setOnLongClickListener(null);
            updateBtns(true);
        }
        setCheckBox(this.mPageHolderVariable.mMode == 1, z2);
        updateBookmark(z, false);
        updateDescription();
    }

    public boolean canDrag() {
        return this.mPresenter.canDrag(getPageId());
    }

    public void clearThumbnailView() {
        this.mThumbnailView.setImageBitmap(null);
        cancelBookmarkAnimation();
    }

    public int getIndex() {
        return this.mIndex;
    }

    public long getLastThumbnailCreatedTime() {
        return this.mLastThumbnailCreatedTime;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageListContract.IPageHolder
    public String getPageId() {
        return this.mPageId;
    }

    public PageReorderController getPageReorderController() {
        return this.mPageHolderVariable.getPageReorderController();
    }

    public ImageView getThumbnailView() {
        return this.mThumbnailView;
    }

    public int getType() {
        return 0;
    }

    public void onBind(String str, int i, int i2, boolean z, boolean z2, String str2, int i4) {
        cancelBookmarkAnimation();
        this.mPageId = str;
        this.mPageIndex = i;
        PageItemView pageItemView = (PageItemView) this.itemView;
        pageItemView.setPageId(str);
        this.mPageFilePath = str2;
        this.mBackgroundColor = i4;
        if (this.mIndex != i2) {
            this.mIndex = i2;
            pageItemView.setIndex(i2);
        }
        setPageIndexText(this.mPageIndex + 1);
        updateModeState(z, z2);
        setNotEditableState();
    }

    public void readyDrag() {
        this.mPresenter.readyDrag(this.mInputEventChecker.getToolType());
    }

    public void resize(float f) {
        this.mPageHolderLayout.resize(f);
    }

    public void setNoInfoState() {
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageListContract.IPageHolder
    public void setPageIndexText(int i) {
        if (i == this.mLastPageIndex) {
            return;
        }
        this.mPageIndexView.setText(LocaleUtils.convertToArabicNumber(i));
        this.mLastPageIndex = i;
    }

    public void setThumbnailLayout(Bitmap bitmap, int i, int i2, float f, long j) {
        this.mPageHolderLayout.setThumbnailLayout(bitmap, i, i2, f);
        if (bitmap == null) {
            this.mLastThumbnailCreatedTime = 0L;
        } else {
            this.mLastThumbnailCreatedTime = j;
        }
        updateFocusedPage();
    }

    public void startDrag() {
        this.mPageHolderVariable.getPageReorderController().startDragByMouse(this, this.mIndex);
    }

    public void startModeChangeAnimation(int i, int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                return;
            }
            this.mCheckBoxShowHideAnimator.showAnimation(this.mCheckbox);
        } else if (i == 1) {
            this.mCheckBoxShowHideAnimator.hideAnimation(this.mCheckbox);
        }
    }

    public void toggleCheckBox() {
        this.mCheckbox.setChecked(!r0.isChecked());
    }

    public void updateCheckboxStatus() {
        boolean z = !this.mCheckbox.isChecked();
        this.mCheckbox.setChecked(z);
        PageListHolderPresenter pageListHolderPresenter = this.mPresenter;
        if (pageListHolderPresenter != null) {
            pageListHolderPresenter.onCheckBoxClicked(this.mPageId, z);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void updateFocusedPage() {
        boolean z;
        CheckableRelativeLayout checkableRelativeLayout = this.mThumbnailContainer;
        int i = this.mPageIndex;
        PageHolderVariable pageHolderVariable = this.mPageHolderVariable;
        if (i == pageHolderVariable.mCurrentPageIndex) {
            z = pageHolderVariable.mMode != 1;
        }
        checkableRelativeLayout.setSelected(z);
    }
}
