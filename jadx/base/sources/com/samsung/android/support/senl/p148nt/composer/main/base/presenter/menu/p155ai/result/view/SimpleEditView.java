package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.text.TextUtils;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.DragEvent;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import androidx.annotation.Nullable;
import com.samsung.android.sdk.composer.SpenTextView;
import com.samsung.android.sdk.composer.text.SpenNoteTextManager;
import com.samsung.android.sdk.composer.view.zoomScroller.SpenNoteZoomScroller;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.engine.deltaZoom.SpenZoomListener;
import com.samsung.android.sdk.pen.text.SpenSoftInputListener;
import com.samsung.android.sdk.pen.view.contextmenu.SpenContextMenuListener;
import com.samsung.android.sdk.pen.widget.listener.SpenTextManagerActionListener;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.spr.drawable.animation.interpolator.SineInOut70;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.composer.text.common.TextUtil;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ClipboardController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SoftInputManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiViewUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AiMenuResultViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.contextmenu.AiResultContextMenuManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.control.action.AiResultTaskController;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerSpenWNoteUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.simple.common.SimpleComposerConstant;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SimpleEditView {
    private static final String TAG = Logger.createTag("SimpleEditView", SimpleComposerConstant.TAG_PREFIX);
    private ClipboardController clipboardController;
    private AiResultContextMenuManager contextMenuManager;
    private boolean isEditMode;
    private boolean isRTL;
    private View mBottomBlurEffect;
    private ViewGroup mDecoratorContainer;
    private ViewGroup mEditTextContainer;
    private SpenWNote mNote;
    OnScrollListener mOnScrollListener;
    private AiMenuResultViewPresenter mPresenter;
    ScrollBarListener mScrollBarListener;
    ZoomListenerImpl mSpenZoomListener;
    private View mTopBlurEffect;
    private SpenTextView mView;
    private AiResultTaskController taskController;
    private SpenObjectTextBox textBox;
    private final boolean ENABLE_EDIT = false;
    private boolean mIsEnabledBlurEffect = false;
    private boolean mIsRightClickByMouse = false;
    public SpenContextMenuListener contextMenuListener = new SpenContextMenuListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.SimpleEditView.3
        @Override // com.samsung.android.sdk.pen.view.contextmenu.SpenContextMenuListener
        public boolean onActionItemClicked(@Nullable ActionMode actionMode, @Nullable MenuItem menuItem) {
            SimpleEditView.this.contextMenuManager.executeMenuItem(menuItem);
            return true;
        }

        @Override // com.samsung.android.sdk.pen.view.contextmenu.SpenContextMenuListener
        public boolean onCreateActionMode(@Nullable ActionMode actionMode, @Nullable Menu menu) {
            SimpleEditView.this.contextMenuManager.createContextMenu(menu, true);
            return SimpleEditView.this.contextMenuManager.canShowContextMenu(menu);
        }

        @Override // com.samsung.android.sdk.pen.view.contextmenu.SpenContextMenuListener
        public void onCreateContextMenu(@Nullable ContextMenu contextMenu) {
            SimpleEditView.this.contextMenuManager.createContextMenu(contextMenu, false);
        }
    };
    public View.OnDragListener onDragListener = new View.OnDragListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.SimpleEditView.4
        @Override // android.view.View.OnDragListener
        public boolean onDrag(View view, DragEvent dragEvent) {
            Logger.m10999d(SimpleEditView.TAG, "event: " + dragEvent.getAction());
            SimpleEditView.this.clearSelection();
            if (dragEvent.getAction() == 5) {
                SimpleEditView.this.mPresenter.getComposerViewPresenter().getView().setFocusable(true);
                SimpleEditView.this.mPresenter.getComposerViewPresenter().getView().setFocusableInTouchMode(true);
                SimpleEditView.this.mPresenter.getComposerViewPresenter().getView().requestFocus();
            }
            return true;
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class OnFocusChangeListener implements View.OnFocusChangeListener {
        public OnFocusChangeListener() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            AbstractC8014b.m7220v("focusComposer: ", SimpleEditView.TAG, z);
            if (SimpleEditView.this.mView == null || SimpleEditView.this.mPresenter == null || !z) {
                return;
            }
            SimpleEditView.this.clearSelection();
            SimpleEditView.this.mView.getTextManager().setCursorBlink(false);
            SimpleEditView.this.mPresenter.getComposerViewPresenter().getTextManager().setCursorBlink(true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnScrollBarListener {
        void onChangedScrollBarY(float f, MotionEvent motionEvent);

        void onReady();

        void onTouchUp();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnScrollListener {
        void onScrolling();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum SCROLL_POSITION {
        TOP,
        BOTTOM
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ScrollBarListener {
        void onWorking(boolean z);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Scrollbar {
        private static final int DURATION = 333;
        private static final long SHOW_TIME = 2500;
        private ViewPropertyAnimator mAnimator;
        private Runnable mHideRunnable;
        private Interpolator mInterpolator;
        private boolean mIsHiding;
        private final int mMinHeight;
        private OnScrollBarListener mOnScrollBarListener;
        private final View mParentView;
        private final Scroller mScroller;

        public Scrollbar(View view) {
            this.mParentView = view;
            this.mScroller = new Scroller(view);
            this.mMinHeight = view.getResources().getDimensionPixelSize(C9086R.dimen.comp_fast_scroll_vertical_thumb_height);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void runHideAnimation() {
            this.mAnimator.alpha(0.0f).setDuration(333L).setInterpolator(this.mInterpolator).setListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.SimpleEditView.Scrollbar.5
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Scrollbar.this.mScroller.setVisibility(8);
                    Scrollbar.this.mIsHiding = false;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Scrollbar.this.mIsHiding = true;
                }
            }).start();
        }

        private void runShowAnimation() {
            this.mAnimator.alpha(1.0f).setDuration(333L).setInterpolator(this.mInterpolator).setListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.SimpleEditView.Scrollbar.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Scrollbar.this.mScroller.getView().postDelayed(Scrollbar.this.mHideRunnable, Scrollbar.SHOW_TIME);
                }
            }).start();
        }

        public void hide() {
            if (this.mHideRunnable == null) {
                return;
            }
            this.mScroller.getView().post(this.mHideRunnable);
        }

        public void init(OnScrollBarListener onScrollBarListener) {
            if (isEnabled()) {
                this.mOnScrollBarListener = onScrollBarListener;
                this.mInterpolator = new SineInOut70();
                this.mHideRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.SimpleEditView.Scrollbar.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Scrollbar.this.runHideAnimation();
                    }
                };
                this.mAnimator = this.mScroller.getView().animate();
                final GestureDetector gestureDetector = new GestureDetector(this.mScroller.getView().getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.SimpleEditView.Scrollbar.2
                    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                    public boolean onDown(MotionEvent motionEvent) {
                        Scrollbar.this.mScroller.onDown(Scrollbar.this.mParentView, motionEvent);
                        Scrollbar.this.mOnScrollBarListener.onReady();
                        Scrollbar.this.mScroller.getView().removeCallbacks(Scrollbar.this.mHideRunnable);
                        return true;
                    }
                });
                this.mScroller.getView().setOnTouchListener(new View.OnTouchListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.SimpleEditView.Scrollbar.3
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        boolean zOnTouchEvent = gestureDetector.onTouchEvent(motionEvent);
                        if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                            if (motionEvent.getAction() == 2) {
                                Scrollbar.this.mScroller.onMove(Scrollbar.this.mScroller.getView(), Scrollbar.this.mOnScrollBarListener, motionEvent);
                            }
                            return zOnTouchEvent;
                        }
                        Logger.m11003i(SimpleEditView.TAG, "onTouch event #" + motionEvent);
                        Scrollbar.this.mScroller.onUp(Scrollbar.this.mOnScrollBarListener);
                        Scrollbar.this.mScroller.getView().postDelayed(Scrollbar.this.mHideRunnable, Scrollbar.SHOW_TIME);
                        return zOnTouchEvent;
                    }
                });
            }
        }

        public boolean isEnabled() {
            return this.mScroller.isEnabled();
        }

        public void show() {
            if (this.mScroller.getView().getVisibility() != 0) {
                this.mScroller.setVisibility(0);
                this.mScroller.getView().bringToFront();
                runShowAnimation();
            } else {
                this.mScroller.getView().removeCallbacks(this.mHideRunnable);
                if (this.mIsHiding) {
                    this.mScroller.getView().animate().cancel();
                    this.mScroller.setVisibility(0);
                    runShowAnimation();
                }
                this.mScroller.getView().postDelayed(this.mHideRunnable, SHOW_TIME);
            }
        }

        public void updatePosition(float f) {
            this.mScroller.setUpdatePosition(this.mParentView, f);
        }

        public void updateScrollbarHeight(float f) {
            int iMax = Math.max((int) (Math.max(Math.min(1.0f, f), 0.3f) * this.mParentView.getHeight()), this.mMinHeight);
            ViewGroup.LayoutParams layoutParams = this.mScroller.getView().getLayoutParams();
            if (iMax == layoutParams.height) {
                return;
            }
            layoutParams.height = iMax;
            this.mScroller.getView().setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Scroller {
        int mMaxPosValue;
        int mRangeEnd;
        View mScrollBar;
        float mStartPos;
        float mTouchStartPoint;

        public Scroller(View view) {
            this.mScrollBar = view.findViewById(C9086R.id.comp_scroll_bar_vertical);
        }

        public void calculateMaxValue(View view) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mScrollBar.getLayoutParams();
            int height = (view.getHeight() - view.getPaddingBottom()) - marginLayoutParams.bottomMargin;
            this.mRangeEnd = height;
            this.mMaxPosValue = height - marginLayoutParams.height;
        }

        public View getView() {
            return this.mScrollBar;
        }

        public boolean isEnabled() {
            return this.mScrollBar != null;
        }

        public void onDown(View view, MotionEvent motionEvent) {
            calculateMaxValue(view);
            this.mStartPos = this.mScrollBar.getTranslationY();
            this.mTouchStartPoint = motionEvent.getRawY();
        }

        public void onMove(View view, OnScrollBarListener onScrollBarListener, MotionEvent motionEvent) {
            Logger.m10999d("mytest", "onMove");
            float fMin = Math.min(Math.max((motionEvent.getRawY() - this.mTouchStartPoint) + this.mStartPos, 0.0f), this.mMaxPosValue);
            view.setTranslationY(fMin);
            onScrollBarListener.onChangedScrollBarY(fMin / this.mMaxPosValue, motionEvent);
        }

        public void onUp(OnScrollBarListener onScrollBarListener) {
            if (onScrollBarListener != null) {
                onScrollBarListener.onTouchUp();
            }
        }

        public void setUpdatePosition(View view, float f) {
            calculateMaxValue(view);
            this.mScrollBar.setTranslationY(this.mMaxPosValue * f);
        }

        public void setVisibility(int i) {
            this.mScrollBar.setVisibility(i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SoftInputListenerImpl implements SpenSoftInputListener {
        SoftInputManager mSoftInputManager;
        SpenTextView mView;

        public SoftInputListenerImpl(SpenTextView spenTextView, SoftInputManager softInputManager) {
            this.mSoftInputManager = softInputManager;
            this.mView = spenTextView;
        }

        public void hide() {
            SoftInputManager softInputManager = this.mSoftInputManager;
            if (softInputManager != null) {
                softInputManager.hide(this.mView);
            }
            this.mView = null;
        }

        @Override // com.samsung.android.sdk.pen.text.SpenSoftInputListener
        public boolean onKeyShortcut(int i, @Nullable KeyEvent keyEvent) {
            return false;
        }

        @Override // com.samsung.android.sdk.pen.text.SpenSoftInputListener
        public boolean onPerformContextMenuAction(int i) {
            return false;
        }

        @Override // com.samsung.android.sdk.pen.text.SpenSoftInputListener
        public boolean onShowClipboard(boolean z) {
            return false;
        }

        @Override // com.samsung.android.sdk.pen.text.SpenSoftInputListener
        public boolean onShowSoftInput(boolean z, long j) {
            return false;
        }

        @Override // com.samsung.android.sdk.pen.text.SpenSoftInputListener
        public boolean onShowSoftInput(boolean z) {
            AbstractC8014b.m7224z("onShowSoftInput# ", SimpleEditView.TAG, z);
            this.mSoftInputManager.setTemporarySoftInputMode(16);
            this.mSoftInputManager.show(this.mView);
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ZoomListenerImpl implements SpenZoomListener {
        SpenTextView mEditorView;
        Scrollbar mScrollbar;

        public ZoomListenerImpl() {
        }

        private void updateBoundaryBlurEffect(float f) {
            if (SimpleEditView.this.mIsEnabledBlurEffect) {
                if (f > 1.0f) {
                    SimpleEditView.this.mTopBlurEffect.setVisibility(0);
                    if (isBottom()) {
                        SimpleEditView.this.mBottomBlurEffect.setVisibility(8);
                        return;
                    } else {
                        SimpleEditView.this.mBottomBlurEffect.setVisibility(0);
                        return;
                    }
                }
                SimpleEditView.this.mTopBlurEffect.setVisibility(8);
                if (isScrollable()) {
                    SimpleEditView.this.mBottomBlurEffect.setVisibility(8);
                } else {
                    SimpleEditView.this.mBottomBlurEffect.setVisibility(0);
                }
            }
        }

        public float convertZoomFromNoteToView(float f) {
            float contentScale = this.mEditorView.getNoteZoomScroller().getContentScale() * f;
            if (contentScale == 0.0f) {
                return 1.0f;
            }
            return contentScale;
        }

        public float getNoteSizeInView(float f) {
            return this.mEditorView.getNoteZoomScroller().getContentHeight() * f;
        }

        public float getYPosRatio(float f, float f4, float f5, float f6) {
            float f7 = f - f4;
            if (f7 != 0.0f) {
                return (f5 * f6) / f7;
            }
            Logger.m11000e(SimpleEditView.TAG, "getYPosRatio# noteSize, baseSize are same");
            return 0.0f;
        }

        public void init(SpenTextView spenTextView, View view) {
            this.mEditorView = spenTextView;
            Scrollbar scrollbar = new Scrollbar(view);
            this.mScrollbar = scrollbar;
            scrollbar.init(new OnScrollBarListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.SimpleEditView.ZoomListenerImpl.1
                private float mScrollableSizeInContent;

                private float getScrollableSizeInContent(float f) {
                    return (ZoomListenerImpl.this.getNoteSizeInView(f) - ZoomListenerImpl.this.mEditorView.getHeight()) / f;
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.SimpleEditView.OnScrollBarListener
                public void onChangedScrollBarY(float f, MotionEvent motionEvent) {
                    ZoomListenerImpl.this.mEditorView.getNoteZoomScroller().setPan(new PointF(0.0f, f * this.mScrollableSizeInContent));
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.SimpleEditView.OnScrollBarListener
                public void onReady() {
                    ZoomListenerImpl zoomListenerImpl = ZoomListenerImpl.this;
                    this.mScrollableSizeInContent = getScrollableSizeInContent(zoomListenerImpl.convertZoomFromNoteToView(zoomListenerImpl.mEditorView.getNoteZoomScroller().getZoomScale()));
                    ScrollBarListener scrollBarListener = SimpleEditView.this.mScrollBarListener;
                    if (scrollBarListener != null) {
                        scrollBarListener.onWorking(true);
                    }
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.SimpleEditView.OnScrollBarListener
                public void onTouchUp() {
                    ScrollBarListener scrollBarListener = SimpleEditView.this.mScrollBarListener;
                    if (scrollBarListener != null) {
                        scrollBarListener.onWorking(false);
                    }
                }
            });
        }

        public boolean isBottom() {
            SpenNoteZoomScroller noteZoomScroller = this.mEditorView.getNoteZoomScroller();
            float fConvertZoomFromNoteToView = convertZoomFromNoteToView(noteZoomScroller.getZoomScale());
            float noteSizeInView = getNoteSizeInView(fConvertZoomFromNoteToView);
            PointF pan = noteZoomScroller.getPan();
            return getYPosRatio(noteSizeInView, (float) this.mEditorView.getHeight(), pan == null ? 0.0f : pan.y, fConvertZoomFromNoteToView) >= 0.9999f;
        }

        public boolean isScrollable(float f, float f4) {
            return f4 != 0.0f && f > f4 + 10.0f;
        }

        @Override // com.samsung.android.sdk.pen.engine.deltaZoom.SpenZoomListener
        public void onZoom(float f, float f4, float f5, float f6, float f7) {
            if (this.mEditorView.getNoteZoomScroller().getContentRectInView() == null) {
                Logger.m10999d(SimpleEditView.TAG, "onZoom# getContentRectInView is null");
                return;
            }
            updateScrollBar(f4, convertZoomFromNoteToView(f7));
            OnScrollListener onScrollListener = SimpleEditView.this.mOnScrollListener;
            if (onScrollListener != null) {
                onScrollListener.onScrolling();
            }
            updateBoundaryBlurEffect(f4);
        }

        public void updateScrollBar(float f, float f4) {
            if (this.mScrollbar.isEnabled()) {
                updateScrollBar(getNoteSizeInView(f4), this.mEditorView.getHeight(), f, f4);
            }
        }

        public boolean isScrollable() {
            return isScrollable(getNoteSizeInView(convertZoomFromNoteToView(this.mEditorView.getNoteZoomScroller().getZoomScale())), this.mEditorView.getHeight());
        }

        public void updateScrollBar(float f, float f4, float f5, float f6) {
            if (isScrollable(f, f4) && f5 >= 0.0f && f != 0.0f) {
                float yPosRatio = getYPosRatio(f, f4, f5, f6);
                this.mScrollbar.updateScrollbarHeight(1.0f - ((f - f4) / f));
                this.mScrollbar.updatePosition(yPosRatio);
                this.mScrollbar.show();
                return;
            }
            this.mScrollbar.hide();
        }
    }

    public SimpleEditView(Context context, AiMenuResultViewPresenter aiMenuResultViewPresenter) {
        if (context == null) {
            return;
        }
        this.mPresenter = aiMenuResultViewPresenter;
        this.mView = new SpenTextView(context);
        this.isRTL = LocaleUtils.isRTLMode();
        this.taskController = new AiResultTaskController();
        this.clipboardController = this.mPresenter.getComposerViewPresenter().getClipboardController();
        this.contextMenuManager = new AiResultContextMenuManager(this.mView, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void initBackgroundColor(Context context, boolean z) {
        boolean zIsNightMode = ContextUtils.isNightMode(context);
        ?? r12 = zIsNightMode;
        if (z) {
            r12 = !zIsNightMode;
        }
        this.mView.setDarkModeEnabled(r12);
        this.mView.setColorTheme(r12);
    }

    private void initDecorator(Context context, ViewGroup viewGroup) {
        ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(context).inflate(C9086R.layout.spen_edit_text_with_decorator_layout, viewGroup, true);
        this.mDecoratorContainer = viewGroup2;
        this.mTopBlurEffect = viewGroup2.findViewById(C9086R.id.top_blur);
        this.mBottomBlurEffect = this.mDecoratorContainer.findViewById(C9086R.id.bottom_blur);
    }

    private void initFeature() {
        SpenNoteTextManager textManager = this.mView.getTextManager();
        textManager.setHyperTextEnabled(false);
        textManager.setHashTagEnabled(false);
        textManager.setDoubleTapSelectionEnabled(!SystemPropertiesCompat.INSTANCE.getInstance().isUSAModel());
    }

    private void initFocusState() {
        this.mView.setClickable(true);
        this.mView.setFocusable(true);
        this.mView.setFocusableInTouchMode(true);
        if (AiViewUtils.isSupportFloatingLayout()) {
            this.mView.setOnContextClickListener(new View.OnContextClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.SimpleEditView.1
                @Override // android.view.View.OnContextClickListener
                public boolean onContextClick(View view) {
                    SimpleEditView.this.mIsRightClickByMouse = true;
                    return false;
                }
            });
        }
    }

    private void initViewState() {
        initFocusState();
    }

    public void attachView(ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        if (this.mView == null) {
            Logger.m11000e(TAG, "attachView# view is null");
            return;
        }
        initViewState();
        initDecorator(context, viewGroup);
        viewGroup.setClipToOutline(true);
        viewGroup.setClipToPadding(true);
        this.mEditTextContainer = (ViewGroup) viewGroup.findViewById(C9086R.id.spen_edit_text_container);
        if (this.mView.getParent() != null) {
            ViewGroup viewGroup2 = (ViewGroup) this.mView.getParent();
            viewGroup2.removeView(this.mView);
            this.mEditTextContainer.setLayoutParams(viewGroup2.getLayoutParams());
        }
        this.mEditTextContainer.addView(this.mView, 0);
    }

    public void clearSelection() {
        int[] cursor = getCursor();
        int i = cursor[0];
        int i2 = cursor[1];
        if (i != i2) {
            try {
                this.textBox.setCursorPosition(i2);
            } catch (Exception unused) {
                String str = TAG;
                StringBuilder sb = new StringBuilder("clearSelection# e: ");
                sb.append(cursor[0]);
                sb.append("/");
                sb.append(cursor[1]);
                sb.append(" / len = ");
                sb.append(TextUtils.isEmpty(this.textBox.getText()) ? "null" : Integer.valueOf(this.textBox.getText().length()));
                Logger.m11000e(str, sb.toString());
            }
        }
    }

    public void forceInvalidate() {
        this.mView.forceInvalidate();
    }

    public ClipboardController getClipboardController() {
        return this.clipboardController;
    }

    public int[] getCursor() {
        SpenObjectTextBox spenObjectTextBox = this.textBox;
        return spenObjectTextBox == null ? new int[]{0, 0} : TextUtil.getCursor(spenObjectTextBox);
    }

    public SpenWNote getDocument() {
        return this.mNote;
    }

    public SpenObjectTextBox getResultToCopy() {
        SpenObjectTextBox spenObjectTextBoxMakeNewTextBox = makeNewTextBox();
        int[] cursor = getCursor();
        int i = cursor[0];
        int i2 = cursor[1];
        if (i >= i2) {
            return spenObjectTextBoxMakeNewTextBox;
        }
        spenObjectTextBoxMakeNewTextBox.copyText(this.textBox, i, i2 - 1);
        return spenObjectTextBoxMakeNewTextBox;
    }

    public AiResultTaskController getTaskController() {
        return this.taskController;
    }

    public SpenObjectTextBox getTextBox() {
        return this.textBox;
    }

    public int getTextBoxLength() {
        String text;
        SpenObjectTextBox spenObjectTextBox = this.textBox;
        if (spenObjectTextBox == null || (text = spenObjectTextBox.getText()) == null) {
            return 0;
        }
        return text.length();
    }

    public View getView() {
        return this.mView;
    }

    public boolean hasNote() {
        return this.mNote != null;
    }

    public void initView(SpenWNote spenWNote, boolean z) {
        initView(spenWNote, z, 0, new boolean[0]);
    }

    public boolean isBottom() {
        ZoomListenerImpl zoomListenerImpl = this.mSpenZoomListener;
        if (zoomListenerImpl != null) {
            return zoomListenerImpl.isBottom();
        }
        return false;
    }

    public boolean isEditMode() {
        return this.isEditMode;
    }

    public boolean isRightClickByMouse() {
        if (!this.mIsRightClickByMouse) {
            return false;
        }
        this.mIsRightClickByMouse = false;
        return true;
    }

    public boolean isScrollable() {
        ZoomListenerImpl zoomListenerImpl = this.mSpenZoomListener;
        if (zoomListenerImpl != null) {
            return zoomListenerImpl.isScrollable();
        }
        return false;
    }

    public boolean isSelected() {
        int[] cursor = getCursor();
        return cursor[0] != cursor[1];
    }

    public SpenObjectTextBox makeNewTextBox() {
        SpenObjectTextBox spenObjectTextBox = new SpenObjectTextBox();
        spenObjectTextBox.setTextAlignment(this.isRTL ? 1 : 0);
        spenObjectTextBox.setFontSize(17.0f);
        spenObjectTextBox.setAutoFitOption(2);
        return spenObjectTextBox;
    }

    public void release() {
        Logger.m10999d(TAG, "release#");
        SpenTextView spenTextView = this.mView;
        if (spenTextView == null) {
            return;
        }
        spenTextView.getTextManager().setSoftInputListener(null);
        this.mView.getNoteZoomScroller().setZoomListener(null);
        this.mView.getTextManager().setActionListener(null);
        this.mView.mListenerManager.setContextMenuListener(null);
        this.mView.setOnContextClickListener(null);
        this.mView.setOnDragListener(null);
        setDocument(null);
        this.taskController.release();
        this.mView.close();
        this.mView = null;
        this.textBox = null;
        this.taskController = null;
        this.clipboardController = null;
        this.contextMenuManager = null;
    }

    public void removeSelectedText(boolean z) {
        int[] cursor = getCursor();
        int i = cursor[0];
        int i2 = cursor[1];
        if (i >= i2) {
            return;
        }
        this.textBox.removeText(i, i2 - i);
        this.textBox.setCursorPosition(cursor[0]);
        if (z) {
            this.mNote.commitHistory();
        }
    }

    public void scrollToCursor() {
        this.mView.getNoteZoomScroller().setPan(new PointF(0.0f, this.mView.getTextManager().getCursorRect(this.mNote.getBodyText(), this.mNote.getBodyText().getCursorPosition()).top));
    }

    public void scrollToPosition(SCROLL_POSITION scroll_position) {
        SpenNoteZoomScroller noteZoomScroller = this.mView.getNoteZoomScroller();
        if (scroll_position == SCROLL_POSITION.BOTTOM) {
            noteZoomScroller.setPan(new PointF(0.0f, noteZoomScroller.getContentHeight()));
        } else {
            noteZoomScroller.setPan(new PointF(0.0f, 0.0f));
        }
    }

    public void setContextMenuListener() {
        this.mView.mListenerManager.setContextMenuListener(this.contextMenuListener);
    }

    public void setCursorOnScreen() {
        this.mView.getTextManager().setCursorOnScreen(this.mNote.getBodyText(), 0);
    }

    public void setDocument(SpenWNote spenWNote) {
        this.mView.setDocument(spenWNote);
        this.mNote = spenWNote;
    }

    public void setEnabledBlurEffect(boolean z) {
        if (AiViewUtils.isSupportFloatingLayout()) {
            this.mIsEnabledBlurEffect = false;
        } else {
            this.mIsEnabledBlurEffect = z;
        }
    }

    public void setMode(int i) {
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mView.setOnLongClickListener(onLongClickListener);
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.mOnScrollListener = onScrollListener;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.mView.setOnTouchListener(onTouchListener);
    }

    public void setScrollBarListener(ScrollBarListener scrollBarListener) {
        this.mScrollBarListener = scrollBarListener;
    }

    public void setSpenObjectEventListener(SpenWNote.ObjectEventListener objectEventListener) {
        this.mNote.registerObjectEventListener(objectEventListener);
    }

    public void setSpenTextManagerActionListener(SpenTextManagerActionListener spenTextManagerActionListener) {
        this.mView.getTextManager().setActionListener(spenTextManagerActionListener);
    }

    public void updateHorizontalPadding(int i) {
        SpenWNote spenWNote = this.mNote;
        if (spenWNote == null) {
            return;
        }
        float fConvertDocumentPX = ComposerSpenWNoteUtils.convertDocumentPX(spenWNote, (int) spenWNote.getBodyText().getLeftMargin());
        float f = i;
        if (f > fConvertDocumentPX) {
            int i2 = (int) (f - fConvertDocumentPX);
            ViewGroup.LayoutParams layoutParams = this.mEditTextContainer.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.setMarginStart(i2);
                marginLayoutParams.setMarginEnd(i2);
                this.mEditTextContainer.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void initView(SpenWNote spenWNote, boolean z, int i, boolean... zArr) {
        if (this.mView == null) {
            Logger.m11000e(TAG, "initView# view is null");
            return;
        }
        setDocument(spenWNote);
        initFeature();
        initBackgroundColor(this.mView.getContext(), z);
        this.mView.setFixedTextSizeEnabled(true);
        ZoomListenerImpl zoomListenerImpl = new ZoomListenerImpl();
        this.mSpenZoomListener = zoomListenerImpl;
        zoomListenerImpl.init(this.mView, this.mDecoratorContainer);
        this.mView.getNoteZoomScroller().setZoomListener(this.mSpenZoomListener);
        updateHorizontalPadding(i);
        if (!AiViewUtils.isSupportFloatingLayout() || (zArr.length > 0 && zArr[0])) {
            this.mView.setMode(3);
            this.isEditMode = false;
        } else {
            this.mView.setMode(2);
            this.isEditMode = false;
        }
        this.textBox = this.mNote.getBodyText();
    }
}
