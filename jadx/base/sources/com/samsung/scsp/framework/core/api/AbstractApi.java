package com.samsung.scsp.framework.core.api;

import android.util.Pair;
import com.samsung.scsp.error.FaultBarrier;
import com.samsung.scsp.framework.core.api.AbstractApi;
import com.samsung.scsp.framework.core.listeners.Listeners;
import com.samsung.scsp.framework.core.network.HttpRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class AbstractApi implements Api {
    private final Map<String, Job> API_JOBS = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class JobFactory {
        private JobFactory() {
        }

        public static Job create(final String str, final HttpRequest.Method method, final String str2, final Class<?> cls, final Class<? extends Job> cls2, Property[] propertyArr) {
            Job job = (Job) FaultBarrier.get(new FaultBarrier.ThrowableSupplier() { // from class: com.samsung.scsp.framework.core.api.c
                @Override // com.samsung.scsp.error.FaultBarrier.ThrowableSupplier
                public final Object get() {
                    return AbstractApi.JobFactory.lambda$create$1(cls2, method, str, str2, cls);
                }
            }, null).obj;
            if (job != null && propertyArr != null) {
                job.attachProperties(propertyArr);
            }
            return job;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Constructor lambda$create$0(Class cls) {
            return cls.getDeclaredConstructor(HttpRequest.Method.class, String.class, String.class, Class.class);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Job lambda$create$1(Class cls, HttpRequest.Method method, String str, String str2, Class cls2) throws NoSuchMethodException {
            if (cls != EmptyJobImpl.class) {
                if (FileTransferableJob.class.isAssignableFrom(cls)) {
                    Constructor declaredConstructor = cls.getDeclaredConstructor(HttpRequest.Method.class, String.class, String.class);
                    declaredConstructor.setAccessible(true);
                    return (Job) declaredConstructor.newInstance(method, str, str2);
                }
                if (ResponsiveJob.class.isAssignableFrom(cls)) {
                    Object[] objArr = {method, str, str2, cls2};
                    Constructor declaredConstructor2 = (Constructor) FaultBarrier.get(new C11638b(cls, 0), null).obj;
                    if (declaredConstructor2 == null) {
                        declaredConstructor2 = cls.getDeclaredConstructor(HttpRequest.Method.class, String.class, String.class);
                        objArr = new Object[]{method, str, str2};
                    }
                    declaredConstructor2.setAccessible(true);
                    return (Job) declaredConstructor2.newInstance(objArr);
                }
                if (SimpleJob.class.isAssignableFrom(cls)) {
                    Constructor declaredConstructor3 = cls.getDeclaredConstructor(HttpRequest.Method.class, String.class, String.class);
                    declaredConstructor3.setAccessible(true);
                    return (Job) declaredConstructor3.newInstance(method, str, str2);
                }
            }
            return cls2 != EmptyResponse.class ? new ResponsiveJob(method, str, str2, cls2) : new SimpleJob(method, str, str2);
        }
    }

    public AbstractApi() {
        FaultBarrier.run(new C11637a(this, 0));
    }

    private void createJob(Class<?> cls) {
        Job jobCreateJob;
        for (Field field : cls.getFields()) {
            field.setAccessible(true);
            Annotation[] annotations = field.getAnnotations();
            if (annotations.length > 0 && (jobCreateJob = createJob((String) field.get(null), annotations[0])) != null) {
                this.API_JOBS.put(jobCreateJob.getName(), jobCreateJob);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        ApiSpec apiSpec = (ApiSpec) getClass().getAnnotation(ApiSpec.class);
        if (apiSpec != null) {
            createJob(apiSpec.value());
        }
    }

    public void add(Job job) {
        this.API_JOBS.put(job.getName(), job);
    }

    public void attachHeaderFunction(String str, Function<ApiContext, Pair<String, String>[]> function) {
        this.API_JOBS.get(str).attachHeaderFunction(function);
    }

    public void attachJournalSupplier(String str, Supplier<Pair<String, String>> supplier) {
        this.API_JOBS.get(str).attachJournalSupplier(supplier);
    }

    public void attachUrlFunction(String str, BiFunction<ApiContext, String, String> biFunction) {
        this.API_JOBS.get(str).attachUrlFunction(biFunction);
    }

    @Override // com.samsung.scsp.framework.core.api.Api
    public void execute(ApiContext apiContext, Listeners listeners) {
        this.API_JOBS.get(apiContext.name).execute(apiContext, listeners);
    }

    private Job createJob(String str, Annotation annotation) {
        if (annotation instanceof Post) {
            Post post = (Post) annotation;
            return JobFactory.create(str, HttpRequest.Method.POST, post.value(), post.response(), post.jobImpl(), post.properties());
        }
        if (annotation instanceof Get) {
            Get get = (Get) annotation;
            return JobFactory.create(str, HttpRequest.Method.GET, get.value(), get.response(), get.jobImpl(), get.properties());
        }
        if (annotation instanceof Put) {
            Put put = (Put) annotation;
            return JobFactory.create(str, HttpRequest.Method.PUT, put.value(), put.response(), put.jobImpl(), put.properties());
        }
        if (annotation instanceof Delete) {
            Delete delete = (Delete) annotation;
            return JobFactory.create(str, HttpRequest.Method.DELETE, delete.value(), delete.response(), delete.jobImpl(), delete.properties());
        }
        if (annotation instanceof Patch) {
            Patch patch = (Patch) annotation;
            return JobFactory.create(str, HttpRequest.Method.PATCH, patch.value(), patch.response(), patch.jobImpl(), patch.properties());
        }
        if (!(annotation instanceof Head)) {
            return null;
        }
        Head head = (Head) annotation;
        return JobFactory.create(str, HttpRequest.Method.HEAD, head.value(), head.response(), head.jobImpl(), head.properties());
    }
}
