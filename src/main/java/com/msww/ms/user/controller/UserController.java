package com.msww.ms.user.controller;

import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session.Cookie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.msww.ms.user.exception.UerExceptionResult;
import com.msww.ms.user.exception.UserException;
import com.msww.ms.user.mockdata.MockUserData;
import com.msww.ms.user.model.MswwResult;
import com.msww.ms.user.model.SysUser;
import com.msww.ms.user.service.UserService;
import com.msww.ms.utils.EncodeUtils;
import com.msww.ms.utils.MswwResultUtil;

@Controller
@RequestMapping(value = "/")
public class UserController extends HttpController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private SysUser currentUser;
    private Cookie cookie;


    @GetMapping("/")
    public String userController(Model model) {
        model.addAttribute("name", "Hello msww");
        return "login";

    }

    @GetMapping("/index")
    public String index(Model model) {
        return "index";

    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("top", "top.html");
        // model.addAttribute("left", "left.html");
        // model.addAttribute("main", "main.html");
        // model.addAttribute("footer", "footer");
        // model.addAttribute("index", "index");
        model.addAttribute("currentUser", currentUser);
        return "home";

    }

    @GetMapping("/user")
    @ResponseBody
    public Iterable<SysUser> getAllUsers(Model model) {
        model.addAttribute("name", "Hello Dsfa");
        return userService.getAllUsers();
    }

    @PostMapping("/adduser")
    public SysUser addUser(SysUser sysUser) {
        log.debug("/adduser");
        sysUser = MockUserData.mockUser();
        if (!sysUser.getUserName().equals(userService.findByUserName(sysUser.getUserName()))) {
            sysUser = userService.save(sysUser);
        }
        return sysUser;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(SysUser sysUser) {
        try {
            sysUser = userService.findByUserNameAndPassord(sysUser.getUserName(), EncodeUtils.md5Encode(sysUser.getPassword()));
            if (sysUser == null) {
                throw new UserException(UerExceptionResult.USERNAME_NOT_EXIST.getCode(), UerExceptionResult.USERNAME_NOT_EXIST.getMessage());
                // return "login";
            } else {
                currentUser = sysUser;
                httpSession.setAttribute("currentUser", currentUser);
                sysUser.setLastLogin(new Date());
                userService.save(sysUser);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
        // userBean = MockUserData.mockUser();
        return "redirect:home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";

    }

    @RequestMapping("/logout")
    public String logout(Model model) {
        currentUser = null;
        model.addAttribute("currentUser", null);
        httpSession.setAttribute("currentUser", null);
        return "redirect:/login";

    }


    @RequestMapping(value = "/userName", method = RequestMethod.POST)
    @ResponseBody
    public MswwResult userName(SysUser sysUser) {
        sysUser = userService.findByUserName(sysUser.getUserName());
        if (sysUser == null) {
            return MswwResultUtil.error(UerExceptionResult.USERNAME_ALREADY_EXIST.getCode(), UerExceptionResult.USERNAME_ALREADY_EXIST.getMessage());
        }
        return MswwResultUtil.success(sysUser);
    }

    @RequestMapping(value = "/password", method = RequestMethod.POST)
    @ResponseBody
    public boolean password(SysUser sysUser) {
        try {
            sysUser = userService.findByUserNameAndPassord(sysUser.getUserName(), EncodeUtils.md5Encode(sysUser.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
        return sysUser == null ? false : true;
    }

    @RequestMapping(value = "/register")
    public String register(SysUser sysUser) {
        if (request.getMethod().equals(RequestMethod.GET.toString())) {

        } else {
            sysUser.setAbled(true);
            sysUser.setActive(true);
            sysUser.setAddress("武汉");
            sysUser.setCreateBy("root");
            sysUser.setCreateTime(new Date());
            sysUser.setLastLogin(new Date());
            sysUser.setModifyBy("root");
            sysUser.setModifyTime(new Date());
            try {
                sysUser.setPassword(EncodeUtils.md5Encode(sysUser.getPassword()));
            } catch (Exception e) {
                log.debug(e.getMessage());
            }
            sysUser.setRealName("root");
            sysUser.setRoleId(UUID.randomUUID().toString().replaceAll("-", ""));
            sysUser.setRoleName("admin");
            sysUser.setTelPhone("12345678");
            sysUser.setUserId(UUID.randomUUID().toString().replaceAll("-", ""));
            sysUser.setUserType("test");
            sysUser = userService.save(sysUser);
            currentUser = sysUser;
            return "redirect:/home";
        }

        return "register";
    }


    public SysUser getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(SysUser currentUser) {
        this.currentUser = currentUser;
    }

    public Cookie getCookie() {
        return cookie;
    }

    public void setCookie(Cookie cookie) {
        this.cookie = cookie;
    }

}
