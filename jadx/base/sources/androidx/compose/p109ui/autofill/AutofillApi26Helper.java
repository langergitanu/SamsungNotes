package androidx.compose.p109ui.autofill;

import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillValue;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 1)
@RequiresApi(26)
@Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J#\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0007¢\u0006\u0002\u0010\u0013J \u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u0018\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0017H\u0007J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u001c"}, m13886d2 = {"Landroidx/compose/ui/autofill/AutofillApi26Helper;", "", "()V", "getAutofillId", "Landroid/view/autofill/AutofillId;", "structure", "Landroid/view/ViewStructure;", "isDate", "", "value", "Landroid/view/autofill/AutofillValue;", "isList", "isText", "isToggle", "setAutofillHints", "", "hints", "", "", "(Landroid/view/ViewStructure;[Ljava/lang/String;)V", "setAutofillId", "parent", "virtualId", "", "setAutofillType", "type", "textValue", "", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class AutofillApi26Helper {
    public static final int $stable = 0;

    @NotNull
    public static final AutofillApi26Helper INSTANCE = new AutofillApi26Helper();

    private AutofillApi26Helper() {
    }

    @DoNotInline
    @RequiresApi(26)
    @Nullable
    public final AutofillId getAutofillId(@NotNull ViewStructure structure) {
        return structure.getAutofillId();
    }

    @DoNotInline
    @RequiresApi(26)
    public final boolean isDate(@NotNull AutofillValue value) {
        return value.isDate();
    }

    @DoNotInline
    @RequiresApi(26)
    public final boolean isList(@NotNull AutofillValue value) {
        return value.isList();
    }

    @DoNotInline
    @RequiresApi(26)
    public final boolean isText(@NotNull AutofillValue value) {
        return value.isText();
    }

    @DoNotInline
    @RequiresApi(26)
    public final boolean isToggle(@NotNull AutofillValue value) {
        return value.isToggle();
    }

    @DoNotInline
    @RequiresApi(26)
    public final void setAutofillHints(@NotNull ViewStructure structure, @NotNull String[] hints) {
        structure.setAutofillHints(hints);
    }

    @DoNotInline
    @RequiresApi(26)
    public final void setAutofillId(@NotNull ViewStructure structure, @NotNull AutofillId parent, int virtualId) {
        structure.setAutofillId(parent, virtualId);
    }

    @DoNotInline
    @RequiresApi(26)
    public final void setAutofillType(@NotNull ViewStructure structure, int type) {
        structure.setAutofillType(type);
    }

    @DoNotInline
    @RequiresApi(26)
    @NotNull
    public final CharSequence textValue(@NotNull AutofillValue value) {
        return value.getTextValue();
    }
}
