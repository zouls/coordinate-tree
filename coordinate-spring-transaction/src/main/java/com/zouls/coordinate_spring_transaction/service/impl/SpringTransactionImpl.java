package com.zouls.coordinate_spring_transaction.service.impl;

import com.zouls.coordinate_spring_transaction.dao.ExtraAdDao;
import com.zouls.coordinate_spring_transaction.entity.ExtraAd;
import com.zouls.coordinate_spring_transaction.exception.CustomException;
import com.zouls.coordinate_spring_transaction.service.ISpringTransaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class SpringTransactionImpl implements ISpringTransaction {

    /**
     * ExtraAd Dao
     */
    private final ExtraAdDao extraAdDao;

    @Autowired
    public SpringTransactionImpl(ExtraAdDao extraAdDao) {
        this.extraAdDao = extraAdDao;
    }

    /**
     * <h2>捕捉异常, 导致不能回滚</h2>
     */
    @Override
    @Transactional
    public void CatchExceptionCanNotRollback() {

        try {
            extraAdDao.save(new ExtraAd("qinyi"));
            throw new RuntimeException();
        } catch (Exception ex) {
            ex.printStackTrace();
            // 手动标记回滚,在捕获异常之后再手动将事务设置为回滚
            // 不建议这样做,会把spring处理事务的代码侵入到我们自己的代码中,代码形成耦合
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }

    /**
     * <h2>捕捉异常并转换异常, 导致不能回滚</h2>
     */
    @Override
    @Transactional
    public void NotRuntimeExceptionCanNotRollback() throws CustomException {

        try {
            extraAdDao.save(new ExtraAd("qinyi"));
            throw new RuntimeException();
        } catch (Exception ex) {
            throw new CustomException(ex.getMessage());
        }
    }

    /**
     * <h2>RuntimeException 异常可以回滚</h2>
     */
    @Override
    @Transactional
    public void RuntimeExceptionCanRollback() {

        extraAdDao.save(new ExtraAd("qinyi"));
        throw new RuntimeException();
    }

    /**
     * <h2>指定异常, 可以回滚</h2>
     */
    @Override
    @Transactional(rollbackFor = {CustomException.class})
    public void AssignExceptionCanRollback() throws CustomException {

        try {
            extraAdDao.save(new ExtraAd("qinyi"));
            throw new RuntimeException();
        } catch (Exception ex) {
            throw new CustomException(ex.getMessage());
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * <h2>在 private 方法上标注 transactional, 事务无效</h2>
     */
    @Transactional
    public void oneSaveMethod() {

        extraAdDao.save(new ExtraAd("qinyi"));
    }

    /**
     * <h2>Rollback Only</h2>
     * org.springframework.transaction.UnexpectedRollbackException:
     * Transaction silently rolled back because it has been marked as rollback-only
     */
    @Override
    @Transactional
    public void RollbackOnlyCanRollback() throws Exception {

        // 这个方法上有事务
        oneSaveMethod();

        // 如果多个方法上都有对应的事务,spring默认会将事务进行合并
        // 当所有的方法执行完才会进行提交,如果有一个方法执行失败,spring会将事务标记为rollbackOnly
        // 如果这些子方法没有将异常进行抛出,异常就不会触发事务进行回滚,事务就会在整个方法执行完进行提交
        try {
            extraAdDao.save(new ExtraAd());//这行代码会抛出异常,name在数据库中是not null的
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;//这里需要主动抛出,不然spring处理会失败
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * <h2>在private方法上标注transactional, 事务无效</h2>
     */
    @Transactional
    public void anotherOneSaveMethod() {

        extraAdDao.save(new ExtraAd("qinyi"));
        throw new RuntimeException();
    }

    /**
     * <h2>同一个类中, 一个不标注事务的方法去调用 transactional 的方法, 事务会失效</h2>
     */
    @Override
//    @Transactional
    public void NonTransactionalCanNotRollback() {

        anotherOneSaveMethod();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
