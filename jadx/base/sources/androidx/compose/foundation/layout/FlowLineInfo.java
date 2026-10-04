package androidx.compose.foundation.layout;

import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import opennlp.tools.tokenize.TokenizerME;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ2\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0002\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0007\u001a\u00020\u0006X\u0080\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0005\u001a\u00020\u0006X\u0080\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001a"}, m13886d2 = {"Landroidx/compose/foundation/layout/FlowLineInfo;", "", "lineIndex", "", "positionInLine", "maxMainAxisSize", "Landroidx/compose/ui/unit/Dp;", "maxCrossAxisSize", "(IIFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLineIndex$foundation_layout_release", "()I", "setLineIndex$foundation_layout_release", "(I)V", "getMaxCrossAxisSize-D9Ej5fM$foundation_layout_release", "()F", "setMaxCrossAxisSize-0680j_4$foundation_layout_release", "(F)V", TokenizerME.NO_SPLIT, "getMaxMainAxisSize-D9Ej5fM$foundation_layout_release", "setMaxMainAxisSize-0680j_4$foundation_layout_release", "getPositionInLine$foundation_layout_release", "setPositionInLine$foundation_layout_release", Constants.ARG_UPDATE, "", "update-4j6BHR0$foundation_layout_release", "(IIFF)V", "foundation-layout_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nContextualFlowLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContextualFlowLayout.kt\nandroidx/compose/foundation/layout/FlowLineInfo\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,562:1\n149#2:563\n149#2:564\n*S KotlinDebug\n*F\n+ 1 ContextualFlowLayout.kt\nandroidx/compose/foundation/layout/FlowLineInfo\n*L\n542#1:563\n543#1:564\n*E\n"})
public final class FlowLineInfo {
    public static final int $stable = 8;
    private int lineIndex;
    private float maxCrossAxisSize;
    private float maxMainAxisSize;
    private int positionInLine;

    public /* synthetic */ FlowLineInfo(int i, int i2, float f, float f4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, f, f4);
    }

    /* JADX INFO: renamed from: getLineIndex$foundation_layout_release, reason: from getter */
    public final int getLineIndex() {
        return this.lineIndex;
    }

    /* JADX INFO: renamed from: getMaxCrossAxisSize-D9Ej5fM$foundation_layout_release, reason: not valid java name and from getter */
    public final float getMaxCrossAxisSize() {
        return this.maxCrossAxisSize;
    }

    /* JADX INFO: renamed from: getMaxMainAxisSize-D9Ej5fM$foundation_layout_release, reason: not valid java name and from getter */
    public final float getMaxMainAxisSize() {
        return this.maxMainAxisSize;
    }

    /* JADX INFO: renamed from: getPositionInLine$foundation_layout_release, reason: from getter */
    public final int getPositionInLine() {
        return this.positionInLine;
    }

    public final void setLineIndex$foundation_layout_release(int i) {
        this.lineIndex = i;
    }

    /* JADX INFO: renamed from: setMaxCrossAxisSize-0680j_4$foundation_layout_release, reason: not valid java name */
    public final void m15788setMaxCrossAxisSize0680j_4$foundation_layout_release(float f) {
        this.maxCrossAxisSize = f;
    }

    /* JADX INFO: renamed from: setMaxMainAxisSize-0680j_4$foundation_layout_release, reason: not valid java name */
    public final void m15789setMaxMainAxisSize0680j_4$foundation_layout_release(float f) {
        this.maxMainAxisSize = f;
    }

    public final void setPositionInLine$foundation_layout_release(int i) {
        this.positionInLine = i;
    }

    /* JADX INFO: renamed from: update-4j6BHR0$foundation_layout_release, reason: not valid java name */
    public final void m15790update4j6BHR0$foundation_layout_release(int lineIndex, int positionInLine, float maxMainAxisSize, float maxCrossAxisSize) {
        this.lineIndex = lineIndex;
        this.positionInLine = positionInLine;
        this.maxMainAxisSize = maxMainAxisSize;
        this.maxCrossAxisSize = maxCrossAxisSize;
    }

    private FlowLineInfo(int i, int i2, float f, float f4) {
        this.lineIndex = i;
        this.positionInLine = i2;
        this.maxMainAxisSize = f;
        this.maxCrossAxisSize = f4;
    }

    public /* synthetic */ FlowLineInfo(int i, int i2, float f, float f4, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? C2256Dp.m20968constructorimpl(0) : f, (i4 & 8) != 0 ? C2256Dp.m20968constructorimpl(0) : f4, null);
    }
}
