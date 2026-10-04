package androidx.compose.runtime.changelist;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.AbstractC1974b;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.InternalComposeApi;
import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.RememberManager;
import androidx.compose.runtime.SlotWriter;
import androidx.compose.runtime.changelist.Operation;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.Arrays;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.apache.commons.beanutils.PropertyUtils;
import org.ccil.cowan.tagsoup.XMLWriter;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u001c\n\u0002\b\u0004\b\u0000\u0018\u0000 J2\u00020\u0001:\u0003JKLB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006H\u0002J\u0018\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006H\u0002J&\u0010\u001c\u001a\u00020\u00162\u001b\u0010\u001d\u001a\u0017\u0012\b\u0012\u00060\u001fR\u00020\u0000\u0012\u0004\u0012\u00020\u00160\u001e¢\u0006\u0002\b H\u0086\bJ\u0010\u0010!\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0006H\u0002J\u0010\u0010\"\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0006H\u0002J\"\u0010#\u001a\u00020\u00162\n\u0010$\u001a\u0006\u0012\u0002\b\u00030%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)J&\u0010*\u001a\u00020\u00162\u001b\u0010+\u001a\u0017\u0012\b\u0012\u00060\u001fR\u00020\u0000\u0012\u0004\u0012\u00020\u00160\u001e¢\u0006\u0002\b H\u0086\bJ\u0006\u0010,\u001a\u00020-J\u0006\u0010.\u001a\u00020-J\b\u0010/\u001a\u00020\rH\u0002J\u0006\u00100\u001a\u00020\u0016J\u000e\u00101\u001a\u00020\u00162\u0006\u00102\u001a\u00020\u0000J\u000e\u00103\u001a\u00020\u00162\u0006\u00104\u001a\u00020\rJ7\u00103\u001a\u00020\u00162\u0006\u00104\u001a\u00020\r2\u0017\u00105\u001a\u0013\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u00160\u001e¢\u0006\u0002\b H\u0086\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001J\u0010\u00107\u001a\u00020\u00162\u0006\u00104\u001a\u00020\rH\u0007J\u0010\u00108\u001a\u0002092\u0006\u0010:\u001a\u000209H\u0016J\b\u0010;\u001a\u000209H\u0017J\u001a\u0010<\u001a\u00020\u00062\u0006\u0010=\u001a\u00020>H\u0002ø\u0001\u0000¢\u0006\u0004\b?\u0010@J\u001e\u0010A\u001a\u00020\u00062\n\u0010=\u001a\u0006\u0012\u0002\b\u00030BH\u0002ø\u0001\u0000¢\u0006\u0004\bC\u0010@J\u0018\u0010D\u001a\u000209*\u00060\u001fR\u00020\u00002\u0006\u0010:\u001a\u000209H\u0002J\u0016\u0010E\u001a\u000209*\u0004\u0018\u00010\t2\u0006\u0010:\u001a\u000209H\u0002J\f\u0010F\u001a\u000209*\u000209H\u0002J \u0010G\u001a\u000209\"\u0004\b\u0000\u0010H*\b\u0012\u0004\u0012\u0002HH0I2\u0006\u0010:\u001a\u000209H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006M"}, m13886d2 = {"Landroidx/compose/runtime/changelist/Operations;", "Landroidx/compose/runtime/changelist/OperationsDebugStringFormattable;", "()V", "intArgs", "", "intArgsSize", "", "objectArgs", "", "", "[Ljava/lang/Object;", "objectArgsSize", "opCodes", "Landroidx/compose/runtime/changelist/Operation;", "[Landroidx/compose/runtime/changelist/Operation;", "opCodesSize", "pushedIntMask", "pushedObjectMask", "size", "getSize", "()I", "clear", "", "createExpectedArgMask", "paramCount", "determineNewSize", "currentSize", "requiredSize", "drain", "sink", "Lkotlin/Function1;", "Landroidx/compose/runtime/changelist/Operations$OpIterator;", "Lkotlin/ExtensionFunctionType;", "ensureIntArgsSizeAtLeast", "ensureObjectArgsSizeAtLeast", "executeAndFlushAllPendingOperations", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "forEach", "action", "isEmpty", "", "isNotEmpty", "peekOperation", "pop", "popInto", "other", "push", "operation", "args", "Landroidx/compose/runtime/changelist/Operations$WriteScope;", "pushOp", "toDebugString", "", "linePrefix", "toString", "topIntIndexOf", "parameter", "Landroidx/compose/runtime/changelist/Operation$IntParameter;", "topIntIndexOf-w8GmfQM", "(I)I", "topObjectIndexOf", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "topObjectIndexOf-31yXWZQ", "currentOpToDebugString", "formatOpArgumentToString", XMLWriter.INDENT, "toCollectionString", "T", "", "Companion", "OpIterator", "WriteScope", "runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nOperations.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Operations.kt\nandroidx/compose/runtime/changelist/Operations\n+ 2 Preconditions.kt\nandroidx/compose/runtime/PreconditionsKt\n*L\n1#1,476:1\n295#1,7:491\n284#1:498\n295#1,7:499\n285#1,2:506\n295#1,7:508\n33#2,7:477\n50#2,7:484\n*S KotlinDebug\n*F\n+ 1 Operations.kt\nandroidx/compose/runtime/changelist/Operations\n*L\n284#1:491,7\n308#1:498\n308#1:499,7\n308#1:506,2\n407#1:508,7\n147#1:477,7\n174#1:484,7\n*E\n"})
public final class Operations extends OperationsDebugStringFormattable {
    public static final int InitialCapacity = 16;
    private static final int MaxResizeAmount = 1024;
    private int intArgsSize;
    private int objectArgsSize;
    private int opCodesSize;
    private int pushedIntMask;
    private int pushedObjectMask;
    public static final int $stable = 8;

    @NotNull
    private Operation[] opCodes = new Operation[16];

    @NotNull
    private int[] intArgs = new int[16];

    @NotNull
    private Object[] objectArgs = new Object[16];

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ&\u0010\u0010\u001a\u0002H\u0011\"\u0004\b\u0000\u0010\u00112\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0012H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, m13886d2 = {"Landroidx/compose/runtime/changelist/Operations$OpIterator;", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "(Landroidx/compose/runtime/changelist/Operations;)V", "intIdx", "", "objIdx", "opIdx", "operation", "Landroidx/compose/runtime/changelist/Operation;", "getOperation", "()Landroidx/compose/runtime/changelist/Operation;", "getInt", "parameter", "Landroidx/compose/runtime/changelist/Operation$IntParameter;", "getInt-w8GmfQM", "(I)I", "getObject", "T", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "getObject-31yXWZQ", "(I)Ljava/lang/Object;", "next", "", "runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public final class OpIterator implements OperationArgContainer {
        private int intIdx;
        private int objIdx;
        private int opIdx;

        public OpIterator() {
        }

        @Override // androidx.compose.runtime.changelist.OperationArgContainer
        /* JADX INFO: renamed from: getInt-w8GmfQM */
        public int mo18094getIntw8GmfQM(int parameter) {
            return Operations.this.intArgs[this.intIdx + parameter];
        }

        @Override // androidx.compose.runtime.changelist.OperationArgContainer
        /* JADX INFO: renamed from: getObject-31yXWZQ */
        public <T> T mo18095getObject31yXWZQ(int parameter) {
            return (T) Operations.this.objectArgs[this.objIdx + parameter];
        }

        @NotNull
        public final Operation getOperation() {
            Operation operation = Operations.this.opCodes[this.opIdx];
            Intrinsics.checkNotNull(operation);
            return operation;
        }

        public final boolean next() {
            if (this.opIdx >= Operations.this.opCodesSize) {
                return false;
            }
            Operation operation = getOperation();
            this.intIdx = operation.getInts() + this.intIdx;
            this.objIdx = operation.getObjects() + this.objIdx;
            int i = this.opIdx + 1;
            this.opIdx = i;
            return i < Operations.this.opCodesSize;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int createExpectedArgMask(int paramCount) {
        if (paramCount == 0) {
            return 0;
        }
        return (-1) >>> (32 - paramCount);
    }

    private final String currentOpToDebugString(OpIterator opIterator, String str) {
        Operation operation = opIterator.getOperation();
        if (operation.getInts() == 0 && operation.getObjects() == 0) {
            return operation.getName();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(operation.getName());
        sb.append(PropertyUtils.MAPPED_DELIM);
        String strIndent = indent(str);
        int ints = operation.getInts();
        boolean z = true;
        for (int i = 0; i < ints; i++) {
            int iM18058constructorimpl = Operation.IntParameter.m18058constructorimpl(i);
            String strMo18030intParamNamew8GmfQM = operation.mo18030intParamNamew8GmfQM(iM18058constructorimpl);
            if (z) {
                z = false;
            } else {
                sb.append(SQLKeyword.COMMA);
            }
            sb.append('\n');
            Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
            sb.append(strIndent);
            sb.append(strMo18030intParamNamew8GmfQM);
            sb.append(" = ");
            sb.append(opIterator.mo18094getIntw8GmfQM(iM18058constructorimpl));
        }
        int objects = operation.getObjects();
        for (int i2 = 0; i2 < objects; i2++) {
            int iM18069constructorimpl = Operation.ObjectParameter.m18069constructorimpl(i2);
            String strMo18031objectParamName31yXWZQ = operation.mo18031objectParamName31yXWZQ(iM18069constructorimpl);
            if (z) {
                z = false;
            } else {
                sb.append(SQLKeyword.COMMA);
            }
            sb.append('\n');
            Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
            sb.append(strIndent);
            sb.append(strMo18031objectParamName31yXWZQ);
            sb.append(" = ");
            sb.append(formatOpArgumentToString(opIterator.mo18095getObject31yXWZQ(iM18069constructorimpl), strIndent));
        }
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
        sb.append(str);
        sb.append(")");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    private final int determineNewSize(int currentSize, int requiredSize) {
        return RangesKt.coerceAtLeast(RangesKt.coerceAtMost(currentSize, 1024) + currentSize, requiredSize);
    }

    private final void ensureIntArgsSizeAtLeast(int requiredSize) {
        int[] iArr = this.intArgs;
        int length = iArr.length;
        if (requiredSize > length) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, determineNewSize(length, requiredSize));
            Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(this, newSize)");
            this.intArgs = iArrCopyOf;
        }
    }

    private final void ensureObjectArgsSizeAtLeast(int requiredSize) {
        Object[] objArr = this.objectArgs;
        int length = objArr.length;
        if (requiredSize > length) {
            Object[] objArrCopyOf = Arrays.copyOf(objArr, determineNewSize(length, requiredSize));
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, newSize)");
            this.objectArgs = objArrCopyOf;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String formatOpArgumentToString(Object obj, String str) {
        return obj == null ? "null" : obj instanceof Object[] ? toCollectionString(ArraysKt.asIterable((Object[]) obj), str) : obj instanceof int[] ? toCollectionString(ArraysKt.asIterable((int[]) obj), str) : obj instanceof long[] ? toCollectionString(ArraysKt.asIterable((long[]) obj), str) : obj instanceof float[] ? toCollectionString(ArraysKt.asIterable((float[]) obj), str) : obj instanceof double[] ? toCollectionString(ArraysKt.asIterable((double[]) obj), str) : obj instanceof Iterable ? toCollectionString((Iterable) obj, str) : obj instanceof OperationsDebugStringFormattable ? ((OperationsDebugStringFormattable) obj).toDebugString(str) : obj.toString();
    }

    private final String indent(String str) {
        return AbstractC0541b.m756B(str, "    ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Operation peekOperation() {
        Operation operation = this.opCodes[this.opCodesSize - 1];
        Intrinsics.checkNotNull(operation);
        return operation;
    }

    private final <T> String toCollectionString(Iterable<? extends T> iterable, final String str) {
        return CollectionsKt.m13955n(iterable, SQLKeyword.COMMA, "[", "]", new Function1<T, CharSequence>() { // from class: androidx.compose.runtime.changelist.Operations.toCollectionString.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(T t) {
                return Operations.this.formatOpArgumentToString(t, str);
            }
        }, 24);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: topIntIndexOf-w8GmfQM, reason: not valid java name */
    public final int m18098topIntIndexOfw8GmfQM(int parameter) {
        return (this.intArgsSize - peekOperation().getInts()) + parameter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: topObjectIndexOf-31yXWZQ, reason: not valid java name */
    public final int m18099topObjectIndexOf31yXWZQ(int parameter) {
        return (this.objectArgsSize - peekOperation().getObjects()) + parameter;
    }

    public final void clear() {
        this.opCodesSize = 0;
        this.intArgsSize = 0;
        ArraysKt___ArraysJvmKt.fill(this.objectArgs, (Object) null, 0, this.objectArgsSize);
        this.objectArgsSize = 0;
    }

    public final void drain(@NotNull Function1<? super OpIterator, Unit> sink) {
        if (isNotEmpty()) {
            OpIterator opIterator = new OpIterator();
            do {
                sink.invoke(opIterator);
            } while (opIterator.next());
        }
        clear();
    }

    public final void executeAndFlushAllPendingOperations(@NotNull Applier<?> applier, @NotNull SlotWriter slots, @NotNull RememberManager rememberManager) {
        if (isNotEmpty()) {
            OpIterator opIterator = new OpIterator();
            do {
                opIterator.getOperation().execute(opIterator, applier, slots, rememberManager);
            } while (opIterator.next());
        }
        clear();
    }

    public final void forEach(@NotNull Function1<? super OpIterator, Unit> action) {
        if (isNotEmpty()) {
            OpIterator opIterator = new OpIterator();
            do {
                action.invoke(opIterator);
            } while (opIterator.next());
        }
    }

    /* JADX INFO: renamed from: getSize, reason: from getter */
    public final int getOpCodesSize() {
        return this.opCodesSize;
    }

    public final boolean isEmpty() {
        return getOpCodesSize() == 0;
    }

    public final boolean isNotEmpty() {
        return getOpCodesSize() != 0;
    }

    public final void pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot pop(), because the stack is empty.");
        }
        Operation[] operationArr = this.opCodes;
        int i = this.opCodesSize - 1;
        this.opCodesSize = i;
        Operation operation = operationArr[i];
        Intrinsics.checkNotNull(operation);
        this.opCodes[this.opCodesSize] = null;
        int objects = operation.getObjects();
        for (int i2 = 0; i2 < objects; i2++) {
            Object[] objArr = this.objectArgs;
            int i4 = this.objectArgsSize - 1;
            this.objectArgsSize = i4;
            objArr[i4] = null;
        }
        int ints = operation.getInts();
        for (int i5 = 0; i5 < ints; i5++) {
            int[] iArr = this.intArgs;
            int i6 = this.intArgsSize - 1;
            this.intArgsSize = i6;
            iArr[i6] = 0;
        }
    }

    public final void popInto(@NotNull Operations other) {
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot pop(), because the stack is empty.");
        }
        Operation[] operationArr = this.opCodes;
        int i = this.opCodesSize - 1;
        this.opCodesSize = i;
        Operation operation = operationArr[i];
        Intrinsics.checkNotNull(operation);
        this.opCodes[this.opCodesSize] = null;
        other.pushOp(operation);
        int i2 = this.objectArgsSize;
        int i4 = other.objectArgsSize;
        int objects = operation.getObjects();
        for (int i5 = 0; i5 < objects; i5++) {
            i4--;
            i2--;
            Object[] objArr = other.objectArgs;
            Object[] objArr2 = this.objectArgs;
            objArr[i4] = objArr2[i2];
            objArr2[i2] = null;
        }
        int i6 = this.intArgsSize;
        int i7 = other.intArgsSize;
        int ints = operation.getInts();
        for (int i8 = 0; i8 < ints; i8++) {
            i7--;
            i6--;
            int[] iArr = other.intArgs;
            int[] iArr2 = this.intArgs;
            iArr[i7] = iArr2[i6];
            iArr2[i6] = 0;
        }
        this.objectArgsSize -= operation.getObjects();
        this.intArgsSize -= operation.getInts();
    }

    public final void push(@NotNull Operation operation) {
        if (!(operation.getInts() == 0 && operation.getObjects() == 0)) {
            PreconditionsKt.throwIllegalArgumentException("Cannot push " + operation + " without arguments because it expects " + operation.getInts() + " ints and " + operation.getObjects() + " objects.");
        }
        pushOp(operation);
    }

    @InternalComposeApi
    public final void pushOp(@NotNull Operation operation) {
        this.pushedIntMask = 0;
        this.pushedObjectMask = 0;
        int i = this.opCodesSize;
        if (i == this.opCodes.length) {
            Object[] objArrCopyOf = Arrays.copyOf(this.opCodes, this.opCodesSize + RangesKt.coerceAtMost(i, 1024));
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, newSize)");
            this.opCodes = (Operation[]) objArrCopyOf;
        }
        ensureIntArgsSizeAtLeast(operation.getInts() + this.intArgsSize);
        ensureObjectArgsSizeAtLeast(operation.getObjects() + this.objectArgsSize);
        Operation[] operationArr = this.opCodes;
        int i2 = this.opCodesSize;
        this.opCodesSize = i2 + 1;
        operationArr[i2] = operation;
        this.intArgsSize = operation.getInts() + this.intArgsSize;
        this.objectArgsSize = operation.getObjects() + this.objectArgsSize;
    }

    @Override // androidx.compose.runtime.changelist.OperationsDebugStringFormattable
    @NotNull
    public String toDebugString(@NotNull String linePrefix) {
        StringBuilder sb = new StringBuilder();
        if (isNotEmpty()) {
            OpIterator opIterator = new OpIterator();
            int i = 1;
            while (true) {
                sb.append(linePrefix);
                int i2 = i + 1;
                sb.append(i);
                sb.append(". ");
                sb.append(currentOpToDebugString(opIterator, linePrefix));
                Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
                sb.append('\n');
                Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
                if (!opIterator.next()) {
                    break;
                }
                i = i2;
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @Deprecated(message = "toString() will return the default implementation from Any. Did you mean to use toDebugString()?", replaceWith = @ReplaceWith(expression = "toDebugString()", imports = {}))
    @NotNull
    public String toString() {
        return super.toString();
    }

    public final void push(@NotNull Operation operation, @NotNull Function1<? super WriteScope, Unit> args) {
        pushOp(operation);
        args.invoke(WriteScope.m18100boximpl(WriteScope.m18101constructorimpl(this)));
        if (this.pushedIntMask == createExpectedArgMask(operation.getInts()) && this.pushedObjectMask == createExpectedArgMask(operation.getObjects())) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int ints = operation.getInts();
        int i = 0;
        for (int i2 = 0; i2 < ints; i2++) {
            if (((1 << i2) & this.pushedIntMask) != 0) {
                if (i > 0) {
                    sb.append(SQLKeyword.COMMA);
                }
                sb.append(operation.mo18030intParamNamew8GmfQM(Operation.IntParameter.m18058constructorimpl(i2)));
                i++;
            }
        }
        String string = sb.toString();
        StringBuilder sbM1325r = AbstractC1974b.m1325r(string, "StringBuilder().apply(builderAction).toString()");
        int objects = operation.getObjects();
        int i4 = 0;
        for (int i5 = 0; i5 < objects; i5++) {
            if (((1 << i5) & this.pushedObjectMask) != 0) {
                if (i > 0) {
                    sbM1325r.append(SQLKeyword.COMMA);
                }
                sbM1325r.append(operation.mo18031objectParamName31yXWZQ(Operation.ObjectParameter.m18069constructorimpl(i5)));
                i4++;
            }
        }
        String string2 = sbM1325r.toString();
        Intrinsics.checkNotNullExpressionValue(string2, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb2 = new StringBuilder("Error while pushing ");
        sb2.append(operation);
        sb2.append(". Not all arguments were provided. Missing ");
        AbstractC1974b.m1331x(sb2, i, " int arguments (", string, ") and ");
        AbstractC1974b.m1305B(sb2, i4, " object arguments (", string2, ").");
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0010ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J,\u0010\u001a\u001a\u00020\u0014\"\u0004\b\u0000\u0010\u001b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u001c2\u0006\u0010\u0017\u001a\u0002H\u001bø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020 HÖ\u0001¢\u0006\u0004\b!\u0010\"R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006#"}, m13886d2 = {"Landroidx/compose/runtime/changelist/Operations$WriteScope;", "", "stack", "Landroidx/compose/runtime/changelist/Operations;", "constructor-impl", "(Landroidx/compose/runtime/changelist/Operations;)Landroidx/compose/runtime/changelist/Operations;", "operation", "Landroidx/compose/runtime/changelist/Operation;", "getOperation-impl", "(Landroidx/compose/runtime/changelist/Operations;)Landroidx/compose/runtime/changelist/Operation;", "equals", "", "other", "equals-impl", "(Landroidx/compose/runtime/changelist/Operations;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Landroidx/compose/runtime/changelist/Operations;)I", "setInt", "", "parameter", "Landroidx/compose/runtime/changelist/Operation$IntParameter;", "value", "setInt-A6tL2VI", "(Landroidx/compose/runtime/changelist/Operations;II)V", "setObject", "T", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "setObject-DKhxnng", "(Landroidx/compose/runtime/changelist/Operations;ILjava/lang/Object;)V", "toString", "", "toString-impl", "(Landroidx/compose/runtime/changelist/Operations;)Ljava/lang/String;", "runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @JvmInline
    @SourceDebugExtension({"SMAP\nOperations.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Operations.kt\nandroidx/compose/runtime/changelist/Operations$WriteScope\n+ 2 Preconditions.kt\nandroidx/compose/runtime/PreconditionsKt\n*L\n1#1,476:1\n50#2,7:477\n50#2,7:484\n*S KotlinDebug\n*F\n+ 1 Operations.kt\nandroidx/compose/runtime/changelist/Operations$WriteScope\n*L\n336#1:477,7\n345#1:484,7\n*E\n"})
    public static final class WriteScope {

        @NotNull
        private final Operations stack;

        private /* synthetic */ WriteScope(Operations operations) {
            this.stack = operations;
        }

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ WriteScope m18100boximpl(Operations operations) {
            return new WriteScope(operations);
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m18102equalsimpl(Operations operations, Object obj) {
            return (obj instanceof WriteScope) && Intrinsics.areEqual(operations, ((WriteScope) obj).getStack());
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m18103equalsimpl0(Operations operations, Operations operations2) {
            return Intrinsics.areEqual(operations, operations2);
        }

        @NotNull
        /* JADX INFO: renamed from: getOperation-impl, reason: not valid java name */
        public static final Operation m18104getOperationimpl(Operations operations) {
            return operations.peekOperation();
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m18105hashCodeimpl(Operations operations) {
            return operations.hashCode();
        }

        /* JADX INFO: renamed from: setInt-A6tL2VI, reason: not valid java name */
        public static final void m18106setIntA6tL2VI(Operations operations, int i, int i2) {
            int i4 = 1 << i;
            if (!((operations.pushedIntMask & i4) == 0)) {
                PreconditionsKt.throwIllegalStateException("Already pushed argument " + m18104getOperationimpl(operations).mo18030intParamNamew8GmfQM(i));
            }
            operations.pushedIntMask |= i4;
            operations.intArgs[operations.m18098topIntIndexOfw8GmfQM(i)] = i2;
        }

        /* JADX INFO: renamed from: setObject-DKhxnng, reason: not valid java name */
        public static final <T> void m18107setObjectDKhxnng(Operations operations, int i, T t) {
            int i2 = 1 << i;
            if (!((operations.pushedObjectMask & i2) == 0)) {
                PreconditionsKt.throwIllegalStateException("Already pushed argument " + m18104getOperationimpl(operations).mo18031objectParamName31yXWZQ(i));
            }
            operations.pushedObjectMask |= i2;
            operations.objectArgs[operations.m18099topObjectIndexOf31yXWZQ(i)] = t;
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m18108toStringimpl(Operations operations) {
            return "WriteScope(stack=" + operations + PropertyUtils.MAPPED_DELIM2;
        }

        public boolean equals(Object obj) {
            return m18102equalsimpl(this.stack, obj);
        }

        public int hashCode() {
            return m18105hashCodeimpl(this.stack);
        }

        public String toString() {
            return m18108toStringimpl(this.stack);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
        public final /* synthetic */ Operations getStack() {
            return this.stack;
        }

        @NotNull
        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static Operations m18101constructorimpl(@NotNull Operations operations) {
            return operations;
        }
    }
}
