package androidx.compose.foundation.text;

import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.p109ui.text.TextRange;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0011\u001a\u00020\u0004J\f\u0010\u0012\u001a\u00020\u0004*\u00020\u0013H\u0016R+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078@@BX\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, m13886d2 = {"Landroidx/compose/foundation/text/PasswordInputTransformation;", "Landroidx/compose/foundation/text/input/InputTransformation;", "scheduleHide", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "<set-?>", "", "revealCodepointIndex", "getRevealCodepointIndex$foundation_release", "()I", "setRevealCodepointIndex", "(I)V", "revealCodepointIndex$delegate", "Landroidx/compose/runtime/MutableIntState;", "getScheduleHide", "()Lkotlin/jvm/functions/Function0;", "hide", "transformInput", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nBasicSecureTextField.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BasicSecureTextField.kt\nandroidx/compose/foundation/text/PasswordInputTransformation\n+ 2 SnapshotIntState.kt\nandroidx/compose/runtime/SnapshotIntStateKt__SnapshotIntStateKt\n*L\n1#1,343:1\n78#2:344\n111#2,2:345\n*S KotlinDebug\n*F\n+ 1 BasicSecureTextField.kt\nandroidx/compose/foundation/text/PasswordInputTransformation\n*L\n268#1:344\n268#1:345,2\n*E\n"})
public final class PasswordInputTransformation implements InputTransformation {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: revealCodepointIndex$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableIntState revealCodepointIndex = SnapshotIntStateKt.mutableIntStateOf(-1);

    @NotNull
    private final Function0<Unit> scheduleHide;

    public PasswordInputTransformation(@NotNull Function0<Unit> function0) {
        this.scheduleHide = function0;
    }

    private final void setRevealCodepointIndex(int i) {
        this.revealCodepointIndex.setIntValue(i);
    }

    public final int getRevealCodepointIndex$foundation_release() {
        return this.revealCodepointIndex.getIntValue();
    }

    @NotNull
    public final Function0<Unit> getScheduleHide() {
        return this.scheduleHide;
    }

    public final void hide() {
        setRevealCodepointIndex(-1);
    }

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public void transformInput(@NotNull TextFieldBuffer textFieldBuffer) {
        if (textFieldBuffer.getChanges().getChangeCount() != 1 || TextRange.m20452getLengthimpl(textFieldBuffer.getChanges().mo16279getRangejx7JFs(0)) != 1 || TextRange.m20452getLengthimpl(textFieldBuffer.getChanges().mo16278getOriginalRangejx7JFs(0)) != 0 || textFieldBuffer.hasSelection()) {
            setRevealCodepointIndex(-1);
            return;
        }
        int iM20454getMinimpl = TextRange.m20454getMinimpl(textFieldBuffer.getChanges().mo16279getRangejx7JFs(0));
        if (getRevealCodepointIndex$foundation_release() != iM20454getMinimpl) {
            this.scheduleHide.invoke();
            setRevealCodepointIndex(iM20454getMinimpl);
        }
    }
}
