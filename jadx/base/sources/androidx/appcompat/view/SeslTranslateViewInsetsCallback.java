package androidx.appcompat.view;

import android.graphics.Insets;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.WindowInsetsAnimation$Callback;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(api = 30)
public class SeslTranslateViewInsetsCallback extends WindowInsetsAnimation$Callback {
    private int mDeferInsetTypes;
    private int mPersistentInsetTypes;
    private View mView;

    public SeslTranslateViewInsetsCallback(View view, int i, int i2) {
        this(view, i, i2, 0);
    }

    public void onEnd(@NonNull WindowInsetsAnimation windowInsetsAnimation) {
        this.mView.setTranslationY(0.0f);
    }

    @NonNull
    public WindowInsets onProgress(@NonNull WindowInsets windowInsets, @NonNull List<WindowInsetsAnimation> list) {
        Insets insetsSubtract = Insets.subtract(windowInsets.getInsets(this.mDeferInsetTypes), windowInsets.getInsets(this.mPersistentInsetTypes));
        Insets unused = Insets.NONE;
        Insets insetsMax = Insets.max(insetsSubtract, Insets.NONE);
        this.mView.setTranslationY(insetsMax.top - insetsMax.bottom);
        return windowInsets;
    }

    public SeslTranslateViewInsetsCallback(View view, int i, int i2, int i4) {
        super(i4);
        this.mView = view;
        this.mPersistentInsetTypes = i;
        this.mDeferInsetTypes = i2;
    }
}
