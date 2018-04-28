package com.whis.app.controller;

import com.whis.base.common.DataResponse;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;


@RestController("Swagger2Controller")
@RequestMapping("/swagger")
@Controller
public class Swagger2Controller {

    @ApiOperation(value = "获取用户详细信息", notes = "根据用户id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "path")
    @RequestMapping(value = "/user/info", method = RequestMethod.GET)
    public DataResponse getUserById(@RequestParam("id") Long id) {

        return DataResponse.create();
    }

    @ApiIgnore // 使用该注解忽略这个API
    @RequestMapping("/test")
    public DataResponse test() {
        return DataResponse.create().put("test", "test");
    }
}
