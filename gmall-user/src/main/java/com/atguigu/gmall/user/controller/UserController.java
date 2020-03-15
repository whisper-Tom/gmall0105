package com.atguigu.gmall.user.controller;

import com.atguigu.gmall.user.bean.UmsMember;
import com.atguigu.gmall.user.bean.UmsMemberReceiveAddress;
import com.atguigu.gmall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("getReceiveAddressByMemberId")
    @ResponseBody
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId( String memberId){
        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses = userService.getReceiveAddressByMemberId(memberId);
        return umsMemberReceiveAddresses;
    }

    @RequestMapping("update")
    @ResponseBody
    public int updateReceiveAddressByMemberId(UmsMemberReceiveAddress umsMemberReceiveAddresses){
        int updatecount = userService.updateReceiveAddress(umsMemberReceiveAddresses);
        return updatecount;
    }

    @RequestMapping("delete")
    @ResponseBody
    public int deleteReceiveAddressByMemberId(UmsMemberReceiveAddress umsMemberReceiveAddresses){
        int deletecount = userService.deleteReceiveAddress(umsMemberReceiveAddresses);
        return deletecount;
    }

    @RequestMapping("insert")
    @ResponseBody
    public int insertReceiveAddressByMemberId(UmsMemberReceiveAddress umsMemberReceiveAddresses){
        //insert?id=3&memberId=2&name=大梨&phoneNumber=18033441849&defaultStatus=2&postCode=518000&province=广东省&city=深圳市&region=南山区&detailAddress=南华街道
        int insertcount = userService.insertReceiveAddress(umsMemberReceiveAddresses);
        return insertcount;
    }



    @RequestMapping("getAllUser")
    @ResponseBody
    public List<UmsMember> getAllUser(){
        List<UmsMember> umsMembers = userService.getAllUser();
        return umsMembers;
    }

    @RequestMapping("index")
    @ResponseBody
    public String index(){
        return "hello user";
    }



}
