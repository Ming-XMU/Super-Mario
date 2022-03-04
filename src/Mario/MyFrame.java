package �����;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyFrame extends JFrame implements Runnable{
	//bg List �洢����ͼƬ
	private ArrayList<Background> bg = new ArrayList<>();
	//��ʾ��ǰ����
	public  Background nowbg = new Background();
	//˫����
	public Image offScreenImage ;
	//����¶���
	private mario mario = new mario();
	//����µ��˶��߳�
	private Thread thread = new Thread(this);
	//�л�����
	
	public static void main(String args[]) {
		
		MyFrame mf = new MyFrame();
		mf.showUI();
	}
	
	//���ô��ڽ���
	public void showUI() {
		
		
		//���ô�������
		this.setTitle("�����");
		//���ô��ڴ�С
		this.setSize(800,600);
		//���ô��ھ�����ʾ
		this.setLocationRelativeTo(null);
		//���ô��ڵ���رս�������
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//���ô��ڴ�С���ɱ�
		this.setResizable(false);
		//���ô�����Ӽ��̼�����
		Listener Listener = new Listener();
		this.addKeyListener(Listener);
		//��Ӱ�ť
		ImageIcon icon = new ImageIcon("/C:/Users/Zhang/eclipse-workspace/Mario/src/Images/start.jpg");
		JButton button1 = new JButton(icon);
		button1.setSize(1000,800);
		button1.setContentAreaFilled(false);
		button1.addActionListener(Listener);
		button1.setFocusPainted(false);
		this.add(button1);
		
//		javax.swing.JButton jbu1 = new javax.swing.JButton("");
//		JButton jb2 = new JButton();
//		JButton jb3 = new JButton();
//		this.add(jbu1);

		//��ʽ����
		this.setLayout(new FlowLayout());
		//���ô��ڿɼ�
		this.setVisible(true);
		//��ʼ��ͼƬ
		Huancun.init();
		
		//ѭ���������г���
			for(int i = 1;i<=3;i++) {		
				bg.add(new Background(i,i == 3 ? true :false));		
			}
	
			//��ʼ�������
			mario = new mario(10,355);
			Listener.mario = mario;
			
			//���õ�ǰ����
			nowbg = bg.get(0);
			mario.setmariobg(nowbg);
			repaint();
			
			//�����߳�
			thread.start();
			this.remove(button1);
			//��������
//			new music();
			
		
	}
	
	public void paint(Graphics g) {
		
	//˫����
		offScreenImage = createImage(800,600);
		Graphics g1 = offScreenImage.getGraphics();
		
    //��������ͼ
	    //�����������ڻ�������
		g1.drawImage(nowbg.getBgimage(),0,0,this);
		//���Ƶ���
		for(Enemy enemy : nowbg.getEnemylist()) {
			g1.drawImage(enemy.getEnemy(),enemy.getX(),enemy.getY(),this);
		}
		//���Ʋ�ͬ���ϰ���
		for(zhangai zhangai : nowbg.getZhangailist()) {
			g1.drawImage(zhangai.getZhangai(),zhangai.getX(),zhangai.getY(),this);
		}
		//���ƳǱ�������
		g1.drawImage(nowbg.getTower(),620,270,this);
		g1.drawImage(nowbg.getGan(),500,220,this);
		
	//���������
//		System.out.println("X ��ֵΪ "+mario.getX());
//		System.out.println("Y ��ֵΪ "+mario.getY());
//		System.out.println("ͼƬ ��"+mario.getmario());
//		System.out.println("�����"+ mario);
		
		g1.drawImage(mario.getmario(),mario.getX(),mario.getY(),this);
		
		//��ʾ����
		Color c  = g1.getColor();
		g1.setColor(Color.black);
		g1.setFont(new Font("����",Font.BOLD,25));
		g1.drawString("��ǰ����Ϊ "+mario.getScore(), 300, 100);
		g1.setColor(c);
		
		
	//����������ͼƬ������
		g.drawImage(offScreenImage,0,0,this);
	}
	
	
	public void run() {
		while(true) {
			repaint();
			try {
				Thread.sleep(50);
		//���ó����л�	
			if(mario.getX() >= 775) {
				
				nowbg = bg.get(nowbg.getBw());
				mario.setmariobg(nowbg);
				mario.setX(10);
				mario.setY(355);
			  }
			
			//�ж�������Ƿ�����
			if(mario.isMariodeath()) {
				
				JOptionPane.showMessageDialog(this, "���ˣ�������������������������������������������");
				System.out.println("���ˣ�����������������������������������������");
				System.exit(0);
				
			}

			//�ж���Ϸ�Ƿ����
			if(mario.getOk()) {
				
				JOptionPane.showMessageDialog(this, "ͨ���ˣ���������������������������������");
				System.out.println("��Ϸ��������������������������������������������");
				
				System.exit(0);
				
			}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	

}
