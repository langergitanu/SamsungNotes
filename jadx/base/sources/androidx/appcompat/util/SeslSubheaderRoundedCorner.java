package androidx.appcompat.util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.util.SeslRoundedCorner;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(api = 23)
public class SeslSubheaderRoundedCorner extends SeslRoundedCorner {
    private static final String TAG = "SeslSubheaderRoundedCorner";

    public SeslSubheaderRoundedCorner(@NonNull Context context) {
        super(context);
    }

    private void drawRoundedCornerInternal(Canvas canvas) {
        Rect rect = this.mRoundedCornerBounds;
        int i = rect.left;
        int i2 = rect.right;
        int i4 = rect.top;
        int i5 = rect.bottom;
        if ((this.mRoundedCornerMode & 1) != 0) {
            SeslRoundedCorner.SeslRoundedChunkingDrawable seslRoundedChunkingDrawable = this.mTopLeftRound;
            int i6 = this.mRoundRadius;
            seslRoundedChunkingDrawable.setBounds(i, i5, i + i6, i6 + i5);
            this.mTopLeftRound.draw(canvas);
        }
        if ((this.mRoundedCornerMode & 2) != 0) {
            SeslRoundedCorner.SeslRoundedChunkingDrawable seslRoundedChunkingDrawable2 = this.mTopRightRound;
            int i7 = this.mRoundRadius;
            seslRoundedChunkingDrawable2.setBounds(i2 - i7, i5, i2, i7 + i5);
            this.mTopRightRound.draw(canvas);
        }
        if ((this.mRoundedCornerMode & 4) != 0) {
            SeslRoundedCorner.SeslRoundedChunkingDrawable seslRoundedChunkingDrawable3 = this.mBottomLeftRound;
            int i8 = this.mRoundRadius;
            seslRoundedChunkingDrawable3.setBounds(i, i4 - i8, i8 + i, i4);
            this.mBottomLeftRound.draw(canvas);
        }
        if ((this.mRoundedCornerMode & 8) != 0) {
            SeslRoundedCorner.SeslRoundedChunkingDrawable seslRoundedChunkingDrawable4 = this.mBottomRightRound;
            int i9 = this.mRoundRadius;
            seslRoundedChunkingDrawable4.setBounds(i2 - i9, i4 - i9, i2, i4);
            this.mBottomRightRound.draw(canvas);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void drawRoundedCorner(int i, int i2, int i4, int i5, @NonNull Canvas canvas) {
        this.mRoundedCornerBounds.set(i, i2, i4, i5);
        drawRoundedCornerInternal(canvas);
    }

    @Override // androidx.appcompat.util.SeslRoundedCorner
    public void drawRoundedCorner(@NonNull View view, @NonNull Canvas canvas) {
        int left;
        int top;
        if (view.getTranslationY() != 0.0f) {
            left = Math.round(view.getX());
            top = Math.round(view.getY());
        } else {
            left = view.getLeft();
            top = view.getTop();
        }
        this.mRoundedCornerBounds.set(left, top, view.getWidth() + left, view.getHeight() + top);
        drawRoundedCornerInternal(canvas);
    }
}
