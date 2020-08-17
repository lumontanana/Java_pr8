package lab8.util;

import java.awt.Color;
import lab8.generics.vegetable.Vegetable;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import lab8.basic.Customer;

/**
 *
 * @author julia
 */
public class Util {

    static Random r = new Random(99);

    public static void payment(Customer c, double cost) {
        System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
        System.out.println(c + " has paid " + cost + " EUR.");
        System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
    }

    public static double generateDoubleNumber(double min, double max) {
        double a = (double) r.nextDouble() * max;
        if (a < min) {
            a = min;
        } else if (a > max) {
            a = max;
        }
        return a;

    }

    public static BufferedImage resize(BufferedImage image, int width, int height) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return bi;
    }

    public static void showVegetableList(ArrayList<Vegetable> sl, Customer c) throws IOException {
        String folder = "./images/";
       
        System.out.println("sl:" + sl);
        System.out.println("c:" + c);
        
        JFrame frame = new JFrame("Shopping List: " + c.getDni() + " [" + Calendar.getInstance().getTime() + "]\t Name = " + c.getName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 6, 1, 1));

        for (int i = 0; i < 24; i++) {
            BufferedImage image = null;
            if (i < sl.size()) {
                image = ImageIO.read(new File(folder + sl.get(i).getImageFile()));
            } else {
                image = ImageIO.read(new File(folder + "blank.jpg"));
            }
            BufferedImage resizedImage = Util.resize(image, 150, 150);
            ImageIcon imageVegetable = new ImageIcon(resizedImage);
            JLabel label2 = new JLabel(new Integer(i + 1).toString(), imageVegetable, JLabel.LEFT);
            label2.setBorder(BorderFactory.createLineBorder(Color.black));
            frame.add(label2);
        }
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public static String getCurrentData() {
        //DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HHmmss");
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-");
        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime()) + (char) (r.nextInt(26) + 'a') + cal.getTimeInMillis();

    }
}
