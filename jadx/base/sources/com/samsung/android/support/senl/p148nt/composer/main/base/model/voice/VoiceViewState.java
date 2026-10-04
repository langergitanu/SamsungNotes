package com.samsung.android.support.senl.p148nt.composer.main.base.model.voice;

import android.os.Parcel;
import android.os.Parcelable;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u0000 !2\u00020\u0001:\u0002 !B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0002\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u001e\u001a\u00020\u0015J\u0006\u0010\u001f\u001a\u00020\u0015R\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u0006R\u0011\u0010\u0017\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\u001a\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\u001b\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0018R\u0011\u0010\u001c\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0018R\u0011\u0010\u001d\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0018¨\u0006\""}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/model/voice/VoiceViewState;", "Landroid/os/Parcelable;", "<init>", "()V", "state", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/voice/VoiceViewState$Type;", "(Lcom/samsung/android/support/senl/nt/composer/main/base/model/voice/VoiceViewState$Type;)V", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "type", "getType", "()Lcom/samsung/android/support/senl/nt/composer/main/base/model/voice/VoiceViewState$Type;", "setType", "describeContents", "", "writeToParcel", "", "dest", "flags", "canHideState", "", "canCollapseStraight", "isVisibleState", "()Z", "isHideState", "isShowingRecordingState", "isRecordState", "isMinimized", "isInitState", "isNormalPlayState", "canUpdateRecordingTime", PackageRelationship.TYPE_ATTRIBUTE_NAME, "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class VoiceViewState implements Parcelable {

    @NotNull
    private Type type;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<VoiceViewState> CREATOR = new Parcelable.Creator<VoiceViewState>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.model.voice.VoiceViewState$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VoiceViewState createFromParcel(Parcel in) {
            Intrinsics.checkNotNullParameter(in, "in");
            return new VoiceViewState(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VoiceViewState[] newArray(int size) {
            return new VoiceViewState[size];
        }
    };

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/model/voice/VoiceViewState$Type;", "", "<init>", "(Ljava/lang/String;I)V", CoverStickerConstants.Category.NONE.NAME, "HIDE", "VOICEINIT", "VOICEINIT_MINIMIZED", "RECORD", "RECORD_MINIMIZED", "EXTEND", "LIST", "EDIT", "NORMAL_PLAY", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Type {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Type[] $VALUES;
        public static final Type NONE = new Type(CoverStickerConstants.Category.NONE.NAME, 0);
        public static final Type HIDE = new Type("HIDE", 1);
        public static final Type VOICEINIT = new Type("VOICEINIT", 2);
        public static final Type VOICEINIT_MINIMIZED = new Type("VOICEINIT_MINIMIZED", 3);
        public static final Type RECORD = new Type("RECORD", 4);
        public static final Type RECORD_MINIMIZED = new Type("RECORD_MINIMIZED", 5);
        public static final Type EXTEND = new Type("EXTEND", 6);
        public static final Type LIST = new Type("LIST", 7);
        public static final Type EDIT = new Type("EDIT", 8);
        public static final Type NORMAL_PLAY = new Type("NORMAL_PLAY", 9);

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{NONE, HIDE, VOICEINIT, VOICEINIT_MINIMIZED, RECORD, RECORD_MINIMIZED, EXTEND, LIST, EDIT, NORMAL_PLAY};
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

    public VoiceViewState() {
        this.type = Type.NONE;
    }

    public final boolean canCollapseStraight() {
        Type type = this.type;
        return type == Type.LIST || type == Type.EDIT || type == Type.NORMAL_PLAY;
    }

    public final boolean canHideState() {
        Type type = this.type;
        return type == Type.EXTEND || type == Type.LIST || type == Type.EDIT || type == Type.NORMAL_PLAY;
    }

    public final boolean canUpdateRecordingTime() {
        return isInitState() || isRecordState();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final Type getType() {
        return this.type;
    }

    public final boolean isHideState() {
        return this.type == Type.HIDE;
    }

    public final boolean isInitState() {
        Type type = this.type;
        return type == Type.VOICEINIT || type == Type.VOICEINIT_MINIMIZED;
    }

    public final boolean isMinimized() {
        Type type = this.type;
        return type == Type.VOICEINIT_MINIMIZED || type == Type.RECORD_MINIMIZED;
    }

    public final boolean isNormalPlayState() {
        return this.type == Type.NORMAL_PLAY;
    }

    public final boolean isRecordState() {
        Type type = this.type;
        return type == Type.RECORD || type == Type.RECORD_MINIMIZED;
    }

    public final boolean isShowingRecordingState() {
        Type type = this.type;
        return type == Type.EXTEND || type == Type.LIST || type == Type.EDIT;
    }

    public final boolean isVisibleState() {
        Type type = this.type;
        return (type == Type.NONE || type == Type.HIDE) ? false : true;
    }

    public final void setType(@NotNull Type type) {
        Intrinsics.checkNotNullParameter(type, "<set-?>");
        this.type = type;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(this.type.ordinal());
    }

    public VoiceViewState(@NotNull Type state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.type = state;
    }

    public VoiceViewState(@NotNull Parcel in) {
        Intrinsics.checkNotNullParameter(in, "in");
        this.type = Type.getEntries().get(in.readInt());
    }
}
