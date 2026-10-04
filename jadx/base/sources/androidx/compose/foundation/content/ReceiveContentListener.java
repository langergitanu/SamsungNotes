package androidx.compose.foundation.content;

import androidx.compose.foundation.ExperimentalFoundationApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalFoundationApi
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bç\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\bH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, m13886d2 = {"Landroidx/compose/foundation/content/ReceiveContentListener;", "", "onDragEnd", "", "onDragEnter", "onDragExit", "onDragStart", "onReceive", "Landroidx/compose/foundation/content/TransferableContent;", "transferableContent", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public interface ReceiveContentListener {
    @Nullable
    TransferableContent onReceive(@NotNull TransferableContent transferableContent);

    default void onDragEnd() {
    }

    default void onDragEnter() {
    }

    default void onDragExit() {
    }

    default void onDragStart() {
    }
}
