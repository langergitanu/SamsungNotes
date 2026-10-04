package androidx.compose.foundation.text.input.internal;

import android.view.inputmethod.EditorInfo;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(34)
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, m13886d2 = {"Landroidx/compose/foundation/text/input/internal/EditorInfoApi34;", "", "()V", "setHandwritingGestures", "", "editorInfo", "Landroid/view/inputmethod/EditorInfo;", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final class EditorInfoApi34 {

    @NotNull
    public static final EditorInfoApi34 INSTANCE = new EditorInfoApi34();

    private EditorInfoApi34() {
    }

    @DoNotInline
    public final void setHandwritingGestures(@NotNull EditorInfo editorInfo) {
        editorInfo.setSupportedHandwritingGestures(CollectionsKt.listOf((Object[]) new Class[]{AbstractC1346d.m1252n(), AbstractC1346d.m1262x(), AbstractC1346d.m1258t(), AbstractC1346d.m1260v(), AbstractC1346d.m1264z(), AbstractC1346d.m1236B(), AbstractC1346d.m1238D()}));
        editorInfo.setSupportedHandwritingGesturePreviews(SetsKt.setOf((Object[]) new Class[]{AbstractC1346d.m1252n(), AbstractC1346d.m1262x(), AbstractC1346d.m1258t(), AbstractC1346d.m1260v()}));
    }
}
