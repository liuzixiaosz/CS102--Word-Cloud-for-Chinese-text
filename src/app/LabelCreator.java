package app;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import wordcount.StringFreqType;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class LabelCreator {
    private final static int MODIFIER = 9;
    private final static int MAXNUM = 135;
    public static List<Label> getLabels(List<StringFreqType> wordFreqList, List<Circle> circles) {
        List<Label> labelList = new LinkedList<>();
        int terms = (wordFreqList.size() >= MAXNUM) ? MAXNUM : wordFreqList.size();
        int word_idx = 0;
        Collections.shuffle(circles);
        xml:for (int i = 0; i < circles.size(); i++) {
            // deal circles, get positions
            int seg = i / MODIFIER;
            Circle parent_c = circles.get(i);

            CircleArea circleArea = new CircleArea(parent_c.getCenterX(), parent_c.getCenterY(), parent_c.getRadius(), seg);
            List<ChildrenCircle> areas = circleArea.getChildAreas();
            for (int j = 0; j < areas.size(); j++) {
                String tmp = wordFreqList.get(word_idx).str;
                String s = tmp.substring(0, tmp.lastIndexOf("/"));
                Label l = new Label(s);
                int this_freq = wordFreqList.get(word_idx).freq;
                double size = Math.pow(Math.min(this_freq, 70), 0.7) + this_freq * 20 / wordFreqList.get(0).freq;
                l.setFont(new Font(getRandomFont(), size));
//                l.getBoundsInLocal();
                double offset_x = -size * s.length() / 2;
                double offset_y = -size / 2;
                l.setLayoutX(areas.get(j).x + offset_x);
                l.setLayoutY(areas.get(j).y + offset_y);
                Random r = new Random();
                l.setRotate(20 - r.nextInt(40));
                l.setTextFill(Color.rgb(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
                labelList.add(l);
                word_idx++;
                if (word_idx >= terms) break xml;
            }
        }
        return labelList;
    }

    public static String getRandomFont() {
        String[] fonts = {"Weibei TC", "Songti TC", "Xingkai TC",
                "Times", "HanziPen TC", "Libian TC",
                "Lantinghei TC", "LiHei Pro", "Yuanti TC", "Kaiti TC",
        };
        return fonts[(new Random()).nextInt(fonts.length)];
    }
}
