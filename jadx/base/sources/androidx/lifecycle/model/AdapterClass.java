package androidx.lifecycle.model;

import androidx.collection.AbstractC0622a;
import java.util.List;
import java.util.Set;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, m13886d2 = {"Landroidx/lifecycle/model/AdapterClass;", "", "type", "Ljavax/lang/model/element/TypeElement;", "calls", "", "Landroidx/lifecycle/model/EventMethodCall;", "syntheticMethods", "", "Ljavax/lang/model/element/ExecutableElement;", "(Ljavax/lang/model/element/TypeElement;Ljava/util/List;Ljava/util/Set;)V", "getCalls", "()Ljava/util/List;", "getSyntheticMethods", "()Ljava/util/Set;", "getType", "()Ljavax/lang/model/element/TypeElement;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "lifecycle-compiler"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final /* data */ class AdapterClass {

    @NotNull
    private final List<EventMethodCall> calls;

    @NotNull
    private final Set<ExecutableElement> syntheticMethods;

    @NotNull
    private final TypeElement type;

    public AdapterClass(@NotNull TypeElement type, @NotNull List<EventMethodCall> calls, @NotNull Set<? extends ExecutableElement> syntheticMethods) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(calls, "calls");
        Intrinsics.checkNotNullParameter(syntheticMethods, "syntheticMethods");
        this.type = type;
        this.calls = calls;
        this.syntheticMethods = syntheticMethods;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AdapterClass copy$default(AdapterClass adapterClass, TypeElement typeElement, List list, Set set, int i, Object obj) {
        if ((i & 1) != 0) {
            typeElement = adapterClass.type;
        }
        if ((i & 2) != 0) {
            list = adapterClass.calls;
        }
        if ((i & 4) != 0) {
            set = adapterClass.syntheticMethods;
        }
        return adapterClass.copy(typeElement, list, set);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final TypeElement getType() {
        return this.type;
    }

    @NotNull
    public final List<EventMethodCall> component2() {
        return this.calls;
    }

    @NotNull
    public final Set<ExecutableElement> component3() {
        return this.syntheticMethods;
    }

    @NotNull
    public final AdapterClass copy(@NotNull TypeElement type, @NotNull List<EventMethodCall> calls, @NotNull Set<? extends ExecutableElement> syntheticMethods) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(calls, "calls");
        Intrinsics.checkNotNullParameter(syntheticMethods, "syntheticMethods");
        return new AdapterClass(type, calls, syntheticMethods);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdapterClass)) {
            return false;
        }
        AdapterClass adapterClass = (AdapterClass) other;
        return Intrinsics.areEqual(this.type, adapterClass.type) && Intrinsics.areEqual(this.calls, adapterClass.calls) && Intrinsics.areEqual(this.syntheticMethods, adapterClass.syntheticMethods);
    }

    @NotNull
    public final List<EventMethodCall> getCalls() {
        return this.calls;
    }

    @NotNull
    public final Set<ExecutableElement> getSyntheticMethods() {
        return this.syntheticMethods;
    }

    @NotNull
    public final TypeElement getType() {
        return this.type;
    }

    public int hashCode() {
        return this.syntheticMethods.hashCode() + AbstractC0622a.m1159e(this.calls, this.type.hashCode() * 31, 31);
    }

    @NotNull
    public String toString() {
        return "AdapterClass(type=" + this.type + ", calls=" + this.calls + ", syntheticMethods=" + this.syntheticMethods + ")";
    }
}
