package com.samsung.android.support.senl.p148nt.base.winset.view.floater;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.MotionEvent;
import androidx.annotation.IntRange;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 92\u00020\u0001:\u00046789J\u001a\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\b\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&J\"\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H&J\b\u0010\u0013\u001a\u00020\u0003H&J\"\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H&J\b\u0010\u0019\u001a\u00020\u0003H&J\b\u0010\u001a\u001a\u00020\u0003H&J\b\u0010\u001e\u001a\u00020\nH&J\u0010\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020!H&J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010 \u001a\u00020&H&J\b\u0010'\u001a\u00020\u0003H&J\b\u0010(\u001a\u00020\u0003H&J\u0012\u0010)\u001a\u00020\u00032\b\u0010*\u001a\u0004\u0018\u00010+H&J\u0010\u0010-\u001a\u00020\u00032\u0006\u0010*\u001a\u00020+H&J\u0010\u0010.\u001a\u00020\u00032\u0006\u0010/\u001a\u00020\u0011H&J\u0010\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u000205H&R\u0012\u0010\u001b\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0012\u0010\"\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u001dR\u0012\u0010#\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u001dR\u0012\u0010$\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u001dR\u0012\u0010,\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\u001dR\u0014\u00100\u001a\u00020\u00058gX¦\u0004¢\u0006\u0006\u001a\u0004\b1\u00102¨\u0006:"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/view/floater/IFloater;", "", "addDock", "", "id", "", "dock", "Lcom/samsung/android/support/senl/nt/base/winset/view/floater/IDock;", "blockadeDock", "blockade", "", "startShowAnimation", "startHideAnimation", "onScroll", "event", "Landroid/view/MotionEvent;", "distanceX", "", "distanceY", "onLongPress", "onFling", "velocityX", "velocityY", "withEndAction", "Ljava/lang/Runnable;", "onFieldSizeChanged", "dropAction", "enabledDocking", "getEnabledDocking", "()Z", "isPressed", "contains", "point", "Landroid/graphics/PointF;", "isFreezeState", "isStateDocking", "isVisible", "animateToFinalPosition", "Landroid/graphics/Point;", "cancelTranslationAnimation", "captureOriginPosition", "getOriginRect", "rect", "Landroid/graphics/Rect;", "isAcceptableOverlap", "getHitRect", "setAlpha", "alpha", "state", "getState", "()I", "addModeChangeListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/support/senl/nt/base/winset/view/floater/IFloater$ModeChangeListener;", "ModeChangeListener", "IContract", "IViewContract", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IFloater {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int DOCKER_ID_SIDE_BOTTOM = 1;
    public static final int DOCKER_ID_SIDE_END = 3;
    public static final int DOCKER_ID_SIDE_NONE = -1;
    public static final int DOCKER_ID_SIDE_START = 2;
    public static final int DOCKER_ID_SIDE_TOP = 0;
    public static final int DROP_TYPE_X = 1;
    public static final int DROP_TYPE_Y = 2;
    public static final int DROP_TYPE_Y_FLING = 3;
    public static final int STATE_CHANGING = 1;
    public static final int STATE_DOCKED = 2;
    public static final int STATE_UNDOCKED = 0;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/view/floater/IFloater$Companion;", "", "<init>", "()V", "DOCKER_ID_SIDE_NONE", "", "DOCKER_ID_SIDE_TOP", "DOCKER_ID_SIDE_BOTTOM", "DOCKER_ID_SIDE_START", "DOCKER_ID_SIDE_END", "STATE_UNDOCKED", "STATE_CHANGING", "STATE_DOCKED", "DROP_TYPE_X", "DROP_TYPE_Y", "DROP_TYPE_Y_FLING", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int DOCKER_ID_SIDE_BOTTOM = 1;
        public static final int DOCKER_ID_SIDE_END = 3;
        public static final int DOCKER_ID_SIDE_NONE = -1;
        public static final int DOCKER_ID_SIDE_START = 2;
        public static final int DOCKER_ID_SIDE_TOP = 0;
        public static final int DROP_TYPE_X = 1;
        public static final int DROP_TYPE_Y = 2;
        public static final int DROP_TYPE_Y_FLING = 3;
        public static final int STATE_CHANGING = 1;
        public static final int STATE_DOCKED = 2;
        public static final int STATE_UNDOCKED = 0;

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/view/floater/IFloater$IContract;", "", "getSnappingDelta", "", "targetBorder", "predictivePosition", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IContract {
        int getSnappingDelta(int targetBorder, int predictivePosition);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/view/floater/IFloater$IViewContract;", "", "parentWidth", "", "getParentWidth", "()I", "parentHeight", "getParentHeight", "endEdgeSize", "", "getEndEdgeSize", "()F", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IViewContract {
        float getEndEdgeSize();

        int getParentHeight();

        int getParentWidth();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/view/floater/IFloater$ModeChangeListener;", "", "onModeChanged", "", "mode", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface ModeChangeListener {
        void onModeChanged(@IntRange(from = 0, m706to = 2) int mode);
    }

    void addDock(@IntRange(from = 0, m706to = 3) int id, @NotNull IDock dock);

    void addModeChangeListener(@NotNull ModeChangeListener listener);

    void animateToFinalPosition(@NotNull Point point);

    void blockadeDock(@IntRange(from = 0, m706to = 3) int id, boolean blockade);

    void cancelTranslationAnimation();

    void captureOriginPosition();

    boolean contains(@NotNull PointF point);

    void dropAction();

    boolean getEnabledDocking();

    void getHitRect(@NotNull Rect rect);

    void getOriginRect(@Nullable Rect rect);

    @IntRange(from = 0, m706to = 2)
    int getState();

    boolean isAcceptableOverlap();

    boolean isFreezeState();

    boolean isPressed();

    boolean isStateDocking();

    boolean isVisible();

    void onFieldSizeChanged();

    boolean onFling(float velocityX, float velocityY, @Nullable Runnable withEndAction);

    void onLongPress();

    boolean onScroll(@Nullable MotionEvent event, float distanceX, float distanceY);

    void setAlpha(float alpha);

    void startHideAnimation();

    void startShowAnimation();
}
