package com.samsung.android.support.senl.addons.base.binding.binder;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.addons.base.binding.binder.CompositeBinder;
import com.samsung.android.support.senl.addons.base.binding.binder.IBinding;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \"2\u00020\u0001:\u0002!\"B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\f\u001a\u00020\u00002\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bJ\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\u0010\u001a\u00020\u0011J\u001e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u001e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u001e\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0018\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\tH\u0002J\u001e\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00112\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J&\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020 2\u0006\u0010\u0014\u001a\u00020\u00112\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BinderBuilder;", "", "root", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "mRoot", "mBindings", "", "Lcom/samsung/android/support/senl/addons/base/binding/binder/IViewBind;", "mCustomBindingFactory", "Lcom/samsung/android/support/senl/addons/base/binding/binder/IBindingFactory;", "addBindings", "binds", "setCustomBindingFactory", "factory", "build", "Lcom/samsung/android/support/senl/addons/base/binding/binder/Binder;", "buildBinder", "", "binder", "Lcom/samsung/android/support/senl/addons/base/binding/binder/CompositeBinder;", "bindings", "preProcess", "processForIncludes", "buildInclude", "bind", "Lcom/samsung/android/support/senl/addons/base/binding/binder/IncludeBind;", "addMapper", "info", "processForViewStub", "initStub", "Lcom/samsung/android/support/senl/addons/base/binding/binder/ViewStubBind;", "StubInflateListener", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BinderBuilder {

    @NotNull
    private static final String TAG = Logger.createTag("BinderBuilder");

    @NotNull
    private final List<IViewBind> mBindings;

    @Nullable
    private IBindingFactory mCustomBindingFactory;

    @Nullable
    private View mRoot;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/BinderBuilder$StubInflateListener;", "Landroid/view/ViewStub$OnInflateListener;", "binds", "", "Lcom/samsung/android/support/senl/addons/base/binding/binder/IViewBind;", "binder", "Lcom/samsung/android/support/senl/addons/base/binding/binder/Binder;", "<init>", "(Ljava/util/List;Lcom/samsung/android/support/senl/addons/base/binding/binder/Binder;)V", "mBindList", "mBinderWRef", "Ljava/lang/ref/WeakReference;", "onInflate", "", "viewStub", "Landroid/view/ViewStub;", "view", "Landroid/view/View;", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class StubInflateListener implements ViewStub.OnInflateListener {

        @Nullable
        private List<IViewBind> mBindList;

        @NotNull
        private final WeakReference<Binder> mBinderWRef;

        public StubInflateListener(@NotNull List<IViewBind> binds, @NotNull Binder binder) {
            Intrinsics.checkNotNullParameter(binds, "binds");
            Intrinsics.checkNotNullParameter(binder, "binder");
            this.mBindList = new ArrayList();
            int size = binds.size();
            for (int i = 0; i < size; i++) {
                List<IViewBind> list = this.mBindList;
                Intrinsics.checkNotNull(list, "null cannot be cast to non-null type java.util.ArrayList<com.samsung.android.support.senl.addons.base.binding.binder.IViewBind>");
                ((ArrayList) list).add(binds.get(i));
            }
            this.mBinderWRef = new WeakReference<>(binder);
        }

        @Override // android.view.ViewStub.OnInflateListener
        public void onInflate(@NotNull ViewStub viewStub, @NotNull View view) {
            List<IViewBind> list;
            Intrinsics.checkNotNullParameter(viewStub, "viewStub");
            Intrinsics.checkNotNullParameter(view, "view");
            Binder binder = this.mBinderWRef.get();
            if (binder == null || (list = this.mBindList) == null) {
                return;
            }
            Intrinsics.checkNotNull(list);
            for (IViewBind iViewBind : list) {
                View viewFindViewById = view.findViewById(iViewBind.getMViewId());
                int mViewKey = iViewBind.getMViewKey();
                Intrinsics.checkNotNull(viewFindViewById);
                binder.changeView(mViewKey, viewFindViewById);
            }
            this.mBinderWRef.clear();
            List<IViewBind> list2 = this.mBindList;
            Intrinsics.checkNotNull(list2);
            list2.clear();
            this.mBindList = null;
            viewStub.setOnInflateListener(null);
        }
    }

    public BinderBuilder(@NotNull View root) {
        Intrinsics.checkNotNullParameter(root, "root");
        this.mBindings = new ArrayList();
        this.mRoot = root;
    }

    private final void addMapper(CompositeBinder binder, IViewBind info) {
        CompositeBinder.BindMapper bindMapper = new CompositeBinder.BindMapper(info);
        String str = TAG;
        String mHolderName = bindMapper.getMHolderName();
        int mIndex = bindMapper.getMIndex();
        String mMapperName = bindMapper.getMMapperName();
        StringBuilder sbM780v = AbstractC0541b.m780v("include mapper : holder = ", mIndex, mHolderName, " @ ", " => ");
        sbM780v.append(mMapperName);
        Logger.m7100d(str, sbM780v.toString());
        binder.addMapper(bindMapper);
    }

    private final void buildBinder(CompositeBinder binder, List<IViewBind> bindings) {
        IBindingFactory iBindingFactory;
        ArrayList arrayList = new ArrayList();
        View root = binder.getRoot();
        preProcess(binder, bindings);
        for (IViewBind iViewBind : bindings) {
            View viewFindViewById = root.findViewById(iViewBind.getMViewId());
            if (viewFindViewById != null) {
                IBinding iBindingCreateBinding = BindingFactory.INSTANCE.createBinding(iViewBind, binder);
                if ((iBindingCreateBinding instanceof IBinding.EmptyBinding) && (iBindingFactory = this.mCustomBindingFactory) != null) {
                    Intrinsics.checkNotNull(iBindingFactory);
                    iBindingCreateBinding = iBindingFactory.createBinding(iViewBind, binder);
                    Intrinsics.checkNotNull(iBindingCreateBinding);
                }
                if (TextUtils.isEmpty(iViewBind.getMViewModelId())) {
                    binder.addView(iViewBind.getMViewKey(), viewFindViewById);
                    iBindingCreateBinding.bind();
                } else {
                    binder.addBinding(viewFindViewById, iBindingCreateBinding);
                    arrayList.add(iViewBind);
                }
            } else {
                Logger.m7105w(TAG, "buildBinder - null view for " + iViewBind.getMViewKey());
            }
        }
        bindings.removeAll(arrayList);
    }

    private final CompositeBinder buildInclude(IncludeBind bind) {
        int mViewId = bind.getMViewId();
        String str = TAG;
        Logger.m7100d(str, "buildInclude : " + bind.getMSize() + " / " + bind.getMInfos().size());
        AbstractC6670b.m4763x("buildInclude : view ", Integer.toHexString(mViewId), str);
        View view = this.mRoot;
        IncludedBinder includedBinder = new IncludedBinder(view != null ? view.findViewById(mViewId) : null);
        Iterator<IViewBind> it = bind.getMInfos().iterator();
        while (it.hasNext()) {
            addMapper(includedBinder, it.next());
        }
        buildBinder(includedBinder, bind.getMSubBinds());
        return includedBinder;
    }

    private final void initStub(ViewStubBind bind, Binder binder, List<IViewBind> bindings) {
        View view = this.mRoot;
        View viewFindViewById = view != null ? view.findViewById(bind.getMViewId()) : null;
        if (viewFindViewById instanceof ViewStub) {
            int mSize = bind.getMSize();
            ((ViewStub) viewFindViewById).setOnInflateListener(new StubInflateListener(bindings.subList(this.mBindings.indexOf(bind) + 1, (mSize + r4) - 1), binder));
        }
    }

    private final void preProcess(CompositeBinder binder, List<IViewBind> bindings) {
        processForIncludes(binder, bindings);
        processForViewStub(binder, bindings);
    }

    private final void processForIncludes(CompositeBinder binder, List<IViewBind> bindings) {
        ArrayList arrayList = new ArrayList();
        Logger.m7100d(TAG, "include - start : " + Integer.toHexString(bindings.hashCode()));
        for (IViewBind iViewBind : bindings) {
            if (iViewBind instanceof IncludeBind) {
                arrayList.add(iViewBind);
                binder.addChild(buildInclude((IncludeBind) iViewBind));
            }
        }
        bindings.removeAll(arrayList);
    }

    private final void processForViewStub(Binder binder, List<IViewBind> bindings) {
        ArrayList arrayList = new ArrayList();
        Logger.m7100d(TAG, "stub - start : " + Integer.toHexString(bindings.hashCode()));
        for (IViewBind iViewBind : bindings) {
            if (iViewBind instanceof ViewStubBind) {
                arrayList.add(iViewBind);
                initStub((ViewStubBind) iViewBind, binder, bindings);
            }
        }
        bindings.removeAll(arrayList);
    }

    @NotNull
    public final BinderBuilder addBindings(@Nullable List<IViewBind> binds) {
        if (binds != null) {
            this.mBindings.addAll(binds);
        }
        return this;
    }

    @NotNull
    public final Binder build() {
        CompositeBinder compositeBinder = new CompositeBinder(this.mRoot);
        buildBinder(compositeBinder, this.mBindings);
        this.mBindings.clear();
        this.mRoot = null;
        return compositeBinder;
    }

    @NotNull
    public final BinderBuilder setCustomBindingFactory(@Nullable IBindingFactory factory) {
        this.mCustomBindingFactory = factory;
        return this;
    }
}
