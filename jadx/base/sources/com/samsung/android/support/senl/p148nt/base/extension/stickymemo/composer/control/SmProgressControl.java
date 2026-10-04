package com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.app.notes.widget.glance.single.setting.view.ViewOnTouchListenerC7005f;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.common.util.SmLogger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0017\u0018\u0000 \u00162\u00020\u0001:\u0002\u0015\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u0012\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\fH\u0002J\b\u0010\u0011\u001a\u00020\fH\u0002J\b\u0010\u0012\u001a\u00020\fH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00060\bR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmProgressControl;", "", "<init>", "()V", "blockingView", "Landroid/view/View;", "progressView", "handler", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmProgressControl$CustomHandler;", "startTime", "", "init", "", "rootView", "showProgress", "delay", "showBlockingView", "showProgressView", "hideProgress", "isShowing", "", "CustomHandler", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SuppressLint({"ClickableViewAccessibility"})
public class SmProgressControl {
    public static final long MIN_SHOW_TIME = 500;
    public static final int MSG_HIDE = 2;
    public static final int MSG_SHOW = 1;
    private View blockingView;

    @NotNull
    private final CustomHandler handler;
    private View progressView;
    private long startTime;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = SmLogger.createTag("ProgressControl");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmProgressControl$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getTAG", "()Ljava/lang/String;", "MIN_SHOW_TIME", "", "MSG_SHOW", "", "MSG_HIDE", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getTAG() {
            return SmProgressControl.TAG;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmProgressControl$CustomHandler;", "Landroid/os/Handler;", "looper", "Landroid/os/Looper;", "<init>", "(Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmProgressControl;Landroid/os/Looper;)V", "handleMessage", "", "msg", "Landroid/os/Message;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class CustomHandler extends Handler {
        final /* synthetic */ SmProgressControl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CustomHandler(@NotNull SmProgressControl smProgressControl, Looper looper) {
            super(looper);
            Intrinsics.checkNotNullParameter(looper, "looper");
            this.this$0 = smProgressControl;
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message msg) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            int i = msg.what;
            if (i != 1) {
                if (i != 2) {
                    return;
                }
                this.this$0.hideProgress();
            } else {
                this.this$0.startTime = System.currentTimeMillis();
                this.this$0.showProgressView();
            }
        }
    }

    public SmProgressControl() {
        Looper mainLooper = Looper.getMainLooper();
        Intrinsics.checkNotNullExpressionValue(mainLooper, "getMainLooper(...)");
        this.handler = new CustomHandler(this, mainLooper);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean init$lambda$0(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean init$lambda$1(View view, DragEvent dragEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean init$lambda$2(View view, int i, KeyEvent keyEvent) {
        return true;
    }

    private final void showBlockingView() {
        View view = this.blockingView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blockingView");
            view = null;
        }
        view.setVisibility(0);
    }

    public static /* synthetic */ void showProgress$default(SmProgressControl smProgressControl, long j, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showProgress");
        }
        if ((i & 1) != 0) {
            j = 500;
        }
        smProgressControl.showProgress(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showProgressView() {
        SmLogger.m8661d(TAG, "showProgressView#  " + System.currentTimeMillis());
        View view = this.progressView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressView");
            view = null;
        }
        view.setVisibility(0);
    }

    public void hideProgress() {
        String str = TAG;
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this.startTime;
        StringBuilder sbM1323p = AbstractC1974b.m1323p(jCurrentTimeMillis, "hideProgress# ", " ");
        sbM1323p.append(j);
        SmLogger.m8661d(str, sbM1323p.toString());
        View view = this.progressView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressView");
            view = null;
        }
        if (view.getVisibility() != 0) {
            SmLogger.m8661d(str, "hideProgress# blocking view only");
            this.handler.removeMessages(1);
            View view3 = this.blockingView;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("blockingView");
            } else {
                view2 = view3;
            }
            view2.setVisibility(8);
            return;
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis() - this.startTime;
        if (jCurrentTimeMillis2 < 500) {
            Message messageObtainMessage = this.handler.obtainMessage(2);
            Intrinsics.checkNotNullExpressionValue(messageObtainMessage, "obtainMessage(...)");
            long j2 = 500 - jCurrentTimeMillis2;
            this.handler.sendMessageDelayed(messageObtainMessage, j2);
            SmLogger.m8661d(str, "hideProgress# delay " + j2);
            return;
        }
        View view4 = this.progressView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressView");
            view4 = null;
        }
        view4.setVisibility(8);
        View view5 = this.blockingView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blockingView");
        } else {
            view2 = view5;
        }
        view2.setVisibility(8);
        SmLogger.m8661d(str, "hideProgress# done");
    }

    public void init(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        View viewFindViewById = rootView.findViewById(C8875R.id.progress_container);
        this.blockingView = viewFindViewById;
        View view = null;
        if (viewFindViewById == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blockingView");
            viewFindViewById = null;
        }
        this.progressView = viewFindViewById.findViewById(C8875R.id.progress_circle);
        View view2 = this.blockingView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blockingView");
            view2 = null;
        }
        view2.setOnTouchListener(new ViewOnTouchListenerC7005f(11));
        View view3 = this.blockingView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blockingView");
            view3 = null;
        }
        view3.setOnDragListener(new ViewOnDragListenerC8926a());
        View view4 = this.blockingView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blockingView");
        } else {
            view = view4;
        }
        view.setOnKeyListener(new ViewOnKeyListenerC8930b());
    }

    public boolean isShowing() {
        View view = this.progressView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressView");
            view = null;
        }
        return view.getVisibility() == 0;
    }

    public void showProgress(long delay) {
        SmLogger.m8661d(TAG, "showProgress# " + delay);
        showBlockingView();
        if (delay <= 0) {
            this.startTime = System.currentTimeMillis();
            showProgressView();
        } else {
            Message messageObtainMessage = this.handler.obtainMessage(1);
            Intrinsics.checkNotNullExpressionValue(messageObtainMessage, "obtainMessage(...)");
            this.handler.sendMessageDelayed(messageObtainMessage, delay);
        }
    }
}
