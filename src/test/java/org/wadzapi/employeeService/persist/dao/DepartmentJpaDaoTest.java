package org.wadzapi.employeeService.persist.dao;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.wadzapi.employeeService.persist.orm.DepartmentOrm;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Юнит-тесты методов класса {@link DepartmentJpaDao}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@TransactionConfiguration
@Transactional
public class DepartmentJpaDaoTest {

    /**
     * Эталонный список департаментов, загруженных из тестовой БД
     */
    private static List<DepartmentOrm> referenceDepartmentOrmList;

    /**
     * Тестовый экземпляр DAO для работы с сущностью "Департамент"
     */
    @Autowired
    private DepartmentJpaDao departmentJpaDao;

    @BeforeClass
    public static void setUpClass() {
        List<DepartmentOrm> initDepartmentOrmList = new ArrayList<>();
        DepartmentOrm.DepartmentOrmBuilder departmentOrmBuilder = new DepartmentOrm.DepartmentOrmBuilder();
        initDepartmentOrmList.add(departmentOrmBuilder.setId(280L).setName("IT").build());
        initDepartmentOrmList.add(departmentOrmBuilder.setId(290L).setName("Sales").build());
        referenceDepartmentOrmList = initDepartmentOrmList;
    }

    /**
     * Юнит-тест для метода {@link DepartmentJpaDao#findOne(long)}
     *
     * @throws Exception ошибка теста
     */
    @Test
    public void testFindOne() throws Exception {
        //IT
        DepartmentOrm departmentOrm = departmentJpaDao.findOne(280L);
        assertNotNull(departmentOrm);
        assertEquals(280L, departmentOrm.getId());
        assertEquals("IT", departmentOrm.getName());
        //Sales
        departmentOrm = departmentJpaDao.findOne(290L);
        assertNotNull(departmentOrm);
        assertEquals(290L, departmentOrm.getId());
        assertEquals("Sales", departmentOrm.getName());
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
        assertTrue(EqualsBuilder.reflectionEquals(referenceDepartmentOrmList, departmentOrmList));
    }
}