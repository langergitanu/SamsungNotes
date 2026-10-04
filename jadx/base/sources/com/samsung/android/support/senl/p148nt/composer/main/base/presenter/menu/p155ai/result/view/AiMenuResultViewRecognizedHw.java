package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Build;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.composer.listener.SpenObjectSelectListener;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.app.main.common.handoff.HandoffLaunchManager;
import com.samsung.android.support.senl.p148nt.base.winset.util.ButtonShapeUtil;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiCommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiViewUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.LanguageIdentifier;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AiMenuContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AiMenuResultViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AutoFormat;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.RecognizedHw;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.Summarization;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.Translation;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AbsAiActionResultView;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AiMenuResultTopView;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import p001A.AbstractC0000a;
import p012C1.RunnableC0050f;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiMenuResultViewRecognizedHw extends AbsAiActionResultView implements RecognizedHw.ResultListener {
    private static final String TAG = Logger.createTag("AiMenuResultViewRecognizedHw", AiConstants.PREFIX_TAG);
    Contract mContract;
    private final Runnable mDragAndDropAction;
    View mEditMenuContainer;
    ScrollView mEditViewContainer;
    private boolean mFailedActionFlag;
    private String mFailedMessage;
    private boolean mIsCursorVisible;
    private boolean mIsReadyDND;
    private boolean mIsStartEdit;
    private boolean mIsStartedDND;
    private PointF mLastTouchPoint;
    private ActionMode mLongClickActionMode;
    private final MorePopupClickListener mMorePopupClickListener;
    EditText mOriginEditText;
    RecognizedHw mRecognizedHw;
    private boolean mSkipInputFilterFlag;
    private SpenObjectSelectListener mSpenObjectSelectListener;
    private Runnable mUpdateResultTextRunnable;
    Runnable mUpdateScrollRunnable;
    CustomConstraintLayout mView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        void addAutoFormatPage(AutoFormat.FormatType formatType, AutoFormat.ErrorType errorType);

        void addSummaryPage(Summarization.ErrorType errorType);

        void addTranslationPage(Translation.ErrorType errorType);

        void executeAutoFormat(AutoFormat.FormatType formatType);

        void executeSummarize();

        void executeTranslate();

        Activity getActivity();

        void hide();

        void updateResultState();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class MorePopupClickListener implements AiMenuResultTopView.MorePopup.OnClickListener {
        public MorePopupClickListener() {
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultTopView.MorePopup.OnClickListener
        public void onItemClick(int i) {
            AbstractC0000a.m3D(i, "onItemClick# ", AiMenuResultViewRecognizedHw.TAG);
            AiMenuResultTopView.MorePopup morePopup = AiMenuResultViewRecognizedHw.this.mCommonViews.getTopView().getMorePopup();
            if (AiMenuResultViewRecognizedHw.this.mLongClickActionMode != null) {
                AiMenuResultViewRecognizedHw.this.mLongClickActionMode.finish();
            }
            if (morePopup.getMenuItems().get(i).strId() == C9086R.string.action_edit) {
                AiMenuResultViewRecognizedHw.this.setEditModeState(true);
            } else if (morePopup.getMenuItems().get(i).strId() == C9086R.string.hw_recognition_language) {
                AiMenuResultViewRecognizedHw.this.showSettingDialog();
                ComposerSA.insertLog(ComposerSAConstants.SCREEN_DIALOGS_CTT_RESULT, ComposerSAConstants.EVENT_AI_CTT_SETTINGS);
            }
            morePopup.hide();
        }
    }

    public AiMenuResultViewRecognizedHw(RecognizedHw recognizedHw, AiMenuResultCommonViews aiMenuResultCommonViews, Contract contract) {
        super(aiMenuResultCommonViews);
        this.mIsCursorVisible = false;
        this.mSkipInputFilterFlag = false;
        this.mIsReadyDND = false;
        this.mIsStartedDND = false;
        this.mIsStartEdit = false;
        this.mDragAndDropAction = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewRecognizedHw.1
            @Override // java.lang.Runnable
            public void run() {
                if (AiMenuResultViewRecognizedHw.this.mIsCursorVisible) {
                    return;
                }
                AiMenuResultViewRecognizedHw.this.mIsReadyDND = false;
                AiMenuResultViewRecognizedHw.this.mIsStartedDND = true;
                AiMenuResultViewRecognizedHw.this.mLongClickActionMode.finish();
                AiMenuResultViewPresenter presenter = AiMenuResultViewRecognizedHw.this.mCommonViews.mContract.getPresenter();
                AiMenuResultViewRecognizedHw aiMenuResultViewRecognizedHw = AiMenuResultViewRecognizedHw.this;
                presenter.startDragAndDrop(aiMenuResultViewRecognizedHw.mOriginEditText, aiMenuResultViewRecognizedHw.mRecognizedHw.getResultToCopy());
            }
        };
        this.mUpdateResultTextRunnable = null;
        this.mMorePopupClickListener = new MorePopupClickListener();
        this.mFailedMessage = null;
        this.mRecognizedHw = recognizedHw;
        recognizedHw.setResultListener(this);
        this.mContract = contract;
    }

    private ActionMode.Callback2 createNormalModeMenu() {
        return new ActionMode.Callback2() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewRecognizedHw.4
            final int MENU_EDIT_ID = HandoffLaunchManager.SYNC_PERMISSION_REQUEST_CODE;

            @Override // android.view.ActionMode.Callback
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                if (menuItem.getItemId() != 9999) {
                    return false;
                }
                Logger.m10999d(AiMenuResultViewRecognizedHw.TAG, "onActionItemClicked# " + ((Object) menuItem.getTitle()));
                AiMenuResultViewRecognizedHw.this.mLongClickActionMode.finish();
                AiMenuResultViewRecognizedHw.this.mLongClickActionMode = null;
                AiMenuResultViewRecognizedHw.this.setEditModeState(true);
                return true;
            }

            @Override // android.view.ActionMode.Callback
            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                menu.add(1, HandoffLaunchManager.SYNC_PERMISSION_REQUEST_CODE, 0, C9086R.string.action_edit).setEnabled(!AiMenuResultViewRecognizedHw.this.mIsCursorVisible);
                return true;
            }

            @Override // android.view.ActionMode.Callback
            public void onDestroyActionMode(ActionMode actionMode) {
            }

            @Override // android.view.ActionMode.Callback2
            public void onGetContentRect(ActionMode actionMode, View view, Rect rect) {
                super.onGetContentRect(actionMode, view, rect);
                rect.offset(((int) (AiMenuResultViewRecognizedHw.this.mLastTouchPoint.x - (view.getWidth() / 2.0f))) * 2, (int) (AiMenuResultViewRecognizedHw.this.mLastTouchPoint.y - 100));
            }

            @Override // android.view.ActionMode.Callback
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return true;
            }
        };
    }

    private void disableSpenToText() {
        if (Build.VERSION.SDK_INT < 34) {
            return;
        }
        this.mOriginEditText.setHandwritingBoundsOffsets(0.0f, 0.0f, -99999.0f, 0.0f);
    }

    private void doDirectAction(int i) {
        if (i == 1) {
            executeTranslate();
            return;
        }
        if (i == 2) {
            executeSummarize();
        } else if (i == 3) {
            executeAutoFormat(AutoFormat.FormatType.Normal);
        } else {
            if (i != 4) {
                return;
            }
            executeAutoFormat(AutoFormat.FormatType.Meeting);
        }
    }

    private void executeAutoFormat(AutoFormat.FormatType formatType) {
        AiCommonUtil.executeActionByServer(this.mContract.getActivity(), new RunnableC9735u(this, formatType, 2));
    }

    private void executeSummarize() {
        AiCommonUtil.executeSummaryAction(this.mContract.getActivity(), new RunnableC9719o(this, 1));
    }

    private void executeTranslate() {
        this.mRecognizedHw.setTranslationLanguageFilter(true);
        AiCommonUtil.executeActionByOndevice(this.mContract.getActivity(), new RunnableC9719o(this, 0));
    }

    private boolean hasDirectAction() {
        return this.mRecognizedHw.getSrcContentInfo().getAiBixbyParam().getAction() != 0;
    }

    private void initEditMode(View view) {
        View viewFindViewById = view.findViewById(C9086R.id.edit_menu_container);
        this.mEditMenuContainer = viewFindViewById;
        View viewFindViewById2 = viewFindViewById.findViewById(C9086R.id.cancel_btn);
        ButtonShapeUtil.setButtonShapeEnabled(viewFindViewById2.findViewById(C9086R.id.ai_menu_result_cancel_text));
        final int i = 0;
        viewFindViewById2.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.p

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ AiMenuResultViewRecognizedHw f6969b;

            {
                this.f6969b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                switch (i) {
                    case 0:
                        this.f6969b.lambda$initEditMode$3(view2);
                        break;
                    default:
                        this.f6969b.lambda$initEditMode$4(view2);
                        break;
                }
            }
        });
        View viewFindViewById3 = this.mEditMenuContainer.findViewById(C9086R.id.done_btn);
        ButtonShapeUtil.setButtonShapeEnabled(viewFindViewById3.findViewById(C9086R.id.ai_menu_result_done_text));
        final int i2 = 1;
        viewFindViewById3.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.p

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ AiMenuResultViewRecognizedHw f6969b;

            {
                this.f6969b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                switch (i2) {
                    case 0:
                        this.f6969b.lambda$initEditMode$3(view2);
                        break;
                    default:
                        this.f6969b.lambda$initEditMode$4(view2);
                        break;
                }
            }
        });
    }

    private void initMorePopup() {
        this.mCommonViews.getTopView().makeMorePopup(Arrays.asList(Integer.valueOf(C9086R.string.action_edit), Integer.valueOf(C9086R.string.hw_recognition_language)), this.mMorePopupClickListener);
    }

    private void initSelectedObjectList() {
        if (this.mSpenObjectSelectListener == null && this.mRecognizedHw.hasSelectedObject()) {
            SpenObjectSelectListener spenObjectSelectListener = new SpenObjectSelectListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewRecognizedHw.5
                @Override // com.samsung.android.sdk.composer.listener.SpenObjectSelectListener
                public void onObjectSelected(ArrayList<SpenWPage> arrayList, ArrayList<SpenObjectBase> arrayList2, boolean z) {
                    if (z || AiMenuResultViewRecognizedHw.this.mRecognizedHw.hasSelectedObject()) {
                        return;
                    }
                    AiMenuResultViewRecognizedHw.this.mCommonViews.getTopView().setDisableSettingBtn();
                    AiMenuResultViewRecognizedHw aiMenuResultViewRecognizedHw = AiMenuResultViewRecognizedHw.this;
                    aiMenuResultViewRecognizedHw.mRecognizedHw.removeSpenObjectSelectListener(aiMenuResultViewRecognizedHw.mSpenObjectSelectListener);
                    AiMenuResultViewRecognizedHw.this.mSpenObjectSelectListener = null;
                }
            };
            this.mSpenObjectSelectListener = spenObjectSelectListener;
            this.mRecognizedHw.addSpenObjectSelectListener(spenObjectSelectListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$executeAutoFormat$12(AutoFormat.FormatType formatType) {
        this.mRecognizedHw.getSrcContentInfo().getAiBixbyParam().clearAction();
        if (!AutoFormat.isLimitedMinLength(this.mView.getContext(), this.mRecognizedHw.getText(), false)) {
            this.mContract.executeAutoFormat(formatType);
            return;
        }
        Logger.m10999d(TAG, "executeAutoFormat# min length");
        this.mFailedActionFlag = true;
        this.mContract.addAutoFormatPage(formatType, AutoFormat.ErrorType.MINIMUM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$executeSummarize$11() {
        this.mRecognizedHw.getSrcContentInfo().getAiBixbyParam().clearAction();
        if (!Summarization.isLimitedMinLength(this.mView.getContext(), this.mRecognizedHw.getText(), false)) {
            this.mContract.executeSummarize();
            return;
        }
        Logger.m10999d(TAG, "executeSummarize# min length");
        this.mFailedActionFlag = true;
        this.mContract.addSummaryPage(Summarization.ErrorType.MINIMUM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$executeTranslate$13() {
        this.mRecognizedHw.getSrcContentInfo().getAiBixbyParam().clearAction();
        if (TextUtils.isEmpty(this.mRecognizedHw.getText())) {
            this.mFailedActionFlag = true;
            this.mContract.addTranslationPage(Translation.ErrorType.MINIMUM);
        } else if (Translation.preCheck(this.mRecognizedHw.getText())) {
            this.mContract.executeTranslate();
        } else {
            this.mFailedActionFlag = true;
            this.mContract.addTranslationPage(Translation.ErrorType.UNSUPPORTED_LANGUAGE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initEditMode$3(View view) {
        Logger.m10999d(TAG, "EditCancel#onClick#");
        this.mOriginEditText.setText(this.mRecognizedHw.getSpannableStringBuilder());
        this.mOriginEditText.clearFocus();
        this.mRecognizedHw.setEditing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initEditMode$4(View view) {
        Logger.m10999d(TAG, "EditCancel#onClick#");
        updateCurrentText();
        this.mOriginEditText.clearFocus();
        this.mRecognizedHw.setEditing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$initEditText$0(ActionMode.Callback2 callback2, View view) {
        if (this.mIsCursorVisible) {
            return false;
        }
        this.mIsReadyDND = true;
        this.mLongClickActionMode = this.mView.startActionMode(callback2, 1);
        setActionModeOutsideTouchable();
        this.mCommonViews.mContract.getPresenter().getHandler().postDelayed(this.mDragAndDropAction, 700L);
        ViewCompat.getInstance().performHapticFeedback(this.mOriginEditText, 1);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initEditText$1(View view, boolean z) {
        if (z) {
            if (this.mIsCursorVisible && isEditable()) {
                setEditModeState(false);
                return;
            }
            return;
        }
        if (this.mIsCursorVisible && isEditable()) {
            this.mRecognizedHw.hideSoftInput(view);
            this.mRecognizedHw.setEditing(false);
            this.mRecognizedHw.requestFocusToComposer();
            setNormalModeState();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initEditText$2(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        if (this.mIsCursorVisible) {
            return;
        }
        contextMenu.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCompleted$14() {
        if (this.mCommonViews.isShowingErrorMessage()) {
            this.mCommonViews.hideErrorMessage();
        }
        boolean zHasDirectAction = hasDirectAction();
        if (setResult() && zHasDirectAction) {
            doDirectAction(this.mRecognizedHw.getSrcContentInfo().getAiBixbyParam().getAction());
        }
        if (!zHasDirectAction) {
            this.mCommonViews.hideProgress();
            this.mCommonViews.setTopButtonState(true);
            this.mCommonViews.setBottomButtonsState(true);
            this.mContract.updateResultState();
        } else if (this.mFailedActionFlag) {
            this.mFailedActionFlag = false;
            this.mCommonViews.hideProgress();
        } else {
            this.mContract.updateResultState();
        }
        this.mCommonViews.getBottomView().show(true);
        AiMenuResultTopView topView = this.mCommonViews.getTopView();
        Object[] objArr = {Integer.valueOf(C9086R.string.hw_recognition_language), Integer.valueOf(C9086R.string.hw_recognition_language)};
        ArrayList arrayList = new ArrayList(2);
        for (int i = 0; i < 2; i++) {
            Object obj = objArr[i];
            Objects.requireNonNull(obj);
            arrayList.add(obj);
        }
        topView.updateMorePopupMenu(Collections.unmodifiableList(arrayList), this.mMorePopupClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$preventInput$10(View view, int i, KeyEvent keyEvent) {
        if (i == 61 || i == 4) {
            return false;
        }
        return !this.mIsCursorVisible;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CharSequence lambda$preventInput$9(CharSequence charSequence, int i, int i2, Spanned spanned, int i4, int i5) {
        return (this.mSkipInputFilterFlag || this.mIsCursorVisible) ? charSequence : spanned;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setEditModeState$5(AbsAiActionResultView.RestoreTextViewScroll restoreTextViewScroll) {
        EditText editText = this.mOriginEditText;
        this.mEditViewContainer.setScrollY(restoreTextViewScroll.findYPos(editText, editText.getSelectionStart()));
        this.mUpdateScrollRunnable = null;
        if (!this.mRecognizedHw.isShowingSoftInput() && this.mIsStartEdit) {
            this.mRecognizedHw.setTemporarySoftInputMode(16);
            this.mRecognizedHw.showSoftInput(this.mOriginEditText);
        }
        this.mIsStartEdit = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setEditModeState$6(AbsAiActionResultView.RestoreTextViewScroll restoreTextViewScroll, View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
        if (this.mIsCursorVisible) {
            Runnable runnable = this.mUpdateScrollRunnable;
            if (runnable == null) {
                this.mUpdateScrollRunnable = new RunnableC9735u(this, restoreTextViewScroll, 0);
            } else {
                this.mEditViewContainer.removeCallbacks(runnable);
            }
            this.mEditViewContainer.postDelayed(this.mUpdateScrollRunnable, 300L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setEditModeState$7(int i) {
        if (this.mEditViewContainer.getScrollY() <= i) {
            if (this.mEditViewContainer.getHeight() + this.mEditViewContainer.getScrollY() >= i) {
                return;
            }
        }
        this.mEditViewContainer.setScrollY(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setNormalModeState$8() {
        this.mEditViewContainer.requestLayout();
    }

    private void preventInput() {
        this.mOriginEditText.setFilters(new InputFilter[]{new InputFilter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.v
            @Override // android.text.InputFilter
            public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i4, int i5) {
                return this.f6979a.lambda$preventInput$9(charSequence, i, i2, spanned, i4, i5);
            }
        }, new InputFilter.LengthFilter(10000)});
        this.mOriginEditText.setOnKeyListener(new View.OnKeyListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.w
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                return this.f6980a.lambda$preventInput$10(view, i, keyEvent);
            }
        });
    }

    @SuppressLint({"PrivateApi"})
    private void setActionModeOutsideTouchable() {
        try {
            Class.forName("com.android.internal.view.FloatingActionMode").getDeclaredMethod("setOutsideTouchable", Boolean.TYPE, PopupWindow.OnDismissListener.class).invoke(this.mLongClickActionMode, Boolean.TRUE, null);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            Logger.m11000e(TAG, "setActionModeOutsideTouchable# " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEditModeState(boolean z) {
        if (z) {
            this.mRecognizedHw.setEditing(true);
            this.mOriginEditText.setFocusableInTouchMode(true);
            this.mIsCursorVisible = true;
            this.mOriginEditText.setCursorVisible(true);
            this.mOriginEditText.requestFocus();
            this.mRecognizedHw.setTemporarySoftInputMode(16);
            this.mRecognizedHw.showSoftInput(this.mOriginEditText);
            this.mCommonViews.getBottomView().hide(false);
            this.mIsStartEdit = true;
            final AbsAiActionResultView.RestoreTextViewScroll restoreTextViewScroll = new AbsAiActionResultView.RestoreTextViewScroll(TAG, this.mOriginEditText, this.mEditViewContainer, this.mRecognizedHw.getHandler());
            if (AiViewUtils.isSupportFloatingLayout()) {
                this.mEditViewContainer.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.q
                    @Override // android.view.View.OnLayoutChangeListener
                    public final void onLayoutChange(View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
                        this.f6970a.lambda$setEditModeState$6(restoreTextViewScroll, view, i, i2, i4, i5, i6, i7, i8, i9);
                    }
                });
            } else {
                EditText editText = this.mOriginEditText;
                this.mRecognizedHw.getHandler().postDelayed(new RunnableC0050f(this, restoreTextViewScroll.findYPos(editText, editText.getSelectionStart()), 19), 500L);
            }
        }
        this.mCommonViews.setTopButtonsVisibility(null);
        this.mEditMenuContainer.setVisibility(0);
    }

    private void setNullMagnifier() {
        try {
            Field declaredField = TextView.class.getDeclaredField("mEditor");
            Class<?> cls = Class.forName("android.widget.Editor");
            Field declaredField2 = cls.getDeclaredField("mMagnifierAnimator");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this.mOriginEditText);
            declaredField2.setAccessible(true);
            declaredField2.set(obj, null);
            Field declaredField3 = cls.getDeclaredField("mUpdateMagnifierRunnable");
            declaredField3.setAccessible(true);
            this.mOriginEditText.removeCallbacks((Runnable) declaredField3.get(obj));
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
            Logger.m11000e(TAG, "setNullMagnifier# " + e.getMessage());
        }
    }

    private boolean setResult() {
        if (this.mRecognizedHw.getSpannableStringBuilder() == null) {
            Logger.m10999d(TAG, "setResult# not yet");
            this.mCommonViews.showProgress(0);
            return false;
        }
        this.mSkipInputFilterFlag = true;
        this.mOriginEditText.setText(this.mRecognizedHw.getSpannableStringBuilder());
        this.mSkipInputFilterFlag = false;
        return true;
    }

    public boolean canShowingSip() {
        return this.mIsCursorVisible && this.mOriginEditText.hasFocus() && isEditable();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public void clear() {
        RecognizedHw recognizedHw = this.mRecognizedHw;
        if (recognizedHw == null) {
            return;
        }
        SpenObjectSelectListener spenObjectSelectListener = this.mSpenObjectSelectListener;
        if (spenObjectSelectListener != null) {
            recognizedHw.removeSpenObjectSelectListener(spenObjectSelectListener);
            this.mSpenObjectSelectListener = null;
        }
        CustomConstraintLayout customConstraintLayout = this.mView;
        if (customConstraintLayout != null) {
            customConstraintLayout.setVisibility(8);
        }
        this.mUpdateResultTextRunnable = null;
        this.mRecognizedHw.clear();
        this.mUpdateScrollRunnable = null;
        View view = this.mEditMenuContainer;
        if (view != null) {
            view.addOnLayoutChangeListener(null);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public AiMenuContract.IAiAction getAction() {
        return this.mRecognizedHw;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public View inflateView(ViewGroup viewGroup) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(C9086R.layout.ai_result_recognized_hw, viewGroup, false);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void initEditText(View view) {
        this.mIsCursorVisible = false;
        EditText editText = (EditText) view.findViewById(C9086R.id.origin_edit_text);
        this.mOriginEditText = editText;
        editText.setCursorVisible(false);
        this.mOriginEditText.setShowSoftInputOnFocus(false);
        this.mOriginEditText.setFocusableInTouchMode(false);
        ViewCompat.getInstance().setAutoHandwritingEnabled(this.mOriginEditText, false);
        final ActionMode.Callback2 callback2CreateNormalModeMenu = createNormalModeMenu();
        final View.OnLongClickListener onLongClickListener = new View.OnLongClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.r
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view2) {
                return this.f6972a.lambda$initEditText$0(callback2CreateNormalModeMenu, view2);
            }
        };
        this.mOriginEditText.setOnLongClickListener(onLongClickListener);
        this.mOriginEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.s
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view2, boolean z) {
                this.f6974a.lambda$initEditText$1(view2, z);
            }
        });
        int scaledTouchSlop = ViewConfiguration.get(this.mView.getContext()).getScaledTouchSlop();
        final int i = scaledTouchSlop * scaledTouchSlop * 3;
        this.mOriginEditText.setOnTouchListener(new View.OnTouchListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewRecognizedHw.2
            final GestureDetector gestureDetector;
            int mStartX;
            int mStartY;

            {
                this.gestureDetector = new GestureDetector(AiMenuResultViewRecognizedHw.this.mView.getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewRecognizedHw.2.1
                    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                    public boolean onSingleTapUp(@NonNull MotionEvent motionEvent) {
                        if (!AiMenuResultViewRecognizedHw.this.mIsCursorVisible || !AiMenuResultViewRecognizedHw.this.isEditable() || !AiMenuResultViewRecognizedHw.this.mOriginEditText.hasFocus() || AiMenuResultViewRecognizedHw.this.mRecognizedHw.isShowingSoftInput()) {
                            return false;
                        }
                        AiMenuResultViewRecognizedHw.this.mRecognizedHw.setTemporarySoftInputMode(16);
                        AiMenuResultViewRecognizedHw aiMenuResultViewRecognizedHw = AiMenuResultViewRecognizedHw.this;
                        aiMenuResultViewRecognizedHw.mRecognizedHw.showSoftInput(aiMenuResultViewRecognizedHw.mOriginEditText);
                        return false;
                    }
                });
            }

            /* JADX WARN: Code restructure failed: missing block: B:9:0x0013, code lost:
            
                if (r3 != 3) goto L19;
             */
            @Override // android.view.View.OnTouchListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                this.gestureDetector.onTouchEvent(motionEvent);
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.mStartX = (int) motionEvent.getX();
                    this.mStartY = (int) motionEvent.getY();
                    return false;
                }
                if (action != 1) {
                    if (action == 2) {
                        if (AiMenuResultViewRecognizedHw.this.mIsReadyDND && !AiMenuResultViewRecognizedHw.this.mIsStartedDND) {
                            int x = (int) (motionEvent.getX() - this.mStartX);
                            int y2 = (int) (motionEvent.getY() - this.mStartY);
                            if ((y2 * y2) + (x * x) > i) {
                                AiMenuResultViewRecognizedHw.this.mCommonViews.mContract.getPresenter().getHandler().removeCallbacks(AiMenuResultViewRecognizedHw.this.mDragAndDropAction);
                                AiMenuResultViewRecognizedHw.this.mDragAndDropAction.run();
                            }
                        }
                    }
                    return false;
                }
                AiMenuResultViewRecognizedHw.this.mIsReadyDND = false;
                AiMenuResultViewRecognizedHw.this.mIsStartedDND = false;
                return false;
            }
        });
        this.mView.setPreTouchListener(new View.OnTouchListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewRecognizedHw.3
            final GestureDetector gestureDetector;

            {
                this.gestureDetector = new GestureDetector(AiMenuResultViewRecognizedHw.this.mView.getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewRecognizedHw.3.1
                    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                    public void onLongPress(@NonNull MotionEvent motionEvent) {
                        ViewOnTouchListenerC96023 viewOnTouchListenerC96023 = ViewOnTouchListenerC96023.this;
                        onLongClickListener.onLongClick(AiMenuResultViewRecognizedHw.this.mView);
                    }
                });
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                this.gestureDetector.onTouchEvent(motionEvent);
                AiMenuResultViewRecognizedHw.this.mLastTouchPoint = new PointF(motionEvent.getX(), motionEvent.getY());
                if (AiMenuResultViewRecognizedHw.this.mLongClickActionMode != null && motionEvent.getAction() == 0) {
                    AiMenuResultViewRecognizedHw.this.mLongClickActionMode.finish();
                    return false;
                }
                if (!AiMenuResultViewRecognizedHw.this.mIsCursorVisible) {
                    int action = motionEvent.getAction();
                    if (action != 0) {
                        if (action == 1 || action == 3) {
                            AiMenuResultViewRecognizedHw.this.mCommonViews.mContract.getPresenter().getHandler().removeCallbacks(AiMenuResultViewRecognizedHw.this.mDragAndDropAction);
                            return false;
                        }
                    } else if (AiMenuResultViewRecognizedHw.this.mLongClickActionMode != null) {
                        AiMenuResultViewRecognizedHw.this.mLongClickActionMode.finish();
                    }
                }
                return false;
            }
        });
        preventInput();
        initEditMode(view);
        disableSpenToText();
        this.mOriginEditText.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.t
            @Override // android.view.View.OnCreateContextMenuListener
            public final void onCreateContextMenu(ContextMenu contextMenu, View view2, ContextMenu.ContextMenuInfo contextMenuInfo) {
                this.f6975a.lambda$initEditText$2(contextMenu, view2, contextMenuInfo);
            }
        });
        Runnable runnable = this.mUpdateResultTextRunnable;
        if (runnable != null) {
            this.mOriginEditText.post(runnable);
            this.mUpdateResultTextRunnable = null;
        }
    }

    public void initTabletLayout(View view) {
        boolean z = this.mView.getResources().getConfiguration().orientation == 2;
        View viewFindViewById = view.findViewById(C9086R.id.ai_menu_result_viewpager);
        updateLayout(z, viewFindViewById.getMeasuredWidth(), viewFindViewById.getMeasuredHeight());
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public void initView(View view, View view2) {
        RecognizedHw recognizedHw = this.mRecognizedHw;
        if (recognizedHw != null && (view2 instanceof CustomConstraintLayout)) {
            this.mView = (CustomConstraintLayout) view2;
            if (recognizedHw.getSrcContentInfo().getAiBixbyParam().getAction() == 1) {
                new LanguageIdentifier().identifyLanguageAsync("wake up service", null);
            }
            this.mView.setVisibility(0);
            this.mEditViewContainer = (ScrollView) this.mView.findViewById(C9086R.id.edit_text_container);
            initEditText(view2);
            if (setResult() && hasDirectAction()) {
                doDirectAction(this.mRecognizedHw.getSrcContentInfo().getAiBixbyParam().getAction());
                this.mContract.updateResultState();
            }
            initTabletLayout(view);
            initSelectedObjectList();
            initMorePopup();
            String str = this.mFailedMessage;
            if (str != null) {
                onFailed(str);
            }
        }
    }

    public boolean isEditable() {
        return this.mRecognizedHw.isEditable();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public boolean isInitialized() {
        return this.mOriginEditText != null;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.RecognizedHw.ResultListener
    public void onCompleted(boolean z) {
        this.mUpdateResultTextRunnable = new RunnableC9719o(this, 3);
        if (isInitialized()) {
            this.mOriginEditText.post(this.mUpdateResultTextRunnable);
            this.mUpdateResultTextRunnable = null;
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.RecognizedHw.ResultListener
    public void onFailed(String str) {
        if (!isInitialized()) {
            this.mFailedMessage = str;
            return;
        }
        this.mFailedMessage = null;
        this.mCommonViews.hideProgress();
        this.mCommonViews.mErrMsgView.setText(str);
        this.mCommonViews.showErrorMessage();
        this.mCommonViews.getTopView().mSettingBtn.setVisibility(0);
        this.mCommonViews.setTopButtonState(true);
        AiMenuResultTopView topView = this.mCommonViews.getTopView();
        Object[] objArr = {Integer.valueOf(C9086R.string.hw_recognition_language)};
        ArrayList arrayList = new ArrayList(1);
        Object obj = objArr[0];
        topView.updateMorePopupMenu(AbstractC2322a.m1630t(obj, arrayList, obj, arrayList), this.mMorePopupClickListener);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AbsAiActionResultView, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public void onPageSelected() {
        if (isEditable()) {
            AiMenuResultCommonViews aiMenuResultCommonViews = this.mCommonViews;
            ArrayList arrayList = new ArrayList(1);
            Object obj = new Object[]{2}[0];
            Objects.requireNonNull(obj);
            arrayList.add(obj);
            aiMenuResultCommonViews.setTopButtonsVisibility(Collections.unmodifiableList(arrayList));
        } else {
            this.mCommonViews.setTopButtonsVisibility(null);
        }
        this.mCommonViews.getBottomView().setTextMenuVisible(false);
        if (isInitialized()) {
            EditText editText = this.mOriginEditText;
            editText.setSelection(editText.getSelectionStart());
        }
    }

    public void onSaveInstanceState() {
        updateCurrentText();
    }

    public void setNormalModeState() {
        this.mIsCursorVisible = false;
        this.mOriginEditText.setCursorVisible(false);
        this.mOriginEditText.clearFocus();
        ActionMode actionMode = this.mLongClickActionMode;
        if (actionMode != null) {
            actionMode.finish();
        }
        setNullMagnifier();
        AiMenuResultCommonViews aiMenuResultCommonViews = this.mCommonViews;
        ArrayList arrayList = new ArrayList(1);
        Object obj = new Object[]{2}[0];
        Objects.requireNonNull(obj);
        arrayList.add(obj);
        aiMenuResultCommonViews.setTopButtonsVisibility(Collections.unmodifiableList(arrayList));
        this.mEditMenuContainer.setVisibility(8);
        this.mEditMenuContainer.post(new RunnableC9719o(this, 2));
        this.mOriginEditText.setFocusableInTouchMode(false);
        this.mCommonViews.getBottomView().show(true);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public void setTitle() {
        this.mCommonViews.getTopView().setTitle(C9086R.string.ai_convert_to_text, C9086R.drawable.ic_ai_clean_up_as_text, Integer.valueOf(C9086R.color.ai_menu_top_icon_color));
    }

    public void showSettingDialog() {
        this.mRecognizedHw.showSettingDialog();
    }

    public void updateCurrentText() {
        EditText editText = this.mOriginEditText;
        if (editText != null) {
            this.mRecognizedHw.updateSpannableString(editText.getText());
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AbsAiActionResultView
    public void updateHorizontalPadding(int i) {
        if (isInitialized()) {
            int dimensionPixelSize = this.mOriginEditText.getResources().getDimensionPixelSize(C9086R.dimen.ai_menu_result_side_margin_size);
            this.mOriginEditText.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        }
    }
}
