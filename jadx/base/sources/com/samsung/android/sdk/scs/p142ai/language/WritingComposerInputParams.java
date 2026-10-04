package com.samsung.android.sdk.scs.p142ai.language;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class WritingComposerInputParams {
    private byte[] data;
    private String dataMimeType;
    private final String dynamicFormat;
    private final String dynamicTone;
    private final WritingComposerFormat format;
    private final String inputText;
    private int outputSentenceCount;
    private final WritingComposerTone tone;

    public WritingComposerInputParams(@NonNull String str, @NonNull WritingComposerFormat writingComposerFormat, @NonNull WritingComposerTone writingComposerTone) {
        this.inputText = str;
        this.format = writingComposerFormat;
        this.tone = writingComposerTone;
        this.dynamicFormat = "";
        this.dynamicTone = "";
    }

    public byte[] getData() {
        return this.data;
    }

    public String getDataMimeType() {
        return this.dataMimeType;
    }

    public String getDynamicFormat() {
        return this.dynamicFormat;
    }

    public String getDynamicTone() {
        return this.dynamicTone;
    }

    public WritingComposerFormat getFormat() {
        return this.format;
    }

    public String getInputText() {
        return this.inputText;
    }

    public int getOutputSentenceCount() {
        return this.outputSentenceCount;
    }

    public WritingComposerTone getTone() {
        return this.tone;
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

    public void setOutputSentenceCount(int i) {
        this.outputSentenceCount = i;
    }

    public WritingComposerInputParams(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        this.inputText = str;
        this.format = WritingComposerFormat.WRITINGCOMPOSER_STANDARD;
        this.tone = WritingComposerTone.WRITINGCOMPOSER_PROFESSIONAL;
        this.dynamicFormat = str2;
        this.dynamicTone = str3;
    }

    public WritingComposerInputParams(@NonNull String str, @Nullable String str2, @Nullable byte[] bArr, @NonNull WritingComposerFormat writingComposerFormat, @NonNull WritingComposerTone writingComposerTone, int i) {
        this.inputText = str;
        this.dataMimeType = str2;
        this.data = bArr;
        this.format = writingComposerFormat;
        this.tone = writingComposerTone;
        this.outputSentenceCount = i;
        this.dynamicFormat = "";
        this.dynamicTone = "";
    }

    public WritingComposerInputParams(@NonNull String str, @Nullable String str2, @Nullable byte[] bArr, @NonNull String str3, @NonNull String str4, int i) {
        this.inputText = str;
        this.dataMimeType = str2;
        this.data = bArr;
        this.format = WritingComposerFormat.WRITINGCOMPOSER_STANDARD;
        this.tone = WritingComposerTone.WRITINGCOMPOSER_PROFESSIONAL;
        this.outputSentenceCount = i;
        this.dynamicFormat = str3;
        this.dynamicTone = str4;
    }
}
