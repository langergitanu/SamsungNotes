package com.samsung.android.app.notes.widget.glance.single.setting.view;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import com.samsung.android.app.notes.widget.setting.view.adapter.NoteListAdapter;
import com.samsung.android.sdk.pen.objectruntime.preload.Video;
import com.samsung.android.sdk.pen.objectruntime.preload.WrapperVideoView;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.NoteStyleActivity;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.TitleEditor;
import kotlin.jvm.internal.Ref;

/* JADX INFO: renamed from: com.samsung.android.app.notes.widget.glance.single.setting.view.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class ViewOnTouchListenerC7004e implements View.OnTouchListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4715a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f4716b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f4717c;

    public /* synthetic */ ViewOnTouchListenerC7004e(Object obj, Object obj2, int i) {
        this.f4715a = i;
        this.f4716b = obj;
        this.f4717c = obj2;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.f4715a) {
            case 0:
                return WidgetSingleGlanceSettingView.initChange$lambda$4((Button) this.f4716b, (WidgetSingleGlanceSettingView) this.f4717c, view, motionEvent);
            case 1:
                return NoteListAdapter.decorateReorder$lambda$0((NoteListAdapter) this.f4716b, (NoteListAdapter.NoteListHolder) this.f4717c, view, motionEvent);
            case 2:
                return Video.startVideoPlay$lambda$8$lambda$7((WrapperVideoView) this.f4716b, (Video) this.f4717c, view, motionEvent);
            case 3:
                return NoteStyleActivity.initContainerLayout$lambda$3((Ref.LongRef) this.f4716b, (NoteStyleActivity) this.f4717c, view, motionEvent);
            default:
                return ((TitleEditor) this.f4716b).lambda$init$3((GestureDetector) this.f4717c, view, motionEvent);
        }
    }
}
