package com.samsung.android.support.senl.p148nt.app.main.common.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.samsung.android.support.senl.p148nt.app.C8003R;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class NumberedBadgeShadowBuilder extends View.DragShadowBuilder {
    private final Context mContext;
    private int mCount;
    private final ShadowBuilderContract mShadowBuilderContract;
    private final int mShadowHeight;
    private View mShadowView;
    private final int mShadowWidth;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ShadowBuilderContract {
        void setImageView(ImageView imageView);
    }

    public NumberedBadgeShadowBuilder(Context context, int i, ShadowBuilderContract shadowBuilderContract) {
        this.mContext = context;
        this.mCount = i;
        this.mShadowWidth = context.getResources().getDimensionPixelSize(C8003R.dimen.note_drag_n_drop_shadow_width);
        this.mShadowHeight = context.getResources().getDimensionPixelSize(C8003R.dimen.note_drag_n_drop_shadow_height);
        this.mShadowBuilderContract = shadowBuilderContract;
    }

    public View onCreateShadow() {
        if (this.mShadowView == null) {
            this.mShadowView = LayoutInflater.from(this.mContext).inflate(C8003R.layout.note_drag_n_drop_shadow, (ViewGroup) null);
        }
        TextView textView = (TextView) this.mShadowView.findViewById(C8003R.id.note_drag_n_drop_badge);
        textView.setVisibility(0);
        textView.setText(String.valueOf(this.mCount));
        int iMeasureText = (int) textView.getPaint().measureText(String.valueOf(this.mCount));
        if (iMeasureText > this.mContext.getResources().getDimensionPixelSize(C8003R.dimen.note_drag_n_drop_badge_size)) {
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            layoutParams.width = iMeasureText + 10;
            textView.setLayoutParams(layoutParams);
        }
        this.mShadowBuilderContract.setImageView((ImageView) this.mShadowView.findViewById(C8003R.id.imageView));
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mShadowView.measure(iMakeMeasureSpec, iMakeMeasureSpec);
        this.mShadowView.layout(0, 0, this.mShadowWidth, this.mShadowHeight);
        this.mShadowView.invalidate();
        return this.mShadowView;
    }

    @Override // android.view.View.DragShadowBuilder
    public void onDrawShadow(Canvas canvas) {
        if (this.mShadowView == null) {
            this.mShadowView = onCreateShadow();
        }
        this.mShadowView.draw(canvas);
    }

    @Override // android.view.View.DragShadowBuilder
    public void onProvideShadowMetrics(Point point, Point point2) {
        point.set(this.mShadowWidth, this.mShadowHeight);
        point2.set(this.mShadowWidth / 2, this.mShadowHeight / 2);
        super.onProvideShadowMetrics(point, point2);
    }

    public void releaseShadow() {
        this.mShadowView = null;
    }

    public void setShadowBadge(int i) {
        this.mCount = i;
    }
}
