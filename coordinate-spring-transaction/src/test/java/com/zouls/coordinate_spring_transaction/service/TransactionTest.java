package com.zouls.coordinate_spring_transaction.service;

import com.zouls.coordinate_spring_transaction.CoordinateSpringTransactionApplicationTests;
import com.zouls.coordinate_spring_transaction.exception.CustomException;
import com.zouls.coordinate_spring_transaction.service.impl.AnotherSpringTransaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <h1>事务回滚测试类</h1>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CoordinateSpringTransactionApplicationTests.class}, webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class TransactionTest {

    @Autowired
    private ISpringTransaction springTransaction;

    @Autowired
    private AnotherSpringTransaction anotherSpringTransaction;

    @Test
    public void testCatchExceptionCanNotRollback() {

        springTransaction.CatchExceptionCanNotRollback();
    }

    @Test
    public void testNotRuntimeExceptionCanNotRollback() throws CustomException {

        springTransaction.NotRuntimeExceptionCanNotRollback();
    }

    @Test
    public void testRuntimeExceptionCanRollback() {

        springTransaction.RuntimeExceptionCanRollback();
    }

    @Test
    public void testAssignExceptionCanRollback() throws CustomException {

        springTransaction.AssignExceptionCanRollback();
    }

    @Test
    public void testRollbackOnlyCanRollback() throws Exception {

        springTransaction.RollbackOnlyCanRollback();
    }

    @Test
    public void testNonTransactionalCanNotRollback() {

        springTransaction.NonTransactionalCanNotRollback();
    }

    @Test
    public void testTransactionalCanRollback() {

        anotherSpringTransaction.TransactionalCanRollback();
    }
}
