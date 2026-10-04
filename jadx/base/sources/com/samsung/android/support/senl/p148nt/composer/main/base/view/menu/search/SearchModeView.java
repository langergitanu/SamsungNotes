package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.search;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Handler;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.C0419R;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.appcompat.widget.SearchView;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.glance.AbstractC2821a;
import com.google.android.material.oneui.floatingdock.ViewOnTouchListenerC4799j;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.widget.search.VoiceButtonHelper;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.CustomToolbar;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.search.SearchModeContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.search.SearchModePresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerRequestCode;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SearchModeView implements SearchModeContract.IView {
    private static final int SEARCH_AUTO_NEXT_DELAY = 120;
    private static final int SEARCH_AUTO_NEXT_DELAY_DELTA = 3;
    private static final int SEARCH_DELAY = 300;
    private static final String TAG = Logger.createTag("SearchModeView");
    private final boolean SUPPORT_HONEY_VOICE_SEARCH;
    private final Runnable mAutoBackwardRunnable;
    private final Runnable mAutoForwardRunnable;
    private View mBackBtn;
    private ImageView mBackwardBtn;
    private View mDivider;
    private ImageView mForwardBtn;
    private final Fragment mFragment;
    private final Handler mHandler;
    private final Handler mHandlerNextSearch;
    private boolean mIsAutoNextSearch;
    private int mLastMultiWindowMode;
    private final View.OnLongClickListener mOnLongClickListenerBackWard;
    private final View.OnLongClickListener mOnLongClickListenerForward;
    private final View.OnTouchListener mOnTouchListener;
    private final SearchModePresenter mPresenter;
    private int mSearchDelayChange;
    private Runnable mSearchRunnable;
    private EditText mSearchText;
    private SearchView mSearchView;
    private ViewGroup mSearchViewContainer;
    private final ViewGroup mSystemBarTarget;
    private CustomToolbar mToolbar;

    public SearchModeView(Fragment fragment, SearchModePresenter searchModePresenter) {
        this.SUPPORT_HONEY_VOICE_SEARCH = 160000 >= 160000;
        this.mHandlerNextSearch = new Handler();
        this.mIsAutoNextSearch = false;
        this.mSearchDelayChange = 0;
        this.mAutoBackwardRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.search.SearchModeView.1
            @Override // java.lang.Runnable
            public void run() {
                SearchModeView.this.updateSearchDelayChange();
                SearchModeView.this.mPresenter.backward();
                if (SearchModeView.this.mIsAutoNextSearch) {
                    SearchModeView.this.mHandlerNextSearch.postDelayed(this, 120 - SearchModeView.this.mSearchDelayChange);
                }
            }
        };
        this.mAutoForwardRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.search.SearchModeView.2
            @Override // java.lang.Runnable
            public void run() {
                SearchModeView.this.updateSearchDelayChange();
                SearchModeView.this.mPresenter.forward();
                if (SearchModeView.this.mIsAutoNextSearch) {
                    SearchModeView.this.mHandlerNextSearch.postDelayed(this, 120 - SearchModeView.this.mSearchDelayChange);
                }
            }
        };
        this.mOnLongClickListenerForward = new View.OnLongClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.search.SearchModeView.8
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                SearchModeView.this.clearAutoNext(true);
                SearchModeView.this.mHandlerNextSearch.post(SearchModeView.this.mAutoForwardRunnable);
                return true;
            }
        };
        this.mOnLongClickListenerBackWard = new View.OnLongClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.search.SearchModeView.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                SearchModeView.this.clearAutoNext(true);
                SearchModeView.this.mHandlerNextSearch.post(SearchModeView.this.mAutoBackwardRunnable);
                return true;
            }
        };
        this.mOnTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.search.SearchModeView.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                    return false;
                }
                SearchModeView.this.clearAutoNext(false);
                return false;
            }
        };
        this.mFragment = fragment;
        this.mPresenter = searchModePresenter;
        searchModePresenter.setView(this);
        this.mSearchViewContainer = null;
        this.mHandler = new Handler();
        this.mSystemBarTarget = (ViewGroup) fragment.getActivity().findViewById(C9086R.id.composer_fragment_container);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adjustZoomButtonPosition(int i) {
        if (this.mFragment.getView() == null) {
            return;
        }
        View viewFindViewById = this.mFragment.getView().findViewById(C9086R.id.comp_zoom_view);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) viewFindViewById.getLayoutParams();
        if (i == 0) {
            marginLayoutParams.topMargin = viewFindViewById.getResources().getDimensionPixelOffset(C9086R.dimen.comp_zoom_view_vertical_margin);
        } else {
            marginLayoutParams.topMargin = viewFindViewById.getResources().getDimensionPixelOffset(C9086R.dimen.comp_zoom_view_vertical_margin) + i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAutoNext(boolean z) {
        this.mIsAutoNextSearch = z;
        this.mSearchDelayChange = 0;
        this.mHandlerNextSearch.removeCallbacks(this.mAutoForwardRunnable);
        this.mHandlerNextSearch.removeCallbacks(this.mAutoBackwardRunnable);
    }

    private int getActionBarHeight() {
        TypedValue typedValue = new TypedValue();
        FragmentActivity fragmentActivityRequireActivity = this.mFragment.requireActivity();
        if (fragmentActivityRequireActivity.getTheme().resolveAttribute(C0419R.attr.actionBarSize, typedValue, true)) {
            return TypedValue.complexToDimensionPixelSize(typedValue.data, fragmentActivityRequireActivity.getResources().getDisplayMetrics());
        }
        return 0;
    }

    private int getStatusBarHeight() {
        return WindowManagerCompat.getInstance().getStatusBarHeight(this.mSearchView.getContext());
    }

    private void initClearButton() {
        this.mSearchView.findViewById(C9086R.id.search_close_btn).setOnClickListener(new ViewOnClickListenerC10423a(this, 1));
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void initSearchText() {
        EditText editText = (EditText) this.mSearchView.findViewById(C9086R.id.search_src_text);
        this.mSearchText = editText;
        editText.setPrivateImeOptions("disableImage=true");
        this.mSearchText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(199) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.search.SearchModeView.13
            @Override // android.text.InputFilter.LengthFilter, android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i4, int i5) {
                CharSequence charSequenceFilter = super.filter(charSequence, i, i2, spanned, i4, i5);
                if (charSequenceFilter != null) {
                    ToastHandler.show(SearchModeView.this.mFragment.getContext(), SearchModeView.this.mFragment.getResources().getString(C9086R.string.ss_maximum_number_of_characters_exceeded, 199), 1);
                }
                return charSequenceFilter;
            }
        }});
        this.mSearchText.setOnTouchListener(new ViewOnTouchListenerC4799j(this, 19));
        this.mSearchText.setTextSize(17.0f);
    }

    private void initSearchView() {
        initSearchViewListener();
        initSearchText();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void initSearchViewContainer() {
        ViewGroup viewGroup = (ViewGroup) this.mFragment.getView().findViewById(C9086R.id.main_container);
        this.mFragment.getLayoutInflater().inflate(C9086R.layout.comp_search_layout, viewGroup);
        this.mSearchViewContainer = (ViewGroup) viewGroup.findViewById(C9086R.id.search_view_layout);
        this.mToolbar = (CustomToolbar) this.mFragment.getView().findViewById(C9086R.id.toolbar);
        this.mSearchViewContainer.setOnTouchListener(new View.OnTouchListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.search.SearchModeView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.mSearchViewContainer.setOnHoverListener(new View.OnHoverListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.search.SearchModeView.4
            @Override // android.view.View.OnHoverListener
            public boolean onHover(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.mDivider = this.mSearchViewContainer.findViewById(C9086R.id.search_view_divider);
        this.mForwardBtn = (ImageView) this.mSearchViewContainer.findViewById(C9086R.id.search_view_forward_btn);
        this.mBackwardBtn = (ImageView) this.mSearchViewContainer.findViewById(C9086R.id.search_view_backward_btn);
        this.mForwardBtn.setEnabled(false);
        this.mBackwardBtn.setEnabled(false);
        ViewCompat.getInstance().setTooltipText(this.mForwardBtn);
        ViewCompat.getInstance().setTooltipText(this.mBackwardBtn);
        setMoveButtonVisibility(false);
        this.mForwardBtn.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.search.SearchModeView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchModeView.this.mPresenter.forward();
                ComposerSA.insertLog(ComposerSAConstants.SCREEN_VIEW_303, ComposerSAConstants.EVENT_VIEW_SEARCH_NEXT);
            }
        });
        this.mBackwardBtn.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.search.SearchModeView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchModeView.this.mPresenter.backward();
                ComposerSA.insertLog(ComposerSAConstants.SCREEN_VIEW_303, ComposerSAConstants.EVENT_VIEW_SEARCH_PREVIOUS);
            }
        });
        if (FeatureInfo.isSearchSTTInComposerEnabled()) {
            this.mForwardBtn.setOnLongClickListener(this.mOnLongClickListenerForward);
            this.mForwardBtn.setOnTouchListener(this.mOnTouchListener);
            this.mBackwardBtn.setOnLongClickListener(this.mOnLongClickListenerBackWard);
            this.mBackwardBtn.setOnTouchListener(this.mOnTouchListener);
        }
        View viewFindViewById = viewGroup.findViewById(C9086R.id.floating_navigate_up);
        this.mBackBtn = viewFindViewById;
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.search.SearchModeView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchModeView.this.mPresenter.onBackPressed();
            }
        });
    }

    private void initSearchViewListener() {
        SearchView searchView = (SearchView) this.mSearchViewContainer.findViewById(C9086R.id.search_view_container);
        this.mSearchView = searchView;
        searchView.onActionViewExpanded();
        this.mSearchView.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.search.SearchModeView.11
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (SearchModeView.this.mPresenter == null || !SearchModeView.this.isShowing()) {
                    return;
                }
                AbstractC8014b.m7224z("onFocusChange# ", SearchModeView.TAG, z);
                if (z) {
                    SearchModeView.this.mPresenter.disableComposerFocusableInTouchMode();
                    SearchModeView.this.mPresenter.stopActionMode();
                } else {
                    SearchModeView.this.mPresenter.enableComposerFocusableInTouchMode();
                    SearchModeView.this.mPresenter.hideSoftInput(view);
                }
            }
        });
        this.mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.search.SearchModeView.12
            @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextChange(final String str) {
                SearchModeView.this.mHandler.removeCallbacks(SearchModeView.this.mSearchRunnable);
                SearchModeView.this.mSearchRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.search.SearchModeView.12.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (SearchModeView.this.mPresenter == null) {
                            return;
                        }
                        if (FeatureInfo.isSearchSTTInComposerEnabled()) {
                            SearchModeView.this.mPresenter.searchSTT(str, false);
                        }
                        SearchModeView.this.mPresenter.search(str);
                        SearchModeView.this.mPresenter.stopActionMode();
                        SearchModeView.this.mSearchRunnable = null;
                    }
                };
                SearchModeView.this.mHandler.postDelayed(SearchModeView.this.mSearchRunnable, 300L);
                if (!TextUtils.isEmpty(str)) {
                    SearchModeView.this.setMoveButtonVisibility(true);
                    return false;
                }
                SearchModeView.this.setMoveButtonVisibility(false);
                SearchModeView.this.mPresenter.clearSearchInfo();
                ComposerSA.insertLog(ComposerSAConstants.SCREEN_VIEW_303, ComposerSAConstants.EVENT_VIEW_SEARCH_CLEAR);
                return false;
            }

            @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextSubmit(final String str) {
                if (SearchModeView.this.mSearchRunnable == null) {
                    SearchModeView.this.onQueryTextSearchSubmit(str);
                    return false;
                }
                SearchModeView.this.mHandler.removeCallbacks(SearchModeView.this.mSearchRunnable);
                SearchModeView.this.mSearchRunnable.run();
                SearchModeView.this.mSearchRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.search.SearchModeView.12.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (SearchModeView.this.mPresenter == null) {
                            return;
                        }
                        SearchModeView.this.onQueryTextSearchSubmit(str);
                        SearchModeView.this.mSearchRunnable = null;
                    }
                };
                SearchModeView.this.mHandler.postDelayed(SearchModeView.this.mSearchRunnable, 300L);
                return false;
            }
        });
        initClearButton();
        initVoiceButton();
    }

    private void initVoiceButton() {
        if (this.mFragment.getActivity() == null) {
            return;
        }
        VoiceButtonHelper.setSearchableInfo(this.mSearchView, this.mFragment.getActivity().getComponentName());
        VoiceButtonHelper.setVoiceButtonListener(this.mSearchView, new ViewOnClickListenerC10423a(this, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initClearButton$1(View view) {
        setSearchText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$initSearchText$0(View view, MotionEvent motionEvent) {
        SearchModePresenter searchModePresenter = this.mPresenter;
        if (searchModePresenter == null) {
            return false;
        }
        searchModePresenter.setSipAdjustResize();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initVoiceButton$2(View view) {
        if (this.mFragment.getActivity() == null) {
            return;
        }
        boolean zIsSviEnabled = VoiceButtonHelper.isSviEnabled(this.mSearchView);
        Intent intentMakeVoiceRecognizerIntent = VoiceButtonHelper.makeVoiceRecognizerIntent(zIsSviEnabled);
        this.mPresenter.hideSoftInput(this.mSearchView);
        this.mFragment.getActivity().startActivityForResult(intentMakeVoiceRecognizerIntent, (zIsSviEnabled ? ComposerRequestCode.SearchVoiceSvi : ComposerRequestCode.SearchVoice).getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onQueryTextSearchSubmit(String str) {
        if (FeatureInfo.isSearchSTTInComposerEnabled()) {
            this.mPresenter.submitSearchSTT(str, false);
        } else {
            this.mPresenter.forward();
        }
    }

    private void setHiddenWindowState() {
        if (isShowing()) {
            if (!isStatusBarHidden() && !WindowManagerCompat.getInstance().isMultiWindowMode(this.mFragment.getActivity())) {
                ((ViewGroup.MarginLayoutParams) this.mSystemBarTarget.getLayoutParams()).topMargin = getStatusBarHeight();
            }
            WindowManagerCompat.getInstance().disableSystemBarInsets(this.mSystemBarTarget);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMoveButtonVisibility(boolean z) {
        if (z) {
            this.mDivider.setVisibility(0);
            this.mForwardBtn.setVisibility(0);
            this.mBackwardBtn.setVisibility(0);
        } else {
            this.mDivider.setVisibility(8);
            this.mForwardBtn.setVisibility(8);
            this.mBackwardBtn.setVisibility(8);
        }
    }

    private void setShowingWindowState() {
        WindowManagerCompat.getInstance().updateSystemBarInsets(this.mSystemBarTarget, new OnApplyWindowInsetsListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.search.SearchModeView.14
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
                Insets insets2 = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.displayCutout());
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                marginLayoutParams.leftMargin = Math.max(insets.left, insets2.left);
                marginLayoutParams.bottomMargin = insets.bottom;
                marginLayoutParams.rightMargin = Math.max(insets.right, insets2.right);
                marginLayoutParams.topMargin = 0;
                view.setLayoutParams(marginLayoutParams);
                if (SearchModeView.this.isShowing()) {
                    ((ViewGroup.MarginLayoutParams) SearchModeView.this.mBackBtn.getLayoutParams()).topMargin = SearchModeView.this.mBackBtn.getResources().getDimensionPixelSize(C9086R.dimen.floating_navigation_top_margin) + insets.top;
                    SearchModeView.this.adjustZoomButtonPosition(insets.top);
                }
                return WindowInsetsCompat.CONSUMED;
            }
        });
    }

    private void setThemeToView(ViewGroup viewGroup, int i) {
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof ViewGroup) {
                setThemeToView((ViewGroup) childAt, i);
            } else if (childAt instanceof ImageView) {
                ((ImageView) childAt).setColorFilter(i);
                childAt.invalidate();
            } else if (childAt instanceof TextView) {
                ((TextView) childAt).setTextColor(i);
            }
        }
    }

    private void setVisibilityView(int i) {
        CustomToolbar customToolbar = this.mToolbar;
        if (customToolbar != null) {
            if (i == 8) {
                SearchModePresenter searchModePresenter = this.mPresenter;
                if (searchModePresenter == null || !searchModePresenter.isFullScreenMode()) {
                    this.mToolbar.showToolbar(null, false);
                }
            } else {
                customToolbar.hideToolbar(null, false);
            }
        }
        ViewGroup viewGroup = this.mSearchViewContainer;
        if (viewGroup != null) {
            viewGroup.setVisibility(i);
        }
        SearchView searchView = this.mSearchView;
        if (searchView != null) {
            searchView.setVisibility(i);
        }
        View view = this.mBackBtn;
        if (view != null) {
            view.setVisibility(i);
        }
        EditText editText = this.mSearchText;
        if (editText != null) {
            editText.setVisibility(i);
        }
        ImageView imageView = this.mForwardBtn;
        if (imageView != null) {
            imageView.setVisibility(i);
        }
        ImageView imageView2 = this.mBackwardBtn;
        if (imageView2 != null) {
            imageView2.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSearchDelayChange() {
        int i = this.mSearchDelayChange;
        if (i <= 108) {
            this.mSearchDelayChange = i + 3;
        }
    }

    public int getVariableTopHeight(int i) {
        int statusBarHeight = 0;
        if (i == 2) {
            return 0;
        }
        boolean zIsStatusBarHidden = isStatusBarHidden(i);
        int actionBarHeight = zIsStatusBarHidden ? getActionBarHeight() : this.mFragment.getResources().getDimensionPixelSize(C9086R.dimen.fragment_toolbar_height);
        if (this.mLastMultiWindowMode != 1 && !zIsStatusBarHidden) {
            statusBarHeight = getStatusBarHeight();
        }
        String str = TAG;
        StringBuilder sbM778t = AbstractC0541b.m778t(statusBarHeight, "getVariableTopHeight# s:", " w: ");
        AbstractC2821a.m2235z(sbM778t, this.mLastMultiWindowMode, actionBarHeight, " appbarH: ", " + statusH: ");
        sbM778t.append(statusBarHeight);
        Logger.m10999d(str, sbM778t.toString());
        return actionBarHeight + statusBarHeight;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.search.SearchModeContract.IView
    public View getView() {
        return this.mSearchView;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.search.SearchModeContract.IView
    public boolean hasFocusSearchText() {
        EditText editText = this.mSearchText;
        return editText != null && editText.hasFocus();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.search.SearchModeContract.IView
    public void hide() {
        Logger.m11003i(TAG, "hide#");
        EditText editText = this.mSearchText;
        if (editText != null) {
            editText.setText("");
            this.mSearchText.clearFocus();
            this.mHandler.removeCallbacks(this.mSearchRunnable);
        }
        setHiddenWindowState();
        setVisibilityView(8);
        SearchModePresenter searchModePresenter = this.mPresenter;
        if (searchModePresenter != null) {
            searchModePresenter.search("");
            this.mPresenter.releaseListener();
            ViewGroup viewGroup = this.mSearchViewContainer;
            if (viewGroup != null) {
                this.mPresenter.setMargin(false, getVariableTopHeight(viewGroup.getResources().getConfiguration().orientation));
            }
            adjustZoomButtonPosition(0);
            this.mPresenter.setFadingEdgeEffectEnabled(false);
        }
    }

    public void initView() {
        initSearchViewContainer();
        initSearchView();
        setVisibilityView(8);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.search.SearchModeContract.IView
    public boolean isShowing() {
        ViewGroup viewGroup = this.mSearchViewContainer;
        return viewGroup != null && viewGroup.getVisibility() == 0;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.search.SearchModeContract.IView
    public boolean isStatusBarHidden() {
        return isStatusBarHidden(this.mFragment.requireActivity().getResources().getConfiguration().orientation);
    }

    public void onConfigurationChanged(Configuration configuration, boolean z) {
        if (isShowing()) {
            int multiWindowMode = WindowManagerCompat.getInstance().getMultiWindowMode(configuration);
            boolean z2 = multiWindowMode != this.mLastMultiWindowMode;
            this.mLastMultiWindowMode = multiWindowMode;
            if (z || z2) {
                onConfigurationChanged(configuration);
            }
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.search.SearchModeContract.IView
    public void release() {
        this.mHandler.removeCallbacks(this.mSearchRunnable);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.search.SearchModeContract.IView
    public void setColorTheme(int i, boolean z, boolean z2) {
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.search.SearchModeContract.IView
    public void setSearchText(String str) {
        this.mSearchText.setText(str);
        this.mSearchText.setSelection(str.length());
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.search.SearchModeContract.IView
    public void show(String str) {
        if (this.mSearchViewContainer == null) {
            initView();
        }
        this.mLastMultiWindowMode = WindowManagerCompat.getInstance().getMultiWindowMode(this.mFragment.requireActivity());
        this.mPresenter.setMargin(true, getVariableTopHeight(this.mSearchView.getResources().getConfiguration().orientation));
        setShowingWindowState();
        setVisibilityView(0);
        setMoveButtonVisibility(false);
        if (TextUtils.isEmpty(str)) {
            this.mSearchText.requestFocus();
            updateMoveButton(false, false);
            this.mPresenter.clearSearchInfo();
        } else {
            setSearchText(str);
            this.mForwardBtn.requestFocus();
        }
        setColorTheme(this.mPresenter.getBackgroundColor(), this.mPresenter.isBackgroundColorInverted(), this.mPresenter.hasBackgroundImage());
        this.mPresenter.disableComposerFocusableInTouchMode();
        this.mPresenter.setListener();
        this.mPresenter.setFadingEdgeEffectEnabled(true);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.search.SearchModeContract.IView
    public void updateMoveButton(boolean z, boolean z2) {
        String str = TAG;
        Logger.m10999d(str, "updateMoveButton# " + z + " / " + z2);
        boolean zHasFocus = this.mForwardBtn.hasFocus();
        boolean zHasFocus2 = this.mBackwardBtn.hasFocus();
        this.mForwardBtn.setEnabled(z);
        this.mBackwardBtn.setEnabled(z2);
        this.mForwardBtn.setAlpha(z ? 1.0f : 0.4f);
        this.mBackwardBtn.setAlpha(z2 ? 1.0f : 0.4f);
        if ((!z || !z2) && FeatureInfo.isSearchSTTInComposerEnabled()) {
            clearAutoNext(false);
        }
        if (z == z2) {
            return;
        }
        Logger.m10999d(str, "updateMoveButton# focus: " + zHasFocus + " / " + zHasFocus2);
        if (z && zHasFocus2) {
            this.mForwardBtn.requestFocus();
        } else if (z2 && zHasFocus) {
            this.mBackwardBtn.requestFocus();
        }
    }

    private boolean isStatusBarHidden(int i) {
        return !WindowManagerCompat.getInstance().canNotHideStatusBar(this.mFragment.requireActivity()) && WindowManagerCompat.getInstance().shouldHideStatusBar(this.mFragment.requireActivity(), i);
    }

    private void onConfigurationChanged(Configuration configuration) {
        int i = configuration.orientation;
        if (i == 2) {
            this.mPresenter.setMargin(true, 0);
        } else {
            this.mPresenter.setMargin(true, getVariableTopHeight(i));
        }
    }
}
