package com.samsung.android.support.senl.docscan.rectify;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.samsung.android.support.senl.docscan.C7976R;
import com.samsung.android.support.senl.docscan.model.DocScanData;
import com.samsung.android.support.senl.docscan.model.ScanDataModel;
import com.samsung.android.support.senl.docscan.rectify.adapter.AdapterContract;
import com.samsung.android.support.senl.docscan.rectify.adapter.RectifiedImagePagerAdapter;
import com.samsung.android.support.senl.docscan.rectify.adapter.RectifiedImageThumbnailAdapter;
import com.samsung.android.support.senl.docscan.rectify.constant.RectifyConstant;
import com.samsung.android.support.senl.docscan.rectify.presenter.RectifyListPresenter;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.util.DisplayUtils;
import com.samsung.android.support.senl.p148nt.base.winset.view.AbsViewPager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p035H2.RunnableC0117b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 I2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002HIB\t\b\u0016¢\u0006\u0004\b\u0005\u0010\u0006B\u0013\b\u0016\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tJ\u0010\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0015J&\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u001a\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010$\u001a\u00020\u0018H\u0002J\b\u0010%\u001a\u00020\u0018H\u0002J\b\u0010&\u001a\u00020\u0018H\u0002J\b\u0010'\u001a\u00020\u0018H\u0002J\b\u0010(\u001a\u00020\u0018H\u0002J\b\u0010)\u001a\u00020\u0018H\u0016J\u0010\u0010*\u001a\u00020\u00182\u0006\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020\u0018H\u0002J\b\u0010.\u001a\u00020\u0018H\u0002J\b\u0010/\u001a\u00020\u0018H\u0002J\b\u00100\u001a\u00020\u0018H\u0016J\u0010\u00101\u001a\u00020\u00182\u0006\u00102\u001a\u000203H\u0016J\b\u00104\u001a\u00020\u0018H\u0016J\u0010\u00105\u001a\u00020\u00182\u0006\u00102\u001a\u000203H\u0016J\u0010\u00106\u001a\u00020\u00182\u0006\u00102\u001a\u000203H\u0016J\b\u00107\u001a\u00020\u0018H\u0017J \u00108\u001a\u00020\u00182\u0006\u00102\u001a\u0002032\u0006\u00109\u001a\u0002032\u0006\u0010:\u001a\u00020;H\u0016J\u0018\u0010<\u001a\u00020\u00182\u0006\u00109\u001a\u0002032\u0006\u00102\u001a\u000203H\u0002J\u0006\u0010=\u001a\u00020\u0018J\b\u0010>\u001a\u000203H\u0016J\u0010\u0010?\u001a\u00020\u00182\u0006\u00102\u001a\u000203H\u0016J\u0012\u0010@\u001a\u0004\u0018\u00010A2\u0006\u00102\u001a\u000203H\u0016J\u0010\u0010B\u001a\u00020\u00182\u0006\u00102\u001a\u000203H\u0016J\u0010\u0010C\u001a\u00020\u00182\u0006\u00102\u001a\u000203H\u0016J\u0012\u0010D\u001a\u0004\u0018\u00010A2\u0006\u00102\u001a\u000203H\u0016J\u0010\u0010E\u001a\u00020\u00182\b\u0010\u0007\u001a\u0004\u0018\u00010\bR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010F\u001a\u00020;8F¢\u0006\u0006\u001a\u0004\bF\u0010G¨\u0006J"}, m13886d2 = {"Lcom/samsung/android/support/senl/docscan/rectify/RectifyListFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/samsung/android/support/senl/docscan/rectify/presenter/RectifyListPresenter$Contract;", "Lcom/samsung/android/support/senl/docscan/rectify/adapter/AdapterContract$ViewPager;", "Lcom/samsung/android/support/senl/docscan/rectify/adapter/AdapterContract$RecyclerView;", "<init>", "()V", "scanDataModel", "Lcom/samsung/android/support/senl/docscan/model/ScanDataModel;", "(Lcom/samsung/android/support/senl/docscan/model/ScanDataModel;)V", "mPresenter", "Lcom/samsung/android/support/senl/docscan/rectify/presenter/RectifyListPresenter;", "mViewPager", "Lcom/samsung/android/support/senl/nt/base/winset/view/AbsViewPager;", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "mPagerAdapter", "Lcom/samsung/android/support/senl/docscan/rectify/adapter/RectifiedImagePagerAdapter;", "mRecyclerViewAdapter", "Lcom/samsung/android/support/senl/docscan/rectify/adapter/RectifiedImageThumbnailAdapter;", "mContract", "Lcom/samsung/android/support/senl/docscan/rectify/RectifyListFragment$Contract;", "mScanDataModel", "setContract", "", "contract", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "updateDocScanData", "initLayout", "initToolbar", "initViewPager", "initRecyclerView", "onResume", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "updateRecyclerViewLayout", "showRectifyEditView", "removeDocScanData", "finishFragment", "notifyPageUpdated", "position", "", "notifyPageRemoved", "notifyThumbnailUpdated", "notifyThumbnailRemoved", "notifyThumbnailDataChanged", "notifyCurrentPositionChanged", "prevPosition", "isPagerScroll", "", "updateRecyclerViewForThumbnail", "onBackPressed", "getCurrentPosition", "onItemSelected", "getRectifiedImage", "Landroid/graphics/Bitmap;", "clearRectifiedImage", "updateRectifiedImage", "getThumbnailImage", "setScanDataModel", "isScanDataModelInitialized", "()Z", "Contract", "Companion", "docscan_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class RectifyListFragment extends Fragment implements RectifyListPresenter.Contract, AdapterContract.ViewPager, AdapterContract.RecyclerView {
    private static final int OFFSET_PAGE_LIMIT = 3;

    @NotNull
    public static final String TAG = "RectifyListFragment";

    @Nullable
    private Contract mContract;

    @Nullable
    private RectifiedImagePagerAdapter mPagerAdapter;

    @Nullable
    private RectifyListPresenter mPresenter;
    private RecyclerView mRecyclerView;

    @Nullable
    private RectifiedImageThumbnailAdapter mRecyclerViewAdapter;

    @Nullable
    private ScanDataModel mScanDataModel;
    private AbsViewPager mViewPager;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/docscan/rectify/RectifyListFragment$Contract;", "", "showRectifyEditView", "", "docScanData", "Lcom/samsung/android/support/senl/docscan/model/DocScanData;", NotesConstants.KEY_CALLER, "", "docscan_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Contract {
        void showRectifyEditView(@Nullable DocScanData docScanData, @Nullable String caller);
    }

    public RectifyListFragment() {
    }

    private final void initLayout() {
        initToolbar();
        initViewPager();
        initRecyclerView();
    }

    private final void initRecyclerView() {
        View view = getView();
        if (view == null) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view.findViewById(C7976R.id.rectified_image_view_list);
        this.mRecyclerView = recyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        RecyclerView recyclerView3 = this.mRecyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView3 = null;
        }
        RectifiedImageThumbnailAdapter rectifiedImageThumbnailAdapter = new RectifiedImageThumbnailAdapter(this, this.mScanDataModel);
        this.mRecyclerViewAdapter = rectifiedImageThumbnailAdapter;
        recyclerView3.setAdapter(rectifiedImageThumbnailAdapter);
        RecyclerView recyclerView4 = this.mRecyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView4 = null;
        }
        recyclerView4.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.samsung.android.support.senl.docscan.rectify.RectifyListFragment.initRecyclerView.2
            private int diff;
            private int idlePosition;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView5, int newState) {
                Intrinsics.checkNotNullParameter(recyclerView5, "recyclerView");
                super.onScrollStateChanged(recyclerView5, newState);
                if (newState == 0) {
                    RectifyListPresenter rectifyListPresenter = RectifyListFragment.this.mPresenter;
                    Intrinsics.checkNotNull(rectifyListPresenter);
                    int currentPosition = rectifyListPresenter.getCurrentPosition();
                    this.diff = 0;
                    this.idlePosition = currentPosition;
                    RectifiedImageThumbnailAdapter rectifiedImageThumbnailAdapter2 = RectifyListFragment.this.mRecyclerViewAdapter;
                    Intrinsics.checkNotNull(rectifiedImageThumbnailAdapter2);
                    rectifiedImageThumbnailAdapter2.notifyItemChanged(currentPosition, Boolean.TRUE);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView5, int dx, int dy) {
                Intrinsics.checkNotNullParameter(recyclerView5, "recyclerView");
                this.diff += dx;
                if (1 == recyclerView5.getScrollState()) {
                    int iRoundToInt = MathKt.roundToInt(this.diff / recyclerView5.getResources().getDimension(C7976R.dimen.rectified_image_thumbnail_item_size)) + this.idlePosition;
                    if (this.idlePosition == iRoundToInt) {
                        return;
                    }
                    RectifyListPresenter rectifyListPresenter = RectifyListFragment.this.mPresenter;
                    Intrinsics.checkNotNull(rectifyListPresenter);
                    rectifyListPresenter.setCurrentPosition(iRoundToInt, false);
                }
            }
        });
        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper() { // from class: com.samsung.android.support.senl.docscan.rectify.RectifyListFragment$initRecyclerView$snapHelper$1
            @Override // androidx.recyclerview.widget.PagerSnapHelper, androidx.recyclerview.widget.SnapHelper
            public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int velocityX, int velocityY) {
                Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
                int iFindTargetSnapPosition = super.findTargetSnapPosition(layoutManager, velocityX, velocityY);
                if (iFindTargetSnapPosition >= 0) {
                    RectifyListPresenter rectifyListPresenter = this.this$0.mPresenter;
                    Intrinsics.checkNotNull(rectifyListPresenter);
                    rectifyListPresenter.setCurrentPosition(iFindTargetSnapPosition, true);
                }
                return iFindTargetSnapPosition;
            }
        };
        RecyclerView recyclerView5 = this.mRecyclerView;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        } else {
            recyclerView2 = recyclerView5;
        }
        pagerSnapHelper.attachToRecyclerView(recyclerView2);
    }

    private final void initToolbar() {
        View view = getView();
        if (view == null) {
            return;
        }
        Toolbar toolbar = (Toolbar) view.findViewById(C7976R.id.toolbar);
        AppCompatActivity appCompatActivity = (AppCompatActivity) getActivity();
        if (appCompatActivity == null || toolbar == null) {
            return;
        }
        appCompatActivity.setSupportActionBar(toolbar);
        ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
        Intrinsics.checkNotNull(supportActionBar);
        supportActionBar.setTitle((CharSequence) null);
        ActionBar supportActionBar2 = appCompatActivity.getSupportActionBar();
        Intrinsics.checkNotNull(supportActionBar2);
        supportActionBar2.setDisplayHomeAsUpEnabled(true);
    }

    private final void initViewPager() {
        View view = getView();
        if (view == null) {
            return;
        }
        AbsViewPager absViewPager = (AbsViewPager) view.findViewById(C7976R.id.rectified_image_view_pager);
        this.mViewPager = absViewPager;
        AbsViewPager absViewPager2 = null;
        if (absViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
            absViewPager = null;
        }
        absViewPager.setOffscreenPageLimit(3);
        AbsViewPager absViewPager3 = this.mViewPager;
        if (absViewPager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
            absViewPager3 = null;
        }
        RectifiedImagePagerAdapter rectifiedImagePagerAdapter = new RectifiedImagePagerAdapter(this, this.mScanDataModel);
        this.mPagerAdapter = rectifiedImagePagerAdapter;
        absViewPager3.setAdapter(rectifiedImagePagerAdapter);
        AbsViewPager absViewPager4 = this.mViewPager;
        if (absViewPager4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
        } else {
            absViewPager2 = absViewPager4;
        }
        absViewPager2.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.samsung.android.support.senl.docscan.rectify.RectifyListFragment.initViewPager.2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int position) {
                RectifyListPresenter rectifyListPresenter = RectifyListFragment.this.mPresenter;
                Intrinsics.checkNotNull(rectifyListPresenter);
                rectifyListPresenter.setCurrentPosition(position, false);
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int state) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeDocScanData() {
        RectifyListPresenter rectifyListPresenter = this.mPresenter;
        Intrinsics.checkNotNull(rectifyListPresenter);
        AbsViewPager absViewPager = this.mViewPager;
        if (absViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
            absViewPager = null;
        }
        rectifyListPresenter.removeDocScanData(absViewPager.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showRectifyEditView() {
        Contract contract = this.mContract;
        if (contract != null) {
            Intrinsics.checkNotNull(contract);
            RectifyListPresenter rectifyListPresenter = this.mPresenter;
            Intrinsics.checkNotNull(rectifyListPresenter);
            AbsViewPager absViewPager = this.mViewPager;
            if (absViewPager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
                absViewPager = null;
            }
            contract.showRectifyEditView(rectifyListPresenter.getDocScanData(absViewPager.getCurrentItem()), "RectifyListFragment");
        }
    }

    private final void updateDocScanData() {
        Bundle arguments = getArguments();
        DocScanData docScanData = arguments != null ? (DocScanData) arguments.getParcelable(RectifyConstant.KEY_DOC_SCAN_DATA) : null;
        RectifyListPresenter rectifyListPresenter = this.mPresenter;
        Intrinsics.checkNotNull(rectifyListPresenter);
        rectifyListPresenter.updateDocScanData(docScanData);
        RectifyListPresenter rectifyListPresenter2 = this.mPresenter;
        Intrinsics.checkNotNull(rectifyListPresenter2);
        rectifyListPresenter2.loadThumbnailImage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateRecyclerViewForThumbnail(int prevPosition, int position) {
        RecyclerView recyclerView = this.mRecyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        if (1 != recyclerView.getScrollState()) {
            RecyclerView recyclerView3 = this.mRecyclerView;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
                recyclerView3 = null;
            }
            recyclerView3.scrollToPosition(position);
        }
        if (prevPosition != position) {
            RectifiedImageThumbnailAdapter rectifiedImageThumbnailAdapter = this.mRecyclerViewAdapter;
            Intrinsics.checkNotNull(rectifiedImageThumbnailAdapter);
            rectifiedImageThumbnailAdapter.notifyItemChanged(prevPosition, Boolean.FALSE);
        }
        RectifiedImageThumbnailAdapter rectifiedImageThumbnailAdapter2 = this.mRecyclerViewAdapter;
        Intrinsics.checkNotNull(rectifiedImageThumbnailAdapter2);
        RecyclerView recyclerView4 = this.mRecyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        } else {
            recyclerView2 = recyclerView4;
        }
        rectifiedImageThumbnailAdapter2.notifyItemChanged(position, Boolean.valueOf(recyclerView2.getScrollState() != 1));
    }

    private final void updateRecyclerViewLayout() {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        int iWidth = (DisplayUtils.getScreenDimension(contextRequireContext).width() - ((int) getResources().getDimension(C7976R.dimen.rectified_image_thumbnail_item_size))) / 2;
        RecyclerView recyclerView = this.mRecyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        RecyclerView recyclerView3 = this.mRecyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView3 = null;
        }
        int paddingTop = recyclerView3.getPaddingTop();
        RecyclerView recyclerView4 = this.mRecyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        } else {
            recyclerView2 = recyclerView4;
        }
        recyclerView.setPaddingRelative(iWidth, paddingTop, iWidth, recyclerView2.getPaddingBottom());
        RectifyListPresenter rectifyListPresenter = this.mPresenter;
        Intrinsics.checkNotNull(rectifyListPresenter);
        RectifyListPresenter rectifyListPresenter2 = this.mPresenter;
        Intrinsics.checkNotNull(rectifyListPresenter2);
        rectifyListPresenter.setCurrentPosition(rectifyListPresenter2.getCurrentPosition(), false, true);
    }

    @Override // com.samsung.android.support.senl.docscan.rectify.adapter.AdapterContract.ViewPager
    public void clearRectifiedImage(int position) {
        RectifyListPresenter rectifyListPresenter = this.mPresenter;
        if (rectifyListPresenter != null) {
            Intrinsics.checkNotNull(rectifyListPresenter);
            rectifyListPresenter.clearRectifiedImage(position);
        }
    }

    @Override // com.samsung.android.support.senl.docscan.rectify.presenter.RectifyListPresenter.Contract
    public void finishFragment() {
        onBackPressed();
    }

    @Override // com.samsung.android.support.senl.docscan.rectify.adapter.AdapterContract.RecyclerView
    public int getCurrentPosition() {
        RectifyListPresenter rectifyListPresenter = this.mPresenter;
        if (rectifyListPresenter == null) {
            return -1;
        }
        Intrinsics.checkNotNull(rectifyListPresenter);
        return rectifyListPresenter.getCurrentPosition();
    }

    @Override // com.samsung.android.support.senl.docscan.rectify.adapter.AdapterContract.ViewPager
    @Nullable
    public Bitmap getRectifiedImage(int position) {
        RectifyListPresenter rectifyListPresenter = this.mPresenter;
        if (rectifyListPresenter == null) {
            return null;
        }
        Intrinsics.checkNotNull(rectifyListPresenter);
        return rectifyListPresenter.getRectifiedImage(position);
    }

    @Override // com.samsung.android.support.senl.docscan.rectify.adapter.AdapterContract.RecyclerView
    @Nullable
    public Bitmap getThumbnailImage(int position) {
        RectifyListPresenter rectifyListPresenter = this.mPresenter;
        if (rectifyListPresenter == null) {
            return null;
        }
        Intrinsics.checkNotNull(rectifyListPresenter);
        return rectifyListPresenter.getThumbnailImage(position);
    }

    public final boolean isScanDataModelInitialized() {
        return this.mScanDataModel != null;
    }

    @Override // com.samsung.android.support.senl.docscan.rectify.presenter.RectifyListPresenter.Contract
    public void notifyCurrentPositionChanged(int position, int prevPosition, boolean isPagerScroll) {
        AbsViewPager absViewPager = this.mViewPager;
        RecyclerView recyclerView = null;
        if (absViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
            absViewPager = null;
        }
        if (absViewPager.getCurrentItem() != position) {
            AbsViewPager absViewPager2 = this.mViewPager;
            if (absViewPager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
                absViewPager2 = null;
            }
            absViewPager2.setCurrentItem(position, isPagerScroll);
        }
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        } else {
            recyclerView = recyclerView2;
        }
        recyclerView.post(new RunnableC0117b(this, prevPosition, position, 3));
    }

    @Override // com.samsung.android.support.senl.docscan.rectify.presenter.RectifyListPresenter.Contract
    public void notifyPageRemoved() {
        RectifiedImagePagerAdapter rectifiedImagePagerAdapter = this.mPagerAdapter;
        if (rectifiedImagePagerAdapter != null) {
            Intrinsics.checkNotNull(rectifiedImagePagerAdapter);
            rectifiedImagePagerAdapter.notifyItemRemoved();
            RectifiedImagePagerAdapter rectifiedImagePagerAdapter2 = this.mPagerAdapter;
            Intrinsics.checkNotNull(rectifiedImagePagerAdapter2);
            rectifiedImagePagerAdapter2.notifyDataSetChanged();
        }
    }

    @Override // com.samsung.android.support.senl.docscan.rectify.presenter.RectifyListPresenter.Contract
    public void notifyPageUpdated(int position) {
        RectifiedImagePagerAdapter rectifiedImagePagerAdapter = this.mPagerAdapter;
        if (rectifiedImagePagerAdapter != null) {
            Intrinsics.checkNotNull(rectifiedImagePagerAdapter);
            rectifiedImagePagerAdapter.notifyItemUpdated(position);
            RectifiedImagePagerAdapter rectifiedImagePagerAdapter2 = this.mPagerAdapter;
            Intrinsics.checkNotNull(rectifiedImagePagerAdapter2);
            rectifiedImagePagerAdapter2.notifyDataSetChanged();
        }
    }

    @Override // com.samsung.android.support.senl.docscan.rectify.presenter.RectifyListPresenter.Contract
    @SuppressLint({"NotifyDataSetChanged"})
    public void notifyThumbnailDataChanged() {
        RectifiedImageThumbnailAdapter rectifiedImageThumbnailAdapter = this.mRecyclerViewAdapter;
        if (rectifiedImageThumbnailAdapter != null) {
            Intrinsics.checkNotNull(rectifiedImageThumbnailAdapter);
            rectifiedImageThumbnailAdapter.notifyDataSetChanged();
        }
    }

    @Override // com.samsung.android.support.senl.docscan.rectify.presenter.RectifyListPresenter.Contract
    public void notifyThumbnailRemoved(int position) {
        RectifiedImageThumbnailAdapter rectifiedImageThumbnailAdapter = this.mRecyclerViewAdapter;
        if (rectifiedImageThumbnailAdapter != null) {
            Intrinsics.checkNotNull(rectifiedImageThumbnailAdapter);
            rectifiedImageThumbnailAdapter.notifyItemRemoved(position);
        }
    }

    @Override // com.samsung.android.support.senl.docscan.rectify.presenter.RectifyListPresenter.Contract
    public void notifyThumbnailUpdated(int position) {
        RectifiedImageThumbnailAdapter rectifiedImageThumbnailAdapter = this.mRecyclerViewAdapter;
        if (rectifiedImageThumbnailAdapter != null) {
            Intrinsics.checkNotNull(rectifiedImageThumbnailAdapter);
            rectifiedImageThumbnailAdapter.notifyItemChanged(position);
        }
    }

    public final void onBackPressed() {
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        activity.onBackPressed();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        updateRecyclerViewLayout();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        fragmentActivityRequireActivity.addMenuProvider(new MenuProvider() { // from class: com.samsung.android.support.senl.docscan.rectify.RectifyListFragment.onCreateView.1
            @Override // androidx.core.view.MenuProvider
            public void onCreateMenu(Menu menu, MenuInflater menuInflater) {
                Intrinsics.checkNotNullParameter(menu, "menu");
                Intrinsics.checkNotNullParameter(menuInflater, "menuInflater");
                menuInflater.inflate(C7976R.menu.rectify_list_menu, menu);
            }

            @Override // androidx.core.view.MenuProvider
            public boolean onMenuItemSelected(MenuItem menuItem) {
                Intrinsics.checkNotNullParameter(menuItem, "menuItem");
                UserInputSkipper.Tag tag = UserInputSkipper.Tag.DocumentScan;
                if (!UserInputSkipper.isValidEvent(tag)) {
                    return false;
                }
                UserInputSkipper.setHoldingEventTime(300L, tag);
                int itemId = menuItem.getItemId();
                if (itemId == 16908332) {
                    RectifyListFragment.this.onBackPressed();
                } else if (itemId == C7976R.id.action_rectify) {
                    RectifyListFragment.this.showRectifyEditView();
                } else if (itemId == C7976R.id.action_remove) {
                    RectifyListFragment.this.removeDocScanData();
                }
                return false;
            }
        }, getViewLifecycleOwner(), Lifecycle.State.RESUMED);
        return inflater.inflate(C7976R.layout.rectify_list_fragment, container, false);
    }

    @Override // com.samsung.android.support.senl.docscan.rectify.adapter.AdapterContract.RecyclerView
    public void onItemSelected(int position) {
        RectifyListPresenter rectifyListPresenter = this.mPresenter;
        Intrinsics.checkNotNull(rectifyListPresenter);
        rectifyListPresenter.setCurrentPosition(position, true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        updateRecyclerViewLayout();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        WindowManagerCompat.INSTANCE.getInstance().disableSystemBarInsets(view);
        RectifyListPresenter rectifyListPresenter = new RectifyListPresenter(this);
        this.mPresenter = rectifyListPresenter;
        Intrinsics.checkNotNull(rectifyListPresenter);
        rectifyListPresenter.setScanDataModel(this.mScanDataModel);
        initLayout();
        updateDocScanData();
    }

    public final void setContract(@Nullable Contract contract) {
        this.mContract = contract;
    }

    public final void setScanDataModel(@Nullable ScanDataModel scanDataModel) {
        this.mScanDataModel = scanDataModel;
    }

    @Override // com.samsung.android.support.senl.docscan.rectify.adapter.AdapterContract.ViewPager
    public void updateRectifiedImage(int position) {
        RectifyListPresenter rectifyListPresenter = this.mPresenter;
        if (rectifyListPresenter != null) {
            Intrinsics.checkNotNull(rectifyListPresenter);
            rectifyListPresenter.updateRectifiedImage(position, true);
        }
    }

    public RectifyListFragment(@Nullable ScanDataModel scanDataModel) {
        this.mScanDataModel = scanDataModel;
    }
}
