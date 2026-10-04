package com.samsung.android.support.senl.p148nt.stt.picker.view.listener;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.appbar.AppBarLayout;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import com.samsung.android.support.senl.p148nt.stt.common.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\fH\u0002J\u0010\u0010\u0013\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u000fJ\u0016\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\fJ\u0018\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/picker/view/listener/OffsetUpdateListener;", "Lcom/google/android/material/appbar/AppBarLayout$OnOffsetChangedListener;", "mContext", "Landroid/content/Context;", "mTextView", "Landroid/widget/TextView;", "<init>", "(Landroid/content/Context;Landroid/widget/TextView;)V", "mAlphaStart", "", "mAlphaRange", "mAppbarHeight", "", "mBaseOffset", "mVerticalView", "Landroid/view/View;", "defineAlphaValues", "", "appbarHeight", "setVerticalView", "verticalView", "baseOffset", "onOffsetChanged", DBSchema.DocumentThumbnail.LAYOUT, "Lcom/google/android/material/appbar/AppBarLayout;", "verticalOffset", "Companion", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class OffsetUpdateListener implements AppBarLayout.OnOffsetChangedListener {
    public static final float ALPHA_RANGE_FACTOR = 0.18f;
    public static final float ALPHA_START_FACTOR = 0.1303f;
    public static final int NOT_ASSIGN = -1;

    @NotNull
    private static final String TAG = "OffsetChangeListener";
    private float mAlphaRange;
    private float mAlphaStart;
    private int mAppbarHeight;
    private int mBaseOffset;

    @NotNull
    private Context mContext;

    @Nullable
    private TextView mTextView;

    @Nullable
    private View mVerticalView;

    public OffsetUpdateListener(@NotNull Context mContext, @Nullable TextView textView) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mContext = mContext;
        this.mTextView = textView;
        this.mAlphaStart = -1.0f;
        this.mAlphaRange = -1.0f;
    }

    private final void defineAlphaValues(int appbarHeight) {
        if (this.mAlphaStart == -1.0f) {
            this.mAlphaStart = appbarHeight * 0.1303f;
            this.mAppbarHeight = appbarHeight;
        }
        if (this.mAlphaRange == -1.0f) {
            this.mAlphaRange = appbarHeight * 0.18f;
            this.mAppbarHeight = appbarHeight;
        }
        if (this.mAppbarHeight != appbarHeight) {
            float f = appbarHeight;
            this.mAlphaStart = 0.1303f * f;
            this.mAlphaRange = f * 0.18f;
            this.mAppbarHeight = appbarHeight;
        }
    }

    @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
    public void onOffsetChanged(@NotNull AppBarLayout layout, int verticalOffset) {
        Intrinsics.checkNotNullParameter(layout, "layout");
        Logger.m12713i(TAG, "onOffsetChanged");
        defineAlphaValues(layout.getHeight());
        Rect rect = new Rect();
        layout.getWindowVisibleDisplayFrame(rect);
        int iAbs = Math.abs(layout.getTop());
        int totalScrollRange = layout.getTotalScrollRange();
        int inputMethodWindowVisibleHeight = InputMethodCompat.INSTANCE.getInstance().getInputMethodWindowVisibleHeight(this.mContext);
        View view = this.mVerticalView;
        if (view != null) {
            Intrinsics.checkNotNull(view);
            if (view.getVisibility() == 0) {
                if (verticalOffset == 0 && totalScrollRange == 0) {
                    View view2 = this.mVerticalView;
                    Intrinsics.checkNotNull(view2);
                    view2.setTranslationY(0.0f);
                } else {
                    WindowManagerCompat companion = WindowManagerCompat.INSTANCE.getInstance();
                    Context context = this.mContext;
                    Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                    if (companion.isFreeFormWindow((Activity) context) || (rect.height() * 2) / 3 < totalScrollRange + inputMethodWindowVisibleHeight) {
                        View view3 = this.mVerticalView;
                        Intrinsics.checkNotNull(view3);
                        view3.setTranslationY(this.mBaseOffset);
                    } else {
                        View view4 = this.mVerticalView;
                        Intrinsics.checkNotNull(view4);
                        view4.setTranslationY((((Math.abs(verticalOffset) - totalScrollRange) - inputMethodWindowVisibleHeight) + this.mBaseOffset) / 2.0f);
                    }
                }
            }
        }
        TextView textView = this.mTextView;
        if (textView != null) {
            Intrinsics.checkNotNull(textView);
            if (textView.getVisibility() == 0) {
                TextView textView2 = this.mTextView;
                Intrinsics.checkNotNull(textView2);
                int currentTextColor = textView2.getCurrentTextColor();
                if (layout.getTotalScrollRange() <= 1) {
                    int alphaComponent = ColorUtils.setAlphaComponent(currentTextColor, 255);
                    TextView textView3 = this.mTextView;
                    Intrinsics.checkNotNull(textView3);
                    textView3.setTextColor(alphaComponent);
                    return;
                }
                double d = 255 - ((iAbs - this.mAlphaStart) * (100 / this.mAlphaRange));
                if (0.0d <= d && d <= 255.0d) {
                    double d2 = ((double) 255) - (((double) 2) * d);
                    if (0.0d > d2 || d2 > 255.0d) {
                        return;
                    }
                    int alphaComponent2 = ColorUtils.setAlphaComponent(currentTextColor, (int) d2);
                    TextView textView4 = this.mTextView;
                    Intrinsics.checkNotNull(textView4);
                    textView4.setTextColor(alphaComponent2);
                    return;
                }
                if (d >= 0.0d) {
                    int alphaComponent3 = ColorUtils.setAlphaComponent(currentTextColor, 0);
                    TextView textView5 = this.mTextView;
                    Intrinsics.checkNotNull(textView5);
                    textView5.setTextColor(alphaComponent3);
                    return;
                }
                double d3 = ((double) 255) - (((double) 2) * 0.0d);
                if (0.0d > d3 || d3 > 255.0d) {
                    return;
                }
                int alphaComponent4 = ColorUtils.setAlphaComponent(currentTextColor, (int) d3);
                TextView textView6 = this.mTextView;
                Intrinsics.checkNotNull(textView6);
                textView6.setTextColor(alphaComponent4);
            }
        }
    }

    public final void setVerticalView(@Nullable View verticalView) {
        this.mVerticalView = verticalView;
    }

    public final void setVerticalView(@NotNull View verticalView, int baseOffset) {
        Intrinsics.checkNotNullParameter(verticalView, "verticalView");
        this.mVerticalView = verticalView;
        this.mBaseOffset = baseOffset;
    }
}
