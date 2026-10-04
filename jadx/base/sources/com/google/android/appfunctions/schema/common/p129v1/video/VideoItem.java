package com.google.android.appfunctions.schema.common.p129v1.video;

import androidx.appsearch.annotation.Document;
import com.google.android.appfunctions.schema.common.p129v1.types.Uri;
import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
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
@Document(name = C$$__AppSearch__VideoItem.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010%\u001a\u00020\u000bH\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0016\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014¨\u0006&"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/video/VideoItem;", "", "namespace", "", "id", "title", "durationInSecond", "", ExternalDataConstants.Column.THUMBNAIL_URI, "Lcom/google/android/appfunctions/schema/common/v1/types/Uri;", "thumbnailWidth", "", "thumbnailHeight", "categories", "", "attributionText", "transcriptId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLcom/google/android/appfunctions/schema/common/v1/types/Uri;IILjava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getNamespace", "()Ljava/lang/String;", "getId", DynamicActionBarProvider.METHOD_GET_DATA, "getDurationInSecond", "()J", "getThumbnailUri", "()Lcom/google/android/appfunctions/schema/common/v1/types/Uri;", "getThumbnailWidth", "()I", "getThumbnailHeight", "getCategories", "()Ljava/util/List;", "getAttributionText", "getTranscriptId", "equals", "", "other", "hashCode", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class VideoItem {

    @Document.StringProperty(required = true)
    @NotNull
    private final String attributionText;

    @Document.StringProperty
    @NotNull
    private final List<String> categories;

    @Document.LongProperty(required = true)
    private final long durationInSecond;

    @Document.InterfaceC0555Id
    @NotNull
    private final String id;

    @Document.Namespace
    @NotNull
    private final String namespace;

    @Document.LongProperty(required = true)
    private final int thumbnailHeight;

    @Document.DocumentProperty(required = true)
    @NotNull
    private final Uri thumbnailUri;

    @Document.LongProperty(required = true)
    private final int thumbnailWidth;

    @Document.StringProperty(required = true)
    @NotNull
    private final String title;

    @Document.StringProperty(required = true)
    @NotNull
    private final String transcriptId;

    public VideoItem(@NotNull String namespace, @NotNull String id, @NotNull String title, long j, @NotNull Uri thumbnailUri, int i, int i2, @NotNull List<String> categories, @NotNull String attributionText, @NotNull String transcriptId) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(thumbnailUri, "thumbnailUri");
        Intrinsics.checkNotNullParameter(categories, "categories");
        Intrinsics.checkNotNullParameter(attributionText, "attributionText");
        Intrinsics.checkNotNullParameter(transcriptId, "transcriptId");
        this.namespace = namespace;
        this.id = id;
        this.title = title;
        this.durationInSecond = j;
        this.thumbnailUri = thumbnailUri;
        this.thumbnailWidth = i;
        this.thumbnailHeight = i2;
        this.categories = categories;
        this.attributionText = attributionText;
        this.transcriptId = transcriptId;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof VideoItem)) {
            return false;
        }
        VideoItem videoItem = (VideoItem) other;
        return Intrinsics.areEqual(this.id, videoItem.id) && Intrinsics.areEqual(this.title, videoItem.title) && this.durationInSecond == videoItem.durationInSecond && Intrinsics.areEqual(this.thumbnailUri, videoItem.thumbnailUri) && this.thumbnailWidth == videoItem.thumbnailWidth && this.thumbnailHeight == videoItem.thumbnailHeight && Intrinsics.areEqual(this.categories, videoItem.categories) && Intrinsics.areEqual(this.attributionText, videoItem.attributionText) && Intrinsics.areEqual(this.transcriptId, videoItem.transcriptId);
    }

    @NotNull
    public final String getAttributionText() {
        return this.attributionText;
    }

    @NotNull
    public final List<String> getCategories() {
        return this.categories;
    }

    public final long getDurationInSecond() {
        return this.durationInSecond;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getNamespace() {
        return this.namespace;
    }

    public final int getThumbnailHeight() {
        return this.thumbnailHeight;
    }

    @NotNull
    public final Uri getThumbnailUri() {
        return this.thumbnailUri;
    }

    public final int getThumbnailWidth() {
        return this.thumbnailWidth;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getTranscriptId() {
        return this.transcriptId;
    }

    public int hashCode() {
        return Objects.hash(this.id, this.title, Long.valueOf(this.durationInSecond), this.thumbnailUri, Integer.valueOf(this.thumbnailWidth), Integer.valueOf(this.thumbnailHeight), this.categories, this.attributionText, this.transcriptId);
    }

    public /* synthetic */ VideoItem(String str, String str2, String str3, long j, Uri uri, int i, int i2, List list, String str4, String str5, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? "" : str, str2, str3, j, uri, i, i2, (i4 & 128) != 0 ? CollectionsKt.emptyList() : list, str4, str5);
    }
}
