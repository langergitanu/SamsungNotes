package androidx.compose.p109ui.input.key;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0013\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\u0010\u0006\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, m13886d2 = {"nativeKeyCode", "", "Landroidx/compose/ui/input/key/Key;", "getNativeKeyCode-YVgTNJs", "(J)I", "Key", "(I)J", "ui_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nKey.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Key.android.kt\nandroidx/compose/ui/input/key/Key_androidKt\n+ 2 InlineClassHelper.kt\nandroidx/compose/ui/util/InlineClassHelperKt\n*L\n1#1,1422:1\n107#2:1423\n100#2:1424\n*S KotlinDebug\n*F\n+ 1 Key.android.kt\nandroidx/compose/ui/input/key/Key_androidKt\n*L\n1419#1:1423\n1421#1:1424\n*E\n"})
public final class Key_androidKt {
    public static final long Key(int i) {
        return Key.m19274constructorimpl((((long) i) << 32) | (((long) 0) & 4294967295L));
    }

    /* JADX INFO: renamed from: getNativeKeyCode-YVgTNJs, reason: not valid java name */
    public static final int m19591getNativeKeyCodeYVgTNJs(long j) {
        return (int) (j >> 32);
    }
}
