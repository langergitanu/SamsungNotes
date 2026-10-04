package com.samsung.android.sdk.pen.setting.handwriting;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.setting.colorpalette.ViewOnClickListenerC7538b;
import com.samsung.android.sdk.pen.setting.pencommon.SpenPenList;
import com.samsung.android.sdk.pen.setting.pencommon.SpenPenViewInterface;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.request.ImportHandler;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0010\u0018\u0000 A2\u00020\u00012\u00020\u0002:\u0001AB\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000bH\u0016J\b\u0010 \u001a\u00020\u000bH\u0016J\u0012\u0010!\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010#\u001a\u00020\u000bH\u0016J\u0010\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u000bH\u0016J\u0010\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\u000bH\u0016J\u0012\u0010(\u001a\u0004\u0018\u00010\u000e2\u0006\u0010%\u001a\u00020\u000bH\u0016J\b\u0010)\u001a\u00020\u001dH\u0014J\b\u0010*\u001a\u00020\u001dH\u0016J\u0016\u0010+\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\u000bJ\u001e\u0010.\u001a\u00020\u001d2\u0006\u0010/\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u000bJ\u0018\u00102\u001a\u00020\u001d2\u0006\u00103\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u000bH\u0004J2\u00105\u001a\u00020\u001d2\b\u00106\u001a\u0004\u0018\u00010\u000e2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u0002082\u0006\u0010:\u001a\u0002082\u0006\u0010%\u001a\u00020\u000bH\u0014J\u001c\u0010;\u001a\u0004\u0018\u00010<2\b\u00106\u001a\u0004\u0018\u00010\u000e2\u0006\u00107\u001a\u000208H\u0004J\u0010\u0010=\u001a\u00020\u000b2\u0006\u00103\u001a\u00020\u000bH\u0002J\u0010\u0010>\u001a\u00020\u001d2\u0006\u0010?\u001a\u00020\u000eH\u0002J\b\u0010@\u001a\u00020\u001dH\u0002J\u0018\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u000b2\u0006\u00109\u001a\u000208H\u0002R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006B"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenListView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenPenList;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mContext", "mSelectedIndex", "", "mChildren", "", "Landroid/view/View;", "mSelectedGuideId", "mUnSelectedGuideId", "mSelectedTranslationValue", "mUnSelectedTranslationValue", "mBetweenPens", "mPenStartMargin", "mPenEndMargin", "mOnItemClickListener", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenPenList$OnItemClickListener;", "mAlignInfo", "", "mPenClickListener", "Landroid/view/View$OnClickListener;", "setPenList", "", ImportHandler.KEY_TOTAL, "childLayoutId", "getPenCount", "setOnItemClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "getSelectPenIndex", "selectPen", "index", "unSelectPen", "penIndex", "getPenView", "onFinishInflate", "close", "setSelectedGuideInfo", "selectedMargin", "unSelectedMargin", "setPenMargin", "startMargin", "endMargin", "betweenPen", "setAlignInfo", "penCount", "alignType", "updateSelected", "child", "selected", "", "needAnimation", "isChangedPen", "getPenAnimator", "Landroid/animation/Animator;", "getAlignInfo", "addChild", "penView", "updateChildList", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public class SpenPenListView extends ConstraintLayout implements SpenPenList {
    private static final int PEN_CHANGE_DURATION = 400;

    @NotNull
    private static final String TAG = "SpenPenListView";

    @Nullable
    private Map<Integer, Integer> mAlignInfo;
    private int mBetweenPens;

    @Nullable
    private List<View> mChildren;

    @NotNull
    private Context mContext;

    @Nullable
    private SpenPenList.OnItemClickListener mOnItemClickListener;

    @NotNull
    private final View.OnClickListener mPenClickListener;
    private int mPenEndMargin;
    private int mPenStartMargin;
    private final int mSelectedGuideId;
    private int mSelectedIndex;
    private int mSelectedTranslationValue;
    private final int mUnSelectedGuideId;
    private int mUnSelectedTranslationValue;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int ALIGN_CENTER = 1;
    private static final int ALIGN_START = 2;
    private static final int ALIGN_SPREAD = 3;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u00020\u00078\u0004X\u0085D¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u00020\u00078\u0004X\u0085D¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\u000bR\u001c\u0010\u000f\u001a\u00020\u00078\u0004X\u0085D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenListView$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "PEN_CHANGE_DURATION", "", "ALIGN_CENTER", "getALIGN_CENTER$annotations", "getALIGN_CENTER", "()I", "ALIGN_START", "getALIGN_START$annotations", "getALIGN_START", "ALIGN_SPREAD", "getALIGN_SPREAD$annotations", "getALIGN_SPREAD", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getALIGN_CENTER() {
            return SpenPenListView.ALIGN_CENTER;
        }

        public final int getALIGN_SPREAD() {
            return SpenPenListView.ALIGN_SPREAD;
        }

        public final int getALIGN_START() {
            return SpenPenListView.ALIGN_START;
        }

        private Companion() {
        }

        @JvmStatic
        public static /* synthetic */ void getALIGN_CENTER$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getALIGN_SPREAD$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getALIGN_START$annotations() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenPenListView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mPenClickListener = new ViewOnClickListenerC7538b(this, 13);
        Log.i(TAG, "2. SpenPenListImpl()");
        this.mContext = context;
        this.mSelectedIndex = -1;
        this.mPenStartMargin = 0;
        this.mPenEndMargin = 0;
        this.mBetweenPens = 0;
        this.mSelectedGuideId = C7932R.id.pens_view_selected_guideline;
        this.mUnSelectedGuideId = C7932R.id.pens_view_unselected_guideline;
    }

    private final void addChild(View penView) {
        if (this.mChildren == null) {
            this.mChildren = new ArrayList();
        }
        List<View> list = this.mChildren;
        if (list != null) {
            list.add(penView);
        }
    }

    public static final int getALIGN_CENTER() {
        return INSTANCE.getALIGN_CENTER();
    }

    public static final int getALIGN_SPREAD() {
        return INSTANCE.getALIGN_SPREAD();
    }

    public static final int getALIGN_START() {
        return INSTANCE.getALIGN_START();
    }

    private final int getAlignInfo(int penCount) {
        int i = ALIGN_START;
        Map<Integer, Integer> map = this.mAlignInfo;
        if (map != null) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int iIntValue = entry.getKey().intValue();
                int iIntValue2 = entry.getValue().intValue();
                if (penCount <= iIntValue) {
                    return iIntValue2;
                }
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mPenClickListener$lambda$1(SpenPenListView spenPenListView, View view) {
        SpenPenList.OnItemClickListener onItemClickListener;
        List<View> list = spenPenListView.mChildren;
        if (list == null || (onItemClickListener = spenPenListView.mOnItemClickListener) == null) {
            return;
        }
        Intrinsics.checkNotNull(view);
        onItemClickListener.onItemClick(view, list.indexOf(view));
    }

    private final void updateChildList() {
        List<View> list = this.mChildren;
        Log.i(TAG, "[BEFORE] updateChildList() mChild=" + (list != null ? Integer.valueOf(list.size()) : ""));
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (!(childAt instanceof SpenPenViewInterface)) {
                Intrinsics.checkNotNull(childAt);
                addChild(childAt);
            }
        }
        List<View> list2 = this.mChildren;
        Log.i(TAG, "[AFTER] updateChildList() mChild=" + (list2 != null ? Integer.valueOf(list2.size()) : ""));
    }

    public void close() {
        this.mOnItemClickListener = null;
        List<View> list = this.mChildren;
        if (list != null) {
            list.clear();
        }
        this.mChildren = null;
        this.mSelectedIndex = -1;
        this.mAlignInfo = null;
    }

    @Nullable
    public final Animator getPenAnimator(@Nullable View child, boolean selected) {
        if (child == null) {
            Log.i(TAG, "updateSelected child is null");
            return null;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(child, "translationY", (this.mUnSelectedTranslationValue - this.mSelectedTranslationValue) * (selected ? -1 : 0));
        objectAnimatorOfFloat.setDuration(400L);
        objectAnimatorOfFloat.setInterpolator(SpenSettingUtilAnimation.getInterpolator(11));
        return objectAnimatorOfFloat;
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPenList
    public int getPenCount() {
        List<View> list = this.mChildren;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPenList
    @Nullable
    public View getPenView(int index) {
        List<View> list = this.mChildren;
        if (list == null || list.size() <= index) {
            return null;
        }
        return list.get(index);
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPenList
    /* JADX INFO: renamed from: getSelectPenIndex, reason: from getter */
    public int getMSelectedIndex() {
        return this.mSelectedIndex;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        AbstractC2322a.m1631u(getChildCount(), "3. onFinishInflate() childCont=", TAG);
        if (this.mChildren != null || getChildCount() <= 0) {
            return;
        }
        updateChildList();
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPenList
    public void selectPen(int index) {
        List<View> list = this.mChildren;
        if (list == null || list.size() <= index) {
            return;
        }
        selectPen(index, true);
    }

    public final void setAlignInfo(int penCount, int alignType) {
        if (this.mAlignInfo == null) {
            this.mAlignInfo = new TreeMap();
        }
        Map<Integer, Integer> map = this.mAlignInfo;
        if (map != null) {
            map.put(Integer.valueOf(penCount), Integer.valueOf(alignType));
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPenList
    public void setOnItemClickListener(@Nullable SpenPenList.OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
        List<View> list = this.mChildren;
        if (list != null) {
            Iterator<View> it = list.iterator();
            while (it.hasNext()) {
                it.next().setOnClickListener(listener != null ? this.mPenClickListener : null);
            }
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPenList
    public void setPenList(int total, int childLayoutId) {
        int i;
        Object systemService = this.mContext.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        LayoutInflater layoutInflater = (LayoutInflater) systemService;
        int[] iArr = new int[total];
        for (int i2 = 0; i2 < total; i2++) {
            int iGenerateViewId = View.generateViewId();
            View viewInflate = layoutInflater.inflate(childLayoutId, (ViewGroup) this, false);
            viewInflate.setId(iGenerateViewId);
            iArr[i2] = iGenerateViewId;
            addView(viewInflate);
            Intrinsics.checkNotNull(viewInflate);
            addChild(viewInflate);
        }
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this);
        constraintSet.create(this.mUnSelectedGuideId, 0);
        constraintSet.create(this.mSelectedGuideId, 0);
        constraintSet.setGuidelineBegin(this.mUnSelectedGuideId, this.mUnSelectedTranslationValue);
        constraintSet.setGuidelineBegin(this.mSelectedGuideId, this.mSelectedTranslationValue);
        constraintSet.create(C7932R.id.pens_view_list_start_guideline, 1);
        constraintSet.setGuidelineBegin(C7932R.id.pens_view_list_start_guideline, this.mPenStartMargin);
        constraintSet.create(C7932R.id.pens_view_list_end_guideline, 1);
        constraintSet.setGuidelineEnd(C7932R.id.pens_view_list_end_guideline, this.mPenEndMargin);
        int alignInfo = getAlignInfo(total);
        if (alignInfo == ALIGN_START) {
            for (int i4 = 0; i4 < total; i4++) {
                if (i4 != 0) {
                    constraintSet.connect(iArr[i4], 6, iArr[i4 - 1], 7, 0);
                } else {
                    constraintSet.connect(iArr[i4], 6, 0, 6, 0);
                }
                if (i4 != total - 1) {
                    constraintSet.connect(iArr[i4], 7, iArr[i4 + 1], 6, 0);
                }
            }
            i = 1;
        } else if (total > 1) {
            i = 1;
            constraintSet.createHorizontalChainRtl(C7932R.id.pens_view_list_start_guideline, 6, C7932R.id.pens_view_list_end_guideline, 7, iArr, null, alignInfo == ALIGN_SPREAD ? 1 : 2);
        } else {
            i = 1;
            constraintSet.connect(iArr[0], 6, 0, 6, 0);
            constraintSet.connect(iArr[0], 7, 0, 7, 0);
        }
        for (int i5 = 0; i5 < total; i5++) {
            constraintSet.connect(iArr[i5], 3, this.mUnSelectedGuideId, 3);
        }
        constraintSet.applyTo(this);
        if (alignInfo == ALIGN_CENTER) {
            for (int i6 = i; i6 < total; i6++) {
                View viewFindViewById = findViewById(iArr[i6]);
                ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                layoutParams2.setMarginStart(this.mBetweenPens);
                viewFindViewById.setLayoutParams(layoutParams2);
            }
        }
    }

    public final void setPenMargin(int startMargin, int endMargin, int betweenPen) {
        this.mPenStartMargin = startMargin;
        this.mPenEndMargin = endMargin;
        this.mBetweenPens = betweenPen;
    }

    public final void setSelectedGuideInfo(int selectedMargin, int unSelectedMargin) {
        this.mSelectedTranslationValue = selectedMargin;
        this.mUnSelectedTranslationValue = unSelectedMargin;
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPenList
    public void unSelectPen(int penIndex) {
        int i;
        View penView;
        List<View> list = this.mChildren;
        if (list == null || (i = this.mSelectedIndex) <= -1 || i != penIndex || list.size() <= penIndex || (penView = getPenView(this.mSelectedIndex)) == null) {
            return;
        }
        updateSelected(penView, false, true, true, penIndex);
        penView.setSelected(false);
        this.mSelectedIndex = -1;
    }

    public void updateSelected(@Nullable View child, boolean selected, boolean needAnimation, boolean isChangedPen, int index) {
        if (child == null) {
            Log.i(TAG, "updateSelected child is null");
            return;
        }
        if (needAnimation) {
            Animator penAnimator = getPenAnimator(child, selected);
            if (penAnimator != null) {
                penAnimator.start();
                return;
            }
            return;
        }
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this);
        if (selected) {
            constraintSet.connect(child.getId(), 3, this.mSelectedGuideId, 3);
        } else {
            constraintSet.connect(child.getId(), 3, this.mUnSelectedGuideId, 3);
        }
        constraintSet.applyTo(this);
    }

    private final void selectPen(int index, boolean needAnimation) {
        SpenPenListView spenPenListView;
        boolean z;
        SpenPenView spenPenView;
        AbstractC0000a.m27x(AbstractC0622a.m1173s(index, this.mSelectedIndex, "selectPen() index=", " mSelectedIndex=", " needAnimation="), needAnimation, TAG);
        int i = this.mSelectedIndex;
        boolean z2 = i != index;
        if (z2) {
            if (i == -1 || (spenPenView = (SpenPenView) getPenView(i)) == null) {
                spenPenListView = this;
                z = needAnimation;
            } else {
                spenPenListView = this;
                z = needAnimation;
                spenPenListView.updateSelected(spenPenView, false, z, z2, this.mSelectedIndex);
                spenPenView.setSelected(false, z);
            }
            SpenPenView spenPenView2 = (SpenPenView) getPenView(index);
            if (spenPenView2 != null) {
                spenPenListView.mSelectedIndex = index;
                spenPenView2.setSelected(true, z);
                spenPenListView.updateSelected(spenPenView2, true, z, z2, index);
            }
        }
    }
}
