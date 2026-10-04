package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.menu;

import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import opennlp.tools.parser.AbstractBottomUpParser;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ViewAnchorUtil {
    private static final int PIXEL_THRESHOLD = 15;
    public static final float PRIORITY_SCORE_THRESHOLD = 0.2f;
    private static final String TAG = Logger.createTag("ViewAnchorUtil");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class Area {
        public static Area BOTTOM;
        public static Area LEFT;
        public static Area RIGHT;
        public static Area TOP;
        int anchorMargin;
        Rect anchorRect;
        Rect borderRect;
        Rect childRect;
        private int emptySpace;
        private int inside;
        private boolean isDisplayable;
        final boolean isHorizon;
        private int outside;
        Rect parentRect;
        private float score;

        static {
            boolean z = true;
            LEFT = new Area(z) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.common.menu.ViewAnchorUtil.Area.1
                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.common.menu.ViewAnchorUtil.Area
                public Rect getAnchorCenterPosition() {
                    return adjustOutBorder((this.parentRect.left - this.anchorMargin) - this.anchorRect.width(), getVerticalCenter());
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.common.menu.ViewAnchorUtil.Area
                public Rect getAnchorPosition() {
                    return adjustOutBorder((this.parentRect.left - this.anchorMargin) - this.anchorRect.width(), this.childRect.centerY() - (this.anchorRect.height() / 2));
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.common.menu.ViewAnchorUtil.Area
                public PointF getPivot() {
                    return new PointF(this.anchorRect.width(), this.anchorRect.height() >> 1);
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.common.menu.ViewAnchorUtil.Area
                public String name() {
                    return "LEFT";
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.common.menu.ViewAnchorUtil.Area
                public void setRect(Rect rect, Rect rect2, Rect rect3, Rect rect4, int i) {
                    super.setRect(rect, rect2, rect3, rect4, i);
                    setInside(rect.centerX() - rect2.left);
                    setOutside(rect2.left);
                    setEmptySpace(rect2.left - rect4.width());
                }
            };
            RIGHT = new Area(z) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.common.menu.ViewAnchorUtil.Area.2
                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.common.menu.ViewAnchorUtil.Area
                public Rect getAnchorCenterPosition() {
                    return adjustOutBorder(this.parentRect.right + this.anchorMargin, getVerticalCenter());
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.common.menu.ViewAnchorUtil.Area
                public Rect getAnchorPosition() {
                    return adjustOutBorder(this.parentRect.right + this.anchorMargin, this.childRect.centerY() - (this.anchorRect.height() / 2));
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.common.menu.ViewAnchorUtil.Area
                public PointF getPivot() {
                    return new PointF(0.0f, this.anchorRect.height() >> 1);
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.common.menu.ViewAnchorUtil.Area
                public String name() {
                    return "RIGHT";
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.common.menu.ViewAnchorUtil.Area
                public void setRect(Rect rect, Rect rect2, Rect rect3, Rect rect4, int i) {
                    super.setRect(rect, rect2, rect3, rect4, i);
                    setInside(rect2.right - rect.centerX());
                    setOutside(rect3.right - rect2.right);
                    setEmptySpace((rect3.right - rect2.right) - rect4.width());
                }
            };
            boolean z2 = false;
            TOP = new Area(z2) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.common.menu.ViewAnchorUtil.Area.3
                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.common.menu.ViewAnchorUtil.Area
                public Rect getAnchorCenterPosition() {
                    return adjustOutBorder(getHorizontalCenter(), (this.parentRect.top - this.anchorMargin) - this.anchorRect.height());
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.common.menu.ViewAnchorUtil.Area
                public Rect getAnchorPosition() {
                    return adjustOutBorder(this.childRect.centerX() - (this.anchorRect.width() / 2), (this.parentRect.top - this.anchorMargin) - this.anchorRect.height());
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.common.menu.ViewAnchorUtil.Area
                public PointF getPivot() {
                    return new PointF(this.anchorRect.width() >> 1, this.anchorRect.height());
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.common.menu.ViewAnchorUtil.Area
                public String name() {
                    return AbstractBottomUpParser.TOP_NODE;
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.common.menu.ViewAnchorUtil.Area
                public void setRect(Rect rect, Rect rect2, Rect rect3, Rect rect4, int i) {
                    super.setRect(rect, rect2, rect3, rect4, i);
                    setInside(rect.centerY() - rect2.top);
                    setOutside(rect2.top);
                    setEmptySpace(rect2.top - rect4.height());
                }
            };
            BOTTOM = new Area(z2) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.common.menu.ViewAnchorUtil.Area.4
                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.common.menu.ViewAnchorUtil.Area
                public Rect getAnchorCenterPosition() {
                    return adjustOutBorder(getHorizontalCenter(), this.parentRect.bottom + this.anchorMargin);
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.common.menu.ViewAnchorUtil.Area
                public Rect getAnchorPosition() {
                    return adjustOutBorder(this.childRect.centerX() - (this.anchorRect.width() / 2), this.parentRect.bottom + this.anchorMargin);
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.common.menu.ViewAnchorUtil.Area
                public PointF getPivot() {
                    return new PointF(this.anchorRect.width() >> 1, 0.0f);
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.common.menu.ViewAnchorUtil.Area
                public String name() {
                    return "BOTTOM";
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.common.menu.ViewAnchorUtil.Area
                public void setRect(Rect rect, Rect rect2, Rect rect3, Rect rect4, int i) {
                    super.setRect(rect, rect2, rect3, rect4, i);
                    setInside(rect2.bottom - rect.centerY());
                    setOutside(rect3.bottom - rect2.bottom);
                    setEmptySpace((rect3.bottom - rect2.bottom) - rect4.height());
                }
            };
        }

        public Area(boolean z) {
            this.isHorizon = z;
        }

        public static void calculateScore() {
            int insideMin = getInsideMin();
            int insideMax = getInsideMax();
            int emptySpaceMax = getEmptySpaceMax();
            for (Area area : values()) {
                area.score = 0.0f;
                boolean z = area.outside > (area.isHorizon ? area.anchorRect.width() : area.anchorRect.height()) + area.anchorMargin;
                area.isDisplayable = z;
                if (z) {
                    area.score += 0.3f;
                }
                int i = area.inside;
                if (i < insideMin + 15) {
                    area.score += 0.2f;
                } else if (i < insideMax) {
                    area.score += 0.1f;
                }
                if (area.emptySpace == emptySpaceMax) {
                    area.score += 0.1f;
                }
                Logger.m10999d(ViewAnchorUtil.TAG, "area " + area.name() + " score : " + area.score);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x0049  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static Area getCandidateArea(boolean z) {
            Area area = LEFT;
            for (Area area2 : values()) {
                if (!area.equals(area2)) {
                    float f = area.score;
                    float f4 = area2.score;
                    if (f >= f4) {
                        if (f == f4) {
                            if (z) {
                                int insideMin = getInsideMin() + 15;
                                int i = area.inside;
                                if (i >= insideMin || area2.inside >= insideMin) {
                                    if (i > area2.inside) {
                                        area = area2;
                                    }
                                } else if (area.outside < area2.outside) {
                                }
                            } else if (area.outside >= area2.outside && area.inside <= area2.inside) {
                            }
                        }
                    }
                }
            }
            Logger.m11003i(ViewAnchorUtil.TAG, "candidate area " + area.name() + " priority inside " + z);
            return area;
        }

        private static int getEmptySpaceMax() {
            return Math.max(Math.max(LEFT.emptySpace, RIGHT.emptySpace), Math.max(TOP.emptySpace, BOTTOM.emptySpace));
        }

        private static int getInsideMax() {
            return Math.max(Math.max(LEFT.inside, RIGHT.inside), Math.max(TOP.inside, BOTTOM.inside));
        }

        private static int getInsideMin() {
            return Math.min(Math.min(LEFT.inside, RIGHT.inside), Math.min(TOP.inside, BOTTOM.inside));
        }

        public static void setRectInfo(Rect rect, Rect rect2, Rect rect3, Rect rect4, int i) {
            for (Area area : values()) {
                area.setRect(rect, rect2, rect3, rect4, i);
            }
        }

        public static Area[] values() {
            return new Area[]{LEFT, RIGHT, TOP, BOTTOM};
        }

        public Rect adjustOutBorder(int i, int i2) {
            this.anchorRect.offsetTo(i, i2);
            Rect rect = this.anchorRect;
            int i4 = rect.right;
            int i5 = this.borderRect.right;
            if (i4 > i5) {
                rect.left = i5 - rect.width();
            }
            Rect rect2 = this.anchorRect;
            int i6 = rect2.bottom;
            int i7 = this.borderRect.bottom;
            if (i6 > i7) {
                rect2.top = i7 - rect2.height();
            }
            Rect rect3 = this.anchorRect;
            if (rect3.left < 0) {
                rect3.left = 0;
            }
            if (rect3.top < 0) {
                rect3.top = 0;
            }
            return rect3;
        }

        public abstract Rect getAnchorCenterPosition();

        public abstract Rect getAnchorPosition();

        public int getHorizontalCenter() {
            return (this.borderRect.width() / 2) - (this.anchorRect.width() / 2);
        }

        public abstract PointF getPivot();

        public int getVerticalCenter() {
            return (this.borderRect.height() / 2) - (this.anchorRect.height() / 2);
        }

        public abstract String name();

        public void setEmptySpace(int i) {
            this.emptySpace = i;
        }

        public void setInside(int i) {
            this.inside = Math.max(0, i);
        }

        public void setOutside(int i) {
            this.outside = Math.max(0, i);
        }

        public void setRect(Rect rect, Rect rect2, Rect rect3, Rect rect4, int i) {
            this.childRect = rect;
            this.parentRect = rect2;
            this.borderRect = rect3;
            this.anchorRect = rect4;
            this.anchorMargin = i;
        }
    }

    public static boolean getRelativeCoordinateFromSpecificView(View view, View view2, Rect rect) {
        view2.getHitRect(rect);
        View viewUpdateRelativeCoordinate = (View) view2.getParent();
        while (viewUpdateRelativeCoordinate != null && (viewUpdateRelativeCoordinate instanceof ViewGroup)) {
            if (viewUpdateRelativeCoordinate.equals(view)) {
                return true;
            }
            viewUpdateRelativeCoordinate = updateRelativeCoordinate(rect, viewUpdateRelativeCoordinate);
        }
        return false;
    }

    public static Area recommendDirection(View view) {
        return updateCandidateShortestDirection(view, view, view, 0, true);
    }

    private static Area updateCandidateShortestDirection(Rect rect, View view, View view2, int i, boolean z) {
        Rect rect2 = new Rect((int) view.getX(), (int) view.getY(), view.getWidth(), view.getHeight());
        Rect rect3 = new Rect();
        view2.getHitRect(rect3);
        Area.setRectInfo(rect, rect, rect2, rect3, i);
        Area.calculateScore();
        return Area.getCandidateArea(z);
    }

    private static void updatePivot(View view, Area area) {
        PointF pivot = area.getPivot();
        view.setPivotX(pivot.x);
        view.setPivotY(pivot.y);
    }

    public static void updatePosition(Rect rect, View view, View view2, int i) {
        Area areaUpdateCandidateShortestDirection = updateCandidateShortestDirection(rect, view, view2, i, true);
        Rect anchorPosition = areaUpdateCandidateShortestDirection.getAnchorPosition();
        view2.setX(anchorPosition.left);
        view2.setY(anchorPosition.top);
        updatePivot(view2, areaUpdateCandidateShortestDirection);
    }

    public static void updatePositionToCenter(Rect rect, View view, View view2, int i) {
        Area areaUpdateCandidateShortestDirection = updateCandidateShortestDirection(rect, view, view2, i, false);
        Rect anchorCenterPosition = areaUpdateCandidateShortestDirection.getAnchorCenterPosition();
        view2.setX(anchorCenterPosition.left);
        view2.setY(anchorCenterPosition.top);
        updatePivot(view2, areaUpdateCandidateShortestDirection);
    }

    public static void updatePositionToVertical(Rect rect, View view, View view2, int i, Area area) {
        updatePositionToVertical(rect, new Rect((int) view.getX(), (int) view.getY(), view.getWidth(), view.getHeight()), view2, i, area);
    }

    private static View updateRelativeCoordinate(Rect rect, View view) {
        int scrollX;
        int scrollY;
        if ((view instanceof HorizontalScrollView) || (view instanceof ScrollView)) {
            scrollX = view.getScrollX();
            scrollY = view.getScrollY();
        } else {
            scrollX = 0;
            scrollY = 0;
        }
        rect.offset(((int) view.getX()) - scrollX, ((int) view.getY()) - scrollY);
        return (View) view.getParent();
    }

    public static void updatePositionToVertical(Rect rect, Rect rect2, View view, int i, Area area) {
        Rect rect3 = new Rect();
        view.getHitRect(rect3);
        Area.setRectInfo(rect, rect, rect2, rect3, i);
        Area.calculateScore();
        if (area == null) {
            area = Area.BOTTOM;
        }
        if (!area.isDisplayable) {
            if (!Area.TOP.isDisplayable) {
                if (Area.BOTTOM.isDisplayable) {
                    area = Area.BOTTOM;
                } else if (area.score < Area.TOP.score && Area.TOP.score - area.score > 0.2f) {
                    area = Area.TOP;
                } else if (area.score < Area.BOTTOM.score && Area.BOTTOM.score - area.score > 0.2f) {
                    area = Area.BOTTOM;
                }
            } else {
                area = Area.TOP;
            }
        }
        Logger.m11003i(TAG, "updatePositionToVertical candidate : " + area.name() + " top : " + Area.TOP.score + " bottom : " + Area.BOTTOM.score);
        Rect anchorPosition = area.getAnchorPosition();
        view.setX((float) anchorPosition.left);
        view.setY((float) anchorPosition.top);
        updatePivot(view, area);
    }

    public static void updatePosition(View view, View view2, View view3, int i) {
        Area areaUpdateCandidateShortestDirection = updateCandidateShortestDirection(view, view2, view3, i, true);
        Rect anchorPosition = areaUpdateCandidateShortestDirection.getAnchorPosition();
        view3.setX(anchorPosition.left);
        view3.setY(anchorPosition.top);
        updatePivot(view3, areaUpdateCandidateShortestDirection);
    }

    public static void updatePositionToCenter(View view, View view2, View view3, int i) {
        Area areaUpdateCandidateShortestDirection = updateCandidateShortestDirection(view, view2, view3, i, false);
        Rect anchorCenterPosition = areaUpdateCandidateShortestDirection.getAnchorCenterPosition();
        view3.setX(anchorCenterPosition.left);
        view3.setY(anchorCenterPosition.top);
        updatePivot(view3, areaUpdateCandidateShortestDirection);
    }

    private static Area updateCandidateShortestDirection(View view, View view2, View view3, int i, boolean z) {
        if (view2 != null && view2.getParent() != null) {
            View view4 = (View) view2.getParent();
            Rect rect = new Rect((int) view4.getX(), (int) view4.getY(), view4.getWidth(), view4.getHeight());
            Rect rect2 = new Rect();
            getRelativeCoordinateFromSpecificView((View) view2.getParent(), view2, rect2);
            Rect rect3 = new Rect();
            getRelativeCoordinateFromSpecificView((View) view2.getParent(), view, rect3);
            Rect rect4 = new Rect();
            view3.getHitRect(rect4);
            Area.setRectInfo(rect3, rect2, rect, rect4, i);
            Area.calculateScore();
            return Area.getCandidateArea(z);
        }
        Logger.m11000e(TAG, "updateCandidateShortestDirection# candidate : parent view is null");
        return Area.LEFT;
    }
}
