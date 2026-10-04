package com.samsung.android.core.p139ai.sdkcommon;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0012\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/core/ai/sdkcommon/ModelInfo;", "Landroid/os/Parcelable;", "modelConfigJson", "Lorg/json/JSONObject;", "<init>", "(Lorg/json/JSONObject;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getModelConfigJson", "()Lorg/json/JSONObject;", "writeToParcel", "", "flags", "", "describeContents", "equals", "", "other", "", "hashCode", "component1", "copy", "toString", "", "Companion", "scs-ai-4.0.55_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final /* data */ class ModelInfo implements Parcelable {

    @NotNull
    private final JSONObject modelConfigJson;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<ModelInfo> CREATOR = new Parcelable.Creator<ModelInfo>() { // from class: com.samsung.android.core.ai.sdkcommon.ModelInfo$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ModelInfo createFromParcel(Parcel source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return new ModelInfo(source, null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ModelInfo[] newArray(int size) {
            return new ModelInfo[size];
        }
    };

    public /* synthetic */ ModelInfo(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    public static /* synthetic */ ModelInfo copy$default(ModelInfo modelInfo, JSONObject jSONObject, int i, Object obj) {
        if ((i & 1) != 0) {
            jSONObject = modelInfo.modelConfigJson;
        }
        return modelInfo.copy(jSONObject);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final JSONObject getModelConfigJson() {
        return this.modelConfigJson;
    }

    @NotNull
    public final ModelInfo copy(@NotNull JSONObject modelConfigJson) {
        Intrinsics.checkNotNullParameter(modelConfigJson, "modelConfigJson");
        return new ModelInfo(modelConfigJson);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ModelInfo) {
            return Intrinsics.areEqual(this.modelConfigJson.toString(), ((ModelInfo) other).modelConfigJson.toString());
        }
        return false;
    }

    @NotNull
    public final JSONObject getModelConfigJson() {
        return this.modelConfigJson;
    }

    public int hashCode() {
        return this.modelConfigJson.toString().hashCode();
    }

    @NotNull
    public String toString() {
        return "ModelInfo(modelConfigJson=" + this.modelConfigJson + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.modelConfigJson.toString());
    }

    public ModelInfo(@NotNull JSONObject modelConfigJson) {
        Intrinsics.checkNotNullParameter(modelConfigJson, "modelConfigJson");
        this.modelConfigJson = modelConfigJson;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private ModelInfo(Parcel parcel) {
        String string = parcel.readString();
        this(new JSONObject(string == null ? "{}" : string));
    }
}
