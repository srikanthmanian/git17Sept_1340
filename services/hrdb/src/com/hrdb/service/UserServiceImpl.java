package com.hrdb.service;
// Generated 7 Oct, 2014 3:41:50 PM

import com.wavemaker.runtime.data.expression.QueryFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrdb.*;
import com.wavemaker.runtime.data.dao.*;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;

/**
 * ServiceImpl object for domain model class User.
 * @see com.hrdb.User
 */
@Service("hrdb.UserService")
public class UserServiceImpl implements UserService {


    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);


@Autowired
@Qualifier("hrdb.UserDao")
private WMGenericDao<User, Integer> wmGenericDao;
  public void setWMGenericDao(WMGenericDao<User, Integer> wmGenericDao){
          this.wmGenericDao = wmGenericDao;
  }

    @Transactional(value = "hrdbTransactionManager")
    @Override
    public User create(User user) {
        LOGGER.debug("Creating a new user with information: {}" , user);
        return this.wmGenericDao.create(user);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "hrdbTransactionManager")
    @Override
    public User delete(Integer userId) throws EntityNotFoundException {
        LOGGER.debug("Deleting user with id: {}" , userId);
        User deleted = this.wmGenericDao.findById(userId);
        if (deleted == null) {
            LOGGER.debug("No user found with id: {}" , userId);
            throw new EntityNotFoundException(String.valueOf(userId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "hrdbTransactionManager")
    @Override
    public Page<User> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all users");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "hrdbTransactionManager")
    @Override
    public Page<User> findAll(Pageable pageable) {
        LOGGER.debug("Finding all users");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "hrdbTransactionManager")
    @Override
    public User findById(Integer id) throws EntityNotFoundException {
        LOGGER.debug("Finding user by id: {}" , id);
        User user=this.wmGenericDao.findById(id);
        if(user==null){
            LOGGER.debug("No user found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return user;
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "hrdbTransactionManager")
    @Override
    public User update(User updated) throws EntityNotFoundException {
        LOGGER.debug("Updating user with information: {}" , updated);
        this.wmGenericDao.update(updated);
        return this.wmGenericDao.findById((Integer)updated.getUserid());
    }

    @Transactional(readOnly = true, value = "hrdbTransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}


