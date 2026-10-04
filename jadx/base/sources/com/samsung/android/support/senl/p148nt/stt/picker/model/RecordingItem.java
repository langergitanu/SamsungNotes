package com.samsung.android.support.senl.p148nt.stt.picker.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 72\u00020\u0001:\u000267BG\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eB\t\b\u0016¢\u0006\u0004\b\r\u0010\u000fB\u0011\b\u0014\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\r\u0010\u0012J\b\u00101\u001a\u00020\nH\u0016J\u0018\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u00112\u0006\u00105\u001a\u00020\nH\u0016R\u001a\u0010\u0013\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\u001a\u0010 \u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0015\"\u0004\b\"\u0010\u0017R\u001a\u0010#\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001a\"\u0004\b.\u0010\u001cR\u001a\u0010/\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010)\"\u0004\b0\u0010+¨\u00068"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/picker/model/RecordingItem;", "Landroid/os/Parcelable;", "mMediaId", "", "mPath", "", "mAlbum", "mDate", "mTitle", "mSize", "", "mIsInternalPath", "", "<init>", "(JLjava/lang/String;Ljava/lang/String;JLjava/lang/String;IZ)V", "()V", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "mediaId", "getMediaId", "()J", "setMediaId", "(J)V", "path", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "title", DynamicActionBarProvider.METHOD_GET_DATA, "setTitle", "date", "getDate", "setDate", "size", "getSize", "()I", "setSize", "(I)V", "isSelected", "()Z", "setSelected", "(Z)V", "album", "getAlbum", "setAlbum", "isInternalPath", "setInternalPath", "describeContents", "writeToParcel", "", "dest", "flags", "RecordingMode", "Companion", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class RecordingItem implements Parcelable {

    @Nullable
    private String album;
    private long date;
    private boolean isInternalPath;
    private boolean isSelected;
    private long mediaId;

    @Nullable
    private String path;
    private int size;

    @Nullable
    private String title;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<RecordingItem> CREATOR = new Parcelable.Creator<RecordingItem>() { // from class: com.samsung.android.support.senl.nt.stt.picker.model.RecordingItem$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RecordingItem createFromParcel(Parcel in) {
            Intrinsics.checkNotNullParameter(in, "in");
            return new RecordingItem(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RecordingItem[] newArray(int size) {
            return new RecordingItem[size];
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/picker/model/RecordingItem$RecordingMode;", "", "<init>", "()V", "NOTES", "", "CALL", "VOICE_RECORDER", "SEARCH_RECORDER", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class RecordingMode {
        public static final int CALL = 1;

        @NotNull
        public static final RecordingMode INSTANCE = new RecordingMode();
        public static final int NOTES = 0;
        public static final int SEARCH_RECORDER = 3;
        public static final int VOICE_RECORDER = 2;

        private RecordingMode() {
        }
    }

    public RecordingItem(long j, @Nullable String str, @Nullable String str2, long j2, @Nullable String str3, int i, boolean z) {
        this.mediaId = j;
        this.path = str;
        this.title = str3;
        this.date = j2;
        this.size = i;
        this.album = str2;
        this.isInternalPath = z;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final String getAlbum() {
        return this.album;
    }

    public final long getDate() {
        return this.date;
    }

    public final long getMediaId() {
        return this.mediaId;
    }

    @Nullable
    public final String getPath() {
        return this.path;
    }

    public final int getSize() {
        return this.size;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: isInternalPath, reason: from getter */
    public final boolean getIsInternalPath() {
        return this.isInternalPath;
    }

    /* JADX INFO: renamed from: isSelected, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    public final void setAlbum(@Nullable String str) {
        this.album = str;
    }

    public final void setDate(long j) {
        this.date = j;
    }

    public final void setInternalPath(boolean z) {
        this.isInternalPath = z;
    }

    public final void setMediaId(long j) {
        this.mediaId = j;
    }

    public final void setPath(@Nullable String str) {
        this.path = str;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    public final void setSize(int i) {
        this.size = i;
    }

    public final void setTitle(@Nullable String str) {
        this.title = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeLong(this.mediaId);
        dest.writeString(this.path);
        dest.writeString(this.title);
        dest.writeLong(this.date);
        dest.writeInt(this.size);
        dest.writeByte(this.isSelected ? (byte) 1 : (byte) 0);
        dest.writeString(this.album);
        dest.writeByte(this.isInternalPath ? (byte) 1 : (byte) 0);
    }

    public RecordingItem() {
    }

    public RecordingItem(@NotNull Parcel in) {
        Intrinsics.checkNotNullParameter(in, "in");
        this.mediaId = in.readLong();
        this.path = in.readString();
        this.title = in.readString();
        this.date = in.readLong();
        this.size = in.readInt();
        this.isSelected = in.readByte() != 0;
        this.album = in.readString();
        this.isInternalPath = in.readByte() != 0;
    }
}
