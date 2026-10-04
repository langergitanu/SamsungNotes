package com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.loadednote;

import android.os.Parcel;
import android.os.Parcelable;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u0001:\u0002\u0019\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005J\b\u0010\f\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0007J\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0007J\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0014H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/loadednote/LoadedNote;", "Landroid/os/Parcelable;", "<init>", "()V", "mLoadedNoteType", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/loadednote/LoadedNote$Type;", "mUuid", "", "mNotePath", "setLoadedNoteType", "", "type", "getLoadedNoteType", "setUuid", "uuid", "getUuid", "setNotePath", "path", "getNotePath", "describeContents", "", "writeToParcel", "parcel", "Landroid/os/Parcel;", "i", PackageRelationship.TYPE_ATTRIBUTE_NAME, "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class LoadedNote implements Parcelable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Parcelable.Creator<LoadedNote> CREATOR = new Parcelable.Creator<LoadedNote>() { // from class: com.samsung.android.support.senl.nt.composer.main.screenoff.model.loadednote.LoadedNote$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LoadedNote createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LoadedNote[] newArray(int i) {
            return new LoadedNote[0];
        }
    };

    @NotNull
    private Type mLoadedNoteType = Type.NONE;

    @NotNull
    private String mUuid = "";

    @NotNull
    private String mNotePath = "";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0019\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/loadednote/LoadedNote$Companion;", "", "<init>", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/loadednote/LoadedNote;", "getCREATOR", "()Landroid/os/Parcelable$Creator;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Parcelable.Creator<LoadedNote> getCREATOR() {
            return LoadedNote.CREATOR;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/loadednote/LoadedNote$Type;", "", "<init>", "(Ljava/lang/String;I)V", CoverStickerConstants.Category.NONE.NAME, "LOADED_BY_CACHE", "LOADED_BY_PIN", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Type {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Type[] $VALUES;
        public static final Type NONE = new Type(CoverStickerConstants.Category.NONE.NAME, 0);
        public static final Type LOADED_BY_CACHE = new Type("LOADED_BY_CACHE", 1);
        public static final Type LOADED_BY_PIN = new Type("LOADED_BY_PIN", 2);

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{NONE, LOADED_BY_CACHE, LOADED_BY_PIN};
        }

        static {
            Type[] typeArr$values = $values();
            $VALUES = typeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(typeArr$values);
        }

        private Type(String str, int i) {
        }

        @NotNull
        public static EnumEntries<Type> getEntries() {
            return $ENTRIES;
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    /* JADX INFO: renamed from: getLoadedNoteType, reason: from getter */
    public final Type getMLoadedNoteType() {
        return this.mLoadedNoteType;
    }

    @Nullable
    /* JADX INFO: renamed from: getNotePath, reason: from getter */
    public final String getMNotePath() {
        return this.mNotePath;
    }

    @Nullable
    /* JADX INFO: renamed from: getUuid, reason: from getter */
    public final String getMUuid() {
        return this.mUuid;
    }

    public final void setLoadedNoteType(@NotNull Type type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.mLoadedNoteType = type;
    }

    public final void setNotePath(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        this.mNotePath = path;
    }

    public final void setUuid(@NotNull String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        this.mUuid = uuid;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.mUuid);
        parcel.writeString(this.mNotePath);
    }
}
