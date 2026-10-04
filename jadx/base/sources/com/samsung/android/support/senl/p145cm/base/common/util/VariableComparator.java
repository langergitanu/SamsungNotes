package com.samsung.android.support.senl.p145cm.base.common.util;

import android.graphics.RectF;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.exifinterface.media.ExifInterface;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001:\r\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/common/util/VariableComparator;", "", "<init>", "()V", "RESULT_DIFFERENT_VAIABLE", "", "compare", "", "src", "Lcom/samsung/android/support/senl/cm/base/common/util/VariableComparator$Collector;", "dst", "logTag", "Collector", "Comparison", "List", "Variable", "BoolVar", "IntVar", "LongVar", "FloatVar", "DoubleVar", "StringVar", "RectVar", "ObjectVar", "ComparisonVar", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class VariableComparator {

    @NotNull
    public static final VariableComparator INSTANCE = new VariableComparator();

    @NotNull
    public static final String RESULT_DIFFERENT_VAIABLE = "different value";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\n\u001a\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0014J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0004R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/common/util/VariableComparator$BoolVar;", "Lcom/samsung/android/support/senl/cm/base/common/util/VariableComparator$Variable;", "tag", "", "value", "", "<init>", "(Ljava/lang/String;Z)V", "getValue", "()Z", "getComparisonResult", VPathDataCmd.RCurveTo, "compare", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class BoolVar extends Variable {
        private final boolean value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BoolVar(@NotNull String tag, boolean z) {
            super(tag);
            Intrinsics.checkNotNullParameter(tag, "tag");
            this.value = z;
        }

        public final boolean compare(boolean v) {
            return this.value == v;
        }

        @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Variable
        @Nullable
        public String getComparisonResult(@Nullable Variable v) {
            if (!(v instanceof BoolVar)) {
                return VariableComparator.RESULT_DIFFERENT_VAIABLE;
            }
            BoolVar boolVar = (BoolVar) v;
            if (compare(boolVar.value)) {
                return null;
            }
            return makeUnequalValueStr(String.valueOf(this.value), String.valueOf(boolVar.value));
        }

        public final boolean getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/common/util/VariableComparator$Collector;", "", "collectVariables", "Lcom/samsung/android/support/senl/cm/base/common/util/VariableComparator$List;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Collector {
        @Nullable
        List collectVariables();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H&¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/common/util/VariableComparator$Comparison;", "", "isSame", "", "obj", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Comparison {
        boolean isSame(@Nullable Object obj);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/common/util/VariableComparator$ComparisonVar;", "Lcom/samsung/android/support/senl/cm/base/common/util/VariableComparator$Variable;", "tag", "", "value", "Lcom/samsung/android/support/senl/cm/base/common/util/VariableComparator$Comparison;", "<init>", "(Ljava/lang/String;Lcom/samsung/android/support/senl/cm/base/common/util/VariableComparator$Comparison;)V", "getComparisonResult", VPathDataCmd.RCurveTo, "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ComparisonVar extends Variable {

        @NotNull
        private final Comparison value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ComparisonVar(@NotNull String tag, @NotNull Comparison value) {
            super(tag);
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Variable
        @Nullable
        public String getComparisonResult(@Nullable Variable v) {
            if ((v instanceof ComparisonVar) && this.value.isSame(((ComparisonVar) v).value)) {
                return null;
            }
            return VariableComparator.RESULT_DIFFERENT_VAIABLE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\n\u001a\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0014J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u0005H\u0004R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/common/util/VariableComparator$DoubleVar;", "Lcom/samsung/android/support/senl/cm/base/common/util/VariableComparator$Variable;", "tag", "", "value", "", "<init>", "(Ljava/lang/String;D)V", "getValue", "()D", "getComparisonResult", VPathDataCmd.RCurveTo, "compare", "", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class DoubleVar extends Variable {
        private final double value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DoubleVar(@NotNull String tag, double d) {
            super(tag);
            Intrinsics.checkNotNullParameter(tag, "tag");
            this.value = d;
        }

        public final boolean compare(double v) {
            return DetourUtils.equalDoubleValues(this.value, v);
        }

        @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Variable
        @Nullable
        public String getComparisonResult(@Nullable Variable v) {
            if (!(v instanceof DoubleVar)) {
                return VariableComparator.RESULT_DIFFERENT_VAIABLE;
            }
            DoubleVar doubleVar = (DoubleVar) v;
            if (compare(doubleVar.value)) {
                return null;
            }
            return makeUnequalValueStr(String.valueOf(this.value), String.valueOf(doubleVar.value));
        }

        public final double getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\n\u001a\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0014J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u0005H\u0004R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/common/util/VariableComparator$FloatVar;", "Lcom/samsung/android/support/senl/cm/base/common/util/VariableComparator$Variable;", "tag", "", "value", "", "<init>", "(Ljava/lang/String;F)V", "getValue", "()F", "getComparisonResult", VPathDataCmd.RCurveTo, "compare", "", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class FloatVar extends Variable {
        private final float value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FloatVar(@NotNull String tag, float f) {
            super(tag);
            Intrinsics.checkNotNullParameter(tag, "tag");
            this.value = f;
        }

        public final boolean compare(float v) {
            return DetourUtils.equalFloatValues(this.value, v);
        }

        @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Variable
        @Nullable
        public String getComparisonResult(@Nullable Variable v) {
            if (!(v instanceof FloatVar)) {
                return VariableComparator.RESULT_DIFFERENT_VAIABLE;
            }
            FloatVar floatVar = (FloatVar) v;
            if (compare(floatVar.value)) {
                return null;
            }
            return makeUnequalValueStr(String.valueOf(this.value), String.valueOf(floatVar.value));
        }

        public final float getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\n\u001a\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0014J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u0005H\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/common/util/VariableComparator$IntVar;", "Lcom/samsung/android/support/senl/cm/base/common/util/VariableComparator$Variable;", "tag", "", "value", "", "<init>", "(Ljava/lang/String;I)V", "getValue", "()I", "getComparisonResult", VPathDataCmd.RCurveTo, "compare", "", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static class IntVar extends Variable {
        private final int value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IntVar(@NotNull String tag, int i) {
            super(tag);
            Intrinsics.checkNotNullParameter(tag, "tag");
            this.value = i;
        }

        public boolean compare(int v) {
            return this.value == v;
        }

        @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Variable
        @Nullable
        public String getComparisonResult(@Nullable Variable v) {
            if (!(v instanceof IntVar)) {
                return VariableComparator.RESULT_DIFFERENT_VAIABLE;
            }
            IntVar intVar = (IntVar) v;
            if (compare(intVar.value)) {
                return null;
            }
            return makeUnequalValueStr(String.valueOf(this.value), String.valueOf(intVar.value));
        }

        public final int getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0002`\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/common/util/VariableComparator$List;", "Ljava/util/ArrayList;", "Lcom/samsung/android/support/senl/cm/base/common/util/VariableComparator$Variable;", "Lkotlin/collections/ArrayList;", "<init>", "()V", "addVar", VPathDataCmd.RCurveTo, "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class List extends ArrayList<Variable> {
        @NotNull
        public final List addVar(@Nullable Variable v) {
            add(v);
            return this;
        }

        public /* bridge */ boolean contains(Variable variable) {
            return super.contains((Object) variable);
        }

        public /* bridge */ int getSize() {
            return super.size();
        }

        public /* bridge */ int indexOf(Variable variable) {
            return super.indexOf((Object) variable);
        }

        public /* bridge */ int lastIndexOf(Variable variable) {
            return super.lastIndexOf((Object) variable);
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public final /* bridge */ Variable remove(int i) {
            return removeAt(i);
        }

        public /* bridge */ Variable removeAt(int i) {
            return remove(i);
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj == null ? true : obj instanceof Variable) {
                return contains((Variable) obj);
            }
            return false;
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj == null ? true : obj instanceof Variable) {
                return indexOf((Variable) obj);
            }
            return -1;
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj == null ? true : obj instanceof Variable) {
                return lastIndexOf((Variable) obj);
            }
            return -1;
        }

        public /* bridge */ boolean remove(Variable variable) {
            return super.remove((Object) variable);
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean remove(Object obj) {
            if (obj == null ? true : obj instanceof Variable) {
                return remove((Variable) obj);
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\n\u001a\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0014J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u0005H\u0004R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/common/util/VariableComparator$LongVar;", "Lcom/samsung/android/support/senl/cm/base/common/util/VariableComparator$Variable;", "tag", "", "value", "", "<init>", "(Ljava/lang/String;J)V", "getValue", "()J", "getComparisonResult", VPathDataCmd.RCurveTo, "compare", "", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class LongVar extends Variable {
        private final long value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LongVar(@NotNull String tag, long j) {
            super(tag);
            Intrinsics.checkNotNullParameter(tag, "tag");
            this.value = j;
        }

        public final boolean compare(long v) {
            return this.value == v;
        }

        @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Variable
        @Nullable
        public String getComparisonResult(@Nullable Variable v) {
            if (!(v instanceof LongVar)) {
                return VariableComparator.RESULT_DIFFERENT_VAIABLE;
            }
            LongVar longVar = (LongVar) v;
            if (compare(longVar.value)) {
                return null;
            }
            return makeUnequalValueStr(String.valueOf(this.value), String.valueOf(longVar.value));
        }

        public final long getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0014J\u0015\u0010\r\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000fR\u0013\u0010\u0005\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\t¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/common/util/VariableComparator$ObjectVar;", ExifInterface.LONGITUDE_EAST, "Lcom/samsung/android/support/senl/cm/base/common/util/VariableComparator$Variable;", "tag", "", "value", "<init>", "(Ljava/lang/String;Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getComparisonResult", VPathDataCmd.RCurveTo, "compare", "", "(Ljava/lang/Object;)Z", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static class ObjectVar<E> extends Variable {
        private final E value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ObjectVar(@NotNull String tag, E e) {
            super(tag);
            Intrinsics.checkNotNullParameter(tag, "tag");
            this.value = e;
        }

        public boolean compare(E v) {
            return Intrinsics.areEqual(this.value, v);
        }

        @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Variable
        @Nullable
        public String getComparisonResult(@Nullable Variable v) {
            if ((v instanceof ObjectVar) && compare(((ObjectVar) v).value)) {
                return null;
            }
            return VariableComparator.RESULT_DIFFERENT_VAIABLE;
        }

        public final E getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\n\u001a\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0014J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u0005H\u0004R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/common/util/VariableComparator$RectVar;", "Lcom/samsung/android/support/senl/cm/base/common/util/VariableComparator$Variable;", "tag", "", "value", "Landroid/graphics/RectF;", "<init>", "(Ljava/lang/String;Landroid/graphics/RectF;)V", "getValue", "()Landroid/graphics/RectF;", "getComparisonResult", VPathDataCmd.RCurveTo, "compare", "", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static class RectVar extends Variable {

        @NotNull
        private final RectF value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RectVar(@NotNull String tag, @NotNull RectF value) {
            super(tag);
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final boolean compare(@NotNull RectF v) {
            Intrinsics.checkNotNullParameter(v, "v");
            return Intrinsics.areEqual(this.value, v);
        }

        @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Variable
        @Nullable
        public String getComparisonResult(@Nullable Variable v) {
            if (!(v instanceof RectVar)) {
                return VariableComparator.RESULT_DIFFERENT_VAIABLE;
            }
            RectVar rectVar = (RectVar) v;
            if (compare(rectVar.value)) {
                return null;
            }
            String string = this.value.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            String string2 = rectVar.value.toString();
            Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
            return makeUnequalValueStr(string, string2);
        }

        @NotNull
        public final RectF getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\t\u001a\u0004\u0018\u00010\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0014J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0004R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/common/util/VariableComparator$StringVar;", "Lcom/samsung/android/support/senl/cm/base/common/util/VariableComparator$Variable;", "tag", "", "value", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "getComparisonResult", VPathDataCmd.RCurveTo, "compare", "", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class StringVar extends Variable {

        @NotNull
        private final String value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StringVar(@NotNull String tag, @NotNull String value) {
            super(tag);
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final boolean compare(@Nullable String v) {
            return TextUtils.equals(this.value, v);
        }

        @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Variable
        @Nullable
        public String getComparisonResult(@Nullable Variable v) {
            if (!(v instanceof StringVar)) {
                return VariableComparator.RESULT_DIFFERENT_VAIABLE;
            }
            StringVar stringVar = (StringVar) v;
            if (compare(stringVar.value)) {
                return null;
            }
            return makeUnequalValueStr(this.value, stringVar.value);
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u0003J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0004J\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0000H$R\u001a\u0010\u0002\u001a\u00020\u0003X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/common/util/VariableComparator$Variable;", "", "tag", "", "<init>", "(Ljava/lang/String;)V", "getTag", "()Ljava/lang/String;", "setTag", "isSame", "", VPathDataCmd.RCurveTo, "logTag", "makeUnequalValueStr", "src", "dst", "getComparisonResult", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static abstract class Variable {

        @NotNull
        private String tag;

        public Variable(@NotNull String tag) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            this.tag = tag;
        }

        @Nullable
        public abstract String getComparisonResult(@Nullable Variable v);

        @NotNull
        public final String getTag() {
            return this.tag;
        }

        public final boolean isSame(@Nullable Variable v, @Nullable String logTag) {
            if (!TextUtils.equals(this.tag, v != null ? v.tag : null)) {
                return false;
            }
            String comparisonResult = getComparisonResult(v);
            if (comparisonResult == null) {
                return true;
            }
            if (TextUtils.isEmpty(logTag)) {
                return false;
            }
            LoggerBase.INSTANCE.m7137i(logTag, AbstractC0541b.m775q(" !! equals() - NE - ", this.tag, "[", comparisonResult, "]"));
            return false;
        }

        @NotNull
        public final String makeUnequalValueStr(@NotNull String src, @NotNull String dst) {
            Intrinsics.checkNotNullParameter(src, "src");
            Intrinsics.checkNotNullParameter(dst, "dst");
            StringBuilder sb = new StringBuilder();
            sb.append(src);
            return AbstractC0622a.m1170p(" - ", dst, sb);
        }

        public final void setTag(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.tag = str;
        }
    }

    private VariableComparator() {
    }

    @JvmStatic
    public static final boolean compare(@NotNull Collector src, @NotNull Collector dst, @Nullable String logTag) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        if (!Intrinsics.areEqual(src.getClass(), dst.getClass())) {
            return false;
        }
        List listCollectVariables = src.collectVariables();
        List listCollectVariables2 = dst.collectVariables();
        if (listCollectVariables == null || listCollectVariables2 == null || listCollectVariables.size() == 0 || listCollectVariables.size() != listCollectVariables2.size()) {
            return false;
        }
        Iterator<Variable> it = listCollectVariables.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        Iterator<Variable> it2 = listCollectVariables2.iterator();
        Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
        while (it.hasNext()) {
            Variable next = it.next();
            if (next != null && !next.isSame(it2.next(), logTag)) {
                return false;
            }
        }
        return true;
    }
}
