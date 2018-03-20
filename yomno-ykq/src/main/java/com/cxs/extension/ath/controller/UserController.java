package com.cxs.extension.ath.controller;

import com.cxs.extension.ath.dto.UserDto;
import com.cxs.extension.ath.result.UserResult;
import com.cxs.extension.ath.service.api.UserService;
import com.cxs.extension.core.config.SysConfig;
import com.cxs.extension.core.utils.MessageDigestUtil;
import com.cxs.extension.sys.interceptor.CorsInterceptor;
import com.cxs.extension.sys.interceptor.NoAuth;
import com.cxs.extension.sys.service.api.DictItemService;
import com.cxs.framework.dto.PageDto;
import com.cxs.framework.dto.ResultDo;
import com.cxs.framework.result.InterfaceResult;
import com.cxs.framework.utils.ath.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/ath")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(CorsInterceptor.class);

    @Autowired
    private SysConfig sysConfig;
    @Autowired
    private UserService userService;
    @Autowired
    private DictItemService dictItemService;

    @RequestMapping(value="login")
    @ResponseBody
    @NoAuth
    public ResultDo<UserDto> Login(@RequestParam(value = "id",required = true) String id, @RequestParam(value="pwd",required = true
    ) String pwd,HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        ResultDo<UserDto> resultDo = new ResultDo<UserDto>();
        if(id!=null){
            UserDto userDto = userService.findOneById(id);
            Integer loginFlag = 0;
            if (null != userDto) {
                //获取用户输入的密码，并加密得到真实密码
                if(pwd!=null){
                    String password = MessageDigestUtil.hmacsha512(pwd, userDto.getSalt());
                    if (userDto.getPwd().equals(password)) {
                        //获得令牌
                        Token token = Token.buildToken(sysConfig.getTokenName(), id, userDto.getSalt(), Token.LOGIN_MAX_AGE);
                        resultDo.setResultDo(UserResult.LOGIN_SUCCESS);
                        resultDo.setResultData(userDto);
                        if (null == token) {
                            resultDo.setResultDo(UserResult.LOGINNAME_OR_PWD_INCORRECT);
                            logger.error(UserResult.LOGINNAME_OR_PWD_INCORRECT.getValue());
                        } else {
                            Cookie cookie = Token.buildCookie(sysConfig.getTokenName(), token.toTokenString(), token.getMaxAge());
                            response.addCookie(cookie);
                            loginFlag = 1;
                        }
                    } else {
                        resultDo.setResultDo(UserResult.PWD_ERROR);
                        logger.error(UserResult.PWD_ERROR.getValue());
                    }
                }else {
                    resultDo.setResultDo(UserResult.PWD_NOT_NULL);
                    logger.error(UserResult.PWD_NOT_NULL.getValue());
                }
                if (loginFlag == 0) {
                    // 登录失败
                    if (null == userDto.getLoginFailCount()) {
                        userDto.setLoginFailCount(0);
                    }
                    userDto.setLoginFailCount(userDto.getLoginFailCount() + 1);
                    userService.updateUser(userDto);
                } else {
                    // 登录成功
                    userDto.setLoginTime(System.currentTimeMillis());
                    System.out.println("登录时间" + userDto.getLoginTime() + "系统时间" + System.currentTimeMillis());
                    if (null != userDto.getLoginFailCount() && userDto.getLoginFailCount() > 0) {
                        // 登录失败次数不为0，
                        userDto.setLoginFailCount(0);
                    }
                    // TODO 修改用户信息增加登录设备相关信息
				/*try {
					userService.updateUser(userDto);
				} catch (Exception e) {
					resultDo.setResultDo(UserResult.UPDATE_LOGIN_DEVICE_ERROR);
					logger.error(UserResult.UPDATE_LOGIN_DEVICE_ERROR.getValue(), e);
				}*/
                    // TODO 记录登录日志
                    // 返回用户信息,去除密码和加密秘钥信息
                    userDto.setPwd("******");
                    userDto.setSalt("******");
                }
            }else{
                resultDo.setResultDo(UserResult.LOGIN_USER_NOT_EXIST);
                logger.error(UserResult.LOGIN_USER_NOT_EXIST.getValue());
            }
        }else{
            resultDo.setResultDo(UserResult.LOGIN_USER_NOT_EXIST);
            logger.error(UserResult.LOGIN_USER_NOT_EXIST.getValue());
        }

        return resultDo;
    }


    @RequestMapping("/logout")
    @ResponseBody
    @NoAuth
    public ResultDo<String> logout(HttpServletResponse response, HttpSession session) {
        ResultDo<String> resultDo = new ResultDo<String>();
        resultDo.setResultDo(InterfaceResult.SUCCESS);
        logger.info(InterfaceResult.SUCCESS.getValue());
        Cookie cookie = Token.buildCookie(sysConfig.getTokenName(), null, 0);
        response.addCookie(cookie);
        return resultDo;
    }

    @RequestMapping("/saveUser")
    @ResponseBody
    @NoAuth
    public ResultDo<UserDto> saveUser(UserDto userDto, HttpServletRequest request) {
        Token token = Token.readTokenFromCookie(sysConfig.getTokenName(), request.getCookies());
        if (null != token) {
            userDto.setCreateBy(token.getId());
        }
        return userService.saveUser(userDto);
    }

    @RequestMapping("/deleteUser")
    @ResponseBody
    @NoAuth
    public ResultDo<String> deleteUser(String id) {
        return userService.deleteUserById(id);
    }

    @RequestMapping("/deleteAllUser")
    @ResponseBody
    @NoAuth
    public ResultDo<String[]> deleteAllUser(String[] ids) {
        return userService.deleteUserByIds(ids);
    }

    @RequestMapping("/updateUser")
    @ResponseBody
    @NoAuth
    public ResultDo<UserDto> updateUser(UserDto userDto, HttpServletRequest request) {
        Token token = Token.readTokenFromCookie(sysConfig.getTokenName(), request.getCookies());
        if (null != token) {
            userDto.setUpdateBy(token.getId());
        }
        return userService.updateUser(userDto);
    }

    /* 显示子系统详情 */
    @RequestMapping("/viewUser")
    @ResponseBody
    @NoAuth
    public ResultDo<Map<String, Object>> viewUser(String id) {
        logger.info("userId:" + id);
        ResultDo<Map<String, Object>> resultDo = new ResultDo<Map<String, Object>>();
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            ResultDo<UserDto> userResultDto = userService.findUserById(id);
            String code = userResultDto.getResultCode();
            resultMap.put("userDto", userResultDto.getResultData());
            if (code.equals("API1000")) {
                resultDo.setResultDo(InterfaceResult.SUCCESS);
                logger.info(InterfaceResult.SUCCESS.getValue());
            } else {
                resultDo.setResultDo(UserResult.VIEW_FAILURE);
                resultDo.setResultMsg(userResultDto.getResultMsg());
                logger.error(UserResult.VIEW_FAILURE.getValue());
            }
        } catch (Exception e) {
            resultDo.setResultDo(UserResult.VIEW_FAILURE);
            logger.error(UserResult.VIEW_FAILURE.getValue(), e);
        }
        resultMap.put("userStateList", dictItemService.findByTypeCode("USER_STATE").getResultData());
        resultMap.put("userTypeList", dictItemService.findByTypeCode("USER_TYPE").getResultData());
        resultMap.put("sexList", dictItemService.findByTypeCode("SEX").getResultData());
        resultDo.setResultData(resultMap);
        return resultDo;
    }

    @RequestMapping("/findUserById")
    @ResponseBody
    @NoAuth
    public ResultDo<UserDto> findUserById(String id) {
        return userService.findUserById(id);
    }

    @RequestMapping("/findUser")
    @ResponseBody
    @NoAuth
    public ResultDo<Map<String, Object>> findUser(PageDto<UserDto> pageDto, UserDto userdto) {
        return userService.findUser(pageDto, userdto);
    }


    /* 增加用户信息 */
    @RequestMapping("/addUser")
    @ResponseBody
    @NoAuth
    public ResultDo<Map<String, Object>> addUser() {
        ResultDo<Map<String, Object>> resultDo = new ResultDo<Map<String, Object>>();
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            resultMap.put("userStateList", dictItemService.findByTypeCode("USER_STATE").getResultData());
            resultMap.put("userTypeList", dictItemService.findByTypeCode("USER_TYPE").getResultData());
            resultMap.put("sexList", dictItemService.findByTypeCode("SEX").getResultData());
            resultDo.setResultDo(InterfaceResult.SUCCESS);
            logger.info(InterfaceResult.SUCCESS.getValue());
        } catch (Exception e) {
            resultDo.setResultDo(UserResult.ADD_FAILURE);
            logger.error(UserResult.ADD_FAILURE.getValue(), e);
        }
        resultDo.setResultData(resultMap);
        return resultDo;
    }

    /* 重置密码,设为字典固定值 */
    @RequestMapping("/resetPwd")
    @ResponseBody
    @NoAuth
    public ResultDo<UserDto> resetPwd(UserDto userDto) {
        return userService.resetPwd(userDto);
    }

    /* 修改密码 */
    @RequestMapping("/pwdEdit")
    @ResponseBody
    @NoAuth
    public ResultDo<UserDto> pwdEdit(UserDto userDto, String formerPwd) {
        return userService.pwdEdit(userDto, formerPwd);
    }

    /* 重置联系方式,设为字典固定值 */
    @RequestMapping("/resetPhone")
    @ResponseBody
    @NoAuth
    public ResultDo<UserDto> resetPhone(@RequestParam(value = "id",required = true)String id,@RequestParam(value = "phone",required = true) String  phone) {
        return userService.resetPhone(id,phone);
    }

    @RequestMapping(value="/login",method= RequestMethod.GET)
    @NoAuth
    public String testForward(){
        return "login";
    }

}
