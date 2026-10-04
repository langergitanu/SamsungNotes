package com.samsung.android.support.senl.p148nt.data.database.core.document.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Entity(foreignKeys = {@ForeignKey(childColumns = {"UUID"}, entity = NotesDocumentEntity.class, onDelete = 5, parentColumns = {"UUID"})}, tableName = DBSchema.ExternalSharedDocument.TABLE_NAME)
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/data/database/core/document/entity/ExternalSharedDocumentEntity;", "", "uuid", "", "timestamp", "", "<init>", "(Ljava/lang/String;J)V", "getUuid", "()Ljava/lang/String;", "setUuid", "(Ljava/lang/String;)V", "getTimestamp", "()J", "setTimestamp", "(J)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ntData_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final /* data */ class ExternalSharedDocumentEntity {

    @ColumnInfo(defaultValue = "0", name = "timestamp")
    private long timestamp;

    @PrimaryKey
    @ColumnInfo(name = "UUID")
    @NotNull
    private String uuid;

    public ExternalSharedDocumentEntity() {
        this(null, 0L, 3, null);
    }

    public static /* synthetic */ ExternalSharedDocumentEntity copy$default(ExternalSharedDocumentEntity externalSharedDocumentEntity, String str, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = externalSharedDocumentEntity.uuid;
        }
        if ((i & 2) != 0) {
            j = externalSharedDocumentEntity.timestamp;
        }
        return externalSharedDocumentEntity.copy(str, j);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUuid() {
        return this.uuid;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    @NotNull
    public final ExternalSharedDocumentEntity copy(@NotNull String uuid, long timestamp) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        return new ExternalSharedDocumentEntity(uuid, timestamp);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExternalSharedDocumentEntity)) {
            return false;
        }
        ExternalSharedDocumentEntity externalSharedDocumentEntity = (ExternalSharedDocumentEntity) other;
        return Intrinsics.areEqual(this.uuid, externalSharedDocumentEntity.uuid) && this.timestamp == externalSharedDocumentEntity.timestamp;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    @NotNull
    public final String getUuid() {
        return this.uuid;
    }

    public int hashCode() {
        return Long.hashCode(this.timestamp) + (this.uuid.hashCode() * 31);
    }

    public final void setTimestamp(long j) {
        this.timestamp = j;
    }

    public final void setUuid(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.uuid = str;
    }

    @NotNull
    public String toString() {
        return "ExternalSharedDocumentEntity(uuid=" + this.uuid + ", timestamp=" + this.timestamp + ")";
    }

    public ExternalSharedDocumentEntity(@NotNull String uuid, long j) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        this.uuid = uuid;
        this.timestamp = j;
    }

    public /* synthetic */ ExternalSharedDocumentEntity(String str, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? 0L : j);
    }
}
