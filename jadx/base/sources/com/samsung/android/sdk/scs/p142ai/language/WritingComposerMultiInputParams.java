package com.samsung.android.sdk.scs.p142ai.language;

import androidx.collection.AbstractC0622a;
import com.samsung.android.smartswitchfileshare.Constants;
import com.samsung.android.visual.p167ai.sdkcommon.image.ImageEditorConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00070\u0005HÆ\u0003J\t\u0010%\u001a\u00020\tHÆ\u0003J\t\u0010&\u001a\u00020\u000bHÆ\u0003J\t\u0010'\u001a\u00020\rHÆ\u0003JQ\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\rHÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006."}, m13886d2 = {"Lcom/samsung/android/sdk/scs/ai/language/WritingComposerMultiInputParams;", "", ImageEditorConst.KEY_PARAM_INPUT_TEXT, "", "dataMimeTypeList", "", Constants.JTAG_DATA_LIST, "", "format", "Lcom/samsung/android/sdk/scs/ai/language/WritingComposerFormat;", "tone", "Lcom/samsung/android/sdk/scs/ai/language/WritingComposerTone;", "outputSentenceCount", "", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/samsung/android/sdk/scs/ai/language/WritingComposerFormat;Lcom/samsung/android/sdk/scs/ai/language/WritingComposerTone;I)V", "getInputText", "()Ljava/lang/String;", "getDataMimeTypeList", "()Ljava/util/List;", "setDataMimeTypeList", "(Ljava/util/List;)V", "getDataList", "setDataList", "getFormat", "()Lcom/samsung/android/sdk/scs/ai/language/WritingComposerFormat;", "setFormat", "(Lcom/samsung/android/sdk/scs/ai/language/WritingComposerFormat;)V", "getTone", "()Lcom/samsung/android/sdk/scs/ai/language/WritingComposerTone;", "getOutputSentenceCount", "()I", "setOutputSentenceCount", "(I)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "scs-ai-4.0.55_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final /* data */ class WritingComposerMultiInputParams {

    @NotNull
    private List<byte[]> dataList;

    @NotNull
    private List<String> dataMimeTypeList;

    @NotNull
    private WritingComposerFormat format;

    @NotNull
    private final String inputText;
    private int outputSentenceCount;

    @NotNull
    private final WritingComposerTone tone;

    public WritingComposerMultiInputParams(@NotNull String inputText, @NotNull List<String> dataMimeTypeList, @NotNull List<byte[]> dataList, @NotNull WritingComposerFormat format, @NotNull WritingComposerTone tone, int i) {
        Intrinsics.checkNotNullParameter(inputText, "inputText");
        Intrinsics.checkNotNullParameter(dataMimeTypeList, "dataMimeTypeList");
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(tone, "tone");
        this.inputText = inputText;
        this.dataMimeTypeList = dataMimeTypeList;
        this.dataList = dataList;
        this.format = format;
        this.tone = tone;
        this.outputSentenceCount = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WritingComposerMultiInputParams copy$default(WritingComposerMultiInputParams writingComposerMultiInputParams, String str, List list, List list2, WritingComposerFormat writingComposerFormat, WritingComposerTone writingComposerTone, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = writingComposerMultiInputParams.inputText;
        }
        if ((i2 & 2) != 0) {
            list = writingComposerMultiInputParams.dataMimeTypeList;
        }
        if ((i2 & 4) != 0) {
            list2 = writingComposerMultiInputParams.dataList;
        }
        if ((i2 & 8) != 0) {
            writingComposerFormat = writingComposerMultiInputParams.format;
        }
        if ((i2 & 16) != 0) {
            writingComposerTone = writingComposerMultiInputParams.tone;
        }
        if ((i2 & 32) != 0) {
            i = writingComposerMultiInputParams.outputSentenceCount;
        }
        WritingComposerTone writingComposerTone2 = writingComposerTone;
        int i4 = i;
        return writingComposerMultiInputParams.copy(str, list, list2, writingComposerFormat, writingComposerTone2, i4);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getInputText() {
        return this.inputText;
    }

    @NotNull
    public final List<String> component2() {
        return this.dataMimeTypeList;
    }

    @NotNull
    public final List<byte[]> component3() {
        return this.dataList;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final WritingComposerFormat getFormat() {
        return this.format;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final WritingComposerTone getTone() {
        return this.tone;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getOutputSentenceCount() {
        return this.outputSentenceCount;
    }

    @NotNull
    public final WritingComposerMultiInputParams copy(@NotNull String inputText, @NotNull List<String> dataMimeTypeList, @NotNull List<byte[]> dataList, @NotNull WritingComposerFormat format, @NotNull WritingComposerTone tone, int outputSentenceCount) {
        Intrinsics.checkNotNullParameter(inputText, "inputText");
        Intrinsics.checkNotNullParameter(dataMimeTypeList, "dataMimeTypeList");
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(tone, "tone");
        return new WritingComposerMultiInputParams(inputText, dataMimeTypeList, dataList, format, tone, outputSentenceCount);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WritingComposerMultiInputParams)) {
            return false;
        }
        WritingComposerMultiInputParams writingComposerMultiInputParams = (WritingComposerMultiInputParams) other;
        return Intrinsics.areEqual(this.inputText, writingComposerMultiInputParams.inputText) && Intrinsics.areEqual(this.dataMimeTypeList, writingComposerMultiInputParams.dataMimeTypeList) && Intrinsics.areEqual(this.dataList, writingComposerMultiInputParams.dataList) && this.format == writingComposerMultiInputParams.format && this.tone == writingComposerMultiInputParams.tone && this.outputSentenceCount == writingComposerMultiInputParams.outputSentenceCount;
    }

    @NotNull
    public final List<byte[]> getDataList() {
        return this.dataList;
    }

    @NotNull
    public final List<String> getDataMimeTypeList() {
        return this.dataMimeTypeList;
    }

    @NotNull
    public final WritingComposerFormat getFormat() {
        return this.format;
    }

    @NotNull
    public final String getInputText() {
        return this.inputText;
    }

    public final int getOutputSentenceCount() {
        return this.outputSentenceCount;
    }

    @NotNull
    public final WritingComposerTone getTone() {
        return this.tone;
    }

    public int hashCode() {
        return Integer.hashCode(this.outputSentenceCount) + ((this.tone.hashCode() + ((this.format.hashCode() + AbstractC0622a.m1159e(this.dataList, AbstractC0622a.m1159e(this.dataMimeTypeList, this.inputText.hashCode() * 31, 31), 31)) * 31)) * 31);
    }

    public final void setDataList(@NotNull List<byte[]> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.dataList = list;
    }

    public final void setDataMimeTypeList(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.dataMimeTypeList = list;
    }

    public final void setFormat(@NotNull WritingComposerFormat writingComposerFormat) {
        Intrinsics.checkNotNullParameter(writingComposerFormat, "<set-?>");
        this.format = writingComposerFormat;
    }

    public final void setOutputSentenceCount(int i) {
        this.outputSentenceCount = i;
    }

    @NotNull
    public String toString() {
        return "WritingComposerMultiInputParams(inputText=" + this.inputText + ", dataMimeTypeList=" + this.dataMimeTypeList + ", dataList=" + this.dataList + ", format=" + this.format + ", tone=" + this.tone + ", outputSentenceCount=" + this.outputSentenceCount + ")";
    }

    public /* synthetic */ WritingComposerMultiInputParams(String str, List list, List list2, WritingComposerFormat writingComposerFormat, WritingComposerTone writingComposerTone, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, list, list2, (i2 & 8) != 0 ? WritingComposerFormat.WRITINGCOMPOSER_STANDARD : writingComposerFormat, (i2 & 16) != 0 ? WritingComposerTone.WRITINGCOMPOSER_PROFESSIONAL : writingComposerTone, (i2 & 32) != 0 ? 1 : i);
    }
}
