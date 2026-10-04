package com.samsung.android.sdk.scs.p142ai.language;

import androidx.annotation.NonNull;
import com.samsung.android.sdk.scs.p142ai.language.ExtractionCategory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ExtractionInputParams {
    private final ExtractionCategory.MultiModal category;
    private byte[] data;
    private String dataMimeType;
    private final String inputText;

    @Deprecated
    public ExtractionInputParams(@NonNull String str, @NonNull ExtractionCategory extractionCategory) {
        this.inputText = str;
        this.category = ExtractionCategory.MultiModal.valueOf(extractionCategory.name());
        this.dataMimeType = "";
    }

    @NonNull
    public ExtractionCategory.MultiModal getCategory() {
        return this.category;
    }

    public byte[] getData() {
        return this.data;
    }

    @NonNull
    public String getDataMimeType() {
        return this.dataMimeType;
    }

    @NonNull
    public String getInputText() {
        return this.inputText;
    }

    public void setData(byte[] bArr) {
        if (bArr != null) {
            byte[] bArr2 = new byte[bArr.length];
            this.data = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        }
    }

    public void setDataMimeType(String str) {
        this.dataMimeType = str;
    }

    public ExtractionInputParams(@NonNull String str, @NonNull ExtractionCategory.MultiModal multiModal) {
        this.inputText = str;
        this.category = multiModal;
        this.dataMimeType = "";
    }

    @Deprecated
    public ExtractionInputParams(@NonNull String str, byte[] bArr, @NonNull ExtractionCategory extractionCategory) {
        this.inputText = str;
        this.data = bArr;
        this.category = ExtractionCategory.MultiModal.valueOf(extractionCategory.name());
        this.dataMimeType = "";
    }

    public ExtractionInputParams(@NonNull String str, byte[] bArr, @NonNull ExtractionCategory.MultiModal multiModal) {
        this.inputText = str;
        this.data = bArr;
        this.category = multiModal;
        this.dataMimeType = "";
    }

    @Deprecated
    public ExtractionInputParams(@NonNull String str, byte[] bArr, @NonNull ExtractionCategory extractionCategory, @NonNull String str2) {
        this.inputText = str;
        this.data = bArr;
        this.category = ExtractionCategory.MultiModal.valueOf(extractionCategory.name());
        this.dataMimeType = str2;
    }

    public ExtractionInputParams(@NonNull String str, byte[] bArr, @NonNull ExtractionCategory.MultiModal multiModal, @NonNull String str2) {
        this.inputText = str;
        this.data = bArr;
        this.category = multiModal;
        this.dataMimeType = str2;
    }
}
