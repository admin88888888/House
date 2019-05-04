package com.ddhouse.house.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ddhouse.house.entity.FUser;
import com.ddhouse.house.mapper.FUserMapper;
import com.ddhouse.house.service.CodeService;
import com.ddhouse.house.service.FUserService;
import com.ddhouse.house.utils.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cyx
 * @since 2019-04-27
 */
@Service
public class FUserServiceImpl extends ServiceImpl<FUserMapper, FUser> implements FUserService {

    @Autowired
    private FUserMapper userMapper;

    @Autowired
    private CodeService codeService;
    @Override
    public void Register(String phone, String usernumber, String password) {

        if (!phone.matches("^[1][3,4,5,7,8][0-9]{9}$")) {
            throw new RuntimeException("手机号格式不正确");
        }

        QueryWrapper<FUser> queryWrapper=new QueryWrapper<>();
        queryWrapper.like("phone",phone);
        FUser user = userMapper.selectOne(queryWrapper);
        if(user != null){
            throw new RuntimeException("该手机号已注册");
        }

        QueryWrapper<FUser> queryWrapper2=new QueryWrapper<>();
        queryWrapper2.like("usernumber", usernumber);
        FUser user2 = userMapper.selectOne(queryWrapper2);
        if (user2 != null){
            throw new RuntimeException("该用户名已存在");
        }

        FUser fUser = new FUser();
        fUser.setPassword(password);
        fUser.setUsernumber(usernumber);
        fUser.setPhone(phone);
        fUser.setName("柚家客"+ RandomString.getRandomString(9));
        QueryWrapper<FUser> queryWrapper3=new QueryWrapper<>();
        queryWrapper3.like("name", fUser.getName());
        FUser user3 = userMapper.selectOne(queryWrapper2);
        if(user3 != null){
            fUser.setName("柚家客"+ RandomString.getRandomString(9));
        }
        userMapper.insert(fUser);

    }

    @Override
    public void Login(String usernumber, String password) {
        QueryWrapper<FUser> queryWrapper=new QueryWrapper<>();
        queryWrapper.like("usernumber", usernumber);
        FUser fUser = userMapper.selectOne(queryWrapper);

        if(fUser == null){
            QueryWrapper<FUser> queryWrapper2=new QueryWrapper<>();
            queryWrapper2.like("phone", usernumber);
            FUser fUser2 = userMapper.selectOne(queryWrapper2);

            if(fUser2 == null){
                QueryWrapper<FUser> queryWrapper3=new QueryWrapper<>();
                queryWrapper3.like("email", usernumber);
                FUser fUser3 = userMapper.selectOne(queryWrapper3);

                if(fUser3 == null){
                    throw new RuntimeException("用户名错误");
                } else {

                    if(!fUser3.getPassword().equals(password)){
                        throw new RuntimeException("密码错误");
                    }
                }
            } else{
                if(!fUser2.getPassword().equals(password)){
                    throw new RuntimeException("密码错误");
                }
            }

        }else {
            if(!fUser.getPassword().equals(password)){
                throw new RuntimeException("密码错误");
            }
        }


    }

    @Override
    public void updatePassword(String phone,String code ,String password,int id) {

        if(!codeService.checkCode(phone,code)){

            throw new RuntimeException("验证码不正确");
        }
        QueryWrapper<FUser> queryWrapper1 = new QueryWrapper();
        queryWrapper1.like("id", id);
        FUser fUser1 = userMapper.selectOne(queryWrapper1);
        if (!phone.equals(fUser1.getPhone())) {
            throw new RuntimeException("手机号不正确");
        }
        QueryWrapper<FUser> queryWrapper = new QueryWrapper();
        queryWrapper.like("password", password);

        QueryWrapper<FUser> queryWrapper2 = new QueryWrapper();
        queryWrapper.like("id", password);
        FUser fUser = userMapper.selectOne(queryWrapper2);
        userMapper.update(fUser,queryWrapper);
    }


}
