package com.samsung.android.sdk.pen.setting.colorpalette;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.material.carousel.RunnableC4617a;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\r¢\u0006\u0004\b\u0004\u0010\u0010J(\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\rH\u0016J\u0018\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\rH\u0002J\u0018\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\rH\u0002R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenBrushPaletteView;", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "isHorizontal", "", "(Landroid/content/Context;Z)V", "row", "", "col", "fixedAlign", "(Landroid/content/Context;III)V", "mIsHorizontal", "onSizeChanged", "", "w", "h", "oldw", "oldh", "updatePadding", "updateChild", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenBrushPaletteView extends SpenPaletteView {
    private static final float CHILD_FOCUS_RATIO = 0.0f;
    private static final float COLOR_ITEM_HORIZONTAL_MARGIN_RATIO = 0.0957f;
    private static final float COLOR_ITEM_RATIO = 0.0974f;
    private static final int DEFAULT_COL_COUNT = 5;
    private static final int DEFAULT_ROW_COUNT = 2;
    private static final float END_PADDING_RATIO = 0.119f;
    private static final float START_PADDING_RATIO = 0.1258f;

    @NotNull
    private static final String TAG = "SpenBrushPaletteView";
    private static final float TOP_PADDING_RATIO = 0.1379f;
    private boolean mIsHorizontal;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenBrushPaletteView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mIsHorizontal = true;
    }

    private final void updateChild(int w, int h) {
        int i = w > h ? w : h;
        if (w > h) {
            w = h;
        }
        int i2 = (int) (i * COLOR_ITEM_RATIO);
        float f = w;
        int i4 = (int) (i2 * 0.0f);
        int i5 = w - (((i2 * 2) + ((int) (TOP_PADDING_RATIO * f))) + ((int) (f * COLOR_ITEM_HORIZONTAL_MARGIN_RATIO)));
        if (this.mIsHorizontal) {
            setIndicatorInfo(-1, i5);
        } else {
            setIndicatorInfo(i5, -1);
        }
        setChildInfo(i2, i4);
    }

    private final void updatePadding(int w, int h) {
        int i = w > h ? w : h;
        if (w > h) {
            w = h;
        }
        int i2 = (int) (w * TOP_PADDING_RATIO);
        float f = i;
        int i4 = (int) (START_PADDING_RATIO * f);
        int i5 = (int) (f * END_PADDING_RATIO);
        setPaddingRelative(i4, i2, i5, 0);
        AbstractC11014a.m12329n(i5, ", 0]", TAG, AbstractC0622a.m1173s(i4, i2, "padding[", SQLKeyword.COMMA, SQLKeyword.COMMA));
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteView, android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        Log.i(TAG, AbstractC2322a.m1625o(AbstractC0622a.m1173s(oldw, oldh, "onSizeChanged() old[", SQLKeyword.COMMA, "]  new["), w, h, SQLKeyword.COMMA, "]"));
        if (h > 0) {
            updatePadding(w, h);
            updateChild(w, h);
            new Handler().post(new RunnableC4617a(this, 20));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenBrushPaletteView(@NotNull Context context, @NotNull AttributeSet attrs) {
        super(context, attrs, true);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.mIsHorizontal = true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenBrushPaletteView(@NotNull Context context, boolean z) {
        super(context, z ? 2 : 5, z ? 5 : 2, z ? 2 : 3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mIsHorizontal = z;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenBrushPaletteView(@NotNull Context context, int i, int i2, int i4) {
        super(context, i, i2, i4);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mIsHorizontal = true;
        this.mIsHorizontal = i <= i2;
    }
}
