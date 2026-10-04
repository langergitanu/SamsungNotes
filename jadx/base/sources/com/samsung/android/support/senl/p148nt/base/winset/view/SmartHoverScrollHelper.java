package com.samsung.android.support.senl.p148nt.base.winset.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.Size;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.widget.NestedScrollView;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.sdk.mobileservice.social.buddy.provider.BuddyContract;
import com.samsung.android.support.senl.p145cm.base.framework.content.PackageManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.provider.SettingsCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0018\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0007H\u0002J\u0018\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0002J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0007H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006#"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/view/SmartHoverScrollHelper;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "HOVERING_SPENICON_DEFAULT", "", "mSmartScrollRegion", "", "Landroid/graphics/Rect;", "[Landroid/graphics/Rect;", "mViewSize", "Landroid/util/Size;", "mCurrentIconRes", "mPreviousScrollTimeMS", "", "onHover", "", "view", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "canScrollable", BuddyContract.Address.REGION, "getRegionId", "x", "y", "updateSmartScrollRegion", "", "layoutWidth", "layoutHeight", "isValidRegion", "()Z", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SmartHoverScrollHelper {
    public static final int HORIZONTAL = 0;
    private static final int HOVER_AREA_FACTOR_VIA_VIEW_SIZE = 6;
    private static final float HOVER_AREA_RATIO_VIA_VIEW_SIZE = 0.16666667f;
    private static final float HOVER_SCROLL_SPEED = 200.0f;
    private static final int REGION_BOTTOM = 3;
    private static final int REGION_LEFT = 0;
    private static final int REGION_MAX = 4;
    private static final int REGION_RIGHT = 1;
    private static final int REGION_TOP = 2;

    @NotNull
    private static final String TAG = "SmartHoverScrollHelper";
    public static final int VERTICAL = 1;
    private static int sHoverScrollSpeed;
    private static boolean sIsInitialized;
    private static boolean sIsSamsungHoverDevice;
    private static int sMinViewSize;
    private static int sRegionThickness;
    private static int sResponseTime;
    private static int sVelocity;
    private final int HOVERING_SPENICON_DEFAULT;
    private int mCurrentIconRes;
    private long mPreviousScrollTimeMS;

    @NotNull
    private final Rect[] mSmartScrollRegion;

    @NotNull
    private final Size mViewSize;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final int[] SMART_SCROLL_ICON = new int[4];

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0007H\u0002J\u0010\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/view/SmartHoverScrollHelper$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "HORIZONTAL", "", "VERTICAL", "HOVER_AREA_FACTOR_VIA_VIEW_SIZE", "HOVER_AREA_RATIO_VIA_VIEW_SIZE", "", "REGION_LEFT", "REGION_RIGHT", "REGION_TOP", "REGION_BOTTOM", "REGION_MAX", "HOVER_SCROLL_SPEED", "SMART_SCROLL_ICON", "", "sIsInitialized", "", "sIsSamsungHoverDevice", "sResponseTime", "sVelocity", "sHoverScrollSpeed", "sRegionThickness", "sMinViewSize", "setHoverIcon", "", "view", "Landroid/view/View;", "toolType", "iconType", "initialize", "context", "Landroid/content/Context;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void initialize(Context context) {
            if (SmartHoverScrollHelper.sIsInitialized) {
                return;
            }
            SmartHoverScrollHelper.sIsSamsungHoverDevice = PackageManagerCompat.INSTANCE.getInstance().isSemHoverDevice(context);
            Logger.m8697d(SmartHoverScrollHelper.TAG, "initialize# IsSamsungHoverDevice = " + SmartHoverScrollHelper.sIsSamsungHoverDevice);
            SmartHoverScrollHelper.sResponseTime = context.getResources().getInteger(C8875R.integer.smart_scroll_response_time);
            SmartHoverScrollHelper.sVelocity = context.getResources().getInteger(C8875R.integer.smart_scroll_velocity);
            SmartHoverScrollHelper.sHoverScrollSpeed = (int) (TypedValue.applyDimension(1, 200.0f, context.getResources().getDisplayMetrics()) + 0.5f);
            SmartHoverScrollHelper.sRegionThickness = context.getResources().getDimensionPixelSize(C8875R.dimen.smart_scroll_thickness);
            SmartHoverScrollHelper.sMinViewSize = SmartHoverScrollHelper.sRegionThickness * 6;
            int[] iArr = SmartHoverScrollHelper.SMART_SCROLL_ICON;
            ViewCompat.Companion companion = ViewCompat.INSTANCE;
            iArr[0] = companion.getInstance().getStylusScrollLeftType();
            SmartHoverScrollHelper.SMART_SCROLL_ICON[1] = companion.getInstance().getStylusScrollRightType();
            SmartHoverScrollHelper.SMART_SCROLL_ICON[2] = companion.getInstance().getStylusScrollUpType();
            SmartHoverScrollHelper.SMART_SCROLL_ICON[3] = companion.getInstance().getStylusScrollDownType();
            SmartHoverScrollHelper.sIsInitialized = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void setHoverIcon(View view, int toolType, int iconType) {
            AbstractC4539a.m3203m(iconType, "setHoverIcon : ", SmartHoverScrollHelper.TAG);
            ViewCompat.INSTANCE.getInstance().setPointerIcon(view, toolType, iconType);
        }

        private Companion() {
        }
    }

    public SmartHoverScrollHelper(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mSmartScrollRegion = new Rect[4];
        this.mViewSize = new Size(0, 0);
        INSTANCE.initialize(context);
        int hoveringSpenIconDefault = ViewCompat.INSTANCE.getInstance().getHoveringSpenIconDefault();
        this.HOVERING_SPENICON_DEFAULT = hoveringSpenIconDefault;
        this.mCurrentIconRes = hoveringSpenIconDefault;
        this.mPreviousScrollTimeMS = System.currentTimeMillis();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean canScrollable(View view, int region) {
        boolean zCanScrollHorizontally;
        int i;
        int scrollX = view.getScrollX();
        int scrollY = view.getScrollY();
        boolean zCanScrollVertically = false;
        if (region == 0) {
            zCanScrollHorizontally = view.canScrollHorizontally(-1);
            scrollX -= sVelocity;
        } else {
            if (region != 1) {
                if (region == 2) {
                    zCanScrollVertically = view.canScrollVertically(-1);
                    scrollY -= sVelocity;
                    i = -sHoverScrollSpeed;
                } else if (region != 3) {
                    i = 0;
                } else {
                    zCanScrollVertically = view.canScrollVertically(1);
                    scrollY += sVelocity;
                    i = sHoverScrollSpeed;
                }
                long jCurrentTimeMillis = System.currentTimeMillis() - this.mPreviousScrollTimeMS;
                if (zCanScrollVertically && jCurrentTimeMillis > sResponseTime) {
                    if (view instanceof NestedScrollView) {
                        view.scrollTo(scrollX, scrollY);
                    } else {
                        ((NestedScrollView) view).fling(i);
                    }
                    this.mPreviousScrollTimeMS = System.currentTimeMillis();
                }
                return zCanScrollVertically;
            }
            zCanScrollHorizontally = view.canScrollHorizontally(1);
            scrollX += sVelocity;
        }
        zCanScrollVertically = zCanScrollHorizontally;
        i = 0;
        long jCurrentTimeMillis2 = System.currentTimeMillis() - this.mPreviousScrollTimeMS;
        if (zCanScrollVertically) {
            if (view instanceof NestedScrollView) {
            }
            this.mPreviousScrollTimeMS = System.currentTimeMillis();
        }
        return zCanScrollVertically;
    }

    private final int getRegionId(int x, int y2) {
        for (int i = 0; i < 4; i++) {
            Rect rect = this.mSmartScrollRegion[i];
            if (rect != null && rect.contains(x, y2)) {
                return i;
            }
        }
        return -1;
    }

    private final boolean isValidRegion() {
        Rect[] rectArr = this.mSmartScrollRegion;
        return (rectArr[0] == null || rectArr[1] == null || rectArr[2] == null || rectArr[3] == null) ? false : true;
    }

    private final void updateSmartScrollRegion(int layoutWidth, int layoutHeight) {
        if (layoutWidth == this.mViewSize.getWidth() && layoutHeight == this.mViewSize.getHeight() && isValidRegion()) {
            return;
        }
        Logger.m8697d(TAG, "updateSmartScrollRegion : " + layoutWidth + "x" + layoutHeight);
        int i = sRegionThickness;
        int i2 = sMinViewSize;
        int i4 = layoutWidth < i2 ? (int) (layoutWidth * HOVER_AREA_RATIO_VIA_VIEW_SIZE) : i;
        int i5 = layoutWidth - i4;
        if (layoutHeight < i2) {
            i = (int) (layoutHeight * HOVER_AREA_RATIO_VIA_VIEW_SIZE);
        }
        this.mSmartScrollRegion[0] = new Rect(0, 0, i4, layoutHeight);
        this.mSmartScrollRegion[1] = new Rect(i5, 0, layoutWidth, layoutHeight);
        this.mSmartScrollRegion[2] = new Rect(0, 0, layoutWidth, i);
        this.mSmartScrollRegion[3] = new Rect(0, layoutHeight - i, layoutWidth, layoutHeight);
    }

    public final boolean onHover(@NotNull View view, @NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(event, "event");
        if ((!sIsSamsungHoverDevice && !SettingsCompat.INSTANCE.getInstance().isAirViewSettingEnabled(view.getContext())) || event.getToolType(0) != 2) {
            return false;
        }
        updateSmartScrollRegion(view.getWidth(), view.getHeight());
        int action = event.getAction();
        if (action == 7 || action == 9) {
            int regionId = getRegionId((int) event.getX(), (int) event.getY());
            if (1 <= regionId && regionId < 4 && canScrollable(view, regionId)) {
                int i = this.mCurrentIconRes;
                int[] iArr = SMART_SCROLL_ICON;
                if (i != iArr[regionId]) {
                    INSTANCE.setHoverIcon(view, event.getToolType(0), iArr[regionId]);
                    this.mCurrentIconRes = iArr[regionId];
                }
                return true;
            }
        } else if (action == 10 && this.mCurrentIconRes != this.HOVERING_SPENICON_DEFAULT) {
            INSTANCE.setHoverIcon(view, event.getToolType(0), this.HOVERING_SPENICON_DEFAULT);
            this.mCurrentIconRes = this.HOVERING_SPENICON_DEFAULT;
        }
        return false;
    }
}
