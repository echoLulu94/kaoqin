package com.cxs.framework.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.cxs.framework.enums.IdTypeEnum;

/**
 * 
 * @ClassName: IdUtil 
 * @Description: TODO id工具类，sql查询条件限制值的长度为1000，本工具用于大id列表拆成多个小id列表
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年3月6日 上午12:25:54 
 *
 */
public class IdUtil {


    public static String[] chars = new String[]{"a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
            "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z"};


    public static String generateShortUuid() {
        StringBuffer shortBuffer = new StringBuffer();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < 8; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(chars[x % 0x3E]);
        }
        return shortBuffer.toString();
    }
    
    
	public static String getUuid(){
		String id = UUID.randomUUID().toString().replaceAll("-", "");
		return id;
	}
	
	public static List<String> getIdsList(List<String> idList){
		return IdUtil.getIdsList(idList,null);
	}

	public static List<String> getIdsList(List<String> idList,String idType){
		List<String> idsList = new ArrayList<String>();
		if(null==idType||"".equals(idType)){
			idType = IdTypeEnum.S.getKey();
		}
		StringBuilder idsStrBuilder = new StringBuilder();
		int i=0;
		for(String id:idList){
			if(IdTypeEnum.S.getKey().equals(idType)){
				idsStrBuilder.append(",").append("'").append(id).append("'");
			}else{
				idsStrBuilder.append(",").append(id);
			}
			if(i==998){
				String idsStr=idsStrBuilder.toString();
				idsStr = idsStr.substring(1);
				idsList.add(idsStr);
				idsStrBuilder = new StringBuilder();
				i=0;
			}
			i++;
		}
		if(i!=0){
			String idsStr = idsStrBuilder.toString();
			if(null!=idsStr&&!"".equals(idsStr)){
				idsStr = idsStr.substring(1);
			}
			idsList.add(idsStr);
		}
		return idsList;
	}
	
	public static List<String> getIdsList(String [] ids){
		return IdUtil.getIdsList(ids,null);
	}
	
	public static List<String> getIdsList(String [] ids,String idType){
		List<String> idsList = new ArrayList<String>();
		if(null==idType||"".equals(idType)){
			idType = IdTypeEnum.S.getKey();
		}
		StringBuilder idsStrBuilder = new StringBuilder();
		int i=0;
		for(String id:ids){
			if(IdTypeEnum.S.getKey().equals(idType)){
				idsStrBuilder.append(",").append("'").append(id).append("'");
			}else{
				idsStrBuilder.append(",").append(id);
			}
			if(i==998){
				String idsStr=idsStrBuilder.toString();
				idsStr = idsStr.substring(1);
				idsList.add(idsStr);
				idsStrBuilder = new StringBuilder();
				i=0;
			}
			i++;
		}
		if(i!=0){
			String idsStr = idsStrBuilder.toString();
			if(null!=idsStr&&!"".equals(idsStr)){
				idsStr = idsStr.substring(1);
			}
			idsList.add(idsStr);
		}
		return idsList;
	}

}
