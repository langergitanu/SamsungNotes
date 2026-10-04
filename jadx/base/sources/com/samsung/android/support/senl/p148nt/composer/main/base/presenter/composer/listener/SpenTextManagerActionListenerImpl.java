package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.RectF;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.inputmethod.InputContentInfoCompat;
import androidx.fragment.app.Fragment;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.textspan.SpenHyperTextSpan;
import com.samsung.android.sdk.pen.widget.listener.SpenTextManagerActionListener;
import com.samsung.android.support.senl.p145cm.base.framework.content.ClipboardManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.PermissionCompat;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.info.DragAndDropInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.link.LinkActionHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mde.CoeditAdapter;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.DragAndDropController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ListenerImplContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenTextManagerActionListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SoftInputManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.TaskController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.hashtag.HashTagController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.link.LinkAction;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiCommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskCommitContent;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Restriction;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.common.OptionMenuPopupWindowHelper;
import java.util.List;
import p122b2.RunnableC4180c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SpenTextManagerActionListenerImpl extends SpenTextManagerActionListener {
    private static final String TAG = Logger.createTag("SpenTextManagerActionListenerImpl");
    private final Activity mActivity;
    private final ComposerModel mComposerModel;
    private final ListenerImplContract.IDialogPresenter mDialogPresenterManager;
    private final DragAndDropController mDragAndDropController;
    private DragAndDropInfo mDragAndDropInfo;
    private final HashTagController mHashTagPresenter;
    private final HyperTextPopupMenu mHyperTextPopupMenu = new HyperTextPopupMenu();
    private final ObjectManager mObjectManager;
    private OnBeforeTextChangedByKeyboardListener mOnBeforeTextChangedByKeyboardListener;
    private final PageManager mPageManager;
    private final ListenerImplContract.IPresenter mPresenter;
    private SoftInputManager mSoftInputManager;
    private final TaskController mTaskController;
    protected final TextManager mTextManager;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class HyperTextAction {
        String displayText;
        String hypertext;
        int hypertextType;

        @Nullable
        SpenObjectShape object;

        @Nullable
        SpenHyperTextSpan span;

        @Nullable
        PointF touchPoint;

        public HyperTextAction(String str, int i, @Nullable SpenObjectShape spenObjectShape, @Nullable SpenHyperTextSpan spenHyperTextSpan, @Nullable PointF pointF) {
            Logger.m10999d(SpenTextManagerActionListenerImpl.TAG, "HyperTextAction# hypertext : " + Logger.getEncode(str));
            this.displayText = str;
            this.hypertext = LinkActionHelper.getHiddenLink(spenHyperTextSpan, str);
            this.hypertextType = i;
            this.object = spenObjectShape;
            this.span = spenHyperTextSpan;
            this.touchPoint = pointF;
        }

        public void copyHyperText(Context context) {
            Logger.m10999d(SpenTextManagerActionListenerImpl.TAG, "copyHyperText# hypertext :" + Logger.getEncode(this.hypertext));
            ClipboardManagerCompat.INSTANCE.getInstance().setClip(context, new ClipData.Item(this.hypertext), new String[]{"text/plain"}, "");
        }

        public void openHyperText(Context context) {
            Logger.m10999d(SpenTextManagerActionListenerImpl.TAG, "openHyperText# hypertext : " + Logger.getEncode(this.hypertext));
            if (new LinkAction().startActivityHyperTextByType(context, this.hypertext, this.hypertextType)) {
                return;
            }
            ToastHandler.show(context, DeviceUtils.isPhoneModel() ? C9086R.string.link_not_support_phone_message : C9086R.string.link_not_support_table_message, 0);
            if (this.object == null || this.span == null) {
                return;
            }
            Logger.m11003i(SpenTextManagerActionListenerImpl.TAG, "onHyperTextClicked# removeTextSpan:" + this.hypertext);
            this.object.removeTextSpan(this.span);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class HyperTextPopupMenu {
        private View mCopyLinkBtn;
        private ListenerImplContract.IDialogPresenter mDialogPresenterManager;
        private PopupWindow mPopupWindow;
        private TextManager mTextManager;

        /* JADX INFO: Access modifiers changed from: private */
        public void hideMenu() {
            PopupWindow popupWindow = this.mPopupWindow;
            if (popupWindow != null) {
                popupWindow.dismiss();
                this.mPopupWindow = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$makeHyperTextPopupMenu$0(HyperTextAction hyperTextAction, View view) {
            hyperTextAction.copyHyperText(view.getContext());
            hideMenu();
            ComposerSA.insertLog(ComposerSAConstants.SCREEN_COMPOSER, ComposerSAConstants.EVENT_HYPERLINK_COPY);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$makeHyperTextPopupMenu$1(HyperTextAction hyperTextAction, View view) {
            hyperTextAction.openHyperText(view.getContext());
            hideMenu();
            ComposerSA.insertLog(ComposerSAConstants.SCREEN_COMPOSER, ComposerSAConstants.EVENT_HYPERLINK_OPEN_LINK);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$makeHyperTextPopupMenu$2(HyperTextAction hyperTextAction, View view) {
            hideMenu();
            this.mDialogPresenterManager.showLinkEditDialog(hyperTextAction.displayText, hyperTextAction.span, false, false);
            ComposerSA.insertLog(ComposerSAConstants.SCREEN_COMPOSER, ComposerSAConstants.EVENT_HYPERLINK_EDIT_LINK_ADDRESS);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$makeHyperTextPopupMenu$3(HyperTextAction hyperTextAction, View view) {
            hideMenu();
            this.mDialogPresenterManager.showLinkEditDialog(hyperTextAction.displayText, hyperTextAction.span, true, false);
            if (TextUtils.equals(hyperTextAction.displayText, hyperTextAction.hypertext)) {
                ComposerSA.insertLog(ComposerSAConstants.SCREEN_COMPOSER, ComposerSAConstants.EVENT_HYPERLINK_EDIT_TEXT, "1");
            } else {
                ComposerSA.insertLog(ComposerSAConstants.SCREEN_COMPOSER, ComposerSAConstants.EVENT_HYPERLINK_EDIT_TEXT, "2");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$makeHyperTextPopupMenu$4(HyperTextAction hyperTextAction, View view) {
            hideMenu();
            this.mTextManager.getTextBox().removeTextSpan(hyperTextAction.span);
        }

        private PopupWindow makeHyperTextPopupMenu(Activity activity, final HyperTextAction hyperTextAction) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(activity).inflate(C9086R.layout.comp_popup_hyper_text_menu, (ViewGroup) null, false);
            View viewFindViewById = viewGroup.findViewById(C9086R.id.link_text_container);
            TextView textView = (TextView) viewGroup.findViewById(C9086R.id.link_text);
            if (FeatureInfo.isSupportHyperLinkEdit() && hyperTextAction.hypertextType == 3 && !TextUtils.equals(hyperTextAction.displayText, hyperTextAction.hypertext)) {
                textView.setText(hyperTextAction.hypertext);
                viewFindViewById.setVisibility(0);
            } else {
                viewFindViewById.setVisibility(8);
            }
            View viewFindViewById2 = viewGroup.findViewById(C9086R.id.copy_link_btn);
            this.mCopyLinkBtn = viewFindViewById2;
            final int i = 0;
            viewFindViewById2.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.c

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ SpenTextManagerActionListenerImpl.HyperTextPopupMenu f6786b;

                {
                    this.f6786b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i) {
                        case 0:
                            this.f6786b.lambda$makeHyperTextPopupMenu$0(hyperTextAction, view);
                            break;
                        case 1:
                            this.f6786b.lambda$makeHyperTextPopupMenu$1(hyperTextAction, view);
                            break;
                        case 2:
                            this.f6786b.lambda$makeHyperTextPopupMenu$2(hyperTextAction, view);
                            break;
                        case 3:
                            this.f6786b.lambda$makeHyperTextPopupMenu$3(hyperTextAction, view);
                            break;
                        default:
                            this.f6786b.lambda$makeHyperTextPopupMenu$4(hyperTextAction, view);
                            break;
                    }
                }
            });
            final int i2 = 1;
            viewGroup.findViewById(C9086R.id.open_link_btn).setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.c

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ SpenTextManagerActionListenerImpl.HyperTextPopupMenu f6786b;

                {
                    this.f6786b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i2) {
                        case 0:
                            this.f6786b.lambda$makeHyperTextPopupMenu$0(hyperTextAction, view);
                            break;
                        case 1:
                            this.f6786b.lambda$makeHyperTextPopupMenu$1(hyperTextAction, view);
                            break;
                        case 2:
                            this.f6786b.lambda$makeHyperTextPopupMenu$2(hyperTextAction, view);
                            break;
                        case 3:
                            this.f6786b.lambda$makeHyperTextPopupMenu$3(hyperTextAction, view);
                            break;
                        default:
                            this.f6786b.lambda$makeHyperTextPopupMenu$4(hyperTextAction, view);
                            break;
                    }
                }
            });
            View viewFindViewById3 = viewGroup.findViewById(C9086R.id.edit_link_btn);
            if (FeatureInfo.isSupportHyperLinkEdit() && hyperTextAction.hypertextType == 3) {
                final int i4 = 2;
                viewFindViewById3.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.c

                    /* JADX INFO: renamed from: b */
                    public final /* synthetic */ SpenTextManagerActionListenerImpl.HyperTextPopupMenu f6786b;

                    {
                        this.f6786b = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        switch (i4) {
                            case 0:
                                this.f6786b.lambda$makeHyperTextPopupMenu$0(hyperTextAction, view);
                                break;
                            case 1:
                                this.f6786b.lambda$makeHyperTextPopupMenu$1(hyperTextAction, view);
                                break;
                            case 2:
                                this.f6786b.lambda$makeHyperTextPopupMenu$2(hyperTextAction, view);
                                break;
                            case 3:
                                this.f6786b.lambda$makeHyperTextPopupMenu$3(hyperTextAction, view);
                                break;
                            default:
                                this.f6786b.lambda$makeHyperTextPopupMenu$4(hyperTextAction, view);
                                break;
                        }
                    }
                });
                viewFindViewById3.setVisibility(0);
            } else {
                viewFindViewById3.setVisibility(8);
            }
            View viewFindViewById4 = viewGroup.findViewById(C9086R.id.edit_text_btn);
            TextView textView2 = (TextView) viewGroup.findViewById(C9086R.id.edit_text);
            if (FeatureInfo.isSupportHyperLinkEdit() && hyperTextAction.hypertextType == 3) {
                final int i5 = 3;
                viewFindViewById4.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.c

                    /* JADX INFO: renamed from: b */
                    public final /* synthetic */ SpenTextManagerActionListenerImpl.HyperTextPopupMenu f6786b;

                    {
                        this.f6786b = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        switch (i5) {
                            case 0:
                                this.f6786b.lambda$makeHyperTextPopupMenu$0(hyperTextAction, view);
                                break;
                            case 1:
                                this.f6786b.lambda$makeHyperTextPopupMenu$1(hyperTextAction, view);
                                break;
                            case 2:
                                this.f6786b.lambda$makeHyperTextPopupMenu$2(hyperTextAction, view);
                                break;
                            case 3:
                                this.f6786b.lambda$makeHyperTextPopupMenu$3(hyperTextAction, view);
                                break;
                            default:
                                this.f6786b.lambda$makeHyperTextPopupMenu$4(hyperTextAction, view);
                                break;
                        }
                    }
                });
                if (TextUtils.equals(hyperTextAction.displayText, hyperTextAction.hypertext)) {
                    textView2.setText(C9086R.string.convert_to_text_link);
                } else {
                    textView2.setText(C9086R.string.toolbar_edit_text);
                }
                viewFindViewById4.setVisibility(0);
            } else {
                viewFindViewById4.setVisibility(8);
            }
            View viewFindViewById5 = viewGroup.findViewById(C9086R.id.remove_link_btn);
            if (FeatureInfo.isSupportHyperLinkEdit() && hyperTextAction.hypertextType == 3) {
                final int i6 = 4;
                viewFindViewById5.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.c

                    /* JADX INFO: renamed from: b */
                    public final /* synthetic */ SpenTextManagerActionListenerImpl.HyperTextPopupMenu f6786b;

                    {
                        this.f6786b = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        switch (i6) {
                            case 0:
                                this.f6786b.lambda$makeHyperTextPopupMenu$0(hyperTextAction, view);
                                break;
                            case 1:
                                this.f6786b.lambda$makeHyperTextPopupMenu$1(hyperTextAction, view);
                                break;
                            case 2:
                                this.f6786b.lambda$makeHyperTextPopupMenu$2(hyperTextAction, view);
                                break;
                            case 3:
                                this.f6786b.lambda$makeHyperTextPopupMenu$3(hyperTextAction, view);
                                break;
                            default:
                                this.f6786b.lambda$makeHyperTextPopupMenu$4(hyperTextAction, view);
                                break;
                        }
                    }
                });
                viewFindViewById5.setVisibility(0);
            } else {
                viewFindViewById5.setVisibility(8);
            }
            PopupWindow popupWindow = new PopupWindow(viewGroup, -2, -2);
            OptionMenuPopupWindowHelper.setDefaultState(popupWindow, viewGroup.getContext());
            return popupWindow;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void showMenu(Activity activity, ListenerImplContract.IPresenter iPresenter, ListenerImplContract.IDialogPresenter iDialogPresenter, HyperTextAction hyperTextAction) {
            Logger.m11003i(SpenTextManagerActionListenerImpl.TAG, "LinkEdit#showMenu# HyperTextAction hyperTextType: " + hyperTextAction.hypertextType + ", displayText: " + hyperTextAction.displayText + ", hyperText: " + hyperTextAction.hypertext + ", span.start: " + hyperTextAction.span.getStart() + ", span.end: " + hyperTextAction.span.getEnd() + ", span.customData: " + hyperTextAction.span.getCustomData());
            this.mDialogPresenterManager = iDialogPresenter;
            this.mTextManager = iPresenter.getTextManager();
            PopupWindow popupWindow = this.mPopupWindow;
            if (popupWindow == null) {
                this.mPopupWindow = makeHyperTextPopupMenu(activity, hyperTextAction);
            } else if (popupWindow.isShowing()) {
                this.mPopupWindow.dismiss();
                this.mPopupWindow = makeHyperTextPopupMenu(activity, hyperTextAction);
            } else {
                hideMenu();
                this.mPopupWindow = makeHyperTextPopupMenu(activity, hyperTextAction);
            }
            updateMenuWidth();
            this.mPopupWindow.getContentView().measure(0, 0);
            int measuredWidth = this.mPopupWindow.getContentView().getMeasuredWidth() / 2;
            PopupWindow popupWindow2 = this.mPopupWindow;
            View view = iPresenter.getView();
            PointF pointF = hyperTextAction.touchPoint;
            popupWindow2.showAtLocation(view, 0, pointF != null ? ((int) pointF.x) - measuredWidth : 0, pointF != null ? (int) pointF.y : 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateContainerWidth() {
            PopupWindow popupWindow = this.mPopupWindow;
            if (popupWindow == null) {
                return;
            }
            ViewGroup viewGroup = (ViewGroup) popupWindow.getContentView().findViewById(C9086R.id.comp_popup_hyper_text_menu_inner_container);
            int childCount = viewGroup.getChildCount();
            int measuredWidth = this.mPopupWindow.getContentView().getMeasuredWidth();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    measuredWidth = Math.max(measuredWidth, childAt.getMeasuredWidth());
                }
            }
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt2 = viewGroup.getChildAt(i2);
                if (childAt2.getVisibility() == 0 && childAt2.getMeasuredWidth() < measuredWidth) {
                    ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                    layoutParams.width = measuredWidth;
                    childAt2.setLayoutParams(layoutParams);
                }
            }
        }

        private void updateMenuWidth() {
            View view = this.mCopyLinkBtn;
            if (view == null) {
                return;
            }
            if (view.isLaidOut()) {
                updateContainerWidth();
            } else {
                this.mCopyLinkBtn.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.SpenTextManagerActionListenerImpl.HyperTextPopupMenu.1
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        if (HyperTextPopupMenu.this.mCopyLinkBtn.getMeasuredWidth() > 0) {
                            HyperTextPopupMenu.this.mCopyLinkBtn.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            HyperTextPopupMenu.this.updateContainerWidth();
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnBeforeTextChangedByKeyboardListener {
        void onTyping();
    }

    public SpenTextManagerActionListenerImpl(ListenerImplContract.IPresenter iPresenter, ControllerManager controllerManager, DragAndDropController dragAndDropController) {
        this.mPresenter = iPresenter;
        this.mActivity = iPresenter.getActivity();
        this.mObjectManager = iPresenter.getObjectManager();
        this.mTextManager = iPresenter.getTextManager();
        this.mHashTagPresenter = controllerManager.getHashTagController();
        this.mTaskController = controllerManager.getTaskController();
        this.mPageManager = iPresenter.getPageManager();
        this.mDialogPresenterManager = iPresenter.getDialogPresenterManager();
        this.mDragAndDropController = dragAndDropController;
        this.mSoftInputManager = controllerManager.getSoftInputManager();
        this.mComposerModel = iPresenter.getComposerModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onHyperTextClickedWithRectAndPoint$1(HyperTextAction hyperTextAction) {
        hyperTextAction.openHyperText(this.mActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showOpenLink$0(SpenHyperTextSpan spenHyperTextSpan, String str, int i, SpenObjectShape spenObjectShape) {
        String hiddenLink = LinkActionHelper.getHiddenLink(spenHyperTextSpan, str);
        if (new LinkAction().startActivityHyperTextByType(this.mActivity, hiddenLink, i)) {
            return;
        }
        ToastHandler.show(this.mActivity, DeviceUtils.isPhoneModel() ? C9086R.string.link_not_support_phone_message : C9086R.string.link_not_support_table_message, 0);
        if (spenObjectShape == null || spenHyperTextSpan == null) {
            return;
        }
        Logger.m11003i(TAG, "onHyperTextClicked# removeTextSpan:" + Logger.getEncode(hiddenLink));
        spenObjectShape.removeTextSpan(spenHyperTextSpan);
    }

    private void showOpenLink(String str, int i, @Nullable SpenObjectShape spenObjectShape, @Nullable SpenHyperTextSpan spenHyperTextSpan) {
        RunnableC4180c runnableC4180c = new RunnableC4180c(this, spenHyperTextSpan, str, i, spenObjectShape);
        if (this.mComposerModel.getModeManager().isMode(Mode.ReadOnly) && this.mComposerModel.getVoiceModel().isPlayingVoiceData() && this.mComposerModel.getVoiceModel().getMSyncEnabled()) {
            this.mDialogPresenterManager.showOpenLinkPopup(runnableC4180c);
        } else {
            runnableC4180c.run();
        }
    }

    @Override // com.samsung.android.sdk.pen.widget.listener.SpenTextManagerActionListener
    public void onBeforeTextChangedByKeyBoard() {
        OnBeforeTextChangedByKeyboardListener onBeforeTextChangedByKeyboardListener = this.mOnBeforeTextChangedByKeyboardListener;
        if (onBeforeTextChangedByKeyboardListener != null) {
            onBeforeTextChangedByKeyboardListener.onTyping();
        }
    }

    @Override // com.samsung.android.sdk.pen.widget.listener.SpenTextManagerActionListener
    public void onCommitContent(InputContentInfoCompat inputContentInfoCompat) {
        if (inputContentInfoCompat == null) {
            Logger.m11004w(TAG, "onCommitContent : inputContentInfo is null");
            return;
        }
        if (this.mObjectManager.getConstraintManager().getThumbnailCount() >= this.mObjectManager.getConstraintManager().getThumbnailMaxCount()) {
            Logger.m11004w(TAG, "Thumbnail is not addable");
            ToastHandler.show(this.mActivity, this.mActivity.getResources().getString(C9086R.string.composer_unable_to_insert_more_than, Integer.valueOf(this.mObjectManager.getConstraintManager().getThumbnailMaxCount())), 1);
            return;
        }
        if (this.mComposerModel.getMdeManager().getCoeditAdapter().isCoeditNote() && this.mComposerModel.getComposerSpenDocModel().getLargeSizeItemsCount() >= 100) {
            Restriction.showToastCoeditErrorOverLargeMaxCount(this.mActivity);
            return;
        }
        Uri contentUri = inputContentInfoCompat.getContentUri();
        List<String> pathSegments = contentUri.getPathSegments();
        TaskCommitContent.InputValues inputValues = new TaskCommitContent.InputValues(this.mActivity, this.mObjectManager, this.mPageManager, inputContentInfoCompat);
        TaskCommitContent taskCommitContent = new TaskCommitContent();
        if (pathSegments.contains("external")) {
            String str = TAG;
            Logger.m11004w(str, "uri is " + Logger.getEncode(contentUri.getPath()));
            String[] storagePermissions = PermissionCompat.getStoragePermissions(1);
            if (!PermissionHelper.isPermissionGrantedWithoutNotice(this.mActivity, storagePermissions)) {
                Logger.m10999d(str, "to get READ_EXTERNAL_STORAGE permission");
                Fragment fragmentFindFragmentByTag = ((AppCompatActivity) this.mActivity).getSupportFragmentManager().findFragmentByTag("Composer");
                if (fragmentFindFragmentByTag != null) {
                    PermissionHelper.requestPermissions(fragmentFindFragmentByTag, 112, storagePermissions);
                    this.mTaskController.setPendingTask(taskCommitContent, inputValues, taskCommitContent.getDefaultCallback(), false);
                    return;
                }
                return;
            }
        }
        this.mTaskController.execute(taskCommitContent, inputValues, taskCommitContent.getDefaultCallback(), false);
    }

    @Override // com.samsung.android.sdk.pen.widget.listener.SpenTextManagerActionListener
    public void onHashTagAdded(String str) {
        Logger.m10999d(TAG, "onHashTagAdded#");
        this.mHashTagPresenter.onHashTagAdded(str, true);
        super.onHashTagAdded(str);
    }

    @Override // com.samsung.android.sdk.pen.widget.listener.SpenTextManagerActionListener
    public void onHyperTextClicked(@NonNull String str, int i, int i2, @Nullable SpenObjectShape spenObjectShape, @Nullable SpenHyperTextSpan spenHyperTextSpan) {
        showOpenLink(str, i, spenObjectShape, spenHyperTextSpan);
    }

    @Override // com.samsung.android.sdk.pen.widget.listener.SpenTextManagerActionListener
    public void onHyperTextClickedWithRectAndPoint(@NonNull String str, int i, int i2, @Nullable SpenObjectShape spenObjectShape, @Nullable SpenHyperTextSpan spenHyperTextSpan, @NonNull RectF rectF, @NonNull PointF pointF) {
        String str2 = TAG;
        Logger.m10999d(str2, "onHyperTextClickedWithRectAndPoint# hypertext : " + Logger.getEncode(str));
        PointF pointFConvertContentPointIntoViewPoint = this.mObjectManager.getNoteZoomScroller().convertContentPointIntoViewPoint(pointF);
        int cursorIndex = this.mTextManager.getCursorIndex(spenObjectShape, pointF);
        final HyperTextAction hyperTextAction = new HyperTextAction(str, i, spenObjectShape, spenHyperTextSpan, pointFConvertContentPointIntoViewPoint);
        ModeManager modeManager = this.mComposerModel.getModeManager();
        Mode mode = Mode.ReadOnly;
        if (modeManager.isMode(mode) && this.mComposerModel.getVoiceModel().isPlayingVoiceData() && this.mComposerModel.getVoiceModel().getMSyncEnabled()) {
            this.mDialogPresenterManager.showOpenLinkPopup(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.b
                @Override // java.lang.Runnable
                public final void run() {
                    this.f6783a.lambda$onHyperTextClickedWithRectAndPoint$1(hyperTextAction);
                }
            });
            return;
        }
        Logger.m10999d(str2, "onHyperTextClickedWithRectAndPoint# showMenu rect : " + rectF.left + " / " + rectF.top + " / " + rectF.right + " / " + rectF.bottom + ", touchPoint : " + pointF.x + " / " + pointF.y + ", touchedPoint : " + pointFConvertContentPointIntoViewPoint.x + " / " + pointFConvertContentPointIntoViewPoint.y + ", touchedIndex : " + cursorIndex);
        if (this.mComposerModel.getModeManager().isMode(mode)) {
            showOpenLink(str, i, spenObjectShape, spenHyperTextSpan);
            ComposerSA.insertLog(ComposerSAConstants.SCREEN_COMPOSER, ComposerSAConstants.EVENT_HYPERLINK_ACTIVATED, "2");
        } else {
            if (FeatureInfo.isSupportHyperTextInEditMode()) {
                this.mHyperTextPopupMenu.showMenu(this.mActivity, this.mPresenter, this.mDialogPresenterManager, hyperTextAction);
                ComposerSA.insertLog(ComposerSAConstants.SCREEN_COMPOSER, ComposerSAConstants.EVENT_HYPERLINK_ACTIVATED, "1");
                return;
            }
            this.mPresenter.getObjectManager().getSelectedObjectManager().selectObject(this.mPresenter.getDoc().getBodyText());
            this.mPresenter.getObjectManager().getSelectedObjectManager().setFocus(true);
            this.mPresenter.getTextManager().setCursorBlink(true);
            spenObjectShape.setCursorPosition(Math.max(cursorIndex, 0));
            ((InputMethodManager) this.mActivity.getWindow().getContext().getSystemService("input_method")).showSoftInput(this.mPresenter.getView(), 1);
        }
    }

    @Override // com.samsung.android.sdk.pen.widget.listener.SpenTextManagerActionListener
    public void onItemClicked(SpenObjectShape spenObjectShape, int i, int i2) {
        SoftInputManager softInputManager;
        if (i == 1) {
            if (this.mActivity.isInMultiWindowMode() && (softInputManager = this.mSoftInputManager) != null) {
                softInputManager.hide((View) null);
            }
            this.mDialogPresenterManager.showTextBoxMoreDialog(spenObjectShape);
            return;
        }
        if (i == 2 && this.mComposerModel.getMdeInfo().hasWritePermission()) {
            CoeditAdapter coeditAdapter = this.mComposerModel.getCoeditAdapter();
            if (this.mComposerModel.getMdeManager().getCoeditAdapter().isCoeditNote() && this.mComposerModel.getModeManager().isComposerViewMode() && !coeditAdapter.takeServerWritePermission()) {
                return;
            }
            this.mTextManager.setTodoState(spenObjectShape, i2);
            this.mObjectManager.commitHistory();
        }
    }

    @Override // com.samsung.android.sdk.pen.widget.listener.SpenTextManagerActionListener
    public void onMaxSelectionTextLengthReached() {
        Activity activity = this.mActivity;
        AiCommonUtil.showCustomToast(activity, activity.getResources().getString(C9086R.string.ai_error_cannot_select_more_maximum_characters));
        ComposerSA.insertLog("401", ComposerSAConstants.EVENT_AI_MAX_LENGTH_TO_SELECT_TEXT, "a");
    }

    @Override // com.samsung.android.sdk.pen.widget.listener.SpenTextManagerActionListener
    public void onSelectionAreaLongPressed() {
        Logger.m10999d(TAG, "onSelectionAreaLongPressed#");
        this.mDragAndDropController.executeDragAndDrop(this.mDragAndDropInfo);
    }

    public void release() {
        DragAndDropController dragAndDropController = this.mDragAndDropController;
        if (dragAndDropController != null) {
            dragAndDropController.release();
        }
        this.mHyperTextPopupMenu.hideMenu();
        this.mOnBeforeTextChangedByKeyboardListener = null;
        this.mSoftInputManager = null;
    }

    public void setDragAndDropInfo(DragAndDropInfo dragAndDropInfo) {
        this.mDragAndDropInfo = dragAndDropInfo;
    }

    public void setOnBeforeTextChangedByKeyboardListener(OnBeforeTextChangedByKeyboardListener onBeforeTextChangedByKeyboardListener) {
        this.mOnBeforeTextChangedByKeyboardListener = onBeforeTextChangedByKeyboardListener;
    }
}
