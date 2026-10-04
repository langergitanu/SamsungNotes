package org.junit.experimental.runners;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import org.junit.runners.Suite;
import org.junit.runners.model.RunnerBuilder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class Enclosed extends Suite {
    public Enclosed(Class<?> cls, RunnerBuilder runnerBuilder) {
        super(runnerBuilder, cls, filterAbstractClasses(cls.getClasses()));
    }

    private static Class<?>[] filterAbstractClasses(Class<?>[] clsArr) {
        ArrayList arrayList = new ArrayList(clsArr.length);
        for (Class<?> cls : clsArr) {
            if (!Modifier.isAbstract(cls.getModifiers())) {
                arrayList.add(cls);
            }
        }
        return (Class[]) arrayList.toArray(new Class[arrayList.size()]);
    }
}
