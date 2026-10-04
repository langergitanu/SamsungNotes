package com.samsung.android.sdk.pdf;

import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006R.\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/sdk/pdf/SpenPdfParagraph;", "", "<init>", "()V", "listPdfText", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pdf/SpenPdfText;", "Lkotlin/collections/ArrayList;", "getListPdfText", "()Ljava/util/ArrayList;", "setListPdfText", "(Ljava/util/ArrayList;)V", "add", "", ExternalDataConstants.Column.PDF_TEXT, "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenPdfParagraph {

    @Nullable
    private ArrayList<SpenPdfText> listPdfText = new ArrayList<>();

    public final void add(@Nullable SpenPdfText pdfText) {
        if (pdfText == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        ArrayList<SpenPdfText> arrayList = this.listPdfText;
        Intrinsics.checkNotNull(arrayList);
        arrayList.add(pdfText);
    }

    @Nullable
    public final ArrayList<SpenPdfText> getListPdfText() {
        return this.listPdfText;
    }

    public final void setListPdfText(@Nullable ArrayList<SpenPdfText> arrayList) {
        this.listPdfText = arrayList;
    }
}
