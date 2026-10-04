package com.samsung.android.support.senl.p148nt.data.database.core.sync.entity;

import androidx.compose.runtime.AbstractC1974b;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.samsung.android.support.senl.p148nt.base.common.constants.DataBaseConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.SyncDBSchema;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Entity(tableName = SyncDBSchema.SyncFolderInfo.TABLE_NAME)
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/data/database/core/sync/entity/SyncFolderInfoEntity;", "", "uuid", "", "deletedBy", "", "<init>", "(Ljava/lang/String;I)V", "getUuid", "()Ljava/lang/String;", "setUuid", "(Ljava/lang/String;)V", "getDeletedBy", "()I", "setDeletedBy", "(I)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "ntData_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final /* data */ class SyncFolderInfoEntity {

    @ColumnInfo(defaultValue = "0", name = "deletedBy")
    private int deletedBy;

    @PrimaryKey
    @ColumnInfo(name = "UUID")
    @NotNull
    private String uuid;

    /* JADX WARN: Multi-variable type inference failed */
    public SyncFolderInfoEntity() {
        this(null, 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SyncFolderInfoEntity copy$default(SyncFolderInfoEntity syncFolderInfoEntity, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = syncFolderInfoEntity.uuid;
        }
        if ((i2 & 2) != 0) {
            i = syncFolderInfoEntity.deletedBy;
        }
        return syncFolderInfoEntity.copy(str, i);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUuid() {
        return this.uuid;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getDeletedBy() {
        return this.deletedBy;
    }

    @NotNull
    public final SyncFolderInfoEntity copy(@NotNull String uuid, @DataBaseConstants.DeletedBy int deletedBy) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        return new SyncFolderInfoEntity(uuid, deletedBy);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SyncFolderInfoEntity)) {
            return false;
        }
        SyncFolderInfoEntity syncFolderInfoEntity = (SyncFolderInfoEntity) other;
        return Intrinsics.areEqual(this.uuid, syncFolderInfoEntity.uuid) && this.deletedBy == syncFolderInfoEntity.deletedBy;
    }

    public final int getDeletedBy() {
        return this.deletedBy;
    }

    @NotNull
    public final String getUuid() {
        return this.uuid;
    }

    public int hashCode() {
        return Integer.hashCode(this.deletedBy) + (this.uuid.hashCode() * 31);
    }

    public final void setDeletedBy(int i) {
        this.deletedBy = i;
    }

    public final void setUuid(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.uuid = str;
    }

    @NotNull
    public String toString() {
        return AbstractC1974b.m1319l("SyncFolderInfoEntity(uuid=", this.deletedBy, this.uuid, ", deletedBy=", ")");
    }

    public SyncFolderInfoEntity(@NotNull String uuid, @DataBaseConstants.DeletedBy int i) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        this.uuid = uuid;
        this.deletedBy = i;
    }

    public /* synthetic */ SyncFolderInfoEntity(String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? 0 : i);
    }
}
