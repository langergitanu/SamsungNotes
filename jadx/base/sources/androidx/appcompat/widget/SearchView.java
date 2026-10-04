package androidx.appcompat.widget;

import android.R;
import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.C0419R;
import androidx.appcompat.oneui.common.BlurSupportable;
import androidx.appcompat.oneui.common.internal.policy.BlurInfoState;
import androidx.appcompat.oneui.common.internal.semblurinfo.SemBlurInfoStateBuilder;
import androidx.appcompat.util.SeslMisc;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.core.content.p110pm.PackageInfoCompat;
import androidx.core.oneui.common.internal.semblurinfo.SemBlurInfoState;
import androidx.core.view.ViewCompat;
import androidx.cursoradapter.widget.CursorAdapter;
import androidx.customview.view.AbsSavedState;
import androidx.reflect.p112os.SeslBuildReflector;
import androidx.reflect.view.inputmethod.SeslInputMethodManagerReflector;
import androidx.reflect.widget.SeslTextViewReflector;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.samsung.android.support.senl.p148nt.base.widget.search.VoiceButtonHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.directwrite.constants.DirectWriteConstant;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.WeakHashMap;
import p001A.AbstractC0000a;
import p074R1.AbstractC0229a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
public class SearchView extends LinearLayoutCompat implements CollapsibleActionView, BlurSupportable {
    private static final String AUTHORITY_SVI_APP;
    static final boolean DBG = false;
    public static final int FLAG_MUTABLE = 33554432;
    private static final int FONT_WEIGHT_SEMIBOLD = 600;
    private static final String IME_OPTION_NO_MICROPHONE = "nm";
    private static final String KEY_SVI_APP_LOCALE;
    static final String LOG_TAG = "SearchView";
    private static final float MAX_FONT_SCALE = 1.3f;
    static final PreQAutoCompleteTextViewReflector PRE_API_29_HIDDEN_METHOD_INVOKER;
    private static final int SEP_VERSION_SUPPORTING_SVI_SEARCH_QUERY = 110100;
    private static final String SVI_ACTION;
    private static final String SVI_INTENT_EXTRA = "samsung.svoiceime.extra.LANGUAGE";
    private static final String SVI_PACKAGE;
    private static final int SVI_VERSION_SUPPORTING_SEARCH_QUERY = 220002001;
    private Bundle mAppSearchData;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    final ImageView mBackButton;
    private SemBlurInfoState mBlurInfo;
    private int mBlurMode;
    private Typeface mBoldTypeface;
    private boolean mClearingFocus;
    final ImageView mCloseButton;
    private int mCollapsedImeOptions;
    private Context mContext;
    private final CharSequence mDefaultQueryHint;
    private final View mDropDownAnchor;
    private boolean mExpandedInActionView;
    final Drawable mGVIVoiceIcon;
    final ImageView mGoButton;
    private boolean mIconified;
    private boolean mIconifiedByDefault;
    private InputMethodManager mImm;
    private final boolean mIsBlurApplied;
    private final boolean mIsBottomSearchView;
    private boolean mIsSearchMagIconButtonEnabled;
    private int mMaxWidth;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    final ImageView mMoreButton;
    private CharSequence mOldQueryText;
    private final View.OnClickListener mOnClickListener;
    private OnCloseListener mOnCloseListener;
    private final TextView.OnEditorActionListener mOnEditorActionListener;
    private final AdapterView.OnItemClickListener mOnItemClickListener;
    private final AdapterView.OnItemSelectedListener mOnItemSelectedListener;
    private OnQueryTextListener mOnQueryChangeListener;
    View.OnFocusChangeListener mOnQueryTextFocusChangeListener;
    private View.OnClickListener mOnSearchClickListener;
    private OnSuggestionListener mOnSuggestionListener;
    private final WeakHashMap<String, Drawable.ConstantState> mOutsideDrawablesCache;
    private CharSequence mQueryHint;
    private boolean mQueryRefinement;
    private Runnable mReleaseCursorRunnable;
    final Drawable mSVIVoiceIcon;
    private final Intent mSVoiceSearchIntent;
    final ImageView mSearchButton;
    private final View mSearchEditFrame;
    private final Drawable mSearchHintIcon;
    private int mSearchIconResId;
    private final ImageView mSearchMagIconButton;
    private final View mSearchPlate;
    private final View mSearchPlateFrame;
    private final View mSearchPlateStroke;
    final SearchAutoComplete mSearchSrcTextView;
    private Rect mSearchSrcTextViewBounds;
    private Rect mSearchSrtTextViewBoundsExpanded;
    SearchableInfo mSearchable;
    private final View mSubmitArea;
    private boolean mSubmitButtonEnabled;
    private final int mSuggestionCommitIconResId;
    private final int mSuggestionRowLayout;
    CursorAdapter mSuggestionsAdapter;
    private int[] mTemp;
    private int[] mTemp2;
    View.OnKeyListener mTextKeyListener;
    private TextWatcher mTextWatcher;
    private UpdatableTouchDelegate mTouchDelegate;
    private final Runnable mUpdateDrawableStateRunnable;
    private boolean mUseSVI;
    private CharSequence mUserQuery;
    private final Intent mVoiceAppSearchIntent;
    final ImageView mVoiceButton;
    private boolean mVoiceButtonEnabled;
    private final Intent mVoiceWebSearchIntent;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        public static void refreshAutoCompleteResults(AutoCompleteTextView autoCompleteTextView) {
            autoCompleteTextView.refreshAutoCompleteResults();
        }

        public static void setInputMethodMode(SearchAutoComplete searchAutoComplete, int i) {
            searchAutoComplete.setInputMethodMode(i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RequiresApi(29)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion {
        private int mIconifiedByDefaultId;
        private int mImeOptionsId;
        private int mMaxWidthId;
        private boolean mPropertiesMapped = false;
        private int mQueryHintId;

        public void mapProperties(@NonNull PropertyMapper propertyMapper) {
            this.mImeOptionsId = propertyMapper.mapInt("imeOptions", R.attr.imeOptions);
            this.mMaxWidthId = propertyMapper.mapInt("maxWidth", R.attr.maxWidth);
            this.mIconifiedByDefaultId = propertyMapper.mapBoolean("iconifiedByDefault", C0419R.attr.iconifiedByDefault);
            this.mQueryHintId = propertyMapper.mapObject("queryHint", C0419R.attr.queryHint);
            this.mPropertiesMapped = true;
        }

        public void readProperties(@NonNull SearchView searchView, @NonNull PropertyReader propertyReader) {
            if (!this.mPropertiesMapped) {
                throw AbstractC0229a.m512l();
            }
            propertyReader.readInt(this.mImeOptionsId, searchView.getImeOptions());
            propertyReader.readInt(this.mMaxWidthId, searchView.getMaxWidth());
            propertyReader.readBoolean(this.mIconifiedByDefaultId, searchView.isIconfiedByDefault());
            propertyReader.readObject(this.mQueryHintId, searchView.getQueryHint());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnCloseListener {
        boolean onClose();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnPrivateImeCommandListener {
        boolean onPrivateIMECommand(String str, Bundle bundle);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnQueryTextListener {
        boolean onQueryTextChange(String str);

        boolean onQueryTextSubmit(String str);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnSuggestionListener {
        boolean onSuggestionClick(int i);

        boolean onSuggestionSelect(int i);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class PreQAutoCompleteTextViewReflector {
        private Method mDoAfterTextChanged;
        private Method mDoBeforeTextChanged;
        private Method mEnsureImeVisible;

        @SuppressLint({"DiscouragedPrivateApi", "SoonBlockedPrivateApi"})
        public PreQAutoCompleteTextViewReflector() {
            this.mDoBeforeTextChanged = null;
            this.mDoAfterTextChanged = null;
            this.mEnsureImeVisible = null;
            preApi29Check();
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", null);
                this.mDoBeforeTextChanged = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", null);
                this.mDoAfterTextChanged = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                this.mEnsureImeVisible = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        private static void preApi29Check() {
            if (Build.VERSION.SDK_INT >= 29) {
                throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
            }
        }

        public void doAfterTextChanged(AutoCompleteTextView autoCompleteTextView) {
            preApi29Check();
            Method method = this.mDoAfterTextChanged;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, null);
                } catch (Exception unused) {
                }
            }
        }

        public void doBeforeTextChanged(AutoCompleteTextView autoCompleteTextView) {
            preApi29Check();
            Method method = this.mDoBeforeTextChanged;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, null);
                } catch (Exception unused) {
                }
            }
        }

        public void ensureImeVisible(AutoCompleteTextView autoCompleteTextView) {
            preApi29Check();
            Method method = this.mEnsureImeVisible;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, Boolean.TRUE);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.appcompat.widget.SearchView.SavedState.1
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
        boolean isIconified;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("SearchView.SavedState{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" isIconified=");
            return AbstractC0000a.m14k(sb, this.isIconified, "}");
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.isIconified));
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.isIconified = ((Boolean) parcel.readValue(null)).booleanValue();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {
        private boolean mForceNotCallShowSoftInput;
        private boolean mHasPendingShowSoftInputRequest;

        @Nullable
        private OnPrivateImeCommandListener mOnAppPrivateCommandListener;
        final Runnable mRunShowSoftInputIfNecessary;
        private SearchView mSearchView;
        private int mThreshold;

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i = configuration.screenWidthDp;
            int i2 = configuration.screenHeightDp;
            if (i >= 960 && i2 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i < 600) {
                return (i < 640 || i2 < 480) ? 160 : 192;
            }
            return 192;
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            return this.mThreshold <= 0 || super.enoughToFilter();
        }

        public void ensureImeVisible() {
            if (Build.VERSION.SDK_INT < 29) {
                SearchView.PRE_API_29_HIDDEN_METHOD_INVOKER.ensureImeVisible(this);
                return;
            }
            Api29Impl.setInputMethodMode(this, 1);
            if (getFilter() == null || !enoughToFilter()) {
                return;
            }
            showDropDown();
        }

        public boolean isEmpty() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        @Override // androidx.appcompat.widget.AppCompatAutoCompleteTextView, android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.mHasPendingShowSoftInputRequest) {
                removeCallbacks(this.mRunShowSoftInputIfNecessary);
                post(this.mRunShowSoftInputIfNecessary);
            }
            return inputConnectionOnCreateInputConnection;
        }

        @Override // android.view.View
        public void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            this.mSearchView.onTextFocusChanged();
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            return super.onKeyPreIme(i, keyEvent);
        }

        @Override // android.widget.TextView
        public boolean onPrivateIMECommand(String str, Bundle bundle) {
            OnPrivateImeCommandListener onPrivateImeCommandListener = this.mOnAppPrivateCommandListener;
            return onPrivateImeCommandListener != null ? onPrivateImeCommandListener.onPrivateIMECommand(str, bundle) : super.onPrivateIMECommand(str, bundle);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.mSearchView.hasFocus() && getVisibility() == 0) {
                this.mHasPendingShowSoftInputRequest = true;
                if (SearchView.isLandscapeMode(getContext())) {
                    ensureImeVisible();
                }
            }
        }

        public void seslSetOnPrivateImeCommandListener(@Nullable OnPrivateImeCommandListener onPrivateImeCommandListener) {
            this.mOnAppPrivateCommandListener = onPrivateImeCommandListener;
        }

        public void setImeVisibility(boolean z) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z) {
                this.mHasPendingShowSoftInputRequest = false;
                removeCallbacks(this.mRunShowSoftInputIfNecessary);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else {
                if (!inputMethodManager.isActive(this)) {
                    this.mHasPendingShowSoftInputRequest = true;
                    return;
                }
                this.mHasPendingShowSoftInputRequest = false;
                removeCallbacks(this.mRunShowSoftInputIfNecessary);
                inputMethodManager.showSoftInput(this, 0);
            }
        }

        public void setNotCallShowSoftInput(boolean z) {
            this.mForceNotCallShowSoftInput = z;
        }

        public void setSearchView(SearchView searchView) {
            this.mSearchView = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i) {
            super.setThreshold(i);
            this.mThreshold = i;
        }

        public void showSoftInputIfNecessary() {
            if (this.mForceNotCallShowSoftInput || !this.mHasPendingShowSoftInputRequest) {
                return;
            }
            ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
            this.mHasPendingShowSoftInputRequest = false;
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, C0419R.attr.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.mRunShowSoftInputIfNecessary = new Runnable() { // from class: androidx.appcompat.widget.SearchView.SearchAutoComplete.1
                @Override // java.lang.Runnable
                public void run() {
                    SearchAutoComplete.this.showSoftInputIfNecessary();
                }
            };
            this.mOnAppPrivateCommandListener = null;
            this.mThreshold = getThreshold();
        }

        @Override // android.widget.AutoCompleteTextView
        public void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        public void replaceText(CharSequence charSequence) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum SeslSearchViewStyle {
        LIGHT_WITH_BACKGROUND(C0419R.color.sesl_search_view_background_text_color_light, C0419R.color.sesl_search_view_background_hint_text_color_light, C0419R.color.sesl_search_view_background_icon_color_light, C0419R.dimen.sesl_search_view_search_text_size_with_background),
        LIGHT_WITHOUT_BACKGROUND(C0419R.color.sesl_search_view_text_color, C0419R.color.sesl_search_view_hint_text_color, C0419R.color.sesl_search_view_icon_color, C0419R.dimen.sesl_search_view_search_text_size),
        DARK_WITH_BACKGROUND(C0419R.color.sesl_search_view_background_text_color_dark, C0419R.color.sesl_search_view_background_hint_text_color_dark, C0419R.color.sesl_search_view_background_icon_color_dark, C0419R.dimen.sesl_search_view_search_text_size_with_background),
        DARK_WITHOUT_BACKGROUND(C0419R.color.sesl_search_view_text_color_dark, C0419R.color.sesl_search_view_hint_text_color_dark, C0419R.color.sesl_search_view_icon_color_dark, C0419R.dimen.sesl_search_view_search_text_size);


        @ColorRes
        private final int mHintTextColorRes;

        @ColorRes
        private final int mIconColorRes;

        @ColorRes
        private final int mTextColorRes;

        @DimenRes
        private final int mTextSizeRes;

        SeslSearchViewStyle(@ColorRes int i, @ColorRes int i2, @ColorRes int i4, @DimenRes int i5) {
            this.mTextColorRes = i;
            this.mHintTextColorRes = i2;
            this.mIconColorRes = i4;
            this.mTextSizeRes = i5;
        }

        public static SeslSearchViewStyle create(@NonNull Context context, boolean z) {
            return (SeslMisc.isLightTheme(context) ? new SeslSearchViewStyle[]{LIGHT_WITH_BACKGROUND, LIGHT_WITHOUT_BACKGROUND} : new SeslSearchViewStyle[]{DARK_WITH_BACKGROUND, DARK_WITHOUT_BACKGROUND})[!z ? 1 : 0];
        }

        public void apply(@NonNull Resources resources, @NonNull TextView textView, @NonNull List<ImageView> list) {
            Log.d(SearchView.LOG_TAG, "[SeslSearchViewStyle] apply " + this);
            textView.setTextColor(resources.getColor(this.mTextColorRes));
            textView.setHintTextColor(resources.getColor(this.mHintTextColorRes));
            textView.setTextSize(0, resources.getDimensionPixelSize(this.mTextSizeRes));
            Iterator<ImageView> it = list.iterator();
            while (it.hasNext()) {
                it.next().setColorFilter(resources.getColor(this.mIconColorRes));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class UpdatableTouchDelegate extends TouchDelegate {
        private final Rect mActualBounds;
        private boolean mDelegateTargeted;
        private final View mDelegateView;
        private final int mSlop;
        private final Rect mSlopBounds;
        private final Rect mTargetBounds;

        public UpdatableTouchDelegate(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.mSlop = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.mTargetBounds = new Rect();
            this.mSlopBounds = new Rect();
            this.mActualBounds = new Rect();
            setBounds(rect, rect2);
            this.mDelegateView = view;
        }

        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z;
            boolean z2;
            int x = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            boolean z3 = true;
            if (action != 0) {
                if (action == 1 || action == 2) {
                    z2 = this.mDelegateTargeted;
                    if (z2 && !this.mSlopBounds.contains(x, y2)) {
                        z3 = z2;
                        z = false;
                    }
                } else {
                    if (action == 3) {
                        z2 = this.mDelegateTargeted;
                        this.mDelegateTargeted = false;
                    }
                    z = true;
                    z3 = false;
                }
                z3 = z2;
                z = true;
            } else if (this.mTargetBounds.contains(x, y2)) {
                this.mDelegateTargeted = true;
                z = true;
            } else {
                z = true;
                z3 = false;
            }
            if (!z3) {
                return false;
            }
            if (!z || this.mActualBounds.contains(x, y2)) {
                Rect rect = this.mActualBounds;
                motionEvent.setLocation(x - rect.left, y2 - rect.top);
            } else {
                motionEvent.setLocation(this.mDelegateView.getWidth() / 2, this.mDelegateView.getHeight() / 2);
            }
            return this.mDelegateView.dispatchTouchEvent(motionEvent);
        }

        public void setBounds(Rect rect, Rect rect2) {
            this.mTargetBounds.set(rect);
            this.mSlopBounds.set(rect);
            Rect rect3 = this.mSlopBounds;
            int i = this.mSlop;
            rect3.inset(-i, -i);
            this.mActualBounds.set(rect2);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        PRE_API_29_HIDDEN_METHOD_INVOKER = i < 29 ? new PreQAutoCompleteTextViewReflector() : null;
        SVI_PACKAGE = i < 33 ? "com.samsung.android.svoiceime" : DirectWriteConstant.SAMSUNG_HONEYBOARD_PKG_NAME;
        SVI_ACTION = i < 33 ? "samsung.svoiceime.action.RECOGNIZE_SPEECH" : VoiceButtonHelper.STT_SVI_ACTION;
        AUTHORITY_SVI_APP = i < 33 ? "com.samsung.android.svoiceime.provider" : "com.samsung.android.honeyboard.provider.VoiceLanguageListProvider";
        KEY_SVI_APP_LOCALE = i < 33 ? "is_svoice_locale_supported" : "is_honeyvoice_locale_supported";
    }

    public SearchView(@NonNull Context context) {
        this(context, null);
    }

    private void applyBottomSearchPlateStyle(Resources resources) {
        View view;
        if (!this.mIsBottomSearchView || (view = this.mSearchPlateFrame) == null || this.mSearchPlate == null || this.mSearchPlateStroke == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            int dimensionPixelSize = resources.getDimensionPixelSize(C0419R.dimen.sesl_search_bottom_horizontal_margin);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (marginLayoutParams.getMarginStart() != dimensionPixelSize || marginLayoutParams.getMarginEnd() != dimensionPixelSize) {
                marginLayoutParams.setMarginStart(dimensionPixelSize);
                marginLayoutParams.setMarginEnd(dimensionPixelSize);
                this.mSearchPlateFrame.setLayoutParams(marginLayoutParams);
            }
        } else {
            Log.w(LOG_TAG, "SearchPlateFrame's LayoutParams are not an instance of MarginLayoutParams.");
        }
        float dimension = resources.getDimension(C0419R.dimen.sesl_figma_elevation_md);
        this.mSearchPlate.setElevation(dimension);
        this.mSearchPlateStroke.setElevation(dimension);
        SearchAutoComplete searchAutoComplete = this.mSearchSrcTextView;
        searchAutoComplete.setImeOptions(searchAutoComplete.getImeOptions() | 268435456);
        setIconifiedByDefault(false);
        seslSetSearchMagIconVisibility(0);
        this.mSearchPlateStroke.setVisibility(0);
    }

    private void applySearchViewBlur() {
        if (!this.mIsBlurApplied || this.mSearchPlate == null) {
            return;
        }
        applyBlurInfo(getContext());
    }

    private Intent createIntent(String str, Uri uri, String str2, String str3, int i, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.mUserQuery);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.mAppSearchData;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (i != 0) {
            intent.putExtra("action_key", i);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.mSearchable.getSearchActivity());
        return intent;
    }

    private Intent createIntentFromSuggestion(Cursor cursor, int i, String str) {
        int position;
        String columnString;
        try {
            String columnString2 = SuggestionsAdapter.getColumnString(cursor, "suggest_intent_action");
            if (columnString2 == null) {
                columnString2 = this.mSearchable.getSuggestIntentAction();
            }
            if (columnString2 == null) {
                columnString2 = "android.intent.action.SEARCH";
            }
            String str2 = columnString2;
            String columnString3 = SuggestionsAdapter.getColumnString(cursor, "suggest_intent_data");
            if (columnString3 == null) {
                columnString3 = this.mSearchable.getSuggestIntentData();
            }
            if (columnString3 != null && (columnString = SuggestionsAdapter.getColumnString(cursor, "suggest_intent_data_id")) != null) {
                columnString3 = columnString3 + "/" + Uri.encode(columnString);
            }
            return createIntent(str2, columnString3 == null ? null : Uri.parse(columnString3), SuggestionsAdapter.getColumnString(cursor, "suggest_intent_extra_data"), SuggestionsAdapter.getColumnString(cursor, "suggest_intent_query"), i, str);
        } catch (RuntimeException e) {
            try {
                position = cursor.getPosition();
            } catch (RuntimeException unused) {
                position = -1;
            }
            Log.w(LOG_TAG, "Search suggestions cursor at row " + position + " returned exception.", e);
            return null;
        }
    }

    private Intent createSVoiceSearchIntent(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = Build.VERSION.SDK_INT >= 31 ? PendingIntent.getActivity(getContext(), 0, intent2, 1107296256) : PendingIntent.getActivity(getContext(), 0, intent2, 1073741824);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.mAppSearchData;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        intent3.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    private Intent createVoiceAppSearchIntent(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = Build.VERSION.SDK_INT >= 31 ? PendingIntent.getActivity(getContext(), 0, intent2, 1107296256) : PendingIntent.getActivity(getContext(), 0, intent2, 1073741824);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.mAppSearchData;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        int voiceMaxResults = searchableInfo.getVoiceMaxResults() != 0 ? searchableInfo.getVoiceMaxResults() : 1;
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
        intent3.putExtra("calling_package", searchActivity != null ? searchActivity.flattenToShortString() : null);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    private Intent createVoiceWebSearchIntent(Intent intent, SearchableInfo searchableInfo) {
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        intent2.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        return intent2;
    }

    private void dismissSuggestions() {
        this.mSearchSrcTextView.dismissDropDown();
    }

    @NonNull
    @RequiresApi(36)
    private SemBlurInfoState generateBlurInfo(@NonNull Context context) {
        float dimension = context.getResources().getDimension(C0419R.dimen.sesl_search_plate_radius_size);
        SemBlurInfoStateBuilder semBlurInfoStateBuilderGenerateFloatingComponentBlurInfoStateBuilder = BlurInfoState.INSTANCE.generateFloatingComponentBlurInfoStateBuilder(context, this.mBlurMode);
        if (this.mSearchPlate.getBackground() != null) {
            semBlurInfoStateBuilderGenerateFloatingComponentBlurInfoStateBuilder.nonBlurBackground(this.mSearchPlate.getBackground());
        }
        return semBlurInfoStateBuilderGenerateFloatingComponentBlurInfoStateBuilder.cornerRadius(dimension).build();
    }

    private void getChildBoundsWithinSearchView(View view, Rect rect) {
        view.getLocationInWindow(this.mTemp);
        getLocationInWindow(this.mTemp2);
        int[] iArr = this.mTemp;
        int i = iArr[1];
        int[] iArr2 = this.mTemp2;
        int i2 = i - iArr2[1];
        int i4 = iArr[0] - iArr2[0];
        rect.set(i4, i2, view.getWidth() + i4, view.getHeight() + i2);
    }

    private CharSequence getDecoratedHint(CharSequence charSequence) {
        if (this.mIconifiedByDefault) {
            return charSequence;
        }
        int textSize = (int) (((double) this.mSearchSrcTextView.getTextSize()) * 1.25d);
        this.mSearchHintIcon.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.mSearchHintIcon), 0, 1, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    private int getPreferredHeight() {
        return this.mIsBottomSearchView ? getContext().getResources().getDimensionPixelSize(C0419R.dimen.sesl_search_view_bottom_preferred_height) : getContext().getResources().getDimensionPixelSize(C0419R.dimen.sesl_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(C0419R.dimen.sesl_search_view_preferred_width);
    }

    private boolean hasVoiceSearch() {
        SearchableInfo searchableInfo = this.mSearchable;
        if (searchableInfo != null && searchableInfo.getVoiceSearchEnabled()) {
            Intent intent = this.mSearchable.getVoiceSearchLaunchWebSearch() ? this.mVoiceWebSearchIntent : this.mSearchable.getVoiceSearchLaunchRecognizer() ? this.mUseSVI ? this.mSVoiceSearchIntent : this.mVoiceAppSearchIntent : null;
            if (intent != null && getContext().getPackageManager().resolveActivity(intent, 65536) != null) {
                return true;
            }
        }
        return false;
    }

    public static boolean isLandscapeMode(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private boolean isSubmitAreaEnabled() {
        return (this.mSubmitButtonEnabled || this.mVoiceButtonEnabled) && !isIconified();
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean isSystemLocaleSupported() {
        int i;
        Cursor cursorQuery;
        try {
            cursorQuery = this.mContext.getContentResolver().query(Uri.parse(AuthenticationConstants.BrokerContentProvider.CONTENT_SCHEME + AUTHORITY_SVI_APP + "/" + KEY_SVI_APP_LOCALE), null, null, null, null);
        } catch (Exception e) {
            e = e;
            i = 0;
        }
        if (cursorQuery == null) {
            if (cursorQuery == null) {
                return false;
            }
            cursorQuery.close();
            return false;
        }
        i = 0;
        while (cursorQuery.moveToNext()) {
            try {
                try {
                    i = cursorQuery.getInt(cursorQuery.getColumnIndex(KEY_SVI_APP_LOCALE));
                } finally {
                }
            } catch (Exception e2) {
                e = e2;
            }
        }
        cursorQuery.close();
        return i != 1;
        Log.w(LOG_TAG, "isSystemLocaleSupported: exception!!" + e);
        if (i != 1) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view, boolean z) {
        if (this.mIsSearchMagIconButtonEnabled) {
            int i = 8;
            if (!z && this.mSearchSrcTextView.isEmpty()) {
                i = 0;
            }
            updateSearchMagIconVisibility(i);
        }
        View.OnFocusChangeListener onFocusChangeListener = this.mOnQueryTextFocusChangeListener;
        if (onFocusChangeListener != null) {
            onFocusChangeListener.onFocusChange(this, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$seslSetSviEnabled$1() {
        updateViewsVisibility(isIconified());
    }

    private void launchIntent(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            getContext().startActivity(intent);
        } catch (RuntimeException e) {
            Log.e(LOG_TAG, "Failed launch activity: " + intent, e);
        }
    }

    private boolean launchSuggestion(int i, int i2, String str) {
        Cursor cursor = this.mSuggestionsAdapter.getCursor();
        if (cursor == null || !cursor.moveToPosition(i)) {
            return false;
        }
        launchIntent(createIntentFromSuggestion(cursor, i2, str));
        return true;
    }

    private void postUpdateFocusedState() {
        post(this.mUpdateDrawableStateRunnable);
    }

    private void rewriteQueryFromSuggestion(int i) {
        Editable text = this.mSearchSrcTextView.getText();
        Cursor cursor = this.mSuggestionsAdapter.getCursor();
        if (cursor == null) {
            return;
        }
        if (!cursor.moveToPosition(i)) {
            setQuery(text);
            return;
        }
        CharSequence charSequenceConvertToString = this.mSuggestionsAdapter.convertToString(cursor);
        if (charSequenceConvertToString != null) {
            setQuery(charSequenceConvertToString);
        } else {
            setQuery(text);
        }
    }

    private void seslCheckMaxFont() {
        Resources resources = this.mContext.getResources();
        float f = resources.getConfiguration().fontScale;
        View view = this.mSearchPlate;
        float dimensionPixelSize = resources.getDimensionPixelSize(SeslSearchViewStyle.create(this.mContext, (view == null || view.getBackground() == null) ? false : true).mTextSizeRes);
        if (f > 1.3f) {
            dimensionPixelSize = (dimensionPixelSize / f) * 1.3f;
        }
        this.mSearchSrcTextView.setTextSize(0, dimensionPixelSize);
    }

    private void updateCloseButton() {
        boolean zIsEmpty = TextUtils.isEmpty(this.mSearchSrcTextView.getText());
        this.mCloseButton.setVisibility(!zIsEmpty ? 0 : 8);
        Drawable drawable = this.mCloseButton.getDrawable();
        if (drawable != null) {
            drawable.setState(!zIsEmpty ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    private void updateQueryHint() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.mSearchSrcTextView;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(queryHint);
    }

    private void updateSearchAutoComplete() {
        this.mSearchSrcTextView.setThreshold(this.mSearchable.getSuggestThreshold());
        this.mSearchSrcTextView.setImeOptions(this.mSearchable.getImeOptions());
        int inputType = this.mSearchable.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.mSearchable.getSuggestAuthority() != null) {
                inputType |= 65536;
            }
        }
        this.mSearchSrcTextView.setInputType(inputType);
        CursorAdapter cursorAdapter = this.mSuggestionsAdapter;
        if (cursorAdapter != null) {
            cursorAdapter.changeCursor(null);
        }
        if (this.mSearchable.getSuggestAuthority() != null) {
            SuggestionsAdapter suggestionsAdapter = new SuggestionsAdapter(getContext(), this, this.mSearchable, this.mOutsideDrawablesCache);
            this.mSuggestionsAdapter = suggestionsAdapter;
            this.mSearchSrcTextView.setAdapter(suggestionsAdapter);
            ((SuggestionsAdapter) this.mSuggestionsAdapter).setQueryRefinement(this.mQueryRefinement ? 2 : 1);
        }
    }

    private void updateSearchMagIconVisibility(int i) {
        ImageView imageView = this.mSearchMagIconButton;
        if (imageView == null || imageView.getVisibility() == i) {
            return;
        }
        this.mSearchMagIconButton.setVisibility(i);
        updateSearchPlatePadding();
    }

    private void updateSearchPlatePadding() {
        if (this.mSearchPlate == null) {
            return;
        }
        Resources resources = this.mContext.getResources();
        int dimensionPixelSize = (!this.mIsBottomSearchView || this.mSearchMagIconButton.getVisibility() == 0) ? resources.getDimensionPixelSize(C0419R.dimen.sesl_search_plate_padding_start) : resources.getDimensionPixelSize(C0419R.dimen.sesl_search_plate_bottom_padding_start);
        this.mSearchPlate.setPaddingRelative(dimensionPixelSize, this.mSearchPlate.getPaddingTop(), resources.getDimensionPixelSize(C0419R.dimen.sesl_search_plate_bottom_padding_end), this.mSearchPlate.getPaddingBottom());
    }

    private void updateSubmitArea() {
        this.mSubmitArea.setVisibility((isSubmitAreaEnabled() && (this.mGoButton.getVisibility() == 0 || this.mVoiceButton.getVisibility() == 0)) ? 0 : 8);
    }

    private void updateSubmitButton(boolean z) {
        this.mGoButton.setVisibility((this.mSubmitButtonEnabled && isSubmitAreaEnabled() && hasFocus() && (z || !this.mVoiceButtonEnabled)) ? 0 : 8);
    }

    private void updateViewsVisibility(boolean z) {
        this.mIconified = z;
        int i = z ? 0 : 8;
        boolean zIsEmpty = TextUtils.isEmpty(this.mSearchSrcTextView.getText());
        this.mSearchButton.setVisibility(i);
        updateSubmitButton(!zIsEmpty);
        this.mSearchEditFrame.setVisibility(z ? 8 : 0);
        updateCloseButton();
        updateVoiceButton(zIsEmpty);
        updateSubmitArea();
    }

    private void updateVoiceButton(boolean z) {
        int i = 8;
        if (this.mVoiceButtonEnabled && !isIconified() && z) {
            this.mGoButton.setVisibility(8);
            i = 0;
        }
        updateVoiceButtonDrawable();
        this.mVoiceButton.setVisibility(i);
    }

    private void updateVoiceButtonDrawable() {
        this.mVoiceButton.setImageDrawable(this.mUseSVI ? this.mSVIVoiceIcon : this.mGVIVoiceIcon);
    }

    public void adjustDropDownSizeAndPosition() {
        if (this.mDropDownAnchor.getWidth() > 1) {
            Rect rect = new Rect();
            boolean zIsLayoutRtl = ViewUtils.isLayoutRtl(this);
            if (this.mSearchSrcTextView.getDropDownBackground() != null) {
                this.mSearchSrcTextView.getDropDownBackground().getPadding(rect);
            }
            this.mSearchSrcTextView.setDropDownHorizontalOffset(zIsLayoutRtl ? -rect.left : 0 - rect.left);
            this.mSearchSrcTextView.setDropDownWidth(this.mDropDownAnchor.getWidth() + rect.left + rect.right);
            if (this.mSearchSrcTextView.isPopupShowing()) {
                this.mSearchSrcTextView.showDropDown();
            }
        }
    }

    @Override // androidx.appcompat.oneui.common.BlurSupportable
    public boolean applyBlurInfo(@NonNull Context context) {
        if (Build.VERSION.SDK_INT < 36) {
            return false;
        }
        clearBlurInfo(context);
        SemBlurInfoState semBlurInfoStateGenerateBlurInfo = generateBlurInfo(context);
        if (semBlurInfoStateGenerateBlurInfo.applyBlurInfo(this.mSearchPlate)) {
            this.mBlurInfo = semBlurInfoStateGenerateBlurInfo;
            return true;
        }
        this.mBlurInfo = null;
        return false;
    }

    @Override // androidx.appcompat.oneui.common.BlurSupportable
    public void clearBlurInfo(@NonNull Context context) {
        View view;
        SemBlurInfoState semBlurInfoState = this.mBlurInfo;
        if (semBlurInfoState == null || (view = this.mSearchPlate) == null) {
            return;
        }
        semBlurInfoState.clearBlurInfo(view);
        this.mBlurInfo = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.mClearingFocus = true;
        super.clearFocus();
        this.mSearchSrcTextView.clearFocus();
        this.mSearchSrcTextView.setImeVisibility(false);
        this.mClearingFocus = false;
    }

    public void forceSuggestionQuery() {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.refreshAutoCompleteResults(this.mSearchSrcTextView);
        } else {
            PreQAutoCompleteTextViewReflector preQAutoCompleteTextViewReflector = PRE_API_29_HIDDEN_METHOD_INVOKER;
            preQAutoCompleteTextViewReflector.doBeforeTextChanged(this.mSearchSrcTextView);
            preQAutoCompleteTextViewReflector.doAfterTextChanged(this.mSearchSrcTextView);
        }
        if (this.mIsSearchMagIconButtonEnabled) {
            updateSearchMagIconVisibility(8);
        }
    }

    public int getImeOptions() {
        return this.mSearchSrcTextView.getImeOptions();
    }

    public int getInputType() {
        return this.mSearchSrcTextView.getInputType();
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public CharSequence getQuery() {
        return this.mSearchSrcTextView.getText();
    }

    @Nullable
    public CharSequence getQueryHint() {
        CharSequence charSequence = this.mQueryHint;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.mSearchable;
        return (searchableInfo == null || searchableInfo.getHintId() == 0) ? this.mDefaultQueryHint : getContext().getText(this.mSearchable.getHintId());
    }

    public int getSuggestionCommitIconResId() {
        return this.mSuggestionCommitIconResId;
    }

    public int getSuggestionRowLayout() {
        return this.mSuggestionRowLayout;
    }

    public CursorAdapter getSuggestionsAdapter() {
        return this.mSuggestionsAdapter;
    }

    @Override // androidx.appcompat.oneui.common.BlurSupportable
    public boolean isBlurApplied() {
        return this.mBlurInfo != null;
    }

    public boolean isIconfiedByDefault() {
        return this.mIconifiedByDefault;
    }

    public boolean isIconified() {
        return this.mIconified;
    }

    public boolean isQueryRefinementEnabled() {
        return this.mQueryRefinement;
    }

    public boolean isSubmitButtonEnabled() {
        return this.mSubmitButtonEnabled;
    }

    public void launchQuerySearch(int i, String str, String str2) {
        getContext().startActivity(createIntent("android.intent.action.SEARCH", null, null, str2, i, str));
    }

    @Override // androidx.appcompat.view.CollapsibleActionView
    public void onActionViewCollapsed() {
        setQuery("", false);
        clearFocus();
        updateViewsVisibility(true);
        this.mSearchSrcTextView.setImeOptions(this.mCollapsedImeOptions);
        this.mExpandedInActionView = false;
    }

    @Override // androidx.appcompat.view.CollapsibleActionView
    public void onActionViewExpanded() {
        if (this.mExpandedInActionView) {
            return;
        }
        this.mExpandedInActionView = true;
        int imeOptions = this.mSearchSrcTextView.getImeOptions();
        this.mCollapsedImeOptions = imeOptions;
        this.mSearchSrcTextView.setImeOptions(imeOptions | 33554432);
        this.mSearchSrcTextView.setText("");
        setIconified(false);
    }

    public void onCloseClicked() {
        if (!TextUtils.isEmpty(this.mSearchSrcTextView.getText())) {
            this.mSearchSrcTextView.setText("");
            this.mSearchSrcTextView.requestFocus();
            this.mSearchSrcTextView.announceForAccessibility(getResources().getString(C0419R.string.sesl_searchview_description_clear_field));
            if (SeslInputMethodManagerReflector.isAccessoryKeyboardState(this.mImm) != 0) {
                this.mSearchSrcTextView.setImeVisibility(false);
                return;
            } else {
                this.mSearchSrcTextView.setImeVisibility(true);
                return;
            }
        }
        if (this.mIconifiedByDefault) {
            OnCloseListener onCloseListener = this.mOnCloseListener;
            if (onCloseListener == null || !onCloseListener.onClose()) {
                clearFocus();
                updateViewsVisibility(true);
            }
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        seslCheckMaxFont();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.mUpdateDrawableStateRunnable);
        post(this.mReleaseCursorRunnable);
        super.onDetachedFromWindow();
    }

    public boolean onItemClicked(int i, int i2, String str) {
        OnSuggestionListener onSuggestionListener = this.mOnSuggestionListener;
        if (onSuggestionListener != null && onSuggestionListener.onSuggestionClick(i)) {
            return false;
        }
        launchSuggestion(i, 0, null);
        this.mSearchSrcTextView.setImeVisibility(false);
        dismissSuggestions();
        return true;
    }

    public boolean onItemSelected(int i) {
        OnSuggestionListener onSuggestionListener = this.mOnSuggestionListener;
        if (onSuggestionListener != null && onSuggestionListener.onSuggestionSelect(i)) {
            return false;
        }
        rewriteQueryFromSuggestion(i);
        return true;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i4, int i5) {
        super.onLayout(z, i, i2, i4, i5);
        if (z) {
            getChildBoundsWithinSearchView(this.mSearchSrcTextView, this.mSearchSrcTextViewBounds);
            Rect rect = this.mSearchSrtTextViewBoundsExpanded;
            Rect rect2 = this.mSearchSrcTextViewBounds;
            rect.set(rect2.left, 0, rect2.right, i5 - i2);
            UpdatableTouchDelegate updatableTouchDelegate = this.mTouchDelegate;
            if (updatableTouchDelegate != null) {
                updatableTouchDelegate.setBounds(this.mSearchSrtTextViewBoundsExpanded, this.mSearchSrcTextViewBounds);
                return;
            }
            UpdatableTouchDelegate updatableTouchDelegate2 = new UpdatableTouchDelegate(this.mSearchSrtTextViewBoundsExpanded, this.mSearchSrcTextViewBounds, this.mSearchSrcTextView);
            this.mTouchDelegate = updatableTouchDelegate2;
            setTouchDelegate(updatableTouchDelegate2);
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int i, int i2) {
        int i4;
        if (isIconified()) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE) {
            int i5 = this.mMaxWidth;
            if (i5 > 0) {
                size = Math.min(i5, size);
            }
        } else if (mode == 0) {
            size = this.mMaxWidth;
            if (size <= 0) {
                size = getPreferredWidth();
            }
        } else if (mode == 1073741824 && (i4 = this.mMaxWidth) > 0) {
            size = Math.min(i4, size);
        }
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getPreferredHeight(), size2);
        } else if (mode2 == 0) {
            size2 = getPreferredHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    public void onQueryRefine(@Nullable CharSequence charSequence) {
        setQuery(charSequence);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        updateViewsVisibility(savedState.isIconified);
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.isIconified = isIconified();
        return savedState;
    }

    public void onSearchClicked() {
        updateViewsVisibility(false);
        if (this.mIsSearchMagIconButtonEnabled) {
            updateSearchMagIconVisibility(8);
        }
        this.mSearchSrcTextView.requestFocus();
        if (SeslInputMethodManagerReflector.isAccessoryKeyboardState(this.mImm) != 0) {
            this.mSearchSrcTextView.setImeVisibility(false);
        } else {
            this.mSearchSrcTextView.setImeVisibility(true);
        }
        View.OnClickListener onClickListener = this.mOnSearchClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public void onSubmitQuery() {
        Editable text = this.mSearchSrcTextView.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        OnQueryTextListener onQueryTextListener = this.mOnQueryChangeListener;
        if (onQueryTextListener == null || !onQueryTextListener.onQueryTextSubmit(text.toString())) {
            if (this.mSearchable != null) {
                launchQuerySearch(0, null, text.toString());
            }
            this.mSearchSrcTextView.setImeVisibility(false);
            dismissSuggestions();
        }
    }

    public boolean onSuggestionsKey(View view, int i, KeyEvent keyEvent) {
        if (this.mSearchable != null && this.mSuggestionsAdapter != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i == 66 || i == 84 || i == 61 || i == 160) {
                return onItemClicked(this.mSearchSrcTextView.getListSelection(), 0, null);
            }
            if (i == 21 || i == 22) {
                this.mSearchSrcTextView.setSelection(i == 21 ? 0 : this.mSearchSrcTextView.length());
                this.mSearchSrcTextView.setListSelection(0);
                this.mSearchSrcTextView.clearListSelection();
                this.mSearchSrcTextView.ensureImeVisible();
                return true;
            }
            if (i == 19) {
                this.mSearchSrcTextView.getListSelection();
                return false;
            }
        }
        return false;
    }

    public void onTextChanged(CharSequence charSequence) {
        Editable text = this.mSearchSrcTextView.getText();
        this.mUserQuery = text;
        boolean zIsEmpty = TextUtils.isEmpty(text);
        updateSubmitButton(!zIsEmpty);
        updateVoiceButton(zIsEmpty);
        updateCloseButton();
        updateSubmitArea();
        if (TextUtils.equals(charSequence, this.mOldQueryText)) {
            return;
        }
        this.mOldQueryText = charSequence.toString();
        OnQueryTextListener onQueryTextListener = this.mOnQueryChangeListener;
        if (onQueryTextListener != null) {
            onQueryTextListener.onQueryTextChange(charSequence.toString());
        }
    }

    public void onTextFocusChanged() {
        updateViewsVisibility(isIconified());
        postUpdateFocusedState();
        if (this.mSearchSrcTextView.hasFocus()) {
            forceSuggestionQuery();
        }
    }

    public void onVoiceClicked() {
        SearchableInfo searchableInfo = this.mSearchable;
        if (searchableInfo == null) {
            return;
        }
        try {
            if (this.mUseSVI) {
                if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                    this.mContext.startActivity(createVoiceWebSearchIntent(this.mVoiceWebSearchIntent, searchableInfo));
                    return;
                } else {
                    if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                        this.mContext.startActivity(createSVoiceSearchIntent(this.mSVoiceSearchIntent, searchableInfo));
                        return;
                    }
                    return;
                }
            }
            if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                this.mContext.startActivity(createVoiceWebSearchIntent(this.mVoiceWebSearchIntent, searchableInfo));
            } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                this.mContext.startActivity(createVoiceAppSearchIntent(this.mVoiceAppSearchIntent, searchableInfo));
            }
        } catch (ActivityNotFoundException unused) {
            Log.w(LOG_TAG, "Could not find voice search activity");
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (SeslInputMethodManagerReflector.isAccessoryKeyboardState(this.mImm) != 0) {
            return;
        }
        postUpdateFocusedState();
    }

    @Override // android.view.View
    public boolean performLongClick() {
        TooltipCompat.seslSetNextTooltipForceBelow(true);
        TooltipCompat.seslSetNextTooltipForceActionBarPosX(true);
        return super.performLongClick();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i, Rect rect) {
        if (this.mClearingFocus || !isFocusable()) {
            return false;
        }
        if (isIconified()) {
            return super.requestFocus(i, rect);
        }
        boolean zRequestFocus = this.mSearchSrcTextView.requestFocus(i, rect);
        if (zRequestFocus) {
            updateViewsVisibility(false);
        }
        return zRequestFocus;
    }

    public AutoCompleteTextView seslGetAutoCompleteView() {
        return this.mSearchSrcTextView;
    }

    public ImageView seslGetOverflowMenuButton() {
        return this.mMoreButton;
    }

    public ImageView seslGetUpButton() {
        return this.mBackButton;
    }

    public boolean seslIsSviEnabled() {
        return this.mUseSVI;
    }

    public void seslSetNotCallShowSoftInput(boolean z) {
        this.mSearchSrcTextView.setNotCallShowSoftInput(z);
    }

    public void seslSetOnOverflowMenuButtonClickListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.mMoreButton;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public void seslSetOnPrivateImeCommandListener(@Nullable OnPrivateImeCommandListener onPrivateImeCommandListener) {
        this.mSearchSrcTextView.seslSetOnPrivateImeCommandListener(onPrivateImeCommandListener);
    }

    public void seslSetOnUpButtonClickListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.mBackButton;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public void seslSetOverflowMenuButtonIcon(Drawable drawable) {
        ImageView imageView = this.mMoreButton;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    public void seslSetOverflowMenuButtonVisibility(int i) {
        ImageView imageView = this.mMoreButton;
        if (imageView != null) {
            imageView.setVisibility(i);
        }
    }

    public void seslSetSearchMagIconVisibility(int i) {
        if (this.mSearchMagIconButton != null) {
            this.mIsSearchMagIconButtonEnabled = i == 0;
            updateSearchMagIconVisibility(i);
        }
    }

    public boolean seslSetSviEnabled(boolean z) {
        if (SeslBuildReflector.SeslVersionReflector.getField_SEM_PLATFORM_INT() < SEP_VERSION_SUPPORTING_SVI_SEARCH_QUERY) {
            Log.w(LOG_TAG, "seslSetSviEnabled: SEP Version is not supported");
            return false;
        }
        this.mUseSVI = z;
        if (z) {
            try {
                PackageInfo packageInfo = getContext().getPackageManager().getPackageInfo(SVI_PACKAGE, 0);
                if ((packageInfo != null ? PackageInfoCompat.getLongVersionCode(packageInfo) : -1L) < 220002001) {
                    Log.w(LOG_TAG, "seslSetSviEnabled: not supported SVI version");
                    this.mUseSVI = false;
                }
                if (!isSystemLocaleSupported()) {
                    Log.w(LOG_TAG, "seslSetSviEnabled: not supported system locale");
                    this.mUseSVI = false;
                }
            } catch (Exception e) {
                Log.w(LOG_TAG, "Exception " + e);
                this.mUseSVI = false;
            }
        }
        post(new RunnableC0553n(this, 2));
        return this.mUseSVI;
    }

    public void seslSetUpButtonIcon(Drawable drawable) {
        ImageView imageView = this.mBackButton;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    public void seslSetUpButtonVisibility(int i) {
        ImageView imageView = this.mBackButton;
        if (imageView != null) {
            imageView.setVisibility(i);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAppSearchData(Bundle bundle) {
        this.mAppSearchData = bundle;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        View view = this.mSearchPlate;
        if (view != null) {
            ViewCompat.setBackground(view, drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        View view = this.mSearchPlate;
        if (view != null) {
            ViewCompat.setBackground(view, getContext().getResources().getDrawable(i));
        }
    }

    @Override // androidx.appcompat.oneui.common.BlurSupportable
    public void setBlurMode(int i) {
        this.mBlurMode = i;
        applySearchViewBlur();
    }

    @Override // android.view.View
    public void setElevation(float f) {
        View view = this.mSearchPlate;
        if (view != null) {
            ViewCompat.setElevation(view, f);
        }
    }

    public void setIconified(boolean z) {
        if (z) {
            onCloseClicked();
        } else {
            onSearchClicked();
        }
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.mIconifiedByDefault == z) {
            return;
        }
        this.mIconifiedByDefault = z;
        updateViewsVisibility(z);
        updateQueryHint();
    }

    public void setImeOptions(int i) {
        this.mSearchSrcTextView.setImeOptions(i);
    }

    public void setInputType(int i) {
        this.mSearchSrcTextView.setInputType(i);
    }

    public void setMaxWidth(int i) {
        this.mMaxWidth = i;
        requestLayout();
    }

    public void setOnCloseListener(OnCloseListener onCloseListener) {
        this.mOnCloseListener = onCloseListener;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.mOnQueryTextFocusChangeListener = onFocusChangeListener;
    }

    public void setOnQueryTextListener(OnQueryTextListener onQueryTextListener) {
        this.mOnQueryChangeListener = onQueryTextListener;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.mOnSearchClickListener = onClickListener;
    }

    public void setOnSuggestionListener(OnSuggestionListener onSuggestionListener) {
        this.mOnSuggestionListener = onSuggestionListener;
    }

    public void setQuery(CharSequence charSequence, boolean z) {
        this.mSearchSrcTextView.setText(charSequence);
        if (charSequence != null) {
            SearchAutoComplete searchAutoComplete = this.mSearchSrcTextView;
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.mUserQuery = charSequence;
            if (this.mIsSearchMagIconButtonEnabled && !this.mSearchSrcTextView.hasFocus()) {
                updateSearchMagIconVisibility(TextUtils.isEmpty(charSequence) ? 0 : 8);
            }
        }
        if (!z || TextUtils.isEmpty(charSequence)) {
            return;
        }
        onSubmitQuery();
    }

    public void setQueryHint(@Nullable CharSequence charSequence) {
        this.mQueryHint = charSequence;
        updateQueryHint();
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.mQueryRefinement = z;
        CursorAdapter cursorAdapter = this.mSuggestionsAdapter;
        if (cursorAdapter instanceof SuggestionsAdapter) {
            ((SuggestionsAdapter) cursorAdapter).setQueryRefinement(z ? 2 : 1);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.mSearchable = searchableInfo;
        if (searchableInfo != null) {
            updateSearchAutoComplete();
            updateQueryHint();
        }
        this.mVoiceButtonEnabled = hasVoiceSearch();
        updateViewsVisibility(isIconified());
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.mSubmitButtonEnabled = z;
        updateViewsVisibility(isIconified());
    }

    public void setSuggestionsAdapter(CursorAdapter cursorAdapter) {
        this.mSuggestionsAdapter = cursorAdapter;
        this.mSearchSrcTextView.setAdapter(cursorAdapter);
    }

    public void updateFocusedState() {
        int[] iArr = this.mSearchSrcTextView.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.mSearchPlate.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.mSubmitArea.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    public SearchView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, C0419R.attr.searchViewStyle);
    }

    public SearchView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        boolean z;
        super(context, attributeSet, i);
        this.mSearchSrcTextViewBounds = new Rect();
        this.mSearchSrtTextViewBoundsExpanded = new Rect();
        this.mTemp = new int[2];
        this.mTemp2 = new int[2];
        this.mIsSearchMagIconButtonEnabled = false;
        this.mBlurMode = 2;
        this.mUseSVI = false;
        this.mUpdateDrawableStateRunnable = new Runnable() { // from class: androidx.appcompat.widget.SearchView.1
            @Override // java.lang.Runnable
            public void run() {
                SearchView.this.updateFocusedState();
            }
        };
        this.mReleaseCursorRunnable = new Runnable() { // from class: androidx.appcompat.widget.SearchView.2
            @Override // java.lang.Runnable
            public void run() {
                CursorAdapter cursorAdapter = SearchView.this.mSuggestionsAdapter;
                if (cursorAdapter instanceof SuggestionsAdapter) {
                    cursorAdapter.changeCursor(null);
                }
            }
        };
        this.mOutsideDrawablesCache = new WeakHashMap<>();
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: androidx.appcompat.widget.SearchView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchView searchView = SearchView.this;
                if (view == searchView.mSearchButton || view == searchView.mSearchMagIconButton) {
                    SearchView.this.onSearchClicked();
                    return;
                }
                SearchView searchView2 = SearchView.this;
                if (view == searchView2.mCloseButton) {
                    searchView2.onCloseClicked();
                    return;
                }
                if (view == searchView2.mGoButton) {
                    searchView2.onSubmitQuery();
                } else if (view == searchView2.mVoiceButton) {
                    searchView2.onVoiceClicked();
                } else if (view == searchView2.mSearchSrcTextView) {
                    searchView2.forceSuggestionQuery();
                }
            }
        };
        this.mOnClickListener = onClickListener;
        this.mTextKeyListener = new View.OnKeyListener() { // from class: androidx.appcompat.widget.SearchView.5
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i2, KeyEvent keyEvent) {
                InputMethodManager inputMethodManager;
                if (SearchView.this.mContext.getPackageManager().hasSystemFeature("com.sec.feature.folder_type") && (inputMethodManager = (InputMethodManager) SearchView.this.getContext().getSystemService("input_method")) != null && i2 == 23) {
                    inputMethodManager.viewClicked(view);
                    inputMethodManager.showSoftInput(view, 1);
                }
                SearchView searchView = SearchView.this;
                if (searchView.mSearchable == null) {
                    return false;
                }
                if (searchView.mSearchSrcTextView.isPopupShowing() && SearchView.this.mSearchSrcTextView.getListSelection() != -1) {
                    return SearchView.this.onSuggestionsKey(view, i2, keyEvent);
                }
                if (SearchView.this.mSearchSrcTextView.isEmpty() || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || (i2 != 66 && i2 != 160)) {
                    return false;
                }
                view.cancelLongPress();
                SearchView searchView2 = SearchView.this;
                searchView2.launchQuerySearch(0, null, searchView2.mSearchSrcTextView.getText().toString());
                return true;
            }
        };
        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() { // from class: androidx.appcompat.widget.SearchView.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                SearchView.this.onSubmitQuery();
                return true;
            }
        };
        this.mOnEditorActionListener = onEditorActionListener;
        AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() { // from class: androidx.appcompat.widget.SearchView.7
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                SearchView.this.onItemClicked(i2, 0, null);
            }
        };
        this.mOnItemClickListener = onItemClickListener;
        AdapterView.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() { // from class: androidx.appcompat.widget.SearchView.8
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j) {
                SearchView.this.onItemSelected(i2);
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        };
        this.mOnItemSelectedListener = onItemSelectedListener;
        this.mTextWatcher = new TextWatcher() { // from class: androidx.appcompat.widget.SearchView.9
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i4, int i5) {
                SearchView.this.onTextChanged(charSequence);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i4, int i5) {
            }
        };
        TintTypedArray tintTypedArrayObtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, C0419R.styleable.SearchView, i, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, C0419R.styleable.SearchView, attributeSet, tintTypedArrayObtainStyledAttributes.getWrappedTypeArray(), i, 0);
        LayoutInflater.from(context).inflate(tintTypedArrayObtainStyledAttributes.getResourceId(C0419R.styleable.SearchView_layout, C0419R.layout.sesl_search_view), (ViewGroup) this, true);
        this.mContext = context;
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(C0419R.id.search_src_text);
        this.mSearchSrcTextView = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.mSearchEditFrame = findViewById(C0419R.id.search_edit_frame);
        View viewFindViewById = findViewById(C0419R.id.search_plate);
        this.mSearchPlate = viewFindViewById;
        this.mSearchPlateFrame = findViewById(C0419R.id.search_plate_frame);
        this.mSearchPlateStroke = findViewById(C0419R.id.search_plate_stroke_overlay);
        View viewFindViewById2 = findViewById(C0419R.id.submit_area);
        this.mSubmitArea = viewFindViewById2;
        ImageView imageView = (ImageView) findViewById(C0419R.id.search_button);
        this.mSearchButton = imageView;
        ImageView imageView2 = (ImageView) findViewById(C0419R.id.search_go_btn);
        this.mGoButton = imageView2;
        ImageView imageView3 = (ImageView) findViewById(C0419R.id.search_close_btn);
        this.mCloseButton = imageView3;
        ImageView imageView4 = (ImageView) findViewById(C0419R.id.search_voice_btn);
        this.mVoiceButton = imageView4;
        ImageView imageView5 = (ImageView) findViewById(C0419R.id.search_more_btn);
        this.mMoreButton = imageView5;
        ImageView imageView6 = (ImageView) findViewById(C0419R.id.search_back_btn);
        this.mBackButton = imageView6;
        ImageView imageView7 = (ImageView) findViewById(C0419R.id.search_mag_icon);
        this.mSearchMagIconButton = imageView7;
        ViewCompat.setBackground(viewFindViewById, tintTypedArrayObtainStyledAttributes.getDrawable(C0419R.styleable.SearchView_queryBackground));
        ViewCompat.setBackground(viewFindViewById2, tintTypedArrayObtainStyledAttributes.getDrawable(C0419R.styleable.SearchView_submitBackground));
        this.mSearchIconResId = tintTypedArrayObtainStyledAttributes.getResourceId(C0419R.styleable.SearchView_searchIcon, 0);
        this.mIsBlurApplied = tintTypedArrayObtainStyledAttributes.getBoolean(C0419R.styleable.SearchView_seslSearchViewApplyBlur, false);
        this.mIsBottomSearchView = tintTypedArrayObtainStyledAttributes.getBoolean(C0419R.styleable.SearchView_seslIsBottomSearchView, false);
        imageView.setImageDrawable(tintTypedArrayObtainStyledAttributes.getDrawable(C0419R.styleable.SearchView_searchIcon));
        imageView2.setImageDrawable(tintTypedArrayObtainStyledAttributes.getDrawable(C0419R.styleable.SearchView_goIcon));
        imageView3.setImageDrawable(tintTypedArrayObtainStyledAttributes.getDrawable(C0419R.styleable.SearchView_closeIcon));
        imageView7.setImageDrawable(tintTypedArrayObtainStyledAttributes.getDrawable(C0419R.styleable.SearchView_searchIcon));
        this.mGVIVoiceIcon = tintTypedArrayObtainStyledAttributes.getDrawable(C0419R.styleable.SearchView_voiceIcon);
        this.mSVIVoiceIcon = tintTypedArrayObtainStyledAttributes.getDrawable(C0419R.styleable.SearchView_voiceIconSVI);
        updateVoiceButtonDrawable();
        this.mSearchHintIcon = tintTypedArrayObtainStyledAttributes.getDrawable(C0419R.styleable.SearchView_searchHintIcon);
        TooltipCompat.setTooltipText(imageView, imageView.getContentDescription());
        TooltipCompat.setTooltipText(imageView7, imageView7.getContentDescription());
        TooltipCompat.setTooltipText(imageView3, imageView3.getContentDescription());
        TooltipCompat.setTooltipText(imageView2, imageView2.getContentDescription());
        TooltipCompat.setTooltipText(imageView4, imageView4.getContentDescription());
        TooltipCompat.setTooltipText(imageView5, imageView5.getContentDescription());
        TooltipCompat.setTooltipText(imageView6, imageView6.getContentDescription());
        this.mSuggestionRowLayout = tintTypedArrayObtainStyledAttributes.getResourceId(C0419R.styleable.SearchView_suggestionRowLayout, C0419R.layout.sesl_search_dropdown_item_icons_2line);
        this.mSuggestionCommitIconResId = tintTypedArrayObtainStyledAttributes.getResourceId(C0419R.styleable.SearchView_commitIcon, 0);
        imageView.setOnClickListener(onClickListener);
        imageView3.setOnClickListener(onClickListener);
        imageView2.setOnClickListener(onClickListener);
        imageView4.setOnClickListener(onClickListener);
        imageView7.setOnClickListener(onClickListener);
        searchAutoComplete.setOnClickListener(onClickListener);
        searchAutoComplete.addTextChangedListener(this.mTextWatcher);
        searchAutoComplete.setOnEditorActionListener(onEditorActionListener);
        searchAutoComplete.setOnItemClickListener(onItemClickListener);
        searchAutoComplete.setOnItemSelectedListener(onItemSelectedListener);
        searchAutoComplete.setOnKeyListener(this.mTextKeyListener);
        searchAutoComplete.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: androidx.appcompat.widget.c
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z2) {
                this.f946a.lambda$new$0(view, z2);
            }
        });
        setIconifiedByDefault(tintTypedArrayObtainStyledAttributes.getBoolean(C0419R.styleable.SearchView_iconifiedByDefault, true));
        int dimensionPixelSize = tintTypedArrayObtainStyledAttributes.getDimensionPixelSize(C0419R.styleable.SearchView_android_maxWidth, -1);
        if (dimensionPixelSize != -1) {
            setMaxWidth(dimensionPixelSize);
        }
        this.mDefaultQueryHint = tintTypedArrayObtainStyledAttributes.getText(C0419R.styleable.SearchView_defaultQueryHint);
        this.mQueryHint = tintTypedArrayObtainStyledAttributes.getText(C0419R.styleable.SearchView_queryHint);
        int i2 = tintTypedArrayObtainStyledAttributes.getInt(C0419R.styleable.SearchView_android_imeOptions, -1);
        if (i2 != -1) {
            setImeOptions(i2);
        }
        int i4 = tintTypedArrayObtainStyledAttributes.getInt(C0419R.styleable.SearchView_android_inputType, -1);
        if (i4 != -1) {
            setInputType(i4);
        }
        setFocusable(tintTypedArrayObtainStyledAttributes.getBoolean(C0419R.styleable.SearchView_android_focusable, true));
        imageView7.setImageDrawable(tintTypedArrayObtainStyledAttributes.getDrawable(C0419R.styleable.SearchView_searchIcon));
        imageView.setImageDrawable(tintTypedArrayObtainStyledAttributes.getDrawable(C0419R.styleable.SearchView_searchIcon));
        Resources resources = this.mContext.getResources();
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 34) {
            this.mBoldTypeface = Typeface.create(Typeface.create("sec", 0), 600, false);
            z = true;
        } else {
            z = true;
            this.mBoldTypeface = Typeface.create(resources.getString(C0419R.string.sesl_font_family_regular), 1);
        }
        searchAutoComplete.setTypeface(this.mBoldTypeface);
        SeslSearchViewStyle.create(this.mContext, viewFindViewById.getBackground() == null ? false : z).apply(resources, searchAutoComplete, Arrays.asList(imageView2, imageView3, imageView4, imageView5, imageView));
        tintTypedArrayObtainStyledAttributes.recycle();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.mVoiceWebSearchIntent = intent;
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.mVoiceAppSearchIntent = intent2;
        intent2.addFlags(268435456);
        Intent intent3 = new Intent(SVI_ACTION);
        this.mSVoiceSearchIntent = intent3;
        intent3.addFlags(268435456);
        if (i5 < 33) {
            intent3.putExtra(SVI_INTENT_EXTRA, Locale.getDefault().toString());
        }
        View viewFindViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.mDropDownAnchor = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.appcompat.widget.SearchView.3
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
                    SearchView.this.adjustDropDownSizeAndPosition();
                }
            });
        }
        updateViewsVisibility(this.mIconifiedByDefault);
        updateQueryHint();
        this.mImm = (InputMethodManager) getContext().getSystemService("input_method");
        int field_SEM_AUTOFILL_ID = SeslTextViewReflector.getField_SEM_AUTOFILL_ID();
        if (field_SEM_AUTOFILL_ID != 0) {
            SeslTextViewReflector.semSetActionModeMenuItemEnabled(searchAutoComplete, field_SEM_AUTOFILL_ID, false);
        }
        seslCheckMaxFont();
        applySearchViewBlur();
        applyBottomSearchPlateStyle(resources);
    }

    private void setQuery(CharSequence charSequence) {
        this.mSearchSrcTextView.setText(charSequence);
        this.mSearchSrcTextView.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
        if (!this.mIsSearchMagIconButtonEnabled || this.mSearchSrcTextView.hasFocus()) {
            return;
        }
        updateSearchMagIconVisibility(TextUtils.isEmpty(charSequence) ? 0 : 8);
    }
}
