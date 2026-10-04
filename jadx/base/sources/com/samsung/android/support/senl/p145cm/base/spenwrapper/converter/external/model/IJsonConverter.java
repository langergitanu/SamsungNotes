package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model;

import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.support.senl.document.data.MemoMetaDataItem;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0006J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H&¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/IJsonConverter;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/IDocumentConverter;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/IJsonConverter$ConverterParams;", "getMemoMetaData", "Lcom/samsung/android/support/senl/document/data/MemoMetaDataItem;", ActionHandler.PARAMS, "ConverterParams", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IJsonConverter extends IDocumentConverter<ConverterParams> {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000f\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0011\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0012\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0014\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\"\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\"\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\b¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/IJsonConverter$ConverterParams;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/AbsConvertParams;", "<init>", "()V", "value", "", "dirPath", "getDirPath", "()Ljava/lang/String;", "extDirPath", "getExtDirPath", "categoryName", "getCategoryName", "categoryUUID", "getCategoryUUID", "setSyncDirPath", "path", "setExtDirPath", "setCategoryName", "name", "setCategoryUUID", "uuid", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ConverterParams extends AbsConvertParams<ConverterParams> {

        @Nullable
        private String categoryName;

        @Nullable
        private String categoryUUID;

        @Nullable
        private String dirPath;

        @Nullable
        private String extDirPath;

        public ConverterParams() {
            super(ConverterParams.class);
        }

        @Nullable
        public final String getCategoryName() {
            return this.categoryName;
        }

        @Nullable
        public final String getCategoryUUID() {
            return this.categoryUUID;
        }

        @Nullable
        public final String getDirPath() {
            return this.dirPath;
        }

        @Nullable
        public final String getExtDirPath() {
            return this.extDirPath;
        }

        @NotNull
        public final ConverterParams setCategoryName(@Nullable String name) {
            this.categoryName = name;
            return this;
        }

        @NotNull
        public final ConverterParams setCategoryUUID(@Nullable String uuid) {
            this.categoryUUID = uuid;
            return this;
        }

        @NotNull
        public final ConverterParams setExtDirPath(@Nullable String path) {
            this.extDirPath = path;
            return this;
        }

        @NotNull
        public final ConverterParams setSyncDirPath(@Nullable String path) {
            this.dirPath = path;
            return this;
        }
    }

    @Nullable
    MemoMetaDataItem getMemoMetaData(@Nullable ConverterParams params);
}
