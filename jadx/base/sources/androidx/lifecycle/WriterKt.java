package androidx.lifecycle;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.model.AdapterClass;
import androidx.lifecycle.model.AdapterClassKt;
import androidx.lifecycle.model.EventMethod;
import androidx.lifecycle.model.EventMethodCall;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.tools.StandardLocation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.p196io.CloseableKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt__IndentKt;
import org.jetbrains.annotations.NotNull;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000j\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002\u001a\u0018\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u0015H\u0002\u001a\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bH\u0002\u001a/\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010\u001a\u001a\u00020\u001b2\u0012\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001e0\u001d\"\u00020\u001eH\u0002¢\u0006\u0002\u0010 \u001a\u0018\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002\u001a\u001c\u0010$\u001a\u00020\u00112\f\u0010%\u001a\b\u0012\u0004\u0012\u00020#0&2\u0006\u0010\u0014\u001a\u00020\u0015\u001a\"\u0010'\u001a\u00020\u0011*\u00020(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020*0&2\u0006\u0010+\u001a\u00020,H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000\"\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000¨\u0006-"}, m13886d2 = {"EVENT_PARAM", "Lcom/squareup/javapoet/ParameterSpec;", "GENERATED_NAME", "", "GENERATED_PACKAGE", "HAS_LOGGER_VAR", "L", "LIFECYCLE_EVENT", "Ljava/lang/Class;", "Landroidx/lifecycle/Lifecycle$Event;", "METHODS_LOGGER", "N", "ON_ANY_PARAM", "OWNER_PARAM", "S", "T", "addGeneratedAnnotationIfAvailable", "", "adapterTypeSpecBuilder", "Lcom/squareup/javapoet/TypeSpec$Builder;", "processingEnv", "Ljavax/annotation/processing/ProcessingEnvironment;", "generateKeepRule", "type", "Ljavax/lang/model/element/TypeElement;", "generateParamString", "count", "", "takeParams", "", "", ActionHandler.PARAMS, "(I[Ljava/lang/Object;)[Ljava/lang/Object;", "writeAdapter", "adapter", "Landroidx/lifecycle/model/AdapterClass;", "writeModels", "infos", "", "writeMethodCalls", "Lcom/squareup/javapoet/MethodSpec$Builder;", "calls", "Landroidx/lifecycle/model/EventMethodCall;", "receiverField", "Lcom/squareup/javapoet/FieldSpec;", "lifecycle-compiler"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nwriter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 writer.kt\nandroidx/lifecycle/WriterKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 4 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 6 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,220:1\n1855#2,2:221\n1477#2:223\n1502#2,3:224\n1505#2,3:234\n1549#2:246\n1620#2,3:247\n1855#2,2:251\n361#3,7:227\n467#3,7:237\n215#4,2:244\n1#5:250\n37#6,2:253\n*S KotlinDebug\n*F\n+ 1 writer.kt\nandroidx/lifecycle/WriterKt\n*L\n36#1:221,2\n78#1:223\n78#1:224,3\n78#1:234,3\n96#1:246\n96#1:247,3\n183#1:251,2\n78#1:227,7\n84#1:237,7\n85#1:244,2\n217#1:253,2\n*E\n"})
public final class WriterKt {

    @NotNull
    private static final ParameterSpec EVENT_PARAM;

    @NotNull
    private static final String GENERATED_NAME = "Generated";

    @NotNull
    private static final String GENERATED_PACKAGE = "javax.annotation";

    @NotNull
    private static final String HAS_LOGGER_VAR = "hasLogger";

    /* JADX INFO: renamed from: L */
    @NotNull
    private static final String f1618L = "$L";

    @NotNull
    private static final Class<Lifecycle.Event> LIFECYCLE_EVENT = Lifecycle.Event.class;

    @NotNull
    private static final ParameterSpec METHODS_LOGGER;

    /* JADX INFO: renamed from: N */
    @NotNull
    private static final String f1619N = "$N";

    @NotNull
    private static final ParameterSpec ON_ANY_PARAM;

    @NotNull
    private static final ParameterSpec OWNER_PARAM;

    /* JADX INFO: renamed from: S */
    @NotNull
    private static final String f1620S = "$S";

    /* JADX INFO: renamed from: T */
    @NotNull
    private static final String f1621T = "$T";

    static {
        ParameterSpec parameterSpecBuild = ParameterSpec.builder(ClassName.get((Class<?>) LifecycleOwner.class), "owner", new Modifier[0]).build();
        Intrinsics.checkNotNullExpressionValue(parameterSpecBuild, "builder(\n    ClassName.g….java), \"owner\"\n).build()");
        OWNER_PARAM = parameterSpecBuild;
        ParameterSpec parameterSpecBuild2 = ParameterSpec.builder(ClassName.get((Class<?>) Lifecycle.Event.class), "event", new Modifier[0]).build();
        Intrinsics.checkNotNullExpressionValue(parameterSpecBuild2, "builder(\n    ClassName.g…EVENT), \"event\"\n).build()");
        EVENT_PARAM = parameterSpecBuild2;
        ParameterSpec parameterSpecBuild3 = ParameterSpec.builder(TypeName.BOOLEAN, "onAny", new Modifier[0]).build();
        Intrinsics.checkNotNullExpressionValue(parameterSpecBuild3, "builder(TypeName.BOOLEAN, \"onAny\").build()");
        ON_ANY_PARAM = parameterSpecBuild3;
        ParameterSpec parameterSpecBuild4 = ParameterSpec.builder(ClassName.get((Class<?>) MethodCallsLogger.class), "logger", new Modifier[0]).build();
        Intrinsics.checkNotNullExpressionValue(parameterSpecBuild4, "builder(\n    ClassName.g…java), \"logger\"\n).build()");
        METHODS_LOGGER = parameterSpecBuild4;
    }

    private static final void addGeneratedAnnotationIfAvailable(TypeSpec.Builder builder, ProcessingEnvironment processingEnvironment) {
        Elements elementUtils = processingEnvironment.getElementUtils();
        String str = GENERATED_PACKAGE;
        String str2 = GENERATED_NAME;
        if (elementUtils.getTypeElement(AbstractC0541b.m757C(str, Extension.DOT, str2)) != null) {
            builder.addAnnotation(AnnotationSpec.builder(ClassName.get(str, str2, new String[0])).addMember("value", f1620S, LifecycleProcessor.class.getCanonicalName()).build());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void generateKeepRule(TypeElement typeElement, ProcessingEnvironment processingEnvironment) {
        String strM757C = AbstractC0541b.m757C(Elements_extKt.getPackageQName((Element) typeElement), Extension.DOT, AdapterClassKt.getAdapterName(typeElement));
        String string = typeElement.toString();
        String strTrimMargin$default = StringsKt__IndentKt.trimMargin$default("# Generated keep rule for Lifecycle observer adapter.\n        |-if class " + string + " {\n        |    <init>(...);\n        |}\n        |-keep class " + strM757C + " {\n        |    <init>(...);\n        |}\n        |", null, 1, null);
        Writer writerOpenWriter = processingEnvironment.getFiler().createResource(StandardLocation.CLASS_OUTPUT, "", AbstractC0541b.m773o("META-INF/proguard/", string, ".pro"), new Element[]{typeElement}).openWriter();
        try {
            writerOpenWriter.write(strTrimMargin$default);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(writerOpenWriter, null);
        } finally {
        }
    }

    private static final String generateParamString(int i) {
        return CollectionsKt.m13955n(RangesKt.until(0, i), ",", null, null, new Function1<Integer, CharSequence>() { // from class: androidx.lifecycle.WriterKt.generateParamString.1
            @NotNull
            public final CharSequence invoke(int i2) {
                return WriterKt.f1619N;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ CharSequence invoke(Integer num) {
                return invoke(num.intValue());
            }
        }, 30);
    }

    private static final Object[] takeParams(int i, Object... objArr) {
        return ArraysKt.take(objArr, i).toArray(new Object[0]);
    }

    private static final void writeAdapter(AdapterClass adapterClass, ProcessingEnvironment processingEnvironment) throws Exception {
        int i = 1;
        char c = 0;
        FieldSpec fieldSpecBuild = FieldSpec.builder(ClassName.get(adapterClass.getType()), "mReceiver", Modifier.FINAL).build();
        Intrinsics.checkNotNullExpressionValue(fieldSpecBuild, "builder(\n        ClassNa…ifier.FINAL\n    ).build()");
        MethodSpec.Builder builderAddParameter = MethodSpec.methodBuilder("callMethods").returns(TypeName.VOID).addParameter(OWNER_PARAM).addParameter(EVENT_PARAM).addParameter(ON_ANY_PARAM);
        ParameterSpec parameterSpec = METHODS_LOGGER;
        MethodSpec.Builder writeAdapter$lambda$5$lambda$4 = builderAddParameter.addParameter(parameterSpec).addModifiers(Modifier.PUBLIC).addAnnotation(Override.class);
        writeAdapter$lambda$5$lambda$4.addStatement(AbstractC0541b.m775q("boolean ", f1618L, " = ", f1619N, " != null"), HAS_LOGGER_VAR, parameterSpec);
        List<EventMethodCall> calls = adapterClass.getCalls();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : calls) {
            Lifecycle.Event eventValue = ((EventMethodCall) obj).getMethod().getOnLifecycleEvent().value();
            Object arrayList = linkedHashMap.get(eventValue);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(eventValue, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        MethodSpec.Builder writeAdapter$lambda$5$lambda$2 = writeAdapter$lambda$5$lambda$4.beginControlFlow(AbstractC0541b.m773o("if (", f1619N, ")"), ON_ANY_PARAM);
        Intrinsics.checkNotNullExpressionValue(writeAdapter$lambda$5$lambda$2, "writeAdapter$lambda$5$lambda$2");
        List listEmptyList = (List) linkedHashMap.get(Lifecycle.Event.ON_ANY);
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        writeMethodCalls(writeAdapter$lambda$5$lambda$2, listEmptyList, fieldSpecBuild);
        writeAdapter$lambda$5$lambda$2.endControlFlow();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (((Lifecycle.Event) entry.getKey()) != Lifecycle.Event.ON_ANY) {
                linkedHashMap2.put(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
            Lifecycle.Event event = (Lifecycle.Event) entry2.getKey();
            List list = (List) entry2.getValue();
            writeAdapter$lambda$5$lambda$4.beginControlFlow(AbstractC0622a.m1170p(f1618L, ")", AbstractC0000a.m16m("if (", f1619N, " == ", f1621T, Extension.DOT)), EVENT_PARAM, LIFECYCLE_EVENT, event);
            Intrinsics.checkNotNullExpressionValue(writeAdapter$lambda$5$lambda$4, "writeAdapter$lambda$5$lambda$4");
            writeMethodCalls(writeAdapter$lambda$5$lambda$4, list, fieldSpecBuild);
            writeAdapter$lambda$5$lambda$4.endControlFlow();
        }
        MethodSpec methodSpecBuild = writeAdapter$lambda$5$lambda$4.build();
        ParameterSpec parameterSpecBuild = ParameterSpec.builder(ClassName.get(adapterClass.getType()), "receiver", new Modifier[0]).build();
        Set<ExecutableElement> syntheticMethods = adapterClass.getSyntheticMethods();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.m13952k(syntheticMethods));
        for (ExecutableElement executableElement : syntheticMethods) {
            MethodSpec.Builder builderReturns = MethodSpec.methodBuilder(Elements_extKt.syntheticName(executableElement)).returns(TypeName.VOID);
            Modifier[] modifierArr = new Modifier[i];
            modifierArr[c] = Modifier.PUBLIC;
            MethodSpec.Builder builderAddModifiers = builderReturns.addModifiers(modifierArr);
            Modifier[] modifierArr2 = new Modifier[i];
            modifierArr2[c] = Modifier.STATIC;
            MethodSpec.Builder builderAddParameter2 = builderAddModifiers.addModifiers(modifierArr2).addParameter(parameterSpecBuild);
            if (executableElement.getParameters().size() >= i) {
                builderAddParameter2.addParameter(OWNER_PARAM);
            }
            if (executableElement.getParameters().size() == 2) {
                builderAddParameter2.addParameter(EVENT_PARAM);
            }
            int size = executableElement.getParameters().size();
            char c2 = c;
            StringBuilder sbM2228s = AbstractC2821a.m2228s(f1619N, Extension.DOT, f1618L, "(", generateParamString(size));
            sbM2228s.append(")");
            String string = sbM2228s.toString();
            SpreadBuilder spreadBuilder = new SpreadBuilder(3);
            spreadBuilder.add(parameterSpecBuild);
            spreadBuilder.add(Elements_extKt.name(executableElement));
            spreadBuilder.addSpread(takeParams(size, OWNER_PARAM, EVENT_PARAM));
            builderAddParameter2.addStatement(string, spreadBuilder.toArray(new Object[spreadBuilder.size()]));
            arrayList2.add(builderAddParameter2.build());
            c = c2;
            i = 1;
        }
        char c4 = c;
        MethodSpec.Builder builderAddParameter3 = MethodSpec.constructorBuilder().addParameter(parameterSpecBuild);
        String str = f1619N;
        MethodSpec methodSpecBuild2 = builderAddParameter3.addStatement(AbstractC0541b.m774p("this.", str, " = ", str), fieldSpecBuild, parameterSpecBuild).build();
        TypeSpec.Builder builderClassBuilder = TypeSpec.classBuilder(AdapterClassKt.getAdapterName(adapterClass.getType()));
        Modifier[] modifierArr3 = new Modifier[1];
        modifierArr3[c4] = Modifier.PUBLIC;
        TypeSpec.Builder adapterTypeSpecBuilder = builderClassBuilder.addModifiers(modifierArr3).addSuperinterface(ClassName.get((Class<?>) GeneratedAdapter.class)).addField(fieldSpecBuild).addMethod(methodSpecBuild2).addMethod(methodSpecBuild).addMethods(arrayList2).addOriginatingElement((Element) adapterClass.getType());
        Intrinsics.checkNotNullExpressionValue(adapterTypeSpecBuilder, "adapterTypeSpecBuilder");
        addGeneratedAnnotationIfAvailable(adapterTypeSpecBuilder, processingEnvironment);
        JavaFile.builder(Elements_extKt.getPackageQName(adapterClass.getType()), adapterTypeSpecBuilder.build()).build().writeTo(processingEnvironment.getFiler());
        generateKeepRule(adapterClass.getType(), processingEnvironment);
    }

    private static final void writeMethodCalls(MethodSpec.Builder builder, List<EventMethodCall> list, FieldSpec fieldSpec) {
        for (EventMethodCall eventMethodCall : list) {
            EventMethod method = eventMethodCall.getMethod();
            Element syntheticAccess = eventMethodCall.getSyntheticAccess();
            int size = method.getMethod().getParameters().size();
            String strName = Elements_extKt.name(method.getMethod());
            String str = f1618L;
            String str2 = f1619N;
            String str3 = f1620S;
            StringBuilder sbM16m = AbstractC0000a.m16m("if (!", str, " || ", str2, ".approveCall(");
            sbM16m.append(str3);
            sbM16m.append(SQLKeyword.COMMA);
            sbM16m.append(1 << size);
            sbM16m.append("))");
            MethodSpec.Builder builderBeginControlFlow = builder.beginControlFlow(sbM16m.toString(), HAS_LOGGER_VAR, METHODS_LOGGER, strName);
            if (syntheticAccess == null) {
                StringBuilder sbM2228s = AbstractC2821a.m2228s(str2, Extension.DOT, str, "(", generateParamString(size));
                sbM2228s.append(")");
                String string = sbM2228s.toString();
                SpreadBuilder spreadBuilder = new SpreadBuilder(3);
                spreadBuilder.add(fieldSpec);
                spreadBuilder.add(strName);
                spreadBuilder.addSpread(takeParams(size, OWNER_PARAM, EVENT_PARAM));
                builderBeginControlFlow.addStatement(string, spreadBuilder.toArray(new Object[spreadBuilder.size()]));
            } else {
                int i = size + 1;
                String strGenerateParamString = generateParamString(i);
                ClassName className = ClassName.get(Elements_extKt.getPackageQName(syntheticAccess), AdapterClassKt.getAdapterName(syntheticAccess), new String[0]);
                StringBuilder sbM2228s2 = AbstractC2821a.m2228s(f1621T, Extension.DOT, str, "(", strGenerateParamString);
                sbM2228s2.append(")");
                String string2 = sbM2228s2.toString();
                SpreadBuilder spreadBuilder2 = new SpreadBuilder(3);
                spreadBuilder2.add(className);
                spreadBuilder2.add(Elements_extKt.syntheticName(method.getMethod()));
                spreadBuilder2.addSpread(takeParams(i, fieldSpec, OWNER_PARAM, EVENT_PARAM));
                builderBeginControlFlow.addStatement(string2, spreadBuilder2.toArray(new Object[spreadBuilder2.size()]));
            }
            builderBeginControlFlow.endControlFlow();
        }
        builder.addStatement("return", new Object[0]);
    }

    public static final void writeModels(@NotNull List<AdapterClass> infos, @NotNull ProcessingEnvironment processingEnv) {
        Intrinsics.checkNotNullParameter(infos, "infos");
        Intrinsics.checkNotNullParameter(processingEnv, "processingEnv");
        Iterator<T> it = infos.iterator();
        while (it.hasNext()) {
            writeAdapter((AdapterClass) it.next(), processingEnv);
        }
    }
}
