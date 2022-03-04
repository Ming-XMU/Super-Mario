package �����;

import java.awt.image.BufferedImage;

public class zhangai implements Runnable{
	//�ϰ�������
	private int x,y;
	//�ϰ�������
	private int type;
	//�ϰ���ͼ��
	private BufferedImage zhangai ;
	//��ǰ����ͼ��
	private Background bg ;


	//���������߳�
	private Thread thread = new Thread(this);
	
	//���췽��
	public zhangai(int x,int y,int type,Background bg) {
		
		this.x = x;
		this.y = y;
		this.type = type;
		this.bg = bg;
		this.zhangai = Huancun.zhangai.get(type);
		//�����߳�����
		if(type == 9) {
			thread.start();
		}
	}
	
	public void run() {
		
		while(true) {
			if(this.bg.isWin()) {
				if(this.y < 372 ) {
					this.y +=5;
				}else {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					this.bg.setFinish(true);
				}
			
				
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
    
	
	//get ����
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public int getType() {
		return type;
	}

	public BufferedImage getZhangai() {
		return zhangai;
	}
	public Background getBg() {
		return bg;
	}

	public void setBg(Background bg) {
		this.bg = bg;
	}

}
