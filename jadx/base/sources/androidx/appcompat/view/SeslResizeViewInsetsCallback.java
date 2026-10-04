package androidx.appcompat.view;

import android.graphics.Insets;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.WindowInsetsAnimation$Callback;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(api = 30)
public class SeslResizeViewInsetsCallback extends WindowInsetsAnimation$Callback {
    private static final String TAG = "SeslRVInsetsCallback";
    private int mDeferInsetTypes;
    private int mOldOrientation;
    private int mOriginalHeight;
    private int mOriginalHeightSpec;
    private int mPersistentInsetTypes;
    private boolean mSkipProgress;
    private View mView;

    public SeslResizeViewInsetsCallback(View view, int i, int i2) {
        this(view, i, i2, 0);
    }

    public void onEnd(@NonNull WindowInsetsAnimation windowInsetsAnimation) {
        StringBuilder sb = new StringBuilder("onEnd : mSkipProgress = ");
        sb.append(this.mSkipProgress);
        sb.append(", mOriginalHeightSpec = ");
        AbstractC0000a.m26w(sb, TAG, this.mOriginalHeightSpec);
        if (this.mSkipProgress) {
            this.mSkipProgress = false;
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.mView.getLayoutParams();
        layoutParams.height = this.mOriginalHeightSpec;
        this.mView.setLayoutParams(layoutParams);
    }

    public void onPrepare(@NonNull WindowInsetsAnimation windowInsetsAnimation) {
        super.onPrepare(windowInsetsAnimation);
        if (this.mOldOrientation != this.mView.getResources().getConfiguration().orientation) {
            this.mSkipProgress = true;
        }
        AbstractC0000a.m27x(new StringBuilder("onPrepare : mSkipProgress = "), this.mSkipProgress, TAG);
    }

    @NonNull
    public WindowInsets onProgress(@NonNull WindowInsets windowInsets, @NonNull List<WindowInsetsAnimation> list) {
        if (this.mSkipProgress) {
            Log.i(TAG, "onProgress : skipped!");
            return windowInsets;
        }
        Insets insets = windowInsets.getInsets(this.mDeferInsetTypes);
        Insets insets2 = windowInsets.getInsets(this.mPersistentInsetTypes);
        Log.i(TAG, "onProgress: DeferInsetType = " + this.mDeferInsetTypes + ", typesInset = " + insets + ", PersistentInsetTypes = " + this.mPersistentInsetTypes + ", otherInset = " + insets2);
        Insets insetsSubtract = Insets.subtract(insets, insets2);
        Insets unused = Insets.NONE;
        Insets insetsMax = Insets.max(insetsSubtract, Insets.NONE);
        int i = insetsMax.top - insetsMax.bottom;
        int i2 = this.mOriginalHeight;
        if (i2 == 0 || i2 == -1) {
            this.mOriginalHeight = this.mView.getHeight();
        }
        ViewGroup.LayoutParams layoutParams = this.mView.getLayoutParams();
        layoutParams.height = this.mOriginalHeight + i;
        this.mView.setLayoutParams(layoutParams);
        return windowInsets;
    }

    public void setSkipProgress(boolean z) {
        this.mSkipProgress = z;
    }

    public SeslResizeViewInsetsCallback(View view, int i, int i2, int i4) {
        super(i4);
        this.mOriginalHeight = -1;
        this.mOriginalHeightSpec = -1;
        this.mView = view;
        this.mPersistentInsetTypes = i;
        this.mDeferInsetTypes = i2;
        this.mOldOrientation = view.getResources().getConfiguration().orientation;
        this.mOriginalHeightSpec = this.mView.getLayoutParams().height;
    }
}
