package com.samsung.android.support.senl.p148nt.app.addons;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import com.samsung.android.app.notes.widget.glance.single.setting.view.ViewOnTouchListenerC7005f;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0007J\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\u000f\u001a\u00020\nR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\f\u0010\u000e¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/addons/AddonsProgressController;", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "mActivity", "mProgressView", "Landroid/widget/LinearLayout;", "showProgress", "", "hideProgress", "isShowing", "", "()Z", "onDestroy", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAddonsProgressController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AddonsProgressController.kt\ncom/samsung/android/support/senl/nt/app/addons/AddonsProgressController\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,57:1\n1#2:58\n*E\n"})
public final class AddonsProgressController {

    @Nullable
    private Activity mActivity;

    @Nullable
    private LinearLayout mProgressView;

    public AddonsProgressController(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.mActivity = activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hideProgress$lambda$4(AddonsProgressController addonsProgressController) {
        LinearLayout linearLayout = addonsProgressController.mProgressView;
        if (linearLayout != null) {
            linearLayout.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showProgress$lambda$2(AddonsProgressController addonsProgressController) {
        LinearLayout linearLayout = addonsProgressController.mProgressView;
        if (linearLayout != null) {
            linearLayout.setOnTouchListener(new ViewOnTouchListenerC7005f(7));
            linearLayout.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean showProgress$lambda$2$lambda$1$lambda$0(View view, MotionEvent motionEvent) {
        return true;
    }

    public final void hideProgress() {
        Activity activity = this.mActivity;
        if (activity != null) {
            activity.runOnUiThread(new RunnableC8015c(this, 0));
        }
    }

    public final boolean isShowing() {
        LinearLayout linearLayout = this.mProgressView;
        return linearLayout != null && linearLayout.getVisibility() == 0;
    }

    public final void onDestroy() {
        Window window;
        LinearLayout linearLayout = this.mProgressView;
        if (linearLayout != null) {
            if (linearLayout != null && linearLayout.isAttachedToWindow()) {
                Activity activity = this.mActivity;
                ViewGroup viewGroup = (ViewGroup) ((activity == null || (window = activity.getWindow()) == null) ? null : window.getDecorView());
                if (viewGroup != null) {
                    viewGroup.removeView(this.mProgressView);
                }
            }
            this.mProgressView = null;
        }
        this.mActivity = null;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void showProgress() {
        if (this.mProgressView == null) {
            Activity activity = this.mActivity;
            Intrinsics.checkNotNull(activity);
            View decorView = activity.getWindow().getDecorView();
            Intrinsics.checkNotNull(decorView, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup = (ViewGroup) decorView;
            LinearLayout linearLayout = new LinearLayout(this.mActivity);
            this.mProgressView = linearLayout;
            Intrinsics.checkNotNull(linearLayout);
            linearLayout.setGravity(17);
            LayoutInflater.from(viewGroup.getContext()).inflate(C8003R.layout.notes_progress_circle, (ViewGroup) this.mProgressView, true);
            viewGroup.addView(this.mProgressView);
        }
        Activity activity2 = this.mActivity;
        if (activity2 != null) {
            activity2.runOnUiThread(new RunnableC8015c(this, 1));
        }
    }
}
