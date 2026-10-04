package com.samsung.android.support.senl.document.delegator;

import android.content.Context;
import com.samsung.android.app.notes.reflect.DocumentSaveParamBuilderImpl;
import com.samsung.android.support.senl.document.contract.DocumentSaveParamBuilder;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class DocumentSaveSDoc {
    public static DocumentSaveParamBuilder createBuilderInstance() {
        try {
            return (DocumentSaveParamBuilder) DocumentSaveParamBuilderImpl.class.getDeclaredConstructor(null).newInstance(null);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (InstantiationException e3) {
            e3.printStackTrace();
            return null;
        } catch (NoSuchMethodException e5) {
            e5.printStackTrace();
            return null;
        } catch (InvocationTargetException e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public static boolean saveSDoc(Context context, DocumentSaveParamBuilder documentSaveParamBuilder) {
        return AppDelegator.getInstance().saveDoc(context, documentSaveParamBuilder);
    }
}
