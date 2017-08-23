package com.bochatclient.utils;


/**
 * <p>Title:GuidUtil.java</p>
 * <p>Description:</p>
 * <p>Company:changyou</p>
 * @author lifengyong
 * date 2014-8-5 下午4:00:14
 * @version 1.0
 */

public class GuidUtil {
	public static String getGuid(int zoneWorldID, int guidH, int guidL) {
		return zoneWorldID + "|" + guidH + "|" + guidL;
	}

	public static int getZoneWorldID(String guid) {
		return Integer.valueOf(guid.substring(0, guid.indexOf("|"))).intValue();
	}

	public static int getGuidL(String guid) {
		return Integer.valueOf(guid.substring(guid.lastIndexOf("|") + 1))
				.intValue();
	}

	public static int getGuidH(String guid) {
		return Integer.valueOf(
				guid.substring(guid.indexOf("|") + 1, guid.lastIndexOf("|")))
				.intValue();
	}

	public static String getGuidWithoutGroup(String guid) {
		if (guid.indexOf("|") == guid.lastIndexOf("|")) {
			return guid;
		}
		return guid.substring(guid.indexOf("|") + 1);
	}

	public static void main(String[] args) {
		System.out.println(getGuidhAndGuidl("234702011290AA7D")[0]+"--"+getGuidhAndGuidl("234702011290AA7D")[1]);;
	}
	public static Integer[] getGuidhAndGuidl(String str) {
		try{
			if(str==null||"".equals(str)){
				return new Integer[]{0,0};
			}
	//		Long li = Long.valueOf(Long.parseLong(str));
	//		String hexstr = Long.toHexString(li.longValue());
			int split = str.length() - 8;
			String befstr = str.substring(0, split);
			String endstr = str.substring(split);
			Integer beflong = Integer.valueOf(Integer.parseInt(befstr, 16));
			Integer endlong = Integer.valueOf(Integer.parseInt(endstr, 16));
			Integer[] guids = { beflong, endlong };
			return guids;
		}catch(Exception e){
			return new Integer[]{0,0};
		}
		
	}
}