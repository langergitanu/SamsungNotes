package com.samsung.android.support.senl.addons.brush.util;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.support.senl.addons.C7944R;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\nJ\u000e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0005J\u0006\u0010\u0017\u001a\u00020\u0013J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aH\u0007J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0005H\u0007J \u0010\u0018\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0005H\u0007J\u0012\u0010\u001e\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0007J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0005H\u0007J \u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0005H\u0007J\u001a\u0010\u001f\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010 \u001a\u00020\u0005H\u0002J\u0018\u0010!\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020&H\u0002J\b\u0010'\u001a\u00020\u0013H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/util/BrushToastHandler;", "", "<init>", "()V", "LONG_DELAY", "", "SHORT_DELAY", "BRUSH_TOAST_HIDE", "mContextRef", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "mDegree", "mPrevDegree", "mDelay", "mToastContainer", "Landroid/view/ViewGroup;", "mToastHandler", "Landroid/os/Handler;", "setContext", "", "context", "setRotation", "degree", "close", "showLong", "content", "", "id", "quantity", "num", "showShort", "makeCustomToast", "delay", "makeToastView", "Landroid/view/View;", "addToast", "toastContainer", ActionHandler.PARAMS, "Landroid/view/WindowManager$LayoutParams;", "removeToast", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BrushToastHandler {
    private static final int BRUSH_TOAST_HIDE = 1;
    private static final int LONG_DELAY = 3500;
    private static final int SHORT_DELAY = 2000;

    @Nullable
    private static WeakReference<Context> mContextRef;

    @Nullable
    private static WeakReference<ViewGroup> mToastContainer;

    @Nullable
    private static Handler mToastHandler;

    @NotNull
    public static final BrushToastHandler INSTANCE = new BrushToastHandler();
    private static int mDegree = -1;
    private static int mPrevDegree = -1;
    private static int mDelay = -1;

    private BrushToastHandler() {
    }

    private final void addToast(ViewGroup toastContainer, WindowManager.LayoutParams params) {
        WeakReference<Context> weakReference = mContextRef;
        Intrinsics.checkNotNull(weakReference);
        Context context = weakReference.get();
        if (context == null) {
            return;
        }
        Object systemService = context.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        mToastContainer = new WeakReference<>(toastContainer);
        ((WindowManager) systemService).addView(toastContainer, params);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void makeCustomToast(String content, int delay) {
        WeakReference<Context> weakReference = mContextRef;
        Intrinsics.checkNotNull(weakReference);
        Context context = weakReference.get();
        if (context == null) {
            return;
        }
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.type = 1000;
        layoutParams.format = -3;
        layoutParams.windowAnimations = R.style.Animation.Toast;
        layoutParams.flags = 24;
        int i = mDegree;
        int i2 = mPrevDegree;
        if (i < 0) {
            i = 0;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        ViewGroup frameLayout = new FrameLayout(context);
        View viewMakeToastView = makeToastView(context, String.valueOf(content));
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(C7944R.dimen.brush_custom_toast_bottom_margin);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        viewMakeToastView.setRotation(i);
        viewMakeToastView.measure(0, 0);
        int measuredWidth = viewMakeToastView.getMeasuredWidth();
        if (i == 0) {
            layoutParams2.setMargins(0, 0, 0, dimensionPixelSize);
            layoutParams2.gravity = 81;
        } else if (i == 90) {
            layoutParams2.setMarginStart(dimensionPixelSize - (measuredWidth >> 1));
            layoutParams2.gravity = 8388627;
        } else if (i != 180) {
            if (i == 270) {
                layoutParams2.setMarginEnd(dimensionPixelSize - (measuredWidth >> 1));
                layoutParams2.gravity = 8388629;
            }
        }
        frameLayout.addView(viewMakeToastView, layoutParams2);
        if (mToastContainer == null) {
            addToast(frameLayout, layoutParams);
        } else {
            Handler handler = mToastHandler;
            Intrinsics.checkNotNull(handler);
            handler.removeMessages(1);
            if (i2 != i) {
                removeToast();
                addToast(frameLayout, layoutParams);
            }
        }
        Handler handler2 = mToastHandler;
        Message messageObtainMessage = handler2 != null ? handler2.obtainMessage(1) : null;
        if (messageObtainMessage != null) {
            Handler handler3 = mToastHandler;
            Intrinsics.checkNotNull(handler3);
            handler3.sendMessageDelayed(messageObtainMessage, delay);
        }
        mDelay = delay;
    }

    private final View makeToastView(Context context, String content) {
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(C7944R.dimen.brush_custom_toast_padding_start_end);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(C7944R.dimen.brush_custom_toast_padding_top_bottom);
        FrameLayout frameLayout = new FrameLayout(context);
        TextView textView = new TextView(context);
        textView.setTextSize(0, resources.getDimensionPixelSize(C7944R.dimen.brush_custom_toast_text_size));
        textView.setTextColor(resources.getColor(C7944R.color.brush_custom_toast_text_color, null));
        textView.setText(content);
        int dimensionPixelOffset = resources.getDimensionPixelOffset(C7944R.dimen.brush_custom_toast_text_padding);
        textView.setPaddingRelative(0, dimensionPixelOffset, 0, dimensionPixelOffset);
        frameLayout.addView(textView);
        frameLayout.setBackground(resources.getDrawable(C7944R.drawable.brush_toast_popup_frame_bg, null));
        frameLayout.setPaddingRelative(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2);
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeToast() {
        WeakReference<Context> weakReference;
        if (mToastContainer == null || (weakReference = mContextRef) == null) {
            return;
        }
        Intrinsics.checkNotNull(weakReference);
        Context context = weakReference.get();
        if (context == null) {
            return;
        }
        WeakReference<ViewGroup> weakReference2 = mToastContainer;
        Intrinsics.checkNotNull(weakReference2);
        ViewGroup viewGroup = weakReference2.get();
        if (viewGroup != null) {
            Object systemService = context.getSystemService("window");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            ((WindowManager) systemService).removeView(viewGroup);
            WeakReference<ViewGroup> weakReference3 = mToastContainer;
            Intrinsics.checkNotNull(weakReference3);
            weakReference3.clear();
        }
        mToastContainer = null;
        mDelay = -1;
    }

    @JvmStatic
    public static final void showLong(@NotNull String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        INSTANCE.makeCustomToast(content, 3500);
    }

    @JvmStatic
    public static final void showShort(@Nullable String content) {
        INSTANCE.makeCustomToast(content, 2000);
    }

    public final void close() {
        Handler handler = mToastHandler;
        if (handler != null) {
            Intrinsics.checkNotNull(handler);
            handler.removeMessages(1);
            mToastHandler = null;
        }
        removeToast();
        WeakReference<Context> weakReference = mContextRef;
        if (weakReference != null) {
            weakReference.clear();
        }
    }

    public final void setContext(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        mContextRef = new WeakReference<>(context);
        mToastHandler = new Handler(Looper.getMainLooper()) { // from class: com.samsung.android.support.senl.addons.brush.util.BrushToastHandler.setContext.1
            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                Intrinsics.checkNotNullParameter(msg, "msg");
                if (msg.what == 1) {
                    BrushToastHandler.INSTANCE.removeToast();
                }
            }
        };
    }

    public final void setRotation(int degree) {
        int i = mDegree;
        mPrevDegree = i;
        mDegree = degree;
        WeakReference<ViewGroup> weakReference = mToastContainer;
        if (weakReference == null || mDelay <= 0 || i == degree) {
            return;
        }
        Intrinsics.checkNotNull(weakReference);
        ViewGroup viewGroup = weakReference.get();
        Intrinsics.checkNotNull(viewGroup);
        View childAt = viewGroup.getChildAt(0);
        Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.view.ViewGroup");
        View childAt2 = ((ViewGroup) childAt).getChildAt(0);
        if (childAt2 instanceof TextView) {
            makeCustomToast(((TextView) childAt2).getText().toString(), mDelay);
        }
    }

    @JvmStatic
    public static final void showLong(int id) {
        WeakReference<Context> weakReference = mContextRef;
        Intrinsics.checkNotNull(weakReference);
        Context context = weakReference.get();
        if (context != null) {
            INSTANCE.makeCustomToast(context.getResources().getString(id), 3500);
        }
    }

    @JvmStatic
    public static final void showShort(int id) {
        WeakReference<Context> weakReference = mContextRef;
        Intrinsics.checkNotNull(weakReference);
        Context context = weakReference.get();
        if (context != null) {
            INSTANCE.makeCustomToast(context.getResources().getString(id), 2000);
        }
    }

    @JvmStatic
    public static final void showLong(int id, int quantity, int num) {
        WeakReference<Context> weakReference = mContextRef;
        Intrinsics.checkNotNull(weakReference);
        Context context = weakReference.get();
        if (context != null) {
            INSTANCE.makeCustomToast(context.getResources().getQuantityString(id, quantity, Integer.valueOf(num)), 3500);
        }
    }

    @JvmStatic
    public static final void showShort(int id, int quantity, int num) {
        WeakReference<Context> weakReference = mContextRef;
        Intrinsics.checkNotNull(weakReference);
        Context context = weakReference.get();
        if (context != null) {
            INSTANCE.makeCustomToast(context.getResources().getQuantityString(id, quantity, Integer.valueOf(num)), 2000);
        }
    }
}
