package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model;

import androidx.annotation.IntRange;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/ISNBConverter;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/IDocumentConverter;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/ISNBConverter$ConverterParams;", "isAlreadyConverted", "", "filePath", "", "ConverterParams", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface ISNBConverter extends IDocumentConverter<ConverterParams> {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\u00002\b\b\u0001\u0010\u0006\u001a\u00020\u0005R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/ISNBConverter$ConverterParams;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/AbsPathConvertParams;", "<init>", "()V", "value", "", "mode", "getMode", "()I", "setMode", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ConverterParams extends AbsPathConvertParams<ConverterParams> {
        public static final int MODE_NORMAL = 0;
        public static final int MODE_RENAME = 2;
        public static final int MODE_REPLACE = 1;
        private int mode;

        public ConverterParams() {
            super(ConverterParams.class);
        }

        public final int getMode() {
            return this.mode;
        }

        @NotNull
        public final ConverterParams setMode(@IntRange(from = 0, m706to = 2) int mode) {
            this.mode = mode;
            return this;
        }
    }

    boolean isAlreadyConverted(@Nullable String filePath);
}
