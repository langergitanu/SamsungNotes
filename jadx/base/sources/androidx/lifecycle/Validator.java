package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import com.google.auto.common.MoreElements;
import com.google.auto.common.MoreTypes;
import com.samsung.android.sdk.smp.common.constants.NetworkConfig;
import java.util.List;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.VariableElement;
import javax.tools.Diagnostic;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fJ\u0016\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\"\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00172\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u00192\u0006\u0010\u001a\u001a\u00020\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001c"}, m13886d2 = {"Landroidx/lifecycle/Validator;", "", "processingEnv", "Ljavax/annotation/processing/ProcessingEnvironment;", "(Ljavax/annotation/processing/ProcessingEnvironment;)V", "getProcessingEnv", "()Ljavax/annotation/processing/ProcessingEnvironment;", "printErrorMessage", "", "msg", "", "elem", "Ljavax/lang/model/element/Element;", "validateClass", "", "classElement", "validateMethod", "method", "Ljavax/lang/model/element/ExecutableElement;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "validateParam", "param", "Ljavax/lang/model/element/VariableElement;", "expectedType", "Ljava/lang/Class;", NetworkConfig.ACK_ERROR_MSG, "", "lifecycle-compiler"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class Validator {

    @NotNull
    private final ProcessingEnvironment processingEnv;

    public Validator(@NotNull ProcessingEnvironment processingEnv) {
        Intrinsics.checkNotNullParameter(processingEnv, "processingEnv");
        this.processingEnv = processingEnv;
    }

    @NotNull
    public final ProcessingEnvironment getProcessingEnv() {
        return this.processingEnv;
    }

    public final void printErrorMessage(@NotNull CharSequence msg, @NotNull Element elem) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(elem, "elem");
        this.processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, msg, elem);
    }

    public final boolean validateClass(@NotNull Element classElement) {
        Intrinsics.checkNotNullParameter(classElement, "classElement");
        if (!MoreElements.isType(classElement)) {
            printErrorMessage(ErrorMessages.INVALID_ENCLOSING_ELEMENT, classElement);
            return false;
        }
        if (!classElement.getModifiers().contains(Modifier.PRIVATE)) {
            return true;
        }
        printErrorMessage(ErrorMessages.INVALID_CLASS_MODIFIER, classElement);
        return false;
    }

    public final boolean validateMethod(@NotNull ExecutableElement method, @NotNull Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(event, "event");
        if (method.getModifiers().contains(Modifier.PRIVATE)) {
            printErrorMessage(ErrorMessages.INVALID_METHOD_MODIFIER, (Element) method);
            return false;
        }
        List parameters = method.getParameters();
        if (parameters.size() > 2) {
            printErrorMessage(ErrorMessages.TOO_MANY_ARGS, (Element) method);
            return false;
        }
        if (parameters.size() == 2 && event != Lifecycle.Event.ON_ANY) {
            printErrorMessage(ErrorMessages.TOO_MANY_ARGS_NOT_ON_ANY, (Element) method);
            return false;
        }
        if (parameters.size() == 2) {
            Object obj = parameters.get(1);
            Intrinsics.checkNotNullExpressionValue(obj, "params[1]");
            if (!validateParam((VariableElement) obj, Lifecycle.Event.class, ErrorMessages.INVALID_SECOND_ARGUMENT)) {
                return false;
            }
        }
        if (parameters.size() <= 0) {
            return true;
        }
        Object obj2 = parameters.get(0);
        Intrinsics.checkNotNullExpressionValue(obj2, "params[0]");
        return validateParam((VariableElement) obj2, LifecycleOwner.class, ErrorMessages.INVALID_FIRST_ARGUMENT);
    }

    public final boolean validateParam(@NotNull VariableElement param, @NotNull Class<?> expectedType, @NotNull String errorMsg) {
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(expectedType, "expectedType");
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        if (MoreTypes.isTypeOf(expectedType, param.asType())) {
            return true;
        }
        printErrorMessage(errorMsg, (Element) param);
        return false;
    }
}
