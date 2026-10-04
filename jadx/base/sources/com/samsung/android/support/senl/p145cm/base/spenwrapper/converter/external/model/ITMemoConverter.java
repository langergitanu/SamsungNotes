package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model;

import com.samsung.android.support.senl.document.data.MemoMetaDataItem;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tJ\"\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/ITMemoConverter;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/IDocumentConverter;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/ITMemoConverter$ConverterParams;", "getMetaData", "Ljava/util/ArrayList;", "Lcom/samsung/android/support/senl/document/data/MemoMetaDataItem;", "Lkotlin/collections/ArrayList;", "filePath", "", "ConverterParams", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface ITMemoConverter extends IDocumentConverter<ConverterParams> {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/ITMemoConverter$ConverterParams;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/AbsPathConvertParams;", "<init>", "()V", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ConverterParams extends AbsPathConvertParams<ConverterParams> {
        public ConverterParams() {
            super(ConverterParams.class);
        }
    }

    @NotNull
    ArrayList<MemoMetaDataItem> getMetaData(@Nullable String filePath);
}
