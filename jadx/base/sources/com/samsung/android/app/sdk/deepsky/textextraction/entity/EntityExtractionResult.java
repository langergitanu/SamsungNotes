package com.samsung.android.app.sdk.deepsky.textextraction.entity;

import androidx.collection.AbstractC0622a;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/entity/EntityExtractionResult;", "", "id", "", "items", "", "Lcom/samsung/android/app/sdk/deepsky/textextraction/entity/EntityItem;", "languageTags", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getItems", "()Ljava/util/List;", "getLanguageTags", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final /* data */ class EntityExtractionResult {

    @NotNull
    private final String id;

    @NotNull
    private final List<EntityItem> items;

    @NotNull
    private final String languageTags;

    public EntityExtractionResult(@NotNull String id, @NotNull List<EntityItem> items, @NotNull String languageTags) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(languageTags, "languageTags");
        this.id = id;
        this.items = items;
        this.languageTags = languageTags;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EntityExtractionResult copy$default(EntityExtractionResult entityExtractionResult, String str, List list, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = entityExtractionResult.id;
        }
        if ((i & 2) != 0) {
            list = entityExtractionResult.items;
        }
        if ((i & 4) != 0) {
            str2 = entityExtractionResult.languageTags;
        }
        return entityExtractionResult.copy(str, list, str2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final List<EntityItem> component2() {
        return this.items;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLanguageTags() {
        return this.languageTags;
    }

    @NotNull
    public final EntityExtractionResult copy(@NotNull String id, @NotNull List<EntityItem> items, @NotNull String languageTags) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(languageTags, "languageTags");
        return new EntityExtractionResult(id, items, languageTags);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EntityExtractionResult)) {
            return false;
        }
        EntityExtractionResult entityExtractionResult = (EntityExtractionResult) other;
        return Intrinsics.areEqual(this.id, entityExtractionResult.id) && Intrinsics.areEqual(this.items, entityExtractionResult.items) && Intrinsics.areEqual(this.languageTags, entityExtractionResult.languageTags);
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final List<EntityItem> getItems() {
        return this.items;
    }

    @NotNull
    public final String getLanguageTags() {
        return this.languageTags;
    }

    public int hashCode() {
        return this.languageTags.hashCode() + AbstractC0622a.m1159e(this.items, this.id.hashCode() * 31, 31);
    }

    @NotNull
    public String toString() {
        String str = this.id;
        List<EntityItem> list = this.items;
        String str2 = this.languageTags;
        StringBuilder sb = new StringBuilder("EntityExtractionResult(id=");
        sb.append(str);
        sb.append(", items=");
        sb.append(list);
        sb.append(", languageTags=");
        return AbstractC0622a.m1170p(str2, ")", sb);
    }

    public /* synthetic */ EntityExtractionResult(String str, List list, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, list, (i & 4) != 0 ? "" : str2);
    }
}
