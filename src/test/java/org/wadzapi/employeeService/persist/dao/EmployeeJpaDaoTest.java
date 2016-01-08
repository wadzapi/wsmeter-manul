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
import org.wadzapi.employeeService.persist.orm.EmployeeOrm;

import java.math.BigInteger;
import java.sql.Date;
import java.util.ArrayList;
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
     */
    /**
     * Эталонный список работников,загружаемый из тестовой БД
     */
    private static List<EmployeeOrm> referenceEmployeeOrmList;
    /**
     * Тестовый экземпляр DAO для работы с сущностью "Работник"
     */
    @Autowired
    private EmployeeJpaDao employeeJpaDao;

    @BeforeClass
    @SuppressWarnings("deprecation")
    public static void setUpClass() {
        List<EmployeeOrm> initEmployeeOrmList = new ArrayList<>();
        EmployeeOrm.EmployeeOrmBuilder employeeOrmBuilder = new EmployeeOrm.EmployeeOrmBuilder();
        DepartmentOrm.DepartmentOrmBuilder departmentOrmBuilder = new DepartmentOrm.DepartmentOrmBuilder();
        initEmployeeOrmList.add(employeeOrmBuilder.setId(0).setFirstName("Ирина Николаевна").setLastName("Василькова")
                .setEmail("vasilkova@test").setPhone("+3(423)332-31-12").setHireDate(new Date(116, 0, 8)).setJobId(0)
                .setSalary(BigInteger.ONE).setCommisionPct(0.23).setManagerId(0).setDepartment(departmentOrmBuilder.setId(290L)
                        .setName("Sales").build()).build());
        initEmployeeOrmList.add(employeeOrmBuilder.setId(1).setFirstName("Кирилл Петрович").setLastName("Шниперсон")
                .setEmail("snippersonchik_a@test").setPhone("+3(423)332-31-12").setHireDate(new Date(116, 0, 8)).setJobId(0)
                .setSalary(BigInteger.ONE).setCommisionPct(0.23).setManagerId(0).setDepartment(departmentOrmBuilder.setId(280L)
                        .setName("IT").build()).build());
        initEmployeeOrmList.add(employeeOrmBuilder.setId(2).setFirstName("Валентина").setLastName("Касикова")
                .setEmail("kasilkiva@test").setPhone("+3(423)332-31-13").setHireDate(new Date(116, 0, 8)).setJobId(0)
                .setSalary(BigInteger.ONE).setCommisionPct(0.23).setManagerId(0).setDepartment(departmentOrmBuilder.setId(280L)
                        .setName("IT").build()).build());
        initEmployeeOrmList.add(employeeOrmBuilder.setId(3).setFirstName("Оксана").setLastName("Продавшкина")
                .setEmail("prodovashkina@test").setPhone("+3(423)332-33-33").setHireDate(new Date(116, 0, 8)).setJobId(0)
                .setSalary(BigInteger.ONE).setCommisionPct(0.23).setManagerId(0).setDepartment(departmentOrmBuilder.setId(290L)
                        .setName("Sales").build()).build());
        initEmployeeOrmList.add(employeeOrmBuilder.setId(4).setFirstName("Максим").setLastName("Шубин")
                .setEmail("shubin@test").setPhone("+3(423)332-44-44").setHireDate(new Date(116, 0, 8)).setJobId(0)
                .setSalary(BigInteger.ONE).setCommisionPct(0.23).setManagerId(0).setDepartment(departmentOrmBuilder.setId(280L)
                        .setName("IT").build()).build());
        referenceEmployeeOrmList = initEmployeeOrmList;
    }

    /**
     * Юнит-тест для метода {@link EmployeeJpaDao#findOne(long)}
     *
     * @throws Exception ошибка теста
     */
    @Test
    @SuppressWarnings("deprecation")
    public void testFindOne() throws Exception {
        //IT
        EmployeeOrm employeeOrm = employeeJpaDao.findOne(1L);
        assertNotNull(employeeOrm);
        assertEquals("Кирилл Петрович", employeeOrm.getFirstName());
        assertEquals("Шниперсон", employeeOrm.getLastName());
        assertEquals("snippersonchik_a@test", employeeOrm.getEmail());
        assertEquals("+3(423)332-31-12", employeeOrm.getPhone());
        assertEquals(new Date(116, 0, 8), employeeOrm.getHireDate());
        assertEquals(BigInteger.valueOf(1), employeeOrm.getSalary());
        assertEquals(0, employeeOrm.getManagerId());
        DepartmentOrm departmentOrm = employeeOrm.getDepartment();
        assertNotNull(departmentOrm);
        assertEquals(280, departmentOrm.getId());
        assertEquals("IT", departmentOrm.getName());
        //Sales
        employeeOrm = employeeJpaDao.findOne(0L);
        assertNotNull(employeeOrm);
        assertEquals("Ирина Николаевна", employeeOrm.getFirstName());
        assertEquals("Василькова", employeeOrm.getLastName());
        assertEquals("vasilkova@test", employeeOrm.getEmail());
        assertEquals("+3(423)332-31-12", employeeOrm.getPhone());
        assertEquals(new Date(116, 0, 8), employeeOrm.getHireDate());
        assertEquals(BigInteger.valueOf(1), employeeOrm.getSalary());
        assertEquals(0, employeeOrm.getManagerId());
        departmentOrm = employeeOrm.getDepartment();
        assertNotNull(departmentOrm);
        assertEquals(290, departmentOrm.getId());
        assertEquals("Sales", departmentOrm.getName());
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
        assertTrue(EqualsBuilder.reflectionEquals(referenceEmployeeOrmList, employeeOrmList));
    }
}