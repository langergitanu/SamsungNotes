package androidx.glance.semantics;

import androidx.compose.runtime.internal.StabilityInferred;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, m13886d2 = {"Landroidx/glance/semantics/SemanticsProperties;", "", "()V", "ContentDescription", "Landroidx/glance/semantics/SemanticsPropertyKey;", "", "", "getContentDescription", "()Landroidx/glance/semantics/SemanticsPropertyKey;", "TestTag", "getTestTag", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class SemanticsProperties {
    public static final int $stable = 0;

    @NotNull
    public static final SemanticsProperties INSTANCE = new SemanticsProperties();

    @NotNull
    private static final SemanticsPropertyKey<List<String>> ContentDescription = new SemanticsPropertyKey<>("ContentDescription", new Function2<List<? extends String>, List<? extends String>, List<? extends String>>() { // from class: androidx.glance.semantics.SemanticsProperties$ContentDescription$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ List<? extends String> invoke(List<? extends String> list, List<? extends String> list2) {
            return invoke2((List<String>) list, (List<String>) list2);
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<String> invoke2(@Nullable List<String> list, @NotNull List<String> childValue) {
            List<String> mutableList;
            Intrinsics.checkNotNullParameter(childValue, "childValue");
            if (list == null || (mutableList = CollectionsKt.toMutableList((Collection) list)) == null) {
                return childValue;
            }
            mutableList.addAll(childValue);
            return mutableList;
        }
    });

    @NotNull
    private static final SemanticsPropertyKey<String> TestTag = new SemanticsPropertyKey<>("TestTag", new Function2<String, String, String>() { // from class: androidx.glance.semantics.SemanticsProperties$TestTag$1
        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final String invoke(@Nullable String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str2, "<anonymous parameter 1>");
            return str;
        }
    });

    private SemanticsProperties() {
    }

    @NotNull
    public final SemanticsPropertyKey<List<String>> getContentDescription() {
        return ContentDescription;
    }

    @NotNull
    public final SemanticsPropertyKey<String> getTestTag() {
        return TestTag;
    }
}
