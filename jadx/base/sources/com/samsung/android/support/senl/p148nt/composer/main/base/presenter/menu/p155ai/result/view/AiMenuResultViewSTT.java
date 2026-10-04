package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.DragEvent;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.FragmentManager;
import androidx.glance.AbstractC2821a;
import androidx.recyclerview.widget.RecyclerView;
import androidx.work.impl.RunnableC4054d;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.tabs.TabLayout;
import com.samsung.android.sdk.composer.voice.VoiceManager;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.SCSOperator;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.Features;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.dialog.AiDisclaimerDialog;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.common.view.penrecyclerview.BasePenRecyclerView;
import com.samsung.android.support.senl.p148nt.base.winset.app.language.AiLanguageHelper;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.coedit.utils.CoeditUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiCommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiViewUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AiMenuContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AiMenuResultViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.ResultOperation;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.STTTabletLayoutAction;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.STTTranslation;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AiContextMenuSTTLongPressPopup;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AiContextMenuSTTPopup;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AiMenuResultBottomView;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AiMenuResultViewSTTVoiceListPopup;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.voice.AIGuidingLightEffect;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerRequestCode;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog.SelectTranslateLanguageDialog;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.stt.ISTTWindow;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.stt.base.audio.FastConvertController;
import com.samsung.android.support.senl.p148nt.stt.base.model.mode.STTMode;
import com.samsung.android.support.senl.p148nt.stt.common.constant.STTConstant;
import com.samsung.android.support.senl.p148nt.stt.presenter.AiMenuSTTProcessListener;
import com.samsung.android.support.senl.p148nt.stt.presenter.STTPresenter;
import com.samsung.android.support.senl.p148nt.stt.view.AiSTTListView;
import com.sun.imageio.plugins.jpeg.JPEG;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import p001A.AbstractC0000a;
import p012C1.RunnableC0050f;
import p079T.RunnableC0284b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiMenuResultViewSTT extends AbsAiActionResultView implements AiMenuSTTProcessListener, AiMenuContract.STTTranslateResultListener {
    private static final String TAG = Logger.createTag("AiMenuResultViewSTT", AiConstants.PREFIX_TAG);
    private final Runnable dragDropRunnable;
    private boolean isShowingLightEffect;
    private AiMenuResultBottomView.AddToListPopup mAddToListPopup;
    private AiContextMenuSTTPopup mAiContextMenuPopup;
    private AiContextMenuSTTLongPressPopup mAiContextMenuSTTLongPressPopup;
    private AiSTTListView mAiSTTListView;
    private BroadcastReceiver mBroadcastAddedReceiver;
    private BroadcastReceiver mBroadcastRemovedReceiver;
    private View mCancelAutoTranscribeBtn;
    private int mContextCurrentIndex;
    private int mContextCurrentPos;
    private View mCopyBtn;
    private String mCurrentShowingSession;
    private View mDeleteBtn;
    private int mDistance;
    private int mDragDistanceThreshold;
    private final View.OnClickListener mDropDownListListener;
    private TextView mFromTextView;
    private View mFromView;
    private View.OnClickListener mFromViewListener;
    private GestureDetector mGestureDetector;
    private AiMenuContract.IAiActionSTTResultContainer mIAiActionSTTResultContainer;
    private ISTTWindow.IAIContract mIAiSTTContract;
    boolean mIsFold;
    private boolean mIsNeedCheckLanguage;
    private boolean mIsPendingDragDropAction;
    private boolean mIsRequestedDownloadLanguage;
    private boolean mIsStartedDragDropAction;
    private final AiMenuResultViewPresenter mMenuResultViewPresenter;
    private RecyclerView.OnItemTouchListener mOnItemTouchListener;
    private int mOrientation;
    private View mSTTInfoView;
    private STTTabletLayoutAction mSTTTabletLayoutAction;
    private STTTranslation mSTTTranslation;
    private AiMenuResultViewSTTVoiceListPopup mSTTVoiceListPopup;
    private View mShareBtn;
    private int mStartDragX;
    private int mStartDragY;
    private ImageView mSwitchLanguageBtn;
    private View.OnClickListener mSwitchLanguageListener;
    private TextView mToTextView;
    private View mToView;
    private View.OnClickListener mToViewListener;
    private View.OnClickListener mTranslatingListener;
    private LottieAnimationView mTranslationAutoDetecting;
    private View mTranslationSelectorLayout;
    private final Runnable mUpdateLayoutRunnable;
    private View mView;
    private ConstraintLayout mViewAutoTranscribe;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTT$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class RunnableC96051 implements Runnable {
        public RunnableC96051() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean lambda$run$0(View view, DragEvent dragEvent) {
            int action = dragEvent.getAction();
            if (action == 1) {
                Logger.m10999d(AiMenuResultViewSTT.TAG, "event ACTION_DRAG_STARTED");
                AiMenuResultViewSTT.this.mIsStartedDragDropAction = true;
                return true;
            }
            if (action == 4) {
                Logger.m10999d(AiMenuResultViewSTT.TAG, "event ACTION_DRAG_ENDED");
                AiMenuResultViewSTT.this.mIsStartedDragDropAction = false;
                return true;
            }
            if (action == 5) {
                Logger.m10999d(AiMenuResultViewSTT.TAG, "event ACTION_DRAG_ENTERED");
                return true;
            }
            if (action != 6) {
                Logger.m10999d(AiMenuResultViewSTT.TAG, "onDrag# event default");
                return true;
            }
            Logger.m10999d(AiMenuResultViewSTT.TAG, "event ACTION_DRAG_EXITED");
            AiMenuResultViewSTT.this.mMenuResultViewPresenter.getComposerViewPresenter().getView().setFocusable(true);
            AiMenuResultViewSTT.this.mMenuResultViewPresenter.getComposerViewPresenter().getView().setFocusableInTouchMode(true);
            AiMenuResultViewSTT.this.mMenuResultViewPresenter.getComposerViewPresenter().getView().requestFocus();
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AiMenuResultViewSTT.this.mView == null || AiMenuResultViewSTT.this.mAiSTTListView == null || AiMenuResultViewSTT.this.mMenuResultViewPresenter == null || AiMenuResultViewSTT.this.mSTTTabletLayoutAction == null || AiMenuResultViewSTT.this.mAiContextMenuSTTLongPressPopup == null) {
                Logger.m11000e(AiMenuResultViewSTT.TAG, "dragDropRunnable# null object");
                return;
            }
            if (AiMenuResultViewSTT.this.mIAiSTTContract == null || AiMenuResultViewSTT.this.mIAiSTTContract.getMSTTPresenter().getCurrentMode() != STTMode.SEARCH) {
                AiMenuResultViewSTT.this.mIsPendingDragDropAction = false;
                ViewCompat.getInstance().performHapticFeedback(AiMenuResultViewSTT.this.mView, 110);
                AiMenuResultViewSTT.this.mMenuResultViewPresenter.startDragAndDrop(AiMenuResultViewSTT.this.mView, AiMenuResultViewSTT.this.mSTTTabletLayoutAction.getResultToCopy());
                if (AiViewUtils.isSupportFloatingLayout()) {
                    AiMenuResultViewSTT.this.mView.setFocusable(false);
                    AiMenuResultViewSTT.this.mMenuResultViewPresenter.getComposerViewPresenter().getView().requestFocus();
                } else {
                    AiMenuResultViewSTT.this.mView.setOnDragListener(new View.OnDragListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.C
                        @Override // android.view.View.OnDragListener
                        public final boolean onDrag(View view, DragEvent dragEvent) {
                            return this.f6913a.lambda$run$0(view, dragEvent);
                        }
                    });
                }
                AiMenuResultViewSTT.this.mAiContextMenuSTTLongPressPopup.dismiss();
            }
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTT$14 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C961014 implements AiContextMenuSTTPopup.OnClickListener {
        public C961014() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onClickAddToNode$0(ResultOperation.AddTo addTo) {
            AiMenuResultViewSTT.this.mAddToListPopup.hide();
            AiMenuResultViewSTT.this.mMenuResultViewPresenter.addTo(AiMenuResultViewSTT.this.mMenuResultViewPresenter.getSTTTabletLayoutAction(), addTo);
            AiMenuResultViewSTT.this.mCommonViews.mContract.close();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiContextMenuSTTPopup.OnClickListener
        public void onClickAddToNode() {
            if (!AiMenuResultViewSTT.this.mMenuResultViewPresenter.canEditBodyText()) {
                AiMenuResultViewSTT.this.mMenuResultViewPresenter.addTo(AiMenuResultViewSTT.this.mMenuResultViewPresenter.getSTTTabletLayoutAction(), ResultOperation.AddTo.NewNote);
                AiMenuResultViewSTT.this.mCommonViews.mContract.close();
                return;
            }
            if (AiMenuResultViewSTT.this.mAddToListPopup == null || !AiMenuResultViewSTT.this.mAddToListPopup.isInitialized()) {
                AiMenuResultViewSTT.this.mAddToListPopup = new AiMenuResultBottomView.AddToListPopup();
                AiMenuResultViewSTT.this.mAddToListPopup.setTextSizeInPx(AiMenuResultViewSTT.this.mMenuResultViewPresenter.getActivity().getResources().getDimension(C9086R.dimen.ai_menu_context_item_text_size));
                AiMenuResultViewSTT.this.mAddToListPopup.init(AiMenuResultViewSTT.this.mCommonViews.getTopView().mSTTContextBtn, AiMenuResultViewSTT.this.mMenuResultViewPresenter.isSinglePageNote(), new C9678D(this));
            }
            AiMenuResultViewSTT.this.mAddToListPopup.show();
            ComposerSA.insertLog("816", STTConstant.EVENT_SELECT_MORE_TRANSCRIPT_ADD_TO, "a");
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiContextMenuSTTPopup.OnClickListener
        public void onClickCopy() {
            AiMenuResultViewSTT.this.mMenuResultViewPresenter.copy(AiMenuResultViewSTT.this.mMenuResultViewPresenter.getSTTTabletLayoutAction());
            ComposerSA.insertLog("816", STTConstant.EVENT_SELECT_MORE_TRANSCRIPT_COPY, "a");
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiContextMenuSTTPopup.OnClickListener
        public void onClickEdit() {
            AiMenuResultViewSTT.this.mIAiSTTContract.toggleEditMode();
            ComposerSA.insertLog("816", STTConstant.EVENT_SELECT_EDIT_TRANSCRIPT);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiContextMenuSTTPopup.OnClickListener
        public void onClickRemoveTranscribe() {
            AiMenuResultViewSTT.this.mIAiSTTContract.showRemoveTranscribeDialog();
            ComposerSA.insertLog("816", STTConstant.EVENT_REMOVE_TRANSCRIPT);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiContextMenuSTTPopup.OnClickListener
        public void onClickSearch() {
            AiMenuResultViewSTT.this.mIAiSTTContract.getMSTTPresenter().toggleSTTSearchMode();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiContextMenuSTTPopup.OnClickListener
        public void onClickSpeakerLabel(boolean z) {
            AiMenuResultViewSTT.this.mIAiSTTContract.setShowSpeakerLabel(z);
            if (z) {
                ComposerSA.insertLog("816", STTConstant.EVENT_SELECT_HIDE_SHOW_SPEAKER_LABELS, "b");
            } else {
                ComposerSA.insertLog("816", STTConstant.EVENT_SELECT_HIDE_SHOW_SPEAKER_LABELS, "a");
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiContextMenuSTTPopup.OnClickListener
        public void onClickSummaryStyle() {
            super.onClickSummaryStyle();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiContextMenuSTTPopup.OnClickListener
        public void onClickTranscribeAgain() {
            if (AiMenuResultViewSTT.this.mMenuResultViewPresenter.isShowingSip()) {
                AiMenuResultViewSTT.this.mMenuResultViewPresenter.getSoftInputManager().hide(true);
            }
            AiMenuResultViewSTT.this.mIAiActionSTTResultContainer.executeTranscribeAgain();
            AiMenuResultViewSTT.this.mIAiSTTContract.reConvertCurrentItem(true);
            ComposerSA.insertLog("816", STTConstant.EVENT_SELECT_TRANSCRIBE_AGAIN);
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTT$3 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C96133 extends GestureDetector.SimpleOnGestureListener {
        public C96133() {
        }

        private static int getDiffY(LinearLayout linearLayout, View view) {
            LinearLayout linearLayout2 = (LinearLayout) linearLayout.getParent();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
            int top = view.getTop();
            int i = layoutParams.bottomMargin;
            return linearLayout.getHeight() + top + i + linearLayout2.getPaddingTop();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onLongPress$0(EditText editText) {
            AiMenuResultViewSTT.this.mMenuResultViewPresenter.getSoftInputManager().setTemporarySoftInputMode(16);
            AiMenuResultViewSTT.this.mMenuResultViewPresenter.getSoftInputManager().show(editText);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onLongPress$1(RecyclerView recyclerView, MotionEvent motionEvent) {
            EditText editText;
            View viewFindChildViewUnder = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
            if (viewFindChildViewUnder == null || (editText = (EditText) viewFindChildViewUnder.findViewById(C9086R.id.stt_content_edit)) == null) {
                return;
            }
            if (AiMenuResultViewSTT.this.mContextCurrentIndex >= editText.length()) {
                Logger.m11000e(AiMenuResultViewSTT.TAG, "onLongPress# edit mode - can't find the cursor to focus");
                return;
            }
            editText.requestFocus();
            editText.setSelection(AiMenuResultViewSTT.this.mContextCurrentIndex);
            editText.postDelayed(new RunnableC9735u(this, editText, 1), 200L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onLongPress$2(View view, final RecyclerView recyclerView, final MotionEvent motionEvent, View view2) {
            int id = view2.getId();
            if (id == C9086R.id.edit_mode) {
                AiMenuResultViewSTT.this.mIAiSTTContract.toggleEditMode();
                if (view != null) {
                    recyclerView.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.E
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f6915a.lambda$onLongPress$1(recyclerView, motionEvent);
                        }
                    });
                } else {
                    Logger.m11003i(AiMenuResultViewSTT.TAG, "onItemClick# startEditMode no item");
                }
            } else if (id == C9086R.id.copy_all) {
                AiMenuResultViewSTT.this.mMenuResultViewPresenter.copy(AiMenuResultViewSTT.this.mMenuResultViewPresenter.getSTTTabletLayoutAction());
            } else if (id == C9086R.id.select_block) {
                AiMenuResultViewSTT.this.mIAiSTTContract.getMSTTPresenter().toggleSTTSelectionMode(true);
                if (AiMenuResultViewSTT.this.mContextCurrentPos != -1) {
                    Logger.m10999d(AiMenuResultViewSTT.TAG, "onItemClick#startSelectMode on item " + AiMenuResultViewSTT.this.mContextCurrentPos);
                    AiMenuResultViewSTT.this.mAiSTTListView.setSelected(AiMenuResultViewSTT.this.mContextCurrentPos);
                    AiMenuResultViewSTT.this.mAiSTTListView.notifyItemChanged(AiMenuResultViewSTT.this.mContextCurrentPos);
                }
            }
            AiMenuResultViewSTT.this.mAiContextMenuSTTLongPressPopup.dismiss();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(@NonNull final MotionEvent motionEvent) {
            long j;
            if ((AiMenuResultViewSTT.this.mSTTTranslation.isTranslateMode() && !AiMenuResultViewSTT.this.mSTTTranslation.isCompleted()) || !AiMenuResultViewSTT.this.mSTTTabletLayoutAction.canDoAction()) {
                Logger.m11000e(AiMenuResultViewSTT.TAG, "onLongPress#startDragAndDrop skip " + AiMenuResultViewSTT.this.mSTTTranslation.isTranslateMode() + " " + AiMenuResultViewSTT.this.mSTTTranslation.isCompleted() + " " + AiMenuResultViewSTT.this.mSTTTabletLayoutAction.canDoAction());
                return;
            }
            if (AiMenuResultViewSTT.this.mIAiSTTContract == null || !(AiMenuResultViewSTT.this.mIAiSTTContract.getMSTTPresenter().getCurrentMode() == STTMode.SEARCH || AiMenuResultViewSTT.this.mIAiSTTContract.getMSTTPresenter().getCurrentMode() == STTMode.SEARCH_COMPOSER)) {
                boolean zIsSelectionMode = AiMenuResultViewSTT.this.mAiSTTListView.isSelectionMode();
                if (!zIsSelectionMode) {
                    j = 700;
                } else if (AiMenuResultViewSTT.this.mAiSTTListView.getSelectedItemMap().isEmpty()) {
                    Logger.m11000e(AiMenuResultViewSTT.TAG, "onLongPress# selection mode but no item selected");
                    return;
                } else {
                    Logger.m10999d(AiMenuResultViewSTT.TAG, "onLongPress# selection mode, drop only selected item");
                    j = 0;
                }
                AiMenuResultViewSTT.this.mStartDragX = (int) motionEvent.getX();
                AiMenuResultViewSTT.this.mStartDragY = (int) motionEvent.getY();
                Logger.m10999d(AiMenuResultViewSTT.TAG, "onLongPress# post delay for pending drag and drop action at " + AiMenuResultViewSTT.this.mStartDragX + " " + AiMenuResultViewSTT.this.mStartDragY);
                AiMenuResultViewSTT.this.mIsPendingDragDropAction = true;
                AiMenuResultViewSTT aiMenuResultViewSTT = AiMenuResultViewSTT.this;
                aiMenuResultViewSTT.mHandler.removeCallbacks(aiMenuResultViewSTT.dragDropRunnable);
                AiMenuResultViewSTT aiMenuResultViewSTT2 = AiMenuResultViewSTT.this;
                aiMenuResultViewSTT2.mHandler.postDelayed(aiMenuResultViewSTT2.dragDropRunnable, j);
                if (zIsSelectionMode) {
                    return;
                }
                Logger.m10999d(AiMenuResultViewSTT.TAG, "onLongPress# popup show");
                AiMenuResultViewSTT.this.mContextCurrentPos = -1;
                final BasePenRecyclerView sttRecyclerView = AiMenuResultViewSTT.this.mAiSTTListView.getSttRecyclerView();
                if (sttRecyclerView != null) {
                    final View viewFindChildViewUnder = sttRecyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
                    if (viewFindChildViewUnder != null) {
                        AiMenuResultViewSTT aiMenuResultViewSTT3 = AiMenuResultViewSTT.this;
                        aiMenuResultViewSTT3.mContextCurrentPos = aiMenuResultViewSTT3.mAiSTTListView.getSttRecyclerView().getChildAdapterPosition(viewFindChildViewUnder);
                        TextView textView = (TextView) viewFindChildViewUnder.findViewById(C9086R.id.stt_content);
                        int diffY = getDiffY((LinearLayout) viewFindChildViewUnder.findViewById(C9086R.id.stt_info_layout), viewFindChildViewUnder);
                        AiMenuResultViewSTT.this.mContextCurrentIndex = textView.getOffsetForPosition((int) motionEvent.getX(), Math.max(((int) motionEvent.getY()) - diffY, 0));
                    }
                    AiMenuResultViewSTT aiMenuResultViewSTT4 = AiMenuResultViewSTT.this;
                    aiMenuResultViewSTT4.mAiContextMenuSTTLongPressPopup = new AiContextMenuSTTLongPressPopup((ViewGroup) aiMenuResultViewSTT4.mView, motionEvent.getX(), motionEvent.getY());
                    AiMenuResultViewSTT.this.mAiContextMenuSTTLongPressPopup.setOnItemClickListener(new AiContextMenuSTTLongPressPopup.OnItemClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.F
                        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiContextMenuSTTLongPressPopup.OnItemClickListener
                        public final void onItemClick(View view) {
                            this.f6918a.lambda$onLongPress$2(viewFindChildViewUnder, sttRecyclerView, motionEvent, view);
                        }
                    });
                    ViewCompat.getInstance().performHapticFeedback(AiMenuResultViewSTT.this.mAiSTTListView.getSttRecyclerView(), 110);
                    AiMenuResultViewSTT.this.mAiContextMenuSTTLongPressPopup.show();
                }
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(@NonNull MotionEvent motionEvent) {
            return true;
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTT$9 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C96199 extends BroadcastReceiver {
        public C96199() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onReceive$0() {
            if (AiMenuResultViewSTT.this.mMenuResultViewPresenter == null || AiMenuResultViewSTT.this.mSTTTranslation == null || !AiMenuResultViewSTT.this.mSTTTranslation.isInvalidStatus()) {
                return;
            }
            Logger.m10999d(AiMenuResultViewSTT.TAG, "onReceive# invalid status. Need to check language pack");
            AiMenuResultViewSTT.this.mIsNeedCheckLanguage = true;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (context == null || intent == null || AiMenuResultViewSTT.this.mSTTTranslation == null) {
                Logger.m10999d(AiMenuResultViewSTT.TAG, "removedReceiver# null");
                return;
            }
            String stringExtra = intent.getStringExtra("locale");
            Logger.m11000e(AiMenuResultViewSTT.TAG, "removedReceiver# " + stringExtra);
            AiLanguageHelper.updateLanguageList(new RunnableC9711g(this, 2));
        }
    }

    public AiMenuResultViewSTT(AiMenuResultViewPresenter aiMenuResultViewPresenter, AiMenuResultCommonViews aiMenuResultCommonViews, AiMenuContract.IAiActionSTTResultContainer iAiActionSTTResultContainer) {
        super(aiMenuResultCommonViews);
        this.mIsPendingDragDropAction = false;
        this.mIsStartedDragDropAction = false;
        this.mIsNeedCheckLanguage = false;
        this.mIsRequestedDownloadLanguage = false;
        this.mContextCurrentPos = -1;
        this.mContextCurrentIndex = -1;
        this.isShowingLightEffect = false;
        this.dragDropRunnable = new RunnableC96051();
        this.mUpdateLayoutRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTT.2
            @Override // java.lang.Runnable
            public void run() {
                String str = AiMenuResultViewSTT.TAG;
                StringBuilder sb = new StringBuilder("mUpdateLayoutRunnable#  ");
                sb.append(AiMenuResultViewSTT.this.mViewWidth);
                sb.append(" - ");
                AbstractC8014b.m7221w(sb, str, AiMenuResultViewSTT.this.mViewHeight);
                if (AiMenuResultViewSTT.this.mMenuResultViewPresenter.getSTTTabletLayoutAction() == null) {
                    Logger.m11000e(AiMenuResultViewSTT.TAG, "getSTTTabletLayoutAction null, showing other action");
                    return;
                }
                if (AiMenuResultViewSTT.this.mCommonViews.mViewPager.getCurrentItem() != 0) {
                    Logger.m11000e(AiMenuResultViewSTT.TAG, "mViewPager is not showing current item");
                    return;
                }
                AiMenuResultViewSTT.this.toggleModeBottomMenu();
                AiMenuResultViewSTT.this.updateTitleViewMode();
                AiMenuResultViewSTT.this.updateSelectionBtnState();
                AiMenuResultViewSTT.this.updateTopContainerLayout();
                if (AiMenuResultViewSTT.this.mIAiSTTContract.getMSTTPresenter().isAutoTranscribeItemRunning()) {
                    AiMenuResultViewSTT.this.mCommonViews.getTopView().mTabLayout.setVisibility(8);
                }
            }
        };
        this.mDropDownListListener = new ViewOnClickListenerC9738x(this, 10);
        this.mMenuResultViewPresenter = aiMenuResultViewPresenter;
        this.mOrientation = aiMenuResultViewPresenter.getActivity().getResources().getConfiguration().orientation;
        STTTabletLayoutAction sTTTabletLayoutAction = aiMenuResultViewPresenter.getSTTTabletLayoutAction();
        this.mSTTTabletLayoutAction = sTTTabletLayoutAction;
        if (sTTTabletLayoutAction == null) {
            return;
        }
        STTTranslation sTTTranslation = sTTTabletLayoutAction.getSTTTranslation();
        this.mSTTTranslation = sTTTranslation;
        sTTTranslation.setResultListener(this);
        ISTTWindow.IAIContract iAiSTTContract = this.mSTTTabletLayoutAction.getIAiSTTContract();
        this.mIAiSTTContract = iAiSTTContract;
        this.mCurrentShowingSession = iAiSTTContract.getCurrentConvertSession();
        this.mIAiSTTContract.addAiMenuSTTProcessListener(0, this);
        this.mIAiActionSTTResultContainer = iAiActionSTTResultContainer;
        this.mIsFold = DeviceUtils.isFoldableModel();
    }

    private void disableListViewAccessibility() {
        AiSTTListView aiSTTListView = this.mAiSTTListView;
        if (aiSTTListView == null || aiSTTListView.getSttRecyclerView() == null) {
            return;
        }
        this.mAiSTTListView.getSttRecyclerView().setImportantForAccessibility(4);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean doInitialStep() {
        updateLanguage();
        Locale locale = AiLanguageHelper.getLocale(this.mSTTTranslation.getFromLanguageTag());
        Locale locale2 = AiLanguageHelper.getLocale(this.mSTTTranslation.getToLanguageTag());
        boolean z = false;
        if (locale != null && locale2 != null) {
            int fromLanguageState = this.mSTTTranslation.getFromLanguageState();
            int toLanguageState = this.mSTTTranslation.getToLanguageState();
            String str = TAG;
            AbstractC8014b.m7216r(fromLanguageState, toLanguageState, "doInitialStep# ", " - ", str);
            if (fromLanguageState == 2) {
                showLanguageSelectorDialog(true);
                ToastHandler.show(BaseUtils.getApplicationContext(), C9086R.string.ai_not_supported_from_language, 1);
            } else if (fromLanguageState == 1) {
                if (AiLanguageHelper.requestDownloadLanguagePack(this.mIAiActionSTTResultContainer.getActivity(), locale, locale2, Integer.valueOf(ComposerRequestCode.DownloadLanguage.getId()))) {
                    this.mIsRequestedDownloadLanguage = true;
                }
                if (z) {
                    this.mCommonViews.hideProgress();
                }
            } else {
                if (fromLanguageState == 0) {
                    if (this.mSTTTranslation.isSame()) {
                        Logger.m10999d(str, "doInitialStep# same");
                        showLanguageSelectorDialog(false);
                    } else if (toLanguageState == 1) {
                        if (AiLanguageHelper.requestDownloadLanguagePack(this.mIAiActionSTTResultContainer.getActivity(), locale, locale2, Integer.valueOf(ComposerRequestCode.DownloadLanguage.getId()))) {
                            this.mIsRequestedDownloadLanguage = true;
                        }
                    } else if (toLanguageState == 2) {
                        showLanguageSelectorDialog(false);
                    }
                }
                if (z) {
                }
            }
            z = true;
            if (z) {
            }
        }
        return z;
    }

    private void enableListViewAccessibility() {
        AiSTTListView aiSTTListView = this.mAiSTTListView;
        if (aiSTTListView == null || aiSTTListView.getSttRecyclerView() == null) {
            return;
        }
        this.mAiSTTListView.getSttRecyclerView().setImportantForAccessibility(0);
    }

    private FragmentManager getSupportFragmentManager() {
        AiMenuContract.IAiActionSTTResultContainer iAiActionSTTResultContainer = this.mIAiActionSTTResultContainer;
        if (iAiActionSTTResultContainer == null) {
            return null;
        }
        AppCompatActivity appCompatActivity = (AppCompatActivity) iAiActionSTTResultContainer.getActivity();
        if (CoeditUtils.isActivityValid(appCompatActivity)) {
            return appCompatActivity.getSupportFragmentManager();
        }
        return null;
    }

    private void hideAllPopup() {
        AiContextMenuSTTPopup aiContextMenuSTTPopup = this.mAiContextMenuPopup;
        if (aiContextMenuSTTPopup != null) {
            aiContextMenuSTTPopup.hide();
            this.mSTTTabletLayoutAction.setShowingContextMenu(false);
        }
        AiContextMenuSTTLongPressPopup aiContextMenuSTTLongPressPopup = this.mAiContextMenuSTTLongPressPopup;
        if (aiContextMenuSTTLongPressPopup != null) {
            aiContextMenuSTTLongPressPopup.dismiss();
        }
        AiMenuResultBottomView.AddToListPopup addToListPopup = this.mAddToListPopup;
        if (addToListPopup != null) {
            addToListPopup.hide();
        }
    }

    private void hideProgress() {
        this.mCommonViews.hideProgress();
        enableListViewAccessibility();
    }

    private void initBroadcastReceiver() {
        AiLanguageHelper.updateLanguageList();
        if (this.mBroadcastAddedReceiver == null) {
            this.mBroadcastAddedReceiver = new BroadcastReceiver() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTT.8
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    if (context == null || intent == null || AiMenuResultViewSTT.this.mSTTTranslation == null) {
                        Logger.m10999d(AiMenuResultViewSTT.TAG, "addedReceiver# null");
                        return;
                    }
                    Logger.m11000e(AiMenuResultViewSTT.TAG, "addedReceiver# " + intent.getStringExtra("locale"));
                    AiLanguageHelper.updateLanguageList();
                }
            };
        }
        AiLanguageHelper.registerLanguagePackAddedReceiver(BaseUtils.getApplicationContext(), this.mBroadcastAddedReceiver);
        if (this.mBroadcastRemovedReceiver == null) {
            this.mBroadcastRemovedReceiver = new C96199();
        }
        AiLanguageHelper.registerLanguagePackRemovedReceiver(BaseUtils.getApplicationContext(), this.mBroadcastRemovedReceiver);
    }

    private void initChooseLanguageLayout() {
        View viewFindViewById = this.mView.findViewById(C9086R.id.translation_language_from);
        this.mFromView = viewFindViewById;
        ViewOnClickListenerC9738x viewOnClickListenerC9738x = new ViewOnClickListenerC9738x(this, 12);
        this.mFromViewListener = viewOnClickListenerC9738x;
        viewFindViewById.setOnClickListener(viewOnClickListenerC9738x);
        this.mFromTextView = (TextView) this.mFromView.findViewById(C9086R.id.translation_language_from_text);
        this.mFromView.setAccessibilityDelegate(new View.AccessibilityDelegate() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTT.6
            @Override // android.view.View.AccessibilityDelegate
            public void onInitializeAccessibilityNodeInfo(@NonNull View view, @NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                accessibilityNodeInfo.setContentDescription(((Object) AiMenuResultViewSTT.this.mFromView.getContentDescription()) + SQLKeyword.COMMA + ((Object) AiMenuResultViewSTT.this.mFromTextView.getText()));
            }
        });
        View viewFindViewById2 = this.mView.findViewById(C9086R.id.translation_language_to);
        this.mToView = viewFindViewById2;
        ViewOnClickListenerC9738x viewOnClickListenerC9738x2 = new ViewOnClickListenerC9738x(this, 13);
        this.mToViewListener = viewOnClickListenerC9738x2;
        viewFindViewById2.setOnClickListener(viewOnClickListenerC9738x2);
        this.mToTextView = (TextView) this.mToView.findViewById(C9086R.id.translation_language_to_text);
        this.mToView.setAccessibilityDelegate(new View.AccessibilityDelegate() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTT.7
            @Override // android.view.View.AccessibilityDelegate
            public void onInitializeAccessibilityNodeInfo(@NonNull View view, @NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                accessibilityNodeInfo.setContentDescription(((Object) AiMenuResultViewSTT.this.mToView.getContentDescription()) + SQLKeyword.COMMA + ((Object) AiMenuResultViewSTT.this.mToTextView.getText()));
            }
        });
        this.mTranslatingListener = new ViewOnClickListenerC9738x(this, 14);
        ImageView imageView = (ImageView) this.mTranslationSelectorLayout.findViewById(C9086R.id.translation_language_change_btn);
        this.mSwitchLanguageBtn = imageView;
        imageView.setImageResource(C9086R.drawable.ic_arrow_translate_language);
        this.mSwitchLanguageBtn.setEnabled(false);
        ViewOnClickListenerC9738x viewOnClickListenerC9738x3 = new ViewOnClickListenerC9738x(this, 15);
        this.mSwitchLanguageListener = viewOnClickListenerC9738x3;
        this.mSwitchLanguageBtn.setOnClickListener(viewOnClickListenerC9738x3);
        initBroadcastReceiver();
        initLanguage();
    }

    private void initContextMenu(Context context) {
        AiContextMenuSTTPopup aiContextMenuSTTPopup = new AiContextMenuSTTPopup();
        this.mAiContextMenuPopup = aiContextMenuSTTPopup;
        aiContextMenuSTTPopup.init(context, AiContextMenuSTTPopup.PopupType.IN_ORIGINAL_PAGE, new C961014());
        this.mAiContextMenuPopup.setPopupListener(new AiContextMenuSTTPopup.OnPopupListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTT.15
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiContextMenuSTTPopup.OnPopupListener
            public void onDismiss() {
                if (AiMenuResultViewSTT.this.mSTTTabletLayoutAction != null) {
                    AiMenuResultViewSTT.this.mSTTTabletLayoutAction.setShowingContextMenu(false);
                }
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiContextMenuSTTPopup.OnPopupListener
            public void onShow() {
                if (AiMenuResultViewSTT.this.mSTTTabletLayoutAction != null) {
                    AiMenuResultViewSTT.this.mSTTTabletLayoutAction.setShowingContextMenu(true);
                }
            }
        });
    }

    private void initDragDrop() {
        if (this.mGestureDetector == null) {
            this.mGestureDetector = new GestureDetector(this.mView.getContext(), new C96133());
        }
        int scaledTouchSlop = ViewConfiguration.get(this.mView.getContext()).getScaledTouchSlop();
        this.mDragDistanceThreshold = scaledTouchSlop * scaledTouchSlop * 3;
        if (this.mOnItemTouchListener == null) {
            this.mOnItemTouchListener = new RecyclerView.OnItemTouchListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTT.4
                @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
                public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
                    if (AiViewUtils.isSupportFloatingLayout() && !AiMenuResultViewSTT.this.mView.isFocusable()) {
                        AiMenuResultViewSTT.this.mView.setFocusable(true);
                        AiMenuResultViewSTT.this.mView.setFocusableInTouchMode(true);
                    }
                    if (AiMenuResultViewSTT.this.mIAiSTTContract != null && ((AiMenuResultViewSTT.this.mIAiSTTContract.getMSTTPresenter().getCurrentMode() == STTMode.SEARCH || AiMenuResultViewSTT.this.mIAiSTTContract.getMSTTPresenter().getCurrentMode() == STTMode.SEARCH_COMPOSER) && InputMethodCompat.getInstance().isInputMethodShown(AiMenuResultViewSTT.this.mView.getContext(), AiMenuResultViewSTT.this.mView, InputMethodCompat.getInstance().isEnabledMobileKeyboard(AiMenuResultViewSTT.this.mView.getContext())))) {
                        InputMethodCompat.getInstance().hideSoftInput(AiMenuResultViewSTT.this.mView.getContext(), AiMenuResultViewSTT.this.mAiSTTListView.getSttRecyclerView());
                        if (AiMenuResultViewSTT.this.mAiSTTListView.getSttLayoutManager() != null) {
                            AiMenuResultViewSTT.this.mAiSTTListView.getSttLayoutManager().setScrollable(false);
                            return false;
                        }
                    } else if (AiViewUtils.isSupportFloatingLayout() || !AiMenuResultViewSTT.this.mIsStartedDragDropAction) {
                        if (AiMenuResultViewSTT.this.mIAiSTTContract != null && !AiMenuResultViewSTT.this.mIAiSTTContract.isEditMode()) {
                            AiMenuResultViewSTT.this.mGestureDetector.onTouchEvent(motionEvent);
                        }
                        int action = motionEvent.getAction();
                        if (action == 0) {
                            AiMenuResultViewSTT.this.mStartDragX = (int) motionEvent.getX();
                            AiMenuResultViewSTT.this.mStartDragY = (int) motionEvent.getY();
                            return false;
                        }
                        if (action == 1) {
                            if (AiMenuResultViewSTT.this.mAiSTTListView.getSttLayoutManager() != null && !AiMenuResultViewSTT.this.mAiSTTListView.getSttLayoutManager().getIsScrollable()) {
                                AiMenuResultViewSTT.this.mAiSTTListView.getSttLayoutManager().setScrollable(true);
                            }
                            if (AiMenuResultViewSTT.this.mIsPendingDragDropAction) {
                                Logger.m10999d(AiMenuResultViewSTT.TAG, "onInterceptTouchEvent# cancel pending drag and drop action");
                                AiMenuResultViewSTT aiMenuResultViewSTT = AiMenuResultViewSTT.this;
                                aiMenuResultViewSTT.mHandler.removeCallbacks(aiMenuResultViewSTT.dragDropRunnable);
                                AiMenuResultViewSTT.this.mIsPendingDragDropAction = false;
                                AiMenuResultViewSTT.this.mIsStartedDragDropAction = false;
                            }
                        } else {
                            if (action != 2) {
                                Logger.m10999d(AiMenuResultViewSTT.TAG, "onInterceptTouchEvent# default");
                                return false;
                            }
                            if (AiMenuResultViewSTT.this.mIsPendingDragDropAction) {
                                int x = (int) motionEvent.getX();
                                int y2 = (int) motionEvent.getY();
                                int i = x - AiMenuResultViewSTT.this.mStartDragX;
                                int i2 = y2 - AiMenuResultViewSTT.this.mStartDragY;
                                AiMenuResultViewSTT.this.mDistance = (i2 * i2) + (i * i);
                                if (AiMenuResultViewSTT.this.mDistance > AiMenuResultViewSTT.this.mDragDistanceThreshold) {
                                    Logger.m10999d(AiMenuResultViewSTT.TAG, "onInterceptTouchEvent# perform the drag and drop action by distance " + AiMenuResultViewSTT.this.mDistance + " > " + AiMenuResultViewSTT.this.mDragDistanceThreshold);
                                    AiMenuResultViewSTT.this.mIsStartedDragDropAction = true;
                                    AiMenuResultViewSTT aiMenuResultViewSTT2 = AiMenuResultViewSTT.this;
                                    aiMenuResultViewSTT2.mHandler.removeCallbacks(aiMenuResultViewSTT2.dragDropRunnable);
                                    AiMenuResultViewSTT aiMenuResultViewSTT3 = AiMenuResultViewSTT.this;
                                    aiMenuResultViewSTT3.mHandler.post(aiMenuResultViewSTT3.dragDropRunnable);
                                    return false;
                                }
                            }
                        }
                    }
                    return false;
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
                public void onRequestDisallowInterceptTouchEvent(boolean z) {
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
                public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
                }
            };
        }
        this.mAiSTTListView.getSttRecyclerView().removeOnItemTouchListener(this.mOnItemTouchListener);
        this.mAiSTTListView.getSttRecyclerView().addOnItemTouchListener(this.mOnItemTouchListener);
    }

    private void initEditMode() {
        STTMode currentMode = this.mIAiSTTContract.getMSTTPresenter().getCurrentMode();
        this.mIAiSTTContract.getOriginalSTTListView().setEditMode(this.mIAiSTTContract.isEditMode());
        onModeChanged(currentMode);
    }

    private void initHelpView() {
        int indexItemToShow = this.mIAiSTTContract.getIndexItemToShow();
        if (this.mIAiSTTContract.isCurrentVoiceHaveSTTData() || FastConvertController.getInstance().isConverting(this.mCurrentShowingSession)) {
            hideHelpView();
        } else {
            showHelpView(indexItemToShow);
        }
    }

    private void initLanguage() {
        Logger.m10999d(TAG, "initLanguage#");
        this.mSTTTranslation.setLanguageIdentifierCallback(new C9483A(this));
    }

    private void initListView() {
        this.mAiSTTListView.getSttRecyclerView().addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTT.5
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                if (AiMenuResultViewSTT.this.mTranslationSelectorLayout != null) {
                    int iComputeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
                    int height = AiMenuResultViewSTT.this.mTranslationSelectorLayout.getHeight();
                    if (iComputeVerticalScrollOffset <= 3 && i2 <= 0) {
                        AiMenuResultViewSTT.this.doUpdateTranslatorLayoutPositionOnScroll(-height);
                    } else if (iComputeVerticalScrollOffset <= height) {
                        AiMenuResultViewSTT.this.doUpdateTranslatorLayoutPositionOnScroll(i2);
                    } else {
                        AiMenuResultViewSTT.this.doUpdateTranslatorLayoutPositionOnScroll(height);
                    }
                }
            }
        });
        this.mView.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC9709e(this, 2));
        this.mAiSTTListView.getSttRecyclerView().setClipToPadding(false);
    }

    private void initPopUpWindow() {
        if (this.mAiContextMenuPopup != null && this.mSTTTabletLayoutAction.isShowingContextMenu()) {
            this.mCommonViews.getTopView().mSTTContextBtn.post(new RunnableC9739y(this, 8));
        }
        if (this.mSTTVoiceListPopup == null || !this.mSTTTabletLayoutAction.isShowingVoiceListPopup()) {
            return;
        }
        this.mCommonViews.getTopView().mTitleContainer.post(new RunnableC9739y(this, 9));
    }

    private void initSTTDisclaimerBtnListener() {
        this.mCommonViews.getTopView().mSTTDisclaimerBtn.setOnClickListener(new ViewOnClickListenerC9738x(this, 11));
    }

    private void initTopMenu() {
        AiMenuResultCommonViews aiMenuResultCommonViews = this.mCommonViews;
        if (aiMenuResultCommonViews == null) {
            return;
        }
        initContextMenu(aiMenuResultCommonViews.mActivity);
        initVoiceListPopup();
        this.mCommonViews.getTopView().mTitleView.setOnClickListener(this.mDropDownListListener);
        this.mCommonViews.getTopView().mSTTDropdown.setOnClickListener(this.mDropDownListListener);
        this.mCommonViews.getTopView().mSTTContextBtn.setOnClickListener(new ViewOnClickListenerC9738x(this, 4));
        this.mCommonViews.getTopView().mSTTTranslateBtn.setOnClickListener(new ViewOnClickListenerC9738x(this, 5));
        initSTTDisclaimerBtnListener();
        if (this.mCommonViews.getTopView().mSTTEditCancelBtn != null && this.mCommonViews.getTopView().mSTTEditDoneBtn != null) {
            this.mCommonViews.getTopView().mSTTEditCancelBtn.setOnClickListener(new ViewOnClickListenerC9738x(this, 6));
            this.mCommonViews.getTopView().mSTTEditDoneBtn.setOnClickListener(new ViewOnClickListenerC9738x(this, 7));
        }
        this.mCommonViews.getTopView().initSTTTabLayout();
        this.mCommonViews.getTopView().mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTT.12
            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabReselected(TabLayout.Tab tab) {
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                Logger.m10999d(AiMenuResultViewSTT.TAG, "onTabSelected " + tab.getPosition() + " " + ((Object) tab.getText()));
                if (tab.getPosition() == 1 && AiMenuResultViewSTT.this.mCommonViews.getTranscribeProgressCancelBtn().getVisibility() == 0) {
                    AiMenuResultViewSTT.this.mCommonViews.getTranscribeProgressCancelBtn().setVisibility(8);
                }
                AiMenuResultViewSTT.this.mIAiActionSTTResultContainer.onTabSelected(tab.getPosition());
                AiMenuResultViewSTT.this.updateTopContainerLayout();
                if (tab.getPosition() == 0) {
                    ComposerSA.insertLog("816", STTConstant.EVENT_SELECT_TRANSCRIPT_TAB);
                } else if (tab.getPosition() == 1) {
                    ComposerSA.insertLog("816", STTConstant.EVENT_SELECT_SUMMARY_TAB);
                }
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
            }
        });
        View viewFindViewById = this.mCommonViews.getTopContainer().findViewById(C9086R.id.ai_menu_result_top_container);
        viewFindViewById.setPaddingRelative(viewFindViewById.getPaddingStart(), viewFindViewById.getPaddingTop(), viewFindViewById.getPaddingEnd(), (int) ResourceUtils.convertDpToPixel(this.mCommonViews.mActivity, 14.0f));
    }

    private void initTranslateConfig() {
        Looper looperMyLooper = Looper.myLooper();
        Objects.requireNonNull(looperMyLooper);
        new Handler(looperMyLooper).post(new RunnableC0284b(29));
    }

    private void initVoiceListPopup() {
        if (this.mSTTVoiceListPopup == null) {
            AiMenuResultViewSTTVoiceListPopup aiMenuResultViewSTTVoiceListPopup = new AiMenuResultViewSTTVoiceListPopup();
            this.mSTTVoiceListPopup = aiMenuResultViewSTTVoiceListPopup;
            aiMenuResultViewSTTVoiceListPopup.init(this.mCommonViews.mActivity, this.mIAiSTTContract.getMSTTPresenter().getVoiceDataList(), new C9483A(this));
            this.mSTTVoiceListPopup.setPopupListener(new AiMenuResultViewSTTVoiceListPopup.OnPopupListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTT.13
                @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTTVoiceListPopup.OnPopupListener
                public void onDismiss() {
                    if (AiMenuResultViewSTT.this.mSTTTabletLayoutAction != null) {
                        AiMenuResultViewSTT.this.mSTTTabletLayoutAction.setShowingVoiceListPopup(false);
                    }
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTTVoiceListPopup.OnPopupListener
                public void onShow() {
                    if (AiMenuResultViewSTT.this.mSTTTabletLayoutAction != null) {
                        AiMenuResultViewSTT.this.mSTTTabletLayoutAction.setShowingVoiceListPopup(true);
                    }
                }
            });
        }
    }

    private boolean isNeedToShowDropdown() {
        return (this.mIAiSTTContract.getMSTTPresenter().isSelectionMode() || this.mIAiSTTContract.getMSTTPresenter().isSelectionSummaryMode() || this.mIAiSTTContract.getMSTTPresenter().isComposerSearchMode() || this.mIAiSTTContract.getMSTTPresenter().isSTTEditMode() || this.mIAiSTTContract.getMSTTPresenter().getVoiceDataList().size() <= 1 || this.mIAiActionSTTResultContainer.isMinimizeView()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initChooseLanguageLayout$3(View view) {
        this.mIAiSTTContract.getMSTTPresenter().setMIsTranslateSTTFirstTime(false);
        showLanguageSelectorDialog(true);
        ComposerSA.insertLog(STTConstant.SCREEN_AI_MENU_RESULT_STT_TRANSLATION, STTConstant.EVENT_SELECT_SOURCE_LANGUAGE, this.mSTTTranslation.getFromLanguageTag());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initChooseLanguageLayout$4(View view) {
        showLanguageSelectorDialog(false);
        ComposerSA.insertLog(STTConstant.SCREEN_AI_MENU_RESULT_STT_TRANSLATION, STTConstant.EVENT_SELECT_TARGET_LANGUAGE, this.mSTTTranslation.getToLanguageTag());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initChooseLanguageLayout$5(View view) {
        if (this.mSTTTranslation.isCompleted()) {
            return;
        }
        ToastHandler.show(this.mView.getContext(), C9086R.string.ai_stt_wait_for_the_translation_to_finish, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initChooseLanguageLayout$6(View view) {
        STTTranslation sTTTranslation = this.mSTTTranslation;
        if (sTTTranslation == null) {
            Logger.m11000e(TAG, "onClick# switch: null");
            return;
        }
        if (sTTTranslation.isSame()) {
            Logger.m11000e(TAG, "onClick# switch: same language");
            return;
        }
        this.mSTTTranslation.switchLanguageTag();
        updateLanguage();
        requestTranslate();
        ComposerSA.insertLog(STTConstant.SCREEN_AI_MENU_RESULT_STT_TRANSLATION, STTConstant.EVENT_TRANSLATE, "d");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initLanguage$7() {
        if (FeatureInfo.isSupportTranslationLanguageAutoDetectingEffect() && this.mIAiSTTContract.getMSTTPresenter().getMIsTranslateSTTFirstTime()) {
            this.mIAiSTTContract.getMSTTPresenter().setMIsTranslateSTTFirstTime(false);
            this.mTranslationSelectorLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTT.10
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    AiMenuResultViewSTT.this.mTranslationSelectorLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    AiMenuResultViewSTT aiMenuResultViewSTT = AiMenuResultViewSTT.this;
                    aiMenuResultViewSTT.animateTranslationAutoDetecting(aiMenuResultViewSTT.mTranslationSelectorLayout.getHeight());
                    AiMenuResultViewSTT.this.mTranslationAutoDetecting.playAnimation();
                }
            });
        }
        if (doInitialStep() || this.mSTTTranslation.isWaitingFirstResult()) {
            return;
        }
        this.mCommonViews.hideProgress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initLanguage$8() {
        View view = this.mView;
        if (view != null) {
            view.post(new RunnableC9739y(this, 6));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initLayout$9(View view) {
        Logger.m10999d(TAG, "CancelAutoTranscribeBtn onClick#");
        ISTTWindow.IAIContract iAIContract = this.mIAiSTTContract;
        if (iAIContract != null) {
            iAIContract.getMSTTPresenter().cancelAutoTranscribe(this.mIAiSTTContract.getMSTTPresenter().getSessionIDAutoTranscribe());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initListView$2(View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
        AiSTTListView aiSTTListView;
        if (this.mTranslationSelectorLayout == null || (aiSTTListView = this.mAiSTTListView) == null || aiSTTListView.getSttRecyclerView() == null || !this.mSTTTranslation.isTranslateMode()) {
            return;
        }
        int iComputeVerticalScrollOffset = this.mAiSTTListView.getSttRecyclerView().computeVerticalScrollOffset();
        int height = this.mTranslationSelectorLayout.getHeight();
        int i10 = i5 - i9;
        if (i10 == 0 || iComputeVerticalScrollOffset > height) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTranslationSelectorLayout.getLayoutParams();
        layoutParams.setMargins(layoutParams.leftMargin, -iComputeVerticalScrollOffset, layoutParams.rightMargin, layoutParams.bottomMargin);
        this.mTranslationSelectorLayout.setLayoutParams(layoutParams);
        String str = TAG;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "onLayoutChange#mView [", " ", " ");
        AbstractC2821a.m2235z(sbM1173s, i4, i5, " ", "] offset ");
        AbstractC2821a.m2235z(sbM1173s, iComputeVerticalScrollOffset, height, " translateViewHeight ", " changeRange ");
        AbstractC8014b.m7221w(sbM1173s, str, i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initPopUpWindow$18() {
        this.mAiContextMenuPopup.show(this.mCommonViews.getTopView().mSTTContextBtn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initPopUpWindow$19() {
        this.mSTTVoiceListPopup.show(this.mCommonViews.getTopView().mTitleContainer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initSTTDisclaimerBtnListener$16(View view) {
        if (this.mCommonViews.isNotAvailable()) {
            return;
        }
        AiDisclaimerDialog aiDisclaimerDialog = new AiDisclaimerDialog();
        aiDisclaimerDialog.showSTTMessage(view.getContext(), view);
        this.mCommonViews.getTopView().setAiDisclaimerDialog(aiDisclaimerDialog);
        this.mCommonViews.getBottomView().hide(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initTopMenu$10(View view) {
        if (!isInfoViewShowing()) {
            this.mAiContextMenuPopup.updateShowSpeakerLabelText(this.mIAiSTTContract.getShowSpeakerLabel());
            this.mAiContextMenuPopup.updateTranslateMode(this.mSTTTranslation.isTranslateMode() && this.mSTTTranslation.isTranslatePending());
        }
        this.mAiContextMenuPopup.show(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$initTopMenu$11() {
        Logger.m10999d(TAG, "context menu cancel");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initTopMenu$12(View view) {
        AiCommonUtil.executeActionByOndevice(this.mIAiActionSTTResultContainer.getActivity(), new RunnableC9735u(this, view, 4), new RunnableC9675B(0));
        ComposerSA.insertLog("816", STTConstant.EVENT_SELECT_MORE_TRANSCRIPT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initTopMenu$13(View view) {
        if (!this.mSTTTranslation.isTranslateMode() && !this.mSTTTranslation.isTranslatePending() && !this.mSTTTranslation.isCompleted()) {
            ComposerSA.insertLog(STTConstant.SCREEN_AI_MENU_RESULT_STT_TRANSLATION, STTConstant.EVENT_TRANSLATE, "a");
            initLanguage();
            this.mSTTTranslation.execute();
        }
        this.mSTTTranslation.toggleTranslateMode();
        updateTranslateMode();
        if (this.mSTTTranslation.isTranslateMode()) {
            ComposerSA.insertLog("816", STTConstant.EVENT_SELECT_TRANSCRIPT_TRANSLATE, "a");
        } else {
            ComposerSA.insertLog("816", STTConstant.EVENT_SELECT_TRANSCRIPT_TRANSLATE, "b");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initTopMenu$14(View view) {
        this.mIAiSTTContract.saveSTTData(false);
        this.mIAiSTTContract.toggleEditMode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initTopMenu$15(View view) {
        this.mIAiSTTContract.saveSTTData(true);
        this.mIAiSTTContract.toggleEditMode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$initTranslateConfig$21() {
        AiLanguageHelper.initTranslateConfig();
        AiLanguageHelper.updateLanguageList();
        SCSOperator.initTranslator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initVoiceListPopup$17(int i) {
        SpenVoiceData spenVoiceData = this.mIAiSTTContract.getMSTTPresenter().getVoiceDataList().get(i);
        if ((spenVoiceData.getPlayTime() == null || spenVoiceData.getAttachedFile() == null) && VoiceManager.isRecording()) {
            Logger.m10999d(TAG, "onSelectVoiceItem# isRecording");
            ToastHandler.show(this.mMenuResultViewPresenter.getActivity(), this.mMenuResultViewPresenter.getActivity().getString(C9086R.string.ai_can_not_transcribe_while_recording), 0);
        } else {
            this.mIAiSTTContract.getMSTTPresenter().showOrExecuteSTTVoiceItem(i);
            this.mSTTVoiceListPopup.hide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view) {
        if (this.mSTTTabletLayoutAction != null && isNeedToShowDropdown()) {
            this.mSTTVoiceListPopup.show(view);
            Logger.m10999d(TAG, "show voice item popup " + view.hashCode());
            ComposerSA.insertLog(STTConstant.SCREEN_AI_MENU_RESULT_STT_SUMMARY, STTConstant.EVENT_CHANGE_RECORDING_FILE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onConverting$26() {
        this.mCommonViews.setTopButtonState(false);
        this.mCommonViews.updatePercentProgress(0);
        this.mCommonViews.showProgress(7);
        disableListViewAccessibility();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onModeChanged$28() {
        this.mAiSTTListView.getSttRecyclerView().setPadding(0, 0, 0, 20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onModeChanged$29() {
        int iConvertDpToPixel = (int) ResourceUtils.convertDpToPixel(this.mIAiActionSTTResultContainer.getActivity(), 66.0f);
        this.mAiSTTListView.getSttRecyclerView().setPadding(0, iConvertDpToPixel, 0, 20);
        this.mAiSTTListView.getSttRecyclerView().smoothScrollBy(0, -iConvertDpToPixel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onOrientationChanged$36() {
        AiContextMenuSTTPopup aiContextMenuSTTPopup;
        if (this.mCommonViews == null || (aiContextMenuSTTPopup = this.mAiContextMenuPopup) == null || !aiContextMenuSTTPopup.isShowing()) {
            return;
        }
        this.mAiContextMenuPopup.show(this.mCommonViews.getTopView().mSTTContextBtn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onResume$30() {
        STTTranslation sTTTranslation = this.mSTTTranslation;
        if (sTTTranslation != null) {
            Locale locale = AiLanguageHelper.getLocale(sTTTranslation.getFromLanguageTag());
            Locale locale2 = AiLanguageHelper.getLocale(this.mSTTTranslation.getToLanguageTag());
            if (locale == null || locale2 == null || this.mMenuResultViewPresenter == null || !this.mSTTTranslation.isInvalidStatus()) {
                return;
            }
            Logger.m10999d(TAG, "onResume# invalid status. requestDownloadLanguagePack");
            this.mIsRequestedDownloadLanguage = true;
            AiLanguageHelper.requestDownloadLanguagePack(this.mIAiActionSTTResultContainer.getActivity(), locale, locale2, Integer.valueOf(ComposerRequestCode.DownloadLanguage.getId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onResume$31() {
        STTTranslation sTTTranslation;
        if (this.mMenuResultViewPresenter == null || (sTTTranslation = this.mSTTTranslation) == null || !sTTTranslation.isInvalidStatus()) {
            return;
        }
        Logger.m10999d(TAG, "onResume# invalid status. Stop Translation mode.");
        this.mSTTTranslation.updateLanguageStatus();
        this.mSTTTranslation.stop();
        this.mSTTTranslation.cancel();
        updateTranslateMode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onVoiceInfoChanged$27() {
        String str = TAG;
        Logger.m10999d(str, "onVoiceInfoChanged");
        if (this.mMenuResultViewPresenter.getSTTTabletLayoutAction() == null) {
            Logger.m11000e(str, "onVoiceInfoChanged# getSTTTabletLayoutAction null, showing other action");
            return;
        }
        updateDropdownView();
        AiMenuResultCommonViews aiMenuResultCommonViews = this.mCommonViews;
        if (aiMenuResultCommonViews != null && aiMenuResultCommonViews.getTopView().mTitleView != null && !this.mIAiSTTContract.getMSTTPresenter().isSelectionMode()) {
            this.mCommonViews.getTopView().mTitleView.setText(this.mIAiSTTContract.getCurrentSTTVoiceName());
        }
        AiMenuContract.IAiActionSTTResultContainer iAiActionSTTResultContainer = this.mIAiActionSTTResultContainer;
        if (iAiActionSTTResultContainer != null) {
            iAiActionSTTResultContainer.onVoiceInfoChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAutoDetectHelpView$33(int i, View view) {
        this.mIAiSTTContract.executeSTT(i);
        ComposerSA.insertLog(STTConstant.SCREEN_AI_MENU_RESULT_STT_HELP_VIEW_DECTECTED, STTConstant.EVENT_TRANSCRIBE_INTO_LANGUAGE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAutoDetectHelpView$34(View view) {
        this.mIAiActionSTTResultContainer.executeTranscribeAgain();
        this.mIAiSTTContract.reConvertCurrentItem(false);
        ComposerSA.insertLog(STTConstant.SCREEN_AI_MENU_RESULT_STT_HELP_VIEW_DECTECTED, STTConstant.EVENT_TRANSCRIBE_TO_OTHER_LANGUAGES);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showAutoDetectHelpView$35(TextView textView, TextView textView2) {
        textView.setMinWidth(textView2.getWidth());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showHelpView$32(int i, View view) {
        this.mIAiSTTContract.executeSTT(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$toggleModeBottomMenu$25(TextView textView, TextView textView2, TextView textView3, ViewGroup viewGroup) {
        textView.setText(C9086R.string.composer_ctx_menu_copy);
        textView2.setText(C9086R.string.ai_action_add_to);
        textView3.setText(C9086R.string.action_replace);
        setViewVisible(viewGroup, false);
        viewGroup.getParent().requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$toggleModeTopMenu$22(View view) {
        this.mMenuResultViewPresenter.getSTTTabletLayoutAction().copySelectedTextData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$toggleModeTopMenu$23(View view) {
        this.mMenuResultViewPresenter.getSTTTabletLayoutAction().shareSelectedTextData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$toggleModeTopMenu$24(View view) {
        this.mMenuResultViewPresenter.getSTTTabletLayoutAction().deleteSelectedTextData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateTitleViewMode$1(View view) {
        this.mIAiSTTContract.getMSTTPresenter().toggleSTTSelectAllItem(this.mCommonViews.getTopView().mSTTSelectAllCheckBox.isChecked());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateTranslateMode$20(int i) {
        int iComputeVerticalScrollOffset = this.mAiSTTListView.getSttRecyclerView().computeVerticalScrollOffset();
        int iConvertDpToPixel = this.mSTTTranslation.isTranslateMode() ? (int) ResourceUtils.convertDpToPixel(this.mIAiActionSTTResultContainer.getActivity(), 74.0f) : 0;
        this.mAiSTTListView.getSttRecyclerView().setPadding(0, iConvertDpToPixel, 0, 20);
        if (iComputeVerticalScrollOffset <= iConvertDpToPixel) {
            this.mAiSTTListView.getSttRecyclerView().scrollToPosition(iComputeVerticalScrollOffset);
        }
        int iComputeVerticalScrollOffset2 = this.mAiSTTListView.getSttRecyclerView().computeVerticalScrollOffset();
        if (iComputeVerticalScrollOffset2 > iConvertDpToPixel) {
            doUpdateTranslatorLayoutPositionOnScroll(iConvertDpToPixel);
        } else {
            doUpdateTranslatorLayoutPositionOnScroll(-iConvertDpToPixel);
        }
        String str = TAG;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(iConvertDpToPixel, i, "toggleTranslateMode topPadding ", " beforeTopPadding ", " beforeScrollPosition ");
        sbM1173s.append(iComputeVerticalScrollOffset);
        sbM1173s.append(" afterScrollPosition ");
        sbM1173s.append(iComputeVerticalScrollOffset2);
        Logger.m10999d(str, sbM1173s.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestTranslate() {
        int fromLanguageState = this.mSTTTranslation.getFromLanguageState();
        int toLanguageState = this.mSTTTranslation.getToLanguageState();
        if (fromLanguageState == 0 && toLanguageState == 0) {
            this.mSTTTranslation.execute();
        }
    }

    private void restoreSelectionMode() {
        if (this.mIAiSTTContract.getMSTTPresenter().isSelectionMode()) {
            this.mAiSTTListView.setSelectionMode(true);
        }
    }

    private void setInfoButtonState(boolean z) {
        setButtonState(this.mCommonViews.getTopView().mSTTTranslateBtn, z);
        setButtonState(this.mCommonViews.getTopView().mSTTDisclaimerBtn, z);
        setButtonState(this.mCommonViews.getTopView().mSTTContextBtn, true);
        AiContextMenuSTTPopup aiContextMenuSTTPopup = this.mAiContextMenuPopup;
        if (aiContextMenuSTTPopup != null) {
            setButtonState(aiContextMenuSTTPopup.mEditButton, z);
            setButtonState(this.mAiContextMenuPopup.mSpeakerLabel, z);
            setButtonState(this.mAiContextMenuPopup.mRemoveTranscribeButton, z);
            setButtonState(this.mAiContextMenuPopup.mCopyButton, z);
            setButtonState(this.mAiContextMenuPopup.mAddToButton, z);
            setButtonState(this.mAiContextMenuPopup.mSearchButton, z);
        }
        if (!z && (this.mCommonViews.getBottomView().isShowing() || DeviceInfo.isVSTModel())) {
            this.mCommonViews.getBottomView().hide(false);
            this.mCommonViews.getBottomView().setDisabled(true);
        } else if (z && DeviceInfo.isVSTModel()) {
            this.mCommonViews.getBottomView().show(false);
            this.mCommonViews.getBottomView().setDisabled(false);
        }
    }

    private void setPaddingBottomView(boolean z) {
        BasePenRecyclerView sttRecyclerView = this.mAiSTTListView.getSttRecyclerView();
        int paddingTop = sttRecyclerView.getPaddingTop();
        if (z) {
            sttRecyclerView.setPadding(0, paddingTop, 0, (int) this.mView.getResources().getDimension(C9086R.dimen.ai_menu_result_bottom_menu_height));
        } else {
            sttRecyclerView.setPadding(0, paddingTop, 0, 0);
        }
    }

    private void setSelectLanguageLayoutState(boolean z) {
        if (this.mView == null) {
            return;
        }
        float f = z ? 1.0f : 0.4f;
        if (this.mTranslationSelectorLayout != null) {
            this.mFromTextView.setAlpha(f);
            this.mToTextView.setAlpha(f);
            this.mSwitchLanguageBtn.setAlpha(f);
            if (z) {
                this.mFromView.setBackground(ContextCompat.getDrawable(this.mView.getContext(), C9086R.drawable.ai_translation_ripple));
                this.mFromView.setOnClickListener(this.mFromViewListener);
                this.mToView.setBackground(ContextCompat.getDrawable(this.mView.getContext(), C9086R.drawable.ai_translation_ripple));
                this.mToView.setOnClickListener(this.mToViewListener);
                this.mSwitchLanguageBtn.setBackground(ContextCompat.getDrawable(this.mView.getContext(), C9086R.drawable.ai_translation_ripple));
                this.mSwitchLanguageBtn.setOnClickListener(this.mSwitchLanguageListener);
                return;
            }
            this.mFromView.setBackground(null);
            this.mFromView.setOnClickListener(this.mTranslatingListener);
            this.mToView.setBackground(null);
            this.mToView.setOnClickListener(this.mTranslatingListener);
            this.mSwitchLanguageBtn.setBackground(null);
            this.mSwitchLanguageBtn.setOnClickListener(this.mTranslatingListener);
        }
    }

    private void setSelectionBtnState(boolean z) {
        float f = z ? 1.0f : 0.4f;
        View view = this.mCopyBtn;
        if (view != null) {
            view.setEnabled(z);
            this.mCopyBtn.setAlpha(f);
        }
        View view2 = this.mShareBtn;
        if (view2 != null) {
            view2.setEnabled(z);
            this.mShareBtn.setAlpha(f);
        }
        View view3 = this.mDeleteBtn;
        if (view3 != null) {
            view3.setEnabled(z);
            this.mDeleteBtn.setAlpha(f);
        }
    }

    private void setViewVisible(View view, boolean z) {
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toggleModeBottomMenu() {
        AiMenuResultCommonViews aiMenuResultCommonViews = this.mCommonViews;
        if (aiMenuResultCommonViews != null && this.mSTTTabletLayoutAction != null) {
            View viewFindViewById = aiMenuResultCommonViews.getTopContainer().findViewById(C9086R.id.ai_menu_result_stt_top_container);
            setViewVisible(this.mCommonViews.getTopContainer().findViewById(C9086R.id.ai_menu_result_stt_top_edit_container), false);
            setViewVisible(this.mCommonViews.getTopContainer().findViewById(C9086R.id.ai_menu_result_stt_top_selection_container), false);
            ViewGroup viewGroup = (ViewGroup) this.mCommonViews.getBottomView().getCopyBtn();
            ViewGroup viewGroup2 = (ViewGroup) this.mCommonViews.getBottomView().getReplaceBtn();
            ViewGroup viewGroup3 = (ViewGroup) this.mCommonViews.getBottomView().getAddToBtn();
            TextView textView = (TextView) viewGroup.getChildAt(0);
            TextView textView2 = (TextView) viewGroup2.getChildAt(0);
            TextView textView3 = (TextView) viewGroup3.getChildAt(0);
            this.mCopyBtn = null;
            this.mShareBtn = null;
            this.mDeleteBtn = null;
            STTMode currentMode = this.mIAiSTTContract.getMSTTPresenter().getCurrentMode();
            if (currentMode == STTMode.SELECTION) {
                setViewVisible(viewFindViewById, false);
                setViewVisible(viewGroup2, true);
                this.mCommonViews.getBottomView().setEnableReplace(true);
                textView.setText(C9086R.string.copy);
                textView2.setText(C9086R.string.action_share);
                textView3.setText(C9086R.string.action_delete);
                this.mCommonViews.getBottomView().setDisabled(false);
                this.mCommonViews.getBottomView().show(true);
                this.mCommonViews.getTopView().setTabLayoutState(false);
                this.mCopyBtn = viewGroup;
                this.mShareBtn = viewGroup2;
                this.mDeleteBtn = viewGroup3;
                return;
            }
            if (currentMode == STTMode.EDIT) {
                setPaddingBottomView(true);
                this.mCommonViews.setBottomButtonsState(true);
                textView.setText(C9086R.string.action_cancel);
                textView3.setText(C9086R.string.action_done);
                setViewVisible(viewGroup2, false);
                this.mCommonViews.getBottomView().setDisabled(false);
                this.mCommonViews.getBottomView().show(true);
                setViewVisible(viewFindViewById, false);
                setViewVisible(this.mCommonViews.getTopView().mTabLayout, false);
                return;
            }
            if (currentMode == STTMode.REPLAY) {
                updateBottomMenuView();
                textView.postDelayed(new RunnableC4054d(this, textView, textView3, textView2, viewGroup2, 2), DeviceInfo.isVSTModel() ? 0 : 1000);
                if (!this.mSTTTabletLayoutAction.isWorking()) {
                    this.mCommonViews.getTopView().setTabLayoutState(true);
                }
                setViewVisible(viewFindViewById, true);
                setViewVisible(this.mCommonViews.getTopView().mTabLayout, this.mCommonViews.mSTTHelpView.getVisibility() != 0);
            }
        }
    }

    private void toggleModeTopMenu() {
        AiMenuResultCommonViews aiMenuResultCommonViews = this.mCommonViews;
        if (aiMenuResultCommonViews == null) {
            return;
        }
        View viewFindViewById = aiMenuResultCommonViews.getTopContainer().findViewById(C9086R.id.ai_menu_result_stt_top_container);
        View viewFindViewById2 = this.mCommonViews.getTopContainer().findViewById(C9086R.id.ai_menu_result_stt_top_edit_container);
        View viewFindViewById3 = this.mCommonViews.getTopContainer().findViewById(C9086R.id.ai_menu_result_stt_top_selection_container);
        this.mCommonViews.getBottomView().hide(false);
        this.mCommonViews.getBottomView().setDisabled(true);
        this.mCopyBtn = null;
        this.mShareBtn = null;
        this.mDeleteBtn = null;
        if (!this.mIAiSTTContract.getMSTTPresenter().isSelectionMode()) {
            if (this.mIAiSTTContract.isEditMode()) {
                setViewVisible(viewFindViewById, false);
                setViewVisible(viewFindViewById3, false);
                setViewVisible(viewFindViewById2, true);
                setViewVisible(this.mCommonViews.getTopView().mTabLayout, false);
                return;
            }
            setViewVisible(viewFindViewById, true);
            setViewVisible(viewFindViewById3, false);
            setViewVisible(viewFindViewById2, false);
            setViewVisible(this.mCommonViews.getTopView().mTabLayout, this.mCommonViews.mSTTHelpView.getVisibility() != 0);
            return;
        }
        View viewFindViewById4 = viewFindViewById3.findViewById(C9086R.id.ai_menu_result_stt_selection_copy_btn);
        this.mCopyBtn = viewFindViewById4;
        View viewFindViewById5 = viewFindViewById3.findViewById(C9086R.id.ai_menu_result_stt_selection_share_btn);
        this.mShareBtn = viewFindViewById5;
        View viewFindViewById6 = viewFindViewById3.findViewById(C9086R.id.ai_menu_result_stt_selection_delete_btn);
        this.mDeleteBtn = viewFindViewById6;
        viewFindViewById4.setOnClickListener(new ViewOnClickListenerC9738x(this, 0));
        viewFindViewById5.setOnClickListener(new ViewOnClickListenerC9738x(this, 3));
        viewFindViewById6.setOnClickListener(new ViewOnClickListenerC9738x(this, 9));
        setViewVisible(viewFindViewById, false);
        setViewVisible(viewFindViewById3, true);
        setViewVisible(viewFindViewById2, false);
        setViewVisible(this.mCommonViews.getTopView().mTabLayout, false);
    }

    private void updateAISTTListView() {
        AiSTTListView aiSTTListView = this.mAiSTTListView;
        if (aiSTTListView == null || aiSTTListView.getVisibility() != 0) {
            return;
        }
        this.mAiSTTListView.updateListMargin();
    }

    private void updateBottomMenuView() {
        if (isInfoViewShowing()) {
            return;
        }
        if (DeviceInfo.isVSTModel()) {
            this.mCommonViews.getBottomView().show(true);
            this.mCommonViews.getBottomView().setDisabled(false);
            this.mAiContextMenuPopup.mCopyButton.setVisibility(8);
            this.mAiContextMenuPopup.mAddToButton.setVisibility(8);
        } else {
            setPaddingBottomView(false);
            this.mCommonViews.getBottomView().hide(false);
            this.mCommonViews.getBottomView().setDisabled(true);
            this.mAiContextMenuPopup.mCopyButton.setVisibility(0);
            this.mAiContextMenuPopup.mAddToButton.setVisibility(0);
        }
        this.mCommonViews.getBottomView().getCopyBtn().getParent().requestLayout();
    }

    private void updateDividerVisibility() {
    }

    private void updateDropdownView() {
        if (this.mCommonViews == null) {
            return;
        }
        if (isNeedToShowDropdown()) {
            this.mCommonViews.getTopView().mSTTDropdown.setVisibility(0);
        } else {
            this.mCommonViews.getTopView().mSTTDropdown.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLanguage() {
        TextView textView;
        TextView textView2;
        Locale locale = AiLanguageHelper.getLocale(this.mSTTTranslation.getFromLanguageTag());
        Locale locale2 = AiLanguageHelper.getLocale(this.mSTTTranslation.getToLanguageTag());
        if (locale != null && (textView2 = this.mFromTextView) != null) {
            textView2.setMaxLines(AiLanguageHelper.isSeperateLanguagePack(locale.getLanguage()) ? 2 : 1);
            this.mFromTextView.setText(AiLanguageHelper.getDisplayName(locale));
            this.mFromView.requestLayout();
        }
        if (locale2 == null || (textView = this.mToTextView) == null) {
            return;
        }
        textView.setMaxLines(AiLanguageHelper.isSeperateLanguagePack(locale2.getLanguage()) ? 2 : 1);
        this.mToTextView.setText(AiLanguageHelper.getDisplayName(locale2));
        this.mToView.requestLayout();
    }

    private void updateSearch() {
        STTMode currentMode = this.mIAiSTTContract.getMSTTPresenter().getCurrentMode();
        if (FeatureInfo.isSearchSTTInComposerEnabled() && currentMode == STTMode.SEARCH_COMPOSER) {
            int itemIndexPreShowSearch = this.mIAiSTTContract.getMSTTPresenter().getItemIndexPreShowSearch();
            int indexItemToShow = this.mIAiSTTContract.getMSTTPresenter().getMItemIndexToShow();
            if (indexItemToShow > -1) {
                this.mCommonViews.search(indexItemToShow <= itemIndexPreShowSearch, -1);
                this.mCommonViews.getSTTSearchView().hideSearchView();
                this.mCommonViews.getTopView().setVisibilityForSearchMode(false);
            }
        }
    }

    private void updateSelectAllView(int i) {
        AiMenuResultCommonViews aiMenuResultCommonViews;
        if (this.mIAiSTTContract.getMSTTPresenter() == null || (aiMenuResultCommonViews = this.mCommonViews) == null) {
            return;
        }
        ((ViewGroup.MarginLayoutParams) aiMenuResultCommonViews.getTopView().mSTTSelectAllContainer.getLayoutParams()).setMarginStart(i == 2 ? this.mView.getResources().getDimensionPixelSize(C9086R.dimen.ai_menu_result_stt_title_select_all_margin_start_landscape) : this.mView.getResources().getDimensionPixelSize(C9086R.dimen.ai_menu_result_stt_title_select_all_margin_start_potrait));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSelectionBtnState() {
        AiSTTListView aiSTTListView = this.mAiSTTListView;
        if (aiSTTListView == null) {
            return;
        }
        setSelectionBtnState(aiSTTListView.getSelectedItemMap().size() > 0 && this.mAiSTTListView.isSelectionMode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTitleViewMode() {
        AiMenuResultCommonViews aiMenuResultCommonViews = this.mCommonViews;
        if (aiMenuResultCommonViews == null || this.mView == null) {
            return;
        }
        ImageView imageView = aiMenuResultCommonViews.getTopView().mTitleIconView;
        if (!this.mIAiSTTContract.getMSTTPresenter().isSelectionMode()) {
            setViewVisible(this.mCommonViews.getTopView().mSTTSelectAllContainer, false);
            setViewVisible(imageView, true);
            return;
        }
        int size = this.mAiSTTListView.getSelectedItemMap().size();
        int size2 = this.mAiSTTListView.getAiTextDataList().size();
        this.mCommonViews.getTopView().mTitleView.setText(this.mView.getResources().getString(C9086R.string.selected_check_info, Integer.valueOf(size)));
        this.mCommonViews.getTopView().mSTTSelectAllCheckBox.setChecked(size == size2 && size != 0);
        this.mCommonViews.getTopView().mSTTSelectAllCheckBox.setOnClickListener(new ViewOnClickListenerC9738x(this, 1));
        setViewVisible(imageView, false);
        setViewVisible(this.mCommonViews.getTopView().mSTTSelectAllContainer, true);
    }

    public void animateTranslationAutoDetecting(int i) {
        if (!FeatureInfo.isSupportTranslationLanguageAutoDetectingEffect()) {
            Logger.m10999d(TAG, "animateTranslationAutoDetecting# Not supported");
            return;
        }
        AbstractC0000a.m3D(i, "animateTranslationAutoDetecting# height = ", TAG);
        LottieAnimationView lottieAnimationView = this.mTranslationAutoDetecting;
        if (lottieAnimationView == null || lottieAnimationView.isAnimating()) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.mTranslationAutoDetecting.getLayoutParams();
        layoutParams.height = i;
        layoutParams.width = i * 4;
        this.mTranslationAutoDetecting.setLayoutParams(layoutParams);
        this.mTranslationAutoDetecting.setClipToOutline(true);
        this.mTranslationAutoDetecting.setRepeatCount(0);
        this.mTranslationAutoDetecting.setAnimation(ContextUtils.isNightMode(this.mTranslationAutoDetecting.getContext()) ? ComposerConstants.TRANSLATION_AUTO_DETECTING_DARK_LOTTIE_FILE : ComposerConstants.TRANSLATION_AUTO_DETECTING_LIGHT_LOTTIE_FILE);
        if (this.mTranslationAutoDetecting.getLayoutDirection() == 1) {
            this.mTranslationAutoDetecting.setScaleX(-1.0f);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public void clear() {
        AiContextMenuSTTPopup aiContextMenuSTTPopup = this.mAiContextMenuPopup;
        if (aiContextMenuSTTPopup != null && aiContextMenuSTTPopup.isShowing()) {
            this.mAiContextMenuPopup.hide();
            this.mAiContextMenuPopup.setPopupListener(null);
        }
        AiMenuResultViewSTTVoiceListPopup aiMenuResultViewSTTVoiceListPopup = this.mSTTVoiceListPopup;
        if (aiMenuResultViewSTTVoiceListPopup != null && aiMenuResultViewSTTVoiceListPopup.isShowing()) {
            this.mSTTVoiceListPopup.setPopupListener(null);
            this.mSTTVoiceListPopup.hide();
        }
        STTTabletLayoutAction sTTTabletLayoutAction = this.mSTTTabletLayoutAction;
        if (sTTTabletLayoutAction != null) {
            sTTTabletLayoutAction.clear();
            this.mSTTTabletLayoutAction = null;
        }
        if (this.mBroadcastAddedReceiver != null) {
            AiLanguageHelper.unregisterLanguagePackReceiver(BaseUtils.getApplicationContext(), this.mBroadcastAddedReceiver);
            this.mBroadcastAddedReceiver = null;
        }
        if (this.mBroadcastRemovedReceiver != null) {
            AiLanguageHelper.unregisterLanguagePackReceiver(BaseUtils.getApplicationContext(), this.mBroadcastRemovedReceiver);
            this.mBroadcastRemovedReceiver = null;
        }
        if (this.mSTTTranslation != null && !this.mMenuResultViewPresenter.getSavedInstanceState()) {
            this.mSTTTranslation.clear();
        }
        View view = this.mView;
        if (view != null) {
            view.setVisibility(8);
            this.mView = null;
            hideProgress();
        }
        AiMenuResultCommonViews aiMenuResultCommonViews = this.mCommonViews;
        if (aiMenuResultCommonViews != null && aiMenuResultCommonViews.getTopView().mSTTTopContainer != null) {
            this.mCommonViews.getTopView().mSTTTopContainer.setVisibility(8);
        }
        AiMenuResultCommonViews aiMenuResultCommonViews2 = this.mCommonViews;
        if (aiMenuResultCommonViews2 != null && aiMenuResultCommonViews2.getTopView().mTabLayout != null) {
            this.mCommonViews.getTopView().mTabLayout.clearOnTabSelectedListeners();
        }
        AiMenuResultCommonViews aiMenuResultCommonViews3 = this.mCommonViews;
        if (aiMenuResultCommonViews3 != null && aiMenuResultCommonViews3.getTopView().mTitleContainer != null) {
            this.mCommonViews.getTopView().mTitleContainer.findViewById(C9086R.id.ai_menu_result_title).setOnClickListener(null);
            this.mCommonViews.getTopView().mTitleContainer.findViewById(C9086R.id.ic_ai_menu_stt_dropdown).setOnClickListener(null);
        }
        AiContextMenuSTTLongPressPopup aiContextMenuSTTLongPressPopup = this.mAiContextMenuSTTLongPressPopup;
        if (aiContextMenuSTTLongPressPopup != null) {
            aiContextMenuSTTLongPressPopup.dismiss();
        }
        AiMenuResultBottomView.AddToListPopup addToListPopup = this.mAddToListPopup;
        if (addToListPopup != null) {
            addToListPopup.hide();
        }
        this.mMenuResultViewPresenter.getSoftInputManager().blockToShow(false, "AiMenuResultViewSTT#clear");
        this.mIAiSTTContract.removeAiMenuSTTProcessListener(0);
    }

    public void doUpdateTranslatorLayoutPositionOnScroll(int i) {
        STTTranslation sTTTranslation;
        if (this.mTranslationSelectorLayout == null || (sTTTranslation = this.mSTTTranslation) == null || !sTTTranslation.isTranslateMode()) {
            return;
        }
        int iConvertDpToPixel = (int) ResourceUtils.convertDpToPixel(this.mIAiActionSTTResultContainer.getActivity(), 0.0f);
        int i2 = (int) (-ResourceUtils.convertDpToPixel(this.mIAiActionSTTResultContainer.getActivity(), 74.0f));
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTranslationSelectorLayout.getLayoutParams();
        int i4 = layoutParams.topMargin;
        if (i <= 0 || i4 > i2) {
            if (i >= 0 || i4 < iConvertDpToPixel) {
                layoutParams.setMargins(layoutParams.leftMargin, Math.min(Math.max(i4 - i, i2), iConvertDpToPixel), layoutParams.rightMargin, layoutParams.bottomMargin);
                this.mTranslationSelectorLayout.setLayoutParams(layoutParams);
            }
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public AiMenuContract.IAiAction getAction() {
        return this.mSTTTabletLayoutAction;
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.presenter.AiMenuSTTProcessListener
    public void hideHelpView() {
        ViewGroup viewGroup;
        AiMenuResultCommonViews aiMenuResultCommonViews = this.mCommonViews;
        if (aiMenuResultCommonViews != null && (viewGroup = aiMenuResultCommonViews.mSTTHelpView) != null) {
            if (viewGroup.getVisibility() == 8) {
                return;
            }
            this.mCommonViews.mSTTHelpView.setVisibility(8);
            this.mCommonViews.setTopButtonState(true);
        }
        if (this.mSTTTabletLayoutAction == null || !this.mIAiSTTContract.isCurrentVoiceHaveSTTData()) {
            return;
        }
        this.mAiSTTListView.setVisibility(0);
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.presenter.AiMenuSTTProcessListener
    public void hideInfoView() {
        View view;
        if (this.mCommonViews == null || (view = this.mSTTInfoView) == null) {
            return;
        }
        view.setVisibility(8);
        this.mAiSTTListView.setVisibility(0);
        setInfoButtonState(true);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public View inflateView(ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(C9086R.layout.ai_menu_result_stt_layout, viewGroup, false);
        this.mIAiSTTContract.initSTTView(viewInflate);
        return viewInflate;
    }

    public void initFoldLayout(View view) {
    }

    public void initLayout(View view) {
        if (view == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view.findViewById(C9086R.id.ai_menu_result_viewpager_container);
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(C9086R.id.ai_menu_result_stt_auto_transcribe);
        this.mViewAutoTranscribe = constraintLayout;
        if (constraintLayout != null) {
            View viewFindViewById = constraintLayout.findViewById(C9086R.id.ai_auto_transcribe_result_cancel_button);
            this.mCancelAutoTranscribeBtn = viewFindViewById;
            viewFindViewById.setOnClickListener(new ViewOnClickListenerC9738x(this, 2));
        }
        if (viewGroup != null) {
            ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.LayoutParams) viewGroup.getLayoutParams())).topMargin = BaseUtils.getApplicationContext().getResources().getDimensionPixelSize(C9086R.dimen.ai_menu_result_stt_content_top_margin);
        }
        boolean z = this.mView.getResources().getConfiguration().orientation == 2;
        View viewFindViewById2 = view.findViewById(C9086R.id.ai_menu_result_viewpager);
        updateLayout(z, viewFindViewById2.getMeasuredWidth(), viewFindViewById2.getMeasuredHeight());
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public void initView(View view, View view2) {
        if (this.mSTTTabletLayoutAction == null) {
            return;
        }
        this.mCommonViews.getBottomView().hide(false);
        this.mCommonViews.setTopButtonState(true);
        this.mView = view2;
        this.mAiSTTListView = this.mIAiSTTContract.getOriginalSTTListView();
        this.mMenuResultViewPresenter.getComposerViewPresenter().setContextMenuDelegate(false, null);
        this.mTranslationSelectorLayout = view2.findViewById(C9086R.id.translation_language_selector_container);
        this.mTranslationAutoDetecting = (LottieAnimationView) view2.findViewById(C9086R.id.stt_translation_auto_detecting_view);
        this.mSTTInfoView = view2.findViewById(C9086R.id.ai_menu_result_stt_info_container);
        this.mView.setVisibility(0);
        this.mIAiSTTContract.showTabletSTTList();
        this.mCommonViews.getTopView().setTopButtonState(true);
        initChooseLanguageLayout();
        initListView();
        initLayout(view);
        this.mCommonViews.getTopView().mTabLayout.clearOnTabSelectedListeners();
        initTopMenu();
        selectTranscriptTab();
        updateResult();
        initHelpView();
        updateTranslateMode();
        initTranslateConfig();
        updateAutoTranscribeView();
        doInitialStep();
        initDragDrop();
        initEditMode();
        initPopUpWindow();
        updateInfoView();
        restoreSelectionMode();
        updateTitleViewMode();
        updateBottomMenuView();
        updateSearch();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public boolean isBottomMenuSupported() {
        return !isInfoViewShowing();
    }

    public boolean isInfoViewShowing() {
        View view = this.mSTTInfoView;
        return view != null && view.getVisibility() == 0;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public boolean isInitialized() {
        return this.mView != null;
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.presenter.AiMenuSTTProcessListener
    public void onCancelled(String str) {
        if (str == null || !str.equals(this.mCurrentShowingSession)) {
            return;
        }
        hideProgress();
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.presenter.AiMenuSTTProcessListener
    public void onCompleted(String str) {
        if (str == null || !str.equals(this.mCurrentShowingSession)) {
            return;
        }
        if (this.mView == null) {
            Logger.m11000e(TAG, "mView is null");
            return;
        }
        hideProgress();
        updateInfoView();
        boolean z = false;
        this.mCommonViews.getTopView().mSTTTopContainer.setVisibility(0);
        STTPresenter sTTPresenter = this.mIAiSTTContract.getMSTTPresenter();
        int indexItemToShow = sTTPresenter.getMItemIndexToShow();
        if (sTTPresenter.getVoiceDataController().isHaveSTTData(indexItemToShow) && !sTTPresenter.isItemSTTConverting(indexItemToShow)) {
            z = true;
        }
        this.mIAiActionSTTResultContainer.updateResultState(true, z);
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.presenter.AiMenuSTTProcessListener
    public void onConverting(String str, int i) {
        AiMenuResultCommonViews aiMenuResultCommonViews;
        if (str == null || !str.equals(this.mCurrentShowingSession) || this.mView == null || (aiMenuResultCommonViews = this.mCommonViews) == null) {
            return;
        }
        if (aiMenuResultCommonViews.getTranscribeProgressCancelBtn().getVisibility() == 8) {
            this.mCommonViews.getTranscribeProgressCancelBtn().setVisibility(0);
        }
        if (i >= 0) {
            this.mCommonViews.updatePercentProgress(i);
        } else {
            this.mView.post(new RunnableC9739y(this, 3));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.presenter.AiMenuSTTProcessListener
    public void onFailed(String str, String str2, int i) {
        if (str == null || !str.equals(this.mCurrentShowingSession) || this.mCommonViews.handleRestrictedPersonalDataError(str2)) {
            return;
        }
        hideProgress();
        if (i == 0) {
            str2 = this.mView.getContext().getString(C9086R.string.stt_file_type_not_supported);
        }
        this.mCommonViews.mErrMsgView.setText(str2);
        this.mCommonViews.showErrorMessage();
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.presenter.AiMenuSTTProcessListener
    public void onLanguageDetected(String str) {
        this.mCommonViews.setLanguageDetectedText(str);
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.presenter.AiMenuSTTProcessListener
    public void onModeChanged(STTMode sTTMode) {
        if (this.mMenuResultViewPresenter.getSTTTabletLayoutAction() == null) {
            Logger.m11000e(TAG, "onModeChanged# getSTTTabletLayoutAction null, showing other action");
            return;
        }
        STTPresenter sTTPresenter = this.mIAiSTTContract.getMSTTPresenter();
        String str = TAG;
        Logger.m10999d(str, "onModeChanged prevMode " + sTTMode.toString() + " #isSelectionMode " + sTTPresenter.isSelectionMode() + " #isSTTEditMode " + sTTPresenter.isSTTEditMode() + " #isSTTReplayMode " + sTTPresenter.isSTTReplayMode() + " #isTranslateMode " + this.mSTTTranslation.isTranslateMode());
        if (this.mSTTTranslation.isTranslateMode()) {
            STTMode currentMode = sTTPresenter.getCurrentMode();
            STTMode sTTMode2 = STTMode.EDIT;
            if (currentMode == sTTMode2 || currentMode == STTMode.SELECTION || currentMode == STTMode.SEARCH || currentMode == STTMode.SEARCH_COMPOSER) {
                this.mTranslationSelectorLayout.setVisibility(8);
                this.mTranslationSelectorLayout.post(new RunnableC9739y(this, 1));
                if (currentMode == sTTMode2) {
                    this.mAiSTTListView.setTranslateMode(false);
                } else {
                    Logger.m10999d(str, "onModeChanged# translated in " + sTTPresenter.getCurrentMode() + " mode");
                }
            } else {
                this.mTranslationSelectorLayout.setVisibility(0);
                this.mTranslationSelectorLayout.post(new RunnableC9739y(this, 2));
                this.mAiSTTListView.setTranslateMode(true);
                if (sTTMode == sTTMode2) {
                    Logger.m10999d(str, "onModeChanged# translate again");
                    ComposerSA.insertLog(STTConstant.SCREEN_AI_MENU_RESULT_STT_TRANSLATION, STTConstant.EVENT_TRANSLATE, "a");
                    this.mSTTTranslation.execute();
                }
            }
        } else if (sTTMode == STTMode.EDIT) {
            this.mSTTTranslation.setCompleted(false);
        }
        if (sTTPresenter.isSelectionMode()) {
            this.mMenuResultViewPresenter.getSoftInputManager().blockToShow(true, "STT selection mode");
        } else {
            this.mMenuResultViewPresenter.getSoftInputManager().blockToShow(false, "exit STT " + sTTMode.name() + " mode");
            this.mCommonViews.getTopView().mTitleView.setText(this.mIAiSTTContract.getCurrentSTTVoiceName());
            setViewVisible(this.mCommonViews.getTopView().mSTTSelectAllContainer, false);
            setViewVisible(this.mCommonViews.getTopContainer().findViewById(C9086R.id.ai_menu_result_stt_top_selection_container), false);
        }
        updateDropdownView();
        if (sTTPresenter.isSTTEditMode() || sTTPresenter.isSelectionMode() || sTTPresenter.getCurrentMode() == STTMode.SEARCH_COMPOSER || sTTPresenter.getCurrentMode() == STTMode.SEARCH) {
            this.mCommonViews.mViewPager.setUserInputEnabled(false);
            this.mCommonViews.mViewPager.seslGetListView().seslSetHoverScrollEnabled(false);
        } else {
            this.mCommonViews.mViewPager.setUserInputEnabled(true);
            this.mCommonViews.mViewPager.seslGetListView().seslSetHoverScrollEnabled(true);
        }
        if (sTTPresenter.getCurrentMode() == STTMode.SEARCH) {
            this.mIAiSTTContract.getMSTTPresenter().onUpdateListVoiceBtnState(true);
            this.mCommonViews.getSTTSearchView().showSearchView();
            this.mCommonViews.getTopView().mTabLayout.setVisibility(8);
            this.mAiSTTListView.getSttRecyclerView().setPadding(0, 0, 0, (int) this.mCommonViews.mActivity.getResources().getDimension(C9086R.dimen.ai_menu_result_stt_search_view_height));
        } else if (sTTPresenter.getCurrentMode() == STTMode.SEARCH_COMPOSER) {
            this.mIAiSTTContract.getMSTTPresenter().onUpdateListVoiceBtnState(false);
            this.mCommonViews.getTopView().setVisibilityForSearchMode(false);
            this.mCommonViews.getSTTSearchView().showSearchViewComposerMode();
            this.mCommonViews.getTopView().mTabLayout.setVisibility(8);
        } else {
            this.mIAiSTTContract.getMSTTPresenter().onUpdateListVoiceBtnState(true);
            this.mCommonViews.getTopView().mSTTContextBtn.setVisibility(0);
            this.mCommonViews.getSTTSearchView().hideSearchView();
            this.mCommonViews.getTopView().mTabLayout.setVisibility(0);
            if (this.mIAiSTTContract.getMSTTPresenter().isAutoTranscribeItemRunning()) {
                this.mCommonViews.getTopView().mSTTContextBtn.setVisibility(8);
                this.mCommonViews.getSTTSearchView().hideSearchView();
                this.mCommonViews.getTopView().mTabLayout.setVisibility(8);
            }
            this.mAiSTTListView.getSttRecyclerView().setPadding(0, 0, 0, 0);
        }
        if (this.mView != null) {
            this.mHandler.post(this.mUpdateLayoutRunnable);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AbsAiActionResultView, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public void onOrientationChanged(int i) {
        if (this.mOrientation != i) {
            if (this.mMenuResultViewPresenter.isSTTEditMode() && !AiViewUtils.isSupportFloatingLayout()) {
                this.mMenuResultViewPresenter.getSoftInputManager().hide(true);
            }
            this.mOrientation = i;
        }
        hideAllPopup();
        updateAISTTListView();
        updateSelectAllView(i);
        this.mHandler.post(new RunnableC9739y(this, 7));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AbsAiActionResultView, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public void onPageSelected() {
        if (isInitialized()) {
            updateDividerVisibility();
            AiMenuResultCommonViews aiMenuResultCommonViews = this.mCommonViews;
            if (aiMenuResultCommonViews == null) {
                return;
            }
            aiMenuResultCommonViews.getTopView().mTabLayout.clearOnTabSelectedListeners();
            initTopMenu();
            this.mCommonViews.getTopView().mSTTTopContainer.setVisibility(0);
            if (this.mIAiSTTContract.getMSTTPresenter().getCurrentMode() == STTMode.SEARCH_COMPOSER) {
                this.mCommonViews.getTopView().mSTTContextBtn.setVisibility(8);
            } else {
                this.mCommonViews.getTopView().mSTTContextBtn.setVisibility(0);
            }
            if (this.mCommonViews.getTopView().mSTTTranslateBtn != null) {
                this.mCommonViews.getTopView().mSTTTranslateBtn.setVisibility(0);
                this.mCommonViews.getTopView().mSTTTranslateBtn.setSelected(this.mSTTTranslation.isTranslateMode());
            }
            if (this.mCommonViews.getTopView().mSTTDisclaimerBtn != null) {
                this.mCommonViews.getTopView().mSTTDisclaimerBtn.setVisibility(0);
                initSTTDisclaimerBtnListener();
            }
            if (this.mCommonViews.getTopView().mTabLayout.getSelectedTabPosition() == 1 && this.mIAiSTTContract.isEditMode()) {
                this.mIAiSTTContract.toggleEditMode();
            }
            updateInfoView();
            selectTranscriptTab();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public void onResume() {
        STTTranslation sTTTranslation = this.mSTTTranslation;
        if (sTTTranslation == null || !sTTTranslation.isTranslateMode()) {
            return;
        }
        String str = TAG;
        StringBuilder sb = new StringBuilder("onResume# check language status : ");
        sb.append(this.mIsNeedCheckLanguage);
        sb.append(", check download language : ");
        AbstractC8014b.m7215q(sb, this.mIsRequestedDownloadLanguage, str);
        if (this.mIsNeedCheckLanguage) {
            this.mIsNeedCheckLanguage = false;
            AiLanguageHelper.updateLanguageList(new RunnableC9739y(this, 4));
        } else if (this.mIsRequestedDownloadLanguage) {
            this.mIsRequestedDownloadLanguage = false;
            AiLanguageHelper.updateLanguageList(new RunnableC9739y(this, 5));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.presenter.AiMenuSTTProcessListener
    public void onSTTDataSaved() {
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.presenter.AiMenuSTTProcessListener
    public void onSTTItemCheckedChange(Map<Integer, Boolean> map) {
        updateTitleViewMode();
        updateSelectionBtnState();
    }

    public void onSaveInstanceState() {
        this.mIAiSTTContract.getMSTTPresenter().setSavedInstanceState(true);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.STTTranslateResultListener
    public void onTranslateCompleted(boolean z, int i) {
        Logger.m11003i(TAG, "onTranslateCompleted# isLast : " + z + ", index : " + i);
        AiSTTListView aiSTTListView = this.mAiSTTListView;
        if (aiSTTListView == null) {
            return;
        }
        if (!z) {
            aiSTTListView.notifyItemChanged(i);
            return;
        }
        aiSTTListView.notifyDataSetChanged();
        AiContextMenuSTTPopup aiContextMenuSTTPopup = this.mAiContextMenuPopup;
        if (aiContextMenuSTTPopup != null) {
            aiContextMenuSTTPopup.enableCopyText();
        }
        setSelectionBtnState(true);
        setSelectLanguageLayoutState(true);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.STTTranslateResultListener
    public void onTranslateFailed(String str) {
        AbstractC8014b.m7198D("Translate error: ", str, TAG);
        if (this.mCommonViews.handleRestrictedPersonalDataError(str)) {
            return;
        }
        this.mCommonViews.hideProgress();
        this.mCommonViews.mErrMsgView.setText(str);
        this.mCommonViews.showErrorMessage();
        this.mIAiActionSTTResultContainer.updateResultState(false, false);
        if (this.mCommonViews.isShowingErrorMessage()) {
            return;
        }
        ToastHandler.show(this.mCommonViews.mErrMsgView.getContext(), str, 0);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.STTTranslateResultListener
    public void onTranslateStart() {
        AiContextMenuSTTPopup aiContextMenuSTTPopup = this.mAiContextMenuPopup;
        if (aiContextMenuSTTPopup != null) {
            aiContextMenuSTTPopup.disableCopyText();
        }
        setSelectionBtnState(false);
        setSelectLanguageLayoutState(false);
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.presenter.AiMenuSTTProcessListener
    public void onVoiceInfoChanged() {
        View view = this.mView;
        if (view == null) {
            return;
        }
        view.post(new RunnableC9739y(this, 0));
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.presenter.AiMenuSTTProcessListener
    public void resetSTTViewToDefault() {
        AiMenuResultCommonViews aiMenuResultCommonViews = this.mCommonViews;
        if (aiMenuResultCommonViews != null && aiMenuResultCommonViews.isShowingProgress()) {
            this.mCommonViews.hideProgress();
            this.mCommonViews.mViewPager.setUserInputEnabled(true);
            this.mCommonViews.mViewPager.seslGetListView().seslSetHoverScrollEnabled(true);
        }
        if (this.mSTTTranslation.isTranslateMode()) {
            this.mSTTTranslation.clear();
            this.mSTTTranslation.stop();
            updateTranslateMode();
        }
        STTPresenter sTTPresenter = this.mIAiSTTContract.getMSTTPresenter();
        if (sTTPresenter.isSelectionMode() || sTTPresenter.isSTTEditMode() || sTTPresenter.isSTTSearchMode() || sTTPresenter.isComposerSearchMode()) {
            sTTPresenter.setMode(STTMode.REPLAY);
        }
    }

    public void selectTranscriptTab() {
        TabLayout.Tab tabAt = this.mCommonViews.getTopView().mTabLayout.getTabAt(0);
        if (tabAt != null) {
            tabAt.select();
        }
        this.mCommonViews.getTopView().mTabLayout.setScrollPosition(0, 0.0f, true);
    }

    public void setButtonState(View view, boolean z) {
        if (view == null) {
            return;
        }
        float f = z ? 1.0f : 0.4f;
        view.setEnabled(z);
        view.setAlpha(f);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public void setTitle() {
        this.mCommonViews.getTopView().setTitle(this.mIAiSTTContract.getCurrentSTTVoiceName(), C9086R.drawable.ic_ai_menu_title, (Integer) null);
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.presenter.AiMenuSTTProcessListener
    public void showAutoDetectHelpView(String str, int i, String str2) {
        if (str == null || !str.equals(this.mCurrentShowingSession) || this.mView == null || this.mCommonViews == null) {
            return;
        }
        if (this.mMenuResultViewPresenter.getSTTTabletLayoutAction() == null) {
            Logger.m11000e(TAG, "showHelpView# getSTTTabletLayoutAction null, showing other action");
            return;
        }
        hideProgress();
        this.mCommonViews.getTopView().mTitleView.setText(this.mIAiSTTContract.getCurrentVoiceName(i));
        this.mCommonViews.setTopButtonState(false);
        this.mCommonViews.getTopView().mTabLayout.setVisibility(8);
        this.mCommonViews.mSTTHelpView.setVisibility(0);
        TextView textView = (TextView) this.mCommonViews.mSTTHelpView.findViewById(C9086R.id.ai_menu_result_help_transribe_button);
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0);
        textView.setCompoundDrawablePadding(0);
        textView.setPaddingRelative((int) ResourceUtils.convertDpToPixel(this.mCommonViews.mActivity, 16.0f), textView.getPaddingTop(), (int) ResourceUtils.convertDpToPixel(this.mCommonViews.mActivity, 16.0f), textView.getPaddingBottom());
        textView.setText(str2);
        textView.setOnClickListener(new ViewOnClickListenerC9740z(this, i, 1));
        TextView textView2 = (TextView) this.mCommonViews.mSTTHelpView.findViewById(C9086R.id.ai_menu_result_help_transribe_transcribe_with_other_language);
        textView2.setVisibility(0);
        textView2.setOnClickListener(new ViewOnClickListenerC9738x(this, 8));
        textView2.post(new RunnableC9735u(textView, textView2, 3));
        this.mAiSTTListView.setVisibility(4);
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.presenter.AiMenuSTTProcessListener
    public void showHelpView(int i) {
        if (this.mMenuResultViewPresenter.getSTTTabletLayoutAction() == null) {
            Logger.m11000e(TAG, "showHelpView# getSTTTabletLayoutAction null, showing other action");
            return;
        }
        List<SpenVoiceData> voiceDataList = this.mIAiSTTContract.getMSTTPresenter().getVoiceDataList();
        if (i < 0 || i >= voiceDataList.size()) {
            Logger.m11000e(TAG, "showHelpView# position out of bounds");
            return;
        }
        if (this.mView == null) {
            Logger.m11000e(TAG, "showHelpView# mView is null, can't action");
            return;
        }
        if (AiViewUtils.isAtLeastOneUI85() && FastConvertController.getInstance().isHasItemConverting() && this.mCommonViews.isShowingProgress()) {
            this.mCommonViews.hideProgress();
        }
        this.mCurrentShowingSession = this.mIAiSTTContract.getCurrentConvertSession();
        if (FastConvertController.getInstance().isAutoTranscribeConverting(voiceDataList.get(i).getMHandle() + "")) {
            Logger.m11000e(TAG, "hideHelpView# isAutoTranscribe");
            hideHelpView();
            return;
        }
        this.mCommonViews.getTopView().mTitleView.setText(this.mIAiSTTContract.getCurrentVoiceName(i));
        this.mCommonViews.setTopButtonState(false);
        this.mCommonViews.getTopView().mTabLayout.setVisibility(8);
        this.mCommonViews.mSTTHelpView.setVisibility(0);
        ((TextView) this.mCommonViews.mSTTHelpView.findViewById(C9086R.id.ai_menu_result_help_transribe_transcribe_with_other_language)).setVisibility(8);
        TextView textView = (TextView) this.mCommonViews.mSTTHelpView.findViewById(C9086R.id.ai_menu_result_help_transribe_button);
        Drawable drawable = AppCompatResources.getDrawable(this.mView.getContext(), C9086R.drawable.ic_ai_stt_transcribe_help_view_btn);
        if (drawable != null) {
            DrawableCompat.setTint(drawable, this.mView.getContext().getColor(C9086R.color.ai_menu_result_stt_help_btn_color));
        }
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setCompoundDrawablePadding((int) ResourceUtils.convertDpToPixel(this.mView.getContext(), 2.0f));
        textView.setPaddingRelative((int) ResourceUtils.convertDpToPixel(this.mCommonViews.mActivity, 50.0f), textView.getPaddingTop(), (int) ResourceUtils.convertDpToPixel(this.mCommonViews.mActivity, 50.0f), textView.getPaddingBottom());
        textView.setMinWidth((int) ResourceUtils.convertDpToPixel(this.mCommonViews.mActivity, 200.0f));
        textView.setText(C9086R.string.ai_result_transcribe_btn);
        textView.setOnClickListener(new ViewOnClickListenerC9740z(this, i, 0));
        this.mAiSTTListView.setVisibility(4);
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.presenter.AiMenuSTTProcessListener
    public void showInfoView() {
        if (this.mCommonViews == null || this.mSTTInfoView == null) {
            return;
        }
        if (this.mMenuResultViewPresenter.getSTTTabletLayoutAction() == null) {
            Logger.m11000e(TAG, "showInfoView# getSTTTabletLayoutAction null, showing other action");
            return;
        }
        this.mCurrentShowingSession = this.mIAiSTTContract.getCurrentConvertSession();
        this.mCommonViews.getTopView().mTitleView.setText(this.mIAiSTTContract.getCurrentSTTVoiceName());
        setInfoButtonState(false);
        ((TextView) this.mSTTInfoView.findViewById(C9086R.id.ai_menu_result_info_message_view)).setText(C9086R.string.stt_info_message_no_speech_detected);
        this.mSTTInfoView.setVisibility(0);
        AiSTTListView aiSTTListView = this.mAiSTTListView;
        if (aiSTTListView != null) {
            aiSTTListView.setVisibility(8);
        }
    }

    public void showLanguageSelectorDialog(final boolean z) {
        FragmentManager supportFragmentManager;
        if (!isInitialized() || (supportFragmentManager = getSupportFragmentManager()) == null || supportFragmentManager.isDestroyed()) {
            return;
        }
        String str = SelectTranslateLanguageDialog.TAG;
        if (((SelectTranslateLanguageDialog) supportFragmentManager.findFragmentByTag(str)) != null) {
            return;
        }
        Locale locale = AiLanguageHelper.getLocale(this.mSTTTranslation.getFromLanguageTag());
        Locale locale2 = AiLanguageHelper.getLocale(this.mSTTTranslation.getToLanguageTag());
        if (locale == null && locale2 == null) {
            return;
        }
        if (!z) {
            z = this.mSTTTranslation.getToLanguageState() == 1;
            locale = locale2;
        } else if (this.mSTTTranslation.getFromLanguageState() == 1) {
            z = true;
        }
        SelectTranslateLanguageDialog selectTranslateLanguageDialog = new SelectTranslateLanguageDialog();
        selectTranslateLanguageDialog.setContract(z, locale, new SelectTranslateLanguageDialog.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTT.11
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.dialog.SelectTranslateLanguageDialog.Contract
            public void onAddLanguagesClick() {
                if (z) {
                    ComposerSA.insertLog(STTConstant.SCREEN_AI_MENU_RESULT_STT_TRANSLATION, STTConstant.EVENT_ADD_LANGUAGES_SOURCE);
                } else {
                    ComposerSA.insertLog(STTConstant.SCREEN_AI_MENU_RESULT_STT_TRANSLATION, STTConstant.EVENT_ADD_LANGUAGES_TARGET);
                }
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.dialog.SelectTranslateLanguageDialog.Contract
            public void onCancel(boolean z2) {
                AbstractC8014b.m7224z("onCancle# ", AiMenuResultViewSTT.TAG, z2);
                if (z) {
                    ComposerSA.insertLog(STTConstant.SCREEN_AI_MENU_RESULT_STT_TRANSLATION, STTConstant.EVENT_CANCEL_SOURCE);
                } else {
                    ComposerSA.insertLog(STTConstant.SCREEN_AI_MENU_RESULT_STT_TRANSLATION, STTConstant.EVENT_CANCEL_TARGET);
                }
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.dialog.SelectTranslateLanguageDialog.Contract
            public void setSelectedLocale(Locale locale3) {
                String languageTag = locale3.toLanguageTag();
                String fromLanguageTag = AiMenuResultViewSTT.this.mSTTTranslation.getFromLanguageTag();
                String toLanguageTag = AiMenuResultViewSTT.this.mSTTTranslation.getToLanguageTag();
                String languageTag2 = Locale.getDefault().toLanguageTag();
                Logger.m11003i(AiMenuResultViewSTT.TAG, "setSelectedLocale# " + z + " - " + languageTag);
                if (z) {
                    if (AiMenuResultViewSTT.this.mSTTTranslation.getFromLanguageTag().equals(languageTag) && (!z || AiMenuResultViewSTT.this.mSTTTranslation.getFromLanguageState() != 0)) {
                        Logger.m10999d(AiMenuResultViewSTT.TAG, "setSelectedLocale source: skip, same old source");
                        return;
                    }
                    AiMenuResultViewSTT.this.mSTTTranslation.setFromLanguageTag(languageTag);
                } else {
                    if (AiMenuResultViewSTT.this.mSTTTranslation.getToLanguageTag().equals(languageTag) && (!z || AiMenuResultViewSTT.this.mSTTTranslation.getToLanguageState() != 0)) {
                        Logger.m10999d(AiMenuResultViewSTT.TAG, "setSelectedLocale target: skip, same old target");
                        return;
                    }
                    AiMenuResultViewSTT.this.mSTTTranslation.setToLanguageTag(languageTag);
                }
                if (AiMenuResultViewSTT.this.mSTTTranslation.isSame()) {
                    AiMenuResultViewSTT.this.mSTTTranslation.clearTranslatedData();
                }
                AiMenuResultViewSTT.this.updateLanguage();
                AiMenuResultViewSTT.this.requestTranslate();
                String str2 = z ? STTConstant.EVENT_TRANSLATION_SOURCE : STTConstant.EVENT_TRANSLATION_TARGET;
                ComposerSA.insertLog(STTConstant.SCREEN_AI_MENU_RESULT_STT_TRANSLATION, str2, languageTag);
                ComposerSA.insertLog(STTConstant.SCREEN_AI_MENU_RESULT_STT_TRANSLATION, str2, "b", languageTag.equals(languageTag2) ? 1L : 0L);
                if (!z) {
                    fromLanguageTag = toLanguageTag;
                }
                ComposerSA.insertLog(STTConstant.SCREEN_AI_MENU_RESULT_STT_TRANSLATION, str2, "c", languageTag.equals(fromLanguageTag) ? 1L : 0L);
                ComposerSA.insertLog(STTConstant.SCREEN_AI_MENU_RESULT_STT_TRANSLATION, STTConstant.EVENT_TRANSLATE, z ? "b" : "c");
            }
        });
        selectTranslateLanguageDialog.showAllowingStateLoss(supportFragmentManager, str);
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.presenter.AiMenuSTTProcessListener
    public void updateAutoTranscribeView() {
        if (this.mAiSTTListView == null) {
            Logger.m11000e(TAG, "updateAutoTranscribe mAiSTTListView null");
            return;
        }
        ISTTWindow.IAIContract iAIContract = this.mIAiSTTContract;
        if (iAIContract != null) {
            boolean zIsAutoTranscribeItemRunning = iAIContract.getMSTTPresenter().isAutoTranscribeItemRunning();
            if (this.mCommonViews.getTopView().mTabLayout == null || this.mViewAutoTranscribe == null) {
                return;
            }
            AbstractC8014b.m7220v("updateAutoTranscribe isAutoTranscribe = ", TAG, zIsAutoTranscribeItemRunning);
            if (!zIsAutoTranscribeItemRunning) {
                this.mCommonViews.getTopView().mTabLayout.setVisibility(0);
                this.mViewAutoTranscribe.setVisibility(8);
                this.isShowingLightEffect = false;
                if (Build.VERSION.SDK_INT >= 33) {
                    AIGuidingLightEffect.removeGuideLightingEffect(this.mViewAutoTranscribe);
                    return;
                }
                return;
            }
            this.mCommonViews.getTopView().mTabLayout.setVisibility(8);
            this.mViewAutoTranscribe.setVisibility(0);
            if (this.isShowingLightEffect || Build.VERSION.SDK_INT < 33) {
                return;
            }
            AIGuidingLightEffect.applyGuidingLightEffectBackground(this.mViewAutoTranscribe, BaseUtils.getContext(), BaseUtils.getApplicationContext().getResources().getDimensionPixelSize(C9086R.dimen.ai_view_auto_transcribe_guiding_light_inset), BaseUtils.getApplicationContext().getResources().getDimensionPixelSize(C9086R.dimen.ai_view_auto_transcribe_guiding_light_radius));
            this.isShowingLightEffect = true;
            onVoiceInfoChanged();
        }
    }

    public void updateInfoView() {
        if (FastConvertController.getInstance().isConverting(this.mCurrentShowingSession) || !this.mIAiSTTContract.isCurrentVoiceHaveSTTData()) {
            return;
        }
        if (this.mIAiSTTContract.checkCurrentVoiceEmptyData()) {
            showInfoView();
        } else {
            hideInfoView();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AbsAiActionResultView, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public void updateLayout(boolean z, int i, int i2) {
        String str = TAG;
        StringBuilder sb = new StringBuilder("updateLayout# landscape ");
        sb.append(z);
        sb.append(" ");
        sb.append(i);
        sb.append(" - ");
        AbstractC8014b.m7221w(sb, str, i2);
        this.mViewWidth = i;
        this.mViewHeight = i2;
        this.mHandler.removeCallbacks(this.mUpdateLayoutRunnable);
        this.mHandler.postDelayed(this.mUpdateLayoutRunnable, 100L);
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.presenter.AiMenuSTTProcessListener
    public void updateRealtimeCompleteView() {
        ISTTWindow.IAIContract iAIContract;
        if (Features.isAutoTranscribeEnable()) {
            if (this.mMenuResultViewPresenter.getSTTTabletLayoutAction() == null) {
                Logger.m11000e(TAG, "updateRealtimeCompleteView# getSTTTabletLayoutAction null, showing other action");
                return;
            }
            if (this.mAiSTTListView == null || (iAIContract = this.mIAiSTTContract) == null || iAIContract.getMSTTPresenter() == null) {
                Logger.m11000e(TAG, "updateRealtimeCompleteView null");
            } else {
                updateAutoTranscribeView();
                this.mAiSTTListView.notifyDataSetChanged();
            }
        }
    }

    public void updateResult() {
        if (this.mSTTTabletLayoutAction.isWorking()) {
            this.mCommonViews.setTopButtonState(false);
            this.mCommonViews.updatePercentProgress(this.mSTTTabletLayoutAction.getConvertingPercent());
            this.mCommonViews.showProgress(7);
            this.mCommonViews.getTranscribeProgressCancelBtn().setVisibility(0);
            disableListViewAccessibility();
            return;
        }
        if (this.mSTTTabletLayoutAction.getLastErrorMessage() == null) {
            onCompleted(this.mCurrentShowingSession);
        } else {
            Logger.m10999d(TAG, "updateResult# onFailed");
            onFailed(this.mCurrentShowingSession, this.mSTTTabletLayoutAction.getLastErrorMessage(), 0);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AbsAiActionResultView
    public void updateTopContainerLayout() {
        AiMenuResultCommonViews aiMenuResultCommonViews = this.mCommonViews;
        if (aiMenuResultCommonViews == null || this.mAiSTTListView == null) {
            return;
        }
        View view = aiMenuResultCommonViews.getTopView().mTitleMenuContainer;
        View viewFindViewById = view.findViewById(C9086R.id.ai_menu_result_title_icon);
        View viewFindViewById2 = view.findViewById(C9086R.id.ai_menu_result_title_container);
        View viewFindViewById3 = view.findViewById(C9086R.id.ai_menu_result_stt_translate_btn);
        View viewFindViewById4 = view.findViewById(C9086R.id.ai_menu_result_stt_disclaimer_btn);
        View viewFindViewById5 = view.findViewById(C9086R.id.ai_menu_result_stt_context_btn);
        if (this.mIAiActionSTTResultContainer.isMinimizeView()) {
            viewFindViewById2.setVisibility(0);
            this.mCommonViews.getTopView().mSTTDropdown.setVisibility(8);
            this.mCommonViews.getTopView().mSTTDropdown.setOnClickListener(null);
            this.mCommonViews.getTopView().mTitleView.setOnClickListener(null);
            return;
        }
        updateDropdownView();
        this.mCommonViews.getTopView().mTitleView.setOnClickListener(this.mDropDownListListener);
        this.mCommonViews.getTopView().mSTTDropdown.setOnClickListener(this.mDropDownListListener);
        int width = view.getWidth();
        int iConvertDpToPixel = (int) ResourceUtils.convertDpToPixel(this.mMenuResultViewPresenter.getActivity(), JPEG.APP11);
        int iConvertDpToPixel2 = (int) ResourceUtils.convertDpToPixel(this.mMenuResultViewPresenter.getActivity(), 205);
        if (this.mIAiSTTContract.getMSTTPresenter().getCurrentMode() == STTMode.REPLAY) {
            viewFindViewById4.setVisibility(0);
            viewFindViewById3.setVisibility(0);
            viewFindViewById5.setVisibility(0);
            if (width >= iConvertDpToPixel) {
                viewFindViewById.setVisibility(0);
                viewFindViewById2.setVisibility(0);
            } else {
                viewFindViewById2.setVisibility(8);
                if (width < iConvertDpToPixel2) {
                    viewFindViewById.setVisibility(8);
                }
            }
        }
    }

    public void updateTranslateMode() {
        AiContextMenuSTTPopup aiContextMenuSTTPopup;
        if (this.mAiSTTListView == null) {
            Logger.m11000e(TAG, "updateTranslateMode mAiSTTListView null");
            return;
        }
        if (!this.mIAiSTTContract.getMSTTPresenter().isSTTReplayMode()) {
            Logger.m10999d(TAG, "skip updateTranslateMode not in ReplayMode");
            return;
        }
        AiMenuResultCommonViews aiMenuResultCommonViews = this.mCommonViews;
        if (aiMenuResultCommonViews != null && aiMenuResultCommonViews.getTopView().mSTTTranslateBtn != null) {
            this.mCommonViews.getTopView().mSTTTranslateBtn.setSelected(this.mSTTTranslation.isTranslateMode());
        }
        int measuredHeight = this.mTranslationSelectorLayout.getMeasuredHeight();
        if (this.mSTTTranslation.isTranslateMode()) {
            this.mAiSTTListView.setTranslateMode(true);
            this.mTranslationSelectorLayout.setVisibility(0);
            if (this.mSTTTranslation.isTranslatePending() && (aiContextMenuSTTPopup = this.mAiContextMenuPopup) != null) {
                aiContextMenuSTTPopup.disableCopyText();
                setSelectLanguageLayoutState(false);
            }
        } else {
            this.mTranslationSelectorLayout.setVisibility(8);
            this.mAiSTTListView.setTranslateMode(false);
            AiContextMenuSTTPopup aiContextMenuSTTPopup2 = this.mAiContextMenuPopup;
            if (aiContextMenuSTTPopup2 != null) {
                aiContextMenuSTTPopup2.enableCopyText();
            }
        }
        this.mTranslationSelectorLayout.post(new RunnableC0050f(this, measuredHeight, 20));
        if (this.mSTTTranslation.isCompleted()) {
            if (this.mSTTTranslation.getTranslatedList() != null) {
                this.mIAiSTTContract.getOriginalSTTListView().setAiTextDataList(this.mSTTTranslation.getTranslatedList());
            }
            this.mAiSTTListView.notifyDataSetChanged();
        }
        updateLanguage();
    }
}
