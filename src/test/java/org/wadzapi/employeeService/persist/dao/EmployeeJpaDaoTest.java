package org.wadzapi.employeeService.persist.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.wadzapi.employeeService.persist.orm.DepartmentOrm;
import org.wadzapi.employeeService.persist.orm.EmployeeOrm;

import java.math.BigInteger;
import java.sql.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Юнит-тест методов класса {@link EmployeeJpaDao}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@TransactionConfiguration
@Transactional
public class EmployeeJpaDaoTest {

    /*
        TODO Доработать тесты DAO
        TODO Поправить типы данных на VARCHAR и убрать trim
     */
    /**
     * Тестовый экземпляр DAO для работы с сущностью "Работник"
     */
    @Autowired
    private EmployeeJpaDao employeeJpaDao;

    /**
     * Юнит-тест для метода {@link EmployeeJpaDao#findOne(long)}
     *
     * @throws Exception ошибка теста
     */
    @Test
    @SuppressWarnings("deprecation")
    public void testFindOne() throws Exception {
        EmployeeOrm employeeOrm = employeeJpaDao.findOne(1L);
        assertNotNull(employeeOrm);
        assertEquals("Кирилл Петрович", employeeOrm.getFirstName().trim());
        assertEquals("Шниперсон", employeeOrm.getLastName());
        assertEquals("snippersonchik_a@test", employeeOrm.getEmail());
        assertNull(employeeOrm.getPhone());
        assertEquals(new Date(116, 0, 2), employeeOrm.getHireDate());
        assertEquals(BigInteger.valueOf(1), employeeOrm.getSalary());
        assertEquals(0, employeeOrm.getManagerId());
        DepartmentOrm departmentOrm = employeeOrm.getDepartment();
        assertNotNull(departmentOrm);
        assertEquals(300, departmentOrm.getId());
        assertEquals("IT", departmentOrm.getName().trim());
    }

    /**
     * Юнит-тест для метода {@link EmployeeJpaDao#findAll()}
     *
     * @throws Exception ошибка теста
     */
    @Test
    public void testFindAll() throws Exception {
        List<EmployeeOrm> employeeOrmList = employeeJpaDao.findAll();
        assertNotNull(employeeOrmList);
        assertEquals(5, employeeOrmList.size());
        /*employeeOrmList.stream().forEach(employee -> assertNotNull(employee.getDepartment()));
        employeeOrmList.stream().forEach(employee -> assertEquals(300, employee.getDepartment().getId()));
        employeeOrmList.stream().forEach(employee -> assertEquals("IT", employee.getDepartment().getName().trim()));*/
    }
}