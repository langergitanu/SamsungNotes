package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.DragEvent;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.glance.AbstractC2821a;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.tabs.TabLayout;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.dialog.AiDisclaimerDialog;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.common.view.penrecyclerview.BasePenRecyclerView;
import com.samsung.android.support.senl.p148nt.base.common.view.penrecyclerview.OnPenMultiSelectionListener;
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
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.STTSummarization;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.STTSummarizeTranslation;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.STTTranslation;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AiContextMenuSTTPopup;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AiMenuResultBottomView;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerRequestCode;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog.SelectTranslateLanguageDialog;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.stt.ISTTWindow;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.stt.base.model.mode.STTMode;
import com.samsung.android.support.senl.p148nt.stt.common.constant.STTConstant;
import com.samsung.android.support.senl.p148nt.stt.presenter.AiMenuSTTProcessListener;
import com.samsung.android.support.senl.p148nt.stt.presenter.STTPresenter;
import com.samsung.android.support.senl.p148nt.stt.view.AiSTTListView;
import com.sun.imageio.plugins.jpeg.JPEG;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import org.jetbrains.annotations.NotNull;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiMenuResultViewSTTSummarization extends AbsAiActionResultView implements AiMenuContract.ResultListener, AiMenuSTTProcessListener, AiMenuContract.STTTranslateResultListener, STTSummarizationAdapterContract {
    private static final String TAG = Logger.createTag("AiMenuResultViewSTTSummarization", AiConstants.PREFIX_TAG);
    private final Runnable dragDropRunnable;
    private AiMenuResultBottomView.AddToListPopup mAddToListPopup;
    private AiContextMenuSTTPopup mAiContextMenuPopup;
    private BroadcastReceiver mBroadcastAddedReceiver;
    private BroadcastReceiver mBroadcastRemovedReceiver;
    private int mContextCurrentPos;
    private int mDistance;
    private int mDragDistanceThreshold;
    private TextView mFromTextView;
    private View mFromView;
    private View.OnClickListener mFromViewListener;
    private GestureDetector mGestureDetector;
    AiMenuContract.IAiActionSTTResultContainer mIAiActionSTTResultContainer;
    private ISTTWindow.IAIContract mIAiSTTContract;
    private boolean mIsNeedCheckLanguage;
    private boolean mIsNeedTranslateAgain;
    private boolean mIsPendingDragDropAction;
    private boolean mIsRequestedDownloadLanguage;
    private boolean mIsStartedDragDropAction;
    private final AiMenuResultViewPresenter mMenuResultViewPresenter;
    private RecyclerView.OnItemTouchListener mOnItemTouchListener;
    private View mSTTInfoView;
    private STTSummarization mSTTSummarization;
    private STTSummarizeTranslation mSTTSummarizeTranslation;
    private AiMenuResultViewSTTSummarizationAdapter mSTTSummaryResultAdapter;
    private BasePenRecyclerView mSTTSummaryResultRecyclerView;
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
    public long mUserScrollTime;
    private View mView;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTTSummarization$22 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C963422 implements STTTranslation.LanguageIdentifyCallback {
        public C963422() {
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.STTTranslation.LanguageIdentifyCallback
        public void onComplete() {
            AiMenuResultViewSTTSummarization.this.mView.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTTSummarization.22.1
                @Override // java.lang.Runnable
                public void run() {
                    Logger.m10999d(AiMenuResultViewSTTSummarization.TAG, "LanguageIdentifierCallback#onComplete#");
                    if (FeatureInfo.isSupportTranslationLanguageAutoDetectingEffect() && AiMenuResultViewSTTSummarization.this.mIAiSTTContract.getMSTTPresenter().getMIsTranslateSTTSummarizationFirstTime()) {
                        AiMenuResultViewSTTSummarization.this.mIAiSTTContract.getMSTTPresenter().setMIsTranslateSTTSummarizationFirstTime(false);
                        AiMenuResultViewSTTSummarization.this.mTranslationSelectorLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTTSummarization.22.1.1
                            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                            public void onGlobalLayout() {
                                AiMenuResultViewSTTSummarization.this.mTranslationSelectorLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                                AiMenuResultViewSTTSummarization aiMenuResultViewSTTSummarization = AiMenuResultViewSTTSummarization.this;
                                aiMenuResultViewSTTSummarization.animateTranslationAutoDetecting(aiMenuResultViewSTTSummarization.mTranslationSelectorLayout.getHeight());
                                AiMenuResultViewSTTSummarization.this.mTranslationAutoDetecting.playAnimation();
                            }
                        });
                    }
                    if (AiMenuResultViewSTTSummarization.this.doInitialStep() || AiMenuResultViewSTTSummarization.this.mSTTSummarizeTranslation.isWaitingFirstResult()) {
                        return;
                    }
                    AiMenuResultViewSTTSummarization.this.mCommonViews.hideProgress();
                }
            });
        }
    }

    public AiMenuResultViewSTTSummarization(AiMenuResultViewPresenter aiMenuResultViewPresenter, AiMenuResultCommonViews aiMenuResultCommonViews, AiMenuContract.IAiActionSTTResultContainer iAiActionSTTResultContainer, ISTTWindow.IAIContract iAIContract) {
        super(aiMenuResultCommonViews);
        this.mIsNeedTranslateAgain = false;
        this.mIsNeedCheckLanguage = false;
        this.mIsRequestedDownloadLanguage = false;
        this.mIsPendingDragDropAction = false;
        this.mIsStartedDragDropAction = false;
        this.mContextCurrentPos = -1;
        this.mUserScrollTime = 0L;
        this.mUpdateLayoutRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTTSummarization.1
            @Override // java.lang.Runnable
            public void run() {
                String str = AiMenuResultViewSTTSummarization.TAG;
                StringBuilder sb = new StringBuilder("mUpdateLayoutRunnable#  ");
                sb.append(AiMenuResultViewSTTSummarization.this.mViewWidth);
                sb.append(" - ");
                AbstractC8014b.m7221w(sb, str, AiMenuResultViewSTTSummarization.this.mViewHeight);
                if (AiMenuResultViewSTTSummarization.this.mMenuResultViewPresenter.getSTTSummarization() == null) {
                    Logger.m11000e(AiMenuResultViewSTTSummarization.TAG, "getSTTSummarization null, showing other action");
                    return;
                }
                if (AiMenuResultViewSTTSummarization.this.mCommonViews.mViewPager.getCurrentItem() != 1) {
                    Logger.m11000e(AiMenuResultViewSTTSummarization.TAG, "mViewPager is not showing current item");
                    return;
                }
                AiMenuResultViewSTTSummarization.this.toggleModeBottomMenu();
                AiMenuResultViewSTTSummarization.this.updateTitleViewMode();
                AiMenuResultViewSTTSummarization.this.updateSelectionBtnState();
                AiMenuResultViewSTTSummarization.this.updateTopContainerLayout();
                if (AiMenuResultViewSTTSummarization.this.mAiContextMenuPopup == null || !AiMenuResultViewSTTSummarization.this.mAiContextMenuPopup.isShowing()) {
                    return;
                }
                AiMenuResultViewSTTSummarization.this.mCommonViews.getTopView().mContextBtn.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTTSummarization.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AiMenuResultViewSTTSummarization.this.mAiContextMenuPopup.show(AiMenuResultViewSTTSummarization.this.mCommonViews.getTopView().mSTTContextBtn);
                    }
                });
            }
        };
        this.dragDropRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTTSummarization.2
            @Override // java.lang.Runnable
            public void run() {
                if (AiMenuResultViewSTTSummarization.this.mView == null || AiMenuResultViewSTTSummarization.this.mSTTSummaryResultRecyclerView == null || AiMenuResultViewSTTSummarization.this.mMenuResultViewPresenter == null || AiMenuResultViewSTTSummarization.this.mSTTSummarization == null) {
                    Logger.m11000e(AiMenuResultViewSTTSummarization.TAG, "dragDropRunnable# null object");
                    return;
                }
                AiMenuResultViewSTTSummarization.this.mIsPendingDragDropAction = false;
                ViewCompat.getInstance().performHapticFeedback(AiMenuResultViewSTTSummarization.this.mView, 110);
                AiMenuResultViewSTTSummarization.this.mMenuResultViewPresenter.startDragAndDrop(AiMenuResultViewSTTSummarization.this.mView, AiMenuResultViewSTTSummarization.this.mSTTSummarization.getResultToCopy());
                if (!AiViewUtils.isSupportFloatingLayout()) {
                    AiMenuResultViewSTTSummarization.this.mView.setOnDragListener(new View.OnDragListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTTSummarization.2.1
                        @Override // android.view.View.OnDragListener
                        public boolean onDrag(View view, DragEvent dragEvent) {
                            int action = dragEvent.getAction();
                            if (action == 1) {
                                Logger.m10999d(AiMenuResultViewSTTSummarization.TAG, "event ACTION_DRAG_STARTED");
                                AiMenuResultViewSTTSummarization.this.mIsStartedDragDropAction = true;
                                return true;
                            }
                            if (action == 4) {
                                Logger.m10999d(AiMenuResultViewSTTSummarization.TAG, "event ACTION_DRAG_ENDED");
                                AiMenuResultViewSTTSummarization.this.mIsStartedDragDropAction = false;
                                return true;
                            }
                            if (action == 5) {
                                Logger.m10999d(AiMenuResultViewSTTSummarization.TAG, "event ACTION_DRAG_ENTERED");
                                return true;
                            }
                            if (action != 6) {
                                Logger.m10999d(AiMenuResultViewSTTSummarization.TAG, "onDrag# event default");
                                return true;
                            }
                            Logger.m10999d(AiMenuResultViewSTTSummarization.TAG, "event ACTION_DRAG_EXITED");
                            AiMenuResultViewSTTSummarization.this.mMenuResultViewPresenter.getComposerViewPresenter().getView().setFocusable(true);
                            AiMenuResultViewSTTSummarization.this.mMenuResultViewPresenter.getComposerViewPresenter().getView().setFocusableInTouchMode(true);
                            AiMenuResultViewSTTSummarization.this.mMenuResultViewPresenter.getComposerViewPresenter().getView().requestFocus();
                            return true;
                        }
                    });
                } else {
                    AiMenuResultViewSTTSummarization.this.mView.setFocusable(false);
                    AiMenuResultViewSTTSummarization.this.mMenuResultViewPresenter.getComposerViewPresenter().getView().requestFocus();
                }
            }
        };
        this.mMenuResultViewPresenter = aiMenuResultViewPresenter;
        STTSummarization sTTSummarization = aiMenuResultViewPresenter.getSTTSummarization();
        this.mSTTSummarization = sTTSummarization;
        if (sTTSummarization == null) {
            return;
        }
        sTTSummarization.setResultListener(this);
        STTSummarizeTranslation sTTSummarizeTranslation = this.mSTTSummarization.getSTTSummarizeTranslation();
        this.mSTTSummarizeTranslation = sTTSummarizeTranslation;
        sTTSummarizeTranslation.setResultListener(this);
        this.mIAiActionSTTResultContainer = iAiActionSTTResultContainer;
        this.mIAiSTTContract = iAIContract;
        iAIContract.addAiMenuSTTProcessListener(1, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean doInitialStep() {
        updateLanguage();
        Locale locale = AiLanguageHelper.getLocale(this.mSTTSummarizeTranslation.getFromLanguageTag());
        Locale locale2 = AiLanguageHelper.getLocale(this.mSTTSummarizeTranslation.getToLanguageTag());
        boolean z = false;
        if (locale != null && locale2 != null) {
            int fromLanguageState = this.mSTTSummarizeTranslation.getFromLanguageState();
            int toLanguageState = this.mSTTSummarizeTranslation.getToLanguageState();
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
                    if (this.mSTTSummarizeTranslation.isSame()) {
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
        }
        AiMenuResultBottomView.AddToListPopup addToListPopup = this.mAddToListPopup;
        if (addToListPopup != null) {
            addToListPopup.hide();
        }
    }

    private void hideProgress() {
        this.mCommonViews.hideProgress();
    }

    private void initBroadcastReceiver() {
        AiLanguageHelper.updateLanguageList();
        if (this.mBroadcastAddedReceiver == null) {
            this.mBroadcastAddedReceiver = new BroadcastReceiver() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTTSummarization.20
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    if (context == null || intent == null || AiMenuResultViewSTTSummarization.this.mSTTSummarizeTranslation == null) {
                        Logger.m10999d(AiMenuResultViewSTTSummarization.TAG, "addedReceiver# null");
                        return;
                    }
                    Logger.m11000e(AiMenuResultViewSTTSummarization.TAG, "addedReceiver# " + intent.getStringExtra("locale"));
                    AiLanguageHelper.updateLanguageList();
                }
            };
        }
        AiLanguageHelper.registerLanguagePackAddedReceiver(BaseUtils.getApplicationContext(), this.mBroadcastAddedReceiver);
        if (this.mBroadcastRemovedReceiver == null) {
            this.mBroadcastRemovedReceiver = new BroadcastReceiver() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTTSummarization.21
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    if (context == null || intent == null || AiMenuResultViewSTTSummarization.this.mSTTSummarizeTranslation == null) {
                        Logger.m10999d(AiMenuResultViewSTTSummarization.TAG, "removedReceiver# null");
                        return;
                    }
                    String stringExtra = intent.getStringExtra("locale");
                    Logger.m11000e(AiMenuResultViewSTTSummarization.TAG, "removedReceiver# " + stringExtra);
                    AiLanguageHelper.updateLanguageList(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTTSummarization.21.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (AiMenuResultViewSTTSummarization.this.mMenuResultViewPresenter == null || AiMenuResultViewSTTSummarization.this.mSTTSummarizeTranslation == null || !AiMenuResultViewSTTSummarization.this.mSTTSummarizeTranslation.isInvalidStatus()) {
                                return;
                            }
                            Logger.m10999d(AiMenuResultViewSTTSummarization.TAG, "onReceive# invalid status. Need to check language pack");
                            AiMenuResultViewSTTSummarization.this.mIsNeedCheckLanguage = true;
                        }
                    });
                }
            };
        }
        AiLanguageHelper.registerLanguagePackRemovedReceiver(BaseUtils.getApplicationContext(), this.mBroadcastRemovedReceiver);
    }

    private void initChooseLanguageLayout() {
        this.mFromView = this.mView.findViewById(C9086R.id.translation_language_from);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTTSummarization.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AiMenuResultViewSTTSummarization.this.showLanguageSelectorDialog(true);
                AiMenuResultViewSTTSummarization.this.mIAiSTTContract.getMSTTPresenter().setMIsTranslateSTTSummarizationFirstTime(false);
            }
        };
        this.mFromViewListener = onClickListener;
        this.mFromView.setOnClickListener(onClickListener);
        this.mFromTextView = (TextView) this.mFromView.findViewById(C9086R.id.translation_language_from_text);
        this.mFromView.setAccessibilityDelegate(new View.AccessibilityDelegate() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTTSummarization.15
            @Override // android.view.View.AccessibilityDelegate
            public void onInitializeAccessibilityNodeInfo(@NonNull View view, @NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                accessibilityNodeInfo.setContentDescription(((Object) AiMenuResultViewSTTSummarization.this.mFromView.getContentDescription()) + SQLKeyword.COMMA + ((Object) AiMenuResultViewSTTSummarization.this.mFromTextView.getText()));
            }
        });
        this.mToView = this.mView.findViewById(C9086R.id.translation_language_to);
        View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTTSummarization.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AiMenuResultViewSTTSummarization.this.showLanguageSelectorDialog(false);
            }
        };
        this.mToViewListener = onClickListener2;
        this.mToView.setOnClickListener(onClickListener2);
        this.mToTextView = (TextView) this.mToView.findViewById(C9086R.id.translation_language_to_text);
        this.mToView.setAccessibilityDelegate(new View.AccessibilityDelegate() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTTSummarization.17
            @Override // android.view.View.AccessibilityDelegate
            public void onInitializeAccessibilityNodeInfo(@NonNull View view, @NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                accessibilityNodeInfo.setContentDescription(((Object) AiMenuResultViewSTTSummarization.this.mToView.getContentDescription()) + SQLKeyword.COMMA + ((Object) AiMenuResultViewSTTSummarization.this.mToTextView.getText()));
            }
        });
        this.mTranslatingListener = new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTTSummarization.18
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AiMenuResultViewSTTSummarization.this.mSTTSummarizeTranslation.isCompleted()) {
                    return;
                }
                ToastHandler.show(AiMenuResultViewSTTSummarization.this.mView.getContext(), C9086R.string.ai_stt_wait_for_the_translation_to_finish, 0);
            }
        };
        ImageView imageView = (ImageView) this.mTranslationSelectorLayout.findViewById(C9086R.id.translation_language_change_btn);
        this.mSwitchLanguageBtn = imageView;
        imageView.setImageResource(C9086R.drawable.ic_arrow_translate_language);
        this.mSwitchLanguageBtn.setEnabled(false);
        View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTTSummarization.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AiMenuResultViewSTTSummarization.this.mSTTSummarizeTranslation == null) {
                    Logger.m11000e(AiMenuResultViewSTTSummarization.TAG, "onClick# switch: null");
                    return;
                }
                if (AiMenuResultViewSTTSummarization.this.mSTTSummarizeTranslation.isSame()) {
                    Logger.m11000e(AiMenuResultViewSTTSummarization.TAG, "onClick# switch: same language");
                    return;
                }
                AiMenuResultViewSTTSummarization.this.mSTTSummarizeTranslation.switchLanguageTag();
                AiMenuResultViewSTTSummarization.this.updateLanguage();
                AiMenuResultViewSTTSummarization.this.requestTranslate();
                ComposerSA.insertLog(STTConstant.SCREEN_AI_MENU_RESULT_STT_TRANSLATION, STTConstant.EVENT_TRANSLATE, "d");
            }
        };
        this.mSwitchLanguageListener = onClickListener3;
        this.mSwitchLanguageBtn.setOnClickListener(onClickListener3);
        initBroadcastReceiver();
        initLanguage();
    }

    private void initContextMenu(Context context) {
        AiContextMenuSTTPopup aiContextMenuSTTPopup = new AiContextMenuSTTPopup();
        this.mAiContextMenuPopup = aiContextMenuSTTPopup;
        aiContextMenuSTTPopup.init(context, AiContextMenuSTTPopup.PopupType.IN_SUMMARY_PAGE, new AiContextMenuSTTPopup.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTTSummarization.10
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiContextMenuSTTPopup.OnClickListener
            public void onClickAddToNode() {
                if (!AiMenuResultViewSTTSummarization.this.mMenuResultViewPresenter.canEditBodyText()) {
                    AiMenuResultViewSTTSummarization.this.mMenuResultViewPresenter.addTo(AiMenuResultViewSTTSummarization.this.mMenuResultViewPresenter.getSTTSummarization(), ResultOperation.AddTo.NewNote);
                    AiMenuResultViewSTTSummarization.this.mCommonViews.mContract.close();
                    return;
                }
                if (AiMenuResultViewSTTSummarization.this.mAddToListPopup == null || !AiMenuResultViewSTTSummarization.this.mAddToListPopup.isInitialized()) {
                    AiMenuResultViewSTTSummarization.this.mAddToListPopup = new AiMenuResultBottomView.AddToListPopup();
                    AiMenuResultViewSTTSummarization.this.mAddToListPopup.setTextSizeInPx(AiMenuResultViewSTTSummarization.this.mMenuResultViewPresenter.getActivity().getResources().getDimension(C9086R.dimen.ai_menu_context_item_text_size));
                    AiMenuResultViewSTTSummarization.this.mAddToListPopup.init(AiMenuResultViewSTTSummarization.this.mCommonViews.getTopView().mSTTContextBtn, AiMenuResultViewSTTSummarization.this.mMenuResultViewPresenter.isSinglePageNote(), new AiMenuResultBottomView.AddToListPopup.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTTSummarization.10.1
                        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultBottomView.AddToListPopup.OnClickListener
                        public void onItemClick(ResultOperation.AddTo addTo) {
                            AiMenuResultViewSTTSummarization.this.mAddToListPopup.hide();
                            AiMenuResultViewSTTSummarization.this.mMenuResultViewPresenter.addTo(AiMenuResultViewSTTSummarization.this.mMenuResultViewPresenter.getSTTSummarization(), addTo);
                            AiMenuResultViewSTTSummarization.this.mCommonViews.mContract.close();
                        }
                    });
                }
                AiMenuResultViewSTTSummarization.this.mAddToListPopup.show();
                ComposerSA.insertLog(STTConstant.SCREEN_AI_MENU_RESULT_STT_SUMMARY, STTConstant.EVENT_SELECT_MORE_SUMMARY_ADD_TO, "b");
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiContextMenuSTTPopup.OnClickListener
            public void onClickCopy() {
                AiMenuResultViewSTTSummarization.this.mMenuResultViewPresenter.copy(AiMenuResultViewSTTSummarization.this.mMenuResultViewPresenter.getSTTSummarization());
                ComposerSA.insertLog(STTConstant.SCREEN_AI_MENU_RESULT_STT_SUMMARY, STTConstant.EVENT_SELECT_MORE_SUMMARY_COPY, "b");
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiContextMenuSTTPopup.OnClickListener
            public void onClickEdit() {
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiContextMenuSTTPopup.OnClickListener
            public void onClickSummarizeAgain() {
                AiMenuResultViewSTTSummarization.this.mIAiActionSTTResultContainer.executeSummarize(true);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiContextMenuSTTPopup.OnClickListener
            public void onClickSummaryStyle() {
                AiMenuResultViewSTTSummarization aiMenuResultViewSTTSummarization = AiMenuResultViewSTTSummarization.this;
                aiMenuResultViewSTTSummarization.showSettingDialog(aiMenuResultViewSTTSummarization.mCommonViews.getTopView().mSTTContextBtn);
            }
        });
        if (this.mIAiSTTContract.canSummarizeBySubject()) {
            return;
        }
        this.mAiContextMenuPopup.mSummaryStyleButton.setVisibility(8);
    }

    private void initDragDrop() {
        if (this.mGestureDetector == null) {
            this.mGestureDetector = new GestureDetector(this.mView.getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTTSummarization.3
                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public void onLongPress(MotionEvent motionEvent) {
                    long j;
                    if (AiMenuResultViewSTTSummarization.this.mView == null || AiMenuResultViewSTTSummarization.this.mMenuResultViewPresenter == null) {
                        Logger.m11000e(AiMenuResultViewSTTSummarization.TAG, "dragDropRunnable# null object");
                        return;
                    }
                    if ((AiMenuResultViewSTTSummarization.this.mSTTSummarizeTranslation.isTranslateMode() && !AiMenuResultViewSTTSummarization.this.mSTTSummarizeTranslation.isCompleted()) || !AiMenuResultViewSTTSummarization.this.mSTTSummarization.canDoAction()) {
                        Logger.m11000e(AiMenuResultViewSTTSummarization.TAG, "onLongPress#startDragAndDrop skip " + AiMenuResultViewSTTSummarization.this.mSTTSummarizeTranslation.isTranslateMode() + " " + AiMenuResultViewSTTSummarization.this.mSTTSummarizeTranslation.isCompleted() + " " + AiMenuResultViewSTTSummarization.this.mSTTSummarization.canDoAction());
                        return;
                    }
                    boolean zIsSTTSelectionSummaryMode = AiMenuResultViewSTTSummarization.this.mIAiSTTContract.isSTTSelectionSummaryMode();
                    if (!zIsSTTSelectionSummaryMode) {
                        j = 700;
                    } else if (AiMenuResultViewSTTSummarization.this.mSTTSummaryResultAdapter.getSelectedItemCount() == 0) {
                        Logger.m11000e(AiMenuResultViewSTTSummarization.TAG, "onLongPress# selection mode but no item selected");
                        return;
                    } else {
                        Logger.m10999d(AiMenuResultViewSTTSummarization.TAG, "onLongPress# selection mode, drop only selected item");
                        j = 0;
                    }
                    AiMenuResultViewSTTSummarization.this.mStartDragX = (int) motionEvent.getX();
                    AiMenuResultViewSTTSummarization.this.mStartDragY = (int) motionEvent.getY();
                    Logger.m10999d(AiMenuResultViewSTTSummarization.TAG, "onLongPress# post delay for pending drag and drop action at " + AiMenuResultViewSTTSummarization.this.mStartDragX + " " + AiMenuResultViewSTTSummarization.this.mStartDragY);
                    AiMenuResultViewSTTSummarization.this.mIsPendingDragDropAction = true;
                    AiMenuResultViewSTTSummarization aiMenuResultViewSTTSummarization = AiMenuResultViewSTTSummarization.this;
                    aiMenuResultViewSTTSummarization.mHandler.removeCallbacks(aiMenuResultViewSTTSummarization.dragDropRunnable);
                    AiMenuResultViewSTTSummarization aiMenuResultViewSTTSummarization2 = AiMenuResultViewSTTSummarization.this;
                    aiMenuResultViewSTTSummarization2.mHandler.postDelayed(aiMenuResultViewSTTSummarization2.dragDropRunnable, j);
                    if (zIsSTTSelectionSummaryMode) {
                        return;
                    }
                    AiMenuResultViewSTTSummarization.this.mContextCurrentPos = -1;
                    if (AiMenuResultViewSTTSummarization.this.mSTTSummaryResultRecyclerView == null || AiMenuResultViewSTTSummarization.this.mIAiSTTContract.isSTTSelectionSummaryMode()) {
                        return;
                    }
                    View viewFindChildViewUnder = AiMenuResultViewSTTSummarization.this.mSTTSummaryResultRecyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
                    if (viewFindChildViewUnder == null) {
                        Logger.m11000e(AiMenuResultViewSTTSummarization.TAG, "onLongPress# can't find child view to select");
                        return;
                    }
                    AiMenuResultViewSTTSummarization aiMenuResultViewSTTSummarization3 = AiMenuResultViewSTTSummarization.this;
                    aiMenuResultViewSTTSummarization3.mContextCurrentPos = aiMenuResultViewSTTSummarization3.mSTTSummaryResultRecyclerView.getChildAdapterPosition(viewFindChildViewUnder);
                    Logger.m10999d(AiMenuResultViewSTTSummarization.TAG, "onLongPress# turn on Selection mode");
                    AiMenuResultViewSTTSummarization.this.mIAiSTTContract.getMSTTPresenter().toggleSTTSelectionMode(false);
                    if (AiMenuResultViewSTTSummarization.this.mContextCurrentPos == -1 || AiMenuResultViewSTTSummarization.this.mSTTSummaryResultAdapter == null) {
                        return;
                    }
                    Logger.m10999d(AiMenuResultViewSTTSummarization.TAG, "onItemClick# start SelectionSummaryMode on item " + AiMenuResultViewSTTSummarization.this.mContextCurrentPos);
                    AiMenuResultViewSTTSummarization.this.mSTTSummaryResultAdapter.toggleSelectItem(AiMenuResultViewSTTSummarization.this.mContextCurrentPos);
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public boolean onSingleTapUp(MotionEvent motionEvent) {
                    return true;
                }
            });
        }
        int scaledTouchSlop = ViewConfiguration.get(this.mView.getContext()).getScaledTouchSlop();
        this.mDragDistanceThreshold = scaledTouchSlop * scaledTouchSlop * 3;
        if (this.mOnItemTouchListener == null) {
            this.mOnItemTouchListener = new RecyclerView.OnItemTouchListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTTSummarization.4
                @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
                public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
                    if (AiViewUtils.isSupportFloatingLayout() && !AiMenuResultViewSTTSummarization.this.mView.isFocusable()) {
                        AiMenuResultViewSTTSummarization.this.mView.setFocusable(true);
                        AiMenuResultViewSTTSummarization.this.mView.setFocusableInTouchMode(true);
                    }
                    if (AiViewUtils.isSupportFloatingLayout() || !AiMenuResultViewSTTSummarization.this.mIsStartedDragDropAction) {
                        AiMenuResultViewSTTSummarization.this.mGestureDetector.onTouchEvent(motionEvent);
                        int action = motionEvent.getAction();
                        if (action == 0) {
                            AiMenuResultViewSTTSummarization.this.mStartDragX = (int) motionEvent.getX();
                            AiMenuResultViewSTTSummarization.this.mStartDragY = (int) motionEvent.getY();
                            return false;
                        }
                        if (action != 1) {
                            if (action != 2) {
                                Logger.m10999d(AiMenuResultViewSTTSummarization.TAG, "onInterceptTouchEvent# default");
                                return false;
                            }
                            if (AiMenuResultViewSTTSummarization.this.mIsPendingDragDropAction) {
                                int x = (int) motionEvent.getX();
                                int y2 = (int) motionEvent.getY();
                                int i = x - AiMenuResultViewSTTSummarization.this.mStartDragX;
                                int i2 = y2 - AiMenuResultViewSTTSummarization.this.mStartDragY;
                                AiMenuResultViewSTTSummarization.this.mDistance = (i2 * i2) + (i * i);
                                if (AiMenuResultViewSTTSummarization.this.mDistance > AiMenuResultViewSTTSummarization.this.mDragDistanceThreshold) {
                                    Logger.m10999d(AiMenuResultViewSTTSummarization.TAG, "onInterceptTouchEvent# perform the drag and drop action by distance " + AiMenuResultViewSTTSummarization.this.mDistance + " > " + AiMenuResultViewSTTSummarization.this.mDragDistanceThreshold);
                                    AiMenuResultViewSTTSummarization.this.mIsStartedDragDropAction = true;
                                    AiMenuResultViewSTTSummarization aiMenuResultViewSTTSummarization = AiMenuResultViewSTTSummarization.this;
                                    aiMenuResultViewSTTSummarization.mHandler.removeCallbacks(aiMenuResultViewSTTSummarization.dragDropRunnable);
                                    AiMenuResultViewSTTSummarization aiMenuResultViewSTTSummarization2 = AiMenuResultViewSTTSummarization.this;
                                    aiMenuResultViewSTTSummarization2.mHandler.post(aiMenuResultViewSTTSummarization2.dragDropRunnable);
                                    return false;
                                }
                            }
                        } else if (AiMenuResultViewSTTSummarization.this.mIsPendingDragDropAction) {
                            Logger.m10999d(AiMenuResultViewSTTSummarization.TAG, "onInterceptTouchEvent# cancel pending drag and drop action");
                            AiMenuResultViewSTTSummarization aiMenuResultViewSTTSummarization3 = AiMenuResultViewSTTSummarization.this;
                            aiMenuResultViewSTTSummarization3.mHandler.removeCallbacks(aiMenuResultViewSTTSummarization3.dragDropRunnable);
                            AiMenuResultViewSTTSummarization.this.mIsPendingDragDropAction = false;
                            AiMenuResultViewSTTSummarization.this.mIsStartedDragDropAction = false;
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
        this.mSTTSummaryResultRecyclerView.removeOnItemTouchListener(this.mOnItemTouchListener);
        this.mSTTSummaryResultRecyclerView.addOnItemTouchListener(this.mOnItemTouchListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initLanguage() {
        Logger.m10999d(TAG, "initLanguage#");
        this.mSTTSummarizeTranslation.setLanguageIdentifierCallback(new C963422());
    }

    @SuppressLint({"NotifyDataSetChanged"})
    private void initSummaryListView() {
        if (this.mSTTSummaryResultAdapter == null) {
            this.mSTTSummaryResultAdapter = new AiMenuResultViewSTTSummarizationAdapter(this.mSTTSummarization.getSummaryResultItemList(), this);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mIAiActionSTTResultContainer.getActivity());
            linearLayoutManager.setOrientation(1);
            this.mSTTSummaryResultRecyclerView.setLayoutManager(linearLayoutManager);
            this.mSTTSummaryResultRecyclerView.setAdapter(this.mSTTSummaryResultAdapter);
        }
        this.mSTTSummaryResultAdapter.notifyDataSetChanged();
        this.mSTTSummaryResultRecyclerView.clearOnScrollListeners();
        this.mSTTSummaryResultRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTTSummarization.11
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 1) {
                    AiMenuResultViewSTTSummarization.this.mUserScrollTime = System.currentTimeMillis();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                if (AiMenuResultViewSTTSummarization.this.mTranslationSelectorLayout != null) {
                    int iComputeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
                    int height = AiMenuResultViewSTTSummarization.this.mTranslationSelectorLayout.getHeight();
                    if (iComputeVerticalScrollOffset <= 3 && i2 <= 0) {
                        AiMenuResultViewSTTSummarization.this.doUpdateTranslatorLayoutPositionOnScroll(-height);
                    } else if (iComputeVerticalScrollOffset <= height) {
                        AiMenuResultViewSTTSummarization.this.doUpdateTranslatorLayoutPositionOnScroll(i2);
                    } else {
                        AiMenuResultViewSTTSummarization.this.doUpdateTranslatorLayoutPositionOnScroll(height);
                    }
                }
            }
        });
        this.mSTTSummaryResultRecyclerView.setOnPenMultiSelectionListener(new OnPenMultiSelectionListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTTSummarization.12
            @Override // com.samsung.android.support.senl.p148nt.base.common.view.penrecyclerview.OnPenMultiSelectionListener
            public void onSelectedItemPosition(@NotNull ArrayList<Integer> arrayList, int i, int i2, int i4) {
                if (arrayList.isEmpty()) {
                    return;
                }
                if (!AiMenuResultViewSTTSummarization.this.mIAiSTTContract.getMSTTPresenter().isSelectionSummaryMode()) {
                    AiMenuResultViewSTTSummarization.this.mIAiSTTContract.getMSTTPresenter().toggleSTTSelectionMode(false);
                }
                Iterator<Integer> it = arrayList.iterator();
                while (it.hasNext()) {
                    AiMenuResultViewSTTSummarization.this.mSTTSummaryResultAdapter.toggleSelectItem(it.next().intValue());
                }
            }
        });
        this.mView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTTSummarization.13
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
                if (AiMenuResultViewSTTSummarization.this.mTranslationSelectorLayout == null || AiMenuResultViewSTTSummarization.this.mSTTSummaryResultRecyclerView == null || !AiMenuResultViewSTTSummarization.this.mSTTSummarizeTranslation.isTranslateMode()) {
                    return;
                }
                int iComputeVerticalScrollOffset = AiMenuResultViewSTTSummarization.this.mSTTSummaryResultRecyclerView.computeVerticalScrollOffset();
                int height = AiMenuResultViewSTTSummarization.this.mTranslationSelectorLayout.getHeight();
                int i10 = i5 - i9;
                if (i10 == 0 || iComputeVerticalScrollOffset > height) {
                    return;
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) AiMenuResultViewSTTSummarization.this.mTranslationSelectorLayout.getLayoutParams();
                layoutParams.setMargins(layoutParams.leftMargin, -iComputeVerticalScrollOffset, layoutParams.rightMargin, layoutParams.bottomMargin);
                AiMenuResultViewSTTSummarization.this.mTranslationSelectorLayout.setLayoutParams(layoutParams);
                String str = AiMenuResultViewSTTSummarization.TAG;
                StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "onLayoutChange#mView [", " ", " ");
                AbstractC2821a.m2235z(sbM1173s, i4, i5, " ", "] offset ");
                AbstractC2821a.m2235z(sbM1173s, iComputeVerticalScrollOffset, height, " translateViewHeight ", " changeRange ");
                AbstractC8014b.m7221w(sbM1173s, str, i10);
            }
        });
        this.mSTTSummaryResultRecyclerView.setClipToPadding(false);
    }

    private void initTopMenu() {
        AiMenuResultCommonViews aiMenuResultCommonViews = this.mCommonViews;
        if (aiMenuResultCommonViews == null) {
            return;
        }
        initContextMenu(aiMenuResultCommonViews.mActivity);
        this.mCommonViews.getTopView().mSTTContextBtn.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTTSummarization.5
            @Override // android.view.View.OnClickListener
            public void onClick(final View view) {
                AiCommonUtil.executeActionByOndevice(AiMenuResultViewSTTSummarization.this.mIAiActionSTTResultContainer.getActivity(), new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTTSummarization.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!AiMenuResultViewSTTSummarization.this.isInfoViewShowing()) {
                            AiMenuResultViewSTTSummarization.this.mAiContextMenuPopup.updateTranslateMode(AiMenuResultViewSTTSummarization.this.mSTTSummarizeTranslation.isTranslateMode() && AiMenuResultViewSTTSummarization.this.mSTTSummarizeTranslation.isTranslatePending());
                        }
                        AiMenuResultViewSTTSummarization.this.mAiContextMenuPopup.show(view);
                    }
                }, new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTTSummarization.5.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Logger.m10999d(AiMenuResultViewSTTSummarization.TAG, "context menu cancel");
                    }
                });
            }
        });
        if (this.mCommonViews.getTopView().mSTTTranslateBtn != null) {
            this.mCommonViews.getTopView().mSTTTranslateBtn.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTTSummarization.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!AiMenuResultViewSTTSummarization.this.mSTTSummarizeTranslation.isTranslateMode() && !AiMenuResultViewSTTSummarization.this.mSTTSummarizeTranslation.isTranslatePending() && !AiMenuResultViewSTTSummarization.this.mSTTSummarizeTranslation.isCompleted()) {
                        AiMenuResultViewSTTSummarization.this.initLanguage();
                        AiMenuResultViewSTTSummarization.this.mSTTSummarizeTranslation.execute(AiMenuResultViewSTTSummarization.this.mSTTSummarization.getSummaryResultItemList());
                    }
                    AiMenuResultViewSTTSummarization.this.mSTTSummarizeTranslation.toggleTranslateMode();
                    AiMenuResultViewSTTSummarization.this.updateTranslateMode();
                }
            });
        }
        if (this.mCommonViews.getTopView().mSTTDisclaimerBtn != null) {
            this.mCommonViews.getTopView().mSTTDisclaimerBtn.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTTSummarization.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AiMenuResultViewSTTSummarization.this.mCommonViews.isNotAvailable()) {
                        return;
                    }
                    AiDisclaimerDialog aiDisclaimerDialog = new AiDisclaimerDialog();
                    aiDisclaimerDialog.show(view.getContext(), true, view);
                    AiMenuResultViewSTTSummarization.this.mCommonViews.getTopView().setAiDisclaimerDialog(aiDisclaimerDialog);
                    AiMenuResultViewSTTSummarization.this.mCommonViews.getBottomView().hide(true);
                }
            });
        }
    }

    private boolean isNeedToShowDropdown() {
        return (this.mIAiSTTContract.getMSTTPresenter().isSelectionMode() || this.mIAiSTTContract.getMSTTPresenter().isSelectionSummaryMode() || this.mIAiSTTContract.getMSTTPresenter().isComposerSearchMode() || this.mIAiSTTContract.getMSTTPresenter().isSTTEditMode() || this.mIAiSTTContract.getMSTTPresenter().getVoiceDataList().size() <= 1 || this.mIAiActionSTTResultContainer.isMinimizeView()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestTranslate() {
        STTSummarizeTranslation sTTSummarizeTranslation;
        if (this.mSTTSummarization == null || (sTTSummarizeTranslation = this.mSTTSummarizeTranslation) == null) {
            return;
        }
        int fromLanguageState = sTTSummarizeTranslation.getFromLanguageState();
        int toLanguageState = this.mSTTSummarizeTranslation.getToLanguageState();
        if (fromLanguageState == 0 && toLanguageState == 0) {
            this.mSTTSummarizeTranslation.execute(this.mSTTSummarization.getSummaryResultItemList());
        }
    }

    private void restoreSelectionMode() {
        if (this.mIAiSTTContract.getMSTTPresenter().isSelectionSummaryMode()) {
            this.mSTTSummaryResultAdapter.restoreSelectionMode(this.mSTTSummarization.getSelectedMap());
        }
    }

    private void selectSummaryTab() {
        TabLayout.Tab tabAt;
        AiMenuResultCommonViews aiMenuResultCommonViews = this.mCommonViews;
        if (aiMenuResultCommonViews == null || (tabAt = aiMenuResultCommonViews.getTopView().mTabLayout.getTabAt(1)) == null) {
            return;
        }
        tabAt.select();
    }

    private void setInfoButtonState(boolean z) {
        setButtonState(this.mCommonViews.getTopView().mSTTTranslateBtn, z);
        setButtonState(this.mCommonViews.getTopView().mSTTDisclaimerBtn, z);
        setButtonState(this.mCommonViews.getTopView().mSTTContextBtn, z);
    }

    private void setSelectLanguageLayoutState(boolean z) {
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
        View copyBtn = this.mCommonViews.getBottomView().getCopyBtn();
        View replaceBtn = this.mCommonViews.getBottomView().getReplaceBtn();
        if (copyBtn != null) {
            copyBtn.setEnabled(z);
            copyBtn.setAlpha(f);
        }
        if (replaceBtn != null) {
            replaceBtn.setEnabled(z);
            replaceBtn.setAlpha(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setViewVisible(View view, boolean z) {
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toggleModeBottomMenu() {
        AiMenuResultCommonViews aiMenuResultCommonViews = this.mCommonViews;
        if (aiMenuResultCommonViews == null || this.mSTTSummarization == null) {
            return;
        }
        View viewFindViewById = aiMenuResultCommonViews.getTopContainer().findViewById(C9086R.id.ai_menu_result_stt_top_container);
        final ViewGroup viewGroup = (ViewGroup) this.mCommonViews.getBottomView().getReplaceBtn();
        View view = (ViewGroup) this.mCommonViews.getBottomView().getAddToBtn();
        final TextView textView = (TextView) viewGroup.getChildAt(0);
        STTMode currentMode = this.mIAiSTTContract.getMSTTPresenter().getCurrentMode();
        if (currentMode == STTMode.SELECTION_SUMMARY) {
            setViewVisible(viewFindViewById, false);
            setViewVisible(viewGroup, true);
            setViewVisible(view, false);
            this.mCommonViews.getBottomView().setEnableReplace(true);
            textView.setText(C9086R.string.action_share);
            this.mCommonViews.getBottomView().setDisabled(false);
            this.mCommonViews.getBottomView().show(true);
            this.mCommonViews.getTopView().setTabLayoutState(false);
            return;
        }
        if (currentMode == STTMode.REPLAY) {
            updateBottomMenuView();
            textView.postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTTSummarization.8
                @Override // java.lang.Runnable
                public void run() {
                    textView.setText(C9086R.string.action_replace);
                    AiMenuResultViewSTTSummarization.this.setViewVisible(viewGroup, false);
                    viewGroup.getParent().requestLayout();
                }
            }, DeviceInfo.isVSTModel() ? 0 : 1000);
            if (!this.mSTTSummarization.isWorking()) {
                this.mCommonViews.getTopView().setTabLayoutState(true);
            }
            setViewVisible(viewFindViewById, true);
            setViewVisible(view, true);
            setViewVisible(this.mCommonViews.getTopView().mTabLayout, this.mCommonViews.mSTTHelpView.getVisibility() != 0);
        }
    }

    private void updateBottomMenuView() {
        if (isInfoViewShowing()) {
            return;
        }
        if (DeviceInfo.isVSTModel()) {
            this.mCommonViews.getTopView().mSTTContextBtn.setVisibility(8);
            this.mCommonViews.getBottomView().show(false);
            this.mCommonViews.getBottomView().setDisabled(false);
        } else {
            this.mCommonViews.getTopView().mSTTContextBtn.setVisibility(0);
            this.mCommonViews.getBottomView().hide(false);
            this.mCommonViews.getBottomView().setDisabled(true);
        }
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
        Locale locale = AiLanguageHelper.getLocale(this.mSTTSummarizeTranslation.getFromLanguageTag());
        Locale locale2 = AiLanguageHelper.getLocale(this.mSTTSummarizeTranslation.getToLanguageTag());
        if (locale != null && (textView2 = this.mFromTextView) != null) {
            textView2.setMaxLines(AiLanguageHelper.isSeperateLanguagePack(locale.getLanguage()) ? 2 : 1);
            this.mFromTextView.setText(AiLanguageHelper.getDisplayName(locale));
        }
        if (locale2 == null || (textView = this.mToTextView) == null) {
            return;
        }
        textView.setMaxLines(AiLanguageHelper.isSeperateLanguagePack(locale2.getLanguage()) ? 2 : 1);
        this.mToTextView.setText(AiLanguageHelper.getDisplayName(locale2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSelectionBtnState() {
        if (this.mSTTSummaryResultRecyclerView == null) {
            return;
        }
        setSelectionBtnState(this.mSTTSummaryResultAdapter.getSelectedItemCount() > 0 && this.mSTTSummaryResultAdapter.isSelectionMode());
    }

    private void updateSummaryResultView() {
        View viewFindViewById = this.mView.findViewById(C9086R.id.stt_summarization_result_recyclerview);
        if (viewFindViewById == null || this.mSTTSummaryResultAdapter == null || viewFindViewById.getVisibility() != 0) {
            return;
        }
        this.mSTTSummaryResultAdapter.updateSummaryResultMargin();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTitleViewMode() {
        AiMenuResultCommonViews aiMenuResultCommonViews = this.mCommonViews;
        if (aiMenuResultCommonViews == null || this.mView == null) {
            return;
        }
        ImageView imageView = aiMenuResultCommonViews.getTopView().mTitleIconView;
        if (!this.mIAiSTTContract.getMSTTPresenter().isSelectionSummaryMode()) {
            setViewVisible(this.mCommonViews.getTopView().mSTTSelectAllContainer, false);
            setViewVisible(imageView, true);
            return;
        }
        int selectedItemCount = this.mSTTSummaryResultAdapter.getSelectedItemCount();
        int itemCount = this.mSTTSummaryResultAdapter.getItemCount();
        this.mCommonViews.getTopView().mTitleView.setText(this.mView.getResources().getString(C9086R.string.selected_check_info, Integer.valueOf(selectedItemCount)));
        this.mCommonViews.getTopView().mSTTSelectAllCheckBox.setChecked(selectedItemCount == itemCount && selectedItemCount != 0);
        this.mCommonViews.getTopView().mSTTSelectAllCheckBox.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTTSummarization.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AiMenuResultViewSTTSummarization.this.mSTTSummaryResultAdapter.toggleSelectAllItems(AiMenuResultViewSTTSummarization.this.mCommonViews.getTopView().mSTTSelectAllCheckBox.isChecked());
            }
        });
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
        this.mSTTSummaryResultRecyclerView = null;
        this.mSTTSummaryResultAdapter = null;
        STTSummarization sTTSummarization = this.mSTTSummarization;
        if (sTTSummarization != null) {
            sTTSummarization.clear();
            this.mSTTSummarization = null;
        }
        View view = this.mView;
        if (view != null) {
            view.setVisibility(8);
            this.mView = null;
            hideProgress();
        }
        hideAllPopup();
        this.mIAiSTTContract.removeAiMenuSTTProcessListener(1);
    }

    public void doUpdateTranslatorLayoutPositionOnScroll(int i) {
        STTSummarizeTranslation sTTSummarizeTranslation;
        if (this.mTranslationSelectorLayout == null || (sTTSummarizeTranslation = this.mSTTSummarizeTranslation) == null || !sTTSummarizeTranslation.isTranslateMode()) {
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
        return this.mSTTSummarization;
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.presenter.AiMenuSTTProcessListener
    public void hideHelpView() {
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.presenter.AiMenuSTTProcessListener
    public void hideInfoView() {
        View view;
        if (this.mCommonViews == null || (view = this.mSTTInfoView) == null || view.getVisibility() == 8) {
            return;
        }
        this.mSTTInfoView.setVisibility(8);
        this.mSTTSummaryResultRecyclerView.setVisibility(0);
        setInfoButtonState(true);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public View inflateView(ViewGroup viewGroup) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(C9086R.layout.ai_menu_result_stt_summarization_layout, viewGroup, false);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public void initView(View view, View view2) {
        if (this.mSTTSummarization == null) {
            return;
        }
        this.mView = view2;
        view2.setVisibility(0);
        this.mSTTSummaryResultRecyclerView = (BasePenRecyclerView) this.mView.findViewById(C9086R.id.stt_summarization_result_recyclerview);
        this.mTranslationSelectorLayout = view2.findViewById(C9086R.id.translation_language_selector_container);
        this.mTranslationAutoDetecting = (LottieAnimationView) view2.findViewById(C9086R.id.stt_summarization_translation_auto_detecting_view);
        this.mSTTInfoView = view2.findViewById(C9086R.id.ai_menu_result_stt_info_container);
        initSummaryListView();
        updateTranslateMode();
        initChooseLanguageLayout();
        initTopMenu();
        updateResult();
        doInitialStep();
        initDragDrop();
        updateInfoView();
        restoreSelectionMode();
        updateTitleViewMode();
        updateBottomMenuView();
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
        return this.mSTTSummaryResultRecyclerView != null;
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.presenter.AiMenuSTTProcessListener
    public void onCancelled(@Nullable String str) {
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.presenter.AiMenuSTTProcessListener
    public void onCompleted(@Nullable String str) {
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.presenter.AiMenuSTTProcessListener
    public void onConverting(@Nullable String str, int i) {
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.presenter.AiMenuSTTProcessListener
    public void onFailed(@Nullable String str, @Nullable String str2, int i) {
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.presenter.AiMenuSTTProcessListener
    public void onLanguageDetected(@Nullable String str) {
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.presenter.AiMenuSTTProcessListener
    public void onModeChanged(@Nullable STTMode sTTMode) {
        if (this.mMenuResultViewPresenter.getSTTSummarization() == null) {
            Logger.m11000e(TAG, "onModeChanged# getSTTSummarization null, showing other action");
            return;
        }
        STTPresenter sTTPresenter = this.mIAiSTTContract.getMSTTPresenter();
        Logger.m10999d(TAG, "onModeChanged prevMode " + sTTMode.toString() + " #isSelectionSummaryMode " + sTTPresenter.isSelectionSummaryMode());
        if (this.mSTTSummarizeTranslation.isTranslateMode()) {
            if (sTTPresenter.isSelectionSummaryMode()) {
                this.mTranslationSelectorLayout.setVisibility(8);
                this.mTranslationSelectorLayout.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTTSummarization.28
                    @Override // java.lang.Runnable
                    public void run() {
                        AiMenuResultViewSTTSummarization.this.mSTTSummaryResultRecyclerView.setPadding(0, 0, 0, 20);
                    }
                });
            } else {
                this.mTranslationSelectorLayout.setVisibility(0);
                this.mTranslationSelectorLayout.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTTSummarization.29
                    @Override // java.lang.Runnable
                    public void run() {
                        int iConvertDpToPixel = (int) ResourceUtils.convertDpToPixel(AiMenuResultViewSTTSummarization.this.mIAiActionSTTResultContainer.getActivity(), 66.0f);
                        AiMenuResultViewSTTSummarization.this.mSTTSummaryResultRecyclerView.setPadding(0, iConvertDpToPixel, 0, 20);
                        AiMenuResultViewSTTSummarization.this.mSTTSummaryResultRecyclerView.smoothScrollBy(0, -iConvertDpToPixel);
                    }
                });
            }
        }
        AiMenuResultViewSTTSummarizationAdapter aiMenuResultViewSTTSummarizationAdapter = this.mSTTSummaryResultAdapter;
        if (aiMenuResultViewSTTSummarizationAdapter != null) {
            aiMenuResultViewSTTSummarizationAdapter.onModeChanged(sTTPresenter.getCurrentMode());
        }
        if (sTTPresenter.isSelectionSummaryMode()) {
            this.mCommonViews.mViewPager.setUserInputEnabled(false);
            this.mCommonViews.mViewPager.seslGetListView().seslSetHoverScrollEnabled(false);
            this.mMenuResultViewPresenter.getSoftInputManager().blockToShow(true, "STT selection summary mode");
        } else {
            this.mCommonViews.mViewPager.setUserInputEnabled(true);
            this.mCommonViews.mViewPager.seslGetListView().seslSetHoverScrollEnabled(true);
            this.mMenuResultViewPresenter.getSoftInputManager().blockToShow(false, "exit STT " + sTTMode.name() + " mode");
            this.mCommonViews.getTopView().mTitleView.setText(this.mIAiSTTContract.getCurrentSTTVoiceName());
            setViewVisible(this.mCommonViews.getTopView().mSTTSelectAllContainer, false);
        }
        if (sTTPresenter.isSTTSearchMode()) {
            this.mCommonViews.mViewPager.setUserInputEnabled(false);
            this.mCommonViews.mViewPager.seslGetListView().seslSetHoverScrollEnabled(false);
        }
        if (this.mView != null) {
            this.mHandler.post(this.mUpdateLayoutRunnable);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.ResultListener
    public void onNextCompleted(boolean z) {
        if (z) {
            this.mCommonViews.getContinuesProgress().setEnable(false);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AbsAiActionResultView, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public void onOrientationChanged(int i) {
        hideAllPopup();
        updateSummaryResultView();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AbsAiActionResultView, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public void onPageSelected() {
        if (updateInfoView() || !isInitialized() || this.mCommonViews == null) {
            return;
        }
        STTSummarization sTTSummarization = this.mSTTSummarization;
        if (sTTSummarization != null && sTTSummarization.isWorking()) {
            this.mCommonViews.setTopButtonState(false);
            this.mCommonViews.showProgress(2);
            this.mCommonViews.getTranscribeProgressCancelBtn().setVisibility(8);
        }
        initTopMenu();
        this.mCommonViews.getTopView().mSTTTopContainer.setVisibility(0);
        this.mCommonViews.getTopView().mSTTContextBtn.setVisibility(0);
        if (this.mCommonViews.getTopView().mSTTTranslateBtn != null) {
            this.mCommonViews.getTopView().mSTTTranslateBtn.setSelected(this.mSTTSummarizeTranslation.isTranslateMode());
        }
        if (this.mCommonViews.getTopView().mSTTDisclaimerBtn != null) {
            this.mCommonViews.getTopView().mSTTDisclaimerBtn.setVisibility(0);
        }
        updateBottomMenuView();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.ResultListener
    public void onProgressing() {
        this.mCommonViews.getContinuesProgress().show(2);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public void onResume() {
        STTSummarizeTranslation sTTSummarizeTranslation = this.mSTTSummarizeTranslation;
        if (sTTSummarizeTranslation == null || !sTTSummarizeTranslation.isTranslateMode()) {
            return;
        }
        String str = TAG;
        StringBuilder sb = new StringBuilder("onResume# check language status : ");
        sb.append(this.mIsNeedCheckLanguage);
        sb.append(", check download language : ");
        AbstractC8014b.m7215q(sb, this.mIsRequestedDownloadLanguage, str);
        if (this.mIsNeedCheckLanguage) {
            this.mIsNeedCheckLanguage = false;
            AiLanguageHelper.updateLanguageList(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTTSummarization.25
                @Override // java.lang.Runnable
                public void run() {
                    if (AiMenuResultViewSTTSummarization.this.mSTTSummarizeTranslation != null) {
                        Locale locale = AiLanguageHelper.getLocale(AiMenuResultViewSTTSummarization.this.mSTTSummarizeTranslation.getFromLanguageTag());
                        Locale locale2 = AiLanguageHelper.getLocale(AiMenuResultViewSTTSummarization.this.mSTTSummarizeTranslation.getToLanguageTag());
                        if (locale == null || locale2 == null || AiMenuResultViewSTTSummarization.this.mMenuResultViewPresenter == null || !AiMenuResultViewSTTSummarization.this.mSTTSummarizeTranslation.isInvalidStatus()) {
                            return;
                        }
                        Logger.m10999d(AiMenuResultViewSTTSummarization.TAG, "onResume# invalid status. requestDownloadLanguagePack");
                        AiMenuResultViewSTTSummarization.this.mIsRequestedDownloadLanguage = true;
                        AiLanguageHelper.requestDownloadLanguagePack(AiMenuResultViewSTTSummarization.this.mIAiActionSTTResultContainer.getActivity(), locale, locale2, Integer.valueOf(ComposerRequestCode.DownloadLanguage.getId()));
                    }
                }
            });
        } else if (this.mIsRequestedDownloadLanguage) {
            this.mIsRequestedDownloadLanguage = false;
            AiLanguageHelper.updateLanguageList(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTTSummarization.26
                @Override // java.lang.Runnable
                public void run() {
                    if (AiMenuResultViewSTTSummarization.this.mMenuResultViewPresenter == null || AiMenuResultViewSTTSummarization.this.mSTTSummarizeTranslation == null || !AiMenuResultViewSTTSummarization.this.mSTTSummarizeTranslation.isInvalidStatus()) {
                        return;
                    }
                    Logger.m10999d(AiMenuResultViewSTTSummarization.TAG, "onResume# invalid status. Stop Translation mode.");
                    AiMenuResultViewSTTSummarization.this.mSTTSummarizeTranslation.updateLanguageStatus();
                    AiMenuResultViewSTTSummarization.this.mSTTSummarizeTranslation.stop();
                    AiMenuResultViewSTTSummarization.this.mSTTSummarizeTranslation.cancel();
                    AiMenuResultViewSTTSummarization.this.updateTranslateMode();
                }
            });
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.presenter.AiMenuSTTProcessListener
    public void onSTTDataSaved() {
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.presenter.AiMenuSTTProcessListener
    public void onSTTItemCheckedChange(@Nullable Map<Integer, Boolean> map) {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.STTSummarizationAdapterContract
    public void onSummaryItemCheckedChanged(TreeMap<Integer, Boolean> treeMap) {
        updateTitleViewMode();
        updateSelectionBtnState();
        this.mSTTSummarization.setSelectedMap(treeMap);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.STTTranslateResultListener
    @SuppressLint({"NotifyDataSetChanged"})
    public void onTranslateCompleted(boolean z, int i) {
        AiMenuResultViewSTTSummarizationAdapter aiMenuResultViewSTTSummarizationAdapter;
        Logger.m11003i(TAG, "onTranslateCompleted# isLast : " + z + ", index : " + i);
        if (this.mSTTSummaryResultRecyclerView == null || (aiMenuResultViewSTTSummarizationAdapter = this.mSTTSummaryResultAdapter) == null) {
            return;
        }
        if (!z) {
            aiMenuResultViewSTTSummarizationAdapter.notifyItemChanged(i);
            return;
        }
        aiMenuResultViewSTTSummarizationAdapter.notifyDataSetChanged();
        AiContextMenuSTTPopup aiContextMenuSTTPopup = this.mAiContextMenuPopup;
        if (aiContextMenuSTTPopup != null) {
            aiContextMenuSTTPopup.enableCopyText();
            this.mAiContextMenuPopup.enableSummaryStyle();
        }
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
            this.mAiContextMenuPopup.disableSummaryStyle();
        }
        setSelectLanguageLayoutState(false);
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.presenter.AiMenuSTTProcessListener
    public void onVoiceInfoChanged() {
        AiMenuResultCommonViews aiMenuResultCommonViews = this.mCommonViews;
        if (aiMenuResultCommonViews == null || aiMenuResultCommonViews.getTopView().mTitleView == null) {
            return;
        }
        this.mCommonViews.getTopView().mTitleView.setText(this.mIAiSTTContract.getCurrentSTTVoiceName());
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.presenter.AiMenuSTTProcessListener
    public void resetSTTViewToDefault() {
        AiMenuResultCommonViews aiMenuResultCommonViews = this.mCommonViews;
        if (aiMenuResultCommonViews != null && aiMenuResultCommonViews.isShowingProgress()) {
            this.mCommonViews.hideProgress();
        }
        if (this.mSTTSummarizeTranslation.isTranslateMode()) {
            this.mSTTSummarizeTranslation.stop();
            updateTranslateMode();
        }
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
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.presenter.AiMenuSTTProcessListener
    public void showAutoDetectHelpView(@Nullable String str, int i, @Nullable String str2) {
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.presenter.AiMenuSTTProcessListener
    public void showHelpView(int i) {
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.presenter.AiMenuSTTProcessListener
    public void showInfoView() {
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
        Locale locale = AiLanguageHelper.getLocale(this.mSTTSummarizeTranslation.getFromLanguageTag());
        Locale locale2 = AiLanguageHelper.getLocale(this.mSTTSummarizeTranslation.getToLanguageTag());
        if (locale == null && locale2 == null) {
            return;
        }
        if (!z) {
            z = this.mSTTSummarizeTranslation.getToLanguageState() == 1;
            locale = locale2;
        } else if (this.mSTTSummarizeTranslation.getFromLanguageState() == 1) {
            z = true;
        }
        SelectTranslateLanguageDialog selectTranslateLanguageDialog = new SelectTranslateLanguageDialog();
        selectTranslateLanguageDialog.setContract(z, locale, new SelectTranslateLanguageDialog.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTTSummarization.23
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
                AbstractC8014b.m7224z("onCancle# ", AiMenuResultViewSTTSummarization.TAG, z2);
                if (z) {
                    ComposerSA.insertLog(STTConstant.SCREEN_AI_MENU_RESULT_STT_TRANSLATION, STTConstant.EVENT_CANCEL_SOURCE);
                } else {
                    ComposerSA.insertLog(STTConstant.SCREEN_AI_MENU_RESULT_STT_TRANSLATION, STTConstant.EVENT_CANCEL_TARGET);
                }
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.dialog.SelectTranslateLanguageDialog.Contract
            public void setSelectedLocale(Locale locale3) {
                String languageTag = locale3.toLanguageTag();
                String fromLanguageTag = AiMenuResultViewSTTSummarization.this.mSTTSummarizeTranslation.getFromLanguageTag();
                String toLanguageTag = AiMenuResultViewSTTSummarization.this.mSTTSummarizeTranslation.getToLanguageTag();
                String languageTag2 = Locale.getDefault().toLanguageTag();
                Logger.m11003i(AiMenuResultViewSTTSummarization.TAG, "setSelectedLocale# " + z + " - " + languageTag);
                if (z) {
                    if (AiMenuResultViewSTTSummarization.this.mSTTSummarizeTranslation.getFromLanguageTag().equals(languageTag) && (!z || AiMenuResultViewSTTSummarization.this.mSTTSummarizeTranslation.getFromLanguageState() != 0)) {
                        Logger.m10999d(AiMenuResultViewSTTSummarization.TAG, "setSelectedLocale source: skip, same old source");
                        return;
                    }
                    AiMenuResultViewSTTSummarization.this.mSTTSummarizeTranslation.setFromLanguageTag(languageTag);
                } else {
                    if (AiMenuResultViewSTTSummarization.this.mSTTSummarizeTranslation.getToLanguageTag().equals(languageTag) && (!z || AiMenuResultViewSTTSummarization.this.mSTTSummarizeTranslation.getToLanguageState() != 0)) {
                        Logger.m10999d(AiMenuResultViewSTTSummarization.TAG, "setSelectedLocale target: skip, same old target");
                        return;
                    }
                    AiMenuResultViewSTTSummarization.this.mSTTSummarizeTranslation.setToLanguageTag(languageTag);
                }
                if (AiMenuResultViewSTTSummarization.this.mSTTSummarizeTranslation.isSame()) {
                    AiMenuResultViewSTTSummarization.this.mSTTSummarizeTranslation.clearTranslatedData();
                }
                AiMenuResultViewSTTSummarization.this.updateLanguage();
                AiMenuResultViewSTTSummarization.this.requestTranslate();
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

    public void showSettingDialog(View view) {
        if (this.mSTTSummarization == null) {
            this.mSTTSummarization = this.mMenuResultViewPresenter.getSTTSummarization();
        }
        STTSummarization sTTSummarization = this.mSTTSummarization;
        if (sTTSummarization == null) {
            Logger.m11000e(TAG, "showSettingDialog# mSTTSummarization null");
        } else {
            sTTSummarization.showSTTSummaryOptionDialog(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTTSummarization.27
                @Override // java.lang.Runnable
                public void run() {
                    if (AiMenuResultViewSTTSummarization.this.mSTTSummarizeTranslation.isTranslateMode()) {
                        AiMenuResultViewSTTSummarization.this.mIsNeedTranslateAgain = true;
                    }
                    AiMenuResultViewSTTSummarization.this.mCommonViews.showProgress(2);
                }
            }, view);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.presenter.AiMenuSTTProcessListener
    public void updateAutoTranscribeView() {
    }

    public boolean updateInfoView() {
        String sTTCurrentVoiceItemAdapterText = this.mIAiSTTContract.getMSTTPresenter().getSTTCurrentVoiceItemAdapterText(false);
        if (this.mIAiSTTContract.isCurrentVoiceHaveSTTData()) {
            if (this.mIAiSTTContract.checkCurrentVoiceEmptyData()) {
                showInfoView(1);
                return true;
            }
            if (STTSummarization.isLimitedMinLength(sTTCurrentVoiceItemAdapterText)) {
                showInfoView(2);
                return true;
            }
            hideInfoView();
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AbsAiActionResultView, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.IAiActionResultView
    public void updateLayout(boolean z, int i, int i2) {
        Logger.m10999d(TAG, "updateLayout# landscape " + z + " " + i + " - " + i2);
        if (isInitialized()) {
            this.mViewWidth = i;
            this.mViewHeight = i2;
            this.mHandler.removeCallbacks(this.mUpdateLayoutRunnable);
            this.mHandler.postDelayed(this.mUpdateLayoutRunnable, 100L);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.presenter.AiMenuSTTProcessListener
    public void updateRealtimeCompleteView() {
    }

    public void updateResult() {
        if (this.mSTTSummarization.isWorking()) {
            return;
        }
        if (this.mSTTSummarization.getLastErrorMessage() != null) {
            Logger.m10999d(TAG, "updateResult# onFailed");
            onFailed(this.mSTTSummarization.getLastErrorMessage());
        } else {
            Logger.m10999d(TAG, "updateResult# normal case");
            onCompleted(true);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AbsAiActionResultView
    public void updateTopContainerLayout() {
        AiMenuResultCommonViews aiMenuResultCommonViews = this.mCommonViews;
        if (aiMenuResultCommonViews == null || this.mSTTSummaryResultRecyclerView == null) {
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
            return;
        }
        updateDropdownView();
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

    @SuppressLint({"NotifyDataSetChanged"})
    public void updateTranslateMode() {
        AiMenuResultViewSTTSummarizationAdapter aiMenuResultViewSTTSummarizationAdapter;
        AiMenuResultCommonViews aiMenuResultCommonViews = this.mCommonViews;
        if (aiMenuResultCommonViews != null && aiMenuResultCommonViews.getTopView().mSTTTranslateBtn != null) {
            this.mCommonViews.getTopView().mSTTTranslateBtn.setSelected(this.mSTTSummarizeTranslation.isTranslateMode());
        }
        final int measuredHeight = this.mTranslationSelectorLayout.getMeasuredHeight();
        if (this.mSTTSummarizeTranslation.isTranslateMode()) {
            AiMenuResultViewSTTSummarizationAdapter aiMenuResultViewSTTSummarizationAdapter2 = this.mSTTSummaryResultAdapter;
            if (aiMenuResultViewSTTSummarizationAdapter2 != null) {
                aiMenuResultViewSTTSummarizationAdapter2.setTranslateMode(true);
            }
            this.mTranslationSelectorLayout.setVisibility(0);
            if (this.mSTTSummarizeTranslation.isTranslatePending() && this.mAiContextMenuPopup != null) {
                setSelectLanguageLayoutState(false);
                this.mAiContextMenuPopup.disableCopyText();
                this.mAiContextMenuPopup.disableSummaryStyle();
            }
        } else {
            this.mTranslationSelectorLayout.setVisibility(8);
            AiMenuResultViewSTTSummarizationAdapter aiMenuResultViewSTTSummarizationAdapter3 = this.mSTTSummaryResultAdapter;
            if (aiMenuResultViewSTTSummarizationAdapter3 != null) {
                aiMenuResultViewSTTSummarizationAdapter3.setTranslateMode(false);
            }
            AiContextMenuSTTPopup aiContextMenuSTTPopup = this.mAiContextMenuPopup;
            if (aiContextMenuSTTPopup != null) {
                aiContextMenuSTTPopup.enableCopyText();
                this.mAiContextMenuPopup.enableSummaryStyle();
            }
        }
        this.mTranslationSelectorLayout.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewSTTSummarization.9
            @Override // java.lang.Runnable
            public void run() {
                if (AiMenuResultViewSTTSummarization.this.mSTTSummaryResultRecyclerView == null) {
                    return;
                }
                int iComputeVerticalScrollOffset = AiMenuResultViewSTTSummarization.this.mSTTSummaryResultRecyclerView.computeVerticalScrollOffset();
                int iConvertDpToPixel = AiMenuResultViewSTTSummarization.this.mSTTSummarizeTranslation.isTranslateMode() ? (int) ResourceUtils.convertDpToPixel(AiMenuResultViewSTTSummarization.this.mIAiActionSTTResultContainer.getActivity(), 74.0f) : 0;
                AiMenuResultViewSTTSummarization.this.mSTTSummaryResultRecyclerView.setPadding(0, iConvertDpToPixel, 0, 20);
                if (iComputeVerticalScrollOffset <= iConvertDpToPixel) {
                    AiMenuResultViewSTTSummarization.this.mSTTSummaryResultRecyclerView.scrollToPosition(iComputeVerticalScrollOffset);
                }
                int iComputeVerticalScrollOffset2 = AiMenuResultViewSTTSummarization.this.mSTTSummaryResultRecyclerView.computeVerticalScrollOffset();
                if (iComputeVerticalScrollOffset2 > iConvertDpToPixel) {
                    AiMenuResultViewSTTSummarization.this.doUpdateTranslatorLayoutPositionOnScroll(iConvertDpToPixel);
                } else {
                    AiMenuResultViewSTTSummarization.this.doUpdateTranslatorLayoutPositionOnScroll(-iConvertDpToPixel);
                }
                String str = AiMenuResultViewSTTSummarization.TAG;
                StringBuilder sbM778t = AbstractC0541b.m778t(iConvertDpToPixel, "toggleTranslateMode topPadding ", " beforeTopPadding ");
                AbstractC2821a.m2235z(sbM778t, measuredHeight, iComputeVerticalScrollOffset, " beforeScrollPosition ", " afterScrollPosition ");
                AbstractC8014b.m7221w(sbM778t, str, iComputeVerticalScrollOffset2);
            }
        });
        if (this.mSTTSummarizeTranslation.isCompleted() && (aiMenuResultViewSTTSummarizationAdapter = this.mSTTSummaryResultAdapter) != null) {
            aiMenuResultViewSTTSummarizationAdapter.notifyDataSetChanged();
        }
        if (this.mSTTSummarizeTranslation.isTranslateMode() && this.mIsNeedTranslateAgain && !this.mSTTSummarization.isWorking()) {
            Logger.m10999d(TAG, "needTranslateAgain true");
            requestTranslate();
            this.mIsNeedTranslateAgain = false;
        }
        updateLanguage();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.ResultListener
    public void onCompleted(boolean z) {
        if (this.mSTTSummaryResultRecyclerView == null) {
            Logger.m11000e(TAG, "mSTTSummaryResultRecyclerView is null");
            return;
        }
        AbstractC8014b.m7220v("onCompleted isLast ", TAG, z);
        initSummaryListView();
        this.mSTTSummaryResultRecyclerView.post(new RunnableC9711g(this, 10));
        if (z) {
            this.mCommonViews.hideProgress(true);
            AiContextMenuSTTPopup aiContextMenuSTTPopup = this.mAiContextMenuPopup;
            if (aiContextMenuSTTPopup != null) {
                aiContextMenuSTTPopup.enableCopyText();
                this.mAiContextMenuPopup.enableSummaryStyle();
            }
            this.mCommonViews.setBottomButtonsState(true);
            this.mCommonViews.setTopButtonState(true);
            this.mIAiActionSTTResultContainer.updateResultState(true, true);
            this.mCommonViews.mViewPager.setUserInputEnabled(true);
            updateBottomMenuView();
            if (!this.mSTTSummarization.isStreamingMode()) {
                this.mSTTSummaryResultRecyclerView.scrollToPosition(0);
            }
        } else {
            if (this.mSTTSummarization.isStreamingMode()) {
                boolean z2 = System.currentTimeMillis() - this.mUserScrollTime < AiSTTListView.USER_SCROLL_INTERVAL;
                this.mCommonViews.hideProgress(false);
                this.mCommonViews.mViewPager.setUserInputEnabled(false);
                if (!z2) {
                    this.mSTTSummaryResultRecyclerView.scrollToPosition(this.mSTTSummarization.getSummaryResultItemList().size() - 1);
                }
            }
            AiContextMenuSTTPopup aiContextMenuSTTPopup2 = this.mAiContextMenuPopup;
            if (aiContextMenuSTTPopup2 != null) {
                aiContextMenuSTTPopup2.disableCopyText();
                this.mAiContextMenuPopup.disableSummaryStyle();
            }
            this.mCommonViews.setBottomButtonsState(false);
            this.mIAiActionSTTResultContainer.updateResultState(true, false);
        }
        this.mCommonViews.getContinuesProgress().setEnable(false);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.AiMenuContract.ResultListener
    public void onFailed(String str) {
        if (this.mCommonViews.handleRestrictedPersonalDataError(str)) {
            return;
        }
        hideProgress();
        this.mCommonViews.mErrMsgView.setText(str);
        this.mCommonViews.showErrorMessage();
        this.mCommonViews.getContinuesProgress().setEnable(false);
    }

    public void showInfoView(int i) {
        if (this.mCommonViews == null || this.mSTTInfoView == null) {
            return;
        }
        if (this.mMenuResultViewPresenter.getSTTTabletLayoutAction() == null) {
            Logger.m11000e(TAG, "showInfoView# getSTTTabletLayoutAction null, showing other action");
            return;
        }
        this.mCommonViews.getTopView().mTitleView.setText(this.mIAiSTTContract.getCurrentSTTVoiceName());
        setInfoButtonState(false);
        TextView textView = (TextView) this.mSTTInfoView.findViewById(C9086R.id.ai_menu_result_info_message_view);
        if (i == 1) {
            textView.setText(C9086R.string.stt_info_message_no_speech_detected);
        } else if (i == 2) {
            textView.setText(C9086R.string.stt_info_message_transcript_is_too_short);
        }
        this.mSTTInfoView.setVisibility(0);
        BasePenRecyclerView basePenRecyclerView = this.mSTTSummaryResultRecyclerView;
        if (basePenRecyclerView != null) {
            basePenRecyclerView.setVisibility(8);
        }
        if (this.mCommonViews.isShowingProgress()) {
            this.mCommonViews.hideProgress();
        }
    }
}
