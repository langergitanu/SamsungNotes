package com.samsung.android.support.senl.p148nt.data.database.temp.domain.model;

import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.p148nt.base.common.constants.DataBaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0003\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\bHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/data/database/temp/domain/model/DeletedNote;", "", "id", "", "uuid", "", "filePath", "deletedBy", "", "<init>", "(JLjava/lang/String;Ljava/lang/String;I)V", "getId", "()J", "getUuid", "()Ljava/lang/String;", "getFilePath", "getDeletedBy", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "ntData_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final /* data */ class DeletedNote {
    private final int deletedBy;

    @NotNull
    private final String filePath;
    private final long id;

    @NotNull
    private final String uuid;

    public DeletedNote(long j, @NotNull String uuid, @NotNull String filePath, @DataBaseConstants.DeletedBy int i) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        this.id = j;
        this.uuid = uuid;
        this.filePath = filePath;
        this.deletedBy = i;
    }

    public static /* synthetic */ DeletedNote copy$default(DeletedNote deletedNote, long j, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = deletedNote.id;
        }
        long j2 = j;
        if ((i2 & 2) != 0) {
            str = deletedNote.uuid;
        }
        String str3 = str;
        if ((i2 & 4) != 0) {
            str2 = deletedNote.filePath;
        }
        String str4 = str2;
        if ((i2 & 8) != 0) {
            i = deletedNote.deletedBy;
        }
        return deletedNote.copy(j2, str3, str4, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUuid() {
        return this.uuid;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getFilePath() {
        return this.filePath;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getDeletedBy() {
        return this.deletedBy;
    }

    @NotNull
    public final DeletedNote copy(long id, @NotNull String uuid, @NotNull String filePath, @DataBaseConstants.DeletedBy int deletedBy) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        return new DeletedNote(id, uuid, filePath, deletedBy);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeletedNote)) {
            return false;
        }
        DeletedNote deletedNote = (DeletedNote) other;
        return this.id == deletedNote.id && Intrinsics.areEqual(this.uuid, deletedNote.uuid) && Intrinsics.areEqual(this.filePath, deletedNote.filePath) && this.deletedBy == deletedNote.deletedBy;
    }

    public final int getDeletedBy() {
        return this.deletedBy;
    }

    @NotNull
    public final String getFilePath() {
        return this.filePath;
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public final String getUuid() {
        return this.uuid;
    }

    public int hashCode() {
        return Integer.hashCode(this.deletedBy) + AbstractC1038a.m1202c(AbstractC1038a.m1202c(Long.hashCode(this.id) * 31, 31, this.uuid), 31, this.filePath);
    }

    @NotNull
    public String toString() {
        long j = this.id;
        String str = this.uuid;
        String str2 = this.filePath;
        int i = this.deletedBy;
        StringBuilder sbM2225p = AbstractC2821a.m2225p(j, "DeletedNote(id=", ", uuid=", str);
        sbM2225p.append(", filePath=");
        sbM2225p.append(str2);
        sbM2225p.append(", deletedBy=");
        sbM2225p.append(i);
        sbM2225p.append(")");
        return sbM2225p.toString();
    }
}
