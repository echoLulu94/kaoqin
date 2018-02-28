package com.cxs.framework.utils;

import java.util.Collection;

public class ObjUtil {

	public static boolean isNull(Object object) {
		if (object instanceof String) {
			return StringUtil.isEmpty(object.toString());
		}
		return object == null;
	}
	
	public static boolean isNotNull(Object object) {
		if (object instanceof String) {
			return StringUtil.isNotEmpty(object.toString());
		}
		return object != null;
	}

	@SuppressWarnings("rawtypes")
	public static boolean isNull(Collection object) {
		return null == object || object.size() ==0;
	}

	@SuppressWarnings("rawtypes")
	public static boolean isNotNull(Collection object) {
		return isNull(object);
	}
}
