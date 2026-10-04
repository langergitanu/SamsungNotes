package kotlin.reflect.jvm.internal.impl.types.checker;

import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.Collection;
import java.util.List;
import kotlin.collections.AbstractC12991c;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.ModalityUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedType;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType;
import kotlin.reflect.jvm.internal.impl.types.DynamicType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.NotNullTypeParameter;
import kotlin.reflect.jvm.internal.impl.types.RawType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SimpleTypeWithEnhancement;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DynamicTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContextKt;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemInferenceExtensionContext;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariableTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface ClassicTypeSystemContext extends TypeSystemCommonBackendContext, TypeSystemInferenceExtensionContext {
    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    @Nullable
    CapturedTypeMarker asCapturedType(@NotNull SimpleTypeMarker simpleTypeMarker);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    @Nullable
    SimpleTypeMarker asSimpleType(@NotNull KotlinTypeMarker kotlinTypeMarker);

    @NotNull
    KotlinTypeMarker createFlexibleType(@NotNull SimpleTypeMarker simpleTypeMarker, @NotNull SimpleTypeMarker simpleTypeMarker2);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    boolean isSingleClassifierType(@NotNull SimpleTypeMarker simpleTypeMarker);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    @NotNull
    SimpleTypeMarker lowerBound(@NotNull FlexibleTypeMarker flexibleTypeMarker);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    @NotNull
    TypeConstructorMarker typeConstructor(@NotNull SimpleTypeMarker simpleTypeMarker);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    @NotNull
    SimpleTypeMarker upperBound(@NotNull FlexibleTypeMarker flexibleTypeMarker);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    @NotNull
    SimpleTypeMarker withNullability(@NotNull SimpleTypeMarker simpleTypeMarker, boolean z);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @SourceDebugExtension({"SMAP\nClassicTypeSystemContext.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClassicTypeSystemContext.kt\norg/jetbrains/kotlin/types/checker/ClassicTypeSystemContext$DefaultImpls\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ClassicTypeSystemContext.kt\norg/jetbrains/kotlin/types/checker/ClassicTypeSystemContextKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 addToStdlib.kt\norg/jetbrains/kotlin/utils/addToStdlib/AddToStdlibKt\n+ 6 TypeUtils.kt\norg/jetbrains/kotlin/types/typeUtil/TypeUtilsKt\n*L\n1#1,975:1\n1#2:976\n969#3:977\n969#3:978\n969#3:979\n969#3:980\n969#3:981\n969#3:982\n969#3:983\n969#3:984\n969#3:985\n969#3:986\n969#3:987\n969#3:988\n969#3:989\n969#3:990\n969#3:991\n969#3:992\n969#3:993\n969#3:994\n969#3:995\n969#3:996\n969#3:997\n969#3:998\n969#3:999\n969#3:1000\n969#3:1001\n969#3:1002\n969#3:1003\n969#3:1004\n969#3:1005\n969#3:1006\n969#3:1007\n969#3:1008\n969#3:1009\n969#3:1010\n969#3:1011\n969#3:1012\n969#3:1013\n969#3:1014\n969#3:1015\n969#3:1016\n969#3:1017\n969#3:1018\n969#3:1019\n969#3:1020\n969#3:1021\n969#3:1022\n969#3:1023\n969#3:1024\n969#3:1025\n969#3:1026\n969#3:1027\n969#3:1028\n969#3:1029\n969#3:1030\n969#3:1031\n969#3:1032\n969#3:1033\n969#3:1034\n969#3:1035\n969#3:1036\n969#3:1037\n969#3:1038\n969#3:1039\n969#3:1040\n969#3:1041\n969#3:1042\n969#3:1043\n969#3:1044\n969#3:1045\n969#3:1046\n969#3:1047\n969#3:1048\n969#3:1049\n969#3:1050\n969#3:1054\n969#3:1055\n969#3:1056\n969#3:1057\n969#3:1058\n969#3:1059\n969#3:1060\n969#3:1061\n969#3:1067\n969#3:1068\n969#3:1069\n969#3:1070\n969#3:1071\n969#3:1072\n969#3:1079\n969#3:1080\n969#3:1081\n969#3:1096\n969#3:1097\n969#3:1098\n969#3:1099\n969#3:1100\n969#3:1101\n969#3:1115\n969#3:1116\n969#3:1117\n969#3:1118\n969#3:1119\n969#3:1120\n969#3:1121\n969#3:1122\n969#3:1123\n969#3:1124\n969#3:1125\n969#3:1126\n969#3:1127\n969#3:1128\n969#3:1129\n969#3:1130\n969#3:1131\n969#3:1132\n969#3:1133\n969#3:1134\n969#3:1135\n969#3:1136\n969#3:1137\n969#3:1138\n969#3:1139\n969#3:1140\n827#4:1051\n855#4,2:1052\n774#4:1064\n865#4,2:1065\n1557#4:1075\n1628#4,3:1076\n1557#4:1082\n1628#4,3:1083\n2669#4,7:1086\n827#4:1093\n855#4,2:1094\n827#4:1102\n855#4,2:1103\n1557#4:1105\n1628#4,3:1106\n1279#4,2:1109\n1293#4,4:1111\n20#5,2:1062\n280#6,2:1073\n*S KotlinDebug\n*F\n+ 1 ClassicTypeSystemContext.kt\norg/jetbrains/kotlin/types/checker/ClassicTypeSystemContext$DefaultImpls\n*L\n41#1:977\n46#1:978\n59#1:979\n64#1:980\n70#1:981\n76#1:982\n81#1:983\n86#1:984\n91#1:985\n96#1:986\n101#1:987\n106#1:988\n111#1:989\n120#1:990\n126#1:991\n131#1:992\n136#1:993\n137#1:994\n142#1:995\n147#1:996\n152#1:997\n157#1:998\n166#1:999\n171#1:1000\n176#1:1001\n181#1:1002\n189#1:1003\n194#1:1004\n199#1:1005\n204#1:1006\n209#1:1007\n214#1:1008\n219#1:1009\n224#1:1010\n229#1:1011\n234#1:1012\n235#1:1013\n240#1:1014\n246#1:1015\n251#1:1016\n256#1:1017\n261#1:1018\n266#1:1019\n271#1:1020\n276#1:1021\n281#1:1022\n286#1:1023\n291#1:1024\n292#1:1025\n298#1:1026\n299#1:1027\n304#1:1028\n309#1:1029\n314#1:1030\n320#1:1031\n328#1:1032\n334#1:1033\n339#1:1034\n344#1:1035\n349#1:1036\n354#1:1037\n359#1:1038\n364#1:1039\n378#1:1040\n388#1:1041\n393#1:1042\n419#1:1043\n424#1:1044\n429#1:1045\n430#1:1046\n470#1:1047\n476#1:1048\n481#1:1049\n486#1:1050\n492#1:1054\n497#1:1055\n514#1:1056\n520#1:1057\n525#1:1058\n530#1:1059\n541#1:1060\n552#1:1061\n575#1:1067\n580#1:1068\n585#1:1069\n592#1:1070\n597#1:1071\n603#1:1072\n608#1:1079\n635#1:1080\n636#1:1081\n692#1:1096\n697#1:1097\n702#1:1098\n707#1:1099\n712#1:1100\n717#1:1101\n755#1:1115\n760#1:1116\n765#1:1117\n770#1:1118\n775#1:1119\n780#1:1120\n785#1:1121\n790#1:1122\n795#1:1123\n800#1:1124\n805#1:1125\n810#1:1126\n815#1:1127\n820#1:1128\n825#1:1129\n830#1:1130\n835#1:1131\n840#1:1132\n845#1:1133\n854#1:1134\n855#1:1135\n866#1:1136\n871#1:1137\n876#1:1138\n907#1:1139\n914#1:1140\n487#1:1051\n487#1:1052,2\n560#1:1064\n560#1:1065,2\n604#1:1075\n604#1:1076,3\n678#1:1082\n678#1:1083,3\n678#1:1086,7\n684#1:1093\n684#1:1094,2\n718#1:1102\n718#1:1103,2\n743#1:1105\n743#1:1106,3\n744#1:1109,2\n744#1:1111,4\n554#1:1062,2\n604#1:1073,2\n*E\n"})
    public static final class DefaultImpls {
        public static boolean areEqualTypeConstructors(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker c12, @NotNull TypeConstructorMarker c2) {
            Intrinsics.checkNotNullParameter(c12, "c1");
            Intrinsics.checkNotNullParameter(c2, "c2");
            if (!(c12 instanceof TypeConstructor)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + c12 + SQLKeyword.COMMA + Reflection.getOrCreateKotlinClass(c12.getClass())).toString());
            }
            if (c2 instanceof TypeConstructor) {
                return Intrinsics.areEqual(c12, c2);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + c2 + SQLKeyword.COMMA + Reflection.getOrCreateKotlinClass(c2.getClass())).toString());
        }

        public static int argumentsCount(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof KotlinType) {
                return ((KotlinType) receiver).getArguments().size();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + SQLKeyword.COMMA + Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        @NotNull
        public static TypeArgumentListMarker asArgumentList(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof SimpleType) {
                return (TypeArgumentListMarker) receiver;
            }
            StringBuilder sbM13992m = AbstractC12991c.m13992m("ClassicTypeSystemContext couldn't handle: ", receiver, SQLKeyword.COMMA);
            sbM13992m.append(Reflection.getOrCreateKotlinClass(receiver.getClass()));
            throw new IllegalArgumentException(sbM13992m.toString().toString());
        }

        @Nullable
        public static CapturedTypeMarker asCapturedType(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (!(receiver instanceof SimpleType)) {
                StringBuilder sbM13992m = AbstractC12991c.m13992m("ClassicTypeSystemContext couldn't handle: ", receiver, SQLKeyword.COMMA);
                sbM13992m.append(Reflection.getOrCreateKotlinClass(receiver.getClass()));
                throw new IllegalArgumentException(sbM13992m.toString().toString());
            }
            if (receiver instanceof SimpleTypeWithEnhancement) {
                return classicTypeSystemContext.asCapturedType(((SimpleTypeWithEnhancement) receiver).getOrigin());
            }
            if (receiver instanceof NewCapturedType) {
                return (NewCapturedType) receiver;
            }
            return null;
        }

        @Nullable
        public static DefinitelyNotNullTypeMarker asDefinitelyNotNullType(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof SimpleType) {
                if (receiver instanceof DefinitelyNotNullType) {
                    return (DefinitelyNotNullType) receiver;
                }
                return null;
            }
            StringBuilder sbM13992m = AbstractC12991c.m13992m("ClassicTypeSystemContext couldn't handle: ", receiver, SQLKeyword.COMMA);
            sbM13992m.append(Reflection.getOrCreateKotlinClass(receiver.getClass()));
            throw new IllegalArgumentException(sbM13992m.toString().toString());
        }

        @Nullable
        public static DynamicTypeMarker asDynamicType(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull FlexibleTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof FlexibleType) {
                if (receiver instanceof DynamicType) {
                    return (DynamicType) receiver;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + SQLKeyword.COMMA + Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        @Nullable
        public static FlexibleTypeMarker asFlexibleType(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof KotlinType) {
                UnwrappedType unwrappedTypeUnwrap = ((KotlinType) receiver).unwrap();
                if (unwrappedTypeUnwrap instanceof FlexibleType) {
                    return (FlexibleType) unwrappedTypeUnwrap;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + SQLKeyword.COMMA + Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        @Nullable
        public static SimpleTypeMarker asSimpleType(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof KotlinType) {
                UnwrappedType unwrappedTypeUnwrap = ((KotlinType) receiver).unwrap();
                if (unwrappedTypeUnwrap instanceof SimpleType) {
                    return (SimpleType) unwrappedTypeUnwrap;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + SQLKeyword.COMMA + Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        @NotNull
        public static TypeArgumentMarker asTypeArgument(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof KotlinType) {
                return TypeUtilsKt.asTypeProjection((KotlinType) receiver);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + SQLKeyword.COMMA + Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        @Nullable
        public static SimpleTypeMarker captureFromArguments(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker type, @NotNull CaptureStatus status) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(status, "status");
            if (type instanceof SimpleType) {
                return NewCapturedTypeKt.captureFromArguments((SimpleType) type, status);
            }
            StringBuilder sbM13992m = AbstractC12991c.m13992m("ClassicTypeSystemContext couldn't handle: ", type, SQLKeyword.COMMA);
            sbM13992m.append(Reflection.getOrCreateKotlinClass(type.getClass()));
            throw new IllegalArgumentException(sbM13992m.toString().toString());
        }

        @NotNull
        public static CaptureStatus captureStatus(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull CapturedTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof NewCapturedType) {
                return ((NewCapturedType) receiver).getCaptureStatus();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + SQLKeyword.COMMA + Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        @NotNull
        public static KotlinTypeMarker createFlexibleType(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker lowerBound, @NotNull SimpleTypeMarker upperBound) {
            Intrinsics.checkNotNullParameter(lowerBound, "lowerBound");
            Intrinsics.checkNotNullParameter(upperBound, "upperBound");
            if (!(lowerBound instanceof SimpleType)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + classicTypeSystemContext + SQLKeyword.COMMA + Reflection.getOrCreateKotlinClass(classicTypeSystemContext.getClass())).toString());
            }
            if (upperBound instanceof SimpleType) {
                return KotlinTypeFactory.flexibleType((SimpleType) lowerBound, (SimpleType) upperBound);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + classicTypeSystemContext + SQLKeyword.COMMA + Reflection.getOrCreateKotlinClass(classicTypeSystemContext.getClass())).toString());
        }

        @NotNull
        public static TypeArgumentMarker getArgument(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker receiver, int i) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof KotlinType) {
                return ((KotlinType) receiver).getArguments().get(i);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + SQLKeyword.COMMA + Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        @NotNull
        public static List<TypeArgumentMarker> getArguments(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof KotlinType) {
                return ((KotlinType) receiver).getArguments();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + SQLKeyword.COMMA + Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        @NotNull
        public static FqNameUnsafe getClassFqNameUnsafe(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof TypeConstructor) {
                ClassifierDescriptor classifierDescriptorMo23493getDeclarationDescriptor = ((TypeConstructor) receiver).mo23493getDeclarationDescriptor();
                Intrinsics.checkNotNull(classifierDescriptorMo23493getDeclarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                return DescriptorUtilsKt.getFqNameUnsafe((ClassDescriptor) classifierDescriptorMo23493getDeclarationDescriptor);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + SQLKeyword.COMMA + Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        @NotNull
        public static TypeParameterMarker getParameter(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker receiver, int i) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof TypeConstructor) {
                TypeParameterDescriptor typeParameterDescriptor = ((TypeConstructor) receiver).getParameters().get(i);
                Intrinsics.checkNotNullExpressionValue(typeParameterDescriptor, "get(...)");
                return typeParameterDescriptor;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + SQLKeyword.COMMA + Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        @NotNull
        public static List<TypeParameterMarker> getParameters(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof TypeConstructor) {
                List<TypeParameterDescriptor> parameters = ((TypeConstructor) receiver).getParameters();
                Intrinsics.checkNotNullExpressionValue(parameters, "getParameters(...)");
                return parameters;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + SQLKeyword.COMMA + Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        @Nullable
        public static PrimitiveType getPrimitiveArrayType(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof TypeConstructor) {
                ClassifierDescriptor classifierDescriptorMo23493getDeclarationDescriptor = ((TypeConstructor) receiver).mo23493getDeclarationDescriptor();
                Intrinsics.checkNotNull(classifierDescriptorMo23493getDeclarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                return KotlinBuiltIns.getPrimitiveArrayType((ClassDescriptor) classifierDescriptorMo23493getDeclarationDescriptor);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + SQLKeyword.COMMA + Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        @Nullable
        public static PrimitiveType getPrimitiveType(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof TypeConstructor) {
                ClassifierDescriptor classifierDescriptorMo23493getDeclarationDescriptor = ((TypeConstructor) receiver).mo23493getDeclarationDescriptor();
                Intrinsics.checkNotNull(classifierDescriptorMo23493getDeclarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                return KotlinBuiltIns.getPrimitiveType((ClassDescriptor) classifierDescriptorMo23493getDeclarationDescriptor);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + SQLKeyword.COMMA + Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        @NotNull
        public static KotlinTypeMarker getRepresentativeUpperBound(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeParameterMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof TypeParameterDescriptor) {
                return TypeUtilsKt.getRepresentativeUpperBound((TypeParameterDescriptor) receiver);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + SQLKeyword.COMMA + Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        @NotNull
        public static KotlinTypeMarker getType(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeArgumentMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof TypeProjection) {
                return ((TypeProjection) receiver).getType().unwrap();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + SQLKeyword.COMMA + Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        @Nullable
        public static TypeParameterMarker getTypeParameter(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeVariableTypeConstructorMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof NewTypeVariableConstructor) {
                return ((NewTypeVariableConstructor) receiver).getOriginalTypeParameter();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + SQLKeyword.COMMA + Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        @Nullable
        public static TypeParameterMarker getTypeParameterClassifier(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof TypeConstructor) {
                ClassifierDescriptor classifierDescriptorMo23493getDeclarationDescriptor = ((TypeConstructor) receiver).mo23493getDeclarationDescriptor();
                if (classifierDescriptorMo23493getDeclarationDescriptor instanceof TypeParameterDescriptor) {
                    return (TypeParameterDescriptor) classifierDescriptorMo23493getDeclarationDescriptor;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + SQLKeyword.COMMA + Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        @Nullable
        public static KotlinTypeMarker getUnsubstitutedUnderlyingType(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof KotlinType) {
                return InlineClassesUtilsKt.unsubstitutedUnderlyingType((KotlinType) receiver);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + SQLKeyword.COMMA + Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        @NotNull
        public static List<KotlinTypeMarker> getUpperBounds(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeParameterMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof TypeParameterDescriptor) {
                List<KotlinType> upperBounds = ((TypeParameterDescriptor) receiver).getUpperBounds();
                Intrinsics.checkNotNullExpressionValue(upperBounds, "getUpperBounds(...)");
                return upperBounds;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + SQLKeyword.COMMA + Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        @NotNull
        public static TypeVariance getVariance(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeArgumentMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof TypeProjection) {
                Variance projectionKind = ((TypeProjection) receiver).getProjectionKind();
                Intrinsics.checkNotNullExpressionValue(projectionKind, "getProjectionKind(...)");
                return TypeSystemContextKt.convertVariance(projectionKind);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + SQLKeyword.COMMA + Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static boolean hasAnnotation(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker receiver, @NotNull FqName fqName) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            Intrinsics.checkNotNullParameter(fqName, "fqName");
            if (receiver instanceof KotlinType) {
                return ((KotlinType) receiver).getAnnotations().hasAnnotation(fqName);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + SQLKeyword.COMMA + Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static boolean hasRecursiveBounds(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeParameterMarker receiver, @Nullable TypeConstructorMarker typeConstructorMarker) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (!(receiver instanceof TypeParameterDescriptor)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + SQLKeyword.COMMA + Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
            }
            TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) receiver;
            if (typeConstructorMarker == null ? true : typeConstructorMarker instanceof TypeConstructor) {
                return TypeUtilsKt.hasTypeParameterRecursiveBounds$default(typeParameterDescriptor, (TypeConstructor) typeConstructorMarker, null, 4, null);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeParameterDescriptor + SQLKeyword.COMMA + Reflection.getOrCreateKotlinClass(typeParameterDescriptor.getClass())).toString());
        }

        public static boolean identicalArguments(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker a, @NotNull SimpleTypeMarker b) {
            Intrinsics.checkNotNullParameter(a, "a");
            Intrinsics.checkNotNullParameter(b, "b");
            if (!(a instanceof SimpleType)) {
                StringBuilder sbM13992m = AbstractC12991c.m13992m("ClassicTypeSystemContext couldn't handle: ", a, SQLKeyword.COMMA);
                sbM13992m.append(Reflection.getOrCreateKotlinClass(a.getClass()));
                throw new IllegalArgumentException(sbM13992m.toString().toString());
            }
            if (b instanceof SimpleType) {
                return ((SimpleType) a).getArguments() == ((SimpleType) b).getArguments();
            }
            StringBuilder sbM13992m2 = AbstractC12991c.m13992m("ClassicTypeSystemContext couldn't handle: ", b, SQLKeyword.COMMA);
            sbM13992m2.append(Reflection.getOrCreateKotlinClass(b.getClass()));
            throw new IllegalArgumentException(sbM13992m2.toString().toString());
        }

        @NotNull
        public static KotlinTypeMarker intersectTypes(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull List<? extends KotlinTypeMarker> types) {
            Intrinsics.checkNotNullParameter(types, "types");
            return IntersectionTypeKt.intersectTypes(types);
        }

        public static boolean isAnyConstructor(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof TypeConstructor) {
                return KotlinBuiltIns.isTypeConstructorForGivenClass((TypeConstructor) receiver, StandardNames.FqNames.any);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + SQLKeyword.COMMA + Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static boolean isClassTypeConstructor(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof TypeConstructor) {
                return ((TypeConstructor) receiver).mo23493getDeclarationDescriptor() instanceof ClassDescriptor;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + SQLKeyword.COMMA + Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static boolean isCommonFinalClassConstructor(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof TypeConstructor) {
                ClassifierDescriptor classifierDescriptorMo23493getDeclarationDescriptor = ((TypeConstructor) receiver).mo23493getDeclarationDescriptor();
                ClassDescriptor classDescriptor = classifierDescriptorMo23493getDeclarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) classifierDescriptorMo23493getDeclarationDescriptor : null;
                return (classDescriptor == null || !ModalityUtilsKt.isFinalClass(classDescriptor) || classDescriptor.getKind() == ClassKind.ENUM_ENTRY || classDescriptor.getKind() == ClassKind.ANNOTATION_CLASS) ? false : true;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + SQLKeyword.COMMA + Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static boolean isDenotable(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof TypeConstructor) {
                return ((TypeConstructor) receiver).isDenotable();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + SQLKeyword.COMMA + Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static boolean isError(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof KotlinType) {
                return KotlinTypeKt.isError((KotlinType) receiver);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + SQLKeyword.COMMA + Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static boolean isInlineClass(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof TypeConstructor) {
                ClassifierDescriptor classifierDescriptorMo23493getDeclarationDescriptor = ((TypeConstructor) receiver).mo23493getDeclarationDescriptor();
                ClassDescriptor classDescriptor = classifierDescriptorMo23493getDeclarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) classifierDescriptorMo23493getDeclarationDescriptor : null;
                return (classDescriptor != null ? classDescriptor.getValueClassRepresentation() : null) instanceof InlineClassRepresentation;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + SQLKeyword.COMMA + Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static boolean isIntegerLiteralTypeConstructor(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof TypeConstructor) {
                return receiver instanceof IntegerLiteralTypeConstructor;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + SQLKeyword.COMMA + Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static boolean isIntersection(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof TypeConstructor) {
                return receiver instanceof IntersectionTypeConstructor;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + SQLKeyword.COMMA + Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static boolean isK2(@NotNull ClassicTypeSystemContext classicTypeSystemContext) {
            return false;
        }

        public static boolean isMarkedNullable(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof SimpleType) {
                return ((SimpleType) receiver).isMarkedNullable();
            }
            StringBuilder sbM13992m = AbstractC12991c.m13992m("ClassicTypeSystemContext couldn't handle: ", receiver, SQLKeyword.COMMA);
            sbM13992m.append(Reflection.getOrCreateKotlinClass(receiver.getClass()));
            throw new IllegalArgumentException(sbM13992m.toString().toString());
        }

        public static boolean isNotNullTypeParameter(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            return receiver instanceof NotNullTypeParameter;
        }

        public static boolean isNothingConstructor(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof TypeConstructor) {
                return KotlinBuiltIns.isTypeConstructorForGivenClass((TypeConstructor) receiver, StandardNames.FqNames.nothing);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + SQLKeyword.COMMA + Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static boolean isNullableType(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof KotlinType) {
                return TypeUtils.isNullableType((KotlinType) receiver);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + SQLKeyword.COMMA + Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static boolean isOldCapturedType(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull CapturedTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            return receiver instanceof CapturedType;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean isPrimitiveType(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof KotlinType) {
                return KotlinBuiltIns.isPrimitiveType((KotlinType) receiver);
            }
            StringBuilder sbM13992m = AbstractC12991c.m13992m("ClassicTypeSystemContext couldn't handle: ", receiver, SQLKeyword.COMMA);
            sbM13992m.append(Reflection.getOrCreateKotlinClass(receiver.getClass()));
            throw new IllegalArgumentException(sbM13992m.toString().toString());
        }

        public static boolean isProjectionNotNull(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull CapturedTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof NewCapturedType) {
                return ((NewCapturedType) receiver).isProjectionNotNull();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + SQLKeyword.COMMA + Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static boolean isRawType(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof KotlinType) {
                return receiver instanceof RawType;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + SQLKeyword.COMMA + Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean isSingleClassifierType(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (!(receiver instanceof SimpleType)) {
                StringBuilder sbM13992m = AbstractC12991c.m13992m("ClassicTypeSystemContext couldn't handle: ", receiver, SQLKeyword.COMMA);
                sbM13992m.append(Reflection.getOrCreateKotlinClass(receiver.getClass()));
                throw new IllegalArgumentException(sbM13992m.toString().toString());
            }
            if (KotlinTypeKt.isError((KotlinType) receiver)) {
                return false;
            }
            SimpleType simpleType = (SimpleType) receiver;
            if (simpleType.getConstructor().mo23493getDeclarationDescriptor() instanceof TypeAliasDescriptor) {
                return false;
            }
            return simpleType.getConstructor().mo23493getDeclarationDescriptor() != null || (receiver instanceof CapturedType) || (receiver instanceof NewCapturedType) || (receiver instanceof DefinitelyNotNullType) || (simpleType.getConstructor() instanceof IntegerLiteralTypeConstructor) || isSingleClassifierTypeWithEnhancement(classicTypeSystemContext, receiver);
        }

        private static boolean isSingleClassifierTypeWithEnhancement(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker) {
            return (simpleTypeMarker instanceof SimpleTypeWithEnhancement) && classicTypeSystemContext.isSingleClassifierType(((SimpleTypeWithEnhancement) simpleTypeMarker).getOrigin());
        }

        public static boolean isStarProjection(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeArgumentMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof TypeProjection) {
                return ((TypeProjection) receiver).isStarProjection();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + SQLKeyword.COMMA + Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean isStubType(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof SimpleType) {
                return TypeUtilsKt.isStubType((KotlinType) receiver);
            }
            StringBuilder sbM13992m = AbstractC12991c.m13992m("ClassicTypeSystemContext couldn't handle: ", receiver, SQLKeyword.COMMA);
            sbM13992m.append(Reflection.getOrCreateKotlinClass(receiver.getClass()));
            throw new IllegalArgumentException(sbM13992m.toString().toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean isStubTypeForBuilderInference(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof SimpleType) {
                return TypeUtilsKt.isStubTypeForBuilderInference((KotlinType) receiver);
            }
            StringBuilder sbM13992m = AbstractC12991c.m13992m("ClassicTypeSystemContext couldn't handle: ", receiver, SQLKeyword.COMMA);
            sbM13992m.append(Reflection.getOrCreateKotlinClass(receiver.getClass()));
            throw new IllegalArgumentException(sbM13992m.toString().toString());
        }

        public static boolean isTypeVariableType(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            return (receiver instanceof UnwrappedType) && (((UnwrappedType) receiver).getConstructor() instanceof NewTypeVariableConstructor);
        }

        public static boolean isUnderKotlinPackage(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof TypeConstructor) {
                ClassifierDescriptor classifierDescriptorMo23493getDeclarationDescriptor = ((TypeConstructor) receiver).mo23493getDeclarationDescriptor();
                return classifierDescriptorMo23493getDeclarationDescriptor != null && KotlinBuiltIns.isUnderKotlinPackage(classifierDescriptorMo23493getDeclarationDescriptor);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + SQLKeyword.COMMA + Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        @NotNull
        public static SimpleTypeMarker lowerBound(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull FlexibleTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof FlexibleType) {
                return ((FlexibleType) receiver).getLowerBound();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + SQLKeyword.COMMA + Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        @Nullable
        public static KotlinTypeMarker lowerType(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull CapturedTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof NewCapturedType) {
                return ((NewCapturedType) receiver).getLowerType();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + SQLKeyword.COMMA + Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        @NotNull
        public static KotlinTypeMarker makeDefinitelyNotNullOrNotNull(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof UnwrappedType) {
                return ClassicTypeSystemContextKt.makeDefinitelyNotNullOrNotNullInternal((UnwrappedType) receiver);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + SQLKeyword.COMMA + Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        @NotNull
        public static TypeCheckerState newTypeCheckerState(@NotNull ClassicTypeSystemContext classicTypeSystemContext, boolean z, boolean z2) {
            return ClassicTypeCheckerStateKt.createClassicTypeCheckerState$default(z, z2, classicTypeSystemContext, null, null, 24, null);
        }

        @NotNull
        public static SimpleTypeMarker original(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull DefinitelyNotNullTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof DefinitelyNotNullType) {
                return ((DefinitelyNotNullType) receiver).getOriginal();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + SQLKeyword.COMMA + Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        public static int parametersCount(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof TypeConstructor) {
                return ((TypeConstructor) receiver).getParameters().size();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + SQLKeyword.COMMA + Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        @NotNull
        public static Collection<KotlinTypeMarker> possibleIntegerTypes(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            TypeConstructorMarker typeConstructorMarkerTypeConstructor = classicTypeSystemContext.typeConstructor(receiver);
            if (typeConstructorMarkerTypeConstructor instanceof IntegerLiteralTypeConstructor) {
                return ((IntegerLiteralTypeConstructor) typeConstructorMarkerTypeConstructor).getPossibleTypes();
            }
            StringBuilder sbM13992m = AbstractC12991c.m13992m("ClassicTypeSystemContext couldn't handle: ", receiver, SQLKeyword.COMMA);
            sbM13992m.append(Reflection.getOrCreateKotlinClass(receiver.getClass()));
            throw new IllegalArgumentException(sbM13992m.toString().toString());
        }

        @NotNull
        public static TypeArgumentMarker projection(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull CapturedTypeConstructorMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof NewCapturedTypeConstructor) {
                return ((NewCapturedTypeConstructor) receiver).getProjection();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + SQLKeyword.COMMA + Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        public static TypeCheckerState.SupertypesPolicy substitutionSupertypePolicy(@NotNull final ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker type) {
            Intrinsics.checkNotNullParameter(type, "type");
            if (type instanceof SimpleType) {
                final TypeSubstitutor typeSubstitutorBuildSubstitutor = TypeConstructorSubstitution.Companion.create((KotlinType) type).buildSubstitutor();
                return new TypeCheckerState.SupertypesPolicy.DoCustomTransform() { // from class: kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext$substitutionSupertypePolicy$2
                    @Override // kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy
                    /* JADX INFO: renamed from: transformType */
                    public SimpleTypeMarker mo23497transformType(TypeCheckerState state, KotlinTypeMarker type2) {
                        Intrinsics.checkNotNullParameter(state, "state");
                        Intrinsics.checkNotNullParameter(type2, "type");
                        ClassicTypeSystemContext classicTypeSystemContext2 = classicTypeSystemContext;
                        TypeSubstitutor typeSubstitutor = typeSubstitutorBuildSubstitutor;
                        Object objLowerBoundIfFlexible = classicTypeSystemContext2.lowerBoundIfFlexible(type2);
                        Intrinsics.checkNotNull(objLowerBoundIfFlexible, "null cannot be cast to non-null type org.jetbrains.kotlin.types.KotlinType");
                        KotlinType kotlinTypeSafeSubstitute = typeSubstitutor.safeSubstitute((KotlinType) objLowerBoundIfFlexible, Variance.INVARIANT);
                        Intrinsics.checkNotNullExpressionValue(kotlinTypeSafeSubstitute, "safeSubstitute(...)");
                        SimpleTypeMarker simpleTypeMarkerAsSimpleType = classicTypeSystemContext2.asSimpleType(kotlinTypeSafeSubstitute);
                        Intrinsics.checkNotNull(simpleTypeMarkerAsSimpleType);
                        return simpleTypeMarkerAsSimpleType;
                    }
                };
            }
            StringBuilder sbM13992m = AbstractC12991c.m13992m("ClassicTypeSystemContext couldn't handle: ", type, SQLKeyword.COMMA);
            sbM13992m.append(Reflection.getOrCreateKotlinClass(type.getClass()));
            throw new IllegalArgumentException(sbM13992m.toString().toString());
        }

        @NotNull
        public static Collection<KotlinTypeMarker> supertypes(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof TypeConstructor) {
                Collection<KotlinType> collectionMo23494getSupertypes = ((TypeConstructor) receiver).mo23494getSupertypes();
                Intrinsics.checkNotNullExpressionValue(collectionMo23494getSupertypes, "getSupertypes(...)");
                return collectionMo23494getSupertypes;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + SQLKeyword.COMMA + Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        @NotNull
        public static TypeConstructorMarker typeConstructor(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof SimpleType) {
                return ((SimpleType) receiver).getConstructor();
            }
            StringBuilder sbM13992m = AbstractC12991c.m13992m("ClassicTypeSystemContext couldn't handle: ", receiver, SQLKeyword.COMMA);
            sbM13992m.append(Reflection.getOrCreateKotlinClass(receiver.getClass()));
            throw new IllegalArgumentException(sbM13992m.toString().toString());
        }

        @NotNull
        public static SimpleTypeMarker upperBound(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull FlexibleTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof FlexibleType) {
                return ((FlexibleType) receiver).getUpperBound();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + SQLKeyword.COMMA + Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        @NotNull
        public static SimpleTypeMarker withNullability(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker receiver, boolean z) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof SimpleType) {
                return ((SimpleType) receiver).makeNullableAsSpecified(z);
            }
            StringBuilder sbM13992m = AbstractC12991c.m13992m("ClassicTypeSystemContext couldn't handle: ", receiver, SQLKeyword.COMMA);
            sbM13992m.append(Reflection.getOrCreateKotlinClass(receiver.getClass()));
            throw new IllegalArgumentException(sbM13992m.toString().toString());
        }

        @NotNull
        public static TypeVariance getVariance(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeParameterMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof TypeParameterDescriptor) {
                Variance variance = ((TypeParameterDescriptor) receiver).getVariance();
                Intrinsics.checkNotNullExpressionValue(variance, "getVariance(...)");
                return TypeSystemContextKt.convertVariance(variance);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + SQLKeyword.COMMA + Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        @NotNull
        public static CapturedTypeConstructorMarker typeConstructor(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull CapturedTypeMarker receiver) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof NewCapturedType) {
                return ((NewCapturedType) receiver).getConstructor();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + receiver + SQLKeyword.COMMA + Reflection.getOrCreateKotlinClass(receiver.getClass())).toString());
        }

        @NotNull
        public static KotlinTypeMarker withNullability(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker receiver, boolean z) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (receiver instanceof SimpleTypeMarker) {
                return classicTypeSystemContext.withNullability((SimpleTypeMarker) receiver, z);
            }
            if (!(receiver instanceof FlexibleTypeMarker)) {
                throw new IllegalStateException("sealed");
            }
            FlexibleTypeMarker flexibleTypeMarker = (FlexibleTypeMarker) receiver;
            return classicTypeSystemContext.createFlexibleType(classicTypeSystemContext.withNullability(classicTypeSystemContext.lowerBound(flexibleTypeMarker), z), classicTypeSystemContext.withNullability(classicTypeSystemContext.upperBound(flexibleTypeMarker), z));
        }
    }
}
