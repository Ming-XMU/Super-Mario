package �����;

import java.awt.image.BufferedImage;

public class mario implements Runnable {
	//����µĵ�ǰλ��
	private int x,y;
	//����µ�״̬
	private String status;
	//��ǰ��ͼ��
	private BufferedImage mario;
	//��ȡ�������ϰ������Ϣ
	private Background mariobg = new Background();
	//���߳�ʵ������µĶ���
	private Thread thread;
	//����µ��ƶ�
	private int speed;
	//����µ���Ծ
	private int jump;
	//ȡ��������˶�ͼ��
	public int index;
	//��Ծ����
	public int up;
	//������Ƿ��ߵ��˳Ǳ�
	private Boolean ok = false;
	public zhangai zhangai;
	//�ж�������Ƿ�����
	private  boolean mariodeath = false;
	//����
	private int score = 0;
	


	public mario() {
		
	}
	public mario(int x,int y) {
		
		this.x = x;
		this.y = y;
		this.mario = Huancun.stand_R;
		this.status = "stop-right";
		this.thread = new Thread(this);
		thread.start();
		
	}
	public void mariodeath() {
		mariodeath = true;
	}
	
	//����������ƶ�
	public void move_left() {
		
		//��������µ��ٶ�
		speed = -5;
		//�ж�������Ƿ���������
		if(mariobg.isWin()) {
			speed = 0;
		}
		//�ж��Ƿ�����Ծ��
		if(status.indexOf("jump") != -1) {
			status = "jump-left";
		}else {
			status = "move-left";
		}
		
	}
	
	
	//����������ƶ�
		public void move_right() {
			
			//��������µ��ٶ�
			speed = 5;
			//�ж�������Ƿ���������
			if(mariobg.isWin()) {
				speed = 0;
			}
			//�ж��Ƿ�����Ծ��
			if(status.indexOf("jump") != -1) {
				status = "jump-right";
			}else {
				status = "move-right";
			}
		}
			
	//�����ֹͣ
			public void stop_left() {
				speed = 0 ;
				if(status.indexOf("jump") != -1) {
					status = "jump-left";
				}else {
					status = "stop-left";
				}
			}
			public void stop_right() {
				speed = 0 ;
//				System.out.println("status ��ֵ "+status.indexOf("jump"));
				if(status.indexOf("jump") != -1) {
					status = "jump-right";
				}else {
					status = "stop-right";
				}
			}

		//�������Ծ����
			public void jump() {
				//�ж��Ƿ�Ϊ��Ծ״̬
				if(status.indexOf("jump") == -1) {
					if(status.indexOf("left") != -1) {
						status = "jump-left";
					}else {
						status = "jump-right";
					}
				
					jump = -10;
					up = 7;
				}
				//�ж�������Ƿ���������
				if(mariobg.isWin()) {
					jump = 0;
				}
			}
			
			public void fall() {
				//���� �����ֿ��ܣ���Ծ���ߴ�ש�����£������ж���Ծ
				if(status.indexOf("left") != -1) {
					status = "jump-left";
				}else {
					status = "jump-right";
				}
				jump = 10;
			}

				
	
	public void run() {
		
	  while(true) {
		//�ж��Ƿ����ϰ�����
			boolean on = false;
		//�ж��Ƿ�������һ�����
			boolean right = true;
			boolean left = true;
			
//			System.out.println("Finish  "+mariobg.finish);
//			System.out.println("Win  "+mariobg.win);
//			System.out.println("y  "+this.y);
//			System.out.println("x  "+this.x);
//			System.out.println("status =  "+status);
			
		//��Ϸ��������
			if(mariobg.isFlag() && this.x >= 500) {
				
				this.mariobg.setWin(true);
				
				if(mariobg.isFinish() ) {
					
					this.status = "move-right";
					
					if(this.x < 690) {
//						move_right();
						this.x += 5;
						this.y = 395;
//						try {
//							Thread.sleep(50);
//						} catch (InterruptedException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
					}else {
						this.ok = true;
					}
					
				}else {
					if(this.y < 395) {
						speed = 0;
						this.y += 5;
						this.status = "jump-right";
					}
					
					if(this.y > 395) {
						this.status = "stop-right";
						this.y = 395;
					}
				}
				
			}else {
	
				//���������ϰ�
				for(int i = 0;i<mariobg.getZhangailist().size();i++) {
					zhangai ob = mariobg.getZhangailist().get(i);
					//�ж��Ƿ����ϰ�����
					if(ob.getY() == this.y + 25 && ob.getX()>this.x - 30 && ob.getX()<this.x + 25 ) {
						
						on = true;
					}
				//�ж��Ƿ������ϰ���
					//�Ƿ񶥵����ϰ���
					if(ob.getY() >= this.y - 30 && ob.getY()<=this.y - 20 && ob.getX()>this.x - 30 && ob.getX()<this.x + 25) {
						
						if(ob.getType() == 0) {
							 mariobg.getZhangailist().remove(ob);
							 score +=1 ;
						}
						up = 0;
					}
					//�����ϰ����ж�
					if(ob.getX() == this.x + 25 && ob.getY() >this.y - 30 && ob.getY()<this.y + 25) {
						
						right = false;
						
					}
					//�������ϰ����ж�
					if(ob.getX() == this.x - 30 && ob.getY() >this.y - 30 && ob.getY()<this.y + 25) {
						
						left = false;
						
					}
					
				}
				//�ж��Ƿ����ϰ�����
				if(on && up == 0) {
					//�ж�����³���������
					if(status.indexOf("left") != -1) {
						
						if(speed != 0) {
							status = "move-left";
						}else {
							status = "stop-left";
						}
						
					}else {
						
							if(speed != 0) {
							status = "move-right";
						}else {
							status = "stop-right";
						}
						
					}
					
				}else {
					if(up !=0) {
						up--;
					}else {
						fall();
					}
					y += jump;
				}
			}
				
				//�ж�������Ƿ���Լ����ж�
				if((left && speed < 0) || (right && speed > 0)) {
					x += speed;
					//�ж��Ƿ������
					if(x<0) {
						x = 0;
					}
					if(x > 760 && mariobg.bw ==3) {
						
						x =760;
					}
				}
				//�ж�������Ƿ��������ˣ��Ƿ��������
				for(int i = 0 ;i < mariobg.getEnemylist().size();i++) {
					
					Enemy enemy = mariobg.getEnemylist().get(i);
					//�Ƿ�ȵ��˵���
					if(enemy.getY()== this.y +20 && (enemy.getX() -25 <this.x && enemy.getX() +35 >= this.x)) {
						//�ж��Ƿ���Ģ������
						if(enemy.getType()==1) {
							enemy.death();
							up = 3;
							jump = -10;
							score +=2 ;
						}else if(enemy.getType()==2) {
							//���������
							mariodeath();
						}
					}
					//�Ƿ���������
					if((enemy.getX() + 35 > this.x && enemy.getX() -25 <this.x) && (enemy.getY() +35 >this.y && enemy.getY() -20 <this.y) ) {
						//���������
						mariodeath();
					}
				}
//				System.out.println("ok  "+ok);
//				System.out.println("Finish  "+mariobg.finish);
//				System.out.println("win  "+mariobg.win);
//				System.out.println("status =  "+status);
				if(status.contains("move")) {
					index = index == 0 ? 1:0;
				}
				//�Ƿ������ƶ�
				if("move-left".equals(status)) {
					mario = Huancun.run_L.get(index);
				}
//				System.out.println(" �����ߣ�   "+status);
				//�Ƿ������ƶ�
				if("move-right".equals(status)) {
					mario = Huancun.run_R.get(index);
					
				}
				//�Ƿ�����ֹͣ
				if("stop-left".equals(status)) {
					mario = Huancun.stand_L;
				}
				//�Ƿ�����ֹͣ
				if("stop-right".equals(status)) {
					mario = Huancun.stand_R;
				}
				//�Ƿ�������Խ
				if("jump-left".equals(status)) {
					mario = Huancun.jump_L;
				}
				//�Ƿ�������Ծ
				if("jump-right".equals(status)) {
					mario = Huancun.jump_R;
				}
				
				//��ʱ50����
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
		
		
	}
	
	
	//set get ����
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public BufferedImage getmario() {
		return mario;
	}
	public void setmario(BufferedImage mario) {
		mario = mario;
	}
	public void setmariobg(Background mariobg) {
		this.mariobg = mariobg;
	}
	
	public Boolean getOk() {
		return ok;
	}
	public boolean isMariodeath() {
		return mariodeath;
	}
	public int getScore() {
		return score;
	}

}
