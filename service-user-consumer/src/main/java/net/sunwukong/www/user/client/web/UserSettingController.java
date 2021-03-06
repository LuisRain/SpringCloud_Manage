package net.sunwukong.www.user.client.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.sunwukong.www.api.entity.RequestData;
import net.sunwukong.www.api.entity.ResponseData;
import net.sunwukong.www.user.bean.UserOtherLogin;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 说明:用户设置控制
 *
 * @author Mick
 * @CreateDate 2018/6/24 14:02
 * @Email ：ideacoding@163.com
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = "/v1/usersetting")
@Api(tags = "用户设置控制", description = "")
public class UserSettingController extends BaseController {

    @RequestMapping(value="/bindaccount",produces= MediaType.APPLICATION_JSON_UTF8_VALUE,method = RequestMethod.POST)
    @ApiOperation(value = "绑定账号", httpMethod = "POST", notes = "绑定账号",response = ResponseData.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID",paramType = "query"),
            @ApiImplicitParam(name = "account", value = "账户号",paramType = "query"),
            @ApiImplicitParam(name = "accountType", value = "账号类型(账户类型 1手机号 2邮箱)",paramType = "query"),
            @ApiImplicitParam(name = "code", value = "验证码",paramType = "query"),
    })
    public ResponseData bindAccount(@RequestBody(required = false) RequestData<Map<String,String>> requestData){
        return userSettingService.bindAccount(requestData);
    }

    @RequestMapping(value="/removebindaccount",produces= MediaType.APPLICATION_JSON_UTF8_VALUE,method = RequestMethod.POST)
    @ApiOperation(value = "解除绑定账号", httpMethod = "POST", notes = "解除绑定账号",response = ResponseData.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID",paramType = "query"),
            @ApiImplicitParam(name = "accountType", value = "账号类型(账户类型 1手机号 2邮箱)",paramType = "query"),
    })
    public ResponseData removeBindAccount(@RequestBody(required = false) RequestData<Map<String,String>> requestData){
        return userSettingService.removeBindAccount(requestData);
    }

    @RequestMapping(value="/bindotherlogin",produces= MediaType.APPLICATION_JSON_UTF8_VALUE,method = RequestMethod.POST)
    @ApiOperation(value = "设置第三方绑定", httpMethod = "POST", notes = "绑定账号",response = ResponseData.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userNo", value = "用户编码",paramType = "query"),
            @ApiImplicitParam(name = "otherAppType", value = "第三方类型(微信:10320001 QQ:10320002 微博:10320003)",paramType = "query"),
            @ApiImplicitParam(name = "otherAppId", value = "第三方登录应用ID号",paramType = "query"),
    })
    public ResponseData bindOtherLogin(@RequestBody(required = false) RequestData<UserOtherLogin> requestData){
        return userSettingService.bindOtherLogin(requestData);
    }

    @RequestMapping(value="/removeotherlogin",produces= MediaType.APPLICATION_JSON_UTF8_VALUE,method = RequestMethod.POST)
    @ApiOperation(value = "解除第三方绑定", httpMethod = "POST", notes = "绑定账号",response = ResponseData.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "第三方绑定ID",paramType = "query"),
    })
    public ResponseData removeOtherLogin(@RequestBody(required = false) RequestData<Map<String,String>> requestData){
        return userSettingService.removeOtherLogin(requestData);
    }
}
