package com.samsung.android.support.senl.addons.base.view.fragmentbase.popupwindow;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0006\u0010\u0014\u001a\u00020\u000eR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/view/fragmentbase/popupwindow/PopupWindowController;", "Lcom/samsung/android/support/senl/addons/base/view/fragmentbase/popupwindow/IPopupWindowProperties;", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "popupFlag", "", "<init>", "(Landroid/app/Activity;I)V", "mCloseButton", "Landroid/view/View;", "mOffset", "mIsCloseEnabled", "", "removeTransparentButton", "", "addCustomCloseButton", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "isCloseButtonTouched", "close", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PopupWindowController implements IPopupWindowProperties {

    @NotNull
    private static final String TAG = Logger.createTag("PopupWindowController");

    @Nullable
    private View mCloseButton;
    private boolean mIsCloseEnabled;
    private int mOffset;

    public PopupWindowController(@NotNull Activity activity, int i) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.mOffset = -1;
        if ((i & 1) != 0) {
            removeTransparentButton(activity);
        }
        if ((i & 2) != 0) {
            addCustomCloseButton(activity);
        }
    }

    private final void addCustomCloseButton(Activity activity) {
        int identifier = Resources.getSystem().getIdentifier("close_window", "id", TelemetryEventStrings.C6439Os.OS_NAME);
        Logger.m7104i(TAG, "addCustomCloseButton");
        if (identifier != -1) {
            this.mCloseButton = activity.getWindow().getDecorView().findViewById(identifier);
        }
    }

    private final boolean isCloseButtonTouched(MotionEvent ev) {
        View view = this.mCloseButton;
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        Intrinsics.checkNotNull(view);
        view.getLocationOnScreen(iArr);
        if (this.mOffset == -1) {
            View view2 = this.mCloseButton;
            Intrinsics.checkNotNull(view2);
            Object parent = view2.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
            int height = ((View) parent).getHeight();
            View view3 = this.mCloseButton;
            Intrinsics.checkNotNull(view3);
            this.mOffset = (height - view3.getHeight()) / 2;
        }
        int i = this.mOffset;
        View view4 = this.mCloseButton;
        Intrinsics.checkNotNull(view4);
        int width = view4.getWidth() + this.mOffset;
        View view5 = this.mCloseButton;
        Intrinsics.checkNotNull(view5);
        Rect rect = new Rect(-i, -i, width, view5.getHeight() + this.mOffset);
        rect.offset(iArr[0], iArr[1]);
        return rect.contains((int) ev.getRawX(), (int) ev.getRawY());
    }

    private final void removeTransparentButton(Activity activity) {
        View viewFindViewById;
        int identifier = Resources.getSystem().getIdentifier("trans_window", "id", TelemetryEventStrings.C6439Os.OS_NAME);
        Logger.m7104i(TAG, "removeTransparentButton");
        if (identifier <= 0 || (viewFindViewById = activity.findViewById(identifier)) == null) {
            return;
        }
        ViewParent parent = viewFindViewById.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) parent).removeView(viewFindViewById);
    }

    public final void close() {
        this.mCloseButton = null;
    }

    public final boolean dispatchTouchEvent(@NotNull MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (!isCloseButtonTouched(ev)) {
            this.mIsCloseEnabled = false;
            return false;
        }
        int action = ev.getAction();
        if (action == 0) {
            this.mIsCloseEnabled = true;
            return false;
        }
        if (action != 1 || !this.mIsCloseEnabled) {
            return false;
        }
        this.mIsCloseEnabled = false;
        return true;
    }
}
