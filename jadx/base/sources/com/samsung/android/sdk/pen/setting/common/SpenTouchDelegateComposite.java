package com.samsung.android.sdk.pen.setting.common;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\b\u0001\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u001a\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001J\u0010\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/common/SpenTouchDelegateComposite;", "Landroid/view/TouchDelegate;", "delegateView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "delegates", "", "delegateViews", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "close", "", "removeAllDelegate", "addDelegate", "delegate", "removeDelegate", "findView", "", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SuppressLint({"LongLogTag"})
public final class SpenTouchDelegateComposite extends TouchDelegate {

    @NotNull
    private static final String TAG = "SpenTouchDelegateComposite";

    @NotNull
    private final List<View> delegateViews;

    @NotNull
    private final List<TouchDelegate> delegates;

    @NotNull
    private static final Rect emptyRect = new Rect();

    public SpenTouchDelegateComposite(@Nullable View view) {
        super(emptyRect, view);
        this.delegates = new ArrayList();
        this.delegateViews = new ArrayList();
    }

    private final int findView(View delegateView) {
        return this.delegateViews.indexOf(delegateView);
    }

    public final void addDelegate(@Nullable View delegateView, @Nullable TouchDelegate delegate) {
        if (delegate == null || delegateView == null) {
            return;
        }
        int iFindView = findView(delegateView);
        if (iFindView > -1) {
            Log.i(TAG, "addDelegate() already existed. so change.");
            this.delegates.set(iFindView, delegate);
        } else {
            this.delegateViews.add(delegateView);
            this.delegates.add(delegate);
            AbstractC2322a.m1631u(this.delegates.size(), "addDelegate() size=", TAG);
        }
    }

    public final void close() {
        Log.i(TAG, "close()");
        removeAllDelegate();
    }

    @Override // android.view.TouchDelegate
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        float x = event.getX();
        float y2 = event.getY();
        Iterator<TouchDelegate> it = this.delegates.iterator();
        while (true) {
            boolean z = false;
            while (it.hasNext()) {
                TouchDelegate next = it.next();
                event.setLocation(x, y2);
                if ((next != null ? next.onTouchEvent(event) : false) || z) {
                    z = true;
                }
            }
            return z;
        }
    }

    public final void removeAllDelegate() {
        this.delegateViews.clear();
        this.delegates.clear();
    }

    public final void removeDelegate(@Nullable View delegateView) {
        int iFindView;
        if (delegateView == null || (iFindView = findView(delegateView)) == -1) {
            return;
        }
        AbstractC2322a.m1631u(iFindView, "deleteDelegate() index=", TAG);
        this.delegates.remove(iFindView);
        this.delegateViews.remove(iFindView);
    }
}
