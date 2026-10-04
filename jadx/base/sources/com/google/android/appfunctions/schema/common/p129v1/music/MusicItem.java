package com.google.android.appfunctions.schema.common.p129v1.music;

import androidx.appsearch.annotation.Document;
import com.google.android.appfunctions.schema.common.p129v1.types.Date;
import com.google.android.appfunctions.schema.common.p129v1.types.Uri;
import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Document(name = C$$__AppSearch__MusicItem.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\n¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010(\u001a\u00020)H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0015R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019R\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001c¨\u0006*"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/music/MusicItem;", "", "namespace", "", "id", "type", "deeplink", "Lcom/google/android/appfunctions/schema/common/v1/types/Uri;", "title", "artistNames", "", "publishDate", "Lcom/google/android/appfunctions/schema/common/v1/types/Date;", "lengthInSeconds", "", "description", "thumbnail", "childMusicItemIds", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/android/appfunctions/schema/common/v1/types/Uri;Ljava/lang/String;Ljava/util/List;Lcom/google/android/appfunctions/schema/common/v1/types/Date;Ljava/lang/Long;Ljava/lang/String;Lcom/google/android/appfunctions/schema/common/v1/types/Uri;Ljava/util/List;)V", "getNamespace", "()Ljava/lang/String;", "getId", "getType", "getDeeplink", "()Lcom/google/android/appfunctions/schema/common/v1/types/Uri;", DynamicActionBarProvider.METHOD_GET_DATA, "getArtistNames", "()Ljava/util/List;", "getPublishDate", "()Lcom/google/android/appfunctions/schema/common/v1/types/Date;", "getLengthInSeconds", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDescription", "getThumbnail", "getChildMusicItemIds", "equals", "", "other", "hashCode", "", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class MusicItem {

    @Document.StringProperty
    @NotNull
    private final List<String> artistNames;

    @Document.StringProperty
    @NotNull
    private final List<String> childMusicItemIds;

    @Document.DocumentProperty
    @Nullable
    private final Uri deeplink;

    @Document.StringProperty
    @Nullable
    private final String description;

    @Document.InterfaceC0555Id
    @NotNull
    private final String id;

    @Document.LongProperty
    @Nullable
    private final Long lengthInSeconds;

    @Document.Namespace
    @NotNull
    private final String namespace;

    @Document.DocumentProperty
    @Nullable
    private final Date publishDate;

    @Document.DocumentProperty
    @Nullable
    private final Uri thumbnail;

    @Document.StringProperty
    @Nullable
    private final String title;

    @Document.StringProperty(required = true)
    @NotNull
    private final String type;

    public MusicItem(@NotNull String namespace, @NotNull String id, @NotNull String type, @Nullable Uri uri, @Nullable String str, @NotNull List<String> artistNames, @Nullable Date date, @Nullable Long l, @Nullable String str2, @Nullable Uri uri2, @NotNull List<String> childMusicItemIds) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(artistNames, "artistNames");
        Intrinsics.checkNotNullParameter(childMusicItemIds, "childMusicItemIds");
        this.namespace = namespace;
        this.id = id;
        this.type = type;
        this.deeplink = uri;
        this.title = str;
        this.artistNames = artistNames;
        this.publishDate = date;
        this.lengthInSeconds = l;
        this.description = str2;
        this.thumbnail = uri2;
        this.childMusicItemIds = childMusicItemIds;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof MusicItem)) {
            return false;
        }
        MusicItem musicItem = (MusicItem) other;
        return Intrinsics.areEqual(this.id, musicItem.id) && Intrinsics.areEqual(this.type, musicItem.type) && Intrinsics.areEqual(this.deeplink, musicItem.deeplink) && Intrinsics.areEqual(this.title, musicItem.title) && Intrinsics.areEqual(this.artistNames, musicItem.artistNames) && Intrinsics.areEqual(this.publishDate, musicItem.publishDate) && Intrinsics.areEqual(this.lengthInSeconds, musicItem.lengthInSeconds) && Intrinsics.areEqual(this.description, musicItem.description) && Intrinsics.areEqual(this.thumbnail, musicItem.thumbnail) && Intrinsics.areEqual(this.childMusicItemIds, musicItem.childMusicItemIds);
    }

    @NotNull
    public final List<String> getArtistNames() {
        return this.artistNames;
    }

    @NotNull
    public final List<String> getChildMusicItemIds() {
        return this.childMusicItemIds;
    }

    @Nullable
    public final Uri getDeeplink() {
        return this.deeplink;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final Long getLengthInSeconds() {
        return this.lengthInSeconds;
    }

    @NotNull
    public final String getNamespace() {
        return this.namespace;
    }

    @Nullable
    public final Date getPublishDate() {
        return this.publishDate;
    }

    @Nullable
    public final Uri getThumbnail() {
        return this.thumbnail;
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
        return Objects.hash(this.id, this.type, this.deeplink, this.title, this.artistNames, this.publishDate, this.lengthInSeconds, this.description, this.thumbnail, this.childMusicItemIds);
    }

    public /* synthetic */ MusicItem(String str, String str2, String str3, Uri uri, String str4, List list, Date date, Long l, String str5, Uri uri2, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, str2, str3, (i & 8) != 0 ? null : uri, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? CollectionsKt.emptyList() : list, (i & 64) != 0 ? null : date, (i & 128) != 0 ? null : l, (i & 256) != 0 ? null : str5, (i & 512) != 0 ? null : uri2, (i & 1024) != 0 ? CollectionsKt.emptyList() : list2);
    }
}
