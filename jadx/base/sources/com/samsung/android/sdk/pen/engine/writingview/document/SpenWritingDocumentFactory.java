package com.samsung.android.sdk.pen.engine.writingview.document;

import com.samsung.android.sdk.pen.document.SpenPageDoc;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/writingview/document/SpenWritingDocumentFactory;", "", "<init>", "()V", "createDocument", "Lcom/samsung/android/sdk/pen/engine/writingview/document/SpenWritingDocument;", "pageDoc", "Lcom/samsung/android/sdk/pen/document/SpenPageDoc;", "wNote", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenWritingDocumentFactory {

    @NotNull
    public static final SpenWritingDocumentFactory INSTANCE = new SpenWritingDocumentFactory();

    private SpenWritingDocumentFactory() {
    }

    @JvmStatic
    @NotNull
    public static final SpenWritingDocument createDocument(@Nullable SpenPageDoc pageDoc) {
        return new SpenWritingPageDocDocument(pageDoc);
    }

    @JvmStatic
    @NotNull
    public static final SpenWritingDocument createDocument(@Nullable SpenWNote wNote) {
        return new SpenWritingWNoteDocument(wNote);
    }
}
