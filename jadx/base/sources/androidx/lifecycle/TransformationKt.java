package androidx.lifecycle;

import androidx.lifecycle.model.AdapterClass;
import androidx.lifecycle.model.EventMethod;
import androidx.lifecycle.model.EventMethodCall;
import androidx.lifecycle.model.InputModel;
import androidx.lifecycle.model.LifecycleObserverInfo;
import com.google.common.collect.HashMultimap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u00008\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a(\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00020\u0006\u001a:\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u0001H\u0002\u001a\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\tH\u0002\u001a\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0012\u001a(\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\tH\u0002¨\u0006\u0014"}, m13886d2 = {"flattenObservers", "", "Landroidx/lifecycle/model/LifecycleObserverInfo;", "processingEnv", "Ljavax/annotation/processing/ProcessingEnvironment;", "world", "", "Ljavax/lang/model/element/TypeElement;", "mergeAndVerifyMethods", "Landroidx/lifecycle/model/EventMethod;", "type", "classMethods", "parentMethods", "needsSyntheticAccess", "", "eventMethod", "transformToOutput", "Landroidx/lifecycle/model/AdapterClass;", "Landroidx/lifecycle/model/InputModel;", "validateMethod", "lifecycle-compiler"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\ntransformation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 transformation.kt\nandroidx/lifecycle/TransformationKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,161:1\n1549#2:162\n1620#2,2:163\n1622#2:166\n819#2:167\n847#2,2:168\n1855#2,2:170\n766#2:172\n857#2,2:173\n766#2:175\n857#2:176\n1726#2,3:177\n858#2:180\n1549#2:181\n1620#2,2:182\n1549#2:184\n1620#2,3:185\n766#2:188\n857#2,2:189\n1855#2,2:191\n1622#2:193\n1549#2:197\n1620#2,3:198\n1855#2,2:202\n1549#2:204\n1620#2,3:205\n1789#2,3:208\n1#3:165\n125#4:194\n152#4,2:195\n154#4:201\n*S KotlinDebug\n*F\n+ 1 transformation.kt\nandroidx/lifecycle/TransformationKt\n*L\n38#1:162\n38#1:163,2\n38#1:166\n54#1:167\n54#1:168,2\n87#1:170,2\n133#1:172\n133#1:173,2\n135#1:175\n135#1:176\n136#1:177,3\n135#1:180\n140#1:181\n140#1:182,2\n141#1:184\n141#1:185,3\n148#1:188\n148#1:189,2\n148#1:191,2\n140#1:193\n157#1:197\n157#1:198,3\n71#1:202,2\n73#1:204\n73#1:205,3\n74#1:208,3\n155#1:194\n155#1:195,2\n155#1:201\n*E\n"})
public final class TransformationKt {
    @NotNull
    public static final List<LifecycleObserverInfo> flattenObservers(@NotNull ProcessingEnvironment processingEnv, @NotNull Map<TypeElement, LifecycleObserverInfo> world) {
        Intrinsics.checkNotNullParameter(processingEnv, "processingEnv");
        Intrinsics.checkNotNullParameter(world, "world");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> it = world.values().iterator();
        while (it.hasNext()) {
            flattenObservers$traverse(linkedHashMap, processingEnv, (LifecycleObserverInfo) it.next());
        }
        return CollectionsKt.toList(linkedHashMap.values());
    }

    private static final void flattenObservers$traverse(Map<LifecycleObserverInfo, LifecycleObserverInfo> map, ProcessingEnvironment processingEnvironment, LifecycleObserverInfo lifecycleObserverInfo) {
        if (map.containsKey(lifecycleObserverInfo)) {
            return;
        }
        if (lifecycleObserverInfo.getParents().isEmpty()) {
            map.put(lifecycleObserverInfo, lifecycleObserverInfo);
            return;
        }
        Iterator<T> it = lifecycleObserverInfo.getParents().iterator();
        while (it.hasNext()) {
            flattenObservers$traverse(map, processingEnvironment, (LifecycleObserverInfo) it.next());
        }
        List<LifecycleObserverInfo> parents = lifecycleObserverInfo.getParents();
        ArrayList<LifecycleObserverInfo> arrayList = new ArrayList(CollectionsKt.m13952k(parents));
        Iterator<T> it2 = parents.iterator();
        while (it2.hasNext()) {
            arrayList.add(map.get((LifecycleObserverInfo) it2.next()));
        }
        List<EventMethod> listEmptyList = CollectionsKt.emptyList();
        for (LifecycleObserverInfo lifecycleObserverInfo2 : arrayList) {
            TypeElement type = lifecycleObserverInfo.getType();
            Intrinsics.checkNotNull(lifecycleObserverInfo2);
            listEmptyList = mergeAndVerifyMethods(processingEnvironment, type, lifecycleObserverInfo2.getMethods(), listEmptyList);
        }
        map.put(lifecycleObserverInfo, new LifecycleObserverInfo(lifecycleObserverInfo.getType(), mergeAndVerifyMethods(processingEnvironment, lifecycleObserverInfo.getType(), lifecycleObserverInfo.getMethods(), listEmptyList), null, 4, null));
    }

    private static final List<EventMethod> mergeAndVerifyMethods(ProcessingEnvironment processingEnvironment, TypeElement typeElement, List<EventMethod> list, List<EventMethod> list2) {
        Object next;
        List<EventMethod> list3 = list2;
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(list3));
        for (EventMethod eventMethod : list3) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (processingEnvironment.getElementUtils().overrides(((EventMethod) next).getMethod(), eventMethod.getMethod(), typeElement)) {
                    break;
                }
            }
            EventMethod eventMethod2 = (EventMethod) next;
            if (eventMethod2 != null) {
                if (!Intrinsics.areEqual(eventMethod2.getOnLifecycleEvent(), eventMethod.getOnLifecycleEvent())) {
                    processingEnvironment.getMessager().printMessage(Diagnostic.Kind.ERROR, ErrorMessages.INVALID_STATE_OVERRIDE_METHOD, eventMethod2.getMethod());
                }
                eventMethod = eventMethod2;
            }
            arrayList.add(eventMethod);
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : list) {
            if (!arrayList.contains((EventMethod) obj)) {
                arrayList2.add(obj);
            }
        }
        return CollectionsKt.plus((Collection) arrayList, (Iterable) arrayList2);
    }

    private static final boolean needsSyntheticAccess(TypeElement typeElement, EventMethod eventMethod) {
        ExecutableElement method = eventMethod.getMethod();
        if (Intrinsics.areEqual(Elements_extKt.getPackageQName((Element) typeElement), eventMethod.packageName())) {
            return false;
        }
        return Elements_extKt.isPackagePrivate(method) || Elements_extKt.isProtected(method);
    }

    @NotNull
    public static final List<AdapterClass> transformToOutput(@NotNull ProcessingEnvironment processingEnv, @NotNull InputModel world) {
        Intrinsics.checkNotNullParameter(processingEnv, "processingEnv");
        Intrinsics.checkNotNullParameter(world, "world");
        List<LifecycleObserverInfo> listFlattenObservers = flattenObservers(processingEnv, world.getObserversInfo());
        HashMultimap hashMultimapCreate = HashMultimap.create();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listFlattenObservers) {
            if (world.isRootType(((LifecycleObserverInfo) obj).getType())) {
                arrayList.add(obj);
            }
        }
        ArrayList<LifecycleObserverInfo> arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            LifecycleObserverInfo lifecycleObserverInfo = (LifecycleObserverInfo) obj2;
            TypeElement type = lifecycleObserverInfo.getType();
            List<EventMethod> listComponent2 = lifecycleObserverInfo.component2();
            if (!(listComponent2 instanceof Collection) || !listComponent2.isEmpty()) {
                Iterator<T> it = listComponent2.iterator();
                while (it.hasNext()) {
                    if (!validateMethod(processingEnv, world, type, (EventMethod) it.next())) {
                        break;
                    }
                }
            }
            arrayList2.add(obj2);
        }
        ArrayList arrayList3 = new ArrayList(CollectionsKt.m13952k(arrayList2));
        for (LifecycleObserverInfo lifecycleObserverInfo2 : arrayList2) {
            TypeElement type2 = lifecycleObserverInfo2.getType();
            List<EventMethod> listComponent22 = lifecycleObserverInfo2.component2();
            ArrayList arrayList4 = new ArrayList(CollectionsKt.m13952k(listComponent22));
            for (EventMethod eventMethod : listComponent22) {
                arrayList4.add(needsSyntheticAccess(type2, eventMethod) ? new EventMethodCall(eventMethod, eventMethod.getType()) : new EventMethodCall(eventMethod, null, 2, null));
            }
            ArrayList<EventMethodCall> arrayList5 = new ArrayList();
            for (Object obj3 : arrayList4) {
                if (((EventMethodCall) obj3).getSyntheticAccess() != null) {
                    arrayList5.add(obj3);
                }
            }
            for (EventMethodCall eventMethodCall : arrayList5) {
                hashMultimapCreate.put(eventMethodCall.getMethod().getType(), eventMethodCall);
            }
            arrayList3.add(TuplesKt.m13893to(type2, arrayList4));
        }
        Map map = MapsKt.toMap(arrayList3);
        ArrayList arrayList6 = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            TypeElement typeElement = (TypeElement) entry.getKey();
            List list = (List) entry.getValue();
            Set setEmptySet = hashMultimapCreate.get((Object) typeElement);
            if (setEmptySet == null) {
                setEmptySet = SetsKt.emptySet();
            } else {
                Intrinsics.checkNotNullExpressionValue(setEmptySet, "syntheticMethods.get(type) ?: emptySet()");
            }
            Set<EventMethodCall> set = setEmptySet;
            ArrayList arrayList7 = new ArrayList(CollectionsKt.m13952k(set));
            for (EventMethodCall eventMethodCall2 : set) {
                Intrinsics.checkNotNull(eventMethodCall2);
                arrayList7.add(eventMethodCall2.getMethod().getMethod());
            }
            arrayList6.add(new AdapterClass(typeElement, list, CollectionsKt.toSet(arrayList7)));
        }
        return arrayList6;
    }

    private static final boolean validateMethod(ProcessingEnvironment processingEnvironment, InputModel inputModel, TypeElement typeElement, EventMethod eventMethod) {
        if (!needsSyntheticAccess(typeElement, eventMethod) || inputModel.isRootType(eventMethod.getType()) || inputModel.hasSyntheticAccessorFor(eventMethod)) {
            return true;
        }
        processingEnvironment.getMessager().printMessage(Diagnostic.Kind.WARNING, ErrorMessages.INSTANCE.failedToGenerateAdapter(typeElement, eventMethod), (Element) typeElement);
        return false;
    }
}
