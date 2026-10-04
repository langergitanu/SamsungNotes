package com.samsung.android.support.senl.p148nt.data.database.core.document.entity;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.runtime.AbstractC1974b;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import com.samsung.android.support.senl.p148nt.data.common.constants.DataConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Entity(foreignKeys = {@ForeignKey(childColumns = {"UUID"}, entity = NotesDocumentEntity.class, onDelete = 5, parentColumns = {"UUID"})}, tableName = DBSchema.DocumentThumbnail.TABLE_NAME)
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J;\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000e¨\u0006$"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/data/database/core/document/entity/DocumentThumbnailEntity;", "", "uuid", "", DBSchema.DocumentThumbnail.BACKGROUND_TYPE, "", DBSchema.DocumentThumbnail.LAYOUT, DBSchema.DocumentThumbnail.IMAGE_PATH, DBSchema.DocumentThumbnail.PLAY_TIME, "<init>", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;)V", "getUuid", "()Ljava/lang/String;", "setUuid", "(Ljava/lang/String;)V", "getBackgroundType", "()I", "setBackgroundType", "(I)V", "getLayout", "setLayout", "getImagePath", "setImagePath", "getPlayTime", "setPlayTime", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "ntData_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final /* data */ class DocumentThumbnailEntity {

    @ColumnInfo(defaultValue = "0", name = DBSchema.DocumentThumbnail.BACKGROUND_TYPE)
    private int backgroundType;

    @ColumnInfo(defaultValue = "", name = DBSchema.DocumentThumbnail.IMAGE_PATH)
    @NotNull
    private String imagePath;

    @ColumnInfo(defaultValue = "0", name = DBSchema.DocumentThumbnail.LAYOUT)
    private int layout;

    @ColumnInfo(defaultValue = "", name = DBSchema.DocumentThumbnail.PLAY_TIME)
    @NotNull
    private String playTime;

    @PrimaryKey
    @ColumnInfo(name = "UUID")
    @NotNull
    private String uuid;

    public DocumentThumbnailEntity(@NotNull String uuid, @DataConstants.PageBackgroundType int i, @DataConstants.Layout int i2, @NotNull String imagePath, @NotNull String playTime) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(imagePath, "imagePath");
        Intrinsics.checkNotNullParameter(playTime, "playTime");
        this.uuid = uuid;
        this.backgroundType = i;
        this.layout = i2;
        this.imagePath = imagePath;
        this.playTime = playTime;
    }

    public static /* synthetic */ DocumentThumbnailEntity copy$default(DocumentThumbnailEntity documentThumbnailEntity, String str, int i, int i2, String str2, String str3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = documentThumbnailEntity.uuid;
        }
        if ((i4 & 2) != 0) {
            i = documentThumbnailEntity.backgroundType;
        }
        if ((i4 & 4) != 0) {
            i2 = documentThumbnailEntity.layout;
        }
        if ((i4 & 8) != 0) {
            str2 = documentThumbnailEntity.imagePath;
        }
        if ((i4 & 16) != 0) {
            str3 = documentThumbnailEntity.playTime;
        }
        String str4 = str3;
        int i5 = i2;
        return documentThumbnailEntity.copy(str, i, i5, str2, str4);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUuid() {
        return this.uuid;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getBackgroundType() {
        return this.backgroundType;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getLayout() {
        return this.layout;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getImagePath() {
        return this.imagePath;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getPlayTime() {
        return this.playTime;
    }

    @NotNull
    public final DocumentThumbnailEntity copy(@NotNull String uuid, @DataConstants.PageBackgroundType int backgroundType, @DataConstants.Layout int layout, @NotNull String imagePath, @NotNull String playTime) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(imagePath, "imagePath");
        Intrinsics.checkNotNullParameter(playTime, "playTime");
        return new DocumentThumbnailEntity(uuid, backgroundType, layout, imagePath, playTime);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DocumentThumbnailEntity)) {
            return false;
        }
        DocumentThumbnailEntity documentThumbnailEntity = (DocumentThumbnailEntity) other;
        return Intrinsics.areEqual(this.uuid, documentThumbnailEntity.uuid) && this.backgroundType == documentThumbnailEntity.backgroundType && this.layout == documentThumbnailEntity.layout && Intrinsics.areEqual(this.imagePath, documentThumbnailEntity.imagePath) && Intrinsics.areEqual(this.playTime, documentThumbnailEntity.playTime);
    }

    public final int getBackgroundType() {
        return this.backgroundType;
    }

    @NotNull
    public final String getImagePath() {
        return this.imagePath;
    }

    public final int getLayout() {
        return this.layout;
    }

    @NotNull
    public final String getPlayTime() {
        return this.playTime;
    }

    @NotNull
    public final String getUuid() {
        return this.uuid;
    }

    public int hashCode() {
        return this.playTime.hashCode() + AbstractC1038a.m1202c(AbstractC0622a.m1157c(this.layout, AbstractC0622a.m1157c(this.backgroundType, this.uuid.hashCode() * 31, 31), 31), 31, this.imagePath);
    }

    public final void setBackgroundType(int i) {
        this.backgroundType = i;
    }

    public final void setImagePath(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.imagePath = str;
    }

    public final void setLayout(int i) {
        this.layout = i;
    }

    public final void setPlayTime(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.playTime = str;
    }

    public final void setUuid(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.uuid = str;
    }

    @NotNull
    public String toString() {
        String str = this.uuid;
        int i = this.backgroundType;
        int i2 = this.layout;
        String str2 = this.imagePath;
        String str3 = this.playTime;
        StringBuilder sbM780v = AbstractC0541b.m780v("DocumentThumbnailEntity(uuid=", i, str, ", backgroundType=", ", layout=");
        AbstractC1974b.m1331x(sbM780v, i2, ", imagePath=", str2, ", playTime=");
        return AbstractC0622a.m1170p(str3, ")", sbM780v);
    }

    public /* synthetic */ DocumentThumbnailEntity(String str, int i, int i2, String str2, String str3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i4 & 2) != 0 ? 0 : i, (i4 & 4) != 0 ? 0 : i2, (i4 & 8) != 0 ? "" : str2, (i4 & 16) != 0 ? "" : str3);
    }
}
