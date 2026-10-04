package com.google.android.appfunctions.schema.common.p129v1.photos;

import androidx.appsearch.annotation.Document;
import com.google.android.appfunctions.schema.common.p129v1.types.DateTime;
import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
import com.samsung.scsp.common.Header;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Document(name = C$$__AppSearch__MediaItem.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001BY\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u001b\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010¨\u0006\u001f"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/photos/MediaItem;", "", "namespace", "", "id", "type", "dateCreated", "Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;", "title", "starred", "", Header.LOCATION, "albumId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "getNamespace", "()Ljava/lang/String;", "getId", "getType", "getDateCreated", "()Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;", DynamicActionBarProvider.METHOD_GET_DATA, "getStarred", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLocation", "getAlbumId", "equals", "other", "hashCode", "", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class MediaItem {

    @Document.StringProperty
    @Nullable
    private final String albumId;

    @Document.DocumentProperty(required = true)
    @NotNull
    private final DateTime dateCreated;

    @Document.InterfaceC0555Id
    @NotNull
    private final String id;

    @Document.StringProperty
    @Nullable
    private final String location;

    @Document.Namespace
    @NotNull
    private final String namespace;

    @Document.BooleanProperty
    @Nullable
    private final Boolean starred;

    @Document.StringProperty
    @Nullable
    private final String title;

    @Document.StringProperty(required = true)
    @NotNull
    private final String type;

    public MediaItem(@NotNull String namespace, @NotNull String id, @NotNull String type, @NotNull DateTime dateCreated, @Nullable String str, @Nullable Boolean bool, @Nullable String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(dateCreated, "dateCreated");
        this.namespace = namespace;
        this.id = id;
        this.type = type;
        this.dateCreated = dateCreated;
        this.title = str;
        this.starred = bool;
        this.location = str2;
        this.albumId = str3;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof MediaItem)) {
            return false;
        }
        MediaItem mediaItem = (MediaItem) other;
        return Intrinsics.areEqual(this.id, mediaItem.id) && Intrinsics.areEqual(this.type, mediaItem.type) && Intrinsics.areEqual(this.dateCreated, mediaItem.dateCreated) && Intrinsics.areEqual(this.title, mediaItem.title) && Intrinsics.areEqual(this.starred, mediaItem.starred) && Intrinsics.areEqual(this.location, mediaItem.location) && Intrinsics.areEqual(this.albumId, mediaItem.albumId);
    }

    @Nullable
    public final String getAlbumId() {
        return this.albumId;
    }

    @NotNull
    public final DateTime getDateCreated() {
        return this.dateCreated;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final String getLocation() {
        return this.location;
    }

    @NotNull
    public final String getNamespace() {
        return this.namespace;
    }

    @Nullable
    public final Boolean getStarred() {
        return this.starred;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return Objects.hash(this.id, this.type, this.dateCreated, this.title, this.starred, this.location, this.albumId);
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ MediaItem(java.lang.String r2, java.lang.String r3, java.lang.String r4, com.google.android.appfunctions.schema.common.p129v1.types.DateTime r5, java.lang.String r6, java.lang.Boolean r7, java.lang.String r8, java.lang.String r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r1 = this;
            r11 = r10 & 1
            if (r11 == 0) goto L6
            java.lang.String r2 = ""
        L6:
            r11 = r10 & 16
            r0 = 0
            if (r11 == 0) goto Lc
            r6 = r0
        Lc:
            r11 = r10 & 32
            if (r11 == 0) goto L11
            r7 = r0
        L11:
            r11 = r10 & 64
            if (r11 == 0) goto L16
            r8 = r0
        L16:
            r10 = r10 & 128(0x80, float:1.8E-43)
            if (r10 == 0) goto L24
            r11 = r0
            r9 = r7
            r10 = r8
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
            goto L2d
        L24:
            r11 = r9
            r10 = r8
            r8 = r6
            r9 = r7
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
        L2d:
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.appfunctions.schema.common.p129v1.photos.MediaItem.<init>(java.lang.String, java.lang.String, java.lang.String, com.google.android.appfunctions.schema.common.v1.types.DateTime, java.lang.String, java.lang.Boolean, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
