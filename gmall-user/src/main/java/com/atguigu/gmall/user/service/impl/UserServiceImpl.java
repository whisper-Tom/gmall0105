package com.atguigu.gmall.user.service.impl;

import com.atguigu.gmall.user.bean.UmsMember;
import com.atguigu.gmall.user.bean.UmsMemberReceiveAddress;
import com.atguigu.gmall.user.mapper.UmsMemberReceiveAddressMapper;
import com.atguigu.gmall.user.mapper.UserMapper;
import com.atguigu.gmall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UmsMemberReceiveAddressMapper umsMemberReceiveAddressMapper;

    @Override
    public List<UmsMember> getAllUser() {

        List<UmsMember> umsMemberList = userMapper.selectAll();//userMapper.selectAllUser();

        return umsMemberList;
    }

    @Override
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(@RequestParam String memberId) {

        // 封装的参数对象
        UmsMemberReceiveAddress umsMemberReceiveAddress = new UmsMemberReceiveAddress();
        umsMemberReceiveAddress.setMemberId(memberId);
        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses = umsMemberReceiveAddressMapper.select(umsMemberReceiveAddress);
        //1.以上是通过umsMemberReceiveAddress对象去查询数据，参数就封装在umsMemberReceiveAddress里
        //2.现在使用了通用mapper就不用去建xml文件写sql语句了
        return umsMemberReceiveAddresses;
    }

    @Override
    public int updateReceiveAddress(UmsMemberReceiveAddress umsMemberReceiveAddress) {
//        UmsMemberReceiveAddress UmsMemberReceiveAddress =  new UmsMemberReceiveAddress();
//        UmsMemberReceiveAddress.setId(id);
//        UmsMemberReceiveAddress.setName(name);
//        UmsMemberReceiveAddress.setPhoneNumber(phoneNumber);
//        UmsMemberReceiveAddress.setDefaultStatus(defaultStatus);
        int updateReceiveAddress = umsMemberReceiveAddressMapper.updateByPrimaryKey(umsMemberReceiveAddress);
        return updateReceiveAddress;
    }

    @Override
    public int insertReceiveAddress(UmsMemberReceiveAddress umsMemberReceiveAddresses) {
        int insertReceiveAddress = umsMemberReceiveAddressMapper.insert(umsMemberReceiveAddresses);
        return insertReceiveAddress;
    }

    @Override
    public int deleteReceiveAddress(UmsMemberReceiveAddress umsMemberReceiveAddresses) {
        int deleteReceiveAddress = umsMemberReceiveAddressMapper.deleteByPrimaryKey(umsMemberReceiveAddresses);
        return deleteReceiveAddress;
    }




}
