package com.samsung.android.support.senl.p148nt.base.common.access.sync.importer.data;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 #2\u00020\u0001:\u0001#B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006B%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u0019\u001a\u00020\u001a2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003J\u0006\u0010\u001b\u001a\u00020\u0003J\u0012\u0010\u001c\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010\u001d\u001a\u00020\u0003H\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0018\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u001fH\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006$"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/access/sync/importer/data/ImportDocument;", "Landroid/os/Parcelable;", "path", "", NotesConstants.KEY_FOLDER_UUID, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "isCoeditNote", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "uuid", "title", DynamicActionBarProvider.METHOD_GET_DATA, "setTitle", "()Z", "setCoeditNote", "(Z)V", "getUuid", "setUuid", "", "getFolderUuid", "getDefaultFolderUuid", "toString", "describeContents", "", "writeToParcel", "dest", "flags", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ImportDocument implements Parcelable {

    @NotNull
    private static final String DEFAULT_SDOCX_FOLDER_UUID = "uncategorized:///";

    @NotNull
    private static final String DEFAULT_SDOC_FOLDER_UUID = "1";

    @Nullable
    private final String folderUuid;
    private boolean isCoeditNote;

    @Nullable
    private String path;

    @Nullable
    private String title;

    @Nullable
    private String uuid;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<ImportDocument> CREATOR = new Parcelable.Creator<ImportDocument>() { // from class: com.samsung.android.support.senl.nt.base.common.access.sync.importer.data.ImportDocument$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ImportDocument createFromParcel(Parcel in) {
            Intrinsics.checkNotNullParameter(in, "in");
            return new ImportDocument(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ImportDocument[] newArray(int size) {
            return new ImportDocument[size];
        }
    };

    public ImportDocument(@Nullable String str, @Nullable String str2) {
        this.path = str;
        this.folderUuid = str2;
    }

    private final String getDefaultFolderUuid(String path) {
        return !TextUtils.isEmpty(path) ? (path == null || !StringsKt.m14167w(path, ".sdocx")) ? "1" : "uncategorized:///" : "uncategorized:///";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final String getFolderUuid() {
        return TextUtils.isEmpty(this.folderUuid) ? getDefaultFolderUuid(this.path) : String.valueOf(this.folderUuid);
    }

    @Nullable
    public final String getPath() {
        return this.path;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getUuid() {
        return this.uuid;
    }

    /* JADX INFO: renamed from: isCoeditNote, reason: from getter */
    public final boolean getIsCoeditNote() {
        return this.isCoeditNote;
    }

    public final void setCoeditNote(boolean z) {
        this.isCoeditNote = z;
    }

    public final void setPath(@Nullable String str) {
        this.path = str;
    }

    public final void setTitle(@Nullable String str) {
        this.title = str;
    }

    public final void setUuid(@Nullable String uuid) {
        this.uuid = uuid;
    }

    @NotNull
    public String toString() {
        String encode = Logger.getEncode(this.path);
        String str = this.folderUuid;
        String str2 = this.uuid;
        boolean z = this.isCoeditNote;
        StringBuilder sbM16m = AbstractC0000a.m16m("ImportDocument{path='", encode, "', folderUuid='", str, "', uuid='");
        sbM16m.append(str2);
        sbM16m.append("', isCoeditNote='");
        sbM16m.append(z);
        sbM16m.append("'}");
        return sbM16m.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.path);
        dest.writeString(this.folderUuid);
        dest.writeString(this.uuid);
        if (Build.VERSION.SDK_INT >= 29) {
            dest.writeBoolean(this.isCoeditNote);
        } else {
            dest.writeInt(this.isCoeditNote ? 1 : 0);
        }
    }

    public ImportDocument(@Nullable String str, @Nullable String str2, boolean z) {
        this.path = str;
        this.folderUuid = str2;
        this.isCoeditNote = z;
    }

    public ImportDocument(@NotNull Parcel in) {
        boolean z;
        Intrinsics.checkNotNullParameter(in, "in");
        this.path = in.readString();
        this.folderUuid = in.readString();
        this.uuid = in.readString();
        if (Build.VERSION.SDK_INT >= 29) {
            z = in.readBoolean();
        } else {
            z = in.readInt() == 1;
        }
        this.isCoeditNote = z;
    }
}
