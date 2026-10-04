package com.samsung.android.app.sdk.deepsky.suggestion.view;

import android.os.Bundle;
import androidx.collection.AbstractC0622a;
import com.samsung.android.app.sdk.deepsky.contract.suggestion.SuggestionItem;
import com.samsung.android.app.sdk.deepsky.contract.suggestion.view.SuggestionViewSpec;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\r\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\r\u0012\u0006\u0010\u000f\u001a\u00020\u0007¢\u0006\u0002\u0010\u0010J\t\u0010\u0011\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÂ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÂ\u0003J\t\u0010\u0014\u001a\u00020\tHÂ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u000bHÂ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\rHÂ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\rHÂ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÂ\u0003Jk\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\b\u0010\u001d\u001a\u00020\tH\u0016J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\rH\u0016J\n\u0010\u001f\u001a\u0004\u0018\u00010\u000bH\u0016J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070\rH\u0016J\b\u0010!\u001a\u00020\u0003H\u0016J\b\u0010\"\u001a\u00020\u0007H\u0016J\b\u0010#\u001a\u00020\u0007H\u0016J\b\u0010$\u001a\u00020\u0005H\u0016J\t\u0010%\u001a\u00020\u0007HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/suggestion/view/SuggestionViewConfigImpl;", "Lcom/samsung/android/app/sdk/deepsky/suggestion/view/SuggestionViewConfig;", "itemParam", "Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/SuggestionItem;", "viewSpecParam", "Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/view/SuggestionViewSpec;", "maxSuggestionCountParam", "", "enableLocalOnlyParam", "", "extrasParam", "Landroid/os/Bundle;", "includedIdParam", "", "excludedIdParam", "listMinHeightParam", "(Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/SuggestionItem;Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/view/SuggestionViewSpec;IZLandroid/os/Bundle;Ljava/util/List;Ljava/util/List;I)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "getEnableLocalOnly", "getExcludedDataId", "getExtras", "getIncludedDataId", "getItem", "getListMinHeight", "getMaxSuggestionCount", "getViewSpec", "hashCode", "toString", "", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final /* data */ class SuggestionViewConfigImpl implements SuggestionViewConfig {
    private final boolean enableLocalOnlyParam;

    @Nullable
    private final List<Integer> excludedIdParam;

    @Nullable
    private final Bundle extrasParam;

    @Nullable
    private final List<Integer> includedIdParam;

    @NotNull
    private final SuggestionItem itemParam;
    private final int listMinHeightParam;
    private final int maxSuggestionCountParam;

    @NotNull
    private final SuggestionViewSpec viewSpecParam;

    public SuggestionViewConfigImpl(@NotNull SuggestionItem itemParam, @NotNull SuggestionViewSpec viewSpecParam, int i, boolean z, @Nullable Bundle bundle, @Nullable List<Integer> list, @Nullable List<Integer> list2, int i2) {
        Intrinsics.checkNotNullParameter(itemParam, "itemParam");
        Intrinsics.checkNotNullParameter(viewSpecParam, "viewSpecParam");
        this.itemParam = itemParam;
        this.viewSpecParam = viewSpecParam;
        this.maxSuggestionCountParam = i;
        this.enableLocalOnlyParam = z;
        this.extrasParam = bundle;
        this.includedIdParam = list;
        this.excludedIdParam = list2;
        this.listMinHeightParam = i2;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final SuggestionItem getItemParam() {
        return this.itemParam;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    private final SuggestionViewSpec getViewSpecParam() {
        return this.viewSpecParam;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    private final int getMaxSuggestionCountParam() {
        return this.maxSuggestionCountParam;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    private final boolean getEnableLocalOnlyParam() {
        return this.enableLocalOnlyParam;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    private final Bundle getExtrasParam() {
        return this.extrasParam;
    }

    private final List<Integer> component6() {
        return this.includedIdParam;
    }

    private final List<Integer> component7() {
        return this.excludedIdParam;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    private final int getListMinHeightParam() {
        return this.listMinHeightParam;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SuggestionViewConfigImpl copy$default(SuggestionViewConfigImpl suggestionViewConfigImpl, SuggestionItem suggestionItem, SuggestionViewSpec suggestionViewSpec, int i, boolean z, Bundle bundle, List list, List list2, int i2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            suggestionItem = suggestionViewConfigImpl.itemParam;
        }
        if ((i4 & 2) != 0) {
            suggestionViewSpec = suggestionViewConfigImpl.viewSpecParam;
        }
        if ((i4 & 4) != 0) {
            i = suggestionViewConfigImpl.maxSuggestionCountParam;
        }
        if ((i4 & 8) != 0) {
            z = suggestionViewConfigImpl.enableLocalOnlyParam;
        }
        if ((i4 & 16) != 0) {
            bundle = suggestionViewConfigImpl.extrasParam;
        }
        if ((i4 & 32) != 0) {
            list = suggestionViewConfigImpl.includedIdParam;
        }
        if ((i4 & 64) != 0) {
            list2 = suggestionViewConfigImpl.excludedIdParam;
        }
        if ((i4 & 128) != 0) {
            i2 = suggestionViewConfigImpl.listMinHeightParam;
        }
        List list3 = list2;
        int i5 = i2;
        Bundle bundle2 = bundle;
        List list4 = list;
        return suggestionViewConfigImpl.copy(suggestionItem, suggestionViewSpec, i, z, bundle2, list4, list3, i5);
    }

    @NotNull
    public final SuggestionViewConfigImpl copy(@NotNull SuggestionItem itemParam, @NotNull SuggestionViewSpec viewSpecParam, int maxSuggestionCountParam, boolean enableLocalOnlyParam, @Nullable Bundle extrasParam, @Nullable List<Integer> includedIdParam, @Nullable List<Integer> excludedIdParam, int listMinHeightParam) {
        Intrinsics.checkNotNullParameter(itemParam, "itemParam");
        Intrinsics.checkNotNullParameter(viewSpecParam, "viewSpecParam");
        return new SuggestionViewConfigImpl(itemParam, viewSpecParam, maxSuggestionCountParam, enableLocalOnlyParam, extrasParam, includedIdParam, excludedIdParam, listMinHeightParam);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SuggestionViewConfigImpl)) {
            return false;
        }
        SuggestionViewConfigImpl suggestionViewConfigImpl = (SuggestionViewConfigImpl) other;
        return Intrinsics.areEqual(this.itemParam, suggestionViewConfigImpl.itemParam) && Intrinsics.areEqual(this.viewSpecParam, suggestionViewConfigImpl.viewSpecParam) && this.maxSuggestionCountParam == suggestionViewConfigImpl.maxSuggestionCountParam && this.enableLocalOnlyParam == suggestionViewConfigImpl.enableLocalOnlyParam && Intrinsics.areEqual(this.extrasParam, suggestionViewConfigImpl.extrasParam) && Intrinsics.areEqual(this.includedIdParam, suggestionViewConfigImpl.includedIdParam) && Intrinsics.areEqual(this.excludedIdParam, suggestionViewConfigImpl.excludedIdParam) && this.listMinHeightParam == suggestionViewConfigImpl.listMinHeightParam;
    }

    @Override // com.samsung.android.app.sdk.deepsky.suggestion.view.SuggestionViewConfig
    public boolean getEnableLocalOnly() {
        return this.enableLocalOnlyParam;
    }

    @Override // com.samsung.android.app.sdk.deepsky.suggestion.view.SuggestionViewConfig
    @NotNull
    public List<Integer> getExcludedDataId() {
        List<Integer> list = this.excludedIdParam;
        return list == null ? CollectionsKt.emptyList() : list;
    }

    @Override // com.samsung.android.app.sdk.deepsky.suggestion.view.SuggestionViewConfig
    @Nullable
    public Bundle getExtras() {
        return this.extrasParam;
    }

    @Override // com.samsung.android.app.sdk.deepsky.suggestion.view.SuggestionViewConfig
    @NotNull
    public List<Integer> getIncludedDataId() {
        List<Integer> list = this.includedIdParam;
        return list == null ? CollectionsKt.emptyList() : list;
    }

    @Override // com.samsung.android.app.sdk.deepsky.suggestion.view.SuggestionViewConfig
    @NotNull
    public SuggestionItem getItem() {
        return this.itemParam;
    }

    @Override // com.samsung.android.app.sdk.deepsky.suggestion.view.SuggestionViewConfig
    public int getListMinHeight() {
        return this.listMinHeightParam;
    }

    @Override // com.samsung.android.app.sdk.deepsky.suggestion.view.SuggestionViewConfig
    public int getMaxSuggestionCount() {
        return this.maxSuggestionCountParam;
    }

    @Override // com.samsung.android.app.sdk.deepsky.suggestion.view.SuggestionViewConfig
    @NotNull
    public SuggestionViewSpec getViewSpec() {
        return this.viewSpecParam;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    public int hashCode() {
        int iM1157c = AbstractC0622a.m1157c(this.maxSuggestionCountParam, (this.viewSpecParam.hashCode() + (this.itemParam.hashCode() * 31)) * 31, 31);
        boolean z = this.enableLocalOnlyParam;
        ?? r2 = z;
        if (z) {
            r2 = 1;
        }
        int i = (iM1157c + r2) * 31;
        Bundle bundle = this.extrasParam;
        int iHashCode = (i + (bundle == null ? 0 : bundle.hashCode())) * 31;
        List<Integer> list = this.includedIdParam;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        List<Integer> list2 = this.excludedIdParam;
        return Integer.hashCode(this.listMinHeightParam) + ((iHashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31);
    }

    @NotNull
    public String toString() {
        return "SuggestionViewConfigImpl(itemParam=" + this.itemParam + ", viewSpecParam=" + this.viewSpecParam + ", maxSuggestionCountParam=" + this.maxSuggestionCountParam + ", enableLocalOnlyParam=" + this.enableLocalOnlyParam + ", extrasParam=" + this.extrasParam + ", includedIdParam=" + this.includedIdParam + ", excludedIdParam=" + this.excludedIdParam + ", listMinHeightParam=" + this.listMinHeightParam + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ SuggestionViewConfigImpl(SuggestionItem suggestionItem, SuggestionViewSpec suggestionViewSpec, int i, boolean z, Bundle bundle, List list, List list2, int i2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        int i5;
        List list3;
        bundle = (i4 & 16) != 0 ? null : bundle;
        list = (i4 & 32) != 0 ? null : list;
        if ((i4 & 64) != 0) {
            i5 = i2;
            list3 = null;
        } else {
            i5 = i2;
            list3 = list2;
        }
        this(suggestionItem, suggestionViewSpec, i, z, bundle, list, list3, i5);
    }
}
