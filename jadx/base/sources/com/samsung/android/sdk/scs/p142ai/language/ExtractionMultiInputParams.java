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
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J=\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013¨\u0006%"}, m13886d2 = {"Lcom/samsung/android/sdk/scs/ai/language/ExtractionMultiInputParams;", "", ImageEditorConst.KEY_PARAM_INPUT_TEXT, "", Constants.JTAG_DATA_LIST, "", "", "category", "Lcom/samsung/android/sdk/scs/ai/language/ExtractionCategory;", "dataMimeTypeList", "<init>", "(Ljava/lang/String;Ljava/util/List;Lcom/samsung/android/sdk/scs/ai/language/ExtractionCategory;Ljava/util/List;)V", "getInputText", "()Ljava/lang/String;", "setInputText", "(Ljava/lang/String;)V", "getDataList", "()Ljava/util/List;", "setDataList", "(Ljava/util/List;)V", "getCategory", "()Lcom/samsung/android/sdk/scs/ai/language/ExtractionCategory;", "setCategory", "(Lcom/samsung/android/sdk/scs/ai/language/ExtractionCategory;)V", "getDataMimeTypeList", "setDataMimeTypeList", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "scs-ai-4.0.55_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final /* data */ class ExtractionMultiInputParams {

    @NotNull
    private ExtractionCategory category;

    @NotNull
    private List<byte[]> dataList;

    @NotNull
    private List<String> dataMimeTypeList;

    @NotNull
    private String inputText;

    public ExtractionMultiInputParams(@NotNull String inputText, @NotNull List<byte[]> dataList, @NotNull ExtractionCategory category, @NotNull List<String> dataMimeTypeList) {
        Intrinsics.checkNotNullParameter(inputText, "inputText");
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(dataMimeTypeList, "dataMimeTypeList");
        this.inputText = inputText;
        this.dataList = dataList;
        this.category = category;
        this.dataMimeTypeList = dataMimeTypeList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ExtractionMultiInputParams copy$default(ExtractionMultiInputParams extractionMultiInputParams, String str, List list, ExtractionCategory extractionCategory, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = extractionMultiInputParams.inputText;
        }
        if ((i & 2) != 0) {
            list = extractionMultiInputParams.dataList;
        }
        if ((i & 4) != 0) {
            extractionCategory = extractionMultiInputParams.category;
        }
        if ((i & 8) != 0) {
            list2 = extractionMultiInputParams.dataMimeTypeList;
        }
        return extractionMultiInputParams.copy(str, list, extractionCategory, list2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getInputText() {
        return this.inputText;
    }

    @NotNull
    public final List<byte[]> component2() {
        return this.dataList;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ExtractionCategory getCategory() {
        return this.category;
    }

    @NotNull
    public final List<String> component4() {
        return this.dataMimeTypeList;
    }

    @NotNull
    public final ExtractionMultiInputParams copy(@NotNull String inputText, @NotNull List<byte[]> dataList, @NotNull ExtractionCategory category, @NotNull List<String> dataMimeTypeList) {
        Intrinsics.checkNotNullParameter(inputText, "inputText");
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(dataMimeTypeList, "dataMimeTypeList");
        return new ExtractionMultiInputParams(inputText, dataList, category, dataMimeTypeList);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExtractionMultiInputParams)) {
            return false;
        }
        ExtractionMultiInputParams extractionMultiInputParams = (ExtractionMultiInputParams) other;
        return Intrinsics.areEqual(this.inputText, extractionMultiInputParams.inputText) && Intrinsics.areEqual(this.dataList, extractionMultiInputParams.dataList) && this.category == extractionMultiInputParams.category && Intrinsics.areEqual(this.dataMimeTypeList, extractionMultiInputParams.dataMimeTypeList);
    }

    @NotNull
    public final ExtractionCategory getCategory() {
        return this.category;
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
    public final String getInputText() {
        return this.inputText;
    }

    public int hashCode() {
        return this.dataMimeTypeList.hashCode() + ((this.category.hashCode() + AbstractC0622a.m1159e(this.dataList, this.inputText.hashCode() * 31, 31)) * 31);
    }

    public final void setCategory(@NotNull ExtractionCategory extractionCategory) {
        Intrinsics.checkNotNullParameter(extractionCategory, "<set-?>");
        this.category = extractionCategory;
    }

    public final void setDataList(@NotNull List<byte[]> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.dataList = list;
    }

    public final void setDataMimeTypeList(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.dataMimeTypeList = list;
    }

    public final void setInputText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.inputText = str;
    }

    @NotNull
    public String toString() {
        return "ExtractionMultiInputParams(inputText=" + this.inputText + ", dataList=" + this.dataList + ", category=" + this.category + ", dataMimeTypeList=" + this.dataMimeTypeList + ")";
    }

    public /* synthetic */ ExtractionMultiInputParams(String str, List list, ExtractionCategory extractionCategory, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, list, extractionCategory, list2);
    }
}
