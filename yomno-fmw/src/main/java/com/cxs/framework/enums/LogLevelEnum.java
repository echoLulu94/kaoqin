package com.cxs.framework.enums;

/**
 * 
 * @Description: 日志级别
 * OFF 、 FATAL 、 ERROR 、 WARN 、 INFO 、 DEBUG 、 TRACE 、 ALL 
 * @ClassName: LogLevelEnum 
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年5月21日 
 *
 */
public enum LogLevelEnum {

	/**
	 * OFF Level 是最高等级的，用于关闭所有日志记录
	 */
	OFF,
	/**
	 * FATAL level 指出每个严重的错误事件将会导致应用程序的退出
	 */
	FATAL,
	/**
	 * ERROR level 指出虽然发生错误事件，但仍然不影响系统的继续运行。 
	 */
	ERROR,
	/**
	 * WARN level 表明会出现潜在错误的情形。 
	 */
	WARN,
	/**
	 * INFO level 表明 消息在粗粒度级别上突出强调应用程序的运行过程。 
	 */
	INFO,
	/**
	 * DEBUG Level 指出细粒度信息事件对调试应用程序是非常有帮助的。 
	 */
	DEBUG,
	/**
	 * 与DEBUG 相比更细致化的记录事件消息。 
	 */
	TRACE,
	/**
	 * ALL Level 是最低等级的，用于打开所有日志记录。 
	 */
	ALL;
}
