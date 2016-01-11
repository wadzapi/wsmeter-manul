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

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Юнит-тест методов класса {@link EmployeeJpaDao}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@TransactionConfiguration
@Transactional
public class EmployeeJpaDaoTest {

    /**
     * Эталонный список работников,загружаемый из тестовой БД
     */
    private static List<TestEqualsEmployeeOrmWrapper> referenceEmployeeOrmList;
    /**
     * Тестовый экземпляр DAO для работы с сущностью "Работник"
     */
    @Autowired
    private EmployeeJpaDao employeeJpaDao;

    @BeforeClass
    @SuppressWarnings("deprecation")
    public static void setUpClass() {
        List<TestEqualsEmployeeOrmWrapper> initEmployeeOrmList = new ArrayList<>();
        EmployeeOrm.EmployeeOrmBuilder employeeOrmBuilder = new EmployeeOrm.EmployeeOrmBuilder();
        DepartmentOrm.DepartmentOrmBuilder departmentOrmBuilder = new DepartmentOrm.DepartmentOrmBuilder();
        initEmployeeOrmList.add(new TestEqualsEmployeeOrmWrapper(employeeOrmBuilder.setId(10120).setFirstName("Armond").setLastName("Fairtlough")
                .setGender("F").setBirthDate(new Date(60, 2, 26)).setHireDate(new Date(96, 6, 6)).setLeaveDate(null)
                .setDepartmentList(Collections.singletonList(departmentOrmBuilder.setId(290L).setName("Sales").build())).build()));
        initEmployeeOrmList.add(new TestEqualsEmployeeOrmWrapper(employeeOrmBuilder.setId(10123).setFirstName("Hinrich").setLastName("Randi")
                .setGender("M").setBirthDate(new Date(62, 4, 12)).setHireDate(new Date(93, 0, 15)).setLeaveDate(null)
                .setDepartmentList(Collections.singletonList(departmentOrmBuilder.setId(280L).setName("IT").build())).build()));
        initEmployeeOrmList.add(new TestEqualsEmployeeOrmWrapper(employeeOrmBuilder.setId(10124).setFirstName("Geraldo").setLastName("Marwedel")
                .setGender("M").setBirthDate(new Date(62, 4, 23)).setHireDate(new Date(91, 8, 2)).setLeaveDate(null)
                .setDepartmentList(Collections.singletonList(departmentOrmBuilder.setId(280L).setName("IT").build())).build()));
        initEmployeeOrmList.add(new TestEqualsEmployeeOrmWrapper(employeeOrmBuilder.setId(10130).setFirstName("Nishit").setLastName("Casperson")
                .setGender("M").setBirthDate(new Date(55, 3, 27)).setHireDate(new Date(88, 5, 21)).setLeaveDate(null)
                .setDepartmentList(Collections.singletonList(departmentOrmBuilder.setId(290L).setName("Sales").build())).build()));
        initEmployeeOrmList.add(new TestEqualsEmployeeOrmWrapper(employeeOrmBuilder.setId(10133).setFirstName("Giri").setLastName("Isaak")
                .setGender("M").setBirthDate(new Date(63, 11, 12)).setHireDate(new Date(85, 11, 15)).setLeaveDate(null)
                .setDepartmentList(Collections.singletonList(departmentOrmBuilder.setId(290L).setName("Sales").build())).build()));
        initEmployeeOrmList.add(new TestEqualsEmployeeOrmWrapper(employeeOrmBuilder.setId(10134).setFirstName("Diederik").setLastName("Siprelle")
                .setGender("M").setBirthDate(new Date(53, 3, 15)).setHireDate(new Date(87, 11, 12)).setLeaveDate(null)
                .setDepartmentList(Collections.singletonList(departmentOrmBuilder.setId(290L).setName("Sales").build())).build()));
        referenceEmployeeOrmList = initEmployeeOrmList;
    }

    /**
     * Юнит-тест для метода {@link EmployeeJpaDao#findOne(Object)}
     *
     * @throws Exception ошибка теста
     */
    @Test
    @SuppressWarnings("deprecation")
    public void testFindOne() throws Exception {
        //IT
        EmployeeOrm employeeOrm = employeeJpaDao.findOne(10133L);
        assertNotNull(employeeOrm);
        assertEquals("Giri", employeeOrm.getFirstName());
        assertEquals("Isaak", employeeOrm.getLastName());
        assertEquals("M", employeeOrm.getGender());
        assertEquals(new Date(63, 11, 12), employeeOrm.getBirthDate());
        assertEquals(null, employeeOrm.getLeaveDate());
        assertEquals(new Date(85, 11, 15), employeeOrm.getHireDate());
        /*List<DepartmentOrm> departmentOrmList = (List<DepartmentOrm>) employeeOrm.getDepartmentList();
        assertEquals(1, departmentOrmList.size());
        DepartmentOrm departmentOrm = departmentOrmList.get(0);
        assertNotNull(departmentOrm);
        assertEquals(280, departmentOrm.getId());
        assertEquals("IT", departmentOrm.getName());*/
        //Sales
        employeeOrm = employeeJpaDao.findOne(10123L);
        assertNotNull(employeeOrm);
        assertEquals("Hinrich", employeeOrm.getFirstName());
        assertEquals("Randi", employeeOrm.getLastName());
        assertEquals("M", employeeOrm.getGender());
        assertEquals(new Date(93, 0, 15), employeeOrm.getHireDate());
        assertEquals(null, employeeOrm.getLeaveDate());
        assertEquals(new Date(62, 4, 12), employeeOrm.getBirthDate());
        /*departmentOrmList = (List<DepartmentOrm>) employeeOrm.getDepartmentList();
        assertEquals(1, departmentOrmList.size());
        departmentOrm = departmentOrmList.get(0);
        assertNotNull(departmentOrm);
        assertEquals(290, departmentOrm.getId());
        assertEquals("Sales", departmentOrm.getName());*/
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
        assertEquals(6, employeeOrmList.size());
        List<TestEqualsEmployeeOrmWrapper> equalsEmployeeOrmWrappers = new ArrayList<>(employeeOrmList.size());
        for (EmployeeOrm employeeOrm : employeeOrmList) {
            equalsEmployeeOrmWrappers.add(new TestEqualsEmployeeOrmWrapper(employeeOrm));
        }
        Assert.assertEquals(referenceEmployeeOrmList, equalsEmployeeOrmWrappers);
        //Assert.assertThat(equalsEmployeeOrmWrappers, (Matcher) CoreMatchers.hasItems(referenceEmployeeOrmList));
    }


    /**
     * Обертка для сущности для реализации сравнения по всем полям класса, т.к.
     * assertTrue(EqualsBuilder.reflectionEquals(referenceEmployeeOrmList, employeeOrmList));
     * дает true, даже если поля не эквивалентны
     * TODO Подумать над реализацией кастомизированного Matcher'а Hamcrest или использовать EqualsBuilder
     */
    static class TestEqualsEmployeeOrmWrapper extends DepartmentOrm {

        /**
         * Обернутый экземпляр сущности Работник
         */
        private final EmployeeOrm employeeOrm;

        /**
         * Список тестовых департаментов
         */
        private List<DepartmentJpaDaoTest.TestEqualsDepartmentOrmWrapper> departmentOrmWrappers;

        /**
         * Конструктор класса
         *
         * @param employeeOrm обернутый экземпляр
         */
        TestEqualsEmployeeOrmWrapper(EmployeeOrm employeeOrm) {
            this.employeeOrm = Objects.requireNonNull(employeeOrm);
            List<DepartmentOrm> departmentOrmList = employeeOrm.getDepartmentList();
            if (departmentOrmList != null) {
                this.departmentOrmWrappers = new ArrayList<>(departmentOrmList.size());
                for (DepartmentOrm departmentOrm : departmentOrmList) {
                    this.departmentOrmWrappers.add(new DepartmentJpaDaoTest.TestEqualsDepartmentOrmWrapper(departmentOrm));
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
            TestEqualsEmployeeOrmWrapper that = (TestEqualsEmployeeOrmWrapper) o;
            return Objects.equals(employeeOrm.getId(), that.employeeOrm.getId()) &&
                    Objects.equals(employeeOrm.getBirthDate(), that.employeeOrm.getBirthDate()) &&
                    //Objects.equals(departmentOrmWrappers, that.departmentOrmWrappers) &&
                    Objects.equals(employeeOrm.getFirstName(), that.employeeOrm.getFirstName()) &&
                    Objects.equals(employeeOrm.getLastName(), that.employeeOrm.getLastName()) &&
                    Objects.equals(employeeOrm.getGender(), that.employeeOrm.getGender()) &&
                    Objects.equals(employeeOrm.getHireDate(), that.employeeOrm.getHireDate()) &&
                    Objects.equals(employeeOrm.getLeaveDate(), that.employeeOrm.getLeaveDate());
        }
    }
}