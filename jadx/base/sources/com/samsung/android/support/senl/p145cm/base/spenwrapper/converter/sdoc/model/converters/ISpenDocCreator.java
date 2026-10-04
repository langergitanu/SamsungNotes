package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters;

import com.samsung.android.sdk.composer.document.sdoc.SpenSDoc;
import com.samsung.android.sdk.pen.document.SpenPageDoc;
import com.samsung.android.sdk.pen.document.SpenPaintingDoc;
import com.samsung.android.sdk.pen.engine.SpenCapturePage;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J$\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H&J\u0014\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/ISpenDocCreator;", "", "createSDoc", "Lcom/samsung/android/sdk/composer/document/sdoc/SpenSDoc;", "path", "", "createPaintingDoc", "Lcom/samsung/android/sdk/pen/document/SpenPaintingDoc;", "width", "", "height", "file", "createCapturePage", "Lcom/samsung/android/sdk/pen/engine/SpenCapturePage;", "pageDoc", "Lcom/samsung/android/sdk/pen/document/SpenPageDoc;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface ISpenDocCreator {
    @Nullable
    SpenCapturePage createCapturePage(@Nullable SpenPageDoc pageDoc);

    @Nullable
    SpenPaintingDoc createPaintingDoc(int width, int height, @Nullable String file);

    @Nullable
    SpenSDoc createSDoc(@Nullable String path);
}
