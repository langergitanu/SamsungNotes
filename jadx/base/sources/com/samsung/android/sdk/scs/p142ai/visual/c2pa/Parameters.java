package com.samsung.android.sdk.scs.p142ai.visual.c2pa;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.glance.AbstractC2821a;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003JK\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/sdk/scs/ai/visual/c2pa/Parameters;", "", "ingredient", "Lcom/samsung/android/sdk/scs/ai/visual/c2pa/Ingredient;", "type", "", "version", "value", "author", "", "Lcom/samsung/android/sdk/scs/ai/visual/c2pa/Author;", "<init>", "(Lcom/samsung/android/sdk/scs/ai/visual/c2pa/Ingredient;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getIngredient", "()Lcom/samsung/android/sdk/scs/ai/visual/c2pa/Ingredient;", "getType", "()Ljava/lang/String;", "getVersion", "getValue", "getAuthor", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "scs-ai-4.0.55_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final /* data */ class Parameters {

    @Nullable
    private final List<Author> author;

    @Nullable
    private final Ingredient ingredient;

    @Nullable
    private final String type;

    @Nullable
    private final String value;

    @Nullable
    private final String version;

    public Parameters(@Nullable Ingredient ingredient, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable List<Author> list) {
        this.ingredient = ingredient;
        this.type = str;
        this.version = str2;
        this.value = str3;
        this.author = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Parameters copy$default(Parameters parameters, Ingredient ingredient, String str, String str2, String str3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            ingredient = parameters.ingredient;
        }
        if ((i & 2) != 0) {
            str = parameters.type;
        }
        if ((i & 4) != 0) {
            str2 = parameters.version;
        }
        if ((i & 8) != 0) {
            str3 = parameters.value;
        }
        if ((i & 16) != 0) {
            list = parameters.author;
        }
        List list2 = list;
        String str4 = str2;
        return parameters.copy(ingredient, str, str4, str3, list2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Ingredient getIngredient() {
        return this.ingredient;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    @Nullable
    public final List<Author> component5() {
        return this.author;
    }

    @NotNull
    public final Parameters copy(@Nullable Ingredient ingredient, @Nullable String type, @Nullable String version, @Nullable String value, @Nullable List<Author> author) {
        return new Parameters(ingredient, type, version, value, author);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Parameters)) {
            return false;
        }
        Parameters parameters = (Parameters) other;
        return Intrinsics.areEqual(this.ingredient, parameters.ingredient) && Intrinsics.areEqual(this.type, parameters.type) && Intrinsics.areEqual(this.version, parameters.version) && Intrinsics.areEqual(this.value, parameters.value) && Intrinsics.areEqual(this.author, parameters.author);
    }

    @Nullable
    public final List<Author> getAuthor() {
        return this.author;
    }

    @Nullable
    public final Ingredient getIngredient() {
        return this.ingredient;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    @Nullable
    public final String getValue() {
        return this.value;
    }

    @Nullable
    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        Ingredient ingredient = this.ingredient;
        int iHashCode = (ingredient == null ? 0 : ingredient.hashCode()) * 31;
        String str = this.type;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.version;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.value;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<Author> list = this.author;
        return iHashCode4 + (list != null ? list.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        Ingredient ingredient = this.ingredient;
        String str = this.type;
        String str2 = this.version;
        String str3 = this.value;
        List<Author> list = this.author;
        StringBuilder sb = new StringBuilder("Parameters(ingredient=");
        sb.append(ingredient);
        sb.append(", type=");
        sb.append(str);
        sb.append(", version=");
        AbstractC2821a.m2207B(sb, str2, ", value=", str3, ", author=");
        return AbstractC0541b.m777s(sb, list, ")");
    }
}
