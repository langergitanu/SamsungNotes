package com.samsung.android.sdk.scs.p142ai.language;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.sdk.scs.p142ai.language.SuggestionCategory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class SuggestionInputParams {
    private final SuggestionCategory.MultiModal category;
    private byte[] data;
    private String dataMimeType;
    private final String inputText;

    public SuggestionInputParams(@NonNull String str, @NonNull SuggestionCategory.MultiModal multiModal) {
        this.inputText = str;
        this.category = multiModal;
        this.dataMimeType = "";
    }

    @NonNull
    public SuggestionCategory.MultiModal getCategory() {
        return this.category;
    }

    @Nullable
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

    public void setData(@NonNull byte[] bArr) {
        if (bArr != null) {
            byte[] bArr2 = new byte[bArr.length];
            this.data = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        }
    }

    public void setDataMimeType(@NonNull String str) {
        this.dataMimeType = str;
    }

    public SuggestionInputParams(@NonNull String str, byte[] bArr, @NonNull SuggestionCategory.MultiModal multiModal) {
        this.inputText = str;
        this.data = bArr;
        this.category = multiModal;
        this.dataMimeType = "";
    }

    public SuggestionInputParams(@NonNull String str, byte[] bArr, @NonNull SuggestionCategory.MultiModal multiModal, @NonNull String str2) {
        this.inputText = str;
        this.data = bArr;
        this.category = multiModal;
        this.dataMimeType = str2;
    }
}
