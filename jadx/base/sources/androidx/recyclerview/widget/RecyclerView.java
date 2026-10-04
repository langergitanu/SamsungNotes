package androidx.recyclerview.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.Display;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import android.widget.SectionIndexer;
import androidx.annotation.CallSuper;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.C0419R;
import androidx.appcompat.animation.SeslAnimationUtils;
import androidx.appcompat.animation.SeslRecoilAnimator;
import androidx.appcompat.graphics.drawable.SeslRecoilDrawable;
import androidx.appcompat.util.SeslMisc;
import androidx.appcompat.util.SeslSubheaderRoundedCorner;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import androidx.core.os.TraceCompat;
import androidx.core.util.Preconditions;
import androidx.core.util.SeslFadingEdgeHelper;
import androidx.core.util.SeslFadingEdgeHelperImpl;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.ScrollingView;
import androidx.core.view.SeslPointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.EdgeEffectCompat;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.RunnableC2502b;
import androidx.core.widget.RunnableC2503c;
import androidx.core.widget.RunnableC2504d;
import androidx.core.widget.SeslGoToTopConfig;
import androidx.core.widget.SeslGoToTopController;
import androidx.core.widget.SeslGoToTopControllerFactory;
import androidx.core.widget.SeslGoToTopImageView;
import androidx.core.widget.SeslScrollable;
import androidx.customview.poolingcontainer.PoolingContainer;
import androidx.customview.view.AbsSavedState;
import androidx.glance.AbstractC2821a;
import androidx.recyclerview.C3728R;
import androidx.recyclerview.widget.AdapterHelper;
import androidx.recyclerview.widget.ChildHelper;
import androidx.recyclerview.widget.GapWorker;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import androidx.recyclerview.widget.ViewBoundsCheck;
import androidx.recyclerview.widget.ViewInfoStore;
import androidx.reflect.p112os.SeslSystemPropertiesReflector;
import androidx.reflect.provider.SeslSettingsReflector;
import androidx.reflect.view.SeslPointerIconReflector;
import androidx.reflect.view.SeslViewReflector;
import androidx.reflect.widget.SeslOverScrollerReflector;
import androidx.reflect.widget.SeslTextViewReflector;
import com.microsoft.identity.common.java.WarningType;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.samsung.android.sesl.visualeffect.utils.DeviceSettingsUtil;
import com.samsung.android.support.senl.addons.base.binding.binder.AbsExecuteBinding;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import opennlp.tools.parser.Parse;
import p035H2.RunnableC0116a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
public class RecyclerView extends ViewGroup implements ScrollingView, NestedScrollingChild2, NestedScrollingChild3, SeslScrollable {
    static final int DEFAULT_ORIENTATION = 1;
    static final boolean DISPATCH_TEMP_DETACH = false;
    private static final float FLING_DESTRETCH_FACTOR = 4.0f;
    private static final int FOCUS_MOVE_DOWN = 1;
    private static final int FOCUS_MOVE_FULL_DOWN = 3;
    private static final int FOCUS_MOVE_FULL_UP = 2;
    private static final int FOCUS_MOVE_UP = 0;
    static final long FOREVER_NS = Long.MAX_VALUE;
    private static final float FRAME_LATENCY_LIMIT = 16.66f;
    public static final int HORIZONTAL = 0;
    private static final int HOVERSCROLL_DELAY = 0;
    private static final int HOVERSCROLL_DOWN = 2;
    private static final int HOVERSCROLL_HEIGHT_BOTTOM_DP = 25;
    private static final int HOVERSCROLL_HEIGHT_TOP_DP = 25;
    private static final int HOVERSCROLL_UP = 1;
    private static final float INFLEXION = 0.35f;
    private static final int INVALID_POINTER = -1;
    public static final int INVALID_TYPE = -1;
    private static final String KEY_DEBUG_AVAIL_RECT = "sesl.debug.recyclerview.avail_rect";
    private static final int LASTITEM_ADD_REMOVE_DURATION = 330;
    private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
    private static final Interpolator LINEAR_INTERPOLATOR;
    static final int MAX_SCROLL_DURATION = 2000;
    private static final int MOTION_EVENT_ACTION_PEN_DOWN = 211;
    private static final int MOTION_EVENT_ACTION_PEN_MOVE = 213;
    private static final int MOTION_EVENT_ACTION_PEN_UP = 212;
    private static final int MSG_HOVERSCROLL_MOVE = 0;
    private static final String NAVIGATION_MODE = "navigation_mode";
    private static final int NAV_BAR_MODE_3BUTTON = 0;
    private static final int NAV_BAR_MODE_GESTURAL = 2;
    public static final long NO_ID = -1;
    public static final int NO_POSITION = -1;
    private static final int RECTANGLE_ON_SCREEN_REQUEST_SOURCE_INPUT_FOCUS = 3;
    private static final float SCROLL_FRICTION = 0.015f;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final int STATISTICS_MAX_COUNT = 5;
    static final String TAG = "SeslRecyclerView";
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    static final String TRACE_BIND_VIEW_TAG = "RV OnBindView";
    static final String TRACE_CREATE_VIEW_TAG = "RV CreateView";
    private static final String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
    static final String TRACE_NESTED_PREFETCH_TAG = "RV Nested Prefetch";
    private static final String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
    private static final String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
    static final String TRACE_PREFETCH_TAG = "RV Prefetch";
    static final String TRACE_SCROLL_TAG = "RV Scroll";
    public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
    static final boolean VERBOSE_TRACING = false;
    public static final int VERTICAL = 1;
    static boolean sDebugAssertionsEnabled = false;
    static final StretchEdgeEffectFactory sDefaultEdgeEffectFactory;
    static final Interpolator sQuinticInterpolator;
    static boolean sVerboseLoggingEnabled = false;
    private final int ON_ABSORB_VELOCITY;
    RecyclerViewAccessibilityDelegate mAccessibilityDelegate;
    private final AccessibilityManager mAccessibilityManager;
    Adapter mAdapter;
    AdapterHelper mAdapterHelper;
    boolean mAdapterUpdateDuringMeasure;
    private Animator.AnimatorListener mAnimListener;
    private int mAnimatedBlackTop;

    @Nullable
    private Rect mAvailableBounds;
    int mBlackTop;
    private EdgeEffect mBottomGlow;
    Rect mChildBound;
    private ChildDrawingOrderCallback mChildDrawingOrderCallback;
    ChildHelper mChildHelper;
    boolean mClipToPadding;
    private View mCloseChildByBottom;
    private View mCloseChildByTop;
    private int mCloseChildPositionByBottom;
    private int mCloseChildPositionByTop;
    private Context mContext;
    boolean mDataSetHasChangedAfterLayout;
    private boolean mDebugDrawAvailRect;
    boolean mDispatchItemsChangedEvent;
    private int mDispatchScrollCounter;
    private int mDistanceFromCloseChildBottom;
    private int mDistanceFromCloseChildTop;
    private boolean mDrawHorizontalPadding;
    private boolean mDrawLastRoundedCorner;
    private boolean mDrawRect;
    private boolean mDrawReverse;
    private int mEatenAccessibilityChangeFlags;
    private boolean mEdgeEffectByDragging;

    @NonNull
    private EdgeEffectFactory mEdgeEffectFactory;
    boolean mEnableFastScroller;
    private int mExtraPaddingInBottomHoverArea;
    private int mExtraPaddingInTopHoverArea;
    private final SeslFadingEdgeHelper mFadingEdgeHelper;
    private SeslRecyclerViewFastScroller mFastScroller;
    private SeslFastScrollerEventListener mFastScrollerEventListener;

    @VisibleForTesting
    boolean mFirstLayoutComplete;
    private float mFrameLatency;
    GapWorker mGapWorker;
    private SeslGoToTopController mGoToTopController;
    private final Runnable mGoToTopEdgeEffectRunnable;
    private final SeslGoToTopController.Host mGoToTopHost;
    boolean mHasFixedSize;
    private boolean mHasNestedScrollRange;
    private boolean mHoverAreaEnter;
    private int mHoverBottomAreaHeight;
    private int mHoverDefaultBottomAreaHeight;
    private int mHoverDefaultTopAreaHeight;
    private Handler mHoverHandler;
    private long mHoverRecognitionCurrentTime;
    private long mHoverRecognitionDurationTime;
    private long mHoverRecognitionStartTime;
    int[] mHoverScrollArrows;
    private int mHoverScrollDirection;
    private boolean mHoverScrollEnable;
    private int mHoverScrollSpeed;
    private long mHoverScrollStartTime;
    private boolean mHoverScrollStateChanged;
    private int mHoverScrollStateForListener;
    private long mHoverScrollTimeInterval;
    private int mHoverTopAreaHeight;
    private boolean mIgnoreMotionEventTillDown;
    private IndexTip mIndexTip;
    private boolean mIndexTipEnabled;
    private int mInitialTopOffsetOfScreen;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private int mInterceptRequestLayoutDepth;
    private OnItemTouchListener mInterceptingOnItemTouchListener;
    private boolean mIsActionScrollFromMouse;
    private boolean mIsArrowKeyPressed;
    boolean mIsAttached;
    private boolean mIsCloseChildSetted;
    private boolean mIsCtrlKeyPressed;
    private boolean mIsCtrlMultiSelection;
    private boolean mIsEdgeEffectEnabled;
    private boolean mIsEnabledPaddingInHoverScroll;
    private boolean mIsFirstMultiSelectionMove;
    private boolean mIsFirstPenMoveEvent;
    private boolean mIsHoverOverscrolled;
    private boolean mIsLongPressMultiSelection;
    private boolean mIsNeedCheckLatency;
    private boolean mIsNeedPenSelectIconSet;
    private boolean mIsNeedPenSelection;
    private boolean mIsPenButtonPressed;
    private boolean mIsPenDragBlockEnabled;
    private boolean mIsPenHovered;
    private boolean mIsPenPressed;
    private boolean mIsPenSelectPointerSetted;
    private boolean mIsPenSelectionEnabled;
    private boolean mIsRecoilEnabled;
    private final boolean mIsRecoilSupported;
    private boolean mIsSendHoverScrollState;
    private boolean mIsSetOnlyAddAnim;
    private boolean mIsSetOnlyRemoveAnim;
    private boolean mIsSkipMoveEvent;
    ItemAnimator mItemAnimator;
    private SeslRecoilAnimator.Holder mItemAnimatorHolder;
    private ItemAnimator.ItemAnimatorListener mItemAnimatorListener;
    private Runnable mItemAnimatorRunner;
    private ItemBackgroundHolder mItemBackgroundHolder;
    final ArrayList<ItemDecoration> mItemDecorations;
    boolean mItemsAddedOrRemoved;
    boolean mItemsChanged;
    private int mLastAutoMeasureNonExactMeasuredHeight;
    private int mLastAutoMeasureNonExactMeasuredWidth;
    private boolean mLastAutoMeasureSkippedDueToExact;
    private int mLastBlackTop;
    private ValueAnimator mLastItemAddRemoveAnim;
    private int mLastItemAnimTop;
    private int mLastTouchX;
    private int mLastTouchY;

    @VisibleForTesting
    LayoutManager mLayout;
    private int mLayoutOrScrollCounter;
    boolean mLayoutSuppressed;
    boolean mLayoutWasDefered;
    private EdgeEffect mLeftGlow;
    Rect mListPadding;
    private SeslLongPressMultiSelectionListener mLongPressMultiSelectionListener;
    private int mMaxFlingVelocity;
    private int mMinFlingVelocity;
    private final int[] mMinMaxLayoutPositions;
    private final int mMotionEventUpPendingFlag;
    private int mNaviBarTop;
    private boolean mNeedsHoverScroll;
    private final int[] mNestedOffsets;
    private int mNestedScrollRange;
    private boolean mNewTextViewHoverState;
    private final RecyclerViewDataObserver mObserver;
    private int mOldHoverScrollDirection;
    private boolean mOldTextViewHoverState;
    private List<OnChildAttachStateChangeListener> mOnChildAttachStateListeners;
    private OnFlingListener mOnFlingListener;
    private SeslOnGoToTopClickListener mOnGoToTopClickListener;
    private List<SeslScrollable.SeslOnGoToTopClickListener> mOnGoToTopClickListeners;
    private final ArrayList<OnItemTouchListener> mOnItemTouchListeners;
    private SeslOnMultiSelectedListener mOnMultiSelectedListener;
    private int mPagingTouchSlop;
    private int mPenDistanceFromTrackedChildTop;
    private int mPenDragBlockBottom;
    private Drawable mPenDragBlockImage;
    private int mPenDragBlockLeft;
    private Rect mPenDragBlockRect;
    private int mPenDragBlockRight;
    private int mPenDragBlockTop;
    private int mPenDragEndX;
    private int mPenDragEndY;
    private long mPenDragScrollTimeInterval;
    private ArrayList<Integer> mPenDragSelectedItemArray;
    private int mPenDragSelectedViewPosition;
    private int mPenDragStartX;
    private int mPenDragStartY;
    private View mPenTrackedChild;
    private int mPenTrackedChildPosition;

    @VisibleForTesting
    final List<ViewHolder> mPendingAccessibilityImportanceChange;
    SavedState mPendingSavedState;
    private final float mPhysicalCoef;
    private float mPointerIconRotation;
    boolean mPostedAnimatorRunner;
    GapWorker.LayoutPrefetchRegistryImpl mPrefetchRegistry;
    private boolean mPreserveFocusAfterLayout;
    private boolean mPreventFirstGlow;

    @ColorInt
    private int mRectColor;
    private Paint mRectPaint;
    final Recycler mRecycler;
    RecyclerListener mRecyclerListener;
    final List<RecyclerListener> mRecyclerListeners;
    private final int[] mRecyclerViewOffsets;
    private int mRemainNestedScrollRange;
    final int[] mReusableIntPair;
    private EdgeEffect mRightGlow;
    private View mRootViewCheckForDialog;
    private SeslSubheaderRoundedCorner mRoundedCorner;
    private float mScaledHorizontalScrollFactor;
    private float mScaledVerticalScrollFactor;
    private int mScrollBarBottomOffset;
    private SeslScrollable.SeslScrollBarOffsetChangedListener mScrollBarOffsetListener;
    private int mScrollBarTopOffset;
    private final SeslFadingEdgeHelper.ScrollInfoProvider mScrollInfoProvider;
    private OnScrollListener mScrollListener;
    private List<OnScrollListener> mScrollListeners;
    private final int[] mScrollOffset;
    private int mScrollPointerId;
    private int mScrollState;
    private int mScrollbarBottomPadding;
    private int mScrollbarTopPadding;
    private NestedScrollingChildHelper mScrollingChildHelper;
    Drawable mSelector;
    Rect mSelectorRect;
    int mSeslBottomBarHeight;
    private boolean mSeslIsNested;
    private int mSeslOverlayFeatureHeight;
    final State mState;
    final Rect mTempRect;
    private final Rect mTempRect2;
    final RectF mTempRectF;
    private EdgeEffect mTopGlow;
    private int mTouchSlop;
    private int mTouchSlop2;
    final Runnable mUpdateChildViewsRunnable;
    private boolean mUsePagingTouchSlopForStylus;
    private VelocityTracker mVelocityTracker;
    final ViewFlinger mViewFlinger;
    private final ViewInfoStore.ProcessCallback mViewInfoProcessCallback;
    final ViewInfoStore mViewInfoStore;
    private final int[] mWindowOffsets;
    private static final int[] NESTED_SCROLLING_ATTRS = {R.attr.nestedScrollingEnabled};
    private static final float DECELERATION_RATE = (float) (Math.log(0.78d) / Math.log(0.9d));
    static final boolean FORCE_INVALIDATE_DISPLAY_LIST = false;
    static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC = true;
    static final boolean POST_UPDATES_ON_ANIMATION = true;
    static final boolean ALLOW_THREAD_GAP_WORK = true;
    private static final boolean FORCE_ABS_FOCUS_SEARCH_DIRECTION = false;
    private static final boolean IGNORE_DETACHED_FOCUSED_CHILD = false;
    private static float HOVERSCROLL_SPEED = 10.0f;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class Adapter<VH extends ViewHolder> {
        private final AdapterDataObservable mObservable = new AdapterDataObservable();
        private boolean mHasStableIds = false;
        private StateRestorationPolicy mStateRestorationPolicy = StateRestorationPolicy.ALLOW;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public enum StateRestorationPolicy {
            ALLOW,
            PREVENT_WHEN_EMPTY,
            PREVENT
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void bindViewHolder(@NonNull VH vh, int i) {
            boolean z = vh.mBindingAdapter == null;
            if (z) {
                vh.mPosition = i;
                if (hasStableIds()) {
                    vh.mItemId = getItemId(i);
                }
                vh.setFlags(1, 519);
                TraceCompat.beginSection(RecyclerView.TRACE_BIND_VIEW_TAG);
            }
            vh.mBindingAdapter = this;
            if (RecyclerView.sDebugAssertionsEnabled) {
                if (vh.itemView.getParent() == null && ViewCompat.isAttachedToWindow(vh.itemView) != vh.isTmpDetached()) {
                    throw new IllegalStateException("Temp-detached state out of sync with reality. holder.isTmpDetached(): " + vh.isTmpDetached() + ", attached to window: " + ViewCompat.isAttachedToWindow(vh.itemView) + ", holder: " + vh);
                }
                if (vh.itemView.getParent() == null && ViewCompat.isAttachedToWindow(vh.itemView)) {
                    throw new IllegalStateException("Attempting to bind attached holder with no parent (AKA temp detached): " + vh);
                }
            }
            onBindViewHolder(vh, i, vh.getUnmodifiedPayloads());
            if (z) {
                vh.clearPayload();
                ViewGroup.LayoutParams layoutParams = vh.itemView.getLayoutParams();
                if (layoutParams instanceof LayoutParams) {
                    ((LayoutParams) layoutParams).mInsetsDirty = true;
                }
                TraceCompat.endSection();
            }
        }

        public boolean canRestoreState() {
            int iOrdinal = this.mStateRestorationPolicy.ordinal();
            return iOrdinal != 1 ? iOrdinal != 2 : getItemCount() > 0;
        }

        @NonNull
        public final VH createViewHolder(@NonNull ViewGroup viewGroup, int i) {
            try {
                TraceCompat.beginSection(RecyclerView.TRACE_CREATE_VIEW_TAG);
                VH vh = (VH) onCreateViewHolder(viewGroup, i);
                if (vh.itemView.getParent() != null) {
                    throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                }
                vh.mItemViewType = i;
                return vh;
            } finally {
                TraceCompat.endSection();
            }
        }

        public int findRelativeAdapterPositionIn(@NonNull Adapter<? extends ViewHolder> adapter, @NonNull ViewHolder viewHolder, int i) {
            if (adapter == this) {
                return i;
            }
            return -1;
        }

        public abstract int getItemCount();

        public long getItemId(int i) {
            return -1L;
        }

        public int getItemViewType(int i) {
            return 0;
        }

        @NonNull
        public final StateRestorationPolicy getStateRestorationPolicy() {
            return this.mStateRestorationPolicy;
        }

        public final boolean hasObservers() {
            return this.mObservable.hasObservers();
        }

        public final boolean hasStableIds() {
            return this.mHasStableIds;
        }

        public final void notifyDataSetChanged() {
            this.mObservable.notifyChanged();
        }

        public final void notifyItemChanged(int i) {
            this.mObservable.notifyItemRangeChanged(i, 1);
        }

        public final void notifyItemInserted(int i) {
            this.mObservable.notifyItemRangeInserted(i, 1);
        }

        public final void notifyItemMoved(int i, int i2) {
            this.mObservable.notifyItemMoved(i, i2);
        }

        public final void notifyItemRangeChanged(int i, int i2) {
            this.mObservable.notifyItemRangeChanged(i, i2);
        }

        public final void notifyItemRangeInserted(int i, int i2) {
            this.mObservable.notifyItemRangeInserted(i, i2);
        }

        public final void notifyItemRangeRemoved(int i, int i2) {
            this.mObservable.notifyItemRangeRemoved(i, i2);
        }

        public final void notifyItemRemoved(int i) {
            this.mObservable.notifyItemRangeRemoved(i, 1);
        }

        public abstract void onBindViewHolder(@NonNull VH vh, int i);

        public void onBindViewHolder(@NonNull VH vh, int i, @NonNull List<Object> list) {
            onBindViewHolder(vh, i);
        }

        @NonNull
        public abstract VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i);

        public boolean onFailedToRecycleView(@NonNull VH vh) {
            return false;
        }

        public void registerAdapterDataObserver(@NonNull AdapterDataObserver adapterDataObserver) {
            this.mObservable.registerObserver(adapterDataObserver);
        }

        public int seslGetAccessibilityItemCount() {
            return getItemCount();
        }

        public boolean seslUseCustomAccessibilityPosition() {
            return false;
        }

        public void setHasStableIds(boolean z) {
            if (hasObservers()) {
                throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            }
            this.mHasStableIds = z;
        }

        public void setStateRestorationPolicy(@NonNull StateRestorationPolicy stateRestorationPolicy) {
            this.mStateRestorationPolicy = stateRestorationPolicy;
            this.mObservable.notifyStateRestorationPolicyChanged();
        }

        public void unregisterAdapterDataObserver(@NonNull AdapterDataObserver adapterDataObserver) {
            this.mObservable.unregisterObserver(adapterDataObserver);
        }

        public final void notifyItemChanged(int i, @Nullable Object obj) {
            this.mObservable.notifyItemRangeChanged(i, 1, obj);
        }

        public final void notifyItemRangeChanged(int i, int i2, @Nullable Object obj) {
            this.mObservable.notifyItemRangeChanged(i, i2, obj);
        }

        public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        }

        public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        }

        public void onViewAttachedToWindow(@NonNull VH vh) {
        }

        public void onViewDetachedFromWindow(@NonNull VH vh) {
        }

        public void onViewRecycled(@NonNull VH vh) {
        }

        public int seslGetAccessibilityItemPosition(int i) {
            return i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class AdapterDataObservable extends Observable<AdapterDataObserver> {
        public boolean hasObservers() {
            return !((Observable) this).mObservers.isEmpty();
        }

        public void notifyChanged() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).onChanged();
            }
        }

        public void notifyItemMoved(int i, int i2) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).onItemRangeMoved(i, i2, 1);
            }
        }

        public void notifyItemRangeChanged(int i, int i2) {
            notifyItemRangeChanged(i, i2, null);
        }

        public void notifyItemRangeInserted(int i, int i2) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).onItemRangeInserted(i, i2);
            }
        }

        public void notifyItemRangeRemoved(int i, int i2) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).onItemRangeRemoved(i, i2);
            }
        }

        public void notifyStateRestorationPolicyChanged() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).onStateRestorationPolicyChanged();
            }
        }

        public void notifyItemRangeChanged(int i, int i2, @Nullable Object obj) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).onItemRangeChanged(i, i2, obj);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class AdapterDataObserver {
        public void onItemRangeChanged(int i, int i2) {
        }

        public void onItemRangeChanged(int i, int i2, @Nullable Object obj) {
            onItemRangeChanged(i, i2);
        }

        public void onChanged() {
        }

        public void onStateRestorationPolicyChanged() {
        }

        public void onItemRangeInserted(int i, int i2) {
        }

        public void onItemRangeRemoved(int i, int i2) {
        }

        public void onItemRangeMoved(int i, int i2, int i4) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ChildDrawingOrderCallback {
        int onGetChildDrawingOrder(int i, int i2);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class EdgeEffectFactory {
        public static final int DIRECTION_BOTTOM = 3;
        public static final int DIRECTION_LEFT = 0;
        public static final int DIRECTION_RIGHT = 2;
        public static final int DIRECTION_TOP = 1;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Retention(RetentionPolicy.SOURCE)
        public @interface EdgeDirection {
        }

        @NonNull
        public EdgeEffect createEdgeEffect(@NonNull RecyclerView recyclerView, int i) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class IndexTip extends View {
        private static final int ALPHA_DURATION = 150;
        private static final int CHANGE_TEXT_DELAY = 90;
        private static final int FADE_DURATION = 300;
        private static final int FONT_WEIGHT_REGULAR = 400;
        private static final int SCALE_DURATION = 200;
        private static final float SHAPE_COLOR_ALPHA_RATIO = 0.9f;
        private static final int TIMER_DURATION = 450;

        @SuppressLint({WarningType.NewApi})
        private final PathInterpolator ALPHA_INTERPOLATOR;

        @SuppressLint({WarningType.NewApi})
        private final PathInterpolator SCALE_INTERPOLATOR;
        private float mAnimatingWidth;
        private int mCenterX;
        private int mCurrentOrientation;
        private boolean mForcedHide;
        private int mHeight;
        private int mHorizontalPadding;
        private final Animator.AnimatorListener mIndexTipTimerListener;
        private boolean mIsNeedUpdate;
        private boolean mIsShowing;
        private int mMaxWidth;
        private int mMinWidth;
        private int mParentPosY;
        private String mPrevText;
        private float mPrevWidth;
        private float mRadius;
        private SectionIndexer mSectionIndexer;
        private Object[] mSections;
        private final Runnable mShapeDelayRunnable;
        private Paint mShapePaint;
        private int mStatusBarHeight;
        private String mTargetText;
        private String mText;
        private final Runnable mTextDelayRunnable;
        private StaticLayout mTextLayout;
        private StaticLayout.Builder mTextLayoutBuilder;
        private StaticLayout mTextLayoutDelay;
        private TextPaint mTextPaint;
        private ValueAnimator mTimer;
        private int mTopMargin;
        private int mVerticalPadding;
        private int mWidth;
        private ValueAnimator mWidthAnimator;

        private void calculateTextLines() {
            int i = this.mWidth;
            int i2 = ((i / 2) - this.mHorizontalPadding) * 2;
            if (i2 > 0) {
                i = i2;
            }
            String str = this.mText;
            float lineWidth = StaticLayout.Builder.obtain(str, 0, str.length(), this.mTextPaint, i).build().getLineWidth(0);
            String str2 = this.mText;
            StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(str2, 0, str2.length(), this.mTextPaint, (int) lineWidth);
            this.mTextLayoutBuilder = builderObtain;
            builderObtain.setAlignment(Layout.Alignment.ALIGN_CENTER);
            this.mTextLayout = this.mTextLayoutBuilder.setMaxLines(2).setEllipsize(TextUtils.TruncateAt.END).build();
        }

        private void changeText(boolean z) {
            if (!z) {
                this.mTargetText = this.mText;
                this.mTextLayoutDelay = this.mTextLayout;
            } else {
                this.mTargetText = this.mText;
                removeCallbacks(this.mTextDelayRunnable);
                postDelayed(this.mTextDelayRunnable, 90L);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void forcedHide() {
            this.mIsShowing = false;
            removeCallbacks(this.mShapeDelayRunnable);
            setAlpha(0.0f);
            invalidate();
        }

        private int getColorWithAlpha(int i, float f) {
            return Color.argb(Math.round(Color.alpha(i) * f), Color.red(i), Color.green(i), Color.blue(i));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void hide() {
            if (this.mIsShowing) {
                removeCallbacks(this.mShapeDelayRunnable);
                postDelayed(this.mShapeDelayRunnable, 300L);
            } else {
                forcedHide();
            }
            RecyclerView.this.mIsActionScrollFromMouse = false;
        }

        private void init() {
            this.mSectionIndexer = (SectionIndexer) RecyclerView.this.mAdapter;
            updateSections();
            Resources resources = RecyclerView.this.mContext.getResources();
            int color = SeslMisc.isLightTheme(RecyclerView.this.mContext) ? resources.getColor(C0419R.color.sesl_scrollbar_index_tip_color) : resources.getColor(C0419R.color.sesl_scrollbar_index_tip_color_dark);
            Paint paint = new Paint();
            this.mShapePaint = paint;
            paint.setStyle(Paint.Style.FILL);
            this.mShapePaint.setAntiAlias(true);
            this.mShapePaint.setColor(getColorWithAlpha(color, 0.9f));
            TextPaint textPaint = new TextPaint();
            this.mTextPaint = textPaint;
            textPaint.setAntiAlias(true);
            if (Build.VERSION.SDK_INT >= 34) {
                this.mTextPaint.setTypeface(Typeface.create(Typeface.create("sec", 0), 400, false));
            } else {
                this.mTextPaint.setTypeface(Typeface.create(RecyclerView.this.mContext.getString(C0419R.string.sesl_font_family_regular), 0));
            }
            this.mTextPaint.setTextSize(resources.getDimensionPixelSize(C3728R.dimen.sesl_index_tip_text_size));
            this.mTextPaint.setColor(resources.getColor(C0419R.color.sesl_white));
            this.mText = "";
            TextPaint textPaint2 = this.mTextPaint;
            StaticLayout staticLayoutBuild = StaticLayout.Builder.obtain("", 0, 0, textPaint2, (int) textPaint2.measureText("")).build();
            this.mTextLayout = staticLayoutBuild;
            this.mTextLayoutDelay = staticLayoutBuild;
            this.mPrevText = "";
            this.mPrevWidth = 0.0f;
            this.mAnimatingWidth = 0.0f;
            this.mHorizontalPadding = resources.getDimensionPixelSize(C3728R.dimen.sesl_index_tip_horizontal_padding);
            this.mVerticalPadding = resources.getDimensionPixelSize(C3728R.dimen.sesl_index_tip_vertical_padding);
            this.mMinWidth = resources.getDimensionPixelSize(C3728R.dimen.sesl_index_tip_min_width);
            this.mMaxWidth = resources.getDimensionPixelSize(C3728R.dimen.sesl_index_tip_max_width);
            this.mTopMargin = resources.getDimensionPixelSize(C3728R.dimen.sesl_index_tip_margin_top);
            this.mRadius = resources.getDimension(C3728R.dimen.sesl_index_tip_radius);
            this.mParentPosY = 0;
            int identifier = resources.getIdentifier("status_bar_height", AbsExecuteBinding.TYPE_DIMEN, TelemetryEventStrings.C6439Os.OS_NAME);
            if (identifier > 0) {
                this.mStatusBarHeight = RecyclerView.this.mContext.getResources().getDimensionPixelSize(identifier);
            } else {
                this.mStatusBarHeight = 0;
            }
            setAlpha(0.0f);
        }

        private void resetTimer() {
            ValueAnimator valueAnimator = this.mTimer;
            if (valueAnimator != null) {
                valueAnimator.removeAllListeners();
                this.mTimer.cancel();
            }
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 0.0f);
            this.mTimer = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setDuration(450L);
            this.mTimer.addListener(this.mIndexTipTimerListener);
            this.mTimer.start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLayout(int i, int i2, int i4, int i5, int i6, int i7) {
            layout(i, i2, i4, i5);
            int i8 = ((i4 - i) - i6) - i7;
            int i9 = this.mHorizontalPadding;
            if (i8 > i9 * 2) {
                int i10 = this.mMaxWidth;
                if (i8 < i10) {
                    i10 = i8 - (i9 * 2);
                }
                this.mWidth = i10;
            }
            this.mCenterX = Math.round(i8 / 2.0f) + i6;
            int i11 = RecyclerView.this.mContext.getResources().getConfiguration().orientation;
            this.mCurrentOrientation = i11;
            if (i11 == 2) {
                this.mIsNeedUpdate = false;
            }
            hide();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTopMargin(int i) {
            this.mTopMargin = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void show(int i, int i2) {
            if (i == 1 && RecyclerView.this.mRemainNestedScrollRange != 0 && i2 >= 0) {
                RecyclerView.this.adjustNestedScrollRange();
                return;
            }
            if (i2 == 0 || this.mIsShowing || !RecyclerView.this.canScrollUp() || this.mForcedHide) {
                return;
            }
            startAnimation();
            this.mIsShowing = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void showWithTimer(int i, int i2) {
            show(i, i2);
            resetTimer();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void startAnimation() {
            ObjectAnimator objectAnimatorOfFloat = this.mIsShowing ? ObjectAnimator.ofFloat(RecyclerView.this.mIndexTip, "alpha", RecyclerView.this.mIndexTip.getAlpha(), 0.0f) : ObjectAnimator.ofFloat(RecyclerView.this.mIndexTip, "alpha", RecyclerView.this.mIndexTip.getAlpha(), 1.0f);
            objectAnimatorOfFloat.setDuration(150L);
            objectAnimatorOfFloat.setInterpolator(this.ALPHA_INTERPOLATOR);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(objectAnimatorOfFloat);
            animatorSet.start();
        }

        private void startWidthAnimation(float f) {
            ValueAnimator valueAnimator = this.mWidthAnimator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.mAnimatingWidth, f);
            this.mWidthAnimator = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setDuration(200L);
            this.mWidthAnimator.setInterpolator(this.SCALE_INTERPOLATOR);
            this.mWidthAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.recyclerview.widget.RecyclerView.IndexTip.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    IndexTip.this.mAnimatingWidth = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                    IndexTip.this.invalidate();
                }
            });
            this.mWidthAnimator.start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateSections() {
            SectionIndexer sectionIndexer = this.mSectionIndexer;
            if (sectionIndexer == null) {
                return;
            }
            Object[] sections = sectionIndexer.getSections();
            this.mSections = sections;
            if (sections == null) {
                throw new IllegalStateException("Section is null. This array, or its contents should be non-null");
            }
            hide();
        }

        private void updateText() {
            Object obj;
            this.mText = "";
            int iFindFirstVisibleItemPosition = RecyclerView.this.findFirstVisibleItemPosition();
            if (iFindFirstVisibleItemPosition == -1) {
                Log.e(RecyclerView.TAG, "First visible item was null.");
                return;
            }
            int sectionForPosition = this.mSectionIndexer.getSectionForPosition(iFindFirstVisibleItemPosition);
            if (sectionForPosition >= 0) {
                Object[] objArr = this.mSections;
                if (sectionForPosition >= objArr.length || (obj = objArr[sectionForPosition]) == null) {
                    return;
                }
                String string = obj.toString();
                this.mText = string;
                int length = string.length();
                TextPaint textPaint = this.mTextPaint;
                StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(string, 0, length, textPaint, (int) textPaint.measureText(this.mText));
                this.mTextLayoutBuilder = builderObtain;
                this.mTextLayout = builderObtain.build();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:41:0x00c2  */
        @Override // android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onDraw(Canvas canvas) {
            int i;
            super.onDraw(canvas);
            updateText();
            if (!this.mText.equals("")) {
                this.mForcedHide = false;
            } else {
                if (this.mPrevText.equals("")) {
                    return;
                }
                if (!this.mForcedHide && this.mIsShowing) {
                    startAnimation();
                    this.mIsShowing = false;
                    this.mForcedHide = true;
                }
                this.mText = this.mPrevText;
            }
            float fMeasureText = (this.mTextPaint.measureText(this.mText) / 2.0f) + this.mHorizontalPadding;
            int i2 = this.mMinWidth;
            if (fMeasureText < i2 / 2.0f) {
                fMeasureText = i2 / 2.0f;
            } else {
                int i4 = this.mWidth;
                if (i4 > 0 && fMeasureText > i4 / 2.0f) {
                    calculateTextLines();
                    fMeasureText = (this.mTextLayout.getLineWidth(0) / 2.0f) + this.mHorizontalPadding;
                }
            }
            if (this.mTextLayoutDelay.getText().equals("")) {
                this.mTargetText = this.mText;
                this.mTextLayoutDelay = this.mTextLayout;
            }
            int i5 = this.mCenterX;
            if (i5 < fMeasureText) {
                fMeasureText = i5;
            }
            float f = fMeasureText;
            float f4 = this.mPrevWidth;
            if (f4 > 0.0f && f4 != f) {
                startWidthAnimation(f);
            }
            if (this.mAnimatingWidth == 0.0f) {
                this.mAnimatingWidth = f;
            }
            StaticLayout staticLayout = this.mTextLayout;
            this.mHeight = (this.mVerticalPadding * 2) + (staticLayout.getLineBottom(staticLayout.getLineCount() - 1) - this.mTextLayout.getLineTop(0));
            if (this.mIsNeedUpdate) {
                int recyclerViewScreenLocationY = RecyclerView.this.getRecyclerViewScreenLocationY();
                this.mParentPosY = recyclerViewScreenLocationY;
                int i6 = this.mStatusBarHeight;
                i = recyclerViewScreenLocationY < i6 ? i6 - recyclerViewScreenLocationY : 0;
            }
            canvas.save();
            int i7 = this.mCenterX;
            float f5 = this.mAnimatingWidth;
            float f6 = this.mTopMargin + this.mHeight + i;
            float f7 = this.mRadius;
            canvas.drawRoundRect(i7 - f5, r4 + i, f5 + i7, f6, f7, f7, this.mShapePaint);
            canvas.translate(this.mCenterX - (this.mTextLayoutDelay.getLineWidth(0) / 2.0f), this.mTextLayoutDelay.getLineTop(0) + this.mTopMargin + this.mVerticalPadding);
            this.mTextLayoutDelay.draw(canvas);
            canvas.restore();
            if (!this.mText.equals(this.mTargetText)) {
                if (this.mText.length() > this.mTargetText.length()) {
                    changeText(true);
                } else {
                    changeText(false);
                }
            }
            if (this.mText.equals(this.mPrevText)) {
                return;
            }
            this.mPrevText = this.mText;
            this.mPrevWidth = f;
        }

        private IndexTip(Context context) {
            super(context);
            this.mIsNeedUpdate = false;
            this.mIsShowing = false;
            this.mForcedHide = false;
            this.mTimer = null;
            this.mIndexTipTimerListener = new Animator.AnimatorListener() { // from class: androidx.recyclerview.widget.RecyclerView.IndexTip.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(@NonNull Animator animator) {
                    IndexTip.this.hide();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(@NonNull Animator animator) {
                    IndexTip.this.hide();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(@NonNull Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(@NonNull Animator animator) {
                }
            };
            this.ALPHA_INTERPOLATOR = new PathInterpolator(0.0f, 0.0f, 1.0f, 1.0f);
            this.SCALE_INTERPOLATOR = new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f);
            this.mTextDelayRunnable = new Runnable() { // from class: androidx.recyclerview.widget.RecyclerView.IndexTip.3
                @Override // java.lang.Runnable
                public void run() {
                    if (RecyclerView.this.mIndexTip != null) {
                        IndexTip indexTip = IndexTip.this;
                        indexTip.mTextLayoutDelay = indexTip.mTextLayout;
                        IndexTip.this.invalidate();
                    }
                }
            };
            this.mShapeDelayRunnable = new Runnable() { // from class: androidx.recyclerview.widget.RecyclerView.IndexTip.4
                @Override // java.lang.Runnable
                public void run() {
                    if (RecyclerView.this.mIndexTip == null || !IndexTip.this.mIsShowing) {
                        return;
                    }
                    IndexTip.this.startAnimation();
                    IndexTip.this.mIsShowing = false;
                }
            };
            init();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class ItemAnimator {
        public static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        public static final int FLAG_CHANGED = 2;
        public static final int FLAG_INVALIDATED = 4;
        public static final int FLAG_MOVED = 2048;
        public static final int FLAG_REMOVED = 8;
        private ItemAnimatorListener mListener = null;
        private ArrayList<ItemAnimatorFinishedListener> mFinishedListeners = new ArrayList<>();
        private View mHostView = null;
        private long mAddDuration = 120;
        private long mRemoveDuration = 120;
        private long mMoveDuration = 250;
        private long mChangeDuration = 250;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Retention(RetentionPolicy.SOURCE)
        public @interface AdapterChanges {
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public interface ItemAnimatorFinishedListener {
            void onAnimationsFinished();
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public interface ItemAnimatorListener {
            void onAnimationFinished(@NonNull ViewHolder viewHolder);
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class ItemHolderInfo {
            public int bottom;
            public int changeFlags;
            public int left;
            public int right;
            public int top;

            @NonNull
            public ItemHolderInfo setFrom(@NonNull ViewHolder viewHolder) {
                return setFrom(viewHolder, 0);
            }

            @NonNull
            public ItemHolderInfo setFrom(@NonNull ViewHolder viewHolder, int i) {
                View view = viewHolder.itemView;
                this.left = view.getLeft();
                this.top = view.getTop();
                this.right = view.getRight();
                this.bottom = view.getBottom();
                return this;
            }
        }

        public static int buildAdapterChangeFlagsForAnimations(ViewHolder viewHolder) {
            int i = viewHolder.mFlags;
            int i2 = i & 14;
            if (viewHolder.isInvalid()) {
                return 4;
            }
            if ((i & 4) == 0) {
                int oldPosition = viewHolder.getOldPosition();
                int absoluteAdapterPosition = viewHolder.getAbsoluteAdapterPosition();
                if (oldPosition != -1 && absoluteAdapterPosition != -1 && oldPosition != absoluteAdapterPosition) {
                    return i2 | 2048;
                }
            }
            return i2;
        }

        public abstract boolean animateAppearance(@NonNull ViewHolder viewHolder, @Nullable ItemHolderInfo itemHolderInfo, @NonNull ItemHolderInfo itemHolderInfo2);

        public abstract boolean animateChange(@NonNull ViewHolder viewHolder, @NonNull ViewHolder viewHolder2, @NonNull ItemHolderInfo itemHolderInfo, @NonNull ItemHolderInfo itemHolderInfo2);

        public abstract boolean animateDisappearance(@NonNull ViewHolder viewHolder, @NonNull ItemHolderInfo itemHolderInfo, @Nullable ItemHolderInfo itemHolderInfo2);

        public abstract boolean animatePersistence(@NonNull ViewHolder viewHolder, @NonNull ItemHolderInfo itemHolderInfo, @NonNull ItemHolderInfo itemHolderInfo2);

        public boolean canReuseUpdatedViewHolder(@NonNull ViewHolder viewHolder) {
            return true;
        }

        public final void dispatchAnimationFinished(@NonNull ViewHolder viewHolder) {
            onAnimationFinished(viewHolder);
            ItemAnimatorListener itemAnimatorListener = this.mListener;
            if (itemAnimatorListener != null) {
                itemAnimatorListener.onAnimationFinished(viewHolder);
            }
        }

        public final void dispatchAnimationStarted(@NonNull ViewHolder viewHolder) {
            onAnimationStarted(viewHolder);
        }

        public final void dispatchAnimationsFinished() {
            int size = this.mFinishedListeners.size();
            for (int i = 0; i < size; i++) {
                this.mFinishedListeners.get(i).onAnimationsFinished();
            }
            this.mFinishedListeners.clear();
        }

        public abstract void endAnimation(@NonNull ViewHolder viewHolder);

        public abstract void endAnimations();

        public long getAddDuration() {
            return this.mAddDuration;
        }

        public long getChangeDuration() {
            return this.mChangeDuration;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public View getHostView() {
            return this.mHostView;
        }

        public long getMoveDuration() {
            return this.mMoveDuration;
        }

        public long getRemoveDuration() {
            return this.mRemoveDuration;
        }

        public abstract boolean isRunning();

        public final boolean isRunning(@Nullable ItemAnimatorFinishedListener itemAnimatorFinishedListener) {
            boolean zIsRunning = isRunning();
            if (itemAnimatorFinishedListener != null) {
                if (!zIsRunning) {
                    itemAnimatorFinishedListener.onAnimationsFinished();
                    return zIsRunning;
                }
                this.mFinishedListeners.add(itemAnimatorFinishedListener);
            }
            return zIsRunning;
        }

        @NonNull
        public ItemHolderInfo obtainHolderInfo() {
            return new ItemHolderInfo();
        }

        @NonNull
        public ItemHolderInfo recordPostLayoutInformation(@NonNull State state, @NonNull ViewHolder viewHolder) {
            return obtainHolderInfo().setFrom(viewHolder);
        }

        @NonNull
        public ItemHolderInfo recordPreLayoutInformation(@NonNull State state, @NonNull ViewHolder viewHolder, int i, @NonNull List<Object> list) {
            return obtainHolderInfo().setFrom(viewHolder);
        }

        public abstract void runPendingAnimations();

        public void setAddDuration(long j) {
            this.mAddDuration = j;
        }

        public void setChangeDuration(long j) {
            this.mChangeDuration = j;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void setHostView(View view) {
            this.mHostView = view;
        }

        public void setListener(ItemAnimatorListener itemAnimatorListener) {
            this.mListener = itemAnimatorListener;
        }

        public void setMoveDuration(long j) {
            this.mMoveDuration = j;
        }

        public void setRemoveDuration(long j) {
            this.mRemoveDuration = j;
        }

        public boolean canReuseUpdatedViewHolder(@NonNull ViewHolder viewHolder, @NonNull List<Object> list) {
            return canReuseUpdatedViewHolder(viewHolder);
        }

        public void onAnimationFinished(@NonNull ViewHolder viewHolder) {
        }

        public void onAnimationStarted(@NonNull ViewHolder viewHolder) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ItemAnimatorRestoreListener implements ItemAnimator.ItemAnimatorListener {
        public ItemAnimatorRestoreListener() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator.ItemAnimatorListener
        public void onAnimationFinished(ViewHolder viewHolder) {
            viewHolder.setIsRecyclable(true);
            if (viewHolder.mShadowedHolder != null && viewHolder.mShadowingHolder == null) {
                viewHolder.mShadowedHolder = null;
            }
            viewHolder.mShadowingHolder = null;
            for (ItemDecoration itemDecoration : RecyclerView.this.mItemDecorations) {
                if (itemDecoration instanceof ItemTouchHelper) {
                    ((ItemTouchHelper) itemDecoration).endRecoverAnimation(viewHolder, false);
                }
            }
            if (viewHolder.shouldBeKeptAsChild() || RecyclerView.this.removeAnimatingView(viewHolder.itemView) || !viewHolder.isTmpDetached()) {
                return;
            }
            RecyclerView.this.removeDetachedView(viewHolder.itemView, false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ItemBackgroundHolder {
        private SeslRecoilDrawable mActiveBg = null;

        public ItemBackgroundHolder() {
        }

        public void setCancel() {
            SeslRecoilDrawable seslRecoilDrawable = this.mActiveBg;
            if (seslRecoilDrawable != null) {
                seslRecoilDrawable.setCancel();
            }
        }

        public void setPress(View view) {
            setRelease();
            if (view.getBackground() instanceof SeslRecoilDrawable) {
                SeslRecoilDrawable seslRecoilDrawable = (SeslRecoilDrawable) view.getBackground();
                this.mActiveBg = seslRecoilDrawable;
                seslRecoilDrawable.setState(new int[]{R.attr.state_hovered});
                this.mActiveBg.setListener(new SeslRecoilDrawable.SeslRecoilDrawableListener() { // from class: androidx.recyclerview.widget.RecyclerView.ItemBackgroundHolder.1
                    @Override // androidx.appcompat.graphics.drawable.SeslRecoilDrawable.SeslRecoilDrawableListener
                    public void onReleaseAnimationStart() {
                        ItemBackgroundHolder.this.mActiveBg.removeListener();
                        ItemBackgroundHolder.this.mActiveBg = null;
                    }
                });
            }
        }

        public void setRelease() {
            SeslRecoilDrawable seslRecoilDrawable = this.mActiveBg;
            if (seslRecoilDrawable != null) {
                seslRecoilDrawable.setState(new int[0]);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class ItemDecoration {
        @Deprecated
        public void getItemOffsets(@NonNull Rect rect, int i, @NonNull RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        @Deprecated
        public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView) {
        }

        @Deprecated
        public void onDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView) {
        }

        public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull State state) {
            getItemOffsets(rect, ((LayoutParams) view.getLayoutParams()).getViewLayoutPosition(), recyclerView);
        }

        public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull State state) {
            onDraw(canvas, recyclerView);
        }

        public void onDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull State state) {
            onDrawOver(canvas, recyclerView);
        }

        public void seslOnDispatchDraw(Canvas canvas, RecyclerView recyclerView, State state) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class LayoutManager {
        boolean mAutoMeasure;
        ChildHelper mChildHelper;
        private int mHeight;
        private int mHeightMode;
        ViewBoundsCheck mHorizontalBoundCheck;
        private final ViewBoundsCheck.Callback mHorizontalBoundCheckCallback;
        boolean mIsAttachedToWindow;
        private boolean mItemPrefetchEnabled;
        private boolean mMeasurementCacheEnabled;
        int mPrefetchMaxCountObserved;
        boolean mPrefetchMaxObservedInInitialPrefetch;
        RecyclerView mRecyclerView;
        boolean mRequestedSimpleAnimations;

        @Nullable
        SmoothScroller mSmoothScroller;
        ViewBoundsCheck mVerticalBoundCheck;
        private final ViewBoundsCheck.Callback mVerticalBoundCheckCallback;
        private int mWidth;
        private int mWidthMode;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public interface LayoutPrefetchRegistry {
            void addPosition(int i, int i2);
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class Properties {
            public int orientation;
            public boolean reverseLayout;
            public int spanCount;
            public boolean stackFromEnd;
        }

        public LayoutManager() {
            ViewBoundsCheck.Callback callback = new ViewBoundsCheck.Callback() { // from class: androidx.recyclerview.widget.RecyclerView.LayoutManager.1
                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public View getChildAt(int i) {
                    return LayoutManager.this.getChildAt(i);
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public int getChildEnd(View view) {
                    return LayoutManager.this.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).rightMargin;
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public int getChildStart(View view) {
                    return LayoutManager.this.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).leftMargin;
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public int getParentEnd() {
                    return LayoutManager.this.getWidth() - LayoutManager.this.getPaddingRight();
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public int getParentStart() {
                    return LayoutManager.this.getPaddingLeft();
                }
            };
            this.mHorizontalBoundCheckCallback = callback;
            ViewBoundsCheck.Callback callback2 = new ViewBoundsCheck.Callback() { // from class: androidx.recyclerview.widget.RecyclerView.LayoutManager.2
                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public View getChildAt(int i) {
                    return LayoutManager.this.getChildAt(i);
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public int getChildEnd(View view) {
                    return LayoutManager.this.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).bottomMargin;
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public int getChildStart(View view) {
                    return LayoutManager.this.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).topMargin;
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public int getParentEnd() {
                    return LayoutManager.this.getHeight() - LayoutManager.this.getPaddingBottom();
                }

                @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
                public int getParentStart() {
                    return LayoutManager.this.getPaddingTop();
                }
            };
            this.mVerticalBoundCheckCallback = callback2;
            this.mHorizontalBoundCheck = new ViewBoundsCheck(callback);
            this.mVerticalBoundCheck = new ViewBoundsCheck(callback2);
            this.mRequestedSimpleAnimations = false;
            this.mIsAttachedToWindow = false;
            this.mAutoMeasure = false;
            this.mMeasurementCacheEnabled = true;
            this.mItemPrefetchEnabled = true;
        }

        private void addViewInt(View view, int i, boolean z) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (z || childViewHolderInt.isRemoved()) {
                this.mRecyclerView.mViewInfoStore.addToDisappearedInLayout(childViewHolderInt);
            } else {
                this.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(childViewHolderInt);
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (childViewHolderInt.wasReturnedFromScrap() || childViewHolderInt.isScrap()) {
                if (childViewHolderInt.isScrap()) {
                    childViewHolderInt.unScrap();
                } else {
                    childViewHolderInt.clearReturnedFromScrapFlag();
                }
                this.mChildHelper.attachViewToParent(view, i, view.getLayoutParams(), false);
            } else if (view.getParent() == this.mRecyclerView) {
                int iIndexOfChild = this.mChildHelper.indexOfChild(view);
                if (i == -1) {
                    i = this.mChildHelper.getChildCount();
                }
                if (iIndexOfChild == -1) {
                    StringBuilder sb = new StringBuilder("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:");
                    sb.append(this.mRecyclerView.indexOfChild(view));
                    throw new IllegalStateException(AbstractC2821a.m2219j(this.mRecyclerView, sb));
                }
                if (iIndexOfChild != i) {
                    this.mRecyclerView.mLayout.moveView(iIndexOfChild, i);
                }
            } else {
                this.mChildHelper.addView(view, i, false);
                layoutParams.mInsetsDirty = true;
                SmoothScroller smoothScroller = this.mSmoothScroller;
                if (smoothScroller != null && smoothScroller.isRunning()) {
                    this.mSmoothScroller.onChildAttachedToWindow(view);
                }
            }
            if (layoutParams.mPendingInvalidate) {
                if (RecyclerView.sVerboseLoggingEnabled) {
                    Log.d(RecyclerView.TAG, "consuming pending invalidate on child " + layoutParams.mViewHolder);
                }
                childViewHolderInt.itemView.invalidate();
                layoutParams.mPendingInvalidate = false;
            }
        }

        public static int chooseSize(int i, int i2, int i4) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            return mode != Integer.MIN_VALUE ? mode != 1073741824 ? Math.max(i2, i4) : size : Math.min(size, Math.max(i2, i4));
        }

        private void detachViewInternal(int i, @NonNull View view) {
            this.mChildHelper.detachViewFromParent(i);
        }

        /* JADX WARN: Removed duplicated region for block: B:5:0x000c A[PHI: r3
          0x000c: PHI (r3v5 int) = (r3v0 int), (r3v2 int), (r3v0 int) binds: [B:7:0x0010, B:11:0x0016, B:4:0x000a] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:6:0x000e  */
        @Deprecated
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static int getChildMeasureSpec(int i, int i2, int i4, boolean z) {
            int i5 = i - i2;
            int i6 = 0;
            int iMax = Math.max(0, i5);
            if (z) {
                if (i4 >= 0) {
                    i6 = 1073741824;
                } else {
                    i4 = 0;
                }
            } else if (i4 < 0) {
                if (i4 == -1) {
                    i4 = iMax;
                    i6 = 1073741824;
                } else if (i4 == -2) {
                    i6 = Integer.MIN_VALUE;
                    i4 = iMax;
                }
            }
            return View.MeasureSpec.makeMeasureSpec(i4, i6);
        }

        private int[] getChildRectangleOnScreenScrollAmount(View view, Rect rect) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = (getHeight() - getPaddingBottom()) - this.mRecyclerView.mHoverBottomAreaHeight;
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int iWidth = rect.width() + left;
            int iHeight = rect.height() + top;
            int i = left - paddingLeft;
            int iMin = Math.min(0, i);
            int i2 = top - paddingTop;
            int iMin2 = Math.min(0, i2);
            int i4 = iWidth - width;
            int iMax = Math.max(0, i4);
            int iMax2 = Math.max(0, iHeight - height);
            if (getLayoutDirection() != 1) {
                if (iMin == 0) {
                    iMin = Math.min(i, iMax);
                }
                iMax = iMin;
            } else if (iMax == 0) {
                iMax = Math.max(iMin, i4);
            }
            if (iMin2 == 0) {
                iMin2 = Math.min(i2, iMax2);
            }
            return new int[]{iMax, iMin2};
        }

        public static Properties getProperties(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
            Properties properties = new Properties();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C3728R.styleable.RecyclerView, i, i2);
            properties.orientation = typedArrayObtainStyledAttributes.getInt(C3728R.styleable.RecyclerView_android_orientation, 1);
            properties.spanCount = typedArrayObtainStyledAttributes.getInt(C3728R.styleable.RecyclerView_spanCount, 1);
            properties.reverseLayout = typedArrayObtainStyledAttributes.getBoolean(C3728R.styleable.RecyclerView_reverseLayout, false);
            properties.stackFromEnd = typedArrayObtainStyledAttributes.getBoolean(C3728R.styleable.RecyclerView_stackFromEnd, false);
            typedArrayObtainStyledAttributes.recycle();
            return properties;
        }

        private boolean isFocusedChildVisibleAfterScrolling(RecyclerView recyclerView, int i, int i2) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = (getHeight() - getPaddingBottom()) - this.mRecyclerView.mHoverBottomAreaHeight;
            Rect rect = this.mRecyclerView.mTempRect;
            getDecoratedBoundsWithMargins(focusedChild, rect);
            return rect.left - i < width && rect.right - i > paddingLeft && rect.top - i2 < height && rect.bottom - i2 > paddingTop;
        }

        private static boolean isMeasurementUpToDate(int i, int i2, int i4) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (i4 > 0 && i != i4) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i;
            }
            return true;
        }

        private void scrapOrRecycleView(Recycler recycler, int i, View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.shouldIgnore()) {
                if (RecyclerView.sVerboseLoggingEnabled) {
                    Log.d(RecyclerView.TAG, "ignoring view " + childViewHolderInt);
                    return;
                }
                return;
            }
            if (childViewHolderInt.isInvalid() && !childViewHolderInt.isRemoved() && !this.mRecyclerView.mAdapter.hasStableIds()) {
                removeViewAt(i);
                recycler.recycleViewHolderInternal(childViewHolderInt);
            } else {
                detachViewAt(i);
                recycler.scrapView(view);
                this.mRecyclerView.mViewInfoStore.onViewDetached(childViewHolderInt);
            }
        }

        @SuppressLint({"UnknownNullness"})
        public void addDisappearingView(View view) {
            addDisappearingView(view, -1);
        }

        @SuppressLint({"UnknownNullness"})
        public void addView(View view) {
            addView(view, -1);
        }

        public void assertInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.assertInLayoutOrScroll(str);
            }
        }

        @SuppressLint({"UnknownNullness"})
        public void assertNotInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.assertNotInLayoutOrScroll(str);
            }
        }

        public void attachView(@NonNull View view, int i, LayoutParams layoutParams) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isRemoved()) {
                this.mRecyclerView.mViewInfoStore.addToDisappearedInLayout(childViewHolderInt);
            } else {
                this.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(childViewHolderInt);
            }
            this.mChildHelper.attachViewToParent(view, i, layoutParams, childViewHolderInt.isRemoved());
        }

        public void calculateItemDecorationsForChild(@NonNull View view, @NonNull Rect rect) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.getItemDecorInsetsForChild(view));
            }
        }

        public boolean canScrollHorizontally() {
            return false;
        }

        public boolean canScrollVertically() {
            return false;
        }

        public boolean checkLayoutParams(LayoutParams layoutParams) {
            return layoutParams != null;
        }

        public int computeHorizontalScrollExtent(@NonNull State state) {
            return 0;
        }

        public int computeHorizontalScrollOffset(@NonNull State state) {
            return 0;
        }

        public int computeHorizontalScrollRange(@NonNull State state) {
            return 0;
        }

        public int computeVerticalScrollExtent(@NonNull State state) {
            return 0;
        }

        public int computeVerticalScrollOffset(@NonNull State state) {
            return 0;
        }

        public int computeVerticalScrollRange(@NonNull State state) {
            return 0;
        }

        public void detachAndScrapAttachedViews(@NonNull Recycler recycler) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                scrapOrRecycleView(recycler, childCount, getChildAt(childCount));
            }
        }

        public void detachAndScrapView(@NonNull View view, @NonNull Recycler recycler) {
            scrapOrRecycleView(recycler, this.mChildHelper.indexOfChild(view), view);
        }

        public void detachAndScrapViewAt(int i, @NonNull Recycler recycler) {
            scrapOrRecycleView(recycler, i, getChildAt(i));
        }

        public void detachView(@NonNull View view) {
            int iIndexOfChild = this.mChildHelper.indexOfChild(view);
            if (iIndexOfChild >= 0) {
                detachViewInternal(iIndexOfChild, view);
            }
        }

        public void detachViewAt(int i) {
            detachViewInternal(i, getChildAt(i));
        }

        public void dispatchAttachedToWindow(RecyclerView recyclerView) {
            this.mIsAttachedToWindow = true;
            onAttachedToWindow(recyclerView);
        }

        public void dispatchDetachedFromWindow(RecyclerView recyclerView, Recycler recycler) {
            this.mIsAttachedToWindow = false;
            onDetachedFromWindow(recyclerView, recycler);
        }

        @SuppressLint({"UnknownNullness"})
        public void endAnimation(View view) {
            ItemAnimator itemAnimator = this.mRecyclerView.mItemAnimator;
            if (itemAnimator != null) {
                itemAnimator.endAnimation(RecyclerView.getChildViewHolderInt(view));
            }
        }

        @Nullable
        public View findContainingItemView(@NonNull View view) {
            View viewFindContainingItemView;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || (viewFindContainingItemView = recyclerView.findContainingItemView(view)) == null || this.mChildHelper.isHidden(viewFindContainingItemView)) {
                return null;
            }
            return viewFindContainingItemView;
        }

        @Nullable
        public View findViewByPosition(int i) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt);
                if (childViewHolderInt != null && childViewHolderInt.getLayoutPosition() == i && !childViewHolderInt.shouldIgnore() && (this.mRecyclerView.mState.isPreLayout() || !childViewHolderInt.isRemoved())) {
                    return childAt;
                }
            }
            return null;
        }

        @SuppressLint({"UnknownNullness"})
        public abstract LayoutParams generateDefaultLayoutParams();

        @SuppressLint({"UnknownNullness"})
        public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
            return layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
        }

        public int getBaseline() {
            return -1;
        }

        public int getBottomDecorationHeight(@NonNull View view) {
            return ((LayoutParams) view.getLayoutParams()).mDecorInsets.bottom;
        }

        @Nullable
        public View getChildAt(int i) {
            ChildHelper childHelper = this.mChildHelper;
            if (childHelper != null) {
                return childHelper.getChildAt(i);
            }
            return null;
        }

        public int getChildCount() {
            ChildHelper childHelper = this.mChildHelper;
            if (childHelper != null) {
                return childHelper.getChildCount();
            }
            return 0;
        }

        public boolean getClipToPadding() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.mClipToPadding;
        }

        public int getColumnCountForAccessibility(@NonNull Recycler recycler, @NonNull State state) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || recyclerView.mAdapter == null || !canScrollHorizontally()) {
                return 1;
            }
            return this.mRecyclerView.mAdapter.getItemCount();
        }

        public int getDecoratedBottom(@NonNull View view) {
            return getBottomDecorationHeight(view) + view.getBottom();
        }

        public void getDecoratedBoundsWithMargins(@NonNull View view, @NonNull Rect rect) {
            RecyclerView.getDecoratedBoundsWithMarginsInt(view, rect);
        }

        public int getDecoratedLeft(@NonNull View view) {
            return view.getLeft() - getLeftDecorationWidth(view);
        }

        public int getDecoratedMeasuredHeight(@NonNull View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).mDecorInsets;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public int getDecoratedMeasuredWidth(@NonNull View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).mDecorInsets;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public int getDecoratedRight(@NonNull View view) {
            return getRightDecorationWidth(view) + view.getRight();
        }

        public int getDecoratedTop(@NonNull View view) {
            return view.getTop() - getTopDecorationHeight(view);
        }

        @Nullable
        public View getFocusedChild() {
            View focusedChild;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.mChildHelper.isHidden(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        @Px
        public int getHeight() {
            return this.mHeight;
        }

        public int getHeightMode() {
            return this.mHeightMode;
        }

        public int getItemCount() {
            RecyclerView recyclerView = this.mRecyclerView;
            Adapter adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.getItemCount();
            }
            return 0;
        }

        public int getItemViewType(@NonNull View view) {
            return RecyclerView.getChildViewHolderInt(view).getItemViewType();
        }

        public int getLayoutDirection() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return ViewCompat.getLayoutDirection(recyclerView);
            }
            Log.e(RecyclerView.TAG, "RecyclerView is null.");
            return 0;
        }

        public int getLeftDecorationWidth(@NonNull View view) {
            return ((LayoutParams) view.getLayoutParams()).mDecorInsets.left;
        }

        @Px
        public int getMinimumHeight() {
            return ViewCompat.getMinimumHeight(this.mRecyclerView);
        }

        @Px
        public int getMinimumWidth() {
            return ViewCompat.getMinimumWidth(this.mRecyclerView);
        }

        @Px
        public int getPaddingBottom() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        @Px
        public int getPaddingEnd() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return ViewCompat.getPaddingEnd(recyclerView);
            }
            return 0;
        }

        @Px
        public int getPaddingLeft() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        @Px
        public int getPaddingRight() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        @Px
        public int getPaddingStart() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return ViewCompat.getPaddingStart(recyclerView);
            }
            return 0;
        }

        @Px
        public int getPaddingTop() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int getPosition(@Nullable View view) {
            if (view != null) {
                return ((LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
            }
            Log.e(RecyclerView.TAG, "View is null.");
            return -1;
        }

        public int getRightDecorationWidth(@NonNull View view) {
            return ((LayoutParams) view.getLayoutParams()).mDecorInsets.right;
        }

        public int getRowCountForAccessibility(@NonNull Recycler recycler, @NonNull State state) {
            Adapter adapter;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null && (adapter = recyclerView.mAdapter) != null) {
                if (adapter.seslUseCustomAccessibilityPosition()) {
                    if (canScrollVertically()) {
                        return this.mRecyclerView.mAdapter.seslGetAccessibilityItemCount();
                    }
                    return 1;
                }
                if (canScrollVertically()) {
                    return this.mRecyclerView.mAdapter.getItemCount();
                }
            }
            return 1;
        }

        public int getSelectionModeForAccessibility(@NonNull Recycler recycler, @NonNull State state) {
            return 0;
        }

        public int getTopDecorationHeight(@NonNull View view) {
            return ((LayoutParams) view.getLayoutParams()).mDecorInsets.top;
        }

        public void getTransformedBoundingBox(@NonNull View view, boolean z, @NonNull Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((LayoutParams) view.getLayoutParams()).mDecorInsets;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.mRecyclerView != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.mRecyclerView.mTempRectF;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        @Px
        public int getWidth() {
            return this.mWidth;
        }

        public int getWidthMode() {
            return this.mWidthMode;
        }

        public boolean hasFlexibleChildInBothOrientations() {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                ViewGroup.LayoutParams layoutParams = getChildAt(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public boolean hasFocus() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.hasFocus();
        }

        public void ignoreView(@NonNull View view) {
            ViewParent parent = view.getParent();
            RecyclerView recyclerView = this.mRecyclerView;
            if (parent != recyclerView || recyclerView.indexOfChild(view) == -1) {
                throw new IllegalArgumentException(AbstractC2821a.m2219j(this.mRecyclerView, new StringBuilder("View should be fully attached to be ignored")));
            }
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.addFlags(128);
            this.mRecyclerView.mViewInfoStore.removeViewHolder(childViewHolderInt);
        }

        public boolean isAttachedToWindow() {
            return this.mIsAttachedToWindow;
        }

        public boolean isAutoMeasureEnabled() {
            return this.mAutoMeasure;
        }

        public boolean isFocused() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.isFocused();
        }

        public final boolean isItemPrefetchEnabled() {
            return this.mItemPrefetchEnabled;
        }

        public boolean isLayoutHierarchical(@NonNull Recycler recycler, @NonNull State state) {
            return false;
        }

        public boolean isMeasurementCacheEnabled() {
            return this.mMeasurementCacheEnabled;
        }

        public boolean isSmoothScrolling() {
            SmoothScroller smoothScroller = this.mSmoothScroller;
            return smoothScroller != null && smoothScroller.isRunning();
        }

        public boolean isViewPartiallyVisible(@NonNull View view, boolean z, boolean z2) {
            boolean z3 = this.mHorizontalBoundCheck.isViewWithinBoundFlags(view, 24579) && this.mVerticalBoundCheck.isViewWithinBoundFlags(view, 24579);
            return z ? z3 : !z3;
        }

        public void layoutDecorated(@NonNull View view, int i, int i2, int i4, int i5) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).mDecorInsets;
            view.layout(i + rect.left, i2 + rect.top, i4 - rect.right, i5 - rect.bottom);
        }

        public void layoutDecoratedWithMargins(@NonNull View view, int i, int i2, int i4, int i5) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect rect = layoutParams.mDecorInsets;
            view.layout(i + rect.left + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i2 + rect.top + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, (i4 - rect.right) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, (i5 - rect.bottom) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        }

        public void measureChild(@NonNull View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
            int i4 = itemDecorInsetsForChild.left + itemDecorInsetsForChild.right + i;
            int i5 = itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom + i2;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingRight() + getPaddingLeft() + i4, ((ViewGroup.MarginLayoutParams) layoutParams).width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingBottom() + getPaddingTop() + i5, ((ViewGroup.MarginLayoutParams) layoutParams).height, canScrollVertically());
            if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, layoutParams)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        public void measureChildWithMargins(@NonNull View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
            int i4 = itemDecorInsetsForChild.left + itemDecorInsetsForChild.right + i;
            int i5 = itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom + i2;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingRight() + getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + i4, ((ViewGroup.MarginLayoutParams) layoutParams).width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingBottom() + getPaddingTop() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + i5, ((ViewGroup.MarginLayoutParams) layoutParams).height, canScrollVertically());
            if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, layoutParams)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        public void moveView(int i, int i2) {
            View childAt = getChildAt(i);
            if (childAt != null) {
                detachViewAt(i);
                attachView(childAt, i2);
            } else {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i + this.mRecyclerView.toString());
            }
        }

        public void offsetChildrenHorizontal(@Px int i) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.offsetChildrenHorizontal(i);
            }
        }

        public void offsetChildrenVertical(@Px int i) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.offsetChildrenVertical(i);
            }
        }

        public boolean onAddFocusables(@NonNull RecyclerView recyclerView, @NonNull ArrayList<View> arrayList, int i, int i2) {
            return false;
        }

        @Deprecated
        public void onDetachedFromWindow(RecyclerView recyclerView) {
        }

        @Nullable
        public View onFocusSearchFailed(@NonNull View view, int i, @NonNull Recycler recycler, @NonNull State state) {
            return null;
        }

        public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.mRecyclerView;
            onInitializeAccessibilityEvent(recyclerView.mRecycler, recyclerView.mState, accessibilityEvent);
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            RecyclerView recyclerView = this.mRecyclerView;
            onInitializeAccessibilityNodeInfo(recyclerView.mRecycler, recyclerView.mState, accessibilityNodeInfoCompat);
        }

        public void onInitializeAccessibilityNodeInfoForItem(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt == null || childViewHolderInt.isRemoved() || this.mChildHelper.isHidden(childViewHolderInt.itemView)) {
                return;
            }
            RecyclerView recyclerView = this.mRecyclerView;
            onInitializeAccessibilityNodeInfoForItem(recyclerView.mRecycler, recyclerView.mState, view, accessibilityNodeInfoCompat);
        }

        @Nullable
        public View onInterceptFocusSearch(@NonNull View view, int i) {
            return null;
        }

        public void onItemsUpdated(@NonNull RecyclerView recyclerView, int i, int i2) {
        }

        @SuppressLint({"UnknownNullness"})
        public void onLayoutChildren(Recycler recycler, State state) {
            Log.e(RecyclerView.TAG, "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public void onMeasure(@NonNull Recycler recycler, @NonNull State state, int i, int i2) {
            this.mRecyclerView.defaultOnMeasure(i, i2);
        }

        @Deprecated
        public boolean onRequestChildFocus(@NonNull RecyclerView recyclerView, @NonNull View view, @Nullable View view2) {
            return isSmoothScrolling() || recyclerView.isComputingLayout();
        }

        @Nullable
        public Parcelable onSaveInstanceState() {
            return null;
        }

        public void onSmoothScrollerStopped(SmoothScroller smoothScroller) {
            if (this.mSmoothScroller == smoothScroller) {
                this.mSmoothScroller = null;
            }
        }

        public boolean performAccessibilityAction(int i, @Nullable Bundle bundle) {
            RecyclerView recyclerView = this.mRecyclerView;
            return performAccessibilityAction(recyclerView.mRecycler, recyclerView.mState, i, bundle);
        }

        public boolean performAccessibilityActionForItem(@NonNull Recycler recycler, @NonNull State state, @NonNull View view, int i, @Nullable Bundle bundle) {
            return false;
        }

        public void postOnAnimation(Runnable runnable) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                ViewCompat.postOnAnimation(recyclerView, runnable);
            }
        }

        public void removeAllViews() {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                this.mChildHelper.removeViewAt(childCount);
            }
        }

        public void removeAndRecycleAllViews(@NonNull Recycler recycler) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                if (!RecyclerView.getChildViewHolderInt(getChildAt(childCount)).shouldIgnore()) {
                    removeAndRecycleViewAt(childCount, recycler);
                }
            }
        }

        public void removeAndRecycleScrapInt(Recycler recycler) {
            int scrapCount = recycler.getScrapCount();
            for (int i = scrapCount - 1; i >= 0; i--) {
                View scrapViewAt = recycler.getScrapViewAt(i);
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(scrapViewAt);
                if (!childViewHolderInt.shouldIgnore()) {
                    childViewHolderInt.setIsRecyclable(false);
                    if (childViewHolderInt.isTmpDetached()) {
                        this.mRecyclerView.removeDetachedView(scrapViewAt, false);
                    }
                    ItemAnimator itemAnimator = this.mRecyclerView.mItemAnimator;
                    if (itemAnimator != null) {
                        itemAnimator.endAnimation(childViewHolderInt);
                    }
                    childViewHolderInt.setIsRecyclable(true);
                    recycler.quickRecycleScrapView(scrapViewAt);
                }
            }
            recycler.clearScrap();
            if (scrapCount > 0) {
                this.mRecyclerView.invalidate();
            }
        }

        public void removeAndRecycleView(@NonNull View view, @NonNull Recycler recycler) {
            removeView(view);
            recycler.recycleView(view);
        }

        public void removeAndRecycleViewAt(int i, @NonNull Recycler recycler) {
            View childAt = getChildAt(i);
            removeViewAt(i);
            recycler.recycleView(childAt);
        }

        public boolean removeCallbacks(Runnable runnable) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public void removeDetachedView(@NonNull View view) {
            this.mRecyclerView.removeDetachedView(view, false);
        }

        @SuppressLint({"UnknownNullness"})
        public void removeView(View view) {
            this.mChildHelper.removeView(view);
        }

        public void removeViewAt(int i) {
            if (getChildAt(i) != null) {
                this.mChildHelper.removeViewAt(i);
            }
        }

        public boolean requestChildRectangleOnScreen(@NonNull RecyclerView recyclerView, @NonNull View view, @NonNull Rect rect, boolean z) {
            return requestChildRectangleOnScreen(recyclerView, view, rect, z, false);
        }

        public void requestLayout() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public void requestSimpleAnimationsInNextLayout() {
            this.mRequestedSimpleAnimations = true;
        }

        @SuppressLint({"UnknownNullness"})
        public int scrollHorizontallyBy(int i, Recycler recycler, State state) {
            return 0;
        }

        public void scrollToPosition(int i) {
            if (RecyclerView.sVerboseLoggingEnabled) {
                Log.e(RecyclerView.TAG, "You MUST implement scrollToPosition. It will soon become abstract");
            }
        }

        @SuppressLint({"UnknownNullness"})
        public int scrollVerticallyBy(int i, Recycler recycler, State state) {
            return 0;
        }

        @Deprecated
        public void setAutoMeasureEnabled(boolean z) {
            this.mAutoMeasure = z;
        }

        public void setExactMeasureSpecsFrom(RecyclerView recyclerView) {
            setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        public final void setItemPrefetchEnabled(boolean z) {
            if (z != this.mItemPrefetchEnabled) {
                this.mItemPrefetchEnabled = z;
                this.mPrefetchMaxCountObserved = 0;
                RecyclerView recyclerView = this.mRecyclerView;
                if (recyclerView != null) {
                    recyclerView.mRecycler.updateViewCacheSize();
                }
            }
        }

        public void setMeasureSpecs(int i, int i2) {
            this.mWidth = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            this.mWidthMode = mode;
            if (mode == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.mWidth = 0;
            }
            this.mHeight = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i2);
            this.mHeightMode = mode2;
            if (mode2 != 0 || RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                return;
            }
            this.mHeight = 0;
        }

        public void setMeasuredDimension(Rect rect, int i, int i2) {
            setMeasuredDimension(chooseSize(i, getPaddingRight() + getPaddingLeft() + rect.width(), getMinimumWidth()), chooseSize(i2, getPaddingBottom() + getPaddingTop() + rect.height(), getMinimumHeight()));
        }

        public void setMeasuredDimensionFromChildren(int i, int i2) {
            int childCount = getChildCount();
            if (childCount == 0) {
                this.mRecyclerView.defaultOnMeasure(i, i2);
                return;
            }
            int i4 = Integer.MIN_VALUE;
            int i5 = Integer.MAX_VALUE;
            int i6 = Integer.MIN_VALUE;
            int i7 = Integer.MAX_VALUE;
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = getChildAt(i8);
                Rect rect = this.mRecyclerView.mTempRect;
                getDecoratedBoundsWithMargins(childAt, rect);
                int i9 = rect.left;
                if (i9 < i7) {
                    i7 = i9;
                }
                int i10 = rect.right;
                if (i10 > i4) {
                    i4 = i10;
                }
                int i11 = rect.top;
                if (i11 < i5) {
                    i5 = i11;
                }
                int i12 = rect.bottom;
                if (i12 > i6) {
                    i6 = i12;
                }
            }
            this.mRecyclerView.mTempRect.set(i7, i5, i4, i6);
            setMeasuredDimension(this.mRecyclerView.mTempRect, i, i2);
        }

        public void setMeasurementCacheEnabled(boolean z) {
            this.mMeasurementCacheEnabled = z;
        }

        public void setRecyclerView(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.mRecyclerView = null;
                this.mChildHelper = null;
                this.mWidth = 0;
                this.mHeight = 0;
            } else {
                this.mRecyclerView = recyclerView;
                this.mChildHelper = recyclerView.mChildHelper;
                this.mWidth = recyclerView.getWidth();
                this.mHeight = recyclerView.getHeight();
            }
            this.mWidthMode = 1073741824;
            this.mHeightMode = 1073741824;
        }

        public boolean shouldMeasureChild(View view, int i, int i2, LayoutParams layoutParams) {
            return (!view.isLayoutRequested() && this.mMeasurementCacheEnabled && isMeasurementUpToDate(view.getWidth(), i, ((ViewGroup.MarginLayoutParams) layoutParams).width) && isMeasurementUpToDate(view.getHeight(), i2, ((ViewGroup.MarginLayoutParams) layoutParams).height)) ? false : true;
        }

        public boolean shouldMeasureTwice() {
            return false;
        }

        public boolean shouldReMeasureChild(View view, int i, int i2, LayoutParams layoutParams) {
            return (this.mMeasurementCacheEnabled && isMeasurementUpToDate(view.getMeasuredWidth(), i, ((ViewGroup.MarginLayoutParams) layoutParams).width) && isMeasurementUpToDate(view.getMeasuredHeight(), i2, ((ViewGroup.MarginLayoutParams) layoutParams).height)) ? false : true;
        }

        @SuppressLint({"UnknownNullness"})
        public void smoothScrollToPosition(RecyclerView recyclerView, State state, int i) {
            Log.e(RecyclerView.TAG, "You must override smoothScrollToPosition to support smooth scrolling");
        }

        @SuppressLint({"UnknownNullness"})
        public void startSmoothScroll(SmoothScroller smoothScroller) {
            SmoothScroller smoothScroller2 = this.mSmoothScroller;
            if (smoothScroller2 != null && smoothScroller != smoothScroller2 && smoothScroller2.isRunning()) {
                this.mSmoothScroller.stop();
            }
            this.mSmoothScroller = smoothScroller;
            smoothScroller.start(this.mRecyclerView, this);
        }

        public void stopIgnoringView(@NonNull View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.stopIgnoring();
            childViewHolderInt.resetInternal();
            childViewHolderInt.addFlags(4);
        }

        public void stopSmoothScroller() {
            SmoothScroller smoothScroller = this.mSmoothScroller;
            if (smoothScroller != null) {
                smoothScroller.stop();
            }
        }

        public boolean supportsPredictiveItemAnimations() {
            return false;
        }

        @SuppressLint({"UnknownNullness"})
        public void addDisappearingView(View view, int i) {
            addViewInt(view, i, true);
        }

        @SuppressLint({"UnknownNullness"})
        public void addView(View view, int i) {
            addViewInt(view, i, false);
        }

        @SuppressLint({"UnknownNullness"})
        @CallSuper
        public void onDetachedFromWindow(RecyclerView recyclerView, Recycler recycler) {
            onDetachedFromWindow(recyclerView);
        }

        public void onInitializeAccessibilityEvent(@NonNull Recycler recycler, @NonNull State state, @NonNull AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || accessibilityEvent == null) {
                return;
            }
            boolean z = true;
            if (!recyclerView.canScrollVertically(1) && !this.mRecyclerView.canScrollVertically(-1) && !this.mRecyclerView.canScrollHorizontally(-1) && !this.mRecyclerView.canScrollHorizontally(1)) {
                z = false;
            }
            accessibilityEvent.setScrollable(z);
            Adapter adapter = this.mRecyclerView.mAdapter;
            if (adapter != null) {
                if (adapter.seslUseCustomAccessibilityPosition()) {
                    accessibilityEvent.setItemCount(this.mRecyclerView.mAdapter.seslGetAccessibilityItemCount());
                } else {
                    accessibilityEvent.setItemCount(this.mRecyclerView.mAdapter.getItemCount());
                }
            }
        }

        public void onInitializeAccessibilityNodeInfo(@NonNull Recycler recycler, @NonNull State state, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (this.mRecyclerView.canScrollVertically(-1) || this.mRecyclerView.canScrollHorizontally(-1)) {
                accessibilityNodeInfoCompat.addAction(8192);
                accessibilityNodeInfoCompat.setScrollable(true);
            }
            if (this.mRecyclerView.canScrollVertically(1) || this.mRecyclerView.canScrollHorizontally(1)) {
                accessibilityNodeInfoCompat.addAction(4096);
                accessibilityNodeInfoCompat.setScrollable(true);
            }
            accessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(getRowCountForAccessibility(recycler, state), getColumnCountForAccessibility(recycler, state), isLayoutHierarchical(recycler, state), getSelectionModeForAccessibility(recycler, state)));
        }

        public void onItemsUpdated(@NonNull RecyclerView recyclerView, int i, int i2, @Nullable Object obj) {
            onItemsUpdated(recyclerView, i, i2);
        }

        public boolean onRequestChildFocus(@NonNull RecyclerView recyclerView, @NonNull State state, @NonNull View view, @Nullable View view2) {
            return onRequestChildFocus(recyclerView, view, view2);
        }

        public boolean performAccessibilityAction(@NonNull Recycler recycler, @NonNull State state, int i, @Nullable Bundle bundle) {
            int paddingTop;
            int paddingLeft;
            int i2;
            int i4;
            if (this.mRecyclerView == null) {
                return false;
            }
            int height = getHeight();
            int width = getWidth();
            Rect rect = new Rect();
            if (this.mRecyclerView.getMatrix().isIdentity() && this.mRecyclerView.getGlobalVisibleRect(rect)) {
                height = rect.height();
                width = rect.width();
            }
            if (i == 4096) {
                paddingTop = this.mRecyclerView.canScrollVertically(1) ? (height - getPaddingTop()) - getPaddingBottom() : 0;
                if (this.mRecyclerView.canScrollHorizontally(1)) {
                    paddingLeft = (width - getPaddingLeft()) - getPaddingRight();
                    i2 = paddingTop;
                    i4 = paddingLeft;
                }
                i2 = paddingTop;
                i4 = 0;
            } else if (i != 8192) {
                i4 = 0;
                i2 = 0;
            } else {
                paddingTop = this.mRecyclerView.canScrollVertically(-1) ? -((height - getPaddingTop()) - getPaddingBottom()) : 0;
                if (this.mRecyclerView.canScrollHorizontally(-1)) {
                    paddingLeft = -((width - getPaddingLeft()) - getPaddingRight());
                    i2 = paddingTop;
                    i4 = paddingLeft;
                }
                i2 = paddingTop;
                i4 = 0;
            }
            if (i2 == 0 && i4 == 0) {
                return false;
            }
            this.mRecyclerView.smoothScrollBy(i4, i2, null, Integer.MIN_VALUE, true);
            return true;
        }

        public boolean performAccessibilityActionForItem(@NonNull View view, int i, @Nullable Bundle bundle) {
            RecyclerView recyclerView = this.mRecyclerView;
            return performAccessibilityActionForItem(recyclerView.mRecycler, recyclerView.mState, view, i, bundle);
        }

        public boolean requestChildRectangleOnScreen(@NonNull RecyclerView recyclerView, @NonNull View view, @NonNull Rect rect, boolean z, boolean z2) {
            int[] childRectangleOnScreenScrollAmount = getChildRectangleOnScreenScrollAmount(view, rect);
            int i = childRectangleOnScreenScrollAmount[0];
            int i2 = childRectangleOnScreenScrollAmount[1];
            if ((z2 && !isFocusedChildVisibleAfterScrolling(recyclerView, i, i2)) || (i == 0 && i2 == 0)) {
                return false;
            }
            if (z) {
                recyclerView.scrollBy(i, i2);
            } else {
                recyclerView.smoothScrollBy(i, i2);
            }
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0022  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static int getChildMeasureSpec(int i, int i2, int i4, int i5, boolean z) {
            int iMax = Math.max(0, i - i4);
            if (z) {
                if (i5 < 0) {
                    if (i5 != -1 || (i2 != Integer.MIN_VALUE && (i2 == 0 || i2 != 1073741824))) {
                        i2 = 0;
                        i5 = 0;
                    } else {
                        i5 = iMax;
                    }
                }
                i2 = 1073741824;
            } else if (i5 >= 0) {
                i2 = 1073741824;
            } else if (i5 != -1) {
                if (i5 == -2) {
                    if (i2 == Integer.MIN_VALUE || i2 == 1073741824) {
                        i5 = iMax;
                        i2 = Integer.MIN_VALUE;
                    } else {
                        i5 = iMax;
                        i2 = 0;
                    }
                }
            }
            return View.MeasureSpec.makeMeasureSpec(i5, i2);
        }

        public void onInitializeAccessibilityNodeInfoForItem(@NonNull Recycler recycler, @NonNull State state, @NonNull View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            int position = canScrollVertically() ? getPosition(view) : 0;
            int position2 = canScrollHorizontally() ? getPosition(view) : 0;
            if (this.mRecyclerView.mAdapter.seslUseCustomAccessibilityPosition()) {
                position = this.mRecyclerView.mAdapter.seslGetAccessibilityItemPosition(position);
                position2 = this.mRecyclerView.mAdapter.seslGetAccessibilityItemPosition(position2);
            }
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(position, 1, position2, 1, false, false));
        }

        public void attachView(@NonNull View view, int i) {
            attachView(view, i, (LayoutParams) view.getLayoutParams());
        }

        @SuppressLint({"UnknownNullness"})
        public LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
            return new LayoutParams(context, attributeSet);
        }

        public void setMeasuredDimension(int i, int i2) {
            this.mRecyclerView.setMeasuredDimension(i, i2);
        }

        public void attachView(@NonNull View view) {
            attachView(view, -1);
        }

        @CallSuper
        public void onAttachedToWindow(RecyclerView recyclerView) {
        }

        public void onItemsChanged(@NonNull RecyclerView recyclerView) {
        }

        @SuppressLint({"UnknownNullness"})
        public void onLayoutCompleted(State state) {
        }

        @SuppressLint({"UnknownNullness"})
        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        public void onScrollStateChanged(int i) {
        }

        @SuppressLint({"UnknownNullness"})
        public void collectInitialPrefetchPositions(int i, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        }

        public void onAdapterChanged(@Nullable Adapter adapter, @Nullable Adapter adapter2) {
        }

        public void onItemsAdded(@NonNull RecyclerView recyclerView, int i, int i2) {
        }

        public void onItemsRemoved(@NonNull RecyclerView recyclerView, int i, int i2) {
        }

        @SuppressLint({"UnknownNullness"})
        public void collectAdjacentPrefetchPositions(int i, int i2, State state, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        }

        public void onItemsMoved(@NonNull RecyclerView recyclerView, int i, int i2, int i4) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnChildAttachStateChangeListener {
        void onChildViewAttachedToWindow(@NonNull View view);

        void onChildViewDetachedFromWindow(@NonNull View view);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class OnFlingListener {
        public abstract boolean onFling(int i, int i2);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnItemTouchListener {
        boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent);

        void onRequestDisallowInterceptTouchEvent(boolean z);

        void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface Orientation {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class RecycledViewPool {
        private static final int DEFAULT_MAX_SCRAP = 5;
        SparseArray<ScrapData> mScrap = new SparseArray<>();
        int mAttachCountForClearing = 0;
        Set<Adapter<?>> mAttachedAdaptersForPoolingContainer = Collections.newSetFromMap(new IdentityHashMap());

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class ScrapData {
            final ArrayList<ViewHolder> mScrapHeap = new ArrayList<>();
            int mMaxScrap = 5;
            long mCreateRunningAverageNs = 0;
            long mBindRunningAverageNs = 0;
        }

        private ScrapData getScrapDataForType(int i) {
            ScrapData scrapData = this.mScrap.get(i);
            if (scrapData != null) {
                return scrapData;
            }
            ScrapData scrapData2 = new ScrapData();
            this.mScrap.put(i, scrapData2);
            return scrapData2;
        }

        public void attach() {
            this.mAttachCountForClearing++;
        }

        public void attachForPoolingContainer(@NonNull Adapter<?> adapter) {
            this.mAttachedAdaptersForPoolingContainer.add(adapter);
        }

        public void clear() {
            for (int i = 0; i < this.mScrap.size(); i++) {
                ScrapData scrapDataValueAt = this.mScrap.valueAt(i);
                if (scrapDataValueAt != null) {
                    Iterator<ViewHolder> it = scrapDataValueAt.mScrapHeap.iterator();
                    while (it.hasNext()) {
                        PoolingContainer.callPoolingContainerOnRelease(it.next().itemView);
                    }
                    scrapDataValueAt.mScrapHeap.clear();
                } else {
                    Log.e(RecyclerView.TAG, "clear() wasn't executed because RecycledViewPool.mScrap was invalid");
                }
            }
        }

        public void detach() {
            this.mAttachCountForClearing--;
        }

        public void detachForPoolingContainer(@NonNull Adapter<?> adapter, boolean z) {
            this.mAttachedAdaptersForPoolingContainer.remove(adapter);
            if (this.mAttachedAdaptersForPoolingContainer.size() != 0 || z) {
                return;
            }
            for (int i = 0; i < this.mScrap.size(); i++) {
                SparseArray<ScrapData> sparseArray = this.mScrap;
                ScrapData scrapData = sparseArray.get(sparseArray.keyAt(i));
                if (scrapData != null) {
                    ArrayList<ViewHolder> arrayList = scrapData.mScrapHeap;
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        if (arrayList.get(i2) != null && arrayList.get(i2).itemView != null) {
                            PoolingContainer.callPoolingContainerOnRelease(arrayList.get(i2).itemView);
                        }
                    }
                }
            }
        }

        public void factorInBindTime(int i, long j) {
            ScrapData scrapDataForType = getScrapDataForType(i);
            scrapDataForType.mBindRunningAverageNs = runningAverage(scrapDataForType.mBindRunningAverageNs, j);
        }

        public void factorInCreateTime(int i, long j) {
            ScrapData scrapDataForType = getScrapDataForType(i);
            scrapDataForType.mCreateRunningAverageNs = runningAverage(scrapDataForType.mCreateRunningAverageNs, j);
        }

        @Nullable
        public ViewHolder getRecycledView(int i) {
            ScrapData scrapData = this.mScrap.get(i);
            if (scrapData == null || scrapData.mScrapHeap.isEmpty()) {
                return null;
            }
            ArrayList<ViewHolder> arrayList = scrapData.mScrapHeap;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size) == null) {
                    StringBuilder sbM778t = AbstractC0541b.m778t(size, "ViewHolder object null when getRecycledView is in progress. pos= ", " size=");
                    sbM778t.append(arrayList.size());
                    sbM778t.append(" max= ");
                    sbM778t.append(scrapData.mMaxScrap);
                    sbM778t.append(" holder= ");
                    sbM778t.append(size());
                    sbM778t.append(" scrapHeap= ");
                    sbM778t.append(arrayList);
                    Log.e(RecyclerView.TAG, sbM778t.toString());
                } else if (!arrayList.get(size).isAttachedToTransitionOverlay()) {
                    return arrayList.remove(size);
                }
            }
            return null;
        }

        public int getRecycledViewCount(int i) {
            return getScrapDataForType(i).mScrapHeap.size();
        }

        public void onAdapterChanged(Adapter<?> adapter, Adapter<?> adapter2, boolean z) {
            if (adapter != null) {
                detach();
            }
            if (!z && this.mAttachCountForClearing == 0) {
                clear();
            }
            if (adapter2 != null) {
                attach();
            }
        }

        public void putRecycledView(ViewHolder viewHolder) {
            int itemViewType = viewHolder.getItemViewType();
            ArrayList<ViewHolder> arrayList = getScrapDataForType(itemViewType).mScrapHeap;
            if (this.mScrap.get(itemViewType).mMaxScrap <= arrayList.size()) {
                PoolingContainer.callPoolingContainerOnRelease(viewHolder.itemView);
            } else {
                if (RecyclerView.sDebugAssertionsEnabled && arrayList.contains(viewHolder)) {
                    throw new IllegalArgumentException("this scrap item already exists");
                }
                viewHolder.resetInternal();
                arrayList.add(viewHolder);
            }
        }

        public long runningAverage(long j, long j2) {
            if (j == 0) {
                return j2;
            }
            return (j2 / 4) + ((j / 4) * 3);
        }

        public void setMaxRecycledViews(int i, int i2) {
            ScrapData scrapDataForType = getScrapDataForType(i);
            scrapDataForType.mMaxScrap = i2;
            ArrayList<ViewHolder> arrayList = scrapDataForType.mScrapHeap;
            while (arrayList.size() > i2) {
                arrayList.remove(arrayList.size() - 1);
            }
        }

        public int size() {
            int size = 0;
            for (int i = 0; i < this.mScrap.size(); i++) {
                ArrayList<ViewHolder> arrayList = this.mScrap.valueAt(i).mScrapHeap;
                if (arrayList != null) {
                    size = arrayList.size() + size;
                }
            }
            return size;
        }

        public boolean willBindInTime(int i, long j, long j2) {
            long j3 = getScrapDataForType(i).mBindRunningAverageNs;
            return j3 == 0 || j + j3 < j2;
        }

        public boolean willCreateInTime(int i, long j, long j2) {
            long j3 = getScrapDataForType(i).mCreateRunningAverageNs;
            return j3 == 0 || j + j3 < j2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class Recycler {
        static final int DEFAULT_CACHE_SIZE = 2;
        final ArrayList<ViewHolder> mAttachedScrap;
        final ArrayList<ViewHolder> mCachedViews;
        ArrayList<ViewHolder> mChangedScrap;
        RecycledViewPool mRecyclerPool;
        private int mRequestedCacheMax;
        private final List<ViewHolder> mUnmodifiableAttachedScrap;
        private ViewCacheExtension mViewCacheExtension;
        int mViewCacheMax;

        public Recycler() {
            ArrayList<ViewHolder> arrayList = new ArrayList<>();
            this.mAttachedScrap = arrayList;
            this.mChangedScrap = null;
            this.mCachedViews = new ArrayList<>();
            this.mUnmodifiableAttachedScrap = Collections.unmodifiableList(arrayList);
            this.mRequestedCacheMax = 2;
            this.mViewCacheMax = 2;
        }

        private void attachAccessibilityDelegateOnBind(ViewHolder viewHolder) {
            if (RecyclerView.this.isAccessibilityEnabled()) {
                View view = viewHolder.itemView;
                if (ViewCompat.getImportantForAccessibility(view) == 0) {
                    ViewCompat.setImportantForAccessibility(view, 1);
                }
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.mAccessibilityDelegate == null) {
                    recyclerView.setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(RecyclerView.this));
                    Log.d(RecyclerView.TAG, "attachAccessibilityDelegate: mAccessibilityDelegate is null, so re create");
                }
                AccessibilityDelegateCompat itemDelegate = RecyclerView.this.mAccessibilityDelegate.getItemDelegate();
                if (itemDelegate instanceof RecyclerViewAccessibilityDelegate.ItemDelegate) {
                    ((RecyclerViewAccessibilityDelegate.ItemDelegate) itemDelegate).saveOriginalDelegate(view);
                }
                ViewCompat.setAccessibilityDelegate(view, itemDelegate);
            }
        }

        private void invalidateDisplayListInt(ViewHolder viewHolder) {
            View view = viewHolder.itemView;
            if (view instanceof ViewGroup) {
                invalidateDisplayListInt((ViewGroup) view, false);
            }
        }

        private void maybeSendPoolingContainerAttach() {
            if (this.mRecyclerPool != null) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.mAdapter == null || !recyclerView.isAttachedToWindow()) {
                    return;
                }
                this.mRecyclerPool.attachForPoolingContainer(RecyclerView.this.mAdapter);
            }
        }

        private void poolingContainerDetach(Adapter<?> adapter) {
            poolingContainerDetach(adapter, false);
        }

        private boolean tryBindViewHolderByDeadline(@NonNull ViewHolder viewHolder, int i, int i2, long j) {
            viewHolder.mBindingAdapter = null;
            viewHolder.mOwnerRecyclerView = RecyclerView.this;
            int itemViewType = viewHolder.getItemViewType();
            long nanoTime = RecyclerView.this.getNanoTime();
            boolean z = false;
            if (j != Long.MAX_VALUE && !this.mRecyclerPool.willBindInTime(itemViewType, nanoTime, j)) {
                return false;
            }
            if (viewHolder.isTmpDetached() && RecyclerView.this.indexOfChild(viewHolder.itemView) > 0) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.attachViewToParent(viewHolder.itemView, recyclerView.getChildCount(), viewHolder.itemView.getLayoutParams());
                z = true;
            }
            RecyclerView.this.mAdapter.bindViewHolder(viewHolder, i);
            if (z) {
                RecyclerView.this.detachViewFromParent(viewHolder.itemView);
            }
            this.mRecyclerPool.factorInBindTime(viewHolder.getItemViewType(), RecyclerView.this.getNanoTime() - nanoTime);
            attachAccessibilityDelegateOnBind(viewHolder);
            if (RecyclerView.this.mState.isPreLayout()) {
                viewHolder.mPreLayoutPosition = i2;
            }
            return true;
        }

        public void addViewHolderToRecycledViewPool(@NonNull ViewHolder viewHolder, boolean z) {
            RecyclerView.clearNestedRecyclerViewIfNotNested(viewHolder);
            View view = viewHolder.itemView;
            RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate = RecyclerView.this.mAccessibilityDelegate;
            if (recyclerViewAccessibilityDelegate != null) {
                AccessibilityDelegateCompat itemDelegate = recyclerViewAccessibilityDelegate.getItemDelegate();
                ViewCompat.setAccessibilityDelegate(view, itemDelegate instanceof RecyclerViewAccessibilityDelegate.ItemDelegate ? ((RecyclerViewAccessibilityDelegate.ItemDelegate) itemDelegate).getAndRemoveOriginalDelegateForItem(view) : null);
            }
            if (z) {
                dispatchViewRecycled(viewHolder);
            }
            viewHolder.mBindingAdapter = null;
            viewHolder.mOwnerRecyclerView = null;
            getRecycledViewPool().putRecycledView(viewHolder);
        }

        public void bindViewToPosition(@NonNull View view, int i) {
            LayoutParams layoutParams;
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt == null) {
                throw new IllegalArgumentException(AbstractC2821a.m2219j(RecyclerView.this, new StringBuilder("The view does not have a ViewHolder. You cannot pass arbitrary views to this method, they should be created by the Adapter")));
            }
            int iFindPositionOffset = RecyclerView.this.mAdapterHelper.findPositionOffset(i);
            if (iFindPositionOffset < 0 || iFindPositionOffset >= RecyclerView.this.mAdapter.getItemCount()) {
                StringBuilder sbM1173s = AbstractC0622a.m1173s(i, iFindPositionOffset, "Inconsistency detected. Invalid item position ", "(offset:", ").state:");
                sbM1173s.append(RecyclerView.this.mState.getItemCount());
                throw new IndexOutOfBoundsException(AbstractC2821a.m2219j(RecyclerView.this, sbM1173s));
            }
            tryBindViewHolderByDeadline(childViewHolderInt, iFindPositionOffset, i, Long.MAX_VALUE);
            ViewGroup.LayoutParams layoutParams2 = childViewHolderInt.itemView.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams = (LayoutParams) RecyclerView.this.generateDefaultLayoutParams();
                childViewHolderInt.itemView.setLayoutParams(layoutParams);
            } else if (RecyclerView.this.checkLayoutParams(layoutParams2)) {
                layoutParams = (LayoutParams) layoutParams2;
            } else {
                layoutParams = (LayoutParams) RecyclerView.this.generateLayoutParams(layoutParams2);
                childViewHolderInt.itemView.setLayoutParams(layoutParams);
            }
            layoutParams.mInsetsDirty = true;
            layoutParams.mViewHolder = childViewHolderInt;
            layoutParams.mPendingInvalidate = childViewHolderInt.itemView.getParent() == null;
        }

        public void clear() {
            this.mAttachedScrap.clear();
            recycleAndClearCachedViews();
        }

        public void clearOldPositions() {
            int size = this.mCachedViews.size();
            for (int i = 0; i < size; i++) {
                this.mCachedViews.get(i).clearOldPosition();
            }
            int size2 = this.mAttachedScrap.size();
            for (int i2 = 0; i2 < size2; i2++) {
                this.mAttachedScrap.get(i2).clearOldPosition();
            }
            ArrayList<ViewHolder> arrayList = this.mChangedScrap;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i4 = 0; i4 < size3; i4++) {
                    this.mChangedScrap.get(i4).clearOldPosition();
                }
            }
        }

        public void clearScrap() {
            this.mAttachedScrap.clear();
            ArrayList<ViewHolder> arrayList = this.mChangedScrap;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        public int convertPreLayoutPositionToPostLayout(int i) {
            if (i >= 0 && i < RecyclerView.this.mState.getItemCount()) {
                return !RecyclerView.this.mState.isPreLayout() ? i : RecyclerView.this.mAdapterHelper.findPositionOffset(i);
            }
            StringBuilder sbM778t = AbstractC0541b.m778t(i, "invalid position ", ". State item count is ");
            sbM778t.append(RecyclerView.this.mState.getItemCount());
            throw new IndexOutOfBoundsException(AbstractC2821a.m2219j(RecyclerView.this, sbM778t));
        }

        public void dispatchViewRecycled(@NonNull ViewHolder viewHolder) {
            RecyclerListener recyclerListener = RecyclerView.this.mRecyclerListener;
            if (recyclerListener != null) {
                recyclerListener.onViewRecycled(viewHolder);
            }
            int size = RecyclerView.this.mRecyclerListeners.size();
            for (int i = 0; i < size; i++) {
                RecyclerView.this.mRecyclerListeners.get(i).onViewRecycled(viewHolder);
            }
            Adapter adapter = RecyclerView.this.mAdapter;
            if (adapter != null) {
                adapter.onViewRecycled(viewHolder);
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mState != null) {
                recyclerView.mViewInfoStore.removeViewHolder(viewHolder);
            }
            if (RecyclerView.sVerboseLoggingEnabled) {
                Log.d(RecyclerView.TAG, "dispatchViewRecycled: " + viewHolder);
            }
        }

        public ViewHolder getChangedScrapViewForPosition(int i) {
            int size;
            int iFindPositionOffset;
            ArrayList<ViewHolder> arrayList = this.mChangedScrap;
            if (arrayList != null && (size = arrayList.size()) != 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    ViewHolder viewHolder = this.mChangedScrap.get(i2);
                    if (!viewHolder.wasReturnedFromScrap() && viewHolder.getLayoutPosition() == i) {
                        viewHolder.addFlags(32);
                        return viewHolder;
                    }
                }
                if (RecyclerView.this.mAdapter.hasStableIds() && (iFindPositionOffset = RecyclerView.this.mAdapterHelper.findPositionOffset(i)) > 0 && iFindPositionOffset < RecyclerView.this.mAdapter.getItemCount()) {
                    long itemId = RecyclerView.this.mAdapter.getItemId(iFindPositionOffset);
                    for (int i4 = 0; i4 < size; i4++) {
                        ViewHolder viewHolder2 = this.mChangedScrap.get(i4);
                        if (!viewHolder2.wasReturnedFromScrap() && viewHolder2.getItemId() == itemId) {
                            viewHolder2.addFlags(32);
                            return viewHolder2;
                        }
                    }
                }
            }
            return null;
        }

        public RecycledViewPool getRecycledViewPool() {
            if (this.mRecyclerPool == null) {
                this.mRecyclerPool = new RecycledViewPool();
                maybeSendPoolingContainerAttach();
            }
            return this.mRecyclerPool;
        }

        public int getScrapCount() {
            return this.mAttachedScrap.size();
        }

        @NonNull
        public List<ViewHolder> getScrapList() {
            return this.mUnmodifiableAttachedScrap;
        }

        public ViewHolder getScrapOrCachedViewForId(long j, int i, boolean z) {
            for (int size = this.mAttachedScrap.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = this.mAttachedScrap.get(size);
                if (viewHolder.getItemId() == j && !viewHolder.wasReturnedFromScrap()) {
                    if (i == viewHolder.getItemViewType()) {
                        viewHolder.addFlags(32);
                        if (viewHolder.isRemoved() && !RecyclerView.this.mState.isPreLayout()) {
                            viewHolder.setFlags(2, 14);
                        }
                        return viewHolder;
                    }
                    if (!z) {
                        this.mAttachedScrap.remove(size);
                        RecyclerView.this.removeDetachedView(viewHolder.itemView, false);
                        quickRecycleScrapView(viewHolder.itemView);
                    }
                }
            }
            int size2 = this.mCachedViews.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                ViewHolder viewHolder2 = this.mCachedViews.get(size2);
                if (viewHolder2.getItemId() == j && !viewHolder2.isAttachedToTransitionOverlay()) {
                    if (i == viewHolder2.getItemViewType()) {
                        if (!z) {
                            this.mCachedViews.remove(size2);
                        }
                        return viewHolder2;
                    }
                    if (!z) {
                        recycleCachedViewAt(size2);
                        return null;
                    }
                }
            }
        }

        public ViewHolder getScrapOrHiddenOrCachedHolderForPosition(int i, boolean z) {
            View viewFindHiddenNonRemovedView;
            int size = this.mAttachedScrap.size();
            for (int i2 = 0; i2 < size; i2++) {
                ViewHolder viewHolder = this.mAttachedScrap.get(i2);
                if (!viewHolder.wasReturnedFromScrap() && viewHolder.getLayoutPosition() == i && !viewHolder.isInvalid() && (RecyclerView.this.mState.mInPreLayout || !viewHolder.isRemoved())) {
                    viewHolder.addFlags(32);
                    return viewHolder;
                }
            }
            if (!z && (viewFindHiddenNonRemovedView = RecyclerView.this.mChildHelper.findHiddenNonRemovedView(i)) != null) {
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(viewFindHiddenNonRemovedView);
                RecyclerView.this.mChildHelper.unhide(viewFindHiddenNonRemovedView);
                int iIndexOfChild = RecyclerView.this.mChildHelper.indexOfChild(viewFindHiddenNonRemovedView);
                if (iIndexOfChild == -1) {
                    StringBuilder sb = new StringBuilder("layout index should not be -1 after unhiding a view:");
                    sb.append(childViewHolderInt);
                    throw new IllegalStateException(AbstractC2821a.m2219j(RecyclerView.this, sb));
                }
                RecyclerView.this.mChildHelper.detachViewFromParent(iIndexOfChild);
                scrapView(viewFindHiddenNonRemovedView);
                childViewHolderInt.addFlags(8224);
                return childViewHolderInt;
            }
            int size2 = this.mCachedViews.size();
            for (int i4 = 0; i4 < size2; i4++) {
                ViewHolder viewHolder2 = this.mCachedViews.get(i4);
                if (!viewHolder2.isInvalid() && viewHolder2.getLayoutPosition() == i && !viewHolder2.isAttachedToTransitionOverlay()) {
                    if (!z) {
                        this.mCachedViews.remove(i4);
                    }
                    if (RecyclerView.sVerboseLoggingEnabled) {
                        Log.d(RecyclerView.TAG, "getScrapOrHiddenOrCachedHolderForPosition(" + i + ") found match in cache: " + viewHolder2);
                    }
                    return viewHolder2;
                }
            }
            return null;
        }

        public View getScrapViewAt(int i) {
            return this.mAttachedScrap.get(i).itemView;
        }

        @NonNull
        public View getViewForPosition(int i) {
            return getViewForPosition(i, false);
        }

        public void markItemDecorInsetsDirty() {
            int size = this.mCachedViews.size();
            for (int i = 0; i < size; i++) {
                LayoutParams layoutParams = (LayoutParams) this.mCachedViews.get(i).itemView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.mInsetsDirty = true;
                }
            }
        }

        public void markKnownViewsInvalid() {
            int size = this.mCachedViews.size();
            for (int i = 0; i < size; i++) {
                ViewHolder viewHolder = this.mCachedViews.get(i);
                if (viewHolder != null) {
                    viewHolder.addFlags(6);
                    viewHolder.addChangePayload(null);
                }
            }
            Adapter adapter = RecyclerView.this.mAdapter;
            if (adapter == null || !adapter.hasStableIds()) {
                recycleAndClearCachedViews();
            }
        }

        public void offsetPositionRecordsForInsert(int i, int i2) {
            int size = this.mCachedViews.size();
            for (int i4 = 0; i4 < size; i4++) {
                ViewHolder viewHolder = this.mCachedViews.get(i4);
                if (viewHolder != null && viewHolder.mPosition >= i) {
                    if (RecyclerView.sVerboseLoggingEnabled) {
                        Log.d(RecyclerView.TAG, "offsetPositionRecordsForInsert cached " + i4 + " holder " + viewHolder + " now at position " + (viewHolder.mPosition + i2));
                    }
                    viewHolder.offsetPosition(i2, true);
                }
            }
        }

        public void offsetPositionRecordsForMove(int i, int i2) {
            int i4;
            int i5;
            int i6;
            int i7;
            if (i < i2) {
                i4 = -1;
                i6 = i;
                i5 = i2;
            } else {
                i4 = 1;
                i5 = i;
                i6 = i2;
            }
            int size = this.mCachedViews.size();
            for (int i8 = 0; i8 < size; i8++) {
                ViewHolder viewHolder = this.mCachedViews.get(i8);
                if (viewHolder != null && (i7 = viewHolder.mPosition) >= i6 && i7 <= i5) {
                    if (i7 == i) {
                        viewHolder.offsetPosition(i2 - i, false);
                    } else {
                        viewHolder.offsetPosition(i4, false);
                    }
                    if (RecyclerView.sVerboseLoggingEnabled) {
                        Log.d(RecyclerView.TAG, "offsetPositionRecordsForMove cached child " + i8 + " holder " + viewHolder);
                    }
                }
            }
        }

        public void offsetPositionRecordsForRemove(int i, int i2, boolean z) {
            int i4 = i + i2;
            for (int size = this.mCachedViews.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = this.mCachedViews.get(size);
                if (viewHolder != null) {
                    int i5 = viewHolder.mPosition;
                    if (i5 >= i4) {
                        if (RecyclerView.sVerboseLoggingEnabled) {
                            Log.d(RecyclerView.TAG, "offsetPositionRecordsForRemove cached " + size + " holder " + viewHolder + " now at position " + (viewHolder.mPosition - i2));
                        }
                        viewHolder.offsetPosition(-i2, z);
                    } else if (i5 >= i) {
                        viewHolder.addFlags(8);
                        recycleCachedViewAt(size);
                    }
                }
            }
        }

        public void onAdapterChanged(Adapter<?> adapter, Adapter<?> adapter2, boolean z) {
            clear();
            poolingContainerDetach(adapter, true);
            getRecycledViewPool().onAdapterChanged(adapter, adapter2, z);
            maybeSendPoolingContainerAttach();
        }

        public void onAttachedToWindow() {
            maybeSendPoolingContainerAttach();
        }

        public void onDetachedFromWindow() {
            for (int i = 0; i < this.mCachedViews.size(); i++) {
                PoolingContainer.callPoolingContainerOnRelease(this.mCachedViews.get(i).itemView);
            }
            poolingContainerDetach(RecyclerView.this.mAdapter);
        }

        public void quickRecycleScrapView(View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.mScrapContainer = null;
            childViewHolderInt.mInChangeScrap = false;
            childViewHolderInt.clearReturnedFromScrapFlag();
            recycleViewHolderInternal(childViewHolderInt);
        }

        public void recycleAndClearCachedViews() {
            for (int size = this.mCachedViews.size() - 1; size >= 0; size--) {
                recycleCachedViewAt(size);
            }
            this.mCachedViews.clear();
            if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                RecyclerView.this.mPrefetchRegistry.clearPrefetchPositions();
            }
        }

        public void recycleCachedViewAt(int i) {
            if (RecyclerView.sVerboseLoggingEnabled) {
                AbstractC0541b.m755A(i, "Recycling cached view at index ", RecyclerView.TAG);
            }
            ViewHolder viewHolder = this.mCachedViews.get(i);
            if (RecyclerView.sVerboseLoggingEnabled) {
                Log.d(RecyclerView.TAG, "CachedViewHolder to be recycled: " + viewHolder);
            }
            addViewHolderToRecycledViewPool(viewHolder, true);
            this.mCachedViews.remove(i);
        }

        public void recycleView(@NonNull View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (childViewHolderInt.isScrap()) {
                childViewHolderInt.unScrap();
            } else if (childViewHolderInt.wasReturnedFromScrap()) {
                childViewHolderInt.clearReturnedFromScrapFlag();
            }
            recycleViewHolderInternal(childViewHolderInt);
            if (RecyclerView.this.mItemAnimator == null || childViewHolderInt.isRecyclable()) {
                return;
            }
            RecyclerView.this.mItemAnimator.endAnimation(childViewHolderInt);
        }

        public void recycleViewHolderInternal(ViewHolder viewHolder) {
            boolean z;
            boolean z2 = true;
            if (viewHolder.isScrap() || viewHolder.itemView.getParent() != null) {
                StringBuilder sb = new StringBuilder("Scrapped or attached views may not be recycled. isScrap:");
                sb.append(viewHolder.isScrap());
                sb.append(" isAttached:");
                sb.append(viewHolder.itemView.getParent() != null);
                throw new IllegalArgumentException(AbstractC2821a.m2219j(RecyclerView.this, sb));
            }
            if (viewHolder.isTmpDetached()) {
                StringBuilder sb2 = new StringBuilder("Tmp detached view should be removed from RecyclerView before it can be recycled: ");
                sb2.append(viewHolder);
                throw new IllegalArgumentException(AbstractC2821a.m2219j(RecyclerView.this, sb2));
            }
            if (viewHolder.shouldIgnore()) {
                throw new IllegalArgumentException(AbstractC2821a.m2219j(RecyclerView.this, new StringBuilder("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.")));
            }
            boolean zDoesTransientStatePreventRecycling = viewHolder.doesTransientStatePreventRecycling();
            Adapter adapter = RecyclerView.this.mAdapter;
            boolean z3 = adapter != null && zDoesTransientStatePreventRecycling && adapter.onFailedToRecycleView(viewHolder);
            if (RecyclerView.sDebugAssertionsEnabled && this.mCachedViews.contains(viewHolder)) {
                StringBuilder sb3 = new StringBuilder("cached view received recycle internal? ");
                sb3.append(viewHolder);
                throw new IllegalArgumentException(AbstractC2821a.m2219j(RecyclerView.this, sb3));
            }
            if (z3 || viewHolder.isRecyclable()) {
                if (this.mViewCacheMax <= 0 || viewHolder.hasAnyOfTheFlags(526)) {
                    z = false;
                } else {
                    int size = this.mCachedViews.size();
                    if (size >= this.mViewCacheMax && size > 0) {
                        recycleCachedViewAt(0);
                        size--;
                    }
                    if (RecyclerView.ALLOW_THREAD_GAP_WORK && size > 0 && !RecyclerView.this.mPrefetchRegistry.lastPrefetchIncludedPosition(viewHolder.mPosition)) {
                        int i = size - 1;
                        while (i >= 0) {
                            if (!RecyclerView.this.mPrefetchRegistry.lastPrefetchIncludedPosition(this.mCachedViews.get(i).mPosition)) {
                                break;
                            } else {
                                i--;
                            }
                        }
                        size = i + 1;
                    }
                    this.mCachedViews.add(size, viewHolder);
                    z = true;
                }
                if (z) {
                    z2 = false;
                } else {
                    addViewHolderToRecycledViewPool(viewHolder, true);
                }
                z = z;
            } else {
                if (RecyclerView.sVerboseLoggingEnabled) {
                    Log.d(RecyclerView.TAG, "trying to recycle a non-recycleable holder. Hopefully, it will re-visit here. We are still removing it from animation lists" + RecyclerView.this.exceptionLabel());
                }
                z2 = false;
            }
            RecyclerView.this.mViewInfoStore.removeViewHolder(viewHolder);
            if (z || z2 || !zDoesTransientStatePreventRecycling) {
                return;
            }
            PoolingContainer.callPoolingContainerOnRelease(viewHolder.itemView);
            viewHolder.mBindingAdapter = null;
            viewHolder.mOwnerRecyclerView = null;
        }

        public void scrapView(View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (!childViewHolderInt.hasAnyOfTheFlags(12) && childViewHolderInt.isUpdated() && !RecyclerView.this.canReuseUpdatedViewHolder(childViewHolderInt)) {
                if (this.mChangedScrap == null) {
                    this.mChangedScrap = new ArrayList<>();
                }
                childViewHolderInt.setScrapContainer(this, true);
                this.mChangedScrap.add(childViewHolderInt);
                return;
            }
            if (childViewHolderInt.isInvalid() && !childViewHolderInt.isRemoved() && !RecyclerView.this.mAdapter.hasStableIds()) {
                throw new IllegalArgumentException(AbstractC2821a.m2219j(RecyclerView.this, new StringBuilder("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.")));
            }
            childViewHolderInt.setScrapContainer(this, false);
            this.mAttachedScrap.add(childViewHolderInt);
        }

        public void setRecycledViewPool(RecycledViewPool recycledViewPool) {
            poolingContainerDetach(RecyclerView.this.mAdapter);
            RecycledViewPool recycledViewPool2 = this.mRecyclerPool;
            if (recycledViewPool2 != null) {
                recycledViewPool2.detach();
            }
            this.mRecyclerPool = recycledViewPool;
            if (recycledViewPool != null && RecyclerView.this.getAdapter() != null) {
                this.mRecyclerPool.attach();
            }
            maybeSendPoolingContainerAttach();
        }

        public void setViewCacheExtension(ViewCacheExtension viewCacheExtension) {
            this.mViewCacheExtension = viewCacheExtension;
        }

        public void setViewCacheSize(int i) {
            this.mRequestedCacheMax = i;
            updateViewCacheSize();
        }

        /* JADX WARN: Removed duplicated region for block: B:110:0x0212  */
        /* JADX WARN: Removed duplicated region for block: B:111:0x0220  */
        /* JADX WARN: Removed duplicated region for block: B:117:0x023c A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:119:0x023f  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:86:0x019a  */
        /* JADX WARN: Removed duplicated region for block: B:92:0x01c6  */
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public ViewHolder tryGetViewHolderForPositionByDeadline(int i, boolean z, long j) {
            ViewHolder viewHolderCreateViewHolder;
            boolean z2;
            ViewHolder viewHolder;
            boolean z3;
            boolean zTryBindViewHolderByDeadline;
            ViewGroup.LayoutParams layoutParams;
            LayoutParams layoutParams2;
            RecyclerView recyclerViewFindNestedRecyclerView;
            ViewCacheExtension viewCacheExtension;
            View viewForPositionAndType;
            if (i < 0 || i >= RecyclerView.this.mState.getItemCount()) {
                StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i, "Invalid item position ", "(", "). Item count:");
                sbM1173s.append(RecyclerView.this.mState.getItemCount());
                throw new IndexOutOfBoundsException(AbstractC2821a.m2219j(RecyclerView.this, sbM1173s));
            }
            if (RecyclerView.this.mState.isPreLayout()) {
                viewHolderCreateViewHolder = getChangedScrapViewForPosition(i);
                if (viewHolderCreateViewHolder != null) {
                    z2 = true;
                }
                if (viewHolderCreateViewHolder == null && (viewHolderCreateViewHolder = getScrapOrHiddenOrCachedHolderForPosition(i, z)) != null) {
                    if (validateViewHolderForOffsetPosition(viewHolderCreateViewHolder)) {
                        if (!z) {
                            viewHolderCreateViewHolder.addFlags(4);
                            if (viewHolderCreateViewHolder.isScrap()) {
                                RecyclerView.this.removeDetachedView(viewHolderCreateViewHolder.itemView, false);
                                viewHolderCreateViewHolder.unScrap();
                            } else if (viewHolderCreateViewHolder.wasReturnedFromScrap()) {
                                viewHolderCreateViewHolder.clearReturnedFromScrapFlag();
                            }
                            recycleViewHolderInternal(viewHolderCreateViewHolder);
                        }
                        viewHolderCreateViewHolder = null;
                    } else {
                        z2 = true;
                    }
                }
                if (viewHolderCreateViewHolder == null) {
                    int iFindPositionOffset = RecyclerView.this.mAdapterHelper.findPositionOffset(i);
                    if (iFindPositionOffset < 0 || iFindPositionOffset >= RecyclerView.this.mAdapter.getItemCount()) {
                        StringBuilder sbM1173s2 = AbstractC0622a.m1173s(i, iFindPositionOffset, "Inconsistency detected. Invalid item position ", "(offset:", ").state:");
                        sbM1173s2.append(RecyclerView.this.mState.getItemCount());
                        throw new IndexOutOfBoundsException(AbstractC2821a.m2219j(RecyclerView.this, sbM1173s2));
                    }
                    int itemViewType = RecyclerView.this.mAdapter.getItemViewType(iFindPositionOffset);
                    if (RecyclerView.this.mAdapter.hasStableIds() && (viewHolderCreateViewHolder = getScrapOrCachedViewForId(RecyclerView.this.mAdapter.getItemId(iFindPositionOffset), itemViewType, z)) != null) {
                        viewHolderCreateViewHolder.mPosition = iFindPositionOffset;
                        z2 = true;
                    }
                    if (viewHolderCreateViewHolder == null && (viewCacheExtension = this.mViewCacheExtension) != null && (viewForPositionAndType = viewCacheExtension.getViewForPositionAndType(this, i, itemViewType)) != null) {
                        viewHolderCreateViewHolder = RecyclerView.this.getChildViewHolder(viewForPositionAndType);
                        if (viewHolderCreateViewHolder == null) {
                            throw new IllegalArgumentException(AbstractC2821a.m2219j(RecyclerView.this, new StringBuilder("getViewForPositionAndType returned a view which does not have a ViewHolder")));
                        }
                        if (viewHolderCreateViewHolder.shouldIgnore()) {
                            throw new IllegalArgumentException(AbstractC2821a.m2219j(RecyclerView.this, new StringBuilder("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.")));
                        }
                    }
                    if (viewHolderCreateViewHolder == null) {
                        if (RecyclerView.sVerboseLoggingEnabled) {
                            Log.d(RecyclerView.TAG, "tryGetViewHolderForPositionByDeadline(" + i + ") fetching from shared pool");
                        }
                        viewHolderCreateViewHolder = getRecycledViewPool().getRecycledView(itemViewType);
                        if (viewHolderCreateViewHolder != null) {
                            viewHolderCreateViewHolder.resetInternal();
                            if (RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST) {
                                invalidateDisplayListInt(viewHolderCreateViewHolder);
                            }
                        }
                    }
                    if (viewHolderCreateViewHolder == null) {
                        long nanoTime = RecyclerView.this.getNanoTime();
                        if (j != Long.MAX_VALUE && !this.mRecyclerPool.willCreateInTime(itemViewType, nanoTime, j)) {
                            return null;
                        }
                        RecyclerView recyclerView = RecyclerView.this;
                        viewHolderCreateViewHolder = recyclerView.mAdapter.createViewHolder(recyclerView, itemViewType);
                        if (RecyclerView.ALLOW_THREAD_GAP_WORK && (recyclerViewFindNestedRecyclerView = RecyclerView.findNestedRecyclerView(viewHolderCreateViewHolder.itemView)) != null) {
                            viewHolderCreateViewHolder.mNestedRecyclerView = new WeakReference<>(recyclerViewFindNestedRecyclerView);
                        }
                        this.mRecyclerPool.factorInCreateTime(itemViewType, RecyclerView.this.getNanoTime() - nanoTime);
                        if (RecyclerView.sVerboseLoggingEnabled) {
                            Log.d(RecyclerView.TAG, "tryGetViewHolderForPositionByDeadline created new ViewHolder");
                        }
                    }
                }
                viewHolder = viewHolderCreateViewHolder;
                z3 = z2;
                if (z3 && !RecyclerView.this.mState.isPreLayout() && viewHolder.hasAnyOfTheFlags(8192)) {
                    viewHolder.setFlags(0, 8192);
                    if (RecyclerView.this.mState.mRunSimpleAnimations) {
                        int iBuildAdapterChangeFlagsForAnimations = ItemAnimator.buildAdapterChangeFlagsForAnimations(viewHolder) | 4096;
                        RecyclerView recyclerView2 = RecyclerView.this;
                        RecyclerView.this.recordAnimationInfoIfBouncedHiddenView(viewHolder, recyclerView2.mItemAnimator.recordPreLayoutInformation(recyclerView2.mState, viewHolder, iBuildAdapterChangeFlagsForAnimations, viewHolder.getUnmodifiedPayloads()));
                    }
                }
                if (RecyclerView.this.mState.isPreLayout() || !viewHolder.isBound()) {
                    if (viewHolder.isBound() || viewHolder.needsUpdate() || viewHolder.isInvalid()) {
                        if (!RecyclerView.sDebugAssertionsEnabled && viewHolder.isRemoved()) {
                            StringBuilder sb = new StringBuilder("Removed holder should be bound and it should come here only in pre-layout. Holder: ");
                            sb.append(viewHolder);
                            throw new IllegalStateException(AbstractC2821a.m2219j(RecyclerView.this, sb));
                        }
                        zTryBindViewHolderByDeadline = tryBindViewHolderByDeadline(viewHolder, RecyclerView.this.mAdapterHelper.findPositionOffset(i), i, j);
                    }
                    layoutParams = viewHolder.itemView.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams2 = (LayoutParams) RecyclerView.this.generateDefaultLayoutParams();
                        viewHolder.itemView.setLayoutParams(layoutParams2);
                    } else if (RecyclerView.this.checkLayoutParams(layoutParams)) {
                        layoutParams2 = (LayoutParams) layoutParams;
                    } else {
                        layoutParams2 = (LayoutParams) RecyclerView.this.generateLayoutParams(layoutParams);
                        viewHolder.itemView.setLayoutParams(layoutParams2);
                    }
                    layoutParams2.mViewHolder = viewHolder;
                    layoutParams2.mPendingInvalidate = z3 && zTryBindViewHolderByDeadline;
                    return viewHolder;
                }
                viewHolder.mPreLayoutPosition = i;
                zTryBindViewHolderByDeadline = false;
                layoutParams = viewHolder.itemView.getLayoutParams();
                if (layoutParams == null) {
                }
                layoutParams2.mViewHolder = viewHolder;
                layoutParams2.mPendingInvalidate = z3 && zTryBindViewHolderByDeadline;
                return viewHolder;
            }
            viewHolderCreateViewHolder = null;
            z2 = false;
            if (viewHolderCreateViewHolder == null) {
                if (validateViewHolderForOffsetPosition(viewHolderCreateViewHolder)) {
                }
            }
            if (viewHolderCreateViewHolder == null) {
            }
            viewHolder = viewHolderCreateViewHolder;
            z3 = z2;
            if (z3) {
                viewHolder.setFlags(0, 8192);
                if (RecyclerView.this.mState.mRunSimpleAnimations) {
                }
            }
            if (RecyclerView.this.mState.isPreLayout()) {
                if (viewHolder.isBound()) {
                }
                if (!RecyclerView.sDebugAssertionsEnabled) {
                }
                zTryBindViewHolderByDeadline = tryBindViewHolderByDeadline(viewHolder, RecyclerView.this.mAdapterHelper.findPositionOffset(i), i, j);
            }
            layoutParams = viewHolder.itemView.getLayoutParams();
            if (layoutParams == null) {
            }
            layoutParams2.mViewHolder = viewHolder;
            layoutParams2.mPendingInvalidate = z3 && zTryBindViewHolderByDeadline;
            return viewHolder;
        }

        public void unscrapView(ViewHolder viewHolder) {
            if (viewHolder.mInChangeScrap) {
                this.mChangedScrap.remove(viewHolder);
            } else {
                this.mAttachedScrap.remove(viewHolder);
            }
            viewHolder.mScrapContainer = null;
            viewHolder.mInChangeScrap = false;
            viewHolder.clearReturnedFromScrapFlag();
        }

        public void updateViewCacheSize() {
            LayoutManager layoutManager = RecyclerView.this.mLayout;
            this.mViewCacheMax = this.mRequestedCacheMax + (layoutManager != null ? layoutManager.mPrefetchMaxCountObserved : 0);
            for (int size = this.mCachedViews.size() - 1; size >= 0 && this.mCachedViews.size() > this.mViewCacheMax; size--) {
                recycleCachedViewAt(size);
            }
        }

        public boolean validateViewHolderForOffsetPosition(ViewHolder viewHolder) {
            if (viewHolder.isRemoved()) {
                if (!RecyclerView.sDebugAssertionsEnabled || RecyclerView.this.mState.isPreLayout()) {
                    return RecyclerView.this.mState.isPreLayout();
                }
                throw new IllegalStateException(AbstractC2821a.m2219j(RecyclerView.this, new StringBuilder("should not receive a removed view unless it is pre layout")));
            }
            int i = viewHolder.mPosition;
            if (i < 0 || i >= RecyclerView.this.mAdapter.getItemCount()) {
                StringBuilder sb = new StringBuilder("Inconsistency detected. Invalid view holder adapter position");
                sb.append(viewHolder);
                throw new IndexOutOfBoundsException(AbstractC2821a.m2219j(RecyclerView.this, sb));
            }
            if (RecyclerView.this.mState.isPreLayout() || RecyclerView.this.mAdapter.getItemViewType(viewHolder.mPosition) == viewHolder.getItemViewType()) {
                return !RecyclerView.this.mAdapter.hasStableIds() || viewHolder.getItemId() == RecyclerView.this.mAdapter.getItemId(viewHolder.mPosition);
            }
            return false;
        }

        public void viewRangeUpdate(int i, int i2) {
            int i4;
            int i5 = i2 + i;
            for (int size = this.mCachedViews.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = this.mCachedViews.get(size);
                if (viewHolder != null && (i4 = viewHolder.mPosition) >= i && i4 < i5) {
                    viewHolder.addFlags(2);
                    recycleCachedViewAt(size);
                }
            }
        }

        private void poolingContainerDetach(Adapter<?> adapter, boolean z) {
            RecycledViewPool recycledViewPool = this.mRecyclerPool;
            if (recycledViewPool != null) {
                recycledViewPool.detachForPoolingContainer(adapter, z);
            }
        }

        public View getViewForPosition(int i, boolean z) {
            return tryGetViewHolderForPositionByDeadline(i, z, Long.MAX_VALUE).itemView;
        }

        private void invalidateDisplayListInt(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    invalidateDisplayListInt((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                } else {
                    int visibility = viewGroup.getVisibility();
                    viewGroup.setVisibility(4);
                    viewGroup.setVisibility(visibility);
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface RecyclerListener {
        void onViewRecycled(@NonNull ViewHolder viewHolder);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class RecyclerViewDataObserver extends AdapterDataObserver {
        public RecyclerViewDataObserver() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.mState.mStructureChanged = true;
            recyclerView.processDataSetCompletelyChanged(true);
            if (!RecyclerView.this.mAdapterHelper.hasPendingUpdates()) {
                RecyclerView.this.requestLayout();
            }
            if (RecyclerView.this.mFastScroller != null) {
                RecyclerView.this.mFastScroller.onSectionsChanged();
            }
            if (RecyclerView.this.mIndexTip != null) {
                RecyclerView.this.mIndexTip.updateSections();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2, Object obj) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.onItemRangeChanged(i, i2, obj)) {
                triggerUpdateProcessor();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i, int i2) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.onItemRangeInserted(i, i2)) {
                triggerUpdateProcessor();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i, int i2, int i4) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.onItemRangeMoved(i, i2, i4)) {
                triggerUpdateProcessor();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i, int i2) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.onItemRangeRemoved(i, i2)) {
                triggerUpdateProcessor();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onStateRestorationPolicyChanged() {
            Adapter adapter;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mPendingSavedState == null || (adapter = recyclerView.mAdapter) == null || !adapter.canRestoreState()) {
                return;
            }
            RecyclerView.this.requestLayout();
        }

        public void triggerUpdateProcessor() {
            if (RecyclerView.POST_UPDATES_ON_ANIMATION) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.mHasFixedSize && recyclerView.mIsAttached) {
                    ViewCompat.postOnAnimation(recyclerView, recyclerView.mUpdateChildViewsRunnable);
                    return;
                }
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            recyclerView2.mAdapterUpdateDuringMeasure = true;
            recyclerView2.requestLayout();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum ScrollArrowDirection {
        UP,
        RIGHT,
        DOWN,
        LEFT
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface SeslFastScrollerEventListener {
        void onPressed(float f);

        void onReleased(float f);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface SeslLongPressMultiSelectionListener {
        void onItemSelected(RecyclerView recyclerView, View view, int i, long j);

        void onLongPressMultiSelectionEnded(int i, int i2);

        void onLongPressMultiSelectionStarted(int i, int i2);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface SeslOnGoToTopClickListener {
        boolean onGoToTopClick(RecyclerView recyclerView);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface SeslOnMultiSelectedListener {
        void onMultiSelectStart(int i, int i2);

        void onMultiSelectStop(int i, int i2);

        void onMultiSelected(RecyclerView recyclerView, View view, int i, long j);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class SmoothScroller {
        private LayoutManager mLayoutManager;
        private boolean mPendingInitialRun;
        private RecyclerView mRecyclerView;
        private boolean mRunning;
        private boolean mStarted;
        private View mTargetView;
        private int mTargetPosition = -1;

        @Nullable
        protected Rect mAvailableBounds = null;
        private final Action mRecyclingAction = new Action(0, 0);

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class Action {
            public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
            private boolean mChanged;
            private int mConsecutiveUpdates;
            private int mDuration;
            private int mDx;
            private int mDy;
            private Interpolator mInterpolator;
            private int mJumpToPosition;

            public Action(@Px int i, @Px int i2) {
                this(i, i2, Integer.MIN_VALUE, null);
            }

            private void validate() {
                if (this.mInterpolator != null && this.mDuration < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                if (this.mDuration < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            public int getDuration() {
                return this.mDuration;
            }

            @Px
            public int getDx() {
                return this.mDx;
            }

            @Px
            public int getDy() {
                return this.mDy;
            }

            @Nullable
            public Interpolator getInterpolator() {
                return this.mInterpolator;
            }

            public boolean hasJumpTarget() {
                return this.mJumpToPosition >= 0;
            }

            public void jumpTo(int i) {
                this.mJumpToPosition = i;
            }

            public void runIfNecessary(RecyclerView recyclerView) {
                int i = this.mJumpToPosition;
                if (i >= 0) {
                    this.mJumpToPosition = -1;
                    recyclerView.jumpToPositionForSmoothScroller(i);
                    this.mChanged = false;
                } else {
                    if (!this.mChanged) {
                        this.mConsecutiveUpdates = 0;
                        return;
                    }
                    validate();
                    recyclerView.mViewFlinger.smoothScrollBy(this.mDx, this.mDy, this.mDuration, this.mInterpolator);
                    int i2 = this.mConsecutiveUpdates + 1;
                    this.mConsecutiveUpdates = i2;
                    if (i2 > 10) {
                        Log.e(RecyclerView.TAG, "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.mChanged = false;
                }
            }

            public void setDuration(int i) {
                this.mChanged = true;
                this.mDuration = i;
            }

            public void setDx(@Px int i) {
                this.mChanged = true;
                this.mDx = i;
            }

            public void setDy(@Px int i) {
                this.mChanged = true;
                this.mDy = i;
            }

            public void setInterpolator(@Nullable Interpolator interpolator) {
                this.mChanged = true;
                this.mInterpolator = interpolator;
            }

            public void update(@Px int i, @Px int i2, int i4, @Nullable Interpolator interpolator) {
                this.mDx = i;
                this.mDy = i2;
                this.mDuration = i4;
                this.mInterpolator = interpolator;
                this.mChanged = true;
            }

            public Action(@Px int i, @Px int i2, int i4) {
                this(i, i2, i4, null);
            }

            public Action(@Px int i, @Px int i2, int i4, @Nullable Interpolator interpolator) {
                this.mJumpToPosition = -1;
                this.mChanged = false;
                this.mConsecutiveUpdates = 0;
                this.mDx = i;
                this.mDy = i2;
                this.mDuration = i4;
                this.mInterpolator = interpolator;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public interface ScrollVectorProvider {
            @Nullable
            PointF computeScrollVectorForPosition(int i);
        }

        @Nullable
        public PointF computeScrollVectorForPosition(int i) {
            Object layoutManager = getLayoutManager();
            if (layoutManager instanceof ScrollVectorProvider) {
                return ((ScrollVectorProvider) layoutManager).computeScrollVectorForPosition(i);
            }
            Log.w(RecyclerView.TAG, "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + ScrollVectorProvider.class.getCanonicalName());
            return null;
        }

        public View findViewByPosition(int i) {
            return this.mRecyclerView.mLayout.findViewByPosition(i);
        }

        public int getChildCount() {
            return this.mRecyclerView.mLayout.getChildCount();
        }

        public int getChildPosition(View view) {
            return this.mRecyclerView.getChildLayoutPosition(view);
        }

        @Nullable
        public LayoutManager getLayoutManager() {
            return this.mLayoutManager;
        }

        public int getTargetPosition() {
            return this.mTargetPosition;
        }

        @Deprecated
        public void instantScrollToPosition(int i) {
            this.mRecyclerView.scrollToPosition(i);
        }

        public boolean isPendingInitialRun() {
            return this.mPendingInitialRun;
        }

        public boolean isRunning() {
            return this.mRunning;
        }

        public void normalize(@NonNull PointF pointF) {
            float f = pointF.x;
            float f4 = pointF.y;
            float fSqrt = (float) Math.sqrt((f4 * f4) + (f * f));
            pointF.x /= fSqrt;
            pointF.y /= fSqrt;
        }

        public void onAnimation(int i, int i2) {
            PointF pointFComputeScrollVectorForPosition;
            RecyclerView recyclerView = this.mRecyclerView;
            if (this.mTargetPosition == -1 || recyclerView == null) {
                stop();
            }
            if (this.mPendingInitialRun && this.mTargetView == null && this.mLayoutManager != null && (pointFComputeScrollVectorForPosition = computeScrollVectorForPosition(this.mTargetPosition)) != null) {
                float f = pointFComputeScrollVectorForPosition.x;
                if (f != 0.0f || pointFComputeScrollVectorForPosition.y != 0.0f) {
                    recyclerView.scrollStep((int) Math.signum(f), (int) Math.signum(pointFComputeScrollVectorForPosition.y), null);
                }
            }
            this.mPendingInitialRun = false;
            View view = this.mTargetView;
            if (view != null) {
                if (getChildPosition(view) == this.mTargetPosition) {
                    onTargetFound(this.mTargetView, recyclerView.mState, this.mRecyclingAction);
                    this.mRecyclingAction.runIfNecessary(recyclerView);
                    stop();
                } else {
                    Log.e(RecyclerView.TAG, "Passed over target position while smooth scrolling.");
                    this.mTargetView = null;
                }
            }
            if (this.mRunning) {
                onSeekTargetStep(i, i2, recyclerView.mState, this.mRecyclingAction);
                boolean zHasJumpTarget = this.mRecyclingAction.hasJumpTarget();
                this.mRecyclingAction.runIfNecessary(recyclerView);
                if (zHasJumpTarget && this.mRunning) {
                    this.mPendingInitialRun = true;
                    recyclerView.mViewFlinger.postOnAnimation();
                }
            }
        }

        public void onChildAttachedToWindow(View view) {
            if (getChildPosition(view) == getTargetPosition()) {
                this.mTargetView = view;
                if (RecyclerView.sVerboseLoggingEnabled) {
                    Log.d(RecyclerView.TAG, "smooth scroll target view has been attached");
                }
            }
        }

        public abstract void onSeekTargetStep(@Px int i, @Px int i2, @NonNull State state, @NonNull Action action);

        public abstract void onStart();

        public abstract void onStop();

        public abstract void onTargetFound(@NonNull View view, @NonNull State state, @NonNull Action action);

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void seslSetAvailableBounds(@Nullable Rect rect) {
            this.mAvailableBounds = rect;
        }

        public void setTargetPosition(int i) {
            this.mTargetPosition = i;
        }

        public void start(RecyclerView recyclerView, LayoutManager layoutManager) {
            recyclerView.mViewFlinger.stop();
            if (this.mStarted) {
                Log.w(RecyclerView.TAG, "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
            this.mRecyclerView = recyclerView;
            this.mLayoutManager = layoutManager;
            int i = this.mTargetPosition;
            if (i == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            recyclerView.mState.mTargetPosition = i;
            this.mRunning = true;
            this.mPendingInitialRun = true;
            this.mTargetView = findViewByPosition(getTargetPosition());
            onStart();
            this.mRecyclerView.mViewFlinger.postOnAnimation();
            this.mStarted = true;
        }

        public final void stop() {
            if (this.mRunning) {
                this.mRunning = false;
                onStop();
                this.mRecyclerView.mState.mTargetPosition = -1;
                this.mTargetView = null;
                this.mTargetPosition = -1;
                this.mPendingInitialRun = false;
                this.mLayoutManager.onSmoothScrollerStopped(this);
                this.mLayoutManager = null;
                this.mRecyclerView = null;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class State {
        static final int STEP_ANIMATIONS = 4;
        static final int STEP_LAYOUT = 2;
        static final int STEP_START = 1;
        private SparseArray<Object> mData;
        long mFocusedItemId;
        int mFocusedItemPosition;
        int mFocusedSubChildId;
        int mRemainingScrollHorizontal;
        int mRemainingScrollVertical;
        int mTargetPosition = -1;
        int mPreviousLayoutItemCount = 0;
        int mDeletedInvisibleItemCountSincePreviousLayout = 0;
        int mLayoutStep = 1;
        int mItemCount = 0;
        boolean mStructureChanged = false;
        boolean mInPreLayout = false;
        boolean mTrackOldChangeHolders = false;
        boolean mIsMeasuring = false;
        boolean mRunSimpleAnimations = false;
        boolean mRunPredictiveAnimations = false;

        public void assertLayoutStep(int i) {
            if ((this.mLayoutStep & i) != 0) {
                return;
            }
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.mLayoutStep));
        }

        public boolean didStructureChange() {
            return this.mStructureChanged;
        }

        public <T> T get(int i) {
            SparseArray<Object> sparseArray = this.mData;
            if (sparseArray == null) {
                return null;
            }
            return (T) sparseArray.get(i);
        }

        public int getItemCount() {
            return this.mInPreLayout ? this.mPreviousLayoutItemCount - this.mDeletedInvisibleItemCountSincePreviousLayout : this.mItemCount;
        }

        public int getRemainingScrollHorizontal() {
            return this.mRemainingScrollHorizontal;
        }

        public int getRemainingScrollVertical() {
            return this.mRemainingScrollVertical;
        }

        public int getTargetScrollPosition() {
            return this.mTargetPosition;
        }

        public boolean hasTargetScrollPosition() {
            return this.mTargetPosition != -1;
        }

        public boolean isMeasuring() {
            return this.mIsMeasuring;
        }

        public boolean isPreLayout() {
            return this.mInPreLayout;
        }

        public void prepareForNestedPrefetch(Adapter adapter) {
            this.mLayoutStep = 1;
            this.mItemCount = adapter.getItemCount();
            this.mInPreLayout = false;
            this.mTrackOldChangeHolders = false;
            this.mIsMeasuring = false;
        }

        public void put(int i, Object obj) {
            if (this.mData == null) {
                this.mData = new SparseArray<>();
            }
            this.mData.put(i, obj);
        }

        public void remove(int i) {
            SparseArray<Object> sparseArray = this.mData;
            if (sparseArray == null) {
                return;
            }
            sparseArray.remove(i);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("State{mTargetPosition=");
            sb.append(this.mTargetPosition);
            sb.append(", mData=");
            sb.append(this.mData);
            sb.append(", mItemCount=");
            sb.append(this.mItemCount);
            sb.append(", mIsMeasuring=");
            sb.append(this.mIsMeasuring);
            sb.append(", mPreviousLayoutItemCount=");
            sb.append(this.mPreviousLayoutItemCount);
            sb.append(", mDeletedInvisibleItemCountSincePreviousLayout=");
            sb.append(this.mDeletedInvisibleItemCountSincePreviousLayout);
            sb.append(", mStructureChanged=");
            sb.append(this.mStructureChanged);
            sb.append(", mInPreLayout=");
            sb.append(this.mInPreLayout);
            sb.append(", mRunSimpleAnimations=");
            sb.append(this.mRunSimpleAnimations);
            sb.append(", mRunPredictiveAnimations=");
            return AbstractC0622a.m1172r(sb, this.mRunPredictiveAnimations, '}');
        }

        public boolean willRunPredictiveAnimations() {
            return this.mRunPredictiveAnimations;
        }

        public boolean willRunSimpleAnimations() {
            return this.mRunSimpleAnimations;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class StretchEdgeEffectFactory extends EdgeEffectFactory {
        @Override // androidx.recyclerview.widget.RecyclerView.EdgeEffectFactory
        @NonNull
        public EdgeEffect createEdgeEffect(@NonNull RecyclerView recyclerView, int i) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class ViewCacheExtension {
        @Nullable
        public abstract View getViewForPositionAndType(@NonNull Recycler recycler, int i, int i2);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ViewFlinger implements Runnable {
        private boolean mEatRunOnAnimationRequest;
        Interpolator mInterpolator;
        private int mLastFlingX;
        private int mLastFlingY;
        OverScroller mOverScroller;
        private boolean mReSchedulePostAnimationCallback;

        public ViewFlinger() {
            Interpolator interpolator = RecyclerView.sQuinticInterpolator;
            this.mInterpolator = interpolator;
            this.mEatRunOnAnimationRequest = false;
            this.mReSchedulePostAnimationCallback = false;
            this.mOverScroller = new OverScroller(RecyclerView.this.getContext(), interpolator);
        }

        private int computeScrollDuration(int i, int i2, int i4, int i5) {
            int iRound;
            int iAbs = Math.abs(i);
            int iAbs2 = Math.abs(i2);
            boolean z = iAbs > iAbs2;
            int iSqrt = (int) Math.sqrt((i5 * i5) + (i4 * i4));
            int iSqrt2 = (int) Math.sqrt((i2 * i2) + (i * i));
            RecyclerView recyclerView = RecyclerView.this;
            int width = z ? recyclerView.getWidth() : recyclerView.getHeight();
            int i6 = width / 2;
            float f = width;
            float f4 = i6;
            float fDistanceInfluenceForSnapDuration = (distanceInfluenceForSnapDuration(Math.min(1.0f, (iSqrt2 * 1.0f) / f)) * f4) + f4;
            if (iSqrt > 0) {
                iRound = Math.round(Math.abs(fDistanceInfluenceForSnapDuration / iSqrt) * 1000.0f) * 4;
            } else {
                if (!z) {
                    iAbs = iAbs2;
                }
                iRound = (int) (((iAbs / f) + 1.0f) * 300.0f);
            }
            return Math.min(iRound, 2000);
        }

        private float distanceInfluenceForSnapDuration(float f) {
            return (float) Math.sin((f - 0.5f) * 0.47123894f);
        }

        private void internalPostOnAnimation() {
            RecyclerView.this.removeCallbacks(this);
            ViewCompat.postOnAnimation(RecyclerView.this, this);
        }

        public void fling(int i, int i2) {
            RecyclerView.this.setScrollState(2);
            this.mLastFlingY = 0;
            this.mLastFlingX = 0;
            Interpolator interpolator = this.mInterpolator;
            Interpolator interpolator2 = RecyclerView.sQuinticInterpolator;
            if (interpolator != interpolator2) {
                this.mInterpolator = interpolator2;
                this.mOverScroller = new OverScroller(RecyclerView.this.getContext(), interpolator2);
            }
            SeslOverScrollerReflector.fling(this.mOverScroller, 0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, RecyclerView.this.mIsSkipMoveEvent, RecyclerView.this.mFrameLatency);
            postOnAnimation();
        }

        public void postOnAnimation() {
            if (this.mEatRunOnAnimationRequest) {
                this.mReSchedulePostAnimationCallback = true;
            } else {
                internalPostOnAnimation();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int i2;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mLayout == null) {
                stop();
                return;
            }
            this.mReSchedulePostAnimationCallback = false;
            this.mEatRunOnAnimationRequest = true;
            recyclerView.consumePendingUpdateOperations();
            OverScroller overScroller = this.mOverScroller;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i4 = currX - this.mLastFlingX;
                int i5 = currY - this.mLastFlingY;
                this.mLastFlingX = currX;
                this.mLastFlingY = currY;
                int iConsumeFlingInHorizontalStretch = RecyclerView.this.consumeFlingInHorizontalStretch(i4);
                int iConsumeFlingInVerticalStretch = RecyclerView.this.consumeFlingInVerticalStretch(i5);
                RecyclerView recyclerView2 = RecyclerView.this;
                int[] iArr = recyclerView2.mReusableIntPair;
                iArr[0] = 0;
                iArr[1] = 0;
                if (recyclerView2.dispatchNestedPreScroll(iConsumeFlingInHorizontalStretch, iConsumeFlingInVerticalStretch, iArr, null, 1)) {
                    RecyclerView recyclerView3 = RecyclerView.this;
                    int[] iArr2 = recyclerView3.mReusableIntPair;
                    iConsumeFlingInHorizontalStretch -= iArr2[0];
                    int i6 = iArr2[1];
                    iConsumeFlingInVerticalStretch -= i6;
                    recyclerView3.adjustNestedScrollRangeBy(i6);
                } else {
                    RecyclerView.this.adjustNestedScrollRangeBy(iConsumeFlingInVerticalStretch);
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.considerReleasingGlowsOnScroll(iConsumeFlingInHorizontalStretch, iConsumeFlingInVerticalStretch);
                }
                RecyclerView recyclerView4 = RecyclerView.this;
                if (recyclerView4.mAdapter != null) {
                    int[] iArr3 = recyclerView4.mReusableIntPair;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    recyclerView4.scrollStep(iConsumeFlingInHorizontalStretch, iConsumeFlingInVerticalStretch, iArr3);
                    RecyclerView recyclerView5 = RecyclerView.this;
                    int[] iArr4 = recyclerView5.mReusableIntPair;
                    int i7 = iArr4[0];
                    int i8 = iArr4[1];
                    iConsumeFlingInHorizontalStretch -= i7;
                    iConsumeFlingInVerticalStretch -= i8;
                    SmoothScroller smoothScroller = recyclerView5.mLayout.mSmoothScroller;
                    if (smoothScroller != null && !smoothScroller.isPendingInitialRun() && smoothScroller.isRunning()) {
                        int itemCount = RecyclerView.this.mState.getItemCount();
                        if (itemCount == 0) {
                            smoothScroller.stop();
                        } else if (smoothScroller.getTargetPosition() >= itemCount) {
                            smoothScroller.setTargetPosition(itemCount - 1);
                            smoothScroller.onAnimation(i7, i8);
                        } else {
                            smoothScroller.onAnimation(i7, i8);
                        }
                    }
                    i2 = i8;
                    i = i7;
                } else {
                    i = 0;
                    i2 = 0;
                }
                int i9 = iConsumeFlingInHorizontalStretch;
                int i10 = iConsumeFlingInVerticalStretch;
                if (!RecyclerView.this.mItemDecorations.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView recyclerView6 = RecyclerView.this;
                int[] iArr5 = recyclerView6.mReusableIntPair;
                iArr5[0] = 0;
                iArr5[1] = 0;
                if (recyclerView6.seslDispatchNestedScroll(i, i2, i9, i10, null, 1, iArr5)) {
                    RecyclerView.this.mScrollOffset[0] = 0;
                    RecyclerView.this.mScrollOffset[1] = 0;
                }
                if (RecyclerView.this.mScrollOffset[0] < 0 || RecyclerView.this.mScrollOffset[1] < 0) {
                    RecyclerView.this.mScrollOffset[0] = 0;
                    RecyclerView.this.mScrollOffset[1] = 0;
                }
                RecyclerView recyclerView7 = RecyclerView.this;
                int[] iArr6 = recyclerView7.mReusableIntPair;
                int i11 = i9 - iArr6[0];
                int i12 = i10 - iArr6[1];
                if (i != 0 || i2 != 0) {
                    recyclerView7.dispatchOnScrolled(i, i2);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i11 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i12 != 0));
                SmoothScroller smoothScroller2 = RecyclerView.this.mLayout.mSmoothScroller;
                if ((smoothScroller2 == null || !smoothScroller2.isPendingInitialRun()) && z) {
                    if (RecyclerView.this.getOverScrollMode() != 2 && !RecyclerView.this.mEdgeEffectByDragging) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        int i13 = i11 < 0 ? -currVelocity : i11 > 0 ? currVelocity : 0;
                        if (i12 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i12 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView.this.absorbGlows(i13, currVelocity);
                    }
                    if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                        RecyclerView.this.mPrefetchRegistry.clearPrefetchPositions();
                    }
                } else {
                    postOnAnimation();
                    RecyclerView recyclerView8 = RecyclerView.this;
                    GapWorker gapWorker = recyclerView8.mGapWorker;
                    if (gapWorker != null) {
                        gapWorker.postFromTraversal(recyclerView8, i, i2);
                    }
                }
                SeslViewReflector.setFrameContentVelocity(RecyclerView.this, Math.abs(overScroller.getCurrVelocity()));
            }
            SmoothScroller smoothScroller3 = RecyclerView.this.mLayout.mSmoothScroller;
            if (smoothScroller3 != null && smoothScroller3.isPendingInitialRun()) {
                smoothScroller3.onAnimation(0, 0);
            }
            this.mEatRunOnAnimationRequest = false;
            if (this.mReSchedulePostAnimationCallback) {
                internalPostOnAnimation();
            } else {
                RecyclerView.this.setScrollState(0);
                RecyclerView.this.stopNestedScroll(1);
            }
        }

        public void smoothScrollBy(int i, int i2, int i4, @Nullable Interpolator interpolator) {
            if (i4 == Integer.MIN_VALUE) {
                i4 = computeScrollDuration(i, i2, 0, 0);
            }
            int i5 = i4;
            if (interpolator == null) {
                interpolator = RecyclerView.sQuinticInterpolator;
            }
            RecyclerView.this.startNestedScroll(i != 0 ? 2 : 1, 1);
            if (this.mInterpolator != interpolator) {
                this.mInterpolator = interpolator;
                this.mOverScroller = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.mLastFlingY = 0;
            this.mLastFlingX = 0;
            RecyclerView.this.setScrollState(2);
            this.mOverScroller.startScroll(0, 0, i, i2, i5);
            postOnAnimation();
        }

        public void stop() {
            RecyclerView.this.removeCallbacks(this);
            this.mOverScroller.abortAnimation();
            SeslViewReflector.setFrameContentVelocity(RecyclerView.this, 0.0f);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class ViewHolder {
        static final int FLAG_ADAPTER_FULLUPDATE = 1024;
        static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
        static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
        static final int FLAG_BOUND = 1;
        static final int FLAG_IGNORE = 128;
        static final int FLAG_INVALID = 4;
        static final int FLAG_MOVED = 2048;
        static final int FLAG_NOT_RECYCLABLE = 16;
        static final int FLAG_REMOVED = 8;
        static final int FLAG_RETURNED_FROM_SCRAP = 32;
        static final int FLAG_TMP_DETACHED = 256;
        static final int FLAG_UPDATE = 2;
        private static final List<Object> FULLUPDATE_PAYLOADS = Collections.EMPTY_LIST;
        static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;

        @NonNull
        public final View itemView;
        Adapter<? extends ViewHolder> mBindingAdapter;
        int mFlags;
        WeakReference<RecyclerView> mNestedRecyclerView;
        RecyclerView mOwnerRecyclerView;
        int mPosition = -1;
        int mOldPosition = -1;
        long mItemId = -1;
        int mItemViewType = -1;
        int mPreLayoutPosition = -1;
        ViewHolder mShadowedHolder = null;
        ViewHolder mShadowingHolder = null;
        List<Object> mPayloads = null;
        List<Object> mUnmodifiedPayloads = null;
        private int mIsRecyclableCount = 0;
        Recycler mScrapContainer = null;
        boolean mInChangeScrap = false;
        private int mWasImportantForAccessibilityBeforeHidden = 0;

        @VisibleForTesting
        int mPendingAccessibilityState = -1;
        private boolean mIsViewHolderRecoilEffectEnabled = true;

        public ViewHolder(@NonNull View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.itemView = view;
        }

        private void createPayloadsIfNeeded() {
            if (this.mPayloads == null) {
                ArrayList arrayList = new ArrayList();
                this.mPayloads = arrayList;
                this.mUnmodifiedPayloads = Collections.unmodifiableList(arrayList);
            }
        }

        public void addChangePayload(Object obj) {
            if (obj == null) {
                addFlags(1024);
            } else if ((1024 & this.mFlags) == 0) {
                createPayloadsIfNeeded();
                this.mPayloads.add(obj);
            }
        }

        public void addFlags(int i) {
            this.mFlags = i | this.mFlags;
        }

        public void clearOldPosition() {
            this.mOldPosition = -1;
            this.mPreLayoutPosition = -1;
        }

        public void clearPayload() {
            List<Object> list = this.mPayloads;
            if (list != null) {
                list.clear();
            }
            this.mFlags &= -1025;
        }

        public void clearReturnedFromScrapFlag() {
            this.mFlags &= -33;
        }

        public void clearTmpDetachFlag() {
            this.mFlags &= -257;
        }

        public boolean doesTransientStatePreventRecycling() {
            return (this.mFlags & 16) == 0 && ViewCompat.hasTransientState(this.itemView);
        }

        public void flagRemovedAndOffsetPosition(int i, int i2, boolean z) {
            addFlags(8);
            offsetPosition(i2, z);
            this.mPosition = i;
        }

        public final int getAbsoluteAdapterPosition() {
            RecyclerView recyclerView = this.mOwnerRecyclerView;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.getAdapterPositionInRecyclerView(this);
        }

        @Deprecated
        public final int getAdapterPosition() {
            return getBindingAdapterPosition();
        }

        @Nullable
        public final Adapter<? extends ViewHolder> getBindingAdapter() {
            return this.mBindingAdapter;
        }

        public final int getBindingAdapterPosition() {
            RecyclerView recyclerView;
            Adapter adapter;
            int adapterPositionInRecyclerView;
            if (this.mBindingAdapter == null || (recyclerView = this.mOwnerRecyclerView) == null || (adapter = recyclerView.getAdapter()) == null || (adapterPositionInRecyclerView = this.mOwnerRecyclerView.getAdapterPositionInRecyclerView(this)) == -1) {
                return -1;
            }
            return adapter.findRelativeAdapterPositionIn(this.mBindingAdapter, this, adapterPositionInRecyclerView);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public int getFlags() {
            return this.mFlags;
        }

        public final long getItemId() {
            return this.mItemId;
        }

        public final int getItemViewType() {
            return this.mItemViewType;
        }

        public final int getLayoutPosition() {
            int i = this.mPreLayoutPosition;
            return i == -1 ? this.mPosition : i;
        }

        public final int getOldPosition() {
            return this.mOldPosition;
        }

        @Deprecated
        public final int getPosition() {
            int i = this.mPreLayoutPosition;
            return i == -1 ? this.mPosition : i;
        }

        public List<Object> getUnmodifiedPayloads() {
            if ((this.mFlags & 1024) != 0) {
                return FULLUPDATE_PAYLOADS;
            }
            List<Object> list = this.mPayloads;
            return (list == null || list.size() == 0) ? FULLUPDATE_PAYLOADS : this.mUnmodifiedPayloads;
        }

        public boolean hasAnyOfTheFlags(int i) {
            return (i & this.mFlags) != 0;
        }

        public boolean isAdapterPositionUnknown() {
            return (this.mFlags & 512) != 0 || isInvalid();
        }

        public boolean isAttachedToTransitionOverlay() {
            return (this.itemView.getParent() == null || this.itemView.getParent() == this.mOwnerRecyclerView) ? false : true;
        }

        public boolean isBound() {
            return (this.mFlags & 1) != 0;
        }

        public boolean isInvalid() {
            return (this.mFlags & 4) != 0;
        }

        public final boolean isRecyclable() {
            return (this.mFlags & 16) == 0 && !ViewCompat.hasTransientState(this.itemView);
        }

        public boolean isRemoved() {
            return (this.mFlags & 8) != 0;
        }

        public boolean isScrap() {
            return this.mScrapContainer != null;
        }

        public boolean isTmpDetached() {
            return (this.mFlags & 256) != 0;
        }

        public boolean isUpdated() {
            return (this.mFlags & 2) != 0;
        }

        public boolean needsUpdate() {
            return (this.mFlags & 2) != 0;
        }

        public void offsetPosition(int i, boolean z) {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
            if (this.mPreLayoutPosition == -1) {
                this.mPreLayoutPosition = this.mPosition;
            }
            if (z) {
                this.mPreLayoutPosition += i;
            }
            this.mPosition += i;
            if (this.itemView.getLayoutParams() != null) {
                ((LayoutParams) this.itemView.getLayoutParams()).mInsetsDirty = true;
            }
        }

        public void onEnteredHiddenState(RecyclerView recyclerView) {
            int i = this.mPendingAccessibilityState;
            if (i != -1) {
                this.mWasImportantForAccessibilityBeforeHidden = i;
            } else {
                this.mWasImportantForAccessibilityBeforeHidden = ViewCompat.getImportantForAccessibility(this.itemView);
            }
            recyclerView.setChildImportantForAccessibilityInternal(this, 4);
        }

        public void onLeftHiddenState(RecyclerView recyclerView) {
            recyclerView.setChildImportantForAccessibilityInternal(this, this.mWasImportantForAccessibilityBeforeHidden);
            this.mWasImportantForAccessibilityBeforeHidden = 0;
        }

        public void resetInternal() {
            if (RecyclerView.sDebugAssertionsEnabled && isTmpDetached()) {
                throw new IllegalStateException("Attempting to reset temp-detached ViewHolder: " + this + ". ViewHolders should be fully detached before resetting.");
            }
            this.mFlags = 0;
            this.mPosition = -1;
            this.mOldPosition = -1;
            this.mItemId = -1L;
            this.mPreLayoutPosition = -1;
            this.mIsRecyclableCount = 0;
            this.mShadowedHolder = null;
            this.mShadowingHolder = null;
            clearPayload();
            this.mWasImportantForAccessibilityBeforeHidden = 0;
            this.mPendingAccessibilityState = -1;
            RecyclerView.clearNestedRecyclerViewIfNotNested(this);
        }

        public void saveOldPosition() {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
        }

        public boolean seslIsViewHolderRecoilEffectEnabled() {
            return this.mIsViewHolderRecoilEffectEnabled;
        }

        public void seslSetViewHolderRecoilEffectEnabled(boolean z) {
            if (this.mIsViewHolderRecoilEffectEnabled != z) {
                this.mIsViewHolderRecoilEffectEnabled = z;
            }
        }

        public void setFlags(int i, int i2) {
            this.mFlags = (i & i2) | (this.mFlags & (~i2));
        }

        public final void setIsRecyclable(boolean z) {
            int i = this.mIsRecyclableCount;
            int i2 = z ? i - 1 : i + 1;
            this.mIsRecyclableCount = i2;
            if (i2 < 0) {
                this.mIsRecyclableCount = 0;
                if (RecyclerView.sDebugAssertionsEnabled) {
                    throw new RuntimeException("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                }
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            } else if (!z && i2 == 1) {
                this.mFlags |= 16;
            } else if (z && i2 == 0) {
                this.mFlags &= -17;
            }
            if (RecyclerView.sVerboseLoggingEnabled) {
                Log.d(RecyclerView.TAG, "setIsRecyclable val:" + z + ":" + this);
            }
        }

        public void setScrapContainer(Recycler recycler, boolean z) {
            this.mScrapContainer = recycler;
            this.mInChangeScrap = z;
        }

        public boolean shouldBeKeptAsChild() {
            return (this.mFlags & 16) != 0;
        }

        public boolean shouldIgnore() {
            return (this.mFlags & 128) != 0;
        }

        public void stopIgnoring() {
            this.mFlags &= -129;
        }

        public String toString() {
            StringBuilder sbM781w = AbstractC0541b.m781w(getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName(), Parse.BRACKET_LCB);
            sbM781w.append(Integer.toHexString(hashCode()));
            sbM781w.append(" position=");
            sbM781w.append(this.mPosition);
            sbM781w.append(" id=");
            sbM781w.append(this.mItemId);
            sbM781w.append(", oldPos=");
            sbM781w.append(this.mOldPosition);
            sbM781w.append(", pLpos:");
            sbM781w.append(this.mPreLayoutPosition);
            StringBuilder sb = new StringBuilder(sbM781w.toString());
            if (isScrap()) {
                sb.append(" scrap ");
                sb.append(this.mInChangeScrap ? "[changeScrap]" : "[attachedScrap]");
            }
            if (isInvalid()) {
                sb.append(" invalid");
            }
            if (!isBound()) {
                sb.append(" unbound");
            }
            if (needsUpdate()) {
                sb.append(" update");
            }
            if (isRemoved()) {
                sb.append(" removed");
            }
            if (shouldIgnore()) {
                sb.append(" ignored");
            }
            if (isTmpDetached()) {
                sb.append(" tmpDetached");
            }
            if (!isRecyclable()) {
                sb.append(" not recyclable(" + this.mIsRecyclableCount + ")");
            }
            if (isAdapterPositionUnknown()) {
                sb.append(" undefined adapter position");
            }
            if (this.itemView.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        public void unScrap() {
            this.mScrapContainer.unscrapView(this);
        }

        public boolean wasReturnedFromScrap() {
            return (this.mFlags & 32) != 0;
        }
    }

    static {
        Class cls = Integer.TYPE;
        LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new Class[]{Context.class, AttributeSet.class, cls, cls};
        LINEAR_INTERPOLATOR = new LinearInterpolator();
        sQuinticInterpolator = new Interpolator() { // from class: androidx.recyclerview.widget.RecyclerView.7
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                float f4 = f - 1.0f;
                return (f4 * f4 * f4 * f4 * f4) + 1.0f;
            }
        };
        sDefaultEdgeEffectFactory = new StretchEdgeEffectFactory();
    }

    public RecyclerView(@NonNull Context context) {
        this(context, null);
    }

    private void addAnimatingView(ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        boolean z = view.getParent() == this;
        this.mRecycler.unscrapView(getChildViewHolder(view));
        if (viewHolder.isTmpDetached()) {
            this.mChildHelper.attachViewToParent(view, -1, view.getLayoutParams(), true);
        } else if (z) {
            this.mChildHelper.hide(view);
        } else {
            this.mChildHelper.addView(view, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adjustNestedScrollRange() {
        getLocationInWindow(this.mWindowOffsets);
        LayoutManager layoutManager = this.mLayout;
        int i = (layoutManager == null || !layoutManager.canScrollHorizontally()) ? this.mWindowOffsets[1] : this.mWindowOffsets[0];
        int i2 = this.mNestedScrollRange;
        int i4 = this.mInitialTopOffsetOfScreen;
        int i5 = i2 - (i4 - i);
        this.mRemainNestedScrollRange = i5;
        if (i4 - i < 0) {
            this.mNestedScrollRange = i5;
            this.mInitialTopOffsetOfScreen = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adjustNestedScrollRangeBy(int i) {
        if (this.mHasNestedScrollRange) {
            if (canScrollUp() && this.mRemainNestedScrollRange == 0) {
                return;
            }
            int i2 = this.mRemainNestedScrollRange - i;
            this.mRemainNestedScrollRange = i2;
            if (i2 < 0) {
                this.mRemainNestedScrollRange = 0;
                return;
            }
            int i4 = this.mNestedScrollRange;
            if (i2 > i4) {
                this.mRemainNestedScrollRange = i4;
            }
        }
    }

    private void animateChange(@NonNull ViewHolder viewHolder, @NonNull ViewHolder viewHolder2, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo2, boolean z, boolean z2) {
        viewHolder.setIsRecyclable(false);
        if (z) {
            addAnimatingView(viewHolder);
        }
        if (viewHolder != viewHolder2) {
            if (z2) {
                addAnimatingView(viewHolder2);
            }
            viewHolder.mShadowedHolder = viewHolder2;
            addAnimatingView(viewHolder);
            this.mRecycler.unscrapView(viewHolder);
            viewHolder2.setIsRecyclable(false);
            viewHolder2.mShadowingHolder = viewHolder;
        }
        if (this.mItemAnimator.animateChange(viewHolder, viewHolder2, itemHolderInfo, itemHolderInfo2)) {
            postAnimationRunner();
        }
    }

    private void applyFadingEdge(boolean z, Runnable runnable) {
        if (z) {
            this.mFadingEdgeHelper.setTargetView(this);
        }
        if (runnable != null) {
            runnable.run();
        }
        invalidate();
    }

    private Rect calculateFadingEdgeBounds() {
        Rect rect = new Rect(getScrollX(), getScrollY(), (getRight() + getScrollX()) - getLeft(), (getBottom() + getScrollY()) - getTop());
        if (getClipToPadding()) {
            rect.left = getPaddingLeft() + rect.left;
            rect.right -= getPaddingRight();
            rect.top = getPaddingTop() + rect.top;
            rect.bottom -= getPaddingBottom();
        }
        if (isPaddingOffsetRequired()) {
            rect.top += getTopPaddingOffset();
            rect.bottom += getBottomPaddingOffset();
        }
        return rect;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canScrollDown() {
        boolean zCanScrollHorizontally;
        boolean z;
        int childCount = getChildCount();
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            zCanScrollHorizontally = layoutManager.canScrollHorizontally();
            z = this.mLayout.getLayoutDirection() == 1;
        } else {
            zCanScrollHorizontally = false;
            z = false;
        }
        LayoutManager layoutManager2 = this.mLayout;
        boolean reverseLayout = layoutManager2 instanceof LinearLayoutManager ? ((LinearLayoutManager) layoutManager2).getReverseLayout() : false;
        if (this.mAdapter == null) {
            Log.e(TAG, "No adapter attached; skipping canScrollDown");
            return false;
        }
        boolean z2 = !reverseLayout ? findFirstChildPosition() + childCount >= this.mAdapter.getItemCount() : findFirstChildPosition() <= 0;
        if (z2 || childCount <= 0) {
            return z2;
        }
        getDecoratedBoundsWithMargins(getChildAt(reverseLayout ? 0 : childCount - 1), this.mChildBound);
        return zCanScrollHorizontally ? z ? this.mChildBound.left < this.mListPadding.left : this.mChildBound.right > getRight() - this.mListPadding.right || this.mChildBound.right > getWidth() - this.mListPadding.right : this.mChildBound.bottom > getBottom() - this.mListPadding.bottom || this.mChildBound.bottom > getHeight() - this.mListPadding.bottom;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canScrollUp() {
        boolean zCanScrollHorizontally;
        boolean z;
        int childCount = getChildCount();
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            zCanScrollHorizontally = layoutManager.canScrollHorizontally();
            z = this.mLayout.getLayoutDirection() == 1;
        } else {
            zCanScrollHorizontally = false;
            z = false;
        }
        LayoutManager layoutManager2 = this.mLayout;
        boolean reverseLayout = layoutManager2 instanceof LinearLayoutManager ? ((LinearLayoutManager) layoutManager2).getReverseLayout() : false;
        boolean z2 = !reverseLayout ? findFirstChildPosition() <= 0 : findFirstChildPosition() + childCount >= this.mAdapter.getItemCount();
        if (z2 || childCount <= 0) {
            return z2;
        }
        getDecoratedBoundsWithMargins(getChildAt(reverseLayout ? childCount - 1 : 0), this.mChildBound);
        return zCanScrollHorizontally ? z ? this.mChildBound.right > getRight() - this.mListPadding.right || this.mChildBound.right > getWidth() - this.mListPadding.right : this.mChildBound.left < this.mListPadding.left : this.mChildBound.top < this.mListPadding.top;
    }

    private void cancelScroll() {
        resetScroll();
        setScrollState(0);
    }

    public static void clearNestedRecyclerViewIfNotNested(@NonNull ViewHolder viewHolder) {
        WeakReference<RecyclerView> weakReference = viewHolder.mNestedRecyclerView;
        if (weakReference != null) {
            RecyclerView recyclerView = weakReference.get();
            while (recyclerView != null) {
                if (recyclerView == viewHolder.itemView) {
                    return;
                }
                Object parent = recyclerView.getParent();
                recyclerView = parent instanceof View ? (View) parent : null;
            }
            viewHolder.mNestedRecyclerView = null;
        }
    }

    private int consumeFlingInStretch(int i, EdgeEffect edgeEffect, EdgeEffect edgeEffect2, int i2) {
        if (i > 0 && edgeEffect != null && EdgeEffectCompat.getDistance(edgeEffect) != 0.0f) {
            int iRound = Math.round(EdgeEffectCompat.onPullDistance(edgeEffect, ((-i) * 4.0f) / i2, 0.5f) * ((-i2) / 4.0f));
            if (iRound != i) {
                edgeEffect.finish();
            }
            return i - iRound;
        }
        if (i >= 0 || edgeEffect2 == null || EdgeEffectCompat.getDistance(edgeEffect2) == 0.0f) {
            return i;
        }
        float f = i2;
        int iRound2 = Math.round(EdgeEffectCompat.onPullDistance(edgeEffect2, (i * 4.0f) / f, 0.5f) * (f / 4.0f));
        if (iRound2 != i) {
            edgeEffect2.finish();
        }
        return i - iRound2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean contentFits() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return true;
        }
        return childCount == this.mAdapter.getItemCount() && getChildAt(0).getTop() >= this.mListPadding.top && getChildAt(childCount - 1).getBottom() <= getHeight() - this.mListPadding.bottom;
    }

    private void createLayoutManager(Context context, String str, AttributeSet attributeSet, int i, int i2) {
        Object[] objArr;
        Constructor constructor;
        if (str != null) {
            String strTrim = str.trim();
            if (strTrim.isEmpty()) {
                return;
            }
            String fullClassName = getFullClassName(context, strTrim);
            try {
                Class<? extends U> clsAsSubclass = Class.forName(fullClassName, false, isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).asSubclass(LayoutManager.class);
                try {
                    constructor = clsAsSubclass.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);
                    objArr = new Object[]{context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
                } catch (NoSuchMethodException e) {
                    objArr = null;
                    try {
                        constructor = clsAsSubclass.getConstructor(null);
                    } catch (NoSuchMethodException e2) {
                        e2.initCause(e);
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + fullClassName, e2);
                    }
                }
                constructor.setAccessible(true);
                setLayoutManager((LayoutManager) constructor.newInstance(objArr));
            } catch (ClassCastException e3) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + fullClassName, e3);
            } catch (ClassNotFoundException e5) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + fullClassName, e5);
            } catch (IllegalAccessException e6) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + fullClassName, e6);
            } catch (InstantiationException e7) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e7);
            } catch (InvocationTargetException e8) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e8);
            }
        }
    }

    private boolean didChildRangeChange(int i, int i2) {
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        int[] iArr = this.mMinMaxLayoutPositions;
        return (iArr[0] == i && iArr[1] == i2) ? false : true;
    }

    private void dispatchContentChangedIfNecessary() {
        int i = this.mEatenAccessibilityChangeFlags;
        this.mEatenAccessibilityChangeFlags = 0;
        if (i == 0 || !isAccessibilityEnabled()) {
            return;
        }
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
        accessibilityEventObtain.setEventType(2048);
        AccessibilityEventCompat.setContentChangeTypes(accessibilityEventObtain, i);
        sendAccessibilityEventUnchecked(accessibilityEventObtain);
    }

    private void dispatchLayoutStep1() {
        this.mState.assertLayoutStep(1);
        fillRemainingScrollValues(this.mState);
        this.mState.mIsMeasuring = false;
        startInterceptRequestLayout();
        this.mViewInfoStore.clear();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        saveFocusInfo();
        State state = this.mState;
        state.mTrackOldChangeHolders = state.mRunSimpleAnimations && this.mItemsChanged;
        this.mItemsChanged = false;
        this.mItemsAddedOrRemoved = false;
        state.mInPreLayout = state.mRunPredictiveAnimations;
        state.mItemCount = this.mAdapter.getItemCount();
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        if (this.mState.mRunSimpleAnimations) {
            int childCount = this.mChildHelper.getChildCount();
            for (int i = 0; i < childCount; i++) {
                ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getChildAt(i));
                if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && (!childViewHolderInt.isInvalid() || this.mAdapter.hasStableIds())) {
                    this.mViewInfoStore.addToPreLayout(childViewHolderInt, this.mItemAnimator.recordPreLayoutInformation(this.mState, childViewHolderInt, ItemAnimator.buildAdapterChangeFlagsForAnimations(childViewHolderInt), childViewHolderInt.getUnmodifiedPayloads()));
                    if (this.mState.mTrackOldChangeHolders && childViewHolderInt.isUpdated() && !childViewHolderInt.isRemoved() && !childViewHolderInt.shouldIgnore() && !childViewHolderInt.isInvalid()) {
                        this.mViewInfoStore.addToOldChangeHolders(getChangedHolderKey(childViewHolderInt), childViewHolderInt);
                    }
                }
            }
        }
        if (this.mState.mRunPredictiveAnimations) {
            saveOldPositions();
            State state2 = this.mState;
            boolean z = state2.mStructureChanged;
            state2.mStructureChanged = false;
            this.mLayout.onLayoutChildren(this.mRecycler, state2);
            this.mState.mStructureChanged = z;
            for (int i2 = 0; i2 < this.mChildHelper.getChildCount(); i2++) {
                ViewHolder childViewHolderInt2 = getChildViewHolderInt(this.mChildHelper.getChildAt(i2));
                if (childViewHolderInt2 != null && !childViewHolderInt2.shouldIgnore() && !this.mViewInfoStore.isInPreLayout(childViewHolderInt2)) {
                    int iBuildAdapterChangeFlagsForAnimations = ItemAnimator.buildAdapterChangeFlagsForAnimations(childViewHolderInt2);
                    boolean zHasAnyOfTheFlags = childViewHolderInt2.hasAnyOfTheFlags(8192);
                    if (!zHasAnyOfTheFlags) {
                        iBuildAdapterChangeFlagsForAnimations |= 4096;
                    }
                    ItemAnimator.ItemHolderInfo itemHolderInfoRecordPreLayoutInformation = this.mItemAnimator.recordPreLayoutInformation(this.mState, childViewHolderInt2, iBuildAdapterChangeFlagsForAnimations, childViewHolderInt2.getUnmodifiedPayloads());
                    if (zHasAnyOfTheFlags) {
                        recordAnimationInfoIfBouncedHiddenView(childViewHolderInt2, itemHolderInfoRecordPreLayoutInformation);
                    } else {
                        this.mViewInfoStore.addToAppearedInPreLayoutHolders(childViewHolderInt2, itemHolderInfoRecordPreLayoutInformation);
                    }
                }
            }
            clearOldPositions();
        } else {
            clearOldPositions();
        }
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mState.mLayoutStep = 2;
    }

    private void dispatchLayoutStep2() {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.assertLayoutStep(6);
        this.mAdapterHelper.consumeUpdatesInOnePass();
        this.mState.mItemCount = this.mAdapter.getItemCount();
        this.mState.mDeletedInvisibleItemCountSincePreviousLayout = 0;
        if (this.mPendingSavedState != null && this.mAdapter.canRestoreState()) {
            Parcelable parcelable = this.mPendingSavedState.mLayoutState;
            if (parcelable != null) {
                this.mLayout.onRestoreInstanceState(parcelable);
            }
            this.mPendingSavedState = null;
        }
        State state = this.mState;
        state.mInPreLayout = false;
        this.mLayout.onLayoutChildren(this.mRecycler, state);
        State state2 = this.mState;
        state2.mStructureChanged = false;
        state2.mRunSimpleAnimations = state2.mRunSimpleAnimations && this.mItemAnimator != null;
        state2.mLayoutStep = 4;
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
    }

    private void dispatchLayoutStep3() {
        RecyclerView recyclerView;
        View childAt;
        this.mState.assertLayoutStep(4);
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        State state = this.mState;
        state.mLayoutStep = 1;
        if (state.mRunSimpleAnimations) {
            for (int childCount = this.mChildHelper.getChildCount() - 1; childCount >= 0; childCount--) {
                ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getChildAt(childCount));
                if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                    long changedHolderKey = getChangedHolderKey(childViewHolderInt);
                    ItemAnimator.ItemHolderInfo itemHolderInfoRecordPostLayoutInformation = this.mItemAnimator.recordPostLayoutInformation(this.mState, childViewHolderInt);
                    ViewHolder fromOldChangeHolders = this.mViewInfoStore.getFromOldChangeHolders(changedHolderKey);
                    if (fromOldChangeHolders == null || fromOldChangeHolders.shouldIgnore()) {
                        this.mViewInfoStore.addToPostLayout(childViewHolderInt, itemHolderInfoRecordPostLayoutInformation);
                    } else {
                        boolean zIsDisappearing = this.mViewInfoStore.isDisappearing(fromOldChangeHolders);
                        boolean zIsDisappearing2 = this.mViewInfoStore.isDisappearing(childViewHolderInt);
                        if (zIsDisappearing && fromOldChangeHolders == childViewHolderInt) {
                            this.mViewInfoStore.addToPostLayout(childViewHolderInt, itemHolderInfoRecordPostLayoutInformation);
                        } else {
                            ItemAnimator.ItemHolderInfo itemHolderInfoPopFromPreLayout = this.mViewInfoStore.popFromPreLayout(fromOldChangeHolders);
                            this.mViewInfoStore.addToPostLayout(childViewHolderInt, itemHolderInfoRecordPostLayoutInformation);
                            ItemAnimator.ItemHolderInfo itemHolderInfoPopFromPostLayout = this.mViewInfoStore.popFromPostLayout(childViewHolderInt);
                            if (itemHolderInfoPopFromPreLayout == null) {
                                handleMissingPreInfoForChangeError(changedHolderKey, childViewHolderInt, fromOldChangeHolders);
                            } else {
                                animateChange(fromOldChangeHolders, childViewHolderInt, itemHolderInfoPopFromPreLayout, itemHolderInfoPopFromPostLayout, zIsDisappearing, zIsDisappearing2);
                            }
                        }
                    }
                }
            }
            recyclerView = this;
            recyclerView.mViewInfoStore.process(recyclerView.mViewInfoProcessCallback);
        } else {
            recyclerView = this;
        }
        recyclerView.mLastBlackTop = recyclerView.mBlackTop;
        int i = -1;
        recyclerView.mBlackTop = -1;
        if (recyclerView.mDrawRect && !canScrollVertically(-1) && !canScrollVertically(1)) {
            int itemCount = recyclerView.mAdapter.getItemCount() - 1;
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.mLayout;
            boolean z = linearLayoutManager.mReverseLayout;
            if (z && linearLayoutManager.mStackFromEnd) {
                recyclerView.mDrawReverse = true;
                i = 0;
            } else if (z || linearLayoutManager.mStackFromEnd) {
                recyclerView.mDrawRect = false;
            } else {
                i = itemCount;
            }
            if (i >= 0 && i <= findLastVisibleItemPosition() && (childAt = recyclerView.mChildHelper.getChildAt(i)) != null) {
                recyclerView.mBlackTop = childAt.getBottom();
            }
        }
        recyclerView.mLayout.removeAndRecycleScrapInt(recyclerView.mRecycler);
        State state2 = recyclerView.mState;
        state2.mPreviousLayoutItemCount = state2.mItemCount;
        recyclerView.mDataSetHasChangedAfterLayout = false;
        recyclerView.mDispatchItemsChangedEvent = false;
        state2.mRunSimpleAnimations = false;
        state2.mRunPredictiveAnimations = false;
        recyclerView.mLayout.mRequestedSimpleAnimations = false;
        ArrayList<ViewHolder> arrayList = recyclerView.mRecycler.mChangedScrap;
        if (arrayList != null) {
            arrayList.clear();
        }
        LayoutManager layoutManager = recyclerView.mLayout;
        if (layoutManager.mPrefetchMaxObservedInInitialPrefetch) {
            layoutManager.mPrefetchMaxCountObserved = 0;
            layoutManager.mPrefetchMaxObservedInInitialPrefetch = false;
            recyclerView.mRecycler.updateViewCacheSize();
        }
        recyclerView.mLayout.onLayoutCompleted(recyclerView.mState);
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        recyclerView.mViewInfoStore.clear();
        int[] iArr = recyclerView.mMinMaxLayoutPositions;
        if (didChildRangeChange(iArr[0], iArr[1])) {
            dispatchOnScrolled(0, 0);
        }
        recoverFocusFromState();
        resetFocusInfo();
    }

    private boolean dispatchToOnItemTouchListeners(MotionEvent motionEvent) {
        OnItemTouchListener onItemTouchListener = this.mInterceptingOnItemTouchListener;
        if (onItemTouchListener == null) {
            if (motionEvent.getAction() == 0) {
                return false;
            }
            return findInterceptingOnItemTouchListener(motionEvent);
        }
        onItemTouchListener.onTouchEvent(this, motionEvent);
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.mInterceptingOnItemTouchListener = null;
        }
        return true;
    }

    private void ensureGoToTopController(boolean z) {
        if (z) {
            SeslGoToTopController seslGoToTopController = this.mGoToTopController;
            if (seslGoToTopController == null) {
                this.mGoToTopController = SeslGoToTopControllerFactory.createController(SeslGoToTopControllerFactory.ControllerType.RECYCLERVIEW, updateGoToTopConfig(), this.mGoToTopHost, TAG);
                return;
            } else {
                seslGoToTopController.updateConfig(updateGoToTopConfig());
                return;
            }
        }
        SeslGoToTopController seslGoToTopController2 = this.mGoToTopController;
        if (seslGoToTopController2 != null) {
            seslGoToTopController2.release();
            this.mGoToTopController = null;
        }
    }

    private int findFirstChildPosition() {
        int iFindFirstVisibleItemPosition;
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager instanceof LinearLayoutManager) {
            iFindFirstVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            iFindFirstVisibleItemPosition = ((StaggeredGridLayoutManager) this.mLayout).findFirstVisibleItemPositions(null)[layoutManager.getLayoutDirection() == 1 ? ((StaggeredGridLayoutManager) this.mLayout).getSpanCount() - 1 : 0];
        } else {
            iFindFirstVisibleItemPosition = 0;
        }
        if (iFindFirstVisibleItemPosition == -1) {
            return 0;
        }
        return iFindFirstVisibleItemPosition;
    }

    private boolean findInterceptingOnItemTouchListener(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.mOnItemTouchListeners.size();
        for (int i = 0; i < size; i++) {
            OnItemTouchListener onItemTouchListener = this.mOnItemTouchListeners.get(i);
            if (onItemTouchListener.onInterceptTouchEvent(this, motionEvent) && action != 3) {
                this.mInterceptingOnItemTouchListener = onItemTouchListener;
                return true;
            }
        }
        return false;
    }

    private void findMinMaxChildLayoutPositions(int[] iArr) {
        int childCount = this.mChildHelper.getChildCount();
        if (childCount == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MIN_VALUE;
        for (int i4 = 0; i4 < childCount; i4++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getChildAt(i4));
            if (!childViewHolderInt.shouldIgnore()) {
                int layoutPosition = childViewHolderInt.getLayoutPosition();
                if (layoutPosition < i) {
                    i = layoutPosition;
                }
                if (layoutPosition > i2) {
                    i2 = layoutPosition;
                }
            }
        }
        iArr[0] = i;
        iArr[1] = i2;
    }

    @Nullable
    public static RecyclerView findNestedRecyclerView(@NonNull View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            RecyclerView recyclerViewFindNestedRecyclerView = findNestedRecyclerView(viewGroup.getChildAt(i));
            if (recyclerViewFindNestedRecyclerView != null) {
                return recyclerViewFindNestedRecyclerView;
            }
        }
        return null;
    }

    @Nullable
    private View findNextViewToFocus() {
        ViewHolder viewHolderFindViewHolderForAdapterPosition;
        State state = this.mState;
        int i = state.mFocusedItemPosition;
        if (i == -1) {
            i = 0;
        }
        int itemCount = state.getItemCount();
        for (int i2 = i; i2 < itemCount; i2++) {
            ViewHolder viewHolderFindViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(i2);
            if (viewHolderFindViewHolderForAdapterPosition2 == null) {
                break;
            }
            if (viewHolderFindViewHolderForAdapterPosition2.itemView.hasFocusable()) {
                return viewHolderFindViewHolderForAdapterPosition2.itemView;
            }
        }
        int iMin = Math.min(itemCount, i);
        do {
            iMin--;
            if (iMin < 0 || (viewHolderFindViewHolderForAdapterPosition = findViewHolderForAdapterPosition(iMin)) == null) {
                return null;
            }
        } while (!viewHolderFindViewHolderForAdapterPosition.itemView.hasFocusable());
        return viewHolderFindViewHolderForAdapterPosition.itemView;
    }

    private boolean findSuperClass(ViewParent viewParent, String str) {
        for (Class<?> superclass = viewParent.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            if (superclass.getSimpleName().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static ViewHolder getChildViewHolderInt(View view) {
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).mViewHolder;
    }

    public static void getDecoratedBoundsWithMarginsInt(View view, Rect rect) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect2 = layoutParams.mDecorInsets;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
    }

    private int getDeepestFocusedViewWithId(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    private String getFullClassName(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        }
        if (str.contains(Extension.DOT)) {
            return str;
        }
        return RecyclerView.class.getPackage().getName() + '.' + str;
    }

    private int getPendingAnimFlag() {
        ItemAnimator itemAnimator = getItemAnimator();
        if (itemAnimator instanceof DefaultItemAnimator) {
            return ((DefaultItemAnimator) itemAnimator).getPendingAnimFlag();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRecyclerViewScreenLocationY() {
        getLocationOnScreen(this.mRecyclerViewOffsets);
        return this.mRecyclerViewOffsets[1];
    }

    private int getRotatedArrowPointerIcon(boolean z, boolean z2) {
        ScrollArrowDirection scrollArrowDirection = z ? z2 ? ScrollArrowDirection.RIGHT : ScrollArrowDirection.DOWN : z2 ? ScrollArrowDirection.LEFT : ScrollArrowDirection.UP;
        float f = this.mPointerIconRotation;
        if (f == 0.0f) {
            return this.mHoverScrollArrows[scrollArrowDirection.ordinal()];
        }
        boolean z3 = f < 0.0f;
        int iOrdinal = ((scrollArrowDirection.ordinal() * (z3 ? -1 : 1)) + ((int) ((f + (z3 ? -45 : 45)) / 90.0f))) % 4;
        if (iOrdinal == 0) {
            return this.mHoverScrollArrows[iOrdinal];
        }
        int[] iArr = this.mHoverScrollArrows;
        if (z3) {
            iOrdinal += 4;
        }
        return iArr[iOrdinal];
    }

    private NestedScrollingChildHelper getScrollingChildHelper() {
        if (this.mScrollingChildHelper == null) {
            this.mScrollingChildHelper = new NestedScrollingChildHelper(this);
        }
        return this.mScrollingChildHelper;
    }

    private float getSplineFlingDistance(int i) {
        double dLog = Math.log((Math.abs(i) * 0.35f) / (this.mPhysicalCoef * SCROLL_FRICTION));
        float f = DECELERATION_RATE;
        return (float) (Math.exp((((double) f) / (((double) f) - 1.0d)) * dLog) * ((double) (this.mPhysicalCoef * SCROLL_FRICTION)));
    }

    private int getTopUnderNestedScrollView(ViewGroup viewGroup) {
        int top = 0;
        while (!(viewGroup instanceof NestedScrollView)) {
            top += viewGroup.getTop();
            if (!(viewGroup.getParent() instanceof ViewGroup)) {
                break;
            }
            viewGroup = (ViewGroup) viewGroup.getParent();
        }
        return top;
    }

    private void handleMissingPreInfoForChangeError(long j, ViewHolder viewHolder, ViewHolder viewHolder2) {
        int childCount = this.mChildHelper.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getChildAt(i));
            if (childViewHolderInt != viewHolder && getChangedHolderKey(childViewHolderInt) == j) {
                Adapter adapter = this.mAdapter;
                if (adapter == null || !adapter.hasStableIds()) {
                    StringBuilder sb = new StringBuilder("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:");
                    sb.append(childViewHolderInt);
                    sb.append(" \n View Holder 2:");
                    sb.append(viewHolder);
                    throw new IllegalStateException(AbstractC2821a.m2219j(this, sb));
                }
                StringBuilder sb2 = new StringBuilder("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:");
                sb2.append(childViewHolderInt);
                sb2.append(" \n View Holder 2:");
                sb2.append(viewHolder);
                throw new IllegalStateException(AbstractC2821a.m2219j(this, sb2));
            }
        }
        Log.e(TAG, "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + viewHolder2 + " cannot be found but it is necessary for " + viewHolder + exceptionLabel());
    }

    private boolean hasUpdatedView() {
        int childCount = this.mChildHelper.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getChildAt(i));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.isUpdated()) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"InlinedApi"})
    private void initAutofill() {
        if (ViewCompat.getImportantForAutofill(this) == 0) {
            ViewCompat.setImportantForAutofill(this, 8);
        }
    }

    private void initChildrenHelper() {
        this.mChildHelper = new ChildHelper(new ChildHelper.Callback() { // from class: androidx.recyclerview.widget.RecyclerView.9
            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public void addView(View view, int i) {
                RecyclerView.this.addView(view, i);
                RecyclerView.this.dispatchChildAttached(view);
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public void attachViewToParent(View view, int i, ViewGroup.LayoutParams layoutParams) {
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt != null) {
                    if (!childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                        StringBuilder sb = new StringBuilder("Called attach on a child which is not detached: ");
                        sb.append(childViewHolderInt);
                        throw new IllegalArgumentException(AbstractC2821a.m2219j(RecyclerView.this, sb));
                    }
                    if (RecyclerView.sVerboseLoggingEnabled) {
                        Log.d(RecyclerView.TAG, "reAttach " + childViewHolderInt);
                    }
                    childViewHolderInt.clearTmpDetachFlag();
                } else if (RecyclerView.sDebugAssertionsEnabled) {
                    StringBuilder sb2 = new StringBuilder("No ViewHolder found for child: ");
                    sb2.append(view);
                    sb2.append(", index: ");
                    sb2.append(i);
                    throw new IllegalArgumentException(AbstractC2821a.m2219j(RecyclerView.this, sb2));
                }
                RecyclerView.this.attachViewToParent(view, i, layoutParams);
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public void detachViewFromParent(int i) {
                View childAt = getChildAt(i);
                if (childAt != null) {
                    ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt);
                    if (childViewHolderInt != null) {
                        if (childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                            StringBuilder sb = new StringBuilder("called detach on an already detached child ");
                            sb.append(childViewHolderInt);
                            throw new IllegalArgumentException(AbstractC2821a.m2219j(RecyclerView.this, sb));
                        }
                        if (RecyclerView.sVerboseLoggingEnabled) {
                            Log.d(RecyclerView.TAG, "tmpDetach " + childViewHolderInt);
                        }
                        childViewHolderInt.addFlags(256);
                    }
                } else if (RecyclerView.sDebugAssertionsEnabled) {
                    StringBuilder sb2 = new StringBuilder("No view at offset ");
                    sb2.append(i);
                    throw new IllegalArgumentException(AbstractC2821a.m2219j(RecyclerView.this, sb2));
                }
                RecyclerView.this.detachViewFromParent(i);
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public View getChildAt(int i) {
                return RecyclerView.this.getChildAt(i);
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public int getChildCount() {
                return RecyclerView.this.getChildCount();
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public ViewHolder getChildViewHolder(View view) {
                return RecyclerView.getChildViewHolderInt(view);
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public int indexOfChild(View view) {
                return RecyclerView.this.indexOfChild(view);
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public void onEnteredHiddenState(View view) {
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt != null) {
                    childViewHolderInt.onEnteredHiddenState(RecyclerView.this);
                }
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public void onLeftHiddenState(View view) {
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt != null) {
                    childViewHolderInt.onLeftHiddenState(RecyclerView.this);
                }
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public void removeAllViews() {
                int childCount = getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = getChildAt(i);
                    RecyclerView.this.dispatchChildDetached(childAt);
                    childAt.clearAnimation();
                }
                RecyclerView.this.removeAllViews();
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public void removeViewAt(int i) {
                View childAt = RecyclerView.this.getChildAt(i);
                if (childAt != null) {
                    RecyclerView.this.dispatchChildDetached(childAt);
                    childAt.clearAnimation();
                }
                RecyclerView.this.removeViewAt(i);
            }
        });
    }

    private boolean isGoToTopAvailableEnvironment() {
        String string;
        AccessibilityManager accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        return (accessibilityManager == null || !accessibilityManager.isEnabled() || (string = Settings.Secure.getString(getContext().getContentResolver(), "enabled_accessibility_services")) == null || !(string.matches("(?i).*com.samsung.accessibility/com.samsung.android.app.talkback.TalkBackService.*") || string.matches("(?i).*com.samsung.android.accessibility.talkback/com.samsung.android.marvin.talkback.TalkBackService.*") || string.matches("(?i).*com.google.android.marvin.talkback.TalkBackService.*") || string.matches("(?i).*com.samsung.accessibility/com.samsung.accessibility.universalswitch.UniversalSwitchService.*"))) && getHeight() > this.mSeslOverlayFeatureHeight;
    }

    private boolean isLockScreenMode() {
        return ((KeyguardManager) this.mContext.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
    }

    private boolean isPreferredNextFocus(View view, View view2, int i) {
        int i2;
        if (view2 == null || view2 == this || view2 == view || findContainingItemView(view2) == null) {
            return false;
        }
        if (view == null || findContainingItemView(view) == null) {
            return true;
        }
        this.mTempRect.set(0, 0, view.getWidth(), view.getHeight());
        this.mTempRect2.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        offsetDescendantRectToMyCoords(view2, this.mTempRect2);
        byte b = -1;
        int i4 = this.mLayout.getLayoutDirection() == 1 ? -1 : 1;
        Rect rect = this.mTempRect;
        int i5 = rect.left;
        Rect rect2 = this.mTempRect2;
        int i6 = rect2.left;
        if ((i5 < i6 || rect.right <= i6) && rect.right < rect2.right) {
            i2 = 1;
        } else {
            int i7 = rect.right;
            int i8 = rect2.right;
            i2 = ((i7 > i8 || i5 >= i8) && i5 > i6) ? -1 : 0;
        }
        int i9 = rect.top;
        int i10 = rect2.top;
        if ((i9 < i10 || rect.bottom <= i10) && rect.bottom < rect2.bottom) {
            b = 1;
        } else {
            int i11 = rect.bottom;
            int i12 = rect2.bottom;
            if ((i11 <= i12 && i9 < i12) || i9 <= i10) {
                b = 0;
            }
        }
        if (i == 1) {
            return b < 0 || (b == 0 && i2 * i4 < 0);
        }
        if (i == 2) {
            return b > 0 || (b == 0 && i2 * i4 > 0);
        }
        if (i == 17) {
            return i2 < 0;
        }
        if (i == 33) {
            return b < 0;
        }
        if (i == 66) {
            return i2 > 0;
        }
        if (i == 130) {
            return b > 0;
        }
        StringBuilder sb = new StringBuilder("Invalid direction: ");
        sb.append(i);
        throw new IllegalArgumentException(AbstractC2821a.m2219j(this, sb));
    }

    private void jumpToPosition(int i) {
        int spanCount;
        LayoutManager layoutManager = this.mLayout;
        if (!(layoutManager instanceof LinearLayoutManager)) {
            scrollToPosition(i);
            return;
        }
        if ((layoutManager instanceof GridLayoutManager) && i < (spanCount = ((GridLayoutManager) layoutManager).getSpanCount())) {
            i = spanCount;
        }
        ((LinearLayoutManager) this.mLayout).scrollToPositionWithOffset(i, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$seslSetFadingEdgeEnabled$0(boolean z, int i, int i2) {
        this.mFadingEdgeHelper.setFadingEdgeEnabled(z, i, i2, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$seslSetFadingEdgeEnabled$1(boolean z) {
        this.mFadingEdgeHelper.setFadingEdgeEnabled(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$seslSetFadingEdgeEnabled$2(boolean z, boolean z2) {
        this.mFadingEdgeHelper.setFadingEdgeEnabled(z, false, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$seslSetFadingEdgeEnabled$3(boolean z, boolean z2, boolean z3) {
        this.mFadingEdgeHelper.setFadingEdgeEnabled(z, z2, z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$seslSetGoToTopEnabled$4() {
        List<SeslScrollable.SeslOnGoToTopClickListener> list = this.mOnGoToTopClickListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnGoToTopClickListeners.get(size).onGoToTopClick(this);
            }
        }
        SeslOnGoToTopClickListener seslOnGoToTopClickListener = this.mOnGoToTopClickListener;
        if (seslOnGoToTopClickListener != null) {
            return seslOnGoToTopClickListener.onGoToTopClick(this);
        }
        return false;
    }

    private void multiSelection(int i, int i2, int i4, int i5, boolean z) {
        OnScrollListener onScrollListener;
        if (this.mIsNeedPenSelection) {
            if (this.mIsFirstPenMoveEvent) {
                this.mPenDragStartX = i;
                this.mPenDragStartY = i2;
                this.mIsPenPressed = true;
                float f = i;
                float f4 = i2;
                View viewFindChildViewUnder = findChildViewUnder(f, f4);
                this.mPenTrackedChild = viewFindChildViewUnder;
                if (viewFindChildViewUnder == null) {
                    View viewSeslFindNearChildViewUnder = seslFindNearChildViewUnder(f, f4);
                    this.mPenTrackedChild = viewSeslFindNearChildViewUnder;
                    if (viewSeslFindNearChildViewUnder == null) {
                        Log.e(TAG, "multiSelection, mPenTrackedChild is NULL");
                        this.mIsPenPressed = false;
                        this.mIsFirstPenMoveEvent = false;
                        return;
                    }
                }
                SeslOnMultiSelectedListener seslOnMultiSelectedListener = this.mOnMultiSelectedListener;
                if (seslOnMultiSelectedListener != null) {
                    seslOnMultiSelectedListener.onMultiSelectStart(i, i2);
                }
                this.mPenTrackedChildPosition = getChildLayoutPosition(this.mPenTrackedChild);
                this.mPenDistanceFromTrackedChildTop = this.mPenDragStartY - this.mPenTrackedChild.getTop();
                this.mIsFirstPenMoveEvent = false;
            }
            if (this.mPenDragStartX == 0 && this.mPenDragStartY == 0) {
                this.mPenDragStartX = i;
                this.mPenDragStartY = i2;
                SeslOnMultiSelectedListener seslOnMultiSelectedListener2 = this.mOnMultiSelectedListener;
                if (seslOnMultiSelectedListener2 != null) {
                    seslOnMultiSelectedListener2.onMultiSelectStart(i, i2);
                }
                this.mIsPenPressed = true;
            }
            this.mPenDragEndX = i;
            this.mPenDragEndY = i2;
            if (i2 < 0) {
                this.mPenDragEndY = 0;
            } else if (i2 > i5) {
                this.mPenDragEndY = i5;
            }
            int i6 = this.mPenDragStartX;
            this.mPenDragBlockLeft = i6 < i ? i6 : i;
            int i7 = this.mPenDragStartY;
            int i8 = this.mPenDragEndY;
            this.mPenDragBlockTop = i7 < i8 ? i7 : i8;
            if (i <= i6) {
                i = i6;
            }
            this.mPenDragBlockRight = i;
            if (i8 > i7) {
                i7 = i8;
            }
            this.mPenDragBlockBottom = i7;
            z = true;
        }
        if (z) {
            if (i2 <= i4 + this.mHoverTopAreaHeight + this.mHoverDefaultTopAreaHeight) {
                if (!this.mHoverAreaEnter) {
                    this.mHoverAreaEnter = true;
                    this.mHoverScrollStartTime = System.currentTimeMillis();
                    OnScrollListener onScrollListener2 = this.mScrollListener;
                    if (onScrollListener2 != null) {
                        onScrollListener2.onScrollStateChanged(this, 1);
                    }
                }
                if (!this.mHoverHandler.hasMessages(0)) {
                    this.mHoverRecognitionStartTime = System.currentTimeMillis();
                    this.mHoverScrollDirection = 2;
                    this.mHoverHandler.sendEmptyMessage(0);
                }
            } else if (i2 >= ((i5 - this.mHoverBottomAreaHeight) - this.mHoverDefaultBottomAreaHeight) - this.mRemainNestedScrollRange) {
                if (!this.mHoverAreaEnter) {
                    this.mHoverAreaEnter = true;
                    this.mHoverScrollStartTime = System.currentTimeMillis();
                    OnScrollListener onScrollListener3 = this.mScrollListener;
                    if (onScrollListener3 != null) {
                        onScrollListener3.onScrollStateChanged(this, 1);
                    }
                }
                if (!this.mHoverHandler.hasMessages(0)) {
                    this.mHoverRecognitionStartTime = System.currentTimeMillis();
                    this.mHoverScrollDirection = 1;
                    this.mHoverHandler.sendEmptyMessage(0);
                }
            } else {
                if (this.mHoverAreaEnter && (onScrollListener = this.mScrollListener) != null) {
                    onScrollListener.onScrollStateChanged(this, 0);
                }
                this.mHoverScrollStartTime = 0L;
                this.mHoverRecognitionStartTime = 0L;
                this.mHoverAreaEnter = false;
                if (this.mHoverHandler.hasMessages(0)) {
                    this.mHoverHandler.removeMessages(0);
                    if (this.mScrollState == 1) {
                        setScrollState(0);
                    }
                }
                this.mIsHoverOverscrolled = false;
            }
            if (this.mIsPenDragBlockEnabled) {
                invalidate();
            }
        }
    }

    private void multiSelectionEnd(int i, int i2) {
        SeslOnMultiSelectedListener seslOnMultiSelectedListener;
        if (this.mIsPenPressed && (seslOnMultiSelectedListener = this.mOnMultiSelectedListener) != null) {
            seslOnMultiSelectedListener.onMultiSelectStop(i, i2);
        }
        this.mIsPenPressed = false;
        this.mIsFirstPenMoveEvent = true;
        this.mPenDragSelectedViewPosition = -1;
        this.mPenDragSelectedItemArray.clear();
        this.mPenDragStartX = 0;
        this.mPenDragStartY = 0;
        this.mPenDragEndX = 0;
        this.mPenDragEndY = 0;
        this.mPenDragBlockLeft = 0;
        this.mPenDragBlockTop = 0;
        this.mPenDragBlockRight = 0;
        this.mPenDragBlockBottom = 0;
        this.mPenTrackedChild = null;
        this.mPenDistanceFromTrackedChildTop = 0;
        if (this.mIsPenDragBlockEnabled) {
            invalidate();
        }
        if (this.mHoverHandler.hasMessages(0)) {
            this.mHoverHandler.removeMessages(0);
        }
    }

    private void nestedScrollByInternal(int i, int i2, @Nullable MotionEvent motionEvent, int i4) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            Log.e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.mLayoutSuppressed) {
            return;
        }
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        boolean zCanScrollHorizontally = layoutManager.canScrollHorizontally();
        boolean zCanScrollVertically = this.mLayout.canScrollVertically();
        int i5 = zCanScrollVertically ? (zCanScrollHorizontally ? 1 : 0) | 2 : zCanScrollHorizontally ? 1 : 0;
        float height = motionEvent == null ? getHeight() / 2.0f : motionEvent.getY();
        float width = motionEvent == null ? getWidth() / 2.0f : motionEvent.getX();
        int iReleaseHorizontalGlow = i - releaseHorizontalGlow(i, height);
        int iReleaseVerticalGlow = i2 - releaseVerticalGlow(i2, width);
        startNestedScroll(i5, i4);
        if (dispatchNestedPreScroll(zCanScrollHorizontally ? iReleaseHorizontalGlow : 0, zCanScrollVertically ? iReleaseVerticalGlow : 0, this.mReusableIntPair, this.mScrollOffset, i4)) {
            int[] iArr2 = this.mReusableIntPair;
            iReleaseHorizontalGlow -= iArr2[0];
            iReleaseVerticalGlow -= iArr2[1];
        }
        scrollByInternal(zCanScrollHorizontally ? iReleaseHorizontalGlow : 0, zCanScrollVertically ? iReleaseVerticalGlow : 0, motionEvent, i4);
        GapWorker gapWorker = this.mGapWorker;
        if (gapWorker != null && (iReleaseHorizontalGlow != 0 || iReleaseVerticalGlow != 0)) {
            gapWorker.postFromTraversal(this, iReleaseHorizontalGlow, iReleaseVerticalGlow);
        }
        stopNestedScroll(i4);
    }

    private void onPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mScrollPointerId) {
            int i = actionIndex == 0 ? 1 : 0;
            this.mScrollPointerId = motionEvent.getPointerId(i);
            int x = (int) (motionEvent.getX(i) + 0.5f);
            this.mLastTouchX = x;
            this.mInitialTouchX = x;
            int y2 = (int) (motionEvent.getY(i) + 0.5f);
            this.mLastTouchY = y2;
            this.mInitialTouchY = y2;
        }
    }

    private boolean pageScroll(int i) {
        int iFindFirstVisibleItemPosition;
        Adapter adapter = this.mAdapter;
        int i2 = 0;
        if (adapter == null) {
            Log.e(TAG, "No adapter attached; skipping pageScroll");
            return false;
        }
        int itemCount = adapter.getItemCount();
        if (itemCount <= 0) {
            return false;
        }
        if (i == 0) {
            iFindFirstVisibleItemPosition = findFirstVisibleItemPosition() - getChildCount();
        } else if (i == 1) {
            iFindFirstVisibleItemPosition = findLastVisibleItemPosition() + getChildCount();
        } else if (i == 2) {
            iFindFirstVisibleItemPosition = 0;
        } else {
            if (i != 3) {
                return false;
            }
            iFindFirstVisibleItemPosition = itemCount - 1;
        }
        int i4 = itemCount - 1;
        if (iFindFirstVisibleItemPosition > i4) {
            i2 = i4;
        } else if (iFindFirstVisibleItemPosition >= 0) {
            i2 = iFindFirstVisibleItemPosition;
        }
        this.mLayout.mRecyclerView.scrollToPosition(i2);
        this.mLayout.mRecyclerView.post(new Runnable() { // from class: androidx.recyclerview.widget.RecyclerView.15
            @Override // java.lang.Runnable
            public void run() {
                View childAt = RecyclerView.this.getChildAt(0);
                if (childAt != null) {
                    childAt.requestFocus();
                }
            }
        });
        return true;
    }

    private boolean predictiveItemAnimationsEnabled() {
        return this.mItemAnimator != null && this.mLayout.supportsPredictiveItemAnimations();
    }

    private void processAdapterUpdatesAndSetAnimationFlags() {
        boolean z;
        if (this.mDataSetHasChangedAfterLayout) {
            this.mAdapterHelper.reset();
            if (this.mDispatchItemsChangedEvent) {
                this.mLayout.onItemsChanged(this);
            }
        }
        if (predictiveItemAnimationsEnabled()) {
            this.mAdapterHelper.preProcess();
        } else {
            this.mAdapterHelper.consumeUpdatesInOnePass();
        }
        boolean z2 = this.mItemsAddedOrRemoved || this.mItemsChanged;
        this.mState.mRunSimpleAnimations = this.mFirstLayoutComplete && this.mItemAnimator != null && ((z = this.mDataSetHasChangedAfterLayout) || z2 || this.mLayout.mRequestedSimpleAnimations) && (!z || this.mAdapter.hasStableIds());
        State state = this.mState;
        state.mRunPredictiveAnimations = state.mRunSimpleAnimations && z2 && !this.mDataSetHasChangedAfterLayout && predictiveItemAnimationsEnabled();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void pullGlows(float f, float f4, float f5, float f6) {
        boolean z;
        boolean z2 = true;
        if (f4 < 0.0f) {
            ensureLeftGlow();
            EdgeEffectCompat.onPullDistance(this.mLeftGlow, (-f4) / getWidth(), 1.0f - (f5 / getHeight()));
        } else {
            if (f4 <= 0.0f) {
                z = false;
                if (f6 >= 0.0f) {
                    ensureTopGlow();
                    EdgeEffectCompat.onPullDistance(this.mTopGlow, (-f6) / getHeight(), f / getWidth());
                } else if (f6 > 0.0f) {
                    ensureBottomGlow();
                    EdgeEffectCompat.onPullDistance(this.mBottomGlow, f6 / getHeight(), 1.0f - (f / getWidth()));
                } else {
                    z2 = z;
                }
                this.mEdgeEffectByDragging = z2;
                if (z2 && f4 == 0.0f && f6 == 0.0f) {
                    return;
                }
                ViewCompat.postInvalidateOnAnimation(this);
            }
            ensureRightGlow();
            EdgeEffectCompat.onPullDistance(this.mRightGlow, f4 / getWidth(), f5 / getHeight());
        }
        z = true;
        if (f6 >= 0.0f) {
        }
        this.mEdgeEffectByDragging = z2;
        if (z2) {
        }
        ViewCompat.postInvalidateOnAnimation(this);
    }

    private void recoverFocusFromState() {
        View viewFindViewById;
        if (!this.mPreserveFocusAfterLayout || this.mAdapter == null || !hasFocus() || getDescendantFocusability() == 393216) {
            return;
        }
        if (getDescendantFocusability() == 131072 && isFocused()) {
            return;
        }
        if (!isFocused()) {
            View focusedChild = getFocusedChild();
            if (!IGNORE_DETACHED_FOCUSED_CHILD || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                if (!this.mChildHelper.isHidden(focusedChild)) {
                    return;
                }
            } else if (this.mChildHelper.getChildCount() == 0) {
                requestFocus();
                return;
            }
        }
        View viewFindNextViewToFocus = null;
        ViewHolder viewHolderFindViewHolderForItemId = (this.mState.mFocusedItemId == -1 || !this.mAdapter.hasStableIds()) ? null : findViewHolderForItemId(this.mState.mFocusedItemId);
        if (viewHolderFindViewHolderForItemId != null && !this.mChildHelper.isHidden(viewHolderFindViewHolderForItemId.itemView) && viewHolderFindViewHolderForItemId.itemView.hasFocusable()) {
            viewFindNextViewToFocus = viewHolderFindViewHolderForItemId.itemView;
        } else if (this.mChildHelper.getChildCount() > 0) {
            viewFindNextViewToFocus = findNextViewToFocus();
        }
        if (viewFindNextViewToFocus != null) {
            int i = this.mState.mFocusedSubChildId;
            if (i != -1 && (viewFindViewById = viewFindNextViewToFocus.findViewById(i)) != null && viewFindViewById.isFocusable()) {
                viewFindNextViewToFocus = viewFindViewById;
            }
            viewFindNextViewToFocus.requestFocus();
        }
    }

    private void releaseGlows() {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = this.mLeftGlow.isFinished();
        } else {
            zIsFinished = false;
        }
        EdgeEffect edgeEffect2 = this.mTopGlow;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mRightGlow;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished |= this.mBottomGlow.isFinished();
        }
        if (zIsFinished) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    private int releaseHorizontalGlow(int i, float f) {
        float height = f / getHeight();
        float width = i / getWidth();
        EdgeEffect edgeEffect = this.mLeftGlow;
        float f4 = 0.0f;
        if (edgeEffect == null || EdgeEffectCompat.getDistance(edgeEffect) == 0.0f) {
            EdgeEffect edgeEffect2 = this.mRightGlow;
            if (edgeEffect2 != null && EdgeEffectCompat.getDistance(edgeEffect2) != 0.0f) {
                if (canScrollHorizontally(1)) {
                    this.mRightGlow.onRelease();
                } else {
                    float fOnPullDistance = EdgeEffectCompat.onPullDistance(this.mRightGlow, width, height);
                    if (EdgeEffectCompat.getDistance(this.mRightGlow) == 0.0f) {
                        this.mRightGlow.onRelease();
                    }
                    f4 = fOnPullDistance;
                }
                invalidate();
            }
        } else {
            if (canScrollHorizontally(-1)) {
                this.mLeftGlow.onRelease();
            } else {
                float f5 = -EdgeEffectCompat.onPullDistance(this.mLeftGlow, -width, 1.0f - height);
                if (EdgeEffectCompat.getDistance(this.mLeftGlow) == 0.0f) {
                    this.mLeftGlow.onRelease();
                }
                f4 = f5;
            }
            invalidate();
        }
        return Math.round(f4 * getWidth());
    }

    private int releaseVerticalGlow(int i, float f) {
        float width = f / getWidth();
        float height = i / getHeight();
        EdgeEffect edgeEffect = this.mTopGlow;
        float f4 = 0.0f;
        if (edgeEffect == null || EdgeEffectCompat.getDistance(edgeEffect) == 0.0f) {
            EdgeEffect edgeEffect2 = this.mBottomGlow;
            if (edgeEffect2 != null && EdgeEffectCompat.getDistance(edgeEffect2) != 0.0f) {
                if (canScrollVertically(1)) {
                    this.mBottomGlow.onRelease();
                } else {
                    float fOnPullDistance = EdgeEffectCompat.onPullDistance(this.mBottomGlow, height, 1.0f - width);
                    if (EdgeEffectCompat.getDistance(this.mBottomGlow) == 0.0f) {
                        this.mBottomGlow.onRelease();
                    }
                    f4 = fOnPullDistance;
                }
                invalidate();
            }
        } else {
            if (canScrollVertically(-1)) {
                this.mTopGlow.onRelease();
            } else {
                float f5 = -EdgeEffectCompat.onPullDistance(this.mTopGlow, -height, width);
                if (EdgeEffectCompat.getDistance(this.mTopGlow) == 0.0f) {
                    this.mTopGlow.onRelease();
                }
                f4 = f5;
            }
            invalidate();
        }
        return Math.round(f4 * getHeight());
    }

    private void requestChildOnScreen(@NonNull View view, @Nullable View view2) {
        View view3 = view2 != null ? view2 : view;
        this.mTempRect.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (!layoutParams2.mInsetsDirty) {
                Rect rect = layoutParams2.mDecorInsets;
                Rect rect2 = this.mTempRect;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.mTempRect);
            offsetRectIntoDescendantCoords(view, this.mTempRect);
        }
        this.mLayout.requestChildRectangleOnScreen(this, view, this.mTempRect, !this.mFirstLayoutComplete, view2 == null);
    }

    private void resetFocusInfo() {
        State state = this.mState;
        state.mFocusedItemId = -1L;
        state.mFocusedItemPosition = -1;
        state.mFocusedSubChildId = -1;
    }

    private void resetScroll() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        stopNestedScroll(0);
        releaseGlows();
    }

    private void runLastItemAddDeleteAnim(View view) {
        if (this.mLastItemAddRemoveAnim == null) {
            ItemAnimator itemAnimator = getItemAnimator();
            if ((itemAnimator instanceof DefaultItemAnimator) && this.mLastItemAnimTop == -1) {
                this.mLastItemAnimTop = ((DefaultItemAnimator) itemAnimator).getLastItemBottom();
            }
            if (this.mIsSetOnlyAddAnim) {
                this.mLastItemAddRemoveAnim = ValueAnimator.ofInt(this.mLastItemAnimTop, view.getHeight() + ((int) view.getY()));
            } else {
                if (!this.mIsSetOnlyRemoveAnim) {
                    Log.d(TAG, "Not set only add/remove anim");
                    return;
                }
                this.mLastItemAddRemoveAnim = ValueAnimator.ofInt(this.mLastItemAnimTop, view.getBottom());
            }
            this.mLastItemAddRemoveAnim.setDuration(330L);
            this.mLastItemAddRemoveAnim.addListener(this.mAnimListener);
            this.mLastItemAddRemoveAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.recyclerview.widget.RecyclerView.12
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    RecyclerView.this.mAnimatedBlackTop = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    RecyclerView.this.invalidate();
                }
            });
            this.mLastItemAddRemoveAnim.start();
        }
    }

    private void saveFocusInfo() {
        View focusedChild = (this.mPreserveFocusAfterLayout && hasFocus() && this.mAdapter != null) ? getFocusedChild() : null;
        ViewHolder viewHolderFindContainingViewHolder = focusedChild != null ? findContainingViewHolder(focusedChild) : null;
        if (viewHolderFindContainingViewHolder == null) {
            resetFocusInfo();
            return;
        }
        this.mState.mFocusedItemId = this.mAdapter.hasStableIds() ? viewHolderFindContainingViewHolder.getItemId() : -1L;
        this.mState.mFocusedItemPosition = this.mDataSetHasChangedAfterLayout ? -1 : viewHolderFindContainingViewHolder.isRemoved() ? viewHolderFindContainingViewHolder.mOldPosition : viewHolderFindContainingViewHolder.getAbsoluteAdapterPosition();
        this.mState.mFocusedSubChildId = getDeepestFocusedViewWithId(viewHolderFindContainingViewHolder.itemView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean seslDispatchNestedScroll(int i, int i2, int i4, int i5, int[] iArr, int i6, @NonNull int[] iArr2) {
        return getScrollingChildHelper().seslDispatchNestedScroll(i, i2, i4, i5, iArr, i6, iArr2);
    }

    private void seslRenderFadingEffect(Canvas canvas) {
        this.mFadingEdgeHelper.renderFadingEffect(canvas, this.mScrollInfoProvider);
    }

    private void setAdapterInternal(@Nullable Adapter<?> adapter, boolean z, boolean z2) {
        Adapter adapter2 = this.mAdapter;
        if (adapter2 != null) {
            adapter2.unregisterAdapterDataObserver(this.mObserver);
            this.mAdapter.onDetachedFromRecyclerView(this);
        }
        if (!z || z2) {
            removeAndRecycleViews();
        }
        this.mAdapterHelper.reset();
        Adapter<?> adapter3 = this.mAdapter;
        this.mAdapter = adapter;
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.mObserver);
            adapter.onAttachedToRecyclerView(this);
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.onAdapterChanged(adapter3, this.mAdapter);
        }
        this.mRecycler.onAdapterChanged(adapter3, this.mAdapter, z);
        this.mState.mStructureChanged = true;
    }

    public static void setDebugAssertionsEnabled(boolean z) {
        sDebugAssertionsEnabled = z;
    }

    public static void setVerboseLoggingEnabled(boolean z) {
        sVerboseLoggingEnabled = z;
    }

    private boolean shouldAbsorb(@NonNull EdgeEffect edgeEffect, int i, int i2) {
        if (i > 0) {
            return true;
        }
        return getSplineFlingDistance(-i) < EdgeEffectCompat.getDistance(edgeEffect) * ((float) i2);
    }

    private boolean stopGlowAnimations(MotionEvent motionEvent) {
        boolean z;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || EdgeEffectCompat.getDistance(edgeEffect) == 0.0f || canScrollHorizontally(-1)) {
            z = false;
        } else {
            EdgeEffectCompat.onPullDistance(this.mLeftGlow, 0.0f, 1.0f - (motionEvent.getY() / getHeight()));
            z = true;
        }
        EdgeEffect edgeEffect2 = this.mRightGlow;
        if (edgeEffect2 != null && EdgeEffectCompat.getDistance(edgeEffect2) != 0.0f && !canScrollHorizontally(1)) {
            EdgeEffectCompat.onPullDistance(this.mRightGlow, 0.0f, motionEvent.getY() / getHeight());
            z = true;
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && EdgeEffectCompat.getDistance(edgeEffect3) != 0.0f && !canScrollVertically(-1)) {
            EdgeEffectCompat.onPullDistance(this.mTopGlow, 0.0f, motionEvent.getX() / getWidth());
            z = true;
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 == null || EdgeEffectCompat.getDistance(edgeEffect4) == 0.0f || canScrollVertically(1)) {
            return z;
        }
        EdgeEffectCompat.onPullDistance(this.mBottomGlow, 0.0f, 1.0f - (motionEvent.getX() / getWidth()));
        return true;
    }

    private void stopScrollersInternal() {
        this.mViewFlinger.stop();
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.stopSmoothScroller();
        }
    }

    private SeslGoToTopConfig updateGoToTopConfig() {
        return new SeslGoToTopConfig.Builder().setIconLight(this.mContext.getResources().getDrawable(C0419R.drawable.sesl_list_go_to_top_light)).setIconDark(this.mContext.getResources().getDrawable(C0419R.drawable.sesl_list_go_to_top_dark)).setBackgroundLight(this.mContext.getResources().getDrawable(C3728R.drawable.sesl_go_to_top_background_light, null)).setBackgroundDark(this.mContext.getResources().getDrawable(C3728R.drawable.sesl_go_to_top_background_dark, null)).setBackgroundBlur(this.mContext.getResources().getDrawable(C3728R.drawable.sesl_go_to_top_background_blur, null)).setBackgroundColorBlur(this.mContext.getResources().getColor(C0419R.color.sesl_figma_floating_component_blur_background_dark)).setPaddingBottom(this.mContext.getResources().getDimensionPixelSize(C0419R.dimen.sesl_go_to_top_scrollable_view_gap)).setPaddingLeft(0).setPaddingRight(0).setSize(this.mContext.getResources().getDimensionPixelSize(C0419R.dimen.sesl_go_to_top_scrollable_view_size)).setElevation(this.mContext.getResources().getDimension(C0419R.dimen.sesl_go_to_top_elevation)).setOverlayFeatureHiddenHeightPx(this.mSeslOverlayFeatureHeight).setSizeChanged(false).setFadeInInterpolator(SeslAnimationUtils.SINE_IN_OUT_70).setFadeOutInterpolator(LINEAR_INTERPOLATOR).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLongPressMultiSelection(int i, int i2, boolean z) {
        int height;
        int i4;
        int i5;
        int i6;
        OnScrollListener onScrollListener;
        int childCount = this.mChildHelper.getChildCount();
        if (this.mIsFirstMultiSelectionMove) {
            this.mPenDragStartX = i;
            this.mPenDragStartY = i2;
            float f = i;
            float f4 = i2;
            View viewFindChildViewUnder = findChildViewUnder(f, f4);
            this.mPenTrackedChild = viewFindChildViewUnder;
            if (viewFindChildViewUnder == null) {
                View viewSeslFindNearChildViewUnder = seslFindNearChildViewUnder(f, f4);
                this.mPenTrackedChild = viewSeslFindNearChildViewUnder;
                if (viewSeslFindNearChildViewUnder == null) {
                    Log.e(TAG, "updateLongPressMultiSelection, mPenTrackedChild is NULL");
                    this.mIsFirstMultiSelectionMove = false;
                    return;
                }
            }
            SeslLongPressMultiSelectionListener seslLongPressMultiSelectionListener = this.mLongPressMultiSelectionListener;
            if (seslLongPressMultiSelectionListener != null) {
                seslLongPressMultiSelectionListener.onLongPressMultiSelectionStarted(i, i2);
            }
            int childLayoutPosition = getChildLayoutPosition(this.mPenTrackedChild);
            this.mPenTrackedChildPosition = childLayoutPosition;
            this.mPenDragSelectedViewPosition = childLayoutPosition;
            this.mPenDistanceFromTrackedChildTop = this.mPenDragStartY - this.mPenTrackedChild.getTop();
            this.mIsFirstMultiSelectionMove = false;
        }
        if (this.mIsEnabledPaddingInHoverScroll) {
            int i7 = this.mListPadding.top;
            height = getHeight() - this.mListPadding.bottom;
            i4 = i7;
        } else {
            height = getHeight();
            i4 = 0;
        }
        int i8 = height;
        this.mPenDragEndX = i;
        this.mPenDragEndY = i2;
        if (i2 < 0) {
            this.mPenDragEndY = 0;
        } else if (i2 > i8) {
            this.mPenDragEndY = i8;
        }
        View viewFindChildViewUnder2 = findChildViewUnder(i, this.mPenDragEndY);
        if (viewFindChildViewUnder2 == null && (viewFindChildViewUnder2 = seslFindNearChildViewUnder(this.mPenDragEndX, this.mPenDragEndY)) == null) {
            Log.e(TAG, "updateLongPressMultiSelection, touchedView is NULL");
            return;
        }
        int childLayoutPosition2 = getChildLayoutPosition(viewFindChildViewUnder2);
        if (childLayoutPosition2 == -1) {
            Log.e(TAG, "touchedPosition is NO_POSITION");
            return;
        }
        this.mPenDragSelectedViewPosition = childLayoutPosition2;
        int i9 = this.mPenTrackedChildPosition;
        if (i9 < childLayoutPosition2) {
            i6 = childLayoutPosition2;
            i5 = i9;
        } else {
            i5 = childLayoutPosition2;
            i6 = i9;
        }
        int i10 = this.mPenDragStartX;
        int i11 = this.mPenDragEndX;
        this.mPenDragBlockLeft = i10 < i11 ? i10 : i11;
        int i12 = this.mPenDragStartY;
        int i13 = this.mPenDragEndY;
        this.mPenDragBlockTop = i12 < i13 ? i12 : i13;
        if (i11 > i10) {
            i10 = i11;
        }
        this.mPenDragBlockRight = i10;
        if (i13 > i12) {
            i12 = i13;
        }
        this.mPenDragBlockBottom = i12;
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (childAt != null) {
                this.mPenDragSelectedViewPosition = getChildLayoutPosition(childAt);
                if (childAt.getVisibility() == 0) {
                    int i15 = this.mPenDragSelectedViewPosition;
                    if (i5 > i15 || i15 > i6 || i15 == this.mPenTrackedChildPosition) {
                        if (i15 != -1 && this.mPenDragSelectedItemArray.contains(Integer.valueOf(i15))) {
                            this.mPenDragSelectedItemArray.remove(Integer.valueOf(this.mPenDragSelectedViewPosition));
                            SeslLongPressMultiSelectionListener seslLongPressMultiSelectionListener2 = this.mLongPressMultiSelectionListener;
                            if (seslLongPressMultiSelectionListener2 != null) {
                                seslLongPressMultiSelectionListener2.onItemSelected(this, childAt, this.mPenDragSelectedViewPosition, getChildItemId(childAt));
                            }
                        }
                    } else if (i15 != -1 && !this.mPenDragSelectedItemArray.contains(Integer.valueOf(i15))) {
                        this.mPenDragSelectedItemArray.add(Integer.valueOf(this.mPenDragSelectedViewPosition));
                        SeslLongPressMultiSelectionListener seslLongPressMultiSelectionListener3 = this.mLongPressMultiSelectionListener;
                        if (seslLongPressMultiSelectionListener3 != null) {
                            seslLongPressMultiSelectionListener3.onItemSelected(this, childAt, this.mPenDragSelectedViewPosition, getChildItemId(childAt));
                        }
                    }
                }
            }
        }
        int i16 = this.mLastTouchY - i2;
        if (z && Math.abs(i16) >= this.mTouchSlop) {
            if (i2 <= i4 + this.mHoverTopAreaHeight + this.mHoverDefaultTopAreaHeight && i16 > 0) {
                if (!this.mHoverAreaEnter) {
                    this.mHoverAreaEnter = true;
                    this.mHoverScrollStartTime = System.currentTimeMillis();
                    OnScrollListener onScrollListener2 = this.mScrollListener;
                    if (onScrollListener2 != null) {
                        onScrollListener2.onScrollStateChanged(this, 1);
                    }
                }
                if (!this.mHoverHandler.hasMessages(0)) {
                    this.mHoverRecognitionStartTime = System.currentTimeMillis();
                    this.mHoverScrollDirection = 2;
                    this.mHoverHandler.sendEmptyMessage(0);
                }
            } else if (i2 < ((i8 - this.mHoverBottomAreaHeight) - this.mHoverDefaultBottomAreaHeight) - this.mRemainNestedScrollRange || i16 >= 0) {
                if (this.mHoverAreaEnter && (onScrollListener = this.mScrollListener) != null) {
                    onScrollListener.onScrollStateChanged(this, 0);
                }
                this.mHoverScrollStartTime = 0L;
                this.mHoverRecognitionStartTime = 0L;
                this.mHoverAreaEnter = false;
                if (this.mHoverHandler.hasMessages(0)) {
                    this.mHoverHandler.removeMessages(0);
                    if (this.mScrollState == 1) {
                        setScrollState(0);
                    }
                }
                this.mIsHoverOverscrolled = false;
            } else {
                if (!this.mHoverAreaEnter) {
                    this.mHoverAreaEnter = true;
                    this.mHoverScrollStartTime = System.currentTimeMillis();
                    OnScrollListener onScrollListener3 = this.mScrollListener;
                    if (onScrollListener3 != null) {
                        onScrollListener3.onScrollStateChanged(this, 1);
                    }
                }
                if (!this.mHoverHandler.hasMessages(0)) {
                    this.mHoverRecognitionStartTime = System.currentTimeMillis();
                    this.mHoverScrollDirection = 1;
                    this.mHoverHandler.sendEmptyMessage(0);
                }
            }
        }
        invalidate();
    }

    private void updateScrollbarVerticalPadding() {
        SeslViewReflector.semSetScrollBarTopPadding(this, this.mScrollbarTopPadding + this.mScrollBarTopOffset);
        SeslViewReflector.semSetScrollBarBottomPadding(this, this.mScrollbarBottomPadding + this.mScrollBarBottomOffset);
    }

    public void absorbGlows(int i, int i2) {
        if (i < 0) {
            ensureLeftGlow();
            if (this.mLeftGlow.isFinished()) {
                this.mLeftGlow.onAbsorb(-i);
            }
        } else if (i > 0) {
            ensureRightGlow();
            if (this.mRightGlow.isFinished()) {
                this.mRightGlow.onAbsorb(i);
            }
        }
        if (i2 < 0) {
            ensureTopGlow();
            if (this.mTopGlow.isFinished()) {
                this.mTopGlow.onAbsorb(-i2);
            }
        } else if (i2 > 0) {
            ensureBottomGlow();
            if (this.mBottomGlow.isFinished()) {
                this.mBottomGlow.onAbsorb(i2);
            }
        }
        if (i == 0 && i2 == 0) {
            return;
        }
        ViewCompat.postInvalidateOnAnimation(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null || !layoutManager.onAddFocusables(this, arrayList, i, i2)) {
            super.addFocusables(arrayList, i, i2);
        }
    }

    public void addItemDecoration(@NonNull ItemDecoration itemDecoration, int i) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
        }
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i < 0) {
            this.mItemDecorations.add(itemDecoration);
        } else {
            this.mItemDecorations.add(i, itemDecoration);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void addOnChildAttachStateChangeListener(@NonNull OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        if (this.mOnChildAttachStateListeners == null) {
            this.mOnChildAttachStateListeners = new ArrayList();
        }
        this.mOnChildAttachStateListeners.add(onChildAttachStateChangeListener);
    }

    public void addOnItemTouchListener(@NonNull OnItemTouchListener onItemTouchListener) {
        this.mOnItemTouchListeners.add(onItemTouchListener);
    }

    public void addOnScrollListener(@NonNull OnScrollListener onScrollListener) {
        if (this.mScrollListeners == null) {
            this.mScrollListeners = new ArrayList();
        }
        this.mScrollListeners.add(onScrollListener);
    }

    public void addRecyclerListener(@NonNull RecyclerListener recyclerListener) {
        Preconditions.checkArgument(recyclerListener != null, "'listener' arg cannot be null.");
        this.mRecyclerListeners.add(recyclerListener);
    }

    public void animateAppearance(@NonNull ViewHolder viewHolder, @Nullable ItemAnimator.ItemHolderInfo itemHolderInfo, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        viewHolder.setIsRecyclable(false);
        if (this.mItemAnimator.animateAppearance(viewHolder, itemHolderInfo, itemHolderInfo2)) {
            postAnimationRunner();
        }
    }

    public void animateDisappearance(@NonNull ViewHolder viewHolder, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo, @Nullable ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        addAnimatingView(viewHolder);
        viewHolder.setIsRecyclable(false);
        if (this.mItemAnimator.animateDisappearance(viewHolder, itemHolderInfo, itemHolderInfo2)) {
            postAnimationRunner();
        }
    }

    public void assertInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            return;
        }
        if (str != null) {
            throw new IllegalStateException(AbstractC2821a.m2219j(this, AbstractC1974b.m1324q(str)));
        }
        throw new IllegalStateException(AbstractC2821a.m2219j(this, new StringBuilder("Cannot call this method unless RecyclerView is computing a layout or scrolling")));
    }

    public void assertNotInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            if (str != null) {
                throw new IllegalStateException(str);
            }
            throw new IllegalStateException(AbstractC2821a.m2219j(this, new StringBuilder("Cannot call this method while RecyclerView is computing a layout or scrolling")));
        }
        if (this.mDispatchScrollCounter > 0) {
            Log.w(TAG, "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(AbstractC2821a.m2219j(this, new StringBuilder(""))));
        }
    }

    public boolean canReuseUpdatedViewHolder(ViewHolder viewHolder) {
        ItemAnimator itemAnimator = this.mItemAnimator;
        return itemAnimator == null || itemAnimator.canReuseUpdatedViewHolder(viewHolder, viewHolder.getUnmodifiedPayloads());
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && this.mLayout.checkLayoutParams((LayoutParams) layoutParams);
    }

    public void clearOldPositions() {
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i = 0; i < unfilteredChildCount; i++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.clearOldPosition();
            }
        }
        this.mRecycler.clearOldPositions();
    }

    public void clearOnChildAttachStateChangeListeners() {
        List<OnChildAttachStateChangeListener> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void clearOnScrollListeners() {
        List<OnScrollListener> list = this.mScrollListeners;
        if (list != null) {
            list.clear();
        }
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollExtent() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollExtent(this.mState);
        }
        return 0;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollOffset() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollOffset(this.mState);
        }
        return 0;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollRange() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollRange(this.mState);
        }
        return 0;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollExtent() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollExtent(this.mState);
        }
        return 0;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollOffset() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollOffset(this.mState);
        }
        return 0;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollRange() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollRange(this.mState);
        }
        return 0;
    }

    public void considerReleasingGlowsOnScroll(int i, int i2) {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished() || i <= 0) {
            zIsFinished = false;
        } else {
            this.mLeftGlow.onRelease();
            zIsFinished = this.mLeftGlow.isFinished();
        }
        EdgeEffect edgeEffect2 = this.mRightGlow;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i < 0) {
            this.mRightGlow.onRelease();
            zIsFinished |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i2 > 0) {
            this.mTopGlow.onRelease();
            zIsFinished |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i2 < 0) {
            this.mBottomGlow.onRelease();
            zIsFinished |= this.mBottomGlow.isFinished();
        }
        if (zIsFinished) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public int consumeFlingInHorizontalStretch(int i) {
        return consumeFlingInStretch(i, this.mLeftGlow, this.mRightGlow, getWidth());
    }

    public int consumeFlingInVerticalStretch(int i) {
        return consumeFlingInStretch(i, this.mTopGlow, this.mBottomGlow, getHeight());
    }

    public void consumePendingUpdateOperations() {
        if (!this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout) {
            TraceCompat.beginSection(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
            dispatchLayout();
            TraceCompat.endSection();
            return;
        }
        if (this.mAdapterHelper.hasPendingUpdates()) {
            if (!this.mAdapterHelper.hasAnyUpdateTypes(4) || this.mAdapterHelper.hasAnyUpdateTypes(11)) {
                if (this.mAdapterHelper.hasPendingUpdates()) {
                    TraceCompat.beginSection(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
                    dispatchLayout();
                    TraceCompat.endSection();
                    return;
                }
                return;
            }
            TraceCompat.beginSection(TRACE_HANDLE_ADAPTER_UPDATES_TAG);
            startInterceptRequestLayout();
            onEnterLayoutOrScroll();
            this.mAdapterHelper.preProcess();
            if (!this.mLayoutWasDefered) {
                if (hasUpdatedView()) {
                    dispatchLayout();
                } else {
                    this.mAdapterHelper.consumePostponedUpdates();
                }
            }
            stopInterceptRequestLayout(true);
            onExitLayoutOrScroll();
            TraceCompat.endSection();
        }
    }

    public void defaultOnMeasure(int i, int i2) {
        setMeasuredDimension(LayoutManager.chooseSize(i, getPaddingRight() + getPaddingLeft(), ViewCompat.getMinimumWidth(this)), LayoutManager.chooseSize(i2, getPaddingBottom() + getPaddingTop(), ViewCompat.getMinimumHeight(this)));
    }

    public void dispatchChildAttached(View view) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        onChildAttachedToWindow(view);
        Adapter adapter = this.mAdapter;
        if (adapter != null && childViewHolderInt != null) {
            adapter.onViewAttachedToWindow(childViewHolderInt);
        }
        List<OnChildAttachStateChangeListener> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).onChildViewAttachedToWindow(view);
            }
        }
    }

    public void dispatchChildDetached(View view) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        onChildDetachedFromWindow(view);
        Adapter adapter = this.mAdapter;
        if (adapter != null && childViewHolderInt != null) {
            adapter.onViewDetachedFromWindow(childViewHolderInt);
        }
        List<OnChildAttachStateChangeListener> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).onChildViewDetachedFromWindow(view);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0032  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void dispatchDraw(Canvas canvas) {
        Canvas canvas2;
        int i;
        View childAt;
        super.dispatchDraw(canvas);
        if (this.mDebugDrawAvailRect) {
            Paint paint = new Paint();
            paint.setColor(-16776961);
            paint.setAlpha(128);
            paint.setStyle(Paint.Style.FILL);
            if (this.mAvailableBounds != null) {
                canvas.drawRect(r0.left, r0.top, r0.right, r0.bottom, paint);
                canvas2 = canvas;
            } else {
                canvas2 = canvas;
            }
        }
        int size = this.mItemDecorations.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mItemDecorations.get(i2).seslOnDispatchDraw(canvas2, this, this.mState);
        }
        int width = getWidth();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        if (!this.mDrawRect || ((this.mBlackTop == -1 && this.mLastBlackTop == -1) || canScrollVertically(-1) || (canScrollVertically(1) && !isAnimating()))) {
            i = paddingLeft;
        } else {
            ValueAnimator valueAnimator = this.mLastItemAddRemoveAnim;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                this.mAnimatedBlackTop = this.mBlackTop;
            }
            if (isAnimating()) {
                int pendingAnimFlag = getPendingAnimFlag();
                if (pendingAnimFlag == 8) {
                    this.mIsSetOnlyAddAnim = true;
                } else if (pendingAnimFlag == 1) {
                    this.mIsSetOnlyRemoveAnim = true;
                }
                if (this.mDrawReverse) {
                    childAt = this.mBlackTop != -1 ? this.mChildHelper.getChildAt(0) : getChildAt(0);
                } else if (this.mBlackTop != -1) {
                    ChildHelper childHelper = this.mChildHelper;
                    childAt = childHelper.getChildAt(childHelper.getChildCount() - 1);
                } else {
                    childAt = getChildAt(getChildCount() - 1);
                }
                if (childAt != null) {
                    if (this.mIsSetOnlyAddAnim || this.mIsSetOnlyRemoveAnim) {
                        runLastItemAddDeleteAnim(childAt);
                    } else {
                        this.mAnimatedBlackTop = childAt.getHeight() + Math.round(childAt.getY());
                    }
                }
                invalidate();
            }
            int i4 = this.mBlackTop;
            if (i4 != -1 || this.mAnimatedBlackTop != i4 || this.mIsSetOnlyAddAnim) {
                canvas2.drawRect(0.0f, this.mAnimatedBlackTop, width, getBottom(), this.mRectPaint);
                if (this.mDrawLastRoundedCorner) {
                    Canvas canvas3 = canvas2;
                    i = paddingLeft;
                    this.mRoundedCorner.drawRoundedCorner(i, this.mAnimatedBlackTop, width - paddingRight, getBottom(), canvas3);
                    canvas2 = canvas3;
                }
            }
        }
        this.mLastItemAnimTop = this.mBlackTop;
        if (this.mDrawHorizontalPadding) {
            int height = getHeight();
            if (i > 0) {
                canvas2.drawRect(0.0f, 0.0f, i, height, this.mRectPaint);
            }
            if (paddingRight > 0) {
                canvas2.drawRect(width - paddingRight, 0.0f, width, height, this.mRectPaint);
            }
        }
        if (this.mFadingEdgeHelper.isFadingEdgeEnabled()) {
            seslRenderFadingEffect(canvas2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:175:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x03c0  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        int i;
        int width;
        int i2;
        SeslGoToTopController seslGoToTopController;
        int i4;
        int i5;
        int i6;
        if (this.mAdapter == null) {
            Log.d(TAG, "No adapter attached; skipping hover scroll");
            return super.dispatchHoverEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        int toolType = motionEvent.getToolType(0);
        if ((action == 7 || action == 9) && toolType == 2) {
            this.mIsPenHovered = true;
        } else if (action == 10) {
            this.mIsPenHovered = false;
        }
        boolean zSemIsTextViewHovered = SeslTextViewReflector.semIsTextViewHovered();
        this.mNewTextViewHoverState = zSemIsTextViewHovered;
        if (!zSemIsTextViewHovered && this.mOldTextViewHoverState && this.mIsPenDragBlockEnabled && (motionEvent.getButtonState() == 32 || motionEvent.getButtonState() == 2)) {
            this.mIsNeedPenSelectIconSet = true;
        } else {
            this.mIsNeedPenSelectIconSet = false;
        }
        this.mOldTextViewHoverState = this.mNewTextViewHoverState;
        if (action == 9 || this.mHoverScrollStateChanged) {
            this.mNeedsHoverScroll = true;
            this.mHoverScrollStateChanged = false;
            if (this.mHasNestedScrollRange) {
                adjustNestedScrollRange();
            }
            if (!this.mHoverScrollEnable) {
                this.mNeedsHoverScroll = false;
            }
            if (this.mNeedsHoverScroll && toolType == 2) {
                boolean z = Settings.System.getInt(this.mContext.getContentResolver(), SeslSettingsReflector.SeslSystemReflector.getField_SEM_PEN_HOVERING(), 0) == 1;
                try {
                } catch (Settings.SettingNotFoundException unused) {
                    Log.i(TAG, "dispatchHoverEvent car_mode_on SettingNotFoundException");
                }
                boolean z2 = Settings.System.getInt(this.mContext.getContentResolver(), "car_mode_on") == 1;
                if (!z || z2) {
                    this.mNeedsHoverScroll = false;
                }
                if (z && this.mIsPenDragBlockEnabled && !this.mIsPenSelectPointerSetted && this.mIsPenSelectionEnabled && (motionEvent.getButtonState() == 32 || motionEvent.getButtonState() == 2)) {
                    showPointerIcon(motionEvent, SeslPointerIconReflector.getField_SEM_TYPE_STYLUS_PEN_SELECT());
                    this.mIsPenSelectPointerSetted = true;
                }
            }
            if (this.mNeedsHoverScroll && toolType == 3) {
                this.mNeedsHoverScroll = false;
            }
        } else if (action == 7) {
            if ((this.mIsPenDragBlockEnabled && !this.mIsPenSelectPointerSetted && this.mIsPenSelectionEnabled && motionEvent.getToolType(0) == 2 && (motionEvent.getButtonState() == 32 || motionEvent.getButtonState() == 2)) || this.mIsNeedPenSelectIconSet) {
                showPointerIcon(motionEvent, SeslPointerIconReflector.getField_SEM_TYPE_STYLUS_PEN_SELECT());
                this.mIsPenSelectPointerSetted = true;
            } else if (this.mIsPenDragBlockEnabled && this.mIsPenSelectPointerSetted && motionEvent.getButtonState() != 32 && motionEvent.getButtonState() != 2) {
                showPointerIcon(motionEvent, SeslPointerIconReflector.getField_SEM_TYPE_STYLUS_DEFAULT());
                this.mIsPenSelectPointerSetted = false;
            }
        } else if (action == 10 && this.mIsPenSelectPointerSetted) {
            showPointerIcon(motionEvent, SeslPointerIconReflector.getField_SEM_TYPE_STYLUS_DEFAULT());
            this.mIsPenSelectPointerSetted = false;
        }
        if (!this.mNeedsHoverScroll) {
            return super.dispatchHoverEvent(motionEvent);
        }
        boolean zCanScrollHorizontally = this.mLayout.canScrollHorizontally();
        int y2 = (int) (zCanScrollHorizontally ? motionEvent.getY() : motionEvent.getX());
        int x = (int) (zCanScrollHorizontally ? motionEvent.getX() : motionEvent.getY());
        if (this.mIsEnabledPaddingInHoverScroll) {
            i = this.mListPadding.top;
            width = getHeight() - this.mListPadding.bottom;
        } else {
            i = this.mExtraPaddingInTopHoverArea;
            width = zCanScrollHorizontally ? getWidth() : getHeight();
        }
        boolean zCanScrollDown = this.mRemainNestedScrollRange > 0 ? true : canScrollDown();
        boolean zCanScrollUp = canScrollUp();
        boolean z3 = motionEvent.getToolType(0) == 2;
        if ((x <= this.mHoverTopAreaHeight + i + this.mHoverDefaultTopAreaHeight || x >= ((width - this.mHoverBottomAreaHeight) - this.mHoverDefaultBottomAreaHeight) - this.mRemainNestedScrollRange) && y2 > 0) {
            if (y2 <= (zCanScrollHorizontally ? getBottom() : getRight()) && ((zCanScrollUp || zCanScrollDown) && (x < i || x > this.mHoverTopAreaHeight + i + this.mHoverDefaultTopAreaHeight || zCanScrollUp || !this.mIsHoverOverscrolled))) {
                int i7 = (width - this.mHoverBottomAreaHeight) - this.mHoverDefaultBottomAreaHeight;
                int i8 = this.mRemainNestedScrollRange;
                if ((x < i7 - i8 || x > width - i8 || zCanScrollDown || !this.mIsHoverOverscrolled) && ((!z3 || (motionEvent.getButtonState() != 32 && motionEvent.getButtonState() != 2)) && z3 && !isLockScreenMode())) {
                    if (this.mHasNestedScrollRange && (i5 = this.mRemainNestedScrollRange) > 0 && i5 != this.mNestedScrollRange) {
                        adjustNestedScrollRange();
                    }
                    if (!this.mHoverAreaEnter) {
                        this.mHoverScrollStartTime = System.currentTimeMillis();
                    }
                    if (this.mRemainNestedScrollRange != 0) {
                        Rect rect = new Rect();
                        getLocalVisibleRect(rect);
                        i2 = width <= rect.bottom ? 0 : this.mRemainNestedScrollRange;
                    }
                    if (action != 7) {
                        if (action == 9) {
                            this.mHoverAreaEnter = true;
                            if (x < i || x > i + this.mHoverTopAreaHeight + this.mHoverDefaultTopAreaHeight) {
                                if (x >= ((width - this.mHoverBottomAreaHeight) - this.mHoverDefaultBottomAreaHeight) - i2 && x <= width - i2 && !this.mHoverHandler.hasMessages(0)) {
                                    this.mHoverRecognitionStartTime = System.currentTimeMillis();
                                    showPointerIcon(motionEvent, getRotatedArrowPointerIcon(true, zCanScrollHorizontally));
                                    this.mHoverScrollDirection = 1;
                                    this.mHoverHandler.sendEmptyMessage(0);
                                    return true;
                                }
                            } else if (!this.mHoverHandler.hasMessages(0)) {
                                this.mHoverRecognitionStartTime = System.currentTimeMillis();
                                showPointerIcon(motionEvent, getRotatedArrowPointerIcon(false, zCanScrollHorizontally));
                                this.mHoverScrollDirection = 2;
                                this.mHoverHandler.sendEmptyMessage(0);
                            }
                        } else if (action == 10) {
                            if (this.mHoverHandler.hasMessages(0)) {
                                this.mHoverHandler.removeMessages(0);
                            }
                            if (this.mScrollState == 1) {
                                setScrollState(0);
                            }
                            showPointerIcon(motionEvent, SeslPointerIconReflector.getField_SEM_TYPE_STYLUS_DEFAULT());
                            this.mHoverRecognitionStartTime = 0L;
                            this.mHoverScrollStartTime = 0L;
                            this.mIsHoverOverscrolled = false;
                            this.mHoverAreaEnter = false;
                            this.mIsSendHoverScrollState = false;
                            if (this.mHoverScrollStateForListener != 0) {
                                this.mHoverScrollStateForListener = 0;
                                OnScrollListener onScrollListener = this.mScrollListener;
                                if (onScrollListener != null) {
                                    onScrollListener.onScrollStateChanged(this, 0);
                                }
                            }
                            return super.dispatchHoverEvent(motionEvent);
                        }
                    } else {
                        if (!this.mHoverAreaEnter) {
                            this.mHoverAreaEnter = true;
                            motionEvent.setAction(10);
                            return super.dispatchHoverEvent(motionEvent);
                        }
                        if (x < i || x > i + this.mHoverTopAreaHeight + this.mHoverDefaultTopAreaHeight) {
                            if (x < ((width - this.mHoverBottomAreaHeight) - this.mHoverDefaultBottomAreaHeight) - i2 || x > width - i2 || ((seslGoToTopController = this.mGoToTopController) != null && seslGoToTopController.dispatchHoverEvent(motionEvent))) {
                                if (this.mHoverHandler.hasMessages(0)) {
                                    this.mHoverHandler.removeMessages(0);
                                    if (this.mScrollState == 1) {
                                        setScrollState(0);
                                    }
                                }
                                showPointerIcon(motionEvent, SeslPointerIconReflector.getField_SEM_TYPE_STYLUS_DEFAULT());
                                this.mHoverRecognitionStartTime = 0L;
                                this.mHoverScrollStartTime = 0L;
                                this.mIsHoverOverscrolled = false;
                                this.mHoverAreaEnter = false;
                                this.mIsSendHoverScrollState = false;
                            } else if (!this.mHoverHandler.hasMessages(0)) {
                                this.mHoverRecognitionStartTime = System.currentTimeMillis();
                                if (!this.mIsHoverOverscrolled || this.mHoverScrollDirection == 2) {
                                    i4 = 1;
                                    showPointerIcon(motionEvent, getRotatedArrowPointerIcon(true, zCanScrollHorizontally));
                                } else {
                                    i4 = 1;
                                }
                                this.mHoverScrollDirection = i4;
                                this.mHoverHandler.sendEmptyMessage(0);
                                SeslGoToTopController seslGoToTopController2 = this.mGoToTopController;
                                if (seslGoToTopController2 != null) {
                                    seslGoToTopController2.dispatchHoverEvent(motionEvent);
                                }
                            }
                        } else if (!this.mHoverHandler.hasMessages(0)) {
                            this.mHoverRecognitionStartTime = System.currentTimeMillis();
                            if (!this.mIsHoverOverscrolled || this.mHoverScrollDirection == 1) {
                                showPointerIcon(motionEvent, getRotatedArrowPointerIcon(false, zCanScrollHorizontally));
                            }
                            this.mHoverScrollDirection = 2;
                            this.mHoverHandler.sendEmptyMessage(0);
                        }
                    }
                    return true;
                }
            }
        }
        if (this.mHasNestedScrollRange && (i6 = this.mRemainNestedScrollRange) > 0 && i6 != this.mNestedScrollRange) {
            adjustNestedScrollRange();
        }
        if (this.mHoverHandler.hasMessages(0)) {
            this.mHoverHandler.removeMessages(0);
            showPointerIcon(motionEvent, SeslPointerIconReflector.getField_SEM_TYPE_STYLUS_DEFAULT());
            if (this.mScrollState == 1) {
                setScrollState(0);
            }
        }
        if ((x <= i + this.mHoverTopAreaHeight + this.mHoverDefaultTopAreaHeight || x >= ((width - this.mHoverBottomAreaHeight) - this.mHoverDefaultBottomAreaHeight) - this.mRemainNestedScrollRange) && y2 > 0) {
            if (y2 > (zCanScrollHorizontally ? getBottom() : getRight())) {
                this.mIsHoverOverscrolled = false;
            }
        }
        if (this.mHoverAreaEnter || this.mHoverScrollStartTime != 0) {
            showPointerIcon(motionEvent, SeslPointerIconReflector.getField_SEM_TYPE_STYLUS_DEFAULT());
        }
        this.mHoverRecognitionStartTime = 0L;
        this.mHoverScrollStartTime = 0L;
        this.mHoverAreaEnter = false;
        this.mIsSendHoverScrollState = false;
        if (action == 10) {
            if (this.mHoverScrollStateForListener != 0) {
                this.mHoverScrollStateForListener = 0;
                OnScrollListener onScrollListener2 = this.mScrollListener;
                if (onScrollListener2 != null) {
                    onScrollListener2.onScrollStateChanged(this, 0);
                }
            } else {
                this.mIsHoverOverscrolled = false;
            }
            showPointerIcon(motionEvent, SeslPointerIconReflector.getField_SEM_TYPE_STYLUS_DEFAULT());
        }
        return super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 19 || keyCode == 20) {
            if (keyEvent.getAction() == 0) {
                this.mIsArrowKeyPressed = true;
            }
        } else if (keyCode == 66 && this.mIsRecoilSupported && this.mIsRecoilEnabled) {
            if (keyEvent.getAction() == 0) {
                View focusedChild = getFocusedChild();
                if (focusedChild != null) {
                    this.mItemAnimatorHolder.setPress(focusedChild);
                }
            } else {
                this.mItemAnimatorHolder.setRelease();
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public void dispatchLayout() {
        if (this.mAdapter == null) {
            Log.w(TAG, "No adapter attached; skipping layout");
            return;
        }
        if (this.mLayout == null) {
            Log.e(TAG, "No layout manager attached; skipping layout");
            return;
        }
        this.mState.mIsMeasuring = false;
        boolean z = this.mLastAutoMeasureSkippedDueToExact && !(this.mLastAutoMeasureNonExactMeasuredWidth == getWidth() && this.mLastAutoMeasureNonExactMeasuredHeight == getHeight());
        this.mLastAutoMeasureNonExactMeasuredWidth = 0;
        this.mLastAutoMeasureNonExactMeasuredHeight = 0;
        this.mLastAutoMeasureSkippedDueToExact = false;
        if (this.mState.mLayoutStep == 1) {
            dispatchLayoutStep1();
            this.mLayout.setExactMeasureSpecsFrom(this);
            dispatchLayoutStep2();
        } else if (this.mAdapterHelper.hasUpdates() || z || this.mLayout.getWidth() != getWidth() || this.mLayout.getHeight() != getHeight()) {
            this.mLayout.setExactMeasureSpecsFrom(this);
            dispatchLayoutStep2();
        } else {
            this.mLayout.setExactMeasureSpecsFrom(this);
        }
        dispatchLayoutStep3();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f, float f4, boolean z) {
        return getScrollingChildHelper().dispatchNestedFling(f, f4, z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f, float f4) {
        return getScrollingChildHelper().dispatchNestedPreFling(f, f4);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        if (this.mGoToTopController != null && canScrollDown()) {
            this.mGoToTopController.invalidate();
        }
        return getScrollingChildHelper().dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i, int i2, int i4, int i5, int[] iArr) {
        return getScrollingChildHelper().dispatchNestedScroll(i, i2, i4, i5, iArr);
    }

    public void dispatchOnScrollStateChanged(int i) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.onScrollStateChanged(i);
        }
        onScrollStateChanged(i);
        OnScrollListener onScrollListener = this.mScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(this, i);
        }
        List<OnScrollListener> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrollStateChanged(this, i);
            }
        }
    }

    public void dispatchOnScrolled(int i, int i2) {
        this.mDispatchScrollCounter++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i, scrollY - i2);
        onScrolled(i, i2);
        SeslRecyclerViewFastScroller seslRecyclerViewFastScroller = this.mFastScroller;
        if (seslRecyclerViewFastScroller != null && this.mAdapter != null && (i != 0 || i2 != 0)) {
            seslRecyclerViewFastScroller.onScroll(findFirstVisibleItemPosition(), getChildCount(), this.mAdapter.getItemCount());
        }
        if (this.mIndexTipEnabled && this.mIndexTip != null) {
            if (this.mScrollState != 0 && getHeight() > this.mSeslOverlayFeatureHeight) {
                this.mIndexTip.show(this.mScrollState, i2);
            } else if (this.mIsActionScrollFromMouse && i2 != 0) {
                this.mIndexTip.showWithTimer(this.mScrollState, i2);
            }
            this.mIndexTip.invalidate();
        }
        OnScrollListener onScrollListener = this.mScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrolled(this, i, i2);
        }
        List<OnScrollListener> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrolled(this, i, i2);
            }
        }
        this.mDispatchScrollCounter--;
    }

    public void dispatchPendingImportantForAccessibilityChanges() {
        int i;
        for (int size = this.mPendingAccessibilityImportanceChange.size() - 1; size >= 0; size--) {
            ViewHolder viewHolder = this.mPendingAccessibilityImportanceChange.get(size);
            if (viewHolder.itemView.getParent() == this && !viewHolder.shouldIgnore() && (i = viewHolder.mPendingAccessibilityState) != -1) {
                ViewCompat.setImportantForAccessibility(viewHolder.itemView, i);
                viewHolder.mPendingAccessibilityState = -1;
            }
        }
        this.mPendingAccessibilityImportanceChange.clear();
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x013e  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int height;
        int i;
        RecyclerView recyclerView;
        SeslGoToTopController seslGoToTopController;
        if (this.mLayout == null) {
            Log.d(TAG, "No layout manager attached; skipping gototop & multiselection");
            return super.dispatchTouchEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        int x = (int) (motionEvent.getX() + 0.5f);
        int y2 = (int) (motionEvent.getY() + 0.5f);
        boolean z = motionEvent.getToolType(0) == 2;
        int i2 = Build.VERSION.SDK_INT;
        boolean z2 = (motionEvent.getButtonState() & 32) != 0;
        if (!this.mIsPenButtonPressed) {
            this.mIsPenButtonPressed = z && z2;
        }
        if (this.mPenDragSelectedItemArray == null) {
            this.mPenDragSelectedItemArray = new ArrayList<>();
        }
        if (this.mIsEnabledPaddingInHoverScroll) {
            i = this.mListPadding.top;
            height = getHeight() - this.mListPadding.bottom;
        } else {
            height = getHeight();
            i = 0;
        }
        this.mIsNeedPenSelection = this.mIsPenSelectionEnabled && !SeslTextViewReflector.semIsTextSelectionProgressing();
        int i4 = i;
        if (actionMasked == 0) {
            boolean z3 = z2;
            int i5 = height;
            if ((!z || !z3) && actionMasked != 211) {
                SeslGoToTopController seslGoToTopController2 = this.mGoToTopController;
                if (seslGoToTopController2 != null && seslGoToTopController2.onTouchEvent(motionEvent)) {
                    return true;
                }
                if (this.mIsCtrlKeyPressed && motionEvent.getToolType(0) == 3) {
                    this.mIsCtrlMultiSelection = true;
                    this.mIsNeedPenSelection = true;
                    multiSelection(x, y2, i4, i5, false);
                    return true;
                }
                if (this.mIsLongPressMultiSelection) {
                    this.mIsLongPressMultiSelection = false;
                }
            } else if (this.mPenDragSelectedItemArray == null) {
                this.mPenDragSelectedItemArray = new ArrayList<>();
            }
        } else if (actionMasked == 1) {
            recyclerView = this;
            if (i2 >= 34 || !z || !z2) {
                if (!recyclerView.mIsCtrlMultiSelection) {
                    multiSelectionEnd(x, y2);
                    recyclerView.mIsCtrlMultiSelection = false;
                    return true;
                }
                if (recyclerView.mIsLongPressMultiSelection) {
                    SeslLongPressMultiSelectionListener seslLongPressMultiSelectionListener = recyclerView.mLongPressMultiSelectionListener;
                    if (seslLongPressMultiSelectionListener != null) {
                        seslLongPressMultiSelectionListener.onLongPressMultiSelectionEnded(x, y2);
                    }
                    recyclerView.mIsFirstMultiSelectionMove = true;
                    recyclerView.mPenDragSelectedViewPosition = -1;
                    recyclerView.mPenDragStartX = 0;
                    recyclerView.mPenDragStartY = 0;
                    recyclerView.mPenDragEndX = 0;
                    recyclerView.mPenDragEndY = 0;
                    recyclerView.mPenDragBlockLeft = 0;
                    recyclerView.mPenDragBlockTop = 0;
                    recyclerView.mPenDragBlockRight = 0;
                    recyclerView.mPenDragBlockBottom = 0;
                    recyclerView.mPenDragSelectedItemArray.clear();
                    recyclerView.mPenTrackedChild = null;
                    recyclerView.mPenDistanceFromTrackedChildTop = 0;
                    if (recyclerView.mHoverHandler.hasMessages(0)) {
                        recyclerView.mHoverHandler.removeMessages(0);
                        if (recyclerView.mScrollState == 1) {
                            setScrollState(0);
                        }
                    }
                    recyclerView.mIsHoverOverscrolled = false;
                    invalidate();
                    recyclerView.mIsLongPressMultiSelection = false;
                }
            }
            recyclerView.mIsPenButtonPressed = false;
            seslGoToTopController = recyclerView.mGoToTopController;
            if (seslGoToTopController == null && seslGoToTopController.onTouchEvent(motionEvent)) {
                return true;
            }
            if (!recyclerView.mIsPenPressed) {
                multiSelectionEnd(x, y2);
                return true;
            }
            multiSelectionEnd(x, y2);
            if (recyclerView.mIsRecoilSupported && recyclerView.mIsRecoilEnabled) {
                recyclerView.mItemBackgroundHolder.setRelease();
                recyclerView.mItemAnimatorHolder.setRelease();
            }
        } else if (actionMasked == 2) {
            if ((z && z2) || this.mIsPenButtonPressed || actionMasked == 213) {
                multiSelection(x, y2, i4, height, false);
            } else {
                if (this.mIsCtrlMultiSelection) {
                    multiSelection(x, y2, i4, height, false);
                    return true;
                }
                if (this.mIsLongPressMultiSelection) {
                    updateLongPressMultiSelection(x, y2, true);
                    return true;
                }
                SeslGoToTopController seslGoToTopController3 = this.mGoToTopController;
                if (seslGoToTopController3 != null && seslGoToTopController3.onTouchEvent(motionEvent)) {
                    return true;
                }
            }
        } else if (actionMasked != 3) {
            switch (actionMasked) {
                case 212:
                    recyclerView = this;
                    recyclerView.mIsPenButtonPressed = false;
                    seslGoToTopController = recyclerView.mGoToTopController;
                    if (seslGoToTopController == null) {
                    }
                    if (!recyclerView.mIsPenPressed) {
                    }
                    break;
            }
        } else {
            SeslGoToTopController seslGoToTopController4 = this.mGoToTopController;
            if (seslGoToTopController4 != null) {
                seslGoToTopController4.onTouchEvent(motionEvent);
            }
            recyclerView = this;
            if (i2 >= 34) {
                if (!recyclerView.mIsCtrlMultiSelection) {
                }
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z;
        super.draw(canvas);
        int size = this.mItemDecorations.size();
        for (int i = 0; i < size; i++) {
            this.mItemDecorations.get(i).onDrawOver(canvas, this, this.mState);
        }
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z = false;
        } else {
            int iSave = canvas.save();
            int paddingBottom = this.mClipToPadding ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.mLeftGlow;
            z = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int iSave2 = canvas.save();
            if (this.mClipToPadding) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.mTopGlow;
            z |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        EdgeEffect edgeEffect5 = this.mRightGlow;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int iSave3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.mClipToPadding ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(paddingTop, -width);
            EdgeEffect edgeEffect6 = this.mRightGlow;
            z |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(iSave3);
        }
        EdgeEffect edgeEffect7 = this.mBottomGlow;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int iSave4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.mClipToPadding) {
                canvas.translate(getPaddingRight() + (-getWidth()), getPaddingBottom() + (-getHeight()));
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.mBottomGlow;
            z |= edgeEffect8 != null && edgeEffect8.draw(canvas);
            canvas.restoreToCount(iSave4);
        }
        if ((z || this.mItemAnimator == null || this.mItemDecorations.size() <= 0 || !this.mItemAnimator.isRunning()) ? z : true) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
        SeslGoToTopController seslGoToTopController = this.mGoToTopController;
        if (seslGoToTopController != null) {
            seslGoToTopController.draw();
        }
        if (!this.mIsPenDragBlockEnabled || this.mIsLongPressMultiSelection || this.mLayout == null) {
            return;
        }
        if (this.mPenDragBlockLeft == 0 && this.mPenDragBlockTop == 0) {
            return;
        }
        int iFindFirstVisibleItemPosition = findFirstVisibleItemPosition();
        int iFindLastVisibleItemPosition = findLastVisibleItemPosition();
        int i2 = this.mPenTrackedChildPosition;
        if (i2 >= iFindFirstVisibleItemPosition && i2 <= iFindLastVisibleItemPosition) {
            View viewFindViewByPosition = this.mLayout.findViewByPosition(i2);
            this.mPenTrackedChild = viewFindViewByPosition;
            this.mPenDragStartY = (viewFindViewByPosition != null ? viewFindViewByPosition.getTop() : 0) + this.mPenDistanceFromTrackedChildTop;
        }
        int i4 = this.mPenDragStartY;
        int i5 = this.mPenDragEndY;
        int i6 = i4 < i5 ? i4 : i5;
        this.mPenDragBlockTop = i6;
        if (i5 > i4) {
            i4 = i5;
        }
        this.mPenDragBlockBottom = i4;
        this.mPenDragBlockRect.set(this.mPenDragBlockLeft, i6, this.mPenDragBlockRight, i4);
        this.mPenDragBlockImage.setBounds(this.mPenDragBlockRect);
        this.mPenDragBlockImage.draw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    public void ensureBottomGlow() {
        if (this.mBottomGlow != null) {
            return;
        }
        EdgeEffect edgeEffectCreateEdgeEffect = this.mEdgeEffectFactory.createEdgeEffect(this, 3);
        this.mBottomGlow = edgeEffectCreateEdgeEffect;
        if (this.mClipToPadding) {
            edgeEffectCreateEdgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffectCreateEdgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void ensureLeftGlow() {
        if (this.mLeftGlow != null) {
            return;
        }
        EdgeEffect edgeEffectCreateEdgeEffect = this.mEdgeEffectFactory.createEdgeEffect(this, 0);
        this.mLeftGlow = edgeEffectCreateEdgeEffect;
        if (this.mClipToPadding) {
            edgeEffectCreateEdgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffectCreateEdgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public void ensureRightGlow() {
        if (this.mRightGlow != null) {
            return;
        }
        EdgeEffect edgeEffectCreateEdgeEffect = this.mEdgeEffectFactory.createEdgeEffect(this, 2);
        this.mRightGlow = edgeEffectCreateEdgeEffect;
        if (this.mClipToPadding) {
            edgeEffectCreateEdgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffectCreateEdgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public void ensureTopGlow() {
        if (this.mTopGlow != null) {
            return;
        }
        EdgeEffect edgeEffectCreateEdgeEffect = this.mEdgeEffectFactory.createEdgeEffect(this, 1);
        this.mTopGlow = edgeEffectCreateEdgeEffect;
        if (this.mClipToPadding) {
            edgeEffectCreateEdgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffectCreateEdgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public String exceptionLabel() {
        return " " + super.toString() + ", adapter:" + this.mAdapter + ", layout:" + this.mLayout + ", context:" + getContext();
    }

    public final void fillRemainingScrollValues(State state) {
        if (getScrollState() != 2) {
            state.mRemainingScrollHorizontal = 0;
            state.mRemainingScrollVertical = 0;
        } else {
            OverScroller overScroller = this.mViewFlinger.mOverScroller;
            state.mRemainingScrollHorizontal = overScroller.getFinalX() - overScroller.getCurrX();
            state.mRemainingScrollVertical = overScroller.getFinalY() - overScroller.getCurrY();
        }
    }

    @Nullable
    public View findChildViewUnder(float f, float f4) {
        for (int childCount = this.mChildHelper.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.mChildHelper.getChildAt(childCount);
            float translationX = childAt.getTranslationX();
            float translationY = childAt.getTranslationY();
            if (f >= childAt.getLeft() + translationX && f <= childAt.getRight() + translationX && f4 >= childAt.getTop() + translationY && f4 <= childAt.getBottom() + translationY) {
                return childAt;
            }
        }
        return null;
    }

    public View findClickableChildUnder(MotionEvent motionEvent) {
        View viewFindChildViewUnder = findChildViewUnder(motionEvent.getX(), motionEvent.getY());
        if (viewFindChildViewUnder == null || !viewFindChildViewUnder.isEnabled()) {
            return null;
        }
        View viewFindClickableChildUnder = findClickableChildUnder(viewFindChildViewUnder, motionEvent.getX(), motionEvent.getY());
        if (viewFindClickableChildUnder != null && viewFindClickableChildUnder != viewFindChildViewUnder) {
            if (viewFindClickableChildUnder.getHeight() * viewFindClickableChildUnder.getWidth() < ((double) (viewFindChildViewUnder.getHeight() * viewFindChildViewUnder.getWidth())) * 0.5d) {
                return null;
            }
        }
        return viewFindClickableChildUnder;
    }

    public View findClickableOfChild(View view) {
        if (view.isClickable()) {
            return view;
        }
        View viewFindClickableOfChild = null;
        if (view instanceof ViewGroup) {
            int i = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i >= viewGroup.getChildCount()) {
                    break;
                }
                viewFindClickableOfChild = findClickableOfChild(viewGroup.getChildAt(i));
                if (viewFindClickableOfChild != null) {
                    return viewFindClickableOfChild;
                }
                i++;
            }
        }
        return viewFindClickableOfChild;
    }

    @Nullable
    public View findContainingItemView(@NonNull View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    @Nullable
    public ViewHolder findContainingViewHolder(@NonNull View view) {
        View viewFindContainingItemView = findContainingItemView(view);
        if (viewFindContainingItemView == null) {
            return null;
        }
        return getChildViewHolder(viewFindContainingItemView);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int findFirstVisibleItemPosition() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            return ((StaggeredGridLayoutManager) layoutManager).findFirstVisibleItemPositions(null)[0];
        }
        return -1;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int findLastVisibleItemPosition() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            return ((StaggeredGridLayoutManager) layoutManager).findLastVisibleItemPositions(null)[0];
        }
        return -1;
    }

    @Nullable
    public ViewHolder findViewHolderForAdapterPosition(int i) {
        ViewHolder viewHolder = null;
        if (this.mDataSetHasChangedAfterLayout) {
            return null;
        }
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i2 = 0; i2 < unfilteredChildCount; i2++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i2));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && getAdapterPositionInRecyclerView(childViewHolderInt) == i) {
                if (!this.mChildHelper.isHidden(childViewHolderInt.itemView)) {
                    return childViewHolderInt;
                }
                viewHolder = childViewHolderInt;
            }
        }
        return viewHolder;
    }

    public ViewHolder findViewHolderForItemId(long j) {
        Adapter adapter = this.mAdapter;
        ViewHolder viewHolder = null;
        if (adapter != null && adapter.hasStableIds()) {
            int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
            for (int i = 0; i < unfilteredChildCount; i++) {
                ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i));
                if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && childViewHolderInt.getItemId() == j) {
                    if (!this.mChildHelper.isHidden(childViewHolderInt.itemView)) {
                        return childViewHolderInt;
                    }
                    viewHolder = childViewHolderInt;
                }
            }
        }
        return viewHolder;
    }

    @Nullable
    public ViewHolder findViewHolderForLayoutPosition(int i) {
        return findViewHolderForPosition(i, false);
    }

    @Nullable
    @Deprecated
    public ViewHolder findViewHolderForPosition(int i) {
        return findViewHolderForPosition(i, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v6 */
    public boolean fling(int i, int i2) {
        int iMax;
        int i4;
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            Log.e(TAG, "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if (this.mLayoutSuppressed) {
            return false;
        }
        int iCanScrollHorizontally = layoutManager.canScrollHorizontally();
        boolean zCanScrollVertically = this.mLayout.canScrollVertically();
        if (iCanScrollHorizontally == 0 || Math.abs(i) < this.mMinFlingVelocity) {
            i = 0;
        }
        if (!zCanScrollVertically || Math.abs(i2) < this.mMinFlingVelocity) {
            i2 = 0;
        }
        if (i == 0 && i2 == 0) {
            return false;
        }
        if (i == 0) {
            iMax = 0;
        } else {
            EdgeEffect edgeEffect = this.mLeftGlow;
            if (edgeEffect == null || EdgeEffectCompat.getDistance(edgeEffect) == 0.0f) {
                EdgeEffect edgeEffect2 = this.mRightGlow;
                if (edgeEffect2 != null && EdgeEffectCompat.getDistance(edgeEffect2) != 0.0f) {
                    if (shouldAbsorb(this.mRightGlow, i, getWidth())) {
                        this.mRightGlow.onAbsorb(i);
                        i = 0;
                    }
                    iMax = i;
                    i = 0;
                }
                iMax = 0;
            } else {
                int i5 = -i;
                if (shouldAbsorb(this.mLeftGlow, i5, getWidth())) {
                    this.mLeftGlow.onAbsorb(i5);
                    i = 0;
                }
                iMax = i;
                i = 0;
            }
        }
        if (i2 == 0) {
            i4 = i2;
            i2 = 0;
        } else {
            EdgeEffect edgeEffect3 = this.mTopGlow;
            if (edgeEffect3 == null || EdgeEffectCompat.getDistance(edgeEffect3) == 0.0f) {
                EdgeEffect edgeEffect4 = this.mBottomGlow;
                if (edgeEffect4 != null && EdgeEffectCompat.getDistance(edgeEffect4) != 0.0f) {
                    if (shouldAbsorb(this.mBottomGlow, i2, getHeight())) {
                        this.mBottomGlow.onAbsorb(i2);
                        i2 = 0;
                    }
                    i4 = 0;
                }
                i4 = i2;
                i2 = 0;
            } else {
                int i6 = -i2;
                if (shouldAbsorb(this.mTopGlow, i6, getHeight())) {
                    this.mTopGlow.onAbsorb(i6);
                    i2 = 0;
                }
                i4 = 0;
            }
        }
        if (iMax != 0 || i2 != 0) {
            int i7 = this.mMaxFlingVelocity;
            iMax = Math.max(-i7, Math.min(iMax, i7));
            int i8 = this.mMaxFlingVelocity;
            i2 = Math.max(-i8, Math.min(i2, i8));
            this.mViewFlinger.fling(iMax, i2);
        }
        if (i == 0 && i4 == 0) {
            return (iMax == 0 && i2 == 0) ? false : true;
        }
        float f = i;
        float f4 = i4;
        if (!dispatchNestedPreFling(f, f4)) {
            boolean z = iCanScrollHorizontally != 0 || zCanScrollVertically;
            dispatchNestedFling(f, f4, z);
            OnFlingListener onFlingListener = this.mOnFlingListener;
            if (onFlingListener != null && onFlingListener.onFling(i, i4)) {
                return true;
            }
            if (z) {
                if (zCanScrollVertically) {
                    iCanScrollHorizontally = (iCanScrollHorizontally == true ? 1 : 0) | 2;
                }
                startNestedScroll(iCanScrollHorizontally, 1);
                int i9 = this.mMaxFlingVelocity;
                int iMax2 = Math.max(-i9, Math.min(i, i9));
                int i10 = this.mMaxFlingVelocity;
                this.mViewFlinger.fling(iMax2, Math.max(-i10, Math.min(i4, i10)));
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i) {
        View viewOnFocusSearchFailed;
        int i2;
        int top;
        int top2;
        boolean z;
        View viewOnInterceptFocusSearch = this.mLayout.onInterceptFocusSearch(view, i);
        if (viewOnInterceptFocusSearch != null) {
            return viewOnInterceptFocusSearch;
        }
        boolean z2 = (this.mAdapter == null || this.mLayout == null || isComputingLayout() || this.mLayoutSuppressed) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z2 && (i == 2 || i == 1)) {
            if (this.mLayout.canScrollVertically()) {
                int i4 = i == 2 ? 130 : 33;
                z = focusFinder.findNextFocus(this, view, i4) == null;
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i = i4;
                }
            } else {
                z = false;
            }
            if (!z && this.mLayout.canScrollHorizontally()) {
                int i5 = (this.mLayout.getLayoutDirection() == 1) ^ (i == 2) ? 66 : 17;
                boolean z3 = focusFinder.findNextFocus(this, view, i5) == null;
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i = i5;
                }
                z = z3;
            }
            if (z) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                this.mLayout.onFocusSearchFailed(view, i, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            }
            viewOnFocusSearchFailed = focusFinder.findNextFocus(this, view, i);
        } else {
            View viewFindNextFocus = focusFinder.findNextFocus(this, view, i);
            if (viewFindNextFocus == null && z2) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                viewOnFocusSearchFailed = this.mLayout.onFocusSearchFailed(view, i, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            } else {
                viewOnFocusSearchFailed = viewFindNextFocus;
            }
        }
        if (viewOnFocusSearchFailed != null && !viewOnFocusSearchFailed.hasFocusable()) {
            if (getFocusedChild() == null || (i == 33 && view != null && view.getBottom() < viewOnFocusSearchFailed.getBottom() && !canScrollVertically(-1))) {
                return super.focusSearch(view, i);
            }
            requestChildOnScreen(viewOnFocusSearchFailed, null);
            return view;
        }
        if (!isPreferredNextFocus(view, viewOnFocusSearchFailed, i)) {
            viewOnFocusSearchFailed = super.focusSearch(view, i);
        }
        View focusedChild = getFocusedChild();
        if (focusedChild != null && this.mIsArrowKeyPressed && viewOnFocusSearchFailed == null && (this.mLayout instanceof StaggeredGridLayoutManager)) {
            if (i == 130) {
                top = focusedChild.getBottom();
                top2 = getBottom();
            } else if (i == 33) {
                top = focusedChild.getTop();
                top2 = getTop();
            } else {
                i2 = 0;
                ((StaggeredGridLayoutManager) this.mLayout).scrollBy(i2, this.mRecycler, this.mState);
                this.mIsArrowKeyPressed = false;
            }
            i2 = top - top2;
            ((StaggeredGridLayoutManager) this.mLayout).scrollBy(i2, this.mRecycler, this.mState);
            this.mIsArrowKeyPressed = false;
        }
        return viewOnFocusSearchFailed;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            return layoutManager.generateDefaultLayoutParams();
        }
        throw new IllegalStateException(AbstractC2821a.m2219j(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            return layoutManager.generateLayoutParams(getContext(), attributeSet);
        }
        throw new IllegalStateException(AbstractC2821a.m2219j(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    @Nullable
    public Adapter getAdapter() {
        return this.mAdapter;
    }

    public int getAdapterPositionInRecyclerView(ViewHolder viewHolder) {
        if (viewHolder.hasAnyOfTheFlags(524) || !viewHolder.isBound()) {
            return -1;
        }
        return this.mAdapterHelper.applyPendingUpdatesToPosition(viewHolder.mPosition);
    }

    @Override // android.view.View
    public int getBaseline() {
        LayoutManager layoutManager = this.mLayout;
        return layoutManager != null ? layoutManager.getBaseline() : super.getBaseline();
    }

    public long getChangedHolderKey(ViewHolder viewHolder) {
        return this.mAdapter.hasStableIds() ? viewHolder.getItemId() : viewHolder.mPosition;
    }

    public int getChildAdapterPosition(@NonNull View view) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getAbsoluteAdapterPosition();
        }
        return -1;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i, int i2) {
        ChildDrawingOrderCallback childDrawingOrderCallback = this.mChildDrawingOrderCallback;
        return childDrawingOrderCallback == null ? super.getChildDrawingOrder(i, i2) : childDrawingOrderCallback.onGetChildDrawingOrder(i, i2);
    }

    public long getChildItemId(@NonNull View view) {
        ViewHolder childViewHolderInt;
        Adapter adapter = this.mAdapter;
        if (adapter == null || !adapter.hasStableIds() || (childViewHolderInt = getChildViewHolderInt(view)) == null) {
            return -1L;
        }
        return childViewHolderInt.getItemId();
    }

    public int getChildLayoutPosition(@NonNull View view) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getLayoutPosition();
        }
        return -1;
    }

    @Deprecated
    public int getChildPosition(@NonNull View view) {
        return getChildAdapterPosition(view);
    }

    public ViewHolder getChildViewHolder(@NonNull View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return getChildViewHolderInt(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.mClipToPadding;
    }

    @Nullable
    public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public void getDecoratedBoundsWithMargins(@NonNull View view, @NonNull Rect rect) {
        getDecoratedBoundsWithMarginsInt(view, rect);
    }

    @NonNull
    public EdgeEffectFactory getEdgeEffectFactory() {
        return this.mEdgeEffectFactory;
    }

    @Nullable
    public ItemAnimator getItemAnimator() {
        return this.mItemAnimator;
    }

    public Rect getItemDecorInsetsForChild(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.mInsetsDirty) {
            return layoutParams.mDecorInsets;
        }
        if (this.mState.isPreLayout() && (layoutParams.isItemChanged() || layoutParams.isViewInvalid())) {
            return layoutParams.mDecorInsets;
        }
        Rect rect = layoutParams.mDecorInsets;
        rect.set(0, 0, 0, 0);
        int size = this.mItemDecorations.size();
        for (int i = 0; i < size; i++) {
            this.mTempRect.set(0, 0, 0, 0);
            this.mItemDecorations.get(i).getItemOffsets(this.mTempRect, view, this, this.mState);
            int i2 = rect.left;
            Rect rect2 = this.mTempRect;
            rect.left = i2 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        layoutParams.mInsetsDirty = false;
        return rect;
    }

    @NonNull
    public ItemDecoration getItemDecorationAt(int i) {
        int itemDecorationCount = getItemDecorationCount();
        if (i >= 0 && i < itemDecorationCount) {
            return this.mItemDecorations.get(i);
        }
        throw new IndexOutOfBoundsException(i + " is an invalid index for size " + itemDecorationCount);
    }

    public int getItemDecorationCount() {
        return this.mItemDecorations.size();
    }

    @Nullable
    public LayoutManager getLayoutManager() {
        return this.mLayout;
    }

    public final SeslLongPressMultiSelectionListener getLongPressMultiSelectionListener() {
        return this.mLongPressMultiSelectionListener;
    }

    public int getMaxFlingVelocity() {
        return this.mMaxFlingVelocity;
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    public long getNanoTime() {
        if (ALLOW_THREAD_GAP_WORK) {
            return System.nanoTime();
        }
        return 0L;
    }

    @Nullable
    public OnFlingListener getOnFlingListener() {
        return this.mOnFlingListener;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.mPreserveFocusAfterLayout;
    }

    @NonNull
    public RecycledViewPool getRecycledViewPool() {
        return this.mRecycler.getRecycledViewPool();
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    public boolean hasFixedSize() {
        return this.mHasFixedSize;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().hasNestedScrollingParent();
    }

    public boolean hasPendingAdapterUpdates() {
        return !this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout || this.mAdapterHelper.hasPendingUpdates();
    }

    public void initAdapterManager() {
        this.mAdapterHelper = new AdapterHelper(new AdapterHelper.Callback() { // from class: androidx.recyclerview.widget.RecyclerView.10
            public void dispatchUpdate(AdapterHelper.UpdateOp updateOp) {
                int i = updateOp.cmd;
                if (i == 1) {
                    RecyclerView recyclerView = RecyclerView.this;
                    recyclerView.mLayout.onItemsAdded(recyclerView, updateOp.positionStart, updateOp.itemCount);
                    return;
                }
                if (i == 2) {
                    RecyclerView recyclerView2 = RecyclerView.this;
                    recyclerView2.mLayout.onItemsRemoved(recyclerView2, updateOp.positionStart, updateOp.itemCount);
                } else if (i == 4) {
                    RecyclerView recyclerView3 = RecyclerView.this;
                    recyclerView3.mLayout.onItemsUpdated(recyclerView3, updateOp.positionStart, updateOp.itemCount, updateOp.payload);
                } else {
                    if (i != 8) {
                        return;
                    }
                    RecyclerView recyclerView4 = RecyclerView.this;
                    recyclerView4.mLayout.onItemsMoved(recyclerView4, updateOp.positionStart, updateOp.itemCount, 1);
                }
            }

            @Override // androidx.recyclerview.widget.AdapterHelper.Callback
            public ViewHolder findViewHolder(int i) {
                ViewHolder viewHolderFindViewHolderForPosition = RecyclerView.this.findViewHolderForPosition(i, true);
                if (viewHolderFindViewHolderForPosition == null) {
                    return null;
                }
                if (!RecyclerView.this.mChildHelper.isHidden(viewHolderFindViewHolderForPosition.itemView)) {
                    return viewHolderFindViewHolderForPosition;
                }
                if (RecyclerView.sVerboseLoggingEnabled) {
                    Log.d(RecyclerView.TAG, "assuming view holder cannot be find because it is hidden");
                }
                return null;
            }

            @Override // androidx.recyclerview.widget.AdapterHelper.Callback
            public void markViewHoldersUpdated(int i, int i2, Object obj) {
                RecyclerView.this.viewRangeUpdate(i, i2, obj);
                RecyclerView.this.mItemsChanged = true;
            }

            @Override // androidx.recyclerview.widget.AdapterHelper.Callback
            public void offsetPositionsForAdd(int i, int i2) {
                RecyclerView.this.offsetPositionRecordsForInsert(i, i2);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            }

            @Override // androidx.recyclerview.widget.AdapterHelper.Callback
            public void offsetPositionsForMove(int i, int i2) {
                RecyclerView.this.offsetPositionRecordsForMove(i, i2);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            }

            @Override // androidx.recyclerview.widget.AdapterHelper.Callback
            public void offsetPositionsForRemovingInvisible(int i, int i2) {
                RecyclerView.this.offsetPositionRecordsForRemove(i, i2, true);
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.mItemsAddedOrRemoved = true;
                recyclerView.mState.mDeletedInvisibleItemCountSincePreviousLayout += i2;
            }

            @Override // androidx.recyclerview.widget.AdapterHelper.Callback
            public void offsetPositionsForRemovingLaidOutOrNewView(int i, int i2) {
                RecyclerView.this.offsetPositionRecordsForRemove(i, i2, false);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            }

            @Override // androidx.recyclerview.widget.AdapterHelper.Callback
            public void onDispatchFirstPass(AdapterHelper.UpdateOp updateOp) {
                dispatchUpdate(updateOp);
            }

            @Override // androidx.recyclerview.widget.AdapterHelper.Callback
            public void onDispatchSecondPass(AdapterHelper.UpdateOp updateOp) {
                dispatchUpdate(updateOp);
            }
        });
    }

    @VisibleForTesting
    public void initFastScroller(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
            throw new IllegalArgumentException(AbstractC2821a.m2219j(this, new StringBuilder("Trying to set fast scroller without both required drawables.")));
        }
        Resources resources = getContext().getResources();
        new FastScroller(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(C3728R.dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(C3728R.dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(C3728R.dimen.fastscroll_margin));
    }

    public void invalidateGlows() {
        this.mBottomGlow = null;
        this.mTopGlow = null;
        this.mRightGlow = null;
        this.mLeftGlow = null;
    }

    public void invalidateItemDecorations() {
        if (this.mItemDecorations.size() == 0) {
            return;
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public boolean isAccessibilityEnabled() {
        AccessibilityManager accessibilityManager = this.mAccessibilityManager;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    public boolean isAnimating() {
        ItemAnimator itemAnimator = this.mItemAnimator;
        return itemAnimator != null && itemAnimator.isRunning();
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.mIsAttached;
    }

    public boolean isComputingLayout() {
        return this.mLayoutOrScrollCounter > 0;
    }

    @Deprecated
    public boolean isLayoutFrozen() {
        return isLayoutSuppressed();
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.mLayoutSuppressed;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().isNestedScrollingEnabled();
    }

    @Override // android.view.View
    public boolean isVerticalScrollBarEnabled() {
        SeslRecyclerViewFastScroller seslRecyclerViewFastScroller = this.mFastScroller;
        return seslRecyclerViewFastScroller != null ? !seslRecyclerViewFastScroller.isEnabled() && super.isVerticalScrollBarEnabled() : super.isVerticalScrollBarEnabled();
    }

    public void jumpToPositionForSmoothScroller(int i) {
        if (this.mLayout == null) {
            return;
        }
        setScrollState(2);
        this.mLayout.scrollToPosition(i);
        awakenScrollBars();
    }

    public void markItemDecorInsetsDirty() {
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i = 0; i < unfilteredChildCount; i++) {
            ((LayoutParams) this.mChildHelper.getUnfilteredChildAt(i).getLayoutParams()).mInsetsDirty = true;
        }
        this.mRecycler.markItemDecorInsetsDirty();
    }

    public void markKnownViewsInvalid() {
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i = 0; i < unfilteredChildCount; i++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.addFlags(6);
            }
        }
        markItemDecorInsetsDirty();
        this.mRecycler.markKnownViewsInvalid();
    }

    public void nestedScrollBy(int i, int i2) {
        nestedScrollByInternal(i, i2, null, 1);
    }

    public void offsetChildrenHorizontal(@Px int i) {
        int childCount = this.mChildHelper.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            this.mChildHelper.getChildAt(i2).offsetLeftAndRight(i);
        }
    }

    public void offsetChildrenVertical(@Px int i) {
        int childCount = this.mChildHelper.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            this.mChildHelper.getChildAt(i2).offsetTopAndBottom(i);
        }
    }

    public void offsetPositionRecordsForInsert(int i, int i2) {
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i4 = 0; i4 < unfilteredChildCount; i4++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i4));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.mPosition >= i) {
                if (sVerboseLoggingEnabled) {
                    Log.d(TAG, "offsetPositionRecordsForInsert attached child " + i4 + " holder " + childViewHolderInt + " now at position " + (childViewHolderInt.mPosition + i2));
                }
                childViewHolderInt.offsetPosition(i2, false);
                this.mState.mStructureChanged = true;
            }
        }
        this.mRecycler.offsetPositionRecordsForInsert(i, i2);
        requestLayout();
    }

    public void offsetPositionRecordsForMove(int i, int i2) {
        int i4;
        int i5;
        int i6;
        int i7;
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        if (i < i2) {
            i6 = -1;
            i5 = i;
            i4 = i2;
        } else {
            i4 = i;
            i5 = i2;
            i6 = 1;
        }
        for (int i8 = 0; i8 < unfilteredChildCount; i8++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i8));
            if (childViewHolderInt != null && (i7 = childViewHolderInt.mPosition) >= i5 && i7 <= i4) {
                if (sVerboseLoggingEnabled) {
                    Log.d(TAG, "offsetPositionRecordsForMove attached child " + i8 + " holder " + childViewHolderInt);
                }
                if (childViewHolderInt.mPosition == i) {
                    childViewHolderInt.offsetPosition(i2 - i, false);
                } else {
                    childViewHolderInt.offsetPosition(i6, false);
                }
                this.mState.mStructureChanged = true;
            }
        }
        this.mRecycler.offsetPositionRecordsForMove(i, i2);
        requestLayout();
    }

    public void offsetPositionRecordsForRemove(int i, int i2, boolean z) {
        int i4 = i + i2;
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i5 = 0; i5 < unfilteredChildCount; i5++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i5));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                int i6 = childViewHolderInt.mPosition;
                if (i6 >= i4) {
                    if (sVerboseLoggingEnabled) {
                        Log.d(TAG, "offsetPositionRecordsForRemove attached child " + i5 + " holder " + childViewHolderInt + " now at position " + (childViewHolderInt.mPosition - i2));
                    }
                    childViewHolderInt.offsetPosition(-i2, z);
                    this.mState.mStructureChanged = true;
                } else if (i6 >= i) {
                    if (sVerboseLoggingEnabled) {
                        Log.d(TAG, "offsetPositionRecordsForRemove attached child " + i5 + " holder " + childViewHolderInt + " now REMOVED");
                    }
                    childViewHolderInt.flagRemovedAndOffsetPosition(i - 1, -i2, z);
                    this.mState.mStructureChanged = true;
                }
            }
        }
        this.mRecycler.offsetPositionRecordsForRemove(i, i2, z);
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        SeslRecyclerViewFastScroller seslRecyclerViewFastScroller;
        super.onAttachedToWindow();
        this.mLayoutOrScrollCounter = 0;
        this.mIsAttached = true;
        this.mFirstLayoutComplete = this.mFirstLayoutComplete && !isLayoutRequested();
        this.mRecycler.onAttachedToWindow();
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.dispatchAttachedToWindow(this);
        }
        this.mPostedAnimatorRunner = false;
        if (ALLOW_THREAD_GAP_WORK) {
            ThreadLocal<GapWorker> threadLocal = GapWorker.sGapWorker;
            GapWorker gapWorker = threadLocal.get();
            this.mGapWorker = gapWorker;
            if (gapWorker == null) {
                this.mGapWorker = new GapWorker();
                Display display = ViewCompat.getDisplay(this);
                if (!isInEditMode() && display != null) {
                    float refreshRate = display.getRefreshRate();
                    f = refreshRate >= 30.0f ? refreshRate : 60.0f;
                    if (this.mIsNeedCheckLatency) {
                        this.mFrameLatency = 1000.0f / f;
                        this.mIsNeedCheckLatency = false;
                    }
                }
                GapWorker gapWorker2 = this.mGapWorker;
                gapWorker2.mFrameIntervalNs = (long) (1.0E9f / f);
                threadLocal.set(gapWorker2);
            }
            this.mGapWorker.add(this);
            LayoutManager layoutManager2 = this.mLayout;
            if (layoutManager2 == null || layoutManager2.getLayoutDirection() != 1 || (seslRecyclerViewFastScroller = this.mFastScroller) == null) {
                return;
            }
            seslRecyclerViewFastScroller.setScrollbarPosition(getVerticalScrollbarPosition());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        IndexTip indexTip;
        GapWorker gapWorker;
        super.onDetachedFromWindow();
        ItemAnimator itemAnimator = this.mItemAnimator;
        if (itemAnimator != null) {
            itemAnimator.endAnimations();
        }
        stopScroll();
        this.mIsAttached = false;
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.dispatchDetachedFromWindow(this, this.mRecycler);
        }
        this.mPendingAccessibilityImportanceChange.clear();
        removeCallbacks(this.mItemAnimatorRunner);
        this.mViewInfoStore.onDetach();
        this.mRecycler.onDetachedFromWindow();
        PoolingContainer.callPoolingContainerOnReleaseForChildren(this);
        if (ALLOW_THREAD_GAP_WORK && (gapWorker = this.mGapWorker) != null) {
            gapWorker.remove(this);
            this.mGapWorker = null;
        }
        if (this.mIndexTipEnabled && (indexTip = this.mIndexTip) != null) {
            indexTip.forcedHide();
        }
        this.mIsNeedCheckLatency = true;
        if (this.mIsRecoilSupported) {
            this.mItemAnimatorHolder.removeAllUpdateListeners();
        }
        SeslGoToTopController seslGoToTopController = this.mGoToTopController;
        if (seslGoToTopController != null) {
            seslGoToTopController.release();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Canvas canvas2;
        super.onDraw(canvas);
        if (this.mFadingEdgeHelper.isFadingEdgeEnabled()) {
            Rect rectCalculateFadingEdgeBounds = calculateFadingEdgeBounds();
            canvas2 = canvas;
            this.mFadingEdgeHelper.prepareFadingEffect(canvas2, rectCalculateFadingEdgeBounds.left, rectCalculateFadingEdgeBounds.top, rectCalculateFadingEdgeBounds.right, rectCalculateFadingEdgeBounds.bottom);
        } else {
            canvas2 = canvas;
        }
        int size = this.mItemDecorations.size();
        for (int i = 0; i < size; i++) {
            this.mItemDecorations.get(i).onDraw(canvas2, this, this.mState);
        }
        if (this.mIsNeedCheckLatency) {
            Display display = ViewCompat.getDisplay(this);
            if (display != null) {
                this.mFrameLatency = 1000.0f / display.getRefreshRate();
            } else {
                this.mFrameLatency = FRAME_LATENCY_LIMIT;
            }
            this.mIsNeedCheckLatency = false;
        }
        SeslRecyclerViewFastScroller seslRecyclerViewFastScroller = this.mFastScroller;
        if (seslRecyclerViewFastScroller != null) {
            seslRecyclerViewFastScroller.updateLayout();
        }
    }

    public void onEnterLayoutOrScroll() {
        this.mLayoutOrScrollCounter++;
    }

    public void onExitLayoutOrScroll() {
        onExitLayoutOrScroll(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0076  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f;
        float axisValue;
        if (this.mLayout == null || this.mLayoutSuppressed) {
            return false;
        }
        if (motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                f = this.mLayout.canScrollVertically() ? -motionEvent.getAxisValue(9) : 0.0f;
                axisValue = this.mLayout.canScrollHorizontally() ? motionEvent.getAxisValue(10) : 0.0f;
                this.mIsActionScrollFromMouse = MotionEventCompat.isFromSource(motionEvent, 8194);
            } else if ((motionEvent.getSource() & 4194304) != 0) {
                float axisValue2 = motionEvent.getAxisValue(26);
                if (this.mLayout.canScrollVertically()) {
                    f = -axisValue2;
                    axisValue = 0.0f;
                } else if (this.mLayout.canScrollHorizontally()) {
                    axisValue = axisValue2;
                    f = 0.0f;
                } else {
                    f = 0.0f;
                    axisValue = 0.0f;
                }
            }
            if (f != 0.0f || axisValue != 0.0f) {
                startNestedScroll(f == 0.0f ? 1 : 2, 1);
                if (!dispatchNestedPreScroll((int) (this.mScaledHorizontalScrollFactor * axisValue), (int) (this.mScaledVerticalScrollFactor * f), null, null, 1)) {
                    nestedScrollByInternal((int) (axisValue * this.mScaledHorizontalScrollFactor), (int) (f * this.mScaledVerticalScrollFactor), motionEvent, 1);
                }
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x015e  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        View viewFindClickableChildUnder;
        ViewHolder viewHolderFindContainingViewHolder;
        boolean z;
        if (this.mLayoutSuppressed) {
            this.mLastTouchX = -1;
            this.mLastTouchY = -1;
            return false;
        }
        this.mInterceptingOnItemTouchListener = null;
        if (findInterceptingOnItemTouchListener(motionEvent)) {
            cancelScroll();
            return true;
        }
        if (this.mLayout == null) {
            return false;
        }
        SeslRecyclerViewFastScroller seslRecyclerViewFastScroller = this.mFastScroller;
        if (seslRecyclerViewFastScroller != null && seslRecyclerViewFastScroller.onInterceptTouchEvent(motionEvent)) {
            return true;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        boolean zCanScrollHorizontally = this.mLayout.canScrollHorizontally();
        boolean zCanScrollVertically = this.mLayout.canScrollVertically();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        boolean z2 = motionEvent.getToolType(0) == 2;
        boolean z3 = (motionEvent.getButtonState() & 32) != 0;
        if (actionMasked == 0) {
            if ((!z2 || !z3) && actionMasked != 211) {
                if (this.mIgnoreMotionEventTillDown) {
                    this.mIgnoreMotionEventTillDown = false;
                }
                this.mScrollPointerId = motionEvent.getPointerId(0);
                int x = (int) (motionEvent.getX() + 0.5f);
                this.mLastTouchX = x;
                this.mInitialTouchX = x;
                int y2 = (int) (motionEvent.getY() + 0.5f);
                this.mLastTouchY = y2;
                this.mInitialTouchY = y2;
                if (this.mUsePagingTouchSlopForStylus) {
                    if (motionEvent.isFromSource(InputDeviceCompat.SOURCE_STYLUS)) {
                        this.mTouchSlop = this.mPagingTouchSlop;
                    } else {
                        this.mTouchSlop = this.mTouchSlop2;
                    }
                }
                if (sVerboseLoggingEnabled) {
                    Log.d(TAG, "onIntercept DOWN mTouchSlop[" + this.mTouchSlop + "] mTouchSlop[" + this.mTouchSlop2 + "] mPagingTouchSlop[" + this.mPagingTouchSlop + "] mLastTouchX[" + this.mLastTouchX + "] mLastTouchY[" + this.mLastTouchY + "] ");
                }
                if (stopGlowAnimations(motionEvent) || this.mScrollState == 2) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    setScrollState(1);
                    stopNestedScroll(1);
                }
                int[] iArr = this.mNestedOffsets;
                iArr[1] = 0;
                iArr[0] = 0;
                if (this.mHasNestedScrollRange) {
                    adjustNestedScrollRange();
                }
                this.mPreventFirstGlow = false;
                int i = zCanScrollHorizontally;
                if (zCanScrollVertically) {
                    i = (zCanScrollHorizontally ? 1 : 0) | 2;
                }
                startNestedScroll(i, 0);
                this.mIsSkipMoveEvent = false;
            } else if (this.mIgnoreMotionEventTillDown) {
                this.mIgnoreMotionEventTillDown = false;
            }
            if (this.mIsRecoilSupported && this.mIsRecoilEnabled && this.mScrollState == 0 && (viewFindClickableChildUnder = findClickableChildUnder(motionEvent)) != null && (viewHolderFindContainingViewHolder = findContainingViewHolder(viewFindClickableChildUnder)) != null && viewHolderFindContainingViewHolder.seslIsViewHolderRecoilEffectEnabled()) {
                this.mItemBackgroundHolder.setPress(viewFindClickableChildUnder);
                this.mItemAnimatorHolder.setPress(viewFindClickableChildUnder);
            }
        } else if (actionMasked == 1) {
            this.mVelocityTracker.clear();
            stopNestedScroll(0);
        } else if (actionMasked != 2) {
            if (actionMasked == 3) {
                if (!this.mSeslIsNested || this.mScrollState == 1) {
                    cancelScroll();
                }
                if (this.mIsRecoilSupported && this.mIsRecoilEnabled) {
                    this.mItemBackgroundHolder.setCancel();
                    this.mItemAnimatorHolder.setRelease();
                }
            } else if (actionMasked == 5) {
                this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
                int x2 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                this.mLastTouchX = x2;
                this.mInitialTouchX = x2;
                int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                this.mLastTouchY = y3;
                this.mInitialTouchY = y3;
                if (sVerboseLoggingEnabled) {
                    Log.d(TAG, "onIntercept POINTER_DOWN mLastTouchX[" + this.mLastTouchX + "] mLastTouchY[" + this.mLastTouchY + "] ");
                }
            } else if (actionMasked == 6) {
                onPointerUp(motionEvent);
            } else if (actionMasked == 211) {
            }
        } else if (this.mLastTouchX >= 0 && this.mLastTouchY >= 0 && ((!z2 || !z3) && !this.mIsPenButtonPressed)) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
            if (iFindPointerIndex < 0) {
                Log.e(TAG, "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                motionEventObtain.recycle();
                return false;
            }
            int x5 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
            int y4 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
            int i2 = this.mLastTouchX - x5;
            int i4 = this.mLastTouchY - y4;
            if (sVerboseLoggingEnabled) {
                Log.d(TAG, AbstractC0622a.m1164j(i2, i4, "onIntercept MOVE dx[", "] dy[", "]"));
            }
            if (this.mScrollState != 1) {
                if (zCanScrollHorizontally) {
                    int iAbs = Math.abs(i2);
                    int i5 = this.mTouchSlop;
                    if (iAbs > i5) {
                        i2 = i2 > 0 ? i2 - i5 : i2 + i5;
                        this.mLastTouchX = x5;
                        z = true;
                    } else {
                        z = false;
                    }
                    if (zCanScrollVertically) {
                        int iAbs2 = Math.abs(i4);
                        int i6 = this.mTouchSlop;
                        if (iAbs2 > i6) {
                            i4 = i4 > 0 ? i4 - i6 : i4 + i6;
                            this.mPreventFirstGlow = true;
                            this.mLastTouchY = y4;
                            z = true;
                        }
                    }
                    if (z) {
                        setScrollState(1);
                        if (this.mIsRecoilSupported && this.mIsRecoilEnabled) {
                            this.mItemBackgroundHolder.setCancel();
                            this.mItemAnimatorHolder.setRelease();
                        }
                    }
                }
            }
            int i7 = i2;
            int i8 = i4;
            if (this.mScrollState == 1) {
                if (dispatchNestedPreScroll(zCanScrollHorizontally ? i7 : 0, zCanScrollVertically ? i8 : 0, this.mReusableIntPair, this.mScrollOffset, 0)) {
                    int[] iArr2 = this.mReusableIntPair;
                    i7 -= iArr2[0];
                    i8 -= iArr2[1];
                    int[] iArr3 = this.mNestedOffsets;
                    int i9 = iArr3[0];
                    int[] iArr4 = this.mScrollOffset;
                    iArr3[0] = i9 + iArr4[0];
                    iArr3[1] = iArr3[1] + iArr4[1];
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                int[] iArr5 = this.mScrollOffset;
                this.mLastTouchX = x5 - iArr5[0];
                this.mLastTouchY = y4 - iArr5[1];
                if ((motionEvent.getFlags() & 33554432) != 0) {
                    this.mVelocityTracker.addMovement(motionEventObtain);
                    this.mIsSkipMoveEvent = true;
                    motionEventObtain.recycle();
                    return false;
                }
                if (scrollByInternal(zCanScrollHorizontally ? i7 : 0, zCanScrollVertically ? i8 : 0, motionEventObtain, 0)) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                GapWorker gapWorker = this.mGapWorker;
                if (gapWorker != null && (i7 != 0 || i8 != 0)) {
                    gapWorker.postFromTraversal(this, i7, i8);
                }
            }
            adjustNestedScrollRangeBy(i8);
        }
        motionEventObtain.recycle();
        return this.mScrollState == 1;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 92) {
            if (i != 93) {
                if (i == 113 || i == 114) {
                    this.mIsCtrlKeyPressed = true;
                } else if (i != 122) {
                    if (i == 123 && keyEvent.hasNoModifiers()) {
                        pageScroll(3);
                    }
                } else if (keyEvent.hasNoModifiers()) {
                    pageScroll(2);
                }
            } else if (keyEvent.hasNoModifiers()) {
                pageScroll(1);
            }
        } else if (keyEvent.hasNoModifiers()) {
            pageScroll(0);
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 113 || i == 114) {
            this.mIsCtrlKeyPressed = false;
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i4, int i5) {
        IndexTip indexTip;
        TraceCompat.beginSection(TRACE_ON_LAYOUT_TAG);
        dispatchLayout();
        TraceCompat.endSection();
        this.mFirstLayoutComplete = true;
        SeslRecyclerViewFastScroller seslRecyclerViewFastScroller = this.mFastScroller;
        if (seslRecyclerViewFastScroller != null && this.mAdapter != null) {
            seslRecyclerViewFastScroller.onItemCountChanged(getChildCount(), this.mAdapter.getItemCount());
        }
        if (z) {
            this.mSeslOverlayFeatureHeight = getResources().getDimensionPixelSize(C3728R.dimen.sesl_recyclerview_overlay_feature_hidden_height);
            SeslGoToTopController seslGoToTopController = this.mGoToTopController;
            if (seslGoToTopController != null) {
                seslGoToTopController.setSizeChanged(true);
                this.mGoToTopController.setOverlayFeatureHiddenHeightPx(this.mSeslOverlayFeatureHeight);
            }
            seslSetImmersiveScrollBottomPadding(0);
            SeslGoToTopController seslGoToTopController2 = this.mGoToTopController;
            if (seslGoToTopController2 != null) {
                seslGoToTopController2.onSizeChanged();
            }
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager == null || layoutManager.canScrollHorizontally()) {
                LayoutManager layoutManager2 = this.mLayout;
                if (layoutManager2 != null && layoutManager2.canScrollHorizontally()) {
                    getLocationInWindow(this.mWindowOffsets);
                    this.mRemainNestedScrollRange = 0;
                    this.mNestedScrollRange = 0;
                    this.mInitialTopOffsetOfScreen = this.mWindowOffsets[0];
                }
            } else {
                this.mHasNestedScrollRange = false;
                ViewParent parent = getParent();
                while (true) {
                    if (parent == null || !(parent instanceof ViewGroup)) {
                        break;
                    }
                    if ((parent instanceof NestedScrollingParent2) && findSuperClass(parent, "CoordinatorLayout")) {
                        ViewGroup viewGroup = (ViewGroup) parent;
                        viewGroup.getLocationInWindow(this.mWindowOffsets);
                        int height = viewGroup.getHeight() + this.mWindowOffsets[1];
                        getLocationInWindow(this.mWindowOffsets);
                        this.mInitialTopOffsetOfScreen = this.mWindowOffsets[1];
                        int height2 = getHeight() - (height - this.mInitialTopOffsetOfScreen);
                        this.mRemainNestedScrollRange = height2;
                        if (height2 < 0) {
                            this.mRemainNestedScrollRange = 0;
                        }
                        this.mNestedScrollRange = this.mRemainNestedScrollRange;
                        this.mHasNestedScrollRange = true;
                    } else {
                        parent = parent.getParent();
                    }
                }
                if (!this.mHasNestedScrollRange) {
                    this.mInitialTopOffsetOfScreen = 0;
                    this.mRemainNestedScrollRange = 0;
                    this.mNestedScrollRange = 0;
                }
            }
            if (!this.mIndexTipEnabled || (indexTip = this.mIndexTip) == null) {
                return;
            }
            indexTip.setLayout(0, this.mScrollBarTopOffset, i4 - i, i5 - i2, getPaddingLeft() + indexTip.getPaddingLeft(), getPaddingRight() + this.mIndexTip.getPaddingRight());
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        if (this.mLayout == null) {
            defaultOnMeasure(i, i2);
            return;
        }
        this.mListPadding.set(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        boolean z = false;
        if (this.mLayout.isAutoMeasureEnabled()) {
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            this.mLayout.onMeasure(this.mRecycler, this.mState, i, i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            this.mLastAutoMeasureSkippedDueToExact = z;
            if (z || this.mAdapter == null) {
                return;
            }
            if (this.mState.mLayoutStep == 1) {
                dispatchLayoutStep1();
            }
            this.mLayout.setMeasureSpecs(i, i2);
            this.mState.mIsMeasuring = true;
            dispatchLayoutStep2();
            this.mLayout.setMeasuredDimensionFromChildren(i, i2);
            if (this.mLayout.shouldMeasureTwice()) {
                this.mLayout.setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                this.mState.mIsMeasuring = true;
                dispatchLayoutStep2();
                this.mLayout.setMeasuredDimensionFromChildren(i, i2);
            }
            this.mLastAutoMeasureNonExactMeasuredWidth = getMeasuredWidth();
            this.mLastAutoMeasureNonExactMeasuredHeight = getMeasuredHeight();
            return;
        }
        if (this.mHasFixedSize) {
            this.mLayout.onMeasure(this.mRecycler, this.mState, i, i2);
            return;
        }
        if (this.mAdapterUpdateDuringMeasure) {
            startInterceptRequestLayout();
            onEnterLayoutOrScroll();
            processAdapterUpdatesAndSetAnimationFlags();
            onExitLayoutOrScroll();
            State state = this.mState;
            if (state.mRunPredictiveAnimations) {
                state.mInPreLayout = true;
            } else {
                this.mAdapterHelper.consumeUpdatesInOnePass();
                this.mState.mInPreLayout = false;
            }
            this.mAdapterUpdateDuringMeasure = false;
            stopInterceptRequestLayout(false);
        } else if (this.mState.mRunPredictiveAnimations) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        Adapter adapter = this.mAdapter;
        if (adapter != null) {
            this.mState.mItemCount = adapter.getItemCount();
        } else {
            this.mState.mItemCount = 0;
        }
        startInterceptRequestLayout();
        this.mLayout.onMeasure(this.mRecycler, this.mState, i, i2);
        stopInterceptRequestLayout(false);
        this.mState.mInPreLayout = false;
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (isComputingLayout()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i, rect);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.mPendingSavedState = savedState;
        super.onRestoreInstanceState(savedState.getSuperState());
        requestLayout();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        SeslRecyclerViewFastScroller seslRecyclerViewFastScroller = this.mFastScroller;
        if (seslRecyclerViewFastScroller != null) {
            seslRecyclerViewFastScroller.setScrollbarPosition(getVerticalScrollbarPosition());
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        this.mIsNeedCheckLatency = true;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SavedState savedState2 = this.mPendingSavedState;
        if (savedState2 != null) {
            savedState.copyFrom(savedState2);
            return savedState;
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            savedState.mLayoutState = layoutManager.onSaveInstanceState();
            return savedState;
        }
        savedState.mLayoutState = null;
        return savedState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i4, int i5) {
        super.onSizeChanged(i, i2, i4, i5);
        if (i == i4 && i2 == i5) {
            return;
        }
        SeslRecyclerViewFastScroller seslRecyclerViewFastScroller = this.mFastScroller;
        if (seslRecyclerViewFastScroller != null) {
            seslRecyclerViewFastScroller.onSizeChanged(i, i2, i4, i5);
        }
        invalidateGlows();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0150 A[PHI: r1
      0x0150: PHI (r1v56 int) = (r1v33 int), (r1v60 int) binds: [B:77:0x0139, B:81:0x014c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0169  */
    /* JADX WARN: Type inference failed for: r9v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v2 */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Object[] objArr;
        if (this.mLayoutSuppressed || this.mIgnoreMotionEventTillDown) {
            return false;
        }
        if (dispatchToOnItemTouchListeners(motionEvent)) {
            cancelScroll();
            return true;
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            return false;
        }
        int iCanScrollHorizontally = layoutManager.canScrollHorizontally();
        boolean zCanScrollVertically = this.mLayout.canScrollVertically();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            int[] iArr = this.mNestedOffsets;
            iArr[1] = 0;
            iArr[0] = 0;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        int[] iArr2 = this.mNestedOffsets;
        motionEventObtain.offsetLocation(iArr2[0], iArr2[1]);
        Object[] objArr2 = motionEvent.getToolType(0) == 2;
        Object[] objArr3 = (motionEvent.getButtonState() & 32) != 0;
        SeslRecyclerViewFastScroller seslRecyclerViewFastScroller = this.mFastScroller;
        if (seslRecyclerViewFastScroller != null && seslRecyclerViewFastScroller.onTouchEvent(motionEvent)) {
            if (this.mFastScrollerEventListener != null) {
                if (motionEvent.getActionMasked() == 0 || motionEvent.getActionMasked() == 2) {
                    int effectState = this.mFastScroller.getEffectState();
                    SeslRecyclerViewFastScroller seslRecyclerViewFastScroller2 = this.mFastScroller;
                    if (effectState == 1) {
                        this.mFastScrollerEventListener.onPressed(seslRecyclerViewFastScroller2.getScrollY());
                    } else if (motionEvent.getActionMasked() == 1) {
                        int effectState2 = this.mFastScroller.getEffectState();
                        SeslRecyclerViewFastScroller seslRecyclerViewFastScroller3 = this.mFastScroller;
                        if (effectState2 == 0) {
                            this.mFastScrollerEventListener.onReleased(seslRecyclerViewFastScroller3.getScrollY());
                        }
                    }
                }
            }
            motionEventObtain.recycle();
            return true;
        }
        if (actionMasked == 0) {
            this.mScrollPointerId = motionEvent.getPointerId(0);
            int x = (int) (motionEvent.getX() + 0.5f);
            this.mLastTouchX = x;
            this.mInitialTouchX = x;
            int y2 = (int) (motionEvent.getY() + 0.5f);
            this.mLastTouchY = y2;
            this.mInitialTouchY = y2;
            if (sVerboseLoggingEnabled) {
                Log.d(TAG, "onTouch DOWN mInitialTouchX[" + this.mInitialTouchX + "] mInitialTouchY[" + this.mInitialTouchY + "] ");
            }
            if (this.mHasNestedScrollRange) {
                adjustNestedScrollRange();
            }
            if (zCanScrollVertically) {
                iCanScrollHorizontally = (iCanScrollHorizontally == true ? 1 : 0) | 2;
            }
            startNestedScroll(iCanScrollHorizontally, 0);
        } else {
            if (actionMasked == 1) {
                this.mVelocityTracker.addMovement(motionEventObtain);
                this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxFlingVelocity);
                float f = iCanScrollHorizontally != 0 ? -this.mVelocityTracker.getXVelocity(this.mScrollPointerId) : 0.0f;
                float f4 = zCanScrollVertically ? -this.mVelocityTracker.getYVelocity(this.mScrollPointerId) : 0.0f;
                if ((f == 0.0f && f4 == 0.0f) || !fling((int) f, (int) f4)) {
                    setScrollState(0);
                }
                Log.i(TAG, "onTouchUp() velocity : " + f4 + ", last move skip : " + this.mIsSkipMoveEvent + "(" + this.mFrameLatency + "), use scroller : " + this.mViewFlinger.mOverScroller.getClass().getName());
                resetScroll();
                motionEventObtain.recycle();
                return true;
            }
            if (actionMasked != 2) {
                if (actionMasked != 3) {
                    if (actionMasked == 5) {
                        this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
                        int x2 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                        this.mLastTouchX = x2;
                        this.mInitialTouchX = x2;
                        int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                        this.mLastTouchY = y3;
                        this.mInitialTouchY = y3;
                    } else if (actionMasked == 6) {
                        onPointerUp(motionEvent);
                    }
                } else if (!this.mSeslIsNested || this.mScrollState == 1) {
                    cancelScroll();
                }
            } else if ((objArr2 == false || objArr3 == false) && !this.mIsPenButtonPressed) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
                if (iFindPointerIndex < 0) {
                    Log.e(TAG, "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                    motionEventObtain.recycle();
                    return false;
                }
                int x5 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
                int y4 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
                int iMax = this.mLastTouchX - x5;
                int iMax2 = this.mLastTouchY - y4;
                if (this.mScrollState != 1) {
                    if (iCanScrollHorizontally == 0) {
                        objArr = false;
                        if (zCanScrollVertically) {
                            iMax2 = iMax2 > 0 ? Math.max(0, iMax2 - this.mTouchSlop) : Math.min(0, iMax2 + this.mTouchSlop);
                            if (iMax2 != 0) {
                                objArr = true;
                            }
                        }
                        if (objArr != false) {
                            setScrollState(1);
                        }
                    } else {
                        iMax = iMax > 0 ? Math.max(0, iMax - this.mTouchSlop) : Math.min(0, iMax + this.mTouchSlop);
                        if (iMax != 0) {
                            objArr = true;
                        }
                        if (zCanScrollVertically) {
                        }
                        if (objArr != false) {
                        }
                    }
                    motionEventObtain.recycle();
                    return true;
                }
                if (this.mScrollState == 1) {
                    int[] iArr3 = this.mReusableIntPair;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    int iReleaseHorizontalGlow = iMax - releaseHorizontalGlow(iMax, motionEvent.getY());
                    int iReleaseVerticalGlow = iMax2 - releaseVerticalGlow(iMax2, motionEvent.getX());
                    if (dispatchNestedPreScroll(iCanScrollHorizontally != 0 ? iReleaseHorizontalGlow : 0, zCanScrollVertically ? iReleaseVerticalGlow : 0, this.mReusableIntPair, this.mScrollOffset, 0)) {
                        int[] iArr4 = this.mReusableIntPair;
                        iReleaseHorizontalGlow -= iArr4[0];
                        iReleaseVerticalGlow -= iArr4[1];
                        int[] iArr5 = this.mNestedOffsets;
                        int i = iArr5[0];
                        int[] iArr6 = this.mScrollOffset;
                        iArr5[0] = i + iArr6[0];
                        iArr5[1] = iArr5[1] + iArr6[1];
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    int[] iArr7 = this.mScrollOffset;
                    this.mLastTouchX = x5 - iArr7[0];
                    this.mLastTouchY = y4 - iArr7[1];
                    if ((motionEvent.getFlags() & 33554432) != 0) {
                        this.mVelocityTracker.addMovement(motionEventObtain);
                        this.mIsSkipMoveEvent = true;
                        motionEventObtain.recycle();
                        return false;
                    }
                    if (scrollByInternal(iCanScrollHorizontally != 0 ? iReleaseHorizontalGlow : 0, zCanScrollVertically ? iReleaseVerticalGlow : 0, motionEvent, 0)) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    GapWorker gapWorker = this.mGapWorker;
                    if (gapWorker != null && (iReleaseHorizontalGlow != 0 || iReleaseVerticalGlow != 0)) {
                        gapWorker.postFromTraversal(this, iReleaseHorizontalGlow, iReleaseVerticalGlow);
                    }
                }
            }
        }
        this.mVelocityTracker.addMovement(motionEventObtain);
        motionEventObtain.recycle();
        return true;
    }

    public void postAnimationRunner() {
        if (this.mPostedAnimatorRunner || !this.mIsAttached) {
            return;
        }
        ViewCompat.postOnAnimation(this, this.mItemAnimatorRunner);
        this.mPostedAnimatorRunner = true;
    }

    public void processDataSetCompletelyChanged(boolean z) {
        this.mDispatchItemsChangedEvent = z | this.mDispatchItemsChangedEvent;
        this.mDataSetHasChangedAfterLayout = true;
        markKnownViewsInvalid();
    }

    public void recordAnimationInfoIfBouncedHiddenView(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo) {
        viewHolder.setFlags(0, 8192);
        if (this.mState.mTrackOldChangeHolders && viewHolder.isUpdated() && !viewHolder.isRemoved() && !viewHolder.shouldIgnore()) {
            this.mViewInfoStore.addToOldChangeHolders(getChangedHolderKey(viewHolder), viewHolder);
        }
        this.mViewInfoStore.addToPreLayout(viewHolder, itemHolderInfo);
    }

    public void removeAndRecycleViews() {
        ItemAnimator itemAnimator = this.mItemAnimator;
        if (itemAnimator != null) {
            itemAnimator.endAnimations();
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.removeAndRecycleAllViews(this.mRecycler);
        }
        LayoutManager layoutManager2 = this.mLayout;
        if (layoutManager2 != null) {
            layoutManager2.removeAndRecycleScrapInt(this.mRecycler);
        }
        this.mRecycler.clear();
    }

    public boolean removeAnimatingView(View view) {
        startInterceptRequestLayout();
        boolean zRemoveViewIfHidden = this.mChildHelper.removeViewIfHidden(view);
        if (zRemoveViewIfHidden) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(view);
            this.mRecycler.unscrapView(childViewHolderInt);
            this.mRecycler.recycleViewHolderInternal(childViewHolderInt);
            if (sVerboseLoggingEnabled) {
                Log.d(TAG, "after removing animated view: " + view + SQLKeyword.COMMA + this);
            }
        }
        stopInterceptRequestLayout(!zRemoveViewIfHidden);
        return zRemoveViewIfHidden;
    }

    @Override // android.view.ViewGroup
    public void removeDetachedView(View view, boolean z) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (childViewHolderInt.isTmpDetached()) {
                childViewHolderInt.clearTmpDetachFlag();
            } else if (!childViewHolderInt.shouldIgnore()) {
                StringBuilder sb = new StringBuilder("Called removeDetachedView with a view which is not flagged as tmp detached.");
                sb.append(childViewHolderInt);
                throw new IllegalArgumentException(AbstractC2821a.m2219j(this, sb));
            }
        } else if (sDebugAssertionsEnabled) {
            StringBuilder sb2 = new StringBuilder("No ViewHolder found for child: ");
            sb2.append(view);
            throw new IllegalArgumentException(AbstractC2821a.m2219j(this, sb2));
        }
        view.clearAnimation();
        dispatchChildDetached(view);
        super.removeDetachedView(view, z);
    }

    public void removeItemDecoration(@NonNull ItemDecoration itemDecoration) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
        }
        this.mItemDecorations.remove(itemDecoration);
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void removeItemDecorationAt(int i) {
        int itemDecorationCount = getItemDecorationCount();
        if (i >= 0 && i < itemDecorationCount) {
            removeItemDecoration(getItemDecorationAt(i));
            return;
        }
        throw new IndexOutOfBoundsException(i + " is an invalid index for size " + itemDecorationCount);
    }

    public void removeOnChildAttachStateChangeListener(@NonNull OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        List<OnChildAttachStateChangeListener> list = this.mOnChildAttachStateListeners;
        if (list == null) {
            return;
        }
        list.remove(onChildAttachStateChangeListener);
    }

    public void removeOnItemTouchListener(@NonNull OnItemTouchListener onItemTouchListener) {
        this.mOnItemTouchListeners.remove(onItemTouchListener);
        if (this.mInterceptingOnItemTouchListener == onItemTouchListener) {
            this.mInterceptingOnItemTouchListener = null;
        }
    }

    public void removeOnScrollListener(@NonNull OnScrollListener onScrollListener) {
        List<OnScrollListener> list = this.mScrollListeners;
        if (list != null) {
            list.remove(onScrollListener);
        }
    }

    public void removeRecyclerListener(@NonNull RecyclerListener recyclerListener) {
        this.mRecyclerListeners.remove(recyclerListener);
    }

    public void repositionShadowingViews() {
        ViewHolder viewHolder;
        int childCount = this.mChildHelper.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mChildHelper.getChildAt(i);
            ViewHolder childViewHolder = getChildViewHolder(childAt);
            if (childViewHolder != null && (viewHolder = childViewHolder.mShadowingHolder) != null) {
                View view = viewHolder.itemView;
                int left = childAt.getLeft();
                int top = childAt.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.mLayout.onRequestChildFocus(this, this.mState, view, view2) && view2 != null) {
            requestChildOnScreen(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z, int i) {
        if (i != 3) {
            return this.mLayout.requestChildRectangleOnScreen(this, view, rect, z);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.mOnItemTouchListeners.size();
        for (int i = 0; i < size; i++) {
            this.mOnItemTouchListeners.get(i).onRequestDisallowInterceptTouchEvent(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mInterceptRequestLayoutDepth != 0 || this.mLayoutSuppressed) {
            this.mLayoutWasDefered = true;
        } else {
            super.requestLayout();
        }
    }

    public void saveOldPositions() {
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i = 0; i < unfilteredChildCount; i++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i));
            if (sDebugAssertionsEnabled && childViewHolderInt.mPosition == -1 && !childViewHolderInt.isRemoved()) {
                throw new IllegalStateException(AbstractC2821a.m2219j(this, new StringBuilder("view holder cannot have position -1 unless it is removed")));
            }
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.saveOldPosition();
            }
        }
    }

    @Override // android.view.View
    public void scrollBy(int i, int i2) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            Log.e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.mLayoutSuppressed) {
            return;
        }
        boolean zCanScrollHorizontally = layoutManager.canScrollHorizontally();
        boolean zCanScrollVertically = this.mLayout.canScrollVertically();
        if (zCanScrollHorizontally || zCanScrollVertically) {
            if (!zCanScrollHorizontally) {
                i = 0;
            }
            if (!zCanScrollVertically) {
                i2 = 0;
            }
            scrollByInternal(i, i2, null, 0);
        }
    }

    public boolean scrollByInternal(int i, int i2, MotionEvent motionEvent, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        consumePendingUpdateOperations();
        if (this.mAdapter != null) {
            int[] iArr = this.mReusableIntPair;
            iArr[0] = 0;
            iArr[1] = 0;
            scrollStep(i, i2, iArr);
            int[] iArr2 = this.mReusableIntPair;
            int i9 = iArr2[0];
            int i10 = iArr2[1];
            i7 = i - i9;
            i8 = i2 - i10;
            i6 = i10;
            i5 = i9;
        } else {
            i5 = 0;
            i6 = 0;
            i7 = 0;
            i8 = 0;
        }
        if (!this.mItemDecorations.isEmpty()) {
            invalidate();
        }
        int[] iArr3 = this.mReusableIntPair;
        iArr3[0] = 0;
        iArr3[1] = 0;
        if (!seslDispatchNestedScroll(i5, i6, i7, i8, this.mScrollOffset, i4, iArr3)) {
            int[] iArr4 = this.mScrollOffset;
            iArr4[0] = 0;
            iArr4[1] = 0;
        }
        int[] iArr5 = this.mReusableIntPair;
        int i11 = iArr5[0];
        int i12 = i7 - i11;
        int i13 = iArr5[1];
        int i14 = i8 - i13;
        boolean z = (i11 == 0 && i13 == 0) ? false : true;
        int i15 = this.mLastTouchX;
        int[] iArr6 = this.mScrollOffset;
        int i16 = iArr6[0];
        this.mLastTouchX = i15 - i16;
        int i17 = this.mLastTouchY;
        int i18 = iArr6[1];
        this.mLastTouchY = i17 - i18;
        int[] iArr7 = this.mNestedOffsets;
        iArr7[0] = iArr7[0] + i16;
        iArr7[1] = iArr7[1] + i18;
        if (this.mIsEdgeEffectEnabled && !this.mPreventFirstGlow && getOverScrollMode() != 2) {
            if (motionEvent != null && !MotionEventCompat.isFromSource(motionEvent, 8194)) {
                pullGlows(motionEvent.getX(), i12, motionEvent.getY(), i14);
            }
            considerReleasingGlowsOnScroll(i, i2);
        }
        if (i5 != 0 || i6 != 0) {
            dispatchOnScrolled(i5, i6);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        if ((this.mLayout instanceof StaggeredGridLayoutManager) && (!canScrollVertically(-1) || !canScrollVertically(1))) {
            this.mLayout.onScrollStateChanged(0);
        }
        this.mPreventFirstGlow = false;
        return (!z && i5 == 0 && i6 == 0) ? false : true;
    }

    public void scrollStep(int i, int i2, @Nullable int[] iArr) {
        int iScrollVerticallyBy;
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        TraceCompat.beginSection(TRACE_SCROLL_TAG);
        fillRemainingScrollValues(this.mState);
        int iScrollHorizontallyBy = i != 0 ? this.mLayout.scrollHorizontallyBy(i, this.mRecycler, this.mState) : 0;
        if (i2 != 0) {
            iScrollVerticallyBy = this.mLayout.scrollVerticallyBy(i2, this.mRecycler, this.mState);
            SeslGoToTopController seslGoToTopController = this.mGoToTopController;
            if (seslGoToTopController != null && seslGoToTopController.getState() == 0) {
                showGoToTop();
            }
        } else {
            iScrollVerticallyBy = 0;
        }
        TraceCompat.endSection();
        repositionShadowingViews();
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        if (iArr != null) {
            iArr[0] = iScrollHorizontallyBy;
            iArr[1] = iScrollVerticallyBy;
        }
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        Log.w(TAG, "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void scrollToPosition(int i) {
        if (this.mLayoutSuppressed) {
            return;
        }
        stopScroll();
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            Log.e(TAG, "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        layoutManager.scrollToPosition(i);
        awakenScrollBars();
        SeslRecyclerViewFastScroller seslRecyclerViewFastScroller = this.mFastScroller;
        if (seslRecyclerViewFastScroller == null || this.mAdapter == null) {
            return;
        }
        seslRecyclerViewFastScroller.onScroll(findFirstVisibleItemPosition(), getChildCount(), this.mAdapter.getItemCount());
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (shouldDeferAccessibilityEvent(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    @Override // androidx.core.widget.SeslScrollable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void seslAddOnGoToTopClickListener(@NonNull SeslScrollable.SeslOnGoToTopClickListener seslOnGoToTopClickListener) {
        if (this.mOnGoToTopClickListeners == null) {
            this.mOnGoToTopClickListeners = new ArrayList();
        }
        this.mOnGoToTopClickListeners.add(seslOnGoToTopClickListener);
    }

    @Override // androidx.core.widget.SeslScrollable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void seslClearOnGoToTopClickListener() {
        List<SeslScrollable.SeslOnGoToTopClickListener> list = this.mOnGoToTopClickListeners;
        if (list != null) {
            list.clear();
        }
    }

    public View seslFindNearChildViewUnder(float f, float f4) {
        int i = (int) (f + 0.5f);
        int i2 = (int) (0.5f + f4);
        int childCount = this.mChildHelper.getChildCount() - 1;
        int i4 = 0;
        int i5 = i2;
        int i6 = Integer.MAX_VALUE;
        for (int i7 = childCount; i7 >= 0; i7--) {
            View childAt = getChildAt(i7);
            if (childAt != null) {
                int bottom = (childAt.getBottom() + childAt.getTop()) / 2;
                if (i4 != bottom) {
                    int iAbs = Math.abs(i2 - bottom);
                    if (iAbs < i6) {
                        i6 = iAbs;
                        i4 = bottom;
                        i5 = i4;
                    } else {
                        if (!(this.mLayout instanceof StaggeredGridLayoutManager)) {
                            break;
                        }
                        i4 = bottom;
                    }
                } else {
                    continue;
                }
            }
        }
        int i8 = -1;
        int i9 = Integer.MAX_VALUE;
        int i10 = Integer.MAX_VALUE;
        int i11 = -1;
        while (childCount >= 0) {
            View childAt2 = getChildAt(childCount);
            if (childAt2 != null) {
                int top = childAt2.getTop();
                int bottom2 = childAt2.getBottom();
                int left = childAt2.getLeft();
                int right = childAt2.getRight();
                if (i5 >= top && i5 <= bottom2) {
                    int iAbs2 = Math.abs(i - left);
                    int iAbs3 = Math.abs(i - right);
                    if (iAbs2 <= i9) {
                        i8 = childCount;
                        i9 = iAbs2;
                    }
                    if (iAbs3 <= i10) {
                        i11 = childCount;
                        i10 = iAbs3;
                    }
                }
                if (i5 > bottom2 || childCount == 0) {
                    return i9 < i10 ? this.mChildHelper.getChildAt(i8) : this.mChildHelper.getChildAt(i11);
                }
            }
            childCount--;
        }
        Log.e(TAG, "findNearChildViewUnder didn't find valid child view! " + f + SQLKeyword.COMMA + f4);
        return null;
    }

    @Override // androidx.core.widget.SeslScrollable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void seslForceBottomFadingEdgeClamped(int i) {
        this.mFadingEdgeHelper.forceBottomFadingEdgeClamped(i);
    }

    @Override // androidx.core.widget.SeslScrollable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void seslForceTopFadingEdgeClamped(int i) {
        this.mFadingEdgeHelper.forceTopFadingEdgeClamped(i);
    }

    @Override // androidx.core.widget.SeslScrollable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public Rect seslGetAvailableBounds() {
        return this.mAvailableBounds;
    }

    @Override // androidx.core.widget.SeslScrollable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int seslGetBottomScrollOffset() {
        return this.mFadingEdgeHelper.getFadingEdgeBottomOffset();
    }

    @Override // androidx.core.widget.SeslScrollable
    public int seslGetGoToTopBottomPadding() {
        SeslGoToTopController seslGoToTopController = this.mGoToTopController;
        if (seslGoToTopController != null) {
            return seslGoToTopController.getBottomPadding();
        }
        return 0;
    }

    @Override // androidx.core.widget.SeslScrollable
    public int seslGetGoToTopDefaultBottomPadding() {
        SeslGoToTopController seslGoToTopController = this.mGoToTopController;
        if (seslGoToTopController != null) {
            return seslGoToTopController.getDefaultBottomPadding();
        }
        return 0;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @VisibleForTesting
    public SeslGoToTopImageView seslGetGoToTopView() {
        SeslGoToTopController seslGoToTopController = this.mGoToTopController;
        if (seslGoToTopController != null) {
            return seslGoToTopController.getView();
        }
        return null;
    }

    @Override // androidx.core.widget.SeslScrollable
    public int seslGetHoverBottomPadding() {
        return this.mHoverBottomAreaHeight;
    }

    @Override // androidx.core.widget.SeslScrollable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int seslGetHoverDefaultBottomPadding() {
        return this.mHoverDefaultBottomAreaHeight;
    }

    @Override // androidx.core.widget.SeslScrollable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int seslGetHoverDefaultTopPadding() {
        return this.mHoverDefaultTopAreaHeight;
    }

    @Override // androidx.core.widget.SeslScrollable
    public int seslGetHoverTopPadding() {
        return this.mHoverTopAreaHeight;
    }

    public final SeslOnMultiSelectedListener seslGetOnMultiSelectedListener() {
        return this.mOnMultiSelectedListener;
    }

    @Override // androidx.core.widget.SeslScrollable
    public int seslGetScrollBarBottomOffset() {
        return this.mScrollBarBottomOffset;
    }

    @Override // androidx.core.widget.SeslScrollable
    public int seslGetScrollBarTopOffset() {
        return this.mScrollBarTopOffset;
    }

    public void seslHideBottomFadingEdge(boolean z) {
        this.mFadingEdgeHelper.hideBottomFadingEdge(z);
    }

    public void seslHideTopFadingEdge(boolean z) {
        this.mFadingEdgeHelper.hideTopFadingEdge(z);
    }

    public void seslInitConfigurations(Context context) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        Resources resources = context.getResources();
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mTouchSlop2 = viewConfiguration.getScaledTouchSlop();
        this.mPagingTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
        this.mScaledHorizontalScrollFactor = ViewConfigurationCompat.getScaledHorizontalScrollFactor(viewConfiguration, context);
        this.mScaledVerticalScrollFactor = ViewConfigurationCompat.getScaledVerticalScrollFactor(viewConfiguration, context);
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mHoverDefaultTopAreaHeight = (int) (TypedValue.applyDimension(1, 25.0f, resources.getDisplayMetrics()) + 0.5f);
        this.mHoverDefaultBottomAreaHeight = (int) (TypedValue.applyDimension(1, 25.0f, resources.getDisplayMetrics()) + 0.5f);
    }

    public boolean seslIsFastScrollerEnabled() {
        SeslRecyclerViewFastScroller seslRecyclerViewFastScroller = this.mFastScroller;
        return seslRecyclerViewFastScroller != null && seslRecyclerViewFastScroller.isEnabled();
    }

    public boolean seslIsIndexTipEnabled() {
        return this.mIndexTipEnabled;
    }

    public boolean seslIsPagingTouchSlopForStylusEnabled() {
        return this.mUsePagingTouchSlopForStylus;
    }

    @Override // androidx.core.widget.SeslScrollable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void seslRemoveOnGoToTopClickListener(@NonNull SeslScrollable.SeslOnGoToTopClickListener seslOnGoToTopClickListener) {
        List<SeslScrollable.SeslOnGoToTopClickListener> list = this.mOnGoToTopClickListeners;
        if (list != null) {
            list.remove(seslOnGoToTopClickListener);
        }
    }

    public void seslSetAllowTopFadingEdgeWithoutEdgeToEdge(boolean z) {
        this.mFadingEdgeHelper.setAllowTopFadingEdgeWithoutEdgeToEdge(z);
    }

    @Override // androidx.core.widget.SeslScrollable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void seslSetAvailableBounds(@Nullable Rect rect) {
        this.mAvailableBounds = rect;
    }

    @Override // androidx.core.widget.SeslScrollable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void seslSetBottomScrollOffset(int i) {
        if (this.mFadingEdgeHelper.getFadingEdgeBottomOffset() != i) {
            this.mFadingEdgeHelper.setFadingEdgeBottomOffset(i);
            invalidate();
        }
    }

    public void seslSetCtrlkeyPressed(boolean z) {
        this.mIsCtrlKeyPressed = z;
    }

    @Override // androidx.core.widget.SeslScrollable
    public void seslSetFadingEdgeColor(@ColorInt int i) {
        this.mFadingEdgeHelper.setFadingEdgeColor(i, new RunnableC3802b(this, 1));
        invalidate();
    }

    @Override // androidx.core.widget.SeslScrollable
    public void seslSetFadingEdgeEnabled(boolean z, int i, int i2) {
        applyFadingEdge(z, new RunnableC2502b(this, z, i, i2, 1));
    }

    public void seslSetFadingEdgeWindowBottomAlignment(boolean z) {
        this.mFadingEdgeHelper.setWindowBottomAlignment(z);
    }

    @RequiresApi(api = 24)
    public void seslSetFastScrollerAdditionalPadding(int i, int i2) {
        SeslRecyclerViewFastScroller seslRecyclerViewFastScroller = this.mFastScroller;
        if (seslRecyclerViewFastScroller != null) {
            seslRecyclerViewFastScroller.setAdditionalPadding(i, i2);
        }
    }

    @RequiresApi(26)
    public void seslSetFastScrollerColor(int i) {
        SeslRecyclerViewFastScroller seslRecyclerViewFastScroller = this.mFastScroller;
        if (seslRecyclerViewFastScroller != null) {
            seslRecyclerViewFastScroller.setDefaultColor(i);
        }
    }

    public void seslSetFastScrollerEnabled(boolean z) {
        SeslRecyclerViewFastScroller seslRecyclerViewFastScroller = this.mFastScroller;
        if (seslRecyclerViewFastScroller != null) {
            z = z != seslRecyclerViewFastScroller.isEnabled();
            this.mFastScroller.setEnabled(z);
        } else if (z) {
            SeslRecyclerViewFastScroller seslRecyclerViewFastScroller2 = new SeslRecyclerViewFastScroller(this);
            this.mFastScroller = seslRecyclerViewFastScroller2;
            seslRecyclerViewFastScroller2.setEnabled(true);
            this.mFastScroller.setScrollbarPosition(getVerticalScrollbarPosition());
        } else {
            z = false;
        }
        SeslRecyclerViewFastScroller seslRecyclerViewFastScroller3 = this.mFastScroller;
        if (seslRecyclerViewFastScroller3 != null && z) {
            seslRecyclerViewFastScroller3.updateLayout();
        }
        if (this.mLayout instanceof StaggeredGridLayoutManager) {
            Log.w(TAG, "FastScroller cannot be used with StaggeredGridLayoutManager.");
        }
    }

    public void seslSetFastScrollerEventListener(SeslFastScrollerEventListener seslFastScrollerEventListener) {
        this.mFastScrollerEventListener = seslFastScrollerEventListener;
    }

    @RequiresApi(24)
    public void seslSetFastScrollerThreshold(float f) {
        SeslRecyclerViewFastScroller seslRecyclerViewFastScroller = this.mFastScroller;
        if (seslRecyclerViewFastScroller == null || f < 0.0f) {
            return;
        }
        seslRecyclerViewFastScroller.setThreshold(f);
    }

    public void seslSetFillBottomColor(@ColorInt int i) {
        this.mRectPaint.setColor(i);
        this.mRoundedCorner.setRoundedCornerColor(12, i);
    }

    public void seslSetFillBottomEnabled(boolean z) {
        if (this.mLayout instanceof LinearLayoutManager) {
            this.mDrawRect = z;
            requestLayout();
        }
    }

    public void seslSetFillHorizontalPaddingEnabled(boolean z) {
        this.mDrawHorizontalPadding = z;
        int dimensionPixelOffset = z ? getResources().getDimensionPixelOffset(C3728R.dimen.sesl_system_scroller_vertical_padding) : 0;
        this.mScrollbarTopPadding = dimensionPixelOffset;
        this.mScrollbarBottomPadding = dimensionPixelOffset;
        updateScrollbarVerticalPadding();
        SeslRecyclerViewFastScroller seslRecyclerViewFastScroller = this.mFastScroller;
        if (seslRecyclerViewFastScroller != null) {
            seslRecyclerViewFastScroller.setScrollBarStyle(getScrollBarStyle());
        }
        requestLayout();
    }

    @Override // androidx.core.widget.SeslScrollable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void seslSetFloatingBottomLayoutHeight(int i) {
        this.mSeslBottomBarHeight = i;
    }

    public void seslSetGoToTopBlurEnabled(boolean z) {
        SeslGoToTopController seslGoToTopController = this.mGoToTopController;
        if (seslGoToTopController != null) {
            seslGoToTopController.setBlurEnabled(z, SeslMisc.isLightTheme(this.mContext));
        }
    }

    @Override // androidx.core.widget.SeslScrollable
    public void seslSetGoToTopBottomPadding(int i) {
        SeslGoToTopController seslGoToTopController = this.mGoToTopController;
        if (seslGoToTopController != null) {
            seslGoToTopController.setBottomPadding(i);
        }
    }

    public void seslSetGoToTopEnabled(boolean z) {
        seslSetGoToTopEnabled(z, SeslMisc.isLightTheme(this.mContext));
    }

    public void seslSetGoToTopPaddingHorizontal(int i, int i2) {
        SeslGoToTopController seslGoToTopController = this.mGoToTopController;
        if (seslGoToTopController != null) {
            seslGoToTopController.setPaddingHorizontal(i, i2);
        }
    }

    @Override // androidx.core.widget.SeslScrollable
    public void seslSetHoverBottomPadding(int i) {
        int iMax = Math.max(0, i);
        if (this.mHoverBottomAreaHeight != iMax) {
            this.mHoverBottomAreaHeight = iMax;
        }
    }

    public void seslSetHoverScrollEnabled(boolean z) {
        this.mHoverScrollEnable = z;
        this.mHoverScrollStateChanged = true;
    }

    @Override // androidx.core.widget.SeslScrollable
    public void seslSetHoverTopPadding(int i) {
        int iMax = Math.max(0, i);
        if (this.mHoverTopAreaHeight != iMax) {
            this.mHoverTopAreaHeight = iMax;
        }
    }

    @RequiresApi(api = 24)
    public void seslSetImmersiveScrollBottomPadding(int i) {
        if (i >= 0) {
            SeslGoToTopController seslGoToTopController = this.mGoToTopController;
            if (seslGoToTopController != null) {
                seslGoToTopController.setImmersiveBottomPadding(i);
            }
            SeslRecyclerViewFastScroller seslRecyclerViewFastScroller = this.mFastScroller;
            if (seslRecyclerViewFastScroller == null || this.mAdapter == null) {
                return;
            }
            seslRecyclerViewFastScroller.setImmersiveBottomPadding(i);
        }
    }

    public void seslSetIndexTipEnabled(boolean z) {
        if (!(this.mAdapter instanceof SectionIndexer)) {
            throw new IllegalStateException("In order to use Index Tip, your Adapter has to implements SectionIndexer. or check if setAdapter is preceded.");
        }
        if (z) {
            IndexTip indexTip = this.mIndexTip;
            if (indexTip == null) {
                this.mIndexTip = new IndexTip(this.mContext);
            } else {
                indexTip.hide();
            }
            if (!this.mIndexTipEnabled) {
                getOverlay().add(this.mIndexTip);
            }
            this.mIndexTip.setLayout(0, this.mScrollBarTopOffset, getRight(), getBottom(), getPaddingLeft() + this.mIndexTip.getPaddingLeft(), getPaddingRight() + this.mIndexTip.getPaddingRight());
        } else if (this.mIndexTipEnabled) {
            getOverlay().remove(this.mIndexTip);
        }
        this.mIndexTipEnabled = z;
    }

    public void seslSetIndexTipPaddingHorizontal(int i, int i2) {
        IndexTip indexTip = this.mIndexTip;
        if (indexTip != null) {
            indexTip.setPadding(i, indexTip.getPaddingTop(), i2, this.mIndexTip.getPaddingBottom());
            this.mIndexTip.setLayout(0, this.mScrollBarTopOffset, getRight(), getBottom(), getPaddingLeft() + this.mIndexTip.getPaddingLeft(), getPaddingRight() + this.mIndexTip.getPaddingRight());
        }
    }

    public void seslSetLastRoundedCorner(boolean z) {
        this.mDrawLastRoundedCorner = z;
    }

    public void seslSetLongPressMultiSelectionListener(SeslLongPressMultiSelectionListener seslLongPressMultiSelectionListener) {
        this.mLongPressMultiSelectionListener = seslLongPressMultiSelectionListener;
    }

    public void seslSetNestedRecyclerView(boolean z) {
        this.mSeslIsNested = z;
    }

    public void seslSetOnGoToTopClickListener(SeslOnGoToTopClickListener seslOnGoToTopClickListener) {
        this.mOnGoToTopClickListener = seslOnGoToTopClickListener;
    }

    public void seslSetOnMultiSelectedListener(SeslOnMultiSelectedListener seslOnMultiSelectedListener) {
        this.mOnMultiSelectedListener = seslOnMultiSelectedListener;
    }

    public void seslSetPagingTouchSlopForStylus(boolean z) {
        this.mUsePagingTouchSlopForStylus = z;
    }

    public void seslSetPenSelectionEnabled(boolean z) {
        this.mIsPenSelectionEnabled = z;
    }

    public void seslSetPointerIconRotation(float f) {
        this.mPointerIconRotation = f;
    }

    public void seslSetRecoilEnabled(boolean z) {
        if (this.mIsRecoilEnabled != z) {
            this.mIsRecoilEnabled = z;
        }
    }

    @Override // androidx.core.widget.SeslScrollable
    public void seslSetScrollBarBottomOffset(int i) {
        int i2 = i - this.mScrollBarTopOffset;
        if (this.mScrollBarBottomOffset != i2) {
            this.mScrollBarBottomOffset = Math.max(i2, 0);
            updateScrollbarVerticalPadding();
            SeslRecyclerViewFastScroller seslRecyclerViewFastScroller = this.mFastScroller;
            if (seslRecyclerViewFastScroller != null) {
                seslRecyclerViewFastScroller.setScrollBarBottomOffset(this.mScrollBarBottomOffset);
            }
            SeslScrollable.SeslScrollBarOffsetChangedListener seslScrollBarOffsetChangedListener = this.mScrollBarOffsetListener;
            if (seslScrollBarOffsetChangedListener != null) {
                seslScrollBarOffsetChangedListener.onOffsetChanged(this.mScrollBarTopOffset, this.mScrollBarBottomOffset);
            }
        }
    }

    @Override // androidx.core.widget.SeslScrollable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void seslSetScrollBarOffsetChangedListener(@Nullable SeslScrollable.SeslScrollBarOffsetChangedListener seslScrollBarOffsetChangedListener) {
        this.mScrollBarOffsetListener = seslScrollBarOffsetChangedListener;
    }

    @Override // androidx.core.widget.SeslScrollable
    public void seslSetScrollBarTopOffset(int i) {
        IndexTip indexTip;
        if (this.mScrollBarTopOffset != i) {
            this.mScrollBarTopOffset = Math.max(i, 0);
            updateScrollbarVerticalPadding();
            SeslRecyclerViewFastScroller seslRecyclerViewFastScroller = this.mFastScroller;
            if (seslRecyclerViewFastScroller != null) {
                seslRecyclerViewFastScroller.setScrollBarTopOffset(this.mScrollBarTopOffset);
            }
            SeslScrollable.SeslScrollBarOffsetChangedListener seslScrollBarOffsetChangedListener = this.mScrollBarOffsetListener;
            if (seslScrollBarOffsetChangedListener != null) {
                seslScrollBarOffsetChangedListener.onOffsetChanged(this.mScrollBarTopOffset, this.mScrollBarBottomOffset);
            }
            if (!this.mIndexTipEnabled || (indexTip = this.mIndexTip) == null) {
                return;
            }
            indexTip.setLayout(0, this.mScrollBarTopOffset, getRight(), getBottom(), getPaddingLeft() + this.mIndexTip.getPaddingLeft(), getPaddingRight() + this.mIndexTip.getPaddingRight());
        }
    }

    public void seslSetScrollbarVerticalPadding(int i, int i2) {
        this.mScrollbarTopPadding = i;
        this.mScrollbarBottomPadding = i2;
        updateScrollbarVerticalPadding();
    }

    public void seslSetSmoothScrollEnabled(boolean z) {
        ViewFlinger viewFlinger = this.mViewFlinger;
        if (viewFlinger != null) {
            SeslOverScrollerReflector.setSmoothScrollEnabled(viewFlinger.mOverScroller, z);
        }
    }

    public void seslShowGoToTopEdge(float f, float f4, int i) {
        removeCallbacks(this.mGoToTopEdgeEffectRunnable);
        postDelayed(this.mGoToTopEdgeEffectRunnable, i);
    }

    public void seslSnapScrollToPosition(int i) {
        final float fComputeHorizontalScrollRange = computeHorizontalScrollRange() * 0.2f;
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(this.mContext) { // from class: androidx.recyclerview.widget.RecyclerView.13
            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return fComputeHorizontalScrollRange / RecyclerView.this.computeHorizontalScrollRange();
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public int getHorizontalSnapPreference() {
                return 1;
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public int getVerticalSnapPreference() {
                return 1;
            }
        };
        linearSmoothScroller.setTargetPosition(i);
        if (getLayoutManager() != null) {
            getLayoutManager().startSmoothScroll(linearSmoothScroller);
        }
    }

    public void seslStartLongPressMultiSelection() {
        this.mIsLongPressMultiSelection = true;
    }

    public void seslUpdateIndexTipPosition() {
        IndexTip indexTip = this.mIndexTip;
        if (indexTip != null) {
            if (indexTip.mCurrentOrientation != 1) {
                this.mIndexTip.mIsNeedUpdate = false;
            } else {
                this.mIndexTip.mIsNeedUpdate = true;
                this.mIndexTip.invalidate();
            }
        }
    }

    public void seslUpdateIndexTipSections() {
        IndexTip indexTip = this.mIndexTip;
        if (indexTip != null) {
            indexTip.updateSections();
        }
    }

    public void setAccessibilityDelegateCompat(@Nullable RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate) {
        this.mAccessibilityDelegate = recyclerViewAccessibilityDelegate;
        ViewCompat.setAccessibilityDelegate(this, recyclerViewAccessibilityDelegate);
    }

    public void setAdapter(@Nullable Adapter adapter) {
        setLayoutFrozen(false);
        setAdapterInternal(adapter, false, true);
        processDataSetCompletelyChanged(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(@Nullable ChildDrawingOrderCallback childDrawingOrderCallback) {
        if (childDrawingOrderCallback == this.mChildDrawingOrderCallback) {
            return;
        }
        this.mChildDrawingOrderCallback = childDrawingOrderCallback;
        setChildrenDrawingOrderEnabled(childDrawingOrderCallback != null);
    }

    @VisibleForTesting
    public boolean setChildImportantForAccessibilityInternal(ViewHolder viewHolder, int i) {
        if (!isComputingLayout()) {
            ViewCompat.setImportantForAccessibility(viewHolder.itemView, i);
            return true;
        }
        viewHolder.mPendingAccessibilityState = i;
        this.mPendingAccessibilityImportanceChange.add(viewHolder);
        return false;
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        if (z != this.mClipToPadding) {
            invalidateGlows();
        }
        this.mClipToPadding = z;
        super.setClipToPadding(z);
        if (this.mFirstLayoutComplete) {
            requestLayout();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setEdgeEffectEnabled(boolean z) {
        if (this.mIsEdgeEffectEnabled != z) {
            this.mIsEdgeEffectEnabled = z;
        }
    }

    public void setEdgeEffectFactory(@NonNull EdgeEffectFactory edgeEffectFactory) {
        Preconditions.checkNotNull(edgeEffectFactory);
        this.mEdgeEffectFactory = edgeEffectFactory;
        invalidateGlows();
    }

    public void setHasFixedSize(boolean z) {
        this.mHasFixedSize = z;
    }

    public void setItemAnimator(@Nullable ItemAnimator itemAnimator) {
        ItemAnimator itemAnimator2 = this.mItemAnimator;
        if (itemAnimator2 != null) {
            itemAnimator2.endAnimations();
            this.mItemAnimator.setListener(null);
        }
        this.mItemAnimator = itemAnimator;
        if (itemAnimator != null) {
            itemAnimator.setListener(this.mItemAnimatorListener);
            this.mItemAnimator.setHostView(this);
        }
    }

    public void setItemViewCacheSize(int i) {
        this.mRecycler.setViewCacheSize(i);
    }

    @Deprecated
    public void setLayoutFrozen(boolean z) {
        suppressLayout(z);
    }

    public void setLayoutManager(@Nullable LayoutManager layoutManager) {
        if (layoutManager == this.mLayout) {
            return;
        }
        boolean z = layoutManager instanceof LinearLayoutManager;
        boolean z2 = false;
        this.mDrawRect = this.mDrawRect && z;
        if (this.mDrawLastRoundedCorner && z) {
            z2 = true;
        }
        this.mDrawLastRoundedCorner = z2;
        stopScroll();
        if (this.mLayout != null) {
            ItemAnimator itemAnimator = this.mItemAnimator;
            if (itemAnimator != null) {
                itemAnimator.endAnimations();
            }
            this.mLayout.removeAndRecycleAllViews(this.mRecycler);
            this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
            this.mRecycler.clear();
            if (this.mIsAttached) {
                this.mLayout.dispatchDetachedFromWindow(this, this.mRecycler);
            }
            this.mLayout.setRecyclerView(null);
            this.mLayout = null;
        } else {
            this.mRecycler.clear();
        }
        this.mChildHelper.removeAllViewsUnfiltered();
        this.mLayout = layoutManager;
        if (layoutManager != null) {
            if (layoutManager.mRecyclerView != null) {
                StringBuilder sb = new StringBuilder("LayoutManager ");
                sb.append(layoutManager);
                sb.append(" is already attached to a RecyclerView:");
                throw new IllegalArgumentException(AbstractC2821a.m2219j(layoutManager.mRecyclerView, sb));
            }
            layoutManager.setRecyclerView(this);
            if (this.mIsAttached) {
                this.mLayout.dispatchAttachedToWindow(this);
            }
        }
        this.mRecycler.updateViewCacheSize();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition != null) {
            throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
        }
        super.setLayoutTransition(null);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().setNestedScrollingEnabled(z);
    }

    public void setOnFlingListener(@Nullable OnFlingListener onFlingListener) {
        this.mOnFlingListener = onFlingListener;
    }

    @Deprecated
    public void setOnScrollListener(@Nullable OnScrollListener onScrollListener) {
        this.mScrollListener = onScrollListener;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.mPreserveFocusAfterLayout = z;
    }

    public void setRecycledViewPool(@Nullable RecycledViewPool recycledViewPool) {
        this.mRecycler.setRecycledViewPool(recycledViewPool);
    }

    @Deprecated
    public void setRecyclerListener(@Nullable RecyclerListener recyclerListener) {
        this.mRecyclerListener = recyclerListener;
    }

    @Override // android.view.View
    public void setScrollBarStyle(int i) {
        super.setScrollBarStyle(i);
        SeslRecyclerViewFastScroller seslRecyclerViewFastScroller = this.mFastScroller;
        if (seslRecyclerViewFastScroller != null) {
            seslRecyclerViewFastScroller.setScrollBarStyle(i);
        }
    }

    public void setScrollState(int i) {
        IndexTip indexTip;
        if (i == this.mScrollState) {
            return;
        }
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "setting scroll state to ", " from ");
        sbM778t.append(this.mScrollState);
        Log.d(TAG, sbM778t.toString());
        if (sVerboseLoggingEnabled) {
            StringBuilder sbM778t2 = AbstractC0541b.m778t(i, "setting scroll state to ", " from ");
            sbM778t2.append(this.mScrollState);
            Log.d(TAG, sbM778t2.toString(), new Exception());
        }
        this.mScrollState = i;
        if (i != 2) {
            stopScrollersInternal();
        }
        dispatchOnScrollStateChanged(i);
        if (i == 1) {
            this.mEdgeEffectByDragging = false;
        }
        if (i == 0 && this.mIndexTipEnabled && (indexTip = this.mIndexTip) != null) {
            indexTip.hide();
        }
    }

    public void setScrollingTouchSlop(int i) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        Log.d(TAG, "setScrollingTouchSlop(): slopConstant[" + i + "]");
        seslSetPagingTouchSlopForStylus(false);
        if (i != 0) {
            if (i == 1) {
                this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
            Log.w(TAG, "setScrollingTouchSlop(): bad argument constant " + i + "; using default value");
        }
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(@Nullable ViewCacheExtension viewCacheExtension) {
        this.mRecycler.setViewCacheExtension(viewCacheExtension);
    }

    public boolean shouldDeferAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (!isComputingLayout()) {
            return false;
        }
        int contentChangeTypes = accessibilityEvent != null ? AccessibilityEventCompat.getContentChangeTypes(accessibilityEvent) : 0;
        this.mEatenAccessibilityChangeFlags |= contentChangeTypes != 0 ? contentChangeTypes : 0;
        return true;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void showGoToTop() {
        SeslGoToTopController seslGoToTopController = this.mGoToTopController;
        if (seslGoToTopController != null) {
            seslGoToTopController.showIfNeeded();
        }
    }

    public boolean showPointerIcon(MotionEvent motionEvent, int i) {
        SeslViewReflector.semSetPointerIcon(this, motionEvent.getToolType(0), SeslPointerIconCompat.isSemStylusDefault(i) ? null : PointerIcon.getSystemIcon(this.mContext, i));
        return true;
    }

    public void smoothScrollBy(@Px int i, @Px int i2) {
        smoothScrollBy(i, i2, null);
    }

    public void smoothScrollToPosition(int i) {
        if (this.mLayoutSuppressed) {
            return;
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            layoutManager.smoothScrollToPosition(this, this.mState, i);
        }
    }

    public void smoothScrollToPositionJumpIfNeeded(final int i) {
        int iFindFirstVisibleItemPosition = findFirstVisibleItemPosition();
        boolean z = iFindFirstVisibleItemPosition > i;
        int iFindLastVisibleItemPosition = z ? iFindFirstVisibleItemPosition : findLastVisibleItemPosition();
        int iAbs = Math.abs(((z ? 1 : -1) * i) + (getChildCount() * 2));
        if (computeVerticalScrollOffset() != 0) {
            stopScroll();
        }
        if (Settings.System.getInt(getContext().getContentResolver(), DeviceSettingsUtil.REDUCE_ANIMATION, 0) == 1) {
            scrollToPosition(0);
            return;
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            ((StaggeredGridLayoutManager) layoutManager).scrollToPositionWithOffset(i, 0);
            return;
        }
        if (iFindFirstVisibleItemPosition > 0 && ((z && iAbs > 0 && iAbs < iFindLastVisibleItemPosition) || (!z && iAbs > 0 && iAbs > iFindLastVisibleItemPosition))) {
            jumpToPosition(iAbs);
        }
        post(new Runnable() { // from class: androidx.recyclerview.widget.RecyclerView.11
            @Override // java.lang.Runnable
            public void run() {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.mLayoutSuppressed) {
                    return;
                }
                LayoutManager layoutManager2 = recyclerView.mLayout;
                if (layoutManager2 == null) {
                    Log.e(RecyclerView.TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
                } else if (layoutManager2 instanceof LinearLayoutManager) {
                    ((LinearLayoutManager) layoutManager2).smoothScrollToPositionJumpIfNeeded(recyclerView, recyclerView.mState, i);
                } else {
                    layoutManager2.smoothScrollToPosition(recyclerView, recyclerView.mState, i);
                }
            }
        });
    }

    public void startInterceptRequestLayout() {
        int i = this.mInterceptRequestLayoutDepth + 1;
        this.mInterceptRequestLayoutDepth = i;
        if (i != 1 || this.mLayoutSuppressed) {
            return;
        }
        this.mLayoutWasDefered = false;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i) {
        return getScrollingChildHelper().startNestedScroll(i);
    }

    public void stopInterceptRequestLayout(boolean z) {
        if (this.mInterceptRequestLayoutDepth < 1) {
            if (sDebugAssertionsEnabled) {
                throw new IllegalStateException(AbstractC2821a.m2219j(this, new StringBuilder("stopInterceptRequestLayout was called more times than startInterceptRequestLayout.")));
            }
            this.mInterceptRequestLayoutDepth = 1;
        }
        if (!z && !this.mLayoutSuppressed) {
            this.mLayoutWasDefered = false;
        }
        if (this.mInterceptRequestLayoutDepth == 1) {
            if (z && this.mLayoutWasDefered && !this.mLayoutSuppressed && this.mLayout != null && this.mAdapter != null) {
                dispatchLayout();
            }
            if (!this.mLayoutSuppressed) {
                this.mLayoutWasDefered = false;
            }
        }
        this.mInterceptRequestLayoutDepth--;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        getScrollingChildHelper().stopNestedScroll();
    }

    public void stopScroll() {
        setScrollState(0);
        stopScrollersInternal();
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z) {
        if (z != this.mLayoutSuppressed) {
            assertNotInLayoutOrScroll("Do not suppressLayout in layout or scroll");
            if (z) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0));
                this.mLayoutSuppressed = true;
                this.mIgnoreMotionEventTillDown = true;
                stopScroll();
                return;
            }
            this.mLayoutSuppressed = false;
            if (this.mLayoutWasDefered && this.mLayout != null && this.mAdapter != null) {
                requestLayout();
            }
            this.mLayoutWasDefered = false;
        }
    }

    public void swapAdapter(@Nullable Adapter adapter, boolean z) {
        setLayoutFrozen(false);
        setAdapterInternal(adapter, true, z);
        processDataSetCompletelyChanged(true);
        requestLayout();
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        SeslGoToTopController seslGoToTopController = this.mGoToTopController;
        return (seslGoToTopController != null ? seslGoToTopController.verifyDrawable(drawable) : false) || super.verifyDrawable(drawable);
    }

    public void viewRangeUpdate(int i, int i2, Object obj) {
        int i4;
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        int i5 = i + i2;
        for (int i6 = 0; i6 < unfilteredChildCount; i6++) {
            View unfilteredChildAt = this.mChildHelper.getUnfilteredChildAt(i6);
            ViewHolder childViewHolderInt = getChildViewHolderInt(unfilteredChildAt);
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && (i4 = childViewHolderInt.mPosition) >= i && i4 < i5) {
                childViewHolderInt.addFlags(2);
                childViewHolderInt.addChangePayload(obj);
                ((LayoutParams) unfilteredChildAt.getLayoutParams()).mInsetsDirty = true;
            }
        }
        this.mRecycler.viewRangeUpdate(i, i2);
    }

    public RecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, C3728R.attr.recyclerViewStyle);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedScroll(int i, int i2, int i4, int i5, int[] iArr, int i6) {
        return getScrollingChildHelper().dispatchNestedScroll(i, i2, i4, i5, iArr, i6);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002a  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ViewHolder findViewHolderForPosition(int i, boolean z) {
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        ViewHolder viewHolder = null;
        for (int i2 = 0; i2 < unfilteredChildCount; i2++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i2));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved()) {
                if (z) {
                    if (childViewHolderInt.mPosition != i) {
                        continue;
                    } else {
                        if (!this.mChildHelper.isHidden(childViewHolderInt.itemView)) {
                            return childViewHolderInt;
                        }
                        viewHolder = childViewHolderInt;
                    }
                } else if (childViewHolderInt.getLayoutPosition() != i) {
                    continue;
                }
            }
        }
        return viewHolder;
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean hasNestedScrollingParent(int i) {
        return getScrollingChildHelper().hasNestedScrollingParent(i);
    }

    public void onExitLayoutOrScroll(boolean z) {
        int i = this.mLayoutOrScrollCounter - 1;
        this.mLayoutOrScrollCounter = i;
        if (i < 1) {
            if (sDebugAssertionsEnabled && i < 0) {
                throw new IllegalStateException(AbstractC2821a.m2219j(this, new StringBuilder("layout or scroll counter cannot go below zero.Some calls are not matching")));
            }
            this.mLayoutOrScrollCounter = 0;
            if (z) {
                dispatchContentChangedIfNecessary();
                dispatchPendingImportantForAccessibilityChanges();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.mLayout.requestChildRectangleOnScreen(this, view, rect, z);
    }

    @Override // androidx.core.widget.SeslScrollable
    public void seslSetFadingEdgeEnabled(boolean z) {
        applyFadingEdge(z, new RunnableC0116a(4, this, z));
    }

    public void seslSetGoToTopEnabled(boolean z, boolean z2) {
        ensureGoToTopController(z);
        SeslGoToTopController seslGoToTopController = this.mGoToTopController;
        if (seslGoToTopController != null) {
            seslGoToTopController.setEnabled(z, z2);
            if (z) {
                this.mGoToTopController.setOnGoToTopClickListener(new SeslGoToTopController.OnGoToTopClickListener() { // from class: androidx.recyclerview.widget.a
                    @Override // androidx.core.widget.SeslGoToTopController.OnGoToTopClickListener
                    public final boolean onGoToTopClick() {
                        return this.f1656a.lambda$seslSetGoToTopEnabled$4();
                    }
                });
            } else {
                this.mGoToTopController.setOnGoToTopClickListener(null);
            }
        }
    }

    public void smoothScrollBy(@Px int i, @Px int i2, @Nullable Interpolator interpolator) {
        smoothScrollBy(i, i2, interpolator, Integer.MIN_VALUE);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean startNestedScroll(int i, int i2) {
        return getScrollingChildHelper().startNestedScroll(i, i2);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public void stopNestedScroll(int i) {
        getScrollingChildHelper().stopNestedScroll(i);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.recyclerview.widget.RecyclerView.SavedState.1
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        };
        Parcelable mLayoutState;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.mLayoutState = parcel.readParcelable(classLoader == null ? LayoutManager.class.getClassLoader() : classLoader);
        }

        public void copyFrom(SavedState savedState) {
            this.mLayoutState = savedState.mLayoutState;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.mLayoutState, 0);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    @SuppressLint({"ResourceType"})
    public RecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mObserver = new RecyclerViewDataObserver();
        this.mRecycler = new Recycler();
        this.mViewInfoStore = new ViewInfoStore();
        this.mUpdateChildViewsRunnable = new Runnable() { // from class: androidx.recyclerview.widget.RecyclerView.1
            @Override // java.lang.Runnable
            public void run() {
                RecyclerView recyclerView = RecyclerView.this;
                if (!recyclerView.mFirstLayoutComplete || recyclerView.isLayoutRequested()) {
                    return;
                }
                RecyclerView recyclerView2 = RecyclerView.this;
                if (!recyclerView2.mIsAttached) {
                    recyclerView2.requestLayout();
                } else if (recyclerView2.mLayoutSuppressed) {
                    recyclerView2.mLayoutWasDefered = true;
                } else {
                    recyclerView2.consumePendingUpdateOperations();
                }
            }
        };
        this.mTempRect = new Rect();
        this.mTempRect2 = new Rect();
        this.mTempRectF = new RectF();
        this.mRecyclerListeners = new ArrayList();
        this.mItemDecorations = new ArrayList<>();
        this.mOnItemTouchListeners = new ArrayList<>();
        this.mInterceptRequestLayoutDepth = 0;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        this.mLayoutOrScrollCounter = 0;
        this.mDispatchScrollCounter = 0;
        this.mEdgeEffectFactory = sDefaultEdgeEffectFactory;
        this.mItemAnimator = new DefaultItemAnimator();
        this.mScrollState = 0;
        this.mScrollPointerId = -1;
        this.mScaledHorizontalScrollFactor = Float.MIN_VALUE;
        this.mScaledVerticalScrollFactor = Float.MIN_VALUE;
        this.mPreserveFocusAfterLayout = true;
        this.mViewFlinger = new ViewFlinger();
        this.mPrefetchRegistry = ALLOW_THREAD_GAP_WORK ? new GapWorker.LayoutPrefetchRegistryImpl() : null;
        this.mState = new State();
        this.mItemsAddedOrRemoved = false;
        this.mItemsChanged = false;
        this.mItemAnimatorListener = new ItemAnimatorRestoreListener();
        this.mPostedAnimatorRunner = false;
        this.mMinMaxLayoutPositions = new int[2];
        this.mScrollOffset = new int[2];
        this.mNestedOffsets = new int[2];
        this.mWindowOffsets = new int[2];
        this.mEdgeEffectByDragging = false;
        this.ON_ABSORB_VELOCITY = 10000;
        this.mIndexTipEnabled = false;
        this.mIsActionScrollFromMouse = false;
        this.mRecyclerViewOffsets = new int[2];
        this.mMotionEventUpPendingFlag = 33554432;
        this.mIsSkipMoveEvent = false;
        this.mFrameLatency = FRAME_LATENCY_LIMIT;
        this.mIsNeedCheckLatency = true;
        this.mLastItemAddRemoveAnim = null;
        this.mIsSetOnlyAddAnim = false;
        this.mIsSetOnlyRemoveAnim = false;
        this.mLastItemAnimTop = -1;
        this.mPreventFirstGlow = false;
        this.mIsEdgeEffectEnabled = true;
        this.mSeslIsNested = false;
        this.mAnimListener = new Animator.AnimatorListener() { // from class: androidx.recyclerview.widget.RecyclerView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                RecyclerView.this.mLastItemAddRemoveAnim = null;
                RecyclerView.this.mIsSetOnlyAddAnim = false;
                RecyclerView.this.mIsSetOnlyRemoveAnim = false;
                ItemAnimator itemAnimator = RecyclerView.this.getItemAnimator();
                if (itemAnimator instanceof DefaultItemAnimator) {
                    ((DefaultItemAnimator) itemAnimator).clearPendingAnimFlag();
                }
                RecyclerView.this.invalidate();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        };
        this.mReusableIntPair = new int[2];
        this.mTouchSlop2 = 0;
        this.mPagingTouchSlop = 0;
        this.mUsePagingTouchSlopForStylus = false;
        this.mOnGoToTopClickListener = null;
        this.mSeslOverlayFeatureHeight = 0;
        this.mGoToTopController = null;
        this.mGoToTopHost = new SeslGoToTopController.Host() { // from class: androidx.recyclerview.widget.RecyclerView.3
            @Override // androidx.core.widget.SeslGoToTopController.Host
            public boolean canScrollDown() {
                return RecyclerView.this.canScrollDown();
            }

            @Override // androidx.core.widget.SeslGoToTopController.Host
            public boolean canScrollUp() {
                return RecyclerView.this.canScrollUp();
            }

            @Override // androidx.core.widget.SeslGoToTopController.Host
            @NonNull
            public Context getContext() {
                return RecyclerView.this.mContext;
            }

            @Override // androidx.core.widget.SeslGoToTopController.Host
            public int getHeight() {
                return RecyclerView.this.getHeight();
            }

            @Override // androidx.core.widget.SeslGoToTopController.Host
            public void getLocationInWindow(@NonNull int[] iArr) {
                RecyclerView.this.getLocationInWindow(iArr);
            }

            @Override // androidx.core.widget.SeslGoToTopController.Host
            @NonNull
            public ViewGroupOverlay getOverlay() {
                return RecyclerView.this.getOverlay();
            }

            @Override // androidx.core.widget.SeslGoToTopController.Host
            public int getPaddingBottom() {
                return RecyclerView.this.getPaddingBottom();
            }

            @Override // androidx.core.widget.SeslGoToTopController.Host
            public int getPaddingLeft() {
                return RecyclerView.this.getPaddingLeft();
            }

            @Override // androidx.core.widget.SeslGoToTopController.Host
            public int getPaddingRight() {
                return RecyclerView.this.getPaddingRight();
            }

            @Override // androidx.core.widget.SeslGoToTopController.Host
            public int getScrollY() {
                return RecyclerView.this.getScrollY();
            }

            @Override // androidx.core.widget.SeslGoToTopController.Host
            public int getWidth() {
                return RecyclerView.this.getWidth();
            }

            @Override // androidx.core.widget.SeslGoToTopController.Host
            public void invalidateHost() {
                RecyclerView.this.invalidate();
            }

            @Override // androidx.core.widget.SeslGoToTopController.Host
            public boolean isFastScrollerEnabled() {
                return RecyclerView.this.seslIsFastScrollerEnabled();
            }

            @Override // androidx.core.widget.SeslGoToTopController.Host
            public void playSoundEffect(int i2) {
                RecyclerView.this.playSoundEffect(i2);
            }

            @Override // androidx.core.widget.SeslGoToTopController.Host
            public void post(@NonNull Runnable runnable) {
                RecyclerView.this.post(runnable);
            }

            @Override // androidx.core.widget.SeslGoToTopController.Host
            public void postDelayed(@NonNull Runnable runnable, long j) {
                RecyclerView.this.postDelayed(runnable, j);
            }

            @Override // androidx.core.widget.SeslGoToTopController.Host
            public void removeCallbacks(@NonNull Runnable runnable) {
                RecyclerView.this.removeCallbacks(runnable);
            }

            @Override // androidx.core.widget.SeslGoToTopController.Host
            public void showTopEdgeEffect() {
                RecyclerView.this.ensureTopGlow();
                RecyclerView.this.mTopGlow.onAbsorb(10000);
                RecyclerView.this.invalidate();
            }

            @Override // androidx.core.widget.SeslGoToTopController.Host
            public void smoothScrollToTop() {
                RecyclerView.this.smoothScrollToPositionJumpIfNeeded(0);
            }
        };
        this.mIsPenSelectionEnabled = true;
        this.mIsPenPressed = false;
        this.mIsFirstPenMoveEvent = true;
        this.mIsNeedPenSelection = false;
        this.mPenDragSelectedViewPosition = -1;
        this.mIsPenDragBlockEnabled = true;
        this.mPenDragStartX = 0;
        this.mPenDragStartY = 0;
        this.mPenDragEndX = 0;
        this.mPenDragEndY = 0;
        this.mPenDragBlockLeft = 0;
        this.mPenDragBlockTop = 0;
        this.mPenDragBlockRight = 0;
        this.mPenDragBlockBottom = 0;
        this.mPenTrackedChild = null;
        this.mPenTrackedChildPosition = -1;
        this.mPenDistanceFromTrackedChildTop = 0;
        this.mPenDragBlockRect = new Rect();
        this.mInitialTopOffsetOfScreen = 0;
        this.mRemainNestedScrollRange = 0;
        this.mNestedScrollRange = 0;
        this.mHasNestedScrollRange = false;
        this.mIsCtrlKeyPressed = false;
        this.mIsLongPressMultiSelection = false;
        this.mIsFirstMultiSelectionMove = true;
        this.mIsCtrlMultiSelection = false;
        this.mIsPenButtonPressed = false;
        this.mDrawHorizontalPadding = false;
        this.mDrawRect = false;
        this.mDrawLastRoundedCorner = true;
        this.mDrawReverse = false;
        this.mBlackTop = -1;
        this.mLastBlackTop = -1;
        this.mAnimatedBlackTop = -1;
        this.mRectPaint = new Paint();
        this.mScrollbarTopPadding = 0;
        this.mScrollbarBottomPadding = 0;
        this.mNaviBarTop = -1;
        this.mScrollInfoProvider = new SeslFadingEdgeHelper.ScrollInfoProvider() { // from class: androidx.recyclerview.widget.RecyclerView.4
            @Override // androidx.core.util.SeslFadingEdgeHelper.ScrollInfoProvider
            public int computeVerticalScrollExtent() {
                return RecyclerView.this.computeVerticalScrollExtent();
            }

            @Override // androidx.core.util.SeslFadingEdgeHelper.ScrollInfoProvider
            public int computeVerticalScrollOffset() {
                return RecyclerView.this.computeVerticalScrollOffset();
            }

            @Override // androidx.core.util.SeslFadingEdgeHelper.ScrollInfoProvider
            public int computeVerticalScrollRange() {
                return RecyclerView.this.computeVerticalScrollRange();
            }

            @Override // androidx.core.util.SeslFadingEdgeHelper.ScrollInfoProvider
            public int getLastItemHeightIfVisible() {
                int iFindLastVisibleItemPosition;
                LayoutManager layoutManager;
                View viewFindViewByPosition;
                if (RecyclerView.this.getAdapter() == null || (iFindLastVisibleItemPosition = RecyclerView.this.findLastVisibleItemPosition()) != r0.getItemCount() - 1 || (layoutManager = RecyclerView.this.getLayoutManager()) == null || (viewFindViewByPosition = layoutManager.findViewByPosition(iFindLastVisibleItemPosition)) == null) {
                    return -1;
                }
                return viewFindViewByPosition.getHeight();
            }

            @Override // androidx.core.util.SeslFadingEdgeHelper.ScrollInfoProvider
            public boolean shouldNormalizeFadingEdge() {
                LayoutManager layoutManager = RecyclerView.this.mLayout;
                if (layoutManager == null) {
                    return false;
                }
                return (layoutManager instanceof LinearLayoutManager) || (layoutManager instanceof StaggeredGridLayoutManager);
            }
        };
        this.mScrollBarTopOffset = 0;
        this.mScrollBarBottomOffset = 0;
        this.mScrollBarOffsetListener = null;
        this.mIsPenHovered = false;
        this.mRootViewCheckForDialog = null;
        this.mIsPenSelectPointerSetted = false;
        this.mIsNeedPenSelectIconSet = false;
        this.mOldTextViewHoverState = false;
        this.mNewTextViewHoverState = false;
        this.mHoverScrollSpeed = 0;
        this.mPointerIconRotation = 0.0f;
        this.mHoverScrollArrows = new int[]{SeslPointerIconReflector.getField_SEM_TYPE_STYLUS_SCROLL_UP(), SeslPointerIconReflector.getField_SEM_TYPE_STYLUS_SCROLL_RIGHT(), SeslPointerIconReflector.getField_SEM_TYPE_STYLUS_SCROLL_DOWN(), SeslPointerIconReflector.getField_SEM_TYPE_STYLUS_SCROLL_LEFT()};
        this.mHoverRecognitionDurationTime = 0L;
        this.mHoverRecognitionCurrentTime = 0L;
        this.mHoverRecognitionStartTime = 0L;
        this.mHoverScrollTimeInterval = 300L;
        this.mPenDragScrollTimeInterval = 500L;
        this.mHoverScrollStartTime = 0L;
        this.mHoverScrollDirection = -1;
        this.mIsHoverOverscrolled = false;
        this.mIsSendHoverScrollState = false;
        this.mHoverScrollStateForListener = 0;
        this.mIsEnabledPaddingInHoverScroll = false;
        this.mHoverAreaEnter = false;
        this.mSelectorRect = new Rect();
        this.mHoverScrollEnable = true;
        this.mHoverScrollStateChanged = false;
        this.mNeedsHoverScroll = false;
        this.mHoverTopAreaHeight = 0;
        this.mHoverBottomAreaHeight = 0;
        this.mHoverDefaultTopAreaHeight = 0;
        this.mHoverDefaultBottomAreaHeight = 0;
        this.mListPadding = new Rect();
        this.mChildBound = new Rect();
        this.mExtraPaddingInTopHoverArea = 0;
        this.mExtraPaddingInBottomHoverArea = 0;
        this.mIsCloseChildSetted = false;
        this.mOldHoverScrollDirection = -1;
        this.mCloseChildByTop = null;
        this.mCloseChildPositionByTop = -1;
        this.mDistanceFromCloseChildTop = 0;
        this.mCloseChildByBottom = null;
        this.mCloseChildPositionByBottom = -1;
        this.mDistanceFromCloseChildBottom = 0;
        this.mItemBackgroundHolder = new ItemBackgroundHolder();
        this.mHoverHandler = new Handler(Looper.getMainLooper()) { // from class: androidx.recyclerview.widget.RecyclerView.5
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i2;
                if (message.what != 0) {
                    return;
                }
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.mAdapter == null) {
                    Log.e(RecyclerView.TAG, "No adapter attached; skipping MSG_HOVERSCROLL_MOVE");
                    return;
                }
                recyclerView.mHoverRecognitionCurrentTime = System.currentTimeMillis();
                RecyclerView recyclerView2 = RecyclerView.this;
                recyclerView2.mHoverRecognitionDurationTime = (recyclerView2.mHoverRecognitionCurrentTime - RecyclerView.this.mHoverRecognitionStartTime) / 1000;
                if (!RecyclerView.this.mIsPenHovered || RecyclerView.this.mHoverRecognitionCurrentTime - RecyclerView.this.mHoverScrollStartTime >= RecyclerView.this.mHoverScrollTimeInterval) {
                    if (!RecyclerView.this.mIsPenPressed || RecyclerView.this.mHoverRecognitionCurrentTime - RecyclerView.this.mHoverScrollStartTime >= RecyclerView.this.mPenDragScrollTimeInterval) {
                        if (RecyclerView.this.mIsPenHovered && !RecyclerView.this.mIsSendHoverScrollState) {
                            if (RecyclerView.this.mScrollListener != null) {
                                RecyclerView.this.mHoverScrollStateForListener = 1;
                                RecyclerView.this.mScrollListener.onScrollStateChanged(RecyclerView.this, 1);
                            }
                            RecyclerView.this.mIsSendHoverScrollState = true;
                        }
                        boolean zCanScrollVertically = RecyclerView.this.mLayout.canScrollVertically();
                        boolean zCanScrollHorizontally = RecyclerView.this.mLayout.canScrollHorizontally();
                        boolean z = RecyclerView.this.mLayout.getLayoutDirection() == 1;
                        boolean zCanScrollDown = RecyclerView.this.mRemainNestedScrollRange > 0 ? true : RecyclerView.this.canScrollDown();
                        boolean zCanScrollUp = RecyclerView.this.canScrollUp();
                        RecyclerView.this.mHoverScrollSpeed = (int) (TypedValue.applyDimension(1, RecyclerView.HOVERSCROLL_SPEED, RecyclerView.this.mContext.getResources().getDisplayMetrics()) + 0.5f);
                        if (RecyclerView.this.mHoverRecognitionDurationTime > 2 && RecyclerView.this.mHoverRecognitionDurationTime < 4) {
                            RecyclerView.this.mHoverScrollSpeed += (int) (((double) RecyclerView.this.mHoverScrollSpeed) * 0.1d);
                        } else if (RecyclerView.this.mHoverRecognitionDurationTime >= 4 && RecyclerView.this.mHoverRecognitionDurationTime < 5) {
                            RecyclerView.this.mHoverScrollSpeed += (int) (((double) RecyclerView.this.mHoverScrollSpeed) * 0.2d);
                        } else if (RecyclerView.this.mHoverRecognitionDurationTime >= 5) {
                            RecyclerView.this.mHoverScrollSpeed += (int) (((double) RecyclerView.this.mHoverScrollSpeed) * 0.3d);
                        }
                        if (RecyclerView.this.mHoverScrollDirection == 2) {
                            i2 = (zCanScrollHorizontally && z) ? RecyclerView.this.mHoverScrollSpeed : RecyclerView.this.mHoverScrollSpeed * (-1);
                            if ((RecyclerView.this.mPenTrackedChild == null && RecyclerView.this.mCloseChildByBottom != null) || (RecyclerView.this.mOldHoverScrollDirection != RecyclerView.this.mHoverScrollDirection && RecyclerView.this.mIsCloseChildSetted)) {
                                RecyclerView recyclerView3 = RecyclerView.this;
                                recyclerView3.mPenTrackedChild = recyclerView3.mCloseChildByBottom;
                                RecyclerView recyclerView4 = RecyclerView.this;
                                recyclerView4.mPenDistanceFromTrackedChildTop = recyclerView4.mDistanceFromCloseChildBottom;
                                RecyclerView recyclerView5 = RecyclerView.this;
                                recyclerView5.mPenTrackedChildPosition = recyclerView5.mCloseChildPositionByBottom;
                                RecyclerView recyclerView6 = RecyclerView.this;
                                recyclerView6.mOldHoverScrollDirection = recyclerView6.mHoverScrollDirection;
                                RecyclerView.this.mIsCloseChildSetted = true;
                            }
                        } else {
                            i2 = (zCanScrollHorizontally && z) ? RecyclerView.this.mHoverScrollSpeed * (-1) : RecyclerView.this.mHoverScrollSpeed;
                            if ((RecyclerView.this.mPenTrackedChild == null && RecyclerView.this.mCloseChildByTop != null) || (RecyclerView.this.mOldHoverScrollDirection != RecyclerView.this.mHoverScrollDirection && RecyclerView.this.mIsCloseChildSetted)) {
                                RecyclerView recyclerView7 = RecyclerView.this;
                                recyclerView7.mPenTrackedChild = recyclerView7.mCloseChildByTop;
                                RecyclerView recyclerView8 = RecyclerView.this;
                                recyclerView8.mPenDistanceFromTrackedChildTop = recyclerView8.mDistanceFromCloseChildTop;
                                RecyclerView recyclerView9 = RecyclerView.this;
                                recyclerView9.mPenTrackedChildPosition = recyclerView9.mCloseChildPositionByTop;
                                RecyclerView recyclerView10 = RecyclerView.this;
                                recyclerView10.mOldHoverScrollDirection = recyclerView10.mHoverScrollDirection;
                                RecyclerView.this.mIsCloseChildSetted = true;
                            }
                        }
                        RecyclerView recyclerView11 = RecyclerView.this;
                        if (recyclerView11.getChildAt(recyclerView11.getChildCount() - 1) == null) {
                            return;
                        }
                        if ((i2 < 0 && zCanScrollUp) || (i2 > 0 && zCanScrollDown)) {
                            RecyclerView.this.startNestedScroll(zCanScrollHorizontally ? 1 : 2, 1);
                            if (RecyclerView.this.dispatchNestedPreScroll(zCanScrollHorizontally ? z ? -i2 : i2 : 0, zCanScrollVertically ? i2 : 0, null, null, 1)) {
                                RecyclerView.this.adjustNestedScrollRangeBy(i2);
                            } else {
                                RecyclerView recyclerView12 = RecyclerView.this;
                                int i4 = zCanScrollHorizontally ? z ? -i2 : i2 : 0;
                                if (!zCanScrollVertically) {
                                    i2 = 0;
                                }
                                recyclerView12.scrollByInternal(i4, i2, null, 0);
                                RecyclerView.this.setScrollState(1);
                                if (RecyclerView.this.mIsLongPressMultiSelection) {
                                    RecyclerView recyclerView13 = RecyclerView.this;
                                    recyclerView13.updateLongPressMultiSelection(recyclerView13.mPenDragEndX, RecyclerView.this.mPenDragEndY, false);
                                }
                            }
                            RecyclerView.this.mHoverHandler.sendEmptyMessageDelayed(0, 0L);
                            return;
                        }
                        int overScrollMode = RecyclerView.this.getOverScrollMode();
                        boolean z2 = overScrollMode == 0 || (overScrollMode == 1 && !RecyclerView.this.contentFits());
                        if (z2 && !RecyclerView.this.mIsHoverOverscrolled) {
                            if (zCanScrollHorizontally) {
                                RecyclerView.this.ensureLeftGlow();
                                RecyclerView.this.ensureRightGlow();
                            } else {
                                RecyclerView.this.ensureTopGlow();
                                RecyclerView.this.ensureBottomGlow();
                            }
                            if (RecyclerView.this.mHoverScrollDirection == 2) {
                                if (zCanScrollHorizontally) {
                                    RecyclerView.this.mLeftGlow.onAbsorb(10000);
                                    if (!RecyclerView.this.mRightGlow.isFinished()) {
                                        RecyclerView.this.mRightGlow.onRelease();
                                    }
                                } else {
                                    RecyclerView.this.mTopGlow.onAbsorb(10000);
                                    if (!RecyclerView.this.mBottomGlow.isFinished()) {
                                        RecyclerView.this.mBottomGlow.onRelease();
                                    }
                                }
                            } else if (RecyclerView.this.mHoverScrollDirection == 1) {
                                if (zCanScrollHorizontally) {
                                    RecyclerView.this.mRightGlow.onAbsorb(10000);
                                    if (!RecyclerView.this.mLeftGlow.isFinished()) {
                                        RecyclerView.this.mLeftGlow.onRelease();
                                    }
                                } else {
                                    RecyclerView.this.mBottomGlow.onAbsorb(10000);
                                    RecyclerView.this.showGoToTop();
                                    if (!RecyclerView.this.mTopGlow.isFinished()) {
                                        RecyclerView.this.mTopGlow.onRelease();
                                    }
                                }
                            }
                            RecyclerView.this.invalidate();
                            RecyclerView.this.mIsHoverOverscrolled = true;
                        }
                        if (RecyclerView.this.mScrollState == 1) {
                            RecyclerView.this.setScrollState(0);
                        }
                        if (z2 || RecyclerView.this.mIsHoverOverscrolled) {
                            return;
                        }
                        RecyclerView.this.mIsHoverOverscrolled = true;
                    }
                }
            }
        };
        this.mPendingAccessibilityImportanceChange = new ArrayList();
        this.mItemAnimatorRunner = new Runnable() { // from class: androidx.recyclerview.widget.RecyclerView.6
            @Override // java.lang.Runnable
            public void run() {
                ItemAnimator itemAnimator = RecyclerView.this.mItemAnimator;
                if (itemAnimator != null) {
                    itemAnimator.runPendingAnimations();
                }
                RecyclerView.this.mPostedAnimatorRunner = false;
            }
        };
        this.mLastAutoMeasureNonExactMeasuredWidth = 0;
        this.mLastAutoMeasureNonExactMeasuredHeight = 0;
        this.mViewInfoProcessCallback = new ViewInfoStore.ProcessCallback() { // from class: androidx.recyclerview.widget.RecyclerView.8
            @Override // androidx.recyclerview.widget.ViewInfoStore.ProcessCallback
            public void processAppeared(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
                RecyclerView.this.animateAppearance(viewHolder, itemHolderInfo, itemHolderInfo2);
            }

            @Override // androidx.recyclerview.widget.ViewInfoStore.ProcessCallback
            public void processDisappeared(ViewHolder viewHolder, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo, @Nullable ItemAnimator.ItemHolderInfo itemHolderInfo2) {
                RecyclerView.this.mRecycler.unscrapView(viewHolder);
                RecyclerView.this.animateDisappearance(viewHolder, itemHolderInfo, itemHolderInfo2);
            }

            @Override // androidx.recyclerview.widget.ViewInfoStore.ProcessCallback
            public void processPersistent(ViewHolder viewHolder, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo2) {
                viewHolder.setIsRecyclable(false);
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.mDataSetHasChangedAfterLayout) {
                    ItemAnimator itemAnimator = recyclerView.mItemAnimator;
                    if (itemAnimator == null || !itemAnimator.animateChange(viewHolder, viewHolder, itemHolderInfo, itemHolderInfo2)) {
                        return;
                    }
                    RecyclerView.this.postAnimationRunner();
                    return;
                }
                ItemAnimator itemAnimator2 = recyclerView.mItemAnimator;
                if (itemAnimator2 == null || !itemAnimator2.animatePersistence(viewHolder, itemHolderInfo, itemHolderInfo2)) {
                    return;
                }
                RecyclerView.this.postAnimationRunner();
            }

            @Override // androidx.recyclerview.widget.ViewInfoStore.ProcessCallback
            public void unused(ViewHolder viewHolder) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.mLayout.removeAndRecycleView(viewHolder.itemView, recyclerView.mRecycler);
            }
        };
        this.mAvailableBounds = null;
        this.mSeslBottomBarHeight = 0;
        this.mDebugDrawAvailRect = false;
        this.mGoToTopEdgeEffectRunnable = new Runnable() { // from class: androidx.recyclerview.widget.RecyclerView.14
            @Override // java.lang.Runnable
            public void run() {
                RecyclerView.this.ensureTopGlow();
                RecyclerView.this.mTopGlow.onAbsorb(10000);
                RecyclerView.this.invalidate();
            }
        };
        this.mIsRecoilEnabled = true;
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        this.mContext = context;
        seslInitConfigurations(context);
        try {
            boolean zEquals = Build.TYPE.toString().toLowerCase().equals("eng");
            String stringProperties = SeslSystemPropertiesReflector.getStringProperties(KEY_DEBUG_AVAIL_RECT);
            if (zEquals && stringProperties != null && Integer.parseInt(stringProperties) == 1) {
                this.mDebugDrawAvailRect = true;
            }
        } catch (Exception e) {
            Log.w(TAG, "Can't check debug condition " + e);
        }
        boolean z = Build.VERSION.SDK_INT >= 29;
        this.mIsRecoilSupported = z;
        if (z) {
            this.mItemAnimatorHolder = new SeslRecoilAnimator.Holder(this.mContext);
        }
        this.mPhysicalCoef = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        setWillNotDraw(getOverScrollMode() == 2);
        this.mItemAnimator.setListener(this.mItemAnimatorListener);
        initAdapterManager();
        initChildrenHelper();
        initAutofill();
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C3728R.styleable.RecyclerView, i, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, C3728R.styleable.RecyclerView, attributeSet, typedArrayObtainStyledAttributes, i, 0);
        String string = typedArrayObtainStyledAttributes.getString(C3728R.styleable.RecyclerView_layoutManager);
        if (typedArrayObtainStyledAttributes.getInt(C3728R.styleable.RecyclerView_android_descendantFocusability, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.mClipToPadding = typedArrayObtainStyledAttributes.getBoolean(C3728R.styleable.RecyclerView_android_clipToPadding, true);
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(C3728R.styleable.RecyclerView_fastScrollEnabled, false);
        this.mEnableFastScroller = z2;
        if (z2) {
            initFastScroller((StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(C3728R.styleable.RecyclerView_fastScrollVerticalThumbDrawable), typedArrayObtainStyledAttributes.getDrawable(C3728R.styleable.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(C3728R.styleable.RecyclerView_fastScrollHorizontalThumbDrawable), typedArrayObtainStyledAttributes.getDrawable(C3728R.styleable.RecyclerView_fastScrollHorizontalTrackDrawable));
        }
        typedArrayObtainStyledAttributes.recycle();
        createLayoutManager(context, string, attributeSet, i, 0);
        int[] iArr = NESTED_SCROLLING_ATTRS;
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr, i, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes2, i, 0);
        boolean z3 = typedArrayObtainStyledAttributes2.getBoolean(0, true);
        typedArrayObtainStyledAttributes2.recycle();
        Resources resources = context.getResources();
        TypedValue typedValue = new TypedValue();
        this.mPenDragBlockImage = resources.getDrawable(C0419R.drawable.sesl_pen_block_selection);
        context.getTheme().resolveAttribute(C0419R.attr.roundedCornerColor, typedValue, true);
        int i2 = typedValue.resourceId;
        if (i2 > 0) {
            this.mRectColor = resources.getColor(i2);
        }
        this.mRectPaint.setColor(this.mRectColor);
        this.mRectPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mItemAnimator.setHostView(this);
        SeslSubheaderRoundedCorner seslSubheaderRoundedCorner = new SeslSubheaderRoundedCorner(getContext());
        this.mRoundedCorner = seslSubheaderRoundedCorner;
        seslSubheaderRoundedCorner.setRoundedCorners(12);
        setNestedScrollingEnabled(z3);
        PoolingContainer.setPoolingContainer(this, true);
        this.mFadingEdgeHelper = SeslFadingEdgeHelperImpl.createSeslFadingEdgeHelper(this.mContext);
    }

    @Override // androidx.core.view.NestedScrollingChild3
    public final void dispatchNestedScroll(int i, int i2, int i4, int i5, int[] iArr, int i6, @NonNull int[] iArr2) {
        getScrollingChildHelper().dispatchNestedScroll(i, i2, i4, i5, iArr, i6, iArr2);
    }

    @Override // androidx.core.widget.SeslScrollable
    public void seslSetFadingEdgeEnabled(boolean z, boolean z2) {
        applyFadingEdge(z, new RunnableC2503c(this, z, z2, 1));
    }

    public void smoothScrollBy(@Px int i, @Px int i2, @Nullable Interpolator interpolator, int i4) {
        smoothScrollBy(i, i2, interpolator, i4, false);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        final Rect mDecorInsets;
        boolean mInsetsDirty;
        boolean mPendingInvalidate;
        ViewHolder mViewHolder;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public int getAbsoluteAdapterPosition() {
            return this.mViewHolder.getAbsoluteAdapterPosition();
        }

        public int getBindingAdapterPosition() {
            return this.mViewHolder.getBindingAdapterPosition();
        }

        @Deprecated
        public int getViewAdapterPosition() {
            return this.mViewHolder.getBindingAdapterPosition();
        }

        public int getViewLayoutPosition() {
            return this.mViewHolder.getLayoutPosition();
        }

        @Deprecated
        public int getViewPosition() {
            return this.mViewHolder.getPosition();
        }

        public boolean isItemChanged() {
            return this.mViewHolder.isUpdated();
        }

        public boolean isItemRemoved() {
            return this.mViewHolder.isRemoved();
        }

        public boolean isViewInvalid() {
            return this.mViewHolder.isInvalid();
        }

        public boolean viewNeedsUpdate() {
            return this.mViewHolder.needsUpdate();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.LayoutParams) layoutParams);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2, int i4) {
        if (this.mGoToTopController != null && canScrollDown()) {
            this.mGoToTopController.invalidate();
        }
        return getScrollingChildHelper().dispatchNestedPreScroll(i, i2, iArr, iArr2, i4);
    }

    @Override // androidx.core.widget.SeslScrollable
    public void seslSetFadingEdgeEnabled(boolean z, boolean z2, boolean z3) {
        applyFadingEdge(z, new RunnableC2504d(this, z, z2, z3, 1));
    }

    public void smoothScrollBy(@Px int i, @Px int i2, @Nullable Interpolator interpolator, int i4, boolean z) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.mLayoutSuppressed) {
            return;
        }
        if (!layoutManager.canScrollHorizontally()) {
            i = 0;
        }
        if (!this.mLayout.canScrollVertically()) {
            i2 = 0;
        }
        if (i == 0 && i2 == 0) {
            return;
        }
        if (i4 != Integer.MIN_VALUE && i4 <= 0) {
            scrollBy(i, i2);
            return;
        }
        if (z) {
            int i5 = i != 0 ? 1 : 0;
            if (i2 != 0) {
                i5 |= 2;
            }
            startNestedScroll(i5, 1);
        }
        this.mViewFlinger.smoothScrollBy(i, i2, i4, interpolator);
        showGoToTop();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View findClickableChildUnder(View view, float f, float f4) {
        View view2;
        int scrollY;
        if (view.isClickable()) {
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            view.getGlobalVisibleRect(rect);
            getGlobalVisibleRect(rect2);
            NestedScrollingChildHelper nestedScrollingChildHelper = this.mScrollingChildHelper;
            if (nestedScrollingChildHelper != null && (nestedScrollingChildHelper.getNestedScrollingParent(0) instanceof NestedScrollView)) {
                NestedScrollView nestedScrollView = (NestedScrollView) this.mScrollingChildHelper.getNestedScrollingParent(0);
                if (nestedScrollView.getScrollY() > getTopUnderNestedScrollView(this)) {
                    scrollY = nestedScrollView.getScrollY() - getTopUnderNestedScrollView(this);
                }
                if (!rect.contains(((int) f) + rect2.left, (((int) f4) + rect2.top) - scrollY)) {
                }
            } else {
                scrollY = 0;
                view2 = !rect.contains(((int) f) + rect2.left, (((int) f4) + rect2.top) - scrollY) ? view : null;
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View viewFindClickableChildUnder = findClickableChildUnder(viewGroup.getChildAt(i), f, f4);
                if (viewFindClickableChildUnder != null) {
                    return viewFindClickableChildUnder;
                }
            }
        }
        return view2;
    }

    public void addItemDecoration(@NonNull ItemDecoration itemDecoration) {
        addItemDecoration(itemDecoration, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            return layoutManager.generateLayoutParams(layoutParams);
        }
        throw new IllegalStateException(AbstractC2821a.m2219j(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }

    public void seslSetIndexTipEnabled(boolean z, int i) {
        seslSetIndexTipEnabled(z);
        this.mIndexTip.setTopMargin(i);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SimpleOnItemTouchListener implements OnItemTouchListener {
        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean z) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        }
    }

    public void onChildAttachedToWindow(@NonNull View view) {
    }

    public void onChildDetachedFromWindow(@NonNull View view) {
    }

    public void onScrollStateChanged(int i) {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class OnScrollListener {
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
        }

        public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
        }
    }

    public void onScrolled(@Px int i, @Px int i2) {
    }
}
