package com.samsung.android.support.senl.p148nt.app.main.common.dialog;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.PathInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.res.ResourcesCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.util.DrawableUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class FolderMarkColorPalette {
    private final int[] mColor;
    private final String[] mColorName;
    private final Context mContext;
    private OnColorChangeListener mOnColorChangeListener = null;
    private int mSelectedPosition;
    private final View mView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnColorChangeListener {
        void onColorChanged(int i);
    }

    public FolderMarkColorPalette(Context context, View view, int i, boolean z) {
        this.mContext = context;
        this.mView = view;
        this.mColor = context.getResources().getIntArray(C8003R.array.folder_mark_new_color);
        this.mColorName = context.getResources().getStringArray(C8003R.array.folder_mark_new_color_name);
        int i2 = 0;
        while (true) {
            int[] iArr = this.mColor;
            if (i2 >= iArr.length) {
                break;
            }
            if (i == iArr[i2]) {
                this.mSelectedPosition = i2;
            }
            i2++;
        }
        if (i == 0) {
            this.mSelectedPosition = 0;
        }
        initLayout(z);
    }

    public static void colorSelectAnimation(View view) {
        if (view == null) {
            return;
        }
        view.measure(0, 0);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.1f, 1.0f, 0.1f, 1.0f, view.getMeasuredWidth() / 2.0f, view.getMeasuredWidth() / 2.0f);
        scaleAnimation.setDuration(300L);
        scaleAnimation.setInterpolator(new PathInterpolator(0.09f, 0.91f, 0.46f, 1.34f));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(200L);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);
        view.startAnimation(animationSet);
    }

    private void initLayout(boolean z) {
        final FrameLayout[] frameLayoutArr = {(FrameLayout) this.mView.findViewById(C8003R.id.frame_mark_0), (FrameLayout) this.mView.findViewById(C8003R.id.frame_mark_1), (FrameLayout) this.mView.findViewById(C8003R.id.frame_mark_2), (FrameLayout) this.mView.findViewById(C8003R.id.frame_mark_3), (FrameLayout) this.mView.findViewById(C8003R.id.frame_mark_4), (FrameLayout) this.mView.findViewById(C8003R.id.frame_mark_5), (FrameLayout) this.mView.findViewById(C8003R.id.frame_mark_6), (FrameLayout) this.mView.findViewById(C8003R.id.frame_mark_7), (FrameLayout) this.mView.findViewById(C8003R.id.frame_mark_8), (FrameLayout) this.mView.findViewById(C8003R.id.frame_mark_9), (FrameLayout) this.mView.findViewById(C8003R.id.frame_mark_10), (FrameLayout) this.mView.findViewById(C8003R.id.frame_mark_11)};
        ImageView[] imageViewArr = {(ImageView) this.mView.findViewById(C8003R.id.mark_color_view_0), (ImageView) this.mView.findViewById(C8003R.id.mark_color_view_1), (ImageView) this.mView.findViewById(C8003R.id.mark_color_view_2), (ImageView) this.mView.findViewById(C8003R.id.mark_color_view_3), (ImageView) this.mView.findViewById(C8003R.id.mark_color_view_4), (ImageView) this.mView.findViewById(C8003R.id.mark_color_view_5), (ImageView) this.mView.findViewById(C8003R.id.mark_color_view_6), (ImageView) this.mView.findViewById(C8003R.id.mark_color_view_7), (ImageView) this.mView.findViewById(C8003R.id.mark_color_view_8), (ImageView) this.mView.findViewById(C8003R.id.mark_color_view_9), (ImageView) this.mView.findViewById(C8003R.id.mark_color_view_10), (ImageView) this.mView.findViewById(C8003R.id.mark_color_view_11)};
        final ImageView[] imageViewArr2 = {(ImageView) this.mView.findViewById(C8003R.id.mark_color_selected_0), (ImageView) this.mView.findViewById(C8003R.id.mark_color_selected_1), (ImageView) this.mView.findViewById(C8003R.id.mark_color_selected_2), (ImageView) this.mView.findViewById(C8003R.id.mark_color_selected_3), (ImageView) this.mView.findViewById(C8003R.id.mark_color_selected_4), (ImageView) this.mView.findViewById(C8003R.id.mark_color_selected_5), (ImageView) this.mView.findViewById(C8003R.id.mark_color_selected_6), (ImageView) this.mView.findViewById(C8003R.id.mark_color_selected_7), (ImageView) this.mView.findViewById(C8003R.id.mark_color_selected_8), (ImageView) this.mView.findViewById(C8003R.id.mark_color_selected_9), (ImageView) this.mView.findViewById(C8003R.id.mark_color_selected_10), (ImageView) this.mView.findViewById(C8003R.id.mark_color_selected_11)};
        for (int i = 0; i < this.mColor.length; i++) {
            Drawable drawable = ResourcesCompat.getDrawable(this.mContext.getResources(), C8003R.drawable.category_mark_color_shape, null);
            if (drawable != null) {
                int color = this.mColor[i];
                if (ResourceUtils.isSupportBackgroundBlur()) {
                    Context context = this.mContext;
                    color = context.getColor(DrawableUtils.getNewFolderColor(context, color));
                }
                drawable.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
                imageViewArr[i].setBackground(drawable);
            }
            imageViewArr[i].setImportantForAccessibility(2);
            imageViewArr2[i].setImportantForAccessibility(2);
            if (this.mSelectedPosition != i || z) {
                imageViewArr2[i].setVisibility(8);
                frameLayoutArr[i].setContentDescription(this.mColorName[i] + SQLKeyword.COMMA + this.mContext.getString(C8003R.string.base_string_radio_button));
            } else {
                imageViewArr2[i].setVisibility(0);
                frameLayoutArr[i].setContentDescription(this.mContext.getString(C8003R.string.selectall_voice_ass_selected) + SQLKeyword.COMMA + this.mColorName[i] + SQLKeyword.COMMA + this.mContext.getString(C8003R.string.base_string_radio_button));
            }
            frameLayoutArr[i].setTag(Integer.valueOf(i));
            frameLayoutArr[i].setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.common.dialog.FolderMarkColorPalette.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    imageViewArr2[FolderMarkColorPalette.this.mSelectedPosition].setVisibility(8);
                    frameLayoutArr[FolderMarkColorPalette.this.mSelectedPosition].setContentDescription(FolderMarkColorPalette.this.mColorName[FolderMarkColorPalette.this.mSelectedPosition]);
                    FolderMarkColorPalette.this.mSelectedPosition = ((Integer) view.getTag()).intValue();
                    imageViewArr2[FolderMarkColorPalette.this.mSelectedPosition].setVisibility(0);
                    frameLayoutArr[FolderMarkColorPalette.this.mSelectedPosition].setContentDescription(FolderMarkColorPalette.this.mContext.getString(C8003R.string.selectall_voice_ass_selected) + SQLKeyword.COMMA + FolderMarkColorPalette.this.mColorName[FolderMarkColorPalette.this.mSelectedPosition]);
                    view.announceForAccessibility(FolderMarkColorPalette.this.mContext.getString(C8003R.string.selectall_voice_ass_selected));
                    if (FolderMarkColorPalette.this.mOnColorChangeListener != null) {
                        FolderMarkColorPalette.this.mOnColorChangeListener.onColorChanged(FolderMarkColorPalette.this.getSelectedColor());
                    }
                    imageViewArr2[FolderMarkColorPalette.this.mSelectedPosition].callOnClick();
                }
            });
            imageViewArr2[i].setTag(Integer.valueOf(i));
            imageViewArr2[i].setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.common.dialog.FolderMarkColorPalette.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FolderMarkColorPalette.colorSelectAnimation(view);
                }
            });
        }
    }

    public int getSelectedColor() {
        return this.mColor[this.mSelectedPosition];
    }

    public void setOnColorChangeListener(OnColorChangeListener onColorChangeListener) {
        this.mOnColorChangeListener = onColorChangeListener;
    }
}
