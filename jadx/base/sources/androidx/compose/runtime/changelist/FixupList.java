package androidx.compose.runtime.changelist;

import androidx.compose.runtime.AbstractC1974b;
import androidx.compose.runtime.Anchor;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RememberManager;
import androidx.compose.runtime.SlotWriter;
import androidx.compose.runtime.changelist.Operation;
import androidx.compose.runtime.changelist.Operations;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.exifinterface.media.ExifInterface;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bJ&\u0010\f\u001a\u00020\u000b2\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u000bJ\"\u0010\u0014\u001a\u00020\u000b2\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001cJ\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fH\u0016J>\u0010!\u001a\u00020\u000b\"\u0004\b\u0000\u0010\"\"\u0004\b\u0001\u0010#2\u0006\u0010$\u001a\u0002H\"2\u001d\u0010%\u001a\u0019\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u0002H\"\u0012\u0004\u0012\u00020\u000b0&¢\u0006\u0002\b'¢\u0006\u0002\u0010(R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006)"}, m13886d2 = {"Landroidx/compose/runtime/changelist/FixupList;", "Landroidx/compose/runtime/changelist/OperationsDebugStringFormattable;", "()V", "operations", "Landroidx/compose/runtime/changelist/Operations;", "pendingOperations", "size", "", "getSize", "()I", "clear", "", "createAndInsertNode", "factory", "Lkotlin/Function0;", "", "insertIndex", "groupAnchor", "Landroidx/compose/runtime/Anchor;", "endNodeInsert", "executeAndFlushAllPendingFixups", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "isEmpty", "", "isNotEmpty", "toDebugString", "", "linePrefix", "updateNode", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "T", "value", "block", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nFixupList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FixupList.kt\nandroidx/compose/runtime/changelist/FixupList\n+ 2 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 3 Operations.kt\nandroidx/compose/runtime/changelist/Operations\n+ 4 Operation.kt\nandroidx/compose/runtime/changelist/Operation$InsertNodeFixup\n+ 5 Preconditions.kt\nandroidx/compose/runtime/PreconditionsKt\n+ 6 Operation.kt\nandroidx/compose/runtime/changelist/Operation$PostInsertNodeFixup\n+ 7 Operation.kt\nandroidx/compose/runtime/changelist/Operation$UpdateNode\n*L\n1#1,91:1\n4553#2,7:92\n4553#2,7:184\n167#3,5:99\n175#3,2:107\n174#3:109\n178#3,25:115\n204#3:141\n167#3,5:142\n175#3,2:149\n174#3:151\n178#3,25:157\n204#3:183\n167#3,5:191\n175#3,2:198\n174#3:200\n178#3,25:206\n204#3:232\n565#4:104\n566#4:105\n567#4:106\n50#5,5:110\n56#5:140\n50#5,5:152\n56#5:182\n50#5,5:201\n56#5:231\n597#6:147\n598#6:148\n435#7:196\n436#7:197\n*S KotlinDebug\n*F\n+ 1 FixupList.kt\nandroidx/compose/runtime/changelist/FixupList\n*L\n46#1:92,7\n71#1:184,7\n58#1:99,5\n58#1:107,2\n58#1:109\n58#1:115,25\n58#1:141\n64#1:142,5\n64#1:149,2\n64#1:151\n64#1:157,25\n64#1:183\n78#1:191,5\n78#1:198,2\n78#1:200\n78#1:206,25\n78#1:232\n59#1:104\n60#1:105\n61#1:106\n58#1:110,5\n58#1:140\n64#1:152,5\n64#1:182\n78#1:201,5\n78#1:231\n65#1:147\n66#1:148\n79#1:196\n80#1:197\n*E\n"})
public final class FixupList extends OperationsDebugStringFormattable {
    public static final int $stable = 8;

    @NotNull
    private final Operations operations = new Operations();

    @NotNull
    private final Operations pendingOperations = new Operations();

    public final void clear() {
        this.pendingOperations.clear();
        this.operations.clear();
    }

    public final void createAndInsertNode(@NotNull Function0<? extends Object> factory, int insertIndex, @NotNull Anchor groupAnchor) {
        int i;
        int i2;
        Operations operations;
        int i4;
        int i5;
        Operations operations2 = this.operations;
        Operation.InsertNodeFixup insertNodeFixup = Operation.InsertNodeFixup.INSTANCE;
        operations2.pushOp(insertNodeFixup);
        Operations operationsM18101constructorimpl = Operations.WriteScope.m18101constructorimpl(operations2);
        Operations.WriteScope.m18107setObjectDKhxnng(operationsM18101constructorimpl, Operation.ObjectParameter.m18069constructorimpl(0), factory);
        Operations.WriteScope.m18106setIntA6tL2VI(operationsM18101constructorimpl, Operation.IntParameter.m18058constructorimpl(0), insertIndex);
        Operations.WriteScope.m18107setObjectDKhxnng(operationsM18101constructorimpl, Operation.ObjectParameter.m18069constructorimpl(1), groupAnchor);
        if (operations2.pushedIntMask == operations2.createExpectedArgMask(insertNodeFixup.getInts()) && operations2.pushedObjectMask == operations2.createExpectedArgMask(insertNodeFixup.getObjects())) {
            i = 0;
            i2 = 1;
        } else {
            StringBuilder sb = new StringBuilder();
            i = 0;
            int ints = insertNodeFixup.getInts();
            i2 = 1;
            int i6 = 0;
            int i7 = 0;
            while (i7 < ints) {
                if (((1 << i7) & operations2.pushedIntMask) != 0) {
                    if (i6 > 0) {
                        sb.append(SQLKeyword.COMMA);
                    }
                    i5 = ints;
                    sb.append(insertNodeFixup.mo18030intParamNamew8GmfQM(Operation.IntParameter.m18058constructorimpl(i7)));
                    i6++;
                } else {
                    i5 = ints;
                }
                i7++;
                ints = i5;
            }
            String string = sb.toString();
            StringBuilder sbM1325r = AbstractC1974b.m1325r(string, "StringBuilder().apply(builderAction).toString()");
            int objects = insertNodeFixup.getObjects();
            int i8 = 0;
            int i9 = 0;
            while (i9 < objects) {
                if (((1 << i9) & operations2.pushedObjectMask) != 0) {
                    if (i6 > 0) {
                        sbM1325r.append(SQLKeyword.COMMA);
                    }
                    i4 = i9;
                    sbM1325r.append(insertNodeFixup.mo18031objectParamName31yXWZQ(Operation.ObjectParameter.m18069constructorimpl(i4)));
                    i8++;
                } else {
                    i4 = i9;
                }
                i9 = i4 + 1;
            }
            String string2 = sbM1325r.toString();
            Intrinsics.checkNotNullExpressionValue(string2, "StringBuilder().apply(builderAction).toString()");
            StringBuilder sb2 = new StringBuilder("Error while pushing ");
            sb2.append(insertNodeFixup);
            sb2.append(". Not all arguments were provided. Missing ");
            AbstractC1974b.m1331x(sb2, i6, " int arguments (", string, ") and ");
            AbstractC1974b.m1305B(sb2, i8, " object arguments (", string2, ").");
        }
        Operations operations3 = this.pendingOperations;
        Operation.PostInsertNodeFixup postInsertNodeFixup = Operation.PostInsertNodeFixup.INSTANCE;
        operations3.pushOp(postInsertNodeFixup);
        Operations operationsM18101constructorimpl2 = Operations.WriteScope.m18101constructorimpl(operations3);
        Operations.WriteScope.m18106setIntA6tL2VI(operationsM18101constructorimpl2, Operation.IntParameter.m18058constructorimpl(i), insertIndex);
        Operations.WriteScope.m18107setObjectDKhxnng(operationsM18101constructorimpl2, Operation.ObjectParameter.m18069constructorimpl(i), groupAnchor);
        if (((operations3.pushedIntMask == operations3.createExpectedArgMask(postInsertNodeFixup.getInts()) && operations3.pushedObjectMask == operations3.createExpectedArgMask(postInsertNodeFixup.getObjects())) ? i2 : i) == 0) {
            StringBuilder sb3 = new StringBuilder();
            int ints2 = postInsertNodeFixup.getInts();
            int i10 = i;
            int i11 = i10;
            while (i10 < ints2) {
                if (((i2 << i10) & operations3.pushedIntMask) != 0) {
                    if (i11 > 0) {
                        sb3.append(SQLKeyword.COMMA);
                    }
                    sb3.append(postInsertNodeFixup.mo18030intParamNamew8GmfQM(Operation.IntParameter.m18058constructorimpl(i10)));
                    i11++;
                }
                i10++;
            }
            String string3 = sb3.toString();
            StringBuilder sbM1325r2 = AbstractC1974b.m1325r(string3, "StringBuilder().apply(builderAction).toString()");
            int objects2 = postInsertNodeFixup.getObjects();
            int i12 = i;
            int i13 = i12;
            while (i13 < objects2) {
                if (((i2 << i13) & operations3.pushedObjectMask) != 0) {
                    if (i11 > 0) {
                        sbM1325r2.append(SQLKeyword.COMMA);
                    }
                    operations = operations3;
                    sbM1325r2.append(postInsertNodeFixup.mo18031objectParamName31yXWZQ(Operation.ObjectParameter.m18069constructorimpl(i13)));
                    i12++;
                } else {
                    operations = operations3;
                }
                i13++;
                operations3 = operations;
            }
            String string4 = sbM1325r2.toString();
            Intrinsics.checkNotNullExpressionValue(string4, "StringBuilder().apply(builderAction).toString()");
            StringBuilder sb4 = new StringBuilder("Error while pushing ");
            sb4.append(postInsertNodeFixup);
            sb4.append(". Not all arguments were provided. Missing ");
            AbstractC1974b.m1331x(sb4, i11, " int arguments (", string3, ") and ");
            AbstractC1974b.m1305B(sb4, i12, " object arguments (", string4, ").");
        }
    }

    public final void endNodeInsert() {
        if (!this.pendingOperations.isNotEmpty()) {
            ComposerKt.composeImmediateRuntimeError("Cannot end node insertion, there are no pending operations that can be realized.");
        }
        this.pendingOperations.popInto(this.operations);
    }

    public final void executeAndFlushAllPendingFixups(@NotNull Applier<?> applier, @NotNull SlotWriter slots, @NotNull RememberManager rememberManager) {
        if (!this.pendingOperations.isEmpty()) {
            ComposerKt.composeImmediateRuntimeError("FixupList has pending fixup operations that were not realized. Were there mismatched insertNode() and endNodeInsert() calls?");
        }
        this.operations.executeAndFlushAllPendingOperations(applier, slots, rememberManager);
    }

    public final int getSize() {
        return this.operations.getOpCodesSize();
    }

    public final boolean isEmpty() {
        return this.operations.isEmpty();
    }

    public final boolean isNotEmpty() {
        return this.operations.isNotEmpty();
    }

    @Override // androidx.compose.runtime.changelist.OperationsDebugStringFormattable
    @NotNull
    public String toDebugString(@NotNull String linePrefix) {
        StringBuilder sb = new StringBuilder();
        sb.append("FixupList instance containing " + getSize() + " operations");
        if (sb.length() > 0) {
            sb.append(":\n" + this.operations.toDebugString(linePrefix));
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final <V, T> void updateNode(V value, @NotNull Function2<? super T, ? super V, Unit> block) {
        Operations operations = this.operations;
        Operation.UpdateNode updateNode = Operation.UpdateNode.INSTANCE;
        operations.pushOp(updateNode);
        Operations operationsM18101constructorimpl = Operations.WriteScope.m18101constructorimpl(operations);
        Operations.WriteScope.m18107setObjectDKhxnng(operationsM18101constructorimpl, Operation.ObjectParameter.m18069constructorimpl(0), value);
        int iM18069constructorimpl = Operation.ObjectParameter.m18069constructorimpl(1);
        Intrinsics.checkNotNull(block, "null cannot be cast to non-null type @[ExtensionFunctionType] kotlin.Function2<kotlin.Any?, kotlin.Any?, kotlin.Unit>");
        Operations.WriteScope.m18107setObjectDKhxnng(operationsM18101constructorimpl, iM18069constructorimpl, (Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(block, 2));
        if (operations.pushedIntMask == operations.createExpectedArgMask(updateNode.getInts()) && operations.pushedObjectMask == operations.createExpectedArgMask(updateNode.getObjects())) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int ints = updateNode.getInts();
        int i = 0;
        for (int i2 = 0; i2 < ints; i2++) {
            if (((1 << i2) & operations.pushedIntMask) != 0) {
                if (i > 0) {
                    sb.append(SQLKeyword.COMMA);
                }
                sb.append(updateNode.mo18030intParamNamew8GmfQM(Operation.IntParameter.m18058constructorimpl(i2)));
                i++;
            }
        }
        String string = sb.toString();
        StringBuilder sbM1325r = AbstractC1974b.m1325r(string, "StringBuilder().apply(builderAction).toString()");
        int objects = updateNode.getObjects();
        int i4 = 0;
        for (int i5 = 0; i5 < objects; i5++) {
            if (((1 << i5) & operations.pushedObjectMask) != 0) {
                if (i > 0) {
                    sbM1325r.append(SQLKeyword.COMMA);
                }
                sbM1325r.append(updateNode.mo18031objectParamName31yXWZQ(Operation.ObjectParameter.m18069constructorimpl(i5)));
                i4++;
            }
        }
        String string2 = sbM1325r.toString();
        Intrinsics.checkNotNullExpressionValue(string2, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb2 = new StringBuilder("Error while pushing ");
        sb2.append(updateNode);
        sb2.append(". Not all arguments were provided. Missing ");
        AbstractC1974b.m1331x(sb2, i, " int arguments (", string, ") and ");
        AbstractC1974b.m1305B(sb2, i4, " object arguments (", string2, ").");
    }
}
