package androidx.appcompat.view;

import android.graphics.Insets;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.WindowInsetsAnimation$Callback;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.C0419R;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(api = 30)
public class SeslContentViewInsetsCallback extends WindowInsetsAnimation$Callback implements View.OnApplyWindowInsetsListener {
    private static final String TAG = "SeslCVInsetsCallback";
    private final Handler handler;
    private int mDeferInsetTypes;
    private final Runnable mHandleInsetsAnimationCanceled;
    private boolean mIsDeferInsets;
    private WindowInsets mLastWindowInsets;
    private int mPersistentInsetTypes;
    private View mView;
    private boolean mWindowInsetsAnimationStarted;

    public SeslContentViewInsetsCallback(int i, int i2) {
        super(1);
        this.mIsDeferInsets = false;
        this.mWindowInsetsAnimationStarted = false;
        this.handler = new Handler();
        this.mHandleInsetsAnimationCanceled = new Runnable() { // from class: androidx.appcompat.view.SeslContentViewInsetsCallback.1
            @Override // java.lang.Runnable
            public void run() {
                Log.i(SeslContentViewInsetsCallback.TAG, "WindowInsetsAnimation could have been cancelled");
                if (!SeslContentViewInsetsCallback.this.mWindowInsetsAnimationStarted && SeslContentViewInsetsCallback.this.mIsDeferInsets) {
                    Log.i(SeslContentViewInsetsCallback.TAG, "Start to restore insets state");
                    SeslContentViewInsetsCallback.this.mIsDeferInsets = false;
                    if (SeslContentViewInsetsCallback.this.mView == null || SeslContentViewInsetsCallback.this.mLastWindowInsets == null) {
                        return;
                    }
                    SeslContentViewInsetsCallback.this.mView.dispatchApplyWindowInsets(SeslContentViewInsetsCallback.this.mLastWindowInsets);
                }
            }
        };
        this.mPersistentInsetTypes = i;
        this.mDeferInsetTypes = i2;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        this.mView = view;
        this.mLastWindowInsets = windowInsets;
        Insets insets = windowInsets.getInsets(this.mIsDeferInsets ? this.mPersistentInsetTypes : this.mPersistentInsetTypes | this.mDeferInsetTypes);
        StringBuilder sb = new StringBuilder("onApplyWindowInsets, typeInsets = ");
        sb.append(insets);
        sb.append(", mIsDeferInsets = ");
        AbstractC0000a.m27x(sb, this.mIsDeferInsets, TAG);
        this.mView.setPadding(insets.left, insets.top, insets.right, insets.bottom);
        View viewFindViewById = this.mView.findViewById(C0419R.id.action_mode_bar);
        if (viewFindViewById != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) viewFindViewById.getLayoutParams();
            if (this.mView.getPaddingTop() != 0) {
                marginLayoutParams.topMargin = 0;
            }
            if (this.mView.getPaddingRight() != 0) {
                marginLayoutParams.rightMargin = 0;
            }
            if (this.mView.getPaddingLeft() != 0) {
                marginLayoutParams.leftMargin = 0;
            }
        }
        return WindowInsets.CONSUMED;
    }

    public void onEnd(@NonNull WindowInsetsAnimation windowInsetsAnimation) {
        WindowInsets windowInsets;
        if ((windowInsetsAnimation.getTypeMask() & this.mDeferInsetTypes) != 0) {
            Log.i(TAG, "onEnd");
            this.mIsDeferInsets = false;
            this.mWindowInsetsAnimationStarted = false;
            View view = this.mView;
            if (view == null || (windowInsets = this.mLastWindowInsets) == null) {
                return;
            }
            view.dispatchApplyWindowInsets(windowInsets);
        }
    }

    public void onPrepare(@NonNull WindowInsetsAnimation windowInsetsAnimation) {
        if ((windowInsetsAnimation.getTypeMask() & this.mDeferInsetTypes) != 0) {
            Log.i(TAG, "onPrepare");
            this.mIsDeferInsets = true;
            this.handler.postDelayed(this.mHandleInsetsAnimationCanceled, 100L);
        }
    }

    public WindowInsetsAnimation.Bounds onStart(@NonNull WindowInsetsAnimation windowInsetsAnimation, @NonNull WindowInsetsAnimation.Bounds bounds) {
        if ((windowInsetsAnimation.getTypeMask() & this.mDeferInsetTypes) != 0) {
            Log.i(TAG, "onStart");
            this.handler.removeCallbacks(this.mHandleInsetsAnimationCanceled);
            this.mWindowInsetsAnimationStarted = true;
        }
        return bounds;
    }

    public WindowInsets onProgress(@NonNull WindowInsets windowInsets, @NonNull List<WindowInsetsAnimation> list) {
        return windowInsets;
    }
}
