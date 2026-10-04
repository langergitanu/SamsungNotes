package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/IConvertParams;", "", "docCreator", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/ISpenDocCreator;", "getDocCreator", "()Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/ISpenDocCreator;", "composer", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/INoteComposer;", "getComposer", "()Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/INoteComposer;", "resourceGetter", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/IResourceGetter;", "getResourceGetter", "()Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/IResourceGetter;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IConvertParams {
    @NotNull
    INoteComposer getComposer();

    @Nullable
    ISpenDocCreator getDocCreator();

    @Nullable
    IResourceGetter getResourceGetter();
}
