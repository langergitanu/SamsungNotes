package com.samsung.android.support.senl.p148nt.app.common.listener;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.samsung.android.support.senl.p145cm.base.framework.view.HoverCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.base.common.util.ImageUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class CoverHoverListener implements View.OnHoverListener {
    private final String mFilePath;

    public CoverHoverListener(String str) {
        this.mFilePath = str;
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        Bitmap bitmap;
        int i;
        if (TextUtils.isEmpty(this.mFilePath) || motionEvent.getToolType(0) != 2) {
            return false;
        }
        if (motionEvent.getAction() != 9) {
            if (motionEvent.getAction() != 10) {
                return true;
            }
            HoverCompat.getInstance().dismiss(view);
            return true;
        }
        Drawable drawableCreateFromPath = Drawable.createFromPath(this.mFilePath);
        if (drawableCreateFromPath == null || (bitmap = ((BitmapDrawable) drawableCreateFromPath).getBitmap()) == null) {
            return false;
        }
        ImageUtils.resizeBitmapImage(bitmap, drawableCreateFromPath.getIntrinsicWidth());
        ImageView imageView = (ImageView) LayoutInflater.from(view.getContext()).inflate(C8003R.layout.cover_hover_popup, (ViewGroup) null).findViewById(C8003R.id.cover_hover_view);
        imageView.setImageDrawable(drawableCreateFromPath);
        float dimensionPixelSize = view.getResources().getDimensionPixelSize(C8003R.dimen.noteslist_hover_image_thumbnail_max);
        float minimumWidth = drawableCreateFromPath.getMinimumWidth();
        float minimumHeight = drawableCreateFromPath.getMinimumHeight();
        if (minimumWidth > minimumHeight) {
            i = (int) dimensionPixelSize;
            dimensionPixelSize = (dimensionPixelSize * minimumHeight) / minimumWidth;
        } else {
            i = (int) ((minimumWidth * dimensionPixelSize) / minimumHeight);
        }
        imageView.setLayoutParams(new ViewGroup.LayoutParams(i, (int) dimensionPixelSize));
        HoverCompat.getInstance().setThumb(view, imageView);
        HoverCompat.getInstance().show(view, 3);
        return true;
    }
}
