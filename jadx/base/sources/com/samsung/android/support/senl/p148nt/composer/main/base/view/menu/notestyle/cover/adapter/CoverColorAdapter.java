package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.cover.adapter;

import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.cover.viewholder.CoverColorViewHolder;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001e\u001fB+\u0012\u0018\u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rJ\u0006\u0010\u0011\u001a\u00020\u0007J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0007H\u0016J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0007H\u0016J\b\u0010\u0019\u001a\u00020\u0007H\u0016J\u0012\u0010\u001a\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0002J\u000e\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u0006J\u0018\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0006H\u0002R \u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/adapter/CoverColorAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/viewholder/CoverColorViewHolder;", "colorList", "", "Landroid/util/Pair;", "", "", "selectedColor", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "selectedPosition", "colorContract", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/adapter/CoverColorAdapter$ColorContract;", "setColorContract", "", "contract", "getSelectedPosition", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "initSelectedPosition", "updateSelectedColor", "colorUuid", "onColorSelected", "ColorContract", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nCoverColorAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoverColorAdapter.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/adapter/CoverColorAdapter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,69:1\n360#2,7:70\n1#3:77\n*S KotlinDebug\n*F\n+ 1 CoverColorAdapter.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/adapter/CoverColorAdapter\n*L\n46#1:70,7\n*E\n"})
public final class CoverColorAdapter extends RecyclerView.Adapter<CoverColorViewHolder> {

    @NotNull
    public static final String TAG = "CoverColorAdapter";

    @Nullable
    private ColorContract colorContract;

    @NotNull
    private final List<Pair<String, Integer>> colorList;
    private int selectedPosition;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/adapter/CoverColorAdapter$ColorContract;", "", "onSelectColor", "", "position", "", "colorUuid", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface ColorContract {
        void onSelectColor(int position, @NotNull String colorUuid);
    }

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.cover.adapter.CoverColorAdapter$onCreateViewHolder$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    public /* synthetic */ class C103541 extends FunctionReferenceImpl implements Function2<Integer, String, Unit> {
        public C103541(Object obj) {
            super(2, obj, CoverColorAdapter.class, "onColorSelected", "onColorSelected(ILjava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
            invoke(num.intValue(), str);
            return Unit.INSTANCE;
        }

        public final void invoke(int i, String p1) {
            Intrinsics.checkNotNullParameter(p1, "p1");
            ((CoverColorAdapter) this.receiver).onColorSelected(i, p1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CoverColorAdapter(@NotNull List<? extends Pair<String, Integer>> colorList, @Nullable String str) {
        Intrinsics.checkNotNullParameter(colorList, "colorList");
        this.colorList = colorList;
        initSelectedPosition(str);
    }

    private final void initSelectedPosition(String selectedColor) {
        if (selectedColor == null) {
            return;
        }
        int iIntValue = 0;
        if (!Intrinsics.areEqual(selectedColor, "DEFAULT:///")) {
            Iterator<Pair<String, Integer>> it = this.colorList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    iIntValue = -1;
                    break;
                } else if (StringsKt__StringsJVMKt.equals((String) it.next().first, selectedColor, true)) {
                    break;
                } else {
                    iIntValue++;
                }
            }
            Integer numValueOf = Integer.valueOf(iIntValue);
            if (iIntValue < 0) {
                numValueOf = null;
            }
            iIntValue = numValueOf != null ? numValueOf.intValue() : this.selectedPosition;
        }
        this.selectedPosition = iIntValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onColorSelected(int position, String colorUuid) {
        notifyItemChanged(this.selectedPosition);
        this.selectedPosition = position;
        ColorContract colorContract = this.colorContract;
        if (colorContract != null) {
            colorContract.onSelectColor(position, colorUuid);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.colorList.size();
    }

    public final int getSelectedPosition() {
        return this.selectedPosition;
    }

    public final void setColorContract(@NotNull ColorContract contract) {
        Intrinsics.checkNotNullParameter(contract, "contract");
        this.colorContract = contract;
    }

    public final void updateSelectedColor(@NotNull String colorUuid) {
        Intrinsics.checkNotNullParameter(colorUuid, "colorUuid");
        initSelectedPosition(colorUuid);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull CoverColorViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(position, this.selectedPosition);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public CoverColorViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(C9086R.layout.cover_style_color_item, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new CoverColorViewHolder(viewInflate, this.colorList, new C103541(this));
    }
}
