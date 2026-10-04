package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
public class LinearSnapHelper extends SnapHelper {
    private static final float INVALID_DISTANCE = 1.0f;

    @Nullable
    private OrientationHelper mHorizontalHelper;

    @Nullable
    private OrientationHelper mVerticalHelper;
    private final DecelerateInterpolator mDecelerateInterpolator = new DecelerateInterpolator();
    private float mVelocityRatio = 0.5f;
    private int mDeccelateTimeRatio = 1;
    private float mMillisecondsPerInch = 100.0f;

    public LinearSnapHelper() {
        setSnapValue(0.5f, 100.0f, 1);
    }

    private float computeDistancePerChild(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
        int childCount = layoutManager.getChildCount();
        if (childCount == 0) {
            return 1.0f;
        }
        View view = null;
        int i = Integer.MIN_VALUE;
        int i2 = Integer.MAX_VALUE;
        View view2 = null;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = layoutManager.getChildAt(i4);
            int position = layoutManager.getPosition(childAt);
            if (position != -1) {
                if (position < i2) {
                    view = childAt;
                    i2 = position;
                }
                if (position > i) {
                    view2 = childAt;
                    i = position;
                }
            }
        }
        if (view == null || view2 == null) {
            return 1.0f;
        }
        int iMax = Math.max(orientationHelper.getDecoratedEnd(view), orientationHelper.getDecoratedEnd(view2)) - Math.min(orientationHelper.getDecoratedStart(view), orientationHelper.getDecoratedStart(view2));
        if (iMax == 0) {
            return 1.0f;
        }
        return (iMax * 1.0f) / ((i - i2) + 1);
    }

    private int distanceToCenter(@NonNull View view, OrientationHelper orientationHelper) {
        return ((orientationHelper.getDecoratedMeasurement(view) / 2) + orientationHelper.getDecoratedStart(view)) - ((orientationHelper.getTotalSpace() / 2) + orientationHelper.getStartAfterPadding());
    }

    private int estimateNextPositionDiffForFling(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper, int i, int i2, int[] iArr) {
        int[] iArrSeslCalculateScrollDistanceForLinear = seslCalculateScrollDistanceForLinear(i, i2);
        float fComputeDistancePerChild = computeDistancePerChild(layoutManager, orientationHelper);
        if (fComputeDistancePerChild <= 0.0f) {
            return 0;
        }
        int i4 = Math.abs(iArrSeslCalculateScrollDistanceForLinear[0]) > Math.abs(iArrSeslCalculateScrollDistanceForLinear[1]) ? iArrSeslCalculateScrollDistanceForLinear[0] : iArrSeslCalculateScrollDistanceForLinear[1];
        int iRound = Math.round(i4 / fComputeDistancePerChild);
        boolean zCanScrollHorizontally = layoutManager.canScrollHorizontally();
        if (!zCanScrollHorizontally) {
            i = i2;
        }
        return (Math.signum((float) i) == Math.signum((float) (zCanScrollHorizontally ? iArr[0] : iArr[1])) || iRound != 0) ? iRound : i4 < 0 ? -1 : 1;
    }

    @Nullable
    private View findCenterView(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
        int childCount = layoutManager.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        int totalSpace = (orientationHelper.getTotalSpace() / 2) + orientationHelper.getStartAfterPadding();
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = layoutManager.getChildAt(i2);
            int iAbs = Math.abs(((orientationHelper.getDecoratedMeasurement(childAt) / 2) + orientationHelper.getDecoratedStart(childAt)) - totalSpace);
            if (iAbs < i) {
                view = childAt;
                i = iAbs;
            }
        }
        return view;
    }

    @NonNull
    private OrientationHelper getHorizontalHelper(@NonNull RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.mHorizontalHelper;
        if (orientationHelper == null || orientationHelper.mLayoutManager != layoutManager) {
            this.mHorizontalHelper = OrientationHelper.createHorizontalHelper(layoutManager);
        }
        return this.mHorizontalHelper;
    }

    @NonNull
    private OrientationHelper getVerticalHelper(@NonNull RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.mVerticalHelper;
        if (orientationHelper == null || orientationHelper.mLayoutManager != layoutManager) {
            this.mVerticalHelper = OrientationHelper.createVerticalHelper(layoutManager);
        }
        return this.mVerticalHelper;
    }

    private void setSnapValue(float f, float f4, int i) {
        this.mMillisecondsPerInch = f4;
        this.mVelocityRatio = f;
        this.mDeccelateTimeRatio = i;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view) {
        int[] iArr = new int[2];
        if (layoutManager.canScrollHorizontally()) {
            iArr[0] = distanceToCenter(view, getHorizontalHelper(layoutManager));
        } else {
            iArr[0] = 0;
        }
        if (layoutManager.canScrollVertically()) {
            iArr[1] = distanceToCenter(view, getVerticalHelper(layoutManager));
            return iArr;
        }
        iArr[1] = 0;
        return iArr;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    @Nullable
    public RecyclerView.SmoothScroller createScroller(@NonNull RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) {
            return new LinearSmoothScroller(this.mRecyclerView.getContext()) { // from class: androidx.recyclerview.widget.LinearSnapHelper.1
                @Override // androidx.recyclerview.widget.LinearSmoothScroller
                public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                    return LinearSnapHelper.this.mMillisecondsPerInch / displayMetrics.densityDpi;
                }

                @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
                public void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
                    LinearSnapHelper linearSnapHelper = LinearSnapHelper.this;
                    RecyclerView recyclerView = linearSnapHelper.mRecyclerView;
                    if (recyclerView == null) {
                        return;
                    }
                    int[] iArrCalculateDistanceToFinalSnap = linearSnapHelper.calculateDistanceToFinalSnap(recyclerView.getLayoutManager(), view);
                    int i = iArrCalculateDistanceToFinalSnap[0];
                    int i2 = iArrCalculateDistanceToFinalSnap[1];
                    int iCalculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(LinearSnapHelper.this.mDeccelateTimeRatio * i), Math.abs(LinearSnapHelper.this.mDeccelateTimeRatio * i2)));
                    if (iCalculateTimeForDeceleration > 0) {
                        action.update(i, i2, iCalculateTimeForDeceleration, this.mDecelerateInterpolator);
                    }
                }
            };
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager.canScrollVertically()) {
            return findCenterView(layoutManager, getVerticalHelper(layoutManager));
        }
        if (layoutManager.canScrollHorizontally()) {
            return findCenterView(layoutManager, getHorizontalHelper(layoutManager));
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.SnapHelper
    public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i, int i2) {
        int itemCount;
        View viewFindSnapView;
        int position;
        int i4;
        PointF pointFComputeScrollVectorForPosition;
        int i5;
        int iEstimateNextPositionDiffForFling;
        float f = this.mVelocityRatio;
        int i6 = (int) (i * f);
        int i7 = (int) (i2 * f);
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (itemCount = layoutManager.getItemCount()) == 0 || (viewFindSnapView = findSnapView(layoutManager)) == null || (position = layoutManager.getPosition(viewFindSnapView)) == -1 || (pointFComputeScrollVectorForPosition = ((RecyclerView.SmoothScroller.ScrollVectorProvider) layoutManager).computeScrollVectorForPosition(itemCount - 1)) == null) {
            return -1;
        }
        int[] iArrCalculateDistanceToFinalSnap = calculateDistanceToFinalSnap(layoutManager, viewFindSnapView);
        if (layoutManager.canScrollHorizontally()) {
            int iEstimateNextPositionDiffForFling2 = estimateNextPositionDiffForFling(layoutManager, getHorizontalHelper(layoutManager), i6, 0, iArrCalculateDistanceToFinalSnap);
            if (pointFComputeScrollVectorForPosition.x < 0.0f) {
                iEstimateNextPositionDiffForFling2 = -iEstimateNextPositionDiffForFling2;
            }
            i5 = iEstimateNextPositionDiffForFling2;
        } else {
            i5 = 0;
        }
        if (layoutManager.canScrollVertically()) {
            iEstimateNextPositionDiffForFling = estimateNextPositionDiffForFling(layoutManager, getVerticalHelper(layoutManager), 0, i7, iArrCalculateDistanceToFinalSnap);
            if (pointFComputeScrollVectorForPosition.y < 0.0f) {
                iEstimateNextPositionDiffForFling = -iEstimateNextPositionDiffForFling;
            }
        } else {
            iEstimateNextPositionDiffForFling = 0;
        }
        if (layoutManager.canScrollVertically()) {
            i5 = iEstimateNextPositionDiffForFling;
        }
        int i8 = position + i5;
        int i9 = i8 >= 0 ? i8 : 0;
        return i9 >= itemCount ? i4 : i9;
    }

    public LinearSnapHelper(float f) {
        setSnapValue(f, 100.0f, 1);
    }

    public LinearSnapHelper(float f, float f4) {
        setSnapValue(f, f4, 1);
    }

    public LinearSnapHelper(float f, float f4, int i) {
        setSnapValue(f, f4, i);
    }
}
