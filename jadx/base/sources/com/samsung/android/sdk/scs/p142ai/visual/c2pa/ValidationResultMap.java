package com.samsung.android.sdk.scs.p142ai.visual.c2pa;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J?\u0010\u0010\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/sdk/scs/ai/visual/c2pa/ValidationResultMap;", "", "success", "", "Lcom/samsung/android/sdk/scs/ai/visual/c2pa/ValidationStatus;", "informational", Bixby2Constants.ResponseOutputResult.RESULT_FAILURE, "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getSuccess", "()Ljava/util/List;", "getInformational", "getFailure", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "scs-ai-4.0.55_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final /* data */ class ValidationResultMap {

    @Nullable
    private final List<ValidationStatus> failure;

    @Nullable
    private final List<ValidationStatus> informational;

    @Nullable
    private final List<ValidationStatus> success;

    public ValidationResultMap(@Nullable List<ValidationStatus> list, @Nullable List<ValidationStatus> list2, @Nullable List<ValidationStatus> list3) {
        this.success = list;
        this.informational = list2;
        this.failure = list3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ValidationResultMap copy$default(ValidationResultMap validationResultMap, List list, List list2, List list3, int i, Object obj) {
        if ((i & 1) != 0) {
            list = validationResultMap.success;
        }
        if ((i & 2) != 0) {
            list2 = validationResultMap.informational;
        }
        if ((i & 4) != 0) {
            list3 = validationResultMap.failure;
        }
        return validationResultMap.copy(list, list2, list3);
    }

    @Nullable
    public final List<ValidationStatus> component1() {
        return this.success;
    }

    @Nullable
    public final List<ValidationStatus> component2() {
        return this.informational;
    }

    @Nullable
    public final List<ValidationStatus> component3() {
        return this.failure;
    }

    @NotNull
    public final ValidationResultMap copy(@Nullable List<ValidationStatus> success, @Nullable List<ValidationStatus> informational, @Nullable List<ValidationStatus> failure) {
        return new ValidationResultMap(success, informational, failure);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ValidationResultMap)) {
            return false;
        }
        ValidationResultMap validationResultMap = (ValidationResultMap) other;
        return Intrinsics.areEqual(this.success, validationResultMap.success) && Intrinsics.areEqual(this.informational, validationResultMap.informational) && Intrinsics.areEqual(this.failure, validationResultMap.failure);
    }

    @Nullable
    public final List<ValidationStatus> getFailure() {
        return this.failure;
    }

    @Nullable
    public final List<ValidationStatus> getInformational() {
        return this.informational;
    }

    @Nullable
    public final List<ValidationStatus> getSuccess() {
        return this.success;
    }

    public int hashCode() {
        List<ValidationStatus> list = this.success;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<ValidationStatus> list2 = this.informational;
        int iHashCode2 = (iHashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<ValidationStatus> list3 = this.failure;
        return iHashCode2 + (list3 != null ? list3.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        List<ValidationStatus> list = this.success;
        List<ValidationStatus> list2 = this.informational;
        List<ValidationStatus> list3 = this.failure;
        StringBuilder sb = new StringBuilder("ValidationResultMap(success=");
        sb.append(list);
        sb.append(", informational=");
        sb.append(list2);
        sb.append(", failure=");
        return AbstractC0541b.m777s(sb, list3, ")");
    }
}
