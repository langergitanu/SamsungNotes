package androidx.test.runner.intercepting;

import android.app.Activity;
import android.content.Intent;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public interface InterceptingActivityFactory {
    Activity create(ClassLoader classLoader, String str, Intent intent);

    boolean shouldIntercept(ClassLoader classLoader, String str, Intent intent);
}
