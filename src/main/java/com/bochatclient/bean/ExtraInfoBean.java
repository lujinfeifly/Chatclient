package com.bochatclient.bean;

/**
 * @ClassName: ExtraInfoBean.java
 * @Description: 入场动画类 
 * @author renms
 * @date 2017年3月10日 上午10:09:22 
 * @version 1.0
 */
public class ExtraInfoBean {
	private String enterEffectPath;
	private String enterEffect;
	private boolean needBroadCast;
	
	
	public String getEnterEffectPath() {
		return enterEffectPath;
	}
	public void setEnterEffectPath(String enterEffectPath) {
		this.enterEffectPath = enterEffectPath;
	}
	public String getEnterEffect() {
		return enterEffect;
	}
	public void setEnterEffect(String enterEffect) {
		this.enterEffect = enterEffect;
	}
	public boolean isNeedBroadCast() {
		return needBroadCast;
	}
	public void setNeedBroadCast(boolean needBroadCast) {
		this.needBroadCast = needBroadCast;
	}
	
}
