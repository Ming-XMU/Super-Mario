package �����;

import java.awt.image.BufferedImage;

public class Enemy implements Runnable{
	
	//��������
	private int x, y;
	//��������
	private int type;
	//�˶�����
	private boolean face = false ;
	//����ͼ��
	private BufferedImage enemy;
	//����ͼ
	private Background bg; 
	//�˶���Χ
	private int max = 0;
	private int min = 0;
	//��ǰͼƬ״̬
	private int a;
	//�����̶߳��� ����di'ren'yun'd
	private Thread thread = new Thread(this);
	
	//Ģ����
	public Enemy(int x ,int y,boolean face,int type, Background bg) {
			
			this.x = x;
			this.y = y;
			this.face = face;
			this.type = type;
			this.bg = bg;
			enemy = Huancun.mushroom.get(0);
			thread.start();
	}
	
	//�����ж�
	public void death(){
		
		enemy = Huancun.mushroom.get(2);
		this.bg.getEnemylist().remove(this);
		
	}
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public BufferedImage getEnemy() {
		return enemy;
	}

	public void setEnemy(BufferedImage enemy) {
		this.enemy = enemy;
	}
	public int getType() {
		return type;
	}

	//ʳ�˻�
	public Enemy(int x ,int y,boolean face,int type, Background bg,int max ,int min ) {
			
			this.x = x;
			this.y = y;
			this.face = face;
			this.type = type;
			this.bg = bg;
			this.max = max;
			this.min = min;
			enemy = Huancun.monster.get(0);
			thread.start();
		}
	
	public void run() {
		
		while(true) {
			//�ж��Ƿ���Ģ������
			if(type == 1) {
				
				if(face) {
					this.x -= 2;
				}else {
					this.x += 2;
				}
				
				a = a == 1 ? 0:1;
				enemy = Huancun.mushroom.get(a);
			}
				//������������ϰ����жϷ�ʽһ��
				//�������������������ж��Ƿ����������ƶ�
				boolean right = true;
				boolean left = true;
//				System.out.println("right ��ֵ "+right);
//				System.out.println("left ��ֵ "+left);
				for(int i = 0;i<bg.getZhangailist().size();i++) {
					
					zhangai zhangai = bg.getZhangailist().get(i);
//					System.out.println("����ֵ  "+(zhangai.getX()-this.x));
					//�ж��Ƿ����������
					if(zhangai.getX() == this.x +36 && (zhangai.getY() + 65 > this.y && zhangai.getY() - 35 < this.y)) {
						right = false;
//						System.out.println("right ��ֵ "+right);
					}
					//������
					if(zhangai.getX() == this.x -36 && (zhangai.getY() + 65 > this.y && zhangai.getY() - 35 < this.y)) {
						left = false;
//						System.out.println("left ��ֵ "+left);
					}
				}
				
				
				if(face && (!left) || this.x == 0) {
					
					face = false;
					
				}
				else if((!face) && (!right) || this.x >= 764) {
					
					face = true;
				}
			
	
			
			if(type == 2) {
				
				if(face) {
					this.y -= 5;
				}else {
					this.y += 5;
				}
				
				a = a == 1 ? 0:1;
				
				//�Ƿ��ƶ���������
				if(face &&(this.y <= max)) {
					
					face = false;
				}
				if(!face &&(this.y >= min)) {
					
					face = true;
				}
				enemy = Huancun.monster.get(a);
			}
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		
		
	}

}
