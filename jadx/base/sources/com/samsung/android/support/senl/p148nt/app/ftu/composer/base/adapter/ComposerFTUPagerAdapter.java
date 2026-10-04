package com.samsung.android.support.senl.p148nt.app.ftu.composer.base.adapter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.viewpager.widget.PagerAdapter;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p148nt.base.winset.view.lottie.LottieResource;
import com.samsung.android.support.senl.p148nt.base.winset.view.lottie.LottieWithMessageLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p012C1.RunnableC0050f;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001b\u001a\u00020\u001cH$J\u000e\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\bJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010\b2\u0006\u0010 \u001a\u00020\u000bJ\u001a\u0010!\u001a\u00020\u001c2\b\u0010\"\u001a\u0004\u0018\u00010\u00142\b\u0010#\u001a\u0004\u0018\u00010\u0012J\u0018\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010 \u001a\u00020\u000bH\u0016J\u0010\u0010(\u001a\u00020\f2\u0006\u0010)\u001a\u00020*H$J \u0010+\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020'2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010,\u001a\u00020%H\u0016J\u0018\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020%H\u0016J\u0010\u00102\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020%H\u0016J\b\u00103\u001a\u00020\u000bH\u0016J\u0010\u00104\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R*\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\nX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u00066"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/ftu/composer/base/adapter/ComposerFTUPagerAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "<init>", "()V", "mHandler", "Landroid/os/Handler;", "mLottieResources", "", "Lcom/samsung/android/support/senl/nt/base/winset/view/lottie/LottieResource;", "mPages", "", "", "Lcom/samsung/android/support/senl/nt/base/winset/view/lottie/LottieWithMessageLayout;", "getMPages", "()Ljava/util/Map;", "setMPages", "(Ljava/util/Map;)V", "mPageContract", "Lcom/samsung/android/support/senl/nt/base/winset/view/lottie/LottieWithMessageLayout$Contract;", "mContract", "Lcom/samsung/android/support/senl/nt/app/ftu/composer/base/adapter/ComposerFTUPagerAdapter$Contract;", "mPendingAction", "Ljava/lang/Runnable;", "getMPendingAction", "()Ljava/lang/Runnable;", "setMPendingAction", "(Ljava/lang/Runnable;)V", "initPagerResources", "", "addLottieResource", "lottieResource", "getLottieResource", "position", "setContract", "contract", "pageContract", "instantiateItem", "", "container", "Landroid/view/ViewGroup;", "getComposerFTUPage", "context", "Landroid/content/Context;", "destroyItem", CoeditServiceConstants.Element.NAME_OBJECT, "isViewFromObject", "", "view", "Landroid/view/View;", "o", "getItemPosition", "getCount", "onPageSelected", "Contract", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class ComposerFTUPagerAdapter extends PagerAdapter {

    @Nullable
    private Contract mContract;

    @NotNull
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    @JvmField
    @Nullable
    protected List<LottieResource> mLottieResources;

    @Nullable
    private LottieWithMessageLayout.Contract mPageContract;

    @Nullable
    private Map<Integer, LottieWithMessageLayout> mPages;

    @Nullable
    private Runnable mPendingAction;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/ftu/composer/base/adapter/ComposerFTUPagerAdapter$Contract;", "", "isLayoutLoaded", "", "()Z", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Contract {
        boolean isLayoutLoaded();
    }

    public ComposerFTUPagerAdapter() {
        initPagerResources();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPageSelected$lambda$0(ComposerFTUPagerAdapter composerFTUPagerAdapter, int i) {
        composerFTUPagerAdapter.onPageSelected(i);
        composerFTUPagerAdapter.mPendingAction = null;
    }

    public final void addLottieResource(@NotNull LottieResource lottieResource) {
        Intrinsics.checkNotNullParameter(lottieResource, "lottieResource");
        if (this.mLottieResources == null) {
            this.mLottieResources = new ArrayList();
        }
        List<LottieResource> list = this.mLottieResources;
        Intrinsics.checkNotNull(list);
        list.add(lottieResource);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NotNull ViewGroup container, int position, @NotNull Object object) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(object, "object");
        container.removeView((View) object);
    }

    @NotNull
    public abstract LottieWithMessageLayout getComposerFTUPage(@NotNull Context context);

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        List<LottieResource> list = this.mLottieResources;
        if (list == null) {
            return 0;
        }
        Intrinsics.checkNotNull(list);
        return list.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NotNull Object object) {
        Intrinsics.checkNotNullParameter(object, "object");
        Object tag = ((View) object).getTag();
        Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) tag).intValue();
    }

    @Nullable
    public final LottieResource getLottieResource(int position) {
        List<LottieResource> list = this.mLottieResources;
        if (list == null) {
            return null;
        }
        Intrinsics.checkNotNull(list);
        return list.get(position);
    }

    @Nullable
    public final Map<Integer, LottieWithMessageLayout> getMPages() {
        return this.mPages;
    }

    @Nullable
    public final Runnable getMPendingAction() {
        return this.mPendingAction;
    }

    public abstract void initPagerResources();

    @Override // androidx.viewpager.widget.PagerAdapter
    @NotNull
    public Object instantiateItem(@NotNull ViewGroup container, int position) {
        Intrinsics.checkNotNullParameter(container, "container");
        if (this.mPages == null) {
            this.mPages = new HashMap();
        }
        Map<Integer, LottieWithMessageLayout> map = this.mPages;
        Intrinsics.checkNotNull(map);
        LottieWithMessageLayout composerFTUPage = map.get(Integer.valueOf(position));
        if (composerFTUPage == null && this.mLottieResources != null) {
            Context context = container.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            composerFTUPage = getComposerFTUPage(context);
            List<LottieResource> list = this.mLottieResources;
            Intrinsics.checkNotNull(list);
            LottieResource lottieResource = list.get(position);
            composerFTUPage.setLottieAnimation(lottieResource.getAssetName(), -1);
            Iterator<LottieResource.MessageInfo> it = lottieResource.getMessageInfos().iterator();
            while (it.hasNext()) {
                composerFTUPage.addMessageInfo(it.next());
            }
            composerFTUPage.setTag(Integer.valueOf(position));
            composerFTUPage.setContract(this.mPageContract);
            Integer numValueOf = Integer.valueOf(position);
            Map<Integer, LottieWithMessageLayout> map2 = this.mPages;
            Intrinsics.checkNotNull(map2);
            map2.put(numValueOf, composerFTUPage);
            Runnable runnable = this.mPendingAction;
            if (runnable != null) {
                Handler handler = this.mHandler;
                Intrinsics.checkNotNull(runnable);
                handler.post(runnable);
            }
        }
        if (composerFTUPage == null) {
            Object objInstantiateItem = super.instantiateItem(container, position);
            Intrinsics.checkNotNullExpressionValue(objInstantiateItem, "instantiateItem(...)");
            return objInstantiateItem;
        }
        if (composerFTUPage.getParent() instanceof ViewGroup) {
            ViewParent parent = composerFTUPage.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(composerFTUPage);
        }
        container.addView(composerFTUPage);
        return composerFTUPage;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NotNull View view, @NotNull Object o) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(o, "o");
        return Intrinsics.areEqual(view, o);
    }

    public void onPageSelected(int position) {
        if (this.mPages == null) {
            this.mPendingAction = new RunnableC0050f(this, position, 11);
            return;
        }
        Contract contract = this.mContract;
        if (contract != null) {
            Intrinsics.checkNotNull(contract);
            if (!contract.isLayoutLoaded()) {
                return;
            }
        }
        int count = getCount();
        for (int i = 0; i < count; i++) {
            Map<Integer, LottieWithMessageLayout> map = this.mPages;
            Intrinsics.checkNotNull(map);
            LottieWithMessageLayout lottieWithMessageLayout = map.get(Integer.valueOf(i));
            if (lottieWithMessageLayout != null) {
                if (position == i) {
                    lottieWithMessageLayout.playLottieAnimation();
                } else {
                    lottieWithMessageLayout.cancelLottieAnimation();
                }
            }
        }
    }

    public final void setContract(@Nullable Contract contract, @Nullable LottieWithMessageLayout.Contract pageContract) {
        this.mContract = contract;
        this.mPageContract = pageContract;
    }

    public final void setMPages(@Nullable Map<Integer, LottieWithMessageLayout> map) {
        this.mPages = map;
    }

    public final void setMPendingAction(@Nullable Runnable runnable) {
        this.mPendingAction = runnable;
    }
}
