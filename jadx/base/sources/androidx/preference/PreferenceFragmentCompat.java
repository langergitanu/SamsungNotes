package androidx.preference;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.XmlRes;
import androidx.appcompat.C0419R;
import androidx.appcompat.util.SeslRoundedCorner;
import androidx.appcompat.util.SeslSubheaderRoundedCorner;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.core.graphics.Insets;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.preference.DialogPreference;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
public abstract class PreferenceFragmentCompat extends Fragment implements PreferenceManager.OnPreferenceTreeClickListener, PreferenceManager.OnDisplayPreferenceDialogListener, PreferenceManager.OnNavigateToScreenListener, DialogPreference.TargetFragment {
    public static final String ARG_PREFERENCE_ROOT = "androidx.preference.PreferenceFragmentCompat.PREFERENCE_ROOT";
    private static final String DIALOG_FRAGMENT_TAG = "androidx.preference.PreferenceFragment.DIALOG";
    private static final float FONT_SCALE_LARGE = 1.3f;
    private static final float FONT_SCALE_MEDIUM = 1.1f;
    private static final int MSG_BIND_PREFERENCES = 1;
    private static final String PREFERENCES_TAG = "android:preferences";

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    static final int SWITCH_PREFERENCE_LAYOUT = 2;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    static final int SWITCH_PREFERENCE_LAYOUT_LARGE = 1;
    private static final String TAG = "SeslPreferenceFragmentC";
    private boolean mHavePrefs;
    private boolean mInitDone;
    private int mIsLargeLayout;
    private boolean mIsReducedMargin;
    RecyclerView mList;
    private SeslRoundedCorner mListRoundedCorner;
    private ViewTreeObserver.OnPreDrawListener mOnPreDrawListener;
    private PreferenceManager mPreferenceManager;
    private SeslRoundedCorner mRoundedCorner;
    private int mScreenWidthDp;
    private Runnable mSelectPreferenceRunnable;

    @ColorInt
    private int mSubheaderColor;
    private SeslSubheaderRoundedCorner mSubheaderRoundedCorner;
    private final DividerDecoration mDividerDecoration = new DividerDecoration();
    private int mLayoutResId = C3711R.layout.preference_list_fragment;
    private boolean mIsRoundedCorner = true;
    private int mLeft = -1;
    private int mTop = -1;
    private int mRight = -1;
    private int mBottom = -1;
    private final Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: androidx.preference.PreferenceFragmentCompat.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            PreferenceFragmentCompat.this.bindPreferences();
        }
    };
    private final Runnable mRequestFocus = new Runnable() { // from class: androidx.preference.PreferenceFragmentCompat.2
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = PreferenceFragmentCompat.this.mList;
            recyclerView.focusableViewAvailable(recyclerView);
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class DividerDecoration extends RecyclerView.ItemDecoration {
        private boolean mAllowDividerAfterLastItem = true;
        private Drawable mDivider;
        private int mDividerHeight;

        public DividerDecoration() {
        }

        private boolean shouldDrawDividerBelow(View view, RecyclerView recyclerView) {
            RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(view);
            if (!(childViewHolder instanceof PreferenceViewHolder) || !((PreferenceViewHolder) childViewHolder).isDividerAllowedBelow()) {
                return false;
            }
            boolean z = this.mAllowDividerAfterLastItem;
            int iIndexOfChild = recyclerView.indexOfChild(view);
            if (iIndexOfChild >= recyclerView.getChildCount() - 1) {
                return z;
            }
            RecyclerView.ViewHolder childViewHolder2 = recyclerView.getChildViewHolder(recyclerView.getChildAt(iIndexOfChild + 1));
            return (childViewHolder2 instanceof PreferenceViewHolder) && ((PreferenceViewHolder) childViewHolder2).isDividerAllowedAbove();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void seslOnDispatchDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
            PreferenceViewHolder preferenceViewHolder;
            int iSeslGetDividerLeftOffset;
            super.seslOnDispatchDraw(canvas, recyclerView, state);
            int childCount = recyclerView.getChildCount();
            int paddingLeft = recyclerView.getPaddingLeft() + recyclerView.getLeft();
            int right = recyclerView.getRight() - recyclerView.getPaddingRight();
            for (int i = 0; i < childCount; i++) {
                View childAt = recyclerView.getChildAt(i);
                RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(childAt);
                if (childViewHolder instanceof PreferenceViewHolder) {
                    preferenceViewHolder = (PreferenceViewHolder) childViewHolder;
                    iSeslGetDividerLeftOffset = preferenceViewHolder.seslGetDividerLeftOffset();
                } else {
                    preferenceViewHolder = null;
                    iSeslGetDividerLeftOffset = 0;
                }
                boolean z = PreferenceFragmentCompat.this.getResources().getConfiguration().getLayoutDirection() == 1;
                int height = childAt.getHeight() + ((int) childAt.getY());
                if (this.mDivider != null && shouldDrawDividerBelow(childAt, recyclerView)) {
                    this.mDivider.setBounds((z ? 0 : iSeslGetDividerLeftOffset) + paddingLeft, height, (z ? -iSeslGetDividerLeftOffset : 0) + right, this.mDividerHeight + height);
                    this.mDivider.draw(canvas);
                }
                if (PreferenceFragmentCompat.this.mIsRoundedCorner && preferenceViewHolder != null && preferenceViewHolder.isBackgroundDrawn()) {
                    if (preferenceViewHolder.isDrawSubheaderRound()) {
                        PreferenceFragmentCompat.this.mSubheaderRoundedCorner.setRoundedCorners(preferenceViewHolder.getDrawCorners());
                        PreferenceFragmentCompat.this.mSubheaderRoundedCorner.drawRoundedCorner(childAt, canvas);
                    } else {
                        PreferenceFragmentCompat.this.mRoundedCorner.setRoundedCorners(preferenceViewHolder.getDrawCorners());
                        PreferenceFragmentCompat.this.mRoundedCorner.drawRoundedCorner(childAt, canvas);
                    }
                }
            }
            if (PreferenceFragmentCompat.this.mIsRoundedCorner) {
                PreferenceFragmentCompat.this.mListRoundedCorner.drawRoundedCorner(canvas, Insets.m1692of(PreferenceFragmentCompat.this.mLeft, PreferenceFragmentCompat.this.mTop, PreferenceFragmentCompat.this.mRight, PreferenceFragmentCompat.this.mBottom));
            }
        }

        public void setAllowDividerAfterLastItem(boolean z) {
            this.mAllowDividerAfterLastItem = z;
        }

        public void setDivider(Drawable drawable) {
            if (drawable != null) {
                this.mDividerHeight = drawable.getIntrinsicHeight();
            } else {
                this.mDividerHeight = 0;
            }
            this.mDivider = drawable;
            PreferenceFragmentCompat.this.mList.invalidateItemDecorations();
        }

        public void setDividerHeight(int i) {
            this.mDividerHeight = i;
            PreferenceFragmentCompat.this.mList.invalidateItemDecorations();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnPreferenceDisplayDialogCallback {
        boolean onPreferenceDisplayDialog(@NonNull PreferenceFragmentCompat preferenceFragmentCompat, @NonNull Preference preference);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnPreferenceStartFragmentCallback {
        boolean onPreferenceStartFragment(@NonNull PreferenceFragmentCompat preferenceFragmentCompat, @NonNull Preference preference);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnPreferenceStartScreenCallback {
        boolean onPreferenceStartScreen(@NonNull PreferenceFragmentCompat preferenceFragmentCompat, @NonNull PreferenceScreen preferenceScreen);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ScrollToPreferenceObserver extends RecyclerView.AdapterDataObserver {
        private final RecyclerView.Adapter<?> mAdapter;
        private final String mKey;
        private final RecyclerView mList;
        private final Preference mPreference;

        public ScrollToPreferenceObserver(RecyclerView.Adapter<?> adapter, RecyclerView recyclerView, Preference preference, String str) {
            this.mAdapter = adapter;
            this.mList = recyclerView;
            this.mPreference = preference;
            this.mKey = str;
        }

        private void scrollToPreference() {
            this.mAdapter.unregisterAdapterDataObserver(this);
            Preference preference = this.mPreference;
            int preferenceAdapterPosition = preference != null ? ((PreferenceGroup.PreferencePositionCallback) this.mAdapter).getPreferenceAdapterPosition(preference) : ((PreferenceGroup.PreferencePositionCallback) this.mAdapter).getPreferenceAdapterPosition(this.mKey);
            if (preferenceAdapterPosition != -1) {
                this.mList.scrollToPosition(preferenceAdapterPosition);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            scrollToPreference();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2) {
            scrollToPreference();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i, int i2) {
            scrollToPreference();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i, int i2, int i4) {
            scrollToPreference();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i, int i2) {
            scrollToPreference();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2, Object obj) {
            scrollToPreference();
        }
    }

    private void createOnPreDrawListner() {
        if (this.mList != null) {
            this.mOnPreDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: androidx.preference.PreferenceFragmentCompat.4
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    RecyclerView recyclerView = PreferenceFragmentCompat.this.mList;
                    if (recyclerView != null) {
                        RecyclerView.Adapter adapter = recyclerView.getAdapter();
                        Configuration configuration = PreferenceFragmentCompat.this.getResources().getConfiguration();
                        int i = configuration.screenWidthDp;
                        int i2 = ((i > 320 || configuration.fontScale < PreferenceFragmentCompat.FONT_SCALE_MEDIUM) && (i >= 411 || configuration.fontScale < 1.3f)) ? 2 : 1;
                        if (adapter instanceof PreferenceGroupAdapter) {
                            PreferenceGroupAdapter preferenceGroupAdapter = (PreferenceGroupAdapter) adapter;
                            if (PreferenceFragmentCompat.this.needToRefeshSwitch(preferenceGroupAdapter, i2, i)) {
                                PreferenceFragmentCompat.this.mIsLargeLayout = i2;
                                for (int i4 = 0; i4 < preferenceGroupAdapter.getItemCount(); i4++) {
                                    Preference item = preferenceGroupAdapter.getItem(i4);
                                    if (item != null && preferenceGroupAdapter.isSwitchLayout(item) && (item instanceof SwitchPreferenceCompat)) {
                                        adapter.notifyItemChanged(i4);
                                    }
                                }
                            }
                        }
                        PreferenceFragmentCompat.this.mScreenWidthDp = configuration.screenWidthDp;
                        PreferenceFragmentCompat.this.mList.getViewTreeObserver().removeOnPreDrawListener(this);
                        PreferenceFragmentCompat.this.mOnPreDrawListener = null;
                    }
                    return false;
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean needToRefeshSwitch(PreferenceGroupAdapter preferenceGroupAdapter, int i, int i2) {
        if (i == this.mIsLargeLayout) {
            if (i != 1) {
                return false;
            }
            if (this.mScreenWidthDp == i2 && preferenceGroupAdapter.getListWidth() != 0) {
                return false;
            }
        }
        return true;
    }

    private void postBindPreferences() {
        if (this.mHandler.hasMessages(1)) {
            return;
        }
        this.mHandler.obtainMessage(1).sendToTarget();
    }

    private void requirePreferenceManager() {
        if (this.mPreferenceManager == null) {
            throw new RuntimeException("This should be called after super.onCreate.");
        }
    }

    private void scrollToPreferenceInternal(@Nullable final Preference preference, @Nullable final String str) {
        Runnable runnable = new Runnable() { // from class: androidx.preference.PreferenceFragmentCompat.5
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                RecyclerView.Adapter adapter = PreferenceFragmentCompat.this.mList.getAdapter();
                if (!(adapter instanceof PreferenceGroup.PreferencePositionCallback)) {
                    if (adapter != 0) {
                        throw new IllegalStateException("Adapter must implement PreferencePositionCallback");
                    }
                    return;
                }
                Preference preference2 = preference;
                int preferenceAdapterPosition = preference2 != null ? ((PreferenceGroup.PreferencePositionCallback) adapter).getPreferenceAdapterPosition(preference2) : ((PreferenceGroup.PreferencePositionCallback) adapter).getPreferenceAdapterPosition(str);
                if (preferenceAdapterPosition != -1) {
                    PreferenceFragmentCompat.this.mList.scrollToPosition(preferenceAdapterPosition);
                } else {
                    adapter.registerAdapterDataObserver(new ScrollToPreferenceObserver(adapter, PreferenceFragmentCompat.this.mList, preference, str));
                }
            }
        };
        if (this.mList == null) {
            this.mSelectPreferenceRunnable = runnable;
        } else {
            runnable.run();
        }
    }

    private void unbindPreferences() {
        getListView().setAdapter(null);
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        if (preferenceScreen != null) {
            preferenceScreen.onDetached();
        }
        onUnbindPreferences();
    }

    private void updatePadding() {
        RecyclerView recyclerView = this.mList;
        if (recyclerView != null) {
            recyclerView.setPadding(this.mLeft, this.mTop, this.mRight, this.mBottom);
            this.mList.seslSetFillHorizontalPaddingEnabled((this.mLeft == 0 && this.mRight == 0 && this.mTop == 0 && this.mBottom == 0) ? false : true);
            this.mList.setScrollBarStyle((this.mLeft > 0 || this.mRight > 0) ? 33554432 : 0);
        }
    }

    public void addPreferencesFromResource(@XmlRes int i) {
        requirePreferenceManager();
        setPreferenceScreen(this.mPreferenceManager.inflateFromResource(requireContext(), i, getPreferenceScreen()));
    }

    public void bindPreferences() {
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        if (preferenceScreen != null) {
            getListView().setAdapter(onCreateAdapter(preferenceScreen));
            preferenceScreen.onAttached();
        }
        onBindPreferences();
    }

    @Override // androidx.preference.DialogPreference.TargetFragment
    @Nullable
    public <T extends Preference> T findPreference(@NonNull CharSequence charSequence) {
        PreferenceManager preferenceManager = this.mPreferenceManager;
        if (preferenceManager == null) {
            return null;
        }
        return (T) preferenceManager.findPreference(charSequence);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public Fragment getCallbackFragment() {
        return null;
    }

    public final RecyclerView getListView() {
        return this.mList;
    }

    public PreferenceManager getPreferenceManager() {
        return this.mPreferenceManager;
    }

    public PreferenceScreen getPreferenceScreen() {
        return this.mPreferenceManager.getPreferenceScreen();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        if (getListView() != null) {
            if (this.mOnPreDrawListener == null) {
                ViewTreeObserver viewTreeObserver = getListView().getViewTreeObserver();
                createOnPreDrawListner();
                viewTreeObserver.addOnPreDrawListener(this.mOnPreDrawListener);
            }
            RecyclerView.Adapter adapter = getListView().getAdapter();
            RecyclerView.LayoutManager layoutManager = getListView().getLayoutManager();
            boolean z = configuration.screenWidthDp <= 250;
            if (z != this.mIsReducedMargin && (adapter instanceof PreferenceGroupAdapter) && layoutManager != null) {
                this.mIsReducedMargin = z;
                if (getContext() != null) {
                    TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, C3711R.styleable.PreferenceFragmentCompat, C3711R.attr.preferenceFragmentCompatStyle, 0);
                    try {
                        setDivider(typedArrayObtainStyledAttributes.getDrawable(C3711R.styleable.PreferenceFragment_android_divider));
                        Parcelable parcelableOnSaveInstanceState = layoutManager.onSaveInstanceState();
                        getListView().setAdapter(getListView().getAdapter());
                        layoutManager.onRestoreInstanceState(parcelableOnSaveInstanceState);
                    } finally {
                        typedArrayObtainStyledAttributes.recycle();
                    }
                }
            }
        }
        super.onConfigurationChanged(configuration);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        TypedValue typedValue = new TypedValue();
        requireContext().getTheme().resolveAttribute(C3711R.attr.preferenceTheme, typedValue, true);
        Configuration configuration = getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        this.mIsLargeLayout = ((i > 320 || configuration.fontScale < FONT_SCALE_MEDIUM) && (i >= 411 || configuration.fontScale < 1.3f)) ? 2 : 1;
        this.mScreenWidthDp = i;
        this.mIsReducedMargin = i <= 250;
        int i2 = typedValue.resourceId;
        if (i2 == 0) {
            i2 = C3711R.style.PreferenceThemeOverlay;
        }
        requireContext().getTheme().applyStyle(i2, false);
        PreferenceManager preferenceManager = new PreferenceManager(requireContext());
        this.mPreferenceManager = preferenceManager;
        preferenceManager.setOnNavigateToScreenListener(this);
        onCreatePreferences(bundle, getArguments() != null ? getArguments().getString("androidx.preference.PreferenceFragmentCompat.PREFERENCE_ROOT") : null);
    }

    @NonNull
    public RecyclerView.Adapter onCreateAdapter(@NonNull PreferenceScreen preferenceScreen) {
        return new PreferenceGroupAdapter(preferenceScreen);
    }

    @NonNull
    public RecyclerView.LayoutManager onCreateLayoutManager() {
        return new LinearLayoutManager(requireContext());
    }

    public abstract void onCreatePreferences(@Nullable Bundle bundle, @Nullable String str);

    @NonNull
    public RecyclerView onCreateRecyclerView(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup, @Nullable Bundle bundle) {
        RecyclerView recyclerView;
        if (requireContext().getPackageManager().hasSystemFeature("android.hardware.type.automotive") && (recyclerView = (RecyclerView) viewGroup.findViewById(C3711R.id.recycler_view)) != null) {
            return recyclerView;
        }
        RecyclerView recyclerView2 = (RecyclerView) layoutInflater.inflate(C3711R.layout.sesl_preference_recyclerview, viewGroup, false);
        recyclerView2.setLayoutManager(onCreateLayoutManager());
        recyclerView2.setAccessibilityDelegateCompat(new PreferenceRecyclerViewAccessibilityDelegate(recyclerView2));
        return recyclerView2;
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        TypedArray typedArrayObtainStyledAttributes = requireContext().obtainStyledAttributes(null, C3711R.styleable.PreferenceFragmentCompat, C3711R.attr.preferenceFragmentCompatStyle, 0);
        this.mLayoutResId = typedArrayObtainStyledAttributes.getResourceId(C3711R.styleable.PreferenceFragmentCompat_android_layout, this.mLayoutResId);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(C3711R.styleable.PreferenceFragmentCompat_android_divider);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(C3711R.styleable.PreferenceFragmentCompat_android_dividerHeight, -1);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(C3711R.styleable.PreferenceFragmentCompat_allowDividerAfterLastItem, true);
        typedArrayObtainStyledAttributes.recycle();
        Context context = getContext();
        if (context != null) {
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(null, C0419R.styleable.View, android.R.attr.listSeparatorTextViewStyle, 0);
            Drawable drawable2 = typedArrayObtainStyledAttributes2.getDrawable(C0419R.styleable.View_android_background);
            if (drawable2 instanceof ColorDrawable) {
                this.mSubheaderColor = ((ColorDrawable) drawable2).getColor();
            }
            typedArrayObtainStyledAttributes2.recycle();
        }
        LayoutInflater layoutInflaterCloneInContext = layoutInflater.cloneInContext(context);
        View viewInflate = layoutInflaterCloneInContext.inflate(this.mLayoutResId, viewGroup, false);
        View viewFindViewById = viewInflate.findViewById(android.R.id.list_container);
        if (!(viewFindViewById instanceof ViewGroup)) {
            throw new IllegalStateException("Content has view with id attribute 'android.R.id.list_container' that is not a ViewGroup class");
        }
        ViewGroup viewGroup2 = (ViewGroup) viewFindViewById;
        RecyclerView recyclerViewOnCreateRecyclerView = onCreateRecyclerView(layoutInflaterCloneInContext, viewGroup2, bundle);
        if (recyclerViewOnCreateRecyclerView == null) {
            throw new RuntimeException("Could not create RecyclerView");
        }
        this.mList = recyclerViewOnCreateRecyclerView;
        if (this.mOnPreDrawListener == null) {
            ViewTreeObserver viewTreeObserver = recyclerViewOnCreateRecyclerView.getViewTreeObserver();
            createOnPreDrawListner();
            viewTreeObserver.addOnPreDrawListener(this.mOnPreDrawListener);
        }
        this.mList.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.preference.PreferenceFragmentCompat.3
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                view.getViewTreeObserver().removeOnPreDrawListener(PreferenceFragmentCompat.this.mOnPreDrawListener);
                view.removeOnAttachStateChangeListener(this);
                PreferenceFragmentCompat.this.mOnPreDrawListener = null;
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
            }
        });
        recyclerViewOnCreateRecyclerView.addItemDecoration(this.mDividerDecoration);
        setDivider(drawable);
        if (dimensionPixelSize != -1) {
            setDividerHeight(dimensionPixelSize);
        }
        this.mDividerDecoration.setAllowDividerAfterLastItem(z);
        this.mList.setItemAnimator(null);
        this.mRoundedCorner = new SeslRoundedCorner(context);
        this.mSubheaderRoundedCorner = new SeslSubheaderRoundedCorner(context);
        if (this.mIsRoundedCorner) {
            recyclerViewOnCreateRecyclerView.seslSetFillBottomEnabled(true);
            recyclerViewOnCreateRecyclerView.seslSetFillBottomColor(this.mSubheaderColor);
            SeslRoundedCorner seslRoundedCorner = new SeslRoundedCorner(context, true);
            this.mListRoundedCorner = seslRoundedCorner;
            seslRoundedCorner.setRoundedCorners(3);
        }
        if (this.mList.getParent() == null) {
            viewGroup2.addView(this.mList);
        }
        this.mHandler.post(this.mRequestFocus);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(C3711R.dimen.sesl_preference_padding_horizontal);
        int i = this.mLeft;
        if (i < 0) {
            i = dimensionPixelSize2;
        }
        int i2 = this.mTop;
        if (i2 < 0) {
            i2 = 0;
        }
        int i4 = this.mRight;
        if (i4 >= 0) {
            dimensionPixelSize2 = i4;
        }
        int i5 = this.mBottom;
        setPadding(i, i2, dimensionPixelSize2, i5 >= 0 ? i5 : 0);
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        RecyclerView recyclerView;
        this.mHandler.removeCallbacks(this.mRequestFocus);
        this.mHandler.removeMessages(1);
        if (this.mHavePrefs) {
            unbindPreferences();
        }
        if (this.mOnPreDrawListener != null && (recyclerView = this.mList) != null) {
            recyclerView.getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        }
        this.mList = null;
        super.onDestroyView();
    }

    @Override // androidx.preference.PreferenceManager.OnDisplayPreferenceDialogListener
    public void onDisplayPreferenceDialog(@NonNull Preference preference) {
        DialogFragment dialogFragmentNewInstance;
        boolean zOnPreferenceDisplayDialog = getCallbackFragment() instanceof OnPreferenceDisplayDialogCallback ? ((OnPreferenceDisplayDialogCallback) getCallbackFragment()).onPreferenceDisplayDialog(this, preference) : false;
        for (Fragment parentFragment = this; !zOnPreferenceDisplayDialog && parentFragment != null; parentFragment = parentFragment.getParentFragment()) {
            if (parentFragment instanceof OnPreferenceDisplayDialogCallback) {
                zOnPreferenceDisplayDialog = ((OnPreferenceDisplayDialogCallback) parentFragment).onPreferenceDisplayDialog(this, preference);
            }
        }
        if (!zOnPreferenceDisplayDialog && (getContext() instanceof OnPreferenceDisplayDialogCallback)) {
            zOnPreferenceDisplayDialog = ((OnPreferenceDisplayDialogCallback) getContext()).onPreferenceDisplayDialog(this, preference);
        }
        if (!zOnPreferenceDisplayDialog && (getActivity() instanceof OnPreferenceDisplayDialogCallback)) {
            zOnPreferenceDisplayDialog = ((OnPreferenceDisplayDialogCallback) getActivity()).onPreferenceDisplayDialog(this, preference);
        }
        if (!zOnPreferenceDisplayDialog && getParentFragmentManager().findFragmentByTag(DIALOG_FRAGMENT_TAG) == null) {
            if (preference instanceof EditTextPreference) {
                dialogFragmentNewInstance = EditTextPreferenceDialogFragmentCompat.newInstance(preference.getKey());
            } else if (preference instanceof ListPreference) {
                dialogFragmentNewInstance = ListPreferenceDialogFragmentCompat.newInstance(preference.getKey());
            } else {
                if (!(preference instanceof MultiSelectListPreference)) {
                    throw new IllegalArgumentException("Cannot display dialog for an unknown Preference type: " + preference.getClass().getSimpleName() + ". Make sure to implement onPreferenceDisplayDialog() to handle displaying a custom dialog for this Preference.");
                }
                dialogFragmentNewInstance = MultiSelectListPreferenceDialogFragmentCompat.newInstance(preference.getKey());
            }
            dialogFragmentNewInstance.setTargetFragment(this, 0);
            dialogFragmentNewInstance.show(getParentFragmentManager(), DIALOG_FRAGMENT_TAG);
        }
    }

    @Override // androidx.preference.PreferenceManager.OnNavigateToScreenListener
    public void onNavigateToScreen(@NonNull PreferenceScreen preferenceScreen) {
        boolean zOnPreferenceStartScreen = getCallbackFragment() instanceof OnPreferenceStartScreenCallback ? ((OnPreferenceStartScreenCallback) getCallbackFragment()).onPreferenceStartScreen(this, preferenceScreen) : false;
        for (Fragment parentFragment = this; !zOnPreferenceStartScreen && parentFragment != null; parentFragment = parentFragment.getParentFragment()) {
            if (parentFragment instanceof OnPreferenceStartScreenCallback) {
                zOnPreferenceStartScreen = ((OnPreferenceStartScreenCallback) parentFragment).onPreferenceStartScreen(this, preferenceScreen);
            }
        }
        if (!zOnPreferenceStartScreen && (getContext() instanceof OnPreferenceStartScreenCallback)) {
            zOnPreferenceStartScreen = ((OnPreferenceStartScreenCallback) getContext()).onPreferenceStartScreen(this, preferenceScreen);
        }
        if (zOnPreferenceStartScreen || !(getActivity() instanceof OnPreferenceStartScreenCallback)) {
            return;
        }
        ((OnPreferenceStartScreenCallback) getActivity()).onPreferenceStartScreen(this, preferenceScreen);
    }

    @Override // androidx.preference.PreferenceManager.OnPreferenceTreeClickListener
    public boolean onPreferenceTreeClick(@NonNull Preference preference) {
        if (preference.getFragment() == null) {
            return false;
        }
        boolean zOnPreferenceStartFragment = getCallbackFragment() instanceof OnPreferenceStartFragmentCallback ? ((OnPreferenceStartFragmentCallback) getCallbackFragment()).onPreferenceStartFragment(this, preference) : false;
        for (Fragment parentFragment = this; !zOnPreferenceStartFragment && parentFragment != null; parentFragment = parentFragment.getParentFragment()) {
            if (parentFragment instanceof OnPreferenceStartFragmentCallback) {
                zOnPreferenceStartFragment = ((OnPreferenceStartFragmentCallback) parentFragment).onPreferenceStartFragment(this, preference);
            }
        }
        if (!zOnPreferenceStartFragment && (getContext() instanceof OnPreferenceStartFragmentCallback)) {
            zOnPreferenceStartFragment = ((OnPreferenceStartFragmentCallback) getContext()).onPreferenceStartFragment(this, preference);
        }
        if (!zOnPreferenceStartFragment && (getActivity() instanceof OnPreferenceStartFragmentCallback)) {
            zOnPreferenceStartFragment = ((OnPreferenceStartFragmentCallback) getActivity()).onPreferenceStartFragment(this, preference);
        }
        if (zOnPreferenceStartFragment) {
            return true;
        }
        Log.w(TAG, "onPreferenceStartFragment is not implemented in the parent activity - attempting to use a fallback implementation. You should implement this method so that you can configure the new fragment that will be displayed, and set a transition between the fragments.");
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Bundle extras = preference.getExtras();
        Fragment fragmentInstantiate = parentFragmentManager.getFragmentFactory().instantiate(requireActivity().getClassLoader(), preference.getFragment());
        fragmentInstantiate.setArguments(extras);
        fragmentInstantiate.setTargetFragment(this, 0);
        parentFragmentManager.beginTransaction().replace(((View) requireView().getParent()).getId(), fragmentInstantiate).addToBackStack(null).commit();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        if (preferenceScreen != null) {
            Bundle bundle2 = new Bundle();
            preferenceScreen.saveHierarchyState(bundle2);
            bundle.putBundle(PREFERENCES_TAG, bundle2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.mPreferenceManager.setOnPreferenceTreeClickListener(this);
        this.mPreferenceManager.setOnDisplayPreferenceDialogListener(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.mPreferenceManager.setOnPreferenceTreeClickListener(null);
        this.mPreferenceManager.setOnDisplayPreferenceDialogListener(null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        Bundle bundle2;
        PreferenceScreen preferenceScreen;
        super.onViewCreated(view, bundle);
        if (bundle != null && (bundle2 = bundle.getBundle(PREFERENCES_TAG)) != null && (preferenceScreen = getPreferenceScreen()) != null) {
            preferenceScreen.restoreHierarchyState(bundle2);
        }
        if (this.mHavePrefs) {
            bindPreferences();
            Runnable runnable = this.mSelectPreferenceRunnable;
            if (runnable != null) {
                runnable.run();
                this.mSelectPreferenceRunnable = null;
            }
        }
        this.mInitDone = true;
    }

    public void scrollToPreference(@NonNull String str) {
        scrollToPreferenceInternal(null, str);
    }

    public void seslSetRoundedCorner(boolean z) {
        this.mIsRoundedCorner = z;
    }

    public void setDivider(@Nullable Drawable drawable) {
        this.mDividerDecoration.setDivider(drawable);
    }

    public void setDividerHeight(int i) {
        this.mDividerDecoration.setDividerHeight(i);
    }

    public void setPadding(int i, int i2, int i4, int i5) {
        this.mLeft = i;
        this.mTop = i2;
        this.mRight = i4;
        this.mBottom = i5;
        updatePadding();
    }

    public void setPreferenceScreen(PreferenceScreen preferenceScreen) {
        if (!this.mPreferenceManager.setPreferences(preferenceScreen) || preferenceScreen == null) {
            return;
        }
        onUnbindPreferences();
        this.mHavePrefs = true;
        if (this.mInitDone) {
            postBindPreferences();
        }
    }

    public void setPreferencesFromResource(@XmlRes int i, @Nullable String str) {
        requirePreferenceManager();
        PreferenceScreen preferenceScreenInflateFromResource = this.mPreferenceManager.inflateFromResource(requireContext(), i, null);
        Preference preference = preferenceScreenInflateFromResource;
        if (str != null) {
            Preference preferenceFindPreference = preferenceScreenInflateFromResource.findPreference(str);
            boolean z = preferenceFindPreference instanceof PreferenceScreen;
            preference = preferenceFindPreference;
            if (!z) {
                throw new IllegalArgumentException(AbstractC0541b.m773o("Preference object with key ", str, " is not a PreferenceScreen"));
            }
        }
        setPreferenceScreen((PreferenceScreen) preference);
    }

    public void scrollToPreference(@NonNull Preference preference) {
        scrollToPreferenceInternal(preference, null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void onBindPreferences() {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void onUnbindPreferences() {
    }
}
