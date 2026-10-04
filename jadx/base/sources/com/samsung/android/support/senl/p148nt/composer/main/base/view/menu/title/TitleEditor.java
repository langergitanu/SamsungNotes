package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.p109ui.text.input.ChoreographerFrameCallbackC2251a;
import androidx.fragment.app.Fragment;
import com.samsung.android.app.notes.widget.glance.single.setting.view.ViewOnTouchListenerC7004e;
import com.samsung.android.app.notes.widget.glance.single.setting.view.ViewOnTouchListenerC7005f;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view.ViewOnClickListenerC8556a;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.ICustomToolbar;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SoftInputManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.title.TitleEditorPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.TitleEditorShowHideAnimator;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.TitleEditorViewSet;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.tag.TagCueAnimator;
import p047K3.ViewOnLayoutChangeListenerC0162a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TitleEditor implements TitleEditorPresenter.IView, SoftInputManager.OnSipListener {
    private static final String TAG = Logger.createTag("TitleEditor");
    private static final boolean TEMP_FEATURE_TITLE_DIALOG = false;
    private AppCompatActivity mActivity;
    private Choreographer.FrameCallback mFrameCallback;
    private final TitleEditorPresenter mPresenter;
    private TagCueAnimator mTagCueAnimator;
    private View mTagCueContainer;
    private final ITitleEditorLayout mTitleEditorLayout;
    private final Handler mUIThreadHandler = new Handler(Looper.getMainLooper());
    protected final TitleEditorViewSet mViewSet;

    public TitleEditor(Activity activity, Fragment fragment, TitleEditorPresenter titleEditorPresenter) {
        titleEditorPresenter.setView(this);
        this.mActivity = (AppCompatActivity) activity;
        this.mPresenter = titleEditorPresenter;
        TitleEditorViewSet titleEditorViewSet = new TitleEditorViewSet(fragment, new TitleEditorViewSet.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.TitleEditor.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.TitleEditorViewSet.Contract
            public AppCompatActivity getActivity() {
                return TitleEditor.this.mActivity;
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.TitleEditorViewSet.Contract
            public TitleEditorPresenter getPresenter() {
                return TitleEditor.this.mPresenter;
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.TitleEditorViewSet.Contract
            public void hide() {
                TitleEditor.this.hide();
            }
        });
        this.mViewSet = titleEditorViewSet;
        this.mTitleEditorLayout = new TitleEditorLayoutPhone(titleEditorViewSet, new TitleEditorShowHideAnimator.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.TitleEditor.3
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.TitleEditorShowHideAnimator.Contract
            public AppCompatActivity getActivity() {
                return TitleEditor.this.mActivity;
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.TitleEditorShowHideAnimator.Contract
            public TitleEditorPresenter getPresenter() {
                return TitleEditor.this.mPresenter;
            }
        });
        init(activity);
        initTagCue();
    }

    private void initTagCue() {
        this.mTagCueContainer = this.mActivity.findViewById(C9086R.id.comp_title_tag_cue_animation_container);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0(long j) {
        Logger.m10999d(TAG, "onLayoutChanged# doFrame frameTimeNanos " + j);
        update();
        Choreographer.getInstance().removeFrameCallback(this.mFrameCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$1(View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
        if (this.mTitleEditorLayout.isAnimating() || i8 - i6 == i4 - i) {
            return;
        }
        this.mFrameCallback = new ChoreographerFrameCallbackC2251a(this, 2);
        Choreographer.getInstance().postFrameCallback(this.mFrameCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$2(View view) {
        if (!this.mPresenter.isEditable() || this.mPresenter.isOverlapping()) {
            return;
        }
        show();
        ComposerSA.insertLog(this.mPresenter.isEditMode() ? "401" : "301", ComposerSAConstants.EVENT_VIEW_TITLE, this.mPresenter.isTitleTextEmpty() ? "a" : "b");
        ComposerSA.insertLog(this.mPresenter.isEditMode() ? "401" : "301", ComposerSAConstants.EVENT_EDIT_TITLE_COLLAPSE_EXPAND, "1");
        if (this.mPresenter.isCoeditNote()) {
            ComposerSA.insertLog(this.mPresenter.isEditMode() ? "683" : "682", this.mPresenter.isStandAlone() ? ComposerSAConstants.EVENT_COEDIT_TITLE_BAR_STANDALONE : ComposerSAConstants.EVENT_COEDIT_TITLE_BAR_NOTE_IN_NOTEBOOK);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$init$3(GestureDetector gestureDetector, View view, MotionEvent motionEvent) {
        gestureDetector.onTouchEvent(motionEvent);
        this.mPresenter.hideSoftInput(view);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$init$4(View view, MotionEvent motionEvent) {
        return true;
    }

    private boolean needToUpdateToolbarVisibility() {
        if (this.mActivity != null && this.mPresenter.isEditMode() && !this.mPresenter.getComposerModel().getComposerState().isFullScreenMode() && !ResourceUtils.isTabletLayout(this.mActivity) && this.mActivity.getResources().getConfiguration().orientation == 2) {
            if (WindowManagerCompat.getInstance().getMultiWindowMode(this.mActivity) == 0) {
                return true;
            }
            if (2 == WindowManagerCompat.getInstance().getMultiWindowMode(this.mActivity) && ResourceUtils.isPhoneLayout(this.mActivity)) {
                return true;
            }
        }
        return false;
    }

    private void updateTitleWidth() {
        Logger.m10999d(TAG, "updateTitleWidth#");
        new Handler().post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.TitleEditor.6
            @Override // java.lang.Runnable
            public void run() {
                if (TitleEditor.this.mActivity == null || TitleEditor.this.mTitleEditorLayout == null || TitleEditor.this.mTitleEditorLayout.isAnimating()) {
                    Logger.m10999d(TitleEditor.TAG, "updateTitleWidth# Ignored by invalid status.");
                    return;
                }
                int width = TitleEditor.this.mActivity.getWindow().getDecorView().getWidth();
                int width2 = TitleEditor.this.mViewSet.getToolbarView().getWidth();
                AbstractC8014b.m7216r(width2, width, "updateTitleWidth# toolbarWidth : ", ", appWidth : ", TitleEditor.TAG);
                ITitleEditorLayout iTitleEditorLayout = TitleEditor.this.mTitleEditorLayout;
                if (width <= width2) {
                    width = width2;
                }
                iTitleEditorLayout.updateTitleWidth(width);
            }
        });
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.title.TitleEditorPresenter.IView
    public void animateTagCue() {
        TagCueAnimator tagCueAnimator = this.mTagCueAnimator;
        if (tagCueAnimator == null) {
            TagCueAnimator tagCueAnimator2 = new TagCueAnimator();
            this.mTagCueAnimator = tagCueAnimator2;
            tagCueAnimator2.init((ViewGroup) this.mTagCueContainer, this.mViewSet.getToolbarView(), this.mViewSet.getParentLockView(), this.mPresenter.getHashTagPresenter());
        } else if (tagCueAnimator.isAnimating()) {
            return;
        }
        this.mViewSet.updateScreenLockView(1.0f, false);
        if (this.mTagCueAnimator.ready(this.mViewSet.getTagListView().isDarkTheme())) {
            this.mTagCueAnimator.animate();
        }
    }

    public void attachTitle() {
        updateTitle();
        this.mViewSet.getCoeditAddMember().attachView();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.title.TitleEditorPresenter.IView
    public String getTitle() {
        return this.mViewSet.getTitleView().getTitleText();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.title.TitleEditorPresenter.IView
    public EditText getTitleView() {
        return this.mViewSet.getTitleView().getView();
    }

    public boolean hide() {
        return hide(true);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.title.TitleEditorPresenter.IView
    public void hideNoteCover() {
        ((TitleEditorLayoutPhone) this.mTitleEditorLayout).hideNoteCover();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void init(Context context) {
        this.mViewSet.getToolbarView().addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC0162a(this, 7));
        this.mViewSet.getToolbarView().setOnClickListener(new ViewOnClickListenerC8556a(this, 18));
        this.mViewSet.getParentLockView().setOnTouchListener(new ViewOnTouchListenerC7004e(this, new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.TitleEditor.4
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(@NonNull MotionEvent motionEvent) {
                if (TitleEditor.this.isShowing() && !TitleEditor.this.mTitleEditorLayout.isAnimating()) {
                    TitleEditor.this.mTitleEditorLayout.hideAfterToolbarSetTitle();
                }
                return false;
            }
        }), 4));
        this.mViewSet.getTitleContainer().setOnTouchListener(new ViewOnTouchListenerC7005f(14));
        this.mViewSet.init();
        this.mViewSet.updateTitleToolbarAccessibilityDelegate(true);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.title.TitleEditorPresenter.IView
    public boolean isShowing() {
        TitleEditorViewSet titleEditorViewSet = this.mViewSet;
        return (titleEditorViewSet == null || titleEditorViewSet.getParentLockView() == null || this.mViewSet.getParentLockView().getVisibility() != 0) ? false : true;
    }

    public boolean onBackPressed(boolean z) {
        TagCueAnimator tagCueAnimator = this.mTagCueAnimator;
        if (tagCueAnimator != null && tagCueAnimator.isAnimating()) {
            if (z) {
                return true;
            }
            this.mTagCueAnimator.cancel();
        }
        return hide(z);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.title.TitleEditorPresenter.IView
    public void onCompleteCover() {
        ((TitleEditorLayoutPhone) this.mTitleEditorLayout).onCompleteCover();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.SoftInputManager.OnSipListener
    public void onHide() {
        if (this.mViewSet.getToolbar() == null || this.mViewSet.getToolbar().getVisibility() == 0 || !needToUpdateToolbarVisibility()) {
            return;
        }
        this.mViewSet.getToolbar().setVisibilityAsResult(0);
    }

    public void onPrepareFragmentOptionMenu() {
        this.mViewSet.initToolbar();
        this.mPresenter.setBackgroundColor();
        this.mViewSet.getFolderViewManager().updateFolderInfo(this.mPresenter.getFolderName(), this.mPresenter.getFolderColor(), this.mPresenter.getFolderIcon());
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.SoftInputManager.OnSipListener
    public void onShow() {
        if (this.mViewSet.getToolbar() == null || !needToUpdateToolbarVisibility()) {
            return;
        }
        this.mViewSet.getToolbar().setVisibilityAsResult(8);
    }

    public void release() {
        this.mActivity = null;
        this.mViewSet.getFolderViewManager().dismiss();
        this.mViewSet.getDetailsViewManager().dismiss();
        this.mTitleEditorLayout.release();
        this.mUIThreadHandler.removeCallbacksAndMessages(null);
        this.mPresenter.release();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.title.TitleEditorPresenter.IView
    public void setBackgroundColor(int i, boolean z, boolean z2) {
        this.mViewSet.setBackgroundColor(i, z, z2);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.title.TitleEditorPresenter.IView
    public void show() {
        this.mTitleEditorLayout.show();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.title.TitleEditorPresenter.IView
    public void showConfirmCover(boolean z) {
        ((TitleEditorLayoutPhone) this.mTitleEditorLayout).showCancelCover(z);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.title.TitleEditorPresenter.IView
    public void showCreatingCover() {
        ((TitleEditorLayoutPhone) this.mTitleEditorLayout).showCreatingCover();
    }

    public void update() {
        ITitleEditorLayout iTitleEditorLayout = this.mTitleEditorLayout;
        if (iTitleEditorLayout == null) {
            return;
        }
        iTitleEditorLayout.updateTitleAndFolderWidth();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.title.TitleEditorPresenter.IView
    public void updateCoeditMemberInfo() {
        this.mViewSet.updateCoeditMemberInfo();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.title.TitleEditorPresenter.IView
    public void updateCreatedTime(String str) {
        this.mViewSet.getNoteInfoViewManager().setCreatedTime(str);
        this.mViewSet.getTitleView().updateTitleHint();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.title.TitleEditorPresenter.IView
    public void updateCreator() {
        this.mViewSet.getNoteInfoViewManager().updateCreator();
        this.mViewSet.getTitleView().updateTitleHint();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.title.TitleEditorPresenter.IView
    public void updateEditableState(boolean z) {
        this.mViewSet.getTitleView().updateEditableState(z);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.title.TitleEditorPresenter.IView
    public void updateFavorite(boolean z) {
        if (this.mTitleEditorLayout.updateFavorite(z)) {
            if (this.mPresenter.getComposerModel().getComposerState().isInAppCollaborationMode()) {
                ComposerSA.insertLog(ComposerSAConstants.SCREEN_IN_APP_SERVER, ComposerSAConstants.EVENT_IN_APP_EDIT_TITLE_FAVORITE, z ? "1" : "0");
            } else {
                ComposerSA.insertLog(this.mPresenter.isEditMode() ? "401" : "301", ComposerSAConstants.EVENT_EDIT_TITLE_FAVORITE, z ? "1" : "0");
            }
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.title.TitleEditorPresenter.IView
    public void updateFolderInfo(String str, int i, int i2) {
        this.mViewSet.getFolderViewManager().updateFolderInfo(str, i, i2);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.title.TitleEditorPresenter.IView
    public void updateLastModifiedTime(String str) {
        this.mViewSet.getNoteInfoViewManager().setModifiedTime(str);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.title.TitleEditorPresenter.IView
    public void updateNoteCover() {
        ((TitleEditorLayoutPhone) this.mTitleEditorLayout).updateNoteCover();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.title.TitleEditorPresenter.IView
    public void updateNoteCoverConfirm(int i) {
        this.mViewSet.getOtherContainerFirstLine().setVisibility(i == 0 ? 4 : 0);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.title.TitleEditorPresenter.IView
    public void updateTitle() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            this.mViewSet.getTitleView().updateTitle();
        } else {
            this.mUIThreadHandler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.TitleEditor.5
                @Override // java.lang.Runnable
                public void run() {
                    TitleEditor.this.mViewSet.getTitleView().updateTitle();
                }
            });
        }
    }

    public void updateVisibility() {
        ICustomToolbar toolbar = this.mViewSet.getToolbar();
        if (toolbar == null) {
            return;
        }
        if (!this.mPresenter.isInputMethodShown()) {
            if (toolbar.getVisibility() != 0) {
                toolbar.setVisibilityAsResult(0);
                return;
            }
            return;
        }
        if (toolbar.getVisibility() == 0) {
            if (needToUpdateToolbarVisibility()) {
                toolbar.setVisibilityAsResult(8);
            }
        } else if (!needToUpdateToolbarVisibility() && toolbar.getVisibility() != 0) {
            toolbar.setVisibilityAsResult(0);
        }
        updateTitleWidth();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.title.TitleEditorPresenter.IView
    public boolean hide(boolean z) {
        return this.mTitleEditorLayout.hide(z);
    }
}
