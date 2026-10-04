package androidx.compose.p109ui.node;

import androidx.compose.p109ui.Actual_jvmKt;
import androidx.compose.p109ui.CombinedModifier;
import androidx.compose.p109ui.Modifier;
import androidx.compose.runtime.AbstractC1974b;
import androidx.compose.runtime.collection.MutableVector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u00007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0005\u001a\u0018\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0000\u001a \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\f*\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\fH\u0002\u001a$\u0010\u000f\u001a\u00020\u0010\"\b\b\u0000\u0010\u0011*\u00020\u0012*\b\u0012\u0004\u0012\u0002H\u00110\u00132\u0006\u0010\u0014\u001a\u00020\u0012H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0015"}, m13886d2 = {"ActionReplace", "", "ActionReuse", "ActionUpdate", "SentinelHead", "androidx/compose/ui/node/NodeChainKt$SentinelHead$1", "Landroidx/compose/ui/node/NodeChainKt$SentinelHead$1;", "actionForModifiers", "prev", "Landroidx/compose/ui/Modifier$Element;", "next", "fillVector", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/Modifier;", "result", "updateUnsafe", "", "T", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/ModifierNodeElement;", "node", "ui_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nNodeChain.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NodeChain.kt\nandroidx/compose/ui/node/NodeChainKt\n+ 2 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVectorKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,843:1\n1188#2:844\n1#3:845\n*S KotlinDebug\n*F\n+ 1 NodeChain.kt\nandroidx/compose/ui/node/NodeChainKt\n*L\n824#1:844\n*E\n"})
public final class NodeChainKt {
    private static final int ActionReplace = 0;
    private static final int ActionReuse = 2;
    private static final int ActionUpdate = 1;

    @NotNull
    private static final NodeChainKt$SentinelHead$1 SentinelHead;

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.compose.ui.Modifier$Node, androidx.compose.ui.node.NodeChainKt$SentinelHead$1] */
    static {
        ?? r02 = new Modifier.Node() { // from class: androidx.compose.ui.node.NodeChainKt$SentinelHead$1
            @NotNull
            public String toString() {
                return "<Head>";
            }
        };
        r02.setAggregateChildKindSet$ui_release(-1);
        SentinelHead = r02;
    }

    public static final int actionForModifiers(@NotNull Modifier.Element element, @NotNull Modifier.Element element2) {
        if (Intrinsics.areEqual(element, element2)) {
            return 2;
        }
        return Actual_jvmKt.areObjectsOfSameType(element, element2) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final MutableVector<Modifier.Element> fillVector(Modifier modifier, final MutableVector<Modifier.Element> mutableVector) {
        MutableVector mutableVector2 = new MutableVector(new Modifier[RangesKt.coerceAtLeast(mutableVector.getSize(), 16)], 0);
        mutableVector2.add(modifier);
        Function1<Modifier.Element, Boolean> function1 = null;
        while (mutableVector2.isNotEmpty()) {
            Modifier modifier2 = (Modifier) AbstractC1974b.m1314g(mutableVector2, 1);
            if (modifier2 instanceof CombinedModifier) {
                CombinedModifier combinedModifier = (CombinedModifier) modifier2;
                mutableVector2.add(combinedModifier.getInner());
                mutableVector2.add(combinedModifier.getOuter());
            } else if (modifier2 instanceof Modifier.Element) {
                mutableVector.add(modifier2);
            } else {
                if (function1 == null) {
                    function1 = new Function1<Modifier.Element, Boolean>() { // from class: androidx.compose.ui.node.NodeChainKt.fillVector.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        @NotNull
                        public final Boolean invoke(@NotNull Modifier.Element element) {
                            mutableVector.add(element);
                            return Boolean.TRUE;
                        }
                    };
                }
                modifier2.all(function1);
                function1 = function1;
            }
        }
        return mutableVector;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T extends Modifier.Node> void updateUnsafe(ModifierNodeElement<T> modifierNodeElement, Modifier.Node node) {
        Intrinsics.checkNotNull(node, "null cannot be cast to non-null type T of androidx.compose.ui.node.NodeChainKt.updateUnsafe");
        modifierNodeElement.update(node);
    }
}
