package com.samsung.android.support.senl.addons.base.binding.binder;

import android.view.View;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0016\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001a\u001bB\u0013\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0000J\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\tJ\u001a\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\"\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0019\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/CompositeBinder;", "Lcom/samsung/android/support/senl/addons/base/binding/binder/Binder;", "root", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "mChild", "", "mMappers", "Lcom/samsung/android/support/senl/addons/base/binding/binder/CompositeBinder$BindMapper;", "enableMapper", "", "addChild", "binder", "addMapper", "mapper", "setViewModel", "id", "", "viewModel", "Lcom/samsung/android/support/senl/addons/base/viewmodel/common/IBaseViewModel;", "setViewModelToChild", "child", "findViewModelId", "", "unBind", "BindMapper", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class CompositeBinder extends Binder {

    @NotNull
    private static final String TAG = Logger.createTag("CompositeBinder");

    @NotNull
    private final List<Binder> mChild;

    @NotNull
    private final List<BindMapper> mMappers;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CompositeBinder(@Nullable View view) {
        super(view);
        Intrinsics.checkNotNull(view);
        this.mChild = new ArrayList();
        this.mMappers = new ArrayList();
    }

    private final boolean findViewModelId(String id) {
        Iterator<BindMapper> it = this.mMappers.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next().getMMapperName(), id)) {
                return true;
            }
        }
        return false;
    }

    private final void setViewModelToChild(Binder child, String id, IBaseViewModel viewModel) {
        if (child instanceof CompositeBinder) {
            CompositeBinder compositeBinder = (CompositeBinder) child;
            for (BindMapper bindMapper : compositeBinder.mMappers) {
                if (Intrinsics.areEqual(bindMapper.getMHolderName(), id) && (viewModel instanceof com.samsung.android.support.senl.addons.base.viewmodel.common.IViewModelHolder)) {
                    String mMapperName = bindMapper.getMMapperName();
                    Intrinsics.checkNotNull(mMapperName);
                    compositeBinder.setViewModel(mMapperName, ((com.samsung.android.support.senl.addons.base.viewmodel.common.IViewModelHolder) viewModel).getViewModel(bindMapper.getMIndex()));
                }
            }
        }
    }

    public final void addChild(@NotNull CompositeBinder binder) {
        Intrinsics.checkNotNullParameter(binder, "binder");
        this.mChild.add(binder);
    }

    public final void addMapper(@NotNull BindMapper mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        this.mMappers.add(mapper);
    }

    public final void enableMapper() {
        setMIsLinkable(true);
    }

    @Override // com.samsung.android.support.senl.addons.base.binding.binder.Binder
    public void setViewModel(@NotNull String id, @Nullable IBaseViewModel viewModel) {
        Intrinsics.checkNotNullParameter(id, "id");
        if (getMIsLinkable() && !findViewModelId(id)) {
            AbstractC6670b.m4763x("not allowed viewmodel : ", id, TAG);
            return;
        }
        super.setViewModel(id, viewModel);
        for (Binder binder : this.mChild) {
            if (binder.getMIsLinkable()) {
                setViewModelToChild(binder, id, viewModel);
            }
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.binding.binder.Binder
    public void unBind() {
        Iterator<Binder> it = this.mChild.iterator();
        while (it.hasNext()) {
            it.next().unBind();
        }
        this.mChild.clear();
        this.mMappers.clear();
        super.unBind();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B!\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/binder/CompositeBinder$BindMapper;", "", "bind", "Lcom/samsung/android/support/senl/addons/base/binding/binder/IViewBind;", "<init>", "(Lcom/samsung/android/support/senl/addons/base/binding/binder/IViewBind;)V", "holderName", "", "index", "", "mapperName", "(Ljava/lang/String;ILjava/lang/String;)V", "mHolderName", "getMHolderName", "()Ljava/lang/String;", "setMHolderName", "(Ljava/lang/String;)V", "mIndex", "getMIndex", "()I", "setMIndex", "(I)V", "mMapperName", "getMMapperName", "setMMapperName", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class BindMapper {

        @Nullable
        private String mHolderName;
        private int mIndex;

        @Nullable
        private String mMapperName;

        public BindMapper(@NotNull IViewBind bind) {
            Intrinsics.checkNotNullParameter(bind, "bind");
            this.mHolderName = bind.getPropertyId();
            String bindingId = bind.getBindingId();
            if (bindingId != null) {
                this.mIndex = Integer.parseInt(bindingId);
            } else {
                Logger.m7101e(CompositeBinder.TAG, "getBindingId() returned null");
                this.mIndex = -1;
            }
            this.mMapperName = bind.getViewModelId();
        }

        @Nullable
        public final String getMHolderName() {
            return this.mHolderName;
        }

        public final int getMIndex() {
            return this.mIndex;
        }

        @Nullable
        public final String getMMapperName() {
            return this.mMapperName;
        }

        public final void setMHolderName(@Nullable String str) {
            this.mHolderName = str;
        }

        public final void setMIndex(int i) {
            this.mIndex = i;
        }

        public final void setMMapperName(@Nullable String str) {
            this.mMapperName = str;
        }

        public BindMapper(@NotNull String holderName, int i, @NotNull String mapperName) {
            Intrinsics.checkNotNullParameter(holderName, "holderName");
            Intrinsics.checkNotNullParameter(mapperName, "mapperName");
            this.mHolderName = holderName;
            this.mIndex = i;
            this.mMapperName = mapperName;
        }
    }
}
