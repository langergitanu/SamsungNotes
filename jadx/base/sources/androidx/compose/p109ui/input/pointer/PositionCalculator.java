package androidx.compose.p109ui.input.pointer;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b`\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\u0002\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H&ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u0006ø\u0001\u0001\u0082\u0002\r\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0001"}, m13886d2 = {"Landroidx/compose/ui/input/pointer/PositionCalculator;", "", "localToScreen", "Landroidx/compose/ui/geometry/Offset;", "localPosition", "localToScreen-MK-Hz9U", "(J)J", "", "localTransform", "Landroidx/compose/ui/graphics/Matrix;", "localToScreen-58bKbWc", "([F)V", "screenToLocal", "positionOnScreen", "screenToLocal-MK-Hz9U", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public interface PositionCalculator {
    /* JADX INFO: renamed from: localToScreen-58bKbWc, reason: not valid java name */
    void mo19807localToScreen58bKbWc(@NotNull float[] localTransform);

    /* JADX INFO: renamed from: localToScreen-MK-Hz9U, reason: not valid java name */
    long mo19808localToScreenMKHz9U(long localPosition);

    /* JADX INFO: renamed from: screenToLocal-MK-Hz9U, reason: not valid java name */
    long mo19809screenToLocalMKHz9U(long positionOnScreen);
}
