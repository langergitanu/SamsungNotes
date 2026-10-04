package com.samsung.android.app.sdk.deepsky.textextraction.translate.data.p138ui;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ,\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\f0\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0014J\u0018\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007H\u0014J\b\u0010\u001b\u001a\u00020\fH\u0002R\u0012\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/translate/data/ui/AccurateWidthTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "extraPaddingRight", "Ljava/lang/Integer;", "drawTranslatedHorizontally", "", "canvas", "Landroid/graphics/Canvas;", "xTranslation", "drawingAction", "Lkotlin/Function1;", "getCompoundPaddingRight", "getMaxLineWidth", "", DBSchema.DocumentThumbnail.LAYOUT, "Landroid/text/Layout;", "onDraw", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onMeasureInternal", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAccurateWidthTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AccurateWidthTextView.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/translate/data/ui/AccurateWidthTextView\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,135:1\n1549#2:136\n1620#2,3:137\n*S KotlinDebug\n*F\n+ 1 AccurateWidthTextView.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/translate/data/ui/AccurateWidthTextView\n*L\n38#1:136\n38#1:137,3\n*E\n"})
public final class AccurateWidthTextView extends AppCompatTextView {

    @Nullable
    private Integer extraPaddingRight;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ExplicitLayoutAlignment.values().length];
            try {
                iArr[ExplicitLayoutAlignment.RIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ExplicitLayoutAlignment.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AccurateWidthTextView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void drawTranslatedHorizontally(Canvas canvas, int xTranslation, Function1<? super Canvas, Unit> drawingAction) {
        this.extraPaddingRight = Integer.valueOf(xTranslation);
        canvas.save();
        canvas.translate(xTranslation, 0.0f);
        drawingAction.invoke(canvas);
        this.extraPaddingRight = null;
        canvas.restore();
    }

    private final float getMaxLineWidth(Layout layout) {
        IntRange intRangeUntil = RangesKt.until(0, layout.getLineCount());
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(intRangeUntil));
        Iterator<Integer> it = intRangeUntil.iterator();
        while (it.hasNext()) {
            arrayList.add(Float.valueOf(layout.getLineWidth(((IntIterator) it).nextInt())));
        }
        return CollectionsKt___CollectionsKt.m22652maxOrThrow((Iterable<Float>) arrayList);
    }

    private final void onMeasureInternal() {
        Layout layout = getLayout();
        Intrinsics.checkNotNullExpressionValue(layout, "layout");
        setMeasuredDimension(getMeasuredWidth() - (getLayout().getWidth() - ((int) Math.ceil(getMaxLineWidth(layout)))), getMeasuredHeight());
    }

    @Override // android.widget.TextView
    public int getCompoundPaddingRight() {
        Integer num = this.extraPaddingRight;
        return num != null ? num.intValue() : super.getCompoundPaddingRight();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (getLayout() == null || getLayout().getLineCount() < 2) {
            super.onDraw(canvas);
            return;
        }
        Layout layout = getLayout();
        Intrinsics.checkNotNullExpressionValue(layout, "layout");
        ExplicitLayoutAlignment explicitAlignment = AccurateWidthTextViewKt.getExplicitAlignment(layout);
        if (explicitAlignment == ExplicitLayoutAlignment.MIXED) {
            super.onDraw(canvas);
            return;
        }
        int width = getLayout().getWidth();
        Layout layout2 = getLayout();
        Intrinsics.checkNotNullExpressionValue(layout2, "layout");
        int iCeil = (int) Math.ceil(getMaxLineWidth(layout2));
        if (width == iCeil) {
            super.onDraw(canvas);
            return;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[explicitAlignment.ordinal()];
        if (i == 1) {
            drawTranslatedHorizontally(canvas, (width - iCeil) * (-1), new Function1<Canvas, Unit>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.translate.data.ui.AccurateWidthTextView.onDraw.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Canvas canvas2) {
                    invoke2(canvas2);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Canvas it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    AccurateWidthTextView.super.onDraw(it);
                }
            });
        } else if (i != 2) {
            super.onDraw(canvas);
        } else {
            drawTranslatedHorizontally(canvas, ((width - iCeil) * (-1)) / 2, new Function1<Canvas, Unit>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.translate.data.ui.AccurateWidthTextView.onDraw.2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Canvas canvas2) {
                    invoke2(canvas2);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Canvas it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    AccurateWidthTextView.super.onDraw(it);
                }
            });
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (getLayout() == null || getLayout().getLineCount() < 2) {
            return;
        }
        onMeasureInternal();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AccurateWidthTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ AccurateWidthTextView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AccurateWidthTextView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
