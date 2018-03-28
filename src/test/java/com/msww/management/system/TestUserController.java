package com.msww.management.system;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.msww.ms.user.model.SysUser;
import com.msww.ms.user.service.UserService;
import com.msww.ms.utils.EncodeUtils;

import junit.framework.Assert;
import net.minidev.json.JSONObject;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserController extends MswwApplicationTests {
    // @Autowired
    private UserService userService;
    // private UserRepository userRepository;
    private MockMvc mvc;
    // @Autowired
    // private WebApplicationContext wac; // 娉ㄥ叆WebApplicationContext

    // @Test
    public void testGetAllUsers() {
        Iterable<SysUser> users = userService.getAllUsers();
        Assert.assertNotNull(users);
    }

    // @Before
    // public void setUp() {
    // currentUser = new SysUser();
    // userService = new UserService();
    // // userRepository = new UserRepository();
    // // this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    // }
    //
    // @Test
    public void testUserDaoRegisterUser() throws Exception {
        SysUser currentUser = new SysUser();
        currentUser.setAddress("涓囩榄呭姏");
        currentUser.setCreateBy("andy");
        currentUser.setCreateTime(new Date());
        currentUser.setAbled(true);
        currentUser.setActive(true);
        currentUser.setLastLogin(new Date());
        currentUser.setModifyBy("root");
        currentUser.setModifyTime(new Date());
        currentUser.setPassword(EncodeUtils.md5Encode("asdf1234"));
        currentUser.setRealName("andy");
        currentUser.setRoleId(UUID.randomUUID().toString().replaceAll("-", ""));
        currentUser.setRoleName("admin");
        currentUser.setTelPhone("17762545590");
        currentUser.setUserId(UUID.randomUUID().toString().replaceAll("-", ""));
        currentUser.setUserName("andy");
        currentUser.setUserType("1");
        Map<String, Object> map = new HashMap<>();
        map.put("currentUser", currentUser);

        MvcResult result =
                mvc.perform(post("/adduser").contentType(MediaType.APPLICATION_JSON).content(JSONObject.toJSONString(map))).andExpect(status().isOk())//
                        // 妯℃嫙鍚憈estRest鍙戦�乬et璇锋眰
                        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))// 棰勬湡杩斿洖鍊肩殑濯掍綋绫诲瀷text/plain;charset=UTF-8
                        .andReturn();

        SysUser registerUser = userService.save(currentUser);
        System.out.println(registerUser);
    }

    // @Test
    public void testUserLogin() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/login")).andExpect(MockMvcResultMatchers.status().isOk());
    }
}
