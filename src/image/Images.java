/**
 * Image location pre-load
 */
package image;

import java.awt.Image;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import image.resource.Resources;

/**
 * @author 
 *
 */
public class Images {
	/**
	 * Overviews
	 */
	public static ImageIcon townOvImg = new ImageIcon(Resources.class.getResource("Mayor.png"));
	public static ImageIcon militaryOvImg = new ImageIcon(Resources.class.getResource("GeneralActive.png"));
	public static ImageIcon researchOvImg = new ImageIcon(Resources.class.getResource("Scientist.png"));
	public static ImageIcon diplomacyOvImg = new ImageIcon(Resources.class.getResource("Diplomat.png"));
	public static ImageIcon ovBackgroundImg = new ImageIcon(Resources.class.getResource("OVPanel.png"));
	/**
	 * House info
	 */
	public static ImageIcon townHallImg = new ImageIcon(Resources.class.getResource("TownHall.png"));
	public static ImageIcon pillageImg = new ImageIcon(image.Images.class.getResource("Pillage_Enabled.png"));
	/**
	 * Islands
	 */
	private static String[] islandUrl = new String[] { "Island1.jpg", "Island2.jpg", "Island3.jpg", "Island4.jpg",
			"Island5.jpg" };

	private static String[] islandTnUrl = new String[] { "thumbnails/Island1_tn.jpg", "thumbnails/Island2_tn.jpg",
			"thumbnails/Island3_tn.jpg", "thumbnails/Island4_tn.jpg", "thumbnails/Island5_tn.jpg" };

	public static Image getIslandImage(int mapId) {
		try (InputStream stream = Resources.class.getResourceAsStream(islandUrl[mapId - 1])) {
			Image res = ImageIO.read(stream);
			return res;
		} catch (Exception e) {
			System.out.println(e);
			System.exit(0);
			return null;
		}
	}

	public static Image getIslandThumbnail(int mapId) {
		try (InputStream stream = Resources.class.getResourceAsStream(islandTnUrl[mapId - 1])) {
			Image res = ImageIO.read(stream);
			return res;
		} catch (Exception e) {
			System.out.println(e);
			System.exit(0);
			return null;
		}
	}
}
