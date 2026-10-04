package com.samsung.android.support.senl.p148nt.stt.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Layout;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.datepicker.ViewOnFocusChangeListenerC4697c;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.TranslatorCommonHelper;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.stt.C11493R;
import com.samsung.android.support.senl.p148nt.stt.base.model.AiTextData;
import com.samsung.android.support.senl.p148nt.stt.base.model.TextData;
import com.samsung.android.support.senl.p148nt.stt.base.model.paint.PaintHelper;
import com.samsung.android.support.senl.p148nt.stt.common.constant.DialogConstant;
import com.samsung.android.support.senl.p148nt.stt.common.util.search.SearchFoundItem;
import com.samsung.android.support.senl.p148nt.stt.view.dialog.STTDialogFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010%\n\u0002\u0010\b\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 Q2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003OPQB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010,\u001a\u00020-2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u0018\u00102\u001a\u00020\u00022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u001bH\u0016J\u001a\u00106\u001a\u00020-2\u0006\u00107\u001a\u00020\u00022\b\b\u0001\u00108\u001a\u00020\u001bH\u0016J\u0010\u00109\u001a\u00020-2\u0006\u00108\u001a\u00020\u001bH\u0002J\u0018\u0010:\u001a\u00020-2\u0006\u00107\u001a\u00020\u00022\u0006\u00108\u001a\u00020\u001bH\u0002J\u0010\u0010;\u001a\u00020-2\u0006\u00107\u001a\u00020\u0002H\u0016J\u0010\u0010<\u001a\u00020-2\u0006\u00107\u001a\u00020\u0002H\u0002J\u0010\u0010=\u001a\u00020-2\u0006\u00107\u001a\u00020\u0002H\u0003J\u0010\u0010>\u001a\u00020-2\u0006\u00107\u001a\u00020\u0002H\u0002J\u000e\u0010?\u001a\u00020-2\u0006\u00108\u001a\u00020\u001bJ\u0010\u0010@\u001a\u00020\r2\u0006\u00108\u001a\u00020\u001bH\u0002J\u001c\u0010A\u001a\u00020-2\u0014\u0010B\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\r\u0018\u00010\u001aJ\u0018\u0010C\u001a\u00020\u001b2\u0006\u00108\u001a\u00020\u001b2\u0006\u0010D\u001a\u00020\u001bH\u0002J \u0010E\u001a\u00020\u001b2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020\u001b2\u0006\u0010I\u001a\u00020\u001bH\u0002J\u000e\u0010J\u001a\u00020-2\u0006\u00107\u001a\u00020\u001eJ\u0006\u0010K\u001a\u00020-J\b\u0010L\u001a\u00020\u001bH\u0016J\f\u0010M\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u0006\u0010N\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0013\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\u001a\u0010\u0015\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001a\u0010\u0017\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010R\u001c\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\r\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020!0 j\b\u0012\u0004\u0012\u00020!`\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0017\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001e0/8F¢\u0006\u0006\u001a\u0004\b0\u00101¨\u0006R"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/view/AiSTTListViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/samsung/android/support/senl/nt/stt/view/AiSTTListViewAdapter$AiSTTListViewHolder;", "mAdapterContract", "Lcom/samsung/android/support/senl/nt/stt/view/AiSTTListViewAdapterContract;", "<init>", "(Lcom/samsung/android/support/senl/nt/stt/view/AiSTTListViewAdapterContract;)V", "mContext", "Landroid/content/Context;", "mAiTextDataItems", "", "Lcom/samsung/android/support/senl/nt/stt/base/model/AiTextData;", "isShowSpeakerLabel", "", "()Z", "setShowSpeakerLabel", "(Z)V", "isEditMode", "setEditMode", "isTranslateMode", "setTranslateMode", "isSelectionMode", "setSelectionMode", "isShowingSpeakerRenameDialog", "setShowingSpeakerRenameDialog", "mSelectedMap", "", "", "mBoundViewHolders", "", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "foundItemList", "Ljava/util/ArrayList;", "Lcom/samsung/android/support/senl/nt/stt/common/util/search/SearchFoundItem;", "Lkotlin/collections/ArrayList;", "getFoundItemList", "()Ljava/util/ArrayList;", "setFoundItemList", "(Ljava/util/ArrayList;)V", "currentSearchPosition", "getCurrentSearchPosition", "()I", "setCurrentSearchPosition", "(I)V", "setAiTextDataItemsItem", "", "allBoundViewHolders", "", "getAllBoundViewHolders", "()Ljava/util/Set;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "updateSearchHighlight", "onHolderGeneralView", "onViewRecycled", "initListener", "initItemTouchEvent", "showSpeakerRenameDialog", "toggleSelectItem", "isItemChecked", "setSelectedMap", "selectedMap", "getTouchWordTimestamp", "charIndex", "getTouchedViewIndex", "textView", "Landroid/widget/TextView;", "x", "y", "updateMarginSize", "updateAISTTListMargin", "getItemCount", "getAiTextDataItems", "isAtLeastOneUI7", "AiSTTListViewHolder", "CustomEditTextListener", "Companion", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AiSTTListViewAdapter extends RecyclerView.Adapter<AiSTTListViewHolder> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "AiSTTListViewAdapter";
    private int currentSearchPosition;

    @NotNull
    private ArrayList<SearchFoundItem> foundItemList;
    private boolean isEditMode;
    private boolean isSelectionMode;
    private boolean isShowSpeakerLabel;
    private boolean isShowingSpeakerRenameDialog;
    private boolean isTranslateMode;

    @NotNull
    private final AiSTTListViewAdapterContract mAdapterContract;

    @NotNull
    private List<AiTextData> mAiTextDataItems;

    @NotNull
    private final Set<RecyclerView.ViewHolder> mBoundViewHolders;

    @Nullable
    private Context mContext;

    @Nullable
    private Map<Integer, Boolean> mSelectedMap;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/view/AiSTTListViewAdapter$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "unwrap", "Landroid/app/Activity;", "context", "Landroid/content/Context;", "getStringByDuration", XmlErrorCodes.DURATION, "", "showMS", "", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Activity unwrap(Context context) {
            while (!(context instanceof Activity) && (context instanceof ContextWrapper)) {
                context = ((ContextWrapper) context).getBaseContext();
                Intrinsics.checkNotNullExpressionValue(context, "getBaseContext(...)");
            }
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            return (Activity) context;
        }

        @JvmStatic
        @NotNull
        public final String getStringByDuration(long duration, boolean showMS) {
            long j = duration / ((long) 1000);
            long j2 = (duration / ((long) 100)) - (((long) 10) * j);
            long j3 = j / ((long) 3600);
            long j5 = 60;
            long j6 = (j / j5) % j5;
            long j7 = j % j5;
            if (showMS) {
                if (j3 > 0) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    return AbstractC11014a.m12323h(new Object[]{Long.valueOf(j3), Long.valueOf(j6), Long.valueOf(j7), Long.valueOf(j2)}, 4, Locale.getDefault(), "%02d:%02d:%02d.%d", "format(...)");
                }
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                return AbstractC11014a.m12323h(new Object[]{Long.valueOf(j6), Long.valueOf(j7), Long.valueOf(j2)}, 3, Locale.getDefault(), "%02d:%02d.%d", "format(...)");
            }
            if (j3 > 0) {
                StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                return AbstractC11014a.m12323h(new Object[]{Long.valueOf(j3), Long.valueOf(j6), Long.valueOf(j7)}, 3, Locale.getDefault(), "%02d:%02d:%02d", "format(...)");
            }
            StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
            return AbstractC11014a.m12323h(new Object[]{Long.valueOf(j6), Long.valueOf(j7)}, 2, Locale.getDefault(), "%02d:%02d", "format(...)");
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007J(\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J(\u0010\u0012\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/view/AiSTTListViewAdapter$CustomEditTextListener;", "Landroid/text/TextWatcher;", "<init>", "(Lcom/samsung/android/support/senl/nt/stt/view/AiSTTListViewAdapter;)V", "position", "", "isFocusing", "", "updatePosition", "", "updateFocus", "focus", "beforeTextChanged", "s", "", "start", "count", "after", "onTextChanged", "before", "afterTextChanged", "editable", "Landroid/text/Editable;", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class CustomEditTextListener implements TextWatcher {
        private boolean isFocusing;
        private int position;

        public CustomEditTextListener() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@NotNull Editable editable) {
            Intrinsics.checkNotNullParameter(editable, "editable");
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@NotNull CharSequence s, int start, int count, int after) {
            Intrinsics.checkNotNullParameter(s, "s");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@NotNull CharSequence s, int start, int before, int count) {
            Intrinsics.checkNotNullParameter(s, "s");
            ((AiTextData) AiSTTListViewAdapter.this.mAiTextDataItems.get(this.position)).setText(s.toString());
            if (AiSTTListViewAdapter.this.getIsEditMode() && this.isFocusing && s.length() >= 1010) {
                ToastHandler.show(AiSTTListViewAdapter.this.mContext, C11493R.string.maximum_number_of_characters_reached, 0);
            }
            AiSTTListViewAdapter.this.mAdapterContract.onEditTextChanged(s.toString(), this.position);
        }

        public final void updateFocus(boolean focus) {
            this.isFocusing = focus;
        }

        public final void updatePosition(int position) {
            this.position = position;
        }
    }

    public AiSTTListViewAdapter(@NotNull AiSTTListViewAdapterContract mAdapterContract) {
        Intrinsics.checkNotNullParameter(mAdapterContract, "mAdapterContract");
        this.mAdapterContract = mAdapterContract;
        this.mBoundViewHolders = new HashSet();
        this.foundItemList = new ArrayList<>();
        this.currentSearchPosition = -1;
        this.mAiTextDataItems = new ArrayList();
    }

    @JvmStatic
    @NotNull
    public static final String getStringByDuration(long j, boolean z) {
        return INSTANCE.getStringByDuration(j, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getTouchWordTimestamp(int position, int charIndex) {
        ArrayList<TextData> textDataList = this.mAiTextDataItems.get(position).getTextDataList();
        int size = textDataList.size();
        int textLength = 0;
        for (int i = 0; i < size; i++) {
            TextData textData = textDataList.get(i);
            Intrinsics.checkNotNullExpressionValue(textData, "get(...)");
            TextData textData2 = textData;
            textLength += textData2.getTextLength();
            if (textLength > charIndex) {
                return textData2.getStartTime();
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getTouchedViewIndex(TextView textView, int x, int y2) {
        int scrollX = (textView.getScrollX() - textView.getTotalPaddingStart()) + x;
        int scrollY = (textView.getScrollY() - textView.getTotalPaddingTop()) + y2;
        Layout layout = textView.getLayout();
        return layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void initItemTouchEvent(final AiSTTListViewHolder holder) {
        final GestureDetector gestureDetector = new GestureDetector(this.mContext, new GestureDetector.SimpleOnGestureListener() { // from class: com.samsung.android.support.senl.nt.stt.view.AiSTTListViewAdapter$initItemTouchEvent$gestureDetector$1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent e) {
                Intrinsics.checkNotNullParameter(e, "e");
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent e) {
                Intrinsics.checkNotNullParameter(e, "e");
                if (this.this$0.getIsSelectionMode()) {
                    this.this$0.toggleSelectItem(holder.getPositionItem());
                    return true;
                }
                int touchWordTimestamp = this.this$0.getTouchWordTimestamp(holder.getPositionItem(), this.this$0.getTouchedViewIndex(holder.getContent(), (int) e.getX(), (int) e.getY()));
                if (touchWordTimestamp >= 0) {
                    this.this$0.mAdapterContract.onWordTouched(touchWordTimestamp);
                }
                return true;
            }
        });
        holder.getContent().setOnTouchListener(new View.OnTouchListener() { // from class: com.samsung.android.support.senl.nt.stt.view.AiSTTListViewAdapter.initItemTouchEvent.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                Intrinsics.checkNotNullParameter(v, "v");
                Intrinsics.checkNotNullParameter(event, "event");
                if (AiSTTListViewAdapter.this.getIsSelectionMode() || AiSTTListViewAdapter.this.getIsEditMode()) {
                    return false;
                }
                gestureDetector.onTouchEvent(event);
                return true;
            }
        });
        holder.getEditText().setOnTouchListener(new View.OnTouchListener() { // from class: com.samsung.android.support.senl.nt.stt.view.AiSTTListViewAdapter.initItemTouchEvent.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                Intrinsics.checkNotNullParameter(v, "v");
                Intrinsics.checkNotNullParameter(event, "event");
                if (!AiSTTListViewAdapter.this.getIsEditMode()) {
                    return true;
                }
                AiSTTListViewAdapter.this.mAdapterContract.onEditWordTouched();
                return false;
            }
        });
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.samsung.android.support.senl.nt.stt.view.AiSTTListViewAdapter$initListener$filter$1] */
    private final void initListener(final AiSTTListViewHolder holder) {
        initItemTouchEvent(holder);
        holder.getSpeakerIcon().setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.stt.view.AiSTTListViewAdapter.initListener.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Intrinsics.checkNotNullParameter(v, "v");
                if (AiSTTListViewAdapter.this.getIsSelectionMode()) {
                    AiSTTListViewAdapter.this.toggleSelectItem(holder.getPositionItem());
                } else if (AiSTTListViewAdapter.this.getIsEditMode()) {
                    AiSTTListViewAdapter.this.showSpeakerRenameDialog(holder);
                } else {
                    AiSTTListViewAdapter.this.mAdapterContract.onWordTouched(((AiTextData) AiSTTListViewAdapter.this.mAiTextDataItems.get(holder.getPositionItem())).getStartTime());
                }
            }
        });
        holder.getSpeakerName().setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.stt.view.AiSTTListViewAdapter.initListener.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Intrinsics.checkNotNullParameter(v, "v");
                if (AiSTTListViewAdapter.this.getIsSelectionMode()) {
                    AiSTTListViewAdapter.this.toggleSelectItem(holder.getPositionItem());
                } else if (AiSTTListViewAdapter.this.getIsEditMode()) {
                    AiSTTListViewAdapter.this.showSpeakerRenameDialog(holder);
                } else {
                    AiSTTListViewAdapter.this.mAdapterContract.onWordTouched(((AiTextData) AiSTTListViewAdapter.this.mAiTextDataItems.get(holder.getPositionItem())).getStartTime());
                }
            }
        });
        holder.getStartOfSpeech().setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.stt.view.AiSTTListViewAdapter.initListener.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Intrinsics.checkNotNullParameter(v, "v");
                if (AiSTTListViewAdapter.this.getIsSelectionMode()) {
                    AiSTTListViewAdapter.this.toggleSelectItem(holder.getPositionItem());
                } else {
                    if (AiSTTListViewAdapter.this.getIsEditMode()) {
                        return;
                    }
                    AiSTTListViewAdapter.this.mAdapterContract.onWordTouched(((AiTextData) AiSTTListViewAdapter.this.mAiTextDataItems.get(holder.getPositionItem())).getStartTime());
                }
            }
        });
        holder.getItemLayout().setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.stt.view.AiSTTListViewAdapter.initListener.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Intrinsics.checkNotNullParameter(v, "v");
                if (AiSTTListViewAdapter.this.getIsSelectionMode()) {
                    AiSTTListViewAdapter.this.toggleSelectItem(holder.getPositionItem());
                }
            }
        });
        holder.getEditText().setOnFocusChangeListener(new ViewOnFocusChangeListenerC4697c(holder, 8));
        holder.getEditText().setFilters(new AiSTTListViewAdapter$initListener$filter$1[]{new InputFilter.LengthFilter() { // from class: com.samsung.android.support.senl.nt.stt.view.AiSTTListViewAdapter$initListener$filter$1
            {
                super(1010);
            }

            @Override // android.text.InputFilter.LengthFilter, android.text.InputFilter
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                CharSequence charSequenceFilter = super.filter(source, start, end, dest, dstart, dend);
                if (this.this$0.getIsEditMode() && charSequenceFilter != null && charSequenceFilter.length() == 0) {
                    ToastHandler.show(this.this$0.mContext, C11493R.string.maximum_number_of_characters_reached, 0);
                }
                return charSequenceFilter;
            }
        }});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListener$lambda$0(AiSTTListViewHolder aiSTTListViewHolder, View view, boolean z) {
        aiSTTListViewHolder.getCustomEditTextListener().updateFocus(z);
    }

    private final boolean isItemChecked(int position) {
        Map<Integer, Boolean> map = this.mSelectedMap;
        if (map == null) {
            return false;
        }
        Intrinsics.checkNotNull(map);
        Boolean bool = map.get(Integer.valueOf(position));
        if (bool == null) {
            bool = Boolean.FALSE;
        }
        return bool.booleanValue();
    }

    private final void onHolderGeneralView(AiSTTListViewHolder holder, int position) {
        AiTextData aiTextData = this.mAiTextDataItems.get(position);
        holder.getContent().setText(aiTextData.getText());
        holder.getContent().setTextColor(ContextCompat.getColor(holder.getContent().getContext(), C11493R.color.ai_view_transcript_text_color));
        holder.getEditText().setText(aiTextData.getText());
        holder.getEditText().setTextColor(ContextCompat.getColor(holder.getContent().getContext(), C11493R.color.ai_view_transcript_text_color));
        holder.getSpeakerName().setText(aiTextData.getSpeakerName());
        holder.getSpeakerName().setTextColor(ContextCompat.getColor(holder.getSpeakerName().getContext(), C11493R.color.ai_view_speaker_text_color));
        holder.getStartOfSpeech().setText(INSTANCE.getStringByDuration(aiTextData.getStartTime(), false));
        holder.setPositionItem(position);
        switch (aiTextData.getSpeakerId()) {
            case 0:
                holder.getSpeakerIcon().setImageResource(C11493R.drawable.speaker_icon_0);
                break;
            case 1:
                holder.getSpeakerIcon().setImageResource(C11493R.drawable.speaker_icon_1);
                break;
            case 2:
                holder.getSpeakerIcon().setImageResource(C11493R.drawable.speaker_icon_2);
                break;
            case 3:
                holder.getSpeakerIcon().setImageResource(C11493R.drawable.speaker_icon_3);
                break;
            case 4:
                holder.getSpeakerIcon().setImageResource(C11493R.drawable.speaker_icon_4);
                break;
            case 5:
                holder.getSpeakerIcon().setImageResource(C11493R.drawable.speaker_icon_5);
                break;
            case 6:
                holder.getSpeakerIcon().setImageResource(C11493R.drawable.speaker_icon_6);
                break;
            case 7:
                holder.getSpeakerIcon().setImageResource(C11493R.drawable.speaker_icon_7);
                break;
            case 8:
                holder.getSpeakerIcon().setImageResource(C11493R.drawable.speaker_icon_8);
                break;
            default:
                holder.getSpeakerIcon().setImageResource(C11493R.drawable.speaker_icon_1);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showSpeakerRenameDialog(final AiSTTListViewHolder holder) {
        this.mAdapterContract.clearSTTFocus();
        Bundle bundle = new Bundle();
        bundle.putString("name", holder.getSpeakerName().getText().toString());
        bundle.putInt("request_code", 2);
        bundle.putInt("title_id", C11493R.string.change_speaker_label);
        bundle.putInt(DialogConstant.BUNDLE_POSITIVE_BTN_ID, C11493R.string.base_string_rename_type1);
        bundle.putInt(DialogConstant.BUNDLE_NEGATIVE_BTN_ID, C11493R.string.base_string_cancel_type1);
        bundle.putInt(DialogConstant.BUNDLE_SPEAKER_ID, this.mAiTextDataItems.get(holder.getPositionItem()).getSpeakerId());
        bundle.putInt("position", holder.getPositionItem());
        STTDialogFactory sTTDialogFactory = STTDialogFactory.INSTANCE;
        Activity activityUnwrap = INSTANCE.unwrap(holder.getContext());
        Intrinsics.checkNotNull(activityUnwrap, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        sTTDialogFactory.show(((AppCompatActivity) activityUnwrap).getSupportFragmentManager(), DialogConstant.SPEAKER_RENAME_DIALOG, bundle, new STTDialogFactory.DialogResultListener() { // from class: com.samsung.android.support.senl.nt.stt.view.AiSTTListViewAdapter.showSpeakerRenameDialog.1
            @Override // com.samsung.android.support.senl.nt.stt.view.dialog.STTDialogFactory.DialogResultListener
            public Map<Integer, String> getSpeakerNameMap() {
                return AiSTTListViewAdapter.this.mAdapterContract.getSpeakerNameMap();
            }

            @Override // com.samsung.android.support.senl.nt.stt.view.dialog.STTDialogFactory.DialogResultListener
            public boolean isShowing() {
                return AiSTTListViewAdapter.this.getIsShowingSpeakerRenameDialog();
            }

            @Override // com.samsung.android.support.senl.nt.stt.view.dialog.STTDialogFactory.DialogResultListener
            public void onDialogResult(DialogFragment dialog, Bundle bundle2) {
                AiSTTListViewAdapterContract aiSTTListViewAdapterContract = AiSTTListViewAdapter.this.mAdapterContract;
                Intrinsics.checkNotNull(bundle2);
                aiSTTListViewAdapterContract.onSpeakerRename(bundle2, holder.getAbsoluteAdapterPosition());
            }

            @Override // com.samsung.android.support.senl.nt.stt.view.dialog.STTDialogFactory.DialogResultListener
            public void setShowing(boolean z) {
                AiSTTListViewAdapter.this.setShowingSpeakerRenameDialog(z);
            }
        });
    }

    private final void updateSearchHighlight(int position) {
        AiTextData aiTextData = this.mAiTextDataItems.get(position);
        int size = this.foundItemList.size();
        int i = 0;
        while (i < size) {
            SearchFoundItem searchFoundItem = this.foundItemList.get(i);
            Intrinsics.checkNotNullExpressionValue(searchFoundItem, "get(...)");
            SearchFoundItem searchFoundItem2 = searchFoundItem;
            if (searchFoundItem2.position == position) {
                boolean z = this.currentSearchPosition == i;
                int keywordStart = searchFoundItem2.getKeywordStart();
                int keywordEnd = searchFoundItem2.getKeywordEnd();
                if (searchFoundItem2.getDeltaPosition() == 0) {
                    PaintHelper paintHelper = this.mAdapterContract.getPaintHelper();
                    if (paintHelper != null) {
                        paintHelper.appendSearchHighlight(aiTextData.getSpeakerName(), z, keywordStart, keywordEnd);
                    }
                } else if (searchFoundItem2.getIsTranslatedItem()) {
                    PaintHelper paintHelper2 = this.mAdapterContract.getPaintHelper();
                    if (paintHelper2 != null) {
                        paintHelper2.appendSearchHighlight(aiTextData.getTranslatedText(), z, keywordStart, keywordEnd);
                    }
                } else {
                    PaintHelper paintHelper3 = this.mAdapterContract.getPaintHelper();
                    if (paintHelper3 != null) {
                        paintHelper3.appendSearchHighlight(aiTextData.getText(), z, keywordStart, keywordEnd);
                    }
                }
            }
            i++;
        }
    }

    @NotNull
    public final List<AiTextData> getAiTextDataItems() {
        return this.mAiTextDataItems;
    }

    @NotNull
    public final Set<RecyclerView.ViewHolder> getAllBoundViewHolders() {
        Set<RecyclerView.ViewHolder> setUnmodifiableSet = Collections.unmodifiableSet(this.mBoundViewHolders);
        Intrinsics.checkNotNullExpressionValue(setUnmodifiableSet, "unmodifiableSet(...)");
        return setUnmodifiableSet;
    }

    public final int getCurrentSearchPosition() {
        return this.currentSearchPosition;
    }

    @NotNull
    public final ArrayList<SearchFoundItem> getFoundItemList() {
        return this.foundItemList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mAiTextDataItems.size();
    }

    public final boolean isAtLeastOneUI7() {
        return SystemPropertiesCompat.INSTANCE.getInstance().getOneUIVersion() >= 70000;
    }

    /* JADX INFO: renamed from: isEditMode, reason: from getter */
    public final boolean getIsEditMode() {
        return this.isEditMode;
    }

    /* JADX INFO: renamed from: isSelectionMode, reason: from getter */
    public final boolean getIsSelectionMode() {
        return this.isSelectionMode;
    }

    /* JADX INFO: renamed from: isShowSpeakerLabel, reason: from getter */
    public final boolean getIsShowSpeakerLabel() {
        return this.isShowSpeakerLabel;
    }

    /* JADX INFO: renamed from: isShowingSpeakerRenameDialog, reason: from getter */
    public final boolean getIsShowingSpeakerRenameDialog() {
        return this.isShowingSpeakerRenameDialog;
    }

    /* JADX INFO: renamed from: isTranslateMode, reason: from getter */
    public final boolean getIsTranslateMode() {
        return this.isTranslateMode;
    }

    public final void setAiTextDataItemsItem(@NotNull List<AiTextData> mAiTextDataItems) {
        Intrinsics.checkNotNullParameter(mAiTextDataItems, "mAiTextDataItems");
        this.mAiTextDataItems = mAiTextDataItems;
    }

    public final void setCurrentSearchPosition(int i) {
        this.currentSearchPosition = i;
    }

    public final void setEditMode(boolean z) {
        this.isEditMode = z;
    }

    public final void setFoundItemList(@NotNull ArrayList<SearchFoundItem> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.foundItemList = arrayList;
    }

    public final void setSelectedMap(@Nullable Map<Integer, Boolean> selectedMap) {
        this.mSelectedMap = selectedMap;
    }

    public final void setSelectionMode(boolean z) {
        this.isSelectionMode = z;
    }

    public final void setShowSpeakerLabel(boolean z) {
        this.isShowSpeakerLabel = z;
    }

    public final void setShowingSpeakerRenameDialog(boolean z) {
        this.isShowingSpeakerRenameDialog = z;
    }

    public final void setTranslateMode(boolean z) {
        this.isTranslateMode = z;
    }

    public final void toggleSelectItem(int position) {
        Map<Integer, Boolean> map = this.mSelectedMap;
        if (map != null) {
            Intrinsics.checkNotNull(map);
            Boolean bool = map.get(Integer.valueOf(position));
            if (bool == null) {
                bool = Boolean.FALSE;
            }
            Integer numValueOf = Integer.valueOf(position);
            Map<Integer, Boolean> map2 = this.mSelectedMap;
            Intrinsics.checkNotNull(map2);
            map2.put(numValueOf, Boolean.valueOf(!bool.booleanValue()));
            this.mAdapterContract.onItemCheckedChange(position, !bool.booleanValue());
            notifyItemChanged(position);
        }
    }

    public final void updateAISTTListMargin() {
        Iterator<RecyclerView.ViewHolder> it = this.mBoundViewHolders.iterator();
        while (it.hasNext()) {
            updateMarginSize(it.next());
        }
    }

    public final void updateMarginSize(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Context context = this.mContext;
        Intrinsics.checkNotNull(context);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(C11493R.dimen.ai_menu_result_stt_side_margin_size);
        if (isAtLeastOneUI7()) {
            Context context2 = this.mContext;
            Intrinsics.checkNotNull(context2);
            dimensionPixelSize = context2.getResources().getDimensionPixelSize(C11493R.dimen.ai_result_stt_side_margin_size);
        }
        View viewFindViewById = holder.itemView.findViewById(C11493R.id.item_layout);
        if (viewFindViewById != null) {
            viewFindViewById.setPaddingRelative(dimensionPixelSize, 0, dimensionPixelSize, 0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull AiSTTListViewHolder holder, @SuppressLint({"RecyclerView"}) int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (this.isEditMode) {
            holder.getContent().setVisibility(8);
            holder.getCheckBox().setVisibility(8);
            holder.getEditText().setVisibility(0);
            holder.getEditText().setHyphenationFrequency(1);
        } else if (this.isSelectionMode) {
            holder.getContent().setVisibility(0);
            holder.getCheckBox().setVisibility(0);
            holder.getEditText().setVisibility(8);
        } else {
            holder.getContent().setVisibility(0);
            holder.getCheckBox().setVisibility(8);
            holder.getEditText().setVisibility(8);
        }
        if (this.isShowSpeakerLabel) {
            holder.getSpeakerIcon().setVisibility(0);
            holder.getSpeakerName().setVisibility(0);
        } else {
            holder.getSpeakerIcon().setVisibility(8);
            holder.getSpeakerName().setVisibility(8);
        }
        AiTextData aiTextData = this.mAiTextDataItems.get(position);
        PaintHelper paintHelper = this.mAdapterContract.getPaintHelper();
        if (paintHelper != null) {
            paintHelper.clearSearchHighlight(aiTextData.getSpeakerName());
        }
        PaintHelper paintHelper2 = this.mAdapterContract.getPaintHelper();
        if (paintHelper2 != null) {
            paintHelper2.clearSearchHighlight(aiTextData.getText());
        }
        PaintHelper paintHelper3 = this.mAdapterContract.getPaintHelper();
        if (paintHelper3 != null) {
            paintHelper3.clearSearchHighlight(aiTextData.getTranslatedText());
        }
        if (!this.foundItemList.isEmpty()) {
            updateSearchHighlight(position);
        }
        if (this.isSelectionMode) {
            boolean zIsItemChecked = isItemChecked(position);
            holder.getCheckBox().setChecked(zIsItemChecked);
            if (zIsItemChecked) {
                ViewGroup itemLayout = holder.getItemLayout();
                Context context = this.mContext;
                Intrinsics.checkNotNull(context);
                itemLayout.setBackgroundColor(ContextCompat.getColor(context, C11493R.color.ai_page_selected_item_bg_color));
            } else {
                holder.getItemLayout().setBackgroundColor(0);
            }
        } else {
            holder.getItemLayout().setBackgroundColor(0);
        }
        holder.getEditText().getText().clearSpans();
        holder.getCustomEditTextListener().updatePosition(position);
        if (!this.isTranslateMode || TextUtils.isEmpty(aiTextData.getTranslatedText())) {
            holder.getTranslatedText().setVisibility(8);
        } else {
            holder.getTranslatedText().setVisibility(0);
            holder.getTranslatedText().setText(aiTextData.getTranslatedText());
        }
        onHolderGeneralView(holder, position);
        updateMarginSize(holder);
        this.mBoundViewHolders.add(holder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public AiSTTListViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        View viewInflate;
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        this.mContext = context;
        Intrinsics.checkNotNull(context);
        Object systemService = context.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        LayoutInflater layoutInflater = (LayoutInflater) systemService;
        if (isAtLeastOneUI7()) {
            viewInflate = layoutInflater.inflate(C11493R.layout.textdata_ai_stt_item, parent, false);
            Intrinsics.checkNotNull(viewInflate);
        } else {
            viewInflate = layoutInflater.inflate(C11493R.layout.textdata_stt_item, parent, false);
            Intrinsics.checkNotNull(viewInflate);
        }
        AiSTTListViewHolder aiSTTListViewHolder = new AiSTTListViewHolder(viewInflate, new CustomEditTextListener());
        initListener(aiSTTListViewHolder);
        return aiSTTListViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(@NotNull AiSTTListViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        this.mBoundViewHolders.remove(holder);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 >2\u00020\u0001:\u0001>B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005R\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010<\u001a\u00020=R\u001e\u0010\u0004\u001a\u00060\u0005R\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\u001a\u0010&\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0011\u0010,\u001a\u00020-¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u00100\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\b1\u0010 R\u0011\u00102\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\b3\u0010 R\u0011\u00104\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0014R\u001a\u00106\u001a\u000207X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;¨\u0006?"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/view/AiSTTListViewAdapter$AiSTTListViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "customEditTextListener", "Lcom/samsung/android/support/senl/nt/stt/view/AiSTTListViewAdapter$CustomEditTextListener;", "Lcom/samsung/android/support/senl/nt/stt/view/AiSTTListViewAdapter;", "<init>", "(Landroid/view/View;Lcom/samsung/android/support/senl/nt/stt/view/AiSTTListViewAdapter$CustomEditTextListener;)V", "getCustomEditTextListener", "()Lcom/samsung/android/support/senl/nt/stt/view/AiSTTListViewAdapter$CustomEditTextListener;", "setCustomEditTextListener", "(Lcom/samsung/android/support/senl/nt/stt/view/AiSTTListViewAdapter$CustomEditTextListener;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "itemLayout", "Landroid/view/ViewGroup;", "getItemLayout", "()Landroid/view/ViewGroup;", "setItemLayout", "(Landroid/view/ViewGroup;)V", "checkBox", "Landroid/widget/CheckBox;", "getCheckBox", "()Landroid/widget/CheckBox;", "setCheckBox", "(Landroid/widget/CheckBox;)V", "content", "Landroid/widget/TextView;", "getContent", "()Landroid/widget/TextView;", "setContent", "(Landroid/widget/TextView;)V", TranslatorCommonHelper.EXTRA_KEY_TRANSLATED_TEXT, "getTranslatedText", "setTranslatedText", "editText", "Landroid/widget/EditText;", "getEditText", "()Landroid/widget/EditText;", "setEditText", "(Landroid/widget/EditText;)V", "speakerIcon", "Landroid/widget/ImageView;", "getSpeakerIcon", "()Landroid/widget/ImageView;", "speakerName", "getSpeakerName", "startOfSpeech", "getStartOfSpeech", "itemContainer", "getItemContainer", "positionItem", "", "getPositionItem", "()I", "setPositionItem", "(I)V", "decorate", "", "Companion", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class AiSTTListViewHolder extends RecyclerView.ViewHolder {

        @NotNull
        private static final String TAG = "AI#OriginalViewHolder";

        @NotNull
        private CheckBox checkBox;

        @NotNull
        private TextView content;

        @NotNull
        private final Context context;

        @NotNull
        private CustomEditTextListener customEditTextListener;

        @NotNull
        private EditText editText;

        @NotNull
        private final ViewGroup itemContainer;

        @NotNull
        private ViewGroup itemLayout;
        private int positionItem;

        @NotNull
        private final ImageView speakerIcon;

        @NotNull
        private final TextView speakerName;

        @NotNull
        private final TextView startOfSpeech;

        @NotNull
        private TextView translatedText;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AiSTTListViewHolder(@NotNull View itemView, @NotNull CustomEditTextListener customEditTextListener) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            Intrinsics.checkNotNullParameter(customEditTextListener, "customEditTextListener");
            this.customEditTextListener = customEditTextListener;
            Context context = itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            this.context = context;
            View viewFindViewById = itemView.findViewById(C11493R.id.item_layout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.itemLayout = (ViewGroup) viewFindViewById;
            View viewFindViewById2 = itemView.findViewById(C11493R.id.stt_item_checkbox);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.checkBox = (CheckBox) viewFindViewById2;
            View viewFindViewById3 = itemView.findViewById(C11493R.id.stt_content);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
            this.content = (TextView) viewFindViewById3;
            View viewFindViewById4 = itemView.findViewById(C11493R.id.stt_translated_content);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
            this.translatedText = (TextView) viewFindViewById4;
            View viewFindViewById5 = itemView.findViewById(C11493R.id.stt_content_edit);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
            this.editText = (EditText) viewFindViewById5;
            View viewFindViewById6 = itemView.findViewById(C11493R.id.stt_speaker_icon);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
            this.speakerIcon = (ImageView) viewFindViewById6;
            View viewFindViewById7 = itemView.findViewById(C11493R.id.stt_speaker_name);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
            this.speakerName = (TextView) viewFindViewById7;
            View viewFindViewById8 = itemView.findViewById(C11493R.id.stt_start_of_speech);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
            this.startOfSpeech = (TextView) viewFindViewById8;
            View viewFindViewById9 = itemView.findViewById(C11493R.id.item_container);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
            this.itemContainer = (ViewGroup) viewFindViewById9;
            this.editText.addTextChangedListener(this.customEditTextListener);
            this.editText.setPrivateImeOptions("disableWritingToolkit=true");
            this.content.semSetMultiSelectionEnabled(false);
            this.translatedText.semSetMultiSelectionEnabled(false);
        }

        @NotNull
        public final CheckBox getCheckBox() {
            return this.checkBox;
        }

        @NotNull
        public final TextView getContent() {
            return this.content;
        }

        @NotNull
        public final Context getContext() {
            return this.context;
        }

        @NotNull
        public final CustomEditTextListener getCustomEditTextListener() {
            return this.customEditTextListener;
        }

        @NotNull
        public final EditText getEditText() {
            return this.editText;
        }

        @NotNull
        public final ViewGroup getItemContainer() {
            return this.itemContainer;
        }

        @NotNull
        public final ViewGroup getItemLayout() {
            return this.itemLayout;
        }

        public final int getPositionItem() {
            return this.positionItem;
        }

        @NotNull
        public final ImageView getSpeakerIcon() {
            return this.speakerIcon;
        }

        @NotNull
        public final TextView getSpeakerName() {
            return this.speakerName;
        }

        @NotNull
        public final TextView getStartOfSpeech() {
            return this.startOfSpeech;
        }

        @NotNull
        public final TextView getTranslatedText() {
            return this.translatedText;
        }

        public final void setCheckBox(@NotNull CheckBox checkBox) {
            Intrinsics.checkNotNullParameter(checkBox, "<set-?>");
            this.checkBox = checkBox;
        }

        public final void setContent(@NotNull TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.content = textView;
        }

        public final void setCustomEditTextListener(@NotNull CustomEditTextListener customEditTextListener) {
            Intrinsics.checkNotNullParameter(customEditTextListener, "<set-?>");
            this.customEditTextListener = customEditTextListener;
        }

        public final void setEditText(@NotNull EditText editText) {
            Intrinsics.checkNotNullParameter(editText, "<set-?>");
            this.editText = editText;
        }

        public final void setItemLayout(@NotNull ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
            this.itemLayout = viewGroup;
        }

        public final void setPositionItem(int i) {
            this.positionItem = i;
        }

        public final void setTranslatedText(@NotNull TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.translatedText = textView;
        }

        public final void decorate() {
        }
    }
}
