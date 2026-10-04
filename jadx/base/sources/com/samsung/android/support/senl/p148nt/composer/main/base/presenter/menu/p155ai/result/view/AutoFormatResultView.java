package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.changedInfo.SpenObjectChangedInfo;
import com.samsung.android.sdk.pen.widget.listener.SpenTextManagerActionListener;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiViewUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AiMenuContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AutoFormat;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AbsAiActionResultView;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.SimpleEditView;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AutoFormatResultView extends AbsAiActionResultView {
    private static final String TAG = Logger.createTag("AutoFormatResultView", AiConstants.PREFIX_TAG);
    boolean isEmptyText;
    private final AutoFormat mAutoFormat;
    private final Contract mContract;
    private ViewGroup mEditViewContainer;
    boolean mIsEnableLongClick;
    boolean mIsFirstPage;
    TextView mPageErrorMsgView;
    int mSelectedTextLength;
    private SimpleEditView mSimpleEditView;
    private final int mStyleNumber;
    private View mView;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AutoFormatResultView$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C96651 implements SpenWNote.ObjectEventListener {
        public C96651() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onObjectChanged$0() {
            Context context = AutoFormatResultView.this.mView.getContext();
            ToastHandler.show(context, context.getString(C9086R.string.ss_maximum_number_of_characters_exceeded, 350000), 0);
        }

        @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.ObjectEventListener
        public void onObjectAdded(@Nullable SpenWPage spenWPage, @NonNull ArrayList<SpenObjectBase> arrayList, int i) {
        }

        @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.ObjectEventListener
        public void onObjectChanged(@Nullable SpenWPage spenWPage, @NonNull SpenObjectChangedInfo spenObjectChangedInfo, int i) {
            int textBoxLength = AutoFormatResultView.this.mSimpleEditView.getTextBoxLength();
            if (textBoxLength >= 350000) {
                new Handler(Looper.getMainLooper()).post(new RunnableC9711g(this, 5));
            }
            AutoFormatResultView autoFormatResultView = AutoFormatResultView.this;
            autoFormatResultView.isEmptyText = textBoxLength == 0;
            autoFormatResultView.mCommonViews.getBottomView().setBottomButtonsState(!AutoFormatResultView.this.isEmptyText);
        }

        @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.ObjectEventListener
        public void onObjectRemoved(@Nullable SpenWPage spenWPage, @NonNull ArrayList<SpenObjectBase> arrayList, int i) {
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AutoFormatResultView$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C96662 extends SpenTextManagerActionListener {
        public C96662() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBeforeTextChangedByKeyBoard$0() {
            Context context = AutoFormatResultView.this.mView.getContext();
            ToastHandler.show(context, context.getString(C9086R.string.ss_maximum_number_of_characters_exceeded, 350000), 0);
        }

        @Override // com.samsung.android.sdk.pen.widget.listener.SpenTextManagerActionListener
        public void onBeforeTextChangedByKeyBoard() {
            if (AutoFormatResultView.this.mSimpleEditView.getTextBoxLength() >= 350000) {
                new Handler(Looper.getMainLooper()).post(new RunnableC9711g(this, 6));
            }
        }

        @Override // com.samsung.android.sdk.pen.widget.listener.SpenTextManagerActionListener
        public void onSelectionAreaLongPressed() {
            if (AutoFormatResultView.this.mCommonViews.isShowingAnyProgress() || !AutoFormatResultView.this.mAutoFormat.canDoAction()) {
                return;
            }
            AutoFormatResultView autoFormatResultView = AutoFormatResultView.this;
            if (autoFormatResultView.mIsEnableLongClick) {
                autoFormatResultView.mAutoFormat.setSelectedStyle(AutoFormatResultView.this.mStyleNumber);
                ViewCompat.getInstance().performHapticFeedback(AutoFormatResultView.this.mSimpleEditView.getView(), 110);
                AutoFormatResultView.this.mCommonViews.mContract.getPresenter().startDragAndDrop(AutoFormatResultView.this.mSimpleEditView.getView(), AutoFormatResultView.this.mSimpleEditView.getResultToCopy());
                AutoFormatResultView.this.mSimpleEditView.getView().setOnDragListener(AutoFormatResultView.this.mSimpleEditView.onDragListener);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        void updateEditedRecognizedHw(AutoFormatResultView autoFormatResultView);
    }

    public AutoFormatResultView(AutoFormat autoFormat, int i, AiMenuResultCommonViews aiMenuResultCommonViews, int i2, Contract contract) {
        super(aiMenuResultCommonViews);
        this.mIsFirstPage = false;
        this.isEmptyText = false;
        this.mAutoFormat = autoFormat;
        this.mContract = contract;
        this.mStyleNumber = i2;
        this.mSelectedTextLength = i;
        AbstractC0000a.m3D(i2, "AutoFormatResultView# ", TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0(boolean z) {
        this.mCommonViews.mViewPager.setUserInputEnabled(!z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$1() {
        this.mIsEnableLongClick = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$initView$2(View view) {
        if (!this.mCommonViews.isShowingAnyProgress() && this.mAutoFormat.canDoAction() && this.mIsEnableLongClick) {
            this.mAutoFormat.setSelectedStyle(this.mStyleNumber);
            this.mCommonViews.mContract.getPresenter().startDragAndDrop(this.mSimpleEditView.getView(), this.mAutoFormat.getResultToCopy());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$initView$3(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        this.mIsEnableLongClick = true;
        return false;
    }

    public void addWatermark() {
        SpenWNote resultNote = this.mAutoFormat.getResultNote(this.mStyleNumber);
        if (resultNote == null) {
            return;
        }
        if (this.mAutoFormat.isRestore()) {
            resultNote.getBodyText().removeAllText();
            resultNote.getBodyText().copy(this.mAutoFormat.getOriginalResultNote(this.mStyleNumber).getBodyText());
        }
        if (this.mCommonViews.getContinuesProgress().isShowing()) {
            return;
        }
        this.mCommonViews.addFormatWatermark(BaseUtils.getApplicationContext(), resultNote);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public void clear() {
        SimpleEditView simpleEditView = this.mSimpleEditView;
        if (simpleEditView != null) {
            simpleEditView.release();
            this.mSimpleEditView = null;
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public AiMenuContract.IAiAction getAction() {
        return this.mAutoFormat;
    }

    public int getStyleNumber() {
        return this.mStyleNumber;
    }

    public void hidePageErrorMsg() {
        TextView textView = this.mPageErrorMsgView;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public View inflateView(ViewGroup viewGroup) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(C9086R.layout.ai_menu_result_auto_format_view, viewGroup, false);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    @SuppressLint({"ClickableViewAccessibility"})
    public void initView(View view, View view2) {
        AbstractC8014b.m7221w(new StringBuilder("initView# "), TAG, this.mStyleNumber);
        this.mView = view2;
        this.mEditViewContainer = (ViewGroup) view2.findViewById(C9086R.id.auto_format_result_edit_view);
        this.mPageErrorMsgView = (TextView) this.mView.findViewById(C9086R.id.auto_format_error_msg_view);
        if (AiViewUtils.isSupportFloatingLayout()) {
            this.mPageErrorMsgView.setBackgroundColor(0);
        }
        SimpleEditView simpleEditView = new SimpleEditView(view2.getContext(), this.mCommonViews.mContract.getPresenter());
        this.mSimpleEditView = simpleEditView;
        simpleEditView.attachView(this.mEditViewContainer);
        this.mSimpleEditView.setScrollBarListener(new C9690K(this));
        this.mSimpleEditView.setOnScrollListener(new C9690K(this));
        if (AiViewUtils.isSupportFloatingLayout()) {
            if (this.mSimpleEditView.isEditMode()) {
                this.mSimpleEditView.setSpenTextManagerActionListener(new C96662());
            } else {
                this.mSimpleEditView.setSpenTextManagerActionListener(new SpenTextManagerActionListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AutoFormatResultView.3
                    @Override // com.samsung.android.sdk.pen.widget.listener.SpenTextManagerActionListener
                    public void onSelectionAreaLongPressed() {
                        if (AutoFormatResultView.this.mCommonViews.isShowingAnyProgress() || !AutoFormatResultView.this.mAutoFormat.canDoAction()) {
                            return;
                        }
                        AutoFormatResultView autoFormatResultView = AutoFormatResultView.this;
                        if (autoFormatResultView.mIsEnableLongClick) {
                            autoFormatResultView.mAutoFormat.setSelectedStyle(AutoFormatResultView.this.mStyleNumber);
                            if (AutoFormatResultView.this.mSimpleEditView.isRightClickByMouse()) {
                                return;
                            }
                            ViewCompat.getInstance().performHapticFeedback(AutoFormatResultView.this.mSimpleEditView.getView(), 110);
                            AutoFormatResultView.this.mCommonViews.mContract.getPresenter().startDragAndDrop(AutoFormatResultView.this.mSimpleEditView.getView(), AutoFormatResultView.this.mSimpleEditView.getResultToCopy());
                            AutoFormatResultView.this.mSimpleEditView.clearSelection();
                            AutoFormatResultView.this.mCommonViews.mContract.getPresenter().getComposerViewPresenter().getView().requestFocus();
                        }
                    }
                });
            }
            this.mSimpleEditView.setContextMenuListener();
        } else {
            this.mSimpleEditView.setOnLongClickListener(new ViewOnLongClickListenerC9715k(this, 3));
        }
        this.mSimpleEditView.setOnTouchListener(new ViewOnTouchListenerC9717m(this, 2));
        updateNote();
        if (this.mAutoFormat.isRestore() && CscFeature.INSTANCE.getInstance().isChinaAiFeature()) {
            addWatermark();
        }
        this.mRestoreSpenEditViewScroll = new AbsAiActionResultView.RestoreSpenEditViewScroll(this.mSimpleEditView, this.mAutoFormat.getHandler());
        this.mSimpleEditView.setEnabledBlurEffect(true);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public boolean isBottomMenuSupported() {
        return this.mAutoFormat.getErrorType() == null;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public boolean isInitialized() {
        return this.mSimpleEditView != null;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AbsAiActionResultView, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public void onPageSelected() {
        AiMenuResultCommonViews aiMenuResultCommonViews = this.mCommonViews;
        ArrayList arrayList = new ArrayList(1);
        Object obj = new Object[]{4}[0];
        Objects.requireNonNull(obj);
        arrayList.add(obj);
        aiMenuResultCommonViews.setTopButtonsVisibility(Collections.unmodifiableList(arrayList));
        this.mCommonViews.getBottomView().setBottomButtonsState((this.mCommonViews.getContinuesProgress().isShowing() || this.isEmptyText) ? false : true);
        if (this.mAutoFormat.getErrorType() != null) {
            setErrorState();
        }
        if (isInitialized()) {
            this.mContract.updateEditedRecognizedHw(this);
            if (CscFeature.INSTANCE.getInstance().isChinaAiFeature()) {
                this.mSimpleEditView.forceInvalidate();
            }
        }
    }

    public void saveLastUsedStyle() {
        this.mAutoFormat.setSelectedStyle(this.mStyleNumber);
    }

    public void scrollToPosition(SimpleEditView.SCROLL_POSITION scroll_position) {
        SimpleEditView simpleEditView = this.mSimpleEditView;
        if (simpleEditView == null) {
            return;
        }
        simpleEditView.scrollToPosition(scroll_position);
    }

    public void setErrorState() {
        this.mCommonViews.getTopView().mDisclaimerBtn.setVisibility(8);
        this.mCommonViews.getBottomView().setBottomButtonsState(false);
    }

    public void setFirstPage(boolean z) {
        this.mIsFirstPage = z;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public void setTitle() {
        this.mCommonViews.getTopView().setTitle(C9086R.string.ai_auto_format_name, C9086R.drawable.ic_ai_menu_title, (Integer) null);
    }

    public void showPageErrorMsg() {
        TextView textView = this.mPageErrorMsgView;
        if (textView != null) {
            textView.setText(this.mAutoFormat.getErrorType().getMsg(this.mPageErrorMsgView.getContext()));
            this.mPageErrorMsgView.setVisibility(0);
            this.mCommonViews.getBottomView().hide(false);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AbsAiActionResultView
    public void updateHorizontalPadding(int i) {
        if (isInitialized()) {
            this.mSimpleEditView.updateHorizontalPadding(this.mView.getResources().getDimensionPixelSize(C9086R.dimen.ai_menu_result_side_margin_size));
        }
    }

    public void updateNote() {
        if (this.mSimpleEditView == null) {
            return;
        }
        if (this.mAutoFormat.getErrorType() != null) {
            showPageErrorMsg();
            return;
        }
        hidePageErrorMsg();
        SpenWNote resultNote = this.mAutoFormat.getResultNote(this.mStyleNumber);
        if (resultNote == null) {
            return;
        }
        resultNote.getBodyText().setMargin(0.0f, 16.0f, 0.0f, 0.0f);
        SimpleEditView simpleEditView = this.mSimpleEditView;
        simpleEditView.initView(resultNote, false, simpleEditView.getView().getResources().getDimensionPixelSize(C9086R.dimen.ai_menu_result_side_margin_size), new boolean[0]);
        this.mSimpleEditView.setSpenObjectEventListener(new C96651());
    }
}
