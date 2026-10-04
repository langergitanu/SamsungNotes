package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.IntProperty;
import android.util.Log;
import android.util.Property;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.SectionIndexer;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.C0419R;
import androidx.appcompat.animation.SeslAnimationUtils;
import androidx.appcompat.util.SeslMisc;
import androidx.collection.AbstractC0622a;
import androidx.core.graphics.ColorUtils;
import androidx.core.math.MathUtils;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.recyclerview.C3728R;
import androidx.recyclerview.animation.SeslAnimatable;
import androidx.recyclerview.animation.SeslColorAnimatable;
import androidx.recyclerview.animation.SeslFloatAnimatable;
import androidx.recyclerview.sesl.drawable.SeslFastScrollerBgDrawable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SeslRecyclerViewFastScroller;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.reflect.view.SeslHapticFeedbackConstantsReflector;
import com.sun.imageio.plugins.jpeg.JPEG;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.DisposableHandle;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(24)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
class SeslRecyclerViewFastScroller {
    private static final float DEFAULT_NORMAL_VIBRATE_VELOCITY = 0.0f;
    private static final int DURATION_CROSS_FADE = 0;
    private static final int DURATION_FADE_IN = 167;
    private static final int DURATION_FADE_OUT = 150;
    private static final int DURATION_RESIZE = 100;
    public static final int EFFECT_STATE_CLOSE = 0;
    public static final int EFFECT_STATE_OPEN = 1;
    private static final long FADE_TIMEOUT = 1500;
    private static final int FASTSCROLL_FAST_VIBRATE_INDEX = 24;
    private static final int FASTSCROLL_NORMAL_VIBRATE_INDEX = 26;
    private static final float MIN_FAST_VIBRATE_VELOCITY = 1000.0f;
    private static final int OVERLAY_ABOVE_THUMB = 2;
    private static final int OVERLAY_AT_THUMB = 1;
    private static final int OVERLAY_FLOATING = 0;
    private static final int PREVIEW_LEFT = 0;
    private static final int PREVIEW_RIGHT = 1;
    private static final int STATE_DRAGGING = 2;
    private static final int STATE_NONE = 0;
    private static final int STATE_VISIBLE = 1;
    private static final String TAG = "SeslFastScroller";
    private static final int THUMB_POSITION_INSIDE = 1;
    private static final int THUMB_POSITION_MIDPOINT = 0;
    private int mAdditionalBottomPadding;
    private int mAdditionalTopPadding;
    private final float mAdditionalTouchArea;
    private boolean mAlwaysShow;
    private final Context mContext;
    private AnimatorSet mDecorAnimation;
    private boolean mEnabled;
    private int mFastVibrateIndex;
    private int mImmersiveBottomPadding;
    private boolean mLayoutFromRight;
    private RecyclerView.Adapter<?> mListAdapter;
    private boolean mLongList;
    private final boolean mMatchDragPosition;
    private int mNormalVibrateIndex;
    private int mOldChildCount;
    private int mOldItemCount;
    private final ViewGroupOverlay mOverlay;
    private final int mOverlayPosition;
    private AnimatorSet mPreviewAnimation;
    private final View mPreviewImage;
    private final int mPreviewMarginEnd;
    private final int mPreviewMinHeight;
    private final int mPreviewMinWidth;
    private final int[] mPreviewResId;
    private final TextView mPrimaryText;
    private final RecyclerView mRecyclerView;
    private final int mScaledTouchSlop;
    private int mScrollBarStyle;
    private boolean mScrollCompleted;
    private final TextView mSecondaryText;
    private SectionIndexer mSectionIndexer;
    private Object[] mSections;
    private boolean mShowingPreview;
    private boolean mShowingPrimary;
    private int mState;
    private final int mTextAppearance;
    private final ColorStateList mTextColor;
    private final float mTextSize;

    @Nullable
    private final Drawable mThumbDrawable;
    private final ImageView mThumbImage;
    private final int mThumbMarginEnd;
    private final int mThumbMinHeight;
    private final int mThumbMinWidth;
    private float mThumbOffset;
    private final int mThumbPosition;
    private float mThumbRange;

    @Nullable
    private final SeslFastScrollThumbAnimator mThumbWidthAnimator;

    @Nullable
    private final Drawable mTrackDrawable;
    private final ImageView mTrackImage;
    private final int mTrackVerticalPadding;
    private boolean mUpdatingLayout;
    private VelocityTracker mVelocityTracker;
    private int mWidth;
    private static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    private static final long TAP_TIMEOUT = ViewConfiguration.getTapTimeout();
    private static final Property<View, Integer> LEFT = new IntProperty<View>("left") { // from class: androidx.recyclerview.widget.SeslRecyclerViewFastScroller.2
        @Override // android.util.Property
        public Integer get(View view) {
            return Integer.valueOf(view.getLeft());
        }

        @Override // android.util.IntProperty
        public void setValue(View view, int i) {
            view.setLeft(i);
        }
    };
    private static final Property<View, Integer> TOP = new IntProperty<View>("top") { // from class: androidx.recyclerview.widget.SeslRecyclerViewFastScroller.3
        @Override // android.util.Property
        public Integer get(View view) {
            return Integer.valueOf(view.getTop());
        }

        @Override // android.util.IntProperty
        public void setValue(View view, int i) {
            view.setTop(i);
        }
    };
    private static final Property<View, Integer> RIGHT = new IntProperty<View>("right") { // from class: androidx.recyclerview.widget.SeslRecyclerViewFastScroller.4
        @Override // android.util.Property
        public Integer get(View view) {
            return Integer.valueOf(view.getRight());
        }

        @Override // android.util.IntProperty
        public void setValue(View view, int i) {
            view.setRight(i);
        }
    };
    private static final Property<View, Integer> BOTTOM = new IntProperty<View>("bottom") { // from class: androidx.recyclerview.widget.SeslRecyclerViewFastScroller.5
        @Override // android.util.Property
        public Integer get(View view) {
            return Integer.valueOf(view.getBottom());
        }

        @Override // android.util.IntProperty
        public void setValue(View view, int i) {
            view.setBottom(i);
        }
    };
    private final Rect mTempBounds = new Rect();
    private final Rect mTempMargins = new Rect();
    private final Rect mContainerRect = new Rect();
    private float mThumbTouchYOffset = 0.0f;
    private int mCurrentSection = -1;
    private int mScrollbarPosition = -1;
    private long mPendingDrag = -1;
    private int mColorPrimary = -1;
    private float mScrollY = 0.0f;
    private int mEffectState = 0;
    private float mOldThumbPosition = -1.0f;
    private float mThreshold = 0.0f;
    private float mLastDraggingY = 0.0f;
    private int mScrollBarTopOffset = 0;
    private int mScrollBarBottomOffset = 0;
    private final Runnable mDeferHide = new RunnableC3802b(this, 0);
    private final Animator.AnimatorListener mSwitchPrimaryListener = new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.SeslRecyclerViewFastScroller.1
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SeslRecyclerViewFastScroller.this.mShowingPrimary = !r2.mShowingPrimary;
        }
    };
    private int mListScrollRange = -1;
    private int mListScrollExtent = -1;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RequiresApi(api = 26)
    public static class SeslFastScrollThumbAnimator implements DisposableHandle {
        private static final float DEFAULT_SCROLL_BAR_VALUE = 0.0f;
        private static final float FAST_SCROLL_BAR_VALUE = 1.0f;
        private final int mActivatedColor;

        @NonNull
        private SeslFastScrollerBgDrawable mBgDrawable;
        private final SeslColorAnimatable mColorAnimator;
        private int mCustomColor = 0;
        private final int mDefaultColor;
        private final float mMaxWidthPx;
        private final float mMinWidthPx;
        private final SeslFloatAnimatable mWidthAnimator;

        public SeslFastScrollThumbAnimator(@NonNull Context context, @NonNull LayerDrawable layerDrawable) {
            this.mBgDrawable = (SeslFastScrollerBgDrawable) layerDrawable.findDrawableByLayerId(C3728R.id.thumb_bg);
            this.mMinWidthPx = context.getResources().getDimension(C3728R.dimen.sesl_fast_scroller_thumb_min_width);
            this.mMaxWidthPx = context.getResources().getDimension(C3728R.dimen.sesl_fast_scroller_thumb_max_width);
            int alphaComponent = ColorUtils.setAlphaComponent(context.getResources().getColor(SeslMisc.isLightTheme(context) ? C0419R.color.sesl_scrollbar_handle_tint_color_light : C0419R.color.sesl_scrollbar_handle_tint_color_dark), 255);
            this.mDefaultColor = alphaComponent;
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(C0419R.attr.colorPrimary, typedValue, true);
            this.mActivatedColor = ColorUtils.setAlphaComponent(context.getResources().getColor(typedValue.resourceId), 153);
            final int i = 0;
            SeslFloatAnimatable seslFloatAnimatable = new SeslFloatAnimatable(-1.0f, new SeslAnimatable.SimpleAnimationSpec(350L, PathInterpolatorCompat.create(0.22f, 0.25f, 0.0f, 1.0f)), new Function1(this) { // from class: androidx.recyclerview.widget.c

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ SeslRecyclerViewFastScroller.SeslFastScrollThumbAnimator f1660b;

                {
                    this.f1660b = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    switch (i) {
                        case 0:
                            return this.f1660b.lambda$new$0((Float) obj);
                        default:
                            return this.f1660b.lambda$new$1((Integer) obj);
                    }
                }
            });
            this.mWidthAnimator = seslFloatAnimatable;
            final int i2 = 1;
            SeslColorAnimatable seslColorAnimatable = new SeslColorAnimatable(-1, new SeslAnimatable.SimpleAnimationSpec(150L, PathInterpolatorCompat.create(0.0f, 0.0f, 1.0f, 1.0f)), new Function1(this) { // from class: androidx.recyclerview.widget.c

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ SeslRecyclerViewFastScroller.SeslFastScrollThumbAnimator f1660b;

                {
                    this.f1660b = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    switch (i2) {
                        case 0:
                            return this.f1660b.lambda$new$0((Float) obj);
                        default:
                            return this.f1660b.lambda$new$1((Integer) obj);
                    }
                }
            });
            this.mColorAnimator = seslColorAnimatable;
            seslFloatAnimatable.tryAnimateTo(Float.valueOf(0.0f));
            seslColorAnimatable.tryAnimateTo(Integer.valueOf(alphaComponent));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit lambda$new$0(Float f) {
            float f4 = this.mMinWidthPx;
            this.mBgDrawable.setValue((f.floatValue() * (this.mMaxWidthPx - f4)) + f4);
            this.mBgDrawable.invalidateSelf();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit lambda$new$1(Integer num) {
            this.mBgDrawable.setArgb(num.intValue());
            this.mBgDrawable.invalidateSelf();
            return Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public void dispose() {
            this.mWidthAnimator.dispose();
            this.mColorAnimator.dispose();
        }

        public void setDefaultColor(int i) {
            this.mCustomColor = i;
            SeslColorAnimatable seslColorAnimatable = this.mColorAnimator;
            if (i == 0) {
                i = this.mDefaultColor;
            }
            seslColorAnimatable.tryAnimateTo(Integer.valueOf(i));
        }

        public void setDragging(boolean z) {
            int i;
            this.mWidthAnimator.tryAnimateTo(Float.valueOf(z ? 1.0f : 0.0f));
            if (z) {
                i = this.mActivatedColor;
            } else {
                i = this.mCustomColor;
                if (i == 0) {
                    i = this.mDefaultColor;
                }
            }
            this.mColorAnimator.tryAnimateTo(Integer.valueOf(i));
        }
    }

    public SeslRecyclerViewFastScroller(RecyclerView recyclerView) {
        int[] iArr = new int[2];
        this.mPreviewResId = iArr;
        this.mRecyclerView = recyclerView;
        this.mOldItemCount = getItemCount(recyclerView);
        this.mOldChildCount = recyclerView.getChildCount();
        Context context = recyclerView.getContext();
        this.mContext = context;
        this.mScaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mScrollBarStyle = recyclerView.getScrollBarStyle();
        this.mScrollCompleted = true;
        this.mState = 1;
        this.mMatchDragPosition = context.getApplicationInfo().targetSdkVersion >= 11;
        ImageView imageView = new ImageView(context);
        this.mTrackImage = imageView;
        ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_XY;
        imageView.setScaleType(scaleType);
        ImageView imageView2 = new ImageView(context);
        this.mThumbImage = imageView2;
        imageView2.setScaleType(scaleType);
        View view = new View(context);
        this.mPreviewImage = view;
        view.setAlpha(0.0f);
        TextView textViewCreatePreviewTextView = createPreviewTextView(context);
        this.mPrimaryText = textViewCreatePreviewTextView;
        TextView textViewCreatePreviewTextView2 = createPreviewTextView(context);
        this.mSecondaryText = textViewCreatePreviewTextView2;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, C3728R.styleable.FastScroll, 0, C3728R.style.Widget_RecyclerView_FastScroll);
        try {
            this.mOverlayPosition = typedArrayObtainStyledAttributes.getInt(C3728R.styleable.FastScroll_position, 0);
            iArr[0] = typedArrayObtainStyledAttributes.getResourceId(C3728R.styleable.FastScroll_backgroundLeft, 0);
            iArr[1] = typedArrayObtainStyledAttributes.getResourceId(C3728R.styleable.FastScroll_backgroundRight, 0);
            Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(C3728R.styleable.FastScroll_thumbDrawable);
            this.mThumbDrawable = drawable;
            this.mTrackDrawable = typedArrayObtainStyledAttributes.getDrawable(C3728R.styleable.FastScroll_trackDrawable);
            this.mTextAppearance = typedArrayObtainStyledAttributes.getResourceId(C3728R.styleable.FastScroll_android_textAppearance, 0);
            this.mTextColor = typedArrayObtainStyledAttributes.getColorStateList(C3728R.styleable.FastScroll_android_textColor);
            this.mTextSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(C3728R.styleable.FastScroll_android_textSize, 0);
            this.mPreviewMinWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(C3728R.styleable.FastScroll_android_minWidth, 0);
            this.mPreviewMinHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(C3728R.styleable.FastScroll_android_minHeight, 0);
            this.mThumbMinWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(C3728R.styleable.FastScroll_thumbMinWidth, 0);
            this.mThumbMinHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(C3728R.styleable.FastScroll_thumbMinHeight, 0);
            int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(C3728R.styleable.FastScroll_android_padding, 0);
            this.mThumbPosition = typedArrayObtainStyledAttributes.getInt(C3728R.styleable.FastScroll_thumbPosition, 0);
            typedArrayObtainStyledAttributes.recycle();
            if (drawable instanceof LayerDrawable) {
                this.mThumbWidthAnimator = new SeslFastScrollThumbAnimator(context, (LayerDrawable) drawable);
            } else {
                this.mThumbWidthAnimator = null;
            }
            updateAppearance();
            ViewGroupOverlay overlay = recyclerView.getOverlay();
            this.mOverlay = overlay;
            overlay.add(imageView);
            overlay.add(imageView2);
            overlay.add(view);
            overlay.add(textViewCreatePreviewTextView);
            overlay.add(textViewCreatePreviewTextView2);
            Resources resources = context.getResources();
            this.mPreviewMarginEnd = resources.getDimensionPixelOffset(C3728R.dimen.sesl_fast_scroll_preview_margin_end);
            this.mThumbMarginEnd = 0;
            this.mAdditionalTouchArea = resources.getDimension(C3728R.dimen.sesl_fast_scroll_additional_touch_area);
            this.mTrackVerticalPadding = resources.getDimensionPixelOffset(C3728R.dimen.sesl_fast_scroller_track_vertical_padding);
            this.mAdditionalBottomPadding = 0;
            this.mAdditionalTopPadding = 0;
            this.mImmersiveBottomPadding = 0;
            textViewCreatePreviewTextView.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            textViewCreatePreviewTextView2.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            getSectionsFromIndexer();
            updateLongList(this.mOldChildCount, this.mOldItemCount);
            setScrollbarPosition(recyclerView.getVerticalScrollbarPosition());
            postAutoHide();
            this.mNormalVibrateIndex = SeslHapticFeedbackConstantsReflector.semGetVibrationIndex(26);
            this.mFastVibrateIndex = SeslHapticFeedbackConstantsReflector.semGetVibrationIndex(24);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    private static Animator animateAlpha(View view, float f) {
        return ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, f);
    }

    private static Animator animateBounds(View view, Rect rect) {
        return ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofInt(LEFT, rect.left), PropertyValuesHolder.ofInt(TOP, rect.top), PropertyValuesHolder.ofInt(RIGHT, rect.right), PropertyValuesHolder.ofInt(BOTTOM, rect.bottom));
    }

    private static Animator animateScaleX(View view, float f) {
        return ObjectAnimator.ofFloat(view, (Property<View, Float>) View.SCALE_X, f);
    }

    private void applyLayout(View view, Rect rect) {
        view.layout(rect.left, rect.top, rect.right, rect.bottom);
        view.setPivotX(this.mLayoutFromRight ? rect.right - rect.left : 0.0f);
    }

    private void beginDrag() {
        this.mPendingDrag = -1L;
        if (this.mListAdapter == null) {
            getSectionsFromIndexer();
        }
        this.mRecyclerView.requestDisallowInterceptTouchEvent(true);
        cancelFling();
        setState(2);
    }

    private void cancelFling() {
        MotionEvent motionEventObtain = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0);
        this.mRecyclerView.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    private void cancelPendingDrag() {
        this.mPendingDrag = -1L;
    }

    private TextView createPreviewTextView(Context context) {
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -2);
        TextView textView = new TextView(context);
        textView.setLayoutParams(layoutParams);
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        textView.setGravity(17);
        textView.setAlpha(0.0f);
        textView.setLayoutDirection(this.mRecyclerView.getLayoutDirection());
        return textView;
    }

    private int getItemCount(RecyclerView recyclerView) {
        if (recyclerView.getAdapter() == null) {
            return 0;
        }
        return recyclerView.getAdapter().getItemCount();
    }

    private float getPosFromItemCount(int i, int i2, int i4) {
        int spanCount;
        Object[] objArr;
        int positionForSection;
        if (this.mSectionIndexer == null || this.mListAdapter == null) {
            getSectionsFromIndexer();
        }
        if (i2 != 0 && i4 != 0) {
            SectionIndexer sectionIndexer = this.mSectionIndexer;
            int paddingTop = this.mRecyclerView.getPaddingTop();
            RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
            if (paddingTop > 0 && (layoutManager instanceof LinearLayoutManager)) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                while (i > 0) {
                    int i5 = i - 1;
                    if (linearLayoutManager.findViewByPosition(i5) == null) {
                        break;
                    }
                    i = i5;
                }
            }
            RecyclerView recyclerView = this.mRecyclerView;
            int childAdapterPosition = i - recyclerView.getChildAdapterPosition(recyclerView.getChildAt(0));
            if (childAdapterPosition < 0) {
                childAdapterPosition = 0;
            }
            View childAt = this.mRecyclerView.getChildAt(childAdapterPosition);
            float top = (childAt == null || childAt.getHeight() == 0) ? 0.0f : i == 0 ? (paddingTop - childAt.getTop()) / (childAt.getHeight() + paddingTop) : (-childAt.getTop()) / childAt.getHeight();
            if (sectionIndexer == null || (objArr = this.mSections) == null || objArr.length <= 0 || !this.mMatchDragPosition) {
                if (i2 != i4 || (i != 0 && !(layoutManager instanceof StaggeredGridLayoutManager))) {
                    if (layoutManager instanceof GridLayoutManager) {
                        GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
                        spanCount = gridLayoutManager.getSpanCount() / gridLayoutManager.getSpanSizeLookup().getSpanSize(i);
                    } else {
                        spanCount = layoutManager instanceof StaggeredGridLayoutManager ? ((StaggeredGridLayoutManager) layoutManager).getSpanCount() : 1;
                    }
                    f = ((top * spanCount) + i) / i4;
                } else if ((layoutManager instanceof StaggeredGridLayoutManager) && i != 0 && childAt != null && ((StaggeredGridLayoutManager.LayoutParams) childAt.getLayoutParams()).isFullSpan()) {
                    return 1.0f;
                }
            } else {
                if (i < 0) {
                    return 0.0f;
                }
                int sectionForPosition = sectionIndexer.getSectionForPosition(i);
                int positionForSection2 = sectionIndexer.getPositionForSection(sectionForPosition);
                int length = this.mSections.length;
                if (sectionForPosition < length - 1) {
                    int i6 = sectionForPosition + 1;
                    positionForSection = (i6 < length ? sectionIndexer.getPositionForSection(i6) : i4 - 1) - positionForSection2;
                } else {
                    positionForSection = i4 - positionForSection2;
                }
                f = (sectionForPosition + (positionForSection != 0 ? ((i + top) - positionForSection2) / positionForSection : 0.0f)) / length;
            }
            if (i + i2 == i4) {
                View childAt2 = this.mRecyclerView.getChildAt(i2 - 1);
                View childAt3 = this.mRecyclerView.getChildAt(0);
                int paddingBottom = this.mRecyclerView.getPaddingBottom() + (childAt2.getBottom() - this.mRecyclerView.getHeight());
                int top2 = paddingBottom - (childAt3.getTop() - this.mRecyclerView.getPaddingTop());
                if (top2 > childAt2.getHeight() || i > 0) {
                    top2 = childAt2.getHeight();
                }
                int i7 = top2 - paddingBottom;
                if (i7 > 0 && top2 > 0) {
                    return ((i7 / top2) * (1.0f - f)) + f;
                }
            }
        }
        return f;
    }

    private float getPosFromMotionEvent(float f) {
        float f4 = this.mThumbRange;
        if (f4 <= 0.0f) {
            return 0.0f;
        }
        return MathUtils.clamp(((f - this.mThumbOffset) + this.mThumbTouchYOffset) / f4, 0.0f, 1.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void getSectionsFromIndexer() {
        this.mSectionIndexer = null;
        RecyclerView.Adapter<?> adapter = this.mRecyclerView.getAdapter();
        if (!(adapter instanceof SectionIndexer)) {
            this.mListAdapter = adapter;
            this.mSections = null;
        } else {
            this.mListAdapter = adapter;
            SectionIndexer sectionIndexer = (SectionIndexer) adapter;
            this.mSectionIndexer = sectionIndexer;
            this.mSections = sectionIndexer.getSections();
        }
    }

    private int getThumbLength(int i, int i2, int i4, int i5) {
        int iRound = Math.round((i * i4) / i5);
        return iRound < i2 ? i2 : iRound;
    }

    private static Animator groupAnimatorOfFloat(Property<View, Float> property, float f, View... viewArr) {
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSet.Builder builderPlay = null;
        for (int length = viewArr.length - 1; length >= 0; length--) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewArr[length], property, f);
            if (builderPlay == null) {
                builderPlay = animatorSet.play(objectAnimatorOfFloat);
            } else {
                builderPlay.with(objectAnimatorOfFloat);
            }
        }
        return animatorSet;
    }

    private boolean isPointInside(float f, float f4) {
        return isPointInsideX(f) && isPointInsideY(f4) && this.mState != 0;
    }

    private boolean isPointInsideX(float f) {
        return this.mLayoutFromRight ? f >= ((float) this.mThumbImage.getLeft()) - this.mAdditionalTouchArea : f <= ((float) this.mThumbImage.getRight()) + this.mAdditionalTouchArea;
    }

    private boolean isPointInsideY(float f) {
        float translationY = this.mThumbImage.getTranslationY();
        return f >= ((float) this.mThumbImage.getTop()) + translationY && f <= ((float) this.mThumbImage.getBottom()) + translationY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        setState(0);
    }

    private void layoutThumb() {
        RecyclerView recyclerView = this.mRecyclerView;
        Rect rect = this.mTempBounds;
        if (this.mLayoutFromRight) {
            int iWidth = this.mContainerRect.width();
            rect.right = iWidth;
            rect.left = iWidth - this.mContext.getResources().getDimensionPixelOffset(C3728R.dimen.sesl_fast_scroll_thumb_width);
        } else {
            rect.right = this.mContext.getResources().getDimensionPixelOffset(C3728R.dimen.sesl_fast_scroll_thumb_width);
            rect.left = 0;
        }
        rect.top = 0;
        int height = ((((recyclerView.getHeight() - (this.mTrackVerticalPadding * 2)) - this.mAdditionalTopPadding) - this.mAdditionalBottomPadding) - this.mScrollBarTopOffset) - this.mScrollBarBottomOffset;
        rect.bottom = Math.min(getThumbLength(height, this.mContext.getResources().getDimensionPixelOffset(C3728R.dimen.sesl_fast_scroll_thumb_min_height), this.mListScrollExtent, this.mListScrollRange), height);
        applyLayout(this.mThumbImage, rect);
    }

    private void layoutTrack() {
        int i;
        int i2;
        ImageView imageView = this.mTrackImage;
        ImageView imageView2 = this.mThumbImage;
        Rect rect = this.mContainerRect;
        imageView.measure(View.MeasureSpec.makeMeasureSpec(Math.max(0, rect.width()), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(Math.max(0, rect.height())), 0));
        if (this.mThumbPosition == 1) {
            int i4 = rect.top;
            int i5 = this.mTrackVerticalPadding;
            i2 = i4 + i5 + this.mAdditionalTopPadding + this.mScrollBarTopOffset;
            i = ((rect.bottom - i5) - this.mAdditionalBottomPadding) - this.mScrollBarBottomOffset;
        } else {
            int height = imageView2.getHeight() / 2;
            int i6 = rect.top + height;
            int i7 = this.mTrackVerticalPadding;
            int i8 = i6 + i7 + this.mAdditionalTopPadding + this.mScrollBarTopOffset;
            i = (((rect.bottom - height) - i7) - this.mAdditionalBottomPadding) - this.mScrollBarBottomOffset;
            i2 = i8;
        }
        if (i < i2) {
            Log.e(TAG, AbstractC0622a.m1164j(i, i, "Error occured during layoutTrack() because bottom[", "] is less than top[", "]."));
            i = i2;
        }
        int measuredWidth = imageView.getMeasuredWidth();
        int width = ((imageView2.getWidth() - measuredWidth) / 2) + imageView2.getLeft();
        imageView.layout(width, i2, measuredWidth + width, i);
    }

    private void measureFloating(View view, Rect rect, Rect rect2) {
        int i;
        int i2;
        int i4;
        if (rect == null) {
            i4 = 0;
            i = 0;
            i2 = 0;
        } else {
            i = rect.left;
            i2 = rect.top;
            i4 = rect.right;
        }
        Rect rect3 = this.mContainerRect;
        int iWidth = rect3.width();
        view.measure(View.MeasureSpec.makeMeasureSpec(Math.max(0, (iWidth - i) - i4), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(Math.max(0, rect3.height())), 0));
        int iHeight = rect3.height();
        int measuredWidth = view.getMeasuredWidth();
        int i5 = (iHeight / 10) + i2 + rect3.top;
        int measuredHeight = view.getMeasuredHeight() + i5;
        int i6 = ((iWidth - measuredWidth) / 2) + rect3.left;
        rect2.set(i6, i5, measuredWidth + i6, measuredHeight);
    }

    private void measurePreview(View view, Rect rect) {
        Rect rect2 = this.mTempMargins;
        rect2.left = this.mPreviewImage.getPaddingLeft();
        rect2.top = this.mPreviewImage.getPaddingTop();
        rect2.right = this.mPreviewImage.getPaddingRight();
        rect2.bottom = this.mPreviewImage.getPaddingBottom();
        if (this.mOverlayPosition == 0) {
            measureFloating(view, rect2, rect);
        } else {
            measureViewToSide(view, this.mThumbImage, rect2, rect);
        }
    }

    private void measureViewToSide(View view, View view2, Rect rect, Rect rect2) {
        int i;
        int i2;
        int right;
        int left;
        if (this.mLayoutFromRight) {
            i2 = view2 == null ? this.mThumbMarginEnd : this.mPreviewMarginEnd;
            i = 0;
        } else {
            i = view2 == null ? this.mThumbMarginEnd : this.mPreviewMarginEnd;
            i2 = 0;
        }
        Rect rect3 = this.mContainerRect;
        int iWidth = rect3.width();
        if (view2 != null) {
            iWidth = this.mLayoutFromRight ? view2.getLeft() : iWidth - view2.getRight();
        }
        int iMax = Math.max(0, rect3.height());
        int iMax2 = Math.max(0, (iWidth - i) - i2);
        view.measure(View.MeasureSpec.makeMeasureSpec(iMax2, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(iMax), 0));
        int iMin = Math.min(iMax2, view.getMeasuredWidth());
        if (this.mLayoutFromRight) {
            left = (view2 == null ? rect3.right : view2.getLeft()) - i2;
            right = left - iMin;
        } else {
            right = i + (view2 == null ? rect3.left : view2.getRight());
            left = right + iMin;
        }
        rect2.set(right, 0, left, view.getMeasuredHeight());
    }

    private void onStateDependencyChanged(boolean z) {
        if (!isEnabled()) {
            stop();
            return;
        }
        if (isAlwaysShowEnabled()) {
            setState(1);
            return;
        }
        if (this.mState == 1) {
            postAutoHide();
        } else if (z) {
            setState(1);
            postAutoHide();
        }
    }

    private void postAutoHide() {
        this.mRecyclerView.removeCallbacks(this.mDeferHide);
        this.mRecyclerView.postDelayed(this.mDeferHide, 1500L);
    }

    private void refreshDrawablePressedState() {
        boolean z = this.mState == 2;
        this.mThumbImage.setPressed(z);
        this.mTrackImage.setPressed(z);
    }

    private void resetScrollDatas() {
        this.mListScrollRange = -1;
        this.mListScrollExtent = -1;
    }

    private void scrollTo(float f) {
        scrollTo(f, 0.0f);
    }

    private void setState(int i) {
        this.mRecyclerView.removeCallbacks(this.mDeferHide);
        if (this.mAlwaysShow && i == 0) {
            i = 1;
        }
        if (i == this.mState) {
            return;
        }
        if (i == 0) {
            transitionToHidden();
        } else if (i == 1) {
            transitionToVisible();
        } else if (i == 2) {
            transitionPreviewLayout(this.mCurrentSection);
        }
        SeslFastScrollThumbAnimator seslFastScrollThumbAnimator = this.mThumbWidthAnimator;
        if (seslFastScrollThumbAnimator != null) {
            seslFastScrollThumbAnimator.setDragging(i == 2);
        }
        this.mState = i;
        refreshDrawablePressedState();
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x000c A[PHI: r2
      0x000c: PHI (r2v6 float) = (r2v0 float), (r2v1 float) binds: [B:3:0x000a, B:6:0x0011] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void setThumbPos(float f) {
        Rect rect = this.mContainerRect;
        int i = rect.top;
        int i2 = rect.bottom;
        float f4 = 1.0f;
        if (f > 1.0f) {
            f = f4;
        } else {
            f4 = 0.0f;
            if (f < 0.0f) {
            }
        }
        float f5 = (f * this.mThumbRange) + this.mThumbOffset;
        this.mThumbImage.setTranslationY(f5 - (r2.getHeight() / 2.0f));
        View view = this.mPreviewImage;
        float height = view.getHeight() / 2.0f;
        float fClamp = MathUtils.clamp(f5, i + height, i2 - height) - height;
        view.setTranslationY(fClamp);
        this.mPrimaryText.setTranslationY(fClamp);
        this.mSecondaryText.setTranslationY(fClamp);
    }

    private void startPendingDrag() {
        this.mPendingDrag = SystemClock.uptimeMillis() + TAP_TIMEOUT;
    }

    private boolean transitionPreviewLayout(int i) {
        return transitionPreviewLayout(i, 0.0f);
    }

    private void transitionToDragging() {
        AnimatorSet animatorSet = this.mDecorAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        Animator duration = groupAnimatorOfFloat(View.ALPHA, 1.0f, this.mThumbImage, this.mTrackImage, this.mPreviewImage).setDuration(167L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.mDecorAnimation = animatorSet2;
        animatorSet2.playTogether(duration);
        this.mDecorAnimation.setInterpolator(SeslAnimationUtils.SINE_IN_OUT_70);
        this.mDecorAnimation.start();
        this.mShowingPreview = true;
    }

    private void transitionToHidden() {
        int i;
        this.mShowingPreview = false;
        this.mCurrentSection = -1;
        AnimatorSet animatorSet = this.mDecorAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
            i = 150;
        } else {
            i = 0;
        }
        Animator duration = groupAnimatorOfFloat(View.ALPHA, 0.0f, this.mThumbImage, this.mTrackImage, this.mPreviewImage, this.mPrimaryText, this.mSecondaryText).setDuration(i);
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.mDecorAnimation = animatorSet2;
        animatorSet2.playTogether(duration);
        this.mDecorAnimation.setInterpolator(LINEAR_INTERPOLATOR);
        this.mDecorAnimation.start();
    }

    private void transitionToVisible() {
        AnimatorSet animatorSet = this.mDecorAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        Property property = View.ALPHA;
        Animator duration = groupAnimatorOfFloat(property, 1.0f, this.mThumbImage, this.mTrackImage).setDuration(167L);
        Animator duration2 = groupAnimatorOfFloat(property, 0.0f, this.mPreviewImage, this.mPrimaryText, this.mSecondaryText).setDuration(150L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.mDecorAnimation = animatorSet2;
        animatorSet2.playTogether(duration, duration2);
        this.mDecorAnimation.setInterpolator(SeslAnimationUtils.SINE_IN_OUT_70);
        this.mShowingPreview = false;
        this.mDecorAnimation.start();
    }

    private void updateAppearance() {
        TypedValue typedValue = new TypedValue();
        this.mContext.getTheme().resolveAttribute(C0419R.attr.colorPrimary, typedValue, true);
        this.mColorPrimary = ColorUtils.setAlphaComponent(this.mContext.getResources().getColor(typedValue.resourceId), JPEG.APP5);
        this.mTrackImage.setImageDrawable(this.mTrackDrawable);
        Drawable drawable = this.mTrackDrawable;
        int iMax = drawable != null ? Math.max(0, drawable.getIntrinsicWidth()) : 0;
        this.mThumbImage.setImageDrawable(this.mThumbDrawable);
        this.mThumbImage.setMinimumWidth(this.mThumbMinWidth);
        this.mThumbImage.setMinimumHeight(this.mThumbMinHeight);
        Drawable drawable2 = this.mThumbDrawable;
        if (drawable2 != null) {
            iMax = Math.max(iMax, drawable2.getIntrinsicWidth());
        }
        this.mWidth = Math.max(iMax, this.mThumbMinWidth);
        this.mPreviewImage.setMinimumWidth(this.mPreviewMinWidth);
        this.mPreviewImage.setMinimumHeight(this.mPreviewMinHeight);
        int i = this.mTextAppearance;
        if (i != 0) {
            this.mPrimaryText.setTextAppearance(this.mContext, i);
            this.mSecondaryText.setTextAppearance(this.mContext, this.mTextAppearance);
        }
        ColorStateList colorStateList = this.mTextColor;
        if (colorStateList != null) {
            this.mPrimaryText.setTextColor(colorStateList);
            this.mSecondaryText.setTextColor(this.mTextColor);
        }
        float f = this.mTextSize;
        if (f > 0.0f) {
            this.mPrimaryText.setTextSize(0, f);
            this.mSecondaryText.setTextSize(0, this.mTextSize);
        }
        int iMax2 = Math.max(0, this.mPreviewMinHeight);
        this.mPrimaryText.setMinimumWidth(this.mPreviewMinWidth);
        this.mPrimaryText.setMinimumHeight(iMax2);
        this.mPrimaryText.setIncludeFontPadding(false);
        this.mSecondaryText.setMinimumWidth(this.mPreviewMinWidth);
        this.mSecondaryText.setMinimumHeight(iMax2);
        this.mSecondaryText.setIncludeFontPadding(false);
        refreshDrawablePressedState();
    }

    private void updateContainerRect() {
        RecyclerView recyclerView = this.mRecyclerView;
        Rect rect = this.mContainerRect;
        rect.left = 0;
        rect.top = 0;
        rect.right = recyclerView.getWidth();
        rect.bottom = recyclerView.getHeight();
        int i = this.mScrollBarStyle;
        if (i == 16777216 || i == 0) {
            rect.left = recyclerView.getPaddingLeft() + rect.left;
            rect.top = recyclerView.getPaddingTop() + rect.top;
            rect.right -= recyclerView.getPaddingRight();
            rect.bottom -= recyclerView.getPaddingBottom();
            if (i == 16777216) {
                int width = getWidth();
                if (this.mScrollbarPosition == 2) {
                    rect.right += width;
                } else {
                    rect.left -= width;
                }
            }
        }
    }

    private void updateLongList(int i, int i2) {
        boolean z = i > 0 && (canScrollList(1) || canScrollList(-1));
        if (this.mLongList != z) {
            this.mLongList = z;
            onStateDependencyChanged(true);
        }
    }

    private void updateOffsetAndRange() {
        float top;
        float bottom;
        ImageView imageView = this.mTrackImage;
        ImageView imageView2 = this.mThumbImage;
        if (this.mThumbPosition == 1) {
            float height = imageView2.getHeight() / 2.0f;
            top = imageView.getTop() + height;
            bottom = imageView.getBottom() - height;
        } else {
            top = imageView.getTop();
            bottom = imageView.getBottom();
        }
        this.mThumbOffset = top;
        float f = (bottom - top) - this.mImmersiveBottomPadding;
        this.mThumbRange = f;
        if (f < 0.0f) {
            this.mThumbRange = 0.0f;
        }
    }

    public boolean canScrollList(int i) {
        int childCount = this.mRecyclerView.getChildCount();
        if (childCount == 0) {
            return false;
        }
        int iFindFirstVisibleItemPosition = this.mRecyclerView.findFirstVisibleItemPosition();
        RecyclerView recyclerView = this.mRecyclerView;
        Rect rect = recyclerView.mListPadding;
        if (i > 0) {
            return iFindFirstVisibleItemPosition + childCount < getItemCount(this.mRecyclerView) || recyclerView.getChildAt(childCount + (-1)).getBottom() > this.mRecyclerView.getHeight() - rect.bottom;
        }
        return iFindFirstVisibleItemPosition > 0 || recyclerView.getChildAt(0).getTop() < rect.top;
    }

    public int getEffectState() {
        return this.mEffectState;
    }

    public float getScrollY() {
        return this.mScrollY;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean isAlwaysShowEnabled() {
        return this.mAlwaysShow;
    }

    public boolean isEnabled() {
        if (this.mEnabled && !this.mLongList) {
            this.mLongList = canScrollList(1) || canScrollList(-1);
        }
        return this.mEnabled && (this.mLongList || this.mAlwaysShow);
    }

    public boolean onInterceptHoverEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if ((actionMasked == 9 || actionMasked == 7) && this.mState == 0 && isPointInside(motionEvent.getX(), motionEvent.getY())) {
            setState(1);
            postAutoHide();
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                cancelPendingDrag();
            } else if (actionMasked != 2) {
                if (actionMasked == 3) {
                }
            } else if (isPointInside(motionEvent.getX(), motionEvent.getY())) {
                long j = this.mPendingDrag;
                if (j >= 0 && j <= SystemClock.uptimeMillis()) {
                    beginDrag();
                    float posFromMotionEvent = getPosFromMotionEvent(0.0f);
                    this.mOldThumbPosition = posFromMotionEvent;
                    scrollTo(posFromMotionEvent);
                    return onTouchEvent(motionEvent);
                }
            } else {
                cancelPendingDrag();
            }
        } else if (isPointInside(motionEvent.getX(), motionEvent.getY())) {
            this.mRecyclerView.performHapticFeedback(this.mNormalVibrateIndex);
            return true;
        }
        return false;
    }

    public void onItemCountChanged(int i, int i2) {
        if (this.mOldChildCount == 0) {
            this.mOldChildCount = this.mRecyclerView.getChildCount();
        }
        if (this.mOldItemCount == i2 && this.mOldChildCount == i) {
            return;
        }
        this.mOldItemCount = i2;
        this.mOldChildCount = i;
        if (i2 - i > 0 && this.mState != 2) {
            setThumbPos(getPosFromItemCount(this.mRecyclerView.findFirstVisibleItemPosition(), i, i2));
        }
        updateLongList(i, i2);
    }

    public void onScroll(int i, int i2, int i4) {
        if (!isEnabled()) {
            setState(0);
            return;
        }
        if ((canScrollList(1) || canScrollList(-1)) && this.mState != 2) {
            float f = this.mOldThumbPosition;
            if (f != -1.0f) {
                setThumbPos(f);
                this.mOldThumbPosition = -1.0f;
            } else {
                setThumbPos(getPosFromItemCount(i, i2, i4));
            }
            if (this.mState != 2) {
                setState(1);
                postAutoHide();
            }
        }
        this.mScrollCompleted = true;
    }

    public void onSectionsChanged() {
        this.mListAdapter = null;
    }

    public void onSizeChanged(int i, int i2, int i4, int i5) {
        boolean z = true;
        if (!canScrollList(1) && !canScrollList(-1)) {
            z = false;
        }
        this.mLongList = z;
        resetScrollDatas();
        updateLayout();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        Rect rect = this.mContainerRect;
        int i = rect.top;
        int i2 = rect.bottom;
        ImageView imageView = this.mTrackImage;
        float top = imageView.getTop();
        float bottom = imageView.getBottom();
        this.mScrollY = motionEvent.getY();
        if (!isEnabled()) {
            return false;
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                if (this.mPendingDrag >= 0) {
                    beginDrag();
                    this.mVelocityTracker.computeCurrentVelocity(1000);
                    float yVelocity = this.mVelocityTracker.getYVelocity();
                    float posFromMotionEvent = getPosFromMotionEvent(motionEvent.getY());
                    this.mOldThumbPosition = posFromMotionEvent;
                    setThumbPos(posFromMotionEvent);
                    scrollTo(posFromMotionEvent, Math.abs(yVelocity));
                    this.mEffectState = 1;
                }
                this.mVelocityTracker.clear();
                if (this.mState == 2) {
                    this.mRecyclerView.requestDisallowInterceptTouchEvent(false);
                    setState(1);
                    postAutoHide();
                    this.mEffectState = 0;
                    this.mScrollY = 0.0f;
                    this.mThumbTouchYOffset = 0.0f;
                    return true;
                }
            } else if (actionMasked == 2) {
                if (this.mPendingDrag >= 0 && Math.abs(motionEvent.getY()) > this.mScaledTouchSlop) {
                    beginDrag();
                    float f = this.mScrollY;
                    float f4 = i;
                    if (f > f4 && f < i2) {
                        float f5 = f4 + top;
                        if (f < f5) {
                            this.mScrollY = f5;
                        } else if (f > bottom) {
                            this.mScrollY = bottom;
                        }
                        this.mEffectState = 1;
                    }
                }
                if (this.mState == 2) {
                    float posFromMotionEvent2 = getPosFromMotionEvent(motionEvent.getY());
                    this.mOldThumbPosition = posFromMotionEvent2;
                    setThumbPos(posFromMotionEvent2);
                    if (this.mThreshold != 0.0f && Math.abs(this.mLastDraggingY - this.mScrollY) <= this.mThreshold) {
                        return true;
                    }
                    this.mLastDraggingY = this.mScrollY;
                    if (this.mScrollCompleted) {
                        this.mVelocityTracker.computeCurrentVelocity(1000);
                        scrollTo(posFromMotionEvent2, Math.abs(this.mVelocityTracker.getYVelocity()));
                    }
                    float f6 = this.mScrollY;
                    float f7 = i;
                    if (f6 > f7 && f6 < i2) {
                        float f8 = f7 + top;
                        if (f6 < f8) {
                            this.mScrollY = f8;
                        } else if (f6 > bottom) {
                            this.mScrollY = bottom;
                        }
                        this.mEffectState = 1;
                    }
                    return true;
                }
            } else if (actionMasked == 3) {
                cancelPendingDrag();
                this.mVelocityTracker.clear();
                if (this.mState == 2) {
                    setState(0);
                }
                this.mEffectState = 0;
                this.mScrollY = 0.0f;
            }
        } else if (isPointInside(motionEvent.getX(), motionEvent.getY())) {
            beginDrag();
            this.mEffectState = 1;
            this.mThumbTouchYOffset = ((this.mThumbImage.getHeight() / 2.0f) + (this.mThumbImage.getTop() + this.mThumbImage.getTranslationY())) - motionEvent.getY();
            return true;
        }
        return false;
    }

    public void remove() {
        this.mOverlay.remove(this.mTrackImage);
        this.mOverlay.remove(this.mThumbImage);
        this.mOverlay.remove(this.mPreviewImage);
        this.mOverlay.remove(this.mPrimaryText);
        this.mOverlay.remove(this.mSecondaryText);
        SeslFastScrollThumbAnimator seslFastScrollThumbAnimator = this.mThumbWidthAnimator;
        if (seslFastScrollThumbAnimator != null) {
            seslFastScrollThumbAnimator.dispose();
        }
    }

    public void setAdditionalPadding(int i, int i2) {
        this.mAdditionalTopPadding = i;
        this.mAdditionalBottomPadding = i2;
        resetScrollDatas();
        updateLayout();
    }

    public void setAlwaysShow(boolean z) {
        if (this.mAlwaysShow != z) {
            this.mAlwaysShow = z;
            onStateDependencyChanged(false);
        }
    }

    @RequiresApi(26)
    public void setDefaultColor(int i) {
        SeslFastScrollThumbAnimator seslFastScrollThumbAnimator = this.mThumbWidthAnimator;
        if (seslFastScrollThumbAnimator != null) {
            seslFastScrollThumbAnimator.setDefaultColor(i);
        }
    }

    public void setEnabled(boolean z) {
        if (this.mEnabled != z) {
            this.mEnabled = z;
            onStateDependencyChanged(true);
        }
    }

    public void setImmersiveBottomPadding(int i) {
        this.mImmersiveBottomPadding = i;
        updateOffsetAndRange();
    }

    public void setScrollBarBottomOffset(int i) {
        if (i < 0) {
            i = 0;
        }
        this.mScrollBarBottomOffset = i;
        resetScrollDatas();
        updateLayout();
    }

    public void setScrollBarStyle(int i) {
        if (this.mScrollBarStyle != i) {
            this.mScrollBarStyle = i;
            resetScrollDatas();
            updateLayout();
        }
    }

    public void setScrollBarTopOffset(int i) {
        if (i < 0) {
            i = 0;
        }
        this.mScrollBarTopOffset = i;
        resetScrollDatas();
        updateLayout();
    }

    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public void setScrollbarPosition(int i) {
        RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        if (i == 0 && layoutManager != null) {
            i = layoutManager.getLayoutDirection() == 1 ? 1 : 2;
        }
        if (this.mScrollbarPosition != i) {
            this.mScrollbarPosition = i;
            ?? r12 = i == 1 ? 0 : 1;
            this.mLayoutFromRight = r12;
            this.mPreviewImage.setBackgroundResource(this.mPreviewResId[r12]);
            this.mPreviewImage.getBackground().setTintMode(PorterDuff.Mode.MULTIPLY);
            this.mPreviewImage.getBackground().setTint(this.mColorPrimary);
            resetScrollDatas();
            updateLayout();
        }
    }

    public void setThreshold(float f) {
        Log.d(TAG, "FastScroller setThreshold called = " + f);
        this.mThreshold = f;
    }

    public void stop() {
        setState(0);
    }

    public void updateLayout() {
        int i;
        if (this.mState == 2) {
            return;
        }
        RecyclerView recyclerView = this.mRecyclerView;
        int iComputeVerticalScrollRange = recyclerView.computeVerticalScrollRange();
        int iComputeVerticalScrollExtent = recyclerView.computeVerticalScrollExtent();
        int i2 = this.mListScrollRange;
        if ((i2 <= 0 || iComputeVerticalScrollRange != i2 || (i = this.mListScrollExtent) <= 0 || iComputeVerticalScrollExtent != i || this.mContainerRect.width() <= 0) && !this.mUpdatingLayout) {
            this.mUpdatingLayout = true;
            this.mListScrollRange = iComputeVerticalScrollRange;
            this.mListScrollExtent = iComputeVerticalScrollExtent;
            updateContainerRect();
            layoutThumb();
            layoutTrack();
            updateOffsetAndRange();
            this.mUpdatingLayout = false;
            Rect rect = this.mTempBounds;
            measurePreview(this.mPrimaryText, rect);
            applyLayout(this.mPrimaryText, rect);
            measurePreview(this.mSecondaryText, rect);
            applyLayout(this.mSecondaryText, rect);
            rect.left -= this.mPreviewImage.getPaddingLeft();
            rect.top -= this.mPreviewImage.getPaddingTop();
            rect.right = this.mPreviewImage.getPaddingRight() + rect.right;
            rect.bottom = this.mPreviewImage.getPaddingBottom() + rect.bottom;
            applyLayout(this.mPreviewImage, rect);
            float f = this.mOldThumbPosition;
            if (f != -1.0f) {
                setThumbPos(f);
                this.mOldThumbPosition = -1.0f;
            } else if (!canScrollList(1)) {
                setThumbPos(1.0f);
            } else {
                if (canScrollList(-1)) {
                    return;
                }
                setThumbPos(0.0f);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void scrollTo(float f, float f4) {
        int iClamp;
        int i;
        int i2;
        float f5;
        float f6;
        this.mScrollCompleted = false;
        int itemCount = getItemCount(this.mRecyclerView);
        Object[] objArr = this.mSections;
        int length = objArr == null ? 0 : objArr.length;
        if (objArr == null || length <= 0) {
            iClamp = MathUtils.clamp((int) (itemCount * f), 0, itemCount - 1);
            i = -1;
        } else {
            float f7 = length;
            int i4 = length - 1;
            int iClamp2 = MathUtils.clamp((int) (f * f7), 0, i4);
            int positionForSection = this.mSectionIndexer.getPositionForSection(iClamp2);
            int i5 = iClamp2 + 1;
            int positionForSection2 = iClamp2 < i4 ? this.mSectionIndexer.getPositionForSection(i5) : itemCount;
            int i6 = iClamp2;
            if (positionForSection2 == positionForSection) {
                int positionForSection3 = positionForSection;
                do {
                    if (i6 <= 0) {
                        i6 = iClamp2;
                    } else {
                        i6--;
                        positionForSection3 = this.mSectionIndexer.getPositionForSection(i6);
                        if (positionForSection3 != positionForSection) {
                        }
                    }
                    positionForSection = positionForSection3;
                    i = i6;
                    break;
                } while (i6 != 0);
                i6 = iClamp2;
                positionForSection = positionForSection3;
                i = 0;
                i2 = iClamp2 + 2;
                while (i2 < length && this.mSectionIndexer.getPositionForSection(i2) == positionForSection2) {
                    i2++;
                    i5++;
                }
                f5 = i6 / f7;
                f6 = i5 / f7;
                float f8 = itemCount != 0 ? Float.MAX_VALUE : 0.125f / itemCount;
                if (i6 == iClamp2 || f - f5 >= f8) {
                    positionForSection += (int) (((f - f5) * (positionForSection2 - positionForSection)) / (f6 - f5));
                }
                iClamp = MathUtils.clamp(positionForSection, 0, itemCount - 1);
            } else {
                i = i6;
                i2 = iClamp2 + 2;
                while (i2 < length) {
                    i2++;
                    i5++;
                }
                f5 = i6 / f7;
                f6 = i5 / f7;
                if (itemCount != 0) {
                }
                if (i6 == iClamp2) {
                    positionForSection += (int) (((f - f5) * (positionForSection2 - positionForSection)) / (f6 - f5));
                    iClamp = MathUtils.clamp(positionForSection, 0, itemCount - 1);
                }
            }
        }
        RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(iClamp, 0);
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            ((StaggeredGridLayoutManager) layoutManager).scrollToPositionWithOffset(iClamp, 0, true);
        }
        onScroll(this.mRecyclerView.findFirstVisibleItemPosition(), this.mRecyclerView.getChildCount(), getItemCount(this.mRecyclerView));
        this.mCurrentSection = i;
        boolean zTransitionPreviewLayout = transitionPreviewLayout(i, f4);
        Log.d(TAG, "scrollTo() called transitionPreviewLayout() sectionIndex =" + i + ", position = " + f);
        boolean z = this.mShowingPreview;
        if (!z && zTransitionPreviewLayout) {
            transitionToDragging();
        } else {
            if (!z || zTransitionPreviewLayout) {
                return;
            }
            transitionToVisible();
        }
    }

    private boolean transitionPreviewLayout(int i, float f) {
        TextView textView;
        TextView textView2;
        boolean zIsEmpty;
        Object obj;
        Object[] objArr = this.mSections;
        String string = (objArr == null || i < 0 || i >= objArr.length || (obj = objArr[i]) == null) ? null : obj.toString();
        Rect rect = this.mTempBounds;
        View view = this.mPreviewImage;
        if (this.mShowingPrimary) {
            textView = this.mPrimaryText;
            textView2 = this.mSecondaryText;
        } else {
            textView = this.mSecondaryText;
            textView2 = this.mPrimaryText;
        }
        textView2.setText(string);
        measurePreview(textView2, rect);
        applyLayout(textView2, rect);
        int i2 = this.mState;
        if (i2 != 1) {
            if (i2 == 2 && textView.getText().equals(string) && textView.getAlpha() != 0.0f) {
                zIsEmpty = TextUtils.isEmpty(string);
            }
            return !zIsEmpty;
        }
        textView.setText("");
        AnimatorSet animatorSet = this.mPreviewAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        if (!textView.getText().equals("")) {
            if (f > MIN_FAST_VIBRATE_VELOCITY) {
                this.mRecyclerView.performHapticFeedback(this.mFastVibrateIndex);
            } else {
                this.mRecyclerView.performHapticFeedback(this.mNormalVibrateIndex);
            }
        }
        Animator duration = animateAlpha(textView2, 1.0f).setDuration(0L);
        Animator duration2 = animateAlpha(textView, 0.0f).setDuration(0L);
        duration2.addListener(this.mSwitchPrimaryListener);
        rect.left -= view.getPaddingLeft();
        rect.top -= view.getPaddingTop();
        rect.right = view.getPaddingRight() + rect.right;
        rect.bottom = view.getPaddingBottom() + rect.bottom;
        Animator animatorAnimateBounds = animateBounds(view, rect);
        animatorAnimateBounds.setDuration(100L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.mPreviewAnimation = animatorSet2;
        AnimatorSet.Builder builderWith = animatorSet2.play(duration2).with(duration);
        builderWith.with(animatorAnimateBounds);
        int width = (view.getWidth() - view.getPaddingLeft()) - view.getPaddingRight();
        int width2 = textView2.getWidth();
        if (width2 > width) {
            textView2.setScaleX(width / width2);
            builderWith.with(animateScaleX(textView2, 1.0f).setDuration(100L));
        } else {
            textView2.setScaleX(1.0f);
        }
        int width3 = textView.getWidth();
        if (width3 > width2) {
            builderWith.with(animateScaleX(textView, width2 / width3).setDuration(100L));
        }
        this.mPreviewAnimation.setInterpolator(SeslAnimationUtils.SINE_IN_OUT_70);
        this.mPreviewAnimation.start();
        zIsEmpty = TextUtils.isEmpty(string);
        return !zIsEmpty;
    }
}
