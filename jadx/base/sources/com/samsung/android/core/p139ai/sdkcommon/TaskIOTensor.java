package com.samsung.android.core.p139ai.sdkcommon;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.AbstractC0622a;
import com.sec.android.diagmonagent.dma.aperf.utils.aPerfUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 +2\u00020\u0001:\u0001+B?\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003¢\u0006\u0004\b\u000b\u0010\fB\t\b\u0016¢\u0006\u0004\b\u000b\u0010\rB\u0017\b\u0016\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0004\b\u000b\u0010\u000eB3\b\u0016\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\u0004\b\u000b\u0010\u000fB%\b\u0016\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\u0004\b\u000b\u0010\u0010B!\b\u0016\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\u0012B\u0011\b\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0004\b\u000b\u0010\u0015J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\nH\u0016J\b\u0010\u001f\u001a\u00020\nH\u0016J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\n0\u0003HÆ\u0003JI\u0010$\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003HÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020\nHÖ\u0001J\t\u0010*\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017¨\u0006,"}, m13886d2 = {"Lcom/samsung/android/core/ai/sdkcommon/TaskIOTensor;", "Landroid/os/Parcelable;", "promptIDs", "", "", "mPrompts", "Lcom/samsung/android/core/ai/sdkcommon/PromptTensor;", "mTensors", "Lcom/samsung/android/core/ai/sdkcommon/ImageTensor;", "mTokenIds", "", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "()V", "(Ljava/util/List;)V", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "(Ljava/util/List;Ljava/util/List;)V", aPerfUtil.DUMMY_SUB_OP_NAME, "(Ljava/util/List;Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getPromptIDs", "()Ljava/util/List;", "getMPrompts", "getMTensors", "getMTokenIds", "writeToParcel", "", "dest", "flags", "describeContents", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "scs-ai-4.0.55_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final /* data */ class TaskIOTensor implements Parcelable {

    @NotNull
    private final List<PromptTensor> mPrompts;

    @NotNull
    private final List<ImageTensor> mTensors;

    @NotNull
    private final List<Integer> mTokenIds;

    @NotNull
    private final List<String> promptIDs;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<TaskIOTensor> CREATOR = new Parcelable.Creator<TaskIOTensor>() { // from class: com.samsung.android.core.ai.sdkcommon.TaskIOTensor$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TaskIOTensor createFromParcel(Parcel source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return new TaskIOTensor(source, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TaskIOTensor[] newArray(int size) {
            return new TaskIOTensor[size];
        }
    };

    public /* synthetic */ TaskIOTensor(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TaskIOTensor copy$default(TaskIOTensor taskIOTensor, List list, List list2, List list3, List list4, int i, Object obj) {
        if ((i & 1) != 0) {
            list = taskIOTensor.promptIDs;
        }
        if ((i & 2) != 0) {
            list2 = taskIOTensor.mPrompts;
        }
        if ((i & 4) != 0) {
            list3 = taskIOTensor.mTensors;
        }
        if ((i & 8) != 0) {
            list4 = taskIOTensor.mTokenIds;
        }
        return taskIOTensor.copy(list, list2, list3, list4);
    }

    @NotNull
    public final List<String> component1() {
        return this.promptIDs;
    }

    @NotNull
    public final List<PromptTensor> component2() {
        return this.mPrompts;
    }

    @NotNull
    public final List<ImageTensor> component3() {
        return this.mTensors;
    }

    @NotNull
    public final List<Integer> component4() {
        return this.mTokenIds;
    }

    @NotNull
    public final TaskIOTensor copy(@NotNull List<String> promptIDs, @NotNull List<PromptTensor> mPrompts, @NotNull List<ImageTensor> mTensors, @NotNull List<Integer> mTokenIds) {
        Intrinsics.checkNotNullParameter(promptIDs, "promptIDs");
        Intrinsics.checkNotNullParameter(mPrompts, "mPrompts");
        Intrinsics.checkNotNullParameter(mTensors, "mTensors");
        Intrinsics.checkNotNullParameter(mTokenIds, "mTokenIds");
        return new TaskIOTensor(promptIDs, mPrompts, mTensors, mTokenIds);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        ImageTensor imageTensor = (ImageTensor) CollectionsKt.firstOrNull((List) this.mTensors);
        if (imageTensor != null) {
            return imageTensor.describeContents();
        }
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskIOTensor)) {
            return false;
        }
        TaskIOTensor taskIOTensor = (TaskIOTensor) other;
        return Intrinsics.areEqual(this.promptIDs, taskIOTensor.promptIDs) && Intrinsics.areEqual(this.mPrompts, taskIOTensor.mPrompts) && Intrinsics.areEqual(this.mTensors, taskIOTensor.mTensors) && Intrinsics.areEqual(this.mTokenIds, taskIOTensor.mTokenIds);
    }

    @NotNull
    public final List<PromptTensor> getMPrompts() {
        return this.mPrompts;
    }

    @NotNull
    public final List<ImageTensor> getMTensors() {
        return this.mTensors;
    }

    @NotNull
    public final List<Integer> getMTokenIds() {
        return this.mTokenIds;
    }

    @NotNull
    public final List<String> getPromptIDs() {
        return this.promptIDs;
    }

    public int hashCode() {
        return this.mTokenIds.hashCode() + AbstractC0622a.m1159e(this.mTensors, AbstractC0622a.m1159e(this.mPrompts, this.promptIDs.hashCode() * 31, 31), 31);
    }

    @NotNull
    public String toString() {
        return "TaskIOTensor(promptIDs=" + this.promptIDs + ", mPrompts=" + this.mPrompts + ", mTensors=" + this.mTensors + ", mTokenIds=" + this.mTokenIds + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeStringList(this.promptIDs);
        dest.writeTypedList(this.mPrompts);
        dest.writeTypedList(this.mTensors);
        dest.writeList(this.mTokenIds);
    }

    public TaskIOTensor(@NotNull List<String> promptIDs, @NotNull List<PromptTensor> mPrompts, @NotNull List<ImageTensor> mTensors, @NotNull List<Integer> mTokenIds) {
        Intrinsics.checkNotNullParameter(promptIDs, "promptIDs");
        Intrinsics.checkNotNullParameter(mPrompts, "mPrompts");
        Intrinsics.checkNotNullParameter(mTensors, "mTensors");
        Intrinsics.checkNotNullParameter(mTokenIds, "mTokenIds");
        this.promptIDs = promptIDs;
        this.mPrompts = mPrompts;
        this.mTensors = mTensors;
        this.mTokenIds = mTokenIds;
    }

    public TaskIOTensor() {
        this((List<String>) CollectionsKt.emptyList(), (List<PromptTensor>) CollectionsKt.emptyList(), (List<ImageTensor>) CollectionsKt.emptyList(), (List<Integer>) CollectionsKt.emptyList());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TaskIOTensor(@NotNull List<PromptTensor> mPrompts) {
        this((List<String>) CollectionsKt.emptyList(), mPrompts, (List<ImageTensor>) CollectionsKt.emptyList(), (List<Integer>) CollectionsKt.emptyList());
        Intrinsics.checkNotNullParameter(mPrompts, "mPrompts");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TaskIOTensor(@NotNull List<String> promptIDs, @NotNull List<PromptTensor> mPrompts, @NotNull List<ImageTensor> mTensors) {
        this(promptIDs, mPrompts, mTensors, (List<Integer>) CollectionsKt.emptyList());
        Intrinsics.checkNotNullParameter(promptIDs, "promptIDs");
        Intrinsics.checkNotNullParameter(mPrompts, "mPrompts");
        Intrinsics.checkNotNullParameter(mTensors, "mTensors");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TaskIOTensor(@NotNull List<String> promptIDs, @NotNull List<ImageTensor> mTensors) {
        this(promptIDs, (List<PromptTensor>) CollectionsKt.emptyList(), mTensors, (List<Integer>) CollectionsKt.emptyList());
        Intrinsics.checkNotNullParameter(promptIDs, "promptIDs");
        Intrinsics.checkNotNullParameter(mTensors, "mTensors");
    }

    public /* synthetic */ TaskIOTensor(List list, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((List<Integer>) list, (i & 2) != 0 ? "" : str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TaskIOTensor(@NotNull List<Integer> mTokenIds, @NotNull String dummy) {
        this((List<String>) CollectionsKt.emptyList(), (List<PromptTensor>) CollectionsKt.emptyList(), (List<ImageTensor>) CollectionsKt.emptyList(), mTokenIds);
        Intrinsics.checkNotNullParameter(mTokenIds, "mTokenIds");
        Intrinsics.checkNotNullParameter(dummy, "dummy");
    }

    private TaskIOTensor(Parcel parcel) {
        List listCreateStringArrayList = parcel.createStringArrayList();
        listCreateStringArrayList = listCreateStringArrayList == null ? CollectionsKt.emptyList() : listCreateStringArrayList;
        List listCreateTypedArrayList = parcel.createTypedArrayList(PromptTensor.CREATOR);
        listCreateTypedArrayList = listCreateTypedArrayList == null ? CollectionsKt.emptyList() : listCreateTypedArrayList;
        List listCreateTypedArrayList2 = parcel.createTypedArrayList(ImageTensor.CREATOR);
        listCreateTypedArrayList2 = listCreateTypedArrayList2 == null ? CollectionsKt.emptyList() : listCreateTypedArrayList2;
        ArrayList arrayList = new ArrayList();
        parcel.readList(arrayList, Integer.TYPE.getClassLoader());
        Unit unit = Unit.INSTANCE;
        this((List<String>) listCreateStringArrayList, (List<PromptTensor>) listCreateTypedArrayList, (List<ImageTensor>) listCreateTypedArrayList2, arrayList);
    }
}
