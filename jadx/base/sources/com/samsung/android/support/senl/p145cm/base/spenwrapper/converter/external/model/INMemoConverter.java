package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model;

import androidx.annotation.IntRange;
import com.samsung.android.support.senl.document.data.MemoMetaDataItem;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\bR\u001a\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/INMemoConverter;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/IDocumentConverter;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/INMemoConverter$ConverterParams;", "memoMetaData", "", "Lcom/samsung/android/support/senl/document/data/MemoMetaDataItem;", "getMemoMetaData", "()Ljava/util/List;", "ConverterParams", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface INMemoConverter extends IDocumentConverter<ConverterParams> {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0005J\u0010\u0010\u0012\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0014\u001a\u00020\u00002\b\b\u0001\u0010\r\u001a\u00020\fR\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/INMemoConverter$ConverterParams;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/AbsPathConvertParams;", "<init>", "()V", "value", "", "isDeleteData", "()Z", "", "memoUuid", "getMemoUuid", "()Ljava/lang/String;", "", "mode", "getMode", "()I", "setDeleteDataAfterConvert", "deleteData", "setUuid", "uuid", "setMode", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ConverterParams extends AbsPathConvertParams<ConverterParams> {
        public static final int MODE_NORMAL = 0;
        public static final int MODE_RENAME = 2;
        public static final int MODE_REPLACE = 1;
        private boolean isDeleteData;

        @Nullable
        private String memoUuid;
        private int mode;

        public ConverterParams() {
            super(ConverterParams.class);
        }

        @Nullable
        public final String getMemoUuid() {
            return this.memoUuid;
        }

        public final int getMode() {
            return this.mode;
        }

        /* JADX INFO: renamed from: isDeleteData, reason: from getter */
        public final boolean getIsDeleteData() {
            return this.isDeleteData;
        }

        @NotNull
        public final ConverterParams setDeleteDataAfterConvert(boolean deleteData) {
            this.isDeleteData = deleteData;
            return this;
        }

        @NotNull
        public final ConverterParams setMode(@IntRange(from = 0, m706to = 2) int mode) {
            this.mode = mode;
            return this;
        }

        @NotNull
        public final ConverterParams setUuid(@Nullable String uuid) {
            this.memoUuid = uuid;
            return this;
        }
    }

    @Nullable
    List<MemoMetaDataItem> getMemoMetaData();
}
