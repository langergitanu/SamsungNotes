package com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.text.span;

import com.samsung.android.support.senl.p148nt.base.composer.text.span.AbsStoredIntegerSpan;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.FontSize;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.common.TableStyle;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0007J\b\u0010\u000b\u001a\u00020\u0003H\u0014J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0014R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0005¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/model/composer/text/span/TableCellFontSize;", "Lcom/samsung/android/support/senl/nt/base/composer/text/span/FontSize;", "deltaSize", "", "<init>", "(I)V", "fontSize", "(II)V", "getFontSize", "()I", "setFontSize", "getStoredSpan", "storeSpan", "", "value", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class TableCellFontSize extends FontSize {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private int fontSize;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/model/composer/text/span/TableCellFontSize$Companion;", "", "<init>", "()V", "getStoredValue", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getStoredValue() {
            try {
                return AbsStoredIntegerSpan.getStoredSpan("Composer", TableStyle.KEY_FONT_SIZE);
            } catch (NoSuchElementException unused) {
                return 15;
            }
        }

        private Companion() {
        }
    }

    public TableCellFontSize(int i) {
        super("Composer", TableStyle.KEY_FONT_SIZE, i);
        this.fontSize = 15;
    }

    public final int getFontSize() {
        return this.fontSize;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.text.span.AbsStoredIntegerSpan
    public int getStoredSpan() {
        return this.fontSize;
    }

    public final void setFontSize(int i) {
        this.fontSize = i;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.text.span.AbsStoredIntegerSpan
    public void storeSpan(int value) {
        this.fontSize = value;
    }

    public TableCellFontSize(int i, int i2) {
        super("Composer", TableStyle.KEY_FONT_SIZE, i, i2);
        this.fontSize = 15;
    }
}
