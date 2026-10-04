package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefinerKt;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@SourceDebugExtension({"SMAP\nAbstractTypeConstructor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractTypeConstructor.kt\norg/jetbrains/kotlin/types/AbstractTypeConstructor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,133:1\n1#2:134\n*E\n"})
public abstract class AbstractTypeConstructor extends ClassifierBasedTypeConstructor {
    private final boolean shouldReportCyclicScopeWithCompanionWarning;

    @NotNull
    private final NotNullLazyValue<Supertypes> supertypes;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class ModuleViewTypeConstructor implements TypeConstructor {

        @NotNull
        private final KotlinTypeRefiner kotlinTypeRefiner;

        @NotNull
        private final Lazy refinedSupertypes$delegate;
        final /* synthetic */ AbstractTypeConstructor this$0;

        public ModuleViewTypeConstructor(@NotNull final AbstractTypeConstructor abstractTypeConstructor, KotlinTypeRefiner kotlinTypeRefiner) {
            Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
            this.this$0 = abstractTypeConstructor;
            this.kotlinTypeRefiner = kotlinTypeRefiner;
            this.refinedSupertypes$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0(this, abstractTypeConstructor) { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$ModuleViewTypeConstructor$$Lambda$0
                private final AbstractTypeConstructor.ModuleViewTypeConstructor arg$0;
                private final AbstractTypeConstructor arg$1;

                {
                    this.arg$0 = this;
                    this.arg$1 = abstractTypeConstructor;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    return AbstractTypeConstructor.ModuleViewTypeConstructor.refinedSupertypes_delegate$lambda$0(this.arg$0, this.arg$1);
                }
            });
        }

        private final List<KotlinType> getRefinedSupertypes() {
            return (List) this.refinedSupertypes$delegate.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List refinedSupertypes_delegate$lambda$0(ModuleViewTypeConstructor this$0, AbstractTypeConstructor this$1) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            return KotlinTypeRefinerKt.refineTypes(this$0.kotlinTypeRefiner, this$1.mo23494getSupertypes());
        }

        public boolean equals(@Nullable Object obj) {
            return this.this$0.equals(obj);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public KotlinBuiltIns getBuiltIns() {
            KotlinBuiltIns builtIns = this.this$0.getBuiltIns();
            Intrinsics.checkNotNullExpressionValue(builtIns, "getBuiltIns(...)");
            return builtIns;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        /* JADX INFO: renamed from: getDeclarationDescriptor */
        public ClassifierDescriptor mo23493getDeclarationDescriptor() {
            return this.this$0.mo23493getDeclarationDescriptor();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public List<TypeParameterDescriptor> getParameters() {
            List<TypeParameterDescriptor> parameters = this.this$0.getParameters();
            Intrinsics.checkNotNullExpressionValue(parameters, "getParameters(...)");
            return parameters;
        }

        public int hashCode() {
            return this.this$0.hashCode();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public boolean isDenotable() {
            return this.this$0.isDenotable();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public TypeConstructor refine(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
            Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
            return this.this$0.refine(kotlinTypeRefiner);
        }

        @NotNull
        public String toString() {
            return this.this$0.toString();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        /* JADX INFO: renamed from: getSupertypes */
        public List<KotlinType> mo23494getSupertypes() {
            return getRefinedSupertypes();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Supertypes {

        @NotNull
        private final Collection<KotlinType> allSupertypes;

        @NotNull
        private List<? extends KotlinType> supertypesWithoutCycles;

        /* JADX WARN: Multi-variable type inference failed */
        public Supertypes(@NotNull Collection<? extends KotlinType> allSupertypes) {
            Intrinsics.checkNotNullParameter(allSupertypes, "allSupertypes");
            this.allSupertypes = allSupertypes;
            this.supertypesWithoutCycles = CollectionsKt.listOf(ErrorUtils.INSTANCE.getErrorTypeForLoopInSupertypes());
        }

        @NotNull
        public final Collection<KotlinType> getAllSupertypes() {
            return this.allSupertypes;
        }

        @NotNull
        public final List<KotlinType> getSupertypesWithoutCycles() {
            return this.supertypesWithoutCycles;
        }

        public final void setSupertypesWithoutCycles(@NotNull List<? extends KotlinType> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.supertypesWithoutCycles = list;
        }
    }

    public AbstractTypeConstructor(@NotNull StorageManager storageManager) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        this.supertypes = storageManager.createLazyValueWithPostCompute(new Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$$Lambda$0
            private final AbstractTypeConstructor arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return AbstractTypeConstructor.supertypes$lambda$0(this.arg$0);
            }
        }, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$$Lambda$1
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return AbstractTypeConstructor.supertypes$lambda$1(((Boolean) obj).booleanValue());
            }
        }, new Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$$Lambda$2
            private final AbstractTypeConstructor arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return AbstractTypeConstructor.supertypes$lambda$7(this.arg$0, (AbstractTypeConstructor.Supertypes) obj);
            }
        });
    }

    private final Collection<KotlinType> computeNeighbours(TypeConstructor typeConstructor, boolean z) {
        List listPlus;
        AbstractTypeConstructor abstractTypeConstructor = typeConstructor instanceof AbstractTypeConstructor ? (AbstractTypeConstructor) typeConstructor : null;
        if (abstractTypeConstructor != null && (listPlus = CollectionsKt.plus((Collection) abstractTypeConstructor.supertypes.invoke().getAllSupertypes(), (Iterable) abstractTypeConstructor.getAdditionalNeighboursInSupertypeGraph(z))) != null) {
            return listPlus;
        }
        Collection<KotlinType> collectionMo23494getSupertypes = typeConstructor.mo23494getSupertypes();
        Intrinsics.checkNotNullExpressionValue(collectionMo23494getSupertypes, "getSupertypes(...)");
        return collectionMo23494getSupertypes;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Supertypes supertypes$lambda$0(AbstractTypeConstructor this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return new Supertypes(this$0.computeSupertypes());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Supertypes supertypes$lambda$1(boolean z) {
        return new Supertypes(CollectionsKt.listOf(ErrorUtils.INSTANCE.getErrorTypeForLoopInSupertypes()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit supertypes$lambda$7(final AbstractTypeConstructor this$0, Supertypes supertypes) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(supertypes, "supertypes");
        List listFindLoopsInSupertypesAndDisconnect = this$0.getSupertypeLoopChecker().findLoopsInSupertypesAndDisconnect(this$0, supertypes.getAllSupertypes(), new Function1(this$0) { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$$Lambda$3
            private final AbstractTypeConstructor arg$0;

            {
                this.arg$0 = this$0;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return AbstractTypeConstructor.supertypes$lambda$7$lambda$2(this.arg$0, (TypeConstructor) obj);
            }
        }, new Function1(this$0) { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$$Lambda$4
            private final AbstractTypeConstructor arg$0;

            {
                this.arg$0 = this$0;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return AbstractTypeConstructor.supertypes$lambda$7$lambda$3(this.arg$0, (KotlinType) obj);
            }
        });
        if (listFindLoopsInSupertypesAndDisconnect.isEmpty()) {
            KotlinType kotlinTypeDefaultSupertypeIfEmpty = this$0.defaultSupertypeIfEmpty();
            List listListOf = kotlinTypeDefaultSupertypeIfEmpty != null ? CollectionsKt.listOf(kotlinTypeDefaultSupertypeIfEmpty) : null;
            if (listListOf == null) {
                listListOf = CollectionsKt.emptyList();
            }
            listFindLoopsInSupertypesAndDisconnect = listListOf;
        }
        if (this$0.getShouldReportCyclicScopeWithCompanionWarning()) {
            this$0.getSupertypeLoopChecker().findLoopsInSupertypesAndDisconnect(this$0, listFindLoopsInSupertypesAndDisconnect, new Function1(this$0) { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$$Lambda$5
                private final AbstractTypeConstructor arg$0;

                {
                    this.arg$0 = this$0;
                }

                @Override // kotlin.jvm.functions.Function1
                public Object invoke(Object obj) {
                    return AbstractTypeConstructor.supertypes$lambda$7$lambda$5(this.arg$0, (TypeConstructor) obj);
                }
            }, new Function1(this$0) { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$$Lambda$6
                private final AbstractTypeConstructor arg$0;

                {
                    this.arg$0 = this$0;
                }

                @Override // kotlin.jvm.functions.Function1
                public Object invoke(Object obj) {
                    return AbstractTypeConstructor.supertypes$lambda$7$lambda$6(this.arg$0, (KotlinType) obj);
                }
            });
        }
        List<KotlinType> list = listFindLoopsInSupertypesAndDisconnect instanceof List ? (List) listFindLoopsInSupertypesAndDisconnect : null;
        if (list == null) {
            list = CollectionsKt.toList(listFindLoopsInSupertypesAndDisconnect);
        }
        supertypes.setSupertypesWithoutCycles(this$0.processSupertypesWithoutCycles(list));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterable supertypes$lambda$7$lambda$2(AbstractTypeConstructor this$0, TypeConstructor it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        return this$0.computeNeighbours(it, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit supertypes$lambda$7$lambda$3(AbstractTypeConstructor this$0, KotlinType it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.reportSupertypeLoopError(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterable supertypes$lambda$7$lambda$5(AbstractTypeConstructor this$0, TypeConstructor it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        return this$0.computeNeighbours(it, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit supertypes$lambda$7$lambda$6(AbstractTypeConstructor this$0, KotlinType it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.reportScopesLoopError(it);
        return Unit.INSTANCE;
    }

    @NotNull
    public abstract Collection<KotlinType> computeSupertypes();

    @Nullable
    public KotlinType defaultSupertypeIfEmpty() {
        return null;
    }

    @NotNull
    public Collection<KotlinType> getAdditionalNeighboursInSupertypeGraph(boolean z) {
        return CollectionsKt.emptyList();
    }

    public boolean getShouldReportCyclicScopeWithCompanionWarning() {
        return this.shouldReportCyclicScopeWithCompanionWarning;
    }

    @NotNull
    public abstract SupertypeLoopChecker getSupertypeLoopChecker();

    @NotNull
    public List<KotlinType> processSupertypesWithoutCycles(@NotNull List<KotlinType> supertypes) {
        Intrinsics.checkNotNullParameter(supertypes, "supertypes");
        return supertypes;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    public TypeConstructor refine(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new ModuleViewTypeConstructor(this, kotlinTypeRefiner);
    }

    public void reportScopesLoopError(@NotNull KotlinType type) {
        Intrinsics.checkNotNullParameter(type, "type");
    }

    public void reportSupertypeLoopError(@NotNull KotlinType type) {
        Intrinsics.checkNotNullParameter(type, "type");
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    @NotNull
    /* JADX INFO: renamed from: getSupertypes */
    public List<KotlinType> mo23494getSupertypes() {
        return this.supertypes.invoke().getSupertypesWithoutCycles();
    }
}
