package androidx.test.platform.p119ui;

import android.view.KeyEvent;
import android.view.MotionEvent;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public interface UiController {
    boolean injectKeyEvent(KeyEvent keyEvent);

    boolean injectMotionEvent(MotionEvent motionEvent);

    boolean injectString(String str);

    void loopMainThreadForAtLeast(long j);

    void loopMainThreadUntilIdle();
}
