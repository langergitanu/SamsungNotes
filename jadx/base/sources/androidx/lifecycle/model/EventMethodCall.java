package androidx.lifecycle.model;

import javax.lang.model.element.TypeElement;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, m13886d2 = {"Landroidx/lifecycle/model/EventMethodCall;", "", "method", "Landroidx/lifecycle/model/EventMethod;", "syntheticAccess", "Ljavax/lang/model/element/TypeElement;", "(Landroidx/lifecycle/model/EventMethod;Ljavax/lang/model/element/TypeElement;)V", "getMethod", "()Landroidx/lifecycle/model/EventMethod;", "getSyntheticAccess", "()Ljavax/lang/model/element/TypeElement;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "lifecycle-compiler"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final /* data */ class EventMethodCall {

    @NotNull
    private final EventMethod method;

    @Nullable
    private final TypeElement syntheticAccess;

    public EventMethodCall(@NotNull EventMethod method, @Nullable TypeElement typeElement) {
        Intrinsics.checkNotNullParameter(method, "method");
        this.method = method;
        this.syntheticAccess = typeElement;
    }

    public static /* synthetic */ EventMethodCall copy$default(EventMethodCall eventMethodCall, EventMethod eventMethod, TypeElement typeElement, int i, Object obj) {
        if ((i & 1) != 0) {
            eventMethod = eventMethodCall.method;
        }
        if ((i & 2) != 0) {
            typeElement = eventMethodCall.syntheticAccess;
        }
        return eventMethodCall.copy(eventMethod, typeElement);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final EventMethod getMethod() {
        return this.method;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final TypeElement getSyntheticAccess() {
        return this.syntheticAccess;
    }

    @NotNull
    public final EventMethodCall copy(@NotNull EventMethod method, @Nullable TypeElement syntheticAccess) {
        Intrinsics.checkNotNullParameter(method, "method");
        return new EventMethodCall(method, syntheticAccess);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EventMethodCall)) {
            return false;
        }
        EventMethodCall eventMethodCall = (EventMethodCall) other;
        return Intrinsics.areEqual(this.method, eventMethodCall.method) && Intrinsics.areEqual(this.syntheticAccess, eventMethodCall.syntheticAccess);
    }

    @NotNull
    public final EventMethod getMethod() {
        return this.method;
    }

    @Nullable
    public final TypeElement getSyntheticAccess() {
        return this.syntheticAccess;
    }

    public int hashCode() {
        int iHashCode = this.method.hashCode() * 31;
        TypeElement typeElement = this.syntheticAccess;
        return iHashCode + (typeElement == null ? 0 : typeElement.hashCode());
    }

    @NotNull
    public String toString() {
        return "EventMethodCall(method=" + this.method + ", syntheticAccess=" + this.syntheticAccess + ")";
    }

    public /* synthetic */ EventMethodCall(EventMethod eventMethod, TypeElement typeElement, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(eventMethod, (i & 2) != 0 ? null : typeElement);
    }
}
