package com.roy.service.Impl;

import com.roy.config.UserCredentialsMatcher;
import com.roy.entity.Menu;
import com.roy.entity.User;
import com.roy.mapper.MenuMapper;
import com.roy.service.MenuService;
import com.roy.service.SaasService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class MenuServiceImpl extends SaasService implements MenuService  {
    @Resource
    private MenuMapper menuMapper;

    @Override
    public User loginname(String loginname) {
        return menuMapper.loginname(loginname);
    }

    @Override
    public User loginname(String loginname,String pwd) {
        User user = menuMapper.loginname(loginname);
        //不存在用户，返回null。存在用户但是密码错误，返回userid=-1。全都正确，返回user
        if(null != user && !UserCredentialsMatcher.isPasswordMatch(pwd,user.getSalt(),user.getPwd())){
            user.setUserid(-1);
        }
        return user;
    }

    @Override
    public List<Menu> queryMenuByUid(Integer userid) {
        return menuMapper.queryMenuByUid(userid);
    }

    @Override
    public List<Menu> loadAvailableMenu() {
        return menuMapper.loadAvailableMenu();
    }

    @Override
    public List<Menu> selAllMenuByUser(Integer userId) {
        return menuMapper.selAllMenuByUser(userId);
    }

    @Override
    public List<Menu> queryMenuAllList(Menu menu) {
        return menuMapper.queryMenuAllList(menu);
    }

    @Override
    public int addMenu(Menu menu) {
        return menuMapper.addMenu(menu);
    }

    @Override
    public int deleteMenu(Integer id) {
        return menuMapper.deleteMenu(id);
    }

    @Override
    public int checkMenuHasChildren(Integer pid) {
        return menuMapper.checkMenuHasChildren(pid);
    }

    @Override
    public int updateMenu(Menu menu) {
        return menuMapper.updateMenu(menu);
    }
}
