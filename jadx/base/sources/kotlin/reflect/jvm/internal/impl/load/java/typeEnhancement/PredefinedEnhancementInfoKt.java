package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.common.Constant;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@SourceDebugExtension({"SMAP\npredefinedEnhancementInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 predefinedEnhancementInfo.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/PredefinedEnhancementInfoKt\n+ 2 SignatureBuildingComponents.kt\norg/jetbrains/kotlin/load/kotlin/SignatureBuildingComponentsKt\n+ 3 predefinedEnhancementInfo.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/SignatureEnhancementBuilder\n*L\n1#1,254:1\n201#1:256\n13#2:255\n207#3:257\n207#3:258\n207#3:259\n207#3:260\n207#3:261\n207#3:262\n207#3:263\n207#3:264\n207#3:265\n207#3:266\n207#3:267\n207#3:268\n207#3:269\n207#3:270\n*S KotlinDebug\n*F\n+ 1 predefinedEnhancementInfo.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/PredefinedEnhancementInfoKt\n*L\n52#1:256\n41#1:255\n53#1:257\n58#1:258\n63#1:259\n75#1:260\n80#1:261\n128#1:262\n148#1:263\n154#1:264\n160#1:265\n167#1:266\n172#1:267\n178#1:268\n184#1:269\n191#1:270\n*E\n"})
public final class PredefinedEnhancementInfoKt {

    @NotNull
    private static final JavaTypeQualifiers NOT_NULLABLE;

    @NotNull
    private static final JavaTypeQualifiers NOT_PLATFORM;

    @NotNull
    private static final JavaTypeQualifiers NULLABLE = new JavaTypeQualifiers(NullabilityQualifier.NULLABLE, null, false, false, 8, null);

    @NotNull
    private static final Map<String, PredefinedFunctionEnhancementInfo> PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE;

    static {
        NullabilityQualifier nullabilityQualifier = NullabilityQualifier.NOT_NULL;
        NOT_PLATFORM = new JavaTypeQualifiers(nullabilityQualifier, null, false, false, 8, null);
        NOT_NULLABLE = new JavaTypeQualifiers(nullabilityQualifier, null, true, false, 8, null);
        final SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
        final String strJavaLang = signatureBuildingComponents.javaLang("Object");
        final String strJavaFunction = signatureBuildingComponents.javaFunction("Predicate");
        final String strJavaFunction2 = signatureBuildingComponents.javaFunction("Function");
        final String strJavaFunction3 = signatureBuildingComponents.javaFunction("Consumer");
        final String strJavaFunction4 = signatureBuildingComponents.javaFunction("BiFunction");
        final String strJavaFunction5 = signatureBuildingComponents.javaFunction("BiConsumer");
        final String strJavaFunction6 = signatureBuildingComponents.javaFunction("UnaryOperator");
        final String strJavaUtil = signatureBuildingComponents.javaUtil("stream/Stream");
        final String strJavaUtil2 = signatureBuildingComponents.javaUtil("Optional");
        SignatureEnhancementBuilder signatureEnhancementBuilder = new SignatureEnhancementBuilder();
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaUtil("Iterator")).function("forEachRemaining", new Function1(strJavaFunction3) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$0
            private final String arg$0;

            {
                this.arg$0 = strJavaFunction3;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m14057x7e5ca92e(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        });
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaLang("Iterable")).function("spliterator", new Function1(signatureBuildingComponents) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$1
            private final SignatureBuildingComponents arg$0;

            {
                this.arg$0 = signatureBuildingComponents;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m14074x66ef8b6e(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        });
        SignatureEnhancementBuilder.ClassEnhancementBuilder classEnhancementBuilder = new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaUtil("Collection"));
        classEnhancementBuilder.function("removeIf", new Function1(strJavaFunction) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$2
            private final String arg$0;

            {
                this.arg$0 = strJavaFunction;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m14081x38154fec(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        });
        classEnhancementBuilder.function("stream", new Function1(strJavaUtil) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$3
            private final String arg$0;

            {
                this.arg$0 = strJavaUtil;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m14082x38154fed(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        });
        classEnhancementBuilder.function("parallelStream", new Function1(strJavaUtil) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$4
            private final String arg$0;

            {
                this.arg$0 = strJavaUtil;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m14083x38154fee(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        });
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaUtil("List")).function("replaceAll", new Function1(strJavaFunction6) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$5
            private final String arg$0;

            {
                this.arg$0 = strJavaFunction6;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m14084x20a8322e(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        });
        SignatureEnhancementBuilder.ClassEnhancementBuilder classEnhancementBuilder2 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaUtil("Map"));
        classEnhancementBuilder2.function("forEach", new Function1(strJavaFunction5) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$6
            private final String arg$0;

            {
                this.arg$0 = strJavaFunction5;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m14058x9f154e28(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        });
        classEnhancementBuilder2.function("putIfAbsent", new Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$7
            private final String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m14059x9f154e29(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        });
        classEnhancementBuilder2.function(Constant.DRAWING_TOOLKIT_KEY_RETURN_TYPE_REPLACE, new Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$8
            private final String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m14060x9f154e2a(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        });
        classEnhancementBuilder2.function(Constant.DRAWING_TOOLKIT_KEY_RETURN_TYPE_REPLACE, new Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$9
            private final String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m14061x9f154e2b(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        });
        classEnhancementBuilder2.function("replaceAll", new Function1(strJavaFunction4) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$10
            private final String arg$0;

            {
                this.arg$0 = strJavaFunction4;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m14062x9f154e2c(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        });
        classEnhancementBuilder2.function("compute", new Function1(strJavaLang, strJavaFunction4) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$11
            private final String arg$0;
            private final String arg$1;

            {
                this.arg$0 = strJavaLang;
                this.arg$1 = strJavaFunction4;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m14063x9f154e2d(this.arg$0, this.arg$1, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        });
        classEnhancementBuilder2.function("computeIfAbsent", new Function1(strJavaLang, strJavaFunction2) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$12
            private final String arg$0;
            private final String arg$1;

            {
                this.arg$0 = strJavaLang;
                this.arg$1 = strJavaFunction2;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m14064x9f154e2e(this.arg$0, this.arg$1, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        });
        classEnhancementBuilder2.function("computeIfPresent", new Function1(strJavaLang, strJavaFunction4) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$13
            private final String arg$0;
            private final String arg$1;

            {
                this.arg$0 = strJavaLang;
                this.arg$1 = strJavaFunction4;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m14065x9f154e2f(this.arg$0, this.arg$1, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        });
        classEnhancementBuilder2.function("merge", new Function1(strJavaLang, strJavaFunction4) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$14
            private final String arg$0;
            private final String arg$1;

            {
                this.arg$0 = strJavaLang;
                this.arg$1 = strJavaFunction4;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m14066x9f154e30(this.arg$0, this.arg$1, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        });
        SignatureEnhancementBuilder.ClassEnhancementBuilder classEnhancementBuilder3 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, strJavaUtil2);
        classEnhancementBuilder3.function("empty", new Function1(strJavaUtil2) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$15
            private final String arg$0;

            {
                this.arg$0 = strJavaUtil2;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m14067x533428a2(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        });
        classEnhancementBuilder3.function("of", new Function1(strJavaLang, strJavaUtil2) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$16
            private final String arg$0;
            private final String arg$1;

            {
                this.arg$0 = strJavaLang;
                this.arg$1 = strJavaUtil2;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m14068x533428a3(this.arg$0, this.arg$1, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        });
        classEnhancementBuilder3.function("ofNullable", new Function1(strJavaLang, strJavaUtil2) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$17
            private final String arg$0;
            private final String arg$1;

            {
                this.arg$0 = strJavaLang;
                this.arg$1 = strJavaUtil2;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m14069x533428a4(this.arg$0, this.arg$1, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        });
        classEnhancementBuilder3.function("get", new Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$18
            private final String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m14070x533428a5(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        });
        classEnhancementBuilder3.function("ifPresent", new Function1(strJavaFunction3) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$19
            private final String arg$0;

            {
                this.arg$0 = strJavaFunction3;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m14071x533428a6(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        });
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaLang("ref/Reference")).function("get", new Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$20
            private final String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m14072x7cfd8e2a(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        });
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, strJavaFunction).function("test", new Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$21
            private final String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m14073xa6c6f3ae(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        });
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaFunction("BiPredicate")).function("test", new Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$22
            private final String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m14075x753031c(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        });
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, strJavaFunction3).function("accept", new Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$23
            private final String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m14076x311c68a0(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        });
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, strJavaFunction5).function("accept", new Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$24
            private final String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m14077x5ae5ce24(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        });
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, strJavaFunction2).function("apply", new Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$25
            private final String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m14078x84af33a8(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        });
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, strJavaFunction4).function("apply", new Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$26
            private final String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m14079xae78992c(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        });
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaFunction("Supplier")).function("get", new Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$27
            private final String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m14080xf04a89a(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        });
        PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE = signatureEnhancementBuilder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$43$lambda$42$lambda$1$lambda$0 */
    public static final Unit m14057x7e5ca92e(String JFConsumer, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(JFConsumer, "$JFConsumer");
        Intrinsics.checkNotNullParameter(function, "$this$function");
        JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.parameter(JFConsumer, javaTypeQualifiers, javaTypeQualifiers);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$43$lambda$42$lambda$19$lambda$10 */
    public static final Unit m14058x9f154e28(String JFBiConsumer, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(JFBiConsumer, "$JFBiConsumer");
        Intrinsics.checkNotNullParameter(function, "$this$function");
        JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.parameter(JFBiConsumer, javaTypeQualifiers, javaTypeQualifiers, javaTypeQualifiers);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$43$lambda$42$lambda$19$lambda$11 */
    public static final Unit m14059x9f154e29(String JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(JLObject, "$JLObject");
        Intrinsics.checkNotNullParameter(function, "$this$function");
        JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.parameter(JLObject, javaTypeQualifiers);
        function.parameter(JLObject, javaTypeQualifiers);
        function.returns(JLObject, NULLABLE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$43$lambda$42$lambda$19$lambda$12 */
    public static final Unit m14060x9f154e2a(String JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(JLObject, "$JLObject");
        Intrinsics.checkNotNullParameter(function, "$this$function");
        JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.parameter(JLObject, javaTypeQualifiers);
        function.parameter(JLObject, javaTypeQualifiers);
        function.returns(JLObject, NULLABLE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$43$lambda$42$lambda$19$lambda$13 */
    public static final Unit m14061x9f154e2b(String JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(JLObject, "$JLObject");
        Intrinsics.checkNotNullParameter(function, "$this$function");
        JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.parameter(JLObject, javaTypeQualifiers);
        function.parameter(JLObject, javaTypeQualifiers);
        function.parameter(JLObject, javaTypeQualifiers);
        function.returns(JvmPrimitiveType.BOOLEAN);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$43$lambda$42$lambda$19$lambda$14 */
    public static final Unit m14062x9f154e2c(String JFBiFunction, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(JFBiFunction, "$JFBiFunction");
        Intrinsics.checkNotNullParameter(function, "$this$function");
        JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.parameter(JFBiFunction, javaTypeQualifiers, javaTypeQualifiers, javaTypeQualifiers, javaTypeQualifiers);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$43$lambda$42$lambda$19$lambda$15 */
    public static final Unit m14063x9f154e2d(String JLObject, String JFBiFunction, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(JLObject, "$JLObject");
        Intrinsics.checkNotNullParameter(JFBiFunction, "$JFBiFunction");
        Intrinsics.checkNotNullParameter(function, "$this$function");
        JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.parameter(JLObject, javaTypeQualifiers);
        JavaTypeQualifiers javaTypeQualifiers2 = NULLABLE;
        function.parameter(JFBiFunction, javaTypeQualifiers, javaTypeQualifiers, javaTypeQualifiers2, javaTypeQualifiers2);
        function.returns(JLObject, javaTypeQualifiers2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$43$lambda$42$lambda$19$lambda$16 */
    public static final Unit m14064x9f154e2e(String JLObject, String JFFunction, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(JLObject, "$JLObject");
        Intrinsics.checkNotNullParameter(JFFunction, "$JFFunction");
        Intrinsics.checkNotNullParameter(function, "$this$function");
        JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.parameter(JLObject, javaTypeQualifiers);
        function.parameter(JFFunction, javaTypeQualifiers, javaTypeQualifiers, javaTypeQualifiers);
        function.returns(JLObject, javaTypeQualifiers);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$43$lambda$42$lambda$19$lambda$17 */
    public static final Unit m14065x9f154e2f(String JLObject, String JFBiFunction, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(JLObject, "$JLObject");
        Intrinsics.checkNotNullParameter(JFBiFunction, "$JFBiFunction");
        Intrinsics.checkNotNullParameter(function, "$this$function");
        JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.parameter(JLObject, javaTypeQualifiers);
        JavaTypeQualifiers javaTypeQualifiers2 = NOT_NULLABLE;
        JavaTypeQualifiers javaTypeQualifiers3 = NULLABLE;
        function.parameter(JFBiFunction, javaTypeQualifiers, javaTypeQualifiers, javaTypeQualifiers2, javaTypeQualifiers3);
        function.returns(JLObject, javaTypeQualifiers3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$43$lambda$42$lambda$19$lambda$18 */
    public static final Unit m14066x9f154e30(String JLObject, String JFBiFunction, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(JLObject, "$JLObject");
        Intrinsics.checkNotNullParameter(JFBiFunction, "$JFBiFunction");
        Intrinsics.checkNotNullParameter(function, "$this$function");
        JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.parameter(JLObject, javaTypeQualifiers);
        JavaTypeQualifiers javaTypeQualifiers2 = NOT_NULLABLE;
        function.parameter(JLObject, javaTypeQualifiers2);
        JavaTypeQualifiers javaTypeQualifiers3 = NULLABLE;
        function.parameter(JFBiFunction, javaTypeQualifiers, javaTypeQualifiers2, javaTypeQualifiers2, javaTypeQualifiers3);
        function.returns(JLObject, javaTypeQualifiers3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$43$lambda$42$lambda$25$lambda$20 */
    public static final Unit m14067x533428a2(String JUOptional, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(JUOptional, "$JUOptional");
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.returns(JUOptional, NOT_PLATFORM, NOT_NULLABLE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$43$lambda$42$lambda$25$lambda$21 */
    public static final Unit m14068x533428a3(String JLObject, String JUOptional, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(JLObject, "$JLObject");
        Intrinsics.checkNotNullParameter(JUOptional, "$JUOptional");
        Intrinsics.checkNotNullParameter(function, "$this$function");
        JavaTypeQualifiers javaTypeQualifiers = NOT_NULLABLE;
        function.parameter(JLObject, javaTypeQualifiers);
        function.returns(JUOptional, NOT_PLATFORM, javaTypeQualifiers);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$43$lambda$42$lambda$25$lambda$22 */
    public static final Unit m14069x533428a4(String JLObject, String JUOptional, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(JLObject, "$JLObject");
        Intrinsics.checkNotNullParameter(JUOptional, "$JUOptional");
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.parameter(JLObject, NULLABLE);
        function.returns(JUOptional, NOT_PLATFORM, NOT_NULLABLE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$43$lambda$42$lambda$25$lambda$23 */
    public static final Unit m14070x533428a5(String JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(JLObject, "$JLObject");
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.returns(JLObject, NOT_NULLABLE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$43$lambda$42$lambda$25$lambda$24 */
    public static final Unit m14071x533428a6(String JFConsumer, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(JFConsumer, "$JFConsumer");
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.parameter(JFConsumer, NOT_PLATFORM, NOT_NULLABLE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$43$lambda$42$lambda$27$lambda$26 */
    public static final Unit m14072x7cfd8e2a(String JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(JLObject, "$JLObject");
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.returns(JLObject, NULLABLE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$43$lambda$42$lambda$29$lambda$28 */
    public static final Unit m14073xa6c6f3ae(String JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(JLObject, "$JLObject");
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.parameter(JLObject, NOT_PLATFORM);
        function.returns(JvmPrimitiveType.BOOLEAN);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$43$lambda$42$lambda$3$lambda$2 */
    public static final Unit m14074x66ef8b6e(SignatureBuildingComponents this_signatures, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(this_signatures, "$this_signatures");
        Intrinsics.checkNotNullParameter(function, "$this$function");
        String strJavaUtil = this_signatures.javaUtil("Spliterator");
        JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.returns(strJavaUtil, javaTypeQualifiers, javaTypeQualifiers);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$43$lambda$42$lambda$31$lambda$30 */
    public static final Unit m14075x753031c(String JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(JLObject, "$JLObject");
        Intrinsics.checkNotNullParameter(function, "$this$function");
        JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.parameter(JLObject, javaTypeQualifiers);
        function.parameter(JLObject, javaTypeQualifiers);
        function.returns(JvmPrimitiveType.BOOLEAN);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$43$lambda$42$lambda$33$lambda$32 */
    public static final Unit m14076x311c68a0(String JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(JLObject, "$JLObject");
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.parameter(JLObject, NOT_PLATFORM);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$43$lambda$42$lambda$35$lambda$34 */
    public static final Unit m14077x5ae5ce24(String JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(JLObject, "$JLObject");
        Intrinsics.checkNotNullParameter(function, "$this$function");
        JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.parameter(JLObject, javaTypeQualifiers);
        function.parameter(JLObject, javaTypeQualifiers);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$43$lambda$42$lambda$37$lambda$36 */
    public static final Unit m14078x84af33a8(String JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(JLObject, "$JLObject");
        Intrinsics.checkNotNullParameter(function, "$this$function");
        JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.parameter(JLObject, javaTypeQualifiers);
        function.returns(JLObject, javaTypeQualifiers);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$43$lambda$42$lambda$39$lambda$38 */
    public static final Unit m14079xae78992c(String JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(JLObject, "$JLObject");
        Intrinsics.checkNotNullParameter(function, "$this$function");
        JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.parameter(JLObject, javaTypeQualifiers);
        function.parameter(JLObject, javaTypeQualifiers);
        function.returns(JLObject, javaTypeQualifiers);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$43$lambda$42$lambda$41$lambda$40 */
    public static final Unit m14080xf04a89a(String JLObject, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(JLObject, "$JLObject");
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.returns(JLObject, NOT_PLATFORM);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$43$lambda$42$lambda$7$lambda$4 */
    public static final Unit m14081x38154fec(String JFPredicate, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(JFPredicate, "$JFPredicate");
        Intrinsics.checkNotNullParameter(function, "$this$function");
        JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.parameter(JFPredicate, javaTypeQualifiers, javaTypeQualifiers);
        function.returns(JvmPrimitiveType.BOOLEAN);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$43$lambda$42$lambda$7$lambda$5 */
    public static final Unit m14082x38154fed(String JUStream, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(JUStream, "$JUStream");
        Intrinsics.checkNotNullParameter(function, "$this$function");
        JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.returns(JUStream, javaTypeQualifiers, javaTypeQualifiers);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$43$lambda$42$lambda$7$lambda$6 */
    public static final Unit m14083x38154fee(String JUStream, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(JUStream, "$JUStream");
        Intrinsics.checkNotNullParameter(function, "$this$function");
        JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.returns(JUStream, javaTypeQualifiers, javaTypeQualifiers);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$43$lambda$42$lambda$9$lambda$8 */
    public static final Unit m14084x20a8322e(String JFUnaryOperator, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(JFUnaryOperator, "$JFUnaryOperator");
        Intrinsics.checkNotNullParameter(function, "$this$function");
        JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.parameter(JFUnaryOperator, javaTypeQualifiers, javaTypeQualifiers);
        return Unit.INSTANCE;
    }

    @NotNull
    public static final Map<String, PredefinedFunctionEnhancementInfo> getPREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE() {
        return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE;
    }
}
