package org.apache.commons.lang3.event;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.function.FailableConsumer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class EventListenerSupport<L> implements Serializable {
    private static final long serialVersionUID = 3593265990380473632L;
    private List<L> listeners;
    private transient L[] prototypeArray;
    private transient L proxy;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ProxyInvocationHandler implements InvocationHandler {
        private final FailableConsumer<Throwable, IllegalAccessException> handler;

        public ProxyInvocationHandler(EventListenerSupport eventListenerSupport) {
            this(new C13832a(0));
        }

        public void handle(Throwable th) {
            this.handler.accept(th);
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            Iterator it = EventListenerSupport.this.listeners.iterator();
            while (it.hasNext()) {
                try {
                    method.invoke(it.next(), objArr);
                } catch (Throwable th) {
                    handle(th);
                }
            }
            return null;
        }

        public ProxyInvocationHandler(FailableConsumer<Throwable, IllegalAccessException> failableConsumer) {
            Objects.requireNonNull(failableConsumer);
            this.handler = failableConsumer;
        }
    }

    private EventListenerSupport() {
        this.listeners = new CopyOnWriteArrayList();
    }

    public static <T> EventListenerSupport<T> create(Class<T> cls) {
        return new EventListenerSupport<>(cls);
    }

    private void createProxy(Class<L> cls, ClassLoader classLoader) {
        this.proxy = cls.cast(Proxy.newProxyInstance(classLoader, new Class[]{cls}, createInvocationHandler()));
    }

    private void initializeTransientFields(Class<L> cls, ClassLoader classLoader) {
        this.prototypeArray = (L[]) ArrayUtils.newInstance(cls, 0);
        createProxy(cls, classLoader);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        Object[] objArr = (Object[]) objectInputStream.readObject();
        this.listeners = new CopyOnWriteArrayList(objArr);
        initializeTransientFields(ArrayUtils.getComponentType(objArr), Thread.currentThread().getContextClassLoader());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        ArrayList arrayList = new ArrayList();
        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new ByteArrayOutputStream());
        for (L l : this.listeners) {
            try {
                objectOutputStream2.writeObject(l);
                arrayList.add(l);
            } catch (IOException unused) {
                objectOutputStream2 = new ObjectOutputStream(new ByteArrayOutputStream());
            }
        }
        objectOutputStream.writeObject(arrayList.toArray(this.prototypeArray));
    }

    public void addListener(L l) {
        addListener(l, true);
    }

    public InvocationHandler createInvocationHandler() {
        return new ProxyInvocationHandler(this);
    }

    public L fire() {
        return this.proxy;
    }

    public int getListenerCount() {
        return this.listeners.size();
    }

    public L[] getListeners() {
        return (L[]) this.listeners.toArray(this.prototypeArray);
    }

    public void removeListener(L l) {
        List<L> list = this.listeners;
        Objects.requireNonNull(l, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        list.remove(l);
    }

    public void addListener(L l, boolean z) {
        Objects.requireNonNull(l, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        if (z || !this.listeners.contains(l)) {
            this.listeners.add(l);
        }
    }

    public EventListenerSupport(Class<L> cls) {
        this(cls, Thread.currentThread().getContextClassLoader());
    }

    public EventListenerSupport(Class<L> cls, ClassLoader classLoader) {
        this();
        Objects.requireNonNull(cls, "listenerInterface");
        Objects.requireNonNull(classLoader, "classLoader");
        Validate.isTrue(cls.isInterface(), "Class %s is not an interface", cls.getName());
        initializeTransientFields(cls, classLoader);
    }
}
