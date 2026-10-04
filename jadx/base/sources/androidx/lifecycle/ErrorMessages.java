package androidx.lifecycle;

import androidx.lifecycle.model.EventMethod;
import javax.lang.model.element.TypeElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Landroidx/lifecycle/ErrorMessages;", "", "()V", "INVALID_ANNOTATED_ELEMENT", "", "INVALID_CLASS_MODIFIER", "INVALID_ENCLOSING_ELEMENT", "INVALID_FIRST_ARGUMENT", "INVALID_METHOD_MODIFIER", "INVALID_SECOND_ARGUMENT", "INVALID_STATE_OVERRIDE_METHOD", "TOO_MANY_ARGS", "TOO_MANY_ARGS_NOT_ON_ANY", "failedToGenerateAdapter", "type", "Ljavax/lang/model/element/TypeElement;", "failureReason", "Landroidx/lifecycle/model/EventMethod;", "lifecycle-compiler"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class ErrorMessages {

    @NotNull
    public static final ErrorMessages INSTANCE = new ErrorMessages();

    @NotNull
    public static final String INVALID_ANNOTATED_ELEMENT = "OnLifecycleEvent can only be added to methods";

    @NotNull
    public static final String INVALID_CLASS_MODIFIER = "class containing OnLifecycleEvent methods can not be private";

    @NotNull
    public static final String INVALID_ENCLOSING_ELEMENT = "Parent of OnLifecycleEvent should be a class or interface";

    @NotNull
    public static final String INVALID_FIRST_ARGUMENT = "1st argument of a callback method must be a LifecycleOwner which represents the source of the event";

    @NotNull
    public static final String INVALID_METHOD_MODIFIER = "method marked with OnLifecycleEvent annotation can not be private";

    @NotNull
    public static final String INVALID_SECOND_ARGUMENT = "2nd argument of a callback method must be Lifecycle.Event and represent the current event";

    @NotNull
    public static final String INVALID_STATE_OVERRIDE_METHOD = "overridden method must handle the same onState changes as original method";

    @NotNull
    public static final String TOO_MANY_ARGS = "callback method cannot have more than 2 parameters";

    @NotNull
    public static final String TOO_MANY_ARGS_NOT_ON_ANY = "only callback annotated with ON_ANY can have 2 parameters";

    private ErrorMessages() {
    }

    @NotNull
    public final String failedToGenerateAdapter(@NotNull TypeElement type, @NotNull EventMethod failureReason) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(failureReason, "failureReason");
        return StringsKt.trim((CharSequence) ("\n             Failed to generate an Adapter for " + type + ", because it needs to be able to access to\n             package private method " + Elements_extKt.name(failureReason.getMethod()) + " from " + failureReason.getType() + "\n            ")).toString();
    }
}
