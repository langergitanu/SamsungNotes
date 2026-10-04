package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view;

import android.os.Handler;
import android.os.Looper;
import android.text.Layout;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AiMenuContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbsAiActionResultView implements AiMenuContract.IAiActionResultView {
    public static final int BODY_TEXT_TOP_MARGIN = 16;
    private static final String TAG = Logger.createTag("AbsAiActionResultView");
    AiMenuResultCommonViews mCommonViews;
    RestoreSpenEditViewScroll mRestoreSpenEditViewScroll;
    protected int mViewWidth = 0;
    protected int mViewHeight = 0;
    protected final Handler mHandler = new Handler(Looper.getMainLooper());
    private final Runnable mUpdateLayoutRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AbsAiActionResultView.1
        @Override // java.lang.Runnable
        public void run() {
            String str = AbsAiActionResultView.TAG;
            StringBuilder sb = new StringBuilder("mUpdateLayoutRunnable#  ");
            sb.append(AbsAiActionResultView.this.mViewWidth);
            sb.append(" - ");
            AbstractC8014b.m7221w(sb, str, AbsAiActionResultView.this.mViewHeight);
            AbsAiActionResultView.this.updateTopContainerLayout();
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class RestoreSpenEditViewScroll {
        private final Handler mHandler;
        private Runnable mRestoreAction;
        private final SimpleEditView mSimpleEditView;

        public RestoreSpenEditViewScroll(SimpleEditView simpleEditView, Handler handler) {
            this.mSimpleEditView = simpleEditView;
            this.mHandler = handler;
        }

        public void requestRestoreScroll() {
            Runnable runnable = this.mRestoreAction;
            if (runnable != null) {
                this.mHandler.removeCallbacks(runnable);
            }
            if (this.mSimpleEditView.hasNote()) {
                this.mSimpleEditView.setCursorOnScreen();
                Runnable runnable2 = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AbsAiActionResultView.RestoreSpenEditViewScroll.1
                    @Override // java.lang.Runnable
                    public void run() {
                        RestoreSpenEditViewScroll.this.mRestoreAction = null;
                        RestoreSpenEditViewScroll.this.mSimpleEditView.scrollToCursor();
                    }
                };
                this.mRestoreAction = runnable2;
                this.mHandler.post(runnable2);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class RestoreTextViewScroll {
        private static final int INVALID = -1;
        private final Handler mHandler;
        private Runnable mRestoreAction;
        private final View mScrollView;
        private final String mTag;
        private final TextView mTextView;

        public RestoreTextViewScroll(String str, TextView textView, View view, Handler handler) {
            this.mTag = str;
            this.mTextView = textView;
            this.mScrollView = view;
            this.mHandler = handler;
        }

        public int findCursorOffset(TextView textView, int i) {
            Layout layout = textView.getLayout();
            if (layout == null) {
                return -1;
            }
            int lineForVertical = layout.getLineForVertical(i);
            int lineAscent = layout.getLineAscent(lineForVertical);
            int lineBottom = layout.getLineBottom(lineForVertical);
            if (i > lineBottom - 10) {
                lineForVertical++;
            }
            int offsetForHorizontal = layout.getOffsetForHorizontal(lineForVertical, 0.0f);
            String str = this.mTag;
            StringBuilder sbM1173s = AbstractC0622a.m1173s(i, lineAscent, "findCursorOffset# ", "/", "/");
            AbstractC2821a.m2235z(sbM1173s, lineBottom, lineForVertical, " ", "/");
            AbstractC8014b.m7221w(sbM1173s, str, offsetForHorizontal);
            return offsetForHorizontal;
        }

        public int findYPos(TextView textView, int i) {
            Layout layout = textView.getLayout();
            int lineForOffset = layout.getLineForOffset(i);
            int lineTop = layout.getLineTop(lineForOffset);
            AbstractC8014b.m7216r(lineForOffset, lineTop, "findYPos# line ", "/", this.mTag);
            return lineTop;
        }

        public void restoreScroll() {
            Runnable runnable = this.mRestoreAction;
            if (runnable != null) {
                this.mHandler.removeCallbacks(runnable);
            }
            if (TextUtils.isEmpty(this.mTextView.getText())) {
                return;
            }
            if (this.mTextView.getLayout() == null) {
                Logger.m10999d(this.mTag, "restoreScroll# layout is null");
                return;
            }
            final int iFindCursorOffset = findCursorOffset(this.mTextView, this.mScrollView.getScrollY());
            Logger.m10999d(this.mTag, "onOrientationChanged# " + this.mScrollView.getScrollY() + " " + iFindCursorOffset);
            if (iFindCursorOffset == -1) {
                Logger.m11000e(this.mTag, "onOrientationChanged# invalid");
            } else {
                this.mTextView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AbsAiActionResultView.RestoreTextViewScroll.1
                    @Override // android.view.View.OnLayoutChangeListener
                    public void onLayoutChange(View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
                        view.removeOnLayoutChangeListener(this);
                        Logger.m10999d(RestoreTextViewScroll.this.mTag, "onLayoutChange#match yPos ");
                        RestoreTextViewScroll.this.mRestoreAction = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AbsAiActionResultView.RestoreTextViewScroll.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                RestoreTextViewScroll.this.mRestoreAction = null;
                                View view2 = RestoreTextViewScroll.this.mScrollView;
                                RestoreTextViewScroll restoreTextViewScroll = RestoreTextViewScroll.this;
                                view2.scrollTo(0, restoreTextViewScroll.findYPos(restoreTextViewScroll.mTextView, iFindCursorOffset));
                            }
                        };
                        RestoreTextViewScroll.this.mHandler.post(RestoreTextViewScroll.this.mRestoreAction);
                    }
                });
            }
        }
    }

    public AbsAiActionResultView(AiMenuResultCommonViews aiMenuResultCommonViews) {
        this.mCommonViews = aiMenuResultCommonViews;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public void onOrientationChanged(int i) {
        if (isInitialized()) {
            RestoreSpenEditViewScroll restoreSpenEditViewScroll = this.mRestoreSpenEditViewScroll;
            if (restoreSpenEditViewScroll != null) {
                restoreSpenEditViewScroll.requestRestoreScroll();
            }
            updateHorizontalPadding(i);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public void onPageSelected() {
        this.mCommonViews.setTopButtonsVisibility(null);
    }

    public void updateHorizontalPadding(int i) {
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public void updateLayout(boolean z, int i, int i2) {
        String str = TAG;
        StringBuilder sb = new StringBuilder("updateLayout# ");
        sb.append(z);
        sb.append(" ");
        sb.append(i);
        sb.append(" ");
        AbstractC8014b.m7195A(sb, str, i2);
        this.mHandler.removeCallbacks(this.mUpdateLayoutRunnable);
        this.mHandler.postDelayed(this.mUpdateLayoutRunnable, 100L);
    }

    public void updateTopContainerLayout() {
        AiMenuResultCommonViews aiMenuResultCommonViews = this.mCommonViews;
        if (aiMenuResultCommonViews == null) {
            return;
        }
        View view = aiMenuResultCommonViews.getTopView().mTitleMenuContainer;
        View viewFindViewById = view.findViewById(C9086R.id.ai_menu_result_title_icon);
        View viewFindViewById2 = view.findViewById(C9086R.id.ai_menu_result_title_container);
        View viewFindViewById3 = view.findViewById(C9086R.id.ai_menu_result_top_menu_container);
        int i = (viewFindViewById3.getLayoutDirection() != 1 ? viewFindViewById.getRight() < viewFindViewById3.getLeft() : viewFindViewById.getLeft() > viewFindViewById3.getRight()) ? 0 : 8;
        viewFindViewById.setVisibility(i);
        viewFindViewById2.setVisibility(i);
    }
}
