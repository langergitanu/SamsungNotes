package com.samsung.android.sdk.pen.setting;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000 (2\u00020\u0001:\u0002()B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005JP\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0011H\u0016J\u0006\u0010\u0019\u001a\u00020\u000eJ\u0010\u0010\u001a\u001a\u00020\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\fJ\u001a\u0010\u001c\u001a\u00020\u000e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u0006\u0010 \u001a\u00020\bJ\u000e\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\bJ\u0010\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u0011H\u0002J\u001c\u0010%\u001a\u00020\u000e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\b\u0010&\u001a\u00020\bH\u0002J\b\u0010'\u001a\u00020\u000eH\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenViewPositionControl;", "Landroid/view/View$OnLayoutChangeListener;", "mCurrentView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "mMonitoringView", "value", "", "isMonitoring", "()Z", "mGuidePositionChangedListener", "Lcom/samsung/android/sdk/pen/setting/SpenViewPositionControl$GuidePositionChangedListener;", "onLayoutChange", "", VPathDataCmd.RCurveTo, "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "close", "setGuidePositionChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setMonitorView", "guide", ActionHandler.PARAMS, "Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;", "startMonitoring", "stopMonitoring", "isHide", "changeCurrentVisibility", "visibility", "setToView", "registerListener", "unregisterListener", "Companion", "GuidePositionChangedListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenViewPositionControl implements View.OnLayoutChangeListener {

    @NotNull
    private static final String TAG = "SpenViewPositionControl";
    private boolean isMonitoring;

    @Nullable
    private View mCurrentView;

    @Nullable
    private GuidePositionChangedListener mGuidePositionChangedListener;

    @Nullable
    private View mMonitoringView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenViewPositionControl$GuidePositionChangedListener;", "", "onGuidePositionChanged", "", "current", "", "guide", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface GuidePositionChangedListener {
        void onGuidePositionChanged(int current, int guide);
    }

    public SpenViewPositionControl(@Nullable View view) {
        this.mCurrentView = view;
    }

    private final void changeCurrentVisibility(int visibility) {
        View view = this.mCurrentView;
        if (view == null || visibility == view.getVisibility()) {
            return;
        }
        view.setVisibility(visibility);
    }

    private final boolean registerListener() {
        AbstractC4539a.m3208r("registerListener() mIsMonitoring=", TAG, this.isMonitoring);
        if (this.isMonitoring) {
            Log.i(TAG, "Already monitoring..");
            return false;
        }
        View view = this.mMonitoringView;
        if (view == null) {
            return false;
        }
        view.addOnLayoutChangeListener(this);
        this.isMonitoring = true;
        return true;
    }

    private final void setToView(View guide, ConstraintLayout.LayoutParams params) {
        Log.i(TAG, "setToView()");
        if (guide == null) {
            return;
        }
        int id = guide.getId();
        if (params != null) {
            params.startToStart = id;
            params.topToTop = id;
            return;
        }
        View view = this.mCurrentView;
        ViewGroup.LayoutParams layoutParams = view != null ? view.getLayoutParams() : null;
        ConstraintLayout.LayoutParams layoutParams2 = layoutParams instanceof ConstraintLayout.LayoutParams ? (ConstraintLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 != null) {
            layoutParams2.startToStart = id;
        }
        if (layoutParams2 != null) {
            layoutParams2.topToTop = id;
        }
        View view2 = this.mCurrentView;
        if (view2 != null) {
            view2.setLayoutParams(layoutParams2);
        }
    }

    private final void unregisterListener() {
        Log.i(TAG, "unregisterListener() isMonitoring=" + this.isMonitoring + " monitoringView=" + (this.mMonitoringView == null ? "NULL" : "NOT_NULL"));
        if (this.isMonitoring) {
            View view = this.mMonitoringView;
            if (view != null) {
                view.removeOnLayoutChangeListener(this);
            }
            this.isMonitoring = false;
        }
    }

    public final void close() {
        Log.i(TAG, "close()");
        unregisterListener();
        this.mMonitoringView = null;
        this.mCurrentView = null;
    }

    /* JADX INFO: renamed from: isMonitoring, reason: from getter */
    public final boolean getIsMonitoring() {
        return this.isMonitoring;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(@NotNull View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        View view;
        GuidePositionChangedListener guidePositionChangedListener;
        Intrinsics.checkNotNullParameter(v, "v");
        Log.i(TAG, "onLayoutChange()");
        if (v != this.mMonitoringView) {
            Log.i(TAG, "=============== Unknown View..!! ===");
            v.removeOnLayoutChangeListener(this);
            return;
        }
        StringBuilder sbM1173s = AbstractC0622a.m1173s(oldLeft, oldTop, "onLayoutChange() [", SQLKeyword.COMMA, SQLKeyword.COMMA);
        AbstractC2821a.m2235z(sbM1173s, oldRight, oldBottom, SQLKeyword.COMMA, "]-->  [");
        AbstractC2821a.m2235z(sbM1173s, left, top, SQLKeyword.COMMA, SQLKeyword.COMMA);
        Log.i(TAG, AbstractC2322a.m1625o(sbM1173s, right, bottom, SQLKeyword.COMMA, "]"));
        boolean z = true;
        boolean z2 = (oldRight - oldLeft == right - left && oldBottom - oldTop == bottom - top) ? false : true;
        if (left == oldLeft && top == oldTop && right == oldRight && bottom == oldBottom) {
            z = false;
        }
        AbstractC6670b.m4758s("onLayoutChange() isSizeChanged=", " isPosChanged=", TAG, z2, z);
        if (z) {
            Log.i(TAG, "onGuidePositionChanged() current" + this.mCurrentView + " guide=" + this.mMonitoringView);
            View view2 = this.mCurrentView;
            if (view2 == null || (view = this.mMonitoringView) == null || (guidePositionChangedListener = this.mGuidePositionChangedListener) == null) {
                return;
            }
            guidePositionChangedListener.onGuidePositionChanged(view2.getId(), view.getId());
        }
    }

    public final void setGuidePositionChangedListener(@Nullable GuidePositionChangedListener listener) {
        this.mGuidePositionChangedListener = listener;
    }

    public final void setMonitorView(@Nullable View guide, @Nullable ConstraintLayout.LayoutParams params) {
        if (guide == null) {
            return;
        }
        Log.i(TAG, "setMonitorView() current=" + this.mCurrentView + " guide=" + guide);
        unregisterListener();
        this.mMonitoringView = guide;
        setToView(guide, params);
        changeCurrentVisibility(0);
    }

    public final boolean startMonitoring() {
        Log.i(TAG, "startMonitoring() isMonitoring=" + this.isMonitoring + " current=" + this.mCurrentView);
        if (this.isMonitoring) {
            return true;
        }
        return registerListener();
    }

    public final void stopMonitoring(boolean isHide) {
        Log.i(TAG, "stopMonitoring() isMonitoring=" + this.isMonitoring + " current=" + this.mCurrentView);
        if (this.isMonitoring) {
            unregisterListener();
            if (isHide) {
                changeCurrentVisibility(8);
            }
        }
    }
}
