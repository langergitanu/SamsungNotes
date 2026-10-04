package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.core.content.ContextCompat;
import androidx.core.view.SemBlurCompat;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.samsung.android.support.senl.p145cm.base.framework.view.SemBlurInfoCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.InterpolatorUtil;
import com.samsung.android.support.senl.p148nt.app.common.util.ViewModeUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.WidgetInsetUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.view.AbsFragment;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.NotesPresenter;
import com.samsung.android.support.senl.p148nt.app.main.smarttipcard.FabLongPressSmartTipCard;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.StorageUtils;
import com.samsung.android.support.senl.p148nt.base.winset.util.DialogUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.NoteStyleActivity;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.common.Constant;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class FabMenuView implements View.OnTouchListener {
    private static final boolean ANIMATE_HIDE = false;
    private static final boolean ANIMATE_SHOW = true;
    private static final int CENTER_PIVOT = 50;
    private static final int DURATION_100 = 100;
    private static final int DURATION_1000 = 1000;
    private static final int DURATION_200 = 200;
    private static final int DURATION_300 = 300;
    private static final int DURATION_400 = 400;
    private static final float MAX_ALPHA = 1.0f;
    private static final float MAX_SCALE = 1.0f;
    private static final float MID_SCALE = 0.85f;
    private static final float MIN_ALPHA = 0.0f;
    private static final float MIN_SCALE = 0.0f;
    private static final String TAG = "FabMenuView";
    private View mBlurView;
    private FloatingActionButton mCancelFab;
    private final Contract mContract;
    private FloatingActionButton mCreateNoteFab;
    private float mCreateNoteY;
    private View mFakeFab;
    private final Fragment mFragment;
    private View mMainView;
    private View mNoteFab;
    private FloatingActionButton mNoteStyleFab;
    private View mNoteStyleFabContainer;
    private TextView mNoteStyleText;
    private float mNoteStyleY;
    private final NotesPresenter mNotesPresenter;
    private OnBackPressedCallback mOnBackPressedCallback;
    private FloatingActionButton mPdfFab;
    private View mPdfFabContainer;
    private TextView mPdfText;
    private float mPdfY;
    private final Handler mHandler = new Handler(Looper.myLooper());
    private int mToolType = 1;
    private boolean mIsFabsBlurEffect = false;
    private boolean mNewDirection = true;
    private boolean mOldDirection = true;
    private final Animator.AnimatorListener mAnimatorFabShowListener = new AnimatorListenerImpl() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.widget.FabMenuView.1
        @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.widget.FabMenuView.AnimatorListenerImpl, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NonNull Animator animator) {
            if (FabMenuView.this.mFakeFab != null && FabMenuView.this.mFakeFab.getVisibility() == 0) {
                FabMenuView.this.mFakeFab.setVisibility(8);
            }
            FabMenuView.this.invalidate();
        }

        @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.widget.FabMenuView.AnimatorListenerImpl, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NonNull Animator animator) {
            FabMenuView.this.mNoteFab.setPivotX(50.0f);
            FabMenuView.this.mNoteFab.setPivotY(50.0f);
        }

        @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.widget.FabMenuView.AnimatorListenerImpl, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NonNull Animator animator) {
            FabMenuView.this.mNoteFab.setVisibility(0);
        }
    };
    private final Animator.AnimatorListener mAnimatorFabHideListener = new AnimatorListenerImpl() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.widget.FabMenuView.2
        @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.widget.FabMenuView.AnimatorListenerImpl, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NonNull Animator animator) {
            FabMenuView.this.mNoteFab.setVisibility(8);
        }

        @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.widget.FabMenuView.AnimatorListenerImpl, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NonNull Animator animator) {
            FabMenuView.this.mNoteFab.setPivotX(50.0f);
            FabMenuView.this.mNoteFab.setPivotY(50.0f);
        }
    };
    private final Runnable mShowNoteFabScrollFinished = new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.widget.FabMenuView.3
        @Override // java.lang.Runnable
        public void run() {
            if (FabMenuView.this.mNoteFab != null && FabMenuView.this.mNoteFab.getVisibility() != 0) {
                FabMenuView fabMenuView = FabMenuView.this;
                fabMenuView.setNoteFabVisibility(fabMenuView.mNoteFab, true);
                FabMenuView fabMenuView2 = FabMenuView.this;
                fabMenuView2.mNewDirection = true;
                fabMenuView2.mOldDirection = true;
            }
            if (FabMenuView.this.mNotesPresenter.setIsScrolling(false)) {
                FabMenuView.this.mNotesPresenter.postNotifyDataSetChanged();
            }
        }
    };
    private final View.OnClickListener mCreateNoteFabClickListener = new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.widget.FabMenuView.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UserInputSkipper.Tag tag = UserInputSkipper.Tag.OpenActivity;
            if (UserInputSkipper.isValidSingleActionEvent(false, tag) && UserInputSkipper.isValidEvent(UserInputSkipper.Tag.MemoList)) {
                UserInputSkipper.setHoldingSingleActionEventTime(1000L, tag);
                if (StorageUtils.isAvailableMemoryForNewMemo()) {
                    FabMenuView.this.mContract.onNewNote(FabMenuView.this.mNotesPresenter.getStateInfo().getFolderUuid(), FabMenuView.this.mToolType);
                } else {
                    DialogUtils.showNotEnoughStorageDialogFragment(view.getContext(), FabMenuView.this.mFragment.getChildFragmentManager());
                }
                FabMenuView.this.onBackKeyDown(false);
            }
        }
    };
    private final View.OnLongClickListener mCreateNoteFabLongClickListener = new View.OnLongClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.widget.FabMenuView.5
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            UserInputSkipper.Tag tag = UserInputSkipper.Tag.OpenActivity;
            if (UserInputSkipper.isValidSingleActionEvent(false, tag) && UserInputSkipper.isValidEvent(UserInputSkipper.Tag.MemoList) && !FeatureUtils.isPickMode(FabMenuView.this.mContract.getModeIndex()) && !FeatureUtils.isCoeditMode(FabMenuView.this.mContract.getModeIndex()) && !FeatureUtils.isCoeditSpaceMode(FabMenuView.this.mContract.getModeIndex()) && !FeatureUtils.isGcsSpaceMode(FabMenuView.this.mContract.getModeIndex())) {
                UserInputSkipper.setHoldingSingleActionEventTime(1000L, tag);
                MainLogger.m7258i(FabMenuView.TAG, "onLongClick");
                FabMenuView.this.mIsLongPressed = true;
                FabMenuView.this.inflateBlurView();
                FabMenuView.this.mBlurView.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.widget.FabMenuView.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        FabMenuView.this.updateFabVisibility();
                        FabMenuView.this.animateDefaultFab(true, false);
                        FabMenuView.this.animateExtendedFabs(true, false);
                        FabMenuView.this.animateBlurView(true, false);
                    }
                });
                CommonSamsungAnalytics.insertLog("101", NotesSAConstants.EVENT_ENTER_THE_FAB);
            }
            return true;
        }
    };
    private final View.OnClickListener mPdfClickListener = new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.widget.FabMenuView.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FabMenuView.this.onBackKeyDown(false);
            FabMenuView.this.mNotesPresenter.getPdfImportHelper().onSelectPdfOptionMenu(FabMenuView.this.mFragment);
            CommonSamsungAnalytics.insertLog("101", NotesSAConstants.EVENT_ACTIVE_THE_FAB, "a");
        }
    };
    private final View.OnClickListener mNoteStyleClickListener = new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.widget.FabMenuView.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FabMenuView.this.onBackKeyDown(true);
            CommonSamsungAnalytics.insertLog("101", NotesSAConstants.EVENT_ACTIVE_THE_FAB, "b");
        }
    };
    private final View.OnClickListener mCancelClickListener = new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.widget.FabMenuView.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FabMenuView.this.onBackKeyDown(false);
        }
    };
    private final View.OnLayoutChangeListener mBlurOnLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.widget.FabMenuView.9
        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) FabMenuView.this.mNoteFab.getLayoutParams();
            float dimension = FabMenuView.this.mMainView.getContext().getResources().getDimension(C8003R.dimen.noteslist_large_fab_container_width) + marginLayoutParams.bottomMargin;
            float measuredHeight = FabMenuView.this.mPdfFabContainer.getMeasuredHeight();
            float f = i5;
            FabMenuView.this.mCreateNoteY = f - dimension;
            FabMenuView.this.mNoteStyleY = f - (dimension + measuredHeight);
            FabMenuView.this.mPdfY = f - ((2.0f * measuredHeight) + dimension);
            StringBuilder sbM778t = AbstractC0541b.m778t(i5, "onLayoutChange bottomY: ", " container: ");
            sbM778t.append(FabMenuView.this.mMainView.getContext().getResources().getDimension(C8003R.dimen.noteslist_large_fab_container_width));
            sbM778t.append(" bottomMargin: ");
            sbM778t.append(marginLayoutParams.bottomMargin);
            sbM778t.append(" delta: ");
            sbM778t.append(measuredHeight);
            MainLogger.m7258i(FabMenuView.TAG, sbM778t.toString());
            MainLogger.m7258i(FabMenuView.TAG, "onLayoutChange createNoteY: " + FabMenuView.this.mCreateNoteY + " noteStyleY: " + FabMenuView.this.mNoteStyleY + " mPdfY: " + FabMenuView.this.mPdfY);
        }
    };
    private boolean mIsLongPressed = false;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class AnimatorListenerImpl implements Animator.AnimatorListener {
        public /* synthetic */ AnimatorListenerImpl(int i) {
            this();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NonNull Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NonNull Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NonNull Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NonNull Animator animator) {
        }

        private AnimatorListenerImpl() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        int getModeIndex();

        boolean getVerticalOffset();

        void onNewNote(String str, int i);
    }

    public FabMenuView(AbsFragment absFragment, NotesPresenter notesPresenter, Contract contract) {
        this.mFragment = absFragment;
        this.mNotesPresenter = notesPresenter;
        this.mContract = contract;
        initFakeFab();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void animateBlurView(boolean z, final boolean z2) {
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        if (z) {
            final ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            valueAnimatorOfFloat.setDuration(200L);
            valueAnimatorOfFloat.setInterpolator(linearInterpolator);
            this.mBlurView.setAlpha(0.0f);
            this.mBlurView.animate().alpha(1.0f).setDuration(200L).setInterpolator(linearInterpolator).setListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.widget.FabMenuView.10
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    DeviceUtils.updatePreferredDisplayMode(FabMenuView.this.mFragment.getActivity(), 0.0f);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    FabMenuView.this.updateBlurView(true, ResourceUtils.isSupportBackgroundBlur());
                    DeviceUtils.updatePreferredDisplayMode(FabMenuView.this.mFragment.getActivity(), 60.0f);
                    valueAnimatorOfFloat.start();
                }
            }).start();
            return;
        }
        long j = z2 ? 200L : 100L;
        final ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat2.setDuration(j);
        valueAnimatorOfFloat2.setInterpolator(linearInterpolator);
        this.mBlurView.setAlpha(1.0f);
        this.mBlurView.animate().alpha(0.0f).setDuration(j).setInterpolator(linearInterpolator).setListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.widget.FabMenuView.11
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                FabMenuView.this.updateBlurView(false, ResourceUtils.isSupportBackgroundBlur());
                DeviceUtils.updatePreferredDisplayMode(FabMenuView.this.mFragment.getActivity(), 0.0f);
                if (z2) {
                    Intent intent = new Intent(FabMenuView.this.mFragment.getContext(), (Class<?>) NoteStyleActivity.class);
                    intent.putExtra("key_type", Constant.Type.CREATE_NOTE.ordinal());
                    intent.putExtra(Constant.KEY_GRAVITY, 81);
                    FabMenuView.this.mFragment.getActivity().startActivityForResult(intent, 14);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                DeviceUtils.updatePreferredDisplayMode(FabMenuView.this.mFragment.getActivity(), 60.0f);
                valueAnimatorOfFloat2.start();
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void animateDefaultFab(boolean z, boolean z2) {
        scaleDefaultFab(this.mCancelFab, z, z2);
        scaleDefaultFab(this.mCreateNoteFab, !z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void animateExtendedFabs(boolean z, boolean z2) {
        if (!z) {
            long j = z2 ? 400L : 300L;
            scaleExtendedFab(this.mPdfFab, 1.0f, 0.0f, j);
            scaleExtendedFab(this.mNoteStyleFab, 1.0f, 0.0f, j);
            startAlphaAnimation(this.mPdfText, 1.0f, 0.0f, 100L);
            startAlphaAnimation(this.mNoteStyleText, 1.0f, 0.0f, 100L);
            startSpringAnimation(this.mPdfFabContainer, this.mPdfY, this.mCreateNoteY, false);
            startSpringAnimation(this.mNoteStyleFabContainer, this.mNoteStyleY, this.mCreateNoteY, false);
            return;
        }
        long j2 = z2 ? 400L : 300L;
        scaleExtendedFab(this.mPdfFab, 0.0f, 1.0f, j2);
        scaleExtendedFab(this.mNoteStyleFab, 0.0f, 1.0f, j2);
        long j3 = z2 ? 200L : 100L;
        startAlphaAnimation(this.mPdfText, 0.0f, 1.0f, j3);
        startAlphaAnimation(this.mNoteStyleText, 0.0f, 1.0f, j3);
        startSpringAnimation(this.mPdfFabContainer, this.mCreateNoteY, this.mPdfY, true);
        startSpringAnimation(this.mNoteStyleFabContainer, this.mCreateNoteY, this.mNoteStyleY, true);
    }

    private boolean applyBlurEffect(FloatingActionButton floatingActionButton) {
        if (floatingActionButton != null && Build.VERSION.SDK_INT >= 35) {
            if (SemBlurCompat.setBlurEffectPreset((View) floatingActionButton, 2, ContextUtils.isNightMode(this.mNoteFab.getContext()) ? new SemBlurCompat.CurveParameter(300, 0.7f, -15.0f, 0.0f, 235.0f, 36.7f, 87.7f) : new SemBlurCompat.CurveParameter(300, 0.75f, 25.0f, 15.0f, 235.0f, 214.6f, 252.8f), (Integer) null, (Float) null, (Integer) 0)) {
                floatingActionButton.setClipToOutline(true);
                floatingActionButton.setBackgroundTintList(ColorStateList.valueOf(this.mNoteFab.getResources().getColor(R.color.transparent)));
                return true;
            }
        }
        return false;
    }

    private View getMainView() {
        View view = this.mMainView;
        if (view != null) {
            return view;
        }
        FragmentActivity activity = this.mFragment.getActivity();
        if (CommonUtil.isNotAvailableActivity(activity)) {
            return null;
        }
        return ResourceUtils.isTabletLayout(activity.getApplicationContext()) ? activity.findViewById(C8003R.id.intercept_layout) : activity.findViewById(C8003R.id.main_view_container);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void inflateBlurView() {
        MainLogger.m7258i(TAG, "inflateBlurView");
        setBackPressedListener();
        if (this.mBlurView == null) {
            View viewFindViewById = this.mMainView.findViewById(C8003R.id.import_pdf_container);
            this.mPdfFabContainer = viewFindViewById;
            this.mPdfFab = (FloatingActionButton) viewFindViewById.findViewById(C8003R.id.import_pdf_btn);
            this.mPdfText = (TextView) this.mPdfFabContainer.findViewById(C8003R.id.import_pdf_text);
            View viewFindViewById2 = this.mMainView.findViewById(C8003R.id.note_style_container);
            this.mNoteStyleFabContainer = viewFindViewById2;
            this.mNoteStyleFab = (FloatingActionButton) viewFindViewById2.findViewById(C8003R.id.note_style_btn);
            this.mNoteStyleText = (TextView) this.mNoteStyleFabContainer.findViewById(C8003R.id.note_style_text);
            this.mCancelFab = (FloatingActionButton) this.mMainView.findViewById(C8003R.id.close_btn);
            this.mCreateNoteFab = (FloatingActionButton) this.mMainView.findViewById(C8003R.id.create_note_btn);
            this.mPdfFab.setOnClickListener(this.mPdfClickListener);
            this.mPdfText.setOnClickListener(this.mPdfClickListener);
            this.mNoteStyleFabContainer.setOnClickListener(this.mNoteStyleClickListener);
            this.mNoteStyleFab.setOnClickListener(this.mNoteStyleClickListener);
            this.mNoteStyleText.setOnClickListener(this.mNoteStyleClickListener);
            this.mCancelFab.setOnClickListener(this.mCancelClickListener);
            View viewFindViewById3 = this.mMainView.findViewById(C8003R.id.main_view_block);
            this.mBlurView = viewFindViewById3;
            viewFindViewById3.setOnTouchListener(new View.OnTouchListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.widget.FabMenuView.12
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return FabMenuView.this.onBackKeyDown(false);
                }
            });
            this.mBlurView.addOnLayoutChangeListener(this.mBlurOnLayoutChangeListener);
            applyBlurEffect(this.mCancelFab);
            applyBlurEffect(this.mPdfFab);
            applyBlurEffect(this.mNoteStyleFab);
            FabLongPressSmartTipCard.disableTipCard();
        } else {
            MainLogger.m7258i(TAG, "inflateBlurView# blur view is already inflated");
        }
        this.mBlurView.setVisibility(0);
    }

    private void initFakeFab() {
        if (CommonUtil.isNotAvailableActivity(this.mFragment.getActivity())) {
            return;
        }
        View mainView = getMainView();
        this.mMainView = mainView;
        if (mainView == null) {
            return;
        }
        View viewFindViewById = mainView.findViewById(C8003R.id.fake_fab);
        this.mFakeFab = viewFindViewById;
        if (viewFindViewById == null) {
            MainLogger.m7258i(TAG, "not found FakeFab");
            return;
        }
        if (!isFabCanVisible(this.mContract.getModeIndex())) {
            this.mFakeFab.setVisibility(8);
        }
        if (this.mFakeFab.getVisibility() != 0) {
            return;
        }
        this.mFakeFab.setOnClickListener(this.mCreateNoteFabClickListener);
        this.mFakeFab.setOnTouchListener(this);
    }

    private boolean isFabCanVisible(int i) {
        return this.mNotesPresenter.getStateInfo().getCaller() != 9 && FeatureUtils.isCreateNewNoteEnabled(i, this.mNotesPresenter.getStateInfo().getFolderUuid());
    }

    private boolean isFabViewStubExistOnMainView() {
        View view = this.mMainView;
        if (view == null) {
            return false;
        }
        if (view.findViewById(C8003R.id.fake_fab) != null) {
            return true;
        }
        return this.mMainView.findViewById(C8003R.id.note_fab) instanceof ViewStub;
    }

    private void scaleDefaultFab(final View view, boolean z, boolean z2) {
        if (view == null) {
            return;
        }
        PathInterpolator pathInterpolator = new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f);
        if (z) {
            view.setScaleX(0.0f);
            view.setScaleY(0.0f);
            view.animate().scaleX(1.0f).scaleY(1.0f).setDuration(400L).setInterpolator(pathInterpolator).setListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.widget.FabMenuView.13
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    view.setVisibility(0);
                }
            }).start();
        } else {
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
            view.animate().scaleX(0.0f).scaleY(0.0f).setDuration(300L).setInterpolator(pathInterpolator).setListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.widget.FabMenuView.14
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    view.setVisibility(4);
                }
            }).start();
        }
    }

    private void scaleExtendedFab(View view, float f, float f4, long j) {
        if (view == null) {
            return;
        }
        PathInterpolator pathInterpolator = new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f);
        view.setScaleX(f);
        view.setScaleY(f);
        view.animate().scaleX(f4).scaleY(f4).setDuration(j).setInterpolator(pathInterpolator).start();
    }

    private void setBackPressedListener() {
        OnBackPressedCallback onBackPressedCallback = this.mOnBackPressedCallback;
        if (onBackPressedCallback != null) {
            onBackPressedCallback.remove();
        }
        this.mOnBackPressedCallback = new OnBackPressedCallback(true) { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.widget.FabMenuView.17
            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                MainLogger.m7254d(FabMenuView.TAG, "handleOnBackPressed");
                FabMenuView.this.onBackKeyDown(false);
            }
        };
        this.mFragment.getActivity().getOnBackPressedDispatcher().addCallback(this.mFragment, this.mOnBackPressedCallback);
    }

    private void setFabDisplay() {
        boolean z = this.mNewDirection;
        if (z != this.mOldDirection) {
            setNoteFabVisibility(this.mNoteFab, z);
        }
        if (!this.mNewDirection && this.mContract.getVerticalOffset()) {
            setNoteFabVisibility(this.mNoteFab, this.mNewDirection);
            this.mNewDirection = true;
        }
        this.mOldDirection = this.mNewDirection;
    }

    private void startAlphaAnimation(View view, float f, float f4, long j) {
        if (view == null) {
            return;
        }
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        view.setAlpha(f);
        view.animate().alpha(f4).setDuration(j).setInterpolator(linearInterpolator).start();
    }

    private void startSpringAnimation(final View view, float f, float f4, final boolean z) {
        if (view == null) {
            return;
        }
        view.setY(f);
        SpringForce springForce = new SpringForce(f4);
        springForce.setDampingRatio(0.66f);
        springForce.setStiffness(300.0f);
        new SpringAnimation(view, DynamicAnimation.f1486Y).setSpring(springForce).addEndListener(new DynamicAnimation.OnAnimationEndListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.widget.FabMenuView.15
            @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
            public void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z2, float f5, float f6) {
                view.setFocusable(z);
                view.setFocusableInTouchMode(z);
                view.setImportantForAccessibility(z ? 1 : 2);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBlurView(boolean z, boolean z2) {
        if (!z) {
            if (z2) {
                ViewCompat.getInstance().semSetBlurInfo(this.mBlurView, null);
                return;
            } else {
                View view = this.mBlurView;
                view.setBackgroundColor(ContextCompat.getColor(view.getContext(), C8003R.color.transparent));
                return;
            }
        }
        if (z2) {
            ViewCompat.getInstance().semSetBlurInfo(this.mBlurView, new SemBlurInfoCompat.Builder(2).setColorCurvePreset(ContextUtils.isNightMode(this.mMainView.getContext()) ? 118 : 103));
            return;
        }
        View view2 = this.mBlurView;
        view2.setBackgroundColor(ContextCompat.getColor(view2.getContext(), C8003R.color.drawer_list_bg_color));
        this.mBlurView.getBackground().mutate().setAlpha(244);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFabVisibility() {
        this.mPdfFab.setVisibility(0);
        this.mPdfText.setVisibility(0);
        this.mNoteStyleFab.setVisibility(0);
        this.mNoteStyleText.setVisibility(0);
    }

    public View getNoteFabLayout() {
        View view = this.mNoteFab;
        return view != null ? view : getNoteFakeFabLayout();
    }

    public View getNoteFakeFabLayout() {
        return this.mFakeFab;
    }

    @SuppressLint({"ClickableViewAccessibility", "WrongViewCast"})
    public void inflateFab() {
        FragmentActivity activity = this.mFragment.getActivity();
        if (!CommonUtil.isNotAvailableActivity(activity) && this.mNoteFab == null) {
            View mainView = getMainView();
            this.mMainView = mainView;
            if (mainView == null) {
                return;
            }
            MainLogger.m7258i(TAG, "inflateFab# ");
            if (isFabViewStubExistOnMainView()) {
                this.mNoteFab = ViewModeUtils.getInflatedView(this.mMainView, C8003R.id.note_fab, C8003R.id.inflate_note_fab);
            } else {
                this.mNoteFab = this.mMainView.findViewById(C8003R.id.note_fab);
            }
            if (this.mNoteFab == null) {
                return;
            }
            FloatingActionButton floatingActionButton = (FloatingActionButton) this.mMainView.findViewById(C8003R.id.create_note_btn);
            this.mCreateNoteFab = floatingActionButton;
            floatingActionButton.setOnLongClickListener(this.mCreateNoteFabLongClickListener);
            this.mCreateNoteFab.setOnClickListener(this.mCreateNoteFabClickListener);
            this.mCreateNoteFab.setOnTouchListener(this);
            this.mCreateNoteFab.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.widget.FabMenuView.16
                @Override // java.lang.Runnable
                public void run() {
                    FabLongPressSmartTipCard.requestShowLongPressTipCard(FabMenuView.this.mCreateNoteFab);
                }
            });
            if (WidgetInsetUtils.getCanUseWindowInsets() && isFabCanVisible(this.mContract.getModeIndex())) {
                WidgetInsetUtils.applyWindowInsetsToNoteFab(activity.getWindow(), getNoteFabLayout(), getNoteFakeFabLayout());
            }
            setNoteFabVisibility(this.mNoteFab, true);
            this.mIsFabsBlurEffect = applyBlurEffect(this.mCreateNoteFab);
        }
    }

    public void invalidate() {
        if (this.mIsFabsBlurEffect) {
            FloatingActionButton floatingActionButton = this.mCreateNoteFab;
            if (floatingActionButton != null) {
                floatingActionButton.invalidate();
            }
            FloatingActionButton floatingActionButton2 = this.mCancelFab;
            if (floatingActionButton2 != null) {
                floatingActionButton2.invalidate();
            }
            FloatingActionButton floatingActionButton3 = this.mPdfFab;
            if (floatingActionButton3 != null) {
                floatingActionButton3.invalidate();
            }
            FloatingActionButton floatingActionButton4 = this.mNoteStyleFab;
            if (floatingActionButton4 != null) {
                floatingActionButton4.invalidate();
            }
        }
    }

    public boolean onBackKeyDown(boolean z) {
        OnBackPressedCallback onBackPressedCallback = this.mOnBackPressedCallback;
        if (onBackPressedCallback != null) {
            onBackPressedCallback.remove();
            this.mOnBackPressedCallback = null;
        }
        if (!this.mIsLongPressed) {
            return false;
        }
        this.mIsLongPressed = false;
        animateDefaultFab(false, z);
        animateExtendedFabs(false, z);
        animateBlurView(false, z);
        return true;
    }

    public void onDestroy() {
        MainLogger.m7258i(TAG, "onDestroy");
        View view = this.mBlurView;
        if (view == null) {
            return;
        }
        view.removeOnLayoutChangeListener(this.mBlurOnLayoutChangeListener);
        this.mBlurView = null;
    }

    @SuppressLint({"WrongViewCast"})
    public void onListScrollStateChanged() {
        if (FeatureUtils.isCreateNewNoteEnabled(this.mContract.getModeIndex(), this.mNotesPresenter.getStateInfo().getFolderUuid())) {
            this.mNotesPresenter.setLastOpenedSDocXUuid(null);
            View mainView = getMainView();
            this.mMainView = mainView;
            if (mainView == null) {
                return;
            }
            if (isFabViewStubExistOnMainView()) {
                inflateFab();
            }
            if (this.mNoteFab == null) {
                this.mNoteFab = this.mMainView.findViewById(C8003R.id.note_fab);
            }
            View view = this.mNoteFab;
            if (view == null || view.getVisibility() != 0) {
                this.mNewDirection = false;
                this.mOldDirection = false;
            } else {
                this.mNewDirection = true;
                this.mOldDirection = true;
            }
            this.mNotesPresenter.setIsScrolling(true);
            this.mHandler.removeCallbacks(this.mShowNoteFabScrollFinished);
            this.mHandler.postDelayed(this.mShowNoteFabScrollFinished, 300L);
        }
    }

    public void onListScrolled(int i) {
        if (FeatureUtils.isCreateNewNoteEnabled(this.mContract.getModeIndex(), this.mNotesPresenter.getStateInfo().getFolderUuid())) {
            if (i > 0) {
                this.mNewDirection = false;
            } else if (i < 0) {
                this.mNewDirection = true;
                invalidate();
            }
            setFabDisplay();
            this.mHandler.removeCallbacks(this.mShowNoteFabScrollFinished);
            this.mHandler.postDelayed(this.mShowNoteFabScrollFinished, 300L);
        }
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, @NonNull MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        this.mToolType = motionEvent.getToolType(motionEvent.getPointerCount() - 1);
        return false;
    }

    public void setNoteFabVisibility(View view, boolean z) {
        Fragment fragment = this.mFragment;
        if (fragment == null || fragment.getActivity() == null || view == null) {
            return;
        }
        if (!isFabCanVisible(this.mContract.getModeIndex())) {
            view.setVisibility(8);
            View view2 = this.mFakeFab;
            if (view2 != null) {
                view2.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoteFab = view;
        ViewPropertyAnimator viewPropertyAnimatorAnimate = this.mCreateNoteFab.animate();
        if (z) {
            viewPropertyAnimatorAnimate.setDuration(200L).setInterpolator(InterpolatorUtil.getSineInOut80()).scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setListener(this.mAnimatorFabShowListener).start();
        } else {
            viewPropertyAnimatorAnimate.setDuration(200L).setInterpolator(InterpolatorUtil.getSineInOut80()).scaleX(MID_SCALE).scaleY(MID_SCALE).alpha(0.0f).setListener(this.mAnimatorFabHideListener).start();
        }
    }
}
