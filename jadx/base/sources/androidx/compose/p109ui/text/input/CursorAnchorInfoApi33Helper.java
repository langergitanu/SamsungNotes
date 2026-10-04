package androidx.compose.p109ui.text.input;

import android.view.inputmethod.CursorAnchorInfo;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.appsearch.platformstorage.converter.AbstractC0564a;
import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.p109ui.graphics.RectHelper_androidKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(33)
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, m13886d2 = {"Landroidx/compose/ui/text/input/CursorAnchorInfoApi33Helper;", "", "()V", "setEditorBoundsInfo", "Landroid/view/inputmethod/CursorAnchorInfo$Builder;", "builder", "decorationBoxBounds", "Landroidx/compose/ui/geometry/Rect;", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final class CursorAnchorInfoApi33Helper {

    @NotNull
    public static final CursorAnchorInfoApi33Helper INSTANCE = new CursorAnchorInfoApi33Helper();

    private CursorAnchorInfoApi33Helper() {
    }

    @JvmStatic
    @DoNotInline
    @NotNull
    public static final CursorAnchorInfo.Builder setEditorBoundsInfo(@NotNull CursorAnchorInfo.Builder builder, @NotNull Rect decorationBoxBounds) {
        return builder.setEditorBoundsInfo(AbstractC0564a.m906j().setEditorBounds(RectHelper_androidKt.toAndroidRectF(decorationBoxBounds)).setHandwritingBounds(RectHelper_androidKt.toAndroidRectF(decorationBoxBounds)).build());
    }
}
