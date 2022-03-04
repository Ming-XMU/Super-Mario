package �����;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Huancun {
	
//ͼƬ����
	//���ű���ͼ
	public static BufferedImage bg1;
	public static BufferedImage bg2;
	//������
	public static BufferedImage jump_L;
	//������
	public static BufferedImage jump_R;
	//���ﳯ����
	public static BufferedImage stand_L;
	//���ﳯ����
	public static BufferedImage stand_R;
	//�Ǳ�
	public static BufferedImage tower;
	//���
	public static BufferedImage gan;
	//��ʼ����
	public static BufferedImage start;
//�ж���ͼƬ��ϵ� ��List����ʽ�洢
	//�ϰ��� 
	public static ArrayList<BufferedImage> zhangai = new ArrayList<>();
	//�������� ����
	public static ArrayList<BufferedImage> run_L = new ArrayList<>();
	public static ArrayList<BufferedImage> run_R = new ArrayList<>();
	//Ģ��
	public static ArrayList<BufferedImage> mushroom = new ArrayList<>();
	//ʳ�˻�
	public static ArrayList<BufferedImage> monster = new ArrayList<>();

//������������ֵ
	public static void init() {
		//����ͼƬ�ļ���
		try {
			
			bg1 = ImageIO.read(new File("/C:/Users/Zhang/eclipse-workspace/Mario/src/Images/" + "bg.png")); 
			bg2 = ImageIO.read(new File("/C:/Users/Zhang/eclipse-workspace/Mario/src/Images/" + "bg2.png"));
			jump_L = ImageIO.read(new File("/C:/Users/Zhang/eclipse-workspace/Mario/src/Images/" + "jump1_L.png"));
			jump_R = ImageIO.read(new File("/C:/Users/Zhang/eclipse-workspace/Mario/src/Images/"+ "jump1_R.png"));
			stand_L = ImageIO.read(new File("/C:/Users/Zhang/eclipse-workspace/Mario/src/Images/"+ "stand_L.png"));
			stand_R = ImageIO.read(new File("/C:/Users/Zhang/eclipse-workspace/Mario/src/Images/"+ "stand_R.png"));
			tower = ImageIO.read(new File("/C:/Users/Zhang/eclipse-workspace/Mario/src/Images/"+ "tower.png"));
			gan = ImageIO.read(new File("/C:/Users/Zhang/eclipse-workspace/Mario/src/Images/"+ "gan.png"));
			
        } catch (IOException e) {
            e.printStackTrace();
        }
		//����ͼƬ�ļ��� ��forѭ���ķ�ʽ����
		//������
		for(int i = 1;i<=2;i++) {
			try {
				run_L.add(ImageIO.read(new File("/C:/Users/Zhang/eclipse-workspace/Mario/src/Images/"+ "run"+i+"_L.png")));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
		//������
		for(int i = 1;i<=2;i++) {
			try {
				run_R.add(ImageIO.read(new File("/C:/Users/Zhang/eclipse-workspace/Mario/src/Images/"+ "run"+i+"_R.png")));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
		//�ϰ���
		try {
			//ש��
			zhangai.add(ImageIO.read(new File("/C:/Users/Zhang/eclipse-workspace/Mario/src/Images/"+"brick.png")));
			zhangai.add(ImageIO.read(new File("/C:/Users/Zhang/eclipse-workspace/Mario/src/Images/"+"brick2.png")));
			//������
			zhangai.add(ImageIO.read(new File("/C:/Users/Zhang/eclipse-workspace/Mario/src/Images/"+"soil_base.png")));
			zhangai.add(ImageIO.read(new File("/C:/Users/Zhang/eclipse-workspace/Mario/src/Images/"+"soil_up.png")));
	     } catch (IOException e) {
	            e.printStackTrace();
	       }
		//�ܵ�Ҳ�����ϰ��� ������
		for(int i = 1;i<=4;i++) {
			try {
				zhangai.add(ImageIO.read(new File("/C:/Users/Zhang/eclipse-workspace/Mario/src/Images/"+ "pipe"+i+".png")));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
		//���ز����ƻ���ש�������
		try {
			//�����ƻ���ש��
			zhangai.add(ImageIO.read(new File("/C:/Users/Zhang/eclipse-workspace/Mario/src/Images/"+"brick2.png")));
			//����
			zhangai.add(ImageIO.read(new File("/C:/Users/Zhang/eclipse-workspace/Mario/src/Images/"+"flag.png")));
	     } catch (IOException e) {
	            e.printStackTrace();
	       }
		//����Ģ����
		for(int i = 1;i<=3;i++) {
			try {
				mushroom.add(ImageIO.read(new File("/C:/Users/Zhang/eclipse-workspace/Mario/src/Images/"+ "fungus"+i+".png")));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
		
		for(int i = 1;i<=2;i++) {
			try {
				monster.add(ImageIO.read(new File("/C:/Users/Zhang/eclipse-workspace/Mario/src/Images/"+ "flower1."+i+".png")));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}

	}
}
 