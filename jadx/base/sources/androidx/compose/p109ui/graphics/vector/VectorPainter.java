package androidx.compose.p109ui.graphics.vector;

import androidx.collection.AbstractC0622a;
import androidx.compose.p109ui.geometry.Size;
import androidx.compose.p109ui.graphics.ColorFilter;
import androidx.compose.p109ui.graphics.drawscope.DrawContext;
import androidx.compose.p109ui.graphics.drawscope.DrawScope;
import androidx.compose.p109ui.graphics.painter.Painter;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010@\u001a\u00020\u00062\u0006\u0010A\u001a\u00020\u0019H\u0014J\u0012\u0010B\u001a\u00020\u00062\b\u0010C\u001a\u0004\u0018\u00010\u001bH\u0014J\f\u0010D\u001a\u00020E*\u00020FH\u0014R+\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u000f8@X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u001f\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001b8@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020%8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b&\u0010'R+\u0010(\u001a\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\u001d8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b)\u0010\u0011\"\u0004\b*\u0010+R$\u0010/\u001a\u00020.2\u0006\u0010\u001e\u001a\u00020.8@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b0\u00101\"\u0004\b2\u00103R1\u00104\u001a\u00020%2\u0006\u0010\u0005\u001a\u00020%8@@@X\u0080\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b8\u0010\r\u001a\u0004\b5\u0010'\"\u0004\b6\u00107R\u0014\u00109\u001a\u00020:X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R*\u0010=\u001a\u00020%2\u0006\u0010\u001e\u001a\u00020%8@@@X\u0080\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b>\u0010'\"\u0004\b?\u00107\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006G"}, m13886d2 = {"Landroidx/compose/ui/graphics/vector/VectorPainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "root", "Landroidx/compose/ui/graphics/vector/GroupComponent;", "(Landroidx/compose/ui/graphics/vector/GroupComponent;)V", "<set-?>", "", "autoMirror", "getAutoMirror$ui_release", "()Z", "setAutoMirror$ui_release", "(Z)V", "autoMirror$delegate", "Landroidx/compose/runtime/MutableState;", "bitmapConfig", "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "getBitmapConfig-_sVssgQ$ui_release", "()I", "composition", "Landroidx/compose/runtime/Composition;", "getComposition$ui_release", "()Landroidx/compose/runtime/Composition;", "setComposition$ui_release", "(Landroidx/compose/runtime/Composition;)V", "currentAlpha", "", "currentColorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "drawCount", "", "value", "intrinsicColorFilter", "getIntrinsicColorFilter$ui_release", "()Landroidx/compose/ui/graphics/ColorFilter;", "setIntrinsicColorFilter$ui_release", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "invalidateCount", "getInvalidateCount", "setInvalidateCount", "(I)V", "invalidateCount$delegate", "Landroidx/compose/runtime/MutableIntState;", "", "name", "getName$ui_release", "()Ljava/lang/String;", "setName$ui_release", "(Ljava/lang/String;)V", "size", "getSize-NH-jbRc$ui_release", "setSize-uvyYCjk$ui_release", "(J)V", "size$delegate", "vector", "Landroidx/compose/ui/graphics/vector/VectorComponent;", "getVector$ui_release", "()Landroidx/compose/ui/graphics/vector/VectorComponent;", "viewportSize", "getViewportSize-NH-jbRc$ui_release", "setViewportSize-uvyYCjk$ui_release", "applyAlpha", "alpha", "applyColorFilter", "colorFilter", "onDraw", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nVectorPainter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VectorPainter.kt\nandroidx/compose/ui/graphics/vector/VectorPainter\n+ 2 SnapshotState.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotStateKt\n+ 3 SnapshotIntState.kt\nandroidx/compose/runtime/SnapshotIntStateKt__SnapshotIntStateKt\n+ 4 VectorPainter.kt\nandroidx/compose/ui/graphics/vector/VectorPainterKt\n+ 5 DrawScope.kt\nandroidx/compose/ui/graphics/drawscope/DrawScopeKt\n*L\n1#1,520:1\n81#2:521\n107#2,2:522\n81#2:524\n107#2,2:525\n78#3:527\n111#3,2:528\n270#4:530\n271#4:551\n184#5,6:531\n272#5,14:537\n*S KotlinDebug\n*F\n+ 1 VectorPainter.kt\nandroidx/compose/ui/graphics/vector/VectorPainter\n*L\n193#1:521\n193#1:522,2\n195#1:524\n195#1:525,2\n232#1:527\n232#1:528,2\n246#1:530\n246#1:551\n246#1:531,6\n246#1:537,14\n*E\n"})
public final class VectorPainter extends Painter {
    public static final int $stable = 8;

    /* JADX INFO: renamed from: autoMirror$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState autoMirror;

    @Nullable
    private Composition composition;
    private float currentAlpha;

    @Nullable
    private ColorFilter currentColorFilter;
    private int drawCount;

    /* JADX INFO: renamed from: invalidateCount$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableIntState invalidateCount;

    /* JADX INFO: renamed from: size$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState size;

    @NotNull
    private final VectorComponent vector;

    /* JADX WARN: Multi-variable type inference failed */
    public VectorPainter() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getInvalidateCount() {
        return this.invalidateCount.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setInvalidateCount(int i) {
        this.invalidateCount.setIntValue(i);
    }

    @Override // androidx.compose.p109ui.graphics.painter.Painter
    public boolean applyAlpha(float alpha) {
        this.currentAlpha = alpha;
        return true;
    }

    @Override // androidx.compose.p109ui.graphics.painter.Painter
    public boolean applyColorFilter(@Nullable ColorFilter colorFilter) {
        this.currentColorFilter = colorFilter;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getAutoMirror$ui_release() {
        return ((Boolean) this.autoMirror.getValue()).booleanValue();
    }

    /* JADX INFO: renamed from: getBitmapConfig-_sVssgQ$ui_release, reason: not valid java name */
    public final int m19228getBitmapConfig_sVssgQ$ui_release() {
        return this.vector.m19220getCacheBitmapConfig_sVssgQ$ui_release();
    }

    @Nullable
    /* JADX INFO: renamed from: getComposition$ui_release, reason: from getter */
    public final Composition getComposition() {
        return this.composition;
    }

    @Nullable
    public final ColorFilter getIntrinsicColorFilter$ui_release() {
        return this.vector.getIntrinsicColorFilter$ui_release();
    }

    @Override // androidx.compose.p109ui.graphics.painter.Painter
    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc */
    public long getIntrinsicSize() {
        return m19229getSizeNHjbRc$ui_release();
    }

    @NotNull
    public final String getName$ui_release() {
        return this.vector.getName();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getSize-NH-jbRc$ui_release, reason: not valid java name */
    public final long m19229getSizeNHjbRc$ui_release() {
        return ((Size) this.size.getValue()).getPackedValue();
    }

    @NotNull
    /* JADX INFO: renamed from: getVector$ui_release, reason: from getter */
    public final VectorComponent getVector() {
        return this.vector;
    }

    /* JADX INFO: renamed from: getViewportSize-NH-jbRc$ui_release, reason: not valid java name */
    public final long m19230getViewportSizeNHjbRc$ui_release() {
        return this.vector.m19221getViewportSizeNHjbRc$ui_release();
    }

    @Override // androidx.compose.p109ui.graphics.painter.Painter
    public void onDraw(@NotNull DrawScope drawScope) {
        VectorComponent vectorComponent = this.vector;
        ColorFilter intrinsicColorFilter$ui_release = this.currentColorFilter;
        if (intrinsicColorFilter$ui_release == null) {
            intrinsicColorFilter$ui_release = vectorComponent.getIntrinsicColorFilter$ui_release();
        }
        if (getAutoMirror$ui_release() && drawScope.getLayoutDirection() == LayoutDirection.Rtl) {
            long jMo19075getCenterF1C5BW0 = drawScope.mo19075getCenterF1C5BW0();
            DrawContext drawContext = drawScope.getDrawContext();
            long jMo18997getSizeNHjbRc = drawContext.mo18997getSizeNHjbRc();
            drawContext.getCanvas().save();
            try {
                drawContext.getTransform().mo19004scale0AR0LA0(-1.0f, 1.0f, jMo19075getCenterF1C5BW0);
                vectorComponent.draw(drawScope, this.currentAlpha, intrinsicColorFilter$ui_release);
            } finally {
                AbstractC0622a.m1179y(drawContext, jMo18997getSizeNHjbRc);
            }
        } else {
            vectorComponent.draw(drawScope, this.currentAlpha, intrinsicColorFilter$ui_release);
        }
        this.drawCount = getInvalidateCount();
    }

    public final void setAutoMirror$ui_release(boolean z) {
        this.autoMirror.setValue(Boolean.valueOf(z));
    }

    public final void setComposition$ui_release(@Nullable Composition composition) {
        this.composition = composition;
    }

    public final void setIntrinsicColorFilter$ui_release(@Nullable ColorFilter colorFilter) {
        this.vector.setIntrinsicColorFilter$ui_release(colorFilter);
    }

    public final void setName$ui_release(@NotNull String str) {
        this.vector.setName(str);
    }

    /* JADX INFO: renamed from: setSize-uvyYCjk$ui_release, reason: not valid java name */
    public final void m19231setSizeuvyYCjk$ui_release(long j) {
        this.size.setValue(Size.m18341boximpl(j));
    }

    /* JADX INFO: renamed from: setViewportSize-uvyYCjk$ui_release, reason: not valid java name */
    public final void m19232setViewportSizeuvyYCjk$ui_release(long j) {
        this.vector.m19222setViewportSizeuvyYCjk$ui_release(j);
    }

    public VectorPainter(@NotNull GroupComponent groupComponent) {
        this.size = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Size.m18341boximpl(Size.INSTANCE.m18362getZeroNHjbRc()), null, 2, null);
        this.autoMirror = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        VectorComponent vectorComponent = new VectorComponent(groupComponent);
        vectorComponent.setInvalidateCallback$ui_release(new Function0<Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorPainter$vector$1$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (this.this$0.drawCount == this.this$0.getInvalidateCount()) {
                    VectorPainter vectorPainter = this.this$0;
                    vectorPainter.setInvalidateCount(vectorPainter.getInvalidateCount() + 1);
                }
            }
        });
        this.vector = vectorComponent;
        this.invalidateCount = SnapshotIntStateKt.mutableIntStateOf(0);
        this.currentAlpha = 1.0f;
        this.drawCount = -1;
    }

    public /* synthetic */ VectorPainter(GroupComponent groupComponent, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new GroupComponent() : groupComponent);
    }
}
