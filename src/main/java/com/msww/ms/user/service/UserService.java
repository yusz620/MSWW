package com.msww.ms.user.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.msww.ms.user.model.SysUser;
import com.msww.ms.user.repository.UserRepository;


@Service
// public class UserService implements UserDetailsService {
public class UserService {
    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserRepository userRepository;

    // @Override
    // public UserDetails loadUserByUsername(String username) { // 閲嶅啓loadUserByUsername 鏂规硶鑾峰緱 userdetails 绫诲瀷鐢ㄦ埛
    //
    // SysUser user = userRepository.findByUserName(username);
    // if (user == null) {
    // throw new UsernameNotFoundException("鐢ㄦ埛鍚嶄笉瀛樺湪");
    // }
    // List<SimpleGrantedAuthority> authorities = new ArrayList<>();
    // // 鐢ㄤ簬娣诲姞鐢ㄦ埛鐨勬潈闄愩�傚彧瑕佹妸鐢ㄦ埛鏉冮檺娣诲姞鍒癮uthorities 灏变竾浜嬪ぇ鍚夈��
    // for (UserRole role : user.getRoles()) {
    // authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
    // System.out.println(role.getRoleName());
    // }
    // return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), authorities);
    // }

    @Transactional(propagation = Propagation.SUPPORTS)
    public Iterable<SysUser> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public Iterable<SysUser> getAllByUserId(List<String> userIdList) {
        return userRepository.findAllById(userIdList);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public SysUser save(SysUser sysUser) {
        return userRepository.save(sysUser);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Iterable<SysUser> saveAll(List<SysUser> userBeanList) {
        return userRepository.saveAll(userBeanList);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(SysUser sysUser) {
        userRepository.delete(sysUser);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteAll(List<SysUser> userBeanList) {
        userRepository.deleteAll(userBeanList);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteAll() {
        userRepository.deleteAll();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteById(String userId) {
        userRepository.deleteById(userId);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public Optional<SysUser> findById(String userId) {
        return userRepository.findById(userId);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public boolean existsById(String userId) {
        return userRepository.existsById(userId);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public Iterable<SysUser> findAllById(List<String> userIdList) {
        return userRepository.findAllById(userIdList);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public Long count() {
        return userRepository.count();
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public SysUser findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public SysUser findByUserNameAndPassord(String userName, String password) {
        return userRepository.findByUserNameAndPassword(userName, password);
    }

}
