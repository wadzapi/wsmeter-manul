package org.wadzapi.employeeService.persist.dao;

import org.junit.Assert;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    /**
     * Эталонный список департаментов, загруженных из тестовой БД
     */
    private static List<TestEqualsDepartmentOrmWrapper> referenceDepartmentOrmList;

    /**
     * Тестовый экземпляр DAO для работы с сущностью "Департамент"
     */
    @Autowired
    private DepartmentJpaDao departmentJpaDao;

    @BeforeClass
    public static void setUpClass() {
        List<TestEqualsDepartmentOrmWrapper> initDepartmentOrmList = new ArrayList<>();
        DepartmentOrm.DepartmentOrmBuilder departmentOrmBuilder = new DepartmentOrm.DepartmentOrmBuilder();
        initDepartmentOrmList.add(new TestEqualsDepartmentOrmWrapper(departmentOrmBuilder.setId("d003").setName("Human Resources").build()));
        initDepartmentOrmList.add(new TestEqualsDepartmentOrmWrapper(departmentOrmBuilder.setId("d004").setName("Production").build()));
        referenceDepartmentOrmList = initDepartmentOrmList;
    }

    /**
     * Юнит-тест для метода {@link DepartmentJpaDao#findOne(Object)}
     *
     * @throws Exception ошибка теста
     */
    @Test
    public void testFindOne() throws Exception {
        //IT
        DepartmentOrm departmentOrm = departmentJpaDao.findOne("d004");
        assertNotNull(departmentOrm);
        assertEquals("d004", departmentOrm.getId());
        assertEquals("Production", departmentOrm.getName());
        //Sales
        departmentOrm = departmentJpaDao.findOne("d003");
        assertNotNull(departmentOrm);
        assertEquals("d003", departmentOrm.getId());
        assertEquals("Human Resources", departmentOrm.getName());
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
        List<TestEqualsDepartmentOrmWrapper> departmentOrmWrappers = new ArrayList<>(departmentOrmList.size());
        for (DepartmentOrm departmentOrm : departmentOrmList) {
            departmentOrmWrappers.add(new TestEqualsDepartmentOrmWrapper(departmentOrm));
        }
        Assert.assertEquals(referenceDepartmentOrmList, departmentOrmWrappers);
        //Assert.assertThat(departmentOrmWrappers, (Matcher) CoreMatchers.hasItems(referenceDepartmentOrmList));
    }

    /**
     * Обертка для сущности для реализации сравнения по всем полям класса, т.к.
     * assertTrue(EqualsBuilder.reflectionEquals(referenceDepartmentOrmList, departmentOrmList));
     * дает true, даже если поля не эквивалентны
     * TODO Подумать над реализацией кастомизированного Matcher'а Hamcrest или использовать EqualsBuilder
     */
    static class TestEqualsDepartmentOrmWrapper extends DepartmentOrm {

        /**
         * Обернутый экземпляр сущности Департамент
         */
        private final DepartmentOrm departmentOrm;

        /**
         * Список тестовых работников департамента
         */
        private List<EmployeeJpaDaoTest.TestEqualsEmployeeOrmWrapper> employeeOrmWrappers;

        /**
         * Конструктор класса
         *
         * @param departmentOrm обернутый экземпляр
         */
        TestEqualsDepartmentOrmWrapper(DepartmentOrm departmentOrm) {
            this.departmentOrm = Objects.requireNonNull(departmentOrm);
            List<EmployeeOrm> employeeOrms = departmentOrm.getEmployeeList();
            if (employeeOrms != null) {
                this.employeeOrmWrappers = new ArrayList<>(employeeOrms.size());
                for (EmployeeOrm employeeOrm : departmentOrm.getEmployeeList()) {
                    this.employeeOrmWrappers.add(new EmployeeJpaDaoTest.TestEqualsEmployeeOrmWrapper(employeeOrm));
                }
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TestEqualsDepartmentOrmWrapper that = (TestEqualsDepartmentOrmWrapper) o;
            return Objects.equals(departmentOrm.getId(), that.departmentOrm.getId()) &&
                    Objects.equals(departmentOrm.getName(), that.departmentOrm.getName());
            //Objects.equals(employeeOrmWrappers, that.employeeOrmWrappers);
        }
    }
}