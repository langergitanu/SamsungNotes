package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.cover.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.cover.util.CoverStyleConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.cover.viewholder.CoverTemplateViewHolder;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002$%B9\u0012\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fJ\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0005H\u0016J\u0018\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0005H\u0016J\b\u0010\u001a\u001a\u00020\u0005H\u0016J\u0012\u0010\u001b\u001a\u00020\u00112\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0018\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u0007J\u0016\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0007J\u0018\u0010#\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0007H\u0002R \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/adapter/CoverTemplateAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/viewholder/CoverTemplateViewHolder;", "templateMap", "", "", "", "", "selectedTemplate", "selectedTypeIndex", "selectedColor", "<init>", "(Ljava/util/Map;Ljava/lang/String;ILjava/lang/String;)V", "selectedPosition", "templateContract", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/adapter/CoverTemplateAdapter$TemplateContract;", "setTemplateContract", "", "contract", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "initSelectedPosition", "updateSelectedType", "newTypeIndex", "updateSelectedColor", "newColor", "updateSelectedTemplate", "templateUuid", "colorUuid", "onTemplateSelected", "TemplateContract", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class CoverTemplateAdapter extends RecyclerView.Adapter<CoverTemplateViewHolder> {

    @NotNull
    public static final String TAG = "CoverTemplateAdapter";

    @NotNull
    private String selectedColor;
    private int selectedPosition;
    private int selectedTypeIndex;

    @Nullable
    private TemplateContract templateContract;

    @NotNull
    private final Map<Integer, List<String>> templateMap;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/adapter/CoverTemplateAdapter$TemplateContract;", "", "onSelectTemplate", "", "position", "", "templateUuid", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface TemplateContract {
        void onSelectTemplate(int position, @NotNull String templateUuid);
    }

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.cover.adapter.CoverTemplateAdapter$onCreateViewHolder$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    public /* synthetic */ class C103561 extends FunctionReferenceImpl implements Function2<Integer, String, Unit> {
        public C103561(Object obj) {
            super(2, obj, CoverTemplateAdapter.class, "onTemplateSelected", "onTemplateSelected(ILjava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
            invoke(num.intValue(), str);
            return Unit.INSTANCE;
        }

        public final void invoke(int i, String p1) {
            Intrinsics.checkNotNullParameter(p1, "p1");
            ((CoverTemplateAdapter) this.receiver).onTemplateSelected(i, p1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CoverTemplateAdapter(@NotNull Map<Integer, ? extends List<String>> templateMap, @NotNull String selectedTemplate, int i, @NotNull String selectedColor) {
        Intrinsics.checkNotNullParameter(templateMap, "templateMap");
        Intrinsics.checkNotNullParameter(selectedTemplate, "selectedTemplate");
        Intrinsics.checkNotNullParameter(selectedColor, "selectedColor");
        this.templateMap = templateMap;
        this.selectedTypeIndex = i;
        this.selectedColor = selectedColor;
        initSelectedPosition(selectedTemplate);
    }

    private final void initSelectedPosition(String selectedTemplate) {
        List<String> list;
        if (selectedTemplate == null) {
            return;
        }
        int iIndexOf = 0;
        if (!Intrinsics.areEqual(selectedTemplate, "DEFAULT:///") && (list = this.templateMap.get(Integer.valueOf(this.selectedTypeIndex))) != null) {
            iIndexOf = list.indexOf(selectedTemplate);
        }
        this.selectedPosition = iIndexOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onTemplateSelected(int position, String templateUuid) {
        notifyItemChanged(this.selectedPosition);
        this.selectedPosition = position;
        TemplateContract templateContract = this.templateContract;
        if (templateContract != null) {
            templateContract.onSelectTemplate(position, templateUuid);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<String> list = this.templateMap.get(Integer.valueOf(this.selectedTypeIndex));
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public final void setTemplateContract(@NotNull TemplateContract contract) {
        Intrinsics.checkNotNullParameter(contract, "contract");
        this.templateContract = contract;
    }

    public final void updateSelectedColor(@NotNull String newColor) {
        Intrinsics.checkNotNullParameter(newColor, "newColor");
        this.selectedColor = newColor;
        notifyDataSetChanged();
    }

    public final void updateSelectedTemplate(@NotNull String templateUuid, @NotNull String colorUuid) {
        Intrinsics.checkNotNullParameter(templateUuid, "templateUuid");
        Intrinsics.checkNotNullParameter(colorUuid, "colorUuid");
        this.selectedTypeIndex = CoverStyleConstants.CoverType.TEXT.ordinal();
        this.selectedColor = colorUuid;
        initSelectedPosition(templateUuid);
        notifyDataSetChanged();
    }

    public final void updateSelectedType(int newTypeIndex, @Nullable String selectedTemplate) {
        if (this.selectedTypeIndex != newTypeIndex) {
            this.selectedTypeIndex = newTypeIndex;
            initSelectedPosition(selectedTemplate);
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull CoverTemplateViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(position, this.selectedPosition, this.selectedTypeIndex, this.selectedColor);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public CoverTemplateViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(C9086R.layout.cover_style_template_item, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new CoverTemplateViewHolder(viewInflate, this.templateMap, new C103561(this));
    }
}
