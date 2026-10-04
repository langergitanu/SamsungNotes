package com.samsung.android.support.senl.addons.base.binding.binder;

import android.view.View;
import com.samsung.android.support.senl.addons.base.common.IObservable;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0005\b&\u0018\u0000 42\u00020\u00012\u00020\u0002:\u000234B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0004J\u0016\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0004J\u0016\u0010 \u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u000eJ\u001a\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010%\u001a\u00020\u001c2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0010\u0010(\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u000bH\u0002J\u0006\u0010)\u001a\u00020\u001cJ\b\u0010*\u001a\u00020\u001cH\u0016J\b\u0010+\u001a\u00020\u001cH\u0002J@\u0010,\u001a\u00020\u001c26\u0010-\u001a2\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0018\u00010\fj\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0018\u0001`\u000fH\u0002J\u0018\u0010.\u001a\u00020\u001c2\u000e\u0010/\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u000100H\u0002J\u0014\u00101\u001a\u0004\u0018\u00010\u00132\b\u0010#\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u00102\u001a\u0004\u0018\u00010\u00042\u0006\u0010#\u001a\u00020\u0011H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bRH\u0010\t\u001a<\u0012\u0004\u0012\u00020\u000b\u00120\u0012.\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fj\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r`\u000f\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00040\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u00130\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u00065"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/Binder;", "Lcom/samsung/android/support/senl/addons/base/viewmodel/common/IBaseViewModel$Observer;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/IViewModelHolder;", "root", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "getRoot", "()Landroid/view/View;", "mBindingMaps", "", "", "Ljava/util/LinkedHashMap;", "", "Lcom/samsung/android/support/senl/addons/base/binding/binder/IBinding;", "Lkotlin/collections/LinkedHashMap;", "mViewMap", "", "mViewModelMap", "Lcom/samsung/android/support/senl/addons/base/viewmodel/common/IBaseViewModel;", "mViewModelHashMap", "mIsLinkable", "", "getMIsLinkable", "()Z", "setMIsLinkable", "(Z)V", "addView", "", "key", "view", "changeView", "addBinding", "binding", "setViewModel", "id", "viewModel", "onUpdate", "info", "Lcom/samsung/android/support/senl/addons/base/viewmodel/common/IBaseViewModel$Info;", "bindViewModel", "bind", "unBind", "unBindBindingMap", "unBindVmBindingMap", "vmBindingMap", "unBindBindList", "bindings", "", "getViewModel", "getView", "EmptyViewModel", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class Binder extends IBaseViewModel.Observer implements IViewModelHolder {

    @NotNull
    private static final String TAG = Logger.createTag("Binder");

    @NotNull
    private static final EmptyViewModel mEmptyViewModel = new EmptyViewModel();

    @Nullable
    private Map<String, LinkedHashMap<String, List<IBinding>>> mBindingMaps;
    private boolean mIsLinkable;

    @NotNull
    private final Map<Integer, View> mViewMap;

    @NotNull
    private Map<Integer, String> mViewModelHashMap;

    @NotNull
    private Map<String, IBaseViewModel> mViewModelMap;

    @NotNull
    private final View root;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\u0012\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/Binder$EmptyViewModel;", "Lcom/samsung/android/support/senl/addons/base/viewmodel/common/IBaseViewModel;", "<init>", "()V", "perform", "", "action", "Lcom/samsung/android/support/senl/addons/base/viewmodel/common/IBaseViewModel$Action;", "getData", "", "id", "", "close", "addObserver", "observer", "Lcom/samsung/android/support/senl/addons/base/viewmodel/common/IBaseViewModel$Observer;", "removeObserver", "notifyChanged", "type", "release", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class EmptyViewModel implements IBaseViewModel {
        @Override // com.samsung.android.support.senl.addons.base.common.IObservable
        public void addObserver(@Nullable IBaseViewModel.Observer observer) {
        }

        @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel
        public void close() {
        }

        @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel
        @NotNull
        public Object getData(@Nullable String id) {
            return Boolean.FALSE;
        }

        @Override // com.samsung.android.support.senl.addons.base.common.IObservable
        public void notifyChanged(@Nullable String type) {
        }

        @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel
        public void perform(@Nullable IBaseViewModel.Action action) {
            if (action != null) {
                action.setResult(Boolean.FALSE);
            }
        }

        @Override // com.samsung.android.support.senl.addons.base.common.IObservable
        public void release() {
        }

        @Override // com.samsung.android.support.senl.addons.base.common.IObservable
        public void removeObserver(@Nullable IBaseViewModel.Observer observer) {
        }
    }

    public Binder(@NotNull View root) {
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        this.mBindingMaps = new HashMap();
        this.mViewMap = new HashMap();
        this.mViewModelMap = new HashMap();
        this.mViewModelHashMap = new HashMap();
        Logger.m7100d(TAG, "construct : " + this + "  / " + root);
    }

    private final void bindViewModel(String id) {
        Map<String, LinkedHashMap<String, List<IBinding>>> map = this.mBindingMaps;
        Intrinsics.checkNotNull(map);
        LinkedHashMap<String, List<IBinding>> linkedHashMap = map.get(id);
        if (linkedHashMap == null) {
            return;
        }
        Set<Map.Entry<String, List<IBinding>>> setEntrySet = linkedHashMap.entrySet();
        Intrinsics.checkNotNullExpressionValue(setEntrySet, "<get-entries>(...)");
        Iterator<Map.Entry<String, List<IBinding>>> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Iterator<IBinding> it2 = it.next().getValue().iterator();
            while (it2.hasNext()) {
                it2.next().bind();
            }
        }
    }

    private final void unBindBindList(List<? extends IBinding> bindings) {
        if (bindings == null) {
            return;
        }
        Iterator<? extends IBinding> it = bindings.iterator();
        while (it.hasNext()) {
            it.next().unbind();
        }
    }

    private final void unBindBindingMap() {
        Map<String, LinkedHashMap<String, List<IBinding>>> map = this.mBindingMaps;
        if (map == null) {
            return;
        }
        Intrinsics.checkNotNull(map);
        Iterator<LinkedHashMap<String, List<IBinding>>> it = map.values().iterator();
        while (it.hasNext()) {
            unBindVmBindingMap(it.next());
        }
        Map<String, LinkedHashMap<String, List<IBinding>>> map2 = this.mBindingMaps;
        Intrinsics.checkNotNull(map2);
        map2.clear();
        this.mBindingMaps = null;
    }

    private final void unBindVmBindingMap(LinkedHashMap<String, List<IBinding>> vmBindingMap) {
        if (vmBindingMap == null) {
            return;
        }
        for (List<IBinding> list : vmBindingMap.values()) {
            Intrinsics.checkNotNullExpressionValue(list, "next(...)");
            unBindBindList(list);
        }
    }

    public final void addBinding(@NotNull View view, @NotNull IBinding binding) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(binding, "binding");
        addView(binding.getMViewKey(), view);
        Map<String, LinkedHashMap<String, List<IBinding>>> map = this.mBindingMaps;
        Intrinsics.checkNotNull(map);
        LinkedHashMap<String, List<IBinding>> linkedHashMap = map.get(binding.getMViewModelId());
        if (linkedHashMap == null) {
            linkedHashMap = new LinkedHashMap<>();
            Map<String, LinkedHashMap<String, List<IBinding>>> map2 = this.mBindingMaps;
            Intrinsics.checkNotNull(map2);
            String mViewModelId = binding.getMViewModelId();
            Intrinsics.checkNotNull(mViewModelId);
            map2.put(mViewModelId, linkedHashMap);
        }
        List<IBinding> arrayList = linkedHashMap.get(binding.getMBindId());
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            linkedHashMap.put(binding.getMBindId(), arrayList);
        }
        arrayList.add(binding);
    }

    public final void addView(int key, @NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (!this.mViewMap.containsKey(Integer.valueOf(key))) {
            this.mViewMap.put(Integer.valueOf(key), view);
            return;
        }
        Logger.m7105w(TAG, "addView : contains key " + key + " / " + view);
    }

    public final void bind() {
    }

    public final void changeView(int key, @NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (this.mViewMap.containsKey(Integer.valueOf(key))) {
            Logger.m7100d(TAG, "changeView : found contains key " + key + " / " + view);
        }
        this.mViewMap.put(Integer.valueOf(key), view);
    }

    public final boolean getMIsLinkable() {
        return this.mIsLinkable;
    }

    @NotNull
    public final View getRoot() {
        return this.root;
    }

    @Override // com.samsung.android.support.senl.addons.base.binding.binder.IViewModelHolder
    @Nullable
    public View getView(int id) {
        return this.mViewMap.get(Integer.valueOf(id));
    }

    @Override // com.samsung.android.support.senl.addons.base.binding.binder.IViewModelHolder
    @Nullable
    public IBaseViewModel getViewModel(@Nullable String id) {
        IBaseViewModel iBaseViewModel = this.mViewModelMap.get(id);
        return iBaseViewModel == null ? mEmptyViewModel : iBaseViewModel;
    }

    public final void setMIsLinkable(boolean z) {
        this.mIsLinkable = z;
    }

    public void setViewModel(@NotNull String id, @Nullable IBaseViewModel viewModel) {
        Intrinsics.checkNotNullParameter(id, "id");
        IBaseViewModel iBaseViewModel = this.mViewModelMap.get(id);
        if (iBaseViewModel != null) {
            if (Intrinsics.areEqual(iBaseViewModel, viewModel)) {
                return;
            }
            this.mViewModelMap.remove(id);
            iBaseViewModel.removeObserver(this);
            this.mViewModelHashMap.remove(Integer.valueOf(iBaseViewModel.hashCode()));
        }
        if (viewModel != null) {
            viewModel.addObserver(this);
            this.mViewModelMap.put(id, viewModel);
            this.mViewModelHashMap.put(Integer.valueOf(viewModel.hashCode()), id);
        }
        bindViewModel(id);
    }

    public void unBind() {
        unBindBindingMap();
        this.mViewMap.clear();
        this.mViewModelMap.clear();
        this.mViewModelHashMap.clear();
    }

    @Override // com.samsung.android.support.senl.addons.base.common.IObservable.Observer
    public void onUpdate(@Nullable IBaseViewModel.Info info) {
        IObservable<String, IBaseViewModel.Observer> sender;
        String str;
        List<IBinding> list;
        if (info == null || (sender = info.getSender()) == null || (str = this.mViewModelHashMap.get(Integer.valueOf(sender.hashCode()))) == null) {
            return;
        }
        Map<String, LinkedHashMap<String, List<IBinding>>> map = this.mBindingMaps;
        Intrinsics.checkNotNull(map);
        LinkedHashMap<String, List<IBinding>> linkedHashMap = map.get(str);
        if (linkedHashMap == null || (list = linkedHashMap.get(info.getId())) == null) {
            return;
        }
        for (IBinding iBinding : list) {
            if (iBinding instanceof AbsExecuteBinding) {
                ((AbsExecuteBinding) iBinding).execute();
            }
        }
    }
}
