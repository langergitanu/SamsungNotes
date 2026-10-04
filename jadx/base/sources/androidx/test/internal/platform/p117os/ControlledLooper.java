package androidx.test.internal.platform.p117os;

import android.view.View;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface ControlledLooper {
    public static final ControlledLooper NO_OP_CONTROLLED_LOOPER = new ControlledLooper() { // from class: androidx.test.internal.platform.os.ControlledLooper.1
        @Override // androidx.test.internal.platform.p117os.ControlledLooper
        public boolean areDrawCallbacksSupported() {
            return true;
        }

        @Override // androidx.test.internal.platform.p117os.ControlledLooper
        public void drainMainThreadUntilIdle() {
        }

        @Override // androidx.test.internal.platform.p117os.ControlledLooper
        public void simulateWindowFocus(View view) {
        }
    };

    default boolean areDrawCallbacksSupported() {
        return false;
    }

    void drainMainThreadUntilIdle();

    void simulateWindowFocus(View view);
}
