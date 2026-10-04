package com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.text.span;

import com.samsung.android.support.senl.p148nt.base.composer.text.span.Alignment;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.common.TableStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0005H\u0014J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0014¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/model/composer/text/span/TableCellAlign;", "Lcom/samsung/android/support/senl/nt/base/composer/text/span/Alignment;", "<init>", "()V", "align", "", "(I)V", "getStoredSpan", "storeSpan", "", "value", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class TableCellAlign extends Alignment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/model/composer/text/span/TableCellAlign$Companion;", "", "<init>", "()V", "getStoredValue", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getStoredValue() {
            return Alignment.getStoredValue("Composer", TableStyle.KEY_ALIGN);
        }

        private Companion() {
        }
    }

    public TableCellAlign() {
        super("Composer", TableStyle.KEY_ALIGN);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.text.span.AbsStoredIntegerSpan
    public int getStoredSpan() {
        return -1;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.text.span.AbsStoredIntegerSpan
    public void storeSpan(int value) {
    }

    public TableCellAlign(int i) {
        super("Composer", TableStyle.KEY_ALIGN, i);
    }
}
