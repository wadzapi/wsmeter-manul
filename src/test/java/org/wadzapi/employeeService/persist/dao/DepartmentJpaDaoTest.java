package org.wadzapi.employeeService.persist.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.wadzapi.employeeService.persist.orm.DepartmentOrm;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Юнит-тесты методов класса {@link DepartmentJpaDao}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@TransactionConfiguration
@Transactional
public class DepartmentJpaDaoTest {

    /*
        TODO Доработать тесты DAO
        TODO Поправить типы данных на VARCHAR и убрать trim
     */

    /**
     * Тестовый экземпляр DAO для работы с сущностью "Департамент"
     */
    @Autowired
    private DepartmentJpaDao departmentJpaDao;

    /**
     * Юнит-тест для метода {@link DepartmentJpaDao#findOne(long)}
     *
     * @throws Exception ошибка теста
     */
    @Test
    public void testFindOne() throws Exception {
        DepartmentOrm departmentOrm = departmentJpaDao.findOne(300L);
        assertNotNull(departmentOrm);
        assertEquals(300L, departmentOrm.getId());
        assertEquals("IT", departmentOrm.getName().trim());
    }

    /**
     * Юнит-тест для метода {@link DepartmentJpaDao#findAll()}
     *
     * @throws Exception ошибка теста
     */
    @Test
    public void testFindAll() throws Exception {
        List<DepartmentOrm> departmentOrmList = departmentJpaDao.findAll();
        assertNotNull(departmentOrmList);
        assertEquals(2, departmentOrmList.size());
    }
}