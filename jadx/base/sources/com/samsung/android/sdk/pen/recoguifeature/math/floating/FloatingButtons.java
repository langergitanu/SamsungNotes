package com.samsung.android.sdk.pen.recoguifeature.math.floating;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.samsung.android.app.notes.widget.glance.single.setting.view.ViewOnTouchListenerC7005f;
import com.samsung.android.sdk.pen.recoguifeature.converttotext.floating.ViewOnHoverListenerC7469a;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 '2\u00020\u0001:\u0002&'B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002J\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0010J\u0010\u0010\u0016\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u0010\u0010\u0019\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u000eJ0\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\nH\u0014J\u0018\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\nH\u0014J\b\u0010%\u001a\u00020\u0012H\u0002R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recoguifeature/math/floating/FloatingButtons;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mInnerView", "mActionListener", "Lcom/samsung/android/sdk/pen/recoguifeature/math/floating/FloatingButtons$ActionListener;", "mWindowRect", "Landroid/graphics/RectF;", "init", "", "close", "setRect", "windowRect", "setToolbarRect", "toolbarRect", "Landroid/graphics/Rect;", "setListener", "l", "onLayout", "changed", "", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setInParent", "ActionListener", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class FloatingButtons extends RelativeLayout {

    @NotNull
    private static final String TAG = "FloatingButtons";

    @Nullable
    private ActionListener mActionListener;

    @Nullable
    private RelativeLayout mInnerView;

    @Nullable
    private RectF mWindowRect;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recoguifeature/math/floating/FloatingButtons$ActionListener;", "", "onConvert", "", "onClose", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface ActionListener {
        void onClose();

        void onConvert();
    }

    public FloatingButtons(@Nullable Context context) {
        super(context);
        init(context);
    }

    private final void init(Context context) {
        View viewInflate = View.inflate(context, C7932R.layout.sdk_floating_math_buttons, null);
        RelativeLayout relativeLayout = viewInflate instanceof RelativeLayout ? (RelativeLayout) viewInflate : null;
        this.mInnerView = relativeLayout;
        if (relativeLayout != null) {
            addView(relativeLayout);
            relativeLayout.setOnTouchListener(new ViewOnTouchListenerC7005f(3));
            relativeLayout.setOnHoverListener(new ViewOnHoverListenerC7469a(2));
            Button button = (Button) relativeLayout.findViewById(C7932R.id.preview_convert_btn);
            if (button != null) {
                final int i = 0;
                button.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.sdk.pen.recoguifeature.math.floating.a

                    /* JADX INFO: renamed from: b */
                    public final /* synthetic */ FloatingButtons f5000b;

                    {
                        this.f5000b = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        switch (i) {
                            case 0:
                                FloatingButtons.init$lambda$5$lambda$2(this.f5000b, view);
                                break;
                            default:
                                FloatingButtons.init$lambda$5$lambda$4$lambda$3(this.f5000b, view);
                                break;
                        }
                    }
                });
            }
            Button button2 = (Button) relativeLayout.findViewById(C7932R.id.preview_close_btn);
            if (button2 != null) {
                button2.setText("Clear");
                final int i2 = 1;
                button2.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.sdk.pen.recoguifeature.math.floating.a

                    /* JADX INFO: renamed from: b */
                    public final /* synthetic */ FloatingButtons f5000b;

                    {
                        this.f5000b = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        switch (i2) {
                            case 0:
                                FloatingButtons.init$lambda$5$lambda$2(this.f5000b, view);
                                break;
                            default:
                                FloatingButtons.init$lambda$5$lambda$4$lambda$3(this.f5000b, view);
                                break;
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean init$lambda$5$lambda$0(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean init$lambda$5$lambda$1(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$5$lambda$2(FloatingButtons floatingButtons, View view) {
        Log.d(TAG, "FloatingButtons::onClick() Convert btn clicked.");
        ActionListener actionListener = floatingButtons.mActionListener;
        if (actionListener != null) {
            actionListener.onConvert();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$5$lambda$4$lambda$3(FloatingButtons floatingButtons, View view) {
        Log.d(TAG, "FloatingButtons::onClick() Close btn clicked.");
        ActionListener actionListener = floatingButtons.mActionListener;
        if (actionListener != null) {
            actionListener.onClose();
        }
    }

    private final void setInParent() {
        Object parent = getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        int height = ((View) parent).getHeight();
        Log.d(TAG, "FloatingButtons::setInParent nHeight: " + height);
        float y2 = getY();
        if (getHeight() + y2 > height) {
            setY(height - getHeight());
        }
        if (y2 < 0.0f) {
            setY(0.0f);
        }
    }

    public final void close() {
        removeAllViews();
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        StringBuilder sbM1173s = AbstractC0622a.m1173s(left, right, "onLayout left: ", ", right : ", ", bottom:");
        sbM1173s.append(bottom);
        sbM1173s.append(", top : ");
        sbM1173s.append(top);
        Log.d(TAG, sbM1173s.toString());
        AbstractC0541b.m783y(right - left, bottom - top, "onLayout w: ", ", h:", TAG);
        RectF rectF = this.mWindowRect;
        if (rectF != null) {
            float dimensionPixelSize = (((int) rectF.top) - getContext().getResources().getDimensionPixelSize(C7932R.dimen.sdk_floating_convert_text_preview_vertical_margin)) - getHeight();
            Log.d(TAG, "onLayout y: " + dimensionPixelSize);
            if (dimensionPixelSize < 0.0f) {
                int dimensionPixelSize2 = getContext().getResources().getDimensionPixelSize(C7932R.dimen.sdk_convert_text_handle_height);
                int dimensionPixelSize3 = getContext().getResources().getDimensionPixelSize(C7932R.dimen.sdk_floating_convert_text_preview_vertical_margin);
                float f = rectF.left;
                float f4 = rectF.top;
                if (f4 <= 0.0f) {
                    f4 = 0.0f;
                }
                RectF rectF2 = new RectF(f, f4, rectF.right, rectF.bottom);
                int iHeight = ((int) rectF2.height()) - ((dimensionPixelSize2 + dimensionPixelSize3) * 2);
                int height = getHeight();
                StringBuilder sbM1173s2 = AbstractC0622a.m1173s(dimensionPixelSize2, dimensionPixelSize3, "onLayout handleSize : ", ",margin : ", ",frameHeight : ");
                sbM1173s2.append(iHeight);
                sbM1173s2.append(", getHeight() : ");
                sbM1173s2.append(height);
                Log.d(TAG, sbM1173s2.toString());
                if (iHeight > getHeight()) {
                    dimensionPixelSize = dimensionPixelSize3 + rectF2.top + dimensionPixelSize2;
                } else {
                    Object parent = getParent();
                    Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
                    if (getHeight() + ((int) rectF2.bottom) + dimensionPixelSize3 < ((View) parent).getHeight()) {
                        dimensionPixelSize = ((int) rectF2.bottom) + dimensionPixelSize3;
                    }
                }
            }
            if (dimensionPixelSize <= 0.0f) {
                dimensionPixelSize = 0.0f;
            }
            setY(dimensionPixelSize);
            Intrinsics.checkNotNull(getParent(), "null cannot be cast to non-null type android.view.View");
            float width = (((View) r10).getWidth() - getWidth()) / 2.0f;
            setX(width > 0.0f ? width : 0.0f);
        }
        setInParent();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public final void setListener(@Nullable ActionListener l) {
        this.mActionListener = l;
    }

    public final void setRect(@NotNull RectF windowRect) {
        Intrinsics.checkNotNullParameter(windowRect, "windowRect");
        Log.d(TAG, "FloatingMathEditor::setRect() windowRect:" + windowRect);
        this.mWindowRect = windowRect;
        if (windowRect == null || windowRect.isEmpty()) {
            return;
        }
        RectF rectF = this.mWindowRect;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(rectF != null ? (int) rectF.width() : 0, -2);
        RelativeLayout relativeLayout = this.mInnerView;
        if (relativeLayout != null) {
            relativeLayout.setLayoutParams(layoutParams);
        }
    }

    public final void setToolbarRect(@Nullable Rect toolbarRect) {
        if (toolbarRect == null || toolbarRect.isEmpty()) {
            return;
        }
        Object parent = getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        int width = ((View) parent).getWidth();
        Object parent2 = getParent();
        Intrinsics.checkNotNull(parent2, "null cannot be cast to non-null type android.view.View");
        boolean z = toolbarRect.top > ((View) parent2).getHeight() - toolbarRect.bottom;
        int height = getHeight();
        if (height == 0) {
            height = toolbarRect.height();
        }
        setY(z ? toolbarRect.top - height : toolbarRect.bottom);
        setX((width - getWidth()) / 2.0f);
    }

    public FloatingButtons(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public FloatingButtons(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }
}
