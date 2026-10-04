package com.samsung.android.support.senl.p148nt.app.settings.detail;

import android.animation.LayoutTransition;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.oneui.floatingactioncontainer.FloatingBottomLayout;
import com.google.android.material.oneui.floatingactioncontainer.FloatingToolbarLayout;
import com.google.android.material.tabs.TabLayout;
import com.samsung.android.sdk.pen.recoguifeature.crowdhwrdata.ViewOnLayoutChangeListenerC7473a;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.listener.OnBackKeyListener;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.SettingsSAConstants;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.NotesFragment;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.RunnableC8515c;
import com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseNonPreferenceFragment;
import com.samsung.android.support.senl.p148nt.app.settings.detail.style.view.pager.DefaultNoteStylePagerAdapter;
import com.samsung.android.support.senl.p148nt.app.settings.detail.style.view.pager.page.StyleOfNewNotesPage;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.DisplayUtils;
import com.samsung.android.support.senl.p148nt.base.winset.view.AbsViewPager;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 D2\u00020\u00012\u00020\u0002:\u0001DB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u001a\u001a\u00020\u00182\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0010H\u0002J\b\u0010\u001d\u001a\u00020\u0018H\u0002J\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0010H\u0002J\u0010\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u0016H\u0016J\u0012\u0010!\u001a\u00020\u00182\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u0018H\u0002J\b\u0010&\u001a\u00020\u0018H\u0002J\b\u0010'\u001a\u00020\u0018H\u0016J\n\u0010(\u001a\u0004\u0018\u00010\u0014H\u0016J\n\u0010)\u001a\u0004\u0018\u00010*H\u0002J\b\u0010+\u001a\u00020\u0018H\u0016J\"\u0010,\u001a\u00020\u00182\u0006\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00062\b\u0010/\u001a\u0004\u0018\u000100H\u0016J+\u00101\u001a\u00020\u00182\u0006\u0010-\u001a\u00020\u00062\f\u00102\u001a\b\u0012\u0004\u0012\u000204032\u0006\u00105\u001a\u000206H\u0016¢\u0006\u0002\u00107J\u0010\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0016J\b\u0010<\u001a\u00020\u0018H\u0002J\u000e\u0010=\u001a\u00020\u00182\u0006\u0010>\u001a\u000209J\b\u0010?\u001a\u000209H\u0016J\u0010\u0010?\u001a\u0002092\u0006\u0010@\u001a\u00020\u0006H\u0002J\b\u0010A\u001a\u00020\u0018H\u0002J\u0010\u0010B\u001a\u00020\u00182\u0006\u0010C\u001a\u00020*H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006E"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/detail/SettingsDefaultNoteStyleFragment;", "Lcom/samsung/android/support/senl/nt/app/settings/common/component/SettingsBaseNonPreferenceFragment;", "Lcom/samsung/android/support/senl/nt/app/common/listener/OnBackKeyListener;", "<init>", "()V", "mCurrentPage", "", "mViewPager", "Lcom/samsung/android/support/senl/nt/base/winset/view/AbsViewPager;", "mTabLayout", "Lcom/google/android/material/tabs/TabLayout;", "mPagerAdapter", "Lcom/samsung/android/support/senl/nt/app/settings/detail/style/view/pager/DefaultNoteStylePagerAdapter;", "mOnBackPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "initPagerAdapter", "initViewPager", "rootView", "updateBlur", "initTabLayout", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "outState", "onViewStateRestored", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "updateViewPagerWidth", "updateViewPagerHeight", "onResume", "getSettingContents", "getNestedScrollView", "Landroidx/core/widget/NestedScrollView;", "onDestroy", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "setBackPressedCallback", "updateBackPressedCallBack", "isEnabled", "onBackKeyDown", "position", "setNestedScrollViewToFloatingView", "addBottomMarginForNestedScrollView", "nestedScrollView", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSettingsDefaultNoteStyleFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SettingsDefaultNoteStyleFragment.kt\ncom/samsung/android/support/senl/nt/app/settings/detail/SettingsDefaultNoteStyleFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,368:1\n1#2:369\n*E\n"})
public final class SettingsDefaultNoteStyleFragment extends SettingsBaseNonPreferenceFragment implements OnBackKeyListener {

    @NotNull
    private static final String KEY_CURRENT_PAGE = "key_current_page";

    @NotNull
    public static final String TAG = "SettingsDefaultNoteStyleFragment";
    private int mCurrentPage;

    @Nullable
    private OnBackPressedCallback mOnBackPressedCallback;

    @Nullable
    private DefaultNoteStylePagerAdapter mPagerAdapter;

    @Nullable
    private TabLayout mTabLayout;

    @Nullable
    private AbsViewPager mViewPager;

    private final void addBottomMarginForNestedScrollView(NestedScrollView nestedScrollView) {
        ViewGroup.LayoutParams layoutParams = nestedScrollView.getChildAt(0).getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            FloatingBottomLayout floatingBottomLayout = getFloatingBottomLayout();
            marginLayoutParams.bottomMargin = floatingBottomLayout != null ? floatingBottomLayout.getMeasuredHeight() : marginLayoutParams.bottomMargin;
        }
    }

    private final NestedScrollView getNestedScrollView() {
        AbsViewPager absViewPager;
        int i = this.mCurrentPage;
        if (i != 0) {
            if (i == 1 && (absViewPager = this.mViewPager) != null) {
                return (NestedScrollView) absViewPager.findViewById(C8003R.id.comp_template_view_pager_container_scroll_view);
            }
            return null;
        }
        AbsViewPager absViewPager2 = this.mViewPager;
        if (absViewPager2 != null) {
            return (NestedScrollView) absViewPager2.findViewById(C8003R.id.layout_style_container_scroll_view);
        }
        return null;
    }

    private final void initPagerAdapter(Bundle savedInstanceState) {
        this.mPagerAdapter = new DefaultNoteStylePagerAdapter(this, savedInstanceState, new DefaultNoteStylePagerAdapter.Contract() { // from class: com.samsung.android.support.senl.nt.app.settings.detail.SettingsDefaultNoteStyleFragment.initPagerAdapter.1
            @Override // com.samsung.android.support.senl.nt.app.settings.detail.style.view.pager.DefaultNoteStylePagerAdapter.Contract
            public boolean isCallFromOtherApps() {
                return SettingsBaseNonPreferenceFragment.isCallFromOtherApps$default(SettingsDefaultNoteStyleFragment.this, false, 1, null);
            }

            @Override // com.samsung.android.support.senl.nt.app.settings.detail.style.view.pager.DefaultNoteStylePagerAdapter.Contract
            public void updateBackPressedCallBack(boolean isEnabled) {
                SettingsDefaultNoteStyleFragment.this.updateBackPressedCallBack(isEnabled);
            }
        });
    }

    private final void initTabLayout(View rootView) {
        TabLayout tabLayout = (TabLayout) rootView.findViewById(C8003R.id.default_note_style_tab_layout);
        if (tabLayout == null) {
            return;
        }
        this.mTabLayout = tabLayout;
        ViewGroup viewGroup = (ViewGroup) tabLayout.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(tabLayout);
        }
        FloatingBottomLayout floatingBottomLayout = getFloatingBottomLayout();
        if (floatingBottomLayout == null) {
            return;
        }
        floatingBottomLayout.removeAllViews();
        floatingBottomLayout.addView(tabLayout);
        tabLayout.setupWithViewPager(this.mViewPager);
        int tabCount = tabLayout.getTabCount();
        for (int i = 0; i < tabCount; i++) {
            TabLayout.Tab tabAt = tabLayout.getTabAt(i);
            if (tabAt != null) {
                TabLayout.Tab tab = tabAt.view.getTab();
                if (tab != null) {
                    DefaultNoteStylePagerAdapter defaultNoteStylePagerAdapter = this.mPagerAdapter;
                    Intrinsics.checkNotNull(defaultNoteStylePagerAdapter);
                    tab.setText(defaultNoteStylePagerAdapter.getPageTitle(i));
                }
                TabLayout.Tab tab2 = tabAt.view.getTab();
                if (tab2 != null) {
                    DefaultNoteStylePagerAdapter defaultNoteStylePagerAdapter2 = this.mPagerAdapter;
                    Intrinsics.checkNotNull(defaultNoteStylePagerAdapter2);
                    tab2.setIcon(defaultNoteStylePagerAdapter2.getPageIcon(i));
                }
            }
        }
        FloatingBottomLayout floatingBottomLayout2 = getFloatingBottomLayout();
        if (floatingBottomLayout2 != null) {
            TabLayout tabLayout2 = this.mTabLayout;
            Intrinsics.checkNotNull(tabLayout2);
            floatingBottomLayout2.addBlurInvalidateTargetViews(CollectionsKt.listOf(tabLayout2));
            floatingBottomLayout2.invalidateBlurTargetView();
        }
    }

    private final void initViewPager(View rootView) {
        AbsViewPager absViewPager = (AbsViewPager) rootView.findViewById(C8003R.id.default_note_style_viewpager);
        if (absViewPager == null) {
            return;
        }
        this.mViewPager = absViewPager;
        if (Build.VERSION.SDK_INT < 30) {
            ViewCompat.setOnApplyWindowInsetsListener(absViewPager, null);
            absViewPager.setOnApplyWindowInsetsListener(null);
        }
        absViewPager.setPagingEnabled(false);
        absViewPager.setAdapter(this.mPagerAdapter);
        absViewPager.setCurrentItem(this.mCurrentPage);
        absViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.samsung.android.support.senl.nt.app.settings.detail.SettingsDefaultNoteStyleFragment$initViewPager$1$1
            private float pageOffset;

            private final void sendPageSALogging(int page) {
                if (page == 0) {
                    CommonSamsungAnalytics.INSTANCE.insertLog("510", SettingsSAConstants.EVENT_SETTINGS_PAGE_STYLE);
                } else {
                    if (page == 1) {
                        CommonSamsungAnalytics.INSTANCE.insertLog("510", SettingsSAConstants.EVENT_SETTINGS_PAGE_TEMPLATE);
                        return;
                    }
                    MainLogger.m7255e(SettingsDefaultNoteStyleFragment.TAG, "sendPageSALogging# unexpected page: " + page);
                }
            }

            public final float getPageOffset() {
                return this.pageOffset;
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                TabLayout tabLayout;
                float f = this.pageOffset;
                if (((f < 0.5f && 0.5f < positionOffset) || (positionOffset < 0.5f && 0.5f < f)) && (tabLayout = this.this$0.mTabLayout) != null) {
                    tabLayout.invalidate();
                }
                this.pageOffset = positionOffset;
                this.this$0.updateBlur();
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int page) {
                if (page == 1) {
                    this.this$0.onBackKeyDown(page);
                }
                this.this$0.mCurrentPage = page;
                DefaultNoteStylePagerAdapter defaultNoteStylePagerAdapter = this.this$0.mPagerAdapter;
                if (defaultNoteStylePagerAdapter != null) {
                    defaultNoteStylePagerAdapter.updateScrollStyle();
                }
                this.this$0.updateViewPagerHeight();
                sendPageSALogging(page);
                this.this$0.setNestedScrollViewToFloatingView();
            }

            public final void setPageOffset(float f) {
                this.pageOffset = f;
            }
        });
        absViewPager.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC7473a(absViewPager, this, 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewPager$lambda$1$lambda$0(final AbsViewPager absViewPager, final SettingsDefaultNoteStyleFragment settingsDefaultNoteStyleFragment, View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
        LayoutTransition layoutTransition;
        LinearLayout linearLayout = (LinearLayout) absViewPager.findViewById(C8003R.id.layout_style_animation_container);
        if (linearLayout == null || (layoutTransition = linearLayout.getLayoutTransition()) == null) {
            return;
        }
        layoutTransition.addTransitionListener(new LayoutTransition.TransitionListener() { // from class: com.samsung.android.support.senl.nt.app.settings.detail.SettingsDefaultNoteStyleFragment$initViewPager$1$2$1
            @Override // android.animation.LayoutTransition.TransitionListener
            public void endTransition(LayoutTransition transition, ViewGroup container, View view2, int transitionType) {
                LayoutTransition layoutTransition2;
                FloatingBottomLayout floatingBottomLayout = this.this$0.getFloatingBottomLayout();
                if (floatingBottomLayout != null) {
                    floatingBottomLayout.invalidateBlurTargetView();
                }
                LinearLayout linearLayout2 = (LinearLayout) absViewPager.findViewById(C8003R.id.layout_style_animation_container);
                if (linearLayout2 == null || (layoutTransition2 = linearLayout2.getLayoutTransition()) == null) {
                    return;
                }
                layoutTransition2.removeTransitionListener(this);
            }

            @Override // android.animation.LayoutTransition.TransitionListener
            public void startTransition(LayoutTransition transition, ViewGroup container, View view2, int transitionType) {
                FloatingBottomLayout floatingBottomLayout = this.this$0.getFloatingBottomLayout();
                if (floatingBottomLayout != null) {
                    floatingBottomLayout.invalidateBlurTargetView();
                }
            }
        });
    }

    private final void setBackPressedCallback() {
        MainLogger.m7254d(TAG, "setBackPressedCallback");
        this.mOnBackPressedCallback = new OnBackPressedCallback() { // from class: com.samsung.android.support.senl.nt.app.settings.detail.SettingsDefaultNoteStyleFragment.setBackPressedCallback.1
            {
                super(true);
            }

            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                MainLogger.m7254d(NotesFragment.TAG, "setBackPressedCallback# handleOnBackPressed");
                if (SettingsDefaultNoteStyleFragment.this.onBackKeyDown()) {
                    return;
                }
                setEnabled(false);
                SettingsDefaultNoteStyleFragment.this.requireActivity().onBackPressed();
            }
        };
        OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        OnBackPressedCallback onBackPressedCallback = this.mOnBackPressedCallback;
        Intrinsics.checkNotNull(onBackPressedCallback);
        onBackPressedDispatcher.addCallback(this, onBackPressedCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setNestedScrollViewToFloatingView() {
        View view = getView();
        if (view != null) {
            view.post(new RunnableC8778c(this, 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setNestedScrollViewToFloatingView$lambda$9(SettingsDefaultNoteStyleFragment settingsDefaultNoteStyleFragment) throws Exception {
        NestedScrollView nestedScrollView = settingsDefaultNoteStyleFragment.getNestedScrollView();
        if (nestedScrollView == null) {
            return;
        }
        FloatingToolbarLayout floatingToolbarLayout = settingsDefaultNoteStyleFragment.getFloatingToolbarLayout();
        if (floatingToolbarLayout != null) {
            floatingToolbarLayout.setNestedScrollView(nestedScrollView);
        }
        FloatingBottomLayout floatingBottomLayout = settingsDefaultNoteStyleFragment.getFloatingBottomLayout();
        if (floatingBottomLayout != null) {
            floatingBottomLayout.setNestedScrollView(nestedScrollView);
        }
        nestedScrollView.seslSetFadingEdgeEnabled(true, true);
        nestedScrollView.seslSetFadingEdgeColor(settingsDefaultNoteStyleFragment.getResources().getColor(C8003R.color.window_background_color, null));
        settingsDefaultNoteStyleFragment.addBottomMarginForNestedScrollView(nestedScrollView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateBlur() {
        TabLayout tabLayout = this.mTabLayout;
        if (tabLayout != null) {
            tabLayout.post(new RunnableC8778c(this, 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateBlur$lambda$3(SettingsDefaultNoteStyleFragment settingsDefaultNoteStyleFragment) throws Exception {
        FloatingBottomLayout floatingBottomLayout = settingsDefaultNoteStyleFragment.getFloatingBottomLayout();
        if (floatingBottomLayout != null) {
            ViewGroup settingContents = settingsDefaultNoteStyleFragment.getSettingContents();
            if (settingContents instanceof NestedScrollView) {
                floatingBottomLayout.setNestedScrollView((NestedScrollView) settingContents);
            }
            TabLayout tabLayout = settingsDefaultNoteStyleFragment.mTabLayout;
            Intrinsics.checkNotNull(tabLayout);
            floatingBottomLayout.addBlurInvalidateTargetViews(CollectionsKt.listOf(tabLayout));
            floatingBottomLayout.invalidateBlurTargetView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void updateViewPagerHeight() {
        AbsViewPager absViewPager = this.mViewPager;
        if (absViewPager == null) {
            return;
        }
        Intrinsics.checkNotNull(absViewPager);
        ViewGroup.LayoutParams layoutParams = absViewPager.getLayoutParams();
        if (getResources().getConfiguration().orientation != 2) {
            WindowManagerCompat.Companion companion = WindowManagerCompat.INSTANCE;
            if (companion.getInstance().isMultiWindowMode(getActivity()) || companion.getInstance().isFreeFormWindow(getActivity())) {
                Integer windowHeight = DisplayUtils.getWindowHeight(getContext());
                AbsViewPager absViewPager2 = this.mViewPager;
                Intrinsics.checkNotNull(absViewPager2);
                View childAt = absViewPager2.getChildAt(this.mCurrentPage);
                if (childAt != null) {
                    childAt.measure(0, View.MeasureSpec.makeMeasureSpec(0, 0));
                    windowHeight = windowHeight != null ? Integer.valueOf((int) Math.min(windowHeight.intValue(), childAt.getMeasuredHeight())) : null;
                }
                if (windowHeight != null) {
                    layoutParams.height = windowHeight.intValue();
                }
            } else {
                layoutParams.height = -1;
            }
        }
        AbsViewPager absViewPager3 = this.mViewPager;
        Intrinsics.checkNotNull(absViewPager3);
        absViewPager3.setLayoutParams(layoutParams);
    }

    private final void updateViewPagerWidth() {
        TabLayout tabLayout = this.mTabLayout;
        if (tabLayout != null) {
            tabLayout.post(new RunnableC8515c(this, tabLayout, 6));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateViewPagerWidth$lambda$7$lambda$6(SettingsDefaultNoteStyleFragment settingsDefaultNoteStyleFragment, TabLayout tabLayout) {
        if (DeviceInfo.isVSTModel()) {
            DisplayUtils.updateViewMarginByFlexibleSpacingForVst(settingsDefaultNoteStyleFragment.getActivity(), tabLayout);
        } else {
            DisplayUtils.updateViewMarginByFlexibleSpacing(settingsDefaultNoteStyleFragment.getActivity(), tabLayout);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseNonPreferenceFragment
    @Nullable
    public ViewGroup getSettingContents() {
        return getNestedScrollView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        DefaultNoteStylePagerAdapter defaultNoteStylePagerAdapter = this.mPagerAdapter;
        Intrinsics.checkNotNull(defaultNoteStylePagerAdapter);
        defaultNoteStylePagerAdapter.onActivityResult(this.mCurrentPage, requestCode, resultCode, data);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.common.listener.OnBackKeyListener
    public boolean onBackKeyDown() {
        return onBackKeyDown(this.mCurrentPage);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseNonPreferenceFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        AbsViewPager absViewPager = this.mViewPager;
        if (absViewPager != null) {
            absViewPager.setCurrentItem(this.mCurrentPage);
        }
        updateViewPagerWidth();
        updateViewPagerHeight();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(C8003R.layout.settings_default_note_style_fragment, container, false);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseNonPreferenceFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        DefaultNoteStylePagerAdapter defaultNoteStylePagerAdapter = this.mPagerAdapter;
        Intrinsics.checkNotNull(defaultNoteStylePagerAdapter);
        defaultNoteStylePagerAdapter.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        DefaultNoteStylePagerAdapter defaultNoteStylePagerAdapter = this.mPagerAdapter;
        if (defaultNoteStylePagerAdapter == null) {
            return super.onOptionsItemSelected(item);
        }
        Intrinsics.checkNotNull(defaultNoteStylePagerAdapter);
        return defaultNoteStylePagerAdapter.onOptionsItemSelected(this.mCurrentPage, item);
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int requestCode, @NotNull String[] permissions, @NotNull int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        DefaultNoteStylePagerAdapter defaultNoteStylePagerAdapter = this.mPagerAdapter;
        Intrinsics.checkNotNull(defaultNoteStylePagerAdapter);
        defaultNoteStylePagerAdapter.onRequestPermissionsResult(this.mCurrentPage, requestCode, permissions, grantResults);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseNonPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        DefaultNoteStylePagerAdapter defaultNoteStylePagerAdapter = this.mPagerAdapter;
        Intrinsics.checkNotNull(defaultNoteStylePagerAdapter);
        defaultNoteStylePagerAdapter.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_CURRENT_PAGE, this.mCurrentPage);
        DefaultNoteStylePagerAdapter defaultNoteStylePagerAdapter = this.mPagerAdapter;
        Intrinsics.checkNotNull(defaultNoteStylePagerAdapter);
        defaultNoteStylePagerAdapter.onSaveInstanceState(outState);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        if (savedInstanceState != null) {
            this.mCurrentPage = savedInstanceState.getInt(KEY_CURRENT_PAGE);
        }
        AbstractC8014b.m7201c(this.mCurrentPage, "onActivityCreated# mCurrentPage: ", TAG);
        initPagerAdapter(savedInstanceState);
        initViewPager(view);
        initTabLayout(view);
        updateViewPagerWidth();
        updateViewPagerHeight();
        setBackPressedCallback();
        updateBackPressedCallBack(false);
        setNestedScrollViewToFloatingView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState == null) {
            return;
        }
        this.mCurrentPage = savedInstanceState.getInt(KEY_CURRENT_PAGE);
        AbsViewPager absViewPager = this.mViewPager;
        if (absViewPager != null) {
            Intrinsics.checkNotNull(absViewPager);
            absViewPager.setCurrentItem(this.mCurrentPage);
        }
        DefaultNoteStylePagerAdapter defaultNoteStylePagerAdapter = this.mPagerAdapter;
        Intrinsics.checkNotNull(defaultNoteStylePagerAdapter);
        defaultNoteStylePagerAdapter.onViewStateRestored(savedInstanceState);
    }

    public final void updateBackPressedCallBack(boolean isEnabled) {
        OnBackPressedCallback onBackPressedCallback = this.mOnBackPressedCallback;
        if (onBackPressedCallback != null) {
            onBackPressedCallback.setEnabled(isEnabled);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean onBackKeyDown(int position) {
        DefaultNoteStylePagerAdapter defaultNoteStylePagerAdapter = this.mPagerAdapter;
        if (defaultNoteStylePagerAdapter == null) {
            return false;
        }
        Intrinsics.checkNotNull(defaultNoteStylePagerAdapter);
        StyleOfNewNotesPage styleOfNewNotesPageCreatePage = defaultNoteStylePagerAdapter.createPage(getContext(), position);
        return styleOfNewNotesPageCreatePage != null && styleOfNewNotesPageCreatePage.onBackKeyDown();
    }
}
