package com.samsung.android.support.senl.p148nt.composer.main.base.external.tageditor.view;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.ColorFilter;
import android.graphics.Insets;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.SimpleLottieValueCallback;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.external.tageditor.common.Utils;
import com.samsung.android.support.senl.p148nt.composer.main.base.external.tageditor.controller.StateChangeListener;
import com.samsung.android.support.senl.p148nt.composer.main.base.external.tageditor.controller.TagEditorController;
import com.samsung.android.support.senl.p148nt.composer.main.base.external.tageditor.model.CandidateTagData;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TagEditorUI implements StateChangeListener {
    private static final int INPUT_FILTER_MAX_LENGTH = 50;
    private static final int MAX_SELECTED_ITEM_COUNT = 30;
    private static final String TAG = "TagEditorUI";
    private TagEditorActionListener mActionListener;
    private Activity mActivity;
    private CandidateTagAdapter mAdapter;
    private View mAddButtonView;
    private ViewGroup mContentArea;
    private CandidateTagsRecyclerView mContentListView;
    private final TagEditorController mController;
    private Display mDisplay;
    private EditText mEditTextView;
    private FlexboxLayoutManager mLayoutManager;
    private ViewGroup mMainGroupView;
    private View mMaskingArea;
    private View mSaveButtonView;
    private final Point mPoint = new Point();
    private final List<CandidateTagData> mList = new ArrayList();
    private boolean mIsSaved = false;
    private InputMethodManager mInputMethodManager = null;
    private int mMaxLimitedCount = 30;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.external.tageditor.view.TagEditorUI$10 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C909510 {

        /* JADX INFO: renamed from: $SwitchMap$com$samsung$android$support$senl$nt$composer$main$base$external$tageditor$controller$StateChangeListener$State */
        static final /* synthetic */ int[] f6765xd3a2aaa5;

        static {
            int[] iArr = new int[StateChangeListener.State.values().length];
            f6765xd3a2aaa5 = iArr;
            try {
                iArr[StateChangeListener.State.INITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6765xd3a2aaa5[StateChangeListener.State.DESTROYED_WITH_SAVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6765xd3a2aaa5[StateChangeListener.State.DESTROYED_WITHOUT_SAVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6765xd3a2aaa5[StateChangeListener.State.RESUME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class CandidateTagAdapter extends RecyclerView.Adapter<ViewHolder> {
        private static final int TAG_TEXT_LENGTH_LIMIT = 30;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class ViewHolder extends RecyclerView.ViewHolder {
            AnimatorSet mAnimatorSet;
            View mContainerView;
            LottieAnimationView mLottieView;
            TextView mTextView;

            public ViewHolder(View view) {
                super(view);
                this.mAnimatorSet = new AnimatorSet();
                this.mContainerView = view.findViewById(C9086R.id.tag_container);
                this.mLottieView = (LottieAnimationView) view.findViewById(C9086R.id.tag_icon);
                this.mTextView = (TextView) view.findViewById(C9086R.id.tag_text);
            }
        }

        public CandidateTagAdapter() {
        }

        private void initClickListener(final ViewHolder viewHolder) {
            viewHolder.mContainerView.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.external.tageditor.view.TagEditorUI.CandidateTagAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int bindingAdapterPosition = viewHolder.getBindingAdapterPosition();
                    if (bindingAdapterPosition >= TagEditorUI.this.mList.size()) {
                        return;
                    }
                    CandidateTagData candidateTagData = (CandidateTagData) TagEditorUI.this.mList.get(bindingAdapterPosition);
                    boolean zIsSelected = candidateTagData.isSelected();
                    boolean z = !zIsSelected;
                    if (zIsSelected || !TagEditorUI.this.isReachedLimitedCount()) {
                        candidateTagData.setSelected(z);
                        if (candidateTagData.getType() == 0) {
                            ArrayList arrayList = new ArrayList();
                            for (CandidateTagData candidateTagData2 : TagEditorUI.this.mList) {
                                if (candidateTagData2.getType() == 0) {
                                    arrayList.add(candidateTagData2);
                                }
                            }
                        }
                        if (viewHolder.mAnimatorSet.isRunning()) {
                            viewHolder.mAnimatorSet.cancel();
                        } else {
                            CandidateTagAdapter.this.playTagAnimation(view, viewHolder.mAnimatorSet, z);
                        }
                    }
                }
            });
            viewHolder.mContainerView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.external.tageditor.view.a
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return this.f6766a.lambda$initClickListener$0(viewHolder, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean lambda$initClickListener$0(ViewHolder viewHolder, View view) {
            int bindingAdapterPosition;
            if (TagEditorUI.this.mEditTextView.getText() != null && TextUtils.isEmpty(TagEditorUI.this.mEditTextView.getText()) && (bindingAdapterPosition = viewHolder.getBindingAdapterPosition()) < TagEditorUI.this.mList.size()) {
                String title = ((CandidateTagData) TagEditorUI.this.mList.get(bindingAdapterPosition)).getTitle();
                TagEditorUI.this.mList.remove(bindingAdapterPosition);
                notifyDataSetChanged();
                TagEditorUI.this.mEditTextView.setText(title);
                TagEditorUI.this.mEditTextView.setSelection(TagEditorUI.this.mEditTextView.getText().length());
                TagEditorUI.this.mEditTextView.requestFocus();
                if (TagEditorUI.this.mInputMethodManager != null) {
                    TagEditorUI.this.mInputMethodManager.showSoftInput(TagEditorUI.this.mEditTextView, 1);
                }
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void playTagAnimation(final View view, AnimatorSet animatorSet, boolean z) {
            Activity activity;
            int i;
            animatorSet.removeAllListeners();
            final LottieAnimationView lottieAnimationView = (LottieAnimationView) view.findViewById(C9086R.id.tag_icon);
            lottieAnimationView.setAnimation("ic_tag.json");
            if (z) {
                lottieAnimationView.setMinAndMaxFrame(0, 32);
            } else {
                lottieAnimationView.setMinAndMaxFrame(150, 168);
            }
            lottieAnimationView.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.external.tageditor.view.TagEditorUI.CandidateTagAdapter.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    TagEditorUI.this.notifyDataSetChanged();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            });
            ValueAnimator valueAnimatorOfArgb = ValueAnimator.ofArgb(TagEditorUI.this.mActivity.getColor(z ? C9086R.color.tag_editor_candidate_text_color_unselected : C9086R.color.tag_editor_candidate_text_color_selected), TagEditorUI.this.mActivity.getColor(z ? C9086R.color.tag_editor_candidate_text_color_selected : C9086R.color.tag_editor_candidate_text_color_unselected));
            valueAnimatorOfArgb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.external.tageditor.view.TagEditorUI.CandidateTagAdapter.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(final ValueAnimator valueAnimator) {
                    lottieAnimationView.addValueCallback(new KeyPath("**"), LottieProperty.COLOR_FILTER, new SimpleLottieValueCallback<ColorFilter>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.external.tageditor.view.TagEditorUI.CandidateTagAdapter.3.1
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.airbnb.lottie.value.SimpleLottieValueCallback
                        public ColorFilter getValue(LottieFrameInfo<ColorFilter> lottieFrameInfo) {
                            return new PorterDuffColorFilter(((Integer) valueAnimator.getAnimatedValue()).intValue(), PorterDuff.Mode.SRC_ATOP);
                        }
                    });
                }
            });
            final TextView textView = (TextView) view.findViewById(C9086R.id.tag_text);
            ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(textView, "textColor", TagEditorUI.this.mActivity.getColor(z ? C9086R.color.tag_editor_candidate_text_color_unselected : C9086R.color.tag_editor_candidate_text_color_selected), TagEditorUI.this.mActivity.getColor(z ? C9086R.color.tag_editor_candidate_text_color_selected : C9086R.color.tag_editor_candidate_text_color_unselected));
            objectAnimatorOfInt.setEvaluator(new ArgbEvaluator());
            objectAnimatorOfInt.setInterpolator(new LinearInterpolator());
            objectAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.external.tageditor.view.TagEditorUI.CandidateTagAdapter.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    textView.setTextColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
            final GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(TagEditorUI.this.mActivity.getResources().getDimensionPixelOffset(C9086R.dimen.tag_editor_candidate_tag_radius));
            int color = TagEditorUI.this.mActivity.getColor(z ? C9086R.color.tag_editor_candidate_background_color_unselected : C9086R.color.tag_editor_candidate_background_color_selected);
            if (z) {
                activity = TagEditorUI.this.mActivity;
                i = C9086R.color.tag_editor_candidate_background_color_selected;
            } else {
                activity = TagEditorUI.this.mActivity;
                i = C9086R.color.tag_editor_candidate_background_color_unselected;
            }
            ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(color), Integer.valueOf(activity.getColor(i)));
            valueAnimatorOfObject.setInterpolator(new LinearInterpolator());
            valueAnimatorOfObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.external.tageditor.view.TagEditorUI.CandidateTagAdapter.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    gradientDrawable.setTint(((Integer) valueAnimator.getAnimatedValue()).intValue());
                    view.setBackground(gradientDrawable);
                }
            });
            animatorSet.setDuration(150L);
            animatorSet.playTogether(valueAnimatorOfArgb, objectAnimatorOfInt, valueAnimatorOfObject);
            lottieAnimationView.playAnimation();
            animatorSet.start();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return TagEditorUI.this.mList.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            Activity activity;
            int i2;
            CandidateTagData candidateTagData = (CandidateTagData) TagEditorUI.this.mList.get(i);
            String title = candidateTagData.getTitle();
            if (!TextUtils.isEmpty(title) && title.length() > 30) {
                title = title.substring(0, 30) + "...";
            }
            viewHolder.mAnimatorSet.cancel();
            viewHolder.mTextView.setText(title);
            TextView textView = viewHolder.mTextView;
            if (candidateTagData.isSelected()) {
                activity = TagEditorUI.this.mActivity;
                i2 = C9086R.color.tag_editor_candidate_text_color_selected;
            } else {
                activity = TagEditorUI.this.mActivity;
                i2 = C9086R.color.tag_editor_candidate_text_color_unselected;
            }
            textView.setTextColor(activity.getColor(i2));
            viewHolder.mLottieView.setImageResource(candidateTagData.isSelected() ? C9086R.drawable.comp_title_tag_ic_sharp : C9086R.drawable.comp_hw_toolbar_convert_setting_add);
            viewHolder.mLottieView.setImageTintList(candidateTagData.isSelected() ? ColorStateList.valueOf(TagEditorUI.this.mActivity.getColor(C9086R.color.tag_editor_candidate_icon_tint_color_selected)) : ColorStateList.valueOf(TagEditorUI.this.mActivity.getColor(C9086R.color.tag_editor_candidate_icon_tint_color_unselected)));
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(TagEditorUI.this.mActivity.getResources().getDimensionPixelOffset(C9086R.dimen.tag_editor_candidate_tag_radius));
            gradientDrawable.setColor(candidateTagData.isSelected() ? TagEditorUI.this.mActivity.getColor(C9086R.color.tag_editor_candidate_background_color_selected) : TagEditorUI.this.mActivity.getColor(C9086R.color.tag_editor_candidate_background_color_unselected));
            viewHolder.mContainerView.setForeground(candidateTagData.isSelected() ? TagEditorUI.this.mActivity.getDrawable(C9086R.drawable.tag_ripple_background_candidate_tag_selected) : TagEditorUI.this.mActivity.getDrawable(C9086R.drawable.tag_ripple_background_candidate_tag_unselected));
            viewHolder.mContainerView.setBackground(gradientDrawable);
            ViewCompat.getInstance().setTooltipText(viewHolder.mContainerView, candidateTagData.getTitle());
            initClickListener(viewHolder);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C9086R.layout.candidate_tag_chip_layout, viewGroup, false));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface TagEditorActionListener {
        void onSavePressed(List<CandidateTagData> list);
    }

    public TagEditorUI(TagEditorController tagEditorController) {
        this.mController = tagEditorController;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addCandidateTag() {
        if (TextUtils.isEmpty(this.mEditTextView.getText())) {
            return;
        }
        String string = this.mEditTextView.getText().toString();
        if (isReachedLimitedCount()) {
            return;
        }
        for (CandidateTagData candidateTagData : this.mList) {
            if (candidateTagData.getTitle().equalsIgnoreCase(string)) {
                if (candidateTagData.isSelected()) {
                    return;
                }
                candidateTagData.setSelected(true);
                notifyDataSetChanged();
                this.mEditTextView.setText("");
                return;
            }
        }
        this.mEditTextView.setText("");
        this.mList.add(new CandidateTagData(string, 0, true));
        notifyDataSetChanged();
        this.mContentListView.smoothScrollToPosition(this.mList.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void determineEditorWidth() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mMainGroupView.getLayoutParams();
        boolean z = this.mDisplay.getRotation() % 2 != 0;
        this.mDisplay.getSize(this.mPoint);
        TypedValue typedValue = new TypedValue();
        this.mActivity.getResources().getValue(C9086R.dimen.tag_editor_width, typedValue, true);
        layoutParams.width = (int) (typedValue.getFloat() * this.mPoint.x);
        if (z) {
            layoutParams.bottomMargin = this.mActivity.getResources().getDimensionPixelSize(C9086R.dimen.tag_editor_bottom_margin_land);
            if (Build.VERSION.SDK_INT >= 35 && WindowManagerCompat.getInstance().getMultiWindowMode(this.mActivity.getResources().getConfiguration()) == 0) {
                layoutParams.width -= InputMethodCompat.getInstance().getNavigationBarHeightIgnoreHasSoftKey(this.mActivity) * 2;
                WindowInsets rootWindowInsets = this.mMainGroupView.getRootWindowInsets();
                if (rootWindowInsets != null) {
                    Insets insets = rootWindowInsets.getInsets(WindowInsets.Type.navigationBars());
                    layoutParams.bottomMargin = (insets.bottom - insets.top) + layoutParams.bottomMargin;
                }
            }
        } else {
            int dimensionPixelSize = this.mActivity.getResources().getDimensionPixelSize(C9086R.dimen.tag_editor_bottom_margin);
            layoutParams.bottomMargin = dimensionPixelSize;
            if (Build.VERSION.SDK_INT >= 35) {
                layoutParams.bottomMargin = InputMethodCompat.getInstance().getNavigationBarHeightIgnoreHasSoftKey(this.mActivity) + dimensionPixelSize;
            }
        }
        this.mMainGroupView.setLayoutParams(layoutParams);
        updateMarginPadding(z);
    }

    private void init() {
        ViewCompat.getInstance().setRoundedCornerColor(this.mMainGroupView, this.mActivity.getColor(R.color.transparent));
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(this.mActivity);
        this.mLayoutManager = flexboxLayoutManager;
        flexboxLayoutManager.setJustifyContent(0);
        this.mLayoutManager.setFlexDirection(0);
        this.mContentListView.setLayoutManager(this.mLayoutManager);
        CandidateTagAdapter candidateTagAdapter = new CandidateTagAdapter();
        this.mAdapter = candidateTagAdapter;
        this.mContentListView.setAdapter(candidateTagAdapter);
        this.mContentListView.seslSetHoverScrollEnabled(false);
        this.mContentListView.addItemDecoration(new ItemOffsetDecoration(this.mActivity, C9086R.dimen.tag_editor_content_area_spacing));
        this.mContentListView.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.external.tageditor.view.TagEditorUI.2
            @Override // android.view.View.OnScrollChangeListener
            public void onScrollChange(View view, int i, int i2, int i4, int i5) {
                if (TagEditorUI.this.mContentListView.canScrollVertically(1)) {
                    TagEditorUI.this.mMaskingArea.setVisibility(0);
                } else {
                    TagEditorUI.this.mMaskingArea.setVisibility(8);
                }
            }
        });
        this.mAddButtonView.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.external.tageditor.view.TagEditorUI.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TagEditorUI.this.addCandidateTag();
                ComposerSA.insertLog(ComposerSAConstants.SCREEN_DIALOGS_TAG_EDITOR, ComposerSAConstants.EVENT_DIALOGS_TAG_EDITOR_ADD_TAG);
            }
        });
        initEditTextView();
        this.mSaveButtonView.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.external.tageditor.view.TagEditorUI.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TagEditorUI.this.addCandidateTag();
                TagEditorUI.this.saveTags();
                ComposerSA.insertLog(ComposerSAConstants.SCREEN_DIALOGS_TAG_EDITOR, ComposerSAConstants.EVENT_DIALOGS_TAG_EDITOR_SAVE);
            }
        });
        if (Build.VERSION.SDK_INT >= 35) {
            final View decorView = this.mActivity.getWindow().getDecorView();
            androidx.core.view.ViewCompat.setOnApplyWindowInsetsListener(decorView, new OnApplyWindowInsetsListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.external.tageditor.view.TagEditorUI.5
                @Override // androidx.core.view.OnApplyWindowInsetsListener
                @NonNull
                public WindowInsetsCompat onApplyWindowInsets(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
                    androidx.core.graphics.Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.ime());
                    View view2 = decorView;
                    view2.setPadding(view2.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), insets.bottom - insets.top);
                    return WindowInsetsCompat.toWindowInsetsCompat(view.onApplyWindowInsets(windowInsetsCompat.toWindowInsets()));
                }
            });
        }
    }

    private void initEditTextView() {
        this.mEditTextView.setFilters(new InputFilter[]{new EditorInputFilter(this.mActivity), new Utils.LimitLengthInputFilter(this.mActivity, 50)});
        this.mEditTextView.addTextChangedListener(new TextWatcher() { // from class: com.samsung.android.support.senl.nt.composer.main.base.external.tageditor.view.TagEditorUI.6
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String strRemoveExceptLetterOrDigit = Utils.removeExceptLetterOrDigit(editable.toString());
                if (editable.toString().equals(strRemoveExceptLetterOrDigit)) {
                    return;
                }
                TagEditorUI.this.mEditTextView.setText(strRemoveExceptLetterOrDigit);
                TagEditorUI.this.mEditTextView.setSelection(TagEditorUI.this.mEditTextView.getText().length());
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i4) {
                TagEditorUI.this.mAddButtonView.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
            }
        });
        this.mEditTextView.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.external.tageditor.view.TagEditorUI.7
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (keyEvent == null) {
                    TagEditorUI.this.addCandidateTag();
                    return true;
                }
                if (keyEvent.getAction() != 0 || keyEvent.getRepeatCount() != 0) {
                    return true;
                }
                TagEditorUI.this.addCandidateTag();
                return true;
            }
        });
        this.mEditTextView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.external.tageditor.view.TagEditorUI.8
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    ComposerSA.insertLog(ComposerSAConstants.SCREEN_DIALOGS_TAG_EDITOR, ComposerSAConstants.EVENT_DIALOGS_TAG_EDITOR_TAG);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isReachedLimitedCount() {
        ArrayList arrayList = new ArrayList();
        for (CandidateTagData candidateTagData : this.mList) {
            if (candidateTagData.isSelected()) {
                arrayList.add(candidateTagData);
            }
        }
        int size = arrayList.size();
        int i = this.mMaxLimitedCount;
        if (size < i) {
            return false;
        }
        Activity activity = this.mActivity;
        ToastHandler.show(activity, activity.getString(C9086R.string.tag_editor_toast_input_error_max_number_tag, Integer.valueOf(i)), 0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyDataSetChanged() {
        CandidateTagsRecyclerView candidateTagsRecyclerView = this.mContentListView;
        if (candidateTagsRecyclerView != null) {
            candidateTagsRecyclerView.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.external.tageditor.view.TagEditorUI.9
                @Override // java.lang.Runnable
                public void run() {
                    TagEditorUI.this.mAdapter.notifyDataSetChanged();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveTags() {
        if (this.mIsSaved || this.mActionListener == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (CandidateTagData candidateTagData : this.mList) {
            if (candidateTagData.isSelected()) {
                arrayList.add(candidateTagData);
            }
        }
        if (arrayList.size() + (!TextUtils.isEmpty(this.mEditTextView.getText()) ? 1 : 0) > this.mMaxLimitedCount) {
            return;
        }
        this.mIsSaved = true;
        this.mActionListener.onSavePressed(new ArrayList(this.mList));
        InputMethodManager inputMethodManager = this.mInputMethodManager;
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.mEditTextView.getWindowToken(), 0);
        }
    }

    private void updateMarginPadding(boolean z) {
        int paddingLeft = this.mMainGroupView.getPaddingLeft();
        int paddingRight = this.mMainGroupView.getPaddingRight();
        int dimensionPixelSize = this.mActivity.getResources().getDimensionPixelSize(C9086R.dimen.tag_editor_top_padding);
        int dimensionPixelSize2 = this.mActivity.getResources().getDimensionPixelSize(C9086R.dimen.tag_editor_bottom_padding);
        if (z) {
            dimensionPixelSize = this.mActivity.getResources().getDimensionPixelSize(C9086R.dimen.tag_editor_top_padding_land);
            dimensionPixelSize2 = this.mActivity.getResources().getDimensionPixelSize(C9086R.dimen.tag_editor_bottom_padding_land);
        }
        this.mMainGroupView.setPadding(paddingLeft, dimensionPixelSize, paddingRight, dimensionPixelSize2);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.mContentArea.getLayoutParams();
        int dimensionPixelSize3 = this.mActivity.getResources().getDimensionPixelSize(C9086R.dimen.tag_editor_content_area_top_margin);
        if (z) {
            dimensionPixelSize3 = this.mActivity.getResources().getDimensionPixelSize(C9086R.dimen.tag_editor_content_area_top_margin_land);
        }
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = dimensionPixelSize3;
        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = dimensionPixelSize3;
        this.mContentArea.setLayoutParams(layoutParams);
    }

    public void initCandidateTagList(List<CandidateTagData> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.mList.clear();
        this.mList.addAll(list);
        notifyDataSetChanged();
    }

    public void initView(Activity activity, View view) {
        this.mActivity = activity;
        this.mMainGroupView = (ViewGroup) view.findViewById(C9086R.id.tag_editor_group);
        this.mContentArea = (ViewGroup) view.findViewById(C9086R.id.content_area);
        this.mContentListView = (CandidateTagsRecyclerView) view.findViewById(C9086R.id.content_list);
        this.mMaskingArea = view.findViewById(C9086R.id.masking_area);
        this.mSaveButtonView = view.findViewById(C9086R.id.btn_save);
        this.mEditTextView = (EditText) view.findViewById(C9086R.id.editor_input);
        this.mAddButtonView = view.findViewById(C9086R.id.btn_add);
        this.mController.registerListener(this);
        this.mInputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method");
        Display defaultDisplay = ((WindowManager) this.mActivity.getSystemService("window")).getDefaultDisplay();
        this.mDisplay = defaultDisplay;
        defaultDisplay.getSize(this.mPoint);
        determineEditorWidth();
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.external.tageditor.view.TagEditorUI.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                new Handler().postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.external.tageditor.view.TagEditorUI.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TagEditorUI.this.determineEditorWidth();
                    }
                }, 200L);
            }
        });
        init();
    }

    public void onDestroy() {
        this.mController.unregisterListener(this);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.external.tageditor.controller.StateChangeListener
    public void onStateChanged(StateChangeListener.State state) {
        int i = C909510.f6765xd3a2aaa5[state.ordinal()];
        if (i == 2) {
            addCandidateTag();
            saveTags();
        } else if (i == 3 || i == 4) {
            this.mIsSaved = false;
        }
    }

    public void setActionListener(TagEditorActionListener tagEditorActionListener) {
        this.mActionListener = tagEditorActionListener;
    }

    public void setMaxSelectedItemCount(int i) {
        if (i < 1) {
            this.mMaxLimitedCount = 30;
        } else {
            this.mMaxLimitedCount = i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ItemOffsetDecoration extends RecyclerView.ItemDecoration {
        private final int mItemOffset;

        public ItemOffsetDecoration(int i) {
            this.mItemOffset = i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            super.getItemOffsets(rect, view, recyclerView, state);
            int i = this.mItemOffset;
            rect.set(0, i, 0, i);
        }

        public ItemOffsetDecoration(@NonNull Context context, @DimenRes int i) {
            this(context.getResources().getDimensionPixelSize(i));
        }
    }
}
