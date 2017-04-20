package com.bochatclient.bean;

import com.bochatclient.annotation.Mapping;

/**
 * @ClassName: ExtraInfoBean.java
 * @Description: 入场动画类 
 * @author renms
 * @date 2017年3月10日 上午10:09:22 
 * @version 1.0
 */
public class ExtraInfoBean {
	@Mapping("b7")
	private String enterEffectPath;
	@Mapping("b9")
	private String enterEffect;
	@Mapping("c2")
	private boolean needBroadCast;
	@Mapping("c5")
	private int mallId;
	@Mapping("c6")
	private String zipPath;
	@Mapping("c7")
	private boolean moblieVersion;
	
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
	public int getMallId() {
		return mallId;
	}
	public void setMallId(int mallId) {
		this.mallId = mallId;
	}
	public String getZipPath() {
		return zipPath;
	}
	public void setZipPath(String zipPath) {
		this.zipPath = zipPath;
	}
	public boolean isMoblieVersion() {
		return moblieVersion;
	}
	public void setMoblieVersion(boolean moblieVersion) {
		this.moblieVersion = moblieVersion;
	}
	
	@Override
	public String toString() {
		return "ExtraInfoBean [enterEffectPath=" + enterEffectPath
				+ ", enterEffect=" + enterEffect + ", needBroadCast="
				+ needBroadCast + ", mallId=" + mallId + ", zipPath=" + zipPath
				+ ", moblieVersion=" + moblieVersion + "]";
	}
	
}
