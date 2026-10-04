package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model;

import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.support.senl.document.data.MemoMetaDataItem;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0006J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0002H&¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/IScrapbookConverter;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/IDocumentConverter;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/IScrapbookConverter$ConverterParams;", "getMetaData", "Lcom/samsung/android/support/senl/document/data/MemoMetaDataItem;", ActionHandler.PARAMS, "ConverterParams", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IScrapbookConverter extends IDocumentConverter<ConverterParams> {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\r\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u000f\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\tR\"\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/IScrapbookConverter$ConverterParams;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/AbsPathConvertParams;", "<init>", "()V", "value", "Lorg/json/JSONObject;", "jSONObject", "getJSONObject", "()Lorg/json/JSONObject;", "", "categoryId", "getCategoryId", "()Ljava/lang/String;", "setJsonObject", CoeditServiceConstants.Element.NAME_OBJECT, "setCategoryId", "id", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ConverterParams extends AbsPathConvertParams<ConverterParams> {

        @Nullable
        private String categoryId;

        @Nullable
        private JSONObject jSONObject;

        public ConverterParams() {
            super(ConverterParams.class);
        }

        @Nullable
        public final String getCategoryId() {
            return this.categoryId;
        }

        @Nullable
        public final JSONObject getJSONObject() {
            return this.jSONObject;
        }

        @NotNull
        public final ConverterParams setCategoryId(@Nullable String id) {
            this.categoryId = id;
            return this;
        }

        @NotNull
        public final ConverterParams setJsonObject(@Nullable JSONObject object) {
            this.jSONObject = object;
            return this;
        }
    }

    @Nullable
    MemoMetaDataItem getMetaData(@NotNull ConverterParams params);
}
