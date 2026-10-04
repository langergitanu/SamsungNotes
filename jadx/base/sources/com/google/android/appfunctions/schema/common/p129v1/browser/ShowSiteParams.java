package com.google.android.appfunctions.schema.common.p129v1.browser;

import androidx.appsearch.annotation.Document;
import com.google.android.appfunctions.schema.common.p129v1.types.Uri;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Document(name = C$$__AppSearch__ShowSiteParams.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u0010\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/browser/ShowSiteParams;", "", "namespace", "", "id", "url", "Lcom/google/android/appfunctions/schema/common/v1/types/Uri;", "shouldShowInNewTab", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/google/android/appfunctions/schema/common/v1/types/Uri;Z)V", "getNamespace", "()Ljava/lang/String;", "getId", "getUrl", "()Lcom/google/android/appfunctions/schema/common/v1/types/Uri;", "equals", "other", "hashCode", "", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class ShowSiteParams {

    @Document.InterfaceC0555Id
    @NotNull
    private final String id;

    @Document.Namespace
    @NotNull
    private final String namespace;

    @Document.BooleanProperty(required = true)
    @JvmField
    public final boolean shouldShowInNewTab;

    @Document.DocumentProperty(required = true)
    @NotNull
    private final Uri url;

    public ShowSiteParams(@NotNull String namespace, @NotNull String id, @NotNull Uri url, boolean z) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(url, "url");
        this.namespace = namespace;
        this.id = id;
        this.url = url;
        this.shouldShowInNewTab = z;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof ShowSiteParams)) {
            return false;
        }
        ShowSiteParams showSiteParams = (ShowSiteParams) other;
        return Intrinsics.areEqual(this.url, showSiteParams.url) && this.shouldShowInNewTab == showSiteParams.shouldShowInNewTab;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getNamespace() {
        return this.namespace;
    }

    @NotNull
    public final Uri getUrl() {
        return this.url;
    }

    public int hashCode() {
        return Objects.hash(this.url, Boolean.valueOf(this.shouldShowInNewTab));
    }

    public /* synthetic */ ShowSiteParams(String str, String str2, Uri uri, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, uri, z);
    }
}
