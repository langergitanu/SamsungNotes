package androidx.lifecycle;

import com.google.auto.common.MoreElements;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.ElementFilter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u000e\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005\u001a\n\u0010\u0007\u001a\u00020\b*\u00020\t\u001a\n\u0010\n\u001a\u00020\u0001*\u00020\t\u001a\n\u0010\u000b\u001a\u00020\u0003*\u00020\u0005\u001a\n\u0010\f\u001a\u00020\u0003*\u00020\u0005\u001a\u0010\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e*\u00020\u000f\u001a\n\u0010\u0010\u001a\u00020\u0001*\u00020\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m13886d2 = {"SYNTHETIC", "", "isSyntheticMethod", "", "method", "Ljavax/lang/model/element/ExecutableElement;", "syntheticName", "getPackage", "Ljavax/lang/model/element/PackageElement;", "Ljavax/lang/model/element/Element;", "getPackageQName", "isPackagePrivate", "isProtected", "methods", "", "Ljavax/lang/model/element/TypeElement;", "name", "lifecycle-compiler"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nelements_ext.kt\nKotlin\n*S Kotlin\n*F\n+ 1 elements_ext.kt\nandroidx/lifecycle/Elements_extKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,46:1\n1747#2,3:47\n*S KotlinDebug\n*F\n+ 1 elements_ext.kt\nandroidx/lifecycle/Elements_extKt\n*L\n33#1:47,3\n*E\n"})
public final class Elements_extKt {

    @NotNull
    private static final String SYNTHETIC = "__synthetic_";

    @NotNull
    public static final PackageElement getPackage(@NotNull Element element) {
        Intrinsics.checkNotNullParameter(element, "<this>");
        PackageElement packageElement = MoreElements.getPackage(element);
        Intrinsics.checkNotNullExpressionValue(packageElement, "getPackage(this)");
        return packageElement;
    }

    @NotNull
    public static final String getPackageQName(@NotNull Element element) {
        Intrinsics.checkNotNullParameter(element, "<this>");
        return getPackage(element).getQualifiedName().toString();
    }

    public static final boolean isPackagePrivate(@NotNull ExecutableElement executableElement) {
        Intrinsics.checkNotNullParameter(executableElement, "<this>");
        Set modifiers = executableElement.getModifiers();
        Intrinsics.checkNotNullExpressionValue(modifiers, "modifiers");
        Set<Modifier> set = modifiers;
        boolean z = false;
        if (!(set instanceof Collection) || !set.isEmpty()) {
            for (Modifier modifier : set) {
                if (modifier == Modifier.PUBLIC || modifier == Modifier.PROTECTED || modifier == Modifier.PRIVATE) {
                    z = true;
                    break;
                }
            }
        }
        return !z;
    }

    public static final boolean isProtected(@NotNull ExecutableElement executableElement) {
        Intrinsics.checkNotNullParameter(executableElement, "<this>");
        return executableElement.getModifiers().contains(Modifier.PROTECTED);
    }

    public static final boolean isSyntheticMethod(@NotNull ExecutableElement method) {
        Intrinsics.checkNotNullParameter(method, "method");
        return StringsKt.m14145S(name(method), SYNTHETIC);
    }

    @NotNull
    public static final List<ExecutableElement> methods(@NotNull TypeElement typeElement) {
        Intrinsics.checkNotNullParameter(typeElement, "<this>");
        List<ExecutableElement> listMethodsIn = ElementFilter.methodsIn(typeElement.getEnclosedElements());
        Intrinsics.checkNotNullExpressionValue(listMethodsIn, "methodsIn(enclosedElements)");
        return listMethodsIn;
    }

    @NotNull
    public static final String name(@NotNull ExecutableElement executableElement) {
        Intrinsics.checkNotNullParameter(executableElement, "<this>");
        return executableElement.getSimpleName().toString();
    }

    @NotNull
    public static final String syntheticName(@NotNull ExecutableElement method) {
        Intrinsics.checkNotNullParameter(method, "method");
        return SYNTHETIC + method.getSimpleName();
    }
}
