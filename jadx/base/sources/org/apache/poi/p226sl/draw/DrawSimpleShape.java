package org.apache.poi.p226sl.draw;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.java.awt.BasicStroke;
import org.apache.poi.java.awt.Graphics2D;
import org.apache.poi.java.awt.Paint;
import org.apache.poi.java.awt.Shape;
import org.apache.poi.java.awt.geom.AffineTransform;
import org.apache.poi.java.awt.geom.Ellipse2D;
import org.apache.poi.java.awt.geom.Path2D;
import org.apache.poi.java.awt.geom.Rectangle2D;
import org.apache.poi.javax.xml.bind.JAXBContext;
import org.apache.poi.javax.xml.bind.Unmarshaller;
import org.apache.poi.javax.xml.stream.EventFilter;
import org.apache.poi.javax.xml.stream.XMLEventReader;
import org.apache.poi.javax.xml.stream.XMLInputFactory;
import org.apache.poi.javax.xml.stream.events.StartElement;
import org.apache.poi.javax.xml.stream.events.XMLEvent;
import org.apache.poi.p226sl.usermodel.Shadow;
import org.apache.poi.p226sl.usermodel.SimpleShape;
import org.apache.poi.sl.draw.binding.CTCustomGeometry2D;
import org.apache.poi.sl.draw.geom.Context;
import org.apache.poi.sl.draw.geom.CustomGeometry;
import org.apache.poi.sl.draw.geom.Outline;
import org.apache.poi.sl.draw.geom.Path;
import org.apache.poi.sl.usermodel.LineDecoration;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.StaxHelper;
import org.apache.poi.util.Units;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DrawSimpleShape extends DrawShape {
    private static final double DECO_SIZE_POW = 1.5d;

    /* JADX INFO: renamed from: org.apache.poi.sl.draw.DrawSimpleShape$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C140702 {

        /* JADX INFO: renamed from: $SwitchMap$org$apache$poi$sl$usermodel$LineDecoration$DecorationShape */
        static final /* synthetic */ int[] f10162xdbdf26f2;

        static {
            int[] iArr = new int[LineDecoration.DecorationShape.values().length];
            f10162xdbdf26f2 = iArr;
            try {
                iArr[LineDecoration.DecorationShape.OVAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10162xdbdf26f2[LineDecoration.DecorationShape.STEALTH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10162xdbdf26f2[LineDecoration.DecorationShape.ARROW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10162xdbdf26f2[LineDecoration.DecorationShape.TRIANGLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public DrawSimpleShape(SimpleShape<?, ?> simpleShape) {
        super(simpleShape);
    }

    public static CustomGeometry getCustomGeometry(String str) {
        return getCustomGeometry(str, null);
    }

    public Collection<Outline> computeOutlines(Graphics2D graphics2D) {
        double width;
        SimpleShape<?, ?> shape = getShape();
        ArrayList arrayList = new ArrayList();
        CustomGeometry<Path> geometry = shape.getGeometry();
        if (geometry != null) {
            Rectangle2D anchor = DrawShape.getAnchor(graphics2D, shape);
            for (Path path : geometry) {
                double w = path.getW();
                double h = path.getH();
                double points = Units.toPoints(1L);
                if (w == -1.0d) {
                    w = Units.toEMU(anchor.getWidth());
                    width = points;
                } else {
                    width = anchor.getWidth() / w;
                }
                double d = w;
                if (h == -1.0d) {
                    h = Units.toEMU(anchor.getHeight());
                } else {
                    points = anchor.getHeight() / h;
                }
                Path2D.Double path2 = path.getPath(new Context(geometry, new Rectangle2D.Double(0.0d, 0.0d, d, h), shape));
                AffineTransform affineTransform = new AffineTransform();
                affineTransform.translate(anchor.getX(), anchor.getY());
                affineTransform.scale(width, points);
                arrayList.add(new Outline(affineTransform.createTransformedShape(path2), path));
            }
        }
        return arrayList;
    }

    @Override // org.apache.poi.p226sl.draw.DrawShape, org.apache.poi.p226sl.draw.Drawable
    public void draw(Graphics2D graphics2D) {
        Paint paint;
        DrawPaint paint2 = DrawFactory.getInstance(graphics2D).getPaint(getShape());
        Paint paint3 = paint2.getPaint(graphics2D, getShape().getFillStyle().getPaint());
        Paint paint4 = paint2.getPaint(graphics2D, getShape().getStrokeStyle().getPaint());
        BasicStroke stroke = getStroke();
        graphics2D.setStroke(stroke);
        Collection<Outline> collectionComputeOutlines = computeOutlines(graphics2D);
        drawShadow(graphics2D, collectionComputeOutlines, paint3, paint4);
        if (paint3 != null) {
            for (Outline outline : collectionComputeOutlines) {
                if (outline.getPath().isFilled() && (paint = paint2.getPaint(graphics2D, getShape().getFillStyle().getPaint(), outline.getPath().getFill())) != null) {
                    graphics2D.setPaint(paint);
                    Shape outline2 = outline.getOutline();
                    graphics2D.setRenderingHint(Drawable.GRADIENT_SHAPE, outline2);
                    graphics2D.fill(outline2);
                }
            }
        }
        drawContent(graphics2D);
        if (paint4 != null) {
            graphics2D.setPaint(paint4);
            graphics2D.setStroke(stroke);
            for (Outline outline3 : collectionComputeOutlines) {
                if (outline3.getPath().isStroked()) {
                    Shape outline4 = outline3.getOutline();
                    graphics2D.setRenderingHint(Drawable.GRADIENT_SHAPE, outline4);
                    graphics2D.draw(outline4);
                }
            }
        }
        drawDecoration(graphics2D, paint4, stroke);
    }

    public void drawDecoration(Graphics2D graphics2D, Paint paint, BasicStroke basicStroke) {
        if (paint == null) {
            return;
        }
        graphics2D.setPaint(paint);
        ArrayList<Outline> arrayList = new ArrayList();
        LineDecoration lineDecoration = getShape().getLineDecoration();
        Outline headDecoration = getHeadDecoration(graphics2D, lineDecoration, basicStroke);
        if (headDecoration != null) {
            arrayList.add(headDecoration);
        }
        Outline tailDecoration = getTailDecoration(graphics2D, lineDecoration, basicStroke);
        if (tailDecoration != null) {
            arrayList.add(tailDecoration);
        }
        for (Outline outline : arrayList) {
            Shape outline2 = outline.getOutline();
            Path path = outline.getPath();
            graphics2D.setRenderingHint(Drawable.GRADIENT_SHAPE, outline2);
            if (path.isFilled()) {
                graphics2D.fill(outline2);
            }
            if (path.isStroked()) {
                graphics2D.draw(outline2);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [org.apache.poi.java.awt.Color, org.apache.poi.java.awt.Paint] */
    public void drawShadow(Graphics2D graphics2D, Collection<Outline> collection, Paint paint, Paint paint2) {
        Shadow<S, P> shadow = getShape().getShadow();
        if (shadow != 0) {
            if (paint == null && paint2 == null) {
                return;
            }
            ?? ApplyColorTransform = DrawPaint.applyColorTransform(shadow.getFillStyle().getSolidColor());
            double rotation = getShape().getRotation();
            if (getShape().getFlipVertical()) {
                rotation += 180.0d;
            }
            double angle = shadow.getAngle() - rotation;
            double distance = shadow.getDistance();
            double dCos = Math.cos(Math.toRadians(angle)) * distance;
            double dSin = Math.sin(Math.toRadians(angle)) * distance;
            graphics2D.translate(dCos, dSin);
            for (Outline outline : collection) {
                Shape outline2 = outline.getOutline();
                Path path = outline.getPath();
                graphics2D.setRenderingHint(Drawable.GRADIENT_SHAPE, outline2);
                graphics2D.setPaint(ApplyColorTransform);
                if (paint != null && path.isFilled()) {
                    graphics2D.fill(outline2);
                } else if (paint2 != null && path.isStroked()) {
                    graphics2D.draw(outline2);
                }
            }
            graphics2D.translate(-dCos, -dSin);
        }
    }

    public Outline getHeadDecoration(Graphics2D graphics2D, LineDecoration lineDecoration, BasicStroke basicStroke) {
        Path path;
        Shape shapeCreateTransformedShape;
        if (lineDecoration == null || basicStroke == null) {
            return null;
        }
        LineDecoration.DecorationSize headLength = lineDecoration.getHeadLength();
        if (headLength == null) {
            headLength = LineDecoration.DecorationSize.MEDIUM;
        }
        LineDecoration.DecorationSize headWidth = lineDecoration.getHeadWidth();
        if (headWidth == null) {
            headWidth = LineDecoration.DecorationSize.MEDIUM;
        }
        double dMax = Math.max(2.5d, basicStroke.getLineWidth());
        Rectangle2D anchor = DrawShape.getAnchor(graphics2D, getShape());
        double x = anchor.getX();
        double y2 = anchor.getY();
        double dAtan = Math.atan(anchor.getHeight() / anchor.getWidth());
        AffineTransform affineTransform = new AffineTransform();
        double dPow = Math.pow(1.5d, ((double) headWidth.ordinal()) + 1.0d);
        double dPow2 = Math.pow(1.5d, ((double) headLength.ordinal()) + 1.0d);
        LineDecoration.DecorationShape headShape = lineDecoration.getHeadShape();
        if (headShape == null) {
            return null;
        }
        int i = C140702.f10162xdbdf26f2[headShape.ordinal()];
        if (i == 1) {
            path = new Path();
            Ellipse2D.Double r19 = new Ellipse2D.Double(0.0d, 0.0d, dMax * dPow2, dMax * dPow);
            Rectangle2D bounds2D = r19.getBounds2D();
            affineTransform.translate(x - (bounds2D.getWidth() / 2.0d), y2 - (bounds2D.getHeight() / 2.0d));
            affineTransform.rotate(dAtan, (bounds2D.getWidth() / 2.0d) + bounds2D.getX(), (bounds2D.getHeight() / 2.0d) + bounds2D.getY());
            shapeCreateTransformedShape = r19;
        } else if (i == 2 || i == 3) {
            path = new Path(false, true);
            Path2D.Double r32 = new Path2D.Double();
            double d = dPow2 * dMax;
            r32.moveTo(d, ((-dMax) * dPow) / 2.0d);
            r32.lineTo(0.0d, 0.0d);
            r32.lineTo(d, (dMax * dPow) / 2.0d);
            affineTransform.translate(x, y2);
            affineTransform.rotate(dAtan);
            shapeCreateTransformedShape = r32;
        } else if (i != 4) {
            path = null;
            shapeCreateTransformedShape = null;
        } else {
            path = new Path();
            Path2D.Double r33 = new Path2D.Double();
            double d2 = dPow2 * dMax;
            r33.moveTo(d2, ((-dMax) * dPow) / 2.0d);
            r33.lineTo(0.0d, 0.0d);
            r33.lineTo(d2, (dMax * dPow) / 2.0d);
            r33.closePath();
            affineTransform.translate(x, y2);
            affineTransform.rotate(dAtan);
            shapeCreateTransformedShape = r33;
        }
        if (shapeCreateTransformedShape != null) {
            shapeCreateTransformedShape = affineTransform.createTransformedShape(shapeCreateTransformedShape);
        }
        if (shapeCreateTransformedShape == null) {
            return null;
        }
        return new Outline(shapeCreateTransformedShape, path);
    }

    public BasicStroke getStroke() {
        return DrawShape.getStroke(getShape().getStrokeStyle());
    }

    public Outline getTailDecoration(Graphics2D graphics2D, LineDecoration lineDecoration, BasicStroke basicStroke) {
        Path path;
        Shape shapeCreateTransformedShape;
        if (lineDecoration == null || basicStroke == null) {
            return null;
        }
        LineDecoration.DecorationSize tailLength = lineDecoration.getTailLength();
        if (tailLength == null) {
            tailLength = LineDecoration.DecorationSize.MEDIUM;
        }
        LineDecoration.DecorationSize tailWidth = lineDecoration.getTailWidth();
        if (tailWidth == null) {
            tailWidth = LineDecoration.DecorationSize.MEDIUM;
        }
        double dMax = Math.max(2.5d, basicStroke.getLineWidth());
        Rectangle2D anchor = DrawShape.getAnchor(graphics2D, getShape());
        double width = anchor.getWidth() + anchor.getX();
        double height = anchor.getHeight() + anchor.getY();
        double dAtan = Math.atan(anchor.getHeight() / anchor.getWidth());
        AffineTransform affineTransform = new AffineTransform();
        double dPow = Math.pow(1.5d, ((double) tailWidth.ordinal()) + 1.0d);
        double dPow2 = Math.pow(1.5d, ((double) tailLength.ordinal()) + 1.0d);
        LineDecoration.DecorationShape tailShape = lineDecoration.getTailShape();
        if (tailShape == null) {
            return null;
        }
        int i = C140702.f10162xdbdf26f2[tailShape.ordinal()];
        if (i == 1) {
            path = new Path();
            Ellipse2D.Double r21 = new Ellipse2D.Double(0.0d, 0.0d, dMax * dPow2, dMax * dPow);
            Rectangle2D bounds2D = r21.getBounds2D();
            affineTransform.translate(width - (bounds2D.getWidth() / 2.0d), height - (bounds2D.getHeight() / 2.0d));
            affineTransform.rotate(dAtan, (bounds2D.getWidth() / 2.0d) + bounds2D.getX(), (bounds2D.getHeight() / 2.0d) + bounds2D.getY());
            shapeCreateTransformedShape = r21;
        } else if (i == 2 || i == 3) {
            path = new Path(false, true);
            Path2D.Double r32 = new Path2D.Double();
            double d = -dMax;
            double d2 = d * dPow2;
            r32.moveTo(d2, (d * dPow) / 2.0d);
            r32.lineTo(0.0d, 0.0d);
            r32.lineTo(d2, (dMax * dPow) / 2.0d);
            affineTransform.translate(width, height);
            affineTransform.rotate(dAtan);
            shapeCreateTransformedShape = r32;
        } else if (i != 4) {
            path = null;
            shapeCreateTransformedShape = null;
        } else {
            path = new Path();
            Path2D.Double r33 = new Path2D.Double();
            double d3 = -dMax;
            double d4 = d3 * dPow2;
            r33.moveTo(d4, (d3 * dPow) / 2.0d);
            r33.lineTo(0.0d, 0.0d);
            r33.lineTo(d4, (dMax * dPow) / 2.0d);
            r33.closePath();
            affineTransform.translate(width, height);
            affineTransform.rotate(dAtan);
            shapeCreateTransformedShape = r33;
        }
        if (shapeCreateTransformedShape != null) {
            shapeCreateTransformedShape = affineTransform.createTransformedShape(shapeCreateTransformedShape);
        }
        if (shapeCreateTransformedShape == null) {
            return null;
        }
        return new Outline(shapeCreateTransformedShape, path);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Object, java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r8v0, types: [org.apache.poi.java.awt.Graphics2D] */
    public static CustomGeometry getCustomGeometry(String str, Graphics2D graphics2D) {
        ?? map = graphics2D == 0 ? 0 : (Map) graphics2D.getRenderingHint(Drawable.PRESET_GEOMETRY_CACHE);
        if (map == 0) {
            map = new HashMap();
            if (graphics2D != 0) {
                graphics2D.setRenderingHint(Drawable.PRESET_GEOMETRY_CACHE, map);
            }
            InputStream resourceAsStream = Drawable.class.getResourceAsStream("presetShapeDefinitions.xml");
            EventFilter eventFilter = new EventFilter() { // from class: org.apache.poi.sl.draw.DrawSimpleShape.1
                @Override // org.apache.poi.javax.xml.stream.EventFilter
                public boolean accept(XMLEvent xMLEvent) {
                    return xMLEvent.isStartElement();
                }
            };
            try {
                try {
                    XMLInputFactory xMLInputFactoryNewXMLInputFactory = StaxHelper.newXMLInputFactory();
                    XMLEventReader xMLEventReaderCreateXMLEventReader = xMLInputFactoryNewXMLInputFactory.createXMLEventReader(resourceAsStream);
                    XMLEventReader xMLEventReaderCreateFilteredReader = xMLInputFactoryNewXMLInputFactory.createFilteredReader(xMLEventReaderCreateXMLEventReader, eventFilter);
                    xMLEventReaderCreateFilteredReader.nextEvent();
                    Unmarshaller unmarshallerCreateUnmarshaller = JAXBContext.newInstance("org.apache.poi.sl.draw.binding").createUnmarshaller();
                    while (xMLEventReaderCreateFilteredReader.peek() != null) {
                        map.put(((StartElement) xMLEventReaderCreateFilteredReader.peek()).getName().getLocalPart(), new CustomGeometry((CTCustomGeometry2D) unmarshallerCreateUnmarshaller.unmarshal(xMLEventReaderCreateXMLEventReader, CTCustomGeometry2D.class).getValue()));
                    }
                    xMLEventReaderCreateFilteredReader.close();
                    xMLEventReaderCreateXMLEventReader.close();
                    IOUtils.closeQuietly(resourceAsStream);
                } catch (Exception e) {
                    throw new RuntimeException("Unable to load preset geometries.", e);
                }
            } catch (Throwable th) {
                IOUtils.closeQuietly(resourceAsStream);
                throw th;
            }
        }
        return (CustomGeometry) map.get(str);
    }

    @Override // org.apache.poi.p226sl.draw.DrawShape
    public SimpleShape<?, ?> getShape() {
        return (SimpleShape) this.shape;
    }
}
