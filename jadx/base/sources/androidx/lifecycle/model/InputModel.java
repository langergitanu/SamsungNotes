package androidx.lifecycle.model;

import androidx.lifecycle.Elements_extKt;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0006¢\u0006\u0002\u0010\u000bJ\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÂ\u0003J\u0015\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u001b\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0006HÆ\u0003JK\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u00062\u001a\b\u0002\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u000e\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u000e\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u0004J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R#\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, m13886d2 = {"Landroidx/lifecycle/model/InputModel;", "", "rootTypes", "", "Ljavax/lang/model/element/TypeElement;", "observersInfo", "", "Landroidx/lifecycle/model/LifecycleObserverInfo;", "generatedAdapters", "", "Ljavax/lang/model/element/ExecutableElement;", "(Ljava/util/Set;Ljava/util/Map;Ljava/util/Map;)V", "getGeneratedAdapters", "()Ljava/util/Map;", "getObserversInfo", "component1", "component2", "component3", "copy", "equals", "", "other", "hasSyntheticAccessorFor", "eventMethod", "Landroidx/lifecycle/model/EventMethod;", "hashCode", "", "isRootType", "type", "toString", "", "lifecycle-compiler"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nInputModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InputModel.kt\nandroidx/lifecycle/model/InputModel\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,47:1\n1747#2,3:48\n*S KotlinDebug\n*F\n+ 1 InputModel.kt\nandroidx/lifecycle/model/InputModel\n*L\n40#1:48,3\n*E\n"})
public final /* data */ class InputModel {

    @NotNull
    private final Map<TypeElement, List<ExecutableElement>> generatedAdapters;

    @NotNull
    private final Map<TypeElement, LifecycleObserverInfo> observersInfo;

    @NotNull
    private final Set<TypeElement> rootTypes;

    /* JADX WARN: Multi-variable type inference failed */
    public InputModel(@NotNull Set<? extends TypeElement> rootTypes, @NotNull Map<TypeElement, LifecycleObserverInfo> observersInfo, @NotNull Map<TypeElement, ? extends List<? extends ExecutableElement>> generatedAdapters) {
        Intrinsics.checkNotNullParameter(rootTypes, "rootTypes");
        Intrinsics.checkNotNullParameter(observersInfo, "observersInfo");
        Intrinsics.checkNotNullParameter(generatedAdapters, "generatedAdapters");
        this.rootTypes = rootTypes;
        this.observersInfo = observersInfo;
        this.generatedAdapters = generatedAdapters;
    }

    private final Set<TypeElement> component1() {
        return this.rootTypes;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InputModel copy$default(InputModel inputModel, Set set, Map map, Map map2, int i, Object obj) {
        if ((i & 1) != 0) {
            set = inputModel.rootTypes;
        }
        if ((i & 2) != 0) {
            map = inputModel.observersInfo;
        }
        if ((i & 4) != 0) {
            map2 = inputModel.generatedAdapters;
        }
        return inputModel.copy(set, map, map2);
    }

    @NotNull
    public final Map<TypeElement, LifecycleObserverInfo> component2() {
        return this.observersInfo;
    }

    @NotNull
    public final Map<TypeElement, List<ExecutableElement>> component3() {
        return this.generatedAdapters;
    }

    @NotNull
    public final InputModel copy(@NotNull Set<? extends TypeElement> rootTypes, @NotNull Map<TypeElement, LifecycleObserverInfo> observersInfo, @NotNull Map<TypeElement, ? extends List<? extends ExecutableElement>> generatedAdapters) {
        Intrinsics.checkNotNullParameter(rootTypes, "rootTypes");
        Intrinsics.checkNotNullParameter(observersInfo, "observersInfo");
        Intrinsics.checkNotNullParameter(generatedAdapters, "generatedAdapters");
        return new InputModel(rootTypes, observersInfo, generatedAdapters);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InputModel)) {
            return false;
        }
        InputModel inputModel = (InputModel) other;
        return Intrinsics.areEqual(this.rootTypes, inputModel.rootTypes) && Intrinsics.areEqual(this.observersInfo, inputModel.observersInfo) && Intrinsics.areEqual(this.generatedAdapters, inputModel.generatedAdapters);
    }

    @NotNull
    public final Map<TypeElement, List<ExecutableElement>> getGeneratedAdapters() {
        return this.generatedAdapters;
    }

    @NotNull
    public final Map<TypeElement, LifecycleObserverInfo> getObserversInfo() {
        return this.observersInfo;
    }

    public final boolean hasSyntheticAccessorFor(@NotNull EventMethod eventMethod) {
        Intrinsics.checkNotNullParameter(eventMethod, "eventMethod");
        List<ExecutableElement> list = this.generatedAdapters.get(eventMethod.getType());
        if (list == null) {
            return false;
        }
        List<ExecutableElement> list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            return false;
        }
        for (ExecutableElement executableElement : list2) {
            if (Intrinsics.areEqual(Elements_extKt.name(executableElement), Elements_extKt.syntheticName(eventMethod.getMethod())) && eventMethod.getMethod().getParameters().size() + 1 == executableElement.getParameters().size()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.generatedAdapters.hashCode() + ((this.observersInfo.hashCode() + (this.rootTypes.hashCode() * 31)) * 31);
    }

    public final boolean isRootType(@NotNull TypeElement type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return this.rootTypes.contains(type);
    }

    @NotNull
    public String toString() {
        return "InputModel(rootTypes=" + this.rootTypes + ", observersInfo=" + this.observersInfo + ", generatedAdapters=" + this.generatedAdapters + ")";
    }
}
