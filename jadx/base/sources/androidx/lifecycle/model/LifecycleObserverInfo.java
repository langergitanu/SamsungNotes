package androidx.lifecycle.model;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import java.util.List;
import javax.lang.model.element.TypeElement;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00000\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00000\u0005HÆ\u0003J3\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00000\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00000\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, m13886d2 = {"Landroidx/lifecycle/model/LifecycleObserverInfo;", "", "type", "Ljavax/lang/model/element/TypeElement;", "methods", "", "Landroidx/lifecycle/model/EventMethod;", "parents", "(Ljavax/lang/model/element/TypeElement;Ljava/util/List;Ljava/util/List;)V", "getMethods", "()Ljava/util/List;", "getParents", "getType", "()Ljavax/lang/model/element/TypeElement;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "lifecycle-compiler"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final /* data */ class LifecycleObserverInfo {

    @NotNull
    private final List<EventMethod> methods;

    @NotNull
    private final List<LifecycleObserverInfo> parents;

    @NotNull
    private final TypeElement type;

    public LifecycleObserverInfo(@NotNull TypeElement type, @NotNull List<EventMethod> methods, @NotNull List<LifecycleObserverInfo> parents) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(methods, "methods");
        Intrinsics.checkNotNullParameter(parents, "parents");
        this.type = type;
        this.methods = methods;
        this.parents = parents;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LifecycleObserverInfo copy$default(LifecycleObserverInfo lifecycleObserverInfo, TypeElement typeElement, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            typeElement = lifecycleObserverInfo.type;
        }
        if ((i & 2) != 0) {
            list = lifecycleObserverInfo.methods;
        }
        if ((i & 4) != 0) {
            list2 = lifecycleObserverInfo.parents;
        }
        return lifecycleObserverInfo.copy(typeElement, list, list2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final TypeElement getType() {
        return this.type;
    }

    @NotNull
    public final List<EventMethod> component2() {
        return this.methods;
    }

    @NotNull
    public final List<LifecycleObserverInfo> component3() {
        return this.parents;
    }

    @NotNull
    public final LifecycleObserverInfo copy(@NotNull TypeElement type, @NotNull List<EventMethod> methods, @NotNull List<LifecycleObserverInfo> parents) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(methods, "methods");
        Intrinsics.checkNotNullParameter(parents, "parents");
        return new LifecycleObserverInfo(type, methods, parents);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LifecycleObserverInfo)) {
            return false;
        }
        LifecycleObserverInfo lifecycleObserverInfo = (LifecycleObserverInfo) other;
        return Intrinsics.areEqual(this.type, lifecycleObserverInfo.type) && Intrinsics.areEqual(this.methods, lifecycleObserverInfo.methods) && Intrinsics.areEqual(this.parents, lifecycleObserverInfo.parents);
    }

    @NotNull
    public final List<EventMethod> getMethods() {
        return this.methods;
    }

    @NotNull
    public final List<LifecycleObserverInfo> getParents() {
        return this.parents;
    }

    @NotNull
    public final TypeElement getType() {
        return this.type;
    }

    public int hashCode() {
        return this.parents.hashCode() + AbstractC0622a.m1159e(this.methods, this.type.hashCode() * 31, 31);
    }

    @NotNull
    public String toString() {
        TypeElement typeElement = this.type;
        List<EventMethod> list = this.methods;
        List<LifecycleObserverInfo> list2 = this.parents;
        StringBuilder sb = new StringBuilder("LifecycleObserverInfo(type=");
        sb.append(typeElement);
        sb.append(", methods=");
        sb.append(list);
        sb.append(", parents=");
        return AbstractC0541b.m777s(sb, list2, ")");
    }

    public /* synthetic */ LifecycleObserverInfo(TypeElement typeElement, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(typeElement, list, (i & 4) != 0 ? CollectionsKt.emptyList() : list2);
    }
}
