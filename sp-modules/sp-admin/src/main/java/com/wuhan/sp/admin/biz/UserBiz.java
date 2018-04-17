package com.wuhan.sp.admin.biz;

import com.ace.cache.annotation.Cache;
import com.ace.cache.annotation.CacheClear;
import com.wuhan.sp.admin.entity.User;
import com.wuhan.sp.admin.mapper.MenuMapper;
import com.wuhan.sp.admin.mapper.UserMapper;
import com.wuhan.sp.common.biz.BaseBiz;
import com.wuhan.sp.common.constant.UserConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ${DESCRIPTION}
 *
 * @author admin
 * @create 2018-03
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserBiz extends BaseBiz<UserMapper,User> {

    @Autowired
    private MenuMapper menuMapper;
    @Override
    public void insertSelective(User entity) {
        String password = new BCryptPasswordEncoder(UserConstant.PW_ENCORDER_SALT).encode(entity.getPassword());
        entity.setPassword(password);
        super.insertSelective(entity);
    }

    @Override
    @CacheClear(pre="user{1.usercode}")
    public void updateSelectiveById(User entity) {
        super.updateSelectiveById(entity);
    }

    /**
     * 根据用户名获取用户信息
     * @param usercode
     * @return
     */
  //  @Cache(key="user{1}")
    public User getUserByUsercode(String usercode){
        User user = new User();
        user.setUsercode(usercode);
        return mapper.selectOne(user);
    }


}
