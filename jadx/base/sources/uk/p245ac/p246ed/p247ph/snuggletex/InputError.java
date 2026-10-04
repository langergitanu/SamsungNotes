package uk.p245ac.p246ed.p247ph.snuggletex;

import java.util.Arrays;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.FrozenSlice;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class InputError {
    private final Object[] arguments;
    private final ErrorCode errorCode;
    private final FrozenSlice slice;
    private String stringRepresentation;

    public InputError(ErrorCode errorCode, FrozenSlice frozenSlice, Object... objArr) {
        this.slice = frozenSlice;
        this.errorCode = errorCode;
        this.arguments = objArr;
    }

    private String buildStringRepresentation() {
        return "InputError(errorCode=" + this.errorCode.toString() + ",slice=" + this.slice.toString() + ",arguments=" + Arrays.toString(this.arguments) + ")";
    }

    public Object[] getArguments() {
        return this.arguments;
    }

    public ErrorCode getErrorCode() {
        return this.errorCode;
    }

    public FrozenSlice getSlice() {
        return this.slice;
    }

    public String toString() {
        if (this.stringRepresentation == null) {
            this.stringRepresentation = buildStringRepresentation();
        }
        return this.stringRepresentation;
    }
}
