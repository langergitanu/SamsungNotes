package androidx.lifecycle.model;

import androidx.lifecycle.Elements_extKt;
import androidx.lifecycle.OnLifecycleEvent;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0006\u0010\u0018\u001a\u00020\u0019J\t\u0010\u001a\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, m13886d2 = {"Landroidx/lifecycle/model/EventMethod;", "", "method", "Ljavax/lang/model/element/ExecutableElement;", "onLifecycleEvent", "Landroidx/lifecycle/OnLifecycleEvent;", "type", "Ljavax/lang/model/element/TypeElement;", "(Ljavax/lang/model/element/ExecutableElement;Landroidx/lifecycle/OnLifecycleEvent;Ljavax/lang/model/element/TypeElement;)V", "getMethod", "()Ljavax/lang/model/element/ExecutableElement;", "getOnLifecycleEvent", "()Landroidx/lifecycle/OnLifecycleEvent;", "getType", "()Ljavax/lang/model/element/TypeElement;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "packageName", "", "toString", "lifecycle-compiler"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final /* data */ class EventMethod {

    @NotNull
    private final ExecutableElement method;

    @NotNull
    private final OnLifecycleEvent onLifecycleEvent;

    @NotNull
    private final TypeElement type;

    public EventMethod(@NotNull ExecutableElement method, @NotNull OnLifecycleEvent onLifecycleEvent, @NotNull TypeElement type) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(onLifecycleEvent, "onLifecycleEvent");
        Intrinsics.checkNotNullParameter(type, "type");
        this.method = method;
        this.onLifecycleEvent = onLifecycleEvent;
        this.type = type;
    }

    public static /* synthetic */ EventMethod copy$default(EventMethod eventMethod, ExecutableElement executableElement, OnLifecycleEvent onLifecycleEvent, TypeElement typeElement, int i, Object obj) {
        if ((i & 1) != 0) {
            executableElement = eventMethod.method;
        }
        if ((i & 2) != 0) {
            onLifecycleEvent = eventMethod.onLifecycleEvent;
        }
        if ((i & 4) != 0) {
            typeElement = eventMethod.type;
        }
        return eventMethod.copy(executableElement, onLifecycleEvent, typeElement);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ExecutableElement getMethod() {
        return this.method;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final OnLifecycleEvent getOnLifecycleEvent() {
        return this.onLifecycleEvent;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final TypeElement getType() {
        return this.type;
    }

    @NotNull
    public final EventMethod copy(@NotNull ExecutableElement method, @NotNull OnLifecycleEvent onLifecycleEvent, @NotNull TypeElement type) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(onLifecycleEvent, "onLifecycleEvent");
        Intrinsics.checkNotNullParameter(type, "type");
        return new EventMethod(method, onLifecycleEvent, type);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EventMethod)) {
            return false;
        }
        EventMethod eventMethod = (EventMethod) other;
        return Intrinsics.areEqual(this.method, eventMethod.method) && Intrinsics.areEqual(this.onLifecycleEvent, eventMethod.onLifecycleEvent) && Intrinsics.areEqual(this.type, eventMethod.type);
    }

    @NotNull
    public final ExecutableElement getMethod() {
        return this.method;
    }

    @NotNull
    public final OnLifecycleEvent getOnLifecycleEvent() {
        return this.onLifecycleEvent;
    }

    @NotNull
    public final TypeElement getType() {
        return this.type;
    }

    public int hashCode() {
        return this.type.hashCode() + ((this.onLifecycleEvent.hashCode() + (this.method.hashCode() * 31)) * 31);
    }

    @NotNull
    public final String packageName() {
        return Elements_extKt.getPackageQName(this.type);
    }

    @NotNull
    public String toString() {
        return "EventMethod(method=" + this.method + ", onLifecycleEvent=" + this.onLifecycleEvent + ", type=" + this.type + ")";
    }
}
