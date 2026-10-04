package androidx.compose.foundation.content.internal;

import androidx.compose.foundation.content.ReceiveContentListener;
import androidx.compose.foundation.content.ReceiveContentNode;
import androidx.compose.foundation.content.TransferableContent;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\f"}, m13886d2 = {"Landroidx/compose/foundation/content/internal/DynamicReceiveContentConfiguration;", "Landroidx/compose/foundation/content/internal/ReceiveContentConfiguration;", "receiveContentNode", "Landroidx/compose/foundation/content/ReceiveContentNode;", "(Landroidx/compose/foundation/content/ReceiveContentNode;)V", "receiveContentListener", "Landroidx/compose/foundation/content/ReceiveContentListener;", "getReceiveContentListener", "()Landroidx/compose/foundation/content/ReceiveContentListener;", "getReceiveContentNode", "()Landroidx/compose/foundation/content/ReceiveContentNode;", "getParentReceiveContentListener", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class DynamicReceiveContentConfiguration extends ReceiveContentConfiguration {
    public static final int $stable = 8;

    @NotNull
    private final ReceiveContentListener receiveContentListener = new ReceiveContentListener() { // from class: androidx.compose.foundation.content.internal.DynamicReceiveContentConfiguration$receiveContentListener$1
        private int nodeEnterCount;

        @Override // androidx.compose.foundation.content.ReceiveContentListener
        public void onDragEnd() {
            this.this$0.getReceiveContentNode().getReceiveContentListener().onDragEnd();
            this.nodeEnterCount = 0;
        }

        @Override // androidx.compose.foundation.content.ReceiveContentListener
        public void onDragEnter() {
            int i = this.nodeEnterCount + 1;
            this.nodeEnterCount = i;
            if (i == 1) {
                this.this$0.getReceiveContentNode().getReceiveContentListener().onDragEnter();
            }
            ReceiveContentListener parentReceiveContentListener = this.this$0.getParentReceiveContentListener();
            if (parentReceiveContentListener != null) {
                parentReceiveContentListener.onDragEnter();
            }
        }

        @Override // androidx.compose.foundation.content.ReceiveContentListener
        public void onDragExit() {
            int i = this.nodeEnterCount;
            int iCoerceAtLeast = RangesKt.coerceAtLeast(i - 1, 0);
            this.nodeEnterCount = iCoerceAtLeast;
            if (iCoerceAtLeast == 0 && i > 0) {
                this.this$0.getReceiveContentNode().getReceiveContentListener().onDragExit();
            }
            ReceiveContentListener parentReceiveContentListener = this.this$0.getParentReceiveContentListener();
            if (parentReceiveContentListener != null) {
                parentReceiveContentListener.onDragExit();
            }
        }

        @Override // androidx.compose.foundation.content.ReceiveContentListener
        public void onDragStart() {
            this.nodeEnterCount = 0;
            this.this$0.getReceiveContentNode().getReceiveContentListener().onDragStart();
        }

        @Override // androidx.compose.foundation.content.ReceiveContentListener
        @Nullable
        public TransferableContent onReceive(@NotNull TransferableContent transferableContent) {
            TransferableContent transferableContentOnReceive = this.this$0.getReceiveContentNode().getReceiveContentListener().onReceive(transferableContent);
            if (transferableContentOnReceive == null) {
                return null;
            }
            ReceiveContentListener parentReceiveContentListener = this.this$0.getParentReceiveContentListener();
            return parentReceiveContentListener == null ? transferableContentOnReceive : parentReceiveContentListener.onReceive(transferableContentOnReceive);
        }
    };

    @NotNull
    private final ReceiveContentNode receiveContentNode;

    public DynamicReceiveContentConfiguration(@NotNull ReceiveContentNode receiveContentNode) {
        this.receiveContentNode = receiveContentNode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReceiveContentListener getParentReceiveContentListener() {
        ReceiveContentConfiguration receiveContentConfiguration = ReceiveContentConfigurationKt.getReceiveContentConfiguration(this.receiveContentNode);
        if (receiveContentConfiguration != null) {
            return receiveContentConfiguration.getReceiveContentListener();
        }
        return null;
    }

    @Override // androidx.compose.foundation.content.internal.ReceiveContentConfiguration
    @NotNull
    public ReceiveContentListener getReceiveContentListener() {
        return this.receiveContentListener;
    }

    @NotNull
    public final ReceiveContentNode getReceiveContentNode() {
        return this.receiveContentNode;
    }
}
