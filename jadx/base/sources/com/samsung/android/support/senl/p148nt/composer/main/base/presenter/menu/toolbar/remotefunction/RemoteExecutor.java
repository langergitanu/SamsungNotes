package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.remotefunction;

import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.remotefunction.RemoteConstant;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@RemoteConstant.RemoteExecutor
public class RemoteExecutor {
    private static final String TAG = Logger.createTag("RemoteExecutor");

    public void executeFunction(Object obj, Method method, Object[] objArr) {
        if (obj == null || method == null) {
            Logger.m11000e(TAG, "executeFunction - parameter error class " + obj + " method " + method);
            return;
        }
        Logger.m11003i(TAG, "executeFunction - methodName " + method.getName());
        try {
            method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            e = e;
            Logger.m11000e(TAG, "executeFunction error : " + e.toString());
        } catch (IllegalArgumentException e2) {
            e = e2;
            Logger.m11000e(TAG, "executeFunction error : " + e.toString());
        } catch (NullPointerException e3) {
            e = e3;
            Logger.m11000e(TAG, "executeFunction error : " + e.toString());
        } catch (InvocationTargetException e5) {
            Logger.m11001e(TAG, "executeFunction InvocationTargetException : " + e5.getMessage(), e5.getTargetException());
        }
    }
}
