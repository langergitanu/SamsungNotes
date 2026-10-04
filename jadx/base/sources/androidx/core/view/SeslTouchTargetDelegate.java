package androidx.core.view;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.ArrayMap;
import android.util.Log;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.compose.p109ui.platform.AbstractC2210j;
import androidx.core.util.Consumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public class SeslTouchTargetDelegate extends TouchDelegate {
    public static boolean DEBUG = false;
    private static final String TAG = "SeslTouchTargetDelegate";

    @NonNull
    final View mAnchorView;

    @NonNull
    final HashSet<CapturedTouchDelegate> mTouchDelegateSet;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder {
        private final View mAnchorView;
        private final Queue<Consumer<SeslTouchTargetDelegate>> mQueue = new LinkedList();

        public Builder(@NonNull View view) {
            this.mAnchorView = view;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$create$1(Consumer consumer) {
            SeslTouchTargetDelegate seslTouchTargetDelegate = new SeslTouchTargetDelegate(this.mAnchorView);
            Iterator<Consumer<SeslTouchTargetDelegate>> it = this.mQueue.iterator();
            while (it.hasNext()) {
                it.next().accept(seslTouchTargetDelegate);
            }
            consumer.accept(seslTouchTargetDelegate);
            if (SeslTouchTargetDelegate.DEBUG) {
                SeslTouchTargetDelegate.drawTouchBounds(this.mAnchorView, seslTouchTargetDelegate.mTouchDelegateSet);
            }
        }

        @NonNull
        public Builder addDelegateView(@NonNull final View view, @Nullable final ExtraInsets extraInsets) {
            this.mQueue.add(new Consumer() { // from class: androidx.core.view.k
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    ((SeslTouchTargetDelegate) obj).addTouchDelegate(view, extraInsets);
                }
            });
            return this;
        }

        public void apply() {
            final View view = this.mAnchorView;
            Objects.requireNonNull(view);
            create(new Consumer() { // from class: androidx.core.view.i
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    view.setTouchDelegate((SeslTouchTargetDelegate) obj);
                }
            });
        }

        public void create(@NonNull final Consumer<SeslTouchTargetDelegate> consumer) {
            this.mAnchorView.post(new Runnable() { // from class: androidx.core.view.j
                @Override // java.lang.Runnable
                public final void run() {
                    this.f1345a.lambda$create$1(consumer);
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CapturedTouchDelegate extends TouchDelegate {

        @NonNull
        protected final Rect mBounds;

        @NonNull
        protected final View mView;

        public CapturedTouchDelegate(@NonNull Rect rect, @NonNull View view) {
            super(rect, view);
            this.mBounds = rect;
            this.mView = view;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InvalidDelegateViewException extends RuntimeException {
        public InvalidDelegateViewException() {
            super("TouchTargetDelegate's delegateView must be child of anchorView");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class TouchBoundsPainter {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class TouchBoundsBitmapDrawable extends BitmapDrawable {
            public TouchBoundsBitmapDrawable(@NonNull Resources resources, @NonNull Bitmap bitmap) {
                super(resources, bitmap);
            }
        }

        @RequiresApi(api = 23)
        public static void drawTouchBounds(@NonNull View view, @NonNull List<Rect> list) {
            if (view.getMeasuredWidth() <= 0 || view.getMeasuredHeight() <= 0) {
                return;
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            canvas.drawColor(0);
            Paint paint = new Paint();
            paint.setStrokeWidth(3.0f);
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(Color.parseColor("#34C3EF"));
            Iterator<Rect> it = list.iterator();
            while (it.hasNext()) {
                canvas.drawRect(it.next(), paint);
            }
            TouchBoundsBitmapDrawable touchBoundsBitmapDrawable = new TouchBoundsBitmapDrawable(view.getResources(), bitmapCreateBitmap);
            Drawable foreground = view.getForeground();
            if (foreground instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) foreground;
                int numberOfLayers = layerDrawable.getNumberOfLayers() - 1;
                if (layerDrawable.getDrawable(numberOfLayers) instanceof TouchBoundsBitmapDrawable) {
                    layerDrawable.setDrawable(numberOfLayers, touchBoundsBitmapDrawable);
                    return;
                }
            }
            view.setForeground(new LayerDrawable((Drawable[]) Arrays.asList(foreground, touchBoundsBitmapDrawable).toArray(new Drawable[2])));
        }
    }

    public SeslTouchTargetDelegate(@NonNull View view) {
        super(new Rect(), view);
        this.mTouchDelegateSet = new HashSet<>();
        this.mAnchorView = view;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Rect calculateViewBounds(@NonNull View view, @NonNull View view2) {
        Rect rect = new Rect(0, 0, view2.getWidth(), view2.getHeight());
        Rect rect2 = new Rect();
        while (!view2.equals(view)) {
            view2.getHitRect(rect2);
            rect.left += rect2.left;
            rect.right += rect2.left;
            rect.top += rect2.top;
            rect.bottom += rect2.top;
            Object parent = view2.getParent();
            if (!(parent instanceof View)) {
                break;
            }
            view2 = (View) parent;
        }
        if (view2.equals(view)) {
            return rect;
        }
        throw new InvalidDelegateViewException();
    }

    public static void drawTouchBounds(@NonNull View view, @NonNull HashSet<CapturedTouchDelegate> hashSet) {
        if (DEBUG) {
            ArrayList arrayList = new ArrayList();
            for (CapturedTouchDelegate capturedTouchDelegate : hashSet) {
                if (capturedTouchDelegate.mView.getVisibility() != 8) {
                    arrayList.add(capturedTouchDelegate.mBounds);
                }
            }
            if (arrayList.size() > 0) {
                TouchBoundsPainter.drawTouchBounds(view, arrayList);
            }
        }
    }

    @Nullable
    public TouchDelegate addTouchDelegate(@NonNull Rect rect, @NonNull View view) {
        CapturedTouchDelegate capturedTouchDelegate = new CapturedTouchDelegate(rect, view);
        this.mTouchDelegateSet.add(capturedTouchDelegate);
        return capturedTouchDelegate;
    }

    @Override // android.view.TouchDelegate
    @NonNull
    @RequiresApi(api = 29)
    public AccessibilityNodeInfo.TouchDelegateInfo getTouchDelegateInfo() {
        Log.i(TAG, "SeslTouchTargetDelegate does not support accessibility because it cannot support multi-touch delegation with AOSP View");
        ArrayMap arrayMap = new ArrayMap(1);
        arrayMap.put(new Region(), this.mAnchorView);
        return AbstractC2210j.m1569g(arrayMap);
    }

    @Override // android.view.TouchDelegate
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        for (CapturedTouchDelegate capturedTouchDelegate : this.mTouchDelegateSet) {
            if (capturedTouchDelegate.mView.getParent() == null) {
                Log.w(TAG, "delegate view(" + capturedTouchDelegate.mView + ")'s getParent() is null");
            } else if (capturedTouchDelegate.onTouchEvent(motionEvent)) {
                if (!DEBUG) {
                    return true;
                }
                Log.i(TAG, "touchEvent was consumed on touchDelegate " + capturedTouchDelegate.mView);
                return true;
            }
        }
        return false;
    }

    @Override // android.view.TouchDelegate
    @RequiresApi(api = 29)
    public boolean onTouchExplorationHoverEvent(@NonNull MotionEvent motionEvent) {
        Log.i(TAG, "SeslTouchTargetDelegate does not support accessibility because it cannot support multi-touch delegation with AOSP View");
        return false;
    }

    public boolean removeTouchDelegate(@NonNull TouchDelegate touchDelegate) {
        if (DEBUG) {
            Log.i(TAG, "removeTouchDelegate touchDelegate : " + touchDelegate);
        }
        if (touchDelegate instanceof CapturedTouchDelegate) {
            return this.mTouchDelegateSet.remove(touchDelegate);
        }
        return false;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ExtraInsets {

        @NonNull
        public static final ExtraInsets NONE = new ExtraInsets(0, 0, 0, 0);
        int bottom;
        int left;
        int right;
        int top;

        private ExtraInsets(int i, int i2, int i4, int i5) {
            this.left = i;
            this.top = i2;
            this.right = i4;
            this.bottom = i5;
        }

        @NonNull
        /* JADX INFO: renamed from: of */
        public static ExtraInsets m1781of(int i, int i2, int i4, int i5) {
            return (i == 0 && i2 == 0 && i4 == 0 && i5 == 0) ? NONE : new ExtraInsets(i, i2, i4, i5);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ExtraInsets extraInsets = (ExtraInsets) obj;
            return this.bottom == extraInsets.bottom && this.left == extraInsets.left && this.right == extraInsets.right && this.top == extraInsets.top;
        }

        public int hashCode() {
            return (((((this.left * 31) + this.top) * 31) + this.right) * 31) + this.bottom;
        }

        @NonNull
        public Rect toRect() {
            return new Rect(this.left, this.top, this.right, this.bottom);
        }

        @NonNull
        public String toString() {
            StringBuilder sb = new StringBuilder("ExtraInsets{left=");
            sb.append(this.left);
            sb.append(", top=");
            sb.append(this.top);
            sb.append(", right=");
            sb.append(this.right);
            sb.append(", bottom=");
            return AbstractC0000a.m13j(sb, this.bottom, '}');
        }

        @NonNull
        /* JADX INFO: renamed from: of */
        public static ExtraInsets m1780of(int i, int i2) {
            if (i == 0 && i2 == 0) {
                return NONE;
            }
            return new ExtraInsets(i, i2, i, i2);
        }

        @NonNull
        /* JADX INFO: renamed from: of */
        public static ExtraInsets m1782of(@Nullable Rect rect) {
            return rect == null ? NONE : m1781of(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    @Nullable
    public TouchDelegate addTouchDelegate(@NonNull View view) {
        return addTouchDelegate(view, (ExtraInsets) null);
    }

    @Nullable
    public TouchDelegate addTouchDelegate(@NonNull View view, @Nullable ExtraInsets extraInsets) {
        try {
            Rect rectCalculateViewBounds = calculateViewBounds(this.mAnchorView, view);
            if (extraInsets != null) {
                rectCalculateViewBounds.left -= extraInsets.left;
                rectCalculateViewBounds.top -= extraInsets.top;
                rectCalculateViewBounds.right += extraInsets.right;
                rectCalculateViewBounds.bottom += extraInsets.bottom;
            }
            return addTouchDelegate(rectCalculateViewBounds, view);
        } catch (InvalidDelegateViewException e) {
            Log.w(TAG, "delegateView must be child of anchorView");
            e.printStackTrace();
            return null;
        }
    }
}
