package com.google.android.appfunctions.schema.common.p129v1.music;

import androidx.appsearch.annotation.Document;
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
@Document(name = C$$__AppSearch__CreatePersonalPlaylistParams.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/music/CreatePersonalPlaylistParams;", "", "namespace", "", "id", "title", "itemIds", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getNamespace", "()Ljava/lang/String;", "getId", DynamicActionBarProvider.METHOD_GET_DATA, "getItemIds", "()Ljava/util/List;", "equals", "", "other", "hashCode", "", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class CreatePersonalPlaylistParams {

    @Document.InterfaceC0555Id
    @NotNull
    private final String id;

    @Document.StringProperty
    @NotNull
    private final List<String> itemIds;

    @Document.Namespace
    @NotNull
    private final String namespace;

    @Document.StringProperty(required = true)
    @NotNull
    private final String title;

    public CreatePersonalPlaylistParams(@NotNull String namespace, @NotNull String id, @NotNull String title, @NotNull List<String> itemIds) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(itemIds, "itemIds");
        this.namespace = namespace;
        this.id = id;
        this.title = title;
        this.itemIds = itemIds;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof CreatePersonalPlaylistParams)) {
            return false;
        }
        CreatePersonalPlaylistParams createPersonalPlaylistParams = (CreatePersonalPlaylistParams) other;
        return Intrinsics.areEqual(this.title, createPersonalPlaylistParams.title) && Intrinsics.areEqual(this.itemIds, createPersonalPlaylistParams.itemIds);
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final List<String> getItemIds() {
        return this.itemIds;
    }

    @NotNull
    public final String getNamespace() {
        return this.namespace;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return Objects.hash(this.title, this.itemIds);
    }

    public /* synthetic */ CreatePersonalPlaylistParams(String str, String str2, String str3, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, str3, (i & 8) != 0 ? CollectionsKt.emptyList() : list);
    }
}
