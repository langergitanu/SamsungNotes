package com.samsung.android.spen.libsdl;

import android.content.Context;
import android.graphics.Rect;
import com.samsung.android.spen.libinterface.HermesServiceManagerInterface;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SdlHermesServiceManager implements HermesServiceManagerInterface {
    private Class<?> mClass;
    private Context mContext;
    private Object mInstance;

    public SdlHermesServiceManager(Context context) throws NoSuchMethodException, ClassNotFoundException {
        this.mClass = null;
        this.mInstance = null;
        this.mContext = context;
        Class<?> cls = Class.forName("com.samsung.android.hermes.HermesServiceManager");
        this.mClass = cls;
        Constructor<?> constructor = cls.getConstructor(Context.class);
        constructor.setAccessible(true);
        this.mInstance = constructor.newInstance(this.mContext);
    }

    @Override // com.samsung.android.spen.libinterface.HermesServiceManagerInterface
    public void dismissHermes() throws IllegalAccessException, InvocationTargetException {
        this.mClass.getMethod("dismissHermes", null).invoke(this.mInstance, null);
    }

    @Override // com.samsung.android.spen.libinterface.HermesServiceManagerInterface
    public void showHermes(String str, Rect rect) throws IllegalAccessException, InvocationTargetException {
        Object[] objArr = {str, rect, 1};
        this.mClass.getMethod("showHermes", String.class, Rect.class, Integer.TYPE).invoke(this.mInstance, objArr);
    }
}
