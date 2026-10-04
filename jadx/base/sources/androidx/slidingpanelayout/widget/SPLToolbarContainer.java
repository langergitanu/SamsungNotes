package androidx.slidingpanelayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.C0419R;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.slidingpanelayout.C3861R;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public class SPLToolbarContainer extends FrameLayout {
    protected static final String TAG = "SPLToolbarContainer";

    @Nullable
    private ViewStubCompat mViewStubCompat;

    public SPLToolbarContainer(@NonNull Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        ViewStubCompat viewStubCompat = this.mViewStubCompat;
        if (viewStubCompat != null) {
            viewStubCompat.bringToFront();
            this.mViewStubCompat.invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        ViewStubCompat viewStubCompat = this.mViewStubCompat;
        if (viewStubCompat != null) {
            viewStubCompat.bringToFront();
            this.mViewStubCompat.invalidate();
        }
        super.onMeasure(i, i2);
    }

    public SPLToolbarContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SPLToolbarContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(C0419R.styleable.AppCompatTheme);
        if (!typedArrayObtainStyledAttributes.getBoolean(C0419R.styleable.AppCompatTheme_windowActionModeOverlay, false)) {
            LayoutInflater.from(context).inflate(C3861R.layout.sesl_spl_action_mode_view_stub, (ViewGroup) this, true);
            this.mViewStubCompat = (ViewStubCompat) findViewById(C3861R.id.action_mode_bar_stub);
        }
        typedArrayObtainStyledAttributes.recycle();
        setWillNotDraw(false);
    }
}
