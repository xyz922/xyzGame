package com.xyz.game.role;

/**
 * 
 * @author 徐宇祯
 *
 */
public class Role {
	//角色面板,基础能力
	private final int LIFEMAX=5;
	private final int LIFEMIN=0;
	private final int ENERGYMAX=7;
	private int life=3;
	private int energy=0;
	private int addenergy=3;
	private boolean live=true;
	private boolean atackable=false;
	private boolean guardable=false;
	private String name="";
	
	//角色可以使用的能力
	public boolean atb=false;
	public boolean ade=false;
	public boolean gua=false;
	public boolean cur=false;
	public boolean undo=true;
	//获取角色name
		/*{
			System.out.println("为你的角色创建名字吧：");
			Scanner scanner=new Scanner(System.in);
			this.name=scanner.nextLine();
		}*/
	//攻击防御能力初始化
	void initialize(){
		this.atackable=false;
		this.guardable=false;
	}
	//失败条件
	void defeat(){
		this.live= (this.life ==0 )?false:true;
	}
	//
	public int getLife() {
		return life;
	}
	public void setLife(int life) {
		this.life = life;
	}
	public int getEnergy() {
		return energy;
	}
	public void setEnergy(int energy) {
		this.energy = energy;
	}
	public int getAddenergy() {
		return addenergy;
	}
	public void setAddenergy(int addenergy) {
		this.addenergy = addenergy;
	}
	public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
	public boolean isAtack() {
		return atackable;
	}
	public void setAtack(boolean atack) {
		this.atackable = atack;
	}
	public boolean isGuard() {
		return guardable;
	}
	public void setGuard(boolean guard) {
		this.guardable = guard;
	}
	public int getLIFEMAX() {
		return LIFEMAX;
	}
	public int getLIFEMIN() {
		return LIFEMIN;
	}
	
	public int getENERGYMAX() {
		return ENERGYMAX;
	}
	@Override
	public String toString() {
		return  name ;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}