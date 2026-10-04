package com.google.android.play.core.internal;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;
import p001A.AbstractC0000a;

/* JADX INFO: renamed from: com.google.android.play.core.internal.bp */
/* JADX INFO: loaded from: classes5.dex */
public final class C5194bp<T> {

    /* JADX INFO: renamed from: a */
    private final Object f2966a;

    /* JADX INFO: renamed from: b */
    private final Field f2967b;

    /* JADX INFO: renamed from: c */
    private final Class<T> f2968c;

    public C5194bp(Object obj, Field field, Class<T> cls) {
        this.f2966a = obj;
        this.f2967b = field;
        this.f2968c = cls;
    }

    /* JADX INFO: renamed from: c */
    private Class m3928c() {
        return m3932b().getType().getComponentType();
    }

    /* JADX INFO: renamed from: a */
    public final T m3929a() {
        try {
            return this.f2968c.cast(this.f2967b.get(this.f2966a));
        } catch (Exception e) {
            String name = this.f2967b.getName();
            String name2 = this.f2966a.getClass().getName();
            String name3 = this.f2968c.getName();
            StringBuilder sbM16m = AbstractC0000a.m16m("Failed to get value of field ", name, " of type ", name2, " on object of type ");
            sbM16m.append(name3);
            throw new C5196br(sbM16m.toString(), e);
        }
    }

    /* JADX INFO: renamed from: b */
    public final Field m3932b() {
        return this.f2967b;
    }

    public C5194bp(Object obj, Field field, Class cls, byte[] bArr) {
        this(obj, field, Array.newInstance((Class<?>) cls, 0).getClass());
    }

    /* JADX INFO: renamed from: b */
    public void m3933b(Collection collection) {
        Object[] objArr = (Object[]) m3929a();
        int i = 0;
        Object[] objArr2 = (Object[]) Array.newInstance((Class<?>) m3928c(), collection.size() + (objArr == null ? 0 : objArr.length));
        if (objArr != null) {
            System.arraycopy(objArr, 0, objArr2, collection.size(), objArr.length);
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            objArr2[i] = it.next();
            i++;
        }
        m3930a(objArr2);
    }

    /* JADX INFO: renamed from: a */
    public final void m3930a(T t) {
        try {
            this.f2967b.set(this.f2966a, t);
        } catch (Exception e) {
            String name = this.f2967b.getName();
            String name2 = this.f2966a.getClass().getName();
            String name3 = this.f2968c.getName();
            StringBuilder sbM16m = AbstractC0000a.m16m("Failed to set value of field ", name, " of type ", name2, " on object of type ");
            sbM16m.append(name3);
            throw new C5196br(sbM16m.toString(), e);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m3931a(Collection collection) {
        Object[] objArr = (Object[]) m3929a();
        int length = objArr == null ? 0 : objArr.length;
        Object[] objArr2 = (Object[]) Array.newInstance((Class<?>) m3928c(), collection.size() + length);
        if (objArr != null) {
            System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            objArr2[length] = it.next();
            length++;
        }
        m3930a(objArr2);
    }
}
